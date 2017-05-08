package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/*
Filter class for INTAKE_ACTIONS_INTAKEACTIONS tab
*/

public class HasStageIdShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    return (GlobalData.getUlIdStage(request) != 0);
  }
}


