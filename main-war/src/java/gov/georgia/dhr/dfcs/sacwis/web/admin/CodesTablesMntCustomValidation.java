package gov.georgia.dhr.dfcs.sacwis.web.admin;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to perform the custom validation on Code Detail. <p/> <p/>
 * 
 * <pre>
 *                          Change History:
 *                           Date          User                    Description
 *                           ----------    --------------------    ----------------------
 *                           07/21/2008     vdevarakonda           Initial class creation
 */
@SuppressWarnings("serial")
public class CodesTablesMntCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "CodesTablesMntCustomValidation";

  @SuppressWarnings( { "unchecked" })
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    boolean result = true;
    Date dtEnd = ContextHelper.getJavaDateSafe(request, "dtEndDate");
    String transType = ContextHelper.getStringSafe(request, "dspTransType");
    transType= Lookup.simpleEncodeSafe(CodesTables.CCTUPDT,transType);
    if (CodesTables.CCTUPDT_F.equals(transType) && !DateHelper.isNull(dtEnd) && DateHelper.isBeforeToday(dtEnd)) {
      setErrorMessage("dtEndDate", Messages.MSG_END_DATE_FUTURE);
      result = false;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }

}