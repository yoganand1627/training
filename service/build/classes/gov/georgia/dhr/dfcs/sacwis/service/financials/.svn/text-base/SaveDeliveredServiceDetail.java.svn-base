package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN07SO;

public interface SaveDeliveredServiceDetail {

  /**
   * This service will add/update to the Delivered Service Table and to the Invoice table.  It will also verify that
   * there are more adjustment line items than reversal line items.
   *
   * @param cfin07si
   */
  CFIN07SO saveDelvrdSvcDtl(CFIN07SI cfin07si);
}
