/**
 * Created on Mar 25, 2006 at 3:33:52 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Situation;

public interface SituationDAO {
  /**
   * Retrieves a Situation row and returns it as an object
   *
   * @param idSituation
   * @return Situation
   */
  Situation findSituation(int idSituation);

  /**
   * This selects a row from the Situation table by the Situation ID.
   * <p/>
   *
   * @param idSituation
   * @return Keys  capsCase, dtSituationClosed, dtSituationOpened
   */
  Map findSituationByIdSituation(int idSituation);

  /**
   * Inserts a new row with the given parameters into Situation
   * 
   * @param idSituation
   * @param idCase
   * @param dtSituationOpened
   * @param dtSituationClosed
   * @return
   */
  int insertSituationUsingIdCaseDtSituationOpenedDtSituationClosed( int idSituation, int idCase, Date dtSituationOpened, Date dtSituationClosed );

  /**
   * Partial update of Situation table using the supplied parameters(column values).
   *
   * @param dtSituationClosed
   * @param idSituation
   */
  int updateSituation(Date dtSituationClosed, int idSituation);

  /**
   * update a Situation row with idCase and dates opened / closed
   *
   * @param idCase
   * @param dtSituationOpened
   * @param dtSituationClosed
   * @param idSituation
   * @return num rows updated
   */
  int updateSituationIdCaseDtOpenClosed(int idCase, Date dtSituationOpened, Date dtSituationClosed,
                                        int idSituation);

  /**
   * Save row situation
   *
   * @param situation
   */
  void saveSituation(Situation situation);
  
  /**
   * 
   * Delete row situation
   * @param situation
   */
  void deleteSituation(Situation situation);
  
  /**
   * Saves or updates Situation record
   * @param situation
   * @return
   */
  int saveNewSituation(Situation situation);
}
