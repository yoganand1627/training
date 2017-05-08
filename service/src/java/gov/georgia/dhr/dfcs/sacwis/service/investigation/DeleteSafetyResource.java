package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceDeleteSI;

public interface DeleteSafetyResource {
  
  /**
   * Deletes a Safety Resource record by deleting from SAFETY_RESOURCE, EVENT, 
   * SR_HOUSEHOLD_MEMBERS, and EVENT_PERSON LINK.  App forces all SAFETY_RESOURCE_CHILD
   * records to be deleted before this service is invoked.
   *
   * @param safetyResourceDeleteSI bean
   * @return
   * @author Patrick Coogan
   * @throws ServiceException
   */
  public void deleteSafetyResource(SafetyResourceDeleteSI safetyResourceDeleteSI);
}
