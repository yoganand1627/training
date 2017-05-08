package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC18SO;

public interface SaveEducationalHistory {
  /** Probably need to add this to the CodesTables later */
  static final String IN_STATE = "I";

  /**
   * This service will add/update/delete all changed or added rows to the EDUCATIONAL HISTORY table for a given
   * ID_EDHIST. A new ID_EDHIST will be triggered if a new row is added.
   *
   * @param ccfc18si {@link CCFC18SI} oject
   * @return {@link CCFC18SO} object
   */
  public CCFC18SO audEducationalHistory(CCFC18SI ccfc18si);
}
