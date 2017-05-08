package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

/**
 * This class is used to perform the custom validation on the Eligibility Determination Worksheet
 *
 * @author Rodrigo. DeJuana, March 4, 2003
 */
public class EligibilityDeterminationCustomValidation
        extends FormValidation {
  public static final long SIXTY_DAYS_IN_MINUTES = 60 * 24 * 60;

  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();

    EligibilityDeterminationDB eligibilityDeterminationDB =
            EligibilityDeterminationConversation.readFromRequest(request);

    Boolean removalOrdered = eligibilityDeterminationDB.getIndRemovalChildOrderedObject();
    Date dtRemovalOrdered = eligibilityDeterminationDB.getDtRemovalChildOrdered();
    Boolean rsnblEffort = eligibilityDeterminationDB.getIndRsnblEffortPrvtRemovalObject();
    Date dtRsnblEffort = eligibilityDeterminationDB.getDtRsnblEffortPreventRem();
    Boolean prsMngCvs = eligibilityDeterminationDB.getIndPrsManagingCvsObject();

    boolean bDetermineEligibility = super.isButtonPressed("btnDetermineEligibility");

    if ((removalOrdered != null) &&
        (removalOrdered) &&
        (dtRemovalOrdered == null)) {
      setErrorMessage(Messages.MSG_FIRST_ORDER_DATES_REQ);
    }

    if ((rsnblEffort != null) &&
        (rsnblEffort) &&
        (dtRsnblEffort == null)) {
      setErrorMessage(Messages.MSG_JUDICIAL_DATE_REQ);
    }

    if ((rsnblEffort != null) &&
        (dtRemovalOrdered != null) &&
        (dtRsnblEffort != null)) {
      long minutesDifferent = (long)
              Math.abs(DateHelper.minutesDifference(dtRemovalOrdered, dtRsnblEffort));

      if ((rsnblEffort) &&
          (minutesDifferent > SIXTY_DAYS_IN_MINUTES)) {
        setErrorMessage(Messages.MSG_FC_TIMEFRAME_INVALID1);
      }

      if ((!rsnblEffort) &&
          (minutesDifferent < SIXTY_DAYS_IN_MINUTES)) {
        setErrorMessage(Messages.MSG_FC_TIMEFRAME_INVALID2);
      }
    }

    validateDateNotInTheFuture(eligibilityDeterminationDB.getDtRemovalChildOrdered(),
                               EligibilityDeterminationDB.DT_REMOVAL_CHILD_ORDERED_STRING);

    validateDateNotInTheFuture(eligibilityDeterminationDB.getDtRsnblEffortPreventRem(),
                               EligibilityDeterminationDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING);

    if ((bDetermineEligibility) &&
        ((removalOrdered == null) ||
         (rsnblEffort == null) ||
         (prsMngCvs == null))) {
      setErrorMessage(Messages.MSG_ELIG_QUESTIONS_REQ);
    }

    return getErrorMessages().isEmpty();
  }

  protected void validateDateNotInTheFuture(Date date,
                                            String name) {
    Date today = new Date();

    if ((date != null) &&
        (date.after(today))) {
      setErrorMessage(name,
                      Messages.SSM_DATE_BEFORE_SAME_CURR);
    }
  }
}
