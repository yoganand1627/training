package gov.georgia.dhr.dfcs.sacwis.dao.impl;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.dao.VisitationTypeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.VisitationType;


import org.hibernate.Query;
 
public class VisitationTypeDAOImpl extends BaseDAOImpl implements VisitationTypeDAO {
   
 
  
  public List<VisitationType> findVisitationTypeByEvent(int idEvent) {
	    Query query = getSession().createQuery(" from VisitationType vt " +
	                                           "where vt.event.idEvent = :idEvent");
	    query.setInteger("idEvent", idEvent);
	    return (List<VisitationType>) query.list();
	  }
 
  public void saveVisitationType(VisitationType visitationType) {
	  getSession().save(visitationType);
	 }
  public int deleteVisitation(int idEvent) {
    Query query = getSession().createQuery(" delete from VisitationType vt " +
                                                 " where vt.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

}
	
	



 