/**
 * Created on 6/6/2008 by Joshua Dorsey
 *  *  * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/21/2009  bgehlot         STGAP00014329: Added method findSafetyResourceByIdEvent  
 * </pre>
 */

package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import java.util.List;
import java.util.Map;

public interface SafetyResourceDAO {
  
  /**
   * This inserts or updates are row in safety Resource table
   * @param safetyResourceSaveSI
   * @return
   */
  int saveOrUpdateSafetyResource(SafetyResource safetyResource);
  
  /**
   * Deletes a row from Safety_Resource table
   * @param idEvent
   * @return
   */
  int deleteSafetyResource(int idEvent);
  
  /**
   * queries a count from Safety_Resource table of rows for the person and case id
   * @param idPerson
   * @param idCase
   * @return
   */ 
  public long countSafetyResourceForCase(int idPerson, int idCase);
  
  /**
   * queries a count from Safety_Resource table of rows of Un-approved Safety Resources and case id
   * @param idCase
   * @return
   */
  public long countOpenSafetyResourcesForCase(int idCase);
  
  
  /**
   * Updates primary safety resource from person closed to person forward
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   * @return int
   */ 
  public int updateSafetyResourcePrimary(int idPersMergeForward, int idPersMergeClosed, int idEvent);
  
  /**
   * Updates secondary safety resource from person closed to person forward
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   * @return int
   */ 
  public int updateSafetyResourceSecondary(int idPersMergeForward, int idPersMergeClosed, int idEvent);
  
  /**
   * STGAP00014329: Find the safety resource for idEvent
   * @param idEvent
   * @return
   */
  SafetyResource findSafetyResourceByIdEvent(int idEvent);
  
  /**
   * Finds all safety resource placements for a case, open or closed,
   * in support of case watch page
   * @param iCase
   * @return Map
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findAllSafetyResourcePlacementsForCase(int idCase);
  
}
