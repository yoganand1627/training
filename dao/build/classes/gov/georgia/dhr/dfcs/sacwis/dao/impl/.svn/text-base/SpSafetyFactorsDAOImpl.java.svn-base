package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.SpSafetyFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors;

public class SpSafetyFactorsDAOImpl extends BaseDAOImpl implements SpSafetyFactorsDAO {

  public void saveSafetyFactor(SpSafetyFactors SpSafetyFactors) {
    getSession().saveOrUpdate(SpSafetyFactors);
  }

  @SuppressWarnings("unchecked")
  public List<SpSafetyFactors> findSpSafetyFactors(int idEvent) {
    Query query = getSession()
                              .createQuery(
                                           " from SpSafetyFactors sf where sf.event.idEvent = :idEvent order by idSftyFctr");
    query.setInteger("idEvent", idEvent);
    return (List<SpSafetyFactors>) query.list();
  }

  public int deleteSafetyFactor(int idSftyFctr) {
    Query query = getSession().createQuery("delete SpSafetyFactors sf  where  sf.idSftyFctr = :idSftyFctr");
    query.setInteger("idSftyFctr", idSftyFctr);
    return query.executeUpdate();
  }

}
