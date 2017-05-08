package gov.georgia.dhr.dfcs.sacwis.web.resource;

// -- java classes --

import javax.servlet.http.HttpServletRequest;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Validation class used to validate the ORS Resource Search page <p/> <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  03/12/08  ssubram   Initial Code
 * </pre>
 * 
 * @author ssubram, March 12, 2008
 */
public class ResourceORSSearchValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "ResourceORSSearchValidation";
  
  /**
   * This method performs custom validation on the data submitted on the ORS Resource Search Page
   *
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm()");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    boolean isValid = true;
    String resourceName = ContextHelper.getStringSafe(request, "txtResourceName");
    String legalName = ContextHelper.getStringSafe(request, "txtLegalName");
    String facilityId = ContextHelper.getStringSafe(request, "txtFacilityId");

    boolean resourceNameFilled = resourceName.length() > 0;
    boolean legalNameFilled = legalName.length() > 0;
    boolean facilityIdFilled = facilityId.length() > 0;
  
      //Check if neither Facility ID, Resource Name, nor Legal Name is filled to perform the search.
      //Atleast one field needs to be filled.
      if (!resourceNameFilled && !facilityIdFilled && !legalNameFilled) {
        setErrorMessage("selResourceType", Messages.MSG_RSRC_INVALID_ADV_SRCH);
        isValid = false;
      }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is" + isValid);
    return isValid;
    
  }
}