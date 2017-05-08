package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaretakerDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCaretaker;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.MailCode;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.AdoptionAssistanceAgreement;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveInitialMedicaid;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ADOFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ADOFORMSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------               
01/14/09  mchillman         STGAP00011888: changed to get office phone number
02/02/09  cwells            STGAP00012295: displaying childs full first and last name
02/28/09  cwells            STGAP00011888: Added correct format for the office phone number(xxx)xxx-xxxx
06/14/09  mxpatel           STGAP00013002: added code to make sure that pre-finalization (ADO Stage) 
                            the AA Agreement form will populate that the child will be covered by Medicaid 
                            even if the Agreement is denied or deferred. Post finalization (PAD stage) the 
                            AA Agreement form will populate the child will not be covered if denied or deferred.
07/15/09 bgehlot            STGAP00014724: Get the non recurring amount limit from the approved non recurring application
02/09/10 hjbaptiste         SMS#44783: MR-60 Changes. If Special Needs Application is 'Deferred' or 'Denied', set 
                            Medical Benefits for Adoption to 'NO'
02/18/10 cwells             No SMS: Per Capta populating IVE and IVB information with information from the application      
01/06/2011  arege           SMS#77302 Modified code to correctly populate the Child covered by Medicaid checkbox 
02/15/11  cwells            SMS# 63467 When the adoptive parents are entered as a Resource-Non DFCS Private adoption.  Their caretaker information will be
                            entered in the resource CareTaker Information
02/07/12  vcollooru		    STGAP00017878: (Break-fix defect for 5.1) Following are the changes done as part of the fix -
 								i) Pre-filled the initial and amended checkbox based upon the Agreement Type selected.
            
*/
public class AdoptionAssistanceAgreementImpl extends BaseDocumentServiceImpl implements AdoptionAssistanceAgreement {
  
  private static final String TITLE_IVE_ASST_AND_MED = CodesTables.CSUBTYPE_01;;
  private static final String TITLE_IVE_ASST_ONLY = CodesTables.CSUBTYPE_03;
  private static final String TITLE_IVE_MED_ONLY = CodesTables.CSUBTYPE_05;
  private static final String TITLE_IVB_ASST_AND_MED = CodesTables.CSUBTYPE_07;
  private static final String TITLE_IVB_ASST_ONLY = CodesTables.CSUBTYPE_09;
  private static final String TITLE_IVB_MED_ONLY = CodesTables.CSUBTYPE_11;
  private static final String TITLE_IVB_ASST_OTHER_MED = CodesTables.CSUBTYPE_12;
  
  private static final String ADOPTIVE_FOSTER_PARENT = CodesTables.CRELVICT_AF;
  private static final String ADOPTIVE_PARENT = CodesTables.CRELVICT_PT;
  private static final String FOSTER_PARENT = CodesTables.CRELVICT_FP;
  private static final String FOSTER_PARENT_CPA_CCI = CodesTables.CRELVICT_FA;

  private static final String MILITARY_INSURANCE = CodesTables.CINSTYPE_MIL;
  private static final String APPROVED = CodesTables.CEVTSTAT_APRV;
  
  
  private AdptSubEventLinkDAO adptSubEventLinkDAO;
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  private CapsResourceDAO capsResourceDAO;
  private CapsCaseDAO capsCaseDAO;
  private EmployeeDAO employeeDAO;
  private EventDAO eventDAO;
  private PersonPhoneDAO personPhoneDAO;
  private PlacementDAO placementDAO;
  private RetrieveInitialMedicaid retrieveInitialMedicaid;
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO;
  private StagePersonLinkDAO stagePersonLinkDAO;
  private EligibilityDAO eligibilityDAO = null;
  private StageLinkDAO stageLinkDAO = null;
  private StageDAO stageDAO = null;
  private CapsCaretakerDAO capsCaretakerDAO = null;
    
  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }
  
  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO){
    this.capsCaseDAO = capsCaseDAO;
  }
  
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEventDAO(EventDAO eventDAO){
    this.eventDAO = eventDAO;
  }
  
  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  public void setRetrieveInitialMedicaid(RetrieveInitialMedicaid retrieveInitialMedicaid) {
    this.retrieveInitialMedicaid = retrieveInitialMedicaid;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setCapsCaretakerDAO(CapsCaretakerDAO capsCaretakerDAO) {
    this.capsCaretakerDAO = capsCaretakerDAO;
  }
  
  public ADOFORMSO retrieveAdoptionAssistanceAgreement(ADOFORMSI adoFormSI){
    ADOFORMSO adoFormso = new ADOFORMSO();

    int idStage = adoFormSI.getUlIdStage();
    int idChildPrimary = adoFormSI.getUlIdPerson();
    int idEvent = adoFormSI.getUlIdEvent();
    int idCase = adoFormSI.getUlIdCase();
    PreFillData preFillData = new PreFillData();
   
    retrieveAgencyInfo(preFillData, idCase, idStage);                           // Get agency info
    retrieveResourceInfo(preFillData, idChildPrimary);                  // Get adoptive parents info
    retrieveAdoptionSubsidyInfo(preFillData,idEvent,idStage,idCase,idChildPrimary);           // Get subsidy info
    retrieveDocumentInfo(preFillData, idEvent, idStage);                // Get Document Info
    retrieveInsuranceInfo(preFillData,idEvent,idStage,idChildPrimary);  // Get medical insurance/info for child
    adoFormso.setPreFillData(preFillData);
    
    return adoFormso;
  }

  @SuppressWarnings( { "unchecked" } )
  private void retrieveAgencyInfo(PreFillData preFillData, int idCase, int idStage){
    Person caseManager = null;
    CapsCase capsCase = null;
    String agencyAddress = "";
    String agencyPhoneNumber = "";
    String countyName = "";

    capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    if (capsCase != null) {
      countyName = capsCase.getCdCaseCounty();
    }
    /*
     * Get the case manager and use this person
     * to get the agency name and address, as well
     * as the county
     */
    caseManager = getCaseManager(idStage);
    if (caseManager != null) {
      Employee employee = employeeDAO.findEmployeeByIdPerson(caseManager.getIdPerson());
      
      if(employee != null) {
        
        MailCode mailCode = employee.getMailCode();
        if (mailCode != null) {
          StringBuffer addr = new StringBuffer();
          formatAddress(mailCode.getAddrMailCodeStLn1(), mailCode.getAddrMailCodeStLn2(),
                        mailCode.getAddrMailCodeCity(), "GA", mailCode.getAddrMailCodeZip(), addr);
          agencyAddress = addr.toString();
          agencyPhoneNumber = mailCode.getNbrMailCodePhone();
        }
      }      
    }

    preFillData.addBookmark(createBookmark(COUNTY_NAME_2, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, countyName)));
    preFillData.addBookmark(createBookmark(COUNTY_NAME_3, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, countyName)));
    preFillData.addBookmark(createBookmark(RELEVANT_AGENCY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, countyName)));
    preFillData.addBookmark(createBookmark(AGENCY_ADDRESS, agencyAddress));
    preFillData.addBookmark(createBookmark(AGENCY_PHONE, FormattingHelper.formatPhone(agencyPhoneNumber)));
    
  }


  @SuppressWarnings( {"unchecked"} )
  private void retrieveResourceInfo(PreFillData preFillData, int idChildPrimary) {
    Placement adoPlacement = null;
    String nmAdoptiveParents = "";
    String phoneNumber = "";
    String address = "";
    String countyName = "";
    int idFadStage = 0;

    /*
     * Use the current placement to get the adoptive
     * parent's names, address, and phone number
     */
    adoPlacement = getCurrentPlacement(idChildPrimary);
    if (adoPlacement != null) {
      
      int idResource = adoPlacement.getCapsResourceByIdRsrcFacil() == null ? 0 : 
                       adoPlacement.getCapsResourceByIdRsrcFacil().getIdResource();
      
      if (idResource > 0) {

        CapsResource resource = capsResourceDAO.findCapsResourceByIdResc(idResource);

        if (resource != null) {
          StringBuffer addr = new StringBuffer();
          formatAddress(resource.getAddrRsrcStLn1(),resource.getAddrRsrcStLn2(),
                        resource.getAddrRsrcCity(),resource.getCdRsrcState(),
                        resource.getAddrRsrcZip(), addr);
          if (addr != null) {
            address = addr.toString();
          }
          
          countyName = resource.getCdRsrcCnty();

          String phoneNbr = FormattingHelper.formatPhone(resource.getNbrRsrcPhn());
          String phoneExt = resource.getNbrRsrcPhoneExt();
          if (phoneNbr != null) {
            phoneNumber = phoneNbr;
            if (phoneExt != null) {
              phoneNumber = phoneNumber + "   Ext " + phoneExt;
            }
          }
          
          idFadStage = resource.getStage() == null ? 0 : resource.getStage().getIdStage();
          if (idFadStage > 0) {
            Collection cdStagePersTypes = new ArrayList<String>();
            cdStagePersTypes.add(ADOPTIVE_PARENT);
            cdStagePersTypes.add(FOSTER_PARENT);
            cdStagePersTypes.add(ADOPTIVE_FOSTER_PARENT);
            cdStagePersTypes.add(FOSTER_PARENT_CPA_CCI);
            List<StagePersonLink> personList = stagePersonLinkDAO
                                                                 .findStagePersonLinkByIdStageByCdStagePersRelInts(
                                                                                                                   idFadStage,
                                                                                                                   cdStagePersTypes);
            if (personList != null) {
              Iterator it = personList.iterator();
              StringBuffer fullName = new StringBuffer();
              while (it.hasNext()) {
                StagePersonLink stgPerson = (StagePersonLink) it.next();
                Person person = stgPerson.getPerson();
                if (person != null) {
                  String personName = person.getNmPersonFirst() + " " + person.getNmPersonLast();
                  if (fullName.length() > 0) {
                    fullName.append(", " + personName);
                  } else {
                    fullName.append(personName);
                  }
                }
              }
              nmAdoptiveParents = fullName.toString();
            }
          } else {//SMS 63467 When the adoptive parents are entered as a Resource-Non DFCS Private adoption.  Their caretaker information will be
            //entered in the resource CareTaker Information.  
            List<Map> capsCaretakerList = capsCaretakerDAO.findCapsCaretakerByIdResource(idResource);
            if (capsCaretakerList != null) {
              StringBuffer fullName = new StringBuffer();
              for (Iterator<Map> it = capsCaretakerList.iterator(); it.hasNext();) {
                Map capsCaretakerMap = it.next();
                String personName = (String) capsCaretakerMap.get("nmCaretkrFname") + " "
                                    + capsCaretakerMap.get("nmCaretkrLname");
                if (fullName.length() > 0) {
                  fullName.append(", " + personName);
                } else {
                  fullName.append(personName);
                }
              }
              nmAdoptiveParents = fullName.toString();
            }
          }
        }
      }
    }
    preFillData.addBookmark(createBookmark(COUNTY_NAME, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, countyName)));
    preFillData.addBookmark(createBookmark(ADO_PARENTS_FULL_NAMES, nmAdoptiveParents));
    preFillData.addBookmark(createBookmark(ADO_ADDRESS, address));
    preFillData.addBookmark(createBookmark(ADO_PHONE_NUMBER, phoneNumber));
    
  }
  
  @SuppressWarnings( { "unchecked" } )
  private void retrieveDocumentInfo(PreFillData preFillData, int idEvent, int idStage) {
    String eventStatus = ""; 
    String indSpcNeedsApproved = "";
    String indSpclRateAdoAppr = ""; 
    String indSpclReqApproved = "";
    String applicationStatus = "";
    /*
     * Retrieve the Adoption Subsidy Information related to
     * the Event idEvent.
     */
    Map adoSubsidyMap = adptSubEventLinkDAO.findAdptSubEventLink(idEvent);
    if (adoSubsidyMap != null) {
      Integer idSpecialNeedsDetermination = (Integer)adoSubsidyMap.get("idSpecialNeedsDetermination");
      if (idSpecialNeedsDetermination != null) {
        //Get the SpecialNeedsDetermination
        SpecialNeedsDetermination specialNeedsDetermination = specialNeedsDeterminationDAO.
                                                                  findSpecialNeedsDeterminationByIdEvent(idSpecialNeedsDetermination);
        //Get the Event for the idSpecialNeedsDetermination as idEvent and idSpecialNeedsDetermination
        //have a Integrity constraints as PK/FK
        Event event = eventDAO.findEventByIdEvent(idSpecialNeedsDetermination);
        if (event != null){
          eventStatus = StringHelper.getSafeString(event.getCdEventStatus());
        }
        if (specialNeedsDetermination != null){
          indSpcNeedsApproved = StringHelper.getSafeString(specialNeedsDetermination.getIndSpcNeedsApproved());
          indSpclRateAdoAppr = StringHelper.getSafeString(specialNeedsDetermination.getIndSpclRateAdoAppr());
          indSpclReqApproved = StringHelper.getSafeString(specialNeedsDetermination.getIndSpclReqApproved());
          //Get the Adoption Assistance Application Status
          applicationStatus = getApprDeferDeniedStatus(eventStatus, indSpcNeedsApproved, indSpclRateAdoAppr, indSpclReqApproved);
          //Checking the application status for deferred and set the check box.
          if (CodesTables.CAPPSTS_D.equals(applicationStatus)){
            preFillData.addBookmark(createBookmark(DOC_PURPOSE_DEFER,"CHECKED"));
          }else if (CodesTables.CAPPSTS_Y.equals(applicationStatus)){
            // STGAP00017878: Agreement type
            //   i) valid indicates it is new agreement and should follow new logic
            //  ii) else indicates it is old agreement and should still use the logic prior 5.1 release
            if(StringHelper.isValid(specialNeedsDetermination.getIndAgrmtType())) {
              // STGAP00017878: Pre-fill the check-box selection based upon the Agreement Type selected -
              // If the Agreement Type selected is Initial then check the initial, else
              // if the Agreement Type selected is Amended then check the amended
              if (AGREEMENT_TYPE_INITIAL.equals(specialNeedsDetermination.getIndAgrmtType())) {
                preFillData.addBookmark(createBookmark(DOC_PURPOSE_INIT, "CHECKED"));
              } else if (AGREEMENT_TYPE_AMENDED.equals(specialNeedsDetermination.getIndAgrmtType())) {
                preFillData.addBookmark(createBookmark(DOC_PURPOSE_AMEND, "CHECKED"));
              }
            } else {
              //If it is approved, then check to see if the current event id is the very first
              //approved event id. In that case check Initial else check the amended one.
              Integer firstApprEventId = getFirstApprIdEvent(idStage);
              if (firstApprEventId != null ){
                //If it is equal, then check the initial
                if (firstApprEventId.intValue() == idSpecialNeedsDetermination.intValue()){
                  preFillData.addBookmark(createBookmark(DOC_PURPOSE_INIT,"CHECKED"));
                }else {
                  //If it is not equal, then check the amended one
                  preFillData.addBookmark(createBookmark(DOC_PURPOSE_AMEND,"CHECKED"));                
                }
              }
            }
          }  
        }
      }
    }
  }
  
  @SuppressWarnings( { "unchecked" } )
  private void retrieveAdoptionSubsidyInfo(PreFillData preFillData, int idEvent, int idStage, int idCase, int idChildPrimary) {
    String childName = "";
    String childFirstName = "";
    String childBirthDate = null;
    Date childBirthDt = null;

    /*
     * Retrieve the stage/person link and retrieve
     * the primary child from this link
     */
    String cdStagePersRelInt = CodesTables.CROLES_PC;
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRole(idStage,
                                                                                                       cdStagePersRelInt);
    if (stagePersonLink != null) {
      Person childPrimary = stagePersonLink.getPerson();
      if (childPrimary != null) {
        // STGAP00012295 displaying childs full first and last name. 
        childName = getFullName(childPrimary);
        childFirstName = childPrimary.getNmPersonFirst();
        childBirthDt = childPrimary.getDtPersonBirth();
        
        // populate from the eligibility setting
        Map adptSubEventLinkInfo = adptSubEventLinkDAO.findAdptSubEventLink(idEvent);
        String actualType = null;
        if (adptSubEventLinkInfo != null) {
          int ulSpecialNeedsEvent = (Integer) adptSubEventLinkInfo.get("idSpecialNeedsDetermination") != null ? (Integer) adptSubEventLinkInfo
                                                                                                                                              .get("idSpecialNeedsDetermination")
                                                                                                             : 0;
          if (ulSpecialNeedsEvent > 0) {
            SpecialNeedsDetermination specialNeedsDetermination = specialNeedsDeterminationDAO
                                                                                              .findSpecialNeedsDeterminationByIdEvent(ulSpecialNeedsEvent);
            String determinationType = specialNeedsDetermination.getCdFundingType();
            if (CodesTables.CAAFDTYP_PST.equals(determinationType)) {
              actualType = CodesTables.CELIGIBI_020;
            } else if (CodesTables.CAAFDTYP_IVE.equals(determinationType)) {
              actualType = CodesTables.CELIGIBI_010;

            }
          }
        }
        // Either there is no attached application or the application does not have a value for Funding Type
        // Then we are looking for the value on the agreement page for Type/Class of Assistance:
        if (actualType == null) {
          HashMap<String, String> agreementTypesMap = new HashMap<String, String>();
          agreementTypesMap.put(CodesTables.CSUBTYPE_01, CodesTables.CELIGIBI_010); // Title IV-E Fin Asst and Medicaid
          agreementTypesMap.put(CodesTables.CSUBTYPE_03, CodesTables.CELIGIBI_010); // Title IV-E Fin Asst Only
          agreementTypesMap.put(CodesTables.CSUBTYPE_26, CodesTables.CELIGIBI_010); // Title IV-E Medicaid Only (GA
                                                                                    // Child)
          agreementTypesMap.put(CodesTables.CSUBTYPE_07, CodesTables.CELIGIBI_020); // Title IV-B State Adpt Fin Asst
                                                                                    // and Medicaid
          agreementTypesMap.put(CodesTables.CSUBTYPE_09, CodesTables.CELIGIBI_020); // Title IV-B State Adpt Fin Asst
          // Only
          agreementTypesMap.put(CodesTables.CSUBTYPE_27, CodesTables.CELIGIBI_020); // Title IV-B State Medicaid Only
          // (GA Child)

          String agreementClass = (String) adptSubEventLinkInfo.get("cdSpclAsstType");
          if (agreementClass != null && agreementTypesMap.containsKey(agreementClass)) {
            actualType = agreementTypesMap.get(agreementClass);
          } else {
            // If the Actual type is still null then we are just pulling the latest approved eligibility regardless of
            // what case we are in.
            Eligibility eligibility = eligibilityDAO.findEligibilityLatestApprovedByIdCaseByIdPerson(idCase,
                                                                                                     idChildPrimary);
            if (eligibility != null) {
              actualType = eligibility.getCdEligActual();
            }
          }
        }
        if (CodesTables.CELIGIBI_010.equals(actualType)) {
          preFillData.addBookmark(createBookmark(TITLE_IV_E_ELIGIBLE_YES, "CHECKED"));
        } else {
          preFillData.addBookmark(createBookmark(TITLE_IV_E_ELIGIBLE_NO, "CHECKED"));
        }

        if (CodesTables.CELIGIBI_020.equals(actualType)) {
          preFillData.addBookmark(createBookmark(TITLE_IV_B_ELIGIBLE_YES, "CHECKED"));
        } else {
          preFillData.addBookmark(createBookmark(TITLE_IV_B_ELIGIBLE_NO, "CHECKED"));
        }
      }
    }
    
    
    /*
     * Retrieve the Adoption Subsidy Information related to
     * the Event idEvent.
     */
    Double amtApproved = 0.0;
    Map adoSubsidyMap = adptSubEventLinkDAO.findAdptSubEventLink(idEvent);
    if (adoSubsidyMap != null) {
      Date dtAdptSubApprvd = (Date) adoSubsidyMap.get("dtAdptSubApprvd");
      if (DateHelper.isNull(dtAdptSubApprvd) == false) {
        Double adoSubsidyAmt = (Double)adoSubsidyMap.get("amtAdptSub");
        if (adoSubsidyAmt != null){
          amtApproved = adoSubsidyAmt;
          preFillData.addBookmark(createBookmark(APPROVED_MONTHLY_PYMNT_YES, "CHECKED"));
          Date dtStart = (Date) adoSubsidyMap.get("dtAdptSubEffective"); 
          Date dtTerminated = (Date) adoSubsidyMap.get("dtAdptSubTerminated"); 
          Date dtEnded = (Date) adoSubsidyMap.get("dtAdptSubEnd");      
          Date dtApprovedEnd = DateHelper.isBefore(dtTerminated, dtEnded) ? dtTerminated: dtEnded;
          preFillData.addBookmark(createBookmark(APPROVED_PAY_START, FormattingHelper.formatDate(dtStart)));
          preFillData.addBookmark(createBookmark(APPROVED_PAY_END, FormattingHelper.formatDate(dtApprovedEnd)));
          preFillData.addBookmark(createBookmark(APPROVED_PAYMENT_AMOUNT, FormattingHelper.formatMoney(amtApproved)));
        } else {
          preFillData.addBookmark(createBookmark(APPROVED_MONTHLY_PYMNT_NO, "CHECKED"));
        }
      } else {
        preFillData.addBookmark(createBookmark(APPROVED_MONTHLY_PYMNT_NO, "CHECKED"));
      }
    }
 
    preFillData.addBookmark(createBookmark(CHILD_NAME, childName));
    preFillData.addBookmark(createBookmark(CHILD_FIRST_NAME, childFirstName));
    preFillData.addBookmark(createBookmark(CHILD_DATE_OF_BIRTH, FormattingHelper.formatDate(childBirthDt)));    
    
    // STGAP00017878: Modified to get the non-recurring amount limit from the current adoption assistance application
    SpecialNeedsDetermination specialNeedsDetermination = null;
    if (adoSubsidyMap != null) {
      Integer idSpecialNeedsDetermination = (Integer) adoSubsidyMap.get("idSpecialNeedsDetermination");
      if (idSpecialNeedsDetermination != null) {
        // Get the SpecialNeedsDetermination
        specialNeedsDetermination = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(idSpecialNeedsDetermination);
      }
    }
    //STGAP00014724: Get the non recurring amount limit from the approved non recurring application
    //SpecialNeedsDetermination specialNeedsDetermination = specialNeedsDeterminationDAO.findAprvNonRecurringByIdStageByIdPerson(idStage, idChildPrimary, idCase);
    double nonRecurringLimit = 0.0;
    if(specialNeedsDetermination != null){
     nonRecurringLimit = specialNeedsDetermination.getNbrNonRecAprvAmt();
    }
    if(nonRecurringLimit != 0.0){
      preFillData.addBookmark(createBookmark(NON_RECURRING_LIMIT_AMT, FormattingHelper.formatMoney(nonRecurringLimit)));
    }else{
      preFillData.addBookmark(createBookmark(NON_RECURRING_LIMIT_AMT, FormattingHelper.formatMoney(NON_RECURRING_LIMIT_AMT_DEFAULT)));
    }
  }

  private void retrieveInsuranceInfo(PreFillData preFillData, int idEvent, int idStage, int idPerson) {
    MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI = populateMedicaidApplicationRetrieveSI(idEvent, idStage, idPerson);
    MedicaidApplicationRetrieveSO medicaidApplicationRetrieveSO = retrieveInitialMedicaid.retrieveInitialMedicaid(medicaidApplicationRetrieveSI);
   
    //if there is medicaidApplication for this and its an ADO look back to the prior stage
    if (medicaidApplicationRetrieveSO == null || medicaidApplicationRetrieveSO.getEventId() == 0){
      Stage stage = getPersistentObject(Stage.class, idStage);
      if(stage != null && CodesTables.CSTAGES_ADO.equals(stage.getCdStage())) {
        Integer priorStageId = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
        int idPriorStage = (priorStageId != null ? priorStageId : 0);
        medicaidApplicationRetrieveSI = populateMedicaidApplicationRetrieveSI(idEvent, idPriorStage, idPerson);
        medicaidApplicationRetrieveSO = retrieveInitialMedicaid.retrieveInitialMedicaid(medicaidApplicationRetrieveSI);
      }
    }
    
    String eventStatus = null;
    if (medicaidApplicationRetrieveSO != null){
      if (NO.equals(medicaidApplicationRetrieveSO.getIndChildCoverage())) {
        preFillData.addBookmark(createBookmark(CHILD_FAM_HEALTH_INS_NO, "CHECKED"));
      } else if (YES.equals(medicaidApplicationRetrieveSO.getIndChildCoverage())) {
        preFillData.addBookmark(createBookmark(CHILD_FAM_HEALTH_INS_YES, "CHECKED"));
      } else {
        preFillData.addBookmark(createBookmark(CHILD_FAM_HEALTH_INS_NO, "CHECKED"));
      }
      
      if (MILITARY_INSURANCE.equals(medicaidApplicationRetrieveSO.getCdType())){
        preFillData.addBookmark(createBookmark(CHILD_MILITARY_BENEFITS_YES, "CHECKED"));
      } else {
        preFillData.addBookmark(createBookmark(CHILD_MILITARY_BENEFITS_NO, "CHECKED"));
      }
      eventStatus = medicaidApplicationRetrieveSO.getCdEventStatus();
    }
    
    // STGAP00013002: mxpatel added this to make sure that pre-finalization (ADO Stage) the AA Agreement form will populate that the
    // child will be covered by Medicaid even if the Agreement is denied or deferred. Post finalization (PAD stage) the AA Agreement
    // form will populate the child will not be covered if denied or deferred.
    
    //SMS#77302 This Child will or will not be covered by Medicaid check box will be populated based on the AA application.
    //If the application is special needs approved or specialized rate approved then the check box will be covered check box is checked
    Map cdSpNeedsOrSpclRateStatus = specialNeedsDeterminationDAO.findIndAprvByIdAgreement(idEvent);
    if (cdSpNeedsOrSpclRateStatus != null) {
      String cdSpecialNeedsApproved = (String) cdSpNeedsOrSpclRateStatus.get("indSpcNeedsApproved");
      String cdSpecializedRateApproved = (String) cdSpNeedsOrSpclRateStatus.get("indSpecialRateApproved");
      if (CodesTables.CAPPSTS_Y.equals(cdSpecialNeedsApproved)
          || ArchitectureConstants.Y.equals(cdSpecializedRateApproved)) {
        preFillData.addBookmark(createBookmark(CHILD_MEDICAID_YES, "CHECKED"));
      } else {
        preFillData.addBookmark(createBookmark(CHILD_MEDICAID_NO, "CHECKED"));
      }
    }
  }
  
  // Get Current Placement
  private Placement getCurrentPlacement(int idChildPrimary) {
    return placementDAO.findPlacementLatestApprovedByIdPerson(idChildPrimary, DateHelper.MAX_JAVA_DATE);
  }
  
  /**
   * Private Method used to display full names
   */
  private String getFullName(Person person) {
    StringBuffer fullName = new StringBuffer();
    if (person != null) {
      fullName.append(person.getNmPersonLast());
      if (person.getNmPersonFirst() != null) {
        fullName.append(", " + person.getNmPersonFirst());
      }
      if (person.getNmPersonMiddle() != null) {
        fullName.append(" " + person.getNmPersonMiddle());
      }
      if (person.getCdPersonSuffix() != null) {
        fullName.append(" " + person.getCdPersonSuffix());
      }
    }
    return fullName.toString();
  }
  
  private Person getCaseManager(int idStage){
    // Checking for current case manager as well as historical case manager
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    Person caseMngr = stagePersonLink.getPerson();
    return caseMngr;
  }
  
  private String getPersonOfficePhone(int idPerson) {
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    return getPersonOfficePhoneNbr(idPerson, phoneTypes);
  }

  private String getPersonOfficePhoneNbr(int idPerson, List<String> phoneTypes) {
    StringBuffer primPersonPhone = new StringBuffer();
    String indPersonPhoneInValid = "N";
    String indPersonPhonePrimary = "Y";

    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);

    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {

      PersonPhone personPhone = it.next();
      if (personPhone != null) {
        if (indPersonPhonePrimary.equals(personPhone.getIndPersonPhonePrimary())) {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          }
        } else {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          } // inner else
        } // end outer if indPersonPhonePrimary
      } // end if personPhone
    } // end for loop
    return primPersonPhone.toString();

  }
  /**
   * Populating SI object  from the context. All population from the context (including request, session, and
   * state). The method should instantiate the input object, get values out of the context, and then return the SI
   * object. The case ID is not populated because it is not used by the class.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   * @return display service input object
   */
  private MedicaidApplicationRetrieveSI populateMedicaidApplicationRetrieveSI(int idEvent, int idStage, int idPerson) {
    
    MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI = new MedicaidApplicationRetrieveSI();
    medicaidApplicationRetrieveSI.setUlIdEvent(idEvent);
    medicaidApplicationRetrieveSI.setUlIdStage(idStage);
    medicaidApplicationRetrieveSI.setUlIdPerson(idPerson);
    
    return medicaidApplicationRetrieveSI;
  }

  /**
   * Using the StringBuffer that is passed in, this method adds all the address information
   * as a comma-delimited string.
   * 
   * @param strLn1
   * @param strLn2
   * @param city
   * @param state
   * @param zip
   * @param address
   */
  private void formatAddress(String strLn1, String strLn2, String city, String state, String zip, StringBuffer address) {
    if (strLn1 != null) {
      address = address.append(strLn1);
    }
    if (strLn2 != null) {
      address = address.append(", " + strLn2);
    }
    if (city != null) {
      address = address.append(", " + city);
    }
    if (state != null) {
      address = address.append(", " + state);
    }
    if (zip != null) {
      address = address.append(", " + zip);
    }
  }

  private String getApprDeferDeniedStatus(String eventStatus, String indSpcNeedsApproved,
                                          String indSpclRateAdoAppr, String indSpclReqApproved){
    // STGAP00010839 Set the application status based on various flags if the EVENT is approved. if any of the requests have been approved, 
    // then page will show 'approved' as the status.
    String applicationStatus="";
    if (CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
      if (CodesTables.CAPPSTS_Y.equals(indSpcNeedsApproved)
          || CodesTables.CAPPSTS_Y.equals(indSpclRateAdoAppr)
          || CodesTables.CAPPSTS_Y.equals(indSpclReqApproved)) {
        applicationStatus = CodesTables.CAPPSTS_Y;
      } else if (CodesTables.CAPPSTS_D.equals(indSpcNeedsApproved)) {
        applicationStatus = CodesTables.CAPPSTS_D;
      } else if (CodesTables.CAPPSTS_N.equals(indSpcNeedsApproved)
                 || CodesTables.CAPPSTS_N.equals(indSpclRateAdoAppr)
                 || CodesTables.CAPPSTS_N.equals(indSpclReqApproved)) {
        applicationStatus = CodesTables.CAPPSTS_N;
      }
    }
    return applicationStatus;
  }

  private Integer getFirstApprIdEvent(Integer idEventStage){
    List<String> cdEventStatus = new ArrayList<String>();
    cdEventStatus.add(CodesTables.CEVTSTAT_APRV);
    Date firstApprDt = DateHelper.MAX_JAVA_DATE;
    Integer firstApprIdEvent=0;
    //Get all the approved Events for Adoption Assistance Event Type
    List<Event> eventList = eventDAO.findEventByIdStageAndCdEventTypeDesc(idEventStage, CodesTables.CEVNTTYP_SND, cdEventStatus);
    if (eventList != null){
      for (int i=0; i<eventList.size(); i++){
        Event event = eventList.get(i);
        if (event != null && event.getIdEvent() != null){
          // Get the First Approval Date from all the approved events
          // DAO call returns all the approval events.  Loop will go thru all and set the approval date of the last approval.
          List<Object[]> approvalList = approvalEventLinkDAO.findApprovalsforCaseEvent(event.getIdEvent());
          for (Iterator<Object[]> it = approvalList.iterator(); it.hasNext();) {
            Object[] approvalArray = it.next();
            if (CodesTables.CEVTSTAT_APRV.equals(approvalArray[2].toString())) {
              // STGAP00014240 Date helper should not be used when comparing java dates with time stamps
              // the method will convert java dates to castor dates which will drop the time stamp
              if (firstApprDt.after((Timestamp) approvalArray[1])){
                firstApprDt = (Timestamp) approvalArray[1];
                firstApprIdEvent = event.getIdEvent();
              }
            }
          }
        }
      }
    }
    return firstApprIdEvent;
  }
}
