package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51SO;

public interface RetrieveRiskFactors {

  /**
   * A retrieval service which obtains risk factors for either a Principal or an Incident type from the RISK FACTORS
   * table. The service also returns the current time stamp for the ID EVENT on the Event table.
   *
   * @param cinv51si
   * @return A populated {@link CINV51SO} object.
   */
  public CINV51SO retrieveRiskFactors(CINV51SI cinv51si);
}
