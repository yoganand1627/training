package org.apache.jsp.grnds_002ddocs.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;

public final class TestMessage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n");

String messageName = request.getParameter("message");

if (messageName == null || "".equals(messageName))
{

      out.write("\r\n  <form name=\"frmMessageTest\" method=\"post\">\r\n    <p>Message:<input name=\"message\" value=\"\"/></p>\r\n    <p><input type=\"submit\" value=\"SUBMIT\" name=\"btnSubmit\"/></p>\r\n  </form>\r\n");

}
else
{
  try
  {
    Integer messageCode = (Integer)(Messages.class.getField(messageName).get(null));

      out.write("\r\n<h2>");
      out.print(messageName);
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print(MessageLookup.getMessageByNumber(messageCode));
      out.write("</h2>\r\n");

  }
  catch (Throwable t)
  {

      out.write("\r\n<h2>error looking up: ");
      out.print(messageName);
      out.write("</h2>\r\n  ");
      out.print(t);
      out.write("\r\n  <pre>\r\n");

     t.printStackTrace(response.getWriter());

      out.write("\r\n  </pre>\r\n");

  }
}

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
