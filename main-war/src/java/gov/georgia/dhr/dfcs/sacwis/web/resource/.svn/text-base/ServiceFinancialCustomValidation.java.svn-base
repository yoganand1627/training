/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hong-van.t.vo
 *
 */
@SuppressWarnings("serial")
public class ServiceFinancialCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "ServiceFinancialCustomValidation";
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    boolean isValid = true;
    
    String[] serviceChecks = CheckboxHelper.getCheckedValues(request, "cbxService");
    
    if (serviceChecks == null || serviceChecks.length == 0) {
      isValid = false;
    }
    
    String[] countyChecks = CheckboxHelper.getCheckedValues(request, "cbxCounty");
    
    if (countyChecks == null || countyChecks.length == 0) {
      isValid = false;
    }
 
    performanceTrace.exitScope();
    return isValid;
  }

}
