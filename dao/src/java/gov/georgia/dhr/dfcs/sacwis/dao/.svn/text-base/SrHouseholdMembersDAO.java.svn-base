package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SrHouseholdMembers;
import java.util.List;

/**
 * This class declares the interface for the SrHouseholdMembersDAO and holds the simple
 * methods for accessing the SR_HOUSEHOLD_MEMBERS table in the CAPS schema.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  Patrick Coogan    Added header and final check in for Safety Resource 
 *                             enhancement.
 * </pre>
 */

public interface SrHouseholdMembersDAO {

 
  /**
   * Returns person id's of existing household members for a passed event
   * 
   * @param idEvent
   * @return List <Integer>
   */
  public List<Integer> findSrHouseholdMembersByIdEvent(int idEvent);
  
  /**
   * Deletes a row from SR_HOUSEHOLD_MEMBERS for a passed person and event
   * 
   * @param idEvent
   * @param idPerson
   * @return int
   */ 
  public int deleteSrHouseholdMembersByPersonAndEvent(int idPerson, int IdEvent);
  
  /**
   * Deletes all row from SR_HOUSEHOLD_MEMBERS for a given safety resource event
   * 
   * @param idEvent
   * @return int
   */ 
  public int deleteSrHouseholdMembersByEvent(int IdEvent);
  
  /**
   * Inserts or updates a row in SR_HOUSEHOLD_MEMBERS 
   * 
   * @param idEvent
   * @return int
   */  
  public void saveOrUpdateSrHouseholdMembers(SrHouseholdMembers srHouseholdMembers);
  
  /**
   * Returns number to verify that person forward in a merge is not already on
   * the safety resource event.
   * 
   * @param idPerson
   * @param idEvent
   * @return long
   */
  public long countSafetyHouseholdForEvent(int idPerson, int idEvent);
  
  /**
   * Deletes persons closed from a safety resource event when the person forward
   * is already on the event.
   * 
   * @param idPerson
   * @param idEvent
   * @return int
   */
  public int deleteSrHouseholdMembersEvent(int idPerson, int idEvent);
  
  /**
   * Merges records for persons closed into persons forward for person id's and
   * a particular safety resource event.
   * 
   * @param idPerson
   * @param idEvent
   * @return int
   */
  public int mergeSafetyResourceHshldMembers(int idPersMergeForward, int idPersMergeClosed, int idEvent);
  
  /**
   * Counts instances of person ID in safety resource placements for a case
   * @param idPerson
   * @param idCase
   * @return long
   */ 
  public long countSafetyHouseholdForCase(int idPerson, int idCase);
  
}
