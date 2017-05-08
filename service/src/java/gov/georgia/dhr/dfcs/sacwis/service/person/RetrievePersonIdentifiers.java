package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19SO;

public interface RetrievePersonIdentifiers {

  /**
   * This service will retrieve numbers for a person from the person_id table.  The table contains the id person as its
   * FK.  This will be used in the select clause.
   *
   * @param cint19si
   * @return {@link CINT19SO}
   */
  public CINT19SO findPersonIdentifiers(CINT19SI cint19si);
}
