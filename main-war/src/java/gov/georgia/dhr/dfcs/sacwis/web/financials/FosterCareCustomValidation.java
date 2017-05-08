package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Income Resource Custom validation class <p>Description:  This class verifies all of the information in the Person
 * Detail conversation </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <pre>
 *                   Change History:
 *                    Date        User      Description
 *                    ----------  --------  --------------------------------------------------
 *                    05/13/03    GRIMSHAN  SIR #17422 Since the From and To fields are both
 *                                          no longer required, ensure that if one has been
 *                                          entered the other has as well.
 *          <p/>
 *                    10/14/03    CORLEYAN  SIR 19857 -- ContextHelper.get... replaces
 *                                          getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD
 *                                          removed message lookup.
 *          <p/>
 *                   </pre>
 */

@SuppressWarnings("serial")
public class FosterCareCustomValidation extends FormValidation {

  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();

    String reversal = ContextHelper.getStringSafe(request, "cbxReversal");
    double income = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtSvcDtlIncome");
    double unitRate = ContextHelper.getDoubleSafe(request, "txtDAmtSvcDtlUnitRate");
    int fromDay = ContextHelper.getIntSafe(request, "txtSNbrSvcDtlFromDay");
    int toDay = ContextHelper.getIntSafe(request, "txtSNbrSvcDtlToDay");
    int month = ContextHelper.getIntSafe(request, "txtUMoSvcDtlSvcMonth");
    int year = ContextHelper.getIntSafe(request, "txtUYrSvcDtlServiceYear");
    org.exolab.castor.types.Date receivedDate = getNonNullDate(ContextHelper.getCastorDateSafe(request, "hdnDtDtInvoReceivedDate"));
    //int unitQty = 0;
    double unitQty = ContextHelper.getDoubleSafe(request, "hdnSNbrSvcDtlUnitQty");
    double calcTotal = 0.0;
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
    int thisMonth = today.getMonth();
    int thisYear = today.getCentury() * 100 + today.getYear();
    int fiscalMonth = 9;
    int fiscalYear = 0;
    int receivedMonth = receivedDate.getMonth();
    int receivedYear = receivedDate.getCentury() * 100 + receivedDate.getYear();
    String message = "";
    double subTotal = 0.0;
    String indValidate = ContextHelper.getStringSafe(request, "hdnIndValidate");

    String fosterFromDate = "" + month + "/" + fromDay + "/" + year;
    String fosterToDate = "" + month + "/" + toDay + "/" + year;

    // If this month is less than nine set the fiscal year (to be used for calculations later)
    // to this year minus 3 years.  Otherwise, set it to this year minus 2 years.
    if (thisMonth < 9) {
      fiscalYear = thisYear - 3;
    } else {
      fiscalYear = thisYear - 2;
    }

    //Calculate Item total for message verification
    double roundRate = Math.round(unitRate * 100) / 100.0;

    //if (toDay == 0 && fromDay == 0) {
    //  unitQty = 0;
    //} else {
    //  unitQty = (toDay - fromDay) + 1;
    //}
    
    if("R".equals(reversal)) {
      unitQty *= -1;
    }

    //Don't calculate subTotal if unitQty is less than 0 (which means the user
    //entered a toDay that was less than the fromDay)
    //if (unitQty >= 0) {
    //  subTotal = (unitQty * roundRate);
    //}
    
    subTotal = unitQty * roundRate;

    if ("R".equals(reversal)) {
      //calcTotal = subTotal * -1;
      calcTotal = subTotal;
      message = MessageLookup.getMessageByNumber(Messages.SSM_FIN_INC_GRTR_THN_ITM);
      message = MessageLookup.addMessageParameter(message, calcTotal);
      // If the invoice was indcated as a reversal, income cannot be positive
      if (income > 0.0) {
        setErrorMessage(Messages.SSM_INC_POS_REVERSAL);
        result = false;
      }
      // income cannot be less than item total for a reversal
      else if (income < calcTotal) {
        setErrorMessage(message);
        result = false;
      }
      // Income cannot be more than 0 if today and from day have not been entered
      //else if ((toDay == 0 || fromDay == 0) && income != 0) {
      else if (unitQty == 0.0 && income != 0) {
        setErrorMessage(message);
        result = false;
      }
    } else {
      message = MessageLookup.getMessageByNumber(Messages.SSM_FIN_INC_GRTR_THN_ITM);
      message = MessageLookup.addMessageParameter(message, subTotal);
      // Income cannot be less than 0 if it is not a reversal
      if (income < 0.0) {
        setErrorMessage(Messages.SSM_FIN_INC_NEG);
        result = false;
      }
      // Income cannot be greater than subTotal if it is not a reversal line item
      else if (income > subTotal) {
        setErrorMessage(message);
        result = false;
      }
      // Income cannot be more than 0 if today and from day have not been entered
      //else if ((toDay == 0 || fromDay == 0) && income != 0) {
      else if (unitQty == 0.0 && income != 0) {
        setErrorMessage(message);
        result = false;
      }
    }

    // Unit Rate cannot be negative
    if (unitRate < 0.0) {
      setErrorMessage("txtDAmtSvcDtlUnitRate", Messages.SSM_NO_NEG_UNIT_RATE);
      result = false;
    }
    // Year cannot be greater than this year
    if (year > thisYear) {
      setErrorMessage(Messages.SSM_FIN_INVALID_MO_YEAR);
      result = false;
    } else if (year == thisYear) {
      // If year is equal to this year, the month cannot be later than this month
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

    // year entered cannot be greater than the received year of the invoice
    if (year > receivedYear) {
      setErrorMessage(Messages.MSG_MO_YR_GRTR_REC);
      result = false;
    } else if (year == receivedYear) {
      // If year is equal to received year, month cannot be greater than received month
      if (month > receivedMonth) {
        setErrorMessage(Messages.MSG_MO_YR_GRTR_REC);
        result = false;
      }
    }
    // to day cannot be less than from day
    // SIR 17422 ensure that if one day is entered, that the other is entered as well
    if ((fromDay > toDay) || (fromDay == 0 && toDay != 0) || (fromDay != 0 && toDay == 0)) {
      setErrorMessage(Messages.SSM_FIN_FROM_GRTR_THAN_TO);
      result = false;
    }
    // page cannot be saved if the information has not been validated
    if (indValidate != null && "N".equals(indValidate)) {
      setErrorMessage(Messages.MSG_VAL_SAVE);
      result = false;
    }

    org.exolab.castor.types.Date convertFromDate = DateHelper.toCastorDateSafe(fosterFromDate);
    org.exolab.castor.types.Date convertToDate = DateHelper.toCastorDateSafe(fosterToDate);
    // Make sure that days entered are valid for the month entered
    if (fromDay != 0 && convertFromDate == null) {
      setErrorMessage(Messages.MSG_INVLD_DAY_MNTH);
      result = false;
    }

    if (toDay != 0 && convertToDate == null) {
      setErrorMessage(Messages.MSG_INVLD_DAY_MNTH);
      result = false;
    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }
  
  private org.exolab.castor.types.Date getNonNullDate(org.exolab.castor.types.Date cDate) {
    if(cDate == null) {
      cDate = DateHelper.MAX_CASTOR_DATE;
    }
    return cDate;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "FosterCareCustomValidation";
}