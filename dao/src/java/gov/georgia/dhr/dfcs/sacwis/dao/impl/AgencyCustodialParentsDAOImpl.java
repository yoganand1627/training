/**
 * Created on May 4, 2007 at 2:21:42 PM by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AgencyCustodialParentsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AgencyCustodialParents;
import org.hibernate.Query;

public class AgencyCustodialParentsDAOImpl extends BaseDAOImpl implements AgencyCustodialParentsDAO {

  public String findCountyByCountyCrsId(int countyCrsId) {
    Query query = getSession().createQuery("select cdCounty from AgencyCustodialParents acp "
                                                 + "where acp.nbrCrsId = :countyCrsId");
    
    query.setInteger("countyCrsId", countyCrsId);
    return (String) firstResult(query);
  }
  
  public String findCountyByCountyCrsIdPadded(int countyCrsId, int countyCrsIdPadded) {
    Query query = getSession().createQuery("select cdCounty from AgencyCustodialParents acp "
                                                 + "where acp.nbrCrsId = :countyCrsId "
                                                 + "   or acp.nbrCrsId = :countyCrsIdPadded");
    
    query.setInteger("countyCrsId", countyCrsId);
    query.setInteger("countyCrsIdPadded", countyCrsIdPadded);
    return (String) firstResult(query);
  }
  
  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.dao.AgencyCustodialParentsDAO#saveAgencyCustodialParents(gov.georgia.dhr.dfcs.sacwis.db.AgencyCustodialParents)
   */
  public int saveAgencyCustodialParents(AgencyCustodialParents agencyCustodialParents) {
    getSession().saveOrUpdate(agencyCustodialParents);
    return agencyCustodialParents.getIdAgencyCustodialParents();
  }

  public AgencyCustodialParents findAgencyCustodialParentById(Integer idAcp) {
    Query query = getSession().createQuery("from AgencyCustodialParents acp "
                                                 + "where acp.idAgencyCustodialParents = :idAcp");
    
    query.setInteger("idAcp", idAcp);
    return (AgencyCustodialParents) firstResult(query);
  }

}
