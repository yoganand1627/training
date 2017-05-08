package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;

/** @author Herve Jean-Baptiste, Februrary 13, 2010 */
public interface SyncContactRule {

  /**
   * This service syncs the Contact Rules that are saved in the database with the prepopulated Contact Rules that 
   * are created for person listed in the child's 'Caregiver/Parental Relationship Information for Child'
   * section. Based on the stage, it will also sync the additional Putative Fathers. It accomplishes this by
   * deleting any Contact Rules that is no longer prepopulated and adding additional Contact Rules that are now
   * being prepopulated but didn't exist in the database. It also syncs the Contact For section of each Parental
   * Contact Rules  
   * 
   * @param contactStandardsRetrieveSI {@link ContactStandardsRetrieveSI} object
   * @return int {@link ContactStandardsRetrieveSO} object
   */
  public int syncContactRule (ContactStandardsRetrieveSI contactStandardsRetrieveSI) throws ServiceException ;
  
    
}
