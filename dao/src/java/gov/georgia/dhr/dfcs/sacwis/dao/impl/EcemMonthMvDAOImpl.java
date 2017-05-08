/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.EcemMonthMvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.EcemMonthMv;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class EcemMonthMvDAOImpl extends BaseDAOImpl implements EcemMonthMvDAO {
  
  public EcemMonthMv findEcemMonthByPersonByCaseByDate(int idPerson, int idCase, Date ecemMonth) {
    
    Query query = getSession().createQuery(" from  EcemMonthMv e " +
                                           " where e.id.idPerson = :idPerson " +
                                           " and e.id.idCase = :idCase " +
                                           " and e.id.ecemMonth = :ecemMonth ");
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setDate("ecemMonth", ecemMonth);
      
    return (EcemMonthMv) firstResult(query);
  }
  
}
