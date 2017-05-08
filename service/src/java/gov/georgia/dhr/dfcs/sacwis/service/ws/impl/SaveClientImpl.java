package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ClientInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ClientInbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveClient;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ClientSO;


public class SaveClientImpl  extends BaseServiceImpl implements SaveClient {
  PersonDAO personDAO = null;
  ClientInboundDAO clientInboundDAO = null;
  
  public static final String ACCEPTED = "CREATED";
  public static final String REJECTED = "REJECTED";
  public static final String UPDATED = "UPDATED";
  public static final String MERGED = "MERGED";
  public static final String SPLIT = "SPLIT";
  /**
   * @param personDAO the personDAO to set
   */
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  public void setClientInboundDAO(ClientInboundDAO clientInboundDAO) {
    this.clientInboundDAO = clientInboundDAO;
  }
  
  
  public ClientSO saveClient(ClientSI clientSI){
    String cdReturnStatus = clientSI.getCdReturnStatus();
    int idPerson = clientSI.getIdPerson();
    cdReturnStatus = (cdReturnStatus != null)? cdReturnStatus.trim() : "ERR";
    if(ACCEPTED.equalsIgnoreCase(cdReturnStatus) || "REG".equalsIgnoreCase(cdReturnStatus)
                    || MERGED.equalsIgnoreCase(cdReturnStatus)  || SPLIT.equalsIgnoreCase(cdReturnStatus)){
    	cdReturnStatus = "REG";
    }
    else if(UPDATED.equalsIgnoreCase(cdReturnStatus) || "UPD".equalsIgnoreCase(cdReturnStatus)){
        cdReturnStatus = "REG";
    }    
    else {
    	cdReturnStatus = "ERR";
    }
    
      
    
    int numOfRowsUpdated = personDAO.updatePersonByCdSmileClient(cdReturnStatus, idPerson);
    
    ClientInbound clientInbound = new ClientInbound();
    
    clientInbound.setIdClientOutbound( clientSI.getIdTrans() != 0 ? clientSI.getIdTrans() : 0);
    clientInbound.setIdPerson( clientSI.getIdPerson() != 0 ? clientSI.getIdPerson() : 0);
    clientInbound.setNbrCrsId( clientSI.getNbrCRSId() != 0 ? clientSI.getNbrCRSId() : 0);
    clientInbound.setNbrPersonIdNumber( clientSI.getNbrPersonId() != null ? clientSI.getNbrPersonId() : "");
    clientInbound.setNmPersonFirst(clientSI.getNmPersonFirst()!= null ? clientSI.getNmPersonFirst() : "");
    clientInbound.setNmPersonLast(clientSI.getNmPersonLast() != null ? clientSI.getNmPersonLast() : "" );
    clientInbound.setNmPersonMiddle(clientSI.getNmPersonMiddle() != null ? clientSI.getNmPersonMiddle() : "");
    clientInbound.setCdClientSmileupdSt(clientSI.getCdReturnStatus() != null ? clientSI.getCdReturnStatus() : "");
    clientInboundDAO.saveClientInboundInfo(clientInbound);     
    
    ClientSO clientSO = new ClientSO();
    clientSO.setNumOfRowsReturned(numOfRowsUpdated);
    return clientSO;
  }
  

  

}
