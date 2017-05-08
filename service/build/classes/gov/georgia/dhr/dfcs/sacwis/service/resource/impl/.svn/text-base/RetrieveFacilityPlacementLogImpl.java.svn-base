package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Clegstat;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cplmntyp;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveFacilityPlacementLog;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  8/18/2008  Joel Cochran        STGAP00009512: If a child has a legal status or legal outcome of "Adoption Finalized",
 *                                      this child's data will not be added to the return data for the Facility Placement Log.
 *   8/26/2008  Joel Cochran        STGAP00009512: Added new checks for the legal status & legal action for a child. Also,
 *                                      a Legal Action with a hearing type of 'Adoption Finalized' has been added to the search.
 *   8/28/2008  Joel Cochran        STGAP00009512: Now, the male/female counts are not incremented when a child with the aforementioned
 *                                      criteria is found.
 *   10/31/2008 mchilman            STGAP00010898 - added code to show new name if the adoption has been finalized
 *   
 *   11/17/2008 mchillman           STGAP00011206: added null pointer check
 *   05/18/2009 mxpatel             STGAP00012700: removed the code that prevented child from being displayed on the placement
 *                                  log when legal status of adoption finalized was present.
 *   10/14/2009 pcoogan             STGAP00015531: Updated service to bring in all placements for a list of resources or agencies passed, 
 *                                  as well as to display RBWO program and per diem information for CCI and CPA placements
 *   11/11/2009 pcoogan                       
 *   09/12/2011 charden             STGAP00017058 - wrote code to get characteristic groupings for children in hom
 */

public class RetrieveFacilityPlacementLogImpl extends BaseServiceImpl implements RetrieveFacilityPlacementLog {

  // offsets into the Object[] returned by the placementDAO lookup
  private static final int OFFSET_dtPlcmtStart = 0;

  private static final int OFFSET_dtPlcmtEnd = 1;

  private static final int OFFSET_cdPlcmtRemovalRsn = 2;

  private static final int OFFSET_idPerson = 3;

  private static final int OFFSET_nmPersonFull = 4;

  private static final int OFFSET_dtPersonBirth = 5;

  private static final int OFFSET_cdLegalStatStatus = 6;

  private static final int OFFSET_idCase = 7;

  private static final int OFFSET_cdPlcmtGender = 8;

  private static final int OFFSET_nbrAge = 9;

  private static final int OFFSET_cdPlcmtType = 10;

  private static final int OFFSET_cdLegalCnty = 11;

  private static final int OFFSET_cdPlcmtSibling = 12;
  
  private static final int OFFSET_idStage = 13;
  
  private static final int OFFSET_indStageSealed = 14;
  
  private static final int OFFSET_idRsrcFacil = 15;
  
  private static final int OFFSET_idRsrcAgency = 16;
  
  private static final int OFFSET_nmPlcmtFacil = 17; 
  
  private static final int OFFSET_cdTempType = 18;
  
  private static final int OFFSET_idPlcmtEvent = 19;

  private static final String ADOPTION_FINALIZED_HEARING_TYPE = CodesTables.CLHECOT_ADF;
  
  private static final String ADOPTION_FINALIZED_LGL_OUTCOME = CodesTables.CLEGLOUT_ADF;
  
  private static final String ADOPTION_FINALIZED_LGL_STATUS = CodesTables.CLEGSTAT_NAF;
  
  private static final String CPA_FACILITY_TYPE = CodesTables.CFACTYP4_CP;
  
  private static final String RESPITE_NIGHT_PLACEMENT = CodesTables.CTMPLTYP_REN;
  
  private static final String RESPITE_DAY_PLACEMENT = CodesTables.CTMPLTYP_RED;
  
  private static final String CONCURRENT_PLACEMENT = CodesTables.CTMPLTYP_COR;
  
  private static final String CPA_PLACEMENT_TYPE = CodesTables.CPLMNTYP_CFH;
  
  private static final String SYS_IND_SHINES = "S";
  
  private static final String SYS_IND_PORTAL = "P";
  
  private CapsResourceDAO capsResourceDAO = null;

  private LegalActionDAO legalActionDAO = null;
  
  private LegalStatusDAO legalStatusDAO = null;
  
  private PersonHistoryDAO personHistoryDAO = null;

  private PersonLocDAO personLocDAO = null;
  
  private PersonDAO personDAO = null;

  private PlacementDAO placementDAO = null;
  
  private FosterCareRateDAO fosterCareRateDAO = null;
  
  private ContractServiceDAO contractServiceDAO = null;
  
  private StageDAO stageDAO = null;
  
  private StageLinkDAO stageLinkDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private FosterHomeConvDAO fosterHomeConvDAO;
  
  private PaymentOfCareDAO paymentOfCareDAO = null;
  
  private CharacteristicsDAO characteristicsDAO = null;
  
  private static final String CCI = CodesTables.CPLMNTYP_CCI;
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setFosterHomeConvDAO(FosterHomeConvDAO fosterHomeConvDAO) {
      this.fosterHomeConvDAO = fosterHomeConvDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO CapsResourceDAO) {
    this.capsResourceDAO = CapsResourceDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }
  
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }
  
  public void setPersonHistoryDAO(PersonHistoryDAO personHistoryDAO) {
    this.personHistoryDAO = personHistoryDAO;
  }

  public void setPersonLocDAO(PersonLocDAO personLocDAO) {
    this.personLocDAO = personLocDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }
  
  public void setcontractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }
  
  public void setFosterCareRateDAO(FosterCareRateDAO fosterCareRateDAO) throws ServiceException {
    this.fosterCareRateDAO = fosterCareRateDAO;
  }

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public PlacementLogSO retrieveLog(CFAD31SI cfad31si) throws ServiceException {
    CFAD31SO cfad31so = new CFAD31SO();
    PlacementLogSO placementLogSO = new PlacementLogSO();
    ROWCFAD31SIG00 rowcfad31sig00 = new ROWCFAD31SIG00();
    // cses41d
    int idResource = findIdResource(cfad31si);
    String cdSortedBy = cfad31si.getBWcdCdSortBy();

    // cdyn17d
   
    List<Integer> idRrscFacilList = new ArrayList<Integer>();
    List<Integer> idRrscAgencyList = new ArrayList<Integer>();
    String indSystem = cfad31si.getIndSystem();
    // Parse the array and set the idRrscFacilList and idRrscAgencyList
    ROWCFAD31SIG00_ARRAY rowcfad31sig00Array = cfad31si.getROWCFAD31SIG00_ARRAY();
    Enumeration<ROWCFAD31SIG00> rscIdEnum = rowcfad31sig00Array.enumerateROWCFAD31SIG00();
    while (rscIdEnum.hasMoreElements()) {
      
      rowcfad31sig00 = (ROWCFAD31SIG00) rscIdEnum.nextElement();
      CapsResource caps = capsResourceDAO.findCapsResourceByIdResourceOnly(rowcfad31sig00.getUlIdResource());
      String facilType = caps.getCdRsrcFacilType() != null ? caps.getCdRsrcFacilType(): "";
      if (CPA_FACILITY_TYPE.equals(facilType)) {
        Integer rsrcAgencyList = rowcfad31sig00.getUlIdResource();
        idRrscAgencyList.add(rsrcAgencyList);
      }
      else {
        Integer rsrcFacilList = rowcfad31sig00.getUlIdResource();
        idRrscFacilList.add(rsrcFacilList);
      }
      
    }
    //If either are empty after enumeration, insert zero to avoid SQL error
    
    if (idRrscFacilList.isEmpty()) {
      idRrscFacilList.add(0);
    }
    if (idRrscAgencyList.isEmpty()) {
      idRrscAgencyList.add(0);
    }
    
    CFAD31SOG00_ARRAY cfad31SOG00_array = findPlacementInfo(idRrscFacilList, idRrscAgencyList, cdSortedBy, indSystem,
                                                            cfad31si.getArchInputStruct(), cfad31so, placementLogSO);

    // This is not an error, but we are done processing if nothing is found.
    if (cfad31SOG00_array == null) {
      placementLogSO.setCfad31so(cfad31so);
      return placementLogSO;
    }

    // Update the information retrieved above with nmPersonFull and cdPlogChild in this loop.
    for (Enumeration<CFAD31SOG00> cfad31sog00_enum = cfad31SOG00_array.enumerateCFAD31SOG00(); cfad31sog00_enum
                                                                                                               .hasMoreElements();) {
      CFAD31SOG00 cfad31sog00 = cfad31sog00_enum.nextElement();
      int idPerson = cfad31sog00.getUlIdPerson();
      int idStage = cfad31sog00.getUlIdStage();
      Date dtPlcmtStart = cfad31sog00.getDtDtPlcmtStart();
      // if the child ado is sealed do not change the name
      if (ArchitectureConstants.Y.equals(cfad31sog00.getCScrIndSealed()) == false) {
        String nmFull = personHistoryDAO.findPersonHistoryByIdPerson(idPerson, dtPlcmtStart);
        if (nmFull != null) {
          cfad31sog00.setSzNmPersonFull(nmFull);
        } else {
          // clss66d
          nmFull = personHistoryDAO.findPersonHistoryByIdPersonforPersonwithOldestHistEffect(idPerson);
          if (nmFull == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          cfad31sog00.setSzNmPersonFull(nmFull);
        }
      }

      Date dtPlcmtEnd = cfad31sog00.getDtDtPlcmtEnd();
      
      if (!DateHelper.isNull(dtPlcmtEnd)) {
        // If dtPlcmtEnd was null, use the max date instead.
        dtPlcmtEnd = DateHelper.MAX_JAVA_DATE;
      }
      
      String plcmtType = cfad31sog00.getCdPlcmtType();
      String tempType = cfad31sog00.getSzCdPlcmtTempType()!= null ? cfad31sog00.getSzCdPlcmtTempType() : "";
      
      String indTempType;
      
      Date currentDate = new Date();
      Date dtActualEnd;
      
      if (DateHelper.MAX_JAVA_DATE.equals(cfad31sog00.getDtDtPlcmtEnd())){
        dtActualEnd = currentDate;
      }else {
        dtActualEnd = cfad31sog00.getDtDtPlcmtEnd();
      }
      
      List<String> conplcmtTypes = new ArrayList<String>();
      conplcmtTypes.add(RESPITE_NIGHT_PLACEMENT);
      conplcmtTypes.add(RESPITE_DAY_PLACEMENT);
      conplcmtTypes.add(CONCURRENT_PLACEMENT);

      List<String> cciPlcmtTypes = new ArrayList<String>();
      cciPlcmtTypes.add(CodesTables.CPLCMTRU_IFH);
      cciPlcmtTypes.add(CodesTables.CPLCMTRU_EMS);
      cciPlcmtTypes.add(CodesTables.CPLCMTRU_GRH);
      cciPlcmtTypes.add(CodesTables.CPLCMTRU_CCI);
      cciPlcmtTypes.add(CodesTables.CPLCMTRU_SFH);
      cciPlcmtTypes.add(CodesTables.CPLCMTRU_ICF);
      
      if (conplcmtTypes.contains(tempType)) {
        indTempType = ArchitectureConstants.Y;
      } 
      else{        
        indTempType = ArchitectureConstants.N ;
      }
      
      if (cciPlcmtTypes.contains(plcmtType)) {
        cfad31sog00.setSzIndCci(ArchitectureConstants.Y);
      }
      else if (CPA_PLACEMENT_TYPE.equals(plcmtType)){
        cfad31sog00.setSzIndCci(ArchitectureConstants.N);  
      }
      if (cciPlcmtTypes.contains(plcmtType)||CPA_PLACEMENT_TYPE.equals(plcmtType)) {
        
        PaymentOfCare payOfCare = paymentOfCareDAO.findPaymentOfCareByIdPersonByIdStage(idPerson, idStage, dtActualEnd,cfad31sog00.getSzIndCci(),indTempType);
        
        if (payOfCare!= null){
          String rbwoProgram = (payOfCare.getCdRbwoProgram() != null ? payOfCare.getCdRbwoProgram() : "");
          cfad31sog00.setSzCdRbwoProg(rbwoProgram);
          cfad31sog00.setDWaiverRate(payOfCare.getAmtSpecFcRbwoWaiver()!= null ? payOfCare.getAmtSpecFcRbwoWaiver() : 0.00);
          
          if (!("".equals(rbwoProgram))) {
            
            int idContractResource;
            
            if (cfad31sog00.getUlIdRsrcAgency() > 0){
              idContractResource = cfad31sog00.getUlIdRsrcAgency();
            } else {
              idContractResource = cfad31sog00.getUlIdRsrcFacil();
            } 
            
            int ChildAge = DateHelper.getAge(DateHelper.toJavaDate(cfad31sog00.getDtDtPersonBirth()),dtActualEnd);
            
            cfad31sog00.setDPerDiem(calculatePerDiem(cfad31sog00.getSzIndCci(),idContractResource,dtActualEnd,ChildAge,rbwoProgram));
          }
        }
      }
    }

    cfad31so.setCFAD31SOG00_ARRAY(cfad31SOG00_array);
    //STGAP00017058
    placementLogSO.setCfad31so(cfad31so);
    return placementLogSO;
  }

  private CFAD31SOG00_ARRAY findPlacementInfo(List<Integer> idRrscFacilList,List<Integer>  idRrscAgencyList, String cdSortedBy, String indSystem, ArchInputStruct archInputStruct,
                                              CFAD31SO cfad31so, PlacementLogSO placementLogSO) throws ServiceException {

    CurrPlacementStats currPlacementStats = new CurrPlacementStats();
    PaginatedHibernateList<Object[]> placementInfoList = null;

    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

    // This if statement was part of cdyn17d.
    if(SYS_IND_SHINES.equals(indSystem)){
      if (SORT_O.equals(cdSortedBy)) {
        // cdyn17d
        placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndAndDtPlcmtStart(idRrscFacilList, idRrscAgencyList,
                                                                                                       pageNbr, pageSize);
       
      } else if (SORT_P.equals(cdSortedBy)) {
        // cdyn17d
        placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByDtPlcmtStart(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize);
      } else if (SORT_E.equals(cdSortedBy)) {
        // cdyn17d
        placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByDtPlcmtEnd(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize);
      } else if (SORT_C.equals(cdSortedBy)) {
        // cdyn17d
        placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByNmPersonFull(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize);
      } else if (SORT_R.equals(cdSortedBy)) {
        // cdyn17d
        placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByCdPlcmtRemovalRsn(idRrscFacilList, idRrscAgencyList, pageNbr,
                                                                                               pageSize);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }

      //We are moving this into the selection between SHINES and Portal due to the need
      //to count differently due to adopted children information 
      Long countFemalesInPlcmt = placementDAO.countFemalesPersonByIdRrscAgencyListByIdRsrcFacil(idRrscFacilList, idRrscAgencyList);
      int femalesInPlcmt = countFemalesInPlcmt.intValue();
      currPlacementStats.setNbrFemalesInHome(femalesInPlcmt);
      
      Long countMalesInPlcmt = placementDAO.countMalesPersonByIdRrscAgencyListByIdRsrcFacil(idRrscFacilList, idRrscAgencyList);
      int malesInPlcmt = countMalesInPlcmt.intValue();
      currPlacementStats.setNbrMalesInHome(malesInPlcmt);
      
      Long countChildrenUnder3 = placementDAO.countChildrenUnder3PersonByIdRrscAgencyListByIdRsrcFacil(idRrscFacilList, idRrscAgencyList);
      int childrenUnder3 = countChildrenUnder3.intValue();
      currPlacementStats.setNbrChldrnUnder3(childrenUnder3);
     
      Long countChildrenOver16 = placementDAO.countChildrenOver16PersonByIdRrscAgencyListByIdRsrcFacil(idRrscFacilList, idRrscAgencyList);
      int childrenOver16 = countChildrenOver16.intValue();
      currPlacementStats.setNbrChldrnOver16(childrenOver16);
      
      
      if (placementInfoList == null) {
        // This is not an error, but we are done if nothing is found.
        return null;
      }

    }else 
      if(SYS_IND_PORTAL.equals(indSystem)){
        if (SORT_O.equals(cdSortedBy)) {
          // cdyn17d
          placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndAndDtPlcmtStartPortal(idRrscFacilList, idRrscAgencyList,
                                                                                                         pageNbr, pageSize);
          
        } else if (SORT_P.equals(cdSortedBy)) {
          // cdyn17d
          placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByDtPlcmtStartPortal(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize);
        } else if (SORT_E.equals(cdSortedBy)) {
          // cdyn17d
          placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndPortal(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize);
        } else if (SORT_C.equals(cdSortedBy)) {
          // cdyn17d
          placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByNmPersonFullPortal(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize);
        } else if (SORT_R.equals(cdSortedBy)) {
          // cdyn17d
          placementInfoList = placementDAO.findPlacementByIdRsrcFacilAndOrderByCdPlcmtRemovalRsnPortal(idRrscFacilList, idRrscAgencyList, pageNbr,
                                                                                                 pageSize);
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
        
        //We are moving this into the selection between SHINES and Portal due to the need
        //to count differently due to adopted children information
        Long countFemalesInPlcmt = placementDAO.countFemalesPersonByIdRrscAgencyListByIdRsrcFacilPortal(idRrscFacilList, idRrscAgencyList);
        int femalesInPlcmt = countFemalesInPlcmt.intValue();
        currPlacementStats.setNbrFemalesInHome(femalesInPlcmt);
        
        Long countMalesInPlcmt = placementDAO.countMalesPersonByIdRrscAgencyListByIdRsrcFacilPortal(idRrscFacilList, idRrscAgencyList);
        int malesInPlcmt = countMalesInPlcmt.intValue();
        currPlacementStats.setNbrMalesInHome(malesInPlcmt);
        
        Long countChildrenUnder3 = placementDAO.countChildrenUnder3PersonByIdRrscAgencyListByIdRsrcFacilPortal(idRrscFacilList, idRrscAgencyList);
        int childrenUnder3 = countChildrenUnder3.intValue();
        currPlacementStats.setNbrChldrnUnder3(childrenUnder3);
       
        Long countChildrenOver16 = placementDAO.countChildrenOver16PersonByIdRrscAgencyListByIdRsrcFacilPortal(idRrscFacilList, idRrscAgencyList);
        int childrenOver16 = countChildrenOver16.intValue();
        currPlacementStats.setNbrChldrnOver16(childrenOver16);

        if (placementInfoList == null) {
          // This is not an error, but we are done if nothing is found.
          return null;
        }
      }
  
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(placementInfoList.getBMoreDataInd());
    cfad31so.setArchOutputStruct(archOutputStruct);
    
    CFAD31SOG00_ARRAY cfad31SOG00_array = new CFAD31SOG00_ARRAY();
    for (Iterator<Object[]> it = placementInfoList.iterator(); it.hasNext();) {
      Object[] objs = it.next();
      //if the stage is marked as sealed do not list the placement
      if (ArchitectureConstants.Y.equals((String) objs[OFFSET_indStageSealed]) == false) {
        CFAD31SOG00 cfad31SOG00 = new CFAD31SOG00();
        cfad31SOG00.setSzNmPersonFull((String) objs[OFFSET_nmPersonFull]);
        cfad31SOG00.setDtDtPersonBirth(DateHelper.toCastorDate((Date) objs[OFFSET_dtPersonBirth]));
        cfad31SOG00.setUlIdCase((Integer) objs[OFFSET_idCase] != null ? (Integer) objs[OFFSET_idCase] : 0);
        cfad31SOG00.setUlIdStage((Integer) objs[OFFSET_idStage] != null ? (Integer) objs[OFFSET_idStage] : 0);
        cfad31SOG00.setCdPlcmtType((String) objs[OFFSET_cdPlcmtType]);
        cfad31SOG00.setUlIdPlcmtEvent((Integer) objs[OFFSET_idPlcmtEvent] != null ? (Integer) objs[OFFSET_idPlcmtEvent] : 0);
  
        cfad31SOG00.setNbrPersonAge((Integer) DateHelper.getAge(cfad31SOG00.getDtDtPersonBirth()));
  
        cfad31SOG00.setDtDtPlcmtStart((Date) objs[OFFSET_dtPlcmtStart]);
        // cfad31SOG00.setDtDtPlcmtEnd(DateHelper.toCastorDate((Date) objs[OFFSET_dtPlcmtEnd]));
        cfad31SOG00.setDtDtPlcmtEnd((Date) objs[OFFSET_dtPlcmtEnd]);
        cfad31SOG00.setUlIdPerson((Integer) objs[OFFSET_idPerson] != null ? (Integer) objs[OFFSET_idPerson] : 0);
        cfad31SOG00.setSzCdPlcmtRemovalRsn((String) objs[OFFSET_cdPlcmtRemovalRsn]);
        cfad31SOG00.setCdLegalStatCnty((String) objs[OFFSET_cdLegalCnty]);
        cfad31SOG00.setSzSblngPlcmt((String) objs[OFFSET_cdPlcmtSibling]);
        cfad31SOG00.setNmPlcmtFacil((String) objs[OFFSET_nmPlcmtFacil]);
        cfad31SOG00.setSzCdPlcmtTempType((String) objs[OFFSET_cdTempType]);
        cfad31SOG00.setUlIdRsrcFacil((Integer) objs[OFFSET_idRsrcFacil] != null ? (Integer) objs[OFFSET_idRsrcFacil] : 0);
        cfad31SOG00.setUlIdRsrcAgency((Integer) objs[OFFSET_idRsrcAgency] != null ? (Integer) objs[OFFSET_idRsrcAgency] : 0);
        String gender = (String) objs[OFFSET_cdPlcmtGender];
            cfad31SOG00.setCdPersonSex(gender);
        
        // LGL_STAT_ADO_CNSM -- Legal Status Adoption Consummated = 090
        String cdLegalStatStatus = (String) objs[OFFSET_cdLegalStatStatus];
        if (CodesTables.CLEGSTAT_090.equals(cdLegalStatStatus) && DateHelper.isNull(cfad31SOG00.getDtDtPlcmtEnd())) {
          cfad31SOG00.setCScrIndAdptnCnsmmtd(ServiceConstants.FND_YES);
        } else {
          cfad31SOG00.setCScrIndAdptnCnsmmtd(ServiceConstants.FND_NO);
        }
        
        cfad31SOG00_array.addCFAD31SOG00(cfad31SOG00);
      }
    }
    
    //STGAP00017058 - setup characteristic groupings
    List<Integer> personList = new ArrayList<Integer>();
    List<String> groups = new ArrayList<String>();
    List<Placement> currPlacementList = new ArrayList<Placement>();
    Map<String, Map<String, Integer>> tempGroups = new HashMap<String, Map<String, Integer>>();
    Map<Integer, Integer> tempDelinquencyMap = new HashMap<Integer, Integer>();
    int delCount = 0;
         
    // get all current placements
    if((idRrscFacilList != null && !idRrscFacilList.isEmpty()) || (idRrscAgencyList != null && !idRrscAgencyList.isEmpty())){
      int idResourceFacilAgency = idRrscFacilList.get(0);
      if(idResourceFacilAgency == 0){
        idResourceFacilAgency = idRrscAgencyList.get(0);
      }
      currPlacementList = placementDAO.findCompAprvPlacementsByIdResource(new Date(), idResourceFacilAgency);
      personList = getPersonsFromList(currPlacementList);
      placementLogSO.setNumChildrenInHome(personList.size());
    }
  
    if(!personList.isEmpty()){
      // get placements and legal statuses of YDC type to track delinquent histories of children (only looking at current placements)
      List<Placement> placementList = placementDAO.findActivePlacementByIdPersonsDatePlcmntType(personList, new Date(), Cplmntyp.CPLMNTYP_YDC);
      List<LegalStatus> legalStatusList = legalStatusDAO.countLegalStatusByStatusDtLegalStatStatusIdPerson(personList, getLegalStatuses(), new Date());
    
      // count unique YDC legal statuses
      for(LegalStatus legalStatus : legalStatusList){
        int idPerson = legalStatus.getPerson().getIdPerson();
        if(!tempDelinquencyMap.containsKey(idPerson)){
          tempDelinquencyMap.put(idPerson, idPerson);
          delCount++;
        }
      }
      
      // count unique YDC placements
      for(Placement placement : placementList){
        int idPerson = placement.getPersonByIdPlcmtChild().getIdPerson();
        if(!tempDelinquencyMap.containsKey(idPerson)){
          tempDelinquencyMap.put(idPerson, idPerson);
          delCount++;
        }
      }
      
      // get characteristic groupings
      List<Map<String, String>> characteristicGroupList = characteristicsDAO.findCdCharacteristicsByIdPersons(personList);
      
      // organize characteristics by group and get count of each characteristic
      for(Map<String, String> characteristicMap : characteristicGroupList){
        String characteristicGroup = characteristicMap.get("characteristic_group");
        String characteristic = characteristicMap.get("characteristic");
        if(!tempGroups.containsKey(characteristicGroup)){
          groups.add(characteristicGroup);
          Map<String, Integer> tempMap = new HashMap<String, Integer>();
          tempMap.put(characteristic, 1);
          tempGroups.put(characteristicGroup, tempMap);
        }else{
          Map<String, Integer> chars = tempGroups.get(characteristicGroup);
          if(chars.containsKey(characteristic)){
            chars.put(characteristic, chars.get(characteristic) + 1);
          }else{
            chars.put(characteristic, 1);
          }
        }
      }
    }
    
    // set characteristic groupings and delinquent count into transport object
    placementLogSO.setNumChildrenDelinquent(delCount);
    placementLogSO.setCharacteristicGroupList(groups);
    placementLogSO.setCharacteristicsGroupMap(tempGroups);
 
    cfad31so.setCurrPlacementStats(currPlacementStats);
    return cfad31SOG00_array;
  }
  
  private List<Integer> getPersonsFromList(List<Placement> placementList){
    List<Integer> personList = new ArrayList<Integer>();
    // get all children currently placed in the home
    if(placementList != null){
      for(Placement placement : placementList){
        personList.add(placement.getPersonByIdPlcmtChild().getIdPerson());
      }
    }
    return personList;
  }
  // End STGAP00017058
  
  private List<String> getLegalStatuses(){
    List<String> legalStatusList = new ArrayList<String>();
    legalStatusList.add(Clegstat.CLEGSTAT_CTD);
    legalStatusList.add(Clegstat.CLEGSTAT_DJA);
    legalStatusList.add(Clegstat.CLEGSTAT_JCP);
    legalStatusList.add(Clegstat.CLEGSTAT_JCT);
    legalStatusList.add(Clegstat.CLEGSTAT_NDJ);
    
    return legalStatusList;
  }

  private int findIdResource(CFAD31SI cfad31si) throws ServiceException {
    int idResource = 0;
    int i = 0;
    ROWCFAD31SIG00_ARRAY rowcfad31sig00Array = cfad31si.getROWCFAD31SIG00_ARRAY();
    Enumeration<ROWCFAD31SIG00> rscIdEnum = rowcfad31sig00Array.enumerateROWCFAD31SIG00();
    while (rscIdEnum.hasMoreElements()) {
      ROWCFAD31SIG00 rowcfad31sig00 = new ROWCFAD31SIG00();
      rowcfad31sig00 = (ROWCFAD31SIG00) rscIdEnum.nextElement();
      idResource = rowcfad31sig00.getUlIdResource();
      if (idResource == 0) {
        int idRsrcFaHomeStage = cfad31si.getUlIdStage();
        // cses41d
        CapsResource caps = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idRsrcFaHomeStage);
        if (caps == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        idResource = caps.getIdResource();
      }
      i++;
    }

    return idResource;
  }
  
  private double calculatePerDiem(String indCci, int idContractResource,Date dtActualEnd,int childAge,String rbwoProgram) {
    
    // find base perdiem
    double baseRate = 0.00;


    if (ArchitectureConstants.Y.equals(indCci)) {

      String service = "60501"+rbwoProgram;
      
      baseRate = contractServiceDAO
                                   .findContractedRateByIdResourceByDateByService(idContractResource,dtActualEnd, service);
    } else if (ArchitectureConstants.N.equals(indCci)) {
           
      String ageRange = "";
      if (childAge <= 5) {
        ageRange = "005";
      } else if (childAge > 5 && childAge < 13) {
        ageRange = "612";
      } else if (childAge >= 13) {
        ageRange = "13P";
      }
      
      String service = "60901"+rbwoProgram;
      
      double contractedRate = contractServiceDAO
                                                .findContractedRateByIdResourceByDateByService(idContractResource,
                                                                                               dtActualEnd, service);
      
      double tableRate = fosterCareRateDAO.findFosterCareRateByAgeDateRangeAndService(ageRange, dtActualEnd , service)
                                          .getAmtFcareRtUnitRate();
      baseRate = tableRate + contractedRate;
    }
   
    return baseRate;    
  }
  
}
