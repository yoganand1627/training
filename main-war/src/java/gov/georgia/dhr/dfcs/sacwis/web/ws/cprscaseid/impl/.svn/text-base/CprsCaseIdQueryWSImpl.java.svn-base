package gov.georgia.dhr.dfcs.sacwis.web.ws.cprscaseid.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ws.cprsidquery.CprsCaseListQueryWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscaseidlist.CprsQueryCaseListWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.cprscaseid.CprsCaseIdQueryWS;

public class CprsCaseIdQueryWSImpl implements CprsCaseIdQueryWS {
  
  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }

  public CprsQueryCaseListWO retrieveCPRSCaseList(CprsCaseListQueryWI cprsQueryWI) {
    CprsQueryCaseListWO wo = ws.retrieveCPRSCaseList(cprsQueryWI);
    return wo;
  }
}
