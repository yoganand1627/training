package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportListDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ReportList;

import java.util.Collection;

import org.hibernate.Query;

/**
 * This class provides the implementation of the methods defined in the Report List interface 
 * 
 * <pre>
 *    Change History:
 *    Date      User        Description
 *    --------  ----------  --------------------------------------------------
 *    03/25/06  mkwerle     Created
 *    12/01/08  alwilliams  STGAP00009474 - Added pagination support to methods
 *                              a. findReportListNonMisByIdPerson  
 *                              b. findReportListAllByIdPerson                                
 *     04/08/2010 vvo       SMS49899: add method 'findReportListByIdPersonReportName'
 *                          to add completed batch report(common to a group/everybody) to everyone's pickup list                    
 * </pre>
 */

public class ReportListDAOImpl extends BaseDAOImpl implements ReportListDAO {
  public String findReportList(int idRptList) {
    Query query = getSession().createQuery("select r.txtRptLstParmlist " +
                                           "  from ReportList r " +
                                           " where r.idRptList = :idRptList ");
    query.setInteger("idRptList", idRptList);
    return (String) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<ReportList> findReportListNonMisByIdPerson(int idPerson, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("      from ReportList l " +
                                           "join fetch l.reports r " +
                                           "     where r.nmRptType <> 'M' " +
                                           "       and l. person.idPerson = :idPerson " +
                                           "       and (l.nbrRptLstCfpStamp = 0 or l.nbrRptLstCfpStamp is null) " +
                                           "  order by r.nmRptType, " +
                                           "           l.dtRptLstGeneration desc");
    query.setInteger("idPerson", idPerson);
    return (PaginatedHibernateList) paginatedList (pageNbr, pageSize, query);
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<ReportList> findReportListAllByIdPerson(int idPerson, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("      from ReportList l " +
                                           "join fetch l.reports r " +
                                           "     where l.person.idPerson = :idPerson " +
                                           "       and (l.nbrRptLstCfpStamp = 0 or l.nbrRptLstCfpStamp is null) " +
                                           "  order by l.dtRptLstGeneration desc");
    query.setInteger("idPerson", idPerson);
    return (PaginatedHibernateList<ReportList>) paginatedList (pageNbr, pageSize, query);
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<ReportList> findReportListByIdPersonReportName(int idPerson, Collection commonReports, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("      from ReportList l " +
                                           "join fetch l.reports r " +
                                           "     where (l.person.idPerson = :idPerson " +
                                           " or (r.id.nmRptSqrName in (:commonReports) and l.txtRptLstStatus = :DONE) ) " +
                                           "       and (l.nbrRptLstCfpStamp = 0 or l.nbrRptLstCfpStamp is null) " +
                                           "  order by l.dtRptLstGeneration desc");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("commonReports", commonReports);
    query.setString("DONE", "Done");
    return (PaginatedHibernateList<ReportList>) paginatedList (pageNbr, pageSize, query);
  }

  public int updateReportListStatus(String txtRptLstStatus, String txtRptGenName,
                                                                     int idRptList) {
    Query query = getSession().createQuery(" update ReportList r " +
                                           "    set r.txtRptLstStatus = :txtRptLstStatus, " +
                                           "        r.txtRptGenName = :txtRptGenName " +
                                           "  where r.idRptList = :idRptList");
    query.setString("txtRptLstStatus", txtRptLstStatus);
    query.setString("txtRptGenName", txtRptGenName);
    query.setInteger("idRptList", idRptList);
    return query.executeUpdate();
  }

  public int deleteReportList(int idRptList) {
    Query query = getSession().createQuery("delete ReportList r" +
                                           " where r.idRptList = :idRptList");
    query.setInteger("idRptList", idRptList);
    return query.executeUpdate();
  }

  public void saveReportList(ReportList reportList) {
    getSession().saveOrUpdate(reportList);
  }
}
