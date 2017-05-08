//Declare your class package
package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

/**
 * ***************************************************************************** This class is used to perform the
 * custom validation on the payment approval jsp
 *
 * @author Katy Laura 01/14/2003
 *         <p/>
 *         Change History: 
 *         
 *         Date      User         Description 
 *       10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *                                                replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD 
 *                                                removed message lookup.
 *      05/22/2008 vdevarak    STGAP00004617:MR-012 Added validations to the search criteria as part of  
 *                                                adding the new search functionality on the Payment Approval page.
 *                                                
 *      04/09/2009  bgehlot    STGAP00013273: Removed the month condition. Added condition for
 *                                "User is required to enter year also when he/she enters a month in the search criteria"
 *      05/27/2009  bgehlot    STGAP00013906: Removed the message MSG_INV_YEAR_REQ as per the design change
 
 *         <p/>
 *         ******************************************************************************
 */
@SuppressWarnings("serial")
public class PaymentApprovalCustomValidation extends FormValidation {

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    boolean result = true;

    HttpServletRequest request = this.getRequest();

    // get count of the array of rows to be updated from the jsp
    // these indices are from the checked boxes on records check list jsp
    String[] selectedRowsForSave = CheckboxHelper.getCheckedValues(request, "ckName_CLEAN");
    // STGAP00004617:Added the following code to validate the search criteria as part of the new search functionality
    // on the Payment Approval page.
    // Begin
    int ulIdContract = ContextHelper.getIntSafe(request, "txtUlIdContract");
    int ulIdResource = ContextHelper.getIntSafe(request, "txtUlIdResource");
    String szCdCntrctRegion = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
    int uMoInvoMonth = ContextHelper.getIntSafe(request, "txtUMoInvoMonth");
    int uYrInvoYear = ContextHelper.getIntSafe(request, "txtUYrInvoYear");
    int ulIdClientPerson = ContextHelper.getIntSafe(request, "txtUlIdClientPerson");

    // If both Contract and Resource Id have been entered tell the user they need
    // to enter one or the other
    if (ulIdContract != 0 && ulIdResource != 0) {
      setErrorMessage(Messages.MSG_INVOICE_CON_RES);
      result = false;
    }
    
    // STGAP00013273: Removed the month condition
    if ("".equals(szCdCntrctRegion) || uYrInvoYear == 0) {
      if(ulIdClientPerson == 0){
        setErrorMessage(Messages.MSG_INVOICE_REQ_FIELD);
        result = false;
      }
    }
    
    // -- verfiy that Month and Year are not in the future
    Calendar cal = Calendar.getInstance();
    int currentMonth = cal.get(Calendar.MONTH) + 1;
    int currentYear = cal.get(Calendar.YEAR);
    if (uMoInvoMonth != 0 && (uMoInvoMonth < 1 || uMoInvoMonth > 12)) {
      setErrorMessage(Messages.MSG_ARC_CONSTR_MONTH);
      result = false;
    }
    if (uYrInvoYear != 0 && uYrInvoYear > currentYear) {
      setErrorMessage("txtUYrInvoYear", Messages.MSG_FIN_INVALID_YR);
      result = false;
    } else if (uMoInvoMonth != 0 && uYrInvoYear == currentYear && uMoInvoMonth > currentMonth) {
      setErrorMessage("txtUMoInvoMonth", Messages.MSG_FIN_INVALID_MO);
      result = false;
    }
    // end
    // if the button pressed is approve, disapprove or reset, validate; otherwise, no validation is required
    if ((isButtonPressed("btnApprove"))
        ||
        (isButtonPressed("btnDisapprove"))
        ||
        (isButtonPressed("btnReset"))) {
      if (selectedRowsForSave.length == 0) {
        setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
        //STGAP00004617: Set this parameter in the request so that the search results section on the page will be displayed.
        request.setAttribute("SearchPerformed", request);
        result = false;
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "PaymentApprovalCustomValidation";
}

