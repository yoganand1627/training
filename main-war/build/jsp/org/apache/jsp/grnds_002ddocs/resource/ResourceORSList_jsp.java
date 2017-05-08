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
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceORSSearchPullBackInfo;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceORSSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class ResourceORSList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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
      out.write("\");\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      document.frmResultsForm.checkedResource.value = valueString;\r\n      disableValidation( \"frmResultsForm\" );\r\n      return true;\r\n    }\r\n  }\r\n  //If 'OK' button is clicked\r\n  if( url == \"callingPage\" )\r\n  {\r\n    if( document.frmResultsForm.txtUlIdResource.value == \"\" )\r\n    {\r\n      setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("\");\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      disableValidation( \"frmResultsForm\" );\r\n      return true;\r\n    }\r\n  }\r\n  //If 'New Search button' is clicked\r\n  if( url == 'newSearch' )\r\n  {\r\n    disableValidation( \"frmResultsForm\" );\r\n    return true;\r\n  }\r\n  //If 'Refine Search' is clicked\r\n  if( url == 'refineSearch' )\r\n  {\r\n    disableValidation( \"frmResultsForm\" );\r\n    return true;\r\n  }\r\n}\r\n\r\n//function called if a Resource Name hyperlink is selected\r\nfunction submitResourceID( facilityId )\r\n{\r\n  document.frmResultsForm.");
      out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      out.write(".value = \"\";\r\n  document.frmResultsForm.");
      out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      out.write(".value = facilityId;\r\n  disableValidation( \"frmResultsForm\" );\r\n  submitValidateForm( \"frmResultsForm\", \"/resource/ResourceORSDetail/displayORSResourceDetail\" );\r\n}\r\n\r\n//function called if a Resource Name hyperlink is selected\r\nfunction setORSResourceID( facilityId )\r\n{\r\n  //clear out the value and then set it\r\n  document.frmResultsForm.");
      out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      out.write(".value = \"\";\r\n  document.frmResultsForm.");
      out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      out.write(".value = facilityId;\r\n}\r\n\r\n\r\nfunction setResourceId( facilityId )\r\n{\r\n  document.frmResultsForm.txtFacilityId.value = facilityId;\r\n}\r\n\r\n</script>\r\n<!--Start Main Content-->\r\n");

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
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceORSDetail/displayORSResourceDetail");
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
          _jspx_th_impact_pagination_0.setSubmitUrl("/resource/ResourceORSSearch/results");
          _jspx_th_impact_pagination_0.setAddSelected(addSelected);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n  <input type=\"hidden\" name=\"");
              out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
              out.write("\"/>\r\n  ");
              if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n  <!-- Capture search parameters as hidden fields -->\r\n  <input type=\"hidden\"  name=\"txtResourceName\" value=\"");
              out.print(resourceName);
              out.write("\"/>\r\n  <input type=\"hidden\"  name=\"txtFacilityId\" value=\"");
              out.print(facilityID);
              out.write("\"/>\r\n  <input type=\"hidden\"  name=\"txtLegalName\" value=\"");
              out.print(legalName);
              out.write("\"/>\r\n  <input type=\"hidden\"  name=\"txtFacilityType\" value=\"\"/>\r\n  <input type=\"hidden\"  name=\"requestFromListPage\" value=\"ResourceORSList\"/>\r\n  <input type=\"hidden\" name=\"destinationUrl\" value=\"");
              out.print(returnPage);
              out.write("\"/>\r\n  ");
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
              out.write("\r\n\r\n         ");
if( selectedList == true ){
              out.write("\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name</th>\r\n            <th class=\"thList\" width=\"8%\">ORS Facility ID</th>\r\n            <th class=\"thList\" width=\"15%\">Legal Name</th>\r\n            <th class=\"thList\" width=\"19%\">Facility Type</th>\r\n            <th class=\"thList\" width=\"3%\">ORS Operating Status</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10%\">City</th>\r\n            <th class=\"thList\" width=\"10%\">County</th>\r\n            <th class=\"thList\" width=\"9%\">Resource ID</th>\r\n            <th class=\"thList\" width=\"7\">&nbsp;</th>\r\n          ");
} else{
              out.write("\r\n          <tr>\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name");
              if (_jspx_meth_impact_sortableColumnHeader_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"8%\">Facility ID</th>\r\n            <th class=\"thList\" width=\"15%\">Legal Name");
              if (_jspx_meth_impact_sortableColumnHeader_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"19%\">Facility Type</th>\r\n            <th class=\"thList\" width=\"3%\">ORS Operating Status</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10\">City");
              if (_jspx_meth_impact_sortableColumnHeader_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"9%\">County");
              if (_jspx_meth_impact_sortableColumnHeader_3(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"9%\">Resource ID</th>\r\n          </tr>\r\n          ");
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
              if (_jspx_meth_impact_ifServerImpact_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifMobileImpact_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n         ");
if( selectedList == true ){
              out.write("\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name</th>\r\n            <th class=\"thList\" width=\"8%\">ORS Facility ID</th>\r\n            <th class=\"thList\" width=\"15%\">Legal Name</th>\r\n            <th class=\"thList\" width=\"19%\">Facility Type</th>\r\n            <th class=\"thList\" width=\"3%\">ORS Operating Status</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10%\">City</th>\r\n            <th class=\"thList\" width=\"10%\">County</th>\r\n            <th class=\"thList\" width=\"9%\">Resource ID</th>\r\n          ");
} else{
              out.write("\r\n          <tr>\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name");
              if (_jspx_meth_impact_sortableColumnHeader_4(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"8%\">Facility ID</th>\r\n            <th class=\"thList\" width=\"15%\">Legal Name");
              if (_jspx_meth_impact_sortableColumnHeader_5(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"19%\">Facility Type</th>\r\n            <th class=\"thList\" width=\"3%\">ORS Operating Status</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10\">City");
              if (_jspx_meth_impact_sortableColumnHeader_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"9%\">County");
              if (_jspx_meth_impact_sortableColumnHeader_7(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"9%\">Resource ID</th>\r\n          </tr>\r\n          ");
}
              out.write("\r\n        </table>\r\n      </div>\r\n<!--- closing div table --->\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 //If results were found and no error messages, display the results
  }
  else
  {

              out.write("\r\n\r\n<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      <div class=\"formInstruct\">Scroll for more information  --></div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <td>\r\n");
   /* SIR 23639 - Use full screen width for MPS - had to use different widths so that IMPACT remains the same */ 
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifServerImpact_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_ifMobileImpact_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n         ");
if( selectedList == true ){
              out.write("\r\n         <tr>\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name</th>\r\n            <th class=\"thList\" width=\"8%\">ORS Facility ID</th>\r\n            <th class=\"thList\" width=\"15%\">Legal Name</th>\r\n            <th class=\"thList\" width=\"19%\">Facility Type</th>\r\n            <th class=\"thList\" width=\"3%\">ORS Operating Status</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10%\">City</th>\r\n            <th class=\"thList\" width=\"10%\">County</th>\r\n            <th class=\"thList\" width=\"9%\">Resource ID</th>\r\n          </tr>  \r\n          ");
} else{
              out.write("\r\n          <tr>\r\n            <th class=\"thList\" width=\"10\">&nbsp;</th>\r\n            <th class=\"thList\" width=\"15%\">Resource Name");
              if (_jspx_meth_impact_sortableColumnHeader_8(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"8%\">Facility ID</th>\r\n            <th class=\"thList\" width=\"15%\">Legal Name");
              if (_jspx_meth_impact_sortableColumnHeader_9(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"19%\">Facility Type</th>\r\n            <th class=\"thList\" width=\"3%\">ORS Operating Status</th>\r\n            <th class=\"thList\" width=\"17%\">Address</th>\r\n            <th class=\"thList\" width=\"10\">City");
              if (_jspx_meth_impact_sortableColumnHeader_10(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"9%\">County");
              if (_jspx_meth_impact_sortableColumnHeader_11(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n            <th class=\"thList\" width=\"9%\">Resource ID</th>\r\n          </tr>\r\n          ");
}
              out.write("\r\n     ");

     for(int i=0; i<resourceArray.length; i++)
     {
       String serializedResource = SerializationHelper.serializeObject(resourceArray[i]);
       rowCss = FormattingHelper.getRowCss( i + 1 );
       ResourceORSSearchValueBean currentResource = (ResourceORSSearchValueBean)resourceArray[i];
       String facId = (currentResource.getFacilityID() != null) ? currentResource.getFacilityID(): "0";
     
              out.write("\r\n      <!--HIDDEN FIELDS: RESOURCE_ID is = ");
              out.print(facId );
              out.write(" -> (TEST FOR HAVING HIDDEN INFO VISIBLE IN SOURCE ONLY) -->\r\n          <tr valign=\"top\" class=\"");
              out.print(rowCss);
              out.write("\">\r\n     ");
if( ! pullBackMode ){
              out.write("\r\n            <td><input type=\"checkbox\" id=\"resource\" name=\"cbxCheckedResource_");
              out.print(i);
              out.write("\" value=\"");
              out.print(serializedResource);
              out.write("\" onClick=\"javaScript: setResourceId('");
              out.print(currentResource.getFacilityID());
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"> </td>\r\n            <td><a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" href=\"javascript:submitResourceID('");
              out.print(facId);
              out.write("')\") >");
              out.print(currentResource.getResourceName());
              out.write("</a></td>\r\n     ");
} else{
              out.write("\r\n            <td><input type=\"radio\" id=\"resource\" name=\"rbResource\" value=\"");
              out.print(i);
              out.write("\" onClick=\"javaScript: setORSResourceID('");
              out.print(facId);
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"> </td>\r\n            <td><nobr>");
              out.print(currentResource.getResourceName());
              out.write("</nobr></td>\r\n     ");
}
              out.write("\r\n            <td>");
              out.print(facId );
              out.write("</td>\r\n            <td>");
              out.print(( currentResource.getLegalName() != null ) ? currentResource.getLegalName() : "&nbsp;" );
              out.write("</td>\r\n            <td>");
              out.print((currentResource.getFacilityType() != null ) ? Lookup.simpleDecodeSafe("CORSOPFT", currentResource.getFacilityType() ) : "&nbsp;" );
              out.write("</td>\r\n            <td>");
              out.print(( currentResource.getOrsOperatingStatus() != null ) ? Lookup.simpleDecodeSafe("CORSOPST",currentResource.getOrsOperatingStatus()) : "&nbsp;" );
              out.write("</td>\r\n            <td>");
              out.print((currentResource.getAddress() != null) ? currentResource.getAddress() : "&nbsp;");
              out.write("</td>\r\n            <td> ");
              out.print((currentResource.getCity() != null) ? currentResource.getCity() : "&nbsp;");
              out.write("</td>\r\n            <td> ");
              out.print((currentResource.getCounty() != null) ? currentResource.getCounty() : "&nbsp;");
              out.write("</td>\r\n            <td> ");
              out.print((currentResource.getShinesResourceId() != null) ? currentResource.getShinesResourceId() : "&nbsp;");
              out.write("</td>\r\n          </tr>\r\n      ");
}//End For
      
              out.write("\r\n      <!-- <input type=\"hidden\" name=\"txtUlIdResource\"/>\r\n         <input type=\"hidden\" name=\"txtNmResource\"/> -->\r\n      <!--- SIR# 18921. checkedResource is now a hidden field... --->\r\n      <!--- SIR# 18498. uncommented the next line --->\r\n      <!--  <input type=\"hidden\" name=\"checkedResources\"/> -->\r\n        <input type=\"hidden\" name=\"");
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
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceORSSearch/displaySelectedList");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
}
          out.write("\r\n     ");
 if( !restrictNewSearch ){
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnRefineSearch");
          _jspx_th_impact_ButtonTag_1.setImg("btnRefineSearch");
          _jspx_th_impact_ButtonTag_1.setFunction("return submitListForm('refineSearch'); ");
          _jspx_th_impact_ButtonTag_1.setForm("frmResultsForm");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ResourceORSSearch/refineSearch");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnNewSearch");
          _jspx_th_impact_ButtonTag_2.setImg("btnNewSearch");
          _jspx_th_impact_ButtonTag_2.setFunction("return submitListForm('newSearch'); ");
          _jspx_th_impact_ButtonTag_2.setForm("frmResultsForm");
          _jspx_th_impact_ButtonTag_2.setAction("/resource/ResourceORSSearch/");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
}
          out.write("\r\n     ");
if( pullBackMode && numberOfResources != 0  ){
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnContinue");
          _jspx_th_impact_ButtonTag_3.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_3.setForm("frmResultsForm");
          _jspx_th_impact_ButtonTag_3.setAction("/resource/ResourceORSSearch/pullBackResource");
          _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
} else{
          out.write("&nbsp;");
}
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

  request.removeAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME );

          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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
    _jspx_th_impact_sortableColumnHeader_0.setOrderBy("NAME");
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
    _jspx_th_impact_sortableColumnHeader_1.setOrderBy("LEGALNAME");
    int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_2.setOrderBy("FAC_CITY");
    int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_3.setOrderBy("COUNTY");
    int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:330px; width:760px; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"1300\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:310px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"150%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifMobileImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_4.setOrderBy("NAME");
    _jspx_th_impact_sortableColumnHeader_4.setIsDefault("true");
    int _jspx_eval_impact_sortableColumnHeader_4 = _jspx_th_impact_sortableColumnHeader_4.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_5.setOrderBy("LEGALNAME");
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
    _jspx_th_impact_sortableColumnHeader_6.setOrderBy("FAC_CITY");
    int _jspx_eval_impact_sortableColumnHeader_6 = _jspx_th_impact_sortableColumnHeader_6.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_sortableColumnHeader_7.setOrderBy("COUNTY");
    int _jspx_eval_impact_sortableColumnHeader_7 = _jspx_th_impact_sortableColumnHeader_7.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:330px; width:760px; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"1300\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifServerImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
      out.write("\r\n      <div id=\"scrollBar2\" style=\"height:310px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"150%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");
    }
    if (_jspx_th_impact_ifMobileImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_sortableColumnHeader_8.setOrderBy("NAME");
    _jspx_th_impact_sortableColumnHeader_8.setIsDefault("true");
    int _jspx_eval_impact_sortableColumnHeader_8 = _jspx_th_impact_sortableColumnHeader_8.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_9.setOrderBy("LEGALNAME");
    int _jspx_eval_impact_sortableColumnHeader_9 = _jspx_th_impact_sortableColumnHeader_9.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_10.setOrderBy("FAC_CITY");
    int _jspx_eval_impact_sortableColumnHeader_10 = _jspx_th_impact_sortableColumnHeader_10.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_11.setOrderBy("COUNTY");
    int _jspx_eval_impact_sortableColumnHeader_11 = _jspx_th_impact_sortableColumnHeader_11.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
