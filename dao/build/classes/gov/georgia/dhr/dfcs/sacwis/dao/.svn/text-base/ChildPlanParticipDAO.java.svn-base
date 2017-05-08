/**
 * Created on Mar 25, 2006 at 2:12:28 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

public interface ChildPlanParticipDAO {
  /**
   * This will select a count of the Child Plan events both people are associated with.
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return
   */
  long countChildPlanParticipEvents(int idPersMergeForward, int idPersMergeClosed);

  /**
   * Updates table ChildPlanParticip, field idPerson given idPersMergeClosed and idEvent.<p/>
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   */
  int updateChildPlanParticipIdPerson(int idPersMergeForward, int idPersMergeClosed, int idEvent);
}
