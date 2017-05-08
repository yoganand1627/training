<%
/**
 * JSP Name:     ResourceList.jsp
 * Created by:   ranas
 * Date Created: 06/04/02
 *
 * Description:
 * The Resource Search Results page is used to perform the following main
 * functions:
 * To view Resource Details for a selected resource
 * To add a new Resource
 * To select a Resource to be used in another functional area
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  05/19/04  Linda Reed        SIR 18791 - Added sortable County to Result List.
  05/31/05  CORLEYAN          SIR 23622 - Add indDonated information as a hidden
                              field so that it can be re-retrieved for pagination.
  07/01/05  piazzat           Changes to support MPS
  07/24/05  brauchs        Adjusted tables for SIR 23639 - Use full screen width for MPS
  08/13/08	Modeste Ngom      SIR STGAP00004550 - Changed code to display all Resource Statuses
  12/30/09  mchillman         Change to support performing full search from SerAuth page for Ado 510 - 512 service codes
  06/30/2010 bgehlot      60409 Add new error message when resource selection is CPA when coming from
 *                                 Investigation conclusion and Intake Information page.
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchConversation"%>
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
  //HD -- SIR 17478: Don't show 'Refine Search' or 'New Search' buttons if
  //                 coming from Intake Actions or Service Auth
  /* HH -- SIR #19750: don't hide the button if comming from Intake Actions page
    I took returnPage.equals("/intake/IntakeActions/setFacilityResource")
    out of if statement to fix the problem */
  if("/financials/ServiceAuth/setResource".equals(returnPage) )
  {
    restrictNewSearch = true;
  }
  //If no return page or user does not have maintain privileges, hide OK button
  if("".equals(returnPage) )
  {
    pullBackMode = false;
  }

  //Variable to hold the css class for the each row in the lists
  String rowCss = "odd";

  //Capture Search Parameters for pagination
  String resourceType = "";
  String resourceName = "";
  String identificationType = "";
  String identificationNumber = "";
  String resourceProgram = "";
  String resourceCategory = "";
  String resourceService = "";
  String resourceLocationArea = "";
  String resourceRegion = "";
  String resourceCounty = "";
  String resourceCity = "";
  String resourceState = "";
  String resourceZip = "";
  String resourceZipSuffix = "";
  String resourceStatus = "";
  String resourceFacilityType = "";
  String resourceLOC = "";
  String resourceAge = "";
  String resourceSex = "";
  String resourceCharacteristics = "";
  String resourceContractedStatus = "";
  String effectiveDate = "";
  double resourceDistance = 0.0;
  String proxRange = "";
  String resourceAddress = "";
  // SIR 23622
  String indDonated = "";
  boolean showRefineSearchFromPullBack = false;
  //If search parameters are in search bean get them from there
  if( request.getAttribute( ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST ) != null )
  {
    ResourceSearchPullBackInfo searchBean = ( ResourceSearchPullBackInfo )request.getAttribute( ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST );
    resourceType = searchBean.getResourceType();
    resourceName = searchBean.getResourceName();
    identificationType = searchBean.getIdentificationType();
    identificationNumber = searchBean.getIdentificationNum();
    resourceProgram = searchBean.getProgram();
    resourceCategory = searchBean.getCategory();
    resourceService = searchBean.getService();
    resourceLocationArea = searchBean.getLocationArea();
    resourceRegion = searchBean.getRsrcRegion();
    resourceCounty = searchBean.getNameCounty();
    resourceCity = searchBean.getNameCity();
    resourceState = searchBean.getStateName();
    resourceZip = searchBean.getZipCode();
    resourceZipSuffix = searchBean.getZipCodeSuffix();
    resourceStatus = searchBean.getResourceStatus();
    resourceFacilityType = searchBean.getFacilityType();
    //resourceLOC = searchBean.getLevelCare();
    resourceAge = searchBean.getAgeServed();
    resourceSex = searchBean.getGenderServed();
    resourceCharacteristics = searchBean.getClientCharacteristics();
    resourceContractedStatus = searchBean.getRsrcContracted();
    effectiveDate = searchBean.getEffectiveDate();
    // SIR 23622
    indDonated = searchBean.getDonatedService();
    proxRange = searchBean.getProximityRange();
    resourceAddress = searchBean.getStreetAddress();
    showRefineSearchFromPullBack = searchBean.isFullSerach();
  }
  // else get search parameters from either resource search or list page fields
  else
  {
    resourceType = FormattingHelper.formatString(ContextHelper.getStringSafe(request, "selResourceType" ));
    resourceName = FormattingHelper.formatString(ContextHelper.getStringSafe(request, "txtResourceName" ));
    identificationType = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selIdentificationType"));
    identificationNumber = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtIdentificationNumber"));
    resourceProgram = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceProgram"));
    resourceCategory = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceCategory"));
    resourceService = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceService"));
    resourceLocationArea = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"rbResourceLocationArea"));
    resourceRegion = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceRegion"));
    resourceCounty = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceCounty"));
    resourceCity = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtResourceCity"));
    resourceState = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceState"));
    resourceZip = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtResourceZip"));
    resourceZipSuffix = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtResourceZipSuffix"));
    resourceStatus = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"rbResourceStatus"));
    resourceFacilityType = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceFacilityType"));
    resourceLOC = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceLOC"));
    resourceAge = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtResourceAge"));
    resourceSex = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceSex"));
    resourceCharacteristics = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceCharacterisitcs"));
    resourceContractedStatus = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selResourceContractedStatus"));
    effectiveDate = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtEffectiveDate"));
    // SIR 23622
    indDonated = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtIndDonated"));
    proxRange = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"selProximityRange"));
    resourceAddress = FormattingHelper.formatString(ContextHelper.getStringSafe(request,"txtResourceAddress1"));
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
      // SIR# 18498. changed checkedResource to checkedResources
      document.frmResultsForm.checkedResource.value = valueString;
      //alert("Checked resource is = "+document.frmResultsForm.checkedResources.value);
      //document.frmResultsForm.validationOverride.value = 'true';
      //submitForm( "frmResultsForm", "/resource/ResourceSearch/displaySelectedList");
      //disableValidation( "frmResultsForm" );
      return true;
      //submitValidateForm( "frmResultsForm", "/resource/ResourceSearch/displaySelectedList" );
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
      //disableValidation( "frmResultsForm" );
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
function submitResourceID( resourceId )
{
  document.frmResultsForm.<%=ResourceSearchConversation.ID_KEY%>.value = resourceId;
  document.frmResultsForm.txtUlIdResource.value = resourceId;
  disableValidation( "frmResultsForm" );
  submitValidateForm( "frmResultsForm", "/resource/ResourceDetail/displayResourceDetail" );
}

//submit form to add a resource
function addResource()
{
  disableValidation( "frmResultsForm" );
  return true;
}

function setResourceId( resourceId, facilityType )
{
  document.frmResultsForm.txtUlIdResource.value = resourceId;
  document.frmResultsForm.txtFacilityType.value = facilityType;
}

function submitStage_ID(stageId)
{
  document.frmResultsForm.stageId.value = stageId;
  document.frmResultsForm.displayIntakeActionsFromResourceSearchResults.value = "<%=ArchitectureConstants.Y%>";
  document.frmResultsForm.intakeActionsPageMode.value = "<%=PageModeConstants.VIEW%>";
  submitValidateForm("frmResultsForm", "/intake/IntakeActions/displayIntakeActions");
}

function setFields(stageId, personId)

{
  document.frmResultsForm.stageId.value = stageId;
  document.frmResultsForm.personId.value = personId;
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

<impact:validateForm
  name="frmResultsForm"
  method="post"
  action="/resource/ResourceDetail/displayResourceDetail"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchListValidation"
  pageMode="<%=PageModeConstants.EDIT%>"
  schema="/WEB-INF/Constraints.xsd">
<impact:validateErrors/>

<impact:pagination
  submitUrl="/resource/ResourceSearch/results"
  addSelected="<%=addSelected%>">

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden"  name="validationOverride"/>
<!-- Capture search parameters as hidden fields -->

<input type="hidden"  name="selResourceType" value="<%=resourceType%>"/>
<input type="hidden"  name="txtResourceName" value="<%=resourceName%>"/>
<input type="hidden"  name="selIdentificationType" value="<%=identificationType%>"/>
<input type="hidden"  name="txtIdentificationNumber" value="<%=identificationNumber%>"/>
<input type="hidden"  name="selResourceProgram" value="<%=resourceProgram%>"/>
<input type="hidden"  name="selResourceCategory" value="<%=resourceCategory%>"/>
<input type="hidden"  name="selResourceService" value="<%=resourceService%>"/>
<input type="hidden"  name="rbResourceLocationArea" value="<%=resourceLocationArea%>"/>
<input type="hidden"  name="selResourceRegion" value="<%=resourceRegion%>"/>
<input type="hidden"  name="selResourceCounty" value="<%=resourceCounty%>"/>
<input type="hidden"  name="txtResourceCity" value="<%=resourceCity%>"/>
<input type="hidden"  name="selResourceState" value="<%=resourceState%>"/>
<input type="hidden"  name="txtResourceZip" value="<%=resourceZip%>"/>
<input type="hidden"  name="txtResourceZipSuffix" value="<%=resourceZipSuffix%>"/>
<input type="hidden"  name="rbResourceStatus" value="<%=resourceStatus%>"/>
<input type="hidden"  name="selResourceFacilityType" value="<%=resourceFacilityType%>"/>
<input type="hidden"  name="txtResourceAge" value="<%=resourceAge%>"/>
<input type="hidden"  name="selResourceSex" value="<%=resourceSex%>"/>
<input type="hidden"  name="selResourceCharacterisitcs" value="<%=resourceCharacteristics%>"/>
<input type="hidden"  name="selResourceContractedStatus" value="<%=resourceContractedStatus%>"/>
<input type="hidden"  name="txtEffectiveDate" value="<%=effectiveDate%>"/>
<input type="hidden"  name="txtIndDonated" value="<%=indDonated%>"/>
<input type="hidden"  name="selProximityRange" value="<%=proxRange%>"/>
<input type="hidden"  name="requestFromListPage" value="ResourceList"/>
<input type="hidden" name="destinationUrl" value="<%=returnPage%>"/>
<input type="hidden" name="stageId" value="">
<input type="hidden" name="intakeActionsPageMode" value="">
<input type="hidden" name="displayIntakeActionsFromResourceSearchResults" value="">

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
            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name</th>
            <th class="thList" width="8%">Resource ID</th>
            <th class="thList" width="5%">Status</th>
            <th class="thList" width="5%">Distance</th>
            <th class="thList" width="3%">C</th>
            <th class="thList" width="10%">Resource Type</th>
            <th class="thList" width="10%">Type</th>
            <th class="thList" width="10%">Dispstn</th>
            <th class="thList" width="10%">Report ID</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10%">City</th>
             <!-- SIR 18791 - display sortable COUNTY in search results list  -->
            <th class="thList" width="9%">County</th>
            <th class="thList" width="10%">Phone</th>
            <th class="thList" width="5%">Ext.</th>
          <%} else{%>
          <tr>
            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name<impact:sortableColumnHeader orderBy="NM_RESOURCE" isDefault="true"/></th>
            <th class="thList" width="8%">Resource ID</th>
            <th class="thList" width="5%">Status</th>
            <th class="thList" width="5%">Distance</th>
            <th class="thList" width="3%"><nobr>C<impact:sortableColumnHeader orderBy="CR.IND_RSRC_CONTRACTED" /></nobr></th>
            <impact:ifServerImpact>
            <th class="thList" width="10%"><nobr>Resource Type<impact:sortableColumnHeader orderBy="CR.CD_RSRC_TYPE" /></nobr></th>
            <th class="thList" width="10%"><nobr>Type</nobr></th>
            </impact:ifServerImpact>
            <impact:ifMobileImpact>
            <th class="thList" width="10%">Resource Type<impact:sortableColumnHeader orderBy="CR.CD_RSRC_TYPE" /></th>
            <th class="thList" width="10%">Type</th>
            </impact:ifMobileImpact>
            <th class="thList" width="10%">Dispstn</th>
            <th class="thList" width="10%">Report ID</th>
            <th class="thList" width="17%">Address</th>
           <impact:ifServerImpact>
            <th class="thList" width="10">City<impact:sortableColumnHeader orderBy="INITCAP(CR.ADDR_RSRC_CITY)" /></th>
           </impact:ifServerImpact>
           <impact:ifMobileImpact>
            <th class="thList" width="10"><nobr>City<impact:sortableColumnHeader orderBy="CR.ADDR_RSRC_CITY" /></nobr></th>
           </impact:ifMobileImpact>
            <!-- SIR 18791 - display sortable COUNTY in search results list  -->
            <th class="thList" width="9%">County<impact:sortableColumnHeader orderBy="CR.CD_RSRC_CNTY" /></th>
            <th class="thList" width="10%">Phone</th>
            <th class="thList" width="5%">Ext.</th>
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
            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name</th>
            <th class="thList" width="8%">Resource ID</th>
            <th class="thList" width="5%">Status</th>
            <th class="thList" width="5%">Distance</th>
            <th class="thList" width="3%">C</th>
            <th class="thList" width="10%">Resource Type</th>
            <th class="thList" width="10%">Type</th>
            <th class="thList" width="10%">Dispstn</th>
            <th class="thList" width="10%">Report ID</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10%">City</th>
           <!-- SIR 18791 - display sortable COUNTY in search results list  -->
        <th class="thList" width="9%">County</th>
            <th class="thList" width="10%">Phone</th>
            <th class="thList" width="5%">Ext.</th>
          <%} else{%>
          <tr>
            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name<impact:sortableColumnHeader orderBy="NM_RESOURCE" isDefault="true"/></th>
            <th class="thList" width="8%">Resource ID</th>
            <th class="thList" width="5%">Status</th>
            <th class="thList" width="5%">Distance</th>
            <th class="thList" width="3%"><nobr>C<impact:sortableColumnHeader orderBy="CR.IND_RSRC_CONTRACTED" /></nobr></th>
            <impact:ifServerImpact>
            <th class="thList" width="10%"><nobr>Resource Type<impact:sortableColumnHeader orderBy="CR.CD_RSRC_TYPE" /></nobr></th>
            <th class="thList" width="10%"><nobr>Facility Type</nobr></th>
            </impact:ifServerImpact>
            <impact:ifMobileImpact>
            <th class="thList" width="10%">Resource Type<impact:sortableColumnHeader orderBy="CR.CD_RSRC_TYPE" /></th>
            <th class="thList" width="10%">Type</th>
            </impact:ifMobileImpact>
            <th class="thList" width="10%">Dispstn</th>
            <th class="thList" width="10%">Report ID</th>
            <th class="thList" width="17%">Address</th>
           <impact:ifServerImpact>
            <th class="thList" width="10">City<impact:sortableColumnHeader orderBy="INITCAP(CR.ADDR_RSRC_CITY)" /></th>
           </impact:ifServerImpact>
           <impact:ifMobileImpact>
            <th class="thList" width="10"><nobr>City<impact:sortableColumnHeader orderBy="CR.ADDR_RSRC_CITY" /></nobr></th>
           </impact:ifMobileImpact>
            <!-- SIR 18791 - display sortable COUNTY in search results list  -->
        <th class="thList" width="9%">County<impact:sortableColumnHeader orderBy="CR.CD_RSRC_CNTY" /></th>
        <th class="thList" width="10%">Phone</th>
            <th class="thList" width="5%">Ext.</th>
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

<table width="100%" cellpading="0" cellspacing="0" border="0">
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
            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name</th>
            <th class="thList" width="8%">Resource ID</th>
            <th class="thList" width="5%">Status</th>
            <th class="thList" width="5%">Distance</th>
            <th class="thList" width="3%">C</th>
            <th class="thList" width="10%">Resource Type</th>
            <th class="thList" width="10%">Type</th>
            <th class="thList" width="10%">Dispstn</th>
            <th class="thList" width="10%">Report ID</th>
            <th class="thList" width="17%">Address</th>
            <th class="thList" width="10%">City</th>
        <!-- SIR 18791 - display sortable COUNTY in search results list  -->
         <th class="thList" width="9%">County</th>
            <th class="thList" width="10%">Phone</th>
            <th class="thList" width="5%">Ext.</th>
          <%} else{%>
          <tr>
            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->
            <th class="thList" width="10">&nbsp;</th>
            <th class="thList" width="15%">Resource Name<impact:sortableColumnHeader orderBy="NM_RESOURCE" isDefault="true"/></th>
            <th class="thList" width="8%">Resource ID</th>
            <th class="thList" width="5%">Status</th>
            <th class="thList" width="5%">Distance</th>
            <th class="thList" width="3%"><nobr>C<impact:sortableColumnHeader orderBy="CR.IND_RSRC_CONTRACTED" /></nobr></th>
            <impact:ifServerImpact>
            <th class="thList" width="10%"><nobr>Resource Type<impact:sortableColumnHeader orderBy="CR.CD_RSRC_TYPE" /></nobr></th>
            <th class="thList" width="10%"><nobr>Type</nobr></th>
            </impact:ifServerImpact>
            <impact:ifMobileImpact>
            <th class="thList" width="10%">Resource Type<impact:sortableColumnHeader orderBy="CR.CD_RSRC_TYPE" /></th>
            <th class="thList" width="10%">Type</th>
            </impact:ifMobileImpact>
            <th class="thList" width="10%">Dispstn</th>
            <th class="thList" width="10%">Report ID</th>
            <th class="thList" width="17%">Address</th>
           <impact:ifServerImpact>
            <th class="thList" width="10">City<impact:sortableColumnHeader orderBy="INITCAP(CR.ADDR_RSRC_CITY)" /></th>
           </impact:ifServerImpact>
           <impact:ifMobileImpact>
            <th class="thList" width="10"><nobr>City<impact:sortableColumnHeader orderBy="CR.ADDR_RSRC_CITY" /></nobr></th>
           </impact:ifMobileImpact>
            <!-- SIR 18791 - display sortable COUNTY in search results list  -->
        <th class="thList" width="9%">County<impact:sortableColumnHeader orderBy="CR.CD_RSRC_CNTY" /></th>
        <th class="thList" width="10%">Phone</th>
            <th class="thList" width="5%">Ext.</th>
          </tr>
          <%}%>
     <%
     for(int i=0; i<resourceArray.length; i++)
     {
       //loopCount = resourcesCount++;
       //String serializedResource = SerializationHelper.serializeObject(currentResource);
       //rowCss = FormattingHelper.getRowCss( loopCount + 1 );
       String serializedResource = SerializationHelper.serializeObject(resourceArray[i]);
       rowCss = FormattingHelper.getRowCss( i + 1 );
       ResourceSearchValueBean currentResource = (ResourceSearchValueBean)resourceArray[i];
       String identificationNum = (currentResource.getIdentificationNum() != null) ? currentResource.getIdentificationNum(): "0";
     %>
      <!--HIDDEN FIELDS: RESOURCE_ID is = <%=identificationNum %> -> (TEST FOR HAVING HIDDEN INFO VISIBLE IN SOURCE ONLY) -->
          <tr valign="top" class="<%=rowCss%>">
     <%if( ! pullBackMode ){%>
            <td><input type="checkbox" id="resource" name="cbxCheckedResource_<%=i%>" value="<%=serializedResource%>" onClick="javaScript: setResourceId('<%=currentResource.getIdentificationNum()%>', '<%=currentResource.getFacilityType()%>')" tabIndex="<%= tabIndex++ %>"> </td>
            <td><a tabIndex="<%= tabIndex++ %>" href="javascript:submitResourceID('<%=identificationNum%>')") ><%=currentResource.getResourceName()%></a></td>
     <%} else{%>
            <td><input type="radio" id="resource" name="rbResource" value="<%=i%>" onClick="javaScript: setResourceId('<%=identificationNum%>', '<%=currentResource.getFacilityType()%>')" tabIndex="<%= tabIndex++ %>"> </td>
            <td><nobr><%=currentResource.getResourceName()%></nobr></td>
     <%}%>
            <td><%=identificationNum %></td>
            <td><%=( currentResource.getResourceStatus() != null ) ? Lookup.simpleDecodeSafe( "CRSCSTAT", currentResource.getResourceStatus()) : "&nbsp;" %></td>
            <td><%=FormattingHelper.formatDouble(currentResource.getDistance())  %></td>           
            <td>
        <%if( currentResource.getRsrcContracted() != null && "Y".equals(currentResource.getRsrcContracted()) ) {%>
          <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" border="0" alt="Y">
        <%}else{%>
           &nbsp;
        <%}%>
            </td>
            <td> <%=( currentResource.getResourceType() != null ) ? Lookup.simpleDecodeSafe( "CRSCTYPE", currentResource.getResourceType()) : "&nbsp;" %></td>
            <td><%=(currentResource.getResourceType() != null && currentResource.getFacilityType()!=null ) ? Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, currentResource.getFacilityType() ) : "&nbsp;" %></td>
            <%  String txtMaltreatmentDesc = "";          
              if ((ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol03())
                 || (ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol04())
                 || (ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol05())
                 ||  CodesTables.CDISPSTN_SUB.equals(currentResource.getCdDispstn())){

                 txtMaltreatmentDesc = Lookup.simpleDecodeSafe("CDISPSTN", CodesTables.CDISPSTN_SUB);
              } else if ((ArchitectureConstants.N).equalsIgnoreCase(currentResource.getCdFamviol03())
                     || (ArchitectureConstants.N).equalsIgnoreCase(currentResource.getCdFamviol04())
                     || (ArchitectureConstants.N).equalsIgnoreCase(currentResource.getCdFamviol05())
                     ||  CodesTables.CDISPSTN_UNS.equals(currentResource.getCdDispstn())){

                txtMaltreatmentDesc = Lookup.simpleDecodeSafe("CDISPSTN", CodesTables.CDISPSTN_UNS);
             } else {
                txtMaltreatmentDesc = "";
             }
               if(APPROVED_EVENT.equals(currentResource.getCdEventStatus())
                  || currentResource.getCdEventStatus() == null 
                  || currentResource.getCdEventStatus() == "") { %>
               <td><%=txtMaltreatmentDesc%></td> 
            <% } else {%>
               <td></td>
            <% } %>
            <td>
            <%// Investigation substantiated and closed
              if (APPROVED_EVENT.equals(currentResource.getCdEventStatus()) 
                  &&((ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol03())
                      || (ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol04())
                      || (ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol05())
                      ||  CodesTables.CDISPSTN_SUB.equals(currentResource.getCdDispstn()))
                  ) {
             %>
                <a href="javascript: submitStage_ID( '<%= String.valueOf(currentResource.getUlIdStage()) %>')" onclick="setIsDirtyCalled(true)"><%=FormattingHelper.formatInt(currentResource.getUlIdStage())%></a>
             <%} else { %>
                 &nbsp;
             <%} %>
             <%--<%
             }else if ((APPROVED_EVENT.equals(currentResource.getCdEventStatus()) 
                          || currentResource.getCdEventStatus() == null)
                         &&(((ArchitectureConstants.N).equalsIgnoreCase(currentResource.getCdFamviol03())
                              || currentResource.getCdFamviol03() == null)
                             || ((ArchitectureConstants.N).equalsIgnoreCase(currentResource.getCdFamviol04())
                                  || currentResource.getCdFamviol03() ==null)
                             || ((ArchitectureConstants.N).equalsIgnoreCase(currentResource.getCdFamviol05())
                                || currentResource.getCdFamviol05() == null))
                  ) {
              %>
              <%=FormattingHelper.formatInt(currentResource.getUlIdStage())%>     
             <%}%> --%> 
            </td>           
            <td><%=(currentResource.getStreetAddress() != null) ? currentResource.getStreetAddress() : "&nbsp;"%></td>
            <td> <%=(currentResource.getNameCity() != null) ? currentResource.getNameCity() : "&nbsp;"%></td>
         <!-- SIR 18791 - display sortable COUNTY in search results list  -->
        <td> <%=(currentResource.getNameCounty() != null) ? Lookup.simpleDecodeSafe( "CCOUNT",currentResource.getNameCounty()): "&nbsp;"%></td>
            <td><nobr><%=(currentResource.getPhoneNumber() != null) ? FormattingHelper.formatPhone(currentResource.getPhoneNumber()) : "&nbsp;" %></nobr></td>
            <td><%=(currentResource.getPhoneExtension() != null) ? currentResource.getPhoneExtension(): "&nbsp;" %></td>
          </tr>
      <%}//End For
      %>
        <input type="hidden" name="<%=ResourceSearchConversation.ID_KEY%>"/>
        <input type="hidden" name="txtUlIdResource"/>
        <input type="hidden" name="txtFacilityType"/>
         <input type="hidden" name="txtNmResource"/>
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
      <impact:ButtonTag name="btnDisplayList" img="btnDisplaySelectedList" function="return submitListForm('selectList'); " form="frmResultsForm" action="/resource/ResourceSearch/displaySelectedList" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
     <%}%>
     <% if( !restrictNewSearch || showRefineSearchFromPullBack){%>
      <impact:ButtonTag name="btnRefineSearch" img="btnRefineSearch" function="return submitListForm('refineSearch'); " form="frmResultsForm" action="/resource/ResourceSearch/refineSearch" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
     <%}%>
     <% if( !restrictNewSearch ){%>
      <impact:ButtonTag name="btnNewSearch" img="btnNewSearch" function="return submitListForm('newSearch'); " form="frmResultsForm" action="/resource/ResourceSearch/" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
     <%}%>
      <impact:personalizeOnRight equalTo='<%= UserProfile.SEC_MNTN_RSRC %>'>
     <% if( !pullBackMode ){%>
      <impact:ButtonTag name="btnAdd" img="btnAdd" function="return addResource(); " form="frmResultsForm" action="/resource/ResourceDetail/newResource" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
     <%}%>
      </impact:personalizeOnRight>
      <%if( pullBackMode && numberOfResources != 0  ){%>
        <impact:ButtonTag name="btnContinue" img="btnContinue" function="return submitListForm('callingPage'); " form="frmResultsForm" action="/resource/ResourceDetail/pullBackResourceDetail" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
      <%} else{%>&nbsp;<%}%>
    </td>
  </tr>
</table>
<%
if(ArchitectureConstants.FALSE.equals(request.getAttribute("CPAError"))){
  request.removeAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME );
}
%>
</impact:validateForm>





