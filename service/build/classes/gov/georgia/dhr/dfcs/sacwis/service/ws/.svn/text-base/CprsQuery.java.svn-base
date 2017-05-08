package gov.georgia.dhr.dfcs.sacwis.service.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsCaseListQuerySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsQueryCaseListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsQuerySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CprsQueryCaseListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CprsQuerySO;

public interface CprsQuery {
  CprsQuerySO performCPRSQuery(CprsQuerySI cprsQuerySI);
  
  public CprsQuerySO retrieveCPRSCases(CprsQueryCaseListSI cprsQueryCaseListSI); 
  
  public CprsQueryCaseListSO retrieveCPRSCaseList(CprsCaseListQuerySI cprsCaseListQuerySI);
}
