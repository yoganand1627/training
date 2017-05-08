package org.apache.jsp.grnds_002ddocs.reports;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsConversation;

public final class ReportList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n  function updateReports(id) {\r\n    document.frmUpdateReports.ulIdRptList.value = id;\r\n    document.frmUpdateReports.submit();\r\n  }\r\n\r\n  function setRetryParms(reportName, reportVersion, reportID, emailMessage, reportType) {\r\n    document.frmUpdateReports.retry.value = 'true';\r\n    document.frmUpdateReports.szNmRptSqrName.value = reportName;\r\n    document.frmUpdateReports.szNmRptSqrVer.value = reportVersion;\r\n    document.frmUpdateReports.ulIdRptList.value = reportID;\r\n    document.frmUpdateReports.szTxtEmailMessage.value = emailMessage;\r\n    document.frmUpdateReports.szNmRptType.value = reportType;\r\n    \r\n  }\r\n\r\n  function checkRetryStatus() {\r\n    if (!(document.frmUpdateReports.retry.value == 'true')) {\r\n      alert('");
      out.print(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("');\r\n      return false;\r\n    } else {\r\n      document.frmUpdateReports.FormValidateCancel = 'true';\r\n      return true;\r\n    }\r\n  }\r\n</script>\r\n\r\n");

  CARC06SI carc06si = (CARC06SI) request.getAttribute("INPUT");
  CARC06SO carc06so = (CARC06SO) request.getAttribute("OUTPUT");
  int loopCount = 0;
  int tabIndex = 1;
  String pageMode = PageModeConstants.EDIT; //Needed for validate form
  boolean bRetryButtonHide = true;
  boolean bIsBatchReport = false;
  String personID = ContextHelper.getStringSafe(request, "ulIdPerson");
  String retrieveType = ContextHelper.getStringSafe(request, "cSysIndRptRtrvType");

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

  if (carc06so == null) {

      out.write("\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorderList\">\r\n  <tr>\r\n    <th class=\"thList\">&nbsp;</th>\r\n    <th class=\"thList\">Status</th>\r\n    <th class=\"thList\">Name</th>\r\n    <th class=\"thList\">Description</th>\r\n    <th class=\"thList\">Generation Date</th>\r\n    <th class=\"thList\">Purge Date</th>\r\n    <th class=\"thList\">Output</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"7\">\r\n      ");
      out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

} else {
  ROWCARC06SOG_ARRAY rowArray = carc06so.getROWCARC06SOG_ARRAY();
  ROWCARC06SOG row;
  String destinationParameters =
          "?cSysIndRptRtrvType=" + carc06si.getCSysIndRptRtrvType() + "&ulIdPerson=" + carc06si.getUlIdPerson();
  String destination = "/admin/Reports/reportDelete" + destinationParameters;

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmUpdateReports");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction( destination );
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("ulIdPerson");
          _jspx_th_impact_validateInput_0.setValue( personID );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("cSysIndRptRtrvType");
          _jspx_th_impact_validateInput_1.setValue( retrieveType );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"95%\">\r\n<tr>\r\n<td>\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/admin/Reports/reportList");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n</td>\r\n</tr>\r\n</table>\r\n\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorderList\">\r\n<tr>\r\n  <th class=\"thList\">&nbsp;</th>\r\n  <th class=\"thList\">Status</th>\r\n  <th class=\"thList\">Name</th>\r\n  <th class=\"thList\">Description</th>\r\n  <th class=\"thList\">Generation Date</th>\r\n  <th class=\"thList\">Purge Date</th>\r\n</tr>\r\n");

  for (Enumeration e = rowArray.enumerateROWCARC06SOG(); e.hasMoreElements();) {
    loopCount++;
    String rowCss = loopCount % 2 == 1 ? "altColor" : "";

    row = (ROWCARC06SOG) e.nextElement();
    String reportType = row.getSzNmRptType();
    String reportSqrName = row.getSzNmRptSqrName();
    String indShinesBatch = row.getBIndShinesBatch();
    if ("B".equals(reportType) || "E".equals(reportType) || "M".equals(reportType) || "K".equals(reportType) || "Y".equals(indShinesBatch)) {
      bIsBatchReport = true;
    } else {
      bIsBatchReport = false;
    }

              out.write("\r\n<tr class=\"");
              out.print(rowCss);
              out.write("\">\r\n  <td>\r\n    ");

      if (!bIsBatchReport && (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_ERR))) {
        //show radio buttons and 'retry' button
        bRetryButtonHide = false;
        String radioValue = String.valueOf(loopCount);
        String onClickString = "setRetryParms( '" + row.getSzNmRptSqrName() + "', '" + row.getSzNmRptSqrVer() +
                               "', '" + row.getUlIdRptList() + "', '" + row.getSzTxtRptLstRuntimeName() + "', '" + row.getSzNmRptType() +  "' )";
    
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_9.setType("radio");
              _jspx_th_impact_validateInput_9.setName("rbRowSelect");
              _jspx_th_impact_validateInput_9.setCssClass("formInput");
              _jspx_th_impact_validateInput_9.setOnClick( onClickString );
              _jspx_th_impact_validateInput_9.setValue( radioValue );
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");

    } else {
    
              out.write("\r\n    &nbsp;&nbsp;\r\n    ");

      }
    
              out.write("\r\n  </td>\r\n  ");

    String strStatus;
    if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_DONE)) {
      strStatus = "Complete";
    } else if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_PENDING)) {
      strStatus = "Pending";
    } else if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_RUNNING)) {
      strStatus = "Running";
    } else if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_ERR)) {
      strStatus = "Error";
    } else {
      strStatus = row.getSzTxtRptLstStatus();
    }
  
              out.write("\r\n  <td>");
              out.print(strStatus);
              out.write("\r\n  </td>\r\n  ");

    if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_DONE)) {
      if (bIsBatchReport) {
        // report is done and is batch
        // display the report, but don't try to delete it
  
              out.write("\r\n  <td>\r\n    <!-- Use a relative URL because we are already in the Reports conversation. -->\r\n    <a href=\"/admin/Reports/reportRetrieve?FILENAME=");
              out.print( row.getSzTxtRptGenName() );
              out.write("&RPTTYPE=");
              out.print( row.getSzNmRptType() );
              out.write("\"\r\n       target=\"_blank\">");
              out.print( row.getSzTxtRptFullName() );
              out.write("\r\n    </a>\r\n  </td>\r\n  ");

  } else {
    // report done and not batch -- display the report and delete it
  
              out.write("\r\n  <td>\r\n    <!-- Use a relative URL because we are already in the Reports conversation. -->\r\n    <a href=\"/admin/Reports/reportRetrieve?FILENAME=");
              out.print( row.getSzTxtRptGenName() );
              out.write("&RPTTYPE=");
              out.print( row.getSzNmRptType() );
              out.write("\" target=\"_blank\"\r\n       onClick=\"updateReports('");
              out.print( row.getUlIdRptList() );
              out.write("')\">");
              out.print( row.getSzTxtRptFullName() );
              out.write("\r\n    </a>\r\n  </td>\r\n  ");

    } //end else report done and not batch
  } else {
    // report is not done
  
              out.write("\r\n  <td>\r\n    ");
              out.print(row.getSzTxtRptFullName());
              out.write("\r\n  </td>\r\n  ");

    } //end else report is not done
  
              out.write("\r\n  <td>\r\n    ");
              out.print((row.getSzTxtRptLstRuntimeName() == null) ? "" : row.getSzTxtRptLstRuntimeName());
              out.write("\r\n  </td>\r\n  <td>\r\n    ");
              out.print( FormattingHelper.formatDate(row.getDtDtRptLstGeneration()) );
              out.write("\r\n  </td>\r\n  <td>\r\n    ");
              out.print( FormattingHelper.formatDate(row.getDtDtRptLstRetainage()) );
              out.write("\r\n  </td>\r\n\r\n</tr>\r\n");

  } //end for Enumeration

              out.write("\r\n\r\n</table>\r\n\r\n");
              out.write('\r');
              out.write('\n');
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"95%\">\r\n<tr>\r\n<td>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</td>\r\n</tr>\r\n</table>\r\n\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <td width=\"5%\">\r\n      ");

        if (!bRetryButtonHide) {
      
          out.write("\r\n      ");
          if (_jspx_meth_impact_ButtonTag_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n      ");

        } // end if retrybutton hide
      
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");

  } //end big else (inputs, outputs not null)

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

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("resultsPerPage");
    _jspx_th_impact_validateInput_2.setValue("20");
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
    _jspx_th_impact_validateInput_3.setName("ulIdRptList");
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
    _jspx_th_impact_validateInput_4.setName("szNmRptSqrName");
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
    _jspx_th_impact_validateInput_5.setName("szNmRptSqrVer");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("retry");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("szTxtEmailMessage");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("szNmRptType");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_1 = _jspx_th_impact_validateErrors_1.doStartTag();
    if (_jspx_th_impact_validateErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ButtonTag_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ButtonTag
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
    _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_ButtonTag_0.setName("btnRetry");
    _jspx_th_impact_ButtonTag_0.setImg("btnRetry");
    _jspx_th_impact_ButtonTag_0.setForm("frmUpdateReports");
    _jspx_th_impact_ButtonTag_0.setAction("/admin/Reports/reportRetry");
    _jspx_th_impact_ButtonTag_0.setFunction("return checkRetryStatus()");
    _jspx_th_impact_ButtonTag_0.setTabIndex(1);
    int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
    if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
