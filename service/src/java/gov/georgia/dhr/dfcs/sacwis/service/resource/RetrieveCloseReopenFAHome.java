package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO;

public interface RetrieveCloseReopenFAHome {
  /**
   * This service retrieves the information necessary for the  Close/Reopen F/A Home Window.
   *
   * @param cfad30si {@link CFAD30SI} object
   * @return {@link CFAD30SO} object
   */
  public CFAD30SO retrieveNeccessaryInformation(CFAD30SI cfad30si);
}
