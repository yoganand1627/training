package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;

public final class CaseWatchFactorHelpTxt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

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


//*  JSP Name:     Case Watch Factor Help Text
//*  Created by:   Patrick Coogan
//*  Date Created: 11/12/09
//*
//*  Description:
//*  This JSP will be used to display case watch factor help text.
//*
//** Change History:
//**  Date      User                Description
//**  --------  ----------------    --------------------------------------------------
//**  11/13/09  Patrick Coogan      Creation to support display of Case Watch factor
//**                                help.

      out.write("\r\n\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n  <title>Case Watch Factor Help</title>\r\n</head>\r\n\r\n<body bgcolor=\"#FFFFFF\" text=\"#000000\">\r\n\r\n");

  String HelpTxt = request.getParameter("HelpTxtName");
  HelpTxt = URLHelper.decode(HelpTxt);
  out.write(HelpTxt);

      out.write("\r\n\r\n</body>\r\n\r\n</html>\r\n\r\n\r\n");
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
