package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --
// -- grnds classes --
// -- javax classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Contract Search.jsp Custom validation class This method checks all custom validation for the Contract Search page
 * 
 * @author Eric Dickman
 * @version 1.0 <p/> Change History: Date User Description -------- -----------
 *          ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *          getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */

public class ContractSearchCustomValidation extends FormValidation {
  /**
   * The validate Form Method handles the following error messages for the Contract Search page;
   * MSG_LIC_CMPLT_DT_INV_BEGUN MSG_CFC_NO_ILS, and SSM_COMPLETE_REQUIRED.
   * 
   * @return results
   */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    boolean results = true;
    if (this.isButtonPressed("btnSearch")) {
      org.exolab.castor.types.Date dateFrom = ContextHelper.getCastorDateSafe(request, "txtDtCnperStart");
      org.exolab.castor.types.Date dateTo = ContextHelper.getCastorDateSafe(request, "txtDtCnperTerm");

      // MSG_LIC_CMPLT_DT_INV_BEGUN Message -- Ensures the From Date is not greater than the to date
      if (dateFrom != null && dateTo != null && DateHelper.isBefore(dateTo, dateFrom)) {
        setErrorMessage("txtDtCnperStart", Messages.SSM_CON_FROM_BEF_SAME_TO);
        results = false;
      }

      int contractId = ContextHelper.getIntSafe(request, "txtIdContract");
      int resourceId = ContextHelper.getIntSafe(request, "txtIdResource");

      // String programType = super.getInputValue("selCdCntrctProgramType");

      // SSM_COMPLETE_REQUIRED message -- ensures the user enters a value for the Program Type, Contract Id, or resource
      // Id
      if (contractId == 0 && resourceId == 0) {
        setErrorMessage("txtIdResource", Messages.SSM_COMPLETE_REQUIRED);
        results = false;
      }

    }
    // PerformanceTrace
    performanceTrace.getTotalTime();
    performanceTrace.exitScope(results);

    return results;
  }

  /**
   * ***************************************************************************** * Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "ContractSearchCustomValidation";

}