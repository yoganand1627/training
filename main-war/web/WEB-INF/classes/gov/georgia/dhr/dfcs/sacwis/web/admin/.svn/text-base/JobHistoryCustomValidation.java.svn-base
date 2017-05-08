package gov.georgia.dhr.dfcs.sacwis.web.admin;

// -- architecture classes --

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * JobHistoryDetail.jsp Custom validation class <p>Description:  This checks to verify valid dates are being used. </p>
 * <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Jeff Chambers
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/13/03  dickmaec     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue();
 */

public class JobHistoryCustomValidation extends FormValidation {
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();

    org.exolab.castor.types.Date startDate = ContextHelper.getCastorDateSafe(request, "txtDtJobStart");
    org.exolab.castor.types.Date endDate = ContextHelper.getCastorDateSafe(request, "txtDtJobEnd");
    org.exolab.castor.types.Date previousEndDate = ContextHelper.getCastorDateSafe(request, "txtDtJobEnd_prev");
    org.exolab.castor.types.Date previousStartDate = ContextHelper.getCastorDateSafe(request, "txtDtJobStart_prev");

    boolean result = true;

    // If the Term Date is before the Start Date, throw this error
    if (endDate != null && (DateHelper.isBefore(endDate, startDate))) {
      setErrorMessage("txtDtJobEnd", Messages.MSG_DATE_INVALID);
      result = false;
    }

    // New row cannot overlap any other rows, if end date is filled, start and end dates must
    // fall completely between other rows
    String pageMode = PageMode.getPageMode(request);

    if (pageMode.equals(PageModeConstants.NEW)) {
      //Cannot have 2 open-ended job history rows
      if (endDate == null && previousEndDate == null) {
        setErrorMessage("txtDtJobEnd_prev", "There can only be 1 open job history row.");
        result = false;
      }
      //previous end cannot overlap previous start
      if (DateHelper.isBefore(previousEndDate, previousStartDate)) {
        setErrorMessage("txtDtJobEnd_prev", MessageLookup.getMessageByNumber(Messages.MSG_DATE_OVERLAP));
        result = false;
      }
      //New Row cannot overlap any other rows
      CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);
      ROWCCMN04SOG02_ARRAY displayJobHistoryArray = ccmn04so.getROWCCMN04SOG02_ARRAY();
      ROWCCMN04SOG02 jobHistory;
      org.exolab.castor.types.Date startDateCheck;
      org.exolab.castor.types.Date endDateCheck;
      boolean overlapFound = false;
      int i = 0;
      Enumeration e = displayJobHistoryArray.enumerateROWCCMN04SOG02();
      while (e.hasMoreElements() && !overlapFound) {
        jobHistory = (ROWCCMN04SOG02) e.nextElement();
        startDateCheck = jobHistory.getDtDtJobStart();
        //existing row end date should come from page data
        if (i == 0) {
          endDateCheck = previousEndDate;
        } else {
          endDateCheck = jobHistory.getDtDtJobEnd();
        }
        if (endDateCheck == null) {
          endDateCheck = DateHelper.MAX_CASTOR_DATE;
        }
        if ((!DateHelper.isBefore(startDate, startDateCheck) &&
             !DateHelper.isBefore(startDate, endDateCheck)) ||
                                                            (!DateHelper.isAfter(startDate, startDateCheck) &&
                                                             !DateHelper.isAfter(endDate, startDateCheck))) {
          // Do nothing; logic written this way to be clearer.
        } else {
          if (endDate == null && previousEndDate == null) {
          } else {
            setErrorMessage("txtDtJobStart", MessageLookup.getMessageByNumber(Messages.MSG_DATE_OVERLAP));
            result = false;
            overlapFound = true;
          }
        }
        i += 1;
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
  public static final String TRACE_TAG = "JobHistoryCustomValidation";
}