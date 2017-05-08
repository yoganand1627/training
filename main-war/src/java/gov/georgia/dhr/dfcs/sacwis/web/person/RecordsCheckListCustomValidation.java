//Declare your class package
package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

/**
 * ***************************************************************************** This class is used to perform the
 * custom validation on the records check list jsp
 *
 * @author Katy Laura 01/14/2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue();
 *         <p/>
 *         ******************************************************************************
 */
public class RecordsCheckListCustomValidation extends FormValidation {

  /**
   * *************************************************************************** list of things to check for
   * MSG_MSG_SELECT_FOR_DELETE
   * <p/>
   * <p/>
   * /****************************************************************************** This method contains custom
   * validation for records check list page
   *
   * @return result - returns false if the data fails validation. - returns true if the data passes validation.
   *         ****************************************************************************
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    boolean result = true;

    // if the button pressed is btnSave, validate; otherwise, no validation is required
    if (isButtonPressed("btnDelete")) {
      boolean resultSave = validateDelete();
      result = resultSave;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }

  /**
   * *************************************************************************** This method contains custom validation
   * for the delete button on the records check list page
   *
   * @return result - returns false if the data fails validation. - returns true if the data passes validation.
   *         ****************************************************************************
   */
  protected boolean validateDelete() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    boolean resultSave = true;
    // define state and request values from the conversation using super.
    HttpServletRequest request = this.getRequest();

    //   get values for the array of rows to be deleted from the jsp
    // these indices are from the checked boxes on records check list jsp
    String[] selectedRowsForDelete = CheckboxHelper.getCheckedValues(request, "ckName_CLEAN");
    // get the ccfc26 object from state
    // test for no rows selected
    if (selectedRowsForDelete.length == 0) {
      setErrorMessage(Messages.MSG_MSG_SELECT_FOR_DELETE);
      resultSave = false;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return resultSave;
  } // end validateDelete method

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "RecordsCheckListCustomValidation";
}

