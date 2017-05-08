package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;

public interface RetrieveSafetyResourceChild {
  
  /**
   * Retrieves information for display of the Safety Resource Child Detail page from the 
   * database using a SafetyResourceChildRetrieveSI bean.
   *
   * @param safetyResourceChildRetrieve bean
   * @return SafetyResourceChildRetrieveSO bean
   * @author Patrick Coogan
   * @throws ServiceException
   */  
   SafetyResourceChildRetrieveSO retrieveSafetyResourceChild(SafetyResourceChildRetrieveSI safetyResourceChildRetrieveSI);

}