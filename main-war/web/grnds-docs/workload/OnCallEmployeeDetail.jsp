<%
//--------------------------------------------------------------------------------
//  JSP Name:     On-Call Employee Detail
//  Created by:   Jason Rios
//  Date Created: 01/08/02
//
//  Description:
//  This JSP displays on-call employee data for the selected employee.
//
//  Change History:
//  Date      User              Description
//  --------  ----------------  --------------------------------------------------
//  10/23/03  Merle A Demo      SIR19889 OnCall schedule caused IndexArrayOutOfBounds
//                              exception. Changed the size of the array from 9 to 18
//                              in the .xds  9 delete rows and 9 add rows. The changes
//                              there are to stop the user from adding more than 9
//                              rows by adding a group that put the array over 9.
//  03/04/04  RIOSJA            SIR 22742 - Added hdnUlIdEmpOnCallLink hidden field
//                              so that the value can be used by validation routines
//                              in OnCallConversation.
//--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallConversation" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
//SIR19889
int numOfEmpsOnList = 0;
int numOfStaffToAdd = 0;

String fieldName = null;
String fieldValue = null;
boolean hasPerformedStaffSearch = false;

CCMN09SO ccmn09so_detail = null;
CCMN09SO ccmn09so_list = null;

BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

String pageMode = PageModeConstants.VIEW;
if( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}
if ("/admin/StaffSearch/staffSearch".equals(ContextHelper.getPreviousUrl(request)) )
{
  pageMode = PageModeConstants.EDIT;
}

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
//SIR19889 Get the number of staff on the list already
ccmn09so_list = ( CCMN09SO )state.getAttribute( OnCallConversation.CCMN09SO_LIST, request );
if (ccmn09so_list != null)
{
  numOfEmpsOnList = ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty();
}

ccmn09so_detail = ( CCMN09SO )state.getAttribute( OnCallConversation.CCMN09SO_DETAIL, request );
//SIR19889 Get the number of staff to add to the list
numOfStaffToAdd = ccmn09so_detail.getROWCCMN21DO_ARRAY().getROWCCMN21DOCount();

if( state.getAttribute( OnCallConversation.PERFORMED_STAFF_SEARCH, request ) != null )
{
  hasPerformedStaffSearch = true;
}
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
  enableValidation("frmOnCallEmployeeDetail");
  enableValidation("frmOnCallEmployeeDetail");
  //SIR19889 tell users how many employee to delete
  var numTotalLeft =  <%= OnCallConversation.INT_MAX_ON_CALL_EMPLOYEES - numOfEmpsOnList   %>;
  var numToBeRemoved = <%= numOfStaffToAdd %> - numTotalLeft;

  if ( numToBeRemoved > 0 && !(numTotalLeft == 0))
  {
     alert("Rows left for Staff Members = " + numTotalLeft + "  Employees to be removed = " + numToBeRemoved);
  }
};

// Called before the page unloads to display the "Are you sure
// you want to navigate away from this page..." message if the
// user hasn't saved their changes.
window.onbeforeunload = function ()
{
  IsDirty();
};

function setIndexOfEmployeeToRemove( index )
{
  if( confirm('Are you sure you want to remove this employee from the list?') )
  {
    document.frmOnCallEmployeeDetail.indexOfEmployeeToRemove.value = index;
    disableValidation( 'frmOnCallEmployeeDetail' );
    return true;
  }
  return false;
}

// Takes the user to the Staff Search page.
function goToStaffSearch()
{
  var goToStaffSearch = true;
  <%
  // If the user performed a Staff Search, but has not saved the
  // employees to the list, warn them that if they perform another
  // staff search, the employee data will not be saved. Also, disable
  // the isDirty() message since they will already have been warned
  // about losing their data.
  if( hasPerformedStaffSearch )
  {%>
    goToStaffSearch = confirm("If you perform another Staff Search, the On-Call Employees on this page will not be saved.\n\nPress 'OK' to continue.\n\nPress 'Cancel' to remain on this page.");
    setIsDirtyCalled(true);
  <%
  }
  %>
  if( goToStaffSearch == true )
  {
    setState('frmOnCallEmployeeDetail');
    setValidationUrl('frmOnCallEmployeeDetail', '/workload/OnCall/performStaffSearch');
    disableValidation( 'frmOnCallEmployeeDetail' );
    document.frmOnCallEmployeeDetail.submit();
  }
  else
  {
    // Since the user chose to stay on the page, enable isDirty()
    // again so that if they attempt to navigate away from the page,
    // they will be warned about losing their data.
    setIsDirtyCalled(false);
    return false;
  }
}
</script>

<%
//*************************
//*** VALIDATION ERRORS ***
//*************************
%>
<impact:validateErrors/>

<%
//********************************************
//**** FORM (EMPLOYEE DETAIL) STARTS HERE ****
//********************************************
%>
<impact:validateForm
  name="frmOnCallEmployeeDetail"
  method="post"
  action="/workload/OnCall/displayOnCallEmployee"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<impact:validateInput
  type="hidden"
  name="indexOfEmployeeToRemove"
  value=""/>

<%
Enumeration enumeration = ccmn09so_detail.getROWCCMN21DO_ARRAY().enumerateROWCCMN21DO();
while( enumeration.hasMoreElements() )
{
  ROWCCMN21DO employee = (ROWCCMN21DO)enumeration.nextElement();

  //RIOSJA, SIR 22742
  //--------------------------
  //---hdnUlIdEmpOnCallLink---
  //--------------------------
  fieldName = OnCallConversation.HDN_ID_EMP_ON_CALL_LINK + loopCounter;
  fieldValue = FormattingHelper.formatInt( employee.getUlIdEmpOnCallLink() );
  %>
  <impact:validateInput
    type="hidden"
    name="<%= fieldName %>"
    value="<%= fieldValue %>"/>
  <%
  //-------------------
  //---hdnUlIdPerson---
  //-------------------
  fieldName = OnCallConversation.HDN_ID_PERSON + loopCounter;
  fieldValue = FormattingHelper.formatInt( employee.getUlIdPerson() );
  %>
  <impact:validateInput
    type="hidden"
    name="<%= fieldName %>"
    value="<%= fieldValue %>"/>
  <%
  //--------------------------
  //---hdnSzNbrEmpHomePhone---
  //--------------------------
  fieldName = OnCallConversation.HDN_EMP_HOME_PHONE + loopCounter;
  fieldValue = employee.getLNbrPhone();
  %>
  <impact:validateInput
    type="hidden"
    name="<%= fieldName %>"
    value="<%= fieldValue %>"/>

  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr><th colspan="7">On-Call Employee Detail</th></tr>
    <tr>
      <td>
        <%
        //--------------------
        //---szNmPersonFull---
        //--------------------
        fieldName = OnCallConversation.TXT_NM_PERSON_FULL + loopCounter;
        fieldValue = FormattingHelper.formatString( employee.getSzNmPersonFull() );
        %>
        <impact:validateDisplayOnlyField
          label="Name"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"/>
        </td>
      <td>
        <%
        //---------------------------
        //---selSzCdEmpOnCallDesig---
        //---------------------------
        //fieldName = OnCallConversation.SEL_ONCALL_DESIG + loopCounter;
        //fieldValue = employee.getSzCdEmpOnCallDesig();
        //---------------------------
        //---selSzCdEmpOnCallProgram---
        //---------------------------
        fieldName = OnCallConversation.SEL_ONCALL_PROGRAM + loopCounter;
        //fieldValue = "BTH"; // need to get this from employee object
        fieldValue = employee.getSzCdOnCallProgram();
        %>
        <impact:validateSelect  
          label="Program Coverage"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"
          codesTable="<%= CodesTables.CCFB %>"
          required="true"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <%
        //-------------------------------
        //---txtUsNbrEmpOnCallCntctOrd---
        //-------------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_CONTACT_ORD + loopCounter;
        fieldValue = FormattingHelper.formatInt( employee.getUsNbrEmpOnCallCntctOrd() );
        %>
        <impact:validateInput
          label="Contact Order"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"
          type="text"
          cssClass="formInput"
          size="1"
          maxLength="1"
          required="true"
          constraint="Digit1"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr>
        <td>
        <%
        //--------------------
        //---txtSzTitle---
        //--------------------
        fieldName = OnCallConversation.TXT_TITLE + loopCounter;
        //fieldValue = FormattingHelper.formatString( employee.getSzNmPersonFull() );
        //fieldValue ="SSCM";
        fieldValue = FormattingHelper.formatString( employee.getSzCdTitle());
        %>
        <impact:validateDisplayOnlyField 
          label="Title"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"/>
      </td>
    </tr>
    <tr>
      <td>
        <%
        //-----------------------------
        //---txtSzNbrEmpOnCallPhone1---
        //-----------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_PHONE1 + loopCounter;
        fieldValue = "";
        if ( employee.getSzNbrEmpOnCallPhone1() != null &&
            !"".equals(employee.getSzNbrEmpOnCallPhone1()) )
        {
          fieldValue = FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone1() );
        }
        %>
        <impact:validateInput
          label="On-Call Phone"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"
          type="text"
          cssClass="formInput"
          size="15"
          maxLength="25"
          required="true"
          constraint="Phone"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <%
        //--------------------------
        //---txtLNbrEmpOnCallExt1---
        //--------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_EXT1 + loopCounter;
        fieldValue = employee.getLNbrEmpOnCallExt1();
        %>
        <impact:validateInput
          label="Ext"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"
          type="text"
          cssClass="formInput"
          size="15"
          maxLength="25"
          constraint="PhoneExtension"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr>
      <td>
        <%
        //-----------------------------
        //---txtSzNbrEmpOnCallPhone2---
        //-----------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_PHONE2 + loopCounter;
        fieldValue = "";
        if ( employee.getSzNbrEmpOnCallPhone2() != null &&
            !"".equals(employee.getSzNbrEmpOnCallPhone2()) )
        {
          fieldValue = FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone2() );
        }
        %>
        <impact:validateInput
          label="Other Phone"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"
          type="text"
          cssClass="formInput"
          size="15"
          maxLength="25"
          constraint="Phone"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <%
        //--------------------------
        //---txtLNbrEmpOnCallExt2---
        //--------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_EXT2 + loopCounter;
        fieldValue = employee.getLNbrEmpOnCallExt2();
        %>
        <impact:validateInput
          label="Ext"
          name="<%= fieldName %>"
          value="<%= fieldValue %>"
          type="text"
          cssClass="formInput"
          size="15"
          maxLength="25"
          constraint="PhoneExtension"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>&nbsp;</td>
      <%
      // Allow the user to remove the employee from the list only if
      // they are adding new employees to the On-Call schedule after
      // performing a Staff Search.
      if( hasPerformedStaffSearch &&
         !employee.hasUlIdOnCall() )
      {
        String functionAsString = "return setIndexOfEmployeeToRemove(" + loopCounter + ")";
        %>
        <td>
          <impact:ButtonTag
              name="btnRemove"
              img="btnRemove"
              align="right"
              form="frmOnCallEmployeeDetail"
              function="<%= functionAsString %>"
              action="/workload/OnCall/removeEmployeeFromStaffSearchList"
              tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      %>
    </tr>
    <tr>
      <td colspan="7">
        <%
        //*********************************
        //**** PHONE DETAIL SUB-MODULE ****
        //*********************************
        if ( employee.getUlIdPerson() > 0 )
        {%>
          <impact:include
            page='<%= "/submodule/PhoneSubmoduleConversation/PhoneSub" %>'
            callingPage='/workload/OnCall/displayOnCallEmployee'
            tabIndex="<%= tabIndex++ %>"
            includingForm="frmOnCallEmployeeDetail">
          <impact:attribute
            name="<%= PhoneSubmoduleConversation.PHONE_SUB_CREATED_FORM_FIELDS %>"
            value='<%= (loopCounter > 0) ? "DONE" : null %>'/>
          <impact:attribute
            name="<%= PhoneSubmoduleConversation.PAGE_MODE %>"
            value='<%= PageModeConstants.VIEW %>'/>
          <impact:attribute
            name="<%= PhoneSubmoduleConversation.PHONE_EXPANDABLE_SECTION_LABEL %>"
            value='<%= "Phone" %>'/>
          <impact:attribute
            name="<%= PhoneSubmoduleConversation.PHONE_SUB_PERSON_ID %>"
            value='<%= FormattingHelper.formatInt( employee.getUlIdPerson() ) %>'/>
          <impact:attribute
            name="<%= PhoneSubmoduleConversation.PHONE_SUB_PERSON_NAME %>"
            value='<%= FormattingHelper.formatString( employee.getSzNmPersonFull() ) %>'/>
          <%
          fieldValue = "OnCallEmployeePhoneSub" + loopCounter;
          %>
          <impact:attribute
            name="<%= PhoneSubmoduleConversation.PHONE_SUB_NAME %>"
            value='<%= "OnCallEmployeePhoneSub" + loopCounter %>'/>
          </impact:include>
        <%
        }
        %>
      </td>
    </tr>
  </table>
  <br>
  <%
  loopCounter++;
} // end while( enumeration.hasMoreElements() )
%>

<impact:validateInput
  type="hidden"
  name="numOfEmployees"
  value="<%= String.valueOf( loopCounter ) %>"/>

<hr>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td width="90%">
      <impact:ButtonTag
          name="btnStaff"
          img="btnSelectStaff"
          align="right"
          form="frmOnCallEmployeeDetail"
          function="return goToStaffSearch();"
          action="/workload/OnCall/performStaffSearch"
          tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td>
      <impact:ButtonTag
          name="btnContinue"
          img="btnContinue"
          align="right"
          form="frmOnCallEmployeeDetail"
          function="enableValidation( 'frmOnCallEmployeeDetail' )"
          action="/workload/OnCall/saveOnCallEmployee"
          restrictRepost="true"
          tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
//******************************************
//**** FORM (EMPLOYEE DETAIL) ENDS HERE ****
//******************************************
%>
