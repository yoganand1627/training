package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * Delivered Service Custom validation class <p>Description:  This class verifies all of the information in the
 * Delivered Service Detail page </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: Date        User      Description ----------  --------  --------------------------------------------------
 *          05/13/03    GRIMSHAN  SIR #17509 User Math.floor to determine if fractional units have been entered 05/20/03
 *             GRIMSHAN  SIR 17582 Display the error message SSM_FIN_FPD_GRTR_THN_ITM based on if it is not a reversal,
 *          regardless of Invoice type 09/23/03    A.Corley  Remove information on calculation of unit rate SIR 19795
 *          09/30/03    CORLEYAN  SIR 19897 Make sure Cost Array is not null before trying to enumerate 10/14/03
 *          CORLEYAN  SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed
 *          InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *          <p/>
 *          </pre>
 */

@SuppressWarnings("serial")
public class DeliveredCustomValidation extends FormValidation {
  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();
    BaseSessionStateManager state = this.getState();

    int month = ContextHelper.getIntSafe(request, "txtUMoSvcDtlSvcMonth");
    int year = ContextHelper.getIntSafe(request, "txtUYrSvcDtlServiceYear");
    int invoiceMonth = ContextHelper.getIntSafe(request, "hdnUMoInvoMonth");
    int invoiceYear = ContextHelper.getIntSafe(request, "hdnUYrInvoYear");
    String paymentType = ContextHelper.getStringSafe(request, "hdnSzCdCnsvcPaymentType");
    String reversal = ContextHelper.getStringSafe(request, "hdnIndInvoiceReversal");
    boolean isReversal = StringHelper.isValid(reversal) && !CodesTables.CINVADJT_N.equals(reversal);
    String invoiceType = ContextHelper.getStringSafe(request, "hdnSzCdInvoType");
    int ulIdSvcDtl = ContextHelper.getIntSafe(request, "hdnUlIdSvcDtl");
    String szCdSvcDtlService = ContextHelper.getStringSafe(request, "selSzCdSvcDtlService");
    String indValidate = ContextHelper.getStringSafe(request, "hdnIndValidate");
    String message = "";
    double feePaid = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtSvcDtlFeePaid");
    double unitQty = ContextHelper.getDoubleSafe(request, "txtSNbrSvcDtlUnitQty");
    double unitRate = ContextHelper.getDoubleSafe(request, "txtDAmtSvcDtlUnitRate");
    double roundFee = Math.round(feePaid * 100) / 100.0;
    double roundQty = Math.round(unitQty * 100) / 100.0;
    double roundRate = Math.round(unitRate * 100) / 100.0;

    double tempTotal = (roundRate * roundQty);

    double roundTempTotal = Math.round(tempTotal * 100) / 100.0;

    int fiscalMonth = 9;
    int fiscalYear = 0;
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
    int thisMonth = today.getMonth();
    int thisYear = today.getCentury() * 100 + today.getYear();

    // If this month is less than nine set the fiscal year (to be used for calculations later)
    // to this year minus 3 years.  Otherwise, set it to this year minus 2 years.
    if (thisMonth < 9) {
      fiscalYear = thisYear - 3;
    } else {
      fiscalYear = thisYear - 2;
    }

    if (unitRate < 0) {
      setErrorMessage("txtDAmtSvcDtlUnitRate", Messages.SSM_FIN_UNIT_RATE_NOT_NEGTV);
      result = false;
    }

    if ((paymentType != null && "CRM".equals(paymentType)) && (invoiceMonth != month || invoiceYear != year)) {
      setErrorMessage(Messages.SSM_FIN_CRM_DIFF_DATE);
      result = false;
    }

    // If the invoice type is Adoption subsidy fractional Units cannot be entered
    // SIR 17509 GRIMSHAN -- change the method for seeing if there are fractional units.
    if (invoiceType != null && "ADS".equals(invoiceType) && ((unitQty - Math.floor(unitQty)) != 0)) {
      setErrorMessage("txtSNbrSvcDtlUnitQty", Messages.SSM_NO_FRACT_UNITS);
      result = false;
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

    // If its not a reversal, then negative amounts cannot be entered
    if (!isReversal) {
      if (unitQty < 0 || feePaid < 0) {
        setErrorMessage(Messages.SSM_FIN_NO_NEGTVE_ENTRY);
        result = false;
      }
    }

    // SIR 17582 this error message will display regardless of invoice type
    //If it is not a reversal Fee paid cannot be greater than
    //item total.  However the Item total used at this point is just rate * qty it is not rate * qty - fee paid
    //this works because we just need to make sure that the item total displayed is not going to be less that 0
    if (!isReversal) {

      if (unitRate != 0 && feePaid != 0) {
        if (roundFee > roundTempTotal) {
          message = MessageLookup.getMessageByNumber(Messages.SSM_FIN_FPD_GRTR_THN_ITM);
          message = MessageLookup.addMessageParameter(message, (roundTempTotal - feePaid));
          setErrorMessage(message);
          result = false;
        }
      }
    }

    //If this Invoice is an Invoice Specific adjustment
    if (isReversal) {
      if (unitQty >= 0) {
        if (feePaid < 0) {
          setErrorMessage(Messages.SSM_FIN_NO_POS_NEG_AMTS);
          result = false;
        }
        if (roundFee > roundTempTotal && feePaid != 0) {
          message = MessageLookup.getMessageByNumber(Messages.SSM_FIN_FPD_GRTR_THN_ITM);
          message = MessageLookup.addMessageParameter(message, roundTempTotal);
          setErrorMessage(message);
          result = false;
        }
      } else {
        if (feePaid > 0) {
          setErrorMessage(Messages.SSM_FIN_NO_POS_NEG_AMTS);
          result = false;
        }
        if (roundFee < roundTempTotal && feePaid != 0) {
          message = MessageLookup.getMessageByNumber(Messages.SSM_FIN_FPD_GRTR_THN_ITM);
          message = MessageLookup.addMessageParameter(message, roundTempTotal);
          setErrorMessage(message);
          result = false;
        }
      }
    }
    if ((paymentType != null && !"CRM".equals(paymentType)) && unitRate == 0.0) {
      setErrorMessage(Messages.MSG_RATE_REQ);
      result = false;
    }

    // If the invoice type is cost reimbursement, the total of the Fees Paid cannot be greater than 99999999.99
    // Also, the total of the unit quantity cannot be greater than 100000.00.
    // Then, if the Invoice Phase is VWO or VWI, the unit rate needs to be re-calculated. In order to do these checks we first
    // loop through all of the Delivered Service rows existing with the same service as the delivered service
    // row we are currently saving to add up the total quantity and Fees Paid of all of the rows.  We also need to check to
    // see if the row we are currently looping through is not the row we ar trying to save.  Then do the checks for
    // Fees Paid and Unit Quantity.
    // After we have the quantity total if the Invoice Phase is VWI or VWO, enumerate though the cost reimbursement
    // rows to find the row that has the same service as the Delivered Service row we are saving.
    // If it does, and the total quantity from the Delivered Services is not 0, total the amounts
    //from that cost reimbursement row and divide it by the summed quantities from Delivered Service.

    if (paymentType != null && "CRM".equals(paymentType)) {
      CFIN13SO cfin13so = (CFIN13SO) state.getAttribute("CFIN13SO", request);
      if (cfin13so == null) {
        cfin13so = new CFIN13SO();
      }

      // SIR 19897 ensure cost Array is not null before trying to enumerate.
      ROWCFIN13SOG_ARRAY costArray = cfin13so.getROWCFIN13SOG_ARRAY();
      if (costArray == null) {
        costArray = new ROWCFIN13SOG_ARRAY();
      }
      Enumeration costEnumeration = costArray.enumerateROWCFIN13SOG();
      if ((paymentType != null && "CRM".equals(paymentType) && costEnumeration.hasMoreElements())) {
        double sumQty = 0.0;
        double sumOffset = 0.0;
        //CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);
        CFIN06SO cfin06so = (CFIN06SO) state.getAttribute("CFIN06SO", request);
        ROWCFIN06SOG_ARRAY delArray = cfin06so.getROWCFIN06SOG_ARRAY();
        Enumeration delEnumeration = delArray.enumerateROWCFIN06SOG();
        while (delEnumeration.hasMoreElements()) {
          ROWCFIN06SOG delRow = (ROWCFIN06SOG) delEnumeration.nextElement();
          if (delRow != null) {
            if (delRow.getSzCdSvcDtlService().equals(szCdSvcDtlService) && delRow.getUlIdSvcDtl() != ulIdSvcDtl) {
              sumQty += delRow.getSNbrSvcDtlUnitQty();
              sumOffset = sumOffset + delRow.getDAmtSvcDtlFeePaid();
            }
          }
        }
        // Also add in the quantity of the current row we are saving

        sumQty += unitQty;
        sumOffset = sumOffset + feePaid;

        // If sumQty is greater than 100,000 display an error message and do not do the unit rate calculation
        // Otherwise, continue and excecute the unit rate calculation
        if (sumQty > 100000) {
          setErrorMessage(Messages.MSG_FIN_UNIT_QTY_MAX);
          result = false;
        }
        // If sumOffset is greater than 99,999,999.99 display an error message and do not do the unit rate calculation
        // Otherwise, continue and execute the unit rate calcualtion
        else if (sumOffset > 99999999.99) {
          setErrorMessage(Messages.MSG_FIN_CR_MAX_EXCEED);
          result = false;
        }
      }
    }

    if (indValidate != null && "N".equals(indValidate)) {
      setErrorMessage(Messages.MSG_VAL_SAVE);
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
  public static final String TRACE_TAG = "DeliveredCustomValidation";
}