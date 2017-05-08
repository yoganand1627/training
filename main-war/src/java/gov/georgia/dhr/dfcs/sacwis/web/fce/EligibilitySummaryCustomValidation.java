package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: EligibilitySummaryCustomValidation</p> <p>Copyright: Copyright (c) 2004</p> <p>Company: DFPS</p>
 *
 * @author Matt
 *         <p/>
 *         <pre>
 *                 Change History:
 *                 Date      User              Description
 *                 --------  ----------------  -------------------------------------------------
 *                 08/19/04  Todd Reser        Added changelog. Changed from a string to
 *                                             Messages.MSG_ACTUAL_ELIGIBILITY_NOT_IVE while I
 *                                             was in here.
 *                 08/20/04  Todd Reser        SIR 23012 - Added error message
 *                                             MSG_FCE_FUTURE_REVIEW_DATE
 *                 08/31/04  Todd Reser        SIR 23012 - added age < 17 to if statement to
 *                                             prevent and edit from erroneously showing up for
 *                                             17 year olds.  Modified Review Date error message
 *                 10/19/04  Todd Reser        Added comments.  Added SSM_SUB_REW_AFTER_START
 *                                             and fixed logic for SSM_SUB_REVIEW_OVER_12.
 *                 11/10/04  Todd Reser        Removed date from message when displaying
 *                                             Messages.MSG_FCE_FUTURE_REVIEW_DATE
 *                 06/11/09  arege             STGAP00014198 The re-determination date on the
 *                                             Eligibility Summary Page can be more than 6 months from the
 *                                             start date for Adoption Finalized cases.
 *                 </pre>
 */

public class EligibilitySummaryCustomValidation
        extends FormValidation {
  protected static final String TRACE_TAG = "EligibilitySummaryCustomValidation";

  public static final String TITLE_IV_E = FceConstants.TITLE_IV_E;
  public static final String STATE_PAID = FceConstants.STATE_PAID;
  public static final String MEDICAID_ASSISTANCE_ONLY = FceConstants.MEDICAID_ASSISTANCE_ONLY;
  public static final String NOT_ELIGIBLE = FceConstants.NOT_ELIGIBLE;
  public static final String NOT_ELIGIBLE_COUNTY_PAID = FceConstants.NOT_ELIGIBLE_COUNTY_PAID;

  /** @return result - Returns false if the data fails validation.  Returns true if the data passes validation. */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, "validateForm");

    try {
      HttpServletRequest request = getRequest();

      String password = ContextHelper.getStringSafe(request, "password");
      try {
        UserProfile userProfile = BasePrsConversation.getUserProfile(request);

        UserProfileHelper.validateLogin(userProfile.getUserLogonID(),
                                        password);
      }
      catch (SecurityException e) {
        e.printStackTrace();
        setErrorMessage("password", Messages.MSG_SUB_INVALID_PASSWORD);
        return false;
      }

      EligibilitySummaryDB eligibilitySummaryDB =
              EligibilitySummaryConversation.readFromRequest(request);

      return validateEligibilitySummary(eligibilitySummaryDB);
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeWrappedException(e);
    }
    finally {
      performanceTrace.exitScope();
    }
  }

  public boolean validateEligibilitySummary(EligibilitySummaryDB eligibilitySummaryDB) {
    HttpServletRequest request = getRequest();

    Date startDate = eligibilitySummaryDB.getDtEligStart();
    Date endDate = eligibilitySummaryDB.getDtEligEnd();
    Date reviewDate = eligibilitySummaryDB.getDtEligReview();
    Date birthDate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(
            request, "BirthDate"));
    int age = DateHelper.getAge(birthDate);

    Date currentDate = new Date();

    // Complain if Startdate is more than 12 months in the future
    if (startDate.after(DateHelper.addToDate(currentDate, 0, 12, 0))) {
      setErrorMessage(EligibilitySummaryDB.DT_ELIG_START_STRING,
                      Messages.SSM_START_FUTURE_SOONER_12);
    }

    // Complain if end date is before start date
    if ((endDate != null) &&
        (endDate.before(startDate))) {
      setErrorMessage(Messages.SSM_START_BEFORE_SAME_END);
    }

    // Complain if end date is a future date
    if ((endDate != null) &&
        (endDate.after(currentDate))) {
      setErrorMessage(EligibilitySummaryDB.DT_ELIG_END_STRING, Messages.SSM_DATE_BEFORE_SAME_CURR);
    }
    
    //make sure they have a closure reason if there is an end date
    if (endDate != null && "".equals(eligibilitySummaryDB.getCdFceEligReason())){
      setErrorMessage(EligibilitySummaryDB.CD_FCE_ELIG_REASON, Messages.MSG_FCE_END_DATE_REASON);
    }
    
    if (reviewDate != null) {
      Date startDatePlus6Months = DateHelper.addToDate(startDate,
                                                     0,
                                                     6,
                                                     0);
      //Date startDatePlus12Months = DateHelper.addToDate(startDate, 1, 0, 0);

      //Complain if the review date is before the start date
      if (reviewDate.before(startDate)) {
        setErrorMessage(Messages.SSM_SUB_REW_AFTER_START);
      }

      // Complain if review date is over 6 months from start date
      // STGAP00014198: If in PAD stage i.e. Case where adoption has been finalized , the
      // re-determination date can be over 6 months from start date
      if (!CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request))) {
        if (reviewDate.after(startDatePlus6Months)) {
          setErrorMessage(Messages.MSG_FCE_REVIEW_DATE_AFTER_6);
        }
      }

      // SIR 23012 - If Review Date is later than 8 days after their birthday
      // when over age 17 complain.
      if (age >= 18 && reviewDate.after(DateHelper.addToDate(birthDate, age + 1, 1, 0))) {
        setErrorMessage(EligibilitySummaryDB.DT_ELIG_REVIEW_STRING, MessageLookup.getMessageByNumber(
                Messages.MSG_FCE_FUTURE_REVIEW_DATE));
      }
    }

    validateActualVersusSelectedEligibility(eligibilitySummaryDB);
    validateActualVersusSystemDerived(eligibilitySummaryDB);
    
    String selectedEligibility = eligibilitySummaryDB.getCdEligSelected();
    String medicaidEligibility = eligibilitySummaryDB.getCdEligMedEligGroup();

    if (("".equals(medicaidEligibility) == false) &&
        ((selectedEligibility.equals(NOT_ELIGIBLE)) ||
         (selectedEligibility.equals(NOT_ELIGIBLE_COUNTY_PAID)))) {
      setErrorMessage(Messages.MSG_NOT_ELIGIBLE_SELECTED);
    }
    if (("".equals(medicaidEligibility)) &&
        ((selectedEligibility.equals(TITLE_IV_E)) ||
         (selectedEligibility.equals(STATE_PAID)) ||
         (selectedEligibility.equals(MEDICAID_ASSISTANCE_ONLY)))) {
      setErrorMessage(Messages.MSG_MEDICAID_RQUIRED);
    }

    boolean childSupportQuestionChecked =
            eligibilitySummaryDB.getIndEligCsupSend();

 
    String childSupportComment = eligibilitySummaryDB.getTxtChildSuppRefComment();
    if (!childSupportQuestionChecked && !StringHelper.isValid(childSupportComment)) {
      setErrorMessage(Messages.MSG_FCE_COMMENT_CHILD_SUP_REF);
    }

    return this.getErrorMessages().isEmpty();
  }

  // pulled into a separate method so only 1 error message in this set will be
  // displayed at a time
  protected void validateActualVersusSelectedEligibility(EligibilitySummaryDB eligibilitySummaryDB) {
    String actualEligibility = eligibilitySummaryDB.getCdEligActual();
    String selectedEligibility = eligibilitySummaryDB.getCdEligSelected();

    // SIR 19296 - State-Paid can also have any option (except Title IVE) for
    // Selected
    if (((actualEligibility.equals(TITLE_IV_E) == false) &&
         (actualEligibility.equals(STATE_PAID) == false)) &&
                                                          (actualEligibility.equals(selectedEligibility) == false)) {
      setErrorMessage(Messages.MSG_ACT_EQUAL_SELECTED);
      return;
    }

    // SIR 19296 - State-Paid Actual can't have Title-IVE Selected
    if (actualEligibility.equals(STATE_PAID) &&
        selectedEligibility.equals(TITLE_IV_E)) {
      setErrorMessage(Messages.MSG_ACTUAL_ELIGIBILITY_NOT_IVE);
      return;
    }
  }
  
  protected void validateActualVersusSystemDerived(EligibilitySummaryDB eligibilitySummaryDB){
    // Complain if user chooses an Actual Eligibility value that is different from 
    // the System-Derived Eligibility, and no Comments have been entered.
    String actualEligibility = eligibilitySummaryDB.getCdEligActual();
    String eligibilityComment = eligibilitySummaryDB.getTxtEligComment();
    boolean isEligible = eligibilitySummaryDB.getIndEligible();
    if((isEligible && !TITLE_IV_E.equals(actualEligibility)) && !StringHelper.isValid(eligibilityComment)){
      setErrorMessage(Messages.MSG_FCE_COMMENT_ELIG_DIFF);
    } else if((!isEligible && TITLE_IV_E.equals(actualEligibility)) && !StringHelper.isValid(eligibilityComment)){
      setErrorMessage(Messages.MSG_FCE_COMMENT_ELIG_DIFF);
    }
  }
}
