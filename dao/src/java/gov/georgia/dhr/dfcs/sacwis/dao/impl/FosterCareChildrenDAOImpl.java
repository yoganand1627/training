/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareChildrenDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareChildren;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class FosterCareChildrenDAOImpl extends BaseDAOImpl implements FosterCareChildrenDAO {
  
    public FosterCareChildren findFosterCareChildByPersonAndCaseId(int idPerson, int idCase) {
    
    Query query = getSession().createQuery(" from  FosterCareChildren f " +
                                           " where f.pcPersonId = :idPerson " +
                                           " and f.idCase = :idCase ");
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
      
    return (FosterCareChildren) firstResult(query);
  }
    @SuppressWarnings({"unchecked"})
    public List<Map> findFosterIncidentsByChildThruDate(int idPerson, Date dtStart) {

      Query query = getSession().createQuery(" select new map (" +
      		                             " f.custodyRemovalDate as removalDate, " +
      		                             " f.dischargeDate as dischargeDate) " +
      		                             " from  FosterCareChildren f " +
                                             " where f.pcPersonId = :idPerson " +
                                             " and ((f.dischargeDate is null) or" +
                                             " (f.dischargeDate >= :dtStart))" +
                                             " order by dischargeDate asc");
      
      query.setInteger("idPerson", idPerson);
      query.setDate("dtStart", dtStart);
      
      return (List<Map>) query.list();  
  }

}
