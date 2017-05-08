package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.TabConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

import javax.servlet.http.HttpServletRequest;

/**
 * Filter Class used for:<ul> <li>PERSON_DETAIL_PERSONDETAIL</li> <li>CVS_FA_HOME_PERSONDETAIL</li>
 * <li>CVS_FA_HOME_PERSONDETAIL 3rd Level Tabs</li></ul>
 */
@SuppressWarnings("serial")
public class PersonDtlShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    int tabIdAsInt = StringHelper.toInteger(tabId);
    int idPerson = GlobalData.getUlIdPerson(request);
    boolean showMe;
    switch (tabIdAsInt) {
      case TabConstants.YOUTH_DETAIL:
        showMe = false;
        BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
        if (idPerson > 0 &&
            ArchitectureConstants.Y.equals(state.getContextParameter("_youthDetailAvailable" + idPerson, request))) {
          showMe = true;
        }
        break;
      default:
        showMe = false;
        if (GlobalData.getUlIdPerson(request) != 0) {
          showMe = true;
        }
    }
    return showMe;
  }
}

