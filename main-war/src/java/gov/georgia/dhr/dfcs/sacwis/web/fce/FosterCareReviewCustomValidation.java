package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.ApplicationErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * <p>Title: FosterCareReviewCustomValidation</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: DFPS</p>
 * This class is used to perform the custom validation on FosterCare Review
 * @author Heather Dean
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 08/26/04  Todd Reser        SIR 23012 - Modified section to only throw errors
 *                             at or above age 18, instead of at age 17
 * </pre>
 */

/**

 */
public class FosterCareReviewCustomValidation
        extends FceCustomValidation {
  public static final String TRACE_TAG = "FosterCareReviewCustomValidation";

  /** validate the FosterCareReview form */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace =
            new PerformanceTrace(TRACE_TAG, "validateForm()");

    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();

    FosterCareReviewDB fosterCareReviewDB = null;

    try {
      GrndsExchangeContext context = super.getGrndsExchangeContext();
      fosterCareReviewDB = FosterCareReviewConversation.read(context);
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeWrappedException(e);
    }

    if (fosterCareReviewDB.getIndReviewInappropriate()) {
      //if comments are null and there are no displayed reasons, complain
      if (("".equals(fosterCareReviewDB.getTxtInappropriateComments())) &&
          (fosterCareReviewDB.getIndNoActivePlacement() == false) &&
          (fosterCareReviewDB.getIndNonPrsPaidPlacement() == false) &&
          (fosterCareReviewDB.getIndNoActiveBloc() == false) &&
          (fosterCareReviewDB.getIndNoOpenPaidEligibility() == false)) {
        setErrorMessage("txtInappropriateComments",
                        Messages.MSG_REVIEW_INAPPROPRIATE_COMMENTS_REQUIRED);
        return false;
      }
      return true;
    }

    boolean incomeFieldsDisabled = true;
    if (false == ContextHelper.getBooleanSafe(request, "disableIncomeResourcesFields")) {
      incomeFieldsDisabled = false;
    }
    if (!incomeFieldsDisabled) {
      validateIncome(fosterCareReviewDB);
    }
    validateNoIncomeCheckboxes(fosterCareReviewDB);

    return getErrorMessages().isEmpty();
  }

  /** validate "No Income" checkboxes have been checked */
  private void validateNoIncomeCheckboxes(FosterCareReviewDB fosterCareReviewDB) {
    List incomeForChild = fosterCareReviewDB.getIncomeForChild();
    if (incomeForChild == null) {
      incomeForChild = new ArrayList();
    }

    Iterator iterator = incomeForChild.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      double amountIncome = fceIncomeDB.getAmtIncome();

      if ((amountIncome == 0.0) &&
          (fceIncomeDB.getIndNone() == false)) {
        setErrorMessage(Messages.MSG_NO_INCOME_IND_REQ);
        break;
      }
    }
  }

  /** validate earned/unearned, countable/exempt radios have been set */
  private void validateIncome(FosterCareReviewDB fosterCareReviewDB) {
    List incomeForChild = fosterCareReviewDB.getIncomeForChild();
    if (incomeForChild == null) {
      incomeForChild = new ArrayList();
    }

    Iterator iterator = incomeForChild.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      double amountIncome = fceIncomeDB.getAmtIncome();

      if ((amountIncome > 0.0) &&
          (fceIncomeDB.getIndEarnedObject() == null)) {
        setErrorMessage(Messages.MSG_EARNED_UNEARNED);
        break;
      }
    }

    iterator = incomeForChild.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      double amountIncome = fceIncomeDB.getAmtIncome();

      if ((amountIncome > 0.0) &&
          (fceIncomeDB.getIndCountableObject() == null)) {
        setErrorMessage(Messages.MSG_COUNTABLE_EXEMPT);
        break;
      }
    }

    List resourcesForChild = fosterCareReviewDB.getResourcesForChild();
    if (resourcesForChild == null) {
      resourcesForChild = new ArrayList();
    }
    iterator = resourcesForChild.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      double amountIncome = fceIncomeDB.getAmtIncome();

      if ((amountIncome > 0.0) &&
          (fceIncomeDB.getIndCountableObject() == null)) {
        setErrorMessage(Messages.MSG_COUNTABLE_EXEMPT_RSRC);
        break;
      }
    }

    iterator = resourcesForChild.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();

      //duplicated from ApplicationErrorList.checkInaccessibleExempt
      if ((fceIncomeDB.getIndNotAccessible()) &&
          ((fceIncomeDB.getIndCountableObject() == null) ||
           (fceIncomeDB.getIndCountable() == true))) {
        setErrorMessage(Messages.MSG_MARK_INACCESSIBLE_RESOURCE_EXEMPT);
        break;
      }
    }
  }
}
