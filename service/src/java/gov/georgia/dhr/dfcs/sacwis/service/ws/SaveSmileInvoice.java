package gov.georgia.dhr.dfcs.sacwis.service.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SmileInvoiceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SmileInvoiceSO;

public interface SaveSmileInvoice {

  SmileInvoiceSO saveSmileInvoice(SmileInvoiceSI smileInvoiceSI);
}


