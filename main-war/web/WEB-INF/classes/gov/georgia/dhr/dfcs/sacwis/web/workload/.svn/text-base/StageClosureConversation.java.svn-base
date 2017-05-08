package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB67SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV20SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV20SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to display, save, save and submit, and save and close the following stages: <p/>
 * APS Aging Out Child CPS SUBCARE CPS POST ADOPTION CPS ADOPTION CPS FAMILY REUNIFICATION CPS FAMILY SUBCARE
 * 
 * @author Paula Blaha, Jan. 30, 2003 <p/>
 * 
 * <pre>
 *                         Change History:
 *                          Date        User      Description
 *                          --------  ----------  ------------------------------------------------------
 *                          05/10/03  KRD         SIR 17233 - Code changes applied to support &quot;Approver
 *                                                Mode&quot; providing supervisors the ability to modify data
 *                                                without invalidating the pending approval.  Required
 *                                                changes to populateCSUB68SI_AUD() and
 *                                                copyOutToInROWCSUB68SIG00().
 *                          06/06/03  GRIMSHAN    SIR 16979 - Retrieve page mode from event search
 *                                                conversation if the page mode does not need to be
 *                                                changed, it will not be
 *                          06/27/03  Todd Reser  Changed rowfoo variables to correct object names.
 *                                                Removed old unused code. Updated Javadoc Comments.
 *                                                Uncommented commented out code that said uncomment
 *                                                after testing in the if statement before throwing
 *                                                MSG_CMN_INVLD_APRVL.
 *                          02/26/04  Todd Reser  Ran PMD, removed unused imports, fixed duplicate
 *                                                String Literals, created Helper funciton getTaskCode.
 *                          02/27/04  Todd Reser  Added javadoc for populateCSUB68SiForApprovalAutoSave
 *                          07/02/04  RIOSJA      SIR 16114 - If validation edits were returned, set an
 *                                                indicator into the request so that the JSP will not
 *                                                display any onload messages because the user has
 *                                                already received them before the save.
 *                          05/09/05  NALLAVS     SIR 23547 - Removed System.out.println statements.
 *                          06/04/05  NALLAVS     SIR 23602 - Resolved the Impact error page,occuring
 *                                                when the Stage Closure page is saved and then the Approval
 *                                                Status button is clicked to open the Approval Status
 *                                                page, by populating CSUB67S in saveStageClosure method.
 *                          6/17/05   gerryc      SIR 19659 - on validateApprv, if the only error message
 *                                                is 'Pending events must be approved before proceeding.'
 *                                                then ignore it - the only pending event is the conclusion event.
 *                          07/25/09 bgehlot    STGAP00014341: MR-51 Reopen Stage Changes
 *                        05/07/2010 arege      SMS#42496:Modified code to reflect changes made to StageClosureEditChecksImpl 
 * </pre>
 */
@SuppressWarnings("serial")
public class StageClosureConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "StageClosureConversation";

  public static final String EVENT_LIST_PAGE = "event";

  public static final String strCSUB67SO = "CSUB67SO";

  public static final String strCSUB68S = "CSUB68S";

  public static final String CLOSE_SUBCARE_STAGE = "3270"; // SUB

  public static final String CLOSE_POST_ADOPTION_STAGE = "9260"; // PAD

  public static final String CLOSE_ADOPTION_STAGE = "8770"; // ADO

  public static final String CLOSE_FAMILY_SUBCARE_STAGE = "4110"; // FSU

  public static final String CLOSE_POST_FOSTER_STAGE = "2070";// PFC

  public static final String PAD_SUB_ADO_FRE_FSU_PFC_EVENT_TYPE = CodesTables.CEVNTTYP_CCL;

  public static final String PAD_EVENT_DESC = "Post Adoption stage has been closed";

  public static final String FRE_EVENT_DESC = "CPS Fam. Reun. stage has been closed";

  public static final String FSU_EVENT_DESC = "Foster Care Family stage has been closed";

  public static final String SUB_EVENT_DESC = "Foster Care Child stage has been closed";

  public static final String ADO_EVENT_DESC = "Adoption stage has been closed";

  public static final String PFC_EVENT_DESC = "Post Foster Care stage has been closed";

  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String CASE_TODO_PAGE = "caseToDo";

  public static final String STAFF_TODO_PAGE = "staffToDo";

  public static final String WINDOW_MODE_NEW_APPRV = "X";

  public static final String WINDOW_MODE_INQUIRE = "3";

  public static final String STAGE_PAD = CodesTables.CSTAGES_PAD;

  public static final String STAGE_FPR = CodesTables.CSTAGES_FPR;

  public static final String STAGE_FSU = CodesTables.CSTAGES_FSU;

  public static final String STAGE_SUB = CodesTables.CSTAGES_SUB;

  public static final String STAGE_ADO = CodesTables.CSTAGES_ADO;

  public static final String STAGE_PFC = CodesTables.CSTAGES_PFC;

  public static final String APPROVE_SUB_TASK = "3420";

  public static final String APPROVE_FSU_TASK = "4300";

  public static final String APPROVE_ADO_TASK = "8910";

  public static final String APPROVE_FPR_TASK = "7160";

  public static final String APPROVE_PFC_TASK = "2080";

  public static final String APPROVE_PAD_TASK = "9400";

  public static final String BRANCH_APPROVAL_TO_DO = "ApprovalToDo";

  public static final String BRANCH_CASE_SUMMARY = "CaseSummary";

  public static final String BRANCH_DISPLAY_STAGE_CLOSURE = "DisplayStageClosure";

  public static final String SVC_CD_EVENT_TYPE_CLOSE = CodesTables.CEVNTTYP_STG;

  public static final String SVC_CD_STAGE_CPS_SVC = CodesTables.CSTAGES_FPR;

  public static final String SVC_CD_TASK_CLOSURE_CPS = "7010";

  public static final String CLOSE_ONG_STAGE = "CPS Ongoing stage has been Closed";

  public static final String ACTION_CODE_CLOSE = "C";

  public static final String ACTION_CODE_SUBMIT = "S";

  public static final String SVC_CTB_CLOSURE_EDITS = CodesTables.CACLOSED;

  public static final String EVENT_ARRAY = "eventArray";

  public static final String SVC_CD_TASK_APPV_CLOSURE_CPS = "7160";

  public static final String DISPLAY_PAGE_FPR = "/workload/StageClosure/displaySrvcDlvryClsr";

  public static final String CSVC15SO_STRING = "CSVC15SO";

  public static final String SERVICE_FAILURE = "Service Failure:";

  public static final String VALIDATE_FAILURE = "Validaton Failure:";

  public static final String MARSHAL_FAILURE = "Marshalling Failure:";

  public static final String POPULATE_FAILURE = "Population Failute:";

  public static final String SELSZCDSTAGEREASONCLOSED = "selSzCdStageReasonClosed";

  public static final String SAVE_SUBMIT_BUTTON = "btnSaveAndSubmit";// SIR 23664

  public static final String SAVE_BUTTON = "btnSave";// SIR 23664

  public static final String REASON_ADOPTION_FINALIZED = CodesTables.CCLOSADO_ADF;
  
  public static final String IND_ADOPTION_FINALIZED = "indAdoptionFinalized";

  private Admin admin;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  private CaseMgmt casemgmt = null;

  public void setCaseMgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }

  public void displayStageClosure_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStageClosure_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(request);

    String taskCode = getTaskCode(GlobalData.getSzCdStage(request));
    CaseUtility.Event testEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request), taskCode);
    int testEventId = testEvent.getIdEvent();
    GlobalData.setUlIdEvent(testEventId, request);

    if (testEventId == 0) {
      PageMode.setPageMode(PageModeConstants.NEW, request);
    } else {
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }

    // initialize the local page mode to the AppMode
    String appMode = GlobalData.getAppMode(request);
    if (appMode.equals(PageModeConstants.VIEW)) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    }

    // SIR 16979 get the page mode from event search conversation if the page mode
    // does not need to be changed, it will not be
    String pageMode = EventSearchConversation.getEventDetailPageMode(request);
    PageMode.setPageMode(pageMode, request);

    try {
      String parentPage = ContextHelper.getStringSafe(request, "parentPage");
      request.setAttribute(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL, parentPage);
      // populate the input object

      // Retrieve Closure Event
      CSUB67SO csub67so = retrieveClosureEvent(context);

      ROWCSUB67SOG00 row67 = new ROWCSUB67SOG00();
      if (csub67so.getROWCSUB67SOG00() != null) {
        row67 = csub67so.getROWCSUB67SOG00();
      } else {
        row67 = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00();
      }

      String eventStatus = row67.getSzCdEventStatus();

      // If the event status is pending, the page mode is edit, and we are not in
      // approval mode, display messages warning the user that saving will invalidate
      // the pending approval
      if (EVENT_STATUS_PENDING.equals(eventStatus) && PageMode.getPageMode(request).equals(PageModeConstants.EDIT)
          && !GlobalData.isApprovalMode(request)) {

        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Display service failed! General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  public void displaySrvcDlvryClsr_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySrvcDlvryClsr_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    // we have to do this to get the most recent ulIdEvent.
    CaseUtility.Event event = CaseUtility.getEvent(GlobalData.getUlIdStage(request), GlobalData.getSzCdTask(request));
    GlobalData.setUlIdEvent(event.getIdEvent(), request);

    try {
      // instantiate input object and populate with data submitted from the calling page
      CSVC15SI csvc15si = populateCSVC15SI_Retrieve(context);
      CSVC15SO csvc15so = casemgmt.retrieveServDelivery(csvc15si);
      String pageMode = GlobalData.getAppMode(request);
      PageMode.setPageMode(pageMode, request);

      // SIR 18989 GRIMSHAN, if the ulidevent is 0, and the
      // pagemode is modify, switch page mode to new
      if (GlobalData.getUlIdEvent(request) == 0 && PageMode.getPageMode(request).equals(PageModeConstants.MODIFY)) {
        pageMode = PageModeConstants.NEW;
      }

      // SIR 16979 get the page mode from event search conversation if the page mode
      // does not need to be changed, it will not be
      pageMode = EventSearchConversation.getEventDetailPageMode(request);

      /*
       * If the Date Stage Closed is populated, then the Stage has been closed and the fields should be protected and
       * buttons disabled. Set the page mode to INQUIRE if the Closure date exists.
       */

      BaseSessionStateManager state = getSessionStateManager(context);
      state.removeAllAttributes(request);

      // setting csvc15so object into state so it will be available to the save
      // methods and the jsp
      state.setAttribute(CSVC15SO_STRING, csvc15so, request);

      /* If event status is pending and window mode is modify, display message MSG_CMN_INVLD_APRVL */
      if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))
          && PageModeConstants.EDIT.equals(pageMode) && !GlobalData.isApprovalMode(request)
          && EVENT_STATUS_PENDING.equals(csvc15so.getROWCCMN01UIG00().getSzCdEventStatus())) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL), DISPLAY_PAGE_FPR,
                                request);
        setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL_POPUP), DISPLAY_PAGE_FPR, request);
      }
      /* SIR 23726 - Display info message if case is checked out to MPS */
      else {
        if (CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request))
            && !PageModeConstants.VIEW.equals(pageMode) && !GlobalData.isApprovalMode(request)) {
          setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, DISPLAY_PAGE_FPR, request);
        }
      }

      // set relevant global data
      if (csvc15so.getROWCINV19SOG02() != null) {
        GlobalData.setSzCdStage(csvc15so.getROWCINV19SOG02().getSzCdStage(), request);
        GlobalData.setSzNmStage(csvc15so.getROWCINV19SOG02().getSzNmStage(), request);
        GlobalData.setUlIdStage(csvc15so.getROWCINV19SOG02().getUlIdStage(), request);
      }

      if (csvc15so.getROWCCMN01UIG00() != null) {
        GlobalData.setUlIdEvent(csvc15so.getROWCCMN01UIG00().getUlIdEvent(), request);
      }

      PageMode.setPageMode(pageMode, request);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_NO_ROWS_RETURNED:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SVC_NO_CLOSURE_DATA);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE + we.getMessage());
        processSevereException(context, we);
        break;
      }

    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method takes in the Stage code to determines the Task Code and returns it. Called by
   * displayStageClosure_xa.
   * 
   * @param testCdStage
   *          String
   * @return taskCode
   */
  private String getTaskCode(String testCdStage) {
    String taskCode = StringHelper.EMPTY_STRING;
    if (testCdStage.equals(STAGE_SUB)) {
      taskCode = CLOSE_SUBCARE_STAGE;
    } else if (testCdStage.equals(STAGE_PAD)) {
      taskCode = CLOSE_POST_ADOPTION_STAGE;
    } else if (testCdStage.equals(STAGE_FSU)) {
      taskCode = CLOSE_FAMILY_SUBCARE_STAGE;
    } else if (testCdStage.equals(STAGE_ADO)) {
      taskCode = CLOSE_ADOPTION_STAGE;
    } else if (testCdStage.equals(STAGE_PFC)) {
      taskCode = CLOSE_POST_FOSTER_STAGE;
    }
    return taskCode;
  }

  /**
   * This helper method populates the csub67si object and returns it. Called by displayStageClosure_xa.
   * 
   * @param context
   *          GrndsExchangeContext
   * @return csub67si
   */
  private CSUB67SI populateCSUB67SI_Retrieve(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    CSUB67SI csub67si = new CSUB67SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(getUserLogonID(request));
    csub67si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub67si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    return csub67si;
  }

  /**
   * This method is the main call for Saving.
   * 
   * @param context
   *          GrndsExchangeContext
   */
  public void saveStageClosure_xa(GrndsExchangeContext context) {
    GrndsTrace.msg(TRACE_TAG, 7, "saveStageClosure_xa");
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveStageClosure_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      CSUB68SI csub68si = populateCSUB68SI_AUD(context);
      CSUB68SO csub68so = admin.performEditChecks(csub68si);
      
      //-- at least update dtLastUpdate value for Stage record
      retrieveClosureEvent(context);

      // Populate the error list and set the error branch if error messages returned
      SzCdUerrorMsgNbr1_ARRAY errorArray = csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr1_ARRAY();
      
      // STGAP00004018 now errors can handle values added to error
      if (errorArray != null && errorArray.getROW_ERROR_MAPPINGCount() > 0) {
        setErrorList(errorArray, request);
      }
      // else if no errors were returned for the error list, populate the input object for the Approval To Do
      else if (!GlobalData.isApprovalMode(request)) {
        this.setPresentationBranch(BRANCH_DISPLAY_STAGE_CLOSURE, context);
      }
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, " save failed! ServiceException" + we.getMessage());
      if (we.getErrorCode() == Messages.MSG_SUB_CLOSE_CASE) {
        request.setAttribute("confirmed", "ask");
      } else {
        handleError(we, context);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This helper method populates the csub68si object and returns it. Called by saveStageClosure_xa.
   * 
   * @param context
   *          GrndsExchangeContext
   * @return csub68si
   */
  private CSUB68SI populateCSUB68SI_AUD(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "##13 .populateCsub68SI_AUD()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI csub68si = new CSUB68SI();

    // populate the rows
    ROWCSUB68SIG00 rowcsub68sig00 = copyOutToInROWCSUB68SIG00(request);
    ROWCSUB68SIG01 rowcsub68sig01 = copyOutToInROWCSUB68SIG01(request);

    ArchInputStruct input = new ArchInputStruct();

    // add if new mode, update if modify mode
    // but the service (csub68s) does this by checking this: if the event id is 0 , it's a new event, so
    // it should be "add". If it isn't 0, it should be update. So if it is being set inside the
    // service, how come the input to the service for CAPS shows a value of "A"?
    if (PageMode.getPageMode(request).equals(PageModeConstants.EDIT)) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }

    input.setSzUserId(getUserLogonID(request));

    // set the flag indicating approver mode
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    // bIndStageClose is set inside the service
    csub68si.setBIndStageClose(ArchitectureConstants.N);
    //STGAP00014341: Date is saved
    rowcsub68sig01.setDtDtStageClose(ContextHelper.getCastorDateSafe(request, "txtDtDtStageClose"));
    rowcsub68sig01.setSzTxtStageClosureCmnts(ContextHelper.getStringSafe(request, "selSzTxtStageClosureCmnts"));
    rowcsub68sig01.setSzCdStageReasonClosed(ContextHelper.getStringSafe(request, "selSzCdStageReasonClosed"));
   //STGAP00010749: If the Satge being closed is Adoption and the reason is Adoption finalized then
   //set the name parameters into the object to insert a row in ADO New Name table.
   if(ContextHelper.isParameterPresent(request, "txtNmFirst")){
     csub68si.setTxtNmFirst(ContextHelper.getStringSafe(request, "txtNmFirst"));
   }
   if(ContextHelper.isParameterPresent(request, "txtNmMiddle")){
     csub68si.setTxtNmMiddle(ContextHelper.getStringSafe(request, "txtNmMiddle"));
   }
   if(ContextHelper.isParameterPresent(request, "txtNmLast")){
     csub68si.setTxtNmLast(ContextHelper.getStringSafe(request, "txtNmLast"));
   }
    rowcsub68sig00.setUlIdPerson(getUserID(request));

    csub68si.setArchInputStruct(input);
    csub68si.setROWCSUB68SIG00(rowcsub68sig00);
    csub68si.setROWCSUB68SIG01(rowcsub68sig01);

    // set BSysIndCase = 0 first time, 1 second time into the save service
    String closeStage = ContextHelper.getStringSafe(request, "closeStage");
    if (closeStage.equals(ArchitectureConstants.TRUE)) {
      csub68si.setBSysIndCase("1");
    } else {
      csub68si.setBSysIndCase("0");
    }
    return csub68si;
  }

  /**
   * This helper method creates, populates and returns a new ROWCSUB68SIG00 object. Called by populateCSUB68SI_AUD.
   * 
   * @param request
   *          HttpServletRequest
   * @return rowcsub68sig00
   */
  private ROWCSUB68SIG00 copyOutToInROWCSUB68SIG00(HttpServletRequest request) {
    ROWCSUB68SIG00 rowcsub68sig00 = new ROWCSUB68SIG00();
    // Set the task code, event type and event description based on the stage
    // Each stage has its own task code and event description
    String stage = GlobalData.getSzCdStage(request);
    if (stage.equals(STAGE_SUB)) {
      rowcsub68sig00.setSzTxtEventDescr(SUB_EVENT_DESC);
      rowcsub68sig00.setSzCdTask(CLOSE_SUBCARE_STAGE);
    } else if (stage.equals(STAGE_PAD)) {
      rowcsub68sig00.setSzTxtEventDescr(PAD_EVENT_DESC);
      rowcsub68sig00.setSzCdTask(CLOSE_POST_ADOPTION_STAGE);
    } else if (stage.equals(STAGE_FSU)) {
      rowcsub68sig00.setSzTxtEventDescr(FSU_EVENT_DESC);
      rowcsub68sig00.setSzCdTask(CLOSE_FAMILY_SUBCARE_STAGE);
    } else if (stage.equals(STAGE_ADO)) {
      rowcsub68sig00.setSzTxtEventDescr(ADO_EVENT_DESC);
      rowcsub68sig00.setSzCdTask(CLOSE_ADOPTION_STAGE);
    } else if (stage.equals(STAGE_PFC)) {
      rowcsub68sig00.setSzTxtEventDescr(PFC_EVENT_DESC);
      rowcsub68sig00.setSzCdTask(CLOSE_POST_FOSTER_STAGE);
    }

    rowcsub68sig00.setSzCdEventType(PAD_SUB_ADO_FRE_FSU_PFC_EVENT_TYPE);

    int idEvent = ContextHelper.getIntSafe(request, "txtUlIdEvent");

    rowcsub68sig00.setUlIdEvent(idEvent);
    rowcsub68sig00.setUlIdStage(ContextHelper.getIntSafe(request, "txtUlIdStage"));

    // Event Status is an array: current status and next status
    // After you set the elements into the array, you still have to set the array into the row
    SzCdEventStatus_ARRAY rowArray = new SzCdEventStatus_ARRAY();

    // if the event is pending, a save in approval mode should not invalidate
    // the approval.
    String eventStatus = ContextHelper.getStringSafe(request, "txtSzCdEventStatus");
    rowArray.addSzCdEventStatus(0, eventStatus);

    // event status should remain PEND, if we're in Approver Mode
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      rowArray.addSzCdEventStatus(1, EVENT_STATUS_PENDING);
    } else {
      rowArray.addSzCdEventStatus(1, EVENT_STATUS_COMP);
    }

    rowcsub68sig00.setSzCdEventStatus_ARRAY(rowArray);
    rowcsub68sig00.setUlIdPerson(ContextHelper.getIntSafe(request, "txtUlIdPerson"));

    if (idEvent > 0) {
      rowcsub68sig00.setDtDtEventOccurred(ContextHelper.getCastorDateSafe(request, "txtDtDtEventOccurred"));
      rowcsub68sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtTsLastUpdate1")));
    } else {
      rowcsub68sig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    }
    return rowcsub68sig00;
  }

  /**
   * This helper method creates, populates and returns a new ROWCSUB68SIG01 object. Called by populateCSUB68SI_AUD.
   * 
   * @param request
   *          HttpServletRequest
   * @return rowcsub68sig01
   */
  private ROWCSUB68SIG01 copyOutToInROWCSUB68SIG01(HttpServletRequest request) {
    ROWCSUB68SIG01 rowcsub68sig01 = new ROWCSUB68SIG01();
    rowcsub68sig01.setUlIdStage(ContextHelper.getIntSafe(request, "txtUlIdStage"));
    rowcsub68sig01.setUlIdCase(ContextHelper.getIntSafe(request, "txtUlIdCase"));
    rowcsub68sig01.setSzCdStageType(ContextHelper.getStringSafe(request, "txtSzCdStageType"));
    rowcsub68sig01.setSzCdStage(ContextHelper.getStringSafe(request, "txtSzCdStage"));
    rowcsub68sig01.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtTsLastUpdate2")));
    rowcsub68sig01.setSzCdStageProgram(ContextHelper.getStringSafe(request, "txtSzCdStageProgram"));
    rowcsub68sig01.setSzCdStageReasonClosed(ContextHelper.getStringSafe(request, "selSzCdStageReasonClosed"));
    rowcsub68sig01.setDtDtStageClose(DateHelper.toCastorDate(new Date()));
    return rowcsub68sig01;
  }

  /**
   * This helper method creates, populates and returns a new CSUB68SI object. Called by validateApprv_xa.
   * 
   * @param request
   *          HttpServletRequest
   * @param state
   *          BaseSessionStateManager
   * @return csub68si
   */
  private CSUB68SI populateCSUB68SiForApprovalAutoSave(HttpServletRequest request, BaseSessionStateManager state) {
    CSUB68SI csub68si = new CSUB68SI();
    ROWCSUB68SIG00 rowcsub68sig00 = new ROWCSUB68SIG00();
    ROWCSUB68SIG01 rowcsub68sig01 = new ROWCSUB68SIG01();
    SzCdEventStatus_ARRAY rowArray = new SzCdEventStatus_ARRAY();
    ArchInputStruct input = new ArchInputStruct();

    CSUB67SO csub67so = (CSUB67SO) state.getAttribute(strCSUB67SO, request);
    ROWCSUB67SOG00 rowcsub67sog00 = csub67so.getROWCSUB67SOG00();
    ROWCSUB67SOG01 rowcsub67sog01 = csub67so.getROWCSUB67SOG01();

    // Copy existing row information on SIG00
    rowcsub68sig00.setSzTxtEventDescr(rowcsub67sog00.getSzTxtEventDescr());
    rowcsub68sig00.setSzCdTask(rowcsub67sog00.getSzCdTask());
    rowcsub68sig00.setSzCdEventType(rowcsub67sog00.getSzCdEventType());
    rowcsub68sig00.setUlIdEvent(rowcsub67sog00.getUlIdEvent());
    rowcsub68sig00.setUlIdStage(rowcsub67sog00.getUlIdStage());
    rowArray.addSzCdEventStatus(0, rowcsub67sog00.getSzCdEventStatus());
    // Keep status the same on save:
    rowArray.addSzCdEventStatus(1, rowcsub67sog00.getSzCdEventStatus());
    rowcsub68sig00.setSzCdEventStatus_ARRAY(rowArray);
    rowcsub68sig00.setUlIdPerson(rowcsub67sog00.getUlIdPerson());
    rowcsub68sig00.setDtDtEventOccurred(rowcsub67sog00.getDtDtEventOccurred());
    rowcsub68sig00.setTsLastUpdate(rowcsub67sog00.getTsLastUpdate());

    // Copy existing row information on SIG01
    rowcsub68sig01.setUlIdStage(rowcsub67sog01.getUlIdStage());
    rowcsub68sig01.setUlIdCase(rowcsub67sog01.getUlIdCase());
    rowcsub68sig01.setSzCdStageType(rowcsub67sog01.getSzCdStageType());
    rowcsub68sig01.setSzCdStage(rowcsub67sog01.getSzCdStage());
    rowcsub68sig01.setTsLastUpdate(rowcsub67sog01.getTsLastUpdate());
    rowcsub68sig01.setSzCdStageProgram(rowcsub67sog01.getSzCdStageProgram());
    rowcsub68sig01.setSzCdStageReasonClosed(rowcsub67sog01.getSzCdStageReasonClosed());
    rowcsub68sig01.setDtDtStageClose(rowcsub67sog01.getDtDtStageClose());
    rowcsub68sig01.setSzTxtStageClosureCmnts(rowcsub67sog01.getSzTxtStageClosureCmnts());
    //STGAP00010749: If the Satge being closed is Adoption and the reason is Adoption finalized then
   //set the name parameters into the object to insert a row in ADO New Name table.
    if(!"".equals(FormattingHelper.formatString(csub67so.getTxtNmFirst()))){
      csub68si.setTxtNmFirst(csub67so.getTxtNmFirst());
    }
    if(!"".equals(FormattingHelper.formatString(csub67so.getTxtNmLast()))){
      csub68si.setTxtNmLast(csub67so.getTxtNmLast());
    }
    if(!"".equals(FormattingHelper.formatString(csub67so.getTxtNmMiddle()))){
      csub68si.setTxtNmMiddle(csub67so.getTxtNmMiddle());
    }
    
    // Set up Arch Input Struct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setSzUserId(getUserLogonID(request));
    input.setUlSysNbrReserved1(ArchitectureConstants.Y);

    // SysIndCase must be 0 to run validation. Case Closure message handled elsewhere.
    csub68si.setBSysIndCase("0");
    csub68si.setBIndStageClose(ArchitectureConstants.N);
    csub68si.setArchInputStruct(input);
    csub68si.setROWCSUB68SIG00(rowcsub68sig00);
    csub68si.setROWCSUB68SIG01(rowcsub68sig01);

    return csub68si;
  }

  /**
   * This method is the main call for Save & Submitting.
   * 
   * @param context
   *          GrndsExchangeContext
   */
  public void saveSubmitStageClosure_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".SaveSubmitStageClosure_xa()");
    performanceTrace.enterScope();

    GrndsTrace.msg(TRACE_TAG, 7, "SaveSubmitStageClosure_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CSUB68SI csub68si = populateCSUB68SI_AUD(context);
      CSUB68SO csub68so = admin.performEditChecks(csub68si);

      String stage = GlobalData.getSzCdStage(request);
      int idEvent = csub68so.getUlIdEvent();
      GlobalData.setUlIdEvent(idEvent, request);
      
      retrieveClosureEvent(context);

      // Populate the error list and set the error branch if error messages returned
      SzCdUerrorMsgNbr1_ARRAY errorArray = csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr1_ARRAY();
      // // RIOSJA, SIR 16114 - If validation edits were returned, set an indicator
      // // into the request so that the JSP will not display any onload messages
      // // because the user has already received them before the save.
      // STGAP00004018 now errors can handle values added to error
      if (errorArray != null && errorArray.getROW_ERROR_MAPPINGCount() > 0) {
        setErrorList(errorArray, request);
      }
      // else if no errors were returned for the error list, populate the input object for the Approval To Do
      else {
        CSUB67SO csub67so = (CSUB67SO) state.getAttribute(strCSUB67SO, request);
        
        GlobalData.setUlIdCase(csub67so.getROWCSUB67SOG01().getUlIdCase(), request);
        GlobalData.setUlIdStage(csub67so.getROWCSUB67SOG01().getUlIdStage(), request);
        PageMode.setPageMode(WINDOW_MODE_NEW_APPRV, request);
        String approvalTaskCode = StringHelper.EMPTY_STRING;

        if (STAGE_FPR.equals(stage)) {
          approvalTaskCode = APPROVE_FPR_TASK;
        } else if (STAGE_FSU.equals(stage)) {
          approvalTaskCode = APPROVE_FSU_TASK;
        } else if (STAGE_ADO.equals(stage)) {
          approvalTaskCode = APPROVE_ADO_TASK;
        } else if (STAGE_SUB.equals(stage)) {
          approvalTaskCode = APPROVE_SUB_TASK;
        } else if (STAGE_PAD.equals(stage)) {
          approvalTaskCode = APPROVE_PAD_TASK;
        } else if (STAGE_PFC.equals(stage)) {
          approvalTaskCode = APPROVE_PFC_TASK;
        }

        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(csub68so.getUlIdEvent(), csub67so.getROWCSUB67SOG01()
                                                                                      .getUlIdCase(),
                                                     csub67so.getROWCSUB67SOG01().getUlIdStage(), approvalTaskCode);

        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
        this.setPresentationBranch(BRANCH_APPROVAL_TO_DO, context);
      }
    }

    catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, " save failed! WTC exception" + we.getMessage());
      if (we.getErrorCode() == Messages.MSG_SUB_CLOSE_CASE) {
        request.setAttribute("confirmed", "ask");
      } else {
        handleError(we, context);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called to autosave and validate on Approval Status navigation
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
      CSUB67SO csub67so = (CSUB67SO) state.getAttribute(strCSUB67SO, request);
      // Only auto-save and validate if status is pending
      if (CodesTables.CEVTSTAT_PEND.equals(csub67so.getROWCSUB67SOG00().getSzCdEventStatus())
          && GlobalData.isStageClosureBeingApproved(request)) {
        csub68si = populateCSUB68SiForApprovalAutoSave(request, state);
        CSUB68SO csub68so = admin.performEditChecks(csub68si);

        // Populate the error list and remain here if errors exist
        SzCdUerrorMsgNbr1_ARRAY errorArray = csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr1_ARRAY();
        
        if (errorArray.getROW_ERROR_MAPPINGCount() > 0) {
          String stage = GlobalData.getSzCdStage(request);
          //Modified the if condition because the the errorArray will not contain the Pending ADO stage closure event error 
          //as the code was changed in Stage ClosureEditChecks
          //SMS#42496: Do not go to approval to do if  the error count is 1 as the new code excludes the CCL event (refer stageclosureeditchecks file)
          // as we need to take into account if any other event was submitted after submitting the stage closure event if yes the 
          // user should not be able to apporve stage closure
          if (errorArray.getROW_ERROR_MAPPINGCount() == 1 && !(STAGE_ADO.equals(stage) || STAGE_SUB.equals(stage) || STAGE_FSU.equals(stage) 
                                                                   || STAGE_PAD.equals(stage) || STAGE_PFC.equals(stage)) ) {
            // SIR 19659 -- don't display error list if the only message is the 'pend'
            // message, and approval flag is Yes.
            this.setPresentationBranch(BRANCH_APPROVAL_TO_DO, context);
          } else {
            // RIOSJA, SIR 16114 - If validation edits were returned, set an indicator
            // into the request so that the JSP will not display any onload messages
            // because the user has already received them before the save.
            // STGAP00004018 now errors can handle values added to error
            setErrorList(errorArray, request);
          }
        }
        // else if no errors were returned for the error list, send the page to
        // Approval Status
        else {
          //STGAP00010749: set the adoption finalized indicator
          if(CodesTables.CCLOSADO_ADF.equals(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed())){
            state.setAttribute(IND_ADOPTION_FINALIZED, ArchitectureConstants.Y,request);
          }
          this.setPresentationBranch(BRANCH_APPROVAL_TO_DO, context);
        }
      } else {
        this.setPresentationBranch(BRANCH_APPROVAL_TO_DO, context);
      }

    }

    catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, " save failed! WTC exception" + we.getMessage());
      if (we.getErrorCode() == Messages.MSG_SUB_CLOSE_CASE) {
        // If this error code is returned, just re-call the save service with
        // IndCase = "1" instead of "0". No need to confirm.
        csub68si.setBSysIndCase("1");
        try {
          admin.performEditChecks(csub68si);
          // If save works the second time, go to the approval page.
          this.setPresentationBranch(BRANCH_APPROVAL_TO_DO, context);
        } catch (ServiceException we2) {
          handleError(we2, context);
        } catch (Exception e) {
          processSevereException(context, e);
        }
      } else {
        handleError(we, context);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method populates the service input object for displaying the Service Delivery Closure page. It instantiates
   * the input object, gets values out of the context, and then returns the SI object.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   * @return csvc15si
   */
  private CSVC15SI populateCSVC15SI_Retrieve(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSVC15SI_Retrieve()");
    performanceTrace.enterScope();

    // get the state and request objects
    HttpServletRequest request = context.getRequest();

    // create a new input object
    // Allocate the structures
    CSVC15SI csvc15si = new CSVC15SI();
    ArchInputStruct input = new ArchInputStruct();

    // populate the input object sub-structures from the request,
    // then populate the input object from the request

    // Set the values for the ArchInputStruct
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());
    if (PageModeConstants.EDIT.equals(PageMode.getPageMode(request))) { // edit mode
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else { // add mode
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }

    csvc15si.setArchInputStruct(input);
    csvc15si.setUlIdStage(GlobalData.getUlIdStage(request));
    csvc15si.setSzCdStage(GlobalData.getSzCdStage(request));
    csvc15si.setUlIdEvent(GlobalData.getUlIdEvent(request));

    if (csvc15si.getUlIdEvent() == 0) {
      csvc15si.setUlIdEvent(ContextHelper.getIntSafe(request, "hdnUlIdEvent"));
    }

    if (csvc15si.getSzCdStage() == null || "".equals(csvc15si.getSzCdStage())) {
      csvc15si.setSzCdStage(ContextHelper.getStringSafe(request, "hdnSzCdStage"));
    }
    if (csvc15si.getUlIdStage() == 0) {
      csvc15si.setUlIdStage(ContextHelper.getIntSafe(request, "hdnUlIdStage"));
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the input object to the calling service
    return csvc15si;
  }

  /**
   * This helper method handles all the WTC Exceptions thrown by the Save service. Called by saveSubmitStageClosure_xa
   * and saveStageClosure_xa.
   * 
   * @param we
   *          WtcException
   * @param context
   *          GrndsExchangeContext
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
    case Messages.MSG_CCL_PC_REQUIRED:
    case Messages.MSG_DATABASE_SAVE_FAIL:
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_MULT_INST:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_STG_CLOS_SUB_B:
    case Messages.MSG_STG_CLOS_SUB_C:
    case Messages.MSG_STG_CLOS_SUB_090:
    case Messages.MSG_STG_CLOS_ADO_040:
    case Messages.SQL_NOT_FOUND:
      setErrorMessage(errorCode, request);
      break;

    default:
      processSevereException(context, we);
      break;
    }
  }

  /**
   * This method is called by the GRNDS controller when the user attempts to save a Service Delivery Closure
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void updateSrvcDlvryClsr_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".updateSrvcDlvryClsr_xa()");
    performanceTrace.enterScope();

    try {
      updateSrvcDlvryClsr(context);
    }

    // handle exceptions
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      String errorMessage;
      switch (we.getErrorCode()) {
      case Messages.MSG_SYS_STAGE_CLOSED:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      case Messages.MSG_SYS_MULT_INST:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE + we.getMessage());
        processSevereException(context, we);
        break;
      }

    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This private method is called by the Save, Save and Submit methods to save the closure before validating.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * 
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   */
  private void updateSrvcDlvryClsr(GrndsExchangeContext context) throws ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".updateSrvcDlvryClsr()");
    performanceTrace.enterScope();

    //HttpServletRequest request = context.getRequest();
    CSVC14SI csvc14si = populateCSVC14SI_Update(context);
    CSVC14SO csvc14so = casemgmt.saveSvcDeliveryClosure(csvc14si);
    GlobalData.setUlIdEvent(csvc14so.getUlIdEvent(), context.getRequest());
    //request.setAttribute("CSVC14SO", csvc14so);

    performanceTrace.exitScope();
  }

  /**
   * This method populates the service input object for saving the Service Delivery Closure page. It instantiates the
   * input object, gets values out of the context, and then returns the SI object.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   * @return csvc14si
   */
  private CSVC14SI populateCSVC14SI_Update(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSVC14SI_Update()");
    performanceTrace.enterScope();

    // get the state and request objects
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    // create a new input object and its structures
    CSVC14SI csvc14si = new CSVC14SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCINV21SIG02 rowcinv21sig02 = new ROWCINV21SIG02();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();

    // populate the input object and its structures from the request
    CSVC15SO csvc15so = (CSVC15SO) state.getAttribute(CSVC15SO_STRING, request);
    if(csvc15so == null) {
      csvc15so = new CSVC15SO(); //-- should never happen
    }

    if (csvc15so.getROWCCMN01UIG00() != null) {
      csvc14si.setUlIdEvent(csvc15so.getROWCCMN01UIG00().getUlIdEvent());
    }

    csvc14si.setTsLastUpdate(csvc15so.getTsLastUpdate());
    csvc14si.setSzCdStage(GlobalData.getSzCdStage(request));

    /* populate user-input data */
    //csvc14si.setDtDtSvcDelvDecision(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context,
    //                                                                                        "txtDtDtSvcDelvDecision")));

    // SIR 23664 set the value of strAlternate if ckAlternateResourcesExplored is not checked and set
    // the value of SzCdClientAdvised
    //rowcinv21sig02.setSzCdClientAdvised(ContextHelper.getStringSafe(context, "rbClientAdvised"));
    //rowcinv21sig02.setBIndEcs(CheckboxHelper.getCheckboxValue(request, "cbxBIndEcs"));
    // End SIR 23664

    // SIR 23771 set the value of strEcs_Ver if cbxbIndEcsVer is not checked
    //rowcinv21sig02.setBIndEcsVer(CheckboxHelper.getCheckboxValue(request, "cbxbIndEcsVer"));
    // END SIR 23771
    int idStage = GlobalData.getUlIdStage(request);
    rowcinv21sig02.setUlIdStage(idStage);
    //STGAP00014341: Date is saved
    rowcinv21sig02.setDtDtStageClose(ContextHelper.getCastorDateSafe(request, "txtDtDtStageClose"));
    rowcinv21sig02.setSzTxtStageClosureCmnts(ContextHelper.getStringSafe(context, "selSzTxtStageClosureCmnts"));
    rowcinv21sig02.setSzCdStageReasonClosed(ContextHelper.getStringSafe(context, SELSZCDSTAGEREASONCLOSED));
    // Set the values for the ArchInputStruct
    
    String pageMode = PageMode.getPageMode(request);
    if (PageModeConstants.EDIT.equals(pageMode)) { // edit mode
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowccmn01uig00.setSzCdTask(csvc15so.getROWCCMN01UIG00().getSzCdTask());
      rowccmn01uig00.setSzCdEventStatus(csvc15so.getROWCCMN01UIG00().getSzCdEventStatus());
      rowccmn01uig00.setSzCdEventType(csvc15so.getROWCCMN01UIG00().getSzCdEventType());
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtDtEventOccurred")));
      rowccmn01uig00.setUlIdStage(idStage);
      rowccmn01uig00.setUlIdPerson(csvc15so.getROWCCMN01UIG00().getUlIdPerson());
      rowccmn01uig00.setUlIdEvent(csvc15so.getROWCCMN01UIG00().getUlIdEvent());
      rowccmn01uig00.setTsLastUpdate(csvc15so.getROWCCMN01UIG00().getTsLastUpdate());
    } else if (PageModeConstants.NEW.equals(pageMode)) { // add mode
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_COMP);
      rowccmn01uig00.setSzCdEventType(PAD_SUB_ADO_FRE_FSU_PFC_EVENT_TYPE);
      //rowccmn01uig00.setUlIdStage(csvc15so.getROWCINV19SOG02().getUlIdStage());
      rowccmn01uig00.setUlIdStage(idStage);
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      rowccmn01uig00.setUlIdPerson(user.getUserID());
      rowccmn01uig00.setSzCdTask(SVC_CD_TASK_CLOSURE_CPS);

      input.setSzUserId(user.getUserLogonID());
    }

    // set event description based on program
    // if (SVC_CD_STAGE_APS_SVC.equals(csvc14si.getSzCdStage())) {
    // rowccmn01uig00.setSzTxtEventDescr(CLOSE_CASE_APS);
    // } else
    //if (STAGE_FPR.equals(csvc14si.getSzCdStage())) {
      rowccmn01uig00.setSzTxtEventDescr(CLOSE_ONG_STAGE);
    //}

    // if status is Pending, demote it to Complete
    if (csvc15so.getROWCCMN01UIG00() != null) {
      if (EVENT_STATUS_PENDING.equals(csvc15so.getROWCCMN01UIG00().getSzCdEventStatus())) {
        // JEH 08/01/03 - If status was pending, set input status as pending so that
        // closure can be invalidated. Won't be invalidated if in Approver Mode,
        // because of the next section of code.
        csvc14si.setSzCdEventStatus(EVENT_STATUS_PENDING);
      }
    }

    // event status should remain PEND, if we're in Approver Mode
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_PENDING);
    } // end if
    else {
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_COMP);
    } // end else

    // set the flag indicating approver mode
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    csvc14si.setArchInputStruct(input);
    //rowcinv21sig02.setUlIdStage(csvc15so.getROWCINV19SOG02().getUlIdStage());
    //rowcinv21sig02.setUlIdPriorStage(csvc15so.getROWCINV19SOG02().getUlIdPriorStage());
    //rowcinv21sig02.setTmSysTmStageClose(csvc15so.getROWCINV19SOG02().getTmSysTmStageClose());
    //rowcinv21sig02.setTmSysTmStageStart(csvc15so.getROWCINV19SOG02().getTmSysTmStageStart());
    //rowcinv21sig02.setUlIdUnit(csvc15so.getROWCINV19SOG02().getUlIdUnit());
    //rowcinv21sig02.setBIndStageClose(csvc15so.getROWCINV19SOG02().getBIndStageClose());
    //rowcinv21sig02.setSzNmStage(csvc15so.getROWCINV19SOG02().getSzNmStage());
    //rowcinv21sig02.setSzCdStage(csvc15so.getROWCINV19SOG02().getSzCdStage());
    //rowcinv21sig02.setSzCdStageClassification(csvc15so.getROWCINV19SOG02().getSzCdStageClassification());
    //rowcinv21sig02.setSzCdStageCnty(csvc15so.getROWCINV19SOG02().getSzCdStageCnty());
    //rowcinv21sig02.setSzCdStageCurrPriority(csvc15so.getROWCINV19SOG02().getSzCdStageCurrPriority());
    //rowcinv21sig02.setSzCdStageInitialPriority(csvc15so.getROWCINV19SOG02().getSzCdStageInitialPriority());
    //rowcinv21sig02.setSzCdStageProgram(csvc15so.getROWCINV19SOG02().getSzCdStageProgram());
    //rowcinv21sig02.setDtDtStageClose(csvc15so.getROWCINV19SOG02().getDtDtStageClose());
    //rowcinv21sig02.setDtDtStageStart(csvc15so.getROWCINV19SOG02().getDtDtStageStart());
    //rowcinv21sig02.setUlIdCase(csvc15so.getROWCINV19SOG02().getUlIdCase());
    //rowcinv21sig02.setUlIdSituation(csvc15so.getROWCINV19SOG02().getUlIdSituation());
    //rowcinv21sig02.setSzTxtStagePriorityCmnts(csvc15so.getROWCINV19SOG02().getSzTxtStagePriorityCmnts());
    //rowcinv21sig02.setSzCdStageRegion(csvc15so.getROWCINV19SOG02().getSzCdStageRegion());
    //rowcinv21sig02.setSzCdStageRsnPriorityChgd(csvc15so.getROWCINV19SOG02().getSzCdStageRsnPriorityChgd());
    //rowcinv21sig02.setSzCdStageType(csvc15so.getROWCINV19SOG02().getSzCdStageType());
    //rowcinv21sig02.setTsLastUpdate(csvc15so.getROWCINV19SOG02().getTsLastUpdate());
    csvc14si.setROWCCMN01UIG00(rowccmn01uig00);
    csvc14si.setROWCINV21SIG02(rowcinv21sig02);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return csvc14si;
  }

  /**
   * This method is called by the GRNDS controller when the user attempts to Save And Submit a Service Delivery Closure
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void updateAndSubmitSrvcDlvryClsr_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitSrvcDlvryClsr_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // save and submit will save the data, then call ValidateClosureSubmit
    try {
      updateSrvcDlvryClsr(context);

      // HD 6/16/2003 -- SIR 18323: re-retrieve to get new timestamp
      CSVC15SI csvc15si = populateCSVC15SI_Retrieve(context);
      CSVC15SO csvc15so = casemgmt.retrieveServDelivery(csvc15si);
      state.setAttribute(CSVC15SO_STRING, csvc15so, request);

      CINV20SOG00_ARRAY cinv20sog00Array = validateSrvcDlvryClsr(context, ACTION_CODE_SUBMIT);

      // GRIMSHAN SIR 18620 -- change the way the events are submitted so that all events
      // associated with the stage are submitted with the stage closure.
      EventIdStruct_ARRAY newArray = new EventIdStruct_ARRAY();
      ToDoDetailDB toDoDetailDB = null;

      if (cinv20sog00Array == null || cinv20sog00Array.getUlRowQty() < 1) {
        toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                        GlobalData.getUlIdStage(request), APPROVE_FPR_TASK);
      } else {
        Enumeration e = cinv20sog00Array.enumerateCINV20SOG00();
        EventIdStruct eventIdStruct = new EventIdStruct();
        // The first element in the array we send to do is ALWAYS the ulIdEvent
        // in global data
        int i = 0;
        while (e.hasMoreElements() && i++ < 100) {
          CINV20SOG00 cinv20sog00 = (CINV20SOG00) e.nextElement();
          int eventId = cinv20sog00.getUlIdEvent();
          eventIdStruct = new EventIdStruct();
          eventIdStruct.setUlIdEvent(eventId);
          newArray.addEventIdStruct(eventIdStruct);
        }

        toDoDetailDB = new ToDoDetailDB(newArray, GlobalData.getUlIdCase(request), GlobalData.getUlIdStage(request),
                                        APPROVE_FPR_TASK);
      }

      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    }
    // handle exceptions
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      String errorMessage;
      switch (we.getErrorCode()) {
      case Messages.MSG_SYS_STAGE_CLOSED:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      case Messages.MSG_SYS_MULT_INST:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE + we.getMessage());
        processSevereException(context, we);
        break;
      }

    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user attempts to Approve a Service Delivery Closure
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void validateApprvFPR_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateApprvFPR_xa()");
    performanceTrace.enterScope();

    // save and submit will save the data, then call ValidateClosureSubmit
    try {
      validateSrvcDlvryClsr(context, ACTION_CODE_SUBMIT);
    } catch (ServiceException we) {
      String errorMessage;
      switch (we.getErrorCode()) {
      case Messages.MSG_SYS_STAGE_CLOSED:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      case Messages.MSG_SYS_MULT_INST:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
        setErrorMessage(errorMessage, DISPLAY_PAGE_FPR, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, SERVICE_FAILURE + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This private method is called by the Save and Submit method to validate the closure before submitting
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param cActionCode
   *          String.
   * @return CINV20SOG00_ARRAY()
   * 
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   */
  private CINV20SOG00_ARRAY validateSrvcDlvryClsr(GrndsExchangeContext context, String cActionCode)
                                                                                                   throws ServiceException {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateClosure()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CSVC16SI csvc16si = populateCSVC16SI_Validate(context, cActionCode);
    CSVC15SO csvc15so = (CSVC15SO) state.getAttribute(CSVC15SO_STRING, request);
    CSVC16SO csvc16so = casemgmt.svcDeliveryClosureValidation(csvc16si);

    if (csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY() != null) {
      // process edit warnings to user
      int[] errorArray = csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().getUsSysNbrMessageCode();
      if (errorArray.length > 0) {
        // If validation edits were returned, set an indicator
        // into the request so that the JSP will not display any onload messages
        // because the user has already received them before the save.
        request.setAttribute("bValidationEditsFound", true);
        if (errorArray.length == 1 && errorArray[0] == Messages.MSG_SVC_EVENT_PENDING
            && ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
          // don't display error list if the only message is the 'pend'
          // message, and approval flag is Yes.
        } else {
          ErrorList.setErrors(errorArray, request);
          setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        }
      }
    } else // no errors
    {

      if (ACTION_CODE_SUBMIT == cActionCode) {
        // else if no errors were returned for the error list, populate the input object for Case To Do Detail
        GlobalData.setUlIdCase(csvc15so.getROWCINV19SOG02().getUlIdCase(), request);
        GlobalData.setUlIdStage(csvc15so.getROWCINV19SOG02().getUlIdStage(), request);
        PageMode.setPageMode(WINDOW_MODE_NEW_APPRV, request);

        GlobalData.setSzCdTask(SVC_CD_TASK_APPV_CLOSURE_CPS, request);

        return csvc16so.getCINV20SOG00_ARRAY();
      }
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return new CINV20SOG00_ARRAY();
  }

  /**
   * This method populates the service input object for validating the Service Delivery Closure page. It instantiates
   * the input object, gets values out of the context, and then returns the SI object.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   * @param cActionCode
   *          String.
   * @return csvc16si
   */
  private CSVC16SI populateCSVC16SI_Validate(GrndsExchangeContext context, String cActionCode) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSVC16SI_Validate()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // create a new input object
    CSVC16SI csvc16si = new CSVC16SI();
    ArchInputStruct input = new ArchInputStruct();
    CSVC15SO csvc15so = (CSVC15SO) state.getAttribute(CSVC15SO_STRING, request);

    // populate the input object form the request
    
    //-- unnecessary according to SvcDeliveryClosureValidationImpl
    //csvc16si.setUlIdEvent(csvc15so.getROWCCMN01UIG00().getUlIdEvent());
    
    csvc16si.setUlIdStage(csvc15so.getROWCINV19SOG02().getUlIdStage());
    csvc16si.setUlIdCase(csvc15so.getROWCINV19SOG02().getUlIdCase()); // RIOSJA, SIR 22970
    csvc16si.setUlIdSituation(csvc15so.getROWCINV19SOG02().getUlIdSituation());
    csvc16si.setSzCdStageReasonClosed(ContextHelper.getStringSafe(context, SELSZCDSTAGEREASONCLOSED));
    csvc16si.setSzCdStage(csvc15so.getROWCINV19SOG02().getSzCdStage());
    csvc16si.setSzCdStageProgram(csvc15so.getROWCINV19SOG02().getSzCdStageProgram());
    csvc16si.setSzCdStageType(csvc15so.getROWCINV19SOG02().getSzCdStageType());
    
    //-- use task code from GlobalData since ROWCCMN01UIG00 will be null if closure event not yet created
    //csvc16si.setSzCdTask(csvc15so.getROWCCMN01UIG00().getSzCdTask());
    csvc16si.setSzCdTask(GlobalData.getSzCdTask(request));

    // retrieve edit process string from codes table if not special requests
    if (SVC_CD_STAGE_CPS_SVC.equals(csvc16si.getSzCdStage())) {
      csvc16si.setSzDcdEditProcess(Lookup.simpleDecodeSafe(SVC_CTB_CLOSURE_EDITS,
                                                           ContextHelper.getStringSafe(context,
                                                                                       SELSZCDSTAGEREASONCLOSED)));
    }
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(cActionCode);
    csvc16si.setArchInputStruct(input);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the input object to the calling service
    return csvc16si;
  }

  private void setErrorList(SzCdUerrorMsgNbr1_ARRAY errorArray, HttpServletRequest request) {
    Map<Integer, Object[]> errorMap = new HashMap<Integer, Object[]>();
    for (Enumeration<ROW_ERROR_MAPPING> e = errorArray.enumerateROW_ERROR_MAPPING(); e.hasMoreElements();) {
      ROW_ERROR_MAPPING errorMapping = e.nextElement();
      SzUerrorAttributes_ARRAY attributesArray = errorMapping.getSzUerrorAttributes_ARRAY();
      errorMap.put(errorMapping.getSzCdUerrorMsgNbr(), attributesArray != null ? attributesArray.getSzAttribute()
                                                                              : null);
    }

    // RIOSJA, SIR 16114 - If validation edits were returned, set an indicator
    // into the request so that the JSP will not display any onload messages
    // because the user has already received them before the save.
    request.setAttribute("bValidationEditsFound", true);
    ErrorList.setErrors(errorMap, request);
  }
  
  private CSUB67SO retrieveClosureEvent(GrndsExchangeContext context) {
    CSUB67SI csub67si = populateCSUB67SI_Retrieve(context);
    // call the service to retrieve data
    CSUB67SO csub67so = admin.retrieveClosureEvent(csub67si);
    
    BaseSessionStateManager state = getSessionStateManager(context);
    state.setAttribute(strCSUB67SO, csub67so, context.getRequest());
    
    return csub67so;
  }

}
