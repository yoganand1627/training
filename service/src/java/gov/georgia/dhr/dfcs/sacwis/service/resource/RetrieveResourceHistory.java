package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD13SO;

public interface RetrieveResourceHistory {
  /**
   * This service will retrieve an entire resource history row given idResourceHistory.
   *
   * @param cfad13si
   * @return A {@link CFAD13SO} object.
   */
  CFAD13SO retrieveResourceHistory(CFAD13SI cfad13si);
}
