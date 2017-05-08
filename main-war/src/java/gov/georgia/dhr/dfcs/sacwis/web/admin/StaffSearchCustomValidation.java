package gov.georgia.dhr.dfcs.sacwis.web.admin;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * StaffSearch.jsp Custom validation class <p>Description:  This class checks that if the First OR Middle names are
 * filled out a Last name is required. </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Jeff Chambers
 * @version 1.0 Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/13/03  dickmaec     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(); This validation did not need a replacement, this was put in to verify the page was
 *          checked.
 */
public class StaffSearchCustomValidation
        extends FormValidation {
  public static final String TRACE_TAG = "StaffSearchCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    String first = ContextHelper.getStringSafe(request, "txtSzNmNameFirst");
    String middle = ContextHelper.getStringSafe(request, "txtSzNmNameMiddle");
    String last = ContextHelper.getStringSafe(request, "txtSzNmNameLast");
/*
    If the Middle name is entered and the Last is not, throw this error
    if ((!"".equals(first)) && "".equals(last)) {
      setErrorMessage("txtSzNmNameLast", Messages.MSG_MISSING_REQ_SEARCH_CRITERIA_LAST);
    }

    If the Middle name is entered and the Last in not, throw this error
    if ((!"".equals(middle)) && "".equals(last)) {
      setErrorMessage("txtSzNmNameLast", Messages.MSG_MISSING_REQ_SEARCH_CRITERIA_LAST);
    }
*/
    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
}
