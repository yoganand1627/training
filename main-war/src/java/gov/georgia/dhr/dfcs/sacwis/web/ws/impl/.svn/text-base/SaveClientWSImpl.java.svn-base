package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ClientWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.SaveClientWS;

public class SaveClientWSImpl implements SaveClientWS {
  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }
  
  public ClientWO saveClient(ClientWI clientWI) {
    return ws.saveClient(clientWI);
  }
}
