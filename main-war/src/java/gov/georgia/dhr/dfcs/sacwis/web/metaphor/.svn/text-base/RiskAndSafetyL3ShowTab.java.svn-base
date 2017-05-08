package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;

/*
Filter class used by RISK_AND_SAFETY_3_RISKASSMT tab
*/

public class RiskAndSafetyL3ShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    if ("investigation/RiskAndSafetyAssmt".equalsIgnoreCase(String.valueOf(request.getAttribute(
            ArchitectureConstants.CONVERSATION)))
        && "displayRiskAndSafetyAssmt".equalsIgnoreCase(String.valueOf(request.getAttribute(
            ArchitectureConstants.COMMAND)))) {
      return true;
    } else {
      return false;
    }
  }
}


