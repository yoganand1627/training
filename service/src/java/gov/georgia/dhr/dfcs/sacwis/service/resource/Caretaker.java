package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;

public interface Caretaker {
  /**
   * This retrieves information about care takers.
   *
   * @param cres18si
   * @return A populated {@link CRES18SO} ojbect.
   */
  CRES18SO caretaker(CRES18SI cres18si);
}
