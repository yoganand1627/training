package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

/**
 * <p/>
 * Title: GlobalData </p>
 * <p/>
 * <p/>
 * Description: This class provides methods for getting and setting values into the context are within state management.
 * </p>
 *
 * @author Bradley Eilers
 * @version 1.0
 */
public abstract class GlobalData {

  private static final String APP_MODE = "appMode";
  private static final String APPROVAL_EVENTS = "APPROVAL_EVENTS";
  private static final String CD_COUNTY = "szCdCounty";
  private static final String CD_INVO_PHASE = "szCdInvoPhase";
  private static final String CD_STAGE = "szCdStage";
  private static final String CD_STAGE_PROGRAM = "szCdStageProgram";
  private static final String CD_STAGE_TYPE = "szCdStageType";
  private static final String CD_TASK = "szCdTask";
  private static final String HAS_STAGE_ACCESS = "hasStageAccess";
  //private static final String HAS_SYS_SUPERVISOR_ACCESS = "hasSysSupervisorAccess";
  private static final String ID_STAGE_CLOSURE = "isStageBeingApproved";
  private static final String ID_APPROVAL = "ulIdApproval";
  private static final String ID_CASE = "ulIdCase";
  private static final String ID_CONTRACT = "ulIdContract";
  private static final String ID_CRS ="ulIdCrs";
  private static final String ID_EVENT = "ulIdEvent";
  private static final String ID_INVOICE = "ulIdInvoice";
  private static final String ID_PERSON = "ulIdPerson";
  private static final String ID_RESOURCE = "ulIdResource";
  private static final String ID_STAFF = "ulIdStaff";
  private static final String ID_STAGE = "ulIdStage";
  private static final String ID_TODO = "ulIdTodo";
  private static final String NBR_CNPER_PERIOD = "ulNbrCnperPeriod";
  private static final String NBR_CNVER_VERSON = "ulNbrCnverVersion";
  private static final String NBR_FIN_ACCOUNT = "szNbrFinAccount";
  private static final String NM_CASE = "szNmCase";
  private static final String NM_PERSON_FULL = "szNmPersonFull";
  private static final String NM_RESOURCE = "szNmResource";
  private static final String NM_ORS_RESOURCE = "szNmORSesource";
  private static final String NM_STAFF = "szNmStaff";
  private static final String NM_STAGE = "szNmStage";
  private static final String SERVICE_DECODE = "szServiceDecode";
  private static final String DT_STAGE_START = "dtDtStageStart";
  private static final String Is_PAD_CASE = "isPadCase";
  private static final String ID_ADO_CASE = "ulIdAdoCase";
  private static final String ID_PAD_CASE = "ulIdPadCase";

  /** Creates a new StateContext object. */
  public GlobalData() {
  }

  /**
   * Returns a String containing all elements in the GlobalData object. Comma delimited list of name : value.  Useful
   * for debugging purposes.
   *
   * @param request
   * @return SPB 12/04
   */
  public static String toString(HttpServletRequest request) {
    StringBuffer globalData = new StringBuffer();
//    private static final String APP_MODE = "appMode";
    globalData.append("App Mode: ").append(GlobalData.getAppMode(request)).append(", \n");
//    private static final String APPROVAL_EVENTS = "APPROVAL_EVENTS";
    globalData.append("Approval Events: ").append(getApprovalEventsString(request)).append(", \n");
//    private static final String CD_COUNTY = "szCdCounty";
    globalData.append("County: ").append(GlobalData.getSzCdCounty(request)).append(", \n");
//    private static final String CD_INVO_PHASE = "szCdInvoPhase";
    globalData.append("Invoice Phase: ").append(GlobalData.getSzCdInvoPhase(request)).append(", \n");
//    private static final String CD_STAGE = "szCdStage";
    globalData.append("Stage Code: ").append(GlobalData.getSzCdStage(request)).append(", \n");
//    private static final String CD_STAGE_PROGRAM = "szCdStageProgram";
    globalData.append("Stage Program Code: ").append(GlobalData.getSzCdStageProgram(request)).append(", \n");
//    private static final String CD_STAGE_TYPE = "szCdStageType";
    globalData.append("Stage Type Code: ").append(GlobalData.getSzCdStageType(request)).append(", \n");
//    private static final String CD_TASK = "szCdTask";
    globalData.append("Task Code: ").append(GlobalData.getSzCdTask(request)).append(", \n");
//    private static final String HAS_STAGE_ACCESS = "hasStageAccess";
    globalData.append("Has Stage Access: ").append(GlobalData.hasStageAccess(request)).append(", \n");
//    private static final String ID_APPROVAL = "ulIdApproval";
    globalData.append("Approval ID: ").append(GlobalData.getUlIdApprovalAsString(request)).append(", \n");
//    private static final String ID_CASE = "ulIdCase";
    globalData.append("Case ID: ").append(GlobalData.getUlIdCaseAsString(request)).append(", \n");
//    private static final String ID_CONTRACT = "ulIdContract";
    globalData.append("Contract ID: ").append(GlobalData.getUlIdContract(request)).append(", \n");
//    private static final String ID_CRS = "ulIdContract";
    globalData.append("CRS ID: ").append(GlobalData.getUlIdCrs(request)).append(", \n");
//    private static final String ID_EVENT = "ulIdEvent";
    globalData.append("Event ID: ").append(GlobalData.getUlIdEventAsString(request)).append(", \n");
//    private static final String ID_INVOICE = "ulIdInvoice";
    globalData.append("Invoice ID: ").append(GlobalData.getUlIdInvoice(request)).append(", \n");
//    private static final String ID_PERSON = "ulIdPerson";
    globalData.append("Person ID: ").append(GlobalData.getUlIdPersonAsString(request)).append(", \n");
//    private static final String ID_RESOURCE = "ulIdPerson";
    globalData.append("Resource ID: ").append(GlobalData.getUlIdResourceAsString(request)).append(", \n");
//    private static final String ID_STAFF = "ulIdStaff";
    globalData.append("Staff ID: ").append(GlobalData.getUlIdStaff(request)).append(", \n");
//    private static final String ID_STAGE = "ulIdStage";
    globalData.append("Stage ID: ").append(GlobalData.getUlIdStageAsString(request)).append(", \n");
//    private static final String ID_TODO = "ulIdTodo";
    globalData.append("Todo ID: ").append(GlobalData.getUlIdTodoAsString(request)).append(", \n");
//    private static final String NBR_CNPER_PERIOD = "ulNbrCnperPeriod";
    globalData.append("Contract Period Number: ").append(GlobalData.getUlNbrCnverVersion(request)).append(", \n");
//    private static final String NBR_CNVER_VERSON = "ulNbrCnverVersion";
    globalData.append("Contract Version Number: ").append(GlobalData.getUlNbrCnverVersion(request)).append(", \n");
//    private static final String NBR_FIN_ACCOUNT = "szNbrFinAccount";
    globalData.append("Account Number: ").append(GlobalData.getSzNbrFinAccount(request)).append(", \n");
//    private static final String NM_CASE = "szNmCase";
    globalData.append("Case Name: ").append(GlobalData.getSzNmCase(request)).append(", \n");
//    private static final String NM_PERSON_FULL = "szNmPersonFull";
    globalData.append("Person Name: ").append(GlobalData.getSzNmPersonFull(request)).append(", \n");
//    private static final String NM_RESOURCE = "szNmResource";
    globalData.append("Resource Name: ").append(GlobalData.getSzNmResource(request)).append(", \n");
//  private static final String NM_ORS_RESOURCE = "szNmORSResource";
    globalData.append("ORS Resource Name: ").append(GlobalData.getSzNmORSResource(request)).append(", \n");
//    private static final String NM_STAFF = "szNmStaff";
    globalData.append("Staff Name: ").append(GlobalData.getSzNmStaff(request)).append(", \n");
//    private static final String NM_STAGE = "szNmStage";
    globalData.append("Stage Name: ").append(GlobalData.getSzNmStage(request)).append(", \n");
//    private static final String SERVICE_DECODE = "szServiceDecode";
    globalData.append("Service Decode: ").append(GlobalData.getSzServiceDecode(request)).append(", \n");
//    private static final String DT_STAGE_START = "dtDtStageStart";
    globalData.append("Stage Start Date: ").append(GlobalData.getDtDtStageStart(request)).append(", \n");
//  private static final String Is_PAD_CASE = "isPadCase";
    globalData.append("Is PAD Case: ").append(GlobalData.isPadCase(request)).append(", \n");
//  private static final String ID_ADO_CASE = "ulIdAdoCase"
    globalData.append("ADO Case Id: ").append(GlobalData.getUlIdAdoCaseAsString(request)).append(", \n");
//  private static final String ID_PAD_CASE = "ulIdPadCase"
    globalData.append("PAD Case Id: ").append(GlobalData.getUlIdPadCaseAsString(request)).append(", \n");
    return globalData.toString();
  }

  /**
   * Gets the global application mode, which can be used to decide the page mode for a specific page. Conversations
   * should use this method to get the page mode set by previous conversations, and then they should use
   * PageMode.setPageMode() and PageMode.getPageMode() to manipulate the page modes for their own specific pages.
   *
   * @param request
   * @return
   */
  public static String getAppMode(HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    String appMode = (String) state.getContextParameter(APP_MODE, request);
    if (appMode == null) {
      appMode = PageModeConstants.VIEW;
    }
    return appMode;
  }

  /**
   * Sets the global application mode, which can be used to calculate the PageMode.pageMode for a specific page. This
   * set method should only be used in the following conversations: <ul> <li>Assigned Workload <li>Case Summary
   * <li>Person Detail <li>Call Info <li>Event List <li>FA List <li>Resource Detail <li>Staff Detail <li>Invoice Header
   * <li>Contracts Header <li>Financial Account Detail <li>Call Log <li>Case List <li>Staff, Case, and Summary To-Do
   * <ul> Everywhere else should use PageMode.setPageMode() for setting pageMode information that persists throughout
   * their conversation
   *
   * @param appMode
   * @param request
   */
  public static void setAppMode(String appMode, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    if (!(PageModeConstants.EDIT.equals(appMode) || PageModeConstants.VIEW.equals(appMode))) {
      throw new IllegalArgumentException
              ("appMode should only be PageMode.EDIT or " +
               "PageMode.VIEW; not '" + appMode + "'");
    }
    state.setContextParameter(APP_MODE, appMode, request);
  }

  /**
   * Indicates whether or not the user is in approval mode for a stage closure event.
   *
   * @param request
   * @return
   */
  public static boolean isStageClosureBeingApproved(HttpServletRequest request) {
    int idStageClosure = getParameterAsInt(ID_STAGE_CLOSURE, request);
    // if idStageClosure is equal to ulIdStage, then we are approving a stage
    return idStageClosure == getUlIdStage(request);
  }

  /**
   * Indicates whether or not the application is in approval mode; APPROVAL mode is indicated by whether or not the
   * current event is one of those being approved.
   *
   * @param request
   * @return
   */
  public static boolean isApprovalMode(HttpServletRequest request) {
    return isEventBeingApproved(getUlIdEvent(request), request) || isStageClosureBeingApproved(request);
  }

  /**
   * Returns the list of currently approvable events.
   *
   * @param request
   * @return
   */
  public static int[] getApprovalEvents(HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    int[] approvalEvents = (int[]) state.getContextParameter(APPROVAL_EVENTS, request);
    return approvalEvents == null ? new int[0] : approvalEvents;
  }

  /**
   * Returns the list of currently approvable events as a human-readible array.
   *
   * @param request
   * @return
   */
  public static String getApprovalEventsString(HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    int[] approvalEvents = (int[]) state.getContextParameter(APPROVAL_EVENTS, request);
    approvalEvents = approvalEvents == null ? new int[0] : approvalEvents;
    StringBuffer sb = new StringBuffer();
    sb.append("{ ");
    if (approvalEvents.length > 0) {
      for (int i = 0; i < approvalEvents.length; i++) {
        int approvalEvent = approvalEvents[i];
        sb.append(approvalEvent).append(", ");
      }
      sb.deleteCharAt(sb.lastIndexOf(","));
    }
    sb.append("}");
    return sb.toString();
  }

  /**
   * Indicates whether or not the event passed in is currently approvable.
   *
   * @param idEvent
   * @param request
   * @return
   */
  public static boolean isEventBeingApproved(int idEvent, HttpServletRequest request) {
    int[] approvalEvents = getApprovalEvents(request);
    // return false immediately if there are no current approvable events
    if (approvalEvents == null) {
      return false;
    }
    int index = Arrays.binarySearch(approvalEvents, idEvent);
    // Arrays.binarySearch returns a non-negative index if the key is found
    return index >= 0;
  }

  /**
   * This method is used to return a flag set into the ArchInputStruct that indicates whether or not to invalidate
   * existing approvals.  To do so, it checks to see if we are in approval mode using the isApprovalMode() method, which
   * in turn defines approval mode as having approvable events.
   *
   * @param request
   * @return
   */
  public static String getApprovalFlag(HttpServletRequest request) {
    boolean eventBeingApproved = isEventBeingApproved(getUlIdEvent(request), request);
    int idStageClosure = getParameterAsInt(ID_STAGE_CLOSURE, request);
    return (eventBeingApproved || (idStageClosure == getUlIdStage(request)))
           ? ArchitectureConstants.Y : ArchitectureConstants.N;
  }

  /**
   * This method will set the application into APPROVE mode.  Note that APPROVE mode will never be returned by
   * GlobalData.getPageMode(); instead, it only controls isApprovalMode() and getApprovalFlag(). It should
   * <i><b>only</b></i> be used by Staff To-Do and Case To-Do. The application will remain in approve mode until idTodo
   * is changed.
   *
   * @param idTodo             The id todo of the approval
   * @param idApproval         The id of the approval
   * @param approvalEvents     The list of events associated with the approvals
   * @param idStageBeingClosed The stage id of the stage being closed (if Task.IND_STAGE_CLOSURE = '1' for the
   *                           associated task)
   * @param request            The current <tt>HttpServletRequest</tt>
   */
  public static void setApprovalMode(int idTodo, int idApproval, int[] approvalEvents, int idStageBeingClosed,
                                     HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    // setUlIdTodo clears out the approvable events; therefore,
    // it MUST be called before setting the array of approvable events
    setUlIdTodo(idTodo, request);
    // sort the array for faster search later on
    Arrays.sort(approvalEvents);
    state.setContextParameter(ID_APPROVAL, String.valueOf(idApproval), request);
    state.setContextParameter(APPROVAL_EVENTS, approvalEvents, request);
    // special case the stage closure
    state.setContextParameter(ID_STAGE_CLOSURE, String.valueOf(idStageBeingClosed), request);
    // The app mode should always be in EDIT when this is called
    state.setContextParameter(APP_MODE, PageModeConstants.EDIT, request);
  }

  /**
   * Get the task name from the global data store
   *
   * @return String - szCdInvoPhase SPB 12/04
   */
  public static String getSzCdInvoPhase(HttpServletRequest request) {
    return getParameterAsString(CD_INVO_PHASE, request);
  }

  /**
   * Description
   *
   * @param szCdInvoPhase param SPB 12/04
   */
  public static void setSzCdInvoPhase(String szCdInvoPhase, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(CD_INVO_PHASE, szCdInvoPhase, request);
  }

  /**
   * Description
   *
   * @return String - County Code
   */
  public static String getSzCdCounty(HttpServletRequest request) {
    return getParameterAsString(CD_COUNTY, request);
  }

  /**
   * Description
   *
   * @param szCdCounty param
   */
  public static void setSzCdCounty(String szCdCounty, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(CD_COUNTY, szCdCounty, request);
  }

  /**
   * Description
   *
   * @return String - Stage Code
   */
  public static String getSzCdStage(HttpServletRequest request) {
    return getParameterAsString(CD_STAGE, request);
  }

  /**
   * Description
   *
   * @param szCdStage param
   */
  public static void setSzCdStage(String szCdStage, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(CD_STAGE, szCdStage, request);
  }

  /**
   * Description
   *
   * @return String - Stage Program
   */
  public static String getSzCdStageProgram(HttpServletRequest request) {
    return getParameterAsString(CD_STAGE_PROGRAM, request);
  }

  /**
   * Description
   *
   * @param szCdStageProgram param
   */
  public static void setSzCdStageProgram(String szCdStageProgram, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(CD_STAGE_PROGRAM, szCdStageProgram, request);
  }

  /**
   * Description
   *
   * @return String - Stage Type Code
   */
  public static String getSzCdStageType(HttpServletRequest request) {
    return getParameterAsString(CD_STAGE_TYPE, request);
  }

  /**
   * Description
   *
   * @param szCdStageType param
   */
  public static void setSzCdStageType(String szCdStageType, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(CD_STAGE_TYPE, szCdStageType, request);
  }

  /**
   * Get the task name from the global data store
   *
   * @return String - task name
   */
  public static String getSzCdTask(HttpServletRequest request) {
    return getParameterAsString(CD_TASK, request);
  }

  /**
   * Description
   *
   * @param szCdTask param
   */
  public static void setSzCdTask(String szCdTask, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(CD_TASK, szCdTask, request);
  }

  /**
   * Should be used by conversations to get the value of gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.hasStageAccess().
   * This variable should be equivalent to the value of CaseUtility.hasStageAccess() at all times, but is used to
   * obviate the need for those queries every time, and improve performance.
   *
   * @param request
   * @return
   */
  public static boolean hasStageAccess(HttpServletRequest request) {
    return getParameterAsBoolean(HAS_STAGE_ACCESS, request);
  }

  /**
   * Should be used by Case Summary and Event List to set a global variable equivalent to the value of
   * gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.hasStageAccess(). Should also be used by ToDoList and Workload
   * to set the global variable to true. This variable should be equivalent to the value of CaseUtility.hasStageAccess()
   * at all times, but is used to obviate the need for those queries every time, and improve performance.
   *
   * @param accessAllowed
   * @param request
   */
  public static void setStageAccess(boolean accessAllowed, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(HAS_STAGE_ACCESS, String.valueOf(accessAllowed), request);
  }

//  /**
//   * Get the bSysIndSupervisor from the global data store
//   * @param request param
//   * @return boolean - bSysIndSupervisor
//   */
//  public static boolean hasSysSupervisorAccess( HttpServletRequest request )
//  {
//    return getParameterAsBoolean( HAS_SYS_SUPERVISOR_ACCESS, request );
//  }

//  /**
//   * Description
//   *
//   * @param SysSupervisorAccess param
//   */
//  public static void setSysSupervisorAccess( boolean SysSupervisorAccess, HttpServletRequest request )
//  {
//    BaseSessionStateManager state = getState( request );
//    state.setContextParameter( HAS_SYS_SUPERVISOR_ACCESS, String.valueOf( SysSupervisorAccess ), request );
//  }

  /**
   * Get the id approval from the global data store; note that the id approval can <i>only</i> be set with
   * setApprovalMode(), and should only be set from one of the To-Do lists.
   *
   * @param request param
   * @return int - approval id
   */
  public static int getUlIdApproval(HttpServletRequest request) {
    return getParameterAsInt(ID_APPROVAL, request);
  }

  /**
   * Get the id approval from the global data store; note that the id approval can <i>only</i> be set with
   * setApprovalMode(), and should only be set from one of the To-Do lists.
   *
   * @param request param
   * @return String - Id Approval
   */
  public static String getUlIdApprovalAsString(HttpServletRequest request) {
    return getParameterAsString(ID_APPROVAL, request);
  }

  /**
   * Get the id case from the global data store
   *
   * @param request param
   * @return int - case id
   */
  public static int getUlIdCase(HttpServletRequest request) {
    return getParameterAsInt(ID_CASE, request);
  }

  /**
   * Get the id case from the global data store
   *
   * @param request param
   * @return String - Id Case
   */
  public static String getUlIdCaseAsString(HttpServletRequest request) {
    return getParameterAsString(ID_CASE, request);
  }

  /**
   * Description
   *
   * @param ulIdCase param
   */
  public static void setUlIdCase(int ulIdCase, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_CASE, String.valueOf(ulIdCase), request);
  }

  /**
   * Description
   *
   * @return int - ulIdContract SPB 11/19
   */
  public static int getUlIdContract(HttpServletRequest request) {
    return getParameterAsInt(ID_CONTRACT, request);
  }

  /**
   * Description
   *
   * @param ulIdContract param SPB 11/19
   */
  public static void setUlIdContract(int ulIdContract, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_CONTRACT, String.valueOf(ulIdContract), request);
  }

  /**
   * Description
   *
   * @return int - Person Id
   */
  public static int getUlIdCrs(HttpServletRequest request) {
    return getParameterAsInt(ID_CRS, request);
  }

  /**
   * Description
   *
   * @return int - Person Id
   */
  public static String getUlIdCrsAsString(HttpServletRequest request) {
    return getParameterAsString(ID_CRS, request);
  }

  /**
   * Description
   *
   * @param ulIdCrs param
   */
  public static void setUlIdCrs(int ulIdCrs, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_CRS, String.valueOf(ulIdCrs), request);
  }

  /**
   * Get the id event from the global data store
   *
   * @return int - id event
   */
  public static int getUlIdEvent(HttpServletRequest request) {
    return getParameterAsInt(ID_EVENT, request);
  }

  /**
   * Get the id event from the global data store
   *
   * @return String - id event
   */
  public static String getUlIdEventAsString(HttpServletRequest request) {
    return getParameterAsString(ID_EVENT, request);
  }
  
  /**
   * Should be used by Case Summary to set a global variable 'isPadCase' to true under certain conditions. This variable 
   * is set to true when the user accessing a case has the SAU Sealed attribute, the case has a PAD Stage, and the corresponding Adoption
   * stage is recorded in another case in shines. The purpose of setting this variable is to display the ADO case stages in the case summary
   * page of the PAD case for the SAU user
   *
   * @param request
   * @return
   */
  public static boolean isPadCase(HttpServletRequest request) {
    return getParameterAsBoolean(Is_PAD_CASE, request);
  }
  
  /**
   * Should be used by Case Summary to set a global variable 'isPadCase' to true under certain conditions. This variable 
   * is set to true when the user accessing a case has the SAU Sealed attribute, the case has a PAD Stage, and the corresponding Adoption
   * stage is recorded in another case in shines. The purpose of setting this variable is to display the ADO case stages in the case summary
   * page of the PAD case for the SAU user.
   *
   * @param isPadCase
   * @param request
   */
  public static void setPadCase(boolean isPadCase, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(Is_PAD_CASE, String.valueOf(isPadCase), request);
  }
  

  /**
   * Description
   *
   * @param ulIdEvent param
   */
  public static void setUlIdEvent(int ulIdEvent, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_EVENT, String.valueOf(ulIdEvent), request);
  }

  /**
   * Description
   *
   * @return int - Invoice Id
   */
  public static int getUlIdInvoice(HttpServletRequest request) {
    return getParameterAsInt(ID_INVOICE, request);
  }

  /**
   * Description
   *
   * @param ulIdInvoice param
   */
  public static void setUlIdInvoice(int ulIdInvoice, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_INVOICE, String.valueOf(ulIdInvoice), request);
  }

  /**
   * Description
   *
   * @return int - Person Id
   */
  public static int getUlIdPerson(HttpServletRequest request) {
    return getParameterAsInt(ID_PERSON, request);
  }

  /**
   * Description
   *
   * @return String - Person Id
   */
  public static String getUlIdPersonAsString(HttpServletRequest request) {
    return getParameterAsString(ID_PERSON, request);
  }

  /**
   * Description
   *
   * @param ulIdPerson param
   */
  public static void setUlIdPerson(int ulIdPerson, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_PERSON, String.valueOf(ulIdPerson), request);
  }

  /**
   * Description
   *
   * @return int - Resource Id
   */
  public static int getUlIdResource(HttpServletRequest request) {
    return getParameterAsInt(ID_RESOURCE, request);
  }

  /**
   * Description
   *
   * @return String - Resource Id
   */
  public static String getUlIdResourceAsString(HttpServletRequest request) {
    return getParameterAsString(ID_RESOURCE, request);
  }

  /**
   * Description
   *
   * @param ulIdResource param
   */
  public static void setUlIdResource(int ulIdResource, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_RESOURCE, String.valueOf(ulIdResource), request);
  }

  /**
   * Get the id staff from the global data store
   *
   * @return int - id staff
   */
  public static int getUlIdStaff(HttpServletRequest request) {
    return getParameterAsInt(ID_STAFF, request);
  }

  /**
   * Get the id staff from the global data store
   *
   * @return String - id staff
   */
  public static String getUlIdStaffAsString(HttpServletRequest request) {
    return getParameterAsString(ID_STAFF, request);
  }

  /**
   * Description
   *
   * @param ulIdStaff param
   */
  public static void setUlIdStaff(int ulIdStaff, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_STAFF, String.valueOf(ulIdStaff), request);
  }

  /**
   * Get the id stage from the global data store
   *
   * @return int - id stage
   */
  public static int getUlIdStage(HttpServletRequest request) {
    return getParameterAsInt(ID_STAGE, request);
  }

  /**
   * Get the id stage from the global data store
   *
   * @return String - id Stage
   */
  public static String getUlIdStageAsString(HttpServletRequest request) {
    return getParameterAsString(ID_STAGE, request);
  }

  /**
   * Description
   *
   * @param ulIdStage param
   */
  public static void setUlIdStage(int ulIdStage, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_STAGE, String.valueOf(ulIdStage), request);
  }

  /**
   * Get the id todo from the global data store
   *
   * @return int - id todo
   */
  public static int getUlIdTodo(HttpServletRequest request) {
    return getParameterAsInt(ID_TODO, request);
  }

  /**
   * Get the id todo from the global data store
   *
   * @return String - id todo
   */
  public static String getUlIdTodoAsString(HttpServletRequest request) {
    return getParameterAsString(ID_TODO, request);
  }

  /**
   * Sets the passed ulIdTodo into the context parameters and clears out approval events, the approval id, and sets
   * isStageBeingApproved() to false.
   *
   * @param ulIdTodo param
   */
  public static void setUlIdTodo(int ulIdTodo, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_TODO, String.valueOf(ulIdTodo), request);
    // setting these two things to null effectively ends approval mode
    state.setContextParameter(APPROVAL_EVENTS, null, request);
    state.setContextParameter(ID_APPROVAL, null, request);
    state.setContextParameter(ID_STAGE_CLOSURE, null, request);
  }

  /**
   * Description
   *
   * @return int - ulNbrCnperPeriod SPB 12/04
   */
  public static int getUlNbrCnperPeriod(HttpServletRequest request) {
    return getParameterAsInt(NBR_CNPER_PERIOD, request);
  }

  /**
   * Description
   *
   * @param ulNbrCnperPeriod param
   */
  public static void setUlNbrCnperPeriod(int ulNbrCnperPeriod, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NBR_CNPER_PERIOD, String.valueOf(ulNbrCnperPeriod), request);
  }

  /**
   * Description
   *
   * @return Date - dtDtStageStart SPB 12/04
   */
  public static org.exolab.castor.types.Date getDtDtStageStart(HttpServletRequest request) {
    return getParameterAsDate(DT_STAGE_START, request);
  }

  /**
   * Description
   *
   * @param dtDtStageStart param
   */
  public static void setDtDtStageStart(org.exolab.castor.types.Date dtDtStageStart, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(DT_STAGE_START, String.valueOf(dtDtStageStart), request);
  }

  /**
   * Description
   *
   * @return int - ulNbrCnverVersion SPB 12/04
   */
  public static int getUlNbrCnverVersion(HttpServletRequest request) {
    return getParameterAsInt(NBR_CNVER_VERSON, request);
  }

  /**
   * Description
   *
   * @param ulNbrCnverVersion param SPB 12/04
   */
  public static void setUlNbrCnverVersion(int ulNbrCnverVersion, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NBR_CNVER_VERSON, String.valueOf(ulNbrCnverVersion), request);
  }

  /**
   * Get the task name from the global data store
   *
   * @return String - szNbrFinAccount SPB 12/04
   */
  public static String getSzNbrFinAccount(HttpServletRequest request) {
    return getParameterAsString(NBR_FIN_ACCOUNT, request);
  }

  /**
   * Description
   *
   * @param szNbrFinAccount param SPB 12/04
   */
  public static void setSzNbrFinAccount(String szNbrFinAccount, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NBR_FIN_ACCOUNT, szNbrFinAccount, request);
  }

  /**
   * Description
   *
   * @return String - Case Name
   */
  public static String getSzNmCase(HttpServletRequest request) {
    return getParameterAsString(NM_CASE, request);
  }

  /**
   * Description
   *
   * @param szNmCase param
   */
  public static void setSzNmCase(String szNmCase, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NM_CASE, szNmCase, request);
  }

  /**
   * Description
   *
   * @return String - Person Name
   */
  public static String getSzNmPersonFull(HttpServletRequest request) {
    return getParameterAsString(NM_PERSON_FULL, request);
  }

  /**
   * Description
   *
   * @param szNmPersonFull param
   */
  public static void setSzNmPersonFull(String szNmPersonFull, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NM_PERSON_FULL, szNmPersonFull, request);
  }

  /**
   * Description
   *
   * @return String - Resource Name SPB 11/19
   */
  public static String getSzNmResource(HttpServletRequest request) {
    return getParameterAsString(NM_RESOURCE, request);
  }

  /**
   * Description
   *
   * @param szNmResource param SPB 11/19
   */
  public static void setSzNmResource(String szNmResource, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NM_RESOURCE, szNmResource, request);
  }
  
  //XXXXXXXXXXXXXXXXXXXXXXXXX
  /**
   * Description
   *
   * @return String - Resource Name SPB 11/19
   */
  public static String getSzNmORSResource(HttpServletRequest request) {
    return getParameterAsString(NM_ORS_RESOURCE, request);
  }

  /**
   * Description
   *
   * @param szNmResource param SPB 11/19
   */
  public static void setSzNmORSResource(String szNmORSResource, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NM_ORS_RESOURCE, szNmORSResource, request);
  }
  
  
  
  //XXXXXXXXXXXXXXXXXXXXXX

  /**
   * Description
   *
   * @return String - Staff Name SPB 11/19
   */
  public static String getSzNmStaff(HttpServletRequest request) {
    return getParameterAsString(NM_STAFF, request);
  }

  /**
   * Description
   *
   * @param szNmStaff param SPB 11/19
   */
  public static void setSzNmStaff(String szNmStaff, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NM_STAFF, szNmStaff, request);
  }

  /**
   * Get the stage name from the global data store
   *
   * @return String - stage name
   */
  public static String getSzNmStage(HttpServletRequest request) {
    return getParameterAsString(NM_STAGE, request);
  }

  /**
   * Description
   *
   * @param szNmStage param
   */
  public static void setSzNmStage(String szNmStage, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(NM_STAGE, szNmStage, request);
  }

  /**
   * Get the task name from the global data store
   *
   * @return String - szServiceDecode SPB 11/19
   */
  public static String getSzServiceDecode(HttpServletRequest request) {
    return getParameterAsString(SERVICE_DECODE, request);
  }

  /**
   * Description
   *
   * @param szServiceDecode param SPB 11/19
   */
  public static void setSzServiceDecode(String szServiceDecode, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(SERVICE_DECODE, szServiceDecode, request);
  }
  

  /**
   * Get the Adoption case Id from the global data store
   *
   * @param request param
   * @return int - Ado case id
   */
  public static int getUlIdAdoCase(HttpServletRequest request) {
    return getParameterAsInt(ID_ADO_CASE, request);
  }
  
  /**
   * Get the Adoption case Id from the global data store
   *
   * @param request param
   * @return String - Id Ado Case
   */
  public static String getUlIdAdoCaseAsString(HttpServletRequest request) {
    return getParameterAsString(ID_ADO_CASE, request);
  }

  /**
   * Description
   *
   * @param ulIdAdoCase param
   */
  public static void setUlIdAdoCase(int ulIdAdoCase, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_ADO_CASE, String.valueOf(ulIdAdoCase), request);
  }
  
  /**
   * Get the PAD case Id from the global data store
   *
   * @param request param
   * @return int - Pad case id
   */
  public static int getUlIdPadCase(HttpServletRequest request) {
    return getParameterAsInt(ID_PAD_CASE, request);
  }
  
  /**
   * Get the id Pad case from the global data store
   *
   * @param request param
   * @return String - Id Pad Case
   */
  public static String getUlIdPadCaseAsString(HttpServletRequest request) {
    return getParameterAsString(ID_PAD_CASE, request);
  }

  /**
   * Description
   *
   * @param ulIdAdoCase param
   */
  public static void setUlIdPadCase(int ulIdPadCase, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    state.setContextParameter(ID_PAD_CASE, String.valueOf(ulIdPadCase), request);
  }

  /** gets request parameter as String */
  private static String getParameterAsString(String param, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    String value = (String) state.getContextParameter(param, request);
    if (value == null) {
      value = "";
    }
    return value;
  }

  /** gets request parameter as int */
  private static int getParameterAsInt(String param, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    int iValue = 0;
    String strParam = (String) state.getContextParameter(param, request);
    if (strParam != null) {
      iValue = Integer.parseInt(strParam);
    }
    return iValue;
  }

  private static boolean getParameterAsBoolean(String param, HttpServletRequest request) {
    String sValue = getParameterAsString(param, request);
    return Boolean.valueOf(sValue);
  }

  /** gets request parameter as Date */
  private static org.exolab.castor.types.Date getParameterAsDate(String param, HttpServletRequest request) {
    BaseSessionStateManager state = getState(request);
    org.exolab.castor.types.Date date = new org.exolab.castor.types.Date();
    String strParam = (String) state.getContextParameter(param, request);
    if (strParam != null) {
      date = DateHelper.toCastorDateSafe(strParam);
    }
    return date;
  }

  /**
   * Gets state for this request, decoding it if necessary; sets state into the Attributes for reuse.
   *
   * @return state State for this request
   */
  public static BaseSessionStateManager getState(HttpServletRequest request) {
    BaseSessionStateManager state;
    if (request != null) {
      state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      if (state == null) {
        state = new HiddenFieldSessionStateManager(request);
      }
    } else {
      state = new HiddenFieldSessionStateManager();
    }

    return state;
  }
}
