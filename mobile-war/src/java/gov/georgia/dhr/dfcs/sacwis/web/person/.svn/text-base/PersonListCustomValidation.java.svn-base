//Declare your class package
package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

/**
 * This class is used to perform the custom validation on Person List when the user attempts to Continue or Search.
 *
 * @author Jenn M Casdorph 11/25/2002
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed message lookup
 */
public class PersonListCustomValidation extends FormValidation {

  /**
   * <p>This method contains custom validation that is checked when the user tries to Search or Continue.</p>
   *
   * @return result - Returns false if the data fails validation.  Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean result = true;

    String index = request.getParameter("rbPersonList_CLEAN");
    // If search or continue has been clicked, and no person has been selected display a message
    if ((super.isButtonPressed("btnSearch") || super.isButtonPressed("btnContinue")) && (index == null)) {
      setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
      result = false;

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
  public static final String TRACE_TAG = "PersonListCustomValidation";

}