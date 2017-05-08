package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveTestRowWI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTestRowWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveTestRowWO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTestRowWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.TestWS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestWSImpl implements TestWS {

  Log log = LogFactory.getLog(TestWS.class);

  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }

  public SaveTestRowWO saveTestRow(SaveTestRowWI saveTestRowWI) {
    log.info(">> Inside TestWSImpl-saveTestRow()");
    return ws.saveTestRow(saveTestRowWI);
  }

  public RetrieveTestRowWO retrieveTestRow(RetrieveTestRowWI retrieveTestRowWI) {
    log.info(">> Inside TestWSImpl-retrieveTestRow()");
    return ws.getTestRow(retrieveTestRowWI);
  }
}
