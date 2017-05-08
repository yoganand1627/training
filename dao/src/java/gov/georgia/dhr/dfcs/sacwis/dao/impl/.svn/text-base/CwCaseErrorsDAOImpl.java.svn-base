/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.CwCaseErrorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.CwCaseErrors;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class CwCaseErrorsDAOImpl extends BaseDAOImpl implements CwCaseErrorsDAO {
  
  @SuppressWarnings({"unchecked"})
  public List<CwCaseErrors> findCwCaseErrorsByStageID(int idStage) {
    
    Query query = getSession().createQuery(" from  CwCaseErrors c " +
                                           " where c.stage.idStage = :idStage " +
                                           " and c.dtAdded <= sysdate " +
                                           " and c.dtCleared is null" +
                                           " order by c.cdError desc");
    
    query.setInteger("idStage", idStage);
    
      
    return (List<CwCaseErrors>) query.list();
  }
  
}
