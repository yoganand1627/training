/**
 * Created on Mar 25, 2006 at 1:48:25 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Approval;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteApprovalsByIdStageCdTask, deleteApprovals
 * </pre>
 */

public interface ApprovalDAO {
  /**
   * Retreives header information for Approval Window. Explicit fetch used although 1 row to be returned due to DB
   * unique rule.
   *
   * @param idApproval
   * @return keys idPerson, nmPersonFull, txtApprovalTopic
   */
  @SuppressWarnings({"unchecked"})
  Map findApprovalInfoForHeader(int idApproval);

  /**
   * Inserts a new Approval row. The original DAM (ccmn92d.pc) noted that idApproval matches a corresponding idEvent. If
   * true, this could lead to conflicts if an Approval is inserted that fires the insert trigger (idApproval value of
   * 0), which uses a sequence to set the idApproval value.
   *
   * @param idApproval
   * @param idPerson
   * @param cdTxtApprovalTopic
   * @return
   */
  int insertApproval(int idApproval, int idPerson, String cdTxtApprovalTopic);
  
  int deleteApprovalByIdApproval(Collection<Integer> idApprovalList);

  /**
   * Deletes an Approval row by idApproval
   *
   * @param idApproval
   * @return
   */
  int deleteApprovalByIdApproval(int idApproval);
  
  /**
   * Saves the approval record
   */
  int saveApproval(Approval approval);
  
  /** 
   * //STGAP00014341: Delete Approvals for the stage and task
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteApprovalsByIdStageCdTask(int idStage, String cdTask);
  
  
  /** 
   * //STGAP00014341: Delete Approvals for the stage and task
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteApprovals(int idStage, String cdTask);
}
