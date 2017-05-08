/**
 * Created on Mar 25, 2006 at 1:48:01 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteApprovalEventLinkByIdStageCdTask
 * </pre>
 */

public interface ApprovalEventLinkDAO {
  /**
   * For a given approval retreives the related functional events
   *
   * @param idApprovers
   * @return keys idEvent, cdTask
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findRelatedFunctionalEventsForGivenApproval(int idApprovers);
  
  List<Integer> findIdApprovalEventLinksByIdEvent(int idEvent);
  
  List<Map> findApprovalEventLinksByIdEvent(int idEvent);

  /**
   * Given a functional event will find the related Approval if available. Implicit cursor used due to functional design
   * that an event may belong to only one approval at a time.
   *
   * @param idEvent
   * @return Integer
   */
  Integer findApprovalEventLinkByIdEvent(int idEvent);
  
  /**
   * Given a functional event will find the related Approvals and Rejections.
   *
   * @param idEvent
   * @return List<Object[]>
   */
   List<Object[]> findApprovalsforCaseEvent (int idEvent);
  
  
  /**
   * Find the current approval's id, currently invalid ones have status 'INVD'; current one has 'PEND'
   * @param idEvent
   * @return
   */
  Integer findActiveIdApprovalByIdEvent(int idEvent);
  
  
  /**
   * Finds the Invalidated approvals id noted as 'INVD'.  Current ones have a 'PEND' Status 
   * @param idEvent
   * @return Integer
   */
  Integer findInvalidIdApprovalByIdEvent(int idEvent);
  

  /**
   * Insert a new ApprovalEventLink
   *
   * @param idEvent
   * @param idApproval
   * @return number of rows affected
   */
  int insertApprovalEventLink(int idEvent, int idApproval);
  
  /**
   * 
   * @param idApprovalEvent
   * @return
   */
  Integer findEventByIdApprovalEvent(int idApprovalEvent) ;
  
  /**
   * Delete rows from APPROVAL_EVENT_LINK based on ID_APPROVAL
   *
   * @param idApproval
   * @return
   */
  int deleteApprovalEventLinkByIdApproval(int idApproval);

  /**
   * Delete rows from APPROVAL_EVENT_LINK based on ID_EVENT
   *
   * @param idEvent
   * @return
   */
  int deleteApprovalEventLinkByIdEvent(int idEvent);

  
  /**
   * Insert new ApprovalEventLink record
   * @param idEvent
   * @param idApproval
   * @param idCase
   * @return
   */
  int insertNewApprovalEventLink(int idEvent, int idApproval, int idCase);
  
  /** 
   * //STGAP00014341: Delete Approval event link records for the stage and task
   * @param idStage
   * @param cdEventType
   * @param cdTask
   * @return
   */
  int deleteApprovalEventLinkByIdStageCdTask(int idStage, String cdEventType, String cdTask);
}
