package gov.georgia.dhr.dfcs.sacwis.service.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveTestRowSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveTestRowSI;

public interface RetrieveTestRow {
  RetrieveTestRowSO getTestRow(RetrieveTestRowSI retrieveTestRowSI);
}