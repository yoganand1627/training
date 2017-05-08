package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Parameter;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.SpecialInvestigationConversation;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class ApprovalStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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

/**
			 * JSP Name:     ApprovalStatus.jsp
			 * Created by:   Michael K. Werle
			 * Date Created: 10/25/02
			 *
			 * Description:
			 * The Approval Status page is the means by which a reviewer can make a
			 * determination of whether or not to approve a package of events.  The page is
			 * either passed an ID TODO, ID EVENT, or ID APPROVAL.  Based on this passed
			 * information the page will populate with visible and stored information
			 * related to the correct instance of approval.
			 **/
			/*
			 Change History:
			 Date      User              Description
			 --------  ----------------  -----------------------------------------------
			 08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
			 02/28/05  CORLYEAN          SIR 23445 - After the user has approved or rejected
			                             the approval use the values in state for re-displaying the page.
			 07/18/05  CASDORJM          SIR 23334 - Added in all APPROVAL REJECTION fields and
			                             corresponding javascript.

			 08/05/05 CASDORJM           SIR 23869 - Changed the comments box attribute from readOnly to disabled.

			 08/10/05   CASDORJM         SIR 23888- Modified the form tag to accept another parameter.

			 08/16/05  CASDORJM          SIR 23901- Modified the logic that determines whether
			                             the reasons for rejection section will be displayed.
			 11/17/09  arege             SMS#38461 Added constraint="Paragraph1000" to the comments field to restrict 
			                             number of characters to 1000. 
             06/10/11  hjbaptiste        SMS#109631: CAPTA 4.3: Special Investigation/Safety Resource - Add multiple approvers
             06/20/11  hjbaptiste        SMS#112385: CAPTA 4.3: Safety Resource - fixed logic to add another approver
             06/27/11  hjbaptiste        SMS#112385: CAPTA 4.3: Safety Resource - fixed logic to show original 'ok' or 'cancel'
                                         pop-up message when approving safety resource and approver is county director
             07/07/11  hjbaptiste        SMS#114335: CAPTA 4.3: Safety Resource - Not showing the secondary approver pop-up if
                                         the indicator that indicates which safety resource approver is null                           

			 */
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String pageMode = PageMode.getPageMode(request);
			//
			// get the user id
			UserProfile user = UserProfileHelper.getUserProfile(request);

			int tabIndex = 1;
			//SIR23334 - Use these task codes to tell when to display the Reasons for Rej section.
			//We need to display the Reasons for Rejection for the Aps Investigation Contacts and
			//APS SVC Contacts because the "Approval Status" button appears on the aps inv contact
			// task 2030 and svc contact task 6020 for the Investigation Conclusion and Service
			//Delivery Closure when the conclusion/closure has an approval.
			String APS_INV_CONTACT_TASK = "2030";
			String APS_SVC_CONTACT_TASK = "6020";

			String SPCL_INV_APPROVAL_TASK = "2265";

			Screen screen = (Screen) request.getAttribute("screen");
			Parameter p = screen.getParameter("HtmlTitle");

			BaseSessionStateManager state = (BaseSessionStateManager) request
					.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
			CCMN34SO ccmn34so = (CCMN34SO) state.getAttribute(
					ApprovalStatusConversation.CCMN34SO_KEY, request);
			ROWCCMN56DO_ARRAY rowccmn56do_array = ccmn34so != null ? ccmn34so
					.getROWCCMN56DO_ARRAY() : null;
			AprvlStageProg aprvlStageProg = ccmn34so != null ? ccmn34so
					.getAprvlStageProg() : null;
			String cwcdCdStageProgressMode = aprvlStageProg != null
					? aprvlStageProg.getCWCDCdStageProgressMode()
					: null;

			ROWCCMNI3DO_ARRAY rowccmni3do_array = ccmn34so != null ? ccmn34so
					.getROWCCMNI3DO_ARRAY() : null;

			ROWCCMNI2DI rowccmni2di = (ROWCCMNI2DI) request
					.getAttribute(ApprovalStatusConversation.ROWCCMNI2DI_KEY);
			rowccmni2di = rowccmni2di != null ? rowccmni2di : new ROWCCMNI2DI();

			// check to see if the user is a supervisor
			boolean isSupervisor = user.getSysSupervisorAccess();
			String approvalTask = (String) request.getAttribute("approvalTask");
			boolean isApprovalSpclInv = (ApprovalStatusConversation.SPCL_INV_APPROVAL_TASK
					.equals(approvalTask));
			boolean isSpclInvApproverSuper = (SpecialInvestigationConversation.SUPERVISOR
					.equals(ccmn34so.getSzWhichSpclInvApprover()))
					? true
					: false;
			boolean isSpclInvApproverCountyDirect = (SpecialInvestigationConversation.COUNTY_DIRECTOR
					.equals(ccmn34so.getSzWhichSpclInvApprover()))
					? true
					: false;
			boolean isSpclInvApproverPolicyUnit = (SpecialInvestigationConversation.POLICY_UNIT
					.equals(ccmn34so.getSzWhichSpclInvApprover()))
					? true
					: false;
			boolean isSpclInvApproverDeputyDirect = (SpecialInvestigationConversation.DEPUTY_DIRECTOR
					.equals(ccmn34so.getSzWhichSpclInvApprover()))
					? true
					: false;
            // Check to see if approving Safety Resource (in INV or ONG)
            boolean isApprovalSafetyRsrc = (ApprovalStatusConversation.APPROVE_SAFETY_RESOURCE
					.equals(approvalTask) || ApprovalStatusConversation.APPROVE_SAFETY_RESOURCE_ONG
					.equals(approvalTask));
            boolean isSafetyRsrcApproverSuper = (SpecialInvestigationConversation.SUPERVISOR
					.equals(ccmn34so.getSzWhichSafetyRsrcApprover()))
					? true
					: false;
			boolean isSafetyRsrcApproverCountyDirect = (SpecialInvestigationConversation.COUNTY_DIRECTOR
					.equals(ccmn34so.getSzWhichSafetyRsrcApprover()))
					? true
					: false;
			boolean isWhichSafetyRsrcApproverNull = (ccmn34so.getSzWhichSafetyRsrcApprover() == null) ? true : false;					
			// Check to see what buttons have been pressed
			String winResult = (String) state.getAttribute(
					ApprovalStatusConversation.WIN_RESULT_KEY, request);
			boolean boolApprovedRejected = winResult != null ? true : false;
			boolean boolSaved = state.getAttribute(
					ApprovalStatusConversation.SAVED_KEY, request) != null
					? true
					: false;

			// check to see if we should display the document
			boolean boolDisplayDocument = request
					.getAttribute(ApprovalStatusConversation.DISPLAY_DOCUMENT_KEY) != null
					? true
					: false;

			// check to see if we should display the reasons for rejection
			//boolean displayRejectionReasons = state.getAttribute(ApprovalStatusConversation.BOOL_DISPLAY_REJ_KEY, request) != null ? true : false;

			// use this boolean to determine which reasons for rejection to display.
			boolean inApsInv = (CodesTables.CPGRMS_APS.equals(GlobalData
					.getSzCdStageProgram(request)) && CodesTables.CSTAGES_INV
					.equals(GlobalData.getSzCdStage(request)));

			String approvedRejected = null;
			String notApprovedRejected = null;
			// We need to check if approved or rejected were clicked if save was not clicked.
			// If save has been clicked, Approved or Rejected must have been clicked.
			approvedRejected = (boolSaved || boolApprovedRejected)
					? "true"
					: "false";
			notApprovedRejected = (boolSaved || boolApprovedRejected)
					? "false"
					: "true";

			// count the number of pending approvals
			int approvalsPendingCount = ApprovalStatusConversation
					.countApprovalsPending(ccmn34so);

			// set approval index key if we've clicked approve or reject
			String approvalIndexString = (String) state.getAttribute(
					ApprovalStatusConversation.APPROVAL_INDEX_KEY, request);
			int approvalIndex = approvalIndexString != null ? Integer
					.parseInt(approvalIndexString) : -1;

			// if we're disabled, this needs to be used to reference some fields in javascript
			String disabled = pageMode.equals(PageModeConstants.VIEW)
					|| boolApprovedRejected ? "_Disabled" : "";

			// Trigger this flag to true in order to display the Form Launcher located at the bottom of the page  
			boolean displayFormLauncher = true;


      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n\r\n//SIR 23334 - Add Approval Rejection Hyperlink Javascript\r\nfunction approvalRejectionHyperlink (index)\r\n{\r\n  frmApprovalStatus.hdnRejectionIndex.value = index;\r\n  disableValidation( 'frmApprovalStatus' );\r\n  submitValidateForm(\"frmApprovalStatus\", \"/workload/ApprovalStatus/displayApprovalRejection\");\r\n}\r\n\r\n");
// add the onbeforeunload event iff one of approve or reject has been clicked, and it has not been saved
			if (boolApprovedRejected && !boolSaved) {
      out.write("\r\n  // We do NOT use IsDirty() because we don't actually need to check if anything is dirty;\r\n  //   all we need to do is prevent navigating away after clicking approve or reject but\r\n  //   before clicking save.\r\n  window.onbeforeunload = function ()\r\n  {\r\n    event.returnValue = \"Your unsaved data will be lost.\";\r\n  };\r\n");
}
      out.write("\r\n\r\n  function launchForm()\r\n  {\r\n");
if (boolApprovedRejected && !boolSaved) {
      out.write("\r\n    var returnVal = confirm( \"");
      out.print(MessageLookup
										.getMessageByNumber(Messages.MSG_SAVE_BEFORE_GENERATE_FORM));
      out.write("\" );\r\n\r\n    if( returnVal == true )\r\n    {\r\n      // execute javascript for save\r\n      returnVal = doSave();\r\n    }\r\n    return returnVal;\r\n");
} else {
      out.write("\r\n    return true;\r\n");
}
      out.write("\r\n  }\r\n\r\n  function showApprovalDetail( index, status )\r\n  {\r\n    frmApprovalStatus.hdnApprovalIndex.value = index;\r\n\r\n    var fullName = document.getElementsByName( \"hdnSzNmPersonFull_\" + index )[0].value;\r\n    updateDisplayOnlyField( \"frmApprovalStatus\", \"txtSzNmPersonFull\", fullName );\r\n    frmApprovalStatus.txtLastUpdateDate");
      out.print(disabled);
      out.write(".value = document.getElementsByName( \"hdnDtWCDDtSystemDate_\" + index )[0].value;\r\n\r\n    // for the time, we have to update the time text box and the am/pm dropdown seperately\r\n    frmApprovalStatus.txtLastUpdateTime");
      out.print(disabled);
      out.write(".value = document.getElementsByName( \"hdnTimeDigits_\" + index )[0].value;\r\n    frmApprovalStatus.seltxtLastUpdateTime.value = document.getElementsByName( \"hdnTimeAMPM_\" + index )[0].value;\r\n    frmApprovalStatus.txtSzTxtApproversComments.value = document.getElementsByName( \"hdnSzTxtApproversComments_\" + index )[0].value;\r\n\r\n    // return false to prevent navigation\r\n    return false;\r\n  }\r\n  \r\n  function checkPassword() {\r\n    var password = frmApprovalStatus.txtPassword.value;\r\n    if(password == null || password == \"\") {\r\n      alert(\"");
      out.print(MessageLookup
									.getMessageByNumber(Messages.MSG_CMN_NEED_PASSWORD));
      out.write("\");\r\n      return false;\r\n    }\r\n    return true;\r\n  }\r\n\r\n  function doApprove()\r\n  {\r\n    var passwordEntered = checkPassword();\r\n    if(!passwordEntered) {\r\n      return false;\r\n    }\r\n    \r\n    if( frmApprovalStatus.hdnValidApprovalIndex.value != frmApprovalStatus.hdnApprovalIndex.value )\r\n    {\r\n      alert( \"");
      out.print(MessageLookup
									.getMessageByNumber(Messages.MSG_APRVL_PASSWORD_NOT_MODIFY));
      out.write("\" );\r\n      return false;\r\n    }\r\n    // if we can approve it, first to see if we should add another approver\r\n    promptAddAnotherApprover();\r\n    return true;\r\n  }\r\n\r\n  function doReject()\r\n  {\r\n    var passwordEntered = checkPassword();\r\n    if(!passwordEntered) {\r\n      return false;\r\n    }\r\n    \r\n    if( frmApprovalStatus.hdnValidApprovalIndex.value != frmApprovalStatus.hdnApprovalIndex.value )\r\n    {\r\n      alert( \"");
      out.print(MessageLookup
									.getMessageByNumber(Messages.MSG_APRVL_PASSWORD_NOT_MODIFY));
      out.write("\" );\r\n      return false;\r\n    }\r\n    return true;\r\n  }\r\n\r\n  function promptAddAnotherApprover()\r\n  {\r\n    if( ");
      out.print(approvalsPendingCount == 1);
      out.write(" )\r\n    {\r\n      // If Approval is Special Investigation, do not show the confirm box with the 'Ok'\r\n      // and Cancel buttons. Instead show an alert box forcing user to add another approver\r\n      if (");
      out.print(isApprovalSpclInv && !isSpclInvApproverDeputyDirect);
      out.write(") {\r\n        alert('");
      out.print(MessageLookup
							.getMessageByNumber(Messages.MSG_CMN_AUTO_ADD_APRVR));
      out.write("');\r\n          // The alert box ok button directs us to add another approver\r\n          frmApprovalStatus.hdnAddApprover.value = true;\r\n\r\n      } \r\n      // If Approval is Safety Resource, do not show the confirm box with the 'Ok'\r\n      // and Cancel buttons. Instead show an alert box forcing user to add another approver\r\n      else if (");
      out.print(isApprovalSafetyRsrc && !isWhichSafetyRsrcApproverNull && !isSafetyRsrcApproverCountyDirect);
      out.write(") {\r\n        alert('");
      out.print(MessageLookup
							.getMessageByNumber(Messages.MSG_CMN_AUTO_ADD_APRVR));
      out.write("');\r\n        // The alert box ok button directs us to add another approver\r\n        frmApprovalStatus.hdnAddApprover.value = true;\r\n      }\r\n      // This is neither a Special Investigation or Safety Resource Approval or it is and this is the \r\n      // last approver. Confirm with the 'Ok' and the 'Cancel' buttons normally\r\n      else {\r\n        if( confirm( '");
      out.print(MessageLookup
							.getMessageByNumber(Messages.MSG_CMN_ADD_APRVR));
      out.write("' ) )\r\n        {\r\n          // The confirm box ok button directs us to add another approver\r\n          frmApprovalStatus.hdnAddApprover.value = true;\r\n        }\r\n        else\r\n        {\r\n        // The confirm box cancel button directs us NOT TO to add another approver\r\n          frmApprovalStatus.hdnAddApprover.value = false;\r\n        }\r\n      }\r\n    }\r\n  }\r\n\r\n  function doSave()\r\n  {\r\n    var returnVal = warnStageProgression();\r\n    if( returnVal == true )\r\n    {\r\n      // if we did not cancel the event through warnStageProgression(), remove the onbeforeunload check\r\n      window.onbeforeunload = null;\r\n    }\r\n    return returnVal;\r\n  }\r\n\r\n  function warnStageProgression()\r\n  {\r\n    var returnVal = true;\r\n    if( ");
      out.print(ApprovalStatusConversation.APPROVALS_COMPLETE
							.equals(winResult)
					&& ApprovalStatusConversation.SP_AUTOMATIC
							.equals(cwcdCdStageProgressMode));
      out.write(" )\r\n    {\r\n      returnVal = confirm( '");
      out.print(MessageLookup
									.getMessageByNumber(Messages.MSG_CMN_STAGE_PROGRESS));
      out.write("' );\r\n    }\r\n    if( returnVal )\r\n    {\r\n      disableValidation( \"frmApprovalStatus\" );\r\n    }\r\n    return returnVal;\r\n  }\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmApprovalStatus");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/ApprovalStatus/displayApprovalStatus");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table width=\"100%\" cellspacing=\"0\" border=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n    <tr>\r\n      <th>Current Status</th>\r\n    </tr>\r\n    <tr>\r\n      <td class=\"tableBG\">\r\n        <div id=\"noScrollResults\" style=\"height:100%; width:100%; overflow:auto\" class=\"tableBorderList\">\r\n          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n            <tr>\r\n              <th class=\"thList\">Status</th>\r\n              <th class=\"thList\">Date</th>\r\n              <th class=\"thList\">Time</th>\r\n              <th class=\"thList\">Approver</th>\r\n            </tr>\r\n");

  // This index is here because we need to use it to create a hidden field below indicating which approval
				//  can be approved.  The rules are that only the first approval in pending status can be approved,
				//  and you must be either assigned to the approval or acting as the person to whom it is assigned.
				int validApprovalIndex = -1;

				// These objects are used to store the defaults associated with the approvable row in order to do the default display.
				String approvableApprover = null;
				String approvableDate = null;
				String approvableTime = null;
				String approvableComments = null;

				Enumeration approverEnum = rowccmn56do_array != null
						? rowccmn56do_array.enumerateROWCCMN56DO()
						: null;
				if (approverEnum == null || !approverEnum.hasMoreElements()) {

          out.write("\r\n            <tr class=\"odd\">\r\n              <td colspan=\"4\">\r\n                 ");
          out.print(MessageLookup
											.getMessageByNumber(Messages.MSG_NO_ROWS_RETURNED));
          out.write("\r\n              </td>\r\n            </tr>\r\n");

  } else {
					int loopCount = 0;
					Enumeration rowccmn56doEnum = rowccmn56do_array
							.enumerateROWCCMN56DO();
					while (rowccmn56doEnum.hasMoreElements()) {
						ROWCCMN56DO approverRow = (ROWCCMN56DO) rowccmn56doEnum
								.nextElement();
						String statusCode = approverRow
								.getSzCdApproversStatus();
						String status = statusCode != null
								? Lookup.simpleDecode(CodesTables.CAPPDESG,
										statusCode)
								: "";
						String updateName = null;
						String updateDate = null;
						String updateTime = null;
						// The comments always come from the approverRow, as they're null if it's pending
						String updateComments = FormattingHelper
								.formatString(approverRow
										.getSzTxtApproversComments());

						// Determine which user, date and time we should use
						// --Use the current user, date and time for a valid approval that has not been approved (the if block)
						// --Use the stored user, date and time for everything else (the else block)
						// four conditions for a valid approval
						// 1) The user cannot have already clicked approve or reject
						// 2) Its status must be PEND.
						// 3) It must be the first valid one that we encounter (tested by initializing validApprovalIndex = -1).
						// 4) The ulIdTodo associated with the approvers record must match the value in Global Data.
						int ulIdTodo = GlobalData.getUlIdTodo(request);
						if (!boolApprovedRejected
								&& CodesTables.CAPPDESG_PEND.equals(statusCode)
								&& validApprovalIndex < 0
								&& (ulIdTodo == approverRow.getLdIdTodo())) {
							validApprovalIndex = loopCount;

							updateName = user.getUserFullName();
							updateDate = ccmn34so != null
									? FormattingHelper.formatDate(ccmn34so
											.getDtWCDDtSystemDate())
									: "";
							updateTime = ccmn34so != null ? ccmn34so
									.getTmWCDTmSystemTime() : null;

							// Populate the defaults for a valid pending approval
							approvableApprover = updateName;
							approvableDate = updateDate;
							approvableTime = updateTime;
							approvableComments = updateComments;
						} else if (boolApprovedRejected
								&& approvalIndex == loopCount) {
							// SIR 23445 - If we just clicked approve or reject, use the information
							// in State for the values of the fields.
							approvableApprover = FormattingHelper
									.formatString(approverRow
											.getSzNmPersonFull());
							approvableDate = FormattingHelper
									.formatDate(approverRow
											.getDtDtApproversDetermination());
							approvableTime = approverRow
									.getTmScrTmApprovalTime();
							approvableComments = updateComments;
						} else {
							updateName = FormattingHelper
									.formatString(approverRow
											.getSzNmPersonFull());
							updateDate = FormattingHelper
									.formatDate(approverRow
											.getDtDtApproversDetermination());
							updateTime = approverRow.getTmScrTmApprovalTime();
							approvableDate = updateDate;
							approvableTime = updateTime;
						}

						// need to parse updateTime into updateTimeDigits and updateTimeAMPM
						String[] updateTimeArray = ApprovalStatusConversation
								.parseTime(updateTime);
						String updateTimeDigits = updateTimeArray[0];
						String updateTimeAMPM = updateTimeArray[1];

          out.write("\r\n            <tr class=\"");
          out.print(FormattingHelper.getRowCss(loopCount + 1));
          out.write("\" valign=\"top\">\r\n              <td>");
          out.print(status);
          out.write("</td>\r\n              <td>");
          out.print(approvableDate);
          out.write("</td>\r\n              <td>");
          out.print(approvableTime);
          out.write("</td>\r\n              <td>\r\n                <a href=\"#\" onClick=\"JavaScript:return showApprovalDetail(");
          out.print(loopCount);
          out.write(',');
          out.write(' ');
          out.write('\'');
          out.print(statusCode);
          out.write("');\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n                  ");
          out.print(FormattingHelper.formatString(approverRow
										.getSzNmPersonFull()));
          out.write("\r\n                </a>\r\n              </td>\r\n            </tr>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnSzTxtApproversComments_" + loopCount);
          _jspx_th_impact_validateInput_3.setValue(updateComments);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnSzNmPersonFull_" + loopCount);
          _jspx_th_impact_validateInput_4.setValue(updateName);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnDtWCDDtSystemDate_" + loopCount);
          _jspx_th_impact_validateInput_5.setValue(updateDate);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnTmWCDTmSystemTime_" + loopCount);
          _jspx_th_impact_validateInput_6.setValue(updateTime);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnTimeDigits_" + loopCount);
          _jspx_th_impact_validateInput_7.setValue(updateTimeDigits);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnTimeAMPM_" + loopCount);
          _jspx_th_impact_validateInput_8.setValue(updateTimeAMPM);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  loopCount++;
					}
				}

          out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnValidApprovalIndex");
          _jspx_th_impact_validateInput_9.setValue(String.valueOf( validApprovalIndex ));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"5\">Approval Information\r\n        ");
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnApprovalIndex");
          _jspx_th_impact_validateInput_10.setValue(validApprovalIndex >= 0 ? String.valueOf( validApprovalIndex ) : "");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </th>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtSzNmPersonFull");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Approver");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(approvableApprover != null ? approvableApprover : "");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td align=\"right\">\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtLastUpdateDate");
          _jspx_th_impact_validateDate_0.setLabel("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue(approvableDate != null ? approvableDate : "");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setDisabled(approvedRejected);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td align=\"right\">\r\n        ");
          out.write("\r\n        <table cellspacing=\"0\" cellpadding=\"3\">\r\n          <tr>\r\n            <td align=\"right\">\r\n              ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setName("txtLastUpdateTime");
          _jspx_th_impact_validateTime_0.setLabel("Time");
          _jspx_th_impact_validateTime_0.setRequired("true");
          _jspx_th_impact_validateTime_0.setValue(approvableTime != null ? approvableTime : "");
          _jspx_th_impact_validateTime_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTime_0.setDisabled(approvedRejected);
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td valign=\"top\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtApproversComments");
          _jspx_th_impact_validateTextArea_0.setColspan("5");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setDisabled(approvedRejected);
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(approvableComments != null
							? approvableComments
							: "");
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n");

  if (PageModeConstants.EDIT.equals(pageMode)) {

          out.write("\r\n    <tr>\r\n      <td align=\"right\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("password");
          _jspx_th_impact_validateInput_11.setName("txtPassword");
          _jspx_th_impact_validateInput_11.setConstraint("Password");
          _jspx_th_impact_validateInput_11.setDisabled(approvedRejected);
          _jspx_th_impact_validateInput_11.setRequired("true");
          _jspx_th_impact_validateInput_11.setLabel("Password");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApproveFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprove");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setDisabled(approvedRejected);
          _jspx_th_impact_ButtonTag_0.setForm("frmApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ApprovalStatus/approveStatus");
          _jspx_th_impact_ButtonTag_0.setFunction("return doApprove()");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnRejectFinal");
          _jspx_th_impact_ButtonTag_1.setImg("btnReject");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_1.setDisabled(approvedRejected);
          _jspx_th_impact_ButtonTag_1.setForm("frmApprovalStatus");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/ApprovalStatus/rejectStatus");
          _jspx_th_impact_ButtonTag_1.setFunction("return doReject()");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n");

  }

          out.write("\r\n  <br>\r\n");

  if (PageModeConstants.EDIT.equals(pageMode)
						&& boolApprovedRejected && !boolSaved) {

          out.write("\r\n    <tr>\r\n      <td colspan=\"5\">\r\n\r\n    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setDisabled(notApprovedRejected);
          _jspx_th_impact_ButtonTag_2.setForm("frmApprovalStatus");
          _jspx_th_impact_ButtonTag_2.setAction("/workload/ApprovalStatus/saveStatus");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setFunction("return doSave()");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n");

  }

          out.write("\r\n</table>\r\n\r\n");

  //SIR 23334 - BEGIN HISTORICAL REASONS FOR REJECTION SECTION
				//the messageColspan variable is used to set the colspan of the "No Rows Returned" row
				if (PageModeConstants.EDIT.equals(pageMode)) { //-- possibly add: && boolSaved
					int messageColspan = 4;

          out.write("\r\n\r\n  <br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("rejHistory");
          _jspx_th_impact_ExpandableSectionTag_0.setId("rejHistory");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Historical Reasons for Rejection ");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded(true);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n      <tr class=\"subDetail\">\r\n        <th class=\"thList\">Date</th>\r\n        <th class=\"thList\">Rejector</th>\r\n        <th class=\"thList\">Comments</th>\r\n      </tr>\r\n\r\n");

  if ((PageModeConstants.EDIT.equals(pageMode) || isSupervisor)) {
							Enumeration rejEnum = rowccmni3do_array != null
									? rowccmni3do_array.enumerateROWCCMNI3DO()
									: null;

							if (rejEnum == null || !rejEnum.hasMoreElements()) {

              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"");
              out.print(messageColspan);
              out.write("\">\r\n          ");
              out.print(MessageLookup
														.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n        </td>\r\n      </tr>\r\n");

  int loopCount = 0;
							} else {
								int loopCounter = 1;
								Enumeration rowccmni3doEnum = rowccmni3do_array
										.enumerateROWCCMNI3DO();
								while (rowccmni3doEnum.hasMoreElements()) {
									ROWCCMNI3DO rejectionRow = (ROWCCMNI3DO) rowccmni3doEnum
											.nextElement();

              out.write("\r\n      <tr class=\"");
              out.print(FormattingHelper
													.getRowCss(loopCounter++));
              out.write("\" valign=\"top\">\r\n        <td>");
              out.print(FormattingHelper
															.formatDate(rejectionRow
																	.getDtDtRejection()));
              out.write("</td>\r\n        <td>");
              out.print(rejectionRow.getSzNMRejector());
              out.write("</td>\r\n        <td>");
              out.print(rejectionRow
															.getSzTxtApproversComments());
              out.write("</td>\r\n      </tr>\r\n");

  }
							}
						} else {
							int rowQnty = rowccmni3do_array != null
									? rowccmni3do_array.getUlRowQty()
									: 0;
							if (rowQnty == 0) {

              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"");
              out.print(messageColspan);
              out.write("\">\r\n          ");
              out.print(MessageLookup
														.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

        int loopCount = 0;
      
              out.write("\r\n    ");

      } else { //end approval rejection display only if statement
    								int loopCount = 0;
    								//use the ulRowQty to get the last row out of the array. The last row is always the most
    								//recent rejection.
    								ROWCCMNI3DO currentRejectionRow = (ROWCCMNI3DO) rowccmni3do_array
    										.getROWCCMNI3DO(rowQnty - 1);
    
              out.write("\r\n      <tr class=\"");
              out.print(FormattingHelper
												.getRowCss(loopCount + 1));
              out.write("\" valign=\"top\">\r\n        <td>\r\n          ");
              out.print(FormattingHelper
												.formatDate(currentRejectionRow
														.getDtDtRejection()));
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              out.print(currentRejectionRow
														.getSzNMRejector());
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              out.print(currentRejectionRow
												.getSzTxtApproversComments());
              out.write("\r\n        </td>\r\n      </tr>\r\n    ");

      }
    						}
    
              out.write("\r\n\r\n    </table>\r\n\r\n\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");

    }
  				//SIR 23334 - END HISTORICAL REASONS FOR REJECTION SECTION
  
          out.write("\r\n  <br>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n");
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
    _jspx_th_impact_validateInput_0.setName("hdnAddApprover");
    _jspx_th_impact_validateInput_0.setValue("false");
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
    _jspx_th_impact_validateInput_1.setName("hdnValidApproval");
    _jspx_th_impact_validateInput_1.setValue("false");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_2.setName("hdnRejectionIndex");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
