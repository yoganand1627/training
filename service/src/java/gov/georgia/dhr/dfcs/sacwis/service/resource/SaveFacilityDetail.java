package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES10SO;

public interface SaveFacilityDetail {

  /**
   * This service updates all enterable fields from Facility Detail Window.
   *
   * @param cres10si
   * @return
   */
  CRES10SO saveFacilityDetail(CRES10SI cres10si);
}
