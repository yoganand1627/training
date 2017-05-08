/**
 * Created on Sept 21, 2006 by Modeste Ngom
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyFactor;


import java.util.List;

public interface SaSafetyFactorDAO {
  /**
   * This will retrieve all rows from the SAFETY FACTORS table that match ID Event.
   *
   * @param idEvent
   * @return List of SaSafetyFactors by idEvent
   */
  @SuppressWarnings({"unchecked"})
  List<SaSafetyFactor> findSafetyFactorsByIdEvent(int idEvent);

  /**
   * This will insert or update a row in Sa_Safety_Factor table
   * @param safetyFactor
   */
  void saveOrUpdateSafetyFactor(SaSafetyFactor safetyFactor);
  
  /**
   * Deletes all Sa_Safety_Factors with given idEvent
   * @param idEvent
   * @return
   */
  int deleteSafetyFactor(int idEvent);

}
