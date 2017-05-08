<%
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
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceDetailConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List"%>

<%
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
%>

<script language="JavaScript">
//Get level of care code/decode array
    <impact:codeArray codeName="CLVOFCR2" arrayName="levelCareArray" blankValue="true"/>
//Get faciltiy type code/decode array for Resource Type of MHMR
    <impact:codeArray codeName="CFACTYP4" arrayName="facilitytype4" blankValue="true"/>
//Get contract status code/decode array
    <impact:codeArray codeName="CCNTSTAT" arrayName="contractStatus" blankValue="true"/>
//Get county code/decode array with all data
    <impact:codeArray codeName="CCOUNT" arrayName="facCounty" blankValue="true"/>
//Get county code/decode array filtered for regions
    <impact:codeArray codeName="CCOUNT01" arrayName="facCounty01" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT02" arrayName="facCounty02" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT03" arrayName="facCounty03" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT04" arrayName="facCounty04" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT05" arrayName="facCounty05" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT06" arrayName="facCounty06" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT07" arrayName="facCounty07" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT08" arrayName="facCounty08" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT09" arrayName="facCounty09" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT10" arrayName="facCounty10" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT11" arrayName="facCounty11" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT12" arrayName="facCounty12" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT13" arrayName="facCounty13" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT14" arrayName="facCounty14" blankValue="true"/>
    <impact:codeArray codeName="CCOUNT15" arrayName="facCounty15" blankValue="true"/>
//Get service code/decode array
    <impact:codeArray codeName="CGLSVCCD" arrayName="facService" blankValue="true"/>
//Get service code/decode array filtered based on category
    <impact:codeArray codeName="CGLSVCCD01" arrayName="facService01" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD02" arrayName="facService02" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD03" arrayName="facService03" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD04" arrayName="facService04" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD05" arrayName="facService05" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD06" arrayName="facService06" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD07" arrayName="facService07" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD08" arrayName="facService08" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD09" arrayName="facService09" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD10" arrayName="facService10" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD11" arrayName="facService11" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD12" arrayName="facService12" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD13" arrayName="facService13" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD14" arrayName="facService14" blankValue="true"/>
    <impact:codeArray codeName="CGLSVCCD15" arrayName="facService15" blankValue="true"/>

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction()
{
  /** If an error message is recived that is not from the validation framework make sure
   *  on the second submit the form is submitted for validation */

  <%if( !"".equals(errorMessage) )
    {%>
      document.frmResourceSearch.action = "/resource/ResourceSearch/default";
  <%}%>

  <% if( StringHelper.isTrue(locationBoolean) && PlatformConstants.SERVER_IMPACT )
     {%>
    // SIR 19264 - disabling the dropdown would not allow the user to submit the
    // form by hitting enter, but clearing and populating it works just fine.
    clearDropdown( "selResourceRegion" );
    //document.frmResourceSearch.selResourceRegion.disabled = true;
   <%}%>

  //checks to see if the Resource Type is MHMR Facility
  if(document.frmResourceSearch.selResourceType.options.value != null)
  {
    populateDropdown("selResourceFacilityType", "<%=facType%>", facilitytype4);
  }

  // Commenting this out for now. RBWO (a.k.a LOC) is likely going to come back
  //if(document.frmResourceSearch.selResourceFacilityType.options.value != '' &&
  //   document.frmResourceSearch.selResourceType.options.value == '06' )
  //{
  //  populateDropdown("selResourceLOC", "<%=lvlCare%>", levelCareArray);
  //}

  if(document.frmResourceSearch.selResourceCategory.options.value == "")
  {
    if ("<%= serviceValue %>" != "")
    {
      populateDropdown("selResourceService", "<%=serviceValue%>", facService);
    }
  }
  else
  {
    populateDropdown("selResourceService", "<%=serviceValue%>",
    eval("facService"+document.frmResourceSearch.selResourceCategory.options.value));
  }

  // this will force clear the region dropdown if needed
  var regMode = <%=areaBoolean%>;

  if ( regMode )
  {
    setRegionMode( 'enable' );
  }
  else
  {
    setRegionMode( 'disable' );
  }

  setFocus();

<impact:ifMobileImpact>
  populateCounties();
</impact:ifMobileImpact>
}

 /*
*This function populates drop down boxes with options.
* param field: Name of drop down box to be populated
* param val: Value of last selected option on dropdown box
* param cat: Array containing the values to populate drop down options
  */
function populateDropdown(field, val, cat)
{
  //sets the drop-down box to the length of the array
  eval("document.frmResourceSearch."+field+".options.length =cat.length");
  for (var q=0; q < cat.length; q++)
  {
    //populates the drop-down box with the values from the CodeDecodeCache
    eval("document.frmResourceSearch."+field+".options[q].value = cat[q].substring(0,cat[q].indexOf(\"|\"))");
    eval("document.frmResourceSearch."+field+".options[q].text = cat[q].substring(cat[q].indexOf(\"|\")+1,cat[q].length)");
  }
  eval("document.frmResourceSearch."+field+".value =\""+val+"\"");
}

 /*
*This function clears drop down boxes of all options.
*@ param field: Name of drop down box to be cleard of all options
  */
function clearDropdown(field)
{
  //sets the values of all options to blank, and changes the number of options to 1
  var fieldLength = eval("document.frmResourceSearch."+field+".options.length");
  for (var b=0; b < fieldLength; b++)
  {
    //empties the facility type drop-down box
    eval("document.frmResourceSearch."+field+".options[b].value = \"\";");
    eval("document.frmResourceSearch."+field+".options[b].text = \"\";");
  }

  eval("document.frmResourceSearch."+field+".options.length = 1");
}

function populateFacilityType()
{
  //checks to see if the Resource Type is MHMR Facility
  if(document.frmResourceSearch.selResourceType.options.value != null)
  {
    populateDropdown("selResourceFacilityType", "", facilitytype4);
  }
  //for facilities other than MHMR Facility and Other Facility
  else
  {
    clearDropdown("selResourceFacilityType");
  }
//  populateLOC();
}

function warnFacTypeMessage(){
	if(document.frmResourceSearch.selResourceType.options.value == 06){
		//alert('document.frmResourceSearch.selResourceType.options.value='+document.frmResourceSearch.selResourceType.options.value)
		alert('When Searching by Home/Other Facility, use the advanced search '+
		'section to select a type of home or facility.');
	}
}

//populate the Level of Care select box
//function populateLOC()
//{
  //clear Level Of Care drop down if Resource Type is not Other Facility and if a Facility Type is not selected
//  if(document.frmResourceSearch.selResourceFacilityType.options.value == '' || document.frmResourceSearch.selResourceType.options.value != '06')
//  {
//    clearDropdown("selResourceLOC");
//  }
  // if Resource type is Other Facility and a Facility Type is selected then populate Level Of Care
//  else if(document.frmResourceSearch.selResourceFacilityType.options.value != '' && document.frmResourceSearch.selResourceType.options.value == '06' )
//  {
//    populateDropdown("selResourceLOC", "", levelCareArray);
//  }
//}

//Populate the Services select box
function populateResourceService()
{
  //clear Service drop down if a Category is not selected
  if(document.frmResourceSearch.selResourceCategory.options.value == "")
  {
    populateDropdown("selResourceService", "", facService);
  }
  else
  {
    populateDropdown("selResourceService", "", eval("facService"+document.frmResourceSearch.selResourceCategory.options.value));
  }
}

//Populate the Counties select box
function populateCounties()
{
  if(document.frmResourceSearch.selResourceRegion.options.value == "00" || document.frmResourceSearch.selResourceRegion.options.value == "98" || document.frmResourceSearch.selResourceRegion.options.value == "99")
  {
    clearDropdown("selResourceCounty");
  }
  else
  {
    populateDropdown("selResourceCounty", "", eval("facCounty"+document.frmResourceSearch.selResourceRegion.options.value));
  }
}

//set the initial focus of the page
function setFocus()
{
  document.frmResourceSearch.selResourceType.focus();
}

// SIR 19264 - set array of regions
<impact:codeArray codeName="<%= CodesTables.CREGIONS %>"
                  arrayName="CSVCRGNS_Array"
                  blankValue="true" />

//set the region to enabled or disabled
function setRegionMode( mode )
{
<impact:ifServerImpact>
  if( mode == 'disable' )
  {
    // SIR 19264 - disabling the dropdown would not allow the user to submit the
    // form by hitting enter, but clearing and populating it works just fine.
    clearDropdown( "selResourceRegion" );
    //document.frmResourceSearch.selResourceRegion.disabled = true;
  }
  else if( mode == 'enable' )
  {
    // populate dropdown pass array with codestable
    // SIR 19264 - disabling the dropdown would not allow the user to submit the
    // form by hitting enter, but clearing and populating it works just fine.
    populateDropdown( "selResourceRegion", "<%= region %>", CSVCRGNS_Array );
    // document.frmResourceSearch.selResourceRegion.disabled = false;
  }
</impact:ifServerImpact>
}

//Clear the values for the fields in the Advanced Search section of the page
function clearAdvancedFields()
{
  var x = document.frmResourceSearch;
  x.rbResourceStatus[0].checked = true;
//Contract Status
  x.selResourceContractedStatus.value = '';
  x.selResourceFacilityType.value = '';
  //RBWO is likely going to be delayed
  //commenting this section cos
  //of an error possibility
  x.txtResourceAge.value = '';
  x.selResourceSex.value = '';
  x.selResourceCharacterisitcs.value = '';
}
</script>
<impact:validateErrors formName="frmResourceSearch"/>
<impact:validateForm
   name="frmResourceSearch"
   method="post"
   action="/resource/ResourceSearch/results"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchValidation"
   pageMode="<%= PageModeConstants.EDIT %>"
   defaultButton="true"
   schema="/WEB-INF/Constraints.xsd">
    <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
     <tr>
      <th colspan="4">Resource Details
      </th>
     </tr>
     <tr>
      <td colspan="4" class="formInstruct">When conducting a resource search, one of the following must be entered:  Resource Type, Resource Name, Identification Number, or Service.</td>
     </tr>
     <tr>
      <td width="20%">
             <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                 value="<%=rsrcType%>"
                                 name="selResourceType"
                                 codesTable="CRSCTYPE"
                                 label="Resource Type"
                                 excludeOptions="<%=typeExclusionSet%>"
                                 conditionallyRequired="true"
                                 onChange="populateFacilityType();warnFacTypeMessage();"
                                 blankValue="true"/>

      </td>
      <td width="20%">
        <impact:validateInput tabIndex="<%=tabIndex++%>"
                              value="<%=rsrcName%>"
                              type="text"
                              name="txtResourceName"
                              label="Resource Name"
                              conditionallyRequired="true"
                              cssClass="formInput"
                              size="15"
                              maxLength="30"
                              constraint="Paragraph"/>
      </td>
     </tr>
     <tr>
      <td>
          <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                 value="<%=idType%>"
                                 name="selIdentificationType"
                                 label="Identification Number"
                                 excludeOptions="<%=idExclusionSet%>"
                                 conditionallyRequired="true"
                                 codesTable="CRSIDTYP"
                                 blankValue="true"/>

          <impact:validateInput tabIndex="<%=tabIndex++%>"
                                value="<%=idNum%>"
                                type="text"
                                name="txtIdentificationNumber"
                                constraint="Digit16Less"
                                maxLength="16"
                                size="16"/>
      </td>
      <td>
         <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                value="<%=programValue%>"
                                name="selResourceProgram"
                                codesTable="CRSCPROG"
                                label="Program"
                                excludeOptions="<%=progExclusionSet%>"
                                blankValue="true"
                                disabled="true"/>
       </td>
     </tr>
     <% if (showServiceEffectiveDate == true) {%>
     <tr>
       <td>
				<impact:validateDisplayOnlyField name="dspServiceCode" label="Service Code" value="<%=FormattingHelper.formatString(serviceValue)%>" />
	   </td>
       <td>
				<impact:validateDisplayOnlyField name="dspEffectiveDate" label="Effective Date" value="<%=FormattingHelper.formatString(effectiveDate)%>" />
	   </td>
      </tr>
     <% } else { %>
     <tr>
       <td>
         <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                value="<%=categoryValue%>"
                                name="selResourceCategory"
                                codesTable="CATOFSVC"
                                label="Category"
                                onChange="populateResourceService()"
                                blankValue="true"/>
       </td>
       <td>
         <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                value="<%=serviceValue%>"
                                name="selResourceService"
                                style="WIDTH: 200px"
                                blankValue="true"
                                orderBy="decode"
                                contentType = "<%= SelectTag.CODES_DECODES%>"
                                codesTable="CGLSVCCD"
                                label="Service"
                                conditionallyRequired="true" />
       </td>
      </tr>
      <% }%>
    </table>

    <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
        <tr>
         <th colspan="4">
           <label id="label_Location/Area_Served" for="Location/Area_Served">Location/Area Served</label>
         </th>
       </tr>
      <%
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
      %>
       <tr>
         <td class="formLabel" colspan="2" width="20%"><nbsp>
           <impact:validateInput tabIndex="<%=tabIndex++%>"
                                 type="radio"
                                 name="rbResourceLocationArea"
                                 value="lctn"
                                 disabled="<%=disabledButtons%>"
                                 onChange="populateCounties()"
                                 cssClass="formInput"
                                 checked="<%= String.valueOf( locationBoolean ) %>"
                                 onClick="setRegionMode('disable');"/>Location
           <impact:validateInput tabIndex="<%=tabIndex++%>"
                                 type="radio"
                                 name="rbResourceLocationArea"
                                 value="area"
                                 disabled="<%=disabledButtons%>"
                                 cssClass="formInput"
                                 checked="<%= String.valueOf( areaBoolean ) %>"
                                 onClick="setRegionMode('enable');"/>Area Served
            <impact:validateInput tabIndex="<%=tabIndex++%>"
                                 type="radio"
                                 name="rbResourceLocationArea"
                                 value="prox"
                                 disabled="<%=disabledButtons%>"
                                 cssClass="formInput"
                                 checked="<%= String.valueOf( areaBoolean ) %>"
                                 onClick="setRegionMode('disable');"/>Proximity
         </td>
         <td >
           <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                value="<%=proximityRange%>"
                                name="selProximityRange"
                                style="WIDTH: 50px"
                                blankValue="true"
                                codesTable="CPROXRNG"
                                label="Proximity Range(miles)"
                                conditionallyRequired="true" />
         </td>         
     </tr>        
     <tr>
      <td width="20%">
        <impact:ifServerImpact>
         <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                value="<%= region %>"
                                name="selResourceRegion"
                                codesTable="CREGIONS"
                                label="Region"
                                onChange="populateCounties()"
                                style="WIDTH: 120px"
                                blankValue="true"/>
        </impact:ifServerImpact>
        <impact:ifMobileImpact>
          <label name="label_selResourceRegion" id="label_selResourceRegion_Id" for="selResourceRegion_Id" class="formLabel" value="Region">Region:</label>
          </td>
          <td width="30%">
          <impact:userRegionSelect personId="<%= personId %>"
                                   value="<%= region %>"
                                   name="selResourceRegion"
                                   id="selResourceRegion_Id"
                                   tabIndex="10"
                                   title="Region"
                                   style="WIDTH: 120px"
                                   onChange="populateCounties()"
                                   blankValue="true"/>
        </impact:ifMobileImpact>
      </td>
      <td width="20%">
       <impact:validateSelect tabIndex="<%=tabIndex++%>"
                              value="<%= county %>"
                              name="selResourceCounty"
                              label="County"
                              codesTable="CCOUNT"
                              style="WIDTH: 120px"
                              blankValue="true"/>
      </td>
     </tr>
     <tr>
      <td>
       <impact:validateInput tabIndex="<%=tabIndex++%>"
                             value="<%= address %>"
                             type="text" 
                             name="txtResourceAddress1"
                             label="Address Ln1"
                             cssClass="formInput"
                             maxLength="30"
                             size="30"
                             constraint="Address"/>
      </td>
    </tr>
    <tr>
      <td width="30">
       <impact:validateInput tabIndex="<%=tabIndex++%>"
                             value="<%= city %>"
                             type="text" name="txtResourceCity"
                             label="City"
                             cssClass="formInput"
                             maxLength="20"
                             size="20"
                             constraint="City"/>
      </td>
      <td width="20%">
        <impact:ifServerImpact>
          <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                 value="<%= resState %>"
                                 name="selResourceState"
                                 label="State"
                                 codesTable="CSTATE"
                                 blankValue="true"/>
        </impact:ifServerImpact>
        <impact:ifMobileImpact>
          <label name="label_selResourceState" id="label_selResourceState_Id" for="selResourceState_Id" class="formLabel" value="State">State:</label>
          </td><td>
          <input type="hidden" name="selResourceState" value="GA">Georgia
        </impact:ifMobileImpact>
      </td>
     </tr>
      <tr>
       <td>
         <impact:validateInput tabIndex="<%=tabIndex++%>"
                               value="<%= zip %>"
                               type="text"
                               name="txtResourceZip"
                               label="Zip Code"
                               cssClass="formInput"
                               maxLength="5"
                               size="5"
                               colspan="3"
                               constraint="Digit5"/>
                               -
        <impact:validateInput  tabIndex="<%=tabIndex++%>"
                               value="<%= zipSuff %>"
                               type="text"
                               name="txtResourceZipSuffix"
                               cssClass="formInput"
                               maxLength="4"
                               size="4"
                               constraint="Digit4"/>
       </td>
     </tr>
    </table>
    <br/>
<!--Begin advanced search
SIR 23890 - changed the wording from level of care to service level.-->
<impact:ExpandableSectionTag name="AdvancedSearch" id="Resource_Status1" label="Advanced Search"
                             tabIndex="<%= tabIndex++ %>">
   <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
        <tr>
           <th colSpan="4">
               <label id="label_Resource_Status" for="Resource_Status">Resource Status</label>
           </th>
        </tr>
        <tr class="subDetail">
            <td>
             <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                    value="<%=resourceStatus%>"
                                    name="selResourceStatus"
                                    codesTable="CRSCSTAT"
                                    label="Resource Status"
                                    blankValue="true"
                                    style="WIDTH: 150px"/>
      	    </td>      	    
            <td>                                    
             <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                    value="<%=resContracted%>"
                                    name="selResourceContractedStatus"
                                    codesTable="CCNTSTAT"
                                    label="Contract Status"
                                    blankValue="true"
                                    style="WIDTH: 150px"/>
            </td>
        </tr>
        <tr>
          <th colSpan="4">Home/Facility Information</th>
        </tr>
      <tr class="subDetail">
       <td  width="20%">
           <impact:validateSelect tabIndex="<%=tabIndex++%>"
                                  value="<%=facType%>"
                                  name="selResourceFacilityType"
                                  blankValue="true"
                                  label="Type"
                                  style="WIDTH: 150px"/>
       </td>       
        <td><impact:validateInput  type="checkbox"
                               label="Available After Hours"
                               tabIndex="<%= tabIndex++ %>"
                               checked="<%= avalibleAfterHours  %>"
                               value="Y"
                               name="cbxBIndAvalibleAfterHours"/>
      </td> 
        <td>
            &nbsp;&nbsp;
       </td>
      </tr>
      <tr>
       <th colSpan="4">Client Characteristics</th>
      </tr>
      <tr class="subDetail">
       <td>
        <impact:validateInput colspan="3"
                              tabIndex="<%=tabIndex++%>"
                              value="<%=age%>"
                              type="text"
                              name="txtResourceAge"
                              label="Age"
                              cssClass="formInput"
                              maxLength="3"
                              size="3"
                              constraint="Numeric"/>
       </td>
      </tr>
      <tr class="subDetail">
       <td>
        <impact:validateSelect colspan="3"
                               tabIndex="<%=tabIndex++%>"
                               value="<%=gender%>"
                               name="selResourceSex"
                               label="Gender"
                               codesTable="CRSRCSEX"
                               blankValue="true"/>
       </td>
      </tr>
      <tr class="subDetail">
       <td>
        <impact:validateSelect colspan="3"
                               tabIndex="<%=tabIndex++%>"
                               value="<%=character%>"
                               name="selResourceCharacterisitcs"
                               label="Characteristics"
                               options="<%= characteristicsOptions %>"
                               blankValue="true"/>
       </td>
      </tr>
    </table>
</impact:ExpandableSectionTag>
<br>
<table cellspacing="0" cellpadding="3" width="100%" border="0">
  <tr>
    <td valign="top" align="right">
      <impact:ButtonTag name="btnSearch"
                        backSafe="true"
                        editableMode="<%= EditableMode.EDIT %>"
                        img="btnSearch"
                        align="right"
                        form="frmResourceSearch"
                        action="/resource/ResourceSearch/results"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
  <!-- <input type="hidden" name="advSearchExpanded" value="<!%=request.getParameter( "advSearchExpanded" )%>">  -->
  <input type="hidden" name="<%=DatabaseResultDetails.RESULTS_PER_PAGE_NAME%>" value="25"/>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <input type="hidden" name="destinationUrl" value="<%=destinationUrl%>"/>
</impact:validateForm>