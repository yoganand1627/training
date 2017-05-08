/**
 * Created on Mar 25, 2006 at 3:22:35 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult;

public interface RemovalCharAdultDAO {
  /**
   * Retrieves the rows from the Removal Char Adult table given an ID Event.
   *
   * @param idRemovalEvent
   * @return List RemovalCharAdult by idEvent
   */
  @SuppressWarnings({"unchecked"})
  List<RemovalCharAdult> findRemovalCharAdultByIdRemovalEvent(int idRemovalEvent);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult} object to the database.
   *
   * @param removalCharAdult A populated {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult} object.
   */
  void saveRemovalCharAdult(RemovalCharAdult removalCharAdult);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult} object to the database.
   *
   * @param idEvent
   * @param cdRemovAdultChar
   * @param dtLastUpdate
   * @return Integer
   */
  int updateRemovalCharAdult(int idEvent, String cdRemovAdultChar, Date dtLastUpdate);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult} object.
   *
   * @param removalCharAdult
   */
  //void deleteRemovalCharAdult(RemovalCharAdult removalCharAdult); //mxpatel commented this out for defect #9009
  void deleteRemovalCharAdult(int idRemovalEvent, String cdRemovAdultChar); //mxpatel added this for defect #9009
}
