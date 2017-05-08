package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/*
Filter class called by INTAKE_PRIORITY_CLOSURE_INTAKEPRIORITYCLOSURE
SIR 18954 - Added logic to filter such that the Intake Priority Closure
tab hides if an Intake has not been saved and submitted or saved and assigned.
*/

public class IsSysIndSupervisor implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    UserProfile user = UserProfileHelper.getUserProfile(request);

    boolean showMe = false;
    if (user.getSysSupervisorAccess()) {
      if (CodesTables.CSTAGES_INT.equals(GlobalData.getSzCdStage(request))
          && (CodesTables.CPGRMSFM_CCL.equals(GlobalData.getSzCdStageProgram(request))
              || CodesTables.CPGRMSFM_RCL.equals(GlobalData.getSzCdStageProgram(request))
              || CodesTables.CPGRMSFM_CPS.equals(GlobalData.getSzCdStageProgram(request)))
          && GlobalData.getUlIdCase(request) == 0) {
        showMe = false;
      } else {
        showMe = true;
      }
    }
    return showMe;
  }
}

