package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.financials.ContractsConversation;

public final class ContractServiceDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*   JSP Name:     ContractServiceDetail.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 02/15/2003
//*
//*   The Contract Service List window will allow contract managers
//*   and technicians to view, add, and modify service data for a
//*   specific contract version. Only counties that are available to be
//*   contracted will be displayed.
//*
//*
//**  Change History:
//**  Date        User              Description
//**  --------    --------------    --------------------------------------------------
//**  02/15/2003  Eric Dickman      Created initial docuement.
//**
//**  05/27/2003  Eric Dickman      SIR 17750 -- Added the following logic to the Select
//**                                and Deselect push button if statement.  Check to see if the
//**                                Version is Locked or Unlocked.
//**
//**  05/29/2003  Eric Dickman      Added a new page state for unsigned and unlocked
//**                                NOT NEW MODE.
//**
//**  06/01/2003  Eric Dickman      SIR 17740 -- The Unit Rate is protected when the
//**                                Payment Type is Cost Reimbursement.  Added this functionality
//**                                to the onChangePaymentType JavaScript Function
//**
//**  06/03/2003  Eric Dickman      SIR 17739 -- If payment type is equal to Cost Reimb,
//**                                the Unit Rate Widget will be disabled.  The user can also
//**                                save and not get the "Field is required. Please  enter
//**                                a value." message.
//**
//**  12/29/2009  vdevarak          SMS#39513: Increased the length of the rate field from 9 to 10
//**  10/16/2010  charden			STGAP00017058: making page editable for fiscal ops users
//**

      out.write("\r\n\r\n\r\n\r\n");
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

    BaseSessionStateManager state = ContractsConversation.getSessionStateManager(request);

    CCON13SI ccon13si = (CCON13SI) request.getAttribute("CCON13SI");
    CCON13SO ccon13so = (CCON13SO) state.getAttribute("CCON13SO", request );
    ROWCCON11SOG00 contractDetailRow = (ROWCCON11SOG00)request.getAttribute("ROWCCON11SOG00");

    if (contractDetailRow == null)
    {
       contractDetailRow = new ROWCCON11SOG00();
       int lineNumber = (Integer) request.getAttribute("csliAdd");
       contractDetailRow.setUlNbrCnsvcLineItem(lineNumber);
    }
    //get hidden variables out of the request
    int resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource");

    org.exolab.castor.types.Date countyEffective =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEffective"));

    org.exolab.castor.types.Date countyEnd =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEnd"));

    String service = (contractDetailRow.getSzCdCnsvcService());

    String dataAction = (String) request.getAttribute("szCdScrDataAction");
    String countyList = (String) request.getAttribute("countyList");

    String contractBudgetLimit = ContextHelper.getStringSafe(request, "hdnContractBudgetLimit");
    String contractFunctionType = ContextHelper.getStringSafe(request, "hdnContractFunctionType");
    String signedOrUnsigned = ContextHelper.getStringSafe(request, "hdnSignedOrUnsigned");
    String lockedOrUnlocked = ContextHelper.getStringSafe(request, "hdnLockedorUnLocked");

    String paymentType = contractDetailRow.getSzCdCnsvcPaymentType();

    // Null catch for contractSearchResultsArray, if null set to blank (initialize)
    if ( ccon13si == null )
    {
      ccon13si = new CCON13SI();
    }

    if ( ccon13so == null )
    {
      ccon13so = new CCON13SO();
    }

    ROWCCON13SOG_ARRAY countryListResultsArray = null;
    if (ccon13so.getROWCCON13SOG_ARRAY() != null )
    {
      countryListResultsArray = ccon13so.getROWCCON13SOG_ARRAY();
    }
    else
    {
      countryListResultsArray = new ROWCCON13SOG_ARRAY();
    }

    // STGAP00017058 - allow Fiscal Ops users to add and modify contract services
	Boolean isEditPlus = state.getAttribute("editPlus", request) != null ? true : false;
    String pageMode = PageMode.getPageMode( request );
    if(isEditPlus){
    	pageMode = PageModeConstants.MODIFY;
    }

    //Variables for Page Modes
    String hideService = null;
    String hidePaymentType = null;
    String hideUnitType = null;
    String hideUnitRate = null;
    String hideFederdalMatch = null;
    String hideLocalMatch = null;
    String hideCountyListCbx = null;
    String hideSelectAllPushButton = null;
    String hideDeselectAllPushButton = null;
    String hideSavePushButton = null;

    if ( "N".equals( lockedOrUnlocked) && !"A".equals(dataAction))
    {
      //Page State 3
      hideService = "true";
      hidePaymentType = "true";
      hideUnitType = "true";

      hideFederdalMatch = "false";
      hideLocalMatch = "false";
      hideCountyListCbx = "false";
      hideSelectAllPushButton = "false";
      hideDeselectAllPushButton = "false";
      hideSavePushButton = "false";

      //SIR 17739 -- If payment type is equal to Cost Reimb, the Unit Rate Widget will
      //be disabled.  The user can also save and not get the "Field is required. Please
      //enter a value." message.
      if ("CRM".equals(paymentType) )
      {
        hideUnitRate = "true";
      }
      else
      {
        hideUnitRate = "false";
      }
    }
    else if("Y".equals( lockedOrUnlocked ) && !"A".equals(dataAction))
    {
      //Page State 1
      hideService = "true";
      hidePaymentType = "true";
      hideUnitType = "true";
      hideUnitRate = "true";
      hideFederdalMatch = "true";
      hideLocalMatch = "true";
      hideCountyListCbx = "true";
      hideSelectAllPushButton = "true";
      hideDeselectAllPushButton = "true";
      hideSavePushButton = "true";

    }
    // setting the Tabindex to One
    int tabIndex = 1;

    //get serviceOptions out of state
    List serviceOptions = (ArrayList) state.getAttribute("serviceOptions", request);

    //get Last Update of ContractDetailRow
    java.util.Date tsLastUpdate = contractDetailRow.getTsLastUpdate();
    String hdnFldLastUpdate = "";
    if(tsLastUpdate!=null){
       hdnFldLastUpdate = tsLastUpdate.toString();
    }

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n  //Confirm on Exit Message\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n\r\n");
 if ( "A".equals( dataAction ) )
  {


      out.write("\r\n\r\n  window.onload = function ()\r\n  {\r\n    onChangePaymentType();\r\n  }\r\n");

  }

      out.write("\r\n//fucntion gives the Select All and Deselect All push buttons functionality\r\nfunction selectAllDisplayedCounties( action )\r\n{\r\n var numOfCheckboxes = ");
      out.print( countryListResultsArray.getROWCCON13SOGCount() );
      out.write(";\r\n   var checkboxField;\r\n   for ( i = 1; i <= numOfCheckboxes; i++ )\r\n   {\r\n     checkboxField = eval(\"document.frmContractServiceDetail.cbxCounty_\" + i);\r\n\r\n     if(checkboxField.checked != action)\r\n     {\r\n       checkboxField.checked = action;\r\n       checkboxField.fireEvent(\"onclick\");\r\n     }\r\n   }\r\n}\r\n\r\n//Fix for SIR 14564\r\n//SIR 17740 The Unit Rate is protected when the Payment Type is Cost Reimbursement.\r\n\r\nfunction onChangePaymentType()\r\n{\r\n   if(frmContractServiceDetail.szNbrCnsvcPaymentType.value == 'VUR')\r\n   {\r\n     frmContractServiceDetail.szNbrCnsvcUnitType.value = 'ONE';\r\n     frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;\r\n     frmContractServiceDetail.ulNbrCnsvcUnitRate.disabled = false;\r\n   }\r\n   else if (frmContractServiceDetail.szNbrCnsvcPaymentType.value == 'CRM')\r\n   {\r\n     frmContractServiceDetail.ulNbrCnsvcUnitRate.disabled = true;\r\n     frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;\r\n     frmContractServiceDetail.szNbrCnsvcUnitType.value = '';\r\n   }\r\n   else\r\n");
      out.write("   {\r\n     frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;\r\n     frmContractServiceDetail.ulNbrCnsvcUnitRate.disabled = false;\r\n   }\r\n}\r\n\r\nfunction enableUnitType()\r\n{\r\n  frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;\r\n}\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContractServiceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Contracts/displayContractServiceDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ContractDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnLastUpdate");
          _jspx_th_impact_validateInput_0.setValue( hdnFldLastUpdate );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnIdPerson");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt( GlobalData.getUlIdPerson( request ) ));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnUlIdCnsvc");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatInt(contractDetailRow.getUlIdCnsvc()));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdndtDtCncntyEffective");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatDate(countyEffective) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdndtDtCncntyEnd");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatDate(countyEnd) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnszCdScrDataAction");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(dataAction) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnUlIdResource");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatInt(resourceId) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnCdRsrcSvcService");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatString(service) );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnContractBudgetLimit");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatString(contractBudgetLimit) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnContractFunctionType");
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatString(contractFunctionType) );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("ulIdResource");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatInt(resourceId) );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnSignedOrUnsigned");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatString(signedOrUnsigned) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnLockedorUnLocked");
          _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatString(lockedOrUnlocked) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnUlAmtCnsvcUnitRate");
          _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatMoney(contractDetailRow.getUlAmtCnsvcUnitRate()) );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnContractVersion");
          _jspx_th_impact_validateInput_14.setValue( FormattingHelper.formatInt( GlobalData.getUlNbrCnverVersion( request ))  );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n  <tr>\r\n    <th colspan=\"4\">\r\n      Contract Service Detail\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("versions");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Version");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatInt( GlobalData.getUlNbrCnverVersion( request )) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n     </td>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspUlNbrCnsvcLineItem");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("CSLI");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatInt(contractDetailRow.getUlNbrCnsvcLineItem() ));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setValue( contractDetailRow.getSzCdCnsvcService() );
          _jspx_th_impact_validateSelect_0.setName("szNbrCnsvcService");
          _jspx_th_impact_validateSelect_0.setLabel("Service");
          _jspx_th_impact_validateSelect_0.setOptions( serviceOptions );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setOnChange("setIsDirtyCalled(true); disableValidation('frmContractServiceDetail'); submitValidateForm('frmContractServiceDetail', '/financials/Contracts/redisplayContractServiceDetail');");
          _jspx_th_impact_validateSelect_0.setDisabled( hideService );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setValue( contractDetailRow.getSzCdCnsvcPaymentType() );
          _jspx_th_impact_validateSelect_1.setName("szNbrCnsvcPaymentType");
          _jspx_th_impact_validateSelect_1.setLabel("Payment Type");
          _jspx_th_impact_validateSelect_1.setCodesTable("CCONPAY");
          _jspx_th_impact_validateSelect_1.setOnChange("javascript:onChangePaymentType()");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setDisabled( hidePaymentType );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setValue( contractDetailRow.getSzNbrCnsvcUnitType() );
          _jspx_th_impact_validateSelect_2.setName("szNbrCnsvcUnitType");
          _jspx_th_impact_validateSelect_2.setLabel("Unit Type");
          _jspx_th_impact_validateSelect_2.setCodesTable("CCONUNIT");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setDisabled( hideUnitType );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setLabel("Unit Rate");
          _jspx_th_impact_validateInput_15.setName("ulNbrCnsvcUnitRate");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setValue( FormattingHelper.formatMoney( contractDetailRow.getUlNbrCnsvcUnitRate() ) );
          _jspx_th_impact_validateInput_15.setConstraint("Money");
          _jspx_th_impact_validateInput_15.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_15.setDisabled( hideUnitRate );
          _jspx_th_impact_validateInput_15.setMaxLength("10");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setLabel("Federal Match");
          _jspx_th_impact_validateInput_16.setName("ulNbrCnsvcFedMatch");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setValue( FormattingHelper.formatInt(contractDetailRow.getUlNbrCnsvcFedMatch())  );
          _jspx_th_impact_validateInput_16.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_16.setDisabled( hideFederdalMatch );
          _jspx_th_impact_validateInput_16.setSize("3");
          _jspx_th_impact_validateInput_16.setMaxLength("3");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setLabel("Local Match");
          _jspx_th_impact_validateInput_17.setName("ulNbrCnsvcLocalMatch");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setValue( FormattingHelper.formatInt(contractDetailRow.getUlNbrCnsvcLocalMatch()) );
          _jspx_th_impact_validateInput_17.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_17.setDisabled( hideLocalMatch );
          _jspx_th_impact_validateInput_17.setSize("3");
          _jspx_th_impact_validateInput_17.setMaxLength("3");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n");

if ("Y".equals(countyList))
{

          out.write("\r\n<div id=\"scrollBar\" style=\"height:175;width:100%;overflow:auto\" class=\"tableBorderList\">\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n    <tr class=\"thList\">\r\n      <td width=\"5%\">\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        Code\r\n      </td>\r\n      <td>\r\n        County\r\n      </td>\r\n    </tr>\r\n");

     //set checkbox counter equal to 1
     int cbxLoopCount = 1;

     //Enumeration through enumerateROWCCON13SOG to get checked values
     Enumeration countryListResultsEnumeration = countryListResultsArray.enumerateROWCCON13SOG();

     //setting ROWCCON13SOG equal to null
     ROWCCON13SOG countryListResultsRow = null;

     //if the enumeration is empty return NO Rows returned message
     if ( !countryListResultsEnumeration.hasMoreElements() )
     {

          out.write("\r\n  <tr class=\"odd\">\r\n    <td colspan=\"5\">\r\n      ");
 hideSelectAllPushButton = "true"; 
          out.write("\r\n      ");
          out.print( MessageLookup.getMessageByNumber(Messages.MSG_CON_NO_COUNTY) );
          out.write("\r\n    </td>\r\n  </tr>\r\n");

     }
      // else there is a least one row.  While there are more rows, create a new rows and display the data
     else
     {
     hideSelectAllPushButton = "false";
     hideDeselectAllPushButton = "false";
     while( countryListResultsEnumeration.hasMoreElements() )
     {
       countryListResultsRow = (ROWCCON13SOG) countryListResultsEnumeration.nextElement();
       String isCountyChecked = "false";
       if(!"A".equals(dataAction) && countryListResultsRow.getUlIdCncnty() > 0)
       {
         isCountyChecked = "true";
       }
       //add one to the checkbox field name
       String cbxFieldName = "cbxCounty_" + cbxLoopCount;

          out.write("\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("checkbox");
          _jspx_th_impact_validateInput_18.setName( cbxFieldName );
          _jspx_th_impact_validateInput_18.setChecked( isCountyChecked );
          _jspx_th_impact_validateInput_18.setValue(( countryListResultsRow.getSzCdCncntyCounty() ));
          _jspx_th_impact_validateInput_18.setDisabled( hideCountyListCbx );
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          out.print( countryListResultsRow.getSzCdCncntyCounty() );
          out.write("\r\n    </td>\r\n\r\n    <td>\r\n      ");
          out.print(Lookup.simpleDecodeSafe("CCOUNT", countryListResultsRow.getSzCdCncntyCounty() ) );
          out.write("\r\n    </td>\r\n  </tr>\r\n");

     //add one to the loop count
     cbxLoopCount++;
       }
         //end of while
     }
//end of if statement

          out.write("\r\n  </table>\r\n</div>\r\n");

}//end if ( for hiding the county list when a user enters the page in add mode);

          out.write('\r');
          out.write('\n');
 /* this is where the "scrollBar" div tag ends */ 
          out.write('\r');
          out.write('\n');

//will display the SelectAllPushButton and DeselectAllPushButton

//SIR 17750 -- Added the following logic to the Select and Deselect push button
//if statement.  Check to see if the Version is Locked or Unlocked.

if (("false".equals(hideSelectAllPushButton) && ("false").equals(hideDeselectAllPushButton) && "N".equals( lockedOrUnlocked )))
{

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"80%\">\r\n      &nbsp;\r\n    </td>\r\n    <td align=\"right\" width=\"10%\">\r\n      <a onclick=\"JavaScript:selectAllDisplayedCounties( true );\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n        <img src=\"/grnds-docs/images/shared/btnSelectAll.gif\" />\r\n      </a>\r\n    </td>\r\n    <td align=\"right\" width=\"10%\">\r\n      <a onclick=\"JavaScript:selectAllDisplayedCounties( false );\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n        <img src=\"/grnds-docs/images/shared/btnDeselectAll.gif\" />\r\n      </a>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

}
//end if(diplay hideSelectAllPushButton and hideSelectAllPushButton)


          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"90%\">\r\n      &nbsp;\r\n    </td>\r\n    <td width=\"10%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmContractServiceDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("enableUnitType()");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Contracts/saveContractServiceDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setDisabled( hideSavePushButton );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n");
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
