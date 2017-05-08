package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.RestrictedFundsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RestrictedFunds;

import org.hibernate.Query;

public class RestrictedFundsDAOImpl extends BaseDAOImpl implements RestrictedFundsDAO {
  public RestrictedFunds findByIdPerson(int idPerson){
    Query query = getSession().createQuery("from RestrictedFunds r where r.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (RestrictedFunds) query.uniqueResult();
  }
  
  public RestrictedFunds findByIdEvent(int idEvent){
    Query query = getSession().createQuery("from RestrictedFunds r " +
                                           "join fetch r.event e " +
                                           "where e.idEvent = :idEvent " +
                                           "order by r.dtLastUpdate desc");
    query.setInteger("idEvent", idEvent);
    return (RestrictedFunds) firstResult(query);
  }
  
  public void save(RestrictedFunds rf){
    getSession().saveOrUpdate(rf);
  }
  
  public int updateRestrictedFundsByIdPerson(double amtCheckBal, double amtSavBal, int idPerson ) {
    Query query = getSession().createQuery("update RestrictedFunds rf" +
                                           "   set rf.amtCheckBal = :amtCheckBal, " +
                                           "   rf.amtSavBal = :amtSavBal "+
                                           " where rf.idPerson = :idPerson");
    query.setDouble("amtCheckBal", amtCheckBal);
    query.setDouble("amtSavBal", amtSavBal);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }
  
  
  
}
