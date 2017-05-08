package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildSaveSO;

public interface SaveSafetyResourceChild {
  
  /**
   * Saves information on the Safety Resource Detail page to the SAFETY_RESOURCE_CHILD
   * and EVENT tables as appropriate.  Returns errors for overlapping placements.
   *
   * @param safetyResourceChildSaveSI bean
   * @return SafetyResourceChildSaveSO bean
   * @author Patrick Coogan
   * @throws ServiceException
   */  
   SafetyResourceChildSaveSO saveSafetyResourceChild(SafetyResourceChildSaveSI safetyResourceChildSaveSI);

}
