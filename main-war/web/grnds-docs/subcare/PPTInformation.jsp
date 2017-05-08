<%//*--------------------------------------------------------------------------------
      //*  JSP Name:     PPT Information
      //*  Created by:   Jason Rios
      //*  Date Created: 03/13/03
      //*
      //*  Description:
      //*  This JSP displays the PPT Information details.
      //*
      //*  Change History:
      //*  Date      User              Description
      //*  --------  ----------------  --------------------------------------------------
      //*  06/16/03  Merle A Demo      Sir 18188  Moved Add and Delete buttons inside of
      //*                              PPT participation  and added a <br> after the save
      //*                              pushButton
      //*  09/18/03  Merle A Demo      SIR19787 added preventDoubleClick to Save button
      //*  10/28/03  Eric Dickman      SIR 19962 -- The PPT Review document will not display
      //*                              when csub29so is not null, the page mode is view, and
      //*                              the document does not exist.
      //*  04/16/04  Donald Wilson     SIR 16299 - If the event status is NEW, when the
      //*                              worker clicks Save, display a JavaScript pop-up
      //*                              message reminding the worker to update the child's
      //*                              Person Characteristics, if necessary.
      //*  09/02/04  Mike Ready        SIR 23133 - "Add" function assumes incorrectly that
      //*                              csub29so is populated.  Script fails on null pointer
      //*                              exception.  Added null check on csub29so to JS function
      //*                              confirmSave().
      //*  09/10/08  alwilliams        STGAP00006265 - Change the lookup in the Notification Type
      //*                              section to use code table CPPTNOST instead of CPPTNOPE. This
      //*                              change is consistent with the design documnet.
      //*  11/10/08  arege             STGAP00010758  Made changes so that the SaveAndSubmit
      //*                              button is not displayed for the Supervisor when he comes
      //*                              to the page via the Task hyperlink on his Staff ToDo page
      //* 3/30/2009  cwells            STGAP00010663 Displaing the teamnarrong when in the ongoing 
      //*                              stage and meeting type is FTM only   
      //* 2/23/2010  wjcochran         MR-62: Added logic for "Add Contact Standards" and "Display
      //*                              Contact Standards" buttons
      //*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB27SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Hashtable"%>

<%
      //*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      int loopCounter = 0;
      int tabIndex = 1;
      CSUB27SO csub27so = null;
      CSUB29SO csub29so = null;
      String cdStage = "";
      String txtMeetingType = "";
      String txtMeetingDate = "";
      String txtMeetingTime = "";
      String txtBeginDate = "";
      String txtEndDate = "";
      String txtDatePrepIntvw = "";
      String txtPermRepComp = "";
      String txtDocumentCompletedDate = "";
      Enumeration enumeration = null;
      boolean approvalStatus = false;
      boolean displaySubmit = true;
      boolean displayNarrativeButton = true;
      boolean protectNarrative = false;
      boolean docExists = false;
      boolean displayAddContStndsBtn = true;
      boolean displayViewContStndsBtn = false;
      Integer intIdContactStdsEvent = 0;

      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      cdStage = GlobalData.getSzCdStage(request);

      csub27so = (CSUB27SO) state.getAttribute("CSUB27SO", request);
      csub29so = (CSUB29SO) state.getAttribute("CSUB29SO", request);
      String cbxIndAssistNeeded = FormattingHelper.formatString("");
      String cbxPrevReqMet = FormattingHelper.formatString("");
      String cbxPermanency = FormattingHelper.formatString("");
      String cbxSafety = FormattingHelper.formatString("");
      String cbxWellbeing = FormattingHelper.formatString("");
      String cbxTranPlanComp = FormattingHelper.formatString("");
      String txtDateHearingReq = "";
      String txtOutcomeDiscussed = "";
      String s;
      String eventStatus = "";
     
      if (csub29so != null) {
        docExists = (ArchitectureConstants.TRUE).equals(csub29so.getBIndBLOBExistsInDatabase());
        
        if (csub29so.getCSUB29SOG00() != null) {
          if (csub29so.getCSUB29SOG00().getDtDtPptDate() != null) {
            txtMeetingDate = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtDtPptDate());
          }

          if (csub29so.getCSUB29SOG00().getTmScrTmPptTime() != null) {
            txtMeetingTime = csub29so.getCSUB29SOG00().getTmScrTmPptTime();
          }

          if (csub29so.getCSUB29SOG00().getSzMeetingType() != null) {
            txtMeetingType = csub29so.getCSUB29SOG00().getSzMeetingType();
          }

          if (csub29so.getCSUB29SOG00().getDtUtilBeginDate() != null) {
            txtBeginDate = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtUtilBeginDate());
          }

          if (csub29so.getCSUB29SOG00().getDtUtilEndDate() != null) {
            txtEndDate = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtUtilEndDate());
          }

          if (csub29so.getCSUB29SOG00().getDtPermRepComp() != null) {
            txtPermRepComp = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtPermRepComp());
          }

          if (csub29so.getCSUB29SOG00().getDtOutcomeDiscussed() != null) {
            txtOutcomeDiscussed = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtOutcomeDiscussed());
          }

          if (csub29so.getCSUB29SOG00().getDtDatePrepIntvw() != null) {
            txtDatePrepIntvw = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtDatePrepIntvw());
          }

          if (csub29so.getCSUB29SOG00().getDtDateHearingReq() != null) {
            txtDateHearingReq = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtDateHearingReq());
          }

          if (csub29so.getCSUB29SOG00().getBIndAssistNeeded() != null) {
            cbxIndAssistNeeded = csub29so.getCSUB29SOG00().getBIndAssistNeeded();
          }

          if (csub29so.getCSUB29SOG00().getBIndPermanency() != null) {
            cbxPermanency = csub29so.getCSUB29SOG00().getBIndPermanency();
          }

          if (csub29so.getCSUB29SOG00().getBIndPrevReqMet() != null) {
            cbxPrevReqMet = csub29so.getCSUB29SOG00().getBIndPrevReqMet();
          }

          if (csub29so.getCSUB29SOG00().getBIndSafety() != null) {
            cbxSafety = csub29so.getCSUB29SOG00().getBIndSafety();
          }

          if (csub29so.getCSUB29SOG00().getBIndWellbeing() != null) {
            cbxWellbeing = csub29so.getCSUB29SOG00().getBIndWellbeing();
          }
          
          if (csub29so.getCSUB29SOG00().getUlIdContactStdsEvent() > 0) {
            intIdContactStdsEvent = csub29so.getCSUB29SOG00().getUlIdContactStdsEvent();
          }

          if (ArchitectureConstants.TRUE.equals(csub29so.getCSUB29SOG00().getSzApprovalStatus())) {
            approvalStatus = true;            
          } else {
            approvalStatus = false;
          }
          cbxTranPlanComp = csub29so.getCSUB29SOG00().getBIndTranPlanComp();

        }
        if (csub29so.getROWCSUB29SOG01() != null) {
          s = csub29so.getROWCSUB29SOG01().getSzCdEventStatus();
          if (s != null && !"".equals(s)) {
            eventStatus = s;
          }
        }
      }

      if (intIdContactStdsEvent > 0 && !(CodesTables.CEVTSTAT_APRV.equals(eventStatus))) {
        displayAddContStndsBtn = false;
        displayViewContStndsBtn = true;
      }
      
      if (!CodesTables.CMEETTYP_FTM.equals(txtMeetingType)) {
        displayAddContStndsBtn = false;
        displayViewContStndsBtn = false;
      }
      
      String pageMode = PageMode.getPageMode(request);
      if (pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.APPROVE)) {
        protectNarrative = true;
      }

      if (pageMode.equals(PageModeConstants.MODIFY)) {
        displayNarrativeButton = true;
      } else {
        displayNarrativeButton = false;
      }

      if ("".equals(txtMeetingDate) || txtMeetingDate == null) {
        displaySubmit = false;
      } else {
        displaySubmit = true;
      }
      
       if (GlobalData.isApprovalMode(request)){
      displaySubmit = false; 
      }

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

function confirmSave()
{
  <%
  // The message that was popped up is removed so this function now just returns true.
  %>
  return true;
}

function convenerMustCreateDoc()
{
  alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_PPT_CONVENER_MUST_CREATE) %>");
  return false;
}

// The PPT review document is no longer created and thus this code is unnecessary. It
// will be removed once Participant is working to ensure that nothing important is deleted.
function checkMeetingDate()
{
  if (document.frmPPTInformation.txtMeetingDate.value == "")
  {
    alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_REQ_PPT_REVIEW_DOCUMENT) %>");
    return false;
  }
  else
  {
    if (isFormChanged(document.frmPPTInformation))
    {
      alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_SAVE_BEFORE_CONTINUE) %>");
      return false;
    }
  }
}

// Each time the user changes the 'Meeting Date', this function is called
// to set the 'bMeetingDateHasChanged' indicator to "Y". (The indicator
// should not be set to "Y" if the field was empty initially.)
function indicateMeetingDateHasChanged()
{
<impact:ifThen test='<%= !"".equals(txtMeetingDate) %>'>
  document.frmPPTInformation.bMeetingDateHasChanged.value = ArchitectureConstants.Y;
</impact:ifThen>
}

// This function confirms that the user has selected a row in the list
// box before continuing with the 'Delete' procedure.
function confirmRowSelected()
{
  var rowSelected = false;

  // If the radio button group is an array (i.e., more than one radio
  // button), then loop through the array and check for a selected radio
  // button; otherwise, check the single radio button to see if it is
  // selected.
  if (document.frmPPTInformation.rbParticipantId_CLEAN[0])
  {
    for (var i = 0; i < document.frmPPTInformation.rbParticipantId_CLEAN.length; i++)
    {
      if (document.frmPPTInformation.rbParticipantId_CLEAN[i].checked)
      {
        rowSelected = true;
        break;
      }
    }
  }
  else
  {
    if (document.frmPPTInformation.rbParticipantId_CLEAN.checked)
    {
      rowSelected = true;
    }
  }

  if (rowSelected == false)
  {
    alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) %>");
    return false;
  }
  else
  {
    disableValidation('frmPPTInformation');
    return confirm("<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>");
  }
  return false;
}

// Takes the user to the Family Plan Item Detail page for the selected
// item.
function goToParticipantDetailPage(selectedParticipantId)
{
  document.frmPPTInformation.selectedParticipantId.value = selectedParticipantId;
  setState('frmPPTInformation');
  setValidationUrl('frmPPTInformation', '/subcare/PPT/displayPPTParticipant');
  document.frmPPTInformation.submit();
}
function setRequest()
{
 cancelValidation();
 document.frmPPTInformation.hdnContactStdsReqTaskBack.value='true';
}
function cancelValidation ()
{
  disableValidation('frmPPTInformation');
  return true;
}
</script>

<%
//*************************
//*** VALIDATION ERRORS ***
//*************************
%>
<impact:validateErrors />
<%
//********************************************
//**** FORM (PPT INFORMATION) STARTS HERE ****
//********************************************
%>
<impact:validateForm name="frmPPTInformation" method="post" action="/subcare/PPT/displayPPTInformation" validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTCustomValidation" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">

  <impact:validateInput type="hidden" name="selectedParticipantId" value="" />

  <impact:validateInput type="hidden" name="bMeetingDateHasChanged" value="<%= ArchitectureConstants.N %>" />

  <%// If the 'Document Completed' field is empty when the page
      // first loads, a new PPT event should be created if the user
      // enters a 'Document Completed' and saves the page. Set the
      // 'bCreateNewPPTEvent' indicator accordingly.
      String indicatorValue = ArchitectureConstants.N;
      if ("".equals(txtDocumentCompletedDate)) {
        indicatorValue = ArchitectureConstants.Y;
      }
%>
  <impact:validateInput type="hidden" name="hdnContactStdsReqTaskBack" value="" />
  <impact:validateInput type="hidden" name="bCreateNewPPTEvent" value="<%= indicatorValue %>" />
<%    // SIR 2171 
      // ExcludeOptions for different stages.
      Hashtable<String, String> excludeList = new Hashtable<String, String>();
      // values put in hash list are the ones not shown for specific stage
      if(CodesTables.CSTAGES_INV.equals(cdStage)) {
        excludeList.put("Community Meeting", CodesTables.CMEETTYP_CMM);
        excludeList.put("RBWO", CodesTables.CMEETTYP_MAT);
        excludeList.put("Administrative Review", CodesTables.CMEETTYP_ADM);
        excludeList.put("MDT", CodesTables.CMEETTYP_MDT);
        excludeList.put("Permanency Review Meeting", CodesTables.CMEETTYP_PRM);
        excludeList.put("RBWO Review Meeting", CodesTables.CMEETTYP_URM);
      } else if(CodesTables.CSTAGES_FPR.equals(cdStage)) {
        excludeList.put("MDT", CodesTables.CMEETTYP_MDT);
        excludeList.put("Permanency Review Meeting", CodesTables.CMEETTYP_PRM);
        excludeList.put("RBWO Review Meeting", CodesTables.CMEETTYP_URM);
      } else if(CodesTables.CSTAGES_FSU.equals(cdStage)) {
        excludeList.put("Safety Plan Meeting", CodesTables.CMEETTYP_SPM);
        excludeList.put("RBWO", CodesTables.CMEETTYP_MAT);
        excludeList.put("Permanency Review Meeting", CodesTables.CMEETTYP_PRM);
        excludeList.put("RBWO Review Meeting", CodesTables.CMEETTYP_URM);
      } else if(CodesTables.CSTAGES_SUB.equals(cdStage)) {
        excludeList.put("FTM", CodesTables.CMEETTYP_FTM);
        excludeList.put("Safety Plan Meeting", CodesTables.CMEETTYP_SPM);
        excludeList.put("MDT", CodesTables.CMEETTYP_MDT);
        excludeList.put("FTM For Legal Guardianship", CodesTables.CMEETTYP_FLG);
      } else if(CodesTables.CSTAGES_PFC.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage)) {
        excludeList.put("FTM", CodesTables.CMEETTYP_FTM);
        excludeList.put("Safety Plan Meeting", CodesTables.CMEETTYP_SPM);
        excludeList.put("RBWO", CodesTables.CMEETTYP_MAT);
        excludeList.put("MDT", CodesTables.CMEETTYP_MDT);
        excludeList.put("RBWO Review Meeting", CodesTables.CMEETTYP_URM);
        excludeList.put("FTM For Legal Guardianship", CodesTables.CMEETTYP_FLG);
      }
      // end SIR 2171
%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
  <%if (approvalStatus) {%>
    <tr>
      <td>
        <impact:ButtonTag name="btnApprovalStatus" tabIndex="<%= tabIndex++ %>" img="btnApprovalStatus" editableMode="<%= EditableMode.ALL %>" form="frmPPTInformation" action="/workload/ApprovalStatus/displayStatus" />
      </td>
  <%} else { %>
      <td>&nbsp;</td>
  <%}%>
    </tr>
  </table>
  <br>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th colspan="4">
        Meeting Information
      </th>
    </tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="100%">
          <tr>
            <td>
              <impact:validateSelect label="Meeting Type" name="txtMeetingType" required="<%= ArchitectureConstants.TRUE %>" tabIndex="<%= tabIndex++ %>" codesTable="CMEETTYP" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                excludeOptions="<%= excludeList.values() %>" value="<%=FormattingHelper.formatString(txtMeetingType)%>" />
            </td>
          </tr>
          <tr>
            <td>
              <impact:validateDate label="Meeting Date" name="txtMeetingDate" type="text" value="<%= txtMeetingDate %>" size="10" required="true" onChange="indicateMeetingDateHasChanged()" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
          <tr>
            <td>
              <impact:validateTime label="Start Time" name="txtMeetingTime" value="<%= txtMeetingTime %>" tabIndex="<%= tabIndex++ %>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  
  <%if ("ADM".equals(txtMeetingType)) {%>

  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">
        Administrative Hearing Information
      </th>
    </tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="55%">
          <tr>
            <td colspan="2">
              <impact:validateInput label="Case Manager Assistance Needed in Requesting an Administrative Hearing" name="cbxIndAssistNeeded" required="<%= ArchitectureConstants.FALSE %>" type="checkbox" tabIndex="<%= tabIndex++ %>"
                editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" checked="<%=FormattingHelper.formatString(cbxIndAssistNeeded)%>" />
            </td>
          </tr>
          <tr>
            <td>
              <impact:validateDate label="Date Hearing Requested" name="txtDateHearingReq" type="text" value="<%= txtDateHearingReq %>" size="10" required="true" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
          <tr>
            <td>
              <impact:validateDate label="Outcome Discussed with Parents" name="txtOutcomeDiscussed" type="text" value="<%= txtOutcomeDiscussed %>" size="10" required="false" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <br>
  <%} //end administrative review%>


  <%if ("FTM".equals(txtMeetingType)) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">
        FTM Meeting Information
      </th>
    </tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="90%">
          <tr>
            <td colspan="2">
              <impact:validateInput label="Previous Requirements/Recommendations Met" name="cbxPrevReqMet" required="<%= ArchitectureConstants.FALSE %>" type="checkbox" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                checked="<%=FormattingHelper.formatString(cbxPrevReqMet)%>" />
            </td>
            <td>
              <impact:validateDate label="Preparation Interview" name="txtDatePrepIntvw" type="text" value="<%= txtDatePrepIntvw %>" size="10" required="false" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <br>
  <%}//end conditional for FTM meeting.%>

  <%if ("URM".equals(txtMeetingType)) {%>

  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">
        RBWO Review Information
      </th>
    </tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="55%">
          <tr>
            <td>
              <impact:validateDate label="Begin Date" name="txtBeginDate" type="text" value="<%= txtBeginDate %>" size="10" required="true" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
          <tr>
            <td>
              <impact:validateDate label="End Date" name="txtEndDate" type="text" value="<%= txtEndDate %>" size="10" required="true" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <br>

  <%}//end conditional for Utilization%>

  <%if ("MDT".equals(txtMeetingType)) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">
        MDT Meeting Regarding
      </th>
    </tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="80%">
          <tr>
            <td colspan="2">
              <impact:validateInput label="Permanency" name="cbxPermanency" required="<%= ArchitectureConstants.FALSE %>" type="checkbox" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                checked="<%=FormattingHelper.formatString(cbxPermanency)%>" />
            </td>
            <td>
              <impact:validateInput label="Safety" name="cbxSafety" required="<%= ArchitectureConstants.FALSE %>" type="checkbox" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                checked="<%=FormattingHelper.formatString(cbxSafety)%>" />
            </td>
            <td>
              <impact:validateInput label="Wellbeing" name="cbxWellbeing" required="<%= ArchitectureConstants.FALSE %>" type="checkbox" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                checked="<%=FormattingHelper.formatString(cbxWellbeing)%>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <br>
  <%}//close conditional for MDT meeting%>

  <%if ("PRM".equals(txtMeetingType)) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">
        Administrative Hearing Information
      </th>
    </tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="60%">
          <tr>
            <td>
              <impact:validateDate label="Permanency Report Completed" name="txtPermRepComp" type="text" value="<%= txtPermRepComp %>" size="10" required="false" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <br>
  <%}//close conditional for PRM%>
  
  <%if ("FLG".equals(txtMeetingType)) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">
        FTM Meeting Information
      </th>
    </tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="90%">
          <tr>
            <td colspan="2">
              <impact:validateInput label="Previous Requirements/Recommendations Met" name="cbxPrevReqMet" required="<%= ArchitectureConstants.FALSE %>" type="checkbox" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                checked="<%=FormattingHelper.formatString(cbxPrevReqMet)%>" />
            </td>
            <td>
              <impact:validateDate label="Preparation Interview" name="txtDatePrepIntvw" type="text" value="<%= txtDatePrepIntvw %>" size="10" required="false" tabIndex="<%= tabIndex++ %>" constraint="Date" />
            </td>
          </tr>
          <tr>
            <td>
              <impact:validateInput label="Transition Plan Completed" name="cbxTranPlanComp" required="<%= ArchitectureConstants.FALSE %>" type="checkbox" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                checked="<%=FormattingHelper.formatString(cbxTranPlanComp)%>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <br>
  <%}//end conditional for FTM meeting.%>



  <%/* BEGIN Admin Address Phone Submodule */%>
  <%//----------------
      //--- Location ---
      //----------------
      AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
      adminAddressPhoneSubDB.setFormName("frmPPTInformation");
      adminAddressPhoneSubDB.setPageMode(pageMode);
      adminAddressPhoneSubDB.setAddressPhoneSectionHeader("Location");
      adminAddressPhoneSubDB.setAddressRequired(false);
      adminAddressPhoneSubDB.setAddressDisabled(false);
      adminAddressPhoneSubDB.setCommentsVisible(true);
      adminAddressPhoneSubDB.setCommentsRequired(false);
      adminAddressPhoneSubDB.setCommentsDisabled(false);
      adminAddressPhoneSubDB.setPhoneRequired(false);
      adminAddressPhoneSubDB.setPhoneDisabled(false);
      adminAddressPhoneSubDB.setAddressSubmoduleName("");
      adminAddressPhoneSubDB.setTabIndex(tabIndex);
      AdminAddressPhoneSubDB.setIntoRequest(adminAddressPhoneSubDB, request);

      %>
  <%@ include file="/grnds-docs/admin/AdminAddressPhoneSub.jsp"%>
  <%tabIndex = adminAddressPhoneSubDB.getTabIndex();
      AdminAddressPhoneSubDB.removeFromRequest(request);
%>
  <%/* END Admin Address Phone Submodule */%>
  <br>

  <%// Do not show the PPT Participation section if the PPT event status
      // is NEW. The user must save the PPT Information page before adding
      // participants.
      if (csub29so != null && !CodesTables.CEVTSTAT_NEW.equals(csub29so.getROWCSUB29SOG01().getSzCdEventStatus())) {
        //-------------------------
        //--- PPT Participation ---
        //-------------------------
        if (csub27so != null && csub27so.getROWCSUB27SOG00_ARRAY().getUlRowQty() > 0) {
          // Adjust the height of the table based on the number of rows to
          // be displayed. 300px is max.
          int sectionHeight = 30 * (1 + csub27so.getROWCSUB27SOG00_ARRAY().getUlRowQty());
          if (sectionHeight > 300) {
            sectionHeight = 300;
          }

          %>
  <table border="0" cellspacing="0" cellpadding="3" class="tableborder" width="100%">
    <tr>
      <th>
        Participation
      </th>
    </tr>
    <tr>
      <td>
        <impact:pagination submitUrl="/subcare/PPT/displayPPT">
          <div id="pptParticipation" style="height:<%= sectionHeight %>px; width:760px; overflow:auto">
            <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableborderList">
              <tr>
                <th class="thList">
                  &nbsp;
                </th>
                <th class="thList">
                  Name
                </th>
                <th class="thList">
                  Notified
                </th>
                <th class="thList">
                  Notification Type
                </th>
                <th class="thList">
                  Participated
                </th>
                <th class="thList">
                  Relationship/Interest
                </th>
              </tr>
              <%enumeration = csub27so.getROWCSUB27SOG00_ARRAY().enumerateROWCSUB27SOG00();
          while (enumeration.hasMoreElements()) {
            ROWCSUB27SOG00 participant = (ROWCSUB27SOG00) enumeration.nextElement();

            %>
              <tr class="<%= FormattingHelper.getRowCss(loopCounter + 1) %>">
                <td>
                  <%// The name of this radio button ends in "_CLEAN" so that the
            // radio group will be excluded from the 'isDirty' check. We
            // don't want the user to get the message "Your unsaved data
            // will be lost" just because they selected a radio button.

            %>
                  <impact:validateInput type="radio" tabIndex="<%= tabIndex++ %>" value="<%= FormattingHelper.formatInt(participant.getUlIdPptPart()) %>" name="rbParticipantId_CLEAN" cssClass="formInput" />
                </td>
                <td>
                  <a href="JavaScript:goToParticipantDetailPage(<%= FormattingHelper.formatInt(participant.getUlIdPptPart()) %>);"><%=participant.getSzNmPptPartFull()%></a>
                </td>
                <td>
                  <%=FormattingHelper.formatDate(participant.getDtDtPptPartDateNotif())%>
                </td>
                <%//-------------------------
            //--- Notification Type ---
            //-------------------------
            // If the Participant Type is 'Person in Case' or 'Other', the
            // Notification Type codes table is CPPTNOPE. Otherwise, it's
            // CPPTNOST.
            //
            // STGAP00006265 - Changed first lookup to use CPPTNOST instead of CPPTNOPE. This change 
            // is consistent with the design documentation
            
            if (participant.getSzCdPptNotifType() != null
                && participant.getSzCdPptPartType() != null
                && (participant.getSzCdPptPartType().equals(CodesTables.CPARTYPE_PIC) || participant
                                                                                                    .getSzCdPptPartType()
                                                                                                    .equals(
                                                                                                            CodesTables.CPARTYPE_OTH))) {%>
                <td>
                  <%=Lookup.simpleDecodeSafe(CodesTables.CPPTNOST, participant.getSzCdPptNotifType())%>
                </td>
                <%} else if (participant.getSzCdPptNotifType() != null && participant.getSzCdPptPartType() != null
                       && participant.getSzCdPptPartType().equals(CodesTables.CPARTYPE_STA)) {%>
                <td>
                  <%=Lookup.simpleDecodeSafe(CodesTables.CPPTNOST, participant.getSzCdPptNotifType())%>
                </td>
                <%} else {%>
                <td>
                  &nbsp;
                </td>
                <%}

            %>
                <td>
                  <%=FormattingHelper.formatDate(participant.getDtDtPptDate())%>
                </td>
                <td>
                  <%=FormattingHelper.formatString(participant.getSzSdsPptPartRelationship())%>
                </td>
              </tr>
              <%loopCounter++;
          } // end while (enum_list.hasMoreElements())

          %>
            </table>
          </div>
        </impact:pagination>

        <table border="0" cellpadding="3" cellspacing="0" width="100%">
          <tr>
            <td>
              <impact:ButtonTag name="<%= PPTConversation.DELETE_BUTTON_ON_PPT_PAGE %>" img="btnDelete" align="left" form="frmPPTInformation" action="/subcare/PPT/deletePPTParticipant" function="return confirmRowSelected()" navAwayCk="true" restrictRepost="true"
                tabIndex="<%= tabIndex++ %>" />
            </td>
            <td>
              <impact:ButtonTag name="btnAdd" img="btnAdd" align="right" form="frmPPTInformation" action="/subcare/PPT/addPPTParticipant" navAwayCk="true" function="cancelValidation();" restrictRepost="true" tabIndex="<%= tabIndex++ %>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <%} else {%>
  <table border="0" cellspacing="0" cellpadding="3" class="tableborder" width="100%">
    <tr>
      <th>
        Participation
      </th>
    </tr>
    <tr>
      <td class="tableBG">
        <div id="pptParticipation" style="height:50px; width:760px; overflow:auto">
          <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableborderList">
            <tr>
              <th class="thList">
                &nbsp;
              </th>
              <th class="thList">
                Name
              </th>
              <th class="thList">
                Notified
              </th>
              <th class="thList">
                Notification Type
              </th>
              <th class="thList">
                Participated
              </th>
              <th class="thList">
                Relationship/Interest
              </th>
            </tr>
            <tr>
              <td colspan="6" class="subDetail">
                <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
              </td>
            </tr>
          </table>
        </div>

        <table border="0" cellpadding="3" cellspacing="0" width="100%">
          <tr>
            <td>
              <impact:ButtonTag name="btnAdd" img="btnAdd" align="right" form="frmPPTInformation" action="/subcare/PPT/addPPTParticipant" navAwayCk="true" function="cancelValidation();" restrictRepost="true" tabIndex="<%= tabIndex++ %>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <%} // end if (csub27so.getROWCSUB27SOG00_ARRAY().getUlRowQty() > 0)
      } // end if (!csub29so.getROWCSUB29SOG01().getSzCdEventStatus().equals(CodesTables.CEVTSTAT_NEW))
%>
<%
//*****************
//**** BUTTONS ****
//*****************
%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td class="alignLeft" width="85%">
        &nbsp;
      </td>
      <td class="alignRight">
      	<impact:ifThen test="<%= displayAddContStndsBtn%>">
      		<impact:ButtonTag name="btnAddContactStandards" img="btnAddContactStandards" form="frmPPTInformation" restrictRepost="true" action="/subcare/PPT/addContactStandards" function="cancelValidation();" align="right" tabIndex="<%= tabIndex++ %>" />
        </impact:ifThen>
      	<impact:ifThen test="<%= displayViewContStndsBtn%>">
      		<impact:ButtonTag name="btnViewContactStandards" img="btnViewContactStandards" form="frmPPTInformation" restrictRepost="true" action="/subcare/PPT/displayContactStandards" function="cancelValidation();" align="right" tabIndex="<%= tabIndex++ %>" />
        </impact:ifThen>
      </td>
      <td class="alignRight">
        <impact:ifThen test="<%= displaySubmit %>">
          <impact:ButtonTag name="btnSaveAndSubmit" img="btnSaveAndSubmit" form="frmPPTInformation" restrictRepost="true" action="/subcare/PPT/saveAndSubmitPPT" align="right" tabIndex="<%= tabIndex++ %>" />
        </impact:ifThen>
      </td>      
      <td class="alignRight">
        <%
      //SIR19787 added preventDoubleClick="true" to ButtonTag for Save
      %>
        <impact:ButtonTag name="<%= PPTConversation.SAVE_BUTTON_ON_PPT_PAGE %>" function="return confirmSave()" img="btnSave" align="right" form="frmPPTInformation" action="/subcare/PPT/savePPT" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
<%
//******************************************
//**** FORM (PPT INFORMATION) ENDS HERE ****
//******************************************
%>

<%
//***************
//**** FORMS ****
//***************

// If page is viewed in the ONG/FPR stage then show the 
// teamnarrong template
String docType = "teamnarr";

// STGAP00010663 Displaing the teamnarrong when in the ongoing stage and meeting type is FTM only 
if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request)) && CodesTables.CMEETTYP_FTM.equals(txtMeetingType) ) {
  docType = "teamnarrong";
}
%>
<br>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td>
      <impact:documentButton pageMode="<%= pageMode %>" buttonUrl="/grnds-docs/images/shared/btnNarrative.gif" tabIndex="<%= tabIndex++ %>" accessKey="W">

        <impact:document
          displayName="TeamNarrative"
          checkForNewMode="true"
          name="TeamNarrative"
          docType="<%= docType %>"
          docExists="<%= docExists%>"
          protectDocument="<%= protectNarrative%>">
          <impact:documentParameter name="sEvent" value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>" />
          <impact:documentParameter name="sCase" value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>" />
        </impact:document>
      </impact:documentButton>
    </td>
  </tr>
</table>