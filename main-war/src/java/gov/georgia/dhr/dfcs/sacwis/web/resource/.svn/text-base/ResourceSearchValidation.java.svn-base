package gov.georgia.dhr.dfcs.sacwis.web.resource;

// -- java classes --

import javax.servlet.http.HttpServletRequest;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate search parameters entered on Resource Search page.
 *
 * @author Sanjay Rana, July 23, 2002
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *         <p/>
 *         05/13/04  REEDLG       SIR 22796 - Expand length of FACILITY NBR to match CLASS. Modify edit criteria to
 *         allow 8 chars. in resource search by facility nbr. 05/19/04  REEDLG       Removed MessageLookup import.
 *         Optimized import.
 */
public class ResourceSearchValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "ResourceSearchValidation";
  
  /**
   * This method performs custom validation on the data submitted on the Resource Search Page
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
    String resourceType = ContextHelper.getStringSafe(request, "selResourceType");
    String resourceName = ContextHelper.getStringSafe(request, "txtResourceName");
    String service = ContextHelper.getStringSafe(request, "selResourceService");
    String identificationType = ContextHelper.getStringSafe(request, "selIdentificationType");
    String identificationNumber = ContextHelper.getStringSafe(request, "txtIdentificationNumber");
    String facilityType = ContextHelper.getStringSafe(request, "selResourceFacilityType");
    //String levelOfCare = ContextHelper.getStringSafe(request, "selResourceLOC");
    String age = ContextHelper.getStringSafe(request, "txtResourceAge");
    String sex = ContextHelper.getStringSafe(request, "selResourceSex");
    String characteristics = ContextHelper.getStringSafe(request, "selResourceCharacterisitcs");
    String locAreaProx = ContextHelper.getStringSafe(request, "rbResourceLocationArea");
    String proximityRange = ContextHelper.getStringSafe(request, "selProximityRange");
    String resourceCounty = ContextHelper.getStringSafe(request, "selResourceCounty");
    String resourceAddress = ContextHelper.getStringSafe(request, "txtResourceAddress1");
    String city = ContextHelper.getStringSafe(request, "txtResourceCity");
    String zip = ContextHelper.getStringSafe(request, "txtResourceZip");

    boolean resourceTypeFilled = resourceType.length() > 0;
    boolean resourceNameFilled = resourceName.length() > 0;
    boolean serviceFilled = service.length() > 0;
    boolean identificationNumberFilled = identificationNumber.length() > 0;
    boolean isProx = "prox".equalsIgnoreCase(locAreaProx); 
    boolean resourceCountyFilled = resourceCounty.length() > 0;
    boolean resourceAddressFilled = resourceAddress.length() > 0;
    boolean cityFilled = city.length() > 0;
    boolean zipFilled = zip.length() > 0;
    

    if(isProx){
      //ToDo --- Once messaging framework is created get error messages from messaging framework
      //rather than hardcoding the error messages
      if (!resourceCountyFilled && !resourceAddressFilled && !cityFilled && !zipFilled) {
        setErrorMessage("selProximityRange", Messages.MSG_RSRC_PROXIMITY_SEARCH_PARAM);
        isValid = false;
      }
    }
    
    
    if(!isProx){
      //ToDo --- Once messaging framework is created get error messages from messaging framework
      //rather than hardcoding the error messages
      if (!resourceTypeFilled && !resourceNameFilled && !serviceFilled && !identificationNumberFilled) {
        setErrorMessage("selResourceType", Messages.MSG_RSRC_ENT_SEARCH_PARAM);
        isValid = false;
      }
     
      //Check if less than 2 characters are entered for Resource Name
      if (resourceName.length() > 0 && resourceName.length() < 2) {
        setErrorMessage("txtResourceName", Messages.MSG_RSRC_ENTER_TWO_CHAR);
        isValid = false;
      }
      
      //Make sure Identification Number is not entered without an Identification Type
      if (identificationNumber.length() > 0 && identificationType.length() < 1) {
        setErrorMessage("selIdentificationType", Messages.MSG_RSRC_ID_TYPE_MISSING);
        isValid = false;
      }
      
      //Make sure correct number of numerals are entered for Identification Number depending on Identification Type
      if (CodesTables.CRSIDTYP_RSC.equals(identificationType) && (identificationNumber.length() < 2 || identificationNumber.length() > 9)) {
        setErrorMessage("txtIdentificationNumber", Messages.MSG_RSRC_RES_CHAR_RANGE);
        isValid = false;
      }
      
      if (CodesTables.CRSIDTYP_CON.equals(identificationType) && (identificationNumber.length() < 2 || identificationNumber.length() > 9)) {
        setErrorMessage("txtIdentificationNumber", Messages.MSG_RSRC_CONTRACT_RANGE);
        isValid = false;
      }
      
      //Check if neither Resource Type, Resource Name, nor Service is filled but an advanced search field is filled.
      //!StringHelper.EMPTY_STRING.equals(levelOfCare) ||
      if (!resourceTypeFilled && !resourceNameFilled && !serviceFilled && (!StringHelper.EMPTY_STRING.equals(facilityType) ||
                      !StringHelper.EMPTY_STRING.equals(age) ||
                      !StringHelper.EMPTY_STRING.equals(sex) || 
                      !StringHelper.EMPTY_STRING.equals(characteristics))) {
        setErrorMessage("selResourceType", Messages.MSG_RSRC_INVALID_ADV_SRCH);
        isValid = false;
      }
    } 
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is" + isValid);
    return isValid;
    
  }
}





