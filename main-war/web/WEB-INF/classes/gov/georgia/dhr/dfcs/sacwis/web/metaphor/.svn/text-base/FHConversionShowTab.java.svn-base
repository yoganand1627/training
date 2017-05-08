package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

public class FHConversionShowTab implements ShowTab {

  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    int idResource = GlobalData.getUlIdResource(request);

    if (idResource > 0
        && ArchitectureConstants.Y.equals(state.getContextParameter("_FHConversionAvailable" + idResource,
                                                                    request))) {
      showMe = true;
    }
    return showMe;
  }

}
