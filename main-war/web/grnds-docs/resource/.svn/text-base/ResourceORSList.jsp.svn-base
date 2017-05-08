<%
/**
 * JSP Name:     ResourceORSList.jsp
 * Created by:   ssubram
 * Date Created: 03/12/08
 *
 * Description:
 * The ORS Resource Search Results page is used to perform the following main
 * functions:
 * To view ORS Resource Details for a selected resource
 * To select a Resource to be used in another functional area
 *
**/
/*
  Change History:
  Date      User      Description
  --------  --------  -----------------------------------------------
  03/12/08	ssubram   Initial Coding
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceORSSearchPullBackInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceORSSearchConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%
  /* SIR# 18921: checkedResource is now a hidden field that gets created even
  ** if there are less than one page results from the search.
  */
  //Initialize display variables for the page
  int numberOfResources = 0;
  List resourceList = new ArrayList();
  String returnPage = "";
  String resultsPerPageName = DatabaseResultDetails.RESULTS_PER_PAGE_NAME;
  String resultsPerPage = "25";
  boolean addButtonHide = false;
  boolean pullBackMode = true;
  boolean restrictNewSearch = false;
  boolean selectedList = false;
  boolean userHasRight = false;
  int tabIndex = 1;
  String APPROVED_EVENT = "APRV";

  //Check the user profile for the attribute to maintain resources.
  UserProfile userProfile = UserProfileHelper.getUserProfile( request );
  if( userProfile != null )
  {
    userHasRight = userProfile.hasRight(UserProfile.SEC_MNTN_RSRC);
  }
  if( !userHasRight )
  {
    addButtonHide = true;
  }

  //Get Results per page
  //int loopCount = 0;
  int resourcesCount = 0;
  if( request.getParameter( DatabaseResultDetails.RESULTS_PER_PAGE_NAME )!=null )
  {
    resultsPerPage = request.getParameter( DatabaseResultDetails.RESULTS_PER_PAGE_NAME );
  }

  //Get Resource Information
  Object results = request.getAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME );
  //If results are not null, set into request for the forEach tag
  Object[] resourceArray = null;
  if( results != null )
  {
    resourceList = ( ( PaginationResultBean )results ).getResults();
    if (resourceList != null)
    {
      numberOfResources = resourceList.size();
      resourceArray = resourceList.toArray();
    }
  }
  //If there is a checkedResources, the sort widgets shouldn't display.
  if( StringHelper.isValid( request.getParameter( "checkedResource" ) ) )
  {
    selectedList = true;
  }
  //If there is a return Page from conversation, set it.
  if( request.getAttribute( "destinationUrl" ) != null )
  {
    returnPage = (String)request.getAttribute( "destinationUrl" );
  }
  //If there is a return Page from search page, set it.
  if( request.getParameter( "destinationUrl" ) != null )
  {
    returnPage = request.getParameter( "destinationUrl" );
  }

  //If no return page or user does not have maintain privileges, hide OK button
  if("".equals(returnPage) )
  {
    pullBackMode = false;
  }

  //Variable to hold the css class for the each row in the lists
  String rowCss = "odd";

  //Capture Search Parameters for pagination
  String resourceName = "";
  String facilityID = "";
  String legalName = "";
  String facilityType = "";
  String orsOperatingStatus = "";
  String address = "";
  String city = "";
  String county = "";
  //If search parameters are in search bean get them from there
  if( request.getAttribute( ResourceORSSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST ) != null )
  {
    ResourceORSSearchPullBackInfo searchBean = ( ResourceORSSearchPullBackInfo )request.getAttribute( ResourceORSSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST );
    resourceName = searchBean.getResourceName();
    facilityID = searchBean.getFacilityID();
    legalName = searchBean.getLegalName();
    facilityType = searchBean.getFacilityType();
    orsOperatingStatus = searchBean.getOrsOperatingStatus();
    address = searchBean.getAddress();
    city = searchBean.getCity();
    county = searchBean.getCounty();
  }
  // else get search parameters from either resource search or list page fields
  else
  {
    resourceName = FormattingHelper.formatString(ContextHelper.getStringSafe(request, "txtResourceName" ));
    facilityID = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtFacilityId"));
    legalName = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtLegalName"));
  }
%>

<script type="text/JavaScript" language="JavaScript1.2">

//general function to submit the search for this page.
function submitListForm( url )
{
  //If 'Display Selected List' button is clicked
  if( url == "selectList" )
  {
    var valueString = "";
    var rowSelected = false;
    <%
    for( int i=0; i<numberOfResources; i++ )
    {%>
      if(document.frmResultsForm.cbxCheckedResource_<%=i%>.checked == true)
      {
        valueString += document.frmResultsForm.cbxCheckedResource_<%=i%>.value;
        valueString += ",";
        rowSelected = true;
      }
    <%
    } //end for loop
    %>
    if( !rowSelected )
    {
      setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>");
      return false;
    }
    else
    {
      document.frmResultsForm.checkedResource.value = valueString;
      disableValidation( "frmResultsForm" );
      return true;
    }
  }
  //If 'OK' button is clicked
  if( url == "callingPage" )
  {
    if( document.frmResultsForm.txtUlIdResource.value == "" )
    {
      setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>");
      return false;
    }
    else
    {
      disableValidation( "frmResultsForm" );
      return true;
    }
  }
  //If 'New Search button' is clicked
  if( url == 'newSearch' )
  {
    disableValidation( "frmResultsForm" );
    return true;
  }
  //If 'Refine Search' is clicked
  if( url == 'refineSearch' )
  {
    disableValidation( "frmResultsForm" );
    return true;
  }
}

//function called if a Resource Name hyperlink is selected
function submitResourceID( facilityId )
{
  document.frmResultsForm.<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>.value = "";
  document.frmResultsForm.<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>.value = facilityId;
  disableValidation( "frmResultsForm" );
  submitValidateForm( "frmResultsForm", "/resource/ResourceORSDetail/displayORSResourceDetail" );
}

//function called if a Resource Name hyperlink is selected
function setORSResourceID( facilityId )
{
  //clear out the value and then set it
  document.frmResultsForm.<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>.value = "";
  document.frmResultsForm.<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>.value = facilityId;
}


function setResourceId( facilityId )
{
  document.frmResultsForm.txtFacilityId.value = facilityId;
}

</script>
<!--Start Main Content-->
<%
// Create addSelected string with number of resources and form name with results list
// for use by PaginationHelper to create JavaScript on this page that submits selected
// resources during pagination
String addSelected = null;
if( !pullBackMode )
{
  StringBuffer addSelectedBuffer = new StringBuffer(String.valueOf(numberOfResources));
  addSelectedBuffer.append(",");
  addSelectedBuffer.append("frmResultsForm");
  addSelected = addSelectedBuffer.toString();
}

%>

<impact:validateForm name="frmResultsForm"
                     method="post"
                     action="/resource/ResourceORSDetail/displayORSResourceDetail"
                     pageMode="<%=PageModeConstants.EDIT%>"
                     schema="/WEB-INF/Constraints.xsd">
<impact:validateErrors/>

<impact:pagination submitUrl="/resource/ResourceORSSearch/results"
  addSelected="<%=addSelected%>">

  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <impact:validateInput type="hidden"  name="validationOverride"/>
  <!-- Capture search parameters as hidden fields -->
  <input type="hidden"  name="txtResourceName" value="<%=resourceName%>"/>
  <input type="hidden"  name="txtFacilityId" value="<%=facilityID%>"/>
  <input type="hidden"  name="txtLegalName" value="<%=legalName%>"/>
  <input type="hidden"  name="txtFacilityType" value=""/>
  <input type="hidden"  name="requestFromListPage" value="ResourceORSList"/>
  <input type="hidden" name="destinationUrl" value="<%=returnPage%>"/>
  <%//if no resources were found, display error message for this.
    if ( numberOfResources == 0 && request.getAttribute( BasePrsConversation.ERROR_MESSAGES ) == null )
    {
  %>
<table width="100%" cellpading="0" cellspacing="0" border="0">
 <tr><td class="alignRight">
<div class="formInstruct">Scroll for more information  --></div>
  </td>
</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td>
<%   /* SIR 23639 - Use full screen width for MPS - had to use different widths so that IMPACT remains the same */ %>
<impact:ifServerImpact>
      <div id="scrollBar2" style="height:330px; width:760px; overflow:auto" class="tableborderList">
        <table width="1300" cellspacing="0" cellpadding="3" border="0">
</impact:ifServerImpact>
<impact:ifMobileImpact>
      <div id="scrollBar2" style="height:310px; width:100%; overflow:auto" class="tableborderList">
        <table width="150%" cellspacing="0" cellpadding="3" border="0">
</impact:ifMobileImpact>

         <%if( selectedList == true ){%>
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name</th>
            <th class="thList" width="8%">ORS Facility ID</th>
            <th class="thList" width="15%">Legal Name</th>
            <th class="thList" width="19%">Facility Type</th>
            <th class="thList" width="3%">ORS Operating Status</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10%">City</th>
            <th class="thList" width="10%">County</th>
            <th class="thList" width="9%">Resource ID</th>
            <th class="thList" width="7">&nbsp;</th>
          <%} else{%>
          <tr>
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name<impact:sortableColumnHeader orderBy="NAME" isDefault="true" /></th>
            <th class="thList" width="8%">Facility ID</th>
            <th class="thList" width="15%">Legal Name<impact:sortableColumnHeader orderBy="LEGALNAME" /></th>
            <th class="thList" width="19%">Facility Type</th>
            <th class="thList" width="3%">ORS Operating Status</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10">City<impact:sortableColumnHeader orderBy="FAC_CITY" /></th>
            <th class="thList" width="9%">County<impact:sortableColumnHeader orderBy="COUNTY" /></th>
            <th class="thList" width="9%">Resource ID</th>
          </tr>
          <%}%>
                <tr class="odd">
                  <td colspan="10">
                     <%= MessageLookup.getMessageByNumber( Messages.MSG_INT_NO_MATCHES_FND ) %>
                  </td>
                </tr>
        </table>
      </div>
<!--- closing div table --->
    </td>
  </tr>
</table>

<%//If an error message is being displayed along with no resources found, don't display anything
  }else if ( numberOfResources == 0 && request.getAttribute( BasePrsConversation.ERROR_MESSAGES ) != null )
  {
%>
<table width="100%" cellpading="0" cellspacing="0" border="0">
 <tr><td class="alignRight">
<div class="formInstruct">Scroll for more information  --></div>
  </td>
</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td>
<%   /* SIR 23639 - Use full screen width for MPS - had to use different widths so that IMPACT remains the same */ %>
<impact:ifServerImpact>
      <div id="scrollBar2" style="height:330px; width:760px; overflow:auto" class="tableborderList">
        <table width="1300" cellspacing="0" cellpadding="3" border="0">
</impact:ifServerImpact>
<impact:ifMobileImpact>
      <div id="scrollBar2" style="height:310px; width:100%; overflow:auto" class="tableborderList">
        <table width="150%" cellspacing="0" cellpadding="3" border="0">
</impact:ifMobileImpact>
         <%if( selectedList == true ){%>
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name</th>
            <th class="thList" width="8%">ORS Facility ID</th>
            <th class="thList" width="15%">Legal Name</th>
            <th class="thList" width="19%">Facility Type</th>
            <th class="thList" width="3%">ORS Operating Status</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10%">City</th>
            <th class="thList" width="10%">County</th>
            <th class="thList" width="9%">Resource ID</th>
          <%} else{%>
          <tr>
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name<impact:sortableColumnHeader orderBy="NAME" isDefault="true" /></th>
            <th class="thList" width="8%">Facility ID</th>
            <th class="thList" width="15%">Legal Name<impact:sortableColumnHeader orderBy="LEGALNAME" /></th>
            <th class="thList" width="19%">Facility Type</th>
            <th class="thList" width="3%">ORS Operating Status</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10">City<impact:sortableColumnHeader orderBy="FAC_CITY" /></th>
            <th class="thList" width="9%">County<impact:sortableColumnHeader orderBy="COUNTY" /></th>
            <th class="thList" width="9%">Resource ID</th>
          </tr>
          <%}%>
        </table>
      </div>
<!--- closing div table --->
    </td>
  </tr>
</table>
<% //If results were found and no error messages, display the results
  }
  else
  {
%>

<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr>
    <td class="alignRight">
      <div class="formInstruct">Scroll for more information  --></div>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td>
<%   /* SIR 23639 - Use full screen width for MPS - had to use different widths so that IMPACT remains the same */ %>
<impact:ifServerImpact>
      <div id="scrollBar2" style="height:330px; width:760px; overflow:auto" class="tableborderList">
        <table width="1300" cellspacing="0" cellpadding="3" border="0">
</impact:ifServerImpact>
<impact:ifMobileImpact>
      <div id="scrollBar2" style="height:310px; width:100%; overflow:auto" class="tableborderList">
        <table width="150%" cellspacing="0" cellpadding="3" border="0">
</impact:ifMobileImpact>
         <%if( selectedList == true ){%>
         <tr>
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name</th>
            <th class="thList" width="8%">ORS Facility ID</th>
            <th class="thList" width="15%">Legal Name</th>
            <th class="thList" width="19%">Facility Type</th>
            <th class="thList" width="3%">ORS Operating Status</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10%">City</th>
            <th class="thList" width="10%">County</th>
            <th class="thList" width="9%">Resource ID</th>
          </tr>  
          <%} else{%>
          <tr>
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name<impact:sortableColumnHeader orderBy="NAME" isDefault="true" /></th>
            <th class="thList" width="8%">Facility ID</th>
            <th class="thList" width="15%">Legal Name<impact:sortableColumnHeader orderBy="LEGALNAME" /></th>
            <th class="thList" width="19%">Facility Type</th>
            <th class="thList" width="3%">ORS Operating Status</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10">City<impact:sortableColumnHeader orderBy="FAC_CITY" /></th>
            <th class="thList" width="9%">County<impact:sortableColumnHeader orderBy="COUNTY" /></th>
            <th class="thList" width="9%">Resource ID</th>
          </tr>
          <%}%>
     <%
     for(int i=0; i<resourceArray.length; i++)
     {
       String serializedResource = SerializationHelper.serializeObject(resourceArray[i]);
       rowCss = FormattingHelper.getRowCss( i + 1 );
       ResourceORSSearchValueBean currentResource = (ResourceORSSearchValueBean)resourceArray[i];
       String facId = (currentResource.getFacilityID() != null) ? currentResource.getFacilityID(): "0";
     %>
      <!--HIDDEN FIELDS: RESOURCE_ID is = <%=facId %> -> (TEST FOR HAVING HIDDEN INFO VISIBLE IN SOURCE ONLY) -->
          <tr valign="top" class="<%=rowCss%>">
     <%if( ! pullBackMode ){%>
            <td><input type="checkbox" id="resource" name="cbxCheckedResource_<%=i%>" value="<%=serializedResource%>" onClick="javaScript: setResourceId('<%=currentResource.getFacilityID()%>')" tabIndex="<%= tabIndex++ %>"> </td>
            <td><a tabIndex="<%= tabIndex++ %>" href="javascript:submitResourceID('<%=facId%>')") ><%=currentResource.getResourceName()%></a></td>
     <%} else{%>
            <td><input type="radio" id="resource" name="rbResource" value="<%=i%>" onClick="javaScript: setORSResourceID('<%=facId%>')" tabIndex="<%= tabIndex++ %>"> </td>
            <td><nobr><%=currentResource.getResourceName()%></nobr></td>
     <%}%>
            <td><%=facId %></td>
            <td><%=( currentResource.getLegalName() != null ) ? currentResource.getLegalName() : "&nbsp;" %></td>
            <td><%=(currentResource.getFacilityType() != null ) ? Lookup.simpleDecodeSafe("CORSOPFT", currentResource.getFacilityType() ) : "&nbsp;" %></td>
            <td><%=( currentResource.getOrsOperatingStatus() != null ) ? Lookup.simpleDecodeSafe("CORSOPST",currentResource.getOrsOperatingStatus()) : "&nbsp;" %></td>
            <td><%=(currentResource.getAddress() != null) ? currentResource.getAddress() : "&nbsp;"%></td>
            <td> <%=(currentResource.getCity() != null) ? currentResource.getCity() : "&nbsp;"%></td>
            <td> <%=(currentResource.getCounty() != null) ? currentResource.getCounty() : "&nbsp;"%></td>
            <td> <%=(currentResource.getShinesResourceId() != null) ? currentResource.getShinesResourceId() : "&nbsp;"%></td>
          </tr>
      <%}//End For
      %>
      <!-- <input type="hidden" name="txtUlIdResource"/>
         <input type="hidden" name="txtNmResource"/> -->
      <!--- SIR# 18921. checkedResource is now a hidden field... --->
      <!--- SIR# 18498. uncommented the next line --->
      <!--  <input type="hidden" name="checkedResources"/> -->
        <input type="hidden" name="<%=resultsPerPageName%>" value="<%=resultsPerPage%>"/>
        </table>
      </div>
<!--- closing div table --->
    </td>
  </tr>
</table>
<%
        }//end else
%>
</impact:pagination>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td align="right">
     <% if( !pullBackMode ){%>
      <impact:ButtonTag name="btnDisplayList" img="btnDisplaySelectedList" function="return submitListForm('selectList'); " form="frmResultsForm" action="/resource/ResourceORSSearch/displaySelectedList" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
     <%}%>
     <% if( !restrictNewSearch ){%>
      <impact:ButtonTag name="btnRefineSearch" img="btnRefineSearch" function="return submitListForm('refineSearch'); " form="frmResultsForm" action="/resource/ResourceORSSearch/refineSearch" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
      <impact:ButtonTag name="btnNewSearch" img="btnNewSearch" function="return submitListForm('newSearch'); " form="frmResultsForm" action="/resource/ResourceORSSearch/" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
     <%}%>
     <%if( pullBackMode && numberOfResources != 0  ){%>
        <impact:ButtonTag name="btnContinue" img="btnContinue" form="frmResultsForm" action="/resource/ResourceORSSearch/pullBackResource" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
     <%} else{%>&nbsp;<%}%>
    </td>
  </tr>
</table>
<%
  request.removeAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME );
%>
<input type="hidden" name="<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>"/>
</impact:validateForm>