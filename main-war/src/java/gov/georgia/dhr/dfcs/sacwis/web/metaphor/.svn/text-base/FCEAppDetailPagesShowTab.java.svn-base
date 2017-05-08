package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceTabState;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;

/**
 * Filter class used by: INCOME_AND_EXPENDITURES_INCOMEEXPENDITURES, DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION,
 * AGE_AND_CITIZENSHIP_AGECITIZENSHIP, APPLICATION_AND_BACKGROUND_APPBACKGROUND tabs
 * <p/>
 * Show these tabs under FC_ASSISTANCE_EVENTLIST 2nd level tab if there is no task code. Also need to ensure they do not
 * show when we are under the FC_REVIEW_APPLICATION_FOSTERCAREDETAIL 3rd level tab.
 */
public class FCEAppDetailPagesShowTab
        implements ShowTab {
  public boolean showTab(String tabId,
                         HttpServletRequest request) {
    String taskCode = GlobalData.getSzCdTask(request);
    FceTabState fceTabState = FceUtility.getFceTabState(request);

    return (("".equals(taskCode)) &&
            (fceTabState.showApplicationTabSet()));
  }
}

