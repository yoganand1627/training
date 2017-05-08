package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO;

public interface RetrievePersonMerge {

  /**
   * @param ccfc13si
   * @return
   */
  CCFC13SO retrievePersonMerge(CCFC13SI ccfc13si);
}
