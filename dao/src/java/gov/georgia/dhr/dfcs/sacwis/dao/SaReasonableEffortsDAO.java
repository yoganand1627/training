/**
 * Created on Sept 21, 2006 by Modeste Ngom
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SaReasonableEfforts;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ReasonableEffortsSaveSI;

import java.util.List;

public interface SaReasonableEffortsDAO {
  /**
   * This will retrieve all rows from the SAFETY FACTORS table that match ID Event.
   *
   * @param idEvent
   * @return List of SaSafetyFactors by idEvent
   */
  @SuppressWarnings({"unchecked"})
  List<SaReasonableEfforts> findReasonableEffortsByIdEvent(int idEvent);
  
  /**
   * This will insert or update a row in SA_REASONABLE_EFFORTS table
   * @param reasonableEfforts
   */
  void saveOrUpdateReasonableEfforts(SaReasonableEfforts reasonableEfforts);
  
  /**
   * This will delete all rows in Sa_Reasonable_Efforts with given idEvent
   * @param idEvent
   * @return
   */
  int deleteReasonableEfforts(int idEvent);

}
