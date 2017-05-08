package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO;

public interface RetrieveNeedsAndOutcomes {
  
  /**
   * A retrieval service which obtains Needs and Outcomes
   *
   * @param NeedsAndOutcomesRetrieveSI
   * @return A populated {@link gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO} object.
   */

  
 public NeedsAndOutcomesRetrieveSO retrieveNeedsAndOutcomes(NeedsAndOutcomesRetrieveSI needsAndOutcomesRetrieveSi);

}
