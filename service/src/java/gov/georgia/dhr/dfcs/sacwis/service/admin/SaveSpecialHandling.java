package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82SO;

public interface SaveSpecialHandling {
  /**
   * Performs AUD operations for the special handling window (CCMN73W). Updates part of one row in the CAPS CASE table.
   *
   * @param ccmn82si The input object populated with the method parameters (row/column values).
   * @return int The number of entities effected by this 'update' operation.
   */
  public CCMN82SO updateCapsCase(CCMN82SI ccmn82si);
}
