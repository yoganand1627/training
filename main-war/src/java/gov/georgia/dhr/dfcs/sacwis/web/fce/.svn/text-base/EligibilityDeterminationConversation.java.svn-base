package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.EventUtility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.ApplicationReasonsNotEligible;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EligibilityDetermination;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Eligibility Determination a.k.a "The Worksheet".
 *
 * @author Rodrigo DeJuana, March 4, 2003
 */
public class EligibilityDeterminationConversation
        extends FceConversation {
  public static final String TRACE_TAG = "EligibilityDeterminationConversation";
  public static final String ELIGIBILITYDB = "eligibilityDB";
  public static final String ELIGIBILITY_URI = "/fce/EligibilityDetermination/displayEligibilityDetermination";
  public static final String STAGE_CLOSURE_EVENT_ID = "STAGE_CLOSURE_EVENT_ID";
  public static final String ELIGIBILITY_WORKSHEET = "FCA";
  public static final String AFDC_BUDGETING = "AFDC";
  public static final String IVE_BUDGETING = "IVE";
  public static final String BUDGETING_PROCESS = "budgetingProcess";

  private EligibilityDetermination eligibilityDetermination;
  private EventUtility eventUtility;
  private Fce fce;
  private Admin admin = null;
  
  // initialize admin
  public void setAdmin(Admin objAdmin) {
    this.admin = objAdmin;
  }

  public void setEventUtility(EventUtility eventUtility) {
    this.eventUtility = eventUtility;
  }

  public void setEligibilityDetermination(EligibilityDetermination eligibilityDetermination) {
    this.eligibilityDetermination = eligibilityDetermination;
  }

  public EligibilityDeterminationConversation() {
    super(TRACE_TAG);
  }
  
  public void setFce(Fce fce) {
    this.fce = fce;
  }
  
  /**
   * This method will access the data need to display the Eligibility Determination Worksheet.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayEligibilityDetermination_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayEligibilityDetermination_xa()");

    HttpServletRequest request = context.getRequest();

    clearState(context);
    FceUtility.setApplicationFceTabState(request);

    try {
      EligibilityDeterminationDB eligibilityDeterminationDB =
              eligibilityDetermination.read(GlobalData.getUlIdStage(request), GlobalData.getUlIdEvent(request),
                                            getUserID(request));

      request.setAttribute(ELIGIBILITYDB, eligibilityDeterminationDB);
      
      // Find the application and set the cd application to use in the jsp to determine which of the equity questions to display
      FceApplicationDB fceApplicationDB = fce.retrieveFceApplication(eligibilityDeterminationDB.getIdFceApplication());
      request.setAttribute("cdApplication", fceApplicationDB.getCdApplication());
      
      EventDB eventDB = eligibilityDetermination.retrieveEventByIdEvent(eligibilityDeterminationDB.getIdEvent());
      
      // Determine wether we are doing an AFDC Relatedness Budgeting or IV-E Budgeting. This will be used in the jsp
      // to determine if we need to display the 'Child & Family Assistance Unit' and the 'Applied Income of Stepparent'
      // sections or the 'Applied Income of Child' section
      String budgetingProcess = ApplicationReasonsNotEligible.determineBudgetingProcess(eventDB.getCdEventType(), eligibilityDeterminationDB.getIdEvent(), fce);
      request.setAttribute(BUDGETING_PROCESS, budgetingProcess);
      
      setPageMode(context, eligibilityDeterminationDB);

      FceUtility.setCdEventStatus(eligibilityDeterminationDB, request);

      int closureEvent = CaseUtility.getPendingStageClosureEvent((int) eligibilityDeterminationDB.getIdStage());
      request.setAttribute(STAGE_CLOSURE_EVENT_ID, closureEvent);

    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will save the data on the Eligibility Determination Worksheet.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveEligibilityDetermination_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG,
                                                                    ".ssaveEligibilityDetermination_xa_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      EligibilityDeterminationDB eligibilityDeterminationDB = readFromRequest(request);

      eligibilityDetermination.save(eligibilityDeterminationDB);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will save the data and determine eligibity for the Eligibility Determination Worksheet.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void determineEligibility_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG,
                                                                    ".determineEligibility_xa()");

    HttpServletRequest request = context.getRequest();

    try {
     // EligibilityDeterminationDB eligibilityDeterminationDB = readFromRequest(request);
      EligibilityDeterminationDB eligibilityDeterminationDB =
        eligibilityDetermination.read(GlobalData.getUlIdStage(request), GlobalData.getUlIdEvent(request),
                                      getUserID(request));
      eligibilityDetermination.determineEligibility(eligibilityDeterminationDB);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will procces as a result of the user pressing the Continue button on the Worksheet.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void confirmYes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".confirmYes_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      long idEligibilityEvent =
              eligibilityDetermination.confirmEligibility(GlobalData.getUlIdStage(request),
                                                          GlobalData.getUlIdEvent(request), getUserID(request));

      GlobalData.setUlIdEvent((int) idEligibilityEvent, request);

      //in case eligibility specialist got this far with only a todo
      //create a new override so he can edit a new eligibility summary
      ToDoHelper.setPageModeEditOverride(request, EventHelper.FCE_ELIGIBILITY_TASK_CODE, GlobalData.getUlIdStage(
              request), (int) idEligibilityEvent);
     
      //This method saves the alert "Eligibility needs to be redetermined for <Stage Name> by <Current Date + 6 Months>"
      // when MES Worker confirms the eligibility. 
      fce.saveEligibilityAlert(getUserID(request), getUserID(request), GlobalData.getUlIdStage(request), GlobalData.getUlIdCase(request), ELIGIBILITY_WORKSHEET);
      
      //!!! 08/2/2003, Matthew McClain, I'm a little concerned if this fails
      // Check for pending stage closure and invalidate if found
      int pendingStageClosure = ContextHelper.getIntSafe(request, "hdnPendingStageClosureEventId");
      if (pendingStageClosure > 0) {
        eventUtility.invalidatePendingStageClosure(pendingStageClosure, admin);
      }
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will blank out the Eligible Indicator.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void confirmNo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".confirmNo_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      EligibilityDeterminationDB eligibilityDeterminationDB = readFromRequest(request);
      eligibilityDeterminationDB.setIndEligible((Boolean) null);

      eligibilityDetermination.save(eligibilityDeterminationDB);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Sets the page mode for the page.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private void setPageMode(GrndsExchangeContext context, EligibilityDeterminationDB eligibilityDeterminationDB) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setPageMode()");

    HttpServletRequest request = context.getRequest();

    String eventStatus = eligibilityDeterminationDB.getCdEventStatus();

    String pageMode = FceUtility.getFceApplicationPageMode(request, eligibilityDeterminationDB);

    if (eligibilityDeterminationDB.getIndEligibleObject() != null) {
      pageMode = PageModeConstants.VIEW;
    }

    UserProfile user = UserProfileHelper.getUserProfile(request);
    if (!user.hasRight(UserProfile.SEC_ELIGIBILITY) ||
        !EventHelper.COMPLETE_EVENT.equals(eventStatus)) {
      pageMode = PageModeConstants.VIEW;
    }

    PageMode.setPageMode(pageMode, request);

    performanceTrace.exitScope();
  }

  public static EligibilityDeterminationDB readFromRequest(HttpServletRequest request) {
    EligibilityDeterminationDB eligibilityDeterminationDB = new EligibilityDeterminationDB();
    populateWithRequest(eligibilityDeterminationDB, request);
    return eligibilityDeterminationDB;
  }

  public static void populateWithRequest(EligibilityDeterminationDB eligibilityDeterminationDB,
                                         HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(EligibilityDeterminationDB.AMT_COUNTABLE_INCOME)) {
      eligibilityDeterminationDB.setAmtCountableIncome(ContextHelper.getDoubleSafe(request,
                                                                                   EligibilityDeterminationDB.AMT_COUNTABLE_INCOME));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_COUNTABLE_INCOME_MONEY)) {
      eligibilityDeterminationDB.setAmtCountableIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          EligibilityDeterminationDB.AMT_COUNTABLE_INCOME_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_EARNED_CRTFD_GRP)) {
      eligibilityDeterminationDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                       EligibilityDeterminationDB.AMT_GROSS_EARNED_CRTFD_GRP));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY)) {
      eligibilityDeterminationDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                              EligibilityDeterminationDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_UNEARNED_CRTFD_GRP)) {
      eligibilityDeterminationDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                         EligibilityDeterminationDB.AMT_GROSS_UNEARNED_CRTFD_GRP));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY)) {
      eligibilityDeterminationDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                                EligibilityDeterminationDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_INCOME_LIMIT)) {
      eligibilityDeterminationDB.setAmtIncomeLimit(ContextHelper.getDoubleSafe(request,
                                                                               EligibilityDeterminationDB.AMT_INCOME_LIMIT));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_INCOME_LIMIT_MONEY)) {
      eligibilityDeterminationDB.setAmtIncomeLimit(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      EligibilityDeterminationDB.AMT_INCOME_LIMIT_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_PWE_INCOME)) {
      eligibilityDeterminationDB.setAmtPweIncome(ContextHelper.getDoubleSafe(request,
                                                                             EligibilityDeterminationDB.AMT_PWE_INCOME));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_PWE_INCOME_MONEY)) {
      eligibilityDeterminationDB.setAmtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    EligibilityDeterminationDB.AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_SSI)) {
      eligibilityDeterminationDB.setAmtSsi(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_SSI));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_SSI_MONEY)) {
      eligibilityDeterminationDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                              EligibilityDeterminationDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_ALIMONY)) {
      eligibilityDeterminationDB.setAmtStepparentAlimony(ContextHelper.getDoubleSafe(request,
                                                                                     EligibilityDeterminationDB.AMT_STEPPARENT_ALIMONY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_ALIMONY_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentAlimony(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                            EligibilityDeterminationDB.AMT_STEPPARENT_ALIMONY_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_ALLOWANCE)) {
      eligibilityDeterminationDB.setAmtStepparentAllowance(ContextHelper.getDoubleSafe(request,
                                                                                       EligibilityDeterminationDB.AMT_STEPPARENT_ALLOWANCE));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_ALLOWANCE_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentAllowance(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                              EligibilityDeterminationDB.AMT_STEPPARENT_ALLOWANCE_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_APPLIED_INCOME)) {
      eligibilityDeterminationDB.setAmtStepparentAppliedIncome(ContextHelper.getDoubleSafe(request,
                                                                                           EligibilityDeterminationDB.AMT_STEPPARENT_APPLIED_INCOME));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentAppliedIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                                  EligibilityDeterminationDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_CNTBL_UNEARNED)) {
      eligibilityDeterminationDB.setAmtStepparentCntblUnearned(ContextHelper.getDoubleSafe(request,
                                                                                           EligibilityDeterminationDB.AMT_STEPPARENT_CNTBL_UNEARNED));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentCntblUnearned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                                  EligibilityDeterminationDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_GROSS_EARNED)) {
      eligibilityDeterminationDB.setAmtStepparentGrossEarned(ContextHelper.getDoubleSafe(request,
                                                                                         EligibilityDeterminationDB.AMT_STEPPARENT_GROSS_EARNED));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_GROSS_EARNED_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentGrossEarned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                                EligibilityDeterminationDB.AMT_STEPPARENT_GROSS_EARNED_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_OUTSIDE_PMNT)) {
      eligibilityDeterminationDB.setAmtStepparentOutsidePmnt(ContextHelper.getDoubleSafe(request,
                                                                                         EligibilityDeterminationDB.AMT_STEPPARENT_OUTSIDE_PMNT));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentOutsidePmnt(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                                EligibilityDeterminationDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_TOTAL_CNTBL)) {
      eligibilityDeterminationDB.setAmtStepparentTotalCntbl(ContextHelper.getDoubleSafe(request,
                                                                                        EligibilityDeterminationDB.AMT_STEPPARENT_TOTAL_CNTBL));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentTotalCntbl(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                               EligibilityDeterminationDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_WORK_DEDUCT)) {
      eligibilityDeterminationDB.setAmtStepparentWorkDeduct(ContextHelper.getDoubleSafe(request,
                                                                                        EligibilityDeterminationDB.AMT_STEPPARENT_WORK_DEDUCT));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY)) {
      eligibilityDeterminationDB.setAmtStepparentWorkDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                               EligibilityDeterminationDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY));
    }
    if (map.containsKey(EligibilityDeterminationDB.CD_BLOC_CHILD)) {
      eligibilityDeterminationDB.setCdBlocChild(ContextHelper.getStringSafe(request,
                                                                            EligibilityDeterminationDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.CD_ELIGIBILITY_ACTUAL)) {
      eligibilityDeterminationDB.setCdEligibilityActual(ContextHelper.getStringSafe(request,
                                                                                    EligibilityDeterminationDB.CD_ELIGIBILITY_ACTUAL));
    }
    if (map.containsKey(EligibilityDeterminationDB.CD_ELIGIBILITY_SELECTED)) {
      eligibilityDeterminationDB.setCdEligibilitySelected(ContextHelper.getStringSafe(request,
                                                                                      EligibilityDeterminationDB.CD_ELIGIBILITY_SELECTED));
    }
    if (map.containsKey(EligibilityDeterminationDB.CD_MEDICAID_ELIGIBILITY_TYPE)) {
      eligibilityDeterminationDB.setCdMedicaidEligibilityType(ContextHelper.getStringSafe(request,
                                                                                          EligibilityDeterminationDB.CD_MEDICAID_ELIGIBILITY_TYPE));
    }
    if (map.containsKey(EligibilityDeterminationDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP)) {
      eligibilityDeterminationDB.setFceEligibilityCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                                                  EligibilityDeterminationDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(EligibilityDeterminationDB.CD_PWE_IRREGULAR_UNDER100)) {
      eligibilityDeterminationDB.setCdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                                       EligibilityDeterminationDB.CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(EligibilityDeterminationDB.CD_PWE_STEADY_UNDER100)) {
      eligibilityDeterminationDB.setCdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                                    EligibilityDeterminationDB.CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_ELIGIBILITY_END_STRING)) {
      eligibilityDeterminationDB.setDtEligibilityEndString(ContextHelper.getStringSafe(request,
                                                                                       EligibilityDeterminationDB.DT_ELIGIBILITY_END_STRING));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_ELIGIBILITY_END_TIME)) {
      eligibilityDeterminationDB.setDtEligibilityEndTime(ContextHelper.getLongSafe(request,
                                                                                   EligibilityDeterminationDB.DT_ELIGIBILITY_END_TIME));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_ELIG_DTRMNTN_START_STRING)) {
      eligibilityDeterminationDB.setDtEligDtrmntnStartString(ContextHelper.getStringSafe(request,
                                                                                         EligibilityDeterminationDB.DT_ELIG_DTRMNTN_START_STRING));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_ELIG_DTRMNTN_START_TIME)) {
      eligibilityDeterminationDB.setDtEligDtrmntnStartTime(ContextHelper.getLongSafe(request,
                                                                                     EligibilityDeterminationDB.DT_ELIG_DTRMNTN_START_TIME));
    }
    if (map.containsKey(EligibilityDeterminationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      eligibilityDeterminationDB.setFceEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                                 EligibilityDeterminationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(EligibilityDeterminationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      eligibilityDeterminationDB.setFceEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                             EligibilityDeterminationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_REMOVAL_CHILD_ORDERED_STRING)) {
      eligibilityDeterminationDB.setDtRemovalChildOrderedString(ContextHelper.getStringSafe(request,
                                                                                            EligibilityDeterminationDB.DT_REMOVAL_CHILD_ORDERED_STRING));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_REMOVAL_CHILD_ORDERED_TIME)) {
      eligibilityDeterminationDB.setDtRemovalChildOrderedTime(ContextHelper.getLongSafe(request,
                                                                                        EligibilityDeterminationDB.DT_REMOVAL_CHILD_ORDERED_TIME));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_REVIEW_DATE_STRING)) {
      eligibilityDeterminationDB.setDtReviewDateString(ContextHelper.getStringSafe(request,
                                                                                   EligibilityDeterminationDB.DT_REVIEW_DATE_STRING));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_REVIEW_DATE_TIME)) {
      eligibilityDeterminationDB.setDtReviewDateTime(ContextHelper.getLongSafe(request,
                                                                               EligibilityDeterminationDB.DT_REVIEW_DATE_TIME));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING)) {
      eligibilityDeterminationDB.setDtRsnblEffortPreventRemString(ContextHelper.getStringSafe(request,
                                                                                              EligibilityDeterminationDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING));
    }
    if (map.containsKey(EligibilityDeterminationDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME)) {
      eligibilityDeterminationDB.setDtRsnblEffortPreventRemTime(ContextHelper.getLongSafe(request,
                                                                                          EligibilityDeterminationDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_CASE)) {
      eligibilityDeterminationDB.setIdCase(ContextHelper.getLongSafe(request, EligibilityDeterminationDB.ID_CASE));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_ELIGIBILITY_EVENT)) {
      eligibilityDeterminationDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request,
                                                                                 EligibilityDeterminationDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_FCE_APPLICATION)) {
      eligibilityDeterminationDB.setIdFceApplication(ContextHelper.getLongSafe(request,
                                                                               EligibilityDeterminationDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_FCE_ELIGIBILITY)) {
      eligibilityDeterminationDB.setIdFceEligibility(ContextHelper.getLongSafe(request,
                                                                               EligibilityDeterminationDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_FCE_PERSON)) {
      eligibilityDeterminationDB.setIdFcePerson(ContextHelper.getLongSafe(request,
                                                                          EligibilityDeterminationDB.ID_FCE_PERSON));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_FCE_REVIEW)) {
      eligibilityDeterminationDB.setIdFceReview(ContextHelper.getLongSafe(request,
                                                                          EligibilityDeterminationDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_LAST_UPDATE_PERSON)) {
      eligibilityDeterminationDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                                 EligibilityDeterminationDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_PERSON)) {
      eligibilityDeterminationDB.setIdPerson(ContextHelper.getLongSafe(request, EligibilityDeterminationDB.ID_PERSON));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_STAGE)) {
      eligibilityDeterminationDB.setIdStage(ContextHelper.getLongSafe(request, EligibilityDeterminationDB.ID_STAGE));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_ALTRNT_CUSTODY)) {
      eligibilityDeterminationDB.setIndAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                                        EligibilityDeterminationDB.IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_DEPORTED)) {
      eligibilityDeterminationDB.setIndAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_DESERTED)) {
      eligibilityDeterminationDB.setIndAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_ABSENT_DESERTED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_DIED)) {
      eligibilityDeterminationDB.setIndAbsentDied(ContextHelper.getBooleanSafe(request,
                                                                               EligibilityDeterminationDB.IND_ABSENT_DIED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_DIVORCED)) {
      eligibilityDeterminationDB.setIndAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_FATHER)) {
      eligibilityDeterminationDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                                 EligibilityDeterminationDB.IND_ABSENT_FATHER));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_HOSPITALIZED)) {
      eligibilityDeterminationDB.setIndAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                                       EligibilityDeterminationDB.IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_INCARCERATED)) {
      eligibilityDeterminationDB.setIndAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                                       EligibilityDeterminationDB.IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_MILITARY_WORK)) {
      eligibilityDeterminationDB.setIndAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                                       EligibilityDeterminationDB.IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_MOTHER)) {
      eligibilityDeterminationDB.setIndAbsentMother(ContextHelper.getBooleanSafe(request,
                                                                                 EligibilityDeterminationDB.IND_ABSENT_MOTHER));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_SEPARATED)) {
      eligibilityDeterminationDB.setIndAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                                    EligibilityDeterminationDB.IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ABSENT_WORK_RELATED)) {
      eligibilityDeterminationDB.setIndAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                                      EligibilityDeterminationDB.IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CHILD_LIVING_PRNT6_MNTHS)) {
      eligibilityDeterminationDB.setIndChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                          EligibilityDeterminationDB.IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CHILD_QUALIFIED_CITIZEN)) {
      eligibilityDeterminationDB.setIndChildQualifiedCitizen(ContextHelper.getBooleanSafe(request,
                                                                                          EligibilityDeterminationDB.IND_CHILD_QUALIFIED_CITIZEN));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CHILD_SUPPORT_ORDERED)) {
      eligibilityDeterminationDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                                        EligibilityDeterminationDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CHILD_UNDER18)) {
      eligibilityDeterminationDB.setIndChildUnder18(ContextHelper.getBooleanSafe(request,
                                                                                 EligibilityDeterminationDB.IND_CHILD_UNDER18));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_AMER_INDIAN_CRD)) {
      eligibilityDeterminationDB.setIndCtznshpAmerIndianCrd(ContextHelper.getBooleanSafe(request, EligibilityDeterminationDB.IND_CTZNSHP_AMER_INDIAN_CRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_ATTORNEY_REVIEW)) {
      eligibilityDeterminationDB.setIndCtznshpAttorneyReview(ContextHelper.getBooleanSafe(request, EligibilityDeterminationDB.IND_CTZNSHP_ATTORNEY_REVIEW));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_BIRTH_ABROAD)) {
      eligibilityDeterminationDB.setIndCtznshpBirthAbroad(ContextHelper.getBooleanSafe(request, EligibilityDeterminationDB.IND_CTZNSHP_BIRTH_ABROAD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR)) {
      eligibilityDeterminationDB.setIndCtznshpBirthCrtfctFor(ContextHelper.getBooleanSafe(request, EligibilityDeterminationDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_BIRTH_CRTFCT_US)) {
      eligibilityDeterminationDB.setIndCtznshpBirthCrtfctUs(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_BIRTH_CRTFCT_US));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpCensusBirthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_CHLD_FOUND)) {
      eligibilityDeterminationDB.setIndCtznshpChldFound(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_CHLD_FOUND));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_CITIZEN_CRTFCT)) {
      eligibilityDeterminationDB.setIndCtznshpCitizenCrtfct(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_CITIZEN_CRTFCT));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_CIVIL_SERVICE_EMP)) {
      eligibilityDeterminationDB.setIndCtznshpCivilServiceEmp(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_CIVIL_SERVICE_EMP));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_CONFRM_BIRTH)) {
      eligibilityDeterminationDB.setIndCtznshpConfrmBirth(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_CONFRM_BIRTH));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_EVALUATION)) {
      eligibilityDeterminationDB.setIndCtznshpEvaluation(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_EVALUATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_FINAL_ADOPT_DECREE)) {
      eligibilityDeterminationDB.setIndCtznshpFinalAdoptDecree(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_FINAL_ADOPT_DECREE));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_FOR_DOCUMENTATION)) {
      eligibilityDeterminationDB.setIndCtznshpForDocumentation(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_FOR_DOCUMENTATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_HOSPITAL_CRTFCT)) {
      eligibilityDeterminationDB.setIndCtznshpHospitalCrtfct(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_HOSPITAL_CRTFCT));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP)) {
      eligibilityDeterminationDB.setIndCtznshpLeglImmiStatExp(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpLifeInsBrthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpLoclGovtBrthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_MED_BIRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpMedBirthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_MED_BIRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpMiltryBirthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_NO_DOCUMENTATION)) {
      eligibilityDeterminationDB.setIndCtznshpNoDocumentation(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_NO_DOCUMENTATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_NORTH_MARIANA_ID)) {
      eligibilityDeterminationDB.setIndCtznshpNorthMarianaId(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_NORTH_MARIANA_ID));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_NTRLZTN_CRTFCT)) {
      eligibilityDeterminationDB.setIndCtznshpNtrlztnCrtfct(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_NTRLZTN_CRTFCT));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_PASSPORT)) {
      eligibilityDeterminationDB.setIndCtznshpPassport(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_PASSPORT));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_REFUGEE)) {
      eligibilityDeterminationDB.setIndCtznshpRefugee(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_REFUGEE));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_RELIG_BIRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpReligBirthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_RELIG_BIRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_RESIDENT_CARD)) {
      eligibilityDeterminationDB.setIndCtznshpResidentCard(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_RESIDENT_CARD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_UNACC_MINOR_CHILD)) {
      eligibilityDeterminationDB.setIndCtznshpUnaccMinorChild(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_UNACC_MINOR_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_UNDOC_IMMIGRANT)) {
      eligibilityDeterminationDB.setIndCtznshpUndocImmigrant(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_UNDOC_IMMIGRANT));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpUsHsptlBrthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_US_ID_CARD)) {
      eligibilityDeterminationDB.setIndCtznshpUsIdCard(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_US_ID_CARD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD)) {
      eligibilityDeterminationDB.setIndCtznshpVitalBirthRcrd(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_SAVE_SYSTEM)) {
      eligibilityDeterminationDB.setIndCtznshpSaveSystem(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_SAVE_SYSTEM));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_STUDENT_VISA)) {
      eligibilityDeterminationDB.setIndCtznshpStudentVisa(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_STUDENT_VISA));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTZNSHP_SUCCESS_SYSTEM)) {
      eligibilityDeterminationDB.setIndCtznshpSuccessSystem(ContextHelper.getBooleanSafe(request,EligibilityDeterminationDB.IND_CTZNSHP_SUCCESS_SYSTEM));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ELIGIBILITY_COURT_MONTH)) {
      eligibilityDeterminationDB.setIndEligibilityCourtMonth(ContextHelper.getBooleanSafe(request,
                                                                                          EligibilityDeterminationDB.IND_ELIGIBILITY_COURT_MONTH));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_ELIGIBLE)) {
      eligibilityDeterminationDB.setIndEligible(ContextHelper.getBooleanSafe(request,
                                                                             EligibilityDeterminationDB.IND_ELIGIBLE));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_EQUITY)) {
      eligibilityDeterminationDB.setIndEquity(ContextHelper.getBooleanSafe(request,
                                                                           EligibilityDeterminationDB.IND_EQUITY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_FATHER_PWE)) {
      eligibilityDeterminationDB.setIndFatherPwe(ContextHelper.getBooleanSafe(request,
                                                                              EligibilityDeterminationDB.IND_FATHER_PWE));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_HOME_INCOME_AFDC_ELGBLTY)) {
      eligibilityDeterminationDB.setIndHomeIncomeAfdcElgblty(ContextHelper.getBooleanSafe(request,
                                                                                          EligibilityDeterminationDB.IND_HOME_INCOME_AFDC_ELGBLTY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_MEETS_DP_OR_NOT_ES)) {
      eligibilityDeterminationDB.setIndMeetsDpOrNotEs(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_MEETS_DP_OR_NOT_ES));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_MEETS_DP_OR_NOT_SYSTEM)) {
      eligibilityDeterminationDB.setIndMeetsDpOrNotSystem(ContextHelper.getBooleanSafe(request,
                                                                                       EligibilityDeterminationDB.IND_MEETS_DP_OR_NOT_SYSTEM));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_MOTHER_PWE)) {
      eligibilityDeterminationDB.setIndMotherPwe(ContextHelper.getBooleanSafe(request,
                                                                              EligibilityDeterminationDB.IND_MOTHER_PWE));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_NARRATIVE_APPROVED)) {
      eligibilityDeterminationDB.setIndNarrativeApproved(ContextHelper.getBooleanSafe(request,
                                                                                      EligibilityDeterminationDB.IND_NARRATIVE_APPROVED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_OTHER_VERIFICATION)) {
      eligibilityDeterminationDB.setIndOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                                      EligibilityDeterminationDB.IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_PARENTAL_DEPRIVATION)) {
      eligibilityDeterminationDB.setIndParentalDeprivation(ContextHelper.getBooleanSafe(request,
                                                                                        EligibilityDeterminationDB.IND_PARENTAL_DEPRIVATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_PARENT_DISABLED)) {
      eligibilityDeterminationDB.setIndParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_PARENT_DISABLED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_PRS_MANAGING_CVS)) {
      eligibilityDeterminationDB.setIndPrsManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_PRS_MANAGING_CVS));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_REMOVAL_CHILD_ORDERED)) {
      eligibilityDeterminationDB.setIndRemovalChildOrdered(ContextHelper.getBooleanSafe(request,
                                                                                        EligibilityDeterminationDB.IND_REMOVAL_CHILD_ORDERED));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_RSDI_VERIFICATION)) {
      eligibilityDeterminationDB.setIndRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                                     EligibilityDeterminationDB.IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_RSNBL_EFFORT_PRVT_REMOVAL)) {
      eligibilityDeterminationDB.setIndRsnblEffortPrvtRemoval(ContextHelper.getBooleanSafe(request,
                                                                                           EligibilityDeterminationDB.IND_RSNBL_EFFORT_PRVT_REMOVAL));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_SSI_VERIFICATION)) {
      eligibilityDeterminationDB.setIndSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                                    EligibilityDeterminationDB.IND_SSI_VERIFICATION));
    }
    if (map.containsKey(EligibilityDeterminationDB.NBR_CERTIFIED_GROUP)) {
      eligibilityDeterminationDB.setNbrCertifiedGroup(ContextHelper.getLongSafe(request,
                                                                                EligibilityDeterminationDB.NBR_CERTIFIED_GROUP));
    }
    if (map.containsKey(EligibilityDeterminationDB.NBR_PARENTS_HOME)) {
      eligibilityDeterminationDB.setNbrParentsHome(ContextHelper.getLongSafe(request,
                                                                             EligibilityDeterminationDB.NBR_PARENTS_HOME));
    }
    if (map.containsKey(EligibilityDeterminationDB.TXT_DETERMINATION_COMMENTS)) {
      eligibilityDeterminationDB.setTxtDeterminationComments(ContextHelper.getStringSafe(request,
                                                                                         EligibilityDeterminationDB.TXT_DETERMINATION_COMMENTS));
    }
    if (map.containsKey(EligibilityDeterminationDB.ID_EVENT)) {
      eligibilityDeterminationDB.setIdEvent(ContextHelper.getLongSafe(request, EligibilityDeterminationDB.ID_EVENT));
    }
    if (map.containsKey(EligibilityDeterminationDB.CD_EVENT_STATUS)) {
      eligibilityDeterminationDB.setCdEventStatus(ContextHelper.getStringSafe(request, EligibilityDeterminationDB.CD_EVENT_STATUS));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_INCOME_CEILING)) {
      eligibilityDeterminationDB.setAmtGrossIncomeCeiling(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_GROSS_INCOME_CEILING));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STANDARD_OF_NEED)) {
      eligibilityDeterminationDB.setAmtStandardOfNeed(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_STANDARD_OF_NEED));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_DEPENDENT_CARE_DEDUC)) {
      eligibilityDeterminationDB.setAmtDependentCareDeduc(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_DEPENDENT_CARE_DEDUC));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_ALLOC_ALLOWANCE)) {
      eligibilityDeterminationDB.setAmtAllocAllowance(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_ALLOC_ALLOWANCE));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_COUNTABLE_INCOME_STD_NEED)) {
      eligibilityDeterminationDB.setAmtCountableIncomeStdNeed(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_COUNTABLE_INCOME_STD_NEED));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_COUNTABLE_INCOME_30_ONE_THIRD)) {
      eligibilityDeterminationDB.setAmtCountableIncome30OneThird(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_COUNTABLE_INCOME_30_ONE_THIRD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STD_EARNED_INCOME_DEDUCT)) {
      eligibilityDeterminationDB.setAmtStdEarnedIncomeDeduct(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_STD_EARNED_INCOME_DEDUCT));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_CNTBL_RESOURCE_CHILD)) {
      eligibilityDeterminationDB.setAmtCtnblResourceChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_CNTBL_RESOURCE_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_EARNED_CHILD)) {
      eligibilityDeterminationDB.setAmtGrossEarnedChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_GROSS_EARNED_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_UNEARNED_CHILD)) {
      eligibilityDeterminationDB.setAmtGrossUnEarnedChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_GROSS_UNEARNED_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_CNTBL_INC_STD_NEED_CHILD)) {
      eligibilityDeterminationDB.setAmtCntblIncStdNeedChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_CNTBL_INC_STD_NEED_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_CNTBL_INC_30_1_3_CHILD)) {
      eligibilityDeterminationDB.setAmtCntblInc30OneThirdChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_CNTBL_INC_30_1_3_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_DEP_CARE_DEDUC_CHILD)) {
      eligibilityDeterminationDB.setAmtDepCareDeducChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_DEP_CARE_DEDUC_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_GROSS_INCOME_CEILING_CHILD)) {
      eligibilityDeterminationDB.setAmtGrossIncomeCeilingChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_GROSS_INCOME_CEILING_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.AMT_STD_OF_NEED_CHILD)) {
      eligibilityDeterminationDB.setAmtStdOfNeedChild(ContextHelper.getDoubleSafe(request, EligibilityDeterminationDB.AMT_STD_OF_NEED_CHILD));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CTNBL_RES_CHILD_ELGBLTY)) {
      eligibilityDeterminationDB.setIndCtnblResChildElgblty(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_CTNBL_RES_CHILD_ELGBLTY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_GROSS_INC_CHILD_ELGBLTY)) {
      eligibilityDeterminationDB.setIndGrossIncChildElgblty(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_GROSS_INC_CHILD_ELGBLTY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_STD_OF_NEED_CHILD_TEST_ELGBLTY)) {
      eligibilityDeterminationDB.setIndStdOfNeedChildTestElgblty(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_STD_OF_NEED_CHILD_TEST_ELGBLTY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_30_1_3_CHILD_TEST_ELGBLTY)) {
      eligibilityDeterminationDB.setInd30OneThirdChildTestElgblty(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_30_1_3_CHILD_TEST_ELGBLTY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_GROSS_INC_CEILING_ELGBLTY)) {
      eligibilityDeterminationDB.setIndGrossIncCeilingElgblty(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_GROSS_INC_CEILING_ELGBLTY));
    }
    if (map.containsKey(EligibilityDeterminationDB.IND_CHILD_RECEIVING_SSI)) {
      eligibilityDeterminationDB.setIndChildReceivingSSI(ContextHelper.getBooleanSafe(request,
                                                                                   EligibilityDeterminationDB.IND_CHILD_RECEIVING_SSI));
    }
  }
}
