/**
 * Created on Sep 13, 2006 at 1:09 PM by Ade Odutayo
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

public interface StffAsgnmtHistoryDAO {
  /**
   * This obtains the full row of the STFF_ASGNMT_HISTORY table. It includes the county of both the from and to
   * persons.
   *
   * @param idCase
   * @return Map of the columns - idToPerson, idFromPerson, idEnteredBy, fromCounty, toCounty, idStage, idCase,
   *         idStffAsgnmtHstry, idStagePersonLink, dtLastUpdate,
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findStffAsgnmtHistoryByIdCase(int idCase);

  /**
   * This inserts the fields for a row into the database. This includes the idFromPerson, idToPerson, idEnteredByPerson,
   * idStage, idCase, idStffAsgnmtHstry
   *
   * @param idCase
   * @param idFromPerson
   * @param idToPerson
   * @param idEnteredByPerson
   * @param idStage
   * @return int
   */
  @SuppressWarnings({"unchecked"})
  public int insertStffAsgnmtHistory(int idFromPerson, int idToPerson, int idEnteredByPerson, int idStage, int idCase);

}
