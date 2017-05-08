/**
 * Created on Mar 25, 2006 at 2:19:49 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.CriminalHistory;

public interface CriminalHistoryDAO {

  /**
   * This DAM will retreive rows from the CRIMINAL_HISTORY table given an ID_REC_CHECK.
   *
   * @param idRecCheck
   * @return List<StagePersonLink>
   */
  @SuppressWarnings({"unchecked"})
  List<CriminalHistory> findCriminalHistoryByIdRecCheck(int idRecCheck);

  /**
   * Insert a new CriminalHistory row
   *
   * @param idRecCheck
   * @param cdCrimHistAction
   * @param cdNmCrimHistReturned
   * @param cdTxtCrimHistCmnts
   */
  void insertCriminalHistory(int idRecCheck, String cdCrimHistAction, String cdNmCrimHistReturned,
                             String cdTxtCrimHistCmnts);

  /**
   * Update a Criminal History record
   *
   * @param criminalHistory
   */
  void saveCriminalHistory(CriminalHistory criminalHistory);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.CriminalHistory} object.
   *
   * @param idCrimHist
   * @param dtLastUpdate
   * @return The number of rows deleted.
   */
  int deleteCriminalHistory(int idCrimHist, Date dtLastUpdate);
}
