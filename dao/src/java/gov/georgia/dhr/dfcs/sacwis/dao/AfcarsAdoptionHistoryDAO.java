/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

public interface AfcarsAdoptionHistoryDAO {
  
  /**
   * Whether a child's adoption was reported to AFCARS
   * @param idPerson
   * @return
   */
  Integer findAfcarsAdoptionHistoryIdPersonByIdPerson(int idPerson);
  
  /**
   * Primary child of given stage was reported to AFCARS (Adoption Finalized reported)
   * @param idStage
   * @return
   */
  Integer findAfcarsAdoptionHistoryIdPersonByIdStage(int idStage);

}
