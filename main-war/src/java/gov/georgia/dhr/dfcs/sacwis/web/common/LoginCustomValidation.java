package gov.georgia.dhr.dfcs.sacwis.web.common;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
/**
 * This class is used to perform the custom validation on Login 
 * when the user attempts to login to Portal
 * 
 * @author ssubram 10/12/2009 
 * Change History:   
 * Date       User    Description 
 * ----       ----    ---------------------------------------------- 
 * 10/12/09   ssubram Initial Validation for Portal
 */
public class LoginCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "LoginCustomValidation";

  /**
   * <p>
   * This method contains custom validation that is checked when the user tries to Assign or Stage Progress a stage from
   * Assigned Workload.
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "LoginCustomValidation.validationForm()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();
    return true;
  }
}
