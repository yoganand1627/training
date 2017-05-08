package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

/**
 * This class is used to perform custom validation on the Caretaker Detail page
 *
 * @author Narasimha Rao, Sep 19, 2002
 */

public class CaretakerValidation extends FormValidation {

  //static constants
  public static final String TRACE_TAG = "CaretakerValidation";

  /** This method validates the form on the Caretaker Detail Page */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("CaretakerValidation", "validateForm");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");

    boolean isValid = true;
    HttpServletRequest request = super.getRequest();
    Date endDate = null;

    Date now = new Date();
    endDate = DateHelper.toJavaDateSafe(request.getParameter("txtDateEnd"));
    //End date is not required field.
    if (endDate == null) {
      isValid = true;
    } else {
      if (endDate.compareTo(now) > 0) {
        this.setErrorMessage("txtDateEnd", Messages.MSG_RSRC_DT_END_NO_FUTURE);
        isValid = false;
      }
    }

    String dateBirth = "";

    //Get fields to be validated
    if (getInputValue("txtDateBirth") != null) {
      dateBirth = getInputValue("txtDateBirth");
    }

    //Try to make a date object out of the input and set error if its not valid
    try {
      DateHelper.toCastorDate(dateBirth);
    } catch (Exception e) {
      this.setErrorMessage("txtDateBirth", MessageLookup.getMessageByName("MSG_ARC_CONSTR_DATE"));
      isValid = false;
    }

    org.exolab.castor.types.Date dob = ContextHelper.getCastorDateSafe(request, "txtDateBirth");

//  DOD and DOB must be on or before today's date
    if (dob != null && DateHelper.isAfterToday(dob)) {
      setErrorMessage("txtDateBirth", Messages.MSG_INV_DT_BIRTH);
      isValid = false;
    }
    GrndsTrace.exitScope(TRACE_TAG + ".validateForm");
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

}
