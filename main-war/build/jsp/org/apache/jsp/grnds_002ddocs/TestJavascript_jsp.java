package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;

public final class TestJavascript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n<html>\r\n<head>\r\n<title>Test Javascript</title>\r\n</head>\r\n\r\n<body>\r\n<h1>Test Browser's Javascript support</h1>\r\n\r\n<script language=\"javascript\">\r\nfunction testWindowOpen()\r\n{\r\n  window.open(\"http://www.google.com/\");\r\n}\r\n\r\n\r\nfunction testAlert()\r\n{\r\n  alert(\"you just tested alert\");\r\n}\r\n\r\n\r\nfunction testConfirm()\r\n{\r\n  confirm(\"testing confirm; click Ok or Cancel\");\r\n}\r\n\r\n\r\nfunction testOnUnload()\r\n{\r\n  window.onbeforeunload = testWindowOpen;\r\n  location.href = \"TestJavascript.jsp\";\r\n}\r\n</script>\r\n\r\n<pre>\r\n");

Enumeration enumeration = request.getHeaderNames();
while (enumeration.hasMoreElements())
{
  String name = (String) enumeration.nextElement();
  out.println(name + ": " + request.getHeader(name));
}

      out.write("\r\n\r\n<a href=\"javascript:testWindowOpen();\">Click to Test pop-up window</a>\r\n\r\n<a href=\"javascript:testAlert();\">Click to Test alert</a>\r\n\r\n<a href=\"javascript:testConfirm();\">Click to Test confirm</a>\r\n\r\n<a href=\"javascript:testOnUnload();\">Click to Test onBeforeUnload</a>\r\n</pre>\r\n\r\n\r\n<hr>\r\n<address></address>\r\n<!-- hhmts start -->\r\n<!-- hhmts end -->\r\n</body> </html>\r\n");
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
