package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/*
Filter class for:
    EVENT_SEARCH_EVENTSEARCHCONVERSATION,
    EVENT_LIST_EVENTLIST,
    EVENT_SEARCH_EVENTSEARCHCONVERSATION tabs.
*/

public class RestrictEventShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = true;
    String conversationString = (String) request.getAttribute(ArchitectureConstants.CONVERSATION);
    if ("workload/CaseSummary".equalsIgnoreCase(conversationString) ||
        "workload/ToDo".equalsIgnoreCase(conversationString)) {
      UserProfile user = UserProfileHelper.getUserProfile(request);
      if (user.hasRight(user.SEC_RESTRICT_CASE_EVENT) && !GlobalData.hasStageAccess(request)) {
        showMe = false;
      }
    }
    return showMe;
  }
}


