package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * Administrative Custom validation class <p>Description:  This class verifies all of the information in the
 * Administrative Detail Page </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */

@SuppressWarnings("serial")
public class AdminCustomValidation extends FormValidation {

  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();

    String reversal = ContextHelper.getStringSafe(request, "hdnIndInvoiceReversal");
    boolean isReversal = StringHelper.isValid(reversal) && !CodesTables.CINVADJT_N.equals(reversal);
    double salaries = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlSalaries");
    double frgBenft = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlFrgBenft");
    double travel = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlTravel");
    double supplies = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlSupplies");
    double equipment = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlEquipment");
    double other = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlOther");
    double adminAlloc = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlAdminAlloc");
    double offsetItem = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlOffsetItem");
    int month = ContextHelper.getIntSafe(request, "txtUMoAdminDtlSvcMonth");
    int year = ContextHelper.getIntSafe(request, "txtUYrAdminDtlSvcYear");
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
    int thisMonth = today.getMonth();
    int thisYear = today.getCentury() * 100 + today.getYear();
    //org.exolab.castor.types.Date receivedDate = ContextHelper.getCastorDateSafe(request, "hdnDtDtInvoReceivedDate");
    int fiscalMonth = 9;
    int fiscalYear = 0;
    
    if(other != 0.0) {
      if("".equals(ContextHelper.getStringSafe(request, "txtComments"))) {
        setErrorMessage("txtComments", Messages.SSM_COMPLETE_REQUIRED);
        result = false;
      }
    }

    // If this month is less than nine set the fiscal year (to be used for calculations later)
    // to this year minus 3 years.  Otherwise, set it to this year minus 2 years.
    if (thisMonth < 9) {
      fiscalYear = thisYear - 3;
    } else {
      fiscalYear = thisYear - 2;
    }

    // If this is not a reversal, none of the fields can be less than 0
    if (!isReversal &&
        (salaries < 0.0 || frgBenft < 0.0 ||
         travel < 0.0 || supplies < 0.0 ||
         equipment < 0.0 || other < 0.0 ||
         adminAlloc < 0.0 || offsetItem < 0.0)) {
      setErrorMessage(Messages.SSM_FIN_NO_NEGTVE_ENTRY);
      result = false;
    }
    // Postive and Negative amounts cannot be entered on the same admin detail
    if ((salaries < 0.0 || frgBenft < 0.0 ||
         travel < 0.0 || supplies < 0.0 ||
         equipment < 0.0 || other < 0.0 ||
         adminAlloc < 0.0 || offsetItem < 0.0)
        &&
        (salaries > 0.0 || frgBenft > 0.0 ||
         travel > 0.0 || supplies > 0.0 ||
         equipment > 0.0 || other > 0.0 ||
         adminAlloc > 0.0 || offsetItem > 0.0)) {
      setErrorMessage(Messages.SSM_FIN_NO_POS_NEG_AMTS);
      result = false;
    }

    if (!isReversal) {
      // If it is not a reversal, Make sure that the categories
      //do not total greater than Item total.
      if (offsetItem >
          (salaries + frgBenft + travel + supplies +
           equipment + other + adminAlloc)) {
        setErrorMessage(Messages.SSM_FIN_OFFSET_GRTR_SUM);
        result = false;
      }

    }
    if (isReversal) {
      // If this invoice is a reversal and
      // If all of the items are less than or equal to 0 make sure that offset
      // Item is not less than the total of the categories
      if (salaries <= 0.0 && frgBenft <= 0.0 &&
          travel <= 0.0 && supplies <= 0.0 &&
          equipment <= 0.0 && other <= 0.0 &&
          adminAlloc <= 0.0 && offsetItem <= 0.0) {
        if (offsetItem <
            (salaries + frgBenft + travel + supplies +
             equipment + other + adminAlloc)) {
          setErrorMessage(Messages.SSM_FIN_OFFSET_GRTR_SUM);
          result = false;
        }
      }
    }

    //Year and Month entered must be less than this year and month
    if (year > thisYear) {
      setErrorMessage(Messages.SSM_FIN_INVALID_MO_YEAR);
      result = false;
    } else if (year == thisYear) {
      if (month > thisMonth) {
        setErrorMessage(Messages.SSM_FIN_INVALID_MO_YEAR);
        result = false;
      }
    }

    //Invoice month and year must be w/in the last two fiscal years
    if (year < fiscalYear) {
      setErrorMessage(Messages.SSM_FIN_SVC_YR_GRTR_MAX);
      result = false;
    } else if (year == fiscalYear) {
      if (month < fiscalMonth) {
        setErrorMessage(Messages.SSM_FIN_SVC_YR_GRTR_MAX);
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
  public static final String TRACE_TAG = "AdminCustomValidation";
}