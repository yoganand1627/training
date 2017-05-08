/**
 * User: mkw
 * Date: Nov 13, 2002
 * Time: 4:23:38 PM
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class IncludeAuthenticatedPrsHttpServlet extends AuthenticatedPrsHttpServlet {

  public GrndsExchangeContext createExchangeContext(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    GrndsTrace.enterScope(TRACE_TAG + ".createExchangeContext");

    String servletMapping = (String) request.getAttribute(GrndsExchangeContext.SERVLET_MAPPING_REQ_ATTRIB);
    GrndsExchangeContext context = super.createExchangeContext(request, response);
    if (servletMapping != null) {
      request.setAttribute(GrndsExchangeContext.SERVLET_MAPPING_REQ_ATTRIB, servletMapping);
    }

    GrndsTrace.exitScope();
    return context;
  }

  /**
   * Executes the presentation portion of the exchange response.
   *
   * @param conversation The <code>GrndsHttpConversation</code> for the request
   * @param command The name <code>String</code> identifying the command
   * @param context The current <code>GrndsExchangeContext</code>
   */
/*
  protected void executePresentation( GrndsHttpConversation conversation, String command, GrndsExchangeContext context ) throws ServletException, IOException
  {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
    Object o = state.getAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request );
    if( o != null && o instanceof String )
    {
      state.removeAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request );
      String callingPage = (String)o;
      RequestDispatcher rd = request.getRequestDispatcher( callingPage );
      rd.forward( request, context.getResponse() );
    }
    else if ( o == null )
    {
      super.executePresentation( conversation, command, context );
    }
    else
    {
      throw new ServletException( "IncludeAuthenticatedPrsHttpServlet: Attribute '" + IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY + "' must be a String representing the calling page; a '" + o.getClass().getName() + "' was found." );
    }
  }
*/

  // -- Constants --
  private static final String TRACE_TAG = "IncludeAuthenticatedPrsHttpServlet";

}
