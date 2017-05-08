<%
  /*
 * JSP Name:     ORSResourceDetail.jsp
 *
 * <pre>
 *                        Change History:
 *                        Date      User                            Description
 *                        --------  ----------------               --------------------------------------------------
 * </pre>                 07/30/2008 mchillman        STGAP00009801 different message will display for non-residential facilities compliants
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ORSResourceDetailSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ORSComplaintSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAdverseActionSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Ccount"%>


<%
  //Initialize all display variables for the page
  String rsrcLegalName = "";
  String rsrcFacilityID = "";
  String destinationUrl = "";
  
  int tabIndex = 1;
  int loopCount = 0;
  String rowCss = "altColor";
  
  
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  ORSResourceDetailSO orsDetail = (ORSResourceDetailSO) state.getAttribute(ORSResourceDetailConversation.ORS_DETAIL_ATTRIBUTE_NAME, request);
  List<ORSComplaintSO> complaintList = orsDetail.getComplaints();
  List<ORSAdverseActionSO> adverseActionList = orsDetail.getAdverseActions();
  
  String pageMode = PageMode.getPageMode(request);
%>

<script language="JavaScript">

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction() {
  
}

/*
  *This function submits the form to bring up address complaint detail page.
  */
function submitFormComplaintDetail( compliantRowId ) {
 document.frmORSResourceDetail.txtCompliantRowId.value = compliantRowId
 disableValidation( "frmORSResourceDetail" );
 submitValidateForm( "frmORSResourceDetail", "/resource/ResourceORSDetail/displayORSComplaintDetail" );
}

/*
  *This function submits the form to bring up address adverse action detail page.
  */
function submitFormAdverseActionDetail( adverseActionRowId ) {
 document.frmORSResourceDetail.txtAdverseActionRowId.value = adverseActionRowId
 disableValidation( "frmORSResourceDetail" );
 submitValidateForm( "frmORSResourceDetail", "/resource/ResourceORSDetail/displayORSAdverseActionDetail" );
}


/*
  *This function submits the form to create a shines resoure from a ors resource.
  */
function submitFormAddToShines() {
 disableValidation( "frmORSResourceDetail" );
}


</script>
<impact:validateErrors formName="frmORSResourceDetail" />
<impact:validateForm name="frmORSResourceDetail" 
	method="post"
	action="/resource/ORSResourceDetail/saveResourceDetail"
	pageMode="<%=PageModeConstants.EDIT%>"
	schema="/WEB-INF/Constraints.xsd">
		
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<%/* Use descriptive IDs for your Table and Tag identifiers :
				   Javascript code would be better inside a function that is called from here,
				   but for ease of use I have put the code here */
				%>
				<a href="#" onClick="expandAll();">Expand All</a>&nbsp;
				<a href="#" onClick="collapseAll();">Collapse All</a>&nbsp;
			</td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
	
	  <tr>
	        <th colspan="4">ORS Resource Detail</th>
	 </tr>
        <tr>
        	<td><impact:validateDisplayOnlyField name="txtResourceName" label="ORS Resource Name" value="<%=orsDetail.getSzResourceName()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtFacilityID" label="ORS Facility ID" value="<%=orsDetail.getSzORSFacilityID()%>"/></td>
		</tr>

		<tr>
			<td><impact:validateDisplayOnlyField name="txtLegalName" label="Legal Name" value="<%=orsDetail.getSzLegalName()%>"/></td>
        </tr>
		
		<tr>
			<td><impact:validateDisplayOnlyField name="txtORSOperatingStatus" label="ORS Operating Status" value="<%=orsDetail.getSzOperatingStatus()%>"/></td>
        </tr>
		
        <tr>
			<td><impact:validateDisplayOnlyField name="txtAddress" label="Address" value="<%=orsDetail.getSzAddress()%>"/></td>
        </tr>
		
		<tr>
            <td><impact:validateDisplayOnlyField name="txtCity" label="City" value="<%=orsDetail.getSzCity()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtState" label="State" value="<%=orsDetail.getSzState()%>"/></td>
		</tr>
		
		<tr>
			<td><impact:validateDisplayOnlyField name="txtZip" label="Zip" value="<%=orsDetail.getSzZipCode()%>"/></td>
			<td><impact:validateDisplayOnlyField name="txtCounty" label="County" value="<%=orsDetail.getSzCounty()%>"/></td>
        </tr>
		
		<tr>
			<td><impact:validateDisplayOnlyField name="txtLicenseNumber" label="License Number" value="<%=orsDetail.getSzORSLicenseNumber()%>"/></td>
			<td><impact:validateDisplayOnlyField name="txtFacilityType" label="Facility Type" value="<%=orsDetail.getSzORSFacilityType()%>"/></td>
        </tr>
		
        <tr>
        	<td><impact:validateDisplayOnlyField name="txtFacilityTypeOfervice" label="Facility Type of Service" value="<%=orsDetail.getSzTypeOfService()%>"/></td>
        </tr>
		
		<tr>
			<td><impact:validateDisplayOnlyField name="txtAgesOfChildrenServed" label="Ages of Children Served" value="<%=orsDetail.getSzAgesOfChildrenServed()%>"/></td>
			<td><impact:validateDisplayOnlyField name="txtCapacity" label="Capacity" value="<%=orsDetail.getSzCapacity()%>"/></td>
        </tr>
		<tr>
			<td><impact:validateDisplayOnlyField name="txtLicenseType" label="License Type" value="<%=orsDetail.getSzLicenseType()%>"/></td>
			<td><impact:validateDisplayOnlyField name="txtLicenseContinuationIndicator" label="License Continuation Indicator" value="<%=orsDetail.getIndLicenseContinuation()%>"/></td>
        </tr>
		<tr>
			<td><impact:validateDisplayOnlyField name="txtLicenseEffectiveDate" label="License Effective Date" value="<%=FormattingHelper.formatDate(orsDetail.getDtLicenseEffective())%>"/></td>
        </tr>
		<tr>
			<td><impact:validateDisplayOnlyField name="txtDateLastUpdated" label="Date Last Updated" value="<%=FormattingHelper.formatDate(orsDetail.getDtLastUpdated())%>"/></td>
        </tr>
         <tr>
        	<td><impact:validateDisplayOnlyField name="txtResourceID" label="Resource ID" value="<%=orsDetail.getSzShinesRsrsID()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtFacilityID" label="Resource Name" value="<%=orsDetail.getSzShinesRsrsName()%>"/></td>
		</tr>

	</table>
	
	
	<br>
	
	<impact:ExpandableSectionTag
		name="complaintDetail"
		label="ORS Complaint List"
		tabIndex="<%=tabIndex++%>">
		<impact:pagination  saveState="true" submitUrl="/resource/ResourceORSDetail/displayORSResourceDetail">
		  <div id="ORSComplaintListScroll" style="OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px" class="tableBorder">
		    
		    <table border="0" cellspacing="0" cellpadding="3" width="100%">
		      <tr>
		        <th class="thList">Intake Number</th>
		        <th class="thList">Intake Date</th>
		        <th class="thList">Type</th>
		        <th class="thList">Status</th>
		        <th class="thList">Priority</th>
		        <th class="thList">Date Last Updated</th>
		     </tr>
		     
		    <%
        		loopCount = 0;
        		if (complaintList != null && complaintList.size() > 0) {
        			Iterator<ORSComplaintSO> itrComplaint = complaintList.iterator();
        			while(itrComplaint.hasNext()){
        				ORSComplaintSO complaint = itrComplaint.next();
        				rowCss = FormattingHelper.getRowCss(++loopCount);
        				%>
        					<tr class="<%=rowCss%>" valign="top">
    					<%
    					
						// SIR 23730 Phase II Mobile Start
						if( PlatformConstants.MOBILE_IMPACT ) {   
						 %>
						 	<td><nobr><%=complaint.getSzNmItake()%></nobr></td>
						 <%
						} else {
						 %>
						 	<td><nobr><a tabIndex="<%=tabIndex++%>" href="javascript:submitFormComplaintDetail( '<%=loopCount%>', 'U')"><%=complaint.getSzNmItake()%> </a></nobr></td>
						 <%        
						 }
						     // SIR 23730 Phase II Mobile End
						 %>
						   <td><nobr><%=FormattingHelper.formatDate(complaint.getDtIntake())%></nobr></td>
						   <td><nobr><%=complaint.getSzType()%></nobr></td>
						   <td><nobr><%=complaint.getSzStatus()%></nobr></td>
						   <td><nobr><%=complaint.getSzPriority().length() <= 40 ? complaint.getSzPriority() : complaint.getSzPriority().substring(0 ,40)%></nobr></td>
						   <td><nobr><%=FormattingHelper.formatDate(complaint.getDtLastUpdate())%></nobr></td>
						  </tr>
						<% 
					}
        		}
        		else {
        		  String facType = orsDetail.getSzORSFacilityTypeCode();
        		  if(facType != null && facType.startsWith("4")) {
        		    %>
        			   <tr class="odd"><td colspan="6">No Results Found</td></tr>
        		   <%
        		  } else {
        		  	 %>
        			   <tr class="odd"><td colspan="6">Data not available through Shines, but available from ORS at 404-657-5550</td></tr>
        		   <%
        		  }
        		}
        	%>
		    </table>
		    
		</div>
		</impact:pagination>
	</impact:ExpandableSectionTag>
	
	<br>
	
	<impact:ExpandableSectionTag
		name="adverseActionDetail"
		label="ORS Adverse Action List"
		tabIndex="<%=tabIndex++%>">
		
		  <div id="ORSAdverseActionListScroll" style="OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px" class="tableBorder">
		    <table border="0" cellspacing="0" cellpadding="3" width="100%">
		      <tr>
			      <th class="thList">Survey Identifier</th>
			      <th class="thList">Date Initiated</th>
			      <th class="thList">Disposition</th>
			      <th class="thList">Date Last Updated</th>
		      </tr>
			<%
        		loopCount = 0;
        		if (adverseActionList != null && adverseActionList.size() > 0) {
        			Iterator<ORSAdverseActionSO> itrAction = adverseActionList.iterator();
        			while(itrAction.hasNext()){
        				ORSAdverseActionSO action = itrAction.next();
        				rowCss = FormattingHelper.getRowCss(++loopCount);
        				%>
        					<tr class="<%=rowCss%>" valign="top">
    					<%
    					
						// SIR 23730 Phase II Mobile Start
						if( PlatformConstants.MOBILE_IMPACT )
						    {   
						 %>
						 	<td><nobr><%=action.getSzSurveyIdentifier()%></nobr></td>
						 <%
						} else {
						 %>
						 	<td><nobr><a tabIndex="<%=tabIndex++%>" href="javascript:submitFormAdverseActionDetail( '<%=loopCount%>', 'U')"><%=action.getSzSurveyIdentifier()%> </a></nobr></td>
						 <%        
						 }
						     // SIR 23730 Phase II Mobile End
						 %>
						   <td><nobr><%=FormattingHelper.formatDate(action.getDtInitiated())%></nobr></td>
						   <td><nobr><%=action.getSzDisposition()%></nobr></td>
						   <td><nobr><%=FormattingHelper.formatDate(action.getDtLastUpdate())%></nobr></td>
						  </tr>
						<% 
					}
        		}
        		else {
        		%>
        			<tr class="odd"><td colspan="4">No Results Found</td></tr>
        		<%
        		}
        	%>
		    </table>
		</div>
	</impact:ExpandableSectionTag>
	
	<% if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) ) { %>
		<table border="0" cellspacing="0" cellpadding="3" width="100%">
		  <tr>
		    <td align="right">
		      <impact:ButtonTag name="btnSave"
		                                     img="btnAddToSHINES"
		                                     align="right"
		                                     editableMode="<%= EditableMode.EDIT %>"
		                                     function="javascript:disableValidation('frmORSResourceDetail');"
		                                     form="frmORSResourceDetail"
		                                     action="/resource/ResourceORSDetail/addORSResourceToShines"
		                   					 restrictRepost="true"
		                                     tabIndex="<%=tabIndex++%>"/>
		    </td>
		  </tr>
		</table>
	<%}%>

	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<input type="hidden" name="destinationUrl" value="<%=destinationUrl%>" />
	<input type="hidden" name="txtCompliantRowId"/>
	<input type="hidden" name="txtAdverseActionRowId"/>
	<!-- For the add page pass the prepop values in the request-->
	<input type="hidden" name="txtNmResource" value="<%=(orsDetail.getSzResourceName().length() > 30) ? orsDetail.getSzResourceName().substring(0, 30) : orsDetail.getSzResourceName()%>" />
	<input type="hidden" name="txtNmLegal" value="<%=orsDetail.getSzLegalName()%>" /> 
	<input type="hidden" name="<%=AddressBean.ADDRESS1%>" value="<%=orsDetail.getSzAddress()%>" /> 
	<input type="hidden" name="<%=AddressBean.CITY%>" value="<%=orsDetail.getSzCity()%>" /> 
	<input type="hidden" name="<%=AddressBean.COUNTY%>" value="<%=Lookup.simpleEncodeSafe(Ccount.CCOUNT, orsDetail.getSzCounty())%>" /> 
	<input type="hidden" name="<%=AddressBean.STATE%>" value="<%=orsDetail.getSzState()%>" /> 
	<input type="hidden" name="<%=AddressBean.ZIP%>" value="<%=orsDetail.getSzZipCode()%>" /> 
	<input type="hidden" name="<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>" value="<%=orsDetail.getSzORSFacilityID()%>" /> 
</impact:validateForm>