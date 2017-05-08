package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;

/**
 * User: mkw Date: Aug 7, 2003 Time: 9:46:34 AM * Date      User         Description --------  -----------
 * ---------------------------------------------- 10/14/03  dickmaec     SIR 19857 -- Verified that the file has no
 * getInputValue();
 */
public class ToDoDetailCustomValidation extends FormValidation {
  protected boolean validateForm() {
    HttpServletRequest request = getRequest();
    if (!StringHelper.isValid(request.getParameter("dspSzScrTodoAssignedTo"))) {
      setErrorMessage(errorMessage);
      request.setAttribute(ASSIGNED_TO_CLASS_KEY, ERROR_CLASS);
    } else {
      request.removeAttribute(ASSIGNED_TO_CLASS_KEY);
    }
    return super.getErrorMessages().size() == 0;
  }

  public static final String TRACE_TAG = "ToDoDetailCustomValidation";
  public static final String ASSIGNED_TO_CLASS_KEY = TRACE_TAG + ".ASSIGNED_TO_CLASS_KEY";
  public static final String ERROR_CLASS = "formLabelError";
  public static final String errorMessage = "<A onclick=hrefDirtyBypass=true; "
                                            +
                                            "href=\\\"javascript:SetFocus(document.getElementsByName('btnStaffFinal' )[0])\\\">"
                                            + "Assigned To</A> - " + InputValidation.REQUIRED_ERROR_MESSAGE;
}
