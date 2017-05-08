package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --
// -- grnds classes --
// -- javax classes --

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * StaffDesigneeMnt.jsp Custom validation class This method checks all custom validation for the Maintain Designee page
 *
 * @author Eric Dickman
 * @version 1.0
 *          <p/>
 *          Change History: Date        User              Description --------  --------------
 *          -------------------------------------------------- 06/11/03  Todd Reser        SIR 18078 -- If the payment
 *          type is Unit Rate or Var Unit Rate then the Unit Rate has to be greater than $0.00, also added missing
 *          results = false; to other error.  Everything was getting returned as true previously. 06/16/03  Todd Reser
 *               Changed Error Message to MSG_CON_SVC_UNIT and combined if statements to complete SIR 18078. 10/14/03
 *          CORLEYAN          SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed
 *          InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class ContractDetailCustomValidation extends FormValidation {

  /**
   * This method is used to validate items submitted on the form.
   *
   * @return results
   */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    boolean results = true;

    if (this.isButtonPressed("btnSave")) {
      String contractBudgetLimit = super.getInputValue("hdnContractBudgetLimit");
      String paymentType = super.getInputValue("szNbrCnsvcPaymentType");
      String unitType = super.getInputValue("szNbrCnsvcUnitType");
      if ("N".equals(contractBudgetLimit) && "CRM".equals(paymentType)) {
        setErrorMessage(Messages.SSM_CON_INVLD_PYMNT_TYPE);
        results = false;
      }

      // SIR 18078 -- If the payment type is Unit Rate (URT) or Var Unit Rate
      // (VUR) then the Unit Rate (unitRate) has to be greater than $0.00
      double unitRate = ContextHelper.getMoneyAsDoubleSafe(this.getRequest(), "ulNbrCnsvcUnitRate");
      if (("URT".equals(paymentType) ||
           "VUR".equals(paymentType)) &&
                                      unitRate < 0.01) {
        setErrorMessage("ulNbrCnsvcUnitRate", Messages.MSG_CON_SVC_UNIT);
        results = false;
      }
      if ("UNT".equals(paymentType)) {
        setErrorMessage("szNbrCnsvcPaymentType", Messages.SSM_COMPLETE_REQUIRED);
        results = false;
      }

    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope(results);
    return results;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "MntainDesigneeCustomValidation";
}