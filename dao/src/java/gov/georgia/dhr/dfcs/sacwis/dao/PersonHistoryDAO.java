/**
 * Created on Mar 25, 2006 at 3:12:59 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PersonHistory;

public interface PersonHistoryDAO {
  /**
   * Retrieve PersHistFull for given idPerson having the oldest HistEffect
   *
   * @param idPerson
   * @return
   */
  String findPersonHistoryByIdPersonforPersonwithOldestHistEffect(int idPerson);

  /**
   * Retrieves PersonHistory by Id Person where given date is between HistEffect and HistEnd.
   *
   * @param idPerson
   * @return
   */
  String findPersonHistoryByIdPerson(int idPerson, Date dtPlcmtStart);

  /**
   * This retrieves PersonHistory given idPerson and lastUpdate
   *
   * @param idPerson
   * @param lastUpdate
   */
  PersonHistory findPersonHistoryByIdPersonAndLastUpdate(int idPerson,
                                                         Date lastUpdate);
}
