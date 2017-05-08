/**
 * Created on Mar 25, 2006 at 3:23:27 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.ReportList;

/**
 * This interface provides the method definitions for accessing the Report List 
 * 
 * <pre>
 *    Change History:
 *    Date      User        Description
 *    --------  ----------  --------------------------------------------------
 *    03/25/06  mkwerle     Created
 *    12/01/08  alwilliams  STGAP00009474 - Added pagination support to methods
 *                              a. findReportListNonMisByIdPerson  
 *                              b. findReportListAllByIdPerson                                
 *                        
 * </pre>
 */
public interface ReportListDAO {
  /**
   * This selects txtRptLstParmlist from ReportList given idRptList.
   *
   * @param idRptList
   * @return Gets txtRptLstParmlist out of ReportList by idRptList.
   */
  String findReportList(int idRptList);

  /**
   * Returns a list of non MIS reports for specified idPerson
   *
   * @param idPerson
   * @param pageNbr
   * @param pageSize
   * @return PaginatedHibernateList<ReportList>
   */
  PaginatedHibernateList<ReportList> findReportListNonMisByIdPerson(int idPerson, int pageNbr, int pageSize);

  /**
   * Returns a list of all reports for specified idPerson
   *
   * @param idPerson
   * @param pageNbr
   * @param pageSize
   * @return PaginatedHibernateList<ReportList>
   */
  PaginatedHibernateList<ReportList> findReportListAllByIdPerson(int idPerson, int pageNbr, int pageSize);
  
  PaginatedHibernateList<ReportList> findReportListByIdPersonReportName(int idPerson, Collection addlReports, int pageNbr, int pageSize);

  /**
   * Updates table ReportList fields txtRptLstStatus and txtRptGenName given idRptList
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param txtRptLstStatus
   * @param txtRptGenName
   * @param idRptList
   */
  int updateReportListStatus(String txtRptLstStatus, String txtRptGenName,
                             int idRptList);

  /**
   * Deletes a row from REPORT_LIST w/o checking the DT_LAST_UPDATE column.
   *
   * @param idRptList
   */
  int deleteReportList(int idRptList);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ReportList} object to the database.
   *
   * @param reportList A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ReportList} object.
   */
  void saveReportList(ReportList reportList);
}
