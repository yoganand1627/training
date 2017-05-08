package org.apache.jsp.grnds_002ddocs.document.cfp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ExceedQueueLimitException;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CaseFilePrint;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public final class QuickTestSubmit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  public static void test(Cfp cfp, int userId, String userLogin, String outputCode, String program, String caseId)
          throws ExceedQueueLimitException, RemoteException {
    DateFormat dateFormat = new SimpleDateFormat("MMdd_HHmm");

    String jobName = "CFP Test Case " + program + " " + outputCode + " " + caseId;

    String destinationFileName =
            CfpConversation.CFP_BASE_FILE_LOCATION +
            program + "_" +
            outputCode + "_" +
            caseId + "_" +
            dateFormat.format(new Date()) +
            ".pdf";

    String[] outputCodesArray = new String[] {outputCode};

    CaseFilePrint.submitCfp(cfp, userId, userLogin, jobName, destinationFileName, Integer.parseInt(caseId), 0,
                            outputCodesArray);
  }

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  try {
    int userId = BasePrsConversation.getUserID(request);
    String outputCode = request.getParameter("outputCode");
    String program = request.getParameter("program");
    String caseId = request.getParameter("caseId");

      out.write("\r\n\r\nuserId: ");
      out.print( userId );
      out.write("<br/>\r\noutputCode: ");
      out.print( outputCode );
      out.write("<br/>\r\nprogram: ");
      out.print( program );
      out.write("<br/>\r\ncaseId: ");
      out.print( caseId );
      out.write("<br>\r\n\r\n");

  WebApplicationContext context =
          WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
  Cfp cfp = (Cfp) context.getBean("cfp");
  test(cfp, userId, BasePrsConversation.getUserLogonID(request), outputCode, program, caseId);

      out.write("\r\nSubmitted!<br>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  function openQueue() {\r\n    //http://www.devguru.com/technologies/ecmascript/quickref/win_open.html\r\n    var width = 820;\r\n    var height = 400;\r\n    var left = screen.availWidth - width - 10;\r\n    var top = 0;\r\n    var queueStatus = window.open(\"");
      out.print( CfpConversation.QUEUE_STATUS );
      out.write("\",\r\n            \"queueStatus\",\r\n            \"menubar=no,location=no,resizable=yes,scrollbars=yes,\" +\r\n            \"width=\" + width + \",height=\" + height + \",left=\" + left + \",top=\" + top);\r\n    queueStatus.focus();\r\n  }\r\n</script>\r\n<br>\r\n<a href=\"javascript:openQueue()\">see queue</a><br>\r\n<br>\r\n<a href=\"");
      out.print( CfpConversation.CONVERSATION_URL );
      out.write("QuickTest\">submit something else</a><br>\r\n");

  }
  catch (Exception e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
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
