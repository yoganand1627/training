/**
 * Created on Sept 21, 2006 by Modeste Ngom
 */

package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentSaveSI;

public interface SaSafetyAssessmentDAO {

  /**
   * This will retrieve a row from SAFETY ASSESSMENT table given idEvent.
   *
   * @param idEvent
   * @return SafetyAssessment by idEvent
   */
  SaSafetyAssessment findSafetyAssessmentByIdEvent(int idEvent);

  /**
   * This inserts or updates are row in Sa_Safety_Assessment table
   * @param safetyAssessmentSaveSI
   * @return
   */
  void saveOrUpdateSafetyAssessment(SaSafetyAssessment safetyAssessmentSaveSI);
  
  /**
   * Deletes a row from Sa_Safety_Assessment table
   * @param idEvent
   * @return
   */
  int deleteSafetyAssessment(int idEvent);

}
