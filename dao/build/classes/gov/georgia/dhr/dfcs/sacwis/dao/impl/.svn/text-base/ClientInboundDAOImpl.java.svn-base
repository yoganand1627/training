package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ClientInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ClientInbound;

public class ClientInboundDAOImpl extends BaseDAOImpl implements ClientInboundDAO{  

    public int saveClientInboundInfo(ClientInbound clientInbound) {
      getSession().saveOrUpdate(clientInbound);
      return clientInbound.getIdClientInbound();    
    }  
    
}



