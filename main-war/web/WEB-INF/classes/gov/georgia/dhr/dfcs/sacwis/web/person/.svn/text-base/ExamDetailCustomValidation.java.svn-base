package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/*
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *
 * 
 */

/**
 * <p/> This class validates data submitted from the Examination Detail Page.
 * </p>
 * <p/> <p/> Error Message Summaries are as follows:
 * </p>
 * <blockquote>
 * <ol>
 * <li> MSG_CMN_YDP_SCORE Score is required when the examination is marked passed.
 * <li> MSG_FP_DATE_BEFORE_SAME_CURR Date must be before or the same as the current date and in the correct format MM/DD/YYYY..
 * </ol>
 * </blockquote>
 * 
 * @author Nandita Hegde 03/20/2007
 */
@SuppressWarnings("serial")
public class ExamDetailCustomValidation extends FormValidation {

  // static constants
  private static final String TXT_SCORE = "txtScore";

  private static final String IND_PASSED = "cbxPassed";

  private static final String DT_TAKEN = "dtExam";

  /** @return result - Returns false if the data fails validation. Returns true if the data passes validation. */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();

    boolean result = true;
    // get score and passed values
    String score = ContextHelper.getStringSafe(request, TXT_SCORE);
    String passed = ContextHelper.getStringSafe(request, IND_PASSED);
    Date dtTaken = ContextHelper.getJavaDateSafe(request, DT_TAKEN);

    if (super.isButtonPressed("btnSave")) {
      // check if score is entered when passed.
      if (ArchitectureConstants.Y.equals(passed) && ("".equals(score) || score == null)) {
        setErrorMessage(Messages.MSG_CMN_YDP_SCORE);
        result = false;
      }
    }
    if (!DateHelper.isNull(dtTaken)) {
      if (DateHelper.isAfterToday(dtTaken)) {
        result = false;
        setErrorMessage("dtExam", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
      }
    }
    performanceTrace.exitScope();
    return result;
  }

  public static final String TRACE_TAG = "ExamDetailCustomValidation";

}
