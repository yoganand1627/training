<%--
JSP Name:     Person Search Address
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>


<% 
String name = "";
String address ="";

name = request.getParameter("hdnFullName");
address = request.getParameter("hdnAddress");

 BaseSessionStateManager state
          = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UserProfile user = UserProfileHelper.getUserProfile(request);

 // PAGE MODE LOGIC BEGIN
  String pageMode;
  pageMode = user.hasRight(UserProfile.SEC_ASSIGN_WORKLOAD) ? PageModeConstants.EDIT : PageModeConstants.VIEW;

%>

<div id="pageNav">
<ul>
	<li class="lvl2NavSelect tab">Address Map</li>
</ul>
</div>
<impact:validateErrors/>
<impact:validateForm name="addressmapform"
                     method="post"
                     action="/person/PersonSearch/displayPersonSearchAddress"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd">
<table width="100%">	
	<tr>
	<br/>
  		<a href="javascript:history.go(-1)">Back to Search Results</a>&nbsp;
	</tr>
	<tr>
		<td>
			&nbsp;
		</td>
	</tr>
</table>	
<table>
	<tr>	
  		<%=name + "." %>&nbsp;<%=address + ".    "%>
	</tr>	
	<tr>
		
		<th>
			<img src="http://maps.google.com/maps/api/staticmap?center=<%=address%>,GA
			&zoom=15
			&size=1400x512
			&maptype=roadmap 
			&mobile=true
			&markers=color:blue|<%=address%>,GA
			&sensor=false" />
		</th>
			
	</tr>
</table>
			
<impact:validateInput type="hidden" name="pageMode" value=""/>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

</impact:validateForm>


		
