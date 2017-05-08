package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON10SO;

public interface SaveContractService {
  /**
   * Updates ContractService using ContractServiceDAO
   *
   * @param input
   * @return The populated {@link CCON10SO} object.
   */
  CCON10SO saveContractService(CCON10SI input);
}
