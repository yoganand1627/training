package org.apache.jsp.grnds_002ddocs.intake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD;

public final class IntakeActions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*  JSP Name:     Intake Actions JSP
      //*  Created by:   Jenn Casdorph
      //*  Date Created: 02/11/2003
      //*
      //*  Description:
      //*  The Intake Actions page contains three expandable sections plus the forms
      //*  section.  Allegation List, Call Decision, and Call Summary.  This page is
      //*  the entry point for users when they are reviewing or returning to a saved Intake.
      //*  The page will load in EDIT mode or VIEW mode (if the Intake is closed).
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  5/20/03   Cawthocw          SIR 17536 - Part of the JS function for the
      //**                                          APS Deidentified Report was using the
      //**                                          wrong variable name.  Changed it to be cfin0800
      //**                                          instead of cfin0600.
      //**  06/08/03  Casdorjm          SIR 18058 - The caseNameCodes vector was getting set to
      //**                                          the null CaseNameEtAlVector when the user
      //**                                          saved Classification AFC and there was only one
      //**                                          victim.  Changed the logic to check to make sure
      //**                                          the classification is AFC AND there is more than
      //**                                          one victim.
      //**  06/19/03  Brauchs          Code Review - Beautiful!  Nice indentation and excellent comments
      //**  07/21/03  Casdorjm         SIR 19030 - Switched the order in which the IN RE name appeared.
      //**  10/07/03  Casdorjm         Added clause to show the Assign button for "stuck" Intakes.
      //**  11/14/03  CASDORJM         Rearranged the Classification and Case Name fields.  Moved
      //**                             Closure Code below Priority.
      //**                             Also added logic to notify the user the Intake Narrative needed
      //**                             to be saved before any processing could take place.
      //**                             Also added logic to promptPersonSearch() on Save and Assign.
      //**  11/17/03 dejuanr           SIR 22428 - Get the curretn value and set it.  It was setting it
      //**                             to "" before
      //**  11/17/03 dejuanr           SIR 22429 & 22430 - Reset the call summary info on load of the page.
      //**  11/17/03 dejuanr            SIR 22442 - Added call to navAway to delete Allegation.
      //**                             For some reason the diryt falg wasnt gettgin set into
      //**                             the request on the unload event.
      //**  02/26/04 ochumd            Sir 19933 - Closure Code 01 or 02 are displaying for Closed Intakes.
      //**                             Added logic to stop this from occuring.
      //**
      //**  04/08/04  ochumd           Sir 22646 - Added code to the setSmryCaseField to peel
      //**                             off the person id from the name stage before setting value to dspSzNmStage.
      //**  04/09/04  corlyan          SIR 22694, only display approval button if
      //**                             the event has been submitted for approval.
      //**
      //** 07/12/04  ochumd            Sir 22934 -- Replaced cint19d with cint76d.
      //**
      //** 09/20/04  codreaa           SIR 23030 - Commented out java script comments so that no extraneous
      //**                             information is added.
      //** 07/20/05  ochumd            Sir 23720 - A check box and a comments box were added to the
      //**                             Special Handling Section on the Intake Actions page to track
      //**                             Methamphetamine cases.
      //** 08/26/05  ochumd            Sir 23920 added code to check the Methamphetamine box if
      //**                             comments are entered.
      //** 03/12/08  vdevarak          STGAP00005621: Modified code to make sure the current priority
      //**                             is over written by initial priority, only when there is no existing current
      //**                             priority
      //** 03/20/08  schoi             STGAP00005751: Enabled the Allegation hyperlinks, 
      //**                             and an If clause was removed.
      //**                             
      //** 03/25/08  arege             STGAP00007413: After Clicking the Return to Case Summary hyperlink
      //**                             the user should be taken to the Case Summary page without doing the 
      //**                             validations on the IntakeActions Page.
      //** 05/23/08  arege             STGAP00005751 After Clickling Allegation Hyperlinks, user should be directed 
      //**                             to Allegation Detail page without doing the Validations on the IntakeActions Page.
      //** 06/12/2008 vdevarak         STGAP00009181: Modified code to add functionality for MR-011
      //**                             Modified the Determination Factor Sections. Added new check boxes, made the sections 
      //**                             individually expandable. Modified the JSP to hide determination factor section,
      //**                             if there are no allegations of that type in the list, and show if there is atleast one.
      //**                             Added a text area and a Determination Factors questions hyperlink  to each determination 
      //**                             factor section. The hyperlink opens a new window which displays the corresponding determination 
      //**                             factor questions
      //** 12/2/2008 arege             STGAP00010106 User i.e the Case Manager should be able to modify the Intake Report if it is 
      //**                             saved by the Supervisor but is not approved yet.
      //** 12/23/2008 arege            STGAP00010409 Modified code so that proper error message is displayed and used 
      //**                             MessageLookup.getMessageByNumber(Messages.MSG_INT_REP_CLASS_REQ instead of hard coding.
      //** 
      //** 1/22/2009  hjbaptiste	   STGAP00010576: Do not show the Delete and Copy buttons when no Allegations exist.
      //** 03/31/2009 arege            Removed the code put in for STGAP00010106 and fixed it in IntakeActionsCustomValidation.
      //** 05/04/2009 arege            STGAP00012386: Modified code so that the Initial Response Time is not modifiable for the 
      //**                             Supervisor.
      //** 05/26/10   hjbaptiste       SMS#51977-MR66-Maltreatment In Care: Added additional field to indicate that Maltreatment took
      //**                             place while the child was/is in DFCS custody.
      //** 08/18/2010  bgehlot          SMS 66380 MR-072 Changes  
      //** 06/10/2011  llokhande       CAPTA 4.3 added policy violation radio button.
      //** 07/08/2011  hjbaptiste      SMS#114497: CAPTA 4.3 Removed functions showMaltreatIncareConfirmation() and 
      //**                             warnSpclInvPlcmtProvider()
      //** 07/11/2011  hjbaptiste      SMS#114497: CAPTA 4.3 Put back functions showMaltreatIncareConfirmation() and 
      //**                             warnSpclInvPlcmtProvider()
      //** 09/21/2011  arege           STGAP00017044 Resolved system error on save and submit of Intake Actions Page
      //**                             
      //**
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                     .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    UserProfile user = UserProfileHelper.getUserProfile(request);
    int tabIndex = 1;
    int loopCount = 0;

    String pageMode = PageMode.getPageMode(request);
    boolean bResourceSearch = false;
    String showPhysAbuse = "none";
    String showNeglect = "none";
    String showEmtAbuse = "none";
    String showSexAbuse = "none";
    String showSplHandling = "none";
    
    ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute("allegListArray", request);
    if (allegListArray == null) {
      allegListArray = new ROWCINT76DO_ARRAY();
    }

    List primaryAllegVector = new ArrayList();
    ROWCINT76DO allegListRow = null;
    Enumeration allegListEnum = allegListArray.enumerateROWCINT76DO();

    // Build the primary allegation drop down box options vector using all the allegations entered on the allegation list
    if (!allegListEnum.hasMoreElements()) {
      showSplHandling = "";
    }
    while (allegListEnum.hasMoreElements()) {
      allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
      String alegType = allegListRow.getSzCdIntakeAllegType();
      Option option = new Option(alegType, alegType);
      if (!primaryAllegVector.contains(option)) {
        primaryAllegVector.add(new Option(alegType, alegType));
      }
      //STGAP00009181:Added checks to hide and show the determination facors sections depending
      //on the allegation types that exist in the list
      //Begin
      if (CodesTables.CABALTYP_PP.equals(alegType)) {
        showPhysAbuse = "";
      }
      if (CodesTables.CABALTYP_NN.equals(alegType)) {
        showNeglect = "";
      }
      if (CodesTables.CABALTYP_EE.equals(alegType)) {
        showEmtAbuse = "";
      }
      if (CodesTables.CABALTYP_SS.equals(alegType)) {
        showSexAbuse = "";
      }
      if (CodesTables.CABALTYP_OO.equals(alegType)) {
        showSplHandling = "";
      }
      //STGAP00009181:End
    }

    String warnSpclInvPlcmtProvider = (String) request.getAttribute("warnSpclInvPlcmtProvider");
    CallEntryRtrvOut callEntryData = (CallEntryRtrvOut) request.getAttribute("CallEntryRtrvOut");
    //MR-072
    String warnRecordsCheckNotCompleted = (String) request.getAttribute("warnRecordsCheckNotCompleted");

    if (callEntryData == null) {
      callEntryData = new CallEntryRtrvOut();
    }

    CallEntrySvcStruct entryInfo = callEntryData.getCallEntrySvcStruct();
    if (entryInfo == null) {
      entryInfo = new CallEntrySvcStruct();
    }
    CallDcsnAUD callDecisionData = callEntryData.getCallDcsnAUD();
    if (callDecisionData == null) {
      callDecisionData = new CallDcsnAUD();
    }
    String classification = callDecisionData.getSzCdStageClassification();
    if (classification == null) {
      classification = "";
    }
	
    DetermCmntsAUD determCmntsAUD = callEntryData.getDetermCmntsAUD();
    if (determCmntsAUD == null) {
      determCmntsAUD = new DetermCmntsAUD();
    }

    String lawEnfInvolved_Yes = "false";
    String lawEnfInvolved_No = "false";
    String ind_lawEnfInvolved = callDecisionData.getCIndIncmgLawEnfInvol();

    if (ind_lawEnfInvolved != null) {
      if (ind_lawEnfInvolved.equals("N")) {
        lawEnfInvolved_No = "true";
      } else {
        lawEnfInvolved_Yes = "true";
      }
    } else {
      lawEnfInvolved_No = "true";
    }

    String yIsCheckedMaltreatment = "false";
    String nIsCheckedMaltreatment = "false";
    //SMS 51977 Maltreatment in care
    if (ArchitectureConstants.Y.equals(callDecisionData.getCIndMaltreatInCare())) {
      yIsCheckedMaltreatment = "true";

    } else if (ArchitectureConstants.N.equals(callDecisionData.getCIndMaltreatInCare())) {
      nIsCheckedMaltreatment = "true";
    }
    String yIsCheckedPolicyViolation = "false";
    String nIsCheckedPolicyViolation = "false";
    //CAPTA 4.3 Policy Violation
    if(callDecisionData.getCIndIntPolicyViolation() != null) {
    	if (ArchitectureConstants.Y.equals(callDecisionData.getCIndIntPolicyViolation())) {
      		yIsCheckedPolicyViolation = "true";
      	}else if (ArchitectureConstants.N.equals(callDecisionData.getCIndIntPolicyViolation())) {
      		nIsCheckedPolicyViolation = "true";
    	}
    } else {
    	nIsCheckedPolicyViolation = "true";
    }
    
    String disableViolationButton = "false";
    if(PageModeConstants.VIEW.equals(pageMode)) {
    	disableViolationButton = "true";
    }else {
    	disableViolationButton = "false";
    }
   
    //defect STGAP00000459: Page does not display as expected. The page is wrongly formatted
    //Resolution:check worker county and worker region for null. if they are null display empty string

    //get worker county
    String workerCounty = StringHelper.EMPTY_STRING;

    if (entryInfo.getSzCdIncomingWorkerCounty() != null) {
      workerCounty = Lookup.simpleDecodeSafe(CodesTables.CCOUNT, entryInfo.getSzCdIncomingWorkerCounty());
    }

    //get woker region
    String workerRegion = StringHelper.EMPTY_STRING;
    if (entryInfo.getSzCdIncmgWorkerRegion() != null) {
      workerRegion = entryInfo.getSzCdIncmgWorkerRegion();
      if (workerRegion.length() == 3) {
        workerRegion = Lookup.simpleDecodeSafe(CodesTables.CREGIONS, entryInfo.getSzCdIncmgWorkerRegion()
                                                                              .substring(1, 3));
      } else {
        workerRegion = Lookup.simpleDecodeSafe(CodesTables.CREGIONS, entryInfo.getSzCdIncmgWorkerRegion());
      }

    }

    // The following deals with populating the Determination Factors sectionin the Call Decision
    // section of the page.  We retrieve the list of Determination Factors for both APS and CPS classifications
    // and also the checked values.
    List CPSDescrValues = (List) request.getAttribute("CPSDescrValues");
    if (CPSDescrValues == null) {
      CPSDescrValues = new ArrayList();
    }

    List APScheckedValues = (List) request.getAttribute("APScheckedValues");
    if (APScheckedValues == null) {
      APScheckedValues = new ArrayList();
    }

    List CPScheckedValuesPA = (List) request.getAttribute("CPScheckedValuesPA");
    if (CPScheckedValuesPA == null) {
      CPScheckedValuesPA = new ArrayList();
    }
    List CPScheckedValuesNEG = (List) request.getAttribute("CPScheckedValuesNEG");
    if (CPScheckedValuesNEG == null) {
      CPScheckedValuesNEG = new ArrayList();
    }
    List CPScheckedValuesEA = (List) request.getAttribute("CPScheckedValuesEA");
    if (CPScheckedValuesEA == null) {
      CPScheckedValuesEA = new ArrayList();
    }
    List CPScheckedValuesSA = (List) request.getAttribute("CPScheckedValuesSA");
    if (CPScheckedValuesSA == null) {
      CPScheckedValuesSA = new ArrayList();
    }
    List CPScheckedValuesOTH = (List) request.getAttribute("CPScheckedValuesOTH");
    if (CPScheckedValuesOTH == null) {
      CPScheckedValuesOTH = new ArrayList();
    }

    List CPSDescrCheckedValues = (List) request.getAttribute("CPSDescrCheckedValues");
    if (CPSDescrCheckedValues == null) {
      CPSDescrCheckedValues = new ArrayList();
    }

    String checkNoFactors = FormattingHelper.formatString(callDecisionData.getBIndIncmgNoFactor());
    checkNoFactors = checkNoFactors != "" ? checkNoFactors : "N";

    // Here we check to see if we are returning from a Law Enforcement Resource Search.  If the user has just
    // completed a search, the selected jurisdiction will be on the request.  If not, we just use what is retrieved
    // from the database.
    String jurisdiction = (String) request.getAttribute("jurisdiction");
    if (jurisdiction == null) {
      jurisdiction = FormattingHelper.formatString(entryInfo.getSzNmJurisdiction());
    }

    // The Initial and Current Priority drop down boxes are dynamically populated based on what the Classification equals.
    String initialPriorityCodes = "";
    String currentPriorityCodes = "";
    currentPriorityCodes = CodesTables.CPRIORTY;
    initialPriorityCodes = CodesTables.CPRIORTY;

    //  The disposition is used to set Classification.  If a disposition is retrieved that
    // means that the user has marked the Intake as an I&R or SPC on the Call Information page.
    // We case on disposition to see if the user has selected a Non-Case Related Special Request,
    // an I&R, or a Case-Related Special Request.  If the Intake is an NCRSR or an I&R, we disable
    // most of the fields in the Call Decision section.
    String disposition = callDecisionData.getSzCdIncomingDisposition();
    if (disposition == null) {
      disposition = StringHelper.EMPTY_STRING;
    }

    if (disposition.equals(CodesTables.CDISP_SCR) || disposition.equals(CodesTables.CDISP_SCO)) {
      bResourceSearch = true;
    } else {
      bResourceSearch = false;
    }

    // Generate list of dispositions to choose from. No longer all values in Codes Tables
    List dispOptions = new ArrayList();
    Option dispOption = null;
    dispOption = new Option(CodesTables.CDISP_ACA, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_ACA));
    dispOptions.add(dispOption);
    dispOption = new Option(CodesTables.CDISP_DIV, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_DIV));
    dispOptions.add(dispOption);
    dispOption = new Option(CodesTables.CDISP_SCO, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_SCO));
    dispOptions.add(dispOption);
    dispOption = new Option(CodesTables.CDISP_SCR, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_SCR));
    dispOptions.add(dispOption);
    dispOption = new Option(CodesTables.CDISP_OIE, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_OIE));
    dispOptions.add(dispOption);

    // If the user is entering this page as an approver, there are certain fields that should be disabled.
    boolean approvalMode = false;
    if (GlobalData.isApprovalMode(request)) {
      approvalMode = true;
    }
    String caseName = callDecisionData.getSzNmStage() != null ? callDecisionData.getSzNmStage()
                                                             : StringHelper.EMPTY_STRING;

      out.write("\r\n\r\n");

    String disableApprovalStatus = "true";
            // SIR 22694, only display approval button if
            // the event has been submitted for approval.
            if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
              disableApprovalStatus = "false";
            }

            String action = ApprovalStatusConversation.DISPLAY_URI;
            if (GlobalData.isApprovalMode(request)) {
              action = "/intake/IntakeActions/submitApproval";
            }
  
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nvar saveAndSubmitClicked;\r\nvar approvalClicked;\r\n");
      out.write("\r\nfunction allegationListHyperlink (index)\r\n{\r\n\r\n\r\n  frmIntakeActions.hdnIndex.value = index;\r\n  submitValidateForm(\"frmIntakeActions\", \"/intake/IntakeActions/displayAllegationDetail\");\r\n\r\n\r\n}\r\n");
      out.write("\r\nfunction changeSpecHandlingComment(commentField, checkBox)\r\n{\r\n  frmIntakeActions.txtTxtIncmgWorkerSafety\r\n  checkBox.checked = commentField.value != \"\";\r\n\r\n}\r\n\r\nfunction showMaltreatIncareConfirmation ()\r\n{\r\n  ");
if ("Y".equals(warnSpclInvPlcmtProvider)) {
      out.write("\r\n    saveAndSubmitClicked = '");
      out.print(StringHelper.isValid(request.getParameter("btnSubmit" + ".x")));
      out.write("';\r\n    approvalClicked = '");
      out.print(StringHelper.isValid(request.getParameter("btnApprovalStatusFinal" + ".x")));
      out.write("';\r\n    warnSpclInvPlcmtProvider();\r\n  ");
}
      out.write("\r\n}\r\n\r\nfunction warnSpclInvPlcmtProvider()    \r\n{\r\n  if ('true' == saveAndSubmitClicked) \r\n  {\r\n    if(confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_ALLEG_LOC_MAL_SPCL_INV));
      out.write("\" ))\r\n    {\r\n      document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value = 'Y';\r\n      submitValidateForm('frmIntakeActions', '/intake/IntakeActions/saveAndSubmitIntake');\r\n    }\r\n  } \r\n  else if ('true' == approvalClicked) \r\n  {\r\n    if(confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_APPRVL_ALLEG_LOC_MAL_SPCL_INV));
      out.write("\" ))\r\n    {\r\n      document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value = 'Y';\r\n      submitValidateForm('frmIntakeActions', '");
      out.print(action);
      out.write("');\r\n    } \r\n  }\r\n}\r\n\r\n//MR-072 \r\nfunction showRecordsCheckConfirmation ()\r\n{\r\n  ");
if ("Y".equals(warnRecordsCheckNotCompleted)) {
      out.write("\r\n    saveAndSubmitClicked = '");
      out.print(StringHelper.isValid(request.getParameter("btnSubmit" + ".x")));
      out.write("';\r\n    warnRecordsCheckCompleted();\r\n  ");
}
      out.write("\r\n}\r\n\r\nfunction warnRecordsCheckCompleted()    \r\n{\r\n  if ('true' == saveAndSubmitClicked || document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value == 'Y') \r\n  {\r\n    if(confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_RECORDS_CHECK_WARN));
      out.write("\" ))\r\n    {\r\n      document.frmIntakeActions.hdnRecordsCheckCompletedConfirmed.value = 'Y';\r\n      submitValidateForm('frmIntakeActions', '/intake/IntakeActions/saveAndSubmitIntake');\r\n    }else{\r\n      submitValidateForm('frmIntakeActions', '/intake/IntakeActions/displayIntakeActions');     \r\n    }\r\n  } \r\n}\r\n\r\nfunction changeDisposition()\r\n{\r\n\r\n    var disposVal =    eval(\"document.frmIntakeActions.selSzCdDisp.value\");\r\n\r\n\r\n    if(\"");
      out.print(bResourceSearch);
      out.write("\"== \"false\" && (disposVal ==\"");
      out.print(CodesTables.CDISP_SCR);
      out.write("\" || disposVal ==\"");
      out.print(CodesTables.CDISP_SCO);
      out.write("\"))\r\n    {\r\n     disableValidation(\"frmIntakeActions\");\r\n   document.frmIntakeActions.hdnChangeDisp.value=true;\r\n     submitValidateForm(\"frmIntakeActions\", \"/intake/IntakeActions/displayIntakeActions\");\r\n    }else if(\"");
      out.print(bResourceSearch);
      out.write("\"== \"true\" && disposVal != \"");
      out.print(CodesTables.CDISP_SCR);
      out.write("\" && disposVal != \"");
      out.print(CodesTables.CDISP_SCO);
      out.write("\" )\r\n    {\r\n     disableValidation(\"frmIntakeActions\");\r\n   document.frmIntakeActions.hdnChangeDisp.value=true;\r\n     submitValidateForm(\"frmIntakeActions\", \"/intake/IntakeActions/displayIntakeActions\");\r\n\r\n    }\r\n\r\n\r\n\r\n }\r\n");
      out.write("\r\nfunction closeCallNarrative()\r\n{\r\n\r\n  var narrativeWindow =\r\n    window.open('',\r\n                '");
      out.print(GlobalData.getUlIdStage(request));
      out.write("',\r\n                'toolbar=no,menubar=no,width=5,height=5');\r\n  if (narrativeWindow.isDirty)\r\n  {\r\n    alert('Please save the Call Narrative before proceeding.');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    narrativeWindow.close();\r\n\r\n    return true;\r\n  }\r\n\r\n}\r\n\r\n");
      out.write("\r\nfunction saveAndSubmitFuction()\r\n{\r\n\r\n  var retVal = true;\r\n  retVal = closeCallNarrative();\r\n\r\n\r\n\r\n  if (retVal)\r\n  {\r\n   retVal = promptPersonSearch();\r\n  }\r\n\r\n  \r\n  return retVal;\r\n\r\n}\r\n\r\nfunction setSpclInvPlcmntProviderConfirmed()\r\n{\r\n  document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value = 'N';\r\n}\r\n\r\nfunction setRecordsCheckCompletedConfirmed()\r\n{\r\n  document.frmIntakeActions.hdnRecordsCheckCompletedConfirmed.value = 'N';\r\n}\r\n");
      out.write("\r\nfunction saveAndAssignFunction()\r\n{\r\n\r\n  var retVal = true;\r\n  retVal = closeCallNarrative();\r\n  if (retVal)\r\n  {\r\n   retVal = promptPersonSearch();\r\n  }\r\n  return retVal;\r\n\r\n}\r\n");
      out.write("\r\nfunction toggleDeterminationFactors()\r\n{\r\n\r\n");
if (PageModeConstants.VIEW.equals(pageMode)) {
      out.write("\r\n  var classification = document.frmIntakeActions.selSzCdStageClassification.value;\r\n  ");
} else {
      out.write("\r\n    var classification = document.frmIntakeActions.selSzCdStageClassification.options.value;\r\n  ");
}
      out.write("\r\n\r\n  if ((classification == \"");
      out.print(CodesTables.CCLASS_AFC);
      out.write("\") ||\r\n       (classification == \"");
      out.print(CodesTables.CCLASS_AOA);
      out.write("\") ||\r\n       (classification == \"");
      out.print(CodesTables.CCLASS_AOS);
      out.write("\") ||\r\n       (classification == \"");
      out.print(CodesTables.CCLASS_APS);
      out.write("\"))\r\n         {\r\n    expandCollapsed('APSfactors', 'CPSfactors');\r\n    document.frmIntakeActions.hdnClassificationType.value = '");
      out.print(CodesTables.CCLASS_APS);
      out.write("';\r\n  }\r\n  else\r\n  {\r\n    if ((classification == \"\"))\r\n    {\r\n      toggleVisibility('APSfactors', 'none');\r\n      toggleVisibility('CPSfactors', 'none');\r\n      document.frmIntakeActions.hdnClassificationType.value = '';\r\n    }\r\n    else\r\n    {\r\n      expandCollapsed('CPSfactors', 'APSfactors');\r\n      document.frmIntakeActions.hdnClassificationType.value = '");
      out.print(CodesTables.CCLASS_CPS);
      out.write("';\r\n    }\r\n  }\r\n\r\n}\r\n");
      out.write("\r\nfunction setSummaryField(decisionValue, summaryField)\r\n{\r\n\r\n  var value = eval(\"document.frmIntakeActions.\" + decisionValue + \".value\");\r\n  var spanID = summaryField + \"_id\";\r\n  var sp = document.getElementById(spanID);\r\n  sp.innerText = value;\r\n\r\n}\r\n\r\nfunction setSmryCaseField(decisionValue, summaryField)\r\n{\r\n\r\n  var value = eval(\"document.frmIntakeActions.\" + decisionValue + \".value\");\r\n  value = value.substr( 0, value.indexOf(\"|\") );\r\n  var spanID = summaryField + \"_id\";\r\n  var sp = document.getElementById(spanID);\r\n  sp.innerText = value;\r\n\r\n}\r\n");
      out.write("\r\n//STGAP00005621: Modified this function to make sure the current priority\r\n//is over written by initial priority only when there is no existing current\r\n//priority\r\nfunction setCurrentPriority()\r\n{\r\n    var value = eval(\"document.frmIntakeActions.selSzCdStageInitialPriority.value\");\r\n    var currValue = eval(\"document.frmIntakeActions.selSzCdStageCurrPriority.value\");\r\n    var disabled = eval(\"document.frmIntakeActions.selSzCdStageCurrPriority.disabled\");\r\n    if (disabled)\r\n    {\r\n      document.frmIntakeActions.selSzCdStageCurrPriority.disabled = false;\r\n    }\r\n    if(currValue == null || currValue == \"\"){\r\n    document.frmIntakeActions.selSzCdStageCurrPriority.value = value;\r\n    var sp = document.getElementById(\"dspSzCdStageCurrPriority_id\");\r\n    sp.innerText = value;\r\n    document.frmIntakeActions.hdnCurrPriority.value = value;\r\n    }else{\r\n    document.frmIntakeActions.selSzCdStageCurrPriority.value = currValue;\r\n    var sp = document.getElementById(\"dspSzCdStageCurrPriority_id\");\r\n    sp.innerText = currValue;\r\n");
      out.write("    document.frmIntakeActions.hdnCurrPriority.value = currValue;\r\n    }\r\n    if (disabled)\r\n    {\r\n      document.frmIntakeActions.selSzCdStageCurrPriority.disabled = true;\r\n    }\r\n    document.frmIntakeActions.hdnInitialPriority.value = value;\r\n\r\n}\r\n");
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName(CodesTables.CAPSPRTY);
      _jspx_th_impact_codeArray_0.setArrayName("apsPriorities");
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_1.setParent(null);
      _jspx_th_impact_codeArray_1.setCodeName(CodesTables.CPRIORTY);
      _jspx_th_impact_codeArray_1.setArrayName("cpsPriorities");
      _jspx_th_impact_codeArray_1.setBlankValue("true");
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  function updatePriorityCodesTables()\r\n{\r\n\r\n  var classification = document.frmIntakeActions.hdnClassificationType.value;\r\n  if (classification == \"");
      out.print(CodesTables.CPGRMSFM_APS);
      out.write("\")\r\n  {\r\n    populateDropdown(frmIntakeActions.selSzCdStageCurrPriority, \"\", apsPriorities);\r\n    populateDropdown(frmIntakeActions.selSzCdStageInitialPriority, \"\", apsPriorities);\r\n  }\r\n\r\n else\r\n  {\r\n   populateDropdown(frmIntakeActions.selSzCdStageCurrPriority, document.frmIntakeActions.selSzCdStageCurrPriority.value, cpsPriorities);\r\n   populateDropdown(frmIntakeActions.selSzCdStageInitialPriority, \"\", cpsPriorities);\r\n  }\r\n\r\n}\r\n");
      out.write("\r\nfunction setCPSFactorStatus()\r\n{\r\n\r\n  var noFactorsChecked = document.frmIntakeActions.CPSnoFactors;  ");
      out.write("\r\n  ");
      out.write("\r\n  if (noFactorsChecked.checked == true)\r\n  {\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CPHYABSE)).size());
      out.write("; i++)\r\n    {\r\n      var cbx1 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsPA\" +i); ");
      out.write("\r\n      cbx1.disabled = true;\r\n      cbx1.checked = false;\r\n    }\r\n\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CNEGLECT)).size());
      out.write("; i++)\r\n    {\r\n      var cbx1 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsNEG\" +i); ");
      out.write("\r\n      cbx1.disabled = true;\r\n      cbx1.checked = false;\r\n    }\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CEMLABSE)).size());
      out.write("; i++)\r\n    {\r\n      var cbx1 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsEA\" +i); ");
      out.write("\r\n      cbx1.disabled = true;\r\n      cbx1.checked = false;\r\n    }\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CSEXABSE)).size());
      out.write("; i++)\r\n    {\r\n      var cbx1 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsSA\" +i); ");
      out.write("\r\n      cbx1.disabled = true;\r\n      cbx1.checked = false;\r\n    }\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.COTHER)).size());
      out.write("; i++)\r\n    {\r\n      var cbx1 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsOTH\" +i); ");
      out.write("\r\n      cbx1.disabled = true;\r\n      cbx1.checked = false;\r\n    }\r\n\r\n\r\n    for (j = 1; j <= ");
      out.print(CPSDescrValues.size());
      out.write("; j++)\r\n    {\r\n      var cbx2 = eval(\"document.frmIntakeActions.cpsDescriptors\" +j);  ");
      out.write("\r\n      cbx2.disabled = true;\r\n      cbx2.checked = false;\r\n    }\r\n  }\r\n  else\r\n  {\r\n\r\n\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CPHYABSE)).size());
      out.write("; i++)\r\n    {\r\n      var cbx3 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsPA\" +i); ");
      out.write("\r\n      cbx3.disabled = false;\r\n    }\r\n\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CNEGLECT)).size());
      out.write("; i++)\r\n    {\r\n      var cbx3 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsNEG\" +i); ");
      out.write("\r\n     cbx3.disabled = false;\r\n    }\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CEMLABSE)).size());
      out.write("; i++)\r\n    {\r\n      var cbx3 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsEA\" +i); ");
      out.write("\r\n      cbx3.disabled = false;\r\n    }\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CSEXABSE)).size());
      out.write("; i++)\r\n    {\r\n      var cbx3 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsSA\" +i); ");
      out.write("\r\n     cbx3.disabled = false;\r\n    }\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.COTHER)).size());
      out.write("; i++)\r\n    {\r\n      var cbx3 = eval(\"document.frmIntakeActions.CPSdeterminationFactorsOTH\" +i); ");
      out.write("\r\n      cbx3.disabled = false;\r\n    }\r\n\r\n\r\n    for (j = 1; j <= ");
      out.print(CPSDescrValues.size());
      out.write("; j++)\r\n    {\r\n      var cbx4 = eval(\"document.frmIntakeActions.cpsDescriptors\" +j);  ");
      out.write("\r\n      cbx4.disabled = false;\r\n    }\r\n  }\r\n\r\n}\r\n");
      out.write("\r\nfunction setAPSFactorStatus()\r\n{\r\n\r\n  var noFactorsChecked = document.frmIntakeActions.APSnoFactors;  ");
      out.write("\r\n  ");
      out.write("\r\n  if (noFactorsChecked.checked == true)\r\n  {\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CADETFCT)).size());
      out.write("; i++)\r\n    {\r\n      var cbx1 = eval(\"document.frmIntakeActions.APSdeterminationFactors\" +i); ");
      out.write("\r\n      cbx1.disabled = true;\r\n      cbx1.checked = false;\r\n    }\r\n  }\r\n  else\r\n  {\r\n    for (i = 1; i <= ");
      out.print((Lookup.getCategoryCollection(CodesTables.CADETFCT)).size());
      out.write("; i++)\r\n    {\r\n      var cbx3 = eval(\"document.frmIntakeActions.APSdeterminationFactors\" +i); ");
      out.write("\r\n      cbx3.disabled = false;\r\n    }\r\n  }\r\n\r\n}\r\n\r\n");
      out.write("\r\nfunction promptPersonSearch()\r\n{\r\n\r\n  ");
      out.write("\r\n  if (");
      out.print(("true"
                               .equals(StringHelper
                                                   .getNonNullString((String) request
                                                                                     .getAttribute("promptPersonSearch")))));
      out.write(")\r\n  {\r\n    var save = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_SRCH_PRINC));
      out.write("');\r\n    if (save == true)\r\n    {\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n");
      out.write("\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n\r\n}\r\n\r\n");
      out.write("\r\nfunction changeClassificationFunctions(selSzCdStageClassification, dspSzCdStageClassification)\r\n{\r\n\r\n  toggleDeterminationFactors();\r\n  setSummaryField(selSzCdStageClassification, dspSzCdStageClassification);\r\n\r\n\r\n}\r\n\r\n");
      out.write("\r\n\r\nfunction populateCaseDropdown(field, val, cat)\r\n{\r\n\r\n  ");
      out.write("\r\n  field.options.length = cat.length;\r\n  for (var q=0; q < cat.length; q++)\r\n  {\r\n    ");
      out.write("\r\n    field.options[q].value = cat[q].substring(0, cat[q].lastIndexOf(\"|\"));\r\n    field.options[q].text = cat[q].substring(cat[q].lastIndexOf(\"|\")+1,cat[q].length);\r\n  }\r\n  field.value = val;\r\n\r\n}\r\n\r\n\r\n\r\n//}\r\n");
      out.write("\r\nwindow.attachEvent('onbeforeunload', navAway);\r\nfunction navAway()\r\n{\r\n  document.frmIntakeActions.hdnIsIntakeActionsDirty.value = isPageChanged();\r\n  if (document.frmIntakeActions.hdnResourceSearch.value == \"true\")\r\n  {\r\n    document.frmIntakeActions.hdnIsIntakeActionsDirty.value = \"true\";\r\n  }\r\n}\r\n\r\nfunction deleteAllegationConfirm()\r\n{\r\n  ");
      out.write("\r\n  navAway();\r\n  ");
      out.write("\r\n  return confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("');\r\n}\r\n");
      out.write("\r\nwindow.attachEvent('onload', checkIndAllegList);\r\nfunction checkIndAllegList()\r\n{\r\n   var indDelList = '");
      out.print((String) request.getAttribute("hdnIndDelAlleg") == null ? ""
                                                                                  : (String) request
                                                                                                    .getAttribute("hdnIndDelAlleg"));
      out.write("';\r\n  if (indDelList == 'Y')\r\n  {\r\n    var save = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ALLEG_DEL_CNFRM));
      out.write("');\r\n    if (save == true)\r\n    {\r\n      document.frmIntakeActions.hdnIndDelAlleg.value = 'N';\r\n      document.frmIntakeActions.hdnIsIntakeActionsDirty.value = true;\r\n      document.frmIntakeActions.hdnIndRdBtn.value = '");
      out.print((Integer) request.getAttribute("rbAllegList") == null ? 0
                                                                                : (Integer) request
                                                                                                   .getAttribute("rbAllegList"));
      out.write("'\r\n      submitValidateForm(\"frmIntakeActions\", \"/intake/IntakeActions/deleteAllegationFromList\");\r\n    }\r\n  }\r\n}\r\n ");
      out.write("\r\nfunction callDetermFaqFormSubmit(detFaqType) {\r\n  frmDetFaq.hdnDetFaqType.value=detFaqType;\r\n  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=600,height=350');\r\n  frmDetFaq.target = \"txtWin\";\r\n  if( window.focus ) {\r\n    errorList.focus();\r\n  }\r\n  frmDetFaq.submit();\r\n}\r\n\r\nfunction displayWindowParameters() {\r\n  var descriptor = \"\";\r\n  descriptor += \"width=700,\";\r\n  descriptor += \"height=475,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=0,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=0,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=0,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=0,\";\r\n  descriptor += \"toolbar=0\"; \r\n}\r\n\r\nfunction displayMICHelp(helpTopic) {\r\nvar topic = helpTopic;\r\n var descriptor = \"\";\r\n  descriptor += \"width=450,\";\r\n  descriptor += \"height=350,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=1,\";\r\n");
      out.write("  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=1,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=1,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=1,\";\r\n  descriptor += \"toolbar=0\";\r\n  if(helpTopic != \"\")\r\n   return window.open('/intake/IntakeActions/displayMICHelp'+'#'+topic, \"\", descriptor);\r\n}\r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      <a tabIndex=\"");
      out.print(tabIndex++);
      out.write("\" href=\"#\" onClick=\"expandAll();\">Expand All</a>&nbsp; <a tabIndex=\"");
      out.print(tabIndex++);
      out.write("\" href=\"#\" onClick=\"collapseAll();\">Collapse All</a>&nbsp;\r\n    </td>\r\n\r\n  </tr>\r\n</table>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmIntakeActions");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/intake/IntakeActions/displayIntakeActions");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeActionsCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          out.write("\r\n\r\n  ");

    /* hdnIndex is used to get the selected row from the allegation list array when a hyperlink is clicked.
             The javaScript function called when the user clicks the hyperlink sets the value for hdnIndex. */
  
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");

    /* hdnClassificationType is used to hold the classification type that is figured out in
             toggleDeterminationFactors. */
  
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");

    /* hdnCurrPriority is used to hold the value of Current Priority when the page is not in Approve Mode.  Current Priority
             is only enabled in Approve mode, but is modified and needs to be submitted in Edit mode also.  */
  
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnCurrPriority");
          _jspx_th_impact_validateInput_2.setValue( callDecisionData.getSzCdStageCurrPriority() );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

    /* This hidden field contains values from the Call Entry object and is used in the Custom Validation.
             Instead of passing in the entire Call Entry object, we just set them into hidden fields.        */
  
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnSzCdIncomingDisposition");
          _jspx_th_impact_validateInput_3.setValue( entryInfo.getSzCdIncomingDisposition() );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnSzCdNonIncReqType");
          _jspx_th_impact_validateInput_4.setValue( entryInfo.getCdIncomingProgramType() );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnSzCdSplInvest");
          _jspx_th_impact_validateInput_5.setValue( entryInfo.getSzCdSpclInvstgtn() );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnTsIncmgCallDisp");
          _jspx_th_impact_validateInput_6.setValue(  FormattingHelper.formatDate( entryInfo.getTsIncmgCallDisp() ) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnIndTrialHomeVisit");
          _jspx_th_impact_validateInput_10.setValue( callEntryData.getCIndTrialHomeVisit() );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

    /* It was decided that clicking on any of the 2nd level Intake tabs should autosave the current page before displaying the
             next page.  We use the hdnSavePageName field as an indicator to the next conversation to save the Call Information
             page before displaying.  For instance, if the user is on Call Info and clicks the Call Log tab, the Call Log display method
             will check to see if the hdnSaveCallInformation indicator is in the request and equal to true, and if so will call the
             Call Information save before displaying the Call Log page. This will work when navigating from Intake Actions to Call Info,
             from Call Info to Intake Actions, from Intake Actions to Call Log, and from Call Info to Call Log. */
  
          out.write("\r\n  ");

    if (!PageModeConstants.VIEW.equals(pageMode)) {
  
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");

    }
  
          out.write("\r\n  ");

    /* The hdnIsIntakeActionsDirty field is used by the Call Information and Call Log pages to determine if any changes were
             made on the Intake Actions page and whether to call the Intake Actions Save.*/
  
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");

    /* The hidden value incomingStatus is used on the Allegation Detail page.  If the user enters the intake
             in approval mode and they are NOT the approver, if the user saves the Allegation Detail page, we should
             invalidate the pending approval.  The allegation_AUD() method uses the value for hdnIncomingStatus
             to determine whether we should invalidate the pending approval or not.  */
  
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnIncomingStatus");
          _jspx_th_impact_validateInput_13.setValue( entryInfo.getCdIncmgStatus() );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

    /* The hdnResourceSearch field is set when the user returns from a Resource Search.  Since we set
             the retrieved resource info into the facility detail object in state before the page is loaded,
             our save method did not register a change in Law Jurisdiction.  In the save method we check to
             see if the data has been changed since the page loaded OR if this indicator is true.  */
  
          out.write("\r\n  ");

    String resourceSearch = (String) request.getAttribute("resourceSearch");
  
          out.write("\r\n  ");

    String hdnResourceId = (String) request.getAttribute("jurisdictionResourceId");
  
          out.write("\r\n  ");

    String refferedResourceId = (String) request.getAttribute("refferedResourceId");
  
          out.write("\r\n  ");

    String serviceProviderName = (String) request.getAttribute("serviceProviderName");
  
          out.write("\r\n  ");

    String typeOfService = (String) request.getAttribute("typeOfService");
  
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnResourceSearch");
          _jspx_th_impact_validateInput_14.setValue( resourceSearch );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnResourceId");
          _jspx_th_impact_validateInput_15.setValue( hdnResourceId );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("hdnInitialPriority");
          _jspx_th_impact_validateInput_16.setValue( callDecisionData.getSzCdStageInitialPriority() );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnCaseName");
          _jspx_th_impact_validateInput_17.setValue( caseName );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("hdnbResourceSearch");
          _jspx_th_impact_validateInput_19.setValue(String.valueOf(bResourceSearch) );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_20(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");

    if (ArchitectureConstants.TRUE.equals(resourceSearch))

            {

              callDecisionData.setSzCdServiceProviderName(serviceProviderName);
              callDecisionData.setSzCdTypeOfService(typeOfService);
              callDecisionData.setUlIdRefferedResource(Integer.valueOf(refferedResourceId));
            }

            //get Type of Serive provider
            String typeOfServiceProvider = StringHelper.EMPTY_STRING;
            if (callDecisionData.getSzCdTypeOfService() != null
                && StringHelper.isValid(callDecisionData.getSzCdTypeOfService())) {
              typeOfServiceProvider = Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE,
                                                              callDecisionData.getSzCdTypeOfService());
            }
  
          out.write("\r\n\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("hdnRefferedResourceId");
          _jspx_th_impact_validateInput_21.setValue( FormattingHelper.formatInt(callDecisionData.getUlIdRefferedResource()));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n  ");

    //*******************************************************************************
            //******************************** APPROVAL STATUS  ***********************************
            //*******************************************************************************
  
          out.write("\r\n  \r\n\r\n  ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest(
                        ((Boolean.valueOf(disableApprovalStatus) == false) ||
                         (GlobalData.getUlIdCase(request) != 0))
                     );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n      <tr>\r\n        <td align=\"left\">\r\n          ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
              _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
              _jspx_th_impact_ButtonTag_0.setForm("frmIntakeActions");
              _jspx_th_impact_ButtonTag_0.setAction(action);
              _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_0.setDisabled(disableApprovalStatus);
              _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        ");

          // If there is a case id in global data, we want to give the user the option to navigate back
                    // back to the Case Summary page.  This becomes important when the user is reviewing an Intake
                    // from an Investigation stage and would like to return to Case Summary page.
                    //The validations for the IntakeActions are disabled after clicking the Return To Case Summary hyperlink.
                    if (GlobalData.getUlIdCase(request) != 0) {
        
              out.write("\r\n\r\n        <td align=\"right\">\r\n          <a href=\"javascript:disableValidation('frmIntakeActions');submitValidateForm('frmIntakeActions', '/workload/CaseSummary/displayCaseSummary')\">Return to Case Summary</a>\r\n          <br>\r\n        </td>\r\n        ");

          }
        
              out.write("\r\n\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

    //*******************************************************************************
            //******************************** ALLEGATION  ***********************************
            //*******************************************************************************
  
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("Allegation");
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Allegation");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded(true);
          _jspx_th_impact_ExpandableSectionTag_0.setAccessKey("T");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");

      /* This outer table is here to set the background color to white  */
    
              out.write("\r\n    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n      <tr>\r\n        <td>\r\n          <div id=\"scrollBar2\" style=\"height:130px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"2\" border=\"0\">\r\n              <tr class=\"subDetail\">\r\n                <!-- <th class=\"thList\">Alleged Perpetrator</th> -->\r\n                <TH class=\"thList\">\r\n                  &nbsp;\r\n                </TH>\r\n                <TH class=\"thList\">\r\n                  Allegation\r\n                </TH>\r\n                <TH class=\"thList\">\r\n                  Alleged Victim\r\n                </TH>\r\n\r\n              </tr>\r\n              ");

                loopCount = 0;
                          allegListEnum = allegListArray.enumerateROWCINT76DO();
                          if (allegListEnum == null || !(allegListEnum.hasMoreElements())) {
              
              out.write("\r\n              <tr class=\"odd\">\r\n                <td>\r\n                  &nbsp;\r\n                </td>\r\n                <td colspan=\"3\">\r\n                  ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                </td>\r\n              </tr>\r\n              ");

                } else {
                            while (allegListEnum.hasMoreElements()) {
                              allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
                              String radioId = "rbAllegList_" + loopCount;
              
              out.write("\r\n              <tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\" valign=\"top\">\r\n\r\n                <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_22.setType("radio");
              _jspx_th_impact_validateInput_22.setId( radioId );
              _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_22.setName("rbAllegList");
              _jspx_th_impact_validateInput_22.setValue( String.valueOf(loopCount) );
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n\r\n                <td>                 \r\n                  ");

                                     {
                                   
              out.write("\r\n                  <a href=\"javascript:disableValidation('frmIntakeActions');allegationListHyperlink('");
              out.print(loopCount);
              out.write("');\" onClick=\"setIsDirtyCalled(true); window.onBeforeUnload=null;\" tabIndex=\"");
              out.print(tabIndex++);
              out.write('"');
              out.write('>');
              out.write(' ');
              out.print(allegListRow.getSzCdIntakeAllegMalCode());
              out.write("</a>\r\n                  ");

                    }
                  
              out.write("\r\n                </td>\r\n                <td>\r\n                  ");
              out.print(allegListRow.getSzScrPersVictim());
              out.write("\r\n                </td>\r\n\r\n              </tr>\r\n              ");

                loopCount++;
                            }
                          }
              
              out.write("\r\n            </table>\r\n          </div>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n      <tr>\r\n      ");

        String disableAllegationDeleteAndCopy = "true";
                  // STGAP00010576, only display copy and add buttons if
                  // an Allegation exist.
                  if (allegListArray != null) {
                    if (allegListArray.getROWCINT76DO() != null && allegListArray.getROWCINT76DOCount() > 0) {
                      disableAllegationDeleteAndCopy = "false";
                    }
                  }
      
              out.write("      \r\n     ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ifThen_1.setTest(
                        ((Boolean.valueOf(disableAllegationDeleteAndCopy) == false)));
              int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
              if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("        \r\n        <td width=\"85%\">\r\n          ");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
                  _jspx_th_impact_ButtonTag_1.setName("btnDeleteFromList");
                  _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
                  _jspx_th_impact_ButtonTag_1.setAlign("left");
                  _jspx_th_impact_ButtonTag_1.setForm("frmIntakeActions");
                  _jspx_th_impact_ButtonTag_1.setAction("/intake/IntakeActions/deleteAllegationFromList");
                  _jspx_th_impact_ButtonTag_1.setFunction("return deleteAllegationConfirm();");
                  _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
                  _jspx_th_impact_ButtonTag_1.setAccessKey("D");
                  _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
                  int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
                  if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>\r\n        <td width=\"10%\">\r\n          ");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
                  _jspx_th_impact_ButtonTag_2.setName("btnNewUsingAlleg");
                  _jspx_th_impact_ButtonTag_2.setImg("btnNewUsing");
                  _jspx_th_impact_ButtonTag_2.setAlign("left");
                  _jspx_th_impact_ButtonTag_2.setForm("frmIntakeActions");
                  _jspx_th_impact_ButtonTag_2.setAction("/intake/IntakeActions/displayAllegationDetail");
                  _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
                  _jspx_th_impact_ButtonTag_2.setAccessKey("U");
                  int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
                  if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>\r\n     ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n        <td width=\"5%\">\r\n          ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_3.setName("btnAdd");
              _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_3.setAlign("left");
              _jspx_th_impact_ButtonTag_3.setForm("frmIntakeActions");
              _jspx_th_impact_ButtonTag_3.setAction("/intake/IntakeActions/displayAllegationDetail");
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_ButtonTag_3.setAccessKey("N");
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <br>\r\n  ");

    //*******************************************************************************
            //******************************** CALL DECISION ***********************************
            //*******************************************************************************
  
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("Decision");
          _jspx_th_impact_ExpandableSectionTag_1.setId("dspDtLicngInvstIntake");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Intake Decision");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_1.setIsExpanded(true);
          _jspx_th_impact_ExpandableSectionTag_1.setAccessKey("Q");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n      <tr class=\"subDetail\">\r\n        <td width=\"15%\">\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_0.setName("dspDtLicngInvstIntake");
              _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Intake ID");
              _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatInt(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        ");

          // If the user marked the Intake as a SPC on Call Information, we want to initialize the Classification to SPC.
                    // If the user marked the Intake as an I&R, we initialize to I&R.  Else we just want to use whatever is retrieved from
                    // the database.  If the Intake is an SPC (NCRSR or CRSR) or an I&R or we are in APPROVE mode, we also disable Classification.
                    String classValue = classValue = callDecisionData.getSzCdStageClassification() != null ? callDecisionData
                                                                                                                             .getSzCdStageClassification()
                                                                                                          : StringHelper.EMPTY_STRING;
                    boolean disableClass = false;
        
              out.write("\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_0.setLabel("Program Area");
              _jspx_th_impact_validateSelect_0.setOnChange("changeClassificationFunctions('selSzCdStageClassification', 'dspSzCdStageClassification');");
              _jspx_th_impact_validateSelect_0.setName("selSzCdStageClassification");
              _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CCLASS );
              _jspx_th_impact_validateSelect_0.setValue( classValue );
              _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf(disableClass) );
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_1.setColspan("4");
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Case Name");
              _jspx_th_impact_validateDisplayOnlyField_1.setName("dspCaseName");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue( caseName );
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n      </tr>\r\n    </table>\r\n ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <div id=\"CPSfactors\" style=\"Display: none\">\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n        <tr class=\"subDetail\">\r\n          <th colspan=\"6\">\r\n            CPS\r\n          </th>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"6\">\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setLabel("No Factors");
          _jspx_th_impact_validateInput_23.setType("checkbox");
          _jspx_th_impact_validateInput_23.setValue("Y");
          _jspx_th_impact_validateInput_23.setChecked( checkNoFactors );
          _jspx_th_impact_validateInput_23.setName("CPSnoFactors");
          _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_23.setOnClick("setCPSFactorStatus()");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n</table>\r\n<br>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th>Determination Factors:</th>\r\n    </tr>\r\n<tr>\r\n<td>\r\n<div id=\"PhysicalAbuse\" style=\"Display: ");
          out.print(showPhysAbuse);
          out.write("\">\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("Physical Abuse");
          _jspx_th_impact_ExpandableSectionTag_2.setId("");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Physical Abuse");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"6\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr class=\"subDetail\">\r\n                <td>\r\n                  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes( CPScheckedValuesPA );
              _jspx_th_impact_codesCheckbox_0.setName("CPSdeterminationFactorsPA");
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CPHYABSE );
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>                 \r\n             <a name=\"DetFaq_pp\" href=\"#DetFaq_pp\" onClick = \"callDetermFaqFormSubmit('PP')\">Determination Factors questions </a>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n             ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_0.setColspan("5");
              _jspx_th_impact_validateTextArea_0.setName("txtSzTxtPhyAbsCmnts");
              _jspx_th_impact_validateTextArea_0.setRows("5");
              _jspx_th_impact_validateTextArea_0.setCols("145");
              _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_0.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_0.setDisabled("false");
              _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph4000");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n             ");
                  out.print(FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtPhyAbsCmnts()));
                  out.write("\r\n             ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</div>\r\n<div id=\"Neglect\" style=\"Display:  ");
          out.print(showNeglect);
          out.write("\">\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("Neglect");
          _jspx_th_impact_ExpandableSectionTag_3.setId("");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Neglect");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"6\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr class=\"subDetail\">\r\n                <td>\r\n                  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_codesCheckbox_1.setDefaultCodes( CPScheckedValuesNEG );
              _jspx_th_impact_codesCheckbox_1.setName("CPSdeterminationFactorsNEG");
              _jspx_th_impact_codesCheckbox_1.setCodesTableName( CodesTables.CNEGLECT );
              _jspx_th_impact_codesCheckbox_1.setColumns(3);
              _jspx_th_impact_codesCheckbox_1.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
              if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>                 \r\n             <a name=\"DetFaq_nn\" href=\"#DetFaq_nn\" onClick = \"callDetermFaqFormSubmit('NN')\">Determination Factors questions </a>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n             ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_1.setColspan("5");
              _jspx_th_impact_validateTextArea_1.setName("txtSzTxtNegAbsCmnts");
              _jspx_th_impact_validateTextArea_1.setRows("5");
              _jspx_th_impact_validateTextArea_1.setCols("145");
              _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_1.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_1.setDisabled("false");
              _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph4000");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n             ");
                  out.print(FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtNegAbsCmnts()));
                  out.write("\r\n             ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</div>\r\n<div id=\"EmotionalAbuse\" style=\"Display:  ");
          out.print(showEmtAbuse);
          out.write("\">\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName("Emotional Abuse");
          _jspx_th_impact_ExpandableSectionTag_4.setId("");
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Emotional Abuse");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"6\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr class=\"subDetail\">\r\n                <td>\r\n                  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_codesCheckbox_2.setDefaultCodes( CPScheckedValuesEA );
              _jspx_th_impact_codesCheckbox_2.setName("CPSdeterminationFactorsEA");
              _jspx_th_impact_codesCheckbox_2.setCodesTableName( CodesTables.CEMLABSE );
              _jspx_th_impact_codesCheckbox_2.setColumns(3);
              _jspx_th_impact_codesCheckbox_2.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_2 = _jspx_th_impact_codesCheckbox_2.doStartTag();
              if (_jspx_th_impact_codesCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>                 \r\n             <a name=\"DetFaq_ee\" href=\"#DetFaq_ee\" onClick = \"callDetermFaqFormSubmit('EE')\">Determination Factors questions </a>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n             ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_2.setColspan("5");
              _jspx_th_impact_validateTextArea_2.setName("txtSzTxtEmAbsCmnts");
              _jspx_th_impact_validateTextArea_2.setRows("5");
              _jspx_th_impact_validateTextArea_2.setCols("145");
              _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_2.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_2.setDisabled("false");
              _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph4000");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n             ");
                  out.print(FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtEmAbsCmnts()));
                  out.write("\r\n             ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</div>\r\n<div id=\"SexualAbuse\" style=\"Display:  ");
          out.print(showSexAbuse);
          out.write("\">\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("Sexual Abuse");
          _jspx_th_impact_ExpandableSectionTag_5.setId("");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("Sexual Abuse");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"6\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr class=\"subDetail\">\r\n                <td>\r\n                  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_codesCheckbox_3.setDefaultCodes( CPScheckedValuesSA );
              _jspx_th_impact_codesCheckbox_3.setName("CPSdeterminationFactorsSA");
              _jspx_th_impact_codesCheckbox_3.setCodesTableName( CodesTables.CSEXABSE );
              _jspx_th_impact_codesCheckbox_3.setColumns(3);
              _jspx_th_impact_codesCheckbox_3.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_3 = _jspx_th_impact_codesCheckbox_3.doStartTag();
              if (_jspx_th_impact_codesCheckbox_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>                 \r\n             <a name=\"DetFaq_ss\" href=\"#DetFaq_ss\" onClick = \"callDetermFaqFormSubmit('SS')\">Determination Factors questions </a>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n             ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateTextArea_3.setColspan("5");
              _jspx_th_impact_validateTextArea_3.setName("txtSzTxtSxAbsCmnts");
              _jspx_th_impact_validateTextArea_3.setRows("5");
              _jspx_th_impact_validateTextArea_3.setCols("145");
              _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_3.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_3.setDisabled("false");
              _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph4000");
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n             ");
                  out.print(FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtSxAbsCmnts()));
                  out.write("\r\n             ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n       </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</div>\r\n<div id=\"SpecialCircumstances\" style=\"Display:  ");
          out.print(showSplHandling);
          out.write("\">\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_6.setName("Special Circumstances");
          _jspx_th_impact_ExpandableSectionTag_6.setId("");
          _jspx_th_impact_ExpandableSectionTag_6.setLabel("Special Circumstances");
          _jspx_th_impact_ExpandableSectionTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_6 = _jspx_th_impact_ExpandableSectionTag_6.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"6\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr class=\"subDetail\">\r\n                <td>\r\n                  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_codesCheckbox_4.setDefaultCodes( CPScheckedValuesOTH );
              _jspx_th_impact_codesCheckbox_4.setName("CPSdeterminationFactorsOTH");
              _jspx_th_impact_codesCheckbox_4.setCodesTableName( CodesTables.COTHER );
              _jspx_th_impact_codesCheckbox_4.setColumns(3);
              _jspx_th_impact_codesCheckbox_4.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_4 = _jspx_th_impact_codesCheckbox_4.doStartTag();
              if (_jspx_th_impact_codesCheckbox_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n             <span class=\"formCondRequiredText\">&#135;</span>Comments:\r\n          </td>\r\n        <tr>\r\n          <td>\r\n             ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_validateTextArea_4.setColspan("5");
              _jspx_th_impact_validateTextArea_4.setName("txtSzTxtOthCmnts");
              _jspx_th_impact_validateTextArea_4.setRows("5");
              _jspx_th_impact_validateTextArea_4.setCols("145");
              _jspx_th_impact_validateTextArea_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_4.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_4.setDisabled("false");
              _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph4000");
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n             ");
                  out.print(FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtOthCmnts()));
                  out.write("\r\n             ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          ");
              out.write("\r\n\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"6\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr class=\"subDetail\">\r\n                <td>\r\n                  ");
              //  impact:listCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.ListCheckboxesTag _jspx_th_impact_listCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.ListCheckboxesTag();
              _jspx_th_impact_listCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_listCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_listCheckbox_0.setDefaultCodes( CPSDescrCheckedValues );
              _jspx_th_impact_listCheckbox_0.setName("cpsDescriptors");
              _jspx_th_impact_listCheckbox_0.setCodesList( CPSDescrValues );
              _jspx_th_impact_listCheckbox_0.setColumns(3);
              _jspx_th_impact_listCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_listCheckbox_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_listCheckbox_0 = _jspx_th_impact_listCheckbox_0.doStartTag();
              if (_jspx_th_impact_listCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</div>\r\n</td>\r\n</tr>\r\n</table>\r\n<br>\r\n</div>\r\n\r\n    <div id=\"APSfactors\" style=\"Display: none\">\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n        <tr class=\"subDetail\">\r\n          <th>\r\n            APS\r\n          </th>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setLabel("No Factors");
          _jspx_th_impact_validateInput_24.setType("checkbox");
          _jspx_th_impact_validateInput_24.setChecked( checkNoFactors );
          _jspx_th_impact_validateInput_24.setValue("Y");
          _jspx_th_impact_validateInput_24.setId("noFactors");
          _jspx_th_impact_validateInput_24.setName("APSnoFactors");
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_24.setOnClick("setAPSFactorStatus()");
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <th>\r\n            Determination Factors\r\n          </th>\r\n\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td>\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr class=\"subDetail\">\r\n                <td>\r\n                  ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_5.setDefaultCodes(APScheckedValues);
          _jspx_th_impact_codesCheckbox_5.setName("APSdeterminationFactors");
          _jspx_th_impact_codesCheckbox_5.setCodesTableName( CodesTables.CADETFCT );
          _jspx_th_impact_codesCheckbox_5.setColumns(3);
          _jspx_th_impact_codesCheckbox_5.setIsHorizontal(true);
          _jspx_th_impact_codesCheckbox_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_codesCheckbox_5 = _jspx_th_impact_codesCheckbox_5.doStartTag();
          if (_jspx_th_impact_codesCheckbox_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </div>\r\n");

  String mandatedReporterInd = FormattingHelper.formatString(callDecisionData.getBIndMRLetter());
          mandatedReporterInd = mandatedReporterInd != "" ? mandatedReporterInd : "N";
          String disableMRLetter = "true";

          if ((Boolean) state.getAttribute("showMRLetter", request) != null
              && (Boolean) state.getAttribute("showMRLetter", request)) {
            disableMRLetter = "false";

          }

          out.write("\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n      <tr class=\"subDetail\">\r\n        <th colspan=\"6\">\r\n          Response Time\r\n        </th>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td width=\"15%\">\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Initial");
          _jspx_th_impact_validateSelect_1.setName("selSzCdStageInitialPriority");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( initialPriorityCodes );
          _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString(callDecisionData.getSzCdStageInitialPriority()) );
          _jspx_th_impact_validateSelect_1.setOnChange("setCurrentPriority();");
          _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf(approvalMode) );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Current");
          _jspx_th_impact_validateSelect_2.setName("selSzCdStageCurrPriority");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable( currentPriorityCodes );
          _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString(callDecisionData.getSzCdStageCurrPriority()) );
          _jspx_th_impact_validateSelect_2.setOnChange("  setSummaryField('selSzCdStageCurrPriority', 'dspSzCdStageCurrPriority');");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Reason Changed");
          _jspx_th_impact_validateSelect_3.setName("selSzCdStageRsnPriorityChgd");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CRSNPRIO );
          _jspx_th_impact_validateSelect_3.setValue( FormattingHelper.formatString(callDecisionData.getSzCdStageRsnPriorityChgd()) );
          _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf(!approvalMode) );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Disposition");
          _jspx_th_impact_validateSelect_4.setName("selSzCdDisp");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setOptions( dispOptions );
          _jspx_th_impact_validateSelect_4.setDisabled( String.valueOf(!approvalMode) );
          _jspx_th_impact_validateSelect_4.setValue( FormattingHelper.formatString(callDecisionData.getSzCdIncomingDisposition()));
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_4.setOnChange("changeDisposition();");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setColspan("4");
          _jspx_th_impact_validateSelect_5.setLabel("Screen Out Reason");
          _jspx_th_impact_validateSelect_5.setName("selSzCdScreentOutReason");
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_5.setCodesTable( CodesTables.CSCNOTRN );
          _jspx_th_impact_validateSelect_5.setDisabled( String.valueOf(!approvalMode) );
          _jspx_th_impact_validateSelect_5.setValue( FormattingHelper.formatString(callDecisionData.getSzCdStageScroutReason()) );
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      <!-- CAPTA 4.3 changes -->\r\n      \r\n      <tr class=\"subDetail\">\r\n        <td colspan =\"2\">\r\n          Is this alleged Maltreatment in Care \r\n          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayMICHelp('maltreatmentInCare')\">?</a></strong>\r\n        </td>\r\n        <td>  \r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setLabel("Yes");
          _jspx_th_impact_validateInput_25.setName("rbIndMaltreatInCare");
          _jspx_th_impact_validateInput_25.setValue("Y");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setChecked( yIsCheckedMaltreatment );
          _jspx_th_impact_validateInput_25.setDisabled("true");
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setLabel("No");
          _jspx_th_impact_validateInput_26.setName("rbIndMaltreatInCare");
          _jspx_th_impact_validateInput_26.setValue("N");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setChecked( nIsCheckedMaltreatment );
          _jspx_th_impact_validateInput_26.setDisabled("true");
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n        <td colspan =\"2\">\r\n          Is this a Policy Violation \r\n          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayMICHelp('policyViolation')\">?</a></strong>\r\n        </td>\r\n        <td>  \r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setLabel("Yes");
          _jspx_th_impact_validateInput_27.setName("rbIndPolicyViolation");
          _jspx_th_impact_validateInput_27.setValue("Y");
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setChecked( yIsCheckedPolicyViolation );
          _jspx_th_impact_validateInput_27.setDisabled( disableViolationButton );
          _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setLabel("No");
          _jspx_th_impact_validateInput_28.setName("rbIndPolicyViolation");
          _jspx_th_impact_validateInput_28.setValue("N");
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setChecked( nIsCheckedPolicyViolation );
          _jspx_th_impact_validateInput_28.setDisabled( disableViolationButton );
          _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      \r\n      <tr class=\"subDetail\">\r\n      <td colspan =\"6\">\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setLabel(" Mandated Reporter Letter Sent");
          _jspx_th_impact_validateInput_29.setName("cbxBIndMandatedLetter");
          _jspx_th_impact_validateInput_29.setType("checkbox");
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setChecked( mandatedReporterInd );
          _jspx_th_impact_validateInput_29.setValue("Y");
          _jspx_th_impact_validateInput_29.setDisabled( disableMRLetter );
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                              </td>\r\n                              </tr>\r\n                              <tr class=\"subDetail\">\r\n        <td>\r\n          ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_5.setColspan("5");
          _jspx_th_impact_validateTextArea_5.setLabel("Comments Regarding Screen out or Diversion");
          _jspx_th_impact_validateTextArea_5.setName("txtSzTxtStagePriorityCmnts");
          _jspx_th_impact_validateTextArea_5.setRows("4");
          _jspx_th_impact_validateTextArea_5.setCols("77");
          _jspx_th_impact_validateTextArea_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_5.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_5.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_5.setDisabled( String.valueOf(!approvalMode) );
          _jspx_th_impact_validateTextArea_5.setConstraint("Paragraph4000");
          int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
          if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_5.doInitBody();
            }
            do {
              out.write("\r\n            ");
              out.print(FormattingHelper.formatString(callDecisionData.getSzTxtStagePriorityCmnts()));
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      ");
          out.write("\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_6.setColspan("5");
          _jspx_th_impact_validateTextArea_6.setLabel("Special Instuctions");
          _jspx_th_impact_validateTextArea_6.setName("txtSzTxtStageSpIns");
          _jspx_th_impact_validateTextArea_6.setRows("4");
          _jspx_th_impact_validateTextArea_6.setCols("77");
          _jspx_th_impact_validateTextArea_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_6.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_6.setConstraint("Paragraph4000");
          int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
          if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_6.doInitBody();
            }
            do {
              out.write("\r\n            ");
              out.print(FormattingHelper.formatString(callDecisionData.getSzTxtStageSplInstrtCmnt()));
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Service Provider Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspSzCdServiceProviderName");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString( callDecisionData.getSzCdServiceProviderName())  );
          _jspx_th_impact_validateDisplayOnlyField_2.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td >\r\n          ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Type Of Service");
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspSzCdTypeOfService");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( typeOfServiceProvider );
          _jspx_th_impact_validateDisplayOnlyField_3.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n\r\n        <td align=\"right\">\r\n          ");

            //if the values of selSzCdDisp is  CodesTables.CDISP_SCR  then disable the button
          
          out.write("\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnResource");
          _jspx_th_impact_ButtonTag_4.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_4.setForm("frmIntakeActions");
          _jspx_th_impact_ButtonTag_4.setDisabled( String.valueOf(!bResourceSearch) );
          _jspx_th_impact_ButtonTag_4.setFunction("disableValidation('frmIntakeActions');");
          _jspx_th_impact_ButtonTag_4.setAction("/intake/IntakeActions/searchResource");
          _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n\r\n      </tr>\r\n    </table>\r\n    ");

      /* Begin Special Handling */
    
          out.write("\r\n    ");

      String workerSafetyInd = FormattingHelper.formatString(callDecisionData.getBIndIncmgWorkerSafety());
              workerSafetyInd = workerSafetyInd != "" ? workerSafetyInd : "N";

              String sensitiveInd = FormattingHelper.formatString(callDecisionData.getBIndIncmgSensitive());
              sensitiveInd = sensitiveInd != "" ? sensitiveInd : "N";
              /* Begin Sir 23720 */
              String suspMethInd = FormattingHelper.formatString(callDecisionData.getBIndIncmgSuspMeth());
              suspMethInd = suspMethInd != "" ? suspMethInd : "N";

              // ochumd whenever there is error on the page or when you do select law
              // juridiction check boxes loose data.

              if (FormattingHelper.formatString(callDecisionData.getTxtIncomgSuspMeth()).length() > 0) {
                suspMethInd = "Y";
              }
              if (FormattingHelper.formatString(callDecisionData.getTxtIncomgSensitive()).length() > 0) {
                sensitiveInd = "Y";
              }

              if (FormattingHelper.formatString(callDecisionData.getTxtIncmgWorkerSafety()).length() > 0) {
                workerSafetyInd = "Y";
              }
              /* End Sir 23720 */
    
          out.write("\r\n\r\n    ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_7.setLabel("Special Handling");
          _jspx_th_impact_ExpandableSectionTag_7.setName("SpecialHandling");
          _jspx_th_impact_ExpandableSectionTag_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_7 = _jspx_th_impact_ExpandableSectionTag_7.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n        <tr class=\"subDetail\">\r\n          <td width=\"15%\">\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_6.setLabel("Special Handling");
              _jspx_th_impact_validateSelect_6.setName("selSzCdCaseSpeclHndlg");
              _jspx_th_impact_validateSelect_6.setValue( FormattingHelper.formatString(callDecisionData.getSzCdIncmgSpecHandling()) );
              _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_6.setCodesTable( CodesTables.CSPECHND );
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"2\">\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateInput_30.setLabel("Worker Safety Issues");
              _jspx_th_impact_validateInput_30.setName("cbxBIndCaseWorkerSafety");
              _jspx_th_impact_validateInput_30.setType("checkbox");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setChecked( workerSafetyInd );
              _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_30.setValue("Y");
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td>\r\n            ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateTextArea_7.setLabel("Comments");
              _jspx_th_impact_validateTextArea_7.setName("txtTxtIncmgWorkerSafety");
              _jspx_th_impact_validateTextArea_7.setRows("3");
              _jspx_th_impact_validateTextArea_7.setCols("77");
              _jspx_th_impact_validateTextArea_7.setConstraint("Paragraph4000");
              _jspx_th_impact_validateTextArea_7.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_7.setConditionallyRequired("true");
              _jspx_th_impact_validateTextArea_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_7.setOnChange("changeSpecHandlingComment(frmIntakeActions.txtTxtIncmgWorkerSafety, frmIntakeActions.cbxBIndCaseWorkerSafety);");
              int _jspx_eval_impact_validateTextArea_7 = _jspx_th_impact_validateTextArea_7.doStartTag();
              if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_7.doInitBody();
                }
                do {
                  out.write("\r\n              ");
                  out.print(FormattingHelper.formatString(callDecisionData.getTxtIncmgWorkerSafety()));
                  out.write("\r\n            ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td colspan=\"2\">\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateInput_31.setLabel("Sensitive Case");
              _jspx_th_impact_validateInput_31.setName("cbxBIndCaseSensitive");
              _jspx_th_impact_validateInput_31.setType("checkbox");
              _jspx_th_impact_validateInput_31.setCssClass("formInput");
              _jspx_th_impact_validateInput_31.setChecked( sensitiveInd );
              _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_31.setValue("Y");
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td>\r\n            ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateTextArea_8.setLabel("Comments");
              _jspx_th_impact_validateTextArea_8.setName("txtTxtIncomgSensitive");
              _jspx_th_impact_validateTextArea_8.setRows("3");
              _jspx_th_impact_validateTextArea_8.setCols("77");
              _jspx_th_impact_validateTextArea_8.setConstraint("Paragraph4000");
              _jspx_th_impact_validateTextArea_8.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_8.setConditionallyRequired("true");
              _jspx_th_impact_validateTextArea_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_8.setOnChange("changeSpecHandlingComment(frmIntakeActions.txtTxtIncomgSensitive, frmIntakeActions.cbxBIndCaseSensitive);");
              int _jspx_eval_impact_validateTextArea_8 = _jspx_th_impact_validateTextArea_8.doStartTag();
              if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_8.doInitBody();
                }
                do {
                  out.write("\r\n              ");
                  out.print(FormattingHelper.formatString(callDecisionData.getTxtIncomgSensitive()));
                  out.write("\r\n            ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_8.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n\r\n\r\n\r\n      </table>\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");

      /* End Special Handling */
    
          out.write("\r\n\r\n \r\n\r\n  <br>\r\n  ");

    //*******************************************************************************
            //******************************** CALL SUMMARY  ***********************************
            //*******************************************************************************
  
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_8.setName("Summary");
          _jspx_th_impact_ExpandableSectionTag_8.setId("");
          _jspx_th_impact_ExpandableSectionTag_8.setLabel("Intake Summary");
          _jspx_th_impact_ExpandableSectionTag_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_8.setIsExpanded(true);
          _jspx_th_impact_ExpandableSectionTag_8.setAccessKey("Z");
          int _jspx_eval_impact_ExpandableSectionTag_8 = _jspx_th_impact_ExpandableSectionTag_8.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Program Area");
              _jspx_th_impact_validateDisplayOnlyField_4.setName("dspSzCdStageClassification");
              _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatString(callDecisionData.getSzCdStageClassification()) );
              int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Response Time");
              _jspx_th_impact_validateDisplayOnlyField_5.setName("dspSzCdStageCurrPriority");
              _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString(callDecisionData.getSzCdStageCurrPriority()) );
              int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Status");
              _jspx_th_impact_validateDisplayOnlyField_6.setName("summaryStatus");
              _jspx_th_impact_validateDisplayOnlyField_6.setValue( Lookup.simpleDecodeSafe("CINCMGST", FormattingHelper.formatString(entryInfo.getCdIncmgStatus())) );
              int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Case Name");
              _jspx_th_impact_validateDisplayOnlyField_7.setName("dspSzNmStage");
              _jspx_th_impact_validateDisplayOnlyField_7.setValue( caseName );
              int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_8.setColspan("4");
              _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Intake ID");
              _jspx_th_impact_validateDisplayOnlyField_8.setName("summaryCallID");
              _jspx_th_impact_validateDisplayOnlyField_8.setValue( FormattingHelper.formatInt(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Intake Date");
              _jspx_th_impact_validateDisplayOnlyField_9.setName("dspDtDtIncomingCall");
              _jspx_th_impact_validateDisplayOnlyField_9.setValue( FormattingHelper.formatDate(entryInfo.getDtDtIncomingCall()));
              int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Intake Time");
              _jspx_th_impact_validateDisplayOnlyField_10.setName("dspTmTmIncmgCall");
              _jspx_th_impact_validateDisplayOnlyField_10.setValue( FormattingHelper.formatString(entryInfo.getTmTmIncmgCall()));
              int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_32.setValue( jurisdiction );
              _jspx_th_impact_validateInput_32.setType("text");
              _jspx_th_impact_validateInput_32.setName("txtSzNmJurisdiction");
              _jspx_th_impact_validateInput_32.setLabel("Law Jurisdiction");
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setSize("40");
              _jspx_th_impact_validateInput_32.setMaxLength("40");
              _jspx_th_impact_validateInput_32.setConstraint("Paragraph40");
              _jspx_th_impact_validateInput_32.setConditionallyRequired("true");
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td colspan=\"3\" width=\"50%\">\r\n          Law Enforcement Involved\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateInput_33.setType("radio");
              _jspx_th_impact_validateInput_33.setLabel("Yes");
              _jspx_th_impact_validateInput_33.setId("LawEnfInvolved_Yes");
              _jspx_th_impact_validateInput_33.setName("rbLawEnfInvolved");
              _jspx_th_impact_validateInput_33.setValue("Y");
              _jspx_th_impact_validateInput_33.setCssClass("formInput");
              _jspx_th_impact_validateInput_33.setChecked( lawEnfInvolved_Yes );
              _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateInput_34.setType("radio");
              _jspx_th_impact_validateInput_34.setLabel("No");
              _jspx_th_impact_validateInput_34.setId("LawEnfInvolved_No");
              _jspx_th_impact_validateInput_34.setName("rbLawEnfInvolved");
              _jspx_th_impact_validateInput_34.setValue("N");
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setChecked( lawEnfInvolved_No );
              _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n      </tr>\r\n    </table>\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n      <tr class=\"subDetail\">\r\n        <th colspan=\"6\">\r\n          Intake Entered By\r\n        </th>\r\n      </tr>\r\n\r\n      <tr class=\"subDetail\">\r\n        <td width=\"15%\">\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Case Manager");
              _jspx_th_impact_validateDisplayOnlyField_11.setName("dspSzNmIncWkrName");
              _jspx_th_impact_validateDisplayOnlyField_11.setValue( FormattingHelper.formatString(entryInfo.getSzNmIncWkrName())  );
              int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Phone");
              _jspx_th_impact_validateDisplayOnlyField_12.setName("dspLNbrIncWkrPhone");
              _jspx_th_impact_validateDisplayOnlyField_12.setValue( FormattingHelper.formatPhone(entryInfo.getLNbrIncWkrPhone()) );
              int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Ext.");
              _jspx_th_impact_validateDisplayOnlyField_13.setName("dspLNbrIncWkrExt");
              _jspx_th_impact_validateDisplayOnlyField_13.setValue( FormattingHelper.formatString(entryInfo.getLNbrIncWkrExt()));
              int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n\r\n\r\n      <tr class=\"subDetail\">\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_14.setLabel("Case Manager ID");
              _jspx_th_impact_validateDisplayOnlyField_14.setName("dspUlIdIncomingWkr");
              _jspx_th_impact_validateDisplayOnlyField_14.setValue( FormattingHelper.formatInt(entryInfo.getUlIdIncomingWkr()));
              int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_15.setLabel("County");
              _jspx_th_impact_validateDisplayOnlyField_15.setName("dspSzCdIncomingWorkerCounty");
              _jspx_th_impact_validateDisplayOnlyField_15.setValue(workerCounty);
              int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_16.setLabel("Region#");
              _jspx_th_impact_validateDisplayOnlyField_16.setName("dspSzCdIncmgWorkerRegion");
              _jspx_th_impact_validateDisplayOnlyField_16.setValue( workerRegion);
              int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n      </tr>\r\n\r\n    </table>\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n      <tr class=\"subDetail\">\r\n        <th colspan=\"6\">\r\n          Supervisor Information\r\n        </th>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td width=\"15%\">\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_17.setLabel("Supervisor");
              _jspx_th_impact_validateDisplayOnlyField_17.setName("dspSzNmIncSupName");
              _jspx_th_impact_validateDisplayOnlyField_17.setValue( FormattingHelper.formatString(entryInfo.getSzNmIncmgSupName())  );
              int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_18.setLabel("Phone");
              _jspx_th_impact_validateDisplayOnlyField_18.setName("dspLNbrIncSupPhone");
              _jspx_th_impact_validateDisplayOnlyField_18.setValue( FormattingHelper.formatPhone(entryInfo.getSzNbrIncmgSupPhone()) );
              int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_19.setLabel("Ext.");
              _jspx_th_impact_validateDisplayOnlyField_19.setName("dspLNbrIncSupExt");
              _jspx_th_impact_validateDisplayOnlyField_19.setValue( FormattingHelper.formatString(entryInfo.getSzNbrIncmgSupExt()));
              int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateDisplayOnlyField_20.setLabel("Supervisor ID");
              _jspx_th_impact_validateDisplayOnlyField_20.setName("dspSzAddrIncWkrCity");
              _jspx_th_impact_validateDisplayOnlyField_20.setValue( FormattingHelper.formatInt(entryInfo.getUlIdIncomingSup()));
              int _jspx_eval_impact_validateDisplayOnlyField_20 = _jspx_th_impact_validateDisplayOnlyField_20.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td colspan=\"4\"></td>\r\n      </tr>\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_8.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");

    //************************************************
            //**** PAGE LEVEL BUTTONS BEING*******************
            //************************************************
  
          out.write("\r\n\r\n  <br>\r\n  <hr>\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n\r\n      <td width=\"65%\">\r\n      </td>\r\n\r\n      <td width=\"10%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSubmit");
          _jspx_th_impact_ButtonTag_5.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_5.setAlign("right");
          _jspx_th_impact_ButtonTag_5.setForm("frmIntakeActions");
          _jspx_th_impact_ButtonTag_5.setAction("/intake/IntakeActions/saveAndSubmitIntake");
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_5.setFunction("return saveAndSubmitFuction();setSpclInvPlcmntProviderConfirmed(); setRecordsCheckCompletedConfirmed();");
          _jspx_th_impact_ButtonTag_5.setDisabled( String.valueOf(approvalMode) );
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setAccessKey("B");
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n      <td width=\"5%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnSave");
          _jspx_th_impact_ButtonTag_6.setImg("btnSave");
          _jspx_th_impact_ButtonTag_6.setAlign("right");
          _jspx_th_impact_ButtonTag_6.setForm("frmIntakeActions");
          _jspx_th_impact_ButtonTag_6.setAction("/intake/IntakeActions/saveIntakeActions");
          _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_6.setAccessKey("S");
          _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_6.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_6.setFunction("return closeCallNarrative();");
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n  \r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.attachEvent('onload', showMaltreatIncareConfirmation);\r\nwindow.attachEvent('onload', showRecordsCheckConfirmation);\r\n</script>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  //************************
        //**** FORM ENDS HERE ****
        //************************

        //STGAP00009181: This form is defined to display the determination factor questions.

      out.write('\r');
      out.write('\n');
      out.write("\r\n<form name=\"frmDetFaq\" method=\"post\" action=\"/intake/IntakeActions/displayDetFaq\">\r\n  <input type=\"hidden\" name=\"hdnDetFaqType\" value=\"\" />\r\n</form>\r\n\r\n");

  //************************
        //**** FORM ENDS HERE ****
        //************************

      out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n\r\n    <td>\r\n\r\n      ");
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
          out.write("\r\n\r\n           ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Intake Narrative");
          _jspx_th_impact_document_0.setProtectDocument( !PageModeConstants.VIEW.equals(pageMode) ? false : true  );
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("callnarr");
          _jspx_th_impact_document_0.setWindowName( String.valueOf(GlobalData.getUlIdStage(request)) );
          _jspx_th_impact_document_0.setDocExists( ((ArchitectureConstants.Y).equals(request.getAttribute(IntakeConstants.NARRATIVE_EXISTS))) );
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sStage");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n\r\n  </tr>\r\n</table>\r\n\r\n\r\n<br>\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n");

  /* begin Forms and Reports  */

      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th>Forms</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n\r\n");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("edit");
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_1.setDisplayName("Intake Report");
          _jspx_th_impact_document_1.setProtectDocument(true);
          _jspx_th_impact_document_1.setDocType("cfin01o00");
          _jspx_th_impact_document_1.setDocExists(true);
          _jspx_th_impact_document_1.setOnClick("setIntakeReport();");
          int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
          if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  if ((CodesTables.CINCMGST_CLD).equals(entryInfo.getCdIncmgStatus())
              || (CodesTables.CINCMGST_SBA).equals(entryInfo.getCdIncmgStatus())) {

            //Removed from tag below - onClick="setNotificationToLe();"

          out.write("\r\n  ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_2.setDisplayName("Notification to L.E.");
          _jspx_th_impact_document_2.setProtectDocument(true);
          _jspx_th_impact_document_2.setDocType("int01o00");
          _jspx_th_impact_document_2.setDocExists(true);
          int _jspx_eval_impact_document_2 = _jspx_th_impact_document_2.doStartTag();
          if (_jspx_eval_impact_document_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
              _jspx_th_impact_documentParameter_2.setName("pStage");
              _jspx_th_impact_documentParameter_2.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_document_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  }

          out.write('\r');
          out.write('\n');

  if ((Boolean) state.getAttribute("showMRLetter", request) != null
              && (Boolean) state.getAttribute("showMRLetter", request)) {

          out.write('\r');
          out.write('\n');
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_3.setDisplayName("Mandated Reporter Letter Form");
          _jspx_th_impact_document_3.setProtectDocument( !PageModeConstants.VIEW.equals(pageMode) ? false : true  );
          _jspx_th_impact_document_3.setCheckForNewMode(false);
          _jspx_th_impact_document_3.setDocType("fim02o00");
          _jspx_th_impact_document_3.setDocExists(true);
          int _jspx_eval_impact_document_3 = _jspx_th_impact_document_3.doStartTag();
          if (_jspx_eval_impact_document_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_3);
              _jspx_th_impact_documentParameter_3.setName("pCase");
              _jspx_th_impact_documentParameter_3.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_3);
              _jspx_th_impact_documentParameter_4.setName("pStage");
              _jspx_th_impact_documentParameter_4.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                     ");
              int evalDoAfterBody = _jspx_th_impact_document_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

  }

          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n\r\n");

  /* end Forms and Reports */

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");
      out.write("\r\nfunction setIntakeReport()\r\n{\r\n  var classification = document.frmIntakeActions.selSzCdStageClassification.value;\r\n  ");
      out.write("\r\n  if (classification == null || classification == \"\")\r\n  {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_REP_CLASS_REQ));
      out.write("\");\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    document.cfin01o00.docType.value = 'cfin01o00';\r\n    return true;\r\n  }\r\n}\r\n");
      out.write("\r\n\r\n");
      out.write("\r\nfunction setNotificationToLe()\r\n{\r\n  var classification = document.frmIntakeActions.selSzCdStageClassification.value;\r\n  if (classification == null || classification == \"\")\r\n  {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_REP_CLASS_REQ));
      out.write("\");\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n      document.cfin0600.docType.value = 'int01o00';\r\n      return true;\r\n  }\r\n}\r\n");
      out.write("\r\n\r\n\r\n");
      out.write("\r\nfunction setAPSDeidentifiedReport()\r\n{\r\n  var classification = document.frmIntakeActions.selSzCdStageClassification.value;\r\n  if (classification == null || classification == \"\")\r\n  {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_REP_CLASS_REQ));
      out.write("\");\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    var startsWith = classification.substring(0, 1);\r\n    if (classification == '");
      out.print(CodesTables.CCLASS_AFC);
      out.write("')\r\n    {\r\n      document.cfin0800.docType.value = 'cfin0800';\r\n      return true;\r\n    }\r\n    else if (startsWith == 'A')  ");
      out.write("\r\n    {\r\n      ");
      out.write("\r\n      document.cfin0800.docType.value = 'cfin0700';\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      alert('You may only generate this document for Intakes with classification APS or AFC.');\r\n      return false;\r\n    }\r\n  }\r\n\r\n}\r\n\r\npreviousOnload = new String( window.onload );\r\npreviousOnload = previousOnload.substring( previousOnload.indexOf('{')+1, previousOnload.lastIndexOf('}') );\r\n\r\nwindow.onload = function ()\r\n{\r\n\r\neval(previousOnload);\r\n\r\n");
/* onLoad of the page we call toggleDeterminationFactors to display the correct
            Determination Factors and Descriptions based on what we have retrieved for Classification.
            If the user entered Special Request or I&R info on the Call Info page, the Classification
            field is disabled, so we do not want to call toggleDeterminationFactors. */
      out.write("\r\n\r\ntoggleDeterminationFactors();\r\n\r\n");
/* Since Current Priority can be modified indirectly in Edit mode by changing Initial Priority, we
             have to to disable the field using javaScript.  This way, when we want to modify the Current Priority,
             we can enable the field (which would be impossible if we had disabled the field using the custom tag disabled=""
             attribute), change the value, and re-disable it.  */
      out.write("\r\n\r\n");
if (approvalMode) {
      out.write("\r\n  document.frmIntakeActions.selSzCdStageCurrPriority.disabled = false;\r\n");
} else {
      out.write("\r\n  document.frmIntakeActions.selSzCdStageCurrPriority.disabled = true;\r\n");
}
      out.write("\r\n\r\n");
/*  We call setClosureCodeStatus here so that onLoad of the page, the Closure Code field will be correctly
            endabled or disabled based on the values for Initial Priority and the Classification Type. Note:  In setClosureCodeStatus()
            we use hdnClassificationType whose value is set in the toggleDeterminationFactors() functions called above. */
      out.write("\r\n\r\n  //setClosureCodeStatus();\r\n\r\n");
/* If 'No Factors' is checked onLoad of the page, we need to disable the corresponding factors and descriptors   */
      out.write('\r');
      out.write('\n');
if (!PageModeConstants.VIEW.equals(pageMode)) {
      out.write("\r\nif ((document.frmIntakeActions.hdnClassificationType.value == '");
      out.print(CodesTables.CCLASS_CPS);
      out.write("') &&\r\n  (document.frmIntakeActions.CPSnoFactors.checked == true))\r\n {\r\n   setCPSFactorStatus();\r\n }\r\nelse if ((document.frmIntakeActions.hdnClassificationType.value == '");
      out.print(CodesTables.CCLASS_APS);
      out.write("') &&\r\n  (document.frmIntakeActions.APSnoFactors.checked == true))\r\n{\r\n  setAPSFactorStatus();\r\n}\r\n");
}
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
//STGAP00005621: Modified code to make sure the current priority
            //is over written by initial priority only when there is no existing current
            //priority
            if (!PageModeConstants.INQUIRE.equals(pageMode)) {
      out.write("\r\n  var priority = document.frmIntakeActions.hdnInitialPriority.value;\r\n  var currPriority = document.frmIntakeActions.hdnCurrPriority.value;\r\n  index1 = document.frmIntakeActions.selSzCdStageCurrPriority.selectedIndex;\r\n  index = document.frmIntakeActions.selSzCdStageInitialPriority.selectedIndex;\r\n  updatePriorityCodesTables();\r\n\r\n  document.frmIntakeActions.selSzCdStageInitialPriority.options.value = priority;\r\n  if ( index == 0 )\r\n  {\r\n    document.frmIntakeActions.selSzCdStageInitialPriority.options[index].selected = true;\r\n    document.frmIntakeActions.selSzCdStageInitialPriority.options[index].defaultSelected = true;\r\n  }\r\n  if(index1 == 0)\r\n  {\r\n    document.frmIntakeActions.selSzCdStageCurrPriority.options[index].selected = true;\r\n    document.frmIntakeActions.selSzCdStageCurrPriority.options[index].defaultSelected = true;\r\n  }\r\n  document.frmIntakeActions.selSzCdStageCurrPriority.options.value = currPriority;\r\n  setCurrentPriority();\r\n  //setClosureCodeStatus();\r\n\r\n");
}
      out.write("\r\nsetSummaryField('selSzCdStageCurrPriority', 'dspSzCdStageCurrPriority');\r\nsetSummaryField('selSzCdStageClassification', 'dspSzCdStageClassification');\r\n\r\n\r\n}\r\n</script>\r\n\r\n");

  }

      out.write("\r\n\r\n");
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
    _jspx_th_impact_validateInput_0.setName("hdnIndex");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnClassificationType");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnIndRdBtn");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("hdnSpclInvPlcmntProviderConfirmed");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnRecordsCheckCompletedConfirmed");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_11.setType("hidden");
    _jspx_th_impact_validateInput_11.setName("hdnSaveIntakeActions");
    _jspx_th_impact_validateInput_11.setValue("true");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("hdnIsIntakeActionsDirty");
    _jspx_th_impact_validateInput_12.setValue("");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_18.setName("hdnChangeDisp");
    _jspx_th_impact_validateInput_18.setValue("false");
    int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
    if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_20(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_20.setType("hidden");
    _jspx_th_impact_validateInput_20.setName("hdnIndDelAlleg");
    _jspx_th_impact_validateInput_20.setValue("");
    int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
    if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
