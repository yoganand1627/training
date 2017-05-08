/**
 * Created on Apr 12, 2006 at 10:20:03 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexRecordsRetentionDAO {
  /**
   * This is not a typical save method.  It is called save because it does both insert and update, but it does these
   * directly, not through the Hibernate saveOrUpdate() method both because it needs to return the count of all
   * operations and because the udpate is done without a dtLastUpdate check.
   *
   * @param attemptAdd
   * @param idCase
   * @param dtLastUpdate
   * @param cdRecRtnRetenType
   * @param dtRecRtnDstryActual
   * @param dtRecRtnDstryElig
   * @param txtRecRtnDstryDtRsn
   * @return The number of inserts or updates done.
   */
  int saveRecordsRetention(boolean attemptAdd, int idCase, Date dtLastUpdate, String cdRecRtnRetenType,
                           Date dtRecRtnDstryActual, Date dtRecRtnDstryElig, String txtRecRtnDstryDtRsn);
}
