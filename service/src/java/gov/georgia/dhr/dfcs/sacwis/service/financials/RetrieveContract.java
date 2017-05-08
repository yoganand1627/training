package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON02SO;

public interface RetrieveContract {

  /**
   * Retrieve a contact
   *
   * @param ccon02si
   * @return
   */
  public CCON02SO findContract(CCON02SI ccon02si);
}
