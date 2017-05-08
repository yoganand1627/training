//Declare your class package
package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * ***************************************************************************** This class is used to perform the
 * custom validation on the criminal history jsp
 *
 * @author Katy Laura 01/14/2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed message look up
 *         <p/>
 *         ******************************************************************************
 */
public class CriminalHistoryCustomValidation extends FormValidation {

  /**
   * *************************************************************************** list of things to check for
   * *MSG_CONFIRM_ON_EXIT        -      a user tries to exit this window without saving *MSG_SUB_CRIMHIS_DECISION  -
   *  USER has accepted only some of the rows *SSM_COMPLETE_REQUIRED     -       where a row is rejected, the comments
   * are required
   * <p/>
   * /****************************************************************************** This method contains custom
   * validation for records check pages
   *
   * @return result - returns false if the data fails validation. - returns true if the data passes validation.
   *         ****************************************************************************
   */
  // protected boolean validateForm( GrndsExchangeContext context )
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    boolean result = true;
    HttpServletRequest request = this.getRequest();
    // get lineCount from the request on the CH jsp
    int lineCount = ContextHelper.getIntSafe(request, "hdnLineCount");

    for (int j = 0; j < lineCount; j++) {
      // get the value of the radio button - "ACP" or "REJ" and the value of the associated comment
      String rb = ContextHelper.getStringSafe(request, "rbAcpRej" + j);
      String rowComments = ContextHelper.getStringSafe(request, "rowComments" + j);
      // if a rejected row has no comments, block the save by setting results = false.  A rejected row must have non null, non blank comments
      if ("REJ".equals(rb) &&
          ((rowComments == null) || (rowComments.equals(StringHelper.EMPTY_STRING)))) {
        setErrorMessage(Messages.MSG_CMTS_REQ_REJ_ROWS);
        result = false;
      } // end if
    }  // end loop

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }  // end protected boolean validate form

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "CriminalHistoryCustomValidation";
}

