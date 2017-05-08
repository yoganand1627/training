
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FosterHomeConversionSO"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.fad.FosterHomeConversionConversation"%>
<%@page import="java.util.List"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionChildBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%--

 %>JSP Name:     FosterHomeConversion.jsp
Date Created: 03/27/08

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
07/01/08  mchillman         JSP creation
01/30/09  wjcochran			STGAP00012200:Modified javascript to better handle deletions
							of children listed in the 'to be adopted' section
04/15/09  cwells			Simplified IsDirty to work correctly. Has formChanged 
                            is already being called by IsDirty. 				

--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>


<%
  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );  
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  String EMPTY_STRING = "";
  String formName = "frmFosterHomeConversion";
  String eventStatus = EMPTY_STRING;
  String szCdConvAppStatus = EMPTY_STRING;
  String dtAppliedDate = EMPTY_STRING;
  String dtApprovedDate = EMPTY_STRING;
  String dtClosureDate = EMPTY_STRING;
  String dtInquiryDate = EMPTY_STRING;
  String szCdClosureReason = EMPTY_STRING;
  String txNmResource = EMPTY_STRING;
  boolean hasNarrative = false;
  boolean eventExists = false;
  List<FosterHomeConversionChildBean> childrenToBeAdopted = null;
  
  int idEvent = 0;
  int idAdoAgency = 0;
  String editableMode = PageMode.getPageMode(request);
  Boolean hasFormChanged = (Boolean) state.getAttribute("formChanged", request);
  FosterHomeConversionSO fosterHomeConversionSO = (FosterHomeConversionSO) state.getAttribute("FosterHomeConversionSO", request);
  if (fosterHomeConversionSO != null) {
  
	  if (fosterHomeConversionSO.getCdConvAppStatus() != null) {
	  	szCdConvAppStatus = fosterHomeConversionSO.getCdConvAppStatus();
	  }
	  if (fosterHomeConversionSO.getDtApplied() != null) {
	  	dtAppliedDate = FormattingHelper.formatDate(fosterHomeConversionSO.getDtApplied());
	  }
	  if (fosterHomeConversionSO.getDtApproved() != null) {
	  	dtApprovedDate = FormattingHelper.formatDate(fosterHomeConversionSO.getDtApproved());
	  }
	  if (fosterHomeConversionSO.getDtClosed() != null) {
	  	dtClosureDate = FormattingHelper.formatDate(fosterHomeConversionSO.getDtClosed());
	  }
	  if (fosterHomeConversionSO.getDtInquired() != null) {
	  	dtInquiryDate = FormattingHelper.formatDate(fosterHomeConversionSO.getDtInquired());
	  }
	  if (fosterHomeConversionSO.getCdClosureReason() != null) {
	  	szCdClosureReason = FormattingHelper.formatString(fosterHomeConversionSO.getCdClosureReason());
	  }
	  if (fosterHomeConversionSO.getNmResource() != null) {
	  	txNmResource = FormattingHelper.formatString(fosterHomeConversionSO.getNmResource());
	  }
	  if (fosterHomeConversionSO.getCdEventStatus() != null) {
	  	eventStatus = FormattingHelper.formatString(fosterHomeConversionSO.getCdEventStatus());
	  }
	  if (fosterHomeConversionSO.getChildrenToBeAdopted() != null) {
	  	childrenToBeAdopted = fosterHomeConversionSO.getChildrenToBeAdopted();
	  } else {
	  	childrenToBeAdopted = (List<FosterHomeConversionChildBean>)state.getAttribute("ChildrenToBeAdopted", request);
	  }
	  idEvent = fosterHomeConversionSO.getIdEvent();
	  idAdoAgency = fosterHomeConversionSO.getIdAdoAgency();
	  if (idEvent > 0) {
	  	eventExists = true;
	  }
	  hasNarrative = fosterHomeConversionSO.hasNarrative();
  }

  if (EMPTY_STRING.equals(dtInquiryDate) || dtInquiryDate == null) {
  	dtInquiryDate = FormattingHelper.formatDate(DateHelper.getTodayCastorDate());
  }
  
  if (childrenToBeAdopted == null) {
  	childrenToBeAdopted = new ArrayList<FosterHomeConversionChildBean>();
  }
  
  if (eventStatus.equals(EMPTY_STRING)) {
  	eventStatus = CodesTables.CEVTSTAT_NEW;
  }
    
  boolean approvalStatus = true;
  boolean pageIsApproved = false;

  if (!CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
    approvalStatus = false;
  }
  
  if (FosterHomeConversionConversation.EVENT_STATUS_APRV.equals(eventStatus)) {
  	pageIsApproved = true;
  }

%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script language="JavaScript">

<!--
  window.onbeforeunload = function ()
  {
    IsDirty();
  };
var eventArray = new Array(<%= childrenToBeAdopted.size() %>);
<%
  for (int i = 0; i < childrenToBeAdopted.size(); i++)
  {
%>
eventArray[<%= i %>] = new Object();
eventArray[<%= i %>].childAge = "<%= childrenToBeAdopted.get(i).getChildAge() %>";
eventArray[<%= i %>].childGender = "<%= childrenToBeAdopted.get(i).getChildGender() %>";
eventArray[<%= i %>].childName = "<%= childrenToBeAdopted.get(i).getChildName() %>";
eventArray[<%= i %>].childId = "<%= childrenToBeAdopted.get(i).getIdChild() %>";
eventArray[<%= i %>].linkId = "<%= childrenToBeAdopted.get(i).getIdFosterHomeConvPerLink() %>";
<% } %>

function deleteChildRow() {
  var doDelete = false;
  var x = document.frmFosterHomeConversion;
  var cnfrm = window.confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>")
  if(cnfrm)
  {
  	doDelete = true;
  } 
  else
  {
  	x.hdnIndex.value = -1;
  }

  return doDelete;
}

function personDeleteFromConversion (index)
{
  document.frmFosterHomeConversion.hdnIndex.value = index;
  document.frmFosterHomeConversion.actionChildId.value = eventArray[index].childId;
  document.frmFosterHomeConversion.actionLinkId.value = eventArray[index].linkId;

}

function personListHyperlink (index)
{
  document.frmFosterHomeConversion.fireEvent("onSubmit");
  document.frmFosterHomeConversion.hdnIndex.value = index;
  document.frmFosterHomeConversion.actionChildId.value = eventArray[index].childId;

  disableValidation("frmFosterHomeConversion");
  submitValidateForm("frmFosterHomeConversion", "/fad/HomeConversion/displayPersonDetail");
}

function closeFHConvNarrative()
{

  var narrativeWindow =
    window.open('',
                '<%= GlobalData.getUlIdStage(request) %>',
                'toolbar=no,menubar=no,width=5,height=5');
  if (narrativeWindow.isDirty)
  {
    alert('Please save the Foster Home Conversion Narrative before proceeding.');
    return false;
  }
  else
  {
    narrativeWindow.close();

    return true;
  }

}

window.onload = function () {
	personDeleteFromConversion(-1);
}

//-->

</script>

<impact:validateErrors />
<impact:validateForm name="frmFosterHomeConversion" 
	action="/fad/HomeConversion/displayHomeConversion"
	pageMode="<%=pageMode%>"
	schema="/WEB-INF/Constraints.xsd">

	<%
	  /* The hdnIndex field value is used to determine which hyperlink row was clicked once we get to the conversation.*/
	%>
	<impact:validateInput type="hidden" name="hdnIndex" value="" />
	<impact:validateInput type="hidden" name="destinationUrl" value="/fad/HomeConversion/setAdoAgency" />
	<impact:validateInput type="hidden" name="actionChildAge" value=''/>
	<impact:validateInput type="hidden" name="actionChildGender" value=''/>
	<impact:validateInput type="hidden" name="actionChildName" value=''/>
	<impact:validateInput type="hidden" name="actionChildId" value=''/>
	<impact:validateInput type="hidden" name="actionLinkId" value=''/>
	<impact:validateInput type="hidden" name="hdnHasNarrative" value = '<%= Boolean.toString(hasNarrative) %>'/>
	<impact:validateInput type="hidden" name="idAdoAgency" value='<%= FormattingHelper.formatInt(idAdoAgency) %>'/>
  	<impact:ifThen test="<%=
    	                    ((Boolean.valueOf(approvalStatus) == true))
            	         %>">
		<table border="0" cellspacing="0" cellpadding="3" width="100%">
			<tr>
				<td>
					<impact:ButtonTag name="btnApprovalStatus"
						tabIndex="<%=tabIndex++%>" img="btnApprovalStatus"
						form="frmFosterHomeConversion"
						editableMode="<%= EditableMode.ALL %>"
						action="/workload/ApprovalStatus/displayStatus" />
				</td>
			</tr>
		</table>
  	</impact:ifThen>
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
	    <tr>
	      <th>
	        Children to be Adopted
	      </th>
	    </tr>
	    <tr>
	      <td>
	      <%if (childrenToBeAdopted != null) { %>
			<table border="0" cellpadding="3" cellspacing="0" width="100%">
				<tr>
					<th>
						&nbsp;
					</th>
					<th>
						Name
					</th>
					<th>
						Gender
					</th>
					<th>
						Age
					</th>
				</tr>
				<% 	int loopCount = 0;
					for (FosterHomeConversionChildBean child : childrenToBeAdopted) {
			            String onClick = "javascript:personDeleteFromConversion(" + loopCount + ");";
					
						if (loopCount % 2 == 0) {
				%>
				<tr class="odd">
				<% } else {
				%>
				<tr class="even">
				<% } %>
					<td>
 			            <impact:validateInput disabled="<%= Boolean.toString(pageIsApproved) %>" 
 			            		  type="radio"
                                  name="event"
                                  value='<%= "" + loopCount %>'
                                  onClick='<%= onClick %>'/>
					</td>
					<td>
						<a href="javascript:personListHyperlink('<%=loopCount%>');">
						<%= child.getChildName() %>
						</a>
					</td>
					<td>
						<%= child.getChildGender() %>
					</td>
					<td>
						<%= child.getChildAge() %>
					</td>
				</tr>
				<% 		loopCount++;
					} %>
			</table>
		  <% } %>
		  </td>
		</tr>
		<tr>
			<td>
			<div id="pptParticipation" style="height:90px; width:760px; overflow:auto"></div>
			</td>
		</tr>
		<tr>
			<td>
			    <table border="0" cellpadding="3" cellspacing="0" width="100%">
			      <tr>
			        <td>
			          <div class="alignLeft">
			            <impact:ButtonTag form="frmFosterHomeConversion" 
			            				  img="btnDelete" 
			            				  name="btnDeleteConvChild" 
			            				  action="/fad/HomeConversion/removeChildFromConversion" 
			            				  preventDoubleClick="true"
			            				  function="deleteChildRow()" 
			            				  disabled="<%= Boolean.toString(pageIsApproved) %>" 
			            				  tabIndex="<%=tabIndex++%>" />
			          </div>
			        </td>
			        <td>
			          <div class="alignRight">
			            <impact:ButtonTag form="frmFosterHomeConversion" 
			            				  img="btnAdd" 
			            				  name="btnAddConvChild" 
			            				  action="/fad/HomeConversion/addChildToConversion" 
			            				  preventDoubleClick="true" 
			            				  disabled="<%= Boolean.toString(pageIsApproved) %>" 
			            				  tabIndex="<%=tabIndex++%>" />
			          </div>
			        </td>
			      </tr>
			    </table>
			</td>
		</tr>	
	</table>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="6">
				Foster Home Conversion
			</th>
		</tr>
		<tr>
		  <td>
 	       <impact:validateSelect label="Status" 
 	       						  name="szCdConvAppStatus" 
 	       						  required="true" 
 	       						  onChange="" 
 	       						  tabIndex="<%= tabIndex++ %>" 
			            		  disabled="<%= Boolean.toString(pageIsApproved) %>" 
 	       						  editableMode="<%= EditableMode.CREATE_AND_EDIT %>" 
 	       						  codesTable="CFHCSTTS"
 	       						  value="<%= szCdConvAppStatus %>" />
		  </td>
		</tr>

		<tr>
		  <td>
		  	<impact:validateDisplayOnlyField label="Inquiry Date" name="dtInquiryDate" value="<%= dtInquiryDate %>" cssClass="formInput" />
		  </td>
		</tr>
		<tr>
			<td>
				<impact:validateDate disabled="<%= Boolean.toString(pageIsApproved) %>" 
									 label="Applied Date" 
									 name="dtAppliedDate" 
									 value="<%= dtAppliedDate %>" 
									 tabIndex="<%= tabIndex++ %>" 
									 cssClass="formInput" 
									 constraint="Date" 
									 required="true"/>
			</td>
		</tr>
		<tr>
		  <td>
		  	<impact:validateDisplayOnlyField label="County Approval Date" name="dtApprovedDate" value="<%= dtApprovedDate %>" cssClass="formInput" />
		  </td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField label="Adoption Agency" name="txNmResource" value="<%= txNmResource %>" cssClass="formInput"/>
			</td>
			<td>
				<impact:ButtonTag
				  disabled="<%= Boolean.toString(pageIsApproved) %>" 
				  name="btnSelectResource" 
				  img="btnSelectResource" 
			      align="left" 
				  form="frmFosterHomeConversion" 
				  action="/fad/HomeConversion/getAdoAgency"  
				  tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate label="Closure Date" name="dtClosureDate" value="<%= dtClosureDate %>" tabIndex="<%= tabIndex++ %>" cssClass="formInput" constraint="Date"/>
			</td>
	  	</tr>
	  	<tr>
        	<td>
        <impact:validateSelect label="Closure Reason" name="szCdClosureReason" conditionallyRequired="true" required="false" onChange="" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.CREATE_AND_EDIT %>" codesTable="CFHCCLSR"
          value="<%= szCdClosureReason %>" />
        	</td>
        </tr>

	</table>		
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
    	<td class="alignLeft" width="65%">
    		&nbsp;
    	</td>
    <% if (!PageModeConstants.VIEW.equals(pageMode)) {%>
		<td class="alignRight" width="10%">
	    <% if (!pageIsApproved) {%>
			<impact:ButtonTag
				name="btnSaveAndSubmit" 
				img="btnSaveAndSubmit"
				align="right" 
				form="frmFosterHomeConversion"
				action="/fad/HomeConversion/saveHomeConversion"
		     	restrictRepost="true" 
		     	preventDoubleClick="true" 
				tabIndex="<%=tabIndex++%>"
				 />
		<% } %>
		</td>
		<td class="alignRight" width="5%">
		  <impact:ButtonTag 
		     name="btnSave" 
		     img="btnSave" 
		     align="right" 
		     form="frmFosterHomeConversion" 
		     action="/fad/HomeConversion/saveHomeConversion" 
		     restrictRepost="true" 
		     preventDoubleClick="true" 
		     tabIndex="<%= tabIndex++ %>"
		      />
		</td>
    <%}%>
    </tr>
  </table>
  <br>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />  
</impact:validateForm>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>

    <td>

      <impact:documentButton pageMode="<%= pageMode %>"
                               buttonUrl="/grnds-docs/images/shared/btnNarrative.gif"
                               tabIndex="<%= tabIndex++ %>"
                               accessKey="W" >

           <impact:document displayName="Foster Home Conversion Narrative"
                    protectDocument="<%= pageIsApproved  %>"
                    checkForNewMode = "true"
                    docType="fhconvnarr"
                    windowName="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"
                    docExists="<%= hasNarrative %>" >
                    <impact:documentParameter name="sCase"
                               value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>
                    <impact:documentParameter name="sEvent"
                               value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>
            </impact:document>
    </impact:documentButton>
    </td>

  </tr>
</table>
