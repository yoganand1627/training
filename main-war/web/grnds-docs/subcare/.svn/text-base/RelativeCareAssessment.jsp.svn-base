<%/**--------------------------------------------------------------------------------
       *
       * JSP Name:     Relative Care Assessment
       
       Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       11/14/2008  arege           STGAP00010758 - Modified code so that the SaveAndSubmit button is not displayed for the 
                                                  Supervisor in approval mode.  
       12/12/2008  mxpatel         STGAP00005841:  Added a function initializeDisplay() to  make sure that state dropdown is
                                                   always displayed when ICPC is chosen.
       05/24/2011  hnguyen         SMS#109405: MR-087 Added new Form Launch section and added new Relative Care Subsidy 
                                   Application and Agreement form in launch dropdown selection.
       */                                                            
 %>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page
	import="java.util.*"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>	
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.subcare.RelativeCareAssessmentConversation"%>	
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentPersonInfo"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>	
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>

	
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<script type="text/javascript" language="JavaScript1.2">
function openPersonList()
{
  disableValidation('frmRelativeCareAssessment');
  return true;
}
function hideAll() { 
var field =  eval("document.getElementById('RESOURCE')");
field.style.display = 'none'; 
field = eval("document.getElementById('BTNRESOURCE')");
field.style.display = 'none';
field = eval("document.getElementById('COUNTY')");
field.style.display = 'none';  
field = eval("document.getElementById('STATE')");
field.style.display = 'none'; 
field = eval("document.getElementById('STATELABEL')");
field.style.display = 'none'; 
field = eval("document.getElementById('COUNTYLABEL')");
field.style.display = 'none';  
} 
function showSpan(elementId) { 
if (elementId=='CCFA'){
var field = document.getElementById("RESOURCE");
field.style.display = '';
field = document.getElementById("BTNRESOURCE");
field.style.display = '';
field = document.getElementById("COUNTY");
field.style.display = '';
field = document.getElementById("COUNTYLABEL");
field.style.display = '';
} else if (elementId=='DFCS'){
field = document.getElementById("COUNTY");
field.style.display = '';
field = document.getElementById("COUNTYLABEL");
field.style.display = '';
} else if (elementId=='ICPC'){
field = document.getElementById("STATE");
field.style.display = '';
field = document.getElementById("STATELABEL");
field.style.display = '';
}
} 

function hideAndShow(elementId){
hideAll();
showSpan(elementId);
}

function initializeDisplay(){
if(document.frmRelativeCareAssessment.rbPersonPerformingAssessment_Id5.checked) {
hideAndShow('ICPC');
}
}

function personListHyperlink (index)
{
  frmRelativeCareAssessment.hdnPersonLoopCount.value = index;
}


</script>
	<body onload="initializeDisplay()">
	
	

		<%
		int tabIndex = 1;
		//Set the page mode to the mode that is passed in
      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }
      
		
		BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY ) ;
		String previousPageMode = (String)state.getAttribute(RelativeCareAssessmentConversation.PREV_PAGE_MODE,request);
		if (previousPageMode!=null){
		  //pageMode = previousPageMode;
		}

  		boolean bDocumentExists = false;
				
		
		RelativeCareAssessmentBean rcaSO = (RelativeCareAssessmentBean) state.getAttribute(RelativeCareAssessmentConversation.RETRIEVESO,request);
		String rbPersonPerformingAssessment = rcaSO.getCdPersonPerformingAssessment();
		boolean hideFields = false;
		int eventId = rcaSO.getIdEvent();
		boolean isSelectedDFCS = "D".equals(rbPersonPerformingAssessment);
		boolean isSelectedCCFA = "C".equals(rbPersonPerformingAssessment);
		boolean isSelectedICPC = "I".equals(rbPersonPerformingAssessment);
		if (eventId!=0){
		    hideFields = true;
		} else {
		   if (!isSelectedDFCS && !isSelectedICPC){
		      isSelectedCCFA = true;
		   }
		}
		String rbAssessmentType = rcaSO.getCdAssessmentType();
		if(rbAssessmentType == null || "".equals(rbAssessmentType)){
		   rbAssessmentType = "I";
		}
		
		String rbCaregiverType = rcaSO.getCdCaregiverType();
		if(rbCaregiverType == null ||"".equals(rbCaregiverType)){
		   rbCaregiverType = "R";
		}
		
				  if (ArchitectureConstants.Y.equals(rcaSO.getIndBLOBExistsInDatabase()))
  {
    bDocumentExists = true;
  }
		
		String showCounty = "none";
		String showResource = "none";
		String showState = "none";
		if (isSelectedDFCS || isSelectedCCFA ){
		  showCounty = "";
		}
		if (isSelectedCCFA){
		  showResource="";
		}
		if (isSelectedICPC){
		  showState = "";
		}
		
		String cdCounty = rcaSO.getCdCounty();
		String cdState = rcaSO.getCdState();
		String dtInitiated = FormattingHelper.formatDate( rcaSO.getDtInitiated() );
		String dtDueDate = FormattingHelper.formatDate( rcaSO.getDueDate() );
		String dtScheduledDate = FormattingHelper.formatDate( rcaSO.getScheduleAssessmentDate() );
		String dtActualHome = FormattingHelper.formatDate( rcaSO.getActualHomeVisitDate() );
		String dtAssessmentComplete = FormattingHelper.formatDate( rcaSO.getDtAssessmentComplete() );
		String dtAssessmentReceived= FormattingHelper.formatDate( rcaSO.getDtAssessmentReceived() );
		boolean approvalStatus = true;
		ROWCCMN45DO eventDetails = rcaSO.getRowccmn45do();
        if ((eventDetails == null)
          || pageMode.equals(PageModeConstants.NEW)
          || (!RelativeCareAssessmentConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus()) && !RelativeCareAssessmentConversation.EVENT_STATUS_APRV
                                                                                                                                              .equals(eventDetails
                                                                                                                                                                  .getSzCdEventStatus()))) {
        approvalStatus = false;
        }
        
        boolean saveAndSubmit = true;
        if(GlobalData.isApprovalMode(request)){
        saveAndSubmit = false;
        }

boolean protectDoc = false;
boolean preFillAlways = true;

// Capta 4.3 Event details will be null if loading the page for the fist time. 
if(eventDetails != null){
String cdEventStatus = eventDetails.getSzCdEventStatus();

//After the page is saved for the first time, 
//the user is able to launch the Safety Resource Assessment form using the Document button 
if(pageMode.equals(PageModeConstants.VIEW) || (cdEventStatus != null && cdEventStatus != "")){ 
 
 //STGAP00014333 Document should be display only and should not prefill if the form is approved or user doesnt have stage access
  if(pageMode.equals(PageModeConstants.VIEW) || "APRV".equals(cdEventStatus))
  {
  protectDoc = true;
  preFillAlways = false;
  
  }    
        
   }   
      }
        
        
		%>
		<impact:validateErrors formName="frmRelativeCareAssessment" />
		<impact:validateForm name="frmRelativeCareAssessment" method="post"
			action="/subcare/RelativeCareAssessment/displayRelativeCareAssessment"
			validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.RelativeCareAssessmentCustomValidation"
			pageMode="<%=pageMode%>"
			schema="/WEB-INF/Constraints.xsd">
        <impact:validateInput type="hidden" name="destinationUrl" value="/subcare/RelativeCareAssessment/setResource"/>
        <impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
        <impact:validateInput type="hidden" name="hdnPersonLoopCount" value=""/>
        <impact:validateInput type="hidden" name="ulIdRcaEvent" value="<%=""+rcaSO.getIdEvent()%>"/>
        <impact:validateInput type="hidden" name="dtLastUpdate" value="<%=DateHelper.toISOString(rcaSO.getDtLastUpdate())%>"/>
        <%if (rcaSO.getRowccmn45do()!=null){ %>
        <impact:validateInput type="hidden" name="dtLastUpdateForEvent" value="<%=DateHelper.toISOString(rcaSO.getRowccmn45do().getTsLastUpdate())%>"/>
        <%} %>
			<table border="0" cellspacing="0" cellpadding="3" width="100%"
				class="tableBorder">
				    <tr>
                   <%if (approvalStatus) {

                   %>
                   <td class="alignLeft">
                   <impact:ButtonTag name="btnApprovalStatus" tabIndex="<%= tabIndex++ %>" img="btnApprovalStatus" editableMode="<%=EditableMode.ALL%>" form="frmRelativeCareAssessment" action="/workload/ApprovalStatus/displayStatus" />
                   </td>
                   <%} else {
                    %>
                   <td class="alignLeft">
                   &nbsp;
                   </td>
                   <%}
                     %>
                </tr>
				<tr>
					<th colspan="4">
						Assessment Type
					</th>
				</tr>
				<tr>
					<td width="35%">
						<font color="#FF0000">*</font>
						<label>
							Person Performing Assessment:
						</label>
					</td>
					<td>
						<impact:validateInput type="radio" id="rbPersonDFCS"
							onClick="hideAndShow('DFCS')" tabIndex="<%=tabIndex++%>" name="rbPersonPerformingAssessment"
							value="D" checked="<%=""+isSelectedDFCS%>" disabled="<%=""+hideFields%>"/>
						DFCS Agency Staff
					</td>
					<td>
						<font color="#FF0000">*</font>
						<label>
							Assessment Type:
						</label>
					</td>
					<td>
						<impact:validateInput type="radio" id=""
							tabIndex="<%=tabIndex++%>" name="rbAssessmentType"
							value="I" checked="<%=""+"I".equals(rbAssessmentType)%>" disabled="<%=""+hideFields%>" />
						Initial
					</td>
				</tr>

				<tr>
					<td width="35%">
						&nbsp;
					</td>
					<td width="24%">
						<impact:validateInput type="radio" id="rbPersonCCFA"
							onClick="hideAll();showSpan('CCFA')" tabIndex="<%=tabIndex++%>" checked="true" name="rbPersonPerformingAssessment"
							checked="<%=""+isSelectedCCFA%>" value="C" disabled="<%=""+hideFields%>"/>
						CCFA Provider
					</td>
					<td width="18%">
						&nbsp;
					</td>
					<td width="19%">
						<impact:validateInput type="radio" id=""
							tabIndex="<%=tabIndex++%>" name="rbAssessmentType"
							value="R" checked="<%=""+"R".equals(rbAssessmentType)%>" disabled="<%=""+hideFields%>"/>
						Renewal
					</td>
				</tr>
				<tr>
					<td width="35%">
						&nbsp;
					</td>
					<td width="24%">
						<impact:validateInput type="radio" id="rbPersonICPC"
							onClick="hideAndShow('ICPC')" tabIndex="<%=tabIndex++%>" name="rbPersonPerformingAssessment"
							checked="<%=""+isSelectedICPC%>" value="I" disabled="<%=""+hideFields%>"/>
						ICPC
					</td>
				</tr>
				<tr>
					<td width="35%">
						<font color="#FF0000">*</font>Caregiver Type
						<label>
							:
						</label>
					</td>
					<td width="24%">
						<impact:validateInput type="radio" id=""
							tabIndex="<%=tabIndex++%>" name="rbCaregiverType"
							checked="<%=""+"R".equals(rbCaregiverType)%>" value="R" />
						Relative
					</td>
				</tr>
				<tr>
					<td width="35%">
						&nbsp;
					</td>
					<td width="24%">
						<impact:validateInput type="radio" id=""
							tabIndex="<%=tabIndex++%>" name="rbCaregiverType"
							checked="<%=""+"N".equals(rbCaregiverType)%>" value="N" />
						Non-Relative
					</td>
				</tr>
				<tr>
					<th colspan="4">
						Assessment Information
					</th>
				</tr>
				
				<tr>
					<td>
						<impact:validateDate name="txtDtDtInitiatedReferred"
							label="Date Initiated/Referred" value="<%=dtInitiated%>" required="true"
							size="10"
							constraint="Date"
							tabIndex="<%=tabIndex++%>" disabled="<%=""+hideFields%>"/>
					</td>

					<td>
						<impact:validateDate name="txtDtDtDue" label="Due Date" value=""
							size="10"
							constraint="Date"
							required="true" tabIndex="<%=tabIndex++%>" value="<%=dtDueDate %>" disabled="<%=""+hideFields%>"/>
					</td>

				</tr>
				<tr>
					<td>
					<span id="COUNTYLABEL" style="display:<%=showCounty%>">
						<impact:validateSelect name="selSzCdCounty" label="County"
							value="<%=cdCounty%>"  id="COUNTY" style="<%="display:"+showCounty %>" conditionallyRequired="true" codesTable="CCOUNT"
							tabIndex="<%=tabIndex++%>" />
					</span>		
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
					<span id="RESOURCE" style="display:<%=showResource%>">
						<impact:validateDisplayOnlyField name="dspNmResource"
							label="Resource" value="<%=FormattingHelper.formatString(rcaSO.getNmResource()) %>" />
					</span>		
					</td>
					<td colspan="2">
					<span id="BTNRESOURCE" style="display:<%=showResource%>">
						<impact:ButtonTag name="btnResource" img="btnSelectResource"
							form="frmRelativeCareAssessment"
							function=""
							action="/subcare/RelativeCareAssessment/getResource"
							tabIndex="<%=tabIndex++%>"
							editableMode="<%=EditableMode.ALL%>" />
					</span>		
					</td>
				</tr>
				
				<tr>
					<td>
					<span id="STATELABEL" style="display:<%=showState%>">
						<impact:validateSelect name="selSzCdState" label="State"
							value="<%=cdState%>" id="STATE" style="<%="display:"+showState%>" conditionallyRequired="true" codesTable="CSTATE"
							tabIndex="<%=tabIndex++%>" />
					</span>		
					</td>


				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>

				<tr>
					<td>
						<impact:validateDate name="txtDtDtScheduledAssessment"
							label=" Scheduled Assessment Date" value="<%=dtScheduledDate%>"
							size="10"
							constraint="Date"
							conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />
					</td>
					<td>

						<impact:validateDate name="txtDtDtActualHomeVisit"
							label=" Actual Home Visit Date" value="<%=dtActualHome%>"
							size="10"
							constraint="Date"
							conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />

					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="scroll3_sub0"
							style="OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px"
							class="tableborderList">
							<table border="0" cellpadding="3" cellspacing="0" width="100%"
								id="table4">
								<tr>
									<th>
										<span class="formRequiredText">*</span>Person Name
									</th>
									<th colspan="3">
										<span class="formRequiredText">*</span>Person Type:
									</th>
								</tr>
								<% List personInfoList = (List)rcaSO.getPersonInfoList() ;
								   int loopCounter = 0;
								   if (personInfoList!=null && personInfoList.size()!=0){
								   for (;loopCounter<personInfoList.size();loopCounter++){
								   RelativeCareAssessmentPersonInfo rcaPersonInfo = (RelativeCareAssessmentPersonInfo)personInfoList.get(loopCounter);
								   if(!rcaPersonInfo.getIsSelected(0) && !rcaPersonInfo.getIsSelected(1) && !rcaPersonInfo.getIsSelected(2)){
								       rcaPersonInfo.setIsSelected(0); 
								       
								       //setIsSelected(boolean[] isSelected)
								   }
								   
								%>
								<impact:validateInput type="hidden" name="<%="dtLastUpdate"+loopCounter%>" value="<%=DateHelper.toISOString(rcaPersonInfo.getDtLastUpdate())%>" />
                                <impact:validateInput type="hidden" name="<%="ulIdRcaPerson"+loopCounter%>" value="<%=""+rcaPersonInfo.getUlIdRcaPerson()%>"/>
                                <impact:validateInput type="hidden" name="<%="ulIdPerson"+loopCounter%>" value="<%=""+rcaPersonInfo.getUlIdPerson()%>"/>
                                <impact:validateInput type="hidden" name="<%="nmPerson"+loopCounter%>" value="<%=rcaPersonInfo.getNmPersonName()%>"/>
								<tr class="<%=FormattingHelper.getRowCss( loopCounter + 1 )%>" valign="top">
									<td>
										<a href="javascript:personListHyperlink( '<%=loopCounter%>' );   disableValidation( 'frmRelativeCareAssessment' ); submitValidateForm( 'frmRelativeCareAssessment' , '/subcare/RelativeCareAssessment/callPersonDetail' )" tabIndex="<%= tabIndex++ %>" > 
										<%=FormattingHelper.formatString(rcaPersonInfo.getNmPersonName())%></a>
									</td>
									<td>
										<impact:validateInput type="radio" id=""
							            tabIndex="<%=tabIndex++%>" name="<%=RelativeCareAssessmentConversation.PERSON_INFO_RB+loopCounter%>"
							            checked="<%=""+rcaPersonInfo.getIsSelected(0) %>" value="0" />
										Primary Caregiver
									</td>
									<td width>
										<impact:validateInput type="radio" id=""
							            tabIndex="<%=tabIndex++%>" name="<%=RelativeCareAssessmentConversation.PERSON_INFO_RB+loopCounter%>"
							            checked="<%=""+rcaPersonInfo.getIsSelected(1) %>" value="1" />
										Child to be Placed
									</td>
									<td width>
										<impact:validateInput type="radio" id=""
							            tabIndex="<%=tabIndex++%>" name="<%=RelativeCareAssessmentConversation.PERSON_INFO_RB+loopCounter%>"
							            checked="<%=""+rcaPersonInfo.getIsSelected(2) %>" value="2" />
										Home Member
									</td>
								</tr>
								<% } 
								%>
								<impact:validateInput type="hidden" name="loopCounter" value="<%=""+loopCounter%>"/>
								<%
								} %>
									</table>		
						</div>	
                 			</td>
			</tr>
			<tr>
				<td colspan="4">
					<impact:ButtonTag name="selectPerson" align="right"
						tabIndex='<%=tabIndex++%>'
						action="/subcare/RelativeCareAssessment/getPerson"
						form="frmRelativeCareAssessment" img="btnSelectPerson"
						function="disableValidation('frmRelativeCareAssessment');"
						editableMode='<%=EditableMode.ALL%>' />
				</td>
			</tr>
			</table>
			<br>
			<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
				<tr>
					<th colspan="4">
						Relative Care Assessment Outcome
					</th>
				</tr>

				<tr>
					<td width="25%">
						<impact:validateDate name="txtDtDtAssessmentComplete"
							label="Date Assessment Complete" value="<%=dtAssessmentComplete%>"
							size="10"
							width="30%"
							constraint="Date"
							conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />
					</td>

					<td width="20%">

						<impact:validateDate name="txtDtDtAssessmentReceived"
							label="Date Assessment Received" value="<%=dtAssessmentReceived%>"
							size="10"
							width="25%"
							constraint="Date"
							conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />
					</td>

				</tr>
				<tr>
					<td>
						<impact:validateSelect name="selSzCdAsmtResults"
							label="Assessment Results" value="<%=FormattingHelper.formatString(rcaSO.getCdAssessmentResults())%>" conditionallyRequired="true"
							codesTable="CASMTRES" tabIndex="<%=tabIndex++%>" />
					</td>

					<td>
						<impact:validateDate name="txtDtDtDecision" label="Decision Date"
							value="<%=FormattingHelper.formatDate(rcaSO.getDtDecisionDate()) %>" conditionallyRequired="true"
							size="10"
							constraint="Date"
							tabIndex="<%=tabIndex++%>" />

					</td>

				</tr>
				<tr>
					<td colspan="2">

						<impact:validateInput type="checkbox" name="cbxBIndSupportOptions"
							checked="<%=""+"S".equals(rcaSO.getIndSupportOptions()) %>" value="S" tabIndex="<%=tabIndex++%>" />
						Support Options and Requirements Discussed
					</td>

					<td>
						<impact:validateDate name="txtDtDtDiscussion"
							label="Discussion Date" value="<%=FormattingHelper.formatDate(rcaSO.getDtDiscussionDate()) %>" conditionallyRequired="true"
							size="10"
							constraint="Date"
							tabIndex="<%=tabIndex++%>" />

					</td>

				</tr>
				<tr>
					<td  colspan="2">
						<impact:validateInput type="checkbox"
							name="cbxBIndWillingToAcceptChild" checked="<%=""+"W".equals(rcaSO.getCdWillingToAcceptChild()) %>"
							tabIndex="<%=tabIndex++%>" value="W"/>
						Willing to Accept Child
					</td>
				</tr>

				<tr>
					<td>
						<impact:validateSelect width="40" name="selSzCdInitSup"
							label="Initial Choice of Support" value="<%=FormattingHelper.formatString(rcaSO.getCdInitialChoiceOfSupport())%>"
							conditionallyRequired="true" codesTable="CINITSUP" 
							tabIndex="<%=tabIndex++%>" />
					</td>
					
					<td>
						<impact:validateDate name="txtDtDtReferredToRD"
							label="Referred to RD" value="<%=FormattingHelper.formatDate(rcaSO.getDtReferredToRD()) %>" conditionallyRequired="true"
							size="10"
							constraint="Date"
							tabIndex="<%=tabIndex++%>" />

					</td>
					
					
					
				</tr>
				<tr>
					<td>
						<impact:validateDate name="txtDtPlacementAgreementSigned"
							label="Placement Agreement Signed" value="<%=FormattingHelper.formatDate(rcaSO.getDtPlacementAgreementSigned()) %>"
							size="10"
							constraint="Date"
							conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />
					</td>
					
				</tr>
				
			</table>			
			<table width="100%">
				<tr>
					<td>
						<impact:validateDisplayOnlyField name="" label="For non-relatives,record degree of relationship and establish the existing relationship and bond"
								conditionallyRequired="true"/>
					</td>
				</tr>	
				<tr>
					<td>
						<impact:validateTextArea
							label=""
							constraint="Comments"
							name="txtSzNonRelatives" rows="4" cols="100"
							maxLength="300" tabIndex="<%=tabIndex++%>">
						<%= FormattingHelper.formatString(rcaSO.getTxtNonRelatives()) %>	
						</impact:validateTextArea>
					</td>
				</tr>
				<tr>
					<td>
						<impact:validateDisplayOnlyField name="" label="Comments" conditionallyRequired="true"/>
					</td>
				</tr>		
				<tr>
					<td>
						<impact:validateTextArea 
							label=""
							constraint="Comments"
							name="txtSzComments" rows="4" cols="100" maxLength="300"
							tabIndex="<%=tabIndex++%>">
						<%= FormattingHelper.formatString(rcaSO.getTxtComments()) %>	
						</impact:validateTextArea>
					</td>
				</tr>
			</table>
		<br>
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
				<tr>
					<td width="85%" class="alignLeft">
						<impact:ButtonTag name="btnDelete" img="btnDelete" align="left"
							form="frmRelativeCareAssessment"
							action="/subcare/RelativeCareAssessment/deleteRelativeCareAssessment"
							restrictRepost="true" preventDoubleClick="true"
							tabIndex="<%=tabIndex++%>" disabled="<%=""+ (!hideFields) %>"/>
					</td>
					<% if(saveAndSubmit){
					 %>
					<td class="alignRight">
						<impact:ButtonTag name="btnSaveSubmit" img="btnSaveAndSubmit"
							align="right" form="frmRelativeCareAssessment"
							action="/subcare/RelativeCareAssessment/saveAndSubmitRelativeCareAssessment"
							restrictRepost="true" preventDoubleClick="true"
							tabIndex="<%=tabIndex++%>" />
					</td>
					<%}
					 %>
					<td class="alignRight">
						<impact:ButtonTag name="btnSave" img="btnSave" align="right"
							form="frmRelativeCareAssessment"
							action="/subcare/RelativeCareAssessment/saveRelativeCareAssessment"
							restrictRepost="true" preventDoubleClick="true"
							tabIndex="<%=tabIndex++%>" />
					</td>
				</tr>
			</table>
				
		</impact:validateForm>
		 
		<br>
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		    <tr>
		        <th colspan="4">
		            Form and Report Launch
		        </th>
		    </tr>
		    <tr>
		        <td>
		            <impact:documentList pageMode="<%=pageMode%>" tabIndex="<%=tabIndex++%>">
		                <impact:document
		                 displayName="Relative Care Subsidy Application and Agreement"
		                 protectDocument="true"
		                 checkForNewMode="true"
		                 docType="rcsappagmt"
		                 docExists="false"
		                 preFillAlways="true">
		                    <impact:documentParameter
		                     name="pCase"
		                     value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
		                    <impact:documentParameter
		                     name="pStage"
		                     value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
		                </impact:document>
		                  <impact:document displayName="Relative Care Assessment" 
	                           name = "frmDocumentTag"
	                           protectDocument="<%= protectDoc %>"
	                           postInSameWindow="false"
	                           preFillAlways="<%= preFillAlways %>" 
	                           docType="RELATIVECARE" 
	                           docExists="<%= bDocumentExists %>">
	            <impact:documentParameter name="sCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request) ) %>" />
	            <impact:documentParameter name="pStage" value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
	            <impact:documentParameter name="sEvent" value="<%=String.valueOf(GlobalData.getUlIdEvent(request))%>" />
	        </impact:document>
		            </impact:documentList>
		        </td>
		    </tr>
		</table>
	</body>

</html>