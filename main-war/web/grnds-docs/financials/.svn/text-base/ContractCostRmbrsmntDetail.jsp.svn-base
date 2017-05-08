<%
//*   JSP Name:     ContractSearch.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 02/10/2003
//*
//*  The Cost Reimbursement Detail window will be used by
//*  contract managers and technicians to maintain or
//*  view budget information about a service line item.
//*
//*
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  02/25/2003  Eric Dickman      Created initial docuement.
//**  06/26/2003  Eric Dickman      SIR 18511 -- Fixed how totalAmountUsed computed.
//**  9/15/2003   Eric Dickman      SIR 19791 -- The Supply Used was not added
//**                                to the totalAmountUsed.
//**  01/21/2003  corleyan      SIR 22577 - Attach custom validation to this page.
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

    ROWCCON11SOG00 rowccon11sog00 = (ROWCCON11SOG00) request.getAttribute("rowccon11sog00");
    int tabIndex = 1;


    //getting the required parameters out of the request
    int resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource");

    org.exolab.castor.types.Date countyEffective =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEffective"));

    org.exolab.castor.types.Date countyEnd =
        DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEnd"));

    String contractFunctionType = ContextHelper.getStringSafe(request, "hdnContractFunctionType");
    String contractBudgetLimit = ContextHelper.getStringSafe(request, "hdnContractBudgetLimit");
    //String pageModeForContractList = ContextHelper.getStringSafe(request, "hdnPageMode");
    String lockedOrUnlocked = ContextHelper.getStringSafe(request, "hdnLockedorUnLocked");
    String signedOrUnsigned = ContextHelper.getStringSafe(request, "hdnSignedOrUnsigned");

    //Sets page mode to Edit
    String pageMode = PageMode.getPageMode( request );

    //Variables for page mode
    String hideSalaryAmt = null;
    String hideFringeAmt = null;
    String hideTravelAmt = null;
    String hideSupplyAmt = null;
    String hideEquipmentAmt = null;
    String hideOtherAmt = null;
    String hideSavePushButton = null;

    if ("Y".equals(lockedOrUnlocked) )
    {
      hideSalaryAmt = "true";
      hideFringeAmt = "true";
      hideTravelAmt = "true";
      hideSupplyAmt = "true";
      hideEquipmentAmt = "true";
      hideOtherAmt = "true";
      hideSavePushButton = "true";
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
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractCostRmbrsmentDetailCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <th colspan="5">
    Cost Reimbursement Detail
  </th>
  <tr>
    <td width="25%"/>
    <td width="23%"/>
    <td width="6%"/>
    <td width="25%"/>
    <td width="23%"/>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField name="version"
                                       label="Version"
                                       value="<%= FormattingHelper.formatInt( GlobalData.getUlNbrCnverVersion( request )) %>" />
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="szCdCnsvcService"
                                       label="CSLI"
                                       value="<%= FormattingHelper.formatInt(rowccon11sog00.getUlNbrCnsvcLineItem())%>" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text"
                            label="Salary Amount"
                            name="ulAmtCnsvcSalary"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcSalary()) %>"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideSalaryAmt %>"
                            maxLength="12"
                            constraint="Money"/>
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcSalaryUsed"
                                       label="Salary Amount Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcSalaryUsed()) %>" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text"
                            label="Fringe Amount"
                            name="ulAmtCnsvcFrgBenft"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcFrgBenft()) %>"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideFringeAmt %>"
                            maxLength="12"
                            constraint="Money"/>
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcFrgBenftUsed"
                                       label="Fringe Amount Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcFrgBenftUsed()) %>" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text"
                            label="Travel Amount"
                            name="ulAmtCnsvcTravel"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcTravel()) %>"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideTravelAmt %>"
                            maxLength="12"
                            constraint="Money"/>
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcTravelUsed"
                                       label="Travel Amount Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcTravelUsed()) %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text"
                            label="Supply Amount"
                            name="ulAmtCnsvcSupply"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcSupply()) %>"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideSupplyAmt %>"
                            maxLength="12"
                            constraint="Money"/>
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcSupplyUsed"
                                       label="Supply Amount Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcSupplyUsed()) %>" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text"
                            label="Equipment Amount"
                            name="ulAmtCnsvcEquip"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcEquip()) %>"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideEquipmentAmt %>"
                            maxLength="12"
                            constraint="Money"/>
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcEquipUsed"
                                       label="Equipment Amount Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcEquipUsed()) %>" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text"
                            label="Other Amount"
                            name="ulAmtCnsvcOther"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcOther()) %>"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideOtherAmt %>"
                            maxLength="12"
                            constraint="Money"/>
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcOtherUsed"
                                       label="Other Amount Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcOtherUsed()) %>" />
    </td>
  </tr>
  <tr>
    <td>
      &nbsp
    </td>
    <td>
      &nbsp
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcOffItemUsed"
                                       label="Off Item Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcOffItemUsed()) %>" />
    </td>
  </tr>
  <tr>
     <td>
      &nbsp
    </td>
    <td>
      &nbsp
    </td>
    <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="ulAmtCnsvcAdminAllUsed"
                                       label="Admin Allocation Used"
                                       value="<%= FormattingHelper.formatMoney(rowccon11sog00.getUlAmtCnsvcAdminAllUsed()) %>" />
    </td>
  </tr>
<%
  //Calculations for Total Amount and Total Amount Used
  double totalAmount = (rowccon11sog00.getUlAmtCnsvcSalary() + rowccon11sog00.getUlAmtCnsvcFrgBenft()
                        + rowccon11sog00.getUlAmtCnsvcTravel() + rowccon11sog00.getUlAmtCnsvcSupply()
                        + rowccon11sog00.getUlAmtCnsvcEquip() + rowccon11sog00.getUlAmtCnsvcOther());

  //SIR 18511 -- Fixed how totalAmountUsed computed.
  //SIR 19791 -- The Supply Used was not added to the totalAmountUsed.
  double totalAmountUsed = (rowccon11sog00.getUlAmtCnsvcSalaryUsed() + rowccon11sog00.getUlAmtCnsvcFrgBenftUsed()
                           + rowccon11sog00.getUlAmtCnsvcTravelUsed()  + rowccon11sog00.getUlAmtCnsvcEquipUsed()
                           + rowccon11sog00.getUlAmtCnsvcOtherUsed()   + rowccon11sog00.getUlAmtCnsvcOffItemUsed()
                           + rowccon11sog00.getUlAmtCnsvcAdminAllUsed()) + rowccon11sog00.getUlAmtCnsvcSupplyUsed();

%>
  <tr>
    <td>
      <impact:validateDisplayOnlyField name="totalAmount"
                                       label="Total Amount"
                                       value="<%= FormattingHelper.formatMoney(totalAmount) %>" />
    </td>
     <td>
      &nbsp
    </td>
    <td>
      <impact:validateDisplayOnlyField name="totalAmountUsed"
                                       label="Total Amount Used"
                                       value="<%= FormattingHelper.formatMoney(totalAmountUsed) %>" />
    </td>
  </tr>
  <%-- Hidden Fields --%>
    <impact:validateInput type="hidden"
                          name="hdnUlAmtCnsvcUnitRate"
                          value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlAmtCnsvcUnitRate()) %>"/>
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
                          value="<%= FormattingHelper.formatDouble(rowccon11sog00.getUlNbrCnsvcUnitRate()) %>"/>
    <% String tsLastUpdate = rowccon11sog00.getTsLastUpdate().toString();  %>
    <impact:validateInput type="hidden"
                          name="hdnTsLastUpdate"
                          value="<%= tsLastUpdate %>"/>

    <impact:validateInput type="hidden"
                          name="hdnUlIdResource"
                          value="<%= FormattingHelper.formatInt(resourceId) %>" />
    <impact:validateInput type="hidden"
                           name="hdnContractFunctionType"
                           value="<%= FormattingHelper.formatString(contractFunctionType) %>" />

    <impact:validateInput type="hidden"
                          name="hdndtDtCncntyEffective"
                          value="<%= FormattingHelper.formatDate(countyEffective) %>" />
    <impact:validateInput type="hidden"
                          name="hdndtDtCncntyEnd"
                          value="<%= FormattingHelper.formatDate(countyEnd) %>" />
    <impact:validateInput type="hidden"
                          name="hdnLockedorUnLocked"
                          value="<%= FormattingHelper.formatString(lockedOrUnlocked) %>" />
    <impact:validateInput type="hidden"
                          name="hdnContractBudgetLimit"
                          value="<%= FormattingHelper.formatString(contractBudgetLimit) %>" />
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



