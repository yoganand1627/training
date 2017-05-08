<%
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
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CCON13SI"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractsConversation"%>
<%
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
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

  //Confirm on Exit Message
  window.onbeforeunload = function ()
  {
    IsDirty();
  }

<% if ( "A".equals( dataAction ) )
  {

%>

  window.onload = function ()
  {
    onChangePaymentType();
  }
<%
  }
%>
//fucntion gives the Select All and Deselect All push buttons functionality
function selectAllDisplayedCounties( action )
{
 var numOfCheckboxes = <%= countryListResultsArray.getROWCCON13SOGCount() %>;
   var checkboxField;
   for ( i = 1; i <= numOfCheckboxes; i++ )
   {
     checkboxField = eval("document.frmContractServiceDetail.cbxCounty_" + i);

     if(checkboxField.checked != action)
     {
       checkboxField.checked = action;
       checkboxField.fireEvent("onclick");
     }
   }
}

//Fix for SIR 14564
//SIR 17740 The Unit Rate is protected when the Payment Type is Cost Reimbursement.

function onChangePaymentType()
{
   if(frmContractServiceDetail.szNbrCnsvcPaymentType.value == 'VUR')
   {
     frmContractServiceDetail.szNbrCnsvcUnitType.value = 'ONE';
     frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;
     frmContractServiceDetail.ulNbrCnsvcUnitRate.disabled = false;
   }
   else if (frmContractServiceDetail.szNbrCnsvcPaymentType.value == 'CRM')
   {
     frmContractServiceDetail.ulNbrCnsvcUnitRate.disabled = true;
     frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;
     frmContractServiceDetail.szNbrCnsvcUnitType.value = '';
   }
   else
   {
     frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;
     frmContractServiceDetail.ulNbrCnsvcUnitRate.disabled = false;
   }
}

function enableUnitType()
{
  frmContractServiceDetail.szNbrCnsvcUnitType.disabled = false;
}
</script>
<impact:validateErrors/>

<impact:validateForm name="frmContractServiceDetail"
  method="post"
  action="/financials/Contracts/displayContractServiceDetail"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractDetailCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
<%-- /* Hidden Fields */ --%>
      <impact:validateInput type="hidden"
                            name="hdnLastUpdate"
                            value="<%= hdnFldLastUpdate %>"  />
      <impact:validateInput type="hidden"
                            name="hdnIdPerson"
                            value="<%= FormattingHelper.formatInt( GlobalData.getUlIdPerson( request ) )%>"  />
      <impact:validateInput type="hidden"
                            name="hdnUlIdCnsvc"
                            value="<%= FormattingHelper.formatInt(contractDetailRow.getUlIdCnsvc())%>"  />
      <impact:validateInput type="hidden"
                            name="hdndtDtCncntyEffective"
                            value="<%= FormattingHelper.formatDate(countyEffective) %>" />
      <impact:validateInput type="hidden"
                            name="hdndtDtCncntyEnd"
                            value="<%= FormattingHelper.formatDate(countyEnd) %>" />
      <impact:validateInput type="hidden"
                            name="hdnszCdScrDataAction"
                            value="<%= FormattingHelper.formatString(dataAction) %>" />
      <impact:validateInput type="hidden"
                            name="hdnUlIdResource"
                            value="<%= FormattingHelper.formatInt(resourceId) %>" />
      <impact:validateInput type="hidden"
                            name="hdnCdRsrcSvcService"
                            value="<%= FormattingHelper.formatString(service) %>" />
      <impact:validateInput type="hidden"
                            name="hdnContractBudgetLimit"
                            value="<%= FormattingHelper.formatString(contractBudgetLimit) %>" />
      <impact:validateInput type="hidden"
                            name="hdnContractFunctionType"
                            value="<%= FormattingHelper.formatString(contractFunctionType) %>" />
      <impact:validateInput type="hidden"
                            name="ulIdResource"
                            value="<%= FormattingHelper.formatInt(resourceId) %>" />
      <impact:validateInput type="hidden"
                            name="hdnSignedOrUnsigned"
                            value="<%= FormattingHelper.formatString(signedOrUnsigned) %>" />
      <impact:validateInput type="hidden"
                            name="hdnLockedorUnLocked"
                            value="<%= FormattingHelper.formatString(lockedOrUnlocked) %>" />
      <impact:validateInput type="hidden"
                            name="hdnUlAmtCnsvcUnitRate"
                            value="<%= FormattingHelper.formatMoney(contractDetailRow.getUlAmtCnsvcUnitRate()) %>" />
      <impact:validateInput type="hidden"
                            name="hdnContractVersion"
                            value="<%= FormattingHelper.formatInt( GlobalData.getUlNbrCnverVersion( request ))  %>" />
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <tr>
    <th colspan="4">
      Contract Service Detail
    </th>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField name="versions"
                                       label="Version"
                                       value="<%= FormattingHelper.formatInt( GlobalData.getUlNbrCnverVersion( request )) %>" />

     </td>
    <td>
      <impact:validateDisplayOnlyField name="dspUlNbrCnsvcLineItem"
                                       label="CSLI"
                                       value="<%= FormattingHelper.formatInt(contractDetailRow.getUlNbrCnsvcLineItem() )%>" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateSelect tabIndex="<%= tabIndex++ %>"
                             value="<%= contractDetailRow.getSzCdCnsvcService() %>"
                             name="szNbrCnsvcService"
                             label="Service"
                             options="<%= serviceOptions %>"
                             required="true"
                             blankValue="true"
                             onChange="setIsDirtyCalled(true); disableValidation('frmContractServiceDetail'); submitValidateForm('frmContractServiceDetail', '/financials/Contracts/redisplayContractServiceDetail');"
                             disabled="<%= hideService %>"/>
    </td>
    <td>
      <impact:validateSelect tabIndex="<%= tabIndex++ %>"
                             value="<%= contractDetailRow.getSzCdCnsvcPaymentType() %>"
                             name="szNbrCnsvcPaymentType"
                             label="Payment Type"
                             codesTable="CCONPAY"
                             onChange="javascript:onChangePaymentType()"
                             required="true"
                             blankValue="true"
                             disabled="<%= hidePaymentType %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateSelect tabIndex="<%= tabIndex++ %>"
                             value="<%= contractDetailRow.getSzNbrCnsvcUnitType() %>"
                             name="szNbrCnsvcUnitType"
                             label="Unit Type"
                             codesTable="CCONUNIT"
                             required="true"
                             blankValue="true"
                             disabled="<%= hideUnitType %>"
                             />
    </td>
    <td>
      <impact:validateInput type="text"
                            label="Unit Rate"
                            name="ulNbrCnsvcUnitRate"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatMoney( contractDetailRow.getUlNbrCnsvcUnitRate() ) %>"
                            constraint="Money"
                            conditionallyRequired="true"
                            tabIndex="<%= tabIndex++ %>"
                            disabled="<%= hideUnitRate %>"
                            maxLength="10" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text"
                            label="Federal Match"
                            name="ulNbrCnsvcFedMatch"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatInt(contractDetailRow.getUlNbrCnsvcFedMatch())  %>"
                            constraint="Digit3Less"
                            tabIndex= "<%= tabIndex++ %>"
                            disabled="<%= hideFederdalMatch %>"
                            size="3"
                            maxLength="3"/>
    </td>
    <td>
      <impact:validateInput type="text"
                            label="Local Match"
                            name="ulNbrCnsvcLocalMatch"
                            cssClass="formInput"
                            value="<%= FormattingHelper.formatInt(contractDetailRow.getUlNbrCnsvcLocalMatch()) %>"
                            constraint="Digit3Less"
                            tabIndex= "<%= tabIndex++%>"
                            disabled="<%= hideLocalMatch %>"
                            size="3"
                            maxLength="3"/>
    </td>
  </tr>
</table>
<br>

<%
if ("Y".equals(countyList))
{
%>
<div id="scrollBar" style="height:175;width:100%;overflow:auto" class="tableBorderList">
  <table border="0" cellspacing="0" cellpadding="3" width="100%" >
    <tr class="thList">
      <td width="5%">
        &nbsp;
      </td>
      <td>
        Code
      </td>
      <td>
        County
      </td>
    </tr>
<%
     //set checkbox counter equal to 1
     int cbxLoopCount = 1;

     //Enumeration through enumerateROWCCON13SOG to get checked values
     Enumeration countryListResultsEnumeration = countryListResultsArray.enumerateROWCCON13SOG();

     //setting ROWCCON13SOG equal to null
     ROWCCON13SOG countryListResultsRow = null;

     //if the enumeration is empty return NO Rows returned message
     if ( !countryListResultsEnumeration.hasMoreElements() )
     {
%>
  <tr class="odd">
    <td colspan="5">
      <% hideSelectAllPushButton = "true"; %>
      <%= MessageLookup.getMessageByNumber(Messages.MSG_CON_NO_COUNTY) %>
    </td>
  </tr>
<%
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
%>
  <tr>
    <td>
      <impact:validateInput type="checkbox"
                            name="<%= cbxFieldName %>"
                            checked="<%= isCountyChecked %>"
                            value="<%=( countryListResultsRow.getSzCdCncntyCounty() )%>"
                            disabled="<%= hideCountyListCbx %>"
                            tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td>
      <%= countryListResultsRow.getSzCdCncntyCounty() %>
    </td>

    <td>
      <%=Lookup.simpleDecodeSafe("CCOUNT", countryListResultsRow.getSzCdCncntyCounty() ) %>
    </td>
  </tr>
<%
     //add one to the loop count
     cbxLoopCount++;
       }
         //end of while
     }
//end of if statement
%>
  </table>
</div>
<%
}//end if ( for hiding the county list when a user enters the page in add mode);
%>
<% /* this is where the "scrollBar" div tag ends */ %>
<%
//will display the SelectAllPushButton and DeselectAllPushButton

//SIR 17750 -- Added the following logic to the Select and Deselect push button
//if statement.  Check to see if the Version is Locked or Unlocked.

if (("false".equals(hideSelectAllPushButton) && ("false").equals(hideDeselectAllPushButton) && "N".equals( lockedOrUnlocked )))
{
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td width="80%">
      &nbsp;
    </td>
    <td align="right" width="10%">
      <a onclick="JavaScript:selectAllDisplayedCounties( true );" tabIndex="<%= tabIndex++ %>">
        <img src="/grnds-docs/images/shared/btnSelectAll.gif" />
      </a>
    </td>
    <td align="right" width="10%">
      <a onclick="JavaScript:selectAllDisplayedCounties( false );" tabIndex="<%= tabIndex++ %>">
        <img src="/grnds-docs/images/shared/btnDeselectAll.gif" />
      </a>
    </td>
  </tr>
</table>
<%
}
//end if(diplay hideSelectAllPushButton and hideSelectAllPushButton)

%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td width="90%">
      &nbsp;
    </td>
    <td width="10%">
      <impact:ButtonTag name="btnSave"
                        img="btnSave"
                        align="right"
                        form="frmContractServiceDetail"
                        function="enableUnitType()"
                        action="/financials/Contracts/saveContractServiceDetail"
                        tabIndex="<%= tabIndex++ %>"
      restrictRepost="true"
      preventDoubleClick="true"
                        disabled="<%= hideSavePushButton %>"/>
    </td>
  </tr>
</table>
</impact:validateForm>


