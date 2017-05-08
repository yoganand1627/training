package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate parameters entered on the ClientCharacteristics page.
 *
 * @author Donald Wilson, August 14, 2002
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class ClientCharacteristicDetailValidation extends FormValidation {
  public static final String TRACE_TAG = "ClientCharacteristicDetailValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace("ClientCharacteristicDetailValidation", "validateForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();

    String smalMinYr = ContextHelper.getStringSafe(request, "malMinYr");
    String smalMaxYr = ContextHelper.getStringSafe(request, "malMaxYr");
    String smalMinMo = ContextHelper.getStringSafe(request, "malMinMo");
    String smalMaxMo = ContextHelper.getStringSafe(request, "malMaxMo");
    String sfemMinYr = ContextHelper.getStringSafe(request, "femMinYr");
    String sfemMaxYr = ContextHelper.getStringSafe(request, "femMaxYr");
    String sfemMinMo = ContextHelper.getStringSafe(request, "femMinMo");
    String sfemMaxMo = ContextHelper.getStringSafe(request, "femMaxMo");

    boolean malMinYrFilled = (smalMinYr.length() > 0);
    boolean malMinMoFilled = (smalMinMo.length() > 0);
    boolean malMaxYrFilled = (smalMaxYr.length() > 0);
    boolean malMaxMoFilled = (smalMaxMo.length() > 0);

    boolean femMinYrFilled = (sfemMinYr.length() > 0);
    boolean femMinMoFilled = (sfemMinMo.length() > 0);
    boolean femMaxYrFilled = (sfemMaxYr.length() > 0);
    boolean femMaxMoFilled = (sfemMaxMo.length() > 0);

    if (malMinYrFilled && !malMinMoFilled) {
      smalMinMo = "0";
      malMinMoFilled = true;
    }
    if (malMaxYrFilled && !malMaxMoFilled) {
      smalMaxMo = "0";
      malMaxMoFilled = true;
    }

    if (!malMinYrFilled && malMinMoFilled) {
      smalMinYr = "0";
      malMinYrFilled = true;
    }
    if (!malMaxYrFilled && malMaxMoFilled) {
      smalMaxYr = "0";
      malMaxYrFilled = true;
    }

    if (femMinYrFilled && !femMinMoFilled) {
      sfemMinMo = "0";
      femMinMoFilled = true;
    }
    if (femMaxYrFilled && !femMaxMoFilled) {
      sfemMaxMo = "0";
      femMaxMoFilled = true;
    }

    if (!femMinYrFilled && femMinMoFilled) {
      sfemMinYr = "0";
      femMinYrFilled = true;
    }
    if (!femMaxYrFilled && femMaxMoFilled) {
      sfemMaxYr = "0";
      femMaxYrFilled = true;
    }

    boolean malAgesDone = malMinYrFilled && malMinMoFilled && malMaxYrFilled && malMaxMoFilled;
    boolean femAgesDone = femMinYrFilled && femMinMoFilled && femMaxYrFilled && femMaxMoFilled;

    boolean malAgesBlank = !malMinYrFilled && !malMinMoFilled && !malMaxYrFilled && !malMaxMoFilled;
    boolean femAgesBlank = !femMinYrFilled && !femMinMoFilled && !femMaxYrFilled && !femMaxMoFilled;

    if (!malAgesDone && !femAgesDone) {
      setErrorMessage("malMinYr", Messages.MSG_FAD_AGE_REQ);
    } else {
      if (!malAgesBlank) {
        int malMinYr = ContextHelper.getIntSafe(request, "malMinYr");
        int malMinMo = ContextHelper.getIntSafe(request, "malMinMo");
        int malMaxYr = ContextHelper.getIntSafe(request, "malMaxYr");
        int malMaxMo = ContextHelper.getIntSafe(request, "malMaxMo");

        int malTotMin = (malMinYr * 12) + malMinMo;
        int malTotMax = (malMaxYr * 12) + malMaxMo;

        if (malTotMin > malTotMax || malTotMax < 1) {
             setErrorMessage("malMinYr", Messages.MSG_RES_INVALID_AGE);
        }
      }

      if (!femAgesBlank) {
        int femMinYr = ContextHelper.getIntSafe(request, "femMinYr");
        int femMinMo = ContextHelper.getIntSafe(request, "femMinMo");
        int femMaxYr = ContextHelper.getIntSafe(request, "femMaxYr");
        int femMaxMo = ContextHelper.getIntSafe(request, "femMaxMo");

        int femTotMin = (femMinYr * 12) + femMinMo;
        int femTotMax = (femMaxYr * 12) + femMaxMo;

        if (femTotMin > femTotMax || femTotMax < 1) {
             setErrorMessage("femMinYr", Messages.MSG_RES_INVALID_AGE);
        }
      }
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
}
