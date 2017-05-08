/**
 * Created on Mar 25, 2006 at 3:22:17 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.RejectionReason;

public interface RejectionReasonDAO {
  /**
   * This will retrieve all rows from the Rejection Reason table that match Id Rejected Item Id & Cd Rej Rsn REj Item
   * Id.
   *
   * @param idRejectedItemId
   * @param cdRejRsnRejItemId
   * @return List of RejectionReason
   */
  @SuppressWarnings({"unchecked"})
  List<RejectionReason> findRejectionReasonByIdRejItemCdRejRsnRejected(int idRejectedItemId,
                                                                       String cdRejRsnRejItemId);
  /**
   * Simple save/update of the rejection reason
   *
   * @param rejectionReason
   */
  public void saveUpdateRejectionReason(RejectionReason rejectionReason);
}
