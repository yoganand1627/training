package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.naming.Binding;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;

public final class JNDITool_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n\n\n\n<html>\n<head>\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\n  <SCRIPT type=\"text/javascript\" language=\"JavaScript1.2\" src=\"/grnds-docs/js/shared/prsValidation.js\"></script>\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/syncscroll.js\"></script>\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/document/document.js\"></script>\n\n</head>\n\n<body>\n");

  InitialContext context = new InitialContext();
  NamingEnumeration<Binding> namingEnumeration = context.listBindings("java:comp/env/ejb");

      out.write("\n<table>\n  ");

    while (namingEnumeration.hasMoreElements()) {
      Binding binding = namingEnumeration.next();
  
      out.write("\n  <tr>\n    <td>");
      out.print(binding.getClassName());
      out.write("</td>\n    <td>");
      out.print(binding.getName());
      out.write("</td>\n    <td>");
      out.print(binding.getObject());
      out.write("</td>\n  </tr>\n  ");

    }
  
      out.write("\n</table>\n</body>\n</html>\n");
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
