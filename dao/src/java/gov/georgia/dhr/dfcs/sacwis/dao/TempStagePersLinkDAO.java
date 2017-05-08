/**
 * Created on Mar 25, 2006 at 3:31:32 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.TempStagePersLink;

public interface TempStagePersLinkDAO {
  /**
   * Returns a TempStagePersLink for a given idStage and TempStagePersRole
   *
   * @param idStage
   * @param cdTempStagePersRole
   * @return TempStagePersLink
   */
  TempStagePersLink findTempStagePersLinkByIdStageAndCdTempStagePersRole(int idStage,
                                                                         String cdTempStagePersRole);

  /**
   * Retrieves row from Temp Stage Pers Link table.
   *
   * @param idTempStagePerson
   * @param pageNbr
   * @param pageSize
   * @return
   */
  @SuppressWarnings({"unchecked"})
  PaginatedHibernateList<TempStagePersLink> findTempStagePersLinkByIdTempStagePerson(int idTempStagePerson, int pageNbr,
                                                                                     int pageSize);

  /**
   * This is an  update/insert for TempStagePersLink info.
   *
   * @param tempStagePersLink
   */

  void saveTempStagePersLink(TempStagePersLink tempStagePersLink);

  /**
   * Delete
   *
   * @param tempStagePersLink
   */
  void deleteTempStagePersLink(TempStagePersLink tempStagePersLink);
}
