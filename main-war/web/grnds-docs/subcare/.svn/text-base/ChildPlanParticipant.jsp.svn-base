<%
//*--------------------------------------------------------------------------------
//*  JSP Name:     Child Plan Participant Detail
//*  Created by:   Bryon Jacob
//*  Date Created: 03/01/03
//*
//*  Description:
//*  This JSP displays the Child Plan Participant details.
//*
//*  Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.ChildPlanConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int tabIndex = 1;
ROWCSUB36SOG00 participant = null;
String hdnParticipantId = "";
String hdnParticipantDateLastUpdate = "";
String hdnPersonId = "";
String selParticipantType = "";
String txtParticipantName = "";
String txtRelationshipInterest = "";
String selNotificationType = "";
String txtNotifiedDate = "";
String txtParticipationDate = "";
String txtCopyGivenDate = "";


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

participant = ( ROWCSUB36SOG00 )state.getAttribute( "participant", request );

if ( participant != null )
{
  if ( participant.getSzCdCspPartType() != null )
  {
    selParticipantType = FormattingHelper.formatString( participant.getSzCdCspPartType() );
  }
  if ( participant.getSzNmCspPartFull() != null )
  {
    txtParticipantName = FormattingHelper.formatString( participant.getSzNmCspPartFull() );
  }
  if ( participant.getSzSdsCspPartRelationship() != null )
  {
    txtRelationshipInterest = FormattingHelper.formatString( participant.getSzSdsCspPartRelationship() );
  }
  if ( participant.getSzCdCspPartNotifType() != null )
  {
    selNotificationType = FormattingHelper.formatString( participant.getSzCdCspPartNotifType() );
  }
  if ( participant.getDtDtCspDateNotified() != null )
  {
    txtNotifiedDate = FormattingHelper.formatDate( participant.getDtDtCspDateNotified() );
  }
  if ( participant.getDtDtCspPartParticipate() != null )
  {
    txtParticipationDate = FormattingHelper.formatDate( participant.getDtDtCspPartParticipate() );
  }
  if ( participant.getDtDtCspPartCopyGiven() != null )
  {
    txtCopyGivenDate = FormattingHelper.formatDate( participant.getDtDtCspPartCopyGiven() );
  }
  if ( participant.getUlIdChildPlanPart() > 0 )
  {
    hdnParticipantId = FormattingHelper.formatInt( participant.getUlIdChildPlanPart() );
  }
  if ( participant.getTsLastUpdate() != null )
  {
    hdnParticipantDateLastUpdate = DateHelper.toISOString( participant.getTsLastUpdate() );
  }
  if ( participant.getUlIdPerson() > 0 )
  {
    hdnPersonId = FormattingHelper.formatInt( participant.getUlIdPerson() );
  }
} // end if ( participant != null )


//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageMode.getPageMode( request );
%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<%/** @todo remove document.js import */%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};

function confirmDelete()
{
  return confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>" );
}

// Reloads the Child Plan Participant Detail page when the user changes
// the Participant Type so the other fields become visible.
function reloadParticipant()
{
  disableValidation('frmChildPlanParticipant');
  setState('frmChildPlanParticipant');
  setValidationUrl('frmChildPlanParticipant','/subcare/ChildPlan/reloadParticipant');
  document.frmChildPlanParticipant.submit();
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
//***************************************************
//**** FORM (Child Plan Participant) STARTS HERE ****
//***************************************************
// The user must begin by selecting a Participant Type.
if ("".equals(selParticipantType) )
{%>
  <impact:validateForm
    name="frmChildPlanParticipant"
    method="post"
    action="/subcare/ChildPlan/displayParticipant"
    validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.ChildPlanCustomValidation"
    defaultButton="true"
    pageMode="<%= pageMode %>"
    schema="/WEB-INF/Constraints.xsd">

  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr><th colspan="2">Child Plan Participant Detail</th>
    </tr>
    <tr>
      <td width="18%">
        <impact:validateSelect
          label="Participant Type"
          name="selParticipantType"
          codesTable="<%= CodesTables.CPARTYPE %>"
          required="true"
          value=""
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>

  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td>
        <impact:ButtonTag
          name="btnContinue"
          img="btnContinue"
          align="right"
          form="frmChildPlanParticipant"
          action="/subcare/ChildPlan/reloadParticipant"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>

  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  </impact:validateForm>
<%
}
else
{%>
  <impact:validateForm
    name="frmChildPlanParticipant"
    method="post"
    action="/subcare/ChildPlan/displayParticipant"
    validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.ChildPlanCustomValidation"
    pageMode="<%= pageMode %>"
    schema="/WEB-INF/Constraints.xsd">

  <impact:validateInput
    type="hidden"
    name="hdnParticipantId"
    value="<%= hdnParticipantId %>"/>

  <impact:validateInput
    type="hidden"
    name="hdnParticipantDateLastUpdate"
    value="<%= hdnParticipantDateLastUpdate %>"/>

  <impact:validateInput
    type="hidden"
    name="hdnPersonId"
    value="<%= hdnPersonId %>"/>

  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr><th colspan="4">Child Plan Participant Detail</th></tr>
    <tr>
      <%
      //------------------------
      //--- Participant Type ---
      //------------------------
      // Once the participant record has been saved to the database,
      // the Participant Type cannot be changed.
      if ("".equals(hdnParticipantId) )
      {%>
        <td width="20%">
          <impact:validateSelect
            label="Participant Type"
            name="selParticipantType"
            codesTable="<%= CodesTables.CPARTYPE %>"
            required="true"
            value="<%= selParticipantType %>"
            onChange="reloadParticipant()"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      else
      {%>
        <td>
          <impact:validateSelect
            label="Participant Type"
            name="selParticipantType"
            codesTable="<%= CodesTables.CPARTYPE %>"
            required="true"
            value="<%= selParticipantType %>"
            disabled="true"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      %>
      <td width="15%">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <%
      //------------------------
      //--- Participant Name ---
      //------------------------
      // If the Participant Type is "Person in Case" or "Staff", the
      // Participant Name field can only be modified by performing a
      // Person Search or Staff Search, accordingly.
      if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
           selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
      {%>
        <td>
          <impact:validateInput
            type="text"
            label="Name"
            name="txtParticipantName"
            value="<%= txtParticipantName %>"
            required="true"
            disabled="true"
            maxLength="25"
            tabIndex="<%= tabIndex++ %>"
            cssClass="formInput"
            constraint="Name25"/>
        </td>
      <%
      }
      else
      {%>
        <td>
          <impact:validateInput
            type="text"
            label="Name"
            name="txtParticipantName"
            value="<%= txtParticipantName %>"
            required="true"
            maxLength="25"
            tabIndex="<%= tabIndex++ %>"
            cssClass="formInput"
            constraint="Name25"/>
        </td>
      <%
      }
      %>

      <%
      //---------------------------
      //--- Person/Staff Button ---
      //---------------------------
      if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) )
      {%>
        <td>
          <impact:ButtonTag
            name="btnPerson"
            img="btnSelectPerson"
            align="left"
            form="frmChildPlanParticipant"
            action="/subcare/ChildPlan/performPersonListPullback"
            function="disableValidation('frmChildPlanParticipant')"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      else if ( selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
      {%>
        <td>
          <impact:ButtonTag
            name="btnStaff"
            img="btnSelectStaff"
            align="left"
            form="frmChildPlanParticipant"
            action="/subcare/ChildPlan/performStaffSearch"
            function="disableValidation('frmChildPlanParticipant')"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      else
      {%>
        <td>&nbsp;</td>
      <%
      }
      %>
    </tr>
    <tr>
      <%
      //-----------------------------
      //--- Relationship/Interest ---
      //-----------------------------
      // If the Participant Type is "Person in Case" or "Staff", the
      // Relationship/Interest field can only be modified by performing
      // a Person Search or Staff Search, accordingly.
      if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
           selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
      {%>
        <td>
          <impact:validateInput
            type="text"
            label="Relationship/Interest"
            name="txtRelationshipInterest"
            value="<%= txtRelationshipInterest %>"
            required="true"
            disabled="true"
            maxLength="20"
            tabIndex="<%= tabIndex++ %>"
            cssClass="formInput"/>
        </td>
      <%
      }
      else
      {%>
        <td>
          <impact:validateInput
            type="text"
            label="Relationship/Interest"
            name="txtRelationshipInterest"
            value="<%= txtRelationshipInterest %>"
            required="true"
            maxLength="20"
            tabIndex="<%= tabIndex++ %>"
            cssClass="formInput"/>
        </td>
      <%
      }
      %>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <%
      //-------------------------
      //--- Notification Type ---
      //-------------------------
      %>
      <td>
        <impact:validateSelect
          label="Notification Type"
          name="selNotificationType"
          codesTable="<%= CodesTables.CPPTNOPE %>"
          value="<%= selNotificationType %>"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateDate
          label="Notified Date"
          name="txtNotifiedDate"
          type="text"
          value="<%= txtNotifiedDate %>"
          size="10"
          tabIndex="<%= tabIndex++ %>"
          constraint="Date"/>
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate
          label="Participation Date"
          name="txtParticipationDate"
          type="text"
          value="<%= txtParticipationDate %>"
          size="10"
          tabIndex="<%= tabIndex++ %>"
          constraint="Date"/>
      </td>
      <td>
        <impact:validateDate
          label="Copy Given Date"
          name="txtCopyGivenDate"
          type="text"
          value="<%= txtCopyGivenDate %>"
          size="10"
          tabIndex="<%= tabIndex++ %>"
          constraint="Date"/>
      </td>
    </tr>
  </table>
  <br>
  <%
  //*****************
  //**** BUTTONS ****
  //*****************
  %>

  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <%
      if ( !"".equals(hdnParticipantId) )
      {%>
        <td>
          <impact:ButtonTag
            name="<%= ChildPlanConversation.DELETE_BUTTON_ON_PARTICIPANT_PAGE %>"
            img="btnDelete"
            align="left"
            form="frmChildPlanParticipant"
            action="/subcare/ChildPlan/deleteParticipant"
            function="return confirmDelete()"
            restrictRepost="true"
            preventDoubleClick="true"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      %>
      <td>
        <impact:ButtonTag
          name="<%= ChildPlanConversation.SAVE_BUTTON_ON_PARTICIPANT_PAGE %>"
          img="btnSave"
          align="right"
          form="frmChildPlanParticipant"
          action="/subcare/ChildPlan/saveParticipant"
          restrictRepost="true"
          preventDoubleClick="true"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>

  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  </impact:validateForm>
<%
}
//*************************************************
//**** FORM (Child Plan Participant) ENDS HERE ****
//*************************************************
%>
