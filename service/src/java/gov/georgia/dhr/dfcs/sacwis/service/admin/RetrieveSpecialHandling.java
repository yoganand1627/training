package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO;

public interface RetrieveSpecialHandling {

  /**
   * Retrieves either all or only the valid rows for a given person id depending upon whether the the invalid 'SYS IND
   * VALID ONLY' indicator is set.
   *
   * @param ccmn81si The input object that contains the method parameters.
   * @return ccmn81so The output object populated with the returned column values.
   */
  CCMN81SO findCapsCase(CCMN81SI ccmn81si);
}
