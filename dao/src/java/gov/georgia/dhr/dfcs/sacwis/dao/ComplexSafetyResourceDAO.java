package gov.georgia.dhr.dfcs.sacwis.dao;

public interface ComplexSafetyResourceDAO {
  /**
   * Description: Updates SafetyResource records when person forward or closed
   * are involved in a safety resource placement.  
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   * @return int
   */

  @SuppressWarnings({"unchecked"})
  public int updateSafetyResource(int idPersMergeForward, int idPersMergeClosed, int idEvent);
}