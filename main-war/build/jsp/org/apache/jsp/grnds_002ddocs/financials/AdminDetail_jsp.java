package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00;

public final class AdminDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Administrative Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/16/2002
//*
//*  Description:
//*  This JSP is used to maintain a Administrative Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/08/03  GRIMSHNAN         SIR 17354 Fixed opening and closing java brackets

      out.write("\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
//Get the output object from the request
ROWCFIN15SOG00 rowcfin15sog00 = (ROWCFIN15SOG00) request.getAttribute("ROWCFIN15SOG00");
//Set excludeViews = (Set) state.getAttribute("excludeViews", request);
//Set serviceCodeOptions = (Set) state.getAttribute(InvoiceConversation.SERVICE_CODE_OPTIONS, request);
Set countyOptions = (Set) state.getAttribute(InvoiceConversation.COUNTY_OPTIONS, request);
CFIN15SO cfin15so = (CFIN15SO) request.getAttribute("CFIN15SO");
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);

//String selSzCdCounty = "";
//String comments = "";

if (cfin15so == null) {
 cfin15so = new CFIN15SO();
}

String cdService = ContextHelper.getStringSafe(request, "selSzCdAdminDtlService");
String county = ContextHelper.getStringSafe(request, "selSzCdCounty");

if (rowcfin15sog00 == null) {
  rowcfin15sog00 = new ROWCFIN15SOG00();
} else {
  cdService = rowcfin15sog00.getSzCdAdminDtlService();
  county = rowcfin15sog00.getSzCdCounty();
}

//if(!InvoiceConversation.optionsContainsCode(serviceCodeOptions, cdService)) {
//  cdService = null;
//}
if(!InvoiceConversation.optionsContainsCode(countyOptions, county)) {
  county = "";
}


      out.write('\r');
      out.write('\n');
 // Start Javascript Section

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n     ");
 InvoiceConversation.writeJavascriptArrays(out, request, InvoiceConversation.COUNTY_SERVICE_MAP, CodesTables.CSVCCODE, "c"); 
      out.write("\r\n     \r\n     function setServiceOptions(serviceCode) {\r\n       var countyValue = document.frmAdminDetail.selSzCdCounty.value;\r\n       var serviceDropdown = document.frmAdminDetail.selSzCdAdminDtlService;\r\n       if(countyValue != null && countyValue != \"\") {\r\n         var optionsArray = eval(\"c\"+countyValue);\r\n         try {\r\n           populateDropdown(serviceDropdown, serviceCode, optionsArray);\r\n         } catch(e) {\r\n           populateDropdown(document.frmAdminDetail.selSzCdAdminDtlService_Disabled, serviceCode, optionsArray);\r\n         }\r\n       } else {\r\n         try {\r\n           clearDropdown(serviceDropdown);\r\n         } catch(e) {\r\n           clearDropdown(document.frmAdminDetail.selSzCdAdminDtlService_Disabled);\r\n         }\r\n       }\r\n     }\r\n\r\n    //  Called onUnload of page to remind user unsaved data will be lost\r\n     window.onbeforeunload = function ()\r\n     {\r\n       IsDirty();\r\n     }\r\n\r\n</script>\r\n");
 //End Javascript Section

      out.write("\r\n\r\n");

  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;


  //Initialize the variables that will specify the display rules for individual fields

  //String pageModePassed = "";
  String overallPageMode = PageMode.getPageMode(request);

   //if (request.getAttribute("pageMode") != null )
   //{
   //  pageModePassed = (String) request.getAttribute("pageMode");
   //  if (pageModePassed.equals(PageModeConstants.MODIFY))
   //  {
   //    overallPageMode = PageModeConstants.EDIT;
   //  }
   //  else if (pageModePassed.equals(PageModeConstants.NEW))
   //  {
   //    overallPageMode = PageModeConstants.NEW;
   //  }
   //  else if (pageModePassed.equals(PageModeConstants.VIEW))
   //  {
   //    overallPageMode = PageModeConstants.VIEW;
   //  }
   //}


      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAdminDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Invoice/saveAdmin");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.AdminCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_0.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnSzCdAdminDtlInvoDisptn");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatString(rowcfin15sog00.getSzCdAdminDtlInvoDisptn())  );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_2.setValue( DateHelper.toISOString(rowcfin15sog00.getTsLastUpdate()) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnUlIdAdminDtl");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatInt(rowcfin15sog00.getUlIdAdminDtl())  );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCIndAdminDtlRejItm");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatString(rowcfin15sog00.getCIndAdminDtlRejItm()) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnIndInvoiceReversal");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(cfin02so.getSzCdInvoAdjustmentRb()) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnDtDtInvoReceivedDate");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatDate(cfin02so.getDtDtInvoReceivedDate()) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"9\">Administrative</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Service");
          _jspx_th_impact_validateSelect_0.setName("selSzCdAdminDtlService");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString(cdService) );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setColspan("3");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setName("selSzCdCounty");
          _jspx_th_impact_validateSelect_1.setOnChange("setServiceOptions('')");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setOptions( countyOptions );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString(county) );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName("txtUsNbrAdminDtlCsli");
          _jspx_th_impact_validateInput_7.setLabel("CSLI");
          _jspx_th_impact_validateInput_7.setConstraint("Digit2Less");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatInt(rowcfin15sog00.getUsNbrAdminDtlCsli()) );
          _jspx_th_impact_validateInput_7.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_7.setSize("2");
          _jspx_th_impact_validateInput_7.setMaxLength("2");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setName("txtUMoAdminDtlSvcMonth");
          _jspx_th_impact_validateInput_8.setLabel("Month");
          _jspx_th_impact_validateInput_8.setConstraint("MonthNumber");
          _jspx_th_impact_validateInput_8.setRequired("true");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatInt(rowcfin15sog00.getUMoAdminDtlSvcMonth()) );
          _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_8.setSize("2");
          _jspx_th_impact_validateInput_8.setMaxLength("2");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setName("txtUYrAdminDtlSvcYear");
          _jspx_th_impact_validateInput_9.setLabel("Year");
          _jspx_th_impact_validateInput_9.setConstraint("Year");
          _jspx_th_impact_validateInput_9.setRequired("true");
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatInt(rowcfin15sog00.getUYrAdminDtlSvcYear()) );
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_9.setSize("4");
          _jspx_th_impact_validateInput_9.setMaxLength("4");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setName("txtDAmtAdminDtlAdminAlloc");
          _jspx_th_impact_validateInput_10.setLabel("Administrative");
          _jspx_th_impact_validateInput_10.setConstraint("Money");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatMoney(rowcfin15sog00.getDAmtAdminDtlAdminAlloc()) );
          _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_10.setSize("11");
          _jspx_th_impact_validateInput_10.setMaxLength("11");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setName("txtDAmtAdminDtlOther");
          _jspx_th_impact_validateInput_11.setLabel("Other");
          _jspx_th_impact_validateInput_11.setConstraint("Money");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatMoney(rowcfin15sog00.getDAmtAdminDtlOther()) );
          _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_11.setSize("11");
          _jspx_th_impact_validateInput_11.setMaxLength("11");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setName("txtDAmtAdminPromotional");
          _jspx_th_impact_validateInput_12.setLabel("Promotional");
          _jspx_th_impact_validateInput_12.setConstraint("Money");
          _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatMoney(rowcfin15sog00.getDAmtAdminDtlPromotional()) );
          _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_12.setSize("11");
          _jspx_th_impact_validateInput_12.setMaxLength("11");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td></td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName("txtComments");
          _jspx_th_impact_validateInput_13.setLabel("Comments");
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setMaxLength("80");
          _jspx_th_impact_validateInput_13.setWidth("80");
          _jspx_th_impact_validateInput_13.setValue(FormattingHelper.formatString(rowcfin15sog00.getSzTxtAdminDtlComments()));
          _jspx_th_impact_validateInput_13.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_13.setConstraint("Comments");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td></td>\r\n  </tr>\r\n  </table>\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmAdminDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Invoice/saveAdmin");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   </tr>\r\n</table>\r\n\r\n\r\n");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
      out.write("\r\n\r\n<script type=\"text/javascript\">\r\n<!--\r\n  setServiceOptions('");
      out.print( FormattingHelper.formatString(cdService) );
      out.write("');\r\n//-->\r\n</script>");
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
}
