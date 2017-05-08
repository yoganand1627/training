package gov.georgia.dhr.dfcs.sacwis.web.intake;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Used to perform the custom validation on Call Log Search when the user searches for matching call info.
 * 
 * @author Mike Ochu 02/05/2003 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup. 09/17/04 Ochumd Sir
 *         22964 -- Added code to allow a search by I&R and I&R Type only.
 */
public class CallLogCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Call Log Search Page
   * 
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "validateForm()");

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;
    String firstName = ContextHelper.getStringSafe(request, "txtFirstName");
    String middleName = ContextHelper.getStringSafe(request, "txtMiddleInt");
    String lastName = ContextHelper.getStringSafe(request, "txtLastName");
    String dateFrom = ContextHelper.getStringSafe(request, "dtrangeFrom");
    String dateTo = ContextHelper.getStringSafe(request, "dtrangeTo");
    String region = ContextHelper.getStringSafe(request, "selszCdStageRegion");
    String callId = ContextHelper.getStringSafe(request, "txtUlidStage");
    String city = ContextHelper.getStringSafe(request, "txtIncomingCallerCity");
    String county = ContextHelper.getStringSafe(request, "selszCdIncomingCounty");
    boolean firstNameFilled = firstName.length() > 0;
    boolean middleNameFilled = middleName.length() > 0;
    boolean lastNameFilled = lastName.length() > 0;
    boolean regionFilled = region.length() > 0;
    boolean cityFilled = city.length() > 0;
    boolean countyFilled = county.length() > 0;
    boolean dateFromFilled = dateFrom.length() > 0;
    boolean dateToFilled = dateTo.length() > 0;
    boolean callIdFilled = callId.length() > 0;

    if (callIdFilled) {
      isValid = true;
    } else if ((firstNameFilled || middleNameFilled) && !lastNameFilled) {
      setErrorMessage("txtLastName", Messages.MSG_INT_LAST_NAME);
      isValid = false;
    } else if (dateFromFilled && !dateToFilled) {
      setErrorMessage("dtrangeFrom", Messages.MSG_INT_DATE_FROM_TO);
      isValid = false;
    } else if (dateToFilled && !dateFromFilled) {
      setErrorMessage("dtrangeTo", Messages.MSG_INT_DATE_FROM_TO);
      isValid = false;
    } else if (dateFromFilled != dateToFilled) {
      String unFilledParameter = "dtrangeTo";
      if (dateFromFilled == false) {
        unFilledParameter = "dtrangeFrom";
      }
      setErrorMessage(unFilledParameter, Messages.MSG_INT_DATE_ORDER);
      isValid = false;
    } else if (dateFromFilled && dateToFilled && firstNameFilled && !lastNameFilled) {
      setErrorMessage("txtLastName", Messages.MSG_INT_INSUFF_PARMS);
      isValid = false;
    } else if (dateFromFilled && dateToFilled && !firstNameFilled && lastNameFilled) {
      setErrorMessage("txtFirstName", Messages.MSG_INT_INSUFF_PARMS);
      isValid = false;
    } else if (dateFromFilled && dateToFilled && !firstNameFilled && !callIdFilled && !lastNameFilled && !regionFilled
               && !cityFilled && !countyFilled) {
      setErrorMessage("selszCdStageRegion", Messages.MSG_INT_INSUFF_PARMS);
      isValid = false;
    } else if (!dateFromFilled && !dateToFilled && !callIdFilled && (!firstNameFilled || !lastNameFilled)) {
      if (!firstNameFilled && lastNameFilled) {
        setErrorMessage("txtFirstName", Messages.MSG_INT_INSUFF_PARMS_DEFAULT);
      } else if (!lastNameFilled && firstNameFilled) {
        setErrorMessage("txtLastName", Messages.MSG_INT_INSUFF_PARMS_DEFAULT);
      } else {
        setErrorMessage(Messages.MSG_INT_INSUFF_PARMS_DEFAULT);
      }
      isValid = false;
    }
    /*
     * * Make sure that Date to is greater than Date from. If not, notify the user via a message * to correct.
     */
    org.exolab.castor.types.Date dateRangeFrom = ContextHelper.getCastorDateSafe(request, "dtrangeFrom");
    org.exolab.castor.types.Date dateRangeTo = ContextHelper.getCastorDateSafe(request, "dtrangeTo");

    if (dateRangeFrom != null && dateRangeTo != null) {
      if (DateHelper.isBefore(dateRangeTo, dateRangeFrom)) {
        setErrorMessage("dtrangeFrom", Messages.MSG_INT_DATE_ORDER);
        isValid = false;
      } else if (dateRangeTo.equals(dateRangeFrom)) {
        /*
         * * Check if the time to and time from flow in a chronological order ie time to must be greater * than time
         * from, If not, notify the user via a message to correct.
         */
        String startTime = ContextHelper.getTimeSafe(request, "szScrTimeFrom");
        String endTime = ContextHelper.getTimeSafe(request, "szScrTmTimeTo");

        if (!"".equals(startTime) && !"".equals(startTime)) {
          TimeTag timeTag = new TimeTag();
          Date startTimeDate = timeTag.parseTimeAMPM(startTime);
          Date endTimeDate = timeTag.parseTimeAMPM(endTime);

          if (startTimeDate.getTime() > endTimeDate.getTime()) {
            isValid = false;
            setErrorMessage("szScrTimeFrom", Messages.MSG_INT_TIME_ORDER);
          }
        }
      } // end else if (dateRangeTo.equals(dateRangeFrom))

      // Get the number of days between (and including) 'Start Date' and 'End Date'
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date dateRangeFromAsImpactUtilDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                                                                                                                                      dateRangeFrom
                                                                                                                                                   .getDay(),
                                                                                                                                      dateRangeFrom
                                                                                                                                                   .getMonth(),
                                                                                                                                      dateRangeFrom
                                                                                                                                                   .getYear());

      gov.georgia.dhr.dfcs.sacwis.core.utility.Date dateRangeToAsImpactUtilDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                                                                                                                                    dateRangeTo
                                                                                                                                               .getDay(),
                                                                                                                                    dateRangeTo
                                                                                                                                               .getMonth(),
                                                                                                                                    dateRangeTo
                                                                                                                                               .getYear());

      int numOfDaysInRange = DateUtility.getDatesInRange(dateRangeFromAsImpactUtilDate, dateRangeToAsImpactUtilDate,
                                                         DateUtility.DAY, 1).size();

      GrndsTrace.msg(TRACE_TAG, 10, "cint07so" + numOfDaysInRange);
      if (numOfDaysInRange > PMAX_SEARCH_RANGE_DAYS) {
        GrndsTrace.msg(TRACE_TAG, 10, "about to set message --- > " + numOfDaysInRange);
        setErrorMessage("dtrangeFrom", Messages.MSG_INT_RANGE_TOO_LONG);
        isValid = false;
      } // end if (numOfDaysInRange > PMAX_SEARCH_RANGE_DAYS)
    } // end if (!dateRangeFrom.equals(DateHelper.NULL_CASTOR_DATE) && !dateRangeTo.equals(DateHelper.NULL_CASTOR_DATE))

    performanceTrace.exitScope("result is" + isValid);
    return isValid;
  }

  // SIR 17935 -- Call Log Search Criteria range will handle 32 days or one month with 31 days.
  // PMAX_SEARCH_RANGE_DAYS was increased to 32 days to handle months that have 31 days. Eric Dickman
  public static final int PMAX_SEARCH_RANGE_DAYS = 32;

  public static final String TRACE_TAG = "CallLogCustomValidation";
}
