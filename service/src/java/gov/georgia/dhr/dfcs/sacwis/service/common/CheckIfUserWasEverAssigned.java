package gov.georgia.dhr.dfcs.sacwis.service.common;

/**
 * @author CWells
 *
 */
public interface CheckIfUserWasEverAssigned {
  
  /**
   *  This method is used to determine if the person was 
   *  ever assigned to a specific stage before or currently
   * @param idCase
   * @param idStage
   * @param idPerson
   * @return boolean indicating if USER was ever assigned to case before
   */
  public boolean determineIfUserWasEverAssigned(int idCase, int idStage, int idPerson);

}
