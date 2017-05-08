package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN01SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

public final class InvoiceSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Invoice Search
//*  Created by:   Jeff Chambers
//*  Date Created: 11/13/2002
//*
//*  Description:
//*  This JSP is used to Search for Invoice Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/01/03  GRIMSHAN          SIR 17097 Moved the closing bracket around the
//**                              display list so that the add pushbutton can still
//**                              be displayed even if there are no rows returned.
//**                              Also added a condition around new using so that it
//**                              will only be displayed if there are rows returned.
//**  05/12/03  GRIMSHAN          SIR 17446 The year calculation had 1900 added to
//**                              it which is not needed.  Year should just be set
//**                              to the current calendar.getyear.
//**  08/20/03  GRIMSHAN          SIR  Chance name of selSzCdInvoType to selSzCdInvoTypeSearch
//**  02/09/04  CORLEYAN          SIR 22554 If we are in january, add 12 to the month value so that
//**                              12 of last year will display on the page.
//**  11/02/07  IMOMIO            STGAP00006231 enhancement to invoice search results including the client name
//**  04/08/2009 bgehlot          STGAP00013273 : Added new input field Client Person ID on the page, Removed conditionally
//**                              required from Month field, Added UAS Codes. Added function setDefaultMonthYearADSRCS
//**  05/26/2009 bgehlot          STGAP00013906: Month field can have empty string 
//**  05/28/2009 bgehlot          STGAP00013940: Region and year field can have empty string when Cliend Id is enetered

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  UserProfile user = UserProfileHelper.getUserProfile( request );

  Calendar cal = new GregorianCalendar();
  cal.setTime( new java.util.Date() );

  //  Declare variables
  int tabIndex = 1;
  int loopCount = 0;
  boolean disableInvoice = true;
  String invoiceId = ContextHelper.getStringSafe(request, "txtUlIdInvoInvoice");
  String contractId = ContextHelper.getStringSafe(request, "txtUlIdContract");
  String resourceId = ContextHelper.getStringSafe(request, "txtUlIdResource");
  
  //STGAP00013273 : Added this new input field on the page
  String idClientPerson = ContextHelper.getStringSafe(request, "txtUlIdClientPerson");
  
  //STGAP00013906: Month field can have empty string
  String indSearch = "false";
  indSearch = (String) request.getAttribute( "indSearch" );
  
  String type = ContextHelper.getStringSafe(request, "selSzCdInvoTypeSearch");
  if("".equals(type)){
    type = "ALL";
  }
  String phase = ContextHelper.getStringSafe(request, "selSzCdInvoPhase");
  if("".equals(phase)){
    phase = "ALL";
  }
  String region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  if("".equals(region)){
    region = FormattingHelper.convertRegionCode(user.getUserRegion());
  }
  
  //STGAP00013940 : Region field can have empty string when Cliend Id is enetered
  if("".equals(ContextHelper.getStringSafe(request, "selSzCdCntrctRegion")) && "true".equals(indSearch)){
    region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  }
  
  String invoiceMonth = "";
  String invoiceYear = "";
  String county = ContextHelper.getStringSafe(request, "selCounty");
  //if("".equals(county)){
  //  county = user.getUserCounty();
  //}
  String defaultButton = "false";

  // Set to current year unless month is January, then set to Year - 1
  int month = cal.get( Calendar.MONTH );
  int year = cal.get( Calendar.YEAR );
  //STGAP00013273 : If invoice type is selected as either Adoption Assistance or Relative Care Subsidy 
  //                then the month and year defaults to current month and year. For all other invoice type 
  //                selections the month defaults to prior month and the year defaults to the year the prior 
  //                month falls under
  
   if(CodesTables.CINVSRTP_ADS.equals(type) || CodesTables.CINVSRTP_RCS.equals(type)){
    invoiceMonth = String.valueOf( month + 1 );
    invoiceYear = String.valueOf( year );
   }else{
      // We need to display the previous month from the month we are in
      // If Month is 0, then it is january.  We want to print out
      // December of last year.  Else print out the value of month.
      // Even though we want to display the previous month, the value of
      // month will be one less than the month we are in since the Calendar
      // class calculates based on January being the 0th month.
      if ( month == 0 )
      {
        invoiceMonth = String.valueOf( month + 12 );
        //SIR 17446 Remove year + 1900
        invoiceYear = String.valueOf( year - 1 );
      }
      else
      {
        invoiceMonth = String.valueOf( month );
        //SIR 17446 Remove year + 1900
        invoiceYear = String.valueOf( year );
      }
   }

   //STGAP00013906: Month field can have empty string
  if("".equals(ContextHelper.getStringSafe(request, "txtUMoInvoMonth")) && "true".equals(indSearch)){
    invoiceMonth = ContextHelper.getStringSafe(request, "txtUMoInvoMonth");
  }
  if(!"".equals(ContextHelper.getStringSafe(request, "txtUMoInvoMonth"))){
    invoiceMonth = ContextHelper.getStringSafe(request, "txtUMoInvoMonth");
  }
  
    
  //STGAP00013940 : Year field can have empty string when Cliend Id is enetered
  if("".equals(ContextHelper.getStringSafe(request, "txtUYrInvoYear")) && "true".equals(indSearch)){
    invoiceYear = ContextHelper.getStringSafe(request, "txtUYrInvoYear");
  }
  
  if(!"".equals(ContextHelper.getStringSafe(request, "txtUYrInvoYear"))){
    invoiceYear = ContextHelper.getStringSafe(request, "txtUYrInvoYear");
  }

  // Determine user access
  if ( user.hasRight( UserProfile.SEC_FIN_BROWSE_INVOICE ) || ( user.hasRight( UserProfile.SEC_FIN_MODIFY_INVOICE) )) {
    disableInvoice = false;
  }

  // If search performed is still null, set the default button to true
  if ( request.getAttribute( "SearchPerformed" ) == null)
  {
    defaultButton = "true";
  }
  else
  {
    defaultButton = "false";
  }


      out.write("\r\n\r\n");

  // Get the CFIN01SO output object out of the request
  CFIN01SO cfin01so = (CFIN01SO) request.getAttribute("CFIN01SO");

  // Initialize the row and array objects
  ROWCFIN01SOG00_ARRAY invoiceArray = null;
  // Null catch for cres03so, if null set to blank (initialize)
  if ( cfin01so == null )
  {
    cfin01so = new CFIN01SO();
  }
  // Null catch for ROW objects, if not null get rows
  if ( cfin01so.getROWCFIN01SOG00_ARRAY() != null )
  {
    invoiceArray = cfin01so.getROWCFIN01SOG00_ARRAY();
  } else {
    invoiceArray = new ROWCFIN01SOG00_ARRAY();
  }

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n\r\n  function submitInvoiceSearch(invoiceId)\r\n  {\r\n    document.frmInvoiceSearch.hdnTxtUlIdInvoInvoice.value = invoiceId;\r\n    submitValidateForm( \"frmInvoiceSearch\", \"/financials/InvoiceSearch/displayInvoiceDetail\" );\r\n  }\r\n\r\n  function addInvoice()\r\n  {\r\n    frmInvoiceSearchResults.hdnCReqFuncCd.value = \"");
      out.print( ServiceConstants.REQ_FUNC_CD_ADD );
      out.write("\";\r\n  }\r\n\r\n  function newUsing()\r\n  {\r\n    var bChecked = false;\r\n    var rs = ");
      out.print( invoiceArray.getROWCFIN01SOG00Count() );
      out.write(";\r\n\r\n      if ( rs <= 1 )\r\n      {\r\n        if ( frmInvoiceSearchResults.rbRowsIndex.checked == false )\r\n        {\r\n          alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n        }\r\n        else\r\n        {\r\n          bChecked = true;\r\n        }\r\n\r\n      } else {\r\n\r\n        for ( var i = 0; i < rs; i++ )\r\n        {\r\n          if (frmInvoiceSearchResults.rbRowsIndex[i].checked)\r\n          {\r\n             bChecked = true;\r\n          }\r\n        }\r\n\r\n        if ( bChecked == false )\r\n        {\r\n          alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n        }\r\n      }\r\n      return bChecked;\r\n  }\r\n\r\n  function setArrayIndex(contractId)\r\n  {\r\n    frmInvoiceSearch.hdnUlIdContract.value = contractId;\r\n  }\r\n  \r\n  \r\n  //STGAP00013273 : If invoice type is selected as either Adoption Assistance or Relative Care Subsidy \r\n  //                then the month and year defaults to current month and year. For all other invoice type \r\n  //                selections the month defaults to prior month and the year defaults to the year the prior \r\n  //                month falls under\r\n  function setDefaultMonthYearADSRCS()\r\n  {\r\n    if(frmInvoiceSearch.selSzCdInvoTypeSearch.value == 'ADS' || frmInvoiceSearch.selSzCdInvoTypeSearch.value == 'RCS'){\r\n           frmInvoiceSearch.txtUMoInvoMonth.value = ");
      out.print(String.valueOf( month + 1 ));
      out.write("; \r\n           frmInvoiceSearch.txtUYrInvoYear.value = ");
      out.print(String.valueOf( year ));
      out.write(";\r\n    }else{\r\n        ");
if ( month == 0 )
        {
      out.write("\r\n          frmInvoiceSearch.txtUMoInvoMonth.value = ");
      out.print(String.valueOf( month + 12 ));
      out.write("; \r\n          frmInvoiceSearch.txtUYrInvoYear.value = ");
      out.print(String.valueOf( year - 1 ));
      out.write(";\r\n       ");
 }
        else
        {
      out.write("\r\n           frmInvoiceSearch.txtUMoInvoMonth.value = ");
      out.print(String.valueOf( month ));
      out.write("; \r\n           frmInvoiceSearch.txtUYrInvoYear.value = ");
      out.print(String.valueOf( year ));
      out.write(";\r\n        ");
}
      out.write("\r\n    }\r\n  }\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmInvoiceSearch");
      _jspx_th_impact_validateForm_0.setDefaultButton(defaultButton);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/InvoiceSearch/searchInvoiceSearch");
      _jspx_th_impact_validateForm_0.setPageMode( PageMode.getPageMode( request ) );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceSearchCustomValidation");
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
          out.write("\r\n\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Invoice Search</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Invoice ID");
          _jspx_th_impact_validateInput_4.setConstraint("ID");
          _jspx_th_impact_validateInput_4.setName("txtUlIdInvoInvoice");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( invoiceId );
          _jspx_th_impact_validateInput_4.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateInput_4.setSize("10");
          _jspx_th_impact_validateInput_4.setMaxLength("10");
          _jspx_th_impact_validateInput_4.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Contract ID");
          _jspx_th_impact_validateInput_5.setConstraint("ID");
          _jspx_th_impact_validateInput_5.setRequired("false");
          _jspx_th_impact_validateInput_5.setName("txtUlIdContract");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue( contractId );
          _jspx_th_impact_validateInput_5.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateInput_5.setSize("10");
          _jspx_th_impact_validateInput_5.setMaxLength("10");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Resource ID");
          _jspx_th_impact_validateInput_6.setConstraint("ID");
          _jspx_th_impact_validateInput_6.setRequired("false");
          _jspx_th_impact_validateInput_6.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_6.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setValue( resourceId );
          _jspx_th_impact_validateInput_6.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateInput_6.setSize("10");
          _jspx_th_impact_validateInput_6.setMaxLength("10");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setName("selSzCdInvoTypeSearch");
          _jspx_th_impact_validateSelect_0.setBlankValue("false");
          _jspx_th_impact_validateSelect_0.setCodesTable("CINVSRTP");
          _jspx_th_impact_validateSelect_0.setContentType( SelectTag.DECODES );
          _jspx_th_impact_validateSelect_0.setValue( type );
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setOnChange("setDefaultMonthYearADSRCS();");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Phase");
          _jspx_th_impact_validateSelect_1.setRequired("false");
          _jspx_th_impact_validateSelect_1.setName("selSzCdInvoPhase");
          _jspx_th_impact_validateSelect_1.setCodesTable("CINVSRCH");
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.DECODES );
          _jspx_th_impact_validateSelect_1.setValue( phase );
          _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
          out.write("\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Region");
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setName("selSzCdCntrctRegion");
          _jspx_th_impact_validateSelect_2.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_2.setContentType( SelectTag.DECODES );
          _jspx_th_impact_validateSelect_2.setValue( region );
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setOptions( user.getUserMaintainedRegionsAsOptions(true) );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Invoice Month");
          _jspx_th_impact_validateInput_7.setConstraint("MonthNumber");
          _jspx_th_impact_validateInput_7.setName("txtUMoInvoMonth");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue( invoiceMonth );
          _jspx_th_impact_validateInput_7.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateInput_7.setSize("3");
          _jspx_th_impact_validateInput_7.setMaxLength("2");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setLabel("Invoice Year");
          _jspx_th_impact_validateInput_8.setConstraint("Year");
          _jspx_th_impact_validateInput_8.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_8.setName("txtUYrInvoYear");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setValue( invoiceYear );
          _jspx_th_impact_validateInput_8.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateInput_8.setSize("5");
          _jspx_th_impact_validateInput_8.setMaxLength("4");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("County");
          _jspx_th_impact_validateSelect_3.setName("selCounty");
          _jspx_th_impact_validateSelect_3.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_3.setValue( county );
          _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("Client Person ID");
          _jspx_th_impact_validateInput_9.setConstraint("ID");
          _jspx_th_impact_validateInput_9.setName("txtUlIdClientPerson");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setValue( idClientPerson );
          _jspx_th_impact_validateInput_9.setDisabled( String.valueOf(disableInvoice) );
          _jspx_th_impact_validateInput_9.setSize("10");
          _jspx_th_impact_validateInput_9.setMaxLength("10");
          _jspx_th_impact_validateInput_9.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
          out.write('\r');
          out.write('\n');
 if (!disableInvoice) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmInvoiceSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/InvoiceSearch/searchInvoiceSearch");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setBackSafe("false");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } // Close the if to hide search button 
          out.write("\r\n\r\n");
          out.write("\r\n<br/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");

  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmInvoiceSearchResults");
      _jspx_th_impact_validateForm_1.setDefaultButton(defaultButton);
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/financials/InvoiceSearch/searchInvoiceSearch");
      _jspx_th_impact_validateForm_1.setPageMode( PageMode.getPageMode( request ) );
      _jspx_th_impact_validateForm_1.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceSearchCustomValidation");
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_13(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSaveState("true");
          _jspx_th_impact_pagination_0.setSubmitUrl("/financials/InvoiceSearch/searchInvoiceSearch");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n\r\n<!--- This is a way to use to styles.  The first one aligns right and the second formatts the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --->\r\n<div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>\r\n  <div id=\"horizontalScrollResults\" style=\"width:764px; height:300px; overflow:auto\" class=\"tableborderList\">\r\n   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n         <td class=\"tableBG\">\r\n        <!-- div id=\"horizontalScrollResults\" style=\"height:300px; width:764px; overflow:auto\" class=\"tableborderList\" -->\r\n           <table width=\"1200\" cellspacing=\"0\" cellpadding=\"3\">\r\n             <tr>\r\n               <th class=\"thList\">&nbsp;</th>\r\n               <th class=\"thList\">Invoice ID</th>\r\n               <th class=\"thList\">Type</th>\r\n               <th class=\"thList\">Client Name</th>\r\n               <th class=\"thList\">Submitted Date</th>\r\n               <th class=\"thList\">UAS Codes</th>\r\n");
              out.write("               <th class=\"thList\">Contract ID</th>\r\n               <th class=\"thList\">Phase</th>\r\n               <th class=\"thList\">Validated Amount</th>\r\n               <th class=\"thList\">Resource Name</th>\r\n               <th class=\"thList\">Resource ID</th>\r\n               <th class=\"thList\">Region</th>\r\n              </tr>\r\n");

  Enumeration e = invoiceArray.enumerateROWCFIN01SOG00();
  boolean hasRows = false;
  //Display the results if the array is not empty
  if (!e.hasMoreElements())
  {
    //hasRows = false;
    
              out.write("\r\n              <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                <td colspan=\"10\">");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ));
              out.write("</td>\r\n              </tr>\r\n  ");

  } else {
  boolean checked = false;
  while (e.hasMoreElements()) {
  ROWCFIN01SOG00 invoiceDetail = (ROWCFIN01SOG00)e.nextElement();
  String onClick = "setArrayIndex( '" + invoiceDetail.getUlIdContract() + "')";
  hasRows = true;
  String idInvoice = FormattingHelper.formatInt(invoiceDetail.getUlIdInvoInvoice());

              out.write("\r\n\r\n                 <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                    <td width=\"2%\">\r\n                        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_14.setType("radio");
              _jspx_th_impact_validateInput_14.setName("rbRowsIndex");
              _jspx_th_impact_validateInput_14.setChecked( String.valueOf(checked) );
              _jspx_th_impact_validateInput_14.setValue( String.valueOf( loopCount ));
              _jspx_th_impact_validateInput_14.setOnClick( onClick );
              _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    </td>\r\n                    <!-- td -->\r\n                    ");
 //-- Consider this redundant security since a user should not even be able to
                       //-- access this page unless the user has the proper financial security attributes;
                       //-- even if they access the page improperly, the Search button will not display
                       //-- without proper security and thus this section would not exist on the page.
                       if (!disableInvoice) { 
              out.write("\r\n                    <td><a href=\"javascript:submitInvoiceSearch( '");
              out.print( idInvoice );
              out.write("' )\">");
              out.print( idInvoice );
              out.write("</a></td>\r\n                    ");
 } else { 
              out.write("\r\n                    <td>");
              out.print( idInvoice );
              out.write("</td>\r\n                    ");
 } 
              out.write("\r\n                    <td>");
              out.print( Lookup.simpleDecodeSafe("CINVTYPE", invoiceDetail.getSzCdInvoType()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatString(invoiceDetail.getSzNmPersonFull()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatDate(invoiceDetail.getDtDtInvoSubmitDate()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatString(invoiceDetail.getSzTxtUASCodes()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatInt(invoiceDetail.getUlIdContract()) );
              out.write("</td>\r\n                    <td>");
              out.print( Lookup.simpleDecodeSafe("CINVPHSE", invoiceDetail.getSzCdInvoPhase()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatMoney(invoiceDetail.getDAmtInvoValidAmount()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatString(invoiceDetail.getSzNmResource()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatInt(invoiceDetail.getUlIdResource()) );
              out.write("</td>\r\n                    <td>");
              out.print( FormattingHelper.formatString(invoiceDetail.getSzCdCntrctRegion()) );
              out.write("</td>\r\n                  </tr>\r\n");
 loopCount++; 
              out.write('\r');
              out.write('\n');
 } /* Close the while */ 
              out.write("\r\n\r\n");
 /* GRIMSHAN SIR 6375 moved the close of display results section above the buttons, so that
      even when no rows are returned the add pushbutton will be displayed
   */
  } /* Close the else to display result section */
              out.write("\r\n               </table>\r\n       </td>\r\n      </tr>\r\n   </table>\r\n   </div>\r\n");
 if ( user.hasRight( UserProfile.SEC_FIN_MODIFY_INVOICE) ) { 
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n\r\n  ");
 /* GRIMSHAN SIR 17097 only display new using if rows were returned from the search */
     if (hasRows)
    {
              out.write("\r\n    <td width=\"90%\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ButtonTag_1.setName("btnNewUsing");
              _jspx_th_impact_ButtonTag_1.setImg("btnNewUsing");
              _jspx_th_impact_ButtonTag_1.setAlign("right");
              _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmInvoiceSearchResults'); return newUsing();");
              _jspx_th_impact_ButtonTag_1.setForm("frmInvoiceSearchResults");
              _jspx_th_impact_ButtonTag_1.setAction("/financials/InvoiceSearch/newUsing");
              _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  ");
 } 
              out.write("\r\n    <td width=\"10%\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ButtonTag_2.setName("btnAdd");
              _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_2.setAlign("right");
              _jspx_th_impact_ButtonTag_2.setFunction("disableValidation('frmInvoiceSearchResults'); addInvoice()");
              _jspx_th_impact_ButtonTag_2.setForm("frmInvoiceSearchResults");
              _jspx_th_impact_ButtonTag_2.setAction("/financials/InvoiceSearch/addInvoice");
              _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } /* Close the if to display the add button */ 
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
 } /* Close the if to display results section */ 
      out.write("\r\n\r\n\r\n<!--- End Detail Table --->\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmInvoiceSearch");
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
    _jspx_th_impact_validateInput_1.setName("hdnTxtUlIdInvoInvoice");
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
    _jspx_th_impact_validateInput_3.setName("hdnUlIdContract");
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
    _jspx_th_impact_validateErrors_1.setFormName("frmInvoiceSearchResults");
    int _jspx_eval_impact_validateErrors_1 = _jspx_th_impact_validateErrors_1.doStartTag();
    if (_jspx_th_impact_validateErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("hdnCReqFuncCd");
    _jspx_th_impact_validateInput_12.setValue("");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_13.setType("hidden");
    _jspx_th_impact_validateInput_13.setName("hdnUlIdContract");
    _jspx_th_impact_validateInput_13.setValue("");
    int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
    if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
