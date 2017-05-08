package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.exolab.castor.types.Date;

/**
 * Performs custom validation for Services and Referrals Checklist.
 * 
 * @author Merle A. Demo * Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/15/03 dickmaec SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(); <p/> 10/15/03 dickmaec As part of SIR 19857, all messages where shorted from
 *         MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX. <p/>
 *         06/28/04 RIOSJA SIR 16114 - Family Response section does not appear for family stages (FPR, FRE and FSU), so
 *         a response should not be required. Some of the other edits do not apply either.
 */
public class SrvcsRfrrlsChecklistCustomValidation extends FormValidation {
  /**
   * Validate for SrvcsRfrrlsChecklist.
   * 
   * @return Returns true if there are no validation errors
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();

    ROWCINV54SOG01_ARRAY rowcinv54sog01Array = (ROWCINV54SOG01_ARRAY) state.getAttribute("ROWCINV54SOG01_ARRAY",
                                                                                         request);

    String txtrbCdFamilyResponse = request.getParameter("rbCdFamilyResponse");
    String noRef = CheckboxHelper.getCheckboxValue(request, "cbxIndSvcRefChklstNoRef");
    String txtChklstComments = ContextHelper.getStringSafe(request, "txtChklstComments");
    String[] checked = null;
    String indSvcRefOtherChecked = null;
    Date dtDtCPSInvstDtlBegun = ContextHelper.getCastorDateSafe(request, "txtdtDtCPSInvstDtlBegun");
    Date dtDtFirstReferral = DateHelper.toCastorDateSafe(request.getParameter("dtDtFirstReferral"));
    int intRecordCount = 0;
    boolean result = true;

    // Get array of checkboxes information and fill variables
    if (rowcinv54sog01Array != null) {
      try {
        checked = CheckboxHelper.getCheckedValues(request, "cbxCIndSvcRefChklstNoRef");
        indSvcRefOtherChecked = CheckboxHelper.getCheckboxValue(request, "cbxCIndSvcRefChklstNoRef26");
        intRecordCount = checked.length;
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure Checkbox:" + e.getMessage());
      }
    }

    // txtrbCdFamilyResponse is set to "0" so we do not have a null pointer
    if (txtrbCdFamilyResponse == null) {
      txtrbCdFamilyResponse = "0";
    }

    // An "Y" in noRef means that the box is checked and no services are being
    // supplied Error: The No Services/ Referrals Check box must be empty if a
    // Service or Referral is selected.
    if ("Y".equals(noRef) && intRecordCount != 0) {
      setErrorMessage("cbxIndSvcRefChklstNoRef", Messages.MSG_INVALID_COMBO_SARC);
      result = false;
    } else {
      // Error: A Service/ Referral must be selected to save this page.
      if (!"Y".equals(noRef) && intRecordCount == 0) {
        setErrorMessage("cbxIndSvcRefChklstNoRef", Messages.MSG_NO_SERVICES_SARC);
        result = false;
      }

      // Temp message for having referrals/service with no date
      // Error: Services/Referrals must have a date.
      if (!"Y".equals(noRef) &&
      // STGAP00005147 - Change in app archtitecture: NULL_CASTOR_DATE is not being used in place of null date
          // anymore; use DateHelper to validate null to avoid NPE
          intRecordCount != 0 && DateHelper.isNull(dtDtFirstReferral)) {
        // "3500-12-31".equals(dtDtFirstReferral.toString())) {
        // end STGAP00005147
        setErrorMessage("dtDtFirstReferral", Messages.MSG_SERVICE_NO_DATE);
        result = false;
      }

      // Error: A Date of First Service/Referral cannot be entered if the No
      // Services/Referrals checkbox is checked
      if ("Y".equals(noRef) &&
      // STGAP00005147 - Change in app archtitecture: NULL_CASTOR_DATE is not being used in place of null date
          // anymore; use DateHelper to validate null to avoid NPE
          intRecordCount == 0 && !DateHelper.isNull(dtDtFirstReferral)) {
        // !"3500-12-31".equals(dtDtFirstReferral.toString())) {
        // end STGAP00005147
        setErrorMessage("dtDtFirstReferral", Messages.MSG_DT_INVLD_NO_SERV_SARC);
        result = false;
      }

      // Error: No Services or Referrals were provided but Family Response is not
      // Other.
      // Error: Comments must be entered if Other in family response or checkbox
      // 24 is selected.
      if ("".equals(txtChklstComments) && ("Y".equals(indSvcRefOtherChecked) || "3".equals(txtrbCdFamilyResponse))
          && "N".equals(noRef)) {
        setErrorMessage("txtChklstComments", Messages.SSM_OTHER_CODE_CHKLST);
        result = false;
      }

      // Error: A Comment is required to explain why no Services or Referrals
      // were provided
      if ("Y".equals(noRef) && "".equals(txtChklstComments)) {
        performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "Yes and null");
        setErrorMessage("txtChklstComments", Messages.MSG_NO_CMNT_NO_SERV);
        result = false;
      }

      // Validation date for first referral cannot be before the investigation
      // started.
      // RIOSJA, SIR 16114 - Does not apply to family stages (FPR, FRE and FSU)
      // because investigation start date is not available.
      if (DateHelper.isAfter(dtDtCPSInvstDtlBegun, dtDtFirstReferral) && intRecordCount != 0 && "N".equals(noRef)
          && !CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_FRE.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request))) {
        performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "Begin date error");
        setErrorMessage("dtDtFirstReferral", Messages.MSG_REF_SVC_DT_TOO_EARLY);
        result = false;
      }

      // Validation for NO Future dates where services are offered and date is not NULL.
      // STGAP00005147 - Change in app archtitecture: NULL_CASTOR_DATE is not being used in place of null date
      // anymore; use DateHelper to validate null to avoid NPE
      //if (DateHelper.isAfterToday(dtDtFirstReferral) && !"3500-12-31".equals(dtDtFirstReferral.toString())) {
      if (!DateHelper.isNull(dtDtFirstReferral) && DateHelper.isAfterToday(dtDtFirstReferral)) {
      // end STGAP00005147  
        performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "Start date error");
        setErrorMessage("dtDtFirstReferral", Messages.MSG_REF_SVC_DT_NO_FUTURE);
        result = false;
      }

      // Family Response in null and we have services provided.
      // RIOSJA, SIR 16114 - Family Response section does not appear for family
      // stages (FPR, FRE and FSU), so a response should not be required.
      if ("N".equals(noRef) && "0".equals(txtrbCdFamilyResponse)
          && !CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_FRE.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))
          && !CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request))) {
        performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "Null Family Reponse");
        setErrorMessage(Messages.SSM_CORRECT_FAM_RESP);
        result = false;
      }

    }
    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! " + result);
    performanceTrace.exitScope();

    return result;
  }

  /**
   * ***************************************************************************** * Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "SrvcsRfrrlsChecklistCustomValidation";
}
