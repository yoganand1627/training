/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CwCaseWarningsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.CwCaseWarnings;

import java.util.List;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class CwCaseWarningsDAOImpl extends BaseDAOImpl implements CwCaseWarningsDAO {
  
  @SuppressWarnings({"unchecked"})
  public List<CwCaseWarnings> findCwCaseWarningsByStageID(int idStage) {
    
    Query query = getSession().createQuery(" from  CwCaseWarnings c " +
                                           " where c.stage.idStage = :idStage " +
                                           " order by c.cdWarning desc");
    
    query.setInteger("idStage", idStage);
    
    return (List<CwCaseWarnings>) query.list();
  }
  
}
