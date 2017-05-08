package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSaveSO;

/** @author Herve Jean-Baptiste, Februrary 13, 2010 */
public interface SaveContactStandards {

  /**
   * Saves the Contact Standards 
   * 
   * @param contactStandardsRetrieveSO {@link ContactStandardsRetrieveSO} object
   * @return ContactStandardsSaveSO {@link ContactStandardsSaveSO} object
   */
  public ContactStandardsSaveSO saveContactStandards (ContactStandardsRetrieveSO contactStandardsRetrieveSO) throws ServiceException;
}
