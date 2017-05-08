package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import org.grnds.structural.web.GrndsExchangePresentation;

/**
 * This class implements the GrndsExchangePresentation interface so it can be used in conjunction with the Grnds Web
 * Conversation framework to present JSPs built from a common template.
 */
public class DecoratedPresentation implements GrndsExchangePresentation {
  private static final String TRACE_TAG = "DecoratedPresentation";

  /**
   * Method called by the GrndsHttpServlet during the doExchange() method to produce the appropriate presentation jsp.
   * This method determines which screen is associated with the current servlet, conversation, command, and branch,
   * retrieves the screen data, puts the screen into the request, and forwards to the appropriate template.
   *
   * @param context the GrndsExchangeContext
   */
  public void executePresentation(GrndsExchangeContext context) throws ServletException {
    GrndsTrace.enterScope(TRACE_TAG + ".executePresentation()");
    Screen screen = ScreenMapping.getScreenData(context);
    String template = screen.getTemplate();
    GrndsTrace.msg(TRACE_TAG, 5, "Screen:" + screen);
    GrndsTrace.msg(TRACE_TAG, 5, "Template:" + template);
    try {
      HttpServletRequest request = context.getRequest();
      HttpServletResponse response = context.getResponse();
      request.getRequestDispatcher(template).forward(request, response);
    } catch (Exception e) {
      throw new ServletException("Exception occured while forwarding to template: " + template, e);
    }
    GrndsTrace.exitScope();
  }
}
