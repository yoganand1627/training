package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

public class FosterCarePartSubConversation extends FosterCareParticipantConversation {
  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";
  
  private CaseMgmt caseMgmt;

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }


  public void displayFCPart_xa(GrndsExchangeContext context) {
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
      
      FosterCareParticipantRetrieveSI fcRetrieveSI = populateFCPart_Retrieve(context);
      FosterCareParticipantRetrieveSO retrieveSO = caseMgmt.retrieveFosterCareParticipant(fcRetrieveSI);
          
      state.setAttribute("RETRIEVESO", retrieveSO, request);
      
    } catch (ServiceException e) {
      handleError(e, context);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

 
  private FosterCareParticipantRetrieveSI populateFCPart_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFCGSRetSI_Retrieve");
    performanceTrace.enterScope();

    FosterCareParticipantRetrieveSI retrieveSI = new FosterCareParticipantRetrieveSI();
    // Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();

    if (GlobalData.getUlIdEvent(request) != 0) {
      retrieveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
      GlobalData.setUlIdEvent(retrieveSI.getUlIdEvent(), request);
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
    return retrieveSI;
  }
}
