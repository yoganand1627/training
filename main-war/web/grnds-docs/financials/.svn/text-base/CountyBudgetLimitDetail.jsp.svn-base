
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  CountyBudgetLimitRetrieveSO output = (CountyBudgetLimitRetrieveSO) request.getAttribute("countyBudgetLimit"); 
  int tabIndex = 1;
  String pageMode = PageModeConstants.EDIT;
  
  String county = ContextHelper.getStringSafe(request, "selCdCounty");
  String program = ContextHelper.getStringSafe(request, "selCdProgram");
  int year = ContextHelper.getIntSafe(request, "txtFiscalYear");
  double budgetAmount = ContextHelper.getMoneyAsDoubleSafe(request, "budgetLimit");
  double amountSpent = ContextHelper.getMoneyAsDoubleSafe(request, "txtAmountSpent");
  double amountObl = ContextHelper.getMoneyAsDoubleSafe(request, "txtAmountObligated");
  double remBal = ContextHelper.getMoneyAsDoubleSafe(request, "txtRemainingBalance");
  
  boolean bOutputNull = false;
  boolean outputNull = output == null;
  if(!outputNull) {
    county = output.getCounty();
    program = output.getProgram();
    year = output.getFiscalYear();
    budgetAmount = output.getBudgetedAmount();
    amountSpent = output.getAmountSpent();
    amountObl = output.getAmountObligated();
    remBal = output.getRemainingBalance();
  }else {
  	bOutputNull = true;
  }
  
%>


<script type="text/javascript" language="JavaScript1.2">

function setRemBal() 
{
      if (document.frmCountyBudgetLimitDetail.hdnBOutputNull.value){
         document.frmCountyBudgetLimitDetail.txtRemainingBalance.value = document.frmCountyBudgetLimitDetail.budgetLimit.value;
       }
       return true;
}
</script>



 
<impact:validateErrors formName="frmCountyBudgetLimitDetail"/>
<impact:validateForm name="frmCountyBudgetLimitDetail"
  method="post"
  action="/financials/CountyBudgetLimit/displayCountyBudgetLimitDetail"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

   
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <tr>
    <th colspan="6">
      County Budget Limit Detail
    </th>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        label="County"
        name="selCdCounty"
        tabIndex="<%= tabIndex++ %>"
        required = "true"
        codesTable="CCOUNT"
        colspan="5"
        disabled="<%= StringHelper.isValid(county) ? "true" : "false" %>"
        value="<%= FormattingHelper.formatString(county) %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        colspan="5"
        label="Program"
        name="selCdProgram"
        tabIndex="<%= tabIndex++ %>"
        codesTable="CPRGAREA"
        required="true"
        disabled="<%= StringHelper.isValid(program) ? "true" : "false" %>"
        value="<%= FormattingHelper.formatString(program) %>"
      />
    </td>
  </tr>
  <tr> 
    <td>
      <impact:validateInput
        type="text"
        label="Fiscal Year"
        constraint="Year"
        name="txtFiscalYear"
        required="true"
        disabled="<%= StringHelper.isValid(FormattingHelper.formatInt(year)) ? "true" : "false" %>"
        value="<%= FormattingHelper.formatInt(year) %>"
        size="4"
        maxLength="4"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        label="Budget Limit"
        name="budgetLimit"
        required="true"
        colspan="3"
        value="<%= FormattingHelper.formatMoney(budgetAmount) %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField
        name="txtAmountSpent"
        label="Amount Spent"
        value="<%= FormattingHelper.formatMoney(amountSpent) %>"
      />
    </td>
    <td>
      <impact:validateDisplayOnlyField
        name="txtAmountObligated"
        label="Amount Obligated"
        value="<%= FormattingHelper.formatMoney(amountObl) %>"
      />
    </td>
    <td>
      <impact:validateDisplayOnlyField
        name="txtRemainingBalance"
        label="Remaining Balance"
        value="<%= FormattingHelper.formatMoney(remBal) %>"
      />
    </td>
  </tr>
</table>
 <input type="hidden" name="hdnCountyBudgetLimitID" value="<%= outputNull ? "" : String.valueOf(output.getIdCountyBudgetLimit()) %>" />
 <input type="hidden" name="hdnDtLastUpdate" value="<%= DateHelper.toISOString(outputNull ? new Date() : output.getDtLastUpdate()) %>" />
 <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>" />
 
 <input type="hidden" name="hdnBOutputNull" value="<%= bOutputNull %>"/>
 
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag
        name="btnSave"
        img="btnSave"
        align="right"
        function="return setRemBal();"
        form="frmCountyBudgetLimitDetail"
        action="/financials/CountyBudgetLimit/saveCountyBudgetLimitDetail"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
</table>
</impact:validateForm>