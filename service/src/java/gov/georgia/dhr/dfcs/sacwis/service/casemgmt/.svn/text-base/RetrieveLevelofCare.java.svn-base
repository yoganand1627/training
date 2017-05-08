package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO;

public interface RetrieveLevelofCare {
  /**
   * Retrieves an event row using the Event ID as the key. It also retrieves a row from the Level of Care table using
   * the Event ID as the key.  This information is used to populate the Level of Care window.
   *
   * @param csub16si The input object containing the method parameters.
   * @return {@link CSUB16SO} Ouput object populated with the retrieved row/column values.
   */
  public CSUB16SO findEventAndPersonLocInformation(CSUB16SI csub16si);
}
