package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;

public interface RetrieveEducationalHistory {

  /**
   * This service will retrieve all rows from the Education History table for a given Id_Person.  It will also retrieve
   * the School Addresses from the Caps Resource table for a given Id_Resource for all Id_Edhist.
   *
   * @param ccfc17si
   * @return
   */
  CCFC17SO retrieveEducationalHistory(CCFC17SI ccfc17si);
}
