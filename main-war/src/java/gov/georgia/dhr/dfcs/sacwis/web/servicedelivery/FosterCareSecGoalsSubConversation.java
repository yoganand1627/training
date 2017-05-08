package gov.georgia.dhr.dfcs.sacwis.web.servicedelivery;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import javax.servlet.http.HttpServletRequest;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * FosterCareSecGoalsSubConversation
 * 
 * @author Nandita Hegde , Feb 21,2006
 * @version 1.0
 * 
 * <pre>
 *                   Change History:
 *                   Date      User              Description
 *                   --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class FosterCareSecGoalsSubConversation extends FosterCareSecGoalsConversation {
  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  private CaseMgmt caseMgmt;

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  /**
   * display method for the Foster Care Secondary Goals submodule
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void displayFCSecGoals_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayFCSecGoals_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      // Get the page mode that was passed to the submodule from the
      // including JSP, and put it into state so the submodule...and
      // possibly the FCGS Detail page...can use it. If no page mode
      // was passed in, use the PageMode from state.

      String pageMode = PageMode.getPageMode(request);
      if (request.getAttribute(PAGE_MODE_KEY) != null) {
        pageMode = (String) request.getAttribute(PAGE_MODE_KEY);
      }
      state.setAttribute(PAGE_MODE_KEY, pageMode, request);

      String includingDisplayCommand = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY,
                                                                   request);
      state.setAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, includingDisplayCommand, request);

      FosterCareSecGoalsRetrieveSI fcRetrieveSI = populateFCSecGoals_Retrieve(context);
      FosterCareSecGoalsRetrieveSO retrieveSO = caseMgmt.retrieveFosterCareSecGoals(fcRetrieveSI);

      state.setAttribute("FosterCareSecGoalsRetrieveSO", retrieveSO, request);

    } catch (ServiceException e) {
      handleError(e, context);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will populate FosterCareSecGoalsRetrieveSI.
   * 
   * @param context
   */

  private FosterCareSecGoalsRetrieveSI populateFCSecGoals_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFCSecGoals_Retrieve");
    performanceTrace.enterScope();

    FosterCareSecGoalsRetrieveSI retrieveSI = new FosterCareSecGoalsRetrieveSI();
    // Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();

    if (GlobalData.getUlIdEvent(request) != 0) {
      retrieveSI.setEventId(GlobalData.getUlIdEvent(request));
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return retrieveSI;
  }
}
