package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

public class FosterCareParticipantCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "FosterCareParticipantCustomValidation";

  /**
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException
   * 
   */
  protected boolean validateForm() throws RuntimeWrappedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;

    try {

    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }

    performanceTrace.exitScope();
    return isValid;
  }
}