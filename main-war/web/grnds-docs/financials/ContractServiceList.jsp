<%
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
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01_ARRAY"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%

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
%>
<impact:validateErrors/>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<script type="text/javascript"  language="JavaScript1.2">

  //Confirm on Exit Message
  window.onbeforeunload = function ()
  {

  };

  //This function is called when a user clicks the CSLI hyperlink.  Determines the index that is passed to the
  //Contract Service Detail page
  function ServiceListFunction (index)
  {
    disableValidation( "frmContractServiceList" );
    document.frmContractServiceList.hdnulNbrCnsvcLineItem.value = index;
    submitValidateForm( "frmContractServiceList" , "/financials/Contracts/displayContractServiceDetail" );
  }

  //This function is called when a user clicks the Payment Type hyperlink.  Determines the index that is passed to the
  //Contract Service Detail page
  function PaymentTypeHyperLinkFunction (index)
  {
    disableValidation( "frmContractServiceList" );
    document.frmContractServiceList.hdnulNbrCnsvcLineItem.value = index;
    submitValidateForm( "frmContractServiceList" , "/financials/Contracts/displayCostRmbrsmentOrUnitRate");
  }
</script>
<impact:validateForm name="frmContractServiceList"
  method="post"
  action="/financials/Contracts/displayContractServiceList"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractListCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td width="10%">
      <impact:validateDisplayOnlyField name="version"
                                       label="Version"
                                       value='<%= FormattingHelper.formatInt( contractVersion )%>' />

    </td>
  </tr>
</table>
<impact:validateInput type="hidden"
                      name="hdnUlIdResource"
                      value="<%=  FormattingHelper.formatInt(resourceId) %>" />
<impact:validateInput type="hidden"
                      name="hdndtDtCncntyEffective"
                      value="<%=  FormattingHelper.formatDate(countyEffective) %>" />
<impact:validateInput type="hidden"
                      name="hdndtDtCncntyEnd"
                      value="<%= FormattingHelper.formatDate(countyEnd) %>" />
<impact:validateInput type="hidden"
                      name="hdnContractBudgetLimit"
                      value="<%= FormattingHelper.formatString(contractBudgetLimit) %>" />
<impact:validateInput type="hidden"
                      name="hdnContractFunctionType"
                      value="<%= FormattingHelper.formatString(contractFunctionType) %>"/>
<impact:validateInput type="hidden"
                      name="hdnSignedOrUnsigned"
                      value="<%= FormattingHelper.formatString(signedOrUnsigned) %>"/>
<impact:validateInput type="hidden"
                      name="hdnLockedorUnLocked"
                      value="<%= FormattingHelper.formatString(lockedOrUnlocked) %>"/>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
   <tr>
    <th>
      CSLI
    </th>
    <th>
      Service
    </th>
    <th>
      Payment Type
    </th>
    <th>
      Unit Type
    </th>
    <th style="{text-align:right}">
      Unit Rate
    </th>
    <th style="{text-align:right}">
      Federal Match
    </th>
    <th style="{text-align:right}">
      Local Match
    </th>
    <th style="{text-align:right}">
      Total Amount
    </th>
    <th style="{text-align:right}">
      Budget Balance
    </th>
  </tr>
<%
     Enumeration contractServiceListResultsEnumeration = contractServiceListResultsArray.enumerateROWCCON11SOG00();
     //Display the results if the array is not empty
     loopCount = 0;
     int lineItemCounter = 1;
     String NbrCnsvcLineItem = "";

     ROWCCON11SOG00 contractServiceListRow = null;
     if ( !contractServiceListResultsEnumeration.hasMoreElements() )
     {
%>
  <tr class="odd">
    <td colspan="12">
      <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
    </td>
  </tr>
<%
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

%>
  <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>">

    <td>
      <a href="javascript:ServiceListFunction( '<%=loopCount%>' );"
                                              onclick="window.onBeforeUnload=null;"
                                              tabIndex="<%= tabIndex++ %>">
                                              <%= ulNbrCnsvcLineItem %>
                                              </a>
    </td>
    <td>
      <%= contractServiceListRow.getSzCdCnsvcService() %>
      <impact:validateInput type="hidden"
                            name="szCdCnsvcService"
                            value="<%= FormattingHelper.formatString(contractServiceListRow.getSzCdCnsvcService()) %>"
                            tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td>
      <a href="javascript:PaymentTypeHyperLinkFunction( '<%=loopCount%>' );"
                                                       onclick="window.onBeforeUnload=null;"
                                                       tabIndex="<%= tabIndex++ %>">
                                                       <%= Lookup.simpleDecodeSafe("CCONPAY", contractServiceListRow.getSzCdCnsvcPaymentType()) %>
                                                       </a>
    </td>
    <td>
      <impact:validateDisplayOnlyField name="serviceListDisplay"
                                       value="<%= FormattingHelper.formatString(unitType) %>"/>
    </td>
    <td align="right">
      <impact:validateDisplayOnlyField name="unitTypeDisplay"
                                       value="<%= FormattingHelper.formatMoney(unitRate) %>"/>
    </td>
<%
    //SIR 17923 -- Changed the format of the Fed Match and Local Match Display only fields.
    //The new format will display as 10 not $ 10.00 like before.
%>
    <td align="right">
      <impact:validateDisplayOnlyField name="fedMatchDisplay"
                                       value="<%= String.valueOf( fedMatch ) %>"/>
    </td>
    <td align="right">
      <impact:validateDisplayOnlyField name="localMatchDisplay"
                                       value="<%= String.valueOf( localMatch ) %>"/>
    </td>
<%
    //prints out the Total Amount and Budget Balnace for Cost Reimb
    if ("CRM".equals(contractServiceListRow.getSzCdCnsvcPaymentType()))
    {
%>
    <td align="right">
      <impact:validateDisplayOnlyField name="totalAmountCostReimDisplay"
                                       label=""
                                       value="<%= FormattingHelper.formatMoney(totalAmountCostReim) %>"/>
    </td>
    <td align="right">
      <impact:validateDisplayOnlyField name="budgetBalanceCostReimDisplay"
                                       label=""
                                       value="<%= FormattingHelper.formatMoney(budgetBalanceCostReim) %>"/>
    </td>
<%
      }
      //prints out the Total Amount and Budget Balnace for Unit Rate and Variable Rate
      else if ("URT".equals(contractServiceListRow.getSzCdCnsvcPaymentType())
              || "VUR".equals(contractServiceListRow.getSzCdCnsvcPaymentType()))
      {
%>
    <td align="right">
       <impact:validateDisplayOnlyField name="totalAmountUnitVarRateDisplay"
                                        label=""
                                        value="<%= FormattingHelper.formatMoney(totalAmountUnitVarRate) %>"/>
    </td>
    <td align="right">
       <impact:validateDisplayOnlyField name="budgetBalanceUnitVarRateDisplay"
                                        label=""
                                        value="<%= FormattingHelper.formatMoney(budgetBalanceUnitVarRate) %>"/>
    </td>
<%
      }
//end of else if
%>
   </tr>
<%
      loopCount++;
      }
      // end while
    }
    lineItemCounter = loopCount + 1;
%>
      <impact:validateInput type="hidden"
                            name="hdnLineItemCounter"
                            value="<%= FormattingHelper.formatInt(lineItemCounter) %>" />

      <impact:validateInput type="hidden"
                            name="hdnulNbrCnsvcLineItem"
                            value=""/>

</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
    <td align="right">
      <impact:ButtonTag name="btnAdd"
                        img="btnAdd"
                        align="right"
                        form="frmContractServiceList"
                        action="/financials/Contracts/displayContractServiceDetailAdd"
                        tabIndex="<%= tabIndex++ %>"
                        disabled="<%= hideAddPushButton %>" />
    </td>
  </tr>
</table>
</impact:validateForm>



