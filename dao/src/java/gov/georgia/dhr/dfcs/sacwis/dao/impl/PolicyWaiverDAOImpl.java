package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.PolicyWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;
import org.hibernate.Query;

public class PolicyWaiverDAOImpl extends BaseDAOImpl implements PolicyWaiverDAO {
  public PolicyWaiver findPolicyWaiverByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from  PolicyWaiver p " +
                                           " where p.idWvrEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (PolicyWaiver) firstResult(query);
  }

  public void savePolicyWaiver(PolicyWaiver policyWaiver) {
    getSession().saveOrUpdate(policyWaiver);
  }

  public int deletePolicyWaiverByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from PolicyWaiver" +
                                           "       where event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
}
