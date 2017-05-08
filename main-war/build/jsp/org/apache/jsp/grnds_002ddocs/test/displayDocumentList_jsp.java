package org.apache.jsp.grnds_002ddocs.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

public final class displayDocumentList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );

      out.write("\r\n<html>\r\n<head>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <title>Display Document List</title>\r\n  <link href=\"/grnds-docs/css/impact.css\" rel=\"stylesheet\">\r\n</head>\r\n<body>\r\n  <table width=\"500\" cellpadding=\"1\">\r\n    <tr>\r\n      <td class=\"formErrorText\">\r\n        <hr noshade size=\"1\">\r\n");

  if (request.getAttribute( BasePrsConversation.ERROR_MESSAGES )!= null)
  {
    Map nonValidationErrorMessages = (Map)request.getAttribute( BasePrsConversation.ERROR_MESSAGES );

    Set keys = nonValidationErrorMessages.keySet();
    Iterator keyIter = keys.iterator();

    while (keyIter.hasNext())
    {
      String nextErrorName = (String) keyIter.next();
      String nextErrorMessage = (String) nonValidationErrorMessages.get(nextErrorName);
      out.println(nextErrorMessage + "<br>");
    }

  }

      out.write("\r\n      <hr noshade size=\"1\">\r\n    </td>\r\n  </tr>\r\n</table>\r\n</body>\r\n</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
