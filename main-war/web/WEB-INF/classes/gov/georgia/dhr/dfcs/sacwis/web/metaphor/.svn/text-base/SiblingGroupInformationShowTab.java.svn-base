package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/*
 Filter Class used for Person Detail SIBLING_GROUP_INFOMATION tab
 */
@SuppressWarnings("serial")
public class SiblingGroupInformationShowTab implements ShowTab {

  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    int idStage = GlobalData.getUlIdStage(request);
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    if (idStage > 0
        && ArchitectureConstants.Y.equals(state.getContextParameter("_siblingGroupInformationAvailable" + idStage,
                                                                    request))) {
      showMe = true;
    }
    return showMe;
  }

}
