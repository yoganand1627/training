package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.grnds.facility.config.GrndsConfiguration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class LoginBanner_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n");


String WEB_HELP = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "webHelp");



      out.write("\r\n\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/RoboHelp_CSH.js\"></script>\r\n<table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" height=\"60\" border=\"0\"\r\n background = \"/grnds-docs/images/metaphor/SHINES_word_header.jpg\">\r\n      <tr><td align = \"right\"><img src=\"/grnds-docs/images/dhr_dfcs_logo.gif\"></td></tr>\r\n      </table>\r\n    </td>\r\n  </tr >\r\n  <tr >\r\n    <td>\r\n      <table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n      <tr class=\"even\" height =\"20\">\r\n       <td align=\"left\" width=\"80%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n \t   <a class=\"header\" href='http://www.georgia.gov' target='_blank'>Georgia.gov</a>&nbsp;&gt;&nbsp;\r\n \t   <a class=\"header\" href='http://www.georgia.gov/00/topic_index_channel/0,2092,4802_937045,00.html' target='_blank'>Agencies & Organizations</a>&nbsp;&gt;&nbsp;\r\n \t   <a class=\"header\" href='http://www.dhs.georgia.gov' target='_blank'>Department of Human Services</a>&nbsp;&gt;&nbsp;\r\n \t   <a class=\"header\" href='http://www.dfcs.dhs.georgia.gov' target='_blank'> DFCS</a>&nbsp;&gt;&nbsp;SHINES Portal\r\n");
      out.write("       </td>\r\n       <td align=\"center\" width=\"10%\"><a class=\"header\" \r\n              href=\"javaScript:RH_ShowHelp(0, '");
      out.print(WEB_HELP);
      out.write("', HH_HELP_CONTEXT, ");
      if (_jspx_meth_impact_WebHelpURL_0(_jspx_page_context))
        return;
      out.write(")\">\r\n              Help</a></td>\r\n     </tr>\r\n    \r\n     </table>\r\n     <table border=\"0\" width=\"780\" cellspacing=\"0\" cellpadding=\"0\">\r\n  <tr>\r\n    <td width=\"780\"><img src=\"/grnds-docs/images/metaphor/SHINES_Header.jpg\"></td>\r\n  </table>\r\n  </tr>\r\n</table>\r\n\r\n     ");
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

  private boolean _jspx_meth_impact_WebHelpURL_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:WebHelpURL
    gov.georgia.dhr.dfcs.sacwis.web.core.tags.WebHelpURLTag _jspx_th_impact_WebHelpURL_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.tags.WebHelpURLTag();
    _jspx_th_impact_WebHelpURL_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_WebHelpURL_0.setParent(null);
    int _jspx_eval_impact_WebHelpURL_0 = _jspx_th_impact_WebHelpURL_0.doStartTag();
    if (_jspx_th_impact_WebHelpURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
