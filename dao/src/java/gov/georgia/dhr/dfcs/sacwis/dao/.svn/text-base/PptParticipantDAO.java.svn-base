/**
 * Created on Mar 25, 2006 at 3:19:56 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PptParticipant;

public interface PptParticipantDAO {
  /**
   * Retrieve a PptParticipant row by idEvent
   *
   * @param idEvent
   * @return PptParticipant
   */
  @SuppressWarnings({"unchecked"})
  List<PptParticipant> findPptParticipantByIdEvent(int idEvent);

  /**
   * Selects a count of the PPT events both people are associated.
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return
   */
  long countPptParticipant(int idPersMergeForward, int idPersMergeClosed);

  /**
   * Inserts/updates an entire row of PptParticipant table.
   *
   * @param pptParticipant
   */
  void savePptParticipant(PptParticipant pptParticipant);

  /**
   * Update PptParticipant
   *
   * @param idEvent
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return
   */
  int updatePptParticipant(int idEvent, int idPersMergeForward, int idPersMergeClosed);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PptParticipant} object.
   *
   * @param PptParticipant
   */
  void deletePptParticipant(PptParticipant pptParticipant);
}
