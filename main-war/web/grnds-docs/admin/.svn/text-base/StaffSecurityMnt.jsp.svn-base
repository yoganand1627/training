<%
//*   JSP Name:     Staff Security Maintenance
//*   Created by:   Eric Dickman
//*   Date Created: 10/10/02
//*
//*   Description:  The Staff Security Maintenance will allow
//*   the Security Administrator or PAC's to create, modify, or delete an
//*   employee's security profile composite, Logon ID, and Assignees.
//*   PACs will have the ability to remove profiles that are restricted to IT
//*   Security but will not be able to assign them.  A user can view this information
//*   if they have Browse Security access.
//*
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  10/09/02  Eric Dickman      Created initial docuement.
//**  03/27/03  Eric Dickman      QA Sweep
//**  05/29/03  Eric Dickman      SIR 17857 -- The validation class was not included
//**                              for the Staff Security Mnt Temp Form.
//**  06/12/03  Eric Dickman      SIR 18210 -- Moved the TEMP FORM with in the pullback
//**                              if statement.
//**  06/17/03  Eric Dickman      SIR 18299 --  The user most have
//**                              SEC_MNTN_LOGIN profile to modify the LOG-ON Textbox.
//**  07/24/05 Mike Werle    SIR 23728 - Moved constants for code reuse in MPS
//**
//**
//**
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSecurityMntConversation" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  int tabIndex = 1;

  BaseSessionStateManager state = (BaseSessionStateManager)
                                  request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  //The bSecMntFlag is used to determine if a user is entering a page for the first time or is returning
  //from the pullback
  Boolean bSecMntFlag = (Boolean) state.getAttribute(StaffSecurityMntConversation.SEC_MNT_FLAG, request);
  //bSecMntFlag is true when editing a user; false when looking at a Designee
  boolean bPullbackMode = Boolean.FALSE.equals(bSecMntFlag);

  //A boolean used to enable/disbale the HRow, just before the save button
  boolean hr = false;

  UserProfile userProfile = StaffSecurityMntConversation.getUserProfile(request);
  String pageMode = PageModeConstants.EDIT;
  if( ( userProfile.hasRight( userProfile.SEC_CHG_USER_CLASS ) == false ) &&
      ( userProfile.hasRight( userProfile.SEC_RESTRICT_SEC ) == false ) &&
      ( userProfile.hasRight( userProfile.SEC_MNTN_LOGIN ) == false ) )
  {
    pageMode = PageModeConstants.VIEW;
  }
  PageMode.setPageMode( pageMode, request );

  CARC14SO carc14so = (CARC14SO)state.getAttribute("CARC14SO", request);
  int numRows = carc14so.getUlRowQty();


  //Checks to ensure that ROWCARC14SOG02_ARRAY is not null and creates a new object.
  ROWCARC14SOG02_ARRAY rowcarc14sog02Array = null;
  if ( carc14so.getROWCARC14SOG02_ARRAY() == null )
  {
    rowcarc14sog02Array = new ROWCARC14SOG02_ARRAY();
  }
  else
  {
    rowcarc14sog02Array = carc14so.getROWCARC14SOG02_ARRAY();
  }

  //Checks to ensure that ROWCARC14SOG01_ARRAY is not null and creates a new object.
  ROWCARC14SOG01_ARRAY rowcarc14sog01Array = null;
  if ( carc14so.getROWCARC14SOG01_ARRAY() == null )
  {
    rowcarc14sog01Array = new ROWCARC14SOG01_ARRAY();
  }
  else
  {
    rowcarc14sog01Array = carc14so.getROWCARC14SOG01_ARRAY();
  }

  //Checks to ensure that ROWCARC14SOG00_ARRAY is not null and creates a new object.
  ROWCARC14SOG00_ARRAY rowcarc14sog00Array = null;
  if ( carc14so.getROWCARC14SOG00_ARRAY() == null )
  {
    rowcarc14sog00Array = new ROWCARC14SOG00_ARRAY();
  }
  else
  {
    rowcarc14sog00Array = carc14so.getROWCARC14SOG00_ARRAY();
  }

  List checkedValueVector = CastorArrayHelper.getStringVector( rowcarc14sog02Array, "szNmSecurityClass" );

  //The selectedStaffID is used to print the Staff Name to the top of the Staff Security Mnt page
  Integer selectedStaffID = (Integer) state.getAttribute( StaffSecurityMntConversation.SELECTED_STAFF_ID, request );

  //Allows the ROWCARC14SOG01_ARRAY to be displayed in two different sections.
  //The IT Restricted Section Yes Array and the Security Profile section is the noArray.

  ROWCARC14SOG01_ARRAY yesArray = new ROWCARC14SOG01_ARRAY();
  ROWCARC14SOG01_ARRAY noArray = new ROWCARC14SOG01_ARRAY();

  //Enumerate's over ROWCARC14SOG01 splitting into two new arrays.  Which are yesArray and noArray.  noArray is
  //the Non-Restricted It Security Profiles.  yesArray is the Restricted Secutiy Profiles.
  for ( Enumeration sog01enum = rowcarc14sog01Array.enumerateROWCARC14SOG01(); sog01enum.hasMoreElements(); )
  {
    ROWCARC14SOG01 sog01 = ( ROWCARC14SOG01 ) sog01enum.nextElement();
    if ("Y".equals(sog01.getCIndRestrict()) )
    {
      yesArray.addROWCARC14SOG01( sog01 );
    }
    else
    {
      noArray.addROWCARC14SOG01( sog01 );
    }
  }

  // Enables and Disables Widgets on the page for SEC_CHG_USER_CLASS or Staff Search pullback
  // bPullback is a boolean that is passed from the Staff Search Detail to the user if they are in pullback
  // or entering the Staff Sec Mnt page for the first time.  If bPullback is false the page is returning from
  // Staff Search in pullback mode.  If the bPullback is null or Staff Sec Mnt is entered from Staff Search,
  // then bPullback is true.

  String chgUserClass = null;
  if(!userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS) ||
     bPullbackMode)
  {
    chgUserClass = "true";
  }
  else
  {
    chgUserClass = "false";
    hr = true;
  }

  // Enables and disables widgets on the page for SEC_MNTN_LOGIN or Staff Search pullback


  String secLogin = null;
  //SIR 18299 -- The user most SEC_MNTN_LOGIN profile
  //to modify the LOG-ON Textbox.

  if(userProfile.hasRight(userProfile.SEC_MNTN_LOGIN) && !bPullbackMode)
  {
    secLogin  =  "false";
  }
  else
  {
    secLogin  =  "true";
  }

  //Disables only widgets that need to be hidden or disabled until the user saves the Designee Pullback section
  String pullBack = "false";
  String expDateDisable = "false";

  if(!userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS))
  {
    pullBack = "true";
    expDateDisable = "true";
  }

   String protectThisIT = null;

   int DISABLED = 0;
   int ENABLED = 1;
   int CHECKED_OR_DISABLED = 2;
   int checkboxState = DISABLED;
   if ( bPullbackMode == false )
   {
     if (userProfile.hasRight(userProfile.SEC_RESTRICT_SEC) && userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS))
     {
       checkboxState = ENABLED;
     }
     else if ( userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS) )
     {
       checkboxState = CHECKED_OR_DISABLED;
       protectThisIT="Javascript:protectCheckbox(this)";
     }
   }
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

//Checks the Security Profile of the user entering the page.  Is user for the IT
//Restricted Security Profiles
window.onload = function ()
{
<impact:ifThen test="<%= (pageMode.equals(PageModeConstants.EDIT)) %>">
  <impact:ifThen test='<%= ("true".equals(chgUserClass)) %>'>
    for (i = 1; i <= <%= noArray.getROWCARC14SOG01Count() %>; i++)
    {
      var cbx = "document.frmStaffSecurityMaint.cbSecurityProfiles" +i;
      eval(cbx + ".disabled = true");
    }
  </impact:ifThen>

for (i = 1; i <= <%= yesArray.getROWCARC14SOG01Count() %>; i++)
{
  var cbx = "document.frmStaffSecurityMaint.cbITSecurityProfiles" +i;
  var cbxValue = eval(cbx + ".checked");

  var disabled = true;
  if ( ( <%= (checkboxState == ENABLED) %> ) ||
       ( ( <%= (checkboxState == CHECKED_OR_DISABLED) %> ) &&
         ( ( cbxValue == true ) ) ) )
  {
    disabled = false;
  }
  eval(cbx + ".disabled = " + disabled);
}
</impact:ifThen>
}// end function

  //Saves with zero security profiles checked or zero It Restricted Security profiles checked
  function confirmOnZeroProfiles()
  {
       var confirmed = true;
       var profBoxCount = <%= noArray.getROWCARC14SOG01Count() %>;
       var itProfBoxCount = <%= yesArray.getROWCARC14SOG01Count() %>;
       var secChgUserClass = <%= userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS) %>;

       if( !areAnyChecked("cbSecurityProfiles", profBoxCount) &&
           !areAnyChecked("cbITSecurityProfiles", itProfBoxCount) &&
           secChgUserClass)
       {
          var message = "<%= MessageLookup.getMessageByNumber(Messages.MSG_SEC_CONFIRM_NO_PROF)%>";
          confirmed  = confirm (message);
       }
       return confirmed;
  }

  //Cancels Validation if the Designee totals more than five
  function cancelValidation ()
  {
  <impact:if test='<%= (numRows > 4) %>'>
    <impact:then>
      this.setInformationalMessage('<%=MessageLookup.getMessageByNumber(Messages.MSG_SEC_TOO_MANY_DESIGNEES)%>');
      return false;
    </impact:then>
    <impact:else>
      document.frmStaffSecurityMaint.FormValidationCancel.value="true";
      return true;
    </impact:else>
  </impact:if>
  }

  //Confirm on Exit Message
  window.onbeforeunload = function ()
  {
    IsDirty();
  };

  //Sets variables to hidden fields
  function setHiddenFields(DtAssignExpiration, UlIdEmpTempAssign , UlIdPerson2, UlIdPersonDesignee, TsLastUpdate)
  {
       document.frmStaffSecurityMaint.hdnDtAssignExpiration.value = DtAssignExpiration;
       document.frmStaffSecurityMaint.hdnUlIdEmpTempAssign.value = UlIdEmpTempAssign;
       document.frmStaffSecurityMaint.hdnUlIdPerson2.value = UlIdPerson2;
       document.frmStaffSecurityMaint.hdnUlIdPersonDesignee.value = UlIdPersonDesignee;
       document.frmStaffSecurityMaint.hdnTsLastUpdate.value = TsLastUpdate;
  }

  //Message for when a user wants to delete a Designee Of and give the user a alert if a
  //radio button was not selected by the user.
  function Delete()
  {
    var cont;
    if( checkForSelection('document.frmStaffSecurityMaint.employeeName'))
    {
         cont = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>');
    }
    else
    {
         alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) %>');
         cont = false;
    }
         return cont;
  }

  //Message will ask the user to com
  function deleteTemp()
  {
    if ( confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>') )
    {
      document.frmStaffSecurityMaintTmp.FormValidationCancel.value='true';
      return true;
    }
    else
    {
      return false;
    }
  }

    //Allows for the employeeName to be selected
  function checkForSelection( objName )
  {
    var buttonChecked = false;
    var obj = eval(objName);

    if (obj != null)
    {
      if (obj.length == null)
      {
        if (obj.checked != false)
        {
          buttonChecked = true;
        }
      }
      else
      {
        for (var i = 0; i < obj.length; ++i)
        {
          buttonChecked = buttonChecked || obj[i].checked;
        }
      }
    }
    return (buttonChecked);
    }

      //Allows It Restricted Checkboxs to be unchecked and not rechecked.
      function protectCheckbox(cb)
      {
           cb.check = "false";
           cb.disabled = "true";
      }
</script>

<impact:validateErrors formName="frmStaffSecurityMaint"/>
  <%
    if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null &&
        selectedStaffID != null )
    {
      int selectedIdInt = selectedStaffID;

      ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY)
          request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

      Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
      while ( e.hasMoreElements() )
      {
        ROWCCMN50DO staff = (ROWCCMN50DO)e.nextElement();
//SIR 17857 -- The validation class was not included for the Staff Security Mnt Temp Form
%>
<%
    // SIR 18210 -- Moved the if statement below, to above the frmStaffSecurityMaintTmp form.
    //  Locates the Logon Id above the Temporary Pullback page when adding a Designee Of.
    if ( bPullbackMode )
    {
      pullBack = "true";
%>
<impact:validateForm name="frmStaffSecurityMaintTmp"
  method="post"
  action="/admin/StaffSecurityMnt/displayStaffSecurityMaint"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSecurityMntCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<table border="0" cellspacing="0" cellpadding="3" width="100%">

  <tr>
    <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%" >
        <tr>
          <td width="100px">
            <impact:validateInput type="text"
                                  label="Logon ID"
                                  constraint="NovellUsername"
                                  name="szIdEmployeeLogonTemp"
                                  cssClass="formInput"
                                  value="<%= FormattingHelper.formatString(carc14so.getSzIdEmployeeLogon()) %>"
                                  size="20"
                                  maxLength="20"
                                  tabIndex= "<%= tabIndex++%>"
                                  disabled="<%= secLogin %>"
                                  required="true" />
          </td>
        </tr>
      </table>
    </td>
  </tr>
    <impact:validateInput type="hidden" name="hdnLastUpdate" value="<%=gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper.toISOString(carc14so.getTsLastUpdate())%>" />
    <impact:validateInput type="hidden" name="hdnIdStaffMember" value="<%= String.valueOf( GlobalData.getUlIdStaff( request ) )%>"  />
  <tr>
    <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
        <tr>
          <th width="3%">&nbsp;</th>
          <th width="37%">Employee Name</th>
          <th width="60%">Expiration</th>
        </tr>
        <tr>
           <td>
             <impact:validateInput tabIndex="<%= tabIndex++ %>" type="radio" name="rdnTempDesignee_CLEAN" checked="true"/>
           </td>
           <td>
             <impact:validateDisplayOnlyField name="StaffSzNmPersonFull" label="" value="<%= FormattingHelper.formatString(staff.getSzNmPersonFull()) %>" />
           </td>
             <impact:validateInput type="hidden" name="hdnIdPersonDesignee" value="<%= FormattingHelper.formatInt(staff.getUlIdPerson())%>"  />
           <td>
             <impact:validateDate size="10" value="" name="tempDate" tabIndex="<%= tabIndex++%>" required = "true"  constraint="Date" title="Pullback Expiration"/>
          </td>
        </tr>
      </table>
    </td>
   </tr>
   <tr>
     <td>
       <table border="0" cellspacing="0" cellpadding="3" width="100%">
         <tr>
           <td>
             <impact:ButtonTag name="btnDeleteTemp"
                               img="btnDelete"
                               function="return deleteTemp()"
                               align="left"
                               form="frmStaffSecurityMaintTmp"
                               action="/admin/StaffSecurityMnt/deleteTempDesigneeOf"
                               tabIndex= "<%= tabIndex++%>"
                               restrictRepost="true"/>
           </td>
           <td>
             <impact:ButtonTag name="btnSaveTemp"
                               img="btnSave"
                               align="right"
                               form="frmStaffSecurityMaintTmp"
                               action="/admin/StaffSecurityMnt/saveTempDesigneeOf"
                               tabIndex= "<%= tabIndex++%>"/>
           </td>
         </tr>
       </table>
     </td>
  </tr>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</table>
</impact:validateForm>
<%
} //Closing of the LogId if statement
%>
<%
       } //end of for finding the number of designee of
    }
%>
<impact:validateForm name="frmStaffSecurityMaint"
  method="post"
  action="/admin/StaffSecurityMnt/displayStaffSecurityMaint"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSecurityMntCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>

<impact:ifThen test="<%= !bPullbackMode %>">
      <table border="0" cellspacing="0" cellpadding="3" width="100%">
        <tr>
          <td width="100" >
            <impact:validateInput type="text"
                                  label="Logon ID"
                                  constraint="NovellUsername"
                                  name="szIdEmployeeLogon"
                                  cssClass="formInput"
                                  value="<%= FormattingHelper.formatString(carc14so.getSzIdEmployeeLogon()) %>"
                                  size="20"
                                  maxLength="20"
                                  tabIndex= "<%= tabIndex++%>"
                                  disabled="<%= secLogin %>"
                                  required="true" />
          </td>
</impact:ifThen>
            <impact:validateInput type="hidden"
                                  name="hdnLastUpdate"
                                  value="<%=gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper.toISOString(carc14so.getTsLastUpdate())%>" />
            <impact:validateInput type="hidden"
                                  name="hdnIdStaffMember"
                                  value="<%= String.valueOf( GlobalData.getUlIdStaff( request ) )%>"  />

        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
        <tr>
          <th width="100%" cellspacing="0" cellpadding="3">Designee Of</th>
        </tr>
          <tr>
            <td>
              <table border="0" cellspacing="0" cellpadding="3" class="tableBorderList" width="100%">
          <tr>
                  <td class="thList" width="3%">&nbsp;</td>
                  <td class="thList" width="37%">Employee Name</td>
                  <td class="thList" width="60%">Expiration</td>
                </tr>
<%
          int loopCount = 0;
          String UlIdEmpTempAssign = "";
          String UlIdPerson2 = "";
          String UlIdPersonDesignee = "";
          String SzNmPersonFull = "";
          String DtAssignExpiration = "";
          String TsLastUpdate2 = "";
          int messageCounter = rowcarc14sog00Array.getROWCARC14SOG00Count();

          //If the message counter is equal to zero, then return No Rows Returned Message
          if(messageCounter == 0)
          {
%>
               <tr class="odd">
                  <td colspan="4">
                    <%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %>
                  </td>
               </tr>
<%
         }
          //Enumerations rowcarc14sog00Array and passed to Javascript function setHiddenFields
          Enumeration sog00enum = rowcarc14sog00Array.enumerateROWCARC14SOG00();
          while ( sog00enum.hasMoreElements() )
          {
            String DesigneeOfValue = Integer.toString(loopCount);
            ROWCARC14SOG00 sog00 = ( ROWCARC14SOG00 ) sog00enum.nextElement();

            UlIdEmpTempAssign = FormattingHelper.formatInt(sog00.getUlIdEmpTempAssign());
            UlIdPerson2 = FormattingHelper.formatInt(sog00.getUlIdPerson());
            UlIdPersonDesignee = FormattingHelper.formatInt(sog00.getUlIdPersonDesignee());
            SzNmPersonFull = sog00.getSzNmPersonFull();
            DtAssignExpiration = FormattingHelper.formatDate(sog00.getDtDtAssignExpiration());
            TsLastUpdate2 = DateHelper.toISOString(sog00.getTsLastUpdate());
%>
              <tr class = "<%=FormattingHelper.getRowCss( loopCount + 1)%>">
                <td>
<%
                  String textName = "txtExpiration" + loopCount;
                  String IncOnClick =
                      "setHiddenFields( '" + DtAssignExpiration + "', '" +
                      UlIdEmpTempAssign  + "', '" +
                      UlIdPerson2 + "', '" +
                      UlIdPersonDesignee  + "', '" +
                      TsLastUpdate2  + "');";
%>
                  <impact:validateInput tabIndex="<%= tabIndex++%>"
                                        type="radio"
                                        id="rdnemployeeName_CLEAN"
                                        name="employeeName"
                                        onClick="<%=IncOnClick%>"
                                        value= "<%= DesigneeOfValue %>"
                                        cssClass="formInput"
                                        checked="false"
                                        disabled="<%=pullBack%>"/>
                </td>
                <td>
                  <%= SzNmPersonFull %>
                </td>
                <td>
                  <impact:validateDate
                          size="10"
                          value="<%= DtAssignExpiration %>"
                          title="Expiration"
                          name="<%= textName %>"
                          cssClass="formInput"
                          constraint="Date"
                          required = "true"
                          tabIndex="<%= tabIndex++ %>"
                          disabled="<%=pullBack%>" />
                 </td>
              </tr>
<%
           loopCount++;
         }

%>
    </table>
   </td>
  </tr>
      </table>
         <impact:validateInput type="hidden" name="hdnNbrExpDate" value="<%= FormattingHelper.formatInt(loopCount)%>"/>
         <impact:validateInput type="hidden" name="hdnUlIdEmpTempAssign" value=""/>
         <impact:validateInput type="hidden" name="hdnUlIdPerson2" value=""/>
         <impact:validateInput type="hidden" name="hdnUlIdPersonDesignee" value=""/>
         <impact:validateInput type="hidden" name="hdnDtAssignExpiration" value=""/>
         <impact:validateInput type="hidden" name="hdnTsLastUpdate" value=""/>
         <impact:validateInput type="hidden" name="hdnExpDateDisable" value="<%=expDateDisable%>"/>
    </td>
  </tr>
  <tr>
    <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%">
        <tr>
           <td>
<%
  //if no Designee Exist the delete push button will be hidden
  if(messageCounter != 0)
  {
%>
             <impact:ButtonTag name="btnDelete"
                               disabled="<%=pullBack%>"
                               img="btnDelete"
                               align="left"
                               form="frmStaffSecurityMaint"
                               action="/admin/StaffSecurityMnt/deleteDesigneeOf"
                               function = "return Delete()"
                               tabIndex= "<%= tabIndex++ %>"
                               restrictRepost="true"/>
           </td>
<%
  }
%>
           <td>
             <impact:ButtonTag name="btnAdd"
                               disabled="<%=pullBack%>"
                               img="btnAdd"
                               align="right"
                               function="return cancelValidation()"
                               form="frmStaffSecurityMaint"
                               action="/admin/StaffSecurityMnt/addDesigneeOf"
                               tabIndex= "<%= tabIndex++ %>"
                               restrictRepost="true"
                               navAwayCk="true" />
           </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
        <tr>
          <th>Security Profiles
          </th>
        </tr>
        <tr>
          <td>
            <impact:castorCheckbox castorEnum="<%= noArray.enumerateROWCARC14SOG01() %>"
                                   name="cbSecurityProfiles"
                                   checkedValues="<%= checkedValueVector %>"
                                   labelPropertyName="szNmSecurityClass"
                                   valuePropertyName="szNmSecurityClass"
                                   columns="3"
                                   isRuled="false"
                                   isHorizontal="true"
                                   tabIndex="<%= tabIndex++ %>"
                                   />
          </td>
        </tr>
      </table>
      <br>
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
        <tr>
          <th>IT Restricted Security Profiles</th>
        </tr>
        <tr>
          <td>
<%
            //Popluates the IT-Restricted Checkboxes (YesArray);
%>
            <impact:castorCheckbox castorEnum="<%= yesArray.enumerateROWCARC14SOG01() %>"
                                   name="cbITSecurityProfiles"
                                   checkedValues="<%= checkedValueVector %>"
                                   labelPropertyName="szNmSecurityClass"
                                   valuePropertyName="szNmSecurityClass"
                                   columns="3"
                                   isRuled="false"
                                   isHorizontal="true"
                                   onClick="<%= protectThisIT %>"
                                   tabIndex="<%= tabIndex++ %>"
                                   />
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
<%
  //Hide the HR if the save button is disabled
  if(hr == true)
  {
%>
  <tr>
    <td>
      <hr width="100%">
    </td>
  </tr>
<%
  }
%>
  <tr>

<%
  if( !bPullbackMode )
  {
%>
    <td>
      <impact:ButtonTag name="btnSave"
                        img="btnSave"
                        align="right"
                        function="return confirmOnZeroProfiles()"
                        form="frmStaffSecurityMaint"
                        action="/admin/StaffSecurityMnt/saveStaffSecurityMaint"
                        tabIndex="<%= tabIndex++ %>" />
    </td>
<%
  }
%>
  </tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
