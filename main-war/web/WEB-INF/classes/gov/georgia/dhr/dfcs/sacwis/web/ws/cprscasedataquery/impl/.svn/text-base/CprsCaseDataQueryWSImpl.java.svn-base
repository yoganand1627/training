package gov.georgia.dhr.dfcs.sacwis.web.ws.cprscasedataquery.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ws.cprsquerycaseidlist.CprsQueryCaseListWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscase.CprsQueryWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.cprscasedataquery.CprsCaseDataQueryWS;

public class CprsCaseDataQueryWSImpl implements CprsCaseDataQueryWS {

  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }

  public CprsQueryWO retrieveCPRSCases(CprsQueryCaseListWI cprsQueryCaseListWI) {
    CprsQueryWO wo = ws.retrieveCPRSCases(cprsQueryCaseListWI);
    return wo;
  }
}
