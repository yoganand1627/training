package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.CompressionHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveApprovalStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveApproval;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.service.document.ServiceAuthRef;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Error;
import gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRecordsCheckCompletedSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DocumentTemplateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN61DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN35SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenMapping;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentBuilderHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentServiceHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentUtilityHelpers;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to approval to do in the system. <p/> January 30, 2003 Mike K. Werle
 * 
 * <pre>
 *      Change History:
 *       Date        User          Description
 *       ----------  --------      --------------------------------------------------
 *       11/13/03    CORLEYAN      SIR 22405 -- If the To-Do is broken display a message
 *                                 telling the user that it is invalid
 *       03/19/04    RIOSJA        SIR 19973 - Added MSG_SVA_OPN_AUTHS error handling to
 *                                 &quot;callCCMN35S&quot; to handle situation where the stage being
 *                                 closed has open service auths that need to be progressed,
 *                                 but an eligible open stage is not found.
 *       03/30/05    marallh       SIR: 19057 - Display Event Type that has been approved or disapproved.
 *                                 Added - setszCdTask to callCCMN35S.
 *      &lt;p/&gt;
 *      07/18/05     CASDORJM      SIR 23334 - Added the new method displayApprovalRejection_xa() which
 *                                 will display the Historical Reasons for Rejection Detail page.  Added
 *                                 population of ulIdCase and ulIdStage before the call to ccmn34s as these
 *                                 two id's are necessary for the rejection history list to populate when not
 *                                 in approval mode.  Also added population of the ROWCCMNI2DI object before
 *                                 the call the ccmn35s.
 *      &lt;p/&gt;
 *      07/24/05     werlem        SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *      &lt;p/&gt;
 *      08/17/05     casdorjm      SIR 23901 - Added logic to pass to the JSP that determines when to display
 *                                 the reasons for rejection based on the title of the page.
 *      10/28/08     vdevarak      STGAP00010749: Added code to call the saveAdoFinalized service when the user
                                   user clicks on the Approval Status page.
 *      03/04/10     hjbaptiste    SMS45718 MR-062 Check to see if the supervisory approval exists for the contact standards being approved
 *                                 throw message if it's not
 *      06/02/2010   arege         SMS54782 Added code to catch exception thrown in SaveApprovalImpl service
 *      08/18/2010   bgehlot       SMS 66380 MR-072 Changes
 *      06/10/2011   hjbaptiste    SMS109631: CAPTA 4.3: Special Investigation/Safety Resource - Add multiple approvers
 *      06/07/2011   hjbaptiste    SMS112385: CAPTA 4.3: Safety Resource - fixed logic to add another approver
 *      02/02/2012   htvo          STGAP00017831: MR-102 Service Authorizations: save SA form at the time of successful approval 
 *                                 so that the form can be frozen.
 *      02/03/2012   htvo          STGAP00017831: split the saveSAForm method into 2 components for code reuse.
 *                                 - populateServiceAuthDocumentTemplate: containing template meta data for a specific form and 
 *                                 - saveDocument: containing generic code that can be applied to other forms
 *                                 
 * </pre>
 */

@SuppressWarnings("serial")
public class ApprovalStatusConversation extends BaseHiddenFieldStateConversation {
  public static final String APPROVE_CONTACT_STANDARDS_FSU = "6540";
  
  public static final String APPROVE_CONTACT_STANDARDS_FPR = "7025";
  
  public static final String APPROVE_INTAKE = "1040"; 
  
  public static final String APPROVAL_STATUS = "Approval Status";
  
  private static final Set<String> INTAKE_APPROVAL_TASKS = new HashSet<String>(
                  Arrays.asList(new String[]{IntakeConstants.APPROVE_CALL_CD_TASK,
                                             IntakeConstants.APPROVE_CALL_CD_TASK_CHILD_DEATH,
                                             IntakeConstants.APPROVE_CALL_CD_TASK_SERIOUS_INJURY,
                                             IntakeConstants.APPROVE_CALL_CD_TASK_RESPONSE_TIME,
                                             IntakeConstants.APPROVE_CALL_CD_TASK_NI}));
  
  public static final String SPCL_INV_APPROVAL_TASK = "2265";
  
  public static final String APPROVE_SAFETY_RESOURCE = "7332";
  
  public static final String APPROVE_SAFETY_RESOURCE_ONG = "7333";
  
  public static final String SEC_REGIONAL_SS_STF = UserProfile.SEC_REGIONAL_SS_STF;
  
  public static final String IND_ADOPTION_FINALIZED = "indAdoptionFinalized";
  
  public static final String WHICH_SPCL_INV_APPROVER = "whichSpclInvApprover";
  
  public static final String WHICH_SAFETY_RSRC_APPROVER = "whichSafetyRsrcApprover";
  
  // STGAP00017831: there are 2 approval task codes for Service Authorization. The header page uses 3310, leave the other code in just in case.
  private static final Set<String> SERVICE_AUTHORIZATION_APPROVAL_TASKS = new HashSet<String>(
                  Arrays.asList(new String[]{"3310", 
                                             "3290"}));
  /**
   * <p>
   * The displayStatus_xa method is called by the GRNDS controller when a user clicks the approve button from a page
   * that includes it. It requires that idEvent be set for read-access; for edit access, it requires that idTodo also be
   * set and that the statement SELECT * FROM TODO WHERE ID_TODO = [idTodo] AND ID_TODO_EVENT = [idEvent] return at
   * least 1 row. In general, idTodo should only ever be set by the Staff To-Do and Case To-Do, meaning that the page
   * will only be in edit mode in these cases.
   * </p>
   * <p/>
   * <p>
   * CCMN34S is called to display the approval; if invalid or rejected approvals are found in the list of approval
   * events, CCMN35S is called to invalidate the approval todo.
   * </p>
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayStatus_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStatus_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    // Find out if we are returning from TODO; if so, do NOT want to recall CCMN34S
    // because it would overwrite what we just approved; we can determine if we are coming
    // from adding a new approver because ccmn34so will still be in state
    if (state.getAttribute(CCMN34SO_KEY, request) != null) {
      // If we already have ccmn34so, then we can assume that we are in edit mode, as the
      // only path to get to here with ccmn34so is to do the add approver pull-back.
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      // We have everything that we need to display in state; just return.
      return;
    }

    // We need either ulIdEvent or ldIdTodo; if we have neither, throw a severe exception.
    // If we have idTodo, put the page into edit mode; otherwise, we should be in view mode
    int idEvent = GlobalData.getUlIdEvent(request);
    int idTodo = GlobalData.getUlIdTodo(request);
    if (idTodo == 0 && idEvent == 0) {
      processSevereException(
                             context,
                             new RuntimeException(
                                                  "Approval Status requires that ldIdToDo or ulIdEvent must be non-zero."));
      return;
    }

    if (idTodo != 0
        && (GlobalData.isEventBeingApproved(idEvent, request) || idEvent == GlobalData.getUlIdApproval(request))) {
      // Need to see if the ulIdEvent and the ldIdTodo match; if so,
      // we are in EDIT mode, otherwise, we are in VIEW mode. Note
      // that this is alwasy true because if a user has a ulIdEvent
      // and an ldIdTodo that match, that means that they came off
      // the To-Do list using an Approval To-Do for this event.
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    } else {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      // This means that the idtodo does not match the idEvent;
      // to prevent SQL_NOT_FOUND exceptions, set idTodo to zero.
      idTodo = 0;
    }

    CCMN34SO ccmn34so = callCCMN34S(idTodo, idEvent, context, admin, admin);
    state.setAttribute(CCMN34SO_KEY, ccmn34so, request);
    if (ccmn34so != null) {
      //STGAP00010749 : Get the indicator that indicates if the adoption is finalized and set it into the object
      String bIndAdoptionFinalized = (String)state.getAttribute(IND_ADOPTION_FINALIZED, request);
      String whichSpclInvApprover = (String)state.getAttribute(WHICH_SPCL_INV_APPROVER, request);
      String whichSafetyRsrcApprover = (String)state.getAttribute(WHICH_SAFETY_RSRC_APPROVER, request);
      ccmn34so.setBIndAdoptionFinalized(bIndAdoptionFinalized);
      ccmn34so.setSzWhichSpclInvApprover(whichSpclInvApprover);
      ccmn34so.setSzWhichSafetyRsrcApprover(whichSafetyRsrcApprover);
      int ulIdApproval = ccmn34so.getUlIdApproval();
      CaseUtility.Event approvalEvent = CaseUtility.getEvent(ulIdApproval);
      try {
        Screen screen = ScreenMapping.getScreenData(context);
        String txtTaskDecode = TaskInit.getTaskColumnString(approvalEvent.getCdTask(), TaskInit.TXT_TASK_DECODE);
        // SIR 23901 - Since it is almost impossible to tell where the approval status page is being
        // accessed from by using the task code, we are going to case on the actual task code decode.
        // Only display the reasons for rejection if we are in an APS INV CONCLUSION or
        // APS SVC APPROVE CLOSURE.
        if (CodesTables.CPGRMS_APS.equals(GlobalData.getSzCdStageProgram(request))
            && CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))
            && "Approve APS Comm Investigation".equals(txtTaskDecode)) {
          state.setAttribute(BOOL_DISPLAY_REJ_KEY, Boolean.TRUE, request);
        } else if (CodesTables.CPGRMS_APS.equals(GlobalData.getSzCdStageProgram(request))
                   && CodesTables.CSTAGES_SVC.equals(GlobalData.getSzCdStage(request))
                   && "Approve Closure".equals(txtTaskDecode)) {
          state.setAttribute(BOOL_DISPLAY_REJ_KEY, Boolean.TRUE, request);
        }
        
        request.setAttribute("approvalTask", approvalEvent.getCdTask());

        screen.setParameter("HtmlTitle", "Approval Status - " + txtTaskDecode, true);
      } catch (ServletException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure setting screen:" + e.getMessage());
        processSevereException(context, e);
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Historical Reasons for Rejection Date hyerplink. It will navigate
   * the user to the Historical Reasons for Rejection Detail page.
   * 
   * @param context
   */
  public void displayApprovalRejection_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayApprovalRejection_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCMN34SO ccmn34so = (CCMN34SO) state.getAttribute(ApprovalStatusConversation.CCMN34SO_KEY, request);
    ROWCCMNI3DO_ARRAY rowccmni3do_array = ccmn34so != null ? ccmn34so.getROWCCMNI3DO_ARRAY() : null;
    ROWCCMNI3DO rowccmni3do = rowccmni3do_array.getROWCCMNI3DO(ContextHelper.getIntSafe(request, "hdnRejectionIndex"));
    request.setAttribute("rowccmni3do", rowccmni3do);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is used to call CCMN34S. It is used both by ApprovalStatusConversation (this class) for display and for
   * ToDoConversation, which uses it to find out if approval To-Do'ss have been invalidated for whatever reason and for
   * correct navigation to approval To-Do's.
   * 
   * @param idTodo
   *          The ulIdTodo for the approval; if it is 0, the data returned will only be for viewing
   * @param idEvent
   *          Any ID_EVENT value associated with the ToDo in the APPROVAL_EVENT_LINK table
   * @param context
   *          The current <tt>GrndsExchangeContext</tt> object
   * @return A <tt>CCMN34SO</tt> object representing the OUTPUT FROM ccmn34so
   */
  static CCMN34SO callCCMN34S(int idTodo, int idEvent, GrndsExchangeContext context,
                              RetrieveApprovalStatus retrieveApprovalStatus, SaveApproval saveApproval) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    CCMN34SI ccmn34si = new CCMN34SI();
    CCMN34SO ccmn34so = null;
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUlPageSizeNbr(NUMLBAPPROVERSROWS);
    archInputStruct.setUsPageNbr(ServiceConstants.INITIAL_PAGE);
    archInputStruct.setSzUserId(user.getUserLogonID());
    ccmn34si.setArchInputStruct(archInputStruct);
    ccmn34si.setLdIdTodo(idTodo);
    ccmn34si.setUlIdEvent(idEvent);
    // SIR 23334 - In approval mode these two ids are retrieved in
    // ccmn34s using event id. When the page is not in approval mode
    // ccmni3d still needs these values so we pass them in from
    // global data.
    ccmn34si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccmn34si.setUlIdStage(GlobalData.getUlIdStage(request));
    try {
      ccmn34so = retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
      // if we have a todo, serach through the list of approvals and look for
      // invalid or rejected approvals
      if (idTodo != 0) {
        int invalidFound = checkInvalidOrRejected(ccmn34so);
        if (invalidFound != NO_INVALID_OR_REJECTED_FOUND) {
          // If invalid approvals were found, display a message as to whether
          // they were invalid or rejected
          int messageId = 0;
          if (invalidFound == REJECTED_FOUND) {
            messageId = Messages.MSG_CMN_REJ_ALREADY;
          } else if (invalidFound == INVALID_FOUND) {
            messageId = Messages.MSG_CMN_DOC_CHANGES;
          }
          try {
            CCMN35SI ccmn35si = new CCMN35SI();
            ccmn35si.setLdIdTodo(idTodo);
            ccmn35si.setSzWcdCdAprvlWinaction(INVALID);
            ArchInputStruct tmpArchInputStruct = new ArchInputStruct();
            tmpArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
            tmpArchInputStruct.setSzUserId(user.getUserLogonID());
            ccmn35si.setArchInputStruct(tmpArchInputStruct);
            saveApproval.saveApproval(ccmn35si);
          } catch (Exception we) {
            // if we threw an exception in the above service call, automatically
            // treat it as a severe error
            processSevereException(context, we);
          }
          // Clean up after ourselves by setting the idtodo in global data back
          // to 0, as the approval was invalid
          GlobalData.setUlIdTodo(0, request);
          // Set an informational message
          setInformationalMessage(messageId, request);
        }
      }
    } catch (ServiceException se) {
      // switch the response based on the Service Returned Error Code
      switch (se.getErrorCode()) {
      case Messages.MSG_NO_ROWS_RETURNED:
        // This means that the ldIdTodo or the ulIdEvent does not exist
        setErrorMessage(Messages.MSG_CMN_NOT_SUBMITTED, request);
        break;
      case Messages.SQL_NOT_FOUND:
        // This errors occur when one of three things happen:
        // 1) The IdTodo passed was not an approval.
        // 2) Both the IdEvent and IdTodo are non-zero but are not associated with one another in the database.
        // 3) Either the IdEvent or the IdTodo (whichever is non-zero) doesn't exist.
        // Only case 3 should ever happen, and only because the IdTodo was already approved or rejected;
        // therefore, set an error message and return if the IdTodo is non-zero; otherwise, processSevereException().
        // SIR 22405 If we fall in here it means the to-do is broken (Data access error in caps)
        // display a message telling the user that the to-do is invalid and to disregard
        if (idTodo != 0) {
          setErrorMessage(Messages.MSG_TODO_INVALID, request);
        } else {
          processSevereException(context, se);
        }
        break;
       // SMS#54782
      case Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE:
        setErrorMessage(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE, request);
        break;
      case Messages.MSG_CNS_REQD_IF_DOD:
        setErrorMessage(Messages.MSG_CNS_REQD_IF_DOD, request);
        break;
      default:
        processSevereException(context, se);
        break;
      }
    } catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + ve.getMessage());
      processSevereException(context, ve);
    }
    return ccmn34so;
  }

  /**
   * This loops through the approval rows returned by CCMN34S, represented by an array of ROWCCMN56DO objects, and finds
   * approvals marked invalid and/or rejected. Rejected is preferred, as all pending approvals will be marked invalid if
   * an approval is rejected.
   * 
   * @param ccmn34so
   * @return
   */
  private static int checkInvalidOrRejected(CCMN34SO ccmn34so) {
    ROWCCMN56DO_ARRAY rowccmn56do_array = ccmn34so.getROWCCMN56DO_ARRAY();
    Enumeration rowccmn56doEnum = rowccmn56do_array.enumerateROWCCMN56DO();
    // default to no invalid or rejected approvals
    int returnStatus = NO_INVALID_OR_REJECTED_FOUND;
    while (rowccmn56doEnum.hasMoreElements()) {
      ROWCCMN56DO rowccmn56do = (ROWCCMN56DO) rowccmn56doEnum.nextElement();
      String status = rowccmn56do.getSzCdApproversStatus();
      if (status.equals(STATUS_INVALID)) {
        returnStatus = INVALID_FOUND;
      } else if (status.equals(STATUS_REJECTED)) {
        returnStatus = REJECTED_FOUND;
        // we prefer rejected, so just break out of the loop once we find one
        break;
      }
    }
    return returnStatus;
  }

  /**
   * This method does what it says; it loops through the approvals and counts the number that are pending. If it gets
   * passed a null ccmn34so reference, it returns 0.
   * 
   * @param ccmn34so
   * @return
   */
  public static int countApprovalsPending(CCMN34SO ccmn34so) {
    int count = 0;
    // if ccmn34so is null, then return 0, since there can't be any approvals pending
    if (ccmn34so != null && (ccmn34so.getROWCCMN56DO_ARRAY() != null)) {
      ROWCCMN56DO_ARRAY rowccmn56do_array = ccmn34so.getROWCCMN56DO_ARRAY();
      Enumeration rowccmn56doEnum = rowccmn56do_array.enumerateROWCCMN56DO();
      while (rowccmn56doEnum.hasMoreElements()) {
        ROWCCMN56DO rowccmn56do = (ROWCCMN56DO) rowccmn56doEnum.nextElement();
        if (rowccmn56do.getSzCdApproversStatus().equals(STATUS_PENDING)) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * The approveStatus_xa method is called by the GRNDS controller when a user clicks the approve button; it sets
   * information necessary to do the approval into state, but does not do the service call. Instead, it optionally
   * forwards to To-Do Detail if the user has indicated that he would like to add another approver; otherwise, it
   * redisplays the Approval Status page, given the user a chance to click save, which persists the data set here.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void approveStatus_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".approveStatus_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    String cdTask = GlobalData.getSzCdTask(request);
    
    // Store the index of the approval into state
    int approvalIndex = ContextHelper.getIntSafe(request, "hdnApprovalIndex");
    state.setAttribute(APPROVAL_INDEX_KEY, String.valueOf(approvalIndex), request);

    // Get the row associated with the index out of CCMN34SO so we can examine it below
    CCMN34SO ccmn34so = (CCMN34SO) state.getAttribute(CCMN34SO_KEY, request);
    ROWCCMN56DO_ARRAY rowccmn56do_array = ccmn34so.getROWCCMN56DO_ARRAY();
    ROWCCMN56DO rowccmn56do = rowccmn56do_array.getROWCCMN56DO(approvalIndex);

    try {
      //MR-062 If supervisory approval not checked throw message
      if(APPROVE_CONTACT_STANDARDS_FSU.equals(cdTask) || (APPROVE_CONTACT_STANDARDS_FPR.equalsIgnoreCase(cdTask))){
        ROWCCMN45DO rowccmn45do = ccmn34so.getROWCCMN45DO();
        ROWCCMN57DO_ARRAY rowccmn57do_array = ccmn34so.getROWCCMN57DO_ARRAY();
        ROWCCMN57DO rowccmn57do = rowccmn57do_array.getROWCCMN57DO(approvalIndex);
        ContactStandardsRetrieveSO contactStandardsRetrieveSO = new ContactStandardsRetrieveSO();
        ContactStandardsRetrieveSI contactStandardsRetrieveSI = new ContactStandardsRetrieveSI();
        contactStandardsRetrieveSI.setUlIdEvent(rowccmn57do.getUlIdEvent());
        contactStandardsRetrieveSI.setUlIdStage(rowccmn45do.getUlIdStage());
        contactStandardsRetrieveSI.setUlIdCase(GlobalData.getUlIdCase(request));
        contactStandardsRetrieveSI.setCdStage(GlobalData.getSzCdStage(request));
        contactStandardsRetrieveSI.setCdTask(cdTask);
        contactStandardsRetrieveSO = common.retrieveContactStandards(contactStandardsRetrieveSI);

        //Check to see if the supervisory approval exists for the contact standards being approved
        if(ArchitectureConstants.N.equals(contactStandardsRetrieveSO.getIndSuperApproval())){
          setErrorMessage(Messages.MSG_CS_SUPER_CBX_REQ, request);
          return;
        }
      } 
      
      //MR-072 If Screen Out Dispositions and records check not completed for all the persons in INT stage throw message
      if(INTAKE_APPROVAL_TASKS.contains(ccmn34so.getROWCCMN45DO().getSzCdTask())){
        ROWCCMN45DO rowccmn45do = ccmn34so.getROWCCMN45DO();
        CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI = new CheckIfRecordsCheckCompletedSI();
        checkIfRecordsCheckCompletedSI.setIdStage(rowccmn45do.getUlIdStage());
        checkIfRecordsCheckCompletedSI.setPageName(APPROVAL_STATUS);
        String recordsCheckCompleted = person.checkIfRecordsCheckCompleted(checkIfRecordsCheckCompletedSI);

        //Check to see if the records check are completed for all the persons on INT stage
        if(ArchitectureConstants.FALSE.equals(recordsCheckCompleted)){
          setErrorMessage(Messages.MSG_RECORDS_CHECK_REQ, request);
          return;
        }
      } 
    } catch (ServiceException se) {
      processSevereException(context, se);
    }
    
    // Set an attribute into state IFF the approver is not the designated approver
    if (userProfile.getUserID() != rowccmn56do.getUlIdPerson()) {
      state.setAttribute(DESIGNEE_APRVL_KEY, Boolean.TRUE, request);
    }

    // It is possible to approve an approval if it is not assigned to you, so set the id of the approved approval
    // to the current id
    rowccmn56do.setUlIdPerson(userProfile.getUserID());
    rowccmn56do.setSzNmPersonFull(userProfile.getUserFullName());

    // Store the last update date and time into the row; these will be used as input in the save
    org.exolab.castor.types.Date approveDate = DateHelper
                                                         .toCastorDateSafe(ContextHelper
                                                                                        .getStringSafe(request,
                                                                                                       "txtLastUpdateDate"));
    rowccmn56do.setDtDtApproversDetermination(approveDate);
    String approveTime = ContextHelper.getTimeSafe(request, "txtLastUpdateTime");
    rowccmn56do.setTmScrTmApprovalTime(approveTime);

    // set the approval status to approved in the output row; this will be used as input in the save
    rowccmn56do.setSzCdApproversStatus(STATUS_APPROVED);

    // set the comments entered into the output row; this will be used as input in the save
    rowccmn56do.setSzTxtApproversComments(ContextHelper.getStringSafe(request, "txtSzTxtApproversComments"));

    // Set winResult appropriately to indicate whether or not the approvals are complete
    String winResult = countApprovalsPending(ccmn34so) == 0 ? APPROVALS_COMPLETE : APPROVED;
    state.setAttribute(WIN_RESULT_KEY, winResult, request);

    // Forward to the To-Do window if the user wants to add another approver
    if (ContextHelper.getBooleanSafe(request, "hdnAddApprover")) {
      // Override WIN_RESULT_KEY because we will be adding another aprover
      state.setAttribute(WIN_RESULT_KEY, APPROVED, request);

      // The To-Do Detail page requires case, stage, and task, as well as the approval ID, a short description, and the
      // TODO_MODE_KEY, which must be set to ToDoConverstaion.TODO_MODE_NEXT_APPRV; finally, since this is effectively
      // a pull-back, we need to include a reutrn URI.
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ccmn34so.getUlIdCase(), ccmn34so.getUlIdStage(),
                                                   ccmn34so.getROWCCMN45DO().getSzCdTask());
      toDoDetailDB.setUlIdApproval(ccmn34so.getUlIdApproval());
      toDoDetailDB.setSzTxtTodoDesc(ccmn34so.getSzTxtApprovalTopic());
      toDoDetailDB.setReturnURI(DISPLAY_URI);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      setPresentationBranch(TODO_DETAIL_BRANCH, context);
    }

    if (INTAKE_APPROVAL_TASKS.contains(ccmn34so.getROWCCMN45DO().getSzCdTask())) {
      state.setAttribute(INTAKE_ACTIONS_PREVIOUS_URI, Boolean.TRUE, request);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * The rejectStatus_xa rejects a pending approval in memory; the action is saved only when a user clicks save.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void rejectStatus_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".rejectStatus_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    // get the approval that was rejected and set it into state
    int approvalIndex = ContextHelper.getIntSafe(request, "hdnApprovalIndex");
    state.setAttribute(APPROVAL_INDEX_KEY, String.valueOf(approvalIndex), request);

    // get the row that was rejected so we can examine it below
    CCMN34SO ccmn34so = (CCMN34SO) state.getAttribute(CCMN34SO_KEY, request);
    ROWCCMN56DO_ARRAY rowccmn56do_array = ccmn34so.getROWCCMN56DO_ARRAY();
    ROWCCMN56DO rowccmn56do = rowccmn56do_array.getROWCCMN56DO(approvalIndex);

    // Set an attribute into state IFF the approver is not the designated approver
    if (userProfile.getUserID() != rowccmn56do.getUlIdPerson()) {
      state.setAttribute(DESIGNEE_APRVL_KEY, Boolean.TRUE, request);
    }

    // It is possible to reject an approval if it is not assigned to you, so set the id of the rejected approval to the
    // current id
    rowccmn56do.setUlIdPerson(userProfile.getUserID());
    rowccmn56do.setSzNmPersonFull(userProfile.getUserFullName());

    // set the time and date that it was rejected into the output row; this will be used as input in the save
    rowccmn56do
               .setDtDtApproversDetermination(DateHelper
                                                        .toCastorDateSafe(ContextHelper
                                                                                       .getStringSafe(request,
                                                                                                      "txtLastUpdateDate")));
    rowccmn56do.setTmScrTmApprovalTime(ContextHelper.getTimeSafe(request, "txtLastUpdateTime"));

    // set the approval status to rejected in the output row; this will be used as input in the save
    rowccmn56do.setSzCdApproversStatus(STATUS_REJECTED);

    // set the comments entered into the output row; these will be used as input in the save
    rowccmn56do.setSzTxtApproversComments(ContextHelper.getStringSafe(request, "txtSzTxtApproversComments"));

    // SIR 23334 - This code is necessary for the Reasons for Rejection section to populate correctly
    // after the user clicks Reject and before the Save is called.
    ROWCCMNI2DI rowccmni2di = new ROWCCMNI2DI();
    rowccmni2di.setSzNMRejector(userProfile.getUserFullName());
    rowccmni2di.setUlIdRejector(userProfile.getUserID());
    rowccmni2di.setUlIdCase(GlobalData.getUlIdCase(request));
    rowccmni2di.setUlIdStage(GlobalData.getUlIdStage(request));
    // rowccmni2di.setDtDtRejection(DateHelper.getTodayCastorDate());
    rowccmni2di
               .setDtDtRejection(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "txtLastUpdateDate")));
    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndApsEffort"))) {
      rowccmni2di.setBIndApsEffort(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndApsEffort(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndCareEntered"))) {
      rowccmni2di.setBIndCareEntered(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndCareEntered(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndEvidence"))) {
      rowccmni2di.setBIndEvidence(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndEvidence(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndMissingEvidRptr"))) {
      rowccmni2di.setBIndMissingEvidRptr(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndMissingEvidRptr(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndMissingEvidAp"))) {
      rowccmni2di.setBIndMissingEvidAp(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndMissingEvidAp(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndMissingEvidMp"))) {
      rowccmni2di.setBIndMissingEvidMp(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndMissingEvidMp(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndMissingEvidCl"))) {
      rowccmni2di.setBIndMissingEvidCl(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndMissingEvidCl(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndMissingEvidPhoto"))) {
      rowccmni2di.setBIndMissingEvidPhoto(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndMissingEvidPhoto(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndMissingEvidDe"))) {
      rowccmni2di.setBIndMissingEvidDe(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndMissingEvidDe(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndMissingEvidOther"))) {
      rowccmni2di.setBIndMissingEvidOther(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndMissingEvidOther(ArchitectureConstants.N);
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "bIndDiscretionaryReason"))) {
      rowccmni2di.setBIndDiscretionaryReason(ArchitectureConstants.Y);
    } else {
      rowccmni2di.setBIndDiscretionaryReason(ArchitectureConstants.N);
    }
    rowccmni2di.setSzTxtApproversComments(ContextHelper.getStringSafe(request, "txtSzTxtApproversComments"));

    state.setAttribute(ROWCCMNI2DI_KEY, rowccmni2di, request);
    request.setAttribute(ROWCCMNI2DI_KEY, rowccmni2di);
    // END SIR 23334 POPULATE

    // Invalidate all other pending approvals
    Enumeration approvalEnum = rowccmn56do_array.enumerateROWCCMN56DO();
    while (approvalEnum.hasMoreElements()) {
      rowccmn56do = (ROWCCMN56DO) approvalEnum.nextElement();
      if (rowccmn56do.getSzCdApproversStatus().equals(STATUS_PENDING)) {
        rowccmn56do.setSzCdApproversStatus(STATUS_INVALID);
      }
    }

    // Indicate that the approval has been rejected
    state.setAttribute(WIN_RESULT_KEY, REJECTED, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * The saveStatus_xa method is called by the GRNDS controller when a user clicks save. It calls CCMN35S to write the
   * information that is stored in state (because of the possible call out to To-Do Detail to create another approver)
   * to the DB.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveStatus_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveStatus_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    CCMN34SO ccmn34so = (CCMN34SO) state.getAttribute(CCMN34SO_KEY, request);

    // Never do the save twice if we can avoid it (though, we should never get
    // here if save has been called, as the button doesn't display then).
    boolean boolSaved = state.getAttribute(ApprovalStatusConversation.SAVED_KEY, request) != null ? true : false;
    // STGAP00017831: get the APP event data. ROWCCMN45DO is always populated inside CCMN34SO. So is cdTask.
    ROWCCMN45DO saAppEvent = ccmn34so.getROWCCMN45DO();   
    String cdTask = saAppEvent.getSzCdTask(); // get APP event task code 
    String forwardStr = ToDoHelper.getReturnToToDoListURI(request); // used to consolidate common code
    
    if (!boolSaved) {
      // If the call to CCMN35S fails, to the Approval Status page;
      // since everything is in state, it should redisplay fine.
      if (callCCMN35S(context, admin)) {
        try {
          // remove szCdTask from global data in order to get tabs to show up
          // right
          GlobalData.setSzCdTask(null, request);
          // remove the idTodo from global data in order to prevent trying to
          // approve the same thing more than once
          GlobalData.setUlIdTodo(0, request);
          // explicitly disable approval mode
          GlobalData.setApprovalMode(0, 0, new int[0], 0, request);
          Boolean intakeAttrib = (Boolean) state.getAttribute(INTAKE_ACTIONS_PREVIOUS_URI, request);
          boolean intakeActions = intakeAttrib != null && intakeAttrib;
          String winResultKey = (String) state.getAttribute(WIN_RESULT_KEY, request);
          if (intakeActions && APPROVALS_COMPLETE.equals(winResultKey)) {
            int[] stageIdArray = new int[]{ccmn34so.getUlIdStage()};
            request.setAttribute(AssignConversation.STAGE_ID_ARRAY, stageIdArray);
            GlobalData.setUlIdPerson(user.getUserID(), request);
            forwardStr = "/workload/Assign/displayAssign"; 
          } 
          // STGAP00017831: create and save the SA form if SA is approved 
          else if (SERVICE_AUTHORIZATION_APPROVAL_TASKS.contains(cdTask) && APPROVALS_COMPLETE.equals(winResultKey)) {
            DocumentTemplateSI documentTemplateSI = populateServiceAuthDocumentTemplate(context);
            saveDocument(context, documentTemplateSI); 
            forwardStr = ToDoHelper.getReturnToToDoListURI(request);
          } 
          forward(forwardStr, request, context.getResponse()); // STGAP00017831: consolidate the forward calls
        } catch (ServletException e) {
          GrndsTrace.msg(TRACE_TAG, 7, "Failure fowarding to To-Do List:" + e.getMessage());
          processSevereException(context, e);
        } catch (Exception e) {
          GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
          processSevereException(context, e);
        }
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Saves and launches the Approval Status document for printing; this is the only way to save and stay on the page.
   * 
   * @param context
   */
  public void displayDocument_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndLaunch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Set displayDocument to true
    request.setAttribute(DISPLAY_DOCUMENT_KEY, Boolean.TRUE);

    // To prevent multiple saves, save only if:
    // 1) Edit mode
    // 2) One of Approve or Reject has been clicked
    // 3) Save has not been clicked
    String pageMode = PageMode.getPageMode(request);
    boolean boolApprovedRejected = state.getAttribute(ApprovalStatusConversation.WIN_RESULT_KEY, request) != null ? true
                                                                                                                 : false;
    boolean boolSaved = state.getAttribute(ApprovalStatusConversation.SAVED_KEY, request) != null ? true : false;
    if (PageModeConstants.EDIT.equals(pageMode) && boolApprovedRejected && !boolSaved) {
      // Set PageMode to view to prevent re-calling save
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      // If the call to CCMN35S fails, redisplay using the error branch;
      // otherwise, the presentation is set to forward to Staff To-Do.
      if (!callCCMN35S(context, admin)) {
        // Set PageMode back to EDIT if save fails so the user can try again
        PageMode.setPageMode(PageModeConstants.EDIT, request);
        // Remove the display_document_key attribute from state to prevent
        // document display if the save failed
        request.removeAttribute(DISPLAY_DOCUMENT_KEY);
      }
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
/**
 * This method populates template data for the Service Authorization and Referral form
 * @param context
 * @return
 * @throws Exception
 * @throws ServiceException
 * @throws IOException
 */
  private DocumentTemplateSI populateServiceAuthDocumentTemplate(GrndsExchangeContext context) throws Exception, ServiceException, IOException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCON18SO saHeader = (CCON18SO) state.getAttribute("CCON18SO", request);
    //set the general attribute for the meta-data
    request.setAttribute("docType", ServiceAuthRef.FCM06O00V2);
    request.setAttribute("pCase", String.valueOf(GlobalData.getUlIdCase(request)));
    request.setAttribute("pStage", String.valueOf(GlobalData.getUlIdStage(request)));
    request.setAttribute("pEvent", String.valueOf(GlobalData.getUlIdEvent(request)));
    request.setAttribute("pSvcAuth", String.valueOf(saHeader.getUlIdSvcAuth()));
                         
    DocumentTemplateSI documentTemplateSI = new DocumentTemplateSI();
    documentTemplateSI.setDocument(ServiceAuthRef.FCM06O00V2_DOC_NAME);
    documentTemplateSI.setMajor(ServiceAuthRef.FCM06O00V2_MAJOR);
    documentTemplateSI.setMinor(ServiceAuthRef.FCM06O00V2_MINOR);
    documentTemplateSI.setRevision(ServiceAuthRef.FCM06O00V2_REVISION);
    
    return documentTemplateSI;
  }
  
  /**
   * This method saves form data to specified narrative table per the template input.
   * It mimics the action save by user on online application supplied by the form architecture. 
   * The method saves the form by manually 
   *  - creating the documentMetaData from the xml
   *  - calling the preFill service
   *  - calling the documentSave method to save blob to narrative table
   * @param context
   * @param documentTemplateSI
   * @throws Exception
   * @throws ServiceException
   * @throws IOException
   */
  private void saveDocument(GrndsExchangeContext context, DocumentTemplateSI documentTemplateSI) throws Exception, ServiceException, IOException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    Integer currentTemplate = common.retrieveDocumentTemplate(documentTemplateSI);
    String docType = (String) request.getAttribute("docType");
    String docMetaDataString = DocumentLookup.lookup(docType.toUpperCase());
    StringReader stringReader = new StringReader(docMetaDataString);
    DocumentMetaData documentMetaData = null;
    try {
      //Unmarshall the Xml String into the DocumentMetaData object
      documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
      documentMetaData.setActualTemplateVersion(currentTemplate.intValue());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
      throw e;
    }
    // Fill in the rest of the documentMetaData from the request
    try {
      if (context.getRequest().getParameter("tableName") != null) {
        documentMetaData.getTableMetaData().setTableName(context.getRequest().getParameter("tableName"));
      }
      documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData,
                                                                         false);
      documentMetaData.setRenderFormat(RenderType.HTML_WITHOUT_SHELL);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in completeDocumentMetaData:" + e.getMessage());
      throw e;
    }
    String preFillData = null;
    try {
      GrndsTrace.msg(TRACE_TAG, 7, "Calling prefill service");
      preFillData = DocumentServiceHelper.returnPreFillData(documentServiceExecutor, request, documentMetaData);
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling Tuxedo:" + we.getMessage());
      String errorMessageString = null;

      // Get the errorMessages collection for the tux service
      ErrorMessages errorMessages = documentMetaData.getPreFillMetaData().getErrorMessages();

      // Loop thru the error messages until the constant is found.
      for (int x = 0; x < errorMessages.getErrorCount(); x++) {
        Error error = errorMessages.getError(x);
        GrndsTrace.msg(TRACE_TAG, 7, "Value of Error code:" + error.getErrorCode());
        // TODO: This used to only get displayed if error code and name were the same, which is very weird.
        errorMessageString = MessageLookup.getMessageByName(error.getDisplayMessage());
        if (errorMessageString.equals(we.getMessage())) {
          break;
        }
      }

      //  If the error code could not be found then perform the default behavior
      if (errorMessageString == null) {
        if (!"PROCESS_SEVERE_ERROR".equals(errorMessages.getDefault().getDisplayMessage())) {
          GrndsTrace.msg(TRACE_TAG, 7,
                         "Getting default error message:" + errorMessages.getDefault().getDisplayMessage());
          errorMessageString = MessageLookup.getMessageByName(errorMessages.getDefault().getDisplayMessage());
        } else {
          throw we;
        }
      }

      //If there was an error message show the exception page. 
      if (errorMessageString != null) {
        throw new Exception(errorMessageString);
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception getting prefill data:" + e.getMessage());
      throw e;
    }
    
    StringWriter stringWriter = new StringWriter();
    try {
      Marshaller.marshal(documentMetaData, stringWriter);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
      throw e;
    }

    docMetaDataString = stringWriter.toString();          
    
    try {
       preFillData = DocumentBuilderHelper.TAG_DEF_START + DocumentBuilderHelper.TAG_DATA_OPEN + preFillData + DocumentBuilderHelper.TAG_DATA_CLOSE;
        documentSave.saveDocument(documentMetaData, (CompressionHelper.compressData(preFillData.getBytes())).toByteArray());

    } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception getting prefill data:" + e.getMessage());
        throw e;
    }
  }

  /**
   * This method saves the approval data, contained mostly in state, after the user clicks save.
   * 
   * @param context
   *          The current <tt>GrndsExchangeContext</tt> object
   * @return
   */
  private boolean callCCMN35S(GrndsExchangeContext context, SaveApproval saveApproval) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    UserProfile user = UserProfileHelper.getUserProfile(request);

    // Get the approval information
    CCMN34SO ccmn34so = (CCMN34SO) state.getAttribute(CCMN34SO_KEY, request);

    // set bindDesigneeAprvl to true IFF the approver was not the person to whom
    // the approval was assigned
    boolean bIndDesigneeAprvl = state.getAttribute(DESIGNEE_APRVL_KEY, request) != null ? true : false;

    // Used to set ccmn35si appropriately depending on what actions were taken
    String winResult = (String) state.getAttribute(WIN_RESULT_KEY, request);

    // Get the index of the record that was approved or rejected
    int index = Integer.parseInt((String) state.getAttribute(APPROVAL_INDEX_KEY, request));

    // Get the row that is associated with the index
    ROWCCMN56DO rowccmn56do = ccmn34so.getROWCCMN56DO_ARRAY().getROWCCMN56DO(index);

    // Get the approval rejection reason row out of state
    ROWCCMNI2DI rowccmni2di = (ROWCCMNI2DI) state.getAttribute(ROWCCMNI2DI_KEY, request);

    // populate the input struct
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    archInputStruct.setSzUserId(user.getUserLogonID());

    // populate sub-structures
    gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg aprvlStageProg = populateAprvlStageProg(ccmn34so);
    ROWCCMN61DI rowccmn61di = populateROWCCMN61DI(rowccmn56do);
    ROWCCMN01UIG00 rowccmn01uig00 = populateROWCCMN01UIG00(ccmn34so, winResult);

    // populate ccmn35si using the structures above and ccmn34so
    CCMN35SI ccmn35si = new CCMN35SI();
    ccmn35si.setArchInputStruct(archInputStruct);
    ccmn35si.setAprvlStageProg(aprvlStageProg);
    ccmn35si.setROWCCMN61DI(rowccmn61di);
    ccmn35si.setROWCCMN01UIG00(rowccmn01uig00);
    ccmn35si.setROWCCMNI2DI(rowccmni2di);
    ccmn35si.setLdIdTodo(rowccmn56do.getLdIdTodo());
    ccmn35si.setUlIdApproval(ccmn34so.getUlIdApproval());
    ccmn35si.setUlIdPerson(ccmn34so.getUlIdPerson());
    ccmn35si.setUlIdStage(ccmn34so.getUlIdStage());
    ccmn35si.setUlIdCase(ccmn34so.getUlIdCase());
    ccmn35si.setSzCdStage(ccmn34so.getSzCdStage());
    ccmn35si.setBIndDesigneeAprvl(bIndDesigneeAprvl ? ArchitectureConstants.Y : ArchitectureConstants.N);
    ccmn35si.setSzWcdCdAprvlWinaction(winResult);
    ccmn35si.setUlIdCntrctWkr(user.getUserID());
    ccmn35si.setSzCdAttrRegSsStf(SEC_REGIONAL_SS_STF);
    // SIR: 19057 Hari Maralla, Populate SzCdTask, so that it can be saved into todo tables using ccmn43d
    ccmn35si.setSzCdTask(GlobalData.getSzCdTask(request));
    //STGAP00010749: Set the Adoption Finalized indicator into the object if Adoption is finalized
    if(ArchitectureConstants.Y.equals(ccmn34so.getBIndAdoptionFinalized())){
      ccmn35si.setBIndAdoptionFinalized(ArchitectureConstants.Y);
    }
    // Set which Special Investigation Approver
    ccmn35si.setSzWhichSpclInvApprover(ccmn34so.getSzWhichSpclInvApprover());
    // Set which Safety Resource Approver
    ccmn35si.setSzWhichSafetyRsrcApprover(ccmn34so.getSzWhichSafetyRsrcApprover());
    
    // Add IdEvent so that it can be used for ClientOutbound table persistance.
    ccmn35si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    // if the save is being called via the approval status form being generated,
    // we need to set the rejection reason row back into the request
    // fordisplay when the page reloads.
    request.setAttribute(ROWCCMNI2DI_KEY, rowccmni2di);
    // END SIR 23334 POPULATE

    // Use success to track the outcome of the service call and return whether
    // or not it succeeded
    boolean success = false;
    try {
      CCMN35SO ccmn35so = saveApproval.saveApproval(ccmn35si);
      state.setAttribute(SAVED_KEY, Boolean.TRUE, request);
      if (ArchitectureConstants.N.equals(ccmn35so.getBAssignPageForward())) {

        state.setAttribute(INTAKE_ACTIONS_PREVIOUS_URI, Boolean.FALSE, request);
      }
      success = true;
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      // switch the response based on the Service Returned Error Code
      switch (errorCode) {
      case Messages.MSG_CHILD_DOB_REQUIRED:
        setErrorMessage(errorCode, request);
        break;
      case Messages.MSG_SVA_OPN_AUTHS:
        // RIOSJA, SIR 19973 - This means that the stage being closed has open
        // service auths that need to be progressed to an open stage, but an
        // eligible open stage was not found.
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SVA_OPN_AUTHS), request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        // This means that the ldIdTodo or the ulIdEvent does not exist, most
        // likely because another user has already approved the same To-Do by
        // acting as the user to which it was assigned.
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH), request);
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        break;
      case Messages.SQL_NOT_FOUND:
        // This means that there is no current Adoptive placement record and the user is trying to close an
        // ADO stage with Adoption Finalized as reason closed or the person record for the Primary child in the ADO
        // stage is not found 
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.SQL_NOT_FOUND), request);
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        break;
        //SMS#54782
      case Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE:
        setErrorMessage(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE, request);
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        break;
      case Messages.MSG_FAD_INVAL_CLOSE_DT:
        // This means that the user is setting a closure date that is before the home was even verified. 
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_FAD_INVAL_CLOSE_DT), request);
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        break;
        // SMS#54782 
      case Messages.MSG_CNS_REQD_IF_DOD:
        setErrorMessage(errorCode, request);
        break;
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + ve.getMessage());
      processSevereException(context, ve);
    }

    return success;
  }

  /**
   * Populates an input ApprvlStageProg object for save with values from the output of ccmn34so.
   * 
   * @param ccmn34so
   *          Returned by CCMN34S
   * @return
   */
  private gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg populateAprvlStageProg(CCMN34SO ccmn34so) {
    gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg input = new gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg();
    gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg output = ccmn34so.getAprvlStageProg();
    input.setCWCDCdStageProgressMode(output.getCWCDCdStageProgressMode());
    input.setSzCdStageOpen(output.getSzCdStageOpen());
    input.setSzCdStageProgram(output.getSzCdStageProgram());
    input.setSzCdStageReasonClosed(output.getSzCdStageReasonClosed());
    return input;
  }

  /**
   * Populates a ROWCCMN61DI object for save with data from the approval that was actually approved or rejected.
   * 
   * @param rowccmn56do
   *          The data for the approval that was modified.
   * @return
   */
  private ROWCCMN61DI populateROWCCMN61DI(ROWCCMN56DO rowccmn56do) {
    ROWCCMN61DI rowccmn61di = new ROWCCMN61DI();
    rowccmn61di.setDtDtApproversDetermination(rowccmn56do.getDtDtApproversDetermination());
    rowccmn61di.setTmScrTmApprovalTime(rowccmn56do.getTmScrTmApprovalTime());
    rowccmn61di.setUlIdPerson(rowccmn56do.getUlIdPerson());
    rowccmn61di.setSzCdApproversStatus(rowccmn56do.getSzCdApproversStatus());
    rowccmn61di.setSzTxtApproversComments(rowccmn56do.getSzTxtApproversComments());
    rowccmn61di.setUlIdApprovers(rowccmn56do.getUlIdApprovers());
    rowccmn61di.setTsLastUpdate(rowccmn56do.getTsLastUpdate());
    return rowccmn61di;
  }

  /**
   * Populates a ROWCCMN01UIG00 object for save, which seems to be used to update the event information associated with
   * the approval.
   * 
   * @param ccmn34so
   *          Returned by CCMN34S
   * @param winResult
   *          Indicates whether or not the event status should change based on whether or not there are more pending
   *          approvals.
   * @return
   */
  private ROWCCMN01UIG00 populateROWCCMN01UIG00(CCMN34SO ccmn34so, String winResult) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN45DO rowccmn45do = ccmn34so.getROWCCMN45DO();
    rowccmn01uig00.setSzCdTask(rowccmn45do.getSzCdTask());
    rowccmn01uig00.setTsLastUpdate(rowccmn45do.getTsLastUpdate());
    String cdEventStatus = APPROVALS_COMPLETE.equals(winResult) || REJECTED.equals(winResult) ?
                           CodesTables.CEVTSTAT_COMP : CodesTables.CEVTSTAT_PROC;
    rowccmn01uig00.setSzCdEventStatus(cdEventStatus);
    rowccmn01uig00.setSzCdEventType(rowccmn45do.getSzCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(rowccmn45do.getDtDtEventOccurred());
    rowccmn01uig00.setUlIdEvent(rowccmn45do.getUlIdEvent());
    rowccmn01uig00.setUlIdStage(rowccmn45do.getUlIdStage());
    rowccmn01uig00.setUlIdPerson(rowccmn45do.getUlIdPerson());
    rowccmn01uig00.setSzTxtEventDescr(rowccmn45do.getSzTxtEventDescr());
    return rowccmn01uig00;
  }

  /**
   * Parses the time that is returned in a ROWCCMN56DO into a time string and AM/PM for use in the validateTime control.
   * 
   * @param time
   *          The time string that is returned from the getTmScrTmApprovalTime() method on a ROWCCMN56DO instance.
   * @return A String array representing the time (element 0) and am/pm (element 1).
   */
  public static String[] parseTime(String time) {
    String[] returnTime = new String[2];
    if (time != null) {
      time = time.trim(); // to strip off any extra spaces
      int spaceIndex = time.lastIndexOf(' '); // finds the space before the AM/PM
      if (spaceIndex >= 0) // make sure that we don't throw a bounds exception
      {
        returnTime[0] = time.substring(0, spaceIndex);
        int timeLength = time.length();
        returnTime[1] = timeLength > spaceIndex + 1 ? time.substring(spaceIndex + 1, timeLength) : "";
      }
    }
    return returnTime;
  }
  
  public void setPerson(Person person) {
    this.person = person;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void setDocumentServiceExecutor(DocumentServiceExecutor documentServiceExecutor) {
    this.documentServiceExecutor = documentServiceExecutor;
  }

  public static final String TRACE_TAG = "ApprovalStatusConversation";

  private static final int NO_INVALID_OR_REJECTED_FOUND = 0;

  private static final int REJECTED_FOUND = 1;

  private static final int INVALID_FOUND = 2;

  public static final int NUMLBAPPROVERSROWS = 50;

  public static final String STATUS_PENDING = "PEND";

  public static final String STATUS_INVALID = "INVD";

  public static final String STATUS_APPROVED = "APRV";

  public static final String STATUS_REJECTED = "REJT";

  public static final String REJECTED = "REJ"; // Rejection Made on Window

  public static final String APPROVALS_COMPLETE = "COM"; // Approval Made and Lockout will Occur

  public static final String APPROVED = "APR"; // Approval Made other Pending Approvers

  public static final String INVALID = "INV"; // No action allowed Invalidated Approval

  // Only SP_AUTOMATIC is used in the following four constants, but they are all
  // present because they are all defined in the caps approval status window
  // (ccmn65w.win)
  public static final String SP_NOT_APPL = "N";

  public static final String SP_MANUAL = "W";

  public static final String SP_AUTOMATIC = "P";

  public static final String SP_CASECLOSE = "C";

  public static final String TODO_DETAIL_BRANCH = "tododetail";

  public static final String WIN_RESULT_KEY = TRACE_TAG + ".WIN_RESULT_KEY";

  public static final String SAVED_KEY = TRACE_TAG + ".SAVED_KEY";

  public static final String DISPLAY_DOCUMENT_KEY = TRACE_TAG + ".DISPLAY_DOCUMENT_KEY";

  public static final String APPROVAL_INDEX_KEY = TRACE_TAG + ".APPROVAL_INDEX_KEY";

  public static final String CCMN34SO_KEY = TRACE_TAG + ".CCMN34SO";

  public static final String ROWCCMNI2DI_KEY = TRACE_TAG + ".ROWCCMNI2DI";

  public static final String DESIGNEE_APRVL_KEY = TRACE_TAG + ".DESIGNEE_APRVL_KEY";

  public static final String BOOL_DISPLAY_REJ_KEY = "BOOL_DISPLAY_REJ_KEY";

  public static final String DISPLAY_URI = "/workload/ApprovalStatus/displayStatus";

  public static String PREVIOUS_URI_PARAM_NAME = "hdnPreviousURI";

  public static String PREVIOUS_URI_INTAKE_ACTION = "/intake/IntakeActions/displayIntakeActions";

  public static String INTAKE_ACTIONS_PREVIOUS_URI = "INTAKE_ACTIONS_PREVIOUS_URI";

  private Admin admin;
  
  private Common common = null;
  
  private Person person = null;
  
  private DocumentSave documentSave = null;
  
  private DocumentServiceExecutor documentServiceExecutor = null;

}
