/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hong.van.t.vo
 * 
 */
@SuppressWarnings("serial")
public class YouthDetailCustomValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "YouthDetailCustomValidation";

  private static final double MAX_GPA = 5.0;

  private static final String ERR_MSG_GPA = "GPA cannot be greater " + MAX_GPA;

  /**
   * <p>
   * This method contains custom validation for Youth Detail activities.
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;

    Date dtEmanDiscDate = ContextHelper.getJavaDateSafe(request, "dtEmanDisc");
    Date dtActualPostDate = ContextHelper.getJavaDateSafe(request, "dtActualPostGrad");
    Date dtActualGedCompDate = ContextHelper.getJavaDateSafe(request, "dtActualGEDComp");
    String txtHsCurrentGPA = ContextHelper.getStringSafe(request, "txtHsCurrentGPA");
    String txtHsCumulativeGPA = ContextHelper.getStringSafe(request, "txtHsCumulativeGPA");
    String txtPostCurrentGPA = ContextHelper.getStringSafe(request, "txtPostCurrentGPA");
    String txtPostCumulativeGPA = ContextHelper.getStringSafe(request, "txtPostCumulativeGPA");

    // Emancipation Discussion date cannot be after today's date
    if (!DateHelper.isNull(dtEmanDiscDate)) {
      if (DateHelper.isAfterToday(dtEmanDiscDate)) {
        isValid = false;
        setErrorMessage("dtEmanDisc", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
      }
    }
    // Actual post secondary education date cannot be after today's date
    if (!DateHelper.isNull(dtActualPostDate)) {
      if (DateHelper.isAfterToday(dtActualPostDate)) {
        isValid = false;
        setErrorMessage("dtActualPostGrad", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
      }
    }
    // Actual GED completion date cannot be after today's date
    if (!DateHelper.isNull(dtActualGedCompDate)) {
      if (DateHelper.isAfterToday(dtActualGedCompDate)) {
        isValid = false;
        setErrorMessage("dtActualGEDComp", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
      }
    }

    double numHsCurrGPA = 0.0;
    double numHsCumGPA = 0.0;
    double numPostCurrGPA = 0.0;
    double numPostCumGPA = 0.0;

    if (StringHelper.isValid(txtHsCurrentGPA)) {
      numHsCurrGPA = Double.parseDouble(txtHsCurrentGPA);
    }
    if (StringHelper.isValid(txtHsCumulativeGPA)) {
      numHsCumGPA = Double.parseDouble(txtHsCumulativeGPA);
    }
    if (StringHelper.isValid(txtPostCurrentGPA)) {
      numPostCurrGPA = Double.parseDouble(txtPostCurrentGPA);
    }
    if (StringHelper.isValid(txtPostCumulativeGPA)) {
      numPostCumGPA = Double.parseDouble(txtPostCumulativeGPA);
    }

    if (numHsCurrGPA > MAX_GPA || numHsCumGPA > MAX_GPA) {
      isValid = false;
      setErrorMessage(ERR_MSG_GPA);
    }
    if (numPostCurrGPA > MAX_GPA || numPostCumGPA > MAX_GPA) {
      isValid = false;
      setErrorMessage(ERR_MSG_GPA);
    }

    return isValid;
  }
}
