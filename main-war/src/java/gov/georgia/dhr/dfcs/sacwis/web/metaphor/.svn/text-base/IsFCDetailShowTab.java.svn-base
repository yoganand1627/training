package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceTabState;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;

/** Filter class for FC_REVIEW_APPLICATION_FOSTERCAREDETAIL tab */
public class IsFCDetailShowTab implements ShowTab {
  public boolean showTab(String tabId,
                         HttpServletRequest request) {
    String taskCode = GlobalData.getSzCdTask(request);
    FceTabState fceTabState = FceUtility.getFceTabState(request);

    return (("".equalsIgnoreCase(taskCode)) &&
            (fceTabState.showReviewTabSet()));
  }
}

