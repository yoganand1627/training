package gov.georgia.dhr.dfcs.sacwis.web.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SmileInvoiceWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SmileInvoiceWO;

public interface SmileInvoiceWS {
  
  public SmileInvoiceWO saveSmileInvoice(SmileInvoiceWI smileInvoiceWI);

}



