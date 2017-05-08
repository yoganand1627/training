package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO;

public interface RetrieveCaseMergeVerify {
  /**
   * This Service will verify that the ID case passed to it is an existing case that has not previouly been a Merge From
   * case. The service will also verify that the ID case passed is not pending another merge. If the security
   * requirement have not been met, the service will also verify that the logged in user is authorized to perform the
   * merge. Finally, a series of edit checks will be run to see if cases are eligible to be merged.
   *
   * @param ccfc40si
   * @return
   */
  public CCFC40SO findCaseMergeVerify(CCFC40SI ccfc40si);
}
