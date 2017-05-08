package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.exolab.castor.types.Date;

/**
 * This class is used to perform the custom validation for the APS Service Plan Page when the user chooses to Save the
 * Client Assessment or attempts to Add or Delete from the APS Outcome Matrix.
 * <p/>
 * The validation for the Completion Check is performed in the performCompletionCheck method because the page needs to
 * save even if the Completion Check is unsuccessful.
 *
 * @author Jenn M Casdorph 01/07/2003 Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/15/03  dickmaec     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue();
 *         <p/>
 *         10/15/03  dickmaec     As part of SIR 19857, all messages where shorted from
 *         MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX.
 */
public class APSServicePlanCustomValidation extends FormValidation {

  /**
   * <p>This method contains custom validation that is checked when the user tries to Add or Delete from the APS Outcome
   * Matrix portion of the APS Service Plan.</p>
   *
   * @return result - Returns false if the data fails validation.  Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean result = true;
    ///////////////////////////////////////////
    //  Client Assessment Custom Validation  //
    ///////////////////////////////////////////
    Date dateCompleted = ContextHelper.getCastorDateSafe(request, "dtDtApsInvstCltAssmt");
    Date dateInvBegun = ContextHelper.getCastorDateSafe(request, "hdnDtDtApsInvstBegun");
    //  No matter what action the user is taking, if they are submitting the form
    //  they should not be able to continue with an invalid date of completion.
    if (dateCompleted != null && DateHelper.isAfterToday(dateCompleted)) {
      setErrorMessage("dtDtApsInvstCltAssmt", Messages.MSG_ASSMT_DT_NO_FUTURE);
      result = false;
    }
    //  We do not want to validate the Date Assessment Completed for AOC stages since
    //  there is no Date Investigation Begun ( there is no inv stage )
    // SPB SIR 18415 - Only do date check for INV stages like CAPS
    if (GlobalData.getSzCdStage(request).equals(INV)) {
      if (dateCompleted != null && DateHelper.isBefore(dateCompleted, dateInvBegun)) {
        setErrorMessage("dtDtApsInvstCltAssmt", Messages.MSG_ASSMT_DT_TOO_EARLY);
        result = false;
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "APSServicePlanCustomValidation";
  public static final String INV = "INV";
}


