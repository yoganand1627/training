package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB59SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.admin.OutputLaunchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public final class OutputLaunch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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
  

      out.write("\r\n\r\n<!--Start Main Content-->\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest(EventSearchConversation.isVisitationPlan(taskCD));
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  function switchDocTypetoEnglish()\r\n  {\r\n    frmDocumentTag.switchLanguage.value = '");
          out.print(OutputLaunchConversation.ENGLISH);
          out.write("';\r\n    frmDocumentTag.docType.value =\r\n    '");
          out.print(Lookup.simpleDecodeSafe("CEVNTDOC", OutputLaunchConversation.ENG_VISIT_EVENT_TYPE));
          out.write("';\r\n    frmDocumentTag.eventType.value = '");
          out.print(OutputLaunchConversation.ENG_VISIT_EVENT_TYPE);
          out.write("';\r\n    frmDocumentTag.taskCD.value = '");
          out.print(EventSearchConversation.getEnglishVisitationTaskCode(taskCD));
          out.write("';\r\n  }\r\n\r\n  function switchDocTypetoSpanish()\r\n  {\r\n    frmDocumentTag.switchLanguage.value = '");
          out.print(OutputLaunchConversation.SPANISH);
          out.write("';\r\n    frmDocumentTag.docType.value =\r\n    '");
          out.print(Lookup.simpleDecodeSafe("CEVNTDOC", OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE));
          out.write("';\r\n    frmDocumentTag.eventType.value = '");
          out.print(OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE);
          out.write("';\r\n    frmDocumentTag.taskCD.value = '");
          out.print(EventSearchConversation.getSpanishVisitationTaskCode(taskCD));
          out.write("';\r\n  }\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  function submitPage()\r\n  {\r\n    if (frmOutputLaunch.eventStatus.value == '");
      out.print(OutputLaunchConversation.EVENT_STATUS_PROC);
      out.write("')\r\n    {\r\n      if (frmOutputLaunch.cbOutputComp.checked)\r\n      {\r\n        return true;\r\n      }\r\n      else\r\n      {\r\n        alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_OUTPUT_NOT_COMP));
      out.write("');\r\n        return false;\r\n      }\r\n    }\r\n    else\r\n    {\r\n      return true;\r\n    }\r\n  }\r\n  \r\n  function confirmDelete()\r\n{\r\n  return confirm( \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_CNS_DELETE));
      out.write("\" );\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmOutputLaunch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/OutputLaunch/saveOutputLaunch");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.OutputLaunchCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("eventStatus");
          _jspx_th_impact_validateInput_0.setValue(eventStatus);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("eventType");
          _jspx_th_impact_validateInput_1.setValue(eventType);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("nEvent");
          _jspx_th_impact_validateInput_2.setValue((String) request.getAttribute("nEvent"));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("nCase");
          _jspx_th_impact_validateInput_3.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("timestamp");
          _jspx_th_impact_validateInput_4.setValue(eventLastUpdated);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("dtDtEventOccurred");
          _jspx_th_impact_validateInput_5.setValue(dtDtEventOccurred);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("dateLastUpdated2");
          _jspx_th_impact_validateInput_6.setValue(dateLastUpdated2);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("idVictim");
          _jspx_th_impact_validateInput_7.setValue(idVictim);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("oldIdEvent");
          _jspx_th_impact_validateInput_8.setValue(oldIdEvent);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n");


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

          out.write("\r\n<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprvlStatus");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmOutputLaunch");
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setDisabled("" + bApprovalStatusHide);
          _jspx_th_impact_ButtonTag_0.setAction(action);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n");

}
  }
    }

          out.write("\r\n<table border=\"0\"  width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" >\r\n  <tr>\r\n    <!-- Inserts the document type in the table header -->\r\n    <th colspan=\"5\">");
          out.print(headerName);
          out.write("&nbsp;</th>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  <table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td class=\"formlabel\" width=\"139\">Date Last Updated:</td>\r\n    <td width=\"50%\">");
          out.print(dateLastUpdated);
          out.write("\r\n    </td>\r\n    ");

      if (!bOutputCompletedHide 
        // MR-094 visitation plan no longer displays checkbox
        && !(OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE.equals(eventType)
            || OutputLaunchConversation.ENG_VISIT_EVENT_TYPE.equals(eventType))) {
    
          out.write("\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setName("cbOutputComp");
          _jspx_th_impact_validateInput_9.setLabel("Output Completed");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setChecked("" + bOutputCompletedChecked);
          _jspx_th_impact_validateInput_9.setDisabled("" + !bOutputCompletedEnabled);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");

      } else {
    
          out.write("\r\n    <td>&nbsp;\r\n    </td>\r\n    ");

      }
    
          out.write("\r\n    </tr>\r\n    </table>\r\n    </td>\r\n    </tr>\r\n   <tr>\r\n    ");

      if (!bCurrentHide) {
    
          out.write("\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setName("cbCurrent");
          _jspx_th_impact_validateInput_10.setLabel("Current");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setValue("Y");
          _jspx_th_impact_validateInput_10.setChecked(String.valueOf(bCurrentChecked));
          _jspx_th_impact_validateInput_10.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_validateInput_10.setDisabled("" + ((!bCurrentEnabled
                                              && !CodesTables.CEVTSTAT_COMP.equals(eventStatus)
                                              && !CodesTables.CEVTSTAT_PEND.equals(eventStatus)
                                              && !CodesTables.CEVTSTAT_APRV.equals(eventStatus))
                                            || !GlobalData.hasStageAccess(request)) );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    </tr>\r\n    <tr>\r\n    <td class=\"infoBox\" ><i>The \"Current\" checkbox must be selected for this Visitation Plan to be included in the Foster Care Case Plan.</t>\r\n    </td>\r\n    ");

      } else {
    
          out.write("\r\n    <td>&nbsp;\r\n    </td>\r\n    ");

      }
    
          out.write("\r\n   </tr>\r\n\r\n\r\n\t\t");

		  if (bCNS) { // if event type = CNS
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td><span class=\"formRequiredText\">*</span>\r\n\t\t\t\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setChecked(CodesTables.CDREPTYP_DTH.equals(checkedReportType) ? "true" : "false");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setValue(CodesTables.CDREPTYP_DTH);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setName("rbReportType");
          _jspx_th_impact_validateInput_11.setLabel("Child Death");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setChecked(CodesTables.CDREPTYP_FTY.equals(checkedReportType) ? "true" : "false");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setValue(CodesTables.CDREPTYP_FTY);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setName("rbReportType");
          _jspx_th_impact_validateInput_12.setLabel("Near Fatality");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setChecked(CodesTables.CDREPTYP_INJ.equals(checkedReportType) ? "true" : "false");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setValue(CodesTables.CDREPTYP_INJ);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setName("rbReportType");
          _jspx_th_impact_validateInput_13.setLabel("Serious Injury");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tChild Identifying Information:\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width=\"3%\">\r\n\t\t\t\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td align=left width=\"22%\">\r\n\t\t\t\t\t\t\t");
          out.print(nmFirst);
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t<td width=\"3%\">\r\n\t\t\t\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td align=\"left\" width=\"22%\">\r\n\t\t\t\t\t\t\t");
          out.print(nmMiddle);
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\r\n\r\n\t\t\t\t\t\t<td width=\"3%\">\r\n\t\t\t\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td align=left width=\"22%\">\r\n\t\t\t\t\t\t\t");
          out.print(nmLast);
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t<td width=\"3%\">\r\n\t\t\t\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td align=left width=\"22%\">\r\n\t\t\t\t\t\t\t");
          out.print(FormattingHelper.formatDate(cdnfRetrieveSO.getDtPersonBirth()));
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t\t\tCause of Death/Serious Injury/Near Death:\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

							  int i = 0;
							      Iterator<CodeAttributes> iterator = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CDCAUDEA)
							                                                .iterator();
							      int size = Lookup.getCategoryCollection(CodesTables.CDCAUDEA).size();
							      int half = size / 2;
							
          out.write("\r\n\t\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t");

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
								
          out.write("\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td title=\"");
          out.print(title);
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setName(cbxCauseOfDeath);
          _jspx_th_impact_validateInput_14.setLabel(decode);
          _jspx_th_impact_validateInput_14.setTitle(title);
          _jspx_th_impact_validateInput_14.setChecked(szCheckedCauseOfDeath);
          _jspx_th_impact_validateInput_14.setValue(code);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  }
								        i++;
								      }
								
          out.write("\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t");

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
								
          out.write("\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td title=\"");
          out.print(title);
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setName(cbxCauseOfDeath);
          _jspx_th_impact_validateInput_15.setLabel(decode);
          _jspx_th_impact_validateInput_15.setTitle(title);
          _jspx_th_impact_validateInput_15.setChecked(szCheckedCauseOfDeath);
          _jspx_th_impact_validateInput_15.setValue(code);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  }
								        i++;
								      }
								
          out.write("\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szCommts");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("100");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setDisabled("false");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsCauseDeath()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width = \"20%\">\r\n\t\t\t\t\t\t\tCounty of Death:\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setName("txtSzCounty");
          _jspx_th_impact_validateSelect_0.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_0.setValue(county);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td width = \"20%\">\r\n\t\t\t\t\t\t\tAutopsy Completed:\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setChecked(ArchitectureConstants.Y.equals(autopsyComp) ? "true" : "false");
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setValue("Y");
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setName("rbAutopsyComp");
          _jspx_th_impact_validateInput_16.setId("idAutopsyComp");
          _jspx_th_impact_validateInput_16.setLabel("Yes");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setChecked("P".equals(autopsyComp) ? "true" : "false");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setValue("P");
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setName("rbAutopsyComp");
          _jspx_th_impact_validateInput_17.setId("idAutopsyComp");
          _jspx_th_impact_validateInput_17.setLabel("In Progress");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setChecked(ArchitectureConstants.N.equals(autopsyComp) ? "true" : "false");
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_18.setValue("N");
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setName("rbAutopsyComp");
          _jspx_th_impact_validateInput_18.setId("idAutopsyComp");
          _jspx_th_impact_validateInput_18.setLabel("Not Required");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("szCommts2");
          _jspx_th_impact_validateTextArea_1.setLabel("Comments");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setCols("100");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setDisabled("false");
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsAutopsy()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table>\r\n\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t\t\tTo What Degree Was This Death Believed to be Preventable?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td\r\n\t\t\t\t\t\t\ttitle=\"Not at all preventable refers to deaths for which there are no cures, current technology, or resources available to prevent it. For example, an incurable type of cancer is not at all preventable.  No current amount of medical, educational, social or technological resources could prevent the death from occurring. \">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setChecked(ArchitectureConstants.N.equals(deathPrev) ? "true" : "false");
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setValue("N");
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setName("rbDeathPrev");
          _jspx_th_impact_validateInput_19.setId("idDeathPrev");
          _jspx_th_impact_validateInput_19.setLabel("Not at All");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td\r\n\t\t\t\t\t\t\ttitle=\"Possibly preventable refers to a death for which there is not enough information to determine if it was preventable (example: an infant sleep-related death while bed-sharing a queen size bed with two parents who smoke heavily)\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setChecked("P".equals(deathPrev) ? "true" : "false");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setValue("P");
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setName("rbDeathPrev");
          _jspx_th_impact_validateInput_20.setId("idDeathPrev");
          _jspx_th_impact_validateInput_20.setLabel("Possibly");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td\r\n\t\t\t\t\t\t\ttitle=\" Definitely preventable refers to a death for which the findings and information demonstrate clear action steps that could have been taken that would have prevented the death from occurring (example:  not allowing a ten-year-old child to drive a truck down the street)\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setChecked("D".equals(deathPrev) ? "true" : "false");
          _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_21.setValue("D");
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setName("rbDeathPrev");
          _jspx_th_impact_validateInput_21.setId("idDeathPrev");
          _jspx_th_impact_validateInput_21.setLabel("Definitely");
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("szCommts3");
          _jspx_th_impact_validateTextArea_2.setLabel("Comments");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setCols("102");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setDisabled("false");
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsDeathPrev()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table>\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tWas the Report Submitted Within 24 Hours of County Notification?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setChecked(ArchitectureConstants.Y.equals(repSubWithin24) ? "true" : "false");
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_22.setValue("Y");
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setName("rbRepSub");
          _jspx_th_impact_validateInput_22.setId("idRepSub");
          _jspx_th_impact_validateInput_22.setLabel("Yes");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setChecked(ArchitectureConstants.N.equals(repSubWithin24) ? "true" : "false");
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_23.setValue("N");
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setName("rbRepSub");
          _jspx_th_impact_validateInput_23.setId("idRepSub");
          _jspx_th_impact_validateInput_23.setLabel("No");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("szCommts4");
          _jspx_th_impact_validateTextArea_3.setLabel("Comments");
          _jspx_th_impact_validateTextArea_3.setRows("4");
          _jspx_th_impact_validateTextArea_3.setCols("100");
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setDisabled("false");
          _jspx_th_impact_validateTextArea_3.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(cdnfRetrieveSO.getTxtCommentsRepSub()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n        ");

         //MR-094 Visitation Plans
          } else if(CodesTables.CEVNTTYP_VIS.equals(eventType)
            || CodesTables.CEVNTTYP_VIP.equals(eventType)) {
        
          out.write("\r\n        <tr>\r\n            <th colspan=\"5\"><span class=\"formRequiredText\">*</span> Visitation Type&nbsp;</th>\r\n        </tr>\r\n\t\t<tr>\r\n\t\t   <td> ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxVisitationTypes");
          _jspx_th_impact_codesCheckbox_0.setColumns(3);
          _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CVSTNTYP );
          _jspx_th_impact_codesCheckbox_0.setDisabled( "" + (CodesTables.CEVTSTAT_COMP.equals(eventStatus) 
		                            || CodesTables.CEVTSTAT_PEND.equals(eventStatus) 
                                    || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) );
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(visitTypeList);
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t  \r\n\t\t    </td>\r\n\t\t</tr>\r\n\t\t");

		  } else {
		
          out.write("\r\n\t\t<tr>\r\n\t<td>&nbsp;\r\n    </td>\r\n    </tr>\r\n    ");

      }
    
          out.write("\r\n</table>\r\n \r\n\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n  <tr>\r\n  ");

    if (delete) {
  
          out.write("\r\n\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDelete");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setForm("frmOutputLaunch");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/OutputLaunch/deleteOutputLaunch");
          _jspx_th_impact_ButtonTag_1.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t\t  \r\n    <td width=\"80%\">\r\n      &nbsp;\r\n    </td>\r\n    ");

    if(eventType.equals(OutputLaunchConversation.SPAN_VISIT_EVENT_TYPE)
          || eventType.equals(OutputLaunchConversation.ENG_VISIT_EVENT_TYPE)){
    
          out.write("\r\n    <td align=\"right\" width=\"10%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnComplete");
          _jspx_th_impact_ButtonTag_2.setImg("btnCompleteQ");
          _jspx_th_impact_ButtonTag_2.setForm("frmOutputLaunch");
          _jspx_th_impact_ButtonTag_2.setDisabled("" + (bCurrentHide 
                                    || CodesTables.CEVTSTAT_COMP.equals(eventStatus) 
                                    || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) );
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setAction("/admin/OutputLaunch/saveOutputLaunch");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");

    } else {
    
          out.write("\r\n    <td align=\"right\" width=\"10%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_3.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_3.setForm("frmOutputLaunch");
          _jspx_th_impact_ButtonTag_3.setDisabled("" + bSubmitButtonHide);
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setAction("/admin/OutputLaunch/saveSubmitOutputLaunch");
          _jspx_th_impact_ButtonTag_3.setFunction("return submitPage()");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");

    }
    
          out.write("\r\n\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnCompletionCheck");
          _jspx_th_impact_ButtonTag_4.setImg("btnCompleteQ");
          _jspx_th_impact_ButtonTag_4.setForm("frmOutputLaunch");
          _jspx_th_impact_ButtonTag_4.setDisabled( String.valueOf(bShowCompletionButtonHide) );
          _jspx_th_impact_ButtonTag_4.setAction("/admin/OutputLaunch/completionCheck");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    <td align=\"right\" width=\"5%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSave");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setForm("frmOutputLaunch");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setDisabled(String.valueOf(bSaveButtonHide || !GlobalData.hasStageAccess(request)));
          _jspx_th_impact_ButtonTag_5.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_5.setAction("/admin/OutputLaunch/saveOutputLaunch");
          _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode(pageMode);
      _jspx_th_impact_documentButton_0.setTabIndex(tabIndex++);
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnDocument.gif");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName(headerName);
          _jspx_th_impact_document_0.setName("frmDocumentTag");
          _jspx_th_impact_document_0.setProtectDocument(bProtectDocument);
          _jspx_th_impact_document_0.setPreFillAlways(bPrefillAlways);
          _jspx_th_impact_document_0.setCheckStage(stageID);
          _jspx_th_impact_document_0.setDocType(docType);
          _jspx_th_impact_document_0.setCreateNewEvent(bCreateNewEvent);
          _jspx_th_impact_document_0.setPostInSameWindow(true);
          _jspx_th_impact_document_0.setCheckForNewMode(bCheckForNewMode);
          _jspx_th_impact_document_0.setAction("/admin/OutputLaunch/displayDocument");
          _jspx_th_impact_document_0.setDocExists(bDocumentExists);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("                         \r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(eventID));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sStage");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(stageID));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("sCase");
              _jspx_th_impact_documentParameter_2.setValue(String.valueOf(caseID));
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pStage");
              _jspx_th_impact_documentParameter_3.setValue(String.valueOf(stageID));
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_4.setName("pEvent");
              _jspx_th_impact_documentParameter_4.setValue(String.valueOf(eventID));
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_5.setName("pPerson");
              _jspx_th_impact_documentParameter_5.setValue(String.valueOf(personID));
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_6 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_6.setName("nEvent");
              _jspx_th_impact_documentParameter_6.setValue((String) request.getAttribute("newUseEventID"));
              int _jspx_eval_impact_documentParameter_6 = _jspx_th_impact_documentParameter_6.doStartTag();
              if (_jspx_th_impact_documentParameter_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_7 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_7.setName("nCase");
              _jspx_th_impact_documentParameter_7.setValue((String) request.getAttribute("newUseCaseID"));
              int _jspx_eval_impact_documentParameter_7 = _jspx_th_impact_documentParameter_7.doStartTag();
              if (_jspx_th_impact_documentParameter_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_8 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_8.setName("sTimestamp");
              _jspx_th_impact_documentParameter_8.setValue(sTimestamp);
              int _jspx_eval_impact_documentParameter_8 = _jspx_th_impact_documentParameter_8.doStartTag();
              if (_jspx_th_impact_documentParameter_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_9 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_9.setName("eventType");
              _jspx_th_impact_documentParameter_9.setValue(eventType);
              int _jspx_eval_impact_documentParameter_9 = _jspx_th_impact_documentParameter_9.doStartTag();
              if (_jspx_th_impact_documentParameter_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_10 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_10.setName("docType");
              _jspx_th_impact_documentParameter_10.setValue(docType);
              int _jspx_eval_impact_documentParameter_10 = _jspx_th_impact_documentParameter_10.doStartTag();
              if (_jspx_th_impact_documentParameter_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_11 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_11.setName("taskCD");
              _jspx_th_impact_documentParameter_11.setValue(taskCD);
              int _jspx_eval_impact_documentParameter_11 = _jspx_th_impact_documentParameter_11.doStartTag();
              if (_jspx_th_impact_documentParameter_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              if (_jspx_meth_impact_documentParameter_12(_jspx_th_impact_document_0, _jspx_page_context))
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_13 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_13.setName("pResourceId");
              _jspx_th_impact_documentParameter_13.setValue(String.valueOf(idResource));
              int _jspx_eval_impact_documentParameter_13 = _jspx_th_impact_documentParameter_13.doStartTag();
              if (_jspx_th_impact_documentParameter_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n\r\n");

  // JRIOS, 05/22/2003 - A change was made to the document architecture so
  // that it no longer expects the docType. Instead, it expects the name of
  // the form that contains the document parameters.
  if (launchType != null) {
    launchType = "frmDocumentTag";
  }

      out.write("\r\n\r\n");
      //  impact:showDocument
      gov.georgia.dhr.dfcs.sacwis.web.document.ShowDocumentTag _jspx_th_impact_showDocument_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.ShowDocumentTag();
      _jspx_th_impact_showDocument_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_showDocument_0.setParent(null);
      _jspx_th_impact_showDocument_0.setDocument(launchType);
      int _jspx_eval_impact_showDocument_0 = _jspx_th_impact_showDocument_0.doStartTag();
      if (_jspx_th_impact_showDocument_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_impact_validateDisplayOnlyField_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_0.setName("dspRepType");
    _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Report Type");
    int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_1.setName("dspNmFirst");
    _jspx_th_impact_validateDisplayOnlyField_1.setLabel("First");
    int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_2.setName("dspNmMiddle");
    _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Middle");
    int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_3.setName("dspNmLast");
    _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Last");
    int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_4.setName("dspChildDOB");
    _jspx_th_impact_validateDisplayOnlyField_4.setLabel("DOB");
    int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_documentParameter_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_12 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
    _jspx_th_impact_documentParameter_12.setName("switchLanguage");
    _jspx_th_impact_documentParameter_12.setValue("");
    int _jspx_eval_impact_documentParameter_12 = _jspx_th_impact_documentParameter_12.doStartTag();
    if (_jspx_th_impact_documentParameter_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
