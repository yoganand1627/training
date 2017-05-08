package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Cost ReimbursementCustom validation class <p>Description:  This class verifies all of the information in the Cost
 * Reimbursement Detail page </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          <pre>
 *                   Change History:
 *                    Date        User      Description
 *                    ----------  --------  --------------------------------------------------
 *                    05/19/03    GRIMSHAN  SIR 17528 -- Removed message that made the user
 *                                          enter a value for one of the cost reimbursement detail
 *                                          fields, they should be allowed to 0 out the values
 *                                          to cancel the line items
 *                    10/14/03    CORLEYAN  SIR 19857 -- ContextHelper.get... replaces
 *                                          getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD
 *                                          removed message lookup.
 *          <p/>
 *                   </pre>
 */

public class CostCustomValidation extends FormValidation {
  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();

    String reversal = ContextHelper.getStringSafe(request, "hdnIndInvoiceReversal");
    double salary = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimSalary");
    double frgBenft = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimFrgBenft");
    double travel = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimTravel");
    double supply = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimSupply");
    double equip = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimEquip");
    double other = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimDtlOther");
    double adminAll = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimAdminAll");
    double offset = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimOffItem");
    String liType = ContextHelper.getStringSafe(request, "hdnSzCdCostReimLiType");

    double qty = ContextHelper.getDoubleSafe(request, "dspUNbrCostReimUnitQty");

    double unitRate = 0.0;

    if (qty > 0) {
      unitRate = (salary + frgBenft + travel + supply + equip + other + adminAll + offset) / qty;
    } else {
      unitRate = 0.0;
    }
    // Unit rate cannot be greater than 9999.99
    if (unitRate > 9999.99) {
      setErrorMessage(Messages.SSM_FIN_CR_UNIT_RATE_MAX);
      result = false;
    }

    if ((reversal != null && "N".equals(reversal)) || (liType != null && "A".equals(liType))) {
      if (salary < 0 || frgBenft < 0 ||
          travel < 0 || supply < 0 ||
          supply < 0 || equip < 0 ||
          other < 0 || adminAll < 0 ||
          offset < 0) {
        setErrorMessage(Messages.SSM_FIN_NO_NEGTVE_ENTRY);
        result = false;
      }
    }

    if (qty > 0) {
      if (salary < 0 || frgBenft < 0 ||
          travel < 0 || supply < 0 ||
          supply < 0 || equip < 0 ||
          other < 0 || adminAll < 0 ||
          offset < 0) {
        setErrorMessage(Messages.SSM_FIN_NO_POS_NEG_AMTS);
        result = false;
      }
    }
    if (qty < 0) {
      if (salary > 0 || frgBenft > 0 ||
          travel > 0 || supply > 0 ||
          supply > 0 || equip > 0 ||
          other > 0 || adminAll > 0 ||
          offset > 0) {
        setErrorMessage(Messages.SSM_FIN_NO_POS_NEG_AMTS);
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
  public static final String TRACE_TAG = "InvoiceCustomValidation";
}