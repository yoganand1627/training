package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.financials.RestrictedFundsConversation;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class RestrictedFundsShowTab implements ShowTab {

  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;

    BaseSessionStateManager state = RestrictedFundsConversation.getSessionStateManager(request);
    int idPerson = GlobalData.getUlIdPerson(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    String cdTask = GlobalData.getSzCdTask(request);
    String stageType = GlobalData.getSzCdStage(request);
    UserProfile profile = UserProfileHelper.getUserProfile(request);
    if (((idPerson > 0 && ArchitectureConstants.Y.equals(state.getContextParameter("_restrictedFunds" + idPerson,
                                                                                   request))) || (idEvent > 0 && RestrictedFundsConversation.TASKS
                                                                                                                                                  .contains(cdTask)))
        && GlobalData.hasStageAccess(request) && RestrictedFundsConversation.APPROVAL_TASK_MAP.containsKey(stageType)) {
      showMe = true;
    } else if (idPerson > 0
               && (profile.hasRight(UserProfile.SEC_REGIONAL_ACCNTNG_STF) || profile.hasRight(UserProfile.SEC_REGIONAL_ACCNTNG_MGMNT_STF))) {

      showMe = true;
    }

    return showMe;
  }

}
