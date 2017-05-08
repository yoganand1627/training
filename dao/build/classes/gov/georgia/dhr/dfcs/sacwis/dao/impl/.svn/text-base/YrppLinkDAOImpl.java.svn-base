package gov.georgia.dhr.dfcs.sacwis.dao.impl;

/*Change History:
 * Date        User              Description
 * --------    ----------------  --------------------------------------------------
 * 08/20/10    hnguyen           MR-067: DAO implementation creation
 * 09/15/10    hjbaptiste        MR-070: Changed nytdBaselineYear to reportingYear
 *
 */
import gov.georgia.dhr.dfcs.sacwis.dao.YrppLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.YrppLink;

import java.util.List;

import org.hibernate.Query;

public class YrppLinkDAOImpl extends BaseDAOImpl implements YrppLinkDAO {

  public YrppLink findYrppLinkByIdYrppLink(int idYrppLink) {
    Query query = getSession().createQuery(" from  YrppLink yl " + " where yl.idYrppLink = :idYrppLink ");
    query.setInteger("idYrppLink", idYrppLink);
    return (YrppLink) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<YrppLink> findYrppLinkByIdUser(int idUser) {
    Query query = getSession().createQuery(" from  YrppLink yl " + " where yl.portalUser.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    return (List<YrppLink>) query.list();
  }

  public YrppLink findYrppLinkByIdYouthReportDtl(int idYouthReportDtl) {
    Query query = getSession().createQuery(" from  YrppLink yl " + " where yl.youthReportDtl.idYouthReportDtl = :idYRD ");
    query.setInteger("idYRD", idYouthReportDtl);
    return (YrppLink) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<YrppLink> findYrppLinkByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from  YrppLink yl " + " where yl.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (List<YrppLink>) query.list();
  }

  public YrppLink findYrppLinkWithPortalUserAccount(int idPerson, int reportingYear, String indNytdGreetEmailSent) {
    Query query = getSession().createQuery(" from  YrppLink yl " + " where yl.person.idPerson = :idPerson " +
                                           " and yl.portalUser.idUser is not null" +
                                           " and yl.indNytdGreetEmailSent = :indNytdGreetEmailSent" +
                                           " and yl.reportingYear = :reportingYear ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("reportingYear", reportingYear);
    query.setString("indNytdGreetEmailSent", indNytdGreetEmailSent);
    return (YrppLink) query.uniqueResult();
  }

  public int updateYrppLinkIndNytdGreetEmailSent(int idYrppLink, String indNytdGreetEmailSent) {
    Query query = getSession().createQuery("update YrppLink " +
                                           "    set indNytdGreetEmailSent = :indNytdGreetEmailSent " +
                                           "  where idYrppLink = :idYrppLink");

    query.setInteger("idYrppLink", idYrppLink);
    query.setString("indNytdGreetEmailSent", indNytdGreetEmailSent);
    return query.executeUpdate();
  }

  public int updateYrppLinkIndNytdSurveyComplete(int idYrppLink, String indNytdSurveyComplete) {
    Query query = getSession().createQuery("update YrppLink " +
                                           "    set indNytdSurveyComplete = :indNytdSurveyComplete " +
                                           "  where idYrppLink = :idYrppLink");

    query.setInteger("idYrppLink", idYrppLink);
    query.setString("indNytdSurveyComplete", indNytdSurveyComplete);
    return query.executeUpdate();
  }

  public void saveYrppLink(YrppLink yrppLink) {
    getSession().saveOrUpdate(yrppLink);
  }

}
