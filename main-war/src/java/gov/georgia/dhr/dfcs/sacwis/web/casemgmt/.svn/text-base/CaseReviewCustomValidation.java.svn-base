package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

// -- java classes --

import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;



/**
 * This class is used to validate parameters entered on the Case Review page.
 * 
 * @author Bhavna Gehlot 03/10/2009
 * 
 * Change History:
 * Date        User              Description
 * --------    ----------------  ----------------------------------------------
 * 10/09/2009  bgehlot           SMS#38872: Adding new error message
 */
public class CaseReviewCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Medical Mental Assessment Page
   * 
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm()");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = getState();
    boolean isValid = true;

    //SMS#38872
    Date dtStaffedWithWorker = ContextHelper.getJavaDateSafe(request, "dtStaffedWithWorker");
    Date dtCorrectionsDue = ContextHelper.getJavaDateSafe(request, "dtCorrectionsDue");
    Date dtCorrectionsComplete = ContextHelper.getJavaDateSafe(request, "dtCorrectionsComplete");
    CaseReviewRetrieveSO caseReviewRetrieveSO = (CaseReviewRetrieveSO) state.getAttribute("CaseReviewRetrieveSO", request);
    Date dtReview = caseReviewRetrieveSO.getDtReview();
    
    if (isButtonPressed("btnSave")) {
      // SMS#38872 Date Staffed with Worker can not be before the Date of Review
      if (dtStaffedWithWorker != null && DateHelper.isBefore(dtStaffedWithWorker, dtReview)) {
         setErrorMessage("dtStaffedWithWorker", Messages.MSG_CSR_NOT_BEFORE_DT_REVIEW);
        isValid = false;
      } 
      //SMS#38872 Date Corrections Due can not be before the Date of Review
      if (dtCorrectionsDue != null && DateHelper.isBefore(dtCorrectionsDue, dtReview)) {
        setErrorMessage("dtCorrectionsDue", Messages.MSG_CSR_NOT_BEFORE_DT_REVIEW);
       isValid = false;
      } 
      //SMS#38872 Date Corrections Completed can not be before the Date of Review
      if (dtCorrectionsComplete != null && DateHelper.isBefore(dtCorrectionsComplete, dtReview)) {
        setErrorMessage("dtCorrectionsComplete", Messages.MSG_CSR_NOT_BEFORE_DT_REVIEW);
       isValid = false;
      } 
    }
    performanceTrace.exitScope("result is" + isValid);
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "CaseReviewCustomValidation";

}
