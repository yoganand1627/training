package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

public class NonIncidentAFCARSInformationShowTab implements ShowTab {

  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    String stage = GlobalData.getSzCdStage(request);
    int idPerson = GlobalData.getUlIdPerson(request);

    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    if (idPerson > 0
        && ArchitectureConstants.Y.equals(state
                                               .getContextParameter("_nonIncidentAFCARSInformationAvailable" + idPerson, request))) {
      showMe = true;
    }
    return showMe;
  }

}
