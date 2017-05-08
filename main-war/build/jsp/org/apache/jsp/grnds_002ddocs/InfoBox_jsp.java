package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public final class InfoBox_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  protected void infoBoxRow(JspWriter out, String name, int value) throws IOException {
    String valueString = null;
    if (value != 0) {
      valueString = "" + value;
    }
    infoBoxRow(out, name, valueString);
  }

  protected void infoBoxRow(JspWriter out, String name, String value) throws IOException {
    out.println("    <tr>");
    out.println("        <td class=\"infoBox\" width=\"40%\">" + name + ":&nbsp;</td>");
    out.println("        <td class=\"infoBox\" width=\"60%\">");
    if ((value != null) && ("".equals(value) == false)) {
      out.println(value);
    } else {
      out.println("&nbsp;");
    }
    out.println("                </td>");
    out.println("    </tr>");
  }

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      if (_jspx_meth_impact_setAttribute_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"infoBox\">\r\n");

  String info1 = (String) request.getAttribute("Info1");
  String info2 = (String) request.getAttribute("Info2");
  String info3 = (String) request.getAttribute("Info3");
  for (int i = 0; i < 3; i++) {
    String info = info1;
    if (i == 1) {
      info = info2;
    } else if (i == 2) {
      info = info3;
    }
    if (info == null) {
      info = "";

      out.write("\r\n<tr>\r\n  <td width=\"40%\">&nbsp;</td>\r\n  <td width=\"60%\">&nbsp;</td>\r\n</tr>\r\n");

    }
    //mdm: I could have made this a hashtable lookup based on info,
    // but I didn't know if the INFO STRING will ever be DIFFERENT THAN the DISPLAY STRING
    if ("User Name".equals(info)) {
      UserProfile infoBoxUser = UserProfileHelper.getUserProfile(request);
      infoBoxRow(out, "User Name", infoBoxUser.getUserFullName());
    } else if ("User ID".equals(info)) {
      UserProfile infoBoxUser = UserProfileHelper.getUserProfile(request);
      infoBoxRow(out, "User ID", infoBoxUser.getUserID());
    } else if ("CaseID".equals(info)) {
      infoBoxRow(out, "Case ID", GlobalData.getUlIdCase(request));
    } else if ("Stage Name".equals(info)) {
      infoBoxRow(out, "Stage Name", GlobalData.getSzNmStage(request));
    } else if ("Person Name".equals(info)) {
      infoBoxRow(out, "Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Case Name".equals(info)) {
      infoBoxRow(out, "Case Name", GlobalData.getSzNmCase(request));
    } else if ("Case or Stage Name".equals(info)) {
      infoBoxRow(out, "Case Name", GlobalData.getSzNmCase(request));
      infoBoxRow(out, "Stage Name", GlobalData.getSzNmStage(request));
    } else if ("Staff Name".equals(info)) {
      infoBoxRow(out, "Staff Name", GlobalData.getSzNmStaff(request));
    } else if ("Person Reviewed".equals(info)) {
      infoBoxRow(out, "Person Reviewed", GlobalData.getSzNmPersonFull(request));
    } else if ("Service".equals(info)) {
      infoBoxRow(out, "Service", GlobalData.getSzServiceDecode(request));
    } else if ("Resource Name".equals(info)) {
      infoBoxRow(out, "Resource Name", GlobalData.getSzNmResource(request));
    } else if ("Resource ID".equals(info)) {
      infoBoxRow(out, "Resource ID", GlobalData.getUlIdResource(request));
    } else if ("Full Name of Principal".equals(info)) {
      infoBoxRow(out, "Principal Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Full Person Name".equals(info)) {
      infoBoxRow(out, "Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Account Number".equals(info)) {
      infoBoxRow(out, "Account Number", GlobalData.getSzNbrFinAccount(request));
    } else if ("Invoice ID".equals(info)) {
      infoBoxRow(out, "Invoice ID", GlobalData.getUlIdInvoice(request));
    } else if ("Invoice Phase".equals(info)) {
      infoBoxRow(out, "Invoice Phase", GlobalData.getSzCdInvoPhase(request));
    } else if ("Contract ID".equals(info)) {
      infoBoxRow(out, "Contract ID", GlobalData.getUlIdContract(request));
    } else if ("Period".equals(info)) {
      infoBoxRow(out, "Period", GlobalData.getUlNbrCnperPeriod(request));
    } else if ("Version".equals(info)) {
      infoBoxRow(out, "Version", GlobalData.getUlNbrCnverVersion(request));
    } else if ("Stage Code".equals(info)) {
      infoBoxRow(out, "Stage Code", Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage(request)));
    } else if ("Stage ID".equals(info)) {
      infoBoxRow(out, "Stage ID", GlobalData.getUlIdStage(request));
    } else if ("Person ID".equals(info)) {
      infoBoxRow(out, "Person ID", GlobalData.getUlIdPerson(request));
    } else if ("Call ID".equals(info)) {
      infoBoxRow(out, "Call ID", GlobalData.getUlIdStage(request));
    } else if ("Waiver ID".equals(info)) {
      infoBoxRow(out, "Waiver ID", GlobalData.getUlIdEvent(request));
    } else if ("County".equals(info)) {
      infoBoxRow(out, "County", Lookup.simpleDecodeSafe(CodesTables.CCOUNT, GlobalData.getSzCdCounty(request)));
    } else if ("CRS ID".equals(info)) {
      infoBoxRow(out, "CRS ID", GlobalData.getUlIdCrs(request));
    }
  }

      out.write("\r\n</table>\r\n");
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
    _jspx_th_impact_setAttribute_0.setParameter("Info1");
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
    _jspx_th_impact_setAttribute_1.setParameter("Info2");
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
    _jspx_th_impact_setAttribute_2.setParameter("Info3");
    int _jspx_eval_impact_setAttribute_2 = _jspx_th_impact_setAttribute_2.doStartTag();
    if (_jspx_th_impact_setAttribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
