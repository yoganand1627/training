<%
//*  JSP Name:     Budget Transfer
//*  Created by:   Paul Lang
//*  Date Created: 01/10/03
//*
//*  Description:
//*  This JSP is is used to tranfer funds between different expense catagories within a contract.
//*  This page is accessed through The Contract Header JSP. This JSP returns to the Contract Header upon Save
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  01/10/03  Paul Lang         Pasted the template into this JSP.
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON09SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="org.exolab.castor.types.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>

<%
String pageMode = PageMode.getPageMode( request );

%>

<impact:validateErrors/>
<impact:validateForm
name="frmBudgetTransfer"
method="post"
defaultButton="true"
action="/financials/Contracts/saveBudgetTransfer"
validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.BudgetTransferCustomValidation"
pageMode="<%= pageMode %>"
schema="/WEB-INF/Constraints.xsd">

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

 /*
  *This function is called before the page unloads. It creates the
  *"Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  }

  function confirmBudgetTrasfer()
{
  confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_CONFIRM_AMENDMENT)%>");
}
</script>

<%

BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
CCON09SO ccon09so = (CCON09SO) state.getAttribute("CCON09SO", request);
ROWCCON09SOG00_ARRAY budgetTransferArray = null;
ROWCCON09SOG00 budgetTransferRow = null;
if ( ccon09so == null )
{
  ccon09so = new CCON09SO();
}
if ( ccon09so.getROWCCON09SOG00_ARRAY() != null )
{
  budgetTransferArray = ccon09so.getROWCCON09SOG00_ARRAY();
}
else
{
  budgetTransferArray = new ROWCCON09SOG00_ARRAY();
}

double ulAmtCnsvcEquip = 0.0;
double ulAmtCnsvcEquipUsed = 0.0;
double ulAmtCnsvcFrgBenft = 0.0;
double ulAmtCnsvcFrgBenftUsed = 0.0;
double ulAmtCnsvcOther = 0.0;
double ulAmtCnsvcOtherUsed = 0.0;
double ulAmtCnsvcSalary = 0.0;
double ulAmtCnsvcSalaryUsed = 0.0;
double ulAmtCnsvcSupply = 0.0;
double ulAmtCnsvcSupplyUsed = 0.0;
double ulAmtCnsvcTravel = 0.0;
double ulAmtCnsvcTravelUsed = 0.0;
double ulAmtCnsvcUnitRate = 0.0;
double ulAmtCnsvcUnitRateUsed = 0.0;
double ulAmtCnsvcAdminAllUsed = 0.0;
double ulNbrCnsvcLineItem = 0.0;
String szCdCnsvcPaymentType = "";
String szCdCnsvcService = "";


int tabIndex = 1;
int loopCount = 0;
%>

<% out.println("Version: " + GlobalData.getUlNbrCnverVersion(request)); %>


  <div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
                  <table width="100%" cellspacing="0" cellpadding="3" border="0">
                          <tr>
                            <th class="thList">From</th>
                            <th class="thList">To</th>
                            <th class="thList">CSLI</th>
                            <th class="thList">Service</th>
                            <th class="thList">Category</th>
                            <th class="thList">Total Amount</th>
                            <th class="thList">Budget Balance</th>
                          </tr>
 <%

//IF the payment type (szCdCnsvcPaymentType) is equal to URT or VUR then the 6 categories below don't populate
//in the list and the category "Unit Rate" appears instead. Unit Rate is equal to ulAmtCnsvcUnitRate for the Total Amount column
//and Budget Balance is equal to ulAmtCnsvcUnitRate - ulAmtCnsvcUnitRateUsed. Else populate the 6 categories for the CRM payment type.

   Enumeration budgetTransferEnumeration = budgetTransferArray.enumerateROWCCON09SOG00();
if ( !budgetTransferEnumeration.hasMoreElements() )
{
 %>
                       <tr class="odd">
                         <td colspan="7">
                            <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
                         </td>
                       </tr>
 <%
   }
   else
   {
     int rowCount = 0;
     while( budgetTransferEnumeration.hasMoreElements() )
     {
       budgetTransferRow = (ROWCCON09SOG00) budgetTransferEnumeration.nextElement();
       if ( !CodesTables.CCONPAY_URT.equals( budgetTransferRow.getSzCdCnsvcPaymentType() ) &&
            !CodesTables.CCONPAY_VUR.equals( budgetTransferRow.getSzCdCnsvcPaymentType() )
          )
       {
         String[][] category = {
         { "Salary" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSalary() )   , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSalary()   - budgetTransferRow.getUlAmtCnsvcSalaryUsed() ) } ,
         { "Fringe" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcFrgBenft() ) , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcFrgBenft() - budgetTransferRow.getUlAmtCnsvcFrgBenftUsed() ) } ,
         { "Travel" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcTravel() )   , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcTravel()   - budgetTransferRow.getUlAmtCnsvcTravelUsed() ) } ,
         { "Supply" , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSupply() )   , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcSupply()   - budgetTransferRow.getUlAmtCnsvcSupplyUsed() ) } ,
         { "Equip" ,  FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcEquip() )    , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcEquip()    - budgetTransferRow.getUlAmtCnsvcEquipUsed() ) }  ,
         { "Other" ,  FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcOther() )    , FormattingHelper.formatMoney( budgetTransferRow.getUlAmtCnsvcOther()    - budgetTransferRow.getUlAmtCnsvcOtherUsed() - budgetTransferRow.getUlAmtCnsvcAdminAllUsed() ) } };

       for ( int i = 0 ; i < category.length ; i++)
       {
 %>
                         <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                           <% String radioId1 = category[i][0] + "_" + rowCount; String radioId2 = category[i][0] + "_" + rowCount; %>
                             <td><impact:validateInput type="radio" id="<%=radioId1%>" tabIndex="<%= tabIndex++ %>" name="rbBudgetTransferFrom" value="<%=radioId1%>"/></td>
                             <td><impact:validateInput type="radio" id="<%=radioId2%>" tabIndex="<%= tabIndex++ %>" name="rbBudgetTransferTo" value="<%=radioId2%>"/></td>
                             <td><%= budgetTransferRow.getUlNbrCnsvcLineItem() %></td>
                             <td><%= budgetTransferRow.getSzCdCnsvcService() %></td>
                             <td><%= category[i][0] %></td>
                             <td><impact:validateDisplayOnlyField name='<%="txtTotalAmount" +  category[i][0] + rowCount %>'  value="<%= category[i][1] %>" /></td>
                             <td><%= category[i][2] %></td>
                          </tr>
 <%
         loopCount++;
       }
     }
     else
     {
       double unitRateTotal = budgetTransferRow.getUlAmtCnsvcUnitRate();
       double unitRateBalance = budgetTransferRow.getUlAmtCnsvcUnitRate() - budgetTransferRow.getUlAmtCnsvcUnitRateUsed();
       String unitRateTotalString = FormattingHelper.formatMoney( unitRateTotal );
       String unitRateBalanceString = FormattingHelper.formatMoney( unitRateBalance );
 %>
       <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
         <% String radioId1 = "UnitRate" + "_" + rowCount; String radioId2 = "UnitRate" + "_" + rowCount; %>
           <td><impact:validateInput type="radio" id="<%=radioId1%>" tabIndex="<%= tabIndex++ %>" name="rbBudgetTransferFrom" value="<%=radioId1%>"/></td>
           <td><impact:validateInput type="radio" id="<%=radioId2%>" tabIndex="<%= tabIndex++ %>" name="rbBudgetTransferTo" value="<%=radioId2%>"/></td>
           <td><%= budgetTransferRow.getUlNbrCnsvcLineItem() %></td>
           <td><%= budgetTransferRow.getSzCdCnsvcService() %></td>
           <td>Unit Rate</td>
           <td><impact:validateDisplayOnlyField name='<%="txtTotalAmount" + rowCount %>'  value="<%= unitRateTotalString %>" /></td>
           <td><%= unitRateBalanceString %></td>
        </tr>
  <%
  loopCount++;
     }
     rowCount++;
   } // end while
  } // end else
 %>

                  </table>
              </div><% /* this is where the "scrollBar" div tag ends */ %>
<% /*  Always include this hidden field in your form */ %>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
 <tr>
  <td><impact:validateInput type="text" label="Amount" required="true" constraint="Money" name="txtUlIdTransferAmount" cssClass="formInput" value="" size="15" maxLength="50" tabIndex="<%= tabIndex++ %>"/></td>
  <td><impact:ButtonTag name="btnTransfer" img="btnTransfer" form="frmBudgetTransfer" function="javascript:confirmBudgetTrasfer()" action="/financials/Contracts/saveBudgetTransfer" align="right" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/></td>
</tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>