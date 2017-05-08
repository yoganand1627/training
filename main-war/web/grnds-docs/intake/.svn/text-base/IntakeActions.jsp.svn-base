<%//*  JSP Name:     Intake Actions JSP
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
      //**%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD"%>

<%
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
%>

<%
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
  %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
var saveAndSubmitClicked;
var approvalClicked;
<%--
//  This function is called when the user clicks a hyperlink in the list.
--%>
function allegationListHyperlink (index)
{


  frmIntakeActions.hdnIndex.value = index;
  submitValidateForm("frmIntakeActions", "/intake/IntakeActions/displayAllegationDetail");


}
<%--
// This function is used to check the Worker Safety or Case Sensitive Checkbox if the user types in the
// associated comments field
--%>
function changeSpecHandlingComment(commentField, checkBox)
{
  frmIntakeActions.txtTxtIncmgWorkerSafety
  checkBox.checked = commentField.value != "";

}

function showMaltreatIncareConfirmation ()
{
  <%if ("Y".equals(warnSpclInvPlcmtProvider)) {%>
    saveAndSubmitClicked = '<%=StringHelper.isValid(request.getParameter("btnSubmit" + ".x"))%>';
    approvalClicked = '<%=StringHelper.isValid(request.getParameter("btnApprovalStatusFinal" + ".x"))%>';
    warnSpclInvPlcmtProvider();
  <%}%>
}

function warnSpclInvPlcmtProvider()    
{
  if ('true' == saveAndSubmitClicked) 
  {
    if(confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_ALLEG_LOC_MAL_SPCL_INV)%>" ))
    {
      document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value = 'Y';
      submitValidateForm('frmIntakeActions', '/intake/IntakeActions/saveAndSubmitIntake');
    }
  } 
  else if ('true' == approvalClicked) 
  {
    if(confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_APPRVL_ALLEG_LOC_MAL_SPCL_INV)%>" ))
    {
      document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value = 'Y';
      submitValidateForm('frmIntakeActions', '<%=action%>');
    } 
  }
}

//MR-072 
function showRecordsCheckConfirmation ()
{
  <%if ("Y".equals(warnRecordsCheckNotCompleted)) {%>
    saveAndSubmitClicked = '<%=StringHelper.isValid(request.getParameter("btnSubmit" + ".x"))%>';
    warnRecordsCheckCompleted();
  <%}%>
}

function warnRecordsCheckCompleted()    
{
  if ('true' == saveAndSubmitClicked || document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value == 'Y') 
  {
    if(confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_RECORDS_CHECK_WARN)%>" ))
    {
      document.frmIntakeActions.hdnRecordsCheckCompletedConfirmed.value = 'Y';
      submitValidateForm('frmIntakeActions', '/intake/IntakeActions/saveAndSubmitIntake');
    }else{
      submitValidateForm('frmIntakeActions', '/intake/IntakeActions/displayIntakeActions');     
    }
  } 
}

function changeDisposition()
{

    var disposVal =    eval("document.frmIntakeActions.selSzCdDisp.value");


    if("<%=bResourceSearch%>"== "false" && (disposVal =="<%=CodesTables.CDISP_SCR%>" || disposVal =="<%=CodesTables.CDISP_SCO%>"))
    {
     disableValidation("frmIntakeActions");
   document.frmIntakeActions.hdnChangeDisp.value=true;
     submitValidateForm("frmIntakeActions", "/intake/IntakeActions/displayIntakeActions");
    }else if("<%=bResourceSearch%>"== "true" && disposVal != "<%=CodesTables.CDISP_SCR%>" && disposVal != "<%=CodesTables.CDISP_SCO%>" )
    {
     disableValidation("frmIntakeActions");
   document.frmIntakeActions.hdnChangeDisp.value=true;
     submitValidateForm("frmIntakeActions", "/intake/IntakeActions/displayIntakeActions");

    }



 }
<%--
// This function is called onClick of all the Save buttons. It will not allow
// the user to Save && Whatever an Intake if the Call Narrative is open and has
// not been saved recently.  If the Narrative is open but has been changed, the
// function will simply close the Narrative.
--%>
function closeCallNarrative()
{

  var narrativeWindow =
    window.open('',
                '<%=GlobalData.getUlIdStage(request)%>',
                'toolbar=no,menubar=no,width=5,height=5');
  if (narrativeWindow.isDirty)
  {
    alert('Please save the Call Narrative before proceeding.');
    return false;
  }
  else
  {
    narrativeWindow.close();

    return true;
  }

}

<%--
// This function is called when the user clicks the Save and Submit button.  It first
// checks to see whether the Narrative has been saved, and then it prompts the user
// to perform person searches if they have not already been performed.
--%>
function saveAndSubmitFuction()
{

  var retVal = true;
  retVal = closeCallNarrative();



  if (retVal)
  {
   retVal = promptPersonSearch();
  }

  
  return retVal;

}

function setSpclInvPlcmntProviderConfirmed()
{
  document.frmIntakeActions.hdnSpclInvPlcmntProviderConfirmed.value = 'N';
}

function setRecordsCheckCompletedConfirmed()
{
  document.frmIntakeActions.hdnRecordsCheckCompletedConfirmed.value = 'N';
}
<%--
// This function is called when the user clicks the Save and Assign button.  It first
// checks to see whether the Narrative has been saved, and then it prompts the user
// to perform person searches if they have not already been performed.
--%>
function saveAndAssignFunction()
{

  var retVal = true;
  retVal = closeCallNarrative();
  if (retVal)
  {
   retVal = promptPersonSearch();
  }
  return retVal;

}
<%--
// This function is used to determing which Determinations Factors, if any, should be visible
// based on what type of Classification is selected.
--%>
function toggleDeterminationFactors()
{

<%if (PageModeConstants.VIEW.equals(pageMode)) {%>
  var classification = document.frmIntakeActions.selSzCdStageClassification.value;
  <%} else {%>
    var classification = document.frmIntakeActions.selSzCdStageClassification.options.value;
  <%}%>

  if ((classification == "<%=CodesTables.CCLASS_AFC%>") ||
       (classification == "<%=CodesTables.CCLASS_AOA%>") ||
       (classification == "<%=CodesTables.CCLASS_AOS%>") ||
       (classification == "<%=CodesTables.CCLASS_APS%>"))
         {
    expandCollapsed('APSfactors', 'CPSfactors');
    document.frmIntakeActions.hdnClassificationType.value = '<%=CodesTables.CCLASS_APS%>';
  }
  else
  {
    if ((classification == ""))
    {
      toggleVisibility('APSfactors', 'none');
      toggleVisibility('CPSfactors', 'none');
      document.frmIntakeActions.hdnClassificationType.value = '';
    }
    else
    {
      expandCollapsed('CPSfactors', 'APSfactors');
      document.frmIntakeActions.hdnClassificationType.value = '<%=CodesTables.CCLASS_CPS%>';
    }
  }

}
<%--
// This function takes in two parameters - the name of a field in the Summary Section and
// the value set in the corresponding field on Call Decision.  It will set the read only
// field equal to what was selected in Call Decision.
--%>
function setSummaryField(decisionValue, summaryField)
{

  var value = eval("document.frmIntakeActions." + decisionValue + ".value");
  var spanID = summaryField + "_id";
  var sp = document.getElementById(spanID);
  sp.innerText = value;

}

function setSmryCaseField(decisionValue, summaryField)
{

  var value = eval("document.frmIntakeActions." + decisionValue + ".value");
  value = value.substr( 0, value.indexOf("|") );
  var spanID = summaryField + "_id";
  var sp = document.getElementById(spanID);
  sp.innerText = value;

}
<%--
//  In EDIT mode the Initial Priority is used to set the read only field Current Priority.
// This javascript function is called onCHange of Initial Priority to update the Current Priority field.
--%>
//STGAP00005621: Modified this function to make sure the current priority
//is over written by initial priority only when there is no existing current
//priority
function setCurrentPriority()
{
    var value = eval("document.frmIntakeActions.selSzCdStageInitialPriority.value");
    var currValue = eval("document.frmIntakeActions.selSzCdStageCurrPriority.value");
    var disabled = eval("document.frmIntakeActions.selSzCdStageCurrPriority.disabled");
    if (disabled)
    {
      document.frmIntakeActions.selSzCdStageCurrPriority.disabled = false;
    }
    if(currValue == null || currValue == ""){
    document.frmIntakeActions.selSzCdStageCurrPriority.value = value;
    var sp = document.getElementById("dspSzCdStageCurrPriority_id");
    sp.innerText = value;
    document.frmIntakeActions.hdnCurrPriority.value = value;
    }else{
    document.frmIntakeActions.selSzCdStageCurrPriority.value = currValue;
    var sp = document.getElementById("dspSzCdStageCurrPriority_id");
    sp.innerText = currValue;
    document.frmIntakeActions.hdnCurrPriority.value = currValue;
    }
    if (disabled)
    {
      document.frmIntakeActions.selSzCdStageCurrPriority.disabled = true;
    }
    document.frmIntakeActions.hdnInitialPriority.value = value;

}
<%--
// This javascript function is called onChange of Classification and updates the Current and Initial Priority
// codes table depednig on what overall classification is picked.
--%>
<impact:codeArray codeName="<%=CodesTables.CAPSPRTY%>" arrayName="apsPriorities" blankValue="true"/>
<impact:codeArray codeName="<%=CodesTables.CPRIORTY%>" arrayName="cpsPriorities" blankValue="true"/>
  function updatePriorityCodesTables()
{

  var classification = document.frmIntakeActions.hdnClassificationType.value;
  if (classification == "<%=CodesTables.CPGRMSFM_APS%>")
  {
    populateDropdown(frmIntakeActions.selSzCdStageCurrPriority, "", apsPriorities);
    populateDropdown(frmIntakeActions.selSzCdStageInitialPriority, "", apsPriorities);
  }

 else
  {
   populateDropdown(frmIntakeActions.selSzCdStageCurrPriority, document.frmIntakeActions.selSzCdStageCurrPriority.value, cpsPriorities);
   populateDropdown(frmIntakeActions.selSzCdStageInitialPriority, "", cpsPriorities);
  }

}
<%--

// This function disables or enables the CPS Determination factors depending on the status of the
// "No Factors" checkbox.
--%>
function setCPSFactorStatus()
{

  var noFactorsChecked = document.frmIntakeActions.CPSnoFactors;  <%--// No Factors Checkbox --%>
  <%--//  If the user is attempting to check the checkbox disable and clear all the determination factors and descriptors --%>
  if (noFactorsChecked.checked == true)
  {
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CPHYABSE)).size()%>; i++)
    {
      var cbx1 = eval("document.frmIntakeActions.CPSdeterminationFactorsPA" +i); <%-- // Checkbox i --%>
      cbx1.disabled = true;
      cbx1.checked = false;
    }

    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CNEGLECT)).size()%>; i++)
    {
      var cbx1 = eval("document.frmIntakeActions.CPSdeterminationFactorsNEG" +i); <%-- // Checkbox i --%>
      cbx1.disabled = true;
      cbx1.checked = false;
    }
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CEMLABSE)).size()%>; i++)
    {
      var cbx1 = eval("document.frmIntakeActions.CPSdeterminationFactorsEA" +i); <%-- // Checkbox i --%>
      cbx1.disabled = true;
      cbx1.checked = false;
    }
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CSEXABSE)).size()%>; i++)
    {
      var cbx1 = eval("document.frmIntakeActions.CPSdeterminationFactorsSA" +i); <%-- // Checkbox i --%>
      cbx1.disabled = true;
      cbx1.checked = false;
    }
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.COTHER)).size()%>; i++)
    {
      var cbx1 = eval("document.frmIntakeActions.CPSdeterminationFactorsOTH" +i); <%-- // Checkbox i --%>
      cbx1.disabled = true;
      cbx1.checked = false;
    }


    for (j = 1; j <= <%=CPSDescrValues.size()%>; j++)
    {
      var cbx2 = eval("document.frmIntakeActions.cpsDescriptors" +j);  <%-- // Checkbox i --%>
      cbx2.disabled = true;
      cbx2.checked = false;
    }
  }
  else
  {


    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CPHYABSE)).size()%>; i++)
    {
      var cbx3 = eval("document.frmIntakeActions.CPSdeterminationFactorsPA" +i); <%-- // Checkbox i --%>
      cbx3.disabled = false;
    }

    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CNEGLECT)).size()%>; i++)
    {
      var cbx3 = eval("document.frmIntakeActions.CPSdeterminationFactorsNEG" +i); <%-- // Checkbox i --%>
     cbx3.disabled = false;
    }
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CEMLABSE)).size()%>; i++)
    {
      var cbx3 = eval("document.frmIntakeActions.CPSdeterminationFactorsEA" +i); <%-- // Checkbox i --%>
      cbx3.disabled = false;
    }
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CSEXABSE)).size()%>; i++)
    {
      var cbx3 = eval("document.frmIntakeActions.CPSdeterminationFactorsSA" +i); <%-- // Checkbox i --%>
     cbx3.disabled = false;
    }
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.COTHER)).size()%>; i++)
    {
      var cbx3 = eval("document.frmIntakeActions.CPSdeterminationFactorsOTH" +i); <%-- // Checkbox i --%>
      cbx3.disabled = false;
    }


    for (j = 1; j <= <%=CPSDescrValues.size()%>; j++)
    {
      var cbx4 = eval("document.frmIntakeActions.cpsDescriptors" +j);  <%-- // Checkbox i --%>
      cbx4.disabled = false;
    }
  }

}
<%--
// This function disables or enables the APS Determination factors depending on the status of the
// "No Factors" checkbox.
--%>
function setAPSFactorStatus()
{

  var noFactorsChecked = document.frmIntakeActions.APSnoFactors;  <%-- // No Factors Checkbox --%>
  <%-- //  If the user is attempting to check the checkbox disable and clear all the determination factors and descriptors --%>
  if (noFactorsChecked.checked == true)
  {
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CADETFCT)).size()%>; i++)
    {
      var cbx1 = eval("document.frmIntakeActions.APSdeterminationFactors" +i); <%-- // Checkbox i --%>
      cbx1.disabled = true;
      cbx1.checked = false;
    }
  }
  else
  {
    for (i = 1; i <= <%=(Lookup.getCategoryCollection(CodesTables.CADETFCT)).size()%>; i++)
    {
      var cbx3 = eval("document.frmIntakeActions.APSdeterminationFactors" +i); <%-- // Checkbox i --%>
      cbx3.disabled = false;
    }
  }

}

<%--
// This function is called when the user clicks any of the "Save &&" buttons.  In the display method for
// intake actions the person list is iterated through and if any principals are found that have not
// had a person search performed for the promptPersonSearch indicator is set into the request as true.
--%>
function promptPersonSearch()
{

  <%--//  If the promptPersonSearch indicator was set into the request in the display method, prompt the user on Save and Submit, etc. --%>
  if (<%=("true"
                               .equals(StringHelper
                                                   .getNonNullString((String) request
                                                                                     .getAttribute("promptPersonSearch"))))%>)
  {
    var save = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_SRCH_PRINC)%>');
    if (save == true)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
<%--
  // If the promptPersonSearch indicator is null or false, this function needs to return true since the
  // custom tag is expecting the promptPersonSearch() function to return a value.
--%>
  else
  {
    return true;
  }

}

<%--// This function is called onChange of the Classification field and contains calls to various other javascript functions.--%>
function changeClassificationFunctions(selSzCdStageClassification, dspSzCdStageClassification)
{

  toggleDeterminationFactors();
  setSummaryField(selSzCdStageClassification, dspSzCdStageClassification);


}

<%--
// This function is called onChange of the Classification field.  If the user selects AFC and there
// is more than one victim we want to append the option array that include the et al entries.

//<impact:codeArray options="<%= caseNameVector %>" arrayName="caseNameVector" blankValue="true"/>
//<impact:codeArray options="<%= caseNameEtAlVector %>" arrayName="caseNameEtAlVector" blankValue="true"/>
--%>

function populateCaseDropdown(field, val, cat)
{

  <%-- //sets the drop-down box to the length of the array --%>
  field.options.length = cat.length;
  for (var q=0; q < cat.length; q++)
  {
    <%-- //populates the drop-down box with the values from the CodeDecodeCache --%>
    field.options[q].value = cat[q].substring(0, cat[q].lastIndexOf("|"));
    field.options[q].text = cat[q].substring(cat[q].lastIndexOf("|")+1,cat[q].length);
  }
  field.value = val;

}



//}
<%--
// This function is called when the user leaves the Intake Actions page.  It sets the value of the hidden
// field hdnIsIntakeActionsDirty to the return of the isPageChanged() function.  The value of this hidden field is used in the
// Call Info and Call Log display.  If hdnIsIntakeActionsDirty == true the Intake Actions Save is called.
// We also  have to check to see if the last action the user performed was a Resource Search.
// If that is the case, we always want to save since populating the Law Jurisdiction section using the
// Resource Search will not set the page to dirty.
--%>
window.attachEvent('onbeforeunload', navAway);
function navAway()
{
  document.frmIntakeActions.hdnIsIntakeActionsDirty.value = isPageChanged();
  if (document.frmIntakeActions.hdnResourceSearch.value == "true")
  {
    document.frmIntakeActions.hdnIsIntakeActionsDirty.value = "true";
  }
}

function deleteAllegationConfirm()
{
  <%--// SIR 22442--%>
  navAway();
  <%--// end sir 22442--%>
  return confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>');
}
<%--//STGAP00009181: This function displays a confirmation message if the control is coming back from delete 
allegation method in the conversation because that is the last allegtion of that type --%>
window.attachEvent('onload', checkIndAllegList);
function checkIndAllegList()
{
   var indDelList = '<%=(String) request.getAttribute("hdnIndDelAlleg") == null ? ""
                                                                                  : (String) request
                                                                                                    .getAttribute("hdnIndDelAlleg")%>';
  if (indDelList == 'Y')
  {
    var save = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_ALLEG_DEL_CNFRM)%>');
    if (save == true)
    {
      document.frmIntakeActions.hdnIndDelAlleg.value = 'N';
      document.frmIntakeActions.hdnIsIntakeActionsDirty.value = true;
      document.frmIntakeActions.hdnIndRdBtn.value = '<%=(Integer) request.getAttribute("rbAllegList") == null ? 0
                                                                                : (Integer) request
                                                                                                   .getAttribute("rbAllegList")%>'
      submitValidateForm("frmIntakeActions", "/intake/IntakeActions/deleteAllegationFromList");
    }
  }
}
 <%--//STGAP00009181:Defined this function to call the Determination Factors questions window
//-- this function called when clicking on Determination Factor Questions --%>
function callDetermFaqFormSubmit(detFaqType) {
  frmDetFaq.hdnDetFaqType.value=detFaqType;
  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=600,height=350');
  frmDetFaq.target = "txtWin";
  if( window.focus ) {
    errorList.focus();
  }
  frmDetFaq.submit();
}

function displayWindowParameters() {
  var descriptor = "";
  descriptor += "width=700,";
  descriptor += "height=475,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=0,";
  descriptor += "fullscreen=0,";
  descriptor += "location=0,";
  descriptor += "menubar=0,";
  descriptor += "resizable=0,";
  descriptor += "scrollbars=1,";
  descriptor += "status=0,";
  descriptor += "toolbar=0"; 
}

function displayMICHelp(helpTopic) {
var topic = helpTopic;
 var descriptor = "";
  descriptor += "width=450,";
  descriptor += "height=350,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=1,";
  descriptor += "fullscreen=0,";
  descriptor += "location=1,";
  descriptor += "menubar=0,";
  descriptor += "resizable=1,";
  descriptor += "scrollbars=1,";
  descriptor += "status=1,";
  descriptor += "toolbar=0";
  if(helpTopic != "")
   return window.open('/intake/IntakeActions/displayMICHelp'+'#'+topic, "", descriptor);
}

</script>
<impact:validateErrors />

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <a tabIndex="<%=tabIndex++%>" href="#" onClick="expandAll();">Expand All</a>&nbsp; <a tabIndex="<%=tabIndex++%>" href="#" onClick="collapseAll();">Collapse All</a>&nbsp;
    </td>

  </tr>
</table>

<impact:validateForm name="frmIntakeActions" method="post" action="/intake/IntakeActions/displayIntakeActions" pageMode="<%= pageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeActionsCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

  <%-- //only display table if either the button or link are showing --%>

  <%
    /* hdnIndex is used to get the selected row from the allegation list array when a hyperlink is clicked.
             The javaScript function called when the user clicks the hyperlink sets the value for hdnIndex. */
  %>
  <impact:validateInput type="hidden" name="hdnIndex" value="" />
  <%
    /* hdnClassificationType is used to hold the classification type that is figured out in
             toggleDeterminationFactors. */
  %>
  <impact:validateInput type="hidden" name="hdnClassificationType" value="" />
  <%
    /* hdnCurrPriority is used to hold the value of Current Priority when the page is not in Approve Mode.  Current Priority
             is only enabled in Approve mode, but is modified and needs to be submitted in Edit mode also.  */
  %>
  <impact:validateInput type="hidden" name="hdnCurrPriority" value="<%= callDecisionData.getSzCdStageCurrPriority() %>" />
  <%
    /* This hidden field contains values from the Call Entry object and is used in the Custom Validation.
             Instead of passing in the entire Call Entry object, we just set them into hidden fields.        */
  %>
  <impact:validateInput type="hidden" name="hdnSzCdIncomingDisposition" value="<%= entryInfo.getSzCdIncomingDisposition() %>" />
  <impact:validateInput type="hidden" name="hdnSzCdNonIncReqType" value="<%= entryInfo.getCdIncomingProgramType() %>" />
  <impact:validateInput type="hidden" name="hdnSzCdSplInvest" value="<%= entryInfo.getSzCdSpclInvstgtn() %>" />
  <impact:validateInput type="hidden" name="hdnTsIncmgCallDisp" value="<%=  FormattingHelper.formatDate( entryInfo.getTsIncmgCallDisp() ) %>" />
  <impact:validateInput type="hidden" name="hdnIndRdBtn" value="" />
  <impact:validateInput type="hidden" name="hdnSpclInvPlcmntProviderConfirmed" value="" />
  <impact:validateInput type="hidden" name="hdnRecordsCheckCompletedConfirmed" value="" />
  <impact:validateInput type="hidden" name="hdnIndTrialHomeVisit" value="<%= callEntryData.getCIndTrialHomeVisit() %>" />
  <%
    /* It was decided that clicking on any of the 2nd level Intake tabs should autosave the current page before displaying the
             next page.  We use the hdnSavePageName field as an indicator to the next conversation to save the Call Information
             page before displaying.  For instance, if the user is on Call Info and clicks the Call Log tab, the Call Log display method
             will check to see if the hdnSaveCallInformation indicator is in the request and equal to true, and if so will call the
             Call Information save before displaying the Call Log page. This will work when navigating from Intake Actions to Call Info,
             from Call Info to Intake Actions, from Intake Actions to Call Log, and from Call Info to Call Log. */
  %>
  <%
    if (!PageModeConstants.VIEW.equals(pageMode)) {
  %>
  <impact:validateInput type="hidden" name="hdnSaveIntakeActions" value="true" />
  <%
    }
  %>
  <%
    /* The hdnIsIntakeActionsDirty field is used by the Call Information and Call Log pages to determine if any changes were
             made on the Intake Actions page and whether to call the Intake Actions Save.*/
  %>
  <impact:validateInput type="hidden" name="hdnIsIntakeActionsDirty" value="" />

  <%
    /* The hidden value incomingStatus is used on the Allegation Detail page.  If the user enters the intake
             in approval mode and they are NOT the approver, if the user saves the Allegation Detail page, we should
             invalidate the pending approval.  The allegation_AUD() method uses the value for hdnIncomingStatus
             to determine whether we should invalidate the pending approval or not.  */
  %>
  <impact:validateInput type="hidden" name="hdnIncomingStatus" value="<%= entryInfo.getCdIncmgStatus() %>" />
  <%
    /* The hdnResourceSearch field is set when the user returns from a Resource Search.  Since we set
             the retrieved resource info into the facility detail object in state before the page is loaded,
             our save method did not register a change in Law Jurisdiction.  In the save method we check to
             see if the data has been changed since the page loaded OR if this indicator is true.  */
  %>
  <%
    String resourceSearch = (String) request.getAttribute("resourceSearch");
  %>
  <%
    String hdnResourceId = (String) request.getAttribute("jurisdictionResourceId");
  %>
  <%
    String refferedResourceId = (String) request.getAttribute("refferedResourceId");
  %>
  <%
    String serviceProviderName = (String) request.getAttribute("serviceProviderName");
  %>
  <%
    String typeOfService = (String) request.getAttribute("typeOfService");
  %>
  <impact:validateInput type="hidden" name="hdnResourceSearch" value="<%= resourceSearch %>" />
  <impact:validateInput type="hidden" name="hdnResourceId" value="<%= hdnResourceId %>" />
  <impact:validateInput type="hidden" name="hdnInitialPriority" value="<%= callDecisionData.getSzCdStageInitialPriority() %>" />
  <impact:validateInput type="hidden" name="hdnCaseName" value="<%= caseName %>" />
  <impact:validateInput type="hidden" name="hdnChangeDisp" value="false" />
  <impact:validateInput type="hidden" name="hdnbResourceSearch" value="<%=String.valueOf(bResourceSearch) %>"/>
  <impact:validateInput type="hidden" name="hdnIndDelAlleg" value="" />

  <%
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
  %>


  <impact:validateInput type="hidden" name="hdnRefferedResourceId" value="<%= FormattingHelper.formatInt(callDecisionData.getUlIdRefferedResource())%>" />


  <%
    //*******************************************************************************
            //******************************** APPROVAL STATUS  ***********************************
            //*******************************************************************************
  %>
  

  <impact:ifThen test="<%=
                        ((Boolean.valueOf(disableApprovalStatus) == false) ||
                         (GlobalData.getUlIdCase(request) != 0))
                     %>">
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr>
        <td align="left">
          <impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmIntakeActions" action="<%=action%>" navAwayCk="true" disabled="<%=disableApprovalStatus%>" editableMode='<%= EditableMode.ALL %>' tabIndex="<%=tabIndex%>" />
        </td>
        <%
          // If there is a case id in global data, we want to give the user the option to navigate back
                    // back to the Case Summary page.  This becomes important when the user is reviewing an Intake
                    // from an Investigation stage and would like to return to Case Summary page.
                    //The validations for the IntakeActions are disabled after clicking the Return To Case Summary hyperlink.
                    if (GlobalData.getUlIdCase(request) != 0) {
        %>

        <td align="right">
          <a href="javascript:disableValidation('frmIntakeActions');submitValidateForm('frmIntakeActions', '/workload/CaseSummary/displayCaseSummary')">Return to Case Summary</a>
          <br>
        </td>
        <%
          }
        %>

    </table>
  </impact:ifThen>
  <%
    //*******************************************************************************
            //******************************** ALLEGATION  ***********************************
            //*******************************************************************************
  %>
  <impact:ExpandableSectionTag name="Allegation" id="" label="Allegation" tabIndex="<%= tabIndex++ %>" isExpanded="true" accessKey="T">
    <%
      /* This outer table is here to set the background color to white  */
    %>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr>
        <td>
          <div id="scrollBar2" style="height:130px;width:763px;overflow:auto" class="tableborderList">
            <table width="100%" cellspacing="0" cellpadding="2" border="0">
              <tr class="subDetail">
                <!-- <th class="thList">Alleged Perpetrator</th> -->
                <TH class="thList">
                  &nbsp;
                </TH>
                <TH class="thList">
                  Allegation
                </TH>
                <TH class="thList">
                  Alleged Victim
                </TH>

              </tr>
              <%
                loopCount = 0;
                          allegListEnum = allegListArray.enumerateROWCINT76DO();
                          if (allegListEnum == null || !(allegListEnum.hasMoreElements())) {
              %>
              <tr class="odd">
                <td>
                  &nbsp;
                </td>
                <td colspan="3">
                  <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                </td>
              </tr>
              <%
                } else {
                            while (allegListEnum.hasMoreElements()) {
                              allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
                              String radioId = "rbAllegList_" + loopCount;
              %>
              <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">

                <td>
                  <impact:validateInput type="radio" id="<%= radioId %>" tabIndex="<%= tabIndex++ %>" name="rbAllegList" value="<%= String.valueOf(loopCount) %>" />
                </td>

                <td>                 
                  <%
                                     {
                                   %>
                  <a href="javascript:disableValidation('frmIntakeActions');allegationListHyperlink('<%=loopCount%>');" onClick="setIsDirtyCalled(true); window.onBeforeUnload=null;" tabIndex="<%=tabIndex++%>"> <%=allegListRow.getSzCdIntakeAllegMalCode()%></a>
                  <%
                    }
                  %>
                </td>
                <td>
                  <%=allegListRow.getSzScrPersVictim()%>
                </td>

              </tr>
              <%
                loopCount++;
                            }
                          }
              %>
            </table>
          </div>
        </td>
      </tr>
    </table>
    <table border="0" cellpadding="3" cellspacing="0" width="100%">
      <tr>
      <%
        String disableAllegationDeleteAndCopy = "true";
                  // STGAP00010576, only display copy and add buttons if
                  // an Allegation exist.
                  if (allegListArray != null) {
                    if (allegListArray.getROWCINT76DO() != null && allegListArray.getROWCINT76DOCount() > 0) {
                      disableAllegationDeleteAndCopy = "false";
                    }
                  }
      %>      
     <impact:ifThen test="<%=
                        ((Boolean.valueOf(disableAllegationDeleteAndCopy) == false))%>">        
        <td width="85%">
          <impact:ButtonTag name="btnDeleteFromList" img="btnDelete" align="left" form="frmIntakeActions" action="/intake/IntakeActions/deleteAllegationFromList" function="return deleteAllegationConfirm();" tabIndex="<%= tabIndex++ %>" accessKey="D"
            restrictRepost="true" />
        </td>
        <td width="10%">
          <impact:ButtonTag name="btnNewUsingAlleg" img="btnNewUsing" align="left" form="frmIntakeActions" action="/intake/IntakeActions/displayAllegationDetail" tabIndex="<%= tabIndex++ %>" accessKey="U" />
        </td>
     </impact:ifThen> 
        <td width="5%">
          <impact:ButtonTag name="btnAdd" img="btnAdd" align="left" form="frmIntakeActions" action="/intake/IntakeActions/displayAllegationDetail" tabIndex="<%= tabIndex++ %>" accessKey="N" />
        </td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>
  <br>
  <%
    //*******************************************************************************
            //******************************** CALL DECISION ***********************************
            //*******************************************************************************
  %>
  <impact:ExpandableSectionTag name="Decision" id="dspDtLicngInvstIntake" label="Intake Decision" tabIndex="<%= tabIndex++ %>" isExpanded="true" accessKey="Q">

    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
      <tr class="subDetail">
        <td width="15%">
          <impact:validateDisplayOnlyField name="dspDtLicngInvstIntake" label="Intake ID" value="<%= FormattingHelper.formatInt(GlobalData.getUlIdStage(request))%>" />
        </td>
        <%
          // If the user marked the Intake as a SPC on Call Information, we want to initialize the Classification to SPC.
                    // If the user marked the Intake as an I&R, we initialize to I&R.  Else we just want to use whatever is retrieved from
                    // the database.  If the Intake is an SPC (NCRSR or CRSR) or an I&R or we are in APPROVE mode, we also disable Classification.
                    String classValue = classValue = callDecisionData.getSzCdStageClassification() != null ? callDecisionData
                                                                                                                             .getSzCdStageClassification()
                                                                                                          : StringHelper.EMPTY_STRING;
                    boolean disableClass = false;
        %>
        <td>
          <impact:validateSelect label="Program Area" onChange="changeClassificationFunctions('selSzCdStageClassification', 'dspSzCdStageClassification');" name="selSzCdStageClassification" tabIndex="<%= tabIndex++ %>" codesTable="<%= CodesTables.CCLASS %>"
            value="<%= classValue %>" disabled="<%= String.valueOf(disableClass) %>" />
        </td>

      </tr>
      <tr class="subDetail">

        <td>
          <impact:validateDisplayOnlyField colspan="4" label="Case Name" name="dspCaseName" value="<%= caseName %>" />
        </td>

      </tr>
    </table>
 </impact:ExpandableSectionTag>
    <div id="CPSfactors" style="Display: none">
      <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
        <tr class="subDetail">
          <th colspan="6">
            CPS
          </th>
        </tr>
        <tr class="subDetail">
          <td colspan="6">
            <impact:validateInput label="No Factors" type="checkbox" value="Y" checked="<%= checkNoFactors %>" name="CPSnoFactors" tabIndex="<%= tabIndex++ %>" onClick="setCPSFactorStatus()" />
          </td>
        </tr>
</table>
<br>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr>
      <th>Determination Factors:</th>
    </tr>
<tr>
<td>
<div id="PhysicalAbuse" style="Display: <%=showPhysAbuse%>">
<br>
<impact:ExpandableSectionTag
  name="Physical Abuse"
  id=""
  label="Physical Abuse"
  tabIndex="<%= tabIndex++ %>">
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
        <tr class="subDetail">
          <td colspan="6">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr class="subDetail">
                <td>
                  <impact:codesCheckbox defaultCodes="<%= CPScheckedValuesPA %>" name="CPSdeterminationFactorsPA" codesTableName="<%= CodesTables.CPHYABSE %>" columns="3" isHorizontal="true" tabIndex="<%= tabIndex++ %>" />
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td>                 
             <a name="DetFaq_pp" href="#DetFaq_pp" onClick = "callDetermFaqFormSubmit('PP')">Determination Factors questions </a>
          </td>
        </tr>
        <tr>
          <td>
             <impact:validateTextArea colspan="5" name="txtSzTxtPhyAbsCmnts" rows="5" cols="145" tabIndex="<%= tabIndex++ %>" maxLength="4000" disabled="false" constraint="Paragraph4000">
             <%=FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtPhyAbsCmnts())%>
             </impact:validateTextArea>
          </td>
        </tr>
</table>
</impact:ExpandableSectionTag>
</div>
<div id="Neglect" style="Display:  <%=showNeglect%>">
<br>
<impact:ExpandableSectionTag
  name="Neglect"
  id=""
  label="Neglect"
  tabIndex="<%= tabIndex++ %>">
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
        <tr class="subDetail">
          <td colspan="6">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr class="subDetail">
                <td>
                  <impact:codesCheckbox defaultCodes="<%= CPScheckedValuesNEG %>" name="CPSdeterminationFactorsNEG" codesTableName="<%= CodesTables.CNEGLECT %>" columns="3" isHorizontal="true" tabIndex="<%= tabIndex++ %>" />
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td>                 
             <a name="DetFaq_nn" href="#DetFaq_nn" onClick = "callDetermFaqFormSubmit('NN')">Determination Factors questions </a>
          </td>
        </tr>
        <tr>
          <td>
             <impact:validateTextArea colspan="5" name="txtSzTxtNegAbsCmnts" rows="5" cols="145" tabIndex="<%= tabIndex++ %>" maxLength="4000" disabled="false" constraint="Paragraph4000">
             <%=FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtNegAbsCmnts())%>
             </impact:validateTextArea>
          </td>
        </tr>
</table>
</impact:ExpandableSectionTag>
</div>
<div id="EmotionalAbuse" style="Display:  <%=showEmtAbuse%>">
<br>
<impact:ExpandableSectionTag
  name="Emotional Abuse"
  id=""
  label="Emotional Abuse"
  tabIndex="<%= tabIndex++ %>">
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
        <tr class="subDetail">
          <td colspan="6">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr class="subDetail">
                <td>
                  <impact:codesCheckbox defaultCodes="<%= CPScheckedValuesEA %>" name="CPSdeterminationFactorsEA" codesTableName="<%= CodesTables.CEMLABSE %>" columns="3" isHorizontal="true" tabIndex="<%= tabIndex++ %>" />
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td>                 
             <a name="DetFaq_ee" href="#DetFaq_ee" onClick = "callDetermFaqFormSubmit('EE')">Determination Factors questions </a>
          </td>
        </tr>
        <tr>
          <td>
             <impact:validateTextArea colspan="5" name="txtSzTxtEmAbsCmnts" rows="5" cols="145" tabIndex="<%= tabIndex++ %>" maxLength="4000" disabled="false" constraint="Paragraph4000">
             <%=FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtEmAbsCmnts())%>
             </impact:validateTextArea>
          </td>
        </tr>
</table>
</impact:ExpandableSectionTag>
</div>
<div id="SexualAbuse" style="Display:  <%=showSexAbuse%>">
<br>
<impact:ExpandableSectionTag
  name="Sexual Abuse"
  id=""
  label="Sexual Abuse"
  tabIndex="<%= tabIndex++ %>">
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
        <tr class="subDetail">
          <td colspan="6">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr class="subDetail">
                <td>
                  <impact:codesCheckbox defaultCodes="<%= CPScheckedValuesSA %>" name="CPSdeterminationFactorsSA" codesTableName="<%= CodesTables.CSEXABSE %>" columns="3" isHorizontal="true" tabIndex="<%= tabIndex++ %>" />
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td>                 
             <a name="DetFaq_ss" href="#DetFaq_ss" onClick = "callDetermFaqFormSubmit('SS')">Determination Factors questions </a>
          </td>
        </tr>
        <tr>
          <td>
             <impact:validateTextArea colspan="5" name="txtSzTxtSxAbsCmnts" rows="5" cols="145" tabIndex="<%= tabIndex++ %>" maxLength="4000" disabled="false" constraint="Paragraph4000">
             <%=FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtSxAbsCmnts())%>
             </impact:validateTextArea>
          </td>
        </tr>
       </table>
</impact:ExpandableSectionTag>
</div>
<div id="SpecialCircumstances" style="Display:  <%=showSplHandling%>">
<br>
<impact:ExpandableSectionTag
  name="Special Circumstances"
  id=""
  label="Special Circumstances"
  tabIndex="<%= tabIndex++ %>">
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
        <tr class="subDetail">
          <td colspan="6">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr class="subDetail">
                <td>
                  <impact:codesCheckbox defaultCodes="<%= CPScheckedValuesOTH %>" name="CPSdeterminationFactorsOTH" codesTableName="<%= CodesTables.COTHER %>" columns="3" isHorizontal="true" tabIndex="<%= tabIndex++ %>" />
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td>
             <span class="formCondRequiredText">&#135;</span>Comments:
          </td>
        <tr>
          <td>
             <impact:validateTextArea colspan="5" name="txtSzTxtOthCmnts" rows="5" cols="145" tabIndex="<%= tabIndex++ %>" maxLength="4000" disabled="false" constraint="Paragraph4000">
             <%=FormattingHelper.formatString(determCmntsAUD.getTxtSzTxtOthCmnts())%>
             </impact:validateTextArea>
          </td>
        </tr>
        <tr class="subDetail">
          <%-- <th colspan="6">
            Determination Descriptors
          </th>  --%>

        </tr>
        <tr class="subDetail">
          <td colspan="6">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr class="subDetail">
                <td>
                  <impact:listCheckbox defaultCodes="<%= CPSDescrCheckedValues %>" name="cpsDescriptors" codesList="<%= CPSDescrValues %>" columns="3" isHorizontal="true" tabIndex="<%= tabIndex++ %>" />
                </td>
              </tr>
            </table>
          </td>
        </tr>
</table>
</impact:ExpandableSectionTag>
</div>
</td>
</tr>
</table>
<br>
</div>

    <div id="APSfactors" style="Display: none">
      <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
        <tr class="subDetail">
          <th>
            APS
          </th>
        </tr>
        <tr class="subDetail">
          <td>
            <impact:validateInput label="No Factors" type="checkbox" checked="<%= checkNoFactors %>" value="Y" id="noFactors" name="APSnoFactors" tabIndex="<%= tabIndex++ %>" onClick="setAPSFactorStatus()" />
          </td>
        </tr>
        <tr class="subDetail">
          <th>
            Determination Factors
          </th>

        </tr>
        <tr class="subDetail">
          <td>
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr class="subDetail">
                <td>
                  <impact:codesCheckbox defaultCodes="<%=APScheckedValues%>" name="APSdeterminationFactors" codesTableName="<%= CodesTables.CADETFCT %>" columns="3" isHorizontal="true" tabIndex="<%= tabIndex++ %>" />
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </div>
<%
  String mandatedReporterInd = FormattingHelper.formatString(callDecisionData.getBIndMRLetter());
          mandatedReporterInd = mandatedReporterInd != "" ? mandatedReporterInd : "N";
          String disableMRLetter = "true";

          if ((Boolean) state.getAttribute("showMRLetter", request) != null
              && (Boolean) state.getAttribute("showMRLetter", request)) {
            disableMRLetter = "false";

          }
%>
    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
      <tr class="subDetail">
        <th colspan="6">
          Response Time
        </th>
      </tr>
      <tr class="subDetail">
        <td width="15%">
          <impact:validateSelect label="Initial" name="selSzCdStageInitialPriority" tabIndex="<%= tabIndex++ %>" codesTable="<%= initialPriorityCodes %>" value="<%= FormattingHelper.formatString(callDecisionData.getSzCdStageInitialPriority()) %>" 
          onChange="setCurrentPriority();" disabled="<%= String.valueOf(approvalMode) %>"  />
        </td>

        <td>
          <impact:validateSelect label="Current" name="selSzCdStageCurrPriority" tabIndex="<%= tabIndex++ %>" codesTable="<%= currentPriorityCodes %>" value="<%= FormattingHelper.formatString(callDecisionData.getSzCdStageCurrPriority()) %>"
            onChange="  setSummaryField('selSzCdStageCurrPriority', 'dspSzCdStageCurrPriority');" />
        </td>

        <td>
          <impact:validateSelect label="Reason Changed" name="selSzCdStageRsnPriorityChgd" tabIndex="<%= tabIndex++ %>" codesTable="<%= CodesTables.CRSNPRIO %>" value="<%= FormattingHelper.formatString(callDecisionData.getSzCdStageRsnPriorityChgd()) %>"
            disabled="<%= String.valueOf(!approvalMode) %>" />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateSelect label="Disposition" name="selSzCdDisp" tabIndex="<%= tabIndex++ %>" options="<%= dispOptions %>" disabled='<%= String.valueOf(!approvalMode) %>' value="<%= FormattingHelper.formatString(callDecisionData.getSzCdIncomingDisposition())%>"
            conditionallyRequired="true" onChange="changeDisposition();" />
        </td>

        <td>
          <impact:validateSelect colspan="4" label="Screen Out Reason" name="selSzCdScreentOutReason" tabIndex="<%= tabIndex++ %>" codesTable="<%= CodesTables.CSCNOTRN %>" disabled='<%= String.valueOf(!approvalMode) %>'
            value="<%= FormattingHelper.formatString(callDecisionData.getSzCdStageScroutReason()) %>" />
        </td>
      </tr>
      <!-- CAPTA 4.3 changes -->
      
      <tr class="subDetail">
        <td colspan ="2">
          Is this alleged Maltreatment in Care 
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayMICHelp('maltreatmentInCare')">?</a></strong>
        </td>
        <td>  
          <impact:validateInput type="radio" label="Yes" name="rbIndMaltreatInCare" value="Y" cssClass="formInput" checked="<%= yIsCheckedMaltreatment %>" disabled="true" tabIndex="<%= tabIndex++ %>" />
          <impact:validateInput type="radio" label="No" name="rbIndMaltreatInCare" value="N" cssClass="formInput" checked="<%= nIsCheckedMaltreatment %>" disabled="true" tabIndex="<%= tabIndex++ %>" />
        </td>
        </tr>
        <tr class="subDetail">
        <td colspan ="2">
          Is this a Policy Violation 
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayMICHelp('policyViolation')">?</a></strong>
        </td>
        <td>  
          <impact:validateInput type="radio" label="Yes" name="rbIndPolicyViolation" value="Y" cssClass="formInput" checked="<%= yIsCheckedPolicyViolation %>" disabled="<%= disableViolationButton %>" tabIndex="<%= tabIndex++ %>" />
          <impact:validateInput type="radio" label="No" name="rbIndPolicyViolation" value="N" cssClass="formInput" checked="<%= nIsCheckedPolicyViolation %>" disabled="<%= disableViolationButton %>" tabIndex="<%= tabIndex++ %>" />
        </td>
      </tr>
      
      <tr class="subDetail">
      <td colspan ="6">
                      <impact:validateInput label=" Mandated Reporter Letter Sent"
                              name="cbxBIndMandatedLetter"
                              type="checkbox"
                              cssClass="formInput"
                              checked="<%= mandatedReporterInd %>"
                              value="Y"
                              disabled="<%= disableMRLetter %>"
                              tabIndex="<%= tabIndex++ %>"/>
                              </td>
                              </tr>
                              <tr class="subDetail">
        <td>
          <impact:validateTextArea colspan="5" label="Comments Regarding Screen out or Diversion" name="txtSzTxtStagePriorityCmnts" rows="4" cols="77" tabIndex="<%= tabIndex++ %>" maxLength="4000" conditionallyRequired="true"
            disabled='<%= String.valueOf(!approvalMode) %>' constraint="Paragraph4000">
            <%=FormattingHelper.formatString(callDecisionData.getSzTxtStagePriorityCmnts())%>
          </impact:validateTextArea>
        </td>
      </tr>
      <%--Defect STGAP00000723 Increase the max length of Text Area --%>
      <tr class="subDetail">
        <td>
          <impact:validateTextArea colspan="5" label="Special Instuctions" name="txtSzTxtStageSpIns" rows="4" cols="77" tabIndex="<%= tabIndex++ %>" maxLength="4000" constraint="Paragraph4000">
            <%=FormattingHelper.formatString(callDecisionData.getSzTxtStageSplInstrtCmnt())%>
          </impact:validateTextArea>
        </td>
      </tr>

      <tr class="subDetail">
        <td>
          <impact:validateDisplayOnlyField label="Service Provider Name" name="dspSzCdServiceProviderName" value="<%= FormattingHelper.formatString( callDecisionData.getSzCdServiceProviderName())  %>" conditionallyRequired="true" />
        </td>
        <td >
          <impact:validateDisplayOnlyField colspan="2" label="Type Of Service" name="dspSzCdTypeOfService" value="<%= typeOfServiceProvider %>" conditionallyRequired="true" />
        </td>

        <td align="right">
          <%
            //if the values of selSzCdDisp is  CodesTables.CDISP_SCR  then disable the button
          %>
          <impact:ButtonTag  name="btnResource" img="btnSelectResource" form="frmIntakeActions" disabled='<%= String.valueOf(!bResourceSearch) %>' function="disableValidation('frmIntakeActions');" action="/intake/IntakeActions/searchResource"
            editableMode='<%= EditableMode.ALL %>' tabIndex="<%= tabIndex++ %>" />
        </td>

      </tr>
    </table>
    <%
      /* Begin Special Handling */
    %>
    <%
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
    %>

    <impact:ExpandableSectionTag label="Special Handling" name="SpecialHandling" tabIndex="<%= tabIndex++ %>">

      <table border="0" width="100%" cellSpacing="0" cellPadding="3">
        <tr class="subDetail">
          <td width="15%">
            <impact:validateSelect label="Special Handling" name="selSzCdCaseSpeclHndlg" value="<%= FormattingHelper.formatString(callDecisionData.getSzCdIncmgSpecHandling()) %>" tabIndex="<%= tabIndex++ %>" codesTable="<%= CodesTables.CSPECHND %>" />
          </td>
        </tr>
        <tr class="subDetail">
          <td colspan="2">
            <impact:validateInput label="Worker Safety Issues" name="cbxBIndCaseWorkerSafety" type="checkbox" cssClass="formInput" checked="<%= workerSafetyInd %>" tabIndex="<%= tabIndex++ %>" value="Y" />
          </td>
        </tr>
        <tr class="subDetail">
          <td>
            <impact:validateTextArea label="Comments" name="txtTxtIncmgWorkerSafety" rows="3" cols="77" constraint="Paragraph4000" maxLength="4000" conditionallyRequired="true" tabIndex="<%= tabIndex++ %>"
              onChange="changeSpecHandlingComment(frmIntakeActions.txtTxtIncmgWorkerSafety, frmIntakeActions.cbxBIndCaseWorkerSafety);">
              <%=FormattingHelper.formatString(callDecisionData.getTxtIncmgWorkerSafety())%>
            </impact:validateTextArea>
          </td>
        </tr>
        <tr class="subDetail">
          <td colspan="2">
            <impact:validateInput label="Sensitive Case" name="cbxBIndCaseSensitive" type="checkbox" cssClass="formInput" checked="<%= sensitiveInd %>" tabIndex="<%= tabIndex++ %>" value="Y" />
          </td>
        </tr>
        <tr class="subDetail">
          <td>
            <impact:validateTextArea label="Comments" name="txtTxtIncomgSensitive" rows="3" cols="77" constraint="Paragraph4000" maxLength="4000" conditionallyRequired="true" tabIndex="<%= tabIndex++ %>"
              onChange="changeSpecHandlingComment(frmIntakeActions.txtTxtIncomgSensitive, frmIntakeActions.cbxBIndCaseSensitive);">
              <%=FormattingHelper.formatString(callDecisionData.getTxtIncomgSensitive())%>
            </impact:validateTextArea>
          </td>
        </tr>



      </table>
    </impact:ExpandableSectionTag>
    <%
      /* End Special Handling */
    %>

 

  <br>
  <%
    //*******************************************************************************
            //******************************** CALL SUMMARY  ***********************************
            //*******************************************************************************
  %>
  <impact:ExpandableSectionTag name="Summary" id="" label="Intake Summary" tabIndex="<%= tabIndex++ %>" isExpanded="true" accessKey="Z">

    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">

      <tr class="subDetail">
        <td>
          <impact:validateDisplayOnlyField label="Program Area" name="dspSzCdStageClassification" value="<%= FormattingHelper.formatString(callDecisionData.getSzCdStageClassification()) %>" />
        </td>

        <td>
          <impact:validateDisplayOnlyField label="Response Time" name="dspSzCdStageCurrPriority" value="<%= FormattingHelper.formatString(callDecisionData.getSzCdStageCurrPriority()) %>" />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateDisplayOnlyField label="Status" name="summaryStatus" value="<%= Lookup.simpleDecodeSafe("CINCMGST", FormattingHelper.formatString(entryInfo.getCdIncmgStatus())) %>" />
        </td>
        <td>
          <impact:validateDisplayOnlyField label="Case Name" name="dspSzNmStage" value="<%= caseName %>" />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateDisplayOnlyField colspan="4" label="Intake ID" name="summaryCallID" value="<%= FormattingHelper.formatInt(GlobalData.getUlIdStage(request))%>" />
        </td>

      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateDisplayOnlyField label="Intake Date" name="dspDtDtIncomingCall" value="<%= FormattingHelper.formatDate(entryInfo.getDtDtIncomingCall())%>" />
        </td>
        <td>
          <impact:validateDisplayOnlyField label="Intake Time" name="dspTmTmIncmgCall" value="<%= FormattingHelper.formatString(entryInfo.getTmTmIncmgCall())%>" />
        </td>
      </tr>

      <tr class="subDetail">
        <td>
          <impact:validateInput tabIndex="<%= tabIndex++ %>" value="<%= jurisdiction %>" type="text" name="txtSzNmJurisdiction" label="Law Jurisdiction" cssClass="formInput" size="40" maxLength="40" constraint="Paragraph40" conditionallyRequired="true"/>
        </td>
        <td colspan="3" width="50%">
          Law Enforcement Involved
          <impact:validateInput type="radio" label="Yes" id="LawEnfInvolved_Yes" name="rbLawEnfInvolved" value="Y" cssClass="formInput" checked="<%= lawEnfInvolved_Yes %>" tabIndex="<%= tabIndex++ %>" />
          <impact:validateInput type="radio" label="No" id="LawEnfInvolved_No" name="rbLawEnfInvolved" value="N" cssClass="formInput" checked="<%= lawEnfInvolved_No %>" tabIndex="<%= tabIndex++ %>" />
        </td>

      </tr>
    </table>
    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
      <tr class="subDetail">
        <th colspan="6">
          Intake Entered By
        </th>
      </tr>

      <tr class="subDetail">
        <td width="15%">
          <impact:validateDisplayOnlyField label="Case Manager" name="dspSzNmIncWkrName" value="<%= FormattingHelper.formatString(entryInfo.getSzNmIncWkrName())  %>" />
        </td>

        <td>
          <impact:validateDisplayOnlyField label="Phone" name="dspLNbrIncWkrPhone" value="<%= FormattingHelper.formatPhone(entryInfo.getLNbrIncWkrPhone()) %>" />
        </td>

        <td>
          <impact:validateDisplayOnlyField label="Ext." name="dspLNbrIncWkrExt" value="<%= FormattingHelper.formatString(entryInfo.getLNbrIncWkrExt())%>" />
        </td>
      </tr>


      <tr class="subDetail">

        <td>
          <impact:validateDisplayOnlyField label="Case Manager ID" name="dspUlIdIncomingWkr" value="<%= FormattingHelper.formatInt(entryInfo.getUlIdIncomingWkr())%>" />
        </td>

        <td>
          <impact:validateDisplayOnlyField label="County" name="dspSzCdIncomingWorkerCounty" value="<%=workerCounty%>" />
        </td>

        <td>
          <impact:validateDisplayOnlyField label="Region#" name="dspSzCdIncmgWorkerRegion" value="<%= workerRegion%>" />
        </td>

      </tr>

    </table>
    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
      <tr class="subDetail">
        <th colspan="6">
          Supervisor Information
        </th>
      </tr>
      <tr class="subDetail">
        <td width="15%">
          <impact:validateDisplayOnlyField label="Supervisor" name="dspSzNmIncSupName" value="<%= FormattingHelper.formatString(entryInfo.getSzNmIncmgSupName())  %>" />
        </td>

        <td>
          <impact:validateDisplayOnlyField label="Phone" name="dspLNbrIncSupPhone" value="<%= FormattingHelper.formatPhone(entryInfo.getSzNbrIncmgSupPhone()) %>" />
        </td>

        <td>
          <impact:validateDisplayOnlyField label="Ext." name="dspLNbrIncSupExt" value="<%= FormattingHelper.formatString(entryInfo.getSzNbrIncmgSupExt())%>" />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateDisplayOnlyField label="Supervisor ID" name="dspSzAddrIncWkrCity" value="<%= FormattingHelper.formatInt(entryInfo.getUlIdIncomingSup())%>" />
        </td>
        <td colspan="4"></td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>

  <%
    //************************************************
            //**** PAGE LEVEL BUTTONS BEING*******************
            //************************************************
  %>

  <br>
  <hr>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>

      <td width="65%">
      </td>

      <td width="10%">
        <impact:ButtonTag name="btnSubmit" img="btnSaveAndSubmit" align="right" form="frmIntakeActions" action="/intake/IntakeActions/saveAndSubmitIntake" tabIndex="<%= tabIndex++ %>" function="return saveAndSubmitFuction();setSpclInvPlcmntProviderConfirmed(); setRecordsCheckCompletedConfirmed();"
          disabled="<%= String.valueOf(approvalMode) %>" restrictRepost="true" preventDoubleClick="true" accessKey="B" />
      </td>

      <td width="5%">
        <impact:ButtonTag name="btnSave" img="btnSave" align="right" form="frmIntakeActions" action="/intake/IntakeActions/saveIntakeActions" tabIndex="<%= tabIndex++ %>" accessKey="S" restrictRepost="true" preventDoubleClick="true"
          function="return closeCallNarrative();" />
      </td>
    </tr>
  </table>

  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  
<script type="text/javascript" language="JavaScript1.2">
window.attachEvent('onload', showMaltreatIncareConfirmation);
window.attachEvent('onload', showRecordsCheckConfirmation);
</script>
</impact:validateForm>
<%
  //************************
        //**** FORM ENDS HERE ****
        //************************

        //STGAP00009181: This form is defined to display the determination factor questions.
%>
<%-- This separate form is used to post determination factors questions for display --%>
<form name="frmDetFaq" method="post" action="/intake/IntakeActions/displayDetFaq">
  <input type="hidden" name="hdnDetFaqType" value="" />
</form>

<%
  //************************
        //**** FORM ENDS HERE ****
        //************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>

    <td>

      <impact:documentButton pageMode="<%= pageMode %>"
                               buttonUrl="/grnds-docs/images/shared/btnNarrative.gif"
                               tabIndex="<%= tabIndex++ %>"
                               accessKey="W" >

           <impact:document displayName="Intake Narrative"
                    protectDocument="<%= !PageModeConstants.VIEW.equals(pageMode) ? false : true  %>"
                    checkForNewMode="false"
                    docType="callnarr"
                    windowName="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"
                    docExists="<%= ((ArchitectureConstants.Y).equals(request.getAttribute(IntakeConstants.NARRATIVE_EXISTS))) %>" >
                    <impact:documentParameter name="sStage"
                               value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
            </impact:document>
    </impact:documentButton>
    </td>

  </tr>
</table>


<br>

<%--removed comment out kevin dunaway--%>



<%
  /* begin Forms and Reports  */
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th>Forms</th>
  </tr>
  <tr>
    <td>

<impact:documentList pageMode="edit" tabIndex="<%= tabIndex++ %>">
  <impact:document displayName="Intake Report"
                        protectDocument="true"
                        docType="cfin01o00"
                        docExists="true"
                        onClick="setIntakeReport();">

    <impact:documentParameter name="pStage"
                              value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
  </impact:document>
<%
  if ((CodesTables.CINCMGST_CLD).equals(entryInfo.getCdIncmgStatus())
              || (CodesTables.CINCMGST_SBA).equals(entryInfo.getCdIncmgStatus())) {

            //Removed from tag below - onClick="setNotificationToLe();"
%>
  <impact:document displayName="Notification to L.E."
                        protectDocument="true"
                        docType="int01o00"
                        docExists="true"
                        >

    <impact:documentParameter name="pStage"
                        value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
  </impact:document>
<%
  }
%>
<%
  if ((Boolean) state.getAttribute("showMRLetter", request) != null
              && (Boolean) state.getAttribute("showMRLetter", request)) {
%>
<impact:document displayName="Mandated Reporter Letter Form" protectDocument="<%= !PageModeConstants.VIEW.equals(pageMode) ? false : true  %>" checkForNewMode="false" docType="fim02o00" docExists="true">
            <impact:documentParameter name="pCase"
                              value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>
           <impact:documentParameter name="pStage"
                              value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
                     </impact:document>

<%
  }
%>

</impact:documentList>
    </td>
  </tr>
</table>


<%
  /* end Forms and Reports */
%>

<script type="text/javascript" language="JavaScript1.2">
<%--
// This function will be called when the user attempts to launch the Intake Report from the
// forms section.  It will check first that this is a "real" Intake .. i.e the Intake
// has not been marked as an I&R or Special Request on the Call Information or Intake
// Action page.  If the intake is not an SPC or I&R, we check to make sure the user has
// entered a classification.  If they have, then we case on the classification to determine
// which document to launch.
--%>
function setIntakeReport()
{
  var classification = document.frmIntakeActions.selSzCdStageClassification.value;
  <%--if ((<%= bCallEntryNCRSR || bCallEntryIR  || bCallEntryCRSR %>) ||
     (classification == '<%= CodesTables.CCLASS_IR %>') ||
       (classification == '<%= CodesTables.CCLASS_SPC %>'))
     {
     alert('You may not create this report for I&Rs and Special Requests.');
    return false;
  }
  else
  --%>
  if (classification == null || classification == "")
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_REP_CLASS_REQ)%>");
    return false;
  }
  else
  {
    document.cfin01o00.docType.value = 'cfin01o00';
    return true;
  }
}
<%--
// This function will be called when the user attempts to launch the Notification to LE from the
// forms section.  This form can only be launched when the status of the intake is SBA or CLD and
// the Intake is classified as a CPS or Licensing stage.
--%>

<%--Edited by Kevin Dunaway for GA Shines--%>
function setNotificationToLe()
{
  var classification = document.frmIntakeActions.selSzCdStageClassification.value;
  if (classification == null || classification == "")
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_REP_CLASS_REQ)%>");
    return false;
  }
  else
  {
      document.cfin0600.docType.value = 'int01o00';
      return true;
  }
}
<%--End of Editing by Kevin Dunaway for GA Shines--%>


<%--
// This function will be called when the user attempts to launch the APS Deidentified Report from the
// forms section.  This form can only be launched when the .
--%>
function setAPSDeidentifiedReport()
{
  var classification = document.frmIntakeActions.selSzCdStageClassification.value;
  if (classification == null || classification == "")
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_REP_CLASS_REQ)%>");
    return false;
  }
  else
  {
    var startsWith = classification.substring(0, 1);
    if (classification == '<%=CodesTables.CCLASS_AFC%>')
    {
      document.cfin0800.docType.value = 'cfin0800';
      return true;
    }
    else if (startsWith == 'A')  <%--// && classification != AFC --%>
    {
      <%--//SIR 17536 - Changed cfin0600 to cfin0800 --%>
      document.cfin0800.docType.value = 'cfin0700';
      return true;
    }
    else
    {
      alert('You may only generate this document for Intakes with classification APS or AFC.');
      return false;
    }
  }

}

previousOnload = new String( window.onload );
previousOnload = previousOnload.substring( previousOnload.indexOf('{')+1, previousOnload.lastIndexOf('}') );

window.onload = function ()
{

eval(previousOnload);

<%/* onLoad of the page we call toggleDeterminationFactors to display the correct
            Determination Factors and Descriptions based on what we have retrieved for Classification.
            If the user entered Special Request or I&R info on the Call Info page, the Classification
            field is disabled, so we do not want to call toggleDeterminationFactors. */%>

toggleDeterminationFactors();

<%/* Since Current Priority can be modified indirectly in Edit mode by changing Initial Priority, we
             have to to disable the field using javaScript.  This way, when we want to modify the Current Priority,
             we can enable the field (which would be impossible if we had disabled the field using the custom tag disabled=""
             attribute), change the value, and re-disable it.  */%>

<%if (approvalMode) {%>
  document.frmIntakeActions.selSzCdStageCurrPriority.disabled = false;
<%} else {%>
  document.frmIntakeActions.selSzCdStageCurrPriority.disabled = true;
<%}%>

<%/*  We call setClosureCodeStatus here so that onLoad of the page, the Closure Code field will be correctly
            endabled or disabled based on the values for Initial Priority and the Classification Type. Note:  In setClosureCodeStatus()
            we use hdnClassificationType whose value is set in the toggleDeterminationFactors() functions called above. */%>

  //setClosureCodeStatus();

<%/* If 'No Factors' is checked onLoad of the page, we need to disable the corresponding factors and descriptors   */%>
<%if (!PageModeConstants.VIEW.equals(pageMode)) {%>
if ((document.frmIntakeActions.hdnClassificationType.value == '<%=CodesTables.CCLASS_CPS%>') &&
  (document.frmIntakeActions.CPSnoFactors.checked == true))
 {
   setCPSFactorStatus();
 }
else if ((document.frmIntakeActions.hdnClassificationType.value == '<%=CodesTables.CCLASS_APS%>') &&
  (document.frmIntakeActions.APSnoFactors.checked == true))
{
  setAPSFactorStatus();
}
<%}%>

<%--// SIR 22429 & 22430- Reset the call summary info on load of the page. --%>
<%//STGAP00005621: Modified code to make sure the current priority
            //is over written by initial priority only when there is no existing current
            //priority
            if (!PageModeConstants.INQUIRE.equals(pageMode)) {%>
  var priority = document.frmIntakeActions.hdnInitialPriority.value;
  var currPriority = document.frmIntakeActions.hdnCurrPriority.value;
  index1 = document.frmIntakeActions.selSzCdStageCurrPriority.selectedIndex;
  index = document.frmIntakeActions.selSzCdStageInitialPriority.selectedIndex;
  updatePriorityCodesTables();

  document.frmIntakeActions.selSzCdStageInitialPriority.options.value = priority;
  if ( index == 0 )
  {
    document.frmIntakeActions.selSzCdStageInitialPriority.options[index].selected = true;
    document.frmIntakeActions.selSzCdStageInitialPriority.options[index].defaultSelected = true;
  }
  if(index1 == 0)
  {
    document.frmIntakeActions.selSzCdStageCurrPriority.options[index].selected = true;
    document.frmIntakeActions.selSzCdStageCurrPriority.options[index].defaultSelected = true;
  }
  document.frmIntakeActions.selSzCdStageCurrPriority.options.value = currPriority;
  setCurrentPriority();
  //setClosureCodeStatus();

<%}%>
setSummaryField('selSzCdStageCurrPriority', 'dspSzCdStageCurrPriority');
setSummaryField('selSzCdStageClassification', 'dspSzCdStageClassification');


}
</script>

<%
  }
%>

