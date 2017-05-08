package gov.georgia.dhr.dfcs.sacwis.service.fad;

import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;

public interface RetrieveNonCompliance {
  /**
   * This retrieves a record from the NON_COMPLIANCE table.
   * 
   * @param NonComplianceSI
   * @return NonComplianceSO
   */
  public NonComplianceSO retrieveNonCompliance(NonComplianceSI input);

}
