/**
 * Created on Apr 5, 2006 at 11:59:57 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

public interface DynamicEventDAO {
  /**
   * Dynamically builds Select statement and retrieves information about all events that satisfy the criteria.
   * <p/>
   * Not all parameters need to be populated.  Missing int values should be zero, and missing String, date, array values
   * should be null.
   * <p/>
   * The return value is list of Object arrays with the following values:
   * <pre>
   * String cdEventStats = szCdEventStatus = row[0];
   * String cdEventType = szCdEventType = row[1];
   * String s.cdStage = szCdStage = row[2];
   * Date dtEventOccurred = dtDtEventOccurred = row[3];
   * String cdStageReasonClosed = szCdStageReasonClosed = row[4]
   * int idCase ulIdCase = row[5];
   * int idEvent ulIdEvent = row[6];
   * int idStage ulIdStage = row[7];
   * String nmStage = szNmStage = row[8];
   * String nmPersonfull = szScrCaseWorker = row[9];
   * String txtEventDescr = szTxtEventDescr = row[10];
   * String cdTask = szCdTask = row[11];
   * String indCaseSensitive = bIndCaseSensitive = row[12];
   * </pre>
   *
   * @param extraTables     This should be true if the cReqFuncCd is set to ADD and false for UPDATE; other cReqFuncCds
   *                        should result in the calling service throwing an exception with ARC_ERR_BAD_FUNC_CD.
   * @param idCase
   * @param idStage
   * @param idPerson
   * @param idSituation
   * @param idEventPerson
   * @param cdEventTypes
   * @param cdStages
   * @param cdTask
   * @param dtScrDtStartDt
   * @param dtScrDtEventEnd
   * @param cdEventStatus
   * @return See description for the structure of the returned array.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  @SuppressWarnings({"unchecked"})
  List<Object[]> findEvents(boolean extraTables, int idCase, int idStage, int idPerson, int idSituation,
                            int idEventPerson, String[] cdEventTypes, String[] cdStages, String cdTask,
                            Date dtScrDtStartDt, Date dtScrDtEventEnd, String[] cdEventStatus) throws ServiceException;

  @SuppressWarnings({"unchecked"})
  PaginatedHibernateList<Object[]> findEvents(boolean extraTables, int idCase, int idStage, int idPerson,
                                              int idSituation,
                                              int idEventPerson, String[] cdEventTypes, String[] cdStages,
                                              String cdTask,
                                              Date dtScrDtStartDt, Date dtScrDtEventEnd, String[] cdEventStatus,
                                              int pageNbr, int pageSize)
          throws ServiceException;
}
