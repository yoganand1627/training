package gov.georgia.dhr.dfcs.sacwis.web.ws.cprsquery.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ws.cprsquery.CprsQueryWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscase.CprsQueryWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.cprsquery.CprsQueryWS;

public class CprsQueryWSImpl implements CprsQueryWS {
  
  private WS ws;
  
  public void setWS(WS ws) {
    this.ws = ws;
  }

  public CprsQueryWO performCPRSQuery(CprsQueryWI cprsQueryWI) {
    CprsQueryWO wo = ws.performCPRSQuery(cprsQueryWI);
    return wo;
  }
}
