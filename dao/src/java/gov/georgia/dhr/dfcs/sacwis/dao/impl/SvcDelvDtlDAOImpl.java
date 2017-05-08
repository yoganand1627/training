package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.SvcDelvDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SvcDelvDtl;
import org.hibernate.Query;

public class SvcDelvDtlDAOImpl extends BaseDAOImpl implements SvcDelvDtlDAO {
  public Map findSvcDelvDtlByIdStage(int idStage) {
    Query query = getSession().createQuery("select new map( a.dtSvcDelvDecision as dtSvcDelvDecision," +
                                           "        a.dtLastUpdate as dtLastUpdate," +
                                           "        b.indEcs as indEcs," +
                                           "        b.cdClientAdvised as cdClientAdvised," +
                                           "        b.indEcsVer  as indEcsVer) " +
                                           "   from SvcDelvDtl a," +
                                           "        Stage b" +
                                           "  where a.idStage = :idStage" +
                                           "    and a.idStage = b.idStage"
    );
    query.setInteger("idStage", idStage);
    return (Map) firstResult(query);

  }

  public void saveSvcDelvDtl(SvcDelvDtl svcDelvDtl) {
    getSession().saveOrUpdate(svcDelvDtl);
  }
}
