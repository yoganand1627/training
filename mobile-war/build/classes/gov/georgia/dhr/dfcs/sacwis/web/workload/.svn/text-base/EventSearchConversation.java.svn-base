package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveEventList;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.Assessment;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.common.EventUtility;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermineIfPptDocumentedSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenMapping;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used to display Event Search, and List <p/>
 * <p/>
 * <pre>
 *          Change History:
 *           Date      User              Description
 *           --------  ----------------  --------------------------------------------------
 *            07/01/04  thompswa         SIR 18013 New Using enabled for cd_tasks
 *                                       3090,8600,9090 with a new method,
 *                                       isPlacementForCase(), called in method
 *                                       eventListSetWindowState.
 *            07/13/04  CORLEYAN         SIR 22985 - When throwing the illegal state
 *                                       exception for display event list, added a
 *                                       message to try and get more informative
 *                                       information from the user.
 *            09/30/04  dickmaec         SIR 15547 - Added the Event Type Event
 *                                       List.
 *            04/20/05  CORLEYAN         SIR 23530 - Added Date Stage Start into global data so that
 *                                       The tabs will display correctly.
 *            05/04/05  Todd Reser       SIR 23033 - If it's an Eligibility Summary List
 *                                       we need to check and see if there is a Foster
 *                                       Care Assistance Application in Approved Status
 *                                       before showing the Add button unless it's a C-IC
 *                                       or C-PB Stage.  Updated Javadocs.
 *           05/20/05  Todd Reser        Was erroneously comparing Stage to &quot;CIC' and
 *                                       &quot;CPB&quot; instead of StageType to &quot;C-IC&quot; &amp;
 * &quot;C-PB&quot;
 *           05/23/05  Todd Reser        Added CSTGTYPE_COS &quot;C-OS&quot; to if Statement,
 *                                       reversed bNew logic for outputArray.length
 *           07/24/05  werlem            SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *          &lt;p/&gt;
 *           10/04/06  AODUTAYO          Added a new method to check if the taskcode is of type medical/mental
 *                                       assessment. if it is it should display Health Log for the window name
 *                                       without the 'List'. Fixes SIR 449***Wrong defect number.
 *           10/12/06  AODUTAYO          Added a constant value representing the a call from the health log page.
 *                                       The constant is set if and only if the caller value is blank. This value is
 *                                       passed to the method that populates CCMN33SI; used in the retrieve event
 *                                       list process. This fixes SIR 449.
 *           6/17/08   PCOOGAN           Per enhancement STGAP00008568, added code for Safety Resource to allow
 *                                       Add button and hyperlinks to show even though marked as a for case list
 *                                       on the task table. STGAP00010004: added validation code for exchange home search jsp
 *           9/21/08   mchillman         Per enhancement STGAP00010004, added code for Exchange Home to not to show add button if
 *                                       any item is a inproc status and set in to view mode
 *           9/21/08   vdevarak          STGAP00010004: Added check to hide the ADD button on the Exchange Child Registration List
 *                                       page if there is an existing Exchange Child Registration event record in PROC status.
 *                                       
 *           10/8/08   charden           STGAP00005759 - Do not display copy button if event list is service 
 *                                       Authorization list page or service auth for case list page
 *                                       
 *           10/13/08  charden           STGAP00010016 - (not a part of this defect but came across while in the application, so fixed with
 *                                       with this defect) added null check to reasonStageClosed to get rid of null pointer exception
 *           10/31/08  mchillman         STGAP00010898 Added code for ADO Sealing
 *           
 *           11/01/08  mchillman         STGAP00010868 show add button for exchange home for SAU users only even if they do not stage access
 *           12/04/08  arege             STGAP00009163 Added Task Code for HEALTH_LOG Tasks in the DIV stage.This will display the 
 *                                       correct event list for  Health Log in DIV stage.
 *                                       
 *           1/5/09    charden           STGAP00010157 - do not display update button for family plan if the user does not have stage access
 *           
 *           01/06/09  mchillman         STGAP00011789 STGAP00011791  allow SAU users to add and modify corrective action plans and policy
 *                                       volations
 *           01/14/09  mchillman         STGAP00011741 - have add button avialable for re-evaluation when sealed
 *           02/25/09  arege             STGAP00012636 - Added Task Code for Service Authorization and Service Auth for Case Tasks in the FAD stage.
 *                                       This will display the correct event list for Service Authorization and Service Auth for Case in FAD stage.
 *           03/26/09  arege             STGAP00011634 Modified code so that all users cannot view the Sensitive case events through the ViewPerson Events
 *                                       on the Person Detail Page.
 *           
 *           03/25/09  bgehlot           STGAP00012833 - Added code to not show Add button when the user does not have proper security attribute to 
 *                                       modify Case Review page
 *           05/20/09  bgehlot           STGAP00013779: SAU_STAFF should not see Add button as they can only view the Agreement. Removed code where
 *                                       SAU_STAFF can modify agreement and can see Add button when not having stage access
 *           07/22/09  bgehlot           STGAP00014341 - Added code to allow user to modify Stage Reopen page
 *           07/28/09  hjbaptiste        STGAP00014922 - In order for SAU_SUBSIDY workers to be to add an Adoption Assistance Application, checking to see
 *                                       if user has both SEC_ADOPT_ASSIST_SPEC and SEC_ADO_VIEW attributes     
 *           10/03/09  hjbaptiste        STGAP00015485 - Added isSafetyAssessment() and isSafetyPlan(). Setting the error message MSG_UNKNOWN_MBR_HH_NO_ADD
 *                                       if it is unknown that any of the principals are a member of the primary caretaker's household.  
 *           12/05/09  bgehlot           41275 MR-057 APPLA changes
 *           12/30/09  mchillman          Change to support bring up ado application list for Ado 510 - 512 service codes from ser aut detail page
 *           01/26/2010 arege            Added Children First Referral Task codes and functionality not to restrict CFR events created in a particular stage.
 *           02/08/2010 arege            STGAP00015749: Added task code for Children 1st Referral for DIV stage
 *           02/15/2010 arege            SMS#45504 If the Stage is closed and the event of type CFR do not show ADD button
 *           02/09/2010 wjcochran        SMS #44832 - Prevent user from adding safety assessment if "Member of 
 *                                       Primary Caretaker's Household" field is blank for any principals.
 *           02/13/2010 hjbaptiste       SMS#XXXX: Added task code for Contact Standards for FSU(FCF) and FPR(ONG) stages
 *           02/20/2010 arege            Added task code for CNS events in INT, INV, ONG, FCC,ADO and PFC  stages
 *           02/28/2010 swroberts        Added postEvent to delete_xa to support MR-062.
 *           03/04/2010 wjcochran        MR-062: Added code to allow the deletion of Contact Standards in COMP status
 *           03/08/2010 mchillman        45631 check to see if the page is being forward from the next/previous button action
 *           03/08/2010 bgehlot          MR-062: Show the FTM message for Copy button also.
 *           03/24/2010 arege            SMS#48651: Added code so that the event list displays all CFR events in the case only for the child and not all children in the case.
 *           03/28/2010 arege            Added code so that CNS eventlist displays events for the PC only in the ADO,FCC and PFC stages of that PC.
 *           03/29/2010 arege            SMS#48653 set person name into GlobalData so that the correct person name is displayed on Children First Referral page
 *           05/19/2010 arege            SMS#52234 and SMS#52235 implemented sealing rules for Corrective Action Plan, Policy Violation , Contact, Re-evaluation and 
 *                                       Home conversion events.
 *           05/21/2010 arege            SMS#54780: Modified code to allow Copying of APRV CNS events only.
 *           06/01/2010 arege            SMS#52234: SAU_SEALED users should not be able to add Policy Violations, Corrective Action Plans, Contacts or Re-Evaluations
 *                                       unless assigned to the stage.
 *           08/19/2010 wjcochran        SMS#48475: Users without the SAU SEALED attribute should not be able to view Exchange Home
 *                                       Detail Events. Added a variable, EXCHANGE_HOME_DETAIL, for use in the JSP to filter these
 *                                       events and remove the links.
 *           
 * </pre>
 */
@SuppressWarnings("serial")
public class EventSearchConversation extends BaseHiddenFieldStateConversation {

  private static final String TRACE_TAG = "EventSearchBaseConversation";
  
  private static final String DELETE = ServiceConstants.REQ_FUNC_CD_DELETE;

  private static final String DISPLAY_PAGE = "/person/PersonList/displayPersonList";

  private static final String PAGE_MODE_SELECT = "S";

  public static final String CONVERSATION_URL = "/workload/EventSearch/";

  // conversation URLS
  public static final String ADD_EVENT = getUrl("addEventDetail");

  public static final String EVENT_LIST = getUrl("displayEventList");

  public static final String EVENT_SEARCH = getUrl("displayEventSearch");

  public static final String FORWARD_TO = getUrl("forwardTo");

  public static final String NEW_USING_EVENT = getUrl("newUsingEventDetail");
  
  public static final String DELETE_EVENT = getUrl("deleteEvent");

  public static final String CONTINUE_EVENT = getUrl("continueEventDetail");

  public static final String PERSON_LIST = getUrl("displayPersonList");

  public static final String STAFF_LIST = getUrl("displayStaffList");

  public static final String VIEW_EVENT = getUrl("displayEventDetail");

  public static final String DUMMY_EVENT_DETAIL = getUrl("DummyEventDetail");

  public static final String EVENT_SEARCH_STUB = getUrl("EventSearchStub");

  public static final String EDIT_EVENT = getUrl("editEventDetail");

  // external URLS
  public static final String URL_PERSON_LIST = DISPLAY_PAGE;

  public static final String URL_DISPLAY_APPROVAL_STATUS = "/workload/ApprovalStatus/displayStatus";

  // other public constants
  public static final String CALLER = "EVENT_LIST_CALLER";

  public static final String CALLER_PERSON_DETAIL = "CALLER_PERSON_DETAIL";

  public static final String CALLER_EVENT_SEARCH = "CALLER_EVENT_SEARCH";

  public static final String CALLER_TODO = "CALLER_TODO";

  public static final String CALLER_HEALTH_LOG = "CALLER_HEALTH_LOG";
  
  public static final String CALLER_CHILDREN_FIRST = "CALLER_CHILDREN_FIRST";
  
  public static final String CALLER_CDNFSI = "CALLER_CDNFSI";

  public static final String EVENT_HISTORY = "ccm02o00";
  
  private static final String PRINCIPAL = CodesTables.CPRSNALL_PRN;

  // SIR15547
  public static final String EVENT_LIST_ON_EVENT_SEARCH = "ccm02o01";

  public static final String SYSTEM_CREATED = "System";

  public static final String ID_CLOSURE_EVENT = "stageClosureIdEvent";

  // request attributes
  protected static final String PERSON_LIST_PULLBACK_INFO = PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME;

  protected static final String EVENT_LIST_WINDOW_STATE = "EventListWindowStateDB";

  protected static final String EVENTS = "EventDB";

  protected static final String EVENT_SEARCH_DB = "EventSearchDB";

  // other protected constants
  protected static final String OUTPUT_LAUNCH_WINDOW = "CSUB09C";

  protected static final String CLOSED_TO_MERGE = "97";

  protected static final int EVENT_LIST_RESULTS_PER_PAGE = 20;

  // -- individual task codes
  public static final String POLICY_WAIVER_INV = "2320";

  public static final String POLICY_WAIVER_FPR = "7815";

  public static final String POLICY_WAIVER_FAD = "8265";

  public static final String POLICY_WAIVER_DIV = "2235";

  public static final String POLICY_WAIVER_FSU = "7310";

  public static final String POLICY_WAIVER_ADO = "9870";

  public static final String POLICY_WAIVER_SUB = "3235";

  public static final String POLICY_WAIVER_PFC = "7916";

  public static final String FCE_ELIG_SUMMARY = "3120";

  public static final String FCE_ELIG_APPLICATION = "3430";

  public static final String FCE_ELIG_REVIEW = "3440";

  public static final String PLACEMENT1_SUB = "3080";

  public static final String PLACEMENT2_SUB = "3090";

  public static final String PLACEMENT1_ADO = "8590";

  public static final String PLACEMENT2_ADO = "8600";

  public static final String PLACEMENT1_PAD = "9080";

  public static final String PLACEMENT2_PAD = "9090";

  public static final String PLACEMENT1_PFC = "9085";

  public static final String PLACEMENT2_PFC = "9086";

  public static final String VISITATION_PLAN_ADO_ENGLISH = "8690";

  public static final String VISITATION_PLAN_ADO_SPANISH = "8700";

  public static final String VISITATION_PLAN_FPR_ENGLISH = "7250";

  public static final String VISITATION_PLAN_FPR_SPANISH = "7260";

  public static final String VISITATION_PLAN_FSU_ENGLISH = "4390";

  public static final String VISITATION_PLAN_FSU_SPANISH = "4400";

  public static final String VISITATION_PLAN_SUB_ENGLISH = "3190";

  public static final String VISITATION_PLAN_SUB_SPANISH = "3200";

  public static final String VISITATION_PLAN_FOR_CASE_SUB = "3195";

  public static final String VISITATION_PLAN_FOR_CASE_ADO = "8695";

  public static final String CHILD_PLAN_TASK_CODE = "3160";

  public static final String LEGAL_STATUS_INV = "2375";

  public static final String LEGAL_STATUS_SUB = "3050";

  public static final String LEGAL_STATUS_FSU = "4370";

  public static final String LEGAL_STATUS_FPR = "7230";

  public static final String LEGAL_STATUS_ADO = "8560";

  public static final String LEGAL_STATUS_PAD = "9050";

  public static final String LEGAL_STATUS_PFC = "2040";
  
  public static final String SAFETY_ASSMNT_INV = "2285";
  
  public static final String SAFETY_ASSMNT_ONG = "7340";
  
  public static final String SAFETY_PLAN_INV = "2275";
  
  public static final String SAFETY_PLAN_ONG = "7330";

  public static final String SVC_AUTH_FAD = "9040"; //STGAP00012636 Added per MR- 037

  public static final String SVC_AUTH_FSU = "4190";

  public static final String SVC_AUTH_FPR = "7100";

  public static final String SVC_AUTH_ADO = "8530";

  public static final String SVC_AUTH_PAD = "9020";

  public static final String SVC_AUTH_DIV = "6000";

  public static final String SVC_AUTH_PFC = "2010";

  public static final String SVC_AUTH_INV = "2310";
  
  public static final String SVC_AUTH_SUB = "3020";
    
  public static final String ELIG_SUMMARY_ADO = "8620";
  
  public static final String ELIG_SUMMARY_PAD = "9110";
  
  public static final String EXCHANGE_CHILD_REG = "9530";
  
  public static final String EXCHANGE_HOME_DETAIL = "8085";
  
  public static final String CASE_REVIEW_INT = "9880";
  
  public static final String CASE_REVIEW_INV = "9890";
  
  public static final String CASE_REVIEW_SUB = "9910";
  
  public static final String CASE_REVIEW_ADO = "9920";
  
  public static final String CASE_REVIEW_FPR = "9940";
  
  public static final String CASE_REVIEW_DIV = "9930";
  
  public static final String SUB_TASK_CODE = "9944";
  public static final String FSU_TASK_CODE = "9943";
  public static final String ADO_TASK_CODE = "9941";
  public static final String PAD_TASK_CODE = "9945";
  public static final String FPR_TASK_CODE = "9942";
  public static final String DIV_TASK_CODE = "9947";
  public static final String PFC_TASK_CODE = "9946";
  
  public static final String REQ_FUNC_CD_CHILDREN_FIRST_ADD = "CFR";
  
  public static final String REQ_FUNC_CD_CDNFSI_ADD = "CNS";


  // -- task code groups
  private static final Set<String> FAMILY_PLAN_TASK_CODES = new HashSet<String>() {
    {
      add("7065"); // -- Foster Care Case Plan Family, FSU (FCF)
      add("7080"); // -- Family Plan, FPR (ONG)
    }
  };

  // -- Previously individual Strings titled LEGAL_STATUS_TASK - the valid task codes were grouped here
  private static final Set<String> LEGAL_STATUS_TASK_CODES = new HashSet<String>() {
    {
      add(LEGAL_STATUS_INV); // -- Legal Status, INV
      add(LEGAL_STATUS_SUB); // -- Legal Status, SUB
      add(LEGAL_STATUS_FSU); // -- Legal Status, FSU
      add(LEGAL_STATUS_FPR); // -- Legal Status, FPR
      add(LEGAL_STATUS_ADO); // -- Legal Status, ADO
      add(LEGAL_STATUS_PAD); // -- Legal Status, PAD
      add(LEGAL_STATUS_PFC);
    }
  };

  // -- Previously individual Strings titled HEALTH_LOG_TASK - the valid task codes were grouped here
  private static final Set<String> MED_ASSMT_TASK_CODES = new HashSet<String>() {
    {
      add("2280"); // -- Medical/Mental Assessment, INV
      add("3240"); // -- Approve Foster Care Child Stage Closure, SUB
      add("4200"); // -- Medical/Mental Assessment, FSU
      add("7125"); // -- Medical/Mental Assessment, FPR
      add("8190"); // -- Medical/Mental Assessment, FAD
      add("8740"); // -- Medical/Mental Assessment, ADO
      add("9230"); // -- Medical/Mental Assessment, PAD
      add("8195"); // -- Medical/Mental Assessment, DIV // Added per STGAP00009163
    }
  };
  
  private static final Set<String> CHILD_FIRST_REF_TASK_CODES = new HashSet<String>() {
    {
      add("5100"); // -- Children First Referral task code in INV
      add("5200"); // -- Children First Referral task code in FPR
      add("5300"); // -- Children First Referral task code in SUB
      add("5400"); // -- Children First Referral task code in ADO
      add("5500"); // -- Children First Referral task code in PFC
      add("5600"); // -- Children First Referral task code in FSU
      add("5700"); // -- Children First Referral task code in PAD
      add("5800"); // -- Children First Referral task code in DIV
    }
  };
  
  private static final Set<String> CD_NF_SI_TASK_CODES = new HashSet<String>() {
    {
      add("6110"); // -- Child Death/Near Fatality / Serious Injury task code in INT
      add("6220"); // -- Child Death/Near Fatality / Serious Injury task code in INV
      add("6330"); // -- Child Death/Near Fatality / Serious Injury task code in FPR
      add("6440"); // -- Child Death/Near Fatality / Serious Injury task code in SUB
      add("6550"); // -- Child Death/Near Fatality / Serious Injury task code in ADO
      add("6660"); // -- Child Death/Near Fatality / Serious Injury task code in PFC    
    }
  };

  private static final Set<String> PLACEMENT_CASE_TASK_CODES = new HashSet<String>() {
    {
      add(PLACEMENT2_SUB); // -- Placements for Case, SUB
      add(PLACEMENT2_ADO); // -- Placements for Case, ADO
      add(PLACEMENT2_PAD); // -- Placements for Case, PAD
      add(PLACEMENT2_PFC);
    }
  };
  
  private static final Set<String> POLICY_WAIVER_TASK_CODES = new HashSet<String>() {
    {
      add(POLICY_WAIVER_INV); // -- Policy Waivers for INV
      add(POLICY_WAIVER_FPR); // -- Policy Waivers for  FPR
      add(POLICY_WAIVER_FAD ); // -- Policy Waivers for  FAD
      add(POLICY_WAIVER_DIV ); // -- Policy Waivers for  DIV
      add(POLICY_WAIVER_FSU  ); // -- Policy Waivers for  FSU
      add(POLICY_WAIVER_ADO  ); // -- Policy Waivers for  ADO
      add(POLICY_WAIVER_SUB  ); // -- Policy Waivers for  SUB
    }
  };

  //-- task code groups
  private static final Set<String> CONTACT_STANDARDS_TASK_CODES = new HashSet<String>() {
    {
      add("6540"); // -- Contact Standards, FSU (FCF)
      add("7025"); // -- Contact Standards, FPR (ONG)
    }
  };
  
  // -- Previously individual Strings titled SERVICE_AUTH_TASK
  //STGAP00005759 - changed PFC task code to 2000, it was previously incorrectly set to 2010
  private static final Set<String> SVC_AUTH_TASK_CODES = new HashSet<String>() {
    {
      add("2310"); // -- Service Authorization, INV
      add("3020"); // -- Service Authorization, SUB
      add("4190"); // -- Service Authorization, FSU
      add("7100"); // -- Service Authorization, FPR
      add("8530"); // -- Service Authorization, ADO
      add("9020"); // -- Service Authorization, PAD
      add("6000"); // -- Service Authorization, DIV
      add("2000"); // -- Service Authorization, PFC
      add("9040"); // -- Service Authorization, FAD //STGAP00012636 Added per MR- 037
    }
  };
  
  //STGAP00005759 - created set of "service auth for case" task codes
  private static final Set<String> SVC_AUTH_TASK_CASE_CODES = new HashSet<String>() {
    {
      add("2315"); // -- Service Authorization, INV
      add("3025"); // -- Service Authorization, SUB
      add("4195"); // -- Service Authorization, FSU
      add("7110"); // -- Service Authorization, FPR
      add("8535"); // -- Service Authorization, ADO
      add("9030"); // -- Service Authorization, PAD
      add("2010"); // -- Service Authorization, PFC
      add("9041"); // -- Service Authorization, FAD //STGAP00012636 Added per MR- 037
    }
  };

  private static final Set<String> PLCMT_CODES = new HashSet<String>() {
    {
      //excluded PAD codes as waivers are not applicable to them
      add(PLACEMENT1_SUB); // -- Placement, SUB
      add(PLACEMENT2_SUB); // -- Placement for Case, SUB
      add(PLACEMENT1_ADO); // -- Placement, ADO
      add(PLACEMENT2_ADO); // -- Placement for Case, ADO
      add(PLACEMENT1_PAD); // -- Placement, PAD
      add(PLACEMENT2_PAD); // -- Placement for Case, PAD
      add(PLACEMENT1_PFC); // -- Placement, PFC
      add(PLACEMENT2_PFC); // -- Placement for Case, PFC
    }
  };

  private static final Set<String> VISITATION_PLAN_TASK_CODES = new HashSet<String>() {
    {
      add(VISITATION_PLAN_ADO_ENGLISH);
      add(VISITATION_PLAN_ADO_SPANISH);
      add(VISITATION_PLAN_FPR_ENGLISH);
      add(VISITATION_PLAN_FPR_SPANISH);
      add(VISITATION_PLAN_FSU_ENGLISH);
      add(VISITATION_PLAN_FSU_SPANISH);
      add(VISITATION_PLAN_SUB_ENGLISH);
      add(VISITATION_PLAN_SUB_SPANISH);
      add(VISITATION_PLAN_FOR_CASE_SUB);
      add(VISITATION_PLAN_FOR_CASE_ADO);
    }
  };

  // -- case task code conversion
  private static final Map<String, String> CASE_TASK_CODE_CONVERSION = new HashMap<String, String>() {
    {
      // put("2155", "2145"); invalid
      put("2365", "2355");
      put("2385", LEGAL_STATUS_INV);
      put("3040", "3030");
      put("3060", LEGAL_STATUS_SUB);
      put(PLACEMENT2_SUB, PLACEMENT1_SUB);
      put("3170", CHILD_PLAN_TASK_CODE);
      put("4360", "4350");
      put("4380", LEGAL_STATUS_FSU);
      // put("5860", "5850"); invalid
      // put("5880", "5870"); invalid
      // put("6140", "6130"); invalid
      put("7220", "7210");
      put("7240", LEGAL_STATUS_FPR);
      put("8550", "8540");
      put("8570", LEGAL_STATUS_ADO);
      put(PLACEMENT2_ADO, "8590");
      put("8670", "8660");
      put("9995", "9520");
      put("9060", LEGAL_STATUS_PAD);
      put(PLACEMENT2_PAD, PLACEMENT1_PAD);
      put(PLACEMENT2_PFC, PLACEMENT1_PFC);
      put("2315", "2310");
      put("7110", "7100");
      put("8535", "8530");
      put("4195", "4190");
      put("9030", "9020");
      put("2010", "2000");
      put("3025", "3020");
      put("8695", "8690");
      put("3195", "3190");
      put("9511", "9510");
      put("9505", "9500");
      put("8585", "8580");
    }
  };

  private static final Set<String> EXCHANGE_CHILD_TASK_CODES = new HashSet<String>() {
    {
      add("9530"); // -- Exchange Child, ADO
      add("9531"); // -- Exchange Child, PAD
    }
  };
  
  private static final Set<String> ADOPTION_ASSIT_AGREE_TASK_CODES = new HashSet<String>() {
    {
      add("9115"); // ADO
      add("9105"); // PAD
    }
  };

  private static final Set<String> ADOPTION_ASSIT_APPL_TASK_CODES = new HashSet<String>() {
    {
      add("8610"); // ADO
      add("9100"); // PAD
    }
  };  
  
  private static final Set<String> NON_COMPLIANCE_TASK_CODES = new HashSet<String>() {
    {
      add("8091"); // PV
      add("8092"); // CV
    }
  };  
  
  // -- event types
  protected static final String APPROVAL_EVENT_TYPE = CodesTables.CEVNTTYP_APP;

  // event status values
  protected static final String APPROVED = CodesTables.CEVTSTAT_APRV;

  protected static final String COMPLETE = CodesTables.CEVTSTAT_COMP;

  protected static final String NEW = CodesTables.CEVTSTAT_NEW;

  protected static final String PENDING = CodesTables.CEVTSTAT_PEND;

  protected static final String PROCESS = CodesTables.CEVTSTAT_PROC;

  protected static final int VALUE_APPROVAL = 4;

  protected static final int VALUE_COMPLETE = 2;

  protected static final int VALUE_OTHER = 0;

  protected static final int VALUE_PENDING = 3;

  protected static final int VALUE_PROCESS = 1;

  protected static final HashSet<String> invalidationTasks = new HashSet<String>();

  // -- TODO: temporary message
  private static final String MSG_CP_COPY_COMP = "Only completed plans can be copied.";

  private Admin admin = null;
  
  private Assessment assessment = null;
  
  private Fce fce = null;
  
  private CaseMgmt caseMgmt= null;

  private Cfp cfp = null;

  private EventUtility eventUtility = null;

  private Person person = null;

  private Financials financials = null;

  private AdoExchange adoExchange;
  
  private Common common = null;

  private PostEvent postEvent = null;
  
  public void setAdoExchange(AdoExchange adoExchange) {
    this.adoExchange = adoExchange;
  }
  
  // initialize admin
  public void setAdmin(Admin objAdmin) {
    this.admin = objAdmin;
  }
  
  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
  }
  
  public void setFce(Fce fce) {
    this.fce = fce;
  }
  
  public void setCfp(Cfp cfp) {
	  this.cfp = cfp;
  }

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  public void setEventUtility(EventUtility eventUtility) {
    this.eventUtility = eventUtility;
  }

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }
  
  
  // Statically initialize invalidationTasks HashSet
  static {
    invalidationTasks.add(FCE_ELIG_SUMMARY);
    invalidationTasks.add(FCE_ELIG_APPLICATION);
    invalidationTasks.add(FCE_ELIG_REVIEW);
  }

  /**
   * Appends pageName to CONVERSATION_URL
   *
   * @param pageName String
   * @return CONVERSATION_URL + pagename
   */
  protected static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }

  /**
   * Delegates to the other getEventDetailPageMode with data from global data
   *
   * @param request HttpServletRequest
   * @return getEventDetailPageMode
   */
  public static String getEventDetailPageMode(HttpServletRequest request) {
    int eventId = GlobalData.getUlIdEvent(request);
    int stageId = GlobalData.getUlIdStage(request);
    String taskCode = GlobalData.getSzCdTask(request);

    return getEventDetailPageMode(request, eventId, stageId, taskCode);
  }

  /**
   * Usually, just called with data from global data; However, Review Intake/Investigation are looking at events in a
   * different stage id
   *
   * @param request  HttpServletRequest
   * @param eventId  int
   * @param stageId  int
   * @param taskCode String
   * @return PageMode
   */
  public static String getEventDetailPageMode(HttpServletRequest request, int eventId, int stageId, String taskCode) {
    // Get page mode as has been set previously
    String mode = PageMode.getPageMode(request);
    GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode; pageMode was " + mode);

    // if the page mode is something other than EDIT or VIEW; return that
    // This is particularly important for pages such as LegalStatus which have
    // values like 'P'; this also handles the case of NEW/NewUsing
    if ((mode.equals(PageModeConstants.EDIT) == false) && (mode.equals(PageModeConstants.VIEW) == false)) {
      GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode: pageMode is neither EDIT or VIEW: '" + mode + "'");
      return mode;
    }

    String eventStatus = CaseUtility.getSzCdEventStatus(eventId);
    GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode; eventId = " + eventId);
    GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode; eventStatus = " + eventStatus);

    stageId = GlobalData.getUlIdStage(request) != 0 ? GlobalData.getUlIdStage(request) : stageId;
    CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);
    GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode; stageId = " + stageId);
    GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode; taskCode = " + taskCode);

    if (canModifyEvent(request, stage, taskCode, eventStatus)) {

      // If the event status is new (the event was created by to do)
      if ((NEW.equals(eventStatus)) ||
          // below added 7/14/2003 by mcclaim
          (eventId == 0)) {
        GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode: pageMode is New");
        return PageModeConstants.NEW;
      }

      GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode: pageMode is EDIT");
      return PageModeConstants.EDIT;
    }

    GrndsTrace.msg(TRACE_TAG, 7, "getEventDetailPageMode: pageMode is VIEW");
    return PageModeConstants.VIEW;
  }

  /**
   * Returns true if one of the following is true: . stage is open and user has access to the stage and eventStatusCode
   * != APPROVED return true . stage is closed and taskCode is LegalStatus and user has LegalStatus Security . stage is
   * closed and taskCode is ServiceAuthorization and user has ServiceAuth Security
   *
   * @param request         HttpServletRequest
   * @param stage           CaseUtility.Stage
   * @param taskCode        String
   * @param eventStatusCode String
   * @return boolean
   */
  protected static boolean canModifyEvent(HttpServletRequest request, CaseUtility.Stage stage, String taskCode,
                                          String eventStatusCode) {
    //If the event detail is being accessed from the policy waiver pullback via the event type hyperlink the 
    //detail page should be in view only mode. SIR - STGAP00004356 
    String reqPullBack = ContextHelper.getStringSafe(request, "hdnReqPullBack");
    if ("true".equals(reqPullBack) && POLICY_WAIVER_TASK_CODES.contains(taskCode)){
      return false;
    }
    
    //If the event detail is being accessed from the adoption assistance a pullback via the event type hyperlink the 
    //detail page should be in view only mode
    String reqAdoPullBack = ContextHelper.getStringSafe(request, "hdnAdoPullBack");
    if (ArchitectureConstants.TRUE.equals(reqAdoPullBack) ){
      return false;
    }
    
    // If it's a NEW/NEW_USING event, eventStatusCode is null; it's never ApprovalMode on a NEW event
    boolean isApprovalMode = ((eventStatusCode != null) && (GlobalData.isApprovalMode(request)));

    if (isApprovalMode) {
      return true;
    }
    UserProfile userProfile = getUserProfile(request);
    // if stage is open
    if (isStageClosed(stage) == false) {
      int stageId = stage.getIdStage();

      //SAU users can edit these exchange up to the time they are marked complete
      if(isExchangeChild(taskCode) && (userProfile.hasRight(UserProfile.SEC_SAU_SEALED) || userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE))
                      && (COMPLETE.equals(eventStatusCode) == false)){
        GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: has SAU Sealed or SAU Staff attribute");
        return true;
      }
      
      if (isExchangeHome(taskCode) && userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE) && (COMPLETE.equals(eventStatusCode) == false)) {
        GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is closed; has  sau right");
        return true;
      }
      
      if (isAdopAssitAgreement(taskCode) && ((userProfile.hasRight(UserProfile.SEC_ADOPT_ASSIST_SPEC) && hasStageAccess(request, stageId)))) {
        return true;
      }
      
      if (isAdoptAssistApplication(taskCode) && ((userProfile.hasRight(UserProfile.SEC_ADOPT_ASSIST_SPEC) && hasStageAccess(request, stageId)) ||
                      userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE))) {
        return true; 
      }
      
      //Policy Violation and Corrective Action Plan events modifiable only for SAU Sealed
      if (isNonCompliance(taskCode) && userProfile.hasRight(UserProfile.SEC_SAU_SEALED) && hasStageAccess(request, stageId)) {
        return true; 
      }
      
      if (isNonCompliance(taskCode) && userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE)&& hasStageAccess(request, stageId)) {
        return true; 
      }
      
      boolean isEventApproved = (APPROVED.equals(eventStatusCode));
      boolean isApprovedEligibility = false;
      String  eventType = getEventType(taskCode);
      // An approved eligibility summary can be modified if it's not end dated
      if (CodesTables.CEVNTTYP_FCD.equals(eventType) && APPROVED.equals(eventStatusCode)) {
        isApprovedEligibility = true;
      }
      if (isApprovedEligibility) {
        // We act as if the event is not approved so that it can be modified
        isEventApproved = false;
      }
      
      //added for exchange home since complete is not editable 
      if(CodesTables.CEVNTTYP_EXH.equals(eventType) && COMPLETE.equals(eventStatusCode)) {
        return false;
      }
      GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is open; hasStageAccess; isEventApproved = "
                                   + isEventApproved + "; isApprovedEligibility = " + isApprovedEligibility);

      return (!isEventApproved);
    }
    
    if (isExchangeHome(taskCode) && userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE) && (COMPLETE.equals(eventStatusCode) == false)) {
      GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is closed; has  sau right");
      return true;
    }
    
    // stage is closed
    if (isLegalStatus(taskCode) && userProfile.hasRight(UserProfile.SEC_MNTN_LEGAL_STAT)) {
      GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is closed; has legal status right");
      return true;
    }
    if (isServiceAuthorization(taskCode) && userProfile.hasRight(UserProfile.SEC_MNTN_SVC_AUTH)) {
      GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is closed; has service authorization right");
      return true;
    }
    
    //STGAP00012833: Added this code so that user can add the case review even if the case is closed.
    if (isCaseReview(taskCode) && userProfile.hasRight(UserProfile.SEC_CASE_REVIEW )) {
      GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is closed;");
      return true;
    }
    
    //STGAP00012833: Added this code so that user can add the case review even if the case is closed.
    if (isStageReopen(taskCode) && userProfile.hasRight(UserProfile.SEC_STAGE_REOPEN )) {
      GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is closed;");
      return true;
    }
    
    GrndsTrace.msg(TRACE_TAG, 7, "canModifyEvent: stage is closed");
    return false;
  }

  /**
   * Returns true if taskCode is of type ServiceAuthorization
   *
   * @param taskCode String
   * @return boolean
   */
  protected static boolean isServiceAuthorization(String taskCode) {
    return SVC_AUTH_TASK_CODES.contains(taskCode);
  }
  
  /**
   * Returns true if taskCode is of type ExchangeChild
   *
   * @param taskCode String
   * @return boolean
   */
  protected static boolean isExchangeChild(String taskCode) {
    return EXCHANGE_CHILD_TASK_CODES.contains(taskCode);
  }
  
  /**
   * Returns true if taskCode is of type AdopAssitAgreement
   *
   * @param taskCode String
   * @return boolean
   */
  protected static boolean isAdopAssitAgreement(String taskCode) {
    return ADOPTION_ASSIT_AGREE_TASK_CODES.contains(taskCode);
  }
  
  
  protected static boolean isAdoptAssistApplication (String taskCode) {
    return ADOPTION_ASSIT_APPL_TASK_CODES.contains(taskCode);
  }
  
  protected static boolean isNonCompliance (String taskCode) {
    return NON_COMPLIANCE_TASK_CODES.contains(taskCode);
  }
  
  /**
   * Returns true if taskCode is of type Contact Standards
   * 
   * @param taskCode String
   *                
   * @return boolean
   */
  protected static boolean isContactStandards(String taskCode) {
    return CONTACT_STANDARDS_TASK_CODES.contains(taskCode);
  }
  
  /**
   * Returns true if taskCode is of type ServiceAuthorizationForCase
   *
   * @param taskCode String
   * @return boolean
   */
  protected static boolean isServiceAuthorizationForCase(String taskCode){
    return SVC_AUTH_TASK_CASE_CODES.contains(taskCode);
  }

  /**
   * Returns true if taskCode is of type Placement excluding PAD Codes
   *
   * @param taskCode String
   * @return boolean
   */
  protected static boolean isPlacement(String taskCode) {
    return PLCMT_CODES.contains(taskCode);
  }

  /**
   * Returns true if taskCode is of type LegalStatus
   *
   * @param taskCode String
   * @return boolean
   */
  protected static boolean isLegalStatus(String taskCode) {
    return LEGAL_STATUS_TASK_CODES.contains(taskCode);
  }
  
  /**
   * Returns true if taskCode is of type Safety Assessment
   *
   * @param taskCode String
   * @return boolean
   */
  private static boolean isSafetyAssessment(String taskCode) {
    if(SAFETY_ASSMNT_INV.equals(taskCode) || SAFETY_ASSMNT_ONG.equals(taskCode)){
       return true;
    }else{
       return false;
    }
  }
  
  /**
   * Returns true if taskCode is of type Safety Plan
   *
   * @param taskCode String
   * @return boolean
   */
  private static boolean isSafetyPlan(String taskCode) {
    if(SAFETY_PLAN_INV.equals(taskCode) || SAFETY_PLAN_ONG.equals(taskCode)){
       return true;
    }else{
       return false;
    }
  }
  
  /**
   * Returns true if taskCode is of type ExchangeHome
   *
   * @param taskCode String
   * @return boolean
   */
  private static boolean isExchangeHome(String taskCode) {
   return "8085".equals(taskCode) ;
  }

  /**
   * Returns true if taskCode is of type Medical Mental Assessment or task event type is MED
   *
   * @param taskCode String
   * @return boolean
   */
  protected static boolean isMedicalMentalAssessment(String taskCode) {
    return MED_ASSMT_TASK_CODES.contains(taskCode);
  }
  
  /**
   * Returns true if taskCode is of type Children 1st Referral or task event type is CFR
   * 
   * @param taskCode String
   *                
   * @return boolean
   */
  protected static boolean isChildrenFirstReferral(String taskCode) {
    return CHILD_FIRST_REF_TASK_CODES.contains(taskCode);
  }
  
  /**
   * Returns true if taskCode is of type CD/NF/SI or task event type is CNS
   * 
   * @param taskCode String
   *                
   * @return boolean
   */
  protected static boolean isCDNFSI(String taskCode) {
    return CD_NF_SI_TASK_CODES.contains(taskCode);
  }
  

  /**
   * Returns true if taskCode is of type CaseReview
   *
   * @param taskCode String
   * @return boolean
   */
  private static boolean isCaseReview(String taskCode) {
    if(CASE_REVIEW_INT.equals(taskCode) || CASE_REVIEW_INV.equals(taskCode) || CASE_REVIEW_SUB.equals(taskCode) ||
       CASE_REVIEW_ADO.equals(taskCode) || CASE_REVIEW_FPR.equals(taskCode) || CASE_REVIEW_DIV.equals(taskCode)){
       return true;
    }else{
       return false;
    }
  }
  
  /**
   * Returns true if taskCode is of type Stage Reopen
   *
   * @param taskCode String
   * @return boolean
   */
  private static boolean isStageReopen(String taskCode) {
    if(SUB_TASK_CODE.equals(taskCode) || FSU_TASK_CODE.equals(taskCode) || ADO_TASK_CODE.equals(taskCode) ||
       PAD_TASK_CODE.equals(taskCode) || FPR_TASK_CODE.equals(taskCode) || DIV_TASK_CODE.equals(taskCode) ||
       PFC_TASK_CODE.equals(taskCode)){
       return true;
    }else{
       return false;
    }
  }

  /**
   * isStageClosed
   *
   * @param stage CaseUtility.Stage
   * @return getIndStageClosed
   */
  protected static boolean isStageClosed(CaseUtility.Stage stage) {
    return isTrue(stage.getIndStageClose());
  }

  /**
   * Wrapper around GlobalData.hasStageAccess() override and CaseUtility.hasStageAccess
   *
   * @param request HttpServletRequest
   * @param stageId int
   * @return boolean
   */
  protected static boolean hasStageAccess(HttpServletRequest request, int stageId) {
    if (GlobalData.hasStageAccess(request)) {
      return true;
    }
    UserProfile userProfile = getUserProfile(request);
    return (CaseUtility.hasStageAccess(userProfile.getUserID(), stageId));
  }

  /**
   * Similar to StringHelper.isTrue, except it handles null and "1"
   *
   * @param string String
   * @return boolean
   */
  protected static boolean isTrue(String string) {
    return ((string != null) && ("Y".equals(string) || "1".equals(string)));
  }

  /**
   * Similar to StringHelper.isFalse, except it handles null and "1"
   *
   * @param string String
   * @return boolean
   */
  protected static boolean isFalse(String string) {
    return (isTrue(string) == false);
  }

  /**
   * Similar to StringHelper.toInteger, except it handles null and returns int
   *
   * @param string String
   * @return Integer
   */
  protected static int stringToInt(String string) {
    if (string == null) {
      return 0;
    }
    return Integer.parseInt(string);
  }

  /**
   * @param name  String
   * @param value String
   * @throws IllegalArgumentException if value is null or empty
   */
  protected static void verify(String name, String value) {
    if ((value == null) || ("".equals(value.trim()))) {
      throw new IllegalStateException("expected value for '" + name + "'");
    }
  }

  /**
   * @param name  String
   * @param value String
   * @throws IllegalArgumentException if value == 0
   */
  protected static void verify(String name, int value) {
    if (value == 0) {
      throw new IllegalStateException("expected value for '" + name + "'");
    }
  }

  /**
   * Scaffolding
   *
   * @param context The GrndsExchangeContext object.
   */
  public void forwardTo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "forwardTo_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      clearState(context);

      int caseId = ContextHelper.getIntSafe(request, "caseId");
      int stageId = ContextHelper.getIntSafe(request, "stageId");

      if ((caseId != 0) || (stageId != 0)) {
        StageDB stageDB = cfp.getStageDB(caseId, stageId);
        GlobalData.setUlIdCase(caseId, request);
        GlobalData.setSzNmCase(stageDB.getCaseName(), request);

        GlobalData.setUlIdStage(stageId, request);
        GlobalData.setSzCdStage(stageDB.getStageCode(), request);
        GlobalData.setSzCdStageProgram(stageDB.getProgramName(), request);
        GlobalData.setSzCdStageType(stageDB.getStageType(), request);
        GlobalData.setSzNmStage(stageDB.getStageName(), request);

        // SIR 23530 - Also set dtStageStart into Global Data
        CaseUtility.Stage stageInfo = CaseUtility.getStage(stageId);
        GlobalData.setDtDtStageStart(stageInfo.getDtStart(), request);
      }

      int todoId = ContextHelper.getIntSafe(request, "todoId");
      GlobalData.setUlIdTodo(todoId, request);
      int eventId = ContextHelper.getIntSafe(request, "eventId");
      GlobalData.setUlIdEvent(eventId, request);

      String taskCode = ContextHelper.getStringSafe(request, "taskCode");
      GlobalData.setSzCdTask(taskCode, request);

      int staffId = ContextHelper.getIntSafe(request, "staffId");
      String staffName = getFullNameForPersonId(staffId);
      int personId = ContextHelper.getIntSafe(request, "personId");
      String personName = getFullNameForPersonId(personId);

      EventSearchDB eventSearchDB = getEventSearchDB(request);
      eventSearchDB.setStaffId(staffId);
      eventSearchDB.setStaffName(staffName);
      eventSearchDB.setPersonId(personId);
      eventSearchDB.setPersonName(personName);
      setEventSearchDB(request, eventSearchDB);

      String hasStageAccessOverride = request.getParameter("hasStageAccess");
      if (hasStageAccessOverride != null) {
        boolean hasStageAccess = "true".equals(hasStageAccessOverride);
        GlobalData.setStageAccess(hasStageAccess, request);
      }

      // note: this is scaffolding, so it's ok
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      String url = ContextHelper.getString(request, "url");
      if ((EVENT_LIST.equals(url)) && (CALLER_PERSON_DETAIL.equals(getCaller(request)) == false)) {
        // note: this is scaffolding, so it's ok
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }

      GrndsTrace.msg(TRACE_TAG, 7, "forwarding request to url: " + url);
      forward(url, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Event Search activity method
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayEventSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayEventSearch_xa");

    HttpServletRequest request = context.getRequest();

    try {
      // because personList_xa mucks with it
      PageMode.setPageMode(PageModeConstants.VIEW, request);

      verify("GlobalData.getUlIdCase", GlobalData.getUlIdCase(request));
      verify("GlobalData.getSzNmCase", GlobalData.getSzNmCase(request));

      String clear = ContextHelper.getStringSafe(request, "clear");
      if ("true".equals(clear)) {
        // write over EventSearchDB settings
        EventSearchDB eventSearchDB = newEventSearchDB(request);
        setEventSearchDB(request, eventSearchDB);
        return;
      }

      EventSearchDB eventSearchDB = getEventSearchDB(request);

      populatePerson(request, eventSearchDB);

      clearState(context);

      setEventSearchDB(request, eventSearchDB);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Event List activity method <p/> You can be in Edit mode even without being in generic list; from workload go to
   * case summary than go to event <p/> Case Summary also goes to generic list for Service Authorization and Legal
   * Status and pageMode doesn't have to be Edit (if stage is closed)
   *
   * @param context The GrndsExchangeContext object.
   */

  public void displayEventList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayEventList_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    BaseSessionStateManager state = getSessionStateManager(context);

    try {

      // EventList doesn't touch AppMode until it passes the request
      // to an event detail page

      EventSearchDB eventSearchDB = getEventSearchDB(request);
      populateCodesAndDates(request, eventSearchDB);

      // it's not safe to clear state until after getEventSearchDB
      // This variable indicates that the request is for a policy Waiver pullback
      // from the Service authorization Header page. In this case we do not want
      // to clear the state.
      String reqPullBack = ContextHelper.getStringSafe(request, "hdnReqPullBack");
      String waiverType = ContextHelper.getStringSafe(request, "hdnWaiverType");
      int idResource = ContextHelper.getIntSafe(request, "hdnIdResource");
      
      clearState(context);
      
      String caller = getCaller(request);

      int caseId = GlobalData.getUlIdCase(request);
      String taskCode = GlobalData.getSzCdTask(request);
      taskCode = taskCode.trim();
      List<String> cdStatus = null;

      int stageId = GlobalData.getUlIdStage(request);
      if ((CALLER_EVENT_SEARCH.equals(caller)) && (eventSearchDB.getSearchEntireCase())) {
        stageId = 0;
      }

      String windowName = "Event List";
      boolean indTaskNuAcrossCase = false;
      if (("".equals(caller)) && ("".equals(taskCode) == false)) {
        windowName = decodeTask(taskCode);

        if (isVisitationPlan(taskCode)) {
          windowName = "Visitation Plan";
        }
        
        if (isCDNFSI(taskCode)){
          windowName = "Child Death/Near Fatality/Serious Injury Report";
        }

        // Add the word lits to the name of all event lists
        windowName += " List";

        // if and only if it is medical mental assessment list
        // then change window name
        if (isMedicalMentalAssessment(taskCode)) {
          windowName = "Health Log ";
          if (caller.trim().length() == 0) {
            caller = CALLER_HEALTH_LOG;
          }
        }
        
        if(isChildrenFirstReferral(taskCode)){
        if (caller.trim().length() == 0) {
          caller = CALLER_CHILDREN_FIRST;
        }
      }
       
        if(isCDNFSI(taskCode)){
          if (caller.trim().length() == 0) {
            caller = CALLER_CDNFSI;
          }
        }
        
        // WCD_cIndTaskNuAcrossCase == Task.IND_TASK_NU_ACROSS_CASE
        // For instance "Legal Status for Case" really is more than 1 task type,
        // so taskCode, stageCode, stageId is not set on ccmn33si
        indTaskNuAcrossCase = getIndTaskNuAcrossCase(taskCode);
      }
      // This is to accomodate the Service Authorization Header page's requirement
      // to access the Policy Waiver List page as a pull back.
      // Begin
      // STGAP00012636 Added one more elseif condition to accomodate Service Authorization Header page's requirement
      // to access the Policy Waiver List page as a pull back in FAD stage.

      if ("true".equals(reqPullBack)) {
        if (SVC_AUTH_INV.equals(taskCode)) {
          taskCode = POLICY_WAIVER_INV;
        } else if (SVC_AUTH_FAD.equals(taskCode)) {     //Per STGAP00012636
          taskCode = POLICY_WAIVER_FAD;
        } else if (SVC_AUTH_FSU.equals(taskCode)) {
          taskCode = POLICY_WAIVER_FSU;
        } else if (SVC_AUTH_FPR.equals(taskCode)) {
          taskCode = POLICY_WAIVER_FPR;
        } else if (SVC_AUTH_DIV.equals(taskCode)) {
          taskCode = POLICY_WAIVER_DIV;
        } else if (SVC_AUTH_SUB.equals(taskCode) || ((PLACEMENT2_SUB.equals(taskCode) || PLACEMENT1_SUB.equals(
                taskCode)) && waiverType.equals("C"))) {
          taskCode = POLICY_WAIVER_SUB;
        } else if (SVC_AUTH_ADO.equals(taskCode) || ((PLACEMENT2_ADO.equals(taskCode) || PLACEMENT1_ADO.equals(
                taskCode)) && waiverType.equals("C"))) {
          taskCode = POLICY_WAIVER_ADO;
        } else if (SVC_AUTH_PFC.equals(taskCode) || ((PLACEMENT1_PFC.equals(taskCode) || PLACEMENT2_PFC.equals(
                taskCode)) && waiverType.equals("C"))) {
          taskCode = POLICY_WAIVER_PFC;
        } else if ((PLACEMENT2_ADO.equals(taskCode) || PLACEMENT1_ADO.equals(taskCode)
                    || PLACEMENT1_PFC.equals(taskCode) || PLACEMENT2_PFC.equals(taskCode)
                    || PLACEMENT1_SUB.equals(taskCode) || PLACEMENT2_SUB.equals(taskCode))
                   && waiverType.equals("H")) {
          FadHomeRetrieveSO fadHomeRetSO = caseMgmt.retrieveFadHome(idResource);
          stageId = fadHomeRetSO.getUlIdStage();
          caseId = fadHomeRetSO.getUlIdCase();
          taskCode = POLICY_WAIVER_FAD;
          
        }

        windowName = "Policy Waiver List Pullback";
      }
      
      //If this a pullback from the Adoption Assistance Agreement page set the task code
      //event status to pull and then set the page title and pullback attribute 
      //for the page
      boolean bAdoptionAssistanceAgreementPullback = false;

      // End
      Screen screen = ScreenMapping.getScreenData(context);
      setEventListScreenData(screen, caseId, stageId, windowName);
      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      pagination.getResultDetails().setResultsPerPage(EVENT_LIST_RESULTS_PER_PAGE);
      CCMN33SI ccmn33si = getCCMN33SI(caseId, stageId, GlobalData.getUlIdPerson(request), taskCode,
                                      indTaskNuAcrossCase, caller, getUserLogonID(request), cdStatus,eventSearchDB);     
      
      if(bAdoptionAssistanceAgreementPullback ) {
        ccmn33si.setBIndAdoptionAssitPB(ArchitectureConstants.Y);
        ccmn33si.setBIndSrvAuthAdoptionAssitPB(ArchitectureConstants.N);
      }

      
      // STGAP00011634 Set bIndUserSensitive in the ccmnsi object, which is used in Retrieve
      // EventList service.
      UserProfile user = getUserProfile(request);
      
      if(user.hasRight(UserProfile.SEC_SENSITIVE_CASE_ACCESS)){
      ccmn33si.setBIndUserSensitive(ArchitectureConstants.Y); 
      } else {
        ccmn33si.setBIndUserSensitive(ArchitectureConstants.N);
      }
      
      // STGAP00011107: if retrieving events at Case level, and if the user does not have SAU Sealed attribute
      // eliminate any event that is associated with a sealed stage from the result set(This will not apply to
      // the FAD stages)
      if (ccmn33si.getUlIdStage()==0) {
         user = getUserProfile(request);
        if (user.hasRight(UserProfile.SEC_SAU_SEALED)) {
          ccmn33si.setBIndUserSealed(ArchitectureConstants.Y);
        } else {
          ccmn33si.setBIndUserSealed(ArchitectureConstants.N);
        }
      }
      CCMN33SO ccmn33so = executeEventListService(ccmn33si, pagination, admin);

      ROWCCMN33SO[] outputArray = ccmn33so.getROWCCMN33SO_ARRAY().getROWCCMN33SO();

      if (isTrue(ccmn33so.getBIndFilteredSensitiveEvents())) {
        setInformationalMessage(Messages.MSG_CMN_SENSITIVE_EVENTS, EVENT_LIST, request);
      }

      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn33so.getBMoreDataInd());
      ccmn33so.setArchOutputStruct(archOutputStruct);

      pagination.setPaginationInformation(ccmn33so.getArchOutputStruct(), outputArray.length);

      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, pagination);

      storePaginationBeanToRequest(context, pagination);

      if (outputArray.length == 0) {
        if (CALLER_EVENT_SEARCH.equals(caller)) {
          setEventSearchDB(request, eventSearchDB);

          setErrorMessage(Messages.MSG_CMN_NO_EVENT_FOUND, EVENT_SEARCH, request);

          forward(EVENT_SEARCH, request, response);
          return;
        }
      }

      // String taskDecode = ccmn33so.getSzTxtTaskDecode();
      //STGAP00010016 - added null check to reasonStageClosed to get rid of null pointer exception
      String reasonStageClosed = ccmn33so.getSzCdStageReasonClosed() != null ? ccmn33so.getSzCdStageReasonClosed() : "";
      boolean stageClosed = (ccmn33so.getDtDtStageClose() != null);

      EventDB[] events = toEventArray(outputArray);
      if (caller.equals(CALLER_TODO)) {
        markSubmittedEvents(events, GlobalData.getUlIdTodo(request),
                            GlobalData.getUlIdEvent(request), getUserLogonID(request));
      }
      // clear event id; so navigation works correctly for fce
      GlobalData.setUlIdEvent(0, request);

      EventListWindowStateDB eventListWindowState =
              eventListSetWindowState(events, getUserProfile(request), taskCode, caseId, stageId, indTaskNuAcrossCase,
                                      hasStageAccess(request, stageId), stageClosed, reasonStageClosed, caller,
                                      ContextHelper.getBooleanSafe(request, "hdnOutProc"),
                                      GlobalData.isStageClosureBeingApproved(request));

      if (taskCode.equals(FCE_ELIG_SUMMARY)) {
        // Eligibility Summary List: No Add button show
        eventListWindowState.setNewEnabled(false);
      }
      // Risk ReAssessment List: No Add button show
      if (RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE.equals(taskCode)) {
        eventListWindowState.setNewEnabled(false);
      }

      int closureEvent = 0;
      if (invalidationTasks.contains(taskCode)) {
        closureEvent = CaseUtility.getPendingStageClosureEvent(stageId);
      }
      request.setAttribute(ID_CLOSURE_EVENT, closureEvent);

      request.setAttribute(EVENTS, events);
      request.setAttribute(EVENT_LIST_WINDOW_STATE, eventListWindowState);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Initialize request to call PersonList Pullback (from EventSearch.jsp)
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayPersonList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayPersonList_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      // don't clear state
      // save checkboxes and dates
      EventSearchDB eventSearchDB = getEventSearchDB(request);
      populateCodesAndDates(request, eventSearchDB);
      setEventSearchDB(request, eventSearchDB);

      PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();

      personListPullBackInfo.setDestinationUrl(EVENT_SEARCH);
      request.setAttribute(PERSON_LIST_PULLBACK_INFO, personListPullBackInfo);

      PageMode.setPageMode(PAGE_MODE_SELECT, request);

      forward(URL_PERSON_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Initialize request to call StaffList Pullback (from EventSearch.jsp)
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayStaffList_xa(GrndsExchangeContext context) {
  }

  /**
   * Initialize request to create a new Event of the current taskCode and call the correct EventDetail window
   *
   * @param context The GrndsExchangeContext object.
   */
  @SuppressWarnings({"unchecked"})
  public void addEventDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "addEventDetail_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      clearState(context);

      int stageId = GlobalData.getUlIdStage(request);
      String taskCode = GlobalData.getSzCdTask(request);

      CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);
      if (canCreateEvent(request, stage, taskCode) == false) {
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, EVENT_LIST, request);

        forward(EVENT_LIST, request, response);
        return;
      }

      // SIR 18571 - Adding FCE events should invalidate pending stage closure.
      // Other event types can invalidate closure by adding task code to HashSet.
      if (invalidationTasks.contains(taskCode)) {
        int stageClosureEventId = ContextHelper.getIntSafe(request, "actionStageClosureEvent");
        if (stageClosureEventId > 0) {
          invalidatePendingClosure(context, stageClosureEventId);
        }
      }

      setAppMode(request, stage);
      PageMode.setPageMode(PageModeConstants.NEW, request);

      if (isLegalStatus(taskCode)) {
        String stageCode0 = ContextHelper.getStringSafe(request, "actionStageCode0");

        if ("".equals(stageCode0) == false) {
          GlobalData.setSzCdStage(stageCode0, request);
        }
      }

      if (isSafetyAssessment(taskCode) || isSafetyPlan(taskCode)) {
        List<Map> unKnownIfMemberOfPKHshld = null;
        List<Map> allPrincipals = null;
        unKnownIfMemberOfPKHshld = person.retrievePRNUnknownIfMmbrOfPKHsehold(stageId, PRINCIPAL);
        allPrincipals = assessment.retrieveAllPrincipals(stageId, PRINCIPAL);

        if (unKnownIfMemberOfPKHshld == null || unKnownIfMemberOfPKHshld.isEmpty()) {
          if (allPrincipals != null) {
            boolean allNo = true;
            for (Iterator<Map> it = allPrincipals.iterator(); it.hasNext();) {
              Map principal = it.next();
              if (!ArchitectureConstants.N.equals(principal.get("CD_PK_HSHD_MEMBER"))) {
                allNo = false;
                break;
              }
            }
            if (allNo) {
              throw new ServiceException(Messages.MSG_NO_PK_HH_MBR);
            }
          }
        } else {
          StringBuffer sb = new StringBuffer();
          for (Iterator<Map> it = unKnownIfMemberOfPKHshld.iterator(); it.hasNext();) {
            Map prnUnknownIfMmbr = it.next();
            sb.append(prnUnknownIfMmbr.get("nmPersonFull"));
            if (it.hasNext()) {
              sb.append("- ");
            } else {
              sb.append(".");
            }
          }
          String eventType = "";
          if (isSafetyAssessment(taskCode)) {
            eventType = "Safety Assessment";
          } else {
            eventType = "Safety Plan";
          }
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_UNKNOWN_MBR_HH_NO_ADD);
          errorMessage = MessageLookup.addMessageParameter(errorMessage, eventType);
          errorMessage = MessageLookup.addMessageParameter(errorMessage, sb.toString());
          setErrorMessage(errorMessage, request);
          forward(EVENT_LIST, request, response);
          return;
        }
      }
      
      
      /*
       * SMS #44832 - Prevent user from adding safety assessment if "Member of Primary Caretaker's
       * Household" field is blank for any principals.
       */
      if (isSafetyAssessment(taskCode)) {
        List<Map> listNullPrincipalsInHshld = null;
        listNullPrincipalsInHshld = assessment.retrieveAllPrincipalsWithNullInPKHshld(stageId, PRINCIPAL);
        if (listNullPrincipalsInHshld != null && listNullPrincipalsInHshld.size() > 0) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_MEM_PK_HSHLD_INFO), EVENT_LIST, request);
          forward(EVENT_LIST, request, response);
          return;
        }
      }

      if (isVisitationPlan(taskCode)) {
        taskCode = getEnglishVisitationTaskCode(taskCode);
        GlobalData.setSzCdTask(taskCode, request);
      }

      if (PLCMT_CODES.contains(taskCode)) {
        if (callPersonDetail(stageId, getUserLogonID(request))) {
          setErrorMessage(Messages.MSG_MOTHER_MARRIED, EVENT_LIST, request);

          forward(EVENT_LIST, request, response);
          return;
        }
      }
      
      if (isContactStandards(taskCode)) {
        DetermineIfPptDocumentedSI determineIfPptDocumentedSI = new DetermineIfPptDocumentedSI();
        determineIfPptDocumentedSI.setIdStage(stageId);
        determineIfPptDocumentedSI.setCdEventType(CodesTables.CEVNTTYP_PPT);
        determineIfPptDocumentedSI.setCdPptType(CodesTables.CMEETTYP_FTM);
        
        boolean pptDocumented = common.determineIfPptDocumented(determineIfPptDocumentedSI);
        if (!pptDocumented) {
          if ("6540".equals(taskCode)) {
            setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CS_FCF_FTM_MISSING), EVENT_LIST, request);
          } else if ("7025".equals(taskCode)) {
            setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CS_ONG_FTM_MISSING), EVENT_LIST, request);
          }

        }
      }
      
      //STGAP00013779: The Agreement should always be attached to the APRV Application with status Approved or Deferred.
      if(isAdopAssitAgreement(taskCode)){
        request.setAttribute("adoPullBack", ArchitectureConstants.TRUE);
      }

      // clear event id because navigation could have passed it
      GlobalData.setUlIdEvent(0, request);
      verify("GlobalData.getSzCdStage", GlobalData.getSzCdStage(request));
      verify("GlobalData.getSzCdStageProgram", GlobalData.getSzCdStageProgram(request));
      // SIR 19790
      // verify("GlobalData.getSzCdStageType", GlobalData.getSzCdStageType(request));

      verify("GlobalData.getSzNmStage", GlobalData.getSzNmStage(request));
      verify("GlobalData.getUlIdCase", GlobalData.getUlIdCase(request));
      verify("GlobalData.getUlIdStage", GlobalData.getUlIdStage(request));

      String url = getTaskDetailUrl(GlobalData.getSzCdTask(request));
      forward(url, request, response);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_PK_HH_MBR:
        GrndsTrace.msg(TRACE_TAG, 7, "add:" + se.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "add:" + se.getMessage());
        processSevereException(context, se);
        break;
      }
    }catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  protected void invalidatePendingClosure(GrndsExchangeContext context, int stageClosureEventId) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "invalidatePendingClosure");

    try {
      // Set event status to COMP
      eventUtility.invalidatePendingStageClosure(stageClosureEventId, admin);
    } catch (Exception e) {
      // If this fails, that's bad, so don't distinguish between WtcException
      // and anything else, just throw it all to processSevereException
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Initialize request to create a new Event based on the currently selected Event and call the correct EventDetail
   * window
   *
   * @param context The GrndsExchangeContext object.
   */
  public void newUsingEventDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "newUsingEventDetail_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    // PageMode.setPageMode(PageModeConstants.NEW_USING, request);
    try {
      int stageId = GlobalData.getUlIdStage(request);
      CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);

      if (isStageClosed(stage)) {
        // must use addErrorMessage here; want to repopulate all hidden fields
        addErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
        forward(EVENT_LIST, request, response);
        return;
      }

      int eventId = ContextHelper.getIntSafe(request, "actionEventId");
      CaseUtility.Event event = CaseUtility.getEvent(eventId);

      if (event.getIdEvent() == 0) {
        addErrorMessage(Messages.MSG_EVENT_NO_LONGER_EXISTS, request);
        forward(EVENT_LIST, request, response);
        return;
      }

      String cdTask = GlobalData.getSzCdTask(request);

      // FCC Child Plan changes for R2
      if (FAMILY_PLAN_TASK_CODES.contains(cdTask) && !APPROVED.equals(event.getCdEventStatus())) {
        addErrorMessage(Messages.MSG_FP_COPY_APRV, request);
        forward(EVENT_LIST, request, response);
        return;
      }
      // For Child Plan only Completed Plans can be copied.
      if (CHILD_PLAN_TASK_CODE.equals(cdTask) && !COMPLETE.equals(event.getCdEventStatus())) {
        addErrorMessage(MSG_CP_COPY_COMP, request);
        forward(EVENT_LIST, request, response);
        return;
      }
      
      // For Contact STandards, only Approved standards can be copied
      if (isContactStandards(cdTask) && !APPROVED.equals(event.getCdEventStatus())) {
        addErrorMessage(Messages.MSG_FP_COPY_APRV, request);
        forward(EVENT_LIST, request, response);
        return;
      }
      
      //Show the FTM message for Copy button also.
      if (isContactStandards(cdTask)) {
        DetermineIfPptDocumentedSI determineIfPptDocumentedSI = new DetermineIfPptDocumentedSI();
        determineIfPptDocumentedSI.setIdStage(stageId);
        determineIfPptDocumentedSI.setCdEventType(CodesTables.CEVNTTYP_PPT);
        determineIfPptDocumentedSI.setCdPptType(CodesTables.CMEETTYP_FTM);
        
        boolean pptDocumented = common.determineIfPptDocumented(determineIfPptDocumentedSI);
        if (!pptDocumented) {
          if ("6540".equals(cdTask)) {
            setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CS_FCF_FTM_MISSING), EVENT_LIST, request);
          } else if ("7025".equals(cdTask)) {
            setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CS_ONG_FTM_MISSING), EVENT_LIST, request);
          }

        }
      }

      clearState(context);
      GlobalData.setUlIdEvent(eventId, request);

      setAppMode(request, stage);
      PageMode.setPageMode(PageModeConstants.NEW_USING, request);

      verify("GlobalData.getSzCdTask", cdTask);

      // convert cd_task from for case to single case events
      // ie. ('Legal Actions for Case' to 'Legal Actions')
      String taskCode = CASE_TASK_CODE_CONVERSION.get(cdTask);
      if (taskCode != null) {
        GlobalData.setSzCdTask(taskCode, request);
      }

      verify("GlobalData.getSzCdStage", GlobalData.getSzCdStage(request));
      verify("GlobalData.getSzCdStageProgram", GlobalData.getSzCdStageProgram(request));
      // SIR 19790
      // verify("GlobalData.getSzCdStageType", GlobalData.getSzCdStageType(request));

      verify("GlobalData.getSzNmStage", GlobalData.getSzNmStage(request));
      verify("GlobalData.getUlIdCase", GlobalData.getUlIdCase(request));
      verify("GlobalData.getUlIdStage", GlobalData.getUlIdStage(request));

      String url = getTaskDetailUrl(GlobalData.getSzCdTask(request));
      forward(url, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Initialize request to delete an Event based on the currently selected Event and return to the event list
   * window
   *
   * @param context The GrndsExchangeContext object.
   */
  public void deleteEvent_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "deleteEvent_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    int userID = UserProfileHelper.getUserProfile(context).getUserID();

    try {
      int stageId = GlobalData.getUlIdStage(request);
      CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);

      if (isStageClosed(stage)) {
        // must use addErrorMessage here; want to repopulate all hidden fields
        addErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
        forward(EVENT_LIST, request, response);
        return;
      }

      int eventId = ContextHelper.getIntSafe(request, "actionEventId");
      CaseUtility.Event event = CaseUtility.getEvent(eventId);

      if (event.getIdEvent() == 0) {
        addErrorMessage(Messages.MSG_EVENT_NO_LONGER_EXISTS, request);
        forward(EVENT_LIST, request, response);
        return;
      }

      String cdTask = GlobalData.getSzCdTask(request);
      // For Contact Standards, only new and in process standards can be deleted
      if (isContactStandards(cdTask) && (APPROVED.equals(event.getCdEventStatus()) || PENDING.equals(event.getCdEventStatus()))) {
        addErrorMessage(Messages.MSG_CS_DELETE_CONTACT_STD, request);
        forward(EVENT_LIST, request, response);
        return;
      }
      
      if (isContactStandards(cdTask)) {
        ContactStandardsSaveSI contactStandardsSaveSI = new ContactStandardsSaveSI();
        contactStandardsSaveSI.setIdStage(stageId);
        contactStandardsSaveSI.setCdtask(cdTask);
        contactStandardsSaveSI.setIdEvent(eventId);
        contactStandardsSaveSI.setCdEventStatus(event.getCdEventStatus());
        contactStandardsSaveSI.setDtEventLastUpdate(event.getDtLastUpdate());
        contactStandardsSaveSI.setIdPerson(userID);
        contactStandardsSaveSI.setCdReqAction(DELETE);
        
        common.deleteContactStandards(contactStandardsSaveSI);
      }
      
        // Since this is only implemented for Contact Standards
        // it only deletes the event record, not the event_person_link
        CCMN01UI ccmn01ui = new CCMN01UI();      
        ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
        ArchInputStruct archInputStruct = new ArchInputStruct();

        rowccmn01uig00.setUlIdEvent(eventId);
        rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
        archInputStruct.setCReqFuncCd(DELETE);
        ccmn01ui.setArchInputStruct(archInputStruct);
        ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
        postEvent.postEvent(ccmn01ui);
      
      
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }
  
  
  /**
   * Initialize request to create a new Event based on the currently selected Event and call the correct EventDetail
   * window.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void editEventDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "editEventDetail_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      int stageId = GlobalData.getUlIdStage(request);
      CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);

      if (isStageClosed(stage)) {
        // must use addErrorMessage here; want to repopulate all hidden fields
        addErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
        forward(EVENT_LIST, request, response);
        return;
      }

      int eventId = ContextHelper.getIntSafe(request, "actionEventId");
      CaseUtility.Event event = CaseUtility.getEvent(eventId);

      if (event.getIdEvent() == 0) {
        // must use addErrorMessage here; want to repopulate all hidden fields
        addErrorMessage(Messages.MSG_EVENT_NO_LONGER_EXISTS, request);
        forward(EVENT_LIST, request, response);
        return;
      }

      String cdTask = GlobalData.getSzCdTask(request);

      if (FAMILY_PLAN_TASK_CODES.contains(cdTask) && !APPROVED.equals(event.getCdEventStatus())) {
        addErrorMessage(Messages.MSG_FP_UPDATE_APRV, request);
        forward(EVENT_LIST, request, response);
        return;
      }

      clearState(context);
      GlobalData.setUlIdEvent(eventId, request);

      setAppMode(request, stage);
      PageMode.setPageMode(PageModeConstants.EDIT, request);

      verify("GlobalData.getSzCdTask", cdTask);

      // convert cd_task from for case to single case events
      // ie. ('Legal Actions for Case' to 'Legal Actions')
      String taskCode = CASE_TASK_CODE_CONVERSION.get(cdTask);
      if (taskCode != null) {
        GlobalData.setSzCdTask(taskCode, request);
      }

      verify("GlobalData.getSzCdStage", GlobalData.getSzCdStage(request));
      verify("GlobalData.getSzCdStageProgram", GlobalData.getSzCdStageProgram(request));
      // SIR 19790
      // verify("GlobalData.getSzCdStageType", GlobalData.getSzCdStageType(request));

      verify("GlobalData.getSzNmStage", GlobalData.getSzNmStage(request));
      verify("GlobalData.getUlIdCase", GlobalData.getUlIdCase(request));
      verify("GlobalData.getUlIdStage", GlobalData.getUlIdStage(request));

      String url = getTaskDetailUrl(GlobalData.getSzCdTask(request));
      forward(url, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Navigate back to the caller page(Service Authorization Header Page in this case)which calls the Policy Waiver List
   * page as a pull back.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void continueEventDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "continueEventDetail_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    BaseSessionStateManager state = getSessionStateManager(context);

    PageMode.setPageMode(PageModeConstants.EDIT, request);
    try {
      int stageId = GlobalData.getUlIdStage(request);
      CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);
      int eventId = ContextHelper.getIntSafe(request, "actionEventId");
      CaseUtility.Event event = CaseUtility.getEvent(eventId);

      if (event.getIdEvent() == 0) {
        // must use addErrorMessage here; want to repopulate all hidden fields
        addErrorMessage(Messages.MSG_EVENT_NO_LONGER_EXISTS, request);
        forward(EVENT_LIST, request, response);
        return;
      }
      
      String reqAdoPullBack = ContextHelper.getStringSafe(request, "hdnAdoPullBack");

      
      // Validating the policy waiver selected
      // Begin
      // Need to validate the Policy waiver selected. If the policy waiver selected
      // is not created for the service code of one of the service auth details for
      // the current service Authorization or for the same uas code and ent code as
      // the service authorization header then display an error message and redisplay
      // the policy waiver list.
      String tskCode = GlobalData.getSzCdTask(request);
      if (isServiceAuthorization(tskCode) || isPlacement(tskCode)) {
        // For Service Authorization Header page the user should be able to select only approved Policy
        // waivers.
        if (!APPROVED.equals(event.getCdEventStatus())) {
          addErrorMessage(Messages.MSG_SVC_SEL_APRV, request);
          forward(EVENT_LIST, request, response);
          return;
        }
      }
      if (isServiceAuthorization(tskCode)) {
        CCON18SO ccon18so = (CCON18SO) state.getAttribute("CCON18SO", request);
        CCON21SO ccon21so = (CCON21SO) state.getAttribute("CCON21SO", request);
        String szCdSvcAuthCategory = ccon18so.getSzCdSvcAuthCategory();
        String szCdSvcAuthService = ccon18so.getSzCdSvcAuthService();
        if (!StringHelper.isValid(szCdSvcAuthService)) {
          szCdSvcAuthService = ContextHelper.getStringSafe(request, "selSzCdSvcAuthService");
        }
        if (!StringHelper.isValid(szCdSvcAuthCategory)) {
          szCdSvcAuthCategory = ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory");
        }
        String svcCode = szCdSvcAuthCategory + szCdSvcAuthService;
        ROWCCON21SOG00_ARRAY serviceArray = new ROWCCON21SOG00_ARRAY();
        if (ccon21so != null) {
          serviceArray = ccon21so.getROWCCON21SOG00_ARRAY();
        }
        List<String> svcCodeList = new ArrayList<String>();
        int size = serviceArray != null ? serviceArray.getROWCCON21SOG00Count() : 0;
        boolean svcCodeMatch = false;
        for (int j = 0; j < size; j++) {
          String serviceCode = serviceArray.getROWCCON21SOG00(j).getSzCdSvcAuthDtlSvc();
          if (svcCodeList.size() == 0 || !svcCodeList.contains(serviceCode)) {
            svcCodeList.add(serviceCode);
          }
        }
        if (!svcCodeList.contains(svcCode)) {
          svcCodeList.add(svcCode);
        }

        PolicyWaiverRetrieveSO policyWaiver = financials.retrieveSvcAuthPolicyWaiver(eventId);
        String pWvrUasEntCode = policyWaiver.getCdWvrUasCd() + policyWaiver.getCdWvrEntCd();
        String pWvrSvcCode = (policyWaiver.getCdWvrSvcDesc() != null ? policyWaiver.getCdWvrSvcDesc() : "");
        int length = svcCodeList.size();
        for (int k = 0; k < length; k++) {
          if (pWvrUasEntCode.equals(svcCodeList.get(k)) || pWvrSvcCode.equals(svcCodeList.get(k))) {
            svcCodeMatch = true;
            break;
          }
        }
        if (!svcCodeMatch) {
          addErrorMessage(Messages.MSG_WAIVER_REQUIREMENTS, request);
          forward(EVENT_LIST, request, response);
          return;
        }
      }
      // Validating the policy waiver selected
      // End

      setAppMode(request, stage);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      verify("GlobalData.getSzCdTask", GlobalData.getSzCdTask(request));

      // convert cd_task from for case to single case events
      // ie. ('Legal Actions for Case' to 'Legal Actions')
      String taskCode = CASE_TASK_CODE_CONVERSION.get(GlobalData.getSzCdTask(request));
      if (taskCode != null) {
        GlobalData.setSzCdTask(taskCode, request);
      }

      verify("GlobalData.getSzCdStage", GlobalData.getSzCdStage(request));
      verify("GlobalData.getSzCdStageProgram", GlobalData.getSzCdStageProgram(request));
      verify("GlobalData.getSzNmStage", GlobalData.getSzNmStage(request));
      verify("GlobalData.getUlIdCase", GlobalData.getUlIdCase(request));
      verify("GlobalData.getUlIdStage", GlobalData.getUlIdStage(request));

      String url = getTaskDetailUrl(GlobalData.getSzCdTask(request));
      forward(url, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Initialize request to view the currently selected Event by calling the correct EventDetail window
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayEventDetail_xa(GrndsExchangeContext context) {
    // PageMode.EDIT or PageMode.VIEW
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayEventDetail_xa");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    HttpServletResponse response = context.getResponse();

    try {
      int eventId = ContextHelper.getIntSafe(request, "actionEventId");

      CaseUtility.Event event = CaseUtility.getEvent(eventId);
      String eventStatusCode = "";
      if (event != null) {
        if (event.getIdEvent() == 0) {
          // must use addErrorMessage here; want to repopulate all hidden fields
          addErrorMessage(Messages.MSG_EVENT_NO_LONGER_EXISTS, request);
          forward(EVENT_LIST, request, response);
          return;
        }
      eventStatusCode = event.getCdEventStatus();
      }
      
      //MR-057 APPLA. Get the FCCP Event before the state is cleared.
      Integer ulIdFCCPEvent = (Integer)state.getAttribute("ulIdFCCPEvent", request);
      
      clearState(context);
      
      //MR-057 APPLA. Set the FCCP Event after the state is cleared
      state.setAttribute("ulIdFCCPEvent", ulIdFCCPEvent, request ); 
      
      GlobalData.setUlIdEvent(eventId, request);
      
      String stageCode = ContextHelper.getStringSafe(request, "actionStageCode");
      GlobalData.setSzCdStage(stageCode, request);

      String stageName = ContextHelper.getStringSafe(request, "actionStageName");
      GlobalData.setSzNmStage(stageName, request);

      String taskCode = ContextHelper.getStringSafe(request, "actionTaskCode");
      GlobalData.setSzCdTask(taskCode, request);

      int caseId = ContextHelper.getIntSafe(request, "actionCaseId");
      GlobalData.setUlIdCase(caseId, request);

      int stageId = ContextHelper.getIntSafe(request, "actionStageId");
      GlobalData.setUlIdStage(stageId, request);
      
      //SMS#48653 
      if(isChildrenFirstReferral(taskCode)){
      String actionPersonName = ContextHelper.getStringSafe(request, "actionPersonName");
      GlobalData.setSzNmPersonFull(actionPersonName, request);
      }

      // SIR 23530 also set date stage start into global data
      CaseUtility.Stage stageInfo = CaseUtility.getStage(stageId);
      GlobalData.setDtDtStageStart(stageInfo.getDtStart(), request);

      // CAPs assumes they are there; you don't always have a stage,
      // so I put in extra logic in case...
      if (("".equals(GlobalData.getSzCdStageType(request))) || ("".equals(GlobalData.getSzCdStageProgram(request)))) {
        StageDB stageDB = cfp.getStageDB(caseId, stageId);
        GlobalData.setSzCdStageType(stageDB.getStageType(), request);
        GlobalData.setSzCdStageProgram(stageDB.getProgramName(), request);
      }

      CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);
      setAppMode(request, stage);

      // set page mode / app mode for event detail page
      String pageMode = PageModeConstants.VIEW;
      if (canModifyEvent(request, stage, taskCode, eventStatusCode)) {
        pageMode = PageModeConstants.EDIT;
      }
      PageMode.setPageMode(pageMode, request);

      String url = getTaskDetailUrl(taskCode);
      if (APPROVAL_EVENT_TYPE.equals(getEventType(taskCode))) {
        url = URL_DISPLAY_APPROVAL_STATUS;
      }
      forward(url, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Scaffolding
   *
   * @param context The GrndsExchangeContext object.
   */
  public void blank_xa(GrndsExchangeContext context) {
    clearState(context);
  }

  /**
   * returns true if stage wasn't closed to merge and canModifyEvent() is true
   *
   * @param request  HttpServletRequest
   * @param stage    CaseUtility.Stage
   * @param taskCode String
   * @return boolean
   */
  protected static boolean canCreateEvent(HttpServletRequest request, CaseUtility.Stage stage, String taskCode) {
    boolean closedToMerge = CLOSED_TO_MERGE.equals(stage.getCdStageReasonClosed());

    if ((closedToMerge) || (canModifyEvent(request, stage, taskCode, null) == false)) {
      return false;
    }
    return true;
  }

  protected static void setAppMode(HttpServletRequest request, CaseUtility.Stage stage) {
    GlobalData.setAppMode(PageModeConstants.VIEW, request);

    boolean isStageClosed = isStageClosed(stage);
    GrndsTrace.msg(TRACE_TAG, 7, "setAppMode: stage is closed? " + isStageClosed);

    if (isStageClosed) {
      return;
    }

    int stageId = stage.getIdStage();
    boolean hasStageAccess = hasStageAccess(request, stageId);
    GrndsTrace.msg(TRACE_TAG, 7, "setAppMode: hasStageAccess? " + hasStageAccess);

    if (hasStageAccess) {
      GlobalData.setAppMode(PageModeConstants.EDIT, request);
    }
  }

  /**
   * Populates personId and personFullName in EventSearchDB when EventSearch is returned to from PersonList
   *
   * @param request       HttpServletRequest
   * @param eventSearchDB EventSearchDB
   */
  protected static void populatePerson(HttpServletRequest request, EventSearchDB eventSearchDB) {
    PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request
            .getAttribute(PERSON_LIST_PULLBACK_INFO);

    if (personListPullBackInfo == null) {
      return;
    }
    ROWCINV01SOG00 row = personListPullBackInfo.getPersonListRow();
    if (row == null) {
      return;
    }
    request.removeAttribute(PERSON_LIST_PULLBACK_INFO);

    int personId = row.getUlIdPerson();
    String personName = row.getSzNmPersonFull();

    eventSearchDB.setPersonId(personId);
    eventSearchDB.setPersonName(personName);
  }

  /**
   * Populate EventSearchDB with stageCodes, eventTypeCodes, startDateString, endDateString from request parameters
   *
   * @param request       HttpServletRequest
   * @param eventSearchDB EventSearchDB
   */
  protected static void populateCodesAndDates(HttpServletRequest request, EventSearchDB eventSearchDB) {
    String[] stageCodes = CheckboxHelper.getCheckedValues(request, "stageCode");

    String[] eventTypeCodes = CheckboxHelper.getCheckedValues(request, "eventTypeCode");

    String startDateString = ContextHelper.getString(request, "startDate");
    String endDateString = ContextHelper.getString(request, "endDate");

    boolean searchEntireCase = ContextHelper.getBooleanSafe(request, "searchEntireCase");

    eventSearchDB.setStageCodes(stageCodes);
    eventSearchDB.setEventTypeCodes(eventTypeCodes);
    eventSearchDB.setStartDateString(startDateString);
    eventSearchDB.setEndDateString(endDateString);
    eventSearchDB.setSearchEntireCase(searchEntireCase);
  }

  /**
   * Returns true if taskCode is of type Placement for Case. SIR 18013 preserves New Using for this type while removing
   * it for Placement List.
   *
   * @param taskCode String
   * @return boolean
   */
  public static boolean isPlacementForCase(String taskCode) {
    return PLACEMENT_CASE_TASK_CODES.contains(taskCode);
  }

  /**
   * Returns true if taskCode is of type VisitationPlan also used by OutputLaunchConversation
   *
   * @param taskCode String
   * @return boolean
   */
  public static boolean isVisitationPlan(String taskCode) {
    return VISITATION_PLAN_TASK_CODES.contains(taskCode);
  }

  /**
   * For a given Visitation Task Code return the English one that coorespondes to it also used by
   * OutputLaunchConversation
   *
   * @param taskCode String
   * @return String
   */
  public static String getEnglishVisitationTaskCode(String taskCode) {
    if (taskCode == null) {
      throw new IllegalArgumentException("taskCode shouldn't be null");
    }
    if ((taskCode.equals(VISITATION_PLAN_SUB_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_SUB_SPANISH))
        || (taskCode.equals(VISITATION_PLAN_FOR_CASE_SUB))) {
      return VISITATION_PLAN_SUB_ENGLISH;
    }
    if ((taskCode.equals(VISITATION_PLAN_ADO_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_ADO_SPANISH))
        || (taskCode.equals(VISITATION_PLAN_FOR_CASE_ADO))) {
      return VISITATION_PLAN_ADO_ENGLISH;
    }
    if ((taskCode.equals(VISITATION_PLAN_FPR_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_FPR_SPANISH))) {
      return VISITATION_PLAN_FPR_ENGLISH;
    }
    if ((taskCode.equals(VISITATION_PLAN_FSU_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_FSU_SPANISH))) {
      return VISITATION_PLAN_FSU_ENGLISH;
    }
    throw new IllegalArgumentException("unexpected taskCode: " + taskCode);
  }

  /**
   * For a given Visitation Task Code return the Spanish one that coorespondes to it also used by
   * OutputLaunchConversation
   *
   * @param taskCode String
   * @return String
   */
  public static String getSpanishVisitationTaskCode(String taskCode) {
    if (taskCode == null) {
      throw new IllegalArgumentException("taskCode shouldn't be null");
    }
    if ((taskCode.equals(VISITATION_PLAN_SUB_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_SUB_SPANISH))
        || (taskCode.equals(VISITATION_PLAN_FOR_CASE_SUB))) {
      return VISITATION_PLAN_SUB_SPANISH;
    }
    if ((taskCode.equals(VISITATION_PLAN_ADO_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_ADO_SPANISH))
        || (taskCode.equals(VISITATION_PLAN_FOR_CASE_ADO))) {
      return VISITATION_PLAN_ADO_SPANISH;
    }
    if ((taskCode.equals(VISITATION_PLAN_FPR_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_FPR_SPANISH))) {
      return VISITATION_PLAN_FPR_SPANISH;
    }
    if ((taskCode.equals(VISITATION_PLAN_FSU_ENGLISH)) || (taskCode.equals(VISITATION_PLAN_FSU_SPANISH))) {
      return VISITATION_PLAN_FSU_SPANISH;
    }
    throw new IllegalArgumentException("unexpected taskCode: " + taskCode);
  }

  /**
   * Set Info1/Info2 and HtmlTitle on the screen data
   *
   * @param screen     Screen
   * @param caseId     int
   * @param stageId    int
   * @param windowName String
   */
  protected static void setEventListScreenData(Screen screen, int caseId, int stageId, String windowName) {
    if (stageId != 0) {
      screen.setParameter("Info1", "Stage Name", false);
      if (caseId != 0) {
        screen.setParameter("Info2", "CaseID", false);
      }
    } else if (caseId != 0) {
      screen.setParameter("Info1", "Case Name", false);
      screen.setParameter("Info2", "CaseID", false);
    }
    screen.setParameter("HtmlTitle", windowName, true);
  }

  /**
   * Method is named after a similar method in ccmn51w.win This is called by addEventDetail_xa. It checks whether:
   * 'Mother Married' info on PersonDetail/CVS FA Home must be entered first.
   *
   * @param stageId   int
   * @param userLogin String
   * @return boolean
   * @throws ServiceException
   */
  private boolean callPersonDetail(int stageId, String userLogin) throws ServiceException {
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(userLogin);
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(1);
    String cCdRemovalMothrMarrd = "";

    CCFC37SI ccfc37si = new CCFC37SI();
    ccfc37si.setArchInputStruct(archInputStruct);
    ccfc37si.setUlIdStage(stageId);

    GrndsTrace.msg(TRACE_TAG, 7, "ccfc37si: " + ccfc37si);

    // CCFC37SO ccfc37so = (CCFC37SO) ServiceHelper.callService("CCFC37S", ccfc37si, CCFC37SO.class);
    CCFC37SO ccfc37so = null;

    try {
      ccfc37so = person.retrievePersonDTL(ccfc37si);
      GrndsTrace.msg(TRACE_TAG, 7, "ccfc37so: " + ccfc37so);
      if (ccfc37so != null) {
        cCdRemovalMothrMarrd = ccfc37so.getCCdRemovalMothrMarrd();
      }
      GrndsTrace.msg(TRACE_TAG, 7, "cCdRemovalMothrMarrd: '" + cCdRemovalMothrMarrd + "'");

      return ((cCdRemovalMothrMarrd == null) || ("".equals(cCdRemovalMothrMarrd)));
    } catch (ServiceException e) {
      return true;
    }

  }

  private boolean checkPrimaryCaretakerHouseholdMembers(int stageId, String userLogin) {
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(userLogin);
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(1);
    String strCdPKHshdMember = "";

    CINV04SI cinv04si = new CINV04SI();
    cinv04si.setArchInputStruct(archInputStruct);
    cinv04si.setUlIdStage(stageId);
    
    GrndsTrace.msg(TRACE_TAG, 7, "ccfc37si: " + cinv04si);

    CINV04SO cinv04so = null;

    try {
      cinv04so = person.retrievePersonDetail(cinv04si);
      
      GrndsTrace.msg(TRACE_TAG, 7, "cinv04so: " + cinv04so);
      if (cinv04so != null) {
        strCdPKHshdMember = cinv04so.getCdPKHouseholdMember();
      }
      GrndsTrace.msg(TRACE_TAG, 7, "CdPKHshdMember: '" + strCdPKHshdMember + "'");

      return ((strCdPKHshdMember == null) || ("".equals(strCdPKHshdMember)));
    } catch (ServiceException e) {
      return true;
    }
    
  }
  
  /**
   * Wrapper around CCMN33S which calls once for a non-visitation plan taskCode or as many times as needed to get all
   * English and Spanish visitation plans cooresponding to the taskCode
   *
   * @param ccmn33si   CCMN33SI
   * @param pagination TuxedoPaginationValueBean
   * @return int
   * @throws ServiceException
   */
  protected static CCMN33SO executeEventListService(CCMN33SI ccmn33si, TuxedoPaginationValueBean pagination,
                                                    RetrieveEventList retrieveEventList) throws ServiceException {
    String taskCode = ccmn33si.getSzCdTask();

    if (!isVisitationPlan(taskCode)) {
      return callCCMN33S(ccmn33si, pagination.getResultDetails().getRequestedPage(), pagination.getResultDetails()
              .getResultsPerPage(),
                         retrieveEventList);
    }

    String englishTaskCode = getEnglishVisitationTaskCode(taskCode);
    ccmn33si.setSzCdTask(englishTaskCode);
    CCMN33SO english = getAllEvents(ccmn33si, retrieveEventList);

    String spanishTaskCode = getSpanishVisitationTaskCode(taskCode);
    ccmn33si.setSzCdTask(spanishTaskCode);
    CCMN33SO spanish = getAllEvents(ccmn33si, retrieveEventList);

    List<ROWCCMN33SO> list = new ArrayList<ROWCCMN33SO>();
    addRowsToList(english, list);
    addRowsToList(spanish, list);

    Comparator<ROWCCMN33SO> comparator = new Comparator<ROWCCMN33SO>() {
      public int compare(ROWCCMN33SO row1, ROWCCMN33SO row2) {
        Date date1 = DateHelper.toJavaDate(row1.getDtDtEventOccurred());
        Date date2 = DateHelper.toJavaDate(row2.getDtDtEventOccurred());
        int dateCompare = date1.compareTo(date2);
        if (dateCompare == 0) {
          int eventId1 = row1.getUlIdEvent();
          int eventId2 = row2.getUlIdEvent();

          if (eventId1 == eventId2) {
            return 0;
          }
          if (eventId1 < eventId2) {
            return -1;
          }
          return 1;
        }
        if (dateCompare < 0) {
          return 1;
        }
        return -1;
      }

      /**
       * @param object
       *          Object
       * @return boolean
       * @todo Jtest suggest using "instanceof" with an equals() method implementation
       */
      public boolean equals(Object object) {
        return (object.getClass().equals(getClass()));
      }
    };

    Collections.sort(list, comparator);

    int pageNumber = pagination.getResultDetails().getRequestedPage();
    int resultsPerPage = pagination.getResultDetails().getResultsPerPage();

    int beginIndex = (pageNumber - 1) * resultsPerPage;
    int endIndex = Math.min(list.size(), beginIndex + resultsPerPage);

    boolean more = (list.size() > endIndex);

    setRowsOnCCMN33SO(english, list.subList(beginIndex, endIndex), more);

    return english;
  }

  /**
   * Calls CCMN33S until there are no more events returned
   *
   * @param ccmn33si CCMN33SI
   * @return ccmn33so
   * @throws ServiceException
   */
  protected static CCMN33SO getAllEvents(CCMN33SI ccmn33si, RetrieveEventList retrieveEventList)
          throws ServiceException {
    CCMN33SO ccmn33so;
    List<ROWCCMN33SO> list = new ArrayList<ROWCCMN33SO>();

    int i = 0;
    while (true) {
      i++;
      ccmn33so = callCCMN33S(ccmn33si, i, EVENT_LIST_RESULTS_PER_PAGE, retrieveEventList);

      addRowsToList(ccmn33so, list);

      ArchOutputStruct archOutputStruct = ccmn33so.getArchOutputStruct();
      if (archOutputStruct == null) {
        break;
      }
      if (isFalse(archOutputStruct.getBMoreDataInd())) {
        break;
      }
    }
    setRowsOnCCMN33SO(ccmn33so, list, false);
    return ccmn33so;
  }

  /**
   * List of ROWCCMN33SO are set back on ccmn33so
   *
   * @param ccmn33so CCMN33SO
   * @param list     List
   * @param more     boolean
   */
  protected static void setRowsOnCCMN33SO(CCMN33SO ccmn33so, List<ROWCCMN33SO> list, boolean more) {
    ROWCCMN33SO[] outputArray = new ROWCCMN33SO[list.size()];
    list.toArray(outputArray);

    ROWCCMN33SO_ARRAY rowccmn33so_array = new ROWCCMN33SO_ARRAY();
    rowccmn33so_array.setROWCCMN33SO(outputArray);
    rowccmn33so_array.setUlRowQty(outputArray.length);

    ccmn33so.setROWCCMN33SO_ARRAY(rowccmn33so_array);

    ArchOutputStruct archOutputStruct = ccmn33so.getArchOutputStruct();
    if (archOutputStruct != null) {
      archOutputStruct.setUlRowQty(outputArray.length);
      archOutputStruct.setBMoreDataInd(ArchitectureConstants.N);
      if (more) {
        archOutputStruct.setBMoreDataInd(ArchitectureConstants.Y);
      }
    }
  }

  /**
   * All ROWCCMN33SO of ccmn33so are set in list
   *
   * @param ccmn33so CCMN33SO
   * @param list     List
   */
  protected static void addRowsToList(CCMN33SO ccmn33so, List<ROWCCMN33SO> list) {
    ROWCCMN33SO[] outputArray = ccmn33so.getROWCCMN33SO_ARRAY().getROWCCMN33SO();
    List<ROWCCMN33SO> list2 = Arrays.asList(outputArray);
    list.addAll(list2);
  }

  /**
   * Wrapper around CCMN33S
   *
   * @param ccmn33si   CCMN33SI
   * @param pageNumber int
   * @param pageSize   int
   * @return ccmn33so
   * @throws ServiceException
   */
  protected static CCMN33SO callCCMN33S(CCMN33SI ccmn33si, int pageNumber, int pageSize,
                                        RetrieveEventList retrieveEventList) throws ServiceException {
    ArchInputStruct archInputStruct = ccmn33si.getArchInputStruct();
    archInputStruct.setUsPageNbr(pageNumber);
    archInputStruct.setUlPageSizeNbr(pageSize);
    return retrieveEventList.retrieveEventList(ccmn33si);
  }

  /**
   * creates CCMN33SI
   *
   * @param caseId              int
   * @param stageId             int
   * @param globalDataPersonId  int
   * @param taskCode            String
   * @param indTaskNuAcrossCase boolean
   * @param caller              String
   * @param userLogin           String
   * @param eventSearchDB       EventSearchDB
   * @return ccmn33si
   */
  protected static CCMN33SI getCCMN33SI(int caseId, int stageId, int globalDataPersonId, String taskCode,
                                        boolean indTaskNuAcrossCase, String caller, String userLogin, List<String> cdStatus,
                                        EventSearchDB eventSearchDB) {
    CCMN33SI ccmn33si = new CCMN33SI();
 
    if (caller.equals(CALLER_PERSON_DETAIL)) {
      ccmn33si.setUlIdPerson(globalDataPersonId); // This is person on person detail page

      setROWCCMN33SI(ccmn33si, eventSearchDB.getEventTypeCodes(), new String[0], new String[0]);
    } else if (caller.equals(CALLER_EVENT_SEARCH)) {
      ccmn33si.setUlIdPerson(eventSearchDB.getPersonId());
      ccmn33si.setUlIdEventPerson(eventSearchDB.getStaffId());
      ccmn33si.setUlIdCase(caseId);
      ccmn33si.setUlIdStage(stageId);

      setROWCCMN33SI(ccmn33si, eventSearchDB.getEventTypeCodes(), eventSearchDB.getStageCodes(), new String[0]);

      Date MINIMUM_DATE = EventSearchCustomValidation.MINIMUM_DATE;
      Date startDate = DateHelper.toJavaDateFromInputWithDefault(eventSearchDB.getStartDateString(), MINIMUM_DATE);

      org.exolab.castor.types.Date castorStartDate = new org.exolab.castor.types.Date(startDate);

      ccmn33si.setDtScrDtStartDt(castorStartDate);

      Date MAXIMUM_DATE = new Date();
      Date endDate = DateHelper.toJavaDateFromInputWithDefault(eventSearchDB.getEndDateString(), MAXIMUM_DATE);

      // add 1 day; because CCMN33S uses dates exclusively
      // where as users expect dates are first date and last date in set
      endDate = DateHelper.addToDate(endDate, 0, 0, 1);

      org.exolab.castor.types.Date castorEndDate = new org.exolab.castor.types.Date(endDate);

      ccmn33si.setDtScrDtEventEnd(castorEndDate);
    } else if (caller.equals(CALLER_TODO)) {
      ccmn33si.setUlIdCase(caseId);
      ccmn33si.setUlIdStage(stageId);
    } else {
      ccmn33si.setUlIdCase(caseId);

      // If New Using across Case
      // filter on eventType of taskCode
      // instead of stageId and taskCode
      // Display CFR events from all stages, do not filter by stage
      // Display CNS events form all stages, do not filter by stage
      if (indTaskNuAcrossCase || isMedicalMentalAssessment(taskCode) || isChildrenFirstReferral(taskCode) || isCDNFSI(taskCode)) {
        if ("".equals(taskCode) == false) {
          String[] eventTypeCodes = new String[1];
          eventTypeCodes[0] = getEventType(taskCode);

          setROWCCMN33SI(ccmn33si, eventTypeCodes, new String[0], new String[0]);
        }
      } else {
        ccmn33si.setUlIdStage(stageId);
        ccmn33si.setSzCdTask(taskCode);
        if(cdStatus != null && cdStatus.size() > 0) {
          String[] arrayCdStatus = cdStatus.toArray(new String[cdStatus.size()]);
          setROWCCMN33SI(ccmn33si, new String[0], new String[0], arrayCdStatus);
        }
      }
    }

    // This is to guard the service from performing a full table scan on
    // on event and never returning; and slowing the rest of the system
    // to a halt
    if ((ccmn33si.getUlIdCase() == 0) && (ccmn33si.getUlIdStage() == 0) && (ccmn33si.getUlIdPerson() == 0)) {

      throw new IllegalArgumentException
              // SIR 22985
              (MessageLookup.getMessageByNumber(Messages.MSG_UNEX_NAV)
               + " - Expected one of id_case, id_stage, id_person to be non-zero");
    }

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(userLogin);
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    if (ccmn33si.getUlIdPerson() == 0) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    // check to see if the caller is HEALTH LOG and only then set the
    // appropriate attributes. However, A is required to allow the
    // system perform a search using more tables than it would ordinarily
    // require. Fixes SIR 449.
    if (caller.equals(CALLER_HEALTH_LOG)) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_HEALTH_LOG_ADD);
      ccmn33si.setUlIdPerson(globalDataPersonId);
    } else if(caller.equals(CALLER_CHILDREN_FIRST)){
      archInputStruct.setCReqFuncCd(REQ_FUNC_CD_CHILDREN_FIRST_ADD);
      ccmn33si.setUlIdPerson(globalDataPersonId);
    } else if(caller.equals(CALLER_CDNFSI)){
      archInputStruct.setCReqFuncCd(REQ_FUNC_CD_CDNFSI_ADD);
      ccmn33si.setUlIdStageForCNS(stageId);
      ccmn33si.setUlIdPerson(globalDataPersonId);
    }
    ccmn33si.setArchInputStruct(archInputStruct);

    return ccmn33si;
  }

  /**
   * Set ROWCCMN33SI_ARRAY struct according to eventTypeCodess and stageCodes
   *
   * @param ccmn33si       CCMN33SI
   * @param eventTypeCodes String []
   * @param stageCodes     String[]
   */
  protected static void setROWCCMN33SI(CCMN33SI ccmn33si, String[] eventTypeCodes, String[] stageCodes, String[] statusCodes) {
    int length = Math.max(stageCodes.length, eventTypeCodes.length);
    length = Math.max(length, statusCodes.length);

    ROWCCMN33SI[] array = new ROWCCMN33SI[length];
    for (int i = 0; i < length; i++) {
      array[i] = new ROWCCMN33SI();
    }
    for (int i = 0; i < stageCodes.length; i++) {
      array[i].setSzCdStage(stageCodes[i]);
    }
    for (int i = 0; i < eventTypeCodes.length; i++) {
      array[i].setSzCdEventType(eventTypeCodes[i]);
    }
    
    for (int i = 0; i < statusCodes.length; i++) {
      array[i].setSzCdEventStatus(statusCodes[i]);
    }

    ROWCCMN33SI_ARRAY rowccmn33si_array = new ROWCCMN33SI_ARRAY();
    rowccmn33si_array.setROWCCMN33SI(array);
    rowccmn33si_array.setUlRowQty(array.length);
    ccmn33si.setROWCCMN33SI_ARRAY(rowccmn33si_array);
  }

  /**
   * Convert ROWCCMN33SO[] into EventDB[]
   *
   * @param inputArray ROWCCMN33SO[]
   * @return EventDB
   */
  protected static EventDB[] toEventArray(ROWCCMN33SO[] inputArray) {
    EventDB[] outputArray = new EventDB[inputArray.length];
    for (int i = 0; i < outputArray.length; i++) {
      outputArray[i] = toEvent(inputArray[i]);
    }
    return outputArray;
  }

  /**
   * Convert ROWCCMN33SO into EventDB
   *
   * @param row ROWCCMN33SO
   * @return eventDB
   */
  protected static EventDB toEvent(ROWCCMN33SO row) {
    EventDB eventDB = new EventDB();
    eventDB.setHasEventNavigation(isTrue(row.getBIndTaskEventNavig()));
    eventDB.setAllowsMultipleInstances(isTrue(row.getBIndTaskMultInstance()));
    eventDB.setAllowsNewUsing(isTrue(row.getCIndTaskNewUsing()));
    eventDB.setAllowsDelete(isTrue(row.getBIndTaskDelete()));
    eventDB.setDateEventOccurred(DateHelper.toJavaDate(row.getDtDtEventOccurred()));
    eventDB.setEventStatusCode((row.getSzCdEventStatus() != null ? row.getSzCdEventStatus() : ""));
    eventDB.setEventTypeCode(row.getSzCdEventType());
    eventDB.setStageCode(row.getSzCdStage());
    eventDB.setTaskCode(row.getSzCdTask());
    eventDB.setTaskStatusCode(row.getSzCdTaskEventStatus());
    eventDB.setTopWindow(row.getSzCdTaskTopWindow());
    eventDB.setStageName(row.getSzNmStage());
    eventDB.setCaseWorkerName((row.getSzScrCaseWorker() != null ? row.getSzScrCaseWorker() : ""));
    eventDB.setPersonName(row.getSzScrPersonNameEvent());
    eventDB.setEventDescription(row.getSzTxtEventDescr());
    eventDB.setCaseId(row.getUlIdCase());
    eventDB.setEventId(row.getUlIdEvent());
    eventDB.setStageId(row.getUlIdStage());
    return eventDB;
  }

  /**
   * Coming from Staff To-Do List click Navigate to get an EventList Greyed out events in CAPs are marked with "#" in
   * Impact They are retrieved by the service CCMN34S by passing ldIdTodo (and ulIdEvent?) Each ROWCCMN57DO provides a
   * ulIdEvent which needs to be marked with "#"
   *
   * @param events    EventDB[]
   * @param todoId    int
   * @param eventId   int
   * @param userLogin String
   * @throws ServiceException
   */
  private void markSubmittedEvents(EventDB[] events, int todoId, int eventId, String userLogin)
          throws ServiceException {
    if (todoId == 0) {
      return;
    }

    Set<String> marked = getMarkedEvents(todoId, eventId, userLogin);
    for (int i = 0; i < events.length; i++) {
      String eventIdString = "" + events[i].getEventId();
      if (marked.contains(eventIdString)) {
        events[i].setSubmitted(true);
      }
    }
  }

  /**
   * Calls CCMN34S service to identify which events need to be "#"d in EventList
   *
   * @param todoId    int
   * @param eventId   int
   * @param userLogin String
   * @return HashSet
   * @throws ServiceException
   */
  private Set<String> getMarkedEvents(int todoId, int eventId, String userLogin) throws ServiceException {
    try {
      Set<String> marked = new HashSet<String>();

      int i = 0;
      while (true) {
        i++;
        ArchInputStruct archInputStruct = new ArchInputStruct();
        archInputStruct.setSzUserId(userLogin);
        archInputStruct.setUsPageNbr(i);
        archInputStruct.setUlPageSizeNbr(15);

        CCMN34SI ccmn34si = new CCMN34SI();
        ccmn34si.setArchInputStruct(archInputStruct);
        ccmn34si.setLdIdTodo(todoId);
        ccmn34si.setUlIdEvent(eventId);

        CCMN34SO ccmn34so = admin.retrieveApprovalStatus(ccmn34si);

        ROWCCMN57DO[] submittedEventsArray = ccmn34so.getROWCCMN57DO_ARRAY().getROWCCMN57DO();

        for (int j = 0; j < submittedEventsArray.length; j++) {
          marked.add(String.valueOf(submittedEventsArray[j].getUlIdEvent()));
        }

        ArchOutputStruct archOutputStruct = ccmn34so.getArchOutputStruct();
        // -- abgoode - I added the null check to prevent a NullPointerException. But the
        // -- RetrieveApprovalStatus service does not use the ArchOutputStruct, therefore this
        // -- if statement will always be true.
        if (archOutputStruct == null || isFalse(archOutputStruct.getBMoreDataInd())) {
          break;
        }
      }
      return marked;
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      if (errorCode == Messages.MSG_NO_ROWS_RETURNED) {
        return new HashSet<String>();
      }
      throw e;
    }
  }

  /**
   * Very analogous to ccmn51w.win setWindowState which lets us know when the different actions are available for each
   * event.
   *
   * @param events              EventDB[]
   * @param userProfile         UserProfile
   * @param taskCode            String
   * @param caseId              int
   * @param stageId             int
   * @param indTaskNuAcrossCase boolean
   * @param hasStageAccess      boolean
   * @param stageClosed         boolean
   * @param reasonStageClosed   String
   * @param caller              String
   * @param bOutProc            boolean
   * @param bStageBeingApproved boolean
   * @return eventListWindowState
   */
  protected EventListWindowStateDB eventListSetWindowState(EventDB[] events, UserProfile userProfile,
                                                                  String taskCode, int caseId, int stageId,
                                                                  boolean indTaskNuAcrossCase, boolean hasStageAccess,
                                                                  boolean stageClosed, String reasonStageClosed,
                                                                  String caller, boolean bOutProc,
                                                                  boolean bStageBeingApproved) {
    
    // STGAP00010963: This indicator is used to display the ADD button on the Exchange Child Registration List page if
    // the user has SAU Sealed or SAU Staff attributes, even if they access the case from Case Search page. This 
    // indicator is set to false if there are any ExchangeChild Registration events with status PROC in which case the
    // ADD button will not be displayed.

    boolean indNoProcEvents = true;
    
    if ((taskCode != null) && ("".equals(taskCode.trim()))) {
      taskCode = null;
    }

    if (caller.equals(CALLER_HEALTH_LOG) || CALLER_CHILDREN_FIRST.equals(caller) || CALLER_CDNFSI.equals(caller)) {
      caller = ""; // changes the caller to blank. SIR 449
    }

    GrndsTrace.msg(TRACE_TAG, 7, "eventListSetWindowState: \n" + " events.length: " + events.length + "\n"
                                 + " userProfile.hasRight(UserProfile.SEC_MNTN_LEGAL_STAT): "
                                 + userProfile.hasRight(UserProfile.SEC_MNTN_LEGAL_STAT) + "\n"
                                 + " userProfile.hasRight(UserProfile.SEC_MNTN_SVC_AUTH): "
                                 + userProfile.hasRight(UserProfile.SEC_MNTN_SVC_AUTH) + "\n" + " taskCode: "
                                 + taskCode + "\n" + " caseId: " + caseId + "\n" + " stageId: " + stageId + "\n"
                                 + " hasStageAccess: " + hasStageAccess + "\n" + " indTaskNuAcrossCase: "
                                 + indTaskNuAcrossCase + "\n" + " stageClosed: " + stageClosed + "\n"
                                 + " reasonStageClosed: " + reasonStageClosed + "\n" + " caller: " + caller);

    // start of port from ccmn51w.win
    boolean bDetail = true;
    boolean bNew = true;
    boolean bNewUsing = true;
    boolean bEventHistory = true;
    boolean bEdit = false;
    boolean bDelete = false;
    boolean bStageIsSealedDisableNewUsing = false;

    // in ccmn51w.win: was personId != 0,
    // but that disables EventHistory when coming from EventSearch
    // if you add a personId; that's kind of unintuitive
    if (caseId == 0) {
      bEventHistory = false;
    }

    if (indTaskNuAcrossCase) {
      bNew = false;
      bEventHistory = false;
      bDetail = false;
    }

    if (taskCode != null) {
      CaseUtility.Stage stage = CaseUtility.getStage(stageId);
      if(CodesTables.CSTAGES_FAD.equals(stage.getCdStage()) && ArchitectureConstants.Y.equals(stage.getIndSealed())) {
        if(userProfile.hasRight(UserProfile.SEC_SAU_SEALED) == false) {
          String taskDecode = decodeTask(taskCode);
          //Foster Home Conversion events; all users see only items since last sealing (except for SAU Sealed users)
          if ("Home Conversion".equals(taskDecode)) {
            for (int i = 0; i < events.length; i++) {
              Date dtSealed = DateHelper.toJavaDate(stage.getDtSealed());
              Date dtEvent = events[i].getDateEventOccurred();
              if(DateHelper.isBefore(dtEvent, dtSealed) || DateHelper.isEqual(dtEvent, dtSealed)){
                events[i].setHasEventNavigation(false);
              }          
            }
          } else {
            String category = (admin != null) ? admin.retrieveFADStageResourceCategory(stage.getIdStage()) : "";
            List<String> categories  = new ArrayList<String>();
            categories.add(CodesTables.CFACATEG_A); //Adoptive
            categories.add(CodesTables.CFACATEG_D); //Relative Adopt
            categories.add(CodesTables.CFACATEG_L); //Foster/Adoptive (Legal Risk)
            categories.add(CodesTables.CFACATEG_J); //ICPC Adopt
             //SMS#52235 general users see only the following events that occured since last sealing
             //the events created before sealing cannot be viewed by an user even if he has stageAccess for above homes but can be viewed
            // if the home is not one of the above and has FHC and person has stage access
            if (categories.contains(category) ||
                 (adoExchange.hasAprvFosterHomeConversionForCase(stage.getIdCase()) == true && !CaseUtility.hasStageAccess(userProfile.getUserID(), stage.getIdStage())) ) { 
              for (int i = 0; i < events.length; i++) {
                List<String> types = new ArrayList<String>();
                types.add(CodesTables.CEVNTTYP_RVF); //Re-evaluation
                types.add(CodesTables.CEVNTTYP_CON); //Contact
                if(types.contains(events[i].eventTypeCode)) {
                  Date dtSealed = DateHelper.toJavaDate(stage.getDtSealed());
                  Date dtEvent = events[i].getDateEventOccurred();
                  if(DateHelper.isBefore(dtEvent, dtSealed) || DateHelper.isEqual(dtEvent, dtSealed)){
                    events[i].setHasEventNavigation(false);
                  }
                }              
              }
            } 
          }
        }
      }
    } else {
      for (int i = 0; i < events.length; i++) {
        CaseUtility.Stage stage = CaseUtility.getStage(events[i].stageId);
        if(CodesTables.CSTAGES_FAD.equals(stage.getCdStage()) && ArchitectureConstants.Y.equals(stage.getIndSealed())) {
          if(userProfile.hasRight(UserProfile.SEC_SAU_SEALED) == false) {
            //Foster Home Conversion events; all users see only items since last sealing (except for SAU Sealed users)
            if(CodesTables.CEVNTTYP_HCN.equals(events[i].eventTypeCode)) {
              Date dtSealed = DateHelper.toJavaDate(stage.getDtSealed());
              Date dtEvent = events[i].getDateEventOccurred();
              if(DateHelper.isBefore(dtEvent, dtSealed) || DateHelper.isEqual(dtEvent, dtSealed)){
                events[i].setHasEventNavigation(false);
              }
            } else {
              String category = (admin != null) ? admin.retrieveFADStageResourceCategory(stage.getIdStage()) : "";
              List<String> categories  = new ArrayList<String>();
              categories.add(CodesTables.CFACATEG_A); //Adoptive
              categories.add(CodesTables.CFACATEG_D); //Relative Adopt
              categories.add(CodesTables.CFACATEG_L); //Foster/Adoptive
              categories.add(CodesTables.CFACATEG_J); //ICPC Adopt
              //general users see only the following events that occuried since last sealing
              //SMS#52235 events could be viewed if the home is not one of the above and has FHC and person has stage access
              if (categories.contains(category)|| 
                    (adoExchange.hasAprvFosterHomeConversionForCase(stage.getIdCase()) == true && !CaseUtility.hasStageAccess(userProfile.getUserID(), stage.getIdStage()))) { 
                List<String> types = new ArrayList<String>();
                types = new ArrayList<String>();
                types.add(CodesTables.CEVNTTYP_RVF); //Re-evaluation
                types.add(CodesTables.CEVNTTYP_CON); //Contact
                if(types.contains(events[i].eventTypeCode)) {
                  Date dtSealed = DateHelper.toJavaDate(stage.getDtSealed());
                  Date dtEvent = events[i].getDateEventOccurred();
                  if(DateHelper.isBefore(dtEvent, dtSealed) || DateHelper.isEqual(dtEvent, dtSealed)){
                    events[i].setHasEventNavigation(false);
                  }
                }
              } 
            }
          }
        }
      }
    }
   
    //For Corrective Action Plans and Policy Violation events created in FosterAdoptive(Legal Risk), Adoptive, Foster, ICPC Foster, ICPC Adopt, Relative Foster
    // Relative Adopt homes 
    // 1. events created before Sealing should be 
    // view only for Resource Dev. assisned to FAD home and anybody in their unit hierarchy and also to SAU Sealed attribute 
    // user if not assigned to the case. 
    // Modify access for SAU sealed users who are assigned to the case
    //2. Resource Dev. assigned to FAD home and anybody in hierarchy and anybody with SAU Sealed should have 
    // Add/Copy/Modify access to events created after Sealing 
    if (taskCode != null) {
      CaseUtility.Stage stage = CaseUtility.getStage(stageId);
      if (CodesTables.CSTAGES_FAD.equals(stage.getCdStage()) && ArchitectureConstants.Y.equals(stage.getIndSealed())) {
        if (userProfile.hasRight(UserProfile.SEC_SAU_SEALED) == false && !(userProfile.hasRight(UserProfile.SEC_RSRC_DEVELOPER))) {
          if ((CaseUtility.hasStageAccess(userProfile.getUserID(), stage.getIdStage()) == false) || (adoExchange.hasAprvFosterHomeConversionForCase(stage.getIdCase()) == true)) {
            for (int i = 0; i < events.length; i++) {
              List<String> types = new ArrayList<String>();
              types.add(CodesTables.CEVNTTYP_CRA); // Corrective Action Plan
              types.add(CodesTables.CEVNTTYP_VLT); // Policy Violation
              if (types.contains(events[i].eventTypeCode)) {
                Date dtSealed = DateHelper.toJavaDate(stage.getDtSealed());
                Date dtEvent = events[i].getDateEventOccurred();
                if (DateHelper.isBefore(dtEvent, dtSealed) || DateHelper.isEqual(dtEvent, dtSealed)) {
                  events[i].setHasEventNavigation(false);
                }
              }
            }
          }
        }
      }
    } else {
      for (int i = 0; i < events.length; i++) {
        CaseUtility.Stage stage = CaseUtility.getStage(events[i].stageId);
        if (CodesTables.CSTAGES_FAD.equals(stage.getCdStage()) && ArchitectureConstants.Y.equals(stage.getIndSealed())) {
          if (userProfile.hasRight(UserProfile.SEC_SAU_SEALED) == false  && !(userProfile.hasRight(UserProfile.SEC_RSRC_DEVELOPER))){
            
            // general users see only the following events that occuried since last sealing
            if ((CaseUtility.hasStageAccess(userProfile.getUserID(), stage.getIdStage()) == false)
                || (adoExchange.hasAprvFosterHomeConversionForCase(stage.getIdCase()) == true)) {
              List<String> types = new ArrayList<String>();
              types = new ArrayList<String>();
              types.add(CodesTables.CEVNTTYP_CRA); // Corrective Action Plan
              types.add(CodesTables.CEVNTTYP_VLT); // Policy Violation
              if (types.contains(events[i].eventTypeCode)) {
                Date dtSealed = DateHelper.toJavaDate(stage.getDtSealed());
                Date dtEvent = events[i].getDateEventOccurred();
                if (DateHelper.isBefore(dtEvent, dtSealed) || DateHelper.isEqual(dtEvent, dtSealed)) {
                  events[i].setHasEventNavigation(false);
                }
              }
            }
          }
        }
      }
    }
    
    if (taskCode != null) {
      // -- Use decodeTask to pull TXT_TASK_DECODE from TASK table and check value for
      // -- "Legal Actions for Case" or "Legal Status for Case"
      // -- If so, set bDetail to true so that the Type hyperlink will display
      String taskDecode = decodeTask(taskCode);
      if (taskDecode != null
          && ("Legal Actions for Case".equalsIgnoreCase(taskDecode) || "Legal Status for Case"
              .equalsIgnoreCase(taskDecode))) {
        bDetail = true;
      }
      if (taskDecode != null
          && ("WTLP for Case".equalsIgnoreCase(taskDecode) || "Service Auth for Case".equalsIgnoreCase(taskDecode))
          || "Visitation Plan for Case".equalsIgnoreCase(taskDecode)) {
        bDetail = true;
      }
    }

    if (taskCode != null) {
      // -- Use decodeTask to pull TXT_TASK_DECODE from TASK table and check value for
      // -- "Family Plan" and "Foster Care Case Plan Family"
      // -- If so, set bEdit to true so that the Edit button will display
      String taskDecode = decodeTask(taskCode);
      //STGAP00010157 - do not display update button if the user does not have stage access
      if (taskDecode != null
          && ("Family Plan".equalsIgnoreCase(taskDecode) || "Foster Care Case Plan Family"
              .equalsIgnoreCase(taskDecode)) && hasStageAccess) {
        bEdit = true;
      }
    }
    
    if (taskCode != null) {
      
    }
    
    if (taskCode != null) {
      //STGAP00008568: Safety Resource page will work as a for case list page, but have
      //editable add button and hyperlinks.  
      String taskDecode = decodeTask(taskCode);
      if (taskDecode != null
          && "Safety Resource".equalsIgnoreCase(taskDecode))  {
        bDetail = true;
        bNew = true;
      }
    }
    
    if (taskCode != null) {
      //STGAP00010004 For Exchange Home do not show Add if items are in in in process status
      String taskDecode = decodeTask(taskCode);
      if (taskDecode != null
          && "Exchange Home Registration".equalsIgnoreCase(taskDecode))  {
        for (int i = 0; i < events.length; i++) {

          if ((events[i].getEventStatusCode().equals(PROCESS))) {
            bNew = false;
            indNoProcEvents = false;
            break;
          }
        }
        
        //only SAU staff can add a Exchange Home
        if(bNew == true) {
          if(userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE)) {
            bNew = true;
          } else {
            bNew = false;;
          }
        }
      }
    }
    //STGAP00010006: If there is an existing Child Registration Event in PROC status, do not show the ADD button.    
    if (taskCode != null) {
      String taskDecode = decodeTask(taskCode);
      if (taskDecode != null && "Exchange Child Registration".equalsIgnoreCase(taskDecode)) {
        for (int i = 0; i < events.length; i++) {

          if (events[i].getEventStatusCode().equals(PROCESS) || events[i].getEventStatusCode().equals(NEW)) {
            bNew = false;
            indNoProcEvents = false;
            break;
          }
        }
        if(stageClosed){
          bNew = false;
          indNoProcEvents = false;
        }
      }
    }
    
    if (taskCode != null) {
      // -- Use decodeTask to pull TXT_TASK_DECODE from TASK table and check value for
      // -- "Contact Standards"
      // -- If the FCEA event status is New, Process, Pending or Complete set bNew to false
      // -- so that the Add button will not display. we don't want to indiscriminately create
      // -- new Contact Standards if the latest one has not been Approved

      String taskDecode = decodeTask(taskCode);
      if (taskDecode != null && ("Contact Standards".equalsIgnoreCase(taskDecode)) && events.length > 0) {
        for (int i = 0; i < events.length; i++) {
          /* MR-062 For Contact Standards, we want to be able to
           * delete those in COMP status as well as NEW & PROC.
           */
          if (isContactStandards(taskCode) && events[i].getEventStatusCode().equals(COMPLETE)) {
            bDelete = true;
          }
          if ((events[i].getEventStatusCode().equals(PROCESS)) || (events[i].getEventStatusCode().equals(NEW))){
            bDelete = true;
          }
          if ((events[i].getEventStatusCode().equals(PROCESS)) || (events[i].getEventStatusCode().equals(COMPLETE))
              || (events[i].getEventStatusCode().equals(PENDING)) || (events[i].getEventStatusCode().equals(NEW))) {
            bNew = false;
            break;
          } else {
            bNew = true;
          }
        }

      }
    }
    
    if (taskCode != null) {
      // -- Use decodeTask to pull TXT_TASK_DECODE from TASK table and check value for
      // -- "Foster Care Application or Foster Care Review"
      // -- If the FCEA event status is New, Process, Pending or Complete set bNew to false
      // -- so that the Add button will not display. we don't want to indiscriminately create
      // -- new Initial Applications if the latest one has not been Approved

      String taskDecode = decodeTask(taskCode);
      if (taskDecode != null && ("Foster Care Application".equalsIgnoreCase(taskDecode)) && events.length > 0) {
        for (int i = 0; i < events.length; i++) {

          if ((events[i].getEventStatusCode().equals(PROCESS)) || (events[i].getEventStatusCode().equals(COMPLETE))
              || (events[i].getEventStatusCode().equals(PENDING)) || (events[i].getEventStatusCode().equals(NEW))) {
            bNew = false;
            break;
          }
        }

      }
      if (taskDecode != null && ("Foster Care Review".equalsIgnoreCase(taskDecode))) {
        if (events.length > 0) {
          for (int i = 0; i < events.length; i++) {

            if ((events[i].getEventStatusCode().equals(PROCESS)) || (events[i].getEventStatusCode().equals(PENDING))
                || (events[i].getEventStatusCode().equals(NEW))) {
              bNew = false;
              break;
            }
          }
        } else {
          // If there aren't any existing Redetermination, check and see if a completed application exist
          // Do not show the 'Add' button if one doesn't exist
          if (!checkIfCompletedFosterCareAppExist(stageId)){
            bNew = false;
          }
        }
        
      }
      
      //STGAP00013779: SAU_STAFF should not see Add button as they can only view the Agreement.
      if (taskDecode != null && ("Adoption Assistance Agreement".equalsIgnoreCase(taskDecode)))  {
        if((userProfile.hasRight(UserProfile.SEC_ADOPT_ASSIST_SPEC) && hasStageAccess)) {
          bNew = true;
        } else {
          bNew = false;
        }
      }
      
      if (taskDecode != null && ("Adoption Assistance Application".equalsIgnoreCase(taskDecode)))  {
        if((userProfile.hasRight(UserProfile.SEC_ADOPT_ASSIST_SPEC) && hasStageAccess) 
                        || (userProfile.hasRight(UserProfile.SEC_ADOPT_ASSIST_SPEC) && (userProfile.hasRight(UserProfile.SEC_ADO_VIEW)))) {
          bNew = true;
        } else {
          bNew = false;
        }
      } 
    }

    if ( !(userProfile.hasRight(UserProfile.SEC_ELIGIBILITY) && userProfile.hasRight(UserProfile.SEC_BILLING)) && 
          (ELIG_SUMMARY_ADO.equals(taskCode) || ELIG_SUMMARY_PAD.equals(taskCode)) ) {
      bNew = false;
    }
    
    //STGAP00012833: Added this code to not show Add button when the user does not have proper security attribute to 
    // modify Case Review page
    if (taskCode != null) {
      if ( !(userProfile.hasRight(UserProfile.SEC_CASE_REVIEW )) && 
                      (CASE_REVIEW_INT.equals(taskCode) || CASE_REVIEW_INV.equals(taskCode) ||
                                      CASE_REVIEW_SUB.equals(taskCode) || CASE_REVIEW_ADO.equals(taskCode) ||
                                      CASE_REVIEW_FPR.equals(taskCode) || CASE_REVIEW_DIV.equals(taskCode))) {
        bNew = false;
      }
    }
    
    /*
     * SIR # 18316: per discussion with Mark P, if user navigates * to Event List from Person Detail Window, the Report
     * section should be hidden
     */
    if (caller.equals(CALLER_PERSON_DETAIL)) {
      bEventHistory = false;
    }
    
    

    // This is analogous to coming from task list in CAPs
    // user has to have stage access and stage needs to be open
    // to have Add/NewUsing/Delete buttons
    if (("".equals(caller)) && (taskCode != null) && (hasStageAccess) && (stageClosed == false)) {
      if ((events.length > 0) && (events[0].getAllowsMultipleInstances() == false)) {
        bNew = false;
        bNewUsing = false;
        bDelete = false;
      }

      if ((events.length > 0) && (events[0].getTaskStatusCode() != null)) {
        int taskStatus = VALUE_OTHER;
        if (events[0].getTaskStatusCode().equals(PROCESS)) {
          taskStatus = VALUE_PROCESS;
        } else if (events[0].getTaskStatusCode().equals(COMPLETE)) {
          taskStatus = VALUE_COMPLETE;
        } else if (events[0].getTaskStatusCode().equals(PENDING)) {
          taskStatus = VALUE_PENDING;
        } else if (events[0].getTaskStatusCode().equals(APPROVED)) {
          taskStatus = VALUE_APPROVAL;
        }

        // 06/30/2003, Matthew McClain
        // removed CHILD_PLAN special casing
        for (int i = 0; i < events.length; i++) {
          if (events[i].getEventStatusCode() == null) {
            break;
          }
          int eventStatus = VALUE_OTHER;
          if (events[i].getEventStatusCode().equals(PROCESS)) {
            eventStatus = VALUE_PROCESS;
          } else if (events[i].getEventStatusCode().equals(COMPLETE)) {
            eventStatus = VALUE_COMPLETE;
          } else if (events[i].getEventStatusCode().equals(PENDING)) {
            eventStatus = VALUE_PENDING;
          } else if (events[i].getEventStatusCode().equals(APPROVED)) {
            eventStatus = VALUE_APPROVAL;
          }

          if ((eventStatus < taskStatus) && (indTaskNuAcrossCase == false)) {
            bNew = false;
            bNewUsing = false; // this gets set back to true (outside for loop)
            break;
          }
        }
      }

      // this cooresponds to when an event is selected
      for (int i = 0; i < events.length; i++) {
        events[i].setNewUsingEnabled(bNewUsing);
        events[i].setDeleteEnabled(bDelete);

        // mdm - as long as the eventStatus is not NEW, it can create one?
        // shouldn't it be as long as the eventStatus is not NEW and (bNewUsing == true)
        // they can create a new one? 4/10/2003
        if ((events[i].getEventStatusCode().equals(PROCESS)) || (events[i].getEventStatusCode().equals(COMPLETE))
            || (events[i].getEventStatusCode().equals(PENDING)) || (events[i].getEventStatusCode().equals(APPROVED))) {
          // this (at least partially) undoes bNewUsing = false from above
          events[i].setNewUsingEnabled(true);
        }

        if ((events[i].getEventStatusCode().equals(NEW)) || (events[i].getEventStatusCode().equals(PROCESS))) {
          events[i].setDeleteEnabled(true);
        }
        if (events[i].getAllowsNewUsing() == false) {
          events[i].setNewUsingEnabled(false);
        }
        
        if (events[i].getAllowsDelete() == false) {
          events[i].setDeleteEnabled(false);
        } 
        
        // SIR 18013 TASK table has IND_TASK_NEW_USING = '0' for Placement List
        // but for PlacementForCase, we want NewUsingEnabled.
        if (isPlacementForCase(taskCode)) {
          events[i].setNewUsingEnabled(true);
        }
        if (isContactStandards(taskCode)) {
          events[i].setDeleteEnabled(true);
        }
      }
    } else {
      bNew = false;
      bNewUsing = false;
      bDelete = false;
      
      // STGAP00010963: If there are no Exchange child Registration events in PROC status for the child and
      // if the user has SAU Sealed or SAU Staff attribute, than display the ADD button on the Exchange
      // Child Registration event list, even if the user has no stage access.
      if (indNoProcEvents && isExchangeChild(taskCode)
          && (userProfile.hasRight(UserProfile.SEC_SAU_SEALED) || userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE))) {
        bNew = true;
      }
      
      
      // STGAP00010868: If there are no Exchange Home Registration events in PROC status for the home and
      // if the user has SAU Sealed or SAU Staff attribute, than display the ADD button on the Exchange
      // Home Registration event list, even if the user has no stage access.
      if (indNoProcEvents && isExchangeHome(taskCode)
          && (userProfile.hasRight(UserProfile.SEC_SAU_SEALED) || userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE))) {
        bNew = true;
      }
      
 
      // if the user has SAU Sealed attribute, than display the ADD button for the Non-compliance adds
      // event list, even if the user has no stage access.
      CaseUtility.Stage stage = CaseUtility.getStage(stageId);
      if (stageClosed == false && isNonCompliance(taskCode) && userProfile.hasRight(UserProfile.SEC_SAU_SEALED) && 
                      (CaseUtility.hasStageAccess(userProfile.getUserID(), stage.getIdStage()) == true)) {
        bNew = true;
      }
      
      // if the user has SAU Sealed attribute, than display the ADD button for the Non-compliance adds
      // event list, even if the user has no stage access.
      if (stageClosed == false && isNonCompliance(taskCode) && userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE) && 
                      (CaseUtility.hasStageAccess(userProfile.getUserID(), stage.getIdStage()) == true)) {
        bNew = true;
      }
      
      // This is analogous to coming from CaseSummary in CAPs
      if (("".equals(caller)) && (taskCode != null) && (stageClosed)
          && (isServiceAuthorization(taskCode) || isLegalStatus(taskCode))) {
        bDetail = true;

        boolean canCreateServiceAuthorization = isServiceAuthorization(taskCode)
                                                && userProfile.hasRight(UserProfile.SEC_MNTN_SVC_AUTH);

        boolean canCreateLegalStatus = isLegalStatus(taskCode) && userProfile.hasRight(UserProfile.SEC_MNTN_LEGAL_STAT);

        if ((reasonStageClosed.equals(CLOSED_TO_MERGE) == false)
            && (canCreateServiceAuthorization || canCreateLegalStatus)) {
          bNew = true;
        }
      }
      
      //STGAP00012833: Added this code to show add button even if the stage is closed as case reviews can be done on closed cases
      if((stageClosed || !hasStageAccess)&& userProfile.hasRight(UserProfile.SEC_CASE_REVIEW ) && (CASE_REVIEW_INT.equals(taskCode) || CASE_REVIEW_INV.equals(taskCode) ||
                                      CASE_REVIEW_SUB.equals(taskCode) || CASE_REVIEW_ADO.equals(taskCode) ||
                                      CASE_REVIEW_FPR.equals(taskCode) || CASE_REVIEW_DIV.equals(taskCode))){
        bNew = true;
      }

      for (int i = 0; i < events.length; i++) {
        events[i].setNewUsingEnabled(bNewUsing);
      }
    }
    // end of port from ccmn51w.win

    // Stages with Output Launch Events cannot have more than
    // one Event of the same type in PROC status.
    //For CDNFSI events ,even if there is a PROC event we should be able to create another CDNFSI event as there could be more
    //than one child in the stage for whom we need to create CNS events
    boolean disableNew = false;
    if (("".equals(caller)) && (taskCode != null) && (events.length > 0)
        && (OUTPUT_LAUNCH_WINDOW.equals(events[0].getTopWindow())) && !isCDNFSI(taskCode)) {

      for (int i = 0; i < events.length; i++) {
        if (events[i].getEventStatusCode().equals(PROCESS) || bOutProc == true) {
          disableNew = true;
          break;
        }
      }
      if (disableNew) {
        bNewUsing = false;
        bNew = false;
        for (int i = 0; i < events.length; i++) {
          events[i].setNewUsingEnabled(false);
        }
      }
    }

    if(isCDNFSI(taskCode)){
      for (int i = 0; i < events.length; i++) {
      //SMS#54780: Can Copy only the APRV CNS events
      if(!(events[i].getEventStatusCode().equals(APPROVED))){
        events[i].setNewUsingEnabled(false);
      }
      }      
    }
    // enable New Using Button only if it is enabled for at least 1 event
    // in the list.
    bNewUsing = false;
    for (int i = 0; i < events.length; i++) {
      if (events[i].getNewUsingEnabled()) {
        bNewUsing = true;
        break;
      }
    }
    // Neither New, New Using or Delete is allowed if we are in approval mode
    // and the stage closure event is pending.
    if (bStageBeingApproved) {
      bNew = false;
      bNewUsing = false;
      bDelete = false;
    }
    
    //STGAP00005759 - Do not display copy button if event list is service Authorization list page or service auth for case list page
    if(isServiceAuthorization(taskCode) || isServiceAuthorizationForCase(taskCode)){
      bNewUsing = false;
    }

    //if the StageIsSealedDisableNewUsing has been set it overrides all other settings
    if (bStageIsSealedDisableNewUsing ){
      bNewUsing = false;
    }

    //SMS#45504 If the Stage is closed and the event of type CFR do not show ADD button
    //Do not show ADD button for CNS in closed stages
    CaseUtility.Stage stage = CaseUtility.getStage("" + stageId);
    if((isChildrenFirstReferral(taskCode) || isCDNFSI(taskCode)) && isStageClosed(stage)){
      bNew = false;
      bNewUsing = false;
    }
    
    EventListWindowStateDB eventListWindowState = new EventListWindowStateDB();
    eventListWindowState.setNewUsingEnabled(bNewUsing);
    eventListWindowState.setDeleteEnabled(bDelete);
    eventListWindowState.setNewEnabled(bNew);
    eventListWindowState.setEventHistoryEnabled(bEventHistory);
    eventListWindowState.setDetailEnabled(bDetail);
    eventListWindowState.setEditEnabled(bEdit);
    // SIR 18642 GRIMSHAN -- set a new method so that if the event list has an
    // in process event for output launch, the new using pushbutton will not
    // be displayed even when pagination occurs.
    eventListWindowState.setOutProc(disableNew);

    GrndsTrace.msg(TRACE_TAG, 7, "eventListWindowState: \n" + " eventListWindowState.getNewUsingEnabled(): "
                                 + eventListWindowState.getNewUsingEnabled() + "\n"
                                 + "eventListWindowState.getDeleteEnabled():" + eventListWindowState.getDeleteEnabled() + "\n"
                                 + " eventListWindowState.getNewEnabled(): " + eventListWindowState.getNewEnabled()
                                 + "\n" + " eventListWindowState.getEventHistoryEnabled(): "
                                 + eventListWindowState.getEventHistoryEnabled() + "\n"
                                 + " eventListWindowState.getDetailEnabled(): "
                                 + eventListWindowState.getDetailEnabled() + "\n");

    return eventListWindowState;
  }

  /**
   * Checks to see if completed Foster Care Application exist for the stage. This is necessary to determine if
   * the 'Add' button needs to be displayed for Foster Care Redetermination.
   * 
   * @param idStage
   * @return boolean
   */
  private boolean checkIfCompletedFosterCareAppExist(long idStage){
    boolean compFceaExist = fce.checkIfCompletedFceaExist(idStage);
    return compFceaExist;
  }
  /**
   * Used by displayStaffList_xa to determine a list of stages for which to look for staff from. The stages are
   * associated with the case.
   *
   * @param caseId    int
   * @param personId  int
   * @param userLogin String
   * @return stageIds
   * @throws ServiceException
   */
  private int[] getStageIds(int caseId, int personId, String userLogin) throws ServiceException {
    CCMN32SI ccmn32si = new CCMN32SI();
    ccmn32si.setUlIdCase(caseId);
    ccmn32si.setUlIdPerson(personId);

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(userLogin);
    archInputStruct.setUlPageSizeNbr(40);
    archInputStruct.setUsPageNbr(1);

    ccmn32si.setArchInputStruct(archInputStruct);

    CCMN32SO ccmn32so = admin.retrieveStageList(ccmn32si);
    ROWCCMN32SO[] rows = ccmn32so.getROWCCMN32SO_ARRAY().getROWCCMN32SO();

    int[] stageIds = new int[rows.length];
    for (int i = 0; i < rows.length; i++) {
      stageIds[i] = rows[i].getUlIdStage();
    }
    return stageIds;
  }

  /**
   * Scaffolding
   *
   * @param idPerson int
   * @return String
   * @throws SQLException
   */
  public static String getFullNameForPersonId(int idPerson) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      String sql = "select nm_person_full from person where id_person =  ?";
      connection = JdbcHelper.getConnection();
      statement = connection.prepareStatement(sql);
      statement.setInt(1, idPerson);
      resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {
        return resultSet.getString(1);
      }
      return "";
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  /**
   * Retrieve EventSearchDB from state; create a new one if one isn't there
   *
   * @param request HttpServletRequest
   * @return eventSearchDB
   */
  public static EventSearchDB getEventSearchDB(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    EventSearchDB eventSearchDB = (EventSearchDB) state.getAttribute(EVENT_SEARCH_DB, request);

    if (eventSearchDB != null) {
      return eventSearchDB;
    }

    eventSearchDB = newEventSearchDB(request);
    setEventSearchDB(request, eventSearchDB);
    return eventSearchDB;
  }

  /**
   * initializes EventSearchDB
   *
   * @param request HttpServletRequest
   * @return eventSearchDB
   */
  protected static EventSearchDB newEventSearchDB(HttpServletRequest request) {
    EventSearchDB eventSearchDB = new EventSearchDB();
    eventSearchDB.setSearchEntireCase(GlobalData.getUlIdStage(request) == 0);
    return eventSearchDB;
  }

  /**
   * Set EventSearchDB into state
   *
   * @param request       HttpServletRequest
   * @param eventSearchDB EventSearchDB
   */
  protected static void setEventSearchDB(HttpServletRequest request, EventSearchDB eventSearchDB) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.setAttribute(EVENT_SEARCH_DB, eventSearchDB, request);
  }

  /**
   * Helper method for EventSearch.jsp to determine if search call resulted in no results
   *
   * @param request HttpServletRequest
   * @return boolean
   */
  public static boolean searchReturnedNoResults(HttpServletRequest request) {
    String message = MessageLookup.getMessageByNumber(Messages.MSG_CMN_NO_EVENT_FOUND);
    return hasErrorMessage(message, request);
  }

  /**
   * returns EVENTS from request attribute
   *
   * @param request HttpServletRequest
   * @return EventDB[]
   */
  public static EventDB[] getEvents(HttpServletRequest request) {
    return (EventDB[]) request.getAttribute(EVENTS);
  }

  /**
   * returns EVENT_LIST_WINDOW_STATE from request attribute
   *
   * @param request HttpServletRequest
   * @return EventListWindowStateDB
   */
  public static EventListWindowStateDB getEventListWindowState(HttpServletRequest request) {
    return (EventListWindowStateDB) request.getAttribute(EVENT_LIST_WINDOW_STATE);
  }

  /**
   * I use this to get pagination to work correctly on EventList page; if I override ContextHelper.getPreviousUrl() to
   * return the url of the request into the first page, it will unfortunately pass it onto any Detail/Add/NewUsing pages
   * which is undesirable
   *
   * @param request HttpServletRequest
   * @return String
   */
  public static String getCaller(HttpServletRequest request) {
    return ContextHelper.getStringSafe(request, CALLER);
  }

  /**
   * Returns the TXT_TASK_DECODE column for the taskCode
   *
   * @param taskCode String
   * @return getTaskColumnString
   */
  public static String decodeTask(String taskCode) {
    return TaskInit.getTaskColumnString(taskCode, TaskInit.TXT_TASK_DECODE);
  }

  /**
   * Returns the CD_TASK_EVENT_TYPE column for the taskCode
   *
   * @param taskCode String
   * @return getTaskColumnString
   */
  protected static String getEventType(String taskCode) {
    return TaskInit.getTaskColumnString(taskCode, TaskInit.CD_TASK_EVENT_TYPE);
  }

  /**
   * Returns the IND_TASK_NU_ACROSS_CASE column for the taskCode
   *
   * @param taskCode String
   * @return indTaskNuAcrossCase
   */
  protected static boolean getIndTaskNuAcrossCase(String taskCode) {
    String indTaskNuAcrossCase = TaskInit.getTaskColumnString(taskCode, TaskInit.IND_TASK_NU_ACROSS_CASE);

    return isTrue(indTaskNuAcrossCase);
  }

  /**
   * Returns the TXT_EVENT_DETAIL_URL column for the taskCode
   *
   * @param taskCode String
   * @return eventDetailUrl
   */
  protected static String getTaskDetailUrl(String taskCode) {
    if ((taskCode == null) || ("".equals(taskCode.trim()))) {
      return null;
    }

    String eventDetailUrl = TaskInit.getTaskColumnString(taskCode, TaskInit.TXT_EVENT_DETAIL_URL);

    if (eventDetailUrl != null) {
      return eventDetailUrl;
    }
    // added taskCode at the end for a little extra debugging
    return DUMMY_EVENT_DETAIL + "?" + taskCode;
  }
}
