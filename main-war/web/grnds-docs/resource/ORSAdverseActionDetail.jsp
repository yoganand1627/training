
<%
  /*
   * JSP Name:     ORSAdverseActionDetail.jsp
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAdverseActionSO"%>
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
  
  
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  ORSAdverseActionSO orsAdverseAction = (ORSAdverseActionSO) state.getAttribute(ORSResourceDetailConversation.ORS_ADVERSE_ACTION_ATTRIBUTE_NAME, request);
  
  String pageMode = PageMode.getPageMode(request);
%>

<script language="JavaScript">

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction() {
  
}


</script>
<impact:validateErrors formName="frmORSAdverseActionDetail" />
<impact:validateForm name="frmORSAdverseActionDetail" 
	action="/resource/ResourceORSDetail/displayORSResourceDetail"
	pageMode="<%=PageModeConstants.VIEW%>"
	schema="/WEB-INF/Constraints.xsd">


	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
		
	  <tr>
	        <th colspan="4">ORS Adverse Action Detail</th>
	  </tr>
        <tr>
            <td><impact:validateDisplayOnlyField name="txtResourceName" label="ORS Resource Name" value="<%=orsAdverseAction.getSzResourceName()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtFacilityID" label="ORS Facility ID" value="<%=orsAdverseAction.getSzORSFacilityID()%>"/></td>
		</tr>

		<tr>
            <td><impact:validateDisplayOnlyField name="txtSurveyIdentifier" label="Survey Identifier" value="<%=orsAdverseAction.getSzSurveyIdentifier()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtDateInitiated" label="Date Initiated" value="<%=FormattingHelper.formatDate(orsAdverseAction.getDtInitiated())%>"/></td>
        </tr>
		
		<tr>
			<td><impact:validateDisplayOnlyField name="txtDisposition" label="Disposition" value="<%=orsAdverseAction.getSzDisposition()%>"/></td>
            <td><impact:validateDisplayOnlyField name="txtReason" label="Reason" value="<%=orsAdverseAction.getSzReason()%>"/></td>
        </tr>
		<tr> 
			<td ><impact:validateDisplayOnlyField name="txtDateLastUpdated" label="Date Last Updated" value="<%=FormattingHelper.formatDate(orsAdverseAction.getDtLastUpdate())%>"/></td>
        </tr>

	</table>
	
	
		
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<input type="hidden" name="destinationUrl" value="<%=destinationUrl%>" />
	<input type="hidden" name="<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>" value="<%=orsAdverseAction.getSzORSFacilityID()%>"/>
</impact:validateForm>