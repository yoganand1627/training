package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to perform the custom validation on Stage Closure when the user chooses to Save, Save and Submit,
 * or Save and Close.
 *
 * @author Paula Blaha 2/6/2003 Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  dickmaec     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(); 10/14/03  dickmaec     As part of SIR 19857, all messages where shorted from
 *         MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX. 02/26/04
 *         Todd Reser   Ran PMD, removed unused imports, fixed javadocs.
 *          /**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  07/25/09 bgehlot    STGAP00014341: MR-51 Reopen Stage Changes
 *
 * </pre>
 */

public class StageClosureCustomValidation extends FormValidation {
  /**
   * <p>This method contains custom validation that is checked when the user tries to save the Stage Closure page.</p>
   *
   * @return result
   */
  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    boolean result = true;
    String cdStage = GlobalData.getSzCdStage(request);
    String recAct = ContextHelper.getStringSafe(request, "selSzCdStageReasonClosed");
    String nmFirst = ContextHelper.getStringSafe(request, "txtNmFirst");
    String nmLast = ContextHelper.getStringSafe(request, "txtNmLast");
    //STGAP00014341
    Date txtDtDtStageClose = ContextHelper.getJavaDateSafe(request, "txtDtDtStageClose");
    Date txtDtDtStageCloseFromReopen = ContextHelper.getJavaDateSafe(request, "txtDtDtStageCloseFromReopen");
    if (CodesTables.CSTAGES_ADO.equals(cdStage) && CodesTables.CCLOSADO_ADF.equals(recAct)
        && ("".equals(nmFirst) || "".equals(nmLast))) {
      setErrorMessage(Messages.MSG_CLOSE_ADO_NEW_NAME);
      result = false;
    }
    if ((recAct == null) || ("".equals(recAct))) {
      setErrorMessage("selSzCdReasonClosed", Messages.SSM_COMPLETE_REQUIRED);
      result = false;
    }
    //STGAP00014341
    if(DateHelper.isBefore(txtDtDtStageClose, txtDtDtStageCloseFromReopen) || DateHelper.isAfter(txtDtDtStageClose, new Date())){
      setErrorMessage("txtDtDtStageClose", Messages.MSG_DT_STAGE_CLOSE_OVERLAP);
      result = false;
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
  public static final String TRACE_TAG = "StageClosureCustomValidation";
}


