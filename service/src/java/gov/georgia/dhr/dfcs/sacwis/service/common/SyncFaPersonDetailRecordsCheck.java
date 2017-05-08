package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

/** @author Hai Nguyen, Februrary 24, 2011 */
public interface SyncFaPersonDetailRecordsCheck {

  /**
   * This service sync records check data for the FA Person Detail fields.
   * 
   * @param idPerson
   */
  public void syncFaPersonDetailRecordsCheck (int idPerson) throws ServiceException ;
  
    
}
