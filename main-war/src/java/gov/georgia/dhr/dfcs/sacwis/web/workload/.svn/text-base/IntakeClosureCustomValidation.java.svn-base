//Declare your class pacakge
package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * This class is used to perform the custom validation on Intake Priority Closure page.
 *
 * @author John Ramspott April 29, 2008
 *         <p/>
 *         Date      User         Description --------  -----------  ----------------------------------------------
 *         04/29/08  jramspott     Re-write for use in Georgia SHINES  Created for STGAP00008086
 *         07/15/08  arege         STGAP00009014  Changed if condition under Case B to Consider response time Comments, 
 *                                 previously Priority comments were used, making the comments box on IntakeActions Page and 
 *                                 IntakeClosure Page common and the same column in Stage table was used.
 *                                 
 *         
 */
public class IntakeClosureCustomValidation extends FormValidation {
  /** This method will validate the Priority Closure page. */
  
  public static final String TRACE_TAG = "IntakeClosureCustomValidation";
  
  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();

    boolean result = true;

    org.exolab.castor.types.Date dtSysDate = ContextHelper.getCastorDateSafe(request, "hdnDtSysDtGenericSysdate");
    org.exolab.castor.types.Date dtStageStart = ContextHelper.getCastorDateSafe(request, "hdnDtDtStageStart");
    org.exolab.castor.types.Date dtChanged = ContextHelper.getCastorDateSafe(request, "txtDtSysDtGenericSysdate");

    String currPri = ContextHelper.getStringSafe(request, "hdnSzCdStageCurrPriority");
    String newPri = ContextHelper.getStringSafe(request, PRIORITY_SELECT_BOX);
    String rsnChanged = ContextHelper.getStringSafe(request, "selSzCdStageRsnPriorityChgd");
    String disposition = ContextHelper.getStringSafe(request, IntakeClosureConversation.DISPOSITION_SELECT_BOX);
    String screenOut = ContextHelper.getStringSafe(request, "selSzCdScreenOutReason");
    //String priorityComments = ContextHelper.getStringSafe(request, "txtaSzTxtStagePriorityCmnts");
    String responseTimeComments = ContextHelper.getStringSafe(request, "szTxtStageResponseTimeCmnts");
    String dispComments = ContextHelper.getStringSafe(request, "txtaSzTxtStageClosureCmnts");

    char mode = (char) 0;
    String modeString = ContextHelper.getStringSafe(request, "mode");
    if (modeString.length() > 0) {
      mode = modeString.charAt(0);
    }

    boolean bSaveAndSubmit = super.isButtonPressed("btnSaveAndSubmit");
    boolean bSaveandClose = super.isButtonPressed("btnSaveAndClose");
    boolean dispNeedsScroutReason = false;
    boolean bDispChange = !ContextHelper.getStringSafe(request, IntakeClosureConversation.DISPOSITION_SELECT_BOX).equals(ContextHelper.getStringSafe(
                                                                                                                           request, "hdnSzCdIncomingDisposition"));
    
    if (StringHelper.isValid(disposition) && (CodesTables.CDISP_DIV.equals(disposition)
                    || CodesTables.CDISP_SCO.equals(disposition) || CodesTables.CDISP_SCR.equals(disposition))) {
      dispNeedsScroutReason = true;
    }

    GrndsTrace.msg(TRACE_TAG, 7,"Disposition:<" + disposition + ">");
    GrndsTrace.msg(TRACE_TAG, 7,"Screen Out Reason:<" + screenOut + ">");
    GrndsTrace.msg(TRACE_TAG,7,"dispNeedsScroutReason: " + dispNeedsScroutReason);
    
    // Mode B is for updating a normal Intake. Chaging disposition to OIE or Screen out
    // will lead to stage closure if supervisor approves.
    // Mode C is for direct closure of stage/case if non-incident intake

    switch (mode) {
      case'B':
        if (!currPri.equals(newPri) &&
                        "".equals(rsnChanged)) {
                      setErrorMessage("selSzCdStageRsnPriorityChgd", Messages.MSG_REASON_CHANGED_REQ);
                      result = false;
        }
        if (dtChanged != null && dtChanged.compareTo(dtSysDate) == org.exolab.castor.types.Date.GREATER_THAN) {
          setErrorMessage("txtDtSysDtGenericSysdate", Messages.MSG_DATE_CHANGED_CURR_DATE);
          result = false;
        }
        if (dtChanged != null && dtChanged.compareTo(dtStageStart) == org.exolab.castor.types.Date.LESS_THAN) {
          setErrorMessage("txtDtSysDtGenericSysdate", Messages.MSG_INT_PRIORITY_DATE_INVALID);
          result = false;
        }
        if (!currPri.equals(newPri) && dtChanged == null) {
          setErrorMessage("txtDtSysDtGenericSysdate", Messages.MSG_DATE_CHANGED_CURR_DATE);
          result = false;
        }
        if (!currPri.equals(newPri) &&
                        "".equals(responseTimeComments)) {
                      setErrorMessage("szTxtStageResponseTimeCmnts", Messages.MSG_CMTS_REQ_RESP_TIME);
                      result = false;
        }
        if (bDispChange && "".equals(dispComments)) {
          setErrorMessage("txtaSzTxtStageClosureCmnts", Messages.MSG_CMTS_REQ_DISP);
          result = false;
        }
        if (dispNeedsScroutReason && !StringHelper.isValid(screenOut)) {
          setErrorMessage("selSzCdScreenOutReason", Messages.MSG_SCRN_OUT_RSN_REQ);
          result = false;
        }
        break;
      case'C':
          if ("".equals(dispComments)) {
            setErrorMessage("txtaSzTxtStageClosureCmnts", Messages.MSG_CMTS_REQ_INT_SAVE);
            result = false;
          }
        break;
      
      default:
    }

    return result;
  }

  /** @todo remove old commented out code */
  // static constants
//  public static final String TRACE_TAG = "AdmnReviewCustomValidation";

  public static final String PRIORITY_SELECT_BOX = "selSzCdStageCurrPriority";
}
