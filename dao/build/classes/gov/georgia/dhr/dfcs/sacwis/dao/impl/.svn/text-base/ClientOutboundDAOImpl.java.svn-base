package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.ClientOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ClientOutbound;

/*Change History:
Date        User      Description
----------  --------  --------------------------------------------------
                          
09/14/2011  arege      SMS #62831: ITSM 37804 Add new method to locate ClientOutbound data by idClient.

*/

public class ClientOutboundDAOImpl extends BaseDAOImpl implements ClientOutboundDAO {

  public void sendClientOutbound(ClientOutbound clientOutbound) {
    // Save ClientOutbound
    getSession().saveOrUpdate(clientOutbound);
  }

  public void updateClientOutbound(ClientOutbound clientOutbound) {
    getSession().saveOrUpdate(clientOutbound);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<ClientOutbound> findClientOutboundByIdClient(int idClient) {
    String hqlQuery = " from ClientOutbound " +
    		      " where idClient = :idClient";
    Query query = getSession().createQuery(hqlQuery);
    query.setInteger("idClient", idClient);
    
    return (List<ClientOutbound>) query.list();
  }
}
