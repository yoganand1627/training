<%/**
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

			 */%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Parameter"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.SpecialInvestigationConversation"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%
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

%>

<script language="JavaScript">

//SIR 23334 - Add Approval Rejection Hyperlink Javascript
function approvalRejectionHyperlink (index)
{
  frmApprovalStatus.hdnRejectionIndex.value = index;
  disableValidation( 'frmApprovalStatus' );
  submitValidateForm("frmApprovalStatus", "/workload/ApprovalStatus/displayApprovalRejection");
}

<%// add the onbeforeunload event iff one of approve or reject has been clicked, and it has not been saved
			if (boolApprovedRejected && !boolSaved) {%>
  // We do NOT use IsDirty() because we don't actually need to check if anything is dirty;
  //   all we need to do is prevent navigating away after clicking approve or reject but
  //   before clicking save.
  window.onbeforeunload = function ()
  {
    event.returnValue = "Your unsaved data will be lost.";
  };
<%}%>

  function launchForm()
  {
<%if (boolApprovedRejected && !boolSaved) {%>
    var returnVal = confirm( "<%=MessageLookup
										.getMessageByNumber(Messages.MSG_SAVE_BEFORE_GENERATE_FORM)%>" );

    if( returnVal == true )
    {
      // execute javascript for save
      returnVal = doSave();
    }
    return returnVal;
<%} else {%>
    return true;
<%}%>
  }

  function showApprovalDetail( index, status )
  {
    frmApprovalStatus.hdnApprovalIndex.value = index;

    var fullName = document.getElementsByName( "hdnSzNmPersonFull_" + index )[0].value;
    updateDisplayOnlyField( "frmApprovalStatus", "txtSzNmPersonFull", fullName );
    frmApprovalStatus.txtLastUpdateDate<%=disabled%>.value = document.getElementsByName( "hdnDtWCDDtSystemDate_" + index )[0].value;

    // for the time, we have to update the time text box and the am/pm dropdown seperately
    frmApprovalStatus.txtLastUpdateTime<%=disabled%>.value = document.getElementsByName( "hdnTimeDigits_" + index )[0].value;
    frmApprovalStatus.seltxtLastUpdateTime.value = document.getElementsByName( "hdnTimeAMPM_" + index )[0].value;
    frmApprovalStatus.txtSzTxtApproversComments.value = document.getElementsByName( "hdnSzTxtApproversComments_" + index )[0].value;

    // return false to prevent navigation
    return false;
  }
  
  function checkPassword() {
    var password = frmApprovalStatus.txtPassword.value;
    if(password == null || password == "") {
      alert("<%=MessageLookup
									.getMessageByNumber(Messages.MSG_CMN_NEED_PASSWORD)%>");
      return false;
    }
    return true;
  }

  function doApprove()
  {
    var passwordEntered = checkPassword();
    if(!passwordEntered) {
      return false;
    }
    
    if( frmApprovalStatus.hdnValidApprovalIndex.value != frmApprovalStatus.hdnApprovalIndex.value )
    {
      alert( "<%=MessageLookup
									.getMessageByNumber(Messages.MSG_APRVL_PASSWORD_NOT_MODIFY)%>" );
      return false;
    }
    // if we can approve it, first to see if we should add another approver
    promptAddAnotherApprover();
    return true;
  }

  function doReject()
  {
    var passwordEntered = checkPassword();
    if(!passwordEntered) {
      return false;
    }
    
    if( frmApprovalStatus.hdnValidApprovalIndex.value != frmApprovalStatus.hdnApprovalIndex.value )
    {
      alert( "<%=MessageLookup
									.getMessageByNumber(Messages.MSG_APRVL_PASSWORD_NOT_MODIFY)%>" );
      return false;
    }
    return true;
  }

  function promptAddAnotherApprover()
  {
    if( <%=approvalsPendingCount == 1%> )
    {
      // If Approval is Special Investigation, do not show the confirm box with the 'Ok'
      // and Cancel buttons. Instead show an alert box forcing user to add another approver
      if (<%=isApprovalSpclInv && !isSpclInvApproverDeputyDirect%>) {
        alert('<%=MessageLookup
							.getMessageByNumber(Messages.MSG_CMN_AUTO_ADD_APRVR)%>');
          // The alert box ok button directs us to add another approver
          frmApprovalStatus.hdnAddApprover.value = true;

      } 
      // If Approval is Safety Resource, do not show the confirm box with the 'Ok'
      // and Cancel buttons. Instead show an alert box forcing user to add another approver
      else if (<%=isApprovalSafetyRsrc && !isWhichSafetyRsrcApproverNull && !isSafetyRsrcApproverCountyDirect%>) {
        alert('<%=MessageLookup
							.getMessageByNumber(Messages.MSG_CMN_AUTO_ADD_APRVR)%>');
        // The alert box ok button directs us to add another approver
        frmApprovalStatus.hdnAddApprover.value = true;
      }
      // This is neither a Special Investigation or Safety Resource Approval or it is and this is the 
      // last approver. Confirm with the 'Ok' and the 'Cancel' buttons normally
      else {
        if( confirm( '<%=MessageLookup
							.getMessageByNumber(Messages.MSG_CMN_ADD_APRVR)%>' ) )
        {
          // The confirm box ok button directs us to add another approver
          frmApprovalStatus.hdnAddApprover.value = true;
        }
        else
        {
        // The confirm box cancel button directs us NOT TO to add another approver
          frmApprovalStatus.hdnAddApprover.value = false;
        }
      }
    }
  }

  function doSave()
  {
    var returnVal = warnStageProgression();
    if( returnVal == true )
    {
      // if we did not cancel the event through warnStageProgression(), remove the onbeforeunload check
      window.onbeforeunload = null;
    }
    return returnVal;
  }

  function warnStageProgression()
  {
    var returnVal = true;
    if( <%=ApprovalStatusConversation.APPROVALS_COMPLETE
							.equals(winResult)
					&& ApprovalStatusConversation.SP_AUTOMATIC
							.equals(cwcdCdStageProgressMode)%> )
    {
      returnVal = confirm( '<%=MessageLookup
									.getMessageByNumber(Messages.MSG_CMN_STAGE_PROGRESS)%>' );
    }
    if( returnVal )
    {
      disableValidation( "frmApprovalStatus" );
    }
    return returnVal;
  }

</script>

<impact:validateErrors/>
<impact:validateForm name="frmApprovalStatus" method="post"
                     action="/workload/ApprovalStatus/displayApprovalStatus"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusCustomValidation"
                     pageMode="<%=pageMode%>"schema="/WEB-INF/Constraints.xsd">
  <impact:validateInput type="hidden" name="hdnAddApprover" value="false" />
  <impact:validateInput type="hidden" name="hdnValidApproval" value="false" />
  <impact:validateInput type="hidden" name="hdnRejectionIndex" value="" />

<table width="100%" cellspacing="0" border="0" cellpadding="3" class="tableborder">
    <tr>
      <th>Current Status</th>
    </tr>
    <tr>
      <td class="tableBG">
        <div id="noScrollResults" style="height:100%; width:100%; overflow:auto" class="tableBorderList">
          <table width="100%" cellspacing="0" cellpadding="3">
            <tr>
              <th class="thList">Status</th>
              <th class="thList">Date</th>
              <th class="thList">Time</th>
              <th class="thList">Approver</th>
            </tr>
<%
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
%>
            <tr class="odd">
              <td colspan="4">
                 <%=MessageLookup
											.getMessageByNumber(Messages.MSG_NO_ROWS_RETURNED)%>
              </td>
            </tr>
<%
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
%>
            <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
              <td><%=status%></td>
              <td><%=approvableDate%></td>
              <td><%=approvableTime%></td>
              <td>
                <a href="#" onClick="JavaScript:return showApprovalDetail(<%=loopCount%>, '<%=statusCode%>');" tabIndex="<%=tabIndex++%>">
                  <%=FormattingHelper.formatString(approverRow
										.getSzNmPersonFull())%>
                </a>
              </td>
            </tr>
            <impact:validateInput type="hidden" name='<%="hdnSzTxtApproversComments_" + loopCount%>' value="<%=updateComments%>" />
            <impact:validateInput type="hidden" name='<%="hdnSzNmPersonFull_" + loopCount%>' value="<%=updateName%>"/>
            <impact:validateInput type="hidden" name='<%="hdnDtWCDDtSystemDate_" + loopCount%>' value="<%=updateDate%>" />
            <impact:validateInput type="hidden" name='<%="hdnTmWCDTmSystemTime_" + loopCount%>' value="<%=updateTime%>" />
            <impact:validateInput type="hidden" name='<%="hdnTimeDigits_" + loopCount%>' value="<%=updateTimeDigits%>" />
            <impact:validateInput type="hidden" name='<%="hdnTimeAMPM_" + loopCount%>' value="<%=updateTimeAMPM%>" />
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
  <%-- This hidden field needs to be after the list above because its value is
       computed during the loop that creates the list above; use String.valueOf()
       inststead of FormattingHelper.formatInt() so 0 is displayed as a valid value. --%>
  <impact:validateInput type="hidden" name='<%="hdnValidApprovalIndex"%>'
                        value="<%=String.valueOf( validApprovalIndex )%>" />
<%--  <br>--%>
  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr>
      <th colspan="5">Approval Information
        <%-- Hidden field to store the index of the current approval detail;
             this is used so we can find the correct row in the activity methods.
             The default MUST be different than the default for hdnValidapprovalIndex
             if validApprovalIndex < 0, or the page will allow clicking Approve and
             Reject even when there are no valid approvals.--%>
        <impact:validateInput type="hidden"  name="hdnApprovalIndex"
                              value='<%=validApprovalIndex >= 0 ? String.valueOf( validApprovalIndex ) : ""%>'/>
      </th>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtSzNmPersonFull" label="Approver"
                                         value='<%=approvableApprover != null ? approvableApprover : ""%>' />
      </td>
      <td align="right">
        <impact:validateDate name="txtLastUpdateDate" label="Date" required="true"
                             value='<%=approvableDate != null ? approvableDate : ""%>'
                             tabIndex="<%=tabIndex++%>" disabled="<%=approvedRejected%>" />
      </td>
      <td align="right">
        <%-- This extra table level is necessary in order to get the time filed to be properly right-justified --%>
        <table cellspacing="0" cellpadding="3">
          <tr>
            <td align="right">
              <impact:validateTime name="txtLastUpdateTime" label="Time" required="true"
                                   value='<%=approvableTime != null ? approvableTime : ""%>'
                                   tabIndex="<%=tabIndex++%>" disabled="<%=approvedRejected%>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <impact:validateTextArea name="txtSzTxtApproversComments"
                                 colspan="5"
                                 label="Comments"
                                 rows="4"
                                 cols="80" tabIndex="<%=tabIndex++%>"
                                 disabled="<%=approvedRejected%>"
                                 conditionallyRequired="true"
                                 maxLength="1000"
                                 constraint="Paragraph1000">
          <%=approvableComments != null
							? approvableComments
							: ""%>
        </impact:validateTextArea>
      </td>
    </tr>

<%
  if (PageModeConstants.EDIT.equals(pageMode)) {
%>
    <tr>
      <td align="right">
        <impact:validateInput type="password" name="txtPassword"
                              constraint="Password" disabled="<%=approvedRejected%>"
                              required="true" label="Password" tabIndex="<%=tabIndex++%>" />
        <impact:ButtonTag name="btnApproveFinal" img="btnApprove" tabIndex="<%=tabIndex++%>" disabled="<%=approvedRejected%>"
                          form="frmApprovalStatus" action="/workload/ApprovalStatus/approveStatus"
                          function="return doApprove()"/>
        <impact:ButtonTag name="btnRejectFinal" img="btnReject" tabIndex="<%=tabIndex++%>" disabled="<%=approvedRejected%>"
                          form="frmApprovalStatus" action="/workload/ApprovalStatus/rejectStatus"
                          function="return doReject()"/>
        &nbsp;
      </td>
    </tr>
<%
  }
%>
  <br>
<%
  if (PageModeConstants.EDIT.equals(pageMode)
						&& boolApprovedRejected && !boolSaved) {
%>
    <tr>
      <td colspan="5">

    <impact:ButtonTag name="btnSaveFinal" img="btnSave" tabIndex="<%=tabIndex++%>" disabled="<%=notApprovedRejected%>"
                      form="frmApprovalStatus" action="/workload/ApprovalStatus/saveStatus" restrictRepost="true"
                      function="return doSave()" align="right" />
      </td>
    </tr>

<%
  }
%>
</table>

<%
  //SIR 23334 - BEGIN HISTORICAL REASONS FOR REJECTION SECTION
				//the messageColspan variable is used to set the colspan of the "No Rows Returned" row
				if (PageModeConstants.EDIT.equals(pageMode)) { //-- possibly add: && boolSaved
					int messageColspan = 4;
%>

  <br>
  <impact:ExpandableSectionTag name="rejHistory" id="rejHistory" label="Historical Reasons for Rejection " tabIndex="<%= tabIndex++ %>" isExpanded="true">
    <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
      <tr class="subDetail">
        <th class="thList">Date</th>
        <th class="thList">Rejector</th>
        <th class="thList">Comments</th>
      </tr>

<%
  if ((PageModeConstants.EDIT.equals(pageMode) || isSupervisor)) {
							Enumeration rejEnum = rowccmni3do_array != null
									? rowccmni3do_array.enumerateROWCCMNI3DO()
									: null;

							if (rejEnum == null || !rejEnum.hasMoreElements()) {
%>
      <tr class="odd">
        <td colspan="<%=messageColspan%>">
          <%=MessageLookup
														.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
        </td>
      </tr>
<%
  int loopCount = 0;
							} else {
								int loopCounter = 1;
								Enumeration rowccmni3doEnum = rowccmni3do_array
										.enumerateROWCCMNI3DO();
								while (rowccmni3doEnum.hasMoreElements()) {
									ROWCCMNI3DO rejectionRow = (ROWCCMNI3DO) rowccmni3doEnum
											.nextElement();
%>
      <tr class="<%=FormattingHelper
													.getRowCss(loopCounter++)%>" valign="top">
        <td><%=FormattingHelper
															.formatDate(rejectionRow
																	.getDtDtRejection())%></td>
        <td><%=rejectionRow.getSzNMRejector()%></td>
        <td><%=rejectionRow
															.getSzTxtApproversComments()%></td>
      </tr>
<%
  }
							}
						} else {
							int rowQnty = rowccmni3do_array != null
									? rowccmni3do_array.getUlRowQty()
									: 0;
							if (rowQnty == 0) {
%>
      <tr class="odd">
        <td colspan="<%=messageColspan%>">
          <%=MessageLookup
														.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
        </td>
      </tr>
      <%
        int loopCount = 0;
      %>
    <%
      } else { //end approval rejection display only if statement
    								int loopCount = 0;
    								//use the ulRowQty to get the last row out of the array. The last row is always the most
    								//recent rejection.
    								ROWCCMNI3DO currentRejectionRow = (ROWCCMNI3DO) rowccmni3do_array
    										.getROWCCMNI3DO(rowQnty - 1);
    %>
      <tr class="<%=FormattingHelper
												.getRowCss(loopCount + 1)%>" valign="top">
        <td>
          <%=FormattingHelper
												.formatDate(currentRejectionRow
														.getDtDtRejection())%>
        </td>
        <td>
          <%=currentRejectionRow
														.getSzNMRejector()%>
        </td>
        <td>
          <%=currentRejectionRow
												.getSzTxtApproversComments()%>
        </td>
      </tr>
    <%
      }
    						}
    %>

    </table>


  </impact:ExpandableSectionTag>

  <%
    }
  				//SIR 23334 - END HISTORICAL REASONS FOR REJECTION SECTION
  %>
  <br>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">


</impact:validateForm>


