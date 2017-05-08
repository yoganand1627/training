package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/*
 Filter Class used for Person Detail EXCHANGE_CHILD_EVENTLIST tab
 */
@SuppressWarnings("serial")
public class ExchangeChildDetailShowTab implements ShowTab {

  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    String stage = GlobalData.getSzCdStage(request);
    int idPerson = GlobalData.getUlIdPerson(request);

    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    if (idPerson > 0
        && ArchitectureConstants.Y.equals(state
                                               .getContextParameter("_exchangeChildDetailAvailable" + idPerson, request))
        && "ADO".equals(stage)) {
      showMe = true;
    }
    return showMe;
  }
}
