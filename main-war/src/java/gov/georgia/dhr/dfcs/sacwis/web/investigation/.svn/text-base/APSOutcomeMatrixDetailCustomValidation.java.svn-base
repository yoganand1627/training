//Declare your class pacakge
package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.exolab.castor.types.Date;

/**
 * This class is used to perform the custom validation for the APS Outcome Matrix Detail Page when the user chooses to
 * Save or Delete.
 *
 * @author Jenn M Casdorph 01/13/2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *         <p/>
 *         06/28/05  dejuanr      changes to support SIR 23723
 *         <p/>
 *         08/10/05  marallh      SIR:23816 - Remove the edit that requires the Action Date to occur after the date of
 *         the problem.
 */
public class APSOutcomeMatrixDetailCustomValidation extends FormValidation {

  /**
   * <p>This method contains custom validation that is checked when the user tries to Save or Delete from the APS
   * Outcome Matrix Detail page
   *
   * @return result - Returns false if the data fails validation.  Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();

    boolean result = true;

    if (super.isButtonPressed("btnSave")) {
      // Problem Variables
      Date problemDate = ContextHelper.getCastorDateSafe(request, "dtDtApsOutcomeProblem");
      // Action Variables
      String actionCat = ContextHelper.getStringSafe(request, "selSzCdApsOutcomeActnCateg");
      String actionSubCat = ContextHelper.getStringSafe(request, "selSzCdApsOutcomeAction");
      Date actionDate = ContextHelper.getCastorDateSafe(request, "dtDtApsOutcomeAction");
      String actionComments = ContextHelper.getStringSafe(request, "");
      // Outcome Variables
      String outcomeSubCat = ContextHelper.getStringSafe(request, "selSzCdApsOutcomeResult");
      Date outcomeDate = ContextHelper.getCastorDateSafe(request, "dtDtApsOutcomeRecord");
      String outcomeComments = ContextHelper.getStringSafe(request, "");

      //  If the Action Date is before the Problem Date display a message.
      //  Sir: 23816 marallh, Remove the edit that requires the Action Date to occur after the date of the problem.
      /* if( DateHelper.isBefore( actionDate, problemDate ) )
             {
               setErrorMessage( "dtDtApsOutcomeAction", Messages.MSG_SVC_AOM_DATES );
               result = false;
             }
       */
      //  If the Outcome Date is before the Action Date display a message.
      if (DateHelper.isBefore(outcomeDate, actionDate)) {
        setErrorMessage("dtDtApsOutcomeRecord", Messages.MSG_SVC_AOM_DATES);
        result = false;
      }

      //  If any of the Action fields are entered, all conditionally required
      //  action fields must be entered.
      if (!("".equals(actionCat)) ||
          !("".equals(actionSubCat)) ||
          actionDate != null ||
          !("".equals(actionComments))) {
        if ("".equals(actionCat)) {
          setErrorMessage("selSzCdApsOutcomeActnCateg", Messages.MSG_ACT_CAT_COND_REQ);
          result = false;
        }
        if ("".equals(actionSubCat)) {
          setErrorMessage("selSzCdApsOutcomeAction", Messages.MSG_ACT_SUBCAT_COND_REQ);
          result = false;
        }
        if (actionDate == null) {
          setErrorMessage("dtDtApsOutcomeAction", Messages.MSG_ACT_DATE_COND_REQ);
          result = false;
        }
      }
      //  If any of the Outcome fields are entered, all conditionally
      //  required Outcome fields must be entered.
      if (!("".equals(outcomeSubCat)) ||
          outcomeDate != null ||
          !("".equals(outcomeComments))) {
        if ("".equals(outcomeSubCat)) {
          setErrorMessage("selSzCdApsOutcomeResult", Messages.MSG_OUTCOME_SUBCAT_REQ);
          result = false;
        }
        if (outcomeDate == null) {
          setErrorMessage("dtDtApsOutcomeRecord", Messages.MSG_OTCOME_DT_COND_REQ);
          result = false;
        }
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
  public static final String TRACE_TAG = "APSOutcomeMatrixDetailCustomValidation";
}


