package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT99SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRecordsCheckCompletedSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageRow;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT99SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.io.StringReader;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class is used to display the Intake Priority/Closure
 * page.  It will also be used to save and close stages.
 *
 * @author
 * Rodrigo DeJuana, January 10, 2003
 * <pre>
 *
 *  Change History:
 *   Date        User      Description
 *   ----------  --------  --------------------------------------------------
 *   06/06/03  GRIMSHAN    SIR 16979 - Retrieve page mode from event search conversation
 *                         if the page mode does not need to be changed, it will not be
 *   07/23/03  JMC         SIR 19079 - The MSG_INT_CREATE_NOTIFICATION requirement was
 *                         being called for RCL and CCL stages when it should only
 *                         have been required for CPS stages.
 *   08/07/03  JMC         SIR 19146 - The form was previously view only, modified
 *                         conversation such that the form will be editable.  Note
 *                         that template changes were also made.
 *   08/28/03  JMC         SIR 19652 - There is no idEvent associated with the
 *                         Priority/Closure page.  In certain instances we have idEvent's
 *                         lingering in GlobalData that are being read incorrectly by the
 *                         EventSearchConversation and hosing up the way the Priority/Closure
 *                         page displays.  I am just removing the code associated with SIR 16979.
 *   06/15/04    CORLEYAN  SIR 22954 -- If the user is saving "N" and the page mode is not B,
 *                         save the reason closed and the comments.
 *   02/17/04    dejuanr   SIR 18305 - Sending date last update of incoming detail table
 *                         so it can update the incoming_detail table row with a status of CLD
 *   05/09/05    ochumd    Sir 23019 - Added 3 Special Request types to the
 *                         Special Request Type List:CCL Standards Violation
 *                         RCL Standards Violation and CPS Foster Home Standards Violation.
 *   04/30/2009  jramspott Major re-write for Georgia SHINES. STGAP00008086
 *   
 *   07/22/2008  arege     STGAP00009014: Added new column to Stage Table to store 
 *                         comments on IntakeClosure page under Response Time
 *                         for Regular Intakes. This sets the SzTxtStageResponseTimeCmnts
 *                         field of InStageRow instead of setSzTxtStagePriorityCmnts   
 *                         
 *   07/22/2008  arege     STGAP00008791: Updated the saveAndCloseIntakeClosure_xa()
 *                         so that  the  The Assigned Workload page
 *                         reloads with My Tasks, Workload tabs after SaveAndClose. 
 *   07/08/2011  arege     SMS#109422: Records check required message needs to be thrown when approving Screen Out intakes.                                                   
 *   
 *
 * </pre>
 */

/**
 * ***************************************************************************** *  Declare your conversation class and
 * have it extend *  BaseHiddenFieldStateConversation class. ******************************************************************************
 */

public class IntakeClosureConversation extends BaseHiddenFieldStateConversation {

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "IntakeClosureConversation";

  public static final String EVENT_STATUS_COMP = "COMP";
  public static final String EVENT_STATUS_PEND = "PEND";
  public static final String EVENT_STATUS_PROC = "PROC";
  public static final String PRIORITY_UPDATE_EVENT_CODE = "PRT";
  public static final String STAGE_EVENT_CODE = "STG";
  public static final String INTAKE_CLOSURE_EVENT_CODE = "INC";
  
  public static final String STAGE_NON_INCIDENT_CLOSED_DESC = "Non Incident Stage Closed";
  public static final String INTAKE_CLOSURE_EVENT_DESC = "A change to Intake after approval has been submitted";
  

  public static final String CT_CURRENT_PRIORITY="CPRIORTY";
  public static final String CT_REASON_CHANGED = "CRSNPRIO";
  public static final String CT_REASON_SCREENED_OUT = "CSCNOTRN";

  public static final String PROG_CPS = "CPS";

  public static final String STAGE_INT = "INT";
  public static final String STAGE_INV = "INV";

  public static final String CAPS_WIN_MODE_SELECT = "S";

  public static final String REQ_FUNC_SAVE = "S";
  public static final String REQ_FUNC_CLOSE = "E";
  public static final String REQ_FUNC_PRI_CHNG = "P";

  public static final String DISPLAY_PAGE = "/workload/IntakePriorityClosure/displayPriorityClosure";

  public static final String CINT99SO_STRING = "CINT99SO";

  public static final String PRIORITY_SELECT_BOX = "selSzCdStageCurrPriority";
  public static final String DISPOSITION_SELECT_BOX = "selSzCdDisp";
  public static final String SCREENOUT_SELECT_BOX = "selSzCdScreenOutReason";

  public static final String INCOMING_DETAIL_TABLE = "INCOMING_DETAIL";
  public static final String ID_STAGE_COLUMN = "ID_STAGE";
  public static final String EVENT_TABLE="EVENT";
  public static final String ID_EVENT_COLUMN="ID_EVENT";
  
  public static final String APP_INT_TASK="1100";
  public static final String SUB_INC_TASK="1090";
  
  public static final String BRANCH_APPROVAL_TO_DO = "ApprovalToDo";
  
  public static final String INTAKE_CLOSURE = "Intake Closure";

  
  private Intake intake1;
  
  private Person person;


  public void setIntake(Intake intake1) {
    this.intake1 = intake1;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
  
  /**
   * This method will set the mode, then call the cint99s service to retrieve the data it needs to display the page.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayIntakeClosure_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPriorityClosure_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    state.removeAllAttributes(request);

    PageMode.setPageMode(GlobalData.getAppMode(request), request);

    try {
      CINT99SI cint99si = populateCINT99SI_Retrieve(context);
      CINT99SO cint99so = intake1.retrieveIntakePriorityClosure(cint99si);
      state.setAttribute(CINT99SO_STRING, cint99so, request);

      // SIR 18305 Start - Get the data last update for the incoming_detail table so
      // we can update the status.
      Date tsIncmngDtlDateLastUpdate = CaseUtility.getDateLastUpdate(INCOMING_DETAIL_TABLE,
                                                                     ID_STAGE_COLUMN, GlobalData.getUlIdStage(request));

      state.setAttribute("tsIncmngDtlDateLastUpdate", tsIncmngDtlDateLastUpdate, request);
       // Depending what is passed in, the page will be in one of three  sets.
      setMode(context, cint99so);
      // SIR 18305 End
      int existingIncEvent = cint99so.getUlIdEvent();
      
      if (existingIncEvent > 0) {
        Date incDateLastUpdate = CaseUtility.getDateLastUpdate(EVENT_TABLE,
                                                               ID_EVENT_COLUMN, existingIncEvent);
        state.setAttribute("tsIncDateLastUpdate", incDateLastUpdate, request);
        GlobalData.setUlIdEvent(existingIncEvent, request);
        String eventStatus = CaseUtility.getSzCdEventStatus(existingIncEvent);
        if (StringHelper.isValid(eventStatus) && EVENT_STATUS_PROC.equals(eventStatus)) {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INT_SAVE_RESP_TIME_DISP);
          setErrorMessage(errorMessage, DISPLAY_PAGE, context.getRequest());
        }
      }
      else {
        state.setAttribute("tsIncDateLastUpdate", null, request);
        GlobalData.setUlIdEvent(0, request);
      }
      
    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INT_STAGE_NOT_FOUND);
          displayMessagePage(errorMessage, context);
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method save the page.  Depending what button they pressed, it may close the stage as well.  It will call
   * cint21s service.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveAndSubmitIntakeClosure_xa(GrndsExchangeContext context) {
    saveIntakeClosure(context, true);
  }
  
  /**
   * This Updates the Intake and creates events as needed.  Depending what button they pressed, it may close the stage as well.  It will call
   * cint21s service.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveIntakeClosure(GrndsExchangeContext context, boolean submitMe) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitIntakeClosure_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      boolean bSaveandClose = ContextHelper.getString(request, "btnSaveAndClose.x") != null;
      boolean bSaveAndSubmit = ContextHelper.getString(request, "btnSaveAndSubmit.x") != null;
      String disposition = ContextHelper.getStringSafe(request, DISPOSITION_SELECT_BOX);
      String screenOutReason = ContextHelper.getStringSafe(request, SCREENOUT_SELECT_BOX);
      String priority = ContextHelper.getStringSafe(request, PRIORITY_SELECT_BOX);

      CINT99SO cint99so = (CINT99SO) state.getAttribute(CINT99SO_STRING, request);
      

      CINT21SI cint21si = populateCINT21SI_Save(context);
      
   // SMS#109422: If the disposition is SCO or SCR check to see if the Records Check is completed
      if (CodesTables.CDISP_SCO.equals(cint21si.getSzCdIncomingDisposition())
          || CodesTables.CDISP_SCR.equals(cint21si.getSzCdIncomingDisposition())) {
        int idStage = cint21si.getStageRow().getUlIdStage();
        CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI = new CheckIfRecordsCheckCompletedSI();
        checkIfRecordsCheckCompletedSI.setIdStage(idStage);
        checkIfRecordsCheckCompletedSI.setPageName(INTAKE_CLOSURE);
        String recordsCheckCompleted = person.checkIfRecordsCheckCompleted(checkIfRecordsCheckCompletedSI);
      }
      
      //WtcHelper.callService("CINT21S", cint21si);
      CINT21SO cint21so = intake1.saveIntakePriorityClosure(cint21si);
      GrndsTrace.msg(TRACE_TAG, 7, "cint21so.getUlIdEvent=<" + cint21so.getUlIdEvent() + ">");
      
      // for submissions, time to create a Todo
      if (submitMe) {
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(cint21so.getUlIdEvent(), cint21si.getStageRow().getUlIdCase(),
                                                   cint21si.getStageRow().getUlIdStage(), APP_INT_TASK);
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      }
    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      resetCINT99SO(context);
      String errorMessage = "";
      this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
          errorMessage = MessageLookup.getMessageByNumber(Messages.SQL_NOT_FOUND);
          setErrorMessage(errorMessage, DISPLAY_PAGE, context.getRequest());
          break;
        case Messages.MSG_SYS_STAGE_CLOSED:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
          setErrorMessage(errorMessage, DISPLAY_PAGE, context.getRequest());
          break;
        case Messages.MSG_CMN_STAGE_CLOSED:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_STAGE_CLOSED);
          setErrorMessage(errorMessage, DISPLAY_PAGE, context.getRequest());
          break;
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          setErrorMessage(errorMessage, DISPLAY_PAGE, context.getRequest());
          break;
        case Messages.MSG_INV_CDNFSI_APRV:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_CDNFSI_APRV);
          setErrorMessage(errorMessage, DISPLAY_PAGE, context.getRequest());
          break;
        case Messages.MSG_RECORDS_CHECK_REQ: //SMS#109422:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_RECORDS_CHECK_REQ);
          setErrorMessage(errorMessage, DISPLAY_PAGE, context.getRequest());
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  /**
   * This method save the page and close the stage and case.  Depending what button they pressed, it may close the stage as well.  It will call
   * cint21s service.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveAndCloseIntakeClosure_xa(GrndsExchangeContext context) {
    saveIntakeClosure(context, false);
    HttpServletRequest request = context.getRequest();
    try {
      // STGAP00008791: After SaveAndClose the The Assigned Workload page reloads with My Tasks, Workload tabs.
      GlobalData.setSzCdTask(null, request);
      forward("/workload/AssignedWorkload/displayAssignedWorkload", request, context.getResponse());
    } catch (ServletException se) {
      processSevereException(context, se);
    }
  }

  /**
   * Populates the cint99si object.  Nothing really special about this one. :-p
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private CINT99SI populateCINT99SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINT99SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CINT99SI cint99si = new CINT99SI();

    cint99si.setUlIdStage(GlobalData.getUlIdStage(request));
    cint99si.setSzCdEventStatus(EVENT_STATUS_COMP);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cint99si;
  }

  /**
   * Populates the cint21si object.  This one can be quite complex.  Depending on the mode of the page, what button is
   * pressed, and many other things the outcome will vary.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private CINT21SI populateCINT21SI_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINT21SI_Save");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    ArchInputStruct input = new ArchInputStruct();
    CINT21SI cint21si = new CINT21SI();
    ROWCCMN01UIG00 EventStatus = new ROWCCMN01UIG00();
    StageRow InStageRow = new StageRow();
    CINT99SO cint99so = (CINT99SO) state.getAttribute(CINT99SO_STRING, request);
    gov.georgia.dhr.dfcs.sacwis.structs.output.StageRow OutStageRow = cint99so.getStageRow();

    boolean bSaveAndSubmit = ContextHelper.getString(request, "btnSaveAndSubmit.x") != null;
    boolean bSaveandClose = ContextHelper.getString(request, "btnSaveAndClose.x") != null;
    boolean bPriChange = !ContextHelper.getStringSafe(request, PRIORITY_SELECT_BOX).equals(ContextHelper.getStringSafe(
            request, "hdnSzCdStageCurrPriority"));
    boolean bDispChange = !ContextHelper.getStringSafe(request, DISPOSITION_SELECT_BOX).equals(ContextHelper.getStringSafe(
            request, "hdnSzCdIncomingDisposition"));
    if (bPriChange) {
      cint21si.setBIndPriorityChanged("Y");
    }
    else {
      cint21si.setBIndPriorityChanged("N");
    }
    if (bDispChange) {
      cint21si.setBIndDispositionChanged("Y");
    }
    else {
      cint21si.setBIndDispositionChanged("N");
    }
    char mode = Sets.getPageSet(request).toCharArray()[0];
    String reqFunc = "";
    switch (mode) {
      case'A':
        reqFunc = "";
        break;
      case'B':
        // In mode B user is changing priority and/or disposition
        reqFunc = REQ_FUNC_SAVE;
        break;
      case'C':
        // Similar to mode B, but here you can only close.  The Save and Submit button is disabled in this mode.
        reqFunc = REQ_FUNC_CLOSE;
        break;
      default:
    }

    input.setCReqFuncCd(reqFunc);
    input.setSzUserId(user.getUserLogonID());

    if (mode != 'A') {
      EventStatus.setUlIdPerson(user.getUserID());
    }
    EventStatus.setUlIdStage(GlobalData.getUlIdStage(request));
    EventStatus.setDtDtEventOccurred(ContextHelper.getCastorDateSafe(request, "txtDtSysDtGenericSysdate"));
    
    if (mode == 'B') { // Save and Submit Regular - Event passed down is the INC event, which could exist if prior update rejected
      EventStatus.setSzCdEventType(INTAKE_CLOSURE_EVENT_CODE);
      EventStatus.setSzCdEventStatus(EVENT_STATUS_PEND);
      EventStatus.setSzTxtEventDescr(INTAKE_CLOSURE_EVENT_DESC);
      Date incDateLastUpdate = (Date) state.getAttribute("tsIncDateLastUpdate", request);
      EventStatus.setTsLastUpdate(incDateLastUpdate);
    }
    else if (mode == 'C') { // Non Incident Event Closed - go direct to closure - no to-do needed
      EventStatus.setSzCdEventType(STAGE_EVENT_CODE);
      EventStatus.setSzCdEventStatus(EVENT_STATUS_COMP);
      EventStatus.setSzTxtEventDescr(STAGE_NON_INCIDENT_CLOSED_DESC);
      cint21si.setSzTxtEventDescr(STAGE_NON_INCIDENT_CLOSED_DESC);
    }

    // Copy the Stage Row we got from cint99so into an input object.
    try {
      InStageRow = StageRow.unmarshal(new StringReader(OutStageRow.toString()));
    }
    catch (Exception e) {
      performanceTrace.msg(TRACE_TAG, 3, "Stage Row copy failed.");
    }

    // Since the user can't modify the field when in mode A, don't do it.  There
    // are some values we set for them on the other side of the if statement.
    if ("B".equals(Sets.getPageSet(request))) {

      String currPri = ContextHelper.getStringSafe(request, PRIORITY_SELECT_BOX);
      String prevPri = ContextHelper.getStringSafe(request, "hdnSzCdStageCurrPriority");

      InStageRow.setSzCdStageCurrPriority(ContextHelper.getStringSafe(request, PRIORITY_SELECT_BOX));
      InStageRow.setSzCdStageRsnPriorityChgd(ContextHelper.getStringSafe(request, "selSzCdStageRsnPriorityChgd"));
      //STGAP00009014: Added new column to Stage Table to store 
      //               comments on IntakeClosure page under Response
      //               Time for Regular Intakes. This sets the SzTxtStageResponseTimeCmnts
      //               field of InStageRow instead of setSzTxtStagePriorityCmnts
      InStageRow.setSzTxtStageResponseTimeCmnts(ContextHelper.getStringSafe(request, "szTxtStageResponseTimeCmnts"));

      //Check for existing INC Event ID. If present, we want the service to update the existing one.
      int existingIncEvent = GlobalData.getUlIdEvent(request);
      cint21si.setUlIdEvent(existingIncEvent);

    } 
    
    String disposition = ContextHelper.getStringSafe(request, DISPOSITION_SELECT_BOX);
    String screenOutReason = ContextHelper.getStringSafe(request,"selSzCdScreenOutReason");
    String cdNonIncReqType = cint99so.getSzCdNonRsdntReqType();
    
    if (mode == 'B' || mode == 'C') {
        cint21si.setSzCdIncomingDisposition(disposition);
        InStageRow.setSzTxtStageClosureCmnts(ContextHelper.getStringSafe(request, "txtaSzTxtStageClosureCmnts"));
        InStageRow.setSzCdStageScroutReason(screenOutReason);
    }
    // Set Stage Closed reason for certain non incident types
    if (mode == 'B' || mode == 'C') {
        if (CodesTables.CNIRTYPE_IC.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_NI.equals(cdNonIncReqType)
                        || CodesTables.CNIRTYPE_PA.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_PF.equals(cdNonIncReqType)) {
          InStageRow.setSzCdStageReasonClosed(cdNonIncReqType);
        }
        else {
          InStageRow.setSzCdStageReasonClosed(disposition);
        }
    }
    

    // SIR 18305 Start - Get the date last update out of state and set it in the
    // new field.
    Date tsIncmngDtlDateLastUpdate = (Date) state.getAttribute("tsIncmngDtlDateLastUpdate", request);

    InStageRow.setTsIncmgDtlLastUpdate(tsIncmngDtlDateLastUpdate);
    // SIR 18305 End

    cint21si.setArchInputStruct(input);
    cint21si.setROWCCMN01UIG00(EventStatus);
    cint21si.setStageRow(InStageRow);

    cint21si.setUlIdPerson(user.getUserID());
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cint21si;
  }

  private boolean hasSupervisorPrivileges(GrndsExchangeContext context) {
    boolean hasSuper = false;
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    if (user.hasRight(UserProfile.SEC_AUTH_TO_APPROVE) &&
        GlobalData.hasStageAccess(request)) {
      hasSuper = true;
    }
    return hasSuper;
  }
  
  /**
   * Determine what mode the page is in.  All cases will fall into one of these modes.
   * <p/>
   * MODE ONE:  Set A. View only
   * 
   * MODE TWO: Set B. Modify a Regular Intake
   * 
   * MODE THREE: Set C. Modify a Non-Incident Intake. Need to be supervisor or above to close anything other than I&R intake.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private void setMode(GrndsExchangeContext context, CINT99SO cint99so) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "setMode");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String pageMode = PageMode.getPageMode(request);

    Sets.setPageSet(Sets.A, request); //just view
    String intakeApprovalStatus = cint99so.getSzCdEventStatus();
    if (PageModeConstants.EDIT.equals(pageMode) && GlobalData.getSzCdStage(request).equals(STAGE_INT)
                    && (StringHelper.isValid(intakeApprovalStatus) && CodesTables.CEVTSTAT_APRV.equals(intakeApprovalStatus))) {
      String nonIncType = cint99so.getSzCdNonRsdntReqType();
      //UserProfile user = UserProfileHelper.getUserProfile(request);
      if (StringHelper.isValid(nonIncType)) {  // check if this is a non-Incident Intake
        if (CodesTables.CNIRTYPE_IR.equals(nonIncType)) {
          Sets.setPageSet(Sets.C, request);  //user who can edit can close an I&R Intake
        }
        else if (hasSupervisorPrivileges(context)) { 
          Sets.setPageSet(Sets.C, request); // Supervisor or above can close any non-incident intake
        }
      }
      else if (hasSupervisorPrivileges(context)) {
        Sets.setPageSet(Sets.B, request); // Modifying a regular Intake
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return;
  }

  // Reset the output structure from the display query
  private void resetCINT99SO(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".resetCINT99SO()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CINT99SO cint99so = (CINT99SO) state.getAttribute(CINT99SO_STRING, request);

    cint99so.getStageRow().setSzCdStageCurrPriority(ContextHelper.getStringSafe(request, "selSzCdStageCurrPriority"));
    cint99so.setDtSysDtGenericSysdate(ContextHelper.getCastorDateSafe(request, "txtDtSysDtGenericSysdate"));
    cint99so.getStageRow().setSzCdStageRsnPriorityChgd(ContextHelper.getStringSafe(request,
                                                                                   "selSzCdStageRsnPriorityChgd"));
    //STGAP00009014: Changed setSzTxtStagePriorityCmnts to setSzTxtStageResponseTimeCmnts
    //               This will save the Comments into new Column of Stage Table.                                                                            
    cint99so.getStageRow().setSzTxtStageResponseTimeCmnts(ContextHelper.getStringSafe(request,
                                                                                  "szTxtStageResponseTimeCmnts"));
    cint99so.getStageRow().setSzCdStageType(ContextHelper.getStringSafe(request, "dspSzCdStageType"));
    cint99so.setSzCdIncomingDisposition(ContextHelper.getStringSafe(request, "selSzCdDisp"));
    cint99so.getStageRow().setSzCdStageScroutReason(ContextHelper.getStringSafe(request, "selSzCdScreenOutReason"));
    cint99so.getStageRow().setSzTxtStageClosureCmnts(ContextHelper.getStringSafe(request,
                                                                                 "txtaSzTxtStageClosureCmnts"));

    state.setAttribute(CINT99SO_STRING, cint99so, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;

  }
  
  /**
   * User has pressed Approval Validation button.
   * Clear our the page sets
   * 
   * @param context
   *          GrndsExchangeContext
   */
  public void validateApprv_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateApprv_xa()");
    performanceTrace.enterScope();

    GrndsTrace.msg(TRACE_TAG, 7, "validateApprv_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    CSUB68SI csub68si = null;

    try {
        this.setPresentationBranch(BRANCH_APPROVAL_TO_DO, context);
        Sets.setPageSet(Sets.NONE, request); //clear out page sets
    }

    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INT_STAGE_NOT_FOUND);
          displayMessagePage(errorMessage, context);
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

}