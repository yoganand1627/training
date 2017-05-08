package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTConversation;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants;
import java.util.Enumeration;
import java.util.Hashtable;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class PPTInformation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/admin/AdminAddressPhoneSub.jsp");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
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

//*--------------------------------------------------------------------------------
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction confirmSave()\r\n{\r\n  ");

  // The message that was popped up is removed so this function now just returns true.
  
      out.write("\r\n  return true;\r\n}\r\n\r\nfunction convenerMustCreateDoc()\r\n{\r\n  alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_PPT_CONVENER_MUST_CREATE) );
      out.write("\");\r\n  return false;\r\n}\r\n\r\n// The PPT review document is no longer created and thus this code is unnecessary. It\r\n// will be removed once Participant is working to ensure that nothing important is deleted.\r\nfunction checkMeetingDate()\r\n{\r\n  if (document.frmPPTInformation.txtMeetingDate.value == \"\")\r\n  {\r\n    alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_REQ_PPT_REVIEW_DOCUMENT) );
      out.write("\");\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    if (isFormChanged(document.frmPPTInformation))\r\n    {\r\n      alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SAVE_BEFORE_CONTINUE) );
      out.write("\");\r\n      return false;\r\n    }\r\n  }\r\n}\r\n\r\n// Each time the user changes the 'Meeting Date', this function is called\r\n// to set the 'bMeetingDateHasChanged' indicator to \"Y\". (The indicator\r\n// should not be set to \"Y\" if the field was empty initially.)\r\nfunction indicateMeetingDateHasChanged()\r\n{\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( !"".equals(txtMeetingDate) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  document.frmPPTInformation.bMeetingDateHasChanged.value = ArchitectureConstants.Y;\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n}\r\n\r\n// This function confirms that the user has selected a row in the list\r\n// box before continuing with the 'Delete' procedure.\r\nfunction confirmRowSelected()\r\n{\r\n  var rowSelected = false;\r\n\r\n  // If the radio button group is an array (i.e., more than one radio\r\n  // button), then loop through the array and check for a selected radio\r\n  // button; otherwise, check the single radio button to see if it is\r\n  // selected.\r\n  if (document.frmPPTInformation.rbParticipantId_CLEAN[0])\r\n  {\r\n    for (var i = 0; i < document.frmPPTInformation.rbParticipantId_CLEAN.length; i++)\r\n    {\r\n      if (document.frmPPTInformation.rbParticipantId_CLEAN[i].checked)\r\n      {\r\n        rowSelected = true;\r\n        break;\r\n      }\r\n    }\r\n  }\r\n  else\r\n  {\r\n    if (document.frmPPTInformation.rbParticipantId_CLEAN.checked)\r\n    {\r\n      rowSelected = true;\r\n    }\r\n  }\r\n\r\n  if (rowSelected == false)\r\n  {\r\n    alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("\");\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    disableValidation('frmPPTInformation');\r\n    return confirm(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("\");\r\n  }\r\n  return false;\r\n}\r\n\r\n// Takes the user to the Family Plan Item Detail page for the selected\r\n// item.\r\nfunction goToParticipantDetailPage(selectedParticipantId)\r\n{\r\n  document.frmPPTInformation.selectedParticipantId.value = selectedParticipantId;\r\n  setState('frmPPTInformation');\r\n  setValidationUrl('frmPPTInformation', '/subcare/PPT/displayPPTParticipant');\r\n  document.frmPPTInformation.submit();\r\n}\r\nfunction setRequest()\r\n{\r\n cancelValidation();\r\n document.frmPPTInformation.hdnContactStdsReqTaskBack.value='true';\r\n}\r\nfunction cancelValidation ()\r\n{\r\n  disableValidation('frmPPTInformation');\r\n  return true;\r\n}\r\n</script>\r\n\r\n");

//*************************
//*** VALIDATION ERRORS ***
//*************************

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

//********************************************
//**** FORM (PPT INFORMATION) STARTS HERE ****
//********************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPPTInformation");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/PPT/displayPPTInformation");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("bMeetingDateHasChanged");
          _jspx_th_impact_validateInput_1.setValue( ArchitectureConstants.N );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
// If the 'Document Completed' field is empty when the page
      // first loads, a new PPT event should be created if the user
      // enters a 'Document Completed' and saves the page. Set the
      // 'bCreateNewPPTEvent' indicator accordingly.
      String indicatorValue = ArchitectureConstants.N;
      if ("".equals(txtDocumentCompletedDate)) {
        indicatorValue = ArchitectureConstants.Y;
      }

          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("bCreateNewPPTEvent");
          _jspx_th_impact_validateInput_3.setValue( indicatorValue );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
    // SIR 2171 
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

          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  ");
if (approvalStatus) {
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setForm("frmPPTInformation");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ApprovalStatus/displayStatus");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n  ");
} else { 
          out.write("\r\n      <td>&nbsp;</td>\r\n  ");
}
          out.write("\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Meeting Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Meeting Type");
          _jspx_th_impact_validateSelect_0.setName("txtMeetingType");
          _jspx_th_impact_validateSelect_0.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CMEETTYP");
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setExcludeOptions( excludeList.values() );
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(txtMeetingType));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Meeting Date");
          _jspx_th_impact_validateDate_0.setName("txtMeetingDate");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue( txtMeetingDate );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setOnChange("indicateMeetingDateHasChanged()");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setLabel("Start Time");
          _jspx_th_impact_validateTime_0.setName("txtMeetingTime");
          _jspx_th_impact_validateTime_0.setValue( txtMeetingTime );
          _jspx_th_impact_validateTime_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  \r\n  ");
if ("ADM".equals(txtMeetingType)) {
          out.write("\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        Administrative Hearing Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"55%\">\r\n          <tr>\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setLabel("Case Manager Assistance Needed in Requesting an Administrative Hearing");
          _jspx_th_impact_validateInput_4.setName("cbxIndAssistNeeded");
          _jspx_th_impact_validateInput_4.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_4.setChecked(FormattingHelper.formatString(cbxIndAssistNeeded));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Date Hearing Requested");
          _jspx_th_impact_validateDate_1.setName("txtDateHearingReq");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue( txtDateHearingReq );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Outcome Discussed with Parents");
          _jspx_th_impact_validateDate_2.setName("txtOutcomeDiscussed");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setValue( txtOutcomeDiscussed );
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setRequired("false");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");
} //end administrative review
          out.write("\r\n\r\n\r\n  ");
if ("FTM".equals(txtMeetingType)) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        FTM Meeting Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"90%\">\r\n          <tr>\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setLabel("Previous Requirements/Recommendations Met");
          _jspx_th_impact_validateInput_5.setName("cbxPrevReqMet");
          _jspx_th_impact_validateInput_5.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_5.setChecked(FormattingHelper.formatString(cbxPrevReqMet));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setLabel("Preparation Interview");
          _jspx_th_impact_validateDate_3.setName("txtDatePrepIntvw");
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setValue( txtDatePrepIntvw );
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setRequired("false");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");
}//end conditional for FTM meeting.
          out.write("\r\n\r\n  ");
if ("URM".equals(txtMeetingType)) {
          out.write("\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        RBWO Review Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"55%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setLabel("Begin Date");
          _jspx_th_impact_validateDate_4.setName("txtBeginDate");
          _jspx_th_impact_validateDate_4.setType("text");
          _jspx_th_impact_validateDate_4.setValue( txtBeginDate );
          _jspx_th_impact_validateDate_4.setSize("10");
          _jspx_th_impact_validateDate_4.setRequired("true");
          _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_5.setLabel("End Date");
          _jspx_th_impact_validateDate_5.setName("txtEndDate");
          _jspx_th_impact_validateDate_5.setType("text");
          _jspx_th_impact_validateDate_5.setValue( txtEndDate );
          _jspx_th_impact_validateDate_5.setSize("10");
          _jspx_th_impact_validateDate_5.setRequired("true");
          _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_5.setConstraint("Date");
          int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
          if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n\r\n  ");
}//end conditional for Utilization
          out.write("\r\n\r\n  ");
if ("MDT".equals(txtMeetingType)) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        MDT Meeting Regarding\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"80%\">\r\n          <tr>\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setLabel("Permanency");
          _jspx_th_impact_validateInput_6.setName("cbxPermanency");
          _jspx_th_impact_validateInput_6.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_6.setChecked(FormattingHelper.formatString(cbxPermanency));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setLabel("Safety");
          _jspx_th_impact_validateInput_7.setName("cbxSafety");
          _jspx_th_impact_validateInput_7.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_7.setChecked(FormattingHelper.formatString(cbxSafety));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setLabel("Wellbeing");
          _jspx_th_impact_validateInput_8.setName("cbxWellbeing");
          _jspx_th_impact_validateInput_8.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_8.setChecked(FormattingHelper.formatString(cbxWellbeing));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");
}//close conditional for MDT meeting
          out.write("\r\n\r\n  ");
if ("PRM".equals(txtMeetingType)) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        Administrative Hearing Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"60%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_6.setLabel("Permanency Report Completed");
          _jspx_th_impact_validateDate_6.setName("txtPermRepComp");
          _jspx_th_impact_validateDate_6.setType("text");
          _jspx_th_impact_validateDate_6.setValue( txtPermRepComp );
          _jspx_th_impact_validateDate_6.setSize("10");
          _jspx_th_impact_validateDate_6.setRequired("false");
          _jspx_th_impact_validateDate_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_6.setConstraint("Date");
          int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
          if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");
}//close conditional for PRM
          out.write("\r\n  \r\n  ");
if ("FLG".equals(txtMeetingType)) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        FTM Meeting Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"90%\">\r\n          <tr>\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setLabel("Previous Requirements/Recommendations Met");
          _jspx_th_impact_validateInput_9.setName("cbxPrevReqMet");
          _jspx_th_impact_validateInput_9.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_9.setChecked(FormattingHelper.formatString(cbxPrevReqMet));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_7.setLabel("Preparation Interview");
          _jspx_th_impact_validateDate_7.setName("txtDatePrepIntvw");
          _jspx_th_impact_validateDate_7.setType("text");
          _jspx_th_impact_validateDate_7.setValue( txtDatePrepIntvw );
          _jspx_th_impact_validateDate_7.setSize("10");
          _jspx_th_impact_validateDate_7.setRequired("false");
          _jspx_th_impact_validateDate_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_7.setConstraint("Date");
          int _jspx_eval_impact_validateDate_7 = _jspx_th_impact_validateDate_7.doStartTag();
          if (_jspx_th_impact_validateDate_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setLabel("Transition Plan Completed");
          _jspx_th_impact_validateInput_10.setName("cbxTranPlanComp");
          _jspx_th_impact_validateInput_10.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_10.setChecked(FormattingHelper.formatString(cbxTranPlanComp));
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");
}//end conditional for FTM meeting.
          out.write("\r\n\r\n\r\n\r\n  ");
/* BEGIN Admin Address Phone Submodule */
          out.write("\r\n  ");
//----------------
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

      
          out.write("\r\n  ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    AdminAddressPhoneSubDB adminAddressPhoneSubAdminAddressPhoneSubDB = AdminAddressPhoneSubDB.getFromRequest( request );
    String adminAddressPhoneSubFormName = adminAddressPhoneSubAdminAddressPhoneSubDB.getFormName();
    String adminAddressPhoneSubPageMode = adminAddressPhoneSubAdminAddressPhoneSubDB.getPageMode();
    String adminAddressPhoneSubAddressPhoneSectionHeader = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressPhoneSectionHeader();
    boolean adminAddressPhoneSubAddressRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressRequired();
    boolean adminAddressPhoneSubAddressDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressDisabled();
    boolean adminAddressPhoneSubCommentsVisible = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsVisible();
    boolean adminAddressPhoneSubCommentsRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsRequired();
    boolean adminAddressPhoneSubCommentsDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsDisabled();
    boolean adminAddressPhoneSubPhoneRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneRequired();
    boolean adminAddressPhoneSubPhoneDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneDisabled();
    String adminAddressPhoneSubAddressSubmoduleName = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressSubmoduleName();
    String expandableSectionName = adminAddressPhoneSubAddressSubmoduleName + "addPhone";
    int adminAddressPhoneSubTabIndex = adminAddressPhoneSubAdminAddressPhoneSubDB.getTabIndex();

//  boolean commentsVisible = true;

    AdminAddressPhoneBean aapBean = null;
    if ( AdminAddressPhoneBean.isInRequest( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromRequest( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else if ( AdminAddressPhoneBean.isInState( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromState( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else
    {
      aapBean = new AdminAddressPhoneBean();
    }

          out.write("\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName( expandableSectionName );
          _jspx_th_impact_ExpandableSectionTag_0.setId(AdminAddressPhoneBean.PHONE + "_Id" );
          _jspx_th_impact_ExpandableSectionTag_0.setLabel( adminAddressPhoneSubAddressPhoneSectionHeader );
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( adminAddressPhoneSubTabIndex );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" class=\"tableBorder\">\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n        <tr>\r\n          <td width=\"10%\">\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE ) );
              _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatPhone( aapBean.getPhone() ) );
              _jspx_th_impact_validateInput_11.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_11.setType("text");
              _jspx_th_impact_validateInput_11.setRequired( String.valueOf( adminAddressPhoneSubPhoneRequired ));
              _jspx_th_impact_validateInput_11.setLabel("Phone");
              _jspx_th_impact_validateInput_11.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              _jspx_th_impact_validateInput_11.setConstraint("Phone");
              _jspx_th_impact_validateInput_11.setWidth("45%");
              _jspx_th_impact_validateInput_11.setSize("14");
              _jspx_th_impact_validateInput_11.setMaxLength("14");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td width=\"15%\">\r\n             ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_12.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE_EXT ) );
              _jspx_th_impact_validateInput_12.setValue( aapBean.getPhoneExt() );
              _jspx_th_impact_validateInput_12.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_12.setType("text");
              _jspx_th_impact_validateInput_12.setLabel("Extension");
              _jspx_th_impact_validateInput_12.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              _jspx_th_impact_validateInput_12.setConstraint("PhoneExtension");
              _jspx_th_impact_validateInput_12.setWidth("30%");
              _jspx_th_impact_validateInput_12.setSize("8");
              _jspx_th_impact_validateInput_12.setMaxLength("8");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n        </tr>\r\n      </table>\r\n     </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n");
/* BEGIN Address Submodule */
              out.write('\r');
              out.write('\n');

    AddressSubDB adminAddressPhoneAddressSubDB = new AddressSubDB();
    adminAddressPhoneAddressSubDB.setFormName( adminAddressPhoneSubFormName );
    adminAddressPhoneAddressSubDB.setPageMode( adminAddressPhoneSubPageMode );
    adminAddressPhoneAddressSubDB.setAddressSubmoduleName( adminAddressPhoneSubAddressSubmoduleName );
    adminAddressPhoneAddressSubDB.setCommentsVisible( adminAddressPhoneSubCommentsVisible );
    adminAddressPhoneAddressSubDB.setCommentsRequired( adminAddressPhoneSubCommentsRequired );
    adminAddressPhoneAddressSubDB.setCommentsDisabled( adminAddressPhoneSubCommentsDisabled );
    adminAddressPhoneAddressSubDB.setAddressRequired( adminAddressPhoneSubAddressRequired );
    adminAddressPhoneAddressSubDB.setAddressDisabled( adminAddressPhoneSubAddressDisabled );
    adminAddressPhoneAddressSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
    AddressSubDB.setIntoRequest( adminAddressPhoneAddressSubDB, request );

              out.write("\r\n        ");
              out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_13.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_13.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_13.setType("text");
              _jspx_th_impact_validateInput_13.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_13.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_13.setLabel("Street");
              _jspx_th_impact_validateInput_13.setWidth("45%");
              _jspx_th_impact_validateInput_13.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setConstraint("Address");
              _jspx_th_impact_validateInput_13.setSize("50");
              _jspx_th_impact_validateInput_13.setMaxLength("30");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_14.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_14.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_14.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_14.setType("text");
              _jspx_th_impact_validateInput_14.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_14.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setConstraint("Address");
              _jspx_th_impact_validateInput_14.setSize("50");
              _jspx_th_impact_validateInput_14.setMaxLength("30");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_15.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_15.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_15.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_15.setType("text");
              _jspx_th_impact_validateInput_15.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_15.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_15.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_15.setLabel("City");
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setConstraint("City");
              _jspx_th_impact_validateInput_15.setMaxLength("20");
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_1.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_1.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_1.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_1.setOnChange( onChange );
              _jspx_th_impact_validateSelect_1.setLabel("State");
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_16.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_16.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_16.setType("text");
              _jspx_th_impact_validateInput_16.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_16.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_16.setLabel("Zip");
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setConstraint("Zip");
              _jspx_th_impact_validateInput_16.setMaxLength("5");
              _jspx_th_impact_validateInput_16.setSize("5");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_17.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_17.setType("text");
              _jspx_th_impact_validateInput_17.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_17.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_17.setMaxLength("4");
              _jspx_th_impact_validateInput_17.setSize("4");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_2.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_2.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_2.setBlankValue("true");
              _jspx_th_impact_validateSelect_2.setLabel("County");
              _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_2.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_2.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_0.setLabel("Comments");
              _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_0.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_0.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_0.setCols("125");
              _jspx_th_impact_validateTextArea_0.setRows("4");
              _jspx_th_impact_validateTextArea_0.setColspan("3");
              _jspx_th_impact_validateTextArea_0.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_0.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

              out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

              out.write("\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_1.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_1.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_1.setAction("#");
              _jspx_th_impact_ButtonTag_1.setFunction(onclick);
              _jspx_th_impact_ButtonTag_1.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_1.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_1.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_19(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_20.setType("hidden");
              _jspx_th_impact_validateInput_20.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_20.setValue("true");
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_21.setType("hidden");
              _jspx_th_impact_validateInput_21.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_21.setValue("true");
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_22.setType("hidden");
              _jspx_th_impact_validateInput_22.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_22.setValue("");
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_23.setType("hidden");
              _jspx_th_impact_validateInput_23.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_23.setValue("");
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
              out.print( addressSubFormName );
              out.write("', '");
              out.print( addressSubAddressSubmoduleName );
              out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

              out.write('\r');
              out.write('\n');
              out.write('\r');
              out.write('\n');

    adminAddressPhoneSubTabIndex = adminAddressPhoneAddressSubDB.getTabIndex();
    AddressSubDB.removeFromRequest( request );

              out.write('\r');
              out.write('\n');
/* END Address Submodule */
              out.write("\r\n     </td>\r\n   </tr>\r\n </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    adminAddressPhoneSubAdminAddressPhoneSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write("\r\n  ");
tabIndex = adminAddressPhoneSubDB.getTabIndex();
      AdminAddressPhoneSubDB.removeFromRequest(request);

          out.write("\r\n  ");
/* END Admin Address Phone Submodule */
          out.write("\r\n  <br>\r\n\r\n  ");
// Do not show the PPT Participation section if the PPT event status
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

          
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" width=\"100%\">\r\n    <tr>\r\n      <th>\r\n        Participation\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/subcare/PPT/displayPPT");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          <div id=\"pptParticipation\" style=\"height:");
              out.print( sectionHeight );
              out.write("px; width:760px; overflow:auto\">\r\n            <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableborderList\">\r\n              <tr>\r\n                <th class=\"thList\">\r\n                  &nbsp;\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Name\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Notified\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Notification Type\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Participated\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Relationship/Interest\r\n                </th>\r\n              </tr>\r\n              ");
enumeration = csub27so.getROWCSUB27SOG00_ARRAY().enumerateROWCSUB27SOG00();
          while (enumeration.hasMoreElements()) {
            ROWCSUB27SOG00 participant = (ROWCSUB27SOG00) enumeration.nextElement();

            
              out.write("\r\n              <tr class=\"");
              out.print( FormattingHelper.getRowCss(loopCounter + 1) );
              out.write("\">\r\n                <td>\r\n                  ");
// The name of this radio button ends in "_CLEAN" so that the
            // radio group will be excluded from the 'isDirty' check. We
            // don't want the user to get the message "Your unsaved data
            // will be lost" just because they selected a radio button.

            
              out.write("\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_24.setType("radio");
              _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_24.setValue( FormattingHelper.formatInt(participant.getUlIdPptPart()) );
              _jspx_th_impact_validateInput_24.setName("rbParticipantId_CLEAN");
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n                <td>\r\n                  <a href=\"JavaScript:goToParticipantDetailPage(");
              out.print( FormattingHelper.formatInt(participant.getUlIdPptPart()) );
              out.write(");\">");
              out.print(participant.getSzNmPptPartFull());
              out.write("</a>\r\n                </td>\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatDate(participant.getDtDtPptPartDateNotif()));
              out.write("\r\n                </td>\r\n                ");
//-------------------------
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
                                                                                                            CodesTables.CPARTYPE_OTH))) {
              out.write("\r\n                <td>\r\n                  ");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CPPTNOST, participant.getSzCdPptNotifType()));
              out.write("\r\n                </td>\r\n                ");
} else if (participant.getSzCdPptNotifType() != null && participant.getSzCdPptPartType() != null
                       && participant.getSzCdPptPartType().equals(CodesTables.CPARTYPE_STA)) {
              out.write("\r\n                <td>\r\n                  ");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CPPTNOST, participant.getSzCdPptNotifType()));
              out.write("\r\n                </td>\r\n                ");
} else {
              out.write("\r\n                <td>\r\n                  &nbsp;\r\n                </td>\r\n                ");
}

            
              out.write("\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatDate(participant.getDtDtPptDate()));
              out.write("\r\n                </td>\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatString(participant.getSzSdsPptPartRelationship()));
              out.write("\r\n                </td>\r\n              </tr>\r\n              ");
loopCounter++;
          } // end while (enum_list.hasMoreElements())

          
              out.write("\r\n            </table>\r\n          </div>\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName( PPTConversation.DELETE_BUTTON_ON_PPT_PAGE );
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setForm("frmPPTInformation");
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/PPT/deletePPTParticipant");
          _jspx_th_impact_ButtonTag_2.setFunction("return confirmRowSelected()");
          _jspx_th_impact_ButtonTag_2.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnAdd");
          _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmPPTInformation");
          _jspx_th_impact_ButtonTag_3.setAction("/subcare/PPT/addPPTParticipant");
          _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_3.setFunction("cancelValidation();");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
} else {
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" width=\"100%\">\r\n    <tr>\r\n      <th>\r\n        Participation\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td class=\"tableBG\">\r\n        <div id=\"pptParticipation\" style=\"height:50px; width:760px; overflow:auto\">\r\n          <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableborderList\">\r\n            <tr>\r\n              <th class=\"thList\">\r\n                &nbsp;\r\n              </th>\r\n              <th class=\"thList\">\r\n                Name\r\n              </th>\r\n              <th class=\"thList\">\r\n                Notified\r\n              </th>\r\n              <th class=\"thList\">\r\n                Notification Type\r\n              </th>\r\n              <th class=\"thList\">\r\n                Participated\r\n              </th>\r\n              <th class=\"thList\">\r\n                Relationship/Interest\r\n              </th>\r\n            </tr>\r\n            <tr>\r\n              <td colspan=\"6\" class=\"subDetail\">\r\n                ");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n              </td>\r\n            </tr>\r\n          </table>\r\n        </div>\r\n\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnAdd");
          _jspx_th_impact_ButtonTag_4.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmPPTInformation");
          _jspx_th_impact_ButtonTag_4.setAction("/subcare/PPT/addPPTParticipant");
          _jspx_th_impact_ButtonTag_4.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_4.setFunction("cancelValidation();");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
} // end if (csub27so.getROWCSUB27SOG00_ARRAY().getUlRowQty() > 0)
      } // end if (!csub29so.getROWCSUB29SOG01().getSzCdEventStatus().equals(CodesTables.CEVTSTAT_NEW))

          out.write('\r');
          out.write('\n');

//*****************
//**** BUTTONS ****
//*****************

          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"alignLeft\" width=\"85%\">\r\n        &nbsp;\r\n      </td>\r\n      <td class=\"alignRight\">\r\n      \t");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest( displayAddContStndsBtn);
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      \t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_ButtonTag_5.setName("btnAddContactStandards");
              _jspx_th_impact_ButtonTag_5.setImg("btnAddContactStandards");
              _jspx_th_impact_ButtonTag_5.setForm("frmPPTInformation");
              _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_5.setAction("/subcare/PPT/addContactStandards");
              _jspx_th_impact_ButtonTag_5.setFunction("cancelValidation();");
              _jspx_th_impact_ButtonTag_5.setAlign("right");
              _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
              if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest( displayViewContStndsBtn);
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      \t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_ButtonTag_6.setName("btnViewContactStandards");
              _jspx_th_impact_ButtonTag_6.setImg("btnViewContactStandards");
              _jspx_th_impact_ButtonTag_6.setForm("frmPPTInformation");
              _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_6.setAction("/subcare/PPT/displayContactStandards");
              _jspx_th_impact_ButtonTag_6.setFunction("cancelValidation();");
              _jspx_th_impact_ButtonTag_6.setAlign("right");
              _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
              if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_3.setTest( displaySubmit );
          int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
          if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ButtonTag_7.setName("btnSaveAndSubmit");
              _jspx_th_impact_ButtonTag_7.setImg("btnSaveAndSubmit");
              _jspx_th_impact_ButtonTag_7.setForm("frmPPTInformation");
              _jspx_th_impact_ButtonTag_7.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_7.setAction("/subcare/PPT/saveAndSubmitPPT");
              _jspx_th_impact_ButtonTag_7.setAlign("right");
              _jspx_th_impact_ButtonTag_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
              if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>      \r\n      <td class=\"alignRight\">\r\n        ");

      //SIR19787 added preventDoubleClick="true" to ButtonTag for Save
      
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_8.setName( PPTConversation.SAVE_BUTTON_ON_PPT_PAGE );
          _jspx_th_impact_ButtonTag_8.setFunction("return confirmSave()");
          _jspx_th_impact_ButtonTag_8.setImg("btnSave");
          _jspx_th_impact_ButtonTag_8.setAlign("right");
          _jspx_th_impact_ButtonTag_8.setForm("frmPPTInformation");
          _jspx_th_impact_ButtonTag_8.setAction("/subcare/PPT/savePPT");
          _jspx_th_impact_ButtonTag_8.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
          if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

//******************************************
//**** FORM (PPT INFORMATION) ENDS HERE ****
//******************************************

      out.write("\r\n\r\n");

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

      out.write("\r\n<br>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnNarrative.gif");
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      _jspx_th_impact_documentButton_0.setAccessKey("W");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("TeamNarrative");
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setName("TeamNarrative");
          _jspx_th_impact_document_0.setDocType( docType );
          _jspx_th_impact_document_0.setDocExists( docExists);
          _jspx_th_impact_document_0.setProtectDocument( protectNarrative);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sCase");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
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
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("selectedParticipantId");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnContactStdsReqTaskBack");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_18(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_18.setType("hidden");
    _jspx_th_impact_validateInput_18.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_18.setValue("0");
    int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
    if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_19(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_19.setType("hidden");
    _jspx_th_impact_validateInput_19.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_19.setValue("0");
    int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
    if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
