package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors;

public interface SpSafetyFactorsDAO {

  /**
   * Retrieves a Safety Factor list from SaSafetyFactors table. <p/>
   * 
   * @param idEvent
   * @return List<SpSafetyFactors> {@link List<gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors>} object
   */
  List<SpSafetyFactors> findSpSafetyFactors(int idEvent);

  /**
   * Save a {@link gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors} object into the database.
   * 
   * @param spSafetyFactors
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors} object.
   */
  void saveSafetyFactor(SpSafetyFactors spSafetyFactors);

  /**
   * This will delete rows from the SP_SAFETY_FACTORS table that match idSftyFctr.
   * 
   * @param idSftyFctr
   * @return Integer
   */

  int deleteSafetyFactor(int idSftyFctr);
}
