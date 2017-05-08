/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.NcandsElementHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.NcandsElementHelp;
import java.util.List;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class NcandsElementHelpDAOImpl extends BaseDAOImpl implements NcandsElementHelpDAO {
  
  
  @SuppressWarnings( { "unchecked" })
  public List<NcandsElementHelp> findNcandsElements() {  
    Query query = getSession().createQuery(" from  NcandsElementHelp a order by nbrNcandsOrder asc");
    
    return (List<NcandsElementHelp>) query.list();
  }
  
}
