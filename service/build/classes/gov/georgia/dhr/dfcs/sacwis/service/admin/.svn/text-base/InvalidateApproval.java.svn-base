package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;

public interface InvalidateApproval {

  /**
   * This library / common function will the approval related to a given ID EVENT. Functional Events are uniquely
   * identified by this input. This function will find the the ID APPROVAL (ID EVENT of the approval event) from the
   * Approval Event List Table. This key information will allow the function to complete the following: Update the
   * Approval Event, Get any other functional events related to the same Approval and demote them, set any pending
   * related approvers to invalid status.
   *
   * @param ccmn05ui Note that ROWCCMN45DO will be populated inside this object during execution as a side-effect.
   */
  public CCMN05UO invalidateApproval(CCMN05UI ccmn05ui);
}
