package org.apache.jsp.grnds_002ddocs.reports;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportPageSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsConversation;

public final class ReportLaunchList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  List<RetrieveReportPageSO> reportPageList = (List<RetrieveReportPageSO>) request.getAttribute("REPORT_PAGE_LIST");
  int loopCount = 0;
  int tabIndex = 1;
  // Defect #
  UserProfile user = UserProfileHelper.getUserProfile(request);
  Object[] reportPageListArray = reportPageList.toArray();
  int reportIndex = 0;

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmReportLaunch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/Reports/displayReportParameterDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(' ');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write(' ');
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");

if (reportPageList == null || reportPageList.isEmpty()) {

          out.write("\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorderList\">\r\n  <tr>\r\n    <th class=\"thList\">Name</th>\r\n    <th class=\"thList\">Description</th>\r\n    <th class=\"thList\">Type</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"7\">\r\n      ");
          out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

} else {

          out.write("  \r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n  ");

  String reportArea = "";
  //Object[] reportPageListArray = reportPageList.toArray();
  int arraySize = reportPageListArray.length;
  for (int arrayIndex = 0; arrayIndex < arraySize ; arrayIndex++) { 
    RetrieveReportPageSO rowTagLabel = (RetrieveReportPageSO) reportPageListArray[arrayIndex];
  
          out.write(' ');
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName(rowTagLabel.getTxtRptAreaType() );
          _jspx_th_impact_ExpandableSectionTag_0.setLabel(rowTagLabel.getTxtRptAreaType() );
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborderList\">   \r\n  <tr>\r\n    <th class=\"thList\">Name</th>\r\n    <th class=\"thList\">Description</th>\r\n    <th class=\"thList\">Type</th>\r\n  </tr>\r\n  ");

  for (int subArrayIndex = arrayIndex; subArrayIndex < arraySize; subArrayIndex++) {
  
    loopCount++;
    String rowCss = loopCount % 2 == 1 ? "altColor" : "odd";
    RetrieveReportPageSO row = (RetrieveReportPageSO) reportPageListArray[subArrayIndex];
    String sqrName = row.getNmRptSqrName();
    String sqrVer = row.getNmRptSqrVer();
    String rptFullName = row.getTxtRptFullName();
    String rptDecs = row.getTxtRptDesc();
    String rptAreaType = row.getTxtRptAreaType();
    String rptType = row.getNmRptType();
    reportIndex = subArrayIndex;
    String rptIndAccessAllowed = row.getIndAccessAllowed();
    
    if (ReportsConversation.BATCH_REPORTS.containsKey(sqrName)) {
 
              out.write("      \r\n    <tr class=\"");
              out.print(rowCss);
              out.write("\">\r\n      <td width=\"20%\" valign=\"top\"><a href=\"javascript:submitForm()\" ");
              out.print( tabIndex++ );
              out.write('"');
              out.write(' ');
              out.write('>');
              out.print( rptFullName );
              out.write("</a></td>\r\n      <td width=\"65%\" valign=\"top\">");
              out.print( rptDecs );
              out.write("</td>\r\n      <td width=\"15%\" valign=\"top\">");
              out.print( rptAreaType );
              out.write("</td>\r\n    </tr>\r\n ");
   }  else if ("Y".equals(rptIndAccessAllowed)) { 
              out.write("\r\n\r\n    <tr class=\"");
              out.print(rowCss);
              out.write("\">\r\n      <td width=\"20%\" valign=\"top\"><a href=\"javascript:submitReportParameterDetails( '");
              out.print( sqrName);
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print( sqrVer);
              out.write("','\r\n      ");
              out.print( rptFullName);
              out.write("', '");
              out.print( rptType);
              out.write("')\" ");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( rptFullName );
              out.write("</a></td>\r\n      <td width=\"65%\" valign=\"top\">");
              out.print( rptDecs );
              out.write("</td>\r\n      <td width=\"15%\" valign=\"top\">");
              out.print( rptAreaType );
              out.write("</td>\r\n    </tr>\r\n  ");
  }  else {  
              out.write("\r\n    <tr class=\"");
              out.print(rowCss);
              out.write("\">\r\n      <td width=\"20%\" valign=\"top\">");
              out.print( rptFullName );
              out.write("</td>\r\n      <td width=\"65%\" valign=\"top\">");
              out.print( rptDecs );
              out.write("</td>\r\n      <td width=\"15%\" valign=\"top\">");
              out.print( rptAreaType );
              out.write("</td>\r\n    </tr>\r\n  ");
 }  
              out.write("\r\n  ");
 
    reportArea = (rptAreaType == null) ? "" : rptAreaType;
    RetrieveReportPageSO lookaheadRow;
    if (subArrayIndex+1 < arraySize) {
      lookaheadRow = (RetrieveReportPageSO) reportPageListArray[subArrayIndex+1];
    } else {
      lookaheadRow = new RetrieveReportPageSO();
    }  
    String lookaheadReportArea = (lookaheadRow.getTxtRptAreaType() == null) ? "" : lookaheadRow.getTxtRptAreaType();
    if (!reportArea.equals(lookaheadReportArea)) { 
      arrayIndex = subArrayIndex; break;
    } // End comparing lookahead 
  } // End subArrayIndex for loop 
              out.write("\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</br>\r\n");
} // End arrayIndex for loop 
          out.write('\r');
          out.write('\n');
} //end big else (inputs, outputs not null) 
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n  function submitReportParameterDetails(hdnNmRptSqrName,hdnNmRptSqrVer,hdnNmOfReport, hdnNmRptType)\r\n  {\r\n    document.frmReportLaunch.hdnNmRptSqrName.value = hdnNmRptSqrName;\r\n    document.frmReportLaunch.hdnNmRptSqrVer.value = hdnNmRptSqrVer;\r\n    document.frmReportLaunch.hdnNmOfReport.value = hdnNmOfReport;\r\n    document.frmReportLaunch.hdnNmRptType.value = hdnNmRptType;\r\n    submitValidateForm( \"frmReportLaunch\", \"/admin/Reports/displayReportParameterDetail\" );\r\n  }\r\n  \r\n  function submitForm ()\r\n  {\r\n    submitValidateForm( \"frmReportLaunch\", \"/admin/Reports/reportList\" );\r\n  }\r\n</script>\r\n");
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnNmRptSqrName");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnNmRptSqrVer");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnNmOfReport");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnIndexOfReport");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnNmRptType");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
