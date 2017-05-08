package org.apache.jsp.grnds_002ddocs.reports;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

public final class ReportForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  UserProfile user = UserProfileHelper.getUserProfile (request);

      out.write("\r\n\r\n<h3>\r\nAvailable Reports:\r\n</h3>\r\n<a href=\"/admin/Reports/reportList?ulIdPerson=");
      out.print(user.getUserID());
      out.write("&cSysIndRptRtrvType=Y&resultsPerPage=10\">Report List</a>\r\n\r\n");
      //  impact:reportList
      gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag _jspx_th_impact_reportList_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag();
      _jspx_th_impact_reportList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_reportList_0.setParent(null);
      _jspx_th_impact_reportList_0.setTabIndex(1);
      _jspx_th_impact_reportList_0.setPersonId(user.getUserID());
      int _jspx_eval_impact_reportList_0 = _jspx_th_impact_reportList_0.doStartTag();
      if (_jspx_eval_impact_reportList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_report_0(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_report_1(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_report_2(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_report_3(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_reportList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_reportList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<form>\r\n<table>\r\n<tr>\r\n<td>\r\n<input type=\"radio\" name=\"id\" checked onClick=\"setReportParameters('param','18022007');\">\r\n</td>\r\n<td>\r\nSTAGE\r\n</td>\r\n</tr>\r\n<tr>\r\n<td>\r\n<input type=\"radio\" name=\"id\" onClick=\"setReportParameters('param','18001988');\">\r\n</td>\r\n<td>\r\nINVOICE\r\n</td>\r\n</tr>\r\n</table>\r\n</form>\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_report_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_0.setUseHiddenParameters(true);
    _jspx_th_impact_report_0.setReportName("ccf02o00");
    int _jspx_eval_impact_report_0 = _jspx_th_impact_report_0.doStartTag();
    if (_jspx_th_impact_report_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_report_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_1 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_1.setUseHiddenParameters(true);
    _jspx_th_impact_report_1.setReportName("ccf03o00");
    int _jspx_eval_impact_report_1 = _jspx_th_impact_report_1.doStartTag();
    if (_jspx_th_impact_report_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_report_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_2 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_2.setUseHiddenParameters(false);
    _jspx_th_impact_report_2.setReportName("cfn51o01");
    int _jspx_eval_impact_report_2 = _jspx_th_impact_report_2.doStartTag();
    if (_jspx_eval_impact_report_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n    ");
        if (_jspx_meth_impact_reportParameter_0(_jspx_th_impact_report_2, _jspx_page_context))
          return true;
        out.write("\r\n  ");
        int evalDoAfterBody = _jspx_th_impact_report_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_report_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_reportParameter_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_report_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:reportParameter
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
    _jspx_th_impact_reportParameter_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_reportParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_2);
    _jspx_th_impact_reportParameter_0.setValue("5600240");
    int _jspx_eval_impact_reportParameter_0 = _jspx_th_impact_reportParameter_0.doStartTag();
    if (_jspx_th_impact_reportParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_report_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_3 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_3.setUseHiddenParameters(false);
    _jspx_th_impact_report_3.setReportName("cfn05o01");
    int _jspx_eval_impact_report_3 = _jspx_th_impact_report_3.doStartTag();
    if (_jspx_eval_impact_report_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n    ");
        if (_jspx_meth_impact_reportParameter_1(_jspx_th_impact_report_3, _jspx_page_context))
          return true;
        out.write("\r\n    ");
        if (_jspx_meth_impact_reportParameter_2(_jspx_th_impact_report_3, _jspx_page_context))
          return true;
        out.write("\r\n  ");
        int evalDoAfterBody = _jspx_th_impact_report_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_report_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_reportParameter_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_report_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:reportParameter
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
    _jspx_th_impact_reportParameter_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_reportParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_3);
    _jspx_th_impact_reportParameter_1.setValue("03");
    int _jspx_eval_impact_reportParameter_1 = _jspx_th_impact_reportParameter_1.doStartTag();
    if (_jspx_th_impact_reportParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_reportParameter_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_report_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:reportParameter
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
    _jspx_th_impact_reportParameter_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_reportParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_3);
    _jspx_th_impact_reportParameter_2.setValue("/opt/impact/config/devl/applications/impact/xmlTest/reports");
    int _jspx_eval_impact_reportParameter_2 = _jspx_th_impact_reportParameter_2.doStartTag();
    if (_jspx_th_impact_reportParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
