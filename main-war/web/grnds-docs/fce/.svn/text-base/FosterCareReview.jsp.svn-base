
<%
  //*  JSP Name:     Foster Care Review
  //*  Created by:   J Heather Dean
  //*  Date Created: 03/11/03
  //*
  //*  Description:
  //*  The FC Review Application is required when a child is scheduled for a
  //*  review of his or her eligibility status.  Most of the sections on this page
  //*  are pre-filled based on the information entered on the Foster Care
  //*  Application pages or in other parts of IMPACT.
  /*
   Change History:
   Date      User              Description
   --------  ---------------- --------------------------------------------------
   08/06/03  Todd Reser       Added Description to Flowerbox.
   08/09/04  Todd Reser       SIR 23012 - Supress the display of two Extended
   Education Questions if the person is under 18.
   10/25/04  Todd Reser       Sir 23012 - Had to add JavaScript calls to the Show
   Functions to display the questions when loading the
   page if the appropriate radio buttons were selected
   10/27/04  Todd Reser       Rewrote Javascript show/hide function and removed a
   conflicting segement of code from setupPage
   11/09/04  Todd Reser       Recoded if Statements upon page load for displaying
   or hiding complete and enrolled questions.
   09/19/05  berkime          SIR 23890 renamed BLOC to BSL
   12/07/10  Hai Nguyen       SMS#81144: MR-053 Removed Deprivation, Citizenship
                              ES Confirmation sections. Added Child Care section.
                              Added IV-E Budget Worksheet section. Remove button 
                              and logic for Determine Eligibility and 
                              confirmation Yes and No button.
   12/14/10  Hai Nguyen       SMS#81144: MR-053 Updated IV-E Budget Worksheet section
   12/29/10  hnguyen          SMS#89026: MR-053 Corrected IV-E Budget Resource Test 
                              and Judicial Requirement comment to not display if not applies. 
   01/19/10  hjbaptiste       SMS#81144: MR-053 Added the word Reimbursability to determination statement
                              at top of page
   01/24/10  hnguyen          SMS#81144: MR-053 Updated section title to display Reimbursability Determination                                                        
   02/09/11  Hai Nguyen       SMS#95590: Updated Judicial Requirement section to display extension order only
                              as required.
   02/11/11  Hai Nguyen       SMS#95590: Further updated logic to appropriately display judicial review
                              when necessary.
   02/12/11  Hai Nguyen       SMS#96233: Updated jsp to enable and disable buttons for COMP status. Continue button
                              to display only after Save have been clicked when in PEND status.
   */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.service.ServiceHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.FosterCareReviewConversation"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<%
  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);

  int tabIndex = 1;
  String formName = "frmReview";
  String bgColor = "#F0FFFF";

  FosterCareReviewDB fosterCareReviewDB = (FosterCareReviewDB) state.getAttribute("FosterCareReviewDB", request);

  UserProfile userProfile = BasePrsConversation.getUserProfile(request);
  boolean userIsEligibilitySpecialist = userProfile.hasRight(UserProfile.SEC_ELIGIBILITY);

  String eventStatus = fosterCareReviewDB.getCdEventStatus();

  Integer pendingStageClosureEventId = (Integer) request
                                                        .getAttribute(FosterCareReviewConversation.STAGE_CLOSURE_EVENT_ID);


  if (pendingStageClosureEventId == null) {
    pendingStageClosureEventId = 0;
  }

  boolean disableIncomeCheckboxes = true;
  boolean disableInappropriateReview = true;
  boolean disableIncomeResourcesFields = true;

  //Determine continue button
  boolean showContinueButton = false;

  //submit application button
  boolean showSubmitButton = false;

  //show system-derived eligibility
  boolean showEligibility = false;

  boolean showSaveButton = false;

  //Determine page mode based on user rights and event status
  if (FosterCareReviewConversation.EVENT_STATUS_APRV.equals(eventStatus) 
        || FosterCareReviewConversation.EVENT_STATUS_COMP.equals(eventStatus)) {
    showEligibility = true;
  }

  if (FosterCareReviewConversation.EVENT_STATUS_PEND.equals(eventStatus)) {
    showEligibility = true;
    if (PageModeConstants.EDIT.equals(pageMode)) {
      disableIncomeResourcesFields = false;
      disableIncomeCheckboxes = false;
      disableInappropriateReview = false;
      showSaveButton = true;
      showContinueButton = false;
    }
  }
  
  if (FosterCareReviewConversation.EVENT_STATUS_NEW.equals(eventStatus) || FosterCareReviewConversation.EVENT_STATUS_PROC.equals(eventStatus)){
    if (PageModeConstants.EDIT.equals(pageMode)) {
      disableIncomeResourcesFields = false;
      disableIncomeCheckboxes = false;
      disableInappropriateReview = false;
      showSaveButton = true;
      showSubmitButton = true;
      showContinueButton = false;
    }
  }

  if (FosterCareReviewConversation.EVENT_STATUS_COMP.equals(eventStatus)){
    if (PageModeConstants.EDIT.equals(pageMode)) {
      disableIncomeResourcesFields = false;
      disableIncomeCheckboxes = false;
      disableInappropriateReview = false;
      showSaveButton = true;
      showContinueButton = true;
    }
  }

  String radioWidth = "7%";
%>


<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};

function alertEligibilitySpecialist()
{
<impact:ifThen test="<%=((userIsEligibilitySpecialist == false) && (disableInappropriateReview == false))%>">

  var x = document.<%=formName%>;
  if (x.indReviewInappropriate.checked == true)
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_NOTIFY_ELIGIBILITY_SPECIALIST)%>");
  }
</impact:ifThen>
}

function navigateToPersonDetail()
{
  setIsDirtyCalled(true);
  disableValidation('<%=formName%>');
  submitValidateForm('<%=formName%>',
          '<%=FosterCareReviewConversation.DISPLAY_PERSON_DETAIL_COMMAND%>');
  return false;
}


function yes()
{
<%
  if (pendingStageClosureEventId > 0)
  {
%>
  var MSG_CMN_INVLD_APRVL =
          "<%=MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL)%>";
  if (!confirm(MSG_CMN_INVLD_APRVL))
  {
    return false;
  }
<%
  }
%>
//  disableValidation('<%=formName%>');
  return true;
}

</script>


<impact:validateErrors formName="<%=formName%>" />

<impact:validateForm name="<%=formName%>" method="post"
	action="/fce/FosterCareReview/displayFosterCareReview2"
	pageMode="<%=pageMode%>"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.FosterCareReviewCustomValidation"
	schema="/WEB-INF/Constraints.xsd" redisplayParameters="true">

	<impact:validateInput type="hidden"
		name="hdnPendingStageClosureEventId"
		value="<%=String.valueOf(pendingStageClosureEventId)%>" />

	<impact:validateInput type="hidden" name="idFceApplication"
		value="<%=fosterCareReviewDB.getIdFceApplicationString()%>" />

	<impact:validateInput type="hidden" name="idFceEligibility"
		value="<%=fosterCareReviewDB.getIdFceEligibilityString()%>" />

	<impact:validateInput type="hidden" name="idFceReview"
		value="<%=fosterCareReviewDB.getIdFceReviewString()%>" />

	<impact:validateInput type="hidden" name="idEvent"
		value="<%=fosterCareReviewDB.getIdEventString()%>" />

	<impact:validateInput type="hidden" name="showEligibility"
		value="<%=String.valueOf(showEligibility)%>" />

	<impact:validateInput type="hidden" name="fceReviewDtLastUpdateTime"
		value='<%="" + fosterCareReviewDB.getFceReviewDtLastUpdateTime()%>' />

	<impact:validateInput type="hidden"
		name="fceEligibilityDtLastUpdateTime"
		value='<%="" + fosterCareReviewDB.getFceEligibilityDtLastUpdateTime()%>' />

	<impact:validateInput type="hidden" name="disableIncomeResourcesFields"
		value="<%=String.valueOf(disableIncomeResourcesFields)%>" />

	<impact:validateInput type="hidden" name="indRightsTerminated"
		value='<%="" + fosterCareReviewDB.getIndRightsTerminated()%>' />

	<impact:validateInput type="hidden" name="indNoActivePlacement"
		value='<%="" + fosterCareReviewDB.getIndNoActivePlacement()%>' />

	<impact:validateInput type="hidden" name="indNonPrsPaidPlacement"
		value='<%="" + fosterCareReviewDB.getIndNonPrsPaidPlacement()%>' />

	<impact:validateInput type="hidden" name="indNoActiveBloc"
		value='<%="" + fosterCareReviewDB.getIndNoActiveBloc()%>' />

	<impact:validateInput type="hidden" name="indNoOpenPaidEligibility"
		value='<%="" + fosterCareReviewDB.getIndNoOpenPaidEligibility()%>' />


	<!--- ELIGIBILITY DETERMINATION --->
	<impact:ifThen
		test="<%=showEligibility && userIsEligibilitySpecialist
                    && fosterCareReviewDB.getIndEligibleObject() != null%>">
		<table border="0" width="100%" cellSpacing="0" cellPadding="3">
			<tr>
				<td class="ReasonsNotEligibileTitle">
					Child is<%=fosterCareReviewDB.getIndEligible() ? "" : " NOT"%>
					Eligible for Title IV-E Reimbursability
				</td>
			</tr>
			<%
			  if (fosterCareReviewDB.getIndEligible() == false) {
			        List reasonsNotEligible = fosterCareReviewDB.getReasonsNotEligible();
			        Iterator iterator = reasonsNotEligible.iterator();
			%>
			<tr>
				<td class="ReasonsNotEligibileReason">
					<ul>
						<%
						  while (iterator.hasNext()) {
						          FceReasonNotEligibleDB reason = (FceReasonNotEligibleDB) iterator.next();
						          out.print("<li>");
						          out.print(Lookup.simpleDecodeSafe(CodesTables.CFCERNE, reason.getCdReasonNotEligible()));
						          out.print("</li>");
						        }
						%>
					</ul>
				</td>
			</tr>
			<%
			  }
			%>
		</table>
		<br>
	</impact:ifThen>
	<!-- END ELIGIBILITY DETERMINATION -->


	<!-- BEGIN DISPLAY ONLY table -->
	<table cellspacing="0" cellpadding="3" width="100%" class="tableborder">
		<tr>
			<th colspan="4">
				Close Foster Care Reimbursability Determination
			</th>
		</tr>
		<tr>
			<td colspan="4">
				<impact:validateInput name="indReviewInappropriate"
					label="Foster Care Reimbursability Determination is no longer appropriate for this child"
					checked="<%=fosterCareReviewDB.getIndReviewInappropriateString()%>"
					disabled='<%="" + disableInappropriateReview%>' value="true"
					type="checkbox" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtInappropriateComments"
					value="<%=fosterCareReviewDB.getTxtInappropriateComments()%>"
					label="Comments" conditionallyRequired="true" type="text"
					colspan="3" cssClass="formInput"
					disabled='<%="" + disableInappropriateReview%>' size="80"
					constraint="Paragraph80" maxLength="80" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>

	<br>
	<!--SIR 23890 renamed BLOC to BSL    -->
	<table cellspacing="0" cellpadding="3" width="100%" class="tableborder">
		<tr>
			<th colspan="4">
				Child Information
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="nmChild" label="Child's Name"
					value="<%=fosterCareReviewDB.getNmPersonFull()%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dtBirthString"
					label="Date of Birth"
					value="<%=fosterCareReviewDB.getDtBirthString()%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="nbrSocialSec"
					label="Social Security Number"
					value="<%=fosterCareReviewDB.getNbrSocialSecurity()%>" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="nbrCrsId" label="CRS Id"
					value="<%=fosterCareReviewDB.getNbrCrsId()%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="idPerson" label="Person ID"
					value="<%=fosterCareReviewDB.getIdPersonString()%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="nbrMhn" label="MHN Number"
					value="<%=fosterCareReviewDB.getNbrMhn()%>" />
			</td>
		</tr>
	</table>
	<br>
	<!-- END DISPLAY ONLY table -->




	<!---- INCOME FOR CHILD SECTION ---->
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th>
				Income for Child
			</th>
		</tr>
		<tr>
			<td>
				<%
				  request.setAttribute("tabIndex", tabIndex);
				    request.setAttribute("disableRadios", "" + disableIncomeResourcesFields);
				    request.setAttribute("disableNoIncome", "" + disableIncomeCheckboxes);
				    request.setAttribute("incomeList", fosterCareReviewDB.getIncomeForChild());
				    request.setAttribute("baseNameSuffix", FosterCareReviewConversation.CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE);
				%>
				<%@ include file="/grnds-docs/fce/IncomeListSub.jsp"%>
				<%
				  tabIndex = (Integer) request.getAttribute("tabIndex");
				%>
			</td>
		</tr>
	</table>
	<br>
	<!-- END INCOME FOR CHILD SECTION -->


	<!-- RESOURCES FOR CHILD SECTION -->
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="5">
				Resources for Child
			</th>
		</tr>
		<tr>
			<td colspan="5">
				<%
				  request.setAttribute("tabIndex", tabIndex);
				    request.setAttribute("disableRadios", "" + disableIncomeResourcesFields);

				    request.setAttribute("resourcesList", fosterCareReviewDB.getResourcesForChild());
				    request.setAttribute("baseNameSuffix", FosterCareReviewConversation.CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE);
				%>
				<%@ include file="/grnds-docs/fce/ResourceListSub.jsp"%>
				<%
				  tabIndex = (Integer) request.getAttribute("tabIndex");
				%>
			</td>
		</tr>
	</table>
	<!-- END RESOURCES FOR CHILD -->
	<br>
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th>
				Child Care Section
			</th>
		</tr>
		<tr>
			<td>
				<impact:ExpandableSectionTag name="expendituresInformation"
					tabIndex="<%=tabIndex++%>" label="Expenditures Information">
					<table cellPadding="3" cellSpacing="0" width="100%"
						class="tableBorder">
						<tr>
							<th class="thList">
								Person Receiving Care
							</th>
							<th class="thList">
								Service Provider Name
							</th>
							<th class="thList">
								Monthly Amount Paid
							</th>
						</tr>
						<%
						  List principals = fosterCareReviewDB.getPrinciples();
						      Map<Long, String> personCareReceiveNameList = new HashMap<Long, String>();
						      for (int i = 0; i < principals.size(); i++) {
						        FcePersonDB principal = (FcePersonDB) principals.get(i);
						        personCareReceiveNameList.put(principal.getIdPerson(), principal.getNmPersonFull());
						      }

						      List expendituresList = fosterCareReviewDB.getExpenditures();
						      if (!expendituresList.isEmpty() && expendituresList != null) {
						        int i = 0;
						        Iterator expendituresIterator = expendituresList.iterator();
						        while (expendituresIterator.hasNext()) {
						          FceExpendituresDB expendituresDB = (FceExpendituresDB) expendituresIterator.next();
						          String personCareReceiveId = FceExpendituresDB.ID_PERSON_CARE_RECEIVE + i;
						          String nmServiceProviderId = FceExpendituresDB.NM_SERVICE_PROVIDER + i;
						          String amtPdMonthlyId = FceExpendituresDB.AMT_PD_MONTHLY + i;
						%>
						<tr class="subDetail">
							<td>
								<impact:validateDisplayOnlyField name="<%=personCareReceiveId%>"
									value="<%=personCareReceiveNameList.get(expendituresDB.getIdPerson())%>" />
							</td>
							<td>
								<impact:validateDisplayOnlyField name="<%=nmServiceProviderId%>"
									value="<%=expendituresDB.getNmServiceProvider()%>" />
							</td>
							<td>
								<impact:validateDisplayOnlyField name="<%=amtPdMonthlyId%>"
									value="<%=FormattingHelper.formatMoney(expendituresDB.getAmtPdMonthly())%>" />
							</td>
						</tr>
						<%
						  i++;
						        }
						      }
						%>
					</table>
				</impact:ExpandableSectionTag>
			</td>
		</tr>
	</table>
	<br>

	<!-- BEGIN IV-E Budget Worksheet-->
	<%
	  FcePersonDB child = fosterCareReviewDB.getFcePerson();
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
      <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtCtnblResourceChild()) %></td>
      <td></td>
      <td>Gross Income for Child</td>
      <td>&nbsp;</td>
      <td width="5%"><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtTotalGrossIncomeChild()) %></td>
    </tr>
    <tr>
      <td>Resource Limit</td>
      <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtResourceLimitChild()) %></td>
      <td></td>
      <td>Gross Income Ceiling</td>
      <td>&nbsp;</td>
      <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGrossIncomeCeilingChild()) %></td>
    </tr>
    <tr>
      <td><b>Eligible Based on Resources?</b></td>
      <td><b><%= fosterCareReviewDB.getIndCtnblResChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO %></b></td>
      <td></td>
      <td><b><%= Lookup.simpleDecodeSafe("CSPLSDEF", fosterCareReviewDB.getCdGicSurpDefctChild()) %></b></td>
      <td>&nbsp;</td>
      <td width="10%"><b><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGicSurpDefctChild()) %></b></td>
    </tr>
    <tr>
      <td colspan="3"></td>
      <td><b>Eligible Based on GIC Test?</b></td>
      <td>&nbsp;</td>
      <td><b><%= fosterCareReviewDB.getIndGrossIncChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO %></b></td>
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
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGrossEarnedChild()) %></td>
    <td></td>
  </tr>
  <tr>
    <td>2. Less Standard Deduction $90</td>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtStdEarnedIncomeDeduct()) %></td>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtEarnedLessStdDeduct()) %></td>
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
      <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtDepCareDeducChild()) %></td>
      <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtLessDepCareElig()) %></td>
  </tr>
  <tr>
    <td>6. Net Earned Income</td>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtNetEarnedIncomeChild()) %>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtNetEarnedIncomeChild()) %></td>
  </tr>
  <tr>
    <td>7. Plus Unearned Income</td>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGrossUnEarnedChild()) %></td>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtPlusUnearnedElig()) %></td>
  </tr>
  <tr>
    <td>8. Plus Child Support(Less $50)</td>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtChsupChild()) %></td>
    <td><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtPlusChsupChild()) %></td>
  </tr>
  <tr>
    <td><b>9. Total Countable Income</b></td>
    <td><b><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtCountableIncome()) %></b></td>
    <td><b><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtCountableIncome()) %></b></td>
  </tr>
  <tr>
      <td><b>10. SON</b></td>
      <td><b><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtStdOfNeedChild()) %></b></td>
      <td></td>
  </tr>
  <tr>
    <td><b>11. <%= Lookup.simpleDecodeSafe("CSPLSDEF", fosterCareReviewDB.getCdEligSurpDefctChild()) %></b>(line 9 less SON)</td>
    <td><b><%= FormattingHelper.formatMoney(fosterCareReviewDB.getAmtSurpDefctEligChild()) %></b></td>
    <td></td>
  </tr>
  </table></td>
  </tr>
</table>


	<!-- END IV-E Budget -->
	<br>
	<!-- BEGIN JUDICIAL DETERMINATIONS table -->
	<table cellspacing="0" cellpadding="3" width="100%" class="tableborder">
		<tr>
			<th colspan="4">
				Judicial Requirements
			</th>
		</tr>
<%
    if( StringHelper.isEmptyOrNull(fosterCareReviewDB.getIndPrmncyHearingsDueString()) ){
        // this scenario occurs when child is not in DFCS custody
        // display nothing
    } else if( fosterCareReviewDB.getIndPrmncyHearingsDue() && !fosterCareReviewDB.getIndPrmncyHrngs12Month() ){    
%>
 		<tr>
		    <td>Judicial determination regarding &#34;Reasonable efforts to Finalize the child&#39;s Permanency Plan&#34; is overdue.</td>
		    <td></td>
		</tr>
<%
    } else if ( !fosterCareReviewDB.getIndPrmncyHearingsDue() && !fosterCareReviewDB.getIndPrmncyHrngs12Month() ){
%>
		<tr>
            <td>Judicial determination regarding &#34;Reasonable efforts to Finalize the child&#39;s Permanency Plan&#34; is not overdue.</td>
            <td></td>
		</tr>
<%
    } else if ((fosterCareReviewDB.getIndPrmncyHearingsDue() && fosterCareReviewDB.getIndPrmncyHrngs12Month())
                || (!fosterCareReviewDB.getIndPrmncyHearingsDue() && fosterCareReviewDB.getIndPrmncyHrngs12Month())){
%>
        <tr>
            <td>Date of Judicial Determination regarding &#34;Reasonable efforts to Finalize the child&#39;s Permanency Plan&#34;:</td>
            <td><%= fosterCareReviewDB.getDtPrmncyHrngs12MonthString() %></td>
        </tr>
<%
    }
%>
<%
    if( StringHelper.isEmptyOrNull(fosterCareReviewDB.getIndPrmncyHearingsDueString())
        ||  StringHelper.isEmptyOrNull(fosterCareReviewDB.getIndExtnsionProvided12MnthsString()) ){
        // do not display any message if child is not in dfcs custody status
        // or child is in permanent custody
    } else if( fosterCareReviewDB.getIndPrmncyHearingsDue() && fosterCareReviewDB.getIndExtnsionProvided12Mnths() ){    
%>
        <tr>
            <td>Custody Expiration Date of the current legal status within the past 12 months:</td>
            <td><%= fosterCareReviewDB.getDtExtnsionProvided12MnthsString() %></td>
        </tr>
<%
    } else if ( fosterCareReviewDB.getIndPrmncyHearingsDue() && !fosterCareReviewDB.getIndExtnsionProvided12Mnths() ){
%>
        <tr>
            <td>There is no legal status that gave DFCS an extension of custody within the past 12 months.</td>
            <td></td>
        </tr>
<%
    }
%>
	</table>
	<br>
	<!-- END JUDICIAL DETERMINATIONS table -->

	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableborder">
		<tr>
			<th colspan="4">
				Worker Information
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="nmWorker"
					label="Case Manager's Name"
					value="<%=fosterCareReviewDB.getNmEmployeePersonFull()%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="nbrWorkerPhone" label="Phone"
					value="<%=FormattingHelper.formatPhone(fosterCareReviewDB.getNbrEmployeePersonPhone())%>" />
			</td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td width="60%" class="alignRight">
				<impact:ButtonTag name="btnSubmitApplication1"
					img="btnSaveAndSubmit" form="<%=formName%>" accessKey="U"
					function="alertEligibilitySpecialist();"
					disabled='<%="" + (showSubmitButton == false)%>'
					action="/fce/FosterCareReview/submitReview"
					tabIndex="<%=tabIndex++%>" />
				<impact:ButtonTag name="btnSave" img="btnSave" accessKey="S"
					function="alertEligibilitySpecialist();"
					disabled='<%="" + (showSaveButton == false)%>' form="<%=formName%>"
					action="/fce/FosterCareReview/saveReview"
					tabIndex="<%=tabIndex++%>" />
				<impact:ButtonTag name="btnContinue" img="btnContinue"
					form="<%=formName%>" accessKey="M"
                    function="yes();"
					disabled='<%="" + (showContinueButton == false)%>'
					action="/fce/FosterCareReview/confirmYes"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<%
  // Sir 23012 - Had to add JavaScript calls to the Show Functions to display
  // the questions when loading the page if the appropriate radio buttons were
  // selected.
%>

<table border="0" cellspacing="0" cellpadding="3" width="100%"
	class="tableBorder">
	<tr>
		<th colspan="4">
			Form Launch
		</th>
	</tr>
	<tr>
		<td>
			<impact:documentList pageMode="2" tabIndex="<%=tabIndex++%>">
				<impact:document displayName="Reimbursability Determination"
					protectDocument="true" checkForNewMode="false" docType="FEL02O00"
					docExists="false">
					<impact:documentParameter name="pEvent"
						value="<%=String.valueOf(GlobalData.getUlIdEvent(request))%>" />
					<impact:documentParameter name="pStage"
						value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
					<impact:documentParameter name="pCase"
						value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
				</impact:document>

			</impact:documentList>
		</td>
	</tr>
</table>
