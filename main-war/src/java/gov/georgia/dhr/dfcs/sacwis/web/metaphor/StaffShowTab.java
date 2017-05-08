package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/*
Not used - DELETE
*/

public class StaffShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    return (GlobalData.getUlIdPerson(request) != 0);
  }
}


