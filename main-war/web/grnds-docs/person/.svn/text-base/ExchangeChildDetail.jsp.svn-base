
<%--
JSP Name:     ExchangeChildDetail.jsp
Date Created: 03/27/08

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
07/01/08  mchillman         JSP creation
08/18/08  vdevarak			Initial implementation
01/27/09  wjcochran			STGAP00012039: Changed formatting of Dates in the 
							registration information section
01/27/09  wjcochran			STGAP00012158: Added expand all/collapse all logic]
02/02/09  wjcochran  		STGAP00012114: Added logic to prevent the birth name 
							from displaying if a child has not had an adoption disruption
04/08/09  wjcochran			STGAP00012984: Added hdnIdResource variable to ensure
							the global idResource can be set if you navigate to an exchange
							home detail page.
04/15/09  hjbaptiste        STGAP00013290: Replaced javascript function that alerts the user to save the page prior
                            to clicking the Match button  	
08/21/09  wjcochran         STGAP00015000: Merged "Now Being Considered By" and "Has Been Considered By" pagination 
						    sections into one pagination section. This enables the sorting functionality to work
						    correctly. The previous sections were causing duplicate variables to be created
						    and also caused duplication of code which impacted sorting functionality.	
12/05/09  mxpatel           SMS # 37348: created hidden variable hdnCdReasonClosed.					
12/06/09  arege             SMS#40965 The Dissolution Date in the Closed With Placement section should be modifiable with a Date ticker.
12/15/09  mxpatel         	SMS# 37447:  created hidden variable hdnTxtBirthName.	
02/21/11  htvo              SMS#97845 MR-074-2: added new section for Putative Father
05/24/11  hnguyen           SMS#109405: MR-083 Added new Actively Recruiting question for Recruitment Activities section. Increased comments
                            for Child Availability section to 2000 characters and increased comment field for recruitment activities to 1000
                            characters. Turned on client-side validations. Also cleaned up code to be more dynamic.
					    					
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page
    import="gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailRetrieveSO"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildStruct"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLinkStruct"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.person.ExchangeChildDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>

<%
  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO = (ExchangeChildDetailRetrieveSO) state
                                                                                                .getAttribute(
                                                                                                              ExchangeChildDetailConversation.EXCHANGE_CHILD_DETAIL,
                                                                                                              request);
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  boolean iterator = false;
  String birthNameToDisplay = "";
  int loopCount = 0;
  int hasBeenLoopCount = 0;
  String nonAvailRsnCode = "";
  String linkNonAvailRsnCode = "";
  Date dateOut = null;
  int idEvent = 0;
  int idStage = GlobalData.getUlIdStage(request);
  boolean indMatching = false;
  ExchangeChildStruct excChildStruct = new ExchangeChildStruct();
  List<ChildLinkStruct> childLinkStructList = new ArrayList<ChildLinkStruct>();
  List<ChildLinkStruct> hasBeenChildLinkStructList = new ArrayList<ChildLinkStruct>();
  Map<String,List<ExcChildAdoInfoCbxStruct>> savedRecActivitiesDatesState = new HashMap<String,List<ExcChildAdoInfoCbxStruct>>();
  if (exchangeChildDetailRetSO == null) {
    exchangeChildDetailRetSO = new ExchangeChildDetailRetrieveSO();
  } else {
    if (exchangeChildDetailRetSO.getExchangeChildStruct() != null) {
      excChildStruct = exchangeChildDetailRetSO.getExchangeChildStruct();
      nonAvailRsnCode = excChildStruct.getCdNonAvailStatus();
      idEvent = excChildStruct.getIdChildEvent();
    }
    if (exchangeChildDetailRetSO.getChildLinkStructList() != null) {
      childLinkStructList = exchangeChildDetailRetSO.getChildLinkStructList();
    }
    if (exchangeChildDetailRetSO.getHasBeenChildLinkStructList() != null) {
      hasBeenChildLinkStructList = exchangeChildDetailRetSO.getHasBeenChildLinkStructList();
    }
    if (exchangeChildDetailRetSO.getDtDissolution() != null) {
      birthNameToDisplay = excChildStruct.getTxtBirthName();
    } else {
      birthNameToDisplay = "";
    }
    if(exchangeChildDetailRetSO.getSavedRecActivitiesDates() != null)
    {
      savedRecActivitiesDatesState = exchangeChildDetailRetSO.getSavedRecActivitiesDates();
    }
  }
  if (childLinkStructList != null && childLinkStructList.size() > 0) {
    Iterator iter = childLinkStructList.iterator();
    while (iter.hasNext()) {
      ChildLinkStruct childLinkStruct = (ChildLinkStruct) iter.next();
      if (!childLinkStruct.isIndLinked()) {
        indMatching = true;
        break;
      }
    }
  }
  if (indMatching) {
    linkNonAvailRsnCode = CodesTables.CANONAV_03;
  } else {
    linkNonAvailRsnCode = CodesTables.CANONAV_00;
  }
  // MR-074-2
  boolean multiPutativePather = exchangeChildDetailRetSO.isMultiPutFather() ? true : false;

  // MR-083
  String cdStateActivelyRecruiting = exchangeChildDetailRetSO.getCdStateActivelyRecruiting();
  List<CodeAttributes> activityCodesList = Lookup.getCategoryCollection(CodesTables.CADRACS);
  
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="Javascript1.2">
// Check for changes before navigating off
window.onbeforeunload = function ()
{
   IsDirty();
};

function checkSave() {
 if(isPageChanged()) {
 	alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_SAVE_BEFORE_MATCH)%>");
 	return false;
 }
 
 return true;
}

function getExchangeChildDetail(idHomeEvent, idResource, nmHome)
{
  frmExchangeChildDetail.hdnIdHomeEvent.value = idHomeEvent;
  frmExchangeChildDetail.hdnIdResource.value = idResource;
  frmExchangeChildDetail.hdnIdHomeName.value = nmHome
  submitValidateForm( "frmExchangeChildDetail", "/person/ExchangeChildDetail/displayHomeDetail" );
}

function getAdoInfoPage(idChildEvent, idStage)
{
  frmExchangeChildDetail.hdnIdChildEvent.value = idChildEvent;
  frmExchangeChildDetail.hdnIdStage.value = idStage;
  submitValidateForm( "frmExchangeChildDetail", "/person/ExchangeChildDetail/displayAdoInfo" );
}

function confirmDelete() {
 return confirm('<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>');
}
</script>
<impact:validateErrors formName="frmExchangeChildDetail" />
<impact:validateForm name="frmExchangeChildDetail"
	action="/person/ExchangeChildDetail/saveExchangeChildDetail"
	clientValidation="true"
	pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.ExchangeChildDetailCustomValidation">
    <impact:validateInput type="hidden" name="hdnIdHomeEvent" value="" />
    <impact:validateInput type="hidden" name="hdnIdChildEvent" value="" />
    <impact:validateInput type="hidden" name="hdnIdStage" value="" />
    <impact:validateInput type="hidden" name="hdnIdResource" value="" />
    <impact:validateInput type="hidden" name="hdnCdReasonClosed" value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getExchangeChildStruct().getCdRsnClosed())%>" />
    <impact:validateInput type="hidden" name="hdnTxtBirthName" value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getExchangeChildStruct().getTxtBirthName())%>" />
    <impact:validateInput type="hidden" name="hdnIdSiblGroup" value="<%=FormattingHelper.formatInt(exchangeChildDetailRetSO.getIdSiblingGroup())%>" />
    <impact:validateInput type="hidden" name="hdnIdHomeName" value="" />
	<%-- Begin Child Information --%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<a tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;" href="javascript:expandAll()">Expand All</a>&nbsp; <a tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;" href="javascript:collapseAll()">Collapse All</a>&nbsp;
			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
		width="100%" id="TABLE1">
		<tr>
			<th colspan="12">
				Child Information
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspNmChild"
					label="Child Name"
					value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getNmChild())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspGender" label="Gender"
					value="<%=Lookup.simpleDecodeSafe(CodesTables.CSEX, exchangeChildDetailRetSO.getCdGender())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspStatus" label="Status"
					value="<%=Lookup.simpleDecodeSafe(CodesTables.CANONAV, excChildStruct.getCdNonAvailStatus())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspAge" label="Age"
					value="<%=FormattingHelper.formatInt(exchangeChildDetailRetSO.getChildAge())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspDtBirth"
					label="Date of Birth"
					value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBirthChild())%>" />
			</td>
		</tr>
		<tr>
		<% int idSibGrp = exchangeChildDetailRetSO.getIdSiblingGroup();
		if(idSibGrp>0){ %>
		  <td>
		   Sibling Group ID:
			<a href="javascript:getAdoInfoPage('<%=exchangeChildDetailRetSO.getExchangeChildStruct().getIdChildEvent()%>', '<%=idStage%>')" 
			   onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
				  <%=FormattingHelper.formatInt(idSibGrp)%>
		    </a></td>
		<% }else{ %>
			<td>
				<impact:validateDisplayOnlyField name="dspIdSiblGroup"
					label="Sibling Group ID"
					value="<%=FormattingHelper.formatInt(idSibGrp)%>" />
			</td>
	   <% } %>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspCaseWorkerInfo"
					label="Case Worker"
					value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getCaseWorkerInfo())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspRace" label="Race"
					value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getChildRace())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspEthnicity"
					label="Ethnicity"
					value="<%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getChildEthnicity())%>" />
			</td>
		</tr>
		<tr>
			<td>
				Child Has Legal Risk?
				<impact:validateInput
					checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndLegalRisk())) ? "true"
                                                                                                                      : "false"%>"
					cssClass="formInput" disabled="false" id="indLegalRisk_Yes"
					label="Yes" name="rbIndLegalRisk" tabIndex="<%=tabIndex++%>"
					type="radio" value="Y" />

				<impact:validateInput
					checked="<%=ArchitectureConstants.N.equals(FormattingHelper.formatString(excChildStruct.getIndLegalRisk())) ? "true"
                                                                                                                      : "false"%>"
					cssClass="formInput" disabled="false" id="indLegalRisk_No"
					label="No" name="rbIndLegalRisk" tabIndex="<%=tabIndex++%>"
					type="radio" value="N" />
			</td>
		</tr>
	</table>
	<%-- End Child Information --%>
	<br>
	<%-- Begin Registration Information --%>
	<impact:ExpandableSectionTag name="RegistrationInfo"
		label="Registration Information" tabIndex="<%=tabIndex++%>" id="">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE2">
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtLastEntry"
						label="Last Entry Into Foster Care"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtLastEntryFc())%>" />
				</td>
				<td colspan="5"></td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtNotified"
						label="Date Notified"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtNotified())%>" />
				</td>
				<td colspan="5"></td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtApproved"
						label="Date Approved"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtApproved())%>" />
				</td>
				<td colspan="5"></td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDate name="txtDtRegistered" label="Date Registered"
						constraint="Date" size="10" tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtRegistered())%>" />
				</td>
				<td colspan="4">
					<impact:validateDate name="txtDtReRegistered"
						label="Date Re-Registered" constraint="Date" size="10"
						tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtReRegistered())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtUpdated"
						label="Date Updated"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtUpdated())%>" />
				</td>
				<td colspan="5"></td>
			</tr>
			<tr class="subDetail">
				<td colspan="9">
					<impact:validateInput name="cbxAdoDissolution"
						label="Previous Adoption Dissolution" cssClass="formInput"
						type="checkbox" tabIndex="<%=tabIndex++%>" disabled="true"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(exchangeChildDetailRetSO
                                                                                                           .getIndAdoptDissol())) ? "true"
                                                                                                                                 : "false"%>" />
				</td>
				<td colspan="1"></td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtPrevDissolution"
						label="Previous Dissolution Date"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDissolution())%>" />
				</td>
				<td colspan="5"></td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateInput name="txtNmBirth" label="Birth Name"
						cssClass="formInput" size="30" maxLength="30"
						constraint="Paragraph30" type="text" tabIndex="<%=tabIndex++%>"
						value="<%=birthNameToDisplay%>" />
				</td>
				<td colspan="5"></td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE2">
			<tr class="subDetail">
				<th colspan="9">
					Responsible County
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateDisplayOnlyField name="dspNmCounty"
						label="County Name"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeChildDetailRetSO.getNbrRspCounty())%>" />
				</td>
				<td colspan="3">
					<impact:validateDisplayOnlyField name="dspNbrCounty"
						label="County Number"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getNbrRspCounty())%>" />
				</td>
				<td colspan="3">
					<impact:validateDisplayOnlyField name="dspRegion" label="Region"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CREGIONS, exchangeChildDetailRetSO.getCdRspRegion())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<th colspan="9">
					Boarding County
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateDisplayOnlyField name="dspNmBrdCounty"
						label="County Name"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getNmBrdCounty())%>" />
				</td>
				<td colspan="3">
					<impact:validateDisplayOnlyField name="dspNbrBrdCounty"
						label="County Number"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getNbrBrdCounty())%>" />
				</td>
				<td colspan="3">
					<impact:validateDisplayOnlyField name="dspBrdRegion" label="Region"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CREGIONS, exchangeChildDetailRetSO.getCdBrdRegion())%>" />
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%-- End Registration Information --%>
	<br>
	<%-- Begin Special Needs Characteristics --%>
	<impact:ExpandableSectionTag name="SpecialNeedsChar"
		label="Special Needs Characteristics" tabIndex="<%=tabIndex++%>" id="">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE3">
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxMntlRetard"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndMntlRetard())) ? "true"
                                                                                                                      : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdMntRetSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(excChildStruct.getCdMntlSevLevel())%>" />
				</td>
				<td colspan="2" style="font-weight: bold">
					Background Factors:
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxVislHearImp"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndVisHearImp())) ? "true"
                                                                                                                      : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdVisHearSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(excChildStruct.getCdVisHearSevLevel())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxFamHxDrgAlcohol"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndFamHxDrugs())) ? "true"
                                                                                                                      : "false"%>"
						value="Y" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxPhyDisabled"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndPhyDisabled())) ? "true"
                                                                                                                       : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdPhyDisSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(excChildStruct.getCdPhySevLevel())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxFamHxMentIll"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndFamHxIll())) ? "true"
                                                                                                                       : "false"%>"
						value="Y" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxEmtDisturbed"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper.formatString(excChildStruct.getIndEmtDisturbed())) ? "true"
                                                                                                                        : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdEmtDistSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(excChildStruct.getCdEmtSevLevel())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxFamHxMR"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndFamHxMr())) ? "true"
                                                                                                                      : "false"%>"
						value="Y" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxOthMedDiag"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndOthMed())) ? "true"
                                                                                                                     : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdOthMedDiagSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(excChildStruct.getCdOthSevLevel())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxChHxSxAbuse"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndChHxSxAbuse())) ? "true"
                                                                                                                       : "false"%>"
						value="Y" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="1">
					Comments:
				</td>
				<td colspan="5">
					<impact:validateTextArea colspan="5" name="txtSpclNeedsCmnts"
						rows="4" cols="77" tabIndex="<%=tabIndex++%>" maxLength="500"
						disabled="false" constraint="Paragraph500">
						<%=FormattingHelper.formatString(excChildStruct.getTxtSpclNeedsCmnts())%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%-- End Special Needs Characteristics --%>
	<br>
	<%-- Begin Child Availability --%>
	<impact:ExpandableSectionTag name="ChildAvlbty"
		label="Child Availability" tabIndex="<%=tabIndex++%>" id="">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE4">
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateSelect name="szCdNonAvailRsnCode"
						label="Non-Availability Reason Code" tabIndex="<%=tabIndex++%>"
						codesTable="CANONAV" required="true"
						value="<%=FormattingHelper.formatString(nonAvailRsnCode)%>" />
				</td>
				<td colspan="2">
					<impact:validateDisplayOnlyField name="dspDtOut" label="Date Out"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtOut())%>" />
				</td>
				<td colspan="2">
					<impact:validateDisplayOnlyField name="dspDaysOut" label="Days Out"
						value="<%=FormattingHelper.formatString(excChildStruct.getTxtDaysOut())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="1">
					Comments:
				</td>
				<td colspan="8">
					<impact:validateTextArea colspan="8" name="txtChAvlCmnts" rows="4"
						cols="77" tabIndex="<%=tabIndex++%>" maxLength="2000"
						disabled="false" constraint="Paragraph2000">
						<%=FormattingHelper.formatString(excChildStruct.getTxtAvailCmnts())%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="1">
					Child is Linked:
				</td>
				<td colspan="8">
					<impact:validateTextArea colspan="8" name="txtChLnkCmnts" rows="4"
						cols="77" tabIndex="<%=tabIndex++%>" maxLength="500"
						disabled="false" constraint="Paragraph500">
						<%=FormattingHelper.formatString(excChildStruct.getTxtChLinked())%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="9" class="alignRight">
					<impact:ButtonTag name="btnMatch" align="right" img="btnMatch"
						form="frmExchangeChildDetail"
						action="/person/ExchangeChildDetail/matchHomes"
						restrictRepost="true" preventDoubleClick="true"
						function="return checkSave();" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
		</table>
		<impact:pagination
			submitUrl="/person/ExchangeChildDetail/displayExchangeChildDetail">
			<div id="scrollBar" style="height: 155; width: 100%; overflow: auto"
				class="tableborderList">
				<table border="0" cellspacing="0" cellpadding="3" width="100%">
					<br>
					<tr>
						<th colspan="9">
							Now Being Considered By
						</th>
					</tr>
					<tr>
						<th class="thList">
							Unlink
						</th>
						<th class="thList">
							Resource ID
						</th>
						<th class="thList">
							Name
						</th>
						<th class="thListNoWrap">
							Non-Availability Reason Code
							<impact:sortableColumnHeader
								orderBy="<%=ExchangeChildDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE%>"
								isDefault="false" />
						</th>
						<th class="thList">
							County
						</th>
						<th class="thListNoWrap">
							Date Out
							<impact:sortableColumnHeader
								orderBy="<%=ExchangeChildDetailConversation.SORT_BY_DT_OUT%>"
								isDefault="true" />
						</th>
					</tr>
					<%
					  if (childLinkStructList != null && childLinkStructList.size() > 0) {
					          Iterator it = childLinkStructList.iterator();
					          while (it.hasNext()) {
					            ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();

					            String chkBoxName = "cbxUnLink" + loopCount;
					%>

					<tr class="subDetail">
						<%
						  if (childLinkStruct.isIndLinked()) {
						%>
						<td>
							<impact:validateInput value="<%=String.valueOf(loopCount)%>"
								type="checkbox" checked="false" name="<%=chkBoxName%>"
								tabIndex="<%=tabIndex++%>" cssClass="formInput" />
						</td>
						<%
						  } else {
						%>
						<td></td>
						<%
						  }
						%>
						<td>
						<a href="javascript:getExchangeChildDetail('<%=childLinkStruct.getIdHomeEvent()%>' ,'<%=childLinkStruct.getIdResource()%>','<%=FormattingHelper.formatString(childLinkStruct.getNmResource())%>')" 
						   onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
						 <%=FormattingHelper.formatInt(childLinkStruct.getIdResource())%>
					    </a></td>
						<td><%=FormattingHelper.formatString(childLinkStruct.getNmResource())%></td>
						<td><%=Lookup.simpleDecodeSafe(CodesTables.CANONAV, (childLinkStruct.getNonAvlRsnCode()))%></td>
						<td><%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, (childLinkStruct.getCounty()))%></td>
						<td><%=FormattingHelper.formatDate(childLinkStruct.getDtOut())%></td>
					</tr>
					<%
					  // increment the loop counter
					            loopCount++;
					          }

					        } else {
					%>
					<tr class="odd">
						<td colspan="8">
							No Results Found
						</td>
					</tr>
					<%
					  }
					%>
				</table>
			</div>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE2">
			<tr class="subDetail">
				<td>
					<impact:validateSelect name="szCdNonAvailRsn"
						label="Non-Availability Reason" tabIndex="<%=tabIndex++%>"
						codesTable="CANONAV" value="<%=linkNonAvailRsnCode%>" />
				</td>
				<td>
					<impact:validateDate name="txtDtOutLink" label="Date Out"
						constraint="Date" conditionallyRequired="false" size="10"
						tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatDate(new Date())%>" />
				</td>
				<td class="alignRight">
					<impact:ButtonTag name="btnLink" align="right" img="btnLink"
						form="frmExchangeChildDetail"
						action="/person/ExchangeChildDetail/linkHomes"
						restrictRepost="true" preventDoubleClick="true"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateSelect name="szCdNonSelRsn"
						label="Non-Selection Reason" tabIndex="<%=tabIndex++%>"
						codesTable="CADNSLCT" value="" />
				</td>
				<td></td>
				<td></td>
				<td class="alignRight">
					<impact:ButtonTag name="btnUnlink" align="right" img="btnUnlink"
						form="frmExchangeChildDetail"
						action="/person/ExchangeChildDetail/unLinkHomes"
						restrictRepost="true" preventDoubleClick="true"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td class="alignRight">
					<impact:ButtonTag name="btnDeleteNowConsidering" align="right" img="btnDelete"
						form="frmExchangeChildDetail"
						action="/person/ExchangeChildDetail/deleteNowConsidering"
						restrictRepost="true" preventDoubleClick="true"
						function ="return confirmDelete();"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
		</table>
			<div id="scrollBar" style="height: 155; width: 100%; overflow: auto"
				class="tableborderList">
				<table border="0" cellspacing="0" cellpadding="3" width="100%">
					<br>
					<tr>
						<th colspan="9" class="thList">
							Has been Considered By
						</th>
					</tr>
					<tr>
						<th class="thList">
						</th>
						<th class="thList">
							Resource ID
						</th>
						<th class="thList">
							Name
						</th>
						<th class="thListNoWrap">
							Non-Availability Reason Code
							<impact:sortableColumnHeader
								orderBy="<%=ExchangeChildDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE%>"
								isDefault="false" />
						</th>
						<th class="thList">
							Non-Selection Reason
						</th>
						<th class="thList">
							County
						</th>
						<th class="thListNoWrap">
							Date Out
							<impact:sortableColumnHeader
								orderBy="<%=ExchangeChildDetailConversation.SORT_BY_DT_OUT%>"
								isDefault="true" />
						</th>
						<th class="thList">
							Unlink Date
						</th>
					</tr>
					<%
					  if (hasBeenChildLinkStructList != null && hasBeenChildLinkStructList.size() > 0) {
					          Iterator it = hasBeenChildLinkStructList.iterator();
					          while (it.hasNext()) {
					            ChildLinkStruct hasBeenChildLinkStruct = (ChildLinkStruct) it.next();
					            String chkBoxName = "cbxDelete" + hasBeenLoopCount;
					%>
					<tr class="subDetail">
					   <td>							
							<impact:validateInput value="<%=String.valueOf(loopCount)%>"
								type="checkbox" checked="false" name="<%=chkBoxName%>"
								tabIndex="<%=tabIndex++%>" cssClass="formInput" />
						</td>
					   <td>
						<a href="javascript:getExchangeChildDetail('<%=hasBeenChildLinkStruct.getIdHomeEvent()%>' , '<%=hasBeenChildLinkStruct.getIdResource()%>', '<%=FormattingHelper.formatString(hasBeenChildLinkStruct.getNmResource())%>')" 
						   onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
							  <%=FormattingHelper.formatInt(hasBeenChildLinkStruct.getIdResource())%>
					    </a></td>
						<td><%=FormattingHelper.formatString(hasBeenChildLinkStruct.getNmResource())%></td>
						<td><%=Lookup.simpleDecodeSafe(CodesTables.CANONAV, hasBeenChildLinkStruct.getNonAvlRsnCode())%></td>
						<td><%=Lookup.simpleDecodeSafe(CodesTables.CADNSLCT, hasBeenChildLinkStruct.getNonSelRsn())%></td>
						<td><%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, hasBeenChildLinkStruct.getCounty())%></td>
						<td><%=FormattingHelper.formatDate(hasBeenChildLinkStruct.getDtOut())%></td>
						<td><%=FormattingHelper.formatDate(hasBeenChildLinkStruct.getDtLastUpdate())%></td>
					</tr>
					<%
					  // increment the loop counter
					            hasBeenLoopCount++;
					          }
					        } else {
					%>
					<tr class="odd">
						<td colspan="8">
							No Results Found
						</td>
					</tr>
					<%
					  }
					%>
				</table>
			</div>
		</impact:pagination>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE2">
			<tr class="subDetail">
				<td class="alignRight">
					<impact:ButtonTag name="btnDeleteHasConsidered" 
						align="right" 
						img="btnDelete"
						form="frmExchangeChildDetail"
						action="/person/ExchangeChildDetail/deleteHasConsidered"
						restrictRepost="true" preventDoubleClick="true"
						function ="return confirmDelete();"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%-- End Child Availability --%>
	<br>
	<%-- Begin Status Of Parental Rights --%>
	<impact:ExpandableSectionTag name="StsOfPrntlRights"
		label="Status Of Parental Rights" tabIndex="<%=tabIndex++%>" id="">
		<table border="0" cellspacing="0" cellpadding="3" width="100%">
			<tr>
				<th>
					Mother
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspMotherDOB"
						label="Date of Birth"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthMother())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspMotherDOD"
						label="Date of Death"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthMother())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspMotherRace" label="Race"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtMotherRace())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspMotherEthnicity"
						label="Ethnicity"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtMthEthnicity())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtTprMother"
						label="TPR Date"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprMother())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspTprCodeMother"
						label="TPR Code"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodeMother())%>" />
				</td>
			</tr>

			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtTermFiled"
						label="Date TPR Order Filed"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledMoth())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspIndMothMarr"
					label = "Mother married at time of child's birth"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CMOTHMAR, exchangeChildDetailRetSO.getIndMothMarried())%>" />
				</td>
			</tr>
			<tr>
				<th>
					Biological Father
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspBioFatherDOB"
						label="Date of Birth"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthBioFather())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspBioFatherDOD"
						label="Date of Death"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthBioFather())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspBioFatherRace"
						label="Race"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtBioFthRace())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspBioFatherEthnicity"
						label="Ethnicity"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtBioFthEthnicity())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtBioFatherTpr"
						label="TPR Date"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprBioFather())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspBioFatherTprCode"
						label="TPR Code"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodeBioFather())%>" />
				</td>
			</tr>
			<tr class="subDetail">
							<%
							  String indBioLegFather = "";
							      if (ArchitectureConstants.Y.equals(exchangeChildDetailRetSO.getIndBioFthIsLegFth())) {
							        indBioLegFather = ArchitectureConstants.YES;
							      }
							%>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtTermFiledBioFath"
						label="Date TPR Order Filed"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledBioFath())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspIndBioLeg"
					label = "Biological Father is Legal Father"
						value="<%=indBioLegFather%>" />
				</td>
			</tr>
			<tr>
				<th>
					Legal Father
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherDOB"
						label="Date of Birth"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthLegFather())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherDOD"
						label="Date of Death"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthLegFather())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherRace"
						label="Race"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtLegFthRace())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherEthnicity"
						label="Ethnicity"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtLegFthEthnicity())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtLegFatherTpr"
						label="TPR Date"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprLegFather())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherTprCode"
						label="TPR Code"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodeLegFather())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
				<impact:validateDisplayOnlyField name="dspDtTermFiledLegFath"
				label = "Date TPR Order Filed"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledLegFath())%>" />
				</td>
				<td colspan="6"></td>
			</tr>
			<tr>
				<th>
					Putative Father
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherDOB"
						label="Date of Birth"
						value="<%=multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthPutFather())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherDOD"
						label="Date of Death"
						value="<%=multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthPutFather())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherRace"
						label="Race"
						value="<%=multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtPutFthRace())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherEthnicity"
						label="Ethnicity"
						value="<%=multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtPutFthEthnicity())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspDtLegFatherTpr"
						label="TPR Date"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprPutFather())%>" />
				</td>
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspLegFatherTprCode"
						label="TPR Code"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodePutFather())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
				<impact:validateDisplayOnlyField name="dspDtTermFiledLegFath"
				label = "Date TPR Order Filed"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledPutFath())%>" />
				</td>
				<td colspan="6"></td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%-- End Status Of Parental Rights --%>
	<br>
	<%-- Begin Recruitment Activities --%>
	<impact:ExpandableSectionTag name="RecActivities"
		label="Recruitment Activities" tabIndex="<%=tabIndex++%>" id="">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE5">
			<% // MR-083 Added new question and cleaned up code %>
			<tr>
				<td colspan="3">
					Actively Recruiting?
					<impact:validateInput 
                       type="radio" 
                       cssClass="formInput" 
                       name="rbStateActRecruiting"
                       label="Yes" 
                       value="Y" 
					   tabIndex="<%=tabIndex++%>" 
					   checked="<%= String.valueOf(CodesTables.CYESNONA_Y.equals(cdStateActivelyRecruiting)) %>" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput 
					   cssClass="formInput" 
					   type="radio" 
					   tabIndex="<%=tabIndex++%>" 
					   name="rbStateActRecruiting"
					   label="No" 
					   value="N" 
					   checked="<%= String.valueOf(CodesTables.CYESNONA_N.equals(cdStateActivelyRecruiting)) %>" />
                    <impact:validateInput 
                       cssClass="formInput" 
                       type="radio" 
                       tabIndex="<%=tabIndex++%>" 
                       name="rbStateActRecruiting"
                       label="N/A" 
                       value="A" 
                       checked="<%= String.valueOf(CodesTables.CYESNONA_A.equals(cdStateActivelyRecruiting) || cdStateActivelyRecruiting == null) %>" />
				</td>
				<td colspan="5"></td>
			</tr>
			<%
              int iLoopCounter = 0;
              
			  for (int i = 0; i < activityCodesList.size(); ++i) {
			        CodeAttributes att = (CodeAttributes) activityCodesList.get(i);
                    
			        List<ExcChildAdoInfoCbxStruct> recActDatesToDisplay = null;
			        
			        if(savedRecActivitiesDatesState != null){
			         recActDatesToDisplay = savedRecActivitiesDatesState.get(att.getCode());
			        }

			        int sizeOfDateList = 0;

			        if (recActDatesToDisplay != null) {
			          sizeOfDateList = recActDatesToDisplay.size();
			        }
			%>
			<tr class="<%=FormattingHelper.getRowCss(iLoopCounter)%>">
				<td width="25%" colspan="2">
					<impact:validateDate label="<%=att.getDecode()%>" size="10"
						value="" tabIndex="<%=tabIndex++%>"
						name="<%="dtRecActState" + att.getCode()%>"
						tabIndex="<%=tabIndex++%>" cssClass="formInput"
						constraint="Date" />
				</td>
				<td>

					<impact:validateInput constraint="Date" type="text"
						name="<%="Date0_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(0).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date0_idInfoChar" + att.getCode()%>" 
                        value="<%= ((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(0).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date1_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(1).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date1_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(1).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date2_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(2).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date2_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(2).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date3_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(3).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date3_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(3).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date4_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(4).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date4_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(4).getIdInfoChar()) : "0"%>" />
				</td>

			</tr>
			<tr class="<%=FormattingHelper.getRowCss(iLoopCounter++)%>">
				<td colspan="3"></td>
				<td>

					<impact:validateInput constraint="Date" type="text"
						name="<%="Date5_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(5).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date5_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(5).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date6_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(6).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date6_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(6).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date7_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(7).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date7_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(7).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date8_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(8).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date8_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(8).getIdInfoChar()) : "0"%>" />
				</td>
				<td>
					<impact:validateInput constraint="Date" type="text"
						name="<%="Date9_dtRecActState" + att.getCode()%>"
						cssClass="formInput" size="8"
						value="<%=((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(9).getDtPerformed()) : ""%>"
						tabIndex="<%=tabIndex++%>" />
                    <impact:validateInput 
                        type="hidden" 
                        name="<%="Date9_idInfoChar" + att.getCode()%>"
                        value="<%= ((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(9).getIdInfoChar()) : "0"%>" />
				</td>

			</tr>
			<%
			  }
			%>
		</table>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE2">
			<tr class="subdetail">
				<td>
					<impact:validateTextArea label="Comments" name="txtRecActCmnts"
						rows="4" cols="77" tabIndex="<%=tabIndex++%>" maxLength="1000"
						disabled="false" constraint="Paragraph1000">
						<%=FormattingHelper.formatString(excChildStruct.getTxtRecCmnts())%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%-- End Recruitment Activities --%>
	<br>
	<%-- Begin Close Record --%>
	<impact:ExpandableSectionTag name="closeRecords" label="Close Records"
		tabIndex="<%=tabIndex++%>">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE">
			<tr>
				<th colspan="4">
					Closed No Placement
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate label="Date" name="txtDtClosedNP" type="text"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtClose())%>"
						size="10" conditionallyRequired="false" disabled="false"
						tabIndex="<%=tabIndex++%>" constraint="Date" />
				</td>
				<td>
					<impact:validateSelect name="szCdRsnClosed" label="Reason Closed"
						tabIndex="<%=tabIndex++%>" codesTable="CADEXCLD"
						value="<%=FormattingHelper.formatString(excChildStruct.getCdRsnClosed())%>" />
				</td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateTextArea name="txtExplNpCmnts" colspan="4"
						label="Explanation" rows="4" cols="110" tabIndex="<%=tabIndex++%>"
						disabled="false" maxLength="500" constraint="Comments">
						<%=FormattingHelper.formatString(excChildStruct.getTxtExplNoPlcmt())%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE14">
			<tr>
				<th colspan="4">
					Closed With Placement
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="txtRsrcChildPlcd"
						label="Family With Whom Child is Placed"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getNmPlcmtRsrc())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="txtNmPrvtAgency"
						label="Private Agency Name"
						value="<%=FormattingHelper.formatString(exchangeChildDetailRetSO.getNmPrvtAgency())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="txtDatePlacedCWP"
						label="Date Placed"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtPlaced())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="dtPermissionToFileCWP"
						label="Permission To File"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtPermToFile())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="dtDocSendCWP"
						label="Documents Sent Date"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDocSent())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="txtCountyCWP" label="County"
						value="<%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeChildDetailRetSO.getLegStatCnty())%>" />
				</td>
				<td>
					<impact:validateInput type="text" name="txtAFileNumCWP"
						label="A-file #" tabIndex="<%=tabIndex++%>" maxLength="16" size="16"
						value="<%=FormattingHelper.formatString(excChildStruct.getNbrAfile())%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="txtDtFinalCWP"
						label="Date Final"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtFinal())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="txtDtFinalEnteredCWP"
						label="Date Final Entered"
						value="<%=FormattingHelper.formatDate(excChildStruct.getDtFnEntered())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDisplayOnlyField name="dtDisruptionCWP"
						label="Disruption"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDisruption())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="dtDissolutionCWP" label="Dissolution"
						type="text" constraint="Date" size="10" tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatDate(exchangeChildDetailRetSO.getExchangeChildStruct()
                                                                          .getDtDissolutionCWP())%>" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateTextArea name="txtChPlcWithCmnts" colspan="4"
						label="Children Placed with" rows="4" cols="110"
						tabIndex="<%=tabIndex++%>" disabled="false" maxLength="500"
						constraint="Comments">
						<%=FormattingHelper.formatString(excChildStruct.getTxtChPlcdWith())%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%-- End Close Record --%>

	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
		width="100%" id="TABLE2">
		<tr class="subDetail">
			<%
			  if (!PageModeConstants.VIEW.equals(pageMode)) {
			%>
			<td class="alignRight">
				<impact:ButtonTag name="btnSave" align="right" img="btnSave"
					form="frmExchangeChildDetail"
					action="/person/ExchangeChildDetail/saveExchangeChildDetail"
					restrictRepost="true" preventDoubleClick="true"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
			  }
			%>
		</tr>
	</table>
	<br>
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>

