package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.ValidatePlacementDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       -------------------------------------------------------------------
 *  12/17/08   charden        STGAP00010273: called new method findAprvPlacementsByCapsResourceByIdRsrcFacilByIdPlcmtChild()                                    
 *                            to get a correct count of home placements
 *  02/11/2009 mxpatel        STGAP00012392: Added custom validations for new placement type - "Other Adoptive Home"
 *  06/17/2009 hjbaptiste     STGAP00014257: When counting the number of placements for the home, do not increment the counter
 *                            if the child placed in the home has a Legal Status of Adoption Finalized 
 *  12/19/2010 schoi          SMS #81140: MR-074 Added comment for existing conditions where end-dated Group Home is included                           
 * </pre>                
 * 
 */

public class ValidatePlacementDetailImpl extends BaseServiceImpl implements ValidatePlacementDetail {

  /**
   * ****************************************************************************************************************** *
   * Service Macro Definitions
   * ******************************************************************************************************************
   */
  private static final String CPA = CodesTables.CRSCLINK_01;

  // Misc constants
  private static final String SUCCESS = ArchitectureConstants.Y;

  private static final String FAIL = ArchitectureConstants.N;

  private static final String INDICATOR_YES = ArchitectureConstants.Y;

  // New R2 Fields for Placement Type.
  public static final String TYPE_PARENT = CodesTables.CPLMNTYP_PRN;

  public static final String TYPE_RELATIVE_UNPAID = CodesTables.CPLMNTYP_REU;

  public static final String TYPE_RELATIVE_FOSTER_HOME = CodesTables.CPLMNTYP_RFH;

  public static final String TYPE_DFCS_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_DFH;

  public static final String TYPE_CPA_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_CFH;

  public static final String TYPE_CCI_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_IFH;

  public static final String TYPE_ADOPTIVE_HOME = CodesTables.CPLMNTYP_ADH;

  public static final String TYPE_EMERGENCY_SHELTER = CodesTables.CPLMNTYP_EMS;

  public static final String TYPE_GROUP_HOME = CodesTables.CPLMNTYP_GRH;

  public static final String TYPE_CHILD_CARE_INSTITUTION = CodesTables.CPLMNTYP_CCI;

  public static final String TYPE_SPECIALIZED_FOSTER_HOME = CodesTables.CPLMNTYP_SFH;

  public static final String TYPE_ILP_AFTERCARE = CodesTables.CPLMNTYP_LAF;

  public static final String TYPE_ICPC_FOSTER = CodesTables.CPLMNTYP_ICF;

  public static final String TYPE_ICPC_ADOPTIVE = CodesTables.CPLMNTYP_ICA;

  public static final String TYPE_ICPC_RELATIVE = CodesTables.CPLMNTYP_ICR;

  public static final String TYPE_HOSPITAL = CodesTables.CPLMNTYP_HOS;

  public static final String TYPE_RUNAWAY = CodesTables.CPLMNTYP_RNA;

  public static final String TYPE_YDC = CodesTables.CPLMNTYP_YDC;
  
  public static final String TYPE_OTHER_ADOPTIVE_HOME = CodesTables.CPLMNTYP_OTA;//mxpatel 12392
  
  public static final String TYPE_OTHER_RESOURCE = CodesTables.CPLMNTYP_OTR;

  public static final String TYPE_OTHER_PERSON = CodesTables.CPLMNTYP_OTP;

  public static final String POC_Assessment = CodesTables.CPOCTYPE_A3;

  public static final String POC_Level1 = CodesTables.CPOCTYPE_L1;

  public static final String POC_Level2 = CodesTables.CPOCTYPE_L2;

  public static final String POC_Level3 = CodesTables.CPOCTYPE_L3;

  public static final String POC_Level4 = CodesTables.CPOCTYPE_L4;

  public static final String POC_Level5 = CodesTables.CPOCTYPE_L5;

  public static final String POC_Level6 = CodesTables.CPOCTYPE_L6;

  public static final String POC_Regular_Foster_Care_PerDiem = CodesTables.CPOCTYPE_RFD;

  public static final String POC_Special_Foster_Care_PerDiem = CodesTables.CPOCTYPE_EFD;

  public static final String POC_Specialized_Foster_Care_PerDiem = CodesTables.CPOCTYPE_SFD;

  public static final String POC_LOC = CodesTables.CPOCTYPE_LOC;

  public static final String POC_RBWO_with_Waiver = CodesTables.CPOCTYPE_RWW;

  public static final String POC_Enhanced_Relative_Rate = CodesTables.CPOCTYPE_ERR;

  public static final String POC_Relative_Care_Subsidy = CodesTables.CPOCTYPE_RCS;

  public static final String POC_Enhanced_Relative_Care_Subsidy = CodesTables.CPOCTYPE_ERS;

  public static final String POC_Subsidized_Guardianship = CodesTables.CPOCTYPE_SUG;

  public static final String POC_Enhanced_Subsidized_Guardianship = CodesTables.CPOCTYPE_ESG;

  public static final String POC_Non_Relative_Subsidized_Guardianship = CodesTables.CPOCTYPE_NSG;

  public static final String POC_Non_Relative_Enhanced_Guardianship = CodesTables.CPOCTYPE_NEG;

  private CapsResourceDAO capsResourceDAO = null;

  private PersonDAO personDAO = null;

  private ResourceHistoryDAO resourceHistoryDAO = null;

  private RsrcLinkDAO rsrcLinkDAO = null;

  private PlacementDAO placementDAO = null;
  
  private LegalStatusDAO legalStatusDAO = null;

  private EventDAO eventDAO = null;
  
  private StageDAO stageDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) throws ServiceException {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) throws ServiceException {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) throws ServiceException {
    this.personDAO = personDAO;
  }

  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) throws ServiceException {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) throws ServiceException {
    this.placementDAO = placementDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  
  public CSUB31SO validatePlacementDetail(CSUB31SI csub31si) throws ServiceException {

    CSUB31SO csub31so = new CSUB31SO();
    int iAge = 0;
    String find = FAIL;
    Date dtTempYearBorn = null;
    Date dtPlcmtStartSI = csub31si.getDtDtPlcmtStart();
    int idPlcmtChildSI = csub31si.getUlIdPlcmtChild();
    int idResourceSI = csub31si.getUlIdResource();
    int idCurrPlcmtEvent = csub31si.getUlIdPlcmtEvent();
    String cdPlcmtTypeSI = csub31si.getSzCdPlcmtType();
    boolean type_foster_adoptive = false;
    boolean type_contracted_institutional = false;
    boolean type_nonpaid_facility = false;
    boolean type_select_person = false;
    boolean type_paid_resources = false;
    int idWaiver = csub31si.getUlIdWaiver();
    /* retrieve child's DOB */
    // ccmn44d
    Person personChild = personDAO.findPersonByIdPerson(idPlcmtChildSI);
    if (personChild == null || personChild.equals(null)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    if (personChild != null) {
      dtTempYearBorn = personChild.getDtPersonBirth();
      /* Get child's age as of start date */
      iAge = DateHelper.getAge(dtTempYearBorn, dtPlcmtStartSI);
    }
    if (DateHelper.isNull(dtTempYearBorn)) {
      csub31so.setBSysIndNoDOBFound(INDICATOR_YES);
    }
    // SMS #81140: MR-074
    // Group Home (TYPE_GROUP_HOME condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
    // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
    // However, it is no harm to keep Group Home in the code below because it will not break the logic.
    // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.  
    if (TYPE_GROUP_HOME.equals(cdPlcmtTypeSI) || TYPE_CHILD_CARE_INSTITUTION.equals(cdPlcmtTypeSI)) {
      if (iAge < 12 && idWaiver == 0) {
        csub31so.setCSysIndChildUnder12(INDICATOR_YES);
      }
    }
    if ((TYPE_DFCS_FAMILY_FOSTER_HOME).equals(cdPlcmtTypeSI) || (TYPE_RELATIVE_FOSTER_HOME).equals(cdPlcmtTypeSI)
        || (TYPE_ICPC_FOSTER).equals(cdPlcmtTypeSI)) {
      type_foster_adoptive = true;

    }
    // SMS #81140: MR-074
    // Group Home (TYPE_GROUP_HOME condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
    // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
    // However, it is no harm to keep Group Home in the code below because it will not break the logic.
    // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.  
    if ((TYPE_CPA_FAMILY_FOSTER_HOME).equals(cdPlcmtTypeSI) || (TYPE_CCI_FAMILY_FOSTER_HOME).equals(cdPlcmtTypeSI)
        || (TYPE_EMERGENCY_SHELTER).equals(cdPlcmtTypeSI) || (TYPE_GROUP_HOME).equals(cdPlcmtTypeSI)
        || (TYPE_CHILD_CARE_INSTITUTION).equals(cdPlcmtTypeSI) || (TYPE_SPECIALIZED_FOSTER_HOME).equals(cdPlcmtTypeSI)) {
      type_contracted_institutional = true;

    }
    if ((TYPE_HOSPITAL).equals(cdPlcmtTypeSI) || (TYPE_YDC).equals(cdPlcmtTypeSI)
        || (TYPE_OTHER_RESOURCE).equals(cdPlcmtTypeSI) ||(TYPE_OTHER_ADOPTIVE_HOME).equals(cdPlcmtTypeSI)) {//mxpatel 12392
      type_nonpaid_facility = true;

    }
    if ((TYPE_PARENT).equals(cdPlcmtTypeSI) || (TYPE_ICPC_RELATIVE).equals(cdPlcmtTypeSI)
        || (TYPE_ILP_AFTERCARE).equals(cdPlcmtTypeSI) || (TYPE_OTHER_PERSON).equals(cdPlcmtTypeSI)
        || (TYPE_RUNAWAY).equals(cdPlcmtTypeSI) || (TYPE_RELATIVE_UNPAID).equals(cdPlcmtTypeSI)) {
      type_select_person = true;
    }
    if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_REP.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_NRP.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_RFH.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_DFH.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_CFH.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_IFH.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_EMS.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_GRH.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_CCI.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_SFH.equals(cdPlcmtTypeSI)) {
      type_paid_resources = true;
    }
    // cres04d
    // Fixing defect STGAP00002862 Begin
    // Since the resource id will not be there for the cases where the select person is displayed instead of
    // select resource it was displaying the SQL not found error. So a check is added to avoid those scenarios
    if (!type_select_person && (!(type_nonpaid_facility && idResourceSI == 0))) {
      CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResourceSI);
      if (capsResource == null || capsResource.equals(null)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      } else {
        // STGAP00007833: Moved this validation from save service to here to address the defect
        // STGAP00005989: If the resource type selected is anything other than Home/Other Facility or MHMR
        // Family Facility then display this message
        if (type_paid_resources && !CodesTables.CRSCTYPE_05.equals(capsResource.getCdRsrcType())
            && !CodesTables.CRSCTYPE_06.equals(capsResource.getCdRsrcType())) {
          throw new ServiceException(Messages.MSG_PLCMT_RSRC_TYP_INVALID);
        }
      }
      csub31so.setSzCdRsrcCategory(capsResource.getCdRsrcCategory());
      csub31so.setCIndRsrcEmergPlace(capsResource.getIndRsrcEmergPlace());
    }
    // Defect STGAP00002862 End
    if (type_contracted_institutional || (type_nonpaid_facility && idResourceSI != 0) || type_foster_adoptive
        || (TYPE_ADOPTIVE_HOME).equals(cdPlcmtTypeSI) || (TYPE_ICPC_ADOPTIVE).equals(cdPlcmtTypeSI)) {
      find = SUCCESS;
    } else {
      find = FAIL;
    }
    int idRsrcAgencySO = 0;

    if (SUCCESS.equals(find)) {
      /*
       * * If the placement type is Contracted and the * szCdRsrcLinkType is Child Placing Agency (CPA) * do a full row
       * retrieval from the * CAPS_RESOURCE table to obtain the Agency Name. * 3/12/96: The Placing Agency needs to be *
       * returned for JUV_PROB and TYC. * SIR 14938: Added PACE to the above scenario.
       */
      String resourceLinkType = CPA;
      int idResourceLinkChild = idResourceSI;
      // csec24d
      RsrcLink capsResourceLink = rsrcLinkDAO.findCapsResourceAndRsrcLink(idResourceLinkChild, resourceLinkType);
      if (capsResourceLink != null && (capsResourceLink.getCapsResourceByIdRsrcLinkParent() != null)) {
        Integer idLinkParent = capsResourceLink.getCapsResourceByIdRsrcLinkParent().getIdResource();
        idRsrcAgencySO = idLinkParent == null ? 0 : idLinkParent;
        csub31so.setUlIdRsrcAgency(idRsrcAgencySO);
      }
      // cres04d
      CapsResource capsResource2 = new CapsResource();

      if (0 != idRsrcAgencySO) {
        // cres04d
        capsResource2 = capsResourceDAO.findCapsResourceByIdResourceOnly(idRsrcAgencySO);
        if (capsResource2 != null) {
          csub31so.setSzNmPlcmtAgency(capsResource2.getNmResource());
        }
      } else {
        // cres04d
        capsResource2 = capsResourceDAO.findCapsResourceByIdResourceOnly(idResourceSI);
      }
      if (capsResource2 == null) {
        find = FAIL;
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      csub31so.setCCdRsrcFaHomeType1(capsResource2.getCdRsrcFaHomeType1());
      csub31so.setCCdRsrcFaHomeType2(capsResource2.getCdRsrcFaHomeType2());
      csub31so.setCCdRsrcFaHomeType3(capsResource2.getCdRsrcFaHomeType3());
      csub31so.setCCdRsrcFaHomeType4(capsResource2.getCdRsrcFaHomeType4());

      csub31so.setCCdRsrcFaHomeType5(capsResource2.getCdRsrcFaHomeType5());

      csub31so.setCCdRsrcFaHomeType6(capsResource2.getCdRsrcFaHomeType6());

      csub31so.setCCdRsrcFaHomeType7(capsResource2.getCdRsrcFaHomeType7());
      csub31so.setSzCdRsrcOwnership(capsResource2.getCdRsrcOwnership());
    }
    if (type_foster_adoptive || (TYPE_ADOPTIVE_HOME).equals(cdPlcmtTypeSI) || (TYPE_ICPC_ADOPTIVE).equals(cdPlcmtTypeSI)) {
      ResourceHistory resourceHistory;
      if (0 != idRsrcAgencySO) {
        // cres54d
        resourceHistory = resourceHistoryDAO.findResourceHistoryByIdResourceDtDtPlcmtStart(idRsrcAgencySO,
                                                                                           dtPlcmtStartSI);
      } else {
        resourceHistory = resourceHistoryDAO
                                            .findResourceHistoryByIdResourceDtDtPlcmtStart(idResourceSI, dtPlcmtStartSI);
      }
      if (resourceHistory == null) {
        csub31so.setBSysIndHomeHist(INDICATOR_YES);
      } else {
        csub31so.setCCdRsrcFaHomeType1(resourceHistory.getCdRshsFaHomeType1());
        csub31so.setCCdRsrcFaHomeType2(resourceHistory.getCdRshsFaHomeType2());
        csub31so.setCCdRsrcFaHomeType3(resourceHistory.getCdRshsFaHomeType3());
        csub31so.setCCdRsrcFaHomeType4(resourceHistory.getCdRshsFaHomeType4());
        csub31so.setCCdRsrcFaHomeType5(resourceHistory.getCdRshsFaHomeType5());
        csub31so.setCCdRsrcFaHomeType6(resourceHistory.getCdRshsFaHomeType6());
        csub31so.setCCdRsrcFaHomeType7(resourceHistory.getCdRshsFaHomeType7());
        csub31so.setSzCdRsrcOwnership(resourceHistory.getCdRshsOwnership());
      }
    }
    // STGAP00005989: Commented out the POC validations as these are done in contract validation code
    // in save palcement service.
    // Check to see if the placement exceeds licensed capacity of placment facility.
    if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_ICA.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_REP.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_NRP.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_RFH.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_DFH.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_CFH.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_IFH.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_EMS.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_GRH.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_CCI.equals(cdPlcmtTypeSI) || CodesTables.CPLMNTYP_SFH.equals(cdPlcmtTypeSI)
        || CodesTables.CPLMNTYP_ICF.equals(cdPlcmtTypeSI)) {
      int curRsCapacity = 0;
      int maxRsCapacity = 0;
      int childUnder2Counter = 0;
      int childUnder3Counter = 0;
      boolean indDfcs = false;
      CapsResource cResource = (CapsResource) capsResourceDAO.findCapsResourceByIdResourceOnly(idResourceSI);
      if (cResource != null) {
        if (cResource.getNbrRsrcFacilCapacity() != null) {
          maxRsCapacity = cResource.getNbrRsrcFacilCapacity();
        }
        if (CodesTables.CFACTYP4_70.equals(cResource.getCdRsrcFacilType())
            || CodesTables.CFACTYP4_71.equals(cResource.getCdRsrcFacilType())) {
          indDfcs = true;
        }
        String status = CodesTables.CEVTSTAT_APRV;
        //STGAP00010273 - calling new method to get correct placement count
        List<Map> placements = placementDAO.findAprvPlacementsByCapsResourceByIdRsrcFacilByIdPlcmtChild(new Date(), idResourceSI,
                                                                                          status, idPlcmtChildSI);
        int placementCount = 0;
        if (placements != null && !placements.isEmpty()) {
          for (Iterator<Map> it = placements.iterator(); it.hasNext();) {
            Map placement = it.next();
            placementCount++;
            int plcmtChildId = (Integer) placement.get("personByIdPlcmtChild") == null ? 0
                                                                                      : (Integer) placement
                                                                                                           .get("personByIdPlcmtChild");
            int idPlcmtEvent = (Integer) placement.get("idPlcmtEvent") == null ? 0
                                                                              : (Integer) placement.get("idPlcmtEvent");
            String cdPlcmtType = (String) placement.get("cdPlcmtType") == null ? ""
                                                                              : (String) placement.get("cdPlcmtType");
            // STGAP00008761: Added check to eliminate current placement from the list.
            // This will enable the user with rights to modify approved placements
            // to change the start date
            if (idCurrPlcmtEvent != 0 && idCurrPlcmtEvent != idPlcmtEvent) {
              int plcmtChildAge = -1;
              Date dtYearBorn = null;
              Person child = personDAO.findPersonByIdPerson(plcmtChildId);
              if (child != null) {
                dtYearBorn = child.getDtPersonBirth();
                /* Get child's age as of start date */
                plcmtChildAge = DateHelper.getAge(dtYearBorn, dtPlcmtStartSI);
              }
              if (CodesTables.CPLMNTYP_ADH.equals(placement.get("cdPlcmtType"))) {
                Event placementEvent = eventDAO.findEventByIdEvent(idPlcmtEvent);
                String cdStage = stageDAO.findCdStageByIdStage(placementEvent.getStage().getIdStage());
                if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
                  // Is child's Legal Status Finalized
                  LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(plcmtChildId, CodesTables.CLEGSTAT_NAF);
                  // If the Adoption Finalized legal status record was not found,
                  // then the placement should count.  Do increment the Counter
                  if (legalStatus == null) {
                    curRsCapacity++;
                  }
                }
              } else {
                // This placement is not an Adoptive Placement
                // then the placement should count.  Do increment the Counter
                curRsCapacity++;
              }
              if (indDfcs && !CodesTables.CPLMNTYP_REP.equals(cdPlcmtType)
                  && !CodesTables.CPLMNTYP_RFH.equals(cdPlcmtType)) {
                if (plcmtChildAge >= 0 && plcmtChildAge < 2) {
                  childUnder2Counter++;
                }
                //removed else if so that children under 2 will increment childUnder3Counter as well
                if (plcmtChildAge >= 0 && plcmtChildAge < 3) {
                  childUnder3Counter++;
                }
              }
            }
          }
        }
        if (maxRsCapacity <= curRsCapacity && idWaiver == 0) {
          csub31so.setCSysIndRsCapacity(INDICATOR_YES);
        }
        // STGAP00008125 Checking to make sure the child being placed is under 2 if he is the 3rd child or under 3 if
        // he is  4th child
        if ((placementCount == 2 && iAge < 2) || (placementCount > 2 && iAge < 3)) {
          if ((childUnder2Counter >= 2) || (childUnder3Counter >= 3) && idWaiver == 0) {
            csub31so.setCSysIndChildUnder2or3(INDICATOR_YES);
          }
        }
      }
    }
    return csub31so;
  }

}
