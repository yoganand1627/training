<%
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  6/12/08   cwells			  STGAP00007985: If the plan is being copied then we want the dates to be  
//**							  enabled.
//**  07/30/08  cwells            STGAP00006201: Updating the Next Review date when the current review date is changed
//**  09/12/08  mxpatel           STGAP00009284 and STGAP000010088: changed the javascript function to getFullYear() 
//**                              instead of getYear() (as getYear() is not Y2K compliant).
//**  11/12/08  arege             STGAP00010758 Modified code so that the SaveAndSubmit button is not displayed for the 
//**                              Supervisor in approval mode.
//**  12/02/09  bgehlot           41275 MR-057 APPLA changes
//**  01/25/10  bgehlot           44337 MR-057 Concurrent Permanency Plan Type validation needs to allow court ordered selections
//**  05/07/10  wjcochran         SMS #51193: Save and Submit button was not working for After Care Case Plans. Added logic
//**                              to replace this button with a button that did not make use of the new javascript function.
//**  08/03/10  bgehlot           SMS# 65400 MR-068 Change the Assigned Judge Text field to a Drop Down List
//**  10/11/11  hnguyen           STGAP00017012: MR-094 Added alert to notify case manager and approver that at least one of the
//**                              principal children does not any current visitation plan.
//**                              STGAP00017323: MR-094 correct js function to return false on cancel of alert not on exit of function
//**                              because no missing current visitation plan.
//**  10/26/11  hnguyen           STGAP00017370: MR-094 Updated alert message for current visitation to include instructions.
//**  10/26/11  hnguyen           STGAP00017376: Removed bypass criteria for current visitation plan if principal is a caretaker.
//**                              The child could be his/her own caretaker to bypass is invalid. We are looking at PC across the case
//**                              for the validation regardless if they are caretaker.
//**  
%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO.RowPlanPrincipal"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FCCPFamilyDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.ArrayList"%>

<%
	//*******************************
	//*** DECLARE LOCAL CONSTANTS ***
	//*******************************

	//*******************************
	//*** DECLARE LOCAL VARIABLES ***
	//*******************************
	@SuppressWarnings( { "unchecked" })
	int loopCounter = 0;
	int tabIndex = 1;
	int idEvent = 0;
	String casePlanMode = null;
	String fieldsToBeSpellChecked = "txtPPPRsns, txtSPPRsns, txtRsnsChildNotHome, txtHarmChildLeftHome, txtNoParentPart, txtNoChildPart";
	String pageMode = PageModeConstants.VIEW;
	String cdStage = null;
	boolean docExists = false;
	boolean isDisabled = false;
	boolean isViewMode = false;
	boolean isReviewPlan = false;
	boolean isInitialPlan = false;
	boolean isDatesLocked = false;
	boolean protectDoc = false;
	//boolean formDocExists = false;

	List<RowPlanPrincipal> listPrincipals = null;
	List<RowPlanPrincipal> listPrimaryChildren = null;
	Map principalsForEventHashmap = null;
	java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat(
			"MM/dd/yyyy");
	Iterator iter = null;
	String dateAsString = null;
	String intAsString = null;
	String codeAsString = null;
	int editableMode = EditableMode.NEW + EditableMode.MODIFY;
	String dtSzInitialDueDate = "";
	String szCReqFuncCd = "";
	boolean isUpdateMode = false;
	boolean isNewUsingMode = false;
	boolean isAddMode = false;
	//MR-068 Assigned Judge remains modifiable even after approving FCCP Case Plan
	//This is Temporary till the clean up process for Assigned Judges is done.
	boolean assignedJudgeDisabled = false;

	String cdPlanType = FCCPFamilyDetailConversation.DEFAULT_STRING;
	String cdPlanTypeAsString = FCCPFamilyDetailConversation.DEFAULT_STRING;

	//**************************
	//*** RETRIEVE PAGE DATA ***
	//**************************
	BaseSessionStateManager state = (BaseSessionStateManager) request
			.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
	UserProfile user = UserProfileHelper.getUserProfile(request);

	FCCPFamilyDetailSO fccpFamilyDetailSO = (FCCPFamilyDetailSO) state
			.getAttribute("CASE_PLAN_FAMILY", request);
	boolean btnEdit = (Boolean) state.getAttribute(
			"BTN_UPDATE_CLICKED", request);
	listPrimaryChildren = (List<RowPlanPrincipal>) fccpFamilyDetailSO
			.getPrincipalsForForm();
	listPrincipals = (List<RowPlanPrincipal>) fccpFamilyDetailSO
			.getPrincipalsForStage();
	principalsForEventHashmap = new HashMap();
	if (fccpFamilyDetailSO.getPrincipalsForEvent() != null) {
		iter = fccpFamilyDetailSO.getPrincipalsForEvent().iterator();
		while (iter.hasNext()) {
			RowPlanPrincipal person = (RowPlanPrincipal) iter.next();
			principalsForEventHashmap.put(person.getIdPerson(), person
					.getIsCaregiver());
		}
	}
	cdPlanType = fccpFamilyDetailSO.getSelCrtPlanType();
	casePlanMode = request.getParameter("hdnCasePlanMode");
	if (StringHelper.isValid(cdPlanType)) {
		casePlanMode = cdPlanType;
	}
	if (!StringHelper.isValid(cdPlanType)
			&& StringHelper.isValid(casePlanMode)) {
		cdPlanType = casePlanMode;
	}

	cdStage = GlobalData.getSzCdStage(request);
	idEvent = GlobalData.getUlIdEvent(request);
	isInitialPlan = FCCPFamilyDetailConversation.INITIAL
			.equalsIgnoreCase(fccpFamilyDetailSO.getRbDatesType());
	isReviewPlan = FCCPFamilyDetailConversation.REVIEW
			.equalsIgnoreCase(fccpFamilyDetailSO.getRbDatesType());
	//*********************
	//*** SET PAGE MODE ***
	//*********************
	pageMode = PageMode.getPageMode(request);
	isUpdateMode = Sets.isInSet(Sets.E, request)
			|| fccpFamilyDetailSO.isUpdatedPlan();
	isNewUsingMode = PageModeConstants.NEW_USING.equals(pageMode)
			|| Sets.isInSet(Sets.C, request);
	if (PageModeConstants.VIEW.equals(pageMode)) {
		isViewMode = true;
		editableMode = EditableMode.NONE;
		isDisabled = true;
		protectDoc = true;
		//MR-068 Disable assigned judge for the User who does not have stage access.
        int ulIdStage = GlobalData.getUlIdStage(request);
        int userID = UserProfileHelper.getUserProfile(request).getUserID();
        if (!CaseUtility.hasStageAccess(userID, ulIdStage)) {
          assignedJudgeDisabled = true;
        }else{
          assignedJudgeDisabled = false;
        }
	}
	if (GlobalData.getUlIdEvent(request) == 0 && !isUpdateMode
			&& !isNewUsingMode) {
		isAddMode = true;
	}
	// STGAP00007985  If we are copying the FccpFamily Detail Page then The Date section should be Edit 
	if(isUpdateMode || PageModeConstants.VIEW.equals(pageMode)){
	   if(!isNewUsingMode){
	isDatesLocked = true;
	   }
	}
	
	//MR-057 APPLA changes
	List<String> excludePrimaryPlanList = new ArrayList<String>();
	if(request.getAttribute("excludePrimaryPlanList") != null){
	   excludePrimaryPlanList = (List<String>)request.getAttribute("excludePrimaryPlanList");
	} else{
	   // if case mode is REU then remove all the options other than Re-unification from drop down
	  if (StringHelper.isValid(casePlanMode) && (CodesTables.CCTPLNTY_REU.equals(casePlanMode))) {
		excludePrimaryPlanList.add(CodesTables.CPERMPLN_LAE);
		excludePrimaryPlanList.add(CodesTables.CPERMPLN_FCO);
		excludePrimaryPlanList.add(CodesTables.CPERMPLN_ADA);
		excludePrimaryPlanList.add(CodesTables.CPERMPLN_GDS);
		excludePrimaryPlanList.add(CodesTables.CPERMPLN_LLR);
      }else if(CodesTables.CCTPLNTY_NRE.equals(casePlanMode)){ // if case mode is NRE then remove the Re-unification from drop down
        excludePrimaryPlanList.add(CodesTables.CPERMPLN_RUI);
      }
    }
    
%>
<%
	//******************
	//*** JAVASCRIPT ***
	//******************
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

  
window.onload = function ()
{
  defaultREUConcurrent();
}
// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
};

function changeCasePlanMode()
{
    var casePlanMode = eval("document.frmFCCPFamilyDetail.selCrtPlanType.value");
    disableValidation("frmFCCPFamilyDetail");
    document.frmFCCPFamilyDetail.hdnCasePlanMode.value=casePlanMode;
    submitValidateForm("frmFCCPFamilyDetail", "/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
} 

function changeCasePlanModeOnly()
{
    var casePlanMode = eval("document.frmFCCPFamilyDetail.selCrtPlanType.value");
    document.frmFCCPFamilyDetail.hdnCasePlanMode.value=casePlanMode;
}

function updateCasePlanMode() {
   return   eval("document.frmFCCPFamilyDetail.selCrtPlanType.value");
}

// This function serves to prevent entering a future date in the Date
// Current Review date field. It will generate value for the Next Review Date field
// if that field has never been filled.

function futureDateInvalid( field )
{
  if ( field.value != "")
  {
    var dtNextReviewField = eval(document.getElementById("dtNextReview_Id"));
    var startingDateAsString = validateDateString( field.value );
    var fieldName = "document.frmFCCPFamilyDetail."+field.name;
    var validValue = "document.frmFCCPFamilyDetail."+fieldName+".value = "+"startingDateAsString;";
    var refocus = "document.frmFCCPFamilyDetail."+fieldName+".blur();";
    var reselect = "document.frmFCCPFamilyDetail."+fieldName+".select();";
    var today = new Date();
    // If input is invalid, pop message, blank field value, put cursor back in field.
    if ( startingDateAsString == "INVALID" ||
       (new Date( Date.parse(startingDateAsString) ) > today ) )
    {
      alert('<%=MessageLookup
									.getMessageByNumber(Messages.MSG_FP_DATE_BEFORE_SAME_CURR)%>');
      eval(refocus); eval(reselect);
    }
    // If the input value is a valid date, put in the validated format.
    else
    {
      eval(validValue);
      // Only if Next Review Date is blank is it autofilled. 
      if ( dtNextReviewField.value == "" )
      {
        autofillNextReviewDue(startingDateAsString);
      }
    }
  }
}

function futureDateOrigSubInvalid( field )
{
  if ( field.value != "")
  {
    var startingDateAsString = validateDateString( field.value );
    var fieldName = "document.frmFCCPFamilyDetail."+field.name;
    var validValue = "document.frmFCCPFamilyDetail."+fieldName+".value = "+"startingDateAsString;";
    var refocus = "document.frmFCCPFamilyDetail."+fieldName+".blur();";
    var reselect = "document.frmFCCPFamilyDetail."+fieldName+".select();";
    var today = new Date();
    // If input is invalid, pop message,blank field value, put cursor back in field.
    if ( startingDateAsString == "INVALID" ||
       (new Date( Date.parse(startingDateAsString) ) > today ) )
    {
      alert('<%=MessageLookup
									.getMessageByNumber(Messages.MSG_FP_DATE_BEFORE_SAME_CURR)%>');
      eval(refocus); eval(reselect);
    }
    // If the input value is a valid date, put in the validated format.
    else
    {
      eval(validValue);
      //document.frmFCCPFamilyDetail.hdnDtOrgSub.value = field.value;alert(document.frmFCCPFamilyDetail.hdnDtOrgSub.value);
    }
  }
  document.frmFCCPFamilyDetail.hdnDtOrgSub.value = field.value;
}

// This function auto-fills the Next Review Due date field is followed:
// It is 6 months from the 'starting date'
// Starting Date is Date of Removal if Date type is Initial
// Starting Date is Current Review Date if Date type is Review 
function autofillNextReviewDue(startingDateAsString)
{
  var startingDateInMilliseconds = Date.parse( startingDateAsString );
  var nextReviewDate = new Date( startingDateInMilliseconds );
  var today = new Date();
  var dtNextReviewField = eval(document.getElementById("dtNextReview_Id"));
    
  nextReviewDate.setMonth( nextReviewDate.getMonth() + 6 );
  
 <%//mxpatel changed the .getYear to .getFullyear this out for defect #9284 and 10088%>
 dtNextReviewField.value = (nextReviewDate.getMonth()+1)   + "/" +nextReviewDate.getDate()   + "/" +nextReviewDate.getFullYear();
  document.frmFCCPFamilyDetail.hdnDtNextReview.value = (nextReviewDate.getMonth()+1) + "/" +nextReviewDate.getDate() + "/" +nextReviewDate.getFullYear();
 
 
 
 
 
}

// called by onChange from Next Review Date field
function updateHdnDtNextReview(field) {
  document.frmFCCPFamilyDetail.hdnDtNextReview.value = field.value;
}

// to update dtNextReview field's status based on what plan date type is selected
function updateDtNextReview() 
{
  if (document.frmFCCPFamilyDetail.hdnCasePlanMode.value != 'AFC')
  {
    var dtNextReviewField = eval("document.frmFCCPFamilyDetail.dtNextReview.value");
    var dtOrgSubField = eval(document.getElementById("dtOrgSub_Id"));
    var dtCurrentReviewDate = eval("document.frmFCCPFamilyDetail.dtCurReview.value");
    var initial, review;
    try {
      initial = document.frmFCCPFamilyDetail.rbDatesType[0];
      review = document.frmFCCPFamilyDetail.rbDatesType[1];
    } catch(e) {
      return;
    }
    
    // Initial is selected
    if (initial.checked)
    { 
      if ( document.frmFCCPFamilyDetail.dtNextReview.type != "hidden" ) {
        disableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtNextReview );
      }
      autofillNextReviewDue("<%=FormattingHelper.formatDate(fccpFamilyDetailSO
							.getDtRemoval())%>");
      enableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtOrgSub );
    }
    // plan is Review, enable field only, date review will be calculated when Current Review date is actually entered
    else if (review.checked)
    {
        enableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtNextReview );
        if ( document.frmFCCPFamilyDetail.dtOrgSub.type != "hidden" ) {
          disableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtOrgSub );
        }
        // STGAP00006201 When the Current Review date is selected then 
        // the next review date is set for 6 months ahead of the current review date
        if(dtCurrentReviewDate != ''){
        autofillNextReviewDue( dtCurrentReviewDate );
        }
    }
  }
  
}

function updateDtOrigSub() {
  var dtOrgSubField = eval(document.getElementById("dtOrgSub_Id"));
  document.frmFCCPFamilyDetail.hdnDtOrgSub.value = dtOrgSubField.value;
}

// future enhancement - to clear the preset dtNextReview when changed from Initial to Review so user
// won't have to guess whether dtNextReview field has to be blank for the auto fill function to work
// should be called in onChange for radio button plan date type
function clearDtReviewField() {
  var dtNextReviewField = eval(document.getElementById("dtNextReview_Id"));
  dtNextReviewField.value = '';
}

function cancelValidation ()
{
  disableValidation('frmFCCPFamilyDetail');
  return true;
}
//MR-057 APPLA Changes
function getChildCurrentPlacement(idPlacementEvent)
{
  frmFCCPFamilyDetail.hdnIdPlacementEvent.value = idPlacementEvent;
  submitValidateForm( "frmFCCPFamilyDetail", "/serviceDelivery/FCCPFamilyDetail/displayPlacementInformation" );
}

/* MR-057 APPLA This function defaults the Primary Plan to Reunification for Reunification Plan Type*/
function defaultREUConcurrent(){
 if (document.frmFCCPFamilyDetail.selCrtPlanType != null && document.frmFCCPFamilyDetail.selPPP != null &&
    (document.frmFCCPFamilyDetail.selPPP.value == null || document.frmFCCPFamilyDetail.selPPP.value == "" || 
     document.frmFCCPFamilyDetail.hdnBPlanTypeChange.value == 'true')) {
  if(document.frmFCCPFamilyDetail.selCrtPlanType.value == 'REU'|| document.frmFCCPFamilyDetail.selCrtPlanType.value == 'CON'){
    document.frmFCCPFamilyDetail.selPPP.value = '<%= FormattingHelper.formatString(CodesTables.CPERMPLN_RUI)%>';
  }else if (document.frmFCCPFamilyDetail.selCrtPlanType.value == 'NRE'){
    if(document.frmFCCPFamilyDetail.selPPP.value == 'RUI'){
      document.frmFCCPFamilyDetail.selPPP.value = '';
    }
  }
 }
}

/* MR-057 APPLA This function sets the hidden variable to true so that it can be used in conversation for creating exclude lists*/
function submitFormOnPlanTypeChange(){
 if (document.frmFCCPFamilyDetail.selCrtPlanType != null && document.frmFCCPFamilyDetail.selPPP != null) {
  disableValidation('frmFCCPFamilyDetail');
  document.frmFCCPFamilyDetail.hdnBPlanTypeChange.value = 'true';
  submitValidateForm( "frmFCCPFamilyDetail", "/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" );
 }
}

/* 44337 MR-057 APPLA This function is displays the confirmation messages for Concurrent Plan Type*/
function confirmPrimaryForConcurrent()
{
   var isPrimaryForConcurrent = false;

   if (document.frmFCCPFamilyDetail.selCrtPlanType != null && document.frmFCCPFamilyDetail.selPPP != null) {
     if(document.frmFCCPFamilyDetail.selCrtPlanType.value == 'CON'){
        if (document.frmFCCPFamilyDetail.selPPP.value != "" && document.frmFCCPFamilyDetail.selPPP.value != 'RUI'){
          if (confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_FCCP_REU_FOR_CON)%>") == true){
           if(document.frmFCCPFamilyDetail.selSPP != null && document.frmFCCPFamilyDetail.selSPP != "" && (document.frmFCCPFamilyDetail.selSPP.value == 'FCO' || document.frmFCCPFamilyDetail.selSPP.value == 'LAE')){
             if (confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_FCCP_NON_APPLA_FOR_CON)%>") == true){
              isPrimaryForConcurrent = true;
             }
           }else {
            isPrimaryForConcurrent = true;
           }
         }
       }else if(document.frmFCCPFamilyDetail.selPPP.value != "" && document.frmFCCPFamilyDetail.selPPP.value == 'RUI'){
         if(document.frmFCCPFamilyDetail.selSPP != null && document.frmFCCPFamilyDetail.selSPP != "" && (document.frmFCCPFamilyDetail.selSPP.value == 'FCO' || document.frmFCCPFamilyDetail.selSPP.value == 'LAE')){
             if (confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_FCCP_NON_APPLA_FOR_CON)%>") == true){
              isPrimaryForConcurrent = true;
             }
         }else {
            isPrimaryForConcurrent = true;
         }
       }else{
        isPrimaryForConcurrent = true;
       }
      }else{
      isPrimaryForConcurrent = true;
    }
    return isPrimaryForConcurrent;  
  }
}

function confirmNoCurrentVisitationPlan(){
  var isMissingCurrVisitationPlan = false;
  var indCurrVisList = new Array();
<%
  for( int i = 0; i < listPrincipals.size(); i++){
%>
  indCurrVisList[<%=i%>] = <%= String.valueOf(((RowPlanPrincipal)listPrincipals.get(i)).getIndHasCurrentVisitationPlan()) %>;
<%
  }
%>
  
  for(var ctr = 0; ctr < <%=listPrincipals.size()%>; ctr++){
    var indPrn = eval("document.frmFCCPFamilyDetail.cbxPrincipalsOnPlan_" + ctr);
    
    if(indPrn != null && indPrn != undefined && indPrn.checked 
          && !indCurrVisList[ctr]){
      isMissingCurrVisitationPlan = true;
      break;
    }
  }
  
  if(isMissingCurrVisitationPlan){
	  if(confirm("No visitation plan is marked \"current\" for at least one of the principal children on this case plan. Press OK to continue or Cancel to stay on the current page.")){
	    return true;
	  }
    return false;
  }
  
  return true;
}
</script>

<impact:validateErrors />

<impact:validateForm name="frmFCCPFamilyDetail" method="post" action="/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" pageMode="<%=pageMode%>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FCCPFamilyCustomValidation"
	schema="/WEB-INF/Constraints.xsd">

	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<impact:validateInput type="hidden" name="hdnDtNextReview" value="<%=FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtNextReview())%>" />
	<impact:validateInput type="hidden" name="hdnDtCurReview" value="<%=FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtCurReview())%>" />
	<impact:validateInput type="hidden" name="hdnDtPrevReview" value="<%=FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtPrevReview())%>" />
	<impact:validateInput type="hidden" name="hdnDtOrgSub" value="<%=FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtOrigSub())%>" />
	<impact:validateInput type="hidden" name="displayedConfirm" value="" />

	<impact:validateInput type="hidden" name="hdnCasePlanMode" value="<%=casePlanMode%>" />
	<impact:validateInput type="hidden" name="hdnIdPlacementEvent" value="" />
	<impact:validateInput type="hidden" name="hdnIdFCCPEvent" value="<%=FormattingHelper.formatInt(fccpFamilyDetailSO.getEventId())%>" />
	<impact:validateInput type="hidden" name="hdnBPlanTypeChange" value="" />
	<%
		//****************************
			//**** FCCP FAMILY DETAIL ****
			//****************************
			// Display the 'Approval Status' button if the event has ever been
			// submitted for approval.

			String disableApprovalStatus = ArchitectureConstants.TRUE;
			if (CaseUtility.hasBeenSubmittedForApproval(GlobalData
					.getUlIdEvent(request))) {
				disableApprovalStatus = ArchitectureConstants.FALSE;
			}
	%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td>
				<impact:ButtonTag 
				  name="btnApprovalStatusFinal" 
				  img="btnApprovalStatus" 
				  form="frmFCCPFamilyDetail" 
				  action="<%=ApprovalStatusConversation.DISPLAY_URI%>" 
				  disabled="<%=disableApprovalStatus%>" 
				  editableMode="<%=EditableMode.ALL%>" 
				  navAwayCk="true"
					function="<%= GlobalData.isApprovalMode(request) ? "return confirmNoCurrentVisitationPlan()" : "" %>" 
					tabIndex="<%=tabIndex%>" />
			</td>
		</tr>
	</table>
	<br>
	
	<%
		//---------------Start of Aftercare Mode-------------------------
		if (FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) { // after care
		
	%>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="4">
				Aftercare
			</th>
		</tr>
	<%
		//---------------End of Aftercare Mode-------------------------
		} else {
		//---------------Start of Foster Case Mode-------------------------
	%>
	
	<%
		// ExcludeOptions for different case modes.

				Hashtable excludeList = new Hashtable();
				// if case mode is CON, REU or NRE then remove the Aftercare option from dropdown
				// only when page is revisited, should not affect when new page not saved
				if (StringHelper.isValid(casePlanMode)
						&& !FCCPFamilyDetailConversation.AFTER_CARE
								.equals(casePlanMode)) {
					excludeList.put("Aftercare", CodesTables.CCTPLNTY_AFC);
				}
	%>

    <%if(ArchitectureConstants.TRUE.equals(state.getAttribute("indLTFCQuesNotAnswered", request)) ||
         ArchitectureConstants.TRUE.equals(state.getAttribute("indAdultConnQuesNotAnswered", request))){ 
         List<Map<String,Object>> childrenList = fccpFamilyDetailSO.getChildrenList();
         %>
        <tr>
        <td>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		    <tr>
				<th>
					Current Placement
				</th>
			</tr>
			<tr>
				<th class="thList">
					Name
				</th>
		    </tr>
		    <%if(childrenList != null && !childrenList.isEmpty()){
		        Iterator<Map<String,Object>> iter1 = childrenList.iterator();
                while (iter1.hasNext()) { 
                    Map<String,Object> childrenMap = (Map<String,Object>) iter1.next();%>
				    <tr class="subDetail">
				     <td>
						<a href="javascript:getChildCurrentPlacement('<%=childrenMap.get("idPlacementEvent")%>')" 
								   onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++ %>">
								 <%=childrenMap.get("nmPerson")%>
						</a></td>
				    </tr>
		      <%}
		     } %>
		    </table>
		    <br>
		 </td>
		 </tr>
    <%  state.removeAttribute("indLTFCQuesNotAnswered", request);
        state.removeAttribute("indAdultConnQuesNotAnswered", request);
     }%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="3">
				Family Detail
			</th>
		</tr>
		<tr>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<impact:validateSelect label="Permanency Plan Type " name="selCrtPlanType" required="true" disabled="<%="" + (isViewMode)%>" codesTable="CCTPLNTY" 
							     value="<%= cdPlanType%>" 
							     onChange="changeCasePlanModeOnly(); defaultREUConcurrent(); submitFormOnPlanTypeChange();"
								 excludeOptions="<%=excludeList.values()%>" disabled="<%=String.valueOf(isDisabled)%>" tabIndex="<%=tabIndex++%>" />
						</td>
					</tr>
				</table>
			</td>
			<%
				if (!PageModeConstants.NEW.equals(pageMode)) {
			%>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
						  <impact:validateSelect label="Assigned Judge " name="txtAssnJudge" conditionallyRequired="true" orderBy = "decode" codesTable="CJUDGES" 
							      value="<%=FormattingHelper
										.formatString(fccpFamilyDetailSO
												.getTxtAssnJudge())%>"
								  disabled="<%="" + assignedJudgeDisabled%>" 
								  editableMode="<%=EditableMode.ALL%>"
								  tabIndex="<%=tabIndex++%>" />
						</td>
					</tr>
				</table>
			</td>
			<%
				}
			%>
		</tr>
		<%
		} //---------------End Of Foster Case Mode-------------------------
		%>
		
		<%
			if (!PageModeConstants.NEW.equals(pageMode)) {
		%>
		<tr>
			<!-- Start Principals on Plan Block and Family Plan Dates -->
			<td width="50%">
				<!-- Start Principals on Plan Block-->
				<%
					//---------------Start of Aftercare Mode-------------------------
					if (FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) { // after care
					
				%>
					<table border="0" cellpadding="3" cellspacing="0" width="100%" height="120" class="tableborder">
				<%
					} else {
				%>
					<table border="0" cellpadding="3" cellspacing="0" width="100%" height="180" class="tableborder">
				<%
					} 
				%>
					<tr>
						<th>
							<span class="formRequiredText">*</span>Principals on the Plan
						</th>
					</tr>
					<tr>
						<td colspan="3">
							<div style="overflow:auto; WIDTH: 370px; HEIGHT: 163px" class="tableborderList">
								<table border="0" cellpadding="3" cellspacing="0" width="100%">
									<tr>
										<th class="thList">
											Name
										</th>
										<th class="thList">
											Relationship
										</th>
										<th class="thList">
											Caregiver
										</th>
									</tr>
									<%
										loopCounter = 0;
													String isSelected = null;
													String isCareGiver = null;
													if (listPrincipals != null && !listPrincipals.isEmpty()
															&& listPrincipals.size() != 0) {
														iter = listPrincipals.iterator();
														while (iter.hasNext()) {
															RowPlanPrincipal prn = (RowPlanPrincipal) iter
																	.next();
															String checkboxName = "cbxPrincipalsOnPlan_"
																	+ loopCounter;
															String careGiverCheckboxName = "cbxCareGiversOnPlan_"
																	+ loopCounter;
															isSelected = "false";
															isCareGiver = "false";
															if ((!principalsForEventHashmap.isEmpty() && principalsForEventHashmap
																	.containsKey(prn.getIdPerson()))
																	|| isAddMode) {
																isSelected = "true";
																String indCaregiver = (String) principalsForEventHashmap
																		.get(prn.getIdPerson());
																if (StringHelper.isValid(indCaregiver)
																		&& ArchitectureConstants.Y
																				.equals(indCaregiver)) {
																	isCareGiver = "true";
																}
															}

															String relString = Lookup.simpleDecodeSafe(
																	CodesTables.CRELVICT, (String) prn
																			.getRelationship());
									%>
									<tr class="<%=FormattingHelper
												.getRowCss(loopCounter + 1)%>">
										<td>
											<impact:validateInput name="<%=checkboxName%>" checked="<%=isSelected%>" type="checkbox" label="<%=prn.getName()%>" value="<%=String.valueOf(prn.getIdPerson())%>" tabIndex="<%=tabIndex++%>"
												disabled="<%=String.valueOf(isViewMode)%>" cssClass="formInput" />
										</td>
										<td>
											<%=relString%>
										</td>
										<td>
											<impact:validateInput type="checkbox" name="<%=careGiverCheckboxName%>" label="" value="<%=String.valueOf(prn.getIdPerson())%>" checked="<%=isCareGiver%>" disabled="<%=String.valueOf(isViewMode)%>" tabIndex="<%=tabIndex++%>"
												cssClass="formInput" />
										</td>
									</tr>
									<%
										loopCounter++;
														}
													}
									%>
								</table>
							</div>
						</td>
					</tr>
				</table>
				<!-- End table PRN -->
			</td>
			<!-- End Principals on Plan Block-->
		<%
			//---------------Start of Aftercare Mode-------------------------
			if (FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) { // after care
		%>
			<td>
				<!-- Start Family Plan Dates Block -->
				<table border="0" cellpadding="3" cellspacing="0" height="200" width="100%" class="tableBorder">
					<tr>
							<th height="28" colspan="2">
								Family Plan Dates
							</th>
					</tr>
					<tr>
						<td>
							<%
								dateAsString = "";
										if (fccpFamilyDetailSO.getDtBeginAft() != null) {
											dateAsString = FormattingHelper
													.formatDate(fccpFamilyDetailSO.getDtBeginAft());
										}
							%>
							<impact:validateDate label="Begin Date of Aftercare" name="dtBeginAft" type="text" value="<%=dateAsString%>" size="10" conditionallyRequired="true" disabled="<%="" + isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Date" />
						</td>
					</tr>
					<tr>
						<td>
							<%
								dateAsString = "";
										if (fccpFamilyDetailSO.getDtEndAft() != null) {
											dateAsString = FormattingHelper
													.formatDate(fccpFamilyDetailSO.getDtEndAft());
										}
							%>
							<impact:validateDate label="End Date of Aftercare" name="dtEndAft" type="text" value="<%=dateAsString%>" size="10" conditionallyRequired="true" disabled="<%="" + isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Date" />
						</td>
					</tr>
			</table>
			<tr>
				<td>
					<impact:validateDisplayOnlyField name="dspDuration" label="Duration of Aftercare" value="<%=FormattingHelper.formatString(fccpFamilyDetailSO
										.getDurationAft())%>" />
				</td>
			</tr>
			<tr>
				<td>
					<span class="formCondRequiredText">&#135;</span>Reason for discharge from foster care:
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<impact:validateTextArea name="txtRsnDischg" title="Reason for discharge from foster care" colspan="1" rows="3" cols="145" maxLength="500" disabled="<%="" + isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Paragraph500">
						<%=FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtTsnDischg())%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
						<tr>
							<td>
								<impact:include page="/submodule/FCGSSubmoduleConversation/displayGoals" callingPage="/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" tabIndex="<%=tabIndex++%>" includingForm="frmFCCPFamilyDetail">
									<impact:attribute name="FCGSSubmoduleConversation.PAGE_MODE_KEY" value="<%=pageMode%>" />
								</impact:include>
							</td>
						</tr>
					</table>
					<br>
				</td>
			</tr>
			
			
		
			<tr>
				<td colspan="4">
					<impact:include page="/submodule/FosterCarePartSubConversation/displayFCPart" callingPage="/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" tabIndex="<%=tabIndex++%>" includingForm="frmFCCPFamilyDetail">
						<impact:attribute name="FosterCarePartSubConversation.PAGE_MODE_KEY" value="<%=pageMode%>" />
					</impact:include>
				</td>
			</tr>
		
		</table>
		<%
				//---------------End of Aftercare Mode-------------------------
		} else {
				//---------------Start of Foster Case Mode-------------------------
		%>
			<td>
				<!-- Start Family Plan Dates Block -->
				<table border="0" cellpadding="3" cellspacing="0" height="200" width="100%" class="tableBorder">
					<tr>
						<th height="28" colspan="2">
							Family Plan Dates
						</th>
					</tr>
					<tr>
						<td>
							<%
								//------------------
											//--- Dates Type ---
											//------------------
							%>
							<impact:validateInput checked="<%=String.valueOf(isInitialPlan)%>" tabIndex="<%=tabIndex++%>" value="<%=FCCPFamilyDetailConversation.INITIAL%>" onClick="updateDtNextReview();" disabled="<%="" + isDatesLocked%>"
								type="radio" name="rbDatesType" label="Initial" cssClass="formInput" />
						</td>
						<td>
							<impact:validateInput checked="<%=String.valueOf(isReviewPlan)%>" tabIndex="<%=tabIndex++%>" value="<%=FCCPFamilyDetailConversation.REVIEW%>" onClick="updateDtNextReview();" disabled="<%="" + isDatesLocked%>"
								type="radio" name="rbDatesType" label="Review" cssClass="formInput" />
						</td>
					</tr>
					<tr>
						<td>
							<%
								//------------------------
											//--- Initial Due Date ---
											//------------------------
											dateAsString = "";
											if (fccpFamilyDetailSO.getDtInitDue() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtInitDue());
											}
							%>
							<impact:validateDisplayOnlyField label="Initial Due Date: " name="txtInitialDueDate" value="<%=dateAsString%>" />
						</td>
					</tr>
					<tr>
						<td>
							<%
								//------------------------------------
											//--- Date Original Plan Submitted ---
											//------------------------------------
											dateAsString = "";
											if (fccpFamilyDetailSO.getDtOrigSub() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtOrigSub());
											}
							%>
							<impact:validateDate label="Date Original Plan Submitted" name="dtOrgSub" type="text" value="<%=dateAsString%>" size="10" conditionallyRequired="true" 
								disabled="<%="" + isDatesLocked%>" onChange="futureDateOrigSubInvalid(this)" tabIndex="<%=tabIndex++%>" constraint="Date" />
						</td>
					</tr>
					<tr>
						<td>
							<%
								//----------------------------
											//--- Previous Review Date ---
											//----------------------------
											dateAsString = "";
											if (fccpFamilyDetailSO.getDtPrevReview() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtPrevReview());
											}
							%>
							<impact:validateDate label="Previous Review Date" name="dtPreReview" type="text" value="<%=dateAsString%>" size="10" conditionallyRequired="true" disabled="<%="" + isDatesLocked%>" tabIndex="<%=tabIndex++%>"
								constraint="Date" />
						</td>
					</tr>
					<tr>
						<td>
							<%
								//---------------------------
											//--- Current Review Date ---
											//---------------------------
											dateAsString = "";
											if (fccpFamilyDetailSO.getDtCurReview() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtCurReview());
											}
								//STGAP00006921: FCCP Family Detail: Current Review Date: needs to allow future date.
							%>
							<impact:validateDate label="Current Review Date" name="dtCurReview" type="text" value="<%=dateAsString%>" onChange="updateDtNextReview()" size="10" conditionallyRequired="true" disabled="<%="" + isDatesLocked%>" 
								tabIndex="<%=tabIndex++%>" constraint="Date" />
						</td>
					</tr>
					<tr>
						<td>
							<%
								//------------------------
											//--- Next Review Date ---
											//------------------------
											dateAsString = "";
											String funcStrDtNextRev = "updateHdnDtNextReview('"
													+ dateAsString + "');";
											if (fccpFamilyDetailSO.getDtNextReview() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtNextReview());
											}
							%>
							<impact:validateDate label="Next Review Date" name="dtNextReview" type="text" value="<%=dateAsString%>" size="10" conditionallyRequired="true" 
								disabled="<%="" + isDatesLocked%>" onChange="updateHdnDtNextReview(this)" tabIndex="<%=tabIndex++%>" constraint="Date" />
						</td>
					</tr>
				</table>
			</td>
			<!-- End Family Plan Dates Block -->
		</tr>
		<!-- End Principals on Plan Block and Family Plan Dates -->
		<%
			//-------------------------------------
						//--- Permanency Plan (PPP) ---
						//-------------------------------------
		%>
		<tr>
			<td colspan="2">
				<span class="formRequiredText">*</span>Permanency Plan:
			</td>
		</tr>
		<%
		  String primaryPlan = "";
		  String hdnBPlanTypeChange = ContextHelper.getStringSafe(request, "hdnBPlanTypeChange");
		  String selCrtPlanType = ContextHelper.getStringSafe(request, "selCrtPlanType");
		  if(ArchitectureConstants.TRUE.equals(hdnBPlanTypeChange) && StringHelper.isValid(selCrtPlanType) && CodesTables.CCTPLNTY_NRE.equals(selCrtPlanType)){
		     primaryPlan = "";
		  }else if(ArchitectureConstants.TRUE.equals(hdnBPlanTypeChange) && StringHelper.isValid(selCrtPlanType) && CodesTables.CCTPLNTY_REU.equals(selCrtPlanType)){
		     primaryPlan = "RUI";
		  }else if(ArchitectureConstants.TRUE.equals(hdnBPlanTypeChange) && StringHelper.isValid(selCrtPlanType) && (CodesTables.CCTPLNTY_CON.equals(selCrtPlanType))){
              primaryPlan = "RUI";
          }else if (fccpFamilyDetailSO.getSelPPP() != null && !StringHelper.EMPTY_STRING.equals(fccpFamilyDetailSO.getSelPPP())){
            primaryPlan = FormattingHelper.formatString(fccpFamilyDetailSO.getSelPPP());
          }
		 %>
		<tr>
			<td colspan="2">
				<impact:validateSelect name="selPPP" disabled="<%="" + isDisabled%>" codesTable="CPERMPLN" 
				              value="<%=FormattingHelper.formatString(fccpFamilyDetailSO.getSelPPP())%>" tabIndex="<%=tabIndex++%>"
					     	  excludeOptions = "<%= excludePrimaryPlanList%>"/>
			</td>
		</tr>
		<%
			//----------------------------------------------------
						//--- Reason for selecting primary permanency plan...(PPP) ---
						//----------------------------------------------------
		%>
		<tr>
			<td colspan="2">
				<span class="formCondRequiredText">&#135;</span>Describe the compelling reasons for selecting a permanency plan other than (1), (02), (03), or (06):
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateTextArea name="txtPPPRsns"
					title="Describe the compelling reasons for selecting a permanency plan other than (01), (02), (03), or (06)"
					colspan="1" rows="3" cols="80" maxLength="500"
					tabIndex="<%=tabIndex++%>"
					constraint="Paragraph500">
					<%=FormattingHelper.formatString(fccpFamilyDetailSO.getTxtPPPRsns())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
			//----------------------------------------
						//--- Concurrent Permanency Plan (PPP) ---
						//----------------------------------------
		%>
		<tr>
			<td colspan="2">
				<span class="formCondRequiredText">&#135;</span>Concurrent Permanency Plan
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateSelect label="" name="selSPP" disabled="<%="" + isDisabled%>" orderBy="decode" codesTable="CPERMPLN"  value="<%=FormattingHelper
										.formatString(fccpFamilyDetailSO.getSelSPP())%>" tabIndex="<%=tabIndex++%>"/>
			</td>
		</tr>
		<%
			//---------------------------------------------------
						//--- Reason fo selecting concurrent plan...(SPP) ---
						//---------------------------------------------------
		%>
		<tr>
			<td colspan="2">
				<span class="formCondRequiredText">&#135;</span>Describe the compelling reasons for selecting a concurrent permanency plan other than (02), (03), or (06):
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateTextArea name="txtSPPRsns" title="Describe the compelling reasons for selecting a concurrent permanency plan other than (02), (03), or (06)" colspan="1" 
				                         rows="3" cols="80" maxLength="500"
					tabIndex="<%=tabIndex++%>" constraint="Paragraph500">
					<%=FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtSPPRsns())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
			//-------------------
						//--- Review Type ---
						//-------------------
		%>
		<tr>
			<td>
				<impact:validateSelect label="Review Type" name="selRvwType" disabled="<%="" + isDisabled%>" codesTable="CREVWTYP" required="true" value="<%=FormattingHelper
										.formatString(fccpFamilyDetailSO
												.getSelRvwType())%>" width="50%"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<%
			//-----------------------------------------------
						//--- Reasons children cannot be safe at home ---
						//-----------------------------------------------
		%>
		<tr>
			<td colspan="2">
				<span class="formCondRequiredText">&#135;</span>Reasons children cannot be adequately and safely protected at home (cur. summary):
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateTextArea name="txtRsnsChildNotHome" title="Reasons children cannot be adequately and safely protected at home" colspan="1" 
				                         rows="3" cols="80" maxLength="1000" 
				                         tabIndex="<%=tabIndex++%>"
					constraint="Paragraph1000">
					<%=FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtRsnsChildNotHome())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
			//--------------------------------------------------
						//--- Harms may occur if children remain at home ---
						//--------------------------------------------------
		%>
		<tr>
			<td colspan="2">
				<span class="formCondRequiredText">&#135;</span>Harms which may occur if child(ren) remains in home (future projection):
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateTextArea name="txtHarmChildLeftHome" title="Harms which may occur if child(ren) remains in home" colspan="1" 
				rows="3" cols="80" maxLength="1000" 
				tabIndex="<%=tabIndex++%>" constraint="Paragraph1000">
					<%=FormattingHelper
													.formatString(fccpFamilyDetailSO
															.getTxtHarmChildLeftInHome())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
			//----------------------------------------------
						//--- Projected Date of Achieving Permanency ---
						//----------------------------------------------
		%>
		<tr>
			<td>
				<%
					dateAsString = "";
								if (fccpFamilyDetailSO.getDtProjPerm() != null) {
									dateAsString = FormattingHelper
											.formatDate(fccpFamilyDetailSO
													.getDtProjPerm());
								}
				%>
				<impact:validateDate label="Projected Date of Achieving Permanency" name="dtProjPerm" type="text" value="<%=dateAsString%>" size="10" conditionallyRequired="true" disabled="<%="" + isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Date" />
			</td>
		</tr>
		<%
			//-----------------------------
						//--- Non/Reunification Goals ---
						//-------------------------------
		%>
		<tr>
			<td colspan="2">
				<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
					<tr>
						<td>
							<impact:include page="/submodule/FCGSSubmoduleConversation/displayGoals" callingPage="/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" tabIndex="<%=tabIndex++%>" includingForm="frmFCCPFamilyDetail">
								<impact:attribute name="FCGSSubmoduleConversation.PAGE_MODE_KEY" value="<%=pageMode%>" />
							</impact:include>
						</td>
					</tr>
				</table>
				<br>
			</td>
		</tr>
		<%
			//-----------------------
						//--- Secondary Goals ---
						//-----------------------
		%>
		<tr>
			<td colspan="2">
				<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
					<tr>
						<td>
							<impact:include page="/submodule/FosterCareSecGoalsSubConversation/displayFCSecGoals" callingPage="/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" tabIndex="<%=tabIndex++%>" includingForm="frmFCCPFamilyDetail">
								<impact:attribute name="FosterCareSecGoalsSubConversation.PAGE_MODE_KEY" value="<%=pageMode%>" />
							</impact:include>
						</td>
					</tr>
				</table>
				<br>
			</td>
		</tr>
		
		
		<%
			//-----------------------------------------------------
						//--- Foster Care Case Plan Participant Information ---
						//-----------------------------------------------------
		%>
		<tr>
			<td colspan="2">
				<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
					<tr>
						<th>
							Foster Care Case Plan Participant Information
						</th>
					</tr>
					<tr>
						<td>
							<span class="formCondRequiredText">&#135;</span>Has the parent participated in the development of this case plan?
						</td>
					</tr>
					<tr>
						<td>
							<table border="0" cellpadding="3" cellspacing="0" width="100%">
								<tr>
									<td>
										<impact:validateInput checked="<%=String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbParentPart()))%>" tabIndex="<%=tabIndex++%>" disabled="<%="" + isDisabled%>" onClick="" value="<%=ArchitectureConstants.Y%>"
											type="radio" name="rbParentPart" label="Yes" cssClass="formInput" />
									</td>
									<td>
										<impact:validateInput checked="<%=String.valueOf(ArchitectureConstants.N
										.equals(fccpFamilyDetailSO
												.getRbParentPart()))%>" tabIndex="<%=tabIndex++%>" disabled="<%="" + isDisabled%>" onClick="" value="<%=ArchitectureConstants.N%>"
											type="radio" name="rbParentPart" label="No" cssClass="formInput" />
									</td>
									<td>
										<span class="formCondRequiredText">&#135;</span>If No, explain below:
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<impact:validateTextArea name="txtNoParentPart" title="No Parental Participation Reason" colspan="1" 
							rows="3" cols="80" maxLength="500" editableMode="<%=editableMode%>" tabIndex="<%=tabIndex++%>" constraint="Paragraph500">
								<%=FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtNoParentPart())%>
							</impact:validateTextArea>
						</td>
					</tr>
					<tr>
						<td>
							<span class="formCondRequiredText">&#135;</span>Has the child participated in the development of this case plan?
						</td>
					</tr>
					<tr>
						<td>
							<table border="0" cellpadding="3" cellspacing="0" width="100%">
								<tr>
									<td>
										<impact:validateInput checked="<%=String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbChildPart()))%>" tabIndex="<%=tabIndex++%>" disabled="<%="" + isDisabled%>" value="<%=ArchitectureConstants.Y%>" type="radio"
											name="rbChildPart" label="Yes" cssClass="formInput" />
									</td>
									<td>
										<impact:validateInput checked="<%=String.valueOf(ArchitectureConstants.N
										.equals(fccpFamilyDetailSO
												.getRbChildPart()))%>" tabIndex="<%=tabIndex++%>" disabled="<%="" + isDisabled%>" value="<%=ArchitectureConstants.N%>" type="radio"
											name="rbChildPart" label="No" cssClass="formInput" />
									</td>
									<td>
										<span class="formCondRequiredText">&#135;</span>If No, explain below:
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<impact:validateTextArea name="txtNoChildPart" title="No Child Participation Reason" colspan="1" 
							rows="3" cols="80" maxLength="500" tabIndex="<%=tabIndex++%>" constraint="Paragraph500">
								<%=FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtNoChildPart())%>
							</impact:validateTextArea>
						</td>
					</tr>
					<tr>
						<td>
							<impact:validateInput type="checkbox" label="Parent was present during the development of this case plan, but refused to sign the attached form" name="cbxParentRefuseSign"
								checked="<%=String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getCbxParentRefuseSign()))%>" value="<%=ArchitectureConstants.Y%>" disabled="<%="" + isDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
						</td>
					</tr>
					<tr>
						<td>
							<span class="formCondRequiredText">&#135;</span>Hearing request submitted
						</td>
					</tr>
					<tr><td valign="top"><br></td></tr><tr>
						<td>
							<table border="0" cellpadding="3" cellspacing="0" width="100%">
								<tr>
									<td>
										<impact:validateInput checked="<%=String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbHearReqSub()))%>" tabIndex="<%=tabIndex++%>" value="<%=ArchitectureConstants.Y%>" type="radio" name="rbHearReqSub" label="Yes"
											disabled="<%="" + isDisabled%>" cssClass="formInput" />
									</td>
									<td>
										<impact:validateInput checked="<%=String.valueOf(ArchitectureConstants.N
										.equals(fccpFamilyDetailSO
												.getRbHearReqSub()))%>" tabIndex="<%=tabIndex++%>" value="<%=ArchitectureConstants.N%>" type="radio" name="rbHearReqSub" label="No"
											disabled="<%="" + isDisabled%>" cssClass="formInput" />
									</td>
									<td>
										<%
											dateAsString = "";
														if (fccpFamilyDetailSO.getDtHearReq() != null) {
															dateAsString = FormattingHelper
																	.formatDate(fccpFamilyDetailSO
																			.getDtHearReq());
														}
										%>
										<impact:validateDate label="If yes, record the date the hearing requested" name="dtHearReq" type="text" value="<%=dateAsString%>" size="10" conditionallyRequired="true" disabled="<%="" + isDisabled%>" tabIndex="<%=tabIndex++%>"
											constraint="Date" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<impact:validateInput type="checkbox" label="Case manager assistance required in requesting review hearing" name="cbxHearReqAsst" checked="<%=String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbHearReqAsst()))%>"
								value="<%=ArchitectureConstants.Y%>" disabled="<%="" + isDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
						</td>
					</tr>
					
					<%
			//--------------------------------------------------
						//--- Hearing Request Comments ---
						//--------------------------------------------------
		%>		
				<tr>
					<td colspan="2">
						Hearing Request Comments:
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<impact:validateTextArea name="txtHearingRequestComments" title="Hearing Request Comments" colspan="1" 
						rows="3" cols="80" maxLength="500" 
						tabIndex="<%=tabIndex++%>" disabled="<%="" + isDisabled%>" constraint="Paragraph500">
							<%=FormattingHelper
															.formatString(fccpFamilyDetailSO
																	.getTxtHearingRequestComments())%>
						</impact:validateTextArea>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		
		
		
		<tr>
			<td colspan="2">
				<impact:include page="/submodule/FosterCarePartSubConversation/displayFCPart" callingPage="/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" tabIndex="<%=tabIndex++%>" includingForm="frmFCCPFamilyDetail">
					<impact:attribute name="FosterCarePartSubConversation.PAGE_MODE_KEY" value="<%=pageMode%>" />
				</impact:include>
			</td>
		</tr>
	</table>
	<!--  End Family Detail table -->

	<%
		} // end else (not AFC)
	%>
	<%
		} // end else (not AFC)
	%>

	<hr>
	<%
		//Additional constraint on Save and Submit button's visiblity:
			// When plan is created through Copy or Update (when id event still > 0), it wil be hidden just as when it was Added (idEvent = 0)
			// Use btnEdit to determine whether it is a new plan created using Update (bearing update mode) vs. updated plan is being
			// accessed through hyperlink (also has update mode)
			boolean disableSaveAndSubmit = PageModeConstants.NEW_USING
					.equals(pageMode)
					|| btnEdit || GlobalData.isApprovalMode(request);
			String bDisableSaveAndSubmit = String.valueOf(disableSaveAndSubmit);
			if (!PageModeConstants.VIEW.equals(pageMode)) {
	%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<%
				if (!PageModeConstants.NEW.equals(pageMode)) {
			%>
			<td width="100%" align="right">
				<impact:spellCheck formToSpellCheck="frmFCCPFamilyDetail" fieldsToSpellCheck="<%=fieldsToBeSpellChecked%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<%
				}
			%>
			<%
				if (idEvent != 0) {
				  // SMS #51193: After Care Case Plans do not need to make
				  // the call to confirmPrimaryForConcurrent()
				  if(FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) {
			%>
			<td align="right">
				<impact:ButtonTag name="SaveSubmitFCCPFamilyDetail" img="btnSaveAndSubmit" align="right" form="frmFCCPFamilyDetail" disabled="<%=bDisableSaveAndSubmit%>" action="/serviceDelivery/FCCPFamilyDetail/checkFormExists" restrictRepost="true"
					preventDoubleClick="true" function="return confirmNoCurrentVisitationPlan()" tabIndex="<%=tabIndex++%>"/>
			</td>
			<%    } else {
			%>
			<td align="right">
				<impact:ButtonTag name="SaveSubmitFCCPFamilyDetail" img="btnSaveAndSubmit" align="right" form="frmFCCPFamilyDetail" disabled="<%=bDisableSaveAndSubmit%>" action="/serviceDelivery/FCCPFamilyDetail/checkFormExists" restrictRepost="true"
					preventDoubleClick="true" tabIndex="<%=tabIndex++%>" function="return confirmPrimaryForConcurrent() && confirmNoCurrentVisitationPlan()"/>
			</td>
			<%
				  }
				} 
			%>
			<%
				if (PageModeConstants.NEW.equals(pageMode)
								&& (idEvent == 0)) {
							String funcString = "cancelValidation();";
			%>
			<td align="right">
				<impact:ButtonTag name="ContinueFCCPFamilyDetail" img="btnContinue" align="right" form="frmFCCPFamilyDetail" action="/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail" restrictRepost="true" function="<%=funcString%>" preventDoubleClick="true"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
				} else {
			%>
			<td align="right">
				<impact:ButtonTag name="SaveFCCPFamilyDetail" img="btnSave" align="right" form="frmFCCPFamilyDetail" action="/serviceDelivery/FCCPFamilyDetail/saveFCCPFamilyDetail" restrictRepost="true" preventDoubleClick="true" tabIndex="<%=tabIndex++%>" 
				editableMode="<%=EditableMode.ALL%>" disabled="<%="" + assignedJudgeDisabled%>" />
			</td>
			<%
				}
			%>
		</tr>
	</table>
	<%
		}else{
		 if(!assignedJudgeDisabled){
		 %>
		  <table border="0" cellpadding="3" cellspacing="0" width="100%">
		   <tr>
		     <td align="right">
				<impact:ButtonTag name="SaveFCCPFamilyDetail" img="btnSave" align="right" form="frmFCCPFamilyDetail" action="/serviceDelivery/FCCPFamilyDetail/saveFCCPFamilyDetail" restrictRepost="true" preventDoubleClick="true" tabIndex="<%=tabIndex++%>" 
				editableMode="<%=EditableMode.ALL%>" />
			</td>
		   </tr>
		  </table>
	<%	  
		  }
		}
	%>
</impact:validateForm>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
	<tr>
		<th colspan="4">
			Form and Report Launch
		</th>
	</tr>
	<tr>
		<td>
			<impact:documentList pageMode="<%=pageMode%>" tabIndex="<%=tabIndex++%>">
				<%
					if (listPrimaryChildren != null
								&& !listPrimaryChildren.isEmpty()) {
							for (Iterator<RowPlanPrincipal> itVic = listPrimaryChildren
									.iterator(); itVic.hasNext();) {
								RowPlanPrincipal victimChild = itVic.next();
								if ("Y".equals(victimChild
										.getBIndBLOBExistsInDatabase())) {
									docExists = true;
								} else {
									docExists = false;
								}

								String documentFormName = "FCM05O00"
										+ String.valueOf(victimChild.getIdPerson());
				%>
				<impact:document displayName="<%=victimChild.getName()%>" protectDocument="<%=protectDoc%>" checkForNewMode="true" docType="FCM05O00" name="<%=documentFormName%>" docExists="<%=docExists%>">
					<impact:documentParameter name="pCase" value="<%=String.valueOf(GlobalData
											.getUlIdCase(request))%>" />
					<impact:documentParameter name="pStage" value="<%=String.valueOf(GlobalData
											.getUlIdStage(request))%>" />
					<impact:documentParameter name="pEvent" value="<%=String.valueOf(idEvent)%>" />
					<impact:documentParameter name="pPerson" value="<%=String.valueOf(victimChild
													.getIdPerson())%>" />
					<impact:documentParameter name="pStageOther" value="<%=String.valueOf(victimChild
											.getIdStagePrincipal())%>" />
				</impact:document>
				<%
					}
						}
				%>
			</impact:documentList>
		</td>
	</tr>
</table>

<script language="javascript">
<impact:ifThen test="<%=((PageModeConstants.VIEW.equals(pageMode) == false)
							&& !isUpdateMode && !isNewUsingMode)%>">
  // updateDtNextReview should be removed from here to Allow the next preview date to be editable without  overwriting it 
  // with  a save 					
  //  	updateDtNextReview();
</impact:ifThen>
  
</script>