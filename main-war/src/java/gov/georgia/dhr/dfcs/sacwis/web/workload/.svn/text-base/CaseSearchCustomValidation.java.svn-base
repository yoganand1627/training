package gov.georgia.dhr.dfcs.sacwis.web.workload;

// -- java classes --

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate Case Search information.
 *
 * @author Jonathan Hardy, January 8, 2003 Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  dickmaec     SIR 19857 -- Verified that
 *         getInputValue() value was not being used.
 */
public class CaseSearchCustomValidation extends FormValidation {

  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("CaseSearchCustomValidation", "validateForm");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");
    HttpServletRequest request = super.getRequest();

    boolean isValid = true;

    String txtUlIdCase = ContextHelper.getStringSafe(request, "txtUlIdCase");
    String txtSzNmCase = ContextHelper.getStringSafe(request, "txtSzNmCase");
    String txtSzNmCaseFirst = ContextHelper.getStringSafe(request, "txtSzNmCaseFirst");
    String txtSzNmCaseMiddle = ContextHelper.getStringSafe(request, "txtSzNmCaseMiddle");
    String txtSzNmCaseLast = ContextHelper.getStringSafe(request, "txtSzNmCaseLast");
    String txtUlIdCaseManager = ContextHelper.getStringSafe(request, "txtUlIdCaseManager");
    String txtSzNmCaseManagerFirst = ContextHelper.getStringSafe(request, "txtSzNmCaseManagerFirst");
    String txtSzNmCaseManagerLast = ContextHelper.getStringSafe(request, "txtSzNmCaseManagerLast");
    String txtSzNbrUnit = ContextHelper.getStringSafe(request, "txtSzNbrUnit");
    String txtDtDtLastUpdate = ContextHelper.getStringSafe(request, "txtDtDtLastUpdate");

    if ("".equals(txtSzNmCaseLast) && "".equals(txtSzNmCaseMiddle)
        && "".equals(txtSzNmCaseFirst) && "".equals(txtSzNmCase)
        && "".equals(txtUlIdCase) && "".equals(txtUlIdCaseManager)
        && "".equals(txtSzNmCaseManagerLast) && "".equals(txtSzNmCaseManagerFirst)) {
      //NO required search parameters have been entered
      super.setErrorMessage(Messages.MSG_CSE_SEARCH_PARM);
      isValid = false;
    }
    if ("".equals(txtSzNmCase) && "".equals(txtUlIdCase)
        && "".equals(txtSzNmCaseLast) && "".equals(txtUlIdCaseManager)
        && "".equals(txtSzNmCaseManagerLast)
        && ((!"".equals(txtSzNmCaseFirst) || !"".equals(txtSzNmCaseMiddle)))) {
      //Person first or middle name entered, but nothing else
      super.setErrorMessage("txtSzNmCaseLast", Messages.MSG_CSE_SRCH_LAST_NM_REQ);
      isValid = false;
    }
    //Added the 
    if ("".equals(txtSzNmCase) && "".equals(txtUlIdCase)
        && "".equals(txtSzNmCaseLast) && "".equals(txtUlIdCaseManager)
        && "".equals(txtSzNmCaseManagerLast)
        && (!"".equals(txtSzNmCaseManagerFirst))) {
      //Case Manager's first name entered, but nothing else
      super.setErrorMessage("txtSzNmCaseManagerLast", Messages.MSG_CSE_SRCH_LAST_NM_REQ);
      isValid = false;
    }
    if ("".equals(txtSzNmCase) && "".equals(txtUlIdCase) && "".equals(txtUlIdCaseManager)
        && "".equals(txtSzNmCaseManagerLast)
        && !("".equals(txtSzNmCaseMiddle)) && "".equals(txtSzNmCaseFirst)) {
      //Can't have middle initial without first name.
      super.setErrorMessage("txtSzNmCaseFirst", Messages.MSG_CSE_SRCH_FRST_NM_REQ);
      isValid = false;
    }

    if ("".equals(txtUlIdCaseManager) && "".equals(txtSzNmCaseManagerLast) && !"".equals(txtDtDtLastUpdate)) {
      super.setErrorMessage("txtSzNmCaseManagerLast", Messages.MSG_CSE_SRCH_CM_LAST_NM_ID_REQ);
      super.setErrorMessage("txtUlIdCaseManager", Messages.MSG_CSE_SRCH_CM_LAST_NM_ID_REQ);
      isValid = false;
    }

    if ("".equals(txtSzNmCaseLast) && !"".equals(txtSzNbrUnit)) {
      super.setErrorMessage("txtSzNmCaseLast", Messages.MSG_CSE_SRCH_UNIT_LAST_NM_REQ);
    }

    GrndsTrace.exitScope(TRACE_TAG + ".validateForm");
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "CaseSearchCustomValidation";

}