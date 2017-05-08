package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;

public class DiligentSearchShowTab implements ShowTab {

  public boolean showTab(String tabId, HttpServletRequest request) {
    String stage = GlobalData.getSzCdStage(request);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // only show the diligent search if the intake person detail tab is showing
    if ("INT".equals(stage)) {
      CallPersonDtlShowTab callPersonDtlShowTab = new CallPersonDtlShowTab();
      if (callPersonDtlShowTab.showTab(tabId, request) == false) {
    return false;
  }
      //return user.hasRight(user.SEC_DILIGENT_SEARCH);
      //temporary fix
      return true;
    } else {
      // so, don't have to duplicate logic for PersonDetail ShowTab
      PersonDtlShowTab personDtlShowTab = new PersonDtlShowTab();
      if (personDtlShowTab.showTab(tabId, request) == false) {
        return false;
      }

      // If the person isn't an employee show the tab
      // (if you navigate from PersonList, it's always set to "N")
      String bIndActiveStatus = PersonHelper.getBIndActiveStatus(request);
      if (ArchitectureConstants.Y.equals(bIndActiveStatus) == false) {
        return true;
      }

      // bIndActiveStatus == 'Y'
      // if user has the right to perform records checks on employees, show tab

      //return user.hasRight(user.SEC_DILIGENT_SEARCH);
      //temporary fix
      return true;
    }
  }
}


