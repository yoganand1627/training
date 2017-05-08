package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;

/*
Filter class for STAFF_DETAIL_STAFFSEARCH tab
*/

public class StaffDtlShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = true;
    if ("admin/StaffSearch".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.CONVERSATION)))
        &&
        ("displayStaffSearch".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
         || "staffSearch".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND))))) {
      showMe = false;
    }
    return showMe;
  }
}

