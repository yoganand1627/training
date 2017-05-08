package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * Invoice Custom validation class <p>Description:  This class verifies all of the information in the Invoice Page </p>
 * <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */

@SuppressWarnings("serial")
public class InvoiceCustomValidation extends FormValidation {

  protected boolean validateForm() {
    //boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();

    int month = ContextHelper.getIntSafe(request, "txtUMoInvoMonth");
    int year = ContextHelper.getIntSafe(request, "txtUYrInvoYear");
    String indCostSaved = ContextHelper.getStringSafe(request, "hdnIndCostSaved");
    String reversal = ContextHelper.getStringSafe(request, "cbxSzCdInvoAdjustmentRb");
    String invoiceReadyValid = ContextHelper.getStringSafe(request, "hdnReadyForValidation");
    String savedInvoiceReadyValid = ContextHelper.getStringSafe(request, "hdnCIndInvoReadyForValid");
    double claimedAmount = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtInvoClaimedAmount");
    org.exolab.castor.types.Date receivedDate = ContextHelper.getCastorDateSafe(request, "txtDtDtInvoReceivedDate");
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
    int thisMonth = today.getMonth();
    int thisYear = today.getCentury() * 100 + today.getYear();
    int receivedMonth = receivedDate.getMonth();
    int receivedYear = receivedDate.getCentury() * 100 + receivedDate.getYear();
    int fiscalMonth = 9;
    int fiscalYear = 0;
    String indValidate = ContextHelper.getStringSafe(request, "hdnIndValidate");

    // If this month is less than nine set the fiscal year (to be used for calculations later)
    // to this year minus 3 years.  Otherwise, set it to this year minus 2 years.
    if (thisMonth < 9) {
      fiscalYear = thisYear - 3;
    } else {
      fiscalYear = thisYear - 2;
    }

    // If received date is entered, it cannot be after today
    if (DateHelper.isAfterToday(receivedDate) && !"".equals(receivedDate)) {
      setErrorMessage("txtDtDtInvoReceivedDate", Messages.SSM_DATE_BEFORE_SAME_CURR);
      //result = false;
    }
    // If reversal has not been marked, claimed amount may not be less than 0
    if (CodesTables.CINVADJT_N.equals(reversal) && claimedAmount < 0) {
      setErrorMessage("txtDAmtInvoClaimedAmount", Messages.SSM_FIN_NO_NEGTVE_ENTRY);
      //result = false;
    }
    // Year entered cannot be greater than this year
    if (year > thisYear) {
      setErrorMessage("txtUYrInvoYear", Messages.SSM_FIN_INVALID_MO_YEAR);
      //result = false;
    } else if (year == thisYear) {
      // if year entered is equal to this year, month cannot be greater than this month
      if (month > thisMonth) {
        setErrorMessage("txtUMoInvoMonth", Messages.SSM_FIN_INVALID_MO_YEAR);
        //result = false;
      }
    }
    // year cannot be greater than received year
    if (year > receivedYear) {
      setErrorMessage("txtUYrInvoYear", Messages.MSG_RECEIVED_DATE_GRTR_INVOICE);
      //result = false;
    } else if (year == receivedYear) {
      // if year is equal to received year, month cannot be greater than received month
      if (month > receivedMonth) {
        setErrorMessage("txtUMoInvoMonth", Messages.MSG_RECEIVED_DATE_GRTR_INVOICE);
        //result = false;
      }
    }

    //Invoice month and year must be w/in the last two fiscal years
    if (year < fiscalYear) {
      setErrorMessage("txtUYrInvoYear", Messages.SSM_FIN_SVC_YR_GRTR_MAX);
      //result = false;
    } else if (year == fiscalYear) {
      if (month < fiscalMonth) {
        setErrorMessage("txtUMoInvoMonth", Messages.SSM_FIN_SVC_YR_GRTR_MAX);
        //result = false;
      }
    }

    // If Cost Reimbursement has not been saved, the user cannot mark the invoice
    // as ready for validation
    if (indCostSaved != null && "N".equals(indCostSaved) && invoiceReadyValid != null && "Y".equals(
            invoiceReadyValid)) {
      setErrorMessage("cbxCIndInvoReadyForValid", Messages.MSG_VALID_NO_COST_REI);
      //result = false;
    }

    // If the Invoice Ready for validation checkbox has been previously checked and saved, it cannot be de-selected.
    if (savedInvoiceReadyValid != null && "Y".equals(savedInvoiceReadyValid) &&
        invoiceReadyValid != null && "N".equals(invoiceReadyValid)) {
      setErrorMessage("cbxCIndInvoReadyForValid", Messages.MSG_INV_VAL_SEL);
      //result = false;
    }
    // The information must be validated before it can be saved.
    if (indValidate != null && "N".equals(indValidate)) {
      setErrorMessage("txtUlIdContract", Messages.MSG_VAL_SAVE);
      //result = false;
    }
    
    BaseSessionStateManager state = getState();
    CFIN02SO cfin02so = (CFIN02SO) state.getAttribute( "CFIN02SO", request );
    String invoType = cfin02so != null ? cfin02so.getSzCdInvoType() : null;
    String cdApproved = ContextHelper.getStringSafe(request, "dspSzCdInvoApproved");
    if(InvoiceConversation.isEmergencyType(invoType) && CodesTables.CINVOAPV_APV.equals(cdApproved)) {
      //-- certain fields become required
      checkEmergencyPaymentRequired(request, "dspDtDtInvoSubmitDate");
      checkEmergencyPaymentRequired(request, "dspDtDtInvoWarrantDate");
      checkEmergencyPaymentRequired(request, "dspSzNbrInvoWarrant");
      checkEmergencyPaymentRequired(request, "dspContact");
      checkEmergencyPaymentRequired(request, "dspDAmtInvoWarrant");
      
      //-- valid amount must equal check amount
      double validAmount = ContextHelper.getMoneyAsDoubleSafe(request, "dspDAmtInvoValidAmount");
      double checkAmount = ContextHelper.getMoneyAsDoubleSafe(request, "dspDAmtInvoWarrant");
      if(validAmount != checkAmount) {
        setErrorMessage("dspDAmtInvoWarrant", Messages.MSG_FIN_EMG_VAL_CHK_MATCH);
      }
    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
  
  private void checkEmergencyPaymentRequired(HttpServletRequest request, String inputName) {
    if("".equals(ContextHelper.getStringSafe(request, inputName))) {
      setErrorMessage(inputName, Messages.MSG_FIN_EMG_FIELD);
    }
  }
  

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "InvoiceCustomValidation";
}