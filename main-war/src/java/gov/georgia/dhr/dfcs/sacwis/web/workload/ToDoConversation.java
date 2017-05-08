package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.EventUtility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN97SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.LdIdTodo_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ToDoAUDStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TodoAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.TempAssignment;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UnitStaffIdentifier;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileException;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.financials.SpecialNeedsDeterminationConversation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain to do in the system. <p/> January 30, 2003 Mike K. Werle
 * 
 * <pre>
 *  Change History:
 *   Date        User      Description
 *   ----------  --------  --------------------------------------------------
 *   11/13/03    CORLEYAN  SIR 22405 -- If the To-Do is broken display a message
 *                         telling the user that it is invalid
 *   02/25/04    CORLEYAN  SIR 22610 -- Defualt sort for case todo should be by date
 *   05/26/04    RIOSJA    SIR 22899 - If a 'Close Service Delivery' Case To-Do
 *                         is being created and the CaseUtility search using task
 *                         code of '6010' finds no matching event, perform another
 *                         search for an event of type STG and associate the new
 *                         to-do with that event.
 *   04/20/05    CORLEYAN  SIR 23530 - Added Date Stage Start into global data so that
 *                         The tabs will display correctly.
 *  07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *  12/13/07    eimomio   STGAP00004839 Assign Detail:  SSCM closed a case with SSCM security clearance
 *  11/06/2008  wjcochran STGAP00010737 - The Foster Home Conversion events should NEVER be marked as COMP
 *  06/01/2009  arege     STGAP00013914 Added code so that the Designee of an Approver is able to approve a
 *                        Payment of Care approval task when the designee accesses the page through Case To-Do List page.
 *  07/13/2009  bgehlot   STGAP00014329 - The Safety Resource events should NEVER be marked as COMP
 *  12/04/2009  wjcochran SMS #37449 - Update MAX_DELETE to 100
 *  09/07/2010  wjcochran SMS #47858 - If a Legal Action is submitted for Approval, it should not be set to COMP.
 *  10/20/2010  arege     SMS #76298 Added code so that the Foster Care Redetermination is set to PEND status 
 *                        after save and submit by the Case Manager
 *  03/21/2011  htvo      SMS#97845 MR-074-2 AFCARS: populate IdTodoPersAssigned in a list  
 *                        since the service has been modified to save a list of todos instead of single todo. 
 *  06/05/2011  htvo      SMS#109403 MR-082 AA: adding stage type prefix (ADO/PAD) to Adoption Assistance Application approval tasks.
 *  06/07/2011  htvo      SMS#109403: correct SMS code from 10943 to 109403 
 *  06/07/2011  hjbaptiste SMS#109631: CAPTA 4.3 MIC - Added whichSpclInvApprover string to determine which approver 
 *                         is the current one in order to prepopulate with next approver  
 *  06/07/2011  hjbaptiste SMS#112385: CAPTA 4.3: Safety Resource - fixed logic to add another approver                                                           
 * </pre>
 */
public class ToDoConversation extends BaseHiddenFieldStateConversation {

  // these strings are commonly used in error reporting in this class
  private static final String SERVICE_FAILURE_STRING = "Service Failure:";

  private static final String GENERAL_FAILURE_STRING = "General Failure:";

  private static final String APPROVE_CALL_CD_TASK_NI = "1044";
  
  private static final String BUDGET_LIMIT = "budgetLimit";
  
  private static final String PAYMENT_OF_CARE_APPROVAL_CDTASK = "9465";
  @SuppressWarnings("serial")  
  private static final List<String> LEGAL_ACTION_TASKS = new ArrayList<String>() {
    {
      add("2355");      //INV
      add("2365"); 
      add("3030");      //SUB
      add("4040"); 
      add("4350");      //FSU
      add("4360"); 
      add("5850");      //FRE
      add("5860");
      add("7210");      //FPR
      add("7220");
      add("8540");      //ADO
      add("8550");
      add("2020");      //PFC
      add("2030");
      add("9070");      //PAD
      add("9075");
    }
  };

  private Admin admin;
  
  private EventUtility eventUtility;

  private Fce fce;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setEventUtility(EventUtility eventUtility) {
    this.eventUtility = eventUtility;
  }

  public void setFce(Fce fce) {
    this.fce = fce;
  }

  /**
   * This method returns the ToDoDetailDB instance that is stored in state. It throws a PopulationException wrapped as a
   * RuntimeWrappedException if there is no ToDoDetailDB in state.
   * 
   * @param request
   *          The <tt>HttpServletRequest</tt> object
   * @param state
   *          The <tt>BaseSessionStateManager</tt> object
   * @return An instance of <tt>ToDoDetailDB</tt> containing information to display or save a To-Do
   */
  public static ToDoDetailDB getToDoDetailDB(HttpServletRequest request, BaseSessionStateManager state) {
    ToDoDetailDB toDoDetailDB = (ToDoDetailDB) state.getAttribute(ToDoHelper.TODO_DETAIL_DB_KEY, request);
    if (toDoDetailDB == null) {
      throw new RuntimeWrappedException(new PopulationException("The ToDoDetailDB object was not found in state."));
    }
    return toDoDetailDB;
  }

  /**
   * This method is called by the Grnds controller to display existing To-Do's for viewing for editing. It should only
   * be used from Staff To-Do and Case To-Do for viewing and editing existing To-Do's, never for creating new To-Do's.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object.
   */
  public void displayToDoDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayToDoDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Create the ToDoDetailDB
    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    // Clear state, now that we have the ToDoDeatilDB object
    state.removeAllAttributes(request);

    // Set the todo mode to modify
    toDoDetailDB.setToDoMode(TODO_MODE_MODIFY);

    // Get the user profile so we can get the userId and logonId
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int userId = user.getUserID();
    toDoDetailDB.setUserId(userId);

    // Create and populate an arch input struct with the correct cReqFuncCd and user logon name
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(TODO_MODE_MODIFY_CODE);
    archInputStruct.setSzUserId(user.getUserLogonID());

    // Populate the toDoCaseInfStruct with the passed ToDoDetailDB
    TodoCaseInfStruct todoCaseInfStruct = new TodoCaseInfStruct();
    todoCaseInfStruct.setLdIdTodo(toDoDetailDB.getLdIdTodo());
    todoCaseInfStruct.setSzCdTask(toDoDetailDB.getSzCdTask());

    // Create a CCMN13SI object and assign the sub-objects to it to call CCMN13S
    CCMN13SI ccmn13si = new CCMN13SI();
    ccmn13si.setArchInputStruct(archInputStruct);
    ccmn13si.setTodoCaseInfStruct(todoCaseInfStruct);

    // call the service
    CCMN13SO ccmn13so = callCCMN13S(ccmn13si, context);
    if (ccmn13so == null) {
      // If we get null back, the error has already been handled; just return.
      return;
    }

    // Set the timestamp so we can save
    toDoDetailDB.setTsLastUpdate(ccmn13so.getTsLastUpdate());

    // Set information about the To-Do itself
    TodoInfoStruct todoInfoStruct = ccmn13so.getTodoInfoStruct();
    toDoDetailDB.setDtDtTodoCompleted(todoInfoStruct.getDtDtTodoCompleted());
    toDoDetailDB.setDtDtTodoDue(todoInfoStruct.getDtDtTodoDue());
    toDoDetailDB.setSzCdTodoType(todoInfoStruct.getSzCdTodoType());
    toDoDetailDB.setSzTxtTodoDesc(todoInfoStruct.getSzTxtTodoDesc());
    toDoDetailDB.setTxtTodoLongDesc(todoInfoStruct.getTxtTodoLongDesc());
    toDoDetailDB.setUlIdCase(todoInfoStruct.getUlIdCase());
    toDoDetailDB.setUlIdEvent(todoInfoStruct.getUlIdEvent());
    toDoDetailDB.setLdIdTodo(todoInfoStruct.getLdIdTodo());

    // Set information about the person to whom the To-Do is assigned
    AssignedStruct assignedStruct = ccmn13so.getAssignedStruct();
    toDoDetailDB.setSzNmPersonFullAssigned(assignedStruct.getSzNmPersonFull());
    toDoDetailDB.setUlIdTodoPersAssigned(assignedStruct.getUlIdTodoPersAssigned());

    // Set information about the stage with which the To-Do is associated
    StageStruct stageStruct = ccmn13so.getStageStruct();
    toDoDetailDB.setSzNmPersonFullWorker(stageStruct.getSzNmPersonFull());
    toDoDetailDB.setSzNmStage(stageStruct.getSzNmStage());
    toDoDetailDB.setUlIdStage(stageStruct.getUlIdStage());
    toDoDetailDB.setUlIdTodoPersWorker(stageStruct.getUlIdTodoPersWorker());

    // Set information about the task with which the To-Do is associated
    TaskStruct taskStruct = ccmn13so.getTaskStruct();
    toDoDetailDB.setDtDtTaskDue(taskStruct.getDtDtTaskDue());
    String szCdTask = taskStruct.getSzCdTask();
    toDoDetailDB.setSzCdTask(szCdTask);
    toDoDetailDB.setSzTxtTaskDecode(taskStruct.getSzTxtTaskDecode());

    // Set information about the creation of the To-Do
    CreatedStruct createdStruct = ccmn13so.getCreatedStruct();
    toDoDetailDB.setDtDtTodoCreated(createdStruct.getDtDtTodoCreated());
    toDoDetailDB.setTmTmTodoCreated(createdStruct.getTmTmTodoCreated());
    String szNmPersonFull = createdStruct.getSzNmPersonFull();
    toDoDetailDB.setSzNmPersonFullCreator(szNmPersonFull);
    toDoDetailDB.setInitialsPersonCreated(FormattingHelper.formatUserInitials(szNmPersonFull));
    toDoDetailDB.setUlIdTodoPersCreator(createdStruct.getUlIdTodoPersCreator());

    UnitStaffIdentifier unitStaffIdentifier = UserProfileHelper.getUnitStaffIdentifier(request);
    int unitStaffId = unitStaffIdentifier != null ? unitStaffIdentifier.getUlIdStaff() : -1;

    // Disable the staff search button if it is an Approval To-Do to which the current user
    // or the user as whom the current user is acting is not assigned.
    if (StringHelper.isValid(szCdTask)
        && CodesTables.CEVNTTYP_APP.equals(TaskInit.getTaskColumnString(szCdTask, TaskInit.CD_TASK_EVENT_TYPE))
        && !(toDoDetailDB.getUlIdTodoPersAssigned() == userId || toDoDetailDB.getUlIdTodoPersAssigned() == unitStaffId)) {
      Sets.setPageSet(DISABLE_STAFF_SERACH_BUTTON_SET, request);
    }

    String appMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.VIEW.equals(appMode) ? PageModeConstants.VIEW : PageModeConstants.EDIT,
                         request);

    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller to create a new To-Do with information from an old one. It is used
   * only by To-Do Detail when displaying a new To-Do. To-Do Detail can only be accessed in this way by clicking on "New
   * Using" on Staff To-Do and Case To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object.
   */
  public void newUsingToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".newUsingToDo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Create the ToDoDetailDB
    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    // SIR 22464
    Set validSzCdTaskSet = getValidTaskCodesForCreatingTodos(toDoDetailDB.getUlIdStage(), toDoDetailDB.getSzCdStage(),
                                                             toDoDetailDB.getSzCdStageProgram());

    String szCdTask = toDoDetailDB.getSzCdTask();
    if (validSzCdTaskSet.contains(szCdTask) == false) {
      String taskDecode = TaskInit.getTaskColumnString(szCdTask, "TXT_TASK_DECODE");

      String message = MessageLookup.getMessageByNumber(Messages.MSG_NEW_USING_CASE_TODO_FORBIDDEN);

      message = MessageLookup.addMessageParameter(message, taskDecode);

      setErrorMessage(message, request);
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      return;
    }

    // Clear state, now that we have the ToDoDeatilDB object
    state.removeAllAttributes(request);

    // Set the todo mode to new using
    toDoDetailDB.setToDoMode(TODO_MODE_NEW_USING);

    // Get the user profile so we can get the userId and logonId
    UserProfile user = UserProfileHelper.getUserProfile(request);
    toDoDetailDB.setUserId(user.getUserID());

    // Create and populate an arch input struct with the correct cReqFuncCd and user logon name
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(TODO_MODE_NEW_USING_CODE);
    archInputStruct.setSzUserId(user.getUserLogonID());

    // Populate the toDoCaseInfStruct with the passed ToDoDetailDB
    TodoCaseInfStruct todoCaseInfStruct = new TodoCaseInfStruct();
    todoCaseInfStruct.setLdIdTodo(toDoDetailDB.getLdIdTodo());

    // Create a CCMN13SI object and assign the sub-objects to it to call CCMN13S
    CCMN13SI ccmn13si = new CCMN13SI();
    ccmn13si.setArchInputStruct(archInputStruct);
    ccmn13si.setTodoCaseInfStruct(todoCaseInfStruct);

    // call the service
    CCMN13SO ccmn13so = callCCMN13S(ccmn13si, context);
    if (ccmn13so == null) {
      // If we get null back, the error has already been handled; just return.
      return;
    }

    // Get the user's full name
    String userFullName = user.getUserFullName();
    int userID = user.getUserID();

    // Set the timestamp so we can save
    toDoDetailDB.setTsLastUpdate(ccmn13so.getTsLastUpdate());

    // Set information about the To-Do itself
    TodoInfoStruct todoInfoStruct = ccmn13so.getTodoInfoStruct();
    toDoDetailDB.setSzCdTodoType(todoInfoStruct.getSzCdTodoType());
    toDoDetailDB.setDtDtTodoCompleted(todoInfoStruct.getDtDtTodoCompleted());
    toDoDetailDB.setDtDtTodoDue(todoInfoStruct.getDtDtTodoDue());
    toDoDetailDB.setSzTxtTodoDesc(todoInfoStruct.getSzTxtTodoDesc());
    toDoDetailDB.setUlIdCase(todoInfoStruct.getUlIdCase());
    toDoDetailDB.setUlIdEvent(todoInfoStruct.getUlIdEvent());
    toDoDetailDB.setLdIdTodo(todoInfoStruct.getLdIdTodo());

    // Set information about the person to whom the To-Do is assigned
    AssignedStruct assignedStruct = ccmn13so.getAssignedStruct();
    toDoDetailDB.setSzNmPersonFullAssigned(assignedStruct.getSzNmPersonFull());
    toDoDetailDB.setUlIdTodoPersAssigned(assignedStruct.getUlIdTodoPersAssigned());

    // Set information about the stage with which the To-Do is associated
    StageStruct stageStruct = ccmn13so.getStageStruct();
    toDoDetailDB.setSzNmPersonFullWorker(stageStruct.getSzNmPersonFull());
    toDoDetailDB.setSzNmStage(stageStruct.getSzNmStage());
    toDoDetailDB.setUlIdStage(stageStruct.getUlIdStage());
    toDoDetailDB.setUlIdTodoPersWorker(stageStruct.getUlIdTodoPersWorker());

    // Set information about the task with which the To-Do is associated
    TaskStruct taskStruct = ccmn13so.getTaskStruct();
    toDoDetailDB.setDtDtTaskDue(taskStruct.getDtDtTaskDue());
    toDoDetailDB.setSzCdTask(taskStruct.getSzCdTask());
    toDoDetailDB.setSzTxtTaskDecode(taskStruct.getSzTxtTaskDecode());

    // Set information about the creation of the To-Do
    toDoDetailDB.setDtDtTodoCreated(ccmn13so.getDtWCDDtSystemDate());
    toDoDetailDB.setTmTmTodoCreated(ccmn13so.getTmTmWCDDtSystemTime());
    toDoDetailDB.setSzNmPersonFullCreator(userFullName);
    toDoDetailDB.setInitialsPersonCreated(FormattingHelper.formatUserInitials(userFullName));
    toDoDetailDB.setUlIdTodoPersCreator(userID);

    // PageMode should always be EDIT
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller to create a new To-Do from Case To-Do. It should never be called from
   * any page except for Case To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object.
   */
  public void newCaseToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".newCaseToDo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Create the ToDoDetailDB
    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    // Clear state, now that we have the ToDoDeatilDB object
    state.removeAllAttributes(request);

    // Set the todo mode to new case todo
    toDoDetailDB.setToDoMode(TODO_MODE_NEW_CASE_TODO);

    // Get the stage id for use later
    int ulIdStage = toDoDetailDB.getUlIdStage();

    // Get validSzCdTaskSet
    Set validSzCdTaskSet = getValidTaskCodesForCreatingTodos(ulIdStage, toDoDetailDB.getSzCdStage(),
                                                             toDoDetailDB.getSzCdStageProgram());
    
    toDoDetailDB.setValidSzCdTaskSet(validSzCdTaskSet);
    
    // Get the user profile so we can get the userId and logonId
    UserProfile user = UserProfileHelper.getUserProfile(request);
    toDoDetailDB.setUserId(user.getUserID());
    
    // Create and populate an arch input struct with the correct cReqFuncCd and user logon name
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(TODO_MODE_NEW_CASE_TODO_CODE);
    archInputStruct.setSzUserId(user.getUserLogonID());
    
    // Populate the toDoCaseInfStruct with the passed in ToDoDetailDB
    TodoCaseInfStruct todoCaseInfStruct = new TodoCaseInfStruct();
    todoCaseInfStruct.setUlIdCase(toDoDetailDB.getUlIdCase());
    todoCaseInfStruct.setUlIdStage(ulIdStage);
    
    // Create a CCMN13SI object and assign the sub-objects to it to call CCMN13S
    CCMN13SI ccmn13si = new CCMN13SI();
    ccmn13si.setArchInputStruct(archInputStruct);
    ccmn13si.setTodoCaseInfStruct(todoCaseInfStruct);
    
    // call the service
    CCMN13SO ccmn13so = callCCMN13S(ccmn13si, context);
    if (ccmn13so == null) {
      // If we get null back, the error has already been handled; just return.
      return;
    }
    
    // Get the user's full name
    String userFullName = user.getUserFullName();
    int userID = user.getUserID();
    
    // Get the map for indTaskNew
    Map taskNewIndMap = getTaskNewIndMap(validSzCdTaskSet, toDoDetailDB);
    toDoDetailDB.setTaskNewIndMap(taskNewIndMap);
    
    org.exolab.castor.types.Date dtWCDDtSystemDate = ccmn13so.getDtWCDDtSystemDate();
    String toDoCreatedTime = ccmn13so.getTmTmWCDDtSystemTime();
    // Set information about the To-Do itself
    toDoDetailDB.setSzCdTodoType(CodesTables.CTODOTYP_A);
    toDoDetailDB.setDtDtTodoDue(dtWCDDtSystemDate);
    
    // Set information about the person to whom the To-Do is assigned
    toDoDetailDB.setSzNmPersonFullAssigned(userFullName);
    toDoDetailDB.setUlIdTodoPersAssigned(userID);
    
    // Set information about the stage with which the To-Do is associated
    StageStruct stageStruct = ccmn13so.getStageStruct();
    toDoDetailDB.setSzNmPersonFullWorker(stageStruct.getSzNmPersonFull());
    toDoDetailDB.setSzNmStage(stageStruct.getSzNmStage());
    toDoDetailDB.setUlIdTodoPersWorker(stageStruct.getUlIdTodoPersWorker());
    
    // No task has been chosen, yet, so the information about the task with
    // which the To-Do is associated is not available.
    
    // Set information about the creation of the To-Do
    toDoDetailDB.setDtDtTodoCreated(dtWCDDtSystemDate);
    toDoDetailDB.setTmTmTodoCreated(toDoCreatedTime);
    toDoDetailDB.setSzNmPersonFullCreator(userFullName);
    toDoDetailDB.setInitialsPersonCreated(FormattingHelper.formatUserInitials(userFullName));
    toDoDetailDB.setUlIdTodoPersCreator(userID);
    
    // PageMode should always be new here
    PageMode.setPageMode(PageModeConstants.EDIT, request);
    
    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    //}
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller to create a new To-Do from FCE Income and Expenditures. It should
   * never be called from any page except FCE Income and Expenditures.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object.
   */
  public void newFceToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".newFceTodo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Create the ToDoDetailDB
    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    // Clear state, now that we have the ToDoDeatilDB object
    state.removeAllAttributes(request);

    // Set the todo mode to new case todo
    toDoDetailDB.setToDoMode(TODO_MODE_NEW_FCE_TODO);

    // Get the user profile so we can get the userId and logonId
    UserProfile user = UserProfileHelper.getUserProfile(request);
    toDoDetailDB.setUserId(user.getUserID());

    // Create and populate an arch input struct with the correct cReqFuncCd and user logon name
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(TODO_MODE_NEW_FCE_TODO_CODE);
    archInputStruct.setSzUserId(user.getUserLogonID());

    // Populate the toDoCaseInfStruct with the passed in ToDoDetailDB
    TodoCaseInfStruct todoCaseInfStruct = new TodoCaseInfStruct();
    todoCaseInfStruct.setUlIdCase(toDoDetailDB.getUlIdCase());
    todoCaseInfStruct.setUlIdStage(toDoDetailDB.getUlIdStage());
    String szCdTask = toDoDetailDB.getSzCdTask();
    String szTxtTodoDesc = toDoDetailDB.getSzTxtTodoDesc();
    todoCaseInfStruct.setSzCdTask(szCdTask);

    // Create a CCMN13SI object and assign the sub-objects to it to call CCMN13S
    CCMN13SI ccmn13si = new CCMN13SI();
    ccmn13si.setArchInputStruct(archInputStruct);
    ccmn13si.setTodoCaseInfStruct(todoCaseInfStruct);

    // call the service
    CCMN13SO ccmn13so = callCCMN13S(ccmn13si, context);
    if (ccmn13so == null) {
      // If we get null back, the error has already been handled; just return.
      return;
    }

    // Get the user's full name
    String userFullName = user.getUserFullName();
    int userID = user.getUserID();

    java.util.Date dtWCDDtSystemDate = DateHelper.addToDate(new Date(), 0, 0, 15);

    // Set information about the To-Do itself
    toDoDetailDB.setSzCdTodoType(CodesTables.CTODOTYP_T);
    toDoDetailDB.setDtDtTodoDue(DateHelper.toCastorDate(dtWCDDtSystemDate));

    // Set information about the stage with which the To-Do is associated
    StageStruct stageStruct = ccmn13so.getStageStruct();
    toDoDetailDB.setSzNmPersonFullWorker(stageStruct.getSzNmPersonFull());
    toDoDetailDB.setSzNmStage(stageStruct.getSzNmStage());
    toDoDetailDB.setUlIdTodoPersWorker(stageStruct.getUlIdTodoPersWorker());

    // Set information about the creation of the To-Do
    toDoDetailDB.setDtDtTodoCreated(DateHelper.toCastorDate(dtWCDDtSystemDate));
    toDoDetailDB.setTmTmTodoCreated(FormattingHelper.formatTime(dtWCDDtSystemDate));
    toDoDetailDB.setSzNmPersonFullCreator(userFullName);
    String initials = FormattingHelper.formatUserInitials(userFullName);
    toDoDetailDB.setInitialsPersonCreated(initials);
    toDoDetailDB.setSzTxtTodoDesc(szTxtTodoDesc);
    toDoDetailDB.setUlIdTodoPersCreator(userID);

    // PageMode should always be EDIT here
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    // Set the return URI to To-Do Detail
    toDoDetailDB.setReturnURI(DISPLAY_TODO_DETAIL_URI);

    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    performanceTrace.exitScope();
  }

  /**
   * This method creates a <tt>java.util.Map</tt> containing task codes as keys and an indicator of whethor or not the
   * task code requires that a new To-Do created with it should link to an existing event, not link to an existing
   * event, or prompt the user to ask if it should link to an existing event.
   * 
   * @param validSzCdTaskSet
   * @param toDoDetailDB
   * @return The map containing task codes as keys and an indicator of whethor or not the task code requires that a new
   *         To-Do created with it should link to an existing event, not link to an existing event, or prompt the user
   *         to ask if it should link to an existing event
   */
  private static Map<String, String> getTaskNewIndMap(Set validSzCdTaskSet, ToDoDetailDB toDoDetailDB) {
    Map<String, String> taskNewIndMap = new HashMap<String, String>();
    Iterator validSzCdTaskSetIterator = validSzCdTaskSet.iterator();
    while (validSzCdTaskSetIterator.hasNext()) {
      // LbProcessListcSysIndTaskNewData[x] is set to IND_YES when:
      // cIndTaskRtrvPriorStage == IND_NO (TASK.IND_TASK_RTRV_PRIOR_STAGE)
      // and bIndTaskMultInstance == IND_YES (TASK.IND_TASK_MULTIPLE_INSTANCE)
      // and ( an event exists,
      // but it's event-status is
      // >= the event-status listed on the task table for that task (TASK.CD_TASK_EVENT_STATUS) )
      // and it's not one of the SA tasks

      Option option = (Option) validSzCdTaskSetIterator.next();
      String szCdTask = option.getCode();

      // Service Auth-related events; ccmn32w.win
      if (szCdTask != null) {
        String cdTaskEventType = TaskInit.getTaskColumnString(szCdTask, TaskInit.CD_TASK_EVENT_TYPE);

        if (CodesTables.CEVNTTYP_AUT.equals(cdTaskEventType)) {
          // we are done at this point, so just set the map and continue through the loop
          taskNewIndMap.put(szCdTask, IND_TASK_NEW_FALSE);
          continue;
        }
      }

      CaseUtility.Event event = CaseUtility.getEvent(toDoDetailDB.getUlIdStage(), szCdTask);

      // RIOSJA, SIR 22899 - When a SVC stage is first opened, a STG event
      // is created with a null task code and an event description of
      // 'Service Delivery Stage Opened'. When the worker subsequently
      // navigates to the Stage Closure page and saves the page, that same
      // STG event is updated with a task code of '6010' (the Service Delivery
      // stage closure task code), and the event description is changed to
      // 'Service Delivery Closure'. If a supervisor creates a 'Close
      // Service Delivery' Case To-Do before the worker ever saves the Stage
      // Closure page, however, the CaseUtility search above does not find an
      // existing event with task code '6010' and so it sets an indicator so
      // that the To-Do Save service (CCMN19S) will create a new event and
      // associate the to-do with that event. This causes a couple of problems:
      // 1.) First, when the worker saves the Stage Closure page, the STG event
      // is updated with a task code of '6010', and then there are two stage
      // closure events when there should only be one. 2.) Second, if the
      // worker saves the Stage Closure page a second time, CaseUtility
      // retrieves the most recent event with task code '6010', which is the
      // event created by the To-Do Save service, and since the event is in NEW
      // status, the Stage Closure Save service (CSVC14S) tries to INSERT a
      // row into the SVC_DELV_DTL table; but a row already exists in that
      // table from when the worker saved the page the first time, so the insert
      // fails. To fix this problem, if a 'Close Service Delivery' Case To-Do
      // is being created and the CaseUtility search above (using task code of
      // '6010') finds no matching event, perform another search for an event
      // of type STG and associate the new to-do with that event.
      if (SVC_STAGE_CLOSURE_TASK_CODE.equals(szCdTask) && event.getIdEvent() == 0) {
        event = CaseUtility.getEventByStageAndEventType(toDoDetailDB.getUlIdStage(), CodesTables.CEVNTTYP_STG);
      }

      // ccmn63w.win: this if statement is translated from there
      // If there is no existing event, then cSysIndTaskNew is true iff
      // IND_TASK_EVENT_CREATE == 1
      if (event == null || event.getIdEvent() == 0) {
        String indTaskEventCreateString = TaskInit.getTaskColumnString(szCdTask, TaskInit.IND_TASK_EVENT_CREATE);
        boolean indTaskEventCreate = IND_TRUE.equals(indTaskEventCreateString);
        if (indTaskEventCreate) {
          taskNewIndMap.put(szCdTask, IND_TASK_NEW_TRUE);
        } else {
          taskNewIndMap.put(szCdTask, IND_TASK_NEW_FALSE);
        }
        continue;
      }

      String indTaskRtrvPriorStateString = TaskInit.getTaskColumnString(szCdTask, TaskInit.IND_TASK_RTRV_PRIOR_STAGE);

      String indTaskMultipleInstanceString = TaskInit
                                                     .getTaskColumnString(szCdTask, TaskInit.IND_TASK_MULTIPLE_INSTANCE);

      String cdEventStatus = event.getCdEventStatus();
      String taskEventStatus = TaskInit.getTaskColumnString(szCdTask, TaskInit.CD_TASK_EVENT_STATUS);

      // indTaskNew is ported from ccmn50s.src: lpOutputMsg->cSysIndTaskNew
      // the indTaskNew flag gets set iff the TASK.IND_TASK_RTRV_PRIOR_STAGE is false,
      // TASK.IND_TASK_MULTIPLE_INSTANCE is true, and either the event status for the most recent event is null,
      // the event status associated with the given task code is null, or the event status on the task table sorts
      // as equal to or greater to the event status from the most recent event.
      boolean indTaskNew = (IND_TRUE.equals(indTaskRtrvPriorStateString) == false)
                           && (IND_TRUE.equals(indTaskMultipleInstanceString))
                           && ((cdEventStatus == null) || (taskEventStatus == null) || (eventStatusComparitor
                                                                                                             .compare(
                                                                                                                      taskEventStatus,
                                                                                                                      cdEventStatus) >= 0));

      // This was szFmPlEvTsks in ccmn63w.win (now it includes FCE and Family Plan events)
      String indTaskForceEventLinkString = TaskInit.getTaskColumnString(szCdTask, TaskInit.IND_TASK_FORCE_EVENT_LINK);
      boolean indTaskForceEventLink = IND_TRUE.equals(indTaskForceEventLinkString);

      // ccmn63w.win: these if statements are translated from there
      if (!indTaskNew || indTaskForceEventLink) {
        taskNewIndMap.put(szCdTask, IND_TASK_MUST_LINK);
        continue;
      }

      if (indTaskNew) {
        taskNewIndMap.put(szCdTask, IND_TASK_NEW_PROMPT);
        continue;
      }
      throw new IllegalStateException("no way should this execute");
    }
    return taskNewIndMap;
  }

  /**
   * This method is called by the Grnds controller in order to create a new Approval To-Do. It should be called by most
   * "Save and Submit" buttons on activity detail pages. It requires that the page calling it create a
   * <tt>ToDoDetailDB</tt> and use the setToDoDetailDB() to set it into state.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void newApprovalToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".newApprovalToDo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get the ToDoDetailDB
    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    // Clear state, now that we have the ToDoDeatilDB object
    state.removeAllAttributes(request);

    // Check to see if we are re-submitting an existing event associated with a pending approval event;
    // if so, just forward to displayToDoDetail, as we edit the existing todo instead of creating a new one.
    EventIdStruct_ARRAY eventIdStruct_array = toDoDetailDB.getEventIdStruct_array();
    if (eventIdStruct_array == null || eventIdStruct_array.getEventIdStructCount() < 1) {
      throw new IllegalArgumentException("No events were submitted for approval.");
    }
    EventIdStruct eventIdStruct = eventIdStruct_array.getEventIdStruct(0);
    int ulIdEvent = eventIdStruct.getUlIdEvent();
    CaseUtility.ToDo approvalToDo = CaseUtility.getApprovalToDo(ulIdEvent);
    if (approvalToDo != null && CodesTables.CEVTSTAT_PROC.equals(approvalToDo.getCdEventStatus())) {
      // Create a new ToDoDetailDB for navigation
      ToDoDetailDB newToDoDetailDB = new ToDoDetailDB();
      newToDoDetailDB.setUlIdEvent(approvalToDo.getIdEvent());
      newToDoDetailDB.setLdIdTodo(approvalToDo.getIdTodo());
      newToDoDetailDB.setReturnURI(DISPLAY_TODO_DETAIL_URI);

      // Overwrite the existing ToDoDetailDB
      toDoDetailDB = newToDoDetailDB;

      // Set the presentation branch to forward to displayToDoDetail
      setPresentationBranch(BRANCH_ALREADY_SUBMITTED, context);
    } else {
      // get the current status of the events
      int evenIdStruct_count = eventIdStruct_array.getEventIdStructCount();
      int[] idEvents = new int[evenIdStruct_count];
      for (int i = 0; i < evenIdStruct_count; i++) {
        idEvents[i] = eventIdStruct_array.getEventIdStruct(i).getUlIdEvent();
      }
      List<CaseUtility.Event> events = CaseUtility.getEvents(idEvents);

      // see if any are not already in comp status
      boolean notComp = false;
      for (Iterator<CaseUtility.Event> eventIterator = events.iterator(); eventIterator.hasNext();) {
        CaseUtility.Event event = eventIterator.next();
        // STGAP00010737 - If the event is for an HCN (Home Conversion) Task,
        //      do not set notComp to true! COMP is not used for HCN Events.
        
        // STGAP00014329 - If the event is for an Safety Resource Task,
        //      do not set notComp to true! COMP is not used for Safety Resource Events.
        
        // SMS#47858 - If the event is for a Legal Action,
        //      do not set notComp to true! COMP isn't used for Legal Actions
        //      submitted for approval
        if (!CodesTables.CEVTSTAT_COMP.equals(event.getCdEventStatus()) && 
            !"9997".equals(event.getCdTask()) && !"2277".equals(event.getCdTask()) && !"7331".equals(event.getCdTask())
            && !LEGAL_ACTION_TASKS.contains(event.getCdTask())) {
          notComp = true;
          break;
        }
      }

      // Next, store their existing status and set them all to CodesTables.CEVTSTAT_COMP
      // if at least 1 of the events is not already comp
      if (notComp) {
        state.setAttribute(TODO_EVENTS_KEY, events, request);
        try {
          eventUtility.updateEventStatus(events, CodesTables.CEVTSTAT_COMP);
        } catch (RuntimeException e) {
          GrndsTrace.msg(TRACE_TAG, 7, "Failure updating event status:" + e.getMessage());
          processSevereException(context, e);
        }
      }

      // Set the todo mode to new approval
      toDoDetailDB.setToDoMode(TODO_MODE_NEW_APPROVAL);

      // Set the return URI to modify To-Do, so that we stay on the same page
      toDoDetailDB.setReturnURI(DISPLAY_TODO_DETAIL_URI);

      // Get the user profile so we can get the userId and logonId
      UserProfile user = UserProfileHelper.getUserProfile(request);
      toDoDetailDB.setUserId(user.getUserID());

      // Create and populate an arch input struct with the correct cReqFuncCd and user logon name
      ArchInputStruct archInputStruct = new ArchInputStruct();
      archInputStruct.setCReqFuncCd(TODO_MODE_NEW_APPROVAL_CODE);
      archInputStruct.setSzUserId(user.getUserLogonID());

      // Populate the toDoCaseInfStruct with the passed in ToDoDetailDB
      TodoCaseInfStruct todoCaseInfStruct = new TodoCaseInfStruct();
      todoCaseInfStruct.setUlIdCase(toDoDetailDB.getUlIdCase());
      int ulIdStage = toDoDetailDB.getUlIdStage();
      if (ulIdStage == 0) {
        throw new IllegalArgumentException("The value of ulIdStage cannot be zero.");
      }
      todoCaseInfStruct.setUlIdStage(ulIdStage);
      String szCdTask = toDoDetailDB.getSzCdTask();
      String taskColumnString = TaskInit.getTaskColumnString(szCdTask, TaskInit.CD_TASK_EVENT_TYPE);
      if (!TaskInit.APP_TASK_EVENT_TYPE.equals(taskColumnString)) {
        throw new IllegalArgumentException("Approvals must be created with an approval task.\n" + "The task '"
                                           + szCdTask + "' has event type '" + taskColumnString + ".'");
      }
      todoCaseInfStruct.setSzCdTask(szCdTask);
      // Populate toDoCaseInfStruct with data from the current user
      todoCaseInfStruct.setSzCdUnitRegion(user.getUserRegion());
      todoCaseInfStruct.setSzCdUnitProgram(user.getUserProgram());
      todoCaseInfStruct.setSzCdCounty(user.getUserCounty());
      todoCaseInfStruct.setSzNbrUnit(user.getUserUnit());

      // Create a CCMN13SI object and assign the sub-objects to it to call CCMN13S
      CCMN13SI ccmn13si = new CCMN13SI();
      ccmn13si.setArchInputStruct(archInputStruct);
      ccmn13si.setTodoCaseInfStruct(todoCaseInfStruct);

      // call the service
      CCMN13SO ccmn13so = callCCMN13S(ccmn13si, context);
      if (ccmn13so == null) {
        // If we get null back, the error has already been handled; just return.
        return;
      }

      // This logic is shared between new approver and next approver, so it uses a helper method
      // SMS#109403: add request as parameter to get cdStage
      populateApprovalToDoDetailDB(user, ccmn13so, toDoDetailDB, request);

      // PageMode should always be EDIT in this case, as we're creating a new approval todo
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }

    // We will need toDoDetailDB to be in request no matter which branch is set.
    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    performanceTrace.exitScope();
  }

  // SMS#109403: add request parameter to get cdStage from globalData
  
  /**
   * This method is used to populate the ToDoDetailDB with data from the CCMN13S service call; the logic is shared
   * between new approval and next approval, so it is in a seperate method.
   * 
   * @param user
   *          The <tt>UserProfile</tt> object for the current user
   * @param ccmn13so
   *          The output from the call to CCMN13S
   * @param toDoDetailDB
   *          The <tt>ToDoDetailDB</tt> object
   * @param request
   *          The <tt>HttpServletRequest</tt> object
   */
  private static void populateApprovalToDoDetailDB(UserProfile user, CCMN13SO ccmn13so, ToDoDetailDB toDoDetailDB, HttpServletRequest request) {
    // Get the user's full name
    int userID = user.getUserID();

    java.util.Date dtWCDDtSystemDate = new Date();

    // Set information about the To-Do itself
    toDoDetailDB.setDtDtTodoDue(DateHelper.toCastorDate(dtWCDDtSystemDate));
    toDoDetailDB.setSzCdTodoType(CodesTables.CTODOTYP_T);

    // Set information about the person to whom the To-Do is assigned
    AssignedStruct assignedStruct = ccmn13so.getAssignedStruct();
    toDoDetailDB.setSzNmPersonFullAssigned(assignedStruct.getSzNmPersonFull());
    toDoDetailDB.setUlIdTodoPersAssigned(assignedStruct.getUlIdTodoPersAssigned());

    // Set information about the stage with which the To-Do is associated
    StageStruct stageStruct = ccmn13so.getStageStruct();
    toDoDetailDB.setSzNmPersonFullWorker(stageStruct.getSzNmPersonFull());
    toDoDetailDB.setSzNmStage(stageStruct.getSzNmStage());
    // idstage was passed in; do not overwrite it
    toDoDetailDB.setUlIdTodoPersWorker(stageStruct.getUlIdTodoPersWorker());

    // Set information about the task with which the To-Do is associated
    TaskStruct taskStruct = ccmn13so.getTaskStruct();
    toDoDetailDB.setSzTxtTaskDecode(taskStruct.getSzTxtTaskDecode());
    // ignore the short description that we get back from the service; instead, use what's passed in through the
    // SHORT_DESCRIPTION_KEY if it's available, or the task decode if it's not
    String shortDescription = toDoDetailDB.getSzTxtTodoDesc();
    if (shortDescription == null || "".equals(shortDescription.trim())) {
      shortDescription = toDoDetailDB.getSzTxtTaskDecode();
    }
    // pre-pend the user's initials to the task description
    String userFullName = user.getUserFullName();
    String initials = FormattingHelper.formatUserInitials(userFullName);
    shortDescription = initials + DASH_STRING + shortDescription;
    
    // SMS#109403: add stage type prefix to todo description for adoption assistance application (AAAP) only, 
    // using task codes defined by the AAAP conversation
    String taskCode = toDoDetailDB.getSzCdTask();
    if (SpecialNeedsDeterminationConversation.APPROVAL_TASK_1.equals(taskCode)
        || SpecialNeedsDeterminationConversation.APPROVAL_TASK_2.equals(taskCode)) {
      // If populate is called by next approval, strip off the stage type prefix before making a new short description. 
      // The stage type will be prepended later to the new description string.
      if (TODO_MODE_NEXT_APPROVAL.equals(toDoDetailDB.getToDoMode())) {
        shortDescription = initials + DASH_STRING + toDoDetailDB.getSzTxtTodoDesc().substring(6);
      } 
      // Save the todo description before adding stage type prefix
      shortDescription = GlobalData.getSzCdStage(request) + DASH_STRING + shortDescription;
    } // end adding stage type prefix
    // trim the description to 80 characters if necessary
    shortDescription = shortDescription.length() > SHORT_DESCRIPTION_SIZE ? shortDescription
                                                                                            .substring(0,
                                                                                                       SHORT_DESCRIPTION_SIZE)
                                                                         : shortDescription;
    toDoDetailDB.setSzTxtTodoDesc(shortDescription);

    // Set information about the creation of the To-Do
    toDoDetailDB.setDtDtTodoCreated(DateHelper.toCastorDate(dtWCDDtSystemDate));
    toDoDetailDB.setTmTmTodoCreated(FormattingHelper.formatTime(dtWCDDtSystemDate));
    toDoDetailDB.setSzNmPersonFullCreator(CREATED_NAME_SYSTEM);
    toDoDetailDB.setInitialsPersonCreated(FormattingHelper.formatUserInitials(userFullName));
    toDoDetailDB.setUlIdTodoPersCreator(userID);
  }

  /**
   * This method is called by the Grnds controller in order to create the next Approval To-Do. It should only be called
   * by the Approval Status page to create another approver when completing the last existing pending approval. It
   * requires that Approval Status create a <tt>ToDoDetailDB</tt> and use the setToDoDetailDB() to set it into state.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void nextApprovalToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".nextApprovalToDo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String whichSpclInvApprover = (String)state.getAttribute(ApprovalStatusConversation.WHICH_SPCL_INV_APPROVER, request);
    String whichSafetyRsrcApprover = (String)state.getAttribute(ApprovalStatusConversation.WHICH_SAFETY_RSRC_APPROVER, request);

    // Create the ToDoDetailDB
    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    // Set the todo mode to new using
    toDoDetailDB.setToDoMode(TODO_MODE_NEXT_APPROVAL);

    // Do NOT clear state, as this XA method is used by Approval Status to create a new approval as a pull-back.

    // Get the user profile so we can get the userId and logonId
    UserProfile user = UserProfileHelper.getUserProfile(request);
    toDoDetailDB.setUserId(user.getUserID());

    // Create and populate an arch input struct with the correct cReqFuncCd and user logon name
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(TODO_MODE_NEXT_APPROVAL_CODE);
    archInputStruct.setSzUserId(user.getUserLogonID());

    // Populate the toDoCaseInfStruct with the passed in toDoDetailDB
    TodoCaseInfStruct todoCaseInfStruct = new TodoCaseInfStruct();
    todoCaseInfStruct.setUlIdCase(toDoDetailDB.getUlIdCase());
    todoCaseInfStruct.setUlIdStage(toDoDetailDB.getUlIdStage());
    todoCaseInfStruct.setSzCdTask(toDoDetailDB.getSzCdTask());

    // Populate toDoCaseInfStruct with data from the current user
    todoCaseInfStruct.setSzCdUnitRegion(user.getUserRegion());
    todoCaseInfStruct.setSzCdUnitProgram(user.getUserProgram());
    todoCaseInfStruct.setSzNbrUnit(user.getUserUnit());
    todoCaseInfStruct.setSzCdCounty(user.getUserCounty());

    // Create a CCMN13SI object and assign the sub-objects to it to call CCMN13S
    CCMN13SI ccmn13si = new CCMN13SI();
    ccmn13si.setArchInputStruct(archInputStruct);
    ccmn13si.setTodoCaseInfStruct(todoCaseInfStruct);
    ccmn13si.setSzWhichSpclInvApprover(whichSpclInvApprover);
    ccmn13si.setSzWhichSafetyRsrcApprover(whichSafetyRsrcApprover);
    // call the service
    CCMN13SO ccmn13so = callCCMN13S(ccmn13si, context);
    if (ccmn13so == null) {
      // If we get null back, the error has already been handled; just return.
      return;
    }
  
    // SMS# 109403: new parameter request was added to populateApprovalToDoDetailDB so updating every calling method. 
    // This logic is shared between new approver and next approver, so it uses a helper method
    populateApprovalToDoDetailDB(user, ccmn13so, toDoDetailDB, request);

    // PageMode should always be EDIT in this case, as we're creating a new approval todo
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when returning from Staff Search to To-Do Detail. It is <i>only</i>
   * used for this purpose and should not be callled except through the Staff Search pullback.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void returnFromStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".returnFromStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCCMN50DO_ARRAY rowccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);
    // get the first row out of the array if it exists and there is exactly one (if there are more or less than one,
    // something really weird happened)
    ROWCCMN50DO rowccmn50do = rowccmn50do_array != null && rowccmn50do_array.getROWCCMN50DOCount() == 1 ? rowccmn50do_array
                                                                                                                           .getROWCCMN50DO(0)
                                                                                                       : null;

    if (rowccmn50do != null) {
      ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

      toDoDetailDB.setSzNmPersonFullAssigned(rowccmn50do.getSzNmPersonFull());
      toDoDetailDB.setUlIdTodoPersAssigned(rowccmn50do.getUlIdPerson());
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      // Set page mode back to edit, as staff search may have changed it;
      // this is save because the Staff button doesn't appear unless
      // we are already in edit mode.
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    } else {
      throw new RuntimeWrappedException(new PopulationException("ROWCCMN50DO_ARRAY not found in request."));
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This is a utility mehtod used to call CCMN13S from multiple activity methods.
   * 
   * @param ccmn13si
   *          The input to CCMN13S
   * @param context
   *          The current <tt>GrndsExchangeContext</tt> object
   * @return A <tt>CCMN13SO</tt> object representing the output from CCMN13S
   */
  private CCMN13SO callCCMN13S(CCMN13SI ccmn13si, GrndsExchangeContext context) {
    CCMN13SO ccmn13so = null;

    try {
      ccmn13so = admin.findIntakeInformation(ccmn13si);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TODO_DELETED:
        displayMessagePage(Messages.MSG_CMN_TODO_DELETED, context);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE_STRING + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }
    return ccmn13so;
  }

  /**
   * This method is used to save the data from To-Do Detail. It is used to save no mater which method was used to
   * display To-Do Detail.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void saveToDoDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveToDoDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    CCMN19SI ccmn19si = populateCCMN19S_Save(toDoDetailDB, request);

    boolean success = false;

    try {
      CCMN19SO ccmn19so = admin.saveTodoInformation(ccmn19si);
      //SMS#76298 Added code so that the Foster Care Redetermination is set to PEND status 
      // after save and submit by the Case Manager
      if (TODO_MODE_NEW_FCE_TODO.equals(toDoDetailDB.getToDoMode())) {
        boolean isSuccessful = fce.changeEventStatus(toDoDetailDB.getUlIdEvent());
      } else {
        List events = (List) state.getAttribute(TODO_EVENTS_KEY, request);
        if (events != null) {
          // eventUtility.updateEventStatus(events); already done in saveTodoInformation, plus this is mix and match between hibernate and old ejb
        }
      }
      toDoDetailDB.setLdIdTodo(ccmn19so.getLdIdTodo());
      success = true;
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_TODO_DELETED:
      case Messages.ARC_UTL_YEAR_TOO_SMALL:
      case Messages.MSG_NOT_AUTH_TO_APPROVE:
      case Messages.MSG_AA_APP_APPRV_PRIV:
      case Messages.MSG_AA_AGR_APPRV_PRIV:
        setErrorMessage(errorCode, request);
        break;
      case Messages.MSG_BUDGET_EXCEEDED:
        this.setPresentationBranch(BUDGET_LIMIT, context); 
          setErrorMessage(errorCode, request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE_STRING + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    if (success) {
      // Return to the return URI in state if it's there;
      // otherwise, go to the URL returned by ToDoHelper.
      try {
        String returnUri = toDoDetailDB.getReturnURI();
        returnUri = returnUri == null ? ToDoHelper.getReturnToToDoListURI(request) : returnUri;
        // Display the message indicating that the save was successful in all cases _except_
        // when returning to Approval Status, as it is confusing in that case.
        if (!ApprovalStatusConversation.DISPLAY_URI.equals(returnUri)) {
          setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, DISPLAY_TODO_DETAIL_URI, request);
        }
        forward(returnUri, request, context.getResponse());
      } catch (ServletException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure returning to calling page:" + e.getMessage());
        processSevereException(context, e);
        return;
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method populates a <tt>CCMN19SI</tt> object from the information stored in the request parameters and in the
   * <tt>ToDoDetailDB</tt> stored in state.
   * 
   * @param request
   *          The <tt>HttpServletRequest</tt> object
   * @return A <tt>CCMN19SO</tt> object representing the input for CCMN19S
   */
  private CCMN19SI populateCCMN19S_Save(ToDoDetailDB toDoDetailDB, HttpServletRequest request) {
    // Get the values for fields that the user can change out of the request;
    // exclued dspszScrTodoAssignedTo because we know that from the values in
    // state, which can be changed by the staff page
    toDoDetailDB.setDtDtTodoDue(ContextHelper.getCastorDateSafe(request, "dtDueDate"));
    toDoDetailDB.setDtDtTodoCompleted(ContextHelper.getCastorDateSafe(request, "dtCompletedDate"));
    toDoDetailDB.setSzTxtTodoDesc(ContextHelper.getStringSafe(request, "txtSzTxtTodoDesc"));
    toDoDetailDB.setTxtTodoLongDesc(ContextHelper.getStringSafe(request, "txtSzTxtTodoLongDesc"));

    String cSysIndTaskNewString = ContextHelper.getStringSafe(request, "hdnCSysIndTaskNew");
    boolean bLinkEvent = ContextHelper.getBooleanSafe(request, "bLinkEvent");

    CCMN19SI ccmn19si = new CCMN19SI();
    ApproversStruct approversStruct = new ApproversStruct();
    ApprvStruct apprvStruct = new ApprvStruct();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    EventStruct eventStruct = new EventStruct();
    ToDoAUDStruct toDoAUDStruct = new ToDoAUDStruct();

    // Fields that need to be set for all cases:
    // set this here because it's set to empty by default, which is fine for
    // all cases that don't require it
    ccmn19si.setEventIdStruct_ARRAY(toDoDetailDB.getEventIdStruct_array());
    // getToDoCode gets the proper cReqFuncCd for us
    archInputStruct.setCReqFuncCd(getToDoCode(toDoDetailDB.getToDoMode()));
    // set the username into the archInputStruct
    archInputStruct.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());
    // this is always "N" but will not default correctly
    approversStruct.setBIndApproversHistorical(ArchitectureConstants.N);

    int ldIdTodo = toDoDetailDB.getLdIdTodo();
    approversStruct.setLdIdTodo(ldIdTodo);

    if (ldIdTodo == 0) {
      Date now = new Date();
      toDoDetailDB.setDtDtTodoCreated(DateHelper.toCastorDate(now));
      String nowTime = FormattingHelper.formatTime(now);
      toDoDetailDB.setTmTmTodoCreated(nowTime);
    }

    String szTxtTodoDesc = toDoDetailDB.getSzTxtTodoDesc();
    // need to chop the description down to 40 characters for the approval topic
    String szTxtApprovalTopic = szTxtTodoDesc.length() > 40 ? szTxtTodoDesc.substring(0, 40) : szTxtTodoDesc;

    toDoAUDStruct.setDtDtTaskDue(toDoDetailDB.getDtDtTaskDue());
    toDoAUDStruct.setDtDtTodoCompleted(toDoDetailDB.getDtDtTodoCompleted());
    toDoAUDStruct.setDtDtTodoCreated(toDoDetailDB.getDtDtTodoCreated());
    toDoAUDStruct.setTmTmTodoCreated(toDoDetailDB.getTmTmTodoCreated());
    toDoAUDStruct.setDtDtTodoDue(toDoDetailDB.getDtDtTodoDue());
    toDoAUDStruct.setLdIdTodo(toDoDetailDB.getLdIdTodo());
    toDoAUDStruct.setSzCdTodoType(toDoDetailDB.getSzCdTodoType());
    toDoAUDStruct.setSzTxtTodoDesc(szTxtTodoDesc);
    toDoAUDStruct.setTxtTodoLongDesc(toDoDetailDB.getTxtTodoLongDesc());
    toDoAUDStruct.setUlIdCase(toDoDetailDB.getUlIdCase());
    toDoAUDStruct.setUlIdEvent(toDoDetailDB.getUlIdEvent());
    toDoAUDStruct.setUlIdStage(toDoDetailDB.getUlIdStage());
    toDoAUDStruct.setUlIdTodoPersAssigned(toDoDetailDB.getUlIdTodoPersAssigned());
    toDoAUDStruct.setUlIdTodoPersCreator(toDoDetailDB.getUlIdTodoPersCreator());
    toDoAUDStruct.setUlIdTodoPersWorker(toDoDetailDB.getUlIdTodoPersWorker());

    int toDoMode = getToDoMask(toDoDetailDB.getToDoMode());

    String szCdTask = toDoDetailDB.getSzCdTask();
    int ulIdStage = toDoDetailDB.getUlIdStage();
    int ulIdEvent; // this is set in multiple cases
    switch (toDoMode) {
    case TODO_MODE_NEW_APPROVAL_MASK:
      approversStruct.setDtDtApproversDetermination(null);
      approversStruct.setDtDtApproversRequested(toDoDetailDB.getDtDtTodoCreated());
      approversStruct.setUlIdPerson(toDoDetailDB.getUlIdTodoPersAssigned());
      apprvStruct.setSzTxtApprovalTopic(szTxtApprovalTopic);
      apprvStruct.setUlIdPerson(toDoDetailDB.getUlIdTodoPersCreator());
      toDoAUDStruct.setSzCdTodoTask(szCdTask);
      eventStruct.setDtDtEventOccurred(toDoDetailDB.getDtDtTodoDue());
      eventStruct.setSzTxtEventDescr(szTxtTodoDesc);
      eventStruct.setUlIdPerson(toDoDetailDB.getUlIdTodoPersCreator());
      eventStruct.setUlIdStage(toDoDetailDB.getUlIdStage());
      eventStruct.setUlIdEvent(GlobalData.getUlIdEvent(request));
      break;

    case TODO_MODE_NEXT_APPROVAL_MASK:
      approversStruct.setDtDtApproversDetermination(null);
      approversStruct.setDtDtApproversRequested(toDoDetailDB.getDtDtTodoCreated());
      approversStruct.setUlIdApproval(toDoDetailDB.getUlIdApproval());
      approversStruct.setUlIdPerson(toDoDetailDB.getUlIdTodoPersAssigned());
      apprvStruct.setSzTxtApprovalTopic(szTxtApprovalTopic);
      apprvStruct.setUlIdPerson(toDoDetailDB.getUlIdTodoPersCreator());
      // this gets set to prevent ccmn19s from updating the event time stamp
      ccmn19si.setCSysIndTaskNew(APPROVAL_FLAG);
      toDoAUDStruct.setSzCdTodoTask(szCdTask);
      break;

    case TODO_MODE_MODIFY_MASK:
      toDoAUDStruct.setSzCdTodoTask(szCdTask);
      toDoAUDStruct.setTsLastUpdate(toDoDetailDB.getTsLastUpdate());
      break;

    case TODO_MODE_NEW_USING_MASK:
      toDoAUDStruct.setSzCdTodoTask(szCdTask);
      break;

    case TODO_MODE_NEW_FCE_TODO_MASK:
      toDoAUDStruct.setSzCdTodoType(CodesTables.CTODOTYP_T);
      toDoAUDStruct.setSzCdTodoTask(szCdTask);
      toDoAUDStruct.setUlIdCase(toDoDetailDB.getUlIdCase());
      toDoAUDStruct.setUlIdStage(ulIdStage);
      // Link to the existing FCE application event
      ccmn19si.setCSysIndTaskNew(ArchitectureConstants.N);
      ulIdEvent = toDoDetailDB.getUlIdEvent();
      toDoAUDStruct.setUlIdEvent(ulIdEvent);
      eventStruct.setDtDtEventOccurred(toDoDetailDB.getDtDtTodoDue());
      eventStruct.setSzTxtEventDescr(szTxtTodoDesc);
      eventStruct.setUlIdPerson(toDoDetailDB.getUlIdTodoPersCreator());
      eventStruct.setUlIdStage(toDoDetailDB.getUlIdStage());
      eventStruct.setUlIdEvent(ulIdEvent);
      break;

    case TODO_MODE_NEW_CASE_TODO_MASK:
      szCdTask = ContextHelper.getStringSafe(request, "selSzCdTask");
      if ("9999".equals(szCdTask)) {
        toDoAUDStruct.setSzCdTodoType(CodesTables.CTODOTYP_A);
      } else {
        toDoAUDStruct.setSzCdTodoType(CodesTables.CTODOTYP_T);
        toDoDetailDB.setSzCdTask(szCdTask);

      }

      toDoAUDStruct.setSzCdTodoTask(szCdTask);
      toDoAUDStruct.setUlIdCase(toDoDetailDB.getUlIdCase());
      toDoAUDStruct.setUlIdStage(ulIdStage);

      // Link to the previous event according to the conditions set for
      // cSysIndTaskNew in display Attributes and, if applicable, the response
      // from the user to a prompt asking if we should
      if (IND_TASK_NEW_TRUE.equals(cSysIndTaskNewString)) {
        ccmn19si.setCSysIndTaskNew(ArchitectureConstants.Y);
      } else if (bLinkEvent) {
        ccmn19si.setCSysIndTaskNew(ArchitectureConstants.N);
        ulIdEvent = CaseUtility.getEvent(ulIdStage, szCdTask).getIdEvent();

        // RIOSJA, SIR 22899 - When a SVC stage is first opened, a STG event
        // is created with a null task code and an event description of
        // 'Service Delivery Stage Opened'. When the worker subsequently
        // navigates to the Stage Closure page and saves the page, that same
        // STG event is updated with a task code of '6010' (the Service Delivery
        // stage closure task code), and the event description is changed to
        // 'Service Delivery Closure'. If a supervisor creates a 'Close
        // Service Delivery' Case To-Do before the worker ever saves the Stage
        // Closure page, however, the CaseUtility search above does not find an
        // existing event with task code '6010' and so it sets an indicator so
        // that the To-Do Save service (CCMN19S) will create a new event and
        // associate the to-do with that event. This causes a couple of problems:
        // 1.) First, when the worker saves the Stage Closure page, the STG event
        // is updated with a task code of '6010', and then there are two stage
        // closure events when there should only be one. 2.) Second, if the
        // worker saves the Stage Closure page a second time, CaseUtility
        // retrieves the most recent event with task code '6010', which is the
        // event created by the To-Do Save service, and since the event is in NEW
        // status, the Stage Closure Save service (CSVC14S) tries to INSERT a
        // row into the SVC_DELV_DTL table; but a row already exists in that
        // table from when the worker saved the page the first time, so the insert
        // fails. To fix this problem, if a 'Close Service Delivery' Case To-Do
        // is being created and the CaseUtility search above (using task code of
        // '6010') finds no matching event, perform another search for an event
        // of type STG and associate the new to-do with that event.
        if (SVC_STAGE_CLOSURE_TASK_CODE.equals(szCdTask) && ulIdEvent == 0) {
          ulIdEvent = CaseUtility.getEventByStageAndEventType(ulIdStage, CodesTables.CEVNTTYP_STG).getIdEvent();
        }

        toDoAUDStruct.setUlIdEvent(ulIdEvent);

        eventStruct.setDtDtEventOccurred(toDoDetailDB.getDtDtTodoDue());
        eventStruct.setSzTxtEventDescr(szTxtTodoDesc);
        eventStruct.setUlIdPerson(toDoDetailDB.getUlIdTodoPersCreator());
        eventStruct.setUlIdStage(toDoDetailDB.getUlIdStage());
        eventStruct.setUlIdEvent(ulIdEvent);
      } else {
        ccmn19si.setCSysIndTaskNew(ArchitectureConstants.N);
      }
      break;

    default:
      throw new RuntimeWrappedException(new PopulationException("Unknown ToDo Mode Mask"));
    }

    // assemble ccmn19si
    ccmn19si.setApproversStruct(approversStruct);
    ccmn19si.setApprvStruct(apprvStruct);
    ccmn19si.setArchInputStruct(archInputStruct);
    ccmn19si.setEventStruct(eventStruct);
    ccmn19si.setToDoAUDStruct(toDoAUDStruct);
    return ccmn19si;
  }

  /**
   * This static method uses a <tt>ToDoDetailDB</tt> in order to determine whether or not the completed date control
   * on the To-Do Detail JSP page.
   * 
   * @param toDoDetailDB
   *          The <tt>ToDoDetailDB</tt> object
   * @return The Strings "true" or "false" depending whether the completed date control should be disabled
   */
  public static String getDisableCompleted(ToDoDetailDB toDoDetailDB) {
    // Disable the completed date control iff the To-Do satisfies either of the following conditions:
    // 1) It is a system created To-do (user id is 0) and the task code is set
    // 2) The current user neither created nor is assigned to this To-Do
    String taskCode = toDoDetailDB.getSzCdTask();
    int userId = toDoDetailDB.getUserId();
    int ulIdTodoPersCreator = toDoDetailDB.getUlIdTodoPersCreator();
    int ulIdTodoPersAssigned = toDoDetailDB.getUlIdTodoPersAssigned();
    boolean disableCompletedDate = (!TODO_MODE_MODIFY.equals(toDoDetailDB.getToDoMode()))
                                   || (ulIdTodoPersCreator == 0 && taskCode != null && !"".equals(taskCode))
                                   || (userId != ulIdTodoPersCreator && userId != ulIdTodoPersAssigned);
    return String.valueOf(disableCompletedDate);
  }

  /**
   * This static method uses a <tt>ToDoDetailDB</tt> in order to determine whether or not the due date control on the
   * To-Do Detail JSP page.
   * 
   * @param toDoDetailDB
   *          The <tt>ToDoDetailDB</tt> object
   * @return The Strings "true" or "false" depending whether the due date control should be disabled
   */
  public static String getDisableDueDate(ToDoDetailDB toDoDetailDB) {
    // Disable the due date control iff the current user did not create the to-do or the to-do is not assigned to him
    int userId = toDoDetailDB.getUserId();
    int ulIdTodoPersCreator = toDoDetailDB.getUlIdTodoPersCreator();
    int ulIdTodoPersAssigned = toDoDetailDB.getUlIdTodoPersAssigned();
    boolean disableDueDate = ulIdTodoPersCreator != userId && ulIdTodoPersAssigned != userId;
    return String.valueOf(disableDueDate);
  }

  /**
   * This method is called by the Grnds controller when the user clicks on the Staff button on To-Do Detail; it is used
   * to reassign the To-Do to a different user than the default or assign the To-Do to a user if it is unassigned.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffSearch_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    ToDoDetailDB toDoDetailDB = getToDoDetailDB(request, state);

    // Preserve any values that have changed
    toDoDetailDB.setDtDtTodoDue(ContextHelper.getCastorDateSafe(request, "dtDueDate"));
    toDoDetailDB.setDtDtTodoCompleted(ContextHelper.getCastorDateSafe(request, "dtCompletedDate"));
    toDoDetailDB.setSzTxtTodoDesc(ContextHelper.getStringSafe(request, "txtSzTxtTodoDesc"));
    toDoDetailDB.setTxtTodoLongDesc(ContextHelper.getStringSafe(request, "txtSzTxtTodoLongDesc"));

    if (TODO_MODE_NEW_CASE_TODO.equals(toDoDetailDB.getToDoMode())) {
      String taskCode = ContextHelper.getStringSafe(request, "selSzCdTask");
      if (StringHelper.isValid(taskCode)) {
        toDoDetailDB.setSzCdTask(taskCode);
        toDoDetailDB.setSzTxtTaskDecode(TaskInit.getTaskColumnString(taskCode, TaskInit.TXT_TASK_DECODE));
      }
    }

    StaffSearchInput staffSearchInput = new StaffSearchInput();
    // SPB SIR 19992 - coming from ToDo Detail indicator
    staffSearchInput.setSourcePage(StaffSearchInput.TODO);
    staffSearchInput.setDestinationUrl(RETURN_FROM_STAFF_SEARCH_URI);
    request.setAttribute(StaffSearchInput.PULL_BACK_KEY, staffSearchInput);

    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (ServletException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure navigating to Staff Search:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is used to execute a Case To-Do search no matter which activity method is used to call the serach;
   * "search" is done on every display in order to find the To-Do's for the correct date range.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void executeCaseToDoSearch(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    // Go through each stage to find out if the user has access to any of them;
    // if he does, then show all the buttons; otherwise, hide them.
    int ulIdCase = GlobalData.getUlIdCase(request);
    List<CaseUtility.Stage> openStages = CaseUtility.getOpenStages(ulIdCase);
    boolean showButtons = false;
    for (Iterator<CaseUtility.Stage> openStageIterator = openStages.iterator(); openStageIterator.hasNext();) {
      CaseUtility.Stage stage = openStageIterator.next();
      if (CaseUtility.hasStageAccess(user.getUserID(), stage.getIdStage())) {
        showButtons = true;
        break;
      }
    }

    // Set the page set based on the showButtons flag
    Sets.setPageSet(showButtons ? CASE_TODO_BUTTON_SET : Sets.NONE, request);

    // Get the current search settings out of context
    ToDoHelper.ToDoStateInfo toDoStateInfo = ToDoHelper.getToDoStateInformation(request, ulIdCase);
    if (toDoStateInfo == null) {
      // This means that this is the first time that this page has been displayed;
      // create a new ToDoHelper.ToDoStageInfo and set some defaults.
      toDoStateInfo = new ToDoHelper.ToDoStateInfo();
      toDoStateInfo.setId(ulIdCase);
      // SIR 22610 default sort should be by date
      toDoStateInfo.setOrderBy(CASE_TODO_SORT_BY_DATE);
    }

    // Set the id and state info object into request and state (respectively) immediately,
    // so we display the list of stages even if there are no existing todos.
    request.setAttribute(TODO_STATE_ID_KEY, String.valueOf(ulIdCase));
    ToDoHelper.setToDoStateInformation(request, toDoStateInfo);

    // Get the pagination information from the request if it's present
    TuxedoPaginationValueBean tuxedoPaginationValueBean = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxedoPaginationValueBean);
    DatabaseResultDetails databaseResultDetails = tuxedoPaginationValueBean.getResultDetails();
    databaseResultDetails.setResultsPerPage(RESULTS_PER_PAGE);

    // Update the toDoStateInfo appropriately if the user has searched
    if (ContextHelper.isParameterPresent(request, "dtFrom")) {
      // If we have a from date, we want to reset the dates and the page number, but nothing else
      toDoStateInfo.setFromDate(ContextHelper.getCastorDateSafe(request, "dtFrom"));
      toDoStateInfo.setToDate(ContextHelper.getCastorDateSafe(request, "dtTo"));
      // Set both the bean and the databaseResultsDetails to page one
      toDoStateInfo.setRequestedPage(1);
      databaseResultDetails.setRequestedPage(1);
      databaseResultDetails.setOrderBy(toDoStateInfo.getOrderBy());
    } else {
      // The user did not search; if the orderBy field of databaseResultDetails is null,
      // then the user did not just set the sort order or selec the page, either, so set them.
      if (databaseResultDetails.getOrderBy() == null) {
        databaseResultDetails.setOrderBy(toDoStateInfo.getOrderBy());
        databaseResultDetails.setRequestedPage(toDoStateInfo.getRequestedPage());
      } else {
        // Need to update the ToDoHelper.ToDoStateInfo object so it will be useful when we return.
        toDoStateInfo.setOrderBy(databaseResultDetails.getOrderBy());
        toDoStateInfo.setRequestedPage(databaseResultDetails.getRequestedPage());
      }
    }

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(user.getUserLogonID());
    archInputStruct.setCReqFuncCd(toDoStateInfo.getOrderBy());
    archInputStruct.setUsPageNbr(databaseResultDetails.getRequestedPage());
    archInputStruct.setUlPageSizeNbr(databaseResultDetails.getResultsPerPage());

    DtDtTodoDue_ARRAY dtDtTodoDue_array = new DtDtTodoDue_ARRAY();
    dtDtTodoDue_array.addDtDtTodoDue(toDoStateInfo.getFromDate());
    dtDtTodoDue_array.addDtDtTodoDue(toDoStateInfo.getToDate());

    CCMN12SI ccmn12si = new CCMN12SI();
    ccmn12si.setArchInputStruct(archInputStruct);
    ccmn12si.setDtDtTodoDue_ARRAY(dtDtTodoDue_array);
    // Use Global Data to get the UlIdCase of for the case that we're interested in
    ccmn12si.setUlIdCase(ulIdCase);

    CCMN12SO ccmn12so;
    ROWCCMN42DO_ARRAY rowccmn42do_array;
    try {
      ccmn12so = admin.retrieveCaseTodo(ccmn12si);

      rowccmn42do_array = ccmn12so.getROWCCMN42DO_ARRAY();
      // we need to store both a map and a list so we preserve the order on the JSP page
      Map<Integer, ROWCCMN42DO> rowccmn42doMap = new HashMap<Integer, ROWCCMN42DO>();
      List<ROWCCMN42DO> rowccmn42doList = new ArrayList<ROWCCMN42DO>();
      Enumeration<ROWCCMN42DO> rowccmn42doEnum = rowccmn42do_array.enumerateROWCCMN42DO();
      while (rowccmn42doEnum.hasMoreElements()) {
        ROWCCMN42DO rowccmn42do = rowccmn42doEnum.nextElement();
        rowccmn42doMap.put(rowccmn42do.getLdIdTodo(), rowccmn42do);
        rowccmn42doList.add(rowccmn42do);
      }
      state.setAttribute(ROWCCMN42DO_MAP_KEY, rowccmn42doMap, request);
      state.setAttribute(ROWCCMN42DO_LIST_KEY, rowccmn42doList, request);
      // TODO
      // setting the value of setBMoreDataInd to N
      // just to make sure it works
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn12so.getBMoreDataInd());
      ccmn12so.setArchOutputStruct(archOutputStruct);
      tuxedoPaginationValueBean.setPaginationInformation(ccmn12so.getArchOutputStruct(),
                                                         rowccmn42do_array.getROWCCMN42DOCount());
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_NO_ROWS_RETURNED:
        state.setAttribute(ROWCCMN42DO_MAP_KEY, null, request); // just set the rows to null, and we will display an
                                                                // error message
        state.setAttribute(ROWCCMN42DO_LIST_KEY, null, request); // just set the rows to null, and we will display an
                                                                  // error message
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE_STRING + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    // set the pagination information outside the try block so it is always set
    request.setAttribute(TuxedoPaginationValueBean.REQUEST_ATTRIBUTE_NAME, tuxedoPaginationValueBean);
  }

  /**
   * This method is called by the Grnds controller when Case To-Do is displayed; it sets default search values if none
   * are set, but will use those set into the request if they are present.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayCaseToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseToDo_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // Set the return page to Case To-Do so when the user navigates on tasks, they go back to Case To-Do
    ToDoHelper.setReturnToCaseToDoList(request);

    // Need to clear the task code out of GlobalData so the page shows up under the right task
    GlobalData.setSzCdTask(null, request);

    // Clear state
    state.removeAllAttributes(request);

    // Set page mode to EDIT always
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    executeCaseToDoSearch(context);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the user clicks on the New Using button on Case To-Do; it is
   * used to create a new Case To-Do with values present in an existing one.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void newUsingCaseToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".newUsingCaseToDo_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    ROWCCMN42DO rowccmn42do = getROWCCMN42DO(request, state);

    ToDoDetailDB toDoDetailDB = new ToDoDetailDB();
    toDoDetailDB.setSzCdStage(rowccmn42do.getSzCdStage());
    toDoDetailDB.setSzCdStageProgram(rowccmn42do.getSzCdStageProgram());
    toDoDetailDB.setSzCdTask(rowccmn42do.getSzCdTask());
    toDoDetailDB.setUlIdCase(rowccmn42do.getUlIdCase());
    toDoDetailDB.setUlIdEvent(rowccmn42do.getUlIdEvent());
    toDoDetailDB.setUlIdStage(GlobalData.getUlIdStage(request));
    toDoDetailDB.setLdIdTodo(rowccmn42do.getLdIdTodo());

    toDoDetailDB.setReturnURI(DISPLAY_CASE_TODO_LIST_URI);

    openToDoDetail(context, DISPLAY_TODO_DETAIL_NEW_USING_URI, toDoDetailDB);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the user clicks on the Add button on Case To-Do; it is used to
   * create a new Case To-Do in the selected stage.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void addCaseToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addCaseToDo_xa()");
    performanceTrace.enterScope();

    // BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    ToDoDetailDB toDoDetailDB = new ToDoDetailDB();
    toDoDetailDB.setToDoMode(TODO_MODE_NEW_CASE_TODO);
    toDoDetailDB.setSzCdStage(ContextHelper.getStringSafe(request, "hdnCdStage"));
    toDoDetailDB.setSzCdStageProgram(ContextHelper.getStringSafe(request, "hdnCdStageProgram"));
    toDoDetailDB.setUlIdCase(GlobalData.getUlIdCase(request));
    toDoDetailDB.setUlIdStage(ContextHelper.getIntSafe(request, "hdnIdStage"));

    toDoDetailDB.setReturnURI(DISPLAY_CASE_TODO_LIST_URI);

    // -- This line is assuming that this method is only called from the Add button
    // -- from the Case To-Do List page
    toDoDetailDB.setAlert(true);

    openToDoDetail(context, DISPLAY_TODO_DETAIL_NEW_CASE_TODO_URI, toDoDetailDB);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the user clicks on one of the detail links on Case To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayCaseToDoDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseToDoDetail_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    ROWCCMN42DO rowccmn42do = getROWCCMN42DO(request, state);

    ToDoDetailDB toDoDetailDB = new ToDoDetailDB();
    toDoDetailDB.setSzCdStage(rowccmn42do.getSzCdStage());
    toDoDetailDB.setSzCdStageProgram(rowccmn42do.getSzCdStageProgram());
    toDoDetailDB.setSzCdTask(rowccmn42do.getSzCdTask());
    toDoDetailDB.setUlIdCase(rowccmn42do.getUlIdCase());
    toDoDetailDB.setUlIdEvent(rowccmn42do.getUlIdEvent());
    int ulIdStage = GlobalData.getUlIdStage(request);
    toDoDetailDB.setUlIdStage(ulIdStage);
    toDoDetailDB.setLdIdTodo(rowccmn42do.getLdIdTodo());

    toDoDetailDB.setReturnURI(DISPLAY_CASE_TODO_LIST_URI);

    // Set appMode appropriately
    boolean hasStageAccess = CaseUtility.hasStageAccess(UserProfileHelper.getUserProfile(request).getUserID(),
                                                        ulIdStage);

    GlobalData.setAppMode(hasStageAccess ? PageModeConstants.EDIT : PageModeConstants.VIEW, request);

    openToDoDetail(context, DISPLAY_TODO_DETAIL_URI, toDoDetailDB);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is used to open To-Do detail in modify mode from the detail*_xa methods; it forwards the request to the
   * displayToDoDetail_xa method.
   * 
   * @param context
   * @param toDoDetailUri
   * @param toDoDetailDB
   */
  private void openToDoDetail(GrndsExchangeContext context, String toDoDetailUri, ToDoDetailDB toDoDetailDB) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    // set the case name and id into global data for the info box
    int ulIdCase = toDoDetailDB.getUlIdCase();
    GlobalData.setUlIdCase(ulIdCase, request);
    GlobalData.setSzNmCase(CaseUtility.getNmCase(ulIdCase), request);

    try {
      forward(toDoDetailUri, request, context.getResponse());
    } catch (ServletException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure navigating to To-Do Detail Page:" + e.getMessage());
      processSevereException(context, e);
    }
  }

  /**
   * This method is called by the Grnds controller when the user clicks on one of the task links on Case To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayCaseToDoActionPage_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseToDoActionPage_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCCMN42DO rowccmn42do = getROWCCMN42DO(request, state);

    forwardToActionPage(rowccmn42do.getLdIdTodo(), context);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method will attempt to forward to the action page; if anything about the forward, which requires calling
   * CCMN30S and (for approvals only) CCMN34S, fails, it will not change the presentation branch or forward; instead,
   * the page that calls it should be capable of redisplaying with the information in request and state <i>before</i>
   * this method is called.
   * 
   * @param ldIdTodo
   *          The user id for the current user or the user as whom the current user is acting
   * @param ldIdTodo
   *          The ID_TODO for the selected row in the To-Do list
   * @param context
   *          The current <tt>GrndsExchangeContext</tt> object
   */
  private void forwardToActionPage(int ldIdTodo, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    CaseUtility.ToDo toDo = CaseUtility.getToDo(ldIdTodo);
    boolean doForward = toDo != null;

    // Used to store the URL to which we will forward
    String forwardUrl = null;

    // Call CaseUtility.getToDo to get information needed to forward to the detail page;
    // if this method returns null, it means that the ToDo no longer exists; this error
    // case is handled in the else clause of this block.
    if (doForward) {
      // Set forward back to false just in case there is an unexpected error below
      doForward = false;

      // Set information into GlobalData based on what we were passed
      GlobalData.setUlIdTodo(toDo.getIdTodo(), request);
      GlobalData.setUlIdEvent(toDo.getIdEvent(), request);
      GlobalData.setUlIdCase(toDo.getIdCase(), request);
      GlobalData.setSzNmCase(toDo.getNmCase(), request);
      GlobalData.setUlIdStage(toDo.getIdStage(), request);
      GlobalData.setSzNmStage(toDo.getNmStage(), request);
      GlobalData.setSzCdTask(toDo.getCdTask(), request);
      GlobalData.setSzCdStage(toDo.getCdStage(), request);
      GlobalData.setSzCdStageProgram(toDo.getCdStageProgram(), request);
      GlobalData.setSzCdStageType(toDo.getCdStageType(), request);

      // SIR 23530 - Also add Date Stage Start into global data.
      CaseUtility.Stage stageInfo = CaseUtility.getStage(toDo.getIdStage());
      GlobalData.setDtDtStageStart(stageInfo.getDtStart(), request);

      // Get the URL that we should go to out of the task table; this is the same url as event detail.
      forwardUrl = toDo.getTxtEventDetailUrl();

      // Set app mode to modify unless the todo is an approval, in which it should be set to approve
      String szCdTaskEventType = toDo.getCdTaskEventType();

      // We need the user object whether or not we have an approval
      UserProfile user = UserProfileHelper.getUserProfile(request);

      if (CodesTables.CEVNTTYP_APP.equals(szCdTaskEventType)) {
        // If there is more than 1 event being approved, forward to event list instead of the appropriate To-Do page
        if (CaseUtility.getApprovalEventCount(toDo.getIdEvent()) > 1) {
          Map<String, String> paramMap = new HashMap<String, String>();
          paramMap.put(EventSearchConversation.CALLER, EventSearchConversation.CALLER_TODO);
          forwardUrl = getUrl((EventSearchConversation.EVENT_LIST), paramMap);
        }
        CCMN34SO ccmn34so = ApprovalStatusConversation.callCCMN34S(toDo.getIdTodo(), toDo.getIdEvent(), context, admin,
                                                                   admin);
        boolean isApprover = false;
        ROWCCMN57DO_ARRAY rowccmn57do_array = ccmn34so != null ? ccmn34so.getROWCCMN57DO_ARRAY() : null;

        // If we don't enter this loop, ccmn34so was null; there will be an error message,
        // and doForward is still false, so do nothing.
        if (rowccmn57do_array != null && rowccmn57do_array.getROWCCMN57DOCount() > 0) {
          ROWCCMN57DO firstRowccmn57do = rowccmn57do_array.getROWCCMN57DO(0);

          // Update GlobalData with the information for the detail window;
          // get information from ccmn34so to mimic caps
          GlobalData.setUlIdEvent(firstRowccmn57do.getUlIdEvent(), request);
          String approveTask = firstRowccmn57do.getSzCdTask();

          if (!APPROVE_CALL_CD_TASK_NI.equals(toDo.getCdTask())) {
            GlobalData.setSzCdTask(approveTask, request);
          }

          GlobalData.setUlIdPerson(0, request); // mimics caps code

          // Loop through rowccmn57do_array and find all the related events
          int[] approvalEvents = new int[rowccmn57do_array.getROWCCMN57DOCount()];
          int i = 0;
          Enumeration<ROWCCMN57DO> rowccmn57doEnumeration = rowccmn57do_array.enumerateROWCCMN57DO();
          while (rowccmn57doEnumeration.hasMoreElements()) {
            ROWCCMN57DO rowccmn57do = rowccmn57doEnumeration.nextElement();
            approvalEvents[i++] = rowccmn57do.getUlIdEvent();
          }

          // Get the current user or user as whom we are acting
          int idUser = user.getUserID();
          UnitStaffIdentifier unitStaffIdentifier = UserProfileHelper.getUnitStaffIdentifier(request);
          int unitStaffId = unitStaffIdentifier != null ? unitStaffIdentifier.getUlIdStaff() : -1;
          
          // STGAP00013914: Designee of approver should be able to approve a task
          // Doing this only for the Payment of Care task.
          boolean isDesigneeOfApprover = false;
          if (toDo != null) {
            String cdTask = toDo.getCdTask();
            if (PAYMENT_OF_CARE_APPROVAL_CDTASK.equals(cdTask)) {
              int idApprover = toDo.getIdPersonAssigned();
              List tempAssignments = getUserProfile(context.getRequest()).getTempAssignments();
              if (tempAssignments != null && !tempAssignments.isEmpty()) {
                for (Iterator iter = tempAssignments.iterator(); iter.hasNext();) {
                  TempAssignment tempAssignment = (TempAssignment) iter.next();
                  String idTempAssignment = tempAssignment.getTempDesignatorID();
                  String idApproverString = Integer.toString(idApprover);
                  if (idTempAssignment != null && idApproverString != null && idTempAssignment.equals(idApproverString)) {
                    isDesigneeOfApprover = true;
                    break;
                  }
                }
              }
            }
          }
          
          // If the todo is assigned to the current user or the person as whom the user is currently
          // acting, then loop through the approval records to check for approval mode; otherwise,
          // we cannot be in approval mode.
           
          if (toDo.getIdPersonAssigned() == idUser || toDo.getIdPersonAssigned() == unitStaffId || isDesigneeOfApprover) {
            // Set the application into APPROVE mode if and only if the ldIdTodo matches that of the
            // first pending approvers record.
            ROWCCMN56DO_ARRAY rowccmn56do_array = ccmn34so.getROWCCMN56DO_ARRAY();
            Enumeration<ROWCCMN56DO> rowccmn56doEnumeration = rowccmn56do_array.enumerateROWCCMN56DO();
            while (rowccmn56doEnumeration.hasMoreElements()) {
              ROWCCMN56DO rowccmn56do = rowccmn56doEnumeration.nextElement();
              if (CodesTables.CAPPDESG_PEND.equals(rowccmn56do.getSzCdApproversStatus())) {
                // Only the first pending approval can be approved, so break no matter what;
                // we are the approver if and only if the ldIdTodo associated with the approval
                // record matches the ldIdTodo that we have from Global Data.
                if (rowccmn56do.getLdIdTodo() == ldIdTodo) {
                  isApprover = true;
                  break;
                } else {
                  isApprover = false;
                  break;
                }
              }
            }
          }
          

          if (isApprover) {
            // if we are the approver or acting as such appMode is ALWAYS edit, and hasStageAccess is ALWAYS true
            GlobalData.setAppMode(PageModeConstants.EDIT, request);
            GlobalData.setStageAccess(true, request);
            boolean isStageBeingApproved = toDo.isIndStageClosure();
            int approveStageClosure = isStageBeingApproved ? toDo.getIdStage() : 0;
            GlobalData.setApprovalMode(toDo.getIdTodo(), ccmn34so.getUlIdApproval(), approvalEvents,
                                       approveStageClosure, request);
          }

          // Set page mode to the same value as app mode to prevent modeproblems on pages that usually
          // come from event list; this can be done because appMode is _always_ VIEW or EDIT
          PageMode.setPageMode(GlobalData.getAppMode(request), request);

          // indicate that we can forward
          doForward = true;
        }
      } else {
        // Set AppMode based on stage access
        if (CaseUtility.hasStageAccess(user.getUserID(), GlobalData.getUlIdStage(request))) {
          GlobalData.setStageAccess(true, request);
          GlobalData.setAppMode(PageModeConstants.EDIT, request);
        } else {
          GlobalData.setStageAccess(false, request);
          GlobalData.setAppMode(PageModeConstants.VIEW, request);
        }
        PageMode.setPageMode(PageModeConstants.EDIT, request);

        ToDoHelper.setPageModeEditOverride(request, GlobalData.getSzCdTask(request), GlobalData.getUlIdStage(request),
                                           GlobalData.getUlIdEvent(request));

        // indicate that we can forward
        doForward = true;
      }
    } else {
      // SIR 22405 If we fall in here it means the to-do is broken (Data access error in caps)
      // display a message telling the user that the to-do is invalid and to disregard
      setErrorMessage(Messages.MSG_TODO_INVALID, request);
    }

    // Handle the case that the above did not result in a foward
    if (doForward) {
      // Clear state; at this point, all failures will cause processSeverException(), anyway
      getSessionStateManager(context).removeAllAttributes(request);
    } else {
      // If we are not forwarding, it means that we got an error;
      // clear szCdTask from GlobalData so the tabs don't change.
      GlobalData.setSzCdTask(null, request);

      // Instead of forwarding to the action page, we need
      // to forward back to the To-Do List that called us.
      forwardUrl = ToDoHelper.getReturnToToDoListURI(request);
    }

    try {
      forward(forwardUrl, request, context.getResponse());
    } catch (ServletException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure redisplaying To-Do List: " + e.getMessage());
      processSevereException(context, e);
    }
  }

  /**
   * This method is used to execute a search for Staff To-Do's for a particular person and date range.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   * @param id
   *          The id (userid or unitstaffid) to use for displaying the list
   */
  public void executeStaffToDoSearch(GrndsExchangeContext context, UserProfile user, int id) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // We can clear state when this is executed.
    state.removeAllAttributes(request);

    // Get the current search settings out of context
    ToDoHelper.ToDoStateInfo toDoStateInfo = ToDoHelper.getToDoStateInformation(request, id);
    if (toDoStateInfo == null) {
      // This means that this is the first time that this page has been displayed;
      // create a new ToDoHelper.ToDoStageInfo and set some defaults.
      toDoStateInfo = new ToDoHelper.ToDoStateInfo();
      toDoStateInfo.setId(id);
      toDoStateInfo.setOrderBy(STAFF_TODO_SORT_BY_DATE);
    }

    // Set the id and state info object into request and state (respectively) immediately,
    // so we display the list of stages even if there are no existing todos.
    request.setAttribute(TODO_STATE_ID_KEY, String.valueOf(id));
    ToDoHelper.setToDoStateInformation(request, toDoStateInfo);

    // Get the pagination information from the request if it's present
    TuxedoPaginationValueBean tuxedoPaginationValueBean = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxedoPaginationValueBean);
    DatabaseResultDetails databaseResultDetails = tuxedoPaginationValueBean.getResultDetails();
    databaseResultDetails.setResultsPerPage(RESULTS_PER_PAGE);

    // Update the toDoStateInfo appropriately if the user has searched
    if (ContextHelper.isParameterPresent(request, "dtFrom")) {
      // If we have a from date, we want to reset the dates and the page number, but nothing else
      toDoStateInfo.setFromDate(ContextHelper.getCastorDateSafe(request, "dtFrom"));
      toDoStateInfo.setToDate(ContextHelper.getCastorDateSafe(request, "dtTo"));
      // Set both the bean and the databaseResultsDetails to page one
      toDoStateInfo.setRequestedPage(1);
      databaseResultDetails.setRequestedPage(1);
      databaseResultDetails.setOrderBy(toDoStateInfo.getOrderBy());
    } else {
      // The user did not search; if the orderBy field of databaseResultDetails is null,
      // then the user did not just set the sort order or selec the page, either, so set them.
      if (databaseResultDetails.getOrderBy() == null) {
        databaseResultDetails.setOrderBy(toDoStateInfo.getOrderBy());
        databaseResultDetails.setRequestedPage(toDoStateInfo.getRequestedPage());
      } else {
        // Need to update the ToDoHelper.ToDoStateInfo object so it will be useful when we return.
        toDoStateInfo.setOrderBy(databaseResultDetails.getOrderBy());
        toDoStateInfo.setRequestedPage(databaseResultDetails.getRequestedPage());
      }
    }

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(user.getUserLogonID());
    archInputStruct.setUsPageNbr(databaseResultDetails.getRequestedPage());
    archInputStruct.setUlPageSizeNbr(databaseResultDetails.getResultsPerPage());
    String orderBy = databaseResultDetails.getOrderBy();
    archInputStruct.setCReqFuncCd(orderBy == null ? STAFF_TODO_SORT_BY_DATE : orderBy);

    // the from and to dates
    org.exolab.castor.types.Date fromDate = toDoStateInfo.getFromDate();
    org.exolab.castor.types.Date toDate = toDoStateInfo.getToDate();

    DtDtTodoDue_ARRAY dtDtTodoDue_array = new DtDtTodoDue_ARRAY();
    // toDate must be first in the array
    dtDtTodoDue_array.addDtDtTodoDue(fromDate);
    dtDtTodoDue_array.addDtDtTodoDue(toDate);

    CCMN11SI ccmn11si = new CCMN11SI();
    ccmn11si.setArchInputStruct(archInputStruct);
    ccmn11si.setDtDtTodoDue_ARRAY(dtDtTodoDue_array);
    // Use Global Data to get the UlIdStaff of for the staff member that we're interested in
    ccmn11si.setUlIdTodoPersAssigned(GlobalData.getUlIdStaff(request));

    try {
      CCMN11SO ccmn11so = admin.retrieveStaffTodo(ccmn11si);
      ROWCCMN17DO_ARRAY rowccmn17do_array = ccmn11so.getROWCCMN17DO_ARRAY();
      // we need to store both a map and a list so we preserve the order on the JSP page
      Map<Integer, ROWCCMN17DO> rowccmn17doMap = new HashMap<Integer, ROWCCMN17DO>();
      List<ROWCCMN17DO> rowccmn17doList = new ArrayList<ROWCCMN17DO>();
      Enumeration<ROWCCMN17DO> rowccmn17doEnum = rowccmn17do_array.enumerateROWCCMN17DO();
      while (rowccmn17doEnum.hasMoreElements()) {
        ROWCCMN17DO rowccmn17do = rowccmn17doEnum.nextElement();
        rowccmn17doMap.put(rowccmn17do.getLdIdTodo(), rowccmn17do);
        rowccmn17doList.add(rowccmn17do);
      }
      state.setAttribute(ROWCCMN17DO_MAP_KEY, rowccmn17doMap, request);
      state.setAttribute(ROWCCMN17DO_LIST_KEY, rowccmn17doList, request);
      // Comment for pagination
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn11so.getBMoreDataInd());
      ccmn11so.setArchOutputStruct(archOutputStruct);

      tuxedoPaginationValueBean.setPaginationInformation(ccmn11so.getArchOutputStruct(),
                                                         rowccmn17do_array.getROWCCMN17DOCount());
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_NO_ROWS_RETURNED:
        state.setAttribute(ROWCCMN17DO_MAP_KEY, null, request); // just set the rows to null, and we will display an
                                                                // error message
        state.setAttribute(ROWCCMN17DO_LIST_KEY, null, request); // just set the rows to null, and we will display an
                                                                  // error message
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE_STRING + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }
    // set the pagination information outside the try block so it is always set
    request.setAttribute(TuxedoPaginationValueBean.REQUEST_ATTRIBUTE_NAME, tuxedoPaginationValueBean);
  }

  /**
   * This method is called by the Grnds controller when the Staff To-Do page is displayed.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayStaffToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffToDo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    // Set the return page to Staff To-Do so when the user navigates on tasks, they go back to Case To-Do
    ToDoHelper.setReturnToStaffToDoList(request);

    // Need to clear the task code out of GlobalData so the page shows up under the right task
    GlobalData.setSzCdTask(null, request);

    // Clear out unit staff identifier information
    try {
      UserProfileHelper.setUnitStaffIdentifier(null, request);
    } catch (UserProfileException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure clearing UnitStaffIdentifier:" + e.getMessage());
      processSevereException(context, e);
    }

    // Get the current user information
    UserProfile user = UserProfileHelper.getUserProfile(request);

    int idStaff = user.getUserID();
    GlobalData.setUlIdStaff(idStaff, request);

    String szStaffFullName = user.getUserFullName();
    GlobalData.setSzNmStaff(szStaffFullName, request);

    // Use the negative value for the id in order to seperate staff and case todo's
    executeStaffToDoSearch(context, user, 0 - idStaff);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the Summary To-Do page is displayed.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayStaffToDoSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffToDoSummary_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    // Set the return page to Staff To-Do so when the user navigates on tasks, they go back to Case To-Do
    ToDoHelper.setReturnToStaffToDoSummaryList(request);

    // Need to clear the task code out of GlobalData so the page shows up under the right task
    GlobalData.setSzCdTask(null, request);

    UnitStaffIdentifier unitStaffIdentifier = UserProfileHelper.getUnitStaffIdentifier(request);

    if (unitStaffIdentifier == null) {
      throw new IllegalStateException("No UnitStaffIdentifier object found in session or state.");
    }

    String szStaffNameFull = unitStaffIdentifier.getSzStaffNameFull();
    GlobalData.setSzNmStaff(szStaffNameFull, request);

    int idStaff = unitStaffIdentifier.getUlIdStaff();
    GlobalData.setUlIdStaff(idStaff, request);

    String strMessage = "You are currently viewing the to-do list of " + szStaffNameFull + ".";
    setInformationalMessage(strMessage, DISPLAY_SUMMARY_TODO_URI, request);

    // Use the negative value for the id in order to seperate staff and case todo's
    executeStaffToDoSearch(context, UserProfileHelper.getUserProfile(request), 0 - idStaff);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the user clicks on the Delete button on Staff To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void deleteStaffToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteStaffToDo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String userLogonID = UserProfileHelper.getUserProfile(request).getUserLogonID();
    String returnUri = ToDoHelper.getReturnToToDoListURI(request);

    // Get the map of rowccmn17do objects out of state
    Map rowccmn17doMap = (Map) state.getAttribute(ROWCCMN17DO_MAP_KEY, request);

    // Loop through the checkboxes to find out which ones were checked.
    // Get the todo row out of state so we can check if it's a task todo.
    // If it's a task to-do, we need to call ccmn19s in order to delete it.
    // Otherwise, just delete it with ccmn97s
    // note that this is reload-safe because, once the ID of a todo has been deleted, it's gone
    LdIdTodo_ARRAY ldIdTodo_array = new LdIdTodo_ARRAY();
    // SMS #37449: Update size from hard-coded 50 to MAX_DELETE
    // so that the size of this list will change accordingly
    List<ROWCCMN17DO> taskToDoList = new ArrayList<ROWCCMN17DO>(MAX_DELETE);
    for (int i = 0; i < RESULTS_PER_PAGE; i++) {
      int idToDo = ContextHelper.getIntSafe(request, "cbIdToDo_" + i);
      if (idToDo != 0) {
        ROWCCMN17DO rowccmn17do = (ROWCCMN17DO) rowccmn17doMap.get(idToDo);
        if (CodesTables.CTODOTYP_T.equals(rowccmn17do.getSzCdTodoType())) {
          taskToDoList.add(rowccmn17do);
        } else {
          ldIdTodo_array.addLdIdTodo(idToDo);
        }
      }
    }

    // Create a boolean variable to see if there has been a service failure;
    // it will be used to fail the rest of the method as soon as there is an error.
    boolean serviceFailure = false;

    if (taskToDoList.size() > 0) {
      // The same archInputStruct will be used for all of the ccmn19s calls, so just create it once
      ArchInputStruct archInputStruct = new ArchInputStruct();
      archInputStruct.setSzUserId(userLogonID);
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);

      // The same values will be set on these each time, so we can safely reuse them
      ToDoAUDStruct toDoAUDStruct = new ToDoAUDStruct();
      CCMN19SI ccmn19si = new CCMN19SI();

      // put the try-catch outside the loop, so we fail on the first one
      try {
        for (ROWCCMN17DO rowccmn17do : taskToDoList) {
          toDoAUDStruct.setSzCdTodoType(rowccmn17do.getSzCdTodoType());
          toDoAUDStruct.setSzCdTodoTask(rowccmn17do.getSzCdTask());
          toDoAUDStruct.setUlIdStage(rowccmn17do.getUlIdStage());
          toDoAUDStruct.setLdIdTodo(rowccmn17do.getLdIdTodo());
          // CCMN43D only cares if the tsLastUpdate value is equal to or AFTER the existing value;
          // setting the value to the current date should ensure that we never get a timestamp
          // mismatch error.
          toDoAUDStruct.setTsLastUpdate(new java.util.Date());

          ccmn19si.setArchInputStruct(archInputStruct);
          ccmn19si.setToDoAUDStruct(toDoAUDStruct);
          // setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, DISPLAY_TODO_DETAIL_URI, request);
          // call the service
          admin.saveTodoInformation(ccmn19si);

          // setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, DISPLAY_TODO_DETAIL_URI, request);

        }
      } catch (ServiceException se) {
        // switch the response based on the Service Returned Error Code
        int errorCode = se.getErrorCode();
        switch (errorCode) {
        // This means that we tried to navigate on a todo that no longer exists
        case Messages.MSG_CMN_TODO_DELETED:
          setInformationalMessage(errorCode, returnUri, request);
        case Messages.MSG_SYS_STAGE_CLOSED:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        case Messages.MSG_SYS_MULT_INST:
          setErrorMessage(errorCode, request);
        default:
          GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE_STRING + se.getMessage());
          processSevereException(context, se);
        }
        serviceFailure = true;
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure Deleting Staff To-Do:" + e.getMessage());
        processSevereException(context, e);
        serviceFailure = true;
      }
    }

    if (!serviceFailure && ldIdTodo_array.getLdIdTodoCount() > 0) {
      ArchInputStruct archInputStruct = new ArchInputStruct();
      archInputStruct.setUlPageSizeNbr(ldIdTodo_array.getLdIdTodoCount());
      archInputStruct.setSzUserId(userLogonID);

      CCMN97SI ccmn97si = new CCMN97SI();
      ccmn97si.setLdIdTodo_ARRAY(ldIdTodo_array);
      ccmn97si.setArchInputStruct(archInputStruct);

      try {
        admin.deleteTodo(ccmn97si);
      } catch (ServiceException se) {
        // switch the response based on the Service Returned Error Code
        switch (se.getErrorCode()) {
        default:
          GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE_STRING + se.getMessage());
          processSevereException(context, se);
        }
        serviceFailure = true;
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure deleting using CCMN97S:" + e.getMessage());
        processSevereException(context, e);
        serviceFailure = true;
      }
    }

    if (!serviceFailure) {
      // Forward back to the display command
      try {
        forward(returnUri, request, context.getResponse());
      } catch (ServletException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure redisplaying To-Do: " + e.getMessage());
        processSevereException(context, e);
      }

    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the user clicks on the New Using button on Staff To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void newUsingStaffToDo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".newUsingStaffToDo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String returnToToDoListURI = ToDoHelper.getReturnToToDoListURI(request);

    ROWCCMN17DO rowccmn17do = getROWCCMN17DO(request, state);

    // Ignore this test if the row does not have a task code
    String szCdTask = rowccmn17do.getSzCdTask();
    if (szCdTask != null && !"".equals(szCdTask)
        && TaskInit.getTaskColumnString(szCdTask, TaskInit.CD_TASK_EVENT_TYPE).equals(CodesTables.CEVNTTYP_APP)) {
      setErrorMessage(Messages.MSG_CMN_ADDL_APPRV, request);
      try {
        forward(returnToToDoListURI, request, context.getResponse());
      } catch (ServletException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure redisplaying Staff To-Do: " + e.getMessage());
        processSevereException(context, e);
      }
      return;
    }

    ToDoDetailDB toDoDetailDB = new ToDoDetailDB();
    toDoDetailDB.setSzCdStage(rowccmn17do.getSzCdStage());
    toDoDetailDB.setSzCdStageProgram(rowccmn17do.getSzCdStageProgram());
    toDoDetailDB.setSzCdTask(rowccmn17do.getSzCdTask());
    toDoDetailDB.setSzNmStage(rowccmn17do.getSzNmStage());
    toDoDetailDB.setUlIdCase(rowccmn17do.getUlIdCase());
    toDoDetailDB.setUlIdEvent(rowccmn17do.getUlIdEvent());
    toDoDetailDB.setUlIdStage(rowccmn17do.getUlIdStage());
    toDoDetailDB.setLdIdTodo(rowccmn17do.getLdIdTodo());
    toDoDetailDB.setReturnURI(returnToToDoListURI);

    openToDoDetail(context, DISPLAY_TODO_DETAIL_NEW_USING_URI, toDoDetailDB);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the user clicks on one of the detail links on Staff To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayStaffToDoDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffToDoDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCCMN17DO rowccmn17do = getROWCCMN17DO(request, state);

    ToDoDetailDB toDoDetailDB = new ToDoDetailDB();
    toDoDetailDB.setSzCdStage(rowccmn17do.getSzCdStage());
    toDoDetailDB.setSzCdStageProgram(rowccmn17do.getSzCdStageProgram());
    toDoDetailDB.setSzCdTask(rowccmn17do.getSzCdTask());
    toDoDetailDB.setSzNmStage(rowccmn17do.getSzNmStage());
    toDoDetailDB.setUlIdCase(rowccmn17do.getUlIdCase());
    toDoDetailDB.setUlIdEvent(rowccmn17do.getUlIdEvent());
    toDoDetailDB.setUlIdStage(rowccmn17do.getUlIdStage());
    toDoDetailDB.setLdIdTodo(rowccmn17do.getLdIdTodo());
    toDoDetailDB.setReturnURI(ToDoHelper.getReturnToToDoListURI(request));
    toDoDetailDB.setDtDtTaskDue(rowccmn17do.getDtDtTodoDue());
    GlobalData.setAppMode(PageModeConstants.EDIT, request);

    openToDoDetail(context, DISPLAY_TODO_DETAIL_URI, toDoDetailDB);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Grnds controller when the user clicks on one of the task links on Staff To-Do.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void displayStaffToDoActionPage_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffToDoActionPage_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCCMN17DO rowccmn17do = getROWCCMN17DO(request, state);

    // The id of the staff person as whom we are acting should always be set
    forwardToActionPage(rowccmn17do.getLdIdTodo(), context);

    performanceTrace.exitScope();
  }

  /**
   * This method is used by various Staff To-Do methods to return the selected <tt>ROWCCMN17DO</tt> object from state
   * using the index stored in the request.
   * 
   * @param request
   *          the current <tt>HttpServletRequest</tt> object
   * @param state
   *          the current <tt>BaseSessionStateManager</tt> object
   * @return the <tt>ROWCCMN17DO</tt> object that was selected by the user
   */
  private static ROWCCMN17DO getROWCCMN17DO(HttpServletRequest request, BaseSessionStateManager state) {
    int ldIdTodo = ContextHelper.getIntSafe(request, "hdnIdTodo");
    Map rowccmn17doMap = (Map) state.getAttribute(ROWCCMN17DO_MAP_KEY, request);
    return (ROWCCMN17DO) rowccmn17doMap.get(ldIdTodo);
  }

  /**
   * This method is used by various Case To-Do methods to return the selected <tt>ROWCCMN42DO</tt> object from state
   * using the index stored in the request.
   * 
   * @param request
   *          the current <tt>HttpServletRequest</tt> object
   * @param state
   *          the current <tt>BaseSessionStateManager</tt> object
   * @return the <tt>ROWCCMN42DO</tt> object that was selected by the user
   */
  private static ROWCCMN42DO getROWCCMN42DO(HttpServletRequest request, BaseSessionStateManager state) {
    int ldIdTodo = ContextHelper.getIntSafe(request, "hdnIdTodo");
    Map rowccmn42doMap = (Map) state.getAttribute(ROWCCMN42DO_MAP_KEY, request);
    return (ROWCCMN42DO) rowccmn42doMap.get(ldIdTodo);
  }

  /**
   * This method is used to return the To-Do mask, which can be used in logical operations or case statements easily,
   * for a given To-Do Mode.
   * 
   * @param toDoMode
   *          a <tt>String</tt> containing the current To-Do Mode
   * @return The To-Do mask for the provided mode.
   */
  public static int getToDoMask(String toDoMode) {
    if (toDoMode == null || "".equals(toDoMode)) {
      throw new IllegalArgumentException("The ToDo Mode must be non-null and non-empty.");
    }
    Integer toDoModeInteger = toDoModeMap.get(toDoMode);
    if (toDoModeInteger == null) {
      throw new IllegalArgumentException("Illegal ToDo Mode: " + toDoMode);
    } else {
      return toDoModeInteger;
    }
  }

  /**
   * This method returns the code used in cReqFuncCd for the given To-Do Mode.
   * 
   * @param toDoMode
   *          a <tt>String</tt> containing the current To-Do Mode
   * @return The code used in cReqFuncCd for the given To-Do Mode.
   */
  public static String getToDoCode(String toDoMode) {
    if (toDoMode == null || "".equals(toDoMode)) {
      throw new IllegalArgumentException("The ToDo Mode must be non-null and non-empty.");
    }
    String toDoCode = toDoCodeMap.get(toDoMode);
    if (toDoCode == null) {
      throw new IllegalArgumentException("Illegal ToDo Mode: " + toDoMode);
    } else {
      return toDoCode;
    }
  }

  /** Return a set of task codes that are valid to create new case todos for this stage */
  protected static Set getValidTaskCodesForCreatingTodos(int ulIdStage, String szCdStage, String szCdStageProgram) {
    Set validSzCdTaskSet = TaskInit.getCaseTodoTasks(szCdStage, szCdStageProgram);
    Set pendingEventTaskSet = CaseUtility.getPendingEventTasks(ulIdStage);

    // filter out tasks that have pending events
    for (Iterator validSzCdTaskSetIterator = validSzCdTaskSet.iterator(); validSzCdTaskSetIterator.hasNext();) {
      Option option = (Option) validSzCdTaskSetIterator.next();
      String szCdTask = option.getCode();
      if (pendingEventTaskSet.contains(szCdTask)) {
        validSzCdTaskSetIterator.remove();
      }
    }
    return validSzCdTaskSet;
  }

  public static final int NUMMBER_TASK_ROWS = 200;

  public static final String TRACE_TAG = "ToDoConversation";

  // A constant for the ToDoDetailDB object that is stored in state;
  // it is protected to encourage use of the getter and setter.
  protected static final String TODO_EVENTS_KEY = TRACE_TAG + ".TODO_EVENTS_KEY";

  // These are constants necessary for interacting with To-Do detail services correctly
  public static final int SHORT_DESCRIPTION_SIZE = 80;

  public static final String DASH_STRING = " - ";

  public static final String CREATED_NAME_SYSTEM = "System";

  public static final String APPROVAL_FLAG = "Z";

  // Types of To-Do's
  // public static final String TASK_TODO = "T";
  // public static final String REMINDER_TODO = "R";
  // public static final String ALERT_TODO = "A";

  // URLs for the To-Do pages
  public static final String DISPLAY_TODO_DETAIL_URI = "/workload/ToDo/displayToDoDetail";

  public static final String DISPLAY_TODO_DETAIL_NEW_USING_URI = "/workload/ToDo/newUsingToDo";

  public static final String DISPLAY_TODO_DETAIL_NEW_APPROVAL_URI = "/workload/ToDo/newApprovalToDo";

  public static final String DISPLAY_TODO_DETAIL_NEXT_APPROVAL_URI = "/workload/ToDo/nextApprovalToDo";

  public static final String DISPLAY_TODO_DETAIL_NEW_CASE_TODO_URI = "/workload/ToDo/newCaseToDo";

  public static final String DISPLAY_STAFF_TODO_URI = "/workload/ToDo/displayStaffToDo";

  public static final String DISPLAY_SUMMARY_TODO_URI = "/workload/ToDo/displayStaffToDoSummary";

  public static final String DISPLAY_CASE_TODO_LIST_URI = "/workload/ToDo/displayCaseToDo";

  // Uri for returning from staff search
  public static final String RETURN_FROM_STAFF_SEARCH_URI = "/workload/ToDo/returnFromStaffSearch";

  // Branch for displaying To-Do Detail in modify mode when supervisors save&submit
  public static final String BRANCH_ALREADY_SUBMITTED = "already_submitted";

  public static final int DISABLE_STAFF_SERACH_BUTTON_SET = Sets.B;

  // Constants for Case To-Do
  public static final String ROWCCMN42DO_MAP_KEY = TRACE_TAG + ".ROWCCMN42DO_MAP_KEY";

  public static final String ROWCCMN42DO_LIST_KEY = TRACE_TAG + ".ROWCCMN42DO_LIST_KEY";

  // Page sets for Case To-Do
  public static final int CASE_TODO_BUTTON_SET = Sets.A;

  // Sorting constants for Case To-Do
  public static final String CASE_TODO_SORT_BY_ASSIGNED = "1";

  public static final String CASE_TODO_SORT_BY_DATE = "2";

  public static final String CASE_TODO_SORT_BY_CREATOR = "3";

  // Constants for Staff To-Do
  public static final String ROWCCMN17DO_MAP_KEY = TRACE_TAG + ".ROWCCMN17DO_MAP_KEY";

  public static final String ROWCCMN17DO_LIST_KEY = TRACE_TAG + ".ROWCCMN17DO_LIST_KEY";

  // Sorting constants for Staff To-Do
  public static final String STAFF_TODO_SORT_BY_CASE = "1";

  public static final String STAFF_TODO_SORT_BY_DATE = "2";

  public static final String STAFF_TODO_SORT_BY_CREATOR = "3";

  public static final String STAFF_TODO_SORT_BY_DESCRIPTION = "4";

  // Constants used for both Case To-Do and Staff To-Do
  public static final int RESULTS_PER_PAGE = 100;

  public static final int MAX_DELETE = 100;

  public static final String TODO_STATE_ID_KEY = TRACE_TAG + "_TODO_STATE_ID_KEY";

  // Constants for column values in the Task table
  public static final String IND_TRUE = "1";

  public static final String IND_FALSE = "0";

  // Constants for deciding when to link to an existing event when creating a new to-do
  public static final String IND_TASK_NEW_TRUE = "TRUE";

  public static final String IND_TASK_NEW_PROMPT = "PROMPT";

  public static final String IND_TASK_NEW_FALSE = "FALSE";

  public static final String IND_TASK_MUST_LINK = "LINK";

  /** Initialize task order; this class is used to determine the "order" for event states */
  private static class EventStatusComparitor {
    /**
     * This method is used to create a new comparitor for a particular list of event status codes.
     * 
     * @param eventStatusList
     *          a list of event status codes
     */
    public EventStatusComparitor(List<String> eventStatusList) {
      int i = 0;
      Iterator<String> eventStatusIterator = eventStatusList.iterator();
      while (eventStatusIterator.hasNext()) {
        eventStatusMap.put(eventStatusIterator.next(), i);
        i++;
      }
    }

    /**
     * This methods is used to compare to two event status Strings. Unlike compare methods implementing the
     * <tt>java.lang.Comparable</tt> interface, it takes <tt>String</tt> objects instead of <tt>Object</tt>
     * objects and sorts nulls to the end.
     * 
     * @param es1
     *          the first event status <tt>String</tt>
     * @param es2
     *          the second event status <tt>String</tt>
     * @return an Integer that is greater than 0 if the second event is greater than the first, 0 if the two events are
     *         equal, and less than 0 if the first event is greater than the second; null values are essentially treated
     *         as positive infinity, sorting them to the end
     */
    public int compare(String es1, String es2) {
      Integer i1 = eventStatusMap.get(es1);
      Integer i2 = eventStatusMap.get(es2);

      int returnValue;
      if (i1 == null && i2 == null) {
        returnValue = 0;
      } else if (i1 == null) {
        returnValue = 1;
      } else if (i2 == null) {
        returnValue = -1;
      } else {
        // just subtract the integer values of what we get because we know that they represent the ordinality of the
        // event stati
        returnValue = i2 - i1;
      }
      return returnValue;
    }

    private Map<String, Integer> eventStatusMap = new HashMap<String, Integer>();
  }

  // this list is the "order" of event stati; it is used to determine when to pass cSysIndTaskNew
  private static final List<String> eventStatusList = new ArrayList<String>();

  static {
    eventStatusList.add(CodesTables.CEVTSTAT_NEW);
    eventStatusList.add(CodesTables.CEVTSTAT_PROC);
    eventStatusList.add(CodesTables.CEVTSTAT_COMP);
    eventStatusList.add(CodesTables.CEVTSTAT_PEND);
    eventStatusList.add(CodesTables.CEVTSTAT_APRV);
  }

  private static final EventStatusComparitor eventStatusComparitor = new EventStatusComparitor(eventStatusList);

  // A constant representing a "don't care" value for the To-Do Code
  private static final String DO_NOT_CARE_CODE = "_";

  public static final String TODO_MODE_NEW_CASE_TODO = "TODO_MODE_NEW_CASE_TODO";

  private static final int TODO_MODE_NEW_CASE_TODO_MASK = 0x1;

  private static final String TODO_MODE_NEW_CASE_TODO_CODE = "Z";

  public static final String TODO_MODE_NEW_FCE_TODO = "TODO_MODE_NEW_FCE_TODO";

  private static final int TODO_MODE_NEW_FCE_TODO_MASK = 0x2;

  private static final String TODO_MODE_NEW_FCE_TODO_CODE = "Z";

  public static final String TODO_MODE_MODIFY = "TODO_MODE_MODIFY";

  private static final int TODO_MODE_MODIFY_MASK = 0x10;

  private static final String TODO_MODE_MODIFY_CODE = ServiceConstants.REQ_FUNC_CD_UPDATE;

  public static final String TODO_MODE_NEW_APPROVAL = "TODO_MODE_NEW_APPROVAL";

  private static final int TODO_MODE_NEW_APPROVAL_MASK = 0x40;

  private static final String TODO_MODE_NEW_APPROVAL_CODE = "X";

  public static final String TODO_MODE_NEW_USING = "TODO_MODE_NEW_USING";

  private static final int TODO_MODE_NEW_USING_MASK = 0x80;

  // this code can be anything that does not conflict with ADD, ASSIGN, MODIFY, NEW_APPROVAL, or NEXT_APPROVAL;
  // it is not directly referenced in CCMN13S CCMN19S, so it does not matter what the exact value is
  private static final String TODO_MODE_NEW_USING_CODE = DO_NOT_CARE_CODE;

  public static final String TODO_MODE_NEXT_APPROVAL = "TODO_MODE_NEXT_APPROVAL";

  private static final int TODO_MODE_NEXT_APPROVAL_MASK = 0x100;

  private static final String TODO_MODE_NEXT_APPROVAL_CODE = "Y";

  private static final String SVC_STAGE_CLOSURE_TASK_CODE = "6010";

  private static final Map<String, Integer> toDoModeMap = new HashMap<String, Integer>();

  private static final Map<String, String> toDoCodeMap = new HashMap<String, String>();

  static {
    ToDoConversation.toDoModeMap.put(ToDoConversation.TODO_MODE_NEW_CASE_TODO,
                                     ToDoConversation.TODO_MODE_NEW_CASE_TODO_MASK);
    ToDoConversation.toDoCodeMap.put(ToDoConversation.TODO_MODE_NEW_CASE_TODO,
                                     ToDoConversation.TODO_MODE_NEW_CASE_TODO_CODE);

    ToDoConversation.toDoModeMap.put(ToDoConversation.TODO_MODE_NEW_FCE_TODO,
                                     ToDoConversation.TODO_MODE_NEW_FCE_TODO_MASK);
    ToDoConversation.toDoCodeMap.put(ToDoConversation.TODO_MODE_NEW_FCE_TODO,
                                     ToDoConversation.TODO_MODE_NEW_FCE_TODO_CODE);

    ToDoConversation.toDoModeMap.put(ToDoConversation.TODO_MODE_MODIFY, ToDoConversation.TODO_MODE_MODIFY_MASK);
    ToDoConversation.toDoCodeMap.put(ToDoConversation.TODO_MODE_MODIFY, ToDoConversation.TODO_MODE_MODIFY_CODE);

    ToDoConversation.toDoModeMap.put(ToDoConversation.TODO_MODE_NEW_APPROVAL,
                                     ToDoConversation.TODO_MODE_NEW_APPROVAL_MASK);
    ToDoConversation.toDoCodeMap.put(ToDoConversation.TODO_MODE_NEW_APPROVAL,
                                     ToDoConversation.TODO_MODE_NEW_APPROVAL_CODE);

    ToDoConversation.toDoModeMap.put(ToDoConversation.TODO_MODE_NEW_USING, ToDoConversation.TODO_MODE_NEW_USING_MASK);
    ToDoConversation.toDoCodeMap.put(ToDoConversation.TODO_MODE_NEW_USING, ToDoConversation.TODO_MODE_NEW_USING_CODE);

    ToDoConversation.toDoModeMap.put(ToDoConversation.TODO_MODE_NEXT_APPROVAL,
                                     ToDoConversation.TODO_MODE_NEXT_APPROVAL_MASK);
    ToDoConversation.toDoCodeMap.put(ToDoConversation.TODO_MODE_NEXT_APPROVAL,
                                     ToDoConversation.TODO_MODE_NEXT_APPROVAL_CODE);

  }

  public void saveAlert_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ToDoDetailDB toDoDetailDB = ToDoConversation.getToDoDetailDB(request, state);

    TodoAlertSaveSI todoalertsavesi = new TodoAlertSaveSI();
    todoalertsavesi.setIdTodoPersAssignedList(new ArrayList<Integer>()); //  SMS#97845 MR-074-2 AFCARS
    toDoDetailDB.setSzTxtTodoDesc(ContextHelper.getStringSafe(request, "txtSzTxtTodoDesc"));
    toDoDetailDB.setTxtTodoLongDesc(ContextHelper.getStringSafe(request, "txtSzTxtTodoLongDesc"));
    toDoDetailDB.setDtDtTodoDue(ContextHelper.getCastorDateSafe(request, "dtDueDate"));

    String txtTodoDesc = toDoDetailDB.getSzTxtTodoDesc();
    String txtTodoLongDesc = toDoDetailDB.getTxtTodoLongDesc();
    int idStage = toDoDetailDB.getUlIdStage();
    java.util.Date dueDate = null;
    if(toDoDetailDB.getDtDtTodoDue() != null){
      dueDate = toDoDetailDB.getDtDtTodoDue().toDate();
    }
    int idTodoPersAssigned = toDoDetailDB.getUlIdTodoPersAssigned();
    int idPersonCreator = toDoDetailDB.getUlIdTodoPersCreator();
    todoalertsavesi.setTxtTodoShortDesc(txtTodoDesc);
    todoalertsavesi.setIdStage(idStage);
    // SMS#97845 MR-074-2 AFCARS: replaced setIdTodoPersAssigned by setIdTodoPersAssignedList  
    // since the service has been modified to save a list of todos.
    todoalertsavesi.getIdTodoPersAssignedList().add(idTodoPersAssigned);
    todoalertsavesi.setIdPersonCreator(idPersonCreator);
    todoalertsavesi.setTxtTodoLongDesc(txtTodoLongDesc);
    todoalertsavesi.setDueDate(dueDate);

    toDoDetailDB.setReturnURI(DISPLAY_CASE_TODO_LIST_URI);

    admin.saveTodoAlert(todoalertsavesi);
    setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, DISPLAY_CASE_TODO_LIST_URI, request);

  }
}
