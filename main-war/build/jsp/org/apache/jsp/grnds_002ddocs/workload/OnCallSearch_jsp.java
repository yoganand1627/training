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
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO;
import gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class OnCallSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
//*  JSP Name:     On-Call Search
//*  Created by:   Jason Rios
//*  Date Created: 12/09/02
//*
//*  Description:
//*  This JSP displays the On-Call Search page.
//*
//*  Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*  03/23/04  CORLEYAN          SIR 22675 -- If slashes were not entered in search
//*                              report would not launch correctly.  Use the value
//*                              of the reloaded field for the report instead of the
//*                              value in request.
//*  06/10/04  dickmaec          SIR 15168 -- The On-Call Report can be run with
//*                              multiple counites selected.  Previously a user could
//*                               only run the report with one County selected.
//*  09/01/04  dickmaec          SIR 23124- Allows the page to search the region
//*                              type of 'Statewide'
//*
//*
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
Boolean bSearchPerformed = null;
//String reportParameters = "";
String selSzCdOnCallProgram = "";
String selSzCdOnCallType = "";
String txtDtDtOnCallStart = "";
String txtTmOnCallStart = "";
String txtDtDtOnCallEnd = "";
String txtTmOnCallEnd = "";
String selSzCdRegion = "";
String selSzCdCounty = "";
List selectedCountiesVector = new ArrayList();
Map countiesToRegionHashMap = null;
//SortedMap countiesTreeMap = null;
//CodeAttributes county = null;
Map scheduleToCountiesHashMap = null;
Enumeration enum_list = null;
ROWCCMN16DO schedule = null;
java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat( "MM/dd/yyyy" );
String startDate = null;
String endDate = null;
java.util.Date tempDate = null;
String countyCode = null;
String countyString = null;

CCMN06SO ccmn06so_list = null;

Collection regionsCollection = Lookup.getCategoryCollection( CodesTables.CREGIONS );
CodeAttributes region = null;
List countiesVector = null;
Iterator regionsIterator = null;


//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//*********************
//*** SET PAGE MODE ***
//*********************
// PageMode is not used on this page. The user's security attribute is
// used instead.


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
UserProfile user = UserProfileHelper.getUserProfile( request );

countiesToRegionHashMap = ( Map )state.getAttribute( "countiesToRegionHashMap", request );
scheduleToCountiesHashMap = ( Map )state.getAttribute( "scheduleToCountiesHashMap", request );

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

if ( request.getAttribute( "bSearchPerformed" ) != null )
{
  bSearchPerformed = ( Boolean )request.getAttribute( "bSearchPerformed" );
}
//SIR 15168 - Initialize new variables.
StringBuffer counties = null;
Integer counterCounties = null;
StringBuffer decodedSelectedCountiesString = null;

//SIR 15168 - Get new variables out of the request
counties = (StringBuffer)request.getAttribute("selectedCountiesString");
counties = counties == null ? new StringBuffer() : counties;
counterCounties = (Integer)request.getAttribute("counterCountiesString");
decodedSelectedCountiesString = (StringBuffer)request.getAttribute("decodedSelectedCountiesString");

//SIR 15168 -- getting bLaunchReport from the request.  this new variable
//will allow a users to launch the on-call report if equal to true.
//if the variable is false the user will be presented with a error
//message
Boolean bLaunchReport = (Boolean) request.getAttribute( "bLaunchReport");

// The Region drop-down should default to the user's region...assuming
// the user is in Region 1-11 or Statewide. Iterate through the regions
// in the CREGIONS codes table to verify that the user is in one of
// those regions. If he is, then default the Region drop-down to that
// region; otherwise, default it to Region 1.
if ("".equals(selSzCdRegion) )
{
  if ( user.getUserRegion() != null &&
       !"".equals(user.getUserRegion()) )
  {
    regionsIterator = regionsCollection.iterator();
    while ( regionsIterator.hasNext() )
    {
      region = ( CodeAttributes )regionsIterator.next();

      if ( !region.getCode().equals( CodesTables.CREGIONS_00 ) &&
           !region.getCode().equals( CodesTables.CREGIONS_99 ) &&
           region.getCode().equals( user.getUserRegion() ) )
      {
        selSzCdRegion = user.getUserRegion();
      }
    }
  }

  // If Region is still empty, default it to Region 1.
  if ("".equals(selSzCdRegion) )
  {
    selSzCdRegion = CodesTables.CREGIONS_01;
  }
}

ccmn06so_list = ( CCMN06SO )state.getAttribute( "CCMN06SO_LIST", request );


      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onload = function ()\r\n{\r\n  ");

  // If the user just performed a search, then achor the page
  // to the On-Call Schedule listbox.
  if ( bSearchPerformed != null )
  {
      out.write("\r\n    schedulesListAnchor.click();\r\n  ");

  }

  // If the user entered all the search parameters required for
  // generating the On-Call Report, including selecting only one
  // county, and they performed a search that returned at least
  // one row, then set the report parameters to the search
  // parameter values.
  // SIR 22675 use the value from the reloaded field for the
  // date values so that they will be sent with slashes to the
  // report.
  if ( !"".equals(txtDtDtOnCallStart) &&
       !"".equals(txtDtDtOnCallEnd) &&
        //||
        //selSzCdRegion.equals( CodesTables.CREGIONS_098 ) ) &&
       ccmn06so_list != null )
  {
    //SIR 15168 -- Added the decodedSelectedCountiesString and selSzCdRegion to the
    //setHiddenReportParamsCounties function.
    
      out.write("setHiddenReportParamsCounties(\"");
      out.print( counties );
      out.write('"');
      out.write(',');
      out.write('\'');
      out.print( selSzCdOnCallProgram );
      out.write("',document.frmOnCallSearch.txtDtDtOnCallStart.value,'");
      out.print( txtTmOnCallStart );
      out.write("',document.frmOnCallSearch.txtDtDtOnCallEnd.value,'");
      out.print( txtTmOnCallEnd );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print( selSzCdRegion );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print( decodedSelectedCountiesString );
      out.write("'); ");

  }
  
      out.write("\r\n}\r\n\r\n// This function will hide all counties sections, then show the\r\n// appropriate counties section based on the region selected in\r\n// the Region drop-down.\r\nfunction showCountiesForSelectedRegion( bInitialPageLoad )\r\n{\r\n  var divArray = document.getElementsByTagName(\"div\");\r\n  for ( i = 0; i < divArray.length; i++ )\r\n  {\r\n    if ( divArray[i].id.substr(0, 6) == \"region\" )\r\n    {\r\n      divArray[i].style.display = \"none\";\r\n    }\r\n  }\r\n\r\n  if ( document.frmOnCallSearch.selSzCdRegion.value != \"\" )\r\n  {\r\n    // Deselect any previously selected counties for the selected\r\n    // region since the user just now changed regions to this region.\r\n    if ( bInitialPageLoad == false &&\r\n         document.frmOnCallSearch.selSzCdRegion.value != \"");
      out.print( CodesTables.CREGIONS_98 );
      out.write("\" )\r\n    {\r\n      selectAllDisplayedCounties( false );\r\n    }\r\n\r\n    // Show the selected region.\r\n    var divNameToDisplay = \"region\" + document.frmOnCallSearch.selSzCdRegion.value + \"Counties\";\r\n    toggleVisibility( divNameToDisplay, \"block\" );\r\n  }\r\n  return true;\r\n}\r\n\r\n// This function is called when user clicks 'Select All' or 'Deselect\r\n// All' button. Function will select all or deselect all the counties\r\n// for the region.\r\n// function selectAllDisplayedCounties( action )\r\n\r\n\r\n// This function confirms that the user has selected a row in\r\n// the list box before continuing with the 'Delete' or 'New Using'\r\n// procedure.\r\nfunction confirmRowSelected( buttonClicked )\r\n{\r\n  var rowSelected = false;\r\n  var rowsReturned = ");
      out.print( (ccmn06so_list != null) );
      out.write(";\r\n\r\n  if ( rowsReturned )\r\n  {\r\n    // If the radio button group is an array (i.e., more than one\r\n    // radio button), then loop through the array and check for a\r\n    // selected radio button; otherwise, check the single radio\r\n    // button to see if it is selected.\r\n    if ( document.frmOnCallSchedules.rbUlIdOnCall[0] )\r\n    {\r\n      for (var i = 0; i < document.frmOnCallSchedules.rbUlIdOnCall.length; i++)\r\n      {\r\n        if ( document.frmOnCallSchedules.rbUlIdOnCall[i].checked )\r\n        {\r\n          rowSelected = true;\r\n          break;\r\n        }\r\n      }\r\n    }\r\n    else\r\n    {\r\n      if ( document.frmOnCallSchedules.rbUlIdOnCall.checked )\r\n      {\r\n        rowSelected = true;\r\n      }\r\n    }\r\n  }\r\n\r\n  // Handle a 'Delete' click.\r\n  if ( buttonClicked == \"delete\" )\r\n  {\r\n    if ( rowSelected == false )\r\n    {\r\n      alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("\" );\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      document.frmOnCallSchedules.buttonPressed.value = \"");
      out.print( OnCallCustomValidation.DELETE_BUTTON_ON_SEARCH_PAGE );
      out.write("\";\r\n      return confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\" );\r\n    }\r\n  }\r\n  // Handle a 'New Using' click.\r\n  else if ( buttonClicked == \"new using\")\r\n  {\r\n    if ( rowSelected == false )\r\n    {\r\n      alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("\" );\r\n      return false;\r\n    }\r\n    else\r\n    {\r\n      document.frmOnCallSchedules.pageMode.value = \"");
      out.print( PageModeConstants.NEW_USING );
      out.write("\";\r\n      return true;\r\n    }\r\n  }\r\n  return false;\r\n}\r\n\r\n// To launch the On-Call Report, the user must first select a schedule\r\n// in the listbox. When the schedule is selected, this function will be\r\n// called to set the report parameters to the selected row's values\r\n// NOTE: The report parameters are stored in hidden fields. When the\r\n// user clicks the Launch button, the setHiddenReportParamsCounties() function\r\n// will be called to pass the report parameters to the report architecture.\r\n \r\n//SIR 15168 - Added hdnRegionReportParam and hdnCountiesDecodeReportParam to the\r\n//setHiddenReportParamsCounties function\r\n\r\nfunction setHiddenReportParamsCounties( counties, program, startDate, startTime, endDate, endTime, region, countiesDecode)\r\n{\r\n  document.frmOnCallSchedules.hdnCountiesReportParam.value = counties;\r\n  document.frmOnCallSchedules.hdnProgramReportParam.value = program;\r\n  document.frmOnCallSchedules.hdnStartDateReportParam.value = startDate;\r\n  document.frmOnCallSchedules.hdnStartTimeReportParam.value = startTime;\r\n");
      out.write("  document.frmOnCallSchedules.hdnEndDateReportParam.value = endDate;\r\n  document.frmOnCallSchedules.hdnEndTimeReportParam.value = endTime;\r\n  document.frmOnCallSchedules.hdnRegionReportParam.value = region;\r\n  document.frmOnCallSchedules.hdnCountiesDecodeReportParam.value = countiesDecode;\r\n}\r\n \r\n// This function passes the report parameters to the report architecture.\r\nfunction createReportParameterList()\r\n{\r\n  //SIR 15168 - setting the bLaunchReport to a javascript variable\r\n  var bLaunchReport = ");
      out.print( bLaunchReport );
      out.write(";\r\n  \r\n  document.frmOnCallSchedules.hdnProgramReportParam.value='CPS';\r\n  alert('BLaunchReport='+bLaunchReport);\r\n  alert('hdnStartDateReportParam='+document.frmOnCallSchedules.hdnStartDateReportParam.value);\r\n  alert('hdnEndDateReportParam='+document.frmOnCallSchedules.hdnEndDateReportParam.value);\r\n  alert('hdnCountiesReportParam='+document.frmOnCallSchedules.hdnCountiesReportParam.value);\r\n  alert('hdnCountiesDecodeReportParam='+document.frmOnCallSchedules.hdnCountiesDecodeReportParam.value);\r\n  alert('hdnProgramReportParam='+document.frmOnCallSchedules.hdnProgramReportParam.value);\r\n\r\n  //SIR 15169 - changed the name of hdnCountyReportParam to hdnCountiesReportParam\r\n  if (   document.frmOnCallSchedules.hdnStartDateReportParam.value == \"\" ||\r\n         document.frmOnCallSchedules.hdnEndDateReportParam.value == \"\" ||\r\n         document.frmOnCallSchedules.hdnCountiesReportParam.value == \"\" )\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CMN_ONCALL_RPT ) );
      out.write("');\r\n    return false;\r\n  }\r\n  //SIR 15168 - verifies that the user is allowed to launch the on-call report\r\n  else if ( bLaunchReport == false )\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CMN_MULT_ONCALL_RPT ) );
      out.write("');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    //SIR 15168 - changed the county to counties since multiple counties can\r\n    //be passed to the SQR Report.\r\n    setReportParameters(\"counties\", document.frmOnCallSchedules.hdnCountiesReportParam.value);\r\n    addReportParameter(\"program\", document.frmOnCallSchedules.hdnProgramReportParam.value);\r\n    addReportParameter(\"startDate\", document.frmOnCallSchedules.hdnStartDateReportParam.value);\r\n\r\n    if ( document.frmOnCallSchedules.hdnStartTimeReportParam.value != \"\" )\r\n    {\r\n      addReportParameter(\"startTime\", document.frmOnCallSchedules.hdnStartTimeReportParam.value);\r\n      \r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"startTime\", \"12:00 AM\");\r\n    }\r\n\r\n    addReportParameter(\"endDate\", document.frmOnCallSchedules.hdnEndDateReportParam.value);\r\n\r\n    if ( document.frmOnCallSchedules.hdnStartTimeReportParam.value != \"\" )\r\n    {\r\n      addReportParameter(\"endTime\", document.frmOnCallSchedules.hdnEndTimeReportParam.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"endTime\", \"11:59 PM\");\r\n");
      out.write("    }\r\n      //SIR 15168 - added these parameters to the report hidden report function.\r\n      addReportParameter(\"region\", document.frmOnCallSchedules.hdnRegionReportParam.value);\r\n      addReportParameter(\"countiesDecode\", document.frmOnCallSchedules.hdnCountiesDecodeReportParam.value);\r\n\r\n    return true;\r\n  }\r\n  return false;\r\n}\r\n\r\nfunction goToOnCallDetailPage( selectedOnCallId )\r\n{\r\n  setState('frmOnCallSchedules');\r\n  setValidationUrl('frmOnCallSchedules', '/workload/OnCall/displayOnCallDetail');\r\n  document.frmOnCallSchedules.pageMode.value = \"");
      out.print( PageModeConstants.MODIFY );
      out.write("\";\r\n  // Mark the radio button that corresponds to the row selected\r\n  // by the user as 'checked'. That way, the radio button group\r\n  // will have a value on the conversation.\r\n  if ( document.frmOnCallSchedules.rbUlIdOnCall[0] )\r\n  {\r\n    for (var i = 0; i < document.frmOnCallSchedules.rbUlIdOnCall.length; i++)\r\n    {\r\n      if ( document.frmOnCallSchedules.rbUlIdOnCall[i].value == selectedOnCallId )\r\n      {\r\n        document.frmOnCallSchedules.rbUlIdOnCall[i].checked = true;\r\n        break;\r\n      }\r\n    }\r\n  }\r\n  else\r\n  {\r\n    document.frmOnCallSchedules.rbUlIdOnCall.checked = true;\r\n  }\r\n  document.frmOnCallSchedules.submit();\r\n}\r\n\r\nfunction setButtonPressed( buttonName )\r\n{\r\n  validateTime();\r\n  document.frmOnCallSearch.buttonPressed.value = buttonName;\r\n  return true;\r\n}\r\n</script>\r\n\r\n");

//*************************
//*** VALIDATION ERRORS ***
//*************************

      out.write('\r');
      out.write('\n');
/* Include custom tag for displaying errors on the page */
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

//****************************************
//**** FORM (SEARCH INFO) STARTS HERE ****
//****************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmOnCallSearch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/OnCall/displayOnCallSearch");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");

//****************************
//**** SEARCH INFORMATION ****
//****************************

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th colspan=\"4\">Search Information</th></tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setName("selSzCdOnCallType");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CONCLTYP );
          _jspx_th_impact_validateSelect_0.setValue( selSzCdOnCallType );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          _jspx_th_impact_validateTime_1.setDefaultAmPm("PM");
          _jspx_th_impact_validateTime_1.setValue( txtTmOnCallEnd );
          _jspx_th_impact_validateTime_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateTime_1 = _jspx_th_impact_validateTime_1.doStartTag();
          if (_jspx_th_impact_validateTime_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setName("selSzCdCounty");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( selSzCdCounty );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n</table>\r\n\r\n<script language=\"javascript\" type=\"text/javascript\">\r\n<!--\r\nfunction validateTime()\r\n{\r\nif (document.frmOnCallSearch.txtDtDtOnCallStart.value != \"\" || document.frmOnCallSearch.txtDtDtOnCallStart.value == !null)\r\n {\r\n\r\n if ( document.frmOnCallSearch.txtTmOnCallStart.value == \"\" || document.frmOnCallSearch.txtTmOnCallStart.value == null )\r\n    {\r\n      document.frmOnCallSearch.txtTmOnCallStart.value = \"12:00\";\r\n      document.frmOnCallSearch.seltxtTmOnCallStart.value = \"AM\"\r\n    }\r\n }\r\nif (document.frmOnCallSearch.txtDtDtOnCallEnd.value != \"\" || document.frmOnCallSearch.txtDtDtOnCallEnd.value == !null)\r\n {\r\n \r\n if ( document.frmOnCallSearch.txtTmOnCallEnd.value == \"\" || document.frmOnCallSearch.txtTmOnCallEnd.value == null)\r\n    {\r\n      document.frmOnCallSearch.txtTmOnCallEnd.value = \"11:59\";\r\n      document.frmOnCallSearch.seltxtTmOnCallEnd.value = \"PM\"\r\n    }\r\n }\r\n}\r\n-->\r\n</script>\r\n\r\n");

//*****************
//**** BUTTONS ****
//*****************
String searchButtonFunction = "return setButtonPressed('" + OnCallCustomValidation.SEARCH_BUTTON + "')";

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"100%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName( OnCallCustomValidation.SEARCH_BUTTON );
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmOnCallSearch");
          _jspx_th_impact_ButtonTag_0.setFunction( searchButtonFunction );
          _jspx_th_impact_ButtonTag_0.setAction("/workload/OnCall/searchOnCallSchedules");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        \r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

//**************************************
//**** FORM (SEARCH INFO) ENDS HERE ****
//**************************************

      out.write("\r\n\r\n");

//**********************************************
//**** FORM (ON-CALL SCHEDULES) STARTS HERE ****
//**********************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmOnCallSchedules");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/workload/OnCall/displayOnCallSearch");
      _jspx_th_impact_validateForm_1.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation");
      _jspx_th_impact_validateForm_1.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

   //SIR 15168 - Created new validate input fields.

          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n\r\n");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("pageName");
          _jspx_th_impact_validateInput_11.setValue( OnCallConversation.ON_CALL_SEARCH_PAGE );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

//************************
//**** SEARCH RESULTS ****
//************************
if ( ccmn06so_list != null )
{

  // Adjust the height of the table based on the number of rows to
  // be displayed. 300px is max.
  int sectionHeight = 30 * (1 + ccmn06so_list.getROWCCMN16DO_ARRAY().getUlRowQty());
  if ( sectionHeight > 300 )
  {
    sectionHeight = 300;
  }
  
          out.write("\r\n\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSubmitUrl("/workload/OnCall/searchOnCallSchedules");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" width=\"100%\">\r\n    <tr>\r\n      <th>\r\n        <a href=\"#schedulesListAnchor\" name=\"schedulesListAnchor\"></a>\r\n        On-Call Schedule\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td class=\"subDetail\">\r\n        <div id=\"scheduleSearchResults\" style=\"height:");
              out.print( sectionHeight );
              out.write("px; overflow:auto\" class=\"tableborderList\">\r\n          <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n            <tr>\r\n              <th class=\"thList\">&nbsp;</th>\r\n              <th class=\"thList\">County</th>\r\n              <th class=\"thList\">Program</th>\r\n              <th class=\"thList\">Start Date</th>\r\n              <th class=\"thList\">Start Time</th>\r\n              <th class=\"thList\">End Date</th>\r\n              <th class=\"thList\">End Time</th>\r\n              <th class=\"thList\">Type</th>\r\n            </tr>\r\n\r\n            ");

            enum_list = ccmn06so_list.getROWCCMN16DO_ARRAY().enumerateROWCCMN16DO();
            while ( enum_list.hasMoreElements() )
            {
              schedule = ( ROWCCMN16DO )enum_list.nextElement();
              tempDate = schedule.getDtDtOnCallStart().toDate();
              startDate = dateFormatter.format( tempDate );
              tempDate = schedule.getDtDtOnCallEnd().toDate();
              endDate = dateFormatter.format( tempDate );
              countyCode = ( String )scheduleToCountiesHashMap.get(schedule.getUlIdOnCall() );
              if ( countyCode.equals( OnCallConversation.ALL_COUNTIES_COUNTY_CODE ) )
              {
                countyString = OnCallConversation.ALL_COUNTIES_COUNTY_DECODE;
              }
              else if ( countyCode.equals( OnCallConversation.MULTIPLE_COUNTIES_CODE ) )
              {
                countyString = OnCallConversation.MULTIPLE_COUNTIES_DECODE;
              }
              else
              {
                countyString = Lookup.simpleDecode( CodesTables.CCOUNT, countyCode );
              }
              
              out.write("\r\n              <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCounter + 1 ) );
              out.write("\">\r\n                <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_12.setType("radio");
              _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_12.setValue( String.valueOf( schedule.getUlIdOnCall() ) );
              _jspx_th_impact_validateInput_12.setName("rbUlIdOnCall");
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n                <td>");
              out.print( countyString );
              out.write("</td>\r\n                <td>");
              out.print( schedule.getSzCdOnCallProgram() );
              out.write("</td>\r\n                ");

                java.util.Date now = new java.util.Date();
                java.util.Date jEndDate = DateHelper.toJavaDateSafe(schedule.getDtDtOnCallEnd(), schedule.getTmOnCallEnd());
                if ( now.compareTo(jEndDate) < 0 )
                {
              out.write("\r\n                  <td><a href=\"JavaScript:goToOnCallDetailPage(");
              out.print( String.valueOf( schedule.getUlIdOnCall() ) );
              out.write(");\">");
              out.print( startDate );
              out.write("</a></td>\r\n                ");

                }
                // details cannot be displayed for expired shifts/blocks. If the
                // schedule has already ended, give the user an error message if
                // they try to view the details.
                else
                {
              out.write("\r\n                  <td><a href=\"JavaScript:alert('");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_ONCALL_EXPIRED_ROW ) );
              out.write("');\" tabIndex=\"-1\">");
              out.print( startDate );
              out.write("</a></td>\r\n                ");

                }
                
              out.write("\r\n                <td>");
              out.print( schedule.getTmOnCallStart() );
              out.write("</td>\r\n                <td>");
              out.print( endDate );
              out.write("</td>\r\n                <td>");
              out.print( schedule.getTmOnCallEnd() );
              out.write("</td>\r\n                <td>");
              out.print( Lookup.simpleDecodeSafe( CodesTables.CONCLTYP, schedule.getSzCdOnCallType() ) );
              out.write("</td>\r\n              </tr>\r\n              ");

              loopCounter++;
            } // end while ( enum_list.hasMoreElements() )
            
              out.write("\r\n\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

}
else
{
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" width=\"100%\">\r\n    <tr>\r\n      <th>\r\n        <a href=\"#schedulesListAnchor\" name=\"schedulesListAnchor\"></a>\r\n        On-Call Schedules\r\n      </th>\r\n    </tr>\r\n    ");

    // If a search was performed and no rows were returned, display
    // as appropriate message to the user.
    if ( bSearchPerformed != null )
    {
          out.write("\r\n      <tr><td class=\"subDetail\">");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_NO_ROWS_RETURNED ) );
          out.write("</td></tr>\r\n    ");

    }
    else
    {
          out.write("\r\n      <tr><td class=\"subDetail\">&nbsp;</td></tr>\r\n    ");

    }
    
          out.write("\r\n  </table>\r\n");

} // end if ( ccmn06so_list != null )

          out.write('\r');
          out.write('\n');

//*****************
//**** BUTTONS ****
//*****************
// Display these buttons only if the user has On-Call maintainer
// privileges.
if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) )
{

          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td width=\"100%\">\r\n");

    // If rows were returned, provide a Delete button, a New Using
    // button and an Add button; otherwise, provide only an Add
    // button.
    if ( ccmn06so_list != null)
    {

          out.write('\r');
          out.write('\n');
          out.write("\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmOnCallSchedules");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/OnCall/displayOnCallDetail");
          _jspx_th_impact_ButtonTag_1.setFunction("return confirmRowSelected( 'new using' )");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n");

    }

          out.write("\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnAdd");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmOnCallSchedules");
          _jspx_th_impact_ButtonTag_2.setAction("/workload/OnCall/addOnCallSchedule");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

} // end if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) )

          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

//********************************************
//**** FORM (ON-CALL SCHEDULES) ENDS HERE ****
//********************************************

      out.write("\r\n\r\n");

//*****************
//**** REPORTS ****
//*****************
// This report requires the following parameters: County, Program, Start
// Date, Start Time, End Date and End Time. To generate this report,
// the user must do one of the following: 1) Enter values for the required
// parameters in the fields on this page, then click the Launch button, or
// 2) Enter search parameters in the fields on this page, then perform a
// search that returns matching schedules, then select one of the matching
// schedules, then click the Launch button. The parameters for this report
// will be set dynamically using JavaScript.


      out.write("\r\n<br>\r\n");
 String county = ( (selectedCountiesVector != null) && !selectedCountiesVector.isEmpty() ) ? (String) selectedCountiesVector.get(0) : "" ;
//SIR 15168 - Changed the description of the email message.  If the user
//searches on a SIngle county the message will displa as "County - 001 Program
//- APS".  And if it is a multiple county search the message will display
//as "Multiple Counties. Program - APS".

String emailMessage = "";

if (counties.length() == 3)
{
  emailMessage = "County - " + counties.toString() + " Program - " +  selSzCdOnCallProgram;
}
else
{
  emailMessage = "Multiple Counties. Program - " + selSzCdOnCallProgram;
}

      out.write("\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("buttonPressed");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnCountiesReportParam");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnProgramReportParam");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnStartDateReportParam");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnStartTimeReportParam");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnEndDateReportParam");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnEndTimeReportParam");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnRegionReportParam");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("hdnCountiesDecodeReportParam");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("pageMode");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("buttonPressed");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
