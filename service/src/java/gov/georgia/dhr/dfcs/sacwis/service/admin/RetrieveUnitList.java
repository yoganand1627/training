package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;

public interface RetrieveUnitList {
  /**
   * Retrieve list of Units (based on unitProgram,unitRegion and nbrUnit) see DynamicUnitDAO for more info on the return
   * value structure
   *
   * @param ccmn24si
   * @return {@link CCMN24SO} object containing list of units
   */
  public CCMN24SO retrieveUnitList(CCMN24SI ccmn24si);
}
