package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

/**
 * Invoice Custom validation class <p>Description:  This class verifies all of the information in the Invoice Page </p>
 * <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: 
 *          Date      User         Description 
 *         --------  -----------  ---------------------------------------------- 
 *         10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *          
 *         04/09/2009  bgehlot    STGAP00013273: Removed the month condition. Added condition for
 *                                "User is required to enter year also when he/she enters a month in the search criteria"
 *         05/27/2009  bgehlot    STGAP00013906: Removed the message MSG_INV_YEAR_REQ as per the design change
 *                               
 */

public class InvoiceSearchCustomValidation extends FormValidation {

  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();

    int ulIdInvoice = ContextHelper.getIntSafe(request, "txtUlIdInvoInvoice");
    int ulIdContract = ContextHelper.getIntSafe(request, "txtUlIdContract");
    int ulIdResource = ContextHelper.getIntSafe(request, "txtUlIdResource");
    String szCdCntrctRegion = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
    int uMoInvoMonth = ContextHelper.getIntSafe(request, "txtUMoInvoMonth");
    int uYrInvoYear = ContextHelper.getIntSafe(request, "txtUYrInvoYear");
    int ulIdClientPerson = ContextHelper.getIntSafe(request, "txtUlIdClientPerson");

    // If Id Invoice has not been entered, do the custom validation otherwise,
    // it is searched on exclusively so do not do it
    if (ulIdInvoice == 0) {
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
      
      //-- verfiy that Month and Year are not in the future
      Calendar cal = Calendar.getInstance();
      int currentMonth = cal.get(Calendar.MONTH) + 1;
      int currentYear = cal.get(Calendar.YEAR);
      if(uYrInvoYear != 0 && uYrInvoYear > currentYear){
        result = false;
        setErrorMessage("txtUYrInvoYear", Messages.MSG_FIN_INVALID_YR);
      } else if(uMoInvoMonth != 0 && uYrInvoYear == currentYear && uMoInvoMonth > currentMonth){
        result = false;
        setErrorMessage("txtUMoInvoMonth", Messages.MSG_FIN_INVALID_MO);
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