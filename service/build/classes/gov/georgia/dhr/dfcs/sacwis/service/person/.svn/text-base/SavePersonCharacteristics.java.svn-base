/**
 * Created on Jul 26, 2006 at 11:39:10 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34SO;

public interface SavePersonCharacteristics {
  static final String MERGE_MODE = "M";
  //static final String SEC_REG_FAM_INDP_STF = "73"; // MES specialist/staff
  //static final String SEC_REGIONAL_SS_STF = "70"; // Adoption specialist 
  /**
   * This service is responsible for adding or updating information from the Person Characteristics window.
   *
   * @param cinv34si
   * @return A populated {@link CINV34SO} object.
   */
  CINV34SO savePersonCharacteristics(CINV34SI cinv34si);
}
