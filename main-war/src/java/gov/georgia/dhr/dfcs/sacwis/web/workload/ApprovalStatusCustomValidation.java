package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * User: mkw Date: Nov 1, 2002 Time: 10:06:16 AM * Change History: Date      User         Description --------
 * -----------  ---------------------------------------------- 10/14/03  dickmaec     SIR 19857 -- ContextHelper.get...
 * replaces getInputValue();
 * <p/>
 * 10/14/03  dickmaec     As part of SIR 19857, all messages where shorted from MessageLookup.getMessageByNumber(
 * Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX.
 * <p/>
 * 07/18/05  casdorjm     SIR 23334 - Added validation for new Reasons for Rejection section.
 */
public class ApprovalStatusCustomValidation extends FormValidation {
  /**
   * This validation method is only called for Approve and Reject; all other commands turn off validation.
   *
   * @return true if the form is valid
   */
  protected boolean validateForm() {
    HttpServletRequest request = getRequest();

    int approvalIndex = ContextHelper.getIntSafe(request, "hdnApprovalIndex");
    boolean rejectClicked = isButtonPressed("btnRejectFinal");
    String commentsString = ContextHelper.getStringSafe(request, "txtSzTxtApproversComments");
    boolean commentsPresent = commentsString != null && commentsString.trim().length() > 0 ? true : false;

    if (rejectClicked) {

      // reject was clicked
      if (!commentsPresent) {
        setErrorMessage("txtSzTxtApproversComments", Messages.MSG_CMN_REJECT_COMMENTS);
      }
      // SIR 23334 - if approve was clicked and any rejection reason data was entered
      // throw an error.
    }

    // Get the date and time returned for the event from the service.
    org.exolab.castor.types.Date oldDate = ContextHelper.getCastorDateSafe(request,
                                                                           "hdnDtWCDDtSystemDate_" + approvalIndex);
    String oldTime = ContextHelper.getStringSafe(request, "hdnTmWCDTmSystemTime_" + approvalIndex);
    Date oldJavaDate = DateHelper.toJavaDateSafe(oldDate, oldTime);

    // Get the date and time set by the user.
    org.exolab.castor.types.Date newDate = ContextHelper.getCastorDateSafe(request, "txtLastUpdateDate");
    String newTime = ContextHelper.getTimeSafe(request, "txtLastUpdateTime");
    Date newJavaDate = DateHelper.toJavaDateSafe(newDate, newTime);

    // If the date returned from the service is not the same as the date set by the user for the approval, and there
    //   are no comments, display a message indicating that comments are required for this case.
    if (!oldJavaDate.equals(newJavaDate) && !commentsPresent) {
      setErrorMessage(Messages.MSG_CMN_DATE_COMMENTS);
    }

    // Dates after today's date are not allowed
    if (DateHelper.isAfterToday(newDate)) {
      setErrorMessage(Messages.MSG_SVC_NO_FUTURE_DATE);
    }

    // verify that the password is not null or an empty string
    String password = ContextHelper.getStringSafe(request, "txtPassword");
    if (password == null || password.trim().length() < 1) {
      setErrorMessage("txtPassword", Messages.MSG_CMN_NEED_PASSWORD);
    }

    try {
      UserProfile userProfile = BasePrsConversation.getUserProfile(request);

      UserProfileHelper.validateLogin(userProfile.getUserLogonID(), password);
    }
    catch (SecurityException e) {
      e.printStackTrace();
      setErrorMessage("txtPassword", Messages.MSG_CMN_INVALID_PASSWORD);
      return false;
    }

    // return true iff there are no error messages set
    return this.getErrorMessages().isEmpty();
  }
}
