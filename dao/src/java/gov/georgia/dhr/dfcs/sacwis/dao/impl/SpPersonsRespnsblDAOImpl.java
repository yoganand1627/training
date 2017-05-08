package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.SpPersonsRespnsblDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SpPersonsRespnsbl;

public class SpPersonsRespnsblDAOImpl extends BaseDAOImpl implements SpPersonsRespnsblDAO {

  @SuppressWarnings("unchecked")
  public List<SpPersonsRespnsbl> findSpPersonsRespnsbl(int idSftyFctr) {
    Query query = getSession()
                              .createQuery(
                                           " from SpPersonsRespnsbl sr "
                                                           + "where sr.spSafetyFactorsByIdSftyFctr.idSftyFctr = :idSftyFctr");
    query.setInteger("idSftyFctr", idSftyFctr);
    return (List<SpPersonsRespnsbl>) query.list();
  }

  public int deleteSpPersonsRespnsbl(int idSftyFctr) {
    Query query = getSession()
                              .createQuery(
                                           "delete SpPersonsRespnsbl sr "
                                                           + "where sr.spSafetyFactorsByIdSftyFctr.idSftyFctr = :idSftyFctr");
    query.setInteger("idSftyFctr", idSftyFctr);
    return query.executeUpdate();
  }

  public void saveSpPersonsRespnsbl(SpPersonsRespnsbl spPersonsRespnsbl) {
    getSession().saveOrUpdate(spPersonsRespnsbl);
  }
}
