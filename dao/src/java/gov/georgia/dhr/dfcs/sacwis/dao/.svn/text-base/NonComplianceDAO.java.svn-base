/**
 * Created on June 05, 2008 at by ssubram
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.NonCompliance;

public interface NonComplianceDAO {
  /**
   * Retrieves all NonCompliance from the Non_Compliance table given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  NonCompliance findNonComplianceByIdEventIdCase(int idEvent, int idCase);

  /**
   * Retrieves NonCompliance from the Non_Compliance table for the given idNonCompliance. <p/>
   * 
   * @param idNonCompliance
   * @return
   */
  NonCompliance findNonComplianceById(int idNonCompliance);

  /**
   * Counts the number of Non Compliance record saved for the given idCase and cdNonCompliance
   * 
   * @param idCase
   * @param cdNonCompliance
   * @return count of Non Compliance rows
   */
  long countTotalNonComplianceByIdCaseCdNonCompliance(int idCase, String cdNonCompliance);

  /**
   * Saves Non_Compliance table and returns id_NonCompliance after the save.
   * 
   * @param NonCompliance
   * @return id_NonCompliance
   */
  int saveNonComplianceReturnId(NonCompliance nonCompliance);

}
