/**
 * Created on Mar 25, 2006 at 2:20:46 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.CpsChecklistItem;

public interface CpsChecklistItemDAO {
  /**
   * Returns CpsCheckListItems for an idEvent
   *
   * @param idEvent
   * @return List<CpsChecklistItem>
   */
  @SuppressWarnings({"unchecked"})
  List<CpsChecklistItem> findCpsCheckListItemByIdEvent(int idEvent);

  /**
   * Delete rows from CpsChecklistItem based on CD_SRVC_REFERRED
   *
   * @param idChklstItem
   * @param tsLastUpdate
   * @param cdSvcReferred
   * @return
   */
  int deleteCpsChecklistItemByCdSvcReferred(int idChklstItem, Date tsLastUpdate, String cdSvcReferred);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.CpsChecklistItem} object to the database.
   *
   * @param cpsChecklistItem A populated {@link gov.georgia.dhr.dfcs.sacwis.db.CpsChecklistItem} object.
   */
  void saveCpsChecklistItem(CpsChecklistItem cpsChecklistItem);
}
