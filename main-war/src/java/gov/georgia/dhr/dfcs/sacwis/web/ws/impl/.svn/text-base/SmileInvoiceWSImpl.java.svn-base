package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SmileInvoiceWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SmileInvoiceWO;
import gov.georgia.dhr.dfcs.sacwis.web.ws.SmileInvoiceWS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SmileInvoiceWSImpl implements SmileInvoiceWS{

  
  Log log = LogFactory.getLog(SmileInvoiceWS.class);

  private WS ws;

  public void setWS(WS ws) {
    this.ws = ws;
  }


  public SmileInvoiceWO saveSmileInvoice(SmileInvoiceWI smileInvoiceWI) {
    log.info(">> Inside SmileInvoiceWSImpl-saveSmileInvoice");
    return ws.saveSmileInvoice(smileInvoiceWI);
      }

  
}

