package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.exolab.castor.types.Date;

/**
 * Custom Validation for the Case Summary conversation
 *
 * @author Bryon Jacob
 * @version 1.0 * 
 *          Date      User         Description 
 *          --------  -----------  ----------------------------------------------
 *          10/14/03  dickmaec     SIR 19857 -- Verified that getInputValue() value was not being used.
 *          12/22/08  charden      STGAP00005890 -- Changed code to retrieve unit from the context 
 */
public class CaseSummaryCustomValidation extends FormValidation {
  /**
   * Custom logic for validating user input
   *
   * @return Returns true if all validation passed, false if anything failed.
   */
  protected boolean validateForm() {
    GrndsExchangeContext context = getGrndsExchangeContext();
    BaseSessionStateManager state = getState();
    HttpServletRequest request = context.getRequest();
    boolean isValid = true;

    isValid = validateSave(request, context, isValid);

    //Insures that the user validates the From ID before merging
    if (isButtonPressed("btnMerge")) {
      String toID = ContextHelper.getStringSafe(context, "txtUlIdCaseMergeTo");
      String fromID = ContextHelper.getStringSafe(context, "txtUlIdCaseMergeFrom");

      //If the From ID is the same as the To ID, display message that From ID is invalid
      if (toID.equals(fromID)) {
        setErrorMessage("txtUlIdCaseMergeFrom", Messages.MSG_CFC_CONNECT_BY_LOOP);
        isValid = false;
      }
    }
    return isValid;
  }

  /** Custom validation for when user presses Save. */
  private boolean validateSave(HttpServletRequest request, GrndsExchangeContext context, boolean valid) {
    if (isButtonPressed("btnSave")) {
      //User must enter comments if Worker Safety is check for Special Handling
      if (StringHelper.isTrue(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseWorkerSafety")) &&
          "".equals(ContextHelper.getStringSafe(context, "txtSzTxtCaseWorkerSafety"))) {
        setErrorMessage(Messages.MSG_WRK_SAFETY_CMMTS_REQ);
        valid = false;
      }

      //User must enter comments is Sensitive Case is checked for Special Handling
      if (StringHelper.isTrue(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSensitive")) &&
          "".equals(ContextHelper.getStringSafe(context, "txtSzTxtCaseSensitiveCmnts"))) {
        setErrorMessage(Messages.MSG_SENSITIVE_CMMTS_REQ);
        valid = false;
      }

      CCFC19SO ccfc19so = (CCFC19SO) getState().getAttribute("CCFC19SO", request);
      if (ccfc19so != null) {
        Date storedDate = ccfc19so.getDtDtRecRtnDstryActual();
        String sDestroyDate = request.getParameter("txtDtDtRecRtnDstryActual");
        Date typedDate = DateHelper.toCastorDateSafe(sDestroyDate);

        //The user must enter reasons for extending the date for Records Retention.
        if (!(sDestroyDate == null || "".equals(sDestroyDate)) &&
            (storedDate.compareTo(typedDate) != Date.EQUALS &&
             "".equals(ContextHelper.getStringSafe(context, "txtSzTxtRecRtnDstryDtRsn")))) {
          setErrorMessage(Messages.MSG_DATE_EXTENTION_REASON);
          valid = false;
        }
      }

      if ("P".equals(ContextHelper.getStringSafe(context, "rbPrs"))) {
        //Unit, Reg/Div, and Mail Code values are required for PRS Storage Locations for Case File Management
        if ("".equals(ContextHelper.getStringSafe(context, "selSzCdOfficeRegion")) ||
            "".equals(ContextHelper.getStringSafe(context, "txtSzNbrUnit")) ) {
          setErrorMessage(Messages.MSG_PRS_CSE_SUM_REQ);
          valid = false;
        }
        // STGAP00004864:- Relaxed this message as the location can be entered for DFCS location now
        //Location address values must be blank for PRS Storage Locations for Case File Management
        /*if (!"".equals(ContextHelper.getStringSafe(context, "txtSzNmCaseFileOffice")) ||
            !"".equals(ContextHelper.getStringSafe(context, "txtSzAddrCaseFileStLn1")) ||
            !"".equals(ContextHelper.getStringSafe(context, "txtSzAddrCaseFileStLn2")) ||
            !"".equals(ContextHelper.getStringSafe(context, "txtSzAddrCaseFileCity"))) {
          setErrorMessage(Messages.MSG_LOCATION_BLANK_PRS);
          valid = false;
        }*/
      } else if ("N".equals(ContextHelper.getStringSafe(context, "rbPrs"))) {
        //Unit, Reg/Div, and Mail Code must be blank for Non-PRS Storage Locations for Case File Management
        //STGAP00005890  - corrected unit name to successfully retrieve unit from context
        if (!"".equals(ContextHelper.getStringSafe(context, "selSzCdOfficeRegion")) ||
            !"".equals(ContextHelper.getStringSafe(context, "txtSzNbrUnit"))) {
          setErrorMessage(Messages.MSG_UNIT_RD_MC_BLANK_NONPRS);
          valid = false;
        }
      }

      String sEligDate = request.getParameter("txtDtDtCaseFileArchElig");
      String sCompleteDate = request.getParameter("txtDtDtCaseFileArchCompl");
      String sCloseDate = request.getParameter("txtDtDtCaseClosed");

      org.exolab.castor.types.Date eligDate = DateHelper.toCastorDateSafe(sEligDate);
      org.exolab.castor.types.Date completeDate = DateHelper.toCastorDateSafe(sCompleteDate);
      org.exolab.castor.types.Date closeDate = DateHelper.toCastorDateSafe(sCloseDate);

      boolean nullEligDate = (sEligDate == null || "".equals(sEligDate));
      boolean nullCompleteDate = (sCompleteDate == null || "".equals(sCompleteDate));
      boolean nullCloseDate = (sCloseDate == null || "".equals(sCloseDate));

      //The Eligible Date must be before or the same as the Complete date or display error message for Case File Management.
      if (!nullEligDate && !nullCompleteDate && DateHelper.isAfter(eligDate, completeDate)) {
        setErrorMessage("txtDtDtCaseFileArchElig", Messages.SSM_ELIG_BEFORE_SAME_COMPL);
        valid = false;
      }

      //The Complete Date must be less than or the same as today's date or display message for Case File Management.
      if (!nullCompleteDate && DateHelper.isAfterToday(completeDate)) {
        setErrorMessage("txtDtDtCaseFileArchCompl", Messages.SSM_DATE_LESS_THAN_CURR);
        valid = false;
      }

      //The Eligible and Complete Dates must be greater than or the same as the Case Close date or display message for Case File Management
      if (!nullCloseDate && (!nullCompleteDate || !nullEligDate)) {
        if (DateHelper.isAfter(closeDate, completeDate)) {
          setErrorMessage("txtDtDtCaseFileArchCompl", Messages.SSM_DATE_LESS_THAN_CASE_CLOSE);
          valid = false;
        }
        if (DateHelper.isAfter(closeDate, eligDate)) {
          setErrorMessage("txtDtDtCaseFileArchElig", Messages.SSM_DATE_LESS_THAN_CASE_CLOSE);
          valid = false;
        }
      }
    }
    return valid;
  }
}
