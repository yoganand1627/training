package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseReviewRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseReviewSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewQuestionsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Created by:   Bhavna Gehlot
 * Date Created: 3/10/2009
 * This is the Conversation class for Case Review.
 * 
 * Change History:
 * Date        User              Description
 * --------    ----------------  ----------------------------------------------
 * 
 * 06/09/2009  bgehlot           STGAP00014146: Users should be able to save the Targeted Case Review  
 *                               and mark as complete with a limited amount of questions answered.
 * 08/03/2009  bgehlot           STGAP00014727: The Log of contact narratives form retrieve all the contacts made in that case.
 * 
 * 10/09/2009  bgehlot           SMS#38872 Set the review complete date to current date when review is complete
 *
 * 
 */

public class CaseReviewConversation extends BaseHiddenFieldStateConversation {

  /**
   * The CLASSNAME_TAG constant is used to mark log records in GRNDS tracing; most classes should have it. <p/> Other
   * static constants should be put just below this.
   */
  public static final String TRACE_TAG = "CaseReviewConversation";

  public static final String INTAKE = "INT";

  public static final String CASE_REVIEW_TASK_CODE_INT = "9880";

  public static final String INVESTIGATION = "INV";

  public static final String CASE_REVIEW_TASK_CODE_INV = "9890";
   
  public static final String FOSTER_CARE  = "SUB";

  public static final String CASE_REVIEW_TASK_CODE_SUB = "9910";
  
  public static final String ADOPTION  = "ADO";

  public static final String CASE_REVIEW_TASK_CODE_ADO = "9920";
     
  public static final String DIVERSION  = "DIV";

  public static final String CASE_REVIEW_TASK_CODE_DIV = "9930";
  
  public static final String ONGOING  = "FPR";

  public static final String CASE_REVIEW_TASK_CODE_FPR = "9940";
  
  public static final String CSR_EVENT_TYPE = CodesTables.CEVNTTYP_CSR;

  public static final String CASE_REVIEW_TAB = "";

  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;
  
  public static final String IS_COMPLETE = "on";
  
  public static final String ON = "on";

  public static String PREVIOUS_URI_PARAM_NAME = "hdnCurrentDisplayURI";

  public static String PREVIOUS_URI_STAFF_TODO = "/workload/ToDo/displayStaffToDo";
  
  public static final String DELETE = "delete";
  
  public static final String SAVE = "save";
  
  public static final String MAIN_QUESTION = "M";
  
  public static final String DECISION_QUESTION = "D";
  
  public static final String NO_QUES_RESPONSE = "1";
  
  public static final String CONTACT_SUMMARY_ITEM = "WLLIT3";
  
  public static final int FROM_MONTHS = -7; // 7 months back from current month
  
  public static final int TO_MONTHS = -2;// 2 months back from current month
  
  public static final int MAX_VERSION = 9999; // Maximum version of the question which is not required to be displayed on the Survey
  
 
  private CaseMgmt caseMgmt;
  
  /** @param investigation */
  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  /**
   * Display method for the Case Review page
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void displayCaseReview_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseReview_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      
      state.removeAllAttributes(request);
      
      CaseReviewRetrieveSI caseReviewRetrieveSI = populateCaseReviewRetrieveSI(context);
      
      CaseReviewRetrieveSO caseReviewRetrieveSO = new CaseReviewRetrieveSO();
      
      //Call the Retrieve Service.
      caseReviewRetrieveSO = caseMgmt.retrieveCaseReview(caseReviewRetrieveSI);
      
      // Check each Item of the case review for completion and set the
      // corresponding property in the case review accordingly. Since
      // this is a new case review, all the Items will be incomplete.
      caseReviewRetrieveSO = this.checkCaseReviewForCompletion(context, caseReviewRetrieveSO);
       
      request.setAttribute("CaseReviewRetrieveSO", caseReviewRetrieveSO);
      state.setAttribute("CaseReviewRetrieveSO", caseReviewRetrieveSO, request);
      
      //STGAP00014727: The Log of contact narratives form retrieve all the contacts made in that case.
      //Set this object to the state so that the form's service gets it and lauch the form
      
      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      pagination.getResultDetails().setResultsPerPage(50);
      
      CSYS04SI csys04si = populateCSYS04SI_Retrieve(context, pagination);;
      state.setAttribute("csys04si", csys04si, request);

      // set page mode
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      if (GlobalData.getSzCdStage(request).equals(INTAKE)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(CASE_REVIEW_TASK_CODE_INT, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         caseReviewRetrieveSO.getIdCaseRevEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         CASE_REVIEW_TASK_CODE_INT);
        PageMode.setPageMode(pageMode, request);
      }
      if (GlobalData.getSzCdStage(request).equals(INVESTIGATION)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(CASE_REVIEW_TASK_CODE_INV, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         caseReviewRetrieveSO.getIdCaseRevEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         CASE_REVIEW_TASK_CODE_INV);
        PageMode.setPageMode(pageMode, request);
      }
      
     if (GlobalData.getSzCdStage(request).equals(FOSTER_CARE)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(CASE_REVIEW_TASK_CODE_SUB, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         caseReviewRetrieveSO.getIdCaseRevEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         CASE_REVIEW_TASK_CODE_SUB);
        PageMode.setPageMode(pageMode, request);
      }
      
      
      if (GlobalData.getSzCdStage(request).equals(DIVERSION)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(CASE_REVIEW_TASK_CODE_DIV, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         caseReviewRetrieveSO.getIdCaseRevEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         CASE_REVIEW_TASK_CODE_DIV);
        PageMode.setPageMode(pageMode, request);
      }
      
  
      if (GlobalData.getSzCdStage(request).equals(ONGOING)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(CASE_REVIEW_TASK_CODE_FPR, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         caseReviewRetrieveSO.getIdCaseRevEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         CASE_REVIEW_TASK_CODE_FPR);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(ADOPTION)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(CASE_REVIEW_TASK_CODE_ADO, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         caseReviewRetrieveSO.getIdCaseRevEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         CASE_REVIEW_TASK_CODE_ADO);
        PageMode.setPageMode(pageMode, request);
      }

    } catch (Exception e) {
      e.printStackTrace();
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * Save Case Review
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void saveCaseReview_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveCaseReview_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      if (IS_COMPLETE.equals(ContextHelper.getStringSafe(request, "cbxComplete"))) {
        // Set a "perform completion check" indicator to true when complete check box is checked and put it in
        // the request so the JSP will know that a completion check is being
        // performed.
        Boolean performCompletionCheck = Boolean.TRUE;
        request.setAttribute("performCompletionCheck", performCompletionCheck);
      }
      // Get the output object out of the request
      CaseReviewRetrieveSO caseReviewRetrieveSO = (CaseReviewRetrieveSO) state.getAttribute("CaseReviewRetrieveSO", request);
      
      //Get the current event status of the Case Review
      String eventStatus = StringHelper.EMPTY_STRING;
      if(caseReviewRetrieveSO.getROWCCMN45DO() != null){
        eventStatus = caseReviewRetrieveSO.getROWCCMN45DO().getSzCdEventStatus();
      }
      
      // Check each Item of the case review for completion and set the
      // corresponding property in the case review accordingly. Since
      // this is a new case review, all the Items will be incomplete.
      caseReviewRetrieveSO = this.checkCaseReviewForCompletion(context, caseReviewRetrieveSO);
      
      //If the complete check box is checked and all the questions are not answered display error message.
      //STGAP00014146: Users should be able to save the Targeted Case Review  and mark as complete with a limited amount of questions answered. 
      if(IS_COMPLETE.equals(ContextHelper.getStringSafe(request, "cbxComplete")) && !caseReviewRetrieveSO.getIndCaseReviewComplete() 
                      && !CodesTables.CCSRTYPE_RT1.equals(ContextHelper.getStringSafe(context, "selReviewType"))){
        setErrorMessage(Messages.MSG_CSR_ANS_REQ, request);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        return;
      } // Check if the complete check box is checked OR the current status of the event is COMP. This is checked
        // because the Save button is always available even in COMP status.
      //STGAP00014146: Users should be able to save the Targeted Case Review  and mark as complete with a limited amount of questions answered. 
      else if((IS_COMPLETE.equals(ContextHelper.getStringSafe(request, "cbxComplete")) || 
                      CodesTables.CEVTSTAT_COMP.equals(eventStatus))
                      && (caseReviewRetrieveSO.getIndCaseReviewComplete() || 
                           (!caseReviewRetrieveSO.getIndCaseReviewComplete() && CodesTables.CCSRTYPE_RT1.equals(ContextHelper.getStringSafe(context, "selReviewType"))))){
        // This takes back to event list page
        this.setPresentationBranch("redirect", context);
      }
      int idCsrEvent  = save(context, SAVE);
      GlobalData.setUlIdEvent(idCsrEvent, request);
      
    } catch (ServiceException we) {
      handleError(we, context);
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

  /**
   * Delete case review
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void deleteCaseReview_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteCaseReview_xa()");
    performanceTrace.enterScope();
    
    save(context, DELETE);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  private int save(GrndsExchangeContext context, String method) {
    //Set all the data in caseReviewSaveSI
    CaseReviewSaveSI caseReviewSaveSI = populateCaseReviewSaveSI(context, method);
    //Call the Save service
    int idEvent = caseMgmt.saveCaseReview(caseReviewSaveSI);
    return idEvent;
  }
  
  /**
   * Demonstrates the pattern for populating SI objects from the context. All population from the context (including
   * request, session, and state), should take place in private methods like this one. The method should instantiate the
   * input object, get values out of the context, and then return the SI object.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  private CaseReviewRetrieveSI populateCaseReviewRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateRetrieveCaseReviewSI");
    performanceTrace.enterScope();
    
    // Get the state and request objects, if necessary.
    HttpServletRequest request = context.getRequest();
    
    UserProfile user = UserProfileHelper.getUserProfile(request);

    // The input object.
    CaseReviewRetrieveSI caseReviewRetrieveSI = new CaseReviewRetrieveSI();

    // Populate the input object sub-structures from the request, then populate the input object form the request.
    // Use GlobalData when practical.
    caseReviewRetrieveSI.setIdCaseRevEvent(GlobalData.getUlIdEvent(request));
    caseReviewRetrieveSI.setPageMode(PageMode.getPageMode(request));
    caseReviewRetrieveSI.setIdStage(GlobalData.getUlIdStage(request));
    caseReviewRetrieveSI.setIdCase(GlobalData.getUlIdCase(request));
    caseReviewRetrieveSI.setIdStaff(user.getUserID());
    //Set the WLLIT3 item for which contact log needs to be displayed
    caseReviewRetrieveSI.setContactSummary(CONTACT_SUMMARY_ITEM);
    //Set the date range for the Contact Log
    Date today = new java.util.Date();
    Date fromDate = DateHelper.addToDate(DateHelper.getFirstDayOfTheMonth(today), 0, FROM_MONTHS, 0);
    Date toDate = DateHelper.addToDate(DateHelper.getLastDayOfTheMonth(today), 0, TO_MONTHS, 0);   
    caseReviewRetrieveSI.setFromDate(fromDate);
    caseReviewRetrieveSI.setToDate(toDate);
    
    // Maximum version of the question which is not required to be displayed on the Survey
    caseReviewRetrieveSI.setMaxVersion(MAX_VERSION);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return caseReviewRetrieveSI;
  }
  
  
  private CaseReviewSaveSI populateCaseReviewSaveSI(GrndsExchangeContext context, String method) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCaseReviewSaveSI");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Get the output object out of the request
    CaseReviewRetrieveSO caseReviewRetrieveSO = (CaseReviewRetrieveSO) state.getAttribute("CaseReviewRetrieveSO", request);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    String eventDesc = Lookup.simpleDecodeSafe(CodesTables.CSTAGES, GlobalData.getSzCdStage(request)) + " Case Review";
    ROWCCMN01UIG00 caseReviewEvent = new ROWCCMN01UIG00();
    CaseReviewSaveSI caseReviewSaveSI = new CaseReviewSaveSI();
    
    //Get the current event status.
    String eventStatus = StringHelper.EMPTY_STRING;
    if(caseReviewRetrieveSO.getROWCCMN45DO() != null){
      eventStatus = caseReviewRetrieveSO.getROWCCMN45DO().getSzCdEventStatus();
    }
    
    // Check if the complete check box is checked OR the current status of the event is COMP. This is checked
    // because the Save button is always available even in COMP status.
    if (IS_COMPLETE.equals(ContextHelper.getStringSafe(request, "cbxComplete")) || 
                    CodesTables.CEVTSTAT_COMP.equals(eventStatus)){
      caseReviewEvent.setSzCdEventStatus(EVENT_STATUS_COMP);
      // If the status is complete then the Event created through Batch has corresponding To do which needs to be deleted
      // Set the below variable to true, which is used in save service to delete the ToDo
      caseReviewSaveSI.setIndTodoDelete(Boolean.TRUE);
    } // end if
    else {
      caseReviewEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
    } // end else
    
    //Set the Event Object
    caseReviewEvent.setSzCdEventType(CSR_EVENT_TYPE);
    caseReviewEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    caseReviewEvent.setUlIdStage(GlobalData.getUlIdStage(request));
    caseReviewEvent.setUlIdPerson(user.getUserID());
    caseReviewEvent.setSzTxtEventDescr(eventDesc);
    caseReviewEvent.setSzCdTask(GlobalData.getSzCdTask(request));
    caseReviewEvent.setUlIdEvent(GlobalData.getUlIdEvent(request));
    caseReviewEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));

    //Set the caseReviewSaveSI Object
    caseReviewSaveSI.setIdCsrEvent(GlobalData.getUlIdEvent(request));
    caseReviewSaveSI.setIdStage(GlobalData.getUlIdStage(request));
    caseReviewSaveSI.setIdCase(GlobalData.getUlIdCase(request));
    caseReviewSaveSI.setIdReviewer(user.getUserID());
    caseReviewSaveSI.setSzTxtSummaryComment(ContextHelper.getStringSafe(request, "txtSummaryComment"));
    caseReviewSaveSI.setCheckedCheckboxes(CheckboxHelper.getCheckedValues(request, "chkQuestion"));
    caseReviewSaveSI.setDtDtStaffedWithWorker(ContextHelper.getJavaDateSafe(request, "dtStaffedWithWorker"));
    caseReviewSaveSI.setDtDtCorrectionDue(ContextHelper.getJavaDateSafe(request, "dtCorrectionsDue"));
    caseReviewSaveSI.setDtDtCorrectionComplete(ContextHelper.getJavaDateSafe(request, "dtCorrectionsComplete"));
    caseReviewSaveSI.setDtDtReview(ContextHelper.getJavaDateSafe(request, "dtDtReview"));
    caseReviewSaveSI.setCdStage(GlobalData.getSzCdStage(request));
    caseReviewSaveSI.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "crTsLastUpdate"));
    caseReviewSaveSI.setCdReviewType(ContextHelper.getStringSafe(context, "selReviewType"));
    caseReviewSaveSI.setDtDtReviewComplete(ContextHelper.getJavaDateSafe(request, "dtDtReviewComplete"));
    
    if (IS_COMPLETE.equals(ContextHelper.getStringSafe(request, "cbxComplete"))){
      //SMS#38872 Set the review complete date to current date when review is complete
      Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
      caseReviewSaveSI.setDtDtReviewComplete(currentDate);
    }
    
    // Check if the complete check box is checked OR the current status of the event is COMP. This is checked
    // because the Save button is always available even in COMP status.
    if (ON.equals(ContextHelper.getStringSafe(request, "cbxComplete")) || 
                    CodesTables.CEVTSTAT_COMP.equals(eventStatus)) {
      caseReviewSaveSI.setIndComplete(ArchitectureConstants.Y);
    }else{
      caseReviewSaveSI.setIndComplete(ArchitectureConstants.N);
    }
    
    //Set the Event Object in caseReviewSaveSI Object
    caseReviewSaveSI.setROWCCMN01UIG00(caseReviewEvent);
    
    if(DELETE.equals(method)){
      caseReviewSaveSI.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    }else{
      caseReviewSaveSI.setCdReqFuncCd(caseReviewRetrieveSO.getCdReqFuncCd());
    }
    
    caseReviewSaveSI.setIndCaseReviewComplete(caseReviewRetrieveSO.getIndCaseReviewComplete());
    caseReviewSaveSI.setIdCaseWorker(caseReviewRetrieveSO.getIdCaseWorker());
    
    String cdPreviousItem = null;
    
    // Create a Question List for each question using the values submitted
    // in the form, then assign the list to the appropriate property in the CaseReviewSaveSI.
    List<CaseReviewQuestionsSO> questionsList = new ArrayList<CaseReviewQuestionsSO>();
    if (caseReviewRetrieveSO.getCaseReviewQuestionsList() != null && !caseReviewRetrieveSO.getCaseReviewQuestionsList().isEmpty()) {
      Iterator<CaseReviewQuestionsSO> iter = caseReviewRetrieveSO.getCaseReviewQuestionsList().iterator();
      while (iter.hasNext()) {
        CaseReviewQuestionsSO caseReviewQuestionsSO = (CaseReviewQuestionsSO) iter.next();

        String cdCategory = caseReviewQuestionsSO.getSzCdCategory();
        String cdItem = caseReviewQuestionsSO.getSzCdItem();
        String cdQuestion = caseReviewQuestionsSO.getSzCdQuestion();
        String txtQuestion = caseReviewQuestionsSO.getSzTxtQuestion();
        String txtComments = "txt" + cdItem + "comments";
        String questionResponseFieldName = "rb" + cdQuestion + "Response";
        String indQuestionType = caseReviewQuestionsSO.getIndQuestionType();

        boolean mainQuesHasDecisionQues = false;
        CaseReviewQuestionsSO caseReviewQuestionSave = new CaseReviewQuestionsSO();

        //This below code checks to see if the decision question for that item has No radio button selected then
        //disable the Main Questions radio button hence mainQuestionDisabled is set to true.
        if (cdPreviousItem == null || !cdPreviousItem.equals(caseReviewQuestionsSO.getSzCdItem())) {
          if(MAIN_QUESTION.equals(indQuestionType)){
            Iterator<CaseReviewQuestionsSO> iterInner = caseReviewRetrieveSO.getCaseReviewQuestionsList().iterator();
            while (iterInner.hasNext()) {
              CaseReviewQuestionsSO caseReviewQuestionsSOInner = (CaseReviewQuestionsSO) iterInner.next();
              String indQuestionTypeInner = caseReviewQuestionsSOInner.getIndQuestionType();
              String cdQuestionInner = caseReviewQuestionsSOInner.getSzCdQuestion();
              String questionResponseFieldNameInner = "rb" + cdQuestionInner + "Response";
              if (caseReviewQuestionsSO.getSzCdItem().equals(caseReviewQuestionsSOInner.getSzCdItem())) {
                if(DECISION_QUESTION.equals(indQuestionTypeInner) && NO_QUES_RESPONSE.equals(ContextHelper.getStringSafe(request, questionResponseFieldNameInner))){
                  boolean mainQuestionDisabled = true;
                  caseReviewQuestionSave.setMainQuestionDisabled(mainQuestionDisabled);
                  mainQuesHasDecisionQues = true;
                  break;
                }
              }
            }
          }
        }
        caseReviewQuestionSave.setIdCaseReviewCateg(caseReviewQuestionsSO.getIdCaseReviewCateg());
        caseReviewQuestionSave.setSzCdCategory(cdCategory);
        caseReviewQuestionSave.setIdCaseReviewItem(caseReviewQuestionsSO.getIdCaseReviewItem());
        caseReviewQuestionSave.setSzCdItem(cdItem);
        caseReviewQuestionSave.setIdCaseReviewQuestion(caseReviewQuestionsSO.getIdCaseReviewQuestion());
        caseReviewQuestionSave.setSzCdQuestion(cdQuestion);
        caseReviewQuestionSave.setSzTxtQuestion(txtQuestion);
        caseReviewQuestionSave.setCdVersion(caseReviewQuestionsSO.getCdVersion());
        
        //If the current question is the main question and that main question has decision question set to No then
        // select No radio button for the main question too.
        if("M".equals(indQuestionType)){
          if(mainQuesHasDecisionQues){
            caseReviewQuestionSave.setSzCdQuestionResponse("1");
          }else{
            String questionResponse =  ContextHelper.getStringSafe(request, questionResponseFieldName);
            if(StringHelper.EMPTY_STRING.equals(questionResponse)){
              questionResponseFieldName = questionResponseFieldName + "_Disabled";
              questionResponse =  ContextHelper.getStringSafe(request, questionResponseFieldName);
            }
            caseReviewQuestionSave.setSzCdQuestionResponse(questionResponse);
          }
        }else{
          caseReviewQuestionSave.setSzCdQuestionResponse(ContextHelper.getStringSafe(request, questionResponseFieldName));
        }
        caseReviewQuestionSave.setTxtComments(ContextHelper.getStringSafe(request, txtComments));
        caseReviewQuestionSave.setIndQuestionType(caseReviewQuestionsSO.getIndQuestionType());
        caseReviewQuestionSave.setIndCbx(caseReviewQuestionsSO.getIndCbx());
        caseReviewQuestionSave.setCdSurveyQuestionType(caseReviewQuestionsSO.getCdSurveyQuestionType());
        questionsList.add(caseReviewQuestionSave);
        cdPreviousItem = caseReviewQuestionsSO.getSzCdItem();
      }
    }
    caseReviewSaveSI.setCaseReviewQuestionsList(questionsList);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return caseReviewSaveSI;
  }
  
  /**
   * Check the Case Review to see if it is complete.
   * 
   * @param caseReviewRetrieveSOToCheck
   *          The CaseReviewRetrieveSO containing the case Review detail to be checked for completion.
   * @return caseReviewRetrieveSOToCheck The CaseReviewRetrieveSO passed to the method, but the "completion check" properties are
   *         set based upon the completion status of the case review.
   */
  public CaseReviewRetrieveSO checkCaseReviewForCompletion(GrndsExchangeContext context, CaseReviewRetrieveSO caseReviewRetrieveSOToCheck) {
    GrndsTrace.enterScope(TRACE_TAG + ".checkCaseReviewForCompletion");
    HttpServletRequest request = context.getRequest();
    CaseReviewQuestionsSO currentQuestion;
    Boolean currentQuesIsComplete = Boolean.TRUE;
    Map<String, Boolean> currentQuesHashtable = new HashMap<String, Boolean>();
    boolean caseReviewIsComplete = true;
    String cdPreviousItem = null;
    try {
      // Iterate through the questions in the order they appear in the array.
      // The questions were grouped by Category and Items when retrieved from the
      // database, so just iterate through the list and check the properties of
      // the questions until the Item changes. Then start over for each new
      // Item.
      Iterator<CaseReviewQuestionsSO> iter = caseReviewRetrieveSOToCheck.getCaseReviewQuestionsList().iterator();
      while (iter.hasNext()) {
        currentQuestion = (CaseReviewQuestionsSO) iter.next();

        String cdQuestion = currentQuestion.getSzCdQuestion();
        String questionResponseFieldName = "rb" + cdQuestion + "Response";
        String questionResponse = ContextHelper.getStringSafe(request, questionResponseFieldName);
        if("".equals(questionResponse)){
          questionResponseFieldName = questionResponseFieldName + "_Disabled";
          questionResponse = ContextHelper.getStringSafe(request, questionResponseFieldName);
        }
        
      //This below code checks to see if the decision question for that item has No radio button selected then
        //disable the Main Questions radio button hence mainQuestionDisabled is set to true.
        if (cdPreviousItem == null || !cdPreviousItem.equals(currentQuestion.getSzCdItem())) {
          if(MAIN_QUESTION.equals(currentQuestion.getIndQuestionType())){
            Iterator<CaseReviewQuestionsSO> iterInner = caseReviewRetrieveSOToCheck.getCaseReviewQuestionsList().iterator();
            while (iterInner.hasNext()) {
              CaseReviewQuestionsSO caseReviewQuestionsSOInner = (CaseReviewQuestionsSO) iterInner.next();
              String indQuestionTypeInner = caseReviewQuestionsSOInner.getIndQuestionType();
              String cdQuestionInner = caseReviewQuestionsSOInner.getSzCdQuestion();
              String questionResponseFieldNameInner = "rb" + cdQuestionInner + "Response";
              if (currentQuestion.getSzCdItem().equals(caseReviewQuestionsSOInner.getSzCdItem())) {
                if(DECISION_QUESTION.equals(indQuestionTypeInner) && NO_QUES_RESPONSE.equals(ContextHelper.getStringSafe(request, questionResponseFieldNameInner))){
                  questionResponse = "1";
                  break;
                }
              }
            }
          }
        }

        // If the current question response is null or empty, then the Review is incomplete.
        if (questionResponse == null || "".equals(questionResponse)) {
          currentQuesIsComplete = Boolean.FALSE;
          currentQuesHashtable.put(currentQuestion.getSzCdQuestion(), currentQuesIsComplete);
          caseReviewIsComplete = false;
        }
        cdPreviousItem = currentQuestion.getSzCdItem();
      }// end while loop

      caseReviewRetrieveSOToCheck.setReviewCompletionStatus(currentQuesHashtable);
      caseReviewRetrieveSOToCheck.setIndCaseReviewComplete(caseReviewIsComplete);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
    return caseReviewRetrieveSOToCheck;
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
 
 /**STGAP00014727: Added this method to populate csys04si for the Log of Contact Narrative form
  * This helper method populates the input object for the csys04s retrieve service.
  *
  * @param context    The GrndsExchangeContext object
  * @param pagination TuxedoPaginationValueBean.
  * @return csys04si
  */
 private CSYS04SI populateCSYS04SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean pagination) {
   PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS04SI_Retrieve()");
   performanceTrace.enterScope();

   HttpServletRequest request = context.getRequest();

   CSYS04SI csys04si = new CSYS04SI();
   UserProfile user = UserProfileHelper.getUserProfile(context);
   ArchInputStruct input = new ArchInputStruct();

   input.setUsPageNbr(pagination.getResultDetails().getRequestedPage());
   input.setUlPageSizeNbr(pagination.getResultDetails().getResultsPerPage());
   input.setSzUserId(user.getUserLogonID());
   csys04si.setArchInputStruct(input);
   csys04si.setUlIdStage(GlobalData.getUlIdStage(request));
   csys04si.setUlIdCase(GlobalData.getUlIdCase(request));
   
   ROWCSYS04SI_ARRAY csys04siArray = new ROWCSYS04SI_ARRAY();
   //set the array into the si object after all of the rows are added
   csys04si.setROWCSYS04SI_ARRAY(csys04siArray);
   csys04si.setUlRowQty(csys04siArray.getUlRowQty());
   
   ContactCbxRecord_Array cbxArray = new ContactCbxRecord_Array();  
   csys04si.setContactCbxRecord_Array(cbxArray);    

   performanceTrace.exitScope();
   return csys04si;
 }

}