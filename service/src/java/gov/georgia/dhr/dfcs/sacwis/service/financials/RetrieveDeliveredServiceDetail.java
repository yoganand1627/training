package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;

public interface RetrieveDeliveredServiceDetail {

  /**
   * Retrieve ApprovalStatus row information
   *
   * @param cfin06si
   * @return A {@link CFIN06SO{
   */
  CFIN06SO findDeliveredServiceDetail(CFIN06SI cfin06si);
}
