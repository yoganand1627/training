package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/*
* Date        User      Description
* --------    --------  --------------------------------------------------
* 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 */

public class InitialContactCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "ContactDetailCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    String type = ContextHelper.getStringSafe(request, "selSzCdContactType");
    // JMC - SIR 17419 - We are updating the task table so multiple instances of all the Admin Review
    // events can be created.  We still need to make sure they are not attempting to add another
    // Process Notes event though.
    if ((this.isButtonPressed("btnContinue")) && (type.equals(CodesTables.CCNTCTYP_KPRO))) {
      BaseSessionStateManager state = super.getState();
      ROWCSYS04SO_ARRAY rowcsys04soArray = (ROWCSYS04SO_ARRAY) state.getAttribute("rowcsys04soArray", request);
      if (rowcsys04soArray != null) {
        Enumeration e = rowcsys04soArray.enumerateROWCSYS04SO();
        while (e.hasMoreElements()) {
          ROWCSYS04SO row = (ROWCSYS04SO) e.nextElement();
          if (CodesTables.CCNTCTYP_KPRO.equals(row.getSzCdContactType())) {
            setErrorMessage(Messages.MSG_SYS_MULT_PRNOTE);
            break;
          }
        }
      }
    }
    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
}
