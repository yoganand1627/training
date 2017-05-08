package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

public class HasAppTaskCDandIDEventShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    String taskCode = GlobalData.getSzCdTask(request);

    if ("".equalsIgnoreCase(taskCode)
        && (!("displayFosterCareReview2".equals(request.getAttribute(ArchitectureConstants.COMMAND))
              || ("FC_REVIEW_APPLICATION_FOSTERCAREDETAIL").equals(request.getParameter("level3Tab"))))) {
      return true;
    }
//    if ( !ArchitectureConstants.COMMAND.equals( "displayEventList" ) )
//    {
//      return true;
//    }
    return false;
  }
}

