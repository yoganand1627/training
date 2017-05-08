package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.AgeCitizenshipDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.EventUtility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.service.fce.FosterCareReview;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgeCitizenshipSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgeCitizenshipSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

/**
 * Handles page flow and calls necessary logic for FosterCareReview.jsp
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 05/09/05  NALLAVS      SIR 23547 - Removed System.out.println statements.
 * 02/12/11  Hai Nguyen   SMS#96233: Updated logic to do determination on page display.
 *                        Updated logic to move event to APRV if no longer appropriate.
 * 02/16/11  Hai Nguyen   SMS#96233: Updated to sync Reimbursability until event is APRV
 *                        and display Eligibility Summary List if reimbursability has no
 *                        longer appropriate checked and user clicked Continue.
 * </pre>
 */
public class FosterCareReviewConversation extends BaseHiddenFieldStateConversation {
  public static final String FC_REVIEW_DISPLAY = getUrl("displayFosterCareReview");
  public static final String FC_REVIEW_SAVE = getUrl("saveReview");
  public static final String FC_REVIEW_DELETE_INCOME = getUrl("deleteIncome");
  public static final String FC_REVIEW_DELETE_RESOURCE = getUrl("deleteResource");
  public static final String TRACE_TAG = "FosterCareReviewConversation";
  protected static final String CONVERSATION_URL = "/fce/FosterCareReview/";

  public static final String CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE = "_CHILD_INCOME_";
  public static final String CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE = "_CHILD_RESOURCE_";

  public static final String DISPLAY_COMMAND = CONVERSATION_URL + "displayFosterCareReview";
  public static final String DISPLAY_PERSON_DETAIL_COMMAND = CONVERSATION_URL + "displayPersonDetail";
  public static final String SUBMIT_APPLICATION_COMMAND = CONVERSATION_URL + "submitApplication";
  public static final String INCOME_EXPENDITURES_BEAN_NAME = "IncomeExpenditures";
  public static final String TXT_TODO_DESC = "Foster Care Reimbursability Determination has been assigned for review.";

  public static final String YES = ArchitectureConstants.Y;
  public static final String NO = ArchitectureConstants.N;
  public static final String NA = "A";

  public static final String FCREVIEWDB = "fosterCareReviewDB";
  public static final String STAGE_CLOSURE_EVENT_ID = "STAGE_CLOSURE_EVENT_ID";

  public static final String EVENT_STATUS_APRV = EventHelper.APPROVED_EVENT;
  public static final String EVENT_STATUS_COMP = EventHelper.COMPLETE_EVENT;
  public static final String EVENT_STATUS_PEND = EventHelper.PENDING_EVENT;
  public static final String EVENT_STATUS_PROC = EventHelper.PROCESS_EVENT;
  public static final String EVENT_STATUS_NEW = EventHelper.NEW_EVENT;

  public static final String FOSTER_CARE_REVIEW_JNDI_NAME = "FosterCareReview";
  public static final String ALREADY_CHECKED_LEGACY = "AlreadyCheckedLegacyApplication";

  protected static final String BRANCH_LEGACY_APPLICATION = "LegacyApplication";
  protected static final String BRANCH_EVENT_LIST = "EventList";
  protected static final String BRANCH_CLOSE_REVIEW = "CloseReview";
  
  public static final String FCE_ELIGIBILITY_EVENT_TYPE = "FCD";
  public static final String FCE_ELIGIBILITY_TASK_CODE = "3120";
  
  private EventUtility eventUtility;
  private FosterCareReview fosterCareReview;
  private Person person;
  private Fce fce;
  private Admin admin = null;
  
  // initialize admin
  public void setAdmin(Admin objAdmin) {
    this.admin = objAdmin;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setFce(Fce fce) {
    this.fce = fce;
  }

  public void setEventUtility(EventUtility eventUtility) {
    this.eventUtility = eventUtility;
  }

  public void setFosterCareReview(FosterCareReview fosterCareReview) {
    this.fosterCareReview = fosterCareReview;
  }

  /** Determines whether foster care review or legacy application page displays */
  public void displayFosterCareReview_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayFosterCareReview_xa");

    HttpServletRequest request = context.getRequest();

    try {
      trace("displayFosterCareReview_xa");
      clearState(context);

      //This is to make the navigation (banner) happy
      GlobalData.setSzCdTask(null, request);
      
      FosterCareReviewDB fosterCareReviewDB = fosterCareReview.read(GlobalData.getUlIdStage(request),
                                                                    GlobalData.getUlIdEvent(request),
                                                                    getUserID(request), null);

      GlobalData.setUlIdEvent((int) fosterCareReviewDB.getIdEvent(), request);

    } catch (Exception e) {
      processException(context, e);
    }
    performanceTrace.exitScope();
  }

  /** Display for Foster Care Review page */
  public void displayFosterCareReview2_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayFosterCareReview2_xa");

    HttpServletRequest request = context.getRequest();

    try {
      trace("displayFosterCareReview2_xa");

      //This is to make the navigation (banner) happy
      GlobalData.setSzCdTask(null, request);
      
      FosterCareReviewDB fosterCareReviewDB = fosterCareReview.read(GlobalData.getUlIdStage(request),
                                                                    GlobalData.getUlIdEvent(request),
                                                                    getUserID(request), null);

      if (EventHelper.APPROVED_EVENT.equals(fosterCareReviewDB.getCdEventStatus()) == false) {
        // in case this is a new reimbursability and does not initially have
        // idLastUpdatePerson set, which will cause an exception in
        // call to fosterCareReview.save() via determineEligibility.
        if( fosterCareReviewDB.getIdLastUpdatePerson() == 0 ){
          fosterCareReviewDB.setIdLastUpdatePerson(getUserID(request));
        }
        fosterCareReview.determineEligibility(fosterCareReviewDB);
        // do another read to refresh DB object before setting to state
        fosterCareReviewDB = fosterCareReview.read(GlobalData.getUlIdStage(request),
                                                                      GlobalData.getUlIdEvent(request),
                                                                      getUserID(request), null);
      }

      BaseSessionStateManager state = getSessionStateManager(context);
      state.setAttribute("FosterCareReviewDB", fosterCareReviewDB, request);

      FceUtility.setReviewFceTabState(request, false);

      boolean showAttentionMessages = true;
      if ((EventHelper.COMPLETE_EVENT.equals(fosterCareReviewDB.getCdEventStatus())) &&
          (fosterCareReviewDB.getIndReviewInappropriate() == false)) {
        showAttentionMessages = false;
      }

      if (showAttentionMessages) {
        if (fosterCareReviewDB.getIndNoActivePlacement()) {
          setInformationalMessage(Messages.MSG_CHILD_NO_PLACEMENT, request);
        }
        if (fosterCareReviewDB.getIndNonPrsPaidPlacement()) {
          setInformationalMessage(Messages.MSG_CHILD_NON_PRS_PAID_PLACEMENT, request);
        }
        if (fosterCareReviewDB.getIndNoActiveBloc()) {
          setInformationalMessage(Messages.MSG_CHILD_NO_BLOC, request);
        }
        if (fosterCareReviewDB.getIndNoOpenPaidEligibility()) {
          setInformationalMessage(Messages.MSG_CHILD_NON_PRS_PAID_ELIGIBILITY, request);
        }
        if (fosterCareReviewDB.getIndMultipleActivePlacements()) {
          setInformationalMessage(Messages.MSG_CHILD_MULTIPLE_PLACEMENTS, request);
        }
      }
    
      String pageMode = FceUtility.getFceReviewPageMode(request, fosterCareReviewDB);

      PageMode.setPageMode(pageMode, request);

      int closureEvent = CaseUtility.getPendingStageClosureEvent((int) fosterCareReviewDB.getIdStage());
      request.setAttribute(STAGE_CLOSURE_EVENT_ID, closureEvent);

      trace("displayFosterCareReview2_xa: " + fosterCareReviewDB);
    } catch (Exception e) {
      processException(context, e);
    }
    performanceTrace.exitScope();
  }

  /** saves the review */
  public void saveReview_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "saveReview_xa");

    Connection connection = null;
    try {
      connection = JdbcHelper.getConnection();
      HttpServletRequest request = context.getRequest();

      BaseSessionStateManager state = getSessionStateManager(request);

      FosterCareReviewDB fosterCareReviewDB = read(context);
      clearState(context);

      fosterCareReview.save(fosterCareReviewDB);
      
      long unApprovedEvents = EventHelper.countUnApprovedEvents(connection , FCE_ELIGIBILITY_TASK_CODE, GlobalData.getUlIdStage(request));
      if (unApprovedEvents == 0) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_FCE_CHILD_NON_DFCS_PAID_ELIGIBILITY), request);
      }
      
    } catch (Exception e) {
      processException(context, e);
    } finally {
      cleanup(connection);
    }
    performanceTrace.exitScope();
  }

  /** check to make sure the application is "complete" before creating a todo to give the eligibility specialist */
  public void submitReview_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "submitReview_xa");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FosterCareReviewDB fosterCareReviewDB = read(context);
      clearState(context);

      if (closeFosterCareReview(fosterCareReviewDB)) {
        GlobalData.setSzCdTask(FCE_ELIGIBILITY_TASK_CODE, request);
        setPresentationBranch(BRANCH_CLOSE_REVIEW, context);
        return;
      }
      fosterCareReview.submit(fosterCareReviewDB);

      int eventId = GlobalData.getUlIdEvent(request);

      int caseId = GlobalData.getUlIdCase(request);
      int stageId = GlobalData.getUlIdStage(request);

      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(TXT_TODO_DESC, eventId, caseId, stageId, EventHelper.FCE_REVIEW_TASK_CODE);

      toDoDetailDB.setUlIdEvent(eventId);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    } catch (Exception e) {
      processException(context, e);
    }
    performanceTrace.exitScope();
  }

  /** close the review prematurely.  sets event status to COMP */
  protected boolean closeFosterCareReview(FosterCareReviewDB fosterCareReviewDB)
          throws RemoteException, EjbValidationException {
    if (fosterCareReviewDB.getIndReviewInappropriate() == false) {
      return false;
    }
    // set completion date, then close out
    fosterCareReviewDB.setDtReviewComplete(new java.util.Date());
    fosterCareReview.closeEligibility(fosterCareReviewDB);

    return true;
  }

  /** on Click 'Continue' */
  public void confirmYes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "confirmYes_xa");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    try {
      FosterCareReviewDB fosterCareReviewDB = read(context);
      clearState(context);

      fosterCareReviewDB.setIdLastUpdatePerson(getUserID(request));

      if (closeFosterCareReview(fosterCareReviewDB)) {
        GlobalData.setSzCdTask(FCE_ELIGIBILITY_TASK_CODE, request);
        setPresentationBranch(BRANCH_CLOSE_REVIEW, context);
        return;
      }

      long idEligibilityEvent = fosterCareReview.confirm(fosterCareReviewDB);
      GlobalData.setUlIdEvent((int) idEligibilityEvent, request);

      //in case eligibility specialist got this far with only a todo
      //create a new override so he can edit a new eligibility summary
      ToDoHelper.setPageModeEditOverride(request, EventHelper.FCE_ELIGIBILITY_TASK_CODE, GlobalData.getUlIdStage(
              request), (int) idEligibilityEvent);

      //!!! 08/2/2003, Matthew McClain, I'm a little concerned if this fails
      // Check for pending stage closure and invalidate if found
      int pendingStageClosure = ContextHelper.getIntSafe(request, "hdnPendingStageClosureEventId");
      if (pendingStageClosure > 0) {
        eventUtility.invalidatePendingStageClosure(pendingStageClosure, admin);
      }
    } catch (Exception e) {
      processException(context, e);
    }
    performanceTrace.exitScope();
  }

  /** Autosaves, then forwards to person detail (for the child) */
  public void displayPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      FosterCareReviewDB fosterCareReviewDB = read(context);
      String pageMode = PageMode.getPageMode(request);

      clearState(context);

      if (PageModeConstants.EDIT.equals(pageMode)) {
        fosterCareReview.save(fosterCareReviewDB);
      }

      // Set any information that needs to go into GlobalData for PersonDetail page.
      //  Event List should have already provided stage code and program code.
      GlobalData.setUlIdPerson((int) fosterCareReviewDB.getIdPerson(), request);

      PersonHelper.setPersonDetailPageMode(request, PageModeConstants.EDIT);
    } catch (Exception e) {
      processException(context, e);
    }
    performanceTrace.exitScope();
  }

  /** standard FCE Review exception handling */
  protected void processException(GrndsExchangeContext context, Exception exception) {
    try {
      if (exception instanceof EjbValidationException) {
        EjbValidationException ejbValidationException = (EjbValidationException) exception;
        HttpServletRequest request = context.getRequest();
        int errorCode = ejbValidationException.getErrorCode();
        switch (errorCode) {
          case Messages.MSG_FCE_CHILD_NON_DFCS_PAID_ELIGIBILITY:
          case Messages.MSG_NO_APPLICATION_REVIEW_NOT_AVAILABLE:
          case Messages.MSG_NO_SUMMARY_REVIEW_NOT_AVAILABLE:
            //replace, because display of review clears it
            GlobalData.setSzCdTask(EventHelper.FCE_REVIEW_TASK_CODE, request);
            int[] errors = new int[] {errorCode};
            ErrorList.setErrors(errors, request);
            setPresentationBranch(BRANCH_EVENT_LIST, context);
            return;
          default:
            setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);

            //This doesn't refresh the html widgets from the request like setErrorMessage
            //which means that the timestamp will be correct in the page so someone
            // can make changes and resave
            addErrorMessage(ejbValidationException.getErrorMessage(), request);
            return;
        }
      }
      processSevereException(context, exception);
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }

  /**
   * Used to get a copy of FosterCareReviewDB out of state and fill in new request parameters. used by
   * FosterCareReviewCustomValidation too
   */
  public static FosterCareReviewDB read(GrndsExchangeContext context) throws PopulationException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    FosterCareReviewDB fosterCareReviewDB = (FosterCareReviewDB) state.getAttribute("FosterCareReviewDB", request);

    populateWithRequest(fosterCareReviewDB, request);
    FceEligibilityDB fceEligibilityDB = fosterCareReviewDB.getFceEligibility();
    fosterCareReviewDB.setFceEligibility(fceEligibilityDB);

    fosterCareReviewDB.setIdLastUpdatePerson(getUserID(request));
    fosterCareReviewDB = populateIncomesAndResources(context, fosterCareReviewDB);

    return fosterCareReviewDB;
  }

  /** Loops through the child's resources checking to see if a Child's Savings Account 
    * or a standard Savings Account exist */
  public static boolean hasChildsSavingsAccountResource(FosterCareReviewDB fosterCareReviewDB) {
    String CHILDS_SAVINGS_ACCOUNT = CodesTables.CRSRC_CSV;
    String SAVINGS_ACCOUNT = CodesTables.CRSRC_SAV;

    List list = fosterCareReviewDB.getResourcesForChild();
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      if (CHILDS_SAVINGS_ACCOUNT.equals(fceIncomeDB.getCdType()) ||
          SAVINGS_ACCOUNT.equals(fceIncomeDB.getCdType())) {
        return true;
      }
    }
    return false;
  }

  /** Loops through the child's resources adding up all countable income amounts */
  public static double getCountableResourceAmount(FosterCareReviewDB fosterCareReviewDB) {
    double amount = 0.;

    List list = fosterCareReviewDB.getResourcesForChild();
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      if (fceIncomeDB.getIndCountable()) {
        amount += fceIncomeDB.getAmtIncome();
      }
    }
    return amount;
  }

  /** fill in income/resource amounts on databean */
  protected static FosterCareReviewDB populateIncomesAndResources(GrndsExchangeContext context,
                                                                  FosterCareReviewDB fosterCareReviewDB)
          throws PopulationException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateIncomesAndResources()");

    HttpServletRequest request = context.getRequest();

    if (fosterCareReviewDB == null) {
      throw new PopulationException("fosterCareReviewDB is null.");
    }

    // Need to populate FceIncome objects for income and resources for principles
    List childIncomes = fosterCareReviewDB.getIncomeForChild();
    if (childIncomes != null) {
      IncomeExpendituresConversation
              .populateIncomesWithRequest(childIncomes, CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE, request);

      //this strictly shouldn't be necessary
      fosterCareReviewDB.setIncomeForChild(childIncomes);
    }
    List childResources = fosterCareReviewDB.getResourcesForChild();
    if (childResources != null) {
      IncomeExpendituresConversation
              .populateResourcesWithRequest(childResources, CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE, request);

      //this strictly shouldn't be necessary
      fosterCareReviewDB.setResourcesForChild(childResources);
    }

    performanceTrace.exitScope();
    return fosterCareReviewDB;
  }

  /** Allows me to optionally print to System.out as well as to impact-trace.log */
  protected static final void trace(String string) {
    FceUtility.trace(TRACE_TAG, string);
  }

  /** Appends pageName to CONVERSATION_URL */
  protected static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }

  public static FosterCareReviewDB readFromRequest(HttpServletRequest request) {
    FosterCareReviewDB fosterCareReviewDB = new FosterCareReviewDB();
    populateWithRequest(fosterCareReviewDB, request);
    return fosterCareReviewDB;
  }
  
  /** The connection cleanup method */
  void cleanup(Connection connection) {
    GrndsTrace.enterScope(TRACE_TAG + ".cleanup() ");
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
      GrndsTrace.msg(TRACE_TAG + ".cleanup() ", 7, " ::Connection closed.");
    } catch (SQLException sEx) {
      ExceptionHandler.handle(sEx);
    }
    GrndsTrace.exitScope();
  }

  public static void populateWithRequest(FosterCareReviewDB fosterCareReviewDB, HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(FosterCareReviewDB.AMT_COUNTABLE_INCOME)) {
      fosterCareReviewDB.setAmtCountableIncome(ContextHelper.getDoubleSafe(request,
                                                                           FosterCareReviewDB.AMT_COUNTABLE_INCOME));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_COUNTABLE_INCOME_MONEY)) {
      fosterCareReviewDB.setAmtCountableIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                  FosterCareReviewDB.AMT_COUNTABLE_INCOME_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_FOSTER_CARE_RATE)) {
      fosterCareReviewDB.setAmtFosterCareRate(ContextHelper.getDoubleSafe(request,
                                                                          FosterCareReviewDB.AMT_FOSTER_CARE_RATE));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_FOSTER_CARE_RATE_MONEY)) {
      fosterCareReviewDB.setAmtFosterCareRate(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                 FosterCareReviewDB.AMT_FOSTER_CARE_RATE_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GROSS_EARNED_CRTFD_GRP)) {
      fosterCareReviewDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_GROSS_EARNED_CRTFD_GRP));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY)) {
      fosterCareReviewDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      FosterCareReviewDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GROSS_UNEARNED_CRTFD_GRP)) {
      fosterCareReviewDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                 FosterCareReviewDB.AMT_GROSS_UNEARNED_CRTFD_GRP));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY)) {
      fosterCareReviewDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        FosterCareReviewDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_INCOME_LIMIT)) {
      fosterCareReviewDB.setAmtIncomeLimit(ContextHelper.getDoubleSafe(request, FosterCareReviewDB.AMT_INCOME_LIMIT));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_INCOME_LIMIT_MONEY)) {
      fosterCareReviewDB.setAmtIncomeLimit(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                              FosterCareReviewDB.AMT_INCOME_LIMIT_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_PWE_INCOME)) {
      fosterCareReviewDB.setAmtPweIncome(ContextHelper.getDoubleSafe(request, FosterCareReviewDB.AMT_PWE_INCOME));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_PWE_INCOME_MONEY)) {
      fosterCareReviewDB.setAmtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                            FosterCareReviewDB.AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_SAVINGS)) {
      fosterCareReviewDB.setAmtSavings(ContextHelper.getDoubleSafe(request, FosterCareReviewDB.AMT_SAVINGS));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_SAVINGS_MONEY)) {
      fosterCareReviewDB.setAmtSavings(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                          FosterCareReviewDB.AMT_SAVINGS_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_SSI)) {
      fosterCareReviewDB.setAmtSsi(ContextHelper.getDoubleSafe(request, FosterCareReviewDB.AMT_SSI));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_SSI_MONEY)) {
      fosterCareReviewDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request, FosterCareReviewDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_ALIMONY)) {
      fosterCareReviewDB.setAmtStepparentAlimony(ContextHelper.getDoubleSafe(request,
                                                                             FosterCareReviewDB.AMT_STEPPARENT_ALIMONY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_ALIMONY_MONEY)) {
      fosterCareReviewDB.setAmtStepparentAlimony(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    FosterCareReviewDB.AMT_STEPPARENT_ALIMONY_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_ALLOWANCE)) {
      fosterCareReviewDB.setAmtStepparentAllowance(ContextHelper.getDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_STEPPARENT_ALLOWANCE));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_ALLOWANCE_MONEY)) {
      fosterCareReviewDB.setAmtStepparentAllowance(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      FosterCareReviewDB.AMT_STEPPARENT_ALLOWANCE_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_APPLIED_INCOME)) {
      fosterCareReviewDB.setAmtStepparentAppliedIncome(ContextHelper.getDoubleSafe(request,
                                                                                   FosterCareReviewDB.AMT_STEPPARENT_APPLIED_INCOME));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY)) {
      fosterCareReviewDB.setAmtStepparentAppliedIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          FosterCareReviewDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_CNTBL_UNEARNED)) {
      fosterCareReviewDB.setAmtStepparentCntblUnearned(ContextHelper.getDoubleSafe(request,
                                                                                   FosterCareReviewDB.AMT_STEPPARENT_CNTBL_UNEARNED));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY)) {
      fosterCareReviewDB.setAmtStepparentCntblUnearned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          FosterCareReviewDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_GROSS_EARNED)) {
      fosterCareReviewDB.setAmtStepparentGrossEarned(ContextHelper.getDoubleSafe(request,
                                                                                 FosterCareReviewDB.AMT_STEPPARENT_GROSS_EARNED));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_GROSS_EARNED_MONEY)) {
      fosterCareReviewDB.setAmtStepparentGrossEarned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        FosterCareReviewDB.AMT_STEPPARENT_GROSS_EARNED_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_OUTSIDE_PMNT)) {
      fosterCareReviewDB.setAmtStepparentOutsidePmnt(ContextHelper.getDoubleSafe(request,
                                                                                 FosterCareReviewDB.AMT_STEPPARENT_OUTSIDE_PMNT));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) {
      fosterCareReviewDB.setAmtStepparentOutsidePmnt(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        FosterCareReviewDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_TOTAL_CNTBL)) {
      fosterCareReviewDB.setAmtStepparentTotalCntbl(ContextHelper.getDoubleSafe(request,
                                                                                FosterCareReviewDB.AMT_STEPPARENT_TOTAL_CNTBL));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY)) {
      fosterCareReviewDB.setAmtStepparentTotalCntbl(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                       FosterCareReviewDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_WORK_DEDUCT)) {
      fosterCareReviewDB.setAmtStepparentWorkDeduct(ContextHelper.getDoubleSafe(request,
                                                                                FosterCareReviewDB.AMT_STEPPARENT_WORK_DEDUCT));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY)) {
      fosterCareReviewDB.setAmtStepparentWorkDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                       FosterCareReviewDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY));
    }
    if (map.containsKey(FosterCareReviewDB.CD_APPLICATION)) {
      fosterCareReviewDB.setCdApplication(ContextHelper.getStringSafe(request, FosterCareReviewDB.CD_APPLICATION));
    }
    if (map.containsKey(FosterCareReviewDB.CD_BLOC_CHILD)) {
      fosterCareReviewDB.setCdBlocChild(ContextHelper.getStringSafe(request, FosterCareReviewDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.CD_CHANGE_CTZN_STATUS)) {
      fosterCareReviewDB.setCdChangeCtznStatus(ContextHelper.getStringSafe(request,
                                                                           FosterCareReviewDB.CD_CHANGE_CTZN_STATUS));
    }
    if (map.containsKey(FosterCareReviewDB.CD_ELIGIBILITY_ACTUAL)) {
      fosterCareReviewDB.setCdEligibilityActual(ContextHelper.getStringSafe(request,
                                                                            FosterCareReviewDB.CD_ELIGIBILITY_ACTUAL));
    }
    if (map.containsKey(FosterCareReviewDB.CD_ELIGIBILITY_SELECTED)) {
      fosterCareReviewDB.setCdEligibilitySelected(ContextHelper.getStringSafe(request,
                                                                              FosterCareReviewDB.CD_ELIGIBILITY_SELECTED));
    }
    if (map.containsKey(FosterCareReviewDB.CD_EVENT_STATUS)) {
      fosterCareReviewDB.setCdEventStatus(ContextHelper.getStringSafe(request, FosterCareReviewDB.CD_EVENT_STATUS));
    }
    if (map.containsKey(FosterCareReviewDB.CD_LIVING_CONDITION_CURRENT)) {
      fosterCareReviewDB.setCdLivingConditionCurrent(ContextHelper.getStringSafe(request,
                                                                                 FosterCareReviewDB.CD_LIVING_CONDITION_CURRENT));
    }
    if (map.containsKey(FosterCareReviewDB.CD_LIVING_MONTH_REMOVAL)) {
      fosterCareReviewDB.setCdLivingMonthRemoval(ContextHelper.getStringSafe(request,
                                                                             FosterCareReviewDB.CD_LIVING_MONTH_REMOVAL));
    }
    if (map.containsKey(FosterCareReviewDB.CD_MEDICAID_ELIGIBILITY_TYPE)) {
      fosterCareReviewDB.setCdMedicaidEligibilityType(ContextHelper.getStringSafe(request,
                                                                                  FosterCareReviewDB.CD_MEDICAID_ELIGIBILITY_TYPE));
    }
    if (map.containsKey(FosterCareReviewDB.CD_PWE_IRREGULAR_UNDER100)) {
      fosterCareReviewDB.setCdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(FosterCareReviewDB.CD_PWE_STEADY_UNDER100)) {
      fosterCareReviewDB.setCdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                            FosterCareReviewDB.CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(FosterCareReviewDB.CD_RATE)) {
      fosterCareReviewDB.setCdRate(ContextHelper.getStringSafe(request, FosterCareReviewDB.CD_RATE));
    }
    if (map.containsKey(FosterCareReviewDB.CD_REL_INT)) {
      fosterCareReviewDB.setCdRelInt(ContextHelper.getStringSafe(request, FosterCareReviewDB.CD_REL_INT));
    }
    if (map.containsKey(FosterCareReviewDB.DT_BIRTH_STRING)) {
      fosterCareReviewDB.setDtBirthString(ContextHelper.getStringSafe(request, FosterCareReviewDB.DT_BIRTH_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_BIRTH_TIME)) {
      fosterCareReviewDB.setDtBirthTime(ContextHelper.getLongSafe(request, FosterCareReviewDB.DT_BIRTH_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_CHILD_CMPLT_HIGH_SCHOOL_STRING)) {
      fosterCareReviewDB.setDtChildCmpltHighSchoolString(ContextHelper.getStringSafe(request,
                                                                                     FosterCareReviewDB.DT_CHILD_CMPLT_HIGH_SCHOOL_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_CHILD_CMPLT_HIGH_SCHOOL_TIME)) {
      fosterCareReviewDB.setDtChildCmpltHighSchoolTime(ContextHelper.getLongSafe(request,
                                                                                 FosterCareReviewDB.DT_CHILD_CMPLT_HIGH_SCHOOL_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_CHILD_ENTER_HIGHER_STRING)) {
      fosterCareReviewDB.setDtChildEnterHigherString(ContextHelper.getStringSafe(request,
                                                                                 FosterCareReviewDB.DT_CHILD_ENTER_HIGHER_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_CHILD_ENTER_HIGHER_TIME)) {
      fosterCareReviewDB.setDtChildEnterHigherTime(ContextHelper.getLongSafe(request,
                                                                             FosterCareReviewDB.DT_CHILD_ENTER_HIGHER_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_ELIG_DTRMNTN_START_STRING)) {
      fosterCareReviewDB.setDtEligDtrmntnStartString(ContextHelper.getStringSafe(request,
                                                                                 FosterCareReviewDB.DT_ELIG_DTRMNTN_START_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_ELIG_DTRMNTN_START_TIME)) {
      fosterCareReviewDB.setDtEligDtrmntnStartTime(ContextHelper.getLongSafe(request,
                                                                             FosterCareReviewDB.DT_ELIG_DTRMNTN_START_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_ELIGIBILITY_END_STRING)) {
      fosterCareReviewDB.setDtEligibilityEndString(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.DT_ELIGIBILITY_END_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_ELIGIBILITY_END_TIME)) {
      fosterCareReviewDB.setDtEligibilityEndTime(ContextHelper.getLongSafe(request,
                                                                           FosterCareReviewDB.DT_ELIGIBILITY_END_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_REMOVAL_CHILD_ORDERED_STRING)) {
      fosterCareReviewDB.setDtRemovalChildOrderedString(ContextHelper.getStringSafe(request,
                                                                                    FosterCareReviewDB.DT_REMOVAL_CHILD_ORDERED_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_REMOVAL_CHILD_ORDERED_TIME)) {
      fosterCareReviewDB.setDtRemovalChildOrderedTime(ContextHelper.getLongSafe(request,
                                                                                FosterCareReviewDB.DT_REMOVAL_CHILD_ORDERED_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_REVIEW_COMPLETE_STRING)) {
      fosterCareReviewDB.setDtReviewCompleteString(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.DT_REVIEW_COMPLETE_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_REVIEW_COMPLETE_TIME)) {
      fosterCareReviewDB.setDtReviewCompleteTime(ContextHelper.getLongSafe(request,
                                                                           FosterCareReviewDB.DT_REVIEW_COMPLETE_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_REVIEW_DATE_STRING)) {
      fosterCareReviewDB.setDtReviewDateString(ContextHelper.getStringSafe(request,
                                                                           FosterCareReviewDB.DT_REVIEW_DATE_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_REVIEW_DATE_TIME)) {
      fosterCareReviewDB.setDtReviewDateTime(ContextHelper.getLongSafe(request,
                                                                       FosterCareReviewDB.DT_REVIEW_DATE_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_RIGHTS_TERMINATED_STRING)) {
      fosterCareReviewDB.setDtRightsTerminatedString(ContextHelper.getStringSafe(request,
                                                                                 FosterCareReviewDB.DT_RIGHTS_TERMINATED_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_RIGHTS_TERMINATED_TIME)) {
      fosterCareReviewDB.setDtRightsTerminatedTime(ContextHelper.getLongSafe(request,
                                                                             FosterCareReviewDB.DT_RIGHTS_TERMINATED_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING)) {
      fosterCareReviewDB.setDtRsnblEffortPreventRemString(ContextHelper.getStringSafe(request,
                                                                                      FosterCareReviewDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME)) {
      fosterCareReviewDB.setDtRsnblEffortPreventRemTime(ContextHelper.getLongSafe(request,
                                                                                  FosterCareReviewDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP)) {
      fosterCareReviewDB.setFceEligibilityCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                                          FosterCareReviewDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      fosterCareReviewDB.setFceEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                         FosterCareReviewDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      fosterCareReviewDB.setFceEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                     FosterCareReviewDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_PERSON_DT_LAST_UPDATE_STRING)) {
      fosterCareReviewDB.setFcePersonDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                    FosterCareReviewDB.FCE_PERSON_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_PERSON_DT_LAST_UPDATE_TIME)) {
      fosterCareReviewDB.setFcePersonDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                FosterCareReviewDB.FCE_PERSON_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_REVIEW_CD_PERSON_CITIZENSHIP)) {
      fosterCareReviewDB.setFceReviewCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                                     FosterCareReviewDB.FCE_REVIEW_CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_REVIEW_DT_LAST_UPDATE_STRING)) {
      fosterCareReviewDB.setFceReviewDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                    FosterCareReviewDB.FCE_REVIEW_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.FCE_REVIEW_DT_LAST_UPDATE_TIME)) {
      fosterCareReviewDB.setFceReviewDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                FosterCareReviewDB.FCE_REVIEW_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(FosterCareReviewDB.ID_CASE)) {
      fosterCareReviewDB.setIdCase(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_CASE));
    }
    if (map.containsKey(FosterCareReviewDB.ID_CURRENT_PLACEMENT_EVENT)) {
      fosterCareReviewDB.setIdCurrentPlacementEvent(ContextHelper.getLongSafe(request,
                                                                              FosterCareReviewDB.ID_CURRENT_PLACEMENT_EVENT));
    }
    if (map.containsKey(FosterCareReviewDB.ID_ELIGIBILITY_EVENT)) {
      fosterCareReviewDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request,
                                                                         FosterCareReviewDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(FosterCareReviewDB.ID_EVENT)) {
      fosterCareReviewDB.setIdEvent(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_EVENT));
    }
    if (map.containsKey(FosterCareReviewDB.ID_FCE_APPLICATION)) {
      fosterCareReviewDB.setIdFceApplication(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(FosterCareReviewDB.ID_FCE_ELIGIBILITY)) {
      fosterCareReviewDB.setIdFceEligibility(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(FosterCareReviewDB.ID_FCE_PERSON)) {
      fosterCareReviewDB.setIdFcePerson(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_FCE_PERSON));
    }
    if (map.containsKey(FosterCareReviewDB.ID_FCE_REVIEW)) {
      fosterCareReviewDB.setIdFceReview(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(FosterCareReviewDB.ID_LAST_UPDATE_PERSON)) {
      fosterCareReviewDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                         FosterCareReviewDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(FosterCareReviewDB.ID_PERSON)) {
      fosterCareReviewDB.setIdPerson(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_PERSON));
    }
    if (map.containsKey(FosterCareReviewDB.ID_PLACEMENT_RATE_EVENT)) {
      fosterCareReviewDB.setIdPlacementRateEvent(ContextHelper.getLongSafe(request,
                                                                           FosterCareReviewDB.ID_PLACEMENT_RATE_EVENT));
    }
    if (map.containsKey(FosterCareReviewDB.ID_STAGE)) {
      fosterCareReviewDB.setIdStage(ContextHelper.getLongSafe(request, FosterCareReviewDB.ID_STAGE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_ALTRNT_CUSTODY)) {
      fosterCareReviewDB.setIndAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_DEPORTED)) {
      fosterCareReviewDB.setIndAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                           FosterCareReviewDB.IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_DESERTED)) {
      fosterCareReviewDB.setIndAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                           FosterCareReviewDB.IND_ABSENT_DESERTED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_DIED)) {
      fosterCareReviewDB.setIndAbsentDied(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_ABSENT_DIED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_DIVORCED)) {
      fosterCareReviewDB.setIndAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                           FosterCareReviewDB.IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_FATHER)) {
      fosterCareReviewDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                         FosterCareReviewDB.IND_ABSENT_FATHER));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_HOSPITALIZED)) {
      fosterCareReviewDB.setIndAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_INCARCERATED)) {
      fosterCareReviewDB.setIndAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_MILITARY_WORK)) {
      fosterCareReviewDB.setIndAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_MOTHER)) {
      fosterCareReviewDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                         FosterCareReviewDB.IND_ABSENT_MOTHER));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_SEPARATED)) {
      fosterCareReviewDB.setIndAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                            FosterCareReviewDB.IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_WORK_RELATED)) {
      fosterCareReviewDB.setIndAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                              FosterCareReviewDB.IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CERTIFIED_GROUP)) {
      fosterCareReviewDB.setIndCertifiedGroup(ContextHelper.getBooleanSafe(request,
                                                                           FosterCareReviewDB.IND_CERTIFIED_GROUP));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_ACCPTD_HIGHER)) {
      fosterCareReviewDB.setIndChildAccptdHigher(ContextHelper.getBooleanSafe(request,
                                                                              FosterCareReviewDB.IND_CHILD_ACCPTD_HIGHER));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_CMPLT19)) {
      fosterCareReviewDB.setIndChildCmplt19(ContextHelper.getBooleanSafe(request,
                                                                         FosterCareReviewDB.IND_CHILD_CMPLT19));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CMPLT_SCHL_MAX_AGE)) {
      fosterCareReviewDB.setIndCmpltSchlMaxAge(ContextHelper.getBooleanSafe(request,
                                                                            FosterCareReviewDB.IND_CMPLT_SCHL_MAX_AGE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_ENROLLED)) {
      fosterCareReviewDB.setIndChildEnrolled(ContextHelper.getBooleanSafe(request,
                                                                          FosterCareReviewDB.IND_CHILD_ENROLLED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_INCOME_GT_FC_PAY)) {
      fosterCareReviewDB.setIndChildIncomeGtFcPay(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_CHILD_INCOME_GT_FC_PAY));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_LIVING_PRNT6_MNTHS)) {
      fosterCareReviewDB.setIndChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                  FosterCareReviewDB.IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_QUALIFIED_CITIZEN)) {
      fosterCareReviewDB.setIndChildQualifiedCitizen(ContextHelper.getBooleanSafe(request,
                                                                                  FosterCareReviewDB.IND_CHILD_QUALIFIED_CITIZEN));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_SUPPORT_ORDERED)) {
      fosterCareReviewDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_UNDER18)) {
      fosterCareReviewDB.setIndChildUnder18(ContextHelper.getBooleanSafe(request,
                                                                         FosterCareReviewDB.IND_CHILD_UNDER18));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_AMER_INDIAN_CRD)) {
      fosterCareReviewDB.setIndCtznshpAmerIndianCrd(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_AMER_INDIAN_CRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_ATTORNEY_REVIEW)) {
      fosterCareReviewDB.setIndCtznshpAttorneyReview(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_ATTORNEY_REVIEW));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_ABROAD)) {
      fosterCareReviewDB.setIndCtznshpBirthAbroad(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_BIRTH_ABROAD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR)) {
      fosterCareReviewDB.setIndCtznshpBirthCrtfctFor(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_US)) {
      fosterCareReviewDB.setIndCtznshpBirthCrtfctUs(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_US));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpCensusBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CHLD_FOUND)) {
      fosterCareReviewDB.setIndCtznshpChldFound(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CHLD_FOUND));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CITIZEN_CRTFCT)) {
      fosterCareReviewDB.setIndCtznshpCitizenCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CITIZEN_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CIVIL_SERVICE_EMP)) {
      fosterCareReviewDB.setIndCtznshpCivilServiceEmp(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CIVIL_SERVICE_EMP));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CONFRM_BIRTH)) {
      fosterCareReviewDB.setIndCtznshpConfrmBirth(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CONFRM_BIRTH));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_EVALUATION)) {
      fosterCareReviewDB.setIndCtznshpEvaluation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_EVALUATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_FINAL_ADOPT_DECREE)) {
      fosterCareReviewDB.setIndCtznshpFinalAdoptDecree(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_FINAL_ADOPT_DECREE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_FOR_DOCUMENTATION)) {
      fosterCareReviewDB.setIndCtznshpForDocumentation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_FOR_DOCUMENTATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_HOSPITAL_CRTFCT)) {
      fosterCareReviewDB.setIndCtznshpHospitalCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_HOSPITAL_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP)) {
      fosterCareReviewDB.setIndCtznshpLeglImmiStatExp(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpLifeInsBrthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpLoclGovtBrthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_MED_BIRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpMedBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_MED_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpMiltryBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NO_DOCUMENTATION)) {
      fosterCareReviewDB.setIndCtznshpNoDocumentation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NO_DOCUMENTATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NORTH_MARIANA_ID)) {
      fosterCareReviewDB.setIndCtznshpNorthMarianaId(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NORTH_MARIANA_ID));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NTRLZTN_CRTFCT)) {
      fosterCareReviewDB.setIndCtznshpNtrlztnCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NTRLZTN_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_PASSPORT)) {
      fosterCareReviewDB.setIndCtznshpPassport(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_PASSPORT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_REFUGEE)) {
      fosterCareReviewDB.setIndCtznshpRefugee(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_REFUGEE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_RELIG_BIRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpReligBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_RELIG_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_RESIDENT_CARD)) {
      fosterCareReviewDB.setIndCtznshpResidentCard(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_RESIDENT_CARD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_UNACC_MINOR_CHILD)) {
      fosterCareReviewDB.setIndCtznshpUnaccMinorChild(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_UNACC_MINOR_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_UNDOC_IMMIGRANT)) {
      fosterCareReviewDB.setIndCtznshpUndocImmigrant(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_UNDOC_IMMIGRANT));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpUsHsptlBrthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_US_ID_CARD)) {
      fosterCareReviewDB.setIndCtznshpUsIdCard(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_US_ID_CARD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD)) {
      fosterCareReviewDB.setIndCtznshpVitalBirthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_DRIVER_LIC_OR_ID)) {
      fosterCareReviewDB.setIndCtznshpDriverLicOrId(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_DRIVER_LIC_OR_ID));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CERT_IND_BLOOD)) {
      fosterCareReviewDB.setIndCtznshpCertIndBlood(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CERT_IND_BLOOD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_DOC_IMMIG_NAT_ACT)) {
      fosterCareReviewDB.setIndCtznshpDocImmigNatAct(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_DOC_IMMIG_NAT_ACT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_ID_PHOTO)) {
      fosterCareReviewDB.setIndCtznshpSchoolIdPhoto(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_ID_PHOTO));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_MILITARY_DEPDNT_ID)) {
      fosterCareReviewDB.setIndCtznshpMilitaryDepdntId(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_MILITARY_DEPDNT_ID));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_REC)) {
      fosterCareReviewDB.setIndCtznshpSchoolRec(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_REC));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CLINIC_DOC_HOS_DOC)) {
      fosterCareReviewDB.setIndCtznshpClinicDocHosDoc(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CLINIC_DOC_HOS_DOC));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_DAYCARE_NURSE_RCRD)) {
      fosterCareReviewDB.setIndCtznshpDaycareNurseRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_DAYCARE_NURSE_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_AFFIDAVIT_SIGNED)) {
      fosterCareReviewDB.setIndCtznshpAffidavitSigned(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_AFFIDAVIT_SIGNED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CERT_REPORT_BIRTH)) {
      fosterCareReviewDB.setIndCtznshpCertReportBirth(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CERT_REPORT_BIRTH));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_SAVE_SYSTEM)) {
      fosterCareReviewDB.setIndCtznshpSaveSystem(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_SAVE_SYSTEM));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_STUDENT_VISA)) {
      fosterCareReviewDB.setIndCtznshpStudentVisa(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_STUDENT_VISA));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_SUCCESS_SYSTEM)) {
      fosterCareReviewDB.setIndCtznshpSuccessSystem(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_SUCCESS_SYSTEM));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CURRENT_PARENT_SIT)) {
      fosterCareReviewDB.setIndCurrentParentSit(ContextHelper.getBooleanSafe(request,
                                                                             FosterCareReviewDB.IND_CURRENT_PARENT_SIT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_DOB_APPROX)) {
      fosterCareReviewDB.setIndDobApprox(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_DOB_APPROX));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ELIGIBILITY_COURT_MONTH)) {
      fosterCareReviewDB.setIndEligibilityCourtMonth(ContextHelper.getBooleanSafe(request,
                                                                                  FosterCareReviewDB.IND_ELIGIBILITY_COURT_MONTH));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ELIGIBLE)) {
      fosterCareReviewDB.setIndEligible(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_ELIGIBLE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_EQUITY)) {
      fosterCareReviewDB.setIndChildEquity(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CHILD_EQUITY));
    }
    if (map.containsKey(FosterCareReviewDB.IND_FATHER_PWE)) {
      fosterCareReviewDB.setIndFatherPwe(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_FATHER_PWE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_HOME_INCOME_AFDC_ELGBLTY)) {
      fosterCareReviewDB.setIndHomeIncomeAfdcElgblty(ContextHelper.getBooleanSafe(request,
                                                                                  FosterCareReviewDB.IND_HOME_INCOME_AFDC_ELGBLTY));
    }
    if (map.containsKey(FosterCareReviewDB.IND_MEETS_DP_OR_NOT_ES)) {
      fosterCareReviewDB.setIndMeetsDpOrNotEs(ContextHelper.getBooleanSafe(request,
                                                                           FosterCareReviewDB.IND_MEETS_DP_OR_NOT_ES));
    }
    if (map.containsKey(FosterCareReviewDB.IND_MEETS_DP_OR_NOT_SYSTEM)) {
      fosterCareReviewDB.setIndMeetsDpOrNotSystem(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_MEETS_DP_OR_NOT_SYSTEM));
    }
    if (map.containsKey(FosterCareReviewDB.IND_MOTHER_PWE)) {
      fosterCareReviewDB.setIndMotherPwe(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_MOTHER_PWE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_NARRATIVE_APPROVED)) {
      fosterCareReviewDB.setIndNarrativeApproved(ContextHelper.getBooleanSafe(request,
                                                                              FosterCareReviewDB.IND_NARRATIVE_APPROVED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_NO_ACTIVE_BLOC)) {
      fosterCareReviewDB.setIndNoActiveBloc(ContextHelper.getBooleanSafe(request,
                                                                         FosterCareReviewDB.IND_NO_ACTIVE_BLOC));
    }
    if (map.containsKey(FosterCareReviewDB.IND_NO_ACTIVE_PLACEMENT)) {
      fosterCareReviewDB.setIndNoActivePlacement(ContextHelper.getBooleanSafe(request,
                                                                              FosterCareReviewDB.IND_NO_ACTIVE_PLACEMENT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_NO_OPEN_PAID_ELIGIBILITY)) {
      fosterCareReviewDB.setIndNoOpenPaidEligibility(ContextHelper.getBooleanSafe(request,
                                                                                  FosterCareReviewDB.IND_NO_OPEN_PAID_ELIGIBILITY));
    }
    if (map.containsKey(FosterCareReviewDB.IND_NON_PRS_PAID_PLACEMENT)) {
      fosterCareReviewDB.setIndNonPrsPaidPlacement(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_NON_PRS_PAID_PLACEMENT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ORIGINAL_APPLICATION_ELIGIBLE)) {
      fosterCareReviewDB.setIndOriginalApplicationEligible(ContextHelper.getBooleanSafe(request,
                                                                                        FosterCareReviewDB.IND_ORIGINAL_APPLICATION_ELIGIBLE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_OTHER_VERIFICATION)) {
      fosterCareReviewDB.setIndOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                              FosterCareReviewDB.IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_PARENT_DISABLED)) {
      fosterCareReviewDB.setIndParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                           FosterCareReviewDB.IND_PARENT_DISABLED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_PARENTAL_DEPRIVATION)) {
      fosterCareReviewDB.setIndParentalDeprivation(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_PARENTAL_DEPRIVATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_PERMANENCY_HEARINGS)) {
      fosterCareReviewDB.setIndPermanencyHearings(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_PERMANENCY_HEARINGS));
    }
    if (map.containsKey(FosterCareReviewDB.IND_PERSON_HM_REMOVAL)) {
      fosterCareReviewDB.setIndPersonHmRemoval(ContextHelper.getBooleanSafe(request,
                                                                            FosterCareReviewDB.IND_PERSON_HM_REMOVAL));
    }
    if (map.containsKey(FosterCareReviewDB.IND_PRMNCY_HEARINGS_DUE)) {
      fosterCareReviewDB.setIndPrmncyHearingsDue(ContextHelper.getBooleanSafe(request,
                                                                              FosterCareReviewDB.IND_PRMNCY_HEARINGS_DUE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_PRMNCY_HRNGS12_MONTH)) {
      fosterCareReviewDB.setIndPrmncyHrngs12Month(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_PRMNCY_HRNGS12_MONTH));
    }
    if (map.containsKey(FosterCareReviewDB.IND_PRS_MANAGING_CVS)) {
      fosterCareReviewDB.setIndPrsManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                           FosterCareReviewDB.IND_PRS_MANAGING_CVS));
    }
    if (map.containsKey(FosterCareReviewDB.IND_REMOVAL_CHILD_ORDERED)) {
      fosterCareReviewDB.setIndRemovalChildOrdered(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_REMOVAL_CHILD_ORDERED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_REVIEW_INAPPROPRIATE)) {
      fosterCareReviewDB.setIndReviewInappropriate(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_REVIEW_INAPPROPRIATE));
    }else{
      fosterCareReviewDB.setIndReviewInappropriate(false);
    }
    if (map.containsKey(FosterCareReviewDB.IND_RIGHTS_TERMINATED)) {
      fosterCareReviewDB.setIndRightsTerminated(ContextHelper.getBooleanSafe(request,
                                                                             FosterCareReviewDB.IND_RIGHTS_TERMINATED));
    }
    if (map.containsKey(FosterCareReviewDB.IND_RSDI_VERIFICATION)) {
      fosterCareReviewDB.setIndRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                             FosterCareReviewDB.IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_RSNBL_EFFORT_PRVT_REMOVAL)) {
      fosterCareReviewDB.setIndRsnblEffortPrvtRemoval(ContextHelper.getBooleanSafe(request,
                                                                                   FosterCareReviewDB.IND_RSNBL_EFFORT_PRVT_REMOVAL));
    }
    if (map.containsKey(FosterCareReviewDB.IND_SAVINGS_ACCT)) {
      fosterCareReviewDB.setIndSavingsAcct(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_SAVINGS_ACCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_SSI_VERIFICATION)) {
      fosterCareReviewDB.setIndSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                            FosterCareReviewDB.IND_SSI_VERIFICATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_TDPRS_RESPONSIBILITY)) {
      fosterCareReviewDB.setIndTdprsResponsibility(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_TDPRS_RESPONSIBILITY));
    }
    if (map.containsKey(FosterCareReviewDB.IND_EXTNSION_PROVIDED_12_MNTHS)) {
      fosterCareReviewDB.setIndExtnsionProvided12Mnths(ContextHelper.getBooleanSafe(request,
                                                                                FosterCareReviewDB.IND_EXTNSION_PROVIDED_12_MNTHS));
    }
    if (map.containsKey(FosterCareReviewDB.DT_EXTNSION_PROVIDED_12_MNTHS_STRING)) {
      fosterCareReviewDB.setDtExtnsionProvided12MnthsString(ContextHelper.getStringSafe(request,
                                                                                FosterCareReviewDB.DT_EXTNSION_PROVIDED_12_MNTHS_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_AGE)) {
      fosterCareReviewDB.setNbrAge(ContextHelper.getLongSafe(request, FosterCareReviewDB.NBR_AGE));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_AGE_MONTHS)) {
      fosterCareReviewDB.setNbrAgeMonths(ContextHelper.getLongSafe(request, FosterCareReviewDB.NBR_AGE_MONTHS));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_AGE_YEARS)) {
      fosterCareReviewDB.setNbrAgeYears(ContextHelper.getLongSafe(request, FosterCareReviewDB.NBR_AGE_YEARS));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_CERTIFIED_GROUP)) {
      fosterCareReviewDB.setNbrCertifiedGroup(ContextHelper.getLongSafe(request,
                                                                        FosterCareReviewDB.NBR_CERTIFIED_GROUP));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_EMPLOYEE_PERSON_PHONE)) {
      fosterCareReviewDB.setNbrEmployeePersonPhone(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.NBR_EMPLOYEE_PERSON_PHONE));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_MEDICAID)) {
      fosterCareReviewDB.setNbrMedicaid(ContextHelper.getStringSafe(request, FosterCareReviewDB.NBR_MEDICAID));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_PARENTS_HOME)) {
      fosterCareReviewDB.setNbrParentsHome(ContextHelper.getLongSafe(request, FosterCareReviewDB.NBR_PARENTS_HOME));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_SOCIAL_SECURITY)) {
      fosterCareReviewDB.setNbrSocialSecurity(ContextHelper.getStringSafe(request,
                                                                          FosterCareReviewDB.NBR_SOCIAL_SECURITY));
    }
    if (map.containsKey(FosterCareReviewDB.NM_EMPLOYEE_PERSON_FULL)) {
      fosterCareReviewDB.setNmEmployeePersonFull(ContextHelper.getStringSafe(request,
                                                                             FosterCareReviewDB.NM_EMPLOYEE_PERSON_FULL));
    }
    if (map.containsKey(FosterCareReviewDB.NM_PERSON_FULL)) {
      fosterCareReviewDB.setNmPersonFull(ContextHelper.getStringSafe(request, FosterCareReviewDB.NM_PERSON_FULL));
    }
    if (map.containsKey(FosterCareReviewDB.TXT_DETERMINATION_COMMENTS)) {
      fosterCareReviewDB.setTxtDeterminationComments(ContextHelper.getStringSafe(request,
                                                                                 FosterCareReviewDB.TXT_DETERMINATION_COMMENTS));
    }
    if (map.containsKey(FosterCareReviewDB.TXT_INAPPROPRIATE_COMMENTS)) {
      fosterCareReviewDB.setTxtInappropriateComments(ContextHelper.getStringSafe(request,
                                                                                 FosterCareReviewDB.TXT_INAPPROPRIATE_COMMENTS));
    }
    if (map.containsKey(FosterCareReviewDB.IND_SHOW_CHECKLIST)) {
      fosterCareReviewDB.setIndShowChecklist(ContextHelper.getBooleanSafe(request,
                                                                          FosterCareReviewDB.IND_SHOW_CHECKLIST));
    }
    if (map.containsKey(FosterCareReviewDB.IND_MULTIPLE_ACTIVE_PLACEMENTS)) {
      fosterCareReviewDB.setIndMultipleActivePlacements(ContextHelper.getBooleanSafe(request,
                                                                                     FosterCareReviewDB.IND_MULTIPLE_ACTIVE_PLACEMENTS));
    }
    if (map.containsKey(FosterCareReviewDB.IND_ABSENT_NEVER_COHABITATED)) {
      fosterCareReviewDB.setIndAbsentNeverCohabitated(ContextHelper.getBooleanSafe(request,
                                                                                   FosterCareReviewDB.IND_ABSENT_NEVER_COHABITATED));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_STEPPARENT_CHILDREN)) {
      fosterCareReviewDB.setNbrStepparentChildren(ContextHelper.getLongSafe(request,
                                                                            FosterCareReviewDB.NBR_STEPPARENT_CHILDREN));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_CRS_ID)) {
      fosterCareReviewDB.setNbrCrsId(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.NBR_CRS_ID));
    }
    if (map.containsKey(FosterCareReviewDB.DT_PRMNCY_HRNGS_12_MONTH_STRING)) {
      fosterCareReviewDB.setDtPrmncyHrngs12MonthString(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.DT_PRMNCY_HRNGS_12_MONTH_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CHILD_CARE_COURT_ORDER)) {
      fosterCareReviewDB.setIndChildCareCourtOrder(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_CHILD_CARE_COURT_ORDER));
    }
    if (map.containsKey(FosterCareReviewDB.DT_CHILD_CARE_COURT_ORDER_STRING)) {
      fosterCareReviewDB.setDtChildCareCourtOrderString(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.DT_CHILD_CARE_COURT_ORDER_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.IND_BEST_INTEREST_LANG)) {
      fosterCareReviewDB.setIndBestInterestLang(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_BEST_INTEREST_LANG));
    }
    if (map.containsKey(FosterCareReviewDB.DT_BEST_INTEREST_LANG_STRING)) {
      fosterCareReviewDB.setDtBestInterestLangString(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.DT_BEST_INTEREST_LANG_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.IND_RESNABL_EFRT_PRVNT_RMVAL)) {
      fosterCareReviewDB.setIndResnablEfrtPrvntRmval(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_RESNABL_EFRT_PRVNT_RMVAL));
    }
    if (map.containsKey(FosterCareReviewDB.DT_RESNABL_EFRT_PRVNT_RMVAL_STRING)) {
      fosterCareReviewDB.setDtResnablEfrtPrvntRmvalString(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.DT_RESNABL_EFRT_PRVNT_RMVAL_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.IND_RESNABL_EFRT_REUNIFY)) {
      fosterCareReviewDB.setIndResnablEfrtReunify(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_RESNABL_EFRT_REUNIFY));
    }
    if (map.containsKey(FosterCareReviewDB.DT_RESNABL_EFRT_REUNIFY_STRING)) {
      fosterCareReviewDB.setDtResnablEfrtReunifyString(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.DT_RESNABL_EFRT_REUNIFY_STRING));
    }
    if (map.containsKey(FosterCareReviewDB.ID_OTHER_RELATIVE_PERSON)) {
      fosterCareReviewDB.setIdOtherRelativePerson(ContextHelper.getLongSafe(request,
                                                                               FosterCareReviewDB.ID_OTHER_RELATIVE_PERSON));
    }
    if (map.containsKey(FosterCareReviewDB.NBR_MHN)) {
      fosterCareReviewDB.setNbrMhn(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.NBR_MHN));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_CHSUP_CHILD)) {
      fosterCareReviewDB.setAmtChsupChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_CHSUP_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_CNTBL_INCOME)) {
      fosterCareReviewDB.setAmtCntblIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_CNTBL_INCOME));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_CNTBL_INCOME_30)) {
      fosterCareReviewDB.setAmtCntblIncome30(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_CNTBL_INCOME_30));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_CNTBL_INCOME_LESS_30)) {
      fosterCareReviewDB.setAmtCntblIncomeLess30(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_CNTBL_INCOME_LESS_30));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_CNTBL_INCOME_THIRD)) {
      fosterCareReviewDB.setAmtCntblIncomeThird(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_CNTBL_INCOME_THIRD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_CNTBL_INCOME_LESS_THIRD)) {
      fosterCareReviewDB.setAmtCntblIncomeLessThird(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_CNTBL_INCOME_LESS_THIRD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_CNTBL_RESOURCE_CHILD)) {
      fosterCareReviewDB.setAmtCtnblResourceChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_CNTBL_RESOURCE_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_DEP_CARE_DEDUC_CHILD)) {
      fosterCareReviewDB.setAmtDepCareDeducChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_DEP_CARE_DEDUC_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_EARNED_LESS_STD_DEDUCT)) {
      fosterCareReviewDB.setAmtEarnedLessStdDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_EARNED_LESS_STD_DEDUCT));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GIC_SURP_DEFCT_CHILD)) {
      fosterCareReviewDB.setAmtGicSurpDefctChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_GIC_SURP_DEFCT_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GROSS_EARNED_CHILD)) {
      fosterCareReviewDB.setAmtGrossEarnedChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_GROSS_EARNED_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GROSS_UNEARNED_CHILD)) {
      fosterCareReviewDB.setAmtGrossUnEarnedChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_GROSS_UNEARNED_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_GROSS_INCOME_CEILING_CHILD)) {
      fosterCareReviewDB.setAmtGrossIncomeCeilingChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_GROSS_INCOME_CEILING_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_LESS_DEP_CARE_ELIG)) {
      fosterCareReviewDB.setAmtLessDepCareElig(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_LESS_DEP_CARE_ELIG));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_NET_EARNED_INCOME_CHILD)) {
      fosterCareReviewDB.setAmtNetEarnedIncomeChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_NET_EARNED_INCOME_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_PLUS_UNEARNED_ELIG)) {
      fosterCareReviewDB.setAmtPlusUnearnedElig(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_PLUS_UNEARNED_ELIG));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_PLUS_CHSUP_CHILD)) {
      fosterCareReviewDB.setAmtPlusChsupChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_PLUS_CHSUP_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_RESOURCE_LIMIT_CHILD)) {
      fosterCareReviewDB.setAmtResourceLimitChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_RESOURCE_LIMIT_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STD_EARNED_INCOME_DEDUCT)) {
      fosterCareReviewDB.setAmtStdEarnedIncomeDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_STD_EARNED_INCOME_DEDUCT));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_STD_OF_NEED_CHILD)) {
      fosterCareReviewDB.setAmtStdOfNeedChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_STD_OF_NEED_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.AMT_SURP_DEFCT_ELIG_CHILD)) {
      fosterCareReviewDB.setAmtSurpDefctEligChild(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               FosterCareReviewDB.AMT_SURP_DEFCT_ELIG_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.CD_ELIG_SURP_DEFCT_CHILD)) {
      fosterCareReviewDB.setCdEligSurpDefctChild(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.CD_ELIG_SURP_DEFCT_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.CD_GIC_SURP_DEFCT_CHILD)) {
      fosterCareReviewDB.setCdGicSurpDefctChild(ContextHelper.getStringSafe(request,
                                                                               FosterCareReviewDB.CD_GIC_SURP_DEFCT_CHILD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTNBL_RES_CHILD_ELGBLTY)) {
      fosterCareReviewDB.setIndCtnblResChildElgblty(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_CTNBL_RES_CHILD_ELGBLTY));
    }
    if (map.containsKey(FosterCareReviewDB.IND_GROSS_INC_CHILD_ELGBLTY)) {
      fosterCareReviewDB.setIndGrossIncChildElgblty(ContextHelper.getBooleanSafe(request,
                                                                               FosterCareReviewDB.IND_GROSS_INC_CHILD_ELGBLTY));
    }
  }
}
