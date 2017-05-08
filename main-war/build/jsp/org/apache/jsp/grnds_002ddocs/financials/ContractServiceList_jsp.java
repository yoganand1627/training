package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01_ARRAY;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public final class ContractServiceList_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*   JSP Name:     ContractServiceList.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 02/10/2003
//*
//*   The Contract Service List window will allow contract managers
//*   and technicians to view service data for a specific contract version.
//*   Users may view a data record from the list.
//*
//*
//**  Change History:
//**  Date        User              Description
//**  --------    ----------------  --------------------------------------------------
//**  02/10/2003  Eric Dickman      Created initial docuement.
//**
//**  06/01/2003  Eric Dickman      SIR 17923 -- Changed the format of the Fed Match
//**                                and Local Match Display only fields. The new format
//**                                will display as 10 not $ 10.00 like before.
//**  10/16/2011	charden			STGAP00017058: making page editable for fiscal ops users
//**

      out.write("\r\n\r\n\r\n\r\n");
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

    CCON11SO ccon11so = (CCON11SO) state.getAttribute("CCON11SO", request);
    ROWCCON11SOG00_ARRAY contractServiceListResultsArray = null;

    // Null catch for contractSearchResultsArray, if null set to blank (initialize)
    if ( ccon11so == null )
    {
      ccon11so = new CCON11SO();
    }

    // Null catch for ROW objects, if not null get rows
    if ( ccon11so.getROWCCON11SOG01_ARRAY() != null )
    {
      contractServiceListResultsArray = ccon11so.getROWCCON11SOG00_ARRAY();
    }
    else
    {
      contractServiceListResultsArray = new ROWCCON11SOG00_ARRAY();
    }

	// STGAP00017058 - allow Fiscal Ops users to add and modify contract services
	Boolean isEditPlus = state.getAttribute("editPlus", request) != null ? true : false;
    String pageMode = PageMode.getPageMode( request );
    if(isEditPlus){
    	pageMode = PageModeConstants.MODIFY;
    }

    //Setting Local Page Variables
    int tabIndex = 1;
    int loopCount = 0;

    //getting fields from the request need for Contract Service List .jsp
    int resourceId = ContextHelper.getIntSafe(request, "txtUlIdResource") ;
    if (resourceId == 0)
    {
      resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource") ;
    }

    org.exolab.castor.types.Date countyEffective =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEffective"));

    org.exolab.castor.types.Date countyEnd =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEnd"));

    String contractFunctionType = ContextHelper.getStringSafe(request, "selSzCdCntrctFuncType");

    String contractBudgetLimit = ContextHelper.getStringSafe(request, "hdnContractBudgetLimit");

    //The Page mode for the Contract Service Detail page are determined on the Contract Period Detail Page.  The checkbox
    //can be either unsigned or signed.  If the case is unsigned the variable will be "N" and if the case is signed the variable
    //passed in will be "Y".  The name of the hidden field is hdnSignedOrUnsigned
     String signedOrUnsigned = ContextHelper.getStringSafe( request, "hdnSignedOrUnsigned" );

     //The hidden variable hdnLockedorUnLocked is passed from the Contract Header page, this variable is used
    //for page modes.  The hdnLockedorUnLocked field can be "Y" or "N".  The hdnLockedorUnLocked is
    //determined by the Locked Checkbox widget Contract Version Detail jsp.
    String lockedOrUnlocked = ContextHelper.getStringSafe(request, "hdnLockedorUnLocked");
    int contractVersion = GlobalData.getUlNbrCnverVersion( request );

    //Variables for page mode
    String hideAddPushButton = null;

    //Sets the page mode
    if //((ContractsConversation.CONTRACT_MODIFY).equals(pageModeForContractList) && "N".equals(lockedOrUnlocked))
      ("N".equals(lockedOrUnlocked))
    {
      //Modify Mode Unlocked, Page State 2 in the Detail Design
      hideAddPushButton = "false";
    }
    else if //((ContractsConversation.CONTRACT_MODIFY).equals(pageModeForContractList) &&
      ("Y".equals(lockedOrUnlocked))
    {
      //Modify Mode Locked, Page State 3 in the Detail Design
      hideAddPushButton = "true";
    }

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n  //Confirm on Exit Message\r\n  window.onbeforeunload = function ()\r\n  {\r\n\r\n  };\r\n\r\n  //This function is called when a user clicks the CSLI hyperlink.  Determines the index that is passed to the\r\n  //Contract Service Detail page\r\n  function ServiceListFunction (index)\r\n  {\r\n    disableValidation( \"frmContractServiceList\" );\r\n    document.frmContractServiceList.hdnulNbrCnsvcLineItem.value = index;\r\n    submitValidateForm( \"frmContractServiceList\" , \"/financials/Contracts/displayContractServiceDetail\" );\r\n  }\r\n\r\n  //This function is called when a user clicks the Payment Type hyperlink.  Determines the index that is passed to the\r\n  //Contract Service Detail page\r\n  function PaymentTypeHyperLinkFunction (index)\r\n  {\r\n    disableValidation( \"frmContractServiceList\" );\r\n    document.frmContractServiceList.hdnulNbrCnsvcLineItem.value = index;\r\n    submitValidateForm( \"frmContractServiceList\" , \"/financials/Contracts/displayCostRmbrsmentOrUnitRate\");\r\n");
      out.write("  }\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContractServiceList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Contracts/displayContractServiceList");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ContractListCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"10%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("version");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Version");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatInt( contractVersion ));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnUlIdResource");
          _jspx_th_impact_validateInput_0.setValue(  FormattingHelper.formatInt(resourceId) );
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
          _jspx_th_impact_validateInput_1.setName("hdndtDtCncntyEffective");
          _jspx_th_impact_validateInput_1.setValue(  FormattingHelper.formatDate(countyEffective) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdndtDtCncntyEnd");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatDate(countyEnd) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnContractBudgetLimit");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatString(contractBudgetLimit) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnContractFunctionType");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatString(contractFunctionType) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnSignedOrUnsigned");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(signedOrUnsigned) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnLockedorUnLocked");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatString(lockedOrUnlocked) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n   <tr>\r\n    <th>\r\n      CSLI\r\n    </th>\r\n    <th>\r\n      Service\r\n    </th>\r\n    <th>\r\n      Payment Type\r\n    </th>\r\n    <th>\r\n      Unit Type\r\n    </th>\r\n    <th style=\"{text-align:right}\">\r\n      Unit Rate\r\n    </th>\r\n    <th style=\"{text-align:right}\">\r\n      Federal Match\r\n    </th>\r\n    <th style=\"{text-align:right}\">\r\n      Local Match\r\n    </th>\r\n    <th style=\"{text-align:right}\">\r\n      Total Amount\r\n    </th>\r\n    <th style=\"{text-align:right}\">\r\n      Budget Balance\r\n    </th>\r\n  </tr>\r\n");

     Enumeration contractServiceListResultsEnumeration = contractServiceListResultsArray.enumerateROWCCON11SOG00();
     //Display the results if the array is not empty
     loopCount = 0;
     int lineItemCounter = 1;
     String NbrCnsvcLineItem = "";

     ROWCCON11SOG00 contractServiceListRow = null;
     if ( !contractServiceListResultsEnumeration.hasMoreElements() )
     {

          out.write("\r\n  <tr class=\"odd\">\r\n    <td colspan=\"12\">\r\n      ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n    </td>\r\n  </tr>\r\n");

     }
     else
     {
        //Variables for Cost Reimb
        double totalAmountCostReim = 0;
        double usedAmountCostReim = 0;
        double budgetBalanceCostReim = 0;

        //Variables for Unit Rate and Variable Rate
        double totalAmountUnitVarRate = 0;
        double usedAmountUnitVarRate = 0;
        double budgetBalanceUnitVarRate = 0;

        //Variables for the Unit Rate Detail Page
        String paymentType = "";
        String serviceType = "";
        String unitType = "";

        int ulNbrCnsvcLineItem = 0;
        int fedMatch = 0;
        int localMatch = 0;
        double unitRate = 0;

        String tsLastUpdate = "";
        int idCnsvc = 0;

        //gets the rows in the list
        while( contractServiceListResultsEnumeration.hasMoreElements() )
        {
          contractServiceListRow = (ROWCCON11SOG00) contractServiceListResultsEnumeration.nextElement();
          ulNbrCnsvcLineItem = contractServiceListRow.getUlNbrCnsvcLineItem();
          paymentType = FormattingHelper.formatString(contractServiceListRow.getSzCdCnsvcPaymentType());

          serviceType = FormattingHelper.formatString(contractServiceListRow.getSzCdCnsvcService());
          unitType = FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCONUNIT", contractServiceListRow.getSzNbrCnsvcUnitType()));
          fedMatch = contractServiceListRow.getUlNbrCnsvcFedMatch();

          localMatch = contractServiceListRow.getUlNbrCnsvcLocalMatch();
          unitRate = contractServiceListRow.getUlNbrCnsvcUnitRate();
          tsLastUpdate = DateHelper.toISOString(contractServiceListRow.getTsLastUpdate());

          idCnsvc = contractServiceListRow.getUlIdCnsvc();
          NbrCnsvcLineItem = FormattingHelper.formatInt(contractServiceListRow.getUlNbrCnsvcLineItem());

          if ("CRM".equals(contractServiceListRow.getSzCdCnsvcPaymentType()))
          {
            //Total amount if the Payment Type is Cost Reim
            totalAmountCostReim = contractServiceListRow.getUlAmtCnsvcEquip() + contractServiceListRow.getUlAmtCnsvcFrgBenft()
                                + contractServiceListRow.getUlAmtCnsvcOther() + contractServiceListRow.getUlAmtCnsvcSalary()
                                + contractServiceListRow.getUlAmtCnsvcSupply() + contractServiceListRow.getUlAmtCnsvcTravel();

            //Remaining Amount if the Payment Type is Cost Reim
            usedAmountCostReim = contractServiceListRow.getUlAmtCnsvcAdminAllUsed() + contractServiceListRow.getUlAmtCnsvcEquipUsed()
                               + contractServiceListRow.getUlAmtCnsvcFrgBenftUsed() + contractServiceListRow.getUlAmtCnsvcOffItemUsed()
                               + contractServiceListRow.getUlAmtCnsvcOtherUsed() + contractServiceListRow.getUlAmtCnsvcSalaryUsed()
                               + contractServiceListRow.getUlAmtCnsvcSupplyUsed() + contractServiceListRow.getUlAmtCnsvcTravelUsed();

            //Math for Cost Re-im, finds the budget that is remaining or variable rate
            budgetBalanceCostReim = (totalAmountCostReim - usedAmountCostReim);
          }
          else if
            ("URT".equals(contractServiceListRow.getSzCdCnsvcPaymentType())
             || "VUR".equals(contractServiceListRow.getSzCdCnsvcPaymentType()))
          {
            //Total amount if the Payment Type is Unit Rate or Variable Rate
            totalAmountUnitVarRate = contractServiceListRow.getUlAmtCnsvcUnitRate();

            //Remaining Amount if the Payment Type is Unit Rate or Variable Rate
            usedAmountUnitVarRate = contractServiceListRow.getUlAmtCnsvcUnitRateUsed();
            budgetBalanceUnitVarRate = (totalAmountUnitVarRate - usedAmountUnitVarRate);
          }
          //end of if for URT or CRM or VAR


          out.write("\r\n  <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\">\r\n\r\n    <td>\r\n      <a href=\"javascript:ServiceListFunction( '");
          out.print(loopCount);
          out.write("' );\"\r\n                                              onclick=\"window.onBeforeUnload=null;\"\r\n                                              tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n                                              ");
          out.print( ulNbrCnsvcLineItem );
          out.write("\r\n                                              </a>\r\n    </td>\r\n    <td>\r\n      ");
          out.print( contractServiceListRow.getSzCdCnsvcService() );
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("szCdCnsvcService");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatString(contractServiceListRow.getSzCdCnsvcService()) );
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      <a href=\"javascript:PaymentTypeHyperLinkFunction( '");
          out.print(loopCount);
          out.write("' );\"\r\n                                                       onclick=\"window.onBeforeUnload=null;\"\r\n                                                       tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n                                                       ");
          out.print( Lookup.simpleDecodeSafe("CCONPAY", contractServiceListRow.getSzCdCnsvcPaymentType()) );
          out.write("\r\n                                                       </a>\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("serviceListDisplay");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString(unitType) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("unitTypeDisplay");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatMoney(unitRate) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

    //SIR 17923 -- Changed the format of the Fed Match and Local Match Display only fields.
    //The new format will display as 10 not $ 10.00 like before.

          out.write("\r\n    <td align=\"right\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("fedMatchDisplay");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( String.valueOf( fedMatch ) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("localMatchDisplay");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( String.valueOf( localMatch ) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

    //prints out the Total Amount and Budget Balnace for Cost Reimb
    if ("CRM".equals(contractServiceListRow.getSzCdCnsvcPaymentType()))
    {

          out.write("\r\n    <td align=\"right\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("totalAmountCostReimDisplay");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatMoney(totalAmountCostReim) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("budgetBalanceCostReimDisplay");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( FormattingHelper.formatMoney(budgetBalanceCostReim) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

      }
      //prints out the Total Amount and Budget Balnace for Unit Rate and Variable Rate
      else if ("URT".equals(contractServiceListRow.getSzCdCnsvcPaymentType())
              || "VUR".equals(contractServiceListRow.getSzCdCnsvcPaymentType()))
      {

          out.write("\r\n    <td align=\"right\">\r\n       ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("totalAmountUnitVarRateDisplay");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue( FormattingHelper.formatMoney(totalAmountUnitVarRate) );
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\">\r\n       ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("budgetBalanceUnitVarRateDisplay");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue( FormattingHelper.formatMoney(budgetBalanceUnitVarRate) );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

      }
//end of else if

          out.write("\r\n   </tr>\r\n");

      loopCount++;
      }
      // end while
    }
    lineItemCounter = loopCount + 1;

          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnLineItemCounter");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatInt(lineItemCounter) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      ");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAdd");
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmContractServiceList");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Contracts/displayContractServiceDetailAdd");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setDisabled( hideAddPushButton );
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

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnulNbrCnsvcLineItem");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
