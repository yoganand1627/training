package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/*
Filter class used by:
   APPLICATION_EVENTLIST,
   FC_REVIEW_APPLICATION_FOSTERCAREREVIEW,
   ELIGIBILITY_SUMMARY_EVENTLIST tabs
*/

public class IsEventListFCShowTab
        implements ShowTab {
  public boolean showTab(String tabId,
                         HttpServletRequest request) {
    int idEvent = GlobalData.getUlIdEvent(request);
    String taskCode = GlobalData.getSzCdTask(request);

    return (idEvent == 0) || !("".equals(taskCode));
  }
}

