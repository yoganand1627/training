package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.StageClosureConversation;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class StageClosure_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Stage Closure
//*  Created by:   Paula Blaha
//*  Date Created: 1/13/03
//*
//*  Description:
//*  The function of the Stage Closure page is to capture the reason for
//*  closure, the closure date and any closure comments.
//*
//*  Change History:
//*  Date      User         Description
//*  --------  -----------  --------------------------------------------------
//*  06/24/03  GRIMSHAN     SIR 18416 Set editable mode to all for approval
//*                         status button
//*  08/07/03  Todd Reser   Added Description.
//*  10/30/03  CORLEYAN     SIR 19857 todo removals and remove validation class
//*  07/01/04  RIOSJA       SIR 16114 - Each time the user accesses this page
//*                         for a family stage (FPR, FRE or FSU), display a
//*                         reminder that says: "Please review the Services and
//*                         Referrals Checklist for completeness and accuracy."
//*  10/28/08  vdevarak		STGAP00010749: Added the name fields and a javascript
//*                         function to show the fields when the reason closed is
//*                         Adoption Finalized
//*  07/25/09 bgehlot       STGAP00014341: MR-51 Reopen Stage Changes
//*  07/31/09 bgehlot       STGAP00014943: Data Closed is also prepopulated


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  /*
  ** RIOSJA, SIR 16114 - If the user attempts to save and submit
  ** the page and validation edits are encountered, an indicator
  ** will be put into the request to be used by this JSP.
  */
  //Boolean bValidationEditsFound = null;
  //if ( request.getAttribute( "bValidationEditsFound" ) != null )
  //{
  //  bValidationEditsFound = (Boolean)request.getAttribute( "bValidationEditsFound" );
  //}

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  //Set the page mode
  String pageMode = PageModeConstants.VIEW;

  if (PageMode.getPageMode(request) != null)
  {
    pageMode = PageMode.getPageMode(request);
  }

  // Declare all the row objects you will need to display data on the page
  ROWCSUB67SOG00 StageClosure00 = null;
  ROWCSUB67SOG01 StageClosure01 = null;
  String nmFirst = "";
  String nmLast = "";
  String nmMiddle = "";

  // Get the whole output object here from the request and get the individual pieces later.
  CSUB67SO csub67so = (CSUB67SO) state.getAttribute("CSUB67SO", request);

  // Null catch and initialization for the output object
  if (csub67so == null)
  {
    csub67so = new CSUB67SO();
  }else{
  nmFirst = FormattingHelper.formatString(csub67so.getTxtNmFirst());
  nmLast = FormattingHelper.formatString(csub67so.getTxtNmLast());
  nmMiddle = FormattingHelper.formatString(csub67so.getTxtNmMiddle());
  }

  // Null catch and initialization for the row objects
  if (csub67so.getROWCSUB67SOG00() == null)
  {
    StageClosure00 = new ROWCSUB67SOG00();
  }
  else
  {
    StageClosure00 = csub67so.getROWCSUB67SOG00();
  }

  if (csub67so.getROWCSUB67SOG01() == null)
  {
  StageClosure01 = new ROWCSUB67SOG01();
   }
  else
  {
  StageClosure01 = csub67so.getROWCSUB67SOG01();
  }
 
       // Get the CSVC15SO output object out of the request
      CSVC15SO csvc15so = (CSVC15SO) state.getAttribute("CSVC15SO", request);
      ROWCCMN01UIG00 rowccmn01uig00 = null;
      ROWCINV19SOG02 rowcinv19sog02 = null;

      // Null catch for csvc15so, if null set to blank (initialize)
      if (csvc15so == null) {
        csvc15so = new CSVC15SO();
      }

      // Null catch for ROW objects, if not null get rows
      if (csvc15so.getROWCCMN01UIG00() != null) {
        rowccmn01uig00 = csvc15so.getROWCCMN01UIG00();
      } else {
        rowccmn01uig00 = new ROWCCMN01UIG00();
      }
      if (csvc15so.getROWCINV19SOG02() != null) {
        rowcinv19sog02 = csvc15so.getROWCINV19SOG02();
      } else {
        rowcinv19sog02 = new ROWCINV19SOG02();
      }

  // Set the date to system date for PAD and AOC.  Leave it blank for the other four stages.
  String stage = "";
  String eventStatus = "";
  String stageType ="";
  String szCdTask = "";
  String szCdEventType = "";
  String szTxtEventDescr = "";
  String FirstName = "none";
  String LastName = "none";
  String MiddleName = "none";
  String Label = "none";
  org.exolab.castor.types.Date dtEventOccurred = null;
  Date tsLastUpdate1 = null;
  Date tsLastUpdate2 = null;
  org.exolab.castor.types.Date dtStageClose = null;
  org.exolab.castor.types.Date dtStageCloseFromReopen = null;
  int ulIdEvent = 0;
  int ulIdStage = 0;
  int ulIdCase = 0;
  int ulIdPerson = 0;
  String szCdStage = "";
  String szCdStageProgram = "";
  String actionSave = "";
  String actionSaveAndSubmit = "";
  String validApprv = "";
  if (csub67so.getROWCSUB67SOG01() != null){
    eventStatus = StageClosure00.getSzCdEventStatus();
    stageType = StageClosure01.getSzCdStageType();
    stage = StageClosure01.getSzCdStage();
    szCdTask = StageClosure00.getSzCdTask();
    szCdEventType = StageClosure00.getSzCdEventType();
    ulIdEvent = StageClosure00.getUlIdEvent();
    ulIdStage = StageClosure01.getUlIdStage();
    ulIdCase = StageClosure01.getUlIdCase();
    szTxtEventDescr = StageClosure00.getSzTxtEventDescr();
    dtEventOccurred = StageClosure00.getDtDtEventOccurred();
    tsLastUpdate1 = StageClosure00.getTsLastUpdate();
    tsLastUpdate2 = StageClosure01.getTsLastUpdate();
    ulIdPerson = StageClosure00.getUlIdPerson();
    szCdStage = StageClosure01.getSzCdStage();
    szCdStageProgram = StageClosure01.getSzCdStageProgram();
    dtStageClose = StageClosure01.getDtDtStageClose();
    actionSave = "/workload/StageClosure/saveStageClosure";
    actionSaveAndSubmit = "/workload/StageClosure/saveSubmitStageClosure";
    validApprv = "/workload/StageClosure/validateApprv";
  }
  if (csvc15so.getROWCINV19SOG02() != null) {
    eventStatus = rowccmn01uig00.getSzCdEventStatus();
    stageType = rowcinv19sog02.getSzCdStageType();
    stage = rowcinv19sog02.getSzCdStage();
    szCdTask = rowccmn01uig00.getSzCdTask();
    szCdEventType = rowccmn01uig00.getSzCdEventType();
    ulIdEvent = rowccmn01uig00.getUlIdEvent();
    ulIdStage = rowcinv19sog02.getUlIdStage();
    ulIdCase = rowcinv19sog02.getUlIdCase();
    szTxtEventDescr = rowccmn01uig00.getSzTxtEventDescr();
    dtEventOccurred = rowccmn01uig00.getDtDtEventOccurred();
    tsLastUpdate1 = rowccmn01uig00.getTsLastUpdate();
    tsLastUpdate2 = rowcinv19sog02.getTsLastUpdate();
    ulIdPerson = rowccmn01uig00.getUlIdPerson();
    szCdStage = rowcinv19sog02.getSzCdStage();
    szCdStageProgram = rowcinv19sog02.getSzCdStageProgram();
    dtStageClose = rowcinv19sog02.getDtDtStageClose();
    actionSave = "/workload/StageClosure/updateSrvcDlvryClsr";
    actionSaveAndSubmit = "/workload/StageClosure/updateAndSubmitSrvcDlvryClsr";
    validApprv = "/workload/StageClosure/validateApprvFPR";
  }

  if ((((dtStageClose == null) || (dtStageClose ==  DateHelper.toCastorDate( "3500-12-31")))) && ((
          CodesTables.CSTAGES_AOC.equals(stage) || (CodesTables.CSTAGES_PAD.equals(stage) ))))
  {
    if (csub67so.getROWCSUB67SOG01() != null){
      StageClosure01.setDtDtStageClose( DateHelper.toCastorDate( new Date() ) );
    }
    if (csvc15so.getROWCINV19SOG02() != null) {
    rowcinv19sog02.setDtDtStageClose( DateHelper.toCastorDate( new Date() ) );
    }
  }
  //STGAP00014943: Data Closed is also prepopulated
  if(dtStageClose == null || (dtStageClose ==  DateHelper.toCastorDate( DateHelper.MAX_JAVA_DATE))){
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null)&& ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
      dtStageClose = csub67so.getDtDtStageCloseFromReopen();
    }
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null )&& ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
      dtStageClose = csvc15so.getDtDtStageCloseFromReopen();
    }
  }
  
  //STGAP00014966 : Data Closed is also prepopulated
  if(dtStageCloseFromReopen == null || (dtStageCloseFromReopen ==  DateHelper.toCastorDate( DateHelper.MAX_JAVA_DATE))){
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus)|| eventStatus == null) && ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
      dtStageCloseFromReopen = csub67so.getDtDtStageCloseFromReopen();
    }
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus)|| eventStatus == null) && ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
      dtStageCloseFromReopen = csvc15so.getDtDtStageCloseFromReopen();
    }
  }

  // If the stage has already been saved (event status = COMP) or saved and submitted (event status = PEND),
  // we need to be in BROWSE mode
  List excludeOptions = new ArrayList();

  if (eventStatus != null && CodesTables.CEVTSTAT_APRV.equals(eventStatus) )
  {
     pageMode = PageModeConstants.VIEW;
  }

  // initialize the tabIndex to 0
  int tabIndex = 1;

  // Attach the codes table for Reason.
  String reasonCodesTable = StringHelper.EMPTY_STRING;  

  if ((stageType.startsWith("C-")) && !(CodesTables.CSTAGES_PAD.equals(stage)))
  {
    reasonCodesTable =  CodesTables.CCLOSCRS;
  }
  else if(CodesTables.CSTAGES_FSU.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSFCF; // FSU (Foster Care Child) reasons
  }
  else if(CodesTables.CSTAGES_SUB.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSFCC; // SUB (Foster Care Family) reasons
  }
  else if(CodesTables.CSTAGES_PAD.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSPAD; // PAD (Post Adoption) reasons
  }
  else if(CodesTables.CSTAGES_ADO.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSADO; // ADO (Adoption) reasons
  }
  else if(CodesTables.CSTAGES_PFC.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSPFC; // PFC (Post Foster Care Services) reasons
  }
  else if(CodesTables.CSTAGES_FPR.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSONG; // FPR (CPS On Going) reasons
  }  
 
  boolean bApprovalStatusHide = true;

  if ( CodesTables.CEVTSTAT_PEND.equals( eventStatus ) ||
       CodesTables.CEVTSTAT_APRV.equals( eventStatus ) )
  {
    bApprovalStatusHide = false;
  }
  else
  {
    //-- will only be PROC if last approval was rejected
    if (CodesTables.CEVTSTAT_PROC.equals( eventStatus )) {
      if(CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
        bApprovalStatusHide = false;
      }
    }
  }

boolean isApprover = false;

if ( GlobalData.getUlIdTodo( request ) != 0 &&
     GlobalData.isApprovalMode( request ) )
{
  isApprover = true;
}

String confirmed = ( String )request.getAttribute("confirmed");

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\r\nfunction confirmCloseCase()\r\n{\r\n      document.frmStageClosure.closeStage.value = '");
      out.print(String.valueOf(isApprover));
      out.write("';\r\n");

  if (confirmed != null &&
      "ask".equals(confirmed) &&
      !FormValidation.pageHasErrorMessages(request) &&
      !FormValidation.pageHasValidationMessages("frmStageClosure", request))
  {
    String buttonPressed = request.getParameter( "btnSave.x" );
    if ( buttonPressed == null )
    {
      buttonPressed = "btnSaveSubmit_Id";
    }
    else
    {
      buttonPressed = "btnSave_Id";
    }

      out.write("\r\n    var confirmed = confirm(\"");
      out.print(MessageLookup.getMessageByName("MSG_SUB_CLOSE_CASE"));
      out.write("\");\r\n\r\n    if (confirmed)\r\n    {\r\n      document.frmStageClosure.closeStage.value = 'true';\r\n      document.getElementById('");
      out.print(buttonPressed);
      out.write("').click();\r\n    }\r\n");

    if ( StringHelper.isTrue( request.getParameter("pageIsChanged") ) )
    {

      out.write("\r\n    else // Cancel was clicked - now enable dirty check\r\n    {\r\n      setPageDirtyFlag( true );\r\n    }\r\n");

    }
  }

      out.write("\r\n}\r\nfunction toggleNameFields()\r\n{\r\n    toggleVisibility('FirstName', 'none');\r\n    toggleVisibility('LastName', 'none');\r\n    toggleVisibility('MiddleName', 'none');\r\n    toggleVisibility('Label', 'none');\r\n    var value = document.frmStageClosure.selSzCdStageReasonClosed.value;\r\n    if(value == '");
      out.print( StageClosureConversation.REASON_ADOPTION_FINALIZED );
      out.write("'){\r\n      toggleVisibility('FirstName', 'block');\r\n      toggleVisibility('LastName', 'block');\r\n      toggleVisibility('MiddleName', 'block');\r\n      toggleVisibility('Label', 'block');\r\n    }\r\n}\r\nwindow.attachEvent('onload',toggleNameFields);\r\nwindow.attachEvent('onload',confirmCloseCase);\r\nwindow.attachEvent('onbeforeunload', checkIsDirty);\r\nfunction checkPageChanged()\r\n{\r\n  document.frmStageClosure.pageIsChanged.value = isPageChanged();\r\n}\r\n\r\nfunction checkIsDirty()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmStageClosure");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction(actionSave);
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.StageClosureCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");

  if ( !bApprovalStatusHide ) {

          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmStageClosure");
          _jspx_th_impact_ButtonTag_0.setAction(validApprv);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(GlobalData.isApprovalMode(request));
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
 } 
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">Closure Information</th>\r\n  </tr>\r\n");

    String reason = request.getParameter("selSzCdStageReasonClosed");
    if (reason == null) {
      if (csub67so.getROWCSUB67SOG01() != null) {
        reason = StageClosure01.getSzCdStageReasonClosed();
      }
      if (csvc15so.getROWCINV19SOG02() != null) {
        reason = rowcinv19sog02.getSzCdStageReasonClosed();
      }
      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
        reason = csub67so.getSzCdStageReasonClosedFromReopen();
      }
      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
        reason = csvc15so.getSzCdStageReasonClosedFromReopen();
      }
    }   

          out.write("\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Reason");
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_0.setName("selSzCdStageReasonClosed");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setExcludeOptions( excludeOptions );
          _jspx_th_impact_validateSelect_0.setCodesTable( reasonCodesTable );
          _jspx_th_impact_validateSelect_0.setOnChange("toggleNameFields()");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString(reason));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n  ");
  boolean disableDate = true;
   if(ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent()) ||
     ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
    disableDate = false;
  
          out.write("  \r\n    <td>\r\n\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtStageClose");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Date");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(dtStageClose));
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setDisabled(String.valueOf(disableDate));
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  ");
}else{ 
          out.write("\t\r\n\t<td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtDtDtStageClose");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Date");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatDate(dtStageClose));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  ");
} 
          out.write("\r\n  </tr>\r\n");

    String comments = request.getParameter("selSzTxtStageClosureCmnts");

    if (comments == null)
    {
      if (csub67so.getROWCSUB67SOG01() != null){
        comments = StageClosure01.getSzTxtStageClosureCmnts();
      }
      if (csvc15so.getROWCINV19SOG02() != null) {
        comments = rowcinv19sog02.getSzTxtStageClosureCmnts();
      }

      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
        comments = csub67so.getSzTxtStageClosureCmntsFromReopen();
      }
      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
        comments = csvc15so.getSzTxtStageClosureCmntsFromReopen();
      }
            
      if("null".equals(comments) || comments == null){
         comments = "";
      }
    }

          out.write("\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("selSzTxtStageClosureCmnts");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n        ");
              out.print( comments );
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  \r\n <tr id=\"Label\" style=\"display: ");
          out.print(Label);
          out.write("\">\r\n  <td> New Child's Name </td>\r\n </tr>     \r\n    <tr id=\"FirstName\" style=\"display: ");
          out.print(FirstName);
          out.write("\">\r\n    <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setValue( nmFirst );
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName("txtNmFirst");
          _jspx_th_impact_validateInput_0.setLabel("First");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setDisabled( "" );
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setSize("12");
          _jspx_th_impact_validateInput_0.setMaxLength("12");
          _jspx_th_impact_validateInput_0.setConstraint("Name12");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     </tr>\r\n     <tr id=\"MiddleName\" style=\"display: ");
          out.print(MiddleName);
          out.write("\">\r\n            <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setValue( nmMiddle );
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setName("txtNmMiddle");
          _jspx_th_impact_validateInput_1.setLabel("Middle");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_1.setDisabled( "" );
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setSize("12");
          _jspx_th_impact_validateInput_1.setMaxLength("12");
          _jspx_th_impact_validateInput_1.setConstraint("Name12");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     </tr>\r\n     <tr id=\"LastName\" style=\"display: ");
          out.print(LastName);
          out.write("\">\r\n            <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setValue( nmLast );
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName("txtNmLast");
          _jspx_th_impact_validateInput_2.setLabel("Last");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_2.setDisabled( "" );
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setSize("22");
          _jspx_th_impact_validateInput_2.setMaxLength("22");
          _jspx_th_impact_validateInput_2.setConstraint("Name22");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"80%\">&nbsp;</td>\r\n    <td width=\"10%\" class=\"alignRight\">\r\n      ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmStageClosure");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck("selSzTxtStageClosureCmnts");
          _jspx_th_impact_spellCheck_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   \r\n");
  
    if (!isApprover ) {

          out.write("\r\n    <td width=\"10%\" class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmStageClosure");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction(actionSaveAndSubmit);
          _jspx_th_impact_ButtonTag_1.setFunction("checkPageChanged()");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

    }

          out.write("\r\n    <td width=\"10%\" class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmStageClosure");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setAction(actionSave);
          _jspx_th_impact_ButtonTag_2.setFunction("checkPageChanged()");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Hidden fields to persist state\r\n !------------------------------------------------------------------------------------------------>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("txtUlIdEvent");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatInt(ulIdEvent));
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
          _jspx_th_impact_validateInput_4.setName("txtUlIdStage");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatInt(ulIdStage));
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
          _jspx_th_impact_validateInput_5.setName("txtSzCdTask");
          _jspx_th_impact_validateInput_5.setValue(szCdTask);
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
          _jspx_th_impact_validateInput_6.setName("txtSzCdEventType");
          _jspx_th_impact_validateInput_6.setValue(szCdEventType);
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
          _jspx_th_impact_validateInput_7.setName("txtDtDtEventOccurred");
          _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatDate(dtEventOccurred));
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
          _jspx_th_impact_validateInput_8.setName("txtTsLastUpdate1");
          _jspx_th_impact_validateInput_8.setValue(DateHelper.toISOString(tsLastUpdate1));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("txtSzTxtEventDescr");
          _jspx_th_impact_validateInput_9.setValue(szTxtEventDescr);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("txtSzCdEventStatus");
          _jspx_th_impact_validateInput_10.setValue(eventStatus);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatInt(ulIdPerson));
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("txtTsLastUpdate2");
          _jspx_th_impact_validateInput_12.setValue(DateHelper.toISOString(tsLastUpdate2));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("txtUlIdCase");
          _jspx_th_impact_validateInput_13.setValue(FormattingHelper.formatInt(ulIdCase));
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("txtSzCdStage");
          _jspx_th_impact_validateInput_14.setValue(FormattingHelper.formatString(szCdStage));
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("txtSzCdStageProgram");
          _jspx_th_impact_validateInput_15.setValue(szCdStageProgram);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("txtSzCdStageType");
          _jspx_th_impact_validateInput_16.setValue(stageType);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnTxtDtDtStageClose");
          _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatDate(dtStageClose));
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_19(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("reasonClosed");
          _jspx_th_impact_validateInput_20.setValue(FormattingHelper.formatString(reason));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("txtDtDtStageCloseFromReopen");
          _jspx_th_impact_validateInput_21.setValue(FormattingHelper.formatDate(dtStageCloseFromReopen));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
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

  private boolean _jspx_meth_impact_validateInput_18(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_18.setType("hidden");
    _jspx_th_impact_validateInput_18.setName("closeStage");
    _jspx_th_impact_validateInput_18.setValue("");
    int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
    if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_19(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_19.setType("hidden");
    _jspx_th_impact_validateInput_19.setName("pageIsChanged");
    _jspx_th_impact_validateInput_19.setValue("false");
    int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
    if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
