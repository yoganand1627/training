package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.financials.PaymentApprovalConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

public final class PaymentApproval_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*
//*  JSP Name:     Payment Approval
//*  Created by:   Katy Laura
//*  Date Created: 02/28/03
//*
//*  Description:
//*  This JSP displays invoice information depending on the user's security attributes
//*  and region access
//*
//*  Change History:
//*  Date      User         SIR        Description
//*  --------  ----------    -------   -------------------------------------------
//*  5/4/2004   gerryc        15533      added sort capabilites to the approval status
//*                                    resource name, and contract id columns.
//*                                    Also used a new style - thListNoWrap to
//*                                   prevent wrapping of the sort arrow.
//*  5/22/2008  vdevarak  STGAP00004617  Added the Search criteria section to the page as per MR-012.

//*  04/08/2009 bgehlot   STGAP00013273 : Added new input field Client Person ID on the page, Removed conditionally
//*                                       required from Month field, Added UAS Codes, Added function setDefaultMonthYearADSRCS
//*  05/26/2009 bgehlot          STGAP00013906: Month field can have empty string    
//** 05/28/2009 bgehlot          STGAP00013940: Region and year field can have empty string when Cliend Id is enetered                              
//*

      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //Set the page mode
  String pageMode = PageModeConstants.MODIFY;
  //STGAP00004617: Added code to enable Search functionality
  //Begin
  UserProfile user = UserProfileHelper.getUserProfile(request);
  Calendar cal = new GregorianCalendar();
  cal.setTime( new java.util.Date() );
  String contractId = ContextHelper.getStringSafe(request, "txtUlIdContract");
  String resourceId = ContextHelper.getStringSafe(request, "txtUlIdResource");
  String type = ContextHelper.getStringSafe(request, "selSzCdInvoTypeSearch");
  
  //STGAP00013273 : Added this new input field on the page
  String idClientPerson = ContextHelper.getStringSafe(request, "txtUlIdClientPerson");
  
  //STGAP00013906: Month field can have empty string
  String indSearch = "false";
  indSearch = (String) request.getAttribute( "indSearch" );
   
  if("".equals(type)){
    type = "ALL";
  }																	
  String approvalStatus = ContextHelper.getStringSafe(request, "selSzCdInvoAprvStatus");
  String region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  if("".equals(region)){
    region = FormattingHelper.convertRegionCode(user.getUserRegion());
  }
  
  //STGAP00013940 : Region field can have empty string when Cliend Id is enetered
  if("".equals(ContextHelper.getStringSafe(request, "selSzCdCntrctRegion")) && "true".equals(indSearch)){
    region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  }
  
  String county = ContextHelper.getStringSafe(request, "selSzCdInvoCounty");
  String invoiceMonth = "";
  String invoiceYear = "";
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
  
  // STGAP00013906: Empty string should also display
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
  //end STGAP00004617
  boolean securityClearance = user.hasRight(UserProfile.SEC_FIN_MODIFY_CPS_PAY_APPVL) &&
                              request.getAttribute(PaymentApprovalConversation.REGION_SECURITY_VIOLATION) == null;
  
     // create the output object
   CFIN19SO cfin19so = ( CFIN19SO ) state.getAttribute( "CFIN19SO", request );
    //initialize the array
   ROWCFIN19SOG_ARRAY paymentApprovalArray = null;
    //null catch
   if ( cfin19so == null )
   {
     cfin19so = new CFIN19SO() ;
   }
    //null catch for row objects, if not null, get rows
   if ( cfin19so.getROWCFIN19SOG_ARRAY() != null )
   {
     paymentApprovalArray = cfin19so.getROWCFIN19SOG_ARRAY();
   }
   else
   {
     paymentApprovalArray = new ROWCFIN19SOG_ARRAY();
   }

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  // QA sweep   int idInvc = 0;

      out.write("\r\n\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n     // tell the Invoice page the pageMode is view for approved or disapproved invoices\r\n function passPageModeIdInvoice( cdInvoApproved, idInvoice )\r\n      {\r\n       frmPaymentApproval.hdnCdInvoApproved.value = cdInvoApproved;\r\n       frmPaymentApproval.hdnIdInvoice.value = idInvoice;\r\n        submitValidateForm('frmPaymentApproval', '/financials/PaymentApproval/setValuesForInvoice');\r\n     }  \r\n     \r\n  //STGAP00013273 : If invoice type is selected as either Adoption Assistance or Relative Care Subsidy \r\n  //                then the month and year defaults to current month and year. For all other invoice type \r\n  //                selections the month defaults to prior month and the year defaults to the year the prior \r\n  //                month falls under\r\n  function setDefaultMonthYearADSRCS()\r\n  {\r\n    if(frmPaymentApproval.selSzCdInvoTypeSearch.value == 'ADS' || frmPaymentApproval.selSzCdInvoTypeSearch.value == 'RCS'){\r\n");
      out.write("           frmPaymentApproval.txtUMoInvoMonth.value = ");
      out.print(String.valueOf( month + 1 ));
      out.write("; \r\n           frmPaymentApproval.txtUYrInvoYear.value = ");
      out.print(String.valueOf( year ));
      out.write(";\r\n    }else{\r\n        ");
if ( month == 0 )
        {
      out.write("\r\n          frmPaymentApproval.txtUMoInvoMonth.value = ");
      out.print(String.valueOf( month + 12 ));
      out.write("; \r\n          frmPaymentApproval.txtUYrInvoYear.value = ");
      out.print(String.valueOf( year - 1 ));
      out.write(";\r\n       ");
 }
        else
        {
      out.write("\r\n           frmPaymentApproval.txtUMoInvoMonth.value = ");
      out.print(String.valueOf( month ));
      out.write("; \r\n           frmPaymentApproval.txtUYrInvoYear.value = ");
      out.print(String.valueOf( year ));
      out.write(";\r\n        ");
}
      out.write("\r\n    }\r\n  }\r\n\r\n//End Java Script-->\r\n</script> \r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPaymentApproval");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/PaymentApproval/searchPaymentApprovals");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.PaymentApprovalCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( securityClearance ? PageModeConstants.MODIFY : PageModeConstants.VIEW );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n<!--- STGAP00004617  Added the Search criteria section - Begin --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Payment Approval</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("Contract ID");
          _jspx_th_impact_validateInput_0.setConstraint("ID");
          _jspx_th_impact_validateInput_0.setRequired("false");
          _jspx_th_impact_validateInput_0.setName("txtUlIdContract");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setValue( contractId );
          _jspx_th_impact_validateInput_0.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateInput_0.setSize("10");
          _jspx_th_impact_validateInput_0.setMaxLength("10");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("Resource ID");
          _jspx_th_impact_validateInput_1.setConstraint("ID");
          _jspx_th_impact_validateInput_1.setRequired("false");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_1.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setValue( resourceId );
          _jspx_th_impact_validateInput_1.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateInput_1.setSize("10");
          _jspx_th_impact_validateInput_1.setMaxLength("10");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Client Person ID");
          _jspx_th_impact_validateInput_2.setConstraint("ID");
          _jspx_th_impact_validateInput_2.setName("txtUlIdClientPerson");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setValue( idClientPerson );
          _jspx_th_impact_validateInput_2.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateInput_2.setSize("10");
          _jspx_th_impact_validateInput_2.setMaxLength("10");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setOnChange("setDefaultMonthYearADSRCS();");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Approval Status");
          _jspx_th_impact_validateSelect_1.setRequired("false");
          _jspx_th_impact_validateSelect_1.setName("selSzCdInvoAprvStatus");
          _jspx_th_impact_validateSelect_1.setCodesTable("CINVOAPV");
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.DECODES );
          _jspx_th_impact_validateSelect_1.setValue( approvalStatus );
          _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf(!securityClearance) );
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
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setOptions( user.getUserMaintainedRegionsAsOptions(true) );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Invoice Month");
          _jspx_th_impact_validateInput_3.setConstraint("MonthNumber");
          _jspx_th_impact_validateInput_3.setName("txtUMoInvoMonth");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setValue( invoiceMonth );
          _jspx_th_impact_validateInput_3.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateInput_3.setSize("3");
          _jspx_th_impact_validateInput_3.setMaxLength("2");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Invoice Year");
          _jspx_th_impact_validateInput_4.setConstraint("Year");
          _jspx_th_impact_validateInput_4.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_4.setName("txtUYrInvoYear");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( invoiceYear );
          _jspx_th_impact_validateInput_4.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateInput_4.setSize("5");
          _jspx_th_impact_validateInput_4.setMaxLength("4");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("County");
          _jspx_th_impact_validateSelect_3.setName("selSzCdInvoCounty");
          _jspx_th_impact_validateSelect_3.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_3.setValue( county );
          _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf(!securityClearance) );
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
          out.write('\r');
          out.write('\n');
 if (securityClearance) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmPaymentApproval");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/PaymentApproval/searchPaymentApprovals");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setBackSafe("false");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } // Close the if to hide search button 
          out.write("\r\n<!--- STGAP00004617  Added the Search criteria section - End--->\r\n");
          out.write("\r\n<br/>\r\n\r\n");

  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {

          out.write('\r');
          out.write('\n');
 if(securityClearance) { 
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/financials/PaymentApproval/searchPaymentApprovals");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>\r\n<div id=\"scrollBar\" style=\"height:275;width:762px;overflow:auto\" class=\"tableborderList\">\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"1000\" >\r\n         <tr>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\">A</th>\r\n             <th class=\"thList\">Invoice ID</th>\r\n             <th class=\"thList\">Client Name</th>\r\n             <th class=\"thList\">Resource Name</th>\r\n             <th class=\"thList\">UAS Codes</th>\r\n             <th class=\"thList\">Validated Amount </th>\r\n             <th class=\"thList\">Phase </th>\r\n             <th class=\"thList\">Resource ID </th>\r\n             <th class=\"thList\">Received Date </th>\r\n             <th class=\"thList\">Approval Date </th>\r\n             <th class=\"thList\">Contract ID</th>\r\n             <th class=\"thList\">Person ID</th>\r\n         </tr>\r\n                  ");
 // within the table, display the data
                    //Enumerate the payment approval rows
              Enumeration paymentApprovalEnum = paymentApprovalArray.enumerateROWCFIN19SOG();//ROWCFIN19SOG_ARRAY(); //ROWCFIN19SOG;  //ROWCFIN19SOG_ARRAY

            //If the enumeration is empty return NO Rows returned message
          if ( !paymentApprovalEnum.hasMoreElements() )
             { 
              out.write("\r\n              <tr class=\"odd\">\r\n                 <td colspan=\"10\">");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("</td>\r\n              </tr>\r\n               ");

             }  // else there is a least one row.  While there are more rows, create a new rows and display the data
          else
             {
               while( paymentApprovalEnum.hasMoreElements() )
                  {     // get the next element
                     ROWCFIN19SOG paymentApprovalRow = ( ROWCFIN19SOG ) paymentApprovalEnum.nextElement();
                        // create the cells and place the elements in them
                 
              out.write("\r\n         <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"middle\">\r\n           <td>\r\n");

         // write an if to display the check box if the type of row is other than RJA
         // define a boolean to protect RJA rows from approval, disapproval and reset functions
           boolean bTheRowCanBeDeleted = true;
         // set theRowCanBeDeleted to false if the row type is RJA
           if ("RJA".equals(paymentApprovalRow.getSzCdInvoApproved()) )
                { bTheRowCanBeDeleted = false; }
           if ( bTheRowCanBeDeleted )
              {   // if the row can be deleted place a checkbox on the screen
            String chckBoxName = "ckName_CLEAN" + loopCount ;

              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_5.setValue( String.valueOf( loopCount ));
              _jspx_th_impact_validateInput_5.setType("checkbox");
              _jspx_th_impact_validateInput_5.setChecked("false");
              _jspx_th_impact_validateInput_5.setName( chckBoxName );
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');

              }  // end if

              out.write("\r\n           </td>\r\n           <td>");
              out.print( FormattingHelper.formatString(paymentApprovalRow.getSzCdInvoApproved()));
              out.write("</td>\r\n           <td>\r\n             <a href=\"#\" onClick=\"passPageModeIdInvoice('");
              out.print( paymentApprovalRow.getSzCdInvoApproved());
              out.write("', '");
              out.print( FormattingHelper.formatInt(paymentApprovalRow.getUlIdInvoInvoice()));
              out.write("')\">\r\n               ");
              out.print( FormattingHelper.formatInt( paymentApprovalRow.getUlIdInvoInvoice() ));
              out.write("\r\n             </a>\r\n           </td>\r\n           <td>");
              out.print( FormattingHelper.formatString(paymentApprovalRow.getSzNmPersonFull()) );
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatString( paymentApprovalRow.getSzNmResource() ));
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatString( paymentApprovalRow.getSzTxtUASCodes()));
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatMoney( paymentApprovalRow.getDAmtInvoValidAmount() ));
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatString( paymentApprovalRow.getSzCdInvoPhase() ));
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatInt(paymentApprovalRow.getUlIdResource()) );
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatDate( paymentApprovalRow.getDtDtInvoReceivedDate() ));
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatDate( paymentApprovalRow.getDtDtInvoApprovalDate() ));
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatInt( paymentApprovalRow.getUlIdContract() ));
              out.write("</td>\r\n           <td>");
              out.print( FormattingHelper.formatInt( paymentApprovalRow.getUlIdPerson() ));
              out.write("</td>\r\n         </tr>\r\n         ");
// increment the loop counter
               loopCount++;
             } // end while
           } //end else, end if
          
              out.write("\r\n     </table>  ");
 /* end the table used to display the data returned from the service */ 
              out.write("\r\n  </div>");
 /* this is where the "scrollBar" div tag ends */ 
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n<br/>\r\n");
  // place the add and delete buttons within a table to control alignment
 
          out.write("\r\n <table border=\"0\" cellpadding=\"3\" class=\"tableNoBorder\" width=\"100%\" >\r\n    <tr>\r\n       <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnApprove");
          _jspx_th_impact_ButtonTag_1.setImg("btnApprove");
          _jspx_th_impact_ButtonTag_1.setForm("frmPaymentApproval");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/PaymentApproval/approve");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnDisapprove");
          _jspx_th_impact_ButtonTag_2.setImg("btnDisapprove");
          _jspx_th_impact_ButtonTag_2.setForm("frmPaymentApproval");
          _jspx_th_impact_ButtonTag_2.setAction("/financials/PaymentApproval/disapprove");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnReset");
          _jspx_th_impact_ButtonTag_3.setImg("btnReset");
          _jspx_th_impact_ButtonTag_3.setForm("frmPaymentApproval");
          _jspx_th_impact_ButtonTag_3.setAction("/financials/PaymentApproval/reset");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n    </tr>\r\n   </table>\r\n");
 } 
}
          out.write("\r\n\r\n     ");
          out.write("\r\n   ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n   ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          out.write("\r\n    <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnCdInvoApproved");
    _jspx_th_impact_validateInput_6.setValue("");
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
    _jspx_th_impact_validateInput_7.setName("hdnIdInvoice");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
