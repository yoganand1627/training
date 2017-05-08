package gov.georgia.dhr.dfcs.sacwis.web.fad;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

public class PolicyViolationCustomValidation extends FormValidation {
  // static constants
  public final static String TRACE_TAG = "PolicyViolationCustomValidation";

  public static final String SAVE_BUTTON = "btnSave";

  public static final String SAVE_SUBMIT_BUTTON = "btnSaveSubmit";

  /** Validate Corrective Action Plan screen */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("PolicyViolationCustomValidation", "validationForm");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    boolean isValid = true;

    // *******************************
    // *** SAVE OR SAVE AND SUBMIT ***
    // *******************************
    if (super.isButtonPressed(SAVE_BUTTON) || super.isButtonPressed(SAVE_SUBMIT_BUTTON)) {
      // At least one principal must be selected.
      String[] checkedPolViolation = CheckboxHelper.getCheckedValues(request, "cbxPolViolation_");
      if (checkedPolViolation.length <= 0) {
        isValid = false;
        setErrorMessage(Messages.MSG_CAP_NO_VIOLATION);
      }
    }
    return isValid;
  }
}
