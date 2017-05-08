/**
 * Created on Mar 25, 2006 at 3:21:15 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention;

public interface RecordsRetentionDAO {
  /**
   * This selects a row from RecordsRetention.
   *
   * @param idCase
   * @return RecordsRetention
   */
  RecordsRetention findRecordsRetention(int idCase);

  /**
   * This counts the number of {@link gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention} objects for a case.
   *
   * @param idCase
   * @return The number of records retention records for the case.
   */
  long countRecordsRetentionByIdCase(int idCase);

  /**
   * Inserts records retention DAO directly; used to get a row count of inserts.
   *
   * @param idCase
   * @param dtLastUpdate
   * @param cdRecRtnRetenType
   * @param dtRecRtnDstryActual
   * @param dtRecRtnDstryElig
   * @param txtRecRtnDstryDtRsn
   */
  public void insertRecordsRetention(int idCase, Date dtLastUpdate, String cdRecRtnRetenType, Date dtRecRtnDstryActual,
                                     Date dtRecRtnDstryElig, String txtRecRtnDstryDtRsn);

  /**
   * Updates RECORDS_RETENTION w/o a dtLastUpdate check.
   *
   * @param idCase
   * @param dtLastUpdate
   * @param cdRecRtnRetenType
   * @param dtRecRtnDstryActual
   * @param dtRecRtnDstryElig
   * @param txtRecRtnDstryDtRsn
   * @return The number of updates done.
   */
  public int updateRecordsRetention(int idCase, Date dtLastUpdate, String cdRecRtnRetenType, Date dtRecRtnDstryActual,
                                    Date dtRecRtnDstryElig, String txtRecRtnDstryDtRsn);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention} object.
   *
   * @param idCase
   * @param dtLastUpdate
   */
  public int deleteRecordsRetention(int idCase, Date dtLastUpdate);
}
