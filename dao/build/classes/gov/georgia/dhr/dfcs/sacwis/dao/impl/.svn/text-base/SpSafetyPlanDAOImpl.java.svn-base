package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.SpSafetyPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyPlan;

public class SpSafetyPlanDAOImpl extends BaseDAOImpl implements SpSafetyPlanDAO {

  public void  saveSpSafetyPlan(SpSafetyPlan spSafetyPlan) {
    getSession().saveOrUpdate(spSafetyPlan);
  }

  public SpSafetyPlan findSpSafetyPlan(int idEvent) {
    Query query = getSession().createQuery(" from SpSafetyPlan sp " + "where sp.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (SpSafetyPlan) firstResult(query);
  }
  
  public void deleteSpSafetyPlan(SpSafetyPlan spSafetyPlan) {
    getSession().delete(spSafetyPlan);
  }
  
  public int deleteSpSafetyPlan(int idEvent, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "delete SpSafetyPlan " + " where idEvent = :idEvent "
                                                           + "   and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();

  }

}
