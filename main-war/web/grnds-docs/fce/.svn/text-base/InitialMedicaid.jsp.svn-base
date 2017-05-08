<%    /**  JSP Name:    InitialMedicaid.jsp
       *  Created by:   Gautami Rout
      *  Date Created: 3/15/07
      *
      *
      * Change History:
      *
      * Date      User              Description
      * --------  ----------------  --------------------------------------------------
      * 4/13/09     cwells          Displaying all required and conditionaly required symbols. 
      * 5/14/09     cwells          STGAP00011727 - Decoding type for Income and resources for child section.     
      *
      *
      *
      **/

      %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceMedicaidSI"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.PrincipalsList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>

 
<%
     String BUTTONATTRB = "buttonAttrb";
     String APPROVED_EVENT = "APRV";
     String PENDING_EVENT = "PEND";
     boolean bDisabledSignNow = false;
     int tabIndex = 1;
     boolean noChecked = false;
     BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
     String pageMode = PageMode.getPageMode(request);
     // Get the CCMN04SO output object out of the request
     MedicaidApplicationRetrieveSO medicaidApplicationRetrieveSO = (MedicaidApplicationRetrieveSO) state
                                                                           .getAttribute(
                                                                                         "MedicaidApplicationRetrieveSO",
                                                                                         request);
      if (medicaidApplicationRetrieveSO == null) {
        medicaidApplicationRetrieveSO = new MedicaidApplicationRetrieveSO();
      }
      %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};

window.attachEvent("onload", initializePage);

function initializePage(){
  var x = document.frmInitialMedicaid;
  if(x.indChildCoverage[0].checked == true){
    enablePage();
  }else{
    disablePage();
  }
  if (x.indIcamaIcpc.checked == false) {
  	toggleIcama();
  }
}


function submitPersonDetail( idPerson )
{
    setIsDirtyCalled( true );
    document.frmInitialMedicaid.hdnPersonDetailId.value = idPerson;
    submitValidateForm( "frmInitialMedicaid", "/fce/InitialMedicaid/forwardPersonDetail" );
}

function disablePage()
{
  var x = document.frmInitialMedicaid;
  x.indChild[0].disabled = true;
  x.indChild[1].disabled = true;
  x.cdType.disabled = true;
  x.nmCompany.disabled = true;
  x.nbrPolicy.disabled = true;
  x.nbrGroup.disabled = true;
  x.addrStLn1.disabled = true;
  x.addrStLn2.disabled = true;
  x.addrCity.disabled = true;
  x.addrState.disabled = true;
  x.addrZip.disabled = true;
  x.addrZipSuff.disabled = true;
  x.nbrPhone.disabled = true;
  x.nmPolicyHolder.disabled = true;
  x.dtBegin.disabled = true;
  x.dtEnd.disabled = true;
  x.nmEmployer.disabled = true;
  x.nmEmployeeName.disabled = true;
}

function enablePage()
{
  var x = document.frmInitialMedicaid;
  x.indChild[0].disabled = false;
  x.indChild[1].disabled = false;
  x.cdType.disabled = false;
  x.nmCompany.disabled = false;
  x.nbrPolicy.disabled = false;
  x.nbrGroup.disabled = false;
  x.addrStLn1.disabled = false;
  x.addrStLn2.disabled = false;
  x.addrCity.disabled = false;
  x.addrState.disabled = false;
  x.addrZip.disabled = false;
  x.addrZipSuff.disabled = false;
  x.nbrPhone.disabled = false;
  x.nmPolicyHolder.disabled = false;
  x.dtBegin.disabled = false;
  x.dtEnd.disabled = false;
  x.nmEmployer.disabled = false;
  x.nmEmployeeName.disabled = false;
}

function toggleIcama()
{
  var x = document.frmInitialMedicaid;
  if (x.cdIcamaState.disabled == true) {
	x.cdIcamaState.disabled = false;
  } else {
  	x.cdIcamaState.disabled = true;
  }
  if (x.cdIcamaAsstType.disabled == true) {
	x.cdIcamaAsstType.disabled = false;
  } else {
  	x.cdIcamaAsstType.disabled = true;
  }
  if (x.cdAdoptionType.disabled == true) {
	x.cdAdoptionType.disabled = false;
  } else {
  	x.cdAdoptionType.disabled = true;
  }
  if (x.txtIcamaComments.disabled == true) {
	x.txtIcamaComments.disabled = false;
  } else {
  	x.txtIcamaComments.disabled = true;
  }
}


</script>
<impact:validateErrors />
<impact:validateForm name="frmInitialMedicaid" 
                     method="post" 
                     action="/fce/InitialMedicaid/displayInitialMedicaid" 
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.InitialMedicaidCustomValidation" 
                     pageMode="<%= pageMode %>"
	schema="/WEB-INF/Constraints.xsd">
	 <impact:validateInput type="hidden" name="idPerson" value="<%=String.valueOf(medicaidApplicationRetrieveSO.getIdPerson())%>" />
	<impact:validateInput type="hidden" name="hdnPersonDetailId" value="<%=String.valueOf(medicaidApplicationRetrieveSO.getIdPerson())%>" />
	<impact:validateInput type="hidden" name="hdnDtRemoval" value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getRemvDate())%>" />
	
	
<%
     boolean signNowPressed = Boolean.parseBoolean(state.getAttribute(BUTTONATTRB, request) != null ? 
                                                  state.getAttribute(BUTTONATTRB, request).toString() :
                                                  (String)null);
                                                  
     if(medicaidApplicationRetrieveSO == null){
       medicaidApplicationRetrieveSO = new MedicaidApplicationRetrieveSO();
     }
     String healthZip = medicaidApplicationRetrieveSO.getAddrZip();
     String healthZipSuff = "";
     if(healthZip != null && healthZip != ""){
       if (healthZip.length() > 5) {
          healthZipSuff = healthZip.substring(5);
          healthZip = healthZip.substring(0, 5);
       }
     }
     UserProfile user = UserProfileHelper.getUserProfile(request);
     String cdEventStatus = medicaidApplicationRetrieveSO.getCdEventStatus();
     String bDisabled = "" + APPROVED_EVENT.equals(cdEventStatus);

/*
     if ((pageMode.equals(PageModeConstants.VIEW))
       && ((APPROVED_EVENT.equals(cdEventStatus)) || 
       ((user.hasRight(UserProfile.SEC_ELIGIBILITY) || user.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST)) && 
       ((PENDING_EVENT.equals(cdEventStatus)))))) {
*/
     if (((pageMode.equals(PageModeConstants.VIEW)) && (APPROVED_EVENT.equals(cdEventStatus))) ||
     	((user.hasRight(UserProfile.SEC_ELIGIBILITY) && (PENDING_EVENT.equals(cdEventStatus))))) {
    %>
 
	<br>
	<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
		<tr>
			<th colspan="5">
				Eligibility Specialist Confirmation
			</th>
		</tr>
		<tr>
			<td colspan="2">
				Please confirm:
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="dtProcessed" label="Date Processed" editableMode="<%= EditableMode.ALL %>" disabled="<%= bDisabled %>" required="true" value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtProcessed())%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtComments" editableMode="<%= EditableMode.ALL %>" disabled="<%= bDisabled %>" label="Comments" rows="4" cols="80" maxLength="300" tabIndex="<%= tabIndex++ %>">
					<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getTxtComments()) ? medicaidApplicationRetrieveSO.getTxtComments() : ""%>
				</impact:validateTextArea>
			</td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag name="btnSaveConfirmation" img="btnSaveConfirmation" form="frmInitialMedicaid" action="/fce/InitialMedicaid/saveConfirmationInitialMedicaid" editableMode="<%= EditableMode.ALL %>" restrictRepost="true" disabled="<%= bDisabled %>"
					tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
	</table>
	<%}%>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp; <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
			</td>
		</tr>


	</table>

	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">

		<tr>
			<th colspan=10>
				Child Information
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="ChildName" colspan="2" label="Child's Name" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getChildName()) ? medicaidApplicationRetrieveSO.getChildName() : ""%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="gender" label="Gender" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getGender()) ? Lookup.simpleDecodeSafe("CSEX", medicaidApplicationRetrieveSO.getGender()) : ""%>" />
			</td>
		</tr>
		<tr>
			<td><impact:validateDisplayOnlyField name="race" colspan="2" label="Race" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getRace())? Lookup.simpleDecodeSafe("CRACE", medicaidApplicationRetrieveSO.getRace()) : ""%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dtBirth" label="Date of Birth" value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDob())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="nbrSocialSecurity" colspan="2" label="Social Security Number" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getSsn()) ? medicaidApplicationRetrieveSO.getSsn(): "" %>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="indCitizenshipStatus" label="Citizenship Status" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getCitizenship())? Lookup.simpleDecodeSafe("CCTZNSTA", medicaidApplicationRetrieveSO.getCitizenship()) : ""%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="cdCounty" colspan="2" label="County" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getCounty())? Lookup.simpleDecodeSafe("CCOUNT", medicaidApplicationRetrieveSO.getCounty()) : ""%>" />
		</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dtRemoval" colspan="2" label="Removal Date" value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getRemvDate())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="childPregnancy" label="Child Pregnant?" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getChildPregnancy()) ? medicaidApplicationRetrieveSO.getChildPregnancy() : " "%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="idPerson" colspan="2" label="Person ID" value="<%=String.valueOf(medicaidApplicationRetrieveSO.getIdPerson() != 0 ? medicaidApplicationRetrieveSO.getIdPerson(): "")%>" />
			</td>
			<td>
				&nbsp;
			</td>
			<td>
				<impact:ButtonTag name="btnChildDetail" img="btnDetail" align="right" form="frmInitialMedicaid" action="/fce/InitialMedicaid/forwardPersonDetail"  tabIndex="<%= tabIndex++ %>" />

			</td>
		</tr>
	</table>
	<br>
	<%/*  Begin Expandable Section with List Table */

      %>
	<impact:ExpandableSectionTag anchor="test" name="PrincipalsList" id="PrincipalsList" label="Child's Parent Information (Please select the appropriate mother & father applicant of the child)" tabIndex="<%= tabIndex++ %>">
		<div id="scrollBar" style="height:250;width:100%;overflow:auto" class="tableborderList">
			<table width="100%" cellspacing="0" cellpadding="3" border="0">
				<tr>
					<th class="thList">
						Parent?
					</th>
					<th class="thList">
						Name
					</th>
					<th class="thList">
						Pat.
						<br>
						Est?
					</th>
					<th class="thList">
						Relationship
					</th>
					<th class="thList">
						Date of Birth
					</th>
					<th class="thList">
						Current Address
					</th>
					<th class="thList">
						SSN
					</th>
					<th class="thList">
						Marital
						<br>
						Status
					</th>
					<th class="thList">
						Race
					</th>
				</tr>
				<%List principals = medicaidApplicationRetrieveSO.getPrincipalsBeanList();
                 if (principals == null || principals.size() == 0) {
                 %>
				<tr class="odd">
					<td colspan="9">
						<%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
					</td>
				</tr>
				<%} else {

                  for (int i = 0; i < principals.size(); i++) {
                    String indParentCbxName = "indParent_" + i;
                    String hiddenPersonIdName = "principalPersonId_" + i;
                    String hiddenTsLastUpdateName = "principalLastUpdate_" + i;
                    String hiddenEventIdName = "initialMedicaidEventId_" + i;
                    PrincipalsList principal = (PrincipalsList) principals.get(i);
                %>
				<tr class="<%=FormattingHelper.getRowCss( i + 1 )%>" valign="top">
				    <impact:validateInput type="hidden" name="<%=hiddenPersonIdName%>" value="<%=String.valueOf(principal.getIdPerson())%>" />
                    <impact:validateInput type="hidden" name="<%=hiddenTsLastUpdateName%>" value="<%=String.valueOf(principal.getDtLastUpdateTime())%>" />
                    				
					<td>
						<impact:validateInput type="checkbox" checked="<%= ArchitectureConstants.Y.equals(principal.getIndParent()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" name="<%= indParentCbxName %>" value="<%= String.valueOf( i ) %>" />
					</td>
					<td>
						<a href="javascript: submitPersonDetail( '<%=String.valueOf(principal.getIdPerson())%>')" tabIndex="<%= tabIndex++ %>"  onclick="setIsDirtyCalled(true)"><%=principal.getNmPrincipals()%></a>
					</td>
					<%  String value=principal.getIndPersonPaternityEst();
                        value=value.trim();

                        if(value != null && (value.compareTo("Y")==0))
                        {
                     %>
                          <td align="center" valign="middle">
                             <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif">
                          </td>
                      <%}
                        else{ %>
                          <td align="center" valign="middle">
                          </td>
                    <%}%>
					<td>
						<%=principal.getCdStagePersRelInt() != null ? Lookup.simpleDecodeSafe("CRELVICT", principal.getCdStagePersRelInt()) : "&nbsp;"%>
					<td>
						<%=principal.getDob()%>
					</td>
					<td>
						<%=principal.getAddrPersonStLn1()%>
						<br>
						<%=principal.getAddrPersonCity()%>
						<%=principal.getCdPersonState()%>
						<%=principal.getAddrPersonZip()%>
					</td>
					<td>
						<%=principal.getNbrPersonIdNumber()%>
					</td>
					<td>
						<%=principal.getCdPersonMaritalStatus() != null ? Lookup.simpleDecodeSafe("CMARSTAT", principal.getCdPersonMaritalStatus()) : "&nbsp;"%>
					</td>
					<td>
						<%=principal.getRace()%>
					</td>
				</tr>
				<%} // end for
      }

      %>
			</table>
		</div>
		<%/* this is where the "scrollBar" div tag ends */

      %>
	</impact:ExpandableSectionTag>
	<%/* this is where the "xpandListTable" div tag ends end ESLT */

      %>
	<br>
	<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th colspan=6>
				Medicaid Information
			</th>
		</tr>
		<% boolean isPregnant = "Yes".equals(medicaidApplicationRetrieveSO.getChildPregnancy());
		   if(isPregnant){
         %>
		<tr>
			<td width="15%">

				<impact:validateInput 
				type="radio" 
				id="rbLiveWithMinorParentYes" 
				tabIndex="<%= tabIndex++ %>" 
				name="indChildPregnent" 
				value="true" 
				label="Yes" 
				checked="<%=String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildPregnancy() != null?  medicaidApplicationRetrieveSO.getIndChildPregnancy() : ""))%>" />
				<impact:validateInput 
				type="radio" 
				id="rbLiveWithMinorParentNo" 
				tabIndex="<%= tabIndex++ %>" 
				name="indChildPregnent" 
				value="false"
			    label="No" 
				checked="<%=String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndChildPregnancy() != null?  medicaidApplicationRetrieveSO.getIndChildPregnancy() : ""))%>" />
			</td>
			<td colspan="5">
    			Is the child's pregnancy verified and documented?
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate 
				name="dtEstDeliveryDate" 
				disabled="false" 
				label="Est. Delivery Date" 
				conditionallyRequired="true" 
				value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtEstDeliveryDate())%>" 
				size="10" 
				constraint="Date" 
				tabIndex="<%= tabIndex++ %>" />
			</td>

		</tr>
		<%}%>
		<tr class="even">
			<td width="15%">

				<impact:validateInput 
				type="radio" 
				id="rbIndSupportOrderYes" 
				tabIndex="<%= tabIndex++ %>" 
				name="indChildSupportOrder" 
				value="true" 
				label="Yes" 
				checked="<%=String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildSupportOrder() != null ? medicaidApplicationRetrieveSO.getIndChildSupportOrder() : ""))%>" />
				<impact:validateInput 
				type="radio" 
				id="rbIndSupportOrderYes" 
				tabIndex="<%= tabIndex++ %>" 
				name="indChildSupportOrder" 
				value="false" 
				label="No" 
				checked="<%=String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndChildSupportOrder() != null ? medicaidApplicationRetrieveSO.getIndChildSupportOrder() : "" ))%>" />
			</td>
			<td colspan="5">
				<span class="formRequiredText">*</span> Has Child Support been ordered in the juvenile court?
			</td>
		</tr>
		<tr class="even">
			<td colspan="6">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td width="15%">
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="15%">

				<impact:validateInput 
				type="radio" 
				id="rbIndMedicalAssistChildYes" 
				tabIndex="<%= tabIndex++ %>" 
				name="indMedicalAssistChild" 
				value="true" 
				label="Yes" 
				checked="<%=String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndMedicalAsstChild() != null ? medicaidApplicationRetrieveSO.getIndMedicalAsstChild() : ""))%>" />
				<impact:validateInput 
				type="radio" 
				id="rbIndMedicalAssistChildNo" 
				tabIndex="<%= tabIndex++ %>" 
				name="indMedicalAssistChild" 
				value="false" 
				label="No" 
				checked="<%=String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndMedicalAsstChild() != null ? medicaidApplicationRetrieveSO.getIndMedicalAsstChild() : ""))%>" />
			</td>
			<td colspan="3">
				<span class="formRequiredText">*</span> Was medical assistance needed for the child prior to removal? (If requesting prior months, please provide proof of medical services.
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Months" constraint="Paragraph80" conditionallyRequired="true" colspan="8" name="txtMonths" cssClass="formInput" value="<%=medicaidApplicationRetrieveSO.getTxtMonths() != null ? medicaidApplicationRetrieveSO.getTxtMonths(): ""%>" size="50" maxLength="" tabIndex="<%= tabIndex++ %>" />

			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th>
				Income for Child
			</th>
		</tr>
		<tr>
			<td colspan="6">
				<div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
					<table width="100%" cellspacing="0" cellpadding="3" border="0">
						<tr>
							<th class="thList">
								Name
							</th>
							<th class="thList">
								Type
							</th>
							<th class="thList">
								Amount
							</th>
							<th class="thList">
								Source
							</th>
						</tr>
						<%List incomeList = medicaidApplicationRetrieveSO.getIncomeResourceList();
                          if (incomeList == null || incomeList.size() == 0) {
                        %>
				          <tr class="odd">
					        <td colspan="9">
						       <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
					        </td>
				         </tr>
				        <%} else {
                             for (int i = 0; i < incomeList.size(); i++) {
                               IncomeResourceMedicaidSI incomeResourceMedicaidSI = (IncomeResourceMedicaidSI) incomeList.get(i);
						       if((CodesTables.CINCORES_INC).equals(incomeResourceMedicaidSI.getCdIncRsrcIncome())){
						%>
						 <tr>
							<td>
								<a href="javascript: submitPersonDetail( '<%=String.valueOf(medicaidApplicationRetrieveSO.getIdPerson())%>')" tabIndex="<%= tabIndex++ %>"  onclick="setIsDirtyCalled(true)"><%=medicaidApplicationRetrieveSO.getChildName() != null ? medicaidApplicationRetrieveSO.getChildName(): " " %></a>
							</td>
							<td>
								<%= incomeResourceMedicaidSI.getCdIncRsrcType() != null ? Lookup.simpleDecodeSafe(CodesTables.CINCRSRC, incomeResourceMedicaidSI.getCdIncRsrcType()): " "%>
							</td>
							<td>
								<%=incomeResourceMedicaidSI.getAmtIncRsrc() != null? FormattingHelper.formatMoney(incomeResourceMedicaidSI.getAmtIncRsrc()) : " " %>
							</td>
							<td>
								<%=incomeResourceMedicaidSI.getSdsIncRsrcSource() != null ? incomeResourceMedicaidSI.getSdsIncRsrcSource() : " "%>
							</td>
						</tr>
					   <% }
					     } 
					    }%>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th>
				Resource for Child
			</th>
		</tr>
		<tr>
			<td colspan="6">
				<div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
					<table width="100%" cellspacing="0" cellpadding="3" border="0">
						<tr>
							<th class="thList">
								Name
							</th>
							<th class="thList">
								Type
							</th>
							<th class="thList">
								Amount
							</th>
							<th class="thList">
								Source
							</th>
							<th class="thList">
								Verification Method
							</th>
							<th class="thList">
								Inaccessible?
							</th>
						</tr>
						<%List resourceList = medicaidApplicationRetrieveSO.getIncomeResourceList();
                          if (resourceList == null || resourceList.size() == 0) {
                        %>
				          <tr class="odd">
					        <td colspan="9">
						       <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
					        </td>
				         </tr>
				        <%} else {
                             for (int i = 0; i < resourceList.size(); i++) {
                               IncomeResourceMedicaidSI incomeResourceMedicaidSI = (IncomeResourceMedicaidSI) resourceList.get(i);
						       if((CodesTables.CINCORES_RES).equals(incomeResourceMedicaidSI.getCdIncRsrcIncome())){
						%>
						<tr>
							<td>
								<a href="javascript: submitPersonDetail( '<%=String.valueOf(medicaidApplicationRetrieveSO.getIdPerson())%>')" tabIndex="<%= tabIndex++ %>"  onclick="setIsDirtyCalled(true)"><%=medicaidApplicationRetrieveSO.getChildName() != null ?  medicaidApplicationRetrieveSO.getChildName(): " "%></a>
							</td>
							<td>
								<%=incomeResourceMedicaidSI.getCdIncRsrcType() != null ? Lookup.simpleDecodeSafe(CodesTables.CINCRSRC, incomeResourceMedicaidSI.getCdIncRsrcType()) : " "%>
							</td>
							<td>
								<%=incomeResourceMedicaidSI.getAmtIncRsrc() != null? FormattingHelper.formatMoney(incomeResourceMedicaidSI.getAmtIncRsrc()): " "%>
							</td>
							<td>
								<%=incomeResourceMedicaidSI.getSdsIncRsrcSource() != null ? incomeResourceMedicaidSI.getSdsIncRsrcSource() : " "%>
							</td>
							<td>
								<%=incomeResourceMedicaidSI.getSdsIncRsrcVerfMethod() != null ? incomeResourceMedicaidSI.getSdsIncRsrcVerfMethod() : " "%>
							</td>
							<td>
								<%=incomeResourceMedicaidSI.getIndIncRsrcNotAccess() != null ? incomeResourceMedicaidSI.getIndIncRsrcNotAccess() : " "%>
							</td>
						</tr>
						<% } 
						  }
						 }%>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th colspan=6>
				Child's Health Insurance Coverage
			</th>
		</tr>
		<%String indChildCoverage = medicaidApplicationRetrieveSO.getIndChildCoverage();
	      noChecked = false;

          if (indChildCoverage == null) {
            noChecked = false;
          } else {
            noChecked = ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildCoverage())? false : true;
         }%>
		<tr>
			<td colspan="6">
				<table width="100%">
					<tr>
						<td width="15%">
							<impact:validateInput 
							  type="radio" id="rbChildCoverageYes" 
							  tabIndex="<%= tabIndex++ %>" 
							  name="indChildCoverage" 
							  value="true" 
							  label="Yes" 
                              checked="<%=String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildCoverage() != null ? medicaidApplicationRetrieveSO.getIndChildCoverage() : ""))%>"
							  onClick="enablePage()" />
							<impact:validateInput 
								type="radio" 
								id="rbChildCoverageNo" 
								tabIndex="<%= tabIndex++ %>" 
								name="indChildCoverage" 
								value="false" label="No" 
        						checked="<%=String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndChildCoverage()))%>" 
								onClick="disablePage()" />
						</td>
						<td>
							<span class="formRequiredText">*</span> Is the child covered by any health insurance other than Medicaid?
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan=6>
				If yes, please complete the following section:
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<table width="100%">
					<tr>
						<td width="15%">
							<impact:validateInput 
							type="radio" 
							id="rbHealthYes" 
							tabIndex="<%= tabIndex++ %>" 
							name="indChild" 
							value="true" 
							label="Yes" 
							checked="<%=String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndHealthInsuranceCard()))%>"/>
							<impact:validateInput 
							type="radio" 
							id="rbHealthNo" 
							tabIndex="<%= tabIndex++ %>" 
							name="indChild" value="false" 
							label="No" 
							checked="<%=String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndHealthInsuranceCard()))%>"/>
						</td>
						<td>
							<span class="formCondRequiredText">&#135;</span>&nbsp; Is a copy of health insurance card available?
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="Type" name="cdType" tabIndex="<%= tabIndex++ %>" codesTable="CINSTYPE" value="<%=medicaidApplicationRetrieveSO.getCdType()%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Company Name" name="nmCompany" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getNmCompany()) ?  medicaidApplicationRetrieveSO.getNmCompany() : ""%>" size="30" maxLength="50" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<impact:validateInput type="text" label="Policy No." name="nbrPolicy" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getNbrPolicy()) ? medicaidApplicationRetrieveSO.getNbrPolicy() : ""%>" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<impact:validateInput type="text" label="Group No." name="nbrGroup" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getNbrGroup()) ? medicaidApplicationRetrieveSO.getNbrGroup() : ""%>" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Street" constraint="Address" name="addrStLn1" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrStreetLn1()) ? medicaidApplicationRetrieveSO.getAddrStreetLn1() : ""%>" size="30" maxLength="" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
			<td>
				<impact:validateInput type="text" label="" constraint="Address" name="addrStLn2" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrStreetLn2()) ? medicaidApplicationRetrieveSO.getAddrStreetLn2() : ""%>" size="30" maxLength="" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="City" constraint="City" name="addrCity" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrCity()) ? medicaidApplicationRetrieveSO.getAddrCity() : ""%>" size="20" maxLength="" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<impact:validateSelect label="State" name="addrState" tabIndex="<%= tabIndex++ %>" codesTable="CSTATE" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrState()) ? medicaidApplicationRetrieveSO.getAddrState() : ""%>" />
			<td>
				<impact:validateInput type="text" label="Zip" constraint="Zip" name="addrZip" cssClass="formInput" value="<%=StringHelper.isValid(healthZip) ? healthZip : ""%>" size="5" maxLength="5" tabIndex="<%= tabIndex++ %>" />
				<impact:validateInput type="text" constraint="ZipSuff" name="addrZipSuff" cssClass="formInput" value="<%=StringHelper.isValid(healthZipSuff) ? healthZipSuff : ""%>" size="4" maxLength="4" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Phone" constraint="Phone" name="nbrPhone" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getNbrPhone()) ? FormattingHelper.formatPhone(medicaidApplicationRetrieveSO.getNbrPhone()) : ""%>" size="12" maxLength="" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
	    <% List principals1 = medicaidApplicationRetrieveSO.getAllPrincipalsBeanList();
	       List policyHolderNameList = new ArrayList();
	        if (principals1 == null || principals1.size() == 0) {
                 %>
				<tr class="odd">
					<td colspan="9">
						<%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
					</td>
				</tr>
		   <%} else {
               for (int i = 0; i < principals1.size(); i++) {
                 PrincipalsList principal = (PrincipalsList) principals1.get(i);
                 policyHolderNameList.add(new Option(String.valueOf(principal.getNmPrincipals()), principal.getNmPrincipals()));
               }
           }%>
		<tr>
			<td>
				<impact:validateSelect label="Policy Holder" name="nmPolicyHolder" options="<%=policyHolderNameList%>" blankValue="true" tabIndex="<%=tabIndex++%>" value="<%=medicaidApplicationRetrieveSO.getNmPolicyHolder()%>"style="WIDTH: 180px" />
			</td>
			<td>
				<impact:validateDate name="dtBegin" disabled="false" label="Begin Date" required="false" value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtBegin())%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<impact:validateDate name="dtEnd" disabled="false" label="End Date" required="false" value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtEnd())%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" colspan="2" label="Employer's Name" name="nmEmployer" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getNmEmployer()) ? medicaidApplicationRetrieveSO.getNmEmployer() : ""%>" size="30" maxLength="50" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<impact:validateInput colspan="2" type="text" label="Employee's Name" name="nmEmployeeName" cssClass="formInput" value="<%=StringHelper.isValid(medicaidApplicationRetrieveSO.getNmEmployeeName()) ? medicaidApplicationRetrieveSO.getNmEmployeeName() : "" %>" size="30" maxLength="50" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<td>
				<table border="0" cellpadding="3" width="100%" class="tableBorder">
					<tr>
						<th colspan="4">
							Final/ICAMA
						</th>
					</tr>
					<tr>
						<td colspan="2">
							<impact:validateInput cssClass="formInput" type="checkbox" name="indIcamaIcpc" checked="<%= ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndIcamaIcpc()) ? "true" : "false" %>" value="Y" label="Child Receives Out of State Assistance" tabIndex="<%= tabIndex++ %>" onClick="toggleIcama()"/>
						</td>
						<td align="right">
							<impact:validateSelect colspan="1" label="State" name="cdIcamaState" codesTable="CSTATE" conditionallyRequired="true" tabIndex="<%= tabIndex++ %>" value="<%= medicaidApplicationRetrieveSO.getCdIcamaState() %>"/>
						</td>
					</tr>
					<tr>
						<td align="left">
							<impact:validateSelect colspan="1" label="Type of Assistance" name="cdIcamaAsstType" conditionallyRequired="true" codesTable="COSATYPE" tabIndex="<%= tabIndex++ %>" value="<%= medicaidApplicationRetrieveSO.getCdIcamaAsstType() %>"/>
						</td>
						<td align="right">
							<impact:validateSelect label="Adoption Type" name="cdAdoptionType" codesTable="CAICTYPE" conditionallyRequired="true" tabIndex="<%= tabIndex++ %>" value="<%= medicaidApplicationRetrieveSO.getCdAdoptionType() %>"/>
						</td>
					</tr>
					<tr>
						<td>
			             <impact:validateTextArea colspan="3" label="Comments" name="txtIcamaComments" rows="5" cols="105" tabIndex="<%= tabIndex++ %>" conditionallyRequired="true" maxLength="300" disabled="false" constraint="Paragraph500">
			             	<%= medicaidApplicationRetrieveSO.getTxtIcamaComments() != null ?  medicaidApplicationRetrieveSO.getTxtIcamaComments() : " " %>
			             </impact:validateTextArea>
			             </td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<td>
				<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
					<tr>
						<th colspan="4">
							Case Manager Signature
						</th>
					</tr>
					<tr>
						<td colspan="4">
							If you chose to use the GA SHINES system application to apply for Foster Care Medicaid you may submit the application using an electronic signature by clicking the "Sign Now" button below. By clicking the "Sign Now" button you are under penalty of
							perjury" of law and accept responsibility for the information being submitted. If you chose to complete the system application, you will be able to review and check your answers at any point during the application process. At the end of the
							application process you will be able to Save and Submit the application to be assigned to a Medicaid Eligibility Specialist (MES) for Initial Medicaid Determination. If you want a copy of this Initial Application page for the case record, you may
							print this page for proof of this application. Clicking on the "Sign Now" button means that you accept responsibility for the correctness for all the information given on this application. Clicking on the "Sign Now" button allows the Medicaid
							Eligibility Specialist to accept and finish working on this system application. If you do not click the "Sign Now" button, the MES will not be able to process this application. If you do not submit the system application within 48 hours, the
							Applicant will not receive proof of a current Medicaid Number in the Person Identifiers section of Persons Detail. The Medicaid Number will be listed as a Person Identifier in the GA SHINES system (Medicaid/MHN # or Temp Medicaid #).
						</td>
					</tr>
					<%if(signNowPressed || (medicaidApplicationRetrieveSO.getDtSigned() != null )){
					  bDisabledSignNow = true;
					}%>
					<tr>
						<td colspan="4">
							<impact:validateInput type="checkbox" id="indCaseManagerApply" tabIndex="<%= tabIndex++ %>" name="indCaseManagerApply" value="true"
								label="I choose to apply for Medicaid benefits for the applicant (Foster Child). I choose to apply using the system application and authorize processing of this system application with my electronic signature." 
								checked="<%=String.valueOf(medicaidApplicationRetrieveSO.getIndCaseManagerApply())%>" 
								disabled="<%=String.valueOf(bDisabledSignNow)%>" />
						</td>
					</tr>
					<%if(medicaidApplicationRetrieveSO.getDtSigned() != null ){%>
					<tr>
						<td>
							<impact:validateDisplayOnlyField name="nmCmSigned" label="Case Manager's Name" value="<%=medicaidApplicationRetrieveSO.getNmCaseManager()%>" />
						</td>
						<td>
							<impact:validateDisplayOnlyField name="dtCmSigned" label="Date Signed" value="<%=FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtSigned())%>" />
						</td>
					</tr>
					<%}%>
					<tr>
						<td colspan="4">
							<impact:ButtonTag name="btnSignNow" img="btnSignNow" align="right" form="frmInitialMedicaid" action="/fce/InitialMedicaid/signNowApplication" tabIndex="<%= tabIndex++ %>" disabled="<%=String.valueOf(bDisabledSignNow)%>"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<%
     if (!((pageMode.equals(PageModeConstants.VIEW)) && (APPROVED_EVENT.equals(cdEventStatus))) &&
     	!((user.hasRight(UserProfile.SEC_ELIGIBILITY)) && (PENDING_EVENT.equals(cdEventStatus)))) {
    %>
	<table cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td align="right" width="95%">
				<impact:ButtonTag name="btnSaveFinal" img="btnSave" form="frmInitialMedicaid" action="/fce/InitialMedicaid/saveInitialMedicaid" align="right" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td align="right" width="5%">
				<impact:ButtonTag name="btnSubmitApplicationFinal" img="btnSaveAndSubmit" form="frmInitialMedicaid" action="/fce/InitialMedicaid/saveAndSubmitApplication" align="right" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
	</table>
	<% } %>
	<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
expandCollapsed('expandedPrincipalsList', 'collapsedPrincipalsList');
</script>
