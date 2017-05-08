package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public final class DummyEventDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n<html> <head>\r\n<title>Dummy Event Detail</title>\r\n</head>\r\n\r\n<body>\r\n<h1>Dummy Event Detail</h1>\r\n\r\nIf you see this, it's because the EventDetail hasn't been\r\nbuilt for your taskCode yet.<br>\r\n<br>\r\npageMode: ");
      out.print( PageMode.getDebugPageMode(PageMode.getPageMode(request)) );
      out.write("<br>\r\ntaskCode: ");
      out.print( GlobalData.getSzCdTask(request) );
      out.write('\r');
      out.write('\n');
      out.write('(');
      out.print( EventSearchConversation.decodeTask(GlobalData.getSzCdTask(request)) );
      out.write(") <br>\r\n<br>\r\neventId: ");
      out.print( GlobalData.getUlIdEvent(request) );
      out.write("<br>\r\n<br>\r\ncaseId: ");
      out.print( GlobalData.getUlIdCase(request) );
      out.write("<br>\r\nprogram: ");
      out.print( GlobalData.getSzCdStageProgram(request) );
      out.write("<br>\r\nstageCode: ");
      out.print( GlobalData.getSzCdStage(request) );
      out.write("<br>\r\nstageId: ");
      out.print( GlobalData.getUlIdStage(request) );
      out.write("<br>\r\nstageName: ");
      out.print( GlobalData.getSzNmStage(request) );
      out.write("<br>\r\nstageType: ");
      out.print( GlobalData.getSzCdStageType(request) );
      out.write("<br>\r\n<br>\r\neventListCaller: ");
      out.print( EventSearchConversation.getCaller(request) );
      out.write("<br>\r\npreviousUrl: ");
      out.print( ContextHelper.getPreviousUrl(request) );
      out.write("<br>\r\nnewEventUrl: ");
      out.print( ContextHelper.getStringSafe(request, "newEventUrl") );
      out.write("<br>\r\n<br>\r\n\r\n<hr>\r\n<address></address>\r\n<!-- hhmts start -->\r\nLast modified: Thu Jan 09 09:56:43 Central Standard Time 2003\r\n<!-- hhmts end -->\r\n</body> </html>\r\n");
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
