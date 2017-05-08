package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

/*
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *
 * 
 */

/**
 * <p/> This class validates data submitted from the Needs And Outcomes and Needs And OutComes Detail page.
 * </p>
 * <p/> <p/> Error Message Summaries are as follows:
 * </p>
 * <blockquote>
 * <ol>
 * <li> MSG_REF_ASST_DATE The Referral Date must be on or before the Assessment Completion Date.
 * <li> MSG_AGENCY_NAME Agency Name is required if any other CCFA information has been completed.
 * <li> MSG_EDU_CCFA_EXP_REQ Record why the child's CCFA Educational Assessment has not been performed.
 * <li> MSG_EDU_CCFA_DATE_REQ Enter the date the CCFA Educational Assessment was completed.
 * <li> MSG_NEEDS_OUTCOMES_DETAIL_REQ A Needs And Outcomes Detail is required to save Needs And Outcomes
 * <li> MSG_SVC_PROV_EXP_REQ Explanation is required when services have not been provided.
 * <li> MSG_NEED_NOT_MET_EXP_REQ Explanation is required when the needs have not been met.
 * </ol>
 * </blockquote>
 * 
 * @author Nandita Hegde 1/02/2007
 */
public class NeedsAndOutcomesCustomValidation extends FormValidation {

  // static constants
  private static final String TXT_DT_REFERRAL = "dtReferral";

  private static final String TXT_DT_ASSMT_COMP = "dtAssessmentCompletion";

  private static final String TXT_AGENCY_NM = "txtAgencyNm";

  private static final String TXT_ASSESSOR_NM = "txtAssessorName";

  private static final String TXT_ASSESSOR_TITLE = "txtAssessorTitle";

  private static final String IND_CCFA_EDUASSMT = "rbCCFAEdu";

  private static final String TXT_DT_CCFA_EDUASSMT = "dtCCFAEduAssmt";

  private static final String TXT_CCFA_EDUASSMT = "txtCCFAEduAssmt";

  private static final String IND_SVC_PROV = "chkServiceProvided";

  private static final String IND_NEED_MET = "chkNeedMet";

  private static final String TXT_SVC_PROV = "txtServNotProvidedRsn";

  private static final String TXT_NEED_MET = "txtNeedNotMetRsn";

  /** @return result - Returns false if the data fails validation. Returns true if the data passes validation. */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();

    boolean result = true;

    // needs and outcomes detail list
    int needsList = ContextHelper.getIntSafe(request, "hdnSize");

    // referral Date and Assessment Completion Date

    Date referralDate = ContextHelper.getJavaDateSafe(request, TXT_DT_REFERRAL);
    Date assmtCompDate = ContextHelper.getJavaDateSafe(request, TXT_DT_ASSMT_COMP);

    // CCFA Agency fields

    String agencyNm = ContextHelper.getStringSafe(request, TXT_AGENCY_NM);
    String assessorNm = ContextHelper.getStringSafe(request, TXT_ASSESSOR_NM);
    String assessorTitle = ContextHelper.getStringSafe(request, TXT_ASSESSOR_TITLE);
    String txtCCFAEduAssmt = ContextHelper.getStringSafe(request, TXT_CCFA_EDUASSMT);
    String indCCFAEduAssmt = ContextHelper.getStringSafe(request, IND_CCFA_EDUASSMT);
    String CCFAEduAssmtDate = ContextHelper.getStringSafe(request, TXT_DT_CCFA_EDUASSMT);

    // Needs and outcomes detail fields

    String indSvcProv = CheckboxHelper.getCheckboxValue(request, IND_SVC_PROV);
    String indNeedMet = CheckboxHelper.getCheckboxValue(request, IND_NEED_MET);
    String txtSvcProv = ContextHelper.getStringSafe(request, TXT_SVC_PROV);
    String txtNeedMet = ContextHelper.getStringSafe(request, TXT_NEED_MET);

    if ((super.isButtonPressed("btnSave")) || (super.isButtonPressed("btnSaveSubmit"))) {

      // -- check referral Date is before assessment completion Date

      if (!DateHelper.isNull(referralDate) && !DateHelper.isNull(assmtCompDate)) {
        if (assmtCompDate.compareTo(referralDate) < 0) {
          setErrorMessage(Messages.MSG_REF_ASST_DATE);
          result = false;

        }
      }

      // -- check to see if any of the CCFA information has been entered
      // without selecting
      // agency name
      if ((agencyNm == null || "".equals(agencyNm)) && assessorNm != null && !"".equals(assessorNm)
          && assessorTitle != null && !"".equals(assessorTitle)) {

        setErrorMessage(Messages.MSG_AGENCY_NAME);
        result = false;
      }

      // check for CCFA Education Assessment explanation when CCFA
      // educational
      // assessment has not been performed

      if (!ArchitectureConstants.N.equals(indCCFAEduAssmt) || (txtCCFAEduAssmt != null && !"".equals(txtCCFAEduAssmt))) {
      } else {
        setErrorMessage(Messages.MSG_EDU_CCFA_EXP_REQ);
        result = false;
      }

      // check if Date of CCFA Education complete date is entered when
      // educational assessment has been performed

      if (ArchitectureConstants.Y.equals(indCCFAEduAssmt) && (CCFAEduAssmtDate == null || "".equals(CCFAEduAssmtDate))) {
        setErrorMessage(Messages.MSG_EDU_CCFA_DATE_REQ);
        result = false;
      }

      // check if user has entered atleast one needs and outcomes detail
      if (needsList == 0) {
        setErrorMessage(Messages.MSG_NEEDS_OUTCOMES_DETAIL_REQ);
        result = false;

      }

    }

    // Needs and outcomes detail validation

    if (super.isButtonPressed("btnSaveDetail")) {

      // check if explanation is provided when service not provided
      if (ArchitectureConstants.N.equals(indSvcProv) && ("".equals(txtSvcProv) || txtSvcProv == null)) {
        setErrorMessage(Messages.MSG_SVC_PROV_EXP_REQ);
        result = false;
      }

      // check if explanation is provided when need not met
      if (ArchitectureConstants.N.equals(indNeedMet) && ("".equals(txtNeedMet) || txtNeedMet == null)) {
        setErrorMessage(Messages.MSG_NEED_NOT_MET_EXP_REQ);
        result = false;
      }

    }

    performanceTrace.exitScope();
    return result;
  }

  public static final String TRACE_TAG = "NeedsAndOutcomesCustomValidation";
}
