<%
//*   JSP Name:     Staff Designee Mnt.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 12/10/02
//*
//*   This window allows supervisors and above to view a list of
//*   all employees who currently are designated to act as them.
//*   In addition, the user can add new assignments and modify or
//*   delete existing assignments.
//*
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/10/02  Eric Dickman      Created initial docuement.
//**  07/24/05 Mike Werle    SIR 23728 - Moved constants for code reuse in MPS
//**

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>
<%@ page import="org.grnds.facility.log.GrndsTrace"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CARC16SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.MntainDesigneeConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
  int tabIndex = 1;

  // variables used for the Hor. Row
  boolean hrNoDesignee = false;
  boolean hrPullback = false;

  boolean hideHr = false;

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  //Sets page mode to Edit
  String pageMode = PageMode.getPageMode(request);

  if (!PageModeConstants.VIEW.equals(pageMode))
  {
    hrNoDesignee = true;
  }
  else
  {
    hideHr = true;
  }

  //Sets CARC16SO to State
  CARC16SO carc16so = (CARC16SO)state.getAttribute( MntainDesigneeConversation.DESIGNEE_INFO, request);
  int numRows = 0;

  if(carc16so != null)
  {
    numRows = carc16so.getArchOutputStruct().getUlRowQty();
  }

  //Ensures carc16so in not null
  if (carc16so == null)
  {
    carc16so = new CARC16SO();
  }

   //Checks to ensure that ROWCARC14SOG00_ARRAY is not null and creates a new object.
  ROWCARC14SOG00_ARRAY rowcarc14sog00Array = null;
  if ( carc16so.getROWCARC14SOG00_ARRAY() == null )
  {
    rowcarc14sog00Array = new ROWCARC14SOG00_ARRAY();
  }
  else
  {
    rowcarc14sog00Array = carc16so.getROWCARC14SOG00_ARRAY();
  }

  //Disables only widgets that need to be hidden or disabled until the user saves the Designee Pullback section
  String pullBack = null;

  if(request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null)
  {
    pullBack  =  "true";
    hrPullback = true;
    hideHr = true;
  }
  else
  {
    pullBack = "false";
  }

  //Disables Save and Delete on the load of the page and if no Designee are chosen a message is displayed.
  String noDesignee = null;
  if((request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null) || (rowcarc14sog00Array.getUlRowQty() == 0))
  {
    noDesignee  =  "true";
    hideHr = true;
  }
  else
  {
    noDesignee = "false";
  }
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

  //Sets variables to hidden fields when the user clicks on the radio button on Staff Designee Mnt .jsp
  function setHiddenFields(DtAssignExpiration, UlIdEmpTempAssign , UlIdPersonDesignee, TsLastUpdate)
    {
        document.frmStaffDesigneeMnt.hdnDtAssignExpiration.value = DtAssignExpiration;
        document.frmStaffDesigneeMnt.hdnUlIdEmpTempAssign.value = UlIdEmpTempAssign;
        document.frmStaffDesigneeMnt.hdnUlIdPersonDesignee.value = UlIdPersonDesignee;
        document.frmStaffDesigneeMnt.hdnTsLastUpdate.value = TsLastUpdate;
    }

  //Confirm on Exit Message
 window.onbeforeunload = function ()
 {
           IsDirty();
 };

//Cancels Validation if the Designee totals more than five and throws a message
  function cancelValidation ()
  {
<%
    if( numRows > 4 )
    {
%>
      this.setInformationalMessage('<%=MessageLookup.getMessageByNumber(Messages.MSG_SEC_TOO_MANY_DESIGNEES)%>');
      return false;
<%
    }
    else
    {
%>
      document.frmStaffDesigneeMnt.FormValidationCancel.value="true";
      return true;
<%
    }
%>
  }

  //Message for when a user wants to delete a Designee and gives the user an alert, the if the
  //radio button was not selected by the user.
  function Delete()
  {
    var cont;
    if( checkForSelection('document.frmStaffDesigneeMnt.rdnemployeeName'))
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

//Message for when a user wants to delete a Designee and gives the user an alert, the if the
  //radio button was not selected by the user.
  function deleteTemp()
  {
     if ( confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>') )
    {
      document.frmStaffDesigneeMntTemp.FormValidationCancel.value='true';
      return true;
    }
    else
    {
      return false;
    }
  }

  //Allows for the employeeName to be selected out of the radio button
  function checkForSelection( objName )
  {
    var buttonChecked = false;
    var obj = eval(objName);

    if (obj != null)
    {
      if (obj.length == null)
      {
        if (obj.checked != false)
          buttonChecked = true;
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

</script>

<impact:validateErrors formName="frmStaffDesigneeMnt"/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
    <td>
<%
      //  Null check the object in the request
      if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null)
      {
        //  Create an instance of the array to use on your page
        ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);
        Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
        while ( e.hasMoreElements() )
        {
          ROWCCMN50DO staff = (ROWCCMN50DO)e.nextElement();
%>

<impact:validateForm name="frmStaffDesigneeMntTemp"
  method="post"
  action="/admin/MntainDesignee/displayStaffDesigneeMnt"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.MntainDesigneeCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

   <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
      <tr>
        <th width="3%">&nbsp;</th>
        <th width="37%">Employee Name</th>
        <th width="60%">Expiration</th>
        <%--impact:validateInput type="hidden" name="hdnIdPerson" value="<%= UserProfileHelper.getUserProfile( request )%>" --%>
      </tr>
      <tr>
        <td>
          <impact:validateInput tabIndex="<%= tabIndex++ %>" type="radio" name="rdnTempDesignee" checked="true"/>
        </td>
        <td>
          <impact:validateDisplayOnlyField name="StaffSzNmPersonFull" label="" value="<%= FormattingHelper.formatString(staff.getSzNmPersonFull()) %>" />
        </td>
        <impact:validateInput type="hidden" name="hdnIdPersonDesignee" value="<%= FormattingHelper.formatInt(staff.getUlIdPerson())%>"  />
        <td>
        <impact:validateDate size="10" value="" name="tempDate" tabIndex="<%= tabIndex++ %>" constraint="Date" required="false" title="Pullback Expiration"/>
        </td>
      </tr>
    </table>
    <table border="0" cellspacing="0" cellpadding="3" width="100%">
      <tr>
        <td>
          <impact:ButtonTag name="btnDeleteTemp" img="btnDelete" restrictRepost="true" align="left" function="return deleteTemp()" form="frmStaffDesigneeMntTemp" action="/admin/MntainDesignee/deleteTempDesigneeOf"  tabIndex="<%= tabIndex++%>"/>
        </td>
        <td>
          <impact:ButtonTag name="btnSaveTemp" img="btnSave" restrictRepost="true" align="right" form="frmStaffDesigneeMntTemp" action="/admin/MntainDesignee/saveTempDesigneeOf" tabIndex="<%= tabIndex++%>"/>
        </td>
       </tr>
     </table>
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
    </impact:validateForm>
     <%
          } //end of for finding the number of designee
       }
     %>

<impact:validateForm name="frmStaffDesigneeMnt"
  method="post"
  action="/admin/MntainDesignee/displayStaffDesigneeMnt"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.MntainDesigneeCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
    </td>
  </tr>
   <%--impact:validateInput type="hidden" name="hdnIdPerson" value="<%= String.valueOf( GlobalData.getUlIdPerson( request ) )%>"  --%>
   <tr>
     <td colspan="4">
       <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
         <tr>
           <th width="3%">&nbsp</th>
           <th width="37%">Employee Name</th>
           <th width="60%">Expiration</th>
        </tr>
<%
           //Variables for the display page, uses CARC16SO
           int loopCount = 0;
           String UlIdEmpTempAssign = "";
           String UlIdPerson2 = "";
           String UlIdPersonDesignee = "";
           String SzNmPersonFull = "";
           String DtAssignExpiration = "";
           String TsLastUpdate = "";

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
           //Enumerations over rowcarc14sog00Array to get the Designees
           Enumeration sog00enum = rowcarc14sog00Array.enumerateROWCARC14SOG00();
           while ( sog00enum.hasMoreElements() )
           {
             String DesigneeOfValue = Integer.toString(loopCount);
             ROWCARC14SOG00 sog00 = ( ROWCARC14SOG00 ) sog00enum.nextElement();

             UlIdEmpTempAssign = FormattingHelper.formatInt(sog00.getUlIdEmpTempAssign());
             UlIdPerson2 = FormattingHelper.formatInt(GlobalData.getUlIdPerson(request));
             UlIdPersonDesignee = FormattingHelper.formatInt(sog00.getUlIdPersonDesignee());
             SzNmPersonFull = sog00.getSzNmPersonFull();
             DtAssignExpiration = FormattingHelper.formatDate(sog00.getDtDtAssignExpiration());
             TsLastUpdate = DateHelper.toISOString(sog00.getTsLastUpdate());
        %>
       <tr class = "<%=FormattingHelper.getRowCss( loopCount + 1)%>">
         <td>
         <%
           String textName = "txtExpiration" + loopCount;
           //When the user selects the radio button, the following fields get populated to the setHiddenFields JavaScript function
           String IncOnClick = "setHiddenFields( '" + DtAssignExpiration + "', '" + UlIdEmpTempAssign  + "', '" + UlIdPersonDesignee  + "', '" + TsLastUpdate + "');";
         %>
           <impact:validateInput tabIndex="<%= tabIndex++%>" type="radio" id="rdnemployeeName" onClick="<%=IncOnClick%>" name="rdnemployeeName" cssClass="formInput" checked="false"  disabled="<%=pullBack%>" />
         </td>
         <td>
           <%= SzNmPersonFull %>
         </td>
         <td>
         <impact:validateDate size="10" value="<%= DtAssignExpiration %>" title="Expiration" name="<%= textName %>" cssClass="formInput" constraint="Date"  required="false"  disabled="<%=pullBack%>" tabIndex="<%= tabIndex++ %>"  />
         </td>
       </tr>
       <%
          loopCount++;
         }
       //2 lines below -- Sets hidden fields
       %>
       <impact:validateInput type="hidden" name="hdnNbrExpDate" value="<%= FormattingHelper.formatInt(loopCount)%>"/>
       <impact:validateInput type="hidden" name="hdnUlIdEmpTempAssign" value=""/>
       <!--impact:validateInput type="hidden" name="hdnUlIdPerson" value=""/-->
       <impact:validateInput type="hidden" name="hdnUlIdPersonDesignee" value=""/>
       <impact:validateInput type="hidden" name="hdnDtAssignExpiration" value=""/>
       <impact:validateInput type="hidden" name="hdnTsLastUpdate" value=""/>
       </table>
     </td>
   </tr>
   <tr>
     <td>
       <table border="0" cellspacing="0" cellpadding="3" width="100%">
         <tr>
            <td>
              <impact:ButtonTag name="btnDelete" function="return Delete()" action="/admin/MntainDesignee/deleteDesigneeOf" form="frmStaffDesigneeMnt" img="btnDelete" align="left"  disabled="<%=noDesignee%>" tabIndex="<%= tabIndex++ %>" />
            </td>
            <td>
              <impact:ButtonTag name="btnAdd" action="/admin/MntainDesignee/addDesigneeOf" navAwayCk="true" restrictRepost="true" function="return cancelValidation()" form="frmStaffDesigneeMnt" img="btnAdd" align="right"  disabled="<%=pullBack%>" tabIndex="<%= tabIndex++ %>" />
            </td>
         </tr>
<%
         //Hide the HR if the page returns from Staff Search or
         if(!hideHr)
         {
%>
        <tr>
         <td colspan="4">
           <hr width="100%">
         </td>
        </tr>
<%
        }
        //end of if for the hr = true
%>
         <tr>
           <td colspan="2">
             <impact:ButtonTag name="btnSave" img="btnSave" align="right" form="frmStaffDesigneeMnt" action="/admin/MntainDesignee/saveMntainDesignee"   disabled="<%=noDesignee%>" tabIndex="<%= tabIndex++ %>" />
           </td>
         </tr>
       </table>
    </td>
  </tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

</impact:validateForm>

