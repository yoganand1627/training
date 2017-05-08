<%
//*-----------------------------------------------------------------------------
//*  JSP Name:     PPT Participant Detail
//*  Created by:   Jason Rios
//*  Date Created: 03/13/03
//*
//*  Description:
//*  This JSP displays the PPT Participant Details.
//*
/*
Change History:
  Date        User              Description
  ----------  ----------------  ---------------------------------------------
  06/05/2003  Todd Reser        Modified onlineNotificationCheck() to have an
                                else that clears the Date and disables Send
                                Alert box.  Also added call to this function
                                when the page loads.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
ROWCSUB27SOG00 participant = null;
int selectedParticipantId = 0;
String hdnParticipantId = "";
String hdnParticipantDateLastUpdate = "";
String hdnPersonId = "";
String selParticipantType = "";
String txtParticipantName = "";
String txtRelationshipInterest = "";
String selNotificationType = "";
String txtNotifiedDate = "";
String txtParticipationDate = "";
String cbxSendAlert = "";
String txtTitle = "";
String txtAgency = "";
String txtMeetingType = "";
String txtMeetingDate = "";
String txtMeetingTime = "";
String cbxAccptdChnges = FormattingHelper.formatString("");
String signedWvrAh = FormattingHelper.formatString("");
String reqAh = FormattingHelper.formatString("");
Boolean agencyDisabled = false;
Boolean titleDisabled = false;
Iterator iter = null;


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
UserProfile user = UserProfileHelper.getUserProfile( request );

participant = ( ROWCSUB27SOG00 )state.getAttribute( "participant", request );

CSUB29SO csub29so = (CSUB29SO)state.getAttribute("CSUB29SO", request);

if ( participant != null )
{
  if ( participant.getSzCdPptPartType() != null )
  {
    selParticipantType = FormattingHelper.formatString( participant.getSzCdPptPartType() );
  }
  if ( participant.getSzNmPptPartFull() != null )
  {
    txtParticipantName = FormattingHelper.formatString( participant.getSzNmPptPartFull() );
  }
  if ( participant.getSzSdsPptPartRelationship() != null )
  {
    txtRelationshipInterest = FormattingHelper.formatString( participant.getSzSdsPptPartRelationship() );
  }
  if ( participant.getSzCdPptNotifType() != null )
  {
    selNotificationType = FormattingHelper.formatString( participant.getSzCdPptNotifType() );
  }
  if ( participant.getDtDtPptPartDateNotif() != null )
  {
    txtNotifiedDate = FormattingHelper.formatDate( participant.getDtDtPptPartDateNotif() );
  }
  if ( participant.getDtDtPptDate() != null )
  {
    txtParticipationDate = FormattingHelper.formatDate( participant.getDtDtPptDate() );
  }
  if ( participant.getUlIdPptPart() > 0 )
  {
    hdnParticipantId = FormattingHelper.formatInt( participant.getUlIdPptPart() );
  }
  if ( participant.getTsLastUpdate() != null )
  {
    hdnParticipantDateLastUpdate = DateHelper.toISOString( participant.getTsLastUpdate() );
  }
  if ( participant.getUlIdPerson() > 0 )
  {
    hdnPersonId = FormattingHelper.formatInt( participant.getUlIdPerson() );
  }
  if (participant.getIndAccptdChnges()!=null)
  {
    cbxAccptdChnges = FormattingHelper.formatString(participant.getIndAccptdChnges());
  }
  if (participant.getIndReqAh()!=null)
  {
    reqAh = FormattingHelper.formatString(participant.getIndReqAh());
  }
  if (participant.getIndSignedWvrAh()!=null)
  {
    signedWvrAh = FormattingHelper.formatString(participant.getIndSignedWvrAh());
  }
  if (participant.getTxtAgency()!=null)
  {
    txtAgency = FormattingHelper.formatString(participant.getTxtAgency());
  }
  if (participant.getTxtTitle()!=null)
  {
    txtTitle = FormattingHelper.formatString(participant.getTxtTitle());
  }
} // end if ( participant != null )

if (csub29so != null)
{
  if (csub29so.getCSUB29SOG00()!= null)
  {
    txtMeetingType = csub29so.getCSUB29SOG00().getSzMeetingType();
  }
  if (csub29so.getCSUB29SOG00().getDtDtPptDate() != null)
    {
      txtMeetingDate = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtDtPptDate());
    }

    if (csub29so.getCSUB29SOG00().getTmScrTmPptTime() != null)
    {
      txtMeetingTime = csub29so.getCSUB29SOG00().getTmScrTmPptTime();
    }
}

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

// Reloads the Family Plan Item Detail page when the user changes
// the Participant Type.
function reloadPPTParticipant()
{
  disableValidation('frmPPTParticipant');
  setState('frmPPTParticipant');
  setValidationUrl('frmPPTParticipant','/subcare/PPT/reloadPPTParticipant');
  document.frmPPTParticipant.submit();
}

// This function will confirm that the user has entered and saved the
// participant details needed to generate the PPT Letter.
function checkPageData()
{
  <%
  if ( "".equals(hdnParticipantId) )
  {%>
    alert("<%= MessageLookup.getMessageByNumber( Messages.MSG_ARC_NO_FORM_DATA ) %>");
    return false;
  <%
  }
  else
  {
  %>
    if ( isFormChanged( document.frmPPTParticipant ) )
    {
      alert("<%= MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) %>");
      return false;
    }
  <%
  }
  %>
}

// When the user selects "Online" as the Notification Type for a PRS Staff
// participant, this function will automatically check the 'Send Alert'
// checkbox, enable the field and prefill the 'Notified Date' field with
// today's date (assuming the field is empty).  If the Notification Type
// is not "Online", this function will clear and disable 'Send Alert'.
function onlineNotificationCheck()
{
  if ( document.frmPPTParticipant.selNotificationType.value == "<%= CodesTables.CPPTNOST_ONL %>" )
  {
   document.frmPPTParticipant.cbxSendAlert.disabled = false;
   document.frmPPTParticipant.cbxSendAlert.checked = true;
    if ( document.frmPPTParticipant.txtNotifiedDate.value == "" )
    {
      var todaysDate = new Date();
      var todaysDateAsString = (todaysDate.getMonth()+1) + "/" + todaysDate.getDate() + "/" + todaysDate.getYear();
      document.frmPPTParticipant.txtNotifiedDate.value = todaysDateAsString;
    }
  }
  else
  {
    document.frmPPTParticipant.cbxSendAlert.checked = false;
    document.frmPPTParticipant.cbxSendAlert.defaultChecked = false;
    document.frmPPTParticipant.cbxSendAlert.disabled = true;
    document.frmPPTParticipant.txtNotifiedDate.value = "";
  }
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
//********************************************
//**** FORM (PPT INFORMATION) STARTS HERE ****
//********************************************
%>
<impact:validateForm
  name="frmPPTParticipant"
  method="post"
  action="/subcare/PPT/displayPPTParticipant"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<%
// The user must begin by selecting a Participant Type.
if ("".equals(selParticipantType) )
{%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr><th colspan="2">Team Meetings/Reviews Participant Detail</th></tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="100%">
          <tr>
            <td>
              <impact:validateSelect
                label="Participant Type"
                name="selParticipantType"
                codesTable="<%= CodesTables.CPARTYPE %>"
                required="true"
                value="<%= CodesTables.CPARTYPE_PIC %>"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
            <td width="50%">&nbsp;</td>
          </tr>
        </table>
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
          form="frmPPTParticipant"
          action="/subcare/PPT/reloadPPTParticipant"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
}
else
{%>
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
          <tr>
           <th colspan="4">Team Meetings/Reviews Participant Detail</th>
          </tr>
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
                  onChange="reloadPPTParticipant()"
                  colspan="3"
                  disabled = "true"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            else
            {%>
              <td width="20%">
                <impact:validateSelect
                  label="Participant Type"
                  name="selParticipantType"
                  codesTable="<%= CodesTables.CPARTYPE %>"
                  required="true"
                  value="<%= selParticipantType %>"
                  disabled="true"
                  colspan="3"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            %>
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
                  tabIndex="<%= tabIndex++ %>"
                  readOnly="true"
                  width="25%"
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
              <td colspan="2">
                <impact:ButtonTag
                  name="btnPerson"
                  img="btnSelectPerson"
                  align="left"
                  form="frmPPTParticipant"
                  action="/subcare/PPT/performPersonListPullback"
                  function="disableValidation('frmPPTParticipant')"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            else if ( selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
              txtAgency = "DFCS";%>
              <td colspan="2">
                <impact:ButtonTag
                  name="btnStaff"
                  img="btnSelectStaff"
                  align="left"
                  form="frmPPTParticipant"
                  action="/subcare/PPT/performStaffSearch"
                  function="disableValidation('frmPPTParticipant')"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            else
            {%>
              <td colspan="2">&nbsp;</td>
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
                  maxLength="20"
                  value="<%= txtRelationshipInterest %>"
                  required="true"
                  readOnly="true"
                  cssClass="readonly"
                  colspan="3"
                  tabIndex="<%= tabIndex++ %>"
                  cssClass="formInput"/>
              </td>
            </tr>
            <tr>
              <td>
                   <impact:validateInput
                    type="text"
                    label="Title"
                    name="txtTitle"
                    maxLength="20"
                    value="<%= txtTitle %>"
                    required="false"
                    readOnly="true"
                    cssClass="readonly"
                    colspan="3"
                    tabIndex="<%= tabIndex++ %>"
                    cssClass="formInput"/>
              </td>
            </tr>
            <tr>
              <td>
                 <impact:validateInput
                    type="text"
                    label="Agency"
                    name="txtAgency"
                    maxLength="20"
                    value="<%= txtAgency %>"
                    required="false"
                    readOnly="true"
                    cssClass="readonly"
                    colspan="3"
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
                  maxLength="20"
                  value="<%= txtRelationshipInterest %>"
                  required="true"
                  colspan="3"
                  tabIndex="<%= tabIndex++ %>"
                  cssClass="formInput"/>
              </td>
            </tr>
            <tr>
              <td>
                   <impact:validateInput
                    type="text"
                    label="Title"
                    name="txtTitle"
                    maxLength="20"
                    value="<%= txtTitle %>"
                    required="false"
                    colspan="3"
                    tabIndex="<%= tabIndex++ %>"
                    cssClass="formInput"/>
              </td>
            </tr>
            <tr>
              <td>
                 <impact:validateInput
                    type="text"
                    label="Agency"
                    name="txtAgency"
                    maxLength="20"
                    value="<%= txtAgency %>"
                    required="false"
                    colspan="3"
                    tabIndex="<%= tabIndex++ %>"
                    cssClass="formInput"/>
              </td>
            <%
            }
            %>
          </tr>
            <impact:validateInput
          type="hidden"
         name="txtMeetingDate"
         value="<%= txtMeetingDate %>"
         constraint="Date"/>

         <impact:validateInput
         type="hidden"
         name="txtMeetingTime"
         value="<%= txtMeetingTime %>"/>
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
                  codesTable="<%= CodesTables.CPPTNOST %>"
                  value="<%= selNotificationType %>"
                  onChange="onlineNotificationCheck()"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            //---------------------
            //--- Notified Date ---
            //---------------------
            %>
            <td  width="15%">
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
            <%
            //--------------------------
            //--- Participation Date ---
            //--------------------------
            %>
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
          </tr>
          <%if (txtMeetingType.equals("ADM")) { %>
          <tr>
            <td>
              <impact:validateInput
              label="Accepted Changes to Case Plan"
                name="cbxAccptdChnges"
                required="false"
                type="checkbox"
                tabIndex="<%= tabIndex++ %>"
                checked="<%=FormattingHelper.formatString(cbxAccptdChnges)%>"/>
            </td>
            <td colspan="2">
              <impact:validateInput
              label="Signed Waiver of Administrative Hearing"
                name="signedWvrAh"
                required="false"
                type="checkbox"
                tabIndex="<%= tabIndex++ %>"
                checked="<%=FormattingHelper.formatString(signedWvrAh)%>"/>
            </td>
            <td colspan="2">
              <impact:validateInput
              label="Requested Administrative Hearing"
                name="reqAh"
                required="false"
                type="checkbox"
                tabIndex="<%= tabIndex++ %>"
                checked="<%=FormattingHelper.formatString(reqAh)%>"/>
            </td>
          </tr>
          <%}//end section if meeting type is ADM%>
        </table>

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
            name="<%= PPTConversation.DELETE_BUTTON_ON_PARTICIPANT_PAGE %>"
            img="btnDelete"
            align="left"
            form="frmPPTParticipant"
            action="/subcare/PPT/deletePPTParticipant"
            function="return confirmDelete()"
            restrictRepost="true"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      %>
      <td>
        <impact:ButtonTag
          name="<%= PPTConversation.SAVE_BUTTON_ON_PARTICIPANT_PAGE %>"
          img="btnSave"
          align="right"
          form="frmPPTParticipant"
          action="/subcare/PPT/savePPTParticipant"
          restrictRepost="true"
          preventDoubleClick="true"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
}
%>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
//******************************************
//**** FORM (PPT PARTICIPANT) ENDS HERE ****
//******************************************
%>

<%
//***************
//**** FORMS ****
//***************
%>
<%/*
// Forms should only be available if the participant record has been
// saved to the database.
if ( !"".equals(selParticipantType) )
{%>
  <br>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr><th>Forms</th></tr>
      <tr>
      <td>
        <impact:documentList pageMode="<%= pageMode %>" tabIndex="<%= tabIndex++ %>" >
          <%
          //----------------------------
          //--- PPT Letter (English) ---
          //----------------------------
          %>
          <impact:document
            displayName="PPT Letter (English)"
            docType="csc06o00"
            docExists="false"
            protectDocument="false"
            onClick="checkPageData()">

            <impact:documentParameter
              name="pPptPart"
              value="<%= hdnParticipantId %>"/>

            <impact:documentParameter
              name="pPerson"
              value="<%= hdnPersonId %>"/>

            <impact:documentParameter
              name="pPptEvent"
              value="<%= String.valueOf( GlobalData.getUlIdEvent( request ) ) %>"/>

            <impact:documentParameter
              name="pStage"
              value="<%= String.valueOf( GlobalData.getUlIdStage( request ) ) %>"/>
          </impact:document>
          <%
          //----------------------------
          //--- PPT Letter (Spanish) ---
          //----------------------------
          %>
          <impact:document
            displayName="PPT Letter (Spanish)"
            docType="csc36o00"
            docExists="false"
            protectDocument="false"
            onClick="checkPageData()">

            <impact:documentParameter
              name="pPptPart"
              value="<%= hdnParticipantId %>"/>

            <impact:documentParameter
              name="pPerson"
              value="<%= hdnPersonId %>"/>

            <impact:documentParameter
              name="pPptEvent"
              value="<%= String.valueOf( GlobalData.getUlIdEvent( request ) ) %>"/>

            <impact:documentParameter
              name="pStage"
              value="<%= String.valueOf( GlobalData.getUlIdStage( request ) ) %>"/>
          </impact:document>
        </impact:documentList>
      </td>
    </tr>
  </table>

<%
} */
%>

<script type="text/javascript" language="JavaScript1.2">
if (document.frmPPTParticipant.cbxSendAlert != null)
{
  document.frmPPTParticipant.cbxSendAlert.disabled = true;
}
</script>

