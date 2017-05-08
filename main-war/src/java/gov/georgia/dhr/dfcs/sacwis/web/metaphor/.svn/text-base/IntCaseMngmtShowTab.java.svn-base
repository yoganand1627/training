package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

public class IntCaseMngmtShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    return (GlobalData.getUlIdCase(request) != 0);
  }
}


