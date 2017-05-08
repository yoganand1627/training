package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Performs custom validation for Services and Referrals Checklist. When the user 'saves'.
 *
 * @author Merle A. Demo
 */
public class CaseMntCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "CaseMntCustomValidation";

  /**
   * Validate for CaseMnt.
   *
   * @return Returns true if there are no validation errors
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean result = true;

    //Error: Trying to save null's
    if ("".equals(ContextHelper.getStringSafe(request, "selCdStageCnty"))
        && "".equals(ContextHelper.getStringSafe(request, "selNmPersonHistFull"))) {
      setErrorMessage("selNmPersonHistFull", Messages.MSG_CHNG_STG_CNTY_OR_NM_REQ);
      result = false;
    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! " + result);
    performanceTrace.exitScope();

    return result;
  }
}
