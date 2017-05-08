/**
 * Created on Mar 25, 2006 at 3:19:56 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant;

import java.util.List;

public interface PlanParticipantDAO {
  /**
   * Retrieve a PlanParticipant row by idEvent
   *
   * @param idEvent
   * @return PlanParticipant
   */
  @SuppressWarnings({"unchecked"})
  List<PlanParticipant> findPlanParticipantByIdEvent(int idEvent);

  /**
   * Selects a count of the Plan events both people are associated.
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return
   */
  //long countPlanParticipant(int idPersMergeForward, int idPersMergeClosed);

  /**
   * Inserts/updates an entire row of PlanParticipant table.
   *
   * @param planParticipant
   */
  void savePlanParticipant(PlanParticipant planParticipant);

  /**
   * Update PlanParticipant
   *
   * @param idEvent
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return
   */
  int updatePlanParticipant(int idEvent, int idPersMergeForward, int idPersMergeClosed);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant} object.
   *
   * @param PlanParticipant
   */
  int deletePlanParticipant(int idPlanPart);
}
