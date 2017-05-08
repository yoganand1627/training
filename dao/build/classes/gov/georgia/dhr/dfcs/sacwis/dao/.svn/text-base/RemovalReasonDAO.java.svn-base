/**
 * Created on Mar 25, 2006 at 3:23:10 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.RemovalReason;

public interface RemovalReasonDAO {
  /**
   * This will retrieve all rows from the Removal Reason table that match an Id Event.
   *
   * @param idEvent
   * @return List of RemovalReason
   */
  @SuppressWarnings({"unchecked"})
  List<RemovalReason> findListOfRemovalReasonByIdEvent(int idEvent);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalReason} object to the database.
   *
   * @param removalReason A populated {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalReason} object.
   */
  void saveRemovalReason(RemovalReason removalReason);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalReason} object to the database.
   *
   * @param idEvent
   * @param cdRemovalReason
   * @param dtLastUpdate
   * @return Integer
   */
  int updateRemovalReason(int idEvent, String cdRemovalReason,
                          Date dtLastUpdate);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.RemovalReason} object.
   *
   * @param removalReason
   */
 // void deleteRemovalReason(RemovalReason removalReason);//mxpatel commented this out for defect #9009
  
  void deleteRemovalReason(int idCase, int idRemovalReason, String cdRemovalReason); //mxpatel added this for defect #9009
}
