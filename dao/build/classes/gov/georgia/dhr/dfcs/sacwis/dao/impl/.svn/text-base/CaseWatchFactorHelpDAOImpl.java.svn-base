/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CaseWatchFactorHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.CaseWatchFactorHelp;

import java.util.List;
import java.util.Map;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * @author Patrick Coogan
 *
 */
public class CaseWatchFactorHelpDAOImpl extends BaseDAOImpl implements CaseWatchFactorHelpDAO {
  
  @SuppressWarnings({"unchecked"})
  public List<CaseWatchFactorHelp> findHelpText() {
    
    Query query = getSession().createQuery(" from  CaseWatchFactorHelp ");
                                           
    
    return (List<CaseWatchFactorHelp>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public Object[] findDateDifferences(String dtStart, String dtEnd){
    
    SQLQuery query = getSession()
    .createSQLQuery(" select round((TO_DATE(:dtEnd,'MM/DD/YYYY HH:MI AM')-TO_DATE(:dtStart,'MM/DD/YYYY HH:MI AM')),4) as actual, BUSINESS_DAYS_DIFF(TO_DATE(:dtStart,'MM/DD/YYYY HH:MI AM'),TO_DATE(:dtEnd,'MM/DD/YYYY HH:MI AM')) as business "
                                           +" from dual ");
    
    query.setString("dtEnd",dtEnd);
    query.setString("dtStart",dtStart);
    query.addScalar("actual", Hibernate.FLOAT);
    query.addScalar("business", Hibernate.INTEGER);
    return (Object[]) firstResult(query);  
  }
  
  
}
