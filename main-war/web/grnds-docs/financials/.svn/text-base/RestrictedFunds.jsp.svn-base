<%--
JSP Name:     RestrictedFunds.jsp
Created by:   Andrew Goode
Date Created: 02/05/07

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
02/05/07  abgoode           Initial creation (isn't that redundant?)

*/
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RestrictedFundsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.RestrictedFundsConversation"%>

<%
  //String childName = ContextHelper.getStringSafe(request, RestrictedFundsConversation.CHILD_NAME_NAME);
  double checkingBalance = ContextHelper.getMoneyAsDoubleSafe(request, RestrictedFundsConversation.CHECKING_BALANCE_NAME);
  double savingsBalance = ContextHelper.getMoneyAsDoubleSafe(request, RestrictedFundsConversation.SAVINGS_BALANCE_NAME);
  double reservedAmount = ContextHelper.getMoneyAsDoubleSafe(request, RestrictedFundsConversation.RESERVED_AMOUNT_NAME);
  String reservedReason = ContextHelper.getStringSafe(request, RestrictedFundsConversation.RESERVED_REASON_NAME);
  String status = CodesTables.CEVTSTAT_NEW;
  int tabIndex = 1;
  
  BaseSessionStateManager state = RestrictedFundsConversation.getSessionStateManager(request);
  RestrictedFundsSO so = (RestrictedFundsSO) state.getAttribute(RestrictedFundsConversation.RESTRICTED_FUNDS_SO, request);
  if(so != null) {
    //childName = so.getChildName();
    checkingBalance = so.getCheckingBalance();
    savingsBalance = so.getSavingsBalance();
    reservedAmount = so.getReservedAmount();
    reservedReason = so.getReservedReason();
    status = so.getStatus();
  }
%>
<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  window.onbeforeunload = function() {
    IsDirty();
  }
</script>
<impact:validateErrors/>
<impact:validateForm
  name="<%= RestrictedFundsConversation.FORM_NAME %>"
  method="post"
  action="/financials/RestrictedFunds/display"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.RestrictedFundsCustomValidation"
  pageMode="<%= PageMode.getPageMode(request) %>"
  schema="/WEB-INF/Constraints.xsd"
>
<%
  if(CodesTables.CEVTSTAT_PEND.equals(status) || CodesTables.CEVTSTAT_APRV.equals(status)) {
%>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td>
      <impact:ButtonTag
        name="<%= RestrictedFundsConversation.APPROVAL_STATUS_BUTTON_NAME %>"
        action="/workload/ApprovalStatus/displayStatus"
        img="btnApprovalStatus"
        form="<%= RestrictedFundsConversation.FORM_NAME %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
</table>
<br>
<%
}
%> 
  <table width="100%" class="tableBorder" cellspacing="0" cellpadding="3" border="0">
    <tr>
      <th colspan="4">Restricted Funds</th>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField
          name="<%= RestrictedFundsConversation.CHECKING_BALANCE_NAME %>"
          label="Checking Balance"
          value="<%= FormattingHelper.formatMoney(checkingBalance) %>"
        />
      </td>
      <td>
        <impact:validateDisplayOnlyField
          name="<%= RestrictedFundsConversation.SAVINGS_BALANCE_NAME %>"
          label="Savings Balance"
          value="<%= FormattingHelper.formatMoney(savingsBalance) %>"
        />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput
          type="text"
          name="<%= RestrictedFundsConversation.RESERVED_AMOUNT_NAME %>"
          label="Reserved Amount"
          required="true"
          constraint="Money"
          maxLength="10"
          size="10"
          value="<%= FormattingHelper.formatMoney(reservedAmount) %>"
          editableMode="<%= EditableMode.MODIFY %>"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
      <td>
        <impact:validateInput
          type="text"
          name="<%= RestrictedFundsConversation.RESERVED_REASON_NAME %>"
          label="Reserved Reason"
          conditionallyRequired="true"
          constraint="Paragraph50"
          maxLength="50"
          size="30"
          value="<%= FormattingHelper.formatString(reservedReason) %>"
          editableMode="<%= EditableMode.MODIFY %>"
          tabIndex="<%= tabIndex++ %>"
        />
        <%-- impact:validateTextArea
          name="<%= RestrictedFundsConversation.RESERVED_REASON_NAME %>"
          label="Reserved Reason"
          cols="25"
          rows="2"
          maxLength="50"
          conditionallyRequired="true"
          constraint="Paragraph50"
          editableMode="<%= EditableMode.MODIFY %>"
          tabIndex="<%= tabIndex++ %>"
        ><%= FormattingHelper.formatString(reservedReason) %></impact:validateTextArea --%>
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField
          name="<%= RestrictedFundsConversation.STATUS_NAME %>"
          label="Status"
          colspan="3"
          value="<%= Lookup.simpleDecodeSafe(CodesTables.CEVTSTAT, status) %>"
        />
      </td>
      <%-- td>
        <impact:validateDisplayOnlyField
          name="<%= RestrictedFundsConversation.CHILD_NAME_NAME %>"
          label="Child's Name"
          value="<%= FormattingHelper.formatString(childName) %>"
        />
      </td --%>
    </tr>
  </table>
  <table width="100%">
    <tr>
      <td class="alignRight">
        <impact:ButtonTag
          name="<%= RestrictedFundsConversation.SAVE_BUTTON_NAME %>"
          action="/financials/RestrictedFunds/save"
          img="btnSave"
          form="<%= RestrictedFundsConversation.FORM_NAME %>"
          editableMode="<%= EditableMode.MODIFY %>"
          tabIndex="<%= tabIndex++ %>"
        />
        <impact:ButtonTag
          name="<%= RestrictedFundsConversation.SAVE_SUBMIT_BUTTON_NAME %>"
          action="/financials/RestrictedFunds/saveAndSubmit"
          img="btnSaveAndSubmit"
          form="<%= RestrictedFundsConversation.FORM_NAME %>"
          editableMode="<%= EditableMode.MODIFY %>"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
    </tr>
  </table>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>