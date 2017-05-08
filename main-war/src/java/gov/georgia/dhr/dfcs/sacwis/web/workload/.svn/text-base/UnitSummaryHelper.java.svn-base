package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/**
 * Helper class for Unit Summary page
 *
 * @author Michael Ochu
 */
public abstract class UnitSummaryHelper {
  /**
   * Sets the unit summary search parameters into the context area of state so they won't get cleared
   *
   * @param request current request
   * @param search  criteria set into context
   */
  public static void setUnitSummarySearchBean(HttpServletRequest request,
                                              UnitSummarySearchBean unitSummarySearchBean) {
    BaseSessionStateManager state = GlobalData.getState(request);
    state.setContextParameter(UNIT_SUMMARY_BEAN,
                              unitSummarySearchBean,
                              request);
  }

  /**
   * Returns the search criteria entered as set in the context area of state.
   *
   * @param request current request
   * @return search criteria
   */
  public static UnitSummarySearchBean getUnitSummarySearchBean(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    return (UnitSummarySearchBean)
            state.getContextParameter(UNIT_SUMMARY_BEAN, request);
  }

  public static final String UNIT_SUMMARY_BEAN =
          UnitSummaryConversation.UNIT_SUMMARY_BEAN;
}