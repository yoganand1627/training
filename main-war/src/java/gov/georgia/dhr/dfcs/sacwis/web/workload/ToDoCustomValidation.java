package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class ToDoCustomValidation extends FormValidation {
  /**
   * Only validates that the to date is after or equal to the from date.
   *
   * @return true if the to date is after or equal to the from date
   */
  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();

    org.exolab.castor.types.Date fromDate = ContextHelper.getCastorDateSafe(request, "dtFrom");
    org.exolab.castor.types.Date toDate = ContextHelper.getCastorDateSafe(request, "dtTo");

    if (!(fromDate == null || toDate == null) && DateHelper.isAfter(fromDate, toDate)) {
      setErrorMessage(Messages.MSG_CMN_INVALID_DT_RANGE);
    }
    return getErrorMessages().isEmpty();
  }
}
