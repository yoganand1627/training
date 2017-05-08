package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.InvalidateApprovalSI;


public interface InvalidateAndPostEvent {
 
  

  /**
   * This service will Combine Post Event and Invalidate Approval into one transaction.  If the post event fails then both 
   * the transaction will be rolled back.  This way the event statuses will be in synch.
   *
   * @param invalidsi {@link InvalidSI} object
   * @return {@link InvalidSO} object
   */
  public void invalidateAndPostEvent(InvalidateApprovalSI invalidateApprovalsi);

}
