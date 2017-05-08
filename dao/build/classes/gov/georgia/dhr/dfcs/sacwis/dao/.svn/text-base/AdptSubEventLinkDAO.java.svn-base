/**
 * Created on Mar 25, 2006 at 1:54:50 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AdptSubEventLink;

import java.util.List;
import java.util.Map;

public interface AdptSubEventLinkDAO {
  /**
   * This selects a row from AdptSubEventLink. <p/>
   *
   * @param idEvent
   * @return AdptSubEventLink
   */
  Map findAdptSubEventLink(int idEvent);

  /**
   * Will add row to the ADPT_SUB_EVENT_ LINK table
   *
   * @param idEvent
   * @param idAdptSub
   * @return The number of rows inserted.
   */
  int insertAdptSubEventLink(int idEvent, int idAdptSub);
  
  /**
   * Find the number of agreements that have ended for that person
   *
   * @param idStage
   * @param idPerson
   * @return The number of rows inserted.
   */
  public Long findPriorEndedAAAgreementCount(int idStage, int idPerson);
  
  /**
   * Inserts or updates a ADptEventLink Record
   * @param adptSubEventLink
   */
  void saveAdptSubEventLink(AdptSubEventLink adptSubEventLink);
    
  /**
   * Gets the corresponding event Id given the Ado Sub Id
   * @param idAdoSub
   * @return
   */
  Integer findIdEventByIdAdoSub(int idAdoSub);
  
  /**
   * Gets all Completed AdoptionSubsidies' Id for a person and case
   * @param idCase
   * @param idPerson 
   * @param idStage 
   * @return list of idAdoptionSubsidy
   */
  List<Integer> findCompletedAdoptionSubsidiesByIdCaseIdStageIdPerson(int idCase, int idStage, int idPerson);
}
