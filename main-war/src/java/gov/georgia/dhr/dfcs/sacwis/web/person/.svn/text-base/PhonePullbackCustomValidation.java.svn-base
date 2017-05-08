package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/** @todo add parameters, etc. to javadocs */

/**
 * Validation for PhonePullback.jsp
 *
 * @author Matthew McClain, March 1, 2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed extra not needed lines of code.
 */
public class PhonePullbackCustomValidation
        extends FormValidation {
  protected static final String TRACE_TAG = "PhonePullbackCustomValidation";

  /** @return false iff number was null and count != 0 */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, "validateForm");

    HttpServletRequest request = this.getRequest();

    try {
      String count = ContextHelper.getStringSafe(request, "count");
      String number = ContextHelper.getStringSafe(request, "phoneNumber");

      if ("0".equals(count)) {
        return true;
      }
      if ("".equals(number)) {
        setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
        return false;
      }
      return true;
    }
    finally {
      performanceTrace.exitScope();
    }
  }
}
