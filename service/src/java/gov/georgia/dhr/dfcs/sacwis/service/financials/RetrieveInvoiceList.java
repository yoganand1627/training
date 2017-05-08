package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN01SO;

public interface RetrieveInvoiceList {

  /**
   * This service will retrieve the information for the listbox on CFIN01W - Invoice List.  This service calls a dynamic
   * dam to retrieve from the INVOICE, CONTRACT, and CAPS RESOURCE tables. It call CDYN07D - INVO LIST RTRV.
   *
   * @param cfin01si
   * @return
   */
  CFIN01SO retrieveInvoiceList(CFIN01SI cfin01si);

}
