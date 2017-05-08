<%
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%
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

%>


<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
var county_region= new Array();
<%
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
%>

 function  getRegionForCountySelected(){
 var county = document.frmOnCallDetail.selSzCdCounty.value;
 var region = document.frmOnCallDetail.txtRegion.value; 
 // retrieves from printed out array above
 document.frmOnCallDetail.txtRegion.value = 'Region'+ county_region[county];
  
}

// Called before the page unloads to display the "Are you sure
// you want to navigate away from this page..." message if the
// user hasn't saved their changes.
window.onbeforeunload = function ()
{
   IsDirty();

};

window.onload = function ()
{
  <%
  // If the user just added or deleted an employee, achor the
  // page to the Employees listbox.
  if ( goToEmployeesSection &&
      !FormValidation.pageHasErrorMessages( request ) &&
      !FormValidation.pageHasValidationMessages( "frmOnCallDetail", request ) )
  {%>
    goToEmployeesSection.click();
  <%
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
    if ( divArray[i].id.substr(0, 6) == "" )
    {
      divArray[i].style.display = "none";
    }
  }

  if ( document.frmOnCallDetail.selSzCdRegion.value != "" )
  {
    // Deselect any previously selected counties for the selected
    // region since the user just now changed regions to this region.
    if ( bInitialPageLoad == false &&
         document.frmOnCallDetail.selSzCdRegion.value != "<%= CodesTables.CREGIONS_98 %>" )
    {
      selectAllDisplayedCounties( false );
    }

    // Show the selected region.
    var divNameToDisplay = "Region" + document.frmOnCallDetail.selSzCdRegion.value + "Counties";
    toggleVisibility( divNameToDisplay, "block" );
  }
  return true;
}


// This function confirms that the user has selected a row in
// the list box before continuing with the 'Delete' or 'New Using'
// procedure.
function confirmRowSelected( buttonClicked )
{
  var rowSelected = false;

  // If the radio button group is an array (i.e., more than one
  // radio button), then loop through the array and check for a
  // selected radio button; otherwise, check the single radio
  // button to see if it is selected.
  if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[0] )
  {
    for (var i = 0; i < document.frmOnCallDetail.selectedEmployeeIndex_CLEAN.length; i++)
    {
      if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[i].checked )
      {
        rowSelected = true;
        break;
      }
    }
  }
  else
  {
    if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN.checked )
    {
      rowSelected = true;
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
      return confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>" );
    }
  }
  return false;
}

// This function submits the 'frmOnCallEmployees' form to display
// the On-Call Employee Details for the selected employee.
function goToOnCallEmployeeDetailPage( selectedEmployeeIndex )
{
  // Disable the "IsDirty()" check because any changes to the schedule
  // information made by the user will be preserved by the activity
  // method.
  window.onbeforeunload = null;

  setState('frmOnCallDetail');
  setValidationUrl('frmOnCallDetail', '/workload/OnCall/displayOnCallEmployee');

  // If the 'selectedEmployeeIndex_CLEAN' radio button group is an array
  // (i.e., more than one radio button), then set the appropriate
  // array element to checked; otherwise, set the single radio button
  // to checked.
  if ( document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[0] )
  {
    document.frmOnCallDetail.selectedEmployeeIndex_CLEAN[ selectedEmployeeIndex ].checked = true;
  }
  else
  {
    document.frmOnCallDetail.selectedEmployeeIndex_CLEAN.checked = true;
  }
  document.frmOnCallDetail.submit();
}

function setButtonPressed( buttonName )
{
  var pageMode = <%= pageMode %>;

  document.frmOnCallDetail.buttonPressed.value = buttonName;

  // If the user clicked Save to modify the record, ask them to
  // confirm that they wish to modify it. The message should not
  // be displayed if the PageMode is NEW_USING.
  if ( buttonName == "<%= OnCallCustomValidation.SAVE_BUTTON %>" &&
       document.frmOnCallDetail.hdnUlIdOnCall.value != "" &&
       pageMode != <%= PageModeConstants.NEW_USING %> )
  {
    return confirm("<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_MODIFY ) %>");
  }

  return true;
}


function showRegionForSelectedCounty()
  {
    if ( document.frmOnCallDetail.selSzCdCounty.value != "" )
     {
        submitValidateForm( "frmOnCallDetail", "/workload/OnCall/displayOnCallDetail" );
     }
  } 
  
 </script>


<impact:validateErrors/>

<%
//*******************************************
//**** FORM (ON-CALL DETAIL) STARTS HERE ****
//*******************************************
%>
<impact:validateForm
  name="frmOnCallDetail"
  method="post"
  action=""
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<impact:validateInput
  type="hidden"
  name="hdnUlIdOnCall"
  value="<%= hdnUlIdOnCall %>"/>

<impact:validateInput
  type="hidden"
  name="hdnTsLastUpdate"
  value="<%= hdnTsLastUpdate %>"/>

<impact:validateInput
  type="hidden"
  name="buttonPressed"
  value=""/>

<impact:validateInput
  type="hidden"
  name="pageName"
  value="<%= OnCallConversation.ON_CALL_DETAIL_PAGE %>"/>

<%
//******************************
//**** SCHEDULE INFORMATION ****
//******************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th colspan="4">Schedule Information</th></tr>
  <tr>
    <td>
      <impact:validateSelect
        label="Program"
        name="selSzCdOnCallProgram"
        tabIndex="<%= tabIndex++ %>"
        codesTable="<%= CodesTables.CONCLPRG %>"
        required="true"
        value="<%= selSzCdOnCallProgram %>"/>
    </td>
    <td>
      <impact:validateSelect
        label="Type"
        name="selSzCdOnCallType"
        tabIndex="<%= tabIndex++ %>"
        codesTable="<%= CodesTables.CONCLTYP %>"
        required="true"
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
        required="true"
        constraint="Date"/>
    </td>
    <td>
      <impact:validateTime
        label="Start Time"
        name="txtTmOnCallStart"
        value="<%= txtTmOnCallStart %>"
        tabIndex="<%= tabIndex++ %>"
        required="true"/>
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
        required="true"
        constraint="Date"/>
    </td>
    <td>
      <impact:validateTime
        label="End Time"
        name="txtTmOnCallEnd"
        value="<%= txtTmOnCallEnd %>"
        tabIndex="<%= tabIndex++ %>"
        required="true"/>
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
        excludeOptions="<%=excludeCounty %>"
        value="<%= selSzCdCounty %>"
        onChange="getRegionForCountySelected()"/>
    </td>
    <td>
    <impact:validateInput
        type = "text"
        label=" Region"
        name="txtRegion"
        value="<%=selSzCdRegion %>"
        readOnly="true"/>
    </td>
   <td>&nbsp;</td>
    </tr>
  
  <tr>
    
  </tr>
  
</table>





<%
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
  %>
    <table border="0" cellspacing="0" cellpadding="3" class="tableborder" width="100%">
      <tr><th><a href="#goToEmployeesSection" name="goToEmployeesSection"></a>Employees</th></tr>
      <tr>
        <td class="tableBG">
          <div id="employeeList" style="height:100px; overflow:auto" class="tableborderList">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr>
                <th class="thList">&nbsp;</th>
                <th class="thList">Name</th>
                <th class="thList">Title</th>
                <th class="thList">Program</th>
                <th class="thList">Home Phone</th>
                <th class="thList">On-Call Phone</th>
                <th class="thList">Ext.</th>
                <th class="thList">OCD</th>
                <th class="thList">CO</th>
                <th class="thList">Other Phone</th>
                <th class="thList">Ext.</th>
              </tr>
              <%
              loopCounter = 0;
              ROWCCMN21DO employee = null;
              while ( enumeration.hasMoreElements() )
              {
                employee = ( ROWCCMN21DO )enumeration.nextElement();
                %>
                <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
                  <td>
                    <impact:validateInput
                      type="radio"
                      tabIndex="<%= tabIndex++ %>"
                      value="<%= String.valueOf( loopCounter ) %>"
                      name="selectedEmployeeIndex_CLEAN"
                      cssClass="formInput" />
                  </td>
                  <%
                  // Employee Name.
                  // Don't provide the hyperlink if PageMode is VIEW. For the
                  // hyperlink, the 'goToOnCallEmployeeDetailPage' function call
                  // must be added to both the 'href' and the 'onclick' attribute
                  // so that the "IsDirty()" check is not performed.
                  if ( pageMode.equals( PageModeConstants.VIEW ) )
                  {%>
                    <td><%= employee.getSzNmPersonFull() %></td>
                  <%
                  }
                  else
                  {%>
                    <td><a href="JavaScript:goToOnCallEmployeeDetailPage(<%= loopCounter %>);" onClick="JavaScript:goToOnCallEmployeeDetailPage(<%= loopCounter %>);"><%= employee.getSzNmPersonFull() %></a></td>
                  <%
                  }
                  %>
                   <%
                  // Title.
                  if ( employee.getSzCdTitle() != null &&
                       !"".equals(employee.getSzCdTitle()) )
                  {%>
                    <td><%= employee.getSzCdTitle() %></td>
                  <%
                  }
                  else
                  {%>
                    <td>&nbsp;</td>
                  <%
                  }
                  %>
                  <%
                  // Program.
                  if ( employee.getSzCdOnCallProgram() != null &&
                       !"".equals(employee.getSzCdOnCallProgram()) )
                  {%>
                    <td><%= employee.getSzCdOnCallProgram() %></td>
                  <%
                  }
                  else
                  {%>
                    <td>&nbsp;</td>
                  <%
                  }
                  %>
                  <%
                  // Home Phone.
                  if ( employee.getLNbrPhone() != null &&
                       !"".equals(employee.getLNbrPhone()) )
                  {%>
                    <td><%= FormattingHelper.formatPhone( employee.getLNbrPhone() ) %></td>
                  <%
                  }
                  else
                  {%>
                    <td>&nbsp;</td>
                  <%
                  }
                  %>
                  <%
                  // On-Call Phone.
                  if ( employee.getSzNbrEmpOnCallPhone1() != null &&
                       !"".equals(employee.getSzNbrEmpOnCallPhone1()) )
                  {%>
                    <td><%= FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone1() ) %></td>
                  <%
                  }
                  else
                  {%>
                    <td>&nbsp;</td>
                  <%
                  }
                  %>
                  <%
                  //Extension1
                   if ( employee.getLNbrEmpOnCallExt1() != null &&
                       !"".equals(employee.getLNbrEmpOnCallExt1()) )
                  {%>
                    <td><%= employee.getLNbrEmpOnCallExt1() %></td>
                   <%
                   }
                   else
                   {%>
                     <td>&nbsp;</td>
                   <%
                   }
                   %>  
                  <% 
                   // On Call Designation
                      
                  if ( employee.getSzCdEmpOnCallDesig() != null &&
                       !"".equals(employee.getSzCdEmpOnCallDesig()) )
                  {%>
                    <td><%= employee.getSzCdEmpOnCallDesig() %></td>
                  <%
                   }
                   else
                   {%>
                     <td>&nbsp;</td>
                   <%
                   }
                   %> 
                     
                  <td><%= employee.getUsNbrEmpOnCallCntctOrd() %></td>
                  <%
                  // Other Phone.
                  if ( employee.getSzNbrEmpOnCallPhone2() != null &&
                       !"".equals(employee.getSzNbrEmpOnCallPhone2()) )
                  {%>
                    <td><%= FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone2() ) %></td>
                  <%
                  }
                  else
                  {%>
                    <td>&nbsp;</td>
                  <%
                  }
                  %>
                  <% 
                  // Extension2
                   if ( employee.getLNbrEmpOnCallExt2()!= null &&
                       !"".equals(employee.getLNbrEmpOnCallExt2()) )
                  {%>
                  <td><%= employee.getLNbrEmpOnCallExt2() %></td>
                  <%
                  }
                  else
                  {%>
                    <td>&nbsp;</td>
                  <%
                  }
                  %>
                </tr>
                <%
                loopCounter++;
              } // end while ( enumeration.hasMoreElements() )
              %>
            </table>
          </div>
        </td>
      </tr>
    </table>
  <%
  } // end if ( enumeration.hasMoreElements() )
} // end if ( ccmn09so_list != null )
else
{%>
  <table border="0" cellspacing="0" cellpadding="3" class="tableborder" width="100%">
    <tr><th><a href="#goToEmployeesSection" name="goToEmployeesSection"></a>Employees</th></tr>
    <tr>
      <td class="tableBG">
        <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
      </td>
    </tr>
  </table>
<%
}
%>

<%
//*****************
//**** BUTTONS ****
//*****************
// Display these buttons only if the user has On-Call maintainer
// privileges and the PageMode is not VIEW.
if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) &&
     !pageMode.equals( PageModeConstants.VIEW ) )
{
  String saveButtonFunction = "return setButtonPressed('" + OnCallCustomValidation.SAVE_BUTTON + "')";
  %>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <%
      if ( ccmn09so_list != null &&
     ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty() > 0 )
      {
      %>
        <td>
          <impact:ButtonTag
            name="btnDelete"
            img="btnDelete"
            align="left"
            form="frmOnCallDetail"
            action="/workload/OnCall/deleteOnCallEmployee"
            function="return confirmRowSelected( 'delete' )"
            restrictRepost="true"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      %>
      <td>
        <impact:ButtonTag
          name="btnAdd"
          img="btnAdd"
          align="right"
          disabled="<%= String.valueOf(arrayEmpOnCallFull) %>"
          form="frmOnCallDetail"
          action="/workload/OnCall/addOnCallEmployee"
          restrictRepost="true"
          function="disableValidation('frmOnCallDetail')"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>

  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td>
        <hr>
        <impact:ButtonTag
          name="<%= OnCallCustomValidation.SAVE_BUTTON %>"
          img="btnSave"
          align="right"
          form="frmOnCallDetail"
          function="<%= saveButtonFunction %>"
          action="/workload/OnCall/saveOnCallSchedule"
          restrictRepost="true"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
} // end if ( user.hasRight( UserProfile.SEC_MNTN_ON_CALL ) && !pageMode.equals( PageMode.VIEW ) )
%>


<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">



</impact:validateForm>
