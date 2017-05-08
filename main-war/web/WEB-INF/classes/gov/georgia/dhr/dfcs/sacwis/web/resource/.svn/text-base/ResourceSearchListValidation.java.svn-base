package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate search parameters entered on Resource Search page.
 *
 * @author Bhavna Gehlot, June 30, 2010
 *         <p/>
 *         Change History: 
 *          Date      User         Description 
 *         --------  -----------   ---------------------------------------------- 
 *         06/30/2010 bgehlot      60409 Add new error message when resource selection is CPA when coming from
 *                                 Investigation conclusion and Intake Information page.
 */
public class ResourceSearchListValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "ResourceSearchListValidation";
  public static String CPS_INV_CNCLSN_CALLED = "/investigation/CPSInvCnclsn/setFacilityResource";
  
  public static String INTAKE_INFORMATION_CALLED = "/intake/CallInformation/setFacilityResource";
  
  public static final String PREVIOUS_URL = TRACE_TAG + "PREVIOUS_URL"; 
  
  /**
   * This method performs custom validation on the data submitted on the Resource Search List Page
   *
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm()");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();
    BaseSessionStateManager state = this.getState();

    boolean isValid = true;
    
    // Get parameter if coming from Results page
    String facilityType = request.getParameter("txtFacilityType");
    String destinationUrl = request.getParameter("destinationUrl");

    if( (CPS_INV_CNCLSN_CALLED.equals(destinationUrl) || INTAKE_INFORMATION_CALLED.equals(destinationUrl) )
                    && StringHelper.isValid(ContextHelper.getStringSafe(request, "btnContinue.x"))
                                            && CodesTables.CFACTYP4_CP.equals(facilityType)){
      setErrorMessage("If maltreatment occurs in a non-DFCS F/A Home, the Provider name should never be the name of a Child Placing Agency, but the name of the F/A Home.");
      request.setAttribute("CPAError", ArchitectureConstants.TRUE);
      isValid = false;
    }else{
      request.setAttribute("CPAError", ArchitectureConstants.FALSE);
    }
   
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is" + isValid);
    return isValid;
    
  }
}





