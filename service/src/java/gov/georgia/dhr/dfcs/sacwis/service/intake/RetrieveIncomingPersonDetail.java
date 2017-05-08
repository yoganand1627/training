package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;

public interface RetrieveIncomingPersonDetail {

  /**
   * Retrieve service for CINT16W Incoming Person Detail window.
   *
   * @param cint34si
   * @return A populated {@link CINT34SO} object.
   */
  CINT34SO retrieveIncomingPersonDetail(CINT34SI cint34si);
}
