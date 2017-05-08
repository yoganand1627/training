package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.IdTriple;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.Nav;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/*
Filter class for RISK_ASSESSMENT_RISKASSMT tab
*/

public class IsRiskShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    String strProgram = GlobalData.getSzCdStageProgram(request);
    String strStage = GlobalData.getSzCdStage(request);

    IdTriple iTrip = new IdTriple(strProgram, strStage, tabId);
    String taskCode = Nav.getTaskCodeForTriple(iTrip);

    if ("2295".equals(taskCode)) {
      showMe = true;
    }
    if ("1175".equals(tabId)) {
      showMe = true;
    }

    return showMe;
  }
}

