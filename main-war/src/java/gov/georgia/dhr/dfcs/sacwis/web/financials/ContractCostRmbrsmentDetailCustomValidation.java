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
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup
 */

public class ContractCostRmbrsmentDetailCustomValidation extends FormValidation {
  /**
   * This method is used to perform validation on entered items on the Contract CostReimbursementPage
   *
   * @return results
   */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    boolean results = true;

    //SSM_CON_AMT_GREAT_EQ_USED -- Verifies the Amount entered is greater then the amount used.
    if (this.isButtonPressed("btnSave")) {
      //import variables from the .jsp page
      double ulAmtCnsvcSalary = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcSalary");
      double ulAmtCnsvcSalaryUsed = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcSalaryUsed");
      double ulAmtCnsvcFrgBenft = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcFrgBenft");
      double ulAmtCnsvcFrgBenftUsed = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcFrgBenftUsed");
      double ulAmtCnsvcTravel = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcTravel");
      double ulAmtCnsvcTravelUsed = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcTravelUsed");
      double ulAmtCnsvcSupply = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcSupply");
      double ulAmtCnsvcSupplyUsed = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcSupplyUsed");
      double ulAmtCnsvcEquip = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcEquip");
      double ulAmtCnsvcEquipUsed = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcEquipUsed");
      double ulAmtCnsvcOther = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcOther");
      double ulAmtCnsvcOtherUsed = ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcOtherUsed");

      //all if statements that ulAmtCnsvc is greater than ulAmtCnsvc...Used
      if (ulAmtCnsvcSalary < ulAmtCnsvcSalaryUsed) {
        setErrorMessage("ulAmtCnsvcSalary", Messages.SSM_CON_AMT_GREAT_EQ_USED);
        results = false;
      }

      if (ulAmtCnsvcFrgBenft < ulAmtCnsvcFrgBenftUsed) {
        setErrorMessage("ulAmtCnsvcFrgBenft", Messages.SSM_CON_AMT_GREAT_EQ_USED);
        results = false;
      }

      if (ulAmtCnsvcTravel < ulAmtCnsvcTravelUsed) {
        setErrorMessage("ulAmtCnsvcTravel", Messages.SSM_CON_AMT_GREAT_EQ_USED);
        results = false;
      }

      if (ulAmtCnsvcSupply < ulAmtCnsvcSupplyUsed) {
        setErrorMessage("ulAmtCnsvcSupply", Messages.SSM_CON_AMT_GREAT_EQ_USED);
        results = false;
      }

      if (ulAmtCnsvcEquip < ulAmtCnsvcEquipUsed) {
        setErrorMessage("ulAmtCnsvcEquip", Messages.SSM_CON_AMT_GREAT_EQ_USED);
        results = false;
      }

      if (ulAmtCnsvcOther < ulAmtCnsvcOtherUsed) {
        setErrorMessage("ulAmtCnsvcOther", Messages.SSM_CON_AMT_GREAT_EQ_USED);
        results = false;
      }
    }

    //PerformanceTrace
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return results;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "ContractCostRmbrsmentDetailCustomValidation";
}




