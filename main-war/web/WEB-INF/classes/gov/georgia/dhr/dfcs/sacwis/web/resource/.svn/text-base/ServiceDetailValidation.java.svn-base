package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate parameters entered on the ServicesByAreaDetail page.
 *
 * @author Donald Wilson, August 14, 2002
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class ServiceDetailValidation extends FormValidation {
  public static final String TRACE_TAG = "ServiceDetailValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace("ServiceDetailValidation", "validateForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    
    boolean bCounty = StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzScrRsrcSvcCntyCode"));
    boolean bAllCounties = StringHelper.isValid(ContextHelper.getStringSafe(request, "allCounties"));
    //we are no longer in Texas
    boolean binTexas = (StringHelper.checkForEquality(ContextHelper.getStringSafe(request, "selSzCdRsrcSvcState"),
                                                      CodesTables.CSTATE_GA));

    boolean bSWIorSO =
            StringHelper.checkForEquality(ContextHelper.getStringSafe(request, "selSzCdRsrcSvcRegion"), "99");

    // first, check to see if we're in SWI or SO
    if (!bSWIorSO) {
      // if not, check for county or ALL counties, but not both
      if (!(bCounty || bAllCounties)) {
        setErrorMessage("selSzScrRsrcSvcCntyCode",
                        "County or All Counties is required.");
      }
    } else {
      // if so, make sure all counties is unchecked and no county is selected
      if ((bCounty || bAllCounties) && binTexas) {
        setErrorMessage("selSzScrRsrcSvcCntyCode",
                        "County and All Counties not allowed in State Office regions.");
      }
    }

    if (bCounty && bAllCounties) {
      setErrorMessage("selSzScrRsrcSvcCntyCode",
                      "A county cannot be entered if All Counties is selected.");
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
}
