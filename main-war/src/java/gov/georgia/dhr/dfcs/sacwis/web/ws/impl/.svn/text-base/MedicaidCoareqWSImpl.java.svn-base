package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidCoareqInboundWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidCoareqInboundWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.MedicaidCoareqWS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class MedicaidCoareqWSImpl implements MedicaidCoareqWS{


  Log log = LogFactory.getLog(MedicaidCoareqWS.class);

  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }


  public MedicaidCoareqInboundWO saveMedicaidCoareq(MedicaidCoareqInboundWI medicaidCoareqInboundWI) {
    log.info(">> Inside MedicaidCoareqWSImpl-saveMedicaidCoareq()");
    return ws.saveMedicaidCoareq(medicaidCoareqInboundWI);
  }

  
}

