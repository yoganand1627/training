package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/** @todo add details to javadocs such as @throws, @return, etc.. */

/**
 * Custom Validation for EventSearch page
 * <p/>
 * Date      User         Description --------  -----------  ---------------------------------------------- 10/14/03
 * dickmaec     SIR 19857 -- ContextHelper.get... replaces getInputValue();
 */
public class EventSearchCustomValidation
        extends FormValidation {
  public static final Date MINIMUM_DATE;
  protected static final String TRACE_TAG = "EventSearchCustomValidation";

  static {
    GregorianCalendar gregorianCalendar =
            new GregorianCalendar(1980, 0, 1);

    MINIMUM_DATE = gregorianCalendar.getTime();
  }

  /** all the validation logic */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, "validateForm");

    HttpServletRequest request = getRequest();

    Date startDate = null;
    Date endDate = null;
    try {
      final Date today = new Date();

      String startDateString = ContextHelper.getString(request, "startDate");
      startDate = DateHelper.toJavaDateFromInputWithDefault(startDateString, MINIMUM_DATE);
      String endDateString = ContextHelper.getString(request, "endDate");
      endDate = DateHelper.toJavaDateFromInputWithDefault(endDateString, today);

      if (startDate.after(today)) {
        setErrorMessage("startDate", Messages.MSG_CMN_INVALID_DATE);
        return false;
      }
      if (endDate.after(today)) {
        setErrorMessage("endDate", Messages.MSG_CMN_INVALID_DATE);
        return false;
      }
      if (startDate.after(endDate)) {
        setErrorMessage(Messages.MSG_CMN_INVALID_DT_RANGE);
        return false;
      }

      boolean searchEntireCase =
              ContextHelper.getBooleanSafe(request, "searchEntireCase");

      if (searchEntireCase == false) {
        String[] stageCodes =
                CheckboxHelper.getCheckedValues(request, "stageCode");

        if ((stageCodes.length > 1) ||
            ((stageCodes.length == 1) &&
             (stageCodes[0].equals(GlobalData.getSzCdStage(request)) == false))) {
          setErrorMessage(Messages.MSG_EVENT_SEARCH_SELECT_ENTIRE_CASE);
          return false;
        }
      }

      return true;
    }
    catch (Throwable e) {
      e.printStackTrace();
      throw new RuntimeWrappedException(e);
    }
    finally {
      performanceTrace.exitScope();
    }
  }
}
