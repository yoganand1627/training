package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/*
 *Filter Class for CASE_TO_DO_LIST_TODCMNTTN tab
 *Can navigate to any To-Do as long as user is assigned to a stage in the case
 *and the user does not have SEC_RESTRICT_CASE_EVENT security attribute.
 *
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 05/09/05  NALLAVS      SIR 23547 - Removed System.out.println statements.

*/

public class CaseTodoShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    UserProfile user = UserProfileHelper.getUserProfile(request);

    if (GlobalData.getUlIdCase(request) != 0
        && !user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
      showMe = true;
    }

    if (user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
      if (GlobalData.hasStageAccess(request)) {
        showMe = true;
      } else {
        showMe = false;
      }
    }

    return showMe;
  }
}
