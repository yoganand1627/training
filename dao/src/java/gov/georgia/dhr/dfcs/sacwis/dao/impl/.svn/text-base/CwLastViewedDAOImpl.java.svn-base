/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.CwLastViewedDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.CwLastViewed;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Patrick Coogan
 *
 */
public class CwLastViewedDAOImpl extends BaseDAOImpl implements CwLastViewedDAO {
  
  @SuppressWarnings({"unchecked"})
  public CwLastViewed findLastViewedByIdStaff(int idStaff, int idStage) {

    Query query = getSession().createQuery(" from  CwLastViewed c " + 
                                           " where c.person.idPerson = :idStaff " +
                                           " and c.stage.idStage = :idStage " +
                                           " order by c.dtLastView desc");

    query.setInteger("idStaff", idStaff);
    query.setInteger("idStage", idStage);
    return (CwLastViewed) firstResult(query);

  }
  
  public void saveCwLastViewed(CwLastViewed cwLastViewed){
    getSession().saveOrUpdate(cwLastViewed);
  }
  
}
