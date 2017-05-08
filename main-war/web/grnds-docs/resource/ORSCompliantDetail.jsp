<%
  /*
   * JSP Name:     ORSComplaintDetail.jsp
   *
   */
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Comparator"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ORSComplaintSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAllegationSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>


<%
  //Initialize all display variables for the page
  String rsrcLegalName = "";
  String rsrcFacilityID = "";
  String destinationUrl = "";
  
  int tabIndex = 1;
  int loopCount = 0;
  String rowCss = "altColor";
  
  String ResourceID = GlobalData.getUlIdResourceAsString( request );
  String ResourceName = GlobalData.getSzNmResource(request);
  
  
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  ORSComplaintSO complaint = (ORSComplaintSO) state.getAttribute(ORSResourceDetailConversation.ORS_COMPLIANT_ATTRIBUTE_NAME, request);
  List<ORSAllegationSO> allegationList = (List<ORSAllegationSO>) state.getAttribute(ORSResourceDetailConversation.ORS_ALLEGATION_LIST_ATTRIBUTE_NAME, request);
  
  String pageMode = PageMode.getPageMode(request);
%>

<script language="JavaScript">

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction() {
  
}


</script>
<impact:validateErrors formName="frmORSComplaintDetail" />
<impact:validateForm name="frmORSComplaintDetail" 
	action="/resource/ResourceORSDetail/displayORSResourceDetail"
	pageMode="<%=PageModeConstants.VIEW%>"
	schema="/WEB-INF/Constraints.xsd">


	
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
	
		
	  <tr>
	        <th colspan="4">ORS Complaint Detail</th>
	 </tr>
        <tr>
            <td><impact:validateDisplayOnlyField name="txtResourceName" label="ORS Resource Name" value="<%=complaint.getSzResourceName()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtFacilityID" label="ORS Facility ID" value="<%=complaint.getSzORSFacilityID()%>"/></td>
		</tr>

		<tr>
            <td><impact:validateDisplayOnlyField name="txtIntakeNumber" label="Intake Number" value="<%=complaint.getSzNmItake()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtIntakeDate" label="Intake Date" value="<%=FormattingHelper.formatDate(complaint.getDtIntake())%>"/></td>
        </tr>
		
		<tr>
			<td><impact:validateDisplayOnlyField name="txtType" label="Type" value="<%=complaint.getSzType()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtStatus" label="Status" value="<%=complaint.getSzStatus()%>"/></td>
        </tr>
		
        <tr>
			<td><impact:validateDisplayOnlyField name="txtPriority" label="Priority" value="<%=complaint.getSzPriority()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtInvestigatorName" label="Investigator Name" value="<%=complaint.getSzInvestigatorName()%>"/></td>
        </tr>
        
        <tr>
         <td class="formLabel">Narrative:</td>
            <td colspan="3">
              <impact:validateTextArea name="txtORSCompliantNarrative"
                                       rows="4"
                                       cols="120"
                                       tabIndex="<%=tabIndex++%>"
                                       constraint="Comments"
                                       maxLength="4000">
                 <%=complaint.getSzNarrative()!= null?FormattingHelper.formatString(complaint.getSzNarrative()):StringHelper.EMPTY_STRING%>
              </impact:validateTextArea>
         </td>
        </tr>
        
		<tr> 
			<td ><impact:validateDisplayOnlyField name="txtDateLastUpdated" label="Date Last Updated" value="<%=FormattingHelper.formatDate(complaint.getDtLastUpdate())%>"/></td>
        </tr>

	</table>
	
	<br>
	
	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderList">
		<tr>
  			<td class="thList" colspan="2">ORS Complaint Allegations</td>
		<tr>
		<%
			if(allegationList != null && allegationList.size() > 0) {
				int loopCounter = 0;
				Iterator<ORSAllegationSO> itrAll = allegationList.iterator();
				while(itrAll.hasNext()){
					ORSAllegationSO allegation = itrAll.next();
					%>
						<tr <%= loopCounter++ % 2 == 1 ? "class='even'" : "" %>>
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
	  								<tr>
		    							<td>
			   							 	<impact:validateDisplayOnlyField name="txtPrimaryType" label="Primary Type" value="<%= allegation.getSzPrimaryType()%>"/>
			  							</td>
			  							<td>
			   							 	<impact:validateDisplayOnlyField name="txtSecondaryType" label="Secondary Type" value="<%= allegation.getSzSecondaryType()%>"/>
			  							</td>
		  							</tr>
		  							<tr>
		    							<td>
			   							 	<impact:validateDisplayOnlyField name="txtFinding" label="Finding" value="<%= allegation.getSzFinding()%>"/>
			  							</td>
		  							</tr>
		  							<tr>
			  							<td class="formLabel">Restatement of the Complaint:</td>
								        <td colspan="3">
								              <impact:validateTextArea name="txtRestatement"
								                                       rows="4"
								                                       cols="120"
								                                       tabIndex="<%=tabIndex++%>"
								                                       constraint="Comments"
								                                       maxLength="4000">
								                 <%=allegation.getSzRestatement() != null ? FormattingHelper.formatString(allegation.getSzRestatement()):StringHelper.EMPTY_STRING%>
								              </impact:validateTextArea>
								         </td>
		  							</tr>
		  							<tr>
			  							<td class="formLabel">Narrative:</td>
								        <td colspan="3">
								              <impact:validateTextArea name="txtNarrative"
								                                       rows="4"
								                                       cols="120"
								                                       tabIndex="<%=tabIndex++%>"
								                                       constraint="Comments"
								                                       maxLength="4000">
								                 <%=allegation.getSzNarrative()!= null?FormattingHelper.formatString(allegation.getSzNarrative()):StringHelper.EMPTY_STRING%>
								              </impact:validateTextArea>
								         </td>
		  							</tr>
		  							<tr>
		    							<td>
			   							 	<impact:validateDisplayOnlyField name="txtDateLastUpdated" label="Date Last Updated" value="<%=FormattingHelper.formatDate(allegation.getDtLastUpdate())%>"/>
			  							</td>
		  							</tr>
		  						</table>
		  				   </td>
		  				</tr>
      				<%
				}
			}
		%>
	</table>
		
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<input type="hidden" name="destinationUrl" value="<%=destinationUrl%>" />
	<input type="hidden" name="<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>" value="<%=complaint.getSzORSFacilityID()%>"/>
</impact:validateForm>