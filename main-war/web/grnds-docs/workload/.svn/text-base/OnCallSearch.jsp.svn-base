<%
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
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>



<%
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

%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onload = function ()
{
  <%
  // If the user just performed a search, then achor the page
  // to the On-Call Schedule listbox.
  if ( bSearchPerformed != null )
  {%>
    schedulesListAnchor.click();
  <%
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
    %>setHiddenReportParamsCounties("<%= counties %>",'<%= selSzCdOnCallProgram %>',document.frmOnCallSearch.txtDtDtOnCallStart.value,'<%= txtTmOnCallStart %>',document.frmOnCallSearch.txtDtDtOnCallEnd.value,'<%= txtTmOnCallEnd %>','<%= selSzCdRegion %>','<%= decodedSelectedCountiesString %>'); <%
  }
  %>
}

// This function will hide all counties sections, then show the
// appropriate counties section based on the region selected in
// the Region drop-down.
function showCountiesForSelectedRegion( bInitialPageLoad )
{
  var divArray = document.getElementsByTagName("div");
  for ( i = 0; i < divArray.length; i++ )
  {
    if ( divArray[i].id.substr(0, 6) == "region" )
    {
      divArray[i].style.display = "none";
    }
  }

  if ( document.frmOnCallSearch.selSzCdRegion.value != "" )
  {
    // Deselect any previously selected counties for the selected
    // region since the user just now changed regions to this region.
    if ( bInitialPageLoad == false &&
         document.frmOnCallSearch.selSzCdRegion.value != "<%= CodesTables.CREGIONS_98 %>" )
    {
      selectAllDisplayedCounties( false );
    }

    // Show the selected region.
    var divNameToDisplay = "region" + document.frmOnCallSearch.selSzCdRegion.value + "Counties";
    toggleVisibility( divNameToDisplay, "block" );
  }
  return true;
}

// This function is called when user clicks 'Select All' or 'Deselect
// All' button. Function will select all or deselect all the counties
// for the region.
// function selectAllDisplayedCounties( action )


// This function confirms that the user has selected a row in
// the list box before continuing with the 'Delete' or 'New Using'
// procedure.
function confirmRowSelected( buttonClicked )
{
  var rowSelected = false;
  var rowsReturned = <%= (ccmn06so_list != null) %>;

  if ( rowsReturned )
  {
    // If the radio button group is an array (i.e., more than one
    // radio button), then loop through the array and check for a
    // selected radio button; otherwise, check the single radio
    // button to see if it is selected.
    if ( document.frmOnCallSchedules.rbUlIdOnCall[0] )
    {
      for (var i = 0; i < document.frmOnCallSchedules.rbUlIdOnCall.length; i++)
      {
        if ( document.frmOnCallSchedules.rbUlIdOnCall[i].checked )
        {
          rowSelected = true;
          break;
        }
      }
    }
    else
    {
      if ( document.frmOnCallSchedules.rbUlIdOnCall.checked )
      {
        rowSelected = true;
      }
    }
  }

  // Handle a 'Delete' click.
  if ( buttonClicked == "delete" )
  {
    if ( rowSelected == false )
    {
      alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>" );
      return false;
    }
    else
    {
      document.frmOnCallSchedules.buttonPressed.value = "<%= OnCallCustomValidation.DELETE_BUTTON_ON_SEARCH_PAGE %>";
      return confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>" );
    }
  }
  // Handle a 'New Using' click.
  else if ( buttonClicked == "new using")
  {
    if ( rowSelected == false )
    {
      alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>" );
      return false;
    }
    else
    {
      document.frmOnCallSchedules.pageMode.value = "<%= PageModeConstants.NEW_USING %>";
      return true;
    }
  }
  return false;
}

// To launch the On-Call Report, the user must first select a schedule
// in the listbox. When the schedule is selected, this function will be
// called to set the report parameters to the selected row's values
// NOTE: The report parameters are stored in hidden fields. When the
// user clicks the Launch button, the setHiddenReportParamsCounties() function
// will be called to pass the report parameters to the report architecture.
 
//SIR 15168 - Added hdnRegionReportParam and hdnCountiesDecodeReportParam to the
//setHiddenReportParamsCounties function

function setHiddenReportParamsCounties( counties, program, startDate, startTime, endDate, endTime, region, countiesDecode)
{
  document.frmOnCallSchedules.hdnCountiesReportParam.value = counties;
  document.frmOnCallSchedules.hdnProgramReportParam.value = program;
  document.frmOnCallSchedules.hdnStartDateReportParam.value = startDate;
  document.frmOnCallSchedules.hdnStartTimeReportParam.value = startTime;
  document.frmOnCallSchedules.hdnEndDateReportParam.value = endDate;
  document.frmOnCallSchedules.hdnEndTimeReportParam.value = endTime;
  document.frmOnCallSchedules.hdnRegionReportParam.value = region;
  document.frmOnCallSchedules.hdnCountiesDecodeReportParam.value = countiesDecode;
}
 
// This function passes the report parameters to the report architecture.
function createReportParameterList()
{
  //SIR 15168 - setting the bLaunchReport to a javascript variable
  var bLaunchReport = <%= bLaunchReport %>;
  
  document.frmOnCallSchedules.hdnProgramReportParam.value='CPS';
  alert('BLaunchReport='+bLaunchReport);
  alert('hdnStartDateReportParam='+document.frmOnCallSchedules.hdnStartDateReportParam.value);
  alert('hdnEndDateReportParam='+document.frmOnCallSchedules.hdnEndDateReportParam.value);
  alert('hdnCountiesReportParam='+document.frmOnCallSchedules.hdnCountiesReportParam.value);
  alert('hdnCountiesDecodeReportParam='+document.frmOnCallSchedules.hdnCountiesDecodeReportParam.value);
  alert('hdnProgramReportParam='+document.frmOnCallSchedules.hdnProgramReportParam.value);

  //SIR 15169 - changed the name of hdnCountyReportParam to hdnCountiesReportParam
  if (   document.frmOnCallSchedules.hdnStartDateReportParam.value == "" ||
         document.frmOnCallSchedules.hdnEndDateReportParam.value == "" ||
         document.frmOnCallSchedules.hdnCountiesReportParam.value == "" )
  {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_CMN_ONCALL_RPT ) %>');
    return false;
  }
  //SIR 15168 - verifies that the user is allowed to launch the on-call report
  else if ( bLaunchReport == false )
  {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_CMN_MULT_ONCALL_RPT ) %>');
    return false;
  }
  else
  {
    //SIR 15168 - changed the county to counties since multiple counties can
    //be passed to the SQR Report.
    setReportParameters("counties", document.frmOnCallSchedules.hdnCountiesReportParam.value);
    addReportParameter("program", document.frmOnCallSchedules.hdnProgramReportParam.value);
    addReportParameter("startDate", document.frmOnCallSchedules.hdnStartDateReportParam.value);

    if ( document.frmOnCallSchedules.hdnStartTimeReportParam.value != "" )
    {
      addReportParameter("startTime", document.frmOnCallSchedules.hdnStartTimeReportParam.value);
      
    }
    else
    {
      addReportParameter("startTime", "12:00 AM");
    }

    addReportParameter("endDate", document.frmOnCallSchedules.hdnEndDateReportParam.value);

    if ( document.frmOnCallSchedules.hdnStartTimeReportParam.value != "" )
    {
      addReportParameter("endTime", document.frmOnCallSchedules.hdnEndTimeReportParam.value);
    }
    else
    {
      addReportParameter("endTime", "11:59 PM");
    }
      //SIR 15168 - added these parameters to the report hidden report function.
      addReportParameter("region", document.frmOnCallSchedules.hdnRegionReportParam.value);
      addReportParameter("countiesDecode", document.frmOnCallSchedules.hdnCountiesDecodeReportParam.value);

    return true;
  }
  return false;
}

function goToOnCallDetailPage( selectedOnCallId )
{
  setState('frmOnCallSchedules');
  setValidationUrl('frmOnCallSchedules', '/workload/OnCall/displayOnCallDetail');
  document.frmOnCallSchedules.pageMode.value = "<%= PageModeConstants.MODIFY %>";
  // Mark the radio button that corresponds to the row selected
  // by the user as 'checked'. That way, the radio button group
  // will have a value on the conversation.
  if ( document.frmOnCallSchedules.rbUlIdOnCall[0] )
  {
    for (var i = 0; i < document.frmOnCallSchedules.rbUlIdOnCall.length; i++)
    {
      if ( document.frmOnCallSchedules.rbUlIdOnCall[i].value == selectedOnCallId )
      {
        document.frmOnCallSchedules.rbUlIdOnCall[i].checked = true;
        break;
      }
    }
  }
  else
  {
    document.frmOnCallSchedules.rbUlIdOnCall.checked = true;
  }
  document.frmOnCallSchedules.submit();
}

function setButtonPressed( buttonName )
{
  validateTime();
  document.frmOnCallSearch.buttonPressed.value = buttonName;
  return true;
}
</script>

<%
//*************************
//*** VALIDATION ERRORS ***
//*************************
%>
<%/* Include custom tag for displaying errors on the page */%>
<impact:validateErrors/>

<%
//****************************************
//**** FORM (SEARCH INFO) STARTS HERE ****
//****************************************
%>
<impact:validateForm
  name="frmOnCallSearch"
  method="post"
  action="/workload/OnCall/displayOnCallSearch"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation"
  pageMode="<%= PageModeConstants.EDIT %>"
  schema="/WEB-INF/Constraints.xsd">

<impact:validateInput
  type="hidden"
  name="buttonPressed"
  value=""/>

<%
//****************************
//**** SEARCH INFORMATION ****
//****************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th colspan="4">Search Information</th></tr>
  <tr>
    <td>
      <impact:validateSelect
        label="Type"
        name="selSzCdOnCallType"
        tabIndex="<%= tabIndex++ %>"
        codesTable="<%= CodesTables.CONCLTYP %>"
        value="<%= selSzCdOnCallType %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDate
        label="Start Date"
        type="text"
        size="10"
        value="<%= txtDtDtOnCallStart %>"
        name="txtDtDtOnCallStart"
        tabIndex="<%= tabIndex++ %>"
        constraint="Date"/>
    </td>
    <td>
      <impact:validateTime
        label="Start Time"
        name="txtTmOnCallStart"
        value="<%= txtTmOnCallStart %>"
        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDate
        label="End Date"
        type="text"
        size="10"
        value="<%= txtDtDtOnCallEnd %>"
        name="txtDtDtOnCallEnd"
        tabIndex="<%= tabIndex++ %>"
        constraint="Date"/>
    </td>
    <td>
      <impact:validateTime
        label="End Time"
        name="txtTmOnCallEnd"
        defaultAmPm="PM"
        value="<%= txtTmOnCallEnd %>"
        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        label="County"
        name="selSzCdCounty"
        tabIndex="<%= tabIndex++ %>"
        codesTable="<%= CodesTables.CCOUNT %>"
        required="true"
        value="<%= selSzCdCounty %>"/>
    </td>
    <td>&nbsp;</td>
  </tr>
</table>

<script language="javascript" type="text/javascript">
<!--
function validateTime()
{
if (document.frmOnCallSearch.txtDtDtOnCallStart.value != "" || document.frmOnCallSearch.txtDtDtOnCallStart.value == !null)
 {

 if ( document.frmOnCallSearch.txtTmOnCallStart.value == "" || document.frmOnCallSearch.txtTmOnCallStart.value == null )
    {
      document.frmOnCallSearch.txtTmOnCallStart.value = "12:00";
      document.frmOnCallSearch.seltxtTmOnCallStart.value = "AM"
    }
 }
if (document.frmOnCallSearch.txtDtDtOnCallEnd.value != "" || document.frmOnCallSearch.txtDtDtOnCallEnd.value == !null)
 {
 
 if ( document.frmOnCallSearch.txtTmOnCallEnd.value == "" || document.frmOnCallSearch.txtTmOnCallEnd.value == null)
    {
      document.frmOnCallSearch.txtTmOnCallEnd.value = "11:59";
      document.frmOnCallSearch.seltxtTmOnCallEnd.value = "PM"
    }
 }
}
-->
</script>

<%
//*****************
//**** BUTTONS ****
//*****************
String searchButtonFunction = "return setButtonPressed('" + OnCallCustomValidation.SEARCH_BUTTON + "')";
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td width="100%">
      <impact:ButtonTag
        name="<%= OnCallCustomValidation.SEARCH_BUTTON %>"
        img="btnSearch"
        align="right"
        form="frmOnCallSearch"
        function="<%= searchButtonFunction %>"
        action="/workload/OnCall/searchOnCallSchedules"
        tabIndex="<%= tabIndex++ %>"/>
        
    </td>
  </tr>
</table>
<br>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
//**************************************
//**** FORM (SEARCH INFO) ENDS HERE ****
//**************************************
%>

<%
//**********************************************
//**** FORM (ON-CALL SCHEDULES) STARTS HERE ****
//**********************************************
%>
<impact:validateForm
  name="frmOnCallSchedules"
  method="post"
  action="/workload/OnCall/displayOnCallSearch"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation"
  pageMode="<%= PageModeConstants.EDIT %>"
  schema="/WEB-INF/Constraints.xsd">
<%
   //SIR 15168 - Created new validate input fields.
%>
<impact:validateInput type="hidden" name="hdnCountiesReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnProgramReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnStartDateReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnStartTimeReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnEndDateReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnEndTimeReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnRegionReportParam" value=""/>
<impact:validateInput type="hidden" name="hdnCountiesDecodeReportParam" value=""/>


<impact:validateInput
  type="hidden"
  name="pageMode"
  value=""/>

<impact:validateInput
  type="hidden"
  name="buttonPressed"
  value=""/>

<impact:validateInput
  type="hidden"
  name="pageName"
  value="<%= OnCallConversation.ON_CALL_SEARCH_PAGE %>"/>

<%
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
  %>

  <impact:pagination submitUrl="/workload/OnCall/searchOnCallSchedules">

  <table border="0" cellspacing="0" cellpadding="3" class="tableborder" width="100%">
    <tr>
      <th>
        <a href="#schedulesListAnchor" name="schedulesListAnchor"></a>
        On-Call Schedule
      </th>
    </tr>
    <tr>
      <td class="subDetail">
        <div id="scheduleSearchResults" style="height:<%= sectionHeight %>px; overflow:auto" class="tableborderList">
          <table border="0" cellpadding="3" cellspacing="0" width="100%">
            <tr>
              <th class="thList">&nbsp;</th>
              <th class="thList">County</th>
              <th class="thList">Program</th>
              <th class="thList">Start Date</th>
              <th class="thList">Start Time</th>
              <th class="thList">End Date</th>
              <th class="thList">End Time</th>
              <th class="thList">Type</th>
            </tr>

            <%
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
              %>
              <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
                <td>
                  <impact:validateInput
                    type="radio"
                    tabIndex="<%= tabIndex++ %>"
                    value="<%= String.valueOf( schedule.getUlIdOnCall() ) %>"
                    name="rbUlIdOnCall"
                    cssClass="formInput"/>
                </td>
                <td><%= countyString %></td>
                <td><%= schedule.getSzCdOnCallProgram() %></td>
                <%
                java.util.Date now = new java.util.Date();
                java.util.Date jEndDate = DateHelper.toJavaDateSafe(schedule.getDtDtOnCallEnd(), schedule.getTmOnCallEnd());
                if ( now.compareTo(jEndDate) < 0 )
                {%>
                  <td><a href="JavaScript:goToOnCallDetailPage(<%= String.valueOf( schedule.getUlIdOnCall() ) %>);"><%= startDate %></a></td>
                <%
                }
                // details cannot be displayed for expired shifts/blocks. If the
                // schedule has already ended, give the user an error message if
                // they try to view the details.
                else
                {%>
                  <td><a href="JavaScript:alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_ONCALL_EXPIRED_ROW ) %>');" tabIndex="-1"><%= startDate %></a></td>
                <%
                }
                %>
                <td><%= schedule.getTmOnCallStart() %></td>
                <td><%= endDate %></td>
                <td><%= schedule.getTmOnCallEnd() %></td>
                <td><%= Lookup.simpleDecodeSafe( CodesTables.CONCLTYP, schedule.getSzCdOnCallType() ) %></td>
              </tr>
              <%
              loopCounter++;
            } // end while ( enum_list.hasMoreElements() )
            %>

          </table>
        </div>
      </td>
    </tr>
  </table>

  </impact:pagination>
<%
}
else
{%>
  <table border="0" cellspacing="0" cellpadding="3" class="tableborder" width="100%">
    <tr>
      <th>
        <a href="#schedulesListAnchor" name="schedulesListAnchor"></a>
        On-Call Schedules
      </th>
    </tr>
    <%
    // If a search was performed and no rows were returned, display
    // as appropriate message to the user.
    if ( bSearchPerformed != null )
    {%>
      <tr><td class="subDetail"><%= MessageLookup.getMessageByNumber( Messages.MSG_NO_ROWS_RETURNED ) %></td></tr>
    <%
    }
    else
    {%>
      <tr><td class="subDetail">&nbsp;</td></tr>
    <%
    }
    %>
  </table>
<%
} // end if ( ccmn06so_list != null )
%>
<%
//*****************
//**** BUTTONS ****
//*****************
// Display these buttons only if the user has On-Call maintainer
// privileges.
if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) )
{
%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td width="100%">
<%
    // If rows were returned, provide a Delete button, a New Using
    // button and an Add button; otherwise, provide only an Add
    // button.
    if ( ccmn06so_list != null)
    {
%>
<%--/* Delete functionality has been removed from baseline
        <td width="25%">
          <impact:ButtonTag
            name="<%= OnCallCustomValidation.DELETE_BUTTON_ON_SEARCH_PAGE %>"
            img="btnDelete"
            align="left"
            form="frmOnCallSchedules"
            action="/workload/OnCall/deleteOnCallSchedule"
            function="return confirmRowSelected( 'delete' )"
            restrictRepost="true"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
*/--%>
          <impact:ButtonTag
            name="btnNewUsing"
            img="btnNewUsing"
            align="right"
            form="frmOnCallSchedules"
            action="/workload/OnCall/displayOnCallDetail"
            function="return confirmRowSelected( 'new using' )"
            restrictRepost="true"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
        <td>
<%
    }
%>
          <impact:ButtonTag
            name="btnAdd"
            img="btnAdd"
            align="right"
            form="frmOnCallSchedules"
            action="/workload/OnCall/addOnCallSchedule"
            restrictRepost="true"
            tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
} // end if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) )
%>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
//********************************************
//**** FORM (ON-CALL SCHEDULES) ENDS HERE ****
//********************************************
%>

<%
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

%>
<br>
<% String county = ( (selectedCountiesVector != null) && !selectedCountiesVector.isEmpty() ) ? (String) selectedCountiesVector.get(0) : "" ;
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
%>


