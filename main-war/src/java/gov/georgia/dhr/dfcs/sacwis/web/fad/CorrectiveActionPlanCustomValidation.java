package gov.georgia.dhr.dfcs.sacwis.web.fad;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;
@SuppressWarnings("serial")
public class CorrectiveActionPlanCustomValidation extends FormValidation {
  // static constants
  public final static String TRACE_TAG = "CorrectiveActionPlanCustomValidation";

  public static final String SAVE_BUTTON = "btnSave";

  public static final String SAVE_SUBMIT_BUTTON = "btnSaveAndSubmit";

  /** Validate Corrective Action Plan screen */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("CorrectiveActionPlanCustomValidation", "validationForm");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    boolean isValid = true;
    // STGAP00009843  
    String effectFromDate = ContextHelper.getStringSafe(request, "txtDtEffectFrom");
    String effectToDate = ContextHelper.getStringSafe(request, "txtDtEffectTo");
    // End STGAP00009843  
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
    // STGAP00009843 - Date Effect From and To required upon Save and Submit  
    if (super.isButtonPressed(SAVE_SUBMIT_BUTTON)) {
      if (!StringHelper.isValid(effectFromDate)) {
        isValid = false;
        setErrorMessage("txtDtEffectFrom", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
      }
      if (!StringHelper.isValid(effectToDate)) {
        isValid = false;
        setErrorMessage("txtDtEffectTo", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
      }
    }
    // End STGAP00009843  
    return isValid;
  }
}
