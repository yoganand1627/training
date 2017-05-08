/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ChildrenFirstReferral;

/**
 * @author ashwini.rege
 *
 */

public interface ChildrenFirstReferralDAO {
  
  /**
   * 
   * Find ChildrenFirstReferral Record for given idEvent
   * @param idEvent
   * @return ChildrenFirstReferral
   */
  ChildrenFirstReferral findChildrenFirstReferralByIdEvent(int idEvent);
  
  //SMS#112531  
  /**
   * This method finds the latest Completed (COMP) CFR record for a given person
   * @param idPerson
   * @return ChildrenFirstReferral record
   */
  public ChildrenFirstReferral findLatestCompChildrenFirstReferralByIdPerson (int idPerson);
  
  /**
   * 
   * Saves ChildrenFirstReferral Record.
   * @param childrenFirstReferral
   */
  void saveChildrenFirstReferral(ChildrenFirstReferral childrenFirstReferral);
  
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ChildrenFirstReferral} object.
   * 
   * @param idEvent
   */
  int deleteCFR(int idEvent);

}
