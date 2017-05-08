package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public class LOCErrorShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    // Only allow users with the view loc exceptions to view the tab.
    UserProfile user = UserProfileHelper.getUserProfile(request);
    return false;
  }
}
