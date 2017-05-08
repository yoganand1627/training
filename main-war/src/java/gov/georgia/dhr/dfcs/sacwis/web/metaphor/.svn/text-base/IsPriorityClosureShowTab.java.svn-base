package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/**
 * Filter class called by INTAKE_PRIORITY_CLOSURE_INTAKEPRIORITYCLOSURE
 * <p/>
 * The 2nd level Intake Priority Closure tab should only be visible in the following instances:
 * <p/>
 * 1.  If the user is a supervisor and the stage is a CPS, RCL, or CCL Intake that has a Case ID. 2.  For all I&R and
 * SPC stages.
 * <p/>
 * Change History: Date      User         Description --------  -----------  ----------------------------------------------
 * 07/15/03  BRAUCHS       SIR 18954 - Added logic to filter such that the Intake Priority Closure tab hides if an
 * Intake has not been saved and submitted or saved and assigned. 07/17/03 CASDORJM       SIR 18992 - Rewrote the filter
 * class to show this tab only when CAPS allows the user access to the Intake Priority/Closure page.  See above for
 * explanation.
 */
public class IsPriorityClosureShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;

    UserProfile user = UserProfileHelper.getUserProfile(request);

    if (user.getSysSupervisorAccess() &&
        CodesTables.CSTAGES_INT.equals(GlobalData.getSzCdStage(request))
        && GlobalData.getUlIdCase(request) != 0) {
      showMe = true;
      // Need to figure out if I can add a check for user being case manager assigned to Intake
    } else if (CodesTables.CSTAGES_INT.equals(GlobalData.getSzCdStage(request))
                    && GlobalData.getUlIdCase(request) != 0) {
      showMe = true;
    }

    return showMe;
  }
}


