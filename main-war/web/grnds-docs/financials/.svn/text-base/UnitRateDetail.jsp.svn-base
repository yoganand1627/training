<%
//*   JSP Name:     UnitRateDetail.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 02/15/2003
//*
//*
//*  The Unit Rate Detail window will be used by contract
//*  managers and technicians to maintain or view budget info.
//*  about a service line item.
//*
//**  Change History:
//**  Date        User              Description
//**  --------    --------------    --------------------------------------------------
//**  02/15/03    Eric Dickman      Created initial docuement.
//**  01/24/05    CORLEYAN          SIR 23023 - Changed the Unit Rate Hidden field
//**                                so that the value is populated with format money
//**                                otherwise it is rounded up or down.
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
    //variables used on the page
    int tabIndex = 1;

    //getting varibles out of the request that are need for the Unit Rate page
    ROWCCON11SOG00 rowccon11sog00 = (ROWCCON11SOG00) request.getAttribute("rowccon11sog00");

    int resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource");
        org.exolab.castor.types.Date countyEffective =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEffective"));
    org.exolab.castor.types.Date countyEnd =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEnd"));
    String contractFunctionType = ContextHelper.getStringSafe(request, "hdnContractFunctionType");

    //page mode hidden variables
    String contractBudgetLimit = ContextHelper.getStringSafe(request, "hdnContractBudgetLimit");
    String signedOrUnsigned = ContextHelper.getStringSafe(request, "hdnSignedOrUnsigned");
    String lockedOrUnlocked = ContextHelper.getStringSafe(request, "hdnLockedorUnLocked");

    //Sets page mode to Edit
    String pageMode = PageMode.getPageMode( request );

    //Set page mode if Budget Detail isn't checked
    if  ("N".equals(contractBudgetLimit))
    {
      pageMode = PageModeConstants.VIEW;
    }

    //Variable for widgets to be enabled or disabled
    String hideLineItemAmt = null;
    String hideSavePushButton = null;


    if ("Y".equals(lockedOrUnlocked) )
    {
      hideLineItemAmt = "true";
      hideSavePushButton = "true";
    }else{
      hideLineItemAmt = "false";
      hideSavePushButton = "false";
    }
   %>
<impact:validateErrors/>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<script type="text/javascript"  language="JavaScript1.2">

//Confirm on Exit Message
  window.onbeforeunload = function ()
  {
      IsDirty();
  };

</script>

<impact:validateForm name="frmContractCostRmbrsmntDetail"
  method="post"
  defaultButton="true"
  action="/financials/Contracts/displayCostRmbrsmentOrUnitRate"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.UnitRateDetailCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <tr>
    <th colspan="4">Unit Rate Detail</th>
  </tr>
  <tr>
    <td width="20%"/>
    <td width="30%"/>
    <td width="20%"/>
    <td width="30%"/>
  </tr>
  <tr>
    <td width="20%">
      <impact:validateDisplayOnlyField name="version"
                                       label="Version"
                                       value="<%= FormattingHelper.formatInt( GlobalData.getUlNbrCnverVersion( request )) %>" />
    </td>
    <td>
       <impact:validateDisplayOnlyField name="szCdCnsvcService"
                                       label="CSLI"
                                       value="<%= FormattingHelper.formatInt(rowccon11sog00.getUlNbrCnsvcLineItem())%>" />
    </td>
  </tr>
  <tr>
    <td width="20%">
      <impact:validateInput type="text"
                            label="Line Item Amount"
                            name="ulAmtCnsvcUnitRate"
                            cssClass="formInput"
                            constraint="Money"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcUnitRate()) %>"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideLineItemAmt %>"
                            maxLength="12"/>
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcUnitRateUsed"
                                       label="Amount Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcUnitRateUsed()) %>" />
    </td>
  </tr>

<%
   //get variables out of the request
   double ulAmtCnsvcUnitRate = rowccon11sog00.getUlAmtCnsvcUnitRate();
   double ulAmtCnsvcUnitRateUsed = rowccon11sog00.getUlAmtCnsvcUnitRateUsed();
   double unitRate = rowccon11sog00.getUlNbrCnsvcUnitRate();

   //setting local variables definations
   double usedUnits = 0;
   double totalUnits = 0;

   //This if statement will determine the Total Units Display Only Field
   if (ulAmtCnsvcUnitRate != 0 && unitRate != 0)
   {
     //calculation for Total Units Field
     totalUnits = ulAmtCnsvcUnitRate/unitRate;
%>
  <tr>
    <td>
      <impact:validateDisplayOnlyField name="unitsTotalUnitRate"
                                       label="Total Units"
                                       value="<%= String.valueOf(Math.round(Math.floor(totalUnits))) %>" />
    </td>
<%
   }
   // if the user enters the page in new mode total units will be zero
   else
   {
%>
    <td>
      <impact:validateDisplayOnlyField name="unitsTotalUnitRateEqualToZero"
                                       label="Total Units"
                                       value="0" />
    </td>
<%
   }
   //end if
%>
<%
   //This if statement will determine the Used Units Display Only Field
   if (ulAmtCnsvcUnitRateUsed != 0 && unitRate != 0)
   {
     //calculation for Total Units Field
     usedUnits = ulAmtCnsvcUnitRateUsed/unitRate;
%>
    <td>
      <impact:validateDisplayOnlyField name="unitsUsedUnitRate"
                                        label="Used Units"
                                        value="<%= String.valueOf(Math.round(Math.floor(usedUnits))) %>" />
    </td>
<%
  }
   // if the user enters the page in new mode used units will be zero
  else
  {
%>
    <td>
      <impact:validateDisplayOnlyField name="unitsUsedUnitRateEqualToZero"
                                       label="Used Units"
                                       value="0" />
    </td>
<%
  }
  //end of if
%>
  </tr>
  <%--Hidden Fields --%>
      <impact:validateInput type="hidden"
                            name="hdnUlAmtCnsvcEquip"
                            value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlAmtCnsvcEquip()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlAmtCnsvcFrgBenft"
                            value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlAmtCnsvcFrgBenft()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlAmtCnsvcOther"
                            value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlAmtCnsvcOther())  %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlAmtCnsvcSalary"
                            value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlAmtCnsvcSalary())  %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlAmtCnsvcSupply"
                            value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlAmtCnsvcSupply())  %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlAmtCnsvcTravel"
                            value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlAmtCnsvcTravel()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnSzCnsvcPaymentType"
                            value="<%= FormattingHelper.formatString(rowccon11sog00.getSzCdCnsvcPaymentType()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnSzCnsvcService"
                            value="<%= FormattingHelper.formatString(rowccon11sog00.getSzCdCnsvcService()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnSzNbrCnsvcUnitType"
                            value="<%= FormattingHelper.formatString(rowccon11sog00.getSzNbrCnsvcUnitType()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlIdCnsvc"
                            value="<%= FormattingHelper.formatInt(rowccon11sog00.getUlIdCnsvc()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlNbrCnsvcFedMatch"
                            value="<%= FormattingHelper.formatInt(rowccon11sog00.getUlNbrCnsvcFedMatch()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlNbrCnsvcLineItem"
                            value="<%= FormattingHelper.formatInt(rowccon11sog00.getUlNbrCnsvcLineItem()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlNbrCnsvcLocalMatch"
                            value="<%= FormattingHelper.formatInt(rowccon11sog00.getUlNbrCnsvcLocalMatch()) %>"/>

      <impact:validateInput type="hidden"
                            name="hdnUlNbrCnsvcUnitRate"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlNbrCnsvcUnitRate()) %>"/>
                            <% String tsLastUpdate = rowccon11sog00.getTsLastUpdate().toString();  %>

      <impact:validateInput type="hidden"
                            name="hdnTsLastUpdate"
                            value="<%= tsLastUpdate %>"/>

       <impact:validateInput type="hidden"
                             name="hdnUlIdResource"
                             value="<%= FormattingHelper.formatInt(resourceId) %>" />

       <impact:validateInput type="hidden"
                             name="hdndtDtCncntyEffective"
                             value="<%= FormattingHelper.formatDate(countyEffective) %>" />

       <impact:validateInput type="hidden"
                             name="hdndtDtCncntyEnd"
                             value="<%= FormattingHelper.formatDate(countyEnd) %>" />

       <impact:validateInput type="hidden"
                             name="hdnContractFunctionType"
                             value="<%= FormattingHelper.formatString(contractFunctionType) %>" />

       <impact:validateInput type="hidden"
                             name="hdnContractBudgetLimit"
                             value="<%= FormattingHelper.formatString(contractBudgetLimit) %>" />

       <impact:validateInput type="hidden"
                             name="hdnLockedorUnLocked"
                             value="<%= FormattingHelper.formatString(lockedOrUnlocked) %>" />

       <impact:validateInput type="hidden"
                             name="hdnSignedOrUnsigned"
                             value="<%= FormattingHelper.formatString(signedOrUnsigned) %>" />
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>
      <impact:ButtonTag name="btnSave"
                        img="btnSave"
                        align="right"
                        form="frmContractCostRmbrsmntDetail"
                        action="/financials/Contracts/saveContractCostRmbrsmntDetailOrUnitRate"
                        tabIndex="<%= tabIndex++ %>"
                        restrictRepost="true"
                        preventDoubleClick="true"
                        disabled="<%= hideSavePushButton %>"/>
    </td>
  </tr>
</table>
</impact:validateForm>
