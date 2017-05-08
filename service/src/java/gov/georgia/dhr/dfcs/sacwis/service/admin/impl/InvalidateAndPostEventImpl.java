package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateAndPostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.InvalidateApprovalSI;

/**
 * This service will Combine Post Event and Invalidate Approval into one transaction. If the post event fails then both
 * the transaction will be rolled back. This way the event statuses will be in synch.<p/> <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  
 * </pre>
 * 
 */
public class InvalidateAndPostEventImpl extends BaseServiceImpl implements InvalidateAndPostEvent {

  private PostEvent postEvent = null;

  private InvalidateApproval invalidateApproval = null;

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void invalidateAndPostEvent(InvalidateApprovalSI invalidApprovalsi) throws ServiceException {

    CCMN05UI ccmn05ui = invalidApprovalsi.getCCMN05UI();

    CCMN01UI ccmn01ui = invalidApprovalsi.getCCMN01UI();

    if (ccmn05ui != null) {
      invalidateApproval.invalidateApproval(ccmn05ui);
    }

    if (ccmn01ui != null) {
      postEvent.postEvent(ccmn01ui);
    }

  }
}
