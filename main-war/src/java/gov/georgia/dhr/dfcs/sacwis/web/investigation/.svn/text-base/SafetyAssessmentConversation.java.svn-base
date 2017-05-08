package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.Assessment;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DrugExposedNewBornSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ReasonableEffortsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyFactorsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DrugExposedNewBornRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ReasonableEffortsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to manipulate the data needed to capture caretaker and child relationships in the
 * household. <p/> <p/> <p/>
 * 
 * <pre>
 *                Change History:
 *                Date        User       Description
 *                ----------  ---------- --------------------------------------------------
 *                07/10/2008   cwells    STGAP00006745: Added submitApproval_xa so when the approval status button
 *                                       is pressed it saves the changes and then navigates the user 
 *                                       to the approval status page upon successful save
 *                                      
 *                07/24/2008   arege     STGAP00006746 Modified  populateSafetyAssessmentFromRequest()
 *                                       set Event Status to 'PEND' if in approvalMode. This passes the correct
 *                                       event status to the SaveSafetyAssessmentImpl Service.
 *                                      
 *                07/31/2008  alwilliams STGAP00009307: Updated the reasonable efforts check-list process to
 *                                       account for principal children (under 18) that were added to the Person List 
 *                                       List after the assessment was saved. A new method updateSavedReasonableEffortsRetrieveSO
 *                                       was added to create an updated Reasonable Effort that includes the new children. 
 *                                       The new method is called when displaying a saved assessment whose event status  
 *                                       is not PEND or APRV.  
 *                                                        
 *                09/02/2008  alwilliams STGAP00009307: Updated to only call the new method when displaying a saved assessment 
 *                                       whose event status is not APRV. This is a deviation from the original solution of the
 *                                       defect but System Testing showed that it is necessary to check for APRV only.                                                           
 *  
 *  
 *                09/23/2008 alwilliams  STGAP00009307: Updated the safety factors check-list process to account for
 *                                       principal children (under 18) and principal care takers that were added to 
 *                                       the Person List after the assessment was saved. Updates were integrated in to the
 *                                       initilizeSafetyFactors method. Also populateSafetyFactorRetrieveSO is now
 *                                       called when displaying a saved assessment whose event status is not APRV. 
 *
 *                                       The updatedSaveReasonableEffortsRetreieveSO method was deleted and replaced with 
 *                                       the initializeReasonableEfforts method. The populateReasonableEffortsRetrieveSO method
 *                                       was reworked to use the initializeResonableEfforts method. Also populateReasonableEffortsRetrieveSO 
 *                                       is now called when displaying a saved assessment whose event status is not APRV. 
 *                                       
 *                10/31/2008   arege     STGAP00010758 Modified  save(), changed condition for calling invalidateApproval.
 *                                                                              
 *                5/4/2009     cwells    STGAP00013413 If the page has been saved already then we should not 
 *                                       update the entered by field or the Date Event Occurred field on the 
 *                                       event status page.    
 *                10/11/2011   arege     STGAP00007729: If the person is marked as Caretaker on the person list then insert the row into Caretaker 
 *                                       list even if the person is under 18.                 
 * </pre>
 * 
 * @author Modeste Ngom, September 09, 2006
 */

@SuppressWarnings("serial")
public class SafetyAssessmentConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "SafetyAssessmentConversation";

  public static final String DISPLAY_PAGE = "/investigation/SafetyAssessment/displaySafetyAssessment";

  public static final String SAFETY_FACTORS_CODES_TABLES = "CSFFAC";

  public static final String DRUG_EXPOSED_NEW_BORNS = "CDRGEXNB";

  public static final String REASONABLE_EFFORTS = "CRSNEFFT";

  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_DESC_SA = "Safety Assessment";

  public static final String SUBMIT = "submit";

  public static final String SAVE = "save";

  public static final String SAFETY_ASSESSMENT_TASK = "2285";
  
  public static final String APPROVE_SAFETY_ASSESSMENT = "2286";

  public static final String SA_EVENT_TYPE = CodesTables.CEVNTTYP_ASM;

  public static final String OTHER_QUESTION = "OTH";

  public static final String CASE_TODO_PAGE = "/workload/ToDo/displayCaseToDo";

  public static final String STAFF_TODO_PAGE = "/workload/ToDo/displayStaffToDo";
  
  private static final String SAFETY_ASSESSMENT_TASK_ONG = "7340";
  
  private static final String APPROVE_SAFETY_ASSESSMENT_ONG = "7345";
  
  private static final Map<String, String> TASK_CODE_MAP = new HashMap<String, String>() {
    {
      put(SAFETY_ASSESSMENT_TASK, APPROVE_SAFETY_ASSESSMENT);
      put(SAFETY_ASSESSMENT_TASK_ONG, APPROVE_SAFETY_ASSESSMENT_ONG);
    }
  };

  /** Create a private field for each service EJB used. */
  private Assessment assessment = null;

  private Common common;

  private Admin admin;

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * Create a public setter for each service EJB used.
   * 
   * @param resource
   */
  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
  }

  /**
   * This method will retrieve data from SafetyAssessmentRetrieveSO to display the page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  /**
   * This method displays the safety assessment. The safety assessment includes the safety factors, 
   * reasonable efforts and safety decision.
   * 
   * STGAP00008071 - Call new method populateSavedReasonableEffortsRetrieveSO to populate the 
   * reasonable efforts if the assessment event status is not PEND (pending) or APRV (approved).
   * 
   * @param context
   */
  public void displaySafetyAssessment_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayLegalStatus_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    // BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // event list sets page mode
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);

      SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO = new SafetyAssessmentRetrieveSO();
      // clear state
      if (state.getAttribute("SafetyAssessmentRetrieveSO", request) == null) {
        state.removeAllAttributes(request);
      }
      PageMode.setPageMode(pageMode, request);

      // call retrieve Principal service
      CINV36SO cinv36so = new CINV36SO();
      CINV36SI cinv36si = populateCINV36SI_Retrieve(context);

      cinv36so = assessment.retrievePrincipals(cinv36si);

      // if this is a new assessment with no idEvent
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {

        // construct Caretaker and Child Collections and populate SafetyAssessmentRetrieveSO.
        safetyAssessmentRetrieveSO = populateCaretakerAndChildrenCollections(cinv36so, safetyAssessmentRetrieveSO);
        populateSafetyFactorsRetrieveSO(context, safetyAssessmentRetrieveSO, SAFETY_FACTORS_CODES_TABLES);
        populateDrugExposedNewBornRetrieveSO(context, safetyAssessmentRetrieveSO, DRUG_EXPOSED_NEW_BORNS);
        populateReasonableEffortsRetrieveSO(context, safetyAssessmentRetrieveSO, REASONABLE_EFFORTS);

        safetyAssessmentRetrieveSO.setszTxtPageStatus(StringHelper.EMPTY_STRING);
        safetyAssessmentRetrieveSO.setSzTxtOverallSafetyDecision(StringHelper.EMPTY_STRING);
        safetyAssessmentRetrieveSO
                                  .setIsDrugExposedNewBorn(assessment
                                                                     .isDrugExposedNewborn(GlobalData
                                                                                                     .getUlIdStage(request)));

      } else {
        // call retrieve service
        SafetyAssessmentRetrieveSI safetyAssessmentRetrieveSI = populateSafetyAssessmentRetrieveSI_Retrieve(context);
        safetyAssessmentRetrieveSO = assessment.retrieveSafetyAssessment(safetyAssessmentRetrieveSI);
        safetyAssessmentRetrieveSO = populateCaretakerAndChildrenCollections(cinv36so, safetyAssessmentRetrieveSO);

        // STGAP00009548 - Get event status
        String eventStatus= null;
        if (safetyAssessmentRetrieveSO != null &&  safetyAssessmentRetrieveSO.getROWCCMN45DO()!= null)
        {  
          eventStatus= safetyAssessmentRetrieveSO.getROWCCMN45DO().getSzCdEventStatus();
        }
        
        // if safety factors section is empty, give it the default view
        if (safetyAssessmentRetrieveSO.getSafetyFactors() == null
            || safetyAssessmentRetrieveSO.getSafetyFactors().isEmpty()) {
          populateSafetyFactorsRetrieveSO(context, safetyAssessmentRetrieveSO, SAFETY_FACTORS_CODES_TABLES);
        } else {
          // STGAP000009307: If the assessment is not Approved (APRV), then populate the saved safety factors  
          // object with the default safety factors information for any new principal children and care taker. 
          if (!EVENT_STATUS_APPROVED.equals(eventStatus ))           
            //populateSavedSafetyFactorsRetrieveSO(context, safetyAssessmentRetrieveSO, SAFETY_FACTORS_CODES_TABLES);
          populateSafetyFactorsRetrieveSO(context, safetyAssessmentRetrieveSO, SAFETY_FACTORS_CODES_TABLES);
        }

        // if reasonable efforts section is empty, give it the default view
        if (safetyAssessmentRetrieveSO.getReasonableEfforts() == null
            || safetyAssessmentRetrieveSO.getReasonableEfforts().isEmpty()) {
          populateReasonableEffortsRetrieveSO(context, safetyAssessmentRetrieveSO, REASONABLE_EFFORTS);
        } else {
          // STGAP000009307: If the assessment is not Approved (APRV), then populate the save reasonable effort  
          // object with the default reasonable efforts information for any new principal children. 
          if (!EVENT_STATUS_APPROVED.equals(eventStatus ))           
            populateReasonableEffortsRetrieveSO(context, safetyAssessmentRetrieveSO, REASONABLE_EFFORTS);
        }

        // if drug exposed newborns section is empty, give it the default view
        if (safetyAssessmentRetrieveSO.getDrugExposedNewborn() == null
            || safetyAssessmentRetrieveSO.getDrugExposedNewborn().isEmpty()) {
          populateDrugExposedNewBornRetrieveSO(context, safetyAssessmentRetrieveSO, DRUG_EXPOSED_NEW_BORNS);
        }

        // If the Safety Assessment event is pending approval and the user
        // did not access the page in approval mode, warn them that the pending
        // closure will be invalidated if they save any changes.
        boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
        if (EVENT_STATUS_PEND.equals(eventStatus) && !globalEvtStatusIsApproval
            && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
          setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }
      setInformationalMessage(Messages.VICTIM_DOB_WARNING, request);
      state.setAttribute("SafetyAssessmentRetrieveSO", safetyAssessmentRetrieveSO, request);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  public void submitApproval_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "submitApproval_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    
    try {
      int eventId = save(context, SAVE);
      GlobalData.setUlIdEvent(eventId, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  
  
  public void saveSafetyAssessment_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveSafetyAssessment_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    
    try {
      int eventId = save(context, SAVE);
      GlobalData.setUlIdEvent(eventId, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  public void deleteSafetyAssessment_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteSafetyAssessment_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    
    try {
      SafetyAssessmentDeleteSI deleteSI = populateDeleteSIFromRequest(request);
      assessment.deleteSafetyAssessment(deleteSI);
      
      // Reset Event ID after deletion
      GlobalData.setUlIdEvent(0, request);
    } catch (ServiceException we) {
      handleError(we, context);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {
      //This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  private SafetyAssessmentDeleteSI populateDeleteSIFromRequest(HttpServletRequest request) {
    SafetyAssessmentDeleteSI deleteSI = new SafetyAssessmentDeleteSI();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    deleteSI.setUIdPerson(user.getUserID());
    deleteSI.setIdStage(GlobalData.getUlIdStage(request));
    deleteSI.setCdStage(GlobalData.getSzCdStage(request));
    deleteSI.setEventReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    deleteSI.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
    deleteSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    ROWCCMN01UIG00 safetyAssessmentEvent = new ROWCCMN01UIG00();
    safetyAssessmentEvent.setUlIdEvent(GlobalData.getUlIdEvent(request));
    safetyAssessmentEvent.setTsLastUpdate(deleteSI.getDtLastUpdate());
    deleteSI.setROWCCMN01UIG00(safetyAssessmentEvent);

    return deleteSI;
  }

  public void saveAndSubmitSafetyAssessment_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveAndSubmitSafetyAssessment_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      int eventId = save(context, SUBMIT);
      GlobalData.setUlIdEvent(eventId, request);

      int ulIdEvent = GlobalData.getUlIdEvent(request);
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = GlobalData.getUlIdStage(request);
      String approvalCdTask = APPROVE_SAFETY_ASSESSMENT;
      //-- STGAP00005607 -----------------------------
      String cdTask = GlobalData.getSzCdTask(request);
      if(TASK_CODE_MAP.containsKey(cdTask)) {
        approvalCdTask = TASK_CODE_MAP.get(cdTask);
      }
      //----------------------------------------------
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, approvalCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    } catch (ServiceException we) {
      handleError(we, context);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {
      //This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  private int save(GrndsExchangeContext context, String method) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, SAVE);
    performanceTrace.enterScope();

    // Get the event Status for Invalidate Approval
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO = (SafetyAssessmentRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "SafetyAssessmentRetrieveSO",
                                                                                                            request);
    ROWCCMN45DO row = safetyAssessmentRetrieveSO.getROWCCMN45DO();
    String eventStatus = StringHelper.EMPTY_STRING;
    if (row != null) {
      eventStatus = row.getSzCdEventStatus();
    }

    SafetyAssessmentSaveSI safetyAssessment = new SafetyAssessmentSaveSI();
    safetyAssessment = populateSafetyAssessmentFromRequest(context, safetyAssessment, method);

    //Passing the original object and the one on the screen to compare and update only if the row has changed
    int eventId = assessment.saveSafetyAssessment(safetyAssessmentRetrieveSO,safetyAssessment );

    // Invalidate Approval

    // if (eventId != 0 && CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))
    // && EVENT_STATUS_PEND.equals(eventStatus) && !isCurrentActiveApprover(context) && hasStageAccessRights(context)) {

    // STGAP00007567 removed Condition CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))
    // STGAP00010758 The Todo was not being deleted when the currentActiveApprover was invalidating his own ToDo.
    // Todo will also be invalidated when supervisor uses "SaveandSubmit" in Approval mode.
    // Commented out the following condition and added new condition.
    // if (eventId != 0 && EVENT_STATUS_PEND.equals(eventStatus)&& !isCurrentActiveApprover(context)&&
    // hasStageAccessRights(context)) {
    boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
    if (eventId != 0 && EVENT_STATUS_PEND.equals(eventStatus) && !globalEvtStatusIsApproval
        && hasStageAccessRights(context)) {
      CCMN05UI ccmn05ui = new CCMN05UI();
      ccmn05ui.setUlIdEvent(eventId);
      ArchInputStruct ais = new ArchInputStruct();
      ais.setUlSysNbrReserved1(ArchitectureConstants.N);
      ccmn05ui.setArchInputStruct(ais);
      try {
        admin.invalidateApproval(ccmn05ui);
      } catch (ServiceException se) {
        handleError(se, context);
      }
    }
  
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return eventId;
  }

  /*
   * determines whether the user has access rights to modify the stage
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  /*
   * Determines whether user login in is a supervisor
   */
  private boolean isCurrentActiveApprover(GrndsExchangeContext context) {
    boolean result = false;

    HttpServletRequest request = context.getRequest();
    int eventId = GlobalData.getUlIdEvent(request);
    if (eventId != 0) {
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      int loggedInUserId = userProfile.getUserID();
      int approverId = -1;

      ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
      ApproversRetrieveSO so = common.retrieveApprovers(si);
      if (so.hasCurrentActiveApprover()) {
        approverId = so.getCurrentActiveApprover().getIdPerson();
      }

      // -- return true if user is approver
      if (loggedInUserId == approverId) {
        result = true;
      }
    }

    return result;
  }

  private SafetyAssessmentSaveSI populateSafetyAssessmentFromRequest(GrndsExchangeContext context,
                                                                     SafetyAssessmentSaveSI safetyAssessment,
                                                                     String method) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateSafetyAssessmentFromRequest");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
    Date lastUpdate = ContextHelper.getJavaDateSafe(request, "saTsLastUpdate");

    SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO = (SafetyAssessmentRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "SafetyAssessmentRetrieveSO",
                                                                                                            request);
    Collection<SaPerson> childrenList = safetyAssessmentRetrieveSO.getPrincipalChildren();
    Collection<SaPerson> caretakerList = safetyAssessmentRetrieveSO.getPrincipalCaretakers();

    try {
      // safety assessment event
      ROWCCMN01UIG00 safetyAssessmentEvent = new ROWCCMN01UIG00();
      if (SUBMIT.equals(method)) {
        safetyAssessmentEvent.setSzCdEventStatus(EVENT_STATUS_PEND);
        safetyAssessmentEvent.setSzCdEventType(SA_EVENT_TYPE);
        safetyAssessmentEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        safetyAssessmentEvent.setUlIdStage(GlobalData.getUlIdStage(request));
        safetyAssessmentEvent.setUlIdPerson(user.getUserID());
        safetyAssessmentEvent.setSzTxtEventDescr(EVENT_DESC_SA);
        safetyAssessmentEvent.setSzCdTask(GlobalData.getSzCdTask(request));
        safetyAssessmentEvent.setUlIdEvent(idEvent);
        safetyAssessmentEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
      } else {
        safetyAssessmentEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
        safetyAssessmentEvent.setSzCdEventType(SA_EVENT_TYPE);
        safetyAssessmentEvent.setUlIdStage(GlobalData.getUlIdStage(request));
       // STGAP00013413: If the page has been saved already then we should not 
       // update the entered by field or the Date Event Occurred field on the 
       // event status page.  
        if(idEvent == 0){
        safetyAssessmentEvent.setUlIdPerson(user.getUserID());
        safetyAssessmentEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        }
        safetyAssessmentEvent.setSzTxtEventDescr(EVENT_DESC_SA);
        safetyAssessmentEvent.setSzCdTask(GlobalData.getSzCdTask(request));
        safetyAssessmentEvent.setUlIdEvent(idEvent);
        safetyAssessmentEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
      }      
      // STGAP00006746 If approvalmode, set the Status to 'PEND'
      if (globalEvtStatusIsApproval) {
        safetyAssessmentEvent.setSzCdEventStatus(EVENT_STATUS_PEND);
      }

      safetyAssessment.setROWCCMN01UIG00(safetyAssessmentEvent);

      // populate SafetyFactor responses
      Collection<String> codesSF = Lookup.getCategoryCodesCollection(SAFETY_FACTORS_CODES_TABLES);
      Map<String, Collection<SafetyFactorsSaveSI>> mapSaveSF = new HashMap<String, Collection<SafetyFactorsSaveSI>>();
      Iterator<String> iteratorCodesSF = codesSF.iterator();
      // loop through each code
      while (iteratorCodesSF.hasNext()) {
        String code = iteratorCodesSF.next();
        Collection<SafetyFactorsSaveSI> collSaveSF = populateSafetyFactorsSaveSI(request, idEvent, code, caretakerList,
                                                                                 childrenList);
        mapSaveSF.put(code, collSaveSF);
      }

      Collection<SafetyFactorsSaveSI> collSaveSF = populateSafetyFactorsSaveSI(request, idEvent, OTHER_QUESTION,
                                                                               caretakerList, childrenList);
      mapSaveSF.put(OTHER_QUESTION, collSaveSF);

      safetyAssessment.setSafetyFactors(mapSaveSF);

      // populate Drug Exposed New Borns
      Collection<String> codesDE = Lookup.getCategoryCodesCollection(DRUG_EXPOSED_NEW_BORNS);
      Collection<DrugExposedNewBornSaveSI> collSaveDE = new ArrayList<DrugExposedNewBornSaveSI>();
      Iterator iteratorCodesDE = codesDE.iterator();
      while (iteratorCodesDE.hasNext()) {
        String code = (String) iteratorCodesDE.next();
        DrugExposedNewBornSaveSI dEN = new DrugExposedNewBornSaveSI();
        String rbFieldName = "rb" + code;
        String rbFieldNameValue = ContextHelper.getStringSafe(request, rbFieldName);
        String idDENFieldName = "id" + code;
        int idFieldNameValue = ContextHelper.getIntSafe(request, idDENFieldName);
        String dtFieldName = "dt" + code;
        Date dtLastUpdate = ContextHelper.getJavaDateSafe(request, dtFieldName);

        dEN.setSzCdDrugExpNb(code);
        dEN.setSzCdDrugExpNbRps(rbFieldNameValue);
        dEN.setIdDrugExposedNewborn(idFieldNameValue);
        dEN.setUlIdEvent(idEvent);
        dEN.setDtLastUpdate(dtLastUpdate);

        collSaveDE.add(dEN);
      }
      safetyAssessment.setDrugExposedNewborn(collSaveDE);
      if (collSaveDE.size() > 0) {
        safetyAssessment.setDrugExposedNewBornExist(true);
      }

      // populate Reasonable Efforts
      Collection<String> codesRE = Lookup.getCategoryCodesCollection(REASONABLE_EFFORTS);
      Map<String, Collection<ReasonableEffortsSaveSI>> mapSaveRE = new TreeMap<String, Collection<ReasonableEffortsSaveSI>>();
      Iterator<String> iteratorCodesRE = codesRE.iterator();

      while (iteratorCodesRE.hasNext()) {
        String code = iteratorCodesRE.next();
        Collection<ReasonableEffortsSaveSI> collSaveRE = new ArrayList<ReasonableEffortsSaveSI>();
        Iterator<SaPerson> iteratorChildren = childrenList.iterator();

        while (iteratorChildren.hasNext()) {
          int idChild = iteratorChildren.next().getIdPerson();
          ReasonableEffortsSaveSI reasonableEfforts = new ReasonableEffortsSaveSI();

          String rbFieldName = "rb" + code + "_" + idChild;
          String rbFieldNameValue = ContextHelper.getStringSafe(request, rbFieldName);
          String txtFieldNameRE = "txt" + code + "_" + idChild;
          String txtFieldNameValue = ContextHelper.getStringSafe(request, txtFieldNameRE);
          String idFieldName = "id" + code + "_" + idChild;
          int idFieldNameValue = ContextHelper.getIntSafe(request, idFieldName);
          String dtFieldName = "dt" + code + "_" + idChild;
          Date dtLastUpdate = ContextHelper.getJavaDateSafe(request, dtFieldName);

          reasonableEfforts.setszCdReasonableEffortsResponse(rbFieldNameValue);
          reasonableEfforts.setSzTxtComments(txtFieldNameValue);
          reasonableEfforts.setIdChild(idChild);
          reasonableEfforts.setSzCdReasonableEfforts(code);
          reasonableEfforts.setUlIdEvent(idEvent);
          reasonableEfforts.setUlIdReasonableEfforts(idFieldNameValue);
          reasonableEfforts.setDtDtLastUpdateDt(dtLastUpdate);

          collSaveRE.add(reasonableEfforts);
        }
        mapSaveRE.put(code, collSaveRE);
      }

      safetyAssessment.setReasonableEfforts(mapSaveRE);

      safetyAssessment.setSzTxtOverallSafetyDecision(ContextHelper.getStringSafe(request, "selOverallSafetyDecision"));
      safetyAssessment.setSzTxtAddtnlCommnts(ContextHelper.getStringSafe(request, "txtAddtnlCommnts"));
      safetyAssessment.setSzTxtWhyResponses(ContextHelper.getStringSafe(request, "txtResponse"));
      safetyAssessment.setIdPerson(user.getUserID());
      safetyAssessment.setIdCase(GlobalData.getUlIdCase(request));
      safetyAssessment.setIdStage(GlobalData.getUlIdStage(request));
      safetyAssessment.setUlIdEvent(idEvent);
      safetyAssessment.setSzTxtOtherSafetyFactor(ContextHelper.getStringSafe(request, "txtOtherSafetyFactor"));
      safetyAssessment.setDtLastUpdate(lastUpdate);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return safetyAssessment;
  }

  private Collection<SafetyFactorsSaveSI> populateSafetyFactorsSaveSI(HttpServletRequest request, int idEvent,
                                                                      String code, Collection<SaPerson> caretakerList,
                                                                      Collection<SaPerson> childrenList) {

    Collection<SafetyFactorsSaveSI> collSaveSF = new ArrayList<SafetyFactorsSaveSI>();
    Iterator<SaPerson> iteratorCaretakers = caretakerList.iterator();

    // for each code, loop through each caretaker
    while (iteratorCaretakers.hasNext()) {
      Iterator<SaPerson> iteratorChildren = childrenList.iterator();
      int idCaretaker = iteratorCaretakers.next().getIdPerson();

      // for each code and caretaker, loop through each child
      while (iteratorChildren.hasNext()) {
        int idChild = iteratorChildren.next().getIdPerson();

        SafetyFactorsSaveSI safetyFactor = new SafetyFactorsSaveSI();
        String rbFieldName = "rbSF" + code + "_" + idCaretaker + "_" + idChild;
        String rbFieldNameValue = ContextHelper.getStringSafe(request, rbFieldName);
        String idFieldName = "id" + code + "_" + idCaretaker + "_" + idChild;
        int idFieldNameValue = ContextHelper.getIntSafe(request, idFieldName);
        String dtFieldName = "dt" + code + "_" + idCaretaker + "_" + idChild;
        Date dtLastUpdate = ContextHelper.getJavaDateSafe(request, dtFieldName);

        safetyFactor.setIdCaretaker(idCaretaker);
        safetyFactor.setIdChild(idChild);
        safetyFactor.setSzCdSafetyFactor(code);
        safetyFactor.setUlIdEvent(idEvent);
        safetyFactor.setSzCdSafetyFactorResponse(rbFieldNameValue);
        safetyFactor.setUlIdSafetyFactor(idFieldNameValue);
        safetyFactor.setDtDtLastUpdateDt(dtLastUpdate);

        collSaveSF.add(safetyFactor);
      }
    }

    return collSaveSF;

  }

  /**
   * This method will populate SafetyAssessmentRetrieveSI.
   * 
   * @param context
   */

  private SafetyAssessmentRetrieveSI populateSafetyAssessmentRetrieveSI_Retrieve(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateSafetyAssessmentRetrieveSI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    SafetyAssessmentRetrieveSI safetyAssessmentRetrieveSI = new SafetyAssessmentRetrieveSI();
    safetyAssessmentRetrieveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    safetyAssessmentRetrieveSI.setUIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return safetyAssessmentRetrieveSI;
  }

  /**
   * This method will populate CINV01SI.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  private CINV36SI populateCINV36SI_Retrieve(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV36SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CINV36SI cinv36si = new CINV36SI();
    cinv36si.setUlIdStage(GlobalData.getUlIdStage(request));
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cinv36si;
  }

  /**
   * This method will Construct the Children and Caretaker Collections, then set those values into
   * SafetyAssessmentRetrieveSI
   * 
   * @param cinv01so
   */

  private SafetyAssessmentRetrieveSO populateCaretakerAndChildrenCollections(
                                                                             CINV36SO cinv36so,
                                                                             SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO) {

    ROWCINV36SOG01_ARRAY personArray = null;

    personArray = cinv36so.getROWCINV36SOG01_ARRAY();

    ArrayList<SaPerson> childrenList = new ArrayList<SaPerson>();
    ArrayList<SaPerson> caretakerList = new ArrayList<SaPerson>();

    if (personArray != null) {

      for (int i = 0; i < personArray.getUlRowQty(); i++) {

        // Evaluate the principal age. If the Age is less than 18
        // insert the row into Children List. Else insert the row into Caretaker List
        //STGAP00007729: If the person is marked as Caretaker on the person list then insert the row into Caretaker 
        //list even if the person is under 18
        ROWCINV36SOG01 row = personArray.getROWCINV36SOG01(i);
        Date birthDate = DateHelper.toJavaDate(row.getDtDtPersonBirth());
        SaPerson childOrCareTaker = new SaPerson();
        childOrCareTaker.setIdPerson(row.getUlIdPerson());
        childOrCareTaker.setNmPersonFull(row.getSzNmPersonFull());
        int age = -1;
        if (birthDate != null) {
          age = DateHelper.getAge(birthDate);
        }
        if(CodesTables.CRELVICT_PK.equals(row.getSzCdStagePersRelInt())){
          caretakerList.add(childOrCareTaker); 
        }else if (age >= 0 && age < 18) {
          childrenList.add(childOrCareTaker);
        } else if (age >= 18) {
          caretakerList.add(childOrCareTaker);
        }
      }
    }

    // Set the values of PrincipalChildren and PrincipalCaretakers
    safetyAssessmentRetrieveSO.setPrincipalChildren(childrenList);
    safetyAssessmentRetrieveSO.setPrincipalCaretakers(caretakerList);

    return safetyAssessmentRetrieveSO;
  }

  private SafetyAssessmentRetrieveSO populateSafetyFactorsRetrieveSO(
                                                                     GrndsExchangeContext context,
                                                                     SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO,
                                                                     String category) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateSafetyFactorsRetrieveSO");
    performanceTrace.enterScope();
    try {
      Collection<SafetyFactorsRetrieveSO> safetyFactors = null;
      Map<String, Collection<SafetyFactorsRetrieveSO>> map = new HashMap<String, Collection<SafetyFactorsRetrieveSO>>();

      Iterator<CodeAttributes> iterator = Lookup.getCategoryListing(category);
      while (iterator.hasNext()) {
        CodeAttributes codeAttribute = iterator.next();
        String code = codeAttribute.getCode();
        safetyFactors = initializeSafetyFactors(code, safetyAssessmentRetrieveSO);
        // this puts all the combinations in for a certain question
        map.put(code, safetyFactors);
      }
      // Initialize combinations for "Other" question
      String code = OTHER_QUESTION;
      safetyFactors = initializeSafetyFactors(code, safetyAssessmentRetrieveSO);
      map.put(code, safetyFactors);

      // This sets the entire safety factor section
      safetyAssessmentRetrieveSO.setSafetyFactors(map);
      
    } catch (Exception e) {
      e.printStackTrace();
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return safetyAssessmentRetrieveSO;

  }

  private ArrayList<SafetyFactorsRetrieveSO> initializeSafetyFactors(
                                                                     String code,
                                                                     SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO) {
    ArrayList<SafetyFactorsRetrieveSO> safetyFactors = new ArrayList<SafetyFactorsRetrieveSO>();
    
    // STGAP00009307: Get the existing safety factors
    ArrayList<SafetyFactorsRetrieveSO> savedSafetyFactors = null;
    Map<String, Collection<SafetyFactorsRetrieveSO>> savedSafetyFactorsMap = safetyAssessmentRetrieveSO.getSafetyFactors();
    if (null != savedSafetyFactorsMap) 
      savedSafetyFactors = (ArrayList<SafetyFactorsRetrieveSO>)savedSafetyFactorsMap.get(code);
  
    Iterator<SaPerson> childrenList = safetyAssessmentRetrieveSO.getPrincipalChildren().iterator();
    while (childrenList.hasNext()) {
      SaPerson child = childrenList.next();
      Iterator<SaPerson> caretakerList = safetyAssessmentRetrieveSO.getPrincipalCaretakers().iterator();
      while (caretakerList.hasNext()) {
        SaPerson caretaker = caretakerList.next();
        
        // STGAP00009307: If safety factors exist for this care taker and child then save it in the 
        // safety factors array
        boolean caretakerHasSafetyFactors = false;
        if (null != savedSafetyFactors) {
          for (SafetyFactorsRetrieveSO savedSafetyFactor : savedSafetyFactors) {
            if ((caretaker.getIdPerson() == savedSafetyFactor.getIdCaretaker()) &&
                (child.getIdPerson() == savedSafetyFactor.getIdChild() ) ) {
              safetyFactors.add(savedSafetyFactor);
              caretakerHasSafetyFactors = true;
              break;
            }
          }
        }

        // STGAP00009307: If safety factors do not exist for this care taker and child then create and 
        // save the default safety factors in the safety factors array.        
        if (!caretakerHasSafetyFactors) {
          SafetyFactorsRetrieveSO safetyFactor = new SafetyFactorsRetrieveSO();
          safetyFactor.setSzCdSafetyFactor(code);
          safetyFactor.setIdChild(child.getIdPerson());
          safetyFactor.setIdCaretaker(caretaker.getIdPerson());
          safetyFactor.setTxtCaretaker(caretaker.getNmPersonFull());
          safetyFactor.setTxtChild(child.getNmPersonFull());
          safetyFactors.add(safetyFactor);
        }
      }
    }
    return safetyFactors;
  }

  private SafetyAssessmentRetrieveSO populateDrugExposedNewBornRetrieveSO(
                                                                          GrndsExchangeContext context,
                                                                          SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO,
                                                                          String category) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateDrugExposedNewBornRetrieveSO");
    performanceTrace.enterScope();

    try {
      Collection<DrugExposedNewBornRetrieveSO> coll = new ArrayList<DrugExposedNewBornRetrieveSO>();
      Iterator<CodeAttributes> iterator = Lookup.getCategoryListing(category);
      while (iterator.hasNext()) {
        CodeAttributes codeAttribute = iterator.next();
        String code = codeAttribute.getCode();
        DrugExposedNewBornRetrieveSO dENB = new DrugExposedNewBornRetrieveSO();
        dENB.setSzCdDrugExpNb(code);
        coll.add(dENB);
      }
      safetyAssessmentRetrieveSO.setDrugExposedNewborn(coll);
    } catch (Exception e) {
      e.printStackTrace();
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return safetyAssessmentRetrieveSO;

  }

  /**
   * 
   * This method updates the incoming safety assessment object with a new reasonable efforts object. 
   * 
   * @param context
   * @param safetyAssessmentRetrieveSO
   * @param category
   * @return
   */
  private SafetyAssessmentRetrieveSO populateReasonableEffortsRetrieveSO(
                                                                         GrndsExchangeContext context,
                                                                         SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO,
                                                                         String category) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateReasonableEffortsRetrieveSO");
    performanceTrace.enterScope();
    try {
      Collection<ReasonableEffortsRetrieveSO> reasonableEfforts = null;
      Map<String, Collection<ReasonableEffortsRetrieveSO>> map = new TreeMap<String, Collection<ReasonableEffortsRetrieveSO>>();
 
      Iterator<CodeAttributes> iterator = Lookup.getCategoryListing(category);
      while (iterator.hasNext()) {
        CodeAttributes codeAttribute = iterator.next();
        String code = codeAttribute.getCode();
        reasonableEfforts = initializeReasonableEfforts(code, safetyAssessmentRetrieveSO);
        map.put(code, reasonableEfforts);
        
      }
      
      // This sets the entire safety factor section 
      safetyAssessmentRetrieveSO.setReasonableEfforts(map);        
 
    } catch (Exception e) {
      e.printStackTrace();
      processSevereException(context, e);
    }
  
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  
    return safetyAssessmentRetrieveSO;
  
  }

  
  /**
   * 
   * This method creates the new reasonable efforts object from existing reasonable efforts object. If reasonable 
   * efforts do not exist then a new reasonable effort is created using the defaults. Reasonable efforts are 
   * added for any new children found in the principal children list. An updated principal children list and the 
   * saved reasonable efforts object are contained in the incoming safety assessment object.
   * 
   * @param code
   * @param safetyAssessmentRetrieveSO
   * @return
   */
  private ArrayList<ReasonableEffortsRetrieveSO> initializeReasonableEfforts(
                                                                 String code,
                                                                 SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO) {
    ArrayList<ReasonableEffortsRetrieveSO> reasonableEfforts = new ArrayList<ReasonableEffortsRetrieveSO>();
    
    // Get the existing reasonable efforts. At this point the reasonable efforts is null or the content is empty
    ArrayList<ReasonableEffortsRetrieveSO> savedReasonableEfforts = null;
    Map<String, Collection<ReasonableEffortsRetrieveSO>> savedReasonableEffortsMap = safetyAssessmentRetrieveSO.getReasonableEfforts();      
    if (null != savedReasonableEffortsMap)
      savedReasonableEfforts = (ArrayList<ReasonableEffortsRetrieveSO>)savedReasonableEffortsMap.get(code);
 
    Iterator<SaPerson> childrenList = safetyAssessmentRetrieveSO.getPrincipalChildren().iterator();
    while (childrenList.hasNext()) {
      SaPerson child = childrenList.next();
        
      // If reasonable efforts exist for this child then copy the reasonable efforts to the 
      // reasonable efforts array     
      boolean childHasReasonableEfforts = false;
      if (null != savedReasonableEfforts) {
        for (ReasonableEffortsRetrieveSO savedReasonableEffort : savedReasonableEfforts) {
          if (child.getIdPerson() == savedReasonableEffort.getIdChild()) {
            reasonableEfforts.add(savedReasonableEffort);
            childHasReasonableEfforts = true;
            break;
          }
        }
      }
      
      // If reasonable efforts do not exist for this child then create the default reasonable efforts and copy  
      // to the reasonable efforts array.
      if (!childHasReasonableEfforts) {
        ReasonableEffortsRetrieveSO reasonableEffort = new ReasonableEffortsRetrieveSO();
        reasonableEffort.setSzCdReasonableEfforts(code);
        reasonableEffort.setIdChild(child.getIdPerson());
        reasonableEffort.setSzTxtChild(child.getNmPersonFull());
        reasonableEfforts.add(reasonableEffort);
      }
    }
       
    return reasonableEfforts;

  }

  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
      setErrorMessage(we.getErrorCode(), request);
      break;
    default:
      if (we.getErrorCode() != 0) {
        setErrorMessage(we.getErrorCode(), request);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
      break;
    }
  }
}
