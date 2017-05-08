package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class PymntHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  07/28/03  Todd Reser        SIR 19184 - It has been decided that since a user
                              can click the invoice hyperlink then generate the
                              report, the reports section is un-needed on this
                              page.
  5/18/04   gerryc        SIR 13891 - added radio button and logic so that
                              user can search by contract id.
*/

      out.write("\r\n\r\n\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n");

  UserProfile user = UserProfileHelper.getUserProfile( request );

  //Set the page mode
  String pageMode = PageModeConstants.EDIT;
  String client = "";
  String resource = "";
  String contract = ""; //13891
  boolean hideReportBtn = true;

  /*
    This initially checks the Staff Radio Buttons
    If the client flag is "N", this page is loading coming back from a resource
    or contract search.  Check which one it is, and set appropriate booleans.
  */
  boolean noErrorMessages = !FormValidation.pageHasErrorMessages( request ) && !FormValidation.pageHasValidationMessages( "frmPaymentHistory", request );
  String clientFlag = (String) request.getAttribute("ClientFlag");
  boolean isClientSearch = "Y".equals(clientFlag);
  if ("N".equals(clientFlag))
  {
    //SIR 13891 added in contract search
    String rbUlScrFinPayhistId = (String) request.getAttribute("rbUlScrFinPayhistId");
    if ("contract".equals(rbUlScrFinPayhistId))
    {
      client = "false";
      resource = "false";
      contract = "true";
    }
    else
    {
      client = "false";
      resource = "true";
      contract = "false";
    }
  }
  /* on initial load of the page, or coming back from a client search, populate the
     client radio button */
  else if( clientFlag == null || isClientSearch )
  {
    client = "true";
    resource = "false";
    contract = "false";
  }


  //  Declare variables
  int tabIndex = 1;
  int loopCount = 0;
  int invoiceId = 0;

  String disablePaymentHistory = "true";
  String searchId = ContextHelper.getStringSafe(request, "txtUlSrcFinPayhistId");
  String fromDate = ContextHelper.getStringSafe(request, "txtDtSrcNbrFinPayhistFrom");
  String toDate = ContextHelper.getStringSafe(request, "txtDtSrcDtFinPayhistTo");
  String region = ContextHelper.getStringSafe(request, "selRegion");
  String county = ContextHelper.getStringSafe(request, "selCounty");

  // Determine user access
  if ( user.hasRight( UserProfile.SEC_FIN_BROWSE_PAY_HIST ) ) {
    disablePaymentHistory = "false";
  }

  // Get the CFIN01SO output object out of the request
  CFIN21SO cfin21so = (CFIN21SO) request.getAttribute("CFIN21SO");
  double total = 0.00;
  String clientName = null;
  if ( cfin21so != null )
  {
    total = cfin21so.getDScrAmtFinPayhistTotpy();
    clientName = cfin21so.getSzNmPersonFull();
  }

  // Initialize the row and array objects
  ROWCFIN21SOG00_ARRAY paymentHistoryArray = null;
  // Null catch for cres03so, if null set to blank (initialize)
  if ( cfin21so == null )
  {
    cfin21so = new CFIN21SO();
  }
  // Null catch for ROW objects, if not null get rows
  if ( cfin21so.getROWCFIN21SOG00_ARRAY() != null )
  {
    paymentHistoryArray = cfin21so.getROWCFIN21SOG00_ARRAY();
    if (paymentHistoryArray.getUlRowQty() != 0)
    {
      hideReportBtn = false;
    }
  }
  else
  {
    paymentHistoryArray = new ROWCFIN21SOG00_ARRAY();
  }
  /* 28238817, */

      out.write("\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction submitInvoicDetail ( invoiceId )\r\n{\r\n  frmPaymentHistory.hdnTxtUlIdInvoInvoice.value = invoiceId;\r\n  submitValidateForm( \"frmPaymentHistory\", \"/financials/PymntHistorySearch/displayInvoiceDetail\" );\r\n}\r\nfunction setHiddenReportParams( invoiceId )\r\n{\r\n  frmPaymentHistory.hdnInvoiceIdReportParam.value = invoiceId;\r\n}\r\n\r\nfunction createReportParameterList()\r\n{\r\n  var bRowSelect = checkForSelection();\r\n  if( !bRowSelect )\r\n  {\r\n    setInformationalMessage( \"");
      out.print(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("\" );\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    setReportParameters( \"invoiceId\", frmPaymentHistory.hdnInvoiceIdReportParam.value );\r\n  }\r\n}\r\n\r\n// check to see if a radio button is selected for new using\r\nfunction checkForSelection()\r\n{\r\n  var x = document.frmPaymentHistoryResults;\r\n  var radioButtonChecked = false;\r\n  var bBreakOutOfLoop = false;\r\n  sTmp2 = new String(\"\");\r\n  for(var i=0; i < x.elements.length ; i++)\r\n  {\r\n    sElementName = new String(x.elements[i].name);\r\n    if( x.elements[i].type == \"radio\" && sElementName.substring(0,10) == \"rbRowIndex\")\r\n    {\r\n      bBreakOutOfLoop = true;\r\n      for(var i=0; i < x.rbRowIndex.length ; i++)\r\n      {\r\n        if(x.rbRowIndex[i].checked == true)\r\n        {\r\n          radioButtonChecked = true;\r\n          break;\r\n        }\r\n      }\r\n    }\r\n    if(bBreakOutOfLoop) break;\r\n  }\r\n\r\n  if(!bBreakOutOfLoop)\r\n  {\r\n    radioButtonChecked = true;\r\n  }\r\n  return radioButtonChecked;\r\n}\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPaymentHistory");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/PymntHistorySearch/searchPaymentHistory");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.PymntHistorySearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
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
          out.write("\r\n\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Payment History Search</th>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formInput\">&nbsp;Search For:</td>\r\n    <td colspan=\"5\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setDisabled("");
          _jspx_th_impact_validateInput_4.setLabel("Client");
          _jspx_th_impact_validateInput_4.setId("Client");
          _jspx_th_impact_validateInput_4.setName("rbUlScrFinPayhistId");
          _jspx_th_impact_validateInput_4.setValue("client");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setChecked( client );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setDisabled("");
          _jspx_th_impact_validateInput_5.setLabel("Resource");
          _jspx_th_impact_validateInput_5.setId("Resource");
          _jspx_th_impact_validateInput_5.setName("rbUlScrFinPayhistId");
          _jspx_th_impact_validateInput_5.setValue("resource");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setChecked( resource );
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setDisabled("");
          _jspx_th_impact_validateInput_6.setLabel("Contract");
          _jspx_th_impact_validateInput_6.setId("Contract");
          _jspx_th_impact_validateInput_6.setName("rbUlScrFinPayhistId");
          _jspx_th_impact_validateInput_6.setValue("contract");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setChecked( contract );
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"15%\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setWidth("17%");
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Search ID");
          _jspx_th_impact_validateInput_7.setConstraint("ID");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setName("txtUlSrcFinPayhistId");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue( searchId );
          _jspx_th_impact_validateInput_7.setDisabled( disablePaymentHistory );
          _jspx_th_impact_validateInput_7.setSize("10");
          _jspx_th_impact_validateInput_7.setMaxLength("10");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"10%\">\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setWidth("20%");
          _jspx_th_impact_validateDate_0.setLabel("From");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setName("txtDtSrcNbrFinPayhistFrom");
          _jspx_th_impact_validateDate_0.setValue( fromDate );
          _jspx_th_impact_validateDate_0.setDisabled( disablePaymentHistory );
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"10%\">\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("To");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setName("txtDtSrcDtFinPayhistTo");
          _jspx_th_impact_validateDate_1.setValue( toDate );
          _jspx_th_impact_validateDate_1.setDisabled( disablePaymentHistory );
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selRegion");
          _jspx_th_impact_validateSelect_0.setLabel("Region");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CREGIONS );
          _jspx_th_impact_validateSelect_0.setValue( region );
          _jspx_th_impact_validateSelect_0.setDisabled( disablePaymentHistory );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selCounty");
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_1.setValue( county );
          _jspx_th_impact_validateSelect_1.setDisabled( disablePaymentHistory );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\"/>\r\n  </tr>\r\n");

  if(isClientSearch && noErrorMessages){

          out.write("\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspNmClient");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Client Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString(clientName) );
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("3");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\"/>\r\n  </tr>\r\n");

  }

          out.write("\r\n</table>\r\n\r\n");
          out.write('\r');
          out.write('\n');
 if ("false".equalsIgnoreCase(disablePaymentHistory)) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmPaymentHistory");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/PymntHistorySearch/searchPaymentHistory");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setBackSafe("false");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } /* Close the if to hide search button */ 
          out.write("\r\n\r\n");
          out.write("\r\n<br/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmPaymentHistoryResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/financials/PymntHistorySearch/searchPaymentHistory");
      _jspx_th_impact_validateForm_1.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.PymntHistorySearchCustomValidation");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_1.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");

  double amount = 0.00;

if( noErrorMessages )
{

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSaveState("true");
          _jspx_th_impact_pagination_0.setSubmitUrl("/financials/PymntHistorySearch/searchPaymentHistory");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');

  // If Client Flag set in the searchPaymentHistory() is set to Y display the client section
  // else, display the Resource/Contract section
  boolean href = "false".equalsIgnoreCase(disablePaymentHistory);
  if (isClientSearch)
  {

              out.write("\r\n    <!--- Begin display for Client results --->\r\n    <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>\r\n    ");
              out.write("\r\n        <div id=\"horizontalScrollResults\" style=\"height:200px; width:762px; overflow:auto\" class=\"tableborderList\">\r\n          <table width=\"1200\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" border=\"0\">\r\n            <tr>\r\n              ");
              out.write("\r\n              <th class=\"thList\">Check Date</th>\r\n              <th class=\"thList\">Check #</th>\r\n              <th class=\"thList\">Invoice ID</th>\r\n              <th class=\"thList\">Resource Name</th>\r\n              <th class=\"thList\">County</th>\r\n              <th class=\"thList\">Svc</th>\r\n              <th class=\"thListRight\">Qty</th>\r\n              <th class=\"thListRight\">UT</th>\r\n              <th class=\"thListRight\">Amount</th>\r\n              ");
              out.write("\r\n              <th class=\"thListRight\">Rate</th>\r\n              ");
              out.write("\r\n              <th class=\"thListRight\">From</th>\r\n              <th class=\"thListRight\">To</th>\r\n             </tr>\r\n");

    Enumeration e = paymentHistoryArray.enumerateROWCFIN21SOG00();
    //Display the results if the array is not empty
    if (!e.hasMoreElements())
    {

              out.write("\r\n      <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n        <td colspan=\"12\">");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ));
              out.write("</td>\r\n      </tr>\r\n");
  }
    else
    {
      while (e.hasMoreElements())
      {
        ROWCFIN21SOG00 paymentDetail = (ROWCFIN21SOG00)e.nextElement();
        
        // Amount calculation ( ( Rate * Qty ) - Income - Fee )
        amount = (( paymentDetail.getDAmtSvcDtlUnitRate() * paymentDetail.getSNbrSvcDtlUnitQty() ) - paymentDetail.getDAmtSvcDtlIncome() - paymentDetail.getDAmtSvcDtlFeePaid() );
        invoiceId = paymentDetail.getUlIdInvoInvoice();
        //String onClickFunction =  "setHiddenReportParams('" + invoiceId + "');";

              out.write("\r\n        <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n          ");
              out.write("\r\n          ");
              out.write("\r\n          <td>");
              out.print( FormattingHelper.formatDate(paymentDetail.getDtDtInvoWarrantDate()) );
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatString(paymentDetail.getSzNbrInvoWarrant()) );
              out.write("</td>\r\n");
      if (href)
        {

              out.write("\r\n          <td><a href=\"javascript:disableValidation('frmPaymentHistoryResults'); submitInvoicDetail( '");
              out.print( invoiceId );
              out.write("')\">");
              out.print( invoiceId );
              out.write("</a></td>\r\n");
      }
        else
        {

              out.write("\r\n          <td>");
              out.print( invoiceId );
              out.write("</td>\r\n");
      }

              out.write("\r\n        <td>");
              out.print( FormattingHelper.formatString(paymentDetail.getSzNmResource()) );
              out.write("</td>\r\n        <td>");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CCOUNT, paymentDetail.getSzCdCounty()) );
              out.write("</td>\r\n        <td>");
              out.print( FormattingHelper.formatString(paymentDetail.getSzCdSvcDtlService()) );
              out.write("</td>\r\n        <td class=\"alignRight\">");
              out.print( FormattingHelper.formatDouble(paymentDetail.getSNbrSvcDtlUnitQty(), 1) );
              out.write("</td>\r\n        <td class=\"alignRight\">");
              out.print( FormattingHelper.formatString(paymentDetail.getSzCdSvcDtlUnitType()) );
              out.write("</td>\r\n        <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(amount) );
              out.write("</td>\r\n        ");
              out.write("\r\n        <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(paymentDetail.getDAmtSvcDtlUnitRate()) );
              out.write("</td>\r\n        ");
              out.write("\r\n        <td class=\"alignRight\">");
              out.print( FormattingHelper.formatInt(paymentDetail.getSNbrSvcDtlFromDay()) );
              out.write("</td>\r\n        <td class=\"alignRight\">");
              out.print( FormattingHelper.formatInt(paymentDetail.getSNbrSvcDtlToDay()) );
              out.write("</td>\r\n        </tr>\r\n");

        loopCount++;
      } /* Close the while */

              out.write("\r\n\r\n");

    } /* Close the else(there are rows) */

              out.write("\r\n           </table>\r\n         </div>\r\n       ");
              out.write("\r\n\r\n<!--- End display for Client results --->\r\n");
}
  else if ("N".equals(clientFlag))
  {

              out.write("\r\n    <!--- Begin display for Resource or Contract results --->\r\n    <div id=\"scrollBar2\" style=\"height:200px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" border=\"0\">\r\n      <tr>\r\n         ");
              out.write("\r\n         <th class=\"thList\">Check Date</th>\r\n         <th class=\"thList\">Check #</th>\r\n         <th class=\"thList\">Invoice ID</th>\r\n         <th class=\"thList\">Resource Name</th>\r\n         <th class=\"thList\">County</th>\r\n         <th class=\"thListRight\">Amount</th>\r\n         ");
              out.write("\r\n      </tr>\r\n");

    Enumeration e = paymentHistoryArray.enumerateROWCFIN21SOG00();
    //Display the results if the array is not empty
    if (!e.hasMoreElements())
    {

              out.write("\r\n      <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n        <td colspan=\"6\">");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ));
              out.write("</td>\r\n      </tr>\r\n");

    }
    else
    {
      while (e.hasMoreElements())
      {
        ROWCFIN21SOG00 paymentDetail = (ROWCFIN21SOG00)e.nextElement();
        amount = paymentDetail.getDAmtInvoValidAmount();
        invoiceId = paymentDetail.getUlIdInvoInvoice();
        //String onClickFunction =  "setHiddenReportParams('" + invoiceId + "');";

              out.write("\r\n        <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n          ");
              out.write("\r\n          <td>");
              out.print( FormattingHelper.formatDate(paymentDetail.getDtDtInvoWarrantDate()) );
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatString(paymentDetail.getSzNbrInvoWarrant()) );
              out.write("</td>\r\n");
      if (href)
        {

              out.write("\r\n          <td><a href=\"javascript:disableValidation('frmPaymentHistoryResults'); submitInvoicDetail( '");
              out.print( invoiceId );
              out.write("')\">");
              out.print( FormattingHelper.formatInt(invoiceId) );
              out.write("</a></td>\r\n");
      }
        else
        {

              out.write("\r\n           <td>");
              out.print( FormattingHelper.formatInt(invoiceId) );
              out.write("</td>\r\n");
      }

              out.write("\r\n          <td>");
              out.print( FormattingHelper.formatString(paymentDetail.getSzNmResource()) );
              out.write("</td>\r\n          <td>");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CCOUNT, paymentDetail.getSzCdCounty()) );
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(amount) );
              out.write("</td>\r\n          ");
              out.write("\r\n        </tr>\r\n");

        loopCount++;
      } /* Close the while */

              out.write("\r\n\r\n<!--- End display for Resource or Contract results --->\r\n");
  } /* Close the else (there are rows) */

              out.write("\r\n</table>\r\n</div>\r\n");

  } /* Close the else if the Client Flag == "N" */

              out.write("\r\n\r\n\r\n");

if (hideReportBtn == false)
{

              out.write("\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <td class=\"alignRight\" width=\"800\">Total Payments: </td>\r\n      <td width=\"200\">");
              out.print( FormattingHelper.formatMoney(total) );
              out.write("</td>\r\n    </tr>\r\n  </table>\r\n");

}

              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

} //SIR 13891 - moved this to not show the payments if there are errors in the
  //search

          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<!--- End Detail Table --->\r\n");
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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateErrors_0.setFormName("frmPaymentHistory");
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
    _jspx_th_impact_validateInput_1.setName("hdnInvoiceIdReportParam");
    _jspx_th_impact_validateInput_1.setValue("");
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
    _jspx_th_impact_validateInput_2.setName("hdnCReqFuncCd");
    _jspx_th_impact_validateInput_2.setValue("");
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
    _jspx_th_impact_validateInput_3.setName("hdnTxtUlIdInvoInvoice");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateErrors_1.setFormName("frmPaymentHistoryResults");
    int _jspx_eval_impact_validateErrors_1 = _jspx_th_impact_validateErrors_1.doStartTag();
    if (_jspx_th_impact_validateErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnInvoiceIdReportParam");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("hdnCReqFuncCd");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_11.setType("hidden");
    _jspx_th_impact_validateInput_11.setName("hdnTxtUlIdInvoInvoice");
    _jspx_th_impact_validateInput_11.setValue("");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
