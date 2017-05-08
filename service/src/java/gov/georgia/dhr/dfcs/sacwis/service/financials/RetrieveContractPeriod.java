package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;

public interface RetrieveContractPeriod {
  /**
   * Retrieve a contact period row.
   *
   * @param ccon05si
   * @return
   */
  public CCON05SO findContractPeriod(CCON05SI ccon05si);
}
