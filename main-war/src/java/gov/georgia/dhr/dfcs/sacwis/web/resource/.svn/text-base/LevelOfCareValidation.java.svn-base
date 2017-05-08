package gov.georgia.dhr.dfcs.sacwis.web.resource;

// -- java classes --

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate Level of Care information.
 *
 * @author Chris Cawthon, July 26, 2002
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup. 12/01/03
 *         CORLEYAN     LOC Enhancement - This Validation is now called by Add LOC as that is now the only place that
 *         Effective date can be set.
 */
public class LevelOfCareValidation extends FormValidation {
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("LevelOfCareValidation", "validateForm");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");

    HttpServletRequest request = this.getRequest();

    boolean isValid = true;
    org.exolab.castor.types.Date effectiveDateCastor = ContextHelper.getCastorDateSafe(request, "effectiveDate");
    org.exolab.castor.types.Date latestEffectiveDateCastor = ContextHelper.getCastorDateSafe(request,
                                                                                             "latestEffectiveDate");
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date effDateUtility = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
            effectiveDateCastor.getDay(), effectiveDateCastor.getMonth(),
            effectiveDateCastor.getCentury() * 100 + effectiveDateCastor.getYear());
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date latestDateUtility = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
            latestEffectiveDateCastor.getDay(), latestEffectiveDateCastor.getMonth(),
            latestEffectiveDateCastor.getCentury() * 100 + latestEffectiveDateCastor.getYear());
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date endDateUtility = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();

    String pageMode = PageMode.getPageMode(request);

    // If latest effective date is not null add 2 days to the utility version
    if (latestEffectiveDateCastor != null) {
      //convert the latest effective date to a date and then add 2 days to it
      latestDateUtility.addDays(2);
    }

    //add 14 days to the current date
    endDateUtility.addDays(14);

    //if the new effective date is more than 14 days after the current date, throw an error
    if (effDateUtility.isDayAfter(endDateUtility)) {
      //Msg "Date of new LOC cannot be more than two weeks from today"
      setErrorMessage("effectiveDate", Messages.MSG_RES_DATE_TOO_LATE);
      isValid = false;
    }
    //the new effective date must be at least 2 days after the previous effective date, otherwise throw an error
    if (effDateUtility.isDayBefore(latestDateUtility) && latestEffectiveDateCastor != null) {
      //Msg "Effective Date of new LOC entry must be at least two days past latest Effective Date"
      setErrorMessage("effectiveDate", Messages.MSG_RES_DATE_TOO_EARLY);
      isValid = false;
    }

    GrndsTrace.exitScope(TRACE_TAG + ".validateForm");
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "LOCValidation";

}





