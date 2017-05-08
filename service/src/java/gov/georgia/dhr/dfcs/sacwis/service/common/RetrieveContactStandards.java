package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;

/** @author Herve Jean-Baptiste, Februrary 13, 2010 */
public interface RetrieveContactStandards {
   
  /**
   * This service retrieves all the information from the Database to display The Contact Standards
   * 
   * @param contactStandardsRetrieveSI {@link ContactStandardsRetrieveSI} object
   * @return ParentContactStandardsRetrieveSO {@link ContactStandardsRetrieveSO} object
   */
  public ContactStandardsRetrieveSO retrieveContactStandards (ContactStandardsRetrieveSI contactStandardsRetrieveSI) throws ServiceException ;
  
    
}
