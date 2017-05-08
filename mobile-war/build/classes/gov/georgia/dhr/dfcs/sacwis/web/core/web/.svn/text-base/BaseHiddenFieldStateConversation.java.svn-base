package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;

/**
 * This conversation extends the GrndsBasicHttpConversation, overriding the initialization and finalization behavior to
 * work with a hidden field strategy for session state management.  Conversations that will use hidden fields to
 * maintain their session state should inherit from this class.
 */
public class BaseHiddenFieldStateConversation extends BasePrsConversation {
  /** Clears BaseSessionStateManager state */
  public void clearState(GrndsExchangeContext context) {
    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(context.getRequest());
  }

  /**
   * Retrieves the current session state manager instance.  The session state manager is the class which handles adding,
   * removing, and getting of attributes that must be maintained throughout a conversation.
   */
  public static BaseSessionStateManager getSessionStateManager(GrndsExchangeContext context) {
    return getSessionStateManager(context.getRequest());
  }

  /**
   * Retrieves the current session state manager instance.  The session state manager is the class which handles adding,
   * removing, and getting of attributes that must be maintained throughout a conversation.
   */
  public static BaseSessionStateManager getSessionStateManager(HttpServletRequest request) {
    BaseSessionStateManager stateManager
            = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    if (stateManager == null) {
      // Request is passed in in order to construct the HiddenFieldSessionStateManager from the
      //   hidden field in the request.
      stateManager = new HiddenFieldSessionStateManager(request);
    }
    return stateManager;
  }

  /**
   * Overrides the parent class's doBeginResponse method to initialize the instance's stateManager instance variable.
   * <p/>
   * It also sets the current and calling page URI data into GlobalData
   *
   * @param context the current GrndsExchangeContext
   */
  protected void doBeginResponse(GrndsExchangeContext context) {
    BaseSessionStateManager manager = getSessionStateManager(context);
    manager.doPreExchange(context);
  }

  /**
   * Many activity methods are placeholders. They don't do anything. This is method they can simply include to perform
   * nominal trace and clearing of state.
   */
  protected void doNothing(GrndsExchangeContext context, String traceTag, String activityMethodName) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(traceTag, activityMethodName);
    try {
      clearState(context);
    }
    catch (Throwable e) {
      e.printStackTrace();
      processSevereException(context, e);
    }
    finally {
      performanceTrace.exitScope();
    }
  }

//      /**
//       * Overrides the parent class's doEndResponse method to finalize the instance's
//       * state manager instance variable
//       *
//       * @param context the current GrndsExchangeContext
//       */
//      // doesn't work - gets called at the wrong time
//      protected void doEndResponse(GrndsExchangeContext context)
//      {
//          BaseSessionStateManager manager = this.getSessionStateManager(context);
//          try
//          {
//              manager.doComplete(context);
//          }
//          catch(Exception e)
//          {
//              ExceptionHandler.handle(e);
//          }
//      }
}
