package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class ResourceList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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



      out.write("\r\n\r\n<script type=\"text/JavaScript\" language=\"JavaScript1.2\">\r\n\r\n//general function to submit the search for this page.\r\nfunction submitListForm( url )\r\n{\r\n  //If 'Display Selected List' button is clicked\r\n  if( url == \"selectList\" )\r\n  {\r\n    var valueString = \"\";\r\n    var rowSelected = false;\r\n    ");

    for( int i=0; i<numberOfResources; i++ )
    {
      out.write("\r\n      if(document.frmResultsForm.cbxCheckedResource_");
      out.print(i);
      out.write(".checked == true)\r\n      {\r\n        valueString += document.frmResultsForm.cbxCheckedResource_");
      out.print(i);
      out.write(".value;\r\n        valueString += \",\";\r\n        rowSelected = true;\r\n      }\r\n    ");

    } //end for loop
    
      out.write("\r\n    if( !rowSelected )\r\n    {\r\n      setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("\");\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      // SIR# 18498. changed checkedResource to checkedResources\r\n      document.frmResultsForm.checkedResource.value = valueString;\r\n      //alert(\"Checked resource is = \"+document.frmResultsForm.checkedResources.value);\r\n      //document.frmResultsForm.validationOverride.value = 'true';\r\n      //submitForm( \"frmResultsForm\", \"/resource/ResourceSearch/displaySelectedList\");\r\n      //disableValidation( \"frmResultsForm\" );\r\n      return true;\r\n      //submitValidateForm( \"frmResultsForm\", \"/resource/ResourceSearch/displaySelectedList\" );\r\n    }\r\n  }\r\n  //If 'OK' button is clicked\r\n  if( url == \"callingPage\" )\r\n  {\r\n    if( document.frmResultsForm.txtUlIdResource.value == \"\" )\r\n    {\r\n      setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("\");\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      //disableValidation( \"frmResultsForm\" );\r\n      return true;\r\n    }\r\n  }\r\n  //If 'New Search button' is clicked\r\n  if( url == 'newSearch' )\r\n  {\r\n    disableValidation( \"frmResultsForm\" );\r\n    return true;\r\n  }\r\n  //If 'Refine Search' is clicked\r\n  if( url == 'refineSearch' )\r\n  {\r\n    disableValidation( \"frmResultsForm\" );\r\n    return true;\r\n  }\r\n}\r\n\r\n//function called if a Resource Name hyperlink is selected\r\nfunction submitResourceID( resourceId )\r\n{\r\n  document.frmResultsForm.");
      out.print(ResourceSearchConversation.ID_KEY);
      out.write(".value = resourceId;\r\n  document.frmResultsForm.txtUlIdResource.value = resourceId;\r\n  disableValidation( \"frmResultsForm\" );\r\n  submitValidateForm( \"frmResultsForm\", \"/resource/ResourceDetail/displayResourceDetail\" );\r\n}\r\n\r\n//submit form to add a resource\r\nfunction addResource()\r\n{\r\n  disableValidation( \"frmResultsForm\" );\r\n  return true;\r\n}\r\n\r\nfunction setResourceId( resourceId, facilityType )\r\n{\r\n  document.frmResultsForm.txtUlIdResource.value = resourceId;\r\n  document.frmResultsForm.txtFacilityType.value = facilityType;\r\n}\r\n\r\nfunction submitStage_ID(stageId)\r\n{\r\n  document.frmResultsForm.stageId.value = stageId;\r\n  document.frmResultsForm.displayIntakeActionsFromResourceSearchResults.value = \"");
      out.print(ArchitectureConstants.Y);
      out.write("\";\r\n  document.frmResultsForm.intakeActionsPageMode.value = \"");
      out.print(PageModeConstants.VIEW);
      out.write("\";\r\n  submitValidateForm(\"frmResultsForm\", \"/intake/IntakeActions/displayIntakeActions\");\r\n}\r\n\r\nfunction setFields(stageId, personId)\r\n\r\n{\r\n  document.frmResultsForm.stageId.value = stageId;\r\n  document.frmResultsForm.personId.value = personId;\r\n}\r\n\r\n</script>\r\n<!--Start Main Content-->\r\n");

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


      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmResultsForm");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceDetail/displayResourceDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchListValidation");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/resource/ResourceSearch/results");
          _jspx_th_impact_pagination_0.setAddSelected(addSelected);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<input type=\"hidden\" name=\"");
              out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
              out.write("\"/>\r\n");
              if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n<!-- Capture search parameters as hidden fields -->\r\n\r\n<input type=\"hidden\"  name=\"selResourceType\" value=\"");
              out.print(resourceType);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtResourceName\" value=\"");
              out.print(resourceName);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selIdentificationType\" value=\"");
              out.print(identificationType);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtIdentificationNumber\" value=\"");
              out.print(identificationNumber);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceProgram\" value=\"");
              out.print(resourceProgram);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceCategory\" value=\"");
              out.print(resourceCategory);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceService\" value=\"");
              out.print(resourceService);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"rbResourceLocationArea\" value=\"");
              out.print(resourceLocationArea);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceRegion\" value=\"");
              out.print(resourceRegion);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceCounty\" value=\"");
              out.print(resourceCounty);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtResourceCity\" value=\"");
              out.print(resourceCity);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceState\" value=\"");
              out.print(resourceState);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtResourceZip\" value=\"");
              out.print(resourceZip);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtResourceZipSuffix\" value=\"");
              out.print(resourceZipSuffix);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"rbResourceStatus\" value=\"");
              out.print(resourceStatus);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceFacilityType\" value=\"");
              out.print(resourceFacilityType);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtResourceAge\" value=\"");
              out.print(resourceAge);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceSex\" value=\"");
              out.print(resourceSex);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceCharacterisitcs\" value=\"");
              out.print(resourceCharacteristics);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selResourceContractedStatus\" value=\"");
              out.print(resourceContractedStatus);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtEffectiveDate\" value=\"");
              out.print(effectiveDate);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"txtIndDonated\" value=\"");
              out.print(indDonated);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"selProximityRange\" value=\"");
              out.print(proxRange);
              out.write("\"/>\r\n<input type=\"hidden\"  name=\"requestFromListPage\" value=\"ResourceList\"/>\r\n<input type=\"hidden\" name=\"destinationUrl\" value=\"");
              out.print(returnPage);
              out.write("\"/>\r\n<input type=\"hidden\" name=\"stageId\" value=\"\">\r\n<input type=\"hidden\" name=\"intakeActionsPageMode\" value=\"\">\r\n<input type=\"hidden\" name=\"displayIntakeActionsFromResourceSearchResults\" value=\"\">\r\n\r\n");
//if no resources were found, display error message for this.
  if ( numberOfResources == 0 && request.getAttribute( BasePrsConversation.ERROR_MESSAGES ) == null )
  {

              out.write("\r\n<table width=\"100%\" cellpading=\"0\" cellspacing=\"0\" border=\"0\">\r\n <tr><td class=\"alignRight\">\r\n<div class=\"formInstruct\">Scroll for more information  --></div>\r\n  </td>\r\n</tr>\r\n</table>\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <td>\r\n");
   /* SIR 23639 - Use full screen width for MPS - had to use different widths so that IMPACT remains the same */ 
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifServerImpact_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifMobileImpact_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n         ");
if( selectedList == true ){
              out.write("\r\n            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name</th>\r\n            <th class=\"thList\" width=\"8%\">Resource ID</th>\r\n            <th class=\"thList\" width=\"5%\">Status</th>\r\n            <th class=\"thList\" width=\"5%\">Distance</th>\r\n            <th class=\"thList\" width=\"3%\">C</th>\r\n            <th class=\"thList\" width=\"10%\">Resource Type</th>\r\n            <th class=\"thList\" width=\"10%\">Type</th>\r\n            <th class=\"thList\" width=\"10%\">Dispstn</th>\r\n            <th class=\"thList\" width=\"10%\">Report ID</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10%\">City</th>\r\n             <!-- SIR 18791 - display sortable COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"9%\">County</th>\r\n            <th class=\"thList\" width=\"10%\">Phone</th>\r\n            <th class=\"thList\" width=\"5%\">Ext.</th>\r\n");
              out.write("          ");
} else{
              out.write("\r\n          <tr>\r\n            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name");
              if (_jspx_meth_impact_sortableColumnHeader_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"8%\">Resource ID</th>\r\n            <th class=\"thList\" width=\"5%\">Status</th>\r\n            <th class=\"thList\" width=\"5%\">Distance</th>\r\n            <th class=\"thList\" width=\"3%\"><nobr>C");
              if (_jspx_meth_impact_sortableColumnHeader_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</nobr></th>\r\n            ");
              if (_jspx_meth_impact_ifServerImpact_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            ");
              if (_jspx_meth_impact_ifMobileImpact_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            <th class=\"thList\" width=\"10%\">Dispstn</th>\r\n            <th class=\"thList\" width=\"10%\">Report ID</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n           ");
              if (_jspx_meth_impact_ifServerImpact_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n           ");
              if (_jspx_meth_impact_ifMobileImpact_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            <!-- SIR 18791 - display sortable COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"9%\">County");
              if (_jspx_meth_impact_sortableColumnHeader_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"10%\">Phone</th>\r\n            <th class=\"thList\" width=\"5%\">Ext.</th>\r\n          </tr>\r\n          ");
}
              out.write("\r\n                <tr class=\"odd\">\r\n                  <td colspan=\"10\">\r\n                     ");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_INT_NO_MATCHES_FND ) );
              out.write("\r\n                  </td>\r\n                </tr>\r\n        </table>\r\n      </div>\r\n<!--- closing div table --->\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
//If an error message is being displayed along with no resources found, don't display anything
  }else if ( numberOfResources == 0 && request.getAttribute( BasePrsConversation.ERROR_MESSAGES ) != null )
  {

              out.write("\r\n<table width=\"100%\" cellpading=\"0\" cellspacing=\"0\" border=\"0\">\r\n <tr><td class=\"alignRight\">\r\n<div class=\"formInstruct\">Scroll for more information  --></div>\r\n  </td>\r\n</tr>\r\n</table>\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <td>\r\n");
   /* SIR 23639 - Use full screen width for MPS - had to use different widths so that IMPACT remains the same */ 
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifServerImpact_3(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifMobileImpact_3(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n         ");
if( selectedList == true ){
              out.write("\r\n            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name</th>\r\n            <th class=\"thList\" width=\"8%\">Resource ID</th>\r\n            <th class=\"thList\" width=\"5%\">Status</th>\r\n            <th class=\"thList\" width=\"5%\">Distance</th>\r\n            <th class=\"thList\" width=\"3%\">C</th>\r\n            <th class=\"thList\" width=\"10%\">Resource Type</th>\r\n            <th class=\"thList\" width=\"10%\">Type</th>\r\n            <th class=\"thList\" width=\"10%\">Dispstn</th>\r\n            <th class=\"thList\" width=\"10%\">Report ID</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10%\">City</th>\r\n           <!-- SIR 18791 - display sortable COUNTY in search results list  -->\r\n        <th class=\"thList\" width=\"9%\">County</th>\r\n            <th class=\"thList\" width=\"10%\">Phone</th>\r\n            <th class=\"thList\" width=\"5%\">Ext.</th>\r\n          ");
} else{
              out.write("\r\n          <tr>\r\n            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name");
              if (_jspx_meth_impact_sortableColumnHeader_7(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"8%\">Resource ID</th>\r\n            <th class=\"thList\" width=\"5%\">Status</th>\r\n            <th class=\"thList\" width=\"5%\">Distance</th>\r\n            <th class=\"thList\" width=\"3%\"><nobr>C");
              if (_jspx_meth_impact_sortableColumnHeader_8(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</nobr></th>\r\n            ");
              if (_jspx_meth_impact_ifServerImpact_4(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            ");
              if (_jspx_meth_impact_ifMobileImpact_4(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            <th class=\"thList\" width=\"10%\">Dispstn</th>\r\n            <th class=\"thList\" width=\"10%\">Report ID</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n           ");
              if (_jspx_meth_impact_ifServerImpact_5(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n           ");
              if (_jspx_meth_impact_ifMobileImpact_5(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            <!-- SIR 18791 - display sortable COUNTY in search results list  -->\r\n        <th class=\"thList\" width=\"9%\">County");
              if (_jspx_meth_impact_sortableColumnHeader_13(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n        <th class=\"thList\" width=\"10%\">Phone</th>\r\n            <th class=\"thList\" width=\"5%\">Ext.</th>\r\n          </tr>\r\n          ");
}
              out.write("\r\n        </table>\r\n      </div>\r\n<!--- closing div table --->\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 //If results were found and no error messages, display the results
  }
  else
  {

              out.write("\r\n\r\n<table width=\"100%\" cellpading=\"0\" cellspacing=\"0\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      <div class=\"formInstruct\">Scroll for more information  --></div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <td>\r\n");
   /* SIR 23639 - Use full screen width for MPS - had to use different widths so that IMPACT remains the same */ 
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifServerImpact_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifMobileImpact_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n         ");
if( selectedList == true ){
              out.write("\r\n         <tr>\r\n            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name</th>\r\n            <th class=\"thList\" width=\"8%\">Resource ID</th>\r\n            <th class=\"thList\" width=\"5%\">Status</th>\r\n            <th class=\"thList\" width=\"5%\">Distance</th>\r\n            <th class=\"thList\" width=\"3%\">C</th>\r\n            <th class=\"thList\" width=\"10%\">Resource Type</th>\r\n            <th class=\"thList\" width=\"10%\">Type</th>\r\n            <th class=\"thList\" width=\"10%\">Dispstn</th>\r\n            <th class=\"thList\" width=\"10%\">Report ID</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10%\">City</th>\r\n        <!-- SIR 18791 - display sortable COUNTY in search results list  -->\r\n         <th class=\"thList\" width=\"9%\">County</th>\r\n            <th class=\"thList\" width=\"10%\">Phone</th>\r\n            <th class=\"thList\" width=\"5%\">Ext.</th>\r\n");
              out.write("          ");
} else{
              out.write("\r\n          <tr>\r\n            <!-- SIR 18791 - display widths modified to add COUNTY in search results list  -->\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name");
              if (_jspx_meth_impact_sortableColumnHeader_14(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"8%\">Resource ID</th>\r\n            <th class=\"thList\" width=\"5%\">Status</th>\r\n            <th class=\"thList\" width=\"5%\">Distance</th>\r\n            <th class=\"thList\" width=\"3%\"><nobr>C");
              if (_jspx_meth_impact_sortableColumnHeader_15(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</nobr></th>\r\n            ");
              if (_jspx_meth_impact_ifServerImpact_7(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            ");
              if (_jspx_meth_impact_ifMobileImpact_7(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            <th class=\"thList\" width=\"10%\">Dispstn</th>\r\n            <th class=\"thList\" width=\"10%\">Report ID</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n           ");
              if (_jspx_meth_impact_ifServerImpact_8(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n           ");
              if (_jspx_meth_impact_ifMobileImpact_8(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n            <!-- SIR 18791 - display sortable COUNTY in search results list  -->\r\n        <th class=\"thList\" width=\"9%\">County");
              if (_jspx_meth_impact_sortableColumnHeader_20(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n        <th class=\"thList\" width=\"10%\">Phone</th>\r\n            <th class=\"thList\" width=\"5%\">Ext.</th>\r\n          </tr>\r\n          ");
}
              out.write("\r\n     ");

     for(int i=0; i<resourceArray.length; i++)
     {
       //loopCount = resourcesCount++;
       //String serializedResource = SerializationHelper.serializeObject(currentResource);
       //rowCss = FormattingHelper.getRowCss( loopCount + 1 );
       String serializedResource = SerializationHelper.serializeObject(resourceArray[i]);
       rowCss = FormattingHelper.getRowCss( i + 1 );
       ResourceSearchValueBean currentResource = (ResourceSearchValueBean)resourceArray[i];
       String identificationNum = (currentResource.getIdentificationNum() != null) ? currentResource.getIdentificationNum(): "0";
     
              out.write("\r\n      <!--HIDDEN FIELDS: RESOURCE_ID is = ");
              out.print(identificationNum );
              out.write(" -> (TEST FOR HAVING HIDDEN INFO VISIBLE IN SOURCE ONLY) -->\r\n          <tr valign=\"top\" class=\"");
              out.print(rowCss);
              out.write("\">\r\n     ");
if( ! pullBackMode ){
              out.write("\r\n            <td><input type=\"checkbox\" id=\"resource\" name=\"cbxCheckedResource_");
              out.print(i);
              out.write("\" value=\"");
              out.print(serializedResource);
              out.write("\" onClick=\"javaScript: setResourceId('");
              out.print(currentResource.getIdentificationNum());
              out.write("', '");
              out.print(currentResource.getFacilityType());
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"> </td>\r\n            <td><a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" href=\"javascript:submitResourceID('");
              out.print(identificationNum);
              out.write("')\") >");
              out.print(currentResource.getResourceName());
              out.write("</a></td>\r\n     ");
} else{
              out.write("\r\n            <td><input type=\"radio\" id=\"resource\" name=\"rbResource\" value=\"");
              out.print(i);
              out.write("\" onClick=\"javaScript: setResourceId('");
              out.print(identificationNum);
              out.write("', '");
              out.print(currentResource.getFacilityType());
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"> </td>\r\n            <td><nobr>");
              out.print(currentResource.getResourceName());
              out.write("</nobr></td>\r\n     ");
}
              out.write("\r\n            <td>");
              out.print(identificationNum );
              out.write("</td>\r\n            <td>");
              out.print(( currentResource.getResourceStatus() != null ) ? Lookup.simpleDecodeSafe( "CRSCSTAT", currentResource.getResourceStatus()) : "&nbsp;" );
              out.write("</td>\r\n            <td>");
              out.print(FormattingHelper.formatDouble(currentResource.getDistance())  );
              out.write("</td>           \r\n            <td>\r\n        ");
if( currentResource.getRsrcContracted() != null && "Y".equals(currentResource.getRsrcContracted()) ) {
              out.write("\r\n          <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" border=\"0\" alt=\"Y\">\r\n        ");
}else{
              out.write("\r\n           &nbsp;\r\n        ");
}
              out.write("\r\n            </td>\r\n            <td> ");
              out.print(( currentResource.getResourceType() != null ) ? Lookup.simpleDecodeSafe( "CRSCTYPE", currentResource.getResourceType()) : "&nbsp;" );
              out.write("</td>\r\n            <td>");
              out.print((currentResource.getResourceType() != null && currentResource.getFacilityType()!=null ) ? Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, currentResource.getFacilityType() ) : "&nbsp;" );
              out.write("</td>\r\n            ");
  String txtMaltreatmentDesc = "";          
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
                  || currentResource.getCdEventStatus() == "") { 
              out.write("\r\n               <td>");
              out.print(txtMaltreatmentDesc);
              out.write("</td> \r\n            ");
 } else {
              out.write("\r\n               <td></td>\r\n            ");
 } 
              out.write("\r\n            <td>\r\n            ");
// Investigation substantiated and closed
              if (APPROVED_EVENT.equals(currentResource.getCdEventStatus()) 
                  &&((ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol03())
                      || (ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol04())
                      || (ArchitectureConstants.Y).equalsIgnoreCase(currentResource.getCdFamviol05())
                      ||  CodesTables.CDISPSTN_SUB.equals(currentResource.getCdDispstn()))
                  ) {
             
              out.write("\r\n                <a href=\"javascript: submitStage_ID( '");
              out.print( String.valueOf(currentResource.getUlIdStage()) );
              out.write("')\" onclick=\"setIsDirtyCalled(true)\">");
              out.print(FormattingHelper.formatInt(currentResource.getUlIdStage()));
              out.write("</a>\r\n             ");
} else { 
              out.write("\r\n                 &nbsp;\r\n             ");
} 
              out.write("\r\n             ");
              out.write(" \r\n            </td>           \r\n            <td>");
              out.print((currentResource.getStreetAddress() != null) ? currentResource.getStreetAddress() : "&nbsp;");
              out.write("</td>\r\n            <td> ");
              out.print((currentResource.getNameCity() != null) ? currentResource.getNameCity() : "&nbsp;");
              out.write("</td>\r\n         <!-- SIR 18791 - display sortable COUNTY in search results list  -->\r\n        <td> ");
              out.print((currentResource.getNameCounty() != null) ? Lookup.simpleDecodeSafe( "CCOUNT",currentResource.getNameCounty()): "&nbsp;");
              out.write("</td>\r\n            <td><nobr>");
              out.print((currentResource.getPhoneNumber() != null) ? FormattingHelper.formatPhone(currentResource.getPhoneNumber()) : "&nbsp;" );
              out.write("</nobr></td>\r\n            <td>");
              out.print((currentResource.getPhoneExtension() != null) ? currentResource.getPhoneExtension(): "&nbsp;" );
              out.write("</td>\r\n          </tr>\r\n      ");
}//End For
      
              out.write("\r\n        <input type=\"hidden\" name=\"");
              out.print(ResourceSearchConversation.ID_KEY);
              out.write("\"/>\r\n        <input type=\"hidden\" name=\"txtUlIdResource\"/>\r\n        <input type=\"hidden\" name=\"txtFacilityType\"/>\r\n         <input type=\"hidden\" name=\"txtNmResource\"/>\r\n      <!--- SIR# 18921. checkedResource is now a hidden field... --->\r\n      <!--- SIR# 18498. uncommented the next line --->\r\n      <!--  <input type=\"hidden\" name=\"checkedResources\"/> -->\r\n        <input type=\"hidden\" name=\"");
              out.print(resultsPerPageName);
              out.write("\" value=\"");
              out.print(resultsPerPage);
              out.write("\"/>\r\n        </table>\r\n      </div>\r\n<!--- closing div table --->\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

        }//end else

              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <td align=\"right\">\r\n     ");
 if( !pullBackMode ){
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDisplayList");
          _jspx_th_impact_ButtonTag_0.setImg("btnDisplaySelectedList");
          _jspx_th_impact_ButtonTag_0.setFunction("return submitListForm('selectList'); ");
          _jspx_th_impact_ButtonTag_0.setForm("frmResultsForm");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceSearch/displaySelectedList");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
}
          out.write("\r\n     ");
 if( !restrictNewSearch || showRefineSearchFromPullBack){
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnRefineSearch");
          _jspx_th_impact_ButtonTag_1.setImg("btnRefineSearch");
          _jspx_th_impact_ButtonTag_1.setFunction("return submitListForm('refineSearch'); ");
          _jspx_th_impact_ButtonTag_1.setForm("frmResultsForm");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ResourceSearch/refineSearch");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
}
          out.write("\r\n     ");
 if( !restrictNewSearch ){
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnNewSearch");
          _jspx_th_impact_ButtonTag_2.setImg("btnNewSearch");
          _jspx_th_impact_ButtonTag_2.setFunction("return submitListForm('newSearch'); ");
          _jspx_th_impact_ButtonTag_2.setForm("frmResultsForm");
          _jspx_th_impact_ButtonTag_2.setAction("/resource/ResourceSearch/");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
}
          out.write("\r\n      ");
          //  impact:personalizeOnRight
          gov.georgia.dhr.dfcs.sacwis.web.core.personalization.PersonalizeOnRightTag _jspx_th_impact_personalizeOnRight_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.personalization.PersonalizeOnRightTag();
          _jspx_th_impact_personalizeOnRight_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_personalizeOnRight_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_personalizeOnRight_0.setEqualTo( UserProfile.SEC_MNTN_RSRC );
          int _jspx_eval_impact_personalizeOnRight_0 = _jspx_th_impact_personalizeOnRight_0.doStartTag();
          if (_jspx_eval_impact_personalizeOnRight_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n     ");
 if( !pullBackMode ){
              out.write("\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_personalizeOnRight_0);
              _jspx_th_impact_ButtonTag_3.setName("btnAdd");
              _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_3.setFunction("return addResource(); ");
              _jspx_th_impact_ButtonTag_3.setForm("frmResultsForm");
              _jspx_th_impact_ButtonTag_3.setAction("/resource/ResourceDetail/newResource");
              _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     ");
}
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_personalizeOnRight_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_personalizeOnRight_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
if( pullBackMode && numberOfResources != 0  ){
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnContinue");
          _jspx_th_impact_ButtonTag_4.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_4.setFunction("return submitListForm('callingPage'); ");
          _jspx_th_impact_ButtonTag_4.setForm("frmResultsForm");
          _jspx_th_impact_ButtonTag_4.setAction("/resource/ResourceDetail/pullBackResourceDetail");
          _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
} else{
          out.write("&nbsp;");
}
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

if(ArchitectureConstants.FALSE.equals(request.getAttribute("CPAError"))){
  request.removeAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME );
}

          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("validationOverride");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:330px; width:760px; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"1300\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:310px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"150%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_0.setOrderBy("NM_RESOURCE");
    _jspx_th_impact_sortableColumnHeader_0.setIsDefault("true");
    int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_1.setOrderBy("CR.IND_RSRC_CONTRACTED");
    int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10%\"><nobr>Resource Type");
      if (_jspx_meth_impact_sortableColumnHeader_2(_jspx_th_impact_ifServerImpact_1, _jspx_page_context))
        return true;
      out.write("</nobr></th>\r\n            <th class=\"thList\" width=\"10%\"><nobr>Type</nobr></th>\r\n            ");
    }
    if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifServerImpact_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_1);
    _jspx_th_impact_sortableColumnHeader_2.setOrderBy("CR.CD_RSRC_TYPE");
    int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_1 = _jspx_th_impact_ifMobileImpact_1.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10%\">Resource Type");
      if (_jspx_meth_impact_sortableColumnHeader_3(_jspx_th_impact_ifMobileImpact_1, _jspx_page_context))
        return true;
      out.write("</th>\r\n            <th class=\"thList\" width=\"10%\">Type</th>\r\n            ");
    }
    if (_jspx_th_impact_ifMobileImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifMobileImpact_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_1);
    _jspx_th_impact_sortableColumnHeader_3.setOrderBy("CR.CD_RSRC_TYPE");
    int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_2 = _jspx_th_impact_ifServerImpact_2.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10\">City");
      if (_jspx_meth_impact_sortableColumnHeader_4(_jspx_th_impact_ifServerImpact_2, _jspx_page_context))
        return true;
      out.write("</th>\r\n           ");
    }
    if (_jspx_th_impact_ifServerImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifServerImpact_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_2);
    _jspx_th_impact_sortableColumnHeader_4.setOrderBy("INITCAP(CR.ADDR_RSRC_CITY)");
    int _jspx_eval_impact_sortableColumnHeader_4 = _jspx_th_impact_sortableColumnHeader_4.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_2 = _jspx_th_impact_ifMobileImpact_2.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10\"><nobr>City");
      if (_jspx_meth_impact_sortableColumnHeader_5(_jspx_th_impact_ifMobileImpact_2, _jspx_page_context))
        return true;
      out.write("</nobr></th>\r\n           ");
    }
    if (_jspx_th_impact_ifMobileImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifMobileImpact_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_2);
    _jspx_th_impact_sortableColumnHeader_5.setOrderBy("CR.ADDR_RSRC_CITY");
    int _jspx_eval_impact_sortableColumnHeader_5 = _jspx_th_impact_sortableColumnHeader_5.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_6.setOrderBy("CR.CD_RSRC_CNTY");
    int _jspx_eval_impact_sortableColumnHeader_6 = _jspx_th_impact_sortableColumnHeader_6.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_3 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_3 = _jspx_th_impact_ifServerImpact_3.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:330px; width:760px; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"1300\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifServerImpact_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_3 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_3 = _jspx_th_impact_ifMobileImpact_3.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:310px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"150%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifMobileImpact_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_7.setOrderBy("NM_RESOURCE");
    _jspx_th_impact_sortableColumnHeader_7.setIsDefault("true");
    int _jspx_eval_impact_sortableColumnHeader_7 = _jspx_th_impact_sortableColumnHeader_7.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_8.setOrderBy("CR.IND_RSRC_CONTRACTED");
    int _jspx_eval_impact_sortableColumnHeader_8 = _jspx_th_impact_sortableColumnHeader_8.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_4 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_4 = _jspx_th_impact_ifServerImpact_4.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10%\"><nobr>Resource Type");
      if (_jspx_meth_impact_sortableColumnHeader_9(_jspx_th_impact_ifServerImpact_4, _jspx_page_context))
        return true;
      out.write("</nobr></th>\r\n            <th class=\"thList\" width=\"10%\"><nobr>Facility Type</nobr></th>\r\n            ");
    }
    if (_jspx_th_impact_ifServerImpact_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifServerImpact_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_4);
    _jspx_th_impact_sortableColumnHeader_9.setOrderBy("CR.CD_RSRC_TYPE");
    int _jspx_eval_impact_sortableColumnHeader_9 = _jspx_th_impact_sortableColumnHeader_9.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_4 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_4 = _jspx_th_impact_ifMobileImpact_4.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10%\">Resource Type");
      if (_jspx_meth_impact_sortableColumnHeader_10(_jspx_th_impact_ifMobileImpact_4, _jspx_page_context))
        return true;
      out.write("</th>\r\n            <th class=\"thList\" width=\"10%\">Type</th>\r\n            ");
    }
    if (_jspx_th_impact_ifMobileImpact_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifMobileImpact_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_4);
    _jspx_th_impact_sortableColumnHeader_10.setOrderBy("CR.CD_RSRC_TYPE");
    int _jspx_eval_impact_sortableColumnHeader_10 = _jspx_th_impact_sortableColumnHeader_10.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_5 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_5 = _jspx_th_impact_ifServerImpact_5.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10\">City");
      if (_jspx_meth_impact_sortableColumnHeader_11(_jspx_th_impact_ifServerImpact_5, _jspx_page_context))
        return true;
      out.write("</th>\r\n           ");
    }
    if (_jspx_th_impact_ifServerImpact_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifServerImpact_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_5);
    _jspx_th_impact_sortableColumnHeader_11.setOrderBy("INITCAP(CR.ADDR_RSRC_CITY)");
    int _jspx_eval_impact_sortableColumnHeader_11 = _jspx_th_impact_sortableColumnHeader_11.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_5 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_5 = _jspx_th_impact_ifMobileImpact_5.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10\"><nobr>City");
      if (_jspx_meth_impact_sortableColumnHeader_12(_jspx_th_impact_ifMobileImpact_5, _jspx_page_context))
        return true;
      out.write("</nobr></th>\r\n           ");
    }
    if (_jspx_th_impact_ifMobileImpact_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifMobileImpact_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_5);
    _jspx_th_impact_sortableColumnHeader_12.setOrderBy("CR.ADDR_RSRC_CITY");
    int _jspx_eval_impact_sortableColumnHeader_12 = _jspx_th_impact_sortableColumnHeader_12.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_13.setOrderBy("CR.CD_RSRC_CNTY");
    int _jspx_eval_impact_sortableColumnHeader_13 = _jspx_th_impact_sortableColumnHeader_13.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_6 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_6 = _jspx_th_impact_ifServerImpact_6.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:330px; width:760px; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"1300\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifServerImpact_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_6 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_6 = _jspx_th_impact_ifMobileImpact_6.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:310px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"150%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifMobileImpact_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_14.setOrderBy("NM_RESOURCE");
    _jspx_th_impact_sortableColumnHeader_14.setIsDefault("true");
    int _jspx_eval_impact_sortableColumnHeader_14 = _jspx_th_impact_sortableColumnHeader_14.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_15.setOrderBy("CR.IND_RSRC_CONTRACTED");
    int _jspx_eval_impact_sortableColumnHeader_15 = _jspx_th_impact_sortableColumnHeader_15.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_7 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_7 = _jspx_th_impact_ifServerImpact_7.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10%\"><nobr>Resource Type");
      if (_jspx_meth_impact_sortableColumnHeader_16(_jspx_th_impact_ifServerImpact_7, _jspx_page_context))
        return true;
      out.write("</nobr></th>\r\n            <th class=\"thList\" width=\"10%\"><nobr>Type</nobr></th>\r\n            ");
    }
    if (_jspx_th_impact_ifServerImpact_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_16(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifServerImpact_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_7);
    _jspx_th_impact_sortableColumnHeader_16.setOrderBy("CR.CD_RSRC_TYPE");
    int _jspx_eval_impact_sortableColumnHeader_16 = _jspx_th_impact_sortableColumnHeader_16.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_7 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_7 = _jspx_th_impact_ifMobileImpact_7.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10%\">Resource Type");
      if (_jspx_meth_impact_sortableColumnHeader_17(_jspx_th_impact_ifMobileImpact_7, _jspx_page_context))
        return true;
      out.write("</th>\r\n            <th class=\"thList\" width=\"10%\">Type</th>\r\n            ");
    }
    if (_jspx_th_impact_ifMobileImpact_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_17(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifMobileImpact_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_17.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_7);
    _jspx_th_impact_sortableColumnHeader_17.setOrderBy("CR.CD_RSRC_TYPE");
    int _jspx_eval_impact_sortableColumnHeader_17 = _jspx_th_impact_sortableColumnHeader_17.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_8 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifServerImpact_8 = _jspx_th_impact_ifServerImpact_8.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10\">City");
      if (_jspx_meth_impact_sortableColumnHeader_18(_jspx_th_impact_ifServerImpact_8, _jspx_page_context))
        return true;
      out.write("</th>\r\n           ");
    }
    if (_jspx_th_impact_ifServerImpact_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_18(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifServerImpact_8, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_8);
    _jspx_th_impact_sortableColumnHeader_18.setOrderBy("INITCAP(CR.ADDR_RSRC_CITY)");
    int _jspx_eval_impact_sortableColumnHeader_18 = _jspx_th_impact_sortableColumnHeader_18.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_8 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_8 = _jspx_th_impact_ifMobileImpact_8.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n            <th class=\"thList\" width=\"10\"><nobr>City");
      if (_jspx_meth_impact_sortableColumnHeader_19(_jspx_th_impact_ifMobileImpact_8, _jspx_page_context))
        return true;
      out.write("</nobr></th>\r\n           ");
    }
    if (_jspx_th_impact_ifMobileImpact_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_19(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifMobileImpact_8, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_8);
    _jspx_th_impact_sortableColumnHeader_19.setOrderBy("CR.ADDR_RSRC_CITY");
    int _jspx_eval_impact_sortableColumnHeader_19 = _jspx_th_impact_sortableColumnHeader_19.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_20(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_20.setOrderBy("CR.CD_RSRC_CNTY");
    int _jspx_eval_impact_sortableColumnHeader_20 = _jspx_th_impact_sortableColumnHeader_20.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
