package org.apache.jsp.grnds_002ddocs.document.cfp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;

public final class OpenQueueStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//Matthew McClain 5/2/2003
//I could have made this a .js, but I didn't want to mess with the problem
//of the .js not loading before the button was clicked or the method was called.

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n<!--\r\nfunction openQueueStatus()\r\n{\r\n  //http://www.devguru.com/technologies/ecmascript/quickref/win_open.html\r\n  var width = 760;\r\n  var height = 350;\r\n  var left = screen.availWidth - width - 10;\r\n  var top = 0;\r\n  var queueStatus = window.open(\"");
      out.print( CfpConversation.QUEUE_STATUS );
      out.write("\",\r\n                                \"queueStatus\",\r\n                                \"menubar=no,\" +\r\n                                \"location=no,\" +\r\n                                \"resizable=yes,\" +\r\n                                \"scrollbars=yes,\" +\r\n                                \"width=\" + width + \",\" +\r\n                                \"height=\" + height + \",\" +\r\n                                \"left=\" + left + \",\" +\r\n                                \"top=\" + top);\r\n  queueStatus.focus();\r\n  return false;\r\n}\r\n//-->\r\n</script>\r\n");
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
