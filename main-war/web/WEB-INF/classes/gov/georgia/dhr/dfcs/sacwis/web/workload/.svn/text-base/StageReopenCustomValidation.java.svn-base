package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to perform the custom validation on Stage Reopen when the user chooses to Save, Save and Submit,
 * or Save and Close.
 *
 * @author Bhavna Gehlot 7/17/2009
 */
public class StageReopenCustomValidation extends FormValidation {
  /**
   * <p>This method contains custom validation that is checked when the user tries to save the Stage Closure page.</p>
   *
   * @return result
   */
  protected boolean validateForm() {


    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = super.getRequest();
    
    BaseSessionStateManager state = getState();

    boolean result = true;
    
    // Get the whole output object here from the request and get the individual pieces later.
    StageReopenRetrieveSO stageReopenRetrieveSO = (StageReopenRetrieveSO) state.getAttribute("stageReopenRetrieveSO", request); 
    
    String[] checkedCheckboxes = CheckboxHelper.getCheckedValues(request, "chkReopenReasons");
    
    if (isButtonPressed("btnSave")) {
      // If no reopen reason selected display the message saying that it's required
      if ((checkedCheckboxes.length == 0)) {
        setErrorMessage(Messages.MSG_REOPEN_REASONS_REQ);
        result = false;
      }

      // The requested by person is required
      if ((stageReopenRetrieveSO.getIdRequestedBy() == 0)) {
        setErrorMessage(Messages.MSG_REQUESTED_BY_REQ);
        result = false;
      }   
    }
    

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return result;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "StageReopenCustomValidation";
}


