package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.Assessment;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyPlanRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyPlanSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonResonsibleSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO.RowCasePersonResponsible;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to launch narratives and forms that are not associated with any particular page
 * in the SACWIS application. <p/>
 * 
 * <pre>
 *                   @author Amit Patel, February 12, 2007
 *                
 *                Change History:
 *                Date        User      Description
 *                ----------  --------  --------------------------------------------------
 *                07/23/2008  arege     STGAP00009550 Modified saveSafetyPlan() so that when a Case Manager  Saves a pending
 *                                      approval it invalidates the approval and deletes Task from the Approvers ToDo list.
 *                                      
 *                10/30/2008  charden   STGAP00010129 - if the safetyPlan is pending approval and the user 
 *                                      is the approver, place page in modify mode. This is so that page will be modifiable
 *                                      when in approval status. If in approval status and user is approver,esave page with
 *                                      pend status and redisplay page if save btn is pressed
 *                   
 *                   
 * 
 */
@SuppressWarnings("serial")
public class SafetyPlanConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "SafetyPlanConversation";

  public static final String ENGLISH = "english";

  public static final String SPANISH = "spanish";

  // Codes table lookups
  public static final String CODE_TABLE_EVENT_DOC = CodesTables.CEVNTDOC;

  public static final String CODE_TABLE_EVENT_TYPE = CodesTables.CEVNTTYP;

  public static final String CODE_TABLE_EVENT_APPROVE = CodesTables.CEVNTAPV;

  // Event Status
  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_DESC_SPL = "Safety Plan";

  public static final String DELETE = "DELETE";
  public static final String SUBMIT = "SUBMIT";

  public static final String SAVE = "SAVE";

  public static final String SAFETY_PLAN_TASK = "2275";

  public static final String APPROVE_SAFETY_PLAN = "2276";

  public static final String SPL_EVENT_TYPE = CodesTables.CEVNTTYP_SPL;

  public static final String FACTOR_ROWS_COUNT = "factorRowsCount";

  public static final String SAFETY_PLAN_RETRIEVESO = "SafetyPlanRetrieveSO";

  public static final String DELETE_SAFETY_FACTOR_LIST = "delete_SafetyFactor_List";

  public static final String ROWCCMN45DO = "rowccmn45do";

  public static final String CASE_PERSON_RESPONSIBLE_LIST = "casePersonResponsibleList";
  
  private static final String SAFETY_PLAN_TASK_ONG = "7330";
  
  private static final String APPROVE_SAFETY_PLAN_ONG = "7335";
  
  private static final Map<String, String> TASK_CODE_MAP = new HashMap<String, String>() {
    {
      put(SAFETY_PLAN_TASK, APPROVE_SAFETY_PLAN);
      put(SAFETY_PLAN_TASK_ONG, APPROVE_SAFETY_PLAN_ONG);
    }
  };

  /** Create a private field for each service EJB used. */
  private Assessment assessment = null;
  
  private InvalidateApproval invalidateApproval = null;

  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
  }
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

   /**
   * This method is called by the GRNDS controller when displaying the Output Launch page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displaySafetyPlan_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displaySafetyPlan_xa");
    displaySafetyPlan(context);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the activity methods when displaying the Safety Plan page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void displaySafetyPlan(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displaySafetyPlan");

    try {

      HttpServletRequest request = context.getRequest();
      
      BaseSessionStateManager state = getSessionStateManager(context);
      
      SafetyPlanRetrieveSI safetyPlanRetrieveSI = populateSafetyPalnRetrieveSI_Retrieve(context);
      
      boolean isPageModeView = true;
      
      UserProfile user = UserProfileHelper.getUserProfile(request);
      if (user.hasRight(UserProfile.SEC_SUPERVISOR) || user.hasRight(UserProfile.SEC_CASE_MANAGER)) {
        isPageModeView = false;
      }

      if (isPageModeView) {
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }

      SafetyPlanRetrieveSO safetyPlanRetrieveSO = null;
      safetyPlanRetrieveSO = assessment.retrieveSafetyPlan(safetyPlanRetrieveSI);

      // if this is not a new assessment (has an idEvent)
      if (safetyPlanRetrieveSI.getUlIdEvent() != 0) {
        // If the Safety Plan event is pending approval and the user
        // did not access the page in approval mode, warn them that the pending
        // closure will be invalidated if they save any changes.
        boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
        String eventStatus = safetyPlanRetrieveSO.getRowccmn45do().getSzCdEventStatus();
        //STGAP00010129 - if the safetyPlan is pending approval and the user 
        //is the approver, place page in modify mode. This is so that page will be modifiable
        //when in approval status
        if(CodesTables.CEVTSTAT_PEND.equals(eventStatus) && globalEvtStatusIsApproval){
          PageMode.setPageMode(PageModeConstants.EDIT, request);
        }
        if (CodesTables.CEVTSTAT_PEND.equals(eventStatus) && !globalEvtStatusIsApproval
            && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
          setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
        state.setAttribute(ROWCCMN45DO, safetyPlanRetrieveSO.getRowccmn45do(), request);
      }
      request.setAttribute(SAFETY_PLAN_RETRIEVESO, safetyPlanRetrieveSO);
      state.setAttribute(CASE_PERSON_RESPONSIBLE_LIST, safetyPlanRetrieveSO.getCasePersonResponsibleList(), request);
      state.setAttribute(DELETE_SAFETY_FACTOR_LIST, new ArrayList(), request);

    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * This method is called by the GRNDS controller when displaying an Output Launch document.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayDocument_xa(GrndsExchangeContext context) {

  }

  /**
   * This method is called by the GRNDS controller when saving a Safety Plan.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveSafetyPlan_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "saveSafetyPlan_xa");
    try {
      saveSafetyPlan(context, assessment, SAVE);
    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  /**
   * 
   * @param context
   */
  public void deleteSafetyPlan_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "deleteSafetyPlan_xa");

    saveSafetyPlan(context, assessment, DELETE);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the GRNDS controller when adding Safety Plan .
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addSafetyFactor_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "addSafetyFactor_xa");

    try {
      HttpServletRequest request = context.getRequest();

      SafetyPlanRetrieveSO safetyPlanRetrieveSO = populateSafetyPalnRetrieveSI_Add(context);
      request.setAttribute(SAFETY_PLAN_RETRIEVESO, safetyPlanRetrieveSO);

    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when submitting an Safety Plan event for approval.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveAndSubmitSafetyPlan_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveAndSubmitSafetyAssessment_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    int idEvent = 0;
    try {

      // first, save the page
      idEvent = saveSafetyPlan(context, assessment, SUBMIT);
      GlobalData.setUlIdEvent(idEvent, request);

      int ulIdEvent = GlobalData.getUlIdEvent(request);
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = GlobalData.getUlIdStage(request);
      String approvalCdTask = APPROVE_SAFETY_PLAN;
      //-- STGAP00005607 -----------------------------
      String cdTask = GlobalData.getSzCdTask(request);
      if(TASK_CODE_MAP.containsKey(cdTask)) {
        approvalCdTask = TASK_CODE_MAP.get(cdTask);
      }
      //----------------------------------------------
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, approvalCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    } catch (ServiceException we) {
      handleException(we, context);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;

  }

  /**
   * This method is called by the GRNDS controller when deleting an Safety Plan event for approval.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void deleteSafetyFactor_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "deleteSafetyFactor_xa");

    try {
      HttpServletRequest request = context.getRequest();

      SafetyPlanRetrieveSO safetyPlanRetrieveSO = populateSafetyPalnRetrieveSI_Delete(context);
      request.setAttribute(SAFETY_PLAN_RETRIEVESO, safetyPlanRetrieveSO);

    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private int saveSafetyPlan(GrndsExchangeContext context, Assessment assessment, String method) {
      
     SafetyPlanSaveSI safetyPlanSaveSI = populateSafetyPalnRetrieveSI__Update(context, method);
     int idEvent = 0;
      BaseSessionStateManager state = getSessionStateManager(context);
      HttpServletRequest request = context.getRequest();
      String eStatus = "";
      boolean isApproval = GlobalData.isApprovalMode(request);

    try {
      SafetyPlanRetrieveSI safetyPlanRetrieveSI = populateSafetyPalnRetrieveSI_Retrieve(context);
      SafetyPlanRetrieveSO safetyPlanRetrieveSO = null;
      safetyPlanRetrieveSO = assessment.retrieveSafetyPlan(safetyPlanRetrieveSI);

      // if this is a new assessment with no idEvent
      if (safetyPlanRetrieveSI.getUlIdEvent() != 0) {
        // If the Safety Plan event is pending approval and the user
        // did not access the page in approval mode, warn them that the pending
        // closure will be invalidated if they save any changes.
        boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
        String eventStatus = safetyPlanRetrieveSO.getRowccmn45do().getSzCdEventStatus();
        eStatus = eventStatus;
        idEvent = safetyPlanRetrieveSO.getRowccmn45do().getUlIdEvent();
        
        //STGAP00009550 Case Manager is Saving a Pending Approval, this should invalidate the approval
        // and delete Task from the Approvers ToDo list.
       if (CodesTables.CEVTSTAT_PEND.equals(eventStatus)
          && (!globalEvtStatusIsApproval || GlobalData.isStageClosureBeingApproved(request))) {
          // This Service Will invalidate the Approval and call Post event to update the event and
          // event_person_link table if the post event fails then both
          // will be rolled back. This way the transaction will be rolled back
          // and event statuses will keep in synch.
         CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
         invalidateApproval.invalidateApproval(ccmn05ui);
        }
      }      
      if (DELETE.equals(method)) {
        idEvent = assessment.deleteSafetyPlan(safetyPlanSaveSI);
      } else {
        idEvent = assessment.saveSafetyPlan(safetyPlanSaveSI);
      }
      
      state.removeAttribute(DELETE_SAFETY_FACTOR_LIST, request);
      state.removeAttribute(CASE_PERSON_RESPONSIBLE_LIST, request);
      state.removeAttribute(ROWCCMN45DO, request);
    } catch (ServiceException se) {
      handleException(se, context);
    } 
    try{
      if(CodesTables.CEVTSTAT_PEND.equals(eStatus) && isApproval && SAVE.equals(method)){
        PageMode.setPageMode(PageModeConstants.EDIT, request);
        GlobalData.setUlIdEvent(idEvent, request);
        forward("/investigation/SafetyPlan/displaySafetyPlan", request, context.getResponse());
      }
    }catch (ServletException  se){
      processSevereException(context, se);
    }
  return idEvent;

  }

  /**
   * This helper method is called by the displaySafetyPlan_xa to populate the input object for the csub59s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private static SafetyPlanRetrieveSI populateSafetyPalnRetrieveSI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG,
                                                                    " populateSafetyPalnRetrieveSI_Retrieve()");

    HttpServletRequest request = context.getRequest();

    SafetyPlanRetrieveSI safetyPlanRetrieveSI = new SafetyPlanRetrieveSI();

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    String pageMode = PageMode.getPageMode(request);

    int idStage = GlobalData.getUlIdStage(request);
    safetyPlanRetrieveSI.setUlIdStage(idStage);
    if (pageMode.equals(PageModeConstants.NEW)) {
      // PageMode.setPageMode(PageModeConstants.EDIT, request);
      safetyPlanRetrieveSI.setUlIdEvent(0);
    } else {
      int idEvent = GlobalData.getUlIdEvent(request);

      safetyPlanRetrieveSI.setUlIdEvent(idEvent);

    }

    performanceTrace.exitScope();
    return safetyPlanRetrieveSI;
  }

  /**
   * This helper method is called by the deleteSafetyPlan_xa to populate the input object for saveSafetyPlan service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  @SuppressWarnings("unchecked")
  private static SafetyPlanRetrieveSO populateSafetyPalnRetrieveSI_Delete(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG,
                                                                    " populateSafetyPalnRetrieveSI_Retrieve()");

    BaseSessionStateManager state = getSessionStateManager(context);
    SafetyPlanRetrieveSO safetyPlanRetrieveSO = new SafetyPlanRetrieveSO();
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    int idEvent = GlobalData.getUlIdEvent(request);
    int idCase = GlobalData.getUlIdCase(request);

    List<Integer> delete_SafetyFactor_List = (List<Integer>) state.getAttribute(DELETE_SAFETY_FACTOR_LIST, request);

    int deleteIndex = ContextHelper.getIntSafe(request, "deleteFactorArrayIndex");

    try {

      safetyPlanRetrieveSO.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsSafetyPlanLastUpdate"));
      safetyPlanRetrieveSO.setUlIdCase(idCase);
      safetyPlanRetrieveSO.setUlIdEvent(idEvent);
      safetyPlanRetrieveSO.setDtDiscWithCrtkr(ContextHelper.getJavaDateSafe(request, "dtDiscWithCrtkr"));
      safetyPlanRetrieveSO.setIndCrtkrAgreesSp(ContextHelper.getStringSafe(request, "rbCareTaker"));

      List<SafetyFactorSO> safetyFactorSOList = new ArrayList<SafetyFactorSO>();

      int factorRow = ContextHelper.getIntSafe(request, FACTOR_ROWS_COUNT);

      ROWCCMN45DO rowccmn45do = (ROWCCMN45DO) state.getAttribute(ROWCCMN45DO, request);

      safetyPlanRetrieveSO.setRowccmn45do(rowccmn45do);

      List<RowCasePersonResponsible> casePersonResponsible = (List<RowCasePersonResponsible>) state
                                                                                                   .getAttribute(
                                                                                                                 CASE_PERSON_RESPONSIBLE_LIST,
                                                                                                                 request);
      safetyPlanRetrieveSO.setCasePersonResponsibleList(casePersonResponsible);

      for (int i = 1; i <= factorRow; i++) {

        int idSftyFctr = ContextHelper.getIntSafe(request, "idSftyFctr" + i);
        // Do not need to read the request for this factor because this factor is deleted.
        if (i == deleteIndex) {
          if (idSftyFctr != 0) {
            delete_SafetyFactor_List.add(ContextHelper.getIntSafe(request, "idSftyFctr" + i));
          }

        } else {
          SafetyFactorSO safetyFactorSO = new SafetyFactorSO();
          safetyFactorSO.setIdSftyFctr(idSftyFctr);
          safetyFactorSO.setDtCompltdBy(ContextHelper.getJavaDateSafe(request, "dtToBeCompletedBy" + i));
          safetyFactorSO.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsSafetyFactorLastUpdate" + i));
          safetyFactorSO.setNmFirstOthrResp(ContextHelper.getStringSafe(request, "txtFirst" + i));
          safetyFactorSO.setNmLastOthrResp(ContextHelper.getStringSafe(request, "txtLast" + i));
          safetyFactorSO.setNmMiddleOthrResp(ContextHelper.getStringSafe(request, "txtMiddle" + i));

          safetyFactorSO.setSzTxtDescActions(ContextHelper.getStringSafe(request, "txtActions" + i));
          safetyFactorSO.setSzTxtSftyFctrComments(ContextHelper.getStringSafe(request, "txtComments" + i));
          safetyFactorSO.setSzTxtSftyFctrDesc(ContextHelper.getStringSafe(request, "txtSafetyFactor" + i));
          safetyFactorSO.setSzTxtSftyFctrMitigate(ContextHelper.getStringSafe(request,
                                                                              "txtChangetoMitigateSafetyFactor" + i));

          String[] chkPersonResponsibleList = null;
          chkPersonResponsibleList = CheckboxHelper.getCheckedValues(request, "chkRespPerson" + i);

          List<PersonResonsibleSO> personResponsibleList = new ArrayList<PersonResonsibleSO>();
          int idPerson = 0;

          for (int j = 0; j < chkPersonResponsibleList.length; j++) {
            idPerson = Integer.valueOf(chkPersonResponsibleList[j]);
            PersonResonsibleSO personResonsibleSO = new PersonResonsibleSO();
            personResonsibleSO.setIdPerson(idPerson);
            personResponsibleList.add(personResonsibleSO);
          }

          safetyFactorSO.setPersonResonsibleList(personResponsibleList);
          safetyFactorSOList.add(safetyFactorSO);

        }
        safetyPlanRetrieveSO.setSafetyFactorList(safetyFactorSOList);
      }
      state.setAttribute(DELETE_SAFETY_FACTOR_LIST, delete_SafetyFactor_List, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return safetyPlanRetrieveSO;

  }

  /**
   * This helper method is called by the displayDocument_xa to populate the input object for the csub60s save service.
   * 
   * @param context
   *          The GrndeExchangeContext
   * @param eventType
   *          String, event type
   * @param eventDescription
   *          a string, event description
   */
  @SuppressWarnings("unchecked")
  private static SafetyPlanRetrieveSO populateSafetyPalnRetrieveSI_Add(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "populateSafetyPalnRetrieveSI_Add");

    BaseSessionStateManager state = getSessionStateManager(context);
    SafetyPlanRetrieveSO safetyPlanRetrieveSO = new SafetyPlanRetrieveSO();
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    int idEvent = GlobalData.getUlIdEvent(request);
    int idCase = GlobalData.getUlIdCase(request);
    try {

      safetyPlanRetrieveSO.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsSafetyPlanLastUpdate"));
      safetyPlanRetrieveSO.setUlIdCase(idCase);
      safetyPlanRetrieveSO.setUlIdEvent(idEvent);
      safetyPlanRetrieveSO.setDtDiscWithCrtkr(ContextHelper.getJavaDateSafe(request, "dtDiscWithCrtkr"));
      safetyPlanRetrieveSO.setIndCrtkrAgreesSp(ContextHelper.getStringSafe(request, "rbCareTaker"));

      List<SafetyFactorSO> safetyFactorSOList = new ArrayList<SafetyFactorSO>();

      int factorRow = ContextHelper.getIntSafe(request, FACTOR_ROWS_COUNT);

      ROWCCMN45DO rowccmn45do = (ROWCCMN45DO) state.getAttribute(ROWCCMN45DO, request);

      safetyPlanRetrieveSO.setRowccmn45do(rowccmn45do);

      List<RowCasePersonResponsible> casePersonResponsible = (List<RowCasePersonResponsible>) state
                                                                                                   .getAttribute(
                                                                                                                 CASE_PERSON_RESPONSIBLE_LIST,
                                                                                                                 request);
      safetyPlanRetrieveSO.setCasePersonResponsibleList(casePersonResponsible);

      for (int i = 1; i <= factorRow; i++) {
        SafetyFactorSO safetyFactorSO = new SafetyFactorSO();
        safetyFactorSO.setIdSftyFctr(ContextHelper.getIntSafe(request, "idSftyFctr" + i));
        safetyFactorSO.setDtCompltdBy(ContextHelper.getJavaDateSafe(request, "dtToBeCompletedBy" + i));
        safetyFactorSO.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsSafetyFactorLastUpdate" + i));
        safetyFactorSO.setNmFirstOthrResp(ContextHelper.getStringSafe(request, "txtFirst" + i));
        safetyFactorSO.setNmLastOthrResp(ContextHelper.getStringSafe(request, "txtLast" + i));
        safetyFactorSO.setNmMiddleOthrResp(ContextHelper.getStringSafe(request, "txtMiddle" + i));

        safetyFactorSO.setSzTxtDescActions(ContextHelper.getStringSafe(request, "txtActions" + i));
        safetyFactorSO.setSzTxtSftyFctrComments(ContextHelper.getStringSafe(request, "txtComments" + i));
        safetyFactorSO.setSzTxtSftyFctrDesc(ContextHelper.getStringSafe(request, "txtSafetyFactor" + i));
        safetyFactorSO.setSzTxtSftyFctrMitigate(ContextHelper.getStringSafe(request, "txtChangetoMitigateSafetyFactor"
                                                                                     + i));

        String[] chkPersonResponsibleList = null;
        chkPersonResponsibleList = CheckboxHelper.getCheckedValues(request, "chkRespPerson" + i);

        List<PersonResonsibleSO> personResponsibleList = new ArrayList<PersonResonsibleSO>();
        int idPerson = 0;

        for (int j = 0; j < chkPersonResponsibleList.length; j++) {
          idPerson = Integer.valueOf(chkPersonResponsibleList[j]);
          PersonResonsibleSO personResonsibleSO = new PersonResonsibleSO();
          personResonsibleSO.setIdPerson(idPerson);
          personResponsibleList.add(personResonsibleSO);
        }
        safetyFactorSO.setPersonResonsibleList(personResponsibleList);
        safetyFactorSOList.add(safetyFactorSO);

      }
      // Add blank object
      safetyFactorSOList.add(new SafetyFactorSO());
      safetyPlanRetrieveSO.setSafetyFactorList(safetyFactorSOList);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return safetyPlanRetrieveSO;
  }

  /**
   * This helper method is called by the saveSafetyPlan_xa to populate the input object for the saveSafetyPlan service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  @SuppressWarnings("unchecked")
  private static SafetyPlanSaveSI populateSafetyPalnRetrieveSI__Update(GrndsExchangeContext context, String method) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "populateCSUB60SI_Update()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    int idStage = GlobalData.getUlIdStage(request);
    int idCase = GlobalData.getUlIdCase(request);
    boolean isApproval = GlobalData.isApprovalMode(request);

    List<Integer> delete_SafetyFactor_List = (List<Integer>) state.getAttribute(DELETE_SAFETY_FACTOR_LIST, request);

    SafetyPlanSaveSI safetyPlanSaveSI = new SafetyPlanSaveSI();

    String funcCd = null;
    String pageMode = PageMode.getPageMode(request);
    if (pageMode.equals(PageModeConstants.CREATE)) {
      safetyPlanSaveSI.setUlIdEvent(0);
      funcCd = ServiceConstants.REQ_FUNC_CD_ADD;
    } else if (pageMode.equals(PageModeConstants.EDIT)) {
      funcCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    if (DELETE.equals(method)) {
      funcCd = ServiceConstants.REQ_FUNC_CD_DELETE;
    }

    try {
      // safety Plan event
      ROWCCMN01UIG00 safetyPlanEvent = new ROWCCMN01UIG00();
      if (SUBMIT.equals(method) || (SAVE.equals(method) && isApproval)) {
        safetyPlanEvent.setSzCdEventStatus(EVENT_STATUS_PEND);
        safetyPlanEvent.setSzCdEventType(SPL_EVENT_TYPE);
        safetyPlanEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        safetyPlanEvent.setUlIdStage(idStage);
        safetyPlanEvent.setUlIdPerson(user.getUserID());
        safetyPlanEvent.setSzTxtEventDescr(EVENT_DESC_SPL);
        safetyPlanEvent.setSzCdTask(GlobalData.getSzCdTask(request));
        safetyPlanEvent.setUlIdEvent(idEvent);
        safetyPlanEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsEventLastUpdate"));
      } else {
        safetyPlanEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
        safetyPlanEvent.setSzCdEventType(SPL_EVENT_TYPE);
        safetyPlanEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        safetyPlanEvent.setUlIdStage(idStage);
        safetyPlanEvent.setUlIdPerson(user.getUserID());
        safetyPlanEvent.setSzTxtEventDescr(EVENT_DESC_SPL);
        safetyPlanEvent.setSzCdTask(GlobalData.getSzCdTask(request));
        safetyPlanEvent.setUlIdEvent(idEvent);
        safetyPlanEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsEventLastUpdate"));
      }
      safetyPlanSaveSI.setROWCCMN01UIG00(safetyPlanEvent);
      safetyPlanSaveSI.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsSafetyPlanLastUpdate"));
      safetyPlanSaveSI.setUlIdCase(idCase);
      safetyPlanSaveSI.setUlIdStage(idStage);
      safetyPlanSaveSI.setUlIdEvent(idEvent);
      safetyPlanSaveSI.setCdReqFuncCd(funcCd);
      safetyPlanSaveSI.setDtDiscWithCrtkr(ContextHelper.getJavaDateSafe(request, "dtDiscWithCrtkr"));
      safetyPlanSaveSI.setIndCrtkrAgreesSp(ContextHelper.getStringSafe(request, "rbCareTaker"));

      List<SafetyFactorSO> SafetyFactorSOList = new ArrayList();

      int factorRow = ContextHelper.getIntSafe(request, FACTOR_ROWS_COUNT);

      for (int i = 1; i <= factorRow; i++) {
        SafetyFactorSO safetyFactorSO = new SafetyFactorSO();
        safetyFactorSO.setIdSftyFctr(ContextHelper.getIntSafe(request, "idSftyFctr" + i));
        safetyFactorSO.setDtCompltdBy(ContextHelper.getJavaDateSafe(request, "dtToBeCompletedBy" + i));
        safetyFactorSO.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtTsSafetyFactorLastUpdate" + i));
        safetyFactorSO.setNmFirstOthrResp(ContextHelper.getStringSafe(request, "txtFirst" + i));
        safetyFactorSO.setNmLastOthrResp(ContextHelper.getStringSafe(request, "txtLast" + i));
        safetyFactorSO.setNmMiddleOthrResp(ContextHelper.getStringSafe(request, "txtMiddle" + i));

        safetyFactorSO.setSzTxtDescActions(ContextHelper.getStringSafe(request, "txtActions" + i));
        safetyFactorSO.setSzTxtSftyFctrComments(ContextHelper.getStringSafe(request, "txtComments" + i));
        safetyFactorSO.setSzTxtSftyFctrDesc(ContextHelper.getStringSafe(request, "txtSafetyFactor" + i));
        safetyFactorSO.setSzTxtSftyFctrMitigate(ContextHelper.getStringSafe(request, "txtChangetoMitigateSafetyFactor"
                                                                                     + i));

        String[] chkPersonResponsibleList = null;
        chkPersonResponsibleList = CheckboxHelper.getCheckedValues(request, "chkRespPerson" + i);

        List<PersonResonsibleSO> personResponsibleList = new ArrayList<PersonResonsibleSO>();
        int idPerson = 0;

        for (int j = 0; j < chkPersonResponsibleList.length; j++) {
          idPerson = Integer.valueOf(chkPersonResponsibleList[j]);
          PersonResonsibleSO personResonsibleSO = new PersonResonsibleSO();
          personResonsibleSO.setIdPerson(idPerson);
          personResponsibleList.add(personResonsibleSO);
        }

        safetyFactorSO.setPersonResonsibleList(personResponsibleList);

        SafetyFactorSOList.add(safetyFactorSO);

      }
      safetyPlanSaveSI.setSafetyFactorList(SafetyFactorSOList);

      safetyPlanSaveSI.setDeletedFactorList(delete_SafetyFactor_List);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return safetyPlanSaveSI;
  }

  private CCMN05UI populateCCMN05UI_InvalidateApproval(int idEvent) {

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    ccmn05ui.setUlIdEvent(idEvent);
    ccmn05ui.setArchInputStruct(input);

    return ccmn05ui;
  }
  
  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param e
   *          The Exception
   * @param methodName
   *          A String containing the method which threw the exception
   */
  private void handleException(ServiceException we, GrndsExchangeContext context) {
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
