package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO;

public interface RetrieveOfficeName {

  /**
   * Retrieves the Office name
   *
   * @param ccmn40si
   * @return
   */
  public CCMN40SO retrieveOfficeName(CCMN40SI ccmn40si);
}
