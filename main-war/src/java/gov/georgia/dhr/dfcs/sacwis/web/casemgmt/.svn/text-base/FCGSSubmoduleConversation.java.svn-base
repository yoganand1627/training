/**
 * @author Vishala Devarakonda, December 4, 2006 
 */
package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import javax.servlet.http.HttpServletRequest;
import org.grnds.structural.web.GrndsExchangeContext;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class FCGSSubmoduleConversation extends FCGSDetailConversation {
  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  private CaseMgmt caseMgmt;

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  /**
   * <p/> This method is called by the GRNDS controller when the parent page calls the FCGS submodule
   * 
   * <pre>
   *       Change History:
   *        Date      User      Description
   *        --------  --------  --------------------------------------------------
   *       @param context The GrndsExchangeContext object.
   * 
   */
  public void displayGoals_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayFCGS_xa()");
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

      FCGSRetrieveSI fcgsretsi = populateFCGSRetSI_Retrieve(context);
      FCGSRetrieveSO fcgsretso = caseMgmt.retrieveFCGS(fcgsretsi);
      state.setAttribute("FCGSRetrieveSO", fcgsretso, request);

    } catch (Exception e) {
      handleException(e, context, "displayOutputLaunch_xa");
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method is called by the displayGoals_xa to populate the input object for the FCGS retrieve service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */

  private FCGSRetrieveSI populateFCGSRetSI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFCGSRetSI_Retrieve");
    performanceTrace.enterScope();

    // Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();

    // Allocate the structures
    FCGSRetrieveSI fcgsretsi = new FCGSRetrieveSI();
    int actionEvent = ContextHelper.getIntSafe(request, "actionEventId");
    if (GlobalData.getUlIdEvent(request) != 0) {
      fcgsretsi.setUlIdEvent(GlobalData.getUlIdEvent(request));
    }
    // STGAP00004206 If this is caused by pushing the copy button GlobalData will be 0
    // The Goals will be retrieved by using the actionEvent
    else if(actionEvent != 0){
    	fcgsretsi.setUlIdEvent(actionEvent);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return fcgsretsi;
  }
}
