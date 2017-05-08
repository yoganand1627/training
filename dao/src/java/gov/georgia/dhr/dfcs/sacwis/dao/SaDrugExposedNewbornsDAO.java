/**
 * Created on Sept 21, 2006 by Modeste Ngom
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SaDrugExposedNewborns;
import java.util.List;

public interface SaDrugExposedNewbornsDAO {
  /**
   * This will retrieve all rows from the SAFETY FACTORS table that match ID Event.
   *
   * @param idEvent
   * @return List of SaSafetyFactors by idEvent
   */
  @SuppressWarnings({"unchecked"})
  List<SaDrugExposedNewborns> findDrugExposedNewbornByIdEvent(int idEvent);
  
  /**
   * This is insert or update row in Sa_Drug_Exposed_NewBorns
   * @param sad
   */
  void saveOrUpdateDrugExposedNewborn(SaDrugExposedNewborns sad);
  
  /**
   * Deletes all Sa_Drug_Exposed_NewBorns rows that match given idEvent 
   * @param idEvent
   * @return
   */
  int deleteDrugExposedNewborns(int idEvent);

}

