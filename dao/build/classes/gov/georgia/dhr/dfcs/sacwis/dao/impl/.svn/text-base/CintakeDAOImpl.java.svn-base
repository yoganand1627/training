package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.CintakeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CIntake;

import java.util.List;

import org.hibernate.Query;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 01/30/2009   mxpatel           STGAP00010438 added a method to return PaginatedHibernateList
 *                                in order to implement pagination.
 */

public class CintakeDAOImpl extends BaseDAOImpl implements CintakeDAO {

  @SuppressWarnings({"unchecked"})
  public CIntake findORSComplaintsByEventId(String complId) {
    Query query = getSession().createQuery("  from CIntake where intakeid =:complId");

    query.setString("complId", complId);
    return (CIntake) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<CIntake> findORSComplaintsByFacilityId(String facId) {
    Query query = getSession().createQuery("  from CIntake where facid =:facId");
    
    query.setString("facId", facId);
    return (List<CIntake>) query.list();
  }
  
  //mxpatel added this method for defect #10438
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<CIntake> findORSComplaintsByFacilityId(String facId, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("  from CIntake where facid =:facId");
    query.setString("facId", facId);
    return (PaginatedHibernateList<CIntake>) this.paginatedList(pageNbr, pageSize, query);
  }
  
}
