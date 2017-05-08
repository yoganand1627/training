package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1SO;

public interface RetrieveOnCallPhone {

  /**
   * Uses personPhoneDAO to retrieve nbrPersonPhone and nbrPersonPhoneExtension
   *
   * @param input
   * @return
   */
  CCMNA1SO retrieveOnCallPhone(CCMNA1SI input);
}
