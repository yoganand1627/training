package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveDiversionConclusionValidationSI;


/**
 * This is the interface is used to run validations/edits for the Diversion
 * Conclusion page.
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------

 * </pre>
 */

public interface SaveDiversionConclusionValidation {
  
  public static final String SVC_AUTH_CD_TASK = "6000";
  
  /**
   * Performs server side validation for the Diversion Conclusion window
   * 
   * @param saveDiversionConclusionValidationSI
   * @throws ServiceException
   * @return List<Integer> List of error codes
   */
  public List<Integer> saveDiversionConclusionValidation (SaveDiversionConclusionValidationSI saveDiversionConclusionValidationSI) 
                                                      throws ServiceException;

}
