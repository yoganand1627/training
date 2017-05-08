package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

public class IncludePresentation extends DecoratedPresentation {

  private static final String TRACE_TAG = "IncludePresentation";

  /**
   * Method called by the GrndsHttpServlet during the doExchange() method to produce the appropriate presentation jsp.
   * This method determines which screen is associated with the current servlet, conversation, command, and branch,
   * retrieves the screen data, puts the screen into the request, and includes the appropriate template.
   *
   * @param context the GrndsExchangeContext
   */
  public void executePresentation(GrndsExchangeContext context) throws ServletException {
    GrndsTrace.enterScope(TRACE_TAG + ".executePresentation()");
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    BaseSessionStateManager state =
            (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    String callingPage = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request);
    String displayPage = (String) state.getAttribute(IncludeTag.SUBMODULE_DISPLAY_COMMAND_KEY, request);
    if (request.getRequestURI().equals(displayPage)) {
      state.removeAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request);
      state.removeAttribute(IncludeTag.SUBMODULE_DISPLAY_COMMAND_KEY, request);
      BasePrsConversation.forward(callingPage, request, response);
      return;
    }

    Screen screen = ScreenMapping.getScreenData(context);
    String template = screen.getTemplate();
    GrndsTrace.msg(TRACE_TAG, 5, "Screen:" + screen);
    GrndsTrace.msg(TRACE_TAG, 5, "Template:" + template);
    try {
      request.getRequestDispatcher(template).include(request, response);
    } catch (Exception e) {
      throw new ServletException("Exception occured while forwarding to template: " +
                                 ScreenMapping.getTemplate(context), e);
    }
    GrndsTrace.exitScope();
  }
}
