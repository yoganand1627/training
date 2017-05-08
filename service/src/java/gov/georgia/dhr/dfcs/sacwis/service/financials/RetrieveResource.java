package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON04SO;

public interface RetrieveResource {

  /**
   * Retrieve a set of Resource row information
   *
   * @param ccon04si
   */
  CCON04SO findResource(CCON04SI ccon04si);
}
