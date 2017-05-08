package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT23SO;

public interface SavePersonIdentifiers {

  /**
   * This service updates all the identifiers for a given person.
   *
   * @param cint23si
   * @return
   */
  public CINT23SO savePersonIdentifiers(CINT23SI cint23si);
}
