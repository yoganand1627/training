package gov.georgia.dhr.dfcs.sacwis.web.core.web;

// -- architecture classes --

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HttpSessionStateManager;

/**
 *
 */
public class BaseHttpSessionStateConversation extends BasePrsConversation {
  public BaseSessionStateManager getSessionStateManager(GrndsExchangeContext context) {
    // Get the existing session state manager from the HttpSession
    BaseSessionStateManager stateManager =
            (BaseSessionStateManager) context.getSession().getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);

    // if no session manager currently exists, then create one and put it on the session
    if (stateManager == null) {
      stateManager = new HttpSessionStateManager();
      context.getSession().setAttribute(BaseSessionStateManager.STATE_MANAGER_KEY,
                                        stateManager);
    }
    return stateManager;
  }

}










