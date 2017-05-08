/**
 * Created on Mar 25, 2006 at 3:22:53 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild;

public interface RemovalCharChildDAO {
  /**
   * Retrieves rows from the Removal Char Child table given an ID Event.
   *
   * @param idRemovalEvent
   * @return List RemovalCharChild by idEvent
   */
  @SuppressWarnings({"unchecked"})
  List<RemovalCharChild> findRemovalCharChildByIdRemovalEvent(int idRemovalEvent);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild} object to the database.
   *
   * @param removalCharChild A populated {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild} object.
   */
  void saveRemovalCharChild(RemovalCharChild removalCharChild);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild} object to the database.
   *
   * @param indCharChildCurrent
   * @param dtLastUpdate
   * @param idEvent
   * @param cdRemovChildChar
   * @return Integer
   */
  int updateRemovalCharChild(String indCharChildCurrent, Date dtLastUpdate,
                             int idEvent, String cdRemovChildChar);
}
