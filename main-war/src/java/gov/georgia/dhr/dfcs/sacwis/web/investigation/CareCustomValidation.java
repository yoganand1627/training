package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class CareCustomValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "CareCustomValidation";

  // Todo: Add Messages to Message Table when integrating into IMPACT.
  private static final String MSG_CARE_THREAT_CMT_REQ =
          "If a life or health threatening condition exists, Comments are required.";
  private static final String MSG_CARE_THREAT_ACT_REQ =
          "If a life or health threatening condition exists, Actions are required.";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "validateForm1()");
    HttpServletRequest request = super.getRequest();

    boolean isValid = true;
    String threaten = ContextHelper.getStringSafe(request, "rbThreaten");
    String comments = ContextHelper.getStringSafe(request, "txtSzThreatenExistsComments");
    String actions = ContextHelper.getStringSafe(request, "txtSzThreatenExistsActions");

    if (ArchitectureConstants.Y.equals(threaten) && !StringHelper.isValid(actions)) {
      setErrorMessage("txtSzThreatenExistsActions", MSG_CARE_THREAT_ACT_REQ);
      isValid = false;
    }

    if (ArchitectureConstants.Y.equals(threaten) && !StringHelper.isValid(comments)) {
      setErrorMessage("txtSzThreatenExistsComments", MSG_CARE_THREAT_CMT_REQ);
      isValid = false;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }
}