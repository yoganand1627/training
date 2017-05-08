package org.apache.jsp.grnds_002ddocs.document.cfp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public final class caseSummaryStub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  try {
    // Set character encoding before printing anything out; this MUST
    //   be done in order to properly display extended characters.
    response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);

      out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n<html>\r\n<head>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <title>Case Summary Stub</title>\r\n</head>\r\n\r\n<body>\r\n<h1>Case Summary Stub</h1>\r\n\r\n<form name=\"stub\" action='");
      out.print( CfpConversation.FORWARD_TO_CFP );
      out.write("' method=\"get\">\r\n  ..... CaseId:&nbsp;&nbsp;<input type=\"text\" name=\"caseId\" value=\"\"><br>\r\n  (opt) StageId:&nbsp;<input type=\"text\" name=\"stageId\" value=\"\"><br>\r\n  <input type=\"hidden\"\r\n         name=\"");
      out.print( ServerSideValidationUtility.FORM_VALIDATION_PREV_URL );
      out.write("\"\r\n         value=\"");
      out.print( CfpConversation.CASE_SUMMARY_STUB );
      out.write("\"/>\r\n  <input type=\"submit\">\r\n</form>\r\n<br>\r\n<br>\r\n<br>\r\n\r\n");

  //don't use 1000000, 1000001
  int[][] ids = new int[][] {
          new int[] {24401368, 0}, //large
          new int[] {16101941, 0}, //large
          new int[] {16015156, 0}, //large; sir 288135
          new int[] {23226045, 0}, //large; sir 288135
          new int[] {23157857, 0}, //large; sir 288135
          new int[] {3000573, 0},  //large; sir 139052
          new int[] {23133019, 0},
          new int[] {23132370, 0}, //has Intake forms time out
          new int[] {23133000, 0},
          new int[] {23132970, 0},
          new int[] {23127091, 0},
          new int[] {23133141, 0},
          new int[] {1000021, 0},
          new int[] {1000001, 0},
          new int[] {23134317, 0},
          new int[] {20064615, 23398497},
          new int[] {20064615, 23398511},
          new int[] {23141007, 23423198},
          new int[] {3001454, 3007040},
          new int[] {1000022, 1000023},
          new int[] {1000001, 1000002},
          new int[] {23090281, 23398513},
          new int[] {23089888, 23398544},
          new int[] {23132986, 23398349},
          new int[] {23132981, 23398442},
          new int[] {23126822, 23398480},
          new int[] {23132680, 23398484},
          new int[] {23133874, 23400607},
          new int[] {23133883, 23400637},
          new int[] {16122488, 23399168},
          new int[] {24288678, 23402657},
          new int[] {23129718, 23398493},
          new int[] {23739724, 23398844}
  };

  WebApplicationContext context =
          WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
  Cfp cfp = (Cfp) context.getBean("cfp");
  for (int i = 0; i < ids.length; i++) {
    int caseId = ids[i][0];
    int stageId = ids[i][1];

    StageDB stageDB = cfp.getStageDB(caseId, stageId);
    Map<String, String> hashtable = new HashMap<String, String>();
    hashtable.put("caseId", "" + caseId);
    hashtable.put("stageId", "" + stageId);
    hashtable.put(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL,
                  CfpConversation.CASE_SUMMARY_STUB);
    String url = BasePrsConversation.getUrl(CfpConversation.FORWARD_TO_CFP, hashtable);
    if (i < 6) {
      out.println("Large: ");
    }
    out.println("<a href=\"" + url + "\">" +
                stageDB.getCaseName() + ", " +
                stageDB.getProgramName() + ", " +
                stageDB.getStageCode() + ", " +
                stageDB.getStageType() + "</a><br>");
  }

      out.write("\r\n\r\n<hr>\r\n<address></address>\r\n<!-- hhmts start -->\r\nLast modified: Tue Nov 12 09:48:23 Central Standard Time 2002\r\n<!-- hhmts end -->\r\n</body>\r\n</html>\r\n");


  }
  catch (Throwable e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }

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
