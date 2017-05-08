<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.CountyBudgetLimitSearchConversation" %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

  //Forwards the user to the Contract Header page via the add push button or
  // the hyperlink in the pagination section.
  function submitCountyBudgetID( countyBudgetLimitID)
  {
          document.frmCountyBudgetLimitSearchResults.hdnCountyBudgetLimitID.value = countyBudgetLimitID;
          submitValidateForm('frmCountyBudgetLimitSearchResults', '/financials/CountyBudgetLimit/forwardCountyBudgetLimitDetail');
  }
</script>

<%
    BaseSessionStateManager state = CountyBudgetLimitSearchConversation.getSessionStateManager(request);
    String disabledAddButton = "true";
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile.hasRight(UserProfile.SEC_MODIFY_COUNTY_BUDGET_LIMIT)){
      disabledAddButton = "false";
    }
    //Sets page mode to Edit
    String pageMode = PageModeConstants.EDIT;
    int tabIndex = 1;
    String county = ContextHelper.getStringSafe(request, "selCdCounty");
    String program = ContextHelper.getStringSafe(request, "selCdProgram");
    String fiscalYear = ContextHelper.getStringSafe(request, "txtFiscalYear");
    List<CountyBudgetLimitRetrieveSO> list1 = 
      (List<CountyBudgetLimitRetrieveSO>)state.getAttribute(CountyBudgetLimitSearchConversation.SEARCH_RESULTS, request);
%>
<impact:validateErrors formName="frmCountyBudgetLimitSearch"/>
<impact:validateForm name="frmCountyBudgetLimitSearch"
  method="post"
  defaultButton="<%= String.valueOf(list1 == null) %>"
  action="/financials/CountyBudgetLimit/displayCountyBudgetLimitSearch"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.CountyBudgetLimitSearchCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <tr>
    <th colspan="4">
      County Budget Limit Search
    </th>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        label="County"
        name="selCdCounty"
        tabIndex="<%= tabIndex++ %>"
        conditionallyRequired="true"
        codesTable="<%= CodesTables.CCOUNT %>"
        value="<%= county %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        label="Fiscal Year"
        constraint="Year"
        name="txtFiscalYear"
        value="<%= fiscalYear %>"
        size="4"
        maxLength="4"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        label="Program"
        name="selCdProgram"
        tabIndex="<%= tabIndex++ %>"
        codesTable="<%= CodesTables.CPRGAREA %>"
        colspan="3"
        conditionallyRequired="true"
        value="<%= program %>"
      />
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
    <td>
      <impact:ButtonTag
        name="btnSearch"
        img="btnSearch"
        align="right"
        form="frmCountyBudgetLimitSearch"
        action="/financials/CountyBudgetLimit/searchCountyBudgetLimit"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
</table>
</impact:validateForm>
<%
  if(list1 != null) {
%>
<impact:validateForm name="frmCountyBudgetLimitSearchResults"
  method="post"
  action="/financials/CountyBudgetLimit/displayCountyBudgetLimitSearch"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<impact:validateErrors formName="frmCountyBudgetLimitSearchResults"/>

<impact:validateInput type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
<impact:validateInput type="hidden" name="hdnCountyBudgetLimitID"/>

<table width="100%" cellspacing="0" cellpadding="3" class="tableborder">
      <tr>
         <td class="tableBG">
           <table width="100%" cellspacing="0" cellpadding="3" border="0">
           <tr>
             <th class="thList">Program</th>
             <th class="thList">County</th>
             <th class="thList">Budgeted Amount</th>
             <th class="thList">Amount Spent</th>
             <th class="thList">Amount Obligated</th>
             <th class="thList">Remaining Balance</th>
           </tr>
  <%
    int loopCount = 0;
    CountyBudgetLimitRetrieveSO countyBudgetSearchRow = null;
    Iterator<CountyBudgetLimitRetrieveSO> iterator = list1.iterator();

    if ( list1.size()==0)
{
  %>
            <tr class="odd">
              <td colspan="6">
                <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
              </td>
            </tr>
  <%
    }
    else
    {
      while( iterator.hasNext() )
      {
        countyBudgetSearchRow = (CountyBudgetLimitRetrieveSO) iterator.next();
  %>
             <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
               <% if ("false".equals(disabledAddButton)) { %>
               <td>
                 <a href="javascript:submitCountyBudgetID('<%=countyBudgetSearchRow.getIdCountyBudgetLimit()%>');">
                   <%= FormattingHelper.formatString(countyBudgetSearchRow.getProgram()) %></a>
               </td>
               <% } else { %>
               <td>
                  <%= FormattingHelper.formatString(countyBudgetSearchRow.getProgram()) %>
               </td>
               <%} %>
               <td>
                 <%= Lookup.simpleDecodeSafe(CodesTables.CCOUNT, countyBudgetSearchRow.getCounty()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatMoney(countyBudgetSearchRow.getBudgetedAmount()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatMoney(countyBudgetSearchRow.getAmountSpent()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatMoney(countyBudgetSearchRow.getAmountObligated()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatMoney(countyBudgetSearchRow.getRemainingBalance()) %>
               </td>
             </tr>
               <%
                 loopCount++;
               } // end while
              }
               %>
             </table>
  </td>
</tr>
</table>    

<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
    <td>
      <impact:ButtonTag
        name="btnAdd"
        img="btnAdd"
        align="right"
        form="frmCountyBudgetLimitSearchResults"
        action="/financials/CountyBudgetLimit/forwardCountyBudgetLimitDetail"
        function="document.frmCountyBudgetLimitSearchResults.hdnCountyBudgetLimitID.value = '0'"
        tabIndex="<%= tabIndex++ %>"
        disabled="<%= disabledAddButton %>"
      />
    </td>
  </tr>
</table>       

</impact:validateForm>

<% } %>