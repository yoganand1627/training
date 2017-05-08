/**
 * Created on Mar 25, 2006 at 1:46:34 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Approvers;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteApproversByIdStageCdTask, deleteApprovers, findApproverByIdEventForFSUSUBFPR
 * </pre>
 */

public interface ApproversDAO {
  /**
   * Retrieves all approvers for the associated idEvent, ordered descending by idApprovers.
   * 
   * @param idEvent
   * @return
   */
  List<Approvers> findApproversByIdEventReverseChronology(int idEvent);
  
  /**
   *  Retrieves the last approvers for the associated idEvent if the that event last status is approved
   * 
   * @param idEvent
   * @param cdEventStatus
   * @return Approvers
   */
  Approvers findApproverByIdEventIfEventIsApproved(int idEvent, String cdEventStatus); 
    
    /**
     * } Retrieves all approvers for the associated idApproval, ordered descending by idApprovers.
     * 
     * @param idApproval
     * @return
     */
  List<Approvers> findApproversByIdApprovalReverseChronology(int idApproval);
  
  /**
   * Retrieves all approvers for the associated idTodo, ordered descending by idApprovers. Typically, there should only
   * be one entry in APPROVERS per ID_TODO, but this method is a conservative approach for the rare chance that more
   * than one record exists.
   * 
   * @param idTodo
   * @return
   */
  List<Approvers> findApproversByIdTodoReverseChronology(int idTodo);

  /**
   * Return Approvers for a given idTodo
   * 
   * @param idTodo
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Approvers findApproversByIdTodo(int idTodo);

  /**
   * Returns the list of Approvers for the given idApproval
   * 
   * @param idApproval
   * @return List<Approvers>
   */
  @SuppressWarnings({"unchecked"})
  List<Approvers> findApproversByIdApproval(int idApproval);

  /**
   * For a given approval returns all approvers
   * 
   * @param idApprovers
   * @return keys dtApproversDetermination, nmPersonFul, cdApproversStatus, txtApproversCmnts, idTodo, idPerson,
   *         idApprovers, dtLstUpdate
   */
  List<Map> findAllApproversForGivenApproval(int idApprovers);

  /**
   * Partial update of Approvers given idPerson, cdApproversStatus, txtApproversComments, idApprovers, and dtLastUpdate.
   * 
   * @param idPerson
   * @param cdApproversStatus
   * @param txtApproversComments
   * @param idApprovers
   * @param dtApproversDetermination
   * @param dtLastUpdate
   * @return int
   */
  int updateApproversByIdApproversAndDtLastUpdate(int idPerson, String cdApproversStatus, String txtApproversComments,
                                                  int idApprovers, Date dtApproversDetermination, Date dtLastUpdate);

  /**
   * Returns all approvers for a specific intake.
   * 
   * @param idEvent
   * @return List<Map>
   */
  @SuppressWarnings({"unchecked"})
  List<Object[]> findAllApproversByIntakeIdEvent(int idEvent);

  /**
   * Update ApproversStatus from PEND to INVD for a specified idApproval
   * 
   * @param idApproval
   * @return number of rows updated
   */
  int updateCdApproversStatusByIdApproval(int idApproval);
  
  /**
   * Resets the ID_TODO value for the given ID_APPROVERS. Note that this column is NOT a foreign key to the TODO table,
   * but it must be non-null. Therefore, after deleting a corresponding entry in the TODO table, use this method to
   * reset the ID_TODO to '0'.
   * 
   * @param idApprovers
   * @param idTodo
   * @return
   */
  int updateIdTodoByIdApprovers(int idApprovers, int idTodo);
  
  /**
   * Use this method to set ID_TODO to zero when all you have is the current ID_TODO value (oldIdTodo).
   * 
   * @param oldIdTodo
   * @param newIdTodo
   * @return
   */
  int updateIdTodoByIdTodo(int oldIdTodo, int newIdTodo);

  /**
   * Insert Approvers row
   * 
   * @param cdApproversStatus
   * @param dtApproversDetermination
   * @param dtApproversRequested
   * @param idApproval
   * @param idPerson
   * @param idTodo
   * @param indApproversHistorical
   * @param cdTxtApproversComments
   * @return
   */
  int insertApprovers(String cdApproversStatus, Date dtApproversDetermination, Date dtApproversRequested,
                      int idApproval, int idPerson, int idTodo, String indApproversHistorical,
                      String cdTxtApproversComments);
  
  int deleteApproversByIdApproval(Collection<Integer> idApprovalList);
  
  List<Approvers> findApproversByIdApproval(Collection<Integer> idApprovalList);

  /**
   * Delete rows from Approvers based on ID_APPROVAL.
   * 
   * @param idApproval
   * @return Integer
   */
  int deleteApproversByIdApproval(int idApproval);
  
    /**
   * Given a idApproval will find the related DtApproversDetermination for Approvers.
   * 
   * @param idApproval
   * @return
   */
  Date findApproversDtApproversDetermination(int idApproval);
  
  /**
   * Gets the Approvers record for the given event Id
   * @param idEvent
   * @return
   */
  Approvers findApproverByIdEvent(int idEvent);
  
  /**
   * Gets list of Approvers records where status is not APRV for the given approval Id
   * @param idApproval
   * @return
   */
  List<Approvers> findApproverByIdApprovalByCdStatus(int idApproval, int idApprovers);
  
  /** 
   * //STGAP00014341: Delete Approvers for the stage and task
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteApproversByIdStageCdTask(int idStage, String cdTask);
  
  /** 
   * //STGAP00014341: Delete Approvers for the stage and task
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteApprovers(int idStage, String cdTask);
  
  /** 
   * //STGAP00014341: find Approvers for SUB, FPR and FSU
   * @param idEvent
   * @return
   */
  Approvers findApproverByIdEventForFSUSUBFPR(int idEvent);
}
