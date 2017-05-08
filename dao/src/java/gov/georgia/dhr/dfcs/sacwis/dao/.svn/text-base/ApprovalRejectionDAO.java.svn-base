/**
 * Created on Mar 25, 2006 at 1:47:44 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.ApprovalRejection;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteApprovalRejectionsByIdStageCdTask
 *  11/18/2009  arege    SMS#38675: Added method deleteApprovalRejectionsByIdStageCdTask
 * </pre>
 */

public interface ApprovalRejectionDAO {
  /**
   * This will retrieve all row from the APPROVAL_REJECTION table for any given stage.  Currently approval rejection
   * information is only available for APS INV & SVC stages.
   *
   * @param idCase
   * @param idStage
   * @return keys nmPersonFull, idApprovalRejection, idPerson, dtRejection, indApsEffort, indProblems, indEvidence,
   *         indMissingEvidRptr, indMissingEvidAp, indMissingEvidMp, indMissingEvidCol, indMissingEvidPhotos,
   *         indMissingEvidDe, indMissingEvidOth, indDiscretionary, txtApproversCmnts
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findApprovalRejectionByIdCaseIdStage(int idCase, int idStage);
  
  int deleteApprovalRejectionByIdApproval(Collection<Integer> idApprovalList);
  
  int deleteApprovalRejectionByIdApproval(int idApproval);
  
  
  /**
   * This will retrieve all row from the APPROVAL_REJECTION table for any given approval.  Currently approval rejection
   * information is only available for APS INV & SVC stages.
   *
   * @param idCase
   * @param idStage
   * @param idApproval
   * @return keys nmPersonFull, idApprovalRejection, idPerson, idApproval, dtRejection, indApsEffort, indProblems, indEvidence,
   *         indMissingEvidRptr, indMissingEvidAp, indMissingEvidMp, indMissingEvidCol, indMissingEvidPhotos,
   *         indMissingEvidDe, indMissingEvidOth, indDiscretionary, txtApproversCmnts
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findApprovalRejectionByIdCaseIdStageAndIdApproval(int idCase, int idStage, int idApproval);
  
  /**
   * Takes a target event and uses ApprovalEventLink to map to all related ApprovalRejection
   * records (if any).
   * 
   * @param idEvent
   * @return
   */
  List<ApprovalRejection> findApprovalRejectionByIdEvent(int idEvent);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ApprovalRejection} object to the database.
   *
   * @param approvalRejection A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ApprovalRejection} object.
   */
  void saveApprovalRejection(ApprovalRejection approvalRejection);
  
  /** 
   * //STGAP00014341: Delete Approval rejections for the stage and task
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteApprovalRejectionsByIdStageCdTask(int idStage, String cdTask);
  
  //SMS#38675: Delete Approval rejections SUB,FPR and FSU by stage and task
  /**
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteApprovalRejections(int idStage, String cdTask);
}
