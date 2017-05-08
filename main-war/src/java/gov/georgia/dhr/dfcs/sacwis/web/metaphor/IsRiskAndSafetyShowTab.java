package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.IdTriple;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.Nav;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/*
Filter class used for RISK_AND_SAFETY_ASSESSMENT_RISKASSMT tab
*/

public class IsRiskAndSafetyShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    String strProgram = GlobalData.getSzCdStageProgram(request);
    String strStage = GlobalData.getSzCdStage(request);

    IdTriple iTrip = new IdTriple(strProgram, strStage, tabId);
    String taskCode = Nav.getTaskCodeForTriple(iTrip);

    if ("2210".equals(taskCode)
        || "2290".equals(taskCode)
        || "2300".equals(taskCode)) {
      showMe = true;
    }

    return showMe;
  }
}


