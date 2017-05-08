package org.apache.jsp.grnds_002ddocs.serviceDelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO.RowPlanPrincipal;
import gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FCCPFamilyDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;

public final class FCCPFamilyDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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
    

      out.write('\r');
      out.write('\n');

	//******************
	//*** JAVASCRIPT ***
	//******************

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  \r\nwindow.onload = function ()\r\n{\r\n  defaultREUConcurrent();\r\n}\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction changeCasePlanMode()\r\n{\r\n    var casePlanMode = eval(\"document.frmFCCPFamilyDetail.selCrtPlanType.value\");\r\n    disableValidation(\"frmFCCPFamilyDetail\");\r\n    document.frmFCCPFamilyDetail.hdnCasePlanMode.value=casePlanMode;\r\n    submitValidateForm(\"frmFCCPFamilyDetail\", \"/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail\");\r\n} \r\n\r\nfunction changeCasePlanModeOnly()\r\n{\r\n    var casePlanMode = eval(\"document.frmFCCPFamilyDetail.selCrtPlanType.value\");\r\n    document.frmFCCPFamilyDetail.hdnCasePlanMode.value=casePlanMode;\r\n}\r\n\r\nfunction updateCasePlanMode() {\r\n   return   eval(\"document.frmFCCPFamilyDetail.selCrtPlanType.value\");\r\n");
      out.write("}\r\n\r\n// This function serves to prevent entering a future date in the Date\r\n// Current Review date field. It will generate value for the Next Review Date field\r\n// if that field has never been filled.\r\n\r\nfunction futureDateInvalid( field )\r\n{\r\n  if ( field.value != \"\")\r\n  {\r\n    var dtNextReviewField = eval(document.getElementById(\"dtNextReview_Id\"));\r\n    var startingDateAsString = validateDateString( field.value );\r\n    var fieldName = \"document.frmFCCPFamilyDetail.\"+field.name;\r\n    var validValue = \"document.frmFCCPFamilyDetail.\"+fieldName+\".value = \"+\"startingDateAsString;\";\r\n    var refocus = \"document.frmFCCPFamilyDetail.\"+fieldName+\".blur();\";\r\n    var reselect = \"document.frmFCCPFamilyDetail.\"+fieldName+\".select();\";\r\n    var today = new Date();\r\n    // If input is invalid, pop message, blank field value, put cursor back in field.\r\n    if ( startingDateAsString == \"INVALID\" ||\r\n       (new Date( Date.parse(startingDateAsString) ) > today ) )\r\n    {\r\n      alert('");
      out.print(MessageLookup
									.getMessageByNumber(Messages.MSG_FP_DATE_BEFORE_SAME_CURR));
      out.write("');\r\n      eval(refocus); eval(reselect);\r\n    }\r\n    // If the input value is a valid date, put in the validated format.\r\n    else\r\n    {\r\n      eval(validValue);\r\n      // Only if Next Review Date is blank is it autofilled. \r\n      if ( dtNextReviewField.value == \"\" )\r\n      {\r\n        autofillNextReviewDue(startingDateAsString);\r\n      }\r\n    }\r\n  }\r\n}\r\n\r\nfunction futureDateOrigSubInvalid( field )\r\n{\r\n  if ( field.value != \"\")\r\n  {\r\n    var startingDateAsString = validateDateString( field.value );\r\n    var fieldName = \"document.frmFCCPFamilyDetail.\"+field.name;\r\n    var validValue = \"document.frmFCCPFamilyDetail.\"+fieldName+\".value = \"+\"startingDateAsString;\";\r\n    var refocus = \"document.frmFCCPFamilyDetail.\"+fieldName+\".blur();\";\r\n    var reselect = \"document.frmFCCPFamilyDetail.\"+fieldName+\".select();\";\r\n    var today = new Date();\r\n    // If input is invalid, pop message,blank field value, put cursor back in field.\r\n    if ( startingDateAsString == \"INVALID\" ||\r\n       (new Date( Date.parse(startingDateAsString) ) > today ) )\r\n");
      out.write("    {\r\n      alert('");
      out.print(MessageLookup
									.getMessageByNumber(Messages.MSG_FP_DATE_BEFORE_SAME_CURR));
      out.write("');\r\n      eval(refocus); eval(reselect);\r\n    }\r\n    // If the input value is a valid date, put in the validated format.\r\n    else\r\n    {\r\n      eval(validValue);\r\n      //document.frmFCCPFamilyDetail.hdnDtOrgSub.value = field.value;alert(document.frmFCCPFamilyDetail.hdnDtOrgSub.value);\r\n    }\r\n  }\r\n  document.frmFCCPFamilyDetail.hdnDtOrgSub.value = field.value;\r\n}\r\n\r\n// This function auto-fills the Next Review Due date field is followed:\r\n// It is 6 months from the 'starting date'\r\n// Starting Date is Date of Removal if Date type is Initial\r\n// Starting Date is Current Review Date if Date type is Review \r\nfunction autofillNextReviewDue(startingDateAsString)\r\n{\r\n  var startingDateInMilliseconds = Date.parse( startingDateAsString );\r\n  var nextReviewDate = new Date( startingDateInMilliseconds );\r\n  var today = new Date();\r\n  var dtNextReviewField = eval(document.getElementById(\"dtNextReview_Id\"));\r\n    \r\n  nextReviewDate.setMonth( nextReviewDate.getMonth() + 6 );\r\n  \r\n ");
//mxpatel changed the .getYear to .getFullyear this out for defect #9284 and 10088
      out.write("\r\n dtNextReviewField.value = (nextReviewDate.getMonth()+1)   + \"/\" +nextReviewDate.getDate()   + \"/\" +nextReviewDate.getFullYear();\r\n  document.frmFCCPFamilyDetail.hdnDtNextReview.value = (nextReviewDate.getMonth()+1) + \"/\" +nextReviewDate.getDate() + \"/\" +nextReviewDate.getFullYear();\r\n \r\n \r\n \r\n \r\n \r\n}\r\n\r\n// called by onChange from Next Review Date field\r\nfunction updateHdnDtNextReview(field) {\r\n  document.frmFCCPFamilyDetail.hdnDtNextReview.value = field.value;\r\n}\r\n\r\n// to update dtNextReview field's status based on what plan date type is selected\r\nfunction updateDtNextReview() \r\n{\r\n  if (document.frmFCCPFamilyDetail.hdnCasePlanMode.value != 'AFC')\r\n  {\r\n    var dtNextReviewField = eval(\"document.frmFCCPFamilyDetail.dtNextReview.value\");\r\n    var dtOrgSubField = eval(document.getElementById(\"dtOrgSub_Id\"));\r\n    var dtCurrentReviewDate = eval(\"document.frmFCCPFamilyDetail.dtCurReview.value\");\r\n    var initial, review;\r\n    try {\r\n      initial = document.frmFCCPFamilyDetail.rbDatesType[0];\r\n      review = document.frmFCCPFamilyDetail.rbDatesType[1];\r\n");
      out.write("    } catch(e) {\r\n      return;\r\n    }\r\n    \r\n    // Initial is selected\r\n    if (initial.checked)\r\n    { \r\n      if ( document.frmFCCPFamilyDetail.dtNextReview.type != \"hidden\" ) {\r\n        disableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtNextReview );\r\n      }\r\n      autofillNextReviewDue(\"");
      out.print(FormattingHelper.formatDate(fccpFamilyDetailSO
							.getDtRemoval()));
      out.write("\");\r\n      enableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtOrgSub );\r\n    }\r\n    // plan is Review, enable field only, date review will be calculated when Current Review date is actually entered\r\n    else if (review.checked)\r\n    {\r\n        enableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtNextReview );\r\n        if ( document.frmFCCPFamilyDetail.dtOrgSub.type != \"hidden\" ) {\r\n          disableDateField( document.frmFCCPFamilyDetail, document.frmFCCPFamilyDetail.dtOrgSub );\r\n        }\r\n        // STGAP00006201 When the Current Review date is selected then \r\n        // the next review date is set for 6 months ahead of the current review date\r\n        if(dtCurrentReviewDate != ''){\r\n        autofillNextReviewDue( dtCurrentReviewDate );\r\n        }\r\n    }\r\n  }\r\n  \r\n}\r\n\r\nfunction updateDtOrigSub() {\r\n  var dtOrgSubField = eval(document.getElementById(\"dtOrgSub_Id\"));\r\n  document.frmFCCPFamilyDetail.hdnDtOrgSub.value = dtOrgSubField.value;\r\n}\r\n\r\n// future enhancement - to clear the preset dtNextReview when changed from Initial to Review so user\r\n");
      out.write("// won't have to guess whether dtNextReview field has to be blank for the auto fill function to work\r\n// should be called in onChange for radio button plan date type\r\nfunction clearDtReviewField() {\r\n  var dtNextReviewField = eval(document.getElementById(\"dtNextReview_Id\"));\r\n  dtNextReviewField.value = '';\r\n}\r\n\r\nfunction cancelValidation ()\r\n{\r\n  disableValidation('frmFCCPFamilyDetail');\r\n  return true;\r\n}\r\n//MR-057 APPLA Changes\r\nfunction getChildCurrentPlacement(idPlacementEvent)\r\n{\r\n  frmFCCPFamilyDetail.hdnIdPlacementEvent.value = idPlacementEvent;\r\n  submitValidateForm( \"frmFCCPFamilyDetail\", \"/serviceDelivery/FCCPFamilyDetail/displayPlacementInformation\" );\r\n}\r\n\r\n/* MR-057 APPLA This function defaults the Primary Plan to Reunification for Reunification Plan Type*/\r\nfunction defaultREUConcurrent(){\r\n if (document.frmFCCPFamilyDetail.selCrtPlanType != null && document.frmFCCPFamilyDetail.selPPP != null &&\r\n    (document.frmFCCPFamilyDetail.selPPP.value == null || document.frmFCCPFamilyDetail.selPPP.value == \"\" || \r\n");
      out.write("     document.frmFCCPFamilyDetail.hdnBPlanTypeChange.value == 'true')) {\r\n  if(document.frmFCCPFamilyDetail.selCrtPlanType.value == 'REU'|| document.frmFCCPFamilyDetail.selCrtPlanType.value == 'CON'){\r\n    document.frmFCCPFamilyDetail.selPPP.value = '");
      out.print( FormattingHelper.formatString(CodesTables.CPERMPLN_RUI));
      out.write("';\r\n  }else if (document.frmFCCPFamilyDetail.selCrtPlanType.value == 'NRE'){\r\n    if(document.frmFCCPFamilyDetail.selPPP.value == 'RUI'){\r\n      document.frmFCCPFamilyDetail.selPPP.value = '';\r\n    }\r\n  }\r\n }\r\n}\r\n\r\n/* MR-057 APPLA This function sets the hidden variable to true so that it can be used in conversation for creating exclude lists*/\r\nfunction submitFormOnPlanTypeChange(){\r\n if (document.frmFCCPFamilyDetail.selCrtPlanType != null && document.frmFCCPFamilyDetail.selPPP != null) {\r\n  disableValidation('frmFCCPFamilyDetail');\r\n  document.frmFCCPFamilyDetail.hdnBPlanTypeChange.value = 'true';\r\n  submitValidateForm( \"frmFCCPFamilyDetail\", \"/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail\" );\r\n }\r\n}\r\n\r\n/* 44337 MR-057 APPLA This function is displays the confirmation messages for Concurrent Plan Type*/\r\nfunction confirmPrimaryForConcurrent()\r\n{\r\n   var isPrimaryForConcurrent = false;\r\n\r\n   if (document.frmFCCPFamilyDetail.selCrtPlanType != null && document.frmFCCPFamilyDetail.selPPP != null) {\r\n     if(document.frmFCCPFamilyDetail.selCrtPlanType.value == 'CON'){\r\n");
      out.write("        if (document.frmFCCPFamilyDetail.selPPP.value != \"\" && document.frmFCCPFamilyDetail.selPPP.value != 'RUI'){\r\n          if (confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_FCCP_REU_FOR_CON));
      out.write("\") == true){\r\n           if(document.frmFCCPFamilyDetail.selSPP != null && document.frmFCCPFamilyDetail.selSPP != \"\" && (document.frmFCCPFamilyDetail.selSPP.value == 'FCO' || document.frmFCCPFamilyDetail.selSPP.value == 'LAE')){\r\n             if (confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_FCCP_NON_APPLA_FOR_CON));
      out.write("\") == true){\r\n              isPrimaryForConcurrent = true;\r\n             }\r\n           }else {\r\n            isPrimaryForConcurrent = true;\r\n           }\r\n         }\r\n       }else if(document.frmFCCPFamilyDetail.selPPP.value != \"\" && document.frmFCCPFamilyDetail.selPPP.value == 'RUI'){\r\n         if(document.frmFCCPFamilyDetail.selSPP != null && document.frmFCCPFamilyDetail.selSPP != \"\" && (document.frmFCCPFamilyDetail.selSPP.value == 'FCO' || document.frmFCCPFamilyDetail.selSPP.value == 'LAE')){\r\n             if (confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_FCCP_NON_APPLA_FOR_CON));
      out.write("\") == true){\r\n              isPrimaryForConcurrent = true;\r\n             }\r\n         }else {\r\n            isPrimaryForConcurrent = true;\r\n         }\r\n       }else{\r\n        isPrimaryForConcurrent = true;\r\n       }\r\n      }else{\r\n      isPrimaryForConcurrent = true;\r\n    }\r\n    return isPrimaryForConcurrent;  \r\n  }\r\n}\r\n\r\nfunction confirmNoCurrentVisitationPlan(){\r\n  var isMissingCurrVisitationPlan = false;\r\n  var indCurrVisList = new Array();\r\n");

  for( int i = 0; i < listPrincipals.size(); i++){

      out.write("\r\n  indCurrVisList[");
      out.print(i);
      out.write("] = ");
      out.print( String.valueOf(((RowPlanPrincipal)listPrincipals.get(i)).getIndHasCurrentVisitationPlan()) );
      out.write(';');
      out.write('\r');
      out.write('\n');

  }

      out.write("\r\n  \r\n  for(var ctr = 0; ctr < ");
      out.print(listPrincipals.size());
      out.write("; ctr++){\r\n    var indPrn = eval(\"document.frmFCCPFamilyDetail.cbxPrincipalsOnPlan_\" + ctr);\r\n    \r\n    if(indPrn != null && indPrn != undefined && indPrn.checked \r\n          && !indCurrVisList[ctr]){\r\n      isMissingCurrVisitationPlan = true;\r\n      break;\r\n    }\r\n  }\r\n  \r\n  if(isMissingCurrVisitationPlan){\r\n\t  if(confirm(\"No visitation plan is marked \\\"current\\\" for at least one of the principal children on this case plan. Press OK to continue or Cancel to stay on the current page.\")){\r\n\t    return true;\r\n\t  }\r\n    return false;\r\n  }\r\n  \r\n  return true;\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFCCPFamilyDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FCCPFamilyCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnDtNextReview");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtNextReview()));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnDtCurReview");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtCurReview()));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnDtPrevReview");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtPrevReview()));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnDtOrgSub");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatDate(fccpFamilyDetailSO
								.getDtOrigSub()));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnCasePlanMode");
          _jspx_th_impact_validateInput_5.setValue(casePlanMode);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnIdFCCPEvent");
          _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatInt(fccpFamilyDetailSO.getEventId()));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

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
	
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_0.setAction(ApprovalStatusConversation.DISPLAY_URI);
          _jspx_th_impact_ButtonTag_0.setDisabled(disableApprovalStatus);
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setFunction( GlobalData.isApprovalMode(request) ? "return confirmNoCurrentVisitationPlan()" : "" );
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t\r\n\t");

		//---------------Start of Aftercare Mode-------------------------
		if (FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) { // after care
		
	
          out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tAftercare\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t");

		//---------------End of Aftercare Mode-------------------------
		} else {
		//---------------Start of Foster Case Mode-------------------------
	
          out.write("\r\n\t\r\n\t");

		// ExcludeOptions for different case modes.

				Hashtable excludeList = new Hashtable();
				// if case mode is CON, REU or NRE then remove the Aftercare option from dropdown
				// only when page is revisited, should not affect when new page not saved
				if (StringHelper.isValid(casePlanMode)
						&& !FCCPFamilyDetailConversation.AFTER_CARE
								.equals(casePlanMode)) {
					excludeList.put("Aftercare", CodesTables.CCTPLNTY_AFC);
				}
	
          out.write("\r\n\r\n    ");
if(ArchitectureConstants.TRUE.equals(state.getAttribute("indLTFCQuesNotAnswered", request)) ||
         ArchitectureConstants.TRUE.equals(state.getAttribute("indAdultConnQuesNotAnswered", request))){ 
         List<Map<String,Object>> childrenList = fccpFamilyDetailSO.getChildrenList();
         
          out.write("\r\n        <tr>\r\n        <td>\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t    <tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tCurrent Placement\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tName\r\n\t\t\t\t</th>\r\n\t\t    </tr>\r\n\t\t    ");
if(childrenList != null && !childrenList.isEmpty()){
		        Iterator<Map<String,Object>> iter1 = childrenList.iterator();
                while (iter1.hasNext()) { 
                    Map<String,Object> childrenMap = (Map<String,Object>) iter1.next();
          out.write("\r\n\t\t\t\t    <tr class=\"subDetail\">\r\n\t\t\t\t     <td>\r\n\t\t\t\t\t\t<a href=\"javascript:getChildCurrentPlacement('");
          out.print(childrenMap.get("idPlacementEvent"));
          out.write("')\" \r\n\t\t\t\t\t\t\t\t   onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
          out.print(tabIndex++ );
          out.write("\">\r\n\t\t\t\t\t\t\t\t ");
          out.print(childrenMap.get("nmPerson"));
          out.write("\r\n\t\t\t\t\t\t</a></td>\r\n\t\t\t\t    </tr>\r\n\t\t      ");
}
		     } 
          out.write("\r\n\t\t    </table>\r\n\t\t    <br>\r\n\t\t </td>\r\n\t\t </tr>\r\n    ");
  state.removeAttribute("indLTFCQuesNotAnswered", request);
        state.removeAttribute("indAdultConnQuesNotAnswered", request);
     }
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"3\">\r\n\t\t\t\tFamily Detail\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Permanency Plan Type ");
          _jspx_th_impact_validateSelect_0.setName("selCrtPlanType");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setDisabled("" + (isViewMode));
          _jspx_th_impact_validateSelect_0.setCodesTable("CCTPLNTY");
          _jspx_th_impact_validateSelect_0.setValue( cdPlanType);
          _jspx_th_impact_validateSelect_0.setOnChange("changeCasePlanModeOnly(); defaultREUConcurrent(); submitFormOnPlanTypeChange();");
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeList.values());
          _jspx_th_impact_validateSelect_0.setDisabled(String.valueOf(isDisabled));
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t\t");

				if (!PageModeConstants.NEW.equals(pageMode)) {
			
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t  ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Assigned Judge ");
          _jspx_th_impact_validateSelect_1.setName("txtAssnJudge");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setOrderBy("decode");
          _jspx_th_impact_validateSelect_1.setCodesTable("CJUDGES");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper
										.formatString(fccpFamilyDetailSO
												.getTxtAssnJudge()));
          _jspx_th_impact_validateSelect_1.setDisabled("" + assignedJudgeDisabled);
          _jspx_th_impact_validateSelect_1.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t\t");

				}
			
          out.write("\r\n\t\t</tr>\r\n\t\t");

		} //---------------End Of Foster Case Mode-------------------------
		
          out.write("\r\n\t\t\r\n\t\t");

			if (!PageModeConstants.NEW.equals(pageMode)) {
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<!-- Start Principals on Plan Block and Family Plan Dates -->\r\n\t\t\t<td width=\"50%\">\r\n\t\t\t\t<!-- Start Principals on Plan Block-->\r\n\t\t\t\t");

					//---------------Start of Aftercare Mode-------------------------
					if (FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) { // after care
					
				
          out.write("\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" height=\"120\" class=\"tableborder\">\r\n\t\t\t\t");

					} else {
				
          out.write("\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" height=\"180\" class=\"tableborder\">\r\n\t\t\t\t");

					} 
				
          out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th>\r\n\t\t\t\t\t\t\t<span class=\"formRequiredText\">*</span>Principals on the Plan\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t\t\t<div style=\"overflow:auto; WIDTH: 370px; HEIGHT: 163px\" class=\"tableborderList\">\r\n\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\t\t\tName\r\n\t\t\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\t\t\tRelationship\r\n\t\t\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\t\t\tCaregiver\r\n\t\t\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t");

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
									
          out.write("\r\n\t\t\t\t\t\t\t\t\t<tr class=\"");
          out.print(FormattingHelper
												.getRowCss(loopCounter + 1));
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setName(checkboxName);
          _jspx_th_impact_validateInput_9.setChecked(isSelected);
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setLabel(prn.getName());
          _jspx_th_impact_validateInput_9.setValue(String.valueOf(prn.getIdPerson()));
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setDisabled(String.valueOf(isViewMode));
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
          out.print(relString);
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setName(careGiverCheckboxName);
          _jspx_th_impact_validateInput_10.setLabel("");
          _jspx_th_impact_validateInput_10.setValue(String.valueOf(prn.getIdPerson()));
          _jspx_th_impact_validateInput_10.setChecked(isCareGiver);
          _jspx_th_impact_validateInput_10.setDisabled(String.valueOf(isViewMode));
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t");

										loopCounter++;
														}
													}
									
          out.write("\r\n\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t\t<!-- End table PRN -->\r\n\t\t\t</td>\r\n\t\t\t<!-- End Principals on Plan Block-->\r\n\t\t");

			//---------------Start of Aftercare Mode-------------------------
			if (FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) { // after care
		
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t<!-- Start Family Plan Dates Block -->\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" height=\"200\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<th height=\"28\" colspan=\"2\">\r\n\t\t\t\t\t\t\t\tFamily Plan Dates\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

								dateAsString = "";
										if (fccpFamilyDetailSO.getDtBeginAft() != null) {
											dateAsString = FormattingHelper
													.formatDate(fccpFamilyDetailSO.getDtBeginAft());
										}
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Begin Date of Aftercare");
          _jspx_th_impact_validateDate_0.setName("dtBeginAft");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue(dateAsString);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled("" + isDisabled);
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

								dateAsString = "";
										if (fccpFamilyDetailSO.getDtEndAft() != null) {
											dateAsString = FormattingHelper
													.formatDate(fccpFamilyDetailSO.getDtEndAft());
										}
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("End Date of Aftercare");
          _jspx_th_impact_validateDate_1.setName("dtEndAft");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue(dateAsString);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setDisabled("" + isDisabled);
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspDuration");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Duration of Aftercare");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(fccpFamilyDetailSO
										.getDurationAft()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Reason for discharge from foster care:\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtRsnDischg");
          _jspx_th_impact_validateTextArea_0.setTitle("Reason for discharge from foster care");
          _jspx_th_impact_validateTextArea_0.setColspan("1");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("145");
          _jspx_th_impact_validateTextArea_0.setMaxLength(500);
          _jspx_th_impact_validateTextArea_0.setDisabled("" + isDisabled);
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtTsnDischg()));
              out.write("\r\n\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/FCGSSubmoduleConversation/displayGoals");
          _jspx_th_impact_include_0.setCallingPage("/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
          _jspx_th_impact_include_0.setTabIndex(tabIndex++);
          _jspx_th_impact_include_0.setIncludingForm("frmFCCPFamilyDetail");
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t\t");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName("FCGSSubmoduleConversation.PAGE_MODE_KEY");
              _jspx_th_impact_attribute_0.setValue(pageMode);
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t\t<br>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t\r\n\t\t\t\r\n\t\t\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_1.setPage("/submodule/FosterCarePartSubConversation/displayFCPart");
          _jspx_th_impact_include_1.setCallingPage("/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
          _jspx_th_impact_include_1.setTabIndex(tabIndex++);
          _jspx_th_impact_include_1.setIncludingForm("frmFCCPFamilyDetail");
          int _jspx_eval_impact_include_1 = _jspx_th_impact_include_1.doStartTag();
          if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_1);
              _jspx_th_impact_attribute_1.setName("FosterCarePartSubConversation.PAGE_MODE_KEY");
              _jspx_th_impact_attribute_1.setValue(pageMode);
              int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
              if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_include_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\r\n\t\t</table>\r\n\t\t");

				//---------------End of Aftercare Mode-------------------------
		} else {
				//---------------Start of Foster Case Mode-------------------------
		
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t<!-- Start Family Plan Dates Block -->\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" height=\"200\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th height=\"28\" colspan=\"2\">\r\n\t\t\t\t\t\t\tFamily Plan Dates\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

								//------------------
											//--- Dates Type ---
											//------------------
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setChecked(String.valueOf(isInitialPlan));
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setValue(FCCPFamilyDetailConversation.INITIAL);
          _jspx_th_impact_validateInput_11.setOnClick("updateDtNextReview();");
          _jspx_th_impact_validateInput_11.setDisabled("" + isDatesLocked);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setName("rbDatesType");
          _jspx_th_impact_validateInput_11.setLabel("Initial");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setChecked(String.valueOf(isReviewPlan));
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setValue(FCCPFamilyDetailConversation.REVIEW);
          _jspx_th_impact_validateInput_12.setOnClick("updateDtNextReview();");
          _jspx_th_impact_validateInput_12.setDisabled("" + isDatesLocked);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setName("rbDatesType");
          _jspx_th_impact_validateInput_12.setLabel("Review");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

								//------------------------
											//--- Initial Due Date ---
											//------------------------
											dateAsString = "";
											if (fccpFamilyDetailSO.getDtInitDue() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtInitDue());
											}
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Initial Due Date: ");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtInitialDueDate");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(dateAsString);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

								//------------------------------------
											//--- Date Original Plan Submitted ---
											//------------------------------------
											dateAsString = "";
											if (fccpFamilyDetailSO.getDtOrigSub() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtOrigSub());
											}
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Date Original Plan Submitted");
          _jspx_th_impact_validateDate_2.setName("dtOrgSub");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setValue(dateAsString);
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setDisabled("" + isDatesLocked);
          _jspx_th_impact_validateDate_2.setOnChange("futureDateOrigSubInvalid(this)");
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

								//----------------------------
											//--- Previous Review Date ---
											//----------------------------
											dateAsString = "";
											if (fccpFamilyDetailSO.getDtPrevReview() != null) {
												dateAsString = FormattingHelper
														.formatDate(fccpFamilyDetailSO
																.getDtPrevReview());
											}
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setLabel("Previous Review Date");
          _jspx_th_impact_validateDate_3.setName("dtPreReview");
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setValue(dateAsString);
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_3.setDisabled("" + isDatesLocked);
          _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

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
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setLabel("Current Review Date");
          _jspx_th_impact_validateDate_4.setName("dtCurReview");
          _jspx_th_impact_validateDate_4.setType("text");
          _jspx_th_impact_validateDate_4.setValue(dateAsString);
          _jspx_th_impact_validateDate_4.setOnChange("updateDtNextReview()");
          _jspx_th_impact_validateDate_4.setSize("10");
          _jspx_th_impact_validateDate_4.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_4.setDisabled("" + isDatesLocked);
          _jspx_th_impact_validateDate_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

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
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_5.setLabel("Next Review Date");
          _jspx_th_impact_validateDate_5.setName("dtNextReview");
          _jspx_th_impact_validateDate_5.setType("text");
          _jspx_th_impact_validateDate_5.setValue(dateAsString);
          _jspx_th_impact_validateDate_5.setSize("10");
          _jspx_th_impact_validateDate_5.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_5.setDisabled("" + isDatesLocked);
          _jspx_th_impact_validateDate_5.setOnChange("updateHdnDtNextReview(this)");
          _jspx_th_impact_validateDate_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_5.setConstraint("Date");
          int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
          if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t\t<!-- End Family Plan Dates Block -->\r\n\t\t</tr>\r\n\t\t<!-- End Principals on Plan Block and Family Plan Dates -->\r\n\t\t");

			//-------------------------------------
						//--- Permanency Plan (PPP) ---
						//-------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formRequiredText\">*</span>Permanency Plan:\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

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
		 
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selPPP");
          _jspx_th_impact_validateSelect_2.setDisabled("" + isDisabled);
          _jspx_th_impact_validateSelect_2.setCodesTable("CPERMPLN");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(fccpFamilyDetailSO.getSelPPP()));
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setExcludeOptions( excludePrimaryPlanList);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//----------------------------------------------------
						//--- Reason for selecting primary permanency plan...(PPP) ---
						//----------------------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Describe the compelling reasons for selecting a permanency plan other than (1), (02), (03), or (06):\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtPPPRsns");
          _jspx_th_impact_validateTextArea_1.setTitle("Describe the compelling reasons for selecting a permanency plan other than (01), (02), (03), or (06)");
          _jspx_th_impact_validateTextArea_1.setColspan("1");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setCols("80");
          _jspx_th_impact_validateTextArea_1.setMaxLength(500);
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(fccpFamilyDetailSO.getTxtPPPRsns()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//----------------------------------------
						//--- Concurrent Permanency Plan (PPP) ---
						//----------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Concurrent Permanency Plan\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("");
          _jspx_th_impact_validateSelect_3.setName("selSPP");
          _jspx_th_impact_validateSelect_3.setDisabled("" + isDisabled);
          _jspx_th_impact_validateSelect_3.setOrderBy("decode");
          _jspx_th_impact_validateSelect_3.setCodesTable("CPERMPLN");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper
										.formatString(fccpFamilyDetailSO.getSelSPP()));
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//---------------------------------------------------
						//--- Reason fo selecting concurrent plan...(SPP) ---
						//---------------------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Describe the compelling reasons for selecting a concurrent permanency plan other than (02), (03), or (06):\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtSPPRsns");
          _jspx_th_impact_validateTextArea_2.setTitle("Describe the compelling reasons for selecting a concurrent permanency plan other than (02), (03), or (06)");
          _jspx_th_impact_validateTextArea_2.setColspan("1");
          _jspx_th_impact_validateTextArea_2.setRows("3");
          _jspx_th_impact_validateTextArea_2.setCols("80");
          _jspx_th_impact_validateTextArea_2.setMaxLength(500);
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtSPPRsns()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//-------------------
						//--- Review Type ---
						//-------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Review Type");
          _jspx_th_impact_validateSelect_4.setName("selRvwType");
          _jspx_th_impact_validateSelect_4.setDisabled("" + isDisabled);
          _jspx_th_impact_validateSelect_4.setCodesTable("CREVWTYP");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper
										.formatString(fccpFamilyDetailSO
												.getSelRvwType()));
          _jspx_th_impact_validateSelect_4.setWidth("50%");
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//-----------------------------------------------
						//--- Reasons children cannot be safe at home ---
						//-----------------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Reasons children cannot be adequately and safely protected at home (cur. summary):\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtRsnsChildNotHome");
          _jspx_th_impact_validateTextArea_3.setTitle("Reasons children cannot be adequately and safely protected at home");
          _jspx_th_impact_validateTextArea_3.setColspan("1");
          _jspx_th_impact_validateTextArea_3.setRows("3");
          _jspx_th_impact_validateTextArea_3.setCols("80");
          _jspx_th_impact_validateTextArea_3.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtRsnsChildNotHome()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//--------------------------------------------------
						//--- Harms may occur if children remain at home ---
						//--------------------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Harms which may occur if child(ren) remains in home (future projection):\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_4.setName("txtHarmChildLeftHome");
          _jspx_th_impact_validateTextArea_4.setTitle("Harms which may occur if child(ren) remains in home");
          _jspx_th_impact_validateTextArea_4.setColspan("1");
          _jspx_th_impact_validateTextArea_4.setRows("3");
          _jspx_th_impact_validateTextArea_4.setCols("80");
          _jspx_th_impact_validateTextArea_4.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
          if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_4.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper
													.formatString(fccpFamilyDetailSO
															.getTxtHarmChildLeftInHome()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//----------------------------------------------
						//--- Projected Date of Achieving Permanency ---
						//----------------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");

					dateAsString = "";
								if (fccpFamilyDetailSO.getDtProjPerm() != null) {
									dateAsString = FormattingHelper
											.formatDate(fccpFamilyDetailSO
													.getDtProjPerm());
								}
				
          out.write("\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_6.setLabel("Projected Date of Achieving Permanency");
          _jspx_th_impact_validateDate_6.setName("dtProjPerm");
          _jspx_th_impact_validateDate_6.setType("text");
          _jspx_th_impact_validateDate_6.setValue(dateAsString);
          _jspx_th_impact_validateDate_6.setSize("10");
          _jspx_th_impact_validateDate_6.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_6.setDisabled("" + isDisabled);
          _jspx_th_impact_validateDate_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_6.setConstraint("Date");
          int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
          if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//-----------------------------
						//--- Non/Reunification Goals ---
						//-------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_2.setPage("/submodule/FCGSSubmoduleConversation/displayGoals");
          _jspx_th_impact_include_2.setCallingPage("/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
          _jspx_th_impact_include_2.setTabIndex(tabIndex++);
          _jspx_th_impact_include_2.setIncludingForm("frmFCCPFamilyDetail");
          int _jspx_eval_impact_include_2 = _jspx_th_impact_include_2.doStartTag();
          if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_2.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_2);
              _jspx_th_impact_attribute_2.setName("FCGSSubmoduleConversation.PAGE_MODE_KEY");
              _jspx_th_impact_attribute_2.setValue(pageMode);
              int _jspx_eval_impact_attribute_2 = _jspx_th_impact_attribute_2.doStartTag();
              if (_jspx_th_impact_attribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_include_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t\t<br>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

			//-----------------------
						//--- Secondary Goals ---
						//-----------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_3.setPage("/submodule/FosterCareSecGoalsSubConversation/displayFCSecGoals");
          _jspx_th_impact_include_3.setCallingPage("/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
          _jspx_th_impact_include_3.setTabIndex(tabIndex++);
          _jspx_th_impact_include_3.setIncludingForm("frmFCCPFamilyDetail");
          int _jspx_eval_impact_include_3 = _jspx_th_impact_include_3.doStartTag();
          if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_3.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_3);
              _jspx_th_impact_attribute_3.setName("FosterCareSecGoalsSubConversation.PAGE_MODE_KEY");
              _jspx_th_impact_attribute_3.setValue(pageMode);
              int _jspx_eval_impact_attribute_3 = _jspx_th_impact_attribute_3.doStartTag();
              if (_jspx_th_impact_attribute_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_include_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t\t<br>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t\r\n\t\t");

			//-----------------------------------------------------
						//--- Foster Care Case Plan Participant Information ---
						//-----------------------------------------------------
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th>\r\n\t\t\t\t\t\t\tFoster Care Case Plan Participant Information\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Has the parent participated in the development of this case plan?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setChecked(String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbParentPart())));
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_13.setOnClick("");
          _jspx_th_impact_validateInput_13.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setName("rbParentPart");
          _jspx_th_impact_validateInput_13.setLabel("Yes");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setChecked(String.valueOf(ArchitectureConstants.N
										.equals(fccpFamilyDetailSO
												.getRbParentPart())));
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_14.setOnClick("");
          _jspx_th_impact_validateInput_14.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setName("rbParentPart");
          _jspx_th_impact_validateInput_14.setLabel("No");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>If No, explain below:\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_5.setName("txtNoParentPart");
          _jspx_th_impact_validateTextArea_5.setTitle("No Parental Participation Reason");
          _jspx_th_impact_validateTextArea_5.setColspan("1");
          _jspx_th_impact_validateTextArea_5.setRows("3");
          _jspx_th_impact_validateTextArea_5.setCols("80");
          _jspx_th_impact_validateTextArea_5.setMaxLength(500);
          _jspx_th_impact_validateTextArea_5.setEditableMode(editableMode);
          _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_5.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
          if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_5.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtNoParentPart()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Has the child participated in the development of this case plan?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setChecked(String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbChildPart())));
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_15.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setName("rbChildPart");
          _jspx_th_impact_validateInput_15.setLabel("Yes");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setChecked(String.valueOf(ArchitectureConstants.N
										.equals(fccpFamilyDetailSO
												.getRbChildPart())));
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_16.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setName("rbChildPart");
          _jspx_th_impact_validateInput_16.setLabel("No");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>If No, explain below:\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_6.setName("txtNoChildPart");
          _jspx_th_impact_validateTextArea_6.setTitle("No Child Participation Reason");
          _jspx_th_impact_validateTextArea_6.setColspan("1");
          _jspx_th_impact_validateTextArea_6.setRows("3");
          _jspx_th_impact_validateTextArea_6.setCols("80");
          _jspx_th_impact_validateTextArea_6.setMaxLength(500);
          _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_6.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
          if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_6.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper
											.formatString(fccpFamilyDetailSO
													.getTxtNoChildPart()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("checkbox");
          _jspx_th_impact_validateInput_17.setLabel("Parent was present during the development of this case plan, but refused to sign the attached form");
          _jspx_th_impact_validateInput_17.setName("cbxParentRefuseSign");
          _jspx_th_impact_validateInput_17.setChecked(String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getCbxParentRefuseSign())));
          _jspx_th_impact_validateInput_17.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_17.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Hearing request submitted\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr><td valign=\"top\"><br></td></tr><tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setChecked(String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbHearReqSub())));
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_18.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setName("rbHearReqSub");
          _jspx_th_impact_validateInput_18.setLabel("Yes");
          _jspx_th_impact_validateInput_18.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setChecked(String.valueOf(ArchitectureConstants.N
										.equals(fccpFamilyDetailSO
												.getRbHearReqSub())));
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setName("rbHearReqSub");
          _jspx_th_impact_validateInput_19.setLabel("No");
          _jspx_th_impact_validateInput_19.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");

											dateAsString = "";
														if (fccpFamilyDetailSO.getDtHearReq() != null) {
															dateAsString = FormattingHelper
																	.formatDate(fccpFamilyDetailSO
																			.getDtHearReq());
														}
										
          out.write("\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_7.setLabel("If yes, record the date the hearing requested");
          _jspx_th_impact_validateDate_7.setName("dtHearReq");
          _jspx_th_impact_validateDate_7.setType("text");
          _jspx_th_impact_validateDate_7.setValue(dateAsString);
          _jspx_th_impact_validateDate_7.setSize("10");
          _jspx_th_impact_validateDate_7.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_7.setDisabled("" + isDisabled);
          _jspx_th_impact_validateDate_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_7.setConstraint("Date");
          int _jspx_eval_impact_validateDate_7 = _jspx_th_impact_validateDate_7.doStartTag();
          if (_jspx_th_impact_validateDate_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("checkbox");
          _jspx_th_impact_validateInput_20.setLabel("Case manager assistance required in requesting review hearing");
          _jspx_th_impact_validateInput_20.setName("cbxHearReqAsst");
          _jspx_th_impact_validateInput_20.setChecked(String.valueOf(ArchitectureConstants.Y
										.equals(fccpFamilyDetailSO
												.getRbHearReqAsst())));
          _jspx_th_impact_validateInput_20.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_20.setDisabled("" + isDisabled);
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t\r\n\t\t\t\t\t");

			//--------------------------------------------------
						//--- Hearing Request Comments ---
						//--------------------------------------------------
		
          out.write("\t\t\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\tHearing Request Comments:\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_7.setName("txtHearingRequestComments");
          _jspx_th_impact_validateTextArea_7.setTitle("Hearing Request Comments");
          _jspx_th_impact_validateTextArea_7.setColspan("1");
          _jspx_th_impact_validateTextArea_7.setRows("3");
          _jspx_th_impact_validateTextArea_7.setCols("80");
          _jspx_th_impact_validateTextArea_7.setMaxLength(500);
          _jspx_th_impact_validateTextArea_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_7.setDisabled("" + isDisabled);
          _jspx_th_impact_validateTextArea_7.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_7 = _jspx_th_impact_validateTextArea_7.doStartTag();
          if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_7.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t");
              out.print(FormattingHelper
															.formatString(fccpFamilyDetailSO
																	.getTxtHearingRequestComments()));
              out.write("\r\n\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_4.setPage("/submodule/FosterCarePartSubConversation/displayFCPart");
          _jspx_th_impact_include_4.setCallingPage("/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
          _jspx_th_impact_include_4.setTabIndex(tabIndex++);
          _jspx_th_impact_include_4.setIncludingForm("frmFCCPFamilyDetail");
          int _jspx_eval_impact_include_4 = _jspx_th_impact_include_4.doStartTag();
          if (_jspx_eval_impact_include_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_4.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_4);
              _jspx_th_impact_attribute_4.setName("FosterCarePartSubConversation.PAGE_MODE_KEY");
              _jspx_th_impact_attribute_4.setValue(pageMode);
              int _jspx_eval_impact_attribute_4 = _jspx_th_impact_attribute_4.doStartTag();
              if (_jspx_th_impact_attribute_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_include_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<!--  End Family Detail table -->\r\n\r\n\t");

		} // end else (not AFC)
	
          out.write('\r');
          out.write('\n');
          out.write('	');

		} // end else (not AFC)
	
          out.write("\r\n\r\n\t<hr>\r\n\t");

		//Additional constraint on Save and Submit button's visiblity:
			// When plan is created through Copy or Update (when id event still > 0), it wil be hidden just as when it was Added (idEvent = 0)
			// Use btnEdit to determine whether it is a new plan created using Update (bearing update mode) vs. updated plan is being
			// accessed through hyperlink (also has update mode)
			boolean disableSaveAndSubmit = PageModeConstants.NEW_USING
					.equals(pageMode)
					|| btnEdit || GlobalData.isApprovalMode(request);
			String bDisableSaveAndSubmit = String.valueOf(disableSaveAndSubmit);
			if (!PageModeConstants.VIEW.equals(pageMode)) {
	
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t");

				if (!PageModeConstants.NEW.equals(pageMode)) {
			
          out.write("\r\n\t\t\t<td width=\"100%\" align=\"right\">\r\n\t\t\t\t");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmFCCPFamilyDetail");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck(fieldsToBeSpellChecked);
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

				}
			
          out.write("\r\n\t\t\t");

				if (idEvent != 0) {
				  // SMS #51193: After Care Case Plans do not need to make
				  // the call to confirmPrimaryForConcurrent()
				  if(FCCPFamilyDetailConversation.AFTER_CARE.equals(casePlanMode)) {
			
          out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("SaveSubmitFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_1.setDisabled(bDisableSaveAndSubmit);
          _jspx_th_impact_ButtonTag_1.setAction("/serviceDelivery/FCCPFamilyDetail/checkFormExists");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setFunction("return confirmNoCurrentVisitationPlan()");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
    } else {
			
          out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("SaveSubmitFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_2.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_2.setDisabled(bDisableSaveAndSubmit);
          _jspx_th_impact_ButtonTag_2.setAction("/serviceDelivery/FCCPFamilyDetail/checkFormExists");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setFunction("return confirmPrimaryForConcurrent() && confirmNoCurrentVisitationPlan()");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

				  }
				} 
			
          out.write("\r\n\t\t\t");

				if (PageModeConstants.NEW.equals(pageMode)
								&& (idEvent == 0)) {
							String funcString = "cancelValidation();";
			
          out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("ContinueFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_3.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_3.setAction("/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setFunction(funcString);
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

				} else {
			
          out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("SaveFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_4.setAction("/serviceDelivery/FCCPFamilyDetail/saveFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_4.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_4.setDisabled("" + assignedJudgeDisabled);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

				}
			
          out.write("\r\n\t\t</tr>\r\n\t</table>\r\n\t");

		}else{
		 if(!assignedJudgeDisabled){
		 
          out.write("\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t   <tr>\r\n\t\t     <td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("SaveFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setAlign("right");
          _jspx_th_impact_ButtonTag_5.setForm("frmFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_5.setAction("/serviceDelivery/FCCPFamilyDetail/saveFCCPFamilyDetail");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_5.setEditableMode(EditableMode.ALL);
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t   </tr>\r\n\t\t  </table>\r\n\t");
	  
		  }
		}
	
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t<tr>\r\n\t\t<th colspan=\"4\">\r\n\t\t\tForm and Report Launch\r\n\t\t</th>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode(pageMode);
      _jspx_th_impact_documentList_0.setTabIndex(tabIndex++);
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t");

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
				
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName(victimChild.getName());
          _jspx_th_impact_document_0.setProtectDocument(protectDoc);
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setDocType("FCM05O00");
          _jspx_th_impact_document_0.setName(documentFormName);
          _jspx_th_impact_document_0.setDocExists(docExists);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pCase");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData
											.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(GlobalData
											.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pEvent");
              _jspx_th_impact_documentParameter_2.setValue(String.valueOf(idEvent));
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pPerson");
              _jspx_th_impact_documentParameter_3.setValue(String.valueOf(victimChild
													.getIdPerson()));
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_4.setName("pStageOther");
              _jspx_th_impact_documentParameter_4.setValue(String.valueOf(victimChild
											.getIdStagePrincipal()));
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

					}
						}
				
          out.write("\r\n\t\t\t");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n\r\n<script language=\"javascript\">\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest(((PageModeConstants.VIEW.equals(pageMode) == false)
							&& !isUpdateMode && !isNewUsingMode));
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  // updateDtNextReview should be removed from here to Allow the next preview date to be editable without  overwriting it \r\n  // with  a save \t\t\t\t\t\r\n  //  \tupdateDtNextReview();\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  \r\n</script>");
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

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("displayedConfirm");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnIdPlacementEvent");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_8.setName("hdnBPlanTypeChange");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
