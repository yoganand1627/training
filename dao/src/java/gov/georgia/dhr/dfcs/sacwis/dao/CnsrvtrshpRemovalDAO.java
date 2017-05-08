/**
 * Created on Mar 25, 2006 at 2:11:32 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;

/**
 *  
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  10/27/2008  arege     STGAP00006284 - Added findDtRemovalByIdPersonByIdCase()
 *                        to reflect correct Removal Date on the Initial Medicaid
 *                        Application. 
 *  03/19/2009  bgehlot   STGAP00012833 - Added new method findLatestCnsrvtrshpRemovalDatetByIdCase for Case Review Page
 *  11/09/2010  htvo      SMS#81140 - MR-074 - AFCARS: Added new method findDtRemovalByIdPersonIdCaseByDate
 *  09/12/2011  arege     STGAP00017062: Added new method to Update CnvrvtrshpRemoval id_victim field with the forward person id.
 * </pre>
 */

public interface CnsrvtrshpRemovalDAO {
  /**
   * This selects a row from ChildPlan given idRemovalEvent. <p/> From: Cses20d.pc
   * 
   * @param idRemovalEvent
   * @return
   */
  CnsrvtrshpRemoval findCnsrvtrshpRemoval(int idRemovalEvent);

  /**
   * for each victim in the given case that has been removed from home, get the most current removal date then find the
   * earliest date among those
   * 
   * @param idCase
   * @return
   */
  Date findEarliestCurrentRemovalDate(int idCase);

  /**
   * for each victim in the given case that has been removed from home, get the most current removal date
   * 
   * @param idCase,
   *          idVictim
   * @return
   */
  List<CnsrvtrshpRemoval> findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(int idCase, int idVictim);

  /**
   * for each victim in the given case that has been removed from home, get the most current removal date
   * 
   * @param idCase,
   *          idVictim
   * @return
   */
  CnsrvtrshpRemoval findCnsrvtrshpLatestRemovalByCaseAndByIdVictim(int idCase, int idVictim);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval} object to the database.
   * 
   * @param cnsrvtrshpRemoval
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval} object.
   */
  void saveCnsrvtrshpRemoval(CnsrvtrshpRemoval cnsrvtrshpRemoval);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval} object.
   * 
   * @param cnsrvtrshpRemoval
   */
  void deleteCnsrvtrshpRemoval(CnsrvtrshpRemoval cnsrvtrshpRemoval);

  /**
   * Select the latest removal given a stage id and event type code
   * 
   * @param idCase
   *          return cnsrvtrshpRemoval
   */
  CnsrvtrshpRemoval findLatestCnsrvtrshpRemovaltByIdCase(int idCase, Date nullDate);
  
  /**
   * Select a list of victim id's for a given person indicating the number removals
   * in open FCC or ADO stages for the passed person id, starting after the passed date.
   * Used by the Safety Resource page to validate that a child cannot be placed in a safety
   * resource while in DFCS custody.
   * 
   * @param idPerson
   * @param dtEnd
   * @return List<Integer>
   */ 
  public List<Integer> findOpenRemovalsAfterDate(int idPerson, Date dtEnd);
  
  /**
   * Retrieves DtRemoval from Cnsrvtrshp_Removal based on Person, Stage and Case.
   * 
   * @param idPerson
   * @param idCase
   * @param idPrevStage
   * @return Date
   */
  public Date findDtRemovalByIdPersonByIdCase(int idPerson,int idCase, int idPrevStage);
  
  
  /**
   * STGAP00012833: Retrieves latest DtRemoval from Cnsrvtrshp_Removal based on Case and idPerson.
   * 
   * @param idCase
   * @param idPerson
   * @return Date
   */
  Date findLatestCnsrvtrshpRemovalDatetByIdCase(int idCase, int idPerson);
  
  /**
   * Find removal that happened before a date
   * @param idPerson
   * @param idCase
   * @param beforeThisDate
   * @return
   */
  Date findDtRemovalByIdPersonIdCaseByDate(int idPerson, int idCase, Date beforeThisDate);
  
  
  /**
   * STGAP00017062: Updates CnvrvtrshpRemoval id_victim field with the forward person id.
   * @param idPersonForward
   * @param idPersonClosed
   */
  public void updateCnrvtrshpRemovalWithForwardPerson(int idPersonForward, int idPersonClosed);
}
