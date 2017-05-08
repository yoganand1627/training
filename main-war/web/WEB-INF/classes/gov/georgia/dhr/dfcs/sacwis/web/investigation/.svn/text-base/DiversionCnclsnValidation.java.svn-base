package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

public class DiversionCnclsnValidation extends FormValidation {
  //static constants
  public static final String TRACE_TAG = "DiversionCnclsnValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace("DiversionCnclsnValidation", "validateForm");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");
    boolean isValid = true;

    //|| this.isButtonPressed("btnApprovalStatus")
    if (super.isButtonPressed("btnSaveAndSubmit")) {
      boolean isValid2 = saveSubmitValidation();
      isValid = isValid && isValid2;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

  /**
   * This method contains custom validation that is checked when the user tries to Save and Submit the CPS Investigation
   * Conclusion page.
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  private boolean saveSubmitValidation() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSubmitValidation()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;
    Date dtDiversionTasks = ContextHelper.getJavaDateSafe(request, "dtDiversionTasks");
    String selSzCdDisposition = ContextHelper.getStringSafe(request, "selSzCdDisposition");

    //if(null == dtDiversionTasks.toString() || "".equals(dtDiversionTasks.toString())){
    if (dtDiversionTasks == null) {
      setErrorMessage(Messages.MSG_DIV_TASKS_COMP_DATE_REQ);
      isValid = false;
    }
    if (selSzCdDisposition == null || "".equals(selSzCdDisposition)) {
      setErrorMessage(Messages.MSG_DIV_DSPSTN_REQ);
      isValid = false;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

}
