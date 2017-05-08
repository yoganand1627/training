package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import java.util.Map;

/**
 * This class declares the interface for the SafetyResourceDAO and holds the simple
 * methods for accessing the SAFETY_RESOURCE table in the CAPS schema.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  Patrick Coogan    Added header and final check in for Safety Resource 
 *                             enhancement.
 * 06/25/2009 bgehlot          STGAP00014329: Added method deleteSafetyResourceChildTodo
 * 
 * 07/09/2009 cwells           STGAP00014333: Added methods retrieveSafetyRsrcForm and findSafetyRsrcFormVersion 
 * 
 * 02/05/2009 cwells           CAPTADEV: Added findOpenActiveSafetyResourcesForChild 
 * 02/06/2012 schoi            STGAP00017831: MR-102 Added new method findActiveApprovedSafetyResourceByIdPersonByDate
 * </pre>
 */

public interface SafetyResourceChildDAO {

  /**
   * Finds the SafetyResourceChild record for the given primary key.
   *
   * @param idSrChild
   * @return SafetyResourceChild
   */
  SafetyResourceChild findSafetyResourceByIdSrChild(int idSrChild);
  
  /**
   * Finds the SafetyResourceChild record for the given child and date.
   * @param idSrChild
   * @param dtSysDtGenericSysdate
   * @return SafetyResourceChild
   */
  public SafetyResourceChild findOpenActiveSafetyResourcesForChild(int idSrChild, Date dtSysDtGenericSysdate);
  

  /**
   * This inserts or updates are row in SAFETY_RESOURCE_CHILD table
   * @param safetyResourceChild
   * @return int #of of rows inserted/updated
   */
  int saveOrUpdateSafetyResourceChild(SafetyResourceChild safetyResourceChild);

  /**
   * Deletes a row from SAFETY_RESOURCE_CHILD table
   * @param idEvent
   * @return
   */
  int deleteSafetyResourceChild(int idSrChild);

  /**
   * Finds all the open safety resource placements for a given stage.
   * @param idStage
   * @return List<SafetyResourceChild>
   */
  List<SafetyResourceChild> findOpenSafetyResourcesForStage(int idStage);
  
  /**
   * Finds all the safety resource child records for a given safety resource event.
   * @param idEvent
   * @return List<SafetyResourceChild>
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findSafetyResourceChildrenForEvent(int idEvent);
  
  /**
   * Finds all the open safety resource placements for a child.
   * @param idSrChild
   * @return List<SafetyResourceChild>
   */
  List<SafetyResourceChild> findOpenSafetyResourcesForChild(int idSrChild);

  /**
   * Finds all the open safety resource placements for a child.  This method was necessary
   * for the ONG stage which may look back at INV for a open Safety Resource
   * 
   * @param idCase
   * @return List<SafetyResourceChild>
   */
  List<SafetyResourceChild> findOpenSafetyResourcesForCase(int idCase);
  
  
  /**
   * For a given child (idChild), end date (dtEnd), and current record primary key
   * (idSrChild), find any safety resource placements for the child where the currently
   * entered end date will overlap the start date of the next safety resource placement.
   * 
   * @param idChild
   * @param dtEnd
   * @param idSrChild
   * @return List<Integer>
   */
  public List<Integer> findOverlapRightForChild(int idChild, Date dtEnd, int idSrChild);
  
  /**
   * For a given child (idChild), end date (dtEnd), start date (dtStart), 
   * and current record primary key(idSrChild), find any safety resource placements 
   * for the child where the currently entered end date will overlap the end date 
   * of the next safety resource placement.
   * 
   * @param idChild
   * @param dtEnd
   * @param dtStart
   * @param idSrChild
   * @return List<Integer>
   */
  public List<Integer> findOverlapLeftForChild(int idChild, Date dtStart, Date dtEnd, int idSrChild);
  
  /**
   * For a given passed safety resource event ID, determine if any placements on the event
   * are not end dated.
   * 
   * @param idEvent
   * @return List<Integer>
   */
  public List<Integer> findOpenSafetyResourcesForEvent(int idEvent);
  
  /**
   * Counts to determine if a particular idPerson is a child on a given Safety Resource placement
   * 
   * @param idPerson
   * @param idEvent
   * @return long
   */
  public long countSafetyResourceChildForEvent(int idPerson, int idEvent);
  
  /**
   * Deletes safety resource child records for a specific child and event
   * when that child is a person closed in a merge and the person forward 
   * was already placed in the safety resource.
   * 
   * @param idPerson
   * @param idEvent
   * @return int
   */
  public int deleteSafetyResourceChildEvent(int idChild, int idEvent);
  
  /**
   * Updates safety resource child rows associated with the closed person
   * to the forward person
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   * @return int
   */
  public int mergeSafetyResourceChildren(int idPersMergeForward, int idPersMergeClosed, int idEvent);
  
  /**
   * Counts instances of person ID in safety resource placements for a case
   * @param idPerson
   * @param idCase
   * @return long
   */ 
  public long countSafetyResourceChildForCase(int idPerson, int idCase);
  
  /**
   * STGAP00014329: Delete todo for the event
   * @param idEvent
   * @return
   */

  int deleteSafetyResourceChildTodo(int idEvent);
  
  
  /**
   * Retrieves the Template Version for the given form 
   * @param idCase
   * @param idEvent
   * @return Integer
   */
  public Integer findSafetyRsrcFormVersion(int idEvent);
  
  // STGAP00017831: MR-102
  /**
   * Finds active Safety Resource Placement in which the Start Date of Safety Resource Placement 
  // is earlier or equal to the Begin Date of the earliest Service Authorization Detail 
  // for the person receiving services AND the End Date of Safety Resource Placement 
  // must be later than the Begin Date of the earliest Service Authorization Detail 
  // for the person receiving services. System will look for the Safety Resource Placement across stages. 
   * @param idChild
   * @param dtSvcAuthDtlBegin
   * @return SafetyResourceChild
   */
  public SafetyResourceChild findActiveApprovedSafetyResourceByIdPersonByDate(int idChild, Date dtSvcAuthDtlBegin);
  
  /**
   * Retrieves form Data for Safety Resource Assessment Form
   * @param idEvent
   * @return
   */
  public byte[] retrieveSafetyRsrcForm(int idEvent);

}
