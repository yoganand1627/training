package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorListMessage;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;

public final class popIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // This must be set before the response is started
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );

  try  // Global try-catch block
  {
    //  BaseSessionStateManager state = new HiddenFieldSessionStateManager();
    //(BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
    //  UserProfile userProfile = UserProfileHelper.getUserProfile( request );
    //  String userName = null;
    //  if( userProfile != null)
    //  {
    //    userName = userProfile.getUserFullName();
    //  }

      out.write("\r\n  ");
      if (_jspx_meth_impact_setAttribute_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      if (_jspx_meth_impact_setAttribute_1(_jspx_page_context))
        return;
      out.write("\r\n  ");
      if (_jspx_meth_impact_setAttribute_2(_jspx_page_context))
        return;
      out.write("\r\n  <html>\r\n  <head>\r\n  <title>");
      if (_jspx_meth_impact_insert_0(_jspx_page_context))
        return;
      out.write("</title>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n  <SCRIPT src=\"/grnds-docs/js/shared/prsValidation.js\"></script>\r\n  <SCRIPT src=\"/grnds-docs/js/shared/syncscroll.js\"></script>\r\n  <SCRIPT src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n  <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n    opener.resetTimeout();\r\n  </script>\r\n  </head>\r\n  <body leftmargin=\"0\" topmargin=\"0\">\r\n  <!-- Begin Title and Legend table-->\r\n  <table align=\"center\" width=\"400\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\" class=\"parentTable\">\r\n    <tr>\r\n      <td colspan=\"2\" class=\"pageTitle\">");
      if (_jspx_meth_impact_insert_1(_jspx_page_context))
        return;
      out.write("</td>\r\n        </tr>\r\n  </table>\r\n  <!-- End Title and Legend table-->\r\n  <!-- Begin Parent table-->\r\n  <table align=\"center\" width=\"400\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"parentTable\">\r\n    <tr>\r\n      <td>\r\n  <!--- BEGIN HtmlBody insertion (index.jsp) --->\r\n        ");
      if (_jspx_meth_impact_insert_2(_jspx_page_context))
        return;
      out.write("<br/>\r\n  <!--- END HtmlBody insertion (index.jsp)-- END Parent Table --->\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  </body>\r\n  </html>\r\n");

}
catch (Exception e) //global try-catch block
{
  out.println("<h2>Your JSP generated an exception: </h2>");
  out.println("<pre>");
  out.println( gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException.getStackTrace( e ) );
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

  private boolean _jspx_meth_impact_setAttribute_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_0.setParent(null);
    _jspx_th_impact_setAttribute_0.setParameter("level1Tab");
    int _jspx_eval_impact_setAttribute_0 = _jspx_th_impact_setAttribute_0.doStartTag();
    if (_jspx_th_impact_setAttribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_1.setParent(null);
    _jspx_th_impact_setAttribute_1.setParameter("level2Tab");
    int _jspx_eval_impact_setAttribute_1 = _jspx_th_impact_setAttribute_1.doStartTag();
    if (_jspx_th_impact_setAttribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_2.setParent(null);
    _jspx_th_impact_setAttribute_2.setParameter("level3Tab");
    int _jspx_eval_impact_setAttribute_2 = _jspx_th_impact_setAttribute_2.doStartTag();
    if (_jspx_th_impact_setAttribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_insert_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_0.setParent(null);
    _jspx_th_impact_insert_0.setParameter("HtmlTitle");
    int _jspx_eval_impact_insert_0 = _jspx_th_impact_insert_0.doStartTag();
    if (_jspx_th_impact_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_insert_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_1.setParent(null);
    _jspx_th_impact_insert_1.setParameter("HtmlTitle");
    int _jspx_eval_impact_insert_1 = _jspx_th_impact_insert_1.doStartTag();
    if (_jspx_th_impact_insert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_insert_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_2.setParent(null);
    _jspx_th_impact_insert_2.setParameter("HtmlBody");
    int _jspx_eval_impact_insert_2 = _jspx_th_impact_insert_2.doStartTag();
    if (_jspx_th_impact_insert_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
