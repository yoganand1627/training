package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

// -- grnds classes --

/**
 * PymntHistorySearch.jsp Custom validation class <p>Description:  This checks to verify valid dates are being used.
 * </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Jeff Chambers
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */

public class PymntHistorySearchCustomValidation extends FormValidation {

  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    org.exolab.castor.types.Date fromDate = ContextHelper.getCastorDateSafe(request, "txtDtSrcNbrFinPayhistFrom");
    org.exolab.castor.types.Date toDate = ContextHelper.getCastorDateSafe(request, "txtDtSrcDtFinPayhistTo");
    boolean result = true;

    // If the toDate is before the fromDate, throw this error
    if (DateHelper.isBefore(toDate, fromDate)) {
      setErrorMessage("txtDtSrcNbrFinPayhistFrom", Messages.SSM_CON_FROM_BEF_SAME_TO);
      result = false;
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
  public static final String TRACE_TAG = "PymntHistorySearchCustomValidation";
}