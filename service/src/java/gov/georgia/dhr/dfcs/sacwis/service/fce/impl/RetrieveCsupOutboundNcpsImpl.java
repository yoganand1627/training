/**
 * Created on May 14, 2007 at 4:00:24 PM by Kapil Aggarwal - SACWIS Atlanta
 * 
 * Change History:
 * Date         User              Description
 * --------    ----------------  -------------------------------------------------
 * 10/15/2009   arege             SMS37183 STGAP00011362 Truncated county name if too long, to resolve System Error on saving 
 *                                Eligibility Summary.
 */
package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.db.MailCode;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import gov.georgia.dhr.dfcs.sacwis.db.OfficePhone;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveCsupOutboundNcps;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveAgencyCustodialParents;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.CalculatePerDiem;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonIdentifiers;
import gov.georgia.dhr.dfcs.sacwis.service.person.impl.CalculatePerDiemImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.CrsRegistration;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgencyCustodialParentsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsRegistrationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonIdInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveCsupOutboundNcpsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgencyCustodialParentsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsRegistrationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveCsupOutboundNcpsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class RetrieveCsupOutboundNcpsImpl extends BaseServiceImpl implements RetrieveCsupOutboundNcps {

  private PersonDAO personDAO;

  private IncomeAndResourcesDAO incomeAndResourcesDAO;

  private PersonDtlDAO personDtlDAO;

  private FceApplicationDAO fceApplicationDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private OfficeDAO officeDAO;

  private PersonAddressDAO personAddressDAO;

  private PersonPhoneDAO personPhoneDAO;
  
  private EmployeeDAO employeeDAO;

  private CrsRegistration crsRegistration;

  private RetrievePersonIdentifiers retrievePersonIdentifiers;

  private SaveAgencyCustodialParents saveAgencyCustodialParents;

  private StageDAO stageDAO;
  
  private CalculatePerDiem calculatePerDiem;



  /**
   * @param personDAO the personDAO to set
   */
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  /**
   * @param incomeAndResourcesDAO the incomeAndResourcesDAO to set
   */
  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  /**
   * @param fceApplicationDAO the fceApplicationDAO to set
   */
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }


  /**
   * @param officeDAO the officeDAO to set
   */
  public void setOfficeDAO(OfficeDAO officeDAO) {
    this.officeDAO = officeDAO;
  }

  /**
   * @param personAddressDAO the personAddressDAO to set
   */
  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  /**
   * @param personDtlDAO the personDtlDAO to set
   */
  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  /**
   * @param personPhoneDAO the personPhoneDAO to set
   */
  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  /**
   * @param stagePersonLinkDAO the stagePersonLinkDAO to set
   */
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  /**
   * @param stageDAO the stageDAO to set
   */
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  /**
   * @param crsRegistration the crsRegistration to set
   */
  public void setCrsRegistration(CrsRegistration crsRegistration) {
    this.crsRegistration = crsRegistration;
  }

  /**
   * @param employeeDAO the employeeDAO to set
   */
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  /**
   * @param retrievePersonIdentifiers the retrievePersonIdentifiers to set
   */
  public void setRetrievePersonIdentifiers(RetrievePersonIdentifiers retrievePersonIdentifiers) {
    this.retrievePersonIdentifiers = retrievePersonIdentifiers;
  }

  /**
   * @param saveAgencyCustodialParents the saveAgencyCustodialParents to set
   */
  public void setSaveAgencyCustodialParents(SaveAgencyCustodialParents saveAgencyCustodialParents) {
    this.saveAgencyCustodialParents = saveAgencyCustodialParents;
  }
  
  public void setCalculatePerDiem(CalculatePerDiem calculatePerDiem) {
    this.calculatePerDiem = calculatePerDiem;
  }
    
 


  /*
   * (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveCsupOutboundNcps#retrieveCsupOutboundNcps(gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB,
   *      gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveCsupOutboundNcpsSI)
   */
  public RetrieveCsupOutboundNcpsSO retrieveCsupOutboundNcps(EligibilitySummaryDB eligibilitySummaryDB,
                                                             RetrieveCsupOutboundNcpsSI retrieveCsupOutboundNcpsSI) {
    
    
    Long idStage = null;
    String dfcsCounty = null;
    Double nbrPerDiem = null;
    Double nbrPerMonth = null;
    Date dtEffPerDiem = null;
    Iterator ncpIter = null;
    boolean crsError = false;
    
    // The output object
    RetrieveCsupOutboundNcpsSO envelopeRetrieveCsupOutboundNcpsSO = new RetrieveCsupOutboundNcpsSO();
    RetrieveCsupOutboundNcpsSO retrieveCsupOutboundNcpsSO = null;
    List<CSupRefOutboundSI> refOutboundSI = new ArrayList<CSupRefOutboundSI>();
    
    //RetrieveCsupOutboundNcpsSO retrieveCsupOutboundNcpsSO = new RetrieveCsupOutboundNcpsSO();
    
    idStage = eligibilitySummaryDB.getIdStage();
    dfcsCounty = getDFCSCounty(idStage.intValue());
    
    if(null != idStage)
    {
      List<StagePersonLink> ncps = getNcpsForChild(idStage);
      if(null != ncps)
        ncpIter = ncps.iterator();
    }

    while (ncpIter.hasNext()) {

      StagePersonLink splRow = (StagePersonLink) ncpIter.next();
      Person ncp = splRow.getPerson();
      int ncpPersonId = ncp.getIdPerson();

      retrieveCsupOutboundNcpsSO = new RetrieveCsupOutboundNcpsSO();
      try {  // TODO Verify why try catch is in the loop
        // Child
        Integer childPersonId = getChildIdPerson(idStage.intValue());
        if(null != childPersonId)
        {
          retrieveCsupOutboundNcpsSO.setIdChild(childPersonId.intValue());
          // Add Per Diem related info
          HashMap pdmInfo = null;
          try {  
              pdmInfo = calculatePerDiem.callCalculatePerDiem(childPersonId.toString());
          } catch(Exception e) {
                envelopeRetrieveCsupOutboundNcpsSO.setError("CRS Referral not sent as no Per-Diem information exists.");
                envelopeRetrieveCsupOutboundNcpsSO.addExceptionMsg(e.getMessage());
                retrieveCsupOutboundNcpsSO.setError("CRS Referral not sent as no Per-Diem information exists.");
                retrieveCsupOutboundNcpsSO.addExceptionMsg(e.getMessage());
                break;
          }
          
          if(null != pdmInfo)
          {
            nbrPerDiem = (Double) pdmInfo.get(InterfaceServiceConstants.PER_DIEM);
            nbrPerMonth = (Double) pdmInfo.get(InterfaceServiceConstants.PER_MONTH);
            dtEffPerDiem = (Date) pdmInfo.get(InterfaceServiceConstants.DT_EFF_PER_DIEM);
          }
        }
       
        retrieveCsupOutboundNcpsSO.setNbrPerDiem(nbrPerDiem);
        retrieveCsupOutboundNcpsSO.setNbrPerMonth(nbrPerMonth);
        retrieveCsupOutboundNcpsSO.setDtEffPerDiem(dtEffPerDiem);
        
        crsError = (nbrPerDiem==null);
        
        // If there is no Per Diem for the child then there is no CSup Referral so no need
        // to go any further.
        if(crsError){
          envelopeRetrieveCsupOutboundNcpsSO.setError("CRS Referral not sent as no Per Diem information exists.");
          retrieveCsupOutboundNcpsSO.setError("CRS Referral not sent as no Per Diem information exists.");
          break;
        }

        // Child CRS Id
        Integer childCrsId = getCrsId(retrieveCsupOutboundNcpsSI.getShinesLogonID(), childPersonId);
        if(childCrsId>0) retrieveCsupOutboundNcpsSO.setNbrChildCrsId(childCrsId);
        else {
          envelopeRetrieveCsupOutboundNcpsSO.setError("CRS ID does not exist for the Primary Child.");
          retrieveCsupOutboundNcpsSO.setError("CRS ID does not exist for the Primary Child.");
          crsError = true;
        }

        // Ncp Crs Id
        Integer ncpCrsId = getCrsId(retrieveCsupOutboundNcpsSI.getShinesLogonID(), ncpPersonId);
        if(ncpCrsId>0) retrieveCsupOutboundNcpsSO.setNbrNoncustCrsId(ncpCrsId);
        else {
          envelopeRetrieveCsupOutboundNcpsSO.setError("CRS ID does not exist for Parent  with Person Id " + ncpPersonId + ".");
          retrieveCsupOutboundNcpsSO.setError("CRS ID does not exist for Parent  with Person Id " + ncpPersonId + ".");
          crsError = true;
        }

        // If any of the above does not have CRS ID then one common message
        if(crsError) 
        { 
          envelopeRetrieveCsupOutboundNcpsSO.setError("Please proceed to Person Identifiers Page and add CRS ID.");
          retrieveCsupOutboundNcpsSO.setError("Please proceed to Person Identifiers Page and add CRS ID.");
        }
        // ACP
        if(childCrsId > 0 && ncpCrsId > 0){         // Can't go any further if Child and NCP Crs Ids are not available
          AgencyCustodialParentsSI agencyCustodialParentsSI = new AgencyCustodialParentsSI();
          agencyCustodialParentsSI.setNbrNcpCrsId(ncpCrsId);

          
          String dfcsCountyName = Lookup.simpleDecodeSafe(InterfaceServiceConstants.CODE_CATEGORY_CCOUNT, dfcsCounty);
          //STGAP00011362 Value too large for column
          if (dfcsCountyName.length() > 12) {
            dfcsCountyName = dfcsCountyName.substring(0, 12);
          }
          agencyCustodialParentsSI.setNmPersonFirst(dfcsCounty);
          agencyCustodialParentsSI.setNmPersonFirst(dfcsCountyName);
          agencyCustodialParentsSI.setNmPersonLast(InterfaceServiceConstants.CDCSUPREF_DFCS);
          agencyCustodialParentsSI.setNmPersonMiddle(StringHelper.EMPTY_STRING);
          agencyCustodialParentsSI.setCdPersonSex(InterfaceServiceConstants.CDCSUPREF_GENDER);
          agencyCustodialParentsSI.setCdEthnicity(InterfaceServiceConstants.CDCSUPREF_ETHNICITY);
          agencyCustodialParentsSI.setCdRace(InterfaceServiceConstants.CDCSUPREF_AFAM);
          agencyCustodialParentsSI.setSzBlnAfAmerican("Y");
          agencyCustodialParentsSI.setCdCounty(dfcsCounty);
          agencyCustodialParentsSI.setIdInitiator(retrieveCsupOutboundNcpsSI.getIdInitiator());
          
          // Get Crs ID for this ACP
          try{
            Integer acpCrsId = createAcpCrsId(agencyCustodialParentsSI);
            retrieveCsupOutboundNcpsSO.setNbrCustCrsId(acpCrsId);

            // Have CRS ID then create a new ACP
            if(acpCrsId != null && acpCrsId.intValue()>0) {
              AgencyCustodialParentsSO agencyCustodialParentsSO = null;
              agencyCustodialParentsSI.setNbrCrsId(acpCrsId);
              agencyCustodialParentsSO = saveAgencyCustodialParents.saveAgencyCustodialParents(agencyCustodialParentsSI);
              if(agencyCustodialParentsSO!=null) {
                retrieveCsupOutboundNcpsSO.setAgencyCustodialParentsSO(agencyCustodialParentsSO);
              }        
            }
          }
          catch(Exception e) {
            envelopeRetrieveCsupOutboundNcpsSO.setError("CRS Registration Service cannot be accessed!");
            envelopeRetrieveCsupOutboundNcpsSO.addExceptionMsg(e.getMessage());
            retrieveCsupOutboundNcpsSO.setError("CRS Registration Service cannot be accessed!");
            retrieveCsupOutboundNcpsSO.addExceptionMsg(e.getMessage());
            break;
          }
        }
        

        // Set Racf ID
        String idInitiator = retrieveCsupOutboundNcpsSI.getIdInitiator();
        int loginId = StringHelper.isValid(idInitiator) ? Integer.parseInt(idInitiator) : 0;
        String employeeRacfId = employeeDAO.findEmployeeRacfIdWithLoginId(loginId);
        retrieveCsupOutboundNcpsSO.setShinesLogonShort(employeeRacfId);

        retrieveCsupOutboundNcpsSO.setDtCsupRequested(eligibilitySummaryDB.getDtEligCsupReferral());
        Long idCase = eligibilitySummaryDB.getIdCase();
        retrieveCsupOutboundNcpsSO.setIdCase(idCase.intValue());

        // Ncp Details
        PersonDtl ncpPersonDetail = getPersonDetails(ncpPersonId);
        if(null != ncpPersonDetail)
        {
          retrieveCsupOutboundNcpsSO.setIndChildPaternityEst(ncpPersonDetail.getIndPersonPaternityEst());
        }
        retrieveCsupOutboundNcpsSO.setIndChildSupportOrder(getIndChildSupportOrder(eligibilitySummaryDB.getIdFceApplication()));
        retrieveCsupOutboundNcpsSO.setIdNoncustParent(ncpPersonId);

        // Ncp Primary Address
        PersonAddress ncpAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(ncpPersonId);
        if (ncpAddress != null) {
          retrieveCsupOutboundNcpsSO.setAddrNoncustAddrStLn1(ncpAddress.getAddrPersAddrStLn1());
          retrieveCsupOutboundNcpsSO.setAddrNoncustAddrStLn2(ncpAddress.getAddrPersAddrStLn2());
          retrieveCsupOutboundNcpsSO.setAddrNoncustAddrCity(ncpAddress.getAddrPersonAddrCity());
          retrieveCsupOutboundNcpsSO.setCdNoncustAddrState(ncpAddress.getCdPersonAddrState());
          retrieveCsupOutboundNcpsSO.setAddrNoncustAddrZip(ncpAddress.getAddrPersonAddrZip());
        }

        // Ncp Marital Status
        retrieveCsupOutboundNcpsSO.setCdNoncustMaritalStatus(ncp.getCdPersonMaritalStatus());

        // Ncp CSup IncAndRes
        IncomeAndResources iandr = getCSPIncomeAndResource(ncpPersonId);
        if (iandr != null) {
          retrieveCsupOutboundNcpsSO.setTxtIncRsrcDesc(iandr.getTxtIncRsrcDesc());
          retrieveCsupOutboundNcpsSO.setTxtIncRsrcSrcAddrStLn1(iandr.getTxtIncRsrcSrcAddrStLn1());
          retrieveCsupOutboundNcpsSO.setTxtIncRsrcSrcAddrStLn2(iandr.getTxtIncRsrcSrcAddrStLn2());
          retrieveCsupOutboundNcpsSO.setTxtIncRsrcSrcAddrCity(iandr.getTxtIncRsrcSrcAddrCity());
          retrieveCsupOutboundNcpsSO.setTxtIncRsrcSrcAddrState(iandr.getTxtIncRsrcSrcAddrState());
          retrieveCsupOutboundNcpsSO.setTxtIncRsrcSrcAddrZip(iandr.getTxtIncRsrcSrcAddrZip());
        }
        retrieveCsupOutboundNcpsSO.setIndSsiNoncust(getIndSsi(ncpPersonId));

        // Office
        Object[] officeDetails = findOffice(idStage);
        String tmp = null;
        if(officeDetails!=null) {
          Object idOffice = officeDetails[1];
          String tmpIdOff = idOffice.toString();
          int tmpIdOffLen = tmpIdOff.length();
          if(tmpIdOffLen > 3)
          {
            tmp = tmpIdOff.substring(tmpIdOffLen - 3, tmpIdOffLen);
            if(null != tmp)
              retrieveCsupOutboundNcpsSO.setIdOffice(Integer.valueOf(tmp));
          } else {
            if(idOffice != null) 
              retrieveCsupOutboundNcpsSO.setIdOffice(Integer.valueOf(tmpIdOff));
          }
          Object nmOffice = officeDetails[0];
          retrieveCsupOutboundNcpsSO.setNmOfficeName((String) nmOffice);
        } else {
          // This should never come here as the idOffice cannot be null
          int idOffice = 0;
          retrieveCsupOutboundNcpsSO.setIdOffice(Integer.valueOf(idOffice));
          retrieveCsupOutboundNcpsSO.setNmOfficeName(InterfaceServiceConstants.OFFICE_NAME_DEFAULT);
        }

        // Find Case Manager Details
        Person caseMgr = retrieveCaseManagerDetails(idStage, CodesTables.CROLEALL_PR);
        if (caseMgr != null) {
          retrieveCsupOutboundNcpsSO.setNmCasemanagerFirst(caseMgr.getNmPersonFirst());
          retrieveCsupOutboundNcpsSO.setNmCasemanagerLast(caseMgr.getNmPersonLast());
          retrieveCsupOutboundNcpsSO.setNmCasemanagerMiddle(caseMgr.getNmPersonMiddle());
          String personFax = personPhoneDAO.findNbrPersonPhoneByIdPersonAndPhoneType(caseMgr.getIdPerson(), InterfaceServiceConstants.PHONE_TYPE);
          retrieveCsupOutboundNcpsSO.setNbrCasemanagerFax(personFax);
        }
        
        // Find Case Manager's office address
        if(caseMgr!=null) {
          Office office = getEmployeeOffice(caseMgr.getIdPerson());
          if (office != null) {
            MailCode mailCode = office.getMailCode();
            if (mailCode != null) {
              retrieveCsupOutboundNcpsSO.setAddrCasemanAddrStLn1(mailCode.getAddrMailCodeStLn1());
              retrieveCsupOutboundNcpsSO.setAddrCasemanAddrStLn2(mailCode.getAddrMailCodeStLn2());
              retrieveCsupOutboundNcpsSO.setAddrCasemanAddrCity(mailCode.getAddrMailCodeCity());
              retrieveCsupOutboundNcpsSO.setCdCasemanAddrState("GA");
              retrieveCsupOutboundNcpsSO.setAddrCasemanAddrZip(mailCode.getAddrMailCodeZip());
              retrieveCsupOutboundNcpsSO.setNbrCasemanagerPhone(mailCode.getNbrMailCodePhone());
            }
            Collection<OfficePhone>  officePhones = office.getOfficePhones();
            if (officePhones != null && !officePhones.isEmpty()) {
              for (Iterator<OfficePhone> it = officePhones.iterator(); it.hasNext();) {
                OfficePhone officePhone = it.next();
                if (CodesTables.CPHNTYP_BF.equals(officePhone.getCdOfficePhoneType()) && DateHelper.isNull(officePhone.getDtOfficePhoneEnd()) == true) {
                  retrieveCsupOutboundNcpsSO.setNbrCasemanagerFax(officePhone.getNbrOfficePhone());
                  break;
                }
              }
            }
          }
        }

        // Other details: County, Stage, IdInitiator, Status, COA
        retrieveCsupOutboundNcpsSO.setCdCounty(dfcsCounty);
        retrieveCsupOutboundNcpsSO.setIdStage(idStage.intValue());
        retrieveCsupOutboundNcpsSO.setIdInitiator(retrieveCsupOutboundNcpsSI.getIdInitiator());
        retrieveCsupOutboundNcpsSO.setInterfaceStatus(RetrieveCsupOutboundNcpsSO.INTERFACE_STATUS_NEW);
        if(null != eligibilitySummaryDB.getCdEligMedEligGroup())
        {
          retrieveCsupOutboundNcpsSO.setCdMedCoa(eligibilitySummaryDB.getCdEligMedEligGroup());
        } else {
          // Should never come here as the MedCOA cannot be null
          retrieveCsupOutboundNcpsSO.setCdMedCoa(InterfaceServiceConstants.MEDICAL_COA_DEFAULT);
        }
        // Add the NCP to the list
        refOutboundSI.add(retrieveCsupOutboundNcpsSO);
        //retrieveCsupOutboundNcpsSO.addToListCSupRefOutboundSI(retrieveCsupOutboundNcpsSO);
      
      } 
      // TODO Check usage of the messages/redundancy  also the SO extending SI
      catch (Exception e) {  
        
        envelopeRetrieveCsupOutboundNcpsSO.setError("Error occured in retrieving the the Child Support Referral related data. Please check logs for errors.");
        envelopeRetrieveCsupOutboundNcpsSO.addExceptionMsg(e.getMessage());
        retrieveCsupOutboundNcpsSO.setError("Error occured in retrieving the the Child Support Referral related data. Please check logs for errors.");
        retrieveCsupOutboundNcpsSO.addExceptionMsg(e.getMessage());
      }
    }
    envelopeRetrieveCsupOutboundNcpsSO.setListCSupRefOutboundSI(refOutboundSI);
    
    return envelopeRetrieveCsupOutboundNcpsSO;
  }


  private Person retrieveCaseManagerDetails(Long idStage, String cdRole) {
    Integer idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage.intValue(), cdRole);
    return personDAO.findPersonByIdPerson(idPerson);
  }

  private PersonAddress retrieveCaseManagerAddress(Integer idPerson) {
    return personAddressDAO.findPrimaryPersonAddressByIdPerson(idPerson);
  }

  private IncomeAndResources getCSPIncomeAndResource(Integer idPerson) {
    IncomeAndResources incRsrcObj =  incomeAndResourcesDAO.findDistinctIncomeAndResourcesInfo(idPerson);
    if(incRsrcObj!=null) {
      String irType = incRsrcObj.getCdIncRsrcType();
      if( (InterfaceServiceConstants.INC_RSRC_DESC_GRS.equalsIgnoreCase(irType))|| (InterfaceServiceConstants.INC_RSRC_DESC_SLF.equalsIgnoreCase(irType))){
        return incRsrcObj;
      }
    }
    return null;
  }

  private String getIndChildSupportOrder(Long idFceApplication) {

    FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdFceApplication(idFceApplication);
    return fceApplication.getIndChildSupportOrder();

  }

  private PersonDtl getPersonDetails(Integer personId) {

    PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(personId);
    return personDtl;

  }

  private Object[] findOffice(Long idStage) {
    Object[] officeInfo = officeDAO.findOfficeByIdStage(idStage.intValue());
    return officeInfo;
  }

  private String getDFCSCounty(Integer idStage) {
    Stage stage = stageDAO.findStageByIdStage(idStage);
    return stage.getCdStageCnty();
  }

  /**
   * Helper methods that makes calls to the appropriate DAO's to get the data that is required to insert into the
   * csup_parent_outbound table
   * 
   * @param idPerson
   * @return
   */
  private String getIndSsi(Integer idPerson) {
    IncomeAndResources incRsrcObj = incomeAndResourcesDAO.findDistinctIncomeAndResourcesInfo(idPerson);
    if(incRsrcObj!=null) {
      String irType = incRsrcObj.getCdIncRsrcType();
      return InterfaceServiceConstants.INC_RSRC_TYPE_SSI.equals(irType)? InterfaceServiceConstants.SSI_NON_CUST_FLAG_Y:InterfaceServiceConstants.SSI_NON_CUST_FLAG_N;
    }
    return InterfaceServiceConstants.SSI_NON_CUST_FLAG_N;
  }

  /**
   * Gets the existing Crs ID for the Person
   * 
   * @param logonId
   * @param idPerson
   * @return
   */
  private int getCrsId(String logonId, Integer idPerson) {

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(logonId);
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(25);

    PersonIdInStruct personIdInStruct = new PersonIdInStruct();
    personIdInStruct.setBSysIndIntake(InterfaceServiceConstants.NOT_INTAKE_MODE);
    personIdInStruct.setUlIdPerson(idPerson.intValue());

    CINT19SI cint19si = new CINT19SI();
    cint19si.setArchInputStruct(archInputStruct);
    cint19si.setPersonIdInStruct(personIdInStruct);

    CINT19SO cint19so = null;
    cint19so = retrievePersonIdentifiers.findPersonIdentifiers(cint19si);
    CINT14WLB_ARRAY identifiers = cint19so.getCINT14WLB_ARRAY();
    String returnString = null;
    if (identifiers != null) {
      Enumeration enumeration = identifiers.enumerateCINT14WLB();
      while (enumeration.hasMoreElements()) {
        CINT14WLB cint14wlb = (CINT14WLB) enumeration.nextElement();
        org.exolab.castor.types.Date endDate = cint14wlb.getDtPersonIDEnd();
        // We need to check and see if the existing one is not end-dated, that the codeType is the same and that the
        // number is the same; if so, we are trying to add a new one that has the same number as an existing one.
        if ((endDate == null) && cint14wlb.getSzCdPersonIdType().equals(CodesTables.CNUMTYPE_CRS_IDNUMBER)) {
          returnString = cint14wlb.getSzNbrPersonIdNumber();
        }
      }
    }
    if(returnString == null)    returnString ="0";
    return Integer.valueOf(returnString);
  }

  /**
   * Creates a Crs ID for AgencyCustodial Parents
   * 
   * @param agencyCustodialParentsSI
   * @return
   */
  private int createAcpCrsId(AgencyCustodialParentsSI agencyCustodialParentsSI) {
    CrsRegistrationSI crsRegistrationSI = new CrsRegistrationSI();
    crsRegistrationSI.setSzFName(agencyCustodialParentsSI.getNmPersonFirst());
    crsRegistrationSI.setSzMName(agencyCustodialParentsSI.getNmPersonMiddle());
    crsRegistrationSI.setSzLName(agencyCustodialParentsSI.getNmPersonLast());
    crsRegistrationSI.setSzSexCode(agencyCustodialParentsSI.getCdPersonSex());
    crsRegistrationSI.setSzEthnCode(agencyCustodialParentsSI.getCdEthnicity());
    crsRegistrationSI.setSzRaceCode(agencyCustodialParentsSI.getCdRace());
    crsRegistrationSI.setUlCountyCode(Integer.valueOf(agencyCustodialParentsSI.getCdCounty()).intValue());
    crsRegistrationSI.setLnIdInitiator(String.valueOf(agencyCustodialParentsSI.getIdInitiator()));
    crsRegistrationSI.setSzBlnAfAmerican(agencyCustodialParentsSI.getSzBlnAfAmerican());
    CrsRegistrationSO crsRegistrationSO = crsRegistration.performCrsRegistration(crsRegistrationSI);
    return crsRegistrationSO.getLnIrnClientId();
  }

  /**
   * Finds out the Ncps of the Child
   * 
   * @param stageId
   * @param stagePersType
   * @param stagePersRelInt
   * @return
   */
  private List<StagePersonLink> getNcpsForChild(Long idStage) {
    return stagePersonLinkDAO.findNcpsForFccChild(idStage.intValue());
  }
  
  
  private Integer getChildIdPerson(int idStage) {
    return stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, InterfaceServiceConstants.STAGE_PERSON_ROLE);
  }
  
  
  private Office getEmployeeOffice(int idPerson) {
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);
    Office office = null;
    if(employee != null) {
      office = employee.getOffice();
    }
    return office;
  }
}
