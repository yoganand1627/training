package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO;
import gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class OnCallDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*--------------------------------------------------------------------------------
//*  JSP Name:     On-Call Detail
//*  Created by:   Jason Rios
//*  Date Created: 12/27/02
//*
//*  Description:
//*  This JSP displays the On-Call Detail page.
//*
//*  Change History:
//*  Date      User              Description
//*  ---------   ----------------  --------------------------------------------------
//*  09/30/03    Merle A Demo      SIR19889 OnCall schedule caused IndexArrayOutOfBounds exception,
//*                                added control veriable arrayEmpOnCallFull to disable the 'Add'
//*                                button when 9 people are in the ccmn22di_array.  Also changed the
//*                                size of the array from 9 to 18 in the .xds  9 delete rows and 9 add
//*                                rows.
//* 07/15/08     Cwells            When hidding the Delete button make sure not only do we check to see  
//*                                if the employee object is null but also check to see if it was created 
//*								   but the rows deleted.
//*
//*
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
String hdnUlIdOnCall = "";
String hdnTsLastUpdate = "";
String selSzCdOnCallProgram = "";
String selSzCdOnCallType = "";
String txtDtDtOnCallStart = "";
String txtTmOnCallStart = "";
String txtDtDtOnCallEnd = "";
String txtTmOnCallEnd = "";
String selSzCdRegion = "";
String selSzCdCounty = "";
List selectedCountiesVector = new ArrayList();
//Map countiesToRegionHashMap = null;
boolean goToEmployeesSection = false;
//SIR19889
boolean arrayEmpOnCallFull = false;

ArrayList<String> excludeCounty = new ArrayList<String>();
excludeCounty.add(CodesTables.CCOUNT_999);

CCMN06SO ccmn06so = null;
CCMN09SO ccmn09so_list = null;

//Collection regionsCollection = Lookup.getCategoryCollection( CodesTables.CREGIONS );
//CodeAttributes region = null;
//List countiesVector = null;
//Iterator regionsIterator = null;

// Create an ArrayList of options to exclude from the Regions dropdown.
// Exclude 'Statewide Intake' and 'State Office'.
List<String> regionsToExclude = new ArrayList<String>();
regionsToExclude.add( CodesTables.CREGIONS_00 );
regionsToExclude.add( CodesTables.CREGIONS_99 );

//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
UserProfile user = UserProfileHelper.getUserProfile( request );

//countiesToRegionHashMap = ( Map )state.getAttribute( "countiesToRegionHashMap", request );

ccmn06so = ( CCMN06SO )state.getAttribute( OnCallConversation.CCMN06SO_DETAIL, request );
if ( ccmn06so != null )
{
  java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat( "MM/dd/yyyy" );
  java.util.Date tempDate = null;
  tempDate = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getDtDtOnCallStart().toDate();
  String startDate = dateFormatter.format( tempDate );
  tempDate = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getDtDtOnCallEnd().toDate();
  String endDate = dateFormatter.format( tempDate );

  hdnUlIdOnCall = String.valueOf( ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getUlIdOnCall() );
  hdnTsLastUpdate = DateHelper.toISOString( ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getTsLastUpdate() );
  selSzCdOnCallProgram = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getSzCdOnCallProgram();
  selSzCdOnCallType = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getSzCdOnCallType();
  txtDtDtOnCallStart = startDate;
  txtTmOnCallStart = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getTmOnCallStart();
  txtDtDtOnCallEnd = endDate;
  txtTmOnCallEnd = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getTmOnCallEnd();
  selSzCdRegion = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO( 0 ).getSzCdRegion();
  if (selSzCdRegion.length()<4){
    if (selSzCdRegion.charAt(0)=='0'){
      selSzCdRegion = selSzCdRegion.substring(1);
    }
    selSzCdRegion = "Region " + selSzCdRegion;
  }
  selSzCdCounty = ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getSzCdOnCallCounty();       
  selectedCountiesVector = ( List )state.getAttribute( OnCallConversation.SELETED_COUNTIES_VECTOR, request );
  
}
else
{
  if ( state.getAttribute( OnCallConversation.SEL_SZCD_ONCALL_PROG, request ) != null )
  {
    selSzCdOnCallProgram = ( String )state.getAttribute( OnCallConversation.SEL_SZCD_ONCALL_PROG, request );
  }
  if ( state.getAttribute( OnCallConversation.SEL_SZCD_ONCALL_TYP, request ) != null )
  {
    selSzCdOnCallType = ( String )state.getAttribute( OnCallConversation.SEL_SZCD_ONCALL_TYP, request );
  }
  if ( state.getAttribute( OnCallConversation.TXT_DT_ONCALL_START, request ) != null )
  {
    txtDtDtOnCallStart = ( String )state.getAttribute( OnCallConversation.TXT_DT_ONCALL_START, request );
  }
  if ( state.getAttribute( OnCallConversation.TXT_TM_ONCALL_START, request ) != null )
  {
    txtTmOnCallStart = ( String )state.getAttribute( OnCallConversation.TXT_TM_ONCALL_START, request );
  }
  if ( state.getAttribute( OnCallConversation.TXT_DT_ONCALL_END, request ) != null )
  {
    txtDtDtOnCallEnd = ( String )state.getAttribute( OnCallConversation.TXT_DT_ONCALL_END, request );
  }
  if ( state.getAttribute( OnCallConversation.TXT_TM_ONCALL_END, request ) != null )
  {
    txtTmOnCallEnd = ( String )state.getAttribute( OnCallConversation.TXT_TM_ONCALL_END, request );
  }
  if ( state.getAttribute( OnCallConversation.SEL_SZCD_REGION, request ) != null )
  {
    selSzCdRegion = ( String )state.getAttribute( OnCallConversation.SEL_SZCD_REGION, request );
  }
  if ( state.getAttribute( OnCallConversation.SELETED_COUNTIES_VECTOR, request ) != null )
  {
    selectedCountiesVector = ( List )state.getAttribute( OnCallConversation.SELETED_COUNTIES_VECTOR, request );
    selSzCdCounty = (String) selectedCountiesVector.get(0);
  }
}

// The Region drop-down should default to the user's region...assuming
// the user is in Region 1-11 or Statewide. Iterate through the regions
// in the CREGIONS codes table to verify that the user is in one of
// those regions. If he is, then default the Region drop-down to that
// region; otherwise, default it to Region 1.
//if ("".equals(selSzCdRegion) )
//{
 // if ( user.getUserRegion() != null &&
 //      !"".equals(user.getUserRegion()) )
 // {
 //   regionsIterator = regionsCollection.iterator();
 //   while ( regionsIterator.hasNext() )
 //   {
 //     region = ( CodeAttributes )regionsIterator.next();

  //    if ( !region.getCode().equals( CodesTables.CREGIONS_00 ) &&
  //         !region.getCode().equals( CodesTables.CREGIONS_99 ) &&
  //         region.getCode().equals( user.getUserRegion() ) )
   //   {
  //      selSzCdRegion = user.getUserRegion();
  //    }
  //  }
  //}

  // If Region is still empty, default it to Region 1.
 // if ("".equals(selSzCdRegion) )
 // {
 //   selSzCdRegion = CodesTables.CREGIONS_01;
 // }
//}

ccmn09so_list = ( CCMN09SO )state.getAttribute( OnCallConversation.CCMN09SO_LIST, request );

if( request.getAttribute( "goToEmployeesSection" ) != null )
{
  goToEmployeesSection = (Boolean) request.getAttribute("goToEmployeesSection");
}

//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageModeConstants.VIEW;
if( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}
List<String> countyCodes = new ArrayList<String>(Lookup.getCategoryCodesCollection(CodesTables.CCNTYREG));
Map<String, String> countyRegions = (Map<String, String>) state.getAttribute("countyRegionCodes", request);


      out.write("\r\n\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nvar county_region= new Array();\r\n");

// Gets an array of counties and regions from the CCNTYREG codes table 
// Prints out the results recieved on the server side so we can use this logic on the client side
if(countyRegions!=null){
for (int i = 0; i < countyCodes.size(); i++){
  int rem = 0;
  if((rem = i%4) == 0){
    out.write("\n");
  }
  out.write("county_region[\"" + countyCodes.get(i) + "\"]=\" " + countyRegions.get(countyCodes.get(i)) + "\";");
}
}

      out.write("\r\n\r\n function  getRegionForCountySelected(){\r\n var county = document.frmOnCallDetail.selSzCdCounty.value;\r\n var region = document.frmOnCallDetail.txtRegion.value; \r\n // retrieves from printed out array above\r\n document.frmOnCallDetail.txtRegion.value = 'Region'+ county_region[county];\r\n  \r\n}\r\n\r\n// Called before the page unloads to display the \"Are you sure\r\n// you want to navigate away from this page...\" message if the\r\n// user hasn't saved their changes.\r\nwindow.onbeforeunload = function ()\r\n{\r\n   IsDirty();\r\n\r\n};\r\n\r\nwindow.onload = function ()\r\n{\r\n  ");

  // If the user just added or deleted an employee, achor the
  // page to the Employees listbox.
  if ( goToEmployeesSection &&
      !FormValidation.pageHasErrorMessages( request ) &&
      !FormValidation.pageHasValidationMessages( "frmOnCallDetail", request ) )
  {
      out.write("\r\n    goToEmployeesSection.click();\r\n  ");

  }
  
      out.write("\r\n}\r\n\r\n// This function will hide all counties sections, then show the\r\n// appropriate counties section based on the region selected in\r\n// the Region drop-down.\r\nfunction showCountiesForSelectedRegion( bInitialPageLoad )\r\n{\r\n  var divArray = document.getElementsByTagName(\"div\");\r\n  for ( i = 0; i < divArray.length; i++ )\r\n  {\r\n    if ( divArray[i].id.substr(0, 6) == \"\" )\r\n    {\r\n      divArray[i].style.display = \"none\";\r\n    }\r\n  }\r\n\r\n  if ( document.frmOnCallDetail.selSzCdRegion.value != \"\" )\r\n  {\r\n    // Deselect any previously selected counties for the selected\r\n    // region since the user just now changed regions to this region.\r\n    if ( bInitialPageLoad == false &&\r\n         document.frmOnCallDetail.selSzCdRegion.value != \"");
      out.print( CodesTables.CREGIONS_98 );
      out.write("\" )\r\n    {\r\n      selectAllDisplayedCounties( false );\r\n    }\r\n\r\n    // Show the selected region.\r\n    var divNameToDisplay = \"Region\" + document.frmOnCallDetail.selSzCdRegion.value + \"Counties\";\r\n    toggleVisibility( divNameToDisplay, \"block\" );\r\n  }\r\n  return true;\r\n}\r\n\r\n\r\n// This function confirms that the user has selected a row in\r\n// the list box before continuing with the 'Delete' or 'New Using'\r\n// procedure.\r\nfunction confirmRowSelected( buttonClicked )\r\n{\r\n  var rowSelected = false;\r\n\r\n  // If the radio button group is an array (i.e., more than one\r\n  // radio button), then loop through the array and check for a\r\n  // selected radio button; otherwise, check the single radio\r\n  // button to see if it is selected.\r\n  if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[0] )\r\n  {\r\n    for (var i = 0; i < document.frmOnCallDetail.selectedEmployeeIndex_CLEAN.length; i++)\r\n    {\r\n      if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[i].checked )\r\n      {\r\n        rowSelected = true;\r\n        break;\r\n");
      out.write("      }\r\n    }\r\n  }\r\n  else\r\n  {\r\n    if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN.checked )\r\n    {\r\n      rowSelected = true;\r\n    }\r\n  }\r\n\r\n  // Handle a 'Delete' click.\r\n  if ( buttonClicked == \"delete\" )\r\n  {\r\n    if ( rowSelected == false )\r\n    {\r\n      alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("\" );\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      return confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\" );\r\n    }\r\n  }\r\n  return false;\r\n}\r\n\r\n// This function submits the 'frmOnCallEmployees' form to display\r\n// the On-Call Employee Details for the selected employee.\r\nfunction goToOnCallEmployeeDetailPage( selectedEmployeeIndex )\r\n{\r\n  // Disable the \"IsDirty()\" check because any changes to the schedule\r\n  // information made by the user will be preserved by the activity\r\n  // method.\r\n  window.onbeforeunload = null;\r\n\r\n  setState('frmOnCallDetail');\r\n  setValidationUrl('frmOnCallDetail', '/workload/OnCall/displayOnCallEmployee');\r\n\r\n  // If the 'selectedEmployeeIndex_CLEAN' radio button group is an array\r\n  // (i.e., more than one radio button), then set the appropriate\r\n  // array element to checked; otherwise, set the single radio button\r\n  // to checked.\r\n  if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[0] )\r\n  {\r\n    document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[ selectedEmployeeIndex ].checked = true;\r\n  }\r\n  else\r\n  {\r\n    document.frmOnCallDetail.selectedEmployeeIndex_CLEAN.checked = true;\r\n");
      out.write("  }\r\n  document.frmOnCallDetail.submit();\r\n}\r\n\r\nfunction setButtonPressed( buttonName )\r\n{\r\n  var pageMode = ");
      out.print( pageMode );
      out.write(";\r\n\r\n  document.frmOnCallDetail.buttonPressed.value = buttonName;\r\n\r\n  // If the user clicked Save to modify the record, ask them to\r\n  // confirm that they wish to modify it. The message should not\r\n  // be displayed if the PageMode is NEW_USING.\r\n  if ( buttonName == \"");
      out.print( OnCallCustomValidation.SAVE_BUTTON );
      out.write("\" &&\r\n       document.frmOnCallDetail.hdnUlIdOnCall.value != \"\" &&\r\n       pageMode != ");
      out.print( PageModeConstants.NEW_USING );
      out.write(" )\r\n  {\r\n    return confirm(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_MODIFY ) );
      out.write("\");\r\n  }\r\n\r\n  return true;\r\n}\r\n\r\n\r\nfunction showRegionForSelectedCounty()\r\n  {\r\n    if ( document.frmOnCallDetail.selSzCdCounty.value != \"\" )\r\n     {\r\n        submitValidateForm( \"frmOnCallDetail\", \"/workload/OnCall/displayOnCallDetail\" );\r\n     }\r\n  } \r\n  \r\n </script>\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

//*******************************************
//**** FORM (ON-CALL DETAIL) STARTS HERE ****
//*******************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmOnCallDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnUlIdOnCall");
          _jspx_th_impact_validateInput_0.setValue( hdnUlIdOnCall );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_1.setValue( hdnTsLastUpdate );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("pageName");
          _jspx_th_impact_validateInput_3.setValue( OnCallConversation.ON_CALL_DETAIL_PAGE );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

//******************************
//**** SCHEDULE INFORMATION ****
//******************************

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th colspan=\"4\">Schedule Information</th></tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Program");
          _jspx_th_impact_validateSelect_0.setName("selSzCdOnCallProgram");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CONCLPRG );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue( selSzCdOnCallProgram );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Type");
          _jspx_th_impact_validateSelect_1.setName("selSzCdOnCallType");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CONCLTYP );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( selSzCdOnCallType );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue( txtDtDtOnCallStart );
          _jspx_th_impact_validateDate_0.setName("txtDtDtOnCallStart");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setLabel("Start Time");
          _jspx_th_impact_validateTime_0.setName("txtTmOnCallStart");
          _jspx_th_impact_validateTime_0.setValue( txtTmOnCallStart );
          _jspx_th_impact_validateTime_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTime_0.setRequired("true");
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue( txtDtDtOnCallEnd );
          _jspx_th_impact_validateDate_1.setName("txtDtDtOnCallEnd");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_1.setLabel("End Time");
          _jspx_th_impact_validateTime_1.setName("txtTmOnCallEnd");
          _jspx_th_impact_validateTime_1.setValue( txtTmOnCallEnd );
          _jspx_th_impact_validateTime_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTime_1.setRequired("true");
          int _jspx_eval_impact_validateTime_1 = _jspx_th_impact_validateTime_1.doStartTag();
          if (_jspx_th_impact_validateTime_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n       ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setName("selSzCdCounty");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setExcludeOptions(excludeCounty );
          _jspx_th_impact_validateSelect_2.setValue( selSzCdCounty );
          _jspx_th_impact_validateSelect_2.setOnChange("getRegionForCountySelected()");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel(" Region");
          _jspx_th_impact_validateInput_4.setName("txtRegion");
          _jspx_th_impact_validateInput_4.setValue(selSzCdRegion );
          _jspx_th_impact_validateInput_4.setReadOnly("true");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   <td>&nbsp;</td>\r\n    </tr>\r\n  \r\n  <tr>\r\n    \r\n  </tr>\r\n  \r\n</table>\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************
//**** EMPLOYEES ****
//*******************
//SIR19889    use arrayEmpOnCallFull to disable 'Add' Button
if (ccmn09so_list != null &&
    ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty() == OnCallConversation.INT_MAX_ON_CALL_EMPLOYEES )
{
    arrayEmpOnCallFull = true;
}
if ( ccmn09so_list != null &&
     ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty() > 0 )
{
  //Display the results if the array is not empty
  Enumeration enumeration = ccmn09so_list.getROWCCMN21DO_ARRAY().enumerateROWCCMN21DO();
  if ( enumeration.hasMoreElements() )
  {
  
          out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" width=\"100%\">\r\n      <tr><th><a href=\"#goToEmployeesSection\" name=\"goToEmployeesSection\"></a>Employees</th></tr>\r\n      <tr>\r\n        <td class=\"tableBG\">\r\n          <div id=\"employeeList\" style=\"height:100px; overflow:auto\" class=\"tableborderList\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr>\r\n                <th class=\"thList\">&nbsp;</th>\r\n                <th class=\"thList\">Name</th>\r\n                <th class=\"thList\">Title</th>\r\n                <th class=\"thList\">Program</th>\r\n                <th class=\"thList\">Home Phone</th>\r\n                <th class=\"thList\">On-Call Phone</th>\r\n                <th class=\"thList\">Ext.</th>\r\n                <th class=\"thList\">OCD</th>\r\n                <th class=\"thList\">CO</th>\r\n                <th class=\"thList\">Other Phone</th>\r\n                <th class=\"thList\">Ext.</th>\r\n              </tr>\r\n              ");

              loopCounter = 0;
              ROWCCMN21DO employee = null;
              while ( enumeration.hasMoreElements() )
              {
                employee = ( ROWCCMN21DO )enumeration.nextElement();
                
          out.write("\r\n                <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCounter + 1 ) );
          out.write("\">\r\n                  <td>\r\n                    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setValue( String.valueOf( loopCounter ) );
          _jspx_th_impact_validateInput_5.setName("selectedEmployeeIndex_CLEAN");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                  </td>\r\n                  ");

                  // Employee Name.
                  // Don't provide the hyperlink if PageMode is VIEW. For the
                  // hyperlink, the 'goToOnCallEmployeeDetailPage' function call
                  // must be added to both the 'href' and the 'onclick' attribute
                  // so that the "IsDirty()" check is not performed.
                  if ( pageMode.equals( PageModeConstants.VIEW ) )
                  {
          out.write("\r\n                    <td>");
          out.print( employee.getSzNmPersonFull() );
          out.write("</td>\r\n                  ");

                  }
                  else
                  {
          out.write("\r\n                    <td><a href=\"JavaScript:goToOnCallEmployeeDetailPage(");
          out.print( loopCounter );
          out.write(");\" onClick=\"JavaScript:goToOnCallEmployeeDetailPage(");
          out.print( loopCounter );
          out.write(");\">");
          out.print( employee.getSzNmPersonFull() );
          out.write("</a></td>\r\n                  ");

                  }
                  
          out.write("\r\n                   ");

                  // Title.
                  if ( employee.getSzCdTitle() != null &&
                       !"".equals(employee.getSzCdTitle()) )
                  {
          out.write("\r\n                    <td>");
          out.print( employee.getSzCdTitle() );
          out.write("</td>\r\n                  ");

                  }
                  else
                  {
          out.write("\r\n                    <td>&nbsp;</td>\r\n                  ");

                  }
                  
          out.write("\r\n                  ");

                  // Program.
                  if ( employee.getSzCdOnCallProgram() != null &&
                       !"".equals(employee.getSzCdOnCallProgram()) )
                  {
          out.write("\r\n                    <td>");
          out.print( employee.getSzCdOnCallProgram() );
          out.write("</td>\r\n                  ");

                  }
                  else
                  {
          out.write("\r\n                    <td>&nbsp;</td>\r\n                  ");

                  }
                  
          out.write("\r\n                  ");

                  // Home Phone.
                  if ( employee.getLNbrPhone() != null &&
                       !"".equals(employee.getLNbrPhone()) )
                  {
          out.write("\r\n                    <td>");
          out.print( FormattingHelper.formatPhone( employee.getLNbrPhone() ) );
          out.write("</td>\r\n                  ");

                  }
                  else
                  {
          out.write("\r\n                    <td>&nbsp;</td>\r\n                  ");

                  }
                  
          out.write("\r\n                  ");

                  // On-Call Phone.
                  if ( employee.getSzNbrEmpOnCallPhone1() != null &&
                       !"".equals(employee.getSzNbrEmpOnCallPhone1()) )
                  {
          out.write("\r\n                    <td>");
          out.print( FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone1() ) );
          out.write("</td>\r\n                  ");

                  }
                  else
                  {
          out.write("\r\n                    <td>&nbsp;</td>\r\n                  ");

                  }
                  
          out.write("\r\n                  ");

                  //Extension1
                   if ( employee.getLNbrEmpOnCallExt1() != null &&
                       !"".equals(employee.getLNbrEmpOnCallExt1()) )
                  {
          out.write("\r\n                    <td>");
          out.print( employee.getLNbrEmpOnCallExt1() );
          out.write("</td>\r\n                   ");

                   }
                   else
                   {
          out.write("\r\n                     <td>&nbsp;</td>\r\n                   ");

                   }
                   
          out.write("  \r\n                  ");
 
                   // On Call Designation
                      
                  if ( employee.getSzCdEmpOnCallDesig() != null &&
                       !"".equals(employee.getSzCdEmpOnCallDesig()) )
                  {
          out.write("\r\n                    <td>");
          out.print( employee.getSzCdEmpOnCallDesig() );
          out.write("</td>\r\n                  ");

                   }
                   else
                   {
          out.write("\r\n                     <td>&nbsp;</td>\r\n                   ");

                   }
                   
          out.write(" \r\n                     \r\n                  <td>");
          out.print( employee.getUsNbrEmpOnCallCntctOrd() );
          out.write("</td>\r\n                  ");

                  // Other Phone.
                  if ( employee.getSzNbrEmpOnCallPhone2() != null &&
                       !"".equals(employee.getSzNbrEmpOnCallPhone2()) )
                  {
          out.write("\r\n                    <td>");
          out.print( FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone2() ) );
          out.write("</td>\r\n                  ");

                  }
                  else
                  {
          out.write("\r\n                    <td>&nbsp;</td>\r\n                  ");

                  }
                  
          out.write("\r\n                  ");
 
                  // Extension2
                   if ( employee.getLNbrEmpOnCallExt2()!= null &&
                       !"".equals(employee.getLNbrEmpOnCallExt2()) )
                  {
          out.write("\r\n                  <td>");
          out.print( employee.getLNbrEmpOnCallExt2() );
          out.write("</td>\r\n                  ");

                  }
                  else
                  {
          out.write("\r\n                    <td>&nbsp;</td>\r\n                  ");

                  }
                  
          out.write("\r\n                </tr>\r\n                ");

                loopCounter++;
              } // end while ( enumeration.hasMoreElements() )
              
          out.write("\r\n            </table>\r\n          </div>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");

  } // end if ( enumeration.hasMoreElements() )
} // end if ( ccmn09so_list != null )
else
{
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" width=\"100%\">\r\n    <tr><th><a href=\"#goToEmployeesSection\" name=\"goToEmployeesSection\"></a>Employees</th></tr>\r\n    <tr>\r\n      <td class=\"tableBG\">\r\n        ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}

          out.write("\r\n\r\n");

//*****************
//**** BUTTONS ****
//*****************
// Display these buttons only if the user has On-Call maintainer
// privileges and the PageMode is not VIEW.
if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) &&
     !pageMode.equals( PageModeConstants.VIEW ) )
{
  String saveButtonFunction = "return setButtonPressed('" + OnCallCustomValidation.SAVE_BUTTON + "')";
  
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      ");

      if ( ccmn09so_list != null &&
     ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty() > 0 )
      {
      
          out.write("\r\n        <td>\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm("frmOnCallDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/OnCall/deleteOnCallEmployee");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmRowSelected( 'delete' )");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      ");

      }
      
          out.write("\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setDisabled( String.valueOf(arrayEmpOnCallFull) );
          _jspx_th_impact_ButtonTag_1.setForm("frmOnCallDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/OnCall/addOnCallEmployee");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmOnCallDetail')");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        <hr>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName( OnCallCustomValidation.SAVE_BUTTON );
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmOnCallDetail");
          _jspx_th_impact_ButtonTag_2.setFunction( saveButtonFunction );
          _jspx_th_impact_ButtonTag_2.setAction("/workload/OnCall/saveOnCallSchedule");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

} // end if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) && !pageMode.equals( PageMode.VIEW ) )

          out.write("\r\n\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("buttonPressed");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
