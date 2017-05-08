<%//
      //----------------------------------------------------------------------------
      //*  JSP Name:     ChildrenFirstReferral - Children 1st Referral in SHINES
      //*  Created by:   Ashwini Rege
      //*  Date Created: 1/18/2010
      //*
      //*  Description:
      //*  This JSP is used to maintain a Children 1st Referral information
      //*   Change History:
      //*   Date         User      Description
      //*   --------   --------  --------------------------------------------------
      //*   02/01/2010  arege    Delete button should not display when the Page Mode is NEW
      //*   02/08/2010  arege    STGAP00015749:Added new field Release on File
      //*   02/25/2010  cwells   SMS 46063: Locking down form when the referral comp checkbox is checked 
      //*   02/26/2010  arege    SMS46400: Marking Referral Complete should display confirmation message
      //**%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@page import="java.util.Date"%>
<%
  int tabIndex = 1;

  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  int userId = userProfile.getUserID();

  String pageMode = PageModeConstants.MODIFY;
  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }

  //-- one boolean for each button to represent if the button should be displayed
  boolean narrative = true;
  boolean save = true;
  boolean delete = true;
  boolean docExists = false;
  //-- one String to represent if fields should be disabled
  String disableFields = "false";
  String disableGenSentRelComp = "false";

  //Initialize the variables for the page

  String szDtReferGene = StringHelper.EMPTY_STRING;
  String szDtReferSent = StringHelper.EMPTY_STRING;
  String indRelSigned = StringHelper.EMPTY_STRING;
  String cbxReferComp = StringHelper.EMPTY_STRING;
  String szDtAckRefRecd = StringHelper.EMPTY_STRING;
  String szDtPhyHelSumRecd = StringHelper.EMPTY_STRING;
  String indPhyFollowUp = StringHelper.EMPTY_STRING;
  String szDtFamSrvTrtPlan = StringHelper.EMPTY_STRING;
  String relOnFile = StringHelper.EMPTY_STRING;
  boolean protectDoc = false;

  String szCdEventType = StringHelper.EMPTY_STRING;
  String dtDtEventOccurred = "";
  int ulIdEvent = 0;
  int ulIdStage = 0;
  int ulIdPerson = 0;
  String szTxtEventDescr = StringHelper.EMPTY_STRING;
  String szCdTask = StringHelper.EMPTY_STRING;
  String szCdEventStatus = StringHelper.EMPTY_STRING;
  String evtsLastUpdate = StringHelper.EMPTY_STRING;
  String childName = StringHelper.EMPTY_STRING;

  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  ChildrenFirstReferralRetrieveSO childrenFirstReferralRetrieveSO = (ChildrenFirstReferralRetrieveSO) state
                                                                                                           .getAttribute(
                                                                                                                         "ChildrenFirstReferralRetrieveSO",
                                                                                                                         request);

  if (childrenFirstReferralRetrieveSO != null) {
    szDtReferGene = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtDtGeneration());
    szDtReferSent = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtDtReferralSent());
    indRelSigned = childrenFirstReferralRetrieveSO.getIndParentalRelease();
    cbxReferComp = childrenFirstReferralRetrieveSO.getIndComplete();
    szDtAckRefRecd = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtDtAcknowledge());
    szDtPhyHelSumRecd = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtPhySummary());
    indPhyFollowUp = childrenFirstReferralRetrieveSO.getIndFurtherAssmt();
    relOnFile = childrenFirstReferralRetrieveSO.getRelOnFile();
    szDtFamSrvTrtPlan = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtIFSP());
    docExists = (ArchitectureConstants.TRUE).equals(childrenFirstReferralRetrieveSO.getBIndBLOBExistsInDatabase());
    protectDoc = ArchitectureConstants.Y.equals(cbxReferComp) ? true : false;
    childName = childrenFirstReferralRetrieveSO.getChildName();
  } else {
    childrenFirstReferralRetrieveSO = new ChildrenFirstReferralRetrieveSO();
  }

  ROWCCMN45DO eventDetails = null;

  if (childrenFirstReferralRetrieveSO.getRowccmn45do() == null) {
    eventDetails = new ROWCCMN45DO();
  } else {
    eventDetails = childrenFirstReferralRetrieveSO.getRowccmn45do();
  }

  // Retrieved data from the event table.
  if (eventDetails != null && eventDetails.getUlIdEvent() != 0) {
    szCdEventType = eventDetails.getSzCdEventType();
    dtDtEventOccurred = FormattingHelper.formatDate(eventDetails.getDtDtEventOccurred());
    ulIdEvent = eventDetails.getUlIdEvent();
    ulIdStage = eventDetails.getUlIdStage();
    ulIdPerson = eventDetails.getUlIdPerson();
    szTxtEventDescr = eventDetails.getSzTxtEventDescr();
    szCdTask = eventDetails.getSzCdTask();
    szCdEventStatus = eventDetails.getSzCdEventStatus();
    evtsLastUpdate = DateHelper.toISOStringSafe(eventDetails.getTsLastUpdate());
  }

  if (GlobalData.getUlIdEvent(request) == 0) {
    ulIdPerson = GlobalData.getUlIdPerson(request);
    ulIdStage = GlobalData.getUlIdStage(request);
    szCdTask = GlobalData.getSzCdTask(request);
  }

  if (PageModeConstants.VIEW.equals(pageMode)) {
    save = false;
    disableFields = "true";
    protectDoc = true;
  }

  if (CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus) || PageModeConstants.VIEW.equals(pageMode)) {
    disableGenSentRelComp = "true";
  }

  if (PageModeConstants.NEW.equals(pageMode) || PageModeConstants.VIEW.equals(pageMode)
      || CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus)) {
    delete = false;
  }
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">
// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
};
window.onload = function ()
{
}

function confirmDelete()
{
  return confirm( "<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>" );
}

function confirmSave()
{
  if(document.frmChildrenFirstReferral.cbxReferComp.checked) {
  return confirm( "<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_REF_COMP)%>" );
  } else {
  return true ;
  }
}

</script>

<impact:validateErrors />

<impact:validateForm name="frmChildrenFirstReferral" method="post"
	action="/investigation/ChildrenFirstReferral/saveChildrenFirstReferral"
	pageMode="<%=pageMode%>"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.ChildrenFirstReferralCustomValidation"
	schema="/WEB-INF/Constraints.xsd">

	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
		width="100%">
		<tr>
			<th colspan="4">
				Children 1st Referral Information
			</th>
		</tr>
		<tr class="subDetail">
			<td width="30%">
				<impact:validateDisplayOnlyField name="szDtReferGene"
					label="Date Generated" value="<%=szDtReferGene%>"
					conditionallyRequired="true" />
			</td>
		</tr>
		<tr class="subDetail">
			<td>
				<impact:validateDate type="text" name="szDtReferSent"
					label="Date Referral Sent" constraint="Date"
					conditionallyRequired="true" value="<%=szDtReferSent%>" size="10"
					tabIndex="<%=tabIndex++%>" disabled="<%=disableGenSentRelComp%>" />
			</td>
		</tr>
		<tr class="subDetail">
			<td>
				Release of Information Form Signed by Parents:
			</td>
			<td>

				<impact:validateInput
					checked="<%=ArchitectureConstants.Y.equals(indRelSigned) ? "true" : "false"%>"
					tabIndex="<%=tabIndex++%>" value="Y" type="radio"
					name="rbRelSigned" disabled="<%=disableGenSentRelComp%>"
					id="indRelSigned" label="Yes" cssClass="formInput" />
				<impact:validateInput
					checked="<%=ArchitectureConstants.N.equals(indRelSigned) ? "true" : "false"%>"
					tabIndex="<%=tabIndex++%>" value="N" type="radio"
					name="rbRelSigned" disabled="<%=disableGenSentRelComp%>"
					id="indRelSigned" label="No" cssClass="formInput" />
			</td>
		</tr>
		<tr class="subDetail">
			<td>
				<impact:validateInput label="Referral Complete" name="cbxReferComp"
					type="checkbox" editableMode="<%=EditableMode.ALL%>"
					checked="<%=ArchitectureConstants.Y.equals(cbxReferComp) ? "true" : "false"%>"
					value="true" tabIndex="<%=tabIndex++%>"
					disabled="<%=disableGenSentRelComp%>" />
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<table>
					<tr>
						<td>
							<b>Note:When launching the referral from the Investigation or
								Ongoing stages, ensure that correct biological parent
								information has been entered on the Caregiver/Parental
								Relationship Information for Child section of the child's Person
								Detail page to correctly pre-fill information for the mother and
								father. When launching from the FCC or ADO stage, ensure that
								the stage person relationships have been updated for the child.</b>
						</td>
					</tr>

				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<table border="0" cellspacing="0" cellpadding="3"
					class="tableBorder" width="100%">
					<tr>
						<th colspan="4">
							Return Information
						</th>
					</tr>

					<tr class="subDetail">
						<td width="30%">
							<impact:validateDate type="text" name="szDtAckRefRecd"
								label="Acknowledgement of Referral Received" constraint="Date"
								value="<%=szDtAckRefRecd%>" size=" 10"
								tabIndex="<%=tabIndex++%>" disabled="<%=disableFields%>" />
						</td>
					</tr>

					<tr class="subDetail">
						<td width="30%">
							<impact:validateDate type="text" name="szDtPhyHelSumRecd"
								label="BCW Physician's Health Summary Received" constraint="Date"
								value="<%=szDtPhyHelSumRecd%>" size="10" onChange ="clearIndFurAssmt()"
								tabIndex="<%=tabIndex++%>" disabled="<%=disableFields%>" />
						</td>
					</tr>

					<tr class="subDetail">
						<td>
							Physician Indicated Need for Further Developmental Assmt:
						</td>
						<td>
							<impact:validateInput
								checked="<%=ArchitectureConstants.Y.equals(indPhyFollowUp) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="Y" type="radio"
								name="rbPhyFollowUp" disabled="false" id="indPhyFollowUp"
								label="Yes" cssClass="formInput" disabled="<%=disableFields%>" />
							<impact:validateInput
								checked="<%=ArchitectureConstants.N.equals(indPhyFollowUp) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="N" type="radio"
								name="rbPhyFollowUp" disabled="false" id="indPhyFollowUp"
								label="No" cssClass="formInput" disabled="<%=disableFields%>" />
						</td>
					</tr>
					<tr>
						<td width="30%">
							<impact:validateDate type="text" name="szDtFamSrvTrtPlan"
								label="BCW Child Individual Family Service Plan Summary/Treatment Plan Received"
								constraint="Date" conditionallyRequired="true"
								value="<%=szDtFamSrvTrtPlan%>" size="10"
								tabIndex="<%=tabIndex++%>" disabled="<%=disableFields%>" />
						</td>
					</tr>
					<tr class="subDetail">
						<td>
							Release on File:
						</td>
						<td>
							<impact:validateInput
								checked="<%=ArchitectureConstants.Y.equals(relOnFile) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="Y" type="radio"
								name="rbRelOnFile" id="indRelOnFile"
								label="Yes" cssClass="formInput" disabled="<%=disableFields%>" />
							<impact:validateInput
								checked="<%=ArchitectureConstants.N.equals(relOnFile) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="N" type="radio"
								name="rbRelOnFile" id="indRelOnFile"
								label="No" cssClass="formInput" disabled="<%=disableFields%>" />
							<impact:validateInput
								checked="<%="R".equals(relOnFile) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="R" type="radio"
								name="rbRelOnFile" id="indRelOnFile"
								label="Rescinded" cssClass="formInput" disabled="<%=disableFields%>" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<table>
								<tr>
									<td>
										<b>Note:Please update the child's Health Log with the Developmental Screen on receipt of the Physician's Health Summary 
										and/or the Developmental Assessment on receipt of the Child Individual Family Service Plan Summary. 
										Upload the documents as appropriate to External Documentation.</b>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<table border="0" cellspacing="0" cellpadding="3"
					class="tableBorder" width="100%">
					<tr>
						<th colspan="4">
							Additional Information
						</th>
					</tr>
					<tr class="subDetail">
						<td width="30%">
							<impact:validateTextArea name="szCommts" label="Comments"
								rows="4" cols="100" tabIndex="<%=tabIndex++%>"
								disabled="<%=disableFields%>" constraint="Paragraph500">
								<%=FormattingHelper.formatString(childrenFirstReferralRetrieveSO.getTxtComments())%>
							</impact:validateTextArea>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<%
			  if (delete) {
			%>
			<td class="alignLeft">
				<impact:ButtonTag name="btnDelete" img="btnDelete" align="left"
					restrictRepost="true" preventDoubleClick="true"
					form="frmChildrenFirstReferral"
					action="/investigation/ChildrenFirstReferral/deleteChildrenFirstReferral"
					function="return confirmDelete()"					
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
			  }
			    if (save) {
			%>
			<td class="alignRight">
				<impact:ButtonTag name="btnSave" img="btnSave" restrictRepost="true"
					preventDoubleClick="true" form="frmChildrenFirstReferral"
					action="/investigation/ChildrenFirstReferral/saveChildrenFirstReferral"
					function="return confirmSave()"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
			  }
			%>
		</tr>
	</table>

	<input type="hidden" name="szCdEventType" value="<%=szCdEventType%>">
	<input type="hidden" name="dtDtEventOccurred"
		value="<%=dtDtEventOccurred%>">
	<input type="hidden" name="ulIdEvent" value="<%=ulIdEvent%>">
	<input type="hidden" name="ulIdStage" value="<%=ulIdStage%>">
	<input type="hidden" name="ulIdPerson" value="<%=ulIdPerson%>">
	<input type="hidden" name="szTxtEventDescr"
		value="<%=szTxtEventDescr%>">
	<input type="hidden" name="szCdTask" value="<%=szCdTask%>">
	<input type="hidden" name="szCdEventStatus"
		value="<%=szCdEventStatus%>">
	<input type="hidden" name="evtsLastUpdate" value="<%=evtsLastUpdate%>">
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<br />
<%
  /* begin Forms and Reports  */
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th>Forms</th>
  </tr>
  <tr>
    <td>

<impact:documentList pageMode="<%=pageMode%>" tabIndex="<%=tabIndex++%>">
  
    <impact:document displayName="Children 1st Referral"
                        protectDocument="<%=protectDoc%>"
                        checkForNewMode="true"
                        docType="scrnref"
                        docExists="<%=docExists%>">
<impact:documentParameter name="userId" value="<%=String.valueOf(userId)%>" />                     
<impact:documentParameter name="stageId" value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
<impact:documentParameter name="pEvent" value="<%=String.valueOf(GlobalData.getUlIdEvent(request))%>" />
<impact:documentParameter name="pCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
<impact:documentParameter name="pStage" value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
<impact:documentParameter name="pPerson" value="<%=String.valueOf(childrenFirstReferralRetrieveSO.getIdChildReferred())%>" />
<impact:documentParameter name="pUser" value="<%=String.valueOf(userId)%>" />
<impact:documentParameter name="userName" value="<%=childName%>" />

  </impact:document>
</impact:documentList>
    </td>
  </tr>
</table>


<%
  /* end Forms and Reports */
%>





