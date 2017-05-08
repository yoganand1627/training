
package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;


/**
 * This class is used to validate parameters entered on the Children First Referral  page.
 * 
 * @author ashwini.rege
 * 
 * Change History:
 * Date           User              Description
 * ----------    ----------------  ----------------------------------------------
 * 01/29/2010     arege            Added correct error message when users marks Referral Complete checkbox 
 *                                 with no Date Referral Sent.
 * 02/08/2010     arege            STGAP00015749: Added validations for Release on File field
 */

@SuppressWarnings("serial")
public class ChildrenFirstReferralCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Children First Referral Page
   * 
   * @return true if the form data is valid; false otherwise.
   */
  // static constants
  public static final String TRACE_TAG = "ChildrenFirstReferralCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;

    String dtGenerated = ContextHelper.getStringSafe(request, "szDtReferGene");
    Date dtReferralSent = ContextHelper.getJavaDateSafe(request, "szDtReferSent");
    Date dtAckRefRecd = ContextHelper.getJavaDateSafe(request, "szDtAckRefRecd");
    Date dtPhyHelSumRecd = ContextHelper.getJavaDateSafe(request, "szDtPhyHelSumRecd");
    Date dtFamSrvTrtPlan = ContextHelper.getJavaDateSafe(request, "szDtFamSrvTrtPlan");
    Date dtToday = new java.util.Date();
    String indPhyFollowUp = ContextHelper.getStringSafe(request, "rbPhyFollowUp");
    String indRelInfSign = ContextHelper.getStringSafe(request, "rbRelSigned");
    String relOnFile = ContextHelper.getStringSafe(request, "rbRelOnFile");

    if (super.isButtonPressed("btnSave")) {

      // User attempts to save the page with any of the date fields entered as a future date. MSG_CHF_FUTURE_DATE
      if (DateHelper.isAfter(dtReferralSent, dtToday) || DateHelper.isAfter(dtAckRefRecd, dtToday)
          || DateHelper.isAfter(dtPhyHelSumRecd, dtToday) || DateHelper.isAfter(dtFamSrvTrtPlan, dtToday)) {
        setErrorMessage(Messages.MSG_CHF_FUTURE_DATE);
        isValid = false;
      }

      // User enters a date for the Physicians Health Summary without entering a response to Physician Indicated Need
      // For Further Developmental Assmt.
      if (dtPhyHelSumRecd != null && StringHelper.isEmptyOrNull(indPhyFollowUp)) {
        setErrorMessage(Messages.MSG_CHF_PHY_ASSMT);
        isValid = false;
      }

      // The user attempts to Save the page with the Referral Complete checkbox indicated
      // and no response has been given to Release of Information Form Signed by Parents. MSG_CHF_PRN_ROI
      if (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "cbxReferComp"))
          && StringHelper.isEmptyOrNull(indRelInfSign)) {
        setErrorMessage(Messages.MSG_CHF_PRN_ROI);
        isValid = false;
      }

      // The user attempts to Save the page with the Referral Complete checkbox indicated and no Date Referral Sent
      // has been entered.
      if (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "cbxReferComp"))
          && DateHelper.isNull(dtReferralSent)) {
        setErrorMessage(Messages.MSG_CHF_REF_SENT);
        isValid = false;
      }

      //The user attempts to select No for Release on File and the original answer to 
      //Release of Information Form signed by Parents was Yes
      if (ArchitectureConstants.Y.equals(indRelInfSign) && ArchitectureConstants.N.equals(relOnFile)) {
        setErrorMessage(Messages.MSG_CANNOT_SEL_NO);
        isValid = false;
      }
    } //End of if Save Button Pressed.

    performanceTrace.exitScope("result is" + isValid);
    return isValid;
  }
}
