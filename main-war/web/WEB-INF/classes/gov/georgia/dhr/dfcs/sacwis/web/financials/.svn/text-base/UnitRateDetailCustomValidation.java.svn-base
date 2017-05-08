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
 * This method is used to validate entered item on the Unit Rate and Cost reimbursement Detail JSP's.
 *
 * @author Eric Dickman
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */

public class UnitRateDetailCustomValidation extends FormValidation {
  /**
   * This method is used to validate items submitted in the UnitRateDetail JSP form
   *
   * @return results
   */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    //set results equal to torue
    boolean results = true;
    double unitRateCal = 0;

    //import variables from the .jsp page
    //Unit Rate Amount
    double ulAmtCnsvcUnitRate = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcUnitRate");
    //Unit Rate for the Service
    double ulNbrCnsvcUnitRate = ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlNbrCnsvcUnitRate");
    //Unit Rate Used
    double ulAmtCnsvcUnitRateUsed = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcUnitRateUsed");

    //Calculate unit rate, if the Rate for the Service is not equal to zero
    if (ulNbrCnsvcUnitRate != 0) {
      //divid unit rate amount by the unit rate for the service
      unitRateCal = ulAmtCnsvcUnitRate / ulNbrCnsvcUnitRate;
    }

    if (this.isButtonPressed("btnSave")) {
      //throws a message, if the Unit Rate is greater then 65535
      if ((unitRateCal >= 65535) && (ulNbrCnsvcUnitRate != 0)) {
        setErrorMessage(Messages.SSM_CON_TOO_MANY_UNITS);
        results = false;
      }

      //throws a message, if the Unit Rate is greater than the Unit Rate Used
      if (ulAmtCnsvcUnitRate < ulAmtCnsvcUnitRateUsed) {
        setErrorMessage(Messages.SSM_CON_AMT_GREAT_EQ_USED);
        results = false;
      }
    }
    //PerformanceTrace
    performanceTrace.getTotalTime();
    performanceTrace.exitScope(results);
    return results;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "ContractListCustomValidation";
}