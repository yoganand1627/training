package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingReasonEligDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DiversionConclusionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPlanLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersRelMapStgPrgDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageProgDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;
import gov.georgia.dhr.dfcs.sacwis.db.AaFundingReasonElig;
import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;
import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.ContactCbx;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.DiversionConclusion;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.EventPlanLink;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Situation;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageLink;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.StageProg;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseOpenStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Retrieve Race & Ethnicity for a person
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * swroberts   10/1/2008                 STGAP00010369: Updated so that a PAD Payment Intake
 *                                       retains the name of the selected child and not the AP.
 * bgehlot     09/09/2009                STGAP00015331: The date entered by the user is saved in the Stage table as dtStageClose
 * bgehlot     10/04/2009                STGAP00015485: MR-056 Added cdPKHouseholdMember in method insertStagePersonLinkWihoutIndNmStage and
 *                                       updateStagePersonLinkWithoutIndNmStage
 * cwells      12/15/2009                38677- copying side of family infromation when creating a new stage.
 * 05/26/2010  hjbaptiste                SMS#51977-MR66-Maltreatment In Care: Added indicator to indicate if Maltreatment in Care when
 *                                       copying allegations
 * 10/04/2011  schoi                     STGAP00017013: MR-095 Added logic to set relationships for FCC and FCF via Custody page                                      
 * 10/06/2011  schoi                     STGAP00017013: MR-095 Added relationship mapping logic for stage progression 
 *                                       from FCF to ONG via Stage Progression page
 * 10/06/2011  hnguyen                   STGAP00017011: MR-092 Added logic to create AA Funding for non-incident PAD and FCC to ADO progression.
 *                                       Also to assign MES worker from FCC to ADO if exists, otherwise assign PA for region.                                      
 * 10/12/2011  schoi                     STGAP00017013: MR-095 Updated code based on findings from peer review 
 *                                       including refactoring logic to use a static final Set
 * 10/17/2011  hnguyen                   STGAP00017239: MR-092 Update secondary assignment to set as new assignment to show up on workload.                                     
 * 10/17/2011  schoi                     STGAP00017013: MR-095 Expanded condition to compare stage name and person name
 *                                       to be in sync with the Custody code logic                                      
 * 10/18/2011  schoi                     STGAP00017269: MR-095 Added logic to update removal child's relationship to Self 
 *                                       in the existing FCF stage after Custody is completed                                    
 * 10/18/2011  hnguyen                   STGAP00017239: MR-092 Updated another secondary assignment logic to set as new assignment to show up on workload.                                     
 * 10/19/2011  schoi                     STGAP00017277: MR-095 Added condition to handle the stage progression from FCF to ONG 
 *                                       when a prior removal stage does not exist
 * 11/07/2011  hnguyen                   STGAP00017011: MR-092 Updated dao call to retrieve MES Program Assistant.                                     
 * 11/09/2011  hnguyen                   STGAP00017622: MR-092 Updated call to AAFundingDAO.findLatestValidatedAAFundingByIdChildByIdStage query 
 * 11/14/2011  schoi                     STGAP00017665: MR-095 Corrected the decode value of Relationship Mapping hierarchy for Custody
 *                                       for First Cousin Once Removed and Adoptive Parent
 * 11/15/2011  hnguyen                   STGAP00017668: MR-092 Added further restriction to avoid "carrying over" MES PA secondary assignment
 *                                       other than for stage progression from FCC to ADO, ADO to PAD, and INT to PAD.
 * 11/17/2011  hnguyen                   STGAP00017668: MR-092 Corrected task description to display stage dynamically based on progressed stage.
 *                                       
 * </PRE>
 */
public class CloseOpenStageImpl extends BaseServiceImpl implements CloseOpenStage {

  private AaFundingDAO aaFundingDAO = null;

  private AaFundingReasonEligDAO aaFundingReasonEligDAO = null;

  private AdminReviewDAO adminReviewDAO = null;

  private AdptSubEventLinkDAO adptSubEventLinkDAO = null;

  private AllegationDAO allegationDAO = null;
  
  private ContactDAO contactDAO = null;
  
  private ContactCbxDAO contactCbxDAO = null;
  
  private EventDAO eventDAO = null;

  private CapsCaseDAO capsCaseDAO = null;

  private CheckIfUserHasRight checkIfUserHasRight = null;

  private CloseStageCase closeStageCase = null;

  private ComplexEventDAO complexEventDAO = null;

  private ComplexPersonEligibilityDAO complexPersonEligibilityDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  
  private DiversionConclusionDAO diversionConclusionDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private EventPlanLinkDAO eventPlanLinkDAO = null;

  private IntakeAllegationDAO intakeAllegationDAO = null;
  
  private PersonDAO personDAO = null;

  private PersonEligibilityDAO personEligibilityDAO = null;

  private SituationDAO situationDAO = null;

  private StageDAO stageDAO = null;

  private StageLinkDAO stageLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private StagePersRelMapStgPrgDAO stagePersRelMapStgPrgDAO = null;  

  private StageProgDAO stageProgDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private TodoDAO todoDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  private AdoNewNameDAO adoNewNameDAO = null;

  private static final String INTAKE = CodesTables.CSTAGES_INT;

  private static final String INVESTIGATION = CodesTables.CSTAGES_INV;
  
  private static final String DIVERSION = CodesTables.CSTAGES_DIV;

  private static final String FPR_PROGRAM = CodesTables.CSTAGES_FPR;

  private static final String FSU_PROGRAM = CodesTables.CSTAGES_FSU;

  private static final String PFC_PROGRAM = CodesTables.CSTAGES_PFC;

  private static final String SUBCARE = CodesTables.CSTAGES_SUB;

  private static final String ADOPTION = CodesTables.CSTAGES_ADO;

  private static final String POST_ADOPT = CodesTables.CSTAGES_PAD;

  private static final String CHILD_SER_PLAN = "CSP";

  private static final String SERVICE_AUTH_TYPE = CodesTables.CEVNTTYP_AUT;

  private static final String FSU_SVC_AUTH_TASK = "4190";

  private static final String FAMILY_PRES_TASK = "7080";

  private static final String PERSON_ROLE_BOTH = CodesTables.CINVROLE_VC;

  private static final String PERSON_ROLE_PRIM_CHILD = CodesTables.CINVROLE_PC;

  private static final String PERSON_ROLE_PRINCIPAL = CodesTables.CPRSNTYP_PRN;
  
  // STGAP00017013: MR-095
  private static final String PERSON_REL_SELF = CodesTables.CRELVICT_SL;
  
  private static final String PARENT = "Parent";
  private static final String GRANDPARENT = "Grandparent";
  private static final String AUNT_UNCLE = "Aunt/Uncle";
  private static final String COUSIN = "Cousin";
  private static final String SIBLING = "Sibling";
  private static final String NON_RELATED = "Non Related";
  
  private static final String MALE = "M";
  private static final String FEMALE = "F";
  private static final String UNKNOWN = "U";
  
  private static final Set<String> PARENT_RELATIONSHIP_CATEGORY = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CRELVICT_AB,    // Absent Parent AB 
                                             CodesTables.CRELVICT_PT,    // Adoptive Parent PT
                                             CodesTables.CRELVICT_BB,    // Biological and Legal Father BB
                                             CodesTables.CRELVICT_BF,    // Biological Father BF
                                             CodesTables.CRELVICT_BM,    // Biological Mother BM
                                             CodesTables.CRELVICT_BP,    // Biological Parent BP
                                             CodesTables.CRELVICT_LF,    // Legal Father LF
                                             CodesTables.CRELVICT_LM,    // Legal Mother LM
                                             CodesTables.CRELVICT_PA,    // Parent PA
                                             CodesTables.CRELVICT_PF,    // Putative Father PF
                                             CodesTables.CRELVICT_ST})); // Step-Parent ST
  
  private static final Set<String> PARENT_RELATIONSHIP_GEN_SPECIFIC = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CRELVICT_BS,    // Biological Sibling
                                             CodesTables.CRELVICT_GP,    // Grandparent
                                             CodesTables.CRELVICT_HS,    // Half Sibling
                                             CodesTables.CRELVICT_SL,    // Self
                                             CodesTables.CRELVICT_SM,    // Self/Minor Parent
                                             CodesTables.CRELVICT_SB}));    // Sibling

  private static final Set<String> GRANDPARENT_RELATIONSHIP_GEN_SPECIFIC = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CRELVICT_AB,    // Absent Parent
                                             CodesTables.CRELVICT_PT,    // Adoptive Parent
                                             CodesTables.CRELVICT_AU,    // Aunt/Uncle
                                             CodesTables.CRELVICT_BB,    // Biological and Legal Father
                                             CodesTables.CRELVICT_BF,    // Biological Father
                                             CodesTables.CRELVICT_BM,    // Biological Mother
                                             CodesTables.CRELVICT_BP,    // Biological Parent
                                             CodesTables.CRELVICT_G2,    // Great Grandparent
                                             CodesTables.CRELVICT_LF,    // Legal Father
                                             CodesTables.CRELVICT_LM,    // Legal Mother
                                             CodesTables.CRELVICT_PA,    // Parent
                                             CodesTables.CRELVICT_ST}));    // Step-Parent
  
  private static final Set<String> AUNT_UNCLE_RELATIONSHIP_GEN_SPECIFIC = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CRELVICT_CO,    // First Cousin
                                             CodesTables.CRELVICT_GP}));    // Grandparent
  
  private static final Set<String> SIBLING_RELATIONSHIP_GEN_SPECIFIC = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CRELVICT_GC}));    // Grandchild
  
  // End STGAP00017013: MR-095  

  private static final String PERSON_ROLE_NONE = CodesTables.CINVROLE_NO;

  private static final String STAFF = CodesTables.CPRSNALL_STF;

  private static final String STAGE_PROG_OLD_STAGE = "O";

  private static final String STAGE_PROG_NEW_STAGE = "N";

  //private static final String EVENT_STATUS_PROCESS = CodesTables.CEVTSTAT_PROC;

  private static final String EVENT_TYPE_PLN = CodesTables.CEVNTTYP_PLN;

  private static final String CONCLUSION_EVENT = CodesTables.CEVNTTYP_CCL;
  
  private static final String DIVERSION_EVENT = CodesTables.CEVNTTYP_DIV;

  private static final String EMPTY_STR = StringHelper.EMPTY_STRING;

  private static final int SPECIAL_DATE = 99;

  private static final String STAGE_TYPE_REG = CodesTables.CSTGTYPE_REG;

  private static final String TODO_CODE = "SUB001";

  private static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  private static final String ADMIN_REVIEW = CodesTables.CSTAGES_ARI;

  private static final String STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  private static final String ADO_ELIGIBILITY_TASK = "8620"; // -- ADO, Eligibility Summary

  private static final String ADOPTION_SUBSIDY_TASK = "9115"; //-- ADO, Adoption Subsidy

  private static final String ADO_AA_FUNDING_TASK = "9118"; // -- ADO, AA Funding Summary

  private static final String PAD_ELIGIBILITY_TASK = "9110"; // -- PAD, Eligibility Summary

  private static final String PAD_SUBSIDY_TASK = "9105"; //-- PAD, Adoption Subsidy

  private static final String PAD_AA_FUNDING_TASK = "9103"; // -- PAD, AA Funding Summary

  private static final String FPR_SVC_AUTH_TASK = "7100";

  private static final String ADO_SVC_AUTH_TASK = "8530";

  private static final String PFC_SVC_AUTH_TASK = "2000";
  
  private static final String PAD_SVC_AUTH_TASK = "9020";
  
  private static final String INV_CONTACT_TASK = "2180";

  private static final String PRIMARY_ROLE_STAGE_CLOSED = CodesTables.CROLEALL_HP;

  private static final String PRIMARY_ROLE_STAGE_OPEN = CodesTables.CROLEALL_PR;

  private static final String ALERT_TODO = CodesTables.CTODOTYP_A;

  private static final String TASK_TODO = CodesTables.CTODOTYP_T;

  private static final String CAPS_PROG_CPS = CodesTables.CPGRMS_CPS;
  
  private static final String INDICATOR_1 = "1";

  private static final String SEC_REG_FAM_INDP_STF = "76";

  private static final String SEC_REG_FAM_INDP_MGMNT_STF = "77";
  
  private static final String SEC_MES_PROGRAM_ASSIST = "83";

  public void setAaFundingDAO(AaFundingDAO aaFundingDAO) {
    this.aaFundingDAO = aaFundingDAO;
  }

  public void setAaFundingReasonEligDAO(AaFundingReasonEligDAO aaFundingReasonEligDAO) {
    this.aaFundingReasonEligDAO = aaFundingReasonEligDAO;
  }

  public void setAdminReviewDAO(AdminReviewDAO adminReviewDAO) {
    this.adminReviewDAO = adminReviewDAO;
  }

  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setContactCbxDAO(ContactCbxDAO contactCbxDAO) {
    this.contactCbxDAO = contactCbxDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setComplexPersonEligibilityDAO(ComplexPersonEligibilityDAO complexPersonEligibilityDAO) {
    this.complexPersonEligibilityDAO = complexPersonEligibilityDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }
  
  public void setDiversionConclusionDAO(DiversionConclusionDAO diversionConclusionDAO){
    this.diversionConclusionDAO = diversionConclusionDAO;
  }
  

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setEventPlanLinkDAO(EventPlanLinkDAO eventPlanLinkDAO) {
    this.eventPlanLinkDAO = eventPlanLinkDAO;
  }

  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPersonEligibilityDAO(PersonEligibilityDAO personEligibilityDAO) {
    this.personEligibilityDAO = personEligibilityDAO;
  }

  public void setSituationDAO(SituationDAO situationDAO) {
    this.situationDAO = situationDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setStagePersRelMapStgPrgDAO(StagePersRelMapStgPrgDAO stagePersRelMapStgPrgDAO) {
    this.stagePersRelMapStgPrgDAO = stagePersRelMapStgPrgDAO;
  }
  
  public void setStageProgDAO(StageProgDAO stageProgDAO) {
    this.stageProgDAO = stageProgDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

   public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
   this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
   
   public void setAdoNewNameDAO(AdoNewNameDAO adoNewNameDAO) {
     this.adoNewNameDAO = adoNewNameDAO;
   }

  public CCMN03UO closeOpenStage(CCMN03UI ccmn03ui) throws ServiceException {
    CCMN03UO ccmn03uo = new CCMN03UO();
    String cSysIndSStgOpenOnly = ccmn03ui.getCSysIndSStgOpenOnly();
    List<StageProg> ccmnb8dStageProgList = null;
    ArchInputStruct ccmn03uiArchInputStruct = ccmn03ui.getArchInputStruct();
    String ccmn03uiSzCdStageOpen = ccmn03ui.getSzCdStageOpen();
    boolean openingStage = StringHelper.isValid(ccmn03uiSzCdStageOpen);
    String ccmn03uiSzCdStage = ccmn03ui.getSzCdStage();
    String ccmn03uiSzCdStageProgram = ccmn03ui.getSzCdStageProgram();
    String ccmn03uiSzCdStageReason = ccmn03ui.getSzCdStageReasonClosed();
    String ccmn03uiNmPersonFull = ccmn03ui.getSzNmPersonFull();
    // set this to use throughout whole method
    int idPrimaryWorker = 0;
    int ccmn03uiPrimaryChild = ccmn03ui.getUlScrIdPrimChild();
    int ccmn03uiIdStage = ccmn03ui.getUlIdStage();  
    // Update to handle Stage Progression for Subcare
    // In the case of opening a subcare stage, we don't necessarily
    // want to close the stage we are in, but we do want to open a
    // new stage for Subcare. We test an indicator passed in
    // before we perform the actions necessary to close the current
    // stage before opening the Subcare Stage. GRD
    if (!ArchitectureConstants.Y.equals(cSysIndSStgOpenOnly)) {
      ccmnb8dStageProgList = findStageProg(STAGE_PROG_OLD_STAGE, ccmn03uiSzCdStageOpen, ccmn03uiSzCdStage,
                                           ccmn03uiSzCdStageProgram, ccmn03uiSzCdStageReason);
    }

    Stage cint21dStage = stageDAO.findStageByIdStage(ccmn03uiIdStage);

    if (cint21dStage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Date cint21dDtStageClose = cint21dStage.getDtStageClose();

    // Check the Stage's DT STAGE CLOSED. If its value is not null then Stage
    // has already been closed so return a message to the user, else continue
    // with process
    // If the Stage has been closed and if the
    // CdStageOpen is ADMIN_REVIEW or FAD_REVIEW, then do NOT return
    // MSG_CMN_STAGE_CLOSED
    if (!DateHelper.isNull(cint21dDtStageClose) && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen)) {
      throw new ServiceException(Messages.MSG_CMN_STAGE_CLOSED);
    }
    // STGAP00007443 This will display the Intake Summary Status field as Closed for an Intake that has
    // been approved and Stage Progressed.
    // STGAP00008607 The PersonList did not display persons on Intake Information page for Closed intakes.
    if (INTAKE.equals(ccmn03uiSzCdStage)) {
      cint21dStage.getIncomingDetail().setCdIncmgStatus(CodesTables.CINCMGST_CLD);
      Calendar cal = Calendar.getInstance();
      Date sysdate = cal.getTime();
      cint21dStage.getIncomingDetail().setDtIncomingCallDisposed(sysdate);        
    }

    Date dtToday = new Date();
    int ccmn03uiIdPerson = ccmn03ui.getUlIdPerson();

    // In the case of opening a suxbcare stage, we don't necessarily
    // want to close the stage we are in, but we do want to open a
    // new stage for Subcare. We if test on an indicator passed in
    // before we perform the actions necessary to close the current
    // stage before opening the Subcare Stage.
    
    //-- check for indicator and also that cdStageOpen is valid since it will be null if
    //-- more than one StageProg record exists for the scenario (MANUAL progression mode)
    if (!ArchitectureConstants.Y.equals(cSysIndSStgOpenOnly)) { //&& StringHelper.isValid(ccmn03uiSzCdStageOpen)) {
      //STGAP00015331: The date entered by the user is saved in the Stage table as dtStageClose
      AdoNewName adoNewName = adoNewNameDAO.findAdoNewNameByIdStage(ccmn03uiIdStage);
      if(adoNewName != null){
        if(adoNewName.getDtStageCloseTemp() != null){
          dtToday = adoNewName.getDtStageCloseTemp();
        }
      }
      // ccmnd4dAUDdam
      int rowsUpdated = complexStageDAO.updateStageAndIncomingDetail(dtToday, ccmn03uiSzCdStageReason, ccmn03uiIdStage,
                                                                     ccmn03uiSzCdStage);
      //STGAP00015331: delete the row from ado_new_name table as the dt_stage_close_temp was temporarily put in that table
      if(!CodesTables.CSTAGES_ADO.equals(ccmn03uiSzCdStage)){
        adoNewNameDAO.deleteAdoNewNameByIdStage(ccmn03uiIdStage);
      }
      
      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      
      boolean insertEvent = false;
      String ccmn46iTxtEventDescr = null;
      String ccmn46iCdEventStatus = null;
      String ccmn46iCdEventType = null;

      // Only use the following fields from
      // Stage Progression record where CD_STAGE_PROG_OPEN is equal
      // to the stage selected for opening
      Iterator itCcmnb8dStageProg = ccmnb8dStageProgList.iterator();

      while (itCcmnb8dStageProg.hasNext()) {
        StageProg ccmnb8dStageProg = (StageProg) itCcmnb8dStageProg.next();
        
        ccmn46iTxtEventDescr = ccmnb8dStageProg.getTxtStageProgEvntDesc();
        ccmn46iCdEventStatus = ccmnb8dStageProg.getCdStageProgStatus();
        ccmn46iCdEventType = ccmnb8dStageProg.getCdStageProgEventType();
        
        String ccmnb8dCdStageProgOpen = ccmnb8dStageProg.getCdStageProgOpen();
        
        //-- if ccmn03uiSzCdStageOpen is valid, use matching open stage record to create opening event
        //-- otherwise, look for empty open stage record to create closing event
        if(openingStage) {
          insertEvent = ccmnb8dCdStageProgOpen != null && ccmnb8dCdStageProgOpen.equals(ccmn03uiSzCdStageOpen);
        } else {
          //-- condition for closing stage event
          insertEvent = !StringHelper.isValid(ccmnb8dCdStageProgOpen) && StringHelper.isValid(ccmn46iTxtEventDescr) &&
                        StringHelper.isValid(ccmn46iCdEventStatus) && StringHelper.isValid(ccmn46iCdEventType);
        }
        
        if(insertEvent) {
          break;
        }

//        if (ccmnb8dCdStageProgOpen != null && ccmnb8dCdStageProgOpen.equals(ccmn03uiSzCdStageOpen)) {
//          ccmn46iTxtEventDescr = eventDesc;
//          ccmn46iCdEventStatus = eventStatus;
//          ccmn46iCdEventType = eventType;
//          break;
//        }
      }
      
      if(insertEvent) {
        saveEvent(dtToday, ccmn03uiIdStage, ccmn03uiIdPerson, ccmn46iTxtEventDescr, ccmn46iCdEventStatus, null,
                  ccmn46iCdEventType);
      }
      // Retrieve the record in the STAGE_PERSON_LINK table for the staff
      // person assigned as "Primary" (PR) to ID STAGE.
      StagePersonLink ccmng2dStagePersonLink = findStagePersonLink(ccmn03uiIdStage);
      idPrimaryWorker = ccmng2dStagePersonLink.getPerson().getIdPerson();
      // Now that the primary worker for the closed stage has been
      // found, we need to update his/her record in the STAGE
      // PERSON LINK table and change the role from 'PR' (Primary)
      // to 'HP' (Historical Primary). In this way we will prevent
      // the next step from removing this link used in the Case
      // Summary window.
      String ccmn3diCdStagePersRelInt = ccmng2dStagePersonLink.getCdStagePersRelInt();
      String ccmn3diCdStagePersSearchInd = ccmng2dStagePersonLink.getCdStagePersSearchInd();
      String ccmn3diCdStagePersType = ccmng2dStagePersonLink.getCdStagePersType();
      String ccmn3diTxtStagePersNotes = ccmng2dStagePersonLink.getTxtStagePersNotes();
      int ccmn3diIdPerson = ccmng2dStagePersonLink.getPerson().getIdPerson();
      int ccmn3diIdStagePerson = ccmng2dStagePersonLink.getIdStagePersonLink();
      String ccmn3diIndStagePersInLaw = ccmng2dStagePersonLink.getIndStagePersInLaw();
      String ccmn3diIndStagePersReporter = ccmng2dStagePersonLink.getIndStagePersReporter();
      Date ccmn3diDtStagePersLink = ccmng2dStagePersonLink.getDtStagePersLink();
      Date ccmn3diLastUpdate = ccmng2dStagePersonLink.getDtLastUpdate();
      //STGAP00015485 MR-056 added cdPKHouseholdMember
      String cdPKHouseholdMember = ccmng2dStagePersonLink.getCdPKHshdMember();
      
      //38677 Side of Family Found on StagePersonLink instead of Person Detail
      String cdPersonSideOfFamily = ccmng2dStagePersonLink.getCdPersonSideOfFamily();
      
      //-- updates the PR StagePersonLink record to be HP
      saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_UPDATE, ccmn03uiIdStage,
                                          ccmn3diCdStagePersRelInt, PRIMARY_ROLE_STAGE_CLOSED,
                                          ccmn3diCdStagePersSearchInd, ccmn3diCdStagePersType,
                                          ccmn3diTxtStagePersNotes, ccmn3diIdPerson, ccmn3diIdStagePerson,
                                          ccmn3diIndStagePersInLaw, ccmn3diIndStagePersReporter,
                                          ArchitectureConstants.N, ccmn3diDtStagePersLink, ccmn3diLastUpdate, cdPKHouseholdMember, cdPersonSideOfFamily);
      
      //-- deletes PR and SE StagePersonLink records for idStage
      saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_DELETE, ccmn03uiIdStage,
                                          ccmn3diCdStagePersRelInt, PRIMARY_ROLE_STAGE_CLOSED,
                                          ccmn3diCdStagePersSearchInd, ccmn3diCdStagePersType,
                                          ccmn3diTxtStagePersNotes, ccmn3diIdPerson, ccmn3diIdStagePerson,
                                          ccmn3diIndStagePersInLaw, ccmn3diIndStagePersReporter,
                                          ArchitectureConstants.N, ccmn3diDtStagePersLink, ccmn3diLastUpdate, cdPKHouseholdMember, cdPersonSideOfFamily);

      if (!INTAKE.equals(ccmn03uiSzCdStage)) {
        // ccmnh1dAUDdam
        todoDAO.deleteTodoByIdTodoStageAndContactNotExist(ccmn03uiIdStage);
      }
    } // end if not cSysIndSStgOpenOnly

    // Before starting with all the edits and updates necessary for opening
    // a new stage, we must verify that the case associated with the stage
    // opened (CD STAGE OPEN) doesn't already have a stage of the same type
    // already opened. Example: if the new stage to open is "INV", but the
    // ID CASE associated with the stage being closed already has an open
    // "INV" stage, then the function must exit without opening the new
    // stage
    // Besides making sure that there is a Case, we don't want to open
    // another subcare stage if a Subcare, Adoption, Post Adoption or
    // Prep Adult stage is already open. If the current stage is one
    // of these types, we want to determine if the Primary Child used
    // in this stage is already the primary child in another Subcare
    // stage (not allowed functionally)
    // We NEVER want to stop the
    // user from opening a new Admin Review stage; these edit
    // checks are done in the functional window
    boolean bEA_Eligible;
    boolean bIndAutoAdopt = false;

    if (FPR_PROGRAM.equals(ccmn03uiSzCdStageOpen) && !ArchitectureConstants.Y.equals(cSysIndSStgOpenOnly)
        && INVESTIGATION.equals(ccmn03uiSzCdStage)) {

      bEA_Eligible = findCpsInvstDetailByIdStage(ccmn03uiIdStage);

      if (bEA_Eligible) {
        List<StagePersonLink> stagePersonLink = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(ccmn03uiIdStage,
                                                                                                  PERSON_ROLE_PRINCIPAL);
        Iterator itClsc18dStagePersonLink = stagePersonLink.iterator();

        while (itClsc18dStagePersonLink.hasNext()) {
          StagePersonLink clsc18dStagePersonLink = (StagePersonLink) itClsc18dStagePersonLink.next();
          Person clsc18dPerson = clsc18dStagePersonLink.getPerson();
          int csea1DiIdPersEligPerson = clsc18dPerson.getIdPerson();
          PersonEligibility cseca1dPersonEligibility = personEligibilityDAO.findPersonEligibilityByIdPersonAndEligType(csea1DiIdPersEligPerson);

          boolean bEA_12Months = false;
          if (cseca1dPersonEligibility != null) {
            org.exolab.castor.types.Date cseca1DiDtPersEligEnd = DateHelper.toCastorDate(cseca1dPersonEligibility.getDtPersEligEnd());

            if (!DateHelper.isBeforeToday(cseca1DiDtPersEligEnd)
                && cseca1dPersonEligibility.getDtPersEligEaDeny() == null) {

              String caudc9dCdPersEligPrgOpen;
              // TODO: cseca1dPersonEligibility.getDtPersEligStart() is a Date object, not a String; this will never work.
              if ("S".equals(cseca1dPersonEligibility.getDtPersEligStart())
                  && "S".equals(cseca1dPersonEligibility.getCdPersEligPrgOpen())) {
                caudc9dCdPersEligPrgOpen = "B";
              } else {
                caudc9dCdPersEligPrgOpen = "C";
              }
              complexPersonEligibilityDAO.updatePersonEligibility(csea1DiIdPersEligPerson, caudc9dCdPersEligPrgOpen);

            } else {
              org.exolab.castor.types.Date csec85dDtPersEligStart = DateHelper.toCastorDate(cseca1dPersonEligibility.getDtPersEligStart());
              // in the service, a DAO was called to add 1 year to a date, we don't need
              // to call a DAO to do this in java.
              org.exolab.castor.types.Date csec85dDtPersEligEnd = DateHelper.addToDate(csec85dDtPersEligStart, 1, 0, 0);

              if (!DateHelper.isAfterToday(csec85dDtPersEligEnd)) {
                bEA_12Months = true;
              }
            }
          }
          if (cseca1dPersonEligibility == null || bEA_12Months) {
            Date caudc9dDtPersEligStart = svcAuthDetailDAO.findDtEaEligibilityInitiated(ccmn03uiIdStage);
            complexPersonEligibilityDAO.insertPersonEligibility(caudc9dDtPersEligStart, csea1DiIdPersEligPerson);
          }
        } // end while
      } // end if bEA_Eligible
    } // end if FPR is the opening and INV is the existing

    int ccmn03uiIdPrimChild = ccmn03ui.getUlScrIdPrimChild();
    CapsCase cint21dCapsCase = cint21dStage.getCapsCase();
    int cint21dIdCase = cint21dCapsCase.getIdCase();

    if (openingStage && !SUBCARE.equals(ccmn03uiSzCdStageOpen) && !ADOPTION.equals(ccmn03uiSzCdStageOpen)
        && !POST_ADOPT.equals(ccmn03uiSzCdStageOpen) && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen)
        && !PFC_PROGRAM.equals(ccmn03uiSzCdStageOpen) && 0 != cint21dIdCase) {
      // if (!AGE_OUT.equals(ccmn03uiSzCdStageOpen)) {
      List<Map> stageListMap = stageDAO.findStageByIdCaseDtStageClose(cint21dIdCase);
      if (stageListMap != null && !stageListMap.isEmpty()) {

        Iterator ccmnf6dItStageListMap = stageListMap.iterator();
        while (ccmnf6dItStageListMap.hasNext()) {
          Map ccmnf6dItStageMap = (Map) ccmnf6dItStageListMap.next();
          String ccmnf6dCdStage = (String) ccmnf6dItStageMap.get("cdStage");
          // int ccmnf6dIdStage = (Integer) ccmnf6dItStageMap.get("idStage");
          // int clsc75dIdStageRelated = (Integer) ccmnf6dItStageMap.get("idStage");

          if (ccmnf6dCdStage.equals(ccmn03uiSzCdStageOpen)) {
            // if (INVESTIGATION.equals(ccmn03uiSzCdStage) && SERVICE_DELIVERY.equals(ccmn03uiSzCdStageOpen)) {
            //
            // // Move all persons not already assigned to the SVC Stage from the
            // // INV stage except for STF.
            //
            // List stagePersonLinkList = findStageStagePersonLinkByIdStageAndIdStageRelated(ccmn03uiIdStage,
            // clsc75dIdStageRelated);
            // if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {
            // Iterator itClsc75dStageList = stagePersonLinkList.iterator();
            //
            // while (itClsc75dStageList.hasNext()) {
            // Object[] itClsc75dStage = (Object[]) itClsc75dStageList.next();
            // String clsc75dCdStagePersRole = (String) itClsc75dStage[24];
            // String clsc75dCdStagePersType = (String) itClsc75dStage[26];
            // String clsc75dCdStagePersSearchInd = (String) itClsc75dStage[27];
            // String clsc75dTxtStagePersNotes = (String) itClsc75dStage[28];
            // String clsc75dIndStagePersInLaw = (String) itClsc75dStage[25];
            // Date clsc75dDtStagePersLink = (Date) itClsc75dStage[29];
            // String clsc75dCdStagePersRelInt = (String) itClsc75dStage[30];
            // String clsc75dIndStagePersReporter = (String) itClsc75dStage[31];
            // String clsc75dIndStagePersEmpNew = (String) itClsc75dStage[32];
            // int clsc75dIdPerson = (Integer) itClsc75dStage[23];
            // int clsc75dIdStagePerson = (Integer) itClsc75dStage[21];
            //
            // saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmnf6dIdStage,
            // clsc75dCdStagePersRelInt, clsc75dCdStagePersRole,
            // clsc75dCdStagePersSearchInd, clsc75dCdStagePersType,
            // clsc75dTxtStagePersNotes, clsc75dIdPerson,
            // clsc75dIdStagePerson, clsc75dIndStagePersInLaw,
            // clsc75dIndStagePersReporter, clsc75dIndStagePersEmpNew,
            // clsc75dDtStagePersLink, null);
            // } // end while
            // }// end if stagePersonLinkList is not empty
            // } // end if INV and SVC
            return ccmn03uo;
          } // end if the stage returned is the same as the stage being opened
        } // end while ccmnf6 has next
      } // end if stageListMap is not null or empty
      // } // end if it's not AGE OUT

      // All the logic in this else is here
      // to test if there is an open AOC stage. If an open AOC stage is found for
      // this person, we will return FND_SUCCESS as is done
      // above for finding an existing stage of the same
      // type being opened.
      // else {
      // // First we need to find the primary child in the stage
      // // Retrieve all rows from stage person link and find
      // // the PC
      // List<StagePersonLink> stagePersonLinkList = findStagePersonLinkRowsByIdStage(ccmn03uiIdStage);
      // if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {
      //
      // Iterator itCcmnb9dStagePersonLink = stagePersonLinkList.iterator();
      //
      // while (itCcmnb9dStagePersonLink.hasNext()) {
      // StagePersonLink ccmnb9dStagePersonLink = (StagePersonLink) itCcmnb9dStagePersonLink.next();
      // String ccmnb9dCdStagePersRole = ccmnb9dStagePersonLink.getCdStagePersRole();
      // int ccmnb9dIdPerson = ccmnb9dStagePersonLink.getPerson().getIdPerson();
      //
      // if (PERSON_ROLE_PRIM_CHILD.equals(ccmnb9dCdStagePersRole)) {
      // Iterator clsc45dItStageListMap = findStageByIdPersonInput(ccmnb9dIdPerson);
      //
      // // Loop through all the rows returned by
      // // looking for an AOC stage. If the date
      // // closed is null or max date, then return
      // // success but stop stage progression
      //
      // while (clsc45dItStageListMap.hasNext()) {
      // Map clsc45dStageMap = (Map) clsc45dItStageListMap.next();
      // String clsc45dCdStage = (String) clsc45dStageMap.get("cdStage");
      // Date clsc45dDtStageClose = (Date) clsc45dStageMap.get("dtStageClose");
      //
      // if ((AGE_OUT.equals(clsc45dCdStage) || SERVICE_DELIVERY.equals(clsc45dCdStage))
      // && (DateHelper.isNull(clsc45dDtStageClose) || DateHelper.MAX_JAVA_DATE.equals(clsc45dDtStageClose))) {
      // int csec29dIdPerson = findStagePersonLinkByCdStageIdPersonCdRoleIdcase(
      // ccmnb9dIdPerson,
      // (Integer) clsc45dStageMap
      // .get("idCase"),
      // PERSON_ROLE_CLIENT,
      // clsc45dCdStage);
      //
      // if (csec29dIdPerson > 0) {
      // return ccmn03uo;
      // }
      // } // end if age out or service delivery and date stage close is null or max
      // } // end if StageList has next
      // } // end if persons role is primary child
      // } // end while StagePersonLinkList has next
      // } // end if StagePersonLinkList is not null
      // } // end if it's not age out
    } // end if it's not many types of stages
    // We don't want to prevent the user from opening an
    // Admin Review stage ever in Stage Progression, all of
    // these edit checks are done in the Admin Review functional
    // window
    else if (openingStage && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen)) {
      // This dao only works for Foster Care Child stages, on other stages, we need to loop through all the open
      // stages for the child and see if the one being opened is already opened.
      if (SUBCARE.equals(ccmn03uiSzCdStageOpen)) {
        // cses21dQUERYdam
        long countOpenSubCareStages = stagePersonLinkDAO.countOpenSubCareStages(ccmn03uiPrimaryChild, PERSON_ROLE_PRIM_CHILD);
        if (countOpenSubCareStages > 0) {
          throw new ServiceException(Messages.MSG_SUB_SUBC_STAGE_EXISTS);
        }
      } else if (ccmn03uiIdPrimChild > 0) {
        // First we need to find the primary child in the stage Retrieve all rows from stage person link and find the PC
        // Retrieve all the records in the STAGE PERSON LINK table associated with the closed ID STAGE and copy to new
        // stage
        // If the primary child was passed into the function, we do not need to figure out who the PC is for the stage
        // we're coming from
        Iterator clsc45dItStageListMap = findStageByIdPersonInput(ccmn03uiIdPrimChild);
        // Loop through all the rows returned by
        // looking for an AOC stage. If the date
        // closed is null or max date, then return
        // success but stop stage progression
        while (clsc45dItStageListMap.hasNext()) {
          Map clsc45dStageMap = (Map) clsc45dItStageListMap.next();
          String clsc45dCdStage = (String) clsc45dStageMap.get("cdStage");
          Date clsc45dDtStageClose = (Date) clsc45dStageMap.get("dtStageClose");
          //make sure that the map is not null to prevent a NPE
          int clsc45dIdCase = 0;
          if( clsc45dStageMap.get("idCase") != null ) {
            clsc45dIdCase = (Integer) clsc45dStageMap.get("idCase");
          }
          if (clsc45dCdStage.equals(ccmn03uiSzCdStageOpen)
              && (DateHelper.isNull(clsc45dDtStageClose) || DateHelper.MAX_JAVA_DATE.equals(clsc45dDtStageClose))) {
            // Retrieve a row from stage person link based on stage, case, role and cdstage
            // CallCSEC29D
            int csec29dIdPerson = findStagePersonLinkByCdStageIdPersonCdRoleIdcase(ccmn03uiIdPrimChild, clsc45dIdCase,
                                                                                   PERSON_ROLE_PRIM_CHILD,
                                                                                   ccmn03uiSzCdStageOpen);
            if (csec29dIdPerson > 0) {
              if (!ADOPTION.equals(clsc45dCdStage)) {
                return ccmn03uo;
              }
              // This is being added for the manual opening of the Adoption
              // stage. If ulIdPrimaryChild is passed in, we are opening
              // the Adoption stage via the placement window. This is when
              // Service Authorizations are moved. We set a flag to know
              // that the Adoption stage is already open, but we need to
              // move the service authorizations now as opposed to when
              // the Adoption stage is manually opened.
              else if (ccmn03uiIdPrimChild == 0) {
                return ccmn03uo;
              } else {
                bIndAutoAdopt = true;
              }
            } // end if csesIdPerson >0
          } // end if date stage closed is null or max
        }// end while
      } else {
        // CallCCMNB9D
        List<StagePersonLink> stagePersonLinkList = findStagePersonLinkRowsByIdStage(ccmn03uiIdStage);
        if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {

          Iterator itCcmnb9dStagePersonLink = stagePersonLinkList.iterator();

          while (itCcmnb9dStagePersonLink.hasNext()) {
            StagePersonLink ccmnb9dStagePersonLink = (StagePersonLink) itCcmnb9dStagePersonLink.next();
            String ccmnb9dCdStagePersRole = ccmnb9dStagePersonLink.getCdStagePersRole();
            int idPrimChild = 0;
            if (PERSON_ROLE_PRIM_CHILD.equals(ccmnb9dCdStagePersRole)) {
              idPrimChild = ccmnb9dStagePersonLink.getPerson().getIdPerson();
              Iterator clsc45dItStageListMap = findStageByIdPersonInput(idPrimChild);
              // Loop through all the rows returned by
              // looking for an AOC stage. If the date
              // closed is null or max date, then return
              // success but stop stage progression
              while (clsc45dItStageListMap.hasNext()) {
                Map clsc45dStageMap = (Map) clsc45dItStageListMap.next();
                String clsc45dCdStage = (String) clsc45dStageMap.get("cdStage");
                Date clsc45dDtStageClose = (Date) clsc45dStageMap.get("dtStageClose");
                // make sure that the map is not null to prevent a NPE
                int clsc45dIdCase = 0;
                if( clsc45dStageMap.get("idCase") != null ) {
                  clsc45dIdCase = (Integer) clsc45dStageMap.get("idCase");
                }

                if (clsc45dCdStage.equals(ccmn03uiSzCdStageOpen)
                    && (DateHelper.isNull(clsc45dDtStageClose) || DateHelper.MAX_JAVA_DATE.equals(clsc45dDtStageClose))) {
                  // Retrieve a row from stage person link based on stage, case, role and cdstage
                  // CallCSEC29D
                  int csec29dIdPerson = findStagePersonLinkByCdStageIdPersonCdRoleIdcase(idPrimChild, clsc45dIdCase,
                                                                                         PERSON_ROLE_PRIM_CHILD,
                                                                                         ccmn03uiSzCdStageOpen);
                  if (csec29dIdPerson > 0) {
                    if (!ADOPTION.equals(clsc45dCdStage)) {
                      return ccmn03uo;
                    }
                    // This is being added for the manual opening of the Adoption
                    // stage. If ulIdPrimaryChild is passed in, we are opening
                    // the Adoption stage via the placement window. This is when
                    // Service Authorizations are moved. We set a flag to know
                    // that the Adoption stage is already open, but we need to
                    // move the service authorizations now as opposed to when
                    // the Adoption stage is manually opened.
                    else if (ccmn03uiIdPrimChild == 0) {
                      return ccmn03uo;
                    } else {
                      bIndAutoAdopt = true;
                    }
                  } // end if csesIdPerson >0
                } // end if date stage closed is null or max
              }// end while
            }
          }// end while
        }// end if stagePersonLinkList is not null
      } // end else ccmn03uIdPrimchild <0
    } // end else not admin review
    String cint21dCdStageCnty = cint21dStage.getCdStageCnty();

    // ACorley - I don't really think that bIndAutoAdopt can ever be true at this point
    // but I'm not sure, so leaving it in.
    if (openingStage && !bIndAutoAdopt) {
      // Retrieve Stage Progression info for NEW stage. This information
      // includes all the events and to-do's that need to be posted when
      // opening the new stage
      if (!StringHelper.isValid(ccmn03uiSzCdStageReason)) {
        ccmn03uiSzCdStageReason = ccmn03uiSzCdStage;
      }

      List<StageProg> ccmnb8dStageProgList2 = findStageProg(STAGE_PROG_NEW_STAGE, ccmn03uiSzCdStageOpen,
                                                            ccmn03uiSzCdStage, ccmn03uiSzCdStageProgram,
                                                            ccmn03uiSzCdStageReason);

      String cint12dCdStageClassification = cint21dStage.getCdStageClassification();

      String cint12dNmStage;
      Date cint12dDtStageStart;
      ccmn03uiNmPersonFull = ccmn03ui.getSzNmPersonFull();
      Date ccmn03uiDtStageStart = DateHelper.toJavaDate(ccmn03ui.getDtDtStageStart());
      String cint21dNmStage = cint21dStage.getNmStage();

      // If the Stage to open is not Foster Care Child, Adoption, Post Adoption (STGAP00010369)
      // Admin Review or Post Foster Care, use the Stage Name retrieved
      // in CINT21do. If the Stage to open is Foster Care Child, Adoption,
      // Admin Review or Post Foster Care, the victim's full name
      // should be used as the Stage Name
      if (!SUBCARE.equals(ccmn03uiSzCdStageOpen) && !ADOPTION.equals(ccmn03uiSzCdStageOpen)
          && !PFC_PROGRAM.equals(ccmn03uiSzCdStageOpen) && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen)
          && !POST_ADOPT.equals(ccmn03uiSzCdStageOpen)) {
        cint12dNmStage = cint21dNmStage;
      } else if (!StringHelper.isValid(ccmn03uiNmPersonFull)) {
        // If the NmPerson Full passed in is empty, use the previous
        // stage name as the new stage name.
        cint12dNmStage = cint21dNmStage;
      } else {
        cint12dNmStage = ccmn03uiNmPersonFull;
      }
      // If the date passed into the function is Null, then use
      // today's date (obtained above). If there is a date
      // passed in by the functional window, then use that instead.
      if (DateHelper.isNull(ccmn03uiDtStageStart)) {
        cint12dDtStageStart = dtToday;
      } else {
        cint12dDtStageStart = ccmn03uiDtStageStart;
      }

      Date cint12dDtStageClose = null;
      
      // Per STGAP00006397 Commented out the following code.
      /*if (ccmn03uiSzCdStageOpen.equals(ADMIN_REVIEW)) {
        cint12dDtStageClose = DateHelper.MAX_JAVA_DATE;
      }*/

      Situation cint21dSituation = cint21dStage.getSituation();
      Unit cint21dUnit = cint21dStage.getUnit();
      int cint12dIdCase = cint21dIdCase;
      int cint12dIdSituation = cint21dSituation.getIdSituation();
      int cint12dIdUnit = cint21dUnit.getIdUnit();

      String cint12dCdStageCurrPriority = cint21dStage.getCdStageCurrPriority();
      String cint12dCdStageInitialPriority = cint21dStage.getCdStageInitialPriority();

      String cint21dCdStageProgram = cint21dStage.getCdStageProgram();
      String cint12dCdStageProgram = cint21dCdStageProgram;

      String cint12dCdStageType;
      String cint21dCdStageRegion = cint21dStage.getCdStageRegion();

      String cint21dCdStageType = cint21dStage.getCdStageType();

      if (!SUBCARE.equals(ccmn03uiSzCdStageOpen)) {
        String ccmnb8dCdStageProgStageType = StringHelper.getNonNullString(ccmnb8dStageProgList2
                                                                           .get(0)
                                                                           .getCdStageProgStageType());

        if (!EMPTY_STR.equals(ccmnb8dCdStageProgStageType)) {

          cint12dCdStageType = ccmnb8dCdStageProgStageType;
          ccmn03uo.setSzCdStageType(ccmnb8dCdStageProgStageType);
        } else {
          cint12dCdStageType = cint21dCdStageType;
          ccmn03uo.setSzCdStageType(cint21dCdStageType);
        }
      } else if (INTAKE.equals(ccmn03uiSzCdStage)) {
        cint12dCdStageType = cint21dCdStageType;
        ccmn03uo.setSzCdStageType(cint21dCdStageType);
      } else {
        cint12dCdStageType = STAGE_TYPE_REG;
        ccmn03uo.setSzCdStageType(STAGE_TYPE_REG);
      }

      String ccmnB2dCdCaseProgram;
      String ccmnB2dCdCaseCounty;
      String ccmnB2dNmCase;

      if (POST_ADOPT.equals(ccmn03uiSzCdStageOpen) && !INTAKE.equals(ccmn03uiSzCdStage)) {

        ccmnB2dCdCaseCounty = cint21dCdStageCnty;
        ccmnB2dCdCaseProgram = cint21dCdStageProgram;
        List<StagePersonLink> stagePersonLinkList = findStagePersonLinkRowsByIdStage(ccmn03uiIdStage);
        if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {

          Iterator itCcmnb9dStagePersonLink = stagePersonLinkList.iterator();

          while (itCcmnb9dStagePersonLink.hasNext()) {
            StagePersonLink ccmnb9dStagePersonLink = (StagePersonLink) itCcmnb9dStagePersonLink.next();
            String ccmnb9dCdStagePersRole = ccmnb9dStagePersonLink.getCdStagePersRole();
            if (PERSON_ROLE_PRIM_CHILD.equals(ccmnb9dCdStagePersRole)) {
              ccmn03uiIdPrimChild = ccmnb9dStagePersonLink.getPerson().getIdPerson();
              break;
            }
          }
        }// end if stagePersonLinkList is not null

        List<Map> clss63dStagePersonLinkListMap = findResourceandStagePersonLinkByidPersonAndCdPlcmtActPlanned(ccmn03uiIdPrimChild);
        ccmnB2dNmCase = (String) clss63dStagePersonLinkListMap.get(0).get("nmResource");

        // int ccmnB2dIdCase = findIdCaseNew(ccmnB2dCdCaseProgram, ccmnB2dCdCaseCounty, new Date(), null,
        // ccmnB2dNmCase, cint21dCdStageRegion);

        CapsCase capsCase = new CapsCase();
        capsCase.setCdCaseProgram(ccmnB2dCdCaseProgram);
        capsCase.setCdCaseCounty(ccmnB2dCdCaseCounty);
        capsCase.setDtCaseOpened(dtToday);
        capsCase.setDtCaseClosed(null);
        capsCase.setNmCase(ccmnB2dNmCase);
        capsCase.setCdCaseRegion(cint21dCdStageRegion);
        // ccmnb2dAUDdam
        capsCaseDAO.saveCapsCase(capsCase);
        int ccmnB2dIdCase = capsCase.getIdCase();

        Situation situation = new Situation();
        situation.setCapsCase(capsCase);
        situation.setDtSituationOpened(dtToday);
        situation.setDtSituationClosed(null);

        // cint13dAUDdam - this service only uses insert
        situationDAO.saveSituation(situation);

        cint12dIdCase = ccmnB2dIdCase;
      }
      int idStage = complexStageDAO.insertStage(0, cint12dCdStageType, cint12dIdCase, cint12dDtStageClose,
                                                cint12dCdStageClassification, cint12dCdStageCurrPriority,
                                                cint12dCdStageInitialPriority, null, null, null, null,
                                                cint21dCdStageCnty, cint12dNmStage, cint21dCdStageRegion,
                                                cint12dDtStageStart, cint12dIdSituation, cint12dCdStageProgram,
                                                ccmn03uiSzCdStageOpen, null, cint12dIdUnit, null, null);

      if (idStage == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      ccmn03uo.setUlIdStage(idStage);

      // Post Stage Opening Events, Task-Events, and Task-To-Do's
      String ccmn46dCdEventType = null;
      int idConclusionEvent = 0;
      int idDiversionEvent = 0;
      int idServicePlanEvent = 0;
      Iterator itCcmnb8dStageProgList2 = ccmnb8dStageProgList2.iterator();

      // We're looping through the rows returned from the Stage
      // Progression table, we may need to post events. An
      // event should be posted if there is an event type in
      // that row of the stage progression table. Alerts will
      // not be posted as events, but todo's and informational
      // events (that the stage was created) will be posted.
      while (itCcmnb8dStageProgList2.hasNext()) {
        StageProg ccmnb8dStageProg = (StageProg) itCcmnb8dStageProgList2.next();
        String ccmnb8dCdStageProgEventType = ccmnb8dStageProg.getCdStageProgEventType();
        String ccmnb8dCdStageProgTodoInfo = ccmnb8dStageProg.getCdStageProgTodoInfo();
        String ccmnb8dTxtStageProgTodoDesc = ccmnb8dStageProg.getTxtStageProgTodoDesc();
        String ccmnb8dCdStageProgTask = ccmnb8dStageProg.getCdStageProgTask();
        String ccmnb8dTxtStageProgEvntDesc = ccmnb8dStageProg.getTxtStageProgEvntDesc();
        int ccmn46dIdEvent = 0;
        int ccmn03uoIdStage = idStage;

        if (StringHelper.isValid(ccmnb8dCdStageProgEventType)) {
          ccmn46dCdEventType = ccmnb8dCdStageProgEventType;

          ccmn46dIdEvent = saveEvent(dtToday, idStage, ccmn03uiIdPerson, ccmnb8dTxtStageProgEvntDesc,
                                     ccmnb8dStageProg.getCdStageProgStatus(), ccmnb8dCdStageProgTask,
                                     ccmn46dCdEventType);
        }

        // When progressing to Subcare, at this point in the logic
        // we do not know the Primary worker from the existing
        // stage to use as the primary worker for the new stage
        // We actually assign this worker to the new stage later
        // in the logic, but we need to know who the primary worker
        // will be to post the ToDo's correctly.
        // Don't find the primary staff person for Admin or FAD review
        int ccmng2dIdPerson = ccmn03ui.getUlIdPerson();

        if (idPrimaryWorker == 0 && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen)) {
          StagePersonLink ccmng2dStagePersonLink = findStagePersonLink(ccmn03uiIdStage);
          Person ccmng2dPerson = ccmng2dStagePersonLink.getPerson();
          ccmng2dIdPerson = ccmng2dPerson.getIdPerson();
          idPrimaryWorker = ccmng2dIdPerson;
        }

        if (StringHelper.isValid(ccmnb8dCdStageProgTodoInfo)) {
          CSUB40UI csub40ui = new CSUB40UI();
          CSUB40UIG00 csub40Uig00 = new CSUB40UIG00();
          csub40Uig00.setSzSysCdTodoCf(ccmnb8dCdStageProgTodoInfo);
          csub40Uig00.setUlSysIdTodoCfPersCrea(ccmng2dIdPerson);
          csub40Uig00.setUlSysIdTodoCfPersWkr(ccmn03uiIdPerson);
          csub40Uig00.setUlSysIdTodoCfStage(ccmn03uoIdStage);
          csub40Uig00.setUlSysIdTodoCfEvent(ccmn46dIdEvent);

          if (TODO_CODE.equals(ccmnb8dCdStageProgTodoInfo)) {
            csub40Uig00.setSzSysTxtTodoCfDesc(ccmnb8dTxtStageProgEvntDesc);
          }

          if ((DateHelper.isNull(ccmn03uiDtStageStart))) {
            csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtToday));
          } else {
            csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(ccmn03uiDtStageStart));
          }

          csub40ui.setCSUB40UIG00(csub40Uig00);
          //CSUB40UO csub40uo = todoCommonFunction.audTodo(csub40ui);
          todoCommonFunction.audTodo(csub40ui);

          //if (THREE_MONTH_REVIEW.equals(csub40uo.getSzCdTodoTask())) {
            //saveContact(csub40uo.getUlIdEvent(), csub40uo.getUlIdStage(), C3MT);
          //}
        }

        if (CONCLUSION_EVENT.equals(ccmn46dCdEventType)) {
          idConclusionEvent = ccmn46dIdEvent;
        } else if(DIVERSION_EVENT.equals(ccmn46dCdEventType)){
          idDiversionEvent = ccmn46dIdEvent;
        }else if (EVENT_TYPE_PLN.equals(ccmn46dCdEventType) || CHILD_SER_PLAN.equals(ccmn46dCdEventType)) {
          idServicePlanEvent = ccmn46dIdEvent;
        }
        // We only want to post the todo here if we did not post it with
        // the ToDo Common Function above. ToDo Common Function will not
        // post a todo if TodoInfo is empty, so we will let this posting
        // of todo's capture rows to be posted
        if (StringHelper.isValid(ccmnb8dTxtStageProgTodoDesc) && !StringHelper.isValid(ccmnb8dCdStageProgTodoInfo)) {
          String ccmn43dCdTodoType;

          if (FAMILY_PRES_TASK.equals(ccmnb8dCdStageProgTask)) {
            ccmn43dCdTodoType = ALERT_TODO;
          } else {
            ccmn43dCdTodoType = TASK_TODO;
          }

          int ccmn43dIdTodoPersAssigned;
          int ccmn43dIdTodoPersWorker;

          if (0 != ccmn03uiIdPerson) {
            ccmn43dIdTodoPersAssigned = ccmn03uiIdPerson;
            ccmn43dIdTodoPersWorker = ccmn03uiIdPerson;
          } else {
            ccmn43dIdTodoPersAssigned = ccmng2dIdPerson;
            ccmn43dIdTodoPersWorker = ccmng2dIdPerson;
          }

          Calendar ccmn43dNow = Calendar.getInstance();
          ccmn43dNow.setTime(dtToday);

          if (SPECIAL_DATE == ccmnb8dStageProg.getNbrStageProgDaysDue()) {
            ccmn43dNow.add(Calendar.MONTH, 1);
            ccmn43dNow.set(Calendar.DATE, 15);
          } else {
            ccmn43dNow.add(Calendar.DATE, ccmnb8dStageProg.getNbrStageProgDaysDue());
          }

          Date dueDate = ccmn43dNow.getTime();

          // MR-092 Assign AFS event to secondary assigned MES from old stage, if any.
          // if no MES assigned in previous stage, assigned to Program Assistant based on old stage region.
          if (PAD_AA_FUNDING_TASK.equals(ccmnb8dCdStageProgTask) 
                          || ADO_AA_FUNDING_TASK.equals(ccmnb8dCdStageProgTask)) {
            List<Integer> mesWorkerOrPaList = getSecondaryAssignedMesWorkers(ccmn03uiIdStage);

            if(!mesWorkerOrPaList.isEmpty()){
                Integer idMesPaPerson = mesWorkerOrPaList.get(0);

                saveTodo(ccmnb8dCdStageProgTask, TASK_TODO, dtToday, dtToday, dtToday, null, cint21dIdCase,
                         ccmn46dIdEvent, idMesPaPerson, 0, idMesPaPerson, ccmn03uoIdStage,
                         "AA Funding Summary created and requires validation.", null);
            }else{
              // no assigned MES in previous stage therefore assign alert to Program assistant
              String cdStageRegion = retrieveStageRegionByStageId(idStage);
              mesWorkerOrPaList = unitEmpLinkDAO.findMESProgramAssistantByCdRegion(cdStageRegion);
              
              if(!mesWorkerOrPaList.isEmpty()){
                Integer idMesPaPerson = mesWorkerOrPaList.get(0);

                saveTodo(ccmnb8dCdStageProgTask, ALERT_TODO, dtToday, dtToday, dtToday, null, cint21dIdCase,
                         0, idMesPaPerson, 0, idMesPaPerson, ccmn03uoIdStage,
                         "Please add a secondary assignment (Revmax) in the " + ccmn03uiSzCdStageOpen + " stage for " + cint12dNmStage, null);
              }
            }
            
          } else {
            saveTodo(ccmnb8dCdStageProgTask, ccmn43dCdTodoType, dtToday, dueDate, dueDate, null, cint21dIdCase,
                     ccmn46dIdEvent, ccmn43dIdTodoPersAssigned, 0, ccmn43dIdTodoPersWorker, ccmn03uoIdStage,
                     ccmnb8dTxtStageProgTodoDesc, null);
          }

          //if (CONTACT.equals(ccmnb8dCdStageProgEventType)) {
            //String csys07dCdContactType = BMTH;
            //saveContact(ccmn46dIdEvent, ccmn03uoIdStage, csys07dCdContactType);
          //}
        }

        if (ADMIN_REVIEW.equals(ccmnb8dCdStageProgEventType)) {
          saveAdminReview(ccmn03uoIdStage, ccmn03uiIdPrimChild, ccmn46dIdEvent, ccmn03uiIdStage);
        }
      } // end while itCcmnb8dStageProgList2.hasNext()

      int ccmn03uoIdStage = ccmn03uo.getUlIdStage();

      // Check if CD STAGE (the one that was closed) is 'INT' or 'DIV'. If so,
      // perform transfer of Intake Allegations to Allegation table
      if (INTAKE.equals(ccmn03uiSzCdStage) || DIVERSION.equals(ccmn03uiSzCdStage)) {
        // IncomingFacility cint09dIncomingFacility = null;
        List<Map> intakeAllegationsListMap = null;
        if (DIVERSION.equals(ccmn03uiSzCdStage)){
          // If we're progressing from Diversion, find the previous Intake stage to Get the Allegations
          int id_prior_stage = stageLinkDAO.findPreviousIdStagebyIdStage(ccmn03uiIdStage);
          intakeAllegationsListMap = intakeAllegationDAO.findIntakeAllegationsByIdStage(id_prior_stage);
        }else {
          intakeAllegationsListMap = intakeAllegationDAO.findIntakeAllegationsByIdStage(ccmn03uiIdStage);
        }

        if (intakeAllegationsListMap != null && !intakeAllegationsListMap.isEmpty()) {
          Iterator itCint19dIntakeAllegationListMap = intakeAllegationsListMap.iterator();

          while (itCint19dIntakeAllegationListMap.hasNext()) {
            Map cint19dIntakeAllegationMap = (Map) itCint19dIntakeAllegationListMap.next();
            // During the INV stage the TYPE is really displaying the Code from the Intake stage
            String cinv07dCdIntakeAllegType = (String) cint19dIntakeAllegationMap.get("cdAllegedMalCode");
            int cint07dIdVictim = (Integer) cint19dIntakeAllegationMap.get("personByIdVictim");
            int cint07dIdAllegedPerpetrator = (Integer) cint19dIntakeAllegationMap.get("personByIdAllegedPerpetrator") != null ? 
            		(Integer) cint19dIntakeAllegationMap.get("personByIdAllegedPerpetrator") : 0;
                        
            String cinv07dCdMaltreatorRel = (String) cint19dIntakeAllegationMap.get("cdMaltreatorRel");                        
            		
            String cinv07dCdAllegedMalLocation = (String) cint19dIntakeAllegationMap.get("cdAllegedMalLocation");
            
            // Get indicator to indicate if Maltreatment in Care
            String cinv07dIndMaltreatInCare = (String) cint19dIntakeAllegationMap.get("indMaltreatInCare"); 
                                                                                                                                                                     
             // Get date of alleged incident
             Date cint07dDtAllegedIncident = (Date) cint19dIntakeAllegationMap.get("dtAllegedIncident");
            
            
                                                                                                                                                                     
            // int cint07dIdAllegation = (Integer) cint19dIntakeAllegationMap.get("idAllegation");
            String cinv07dTxtAllegDuration = null;
            //
            // if (!CAPS_PROG_CPS.equals(ccmn03uiSzCdStageProgram) && !CAPS_PROG_CCL.equals(ccmn03uiSzCdStageProgram)
            // && !CAPS_PROG_RCL.equals(ccmn03uiSzCdStageProgram)) {
            //
            // cinv07dTxtAllegDuration = (String) cint19dIntakeAllegationMap.get("txtIntakeAllegDuration");
            // }

            saveAllegation(INTAKE, cinv07dCdIntakeAllegType, cint07dIdAllegedPerpetrator, ccmn03uoIdStage,
                           cint07dIdVictim, cinv07dTxtAllegDuration, cint07dDtAllegedIncident, 
                           cinv07dCdAllegedMalLocation, cinv07dCdMaltreatorRel, cinv07dIndMaltreatInCare);
            // // When an INTake stage is progressed and the
            // // Program is AFC, a dummy row needs to be added to the
            // // FACIL_ALLEG table for each row added to the ALLEGATION
            // // table.
            // if (CAPS_PROG_AFC.equals(ccmn03uiSzCdStageProgram)) {
            // int cinb4dRowsUpdated = facilAllegDAO
            // .insertFacilAllegDummyRow(
            // cint07dIdAllegation,
            // cint09dIncomingFacility
            // .getIndIncmgFacilOffGrnds(),
            // cint09dIncomingFacility
            // .getIndIncmgFacilAbSupvd());
            //
            // if (cinb4dRowsUpdated == 0) {
            // throw new ServiceException(Messages.SQL_NOT_FOUND);
            // }
            // }// end if AFC
          } // end while
        }// end if allegationListMap is not null
      }// end if intake

      // Check if CD STAGE (the one that was closed) is 'DIV' ant the opening stage is 'INV'. If so,
      // perform transfer of Diversion Initial Contact to Contact table
      if (DIVERSION.equals(ccmn03uiSzCdStage) && INVESTIGATION.equals(ccmn03uiSzCdStageOpen)) {
        saveInitialContact(dtToday, ccmn03uiIdStage, ccmn03uiIdPerson, ccmn03uoIdStage);
      }
      
      Date cint21dDtStageStart = cint21dStage.getDtStageStart();

      if (INVESTIGATION.equals(ccmn03uiSzCdStageOpen) && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen)) {
        if (CAPS_PROG_CPS.equals(ccmn03uiSzCdStageProgram)) {
          Date cint12dDtCPSInvstDtlIntake;

          if (INTAKE.equals(ccmn03uiSzCdStage)) {
            // STGAP00009603 - preserve time portion in intake date
            //cint12dDtCPSInvstDtlIntake = cint21dDtStageStart;
            cint12dDtCPSInvstDtlIntake = ((IncomingDetail) getPersistentObject(IncomingDetail.class, ccmn03uiIdStage)).getDtIncomingCall();
          } else if (DIVERSION.equals(ccmn03uiSzCdStage)){
            // If we're progressing from Diversion, find the previous Intake stage to set the date the Intake started
            // for the CPS INVESTIGATION DETAIL
            int id_prior_stage = stageLinkDAO.findPreviousIdStagebyIdStage(ccmn03uiIdStage);
            // STGAP00009603 - preserve time portion in intake date
            //Map intakeStage = stageLinkDAO.findStageLinkPreviousStage(id_prior_stage);
            //cint12dDtCPSInvstDtlIntake = (Date) intakeStage.get("dtStageStart");
            cint12dDtCPSInvstDtlIntake = ((IncomingDetail) getPersistentObject(IncomingDetail.class, id_prior_stage)).getDtIncomingCall();
          } else { 
          
            cint12dDtCPSInvstDtlIntake = null;
          }

          saveCpsInvstDetail(ccmn03uoIdStage, idConclusionEvent, cint12dDtCPSInvstDtlIntake, null, dtToday, null);

          // }
          // else if (CAPS_PROG_CCL.equals(ccmn03uiSzCdStageProgram) || CAPS_PROG_RCL.equals(ccmn03uiSzCdStageProgram))
          // {
          // Date cinv53dDtLicngInvstIntake;
          //
          // if (INTAKE.equals(ccmn03uiSzCdStage)) {
          // cinv53dDtLicngInvstIntake = cint21dDtStageStart;
          // } else {
          // cinv53dDtLicngInvstIntake = DateHelper.NULL_JAVA_DATE;
          // }
          //
          // insertLicensingInvstDtl(ccmn03uoIdStage, idConclusionEvent, dtToday, cinv53dDtLicngInvstIntake, dtToday,
          // DateHelper.NULL_JAVA_DATE);
          //
          // // } else if (CAPS_PROG_AFC.equals(ccmn03uiSzCdStageProgram)) {
          // // Date cinv54dDtFacilInvstIntake;
          // // Date dtIncomingCall;
          // //
          // // if (INTAKE.equals(ccmn03uiSzCdStage)) {
          // // dtIncomingCall = incomingDetailDAO.findIncomingDetailDtByIdStage(ccmn03uiIdStage);
          // // cinv54dDtFacilInvstIntake = dtIncomingCall;
          // // } else {
          // // cinv54dDtFacilInvstIntake = DateHelper.NULL_JAVA_DATE;
          // // }
          // //
          // // insertFacilityInvstDtl2(ccmn03uoIdStage, idConclusionEvent, DateHelper.NULL_JAVA_DATE,
          // // cinv54dDtFacilInvstIntake, DateHelper.NULL_JAVA_DATE, DateHelper.NULL_JAVA_DATE);
          //
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      } // end if stage is INV

      //if diversion
      if(DIVERSION.equals(ccmn03uiSzCdStageOpen)){
        saveDiversionConclusion(ccmn03uoIdStage, idDiversionEvent);
      }//end if diversion
      
      if ((SUBCARE.equals(ccmn03uiSzCdStageOpen) || FPR_PROGRAM.equals(ccmn03uiSzCdStageOpen) || FSU_PROGRAM
                                                                                                            .equals(ccmn03uiSzCdStageOpen))
          && (idServicePlanEvent != 0)) {
        
        EventPlanLink eventPlanLink = new EventPlanLink();
        eventPlanLink.setIdEventFamilyPlanLink(0); //-- not necessary, but for clarity
        eventPlanLink.setIndImpactCreated(ArchitectureConstants.Y);
        eventPlanLink.setEvent(getPersistentObject(Event.class, idServicePlanEvent));
        eventPlanLinkDAO.saveEventPlanLink(eventPlanLink);
      }

      if (!ArchitectureConstants.Y.equals(cSysIndSStgOpenOnly)) {
        List<StagePersonLink> stagePersonLinkList = findStagePersonLinkRowsByIdStage(ccmn03uiIdStage);
        if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {

          Iterator itCcmnb9dStagePersonLink = stagePersonLinkList.iterator();

          boolean bMesAssigned = false;

          while (itCcmnb9dStagePersonLink.hasNext()) {
            StagePersonLink ccmnb9dStagePersonLink = (StagePersonLink) itCcmnb9dStagePersonLink.next();
            String ccmnb9dCdStagePersRole = ccmnb9dStagePersonLink.getCdStagePersRole();
            String ccmnb9dCdStagePersType = ccmnb9dStagePersonLink.getCdStagePersType();
            Person ccmnb9dPerson = ccmnb9dStagePersonLink.getPerson();
            int ccmnb9dIdPerson = ccmnb9dPerson.getIdPerson();
            String ccmnd3dCdStagePersRole;
            String ccmnd3dCdStagePersType;

            if (ccmnb9dIdPerson == ccmn03ui.getUlScrIdPrimChild()
                && (SUBCARE.equals(ccmn03uiSzCdStageOpen) || ADOPTION.equals(ccmn03uiSzCdStageOpen)
                    || POST_ADOPT.equals(ccmn03uiSzCdStageOpen) || PFC_PROGRAM.equals(ccmn03uiSzCdStageOpen))) {

              ccmnd3dCdStagePersRole = PERSON_ROLE_PRIM_CHILD;
              ccmnd3dCdStagePersType = ccmnb9dCdStagePersType;

            } else {
              ccmnd3dCdStagePersRole = ccmnb9dCdStagePersRole;
              ccmnd3dCdStagePersType = ccmnb9dCdStagePersType;
            }

            // ACorley - Although I have left a lot of the APS functionality in here
            // in case it is useful in GA, I have taken out the code for
            // aged characteristic, b/c no person should be marked aged for purpsoses
            // of a case in SACWIS

            String ccmnb9dIndStagePersEmpNew = ccmnb9dStagePersonLink.getIndStagePersEmpNew();
            String ccmnb9dTxtStagePersNotes = ccmnb9dStagePersonLink.getTxtStagePersNotes();
            String ccmnb9dIndStagePersInLaw = ccmnb9dStagePersonLink.getIndStagePersInLaw();
            int ccmnb9dIdStagePerson = ccmnb9dStagePersonLink.getIdStagePersonLink();
            Date ccmnb9dDtLastUpdate = ccmnb9dStagePersonLink.getDtLastUpdate();
            String ccmnb9dCdStagePersSearchInd = ccmnb9dStagePersonLink.getCdStagePersSearchInd();
            String ccmnb9dIndStagePersReporter = ccmnb9dStagePersonLink.getIndStagePersReporter();
            Date ccmnb9dDtStagePersLink = ccmnb9dStagePersonLink.getDtStagePersLink();
            String ccmnd3dCdStagePersRelInt = ccmnb9dStagePersonLink.getCdStagePersRelInt();
            //STGAP00015485 MR-056 added cdPKHouseholdMember
            String cdPKHouseholdMember = ccmnb9dStagePersonLink.getCdPKHshdMember();
            //38677 Side of Family Found on StagePersonLink instead of Person Detail
            String cdPersonSideOfFamily = ccmnb9dStagePersonLink.getCdPersonSideOfFamily();

            // cjg 09/16/06 - changed from PRIMARY_ROLE_STAGE_CLOSED to PRIMARY_ROLE_STAGE_OPEN for SHINES.
            // The HP role hasn't taken effect yet in the DB
            if (!PRIMARY_ROLE_STAGE_OPEN.equals(ccmnb9dCdStagePersRole)) {
              if (!POST_ADOPT.equals(ccmn03uiSzCdStageOpen)) {
                saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                                    ccmnd3dCdStagePersRelInt, ccmnd3dCdStagePersRole,
                                                    ccmnb9dCdStagePersSearchInd, ccmnd3dCdStagePersType, null,
                                                    ccmnb9dIdPerson, 0, ccmnb9dIndStagePersInLaw,
                                                    ccmnb9dIndStagePersReporter, null, dtToday, null, cdPKHouseholdMember, cdPersonSideOfFamily);
              } else if (PERSON_ROLE_PRIM_CHILD.equals(ccmnb9dCdStagePersRole)
                         || (INTAKE.equals(ccmn03uiSzCdStage) && !STAFF.equals(ccmnb9dCdStagePersType))) {

                saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                                    ccmnd3dCdStagePersRelInt, ccmnd3dCdStagePersRole,
                                                    ccmnb9dCdStagePersSearchInd, ccmnd3dCdStagePersType,
                                                    ccmnb9dTxtStagePersNotes, ccmnb9dIdPerson, ccmnb9dIdStagePerson,
                                                    ccmnb9dIndStagePersInLaw, ccmnb9dIndStagePersReporter,
                                                    ccmnb9dIndStagePersEmpNew, ccmnb9dDtStagePersLink,
                                                    ccmnb9dDtLastUpdate, cdPKHouseholdMember, cdPersonSideOfFamily);
              } // end else if primary child, or intake and not staff
              
              // MR-092: If new stage is non-incident pad then copy over the MES secondary assignment from previous stage, if any
              if (STAFF.equals(ccmnd3dCdStagePersType)
                  && CodesTables.CROLEALL_SE.equals(ccmnb9dCdStagePersRole)
                  && (checkIfUserHasRight.determineIfUserHasRight(ccmnb9dIdPerson, SEC_REG_FAM_INDP_STF) 
                                  || checkIfUserHasRight.determineIfUserHasRight(ccmnb9dIdPerson, SEC_REG_FAM_INDP_MGMNT_STF)
                                  || checkIfUserHasRight.determineIfUserHasRight(ccmnb9dIdPerson, SEC_MES_PROGRAM_ASSIST))
                  && POST_ADOPT.equals(ccmn03uiSzCdStageOpen)
                  && INTAKE.equals(ccmn03uiSzCdStage)) {

                saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                                    ccmnd3dCdStagePersRelInt, ccmnd3dCdStagePersRole,
                                                    ccmnb9dCdStagePersSearchInd, ccmnd3dCdStagePersType, null,
                                                    ccmnb9dIdPerson, 0, ccmnb9dIndStagePersInLaw,
                                                    ccmnb9dIndStagePersReporter, INDICATOR_1, dtToday, null,
                                                    cdPKHouseholdMember, cdPersonSideOfFamily);
                
                saveTodo("", ALERT_TODO, dtToday, dtToday, dtToday, null, cint21dIdCase,
                         0, ccmnb9dIdPerson, 0, ccmnb9dIdPerson, ccmn03uoIdStage,
                         "New Secondary Assignment", null);

                bMesAssigned = true;
              } // end if a staff and new stage is PAD
            }// end if not historical primary
          } // end while

          // MR-092 if looped through old stage stage person links did not assign any MES worker then
          // assign MES Program Assistant as secondary to the new stage.
          if(!bMesAssigned
                          && POST_ADOPT.equals(ccmn03uiSzCdStageOpen)
                          && INTAKE.equals(ccmn03uiSzCdStage)){
            String cdStageRegion = retrieveStageRegionByStageId(idStage);
            List<Integer> mesWorkerOrPaList = unitEmpLinkDAO.findMESProgramAssistantByCdRegion(cdStageRegion);
            
            if(mesWorkerOrPaList != null && !mesWorkerOrPaList.isEmpty()){
              saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                                  null, CodesTables.CROLEALL_SE,
                                                  ServiceConstants.FND_NO, STAFF, null,
                                                  mesWorkerOrPaList.get(0), 0, null,
                                                  null, INDICATOR_1, dtToday, null,
                                                  null, null);

              saveTodo("", ALERT_TODO, dtToday, dtToday, dtToday, null, cint21dIdCase,
                       0, mesWorkerOrPaList.get(0), 0, mesWorkerOrPaList.get(0), ccmn03uoIdStage,
                       "New Secondary Assignment", null);

            }
          }
          
        } // end if stagePersonLinkList is not null

        // if (INVESTIGATION.equals(ccmn03uiSzCdStage) && SERVICE_DELIVERY.equals(ccmn03uiSzCdStageOpen)) {
        // List stageList = findStageStagePersonLinkByIdStageAndIdStageRelated(ccmn03uiIdStage, ccmn03uoIdStage);
        // if (stageList != null && !stageList.isEmpty()) {
        // Iterator itClsc75dStageList = stageList.iterator();
        // while (itClsc75dStageList.hasNext()) {
        // Object[] itClsc75dStage = (Object[]) itClsc75dStageList.next();
        // String clsc75dCdStagePersRole = (String) itClsc75dStage[24];
        // String clsc75dCdStagePersType = (String) itClsc75dStage[26];
        // String clsc75dCdStagePersSearchInd = (String) itClsc75dStage[27];
        // String clsc75dTxtStagePersNotes = (String) itClsc75dStage[28];
        // String clsc75dIndStagePersInLaw = (String) itClsc75dStage[25];
        // Date clsc75dDtStagePersLink = (Date) itClsc75dStage[29];
        // String clsc75dCdStagePersRelInt = (String) itClsc75dStage[30];
        // String clsc75dIndStagePersReporter = (String) itClsc75dStage[31];
        // String clsc75dIndStagePersEmpNew = (String) itClsc75dStage[32];
        // int clsc75dIdPerson = (Integer) itClsc75dStage[23];
        // int clsc75dIdStagePerson = (Integer) itClsc75dStage[21];
        //
        // saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
        // clsc75dCdStagePersRelInt, clsc75dCdStagePersRole,
        // clsc75dCdStagePersSearchInd, clsc75dCdStagePersType,
        // clsc75dTxtStagePersNotes, clsc75dIdPerson, clsc75dIdStagePerson,
        // clsc75dIndStagePersInLaw, clsc75dIndStagePersReporter,
        // clsc75dIndStagePersEmpNew, clsc75dDtStagePersLink,
        // DateHelper.NULL_JAVA_DATE);
        // } // end while
        // } // end if Stage List is not null
        // } // end if INV and SVC
      } else { // (!FAD_REVIEW.equals(ccmn03uiSzCdStageOpen)) {
        // If the functional page only creates the subcare stage
        // we should retrieve all principals associated with the
        // old stage, and update Stage_Person_link with the new
        // stage id and principals (including the primary child)
        List<StagePersonLink> stagePersonLinkList = findStagePersonLinkRowsByIdStage(ccmn03uiIdStage);
        if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {

          Iterator itCcmnb9dStagePersonLink = stagePersonLinkList.iterator();

          boolean bMesAssigned = false;
          
          while (itCcmnb9dStagePersonLink.hasNext()) {
            StagePersonLink ccmnb9dStagePersonLink = (StagePersonLink) itCcmnb9dStagePersonLink.next();
            String ccmnd3dCdStagePersType = ccmnb9dStagePersonLink.getCdStagePersType();
            String ccmnb9dCdStagePersRole = ccmnb9dStagePersonLink.getCdStagePersRole();
            int ccmnb9dIdPerson = ccmnb9dStagePersonLink.getPerson().getIdPerson();
            String ccmnd3dCdStagePersRole;
            // STGAP00017013: MR-095
            String ccmnd3dCdStagePersRelInt = "";
            String ccmnb9dCdPersSex = ccmnb9dStagePersonLink.getPerson().getCdPersonSex();

            // If the id of the person matches the id of the primary child passed
            // in, then update that person's role to Primary Child. Do this
            // for Foster Care Child, ADO, PAD, and Post Foster Care.
            
            //-- although, if we are coming from a stage that already has a PC defined (e.g. FCC)
            //-- then ccmn03uiIdPrimChild could be 0 since the Stage Progression page does not
            //-- allow you to select a PC if one already exists
            if (ccmnb9dIdPerson == ccmn03uiIdPrimChild
                && (SUBCARE.equals(ccmn03uiSzCdStageOpen) || ADOPTION.equals(ccmn03uiSzCdStageOpen)
                    || POST_ADOPT.equals(ccmn03uiSzCdStageOpen) || PFC_PROGRAM.equals(ccmn03uiSzCdStageOpen))) {

              ccmnd3dCdStagePersRole = PERSON_ROLE_PRIM_CHILD;
              // STGAP00017013: MR-095
              if (SUBCARE.equals(ccmn03uiSzCdStageOpen)) {
                // Set Primary Child as Self
                ccmnd3dCdStagePersRelInt = PERSON_REL_SELF;
              }
              // End STGAP00017013: MR-095
            } else if (PERSON_ROLE_PRIM_CHILD.equals(ccmnb9dCdStagePersRole)
                       && FPR_PROGRAM.equals(ccmn03uiSzCdStageOpen)) {
              // If we have a PC role and we are opening a Family
              // stage we should not copy the person to the new stage
              // as a PC, but as a VC
              ccmnd3dCdStagePersRole = PERSON_ROLE_BOTH;
            } else if(PERSON_ROLE_PRIM_CHILD.equals(ccmnb9dCdStagePersRole) && SUBCARE.equals(ccmn03uiSzCdStageOpen)) {
              //-- added this condition to avoid changing PC -> NO when ccmn03uiIdPrimChild == 0
              ccmnd3dCdStagePersRole = ccmnb9dCdStagePersRole;
            } else if (SUBCARE.equals(ccmn03uiSzCdStageOpen) || FSU_PROGRAM.equals(ccmn03uiSzCdStageOpen)) {
              ccmnd3dCdStagePersRole = PERSON_ROLE_NONE;
              // STGAP00017013: MR-095
              if (FSU_PROGRAM.equals(ccmn03uiSzCdStageOpen) && ccmnb9dIdPerson == ccmn03uiIdPrimChild
                  && ccmn03ui.getROWCCMN03UIG00_ARRAY() != null) {
                // Set Primary Child as Self
                ccmnd3dCdStagePersRelInt = PERSON_REL_SELF;
              } // End STGAP00017013: MR-095
            } else {
              ccmnd3dCdStagePersRole = ccmnb9dCdStagePersRole;
            }

            // STGAP00017013: MR-095
            // Set the relationship of all Principals (except removal child) as selected 
            // in the Foster Care Principals List for FCC Stage in the Custody page
            if (PERSON_ROLE_PRINCIPAL.equals(ccmnd3dCdStagePersType) && ccmn03ui.getROWCCMN03UIG00_ARRAY() != null) {

              // Check to see if FSU is open. If open then Stronger Relationship Hierarchy below will be applied
              List openStages = CaseUtility.getOpenStages(cint21dIdCase);
              boolean isFSUOpen = false;
              int idFSUStage = 0;
              for (Iterator openStageIterator = openStages.iterator(); openStageIterator.hasNext();) {
                CaseUtility.Stage stage = (CaseUtility.Stage) openStageIterator.next();
                if (stage.getCdStage().equals("FSU")) {
                  isFSUOpen = true;
                  idFSUStage = stage.getIdStage();
                  break;
                }
              }

              // Loop through ROWCCMN03UIG00_ARRAY to get the relationship set
              // via 'Foster Care Principals List for FCC Stage' section on Custody page
              ROWCCMN03UIG00_ARRAY rowccmn03uigoo_array = ccmn03ui.getROWCCMN03UIG00_ARRAY();
              Enumeration rowccmn03uigooEnumeration = rowccmn03uigoo_array.enumerateROWCCMN03UIG00();

              // If the person is removal child then the relationship in the existing FCF needs to be updated
              // to 'Self' if the person has different relationship
              if ((rowccmn03uigoo_array != null) && SUBCARE.equals(ccmn03uiSzCdStageOpen) && isFSUOpen
                  && (ccmn03uiIdPrimChild == ccmnb9dIdPerson)) {
                
                //
                // Find the relationship of the person in the FCF stage
                StagePersonLink splRecordInFsuStage = stagePersonLinkDAO
                                                                        .findStagePersonLinkByIdStageByIdPerson(
                                                                                                                idFSUStage,
                                                                                                                ccmnb9dIdPerson);
                if (splRecordInFsuStage != null) {
                  String cdRelInFsuStage = splRecordInFsuStage.getCdStagePersRelInt();
                  if (!PERSON_REL_SELF.equals(cdRelInFsuStage)) {
                    // Update the relationship to Self
                    stagePersonLinkDAO.updateStagePersonLinkCdStagePersRelInt(PERSON_REL_SELF, ccmnb9dIdPerson,
                                                                              idFSUStage);
                  }
                }
              }
              
              while (rowccmn03uigooEnumeration.hasMoreElements()) {
                ROWCCMN03UIG00 rowccmn03uigoo;
                rowccmn03uigoo = (ROWCCMN03UIG00) rowccmn03uigooEnumeration.nextElement();
                if (ccmnb9dIdPerson == rowccmn03uigoo.getUlIdPersonPrincipal()) {
                  ccmnd3dCdStagePersRelInt = rowccmn03uigoo.getSzCdStagePersRelInt();
                  // If this is FCC creation and FCF stage already exists in the same case
                  // use the Stronger Relationship Hierarchy defined below to update existing relationship
                  // in the FCF stage for all Principals except children with FCC stages
                  if (SUBCARE.equals(ccmn03uiSzCdStageOpen) && isFSUOpen) {
                    // Check if the person is FCC child in the case
                    // If so, the person should be excluded in this hierarchy
                    // because the relationship should have been determined in the FCF stage
                    long countSplFccStageForThisPerson = stagePersonLinkDAO
                                                                           .countStagePersonLinkOpenFccStageByIdPersonIdCase(
                                                                                                                             ccmnb9dIdPerson,
                                                                                                                             cint21dIdCase);
                    if (countSplFccStageForThisPerson < 1) {
                      // Find the relationship of the person in the FCF stage
                      StagePersonLink splRecordInFsuStage = stagePersonLinkDAO
                                                                              .findStagePersonLinkByIdStageByIdPerson(
                                                                                                                      idFSUStage,
                                                                                                                      ccmnb9dIdPerson);
                      if (splRecordInFsuStage != null) {
                        String cdRelInFsuStage = splRecordInFsuStage.getCdStagePersRelInt();
                        if (cdRelInFsuStage != ccmnd3dCdStagePersRelInt) {
                          if (CodesTables.CSEX_M.equals(splRecordInFsuStage.getPerson().getCdPersonSex())) {

                            // Stronger Hierarchy for Gender Male
                            // First one listed has strongest hierarchy
                            List<String> strongerRelHierMale = new ArrayList<String>();
                            strongerRelHierMale.add(CodesTables.CRELVICT_BB); // Biological and Legal Father
                            strongerRelHierMale.add(CodesTables.CRELVICT_BF); // Biological Father
                            strongerRelHierMale.add(CodesTables.CRELVICT_BP); // Biological Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_LF); // Legal Father
                            strongerRelHierMale.add(CodesTables.CRELVICT_PA); // Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_PT); // Adoptive Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_GP); // Grandparent
                            strongerRelHierMale.add(CodesTables.CRELVICT_G2); // Great Grandparent
                            strongerRelHierMale.add(CodesTables.CRELVICT_AU); // Aunt/Uncle
                            strongerRelHierMale.add(CodesTables.CRELVICT_GU); // Guardian
                            strongerRelHierMale.add(CodesTables.CRELVICT_BS); // Biological Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_SB); // Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_CO); // First Cousin
                            strongerRelHierMale.add(CodesTables.CRELVICT_FC); // First Cousin Once Removed
                            strongerRelHierMale.add(CodesTables.CRELVICT_HS); // Half Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_ST); // Step-Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_GS); // Step Grandparent
                            strongerRelHierMale.add(CodesTables.CRELVICT_SS); // Step-Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_FM); // Other Family Member
                            strongerRelHierMale.add(CodesTables.CRELVICT_OR); // Other Relative
                            strongerRelHierMale.add(CodesTables.CRELVICT_SC); // Secondary Caretaker
                            strongerRelHierMale.add(CodesTables.CRELVICT_PF); // Putative Father
                            strongerRelHierMale.add(CodesTables.CRELVICT_OP); // Other non-related Person
                            strongerRelHierMale.add(CodesTables.CRELVICT_XX); // Other
                            strongerRelHierMale.add(CodesTables.CRELVICT_OU); // Other/Unknown

                            Iterator<String> it = strongerRelHierMale.iterator();
                            Boolean isFsuRelFound = false;
                            Boolean isSubRelFound = false;
                            int fsuRelRank = 100;
                            int subRelRank = 100;
                            while (it.hasNext()) {
                              String isMatch = it.next();
                              if (isMatch.equals(cdRelInFsuStage)) {
                                isFsuRelFound = true;
                                fsuRelRank = strongerRelHierMale.indexOf(isMatch);
                              } else if (isMatch.equals(ccmnd3dCdStagePersRelInt)) {
                                isSubRelFound = true;
                                subRelRank = strongerRelHierMale.indexOf(isMatch);
                              }
                            }
                            if (isFsuRelFound && isSubRelFound) {
                              // Compare the rank between FCC relationship and FCF relationship
                              // and update the FCF StagePersonLink if FCC relationship
                              // has stronger than FCF relationship per hierarchy
                              if (fsuRelRank > subRelRank) {
                                stagePersonLinkDAO.updateStagePersonLinkCdStagePersRelInt(ccmnd3dCdStagePersRelInt,
                                                                                          ccmnb9dIdPerson, idFSUStage);
                              }
                            }
                          } else {
                            // Stronger Hierarchy for Gender Female
                            // First one listed has strongest hierarchy
                            List<String> strongerRelHierMale = new ArrayList<String>();
                            strongerRelHierMale.add(CodesTables.CRELVICT_BM); // Biological Mother
                            strongerRelHierMale.add(CodesTables.CRELVICT_BP); // Biological Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_LM); // Legal Mother
                            strongerRelHierMale.add(CodesTables.CRELVICT_PA); // Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_PT); // Adoptive Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_GP); // Grandparent
                            strongerRelHierMale.add(CodesTables.CRELVICT_G2); // Great Grandparent
                            strongerRelHierMale.add(CodesTables.CRELVICT_AU); // Aunt/Uncle
                            strongerRelHierMale.add(CodesTables.CRELVICT_GU); // Guardian
                            strongerRelHierMale.add(CodesTables.CRELVICT_BS); // Biological Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_SB); // Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_CO); // First Cousin
                            strongerRelHierMale.add(CodesTables.CRELVICT_FC); // First Cousin Once Removed
                            strongerRelHierMale.add(CodesTables.CRELVICT_HS); // Half Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_ST); // Step-Parent
                            strongerRelHierMale.add(CodesTables.CRELVICT_GS); // Step Grandparent
                            strongerRelHierMale.add(CodesTables.CRELVICT_SS); // Step-Sibling
                            strongerRelHierMale.add(CodesTables.CRELVICT_FM); // Other Family Member
                            strongerRelHierMale.add(CodesTables.CRELVICT_OR); // Other Relative
                            strongerRelHierMale.add(CodesTables.CRELVICT_SC); // Secondary Caretaker
                            strongerRelHierMale.add(CodesTables.CRELVICT_PF); // Putative Father
                            strongerRelHierMale.add(CodesTables.CRELVICT_OP); // Other non-related Person
                            strongerRelHierMale.add(CodesTables.CRELVICT_XX); // Other
                            strongerRelHierMale.add(CodesTables.CRELVICT_OU); // Other/Unknown

                            Iterator<String> it = strongerRelHierMale.iterator();
                            Boolean isFsuRelFound = false;
                            Boolean isSubRelFound = false;
                            int fsuRelRank = 100;
                            int subRelRank = 100;
                            while (it.hasNext()) {
                              String isMatch = it.next();
                              if (isMatch.equals(cdRelInFsuStage)) {
                                isFsuRelFound = true;
                                fsuRelRank = strongerRelHierMale.indexOf(isMatch);
                              } else if (isMatch.equals(ccmnd3dCdStagePersRelInt)) {
                                isSubRelFound = true;
                                subRelRank = strongerRelHierMale.indexOf(isMatch);
                              }
                            }
                            if (isFsuRelFound && isSubRelFound) {
                              // Compare the rank between FCC relationship and FCF relationship
                              // and update the FCF StagePersonLink if FCC relationship
                              // has stronger than FCF relationship per hierarchy
                              if (fsuRelRank > subRelRank) {
                                stagePersonLinkDAO.updateStagePersonLinkCdStagePersRelInt(ccmnd3dCdStagePersRelInt,
                                                                                          ccmnb9dIdPerson, idFSUStage);
                              }
                            }
                          }
                        }
                      }
                    }
                    break;
                  }
                }
              }
            } 
            // Stage Progression logic change per STGAP00017013: MR-095
            // When FCF stage progress to ONG, 
            // Copy the FCF Person List to the ONG Person List and update the relationship of persons in the ONG Person List 
            // with the same relationship found in the most recent family stage (INV or ONG)
            // If person exists in the FCF Person List and not in the most recent family stage  (INV or ONG) 
            // and there is an identified Primary Caretaker in the ONG stage, auto-populate the relationship of the person 
            // using the relationship matrix defined in the Stage Progression design
            // to identify the relationship to the Primary Caretaker
            // If person exists in the FCF Person List and not in the most recent family stage  (INV or ONG) 
            // and there is no identified Primary Caretaker in the ONG stage, use the Stage name of the FCF stage 
            // for identifying the Primary Caretaker in the ONG stage and auto-populate the relationship of the person 
            // using the relationship matrix defined in in the Stage Progression design
            // to identify the relationship to the Primary Caretaker
            else if (PERSON_ROLE_PRINCIPAL.equals(ccmnd3dCdStagePersType) && FPR_PROGRAM.equals(ccmn03uiSzCdStageOpen)) {

              // Find the most recent family stage (INV or ONG) where the FCF stage was created
              // The current ONG stage (ccmn03uoIdStage) opening needs to be excluded in the DAO below
              Integer idMostRecentFamilyStage = stageLinkDAO.findPreviousIdStagebyIdStage(ccmn03uiIdStage);
              
              if (idMostRecentFamilyStage == null) {
                idMostRecentFamilyStage = 0;
              }
                
              // Find the overall relationship for mapping 
              // based on the relationship of the removal child to the Primary Caretaker in FCF stage
              int idPrimaryCaretaker = 0;
              Map mapStagePersRelPK = checkCdStagePersRelPK(ccmn03uiIdStage, idMostRecentFamilyStage);
              String cdStagePersRelPK = (String) mapStagePersRelPK.get("cdStagePersRelPK");              
              idPrimaryCaretaker = (Integer) mapStagePersRelPK.get("idPrimaryCaretaker");
              
              if (idMostRecentFamilyStage != null && idMostRecentFamilyStage > 0) {
                List<StagePersonLink> splListFromRecentFamStage = findStagePersonLinkRowsByIdStage(idMostRecentFamilyStage);
                if (splListFromRecentFamStage != null && !splListFromRecentFamStage.isEmpty()) {
                  boolean isPersonFoundInFamStage = false;
                  boolean isPKFoundInFamStage = false;
                  Iterator<StagePersonLink> it = splListFromRecentFamStage.iterator();
                  while (it.hasNext()) {
                    StagePersonLink splFromRecentFamStage = it.next();
                    // If the person exists in the previous family stage, copy the relationship
                    if (ccmnb9dIdPerson == splFromRecentFamStage.getPerson().getIdPerson()
                        && ccmnb9dIdPerson == idPrimaryCaretaker) {
                      ccmnd3dCdStagePersRelInt = CodesTables.CRELVICT_PK;
                      // Set indicator to true
                      isPersonFoundInFamStage = true;
                      break;
                    } else if (ccmnb9dIdPerson == splFromRecentFamStage.getPerson().getIdPerson()
                               && ccmnb9dIdPerson != idPrimaryCaretaker
                               && !CodesTables.CRELVICT_PK.equals(splFromRecentFamStage.getCdStagePersRelInt())) {
                      ccmnd3dCdStagePersRelInt = splFromRecentFamStage.getCdStagePersRelInt();
                      // Set indicator to true
                      isPersonFoundInFamStage = true;
                      break;                      
                    }
                  }                  
                  
                  if (!isPersonFoundInFamStage) {
                    // If the person doesn't exist in the previous family stage, then send the person
                    // to the relationship mapping because this person exists in the FCF stage
                    // but not in the previous family stage
                                        
                    // Send the person to the relationship mapping if this person is not determined as PK
                    // If the person is determined as PK, then set the relationship to PK
                    // So ONG stage should have one PK
                    if (ccmnb9dIdPerson == idPrimaryCaretaker) {
                      ccmnd3dCdStagePersRelInt = CodesTables.CRELVICT_PK;
                    } else {
                      String cdStagePersRelFromMapping = findCdStagePersRelFromMapping(
                                                                                       ccmnb9dIdPerson,
                                                                                       ccmnb9dStagePersonLink
                                                                                                             .getCdStagePersRelInt(),
                                                                                       cdStagePersRelPK,
                                                                                       ccmnb9dCdPersSex);
                      ccmnd3dCdStagePersRelInt = cdStagePersRelFromMapping;
                    }
                  }
                }
              }
              // If the FCF is stand-alone stage (due to conversion) then send all persons in the Person List
              // to the relationship mapping after find a person as PK in the FCF stage              
              else if (idMostRecentFamilyStage == 0) {
                
                // Set the PK if this is the person with the stage name
                if (ccmnb9dIdPerson == idPrimaryCaretaker) {
                  ccmnd3dCdStagePersRelInt = CodesTables.CRELVICT_PK;
                } else {
                  // Otherwise send the person to the relationship mapping
                  String cdStagePersRelFromMapping = findCdStagePersRelFromMapping(
                                                                                   ccmnb9dIdPerson,
                                                                                   ccmnb9dStagePersonLink
                                                                                                         .getCdStagePersRelInt(),
                                                                                   cdStagePersRelPK, ccmnb9dCdPersSex);
                  ccmnd3dCdStagePersRelInt = cdStagePersRelFromMapping;
                }
              }
            } else { // End STGAP00017013: MR-095
              ccmnd3dCdStagePersRelInt = ccmnb9dStagePersonLink.getCdStagePersRelInt();
            }
            String ccmnd3dCdStagePersSearchInd = ccmnb9dStagePersonLink.getCdStagePersSearchInd();
            String ccmnd3dIndStagePersInLaw = ccmnb9dStagePersonLink.getIndStagePersInLaw();
            String ccmnd3dIndStagePersReporter = ccmnb9dStagePersonLink.getIndStagePersReporter();
            //STGAP00015485 MR-056 added cdPKHouseholdMember
            String cdPKHouseholdMember = ccmnb9dStagePersonLink.getCdPKHshdMember();
            //38677 Side of Family Found on StagePersonLink instead of Person Detail
            String cdPersonSideOfFamily = ccmnb9dStagePersonLink.getCdPersonSideOfFamily();

            if ((!STAFF.equals(ccmnd3dCdStagePersType) && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen))
                || (ccmnb9dIdPerson == ccmn03uiIdPrimChild && ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen))) {

              saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                                  ccmnd3dCdStagePersRelInt, ccmnd3dCdStagePersRole,
                                                  ccmnd3dCdStagePersSearchInd, ccmnd3dCdStagePersType, null,
                                                  ccmnb9dIdPerson, 0, ccmnd3dIndStagePersInLaw,
                                                  ccmnd3dIndStagePersReporter, null, dtToday, null, cdPKHouseholdMember,cdPersonSideOfFamily);
            } // end if not staff and not admin review, or ids match and admin review

            // MR-092: If new stage is ado or pad then copy over the MES secondary assignment from previous stage, if any
            if (STAFF.equals(ccmnd3dCdStagePersType)
                && CodesTables.CROLEALL_SE.equals(ccmnb9dCdStagePersRole)
                && (checkIfUserHasRight.determineIfUserHasRight(ccmnb9dIdPerson, SEC_REG_FAM_INDP_STF) 
                                || checkIfUserHasRight.determineIfUserHasRight(ccmnb9dIdPerson, SEC_REG_FAM_INDP_MGMNT_STF)
                                || checkIfUserHasRight.determineIfUserHasRight(ccmnb9dIdPerson, SEC_MES_PROGRAM_ASSIST))
                && (POST_ADOPT.equals(ccmn03uiSzCdStageOpen) 
                                || ADOPTION.equals(ccmn03uiSzCdStageOpen))
                && !INTAKE.equals(ccmn03uiSzCdStage)) {

              saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                                  null, CodesTables.CROLEALL_SE,
                                                  null, ccmnd3dCdStagePersType, null,
                                                  ccmnb9dIdPerson, 0, null,
                                                  null, INDICATOR_1, dtToday, null,
                                                  null, null);

              saveTodo("", ALERT_TODO, dtToday, dtToday, dtToday, null, cint21dIdCase,
                       0, ccmnb9dIdPerson, 0, ccmnb9dIdPerson, ccmn03uoIdStage,
                       "New Secondary Assignment", null);

              bMesAssigned = true;
            } // end if a staff and new stage is ADO or PAD
          } // end while
          
          // MR-092 if looped through old stage stage person links did not assign any secondary MES work then
          // assign the MES Program Assistant to the new stage as secondary based on stage region.
          if(!bMesAssigned 
                          && (POST_ADOPT.equals(ccmn03uiSzCdStageOpen) 
                                          || ADOPTION.equals(ccmn03uiSzCdStageOpen))
                          && !INTAKE.equals(ccmn03uiSzCdStage)){
              String cdStageRegion = retrieveStageRegionByStageId(idStage);
              List<Integer> mesWorkerOrPaList = unitEmpLinkDAO.findMESProgramAssistantByCdRegion(cdStageRegion);
              
              if(mesWorkerOrPaList != null && !mesWorkerOrPaList.isEmpty()){
                saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                                    null, CodesTables.CROLEALL_SE,
                                                    null, STAFF, null,
                                                    mesWorkerOrPaList.get(0), 0, null,
                                                    null, INDICATOR_1, dtToday, null,
                                                    null, null);

                saveTodo("", ALERT_TODO, dtToday, dtToday, dtToday, null, cint21dIdCase,
                         0, mesWorkerOrPaList.get(0), 0, mesWorkerOrPaList.get(0), ccmn03uoIdStage,
                         "New Secondary Assignment", null);

              }
          }
        }// end if stagePersonLinkList is not null
      } // end else // if !FAD review

      // Now that all non-staff persons have been linked to new stage,
      // we must create a record in the STAGE_PERSON_LINK table for the
      // primary worker of the old stage. This record will be linked with
      // the newly opened stage
      int ccmnd3dIdPerson = 0x0;

      ccmnd3dIdPerson = ccmn03ui.getUlIdPerson();
      
      saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage, null,
                                          PRIMARY_ROLE_STAGE_OPEN, null, STAFF, null, ccmnd3dIdPerson, 0, null, null,
                                          INDICATOR_1, dtToday, null, null, null);

      // TodoCommonFunction call was added here for AOC only
      // Creation of todo's for the APS AOC stage is handled
      // here instead of above where it is normally handled,
      // because we must go through the logic of finding the
      // correct AOC worker. The 2 todo's currently to be
      // created are hard-coded here, as well as the number
      // of times to hit the ToDoCommonFunction. These can
      // be changed at the top of this program. If more todo's
      // are added in the future, just change where the flag is
      // set to TRUE
      // if (AGE_OUT.equals(ccmn03uiSzCdStageOpen)) {
      // int i85 = 0;
      // int ccmn46dIdEvent = 0;
      // boolean bIndNoAOCTodo = false;
      //
      // while (!bIndNoAOCTodo) {
      // CSUB40UI csub40ui = new CSUB40UI();
      // CSUB40UO csub40uo = new CSUB40UO();
      // CSUB40UIG00 csub40Uig00 = new CSUB40UIG00();
      //
      // if (0 == i85) {
      // csub40Uig00.setSzSysCdTodoCf(AOC_CLIENT_ASSES_ALERT);
      // i85++;
      // } else {
      //
      // csub40Uig00.setSzSysCdTodoCf(AOC_QUARTERLY_REVIEW);
      // ccmn46dIdEvent = saveEvent(dtToday, ccmn03uoIdStage, ccmn03uiIdPerson, QUART_EVENT_DESC, EVENT_STATUS_NEW,
      // APS_CONTACT_TASK, CONTRACT);
      //
      // bIndNoAOCTodo = true;
      // }
      //
      // csub40Uig00.setUlSysIdTodoCfPersCrea(ccmnd3dIdPerson);
      // csub40Uig00.setUlSysIdTodoCfStage(ccmn03uoIdStage);
      // csub40Uig00.setUlSysIdTodoCfEvent(ccmn46dIdEvent);
      //
      // if ((DateHelper.isNull(ccmn03uiDtStageStart))) {
      // csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtToday));
      // } else {
      // csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(ccmn03uiDtStageStart));
      // }
      //
      // // For the Quarterly Review, the todo is do
      // // on the 20th of the 3rd month from the current
      // // month
      // if (csub40Uig00.getSzSysCdTodoCf().equals(AOC_QUARTERLY_REVIEW)) {
      // Calendar csub40uiDate = Calendar.getInstance();
      // csub40uiDate.setTime(dtToday);
      // csub40uiDate.add(Calendar.MONTH, 3);
      // csub40uiDate.set(Calendar.DATE, 20);
      // Date csub40uiNow = csub40uiDate.getTime();
      //
      // csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(csub40uiNow));
      // }
      //
      // csub40ui.setCSUB40UIG00(csub40Uig00);
      // todoCommonFunction.audTodo(csub40ui);
      //
      // if (APS_CONTACT_TASK.equals(csub40uo.getSzCdTodoTask())) {
      // saveContact(csub40uo.getUlIdEvent(), csub40uo.getUlIdStage(), C3MT);
      // }
      // } // end while
      // } else if (PREP_ADULT.equals(ccmn03uiSzCdStageOpen)) {
      // // Similar to AOC stage, for PAL, we can't use the Todo Common
      // // Function with stage progression table above to assign the PAL ILS
      // // assessment because we don't know who the current worker is
      // // yet. If we reach this point in the code, we have determined
      // // the PAL Coordinator for the region.
      //
      // // Create the dummy event for the todo to navigate
      // // with
      // // This is being hard-coded at for this event AND ONLY
      // // THIS EVENT, because of the uniqueness of progressing
      // // anything from CPS to PAL. We don't know the new
      // // worker until this point, and redesigning stage progression
      // // would have indeterminable regression problems with other
      // // stages that are working correctly.
      //
      // int ccmn46dIdEvent = saveEvent(dtToday, ccmn03uoIdStage, ccmn03uiIdPerson, PAL_ILS_DESCRIPTION,
      // EVENT_STATUS_NEW, PAL_ILS_TASK, PAL_ILS_EVENT_TYPE);
      //
      // CSUB40UI csub40ui = new CSUB40UI();
      // CSUB40UIG00 csub40Uig00 = new CSUB40UIG00();
      // csub40Uig00.setUlSysIdTodoCfPersCrea(ccmnd3dIdPerson);
      // csub40Uig00.setUlSysIdTodoCfStage(ccmn03uoIdStage);
      // csub40Uig00.setUlSysIdTodoCfEvent(ccmn46dIdEvent);
      // csub40Uig00.setSzSysCdTodoCf(PAL_ILS_TODO);
      //
      // if (DateHelper.isNull(ccmn03uiDtStageStart)) {
      // csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtToday));
      // } else {
      // csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(ccmn03uiDtStageStart));
      // }
      //
      // csub40ui.setCSUB40UIG00(csub40Uig00);
      // todoCommonFunction.audTodo(csub40ui);
      // } // end else if PAL stage

      // Create a link between the old stage and the new stage in the
      // STAGE LINK table
      saveStageLink(ccmn03uoIdStage, ccmn03uiIdStage);

      // ACorley - Removed APS guardianship and outcome matrix information from this section
    } // end if !bindautoadopt

    if (openingStage && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen) && !SUBCARE.equals(ccmn03uiSzCdStageOpen) &&
    // cjg 9/16/06 - added this for SHINES - no service auths in intake to transfer
        !INVESTIGATION.equals(ccmn03uiSzCdStageOpen) && !POST_ADOPT.equals(ccmn03uiSzCdStageOpen)
        && !ADOPTION.equals(ccmn03uiSzCdStageOpen) && !PFC_PROGRAM.equals(ccmn03uiSzCdStageOpen)) {
      // When progressing service auth, we need to determine if
      // any events for the stage being closed are complete in
      // the service authorization table and have term dates
      // greater than todays. For each record in the Service
      // Auth table that fulfills this requirement, we need to
      // create a new event, essentially a copy of the old event
      // with the new idStage and a CdTask for Service Auth.
      String[] cdEventTypes;
      cdEventTypes = new String[] { SERVICE_AUTH_TYPE };
      String ccmn87dCdTask = null;
      // if (CAPS_PROG_APS.equals(ccmn03uiSzCdStageProgram) && INVESTIGATION.equals(ccmn03uiSzCdStage)) {
      // ccmn87dCdTask = APS_SVC_AUTH_TASK;
      // } else if (CAPS_PROG_APS.equals(ccmn03uiSzCdStageProgram) && AGE_OUT.equals(ccmn03uiSzCdStage)) {
      // ccmn87dCdTask = AOC_SVC_AUTH_TASK;
      // }

      int ccmn03uoIdStage = ccmn03uo.getUlIdStage();
      List<Object[]> ccmn87DynamicEventList = findEvents(ccmn03uiIdStage, ccmn87dCdTask, cdEventTypes);

      if (ccmn87DynamicEventList != null && !ccmn87DynamicEventList.isEmpty()) {
        Iterator itCcmn87DynamicEventList = ccmn87DynamicEventList.iterator();

        while (itCcmn87DynamicEventList.hasNext()) {
          Object[] ccmn87DynamicEvent = (Object[]) itCcmn87DynamicEventList.next();
          String ccmn87CdEventStatus = (String) ccmn87DynamicEvent[0];
          String ccmn87CdEventType = (String) ccmn87DynamicEvent[1];
          int ccmn87IdEvent = (Integer) ccmn87DynamicEvent[6];
          Date ccmn87dDtEventOccurred = (Date) ccmn87DynamicEvent[3];
          String ccmn87dTxtEventDescr = (String) ccmn87DynamicEvent[10];

          if (SERVICE_AUTH_TYPE.equals(ccmn87CdEventType)) {
            ServiceAuthorization cses24dServiceAuthorization = serviceAuthorizationDAO.findServiceAuthEventLink(ccmn87IdEvent);

            if (cses24dServiceAuthorization == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            int cses24dIdSvcAuth = cses24dServiceAuthorization.getIdSvcAuth();
            ServiceAuthorization cses23dServiceAuthorization = serviceAuthorizationDAO.findServiceAuth(cses24dIdSvcAuth);

            if (cses23dServiceAuthorization == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            if (ArchitectureConstants.Y.equals(cses23dServiceAuthorization.getIndSvcAuthComplete())) {

              // clss24dQUERYdam
              List<SvcAuthDetail> clss24dServiceAuthDetailList = svcAuthDetailDAO.findServiceAuthDetailPersonByIdSvcAuth(cses24dIdSvcAuth);

              if (clss24dServiceAuthDetailList == null || clss24dServiceAuthDetailList.isEmpty()) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
              Iterator itClss24dSvcAuthDetailList = clss24dServiceAuthDetailList.iterator();

              // Loop through all the rows returned from this service
              // and add a new event row. The new event row will
              // be exactly the same as retrieved above except it will
              // use the new IdStage, the CdEventTask will be the CdTask
              // for Service Auth and the IdEvent will be new
              while (itClss24dSvcAuthDetailList.hasNext()) {
                SvcAuthDetail clss24dSvcAuthDetail = (SvcAuthDetail) itClss24dSvcAuthDetailList.next();

                if (DateHelper.isBefore(dtToday, clss24dSvcAuthDetail.getDtSvcAuthDtlTerm())
                    && (STATUS_APPROVED.equals(ccmn87CdEventStatus))) {
                  String ccmn46dCdTask;

                  if (ADOPTION.equals(ccmn03uiSzCdStageOpen)) {
                    ccmn46dCdTask = ADO_SVC_AUTH_TASK;
                  } else if (FSU_PROGRAM.equals(ccmn03uiSzCdStageOpen)) {
                    ccmn46dCdTask = FSU_SVC_AUTH_TASK;
                  } else if (FPR_PROGRAM.equals(ccmn03uiSzCdStageOpen)) {
                    ccmn46dCdTask = FPR_SVC_AUTH_TASK;
                  } else if (PFC_PROGRAM.equals(ccmn03uiSzCdStageOpen)) {
                    ccmn46dCdTask = PFC_SVC_AUTH_TASK;
                  } else {
                    ccmn46dCdTask = PAD_SVC_AUTH_TASK;
                  }

                  int ccmn46dIdEvent = saveEvent(ccmn87dDtEventOccurred, ccmn03uoIdStage, 0, ccmn87dTxtEventDescr,
                                                 ccmn87CdEventStatus, ccmn46dCdTask, ccmn87CdEventType);

                  // Create a new SvcAuthEventLink record for the
                  // event just created
                  saveSvcAuthEventLink(cses24dIdSvcAuth, ccmn46dIdEvent);

                  List<EventPersonLink> ccmnd2dEventPersonLinkList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(ccmn87IdEvent);

                  if (ccmnd2dEventPersonLinkList == null || ccmnd2dEventPersonLinkList.isEmpty()) {
                    throw new ServiceException(Messages.SQL_NOT_FOUND);
                  }
                  Iterator itCcmnd2dEventPersonLinkList = ccmnd2dEventPersonLinkList.iterator();

                  // We also need to update the Event Person Link table
                  // for the new IdEvent. First we retrieve all the
                  // records linked to the old event, then insert new
                  // rows for the new event
                  while (itCcmnd2dEventPersonLinkList.hasNext()) {
                    EventPersonLink ccmnd2dEventPersonLink = (EventPersonLink) itCcmnd2dEventPersonLinkList.next();
                    Person ccmnd2dPerson = ccmnd2dEventPersonLink.getPerson();
                    // ccmn68dAUDdam
                    int ccmn68dRowsUpdated = eventPersonLinkDAO.insertEventPersonLink(ccmn46dIdEvent, ccmnd2dPerson.getIdPerson());

                    if (ccmn68dRowsUpdated == 0) {
                      throw new ServiceException(Messages.SQL_NOT_FOUND);
                    }
                  }
                  // We only want to create ONE event row if
                  // a Detail record is found with a term date greater
                  // than today's date. Therefore, if a row is found,
                  // break from the for loop.
                  break;
                } // end if term date is greater than today and status is approved
              } // end while service auth detail has next
            } // end if service authorization is complete
          } // end if the event is a service authorization
        } // end while event list has next
      } // end if event list is not null or empty
    } // end if it's not a bunch of stage types

    // The following section deals exclusively with creating alerts for
    // primary workers.These DAO's are only called if the closed stage
    // was an INTAKE. The first DAO retrieves all those persons that are
    // 'Principals' in the closed Intake. The second DAO retrieves a list
    // of stage id's (and the primary worker's id associated with each
    // stage) for each stage linked to the person id's retrieved in the
    // first DAO and that belong to other cases. The third DAO creates a
    // to-do for each primary worker retrieved in the second DAO.
    if (INTAKE.equals(ccmn03uiSzCdStage)) {
      // ccmne4dQUERYdam
      List<Map> stagePersonMap = stagePersonLinkDAO.findIdPersonAndNmPersonFullFromStagePersonLinkAndPerson(ccmn03uiIdStage);

      if (stagePersonMap == null || stagePersonMap.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      Iterator itCcmne4dStagePersonMap = stagePersonMap.iterator();

      while (itCcmne4dStagePersonMap.hasNext()) {
        Map ccmne4dStagePersonMap = (Map) itCcmne4dStagePersonMap.next();
        int ccmne4dIdPerson = (Integer) ccmne4dStagePersonMap.get("idPerson");

        // ccmne5dQUERYdam
        List<Map> stagePersonLinkMap = stagePersonLinkDAO.findIdStageIdPersonIdCaseFromStageAndStagePersonLink(ccmne4dIdPerson,
                                                                                                               cint21dIdCase);

        Iterator itCcmne5dStagePersonLinkMap = stagePersonLinkMap.iterator();

        while (itCcmne5dStagePersonLinkMap.hasNext()) {
          Map ccmne5dStagePersonLink = (Map) itCcmne5dStagePersonLinkMap.next();
          int ccmn43dIdTodoPersAssigned = (Integer) ccmne5dStagePersonLink.get("idPerson");
          int ccmn43dIdTodoPersWorker = (Integer) ccmne5dStagePersonLink.get("idPerson");
          int ccmn43dIdCase = (Integer) (ccmne5dStagePersonLink.get("idCase") != null ? ccmne5dStagePersonLink
                                                                                                              .get("idCase")
                                                                                     : 0);
          int ccmn43dIdStage = (Integer) ccmne5dStagePersonLink.get("idStage");

          //Person ccmn43dPerson = (Person) getPersistentObject(Person.class, ccmn43dIdTodoPersAssigned);

          Stage ccmn03uiStage = (Stage) getPersistentObject(Stage.class, ccmn03uiIdStage);

          Person ccmne4dPerson = (Person) getPersistentObject(Person.class, ccmne4dIdPerson);

          String szTempString = ccmne4dPerson.getNmPersonFull() + " is involved in Intake "
                                + ccmn03uiStage.getNmStage();
          saveTodo(null, ALERT_TODO, dtToday, dtToday, null, dtToday, ccmn43dIdCase, 0,
                   ccmn43dIdTodoPersAssigned, 0, ccmn43dIdTodoPersWorker, ccmn43dIdStage, szTempString, szTempString);

          // Send an Alert to Supervisor
          int idSupervisor = retrieveUnitSupervisorByCaseManagerId(ccmn43dIdTodoPersWorker).getIdPerson();

          
          saveTodo(null, ALERT_TODO, dtToday, dtToday, null, dtToday, ccmn43dIdCase, 0,
                   idSupervisor, 0, ccmn43dIdTodoPersWorker, ccmn43dIdStage, szTempString, szTempString);

        } // end while
      } // end while stagePersonMap hasNext
    } // end if intake

    int ccmn03uoIdStage = ccmn03uo.getUlIdStage();

    // if (CAPS_PROG_APS.equals(ccmn03uiSzCdStageProgram) && !ADMIN_REVIEW.equals(ccmn03uiSzCdStageOpen)) {
    //
    // // ccmnh0dQUERYdam
    // List<Map> todoListMap = todoDAO.findTodoContactEventInfo(ccmn03uiIdStage);
    //
    // if (todoListMap != null && !todoListMap.isEmpty()) {
    // Iterator itCcmnh0dTodooListMap = todoListMap.iterator();
    //
    // while (itCcmnh0dTodooListMap.hasNext()) {
    // Map ccmnh0dTodooMap = (Map) itCcmnh0dTodooListMap.next();
    // int ccmnh0dIdEvent = (Integer) ccmnh0dTodooMap.get("idEvent");
    // int ccmnh0dIdTodo = (Integer) ccmnh0dTodooMap.get("idTodo");
    // String ccmng7dCdTask = "";
    // String ccmng9dCdTask = "";
    //
    // if (INVESTIGATION.equals(ccmn03uiSzCdStageOpen)) {
    // ccmng7dCdTask = APS_INT_TO_INV_TASK;
    // ccmng9dCdTask = APS_INT_TO_INV_TASK;
    // } else if (SERVICE_DELIVERY.equals(ccmn03uiSzCdStageOpen)) {
    // ccmng7dCdTask = APS_INV_TO_SVC_TASK;
    // ccmng9dCdTask = APS_INV_TO_SVC_TASK;
    // }
    //
    // // updates ID_EVENT_STAGE and CD_TASK on the EVENT table.
    // updateEventByIdEventAndCdTask(ccmn03uoIdStage, ccmnh0dIdEvent, ccmng7dCdTask);
    //
    // // updates ID_CONTACT_STAGE on the CONTACT table
    // updateContact(ccmn03uoIdStage, ccmnh0dIdEvent);
    //
    // // updates ID_TODO_STAGE and CD_TODO_TASK on the to do table.
    // updateTodo(ccmnh0dIdTodo, ccmng9dCdTask, ccmn03uoIdStage);
    // } // end while todoListMap has next
    // } // end if todoListMap is not empty
    // } // end if aps and not ari

    // Add migration of Adoption Subsidies from the Adoption stage to the
    // PostAdoption stage. If there are no open Adoption Subsidies, then
    // close the newly created PostAdoption stage and case (yes, the one
    // we just got done opening in the above process) if INTAKE then this is CRSR and
    // don't follow normal logic
    if (POST_ADOPT.equals(ccmn03uiSzCdStageOpen) && !INTAKE.equals(ccmn03uiSzCdStage)) {

      // We need to link the people from the FAD stage to the new stage.
      // We must use the rows retrieved above for the persons

      List<Map> clss63dStagePersonLinkListMap = findResourceandStagePersonLinkByidPersonAndCdPlcmtActPlanned(ccmn03uiIdPrimChild);
      Iterator itClss63dStagePersonLinkListMap = clss63dStagePersonLinkListMap.iterator();

      while (itClss63dStagePersonLinkListMap.hasNext()) {
        Map clss63dStagePersonLinkMap = (Map) itClss63dStagePersonLinkListMap.next();
        String ccmnd3dCdStagePersRelInt = (String) clss63dStagePersonLinkMap.get("cdStagePersRelInt");
        String ccmnd3dCdStagePersRole = (String) clss63dStagePersonLinkMap.get("cdStagePersRole");
        String ccmnd3dCdStagePersType = (String) clss63dStagePersonLinkMap.get("cdStagePersType");
        String ccmnd3dCdStagePersSearchInd = (String) clss63dStagePersonLinkMap.get("cdStagePersSearchInd");
        int ccmnd3dIdPerson = (Integer) clss63dStagePersonLinkMap.get("idPerson");
        String ccmnd3dIndStagePersInLaw = (String) clss63dStagePersonLinkMap.get("indStagePersInLaw");
        String ccmnd3dIndStagePersReporter = (String) clss63dStagePersonLinkMap.get("indStagePersReporter");
        //STGAP00015485 MR-056 added cdPKHouseholdMember
        String cdPKHouseholdMember = (String) clss63dStagePersonLinkMap.get("cdPKHouseholdMember");
        //38677 Side of Family Found on StagePersonLink instead of Person Detail
        String cdPersonSideOfFamily = (String) clss63dStagePersonLinkMap.get("cdPersonSideOfFamily");
        

        // Copy all the retrieved records, except for the one
        // staff person, to the new ID_STAGE
        if (!STAFF.equals(ccmnd3dCdStagePersType)) {

          saveStagePersonLinkWihoutIndNmStage(ServiceConstants.REQ_FUNC_CD_ADD, ccmn03uoIdStage,
                                              ccmnd3dCdStagePersRelInt, ccmnd3dCdStagePersRole,
                                              ccmnd3dCdStagePersSearchInd, ccmnd3dCdStagePersType, null,
                                              ccmnd3dIdPerson, 0, ccmnd3dIndStagePersInLaw,
                                              ccmnd3dIndStagePersReporter, "", dtToday, null, cdPKHouseholdMember,cdPersonSideOfFamily );
        }
      }

      String[] cdEventTypes;
      cdEventTypes = new String[] { "ADP" };
      List<Object[]> ccmn87dDynamicEventList = findEvents(ccmn03uiIdStage, ADOPTION_SUBSIDY_TASK, cdEventTypes);

      boolean bClosePAD = true;

      if (ccmn87dDynamicEventList != null && !ccmn87dDynamicEventList.isEmpty()) {
        Iterator itCcmn87DynamicEventList = ccmn87dDynamicEventList.iterator();

        while (itCcmn87DynamicEventList.hasNext()) {
          Object[] ccmn87DynamicEvent = (Object[]) itCcmn87DynamicEventList.next();
          String ccmn87CdEventStatus = (String) ccmn87DynamicEvent[0];
          int ccmn87IdEvent = (Integer) ccmn87DynamicEvent[6];
          String ccmn87CdEventType = (String) ccmn87DynamicEvent[1];
          String ccmn87dTxtEventDescr = (String) ccmn87DynamicEvent[10];
          
          //**********************************************************
          //-- The check for each is:
          //-- (1) EVENT.CD_EVENT_STATUS == COMP
          //-- (2) ADOPTION_SUBSIDY.DT_ADPT_SUB_END > today
          //-- (3) no value for ADOPTION_SUBSIDY.CD_ADPT_SUB_CLOSE_RSN
          //**********************************************************
          if (CodesTables.CEVTSTAT_COMP.equals(ccmn87CdEventStatus)) {
            int cses64dIdAdptSub = findAdptSubEventLink(ccmn87IdEvent);
            AdoptionSubsidy adptSub = getPersistentObject(AdoptionSubsidy.class, cses64dIdAdptSub);
            Date dtAdptSubEnd = adptSub.getDtAdptSubEnd();
            String cdAdptSubCloseRsn = adptSub.getCdAdptSubCloseRsn();
            if(dtAdptSubEnd != null && dtAdptSubEnd.compareTo(new Date()) > 0 && !StringHelper.isValid(cdAdptSubCloseRsn)) {
              //-- clone ADP event for PAD stage
              int ccmn46dIdEvent = saveEvent(dtToday, ccmn03uoIdStage, 0, ccmn87dTxtEventDescr, ccmn87CdEventStatus,
                                             PAD_SUBSIDY_TASK, ccmn87CdEventType);
              // caudb2dAUDdam
              //-- associate new event to same ADOPTION_SUBSIDY record
              adptSubEventLinkDAO.insertAdptSubEventLink(ccmn46dIdEvent, cses64dIdAdptSub);

              //if (caudb2dRowsUpdated == 0) {
              //  throw new ServiceException(Messages.SQL_NOT_FOUND);
              //}
              bClosePAD = false;
            }
          } // end if event stat proc
        } // end while event list has next
      } // end if event list is not empty
      
      // **********************************************************
      // MR-092 Copy latest validated AA Funding Summary
      // **********************************************************
      int idPadPrimaryChild = stagePersonLinkDAO.findIdPersonForChildByIdStage(ccmn03uoIdStage);
      AaFunding aaFunding = aaFundingDAO.findLatestValidatedAAFundingByIdChildByIdStage(ccmn03uiPrimaryChild, ccmn03uiIdStage);
      if (aaFunding != null) {
        Event aaFundingEvent = aaFunding.getEvent();
        
        int ccmn46dIdEvent = saveEvent(dtToday, ccmn03uoIdStage, 0, aaFundingEvent.getTxtEventDescr(),
                                       aaFundingEvent.getCdEventStatus(),
                                       PAD_AA_FUNDING_TASK, aaFundingEvent.getCdEventType());

        copyAAFundingSummary(aaFundingEvent.getIdEvent(), ccmn46dIdEvent, idPadPrimaryChild);

        bClosePAD = false;
      }else{
        // **********************************************************
        // MR-092 Copy the latest completed and approved Eligibility Summary
        // **********************************************************
        Eligibility eligibility = eligibilityDAO.findLatestApprovedEligibilityinFCC(ccmn03uiPrimaryChild);
  
        if (eligibility != null) {
          Event eligEvent = eligibility.getEvent();
          // clone FCD event for PAD stage
          int ccmn46dIdEvent = saveEvent(dtToday, ccmn03uoIdStage, 0, eligEvent.getTxtEventDescr(),
                                         eligEvent.getCdEventStatus(),
                                         PAD_ELIGIBILITY_TASK, eligEvent.getCdEventType());
  
          // cloned eligibility record and associate to new PAD event
          copyEligibility(eligEvent.getIdEvent(), ccmn46dIdEvent, idPadPrimaryChild);
  
          bClosePAD = false;
        } // end if event stat (comp || aprv) and FCD
      }
      
      if (bClosePAD) {
        CCMN02UI ccmn02ui = new CCMN02UI();
        CCMN02UIG00 ccmn02Uig00 = new CCMN02UIG00();
        ArchInputStruct ccmn02uiArchInputStruct = ccmn03uiArchInputStruct;
        ccmn02ui.setArchInputStruct(ccmn02uiArchInputStruct);
        ccmn02Uig00.setSzCdStage(POST_ADOPT);
        ccmn02Uig00.setSzCdStageProgram(CAPS_PROG_CPS);
        ccmn02Uig00.setSzCdStageReasonClosed(POST_ADOPT);
        ccmn02Uig00.setUlIdStage(ccmn03uoIdStage);
        ccmn02ui.setCCMN02UIG00(ccmn02Uig00);
        closeStageCase.closeStageCase(ccmn02ui);
      } // end if not bClosePad
    } // end if it's a pad stage
    return ccmn03uo;
  }

  private StagePersonLink findStagePersonLink(int idStage) throws ServiceException {

    // ccmng2dQUERYdam
    StagePersonLink ccmng2dStagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRole(idStage);

    if (ccmng2dStagePersonLink == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return ccmng2dStagePersonLink;
  }

  private void saveStagePersonLinkWihoutIndNmStage(String cReqFuncCd, int idStage, String cdStagePersRelInt,
                                                   String cdStagePersRole, String cdStagePersSearchInd,
                                                   String cdStagePersType, String txtStagePersNotes, int idPerson,
                                                   int idStagePerson, String indStagePersInLaw,
                                                   String indStagePersReporter, String indStagePersEmpNew,
                                                   Date dtStagePersLink, Date dtLastUpdate, String cdPKHouseholdMember, String cdPersonSideOfFamily) throws ServiceException {

    // ccmnd3dAUDdam
    int ccmnd3dRowsUpdated = 0;

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      ccmnd3dRowsUpdated = stagePersonLinkDAO.insertStagePersonLinkWihoutIndNmStage(idStage, idPerson, cdStagePersRole,
                                                                                    cdStagePersType,
                                                                                    cdStagePersSearchInd,
                                                                                    txtStagePersNotes, dtStagePersLink,
                                                                                    cdStagePersRelInt,
                                                                                    indStagePersReporter,
                                                                                    indStagePersInLaw,
                                                                                    indStagePersEmpNew,
                                                                                    cdPKHouseholdMember, cdPersonSideOfFamily);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      ccmnd3dRowsUpdated = stagePersonLinkDAO.updateStagePersonLinkWithoutIndNmStage(idPerson, cdStagePersRole,
                                                                                     cdStagePersType,
                                                                                     cdStagePersSearchInd,
                                                                                     txtStagePersNotes,
                                                                                     dtStagePersLink,
                                                                                     cdStagePersRelInt,
                                                                                     indStagePersReporter,
                                                                                     indStagePersInLaw,
                                                                                     indStagePersEmpNew, idStagePerson,
                                                                                     cdPKHouseholdMember, cdPersonSideOfFamily);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      stagePersonLinkDAO.deleteStagePersonLinkByIdStageCdStagePersRole(idStage);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    if (ccmnd3dRowsUpdated == 0 && !ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // If the DAO returned -1, the following statement was run for update and add
    // since the dao can't return -1, I'm leaving this commented out, but
    // if something seems weird later it may need some further investigation
    // if (cdStagePersRole.equals(PRIMARY_ROLE_STAGE_OPEN)) {
    // throw new ServiceException(Messages.MSG_CANT_ASSIGN_WORKER);
  }

  private List<StageProg> findStageProg(String cReqFuncCd, String szCdStageOpen, String szCdStage,
                                        String szCdStageProgram, String szCdStageReasonClosed) throws ServiceException {

    String ccmn03uiSzCdStage = null;

    if (STAGE_PROG_NEW_STAGE.equals(cReqFuncCd)) {
      ccmn03uiSzCdStage = szCdStageOpen;
    } else if (STAGE_PROG_OLD_STAGE.equals(cReqFuncCd)) {
      ccmn03uiSzCdStage = szCdStage;
    }

    // MR-092 Not sure why we are setting reason closed to ADO if new stage is PAD
    // it would prevent generation of any non-incident PAD stage open events
    // putting in fix to leave reason close as is if not null, otherwise set it as ADO.
    if (STAGE_PROG_NEW_STAGE.equals(cReqFuncCd) 
                    && POST_ADOPT.equals(ccmn03uiSzCdStage)
                    && StringHelper.isEmptyOrNull(szCdStageReasonClosed)) {
      szCdStageReasonClosed = ADOPTION;
    }

    // ccmnb8dQUERYdam
    List<StageProg> ccmnb8dStageProgList = stageProgDAO.findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(
                                                                                                                             ccmn03uiSzCdStage,
                                                                                                                             szCdStageProgram,
                                                                                                                             szCdStageReasonClosed);

    if (ccmnb8dStageProgList == null || ccmnb8dStageProgList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return ccmnb8dStageProgList;
  }

  private int saveEvent(Date dtEventOccurred, int idStage, int idPerson, String txtEventDescr, String cdEventStatus,
                        String cdTask, String cdEventType) throws ServiceException {

    if (SERVICE_AUTH_TYPE.equals(cdEventType)) {
      if (EVENT_STATUS_PEND.equals(cdEventStatus)) {
        cdEventStatus = CodesTables.CEVTSTAT_COMP;
      }
    }

    // ccmn46dAUDdam
    int ccmn46dIdEvent = complexEventDAO.insertEvent(cdEventStatus, cdEventType, dtEventOccurred, idPerson, idStage,
                                                     txtEventDescr, cdTask);

    if (ccmn46dIdEvent == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return ccmn46dIdEvent;
  }

  private int saveAllegation(String cdAllegIncidentStage, String cdAllegType, int idAllegedPerpetrator, int idStage,
                             int idVictim, String txtAllegDuration, Date dtAllegedIncident, 
                             String cdAllegedMalLocation, String cdMaltreatorRel, String indMaltreatInCare) {

    Allegation allegation = new Allegation();
    allegation.setCdAllegIncidentStage(cdAllegIncidentStage);
    allegation.setCdAllegType(cdAllegType);
    allegation.setCdAllegedMalLocation(cdAllegedMalLocation);
    allegation.setIndMaltreatInCare(indMaltreatInCare);
    if (idAllegedPerpetrator != 0) {
      Person allegedPerpetrator = (Person) getPersistentObject(Person.class, idAllegedPerpetrator);
      allegation.setPersonByIdAllegedPerpetrator(allegedPerpetrator);
    }
    allegation.setCdMaltreatorRel(cdMaltreatorRel);
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    stage.setIdStage(idStage);
    allegation.setStage(stage);
    Person victim = (Person) getPersistentObject(Person.class, idVictim);
    allegation.setPersonByIdVictim(victim);
    allegation.setTxtAllegDuration(txtAllegDuration);
    
    allegation.setDtAllegedIncident(dtAllegedIncident);

    // cinv07dAUDdam
    allegationDAO.saveAllegation(allegation);

    return allegation.getIdAllegation();
  }

  private void saveCpsInvstDetail(int idStage, int idEvent, Date dtCPSInvstDtlIntake, Date dtCPSInvstDtlBegun,
                                  Date dtCPSInvstDtlAssigned, Date dtCpsInvstDtlComplt) {

    CpsInvstDetail cpsInvstDetail = new CpsInvstDetail();
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    stage.setIdStage(idStage);
    cpsInvstDetail.setStage(stage);
    Event event = (Event) getPersistentObject(Event.class, idEvent);
    event.setIdEvent(idEvent);
    cpsInvstDetail.setEvent(event);
    cpsInvstDetail.setDtCpsInvstDtlIntake(dtCPSInvstDtlIntake);
    cpsInvstDetail.setDtCpsInvstDtlBegun(dtCPSInvstDtlBegun);

    // for some reason dtCPSInvstDtlAssigned is sent in as dtToday, but then
    // turns into 12-31-3500. so, i'm using today's date here.
    cpsInvstDetail.setDtCpsInvstDtlAssigned(new Date());
    cpsInvstDetail.setDtCpsInvstDtlComplt(dtCpsInvstDtlComplt);

    // cinv12dAUDdam
    cpsInvstDetailDAO.saveCpsInvstDetail(cpsInvstDetail);

  }
  
  private void saveInitialContact(Date dtToday, int divIdStage, int ccmn03uiIdPerson, int invIdStage) {
    //Retrieve initial contact created on the DIV stage. Create new event for contact and re-save initial contact
    // Find the Diversion Initial Contact
    Contact diversionContact = contactDAO.findInitialContactByIdStage(divIdStage);
    // Find the contact event so that we can copy it to create the newly created Investigation contact event
    Event divContactEvent = eventDAO.findEventByIdEvent(diversionContact.getIdEvent());
    int invContactEventId =  saveEvent(divContactEvent.getDtEventOccurred(), invIdStage, ccmn03uiIdPerson, divContactEvent.getTxtEventDescr(), 
                                       divContactEvent.getCdEventStatus(), INV_CONTACT_TASK, divContactEvent.getCdEventType());
    Event invContactEvent = (Event) getPersistentObject(Event.class, invContactEventId);
    // Copy the Event Person Link records and save them to indicate that the person was contacted
    List<EventPersonLink> eventPersonLinkList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(diversionContact.getIdEvent());
    if (eventPersonLinkList != null && !eventPersonLinkList.isEmpty()) {
      // copy each one
      for (Iterator<EventPersonLink> eventPersonLinkList_it = eventPersonLinkList.iterator(); eventPersonLinkList_it.hasNext();){
        EventPersonLink divContacteventPersonLink = eventPersonLinkList_it.next();
        EventPersonLink invContacteventPersonLink = new EventPersonLink();
        invContacteventPersonLink.setCapsCase(divContacteventPersonLink.getCapsCase());
        invContacteventPersonLink.setCdFamPlanPermGoal(divContacteventPersonLink.getCdFamPlanPermGoal());
        invContacteventPersonLink.setDtFamPlanPermGoalTarget(divContacteventPersonLink.getDtFamPlanPermGoalTarget());
        invContacteventPersonLink.setEvent(invContactEvent);
        invContacteventPersonLink.setIndCaregiver(divContacteventPersonLink.getIndCaregiver());
   //     invContacteventPersonLink.setInterceptFieldCallback(divContacteventPersonLink.getInterceptFieldCallback());
        invContacteventPersonLink.setPerson(divContacteventPersonLink.getPerson());
        invContacteventPersonLink.setTxtGoalCmmt(divContacteventPersonLink.getTxtGoalCmmt());
        eventPersonLinkDAO.saveEventPersonLink(invContacteventPersonLink);
      }
    }
    
    // Copy the Diversion Initial Contact into the Investigation Initial Contact 
    Contact investigationContact = new Contact();
    investigationContact.setCapsCase(diversionContact.getCapsCase());
    investigationContact.setCdContactLocation(diversionContact.getCdContactLocation());
    investigationContact.setCdContactMethod(diversionContact.getCdContactMethod());
    investigationContact.setCdContactOthers(diversionContact.getCdContactOthers());
    //investigationContact.setCdContactPurpose(diversionContact.getCdContactPurpose());
    investigationContact.setCdContactTcmEligible(diversionContact.getCdContactTcmEligible());
    investigationContact.setCdContactTcmMedSvcs(diversionContact.getCdContactTcmMedSvcs());
    investigationContact.setCdContactType(diversionContact.getCdContactType());
    investigationContact.setDtCntctMnthlySummBeg(diversionContact.getDtCntctMnthlySummBeg());
    investigationContact.setDtCntctMnthlySummEnd(diversionContact.getDtCntctMnthlySummEnd());
    investigationContact.setDtCntctNextSummDue(diversionContact.getDtCntctNextSummDue());
    investigationContact.setDtContactApprv(diversionContact.getDtContactApprv());
    investigationContact.setDtContactOccurred(diversionContact.getDtContactOccurred());
    investigationContact.setIndContactAttempted(diversionContact.getIndContactAttempted());
    investigationContact.setIndPermCrossCntyLn(diversionContact.getIndPermCrossCntyLn());
    //investigationContact.setInterceptFieldCallback(diversionContact.getInterceptFieldCallback());
    investigationContact.setNmAgencyName(diversionContact.getNmAgencyName());
    investigationContact.setPerson(diversionContact.getPerson());
    investigationContact.setPersonByIdContactTcmClient(diversionContact.getPersonByIdContactTcmClient());
    //MR-024 Setting the newly added fields 
    investigationContact.setCdContactedBy(diversionContact.getCdContactedBy());
    investigationContact.setCdContactNarrative(diversionContact.getCdContactNarrative());
    investigationContact.setDtEnteredOn(diversionContact.getDtEnteredOn()); 
    investigationContact.setNmContactedBy(diversionContact.getNmContactedBy());  
    
    investigationContact.setEvent(invContactEvent);
    
    investigationContact.setIdEvent(invContactEventId);
    
    Stage invContactStage = (Stage) getPersistentObject(Stage.class, invIdStage);
    investigationContact.setStage(invContactStage);
    
    contactDAO.saveContact(investigationContact);
    
    //-- Retrieve any existing CONTACT_CBX records for the DIV contact
    List<ContactCbx> cbxList = contactCbxDAO.findContactCbx(diversionContact.getIdEvent());
    if(cbxList != null && !cbxList.isEmpty()) {
      // For each checkbox record, copy it and recreate it for the INV contact
      for(Iterator<ContactCbx> cbxList_it = cbxList.iterator(); cbxList_it.hasNext();) {
        ContactCbx cbx_div = cbxList_it.next();
        ContactCbx cbx_inv = new ContactCbx();
        cbx_inv.setCdCbxCodeType(cbx_div.getCdCbxCodeType());
        cbx_inv.setCdContactCbx(cbx_div.getCdContactCbx());
       // cbx_inv.setInterceptFieldCallback(cbx_div.getInterceptFieldCallback());
        cbx_inv.setContact(investigationContact);
        contactCbxDAO.saveContactCbx(cbx_inv);
      }
    }
  }
  private void saveDiversionConclusion(int idStage, int idEvent) {

    DiversionConclusion diversionConclusion = new DiversionConclusion();
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    stage.setIdStage(idStage);
    diversionConclusion.setStageByIdStage(stage);
    Event event = (Event) getPersistentObject(Event.class, idEvent);
    event.setIdEvent(idEvent);
    diversionConclusion.setEvent(event);
    CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, stage.getCapsCase().getIdCase());
    diversionConclusion.setCapsCaseByIdCase(capsCase);
    
    diversionConclusionDAO.saveDiversionConclusion(diversionConclusion);
  }

  /*
  private void insertLicensingInvstDtl(int idStage, int idEvent, Date dtLicngInvstDtlBegun, Date dtLicngInvstIntake,
                                       Date dtLicngInvstAssigned, Date dtLicngInvstComplt) throws ServiceException {

    // cinv53dAUDdam

    int cinv53dRowsUpdated = licensingInvstDtlDAO.insertLicensingInvstDtl(idEvent, idStage, null, dtLicngInvstIntake,
                                                                          dtLicngInvstDtlBegun, dtLicngInvstComplt,
                                                                          dtLicngInvstAssigned, null, null, 0, null, 0,
                                                                          null, null, null, null, null, null, null,
                                                                          null, null, null, null, 0, null, null, null,
                                                                          null, null, null, null, null, null, null,
                                                                          null, 0, 0, 0, 0, 0, 0, 0, null);

    if (cinv53dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

  }
  */
  
  /*
  private void insertFacilityInvstDtl2(int idStage, int idEvent, Date dtFacilInvstBegun, Date dtFacilInvstIntake,
                                       Date dtFacilInvstIncident, Date dtFacilInvstComplt) throws ServiceException {

    // cinv54dAUDdam
    int cinv54dRowsUpdated = facilityInvstDtlDAO.insertFacilityInvstDtl2(idEvent, idStage, 0, 0, null, null, null,
                                                                         null, null, null, null, null, null, null,
                                                                         null, null, null, null, null,
                                                                         dtFacilInvstIntake, dtFacilInvstIncident,
                                                                         dtFacilInvstBegun, dtFacilInvstComplt, 0, 0,
                                                                         null, null, null, null, null, null);

    if (cinv54dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

  }
  */

  private List<StagePersonLink> findStagePersonLinkRowsByIdStage(int idStage) {
    // ccmnb9dQUERYdam
    return stagePersonLinkDAO.findStagePersonLinkRowsByIdStage(idStage);
  }

  private void saveTodo(String todoTask, String cdTodoType, Date dtTodoCreated, Date dtTodoDue, Date dtTaskDue,
                        Date dtTodoCompleted, int idCase, int idEvent, int idTodoPersAssigned, int idTodoPersCreator,
                        int idTodoPersWorker, int idStage, String txtTodoDesc, String txtTodoLongDesc) {

    Todo todo = new Todo();
    // Session session = getSession();
    todo.setCdTodoTask(todoTask);
    todo.setCdTodoType(cdTodoType);
    todo.setDtTodoCreated(dtTodoCreated);
    todo.setDtTodoDue(dtTodoDue);
    todo.setDtTodoTaskDue(dtTaskDue);
    todo.setDtTodoCompleted(dtTodoCompleted);

    CapsCase capsCase = new CapsCase();
    if (idCase != 0) {
      capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
      todo.setCapsCase(capsCase);
    }
    // todo.setCapsCase(capsCase);

    Event event = new Event();
    if (idEvent != 0) {
      event = (Event) getPersistentObject(Event.class, idEvent);
      // Event event = (Event) session.load(Event.class, idEvent);
      todo.setEvent(event);
    }

    Person personIdTodoPersAssigned = new Person();
    if (idTodoPersAssigned != 0) {
      personIdTodoPersAssigned = (Person) getPersistentObject(Person.class, idTodoPersAssigned);
      todo.setPersonByIdTodoPersAssigned(personIdTodoPersAssigned);
    }
    // todo.setPersonByIdTodoPersAssigned(personIdTodoPersAssigned);

    Person personIdTodoPersCreator = new Person();
    if (idTodoPersCreator != 0) {
      personIdTodoPersCreator = (Person) getPersistentObject(Person.class, idTodoPersCreator);
      // Person personIdTodoPersCreator = (Person) session.load(Person.class, idTodoPersCreator);
      todo.setPersonByIdTodoPersCreator(personIdTodoPersCreator);
    }
    // todo.setPersonByIdTodoPersCreator(personIdTodoPersCreator);

    Person personIdTodoPersWorker = new Person();
    if (idTodoPersWorker != 0) {
      personIdTodoPersWorker = (Person) getPersistentObject(Person.class, idTodoPersWorker);
      // Person personIdTodoPersWorker = (Person) session.load(Person.class, idTodoPersWorker);
      todo.setPersonByIdTodoPersWorker(personIdTodoPersWorker);
    }

    // todo.setPersonByIdTodoPersWorker(personIdTodoPersWorker);

    Stage stage = new Stage();
    stage = (Stage) getPersistentObject(Stage.class, idStage);
    // Stage stage = (Stage) session.load(Stage.class, idStage);
    todo.setStage(stage);
    todo.setTxtTodoDesc(txtTodoDesc);
    todo.setTxtTodoLongDesc(txtTodoLongDesc);

    // ccmn43dAUDdam
    todoDAO.saveTodo(todo);

  }

  private void saveStageLink(int idStage, int idPriorStage) {
    StageLink stageLink = new StageLink();
    Stage stage = getPersistentObject(Stage.class, idStage);
    stageLink.setStageByIdStage(stage);
    Stage priorStage = getPersistentObject(Stage.class, idPriorStage);
    stageLink.setStageByIdPriorStage(priorStage);
    // ccmnc1dAUDdam
    stageLinkDAO.saveStageLink(stageLink);
  }
  
  /*
  private void saveContact(int idEvent, int idStage, String cdContactType) {

    Contact contact = new Contact();
    Event event = new Event();
    event.setIdEvent(idEvent);
    contact.setEvent(event);
    Stage stage = new Stage();
    stage.setIdStage(idStage);
    contact.setStage(stage);
    Person person = new Person();
    person.setIdPerson(0);
    contact.setPerson(person);
    contact.setCdContactLocation(null);
    contact.setCdContactMethod(null);
    contact.setCdContactOthers(null);
    contact.setCdContactPurpose(null);
    contact.setCdContactType(cdContactType);
    contact.setIndContactAttempted(null);
    contact.setDtCntctMnthlySummBeg(DateHelper.NULL_JAVA_DATE);
    contact.setDtCntctMnthlySummEnd(DateHelper.NULL_JAVA_DATE);
    contact.setDtContactOccurred(DateHelper.NULL_JAVA_DATE);

    // csys07dAUDdam
    contactDAO.saveContact(contact);

  }
  */

  private List<Object[]> findEvents(int idStage, String cdTask, String[] cdEventTypes) throws ServiceException {
    boolean extraTables = false;
    // ccmn87dQUERYdam
    return dynamicEventDAO.findEvents(extraTables, 0, idStage, 0, 0, 0, cdEventTypes, null, cdTask, null, null, null);
  }

  /*
  private void updateEventByIdEventAndCdTask(int idStage, int idEvent, String cdTask) throws ServiceException {

    // ccmng7dAUDdam
    int ccmng7dRowsUpdated = eventDAO.updateEventByIdEventAndCdTask(idStage, cdTask, idEvent);

    if (ccmng7dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }
  */
  
  /*
  private void updateContact(int idStage, int idEvent) throws ServiceException {

    // ccmng8dAUDdam
    int ccmng8dRowsUpdated = contactDAO.updateContact(idStage, idEvent);

    if (ccmng8dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

  }
  */
  
  /*
  private void updateTodo(int idTodo, String cdTask, int idStage) throws ServiceException {

    // ccmng9dAUDdam
    int ccmng9dRowsUpdated = todoDAO.updateTodo(idTodo, cdTask, idStage);

    if (ccmng9dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

  }
  */

  private void saveSvcAuthEventLink(int idSvcAuth, int idSvcAuthEvent) {

    SvcAuthEventLink svcAuthEventLink = new SvcAuthEventLink();
    svcAuthEventLink.setIdSvcAuthEvent(idSvcAuthEvent);
    ServiceAuthorization serviceAuthorization = new ServiceAuthorization();
    serviceAuthorization.setIdSvcAuth(idSvcAuth);
    svcAuthEventLink.setServiceAuthorization(serviceAuthorization);

    // caud34dAUDdam
    svcAuthEventLinkDAO.saveSvcAuthEventLink(svcAuthEventLink);
  }

  private Iterator findStageByIdPersonInput(int idPerson) throws ServiceException {

    // clsc45dQUERYdam
    List<Map> stageListMap = stageDAO.findStageByIdPersonInput(idPerson);

    if (stageListMap == null || stageListMap.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return stageListMap.iterator();
  }

  private void saveAdminReview(int idStage, int idPerson, int idEvent, int idStageRelated) {

    AdminReview adminReview = new AdminReview();
    // Stage stage = new Stage();
    // stage.setIdStage(idStage);
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    adminReview.setStage(stage);
    // Person person = new Person();
    // person.setIdPerson(idPerson);
    Person person = (Person) getPersistentObject(Person.class, idPerson);
    adminReview.setPerson(person);
    // Event event = new Event();
    // event.setIdEvent(idEvent);
    Event event = (Event) getPersistentObject(Event.class, idEvent);
    adminReview.setEvent(event);
    // Stage idStageRelatedStage = new Stage();
    // idStageRelatedStage.setIdStage(idStageRelated);
    Stage idStageRelatedStage = (Stage) getPersistentObject(Stage.class, idStageRelated);
    adminReview.setStageByIdStageRelated(idStageRelatedStage);
    adminReview.setDtLastUpdate(null);
    adminReview.setDtAdminRvAppealNotif(null);
    adminReview.setDtAdminRvAppealReview(null);
    adminReview.setDtAdminRvDue(null);
    adminReview.setDtAdminRvEmgcyRel(null);
    adminReview.setDtAdminRvHearing(null);
    adminReview.setDtAdminRvReqAppeal(null);
    adminReview.setCdAdminRvStatus("");

    // cauda3dAUDdam
    adminReviewDAO.saveAdminReview(adminReview);

  }

  private void copyEligibility(int idAdoEligibilityEvent, int idPadEligibilityEvent, int idPadChild) {
    Eligibility adoElig = eligibilityDAO.findEligibilityByIdEligEvent(idAdoEligibilityEvent);

    if (adoElig == null) {
      // this should never happen
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Event event = getPersistentObject(Event.class, idPadEligibilityEvent);
    Person padPrimaryChild = getPersistentObject(Person.class, idPadChild);
    // create primary child event person link to new event
    EventPersonLink eventPersonLink = new EventPersonLink();
    eventPersonLink.setCapsCase(event.getCapsCase());
    eventPersonLink.setEvent(event);
    eventPersonLink.setPerson(getPersistentObject(Person.class, idPadChild));
    eventPersonLinkDAO.saveEventPersonLink(eventPersonLink);

    Eligibility padElig = new Eligibility();
    padElig.setCdEligActual(adoElig.getCdEligActual());
    padElig.setCdEligCsupQuest1(adoElig.getCdEligCsupQuest1());
    padElig.setCdEligCsupQuest2(adoElig.getCdEligCsupQuest2());
    padElig.setCdEligCsupQuest3(adoElig.getCdEligCsupQuest3());
    padElig.setCdEligCsupQuest4(adoElig.getCdEligCsupQuest4());
    padElig.setCdEligCsupQuest5(adoElig.getCdEligCsupQuest5());
    padElig.setCdEligCsupQuest6(adoElig.getCdEligCsupQuest6());
    padElig.setCdEligCsupQuest7(adoElig.getCdEligCsupQuest7());
    padElig.setCdEligMedEligGroup(adoElig.getCdEligMedEligGroup());
    padElig.setCdEligSelected(adoElig.getCdEligSelected());
    padElig.setCdFceEligReason(adoElig.getCdFceEligReason());
    padElig.setDtEligCsupReferral(adoElig.getDtEligCsupReferral());
    padElig.setDtEligEnd(adoElig.getDtEligEnd());
    padElig.setDtEligReview(adoElig.getDtEligReview());
    padElig.setDtEligStart(adoElig.getDtEligStart());
    padElig.setDtLastUpdate(adoElig.getDtLastUpdate());
    padElig.setEvent(event); // replace with new Pad event
    padElig.setIdEligEvent(idPadEligibilityEvent); // replace with new pad id event
    padElig.setIndEligCsupSend(adoElig.getIndEligCsupSend());
    padElig.setIndEligWriteHistory(adoElig.getIndEligWriteHistory());
    padElig.setIndReviewCreated(adoElig.getIndReviewCreated());
    padElig.setPersonByIdPerson(padPrimaryChild); // set new PAD child id
    padElig.setPersonByIdPersonUpdate(adoElig.getPersonByIdPersonUpdate());
    padElig.setTxtChildSuppRefComment(adoElig.getTxtChildSuppRefComment());
    padElig.setTxtEligComment(adoElig.getTxtEligComment());

    eligibilityDAO.saveEligibility(padElig);
  }

  private void copyAAFundingSummary(int idAdoAaFundingEvent, int idPadAaFundingEvent, int idPadChild) {
    AaFunding adoAaFunding = aaFundingDAO.findAAfundingByIdEvent(idAdoAaFundingEvent);

    if (adoAaFunding == null) {
      // this should never happen
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Person padPrimaryChild = getPersistentObject(Person.class, idPadChild);
    Event padAaFundingEvent = eventDAO.findEventByIdEvent(idPadAaFundingEvent);

    // create primary child event person link to new event
    EventPersonLink eventPersonLink = new EventPersonLink();
    eventPersonLink.setCapsCase(padAaFundingEvent.getCapsCase());
    eventPersonLink.setEvent(padAaFundingEvent);
    eventPersonLink.setPerson(padPrimaryChild);
    eventPersonLinkDAO.saveEventPersonLink(eventPersonLink);

    AaFunding padAaFunding = new AaFunding();
    padAaFunding.setCdAaFundingType(adoAaFunding.getCdAaFundingType());
    padAaFunding.setChild(padPrimaryChild); // replace with new PAD child
    padAaFunding.setDtAaFundingValidated(adoAaFunding.getDtAaFundingValidated());
    padAaFunding.setDtAcSiblingDob(adoAaFunding.getDtAcSiblingDob());
    padAaFunding.setDtChildDob(adoAaFunding.getDtChildDob());
    padAaFunding.setDtCreated(adoAaFunding.getDtCreated());
    padAaFunding.setDtLastUpdate(adoAaFunding.getDtLastUpdate());
    padAaFunding.setEligibility(adoAaFunding.getEligibility());
    padAaFunding.setEmployee(adoAaFunding.getEmployee());
    padAaFunding.setEvent(padAaFundingEvent); // replace with new pad Event
    padAaFunding.setIdAaFundingEvent(idPadAaFundingEvent); // replace with new pad event id
    padAaFunding.setIndAcAgeMet(adoAaFunding.getIndAcAgeMet());
    padAaFunding.setIndAcChildOfMinorMet(adoAaFunding.getIndAcChildOfMinorMet());
    padAaFunding.setIndAcIvePriorAdoptMet(adoAaFunding.getIndAcIvePriorAdoptMet());
    padAaFunding.setIndAcSiblingMet(adoAaFunding.getIndAcSiblingMet());
    padAaFunding.setIndAcSsiEligMet(adoAaFunding.getIndAcSsiEligMet());
    padAaFunding.setIndAcTimeInFosterMet(adoAaFunding.getIndAcTimeInFosterMet());
    padAaFunding.setIndAcTprCtwVsMet(adoAaFunding.getIndAcTprCtwVsMet());
    padAaFunding.setIndNacAfdcMet(adoAaFunding.getIndNacAfdcMet());
    padAaFunding.setIndNacChildOfMinorMet(adoAaFunding.getIndNacChildOfMinorMet());
    padAaFunding.setIndNacIvePriorAdoptMet(adoAaFunding.getIndNacIvePriorAdoptMet());
    padAaFunding.setIndNacSsiEligMet(adoAaFunding.getIndNacSsiEligMet());
    padAaFunding.setIndNonRecurringReq(adoAaFunding.getIndNonRecurringReq());
    padAaFunding.setNbrAcSiblingAge(adoAaFunding.getNbrAcSiblingAge());
    padAaFunding.setNbrAcSiblingMthsInFoster(adoAaFunding.getNbrAcSiblingMthsInFoster());
    padAaFunding.setNbrChildAge(adoAaFunding.getNbrChildAge());
    padAaFunding.setNbrChildMthsInFoster(adoAaFunding.getNbrChildMthsInFoster());
    padAaFunding.setNbrFfy(adoAaFunding.getNbrFfy());
    padAaFunding.setNmAcSiblingFullName(adoAaFunding.getNmAcSiblingFullName());
    padAaFunding.setSibling(adoAaFunding.getSibling());
    padAaFunding.setTxtComments(adoAaFunding.getTxtComments());

    aaFundingDAO.saveAaFunding(padAaFunding);

    padAaFunding = aaFundingDAO.findAAfundingByIdEvent(idPadAaFundingEvent);

    // Loop through any AAFundingReasonElig for ADO stage and copy over with new PAD stage AA Funding event id.
    Collection<AaFundingReasonElig> adoAaFundingReasonEligs = adoAaFunding.getAaFundingReasonEligs();
    if(adoAaFundingReasonEligs != null){
      Iterator<AaFundingReasonElig> iter = adoAaFundingReasonEligs.iterator();
  
      while (iter.hasNext()) {
        AaFundingReasonElig adoAaFundingReasonElig = iter.next();
        // update to new event
        AaFundingReasonElig padAaFundingReasonElig = new AaFundingReasonElig();
        padAaFundingReasonElig.setAaFunding(padAaFunding);
        padAaFundingReasonElig.setCdAaFundingRsn(adoAaFundingReasonElig.getCdAaFundingRsn());
        padAaFundingReasonElig.setDtLastUpdate(adoAaFundingReasonElig.getDtLastUpdate());
        padAaFundingReasonElig.setIdAaFundingReasonElig(padAaFunding.getIdAaFundingEvent());
  
        aaFundingReasonEligDAO.saveAaFundingReasonElig(padAaFundingReasonElig);
      }
    }
  }

  private int findStagePersonLinkByCdStageIdPersonCdRoleIdcase(int idPerson, int idCase, String cdStagePersRole,
                                                               String cdStage) {

    // csec29dQUERYdam
    StagePersonLink csec29dStagePersonLink = stagePersonLinkDAO.findStagePersonLinkByCdStageIdPersonCdRoleIdcase(cdStage,
                                                                                                                 idPerson,
                                                                                                                 cdStagePersRole,
                                                                                                                 idCase);

    int csec29dIdPerson;
    if (csec29dStagePersonLink != null) {
      csec29dIdPerson = csec29dStagePersonLink.getPerson().getIdPerson();
    } else {
      csec29dIdPerson = 0;
    }

    return csec29dIdPerson;
  }

  private int findAdptSubEventLink(int idEvent) throws ServiceException {

    // cses64dQUERYdam
    Map cses64dIdAdptSubMap = adptSubEventLinkDAO.findAdptSubEventLink(idEvent);

    if (cses64dIdAdptSubMap == null || cses64dIdAdptSubMap.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return (Integer) cses64dIdAdptSubMap.get("idAdptSub");
  }

  private List<Map> findResourceandStagePersonLinkByidPersonAndCdPlcmtActPlanned(int idPerson) throws ServiceException {

    // clss63dQUERYdam
    List<Map> stagePersonLinkListMap = stagePersonLinkDAO.findResourceandStagePersonLinkByidPersonAndCdPlcmtActPlanned(idPerson);

    if (stagePersonLinkListMap == null || stagePersonLinkListMap.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return stagePersonLinkListMap;
  }
  
  /*
  private List findStageStagePersonLinkByIdStageAndIdStageRelated(int idStage, int idStageRelated) {
    // clsc75dQUERYdam
    return stageDAO.findStageStagePersonLinkByIdStageAndIdStageRelated(idStage, idStageRelated);
  }
  */

  // private void countOpenStagesForIdPerson(int idPrimChild) throws ServiceException {
  // // cses94dQUERYdam
  // long countOpenStagesForIdPerson = complexStagePersonLinkDAO.countOpenStagesForIdPerson("0", idPrimChild,
  // PERSON_ROLE_PRIM_CHILD,
  // PREP_ADULT);
  //
  // if (countOpenStagesForIdPerson > 0) {
  // throw new ServiceException(Messages.MSG_PAL_STAGE_EXISTS);
  // }
  // }

  private boolean findCpsInvstDetailByIdStage(int idStage) {

    boolean bEA_Eligible = false;

    // cseca2dQUERYdam
    CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStage(idStage);

    if (cpsInvstDetail != null) {
      bEA_Eligible = true;
    }

    return bEA_Eligible;
  }

  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {
    // ccmn60d
    Map resultMap = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
    Integer idSupervisor = null;
    if (resultMap != null && resultMap.size() > 0) {
      idSupervisor = (Integer) resultMap.get("idPerson");
    }
    if (idSupervisor == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return getPersistentObject(Person.class, idSupervisor);
  }

  /**
   * check if a secondary MES Worker already exists for the stage. If secondary MES Worker already exists, Get all MES
   * Workers currently assigned as a secondary to the given stage.
   * 
   * @param idStage
   * @return List<Integer> List of assigned secondary MES Workers 
   */
  private List<Integer> getSecondaryAssignedMesWorkers(int idStage) {
    String[] secAttributesMESWorker = { SEC_REG_FAM_INDP_STF, SEC_REG_FAM_INDP_MGMNT_STF };
    List<Integer> mesWorkerAssignedAsSEList = new ArrayList<Integer>();

    // retrieve list of all secondary workers for the stage
    List<Integer> idSecondaryWorkers = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);
    if (idSecondaryWorkers != null && idSecondaryWorkers.size() > 0) {
      // loop thru the list of secondary workers, retrieve their security profile
      // and see if they have the MES Worker attribute
      for (Iterator<Integer> it_idSecondaryWorkers = idSecondaryWorkers.iterator(); it_idSecondaryWorkers.hasNext();) {
        int idSecondaryWorker = it_idSecondaryWorkers.next();
        if ((checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, secAttributesMESWorker[0]))
            || (checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, secAttributesMESWorker[1]))) {
          mesWorkerAssignedAsSEList.add(idSecondaryWorker);
        }
      }
    }
    return mesWorkerAssignedAsSEList;
  }

  private String retrieveStageRegionByStageId(int idStage) {
    Stage stage = stageDAO.findStageByIdStage(idStage);
    String cdStageRegion = stage.getCdStageRegion();
    if (cdStageRegion != null) {
      if (cdStageRegion.length() == 1) {
        cdStageRegion = "00" + cdStageRegion;
      } else if (cdStageRegion.length() == 2) {
        cdStageRegion = "0" + cdStageRegion;
      }
    }
    return cdStageRegion;
  }

  // STGAP00017013: MR-095
  private String findCdStagePersRelFromMapping(int idPerson, String cdRelInFcfStage, String cdStagePersRelPK,
                                               String cdPersonSex) {
    String cdRelFromMapping = "";

    // Send Principal to the relationship mapping
    // In the relationship mapping table, there are only few conditions in the mapping table
    // that Gender of the person determines the relationship:
    // (The rows below can be obtained by filtering CD_PERSON_GENDER is not null)
    // 1. cdStagePersRelPKForPrincipals = PARENT 
    //    and cdStagePersRelInt = Biological Sibling, Grandparent, Half Sibling, Self, Self/Minor Parent, Sibling
    // 2. cdStagePersRelPKForPrincipals = GRANDPARENT 
    //    and cdStagePersRelInt = Absent Parent, Adoptive Parent, Aunt/Uncle, Biological and Legal Father,
    //                            Biological Father, Biological Mother, Biological Parent, Great Grandparent,
    //                            Legal Father, Legal Mother, Parent, Step-Parent
    // 3. cdStagePersRelPKForPrincipals = AUNT_UNCLE 
    //    and cdStagePersRelInt = First Cousin, Grandparent
    // 4. cdStagePersRelPKForPrincipals = SIBLING
    //    and cdStagePersRelInt = Grandchild 
    //
    // So check the conditions first; if Gender is Unknown then set the Gender as Female 
    // for passong Gender in the conditions mentioned above
    if (UNKNOWN.equals(cdPersonSex)) {
      cdPersonSex = FEMALE;
    }
    if ((PARENT.equals(cdStagePersRelPK) && PARENT_RELATIONSHIP_GEN_SPECIFIC.contains(cdRelInFcfStage))
                    || (GRANDPARENT.equals(cdStagePersRelPK) && GRANDPARENT_RELATIONSHIP_GEN_SPECIFIC.contains(cdRelInFcfStage))
                    || (AUNT_UNCLE.equals(cdStagePersRelPK) && AUNT_UNCLE_RELATIONSHIP_GEN_SPECIFIC.contains(cdRelInFcfStage))
                    || (SIBLING.equals(cdStagePersRelPK) && SIBLING_RELATIONSHIP_GEN_SPECIFIC.contains(cdRelInFcfStage)))  
    {
      // Find the relationship mapping based on Gender
      cdRelFromMapping = stagePersRelMapStgPrgDAO
                                                  .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStageCdPersonGender(
                                                                                                                           cdStagePersRelPK,
                                                                                                                           cdRelInFcfStage,
                                                                                                                           cdPersonSex);
    } else {
      // Find the relationship mapping without Gender involved
      cdRelFromMapping = stagePersRelMapStgPrgDAO
                                                  .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                                             cdStagePersRelPK,
                                                                                                             cdRelInFcfStage);
    }

    return cdRelFromMapping;
  }
  
  // STGAP00017013: MR-095
  private Map checkCdStagePersRelPK(int idFcfStage, int idMostRecentFamilyStage) {
    String cdStagePersRelPK = "";
    int idPrimaryCaretaker = 0;
    boolean noPrimaryCaretaker = false;
    boolean multiPrimaryCaretaker = false;
    // Get the count for PK only if the FCF stage has been progressed from another stage
    // The count is not needed for stand-alone FCF (from conversion)
    if (idMostRecentFamilyStage > 0) {
      long cntPrimaryCaretaker = stagePersonLinkDAO
                                                   .countStagePersonLinkByIdStageCdStagePersRelInt(
                                                                                                   idMostRecentFamilyStage,
                                                                                                   CodesTables.CRELVICT_PK);
      noPrimaryCaretaker = cntPrimaryCaretaker < 1 ? true : false;
      multiPrimaryCaretaker = cntPrimaryCaretaker > 1 ? true : false;
    }
    // If no PK found, set the person with the stage name as PK
    // If multiple PK found, set the person with the stage name as the PK
    // and set the relationship of the additional PK(s) as 'Other' (by sending to the relationship mapping)
    if (noPrimaryCaretaker || multiPrimaryCaretaker || idMostRecentFamilyStage == 0) {
      String stageName = stageDAO.findNmStageByIdStage(idFcfStage);

      // This is query for the exact match between the stage name and person name
      Person personWithStageName = stagePersonLinkDAO.findPersonByIdStageByNmPersonFull(idFcfStage, stageName);
      if (personWithStageName != null) {
        idPrimaryCaretaker = personWithStageName.getIdPerson();
      }
      // There are stages that have stage name not in sync with the person name of the PK
      // If no exact match found between stage name and person name
      // then look for the person having the same last and first name as in the stage name
      // For instance, if there is no PK exists in the stage and the stage name is 'Mciver,Ronald'
      // then look for person with the same last and first name with the stage name
      // Therefore, person name as 'Mciver,Ronald A' can be considered as a match
      // even if the person has extra initials
      //
      // Note: There are some variations in entering person name
      // Some names have Jr., Sr., or Third as its Suffix column
      // and some names have Jr., Sr., or Third inside of its first name or last name
      // Therefore, the following code will catch as many variations as possible
      // Here are some example of stage name Vs. person name that the code will catch:
      // Stage name Haynes Iii,Joshua with person name Haynes,Joshua
      // Stage name Mcgath, Jr.,Thomas with person name Mcgath,Thomas L
      // Stage name Johnson Jr.,Joseph with person name Johnson,Joseph D

      else {
        // Compare the entire string of the stage name and person name
        List<StagePersonLink> stagePersonLink = stagePersonLinkDAO
                                                                  .findAllPrincipalsLinkedToStage(idFcfStage,
                                                                                                  PERSON_ROLE_PRINCIPAL);
        Iterator<StagePersonLink> it = stagePersonLink.iterator();
        while (it.hasNext()) {
          StagePersonLink spl = it.next();
          String lastName = spl.getPerson().getNmPersonLast();
          String firstName = spl.getPerson().getNmPersonFirst();
          if (StringHelper.getSafeString(spl.getPerson().getNmPersonFull()).startsWith(stageName)) {
            idPrimaryCaretaker = spl.getPerson().getIdPerson();
          } else if (stageName.startsWith(StringHelper.getSafeString(spl.getPerson().getNmPersonFull()))) {
            idPrimaryCaretaker = spl.getPerson().getIdPerson();
          }
        }

        // If PK is still not found check for more variations
        if (idPrimaryCaretaker == 0) {
          // There are two different patterns in the last name in the stage name
          // 1. Space before the first comma
          // 2. First comma, Jr., Sr., etc., then second comma, then last name
          String lastNmFrStgNm = "";
          String firstNmFrStgNm = "";
          if (StringHelper.isValid(stageName) && stageName.indexOf(',') > 0) {
            // Check for the space before the first comma
            int idLocSpaceBeforeComma = -1;
            if (stageName.indexOf(' ') > 0) {
              idLocSpaceBeforeComma = stageName.indexOf(' ');
            }
            // Check for the existence of second comma
            String nmAfterFirstComma = stageName.substring(stageName.indexOf(',') + 1);
            int checkSecondComma = nmAfterFirstComma.indexOf(',');
            if (checkSecondComma > 0 && idLocSpaceBeforeComma < 0) {
              // Last name will be anything before the first comma
              lastNmFrStgNm = stageName.substring(0, stageName.indexOf(','));
              // First name will be anything after the second comma
              firstNmFrStgNm = nmAfterFirstComma.substring(checkSecondComma + 1);
            } else if (checkSecondComma > 0 && idLocSpaceBeforeComma > 0) {
              // Last name will be anything before the first comma
              lastNmFrStgNm = stageName.substring(0, stageName.indexOf(','));
              // First name will be anything after the second comma
              firstNmFrStgNm = nmAfterFirstComma.substring(checkSecondComma + 1);
            } else if (idLocSpaceBeforeComma > 0) {
              // Compare the location of the space and comma
              if (idLocSpaceBeforeComma < stageName.indexOf(',')) {
                lastNmFrStgNm = stageName.substring(0, idLocSpaceBeforeComma);
                firstNmFrStgNm = stageName.substring(stageName.indexOf(',') + 1);
              }
            } else {
              // This is condition for the comparison between normal stage name with first and last name only
              // and person name with some variations (i.e. having middle initial, space, suffix, etc.)
              lastNmFrStgNm = stageName.substring(0, stageName.indexOf(','));
              firstNmFrStgNm = stageName.substring(stageName.indexOf(',') + 1);
            }
          }

          // Find the person with the same last name and first name as in the stage name
          Person personWithSimilarStgNm = personDAO.findPersonByFirstNameLastName(firstNmFrStgNm, lastNmFrStgNm);
          if (personWithSimilarStgNm != null) {
            idPrimaryCaretaker = personWithSimilarStgNm.getIdPerson();
          }
        }
      }
    }

    if (!noPrimaryCaretaker && !multiPrimaryCaretaker && idMostRecentFamilyStage > 0) {
      // Set the Relationship that is used for mapping through STAGE_PERS_REL_MAP_STG_PRG table
      // The Relationship is based on the PK relationship in FCF stage
      Person personPK = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRelInt(idMostRecentFamilyStage,
                                                                                           CodesTables.CRELVICT_PK);
      if (personPK != null) {
        idPrimaryCaretaker = personPK.getIdPerson();
      }
    }

    if (idPrimaryCaretaker > 0) {
      // Single PK has been set
      // Do the rest of the mapping
      // Find the relationship for the overall mapping based on the PK relationship in FCF stage
      StagePersonLink singlePK = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idPrimaryCaretaker,
                                                                                            idFcfStage);

      // if PK in the previous family stage is any of the following Parent type in the FCF stage
      // cdStagePersRelPK is Parent
      if (PARENT_RELATIONSHIP_CATEGORY.contains(singlePK.getCdStagePersRelInt()))
      {
        cdStagePersRelPK = PARENT;
      }
      // if PK in the previous family stage is Grandparent, cdStagePersRelPK is Grandparent
      else if (singlePK.getCdStagePersRelInt().equals(CodesTables.CRELVICT_GP)) {
        cdStagePersRelPK = GRANDPARENT;
      }
      // if PK in the previous family stage is Aunt/Uncle, cdStagePersRelPK is Aunt/Uncle
      else if (singlePK.getCdStagePersRelInt().equals(CodesTables.CRELVICT_AU)) {
        cdStagePersRelPK = AUNT_UNCLE;
      }
      // if PK in the previous family stage is First Cousin, cdStagePersRelPK is Cousin
      else if (singlePK.getCdStagePersRelInt().equals(CodesTables.CRELVICT_CO)) {
        cdStagePersRelPK = COUSIN;
      }
      // if PK in the previous family stage is Sibling, cdStagePersRelPK is Sibling
      else if (singlePK.getCdStagePersRelInt().equals(CodesTables.CRELVICT_SB)) {
        cdStagePersRelPK = SIBLING;
      }
      // if PK in the previous family stage has the other Relationships other than specified above
      // cdStagePersRelPK is Non Related
      else {
        cdStagePersRelPK = NON_RELATED;
      }
    } else {
      // If PK cannot be determined, set the relationship category to Non Related to avoid null value is displayed in the Person List
      cdStagePersRelPK = NON_RELATED;
    }    

    Map pkMap = new HashMap();    
    pkMap.put("idPrimaryCaretaker", idPrimaryCaretaker);
    pkMap.put("cdStagePersRelPK", cdStagePersRelPK);
    
    return pkMap;
  }
}