/**
 * Created on June 22, 2009  by Bhavna Gehlot
 */

package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SrChildrenConsideredPlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SrChildConsiderPlcmnt;
import java.util.List;

import org.hibernate.Query;

public class SrChildrenConsideredPlacementDAOImpl extends BaseDAOImpl implements SrChildrenConsideredPlacementDAO {

  @SuppressWarnings( { "unchecked" })
  public  List<Integer> findSrChildrenConsideredByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select s.idPerson  " +
    		                               " from SrChildConsiderPlcmnt s " +
                                           " where s.safetyResource.event.idEvent = :idEvent"); 
    query.setInteger("idEvent", idEvent);
    return  (List<Integer>) query.list();
  }

  public void saveOrUpdateSrChildrenConsidered(SrChildConsiderPlcmnt srChildConsiderPlcmnt){
    getSession().saveOrUpdate(srChildConsiderPlcmnt);
  }
  
  public int deleteSrChildrenConsiderByPersonAndEvent(int idPerson, int idEvent) {
    Query query = getSession().createQuery("delete from SrChildConsiderPlcmnt s" +
                                           "       where s.idPerson = :idPerson" +
                                           "       and s.safetyResource.idEvent = :idEvent");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
  
  public int deleteSrChildrenConsiderByEvent(int idEvent) {
    Query query = getSession().createQuery("delete from SrChildConsiderPlcmnt s" +
                                           "       where s.safetyResource.idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
}
