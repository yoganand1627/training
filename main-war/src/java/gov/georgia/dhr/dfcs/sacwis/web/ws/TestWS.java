package gov.georgia.dhr.dfcs.sacwis.web.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveTestRowWI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTestRowWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveTestRowWO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTestRowWO;

public interface TestWS {
  public SaveTestRowWO saveTestRow(SaveTestRowWI saveTestRowWI);

  public RetrieveTestRowWO retrieveTestRow(RetrieveTestRowWI retrieveTestRowWI);
}
