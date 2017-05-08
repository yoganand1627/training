package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/*
 * Change History:
 *  Date      User        Description
 *  --------  ----------  --------------------------------------------------
 *  12/08/08  alwilliams  STGAP00010603 - Processed the "Was the person successfully 
 *                        contacted?" field as a required field. 
 * 
 */

/**
 * <p/> This class validates data submitted from the Diligent Search List and Diligent Search Info Page.
 * </p>
 * <p/> <p/> Error Message Summaries are as follows:
 * </p>
 * <blockquote>
 * <ol>
 * <li> MSG_DILSEARCH_CARE This person was the caretaker prior to removal; please describe why the child was removed
 * from their care.
 * <li> MSG_DILSEARCH_CONTACT Please explain why this person was not contacted.
 * <li> MSG_DILSEARCH_OUTCOME Please indicate the current outcome of contact.
 * <li> MSG_DILSEARCH_VISIT Please indicate whether this person is a willing visitation resource.
 * <li> MSG_DILSEARCH_PLACE Please indicate whether this person is a potential placement resource.
 * <li> MSG_DILSEARCH_NWHY Please indicate why this person is not a potential placement resource.
 * <li> MSG_DILSEARCH_REVCAR Please indicate the date when relative care subsidies were discussed with this person.
 * <li> MSG_DILSEARCH_OTHER Please describe when referral type is other.
 * </ol>
 * </blockquote>
 * 
 * @author Nandita Hegde 1/29/2007
 */
public class DiligentSearchCustomValidation extends FormValidation {

  // static constants

  private static final String IND_CARETAKER_REM = "cbCaretakerPriorRemoval";

  private static final String TXT_REASON_CARETAKER_REM = "txtCaretakerCmnts";

  private static final String IND_SUCC_CONTACTED = "rbSuccContacted";

  private static final String TXT_NOT_CONTACTED = "txtNotContactedCmnts";

  private static final String SEL_CURRENT_OUTCOME_CONTACT = "selCurrOutcomeContact";

  private static final String SEL_REFERRAL_TYPE = "selReferralType";

  private static final String IND_VISITATION_RESOURCE = "rbVisitationRsrc";

  private static final String IND_PLACEMENT_RESOURCE = "rbPlcmtRsrc";

  private static final String TXT_PLACEMENT_RESOURCE = "txtPlcmtRsrcCmnts";

  private static final String TXT_DT_REL_CARE = "dtRelCareSubDisc";

  private static final String TXT_OTHER = "txtOtherDesc";

  /** @return result - Returns false if the data fails validation. Returns true if the data passes validation. */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();

    boolean result = true;

    // get data from request

    String relativeCareDate = ContextHelper.getStringSafe(request, TXT_DT_REL_CARE);
    String indCaretakerRem = CheckboxHelper.getCheckboxValue(request, IND_CARETAKER_REM);
    String caretakerCmnts = ContextHelper.getStringSafe(request, TXT_REASON_CARETAKER_REM);
    String indSuccContacted = ContextHelper.getStringSafe(request, IND_SUCC_CONTACTED);
    String succNotContactedCmnts = ContextHelper.getStringSafe(request, TXT_NOT_CONTACTED);
    String currentOutcomeContact = ContextHelper.getStringSafe(request, SEL_CURRENT_OUTCOME_CONTACT);
    String indVisitationRsrc = ContextHelper.getStringSafe(request, IND_VISITATION_RESOURCE);
    String indPlacementRsrc = ContextHelper.getStringSafe(request, IND_PLACEMENT_RESOURCE);
    String placementRsrc = ContextHelper.getStringSafe(request, TXT_PLACEMENT_RESOURCE);
    String referralType = ContextHelper.getStringSafe(request, SEL_REFERRAL_TYPE);
    String other = ContextHelper.getStringSafe(request, TXT_OTHER);

    if (super.isButtonPressed("btnSave")) {

      // -- check for comments if caretaker prior removal is checked

      if (indCaretakerRem.equals("Y") && (caretakerCmnts == null || "".equals(caretakerCmnts))) {
        setErrorMessage(Messages.MSG_DILSEARCH_CARE);
        result = false;

      }

      // STGAP00010603 - Check for successfully contacted radio button selection
      // -- check for successfully contacted Yes or No button selected
      String succContacted = request.getParameter("rbSuccContacted");
      if (succContacted == null || "".equals(succContacted)) {
        setErrorMessage("Was the person successfully contacted? - This field is required.");
        result = false;
      }      
      
      // -- check for successfully not contacted comments if was the person sucessfully contacted is 'No'
      if (indSuccContacted.equals("N") && (succNotContactedCmnts == null || "".equals(succNotContactedCmnts))) {
        setErrorMessage(Messages.MSG_DILSEARCH_CONTACT);
        result = false;

      }

      // -- check for current outcome of contact ,if was the person sucessfully contacted is 'Yes'
      if (indSuccContacted.equals("Y") && (currentOutcomeContact == null || "".equals(currentOutcomeContact))) {
        setErrorMessage(Messages.MSG_DILSEARCH_OUTCOME);
        result = false;

      }

      // -- check for visitation resource ,if was the person sucessfully contacted is 'Yes'
      if (indSuccContacted.equals("Y") && (indVisitationRsrc == null || "".equals(indVisitationRsrc))) {
        setErrorMessage(Messages.MSG_DILSEARCH_VISIT);
        result = false;

      }

      // -- check for placement resource ,if was the person sucessfully contacted is 'Yes'
      if (indSuccContacted.equals("Y") && (indPlacementRsrc == null || "".equals(indPlacementRsrc))) {
        setErrorMessage(Messages.MSG_DILSEARCH_PLACE);
        result = false;

      }

      // -- check for placement resource comments ,if was the person a potential placement resource is 'No'
      if (indPlacementRsrc.equals("N") && (placementRsrc == null || "".equals(placementRsrc))) {
        setErrorMessage(Messages.MSG_DILSEARCH_NWHY);
        result = false;

      }

      // -- check for Date relative care subsidies ,if was the person sucessfully contacted is 'Yes'
      if (indSuccContacted.equals("Y") && (relativeCareDate == null || "".equals(relativeCareDate))) {
        setErrorMessage(Messages.MSG_DILSEARCH_REVCAR);
        result = false;

      }

      // check for if other ,describe ,if referral type is 'other'

      if (referralType.equals("XXX") && (other == null || "".equals(other))) {
        setErrorMessage(Messages.MSG_DILSEARCH_OTHER);
        result = false;

      }

    }

    performanceTrace.exitScope();
    return result;
  }

  public static final String TRACE_TAG = "DiligentSearchCustomValidation";
}
