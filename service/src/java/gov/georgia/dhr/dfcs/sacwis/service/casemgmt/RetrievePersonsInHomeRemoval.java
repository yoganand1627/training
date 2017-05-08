package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB48SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB48SO;

public interface RetrievePersonsInHomeRemoval {

  /**
   * This service retrieves all persons associated with an event from STAGE_PERSON_LINK and a subset of all persons at
   * home during removal from PERSON_HOME_RMVL table. If the person is found in both tables, an attribute is set to
   * true, so that the person will be 'checked' when displayed to the window.
   *
   * @param csub48si
   * @return
   */
  CSUB48SO retrievePersonsInHomeRemoval(CSUB48SI csub48si);
}
