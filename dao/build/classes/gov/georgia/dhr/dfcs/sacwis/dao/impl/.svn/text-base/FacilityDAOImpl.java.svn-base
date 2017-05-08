package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Facility;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

public class FacilityDAOImpl extends BaseDAOImpl implements FacilityDAO {

  public Facility findFacilityByFacilityId(String facId) {
    Query query = getSession().createQuery("  from  Facility where facid =:facId");

    query.setString("facId", facId);
    return (Facility) firstResult(query);
  }
  
  public int updateFacilityResourceId(String facId, int resourceid) {
    Query query = getSession().createQuery("update Facility " 
                                                   + " set shinesRsrcId = :resourceid "
                                                   + " where facid =:facId ");
    query.setString("facId", facId);
    query.setParameter("resourceid", ((resourceid != 0) ? new Integer(resourceid) : null), Hibernate.INTEGER);
    return query.executeUpdate();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Facility> findFacilitiesByResourceId(int resourceid) {
    Query query = getSession().createQuery("  from  Facility where shinesRsrcId = :resourceid");

    query.setInteger("resourceid", resourceid);
    return (List<Facility>) query.list();
  }

}
