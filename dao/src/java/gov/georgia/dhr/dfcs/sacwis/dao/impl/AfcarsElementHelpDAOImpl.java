/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsElementHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.AfcarsElementHelp;
import java.util.List;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class AfcarsElementHelpDAOImpl extends BaseDAOImpl implements AfcarsElementHelpDAO {
  
  
  @SuppressWarnings( { "unchecked" })
  public List<AfcarsElementHelp> findAfcarsElements() {  
    Query query = getSession().createQuery(" from  AfcarsElementHelp a order by nbrAfcarsOrder asc");
    
    return (List<AfcarsElementHelp>) query.list();
  }
  
}
