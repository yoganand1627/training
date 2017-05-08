package gov.georgia.dhr.dfcs.sacwis.service.document.impl;


import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxSentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicPlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExcChildAdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OutputLaunchEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanSecGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProfessionalAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharAdultDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.MailCode;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant;
import gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalReason;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;
import gov.georgia.dhr.dfcs.sacwis.db.YouthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.document.FCCPFamilyDetailForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFAMILYDETAILFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFAMILYDETAILFORMSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

/**
 * @author hong.van.t.vo, Mar 8, 2007
 * @version 1.0
 * 
 * <pre>
 *                        Change History:
 *                        Date      User              Description
 *                        --------  ----------------  --------------------------------------------------
 *
 *                        5/17/2008  cjgerry          STGAP00006520 - if there is no child plan AFSA checkmarks from SHINES
 *                                                     display as if the answer was 'No' 
 *                        06/12/2008 mchillman        STGAP00006933 Add conditions on when to show WTLP Sections
 *                        06/14/2008 mchillman        STGAP00005906 get the value based on the CodesTables.CLHECOT_FDP Final Disposition entry
 *                        06/14/2008 mchillman        STGAP00005932 Removed Date of Approval
 *                        06/16/2008 mchillman        STGAP00009115 Pull for field that were moved to Education and Needs Outcome pages
 *                        06/24/2008 cjgerry          STGAP00009339 - get safe version of string to avoid null pointer on replaceAll command
 *                        07/28/2008 mchillman        STGAP00009568 Changed code to populate education section for aftercare plans
 *                        09/16/2008 arege            STGAP00010091 Changed private method getSUBidStage() to get isStages for both open
 *                                                    and closed FCC stages. 
 *                       10/17/2008 rphelps           STGAP00010523: changes for adoptions enhamcents.
 *                       02/11/2009 cwells            STGAP00012156 Displaying the ADO information section with the Childs name if a ADO 
 *                                                    stage is opened without the Adoption Information 
 *                       02/25/2009 cwells            STGAP00012585 Displaying correct dates for State Recruitment Activities section.                              
 *                                                      
 *                       04/17/2009 bgehlot           STGAP00012810: Changed the Action date to Court Order Date
 *                       05/26/2009 mchillman         STGAP00012742: Change method on pulling TPR Filed date
 *                       06/12/2009 mxpatel           STGAP00013356: removed changed that were made fore defect #10091   
 *                       09/27/2009 arege             STGAP00013356: Child's name should be available in form launch dropdown even if the child has closed FCC
 *                                                    but open ADO stage.  
 *                       12/01/2009 bgehlot           41275 MR-057 Added new fields for APPLA      
 *                       08/03/2010 bgehlot           SMS# 65400 MR-068 Assigned Judge is a dropdown. Get the values from Codes Table CJUDGES.   
 *                       12/16/2010 schoi             SMS #81140: MR-074 Changed code per AFCARS re-mapping for Custody page                 
 *                       03/17/2011 schoi             SMS #97845: MR-074-2 Updated the code to retrieve the following two dates per new logic per AFCARS Phase 2
 *                                                    Date TPR Filed and Date of TPR/VS Achieved (Note: No code change needed for TPR Appealed) 
 *                       03/19/2011 schoi             SMS #97845: MR-074-2 Added the code to display "No" for the TPR Appealed field if the date does not exit                 
 *                       03/25/2011 schoi             SMS #97845: MR-074-2 Updated the code per code peer review; removed the method courtOrderIsTPR
 *                                                    and added a previously available parameter cdHrTypCrtOrds to the method getTPRFiled
 *                       03/31/2011 htvo              SMS #97845: MR-074-2 Modified TPR Filed as the most recent action date; removed Permanent custody outcome from
 *                                                    TPR/VS Achieved as this date is not a final/achieved date as the name may suggest                                                
 *                       05/31/2011 hnguyen           SMS #109405: MR-083 Modified number of recruitment activity dates to display
 **/                       
public class FCCPFamilyDetailFormImpl extends BaseDocumentServiceImpl implements FCCPFamilyDetailForm {

  private FCCPFamilyDAO fccpFamilyDAO;

  private PersonDAO personDAO;

  private PersonRaceDAO personRaceDAO;

  private PersonEthnicityDAO personEthnicityDAO;

  private LegalActionDAO legalActionDAO;

  private LegalStatusDAO legalStatusDAO;

  private PersonAddressDAO personAddressDAO;

  private PersonPhoneDAO personPhoneDAO;

  private EventPersonLinkDAO eventPersonLinkDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private EmpJobHistoryDAO empJobHistoryDAO;

  private EmployeeDAO employeeDAO;

  private NeedsOutcomesDAO needsOutcomesDAO;

  private PptDAO pptDAO;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO;

  private FccpChildDAO fccpChildDAO;

  private ApproversDAO approversDAO;

  private RemovalReasonDAO removalReasonDAO;

  private RemovalCharChildDAO removalCharChildDAO;

  private RemovalCharAdultDAO removalCharAdultDAO;

  private PlanGoalDAO planGoalDAO;

  private CapsCaseDAO capsCaseDAO;

  private PlanSecGoalDAO planSecGoalDAO;

  private PlacementDAO placementDAO;

  private RelativeCareAssmtDAO relativeCareAssmtDAO;

  private WtlpPlanDAO wtlpPlanDAO;

  private YouthDetailDAO youthDetailDAO;

  private EligibilityDAO eligibilityDAO;

  private ProfessionalAssmtDAO professionalAssmtDAO;

  private MedicationDAO medicationDAO;

  private AddressPersonLinkDAO addressPersonLinkDAO;

  private EducationalHistoryDAO educationalHistoryDAO;

  private PlanParticipantDAO planParticipantDAO;

  private ResourcePhoneDAO resourcePhoneDAO;

  private DynamicPlanGoalDAO dynamicPlanGoalDAO;

  private StageDAO stageDAO;

  private AdoInfoDAO adoInfoDAO;

  private AdoInfoCbxDAO adoInfoCbxDAO;

  private AdoInfoCbxSentDAO adoInfoCbxSentDAO;

  private ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO;

  private ExchangeChildDAO exchangeChildDAO;

  private LegalActionOutcomeDAO legalActionOutcomeDAO;
  
  private OutputLaunchEventLinkDAO outputLaunchEventLinkDAO;

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }

  public void setAdoInfoDAO(AdoInfoDAO adoInfoDAO) {
    this.adoInfoDAO = adoInfoDAO;
  }

  public void setAdoInfoCbxDAO(AdoInfoCbxDAO adoInfoCbxDAO) {
    this.adoInfoCbxDAO = adoInfoCbxDAO;
  }

  public void setAdoInfoCbxSentDAO(AdoInfoCbxSentDAO adoInfoCbxSentDAO) {
    this.adoInfoCbxSentDAO = adoInfoCbxSentDAO;
  }

  public void setExcChildAdoInfoCbxDAO(ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO) {
    this.excChildAdoInfoCbxDAO = excChildAdoInfoCbxDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setPlanParticipantDAO(PlanParticipantDAO planParticipantDAO) {
    this.planParticipantDAO = planParticipantDAO;
  }

  public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
    this.educationalHistoryDAO = educationalHistoryDAO;
  }

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public void setMedicationDAO(MedicationDAO medicationDAO) {
    this.medicationDAO = medicationDAO;
  }

  public void setProfessionalAssmtDAO(ProfessionalAssmtDAO professionalAssmtDAO) {
    this.professionalAssmtDAO = professionalAssmtDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setYouthDetailDAO(YouthDetailDAO youthDetailDAO) {
    this.youthDetailDAO = youthDetailDAO;
  }

  public void setWtlpPlanDAO(WtlpPlanDAO wtlpPlanDAO) {
    this.wtlpPlanDAO = wtlpPlanDAO;
  }

  public void setRelativeCareAssmtDAO(RelativeCareAssmtDAO relativeCareAssmtDAO) {
    this.relativeCareAssmtDAO = relativeCareAssmtDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPlanSecGoalDAO(PlanSecGoalDAO planSecGoalDAO) {
    this.planSecGoalDAO = planSecGoalDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setPlanGoalDAO(PlanGoalDAO planGoalDAO) {
    this.planGoalDAO = planGoalDAO;
  }

  public void setRemovalCharAdultDAO(RemovalCharAdultDAO removalCharAdultDAO) {
    this.removalCharAdultDAO = removalCharAdultDAO;
  }

  public void setRemovalCharChildDAO(RemovalCharChildDAO removalCharChildDAO) {
    this.removalCharChildDAO = removalCharChildDAO;
  }

  public void setRemovalReasonDAO(RemovalReasonDAO removalReasonDAO) {
    this.removalReasonDAO = removalReasonDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setPptDAO(PptDAO pptDAO) {
    this.pptDAO = pptDAO;
  }

  public void setNeedsOutcomesDAO(NeedsOutcomesDAO needsOutcomesDAO) {
    this.needsOutcomesDAO = needsOutcomesDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }

  public void setDynamicPlanGoalDAO(DynamicPlanGoalDAO dynamicPlanGoalDAO) {
    this.dynamicPlanGoalDAO = dynamicPlanGoalDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setOutputLaunchEventLinkDAO(OutputLaunchEventLinkDAO outputLaunchEventLinkDAO){
    this.outputLaunchEventLinkDAO = outputLaunchEventLinkDAO;
  }

  public FCCPFAMILYDETAILFORMSO retrieveFccpFamilyDetailForm(FCCPFAMILYDETAILFORMSI fccpFamilyDtlFormsi) {
    FCCPFAMILYDETAILFORMSO fccpFamilyDtlFormso = new FCCPFAMILYDETAILFORMSO();

    HashMap<String, FccpChildCbx> fccpChildCbxList = null;
    int idCase = fccpFamilyDtlFormsi.getUlIdCase();
    int idStageFSU = fccpFamilyDtlFormsi.getUlIdStage();
    int idEventFFCPDtl = fccpFamilyDtlFormsi.getUlIdEvent();
    int idChildPrimary = fccpFamilyDtlFormsi.getUlIdPerson();

    // ******************************** Build the Objects used in the form *****************//

    // get primary child data
    Person primaryChild = retrievePersonData(idChildPrimary);

    // get the list of persons in the plan
    List<EventPersonLink> personsInPlanList = retrieveFFCPPrincipals(idEventFFCPDtl);

    // get FCCP family detail
    FccpFamily fccpFamily = getFccpFamilyPlanData(idEventFFCPDtl);
    int idEventFccpFamily = 0;

    if (fccpFamily == null) { // exit if no Foster Care plan family detail exist
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    idEventFccpFamily = fccpFamily.getIdEvent();
    String fccpFamilyCdPlanType = fccpFamily.getCdPlanType();

    // get SUB stage id
    int idStageSUB = getSUBidStage(idCase, idChildPrimary, fccpFamily);

    NeedsOutcomes needsOutcomes = null; // needs and outcome for that child
    Ppt teamMeetingFTM = null; // get PPT
    Ppt teamMeetingFTM_FLG = null; // get PPT
    Ppt teamMeetingMDT = null; // get PPT
    CnsrvtrshpRemoval cnsrvtrshpRemoval = null; // CNSRVTRSHP_REMOVAL
    FccpChild fccpChild = null; // FCCP_CHILD
    List<PlanGoal> allGoals = null; // place holder to hold all the goals REU, NRE and DFC types
    List<PlanGoal> reunificationPlanGoals = new ArrayList<PlanGoal>(); // goal types
    List<PlanSecGoal> secondaryGoals = null; // goal types
    List<PlanGoal> dfcsStandardGoals = new ArrayList<PlanGoal>(); // goal types
    List<PlanGoal> nonReunificationPlanGoals = new ArrayList<PlanGoal>(); // goal types
    List<Placement> placementHistory = null; // Placement History
    List<ProfessionalAssmt> professionalAssmts = null; // HealthCare Provider
    List<Map> medications = null; // Health Status
    HashMap<String, ProfessionalAssmt> medicalVisits = null; // Health Status
    EducationalHistory educationalHistory = null; // Education
    String DFC_CODE = "DFC";

    // get latest LEGAL_ACTION(s) at the case level
    HashMap<String, LegalAction> lglActnHearingCourtTypes = retrieveLglActnByIdPersonByCdHrTypCrtOrds(idChildPrimary,
                                                                                                      idCase);
    HashMap<String, Map> lglActnOutcomes = retrieveLglActnByIdPersonByOutcomes(idChildPrimary, idCase);
    // STGAP00005906 get the value based on the CodesTables.CLHECOT_FDP Final Disposition entry
    Date dtFinalDisposition = retrieveLatestFinalDispositionLegalAction(idCase, idChildPrimary);
    String cdLegalActAction = CodesTables.CLEGCPS_PFD; // TPR Petition Filed
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    // SMS #97845: MR-074-2
    // Add all TPR values and indicate CLHECOT_TPF as end-dated code, keep for old data
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPF); // This is an end-dated code for TPR - Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR - Biological Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR - Biological and Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR - Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA); // TPR - Adoptive Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA); // TPR - Adoptive Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father
    // End of SMS #97845: MR-074-2
    LegalAction lglActTPRFiled = getTPRFiled(idCase, idChildPrimary, cdHrTypCrtOrds); // Date TPR Filed
    cdLegalActAction = CodesTables.CLEGCPS_APL; // TPR Appeal
    LegalAction lglActTPRAppealed = retrieveLatestLegalActionAppealed(idCase, idChildPrimary, cdLegalActAction,
                                                                      cdHrTypCrtOrds); // TPR Appealed
    // SMS #97845: MR-074-2
    Date lglActTPRAchieved = null;
    lglActTPRAchieved = retrieveLegalActionTPRAchieved(idCase, idChildPrimary);
    List<LegalAction> intAuthPlaceList = retrieveLegalActionIntAuthPlacement(idCase, idChildPrimary);
    // SMS #97845: MR-074-2
    // Remove unnecessary local method determineDtTprAchieved because method retrieveLegalActionTPRAchieved 
    // was updated to accomplish the task required
    // Date lglActTPRAchieved = determineDtTprAchieved(legalActionList);
    Date lgActIntAuthPlace = determineDtIntAuthPlace(intAuthPlaceList);

    // get LEGAL STATUS
    LegalStatus legalStatus = retrieveLegalStatusData(idChildPrimary);

    int idEventFccpChild = 0;

    // get all FCCP_FAMILY goal types
    List<PlanGoal> afterCarePlanGoals = getPlanedGoalsByIdEventByCdGoalType(idEventFccpFamily, CodesTables.CCTPLNTY_AFC);
    secondaryGoals = getSecondaryGoalsByIdEvent(idEventFccpFamily);

    // Placement
    Placement currentPlacement = getCurrentPlacement(idChildPrimary);
    Map relativeCareAssmtData = null;
    Approvers currPlcmtApprovers = null;
    if (currentPlacement != null) {
      relativeCareAssmtData = getRelativeCareAssmt(currentPlacement, idStageSUB);
      currPlcmtApprovers = retrieveApproversByIdEvent(currentPlacement.getIdPlcmtEvent());
    }

    // WTLP detail
    YouthDetail youthDetail = null;
    WtlpPlan wtlpPlan = null;
    Person ydpCoordinator = null;
    Placement wtlpPlcmt = null;
    List<PlanGoal> wtlpPlanGoals = null;
    Eligibility eligibility14 = null;
    LegalStatus chld14LegalStatus = null;
    Person caseMngr = null;

    Date birthDate = primaryChild.getDtPersonBirth();
    if (birthDate != null) {// STGAP00005915 removed 14 year age restriction
      wtlpPlan = wtlpPlanDAO.findWtlpPlanLatestApprovedByIdStageByIdPerson(idStageSUB, idChildPrimary);
      if (wtlpPlan != null) {
        ydpCoordinator = wtlpPlan.getPersonByIdYdpCoord();
        youthDetail = youthDetailDAO.findYouthDetail(idChildPrimary);
        caseMngr = getCaseManagerInfo(idStageSUB);
        wtlpPlcmt = currentPlacement;
        eligibility14 = getEligibility(idStageSUB, idChildPrimary);
        chld14LegalStatus = legalStatus;
        wtlpPlanGoals = getPlanedGoalsByIdEventByCdGoalType(wtlpPlan.getIdEvent().intValue(), "WTL");
      }
    }

    // Participation and Disclosure
    List<PlanParticipant> planParticipants = getPlanParticipants(idEventFFCPDtl);
    Eligibility eligibility = getEligibility(idStageSUB, idChildPrimary);

    // Education
    educationalHistory = getEducation(idChildPrimary);

    // get needs and outcome for that child
    needsOutcomes = getNeedsAndOutcomeData(idStageSUB);

    // get FCCP_CHILD
    fccpChild = getFccpChildData(idStageSUB);

    if (!CodesTables.CCTPLNTY_AFC.equals(fccpFamilyCdPlanType)) { // any plan type other than "After Care" type

      // get PPT
      teamMeetingFTM = getTeamMeetingReviewData(idStageFSU, CodesTables.CMEETTYP_FTM);
      teamMeetingFTM_FLG = getTeamMeetingReviewData(idStageFSU, CodesTables.CMEETTYP_FLG);
      teamMeetingMDT = getTeamMeetingReviewData(idStageFSU, CodesTables.CMEETTYP_MDT);

      // get CNSRVTRSHP_REMOVAL
      cnsrvtrshpRemoval = getCnsrvtrshpRemovalData(idCase, idChildPrimary);

      if (fccpChild != null) {
        // get FCCP_CHILD_CBX ( list of check boxes attached to an FCCP_CHILD selection )
        fccpChildCbxList = getFccpChildCbxData(fccpChild.getIdEvent());
        idEventFccpChild = fccpChild.getIdEvent();
      }

      // Adding GoalTypes to the Collection
      Map<Integer, String> eventGoal = new HashMap<Integer, String>();
      eventGoal.put(idEventFccpFamily, CodesTables.CCTPLNTY_REU);
      eventGoal.put(idEventFccpFamily, CodesTables.CCTPLNTY_NRE);
      eventGoal.put(idEventFccpChild, DFC_CODE);// subsection DFCS in Child Plans does not have Goal reason so no codes
      // tables record
      // get all FCCP_FAMILY goal types
      allGoals = getPlanedGoalsByIdEventsByCdGoalTypes(eventGoal);
      // Resultset returning in date descending order. Using the flag logic to get the latest row
      // for the given category MDT or FTM and exiting the for loop after loading both MDT and FTM objects.
      for (Iterator<PlanGoal> it = allGoals.iterator(); it.hasNext();) {
        PlanGoal planGoal = it.next();
        String cdGoalType = planGoal.getCdGoalTyp();
        if (CodesTables.CCTPLNTY_REU.equalsIgnoreCase(cdGoalType)) {
          reunificationPlanGoals.add(planGoal);
        } else if (CodesTables.CCTPLNTY_NRE.equalsIgnoreCase(cdGoalType)) {
          nonReunificationPlanGoals.add(planGoal);
        } else if (DFC_CODE.equalsIgnoreCase(cdGoalType)) {
          dfcsStandardGoals.add(planGoal);
        }
      }
      reunificationPlanGoals = getPlanedGoalsByIdEventByCdGoalType(idEventFccpFamily, CodesTables.CCTPLNTY_REU);
      nonReunificationPlanGoals = getPlanedGoalsByIdEventByCdGoalType(idEventFccpFamily, CodesTables.CCTPLNTY_NRE);
      dfcsStandardGoals = getPlanedGoalsByIdEventByCdGoalType(idEventFccpChild, "DFC");
      // Placement History
      placementHistory = getPlacementHistory(idChildPrimary, idCase);
      // HealthCare Provider
      professionalAssmts = getHealthCareProviders(idChildPrimary, idCase);
      // Health Status
      medications = getMedications(idChildPrimary);
      medicalVisits = getLatestVisitDateForSpecificReason(idCase, idChildPrimary);
    }

    // ******************************** Build the form *****************//

    // Start building the page
    PreFillData preFillData = new PreFillData();

    // Headers
    retrieveHeaderData(preFillData, fccpFamily, idCase);
    retrieveCaseHeaderData(preFillData, fccpFamily, primaryChild);

    // child info
    retrieveChildInfo(preFillData, idCase, primaryChild, fccpFamily);
    // caretaker & relative data

    retrieveCareTakerAndRelativeInfo(preFillData, idStageFSU, primaryChild, personsInPlanList);

    // caseManager data
    retrieveDFCSCaseMngrInfo(preFillData, idStageFSU);
    // After Case Plan
    retrieveAfterCarePlan(preFillData, primaryChild, fccpFamily, afterCarePlanGoals, idCase, idStageFSU,
                          personsInPlanList);

    // Steps for all Parents
    retrieveStepsForAllParents(preFillData, primaryChild);

    // Secondary Goals
    retrieveSecondaryGoals(preFillData, primaryChild, fccpFamily, secondaryGoals);

    // WTLP
    retrieveWtlp(preFillData, primaryChild, ydpCoordinator, wtlpPlcmt, eligibility14, youthDetail, chld14LegalStatus,
                 caseMngr, wtlpPlan, wtlpPlanGoals);

    // Participation and Disclosure
    retrieveParticipationAndDisclosure(preFillData, primaryChild, fccpFamily, planParticipants, eligibility, idStageSUB);

    // Education
    retrieveEducation(preFillData, primaryChild, fccpFamily, fccpChild, needsOutcomes, educationalHistory, idCase,
                      idStageSUB, currentPlacement);

    if (!CodesTables.CCTPLNTY_AFC.equals(fccpFamilyCdPlanType)) { // any plan type other than "After Care" type
      // Case Tracking & Legal
      retrieveCaseTrackingAndLegalInfo(preFillData, primaryChild, fccpFamily, needsOutcomes, teamMeetingFTM,
                                       teamMeetingFTM_FLG, teamMeetingMDT, cnsrvtrshpRemoval, lglActnHearingCourtTypes,
                                       lglActnOutcomes, legalStatus, dtFinalDisposition, lglActTPRFiled,
                                       lglActTPRAppealed, lglActTPRAchieved, fccpChild, lgActIntAuthPlace);
      // Removal and Separation
      retrieveRemovalAndSeparation(preFillData, primaryChild, fccpFamily, cnsrvtrshpRemoval, fccpChild,
                                   fccpChildCbxList);

      // Reunification Goals
      retrieveReunificationGoals(preFillData, primaryChild, fccpFamily, reunificationPlanGoals);

      // DFCS Standard goals
      retrieveDFCSStandardGoals(preFillData, primaryChild, fccpFamily, dfcsStandardGoals);

      // Non-Reunification goals
      retrieveNonReunificationGoals(preFillData, primaryChild, fccpFamily, nonReunificationPlanGoals);

      // FCCP Child Non-Reunification
      retrieveFccpChildNREConditions(preFillData, primaryChild, fccpFamily, fccpChild, fccpChildCbxList);

      // Current Placement
      retrieveCurrentPlacement(preFillData, primaryChild, needsOutcomes, currentPlacement, relativeCareAssmtData,
                               currPlcmtApprovers, fccpFamily, fccpChild);

      // Placement history
      retrievePlcmtHistory(preFillData, primaryChild, fccpFamily, placementHistory, idCase, idStageSUB);

      // HealthCare Provider
      retrieveHealthCareProvider(preFillData, primaryChild, fccpFamily, professionalAssmts, idCase);

      // Heatlh Status
      retrieveHealthStatus(preFillData, primaryChild, fccpFamily, fccpChild, medications, medicalVisits);

      // STGAP00004867: Added this method to retrieve the list of current Visitation plans instead of the single
      // latest visitation plan
      // Visitation Plan
      retrieveVisitationPlan(preFillData, primaryChild, fccpFamily, fccpChild, idCase, idStageSUB);

      // get open adoption stages
      // List<Map> adoptionStageMapList = stageDAO.findOpenStagesByIdCaseCdStage(idCase, CodesTables.CSTAGES_ADO);

      StagePersonLink spl = getStagePersonLinkForAPersonAndIdCaseAndCdStage(idCase, CodesTables.CSTAGES_ADO,
                                                                            primaryChild.getIdPerson());

      if (spl != null) {// The primary child has an adoption stage
        AdoInfo adoInfo = adoInfoDAO.findLatestAdoptionInformationByStage(spl.getStage().getIdStage());
        retrieveAdoptionInformation(preFillData, primaryChild, adoInfo, idCase);
      }
    }

    fccpFamilyDtlFormso.setPreFillData(preFillData);

    return fccpFamilyDtlFormso;
  }

  private void retrieveHeaderData(PreFillData preFillData, FccpFamily fccpFamily, int idCase) {
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    preFillData.addBookmark(createBookmark(REPORT_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                  capsCase.getCdCaseCounty())));
    preFillData.addBookmark(createBookmark(TODAY_DATE, FormattingHelper.formatDate(DateHelper.getTodayCastorDate())));
    preFillData.addBookmark(createBookmark(CASE_REVIEW_MTHD, Lookup.simpleDecodeSafe(CodesTables.CREVWTYP,
                                                                                     fccpFamily.getCdRevTyp())));
  }

  // given a case id, get the stage id for a person in the stage type "SUB"
  private int getSUBidStage(int idCase, int idPerson, FccpFamily fccpFamily) {
    String cdPlanType = fccpFamily.getCdPlanType();
    StagePersonLink stagePersonLinkSUB = null;
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) { // non AFC find the open SUB stage
      stagePersonLinkSUB = getStagePersonLinkForAPersonAndIdCaseAndCdStage(idCase, CodesTables.CSTAGES_SUB, idPerson);
     // STGAP00013356     
      if (stagePersonLinkSUB == null) {
        //If FCC stage is closed and there exists an Open ADO stage get closed SUB stage
        List<Integer> idPersonList = new ArrayList<Integer>();
        idPersonList.add(idPerson);
        List<Person> primaryChildWithOpenADO = stagePersonLinkDAO.findPersonsByIdCaseByIdPersonsByCdPersonRoleByCdStagePersTypeByCdADOStage(idCase,
                                                                                                                   idPersonList,
                                                                                                                   CodesTables.CROLES_PC,
                                                                                                                   CodesTables.CPRSNTYP_PRN);
       if( primaryChildWithOpenADO != null && !primaryChildWithOpenADO.isEmpty()){
         stagePersonLinkSUB = getStagePersonLinkClosedForAPersonAndIdCaseAndCdStage(idCase, CodesTables.CSTAGES_SUB, idPerson);
       }
      }
    } else { // After care find the closed SUB stage
      stagePersonLinkSUB = getStagePersonLinkClosedForAPersonAndIdCaseAndCdStage(idCase, CodesTables.CSTAGES_SUB,
                                                                                 idPerson);
      if (stagePersonLinkSUB == null) {
        stagePersonLinkSUB = getStagePersonLinkForAPersonAndIdCaseAndCdStage(idCase, CodesTables.CSTAGES_SUB, idPerson);
      }
    }

    int idStageSUB = stagePersonLinkSUB.getStage().getIdStage(); // stage id for stage type of SUB
    return idStageSUB;
  }

  private FccpFamily getFccpFamilyPlanData(int idEvent) {
    FccpFamily fccpFamily = fccpFamilyDAO.findFCCPFamilyByIdEvent(idEvent);
    return fccpFamily;
  }

  private NeedsOutcomes getNeedsAndOutcomeData(int idStage) {
    NeedsOutcomes needsOutcomes = needsOutcomesDAO.findNeedsAndOutcomesLatestApprovedByIdStage(idStage);

    return needsOutcomes;
  }

  private Ppt getTeamMeetingReviewData(int idStageFSU, String cdPptType) {
    Ppt teamMeeting = pptDAO.findLatestPptByIdStageByCdEventTypeByCdPptType(idStageFSU, CodesTables.CEVNTTYP_PPT,
                                                                            cdPptType);

    return teamMeeting;
  }

  private FccpChild getFccpChildData(int idStageSUB) {
    FccpChild fccpChild = fccpChildDAO.findLatestChildPlanByIdStageByCdEventType(idStageSUB);

    return fccpChild;
  }

  private HashMap<String, FccpChildCbx> getFccpChildCbxData(int idEvent) {
    HashMap<String, FccpChildCbx> fccpCbxList = new HashMap<String, FccpChildCbx>();
    // List of child boxes
    List<FccpChildCbx> fccpChildCbxs = fccpChildDAO.findChildCheckBoxByIdEvent(idEvent);

    if (fccpChildCbxs != null && !fccpChildCbxs.isEmpty()) {
      for (Iterator<FccpChildCbx> it = fccpChildCbxs.iterator(); it.hasNext();) {
        FccpChildCbx fccpChildCbx = it.next();
        fccpCbxList.put(fccpChildCbx.getCdCbxCodeType() + "_" + fccpChildCbx.getCdCbx(), fccpChildCbx);
      }
    }
    return fccpCbxList;
  }

  private List<PlanGoal> getPlanedGoalsByIdEventsByCdGoalTypes(Map<Integer, String> eventGoal) {

    List<PlanGoal> planGoalList = dynamicPlanGoalDAO.findFCGSByIdEventsByCdGoalTypes(eventGoal);

    return planGoalList;
  }

  private List<PlanGoal> getPlanedGoalsByIdEventByCdGoalType(int idEvent, String cdGoalType) {

    List<PlanGoal> planGoalList = planGoalDAO.findFCGSByIdEventByCdGoalType(idEvent, cdGoalType);

    return planGoalList;
  }

  private List<PlanSecGoal> getSecondaryGoalsByIdEvent(int idEvent) {
    // Retrieve sec plan goals based on event id.
    List<PlanSecGoal> fosterCareSecGoalsList = planSecGoalDAO.findFosterCareSecGoalsList(idEvent);
    return fosterCareSecGoalsList;
  }

  // find latest removal information for that child for that case
  private CnsrvtrshpRemoval getCnsrvtrshpRemovalData(int idCase, int idVictim) {
    List<CnsrvtrshpRemoval> cnsrvtrshpRemovals = cnsrvtrshpRemovalDAO
                                                                     .findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(
                                                                                                                     idCase,
                                                                                                                     idVictim);

    return cnsrvtrshpRemovals.get(0);
  }

  private void retrieveCaseHeaderData(PreFillData preFillData, FccpFamily fccpFamily, Person primaryChild) {

    if (primaryChild != null) {
      preFillData.addBookmark(createBookmark(CHILD_INFO_CHLD_FULLNAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      preFillData.addBookmark(createBookmark(FCCP_FAM_ID_CASE, fccpFamily.getCapsCase().getIdCase()));
      preFillData.addBookmark(createBookmark(DT_CURR_CASE_RVW_DT,
                                             FormattingHelper.formatDate(fccpFamily.getDtCurrRev())));
      preFillData.addBookmark(createBookmark(DT_NEXT_CASE_RVW_DT,
                                             FormattingHelper.formatDate(fccpFamily.getDtNextReview())));
    }
  }

  private Person retrievePersonData(int idPerson) {
    Person person = personDAO.findPersonByIdPerson(idPerson);

    return person;
  }

  private String retrievePersonRaceData(int idPerson) {
    List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(idPerson);
    StringBuffer raceList = new StringBuffer();
    if (personRaceList != null && !personRaceList.isEmpty()) {
      for (Iterator<PersonRace> it = personRaceList.iterator(); it.hasNext();) {
        PersonRace personRace = it.next();
        raceList.append(Lookup.simpleDecodeSafe(CodesTables.CRACE, personRace.getCdRace()));
      }
    }

    return raceList.toString();
  }

  private PersonEthnicity retrievePersonEthnicityData(int idPerson) {
    PersonEthnicity personEthnicity = personEthnicityDAO.findLatestPersonEthnicityByIdPerson(idPerson);

    return personEthnicity;
  }

  private void retrieveChildInfo(PreFillData preFillData, int idCase, Person primaryChild, FccpFamily fccpFamily) {

    String initialReview = null;
    int idPerson = primaryChild.getIdPerson().intValue();

    Person person = retrievePersonData(idPerson);
    String personRaceList = retrievePersonRaceData(idPerson);
    PersonEthnicity personEthnicity = retrievePersonEthnicityData(idPerson);
    LegalStatus legalStatus = retrieveLegalStatusData(idPerson);
    Map legalActionMap = retrieveLglActnByIdPersonByOutcome(idPerson, idCase);

    if (person != null) {
      preFillData.addBookmark(createBookmark(CHILD_FULL_NAME, getFullName(person)));
      preFillData.addBookmark(createBookmark(DT_CHILD_DOB, FormattingHelper.formatDate(person.getDtPersonBirth())));
      preFillData.addBookmark(createBookmark(CHILD_GENDER, person.getCdPersonSex()));
    }
    preFillData.addBookmark(createBookmark(CHILD_RACE, personRaceList));

    if (personEthnicity != null) {
      String cdEthnicity = personEthnicity.getCdEthnicity();

      preFillData.addBookmark(createBookmark(CHILD_ETHNICITY,
                                             Lookup.simpleDecodeSafe(CodesTables.CINDETHN, cdEthnicity)));
    }

    if (fccpFamily != null) {
      preFillData.addBookmark(createBookmark(CHILD_PLAN_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCTPLNTY,
                                                                                      fccpFamily.getCdPlanType())));
      String cdPlanType = fccpFamily.getIndInitReview();
      if ("I".equals(cdPlanType)) {
        initialReview = "Initial";
      } else if ("R".equals(cdPlanType)) {
        initialReview = "Review";
      } else {
        initialReview = "";
      }
      preFillData.addBookmark(createBookmark(CHILD_INTL_RVW, initialReview));
    }

    if (legalStatus != null) {
      preFillData.addBookmark(createBookmark(CHILD_LEGAL_STATUS,
                                             Lookup.simpleDecodeSafe(CodesTables.CLEGSTAT,
                                                                     legalStatus.getCdLegalStatStatus())));
      //MR-057 Adding the date status effective
      preFillData.addBookmark(createBookmark(DT_CHILD_LEGAL_STATUS,
                                             FormattingHelper.formatDate(legalStatus.getDtLegalStatStatusDt())));
    }

    //MR-068 Display the decode of the judge code as the Assigned Judge has been changed to the Codes Table
    String assignedJudge = fccpFamily.getCdAssgnJudge() != null ? fccpFamily.getCdAssgnJudge(): fccpFamily.getNmAssgnJudge();    
    String assignedJudgeDecode = "";
    if (assignedJudge == null) {
      assignedJudgeDecode = "Unknown";
    }else{
      assignedJudgeDecode = Lookup.simpleDecodeSafe(CodesTables.CJUDGES, assignedJudge);
      if("".equals(assignedJudgeDecode)){
        assignedJudgeDecode = fccpFamily.getNmAssgnJudge();
      }
    }
    preFillData.addBookmark(createBookmark(ASSIGNED_JUDGE, assignedJudgeDecode));
    preFillData.addBookmark(createBookmark(DT_INTL_CP_FILED, FormattingHelper.formatDate(fccpFamily.getDtOrigSub())));

    // STGAP00005914 Removing CareTaker Information Section
  }

  private PersonAddress retrievePrimaryPersonAddressData(int idPerson) {
    PersonAddress personAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(idPerson);

    return personAddress;
  } // end retrieveChildInfo

  private List<Map> retrievePrimaryPersonAddressData(Collection<Integer> idPersons) {
    List<Map> personListAddress = null;
    if (idPersons != null && !idPersons.isEmpty()) {
      personListAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(idPersons);
    }

    return personListAddress;
  } // end retrieveChildInfo

  private PersonAddress getPrimaryPersonAddress(Person person) {
    PersonAddress personAddress = null;
    if (person != null) {
      Collection<AddressPersonLink> personAddresses = person.getAddressPersonLinks();
      if (personAddresses != null && !personAddresses.isEmpty()) {
        for (Iterator<AddressPersonLink> it = personAddresses.iterator(); it.hasNext();) {
          AddressPersonLink addressPersonLink = it.next();
          if (addressPersonLink.getIndPersAddrLinkPrimary().equals("Y")
              && DateHelper.isNull(addressPersonLink.getDtPersAddrLinkEnd())) {
            personAddress = addressPersonLink.getPersonAddress();
            break;
          }
        } // end for loop
      } // end personAddress
    } // end person
    return personAddress;
  }

  private PersonAddress getPersonBusinessAddress(Person person) {
    PersonAddress personAddress = null;
    Collection<String> cdPersAddrLinkTypes = new ArrayList<String>();
    cdPersAddrLinkTypes.add(CodesTables.CADDRTYP_BS);

    if (person != null) {
      personAddress = getPersonBusinessAddress(person.getIdPerson().intValue(), cdPersAddrLinkTypes);
    } // end person

    return personAddress;
  }

  private String buildStreetAddressLine(PersonAddress personAddress) {
    StringBuffer addressBuffer = new StringBuffer();
    if (personAddress != null) {
      addressBuffer.append(personAddress.getAddrPersAddrStLn1());
    }

    return addressBuffer.toString();
  }

  private String buildCityStateLine(PersonAddress personAddress) {
    StringBuffer addressBuffer = new StringBuffer();

    if (personAddress != null) {
      String city = personAddress.getAddrPersonAddrCity();
      if (city == null) {
        city = SPACE;
      }
      String state = personAddress.getCdPersonAddrState();
      if (state == null) {
        state = SPACE;
      }
      String zipCode = personAddress.getAddrPersonAddrZip();
      if (zipCode == null) {
        zipCode = SPACE;
      }

      addressBuffer.append(city + ", " + state + SPACE + zipCode);
    }

    return addressBuffer.toString();
  }

  private List<EventPersonLink> retrieveFFCPPrincipals(int idEvent) {
    List<EventPersonLink> personList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idEvent);

    return personList;
  }

  private List<Map> retrieveStagePrincipalList(int idStage) {
    // Retrieve all persons in this stage
    List<Map> stagePrincipalList = stagePersonLinkDAO.findAllPrincipalsForStage(CodesTables.CPRSNTYP_PRN, idStage);
    return stagePrincipalList;
  } // end retrieveStagePrincipalList

  private String retrievePrimaryPersonPhoneData(int idPerson) {
    String phoneNbr = null;
    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    PersonPhone personPhone = null;
    if (idPerson != 0) {
      personPhone = personPhoneDAO.findPersonPhoneByIdPersonAndMaxDate(idPerson, maxDate);
    }

    if (personPhone != null) {
      phoneNbr = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone());
    }
    return phoneNbr;
  }

  // if a person has a primary active & valid business office phone, select it, otherwise get the next active & valid
  // business phone available
  private String getPersonOfficePhone(int idPerson) {
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    return getPersonOfficePhoneNbr(idPerson, phoneTypes);
  }

  private String getPersonOfficeFaxPhone(int idPerson) {
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BF); // Business Fax

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

  private PersonAddress getPersonBusinessAddress(int idPerson, Collection<String> cdPersAddrLinkTypes) {
    PersonAddress primPersonAddress = null;
    List<AddressPersonLink> addressPersonLinks = addressPersonLinkDAO
                                                                     .findAddressPersonLinkByIdPersonByCdPersAddrLinkType(
                                                                                                                          idPerson,
                                                                                                                          cdPersAddrLinkTypes);

    for (Iterator<AddressPersonLink> it = addressPersonLinks.iterator(); it.hasNext();) {

      AddressPersonLink addressPersonLink = it.next();
      if (addressPersonLink.getPersonAddress() != null) {
        primPersonAddress = addressPersonLink.getPersonAddress();
        break;
      }
    } // end for loop
    return primPersonAddress;

  }

  // STGAP00005914 Adding Care Taker Information Section back
  private void bulidCareTakerHeader(PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_NON_AFC_1, FCM05O00);
    preFillData.addFormDataGroup(group);
  }

  private void buildCareTakerInfo(PreFillData preFillData, String relationship, String fullName, Person personInPlan,
                                  PersonAddress personAddress, String phoneNbr) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CARETAKER_INFO, FCM05O00);
    group.addBookmark(createBookmark(CARETAKER_TYPE, relationship));
    group.addBookmark(createBookmark(CARETAKER_FULLNAME, fullName));
    if (personInPlan != null) {
      group.addBookmark(createBookmark(CARETAKER_DOB, FormattingHelper.formatDate(personInPlan.getDtPersonBirth())));
    }
    group.addBookmark(createBookmark(CARETAKER_ADDRESS_STREET, buildStreetAddressLine(personAddress)));
    group.addBookmark(createBookmark(CARETAKER_ADDRESS_STATE, buildCityStateLine(personAddress)));
    group.addBookmark(createBookmark(CARETAKER_PHONE_NBR, phoneNbr));
    group.addBookmark(createBookmark(CARETAKER_COMMENTS, (personInPlan != null ? personInPlan.getTxtPersonAddlCmnts()
                                                                              : null)));

    preFillData.addFormDataGroup(group);
  }

  // STGAP00005914 Adding Relative information section back
  private void bulidRelativeHeader(PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_NON_AFC, FCM05O00);
    preFillData.addFormDataGroup(group);
  }

  private void buildRelativeInfo(PreFillData preFillData, String relationship, String fullName, String sideOfFamily,
                                 PersonAddress personAddress, String phoneNbr, Person personInPlan) {
    FormDataGroup group = createFormDataGroup(TMPLAT_RELATIVE_INFO, FCM05O00);

    group.addBookmark(createBookmark(RELATIVE_TYPE, relationship));
    group.addBookmark(createBookmark(RELATIVE_FULLNAME, fullName));
    group.addBookmark(createBookmark(RELATIVE_SIDE_OF_FAMILY, sideOfFamily));
    group.addBookmark(createBookmark(RELATIVE_ADDRESS_STREET, buildStreetAddressLine(personAddress)));
    group.addBookmark(createBookmark(RELATIVE_ADDRESS_STATE, buildCityStateLine(personAddress)));
    group.addBookmark(createBookmark(RELATIVE_PHONE_NBR, phoneNbr));
    group.addBookmark(createBookmark(RELATIVE_COMMENTS, (personInPlan != null ? personInPlan.getTxtPersonAddlCmnts()
                                                                             : null)));

    preFillData.addFormDataGroup(group);
  }

  private void retrieveCareTakerAndRelativeInfo(PreFillData preFillData, int idStageFSU, Person primaryChild,
                                                List<EventPersonLink> personsInPlanList) {
    // return the list of principals in the current stage for that child
    List<Map> stagePrincipalList = retrieveStagePrincipalList(idStageFSU);
    int idPrimaryChild = primaryChild.getIdPerson().intValue();
    boolean careTakerExist = false;
    boolean relativeExist = false;

    if (personsInPlanList != null && !personsInPlanList.isEmpty()) {
      List<HashMap> caretakerList = new ArrayList<HashMap>();
      List<HashMap> relativeList = new ArrayList<HashMap>();
      List<Integer> idPersonInPlanList = new ArrayList<Integer>();
      Map<Integer, String> indCaregiverList = new HashMap<Integer, String>();
      for (Iterator<EventPersonLink> it = personsInPlanList.iterator(); it.hasNext();) {
        EventPersonLink eventPersonLink = it.next();
        idPersonInPlanList.add(eventPersonLink.getPerson().getIdPerson());
        indCaregiverList.put(eventPersonLink.getPerson().getIdPerson(), eventPersonLink.getIndCaregiver());
      }

      List<Person> personObjList = personDAO.findPersonByIdPerson(idPersonInPlanList);
      // get list of primary addresses for the persons in the plan
      List<Map> personAddList = retrievePrimaryPersonAddressData(idPersonInPlanList);
      Map<Integer, PersonAddress> personAddListByIdPerson = new HashMap<Integer, PersonAddress>();
      for (Iterator<Map> it1 = personAddList.iterator(); it1.hasNext();) {
        Map map = it1.next();
        personAddListByIdPerson.put((Integer) map.get("idPerson"), (PersonAddress) map.get("personAddress"));
      }

      for (Iterator<Person> it2 = personObjList.iterator(); it2.hasNext();) {
        Person personInPlan = it2.next();
        int idPersonInPlan = personInPlan.getIdPerson().intValue();
        String fullName = getFullName(personInPlan);
        String relationship = null;
        String sideOfFamily = null;

        PersonAddress personAddress = (PersonAddress) personAddListByIdPerson.get(idPersonInPlan);
        // get the the relative type
        if (stagePrincipalList != null && !stagePrincipalList.isEmpty()) {
          for (Iterator<Map> it3 = stagePrincipalList.iterator(); it3.hasNext();) {
            Map map = it3.next();
            if (idPersonInPlan == ((Integer) map.get("ID_PERSON")).intValue()) {
              relationship = getRelationshipType((String) map.get("CD_STAGE_PERS_TYPE"), (String) map.get("CD_REL_INT"));
              sideOfFamily = Lookup
                                   .simpleDecodeSafe(CodesTables.CSIDEFAM, (String) map.get("CD_PERSON_SIDE_OF_FAMILY"));
              break;
            }
          }
        }
        // get caregivers and adult relatives (18 yrs old and up ) info
        if ("Y".equals((String) indCaregiverList.get(idPersonInPlan))) {
          HashMap<String, Object> caretaker = new HashMap<String, Object>();
          caretaker.put("RELA", relationship);
          caretaker.put("NAME", fullName);
          caretaker.put("PERS", personInPlan);
          caretaker.put("ADDR", personAddress);
          caretaker.put("ID", idPersonInPlan);
          caretakerList.add(caretaker);
          careTakerExist = true;
        } else if ((idPersonInPlan != idPrimaryChild)
                   && (DateHelper.getAge(personInPlan.getDtPersonBirth()) >= EIGHTEEN)) {
          HashMap<String, Object> relative = new HashMap<String, Object>();
          relative.put("RELA", relationship);
          relative.put("NAME", fullName);
          relative.put("PERS", personInPlan);
          relative.put("SIDE", sideOfFamily);
          relative.put("ADDR", personAddress);
          relative.put("ID", idPersonInPlan);
          relativeList.add(relative);
          relativeExist = true;
        }
      }

      // If not one house hold member belong to a group, build at least one row for that group for display purpose
      Integer zero = Integer.valueOf(0);
      if (!careTakerExist) {
        HashMap<String, Object> caretaker = new HashMap<String, Object>();
        caretaker.put("RELA", null);
        caretaker.put("NAME", null);
        caretaker.put("PERS", null);
        caretaker.put("ADDR", null);
        caretaker.put("ID", zero);
        caretakerList.add(caretaker);
      }
      if (!relativeExist) {
        HashMap<String, Object> caretaker = new HashMap<String, Object>();
        caretaker.put("RELA", null);
        caretaker.put("NAME", null);
        caretaker.put("SIDE", null);
        caretaker.put("ADDR", null);
        caretaker.put("ID", zero);
        relativeList.add(caretaker);
      }
      // STGAP00005914 Adding Code For CareTaker Information and Relative Display Back
      buildCareTakerAndRelativeDisplay(preFillData, caretakerList, relativeList);
    }
  } // end retrieveCareTakerAndRelativeInfo()

  // STGAP00005914 Adding Code For CareTaker Information and Relative Display Back
  private void buildCareTakerAndRelativeDisplay(PreFillData preFillData, List<HashMap> careTakerList,
                                                List<HashMap> relativeList) {
    if (careTakerList != null && !careTakerList.isEmpty()) {
      bulidCareTakerHeader(preFillData);
      for (Iterator<HashMap> it = careTakerList.iterator(); it.hasNext();) {
        HashMap personDtl = it.next();
        if (personDtl != null) {
          buildCareTakerInfo(preFillData, (String) personDtl.get("RELA"), (String) personDtl.get("NAME"),
                             (Person) personDtl.get("PERS"), (PersonAddress) personDtl.get("ADDR"),
                             retrievePrimaryPersonPhoneData((Integer) personDtl.get("ID")));
        } // end if personDtl
      } // end for
    } // end if careTakerList

    // STGAP00005914 Adding code for relative information Back
    if (relativeList != null && !relativeList.isEmpty()) {
      bulidRelativeHeader(preFillData);
      for (Iterator<HashMap> it2 = relativeList.iterator(); it2.hasNext();) {
        HashMap personDtl = it2.next();
        if (personDtl != null) {
          buildRelativeInfo(preFillData, (String) personDtl.get("RELA"), (String) personDtl.get("NAME"),
                            (String) personDtl.get("SIDE"), (PersonAddress) personDtl.get("ADDR"),
                            retrievePrimaryPersonPhoneData((Integer) personDtl.get("ID")),
                            (Person) personDtl.get("PERS"));
        }
      } // end for
    } // end if relativeList

  } // end buildCareTakerAndRelativeDisplay()

  private void buildDFCSCaseMngrInfo(PreFillData preFillData, String caseMngrFullName, String caseMngrStAddressLn,
                                     String caseMngrStZipAddressLn, String caseMngrPhoneNbr, String supervisorName,
                                     String supervisorPhnNbr) {

    preFillData.addBookmark(createBookmark(CASEMNGR_NAME, caseMngrFullName));
    preFillData.addBookmark(createBookmark(CASEMNGR_ADDRESS_STREET, caseMngrStAddressLn));
    preFillData.addBookmark(createBookmark(CASEMNGR_STATE_ZIP, caseMngrStZipAddressLn));
    preFillData.addBookmark(createBookmark(CASEMNGR_PHONE_NBR, caseMngrPhoneNbr));
    preFillData.addBookmark(createBookmark(CASEMNGR_SPRVISOR_NAME, supervisorName));
    preFillData.addBookmark(createBookmark(CASEMNGR_SPRVISOR_PHONE_NBR, supervisorPhnNbr));
  }

  private List<Map> getEmpJobHistory(int idPerson) {
    List<Map> mapList = empJobHistoryDAO.findEmpJobHistoryByIdPerson(idPerson);

    return mapList;
  }

  private Office getEmployeeOffice(int idPerson) {
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);
    return employee.getOffice();
  }

  private Map<String, String> getOfficeAddress(Office office) {
    MailCode mailCode = office.getMailCode();
    HashMap<String, String> officeAddress = new HashMap<String, String>();
    if (mailCode != null) {
      officeAddress.put("StLn1", mailCode.getAddrMailCodeStLn1());
      officeAddress.put("City", mailCode.getAddrMailCodeCity());
      officeAddress.put("State", "GA");
      officeAddress.put("Zip", mailCode.getAddrMailCodeZip());
    }
    return officeAddress;
  }

  private String createOfficeStateZipAddrLn(Map addrMap) {
    StringBuffer addrBuff = new StringBuffer();

    if (addrMap != null) {
      addrBuff.append((String) addrMap.get("City") + ", " + (String) addrMap.get("State") + " "
                      + (String) addrMap.get("Zip"));

    }
    return addrBuff.toString();
  }

  private void retrieveDFCSCaseMngrInfo(PreFillData preFillData, int idStage) {
    // get case manager data
    // STGAP00007801 Changing DAO to pull back current Case Managers and Historical Case Managers
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    Person caseMngr = stagePersonLink.getPerson();
    int idCaseMngr = caseMngr.getIdPerson().intValue();
    List<Map> mapList = getEmpJobHistory(idCaseMngr);
    Map map = mapList.get(0); // currently there is only one entry per employee in EmpJobHistory for Georgia
    Office caseMngrOffice = getEmployeeOffice(idCaseMngr);
    Map caseMngrOfficeAddressMap = getOfficeAddress(caseMngrOffice);
    String caseMngrPhnNbr = getPersonOfficePhone(idCaseMngr);

    // get case manager supervisor data
    int idSupervisor = ((Integer) map.get("personByIdJobPersSupv")).intValue();
    String supervisorPhnNbr = getPersonOfficePhone(idSupervisor);
    buildDFCSCaseMngrInfo(preFillData, getFullName(caseMngr), (String) caseMngrOfficeAddressMap.get("StLn1"),
                          createOfficeStateZipAddrLn(caseMngrOfficeAddressMap), caseMngrPhnNbr,
                          (String) map.get("nmPersonFull"), supervisorPhnNbr);

  } // end retrieveDFCSCaseMngrInfo

  private LegalStatus retrieveLegalStatusData(int idPerson) {
    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPerson);

    return legalStatus;
  }

  private HashMap<String, LegalAction> retrieveLglActnByIdPersonByCdHrTypCrtOrds(int idPerson, int idCase) {
    HashMap<String, LegalAction> legalActionsBycdHrTypCrtOrds = new HashMap<String, LegalAction>();
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_ADJ); // Adjudicatory
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_DTH); // Detention Hearing (72hr)
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_DIS); // Dispositional
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_ETO); // Extension Order
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_NRE); // Non-Reunification
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_PRM); // Permanency
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_SHC); // Shelter Care
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_SUP); // Supplemental

    if (cdHrTypCrtOrds != null && !cdHrTypCrtOrds.isEmpty()) {
      List<LegalAction> legalActionList = legalActionDAO
                                                        .findLegalActionByIdCaseByIdPersonByCdHrTypCrtOrds(idCase,
                                                                                                           idPerson,
                                                                                                           cdHrTypCrtOrds);
      for (Iterator<LegalAction> it = legalActionList.iterator(); it.hasNext();) {
        LegalAction legalAction = it.next();
        if (!legalActionsBycdHrTypCrtOrds.containsKey(legalAction.getCdHrTypCrtOrd())) {
          legalActionsBycdHrTypCrtOrds.put(legalAction.getCdHrTypCrtOrd(), legalAction);
        } else {// STGAP00005911
          // Do nothing because latest court order type is already in list
          // since lookup returns the latest first.
        }
      }
    }
    return legalActionsBycdHrTypCrtOrds;
  }

  // get back the approval date for latest approved "Judge Approved Case Plan" outcome
  private Map retrieveLglActnByIdPersonByOutcome(int idPerson, int idCase) {
    // CLEGLOUT_JAC = Judge Approved Case Plan
    Map legalActionMap = legalActionDAO.findLegalActionLatestByIdCaseByIdPersonByCdOutcome(idCase, idPerson,
                                                                                           CodesTables.CLEGLOUT_JAC);

    return legalActionMap;
  }

  // given a case, person and a list of cdOutcomes, give me the latest corresponding list of legal actions
  private HashMap<String, Map> retrieveLglActnByIdPersonByOutcomes(int idPerson, int idCase) {
    List<String> cdOutcomes = new ArrayList<String>();
    HashMap<String, Map> legalActionByOutcomeList = new HashMap<String, Map>();
    // List of outcomes
    cdOutcomes.add(CodesTables.CLEGLOUT_DSR); // Diligent Search Ruling Granted
    cdOutcomes.add(CodesTables.CLEGLOUT_IAP); // Initial authorization for placement

    if (cdOutcomes != null && !cdOutcomes.isEmpty()) {
      List<Map> legalActionMaps = legalActionDAO.findLegalActionLatestByIdCaseByIdPersonByCdOutcomes(idCase, idPerson,
                                                                                                     cdOutcomes);
      for (Iterator<Map> it = legalActionMaps.iterator(); it.hasNext();) {
        Map legalActionMap = it.next();
        legalActionByOutcomeList.put((String) legalActionMap.get("cdOutcome"), legalActionMap);
      }
    }

    return legalActionByOutcomeList;
  }

  // given a legalAction give me the date where the last action was an approval
  private Date retrieveApprovalDateOfLglActionByHearingTypeCrtOrds(LegalAction legalAction) {
    Date approvalDate = null;
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    if (legalAction != null) {
      Approvers approvers = approversDAO.findApproverByIdEventIfEventIsApproved(legalAction.getIdLegalActEvent(),
                                                                                cdEventStatus);
      if (approvers != null) {
        approvalDate = approvers.getDtApproversDetermination();
      }
    }
    return approvalDate;
  }

  private Approvers retrieveApproversByIdEvent(Integer idEvent) {
    Approvers approvers = null;
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    if (idEvent != null && idEvent.intValue() != 0) {
      approvers = approversDAO.findApproverByIdEventIfEventIsApproved(idEvent.intValue(), cdEventStatus);
    }
    return approvers;
  }

  private List<LegalAction> retrieveLegalActionIntAuthPlacement(int idCase, int idPerson) {
    String[] cdOutcomes = new String[1];
    cdOutcomes[0] = CodesTables.CLEGLOUT_IAP; // Initial Authorization Placement
    List<LegalAction> legalActionsQueriedList = legalActionDAO
                                                              .findLegalActionListByIdCaseByidPersonBycdOutcomes(
                                                                                                                 idCase,
                                                                                                                 idPerson,
                                                                                                                 cdOutcomes);

    return legalActionsQueriedList;
  }

  // Find the latest date of approved or completed legal action for any of the listed actions or outcomes
  // SMS #97845: MR-074-2
  // Updated the return type of this method from List<LegalAction> to Date
  // Display the most recent date from Items #1, #2 and #3 (The event status of Legal Action should be approved or completed):
  // 1. Most recent Court Action Date for the Legal Action with Action type of any Voluntary Surrender 
  //    (VLM - VS Biological Mother, VAM - VS Adoptive Mother, VBF - VS Biological Father, VSF - VS Biological and Legal Father, 
  //    VLS - VS Legal Father, VAF - VS Adoptive Father, VPF - VS Putative Father)
  // 2. Most recent Court Order Date for the Legal Action with Hearing/Court Order Type of any TPR value 
  //    (TFA – TPR Adoptive Father, TPA – TPR Adoptive Mother, TFB – TPR Biological Father, TFF – TPR Legal Father, 
  //    TFL – TPR Biological and Legal Father, TPM – TPR Biological Mother, TPP – TPR Putative Father) 
  //    if the Action Type is either ‘Hearing’ or ‘Received Court Order’, 
  //    and the Outcome is ‘TPR Granted (CLEGLOUT_TPG)’ 
  // 3. Most recent Court Order Date for Legal Action if the Action Type is either ‘Hearing’ or ‘Received Court Order’ 
  //    and the Outcome is 'Deceased Parents - Permanent Custody to DHR (CLEGLOUT_DPC)'

  private Date retrieveLegalActionTPRAchieved(int idCase, int idPerson) {
    List<String> cdLegalActActions = new ArrayList<String>();
    // SMS #97845: MR-074-2
    // Add missing Voluntary Surrender values including the new Voluntary Surrender - Putative Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VLM); // Voluntary Surrender - Biological Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VLF); // Voluntary Surrender - Father (NOTE: This has been end-dated, keep for old data)
    cdLegalActActions.add(CodesTables.CLEGCPS_VAM); // Voluntary Surrender - Adoptive Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAF); // Voluntary Surrender - Adoptive Father 
    cdLegalActActions.add(CodesTables.CLEGCPS_VSF); // Voluntary Surrender - Legal/Biological Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VLS); // Voluntary Surrender - Legal Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VBF); // Voluntary Surrender - Biological Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VPF); // Voluntary Surrender - Putative Father
    
    // SMS #97845: MR-074-2
    List<String> cdLegalActActionsOth = new ArrayList<String>();
    cdLegalActActionsOth.add(CodesTables.CLEGCPS_HRG); // Hearing
    cdLegalActActionsOth.add(CodesTables.CLEGCPS_RCO); // Receive Court Order
        
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    // SMS #97845: MR-074-2
    // Add missing TPR values including the new TPR - Putative Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPF); // TPR - Father (NOTE: This has been end-dated, keep for old data)
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR - Biological Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA); // TPR - Adoptive Mother
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA); // TPR - Adoptive Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR - Biological and Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR - Legal Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father

    Date dtMostRecentTPRVS = null;
    dtMostRecentTPRVS = legalActionDAO.findTheMostRecentDateTprAchievedLegalActionsDateForCase(idCase,
                                                                                     idPerson,
                                                                                     cdLegalActActions,
                                                                                     cdLegalActActionsOth,
                                                                                     cdHrTypCrtOrds,
                                                                                     CodesTables.CLEGLOUT_TPG,
                                                                                     CodesTables.CLEGLOUT_DPC); 
    if (dtMostRecentTPRVS != null) {
      return dtMostRecentTPRVS;
    }
    return dtMostRecentTPRVS;
  }

  private LegalAction retrieveLatestLegalActionFiled(int idCase, int idPerson, String cdLegalActAction,
                                                     Collection<String> cdHrTypCrtOrds) {
    LegalAction legalAction = legalActionDAO
                                            .findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                                               idCase,
                                                                                                               idPerson,
                                                                                                               cdLegalActAction,
                                                                                                               cdHrTypCrtOrds,
                                                                                                               "F");

    return legalAction;
  }

  private LegalAction retrieveLatestLegalActionAppealed(int idCase, int idPerson, String cdLegalActAction,
                                                        Collection<String> cdHrTypCrtOrds) {
    LegalAction legalAction = legalActionDAO
                                            .findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                                               idCase,
                                                                                                               idPerson,
                                                                                                               cdLegalActAction,
                                                                                                               cdHrTypCrtOrds,
                                                                                                               "A");

    return legalAction;
  }

  private Date retrieveLatestFinalDispositionLegalAction(int idCase, int idPerson) {
    LegalAction legalAction = legalActionDAO.findLegalActionByIdCaseByIdPersonByCdHrTypCrtOrd(idCase, idPerson,
                                                                                              CodesTables.CLHECOT_FDP);

    return (legalAction != null ? legalAction.getDtCrtOrdDate() : null);
  }

  private void retrieveCaseTrackingAndLegalInfo(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                                NeedsOutcomes needsOutcomes, Ppt teamMeetingFTM,
                                                Ppt teamMeetingFTM_FLG, Ppt teamMeetingMDT,
                                                CnsrvtrshpRemoval cnsrvtrshpRemoval, HashMap lglActnHearingCourtTypes,
                                                HashMap lglActnOutcomes, LegalStatus legalStatus,
                                                Date dtFinalDisposition, LegalAction lglActTPRFiled,
                                                LegalAction lglActTPRAppealed, Date lglActTPRAchieved,
                                                FccpChild fccpChild, Date lgActIntAuthPlace) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      addToCaseTrackingAndLegalGroup(preFillData, primaryChild, fccpFamily, needsOutcomes, teamMeetingFTM,
                                     teamMeetingFTM_FLG, teamMeetingMDT, cnsrvtrshpRemoval, lglActnHearingCourtTypes,
                                     lglActnOutcomes, legalStatus, dtFinalDisposition, lglActTPRFiled,
                                     lglActTPRAppealed, lglActTPRAchieved, fccpChild, lgActIntAuthPlace);
    }
  }

  private void addToCaseTrackingAndLegalGroup(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                              NeedsOutcomes needsOutcomes, Ppt teamMeetingFTM, Ppt teamMeetingFTM_FLG,
                                              Ppt teamMeetingMDT, CnsrvtrshpRemoval cnsrvtrshpRemoval,
                                              HashMap lglActnHearingCourtTypes, HashMap lglActnOutcomes,
                                              LegalStatus legalStatus, Date dtFinalDisposition,
                                              LegalAction lglActTPRFiled, LegalAction lglActTPRAppealed,
                                              Date lglActTPRAchieved, FccpChild fccpChild, Date lgActIntAuthPlace) {
    FormDataGroup caseTrackingGroup = createFormDataGroup(TMPLAT_CASE_TRACKING, FCM05O00);
    buildCaseTrackingAndLegalInfo(caseTrackingGroup, primaryChild, fccpFamily, needsOutcomes, teamMeetingFTM,
                                  teamMeetingFTM_FLG, teamMeetingMDT, cnsrvtrshpRemoval, lglActnHearingCourtTypes,
                                  lglActnOutcomes, legalStatus, dtFinalDisposition, lglActTPRFiled, lglActTPRAppealed,
                                  lglActTPRAchieved, fccpChild, lgActIntAuthPlace);
    preFillData.addFormDataGroup(caseTrackingGroup);
  }

  private void buildCaseTrackingAndLegalInfo(FormDataGroup caseTrackingGroup, Person primaryChild,
                                             FccpFamily fccpFamily, NeedsOutcomes needsOutcomes, Ppt teamMeetingFTM,
                                             Ppt teamMeetingFTM_FLG, Ppt teamMeetingMDT,
                                             CnsrvtrshpRemoval cnsrvtrshpRemoval, HashMap lglActnHearingCourtTypes,
                                             HashMap lglActnOutcomes, LegalStatus legalStatus, Date dtFinalDisposition,
                                             LegalAction lglActTPRFiled, LegalAction lglActTPRAppealed,
                                             Date lglActTPRAchieved, FccpChild fccpChild, Date lgActIntAuthPlace) {
    // CodesTables.CLHECOT_ADJ
    if (primaryChild != null) {
      caseTrackingGroup.addBookmark(createBookmark(CT_LGL_CHILD_NAME, getFullName(primaryChild)));
    }
    if (needsOutcomes != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_CCFA_REFERRAL,
                                                   FormattingHelper.formatDate(needsOutcomes.getDtReferral())));
      caseTrackingGroup.addBookmark(createBookmark(DT_COMP_ASSMT_CMPLT,
                                                   FormattingHelper.formatDate(needsOutcomes.getDtAsstCmplt())));
    }
    if (teamMeetingFTM != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_FAM_TEAM_MEET,
                                                   FormattingHelper.formatDate(teamMeetingFTM.getDtPptDate())));
    } else if (teamMeetingFTM_FLG != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_FAM_TEAM_MEET,
                                                   FormattingHelper.formatDate(teamMeetingFTM_FLG.getDtPptDate())));
    }
    if (teamMeetingMDT != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_MULTI_DISC_TEAM_MEET,
                                                   FormattingHelper.formatDate(teamMeetingMDT.getDtPptDate())));
    }
    if (fccpFamily != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_INITIAL_CASE_PLAN,
                                                   FormattingHelper.formatDate(fccpFamily.getDtOrigSub())));
      caseTrackingGroup.addBookmark(createBookmark(DT_CURR_CASE_PLAN_RVW,
                                                   FormattingHelper.formatDate(fccpFamily.getDtCurrRev())));
      caseTrackingGroup
                       .addBookmark(createBookmark(DT_PREV_RVW, FormattingHelper.formatDate(fccpFamily.getDtPrevRev())));
      caseTrackingGroup.addBookmark(createBookmark(DT_NEXT_RVW,
                                                   FormattingHelper.formatDate(fccpFamily.getDtNextReview())));
      caseTrackingGroup.addBookmark(createBookmark(DT_ANT_DT_ACHVMT_PERMANENCY,
                                                   FormattingHelper.formatDate(fccpFamily.getDtPermAchvd())));
      caseTrackingGroup
                       .addBookmark(createBookmark(COURT_PLAN_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCTPLNTY,
                                                                                            fccpFamily.getCdPlanType())));
      caseTrackingGroup.addBookmark(createBookmark(PRIMARY_PERMANCY_PLAN,
                                                   Lookup.simpleDecodeSafe(CodesTables.CPERMPLN,
                                                                           fccpFamily.getCdPrimPermPlan())));
      caseTrackingGroup.addBookmark(createBookmark(SECONDARY_PERMANCY_PLAN,
                                                   Lookup.simpleDecodeSafe(CodesTables.CPERMPLN,
                                                                           fccpFamily.getCdSecndPermPlan())));
      caseTrackingGroup.addBookmark(createBookmark(TXT_COMP_REASON_PERM, fccpFamily.getTxtPrimCompRsns()));
      caseTrackingGroup.addBookmark(createBookmark(TXT_COMP_REASON_CONC_PERM, fccpFamily.getTxtSecndCompRsns()));

    }
    if (fccpChild != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_DLGNT_SEARCH_CMPLT,
                                                   FormattingHelper.formatDate(fccpChild.getDtDilgntComp())));
    }

    if (cnsrvtrshpRemoval != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_CHLD_RMVD_FRM_HOME,
                                                   FormattingHelper.formatDate(cnsrvtrshpRemoval.getDtRemoval())));
    }
      /*
    if (lglActnOutcomes != null && !lglActnOutcomes.isEmpty()) {
      if ((Map) lglActnOutcomes.get(CodesTables.CLEGLOUT_IAP) != null) {
        if ("RCO".equals(((Map) lglActnOutcomes.get(CodesTables.CLEGLOUT_IAP)).get("cdLegalActAction"))) {
          caseTrackingGroup
                           .addBookmark(createBookmark(
                                                       DT_INIT_AUTH_PLCMT,
                                                       FormattingHelper
                                                                       .formatDate((Date) ((Map) lglActnOutcomes
                                                                                                                .get(CodesTables.CLEGLOUT_IAP))
                                                                                                                                               .get("dtCrtOrdDate"))));
        } else {
          caseTrackingGroup
                           .addBookmark(createBookmark(
                                                       DT_INIT_AUTH_PLCMT,
                                                       FormattingHelper
                                                                       .formatDate((Date) ((Map) lglActnOutcomes
                                                                                                                .get(CodesTables.CLEGLOUT_IAP))
                                                                                                                                               .get("dtCrtActDate"))));
        }
      }
      
    
    
    
      if ((Map) lglActnOutcomes.get(CodesTables.CLEGLOUT_DSR) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_DLGNT_SEARCH_RULING,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((Map) lglActnOutcomes
                                                                                                              .get(CodesTables.CLEGLOUT_DSR))
                                                                                                                                             .get("dtCrtActDate"))));
      }
    }
    
    */
   
    
    if(lgActIntAuthPlace != null){
      caseTrackingGroup
      .addBookmark(createBookmark(
                                  DT_INIT_AUTH_PLCMT,
                                  FormattingHelper
                                                  .formatDate(lgActIntAuthPlace)));
    }
    if ((Map) lglActnOutcomes.get(CodesTables.CLEGLOUT_DSR) != null) {
      caseTrackingGroup
                       .addBookmark(createBookmark(
                                                   DT_DLGNT_SEARCH_RULING,
                                                   FormattingHelper
                                                                   .formatDate((Date) ((Map) lglActnOutcomes
                                                                                                            .get(CodesTables.CLEGLOUT_DSR))
                                                                                                                                           .get("dtCrtActDate"))));
    }
   
    if (lglActnHearingCourtTypes != null && !lglActnHearingCourtTypes.isEmpty()) {
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_SHC) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_EMRGNCY_SHELTER_CARE_ORDER,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_SHC))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
      //STGAP00012810: Changed the Action date to Court Order Date
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_DTH) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_DTNTN_ORDER_72_HR,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_DTH))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_ADJ) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_ADJUDICATORY_ORDER,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_ADJ))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
      //STGAP00012810: Changed the Action date to Court Order Date
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_DIS) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_DISPOSITIONAL_ORDER,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_DIS))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_ETO) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_EXTENDSION_ORDER,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_ETO))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_SUP) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_CASE_PLAN_SUPP_ORDER,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_SUP))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_PRM) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_PERMANENCY_ORDER,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_PRM))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
      if ((LegalAction) lglActnHearingCourtTypes.get(CodesTables.CLHECOT_NRE) != null) {
        caseTrackingGroup
                         .addBookmark(createBookmark(
                                                     DT_NON_REUNIFICATION_ORDER,
                                                     FormattingHelper
                                                                     .formatDate((Date) ((LegalAction) lglActnHearingCourtTypes
                                                                                                                               .get(CodesTables.CLHECOT_NRE))
                                                                                                                                                             .getDtCrtOrdDate())));
      }
    }

    // STGAP00005906 added field back in
    if (dtFinalDisposition != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_FINAL_DSPSTN_ORDER,
                                                   FormattingHelper.formatDate(dtFinalDisposition)));
    }
    if (legalStatus != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_CUSTODY_EXPRTN_DT,
                                                   FormattingHelper.formatDate(legalStatus.getDtLegalStatCusExpDt())));
    }

    if (lglActTPRFiled != null) {
      caseTrackingGroup
                       .addBookmark(createBookmark(DT_TPR_FILED,
                                                   FormattingHelper.formatDate(lglActTPRFiled.getDtCrtActDate())));
    }

    if (lglActTPRAppealed != null) {
      Date dtTPRAppealed = lglActTPRAppealed.getDtCrtActDate();
      if (dtTPRAppealed != null) {
        caseTrackingGroup.addBookmark(createBookmark(IND_TPR_APPEALED, "Yes"));
      }
    }
    // SMS #97845: MR-074-2
    // Display "No" if the TPR Appealed date doesn't exist
    else {
      caseTrackingGroup.addBookmark(createBookmark(IND_TPR_APPEALED, "No"));
    }
    // End of SMS #97845: MR-074-2

    if (lglActTPRAchieved != null) {
      caseTrackingGroup.addBookmark(createBookmark(DT_TPR_VS_ACHVD, FormattingHelper.formatDate(lglActTPRAchieved)));
    }

  } // end buildCaseTrackingAndLegalInfo()

  private void retrieveRemovalAndSeparation(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                            CnsrvtrshpRemoval cnsrvtrshpRemoval, FccpChild fccpChild,
                                            HashMap<String, FccpChildCbx> fccpChildCbxs) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      int idEvent = cnsrvtrshpRemoval.getIdRemovalEvent();
      HashMap<String, String> removalReasons = getRemovalReasons(idEvent);
      // SMS #81140: MR-074 
      // Change per AFCARS re-mapping; removalCaretakerReasons & removalChildReasons were removed 
      //HashMap<String, String> removalCaretakerReasons = retrieveRemovalCharAdult(idEvent);
      //List<RemovalCharChild> listRemovalCharChild = getAllRemovalCharChild(idEvent);
      //HashMap<String, String> removalChildReasons = retrieveRemovalCharChild(listRemovalCharChild);
      //String foundMoreChildBehaviorProblems = childHasOtherBehaviorProblems(listRemovalCharChild);

      addToRemovalSeparationGroup(preFillData, primaryChild, fccpFamily, removalReasons, //removalCaretakerReasons,
                                  //removalChildReasons, 
                                  fccpChild, fccpChildCbxs, cnsrvtrshpRemoval
                                  //foundMoreChildBehaviorProblems
                                  );
    }
  }

  // SMS #81140: MR-074 
  // Signature change per AFCARS re-mapping; 
  // removalCaretakerReasons, removalChildReasons and foundMoreChildBehaviorProblems were removed 
  private void addToRemovalSeparationGroup(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                           HashMap<String, String> removalReasons,
                                           //HashMap<String, String> removalCaretakerReasons,
                                           //HashMap<String, String> removalChildReasons, 
                                           FccpChild fccpChild,
                                           HashMap<String, FccpChildCbx> fccpChildCbxs,
                                           CnsrvtrshpRemoval cnsrvtrshpRemoval//, String foundMoreChildBehaviorProblems
                                           ) {
    FormDataGroup removalGroup = createFormDataGroup(TMPLAT_REMOVAL_SEPARATION, FCM05O00);
    buildRemovalAndSeparationInfo(removalGroup, primaryChild, fccpFamily, removalReasons, //removalCaretakerReasons,
                                  //removalChildReasons, 
                                  fccpChild, fccpChildCbxs, cnsrvtrshpRemoval
                                  //foundMoreChildBehaviorProblems
                                  );
    preFillData.addFormDataGroup(removalGroup);
  }

  private HashMap<String, String> retrieveRemovalCharChild(List<RemovalCharChild> listRemovalCharChild) {
    HashMap<String, String> checkedRemovalCharChild = new HashMap<String, String>();
    checkedRemovalCharChild.put(CodesTables.CPM_60, "N");
    checkedRemovalCharChild.put(CodesTables.CHB_112, "N");
    checkedRemovalCharChild.put(CodesTables.CHB_113, "N");

    if (listRemovalCharChild != null || !listRemovalCharChild.isEmpty()) {
      for (Iterator<RemovalCharChild> removalCharChildIt = listRemovalCharChild.iterator(); removalCharChildIt
                                                                                                              .hasNext();) {
        RemovalCharChild removalCharChild = removalCharChildIt.next();
        String cdRemovChildChar = removalCharChild.getId().getCdRemovChildChar();
        if (CodesTables.CPM_60.equals(cdRemovChildChar) || CodesTables.CHB_112.equals(cdRemovChildChar)
            || CodesTables.CHB_113.equals(cdRemovChildChar)) {
          checkedRemovalCharChild.put(cdRemovChildChar, "Y");
        }
      }
    }
    return checkedRemovalCharChild;
  }

  private List<RemovalCharChild> getAllRemovalCharChild(int idEvent) {
    List<RemovalCharChild> listRemovalCharChild = removalCharChildDAO.findRemovalCharChildByIdRemovalEvent(idEvent);
    return listRemovalCharChild;
  }

  // Find if child has any behavior problem other than "Child Alcohol Abuse"
  private String childHasOtherBehaviorProblems(List<RemovalCharChild> listRemovalCharChild) {
    String childHasOtherProblems = "N";
    boolean foundOne = false;
    try {
      // get the list of all possible child behavior problems
      Collection<String> codes = Lookup.getCategoryCodesCollection(CodesTables.CHB);
      // Go through the list and find if at least one behavior other than "Child Alcohol Abuse" exists
      for (Iterator<String> it = codes.iterator(); it.hasNext();) {
        String code = it.next();
        for (Iterator<RemovalCharChild> removalCharChildIt = listRemovalCharChild.iterator(); removalCharChildIt
                                                                                                                .hasNext();) {
          RemovalCharChild removalCharChild = removalCharChildIt.next();
          String cdRemovChildChar = removalCharChild.getId().getCdRemovChildChar();
          if (code.equals(cdRemovChildChar)) {
            childHasOtherProblems = "Y";
            foundOne = true;
            break; // break from inner loop
          }
        } // end inner for loop
        if (foundOne) {
          break; // break from outer loop
        }
      } // end outer for loop

    } catch (LookupException le) {
      ; // do nothing
    }
    return childHasOtherProblems;
  }

  private HashMap<String, String> retrieveRemovalCharAdult(int idEvent) {

    HashMap<String, String> checkedRemovalCharAdult = new HashMap<String, String>();
    checkedRemovalCharAdult.put(CodesTables.CREMCHCT_ALC, "N");
    checkedRemovalCharAdult.put(CodesTables.CREMCHCT_INA, "N");
    checkedRemovalCharAdult.put(CodesTables.CREMCHCT_DEA, "N");
    checkedRemovalCharAdult.put(CodesTables.CREMCHCT_INC, "N");
    checkedRemovalCharAdult.put(CodesTables.CREMCHCT_DRU, "N");
    checkedRemovalCharAdult.put(CodesTables.CREMCHCT_UNA, "N");

    List<RemovalCharAdult> listRemovalCharAdult = removalCharAdultDAO.findRemovalCharAdultByIdRemovalEvent(idEvent);
    if (listRemovalCharAdult != null && !listRemovalCharAdult.isEmpty()) {
      for (Iterator<RemovalCharAdult> removalCharAdultIt = listRemovalCharAdult.iterator(); removalCharAdultIt
                                                                                                              .hasNext();) {
        RemovalCharAdult removalCharAdult = removalCharAdultIt.next();
        checkedRemovalCharAdult.put(removalCharAdult.getId().getCdRemovAdultChar(), "Y");
      }
    }
    return checkedRemovalCharAdult;
  }

  private HashMap<String, String> getRemovalReasons(int idEvent) {
    HashMap<String, String> checkedRemovalReasons = new HashMap<String, String>();
    checkedRemovalReasons.put(CodesTables.CREMFRHR_PAR, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_SAR, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_ABN, "N");
    // SMS #81140: MR-074
    // Re-map old Removal Reasons to the new AFCARS Removal Reasons in Custody page
    //checkedRemovalReasons.put(CodesTables.CREMFRHR_NSR, "N"); // End-dated
    checkedRemovalReasons.put(CodesTables.CREMFRHR_RLM, "N");
    //checkedRemovalReasons.put(CodesTables.CREMFRHR_EAR, "N"); // End-dated
    //checkedRemovalReasons.put(CodesTables.CREMFRHR_MNR, "N"); // End-dated
    //checkedRemovalReasons.put(CodesTables.CREMFRHR_NPR, "N"); // End-dated
    //checkedRemovalReasons.put(CodesTables.CREMFRHR_PHR, "N"); // End-dated
    // These 11 Removal Reasons are 
    // either New or Re-Mapped under different code_type
    checkedRemovalReasons.put(CodesTables.CREMFRHR_DRU, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_ALC, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_NEG, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_INA, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_UNA, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_DEA, "N");
    checkedRemovalReasons.put(CodesTables.CREMFRHR_INC, "N");
    checkedRemovalReasons.put(CodesTables.CCREMRSN_CDA, "N");
    checkedRemovalReasons.put(CodesTables.CCREMRSN_CCA, "N");
    checkedRemovalReasons.put(CodesTables.CCREMRSN_CDI, "N");
    checkedRemovalReasons.put(CodesTables.CCREMRSN_CBP, "N");

    List<RemovalReason> listRemovalReason = removalReasonDAO.findListOfRemovalReasonByIdEvent(idEvent);
    if (listRemovalReason != null && !listRemovalReason.isEmpty()) {
      for (Iterator<RemovalReason> removalReasonIt = listRemovalReason.iterator(); removalReasonIt.hasNext();) {
        RemovalReason removalReason = removalReasonIt.next();
        checkedRemovalReasons.put(removalReason.getId().getCdRemovalReason(), "Y");
      }
    }
    return checkedRemovalReasons;
  }

  // SMS #81140: MR-074 
  // Signature change per re-mapping; 
  // removalCaretakerReasons, removalChildReasons and foundMoreChildBehaviorProblems were removed 
  private void buildRemovalAndSeparationInfo(FormDataGroup removalGroup, Person primaryChild, FccpFamily fccpFamily,
                                             HashMap<String, String> removalReasons,
                                             //HashMap<String, String> removalCaretakerReasons,
                                             //HashMap<String, String> removalChildReasons, 
                                             FccpChild fccpChild,
                                             HashMap<String, FccpChildCbx> fccpChildCbxs,
                                             CnsrvtrshpRemoval cnsrvtrshpRemoval//, String foundMoreChildBehaviorProblems
                                             ) {

    if (primaryChild != null) {
      removalGroup.addBookmark(createBookmark(REMOVAL_CHILD_FULL_NAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      removalGroup.addBookmark(createBookmark(RSN_CHLD_NOT_PRTCT_AT_HOME, fccpFamily.getTxtRsnsProt()));
      removalGroup.addBookmark(createBookmark(CHILD_FUTURE_HARM_AT_HOME, fccpFamily.getTxtHarm()));
    }
    if (cnsrvtrshpRemoval != null) {
      removalGroup.addBookmark(createBookmark(RSN_CHILD_PLCD_IN_FH, cnsrvtrshpRemoval.getTxtDescriptionOfIncident()));
    }

    // Removal Reasons
    if (removalReasons != null && removalReasons.size() > 0) {
      // modified for STGAP00005237
      Object yes = "Y";
      // PHYSICAL ABUSE
      // if (removalReasons.get(CodesTables.CREMFRHR_PAR)) {
      boolean wasPhysicallyAbused = (removalReasons.get(CodesTables.CREMFRHR_PAR).equals(yes));

      /* This is old mapping
      // NEGLECT
      boolean wasNeglected = (removalReasons.get(CodesTables.CREMFRHR_NSR).equals(yes)
                              || removalReasons.get(CodesTables.CREMFRHR_EAR).equals(yes)
                              || removalReasons.get(CodesTables.CREMFRHR_MNR).equals(yes)
                              || removalReasons.get(CodesTables.CREMFRHR_NPR).equals(yes) || removalReasons
                                                                                                           .get(
                                                                                                                CodesTables.CREMFRHR_PHR)
                                                                                                           .equals(yes));
      */
      
      // This is new mapping
      // NEGLECT
      boolean wasNeglected = (removalReasons.get(CodesTables.CREMFRHR_NEG).equals(yes));
      
      // RELINQUISHED
      boolean wasRelinquished = (removalReasons.get(CodesTables.CREMFRHR_RLM).equals(yes));

      // ABANDONED
      boolean wasAbandoned = (removalReasons.get(CodesTables.CREMFRHR_ABN).equals(yes));

      // SEXUALLY ABUSED
      boolean wasSexuallyAbused = (removalReasons.get(CodesTables.CREMFRHR_SAR).equals(yes));

      String physicalAbusInd = (wasPhysicallyAbused) ? "Y" : "N";
      String neglectedInd = (wasNeglected) ? "Y" : "N";
      String relinquishedInd = (wasRelinquished) ? "Y" : "N";
      String abondonedInd = (wasAbandoned) ? "Y" : "N";
      String sexuallyAbusedInd = (wasSexuallyAbused) ? "Y" : "N";

      removalGroup.addBookmark(createBookmark(PHYSICAL_ABUSE, physicalAbusInd));
      removalGroup.addBookmark(createBookmark(SEXUAL_ABUSE, sexuallyAbusedInd));
      removalGroup.addBookmark(createBookmark(ABANDONMENT, abondonedInd));
      removalGroup.addBookmark(createBookmark(NEGLECT, neglectedInd));
      removalGroup.addBookmark(createBookmark(RELINQUISHMENT, relinquishedInd));

      // }
      
      // SMS #81140: MR-074 These 10 Removal Reasons are based on the new AFCARS mapping
      
      // PARENT DRUG ABUSE
      boolean wasParentDrugAbused = (removalReasons.get(CodesTables.CREMFRHR_DRU).equals(yes));
      
      // PARENT ALCOHOL ABUSE
      boolean wasParentAlcoholAbused = (removalReasons.get(CodesTables.CREMFRHR_ALC).equals(yes));
      
      // INADEQUATE HOUSING
      boolean wasInadequateHousing = (removalReasons.get(CodesTables.CREMFRHR_INA).equals(yes));

      // CARETAKER NOT COPING
      boolean wasCaretakerNotCoping = (removalReasons.get(CodesTables.CREMFRHR_UNA).equals(yes));

      // PARENT DEATH
      boolean wasParentDeath = (removalReasons.get(CodesTables.CREMFRHR_DEA).equals(yes));
      
      // PARENT INCARCERATION
      boolean wasParentIncarceration = (removalReasons.get(CodesTables.CREMFRHR_INC).equals(yes));
      
      // CHILD DRUG ABUSE
      boolean wasChildDrugAbused = (removalReasons.get(CodesTables.CCREMRSN_CDA).equals(yes));
      
      // CHILD ALCOHOL ABUSE
      boolean wasChildAlcoholAbused = (removalReasons.get(CodesTables.CCREMRSN_CCA).equals(yes));

      // CHILD DISABILITY
      boolean wasChildDisabled = (removalReasons.get(CodesTables.CCREMRSN_CDI).equals(yes));

      // CHILD BEHAVIOR PROBLEM
      boolean wasChildBehaviorProblem = (removalReasons.get(CodesTables.CCREMRSN_CBP).equals(yes));

      String parentDrugAbusedInd = (wasParentDrugAbused) ? "Y" : "N";
      String parentAlcoholAbusedInd = (wasParentAlcoholAbused) ? "Y" : "N";
      String inadequateHousingInd = (wasInadequateHousing) ? "Y" : "N";
      String caretakerNotCopingInd = (wasCaretakerNotCoping) ? "Y" : "N";
      String parentDeathInd = (wasParentDeath) ? "Y" : "N";
      String parentIncarcerationInd = (wasParentIncarceration) ? "Y" : "N";
      String childDrugAbusedInd = (wasChildDrugAbused) ? "Y" : "N";
      String childAlcoholAbusedInd = (wasChildAlcoholAbused) ? "Y" : "N";
      String childDisabledInd = (wasChildDisabled) ? "Y" : "N";
      String childBehaviorProblemInd = (wasChildBehaviorProblem) ? "Y" : "N";

      removalGroup.addBookmark(createBookmark(PARENT_DRUG_ABUSE, parentDrugAbusedInd));
      removalGroup.addBookmark(createBookmark(PARENT_ALCOHOL_ABUSE, parentAlcoholAbusedInd));
      removalGroup.addBookmark(createBookmark(INADEQUATE_HOUSING, inadequateHousingInd));
      removalGroup.addBookmark(createBookmark(CARETAKER_NOT_COPING, caretakerNotCopingInd));
      removalGroup.addBookmark(createBookmark(PARENT_DEATH, parentDeathInd));
      removalGroup.addBookmark(createBookmark(PARENT_INCARCERATION, parentIncarcerationInd));
      removalGroup.addBookmark(createBookmark(CHILD_DRUG_ABUSE, childDrugAbusedInd));
      removalGroup.addBookmark(createBookmark(CHILD_ALCOHOL_ABUSE, childAlcoholAbusedInd));
      removalGroup.addBookmark(createBookmark(CHILD_DISABILITY, childDisabledInd));
      removalGroup.addBookmark(createBookmark(CHILD_BEHAVIOR_PROBLEM, childBehaviorProblemInd));
      
    }

    // SMS #81140: MR-074 
    /* This is old mapping
    // Removal Caretaker Reasons
    if (removalCaretakerReasons != null && removalCaretakerReasons.size() > 0) {
      removalGroup.addBookmark(createBookmark(PARENT_DRUG_ABUSE,
                                              (String) removalCaretakerReasons.get(CodesTables.CREMCHCT_DRU)));
      removalGroup.addBookmark(createBookmark(PARENT_ALCOHOL_ABUSE,
                                              (String) removalCaretakerReasons.get(CodesTables.CREMCHCT_ALC)));
      removalGroup.addBookmark(createBookmark(INADEQUATE_HOUSING,
                                              (String) removalCaretakerReasons.get(CodesTables.CREMCHCT_INA)));
      removalGroup.addBookmark(createBookmark(CARETAKER_NOT_COPING,
                                              (String) removalCaretakerReasons.get(CodesTables.CREMCHCT_UNA)));
      removalGroup.addBookmark(createBookmark(PARENT_DEATH,
                                              (String) removalCaretakerReasons.get(CodesTables.CREMCHCT_DEA)));
      removalGroup.addBookmark(createBookmark(PARENT_INCARCERATION,
                                              (String) removalCaretakerReasons.get(CodesTables.CREMCHCT_INC)));
    }

    // Removal Child Reasons
    if (removalChildReasons != null && removalChildReasons.size() > 0) {
      removalGroup.addBookmark(createBookmark(CHILD_DRUG_ABUSE, (String) removalChildReasons.get(CodesTables.CHB_113)));
      removalGroup.addBookmark(createBookmark(CHILD_ALCOHOL_ABUSE,
                                              (String) removalChildReasons.get(CodesTables.CHB_112)));
      removalGroup.addBookmark(createBookmark(CHILD_DISABILITY, (String) removalChildReasons.get(CodesTables.CPM_60)));
    }

    removalGroup.addBookmark(createBookmark(CHILD_BEHAVIOR_PROBLEM, foundMoreChildBehaviorProblems));

    */
    
    if (fccpChild != null) {
      removalGroup.addBookmark(createBookmark(EFFORTS_PRVNT_RMVL, fccpChild.getTxtEffrtsRem()));
      removalGroup.addBookmark(createBookmark(REMOVAL_YES_DETAILS, fccpChild.getTxtAfsa()));
    }
    if (fccpChildCbxs != null && fccpChildCbxs.size() > 0) {
      if (fccpChildCbxs.get(CodesTables.CCPTASF1 + "_" + CodesTables.CCPTASF1_CFC) != null) {
        removalGroup.addBookmark(createBookmark(CHILD_15_22_YES, CAPX));
        removalGroup.addBookmark(createBookmark(CHILD_15_22_NO, DOUBLEUNDERSCORE));
      } else {
        removalGroup.addBookmark(createBookmark(CHILD_15_22_YES, DOUBLEUNDERSCORE));
        removalGroup.addBookmark(createBookmark(CHILD_15_22_NO, CAPX));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTASF1 + "_" + CodesTables.CCPTASF1_COG) != null) {
        removalGroup.addBookmark(createBookmark(CHILD_ABNDND_OCGA_YES, CAPX));
        removalGroup.addBookmark(createBookmark(CHILD_ABNDND_OCGA_NO, DOUBLEUNDERSCORE));
      } else {
        removalGroup.addBookmark(createBookmark(CHILD_ABNDND_OCGA_YES, DOUBLEUNDERSCORE));
        removalGroup.addBookmark(createBookmark(CHILD_ABNDND_OCGA_NO, CAPX));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTASF1 + "_" + CodesTables.CCPTASF1_CMU) != null) {
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_MURDER_YES, CAPX));
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_MURDER_NO, DOUBLEUNDERSCORE));
      } else {
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_MURDER_YES, DOUBLEUNDERSCORE));
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_MURDER_NO, CAPX));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTASF1 + "_" + CodesTables.CCPTASF1_CAM) != null) {
        removalGroup.addBookmark(createBookmark(PARENT_AIDED_MURDER_YES, CAPX));
        removalGroup.addBookmark(createBookmark(PARENT_AIDED_MURDER_NO, DOUBLEUNDERSCORE));
      } else {
        removalGroup.addBookmark(createBookmark(PARENT_AIDED_MURDER_YES, DOUBLEUNDERSCORE));
        removalGroup.addBookmark(createBookmark(PARENT_AIDED_MURDER_NO, CAPX));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTASF1 + "_" + CodesTables.CCPTASF1_CFA) != null) {
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_FELONY_YES, CAPX));
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_FELONY_NO, DOUBLEUNDERSCORE));
      } else {
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_FELONY_YES, DOUBLEUNDERSCORE));
        removalGroup.addBookmark(createBookmark(PARENT_COMMIT_FELONY_NO, CAPX));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTASF2 + "_" + CodesTables.CCPTASF2_ERC) != null) {
        removalGroup.addBookmark(createBookmark(RELATIVE_CARING_FOR_CHILD, CAPX));
      } else {
        removalGroup.addBookmark(createBookmark(RELATIVE_CARING_FOR_CHILD, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTASF2 + "_" + CodesTables.CCPTASF2_ECR) != null) {
        removalGroup.addBookmark(createBookmark(RSN_PRNT_RIGHT_TERMINATION, CAPX));
      } else {
        removalGroup.addBookmark(createBookmark(RSN_PRNT_RIGHT_TERMINATION, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTASF2 + "_" + CodesTables.CCPTASF2_ENS) != null) {
        removalGroup.addBookmark(createBookmark(DFCS_CHLD_SAFE_RETURN_HOME, CAPX));
      } else {
        removalGroup.addBookmark(createBookmark(DFCS_CHLD_SAFE_RETURN_HOME, DOUBLEUNDERSCORE));
      }

    } else { // no fccp_child found
      removalGroup.addBookmark(createBookmark(CHILD_15_22_YES, DOUBLEUNDERSCORE));
      removalGroup.addBookmark(createBookmark(CHILD_15_22_NO, CAPX));
      removalGroup.addBookmark(createBookmark(CHILD_ABNDND_OCGA_YES, DOUBLEUNDERSCORE));
      removalGroup.addBookmark(createBookmark(CHILD_ABNDND_OCGA_NO, CAPX));
      removalGroup.addBookmark(createBookmark(PARENT_COMMIT_MURDER_YES, DOUBLEUNDERSCORE));
      removalGroup.addBookmark(createBookmark(PARENT_COMMIT_MURDER_NO, CAPX));
      removalGroup.addBookmark(createBookmark(PARENT_AIDED_MURDER_YES, DOUBLEUNDERSCORE));
      removalGroup.addBookmark(createBookmark(PARENT_AIDED_MURDER_NO, CAPX));
      removalGroup.addBookmark(createBookmark(PARENT_COMMIT_FELONY_YES, DOUBLEUNDERSCORE));
      removalGroup.addBookmark(createBookmark(PARENT_COMMIT_FELONY_NO, CAPX));
      removalGroup.addBookmark(createBookmark(RELATIVE_CARING_FOR_CHILD, DOUBLEUNDERSCORE));
      removalGroup.addBookmark(createBookmark(RSN_PRNT_RIGHT_TERMINATION, DOUBLEUNDERSCORE));
      removalGroup.addBookmark(createBookmark(DFCS_CHLD_SAFE_RETURN_HOME, DOUBLEUNDERSCORE));

    } // end fccpChildCbxs

  }

  // ****************** Reunification Goals
  private void retrieveReunificationGoals(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                          List<PlanGoal> reunificationPlanGoals) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (cdPlanType.equals(CodesTables.CCTPLNTY_REU) || cdPlanType.equals(CodesTables.CCTPLNTY_CON)) {
      addToReunificationGoalsGroup(preFillData, primaryChild, fccpFamily, reunificationPlanGoals);
    }
  }

  private void addToReunificationGoalsGroup(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                            List<PlanGoal> reunificationPlanGoals) {
    FormDataGroup reuGroup = createFormDataGroup(TMPLAT_REUNIF_PLAN, FCM05O00);
    buildReunificationGoalsInfo(reuGroup, primaryChild, fccpFamily, reunificationPlanGoals);
    preFillData.addFormDataGroup(reuGroup);

  }

  private FormDataGroup buildReunificationGoalGroup(PlanGoal planGoal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_REUNIF_GOAL_TYPES, FCM05O00);

    group.addBookmark(createBookmark(REUNIF_GOAL_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCTPLNTY,
                                                                               planGoal.getCdGoalTyp())));
    group.addBookmark(createBookmark(REUNIF_GOAL_REASON, Lookup.simpleDecodeSafe(CodesTables.CRURSN,
                                                                                 planGoal.getCdGoalRsn())));
    group.addBookmark(createBookmark(REUNIF_GOAL_CHANGE_GOAL, planGoal.getTxtGoal()));
    buildReunificationGoalSteps(group, planGoal.getPlanSteps());

    return group;
  }

  private void buildReunificationGoalSteps(FormDataGroup goalGroup, Collection<PlanStep> planSteps) {
    int count = 1;
    for (Iterator<PlanStep> it = planSteps.iterator(); it.hasNext();) {
      PlanStep planStep = it.next();
      if ("Y".equals(planStep.getIndSelected())) {
        goalGroup.addFormDataGroup(buildReunificationGoalStepsGroup(planStep, count++));
      }
    }
  }

  private FormDataGroup buildReunificationGoalStepsGroup(PlanStep planStep, int stepNbr) {
    FormDataGroup group = createFormDataGroup(TMPLAT_REUNIF_GOAL_STEPS, FCM05O00);

    group.addBookmark(createBookmark(REUNIF_GOAL_STEP_SEQ, stepNbr));
    group.addBookmark(createBookmark(REUNIF_STEP_SPECIFIC_ACTN, planStep.getTxtStep()));
    group.addBookmark(createBookmark(REUNIF_STEP_RESP_PRSN, planStep.getTxtRspns()));
    group.addBookmark(createBookmark(REUNIF_STEP_PRIORITY, planStep.getTxtPriority()));
    group.addBookmark(createBookmark(REUNIF_STEP_CMPLTN_DT, FormattingHelper.formatDate(planStep.getDtAntComp())));
    group.addBookmark(createBookmark(REUNIF_STEP_STATUS, Lookup.simpleDecodeSafe(CodesTables.CSTATUS,
                                                                                 planStep.getCdStatus())));
    group.addBookmark(createBookmark(REUNIF_STEP_COMMENTS, planStep.getTxtStepComm()));

    return group;

  }

  private void buildReunificationGoalsInfo(FormDataGroup mainGroup, Person primaryChild, FccpFamily fccpFamily,
                                           List<PlanGoal> reunificationPlanGoals) {
    if (primaryChild != null) {
      mainGroup.addBookmark(createBookmark(REUNIF_CHILD_FULL_NAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      String cdPlanType = fccpFamily.getCdPlanType();
      mainGroup.addBookmark(createBookmark(DT_CURR_REUNIF_REVIEW_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtCurrRev())));
      mainGroup.addBookmark(createBookmark(DT_PREV_REUNIF_REVIEW_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtPrevRev())));
      mainGroup.addBookmark(createBookmark(DT_NEXT_REUNIF_REVIEW_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtNextReview())));
      mainGroup
               .addBookmark(createBookmark(REUNIF_PLAN_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCTPLNTY, cdPlanType)));
      mainGroup
               .addBookmark(createBookmark(REUNIF_PERMNCY_PLAN, Lookup.simpleDecodeSafe(CodesTables.CPERMPLN,
                                                                                        fccpFamily.getCdPrimPermPlan())));
      mainGroup.addBookmark(createBookmark(REUNIF_PERMNCY_PLN_CMNT, fccpFamily.getTxtPrimCompRsns()));

      getReunificationConcurrencyPlanInfo(mainGroup, cdPlanType, fccpFamily);
      buildReunificationGoals(mainGroup, reunificationPlanGoals);
    } // end fccpFamily

  } // end buildReunificationGoalsInfo()

  private void getReunificationConcurrencyPlanInfo(FormDataGroup mainGroup, String cdPlanType, FccpFamily fccpFamily) {
    FormDataGroup group = null;
    if (cdPlanType != null && cdPlanType.equals(CodesTables.CCTPLNTY_CON)) {
      group = createFormDataGroup(TMPLAT_REUNIF_CNCUR_PERM_PLN, FCM05O00);

      group.addBookmark(createBookmark(REUNIF_CNCRRNT_PLAN, Lookup.simpleDecodeSafe(CodesTables.CPERMPLN,
                                                                                    fccpFamily.getCdSecndPermPlan())));
      group.addBookmark(createBookmark(REUNIF_CNCRRNT_PLAN_CMNT, fccpFamily.getTxtSecndCompRsns()));
      mainGroup.addFormDataGroup(group);
    }
  }

  private void buildReunificationGoals(FormDataGroup mainGroup, List<PlanGoal> planGoals) {

    for (Iterator<PlanGoal> it = planGoals.iterator(); it.hasNext();) {
      PlanGoal planGoal = it.next();
      mainGroup.addFormDataGroup(buildReunificationGoalGroup(planGoal));
    }

  }

  // ****************** End Reunification goals

  // ****************** Start after Case Plan
  private void retrieveAfterCarePlan(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                     List<PlanGoal> afterCasePlanGoals, int idCase, int idStage,
                                     List<EventPersonLink> personsInPlan) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
      List<Person> caregivers = getCareGivers(personsInPlan);
      addToAfterCarePlanGroup(preFillData, primaryChild, fccpFamily, afterCasePlanGoals, capsCase, idStage, caregivers);
    }
  }

  private List<Person> getCareGivers(List<EventPersonLink> personsInPlanList) {
    List<Person> caregivers = null;
    if (personsInPlanList != null && !personsInPlanList.isEmpty()) {
      caregivers = new ArrayList<Person>();
      for (Iterator<EventPersonLink> it = personsInPlanList.iterator(); it.hasNext();) {
        EventPersonLink eventPersonLink = it.next();
        Person personInPlan = eventPersonLink.getPerson();
        // get the the relative type
        if ("Y".equals(eventPersonLink.getIndCaregiver())) {
          caregivers.add(personInPlan);
        }
      }
    }

    return caregivers;
  }

  private void buildCareGiverList(FormDataGroup mainGroup, List<Person> caregivers) {
    FormDataGroup group = null;
    if (caregivers != null && !caregivers.isEmpty()) {
      for (Iterator<Person> it = caregivers.iterator(); it.hasNext();) {
        Person caregiver = it.next();
        group = createFormDataGroup(TMPLAT_AFTERCARE_CAREGIVER_NAME, FCM05O00);

        group.addBookmark(createBookmark(AFTERCARE_CAREGIVER_NAME, getFullName(caregiver)));
        mainGroup.addFormDataGroup(group);
      }
    }
  }

  private void addToAfterCarePlanGroup(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                       List<PlanGoal> afterCasePlanGoals, CapsCase capsCase, int idStage,
                                       List<Person> caregivers) {
    FormDataGroup afcGroup = createFormDataGroup(TMPLAT_AFTERCARE_PLAN, FCM05O00);
    buildAfterCasePlanInfo(afcGroup, primaryChild, fccpFamily, afterCasePlanGoals, capsCase, idStage, caregivers);
    preFillData.addFormDataGroup(afcGroup);

  }

  private void buildAfterCasePlanGoals(FormDataGroup mainGroup, List<PlanGoal> planGoals) {

    for (Iterator<PlanGoal> it = planGoals.iterator(); it.hasNext();) {
      PlanGoal planGoal = it.next();
      mainGroup.addFormDataGroup(buildAfterCasePlanGoalGroup(planGoal));
    }
  }

  private FormDataGroup buildAfterCasePlanGoalGroup(PlanGoal planGoal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_AFTERCARE_GOAL_TYPES, FCM05O00);

    group.addBookmark(createBookmark(AFTERCARE_GOAL_REASON, Lookup.simpleDecodeSafe(CodesTables.CCTPLNTY,
                                                                                    planGoal.getCdGoalTyp())));
    group.addBookmark(createBookmark(AFTERCARE_GOAL_CHANGE_GOAL, planGoal.getTxtGoal()));
    buildAfterCasePlanSteps(group, planGoal.getPlanSteps());

    return group;
  }

  private void buildAfterCasePlanSteps(FormDataGroup goalGroup, Collection<PlanStep> planSteps) {
    int count = 1;
    for (Iterator<PlanStep> it = planSteps.iterator(); it.hasNext();) {
      PlanStep planStep = it.next();
      if ("Y".equals(planStep.getIndSelected())) {
        goalGroup.addFormDataGroup(buildAfterCasePlanStepsGroup(planStep, count++));
      }
    }
  } // end buildAfterCasePlanSteps

  private FormDataGroup buildAfterCasePlanStepsGroup(PlanStep planStep, int stepNbr) {
    FormDataGroup group = createFormDataGroup(TMPLAT_AFTERCARE_GOAL_STEPS, FCM05O00);

    group.addBookmark(createBookmark(AFTERCARE_GOAL_STEP_SEQ, stepNbr));
    group.addBookmark(createBookmark(AFTERCARE_STEP_SPECIFIC_ACTN, planStep.getTxtStep()));
    group.addBookmark(createBookmark(AFTERCARE_STEP_RESP_PRSN, planStep.getTxtRspns()));
    group.addBookmark(createBookmark(AFTERCARE_STEP_PRIORITY, planStep.getTxtPriority()));
    group.addBookmark(createBookmark(AFTERCARE_STEP_CMPLTN_DT, FormattingHelper.formatDate(planStep.getDtAntComp())));
    group.addBookmark(createBookmark(AFTERCARE_STEP_STATUS, Lookup.simpleDecodeSafe(CodesTables.CSTATUS,
                                                                                    planStep.getCdStatus())));
    group.addBookmark(createBookmark(AFTERCARE_COMMENTS, planStep.getTxtStepComm()));

    return group;
  } // end buildAfterCasePlanStepsGroup

  private void buildAfterCasePlanInfo(FormDataGroup mainGroup, Person primaryChild, FccpFamily fccpFamily,
                                      List<PlanGoal> afterCasePlanGoals, CapsCase capsCase, int idStage,
                                      List<Person> caregivers) {
    if (primaryChild != null) {
      mainGroup.addBookmark(createBookmark(AFTERCARE_CHILD_FULLNAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      mainGroup.addBookmark(createBookmark(AFTERCARE_DT_CHLD_DISCHARGED,
                                           FormattingHelper.formatDate(fccpFamily.getDtEndAftercare())));
      mainGroup.addBookmark(createBookmark(AFTERCARE_RSN_CHLD_DISCHARGED, fccpFamily.getTxtRsnDschrgAftercare()));
      mainGroup.addBookmark(createBookmark(AFTERCARE_DT_DURATION_FROM,
                                           FormattingHelper.formatDate(fccpFamily.getDtBeginAftercare())));
      mainGroup.addBookmark(createBookmark(AFTERCARE_DT_DURATION_TO, fccpFamily.getDtEndAftercare()));

      buildAfterCasePlanGoals(mainGroup, afterCasePlanGoals);
    } // end fccpFamily
    if (capsCase != null) {
      mainGroup.addBookmark(createBookmark(AFTERCARE_CASE_NAME, capsCase.getNmCase()));
      mainGroup.addBookmark(createBookmark(AFTERCARE_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                     capsCase.getCdCaseCounty())));
    }
    Person caseMngr = getCaseManagerInfo(idStage);
    if (caseMngr != null) {
      mainGroup.addBookmark(createBookmark(AFTERCARE_CASE_MNGR_NAME, getFullName(caseMngr)));
      mainGroup.addBookmark(createBookmark(AFTERCARE_CASE_MNGR_PH, getPersonOfficePhone(caseMngr.getIdPerson()
                                                                                                .intValue())));
    }
    if (caregivers != null) {
      buildCareGiverList(mainGroup, caregivers);
    }
  } // end buildAfterCasePlanInfo()

  // end After Case Plan **********************

  // Start DFCS Standard Goals **********************
  private void retrieveDFCSStandardGoals(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                         List<PlanGoal> dfcsStandardGoals) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      addToDFCSStandardGoalsGroup(preFillData, primaryChild, fccpFamily, dfcsStandardGoals);
    }
  } // end retrieveDFCSStandardGoals()

  private void addToDFCSStandardGoalsGroup(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                           List<PlanGoal> dfcsStandardGoals) {
    FormDataGroup dfcsGroup = createFormDataGroup(TMPLAT_DFCS_PLAN, FCM05O00);
    buildDFCSStandardGoalsInfo(dfcsGroup, primaryChild, fccpFamily, dfcsStandardGoals);
    preFillData.addFormDataGroup(dfcsGroup);
  } // end addToDFCSStandardGoalsGroup()

  private FormDataGroup buildDFCSStandardGoalsGroup(PlanGoal planGoal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_DFCS_GOAL_TYPES, FCM05O00);
    group.addBookmark(createBookmark(DFCS_GOAL_TYPE, "DFCS Standard"));
    group.addBookmark(createBookmark(DFCS_GOAL_CHANGE_GOAL, planGoal.getTxtGoal()));
    buildDFCSStandardGoalsSteps(group, planGoal.getPlanSteps());

    return group;
  } // end buildDFCSStandardGoalsGroup()

  private void buildDFCSStandardGoalsSteps(FormDataGroup goalGroup, Collection<PlanStep> planSteps) {
    int count = 1;
    for (Iterator<PlanStep> it = planSteps.iterator(); it.hasNext();) {
      PlanStep planStep = it.next();
      if ("Y".equals(planStep.getIndSelected())) {
        goalGroup.addFormDataGroup(buildDFCSStandardGoalsStepsGroup(planStep, count++));
      }
    }
  } // end buildDFCSStandardGoalsSteps()

  private FormDataGroup buildDFCSStandardGoalsStepsGroup(PlanStep planStep, int stepNbr) {
    FormDataGroup group = createFormDataGroup(TMPLAT_DFCS_GOAL_STEPS, FCM05O00);

    group.addBookmark(createBookmark(DFCS_GOAL_STEP_SEQ, stepNbr));
    group.addBookmark(createBookmark(DFCS_STEP_SPECIFIC_ACTN, planStep.getTxtStep()));
    group.addBookmark(createBookmark(DFCS_STEP_RESP_PRSN, planStep.getTxtRspns()));
    group.addBookmark(createBookmark(DFCS_STEP_PRIORITY, planStep.getTxtPriority()));
    group.addBookmark(createBookmark(DFCS_STEP_CMPLTN_DT, FormattingHelper.formatDate(planStep.getDtAntComp())));
    group.addBookmark(createBookmark(DFCS_STEP_STATUS, Lookup.simpleDecodeSafe(CodesTables.CSTATUS,
                                                                               planStep.getCdStatus())));
    group.addBookmark(createBookmark(DFCS_STEP_COMMENTS, planStep.getTxtStepComm()));

    return group;
  } // end buildDFCSStandardGoalsStepsGroup()

  private void buildDfcsStandardGoals(FormDataGroup dfcsGroup, List<PlanGoal> planGoals) {

    for (Iterator<PlanGoal> it = planGoals.iterator(); it.hasNext();) {
      PlanGoal planGoal = it.next();
      dfcsGroup.addFormDataGroup(buildDFCSStandardGoalsGroup(planGoal));
    }
  } // end buildDfcsStandardGoals()

  private void buildDFCSStandardGoalsInfo(FormDataGroup dfcsGroup, Person primaryChild, FccpFamily fccpFamily,
                                          List<PlanGoal> dfcsStandardGoals) {
    if (primaryChild != null) {
      dfcsGroup.addBookmark(createBookmark(DFCS_CHILD_FULLNAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      dfcsGroup.addBookmark(createBookmark(DFCS_CURR_CASE_PLAN_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtCurrRev())));
      dfcsGroup.addBookmark(createBookmark(DFCS_PREV_CASE_PLAN_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtPrevRev())));
      dfcsGroup.addBookmark(createBookmark(DFCS_NEXT_CASE_PLAN_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtNextReview())));

      buildDfcsStandardGoals(dfcsGroup, dfcsStandardGoals);
    } // end fccpFamily
  } // end buildDFCSStandardGoalsInfo()

  // end DfcsStandardGoals ********************

  // Start Steps for all parents ********************
  private void retrieveStepsForAllParents(PreFillData preFillData, Person primaryChild) {
    preFillData.addBookmark(createBookmark(STEPS_PARENTS_CHILD_FULL_NAME, getFullName(primaryChild)));
  }

  // End Steps for all parents ********************

  // Start Non-Reunification Goals ******************
  private void retrieveNonReunificationGoals(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                             List<PlanGoal> nonReunificationPlanGoals) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (cdPlanType.equals(CodesTables.CCTPLNTY_NRE) || cdPlanType.equals(CodesTables.CCTPLNTY_CON)) {
      addToNonReunificationGoalsGroup(preFillData, primaryChild, fccpFamily, nonReunificationPlanGoals);
    }
  } // end retrieveNonReunificationGoals()

  private void addToNonReunificationGoalsGroup(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                               List<PlanGoal> nonReunificationPlanGoals) {
    FormDataGroup reuGroup = createFormDataGroup(TMPLAT_NON_REUNIF_PLAN, FCM05O00);
    buildNonReunificationGoalsInfo(reuGroup, primaryChild, fccpFamily, nonReunificationPlanGoals);
    preFillData.addFormDataGroup(reuGroup);
  } // end addToNonReunificationGoalsGroup()

  private FormDataGroup buildNonReunificationGoalGroup(PlanGoal planGoal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_NON_REUNIF_GOAL_TYPES, FCM05O00);

    group.addBookmark(createBookmark(NON_REUNIF_GOAL_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCTPLNTY,
                                                                                   planGoal.getCdGoalTyp())));
    group.addBookmark(createBookmark(NON_REUNIF_GOAL_REASON, Lookup.simpleDecodeSafe(CodesTables.CNRRSN,
                                                                                     planGoal.getCdGoalRsn())));
    group.addBookmark(createBookmark(NON_REUNIF_GOAL_CHANGE_GOAL, planGoal.getTxtGoal()));
    buildNonReunificationGoalSteps(group, planGoal.getPlanSteps());

    return group;
  } // end buildNonReunificationGoalGroup()

  private void buildNonReunificationGoalSteps(FormDataGroup goalGroup, Collection<PlanStep> planSteps) {
    int count = 1;
    for (Iterator<PlanStep> it = planSteps.iterator(); it.hasNext();) {
      PlanStep planStep = it.next();
      if ("Y".equals(planStep.getIndSelected())) {
        goalGroup.addFormDataGroup(buildNonReunificationGoalStepsGroup(planStep, count++));
      }
    }
  } // end buildNonReunificationGoalSteps()

  private FormDataGroup buildNonReunificationGoalStepsGroup(PlanStep planStep, int stepNbr) {
    FormDataGroup group = createFormDataGroup(TMPLAT_NON_REUNIF_GOAL_STEPS, FCM05O00);

    group.addBookmark(createBookmark(NON_REUNIF_GOAL_STEP_SEQ, stepNbr));
    group.addBookmark(createBookmark(NON_REUNIF_STEP_SPECIFIC_ACTN, planStep.getTxtStep()));
    group.addBookmark(createBookmark(NON_REUNIF_STEP_RESP_PRSN, planStep.getTxtRspns()));
    group.addBookmark(createBookmark(NON_REUNIF_STEP_PRIORITY, planStep.getTxtPriority()));
    group.addBookmark(createBookmark(NON_REUNIF_STEP_CMPLTN_DT, FormattingHelper.formatDate(planStep.getDtAntComp())));
    group.addBookmark(createBookmark(NON_REUNIF_STEP_STATUS, Lookup.simpleDecodeSafe(CodesTables.CSTATUS,
                                                                                     planStep.getCdStatus())));
    group.addBookmark(createBookmark(NON_REUNIF_COMMENTS, planStep.getTxtStepComm()));

    return group;
  } // end buildNonReunificationGoalStepsGroup()

  private void buildNonReunificationGoalsInfo(FormDataGroup mainGroup, Person primaryChild, FccpFamily fccpFamily,
                                              List<PlanGoal> nonReunificationPlanGoals) {
    if (primaryChild != null) {
      mainGroup.addBookmark(createBookmark(NON_REUNIF_CHILD_FULL_NAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      String cdPlanType = fccpFamily.getCdPlanType();
      mainGroup.addBookmark(createBookmark(NON_REUNIF_CURR_REVIEW_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtCurrRev())));
      mainGroup.addBookmark(createBookmark(NON_REUNIF_PREV_REVIEW_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtPrevRev())));
      mainGroup.addBookmark(createBookmark(NON_REUNIF_NEXT_REVIEW_DT,
                                           FormattingHelper.formatDate(fccpFamily.getDtNextReview())));
      mainGroup.addBookmark(createBookmark(NON_REUNIF_PLAN_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCTPLNTY,
                                                                                         cdPlanType)));
      mainGroup
               .addBookmark(createBookmark(
                                           NON_REUNIF_PERMNCY_PLAN,
                                           Lookup
                                                 .simpleDecodeSafe(CodesTables.CPERMPLN, fccpFamily.getCdPrimPermPlan())));
      mainGroup.addBookmark(createBookmark(NON_REUNIF_PERMNCY_PLN_CMNT, fccpFamily.getTxtPrimCompRsns()));

      getNonReunificationConcurrencyPlanInfo(mainGroup, cdPlanType, fccpFamily);
      buildNonReunificationGoals(mainGroup, nonReunificationPlanGoals);
    } // end fccpFamily

  } // end buildNonReunificationGoalsInfo()

  private void getNonReunificationConcurrencyPlanInfo(FormDataGroup mainGroup, String cdPlanType, FccpFamily fccpFamily) {
    FormDataGroup group = null;
    if (cdPlanType != null && cdPlanType.equals(CodesTables.CCTPLNTY_CON)) {
      group = createFormDataGroup(TMPLAT_NON_REUNIF_CNCUR_PERM_PLN, FCM05O00);

      group.addBookmark(createBookmark(NON_REUNIF_CNCRRNT_PLAN,
                                       Lookup.simpleDecodeSafe(CodesTables.CPERMPLN, fccpFamily.getCdSecndPermPlan())));
      group.addBookmark(createBookmark(NON_REUNIF_CNCRRNT_PLAN_CMNT, fccpFamily.getTxtSecndCompRsns()));
      mainGroup.addFormDataGroup(group);
    }
  } // end getNonReunificationConcurrencyPlanInfo()

  private void buildNonReunificationGoals(FormDataGroup mainGroup, List<PlanGoal> planGoals) {

    for (Iterator<PlanGoal> it = planGoals.iterator(); it.hasNext();) {
      PlanGoal planGoal = it.next();
      mainGroup.addFormDataGroup(buildNonReunificationGoalGroup(planGoal));
    }
  } // end buildNonReunificationGoals()

  // ****************** End Non-Reunification goals

  // Start Secondary Goals **********************
  private void retrieveSecondaryGoals(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                      List<PlanSecGoal> secondaryGoals) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      addToSecondaryGoalsGroup(preFillData, primaryChild, fccpFamily, secondaryGoals);
    }
  } // end retrieveSecondaryGoals

  private void addToSecondaryGoalsGroup(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                        List<PlanSecGoal> Secondary) {
    FormDataGroup secondaryGroup = createFormDataGroup(TMPLAT_SECONDARY_PLAN, FCM05O00);
    buildSecondaryGoalsInfo(secondaryGroup, primaryChild, fccpFamily, Secondary);
    preFillData.addFormDataGroup(secondaryGroup);
  } // end addToSecondaryGoalsGroup()

  private void buildSecondaryGoalsInfo(FormDataGroup secondaryGroup, Person primaryChild, FccpFamily fccpFamily,
                                       List<PlanSecGoal> secondaryGoals) {
    if (primaryChild != null) {
      secondaryGroup.addBookmark(createBookmark(SCNDRY_CHILD_FULLNAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      buildSecondaryGoals(secondaryGroup, secondaryGoals);
    } // end fccpFamily
  } // end buildSecondaryGoalsInfo()

  private void buildSecondaryGoals(FormDataGroup secondaryGroup, List<PlanSecGoal> planSecGoals) {

    if (planSecGoals.size() > 0) {
      for (Iterator<PlanSecGoal> it = planSecGoals.iterator(); it.hasNext();) {
        PlanSecGoal planSecGoal = it.next();
        secondaryGroup.addFormDataGroup(buildSecondaryGoalsGroup(planSecGoal));
      }
    } else { // show at least an empty line
      PlanSecGoal planSecGoal = new PlanSecGoal();
      secondaryGroup.addFormDataGroup(buildSecondaryGoalsGroup(planSecGoal));
    }
  } // end buildSecondaryGoals

  private FormDataGroup buildSecondaryGoalsGroup(PlanSecGoal planSecGoal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SCNDRY_GOAL_TYPES, FCM05O00);

    group.addBookmark(createBookmark(SCNDRY_DESC, planSecGoal.getTxtDesc()));
    group.addBookmark(createBookmark(SCNDRY_GOAL_STATUS, Lookup.simpleDecodeSafe(CodesTables.CSTATUS,
                                                                                 planSecGoal.getCdStat())));

    return group;
  } // end buildSecondaryGoalsGroup()

  // End Secondary Goals ********************

  // Start FCCP Child Non-Reunification

  private void retrieveFccpChildNREConditions(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                              FccpChild fccpChild, HashMap<String, FccpChildCbx> fccpChildCbxs) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if ((cdPlanType.equals(CodesTables.CCTPLNTY_NRE) || cdPlanType.equals(CodesTables.CCTPLNTY_CON))) {
      addToFccpChildNREConditions(preFillData, primaryChild, fccpChild, fccpChildCbxs);
    }
  } // end retrieveFccpChildNREConditions()

  private void addToFccpChildNREConditions(PreFillData preFillData, Person primaryChild, FccpChild fccpChild,
                                           HashMap<String, FccpChildCbx> fccpChildCbxs) {
    FormDataGroup secondaryGroup = createFormDataGroup(TMPLAT_FCCP_CHLD_NRE, FCM05O00);
    buildFccpChildNREConditionsInfo(secondaryGroup, primaryChild, fccpChild, fccpChildCbxs);
    preFillData.addFormDataGroup(secondaryGroup);
  } // end addToFccpChildNREConditions()

  private void buildFccpChildNREConditionsInfo(FormDataGroup nreGroup, Person primaryChild, FccpChild fccpChild,
                                               HashMap<String, FccpChildCbx> fccpChildCbxs) {
    if (primaryChild != null) {
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_CHLD_FULLNAME, getFullName(primaryChild)));
    }

    if (fccpChild != null) {
      String indTpr = fccpChild.getIndTpr();
      if (indTpr != null && YES.equals(indTpr)) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_YES, CAPX));
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_NO, DOUBLEUNDERSCORE));
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_DT_TPR, FormattingHelper.formatDate(fccpChild.getDtTpr())));
      } else if (NO.equals(indTpr)) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_YES, DOUBLEUNDERSCORE));
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_NO, CAPX));
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_TXT_TPR, fccpChild.getTxtTpr()));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_YES, DOUBLEUNDERSCORE));
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_NO, DOUBLEUNDERSCORE));
      }
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_TXT_STEPS, fccpChild.getTxtSteps()));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_TXT_ADDTL_INFO, fccpChild.getTxtAddtlInfo()));
    }

    if (fccpChildCbxs != null && fccpChildCbxs.size() > 0) {
      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NCR) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCR, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCR, DOUBLEUNDERSCORE));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NVS) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NVS, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NVS, DOUBLEUNDERSCORE));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NAB) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NAB, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NAB, DOUBLEUNDERSCORE));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NDC) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NDC, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NDC, DOUBLEUNDERSCORE));
      }
      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NMD) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NMD, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NMD, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NPD) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPD, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPD, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NCV) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCV, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCV, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NEC) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NEC, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NEC, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NPN) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPN, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPN, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NID) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NID, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NID, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NPB) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPB, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPB, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NPV) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPV, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPV, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NCO) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCO, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCO, DOUBLEUNDERSCORE));
      }

      if (fccpChildCbxs.get(CodesTables.CCPTNRUN + "_" + CodesTables.CCPTNRUN_NTR) != null) {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NTR, CAPX));
      } else {
        nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NTR, DOUBLEUNDERSCORE));
      }
    } else {
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCR, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NVS, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NAB, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NDC, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NMD, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPD, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCV, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NEC, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPN, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NID, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPB, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NPV, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NCO, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_NTR, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_YES, DOUBLEUNDERSCORE));
      nreGroup.addBookmark(createBookmark(FCCP_CHLD_NRE_IND_TPR_NO, DOUBLEUNDERSCORE));

    } // end fccpChildCbxs
  } // end buildFccpChildNREConditionsInfo

  // End FCCP Child Non-Reunification

  // Start Current Placement
  private Placement getCurrentPlacement(int idPrimaryChild) {
    return placementDAO.findPlacementLatestApprovedByIdPerson(idPrimaryChild, DateHelper.MAX_JAVA_DATE);
  }

  // if the child was placed to a Resource, find if one of the approved relative Assessment for that stage
  // verify if any of the approved ones is a relative and get the the data for the caretaker.
  // if the child was placed to a person, find the approved relative Assessment for that stage, see if the
  // relative is listed as one of the people investigated
  private Map getRelativeCareAssmt(Placement currentPlacement, int idStageSUB) {

    Map relativeCareAssmtData = null;
    if (currentPlacement != null) {

      String cdPlacementType = currentPlacement.getCdPlcmtType();
      if (CodesTables.CPLMNTYP_RFH.equals(cdPlacementType) || // Relative Foster Home
          CodesTables.CPLMNTYP_REP.equals(cdPlacementType) || // Relative - Paid
          CodesTables.CPLMNTYP_NRP.equals(cdPlacementType)) { // Non-Relative Paid
        // placed into a resource
        relativeCareAssmtData = relativeCareAssmtDAO.findRelativeCareAssmtByIdStage(idStageSUB);
      } else if (CodesTables.CPLMNTYP_REU.equals(cdPlacementType) || // Relative - Unpaid
                 CodesTables.CPLMNTYP_ICR.equals(cdPlacementType)) { // ICPC - Relative
        if (currentPlacement.getPersonByIdPlcmtAdult() != null) {
          // placed with a person
          relativeCareAssmtData = relativeCareAssmtDAO
                                                      .findRelativeCareAssmtByIdStageByIdPerson(
                                                                                                idStageSUB,
                                                                                                currentPlacement
                                                                                                                .getPersonByIdPlcmtAdult()
                                                                                                                .getIdPerson());
        } // end if currentPlacement.getPersonByIdPlcmtAdult()
      } // end else if
    } // end currentPlacement != null
    return relativeCareAssmtData;
  } // end getRelativeCareAssmt()

  private void retrieveCurrentPlacement(PreFillData preFillData, Person primaryChild, NeedsOutcomes needsOutcomes,
                                        Placement placement, Map relativeCareAssmtData, Approvers approvers,
                                        FccpFamily fccpFamily, FccpChild fccpChild) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      addToCurrentPlacement(preFillData, primaryChild, needsOutcomes, placement, relativeCareAssmtData, approvers,
                            fccpChild);
    }
  } // end retrieveCurrentPlacement()

  private void addToCurrentPlacement(PreFillData preFillData, Person primaryChild, NeedsOutcomes needsOutcomes,
                                     Placement placement, Map relativeCareAssmtData, Approvers approvers,
                                     FccpChild fccpChild) {
    FormDataGroup currPlcmtGroup = createFormDataGroup(TMPLAT_CURRENT_PLACEMENT, FCM05O00);
    buildCurrentPlacmentInfo(currPlcmtGroup, primaryChild, needsOutcomes, placement, relativeCareAssmtData, approvers,
                             fccpChild);
    preFillData.addFormDataGroup(currPlcmtGroup);

  }

  private void buildCurrentPlacmentInfo(FormDataGroup currPlcmtGroup, Person primaryChild, NeedsOutcomes needsOutcomes,
                                        Placement placement, Map relativeCareAssmtData, Approvers approvers,
                                        FccpChild fccpChild) {

    boolean plcmRcmdtnIdentify = false; // Placement recommendation identified
    boolean matchCCFARecommendation = true; // match CCFA Recommendations

    if (primaryChild != null) {
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_FULLNAME, getFullName(primaryChild)));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PRSN_LVNG_ARRGMT,
                                                Lookup.simpleDecodeSafe(CodesTables.CLIVARR,
                                                                        primaryChild.getCdPersonLivArr())));
      Date birthDate = primaryChild.getDtPersonBirth();
      if (birthDate != null) {
        if (isPersonAtLeastThisAge(birthDate, FOURTEEN)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_N, DOUBLEUNDERSCORE));
        } else {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_N, DOUBLEUNDERSCORE));
      }
    } else { // display blank underscore
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_AGE_GT_14_N, DOUBLEUNDERSCORE));
    }

    if (needsOutcomes != null) {
      Date dtReferral = needsOutcomes.getDtReferral();
      if (dtReferral != null) {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_COMP_REFERRAL_Y, CAPX));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_COMP_REFERRAL_N, DOUBLEUNDERSCORE));
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_COMP_REFERRAL_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_COMP_REFERRAL_N, CAPX));
      }

      String txtPlcmtRec = needsOutcomes.getTxtPlcmtRec();
      if (txtPlcmtRec != null && txtPlcmtRec.length() > 0) {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PLCMT_RCMDTN_Y, CAPX));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PLCMT_RCMDTN_N, DOUBLEUNDERSCORE));
        plcmRcmdtnIdentify = true;
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PLCMT_RCMDTN_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PLCMT_RCMDTN_N, CAPX));
      }

    } else { // display blank underscore
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_COMP_REFERRAL_Y, DOUBLEUNDERSCORE));
      // STGAP00005529 default to no
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_COMP_REFERRAL_N, CAPX));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PLCMT_RCMDTN_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PLCMT_RCMDTN_N, CAPX));
    }
    // end needsOutcomes

    if (placement != null) {

      String indPlcmtCcfa = placement.getIndPlcmtCcfa();
      if (indPlcmtCcfa != null) {
        if (plcmRcmdtnIdentify) { // if placement recommedation identified, does placement match CCFA placement
          // recommendation
          if (YES.equals(indPlcmtCcfa)) {
            currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_Y, CAPX));
            currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_N, DOUBLEUNDERSCORE));
          } else if (NO.equals(indPlcmtCcfa)) {
            currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_Y, DOUBLEUNDERSCORE));
            currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_N, CAPX));
            matchCCFARecommendation = false;
          }
        } else {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_N, DOUBLEUNDERSCORE));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_N, DOUBLEUNDERSCORE));
      }

      String txtPlcmtCcfa = placement.getTxtPlcmtCcfa();
      String cdPlcmtCcfa = placement.getCdPlcmtCcfa();
      String plcmtEmerg = placement.getIndPlcmtEmerg();
      if (plcmtEmerg != null) {
        if (YES.equals(plcmtEmerg)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_EMRGCY_PLCMT_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_EMRGCY_PLCMT_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(plcmtEmerg)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_EMRGCY_PLCMT_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_EMRGCY_PLCMT_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_EMRGCY_PLCMT_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_EMRGCY_PLCMT_N, DOUBLEUNDERSCORE));
      }
      if (!matchCCFARecommendation) { // explain why does not match CCFA recommendation
        String plcmtCcfaReason = "";
        if (cdPlcmtCcfa != null) {
          plcmtCcfaReason = Lookup.simpleDecodeSafe(CodesTables.CCCFARNU, cdPlcmtCcfa);
        }
        String txtPlcmtCcfaFinal = "Reason: " + plcmtCcfaReason + ". Comments: " + txtPlcmtCcfa;
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TXT_PLCMT_CCFA, txtPlcmtCcfaFinal));
      }

      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_ADDR_PLCMT_CNTY,
                                                Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                        placement.getAddrPlcmtCnty())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_ADDR_PLCMT_ST, placement.getAddrPlcmtSt()));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_PLCMT_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtStart())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_PREPLCMT_VISIT_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtPreplaceVisit())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CD_PCLMT_TYPE,
                                                Lookup.simpleDecodeSafe(CodesTables.CPLMNTYP,
                                                                        placement.getCdPlcmtType())));
      // start checkboxes
      String indPlcmtSafe = placement.getIndPlcmtSafe();
      if (indPlcmtSafe != null) {
        if (YES.equals(indPlcmtSafe)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtSafe)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_N, DOUBLEUNDERSCORE));
      }

      String indPlcmtRestr = placement.getIndPlcmtRestr();
      if (indPlcmtRestr != null) {
        if (YES.equals(indPlcmtRestr)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtRestr)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_N, DOUBLEUNDERSCORE));
      }

      String indPlcmtFam = placement.getIndPlcmtFam();
      if (indPlcmtFam != null) {
        if (YES.equals(indPlcmtFam)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtFam)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_N, DOUBLEUNDERSCORE));
      }

      String indPlcmtAppr = placement.getIndPlcmtAppr();
      if (indPlcmtAppr != null) {
        if (YES.equals(indPlcmtAppr)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtAppr)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_N, DOUBLEUNDERSCORE));
      }

      String indPlcmtProx = placement.getIndPlcmtProx();
      if (indPlcmtProx != null) {
        if (YES.equals(indPlcmtProx)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtProx)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_N, DOUBLEUNDERSCORE));
      }

      String indSchoolChange = placement.getIndPlcmtSchDist();
      if (indSchoolChange != null) {
        if (YES.equals(indSchoolChange)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indSchoolChange)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_N, DOUBLEUNDERSCORE));
      }

      String indPlcmtCasePlan = placement.getIndPlcmtCasePlan();
      if (indPlcmtCasePlan != null) {
        if (YES.equals(indPlcmtCasePlan)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtCasePlan)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_N, DOUBLEUNDERSCORE));
      }
      // end checkboxes

      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TXT_PLCMT_CHECKLIST, placement.getTxtPlcmtChecklist()));
      
      //MR-057 APPLA Added new fields 
      String indLTFCPlacement = placement.getIndLTFCPlacement();
      if (indLTFCPlacement != null) {
        if (YES.equals(indLTFCPlacement)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indLTFCPlacement)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_N, DOUBLEUNDERSCORE));
      }
      
      //Date Agreement signed
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_AGREEMENT_SIGNED_DT, 
                                                FormattingHelper.formatDate(placement.getDtLTFCAgreementSigned())));
      
      //Connected Adult Question
      String indChildConnectAdult = placement.getIndChildConnectAdult();
      if (indChildConnectAdult != null) {
        if (YES.equals(indChildConnectAdult)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indChildConnectAdult)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_N, DOUBLEUNDERSCORE));
      }
      
      //Connected Adult
      Person connectedAdult = placement.getConnectedAdult();
      if(connectedAdult != null){
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT, getFullName(connectedAdult)));
      }
      
      //MR-057 Adding Temporary Placement 
      String indPlcmtEmerg = placement.getIndPlcmtEmerg();
      if (indPlcmtEmerg != null) {
        if (YES.equals(indPlcmtEmerg)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TEMP_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TEMP_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtEmerg)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TEMP_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TEMP_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TEMP_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TEMP_N, DOUBLEUNDERSCORE));
      }
      
      //MR-057 Adding Temporary Placement Type
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TEMP_TYPE, Lookup.simpleDecodeSafe(CodesTables.CTMPLTYP,placement.getCdTempType())));
      
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RSN_PLCMT_DISCUSS_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtChildDiscuss())));
      String indPlcmtTrauma = placement.getIndPlcmtTrauma();
      if (indPlcmtTrauma != null) {
        if (YES.equals(indPlcmtTrauma)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_N, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TXT_PLCMT_TRAUMA, placement.getTxtPlcmtTrauma()));
        } else if (NO.equals(indPlcmtTrauma)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_N, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_N, DOUBLEUNDERSCORE));
      }
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TXT_PLCMT_DISCUSS, placement.getTxtPlcmtDiscussion()));

      String indPlcmtSiblings = placement.getIndPlcmtSibling();
      if (indPlcmtSiblings != null) {
        if (YES.equals(indPlcmtSiblings)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_N, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_A, DOUBLEUNDERSCORE));
        } else if (NO.equals(indPlcmtSiblings)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_N, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_A, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TXT_SIBLINGS_COMM, placement.getTxtPlcmtSibling()));
        } else if (NA.equals(indPlcmtSiblings)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_N, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_A, CAPX));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_N, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_A, DOUBLEUNDERSCORE));
      }

      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CAREGVR_DISCUSS_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtCaregvrDiscuss())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_MEDDEV_HISTORY_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtMeddevHistory())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_EDUC_LOG_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtEducLog())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_SCHOOL_RECORDS_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtSchoolRecords())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_PLAN_DT,
                                                FormattingHelper.formatDate(placement.getDtPlcmtSchoolRecords())));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_TXT_PLCMT_DOCUMENTS, placement.getTxtPlcmtDocuments()));
    } else {
      // there is no Current placement, need to display blank underscore
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_SAFE_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_CCFA_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PLCMT_APPROP_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_PRXMT_PARENT_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHK_CHLD_BEST_INTRST_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_PLCMT_SIBLINGS_A, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHILD_SCHOOL_CHANGE_N, DOUBLEUNDERSCORE));
      //MR-057 APPLA new fields
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_APPLA_LTFC_N, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CONNECTED_ADULT_N, DOUBLEUNDERSCORE));
    }
    // end placement

    if (fccpChild != null) {
      String indDilgntSearch = fccpChild.getIndDilgntSrch();
      if (indDilgntSearch != null) {
        if (YES.equals(indDilgntSearch)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indDilgntSearch)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_N, CAPX));
        } else {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_N, DOUBLEUNDERSCORE));
        }
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_DLGNT_SEARCH_N, DOUBLEUNDERSCORE));
      }

      String indChildAdjCare = fccpChild.getIndChildAdjCare();
      if (indChildAdjCare != null) {
        if (YES.equals(indChildAdjCare)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_ADJ_IN_CARE_Y, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_ADJ_IN_CARE_N, DOUBLEUNDERSCORE));
        } else if (NO.equals(indChildAdjCare)) {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_ADJ_IN_CARE_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_ADJ_IN_CARE_N, CAPX));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_ADJ_COMM, fccpChild.getTxtChildAdjComm()));
        } else {
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_ADJ_IN_CARE_Y, DOUBLEUNDERSCORE));
          currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_CHLD_ADJ_IN_CARE_N, DOUBLEUNDERSCORE));
        }
      }

    } // end fccpChild

    if (relativeCareAssmtData != null && !relativeCareAssmtData.isEmpty()) {
      Date dateAssmtComplete = (Date) relativeCareAssmtData.get("dtComplete");
      if (dateAssmtComplete != null) {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_HM_EVAL_COMP_Y, CAPX));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_HM_EVAL_COMP_N, DOUBLEUNDERSCORE));
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_HM_EVAL_COMP_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_HM_EVAL_COMP_N, CAPX));
      }

      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RLTV_HM_EVAL_COMP_DT,
                                                FormattingHelper.formatDate(dateAssmtComplete)));

      // String cdAssmtResults = relativeCareAssmt.getCdAssmtResults();
      String cdAssmtResults = (String) relativeCareAssmtData.get("cdAssmtResults");
      Date dtDecision = null;
      if (CodesTables.CASMTRES_APP.equals(cdAssmtResults) || CodesTables.CASMTRES_AWC.equals(cdAssmtResults)) {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_RLTV_HM_APRVD_Y, CAPX));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_RLTV_HM_APRVD_N, DOUBLEUNDERSCORE));
        dtDecision = (Date) relativeCareAssmtData.get("dtDecision");
      } else {
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_RLTV_HM_APRVD_Y, DOUBLEUNDERSCORE));
        currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_RLTV_HM_APRVD_N, CAPX));
      }
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RLTV_HM_EVAL_APRVD_DT,
                                                FormattingHelper.formatDate(dtDecision)));
      currPlcmtGroup
                    .addBookmark(createBookmark(CURR_PLCMT_DFCS_CMNT, (String) relativeCareAssmtData.get("txtComments")));
      // STGAP00005943:Commenting out the retrieval of the relationship and name based on the relative care assesment
      /*
       * String cdRelativeToVic = (String) relativeCareAssmtData.get("cdStagePersRelInt"); String cdStagePersType =
       * (String) relativeCareAssmtData.get("cdStagePersType");
       * 
       * if (isRelativeToVictim(cdStagePersType, cdRelativeToVic)) {
       * currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RELATIVE_RLTNSHP, getRelationshipType(cdStagePersType,
       * cdRelativeToVic))); currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RELATIVE_NAME, (String)
       * relativeCareAssmtData.get("nmPersonFull"))); }
       */
    } else {
      // STGAP00005529 default to no
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_HM_EVAL_COMP_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_HM_EVAL_COMP_N, CAPX));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_RLTV_HM_APRVD_Y, DOUBLEUNDERSCORE));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_IND_RLTV_HM_APRVD_N, CAPX));
    }
    // end relativeCareAssmt
    // STGAP00005943: Populating the relationship field only for Relative Unpaid placement type
    // and leaving it empty for the rest. Populating the Relative Name field with the name of the person
    // selected or the name of the resource selected.
    if (placement != null) {
      String plcmtType = placement.getCdPlcmtType();
      String relationship = "";
      String rsrcName = "";
      if (CodesTables.CPLMNTYP_REU.equals(plcmtType)) {
        String relInt = getRelationshipFromPlacement(placement);
        if (relInt != null) {
          relationship = relInt;
        }
        rsrcName = placement.getNmPlcmtPersonFull();
      } else if (CodesTables.CPLMNTYP_REP.equals(plcmtType) || CodesTables.CPLMNTYP_RFH.equals(plcmtType)) {
        rsrcName = placement.getNmPlcmtFacil();
      }
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RELATIVE_RLTNSHP, relationship));
      currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RELATIVE_NAME, rsrcName));
    }
    // STGAP00005943:end
    /*
     * if (approvers != null) { currPlcmtGroup.addBookmark(createBookmark(CURR_PLCMT_RLTV_HM_EVAL_APRVD_DT,
     * FormattingHelper.formatDate(approvers.getDtApproversDetermination()))); } // end approvers
     */} // end buildCurrentPlacmentInfo() // End Current Placement

  // Start Wtlp
  private void retrieveWtlp(PreFillData preFillData, Person primaryChild, Person ydpCoordinator, Placement wtlpPlcmt,
                            Eligibility eligibility, YouthDetail youthDetail, LegalStatus chld14LegalStatus,
                            Person caseMngr, WtlpPlan wtlpPlan, List<PlanGoal> wtlpPlanGoals) {

    PersonAddress primaryChildAddress = getPrimaryPersonAddress(primaryChild);
    buildWtlpInfo(preFillData, primaryChild, ydpCoordinator, wtlpPlcmt, eligibility, youthDetail, chld14LegalStatus,
                  wtlpPlan, caseMngr, primaryChildAddress, wtlpPlanGoals);
  }

  // STGAP00006933 only include the WTLP section when there is a wtlp placement
  private void buildWtlpInfo(PreFillData preFillData, Person primaryChild, Person ydpCoordinator, Placement wtlpPlcmt,
                             Eligibility eligibility, YouthDetail youthDetail, LegalStatus chld14LegalStatus,
                             WtlpPlan wtlpPlan, Person caseMngr, PersonAddress primaryChildAddress,
                             List<PlanGoal> wtlpPlanGoals) {

    Date birthDate = primaryChild.getDtPersonBirth();
    if (wtlpPlan != null) { // kid is over 14 and has a wtlp placement create fill the wtlp section
      FormDataGroup wtlpGroup = createFormDataGroup(TMPLAT_WTLP, FCM05O00);
      final HashMap<String, String> authPlcmtCodes = new HashMap<String, String>();
      authPlcmtCodes.put("TEM", "Temporary");
      authPlcmtCodes.put("PER", "Permanent");
      authPlcmtCodes.put("VOL", "Voluntary");

      final HashMap<String, String> wtlpCdPlanTypes = new HashMap<String, String>();
      wtlpCdPlanTypes.put("I", "30-Day Case Plan");
      wtlpCdPlanTypes.put("R", "Case Review");

      final HashMap<String, String> wtlpGoalTypes = new HashMap<String, String>();
      wtlpGoalTypes.put(CodesTables.CGOALTYP_EDU, "Education");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_VEP, "Vocational/Employment Prep");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_BDL, "Basic Daily Living");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_HEM, "Health/Education Maintenance");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_PDC, "Personal Development/Counseling");

      if (primaryChild != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_STEPS_CHLD_FNAME, getFullName(primaryChild)));
        wtlpGroup.addBookmark(createBookmark(WTLP_STEP_CHILD_FULLNAME, getFullName(primaryChild)));

        wtlpGroup.addBookmark(createBookmark(WTLP_CHLD_FULLNAME, getFullName(primaryChild)));
        wtlpGroup.addBookmark(createBookmark(WTLP_DOB, FormattingHelper.formatDate(birthDate)));
        wtlpGroup.addBookmark(createBookmark(WTLP_GENDER, Lookup.simpleDecodeSafe(CodesTables.CSEX,
                                                                                  primaryChild.getCdPersonSex())));
        wtlpGroup.addBookmark(createBookmark(WTLP_MRTL_STAT,
                                             Lookup.simpleDecodeSafe(CodesTables.CMARSTAT,
                                                                     primaryChild.getCdPersonMaritalStatus())));
        int idPerson = primaryChild.getIdPerson().intValue();
        String ethnicity = Lookup.simpleDecodeSafe(CodesTables.CINDETHN,
                                                   retrievePersonEthnicityData(idPerson).getCdEthnicity());
        String race = retrievePersonRaceData(idPerson);
        String raceEthnicity = race + "/" + ethnicity;
        wtlpGroup.addBookmark(createBookmark(WTLP_RACE_ETHNCTY, raceEthnicity));
      } // end primaryChild

      if (ydpCoordinator != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_YDP_FULLNAME, getFullName(ydpCoordinator)));
        wtlpGroup.addBookmark(createBookmark(WTLP_YDP_PH_NBR, getPersonOfficePhone(ydpCoordinator.getIdPerson()
                                                                                                 .intValue())));
      } // end ydpCoordinator

      if (caseMngr != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_CASE_MNGR_FNAME, getFullName(caseMngr)));
        wtlpGroup.addBookmark(createBookmark(WTLP_CASE_MNGR_PH_NBR, getPersonOfficePhone(caseMngr.getIdPerson()
                                                                                                 .intValue())));
      } // end ydpCoordinator

      if (wtlpPlcmt != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_CURR_LV_ARR, Lookup.simpleDecodeSafe(CodesTables.CPLMNTYP,
                                                                                       wtlpPlcmt.getCdPlcmtType())));

      } // end wtlpPlcmt

      if (eligibility != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_ELIGIBILITY, Lookup.simpleDecodeSafe(CodesTables.CELIGIBI,
                                                                                       eligibility.getCdEligActual())));
      } // end eligibility

      if (youthDetail != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_PARENT_STATUS, Lookup.simpleDecodeSafe(CodesTables.CPARSTAT,
                                                                                         youthDetail.getCdParStat())));
        wtlpGroup.addBookmark(createBookmark(WTLP_EXPTD_GRAD_DT,
                                             FormattingHelper.formatDate(youthDetail.getDtSchGrad())));
        wtlpGroup.addBookmark(createBookmark(WTLP_ACDMY_TRACK, Lookup.simpleDecodeSafe(CodesTables.CATRACK,
                                                                                       youthDetail.getCdAcadTrack())));
        wtlpGroup.addBookmark(createBookmark(WTLP_EDU_CRDT_GRAD_REQ, youthDetail.getNbrSchCreditReqd()));
        wtlpGroup.addBookmark(createBookmark(WTLP_EDU_CRDT_GRAD_ERND, youthDetail.getNbrSchCreditEarned()));
        Date dtEmancipationDiscussed = youthDetail.getDtEmncDisc();
        if (dtEmancipationDiscussed != null) { // emancipation was discussed
          wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_Y, CAPX));
          wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_N, DOUBLEUNDERSCORE));
          wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_DT,
                                               FormattingHelper.formatDate(dtEmancipationDiscussed)));
          wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_COMM, youthDetail.getTxtEmncDisc()));
          wtlpGroup.addBookmark(createBookmark(WTLP_EMAN_CRDT_GRAD_REQ, youthDetail.getNbrPostReqCred()));
          wtlpGroup.addBookmark(createBookmark(WTLP_EMAN_CRDT_GRAD_ERND, youthDetail.getNbrPostReqEar()));

        } else {
          wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_Y, DOUBLEUNDERSCORE));
          wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_N, CAPX));
        }

      } else {
        // STGAP00005529 defaulted to no
        wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_Y, DOUBLEUNDERSCORE));
        wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_N, CAPX));
      }

      // end youthDetail

      if (chld14LegalStatus != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_CUST_STAT,
                                             Lookup.simpleDecodeSafe(CodesTables.CLEGSTAT,
                                                                     chld14LegalStatus.getCdLegalStatStatus())));
      } // end chld14LegalStatus

      if (wtlpPlan != null) {

        // String wtlpStrength = stripRTFChars(wtlpPlan.getTxtStrengths());
        // STGAP00009339 - get safe version of string to avoid null poitner on replaceAll command
        String wtlpStrength = FormattingHelper.formatString(wtlpPlan.getTxtStrengths());
        String filteredString = wtlpStrength.replaceAll("\r\n", "<br />");
        wtlpGroup.addBookmark(createBookmark(WTLP_DT, FormattingHelper.formatDate(wtlpPlan.getDtWtlp())));
        wtlpGroup.addBookmark(createBookmark(WTLP_TYPE, (String) wtlpCdPlanTypes.get(wtlpPlan.getCdPlanType())));
        wtlpGroup.addBookmark(createBookmark(WTLP_AUTHRTY_PLCMT, authPlcmtCodes.get(wtlpPlan.getCdPlcmtAuth())));
        wtlpGroup.addBookmark(createBookmark(WTLP_DRTN_DT_FROM, FormattingHelper.formatDate(wtlpPlan.getDtFrom())));
        wtlpGroup.addBookmark(createBookmark(WTLP_DRNT_DT_TO, FormattingHelper.formatDate(wtlpPlan.getDtTo())));
        wtlpGroup.addBookmark(createBookmark(WTLP_STRENGTH, filteredString));
        wtlpGroup.addBookmark(createBookmark(WTLP_NEEDS, wtlpPlan.getTxtNeeds()));
        if (wtlpPlan.getCdEdu() != null) {
          wtlpGroup.addBookmark(createBookmark(WTLP_CHK_EDU, CAPX));
        }
        if (wtlpPlan.getCdVoc() != null) {
          wtlpGroup.addBookmark(createBookmark(WTLP_CHK_VOC, CAPX));
        }
        if (wtlpPlan.getCdBasic() != null) {
          wtlpGroup.addBookmark(createBookmark(WTLP_CHK_DAY_LVNG, CAPX));
        }
        if (wtlpPlan.getCdHealth() != null) {
          wtlpGroup.addBookmark(createBookmark(WTLP_CHK_HEALTH, CAPX));
        }
        if (wtlpPlan.getCdPers() != null) {
          wtlpGroup.addBookmark(createBookmark(WTLP_CHK_PRSNL, CAPX));
        }
      } // end wtlpPlan

      if (primaryChildAddress != null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_COUNTY,
                                             Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                     primaryChildAddress.getCdPersonAddrCounty())));
      } // end primaryChildAddress

      if (wtlpPlanGoals != null && !wtlpPlanGoals.isEmpty()) {
        buildWtlpGoals(wtlpGroup, wtlpPlanGoals);
      } // end primwtlpPlanGoalsaryChild

      if (birthDate == null) {
        wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_Y, DOUBLEUNDERSCORE));
        wtlpGroup.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_N, DOUBLEUNDERSCORE));
      }

      preFillData.addFormDataGroup(wtlpGroup);
    }
  } // end buildWtlpInfo

  private void buildWtlpGoals(FormDataGroup wtlpGroup, List<PlanGoal> planGoals) {

    for (Iterator<PlanGoal> it = planGoals.iterator(); it.hasNext();) {
      PlanGoal planGoal = it.next();
      wtlpGroup.addFormDataGroup(buildWtlpGoalGroup(planGoal));
    }
  } // end buildWtlpGoals

  private FormDataGroup buildWtlpGoalGroup(PlanGoal planGoal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_WTLP_GOAL_TYPES, TMPLAT_WTLP);

    group.addBookmark(createBookmark(WTLP_GOAL_TYPE, "WTLP"));
    group.addBookmark(createBookmark(WTLP_GOAL_RSN, Lookup.simpleDecodeSafe(CodesTables.CWTLPGLS,
                                                                            planGoal.getCdGoalRsn())));
    group.addBookmark(createBookmark(WTLP_GOAL_TXT, planGoal.getTxtGoal()));
    buildWtlpGoalSteps(group, planGoal.getPlanSteps());

    return group;
  } // end buildWtlpGoalGroup

  private void buildWtlpGoalSteps(FormDataGroup goalGroup, Collection<PlanStep> planSteps) {
    int count = 1;
    for (Iterator<PlanStep> it = planSteps.iterator(); it.hasNext();) {
      PlanStep planStep = it.next();
      if ("Y".equals(planStep.getIndSelected())) {
        goalGroup.addFormDataGroup(buildWtlpGoalStepsGroup(planStep, count++));
      }
    }
  } // end buildWtlpGoalSteps

  private FormDataGroup buildWtlpGoalStepsGroup(PlanStep planStep, int stepNbr) {
    FormDataGroup group = createFormDataGroup(TMPLAT_WTLP_GOAL_STEPS, TMPLAT_WTLP);

    group.addBookmark(createBookmark(WTLP_STEP_SEQ, stepNbr));
    group.addBookmark(createBookmark(WTLP_STEP_ACTN, planStep.getTxtStep()));
    group.addBookmark(createBookmark(WTLP_STEP_PRSN, planStep.getTxtRspns()));
    group.addBookmark(createBookmark(WTLP_STEP_PRIORITY, planStep.getTxtPriority()));
    group.addBookmark(createBookmark(WTLP_STEP_CMPLTN_DT, FormattingHelper.formatDate(planStep.getDtAntComp())));
    group.addBookmark(createBookmark(WTLP_STEP_STATUS, Lookup.simpleDecodeSafe(CodesTables.CSTATUS,
                                                                               planStep.getCdStatus())));
    group.addBookmark(createBookmark(WTLP_STEP_COMM, planStep.getTxtStepComm()));

    return group;
  } // end buildWtlpGoalStepsGroup

  // End Wtlp

  // Start Placement History
  private List<Placement> getPlacementHistory(int idChildPrimary, int idCase) {
    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);

    List<Placement> placementHistory = placementDAO.findPlacementHistoryByIdPersonByIdCase(idCase, idChildPrimary,
                                                                                           maxDate);
    return placementHistory;
  } // end getPlacementHistory

  private void retrievePlcmtHistory(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                    List<Placement> placementHistory, int idCase, int idStageSUB) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      buildPlcmtHistoryInfo(preFillData, primaryChild, placementHistory, idCase, idStageSUB);
    }
  } // end retrievePlcmtHistory

  private void buildPlcmtHistoryInfo(PreFillData preFillData, Person primaryChild, List<Placement> placementHistory,
                                     int idCase, int idStageSUB) {

    FormDataGroup plcmtHistGroup = createFormDataGroup(TMPLAT_PLCMT_HISTORY, FCM05O00);
    if (primaryChild != null) {
      plcmtHistGroup.addBookmark(createBookmark(PLCMT_HIST_CHILD_FULLNAME, getFullName(primaryChild)));
    }

    if (placementHistory != null && !placementHistory.isEmpty()) {
      buildPlcmtHistory(plcmtHistGroup, placementHistory, idCase, idStageSUB);
    }
    preFillData.addFormDataGroup(plcmtHistGroup);
  }

  private void buildPlcmtHistory(FormDataGroup plcmtHistGroup, List<Placement> placementHistory, int idCase,
                                 int idStageSUB) {
    StagePersonLink stagePersonLink;
    for (Iterator<Placement> it = placementHistory.iterator(); it.hasNext();) {
      stagePersonLink = null;
      Placement placement = it.next();
      if (placement.getPersonByIdPlcmtAdult() != null) { // find the relationship to victim
        stagePersonLink = getRelationshipToVictim(idStageSUB, placement.getPersonByIdPlcmtAdult().getIdPerson()
                                                                       .intValue());
        if (stagePersonLink != null
            && !isRelativeToVictim(stagePersonLink.getCdStagePersType(), stagePersonLink.getCdStagePersRelInt())) {
          stagePersonLink = null;
        }
      }
      plcmtHistGroup.addFormDataGroup(buildPlcmtHistoryGroup(placement, stagePersonLink));
    }
  } // end buildPlcmtHistory

  private FormDataGroup buildPlcmtHistoryGroup(Placement placement, StagePersonLink stagePersonLink) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PLCMT_HISTORY_LIST, FCM05O00);

    if (placement != null) {
      group.addBookmark(createBookmark(PLCMT_HIST_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                  placement.getAddrPlcmtCnty())));
      group.addBookmark(createBookmark(PLCMT_HIST_STATE, placement.getAddrPlcmtSt()));
      group.addBookmark(createBookmark(PLCMT_HIST_DT_ENTER, FormattingHelper.formatDate(placement.getDtPlcmtStart())));
      group.addBookmark(createBookmark(PLCMT_HIST_DT_EXIT, FormattingHelper.formatDate(placement.getDtPlcmtEnd())));
      group.addBookmark(createBookmark(PLCMT_HIST_PLCMT_TYPE, Lookup.simpleDecodeSafe(CodesTables.CPLMNTYP,
                                                                                      placement.getCdPlcmtType())));
      group
           .addBookmark(createBookmark(PLCMT_HIST_REMOVAL_RSN,
                                       Lookup.simpleDecodeSafe(CodesTables.CRMRSNAC, placement.getCdPlcmtRemovalRsn())));
    }
    if (stagePersonLink != null) {
      group.addBookmark(createBookmark(PLCMT_HIST_CHLD_REL_INT,
                                       Lookup.simpleDecodeSafe(CodesTables.CRPTRINT,
                                                               stagePersonLink.getCdStagePersRelInt())));
    }
    return group;
  } // end buildPlcmtHistoryGroup

  // End Placement History

  // Start HealthCare Provider
  private List<ProfessionalAssmt> getHealthCareProviders(int idChildPrimary, int idCase) {
    List<ProfessionalAssmt> professionalAssmts = professionalAssmtDAO
                                                                     .findProfessionalAssmtByIdCaseByIdPersonPrincipal(
                                                                                                                       idCase,
                                                                                                                       idChildPrimary);
    return professionalAssmts;
  } // end getHealthCareProviders

  private void retrieveHealthCareProvider(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                          List<ProfessionalAssmt> professionalAssmts, int idCase) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      buildHealthCareProviderInfo(preFillData, primaryChild, professionalAssmts, idCase);
    }
  } // end retrieveHealthCareProvider

  private void buildHealthCareProviderInfo(PreFillData preFillData, Person primaryChild,
                                           List<ProfessionalAssmt> professionalAssmts, int idCase) {

    FormDataGroup plcmtHistGroup = createFormDataGroup(TMPLAT_HEALTHCARE_PROVIDER, FCM05O00);
    if (primaryChild != null) {
      plcmtHistGroup.addBookmark(createBookmark(HLTHCARE_PRVDR_CHILD_FULLNAME, getFullName(primaryChild)));
    }

    if (professionalAssmts != null && !professionalAssmts.isEmpty()) {
      buildHealthCareProvider(plcmtHistGroup, professionalAssmts, idCase);
    }
    preFillData.addFormDataGroup(plcmtHistGroup);
  } // end buildHealthCareProviderInfo

  private void buildHealthCareProvider(FormDataGroup healthCarePvdrGroup, List<ProfessionalAssmt> professionalAssmts,
                                       int idCase) {

    String personPhoneFax;
    String personPhoneOffice;
    StagePersonLink stagePersonLink;
    PersonAddress personAddress;
    ProfessionalAssmt professionalAssmt = null;
    List<ProfessionalAssmt> otherProfessionalAssmts = new ArrayList<ProfessionalAssmt>();
    List<HashMap> idProfessionalAssmts = new ArrayList<HashMap>();

    for (Iterator<ProfessionalAssmt> it = professionalAssmts.iterator(); it.hasNext();) {
      professionalAssmt = it.next();
      stagePersonLink = null;
      personAddress = null;
      if (professionalAssmt != null) {
        HashMap<String, Object> professional = new HashMap<String, Object>();
        Person personById = professionalAssmt.getPersonByIdPersonProfessional();
        if (personById != null) {
          int idPersonProfessional = personById.getIdPerson().intValue();
          stagePersonLink = getRelationshipToCase(idCase, idPersonProfessional);

          personPhoneFax = new String();
          personPhoneOffice = new String();
          personPhoneFax = getPersonOfficeFaxPhone(idPersonProfessional);
          personPhoneOffice = retrievePrimaryPersonPhoneData(idPersonProfessional);
          personAddress = getPrimaryPersonAddress(personById);
          professional.put("person", personById);
          professional.put("stagePersonLink", stagePersonLink);
          professional.put("personPhoneFax", personPhoneFax);
          professional.put("personPhoneOffice", personPhoneOffice);
          professional.put("personAddress", personAddress);
          if (!idProfessionalAssmts.contains(professional)) {
            idProfessionalAssmts.add(professional);
          }
        } else {
          otherProfessionalAssmts.add(professionalAssmt);
        } // end if personById
      } // end if professionalAssmt
    } // end for loop
    buildHealthCareProviderGroup(healthCarePvdrGroup, idProfessionalAssmts, otherProfessionalAssmts);
  } // end buildHealthCareProvider

  private FormDataGroup buildHealthCareProviderGroup(FormDataGroup maingroup, List<HashMap> idProfessionalAssmts,
                                                     List<ProfessionalAssmt> otherProfessionalAssmts) {
    if (idProfessionalAssmts != null && !idProfessionalAssmts.isEmpty()) {
      for (Iterator<HashMap> it = idProfessionalAssmts.iterator(); it.hasNext();) {
        HashMap idProfessionalAssmt = it.next();
        if (idProfessionalAssmt != null) {
          maingroup.addFormDataGroup(buildHealthCareProviderGroupId(idProfessionalAssmt));
        }
      } // end idProfessionalAssmts for loop
    } // end if idProfessionalAssmts

    if (otherProfessionalAssmts != null && !otherProfessionalAssmts.isEmpty()) {
      for (Iterator<ProfessionalAssmt> it2 = otherProfessionalAssmts.iterator(); it2.hasNext();) {
        ProfessionalAssmt professionalAssmt = it2.next();
        if (professionalAssmt != null) {
          maingroup.addFormDataGroup(buildHealthCareProviderGroupOther(professionalAssmt));
        }
      } // end otherProfessionalAssmts for loop
    } // end if otherProfessionalAssmts

    return maingroup;
  } // end buildHealthCareProviderGroup

  private FormDataGroup buildHealthCareProviderGroupId(HashMap idProfessionalAssmt) {
    FormDataGroup group = createFormDataGroup(TMPLAT_HEALTHCARE_PRVDR_LIST, FCM05O00);

    Person professionalById = (Person) idProfessionalAssmt.get("person");
    if (professionalById != null) { // Name field in Health detail was selected
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_NAME, getFullName(professionalById)));
    }
    PersonAddress personAddress = (PersonAddress) idProfessionalAssmt.get("personAddress");
    if (personAddress != null) {
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_ADDR, personAddress.getAddrPersAddrStLn1()));
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_CSZIP, personAddress.getAddrPersonAddrCity() + ", "
                                                                   + personAddress.getCdPersonAddrState() + " "
                                                                   + personAddress.getAddrPersonAddrZip()));
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_CO,
                                       Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                               personAddress.getCdPersonAddrCounty())));
    }

    String personPhoneOffice = (String) idProfessionalAssmt.get("personPhoneOffice");
    if (personPhoneOffice != null) {
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_PH, personPhoneOffice));

    }
    String personPhoneFax = (String) idProfessionalAssmt.get("personPhoneFax");
    if (personPhoneFax != null) {
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_FAX, personPhoneFax));
    }

    StagePersonLink stagePersonLink = (StagePersonLink) idProfessionalAssmt.get("stagePersonLink");
    if (stagePersonLink != null) {
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_TYPE,
                                       Lookup.simpleDecodeSafe(CodesTables.CRPTRINT,
                                                               stagePersonLink.getCdStagePersRelInt())));
    }

    return group;
  } // end buildHealthCareProviderGroupIds

  private FormDataGroup buildHealthCareProviderGroupOther(ProfessionalAssmt professionalAssmt) {
    FormDataGroup group = createFormDataGroup(TMPLAT_HEALTHCARE_PRVDR_LIST, FCM05O00);

    if (professionalAssmt != null) { // Name field in Health detail was selected
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_NAME, professionalAssmt.getTxtProfAssmtOther()));
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_ADDR, professionalAssmt.getAddrProfAssmtStLn1()));

      String city = professionalAssmt.getAddrProfAssmtCity();
      String state = professionalAssmt.getCdProfAssmtState();
      String zip = professionalAssmt.getAddrProfAssmtZip();
      String county = professionalAssmt.getCdProfAssmtCounty();
      if (city == null) {
        city = SPACE;
      }
      if (state == null) {
        state = SPACE;
      }
      if (zip == null) {
        zip = SPACE;
      }
      if (county == null) {
        county = SPACE;
      }
      group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_CO,
                                       Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                               professionalAssmt.getCdProfAssmtCounty())));
      if (city != null) {
        group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_CSZIP, city + ", " + state + " " + zip));
      }

      String phoneNbr = professionalAssmt.getNbrProfAssmtPhone();
      String phoneExt = professionalAssmt.getNbrProfAssmtPhoneExt();
      if (phoneNbr == null) {
        phoneNbr = SPACE;
      }
      if (phoneExt == null) {
        phoneExt = SPACE;
      }
      if (phoneNbr != null) {
        group.addBookmark(createBookmark(HLTHCARE_PRVDR_PRVDR_PH, phoneNbr + " Ext " + phoneExt));
      }
    }

    return group;
  } // end buildHealthCareProviderGroupOther

  // End HealthCare Provider

  // Start Health Status
  private List<Map> getMedications(int idPerson) {
    List<Map> medications = medicationDAO.findMedicationCurrentlyOnByIdPerson(idPerson);

    return medications;
  } // end getMedications()

  private HashMap<String, ProfessionalAssmt> getLatestVisitDateForSpecificReason(int idCase, int idPerson) {

    HashMap<String, ProfessionalAssmt> visitTypes = new HashMap<String, ProfessionalAssmt>();

    Collection<String> visitReasons = new ArrayList<String>();
    // Medical Exam types
    visitReasons.add(CodesTables.CARSAPPT_AIL); // Acute Illness
    visitReasons.add(CodesTables.CARSAPPT_CHI); // Chronic Illness
    visitReasons.add(CodesTables.CARSAPPT_PYL); // Physical Exam
    visitReasons.add(CodesTables.CARSAPPT_PYM); // Annual Medical Exam
    visitReasons.add(CodesTables.CARSAPPT_FUM); // Follow up Medical

    ProfessionalAssmt professionalAssmt = professionalAssmtDAO
                                                              .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(
                                                                                                                                idCase,
                                                                                                                                idPerson,
                                                                                                                                visitReasons);
    if (professionalAssmt != null) {
      visitTypes.put("MEXM", professionalAssmt);
    }

    visitReasons.clear();

    // Medical Screen types
    visitReasons.add(CodesTables.CARSAPPT_MSC); // Medical Screen
    visitReasons.add(CodesTables.CARSAPPT_EPS);// EPSDT/GA Health Check
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase,
                                                                                                              idPerson,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      visitTypes.put("MSCR", professionalAssmt);
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_DAA); // Dental 6 mo. Exm/CI
    visitReasons.add(CodesTables.CARSAPPT_DAB); // Other Dental Ex/Trt
    visitReasons.add(CodesTables.CARSAPPT_FUD); // Follow up Dental

    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase,
                                                                                                              idPerson,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      visitTypes.put("DEXM", professionalAssmt);
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_DSC); // Dental screen
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase,
                                                                                                              idPerson,
                                                                                                              visitReasons);

    if (professionalAssmt != null) {
      visitTypes.put("DSCR", professionalAssmt);
    }

    visitReasons.clear();
    visitReasons.add(CodesTables.CARSAPPT_PHL); // Psychological
    professionalAssmt = professionalAssmtDAO
                                            .findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(idCase,
                                                                                                              idPerson,
                                                                                                              visitReasons);
    if (professionalAssmt != null) {
      visitTypes.put("PSYC", professionalAssmt);
    }

    return visitTypes;
  }

  private void retrieveHealthStatus(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                    FccpChild fccpChild, List<Map> medications,
                                    HashMap<String, ProfessionalAssmt> medicalVisits) {
    String cdPlanType = fccpFamily.getCdPlanType();
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      buildHealthStatusInfo(preFillData, primaryChild, fccpChild, medications, medicalVisits);
    }
  } // end retrieveHealthStatus

  private void buildHealthStatusInfo(PreFillData preFillData, Person primaryChild, FccpChild fccpChild,
                                     List<Map> medications, HashMap<String, ProfessionalAssmt> medicalVisits) {

    FormDataGroup healthStatusGroup = createFormDataGroup(TMPLAT_HEALTH_STATUS, FCM05O00);
    if (primaryChild != null) {
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_CHILD_FULLNAME, getFullName(primaryChild)));
    }

    if (fccpChild != null) {
      if (YES.equals(fccpChild.getIndImmUtd())) { // immunization upto date
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_Y, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(fccpChild.getIndImmUtd())) {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_N, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTDT_COMM, fccpChild.getTxtImmUtd()));
      } else {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_N, DOUBLEUNDERSCORE));
      }

      if (YES.equals(fccpChild.getIndImmOnfile())) { // immunization on record
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_Y, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(fccpChild.getIndImmOnfile())) {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_N, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_COMM, fccpChild.getTxtImmOnfile()));
      } else {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_N, DOUBLEUNDERSCORE));
      }
      if (YES.equals(fccpChild.getIndOngoingProb())) { // On going medical problems
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_Y, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_N, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_EXPLN, fccpChild.getTxtOngoingProb()));
      } else if (NO.equals(fccpChild.getIndOngoingProb())) {// RMP updated for STGAP00005723
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_N, CAPX));
      } else {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_N, DOUBLEUNDERSCORE));
      }

      if (YES.equals(fccpChild.getIndPsychTreat())) { // On going medical treatment
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_Y, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(fccpChild.getIndPsychTreat())) {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_N, CAPX));
      } else {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_N, DOUBLEUNDERSCORE));
      }
      
      if (YES.equals(fccpChild.getIndPsychDoc())) { // On going medical treatment
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DOC_REC_Y, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DOC_REC_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(fccpChild.getIndPsychDoc())) {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DOC_REC_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DOC_REC_N, CAPX));
      } else {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DOC_REC_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DOC_REC_N, DOUBLEUNDERSCORE));
      }

      if (YES.equals(fccpChild.getIndMedrecOnfile())) { // Medical records on file
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_Y, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(fccpChild.getIndMedrecOnfile())) {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_N, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_COMM, fccpChild.getTxtMedrecOnfile()));
      } else {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_N, DOUBLEUNDERSCORE));
      }

      if (YES.equals(fccpChild.getIndPsychOnfile())) { // Psycholigical records on file
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_Y, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(fccpChild.getIndPsychOnfile())) {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_N, CAPX));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_COMM, fccpChild.getTxtPsychOnfile()));
      } else {
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_Y, DOUBLEUNDERSCORE));
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_N, DOUBLEUNDERSCORE));
      }

      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_OTHER_MED_INFO, fccpChild.getTxtRelevantMed()));

    } else { // fccpchild is null display the yes/no underscores empty
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_UPTODATE_N, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_REC_N, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_CERT_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_IMUN_CERT_N, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_PROB_N, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MDCL_TREAT_N, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MED_REC_FILE_N, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PSY_REC_FILE_N, DOUBLEUNDERSCORE));
    }

    if (medications != null && !medications.isEmpty()) {
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_CHLD_ON_MED_Y, CAPX));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_CHLD_ON_MED_N, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_CHLD_MED_NAMES, buildMedList(medications)));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_PRSN_ADMN_MED, buildMedAdminList(medications)));
    } else { // no medication
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_CHLD_ON_MED_Y, DOUBLEUNDERSCORE));
      healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_CHLD_ON_MED_N, CAPX));
    }

    if (medicalVisits != null && !medicalVisits.isEmpty()) {
      ProfessionalAssmt professionalAssmt = (ProfessionalAssmt) medicalVisits.get("MSCR");
      if (professionalAssmt != null) { // Medical screen
        Date dtLastHealthChk = professionalAssmt.getDtProfAssmtAppt();
        if (dtLastHealthChk != null) {
          healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DT_LAST_HLTH_CHK,
                                                       FormattingHelper.formatDate(dtLastHealthChk)));
        }
      }

      professionalAssmt = (ProfessionalAssmt) medicalVisits.get("MEXM");
      if (professionalAssmt != null) { // medical exam
        Date dtLastMedExam = professionalAssmt.getDtProfAssmtAppt();
        if (dtLastMedExam != null) {
          healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DT_LAST_MED_EXAM,
                                                       FormattingHelper.formatDate(dtLastMedExam)));
        }
      }

      professionalAssmt = (ProfessionalAssmt) medicalVisits.get("DSCR");
      if (professionalAssmt != null) { // dental screen
        Date dtLastDntlScrn = professionalAssmt.getDtProfAssmtAppt();
        if (dtLastDntlScrn != null) {
          healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DT_LAST_DNTL_SCRN,
                                                       FormattingHelper.formatDate(dtLastDntlScrn)));
        }
      }

      professionalAssmt = (ProfessionalAssmt) medicalVisits.get("DEXM");
      if (professionalAssmt != null) { // dental exam
        Date dtLastDentalExam = professionalAssmt.getDtProfAssmtAppt();
        if (dtLastDentalExam != null) {
          healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DT_LAST_DNTL_EXAM,
                                                       FormattingHelper.formatDate(dtLastDentalExam)));
        }
      }

      professionalAssmt = (ProfessionalAssmt) medicalVisits.get("PSYC");
      if (professionalAssmt != null) { // psychological
        Date dtLastPsychExam = professionalAssmt.getDtProfAssmtAppt();
        if (dtLastPsychExam != null) {
          healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_DT_LAST_PSYC_EVAL,
                                                       FormattingHelper.formatDate(dtLastPsychExam)));
        }
      }

      if (fccpChild != null && medicalVisits.size() < 5) { // explain why all last medical visit dates are missing
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MISSING_DT_EXPLN, fccpChild.getTxtEvalDates()));
      }
    } else {
      // STGAP00006689 if there are no medical visits we should still get an explanation
      if (fccpChild != null) { // explain why all last medical visit dates are missing
        healthStatusGroup.addBookmark(createBookmark(HLTH_STAT_MISSING_DT_EXPLN, fccpChild.getTxtEvalDates()));
      }
    }

    preFillData.addFormDataGroup(healthStatusGroup);
  } // end buildHealthStatusInfo

  private String buildMedList(List<Map> medications) {
    StringBuffer medBuf = new StringBuffer();
    for (Iterator<Map> it = medications.iterator(); it.hasNext();) {
      Map medicin = it.next();
      medBuf.append((String) medicin.get("nmMedctn") + "; ");
    }
    return medBuf.toString();
  }

  private String buildMedAdminList(List<Map> medications) {
    StringBuffer medAdmins = new StringBuffer();
    HashMap<String, String> adminNames = new HashMap<String, String>();

    for (Iterator<Map> it = medications.iterator(); it.hasNext();) {
      Map medicin = it.next();
      String adminName = (String) medicin.get("txtMedctnAdminPerson");
      if (adminNames.get(adminName) == null) {
        adminNames.put(adminName, adminName);
        medAdmins.append(adminName + "; ");
      }
    }
    return medAdmins.toString();
  }

  // End Health Status

  // Start Education
  private EducationalHistory getEducation(int idChildPrimary) {
    EducationalHistory educationalHistory = educationalHistoryDAO.findEducationalHistory(idChildPrimary);

    return educationalHistory;
  }

  private void retrieveEducation(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                 FccpChild fccpChild, NeedsOutcomes needsOutcomes,
                                 EducationalHistory educationalHistory, int idCase, int idStageSub, Placement placement) {
    buildEducationData(preFillData, primaryChild, fccpChild, needsOutcomes, educationalHistory, idCase, idStageSub,
                       placement);
  }

  // End Education

  private void buildEducationData(PreFillData preFillData, Person primaryChild, FccpChild fccpChild,
                                  NeedsOutcomes needsOutcomes, EducationalHistory educationalHistory, int idCase,
                                  int idStageSub, Placement placement) {
    ProfessionalAssmt profAssmtForDevAssmt = null;
    ProfessionalAssmt profAssmtForDevScreen = null;
    HashMap<String, ProfessionalAssmt> profAssmtList = null;

    if (isPersonYoungerThanThisAge(primaryChild.getDtPersonBirth(), FOUR)) {
      profAssmtForDevAssmt = getLatestProfessionalAssmtForSpecificReason(idCase, primaryChild.getIdPerson().intValue(),
                                                                         CodesTables.CARSAPPT_DEA);
      profAssmtForDevScreen = getLatestProfessionalAssmtForSpecificReason(idCase,
                                                                          primaryChild.getIdPerson().intValue(),
                                                                          CodesTables.CARSAPPT_DES);
      profAssmtList = new HashMap<String, ProfessionalAssmt>();
      if (profAssmtForDevAssmt != null) {
        profAssmtList.put(CodesTables.CARSAPPT_DEA, profAssmtForDevAssmt);
      }
      if (profAssmtForDevScreen != null) {
        profAssmtList.put(CodesTables.CARSAPPT_DES, profAssmtForDevScreen);
      }
    }
    Person guidanceCounselor = getPersonFittingRelationshipToChild(idStageSub, CodesTables.CRPTRINT_GR);

    // List<Map> visitationPlans = getVisitPlanNarrEvent(idStageSub, primaryChild.getIdPerson().intValue());
    buildEducationInfo(preFillData, primaryChild, fccpChild, needsOutcomes, educationalHistory, profAssmtList,
                       guidanceCounselor, placement);
  }

  private void buildEducationInfo(PreFillData preFillData, Person primaryChild, FccpChild fccpChild,
                                  NeedsOutcomes needsOutcomes, EducationalHistory educationalHistory,
                                  HashMap<String, ProfessionalAssmt> profAssmtList, Person guidanceCounselor,
                                  Placement placement) {

    boolean receiveEID = false; // set to true if receiving or previously received early intervention

    if (primaryChild != null) {
      preFillData.addBookmark(createBookmark(EDUCTN_CHILD_FULLNAME, getFullName(primaryChild)));
    }

    if (needsOutcomes != null) {
      String educAssmtCompleted = needsOutcomes.getIndCcfaEduAssmt();
      if (NO.equals(educAssmtCompleted)) {
        preFillData.addBookmark(createBookmark(EDUCTN_CCFA_EDUC_ASSMT_EXPLN, needsOutcomes.getTxtCcfaEduAssmt()));
      }
      Date educAssmtDt = needsOutcomes.getDtCcfaEduAssmt();
      preFillData.addBookmark(createBookmark(EDUCTN_CCFA_EDUC_ASSMT_DT, FormattingHelper.formatDate(educAssmtDt)));

      // STGAP00009115 fields were moved from form to page
      preFillData.addBookmark(createBookmark(DEV_SCRN_ASSMT_CMNT, needsOutcomes.getTxtUndSchoolageNoDevAss()));
      preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_EXPLN, needsOutcomes.getTxtUnder4NoDevSrcCmnt()));

    }

    if (guidanceCounselor != null) {
      preFillData.addBookmark(createBookmark(EDUCTN_GUIDANCE_CNSLR, getFullName(guidanceCounselor)));
    }

    if (profAssmtList != null && !profAssmtList.isEmpty()) {
      ProfessionalAssmt profAssmtForDevScreen = (ProfessionalAssmt) profAssmtList.get(CodesTables.CARSAPPT_DES);
      ProfessionalAssmt profAssmtForDevAssmt = (ProfessionalAssmt) profAssmtList.get(CodesTables.CARSAPPT_DEA);

      if (profAssmtForDevScreen != null) { // Development screen completed
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_NA, DOUBLEUNDERSCORE));
        preFillData
                   .addBookmark(createBookmark(EDUCTN_DEV_SCRN_DT,
                                               FormattingHelper.formatDate(profAssmtForDevScreen.getDtProfAssmtAppt())));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_NA, DOUBLEUNDERSCORE));
      }

      if (profAssmtForDevAssmt != null) { // Developement assessment completed
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_NA, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_DT,
                                               FormattingHelper.formatDate(profAssmtForDevAssmt.getDtProfAssmtAppt())));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_NA, DOUBLEUNDERSCORE));
      }
    } else {
      // added for STGAP00005949
      if (isPersonYoungerThanThisAge(primaryChild.getDtPersonBirth(), FOUR)) {
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_NA, DOUBLEUNDERSCORE));

        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_NA, DOUBLEUNDERSCORE));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_SCRN_NA, CAPX));

        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_DEV_ASSMT_NA, CAPX));
      }

    }

    if (educationalHistory != null) {
      Date enrollDate = educationalHistory.getDtEdhistEnrollDate();
      Date withdrawDt = educationalHistory.getDtEdhistWithdrawnDate();
      // STGAP00006685 if the education type not is school is selected then we are displaying a
      // X for the Child in School No section
      String edHistType = educationalHistory.getCdEdhistType();
      if (enrollDate != null && withdrawDt == null) { // child in school
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_N, DOUBLEUNDERSCORE));
      } else if (withdrawDt != null) {
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_N, CAPX));
      } else if (CodesTables.CEDTYPE_NIS.equals(edHistType)) {
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_N, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_N, DOUBLEUNDERSCORE));
      }

      if (YES.equals(educationalHistory.getIndEis())) { // receiving early intervention
        receiveEID = true;
        preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(educationalHistory.getIndEis())) {
        preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_N, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_N, DOUBLEUNDERSCORE));
      }

      String indPrevEis = educationalHistory.getIndPrevEis();
      if (YES.equals(indPrevEis)) { // previously received Early intervention services
        receiveEID = true;
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(indPrevEis)) {
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_N, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_N, DOUBLEUNDERSCORE));
      }

      if (receiveEID) {
        preFillData.addBookmark(createBookmark(EDUCTN_EID_YES_EXPLN, educationalHistory.getTxtEis()));
      }

      String indLegalPrnt = educationalHistory.getIndLegalPrnt();
      if (YES.equals(indLegalPrnt)) { // legal parents involved
        receiveEID = true;
        preFillData.addBookmark(createBookmark(EDUCTN_LGL_PRNT_INVOLVE_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_LGL_PRNT_INVOLVE_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(indLegalPrnt)) {
        preFillData.addBookmark(createBookmark(EDUCTN_LGL_PRNT_INVOLVE_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_LGL_PRNT_INVOLVE_N, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_LGL_PRNT_INVOLVE_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_LGL_PRNT_INVOLVE_N, DOUBLEUNDERSCORE));
      }

      String cdAttendance = educationalHistory.getCdAttendance();
      if (cdAttendance != null) { // attendance
        if (CodesTables.CATNDNCE_REG.equals(cdAttendance)) {
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_REG, CAPX));
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_TRUANT, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_NA, DOUBLEUNDERSCORE));
        } else if (CodesTables.CATNDNCE_TRU.equals(cdAttendance)) {
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_REG, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_TRUANT, CAPX));
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_NA, DOUBLEUNDERSCORE));
        } else if (CodesTables.CATNDNCE_NA.equals(cdAttendance)) {
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_REG, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_TRUANT, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_NA, CAPX));
        }
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_REG, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_TRUANT, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_NA, DOUBLEUNDERSCORE));
      }

      String indCurrGradLevel = educationalHistory.getIndCurrGradeLevel();
      if (indCurrGradLevel != null) { // attendance
        if ("A".equals(indCurrGradLevel)) {
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_Y, CAPX));
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_N, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_NA, DOUBLEUNDERSCORE));
        } else if ("B".equals(indCurrGradLevel)) {
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_Y, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_N, CAPX));
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_NA, DOUBLEUNDERSCORE));
        } else {
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_Y, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_N, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_NA, CAPX));
        }
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_NA, CAPX));
      }

      String cdCurrGrade = educationalHistory.getCdCurrGrade();
      if (cdCurrGrade != null) { // current grade level
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_GRADE_LVL, Lookup.simpleDecodeSafe(CodesTables.CSCHGRAD,
                                                                                              cdCurrGrade)));
      }

      String schoolDist = educationalHistory.getNmEdhistSchDist();
      if (schoolDist != null) { // current grade level
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_DISCTRICT, schoolDist));
      }

      String schoolName = educationalHistory.getNmEdhistSchool();
      if (schoolName != null) { // current grade level
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_NAME, schoolName));
      }

      String schoolStAddr = educationalHistory.getAddrEdhistStreetLn1();
      if (schoolStAddr != null) { // current grade level
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_ST_ADDRESS, schoolStAddr));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_ADDR_CSZIP, educationalHistory.getAddrEdhistCity() + ", "
                                                                       + educationalHistory.getAddrEdhistState() + " "
                                                                       + educationalHistory.getAddrEdhistZip()));
      }

      String schoolPhone = educationalHistory.getNbrEdhistPhone();
      String schoolPhoneExt = educationalHistory.getNbrEdhistPhoneExt();
      if (schoolPhoneExt == null) {
        schoolPhoneExt = "";
      }
      if (schoolPhone != null) { // current grade level
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_PHONE, FormattingHelper.formatPhone(schoolPhone) + "  Ext "
                                                                  + schoolPhoneExt));
      }

      // get school fax number
      if (educationalHistory.getCapsResource() != null) {
        Integer idResource = educationalHistory.getCapsResource().getIdResource(); // school id
        String schoolPhoneFax = getResourceFaxPhoneNbr(idResource);
        if (schoolPhoneFax != null) {
          preFillData.addBookmark(createBookmark(EDUCTN_SCHL_FAX, schoolPhoneFax));
        }
      }

      String indSpcEduNeed = educationalHistory.getIndSpcEduNeed();
      if (YES.equals(indSpcEduNeed)) { // Special education needs
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_NA, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_EXPLN, educationalHistory.getTxtSpcEdu()));
      } else if (NO.equals(indSpcEduNeed)) {
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_NA, DOUBLEUNDERSCORE));
      } else if (NA.equals(indSpcEduNeed)) {
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_NA, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_NA, DOUBLEUNDERSCORE));
      }

      String indPrevSpcEduNeed = educationalHistory.getIndPrevEduNeed();
      if (YES.equals(indPrevSpcEduNeed)) { // Special education needs
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_NA, DOUBLEUNDERSCORE));
      } else if (NO.equals(indPrevSpcEduNeed)) {
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_NA, DOUBLEUNDERSCORE));
      } else if (NA.equals(indPrevSpcEduNeed)) {
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_NA, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_PREV_SPCL_EDU_SRVC_NA, DOUBLEUNDERSCORE));
      }

      String indSchChg = educationalHistory.getIndSchChg();
      if (YES.equals(indSchChg)) { // child changed schools due to placement changes
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_NA, DOUBLEUNDERSCORE));
      } else if (NO.equals(indSchChg)) {
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_NA, DOUBLEUNDERSCORE));
      } else if (NA.equals(indSchChg)) {
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_NA, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_NA, DOUBLEUNDERSCORE));
      }

      String indSchRec = educationalHistory.getIndSchRec();
      if (YES.equals(indSchRec)) { // school records in child file
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_NA, DOUBLEUNDERSCORE));
      } else if (NO.equals(indSchRec)) {
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_NA, DOUBLEUNDERSCORE));
      } else if (NA.equals(indSchRec)) {
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_NA, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_NA, DOUBLEUNDERSCORE));
      }

      String indRecBoard = educationalHistory.getIndRecBoard();
      if (YES.equals(indRecBoard)) { // educational records provided to boarding county
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_Y, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_NOUT, DOUBLEUNDERSCORE));
      } else if (NO.equals(indRecBoard)) {
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_N, CAPX));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_NOUT, DOUBLEUNDERSCORE));
      } else if (NA.equals(indRecBoard)) {
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_NOUT, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_NOUT, DOUBLEUNDERSCORE));
      }

      Date stdSupportTeamRefDt = educationalHistory.getDtSstRef();
      if (stdSupportTeamRefDt != null) { // current grade level
        preFillData.addBookmark(createBookmark(EDUCTN_STDNT_SUPRT_REF_DT,
                                               FormattingHelper.formatDate(stdSupportTeamRefDt)));
      }

      Date eipDt = educationalHistory.getDtEduPlan();
      if (eipDt != null) { // current grade level
        preFillData.addBookmark(createBookmark(EDUCTN_IEP_DT, FormattingHelper.formatDate(eipDt)));
      }

      String indSurrPrntType = educationalHistory.getIndFstrPrnt();
      if (YES.equals(indSurrPrntType)) { // surrogate parent type
        preFillData.addBookmark(createBookmark(EDUCTN_SURROGATE_PRNT_TYP, "Foster Parent"));
      } else if (NO.equals(indSurrPrntType)) {
        preFillData.addBookmark(createBookmark(EDUCTN_SURROGATE_PRNT_TYP, "Other"));
      }
      // Comments on SST or IEP per defect STGAP00005749
      preFillData.addBookmark(createBookmark(EDUCTN_SST_IEP_RCMDTN_COMM, educationalHistory.getTxtSst()));

      preFillData.addBookmark(createBookmark(EDUCTN_BHVR_DISCPLN_REC, educationalHistory.getTxtDscplComm()));
      preFillData.addBookmark(createBookmark(EDUCTN_SURROGATE_PRNT_NM, educationalHistory.getNmSurrPrnt()));
      preFillData.addBookmark(createBookmark(EDUCTN_CLASSRM_PLCMT, getClassroomPlcmt(educationalHistory)));

      if (placement != null) {
        String indSpvsn = placement.getIndSpvsn();
        if (YES.equals(indSpvsn)) { // receiving Suplemental supervision
          receiveEID = true;
          preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_Y, CAPX));
          preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_N, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_EXPLN, placement.getTxtSpvsn()));
        } else if (NO.equals(indSpvsn)) {
          preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_Y, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_N, CAPX));
        } else {
          preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_Y, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_N, DOUBLEUNDERSCORE));
        }
      }

      // STGAP00009115 fields were moved from form to page
      preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_EXPLN, educationalHistory.getTxtSchCngCmnt()));
      preFillData.addBookmark(createBookmark(EDUCTN_REC_IN_FILE_EXPLN, educationalHistory.getTxtSchRecOnFileCmnt()));

    } else { // fccpchild is null display the yes/no underscores empty

      preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_CURR_EID_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_PREV_EID_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_CHLD_IN_SCHOOL_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SPCL_EDU_NEEDS_NA, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SCHL_CHG_DUE_PLCMT_NA, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SCH_REC_CHLD_FILE_NA, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_EDU_REC_BOARD_CO_NOUT, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_REG, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_TRUANT, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_ATTENDANCE_NA, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_SUPLMNT_SPRVSN_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_N, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(EDUCTN_PRFMNCE_GRADE_LVL_NA, CAPX));
    }

  } // end buildHealthStatusInfo

  // STGAP00004867: Added these methods to retrieve the list of current Visitation plans instead of the single
  // latest visitation plan
  private void retrieveVisitationPlan(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                      FccpChild fccpChild, int idCase, int idStageSub) {
    String cdPlanType = fccpFamily.getCdPlanType();
    List<OutputLaunchEventLink> visitationPlans = outputLaunchEventLinkDAO.findCurrentVisitationPlansForOpenStageByIdPersonByIdCase(primaryChild.getIdPerson().intValue(), idCase);
    if (!cdPlanType.equals(CodesTables.CCTPLNTY_AFC)) {
      buildVisitationPlanInfo(preFillData, primaryChild, visitationPlans);
    }
  } // end retrieveVisitationPlan

  private void buildVisitationPlanInfo(PreFillData preFillData,Person primaryChild, List<OutputLaunchEventLink> visitationPlans) {

    if(visitationPlans != null){
      for (OutputLaunchEventLink olel : visitationPlans) {
        FormDataGroup visitationGroup = createFormDataGroup(TMPLAT_VISITATION_PLAN_lIST, FCM05O00);
        String indVisitationPlan = "NONE";
        if (olel != null) {
          // Add visit plan narrative
          indVisitationPlan = "";
          visitationGroup.addBlobData(createBlobData(VISIT_PLAN_NARR, VISIT_PLAN_NARR, olel.getIdEvent()));
          visitationGroup.addBookmark(createBookmark(VISIT_PLAN_EXIST, indVisitationPlan));
          if (primaryChild != null) {
          visitationGroup.addBookmark(createBookmark(CHILD_NAME, getFullName(primaryChild)));
          }          
        }
        preFillData.addFormDataGroup(visitationGroup);
        
      }
    }

  }

  private ProfessionalAssmt getLatestProfessionalAssmtForSpecificReason(int idCase, int idPerson,
                                                                        String cdProfAssmtApptRsn) {
    ProfessionalAssmt professionalAssmt = professionalAssmtDAO
                                                              .findProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsn(
                                                                                                                           idCase,
                                                                                                                           idPerson,
                                                                                                                           cdProfAssmtApptRsn);
    return professionalAssmt;
  }

  private String getClassroomPlcmt(EducationalHistory educationalHistory) {
    StringBuffer classRmPlcmt = new StringBuffer();
    if (educationalHistory.getCdEdhistNeeds1() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds1()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds2() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds2()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds3() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds3()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds4() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds4()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds5() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds5()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds6() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds6()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds7() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds7()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds8() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds8()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds9() != null) {
      classRmPlcmt.append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds9()) + "; ");
    }
    if (educationalHistory.getCdEdhistNeeds10() != null) {
      classRmPlcmt
                  .append(Lookup.simpleDecodeSafe(CodesTables.CEDUCNED, educationalHistory.getCdEdhistNeeds10()) + "; ");
    }

    return classRmPlcmt.toString();
  }

  // End Education

  // Start Participation and Disclosure
  private List<PlanParticipant> getPlanParticipants(int idEvent) {
    List<PlanParticipant> planParticipants = planParticipantDAO.findPlanParticipantByIdEvent(idEvent);

    return planParticipants;
  }

  private void retrieveParticipationAndDisclosure(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                                  List<PlanParticipant> planParticipants, Eligibility eligibility,
                                                  int idCase) {

    buildParticipationAndDisclosureInfo(preFillData, primaryChild, fccpFamily, planParticipants, eligibility, idCase);
  }

  private void buildParticipationAndDisclosureInfo(PreFillData preFillData, Person primaryChild, FccpFamily fccpFamily,
                                                   List<PlanParticipant> planParticipants, Eligibility eligibility,
                                                   int idCase) {

    if (primaryChild != null) {
      preFillData.addBookmark(createBookmark(PARTCPTN_CHILD_FULLNAME, getFullName(primaryChild)));
    }
    if (fccpFamily != null) {
      String indPrntPresent = fccpFamily.getIndPrntPresent();
      if (YES.equals(indPrntPresent)) { // parent are present but refuses to sign
        preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_Y, CAPX));
        preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_N, DOUBLEUNDERSCORE));
      } else if (NO.equals(indPrntPresent)) {
        preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_N, CAPX));
      } else {
        preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_N, CAPX));
      }

      Date dtHearingRequeted = fccpFamily.getDtHearingReqstd();
      if (dtHearingRequeted != null) {
        preFillData.addBookmark(createBookmark(PARTCPTN_HEAR_REQ_SUBMIT_Y, CAPX));
        preFillData.addBookmark(createBookmark(PARTCPTN_HEAR_REQ_SUBMIT_N, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(PARTCPTN_HEAR_REQ_DT, FormattingHelper.formatDate(dtHearingRequeted)));
      } else {
        preFillData.addBookmark(createBookmark(PARTCPTN_HEAR_REQ_SUBMIT_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(PARTCPTN_HEAR_REQ_SUBMIT_N, CAPX));
      }

      String txtPrntPrtcpt = fccpFamily.getTxtPrntPrtcpt();
      String txtChildPrtcpt = fccpFamily.getTxtChildPrtcpt();
      StringBuffer prntChildPrtcptTxt = new StringBuffer();
      if (txtPrntPrtcpt != null) {
        prntChildPrtcptTxt.append(txtPrntPrtcpt + " ; ");
      }
      if (txtChildPrtcpt != null) {
        prntChildPrtcptTxt.append(txtChildPrtcpt);
      }
      preFillData.addBookmark(createBookmark(PARTCPTN_NOT_AGREE_COMM, prntChildPrtcptTxt.toString()));

      preFillData.addBookmark(createBookmark(HEARING_REQUEST_COMM, fccpFamily.getTxtHearingRequestCmnts()));

    } else {
      preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_Y, DOUBLEUNDERSCORE));
      preFillData.addBookmark(createBookmark(PARTCPTN_PRNT_REFUSE_SIGN_N, DOUBLEUNDERSCORE));
    }

    if (planParticipants != null) {
      buildParticipantList(preFillData, planParticipants, idCase);
    }

    if (eligibility != null) {
      String indEligCsupSend = eligibility.getIndEligCsupSend();
      if (ArchitectureConstants.Y.equals(indEligCsupSend)) {
        preFillData.addBookmark(createBookmark(PARTCPTN_DFCS_REF_SUP_ENF_Y, CAPX));
        preFillData.addBookmark(createBookmark(PARTCPTN_DFCS_REF_SUP_ENF_N, DOUBLEUNDERSCORE));
      } else if (ArchitectureConstants.N.equals(indEligCsupSend)) {
        preFillData.addBookmark(createBookmark(PARTCPTN_DFCS_REF_SUP_ENF_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(PARTCPTN_DFCS_REF_SUP_ENF_N, CAPX));
        preFillData.addBookmark(createBookmark(PARTCPTN_DFCS_SUP_ENF_EXPLN, eligibility.getTxtChildSuppRefComment()));
      } else {
        preFillData.addBookmark(createBookmark(PARTCPTN_DFCS_REF_SUP_ENF_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(PARTCPTN_DFCS_REF_SUP_ENF_N, DOUBLEUNDERSCORE));
      }
    }
  }

  private void buildParticipantList(PreFillData preFillData, List<PlanParticipant> planParticipants, int idCase) {
    StagePersonLink stagePersonLink;

    for (Iterator<PlanParticipant> it = planParticipants.iterator(); it.hasNext();) {
      stagePersonLink = null;
      PlanParticipant planParticipant = it.next();
      Person participant = planParticipant.getPerson();
      if (participant != null) { // find the relationship to victim
        stagePersonLink = getStagePersonLinkForAPersonAndIdCaseAndCdStageFSU(idCase, CodesTables.CSTAGES_FSU,
                                                                             participant.getIdPerson().intValue());
      }
      preFillData.addFormDataGroup(buildParticipantGroup(planParticipant, stagePersonLink, participant));
    }
  } // end buildParticipantList

  private FormDataGroup buildParticipantGroup(PlanParticipant planParticipant, StagePersonLink stagePersonLink,
                                              Person participant) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PARTICIATION_lIST, FCM05O00);

    if (planParticipant != null) {
      group.addBookmark(createBookmark(PARTCPTN_PARTICIPANT_NAME, planParticipant.getNmPart()));
      group.addBookmark(createBookmark(PARTCPTN_PARTICIPANT_RELTN, planParticipant.getCdRel()));
    }

    return group;
  } // end buildParticipantGroup

  // End Participation and Disclosure

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

  // get the case manager for the FCCP Family stage
  private Person getCaseManagerInfo(int idStage) {
    // STGAP00007801 Using a different Method that checks for current case manager
    // as well as historical case manager
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    Person caseMngr = stagePersonLink.getPerson();
    return caseMngr;
  } // end getCaseManagerInfo()

  private boolean isPersonOverThisAge(Date birthdate, int ageThreshold) {
    boolean over = false;
    int age = DateHelper.getAge(birthdate);
    if ((age - ageThreshold) > 0) {
      over = true;
    }
    return over;
  }

  private boolean isPersonYoungerThanThisAge(Date birthdate, int ageThreshold) {
    boolean over = false;
    int age = DateHelper.getAge(birthdate);
    if ((age - ageThreshold) < 0) {
      over = true;
    }
    return over;
  }

  // RMP added for STGAP00005620
  private boolean isPersonAtLeastThisAge(Date birthdate, int ageThreshold) {
    boolean over = false;
    int age = DateHelper.getAge(birthdate);
    if ((age - ageThreshold) >= 0) {
      over = true;
    }
    return over;
  }

  // whether the person is a principal or a collateral will determine how to extract the relationship
  private boolean isRelativeToVictim(String cdStagePersType, String cdStagePersonRelInt) {
    boolean success = false;

    // relative codes for Principal Type from code_type = 'CRELVICT'
    final HashMap<String, String> relativesPRNCodes = new HashMap<String, String>();
    relativesPRNCodes.put("AB", "Absent Parent");
    relativesPRNCodes.put("AU", "Aunt/Uncle");
    relativesPRNCodes.put("BF", "Biological Father");
    relativesPRNCodes.put("BM", "Biological Mother");
    relativesPRNCodes.put("CO", "Cousin");
    relativesPRNCodes.put("DA", "Daughter");
    relativesPRNCodes.put("FM", "Other Family Member");
    relativesPRNCodes.put("GC", "Grand Child");
    relativesPRNCodes.put("GP", "Grand Parent");
    relativesPRNCodes.put("LF", "Legal Father");
    relativesPRNCodes.put("NN", "Niece/Nephew");
    relativesPRNCodes.put("PA", "Parent");
    relativesPRNCodes.put("PF", "Putative Father to Child");
    relativesPRNCodes.put("SB", "Sibling");
    relativesPRNCodes.put("SO", "Son");
    relativesPRNCodes.put("SP", "Spouse");
    relativesPRNCodes.put("SR", "Step Child");
    relativesPRNCodes.put("SS", "Step Sibling");
    relativesPRNCodes.put("ST", "Step Parent");

    // relative codes for Collateral type from code_type = 'CSRCRPTR'
    final HashMap<String, String> relativesCOLCodes = new HashMap<String, String>();
    relativesCOLCodes.put("AB", "Absent Parent");
    relativesCOLCodes.put("AF", "Adoptive/Foster Parent");
    relativesCOLCodes.put("AU", "Aunt/Uncle");
    relativesCOLCodes.put("BF", "Biological Father");
    relativesCOLCodes.put("BM", "Biological Mother");
    relativesCOLCodes.put("CO", "First Cousin");
    relativesCOLCodes.put("DA", "Daughter");
    relativesCOLCodes.put("FC", "First Cousin Once Removed");
    relativesCOLCodes.put("FM", "Other Family Member");
    relativesCOLCodes.put("G2", "Great Grandparent");
    relativesCOLCodes.put("G3", "Great Great Grandparent");
    relativesCOLCodes.put("G4", "Great Great Great Grandparent");
    relativesCOLCodes.put("GC", "Grand Child");
    relativesCOLCodes.put("GN", "Great Niece");
    relativesCOLCodes.put("GP", "Grand Parent");
    relativesCOLCodes.put("GS", "Step-grandparent");
    relativesCOLCodes.put("GW", "Great Nephew");
    relativesCOLCodes.put("HS", "Half Sibling");
    relativesCOLCodes.put("LF", "Legal Father");
    relativesCOLCodes.put("N2", "Great Great niece");
    relativesCOLCodes.put("NN", "Niece/Nephew");
    relativesCOLCodes.put("NS", "Non Parent Spouse");
    relativesCOLCodes.put("PA", "Parent");
    relativesCOLCodes.put("PF", "Putative Father");
    relativesCOLCodes.put("SB", "Sibling");
    relativesCOLCodes.put("S0", "Son");
    relativesCOLCodes.put("SP", "Spouse");
    relativesCOLCodes.put("SC", "Step Child");
    relativesCOLCodes.put("SS", "Step Sibling");
    relativesCOLCodes.put("ST", "Step Parent");
    relativesCOLCodes.put("W2", "Great Great Nephew");

    if (CodesTables.CPRSNALL_PRN.equals(cdStagePersType)) {
      if (relativesPRNCodes.get(cdStagePersonRelInt) != null) {
        success = true;
      }
    } else if (CodesTables.CPRSNALL_COL.equals(cdStagePersType)) {
      if (relativesCOLCodes.get(cdStagePersonRelInt) != null) {
        success = true;
      }
    }
    return success;
  }

  private StagePersonLink getStagePersonLinkForAPersonAndIdCaseAndCdStage(int idCase, String cdStage, int idPerson) {
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdCaseByIdPersosByCdStage(
                                                                                                        idCase,
                                                                                                        idPerson,
                                                                                                        cdStage,
                                                                                                        CodesTables.CROLEALL_PC);
    return stagePersonLink;

  } // end getStagePersonLinkForAPersonAndCase

  private StagePersonLink getStagePersonLinkForAPersonAndIdCaseAndCdStageFSU(int idCase, String cdStage, int idPerson) {
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdCaseByIdPersosByCdStage(idCase,
                                                                                                        idPerson,
                                                                                                        cdStage);
    return stagePersonLink;

  } // end getStagePersonLinkForAPersonAndCase

  private StagePersonLink getStagePersonLinkClosedForAPersonAndIdCaseAndCdStage(int idCase, String cdStage, int idPerson) {
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkClosedByIdCaseByIdPersosByCdStage(idCase,
                                                                                                              idPerson,
                                                                                                              cdStage);
    return stagePersonLink;

  } // end getStagePersonLinkForAPersonAndCase

  // find the person that has that type of relationship
  private Person getPersonFittingRelationshipToChild(int idStage, String cdStagePersRelInt) {
    Person person = null;
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(idStage,
                                                                                                             cdStagePersRelInt);
    if (stagePersonLink != null) {
      person = stagePersonLink.getPerson();
    }
    return person;
  }

  private Eligibility getEligibility(int idStageSUB, int idPerson) {
    Eligibility eligibility = eligibilityDAO.findEligibilityLatestApprovedByIdStageByIdPerson(idStageSUB, idPerson);

    return eligibility;
  }

  private String getRelationshipType(String cdStagePersType, String cdStagePersonRelInt) {
    String relationship = null;
    if (cdStagePersType.equals(CodesTables.CPRSNALL_PRN)) { // person is principal type person
      relationship = Lookup.simpleDecodeSafe(CodesTables.CRELVICT, cdStagePersonRelInt);
    } else if (cdStagePersType.equals(CodesTables.CPRSNALL_COL)) { // person is a collateral type person
      relationship = Lookup.simpleDecodeSafe(CodesTables.CSRCRPTR, cdStagePersonRelInt);
    }
    return relationship;
  }

  private String getRelationshipFromPlacement(Placement placement) {
    String relationship = "";
    Integer idEvent = placement.getIdPlcmtEvent();
    Person relative = placement.getPersonByIdPlcmtAdult();
    Integer idPerson = relative.getIdPerson();
    if (idPerson != null) {
      relationship = stagePersonLinkDAO.findRelIntByIdEventIdPerson(idEvent, idPerson);
    }
    return relationship;
  }

  private String getResourceFaxPhoneNbr(Integer idResource) {
    String faxNbr = null;
    Map map = resourcePhoneDAO.findResourceFaxInfo(idResource);
    if (map != null) {
      faxNbr = (String) map.get("nbrRsrcPhone");
    }
    return faxNbr;
  }

  private String getString(String str) {
    return (str != null) ? str : "";
  }

  private String stripRTFChars(String rtfString) {
    String returnString = rtfString;
    if (rtfString != null && rtfString.length() > 0) {
      StringReader stringReader = new java.io.StringReader(rtfString);
      RTFEditorKit rtfEditor = new RTFEditorKit();
      DefaultStyledDocument defDoc = new DefaultStyledDocument();
      try {
        rtfEditor.read(stringReader, defDoc, 0);
        returnString = defDoc.getText(0, defDoc.getLength());
      } catch (Exception io) {
        // TODO: Add exception throw here
      }
    }
    return getString(returnString);
  }

  // get the list of codes to determine whether a person is a relative and a caretaker type
  private Collection<String> getRelativeCaretakerCodes() {
    List<String> relatives = new ArrayList<String>();
    relatives.add("AB"); // Absent Parent
    relatives.add("AU"); // Aunt/Uncle
    relatives.add("BF"); // Biological Father
    relatives.add("BM"); // Biological Mother
    relatives.add("CO"); // Cousin
    relatives.add("FM"); // Other Family Member
    relatives.add("GP"); // Grand Parent
    relatives.add("LF"); // Legal Father
    relatives.add("NN"); // Niece/Nephew
    relatives.add("PA"); // Parent
    relatives.add("PF"); // Putative Father to Child
    relatives.add("SB"); // Sibling
    relatives.add("SS"); // Step Sibling
    relatives.add("ST"); // Step Parent

    return relatives;
  }

  // find the relationship of that person to the victim
  private StagePersonLink getRelationshipToVictim(int idCase, int idPerson) {
    StagePersonLink stagePersonLink = null;
    stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageByIdPerson(idCase, idPerson);
    return stagePersonLink;
  }

  private StagePersonLink getRelationshipToCase(int idCase, int idPerson) {
    StagePersonLink stagePersonLink = null;
    stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdCaseByIdPerson(idCase, idPerson);
    return stagePersonLink;
  }

  /**
   * This Method is used to determine the Initial Authorization Placement date. The determination is figured by
   * displaying the first/initial date found by going thru all legal actions with the outcome of initial placement
   * authorization.
   * 
   * @param legalActionList
   * @return List<LegalAction>
   */
  private Date determineDtIntAuthPlace(List<LegalAction> legalActionList) {
    // Date that will be displayed on the form
    Date currentAuthPlacementDate = null;

    if (legalActionList != null && legalActionList.size() != 0) {
      Iterator<LegalAction> itTpr = legalActionList.iterator();
      while (itTpr.hasNext()) {
        LegalAction laTpr = (LegalAction) itTpr.next();
        if (laTpr != null) {
          Date tempLglActDt = laTpr.getDtCrtActDate();
          Date tempAuthPlaceOrdDate = null;
          int result = 0;
          // STGAP00010351 The form should pull the court order date whenever the action is Received Court Order.
          if (CodesTables.CLEGCPS_RCO.equals(laTpr.getCdLegalActAction())) {
            tempAuthPlaceOrdDate = laTpr.getDtCrtOrdDate();
          }
          // This if condition is added here just to add clarity.
          if (tempLglActDt == null && tempAuthPlaceOrdDate == null) {
            // Do nothing
          } else {
            // Get the earliest of the court action date and the court order date.
            // The 'result' is set to -1 if the court order date is the earliest and
            // it is set to 1 if the court action date is the earliest.
            if (tempLglActDt == null && tempAuthPlaceOrdDate != null) {
              result = -1;
            } else if (tempLglActDt != null && tempAuthPlaceOrdDate == null) {
              result = 1;
            } else if (tempLglActDt != null && tempAuthPlaceOrdDate != null) {
              result = tempAuthPlaceOrdDate.compareTo(tempLglActDt);
            }
          }
          // If the court order date is the earliest or if the court order date and court action dates are same
          // and if the recent date and the court order dates are non null then the earliest of them is set as
          // the recent date.
          if (result <= 0) {
            if (currentAuthPlacementDate == null) {
              currentAuthPlacementDate = tempAuthPlaceOrdDate;
            } else {
              if (tempAuthPlaceOrdDate.before(currentAuthPlacementDate)) {
                currentAuthPlacementDate = tempAuthPlaceOrdDate;
              }
            }
          } else {

            if (currentAuthPlacementDate == null) {
              currentAuthPlacementDate = tempLglActDt;
            } else {
              if (tempLglActDt.before(currentAuthPlacementDate)) {
                currentAuthPlacementDate = tempLglActDt;
              }
            }
          }

        }
      }
    }
    return currentAuthPlacementDate;
  }

  public void retrieveAdoptionInformation(PreFillData preFillData, Person primaryChild, AdoInfo adoInfo, int idCase) {
    FormDataGroup group = createFormDataGroup(TMPLAT_ADO_INFO, FCM05O00);
    // STGAP00012156 Displaying ADO information Header Page at a minimum if the ADO stage exists
    if (primaryChild != null) {
      group.addBookmark(createBookmark(FCCP_CHLD_ADO_INFO_CHLD_FULLNAME, getFullName(primaryChild)));
    }
    if (adoInfo != null) {
      int idAdoInfoEvent = adoInfo.getEvent().getIdEvent();
      int idChildRegEvent = 0;

      ExchangeChild exchangeChild = null;
      if (adoInfo.getEventByIdEventChildRegistration() != null) {
        idChildRegEvent = adoInfo.getEventByIdEventChildRegistration().getIdEvent();
        exchangeChild = exchangeChildDAO.findExchangeChildByEventId(idChildRegEvent);
      }
      // populate county recruitment activites
      populateCountyRecruitmentActivities(group, idAdoInfoEvent);

        String indIdenAdo = adoInfo.getIndIdenAdo();
        if (indIdenAdo != null && YES.equals(indIdenAdo)) {
          group.addBookmark(createBookmark("IND_HAS_IDENTIFIED_RESOURCE", "Yes"));
        } else {
          group.addBookmark(createBookmark("IND_HAS_IDENTIFIED_RESOURCE", "No"));
        }

        // populate all checkboxes
        populateCheckBoxes(idAdoInfoEvent, idChildRegEvent, group);

        // populate comment boxes
        group.addBookmark(createBookmark("CADCPAC_COMMENTS", adoInfo.getTxtPrepCmnts()));
        group.addBookmark(createBookmark("CADBREC_COMMENTS", adoInfo.getTxtRecrBarr()));
        group.addBookmark(createBookmark("CADBPLA_COMMENTS", adoInfo.getTxtPlcmntBarr()));
        group.addBookmark(createBookmark("CADBTPR_COMMENTS", adoInfo.getTxtTprBarr()));
        group.addBookmark(createBookmark("CADRACC_COMMENTS", adoInfo.getTxtCntyAct()));
        if (exchangeChild != null) {
          // populate state recruitment activites
          populateStateRecruitmentActivities(group, idChildRegEvent);
          group.addBookmark(createBookmark("CD_STATE_ACTIVELY_RECRUITING", 
                                           Lookup.simpleDecodeSafe(CodesTables.CYESNONA, 
                                                                   (exchangeChild.getCdStateActivelyRecruiting() != null ? exchangeChild.getCdStateActivelyRecruiting() : CodesTables.CYESNONA_A))));
          group.addBookmark(createBookmark("CADRACS_COMMENTS", exchangeChild.getTxtRecruitComment()));
        }
        group.addBookmark(createBookmark(DT_FP_NT_TPR, FormattingHelper.formatDate(adoInfo.getDtIntTpr())));
        group.addBookmark(createBookmark(DT_PERM_STAFF, FormattingHelper.formatDate(adoInfo.getDtPermStaff())));
        group.addBookmark(createBookmark(DT_FPR_NTF_AG, FormattingHelper.formatDate(adoInfo.getDtDecAdopt())));
        group.addBookmark(createBookmark(DT_SL_SENT, FormattingHelper.formatDate(adoInfo.getDtLetterSent())));
        group.addBookmark(createBookmark(DT_CLH_PRS, FormattingHelper.formatDate(adoInfo.getDtLifeHisPres())));
        group.addBookmark(createBookmark(DT_STAFFING_AF, FormattingHelper.formatDate(adoInfo.getDtAdoStaff())));
        group.addBookmark(createBookmark(DT_ADO_PLCMT_SD, FormattingHelper.formatDate(adoInfo.getDtAdoAgree())));
        group.addBookmark(createBookmark(DT_PM_TO_FILE, FormattingHelper.formatDate(adoInfo.getDtPermFile())));
        group.addBookmark(createBookmark(DT_DOC_SENT, FormattingHelper.formatDate(adoInfo.getDtDocSent())));

        String indFpAdo = adoInfo.getIndFpAdo();

        if (indFpAdo != null) {
          if (YES.equals(indFpAdo)) {
            group.addBookmark(createBookmark(IND_FPR_NTF_OUTCOME, "Yes"));
          } else if (NO.equals(indFpAdo)) {
            group.addBookmark(createBookmark(IND_FPR_NTF_OUTCOME, "No"));
          }
        }

        Date disruptionDate = getDisruptionDate(primaryChild.getIdPerson(), idCase);
        group.addBookmark(createBookmark(DT_DR_DT, FormattingHelper.formatDate(disruptionDate)));
      
    }
    preFillData.addFormDataGroup(group);
  }

  private void populateCheckBoxes(int idAdoInfoEvent, int idChildRegEvent, FormDataGroup group) {

    try {
      // populate other checkboxes
      populateAdoptionInformationCheckboxes(group, idAdoInfoEvent, CodesTables.CADCPAC);
      populateAdoptionInformationCheckboxes(group, idAdoInfoEvent, CodesTables.CADBREC);
      populateAdoptionInformationCheckboxes(group, idAdoInfoEvent, CodesTables.CADBPLA);
      populateAdoptionInformationCheckboxes(group, idAdoInfoEvent, CodesTables.CADBTPR);
      // populateAdoptionInformationCheckboxes(group, idAdoInfoEvent, CodesTables.CADCPAC);
    } catch (LookupException e) {
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
  }

  private void populateStateRecruitmentActivities(FormDataGroup group, int idEvent){
    Map<String, List<Date>> existingDatesForCheckedRecActsState = getStateRecruitmentActivities(idEvent);

    // get all county recruitment codes and for these codes we will generatge the list below
    try{
      Collection recactscounty = Lookup.getCategoryCollection(CodesTables.CADRACS);
  
      Iterator recCode = recactscounty.iterator();
      while (recCode.hasNext()) {
        String recruitmentCode = ((CodeAttributes) recCode.next()).getCode();
  
        if (existingDatesForCheckedRecActsState.containsKey(recruitmentCode)) {
          StringBuffer dtListBuffer = new StringBuffer("");
          // add dates if they exits
          List<Date> datesForRecruitmentCode = existingDatesForCheckedRecActsState.get(recruitmentCode);
  
          List<Date> dateListToDisplay = null;
  
          if (datesForRecruitmentCode != null && datesForRecruitmentCode.size() > 10) {
            /* Truncate existing dates since we only plan to display the 10 most recent dates */
            // MR-083 Display the 10 most recent dates 
            dateListToDisplay = datesForRecruitmentCode.subList(0,10);
          } else if (datesForRecruitmentCode != null) {
            dateListToDisplay = datesForRecruitmentCode;
          }
  
          if (dateListToDisplay != null && !dateListToDisplay.isEmpty()) {
            Iterator dtIterator = dateListToDisplay.iterator();
            boolean firstDate = true;
            while (dtIterator.hasNext()) {
              Date dt = (Date) dtIterator.next();
  
              if (!firstDate)
                dtListBuffer.append(", ");
  
              dtListBuffer.append(FormattingHelper.formatDate(dt));
              firstDate = false;
            }
          }
          group.addBookmark(createBookmark("DT_LIST_CADRACS_" + recruitmentCode, dtListBuffer.toString()));
        }
      }
    }catch(LookupException le){
      // this should never happen
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private void populateCountyRecruitmentActivities(FormDataGroup group, int idEvent){
    Map<String, List<Date>> existingDatesForCheckedRecActsCounty = getCountyRecruitmentActivities(idEvent);

    // get all county recruitment codes and for these codes we will generatge the list below
    try{
      Collection recactscounty = Lookup.getCategoryCollection(CodesTables.CADRACC);
  
      Iterator recCode = recactscounty.iterator();
      while (recCode.hasNext()) {
        String recruitmentCode = ((CodeAttributes) recCode.next()).getCode();
  
        if (existingDatesForCheckedRecActsCounty.containsKey(recruitmentCode)) {
          StringBuffer dtListBuffer = new StringBuffer("");
          // add dates if they exits
          List<Date> datesForRecruitmentCode = existingDatesForCheckedRecActsCounty.get(recruitmentCode);
          List<Date> dateListToDisplay = null;
  
          if (datesForRecruitmentCode != null && datesForRecruitmentCode.size() > 10) {
            /* Truncate existing dates since we only plan to display the 10 most recent dates */
            // MR-083 Display the 10 most recent dates 
            dateListToDisplay = datesForRecruitmentCode.subList(0,10);
          } else if (datesForRecruitmentCode != null) {
            dateListToDisplay = datesForRecruitmentCode;
          }
  
          if (dateListToDisplay != null && !dateListToDisplay.isEmpty()) {
            Iterator dtIterator = dateListToDisplay.iterator();
            boolean firstDate = true;
            while (dtIterator.hasNext()) {
              Date dt = (Date) dtIterator.next();
  
              if (!firstDate)
                dtListBuffer.append(", ");
  
              dtListBuffer.append(FormattingHelper.formatDate(dt));
              firstDate = false;
            }
          }
          group.addBookmark(createBookmark("DT_LIST_CADRACC_" + recruitmentCode, dtListBuffer.toString()));
        }
      }
    }catch(LookupException le){
      // this should never occur
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private Map<String, List<Date>> getCountyRecruitmentActivities(int idEvent) {
    Map<String, List<Date>> existingDatesForCheckedRecActsCounty = new HashMap<String, List<Date>>();
    List<AdoInfoCbx> adoptioninformationCountyRecruitCbxList = new ArrayList<AdoInfoCbx>();
    adoptioninformationCountyRecruitCbxList = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent,
                                                                                                       "CADRACC");

    if (adoptioninformationCountyRecruitCbxList != null && !adoptioninformationCountyRecruitCbxList.isEmpty()) {
      Iterator itRecCt = adoptioninformationCountyRecruitCbxList.iterator();

      for (int i = 0; itRecCt.hasNext(); i++) {
        AdoInfoCbx cb1 = (AdoInfoCbx) itRecCt.next();

        List<Date> recruitmentActivityDates = adoInfoCbxSentDAO.findAdoInfoCbxSentDateByIdInfoCharIdEvent(cb1.getIdInfoChar(),
                                                                                                          idEvent);

        existingDatesForCheckedRecActsCounty.put(cb1.getCdAdoInfoCbx(), recruitmentActivityDates);
      }
    }

    return existingDatesForCheckedRecActsCounty;
  }

  private Map<String, List<Date>> getStateRecruitmentActivities(int idChildRegEvent) {
    List<ExcChildAdoInfoCbx> adoptioninformationcbx3List = new ArrayList<ExcChildAdoInfoCbx>();
    adoptioninformationcbx3List = excChildAdoInfoCbxDAO.findExcChildAdoInfoByIdEventByCdInfoCbx(idChildRegEvent,
                                                                                                CodesTables.CADRACS);

    Map<String, List<Date>> existingDatesForRecActsState = new HashMap<String, List<Date>>();

    if (adoptioninformationcbx3List != null && !adoptioninformationcbx3List.isEmpty()) {
      Iterator<ExcChildAdoInfoCbx> itRecSt = adoptioninformationcbx3List.iterator();

      for (int i = 0; itRecSt.hasNext(); i++) {
        ExcChildAdoInfoCbx cb1 = itRecSt.next();
        Date cbxDate = cb1.getDtPerformed();
        String cdAdoInfoCbx = cb1.getCdAdoInfoCbx();

        List<Date> stateRecruitmentDates = null;

        if (!existingDatesForRecActsState.containsKey(cdAdoInfoCbx)) {
          stateRecruitmentDates = new ArrayList<Date>();
          stateRecruitmentDates.add(cbxDate);
          existingDatesForRecActsState.put(cdAdoInfoCbx, stateRecruitmentDates);
        } else {
          stateRecruitmentDates = existingDatesForRecActsState.get(cdAdoInfoCbx);
          stateRecruitmentDates.add(cbxDate);
        }
      }
    }

    return existingDatesForRecActsState;
  }

  private Map<String, String> getAdoptionInformationCheckBox(int idEvent, String codeType) {
    List<AdoInfoCbx> adoptioninformationCbxList = new ArrayList<AdoInfoCbx>();
    adoptioninformationCbxList = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent, codeType);

    Map<String, String> mapOfCheckedValues = new HashMap<String, String>();

    if (adoptioninformationCbxList != null && !adoptioninformationCbxList.isEmpty()) {
      Iterator itCheckedValues = adoptioninformationCbxList.iterator();

      for (int i = 0; itCheckedValues.hasNext(); i++) {
        AdoInfoCbx cb1 = (AdoInfoCbx) itCheckedValues.next();

        String cbxCode = (String) cb1.getCdAdoInfoCbx();

        mapOfCheckedValues.put(cbxCode, cbxCode);
      }
    }
    return mapOfCheckedValues;
  }

  private void populateAdoptionInformationCheckboxes(FormDataGroup group, int idEvent, String codeType)
                                                                                                       throws LookupException {
    Map<String, String> mapOfCheckedValues = getAdoptionInformationCheckBox(idEvent, codeType);

    Collection checkBoxCollections = Lookup.getCategoryCollection(codeType);
    Iterator checkBoxCodeAttributes = checkBoxCollections.iterator();

    while (checkBoxCodeAttributes.hasNext()) {
      String checkboxCode = ((CodeAttributes) checkBoxCodeAttributes.next()).getCode();
      boolean indCheckBoxChecked = false;

      if (mapOfCheckedValues.get(checkboxCode) != null) {
        indCheckBoxChecked = true;
      }
      group.addBookmark(createBookmark("IND_" + codeType + "_" + checkboxCode, indCheckBoxChecked ? CAPX : "_"));
    }
  }

  private Date getDisruptionDate(int idChild, int idStage) {

    // Get the earliest, actual, non-concurrent placement for the child in the ADO stage to populate the Disruption
    // date.
    String cdStage = CodesTables.CSTAGES_ADO;
    Placement placement = placementDAO.findEndedPlcmtByIdChildByStageType(idChild, cdStage);

    // cdPlcmtRemovalRsn
    if (placement != null && (placement.getCdPlcmtRemovalRsn().equals(CodesTables.CRMRSNAC_ADF)) == false) {
      // if removal reason is anything other then adoption finalized
      // return the disrutption dae
      return placement.getDtPlcmtEnd();
    }
    return null;
  }
  
  private LegalAction getTPRFiled(int idCase, int idPerson, Collection<String> cdHrTypCrtOrds) {    
    // SMS #97845: MR-074-2
    String cdLegalActAction = CodesTables.CLEGCPS_PFD; // Petition Filed

    // SMS #97845: MR-074-2
    // Retrieve the most recent Court Order Date where:
    // 1. Legal Action Type = PFD (Petition Filed) AND
    // 2. Hearing/Court Order Type is one of the TPRs (TFA – TPR Adoptive Father, TPA – TPR Adoptive Mother, 
    //    TFB – TPR Biological Father, TFF – TPR Legal Father, TFL – TPR Biological and Legal Father, 
    //    TPM – TPR Biological Mother, TPP – TPR Putative Father)
    // Sort by Court Action Date Desc (using "A" parameter)
    return legalActionDAO.findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(idCase, idPerson, cdHrTypCrtOrds,
                                                                                      cdLegalActAction, "A");
  }
}
