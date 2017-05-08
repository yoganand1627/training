
<%
  //*  JSP Name:     Output Launch
  //*  Created by:   Heather Dean
  //*  Date Created: 10/08/02
  //*
  //*  Description:
  //*  This JSP allows the user to launch forms/narratives that are not logically
  //*  associated with any other page
  //*
  //** Change History:
  //**  Date      User              Description
  //**  --------  ----------------  --------------------------------------------------
  //**  10/09/02  Heather Dean      Initial jsp creation
  //**  06/24/03  GRIMSHAN          SIR 18416 Set editable mode to all for approval
  //**                              status button
  //**  07/07/03  GRIMSHAN          SIR 18709 Removed invalidate approval popup message from the jsp
  //**                              this is handled in the conversation.
  //**  03/01/2010  arege           STGAP00015749: CAPTA Added code for Child Death/Near Fatality/ Serious Injury Report page
  //**  03/02/2010  arege           STGAP00015749: Modified code to remove repeated code to display Cause of Death checkboxes
  //**  03/02/2010  arege           STGAP00015749: Modified code to change label for Cause of Death Checkboxes
  //**  03/04/2010  arege           STGAP00015749: Aligned fields and added border to outermost table.
  //**  03/15/2010  arege           SMS#47654 CAPTA - CDNFSI Output Completed check box should be enabled for copied event.
  //**  03/18/2010  arege           SMS#48317 Copy function should not copy over the output complete checkbox
  //**	03/23/2010  arege           SMS#48528 Added code to allow users to delete CD/NF/SI events when in PROC or COMP status
  //**  03/25/2010  arege           SMS#48851 Save should allow the user to stay on the page and launch the form.  
  //**  03/29/2010  arege           SMS#49018 User should be able to delete CNS event even if the stage in which it was created is closed.
  //**	03/29/2010  arege           SMS#49098 Cause of Death options are arranged alphabetically first down the column then across	
  //**  05/05/2010  arege			SMS#49018 User should be able to modify an CD/NF/SI event even if the stage in which it was created is closed.
  //**  05/24/2010  arege           SMS#54782 Added radio buttons to capture report type.  	
  //**  06/07/2010  arege           SMS#54782: Error message for required field should specify the name of required field. 
  //**  09/09/2011  cwells          STGAP00017068: ECEM 5.0 Initial development for Permanency Roundtable. 		
  //**  10/05/2011  pnguyen         MR-094: Visitation Type	
  //**  10/07/2011  cwells          172674: ECEM 5.0 Initial Development for Safety Roundtable form																																																																																																																																																																																																																																						
  //**  10/14/2011  hnguyen         STGAP00017012: MR-094 Disable Visitation form when event in COMP or APRV																																																																																																																																																																																																																																	
  //**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB59SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.OutputLaunchConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String ASMode = PageModeConstants.VIEW; //initialize approval status mode to view
  String dateLastUpdated = null;
  String dateLastUpdated2 = null;
  String eventLastUpdated = null;
  String dtDtEventOccurred = null;
  String headerName = "None";
  String eventType = null;
  String eventStatus = "";
  String cIndCurrent = "";
  String taskCD = GlobalData.getSzCdTask(request);
  RenderType renderFormat = RenderType.HTML_WITH_SHELL;
  int caseID = GlobalData.getUlIdCase(request);
  int stageID = GlobalData.getUlIdStage(request);
  int eventID = GlobalData.getUlIdEvent(request);
  int idResource = GlobalData.getUlIdResource(request);

  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  int personID = userProfile.getUserID();

  Date timestamp = null;
  String sTimestamp = null;

  //Initialize the variables that will specify the display rules for individual fields
  boolean bHasBeenSubmitted = false;
  boolean bApprovalStatusHide = true;
  boolean bLanguageBtnHide = true;
  boolean bLanguageBtnEnabled = false;
  boolean bLanguageEnglish = true;
  boolean bOutputCompletedEnabled = false;
  boolean bOutputCompletedChecked = false;
  boolean bCurrentEnabled = false;
  boolean bOutputCompletedHide = false;
  boolean bDocumentExists = false;
  boolean bSaveButtonHide = true;
  boolean bSubmitButtonHide = true;
  boolean bProtectDocument = true;
  boolean bCreateNewEvent = false;
  boolean bCurrentHide = true;
  boolean bCurrentChecked = false;
  boolean bProtectFormDocument = false;
  boolean bPrefillAlways = false;
  boolean bShowCompletionButtonHide = true;
  //CDNFSI fields
  boolean bCheckForNewMode = false;
  String county = "";
  String autopsyComp = "";
  String deathPrev = "";
  String repSubWithin24 = "";
  boolean bCNS = false;
  String comments = "";
  String commentsAutComp = "";
  String commentsDeathPrev = "";
  String commentsRep24hrs = "";
  String nmFirst = "";
  String nmLast = "";
  String nmMiddle = "";
  List<String> savedCauses = new ArrayList<String>();
  String SIDShelp = MessageLookup.getMessageByNumber(Messages.MSG_SIDS_HELP);
  String SUIDhelp = MessageLookup.getMessageByNumber(Messages.MSG_SUID_HELP);
  String MediHelp = MessageLookup.getMessageByNumber(Messages.MSG_MEDI_HELP);
  String pageMode = PageMode.getPageMode(request);
  String idVictim = "";
  String oldIdEvent = "";
  boolean delete = true;
  String cdStage = StringHelper.EMPTY_STRING;
  String checkedReportType = StringHelper.EMPTY_STRING;

  if (CaseUtility.hasBeenSubmittedForApproval(eventID)) {
    bHasBeenSubmitted = true;
  }

  String docType = (String) request.getAttribute("docType");

  String launchType = null;
  if (request.getAttribute("launchType") != null && !FormValidation.pageHasErrorMessages(request)
      && !FormValidation.pageHasValidationMessages("frmOutputLaunch", request)) {
    launchType = (String) request.getAttribute("launchType");
  }

  CSUB59SO csub59so = (CSUB59SO) request.getAttribute("CSUB59SO");
  CDNFRetrieveSO cdnfRetrieveSO = (CDNFRetrieveSO) request.getAttribute("CDNFRetrieveSO");
  if (cdnfRetrieveSO != null) {
    county = cdnfRetrieveSO.getCountyOfDeath();
    autopsyComp = cdnfRetrieveSO.getAutopsyCompleted();
    deathPrev = cdnfRetrieveSO.getDeathPrev();
    repSubWithin24 = cdnfRetrieveSO.getReportSubmittedWith24Hrs();
    nmFirst = (cdnfRetrieveSO.getNmFirst() != null) ? cdnfRetrieveSO.getNmFirst() : StringHelper.EMPTY_STRING;
    nmLast = (cdnfRetrieveSO.getNmLast() != null) ? cdnfRetrieveSO.getNmLast() : StringHelper.EMPTY_STRING;
    nmMiddle = (cdnfRetrieveSO.getNmMiddle() != null) ? cdnfRetrieveSO.getNmMiddle() : StringHelper.EMPTY_STRING;
    savedCauses = cdnfRetrieveSO.getSavedCausesOfDeath();
    idVictim = String.valueOf(cdnfRetrieveSO.getIdChild());
    oldIdEvent = String.valueOf(cdnfRetrieveSO.getIdEvent());
    state.setAttribute("savedCauses", savedCauses, request);
    cdStage = cdnfRetrieveSO.getCdStage();
    //SMS#54782    
    checkedReportType = cdnfRetrieveSO.getReportType();    
  }
  
  if(StringHelper.isEmptyOrNull(checkedReportType)){  
    checkedReportType = request.getParameter("rbReportType");  
  }

  if (csub59so == null) {
    headerName = "Retrieve Error - No object returned";
  } else {
    //If csub59so is not null then we can get the output row out
    ROWCSUB59SOG00 outputRow = csub59so.getROWCSUB59SOG00();
    //this is the unformatted timestamp for the narrative
    timestamp = csub59so.getTsLastUpdate();
    sTimestamp = String.valueOf(timestamp);
    //mm/dd/yyyy timestamp for the narrative
    dateLastUpdated = FormattingHelper.formatDate(csub59so.getTsLastUpdate());

    if (outputRow != null) {
      bOutputCompletedChecked = "Y".equals(outputRow.getCIndCurrent()) ? true : false;
    } else {
      bOutputCompletedChecked = false;
    }

    dateLastUpdated2 = String.valueOf(outputRow.getTsSysTsLastUpdate2());
    cIndCurrent = outputRow.getCIndCurrent();

    bCurrentChecked = "Y".equals(cIndCurrent) ? true : false;

    if (outputRow != null) {
      eventLastUpdated = String.valueOf(outputRow.getTsLastUpdate());
      dtDtEventOccurred = String.valueOf(outputRow.getDtDtEventOccurred());

      //if new event status, don't get from output row
      if (!"".equals(outputRow.getSzCdEventStatus())) {
        eventStatus = outputRow.getSzCdEventStatus();
      }

      if (outputRow.getSzCdEventType() != null && !"".equals(outputRow.getSzCdEventType())) {
        eventType = outputRow.getSzCdEventType();
      }
    }

    if (CodesTables.CEVNTTYP_CNS.equals(eventType)) {
      bCNS = true;
      bCheckForNewMode = true;
    }
    if (CodesTables.CEVNTTYP_VIS.equals(eventType)) {
      bCheckForNewMode = false;
      bPrefillAlways = true;
       
    }

    if (CodesTables.CEVNTTYP_RVF.equals(eventType)) {
      bPrefillAlways = true;
    }
    //Overwrite narrative timestamp with sTimestamp from request if it's there
    if (request.getAttribute("sTimestamp") != null) {
      sTimestamp = (String) request.getAttribute("sTimestamp");
    }

    //Visitation Plan header for both English and Spanish docs
    if (OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE.equals(eventType)
        || OutputLaunchConversation.ENG_VISIT_EVENT_TYPE.equals(eventType)) {
      headerName = OutputLaunchConversation.VISIT_PLAN_HEADER;
    } else if (eventType.equals(OutputLaunchConversation.RISK_ASMT_EVENT_TYPE)) {
      headerName = OutputLaunchConversation.RISK_ASMT_HEADER;
    } else {
      headerName = Lookup.simpleDecodeSafe(OutputLaunchConversation.CODE_TABLE_EVENT_TYPE, eventType);
    }

    //Set up display for page modes
    if (pageMode.equals(PageModeConstants.NEW)) {
      bOutputCompletedChecked = false;
      bOutputCompletedEnabled = true;
      bLanguageBtnEnabled = true;
      bDocumentExists = false;
      bSaveButtonHide = false;
      bSubmitButtonHide = false;
      bProtectDocument = false;
      bCreateNewEvent = true;
    }

    if (pageMode.equals(PageModeConstants.NEW_USING)) {
      bOutputCompletedChecked = false;
      bOutputCompletedEnabled = false;
      bLanguageBtnEnabled = false;
      bSaveButtonHide = false;
      bSubmitButtonHide = false;
      bProtectDocument = false;
      bCreateNewEvent = true;
    }

    //hide output complete box if ASM or MDH
    if (eventType.equals(OutputLaunchConversation.RISK_ASMT_EVENT_TYPE)
        || eventType.equals(OutputLaunchConversation.MED_DEV_EVENT_TYPE)) {
      bOutputCompletedHide = true;
    }

    if (pageMode.equals(PageModeConstants.EDIT)) //Set the page up for edit mode
    {
      bProtectDocument = false;
      //Enable the save button in edit mode for all doc types
      bSaveButtonHide = false;

      //only show submit button if not ASM or MDH
      if (eventType.equals(OutputLaunchConversation.RISK_ASMT_EVENT_TYPE)
          || eventType.equals(OutputLaunchConversation.MED_DEV_EVENT_TYPE)) {
        bSubmitButtonHide = true;
        bOutputCompletedHide = true;
        bApprovalStatusHide = true; //for the sake of redundancy
      } else //document type is neither Risk Assmt or Med/Dev Hist
      {
        bSubmitButtonHide = false;
        bOutputCompletedEnabled = true;
      }
    } //end if page mode is edit

    if (pageMode.equals(PageModeConstants.VIEW)) {
      //Set up the page for View mode
      bSubmitButtonHide = true;
      bSaveButtonHide = true;
      bOutputCompletedEnabled = false;
      bLanguageBtnEnabled = false;
      bProtectDocument = true;
      renderFormat = RenderType.PDF;
      ASMode = PageModeConstants.VIEW;

    } //end if page mode is view

    //if Event Status has a value beyond 'PROC'  or 'NEW' then the output is completed
    if (OutputLaunchConversation.EVENT_STATUS_COMP.equals(eventStatus)
        || OutputLaunchConversation.EVENT_STATUS_PEND.equals(eventStatus)
        || OutputLaunchConversation.EVENT_STATUS_APRV.equals(eventStatus)) {
      bOutputCompletedChecked = true;
      bOutputCompletedEnabled = false;
      bLanguageBtnEnabled = false;
      if (eventType.equals(OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE)
          || eventType.equals(OutputLaunchConversation.ENG_VISIT_EVENT_TYPE)) {
        bSaveButtonHide = false;
        bCurrentEnabled = true;
        bProtectDocument = true;
      }
    }

    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      bApprovalStatusHide = false;
      bProtectDocument = false;
    }

    if (pageMode.equals(PageModeConstants.NEW_USING)) {
      bOutputCompletedEnabled = true;
      bOutputCompletedChecked = false;
    }

    //if Event Status is pending, approved, or rejected, show the approval status submodule
    if (OutputLaunchConversation.EVENT_STATUS_PEND.equals(eventStatus)
        || OutputLaunchConversation.EVENT_STATUS_APRV.equals(eventStatus)
        || OutputLaunchConversation.EVENT_STATUS_REJT.equals(eventStatus)
        || (OutputLaunchConversation.EVENT_STATUS_COMP.equals(eventStatus) && bHasBeenSubmitted)) {
      bApprovalStatusHide = false;
    } // end if pend, approve, reject

    //document exists if date last updated has a value
    if (!"".equals(FormattingHelper.formatString(dateLastUpdated))) {
      bDocumentExists = true;
    }

    // form document cannot be modified once the home has been approved.
    if (OutputLaunchConversation.EVENT_STATUS_APRV.equals(eventStatus)
        || pageMode.equals(PageModeConstants.APPROVE)
        || (OutputLaunchConversation.EVENT_STATUS_COMP.equals(eventStatus) && bHasBeenSubmitted) || (OutputLaunchConversation.EVENT_STATUS_COMP.equals(eventStatus) && (OutputLaunchConversation.PERM_ROUNDTABLE_EVENT_TYPE.equals(eventType) || OutputLaunchConversation.SAFETY_ROUNDTABLE_EVENT_TYPE.equals(eventType) ))) {
      bProtectDocument = true;
    }

    if (OutputLaunchConversation.ENG_VISIT_EVENT_TYPE.equals(eventType)
        || OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE.equals(eventType)) {
      bLanguageBtnHide = false;
      bCurrentHide = false;
      //if the doc type is VIP, language is spanish
      if (OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE.equals(eventType)) {
        bLanguageEnglish = false;
      }
    }
  }

  // SIR 17676 if we are in approval mode hide the save and submit pushbutton.
  if (GlobalData.isApprovalMode(request)) {
    bSubmitButtonHide = true;
  }

  // Do not show Delete button when the event is NEW or page mode is in VIEW or eventstatus is PEND
  if ((GlobalData.getUlIdEvent(request) == 0) || PageModeConstants.VIEW.equals(pageMode)
      || CodesTables.CEVTSTAT_PEND.equals(eventStatus) || !bCNS) {
    delete = false;
  }

  //Show the delete button if event status is PROC or COMP so that the CNS event can be deleted even if 
  //the stage in which it was created is closed
  if ((OutputLaunchConversation.EVENT_STATUS_PEND.equals(eventStatus)
       || OutputLaunchConversation.EVENT_STATUS_PROC.equals(eventStatus) || OutputLaunchConversation.EVENT_STATUS_COMP
                                                                                                                      .equals(eventStatus))
      && bCNS) {
    pageMode = PageModeConstants.EDIT;
    delete = true;
    bSaveButtonHide = false;
    bSubmitButtonHide = false;
    bProtectDocument = false;
  }
  
  if (OutputLaunchConversation.PERM_ROUNDTABLE_EVENT_TYPE.equals(eventType) ||OutputLaunchConversation.SAFETY_ROUNDTABLE_EVENT_TYPE.equals(eventType) ) {
      bSaveButtonHide = false;
      bSubmitButtonHide = true;
      bSaveButtonHide = true;
      bOutputCompletedHide = true;
      bShowCompletionButtonHide = OutputLaunchConversation.EVENT_STATUS_COMP.equals(eventStatus) ?  true : false;
    }
  
  // 

  if ((OutputLaunchConversation.EVENT_STATUS_PEND.equals(eventStatus) || OutputLaunchConversation.EVENT_STATUS_PROC
                                                                                                                   .equals(eventStatus))
      && bCNS) {
    bOutputCompletedEnabled = true;

  }

  
  int tabIndex = 1;
  
   //MR-094 Visitation Type
 List<String> visitTypeList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxVisitationTypes"));
   VisitCbxDisplay_Array cbxArray = csub59so.getVisitCbxDisplay_Array();
    if(cbxArray != null && cbxArray.getUlRowQty() > 0) {
      visitTypeList = new ArrayList<String>();
      for(VisitCbxDisplay cbxDisplay : cbxArray.getVisitCbxDisplay()) {
       visitTypeList.add(cbxDisplay.getSzCdVisitTypeCbx());
    
      }
    }
  
%>

<!--Start Main Content-->

<script type="text/javascript" language="JavaScript1.2">
  <impact:ifThen test="<%=EventSearchConversation.isVisitationPlan(taskCD)%>">
  function switchDocTypetoEnglish()
  {
    frmDocumentTag.switchLanguage.value = '<%=OutputLaunchConversation.ENGLISH%>';
    frmDocumentTag.docType.value =
    '<%=Lookup.simpleDecodeSafe("CEVNTDOC", OutputLaunchConversation.ENG_VISIT_EVENT_TYPE)%>';
    frmDocumentTag.eventType.value = '<%=OutputLaunchConversation.ENG_VISIT_EVENT_TYPE%>';
    frmDocumentTag.taskCD.value = '<%=EventSearchConversation.getEnglishVisitationTaskCode(taskCD)%>';
  }

  function switchDocTypetoSpanish()
  {
    frmDocumentTag.switchLanguage.value = '<%=OutputLaunchConversation.SPANISH%>';
    frmDocumentTag.docType.value =
    '<%=Lookup.simpleDecodeSafe("CEVNTDOC", OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE)%>';
    frmDocumentTag.eventType.value = '<%=OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE%>';
    frmDocumentTag.taskCD.value = '<%=EventSearchConversation.getSpanishVisitationTaskCode(taskCD)%>';
  }
  </impact:ifThen>

  function submitPage()
  {
    if (frmOutputLaunch.eventStatus.value == '<%=OutputLaunchConversation.EVENT_STATUS_PROC%>')
    {
      if (frmOutputLaunch.cbOutputComp.checked)
      {
        return true;
      }
      else
      {
        alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_OUTPUT_NOT_COMP)%>');
        return false;
      }
    }
    else
    {
      return true;
    }
  }
  
  function confirmDelete()
{
  return confirm( "<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_CNS_DELETE)%>" );
}

</script>

<impact:validateErrors/>

<impact:validateForm name="frmOutputLaunch"
                     method="post"
                     action="/admin/OutputLaunch/saveOutputLaunch"
                     pageMode="<%=pageMode%>"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.OutputLaunchCustomValidation"                    
                     schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="eventStatus" value="<%=eventStatus%>"/>
<impact:validateInput type="hidden" name="eventType" value="<%=eventType%>"/>
<impact:validateInput type="hidden" name="nEvent" value='<%=(String) request.getAttribute("nEvent")%>'/>
<impact:validateInput type="hidden" name="nCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>"/>
<impact:validateInput type="hidden" name="timestamp" value="<%=eventLastUpdated%>"/>
<impact:validateInput type="hidden" name="dtDtEventOccurred" value="<%=dtDtEventOccurred%>"/>
<impact:validateInput type="hidden" name="dateLastUpdated2" value="<%=dateLastUpdated2%>"/>
<impact:validateInput type="hidden" name="idVictim" value="<%=idVictim%>"/>
<impact:validateInput type="hidden" name="oldIdEvent" value="<%=oldIdEvent%>"/>


<%

if (!(OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE.equals(eventType)
            || OutputLaunchConversation.ENG_VISIT_EVENT_TYPE.equals(eventType))){

  if (!bApprovalStatusHide) {
      //Added this code to ensure that when Supervisor clicks on Approval Status button 
      // without clicking on Save first the page gets save with the changes made by the supervisor  
      if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
        String action = ApprovalStatusConversation.DISPLAY_URI;
        if (GlobalData.isApprovalMode(request)) {
          action = "/admin/OutputLaunch/submitApproval";
        }
%>
<table border="0" width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td>
      <impact:ButtonTag
              name="btnApprvlStatus"
              img="btnApprovalStatus"
              form="frmOutputLaunch"
              editableMode="<%=EditableMode.ALL%>"
              disabled='<%="" + bApprovalStatusHide%>'
              action="<%=action%>" 
              tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<br>
<%
}
  }
    }
%>
<table border="0"  width="100%" cellpadding="3" cellspacing="0" class="tableBorder" >
  <tr>
    <!-- Inserts the document type in the table header -->
    <th colspan="5"><%=headerName%>&nbsp;</th>
  </tr>
  <tr>
  <td>
  <table border="0" width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td class="formlabel" width="139">Date Last Updated:</td>
    <td width="50%"><%=dateLastUpdated%>
    </td>
    <%
      if (!bOutputCompletedHide 
        // MR-094 visitation plan no longer displays checkbox
        && !(OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE.equals(eventType)
            || OutputLaunchConversation.ENG_VISIT_EVENT_TYPE.equals(eventType))) {
    %>
    <td>
      <impact:validateInput tabIndex="<%=tabIndex++%>"
                            type="checkbox"
                            name="cbOutputComp"
                            label="Output Completed"
                            cssClass="formInput"
                            checked='<%="" + bOutputCompletedChecked%>'
                            disabled='<%="" + !bOutputCompletedEnabled%>'/>
    </td>
    <%
      } else {
    %>
    <td>&nbsp;
    </td>
    <%
      }
    %>
    </tr>
    </table>
    </td>
    </tr>
   <tr>
    <%
      if (!bCurrentHide) {
    %>
    <td>
      <impact:validateInput tabIndex="<%=tabIndex++%>"
                            type="checkbox"
                            name="cbCurrent"
                            label="Current"
                            cssClass="formInput"
                            value="Y"
                            checked='<%=String.valueOf(bCurrentChecked)%>'
                            editableMode="<%=EditableMode.ALL%>"
                            disabled='<%="" + ((!bCurrentEnabled
                                              && !CodesTables.CEVTSTAT_COMP.equals(eventStatus)
                                              && !CodesTables.CEVTSTAT_PEND.equals(eventStatus)
                                              && !CodesTables.CEVTSTAT_APRV.equals(eventStatus))
                                            || !GlobalData.hasStageAccess(request)) %>'/>
    </td>
    </tr>
    <tr>
    <td class="infoBox" ><i>The "Current" checkbox must be selected for this Visitation Plan to be included in the Foster Care Case Plan.</t>
    </td>
    <%
      } else {
    %>
    <td>&nbsp;
    </td>
    <%
      }
    %>
   </tr>


		<%
		  if (bCNS) { // if event type = CNS
		%>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td><span class="formRequiredText">*</span>
							<impact:validateDisplayOnlyField name="dspRepType"
								label="Report Type" />
						</td>
						<td>
							<impact:validateInput
								checked="<%=CodesTables.CDREPTYP_DTH.equals(checkedReportType) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" 
								value="<%=CodesTables.CDREPTYP_DTH%>" type="radio"
								name="rbReportType" label="Child Death" cssClass="formInput" />
						</td>
						<td>
							<impact:validateInput
								checked="<%=CodesTables.CDREPTYP_FTY.equals(checkedReportType) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CDREPTYP_FTY%>"
								type="radio" name="rbReportType" label="Near Fatality"
								cssClass="formInput" />
						</td>
						<td>
							<impact:validateInput
								checked="<%=CodesTables.CDREPTYP_INJ.equals(checkedReportType) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CDREPTYP_INJ%>"
								type="radio" name="rbReportType" label="Serious Injury"
								cssClass="formInput" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td>
							Child Identifying Information:
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<table border="0" width="100%" cellpadding="3" cellspacing="0">

					<tr>
						<td width="3%">
							<impact:validateDisplayOnlyField name="dspNmFirst" label="First" />
						</td>
						<td align=left width="22%">
							<%=nmFirst%>
						</td>

						<td width="3%">
							<impact:validateDisplayOnlyField name="dspNmMiddle"
								label="Middle" />
						</td>
						<td align="left" width="22%">
							<%=nmMiddle%>
						</td>


						<td width="3%">
							<impact:validateDisplayOnlyField name="dspNmLast" label="Last" />
						</td>
						<td align=left width="22%">
							<%=nmLast%>
						</td>

						<td width="3%">
							<impact:validateDisplayOnlyField name="dspChildDOB" label="DOB" />
						</td>
						<td align=left width="22%">
							<%=FormattingHelper.formatDate(cdnfRetrieveSO.getDtPersonBirth())%>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="5">
							Cause of Death/Serious Injury/Near Death:
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td>
							<%
							  int i = 0;
							      Iterator<CodeAttributes> iterator = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CDCAUDEA)
							                                                .iterator();
							      int size = Lookup.getCategoryCollection(CodesTables.CDCAUDEA).size();
							      int half = size / 2;
							%>
							<table border="0" width="100%" cellpadding="3" cellspacing="0">
								<%
								  for (i = 0; i <= half - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String cbxCauseOfDeath = "cbxCauseOfDeath" + (i + 1);
								          String szCheckedCauseOfDeath = "false";

								          if (savedCauses != null) {
								            if (savedCauses.contains(code)) {
								              szCheckedCauseOfDeath = "true";
								            }
								          }
								%>
								<tr>
									<td title="<%=title%>">
										<impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="<%=cbxCauseOfDeath%>"
											label="<%=decode%>" title="<%=title%>"
											checked="<%=szCheckedCauseOfDeath%>" value="<%=code%>" />
									</td>
								</tr>
								<%
								  }
								        i++;
								      }
								%>
							</table>
						</td>
						<td>
							<table border="0" width="100%" cellpadding="3" cellspacing="0">
								<%
								  for (i = half; i <= size - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          if (decode.startsWith("SIDS")) {
								            title = SIDShelp;
								          } else if (decode.startsWith("SUID")) {
								            title = SUIDhelp;
								          } else if (decode.startsWith("Medical")) {
								            title = MediHelp;
								          }

								          String cbxCauseOfDeath = "cbxCauseOfDeath" + (i + 1);
								          String szCheckedCauseOfDeath = "false";

								          if (savedCauses != null) {
								            if (savedCauses.contains(code)) {
								              szCheckedCauseOfDeath = "true";
								            }
								          }
								%>
								<tr>
									<td title="<%=title%>">
										<impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="<%=cbxCauseOfDeath%>"
											label="<%=decode%>" title="<%=title%>"
											checked="<%=szCheckedCauseOfDeath%>" value="<%=code%>" />
									</td>
								</tr>
								<%
								  }
								        i++;
								      }
								%>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="2">
							<impact:validateTextArea name="szCommts" label="Comments"
								rows="4" cols="100" tabIndex="<%=tabIndex++%>" disabled="false"
								conditionallyRequired="true" constraint="Paragraph500">
								<%=FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsCauseDeath())%>
							</impact:validateTextArea>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td width = "20%">
							County of Death:
						</td>
						<td>
							<impact:validateSelect  required="false"
								blankValue="true" name="txtSzCounty" codesTable="CCOUNT"
								value="<%=county%>" tabIndex="<%=tabIndex++%>" />
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr class="subDetail">
						<td width = "20%">
							Autopsy Completed:
						</td>
						<td>
							<impact:validateInput
								checked="<%=ArchitectureConstants.Y.equals(autopsyComp) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="Y" type="radio"
								name="rbAutopsyComp" id="idAutopsyComp" label="Yes"
								cssClass="formInput" />
						</td>
						<td>
							<impact:validateInput
								checked="<%="P".equals(autopsyComp) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="P" type="radio"
								name="rbAutopsyComp" id="idAutopsyComp" label="In Progress"
								cssClass="formInput" />
						</td>
						<td>
							<impact:validateInput
								checked="<%=ArchitectureConstants.N.equals(autopsyComp) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="N" type="radio"
								name="rbAutopsyComp" id="idAutopsyComp" label="Not Required"
								cssClass="formInput" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="2">
							<impact:validateTextArea name="szCommts2" label="Comments"
								rows="4" cols="100" tabIndex="<%=tabIndex++%>" disabled="false"
								conditionallyRequired="true" constraint="Paragraph500">
								<%=FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsAutopsy())%>
							</impact:validateTextArea>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table>

					<tr class="subDetail">
						<td colspan="5">
							To What Degree Was This Death Believed to be Preventable?
						</td>
						<td
							title="Not at all preventable refers to deaths for which there are no cures, current technology, or resources available to prevent it. For example, an incurable type of cancer is not at all preventable.  No current amount of medical, educational, social or technological resources could prevent the death from occurring. ">
							<impact:validateInput
								checked="<%=ArchitectureConstants.N.equals(deathPrev) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="N" type="radio"
								name="rbDeathPrev" id="idDeathPrev" label="Not at All"
								cssClass="formInput" />
						</td>
						<td
							title="Possibly preventable refers to a death for which there is not enough information to determine if it was preventable (example: an infant sleep-related death while bed-sharing a queen size bed with two parents who smoke heavily)">
							<impact:validateInput
								checked="<%="P".equals(deathPrev) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="P" type="radio"
								name="rbDeathPrev" id="idDeathPrev" label="Possibly"
								cssClass="formInput" />
						</td>
						<td
							title=" Definitely preventable refers to a death for which the findings and information demonstrate clear action steps that could have been taken that would have prevented the death from occurring (example:  not allowing a ten-year-old child to drive a truck down the street)">
							<impact:validateInput
								checked="<%="D".equals(deathPrev) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="D" type="radio"
								name="rbDeathPrev" id="idDeathPrev" label="Definitely"
								cssClass="formInput" />
						</td>

					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="2">
							<impact:validateTextArea name="szCommts3" label="Comments"
								rows="4" cols="102" tabIndex="<%=tabIndex++%>" disabled="false"
								constraint="Paragraph500">
								<%=FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsDeathPrev())%>
							</impact:validateTextArea>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr class="subDetail">
						<td>
							Was the Report Submitted Within 24 Hours of County Notification?
						</td>
						<td>

							<impact:validateInput
								checked="<%=ArchitectureConstants.Y.equals(repSubWithin24) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="Y" type="radio"
								name="rbRepSub" id="idRepSub" label="Yes" cssClass="formInput" />
							<impact:validateInput
								checked="<%=ArchitectureConstants.N.equals(repSubWithin24) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="N" type="radio"
								name="rbRepSub" id="idRepSub" label="No" cssClass="formInput" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="2">
							<impact:validateTextArea name="szCommts4" label="Comments"
								rows="4" cols="100" tabIndex="<%=tabIndex++%>" disabled="false"
								conditionallyRequired="true" constraint="Paragraph500">
								<%=FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsRepSub())%>
							</impact:validateTextArea>
						</td>
					</tr>
				</table>
			</td>
		</tr>
        <%
         //MR-094 Visitation Plans
          } else if(CodesTables.CEVNTTYP_VIS.equals(eventType)
            || CodesTables.CEVNTTYP_VIP.equals(eventType)) {
        %>
        <tr>
            <th colspan="5"><span class="formRequiredText">*</span> Visitation Type&nbsp;</th>
        </tr>
		<tr>
		   <td> <impact:codesCheckbox 
		                name="cbxVisitationTypes"
		                columns="3"
		                codesTableName="<%= CodesTables.CVSTNTYP %>"
		                disabled="<%= "" + (CodesTables.CEVTSTAT_COMP.equals(eventStatus) 
		                            || CodesTables.CEVTSTAT_PEND.equals(eventStatus) 
                                    || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) %>"
                        defaultCodes="<%=visitTypeList%>"
		                tabIndex="<%= tabIndex++ %>"
		                />
		  
		    </td>
		</tr>
		<%
		  } else {
		%>
		<tr>
	<td>&nbsp;
    </td>
    </tr>
    <%
      }
    %>
</table>
 

<table width="100%" cellpadding="3" cellspacing="0" border="0">
  <tr>
  <%
    if (delete) {
  %>
			<td class="alignLeft">
				<impact:ButtonTag name="btnDelete" img="btnDelete" align="left"
					restrictRepost="true" preventDoubleClick="true"
					form="frmOutputLaunch"
					action="/admin/OutputLaunch/deleteOutputLaunch"
					function="return confirmDelete()"					
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
			  }
			%>
			  
    <td width="80%">
      &nbsp;
    </td>
    <%
    if(eventType.equals(OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE)
          || eventType.equals(OutputLaunchConversation.ENG_VISIT_EVENT_TYPE)){
    %>
    <td align="right" width="10%">
      <impact:ButtonTag
              name="btnComplete"
              img="btnCompleteQ"
              form="frmOutputLaunch"
              disabled='<%="" + (bCurrentHide 
                                    || CodesTables.CEVTSTAT_COMP.equals(eventStatus) 
                                    || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) %>'
              restrictRepost="true"
              preventDoubleClick="true"              
              action="/admin/OutputLaunch/saveOutputLaunch"
              tabIndex="<%=tabIndex++%>"/>
    </td>
    <%
    } else {
    %>
    <td align="right" width="10%">
      <impact:ButtonTag
              name="btnSaveSubmit"
              img="btnSaveAndSubmit"
              form="frmOutputLaunch"
              disabled='<%="" + bSubmitButtonHide%>'
              restrictRepost="true"
              preventDoubleClick="true"              
              action="/admin/OutputLaunch/saveSubmitOutputLaunch"
              function="return submitPage()"
              tabIndex="<%=tabIndex++%>"/>
    </td>
    <%
    }
    %>

      <td align="right">
        <impact:ButtonTag
            name="btnCompletionCheck"
            img="btnCompleteQ"
            form="frmOutputLaunch"
            disabled='<%= String.valueOf(bShowCompletionButtonHide) %>'
            action="/admin/OutputLaunch/completionCheck"
            restrictRepost="true"
            preventDoubleClick="true"
            tabIndex="<%= tabIndex++ %>"/>
      </td>
    <td align="right" width="5%">
      <impact:ButtonTag
              name="btnSave"
              img="btnSave"
              form="frmOutputLaunch"
              restrictRepost="true"
              preventDoubleClick="true"
              disabled='<%=String.valueOf(bSaveButtonHide || !GlobalData.hasStageAccess(request))%>'
              editableMode="<%=EditableMode.ALL%>"
              action="/admin/OutputLaunch/saveOutputLaunch"
              tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<br>
</impact:validateForm>


<table width="100%" cellpadding="3" cellspacing="0" border="0">
  <tr>
    <td>
      <impact:documentButton pageMode="<%=pageMode%>"
                             tabIndex="<%=tabIndex++%>"
                             buttonUrl="/grnds-docs/images/shared/btnDocument.gif">

        <impact:document displayName="<%=headerName%>"
                         name="frmDocumentTag"
                         protectDocument="<%=bProtectDocument%>"
                         preFillAlways="<%=bPrefillAlways%>"
                         checkStage="<%=stageID%>"
                         docType="<%=docType%>"
                         createNewEvent="<%=bCreateNewEvent%>"
                         postInSameWindow="true"
                         checkForNewMode="<%=bCheckForNewMode%>"
                         action="/admin/OutputLaunch/displayDocument"
                         docExists="<%=bDocumentExists%>">                         
          <impact:documentParameter name="sEvent" value="<%=String.valueOf(eventID)%>"/>
          <impact:documentParameter name="sStage" value="<%=String.valueOf(stageID)%>"/>
          <impact:documentParameter name="sCase" value="<%=String.valueOf(caseID)%>"/>
          <impact:documentParameter name="pStage" value="<%=String.valueOf(stageID)%>"/>
          <impact:documentParameter name="pEvent" value="<%=String.valueOf(eventID)%>"/>
          <impact:documentParameter name="pPerson" value="<%=String.valueOf(personID)%>"/>
          <impact:documentParameter name="nEvent" value='<%=(String) request.getAttribute("newUseEventID")%>'/>
          <impact:documentParameter name="nCase" value='<%=(String) request.getAttribute("newUseCaseID")%>'/>
          <impact:documentParameter name="sTimestamp" value="<%=sTimestamp%>"/>
          <impact:documentParameter name="eventType" value="<%=eventType%>"/>
          <impact:documentParameter name="docType" value="<%=docType%>"/>
          <impact:documentParameter name="taskCD" value="<%=taskCD%>"/>
          <impact:documentParameter name="switchLanguage" value=""/>
          <impact:documentParameter name="pResourceId" value="<%=String.valueOf(idResource)%>"/>
         </impact:document>
      </impact:documentButton>
    </td>
  </tr>
</table>


<%
  // JRIOS, 05/22/2003 - A change was made to the document architecture so
  // that it no longer expects the docType. Instead, it expects the name of
  // the form that contains the document parameters.
  if (launchType != null) {
    launchType = "frmDocumentTag";
  }
%>

<impact:showDocument document="<%=launchType%>"/>
