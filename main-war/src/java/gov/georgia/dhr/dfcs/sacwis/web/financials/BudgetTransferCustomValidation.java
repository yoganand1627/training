package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- java classes --

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate Case Search information.
 *
 * @author Paul Lang, February 21, 2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class BudgetTransferCustomValidation extends FormValidation {
  /**
   * this method is used to validate items on the form on the Budget Transfer JSp.
   *
   * @return isValid
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");

    boolean isValid = true;

    HttpServletRequest request = this.getRequest();

    String rbBudgetTransferFrom = ContextHelper.getStringSafe(request, "rbBudgetTransferFrom");
    String rbBudgetTransferTo = ContextHelper.getStringSafe(request, "rbBudgetTransferTo");

    if ("".equals(rbBudgetTransferFrom)) {
      super.setErrorMessage(Messages.MSG_CON_TRAN_NO_FROM);
      isValid = false;
    }

    if ("".equals(rbBudgetTransferTo)) {
      super.setErrorMessage(Messages.MSG_CON_TRAN_NO_TO);
      isValid = false;
    }

    if ((!"".equals(rbBudgetTransferTo)) && (!"".equals(rbBudgetTransferFrom))
        && rbBudgetTransferTo.equals(rbBudgetTransferFrom)) {
      super.setErrorMessage(Messages.MSG_CON_TRAN_SAME);
      isValid = false;
    }

    GrndsTrace.exitScope(TRACE_TAG + ".validateForm");
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "BudgetTransferCustomValidation";

}
