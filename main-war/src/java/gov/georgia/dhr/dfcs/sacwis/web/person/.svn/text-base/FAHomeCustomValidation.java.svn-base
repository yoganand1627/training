package gov.georgia.dhr.dfcs.sacwis.web.person;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Income Resource Custom validation class <p>Description:  This class verifies all of the information in the F/A Home
 * Detail page</p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue();
 */

public class FAHomeCustomValidation extends FormValidation {

  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    org.exolab.castor.types.Date trainDate = ContextHelper.getCastorDateSafe(request, "txtDtDtIndivTrn");
    //Training date cannot be after today
    if (trainDate != null && DateHelper.isAfterToday(trainDate)) {
      setErrorMessage("txtDtDtIndivTrn", Messages.SSM_DATE_BEFORE_SAME_CURR);
      result = false;
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
  public static final String TRACE_TAG = "IncRsrcCustomValidation";
}