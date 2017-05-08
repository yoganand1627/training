/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.CwSummaryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.CwSummary;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class CwSummaryDAOImpl extends BaseDAOImpl implements CwSummaryDAO {
  
  @SuppressWarnings({"unchecked"})
  public CwSummary findCwSummaryByStageID(int idStage) {
    
    Query query = getSession().createQuery(" from  CwSummary c " +
                                           " where c.stage.idStage = :idStage ");
    
    query.setInteger("idStage", idStage);     
    return (CwSummary) firstResult(query);
  }
  
}
