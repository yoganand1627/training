/**
 * Created on April 6, 2007 at by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimitWaiver;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitWaiverDAO;
import org.hibernate.Query;

/** @author vishala devarakonda */

public class CaseBudgetLimitWaiverDAOImpl extends BaseDAOImpl implements CaseBudgetLimitWaiverDAO {
  
public CaseBudgetLimitWaiver findPolicyWaiverEntry(int idWaiver){
    Query query = getSession()
    .createQuery(
                 " from CaseBudgetLimitWaiver a where idWaiver = :idWaiver");
    
    query.setInteger("idWaiver", idWaiver);
    return (CaseBudgetLimitWaiver) query.uniqueResult();
  }

  
  public void saveCaseBudgetLimitWaiver(CaseBudgetLimitWaiver bLmtWaiver) {
    getSession().saveOrUpdate(bLmtWaiver);
  }

}