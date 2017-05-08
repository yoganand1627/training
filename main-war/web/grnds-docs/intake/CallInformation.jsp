    <%
      //*  JSP Name:     Call Information JSP
      //*  Created by:   Jenn Casdorph
      //*  Date Created: 02/06/2003
      //*
      //*  Description:
      //*  The Call Information JSP contains three expandable sections.
      //*  Call Entry, Call Person List, and Facility Detail.  This is
      //*  the entry point for all new Intakes.  The user will navigate to a
      //*  new Call Information page by clicking the Intake Top Level Tab.
      //*  The page will load in VIEW mode with only the Phone Icon available.
      //*  Once the user has clicked the Phone Icon, the Call Information page
      //*  will load in NEW mode with only the Call Entry section visible.  The
      //*  user will enter Call Entry info and select to Continue, or to Save &&
      //*  whatever if the call is an I&R or NCRSR.  If the user chooses to continue,
      //*  the page will reload in normal EDIT mode.
      //*
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  05/22/2003 CASDORJM         Removed the disableSaveAssign indicator from the page.
      //**                              The user should be able to save and assign all SPC and I&R.
      //**                              We do need to check for the SEC_ASSIGN_INTAKE_DIRECT security
      //**                              attribute in the custom validation when the user is attempting to
      //**                              assign a CPS Case Related Special Request though.
      //**  07/14/2003 CASDORJM         SIR 18881 - Added logic to disable validation when the user clicks
      //**                              the person list hyperlink and the page is in VIEW mode.
      //**  10/8/2003  Dickmaec    SIR 19805 - The extension textbox needed to be able to handle an eight
      //**                              character extension. Changed maxlength and size equal to eight.
      //**  11/14/03  CASDORJM         Rearranged the Caller and IN RE Fields.
      //**                             Also added logic to notify the user the Intake Narrative needed
      //**                             to be saved before any processing could take place.
      //**                             Modified Call Person list to show codes instead of codes.
      //**  01/06/04  dejuanr          E-Report Project. Made Date/Time fields editable
      //**                             during the entire life of an ereport intake.
      //**  03/17/04  dejuanr          E-Report Project. Removed code to make date/time
      //**                             field editble only for ereprots itnakes and made the
      //**                             fields open all the time.
      //**
      //** 08/17/04   ochumd           Sir22962 - Added three new program types viz CCL,
      //**                             RCL,AFC.  Re-wrote the function filterDropDownByProgram()
      //**                             to accomodate the new codes.
      //** 09/09/04   dejuanr          SIR 23110 - Added code to notify user to validate address
      //**
      //** 09/20/04  codreaa           SIR 23030 - Changed Javascript comments to JSP comments so they
      //**                             will not be output to the HTML code on the page
      //** 10/14/04  CORLEYAN          SIR 23209 - Changed the length of the special reqest field to
      //**                             accomidate Emergency Background Check CRSR.
      //** 02/03/05  ochumd            Backed out the code for sir 23019 and added the code for
      //**                             sir 23319 which modified the Window Onload function
      //**                             that was preventing error list page from coming up.
      //** 05/09/05  ochumd            Sir 23019 - Add 3 Special Request types to the
      //**                             Special Request Type List:CCL Standards Violation
      //**                             RCL Standards Violation and CPS Foster Home Standards Violation.
      //** 06/30/05  ochumd            Sir 23711 - APS Reform R2 - CRSR Four new Special Request types
      //**                             added to the Special Request Dropdown.  The new ones are
      //**                             DADD Court, APS Court, Law Enforcement and Out of State.
      //**
      //** 03/12/08  arege			   Created an ArrayList for the purpose of excluding the Juvenile Court 
      //**                             decode from displaying in the 'Non Incident Request Type' dropdown.It
      //**                             is used as the value for the excludeOptions attribute of the tag.
      //** 03/19/08  ccurd			   STGAP00007602 - Modified 'Operated By' drop-down to use CERTIFBY codes
      //**							   table instead of COPRTBY2  
      //** 03/28/08  schoi			   STGAP00003968 - Added two functions, deleteCallPersonConfirm() 
      //**							   and navAway() for the new Delete button. Added code for "btnDeleteFromList" tab.
      //** 05/07/08  jramspot          STGAP00008473 - make sure save and close popup allows all 5 non-incident types to be closed    
      //** 06/02/08  arege             STGAP00008255  Clear the Dispositin field on IntakeActions page 
      //**                             if the Intake is not one of the PA,IC, PF or NI
      //** 11/5/08   cwells            STGAP00010528 Changed the name of the widget for Placement provider type.  The name should not be the same
      //**   	                       as Resource Type. 
      //** 11/12/08  arege             STGAP00010758 Modified code so that the SaveAndSubmit button is hidden for the 
      //**                             Supervisor in approvalMode.
      //** 12/12/08  arege             STGAP00009681 Added CNIRTYPE_OT to the excludeOptions arraylist so that the
      //**                             Non -Incident Request type of OTI does not display in the 'Non Incident Request Type' dropdown.
      //** 04/30/10 bgehlot            SMS#51977: MR-066 Changes
      //** 06/30/2010 bgehlot          SMS 60409 MR-066 Remove CPA from Provider Type list and change the PRovider Search label with new text
      //** 09/20/2010 wjcochran        SMS#50402: Removed 'No County' option for Reporter
      //** 06/30/2011 arege            SMS#113535 Added if statement to eliminate javascript error of 'document.frmCallInformation.txtNmIncmgFacilNameSearch'
      //**                             is null or not an object.         
      //** 07/01/2011 arege            SMS#113944: CAPTA 4.3 The provider search area is populating after superivosr approval                    
      //** 07/11/2011 hnguyen          SMS#114325: CAPTA 4.3 Remove population for Provider Search fields to resolve issue with dirty page message.                    
      //** 08/30/2011 arege            STGAP000135790: Added proper constraint to txtSzTxtFacilCmnts
      
    %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.HashSet"%> 
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.ArrayList"%> 
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>

<%
  {
    String rsrcType = "";
    BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                     .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    UserProfile user = UserProfileHelper.getUserProfile(request);

    int tabIndex = 1;
    int loopCount = 0;

    /* PAGE MODE LOGIC BEGIN  */
    String pageMode = PageModeConstants.EDIT;
    if (PageMode.getPageMode(request) != null) {
      pageMode = PageMode.getPageMode(request);
    }
    // We use two different boolean indicators here for two different cases:
    // 1.  newIntake_noStageID - The user clicked on the Intake tab and has not
    //     clicked the Phone icon.
    //
    //     Fields Affected By newIntake_noStageID:
    //     - The Phone Icon (disabled if false)
    //     - The Narrative Document Button (hidden if true)
    //
    // 2.  newIntake_withStageID - The user clicked on the Intake tab and has clicked the
    //     Phone icon.
    //
    //     Fields Affected By The NewIntake
    //     - The Continue Button (visible if true)
    //     - The first set of Save && Whatever buttons (visible if true)
    //     - The Person and Facility Section (hidden if true)
    boolean newIntake_noStageID = false;
    boolean newIntake_withStageID = false;
    // Exclude the Juvenile Court decode from displaying in the 'Non Incident Request Type' dropdown
    ArrayList excludeOptions = new ArrayList();
    excludeOptions.add(CodesTables.CNIRTYPE_JC);
    excludeOptions.add(CodesTables.CNIRTYPE_OT);

    if ((pageMode.equals(PageModeConstants.VIEW)) && (GlobalData.getUlIdStage(request) == 0)) {
      newIntake_noStageID = true;
    }
    if (newIntake_noStageID || pageMode.equals(PageModeConstants.NEW)) {
      newIntake_withStageID = true;
    }
    boolean approvalMode = false;
        if (GlobalData.isApprovalMode(request)) {
          approvalMode = true;
        }

    // foo foo

    /*  GET OBJECTS FROM REQUEST AND PERFORM NULL CATCH  */
    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct callEntryData = callEntryRtrvOut.getCallEntrySvcStruct();
    if (callEntryData == null) {
      callEntryData = new CallEntrySvcStruct();
    }

    CallDcsnAUD callDecisionData = callEntryRtrvOut.getCallDcsnAUD();
    if (callDecisionData == null) {
      callDecisionData = new CallDcsnAUD();
    }

    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);
    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }

    FacilRtrvOutRec facilRtrvOutRec = (FacilRtrvOutRec) state.getAttribute("FacilRtrvOutRec", request);
    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    FacDetailEntStruct facilityData = facilRtrvOutRec.getFacDetailEntStruct();
    if (facilityData == null) {
      facilityData = new FacDetailEntStruct();
    }

    String cdsplInvest = FormattingHelper.formatString(callEntryData.getSzCdSpclInvstgtn());
    String cdsplCircum = FormattingHelper.formatString(callEntryData.getSzCdSpclCircumstances());
    String nonIncReqType = FormattingHelper.formatString(callEntryData.getSzCdNonRsdntReqType());
    String facType = FormattingHelper.formatString(facilityData.getSzCdIncmgFacilType());
    rsrcType = FormattingHelper.formatString(facilityData.getSzCdIncmgFacilType());

    String programType = callEntryData.getSzCdStageClassification() != null ? callEntryData
                                                                                           .getSzCdStageClassification()
                                                                           : StringHelper.EMPTY_STRING;
    boolean disableClass = false;

    // If the user entered the page by doing a new using, we want the Date, Time
    // and Call Type fields to be editable.  The following indicator is passed
    // in from the newUsingIntake_xa() method.
    String newUsing = (String) request.getAttribute("newUsing");
    if (newUsing == null) {
      newUsing = "false";
    }
    Date dtCnfidntltyExplntn = null;

    if (callEntryData.getDtCnfidntltyExplntn() != null
        && !StringHelper.EMPTY_STRING.equals(callEntryData.getDtCnfidntltyExplntn())) {
      dtCnfidntltyExplntn = DateHelper.toJavaDate(callEntryData.getDtCnfidntltyExplntn());
    } else if (dtCnfidntltyExplntn == null) {
      dtCnfidntltyExplntn = new Date();

    }

    Set typeExclusionSet = (HashSet) request.getAttribute("rsrcTypeExclusions");
    if (typeExclusionSet == null) {
      typeExclusionSet = new HashSet();
    }
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
<%--
//  Called onUnload of page to remind user unsaved data will be lost
--%>
window.onbeforeunload = function ()
 {
   return IsDirty();
 };
 <%--
//  Filters the Special Requests Drop Down box based on what Program is selected
//  Create a codeArray for every dropdown box that needs to be filtered on the page
--%>
<impact:codeArray codeName="<%=CodesTables.CSPECREQ%>"
                  arrayName="<%=CodesTables.CSPECREQ%>"
                  blankValue="true"/>;

//Get faciltiy type code/decode array for Resource Type of MHMR
    <impact:codeArray codeName="CFACTYP4" arrayName="facilitytype4" blankValue="true"/>
//Get faciltiy type code/decode array for Resource Type of Other Facility
    <impact:codeArray codeName="CFACTYP5" arrayName="facilitytype5" blankValue="true"/>
<%--
//  This function is called when the user clicks a hyperlink in the list.  We don't want to disable the form validation
//  since clicking on a hyperlink auto saves the Call Information page.  We set the value of the hdnPersonDetailHyperlink field
//  to true so the custom validation knows that we clicked a hyperlink.
// JMC - SIR 18881 - Added logic to disable validation when the page is in view mode.
--%>
function personListHyperlink (index)
{
  frmCallInformation.fireEvent("onSubmit");
  frmCallInformation.hdnIndex.value = index;
  frmCallInformation.hdnPersonDetailHyperlink.value = "true";

  <%
    if ( PageModeConstants.VIEW.equals( pageMode ) )
    {
%>
      disableValidation("frmCallInformation");
      submitValidateForm("frmCallInformation", "/intake/CallInformation/displayCallPersonDetail");
<%
    }
    else
    {
%> 
      if (validateAddressOnSave("frmCallInformation",
                                   "/intake/CallInformation/displayCallPersonDetail",
                                   "callEntryAddress"))
      {
        submitValidateForm("frmCallInformation", "/intake/CallInformation/displayCallPersonDetail");
      }
  <%}%>
}
<%--
//  This function is called when the user clicks the Phone Icon.
--%>
function createNewIntakeHyperlink ()
{
  disableValidation("frmCallInformation");
  submitValidateForm("frmCallInformation", "/intake/CallInformation/createNewIntake");
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

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction()
{


	if (<%=!newIntake_withStageID%>)
	{ 
  		
	}

   //setFocus();
}

//set the initial focus of the page
function setFocus()
{
  document.frmCallInformation.selResourceFacilityTypeSearch.focus();
}

<%--
//This function is called when the Non Incident Request Type drop down is changed.
--%>
function clearDisposition()
{
      if (!(document.frmCallInformation.selSzCdNonIncReqType.options.value == "<%=CodesTables.CNIRTYPE_IC%>" ||
     	document.frmCallInformation.selSzCdNonIncReqType.options.value == "<%=CodesTables.CNIRTYPE_NI%>" ||
     	document.frmCallInformation.selSzCdNonIncReqType.options.value == "<%=CodesTables.CNIRTYPE_PA%>" ||
     	document.frmCallInformation.selSzCdNonIncReqType.options.value == "<%=CodesTables.CNIRTYPE_PF%>" 
     	))
        {
           if( document.frmCallInformation.btnSaveAndCloseIsEnabled.value == "true" )
           {
           disableValidation("frmCallInformation");
           submitValidateForm("frmCallInformation", "/intake/CallInformation/deleteDisposition");
           }
              	
         }
  
    return false;
}

<%--
// Do not allow the user to Save and Close an Intake that is not 
// an Non-incident Request of Information and Referral
--%>
function ncrsrIrOnly()
{
  var retVal = true;
  
  
  if (document.frmCallInformation.selSzCdNonIncReqType_Disabled != null)
  {
  
  		if (document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value == "" ||
  		((document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != "<%=CodesTables.CNIRTYPE_IR%>") &&
  		(document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != "<%=CodesTables.CNIRTYPE_OE%>") &&
  		(document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != "<%=CodesTables.CNIRTYPE_OT%>") &&
  		(document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != "<%=CodesTables.CNIRTYPE_TA%>")))
              
  		{
    		retVal = false;
 	 	}
  
  }else 
  {
  		if (document.frmCallInformation.selSzCdNonIncReqType.options.value == "" ||
     	((document.frmCallInformation.selSzCdNonIncReqType.options.value != "<%=CodesTables.CNIRTYPE_IR%>") &&
     	(document.frmCallInformation.selSzCdNonIncReqType.options.value != "<%=CodesTables.CNIRTYPE_OE%>") &&
     	(document.frmCallInformation.selSzCdNonIncReqType.options.value != "<%=CodesTables.CNIRTYPE_OT%>") &&
     	(document.frmCallInformation.selSzCdNonIncReqType.options.value != "<%=CodesTables.CNIRTYPE_TA%>")))
              
  		{
   		 retVal = false;
  		}
  }
 if (!retVal)
  {
	alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_INR_SAVE_CLOSE)%>");
  }
  return retVal;
}
<%--
// This function is called on Save and Close and if the Intake is an I&R of type  will display a confirmation box asking the user
// if they entered the Facility Name the Intake was referred to in the Call Narrative.
--%>
function facNameReqForReferrals()
{
  var retVal = true;
  if ((document.frmCallInformation.selSzCdInfoAndRefrl.options.value != "") &&
       ((document.frmCallInformation.selSzCdInfoAndRefrl.options.value == "<%=CodesTables.CINRTYPE_03%>") ||
         (document.frmCallInformation.selSzCdInfoAndRefrl.options.value == "<%=CodesTables.CINRTYPE_05%>")))
  {
    retVal = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_IR_ENTER_FACILITY)%>');
  }
  return retVal;
}

<%--
// These functions are called upon pressing the saveAndSubmit button.
// If this function returns true, the saveAndSubmit action is completed,
// otherwise, the page just halts.
//
// The logic of this function is as follows:
// 1.  If the call is not an SPC exit.
// 2.  Validate the addresses.  If the user clicks "Cancel" exit.
//      NOTE: This function is called by btnSaveAndSubmit1 and btnSaveAndSubmit.
//            When btnSaveAndSubmit1 is visible we are in a new intake and the
//            Facility Address is not visible, so we only validate ONE address.
// 3.  Close the Call Narrative and complete the saveAndSubmitIntake action.
--%>
function saveAndSubmitFunctions()
{
  var retVal = true;
  
  if (retVal)
  {
      <% if (newIntake_withStageID) {%>
      retVal = validateAddressOnSave("frmCallInformation",
                                     "/intake/CallInformation/saveAndSubmitIntake",
                                     "callEntryAddress");
      <%} else {%>
      
      retVal = validateAddressOnSave("frmCallInformation",
                                     "/intake/CallInformation/saveAndSubmitIntake",
                                     "callEntryAddress");
     
      <%}%>
    if (retVal)
    {
      retVal = closeCallNarrative();
    }
  }
  return retVal;
}
<%--
// These functions are called upon pressing the saveAndAssign button.
// If this function returns true, the saveAndAssign action is completed,
// otherwise, the page just halts.
// The logic of this function is as follows:
// 1.  If the call is not an IR or a SPC exit.
// 2.  Validate the addresses.  If the user clicks "Cancel" exit.
//      NOTE: This function is called by btnSaveAndAssign1 and btnSaveAndAssign.
//            When btnSaveAndAssign1 is visible we are in a new intake and the
//            Facility Address is not visible, so we only validate ONE address.
// 3.  Close the Call Narrative and complete the saveAndAssignIntake action.
--%>
function saveAndAssignFunctions()
{
  var retVal = true;
  
  if (retVal)
  {
      <% if (newIntake_withStageID) {%>
        retVal = validateAddressOnSave("frmCallInformation",
                                       "/intake/CallInformation/saveAndAssignIntake",
                                       "callEntryAddress");
      <%} else {%>
        retVal = validate2AddressesOnSave("frmCallInformation",
                                          "/intake/CallInformation/saveAndAssignIntake",
                                          "callEntryAddress",
                                          "facilityAddress");
      <%}%>
        if (retVal)
        {
          retVal = closeCallNarrative();
        }
  }
  return retVal;
}
<%--
// These functions are called upon pressing the saveAndClose button.
// If this function returns true, the saveAndClose action is completed,
// otherwise, the page just halts.
//
// The logic of this function is as follows:
// 1.  Prompt the user to see if they have entered the an agency name in the Call Narrative
//     for referrals.  If the user clicks "Cancel" exit.
// 2.  Validate the addresses.  If the user clicks "Cancel" exit.
//      NOTE: This function is called by btnSaveAndClose1 and btnSaveAndClose.
//            When btnSaveAndClose1 is visible we are in a new intake and the
//            Facility Address is not visible, so we only validate ONE address.
// 3.  Close the Call Narrative and complete the saveAndCloseIntake action.
--%>
function saveAndCloseFunctions()
{
  var retVal = true;
  retVal = ncrsrIrOnly();
  if (retVal)
  {
    //retVal = facNameReqForReferrals();
    if (retVal)
    {
      <% if (newIntake_withStageID) {%>
      retVal = validateAddressOnSave("frmCallInformation",
                                     "/intake/CallInformation/saveAndCloseIntake",
                                     "callEntryAddress");
      <%} else {%>
        retVal = validateAddressOnSave("frmCallInformation",
                                        "/intake/CallInformation/saveAndCloseIntake",
                                        "callEntryAddress");
   
      <%}%>
      if (retVal)
      {
        retVal = closeCallNarrative();
      }
    }
  }
  return retVal;
}
<%--
// These functions are called upon pressing the continue button.
// If this function returns true, the continue action is completed,
// otherwise, the page just halts.
// This function simply validates the Call Entry Address before saving
// the initial Call Entry page.
--%>
function continueFunctions()
{
  var retVal = true;
   
  retVal = validateAddressOnSave("frmCallInformation",
                                  "/intake/CallInformation/saveInitialCallEntry",
                                 "callEntryAddress");
                       
  return retVal;
}

<%--
// These functions are called upon pressing the save button.
// If this function returns true, the save (and exit) action is completed,
// otherwise, the page just halts.  This function simiply makes sure the
// Call Entry and Facility addresses have been validated.
--%>
function saveFunctions()
{
  var retVal = true;
  
  retVal = validateAddressOnSave("frmCallInformation", "/intake/CallInformation/saveCallInformation","callEntryAddress");
 
  if (retVal)
  {
    retVal = closeCallNarrative();
   
  }
  return retVal;
}
<%--
// SIR 23110 Start
// This function will set the valdiated flag to false and notify the user to validate
// the address.
--%>
function validateEReportAddress()
{
<%
  Map validateMap = (Map) state.getAttribute( "validateMap" , request );
  validateMap = validateMap == null ? new HashMap() : validateMap;
  String flag = (String) validateMap.get( "0" );
  if ( "0".equals( flag ) )
  {
%>
  changeValidAddress( "frmCallInformation" , "callEntryAddress" );
  document.frmCallInformation.hdnAddressValidation.value = "true";
<%
  }
%>
}
<%--
//SIR 23110 End
--%>
//Sir 23319 Begin.
previousOnload = new String( window.onload );
previousOnload = previousOnload.substring( previousOnload.indexOf('{')+1, previousOnload.lastIndexOf('}') );

window.onload = function ()
{
eval(previousOnload);
validateEReportAddress();
}
// Sir 23319 End.

//}

function deleteCallPersonConfirm()
{
  navAway();
  return confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>');
}

/**SMS#51977 Resource ID hyperlink submission */
function submitResourceID(idResource, idHomeStage)
  {
    document.frmCallInformation.idResource.value = idResource;
    document.frmCallInformation.hdnUlIdHomeStage.value = idHomeStage;
    submitValidateForm( "frmCallInformation", "/intake/CallInformation/displayResourceDetail" );
  }
  
/**CAPTA 4.3 Provide Allegation History hyperlink submission */
function submitProviderAllegationHistory(idResource)
  {
    document.frmCallInformation.idResource.value = idResource;
    submitValidateForm( "frmCallInformation", "/resource/ProviderAllgtnHistory/displayProviderAllgtnHistory" );
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

<impact:validateForm name="frmCallInformation" method="post" action="/intake/CallInformation/displayCallInformation" pageMode="<%=pageMode%>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.intake.CallInformationCustomValidation"
	schema="/WEB-INF/Constraints.xsd">
	<%
	  /* The hdnIndex field value is used to determine which hyperlink row was clicked once we get to the conversation.*/
	%>
	<impact:validateInput type="hidden" name="hdnIndex" value="" />
	<%
	  /* The hdnPersonDetailHyperlink field value is set to true when the user clicks on one of the Call Person List
	     hyperlinks.  The custom validation class CallInformationCustomValidation uses the value of this field to determine
	     if the user clicked a hyperlink or not.  We need to know this since Call Information is automatically saved when
	     the user navigates to the Call Person Detail page.  Therefore, clicking the hyperlink will cause the Call Information
	     save validation to be performed. */
	%>
	<impact:validateInput type="hidden" name="hdnPersonDetailHyperlink" value="" />
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
	<impact:validateInput type="hidden" name="hdnSaveCallInformation" value="true" />
	<%
	  }
	%>
	<%
	  /* The hdnIsCallInfoDirty field is used by the Intake Actions page to determine if any changes were made on the Call Information
	                                       page and whether to call the Call Information Save.*/
	%>
	<impact:validateInput type="hidden" name="hdnIsCallInfoDirty" value="" />
	<impact:validateInput type="hidden" name="hdnIsSetIsDirtyCalled" value="" />
	<%
	  /* The hdnResourceSearch field is set when the user returns from a Resource Search.  Since we set
	                                       the retrieved resource info into the facility detail object in state before the page is loaded,
	                                       our save method did not register a change in facility.  In the save method we check to
	                                       see if the data has been changed since the page loaded OR if this indicator is true.  */
	%>
	<%
	  String resourceSearch = (String) request.getAttribute("resourceSearch");
	%>
	<impact:validateInput type="hidden" name="hdnResourceSearch" value="<%=resourceSearch%>" />
	
	<impact:validateInput type="hidden" name="hdnSaveandClose" value="" />
	<% /* capta 4.3 - the hdnPlacementFound flag is used when saving the faculty if retrieve for a victim child
		* and pre-poluated while loading the intake information page.
	    */
	 %>
	<%
	
	  String placementFound = (String) state.getAttribute("PlacementFoundForChild", request);
	%>
	<impact:validateInput type="hidden" name="hdnPlacementFound" value="<%=placementFound%>" />
	

	<%
	  /* SIR 23110 Start */
	%>
	<impact:validateInput type="hidden" name="hdnAddressValidation" value="false" />
	<%
	  /* SIR 23110 End */
	%>

	<%
	  if ("true".equals(newUsing)) {
	%>
	<impact:validateInput type="hidden" name="hdnNewUsing" value="true" />
	<%
	  }
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
	        action = "/intake/CallInformation/submitApproval";
	      }
	%>


	<impact:ifThen test="<%=((Boolean.valueOf(disableApprovalStatus) == false) || (GlobalData.getUlIdCase(request) != 0))%>">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td align="left">
					<impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmCallInformation" action="<%=action%>" navAwayCk="true" disabled="<%=disableApprovalStatus%>" editableMode='<%=EditableMode.ALL%>' tabIndex="<%=tabIndex%>" />
				</td>
		</table>
	</impact:ifThen>
	<%
	  //*******************************************************************************
	      //******************************** CALL ENTRY ***********************************
	      //*******************************************************************************
	%>
	<impact:ExpandableSectionTag name="Entry" id="" label="Entry" tabIndex="<%=tabIndex++%>" accessKey="E">
		<table border="0" cellpadding="0" cellspacing="0" width="100%" class="tableBorder">
			<tr class="subDetail">
				<td width="35%">
					<!-- end calendar table -->
					<TABLE border="0" cellpadding="3" cellspacing="0" width="100%">
						<TR>
							<TD rowspan="2">
								<%
								  if (newIntake_noStageID) {
								%>
								<A href="javascript:createNewIntakeHyperlink();"><IMG border="0" src="/grnds-docs/images/shared/phone.jpg"></A>
								<%
								  } else {
								%>
								<IMG border="0" src="/grnds-docs/images/shared/phone.jpg">
								<%
								  }
								%>
							</TD>
							<TD>
								<impact:validateDate label="Date" name="dtDtIncomingCall" value="<%=FormattingHelper.formatDate(callEntryData.getDtDtIncomingCall())%>" type="text" required="true" constraint="Date" size="8" tabIndex="<%=tabIndex++%>" />
							</TD>
						</TR>
						<TR>
							<TD>
								<impact:validateTime name="txtTmTmIncmgCall" label="Time" required="true" value="<%=callEntryData.getTmTmIncmgCall()%>" tabIndex="<%=tabIndex++%>" />
							</TD>
						</TR>
					</TABLE>

				</td>
				<td class="formLabel">
					<!-- begin the radio buttons table -->
					<!-- end the radio buttons table -->
					<TABLE border="0" cellpadding="3" cellspacing="0" width="100%">
						<TR>
							<%
							  String szCdIncomingCallType = FormattingHelper.formatString(callEntryData.getSzCdIncomingCallType());
							        ;
							        szCdIncomingCallType = szCdIncomingCallType != "" ? szCdIncomingCallType : CodesTables.CINCCTYP_0;

							        Collection types = Lookup.getCategoryCollection(CodesTables.CINCCTYP);
							        Iterator i = types.iterator();
							        while (i.hasNext()) {
							          CodeAttributes o = (CodeAttributes) i.next();
							          String value = o.getCode();
							          String label = o.getDecode();
							%>
							<TD>
								<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=value%>" type="radio" name="callType" label="<%=label%>" checked='<%=(szCdIncomingCallType.equals(value)) ? "true" : "false"%>' cssClass="formInput" />
							</TD>
							<%
							  }
							%>
						</TR>
					</TABLE>

				</td>
			</tr>
		</table>

		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
			<tr class="subDetail">
				<th colspan="6">
					Special Call Type
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateSelect colspan="2" label="Non Incident Request Type" name="selSzCdNonIncReqType" tabIndex="<%=tabIndex++%>" 
					excludeOptions="<%=excludeOptions%>" codesTable="<%=CodesTables.CNIRTYPE%>" 
					onChange="clearDisposition();" blankValue="true"
						conditionallyRequired="true" value="<%=nonIncReqType%>" style="width:240px" />
				</td>
				<td>
					<impact:validateSelect colspan="4" label="Program Area" name="selSzCdStageClassification" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CCLASS%>" value="<%=programType%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateSelect colspan="6" label="Special Investigation" name="selSzCdSplInvest" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CSPECREQ%>" blankValue="true" value="<%=cdsplInvest%>"
						style="width:500px" conditionallyRequired="true"/>
				</td>

			</tr>

			<tr class="subDetail">
				<td>
					<impact:validateSelect colspan="6" label="Special Circumstances" name="selSzCdSplCircum" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CSPECCIR%>" blankValue="true" value="<%=cdsplCircum%>"
						style="width:240px" />
				</td>

			</tr>

			<tr class="subDetail">
				<th colspan="6">
					Reporter Information
				</th>
			</tr>
			<tr class="subDetail">
				<td width="17%">
					<impact:validateInput width="25%" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(callEntryData.getNmIncomingCallerLast())%>" type="text" name="txtNmIncomingCallerLast" label="Last" cssClass="formInput" size="22" maxLength="22"
						constraint="Name22" />
				</td>
				<td width="13%">
					<impact:validateInput width="15%" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(callEntryData.getNmIncomingCallerFirst())%>" type="text" name="txtNmIncomingCallerFirst" label="First" cssClass="formInput" size="12"
						maxLength="12" constraint="Name12" />
				</td>

				<td width="10%">
					<impact:validateInput width="15%" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(callEntryData.getNmIncomingCallerMiddle())%>" type="text" name="txtNmIncomingCallerMiddle" label="Middle" cssClass="formInput" size="12"
						maxLength="12" constraint="Name12" />
				</td>


			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateSelect label="Suffix" name="selCdIncomingCallerSuffix" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CSUFFIX%>" blankValue="true" value="<%=callEntryData.getCdIncomingCallerSuffix()%>" />
				</td>

				<td>
					<impact:validateSelect label="Gender" name="selszCdIncmgSex" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CSEX%>" blankValue="true" value="<%=callEntryData.getSzCdIncmgSex()%>" />
				</td>

				<td>
					<impact:validateSelect label="Reporter Type" name="selszCdIncmgCallerInt" tabIndex="<%=tabIndex++%>" orderBy="decode" codesTable="<%=CodesTables.CSRCRPTR%>" conditionallyRequired="true" blankValue="true" value="<%=callEntryData.getSzCdIncmgCallerInt()%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatPhone(callEntryData.getSzNbrIncomingCallerPhone())%>" type="text" name="txtSzNbrIncomingCallerPhone" label="Phone" cssClass="formInput" size="14" maxLength="14"
						conditionallyRequired="true" constraint="Phone" />
				</td>

				<td>
					<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(callEntryData.getSzNbrIncmgCallerExt())%>" type="text" name="txtSzNbrIncmgCallerExt" label="Ext." cssClass="formInput" size="8" maxLength="8"
						constraint="PhoneExtension" />
				</td>

				<td>
					<impact:validateSelect label="Phone Type" name="selSzCdIncmgPhoneType" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CPHNTYP%>" conditionallyRequired="true" blankValue="true" value="<%=callEntryData.getSzCdIncmgPhoneType()%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="6">
					<%
					  /* BEGIN Address Submodule */
					%>
					<%
					  AddressSubDB callEntryAddressSubDB = new AddressSubDB();
					        callEntryAddressSubDB.setFormName("frmCallInformation");
					        callEntryAddressSubDB.setPageMode(pageMode);
					        callEntryAddressSubDB.setAddressSubmoduleName("callEntryAddress");
					        callEntryAddressSubDB.setCommentsVisible(false);
					        callEntryAddressSubDB.setCommentsRequired(false);
					        callEntryAddressSubDB.setCommentsDisabled(true);
					        /* hadjimh:  street & zip are not required fields */
					        callEntryAddressSubDB.setStreetRequired(false);
					        callEntryAddressSubDB.setZipRequired(false);
					        callEntryAddressSubDB.setAddressRequired(false);
					        callEntryAddressSubDB.setAddressDisabled(pageMode.equals(PageModeConstants.VIEW));
					        callEntryAddressSubDB.setTabIndex(tabIndex);
					        // SMS #50402: Remove 'No County' Option
					        ArrayList<String> excludedCounties = new ArrayList<String>();
					        excludedCounties.add(CodesTables.CCOUNT_XXX);
					        callEntryAddressSubDB.setExcludeCounty(excludedCounties);
					        AddressSubDB.setIntoRequest(callEntryAddressSubDB, request);
					%>
					<%@ include file="/grnds-docs/common/AddressSub.jsp"%>
					<%
					  tabIndex = callEntryAddressSubDB.getTabIndex();
					        AddressSubDB.removeFromRequest(request);
					%>
					<%
					  /* END Address Submodule */
					%>
				</td>
			</tr>
			<tr class="subDetail"> 
				<td>
					<impact:validateSelect colspan="6" label="Address Type" name="selSzCdIncmgAddrType" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CADDRTYP%>" blankValue="true" conditionallyRequired="true"
						value="<%=callEntryData.getSzCdIncmgAddrType()%>" />
				</td>
			</tr>

			<%
			  String bConfExplained = FormattingHelper.formatString(callEntryData.getCIndCnfidntltyExplnd());
			%>
			<tr class="subDetail">
				<th colspan="6">
					Confidentiality Explanation:
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="6">
					Confidentiality Explained
					<impact:validateInput type="radio" label="Yes" id="ConfExpl_Yes" name="rdConfExpl" value="Y" cssClass="formInput" checked='<%=(bConfExplained.equals("Y")) ? "true" : "false"%>' tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="ConfExpl_No" name="rdConfExpl" value="N" cssClass="formInput" checked='<%=(bConfExplained.equals("N")) ? "true" : "false"%>' tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate colspan="6" label="Date of Explanation" name="dtCnfidntltyExplntn" value="<%=FormattingHelper.formatDate(dtCnfidntltyExplntn)%>" type="text" required="false" constraint="Date" size="8" tabIndex="<%=tabIndex++%>" />

				</td>

			</tr>

			<tr class="subDetail">
			
		</table>
	</impact:ExpandableSectionTag>

	<%
	  //  There are two sets of Save && Whatever's on the Call Information page.  When the page is in NEW mode
	      //  (the user has selected the phone icon but has not clicked the continue button) the user should still
	      //  have the option of Saving && Whatever.  If the call is an I&R or SPC they can Save && Whatever before
	      //  clicking the Continue button.  Since for many SPC's and I&R's the person list must be empty, this saves them
	      //  the trouble of having to delete the reporter information that automatically fills on the Call Person List when
	      //  they click the Continue button.
	      if (newIntake_withStageID) {
	%>

	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td width="70%">
				&nbsp;
			</td>
			<td width="10%">
				<impact:ButtonTag name="btnSaveAndClose1" img="btnSaveAndClose" align="right" form="frmCallInformation" action="/intake/CallInformation/saveAndCloseIntake" tabIndex="<%=tabIndex++%>" function="return saveAndCloseFunctions();" accessKey="O"
					restrictRepost="true" preventDoubleClick="true" backSafe="true" />
			</td>

			<td width="10%">
				<impact:ButtonTag name="btnSaveAndSubmit1" img="btnSaveAndSubmit" align="right" form="frmCallInformation" action="/intake/CallInformation/saveAndSubmitIntake" tabIndex="<%=tabIndex++%>"
					editableMode="<%=EditableMode.ALL - EditableMode.APPROVE - EditableMode.VIEW%>" function="return saveAndSubmitFunctions();" accessKey="B" restrictRepost="true" preventDoubleClick="true" backSafe="true" />
			</td>
     		<td width="10%">
				<impact:ButtonTag name="btnContinue" img="btnContinue" align="right" form="frmCallInformation" action="/intake/CallInformation/saveInitialCallEntry" function="return continueFunctions();" tabIndex="<%=tabIndex++%>" accessKey="S" restrictRepost="true"
					preventDoubleClick="true" backSafe="true" />
			</td>
		</tr>
	</table>
	<%
	  } else {
	%>
	<br>
	<%
	  }
	%>

	<%
	  // If this is !newIntake_withStageID (meaning there is a stage id and pageMode != new)
	      // the only expandable section that should be visible is Call Entry.
	      if (!newIntake_withStageID) {
	%>
	<%
	  //*******************************************************************************
	        //******************************** PERSON  ***********************************
	        //*******************************************************************************
	%>
	<impact:ExpandableSectionTag name="Person" id="" label="Person" tabIndex="<%=tabIndex++%>" isExpanded="true" accessKey="P">
		<%
		  /* This outer table is here to set the background color to white  */
		%>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td>
					<div class="alignRight">
						<div class="formInstruct">
							Scroll for more information --&gt;
						</div>
					</div>
					<div id="scrollBar2" style="height:210px;width:763px;overflow:auto" class="tableborderList">
						<table width="2200" cellspacing="0" cellpadding="3" border="0">
							<tr class="subDetail">
								<th class="thList" width="1%">
									&nbsp;
								</th>
								<th class="thList" width="2%">
									Type
								</th>
								<th class="thList" width="2%">
									Role
								</th>
								<th class="thList" width="5%">
									Name
								</th>
								<th class="thList" width="4%">
									Suffix
								</th>
								<th class="thList" width="4%">
									<nobr>
										Person ID
									</nobr>
								</th>
								<th class="thList" width="3%">
									DOB
								</th>
								<th class="thList" width="2%">
									Age
								</th>
								<th class="thList" width="2%">
									Gender
								</th>
								<th class="thList" width="2%">
									Relationship
								</th>
								<th class="thList" width="2%">
									Search
								</th>
								<th class="thList" width="2%">
									DOD
								</th>
								<th class="thList" width="3%">
									Reason For Death
								</th>
								<th class="thList" width="3%">
									SSN
								</th>
								<th class="thList" width="2%">
									Language
								</th>
								<th class="thList" width="2%">
									Race/Ethnicity
								</th>
							</tr>
							<%
							  loopCount = 0;
							          PersListRtrvStruct personListRow = null;
							          Enumeration personListEnum = personListArray.enumeratePersListRtrvStruct();
							          if (personListEnum == null || !(personListEnum.hasMoreElements())) {
							%>
							<tr class="odd">
								<td colspan="32">
									<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
								</td>
							</tr>
							<%
							  } else {
							            while (personListEnum.hasMoreElements()) {
							              personListRow = (PersListRtrvStruct) personListEnum.nextElement();
							%>
							<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
								<%-- Checkbox  --%>
								<%
								  String checkId = "cbxPerson_" + loopCount;
								%>
								<td>
									<impact:validateInput type="checkbox" value="<%=String.valueOf(loopCount)%>" id="<%=checkId%>" name="<%=checkId%>" tabIndex="<%=tabIndex++%>" />
								</td>
								<%
								  /* Type */
								%>
								<%
								  if ((personListRow.getSzCdStagePersRole() == null)
								                  || ("".equals(personListRow.getSzCdStagePersRole()))) {
								                personListRow.setSzCdStagePersType("");
								              }
								%>
								<td>
									<%=personListRow.getSzCdStagePersType()%>
								</td>
								<%
								  /* Role */
								%>
								<td>
									<%=personListRow.getSzCdStagePersRole() != null ? personListRow.getSzCdStagePersRole()
                                                                             : StringHelper.EMPTY_STRING%>
								</td>

								<%
								  /* Name */
								%>
								<td>
									<nobr>
										<%
										  if (personListRow.getBIndStagePersReporter().equals(IntakeConstants.INDICATOR_YES)) {
										%>
										<impact:validateInput type="hidden" name='<%="hdnReporter_" + loopCount%>' value="<%=IntakeConstants.PERSON_IS_REPORTER%>" />
										<font color="#FF0000"> <b>#</b></font>
										<%
										  }
										%>
										<a href="javascript:personListHyperlink('<%=loopCount%>');" onclick="setIsDirtyCalled(true); window.onBeforeUnload=null;" tabIndex="<%=tabIndex++%>"> <%
   if (personListRow.getSzNmPersonFull() != null && !("".equals(personListRow.getSzNmPersonFull()))) {
 %> <%=personListRow.getSzNmPersonFull()%> <%
   } else {
 %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%
   }
 %></a>
									</nobr>
								</td>
								<%
								  /* Suffix */
								%>
								<td>
									<nobr>
										<%=Lookup.simpleDecodeSafe(CodesTables.CSUFFIX, personListRow.getSzCdNameSuffix())%>
									</nobr>
								</td>

								<%
								  /* Person ID */
								%>
								<td>
									<nobr>
										<%=FormattingHelper.formatInt(personListRow.getUlIdPerson())%>
									</nobr>
								</td>
								<%
								  /* DOB */
								%>
								<td>
									<nobr>
										<%
										  if (!"Y".equals(personListRow.getBIndPersonDobApprox())) {
										%>
										<%=FormattingHelper.formatDate(personListRow.getDtDtPersonBirth())%>
										<%
										  }
										%>
									</nobr>
								</td>
								<%
								  /* Age */
								%>
								<td>
									<nobr>
										<%=FormattingHelper.formatInt(personListRow.getLNbrPersonAge())%>
									</nobr>
								</td>
								<%
								  /* Gender */
								%>
								<td>
									<nobr>
										<%=personListRow.getCCdPersonSex()%>
									</nobr>
								</td>
								<%
								  String relIntCodesTable = ((CodesTables.CPRSNTYP_PRN).equals(personListRow.getSzCdStagePersType())) ? CodesTables.CRELVICT
								                                                                                                                 : CodesTables.CSRCRPTR;
								%>
								<%
								  /* Rel/Int */
								%>
								<td>
									<nobr>
										<%=personListRow.getSzCdStagePersRelInt() != null ? personListRow
                                                                                               .getSzCdStagePersRelInt()
                                                                               : StringHelper.EMPTY_STRING%>
									</nobr>
								</td>

								<%
								  /* We want to calculate the appropriate value to display for the Search Indicator.  If a value was retrieved from
								                                                                                                               the database, we display it.  Otherwise we will check to see if there are search results in the session and
								                                                                                                               display "L" if there are. */
								%>
								<%
								  String personSearchInd = "";
								              if (personListRow.getSzCdStagePersSearchInd() != null
								                  && !"".equals(personListRow.getSzCdStagePersSearchInd())) {
								                personSearchInd = personListRow.getSzCdStagePersSearchInd();
								              } else {
								                String searchPerformedName = IntakeConstants.SEARCH_PERFORMED + personListRow.getUlIdPerson();
								                //String searchPerformed = (String) session.getAttribute(searchPerformedName);
								                String searchPerformed = (String) state.getContextParameter(searchPerformedName, request);
								                //AsynchCallBean searchResults = null;
								                PersonSearchOutRec searchResults = null;
								                if (!ArchitectureConstants.N.equals(searchPerformed)) {
								                  String searchResultsName = IntakeConstants.SEARCH_RESULTS + personListRow.getUlIdPerson();
								                  //searchResults = (AsynchCallBean) session.getAttribute(searchResultsName);
								                  //searchResults = (PersonSearchOutRec) session.getAttribute(searchResultsName);
								                  searchResults = (PersonSearchOutRec) state.getContextParameter(searchResultsName, request);
								                }
								                if (searchResults != null) {
								                  personSearchInd = "L";
								                }
								              }
								%>

								<%
								  /* SCH */
								%>
								<td>
									<%=FormattingHelper.formatString(personSearchInd)%>
								</td>


								<%
								  /* For each related person in the person list we build a hidden input called hdnPersonRelated_#.
								                                                                                                               When the user selects this a row, the metaphor looks for the value of hdnPersonRelated_# using
								                                                                                                               the selected index and uses this value to determine whether to display the Incoming Person Detail tab or not. */
								%>
								<%
								  if ((CodesTables.CSRCHSTA_R).equals(personListRow.getSzCdStagePersSearchInd())) {
								%>
								<impact:validateInput type="hidden" name='<%="hdnPersonRelated_" + loopCount%>' value="<%=IntakeConstants.PERSON_IS_RELATED%>" />
								<%
								  }
								%>
								<!-- 
<% /* AKA */ %>                <td><%=FormattingHelper.formatString(personListRow.getBScrIndAlias())%></td>
<% /* ID */ %>                 <td><%=FormattingHelper.formatString(personListRow.getBScrIndPersIdentifiers())%></td>
                                   <%
                                    String notesExist = IntakeConstants.INDICATOR_NO;
                                    if (!("".equals(FormattingHelper.formatString(
                                            personListRow.getSzTxtStagePersNotes()))))
                                    {
                                      notesExist = IntakeConstants.INDICATOR_YES;
                                    }
                                   %>
<% /* NTS */ %>                <td><%=notesExist%></td>
<% /* Law */ %>                <td><%=FormattingHelper.formatString(personListRow.getBIndStagePersInLaw())%></td>
<% /* Suffix */ %>             <td><nobr><%=Lookup.simpleDecodeSafe(CodesTables.CSUFFIX, personListRow.getSzCdNameSuffix())%></nobr></td>
                                   <%
                                   String addressExist = IntakeConstants.INDICATOR_NO;
                                   if ("More".equals(FormattingHelper.formatString(personListRow.getLScrNbrOfAddrs())))
                                   {
                                     addressExist = IntakeConstants.INDICATOR_YES;
                                   }
                                  %>
<% /* subAddress Exists */ %>  <td><%=addressExist%></td>
<% /* Type */ %>               <td><nobr><%=Lookup.simpleDecodeSafe(CodesTables.CADDRTYP, personListRow.getSzCdPersAddrLinkType())%></nobr></td>
<% /* Street */ %>             <td><nobr><%=FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn1())%></nobr></td>
<% /* Street[2] */ %>          <td><nobr><%=FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn2())%></nobr></td>
<% /* City */ %>               <td><nobr><%=FormattingHelper.formatString(personListRow.getSzAddrCity())%></nobr></td>
<% /* County */ %>             <td><nobr><%=FormattingHelper.initCaps(Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                personListRow.getSzCdAddrCounty()))%></nobr></td>
<% /* State */ %>              <td><nobr><%=Lookup.simpleDecodeSafe(CodesTables.CSTATE, personListRow.getSzCdAddrState())%></nobr></td>
<% /* Zip */ %>                <td><nobr><%=FormattingHelper.formatString(personListRow.getLAddrZip())%></nobr></td>
                                   <%
                                     String phonesExist = IntakeConstants.INDICATOR_NO;
                                  if ("More".equals(FormattingHelper.formatString(personListRow.getLScrNbrPhoneNbrs())))
                                  {
                                    phonesExist = IntakeConstants.INDICATOR_YES;
                                  }
                                  %>
<% /* Phn */ %>                <td><%=phonesExist%></td>
<% /* Type */ %>               <td><nobr><%=Lookup.simpleDecodeSafe(CodesTables.CPHNTYP, personListRow.getSzCdPhoneType())%></nobr></td>
<% /* Phone */ %>              <td><nobr><%=FormattingHelper.formatPhone(personListRow.getLNbrPhone())%></nobr></td>
<% /* Ext */ %>                <td><nobr><%=FormattingHelper.formatString(personListRow.getLNbrPhoneExtension())%></nobr></td>
 -->
								<%
								  /* DOD */
								%>
								<td>
									<nobr>
										<%=FormattingHelper.formatDate(personListRow.getDtDtPersonDeath())%>
									</nobr>
								</td>
								<%
								  /* Reason */
								%>
								<td>
									<nobr>
										<%=Lookup.simpleDecodeSafe(CodesTables.CRSNFDTH, personListRow.getSzCdPersonDeath())%>
									</nobr>
								</td>
								<%
								  /* SSN */
								%>
								<td>
									<nobr>
										<%=FormattingHelper.formatSSN(personListRow.getSzNbrPersonIdNumber())%>
									</nobr>
								</td>
								<!--<% /* MAR */ %>                <td><nobr><%=Lookup.simpleDecodeSafe(CodesTables.CMARSTAT, personListRow.getSzCdPersonMaritalStatus())%></nobr></td>-->
								<%
								  /* Lng */
								%>
								<td>
									<nobr>
										<%=Lookup.simpleDecodeSafe(CodesTables.CLANG, personListRow.getSzCdPersonLanguage())%>
									</nobr>
								</td>
								<%
								  /* Eth */
								%>
								<td>
									<nobr>
										<%=FormattingHelper.formatString(personListRow.getSzCdPersonEthnicGroup())%>
									</nobr>
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
			
				<td width="85%">
          			<impact:ButtonTag name="btnDeleteFromList" img="btnDelete" align="left" form="frmCallInformation" action="/intake/CallInformation/deleteCallPersonFromList" function="return deleteCallPersonConfirm();" tabIndex="<%=tabIndex++%>" accessKey="D"
            		restrictRepost="true" />
        		</td>
        		
				<td width="80%">
					<impact:ButtonTag name="btnNewUsing" img="btnNewUsing" align="right" form="frmCallInformation" action="/intake/CallInformation/newUsingCallPersonDetail" tabIndex="<%=tabIndex++%>" accessKey="U" />
				</td>

				<td width="5%">
					<impact:ButtonTag name="btnDetail" img="btnDetail" align="right" form="frmCallInformation" action="/intake/CallInformation/displayCallPersonDetail" tabIndex="<%=tabIndex++%>" />
				</td>


				<td width="5%">
					<impact:ButtonTag name="btnAdd" img="btnAdd" align="left" form="frmCallInformation" action="/intake/CallInformation/displayCallPersonDetail" tabIndex="<%=tabIndex++%>" accessKey="N" />
				</td>

				<td width="5%">
					<impact:ButtonTag name="btnUnrelate" img="btnUnrelate" align="left" form="frmCallInformation" action="/intake/CallInformation/unrelatePerson" tabIndex="<%=tabIndex++%>" accessKey="L" />
				</td>

				<td width="5%">
					<impact:ButtonTag name="btnViewSearch" img="btnViewSearch" align="left" form="frmCallInformation" action="/intake/CallInformation/viewPersonSearch" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<br>
	<%
	  //*******************************************************************************
	        //******************************** FACILITY  ***********************************
	        //*******************************************************************************
	        // This section may add in future
	%>
	<impact:validateInput type="hidden" name="idResource" value="<%=FormattingHelper.formatInt(facilityData.getUlIdResource())%>" />
	<impact:validateInput type="hidden" name="destinationUrl" value="/intake/CallInformation/setFacilityResource" />
    <impact:validateInput type="hidden" name="hdnUlIdHomeCase"/>
    <impact:validateInput type="hidden" name="hdnUlIdHomeStage"/>
    
	<impact:ExpandableSectionTag name="Placement/Non-Placement Provider" id="txtNmIncmgFacilName" label="&#135; Placement/Non-Placement Provider" tabIndex="<%=tabIndex++%>" isExpanded="false" accessKey="F">
		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		    <tr class="subDetail">
				<th colspan="5">
					Provider Search <i style="color:red">If maltreatment occurs in a non-DFCS F/A Home, the Provider name should never be the name of a Child Placing Agency, but the name of the F/A Home.</i>
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateInput width="30%" tabIndex="<%=tabIndex++%>" 
					type="text" name="txtNmIncmgFacilNameSearch" label="Provider Name" cssClass="formInput" size="40"
						maxLength="40" constraint="Paragraph40" />
				</td>
                <%//Set up the exclude array.
                   ArrayList<String> excludeOptionsProviderTypeS = new ArrayList<String>(); 
                   excludeOptionsProviderTypeS.add(CodesTables.CFACTYP4_CP);
                %>
				<td>
					<impact:validateSelect tabIndex="<%=tabIndex++%>" name="selResourceFacilityTypeSearch" codesTable="CFACTYP4" label="Provider Type" excludeOptions="<%=typeExclusionSet%>" onChange="populateFacilityType()" blankValue="true" 
					excludeOptions="<%=excludeOptionsProviderTypeS%>" />

				</td>


				<%
				  String searchPerformed = FormattingHelper.formatString(facilityData.getBIndIncmgFacilSearch());
				%>
				<impact:validateInput type="hidden" name="hdnBIndIncmgFacilSearch" value="<%=searchPerformed%>" />
				<td>
					<table cellspacing="0" cellpadding="3" width="100%" border="0">
  						<tr>
    						<td align="right">
      						<impact:ButtonTag name="btnFacilitySearch"
                        						backSafe="true"
                        						img="btnSearch"
                       							 align="right"
                       							 form="frmCallInformation"
                        						action="/intake/CallInformation/getFacilityResource"
                        						tabIndex="<%=tabIndex++%>"/>
    			</td>
 

							<td>
								&nbsp;
								<%
								  if ("Y".equals(searchPerformed)) {
								%>
								<img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif">
								<%
								  }
								%>
							</td>
						</tr>
					</table>
				</td>
			</tr>		
			<tr class="subDetail" >
               <td>
					<impact:validateInput tabIndex="<%=tabIndex++%>"
                                type="text"
                                label="Resource ID"
                                name="txtResourceId"
                                constraint="Digit16Less"
                                maxLength="16"
                                size="16"/>
				</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>									
			<tr class="subDetail">
				<th colspan="5">
					General Information
				</th>
			</tr>
			<!-- CAPTA 4.3 Provider Allegation hyperlink, display only when resource is linked to the intakeS -->
			<%if(facilityData.getUlIdResource() != 0) { %>
			   <tr class="subDetail">
			    <td colspan="5">
			       <a href="javascript:submitProviderAllegationHistory('<%=facilityData.getUlIdResource()%>')" tabIndex='<%=tabIndex++%>'>
			     	Provider Allegation History
			     	</a>
              </td>
              </tr>
              <% } 
              %>
              
              <tr class="subDetail">
			    <td>
			    
					<impact:validateInput width="30%" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(facilityData.getNmIncmgFacilName())%>" type="text" name="txtNmIncmgFacilName" label="Provider Name" conditionallyRequired="true" cssClass="formInput" size="40"
						maxLength="40" constraint="Paragraph40" />
				</td>
                <td>
				 <impact:validateDisplayOnlyField
                  name="dispResourceId"
                  label="Resource ID"
                  value=""
                />
                <a onclick="setIsDirtyCalled(true);" href="javascript:submitResourceID('<%=facilityData.getUlIdResource()%>', '<%=facilityData.getUlIdHomeStage()%>')" tabIndex='<%=tabIndex++%>'>
                <%=FormattingHelper.formatInt(facilityData.getUlIdResource())%>
                </a>
			   </td>

				<td></td>
			</tr>

			<tr class="subDetail">
				<td>
					<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(facilityData.getSzNmIncmgFacilAffiliated())%>" type="text" name="txtSzNmIncmgFacilAffiliated" label="Affiliated" cssClass="formInput" size="40" maxLength="40"
						constraint="Paragraph40" />
				</td>

				<td>
					<impact:validateSelect colspan="2" label="Operated By" name="selSzCdIncFacilOperBy" tabIndex="<%=tabIndex++%>" codesTable="<%=CodesTables.CERTIFBY%>" blankValue="true" value="<%=facilityData.getSzCdIncFacilOperBy()%>" />
				</td>
			</tr>
			<%//Set up the exclude array.
                   ArrayList<String> excludeOptionsProviderType = new ArrayList<String>(); 
                   if(!CodesTables.CFACTYP4_CP.equals(facType)){
                     excludeOptionsProviderType.add(CodesTables.CFACTYP4_CP);
                 }%>
			<tr class="subDetail">
				<td>
					<impact:validateSelect label="Provider Type" name="selSzCdIncmgFacilType" codesTable="CFACTYP4" tabIndex="<%=tabIndex++%>" blankValue="true" value="<%=facType%>" style="WIDTH: 200px" 
					excludeOptions="<%=excludeOptionsProviderType%>"/>
				</td>

				<td>
					<impact:validateInput colspan="2" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(facilityData.getSzNmIncmgFacilSuprtdant())%>" type="text" name="txtSzNmIncmgFacilSuprtdant" label="Contact Person" cssClass="formInput" size="40"
						maxLength="40" constraint="Paragraph40" />
				</td>
			</tr>
			
			<tr class="subDetail">
				<th colspan="5">
					Provider Address
				</th>
			</tr>
			
			<tr class="subDetail">
				<td colspan="5">
					<%
					  /* BEGIN Address Submodule */
					%>
					<%
					  AddressSubDB facilityAddressSubDB = new AddressSubDB();
					          facilityAddressSubDB.setFormName("frmCallInformation");
					          facilityAddressSubDB.setPageMode(pageMode);
					          facilityAddressSubDB.setAddressSubmoduleName("facilityAddress");
					          facilityAddressSubDB.setCommentsVisible(false);
					          facilityAddressSubDB.setCommentsRequired(false);
					          facilityAddressSubDB.setCommentsDisabled(true);
					          facilityAddressSubDB.setAddressRequired(false);
					          facilityAddressSubDB.setAddressDisabled(pageMode.equals(PageModeConstants.VIEW));
					          facilityAddressSubDB.setTabIndex(tabIndex);
					          AddressSubDB.setIntoRequest(facilityAddressSubDB, request);
					%>
					<%@ include file="/grnds-docs/common/AddressSub.jsp"%>
					<%
					  tabIndex = facilityAddressSubDB.getTabIndex();
					          AddressSubDB.removeFromRequest(request);
					%>
					<%
					  /* END Address Submodule */
					%>
				</td>
			</tr>
			<tr class="subDetail">
				<th colspan="5">
					Provider Phone
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatPhone(facilityData.getSzNbrIncmgFacilPhone())%>" type="text" name="txtSzNbrIncmgFacilPhone" label="Phone" cssClass="formInput" size="14" maxLength="14"
						constraint="Phone" />
				</td>

				<td>
					<impact:validateInput colspan="2" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(facilityData.getSzNbrIncmgFacilPhoneExt())%>" type="text" name="txtSzNbrIncmgFacilPhoneExt" label="Ext." cssClass="formInput" size="4"
						maxLength="4" constraint="PhoneExtension" />
				</td>
			</tr>
		</table>

		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
			<tr class="subDetail">
				<th colspan="5">
					Additional Details
				</th>
			</tr>
			<tr class="subDetail">
				<td width="30%">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr class="subDetail">
							<%
							  String offGrounds = FormattingHelper.formatString(facilityData.getBIndIncmgOnGrnds());
							%>
							<td colspan="2">
								<impact:validateInput label="Abuse Off Grounds" type="checkbox" checked='<%=(("".equals(offGrounds)) || ("N".equals(offGrounds))) ? "false" : "true"%>' value="Y" name="cbxBIndIncmgOnGrnds" tabIndex="<%=tabIndex++%>" />
							</td>
						</tr>
						<tr class="subDetail">
							<%
							  String unsupervised = FormattingHelper.formatString(facilityData.getBIndIncmgFacilAbSupvd());
							%>
							<td colspan="2">
								<impact:validateInput label="Unsupervised" type="checkbox" checked='<%=(("".equals(unsupervised)) || ("N".equals(unsupervised))) ? "false" : "true"%>' value="Y" name="cbxBIndIncmgFacilAbSupv" tabIndex="<%=tabIndex++%>" />
							</td>
						</tr>
						<tr class="subDetail">
							<td>
								<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(facilityData.getSzNmUnitWard())%>" type="text" name="txtSzNmUnitWard" label="Unit/Ward" cssClass="formInput" size="15" maxLength="15" constraint="Any15" />
							</td>
						</tr>
					</table>
				</td>
				<td>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr class="subDetail">
							<td colspan="2">
								Special Instructions (Hrs. of Op., Pop. served, Etc.)
							</td>
						</tr>
						<tr class="subDetail">
							<td>
								<impact:validateTextArea name="txtSzTxtFacilCmnts" rows="4" cols="65" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Paragraph300">
									<%=FormattingHelper.formatString(facilityData.getSzTxtFacilCmnts())%>
								</impact:validateTextArea>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>

	<hr>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td width="70%">
				&nbsp;
			</td>

			<td width="10%">
				<impact:ButtonTag name="btnSaveAndClose" img="btnSaveAndClose" align="right" form="frmCallInformation" action="/intake/CallInformation/saveAndCloseIntake" tabIndex="<%=tabIndex++%>" function=" return saveAndCloseFunctions();" restrictRepost="true"
					preventDoubleClick="true" accessKey="O" />
			</td>
			<% if(!approvalMode){ 
			%>
			<td width="10%">
				<impact:ButtonTag name="btnSaveAndSubmit" img="btnSaveAndSubmit" align="right" form="frmCallInformation" action="/intake/CallInformation/saveAndSubmitIntake" tabIndex="<%=tabIndex++%>"
					editableMode="<%=EditableMode.ALL - EditableMode.APPROVE - EditableMode.VIEW%>" function="return saveAndSubmitFunctions();" restrictRepost="true" preventDoubleClick="true" accessKey="B" />
			</td>
			<%
			  }
			%>

			<td width="10%">
				<impact:ButtonTag name="btnContinue" img="btnContinue" align="right" form="frmCallInformation" action="/intake/CallInformation/saveCallInformation" tabIndex="<%=tabIndex++%>" function="return saveFunctions();" restrictRepost="true"
					preventDoubleClick="true" accessKey="S" />
			</td>
		</tr>


	</table>

	<%
	  /* Close the if statement that hides Person, Facility and Buttons when we are in NEW mode  */
	%>
	<%
	  }
	%>

	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
  //************************
    //**** FORM ENDS HERE ****
    //************************
%>
<%
  // If this is !newIntake_withStageID (meaning there is a stage id and pageMode != new)
    // the only expandable section that should be visible is Call Entry.
    if (!newIntake_noStageID) {
%>
<impact:documentButton pageMode="<%=pageMode%>" buttonUrl="/grnds-docs/images/shared/btnNarrative.gif" tabIndex="<%=tabIndex++%>" accessKey="W">

	<impact:document displayName="Intake Narrative" protectDocument="<%=!PageModeConstants.VIEW.equals(pageMode) ? false : true%>" checkForNewMode="false" docType="callnarr" windowName="<%=String.valueOf(GlobalData.getUlIdStage(request))%>"
		docExists="<%=((ArchitectureConstants.Y).equals(request.getAttribute(IntakeConstants.NARRATIVE_EXISTS)))%>">
		<impact:documentParameter name="sStage" value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
	</impact:document>
</impact:documentButton>
<%
  }
%>

<script type="text/javascript" language="JavaScript1.2">
<%
// If we are in view mode of new mode, we want to call the javascript function onload of the
// page that will expand the call entry section.
boolean expandEntry = false;
if (pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.NEW))
{
  expandEntry = true;
%>
   collapseExpanded('collapsedEntry', 'expandedEntry');
<%
}
%>

<%--
// This function is called when the user leaves the Call Information page.  It sets the value of the hidden
// field hdnIsCallInfoDirty to the return of the isPageChanged() function.  The value of this hidden field is used in the
// Intake Actions display.  If hdnIsCallInfoDirty == true the Call Information Save is called.  We also
// have to check to see if the last action the user performed was a Resource Search.  If that is the case,
// we always want to save since populating the Facility section using the Resource Search will not
// set the page to dirty.
--%>
document.frmCallInformation.attachEvent('onsubmit', navAway);
 function navAway()
 {
   document.frmCallInformation.hdnIsCallInfoDirty.value = isPageChanged();
   if (document.frmCallInformation.hdnResourceSearch.value == "true" ||
       document.frmCallInformation.hdnAddressValidation.value == "true")
   {
        document.frmCallInformation.hdnIsCallInfoDirty.value = "true";
   }
   
   if (isDirtyCalled)
   {
   	document.frmCallInformation.hdnIsSetIsDirtyCalled.value = "<%= ArchitectureConstants.Y %>";
   }
 }
 
 

</script>


<%
  }
%>

