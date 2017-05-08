package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- java classes --

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate Contract Header information.
 *
 * @author Paul Lang, February 21, 2003
 *         <p/>
 *         Change History: Date        User      Description --------  ----------  --------------------------------------------------
 *         06/25/03  GRIMSHAN    SIR 18509 check the value of indValidate to determine if the message needs to be
 *         displayed.
 *         <p/>
 *         10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed
 *         InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class ContractHeaderCustomValidation extends FormValidation {
  /**
   * This method is used to perform validation on entered items on the Contract Header page.
   *
   * @return isValid
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ContractHeaderCustomValidation", "validateForm");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");

    boolean isValid = true;

    HttpServletRequest request = this.getRequest();

    String txtSzNmResource = ContextHelper.getStringSafe(request, "txtSzNmResource");
    String rbcontractPeriod = ContextHelper.getStringSafe(request, "rbcontractPeriod_CLEAN");
    String indValidate = ContextHelper.getStringSafe(request, "hdnIndValidate");
    String txtUlIdCntrctManager = ContextHelper.getStringSafe(request, "txtUlIdCntrctManager");

    String hdnBudgetTransferPressed = getInputValue("hdnBudgetTransferPressed");
    BaseSessionStateManager state = super.getState();

    if (super.isButtonPressed("btnSave")) {
      if ("N".equals(indValidate)) {
        super.setErrorMessage(Messages.SSM_CON_NOT_VALIDATED);
        isValid = false;
      }
      if ("".equals(txtUlIdCntrctManager)) {
        super.setErrorMessage(Messages.MSG_CON_MGR_REQUIRED);
        isValid = false;
      }
    }

    if (!"".equals(hdnBudgetTransferPressed)) {
      CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);
      try {
        String locked = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(0).getCIndCnverVerLock();
        if (!"Y".equalsIgnoreCase(locked)) {
          super.setErrorMessage(Messages.MSG_CANNOT_OPEN_TRANSFER);
          isValid = false;
        }
      }
      catch (Exception e) {
        String stackTraceString = BasePrsException.getStackTrace(e);
        GrndsTrace.msg(TRACE_TAG, 7,
                       "A problem occured while trying to access the version array when the  Budget Transfer button was pressed.");
        GrndsTrace.msg(TRACE_TAG, 7, stackTraceString);
      }
    }

    if (super.isButtonPressed("btnDelete")) {
      if ("".equals(rbcontractPeriod)) {
        super.setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
        isValid = false;
      } else {
        int contractPeriodIndex = Integer.parseInt(rbcontractPeriod);
        CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
        try {
          String signed = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(
                  contractPeriodIndex).getCIndCnperSigned();
          String status = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(
                  contractPeriodIndex).getSzCdCnperStatus();
          if ("Y".equalsIgnoreCase(signed)) {
            super.setErrorMessage(Messages.MSG_CANNOT_DELETE_PERIOD);
            isValid = false;
          }
          // If the status is not pending display a message
          if (!"PND".equalsIgnoreCase(status)) {
            super.setErrorMessage(Messages.MSG_CANNOT_DELETE_PERIOD_PEND);
            isValid = false;
          }
        }
        catch (Exception e) {

          String stackTraceString = BasePrsException.getStackTrace(e);
          GrndsTrace.msg(TRACE_TAG, 7,
                         "A problem occured while trying to access the period array when Deleting Period.");
          GrndsTrace.msg(TRACE_TAG, 7, stackTraceString);
        }
      }
    }

    GrndsTrace.exitScope(TRACE_TAG + ".validateForm");
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "ContractHeaderCustomValidation";

}