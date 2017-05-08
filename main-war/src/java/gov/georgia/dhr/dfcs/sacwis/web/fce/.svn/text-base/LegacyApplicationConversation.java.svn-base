package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.LegacyApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.LegacyApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.FosterCareReview;
import gov.georgia.dhr.dfcs.sacwis.service.fce.LegacyApplication;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * this is the non-Title IV-E checklist
 *
 * @author Rodrigo DeJuana, March 4, 2003
 */
public class LegacyApplicationConversation extends FceConversation {
  public static final String TRACE_TAG = "LegacyApplicationConversation";
  public static final String LEGACYDB = "legacyDB";

  private FosterCareReview fosterCareReview;
  private LegacyApplication legacyApplication;

  public void setFosterCareReview(FosterCareReview fosterCareReview) {
    this.fosterCareReview = fosterCareReview;
  }

  public void setLegacyApplication(LegacyApplication legacyApplication) {
    this.legacyApplication = legacyApplication;
  }

  public LegacyApplicationConversation() {
    super(TRACE_TAG);
  }

  /**
   * Blank method just to show general pattern of a Activity Method, including naming standards, etc.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayLegacyApplication_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayLegacyApplication_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    clearState(context);
    FceUtility.setReviewFceTabState(request, true);

    try {
      LegacyApplicationDB legacyDB = legacyApplication.read(GlobalData.getUlIdStage(request),
                                                            GlobalData.getUlIdEvent(request),
                                                            getUserID(request));

      request.setAttribute(LEGACYDB, legacyDB);
      setPageMode(context, legacyDB);

      state.setAttribute(FosterCareReviewConversation.ALREADY_CHECKED_LEGACY, Boolean.TRUE, request);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Blank method just to show general pattern of a Activity Method, including naming standards, etc.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveLegacyApplication_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveLegacyApplication_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      LegacyApplicationDB legacyDB = new LegacyApplicationDB();
      clearFields(legacyDB);
      populateWithRequest(legacyDB, request);

//      trace(legacyDB.toString());

      legacyApplication.save(legacyDB);
      int eventId = GlobalData.getUlIdEvent(request);
      fosterCareReview.updateSystemDerivedParentalDeprivation(eventId);
      state.setAttribute(FosterCareReviewConversation.ALREADY_CHECKED_LEGACY, Boolean.TRUE, request);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /** @param context Contains the session, state, and request objects to get data from jsps */
  public void continueLegacyApplication_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".continueLegacyApplication_xa()");
    BaseSessionStateManager state = getSessionStateManager(context);
    state.setAttribute(FosterCareReviewConversation.ALREADY_CHECKED_LEGACY, Boolean.TRUE, context.getRequest());
    performanceTrace.exitScope();
  }

  /**
   * Blank method just to show general pattern of a Activity Method, including naming standards, etc.
   *
   * @param legacyDB
   */
  private void clearFields(LegacyApplicationDB legacyDB) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".clearFields()");
    legacyDB.setIndChildUnder18(true);
    legacyDB.setIndChildQualifiedCitizen(true);
    legacyDB.setIndParentalDeprivation(true);
    legacyDB.setIndChildLivingPrnt6Mnths(true);
    legacyDB.setIndHomeIncomeAfdcElgblty(true);
    legacyDB.setIndEquity(false); //see ApplicationReasonsNotEligible
    legacyDB.setIndEligibilityCourtMonth(true);
    legacyDB.setIndRemovalChildOrdered(true);
    legacyDB.setIndRsnblEffortPrvtRemoval(true);
    legacyDB.setIndPrsManagingCvs(true);
    performanceTrace.exitScope();
  }

  /** @param context Contains the session, state, and request objects to get data from jsps */
  private void setPageMode(GrndsExchangeContext context, LegacyApplicationDB legacyDB) {
    HttpServletRequest request = context.getRequest();

    String pageMode = FceUtility.getFceReviewPageMode(request, legacyDB);

    UserProfile user = getUserProfile(request);
    if (user.hasRight(UserProfile.SEC_ELIGIBILITY) == false) {
      pageMode = PageModeConstants.VIEW;
    }

    PageMode.setPageMode(pageMode, request);
  }

  public static void populateWithRequest(LegacyApplicationDB legacyApplicationDB, HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(LegacyApplicationDB.AMT_COUNTABLE_INCOME)) {
      legacyApplicationDB.setAmtCountableIncome(ContextHelper.getDoubleSafe(request,
                                                                            LegacyApplicationDB.AMT_COUNTABLE_INCOME));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_COUNTABLE_INCOME_MONEY)) {
      legacyApplicationDB.setAmtCountableIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                   LegacyApplicationDB.AMT_COUNTABLE_INCOME_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_GROSS_EARNED_CRTFD_GRP)) {
      legacyApplicationDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                LegacyApplicationDB.AMT_GROSS_EARNED_CRTFD_GRP));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY)) {
      legacyApplicationDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                       LegacyApplicationDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_GROSS_UNEARNED_CRTFD_GRP)) {
      legacyApplicationDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                  LegacyApplicationDB.AMT_GROSS_UNEARNED_CRTFD_GRP));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY)) {
      legacyApplicationDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         LegacyApplicationDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_INCOME_LIMIT)) {
      legacyApplicationDB.setAmtIncomeLimit(ContextHelper.getDoubleSafe(request, LegacyApplicationDB.AMT_INCOME_LIMIT));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_INCOME_LIMIT_MONEY)) {
      legacyApplicationDB.setAmtIncomeLimit(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                               LegacyApplicationDB.AMT_INCOME_LIMIT_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_PWE_INCOME)) {
      legacyApplicationDB.setAmtPweIncome(ContextHelper.getDoubleSafe(request, LegacyApplicationDB.AMT_PWE_INCOME));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_PWE_INCOME_MONEY)) {
      legacyApplicationDB.setAmtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                             LegacyApplicationDB.AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_SSI)) {
      legacyApplicationDB.setAmtSsi(ContextHelper.getDoubleSafe(request, LegacyApplicationDB.AMT_SSI));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_SSI_MONEY)) {
      legacyApplicationDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request, LegacyApplicationDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_ALIMONY)) {
      legacyApplicationDB.setAmtStepparentAlimony(ContextHelper.getDoubleSafe(request,
                                                                              LegacyApplicationDB.AMT_STEPPARENT_ALIMONY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_ALIMONY_MONEY)) {
      legacyApplicationDB.setAmtStepparentAlimony(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                     LegacyApplicationDB.AMT_STEPPARENT_ALIMONY_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_ALLOWANCE)) {
      legacyApplicationDB.setAmtStepparentAllowance(ContextHelper.getDoubleSafe(request,
                                                                                LegacyApplicationDB.AMT_STEPPARENT_ALLOWANCE));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_ALLOWANCE_MONEY)) {
      legacyApplicationDB.setAmtStepparentAllowance(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                       LegacyApplicationDB.AMT_STEPPARENT_ALLOWANCE_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_APPLIED_INCOME)) {
      legacyApplicationDB.setAmtStepparentAppliedIncome(ContextHelper.getDoubleSafe(request,
                                                                                    LegacyApplicationDB.AMT_STEPPARENT_APPLIED_INCOME));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY)) {
      legacyApplicationDB.setAmtStepparentAppliedIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                           LegacyApplicationDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_CNTBL_UNEARNED)) {
      legacyApplicationDB.setAmtStepparentCntblUnearned(ContextHelper.getDoubleSafe(request,
                                                                                    LegacyApplicationDB.AMT_STEPPARENT_CNTBL_UNEARNED));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY)) {
      legacyApplicationDB.setAmtStepparentCntblUnearned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                           LegacyApplicationDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_GROSS_EARNED)) {
      legacyApplicationDB.setAmtStepparentGrossEarned(ContextHelper.getDoubleSafe(request,
                                                                                  LegacyApplicationDB.AMT_STEPPARENT_GROSS_EARNED));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_GROSS_EARNED_MONEY)) {
      legacyApplicationDB.setAmtStepparentGrossEarned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         LegacyApplicationDB.AMT_STEPPARENT_GROSS_EARNED_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_OUTSIDE_PMNT)) {
      legacyApplicationDB.setAmtStepparentOutsidePmnt(ContextHelper.getDoubleSafe(request,
                                                                                  LegacyApplicationDB.AMT_STEPPARENT_OUTSIDE_PMNT));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) {
      legacyApplicationDB.setAmtStepparentOutsidePmnt(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         LegacyApplicationDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_TOTAL_CNTBL)) {
      legacyApplicationDB.setAmtStepparentTotalCntbl(ContextHelper.getDoubleSafe(request,
                                                                                 LegacyApplicationDB.AMT_STEPPARENT_TOTAL_CNTBL));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY)) {
      legacyApplicationDB.setAmtStepparentTotalCntbl(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        LegacyApplicationDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_WORK_DEDUCT)) {
      legacyApplicationDB.setAmtStepparentWorkDeduct(ContextHelper.getDoubleSafe(request,
                                                                                 LegacyApplicationDB.AMT_STEPPARENT_WORK_DEDUCT));
    }
    if (map.containsKey(LegacyApplicationDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY)) {
      legacyApplicationDB.setAmtStepparentWorkDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        LegacyApplicationDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY));
    }
    if (map.containsKey(LegacyApplicationDB.CD_BLOC_CHILD)) {
      legacyApplicationDB.setCdBlocChild(ContextHelper.getStringSafe(request, LegacyApplicationDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(LegacyApplicationDB.CD_ELIGIBILITY_ACTUAL)) {
      legacyApplicationDB.setCdEligibilityActual(ContextHelper.getStringSafe(request,
                                                                             LegacyApplicationDB.CD_ELIGIBILITY_ACTUAL));
    }
    if (map.containsKey(LegacyApplicationDB.CD_ELIGIBILITY_SELECTED)) {
      legacyApplicationDB.setCdEligibilitySelected(ContextHelper.getStringSafe(request,
                                                                               LegacyApplicationDB.CD_ELIGIBILITY_SELECTED));
    }
    if (map.containsKey(LegacyApplicationDB.CD_MEDICAID_ELIGIBILITY_TYPE)) {
      legacyApplicationDB.setCdMedicaidEligibilityType(ContextHelper.getStringSafe(request,
                                                                                   LegacyApplicationDB.CD_MEDICAID_ELIGIBILITY_TYPE));
    }
    if (map.containsKey(LegacyApplicationDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP)) {
      legacyApplicationDB.setFceEligibilityCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                                           LegacyApplicationDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(LegacyApplicationDB.CD_PWE_IRREGULAR_UNDER100)) {
      legacyApplicationDB.setCdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                                LegacyApplicationDB.CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(LegacyApplicationDB.CD_PWE_STEADY_UNDER100)) {
      legacyApplicationDB.setCdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                             LegacyApplicationDB.CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(LegacyApplicationDB.DT_ELIGIBILITY_END_STRING)) {
      legacyApplicationDB.setDtEligibilityEndString(ContextHelper.getStringSafe(request,
                                                                                LegacyApplicationDB.DT_ELIGIBILITY_END_STRING));
    }
    if (map.containsKey(LegacyApplicationDB.DT_ELIGIBILITY_END_TIME)) {
      legacyApplicationDB.setDtEligibilityEndTime(ContextHelper.getLongSafe(request,
                                                                            LegacyApplicationDB.DT_ELIGIBILITY_END_TIME));
    }
    if (map.containsKey(LegacyApplicationDB.DT_ELIG_DTRMNTN_START_STRING)) {
      legacyApplicationDB.setDtEligDtrmntnStartString(ContextHelper.getStringSafe(request,
                                                                                  LegacyApplicationDB.DT_ELIG_DTRMNTN_START_STRING));
    }
    if (map.containsKey(LegacyApplicationDB.DT_ELIG_DTRMNTN_START_TIME)) {
      legacyApplicationDB.setDtEligDtrmntnStartTime(ContextHelper.getLongSafe(request,
                                                                              LegacyApplicationDB.DT_ELIG_DTRMNTN_START_TIME));
    }
    if (map.containsKey(LegacyApplicationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      legacyApplicationDB.setFceEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                          LegacyApplicationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(LegacyApplicationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      legacyApplicationDB.setFceEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                      LegacyApplicationDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(LegacyApplicationDB.DT_REMOVAL_CHILD_ORDERED_STRING)) {
      legacyApplicationDB.setDtRemovalChildOrderedString(ContextHelper.getStringSafe(request,
                                                                                     LegacyApplicationDB.DT_REMOVAL_CHILD_ORDERED_STRING));
    }
    if (map.containsKey(LegacyApplicationDB.DT_REMOVAL_CHILD_ORDERED_TIME)) {
      legacyApplicationDB.setDtRemovalChildOrderedTime(ContextHelper.getLongSafe(request,
                                                                                 LegacyApplicationDB.DT_REMOVAL_CHILD_ORDERED_TIME));
    }
    if (map.containsKey(LegacyApplicationDB.DT_REVIEW_DATE_STRING)) {
      legacyApplicationDB.setDtReviewDateString(ContextHelper.getStringSafe(request,
                                                                            LegacyApplicationDB.DT_REVIEW_DATE_STRING));
    }
    if (map.containsKey(LegacyApplicationDB.DT_REVIEW_DATE_TIME)) {
      legacyApplicationDB.setDtReviewDateTime(ContextHelper.getLongSafe(request,
                                                                        LegacyApplicationDB.DT_REVIEW_DATE_TIME));
    }
    if (map.containsKey(LegacyApplicationDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING)) {
      legacyApplicationDB.setDtRsnblEffortPreventRemString(ContextHelper.getStringSafe(request,
                                                                                       LegacyApplicationDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING));
    }
    if (map.containsKey(LegacyApplicationDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME)) {
      legacyApplicationDB.setDtRsnblEffortPreventRemTime(ContextHelper.getLongSafe(request,
                                                                                   LegacyApplicationDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME));
    }
    if (map.containsKey(LegacyApplicationDB.ID_CASE)) {
      legacyApplicationDB.setIdCase(ContextHelper.getLongSafe(request, LegacyApplicationDB.ID_CASE));
    }
    if (map.containsKey(LegacyApplicationDB.ID_ELIGIBILITY_EVENT)) {
      legacyApplicationDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request,
                                                                          LegacyApplicationDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(LegacyApplicationDB.ID_FCE_APPLICATION)) {
      legacyApplicationDB.setIdFceApplication(ContextHelper.getLongSafe(request,
                                                                        LegacyApplicationDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(LegacyApplicationDB.ID_FCE_ELIGIBILITY)) {
      legacyApplicationDB.setIdFceEligibility(ContextHelper.getLongSafe(request,
                                                                        LegacyApplicationDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(LegacyApplicationDB.ID_FCE_PERSON)) {
      legacyApplicationDB.setIdFcePerson(ContextHelper.getLongSafe(request, LegacyApplicationDB.ID_FCE_PERSON));
    }
    if (map.containsKey(LegacyApplicationDB.ID_FCE_REVIEW)) {
      legacyApplicationDB.setIdFceReview(ContextHelper.getLongSafe(request, LegacyApplicationDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(LegacyApplicationDB.ID_LAST_UPDATE_PERSON)) {
      legacyApplicationDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                          LegacyApplicationDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(LegacyApplicationDB.ID_PERSON)) {
      legacyApplicationDB.setIdPerson(ContextHelper.getLongSafe(request, LegacyApplicationDB.ID_PERSON));
    }
    if (map.containsKey(LegacyApplicationDB.ID_STAGE)) {
      legacyApplicationDB.setIdStage(ContextHelper.getLongSafe(request, LegacyApplicationDB.ID_STAGE));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_ALTRNT_CUSTODY)) {
      legacyApplicationDB.setIndAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                                 LegacyApplicationDB.IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_DEPORTED)) {
      legacyApplicationDB.setIndAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                            LegacyApplicationDB.IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_DESERTED)) {
      legacyApplicationDB.setIndAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                            LegacyApplicationDB.IND_ABSENT_DESERTED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_DIED)) {
      legacyApplicationDB.setIndAbsentDied(ContextHelper.getBooleanSafe(request, LegacyApplicationDB.IND_ABSENT_DIED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_DIVORCED)) {
      legacyApplicationDB.setIndAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                            LegacyApplicationDB.IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_FATHER)) {
      legacyApplicationDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                          LegacyApplicationDB.IND_ABSENT_FATHER));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_HOSPITALIZED)) {
      legacyApplicationDB.setIndAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                                LegacyApplicationDB.IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_INCARCERATED)) {
      legacyApplicationDB.setIndAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                                LegacyApplicationDB.IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_MILITARY_WORK)) {
      legacyApplicationDB.setIndAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                                LegacyApplicationDB.IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_MOTHER)) {
      legacyApplicationDB.setIndAbsentMother(ContextHelper.getBooleanSafe(request,
                                                                          LegacyApplicationDB.IND_ABSENT_MOTHER));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_SEPARATED)) {
      legacyApplicationDB.setIndAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                             LegacyApplicationDB.IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ABSENT_WORK_RELATED)) {
      legacyApplicationDB.setIndAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                               LegacyApplicationDB.IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CHILD_LIVING_PRNT6_MNTHS)) {
      legacyApplicationDB.setIndChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                   LegacyApplicationDB.IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CHILD_QUALIFIED_CITIZEN)) {
      legacyApplicationDB.setIndChildQualifiedCitizen(ContextHelper.getBooleanSafe(request,
                                                                                   LegacyApplicationDB.IND_CHILD_QUALIFIED_CITIZEN));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CHILD_SUPPORT_ORDERED)) {
      legacyApplicationDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                                 LegacyApplicationDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CHILD_UNDER18)) {
      legacyApplicationDB.setIndChildUnder18(ContextHelper.getBooleanSafe(request,
                                                                          LegacyApplicationDB.IND_CHILD_UNDER18));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_AMER_INDIAN_CRD)) {
      legacyApplicationDB.setIndCtznshpAmerIndianCrd(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_AMER_INDIAN_CRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_ATTORNEY_REVIEW)) {
      legacyApplicationDB.setIndCtznshpAttorneyReview(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_ATTORNEY_REVIEW));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_ABROAD)) {
      legacyApplicationDB.setIndCtznshpBirthAbroad(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_BIRTH_ABROAD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR)) {
      legacyApplicationDB.setIndCtznshpBirthCrtfctFor(ContextHelper.getBooleanSafe(request, FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_US)) {
      legacyApplicationDB.setIndCtznshpBirthCrtfctUs(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_BIRTH_CRTFCT_US));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpCensusBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CHLD_FOUND)) {
      legacyApplicationDB.setIndCtznshpChldFound(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CHLD_FOUND));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CITIZEN_CRTFCT)) {
      legacyApplicationDB.setIndCtznshpCitizenCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CITIZEN_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CIVIL_SERVICE_EMP)) {
      legacyApplicationDB.setIndCtznshpCivilServiceEmp(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CIVIL_SERVICE_EMP));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_CONFRM_BIRTH)) {
      legacyApplicationDB.setIndCtznshpConfrmBirth(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_CONFRM_BIRTH));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_EVALUATION)) {
      legacyApplicationDB.setIndCtznshpEvaluation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_EVALUATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_FINAL_ADOPT_DECREE)) {
      legacyApplicationDB.setIndCtznshpFinalAdoptDecree(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_FINAL_ADOPT_DECREE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_FOR_DOCUMENTATION)) {
      legacyApplicationDB.setIndCtznshpForDocumentation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_FOR_DOCUMENTATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_HOSPITAL_CRTFCT)) {
      legacyApplicationDB.setIndCtznshpHospitalCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_HOSPITAL_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP)) {
      legacyApplicationDB.setIndCtznshpLeglImmiStatExp(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpLifeInsBrthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpLoclGovtBrthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_MED_BIRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpMedBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_MED_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpMiltryBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NO_DOCUMENTATION)) {
      legacyApplicationDB.setIndCtznshpNoDocumentation(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NO_DOCUMENTATION));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NORTH_MARIANA_ID)) {
      legacyApplicationDB.setIndCtznshpNorthMarianaId(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NORTH_MARIANA_ID));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_NTRLZTN_CRTFCT)) {
      legacyApplicationDB.setIndCtznshpNtrlztnCrtfct(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_NTRLZTN_CRTFCT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_PASSPORT)) {
      legacyApplicationDB.setIndCtznshpPassport(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_PASSPORT));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_REFUGEE)) {
      legacyApplicationDB.setIndCtznshpRefugee(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_REFUGEE));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_RELIG_BIRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpReligBirthRcrd(ContextHelper.getBooleanSafe(request,FosterCareReviewDB.IND_CTZNSHP_RELIG_BIRTH_RCRD));
    }
    if (map.containsKey(FosterCareReviewDB.IND_CTZNSHP_RESIDENT_CARD)) {
      legacyApplicationDB.setIndCtznshpResidentCard(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_RESIDENT_CARD));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_UNACC_MINOR_CHILD)) {
      legacyApplicationDB.setIndCtznshpUnaccMinorChild(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_UNACC_MINOR_CHILD));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_UNDOC_IMMIGRANT)) {
      legacyApplicationDB.setIndCtznshpUndocImmigrant(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_UNDOC_IMMIGRANT));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpUsHsptlBrthRcrd(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_US_ID_CARD)) {
      legacyApplicationDB.setIndCtznshpUsIdCard(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_US_ID_CARD));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD)) {
      legacyApplicationDB.setIndCtznshpVitalBirthRcrd(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_VITAL_BIRTH_RCRD));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_SAVE_SYSTEM)) {
      legacyApplicationDB.setIndCtznshpSaveSystem(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_SAVE_SYSTEM));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_STUDENT_VISA)) {
      legacyApplicationDB.setIndCtznshpStudentVisa(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_STUDENT_VISA));
    }
    if (map.containsKey(LegacyApplicationDB.IND_CTZNSHP_SUCCESS_SYSTEM)) {
      legacyApplicationDB.setIndCtznshpSuccessSystem(ContextHelper.getBooleanSafe(request,LegacyApplicationDB.IND_CTZNSHP_SUCCESS_SYSTEM));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ELIGIBILITY_COURT_MONTH)) {
      legacyApplicationDB.setIndEligibilityCourtMonth(ContextHelper.getBooleanSafe(request,
                                                                                   LegacyApplicationDB.IND_ELIGIBILITY_COURT_MONTH));
    }
    if (map.containsKey(LegacyApplicationDB.IND_ELIGIBLE)) {
      legacyApplicationDB.setIndEligible(ContextHelper.getBooleanSafe(request, LegacyApplicationDB.IND_ELIGIBLE));
    }
    if (map.containsKey(LegacyApplicationDB.IND_EQUITY)) {
      legacyApplicationDB.setIndEquity(ContextHelper.getBooleanSafe(request, LegacyApplicationDB.IND_EQUITY));
    }
    if (map.containsKey(LegacyApplicationDB.IND_FATHER_PWE)) {
      legacyApplicationDB.setIndFatherPwe(ContextHelper.getBooleanSafe(request, LegacyApplicationDB.IND_FATHER_PWE));
    }
    if (map.containsKey(LegacyApplicationDB.IND_HOME_INCOME_AFDC_ELGBLTY)) {
      legacyApplicationDB.setIndHomeIncomeAfdcElgblty(ContextHelper.getBooleanSafe(request,
                                                                                   LegacyApplicationDB.IND_HOME_INCOME_AFDC_ELGBLTY));
    }
    if (map.containsKey(LegacyApplicationDB.IND_MEETS_DP_OR_NOT_ES)) {
      legacyApplicationDB.setIndMeetsDpOrNotEs(ContextHelper.getBooleanSafe(request,
                                                                            LegacyApplicationDB.IND_MEETS_DP_OR_NOT_ES));
    }
    if (map.containsKey(LegacyApplicationDB.IND_MEETS_DP_OR_NOT_SYSTEM)) {
      legacyApplicationDB.setIndMeetsDpOrNotSystem(ContextHelper.getBooleanSafe(request,
                                                                                LegacyApplicationDB.IND_MEETS_DP_OR_NOT_SYSTEM));
    }
    if (map.containsKey(LegacyApplicationDB.IND_MOTHER_PWE)) {
      legacyApplicationDB.setIndMotherPwe(ContextHelper.getBooleanSafe(request, LegacyApplicationDB.IND_MOTHER_PWE));
    }
    if (map.containsKey(LegacyApplicationDB.IND_NARRATIVE_APPROVED)) {
      legacyApplicationDB.setIndNarrativeApproved(ContextHelper.getBooleanSafe(request,
                                                                               LegacyApplicationDB.IND_NARRATIVE_APPROVED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_OTHER_VERIFICATION)) {
      legacyApplicationDB.setIndOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                               LegacyApplicationDB.IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(LegacyApplicationDB.IND_PARENTAL_DEPRIVATION)) {
      legacyApplicationDB.setIndParentalDeprivation(ContextHelper.getBooleanSafe(request,
                                                                                 LegacyApplicationDB.IND_PARENTAL_DEPRIVATION));
    }
    if (map.containsKey(LegacyApplicationDB.IND_PARENT_DISABLED)) {
      legacyApplicationDB.setIndParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                            LegacyApplicationDB.IND_PARENT_DISABLED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_PRS_MANAGING_CVS)) {
      legacyApplicationDB.setIndPrsManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                            LegacyApplicationDB.IND_PRS_MANAGING_CVS));
    }
    if (map.containsKey(LegacyApplicationDB.IND_REMOVAL_CHILD_ORDERED)) {
      legacyApplicationDB.setIndRemovalChildOrdered(ContextHelper.getBooleanSafe(request,
                                                                                 LegacyApplicationDB.IND_REMOVAL_CHILD_ORDERED));
    }
    if (map.containsKey(LegacyApplicationDB.IND_RSDI_VERIFICATION)) {
      legacyApplicationDB.setIndRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                              LegacyApplicationDB.IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(LegacyApplicationDB.IND_RSNBL_EFFORT_PRVT_REMOVAL)) {
      legacyApplicationDB.setIndRsnblEffortPrvtRemoval(ContextHelper.getBooleanSafe(request,
                                                                                    LegacyApplicationDB.IND_RSNBL_EFFORT_PRVT_REMOVAL));
    }
    if (map.containsKey(LegacyApplicationDB.IND_SSI_VERIFICATION)) {
      legacyApplicationDB.setIndSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                             LegacyApplicationDB.IND_SSI_VERIFICATION));
    }
    if (map.containsKey(LegacyApplicationDB.NBR_CERTIFIED_GROUP)) {
      legacyApplicationDB.setNbrCertifiedGroup(ContextHelper.getLongSafe(request,
                                                                         LegacyApplicationDB.NBR_CERTIFIED_GROUP));
    }
    if (map.containsKey(LegacyApplicationDB.NBR_PARENTS_HOME)) {
      legacyApplicationDB.setNbrParentsHome(ContextHelper.getLongSafe(request, LegacyApplicationDB.NBR_PARENTS_HOME));
    }
    if (map.containsKey(LegacyApplicationDB.TXT_DETERMINATION_COMMENTS)) {
      legacyApplicationDB.setTxtDeterminationComments(ContextHelper.getStringSafe(request,
                                                                                  LegacyApplicationDB.TXT_DETERMINATION_COMMENTS));
    }
    if (map.containsKey(LegacyApplicationDB.ID_EVENT)) {
      legacyApplicationDB.setIdEvent(ContextHelper.getLongSafe(request, LegacyApplicationDB.ID_EVENT));
    }
    if (map.containsKey(LegacyApplicationDB.CD_EVENT_STATUS)) {
      legacyApplicationDB.setCdEventStatus(ContextHelper.getStringSafe(request, LegacyApplicationDB.CD_EVENT_STATUS));
    }
  }
}
