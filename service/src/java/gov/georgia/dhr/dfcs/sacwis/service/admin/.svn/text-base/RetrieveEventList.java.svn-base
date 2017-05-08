package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN33SO;

public interface RetrieveEventList {
  /**
   * This service calls three main DAOs:
   * <pre>
   * CCMN87D: input:  dynamic: up to 10 variables (2 can repeat up to 40 times)
   *   output: Data for Event List window's ListBox
   * CCMN85D: input:  ID_EVENT
   *   output: NM_PERSON_FULL from the PERSON table
   * CCMN85D: input:  ID_EVENT
   *   output: NM_PERSON_FULL from the PERSON table or "MULTIPLE"
   *   if more than one person is associated with the ID_EVENT
   * CCMN82D: input:  CD_TASK
   *   output: one entire row from the TASK table
   * </pre>
   *
   * @param ccmn33ssi
   * @return
   */
  CCMN33SO retrieveEventList(CCMN33SI ccmn33si);
}
