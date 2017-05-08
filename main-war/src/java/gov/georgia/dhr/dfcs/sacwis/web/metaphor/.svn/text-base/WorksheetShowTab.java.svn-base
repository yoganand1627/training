package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceTabState;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;

/** Filter class used by ELIGIBILITY_DETERMINATION_ELGBLTYDTRMNTNWORKSHEET tab */
public class WorksheetShowTab
        implements ShowTab {
  public boolean showTab(String tabId,
                         HttpServletRequest request) {
    UserProfile user = UserProfileHelper.getUserProfile(request);

    int idEvent = GlobalData.getUlIdEvent(request);
    String taskCode = GlobalData.getSzCdTask(request);
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);

    //tab is not available without an Fce Application Event Id
    if ((idEvent == 0) ||
        ("".equals(taskCode) == false)) {
      return false;
    }

    FceTabState fceTabState = FceUtility.getFceTabState(request);
    if (fceTabState.showApplicationTabSet() == false) {
      return false;
    }

    //caseworkers can view worksheets of approved events
    String eventStatus = FceUtility.getCdEventStatus(request);
    if (EventHelper.APPROVED_EVENT.equals(eventStatus)) {
      return true;
    }

    //only billing or eligibility specialists can view/edit complete events
    return
            ((EventHelper.COMPLETE_EVENT.equals(eventStatus)) &&
             ((user.hasRight(UserProfile.SEC_BILLING)) ||
              (user.hasRight(UserProfile.SEC_ELIGIBILITY))));
  }
}
