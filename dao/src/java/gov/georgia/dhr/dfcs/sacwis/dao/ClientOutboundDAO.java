package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ClientOutbound;

/*Change History:
Date        User      Description
----------  --------  --------------------------------------------------
                          
07/14/2011  arege  SMS #62831: ITSM 37804 Add new method to locate ClientOutbound data by idClient.
*/
public interface ClientOutboundDAO {
  public void sendClientOutbound(ClientOutbound clientOutbound);
  public void updateClientOutbound(ClientOutbound clientOutbound);
  public List<ClientOutbound> findClientOutboundByIdClient(int idClient);
}
