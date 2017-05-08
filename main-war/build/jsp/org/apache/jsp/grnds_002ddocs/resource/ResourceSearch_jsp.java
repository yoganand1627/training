package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashSet;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

public final class ResourceSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/*
 * JSP Name:     ResourceSearch.jsp
 * Created by:   ranas
 * Date Created: 07/26/02
 *
 * Description:
 * This page allows a user to search for resources in the Database by searching on
 * a Type, Name, Identification Number or Service.  The user can also narrow the
 * search criteria by Location/Area Served, Resource Status, Facility Type, Level
 * of care, or Client Characteristics.
 *
 *
 *  Change History:
 *  Date      User              Description
 *  --------  ----------------  --------------------------------------------------
 *  07/01/05  piazzat           Changes to support MPS
 *  08/02/05  reedlg            SIR 23741 - Adding new category of service.
 *  08/03/05  cooganpj          SIR 23845 - Added attribute to UserRegionSelect tag
 *                              to automatically redisplay region for refined searches
 *                              in MPS.
 *  09/16/05  berkime           SIR 23890 - changed the wording from level of care to
 *                              service level.
 *  10/06/05  piazzat           SIR 24009 and SIR 24011
 *  10/12/05  piazzat           SIR 24033
 *  10/19/05  piazzat           SIR 24066 - region is lost when an error occurs
 *  10/20/05  piazzat           added code to populate counties when page loads
 *  10/21/05  piazzat           SIR 24074 - disable active/inactive radio buttons 
 *                              for MPS only
 *  04/16/07  aodutayo		Removed references to CFACTYP5. Based on my understanding it
 *				will no longer be used. As such any selection on the resource
 *				type will only load values for CFACTYP4. In the past, selections
 *				of type MHMR and Other Facility loads CFACTYP5.
 *  12/30/2009  mchillman       Change to support performing full search from SerAuth page for Ado 510 - 512 service codes
 *  04/11/2012  vcollooru 		STGAP00018067: Modified to remove the codeArray tag referring to regions 16 and 17
 */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  ResourceSearchValueBean bean = new ResourceSearchValueBean();
  String rsrcType = "";
  String rsrcName = "";
  String categoryValue = "";
  String serviceValue = "";
  String programValue = "";
  String idType = "";
  String idNum = "";
  String resContracted = "";
  String facType = "";
  String lvlCare = "";
  String region = "";
  String county = "";
  String address = "";
  String city = "";
  String zip = "";
  String zipSuff = "";
  String resState = "GA";
  String gender = "";
  String age = "";
  String character = "";
  //String activeBoolean = "true";
  //String inActiveBoolean = "false";
  String locationBoolean = "true";
  String areaBoolean = "false";
  String errorMessage = "";
  String destinationUrl = "";
  String camefrom = "nowhere";
  String progcamefrom = "nowhere";
  String proximityRange= "30";
  String resourceStatus="01";
  String avalibleAfterHours="";
  String effectiveDate = "";
  boolean showServiceEffectiveDate = false;
  
  int tabIndex = 1;

  Set typeExclusionSet = (HashSet) request.getAttribute( "rsrcTypeExclusions");
  if ( typeExclusionSet == null )
  {
    typeExclusionSet = new HashSet();
  }

  Set progExclusionSet = (HashSet) request.getAttribute( "rsrcProgExclusions");
  if ( progExclusionSet == null )
  {
    progExclusionSet = new HashSet();
  }

  Set idExclusionSet = (HashSet) request.getAttribute( "rsrcIdExclusions");
  if ( idExclusionSet == null )
  {
    idExclusionSet = new HashSet();
  }

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  state.removeAttribute( ResourceDetailConversation.CRES03SO_ATTRIBUTE_NAME, request );
  state.removeAttribute( "CRES04SI_ResourceDetail", request );
  state.removeAttribute( "CCON15S_resourceDetail", request );
  if( state.getAttribute( "checkedResources", request) != null )
  {
    state.removeAttribute( "checkedResources", request );
  }
  //Check the users region
  UserProfile userProfile = UserProfileHelper.getUserProfile( request );
  if( userProfile.getUserRegion() != null && !"".equals(userProfile.getUserRegion()) )
  {
    region = FormattingHelper.convertRegionCode( userProfile.getUserRegion() );
  }
  //Determine if an error message has been set for this page
  if( request.getAttribute( "errorMessage" ) != null )
  {
    errorMessage = (String)request.getAttribute( "errorMessage" );
    request.removeAttribute( "errorMessage" );//SR-
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

  if( request.getParameter("requestFromListPage") == null && request.getAttribute("requestFromServiceAutPage") == null)
  {
    if(request.getParameter("selResourceType")!=null){rsrcType = request.getParameter("selResourceType");}
    if(request.getParameter("txtResourceName")!=null){ rsrcName = request.getParameter("txtResourceName");}
    if(request.getParameter("selResourceCategory")!=null){ categoryValue = request.getParameter("selResourceCategory");}
    if(request.getParameter("selResourceProgram")!=null){ programValue = request.getParameter("selResourceProgram"); progcamefrom="request";}
    if(request.getParameter("selIdentificationType")!=null){ idType = request.getParameter("selIdentificationType");}
    if(request.getParameter("txtIdentificationNumber")!=null){ idNum = request.getParameter("txtIdentificationNumber");}
    if(request.getParameter("selResourceFacilityType")!=null){ facType = request.getParameter("selResourceFacilityType");}
    //if(request.getParameter("selResourceLOC")!=null){ lvlCare = request.getParameter("selResourceLOC");}
    if(request.getParameter("txtResourceAddress1")!=null){ address =request.getParameter("txtResourceAddress1");}
    if(request.getParameter("selResourceRegion")!=null){ region =request.getParameter("selResourceRegion");}
    if(request.getParameter("txtResourceCity")!=null){ city = request.getParameter("txtResourceCity");}
    if(request.getParameter("txtResourceZip")!=null){ zip = request.getParameter("txtResourceZip");}
    if(request.getParameter("txtResourceZipSuffix")!=null){ zipSuff = request.getParameter("txtResourceZipSuffix");}
    if(request.getParameter("selResourceState")!=null){ resState = request.getParameter("selResourceState");}
    if(request.getParameter("selResourceSex")!=null){ gender = request.getParameter("selResourceSex");}
    if(request.getParameter("txtResourceAge")!=null){ age = request.getParameter("txtResourceAge");}
    if(request.getParameter("selResourceCharacterisitcs")!=null){ character = request.getParameter("selResourceCharacterisitcs");}
    if(request.getParameter("selResourceContractedStatus")!=null){resContracted = request.getParameter("selResourceContractedStatus");}
    if(request.getParameter("selResourceFacilityType")!=null){facType = request.getParameter("selResourceFacilityType");}
    //if(request.getParameter("selResourceLOC")!=null){lvlCare = request.getParameter("selResourceLOC");}
    if(request.getParameter("selResourceCounty")!=null){county = request.getParameter("selResourceCounty");}
    if(request.getParameter("selResourceStatus")!=null) {resourceStatus=request.getParameter("selResourceStatus");}
    if(request.getParameter("rbResourceLocationArea")!=null && "area".equals(request.getParameter(
            "rbResourceLocationArea"))){locationBoolean = "false";areaBoolean="true";}
    if(request.getParameter("destinationUrl")!=null ){ destinationUrl = request.getParameter("destinationUrl"); }
    if(request.getParameter("selResourceService")!=null ){ serviceValue = request.getParameter("selResourceService"); camefrom = "request";}
    if(request.getParameter("selProximityRange")!=null ){ serviceValue = request.getParameter("selProximityRange");}
    
    
  }
  //Get all search parameters eneterd previously on page for refining search
  else if( request.getAttribute( "searchBean" ) != null )
  {
    bean = (ResourceSearchValueBean)request.getAttribute( "searchBean" );
    if(bean.getResourceType()!=null){rsrcType = bean.getResourceType();}
    if(bean.getResourceName()!=null){rsrcName = bean.getResourceName();}
    if(bean.getCategory()!=null){categoryValue = bean.getCategory();}
    if(bean.getService()!=null){serviceValue = bean.getService();     camefrom = "bean";}
    if(bean.getProgram()!=null){programValue = bean.getProgram(); progcamefrom="bean";}
    if(bean.getIdentificationType()!=null){idType = bean.getIdentificationType();}
    if(bean.getIdentificationNum()!=null){idNum = bean.getIdentificationNum();}
    if(bean.getRsrcContracted()!=null){resContracted = bean.getRsrcContracted();}
    if(bean.getFacilityType()!=null){facType = bean.getFacilityType();}
    if(bean.getLevelCare()!=null){lvlCare = bean.getLevelCare();}
    if(bean.getRsrcRegion()!=null){region = bean.getRsrcRegion();}
    if(bean.getNameCounty()!=null){county = bean.getNameCounty();}
    if(bean.getStreetAddress()!=null){address = bean.getStreetAddress();}
    if(bean.getNameCity()!=null){city = bean.getNameCity();}
    if(bean.getZipCode()!=null){zip = bean.getZipCode();}
    if(bean.getZipCodeSuffix()!=null){zipSuff = bean.getZipCodeSuffix();}
    if(bean.getStateName()!=null){resState = bean.getStateName();}
    if(bean.getGenderServed()!=null){gender = bean.getGenderServed();}
    if(bean.getAgeServed()!=null){age = bean.getAgeServed();}
    if(bean.getClientCharacteristics()!=null){character = bean.getClientCharacteristics();}
    if(bean.getResourceStatus()!=null  ){resourceStatus = bean.getResourceStatus();}     

    if(bean.getLocationArea()!=null && "area".equals(bean.getLocationArea()))
    {
      locationBoolean = "false";
      areaBoolean="true";
    }

    if(request.getParameter("destinationUrl")!=null )
    {
       destinationUrl = request.getParameter("destinationUrl");
    }
    
    if (request.getAttribute("requestFromServiceAutPage") != null) 
    {
    	ResourceSearchPullBackInfo resourceSearchPullBackInfo = (ResourceSearchPullBackInfo) bean;
    	showServiceEffectiveDate = resourceSearchPullBackInfo.isFullSerach();
    	effectiveDate = resourceSearchPullBackInfo.getEffectiveDate();
    }
  }
  Comparator<CodeAttributes> sortDecode = new Comparator<CodeAttributes>(){
    public int compare(CodeAttributes c1, CodeAttributes c2) {
      return c1.getDecode().compareTo(c2.getDecode());
    }
  };
  List<CodeAttributes> characteristicsOptions = Lookup.getCategoryCollection(CodesTables.CLNCHAR2);
  Collections.sort(characteristicsOptions, sortDecode);

  // if we just came from the placement page
  if ("/subcare/Placement/setResource".equals(destinationUrl))
  {
    rsrcType = "06";  // set resource type to "Other"
  }

  String personId = String.valueOf( userProfile.getUserID() );

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n//Get level of care code/decode array\r\n    ");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n//Get faciltiy type code/decode array for Resource Type of MHMR\r\n    ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\n//Get contract status code/decode array\r\n    ");
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write("\r\n//Get county code/decode array with all data\r\n    ");
      if (_jspx_meth_impact_codeArray_3(_jspx_page_context))
        return;
      out.write("\r\n//Get county code/decode array filtered for regions\r\n    ");
      if (_jspx_meth_impact_codeArray_4(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_5(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_6(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_7(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_8(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_9(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_10(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_11(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_12(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_13(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_14(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_15(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_16(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_17(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_18(_jspx_page_context))
        return;
      out.write("\r\n//Get service code/decode array\r\n    ");
      if (_jspx_meth_impact_codeArray_19(_jspx_page_context))
        return;
      out.write("\r\n//Get service code/decode array filtered based on category\r\n    ");
      if (_jspx_meth_impact_codeArray_20(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_21(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_22(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_23(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_24(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_25(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_26(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_27(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_28(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_29(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_30(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_31(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_32(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_33(_jspx_page_context))
        return;
      out.write("\r\n    ");
      if (_jspx_meth_impact_codeArray_34(_jspx_page_context))
        return;
      out.write("\r\n\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction()\r\n{\r\n  /** If an error message is recived that is not from the validation framework make sure\r\n   *  on the second submit the form is submitted for validation */\r\n\r\n  ");
if( !"".equals(errorMessage) )
    {
      out.write("\r\n      document.frmResourceSearch.action = \"/resource/ResourceSearch/default\";\r\n  ");
}
      out.write("\r\n\r\n  ");
 if( StringHelper.isTrue(locationBoolean) && PlatformConstants.SERVER_IMPACT )
     {
      out.write("\r\n    // SIR 19264 - disabling the dropdown would not allow the user to submit the\r\n    // form by hitting enter, but clearing and populating it works just fine.\r\n    clearDropdown( \"selResourceRegion\" );\r\n    //document.frmResourceSearch.selResourceRegion.disabled = true;\r\n   ");
}
      out.write("\r\n\r\n  //checks to see if the Resource Type is MHMR Facility\r\n  if(document.frmResourceSearch.selResourceType.options.value != null)\r\n  {\r\n    populateDropdown(\"selResourceFacilityType\", \"");
      out.print(facType);
      out.write("\", facilitytype4);\r\n  }\r\n\r\n  // Commenting this out for now. RBWO (a.k.a LOC) is likely going to come back\r\n  //if(document.frmResourceSearch.selResourceFacilityType.options.value != '' &&\r\n  //   document.frmResourceSearch.selResourceType.options.value == '06' )\r\n  //{\r\n  //  populateDropdown(\"selResourceLOC\", \"");
      out.print(lvlCare);
      out.write("\", levelCareArray);\r\n  //}\r\n\r\n  if(document.frmResourceSearch.selResourceCategory.options.value == \"\")\r\n  {\r\n    if (\"");
      out.print( serviceValue );
      out.write("\" != \"\")\r\n    {\r\n      populateDropdown(\"selResourceService\", \"");
      out.print(serviceValue);
      out.write("\", facService);\r\n    }\r\n  }\r\n  else\r\n  {\r\n    populateDropdown(\"selResourceService\", \"");
      out.print(serviceValue);
      out.write("\",\r\n    eval(\"facService\"+document.frmResourceSearch.selResourceCategory.options.value));\r\n  }\r\n\r\n  // this will force clear the region dropdown if needed\r\n  var regMode = ");
      out.print(areaBoolean);
      out.write(";\r\n\r\n  if ( regMode )\r\n  {\r\n    setRegionMode( 'enable' );\r\n  }\r\n  else\r\n  {\r\n    setRegionMode( 'disable' );\r\n  }\r\n\r\n  setFocus();\r\n\r\n");
      if (_jspx_meth_impact_ifMobileImpact_0(_jspx_page_context))
        return;
      out.write("\r\n}\r\n\r\n /*\r\n*This function populates drop down boxes with options.\r\n* param field: Name of drop down box to be populated\r\n* param val: Value of last selected option on dropdown box\r\n* param cat: Array containing the values to populate drop down options\r\n  */\r\nfunction populateDropdown(field, val, cat)\r\n{\r\n  //sets the drop-down box to the length of the array\r\n  eval(\"document.frmResourceSearch.\"+field+\".options.length =cat.length\");\r\n  for (var q=0; q < cat.length; q++)\r\n  {\r\n    //populates the drop-down box with the values from the CodeDecodeCache\r\n    eval(\"document.frmResourceSearch.\"+field+\".options[q].value = cat[q].substring(0,cat[q].indexOf(\\\"|\\\"))\");\r\n    eval(\"document.frmResourceSearch.\"+field+\".options[q].text = cat[q].substring(cat[q].indexOf(\\\"|\\\")+1,cat[q].length)\");\r\n  }\r\n  eval(\"document.frmResourceSearch.\"+field+\".value =\\\"\"+val+\"\\\"\");\r\n}\r\n\r\n /*\r\n*This function clears drop down boxes of all options.\r\n*@ param field: Name of drop down box to be cleard of all options\r\n  */\r\nfunction clearDropdown(field)\r\n");
      out.write("{\r\n  //sets the values of all options to blank, and changes the number of options to 1\r\n  var fieldLength = eval(\"document.frmResourceSearch.\"+field+\".options.length\");\r\n  for (var b=0; b < fieldLength; b++)\r\n  {\r\n    //empties the facility type drop-down box\r\n    eval(\"document.frmResourceSearch.\"+field+\".options[b].value = \\\"\\\";\");\r\n    eval(\"document.frmResourceSearch.\"+field+\".options[b].text = \\\"\\\";\");\r\n  }\r\n\r\n  eval(\"document.frmResourceSearch.\"+field+\".options.length = 1\");\r\n}\r\n\r\nfunction populateFacilityType()\r\n{\r\n  //checks to see if the Resource Type is MHMR Facility\r\n  if(document.frmResourceSearch.selResourceType.options.value != null)\r\n  {\r\n    populateDropdown(\"selResourceFacilityType\", \"\", facilitytype4);\r\n  }\r\n  //for facilities other than MHMR Facility and Other Facility\r\n  else\r\n  {\r\n    clearDropdown(\"selResourceFacilityType\");\r\n  }\r\n//  populateLOC();\r\n}\r\n\r\nfunction warnFacTypeMessage(){\r\n\tif(document.frmResourceSearch.selResourceType.options.value == 06){\r\n\t\t//alert('document.frmResourceSearch.selResourceType.options.value='+document.frmResourceSearch.selResourceType.options.value)\r\n");
      out.write("\t\talert('When Searching by Home/Other Facility, use the advanced search '+\r\n\t\t'section to select a type of home or facility.');\r\n\t}\r\n}\r\n\r\n//populate the Level of Care select box\r\n//function populateLOC()\r\n//{\r\n  //clear Level Of Care drop down if Resource Type is not Other Facility and if a Facility Type is not selected\r\n//  if(document.frmResourceSearch.selResourceFacilityType.options.value == '' || document.frmResourceSearch.selResourceType.options.value != '06')\r\n//  {\r\n//    clearDropdown(\"selResourceLOC\");\r\n//  }\r\n  // if Resource type is Other Facility and a Facility Type is selected then populate Level Of Care\r\n//  else if(document.frmResourceSearch.selResourceFacilityType.options.value != '' && document.frmResourceSearch.selResourceType.options.value == '06' )\r\n//  {\r\n//    populateDropdown(\"selResourceLOC\", \"\", levelCareArray);\r\n//  }\r\n//}\r\n\r\n//Populate the Services select box\r\nfunction populateResourceService()\r\n{\r\n  //clear Service drop down if a Category is not selected\r\n  if(document.frmResourceSearch.selResourceCategory.options.value == \"\")\r\n");
      out.write("  {\r\n    populateDropdown(\"selResourceService\", \"\", facService);\r\n  }\r\n  else\r\n  {\r\n    populateDropdown(\"selResourceService\", \"\", eval(\"facService\"+document.frmResourceSearch.selResourceCategory.options.value));\r\n  }\r\n}\r\n\r\n//Populate the Counties select box\r\nfunction populateCounties()\r\n{\r\n  if(document.frmResourceSearch.selResourceRegion.options.value == \"00\" || document.frmResourceSearch.selResourceRegion.options.value == \"98\" || document.frmResourceSearch.selResourceRegion.options.value == \"99\")\r\n  {\r\n    clearDropdown(\"selResourceCounty\");\r\n  }\r\n  else\r\n  {\r\n    populateDropdown(\"selResourceCounty\", \"\", eval(\"facCounty\"+document.frmResourceSearch.selResourceRegion.options.value));\r\n  }\r\n}\r\n\r\n//set the initial focus of the page\r\nfunction setFocus()\r\n{\r\n  document.frmResourceSearch.selResourceType.focus();\r\n}\r\n\r\n// SIR 19264 - set array of regions\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_35.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_35.setParent(null);
      _jspx_th_impact_codeArray_35.setCodeName( CodesTables.CREGIONS );
      _jspx_th_impact_codeArray_35.setArrayName("CSVCRGNS_Array");
      _jspx_th_impact_codeArray_35.setBlankValue("true");
      int _jspx_eval_impact_codeArray_35 = _jspx_th_impact_codeArray_35.doStartTag();
      if (_jspx_th_impact_codeArray_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n//set the region to enabled or disabled\r\nfunction setRegionMode( mode )\r\n{\r\n");
      //  impact:ifServerImpact
      gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
      _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifServerImpact_0.setParent(null);
      int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
      if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n  if( mode == 'disable' )\r\n  {\r\n    // SIR 19264 - disabling the dropdown would not allow the user to submit the\r\n    // form by hitting enter, but clearing and populating it works just fine.\r\n    clearDropdown( \"selResourceRegion\" );\r\n    //document.frmResourceSearch.selResourceRegion.disabled = true;\r\n  }\r\n  else if( mode == 'enable' )\r\n  {\r\n    // populate dropdown pass array with codestable\r\n    // SIR 19264 - disabling the dropdown would not allow the user to submit the\r\n    // form by hitting enter, but clearing and populating it works just fine.\r\n    populateDropdown( \"selResourceRegion\", \"");
        out.print( region );
        out.write("\", CSVCRGNS_Array );\r\n    // document.frmResourceSearch.selResourceRegion.disabled = false;\r\n  }\r\n");
      }
      if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n}\r\n\r\n//Clear the values for the fields in the Advanced Search section of the page\r\nfunction clearAdvancedFields()\r\n{\r\n  var x = document.frmResourceSearch;\r\n  x.rbResourceStatus[0].checked = true;\r\n//Contract Status\r\n  x.selResourceContractedStatus.value = '';\r\n  x.selResourceFacilityType.value = '';\r\n  //RBWO is likely going to be delayed\r\n  //commenting this section cos\r\n  //of an error possibility\r\n  x.txtResourceAge.value = '';\r\n  x.selResourceSex.value = '';\r\n  x.selResourceCharacterisitcs.value = '';\r\n}\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmResourceSearch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceSearch/results");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchValidation");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n     <tr>\r\n      <th colspan=\"4\">Resource Details\r\n      </th>\r\n     </tr>\r\n     <tr>\r\n      <td colspan=\"4\" class=\"formInstruct\">When conducting a resource search, one of the following must be entered:  Resource Type, Resource Name, Identification Number, or Service.</td>\r\n     </tr>\r\n     <tr>\r\n      <td width=\"20%\">\r\n             ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setValue(rsrcType);
          _jspx_th_impact_validateSelect_0.setName("selResourceType");
          _jspx_th_impact_validateSelect_0.setCodesTable("CRSCTYPE");
          _jspx_th_impact_validateSelect_0.setLabel("Resource Type");
          _jspx_th_impact_validateSelect_0.setExcludeOptions(typeExclusionSet);
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setOnChange("populateFacilityType();warnFacTypeMessage();");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n      <td width=\"20%\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setValue(rsrcName);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName("txtResourceName");
          _jspx_th_impact_validateInput_0.setLabel("Resource Name");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setSize("15");
          _jspx_th_impact_validateInput_0.setMaxLength("30");
          _jspx_th_impact_validateInput_0.setConstraint("Paragraph");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n     <tr>\r\n      <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setValue(idType);
          _jspx_th_impact_validateSelect_1.setName("selIdentificationType");
          _jspx_th_impact_validateSelect_1.setLabel("Identification Number");
          _jspx_th_impact_validateSelect_1.setExcludeOptions(idExclusionSet);
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setCodesTable("CRSIDTYP");
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setValue(idNum);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setName("txtIdentificationNumber");
          _jspx_th_impact_validateInput_1.setConstraint("Digit16Less");
          _jspx_th_impact_validateInput_1.setMaxLength("16");
          _jspx_th_impact_validateInput_1.setSize("16");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n         ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setValue(programValue);
          _jspx_th_impact_validateSelect_2.setName("selResourceProgram");
          _jspx_th_impact_validateSelect_2.setCodesTable("CRSCPROG");
          _jspx_th_impact_validateSelect_2.setLabel("Program");
          _jspx_th_impact_validateSelect_2.setExcludeOptions(progExclusionSet);
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setDisabled("true");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n     </tr>\r\n     ");
 if (showServiceEffectiveDate == true) {
          out.write("\r\n     <tr>\r\n       <td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspServiceCode");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Service Code");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(serviceValue));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t   </td>\r\n       <td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspEffectiveDate");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Effective Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatString(effectiveDate));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t   </td>\r\n      </tr>\r\n     ");
 } else { 
          out.write("\r\n     <tr>\r\n       <td>\r\n         ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setValue(categoryValue);
          _jspx_th_impact_validateSelect_3.setName("selResourceCategory");
          _jspx_th_impact_validateSelect_3.setCodesTable("CATOFSVC");
          _jspx_th_impact_validateSelect_3.setLabel("Category");
          _jspx_th_impact_validateSelect_3.setOnChange("populateResourceService()");
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n       <td>\r\n         ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setValue(serviceValue);
          _jspx_th_impact_validateSelect_4.setName("selResourceService");
          _jspx_th_impact_validateSelect_4.setStyle("WIDTH: 200px");
          _jspx_th_impact_validateSelect_4.setBlankValue("true");
          _jspx_th_impact_validateSelect_4.setOrderBy("decode");
          _jspx_th_impact_validateSelect_4.setContentType( SelectTag.CODES_DECODES);
          _jspx_th_impact_validateSelect_4.setCodesTable("CGLSVCCD");
          _jspx_th_impact_validateSelect_4.setLabel("Service");
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n      </tr>\r\n      ");
 }
          out.write("\r\n    </table>\r\n\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n        <tr>\r\n         <th colspan=\"4\">\r\n           <label id=\"label_Location/Area_Served\" for=\"Location/Area_Served\">Location/Area Served</label>\r\n         </th>\r\n       </tr>\r\n      ");

        String disabledButtons = "false";
        if( PlatformConstants.MOBILE_IMPACT )
        {
          if( ResourceHelper.userHasApsWorkloadCases() && !ResourceHelper.userHasAfcWorkloadCases() )
          {
            // employee has APS cases only 
            disabledButtons = "true";
            areaBoolean = "true";
          }
          else if( !ResourceHelper.userHasApsWorkloadCases() && ResourceHelper.userHasAfcWorkloadCases() )
          {
            // employee has AFC cases only 
            disabledButtons = "true";
            locationBoolean = "true";
          }
          else
          {
            // employee has both APS and AFC cases
            locationBoolean = "true";
          }
        }
      
          out.write("\r\n       <tr>\r\n         <td class=\"formLabel\" colspan=\"2\" width=\"20%\"><nbsp>\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setName("rbResourceLocationArea");
          _jspx_th_impact_validateInput_2.setValue("lctn");
          _jspx_th_impact_validateInput_2.setDisabled(disabledButtons);
          _jspx_th_impact_validateInput_2.setOnChange("populateCounties()");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setChecked( String.valueOf( locationBoolean ) );
          _jspx_th_impact_validateInput_2.setOnClick("setRegionMode('disable');");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Location\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName("rbResourceLocationArea");
          _jspx_th_impact_validateInput_3.setValue("area");
          _jspx_th_impact_validateInput_3.setDisabled(disabledButtons);
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setChecked( String.valueOf( areaBoolean ) );
          _jspx_th_impact_validateInput_3.setOnClick("setRegionMode('enable');");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Area Served\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setName("rbResourceLocationArea");
          _jspx_th_impact_validateInput_4.setValue("prox");
          _jspx_th_impact_validateInput_4.setDisabled(disabledButtons);
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setChecked( String.valueOf( areaBoolean ) );
          _jspx_th_impact_validateInput_4.setOnClick("setRegionMode('disable');");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Proximity\r\n         </td>\r\n         <td >\r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setValue(proximityRange);
          _jspx_th_impact_validateSelect_5.setName("selProximityRange");
          _jspx_th_impact_validateSelect_5.setStyle("WIDTH: 50px");
          _jspx_th_impact_validateSelect_5.setBlankValue("true");
          _jspx_th_impact_validateSelect_5.setCodesTable("CPROXRNG");
          _jspx_th_impact_validateSelect_5.setLabel("Proximity Range(miles)");
          _jspx_th_impact_validateSelect_5.setConditionallyRequired("true");
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         </td>         \r\n     </tr>        \r\n     <tr>\r\n      <td width=\"20%\">\r\n        ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n         ");
            //  impact:validateSelect
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
            _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
            _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_1);
            _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
            _jspx_th_impact_validateSelect_6.setValue( region );
            _jspx_th_impact_validateSelect_6.setName("selResourceRegion");
            _jspx_th_impact_validateSelect_6.setCodesTable("CREGIONS");
            _jspx_th_impact_validateSelect_6.setLabel("Region");
            _jspx_th_impact_validateSelect_6.setOnChange("populateCounties()");
            _jspx_th_impact_validateSelect_6.setStyle("WIDTH: 120px");
            _jspx_th_impact_validateSelect_6.setBlankValue("true");
            int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
            if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n        ");
          }
          if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:ifMobileImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
          _jspx_th_impact_ifMobileImpact_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifMobileImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifMobileImpact_1 = _jspx_th_impact_ifMobileImpact_1.doStartTag();
          if (_jspx_eval_impact_ifMobileImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n          <label name=\"label_selResourceRegion\" id=\"label_selResourceRegion_Id\" for=\"selResourceRegion_Id\" class=\"formLabel\" value=\"Region\">Region:</label>\r\n          </td>\r\n          <td width=\"30%\">\r\n          ");
            //  impact:userRegionSelect
            gov.georgia.dhr.dfcs.sacwis.core.utility.UserRegionSelect _jspx_th_impact_userRegionSelect_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.UserRegionSelect();
            _jspx_th_impact_userRegionSelect_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_userRegionSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_1);
            _jspx_th_impact_userRegionSelect_0.setPersonId( personId );
            _jspx_th_impact_userRegionSelect_0.setValue( region );
            _jspx_th_impact_userRegionSelect_0.setName("selResourceRegion");
            _jspx_th_impact_userRegionSelect_0.setId("selResourceRegion_Id");
            _jspx_th_impact_userRegionSelect_0.setTabIndex("10");
            _jspx_th_impact_userRegionSelect_0.setTitle("Region");
            _jspx_th_impact_userRegionSelect_0.setStyle("WIDTH: 120px");
            _jspx_th_impact_userRegionSelect_0.setOnChange("populateCounties()");
            _jspx_th_impact_userRegionSelect_0.setBlankValue("true");
            int _jspx_eval_impact_userRegionSelect_0 = _jspx_th_impact_userRegionSelect_0.doStartTag();
            if (_jspx_th_impact_userRegionSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n        ");
          }
          if (_jspx_th_impact_ifMobileImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td width=\"20%\">\r\n       ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_7.setValue( county );
          _jspx_th_impact_validateSelect_7.setName("selResourceCounty");
          _jspx_th_impact_validateSelect_7.setLabel("County");
          _jspx_th_impact_validateSelect_7.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_7.setStyle("WIDTH: 120px");
          _jspx_th_impact_validateSelect_7.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n     <tr>\r\n      <td>\r\n       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setValue( address );
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setName("txtResourceAddress1");
          _jspx_th_impact_validateInput_5.setLabel("Address Ln1");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setMaxLength("30");
          _jspx_th_impact_validateInput_5.setSize("30");
          _jspx_th_impact_validateInput_5.setConstraint("Address");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td width=\"30\">\r\n       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setValue( city );
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName("txtResourceCity");
          _jspx_th_impact_validateInput_6.setLabel("City");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setMaxLength("20");
          _jspx_th_impact_validateInput_6.setSize("20");
          _jspx_th_impact_validateInput_6.setConstraint("City");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td width=\"20%\">\r\n        ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifServerImpact_2 = _jspx_th_impact_ifServerImpact_2.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n          ");
            //  impact:validateSelect
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
            _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
            _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_2);
            _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
            _jspx_th_impact_validateSelect_8.setValue( resState );
            _jspx_th_impact_validateSelect_8.setName("selResourceState");
            _jspx_th_impact_validateSelect_8.setLabel("State");
            _jspx_th_impact_validateSelect_8.setCodesTable("CSTATE");
            _jspx_th_impact_validateSelect_8.setBlankValue("true");
            int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
            if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n        ");
          }
          if (_jspx_th_impact_ifServerImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          if (_jspx_meth_impact_ifMobileImpact_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n      <tr>\r\n       <td>\r\n         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setValue( zip );
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName("txtResourceZip");
          _jspx_th_impact_validateInput_7.setLabel("Zip Code");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setMaxLength("5");
          _jspx_th_impact_validateInput_7.setSize("5");
          _jspx_th_impact_validateInput_7.setColspan("3");
          _jspx_th_impact_validateInput_7.setConstraint("Digit5");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                               -\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setValue( zipSuff );
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setName("txtResourceZipSuffix");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setMaxLength("4");
          _jspx_th_impact_validateInput_8.setSize("4");
          _jspx_th_impact_validateInput_8.setConstraint("Digit4");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n     </tr>\r\n    </table>\r\n    <br/>\r\n<!--Begin advanced search\r\nSIR 23890 - changed the wording from level of care to service level.-->\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("AdvancedSearch");
          _jspx_th_impact_ExpandableSectionTag_0.setId("Resource_Status1");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Advanced Search");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n   <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n        <tr>\r\n           <th colSpan=\"4\">\r\n               <label id=\"label_Resource_Status\" for=\"Resource_Status\">Resource Status</label>\r\n           </th>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n            <td>\r\n             ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_9.setValue(resourceStatus);
              _jspx_th_impact_validateSelect_9.setName("selResourceStatus");
              _jspx_th_impact_validateSelect_9.setCodesTable("CRSCSTAT");
              _jspx_th_impact_validateSelect_9.setLabel("Resource Status");
              _jspx_th_impact_validateSelect_9.setBlankValue("true");
              _jspx_th_impact_validateSelect_9.setStyle("WIDTH: 150px");
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      \t    </td>      \t    \r\n            <td>                                    \r\n             ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_10.setValue(resContracted);
              _jspx_th_impact_validateSelect_10.setName("selResourceContractedStatus");
              _jspx_th_impact_validateSelect_10.setCodesTable("CCNTSTAT");
              _jspx_th_impact_validateSelect_10.setLabel("Contract Status");
              _jspx_th_impact_validateSelect_10.setBlankValue("true");
              _jspx_th_impact_validateSelect_10.setStyle("WIDTH: 150px");
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n          <th colSpan=\"4\">Home/Facility Information</th>\r\n        </tr>\r\n      <tr class=\"subDetail\">\r\n       <td  width=\"20%\">\r\n           ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_11.setValue(facType);
              _jspx_th_impact_validateSelect_11.setName("selResourceFacilityType");
              _jspx_th_impact_validateSelect_11.setBlankValue("true");
              _jspx_th_impact_validateSelect_11.setLabel("Type");
              _jspx_th_impact_validateSelect_11.setStyle("WIDTH: 150px");
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>       \r\n        <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_9.setType("checkbox");
              _jspx_th_impact_validateInput_9.setLabel("Available After Hours");
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_9.setChecked( avalibleAfterHours  );
              _jspx_th_impact_validateInput_9.setValue("Y");
              _jspx_th_impact_validateInput_9.setName("cbxBIndAvalibleAfterHours");
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td> \r\n        <td>\r\n            &nbsp;&nbsp;\r\n       </td>\r\n      </tr>\r\n      <tr>\r\n       <th colSpan=\"4\">Client Characteristics</th>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setColspan("3");
              _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_10.setValue(age);
              _jspx_th_impact_validateInput_10.setType("text");
              _jspx_th_impact_validateInput_10.setName("txtResourceAge");
              _jspx_th_impact_validateInput_10.setLabel("Age");
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              _jspx_th_impact_validateInput_10.setMaxLength("3");
              _jspx_th_impact_validateInput_10.setSize("3");
              _jspx_th_impact_validateInput_10.setConstraint("Numeric");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n       <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_12.setColspan("3");
              _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_12.setValue(gender);
              _jspx_th_impact_validateSelect_12.setName("selResourceSex");
              _jspx_th_impact_validateSelect_12.setLabel("Gender");
              _jspx_th_impact_validateSelect_12.setCodesTable("CRSRCSEX");
              _jspx_th_impact_validateSelect_12.setBlankValue("true");
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n       <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_13.setColspan("3");
              _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_13.setValue(character);
              _jspx_th_impact_validateSelect_13.setName("selResourceCharacterisitcs");
              _jspx_th_impact_validateSelect_13.setLabel("Characteristics");
              _jspx_th_impact_validateSelect_13.setOptions( characteristicsOptions );
              _jspx_th_impact_validateSelect_13.setBlankValue("true");
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n      </tr>\r\n    </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"0\">\r\n  <tr>\r\n    <td valign=\"top\" align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmResourceSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceSearch/results");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n  <!-- <input type=\"hidden\" name=\"advSearchExpanded\" value=\"<!%=request.getParameter( \"advSearchExpanded\" )%>\">  -->\r\n  <input type=\"hidden\" name=\"");
          out.print(DatabaseResultDetails.RESULTS_PER_PAGE_NAME);
          out.write("\" value=\"25\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"destinationUrl\" value=\"");
          out.print(destinationUrl);
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CLVOFCR2");
    _jspx_th_impact_codeArray_0.setArrayName("levelCareArray");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CFACTYP4");
    _jspx_th_impact_codeArray_1.setArrayName("facilitytype4");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_2.setParent(null);
    _jspx_th_impact_codeArray_2.setCodeName("CCNTSTAT");
    _jspx_th_impact_codeArray_2.setArrayName("contractStatus");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_3.setParent(null);
    _jspx_th_impact_codeArray_3.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_3.setArrayName("facCounty");
    _jspx_th_impact_codeArray_3.setBlankValue("true");
    int _jspx_eval_impact_codeArray_3 = _jspx_th_impact_codeArray_3.doStartTag();
    if (_jspx_th_impact_codeArray_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_4.setParent(null);
    _jspx_th_impact_codeArray_4.setCodeName("CCOUNT01");
    _jspx_th_impact_codeArray_4.setArrayName("facCounty01");
    _jspx_th_impact_codeArray_4.setBlankValue("true");
    int _jspx_eval_impact_codeArray_4 = _jspx_th_impact_codeArray_4.doStartTag();
    if (_jspx_th_impact_codeArray_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_5.setParent(null);
    _jspx_th_impact_codeArray_5.setCodeName("CCOUNT02");
    _jspx_th_impact_codeArray_5.setArrayName("facCounty02");
    _jspx_th_impact_codeArray_5.setBlankValue("true");
    int _jspx_eval_impact_codeArray_5 = _jspx_th_impact_codeArray_5.doStartTag();
    if (_jspx_th_impact_codeArray_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_6.setParent(null);
    _jspx_th_impact_codeArray_6.setCodeName("CCOUNT03");
    _jspx_th_impact_codeArray_6.setArrayName("facCounty03");
    _jspx_th_impact_codeArray_6.setBlankValue("true");
    int _jspx_eval_impact_codeArray_6 = _jspx_th_impact_codeArray_6.doStartTag();
    if (_jspx_th_impact_codeArray_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_7.setParent(null);
    _jspx_th_impact_codeArray_7.setCodeName("CCOUNT04");
    _jspx_th_impact_codeArray_7.setArrayName("facCounty04");
    _jspx_th_impact_codeArray_7.setBlankValue("true");
    int _jspx_eval_impact_codeArray_7 = _jspx_th_impact_codeArray_7.doStartTag();
    if (_jspx_th_impact_codeArray_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_8.setParent(null);
    _jspx_th_impact_codeArray_8.setCodeName("CCOUNT05");
    _jspx_th_impact_codeArray_8.setArrayName("facCounty05");
    _jspx_th_impact_codeArray_8.setBlankValue("true");
    int _jspx_eval_impact_codeArray_8 = _jspx_th_impact_codeArray_8.doStartTag();
    if (_jspx_th_impact_codeArray_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_9.setParent(null);
    _jspx_th_impact_codeArray_9.setCodeName("CCOUNT06");
    _jspx_th_impact_codeArray_9.setArrayName("facCounty06");
    _jspx_th_impact_codeArray_9.setBlankValue("true");
    int _jspx_eval_impact_codeArray_9 = _jspx_th_impact_codeArray_9.doStartTag();
    if (_jspx_th_impact_codeArray_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_10.setParent(null);
    _jspx_th_impact_codeArray_10.setCodeName("CCOUNT07");
    _jspx_th_impact_codeArray_10.setArrayName("facCounty07");
    _jspx_th_impact_codeArray_10.setBlankValue("true");
    int _jspx_eval_impact_codeArray_10 = _jspx_th_impact_codeArray_10.doStartTag();
    if (_jspx_th_impact_codeArray_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_11.setParent(null);
    _jspx_th_impact_codeArray_11.setCodeName("CCOUNT08");
    _jspx_th_impact_codeArray_11.setArrayName("facCounty08");
    _jspx_th_impact_codeArray_11.setBlankValue("true");
    int _jspx_eval_impact_codeArray_11 = _jspx_th_impact_codeArray_11.doStartTag();
    if (_jspx_th_impact_codeArray_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_12.setParent(null);
    _jspx_th_impact_codeArray_12.setCodeName("CCOUNT09");
    _jspx_th_impact_codeArray_12.setArrayName("facCounty09");
    _jspx_th_impact_codeArray_12.setBlankValue("true");
    int _jspx_eval_impact_codeArray_12 = _jspx_th_impact_codeArray_12.doStartTag();
    if (_jspx_th_impact_codeArray_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_13.setParent(null);
    _jspx_th_impact_codeArray_13.setCodeName("CCOUNT10");
    _jspx_th_impact_codeArray_13.setArrayName("facCounty10");
    _jspx_th_impact_codeArray_13.setBlankValue("true");
    int _jspx_eval_impact_codeArray_13 = _jspx_th_impact_codeArray_13.doStartTag();
    if (_jspx_th_impact_codeArray_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_14.setParent(null);
    _jspx_th_impact_codeArray_14.setCodeName("CCOUNT11");
    _jspx_th_impact_codeArray_14.setArrayName("facCounty11");
    _jspx_th_impact_codeArray_14.setBlankValue("true");
    int _jspx_eval_impact_codeArray_14 = _jspx_th_impact_codeArray_14.doStartTag();
    if (_jspx_th_impact_codeArray_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_15.setParent(null);
    _jspx_th_impact_codeArray_15.setCodeName("CCOUNT12");
    _jspx_th_impact_codeArray_15.setArrayName("facCounty12");
    _jspx_th_impact_codeArray_15.setBlankValue("true");
    int _jspx_eval_impact_codeArray_15 = _jspx_th_impact_codeArray_15.doStartTag();
    if (_jspx_th_impact_codeArray_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_16.setParent(null);
    _jspx_th_impact_codeArray_16.setCodeName("CCOUNT13");
    _jspx_th_impact_codeArray_16.setArrayName("facCounty13");
    _jspx_th_impact_codeArray_16.setBlankValue("true");
    int _jspx_eval_impact_codeArray_16 = _jspx_th_impact_codeArray_16.doStartTag();
    if (_jspx_th_impact_codeArray_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_17(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_17.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_17.setParent(null);
    _jspx_th_impact_codeArray_17.setCodeName("CCOUNT14");
    _jspx_th_impact_codeArray_17.setArrayName("facCounty14");
    _jspx_th_impact_codeArray_17.setBlankValue("true");
    int _jspx_eval_impact_codeArray_17 = _jspx_th_impact_codeArray_17.doStartTag();
    if (_jspx_th_impact_codeArray_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_18(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_18.setParent(null);
    _jspx_th_impact_codeArray_18.setCodeName("CCOUNT15");
    _jspx_th_impact_codeArray_18.setArrayName("facCounty15");
    _jspx_th_impact_codeArray_18.setBlankValue("true");
    int _jspx_eval_impact_codeArray_18 = _jspx_th_impact_codeArray_18.doStartTag();
    if (_jspx_th_impact_codeArray_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_19(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_19.setParent(null);
    _jspx_th_impact_codeArray_19.setCodeName("CGLSVCCD");
    _jspx_th_impact_codeArray_19.setArrayName("facService");
    _jspx_th_impact_codeArray_19.setBlankValue("true");
    int _jspx_eval_impact_codeArray_19 = _jspx_th_impact_codeArray_19.doStartTag();
    if (_jspx_th_impact_codeArray_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_20(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_20.setParent(null);
    _jspx_th_impact_codeArray_20.setCodeName("CGLSVCCD01");
    _jspx_th_impact_codeArray_20.setArrayName("facService01");
    _jspx_th_impact_codeArray_20.setBlankValue("true");
    int _jspx_eval_impact_codeArray_20 = _jspx_th_impact_codeArray_20.doStartTag();
    if (_jspx_th_impact_codeArray_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_21(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_21.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_21.setParent(null);
    _jspx_th_impact_codeArray_21.setCodeName("CGLSVCCD02");
    _jspx_th_impact_codeArray_21.setArrayName("facService02");
    _jspx_th_impact_codeArray_21.setBlankValue("true");
    int _jspx_eval_impact_codeArray_21 = _jspx_th_impact_codeArray_21.doStartTag();
    if (_jspx_th_impact_codeArray_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_22(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_22.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_22.setParent(null);
    _jspx_th_impact_codeArray_22.setCodeName("CGLSVCCD03");
    _jspx_th_impact_codeArray_22.setArrayName("facService03");
    _jspx_th_impact_codeArray_22.setBlankValue("true");
    int _jspx_eval_impact_codeArray_22 = _jspx_th_impact_codeArray_22.doStartTag();
    if (_jspx_th_impact_codeArray_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_23(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_23.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_23.setParent(null);
    _jspx_th_impact_codeArray_23.setCodeName("CGLSVCCD04");
    _jspx_th_impact_codeArray_23.setArrayName("facService04");
    _jspx_th_impact_codeArray_23.setBlankValue("true");
    int _jspx_eval_impact_codeArray_23 = _jspx_th_impact_codeArray_23.doStartTag();
    if (_jspx_th_impact_codeArray_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_24(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_24.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_24.setParent(null);
    _jspx_th_impact_codeArray_24.setCodeName("CGLSVCCD05");
    _jspx_th_impact_codeArray_24.setArrayName("facService05");
    _jspx_th_impact_codeArray_24.setBlankValue("true");
    int _jspx_eval_impact_codeArray_24 = _jspx_th_impact_codeArray_24.doStartTag();
    if (_jspx_th_impact_codeArray_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_25(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_25.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_25.setParent(null);
    _jspx_th_impact_codeArray_25.setCodeName("CGLSVCCD06");
    _jspx_th_impact_codeArray_25.setArrayName("facService06");
    _jspx_th_impact_codeArray_25.setBlankValue("true");
    int _jspx_eval_impact_codeArray_25 = _jspx_th_impact_codeArray_25.doStartTag();
    if (_jspx_th_impact_codeArray_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_26(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_26.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_26.setParent(null);
    _jspx_th_impact_codeArray_26.setCodeName("CGLSVCCD07");
    _jspx_th_impact_codeArray_26.setArrayName("facService07");
    _jspx_th_impact_codeArray_26.setBlankValue("true");
    int _jspx_eval_impact_codeArray_26 = _jspx_th_impact_codeArray_26.doStartTag();
    if (_jspx_th_impact_codeArray_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_27(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_27.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_27.setParent(null);
    _jspx_th_impact_codeArray_27.setCodeName("CGLSVCCD08");
    _jspx_th_impact_codeArray_27.setArrayName("facService08");
    _jspx_th_impact_codeArray_27.setBlankValue("true");
    int _jspx_eval_impact_codeArray_27 = _jspx_th_impact_codeArray_27.doStartTag();
    if (_jspx_th_impact_codeArray_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_28(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_28.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_28.setParent(null);
    _jspx_th_impact_codeArray_28.setCodeName("CGLSVCCD09");
    _jspx_th_impact_codeArray_28.setArrayName("facService09");
    _jspx_th_impact_codeArray_28.setBlankValue("true");
    int _jspx_eval_impact_codeArray_28 = _jspx_th_impact_codeArray_28.doStartTag();
    if (_jspx_th_impact_codeArray_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_29(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_29.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_29.setParent(null);
    _jspx_th_impact_codeArray_29.setCodeName("CGLSVCCD10");
    _jspx_th_impact_codeArray_29.setArrayName("facService10");
    _jspx_th_impact_codeArray_29.setBlankValue("true");
    int _jspx_eval_impact_codeArray_29 = _jspx_th_impact_codeArray_29.doStartTag();
    if (_jspx_th_impact_codeArray_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_30(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_30.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_30.setParent(null);
    _jspx_th_impact_codeArray_30.setCodeName("CGLSVCCD11");
    _jspx_th_impact_codeArray_30.setArrayName("facService11");
    _jspx_th_impact_codeArray_30.setBlankValue("true");
    int _jspx_eval_impact_codeArray_30 = _jspx_th_impact_codeArray_30.doStartTag();
    if (_jspx_th_impact_codeArray_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_31(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_31.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_31.setParent(null);
    _jspx_th_impact_codeArray_31.setCodeName("CGLSVCCD12");
    _jspx_th_impact_codeArray_31.setArrayName("facService12");
    _jspx_th_impact_codeArray_31.setBlankValue("true");
    int _jspx_eval_impact_codeArray_31 = _jspx_th_impact_codeArray_31.doStartTag();
    if (_jspx_th_impact_codeArray_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_32(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_32.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_32.setParent(null);
    _jspx_th_impact_codeArray_32.setCodeName("CGLSVCCD13");
    _jspx_th_impact_codeArray_32.setArrayName("facService13");
    _jspx_th_impact_codeArray_32.setBlankValue("true");
    int _jspx_eval_impact_codeArray_32 = _jspx_th_impact_codeArray_32.doStartTag();
    if (_jspx_th_impact_codeArray_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_33(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_33.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_33.setParent(null);
    _jspx_th_impact_codeArray_33.setCodeName("CGLSVCCD14");
    _jspx_th_impact_codeArray_33.setArrayName("facService14");
    _jspx_th_impact_codeArray_33.setBlankValue("true");
    int _jspx_eval_impact_codeArray_33 = _jspx_th_impact_codeArray_33.doStartTag();
    if (_jspx_th_impact_codeArray_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_34(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_34.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_34.setParent(null);
    _jspx_th_impact_codeArray_34.setCodeName("CGLSVCCD15");
    _jspx_th_impact_codeArray_34.setArrayName("facService15");
    _jspx_th_impact_codeArray_34.setBlankValue("true");
    int _jspx_eval_impact_codeArray_34 = _jspx_th_impact_codeArray_34.doStartTag();
    if (_jspx_th_impact_codeArray_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_0.setParent(null);
    int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n  populateCounties();\r\n");
    }
    if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("frmResourceSearch");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_ifMobileImpact_2 = _jspx_th_impact_ifMobileImpact_2.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n          <label name=\"label_selResourceState\" id=\"label_selResourceState_Id\" for=\"selResourceState_Id\" class=\"formLabel\" value=\"State\">State:</label>\r\n          </td><td>\r\n          <input type=\"hidden\" name=\"selResourceState\" value=\"GA\">Georgia\r\n        ");
    }
    if (_jspx_th_impact_ifMobileImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
