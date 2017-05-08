
package gov.georgia.dhr.dfcs.sacwis.web.admin;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;


/**
 * This class is used to validate parameters entered on the OutputLaunch page.
 * 
 * @author ashwini.rege
 * 
 * Change History:
 * Date           User              Description
 * ----------    ----------------  ----------------------------------------------
 * 06/07/2010      arege           SMS#54782: Error message for required field should specify the name of required field.
 * 10/11/2011      hnguyen         STGAP00017012: MR-092 Update to not validate types for existing COMP or APRV events.
 */

@SuppressWarnings("serial")
public class OutputLaunchCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the OutputLaunch Page
   * 
   * @return true if the form data is valid; false otherwise.
   */
  // static constants
  public static final String TRACE_TAG = "OutputLaunchCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;

    String[] cbxValues = CheckboxHelper.getCheckedValues(request, "cbxCauseOfDeath");
    String comments1 = ContextHelper.getStringSafe(request, "szCommts");
    String autopsyCompleted = ContextHelper.getStringSafe(request, "rbAutopsyComp");
    String comments2 = ContextHelper.getStringSafe(request, "szCommts2");
    String repSubWithin24 = ContextHelper.getStringSafe(request, "rbRepSub");
    String comments4 = ContextHelper.getStringSafe(request, "szCommts4");
    String reportType = ContextHelper.getStringSafe(request, "rbReportType");
    String errorMessage = "";
    String eventType = ContextHelper.getStringSafe(request, "eventType"); 
    String[] visitationTypes = CheckboxHelper.getCheckedValues(request,"cbxVisitationTypes");
    String eventStatus = ContextHelper.getStringSafe(request, "eventStatus");

    if (super.isButtonPressed("btnSave") || super.isButtonPressed("btnSaveSubmit") || super.isButtonPressed("btnComplete") ) {

      // Comments Required if Cause of Death is selected as Other
      for (int i = 0; i < cbxValues.length; i++) {
        String cdCause = cbxValues[i];
        if (CodesTables.CDCAUDEA_CDCOD12.equals(cdCause) && StringHelper.isEmptyOrNull(comments1)) {
          setErrorMessage("szCommts", Messages.MSG_COMMENT_REQD); 
          isValid = false;
        }
      }
      
      // Comments Required if Not Required selected for Autopsy Completed radio button
      if (CodesTables.CAUTCOMP_N.equals(autopsyCompleted) && StringHelper.isEmptyOrNull(comments2)) {
        setErrorMessage("szCommts2", Messages.MSG_COMMENT_REQD);
        isValid = false;
      }

      // Comments Required if No selected for Report Submitted within 24 hrs
      if (ArchitectureConstants.N.equals(repSubWithin24) && StringHelper.isEmptyOrNull(comments4)) {
        setErrorMessage("szCommts4", Messages.MSG_COMMENT_REQD);
        isValid = false;
      }      
     
      // SMS#54782 Report Type field is required 
      if (CodesTables.CEVNTTYP_CNS.equals(eventType) && StringHelper.isEmptyOrNull(reportType)) {
        errorMessage = "Report Type - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
        setErrorMessage(errorMessage);
        isValid = false;
      }
      
      // Visitation Type required - MR-094
      if (eventType.equalsIgnoreCase("VIS") && !eventStatus.equals("COMP") && !eventStatus.equals("APRV")) {
        if (visitationTypes.length <= 0) {
          errorMessage = "Visitation Type - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
          setErrorMessage(errorMessage);
          isValid = false;
        }
      }

    } //End of if Save OR SaveAndSubmit Button Pressed.

    performanceTrace.exitScope("result is" + isValid);
    return isValid;
  }
}
