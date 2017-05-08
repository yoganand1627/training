package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --
// -- grnds classes --
// -- javax classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * @author Eric Dickman
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */

public class ContractListCustomValidation extends FormValidation {

  /**
   * This method is used to perfrom validation on entered items on the Contract Service Detail JSP.
   *
   * @return results
   */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    //set results to true
    boolean results = true;

    HttpServletRequest request = this.getRequest();

    //if the add button is pressed verify that the CSLI hyperlink is not greater 9999
    if (this.isButtonPressed("btnAdd")) {
      //get lineitemCounter out of the request
      int lineItemCounter = ContextHelper.getIntSafe(request, "hdnLineItemCounter");
      if (lineItemCounter == LINE_AMOUNT) {
        setErrorMessage(Messages.MSG_NO_CSLI_LEFT);
        results = false;
      }
    }
    //Performance Trace
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return results
    return results;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "ContractListCustomValidation";
  public static final int LINE_AMOUNT = 9999;
}