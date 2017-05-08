package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;

public interface RetrieveEmployeeDetail {

  /**
   * Retrieves the Employee information
   *
   * @param ccmn04si
   * @return {@link CCMN04SO}
   */
  public CCMN04SO retrieveEmployeeDetail(CCMN04SI ccmn04si);
  
}
