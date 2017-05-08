package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.YouthReportDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.YouthReportDtl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

public class YouthReportDtlDAOImpl extends BaseDAOImpl implements YouthReportDtlDAO {

  public YouthReportDtl findYouthReportDtlById(int idYouthReportDtl) {
    Query query = getSession().createQuery(" from YouthReportDtl y " +
                                           "where y.idYouthReportDtl = :idYouthReportDtl");
    query.setInteger("idYouthReportDtl", idYouthReportDtl);
    return (YouthReportDtl) query.uniqueResult();
  }

  public YouthReportDtl findYouthReportDtl(int idPerson, Date dtRptPeriodEnd) {
    Query query = getSession().createQuery("    from YouthReportDtl y " +
                                           "   where y.person.idPerson = :idPerson " +
                                           "     and y.dtRptPeriodEnd = :dtRptPeriodEnd " +
                                           "order by y.idYouthReportDtl desc");
    query.setInteger("idPerson", idPerson);
    query.setDate("dtRptPeriodEnd", dtRptPeriodEnd);
    return (YouthReportDtl) firstResult(query);
  }

  @SuppressWarnings("unchecked")
  public List<YouthReportDtl> findAllYouthReportDtl(int idPerson) {
    Query query = getSession().createQuery("    from YouthReportDtl y " +
                                           "   where y.person.idPerson = :idPerson " +
                                           "order by y.dtRptPeriodEnd desc, " +
                                           "         y.idYouthReportDtl desc");
    query.setInteger("idPerson", idPerson);
    return (List<YouthReportDtl>) query.list();
  }

  public void saveYouthReportDtl(YouthReportDtl youthReportDtl) {
    getSession().saveOrUpdate(youthReportDtl);
  }
}
