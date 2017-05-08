package gov.georgia.dhr.dfcs.sacwis.web.ws.cprscaseid;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ws.cprsidquery.CprsCaseListQueryWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscaseidlist.CprsQueryCaseListWO;

public interface CprsCaseIdQueryWS {
  public CprsQueryCaseListWO retrieveCPRSCaseList(CprsCaseListQueryWI cprsQueryWI);
}
