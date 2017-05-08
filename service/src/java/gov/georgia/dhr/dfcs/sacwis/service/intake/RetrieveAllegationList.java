package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44SO;

public interface RetrieveAllegationList {

  /**
   * This service retrieves allegations to fill the Investigation Allegation List listbox.  It also retrieves the
   * stage's overall disposition.
   *
   * @param cinv44si
   * @return A populated {@link CINV44SO} object.
   */
  CINV44SO retrieveAllegationList(CINV44SI cinv44si);
}
