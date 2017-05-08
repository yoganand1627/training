/**
 * @author Vishala Devarakonda, April 6, 2007 
 */
package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class CaseBudgetLimitListConversation extends BaseHiddenFieldStateConversation {
  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  private Financials financials;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  /**
   * <p/> This method is called by the GRNDS controller when the Case Budget Limit third level tab is hit.
   * 
   * <pre>
   *         Change History:
   *          Date      User      Description
   *          --------  --------  --------------------------------------------------
   *         @param context The GrndsExchangeContext object.
   * 
   */
  public void displayCaseBudgetLimit_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayCaseBudgetLimit_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      CaseBudgetLimitRetrieveSO caseBudgetLimitRetrieveSO = new CaseBudgetLimitRetrieveSO();

      CaseBudgetLimitRetrieveSI csBdgtLmtretSI = populateCsBdgtLmtRetSI_Retrieve(context);
      caseBudgetLimitRetrieveSO = financials.retrieveCaseBudgetLimitList(csBdgtLmtretSI);
      state.setAttribute("caseBudgetLimitRetrieveSO", caseBudgetLimitRetrieveSO, request);

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

  private CaseBudgetLimitRetrieveSI populateCsBdgtLmtRetSI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFCGSRetSI_Retrieve");
    performanceTrace.enterScope();

    // Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();

    // Allocate the structures
    CaseBudgetLimitRetrieveSI csBdgtLmtretSI = new CaseBudgetLimitRetrieveSI();

    if (GlobalData.getUlIdCase(request) != 0) {
      csBdgtLmtretSI.setUlIdCase(GlobalData.getUlIdCase(request));
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return csBdgtLmtretSI;
  }

  /**
   * ************************************************************************** This method is called by the other
   * methods when an exception is caught.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param e
   *          The Exception
   * @param methodName
   *          A String containing the method which threw the exception
   *          **************************************************************************
   */
  protected void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
        this.setPresentationBranch("error", context);

        setErrorMessage(Messages.MSG_CMN_NO_PRIMARY_ROW, "/casemgmt/FCGSDetail/displayFCGSDetail", context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
}
