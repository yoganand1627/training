<%--
/**    PymntHistory.jsp
 *    Created by:  Jeff Chambers
 *    02/06/03
**/
--%>
<%
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
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%-- Import Java classes --%>
<%@ page import="java.util.Enumeration" %>
<%-- Import xmlstructs --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00" %>
<%-- Import architecture classes --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%-- Import State Management classes --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%-- Import needed for Messages --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%-- Import needed for Form Launch --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
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
%>


<script type="text/javascript" language="JavaScript1.2">
function submitInvoicDetail ( invoiceId )
{
  frmPaymentHistory.hdnTxtUlIdInvoInvoice.value = invoiceId;
  submitValidateForm( "frmPaymentHistory", "/financials/PymntHistorySearch/displayInvoiceDetail" );
}
function setHiddenReportParams( invoiceId )
{
  frmPaymentHistory.hdnInvoiceIdReportParam.value = invoiceId;
}

function createReportParameterList()
{
  var bRowSelect = checkForSelection();
  if( !bRowSelect )
  {
    setInformationalMessage( "<%=MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>" );
    return false;
  }
  else
  {
    setReportParameters( "invoiceId", frmPaymentHistory.hdnInvoiceIdReportParam.value );
  }
}

// check to see if a radio button is selected for new using
function checkForSelection()
{
  var x = document.frmPaymentHistoryResults;
  var radioButtonChecked = false;
  var bBreakOutOfLoop = false;
  sTmp2 = new String("");
  for(var i=0; i < x.elements.length ; i++)
  {
    sElementName = new String(x.elements[i].name);
    if( x.elements[i].type == "radio" && sElementName.substring(0,10) == "rbRowIndex")
    {
      bBreakOutOfLoop = true;
      for(var i=0; i < x.rbRowIndex.length ; i++)
      {
        if(x.rbRowIndex[i].checked == true)
        {
          radioButtonChecked = true;
          break;
        }
      }
    }
    if(bBreakOutOfLoop) break;
  }

  if(!bBreakOutOfLoop)
  {
    radioButtonChecked = true;
  }
  return radioButtonChecked;
}
</script>

<impact:validateForm name="frmPaymentHistory"
   method="post"
   action="/financials/PymntHistorySearch/searchPaymentHistory"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.PymntHistorySearchCustomValidation"
   pageMode="<%= pageMode %>"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">
<impact:validateErrors formName="frmPaymentHistory"/>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnInvoiceIdReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="hdnTxtUlIdInvoInvoice" value=""/>

<!--- Begin Detail Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Payment History Search</th>
  </tr>
  <tr>
    <td class="formInput">&nbsp;Search For:</td>
    <td colspan="5">
        <impact:validateInput
          type="radio"
          disabled=""
          label="Client"
          id="Client"
          name="rbUlScrFinPayhistId"
          value="client"
          cssClass="formInput"
          checked="<%= client %>"
          tabIndex="<%= tabIndex++ %>"
        />
        <impact:validateInput
          type="radio"
          disabled=""
          label="Resource"
          id="Resource"
          name="rbUlScrFinPayhistId"
          value="resource"
          cssClass="formInput"
          checked="<%= resource %>"
          tabIndex="<%= tabIndex++ %>"
        />
        <%--SIR 13891 - added contract search --%>
        <impact:validateInput
          type="radio"
          disabled=""
          label="Contract"
          id="Contract"
          name="rbUlScrFinPayhistId"
          value="contract"
          cssClass="formInput"
          checked="<%= contract %>"
          tabIndex="<%= tabIndex++ %>"
        /><%--13891--%>
    </td>
  </tr>
  <tr>
    <td width="15%">
      <impact:validateInput
        width="17%"
        type="text"
        label="Search ID"
        constraint="ID"
        required="true"
        name="txtUlSrcFinPayhistId"
        cssClass="formInput"
        value="<%= searchId %>"
        disabled="<%= disablePaymentHistory %>"
        size="10"
        maxLength="10"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td width="10%">
      <impact:validateDate
        width="20%"
        label="From"
        constraint="Date"
        required="true"
        name="txtDtSrcNbrFinPayhistFrom"
        value="<%= fromDate %>"
        disabled="<%= disablePaymentHistory %>"
        size="8"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td width="10%">
      <impact:validateDate
        label="To"
        constraint="Date"
        required="true"
        name="txtDtSrcDtFinPayhistTo"
        value="<%= toDate %>"
        disabled="<%= disablePaymentHistory %>"
        size="8"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        name="selRegion"
        label="Region"
        codesTable="<%= CodesTables.CREGIONS %>"
        value="<%= region %>"
        disabled="<%= disablePaymentHistory %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateSelect
        name="selCounty"
        label="County"
        codesTable="<%= CodesTables.CCOUNT %>"
        value="<%= county %>"
        disabled="<%= disablePaymentHistory %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td colspan="2"/>
  </tr>
<%
  if(isClientSearch && noErrorMessages){
%>
  <tr>
    <td>
      <impact:validateDisplayOnlyField
        name="dspNmClient"
        label="Client Name"
        value="<%= FormattingHelper.formatString(clientName) %>"
        colspan="3"
      />
    </td>
    <td colspan="2"/>
  </tr>
<%
  }
%>
</table>

<%--Search Button--%>
<% if ("false".equalsIgnoreCase(disablePaymentHistory)) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag name="btnSearch" img="btnSearch" align="right" form="frmPaymentHistory" action="/financials/PymntHistorySearch/searchPaymentHistory" tabIndex="<%= tabIndex++ %>" backSafe="false"/>
    </td>
  </tr>
</table>
<% } /* Close the if to hide search button */ %>

<%-- Result Set for Invoice Search --%>
<br/>
</impact:validateForm>


<impact:validateForm name="frmPaymentHistoryResults"
   method="post"
   action="/financials/PymntHistorySearch/searchPaymentHistory"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.PymntHistorySearchCustomValidation"
   pageMode="<%= pageMode %>"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">
<impact:validateErrors formName="frmPaymentHistoryResults"/>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnInvoiceIdReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="hdnTxtUlIdInvoInvoice" value=""/>

<%
  double amount = 0.00;

if( noErrorMessages )
{
%>
<%--SIR 13891 - only show pagination if there are no errors--%>
<impact:pagination saveState="true" submitUrl="/financials/PymntHistorySearch/searchPaymentHistory">
<%
  // If Client Flag set in the searchPaymentHistory() is set to Y display the client section
  // else, display the Resource/Contract section
  boolean href = "false".equalsIgnoreCase(disablePaymentHistory);
  if (isClientSearch)
  {
%>
    <!--- Begin display for Client results --->
    <div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>
    <%--/*table width="100%" cellspacing="0" cellpadding="3" class="tableborder" border="0">
      <tr>
        <td class="tableBG"*/--%>
        <div id="horizontalScrollResults" style="height:200px; width:762px; overflow:auto" class="tableborderList">
          <table width="1200" cellspacing="0" cellpadding="3" class="tableborder" border="0">
            <tr>
              <%-- th class="thList">&nbsp;</th --%>
              <th class="thList">Check Date</th>
              <th class="thList">Check #</th>
              <th class="thList">Invoice ID</th>
              <th class="thList">Resource Name</th>
              <th class="thList">County</th>
              <th class="thList">Svc</th>
              <th class="thListRight">Qty</th>
              <th class="thListRight">UT</th>
              <th class="thListRight">Amount</th>
              <%-- th class="thListRight">DLV</th --%>
              <th class="thListRight">Rate</th>
              <%-- th class="thList">Income</th>
              <th class="thList">Fee Paid</th --%>
              <th class="thListRight">From</th>
              <th class="thListRight">To</th>
             </tr>
<%
    Enumeration e = paymentHistoryArray.enumerateROWCFIN21SOG00();
    //Display the results if the array is not empty
    if (!e.hasMoreElements())
    {
%>
      <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
        <td colspan="12"><%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED )%></td>
      </tr>
<%  }
    else
    {
      while (e.hasMoreElements())
      {
        ROWCFIN21SOG00 paymentDetail = (ROWCFIN21SOG00)e.nextElement();
        
        // Amount calculation ( ( Rate * Qty ) - Income - Fee )
        amount = (( paymentDetail.getDAmtSvcDtlUnitRate() * paymentDetail.getSNbrSvcDtlUnitQty() ) - paymentDetail.getDAmtSvcDtlIncome() - paymentDetail.getDAmtSvcDtlFeePaid() );
        invoiceId = paymentDetail.getUlIdInvoInvoice();
        //String onClickFunction =  "setHiddenReportParams('" + invoiceId + "');";
%>
        <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
          <%-- what is the point of the radio button? --%>
          <%-- td><impact:validateInput type="radio" name="rbRowIndex" disabled="" onClick="<%= onClickFunction %>" label="" id="RowIndex" value="" cssClass="formInput" checked="" tabIndex="<%= tabIndex++ %>"/></td --%>
          <td><%= FormattingHelper.formatDate(paymentDetail.getDtDtInvoWarrantDate()) %></td>
          <td><%= FormattingHelper.formatString(paymentDetail.getSzNbrInvoWarrant()) %></td>
<%      if (href)
        {
%>
          <td><a href="javascript:disableValidation('frmPaymentHistoryResults'); submitInvoicDetail( '<%= invoiceId %>')"><%= invoiceId %></a></td>
<%      }
        else
        {
%>
          <td><%= invoiceId %></td>
<%      }
%>
        <td><%= FormattingHelper.formatString(paymentDetail.getSzNmResource()) %></td>
        <td><%= Lookup.simpleDecodeSafe(CodesTables.CCOUNT, paymentDetail.getSzCdCounty()) %></td>
        <td><%= FormattingHelper.formatString(paymentDetail.getSzCdSvcDtlService()) %></td>
        <td class="alignRight"><%= FormattingHelper.formatDouble(paymentDetail.getSNbrSvcDtlUnitQty(), 1) %></td>
        <td class="alignRight"><%= FormattingHelper.formatString(paymentDetail.getSzCdSvcDtlUnitType()) %></td>
        <td class="alignRight"><%= FormattingHelper.formatMoney(amount) %></td>
        <%-- td class="alignRight"><%= FormattingHelper.formatString(paymentDetail.getSzCdPaymentDelivery()) %></td --%>
        <td class="alignRight"><%= FormattingHelper.formatMoney(paymentDetail.getDAmtSvcDtlUnitRate()) %></td>
        <%-- td><%= FormattingHelper.formatMoney(paymentDetail.getDAmtSvcDtlIncome()) %></td>
        <td><%= paymentDetail.getDAmtSvcDtlFeePaid() %></td --%>
        <td class="alignRight"><%= FormattingHelper.formatInt(paymentDetail.getSNbrSvcDtlFromDay()) %></td>
        <td class="alignRight"><%= FormattingHelper.formatInt(paymentDetail.getSNbrSvcDtlToDay()) %></td>
        </tr>
<%
        loopCount++;
      } /* Close the while */
%>

<%
    } /* Close the else(there are rows) */
%>
           </table>
         </div>
       <%--/*/td>
    </tr>
</table*/--%>

<!--- End display for Client results --->
<%}
  else if ("N".equals(clientFlag))
  {
%>
    <!--- Begin display for Resource or Contract results --->
    <div id="scrollBar2" style="height:200px;width:100%;overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" class="tableborder" border="0">
      <tr>
         <%-- th class="thList">&nbsp;</th --%>
         <th class="thList">Check Date</th>
         <th class="thList">Check #</th>
         <th class="thList">Invoice ID</th>
         <th class="thList">Resource Name</th>
         <th class="thList">County</th>
         <th class="thListRight">Amount</th>
         <%-- th class="thList">DLV</th --%>
      </tr>
<%
    Enumeration e = paymentHistoryArray.enumerateROWCFIN21SOG00();
    //Display the results if the array is not empty
    if (!e.hasMoreElements())
    {
%>
      <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
        <td colspan="6"><%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED )%></td>
      </tr>
<%
    }
    else
    {
      while (e.hasMoreElements())
      {
        ROWCFIN21SOG00 paymentDetail = (ROWCFIN21SOG00)e.nextElement();
        amount = paymentDetail.getDAmtInvoValidAmount();
        invoiceId = paymentDetail.getUlIdInvoInvoice();
        //String onClickFunction =  "setHiddenReportParams('" + invoiceId + "');";
%>
        <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
          <%-- td width="5"><impact:validateInput type="radio" name="rbRowIndex" disabled="" onClick="<%= onClickFunction %>" label="" id="RowIndex" value="" cssClass="formInput" checked="" tabIndex="<%= tabIndex++ %>"/></td --%>
          <td><%= FormattingHelper.formatDate(paymentDetail.getDtDtInvoWarrantDate()) %></td>
          <td><%= FormattingHelper.formatString(paymentDetail.getSzNbrInvoWarrant()) %></td>
<%      if (href)
        {
%>
          <td><a href="javascript:disableValidation('frmPaymentHistoryResults'); submitInvoicDetail( '<%= invoiceId %>')"><%= FormattingHelper.formatInt(invoiceId) %></a></td>
<%      }
        else
        {
%>
           <td><%= FormattingHelper.formatInt(invoiceId) %></td>
<%      }
%>
          <td><%= FormattingHelper.formatString(paymentDetail.getSzNmResource()) %></td>
          <td><%= Lookup.simpleDecodeSafe(CodesTables.CCOUNT, paymentDetail.getSzCdCounty()) %></td>
          <td class="alignRight"><%= FormattingHelper.formatMoney(amount) %></td>
          <%-- td><%= FormattingHelper.formatString(paymentDetail.getSzCdPaymentDelivery()) %></td --%>
        </tr>
<%
        loopCount++;
      } /* Close the while */
%>

<!--- End display for Resource or Contract results --->
<%  } /* Close the else (there are rows) */
%>
</table>
</div>
<%
  } /* Close the else if the Client Flag == "N" */
%>


<%
if (hideReportBtn == false)
{
%>
  <table width="100%" cellspacing="0" cellpadding="3" border="0">
    <tr>
      <td class="alignRight" width="800">Total Payments: </td>
      <td width="200"><%= FormattingHelper.formatMoney(total) %></td>
    </tr>
  </table>
<%
}
%>
</impact:pagination>
<%
} //SIR 13891 - moved this to not show the payments if there are errors in the
  //search
%>
</impact:validateForm>

<!--- End Detail Table --->
