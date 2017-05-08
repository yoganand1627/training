package gov.georgia.dhr.dfcs.sacwis.web.person;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Merge Split Custom validation class <p>Description:  This class verifies all of the information in the Person Merge
 * Split page </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(); removed InputValidation.UNSPECIFIED_INPUT_FIELD removed Message lookup
 */

public class MergeSplitCustomValidation extends FormValidation {
  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    String bIndValidate = ContextHelper.getStringSafe(request, "hdnBIndValidate");
    String cSysIndError = ContextHelper.getStringSafe(request, "hdnCSysIndError");
    int txtUlIdPersMergeForward = ContextHelper.getIntSafe(request, "txtUlIdPersMergeForward");
    int txtUlIdPersMergeClosed = ContextHelper.getIntSafe(request, "txtUlIdPersMergeClosed");

    if (super.isButtonPressed("btnMerge")) {
      // The closed person and forward person cannot have the same ID
      if (txtUlIdPersMergeForward == txtUlIdPersMergeClosed) {
        setErrorMessage(Messages.SSM_SAME_ID);
        result = false;
      }
      // In order to merge validate must be clicked first
      if ("N".equals(bIndValidate)) {
        setErrorMessage(Messages.MSG_VAL_MERGE);
        result = false;
      }
      // If an error has been returned from validation, the persons cannot be merged
      if ((cSysIndError != null && !"".equals(cSysIndError)) && ArchitectureConstants.TRUE.equals(cSysIndError)) {
        setErrorMessage(Messages.MSG_ERR_MERGE);
        result = false;
      }
    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "MergeSplitCustomValidation";
}