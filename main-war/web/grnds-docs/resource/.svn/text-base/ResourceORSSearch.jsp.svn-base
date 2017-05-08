<%
/*
 * JSP Name:     ResourceORSSearch.jsp
 * Created by:   ssubram
 * Date Created: 03/12/08
 *
 * Description:
 * This page allows a user to search for ORS resources in the Database by searching on
 * a Name, Facility ID or Legal Name.
 *
 *  Change History:
 *  Date      User              Description
 *  --------  ----------------  --------------------------------------------------
 *  03/12/06  ssubram           Initial Code 
 */
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceDetailConversation" %>


<%
  //Initialize all display variables for the page
  ResourceORSSearchValueBean bean = new ResourceORSSearchValueBean();
  String resourceName = "";
  String facilityID = "";
  String legalName = "";
  String errorMessage = "";
  String destinationUrl = "";
    
  int tabIndex = 1;
  UserProfile userProfile = UserProfileHelper.getUserProfile( request );
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  if( state.getAttribute( "checkedResources", request) != null )
  {
    state.removeAttribute( "checkedResources", request );
  }

  //Determine if an error message has been set for this page
  if( request.getAttribute( "errorMessage" ) != null )
  {
    errorMessage = (String)request.getAttribute( "errorMessage" );
    request.removeAttribute( "errorMessage" );
  }

  if( request.getAttribute( "destinationUrl" ) != null )
  {
    destinationUrl = (String)request.getAttribute( "destinationUrl" );
  }
  else if (request.getParameter( "destinationUrl" ) != null )
  {
    destinationUrl = request.getParameter( "destinationUrl" );
  }

//In case of validation failure, get values entered for dynamically populated drop downs and radio buttons to redisplay values previously entered

  if( request.getParameter("requestFromListPage") == null )
  {
    if(request.getParameter("txtResourceName")!=null){ resourceName = request.getParameter("txtResourceName");}
    if(request.getParameter("txtFacilityId")!=null){ facilityID = request.getParameter("txtFacilityId");}
    if(request.getParameter("txtLegalName")!=null){ legalName = request.getParameter("txtLegalName");}
  }
  //Get all search parameters entered previously on page for refining search
  else if( request.getAttribute( "searchBean" ) != null )
  {
    bean = (ResourceORSSearchValueBean)request.getAttribute( "searchBean" );
    if(bean.getResourceName()!=null){resourceName = bean.getResourceName();}
    if(bean.getFacilityID()!=null){facilityID = bean.getFacilityID();}
    if(bean.getLegalName()!=null){legalName = bean.getLegalName();}

    if(request.getParameter("destinationUrl")!=null ){
       destinationUrl = request.getParameter("destinationUrl");
    }
  }
  String personId = String.valueOf( userProfile.getUserID() );
%>

<script language="JavaScript">
window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction()
{
  /** If an error message is received that is not from the validation framework make sure
   *  on the second submit the form is submitted for validation */

  <%if( !"".equals(errorMessage) )
    {%>
      document.frmResourceORSSearch.action = "/resource/ResourceORSSearch/default";
  <%}%>

  setFocus();

}

//set the initial focus of the page
function setFocus()
{
  document.frmResourceORSSearch.txtResourceName.focus();
}
</script>

<impact:validateErrors formName="frmResourceORSSearch"/>
<impact:validateForm
   name="frmResourceORSSearch"
   method="post"
   action="/resource/ResourceORSSearch/results"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceORSSearchValidation"
   pageMode="<%= PageModeConstants.EDIT %>"
   defaultButton="true"
   schema="/WEB-INF/Constraints.xsd">
    <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
     <tr>
      <th colspan="4">Resource Details
      </th>
     </tr>
     <tr>
      <td colspan="4" class="formInstruct">When conducting a ORS resource search, one of the following must be entered: Resource Name, Facility ID or Legal Name.</td>
     </tr>
     <tr>
      <td width="20%">
        <impact:validateInput tabIndex="<%=tabIndex++%>"
                              value="<%=resourceName%>"
                              type="text"
                              name="txtResourceName"
                              label="Resource Name"
                              cssClass="formInput"
                              size="50"
                              maxLength="50"
                              constraint="Paragraph"
                              conditionallyRequired="true"/>
      </td>
     </tr>
     <tr>
      <td>
          <impact:validateInput tabIndex="<%=tabIndex++%>"
                                value="<%=facilityID%>"
                                type="text"
                                name="txtFacilityId"
                                label="Facility ID"
                                cssClass="formInput"
                                maxLength="16"
                                size="16"
                                constraint="Paragraph"
                                conditionallyRequired="true"/>
      </td>
     </tr>
      <tr>
       <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
                              value="<%=legalName%>"
                              type="text"
                              name="txtLegalName"
                              label="Legal Name"
                              cssClass="formInput"
                              size="80"
                              maxLength="80"
                              constraint="Paragraph"
                              conditionallyRequired="true"/>
       </td>
      </tr>
    </table>
	<br>
	<table cellspacing="0" cellpadding="3" width="100%" border="0">
	  <tr>
	    <td valign="top" align="right">
	      <impact:ButtonTag name="btnSearch"
	                        backSafe="true"
	                        editableMode="<%= EditableMode.EDIT %>"
	                        img="btnSearch"
	                        align="right"
	                        form="frmResourceORSSearch"
	                        action="/resource/ResourceORSSearch/results"
	                        tabIndex="<%= tabIndex++ %>"/>
	    </td>
	  </tr>
	</table>
  <!-- <input type="hidden" name="advSearchExpanded" value="<!%=request.getParameter( "advSearchExpanded" )%>">  -->
  <input type="hidden" name="<%=DatabaseResultDetails.RESULTS_PER_PAGE_NAME%>" value="25"/>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <input type="hidden" name="destinationUrl" value="<%=destinationUrl%>"/>
</impact:validateForm>