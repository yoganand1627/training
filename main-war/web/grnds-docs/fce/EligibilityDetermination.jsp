<%
/**  JSP Name:     Domicile and Deprevation
 *   Created by:   Rodrigo DeJuana
 *   Date Created: 02/17/02
 *   Description:
 *   This page is used to accurately determine if the child meets the AFDC
 *   requirement for Deprivation and Domicile.
**/
/*
 Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Added Description to Flowerbox.
  12/27/10  hjbaptiste        SMS#88374; MR-053 fixed diplaying the gross earned income for
                              deeming responsible individuals and added link to income and expenditures
                              page for gross unearned income.
  12/28/10  hjbaptiste        SMS#89028; MR-053 Fixed Grossed earned income rounding                           
  12/29/10  hnguyen           SMS#89026; MR-053 Corrected IV-E Budget Resource and GIC test 
                              and Total Countable Income.
  01/05/10  hjbaptiste        SMS#86429; MR-053 Do not show deprivation and citizenship in the Requirements section
                              for NOC                                                          
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilityDeterminationConversation" %>

<%
  int tabIndex = 1;
  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  EligibilityDeterminationDB eligibilityDB = (EligibilityDeterminationDB)
    request.getAttribute(EligibilityDeterminationConversation.ELIGIBILITYDB);
    
  String cdApplication = (String) request.getAttribute("cdApplication");
  List<FcePersonDB> aUMembersList = eligibilityDB.getAUMembers();
  List<FcePersonDB> nonAUMembersList = eligibilityDB.getNonAUMembers();
  List<FcePersonDB> principlesList = eligibilityDB.getPrincipals();

  Integer pendingStageClosureEventId = (Integer)request.getAttribute(EligibilityDeterminationConversation.STAGE_CLOSURE_EVENT_ID);
  if (pendingStageClosureEventId == null)
  {
    pendingStageClosureEventId = 0;
  }


%>
<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};


function yes()
{
<%
  if ( pendingStageClosureEventId > 0 )
  {
%>
  var MSG_CMN_INVLD_APRVL =
      "<%= MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL) %>";
  if ( !confirm(MSG_CMN_INVLD_APRVL) )
  {
    return false;
  }
<%
  }
%>
  disableValidation('frmEDW');
  return true;
}


function navigateTo(destination)
{
  disableValidation("frmEDW");
  submitValidateForm("frmEDW", destination);
}
</script>

<impact:validateErrors/>

<impact:validateForm name="frmEDW"
  method="post"
  action="/fce/EligibilityDetermination/saveEligibilityDetermination"
  pageMode="<%= pageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilityDeterminationCustomValidation"
  schema="/WEB-INF/Constraints.xsd">


<!-- Hidden Fields -->
<impact:validateInput type="hidden"
                      name="hdnPendingStageClosureEventId"
                      value="<%= String.valueOf(pendingStageClosureEventId) %>" />

<impact:validateInput type="hidden"
                      name="idEvent"
                      value="<%= eligibilityDB.getIdEventString() %>" />

<impact:validateInput type="hidden"
                      name="idFceApplication"
                      value="<%= eligibilityDB.getIdFceApplicationString() %>" />

<impact:validateInput type="hidden"
                      name="idFceEligibility"
                      value="<%= eligibilityDB.getIdFceEligibilityString() %>" />

<impact:validateInput type="hidden"
                      name="idFcePerson"
                      value="<%= eligibilityDB.getIdFcePersonString() %>" />

<impact:validateInput type="hidden"
                      name="idLastUpdatePerson"
                      value="<%= eligibilityDB.getIdLastUpdatePersonString() %>" />

<impact:validateInput type="hidden"
                      name="idPerson"
                      value="<%= eligibilityDB.getIdPersonString() %>" />

<impact:validateInput type="hidden"
                      name="idStage"
                      value="<%= eligibilityDB.getIdStageString() %>" />

<impact:validateInput type="hidden"
                      name="fceEligibilityDtLastUpdateTime"
                      value='<%= ""+ eligibilityDB.getFceEligibilityDtLastUpdateTime() %>' />

<!--- Begin Detail Table --->

<% if (eligibilityDB.getIndEligibleObject() != null) { %>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" >
  <tr>
    <td class="ReasonsNotEligibileTitle">Child is<%= eligibilityDB.getIndEligible() ? "" : " NOT" %> Eligible for Title IV-E<%= ("R".equals(cdApplication)) ? " Reimbursability" : "" %></td>
  </tr>
  <tr>
  <% if(eligibilityDB.getIndChildReceivingSSI()){%>
    <td>Due to IV-E eligibility and SSI income, the recommended funding source is IV-B.</td>
  <%}%>
  </tr>
  <tr>
    <td>
      <ul>
<%
List reasonList = eligibilityDB.getReasonsNotEligible();
Iterator reasonIt = reasonList.iterator();
while (reasonIt.hasNext())
{
  FceReasonNotEligibleDB reason = (FceReasonNotEligibleDB) reasonIt.next();
%>
        <li class="ReasonsNotEligibileReason"><%= Lookup.simpleDecodeSafe(CodesTables.CFCERNE, reason.getCdReasonNotEligible())%></li>
<%}%>
      </ul>
    </td>
  </tr>
</table>
<% } %>

<%
int i = 1;
String budgetingProcess = (String) request.getAttribute(EligibilityDeterminationConversation.BUDGETING_PROCESS);
// Only show this section if we're doing an AFCD Budget
if (EligibilityDeterminationConversation.AFDC_BUDGETING.equals(budgetingProcess)) {
%>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="3"> I. Deeming Budget</th>
  </tr>
  <tr>
    <td>1.</td>
    <td>
	    Number of responsible individual's children who live in the home but are not included in the AU
	</td>
	<td width="10%"><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= eligibilityDB.getNbrDeemChildNotInAU() %></a></td>
  </tr>
  <tr>
    <td>2.</td>
    <td>
      Number of other dependents in the home who are claimed or could be claimed as tax dependents and are not included in the AU
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= eligibilityDB.getNbrDeemTaxDependNotInAU() %></a></td>
  </tr>
  <tr>
    <td>3.</td>
    <td>
      Number of Responsible Individuals
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= eligibilityDB.getNbrDeemResponseIndiv() %></a></td>
  </tr>
  <tr>
    <td>4.</td>
    <td>
      Total of 1, 2, 3 above
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= eligibilityDB.getNbrDeemPersonSONLookup() %></a></td>
  </tr>
  <tr>
    <td>5.</td>
    <td>
      Earned Income
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemGrossEarnedIncome()) %></a></td>
  </tr>
  <tr>
    <td>6.</td>
    <td>
      Earned Income Deduction (Only if the Responsible Individual has earning)
    </td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemStdEarnedIncDeduct()) %></td>
  </tr>
  <tr>
    <td>7.</td>
    <td>
      Net Earned Income
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemNetEarnedIncome()) %></a></td>
  </tr>
  <tr>
    <td>8.</td>
    <td>
      Unearned Income
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemUnearnedIncome()) %></a></td>
  </tr>
  <tr>
    <td>9.</td>
    <td>
      Total Net Income
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemCntNetIncome()) %></a></td>
  </tr>
  <tr>
    <td>10.</td>
    <td>
      Standard of Need (From 4. above)
    </td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemStdOfNeed()) %></td>
  </tr>
  <tr>
    <td>11.</td>
    <td>
      Amount paid to dependents outside the household who are claimed or could be claimed as tax dependents
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTaxDependOutHh()) %></a></td>
  </tr>
  <tr>
    <td>12.</td>
    <td>
      Alimony and/or child support paid to person(s) outside of the household
    </td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemAlimonyOutsideHh()) %></a></td>
  </tr>
  <tr>
    <td>13.</td>
    <td><b>
      <%= Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdDeemSurplusOrDeficit()) %></b> (Line 9 minus the total of Line 10, 11 and 12)
    </td>
    <td><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemSurplusOrDeficit()) %></b></td>
  </tr>
  <tr>
    <td>14.</td>
    <td>
      <b>Total Deemed Amount </b> (If a surplus exists)
    </td>
    <td><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTotal()) %></b></td>
  </tr>
</table>

<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="6">II.  Allocation Budget</th>
  </tr>
  <tr>
    <td><b>AU Member(s)</b></td>
    <td width="25%"><b>1. # of Persons to whom AU members' income can be allocated</b></td>
    <td><b>2. Standard Of Need<br>for # of Persons</b></td>
    <td><b>3. Gross income</b></td>
    <td width="25%"><b>4. Allocated Amount</b> (Either 2. or 3; Whichever is less)</td>
  </tr>
<%
if (CodesTables.CALOCTYP_MUTP.equals(eligibilityDB.getCdAllocType()) || 
    CodesTables.CALOCTYP_MSGL.equals(eligibilityDB.getCdAllocType()) ||
    CodesTables.CALOCTYP_MMUL.equals(eligibilityDB.getCdAllocType())) { 
    String nmPersonAllocMutual1 = "";
    String nmPersonAllocMutual2 = "";
    if (aUMembersList != null && aUMembersList.size() > 0) {
       Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
        while (aUMembersList_it.hasNext()) {
          FcePersonDB aUMember = aUMembersList_it.next();
          if (eligibilityDB.getIdPersonAllocMutual1() == aUMember.getIdPerson()) {
            nmPersonAllocMutual1 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
          }
          if (eligibilityDB.getIdPersonAllocMutual2() == aUMember.getIdPerson()) {
            nmPersonAllocMutual2 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
          }
        }
    }
%>
  <tr>
  	<td rowspan="2"><%= nmPersonAllocMutual1 %><br/>
  	                <%= nmPersonAllocMutual2 %></td>
  	<td><%= eligibilityDB.getNbrIneligPersonAllocMutual()%></td>
  	<td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedAllocMutual()) %></td>
  	<td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeAllocMutual()) %></a></td>
  	<td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowanceMutual()) %></a></td>
  </tr>
  <tr>
	<td colspan="4"></td>
  </tr>
<%
}
if (CodesTables.CALOCTYP_SGLP.equals(eligibilityDB.getCdAllocType()) || 
    CodesTables.CALOCTYP_MULP.equals(eligibilityDB.getCdAllocType()) ||
    CodesTables.CALOCTYP_MSGL.equals(eligibilityDB.getCdAllocType()) ||
    CodesTables.CALOCTYP_MMUL.equals(eligibilityDB.getCdAllocType())) {
    String nmPersonAllocSngl1 = "";
    if (aUMembersList != null && aUMembersList.size() > 0) {
       Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
        while (aUMembersList_it.hasNext()) {
          FcePersonDB aUMember = aUMembersList_it.next();
          if (eligibilityDB.getIdPersonAllocSngl1() == aUMember.getIdPerson()) {
            nmPersonAllocSngl1 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
            break;
          }
        }
    } 
%> 
  <tr>
  	<td><%= nmPersonAllocSngl1 %></td>
  	<td><%= eligibilityDB.getNbrIneligPersonAllocSngl1() %></td>
  	<td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedAllocSngl1()) %></td>
  	<td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeAllocSngl1()) %></a></td>
  	<td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowanceSngl1()) %></a></td>
  </tr>
<%
}
if (CodesTables.CALOCTYP_MULP.equals(eligibilityDB.getCdAllocType()) || 
    CodesTables.CALOCTYP_MMUL.equals(eligibilityDB.getCdAllocType())) {
    String nmPersonAllocSngl2 = "";
    if (aUMembersList != null && aUMembersList.size() > 0) {
       Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
        while (aUMembersList_it.hasNext()) {
          FcePersonDB aUMember = aUMembersList_it.next();
          if (eligibilityDB.getIdPersonAllocSngl2() == aUMember.getIdPerson()) {
            nmPersonAllocSngl2 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
            break;
          }
        }
    } 
%> 
  <tr>
  	<td><%= nmPersonAllocSngl2 %></td>
  	<td><%= eligibilityDB.getNbrIneligPersonAllocSngl2() %></td>
  	<td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedAllocSngl2()) %></td>
  	<td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeAllocSngl2()) %></a></td>
  	<td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowanceSngl2()) %></a></td>
  </tr>
<%
}
%>
  <tr>
      	<td colspan="5">&nbsp;</td>
  </tr>
  <tr>
    	<td colspan="4"><b>5. Total Allocated Amount</b></td>
    	<td colspan="1"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowance()) %></b></td>
  </tr>
</table>

<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="6">III. AFDC Budget</th>
  </tr>
  <tr>
    <td>Number of People in Assistance Unit</td>
    <td><a href='javascript:navigateTo("/fce/ApplicationAndBackground/displayAppAndBG")'
                                    tabIndex="<%= tabIndex++ %>"><%= eligibilityDB.getNbrCertifiedGroup() %></a></td>
  </tr>
  <tr>
    <th colspan="3" width="42%">Resource Test</th>
    <th colspan="3" width="58%">Gross Income Ceiling Test</th>
  </tr>
  <tr>
    <td>Total Nonexempt Resources</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtNonexmptRsrcCrtfdGrp()) %></a></td>
    <td></td>
    <td>Gross Income (Plus Deemed (Only Added if Surplus, from I. 14., above) less Allocated Income (from II. 5. above))</td>
    <td>&nbsp;</td>
    <td width="5%"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeCrtfdGrp()) %></td>
  </tr>
  <tr>
    <td>Resource Limit</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtResourceLimitCrtfdGrp()) %></td>
    <td></td>
    <td>Gross Income Ceiling</td>
    <td>&nbsp;</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeCeiling()) %></td>
  </tr>
  <tr>
    <td><b>Eligible Based on Resources?</b></td>
    <td><b><%= eligibilityDB.getIndEquity() ? ArchitectureConstants.NO : ArchitectureConstants.YES %></b></td>
    <td></td>
    <td><b><%= Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdGicSurpDefctCrtfdGrp()) %></b></td>
    <td>&nbsp;</td>
    <td width="10%"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGicSurpDefctCrtfdGrp()) %></b></td>
  </tr>
  <tr>
    <td colspan="3"></td>
    <td><b>Eligible Based on GIC Test?</b></td>
    <td>&nbsp;</td>
    <td><b><%= eligibilityDB.getIndGrossIncCeilingElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO %></b></td>
  </tr>
  <tr>
    <th colspan="6">Standard of Need Test</th>
  </tr>
  <tr>
  <td colspan="6">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3">
    <tr>
      <td><b>AU Member</b></td>
      <td><b>Relationship</b></td>
      <td><b>Earned Income</b></td>
      <td><b>$90 Deduction</b></td>
      <td><b>Sub Total</b></td>
      <td></td>
    </tr>
<%
if (aUMembersList != null && aUMembersList.size() > 0) {
  Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
  while (aUMembersList_it.hasNext()) {
    FcePersonDB aUMember = aUMembersList_it.next();
    String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", aUMember.getCdRelInt());
    if ("".equals(relationDecode)) {
     relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", aUMember.getCdRelInt());
    }
%>
    <tr>
	  <td><%= aUMember.getNmPersonLast() + ", " +  aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle()%></td>
	  <td><%= relationDecode %></td>
	  <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(aUMember.getAmtGrossEarnedIncome()) %></a></td>
	  <td><%= FormattingHelper.formatMoney(aUMember.getAmtStdEarnedIncomeDeduct()) %></td>
	  <td><%= FormattingHelper.formatMoney(aUMember.getAmtCntblIncome()) %></td>
	  <td></td>
    </tr>
<%
  }
} 
%>    
    <tr>
		  <td></td>
		  <td><b>Sub Total</b></td>
		  <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossEarnedCrtfdGrp()) %></td>
		  <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStdEarnedIncomeDeduct()) %></td>
		  <td><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessStdDeduct()) %></b></td>
    </tr>
  </table>
  </td>
  </tr>
  <tr>
  <td colspan="6">--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td>
  </tr>
  <tr>
  <td colspan="6">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3">
  <tr>
      <td width="60%"></td>
      <td></td>
      <td width="20%" colspan="3"><b>Sub Total</b></td>
  </tr>
  <tr>
    <td width="60%">Earned Income Less Standard Earned Income Deduction(s)(Sub Total from above)</td>
    <td></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessStdDeduct()) %></td> 
  </tr>
  <tr>
    <td width="60%">Less Child Care (Do not deduct $50 Child Support)</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDependentCareDeduc()) %></a></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtLessDepCareStdNeed()) %></td>
  </tr>
  <tr>
    <td width="60%">Plus Unearned Income</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtCsupWithUnearnedIncome()) %></a></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtPlusUnearnedStdNeed()) %></td>
  </tr>
  <tr>
    <td width="60%">Plus Deemed Income (Only Added if Surplus, from I. 14., above)</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTotal()) %></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtPlusDeemedStdNeed()) %></td>
  </tr>
  <tr>
    <td width="60%">Less Allocation (from II. 5., above)</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowance()) %></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncomeStdNeed()) %></td>
  </tr>
  <tr>
    <td width="60%"><b>Total</b></td>
    <td></td>
    <td width="20%" colspan="3"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncomeStdNeed()) %></b></td>
  </tr>
  <tr>
    <td width="60%"><b>SON</b></td>
    <td></td>
    <td width="20%" colspan="3"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStandardOfNeed()) %></b></td>
  </tr>
  <tr>
    <td width="60%"><b><%= Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdStdTestSurpDefct()) %></b></td>
    <td></td>
    <td width="20%" colspan="3"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtSurpDefctStdNeed()) %></b></td>
  </tr>
    </table>
  </td>
  </tr>
  <tr>
    <th colspan="6">Eligibility/Payment Budget</th>
  </tr>

  <tr>
  <td colspan="6">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3">
      <tr>
        <td><b>AU Member</b></td>
        <td><b>1. Earned Income</b></td>
        <td><b>2. Less $90 Deduction</b></td>
        <td><b>3. Less $30</b></td>
        <td><b>4. Less 1/3</b></td>
      </tr>
<%
if (aUMembersList != null && aUMembersList.size() > 0) {
  Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
  while (aUMembersList_it.hasNext()) {
    FcePersonDB aUMember = aUMembersList_it.next();
%>      
      <tr>
	    <td><%= aUMember.getNmPersonLast() + ", " +  aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle()%></td>
	    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(aUMember.getAmtGrossEarnedIncome()) %></a></td>
	    <td><%= FormattingHelper.formatMoney(aUMember.getAmtCntblIncome()) %></td>
	    <td><%= FormattingHelper.formatMoney(aUMember.getAmtCntblIncomeLess30()) %></td>
	    <td><%= FormattingHelper.formatMoney(aUMember.getAmtCntblIncomeLessThird()) %></td>
      </tr>
<%
  }
}  
%>    
      <tr>
  		<td><b>Sub Total</b></td>
  		<td></td>
  		<td colspan="2" align="center"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessAllDeduct()) %></b></td>
  		<td></td>
      </tr>
  </table>
  </td>
  </tr>
  <tr>
  <td align="center" colspan="6">--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td>
  </tr>
  <tr>
  <td colspan="6">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3">
  <tr>
    <td width="60%"></td>
    <td></td>
    <td width="20%" colspan="3"><b>Sub Total</b></td>
  </tr>
  <tr>
      <td width="60%">5. Earned Income Less Earned Income Deduction(s)(Sub Total from above)</td>
      <td></td>
      <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessAllDeduct()) %></td>
  </tr>
  <tr>
    <td width="60%">6. Less Child Care</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDependentCareDeduc()) %></a></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtLessDepCareElig()) %></td>
  </tr>
  <tr>
    <td width="60%">7. Net Earned Income</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncome()) %></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncome()) %></td>
  </tr>
  <tr>
    <td width="60%">8. Plus Unearned Income</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossUnearnedCrtfdGrp()) %></a></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtPlusUnearnedElig()) %></td>
  </tr>
  <tr>
    <td width="60%">9. Plus Child Support (Less $50)</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtChsupCrtfdGrp()) %></a></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtPlusChsupCrtfdGrp()) %></td>
  </tr>
  <tr>
    <td width="60%">10. Plus Deemed Income (Only Added if Surplus,from I. 14., above)</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTotal()) %></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtPlusDeemedElig()) %></td>
  </tr>
  <tr>
    <td width="60%">11. Less Allocation (from II. 5., above)</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowance()) %></td>
    <td width="20%" colspan="3"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtLessAllocElig()) %></td>
  </tr>
  <tr>
    <td width="60%"><b>12. Total Countable Income</b></td>
    <td></td>
    <td width="20%" colspan="3"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncome()) %></b></td>
  </tr>
  <tr>
      <td width="60%"><b>13. SON</b></td>
      <td></td>
      <td width="20%" colspan="3"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStandardOfNeed()) %></b></td>
  </tr>
  <tr>
    <td width="60%"><b>14. <%= Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdEligSurpDefctCrtfdGrp()) %></b> (line 12 less SON)</td>
    <td></td>
    <td width="20%" colspan="3"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtSurpDefctEligCrtfdGrp()) %></b></td>
  </tr>
  </table>
  </td>
  </tr>
</table>

<%
} 
// Only show this section if we're doing a IV-E Budget
else {
  long idChild = eligibilityDB.getIdFcePerson();
  FcePersonDB child = new FcePersonDB();
  if (aUMembersList != null && aUMembersList.size() > 0) {
    Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
    while (aUMembersList_it.hasNext()) {
      child = aUMembersList_it.next();
      if (idChild == child.getIdFcePerson()) {
        break;
      }
    }
  }
  i = 1;
  int j = 5;
%>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="6">IV-E Reimbursability Worksheet</th>
  </tr>
  <tr>
    <td>Number of People in Assistance Unit</td>
    <td>1</td>
  </tr>
      <tr>
      <th colspan="3" width="42%">Resource Test</th>
      <th colspan="3" width="58%">Gross Income Ceiling Test</th>
    </tr>
    <tr>
      <td>Total Countable Resources for Child</td>
      <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                                    tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtCtnblResourceChild()) %></a></td>
      <td></td>
      <td>Gross Income for Child</td>
      <td>&nbsp;</td>
      <td width="5%"><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtTotalGrossIncomeChild()) %></a></td>
    </tr>
    <tr>
      <td>Resource Limit</td>
      <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtResourceLimitChild()) %></td>
      <td></td>
      <td>Gross Income Ceiling</td>
      <td>&nbsp;</td>
      <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeCeilingChild()) %></td>
    </tr>
    <tr>
      <td><b>Eligible Based on Resources?</b></td>
      <td><b><%= eligibilityDB.getIndCtnblResChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO %></b></td>
      <td></td>
      <td><b><%= Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdGicSurpDefctChild()) %></b></td>
      <td>&nbsp;</td>
      <td width="10%"><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGicSurpDefctChild()) %></b></td>
    </tr>
    <tr>
      <td colspan="3"></td>
      <td><b>Eligible Based on GIC Test?</b></td>
      <td>&nbsp;</td>
      <td><b><%= eligibilityDB.getIndGrossIncChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO %></b></td>
  </tr>
  <tr>
    <th colspan="6">Reimbursability/Payment Budget</th>
  </tr>
  <tr>
    <td colspan="6"><table border="0" width="100%" cellSpacing="0" cellPadding="3">
  <tr>
    <td></td>
    <td></td>
    <td><b>Sub Total</b></td>
  </tr>
  <tr>
    <td>1. Total Monthly Earned Income for Child</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossEarnedChild()) %></a></td>
    <td></td>
  </tr>
  <tr>
    <td>2. Less Standard Deduction $90</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStdEarnedIncomeDeduct()) %></td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessStdDeduct()) %></td>
  </tr>
  <tr>
    <td>3. Less $30</td>
    <td><%= FormattingHelper.formatMoney(child.getAmtCntblIncome30()) %></td>
    <td><%= FormattingHelper.formatMoney(child.getAmtCntblIncomeLess30()) %></td>
  </tr>
  <tr>
    <td>4. Less 1/3</td>
    <td><%= FormattingHelper.formatMoney(child.getAmtCntblIncomeThird()) %></td>
    <td><%= FormattingHelper.formatMoney(child.getAmtCntblIncomeLessThird()) %></td>
  </tr>
  <tr>
      <td>5. Less Dependent Care Deduction for Child</td>
      <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtDepCareDeducChild()) %></td>
      <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtLessDepCareElig()) %></td>
  </tr>
  <tr>
    <td>6. Net Earned Income</td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncomeChild()) %>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncomeChild()) %></td>
  </tr>
  <tr>
    <td>7. Plus Unearned Income</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                                    tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtGrossUnEarnedChild()) %></a></td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtPlusUnearnedElig()) %></td>
  </tr>
  <tr>
    <td>8. Plus Child Support(Less $50)</td>
    <td><a href='javascript:navigateTo("/fce/IncomeExpenditures/displayIncomeExpenditures")'
                         tabIndex="<%= tabIndex++ %>"><%= FormattingHelper.formatMoney(eligibilityDB.getAmtChsupChild()) %></a></td>
    <td><%= FormattingHelper.formatMoney(eligibilityDB.getAmtPlusChsupChild()) %></td>
  </tr>
  <tr>
    <td><b>9. Total Countable Income</b></td>
    <td><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncome()) %></b></td>
    <td><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncome()) %></b></td>
  </tr>
  <tr>
      <td><b>10. SON</b></td>
      <td><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedChild()) %></b></td>
      <td></td>
  </tr>
  <tr>
    <td><b>11. <%= Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdEligSurpDefctChild()) %></b>(line 9 less SON)</td>
    <td><b><%= FormattingHelper.formatMoney(eligibilityDB.getAmtSurpDefctEligChild()) %></b></td>
    <td></td>
  </tr>
  </table></td>
  </tr>
</table>
<%
}
%>
<br>
<impact:ExpandableSectionTag name="checklist"
                             id=""
                             isExpanded="true"
                             label="<%= (CodesTables.CFCEAPRE_R.equals(cdApplication) ? "Reimbursability Checklist" : "Foster Care Eligibility Checklist") %>"
                             tabIndex="<%= tabIndex++ %>">

<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th></th>
    <th><%= (CodesTables.CFCEAPRE_R.equals(cdApplication) ? "IV-E Reimbursability" : "AFDC") %> Requirements</th>
  </tr>
  <tr class="odd">
    <td><a href='javascript:navigateTo("/fce/AgeCitizenship/displayAgeCitizenship")'
           tabIndex="<%= tabIndex++ %>"><%= (eligibilityDB.getIndChildUnder18()) ? "Yes" : "No" %></a></td>

    <td>Was the child under age 18?</td>
  </tr>
<%
if (EligibilityDeterminationConversation.AFDC_BUDGETING.equals(budgetingProcess)) {
%>  
  <tr class="odd">
    <td><a href='javascript:navigateTo("/fce/AgeCitizenship/displayAgeCitizenship")'
           tabIndex="<%= tabIndex++ %>"><%= (eligibilityDB.getIndChildQualifiedCitizen()) ? "Yes" : "No" %></a></td>

    <td>Was the child a U.S. Citizen, Permanent Resident/Refugee, Qualified Alien or was Evaluative Conclusion used to verify the child's Citizenship status?</td>
  </tr>
  <tr class="odd">
    <td><a href='javascript:navigateTo("/fce/DomicileDeprivation/displayDomicile")'
           tabIndex="<%= tabIndex++ %>"><%= (eligibilityDB.getIndParentalDeprivation()) ? "Yes" : "No" %></a></td>

    <td>Did Parental Deprivation exist in the removal home?</td>
  </tr>
  <tr class="odd">
    <td><a href='javascript:navigateTo("/fce/DomicileDeprivation/displayDomicile")'
           tabIndex="<%= tabIndex++ %>"><%= (Boolean.FALSE.equals(eligibilityDB.getIndChildLivingPrnt6MnthsObject())) ? "No" : "Yes" %></a></td>

    <td>Was the child physically removed by court order from a Parent OR did the child live with a Parent at any time during the six months before the court proceedings were initiated?</td>
  </tr>
<%
}
%>  
</table>
<%
if (EligibilityDeterminationConversation.AFDC_BUDGETING.equals(budgetingProcess)) {
%>
<br>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="2">Judicial Requirements</th>
  </tr>
  <tr class="odd">
<% 
if (eligibilityDB.getIndRemovalChildOrderedObject()) {
%>  
    <td>Date of First Judicial Determination containing the "contrary to the welfare" or "best interest" language</td>
    <td><%=  eligibilityDB.getDtRemovalChildOrderedString() %></td>
<%
} else { %>  
    <td colspan="2">The first judicial determination removing the child from the home did not contain the "contrary to the welfare" or "best interest" language</td>
<%
} %> 
  </tr>  

  <tr class="odd">
<% 
if (eligibilityDB.getIndRsnblEffortPrvtRemovalObject()) {
%>   
    <td>Date of Court Order of a judicial determination that "reasonable efforts were made to prevent removal" or that "reasonable efforts were not required to prevent removal" within 60 days of the child's court-ordered removal from the home</td>
    <td><%=  eligibilityDB.getDtRsnblEffortPreventRemString() %></td>
<%
} else { %>
    <td colspan="2">There was not a judicial determination that "reasonable efforts were made to prevent removal" or that "reasonable efforts were not required to prevent removal" within 60 days of the child's court-ordered removal from the home</td>      
<%
} %>   
  </tr>
  <tr class="odd">
<% 
if (eligibilityDB.getIndPrsManagingCvsObject()) {
%>  
     <td colspan="2">A court order did give DFCS responsibility for the child's placement and care, or custody of the child</td>
<%
} else { %>
     <td colspan="2">A court order did not give DFCS responsibility for the child's placement and care, or custody of the child</td>
<%
} %>        
  </tr>
</table>
<%
}
 %>
</impact:ExpandableSectionTag>
<br>
<hr>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td align="right"><impact:ButtonTag
                              name="btnSave"
                              img="btnSave"
                              form="frmEDW"
                              action="/fce/EligibilityDetermination/saveEligibilityDetermination"
                              restrictRepost="true"
                              tabIndex="<%= tabIndex++ %>"/>
                      <impact:ButtonTag name="btnDetermineEligibility"
                              img="btnDetermineEligibility"
                              form="frmEDW"
                              action="/fce/EligibilityDetermination/determineEligibility"
                              restrictRepost="true"
                              tabIndex="<%= tabIndex++ %>"/></td>

<%  
  if ("APRV".equals(eligibilityDB.getCdEventStatus()) == false)
{
%>

    <td align="right">
        <impact:ButtonTag name="btnContinue"
                             cssClass="md"
                             img="btnContinue"
                             action="/fce/EligibilityDetermination/confirmYes"
                             function="return yes()"
                             editableMode="<%= EditableMode.ALL %>"
                             form="frmEDW"
                             tabIndex="<%= tabIndex++ %>"/>
    </td>
  
<%
}
%>
  </tr>
</table>


<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

<script language="javascript">
expandCollapsed('expandedchecklist', 'collapsedchecklist');
</script>
