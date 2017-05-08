/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.web.ws.cprsextdoc.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ws.cprsextdoc.CprsExtDocWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprsextdoc.CprsExtDocWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.cprsextdoc.CprsExtDocWS;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CprsExtDocWSImpl implements CprsExtDocWS {
  Log log = LogFactory.getLog(CprsExtDocWS.class);

  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }

  /*
   * (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.web.ws.cprsextdoc.CprsExtDocWS#saveCprsExtDoc(gov.georgia.dhr.dfcs.sacwis.structs.input.ws.cprsextdoc.CprsExtDocWI)
   */
  public CprsExtDocWO saveCprsExtDoc(CprsExtDocWI cprsExtDocWI) {
    log.info(">> Inside CprsExtDocWSImpl-saveCprsExtDoc");
    return ws.saveCprsExtDoc(cprsExtDocWI);

  }

}
