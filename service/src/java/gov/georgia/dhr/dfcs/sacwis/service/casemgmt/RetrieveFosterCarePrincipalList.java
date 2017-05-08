package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80SO;

/** @author Seung-eun (Caroline) Choi, September 20, 2011 */

public interface RetrieveFosterCarePrincipalList {

  /**
   * This service retrieves all persons associated with an event from STAGE_PERSON_LINK
   *
   * @param csub80si
   * @return
   */
  CSUB80SO retrieveFosterCarePrincipalList(CSUB80SI csub80si);
}
