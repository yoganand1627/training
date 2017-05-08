/**
 * Created on Mar 25, 2006 at 3:06:05 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  4/4/2008  Corey Harden        STGAP00007558: Created new method countLegalStatusByDtLegalStatStatusDtByIdCase
 *                                 to count the number of legal status's entered on a particular date
 *                                 
 *   04/28/2009  bgehlot           STGAP00012833: Added the method findCurrentLegalStatusByIdPersonCdLegalStatuses,
 *                                 findTwelveMonthRecurrence
 *   
 *   04/29/2009  bgehlot           STGAP00012734: Added the method findLegalStatCntyByIdPersonIdStage, findMonthDiff
 *   
 *   12/04/2009  cwells            37365: Added method findLegalStatusByIdCaseByIdPerson 
 *   
 *   2/7/2010    cwells            CAPTA DEV: added findMostRecentLegalStatusByIdPersonIdCase
 *   
 *   5/11/2010   mxpatel           SMS #52233: added method findMostRecentAdoFinalizedDate
 *   05/26/2010  hjbaptiste        SMS#51977-MR66-Maltreatment In Care: Added method to check legal status view to see if child
 *                                 was in DFCS Custody at the time of an alleged incident
 *   09/15/2010  wjcochran         SMS#67942: Added method findIdCaseForLegalStatusByIdLegalStatEvent to return the
 *                                 ID_CASE of a given Legal Status Event
 *   11/08/2010  htvo              SMS#81140 - MR-074: update findMostRecentLegalStatusByIdPersonIdCase to look within the current case.
 *                                 Add findPriorLegalStatusByIdPersonIdCaseByDate, findNextLegalStatusByIdPersonIdCaseByDate 
 *   12/09/2010  schoi             SMS #81140: MR-074 Added findMostRecentLegalStatusViewByIdPersonIdCase(int idPerson, int idCase) 
 *                                 and findInDFCSCustodyLegalStatusByIdPersonByIdCaseByIdEvent(int idPerson, int idCase, int idEvent)
 *   12/10/2010  schoi             SMS #81140: MR-074 Added countCurrentLegalStatusByIdPersonIdCaseIdEventCdLegalStatStatus                                                                                          
 *   12/12/2010  schoi             SMS #81140: MR-074 Removed previously added findMostRecentLegalStatusViewByIdPersonIdCase
 *                                 and findInDFCSCustodyLegalStatusByIdPersonByIdCaseByIdEvent methods; 
 *                                 these methods are no longer needed per design change requested by the State team
 *   02/09/2011  Hai Nguyen        SMS#95590: Added new method findLegalStatusByIdVictimByIdCaseByCdLegalStatuses.                                                                                                                                                                                                          
 *   02/10/2011  Hai Nguyen        SMS#95590: Removed method findLegalStatusByIdVictimByIdCaseByCdLegalStatuses.   
 *   09/12/2011  charden           STGAP00017058 - created method countLegalStatusByStatusDtLegalStatStatusIdPerson() to find number of delinquent children          
 *   09/15/2011  charden           STGAP00017058 - created method countKennyACountyForIdPersons
 *   09/30/2011  hjbaptiste        STGAP00017011: MR-092 Fostering Connections. Added findAllLegalStatusesForCaseUsingView                                                                                                                                                                                           
 */

public interface LegalStatusDAO {
  /**
   * Counts number of legal statuses with a county of Fulton or Dekalb for the passed in persons
   * @param idPersons - persons to check for
   * @return count
   */
  public Long countKennyACountyForIdPersons(List<Integer> idPersons);
  /**
   * Retrieves the most recent Legal Status by Person Id
   * Added for calculating per diem for service that updates CSUP_PARENT_OUTBOUND table
   *
   * @param idPerson
   * @return
   */
  LegalStatus findCurrentLegalStatusbyIdPersonForPerDiem(int idPerson);
  
  /**
   * Retrieves a count of all past and current legal statuses matching the criteria
   * @param idPersons - list of persons
   * @param statuses - list of statuses
   * @param dtLegalStat - the date to compare legal statuses against
   * @return
   */
  public List<LegalStatus> countLegalStatusByStatusDtLegalStatStatusIdPerson(List<Integer> idPersons, List<String> statuses, Date dtLegalStat);
  
  /**
   * Looks in the Legal Status table for legal statuses that already exist for the same Person ID and date.
   *
   * @param idPerson
   * @param dtLegalStatStatusDt
   * @return
   */
  long countLegalStatusByDtLegalStatStatusDt(int idPerson, Date dtLegalStatStatusDt);

  /**
   * counts legal statuses in a case on a specific date for a specific person
   *
   * @param idPerson
   * @param idCase
   * @return
   */
  public long countLegalStatusByDtLegalStatStatusDtByIdCaseIdPerson(int idCase, int idPerson, Date dtLegalStatStatusDt);
  
  /**
   * Retrieves a full row from LEGAL_STATUS based on max dtLegalStatStatusDt
   *
   * @param idCase
   * @param dtLegalStatStatusDt
   * @return
   */
  LegalStatus findLegalStatusByMaxDtLegalStatStatusDt(int idPerson, int idCase);

  /**
   * Selects Cd Legal Stat Status for an Id Person from the Legal Status table.
   *
   * @param idPerson
   * @param type1
   * @return
   */
  String findCdLegalStatStatusByMaxIdLegalStatEvent(int idPerson, String type1);

  /**
   * Retrieves the most recent Legal Status by Person Id and LegalStatStatus
   *
   * @param idPerson
   * @param cdLegalStatStatus
   * @return
   */
  LegalStatus findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(int idPerson, String cdLegalStatStatus);

  /**
   * This selects the most current legal status for a particular person id.
   * <p/>
   * From: Cses32d.pc
   *
   * @param idPerson
   * @return
   */
  LegalStatus findMostRecentLegalStatusByIdPerson(int idPerson);
  
  /**
   * Finds the most current legal status for a particular person id given the id case
   * @param idPerson
   * @param idCase
   * @return
   */
  public LegalStatus findMostRecentLegalStatusByIdPersonIdCase(int idPerson, int idCase);

  /**
   * This selects the most current legal status for a particular person id and returns a map.  This DAO
   * was created for the SaveLegalServiceImpl class which needs to validate against the most recent legal status.  However
   * two persistent objects cannot be used within Hibernate which is why this method was used.
   * <p/>
   * From: Cses32d.pc
   *
   * @param idPerson
   * @return
   */
  Map findMostRecentLegalStatusIdAndCounty(int idPerson);
  
  
  /**
   * This selects the current legal status for a particular person id.
   * <p/>
   * @param idPerson
   * @return
   */  
  LegalStatus findCurrentLegalStatusByIdPerson(int idPerson);
  
  /**
   * This selects the current legal status for a particular person id.
   * <p/>
   * @param idPerson
   * @param idCase
   * @param idEvent
   * @return
   */
  Long countCurrentLegalStatusByIdPersonIdCaseIdEventCdLegalStatStatus(int idPerson, int idCase, int idEvent, String cdLegalStatStatus);

  /**
   * Find the latest legal status relative to a certain date
   * @param idPerson
   * @param dtLegalStatStatusDt
   * @return
   */
  LegalStatus findLegalStatusByIdPersonByDtLegalStatStatusDt(int idPerson, Date dtLegalStatStatusDt);
  
  /**
   * This selects the legal status for a particular idLegalStatEvent.
   * <p/>
   * From: Cses11d.pc
   *
   * @param idLegalStatEvent
   * @return
   */
  LegalStatus findLegalStatus(int idLegalStatEvent);

  /**
   * Inserting/updating an entire row of LegalStatus table.
   *
   * @param LegalStatus
   */
  void saveLegalStatus(LegalStatus legalStatus);

  /**
   * Update LegalStatus
   *
   * @param idPersMergeClosed
   * @param idPersMergeForward
   * @param idEvent
   * @return
   */
  int updateLegalStatus(int idPersMergeClosed, int idPersMergeForward, int idEvent);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.LegalStatus} object.
   *
   * @param LegalStatus
   */
  void deleteLegalStatus(LegalStatus legalStatus);
  
  /**
   * 
   * @param idStage
   * @param idPerson
   * @param cdLegalStatStatusList
   * @return
   */
  Map findLegalStatusByIdSatgeByIdPerson(int idStage, int idPerson, List<String> cdLegalStatStatusList);
  
  
  
  /**
   *  This DAO finds the latest legal action for the entire case given a list of statuses 
   * @param idCase
   * @param idPerson
   * @param cdLegalStatStatusList
   * @param dtEcdCreated
   * @return
   */
  public Map findLegalStatusByIdCaseByIdPerson(int idCase, int idPerson, List<String> cdLegalStatStatusList, Date dtEcdCreated);
  
  /**
   * @param idCase
   * @param idPerson
   * @param cdLegalStatStatus
   * @param cdStages
   * @return 
   */
  
  Map findLegalStatusByIdCaseByIdPersonByCdStatusByCdStages(int idCase, int idPerson, String cdLegalStatStatus, List<String> cdStages);
  
  
  /** 
   * STGAP00012734: Returns the Legal Status County for the person and the event
   * @param idPerson
   * @param idEvent
   * @return String
   */
   String findLegalStatCntyByIdPersonIdStage(int idPerson, int idEvent);
  
  /** 
   * STGAP00012833: Gets the month difference between the Removal Date and the dtLegalStatus
   * @param idPerson
   * @param cdLegalStatuses
   * @param dtRemoval
   * @return Float
   */
  Float findCurrentLegalStatusByIdPersonCdLegalStatuses(int idPerson, List<String> cdLegalStatuses, Date dtRemoval );
  
  /** 
   *  STGAP00012833: This method returns Y if if this child had a twelve month recurrence due to a re-entry into 
   *  foster care within twelve months of the child's previous discharge.
   * @param idStage
   * @param idCase
   * @param idPerson
   * @return Character
   */
 Character findTwelveMonthRecurrence(int idStage, int idCase, int idPerson);
 
 /**
  * MR-066: Finds an in DFCS Care legal status for a child in a case other than the case where the allegation is recorded
  * at the time of the allegation alleged incident date
  * @param idVictim
  * @param idCase
  * @param dtAllegedIncident
  * @return
  */
 List<Integer> findInDFCSCareLegalStatus(int idVictim, int idCase, Date dtAllegedIncident);

 /**
  * Finds all Legal Statuses for a child in a given case using the LEGAL_STATUS_VIEW
  * 
  * @param idVictim
  * @param idCase
  * @return
  */
 List<Object[]> findAllLegalStatusesForCaseUsingView(int idVictim, int idCase);
 
 /**
  * STGAP00012833: Gets the month difference between the Removal Date and the system date
  * @param dtRemoval
  * @param  previousMonth
  * @return
  */
 
 Float findMonthDiff(Date previousMonth, Date dtRemoval );
 Date findMostRecentAdoFinalizedDate(int idResource);

 /**
  * Return the idCase for a particular LegalStatus (implemented for SMS #67942)
  * @param idEvent
  * @return idCase for the LegalStatus
  */
 Integer findIdCaseForLegalStatusByIdLegalStatEvent(int idEvent);
 
 /**
  * Get the LS prior to a LS (defined by effective date and not the same event ) (implemented for MR-074 AFCARS)
  * explicitly excluding id event of the LS to prevent picking up itself when the LS effective date is being shifted
 * @param idPerson
 * @param idCase
 * @param aDate
 * @param idEvent
 * @return
 */
LegalStatus findPriorLegalStatusByIdPersonIdCaseByDate(int idPerson, int idCase, Date aDate, int idEvent);
 
 /**
  * Get the LS right after a LS by effective date by id event
  * explicitly excluding id event of the LS to prevent picking up itself when the LS effective date is being shifted
 * @param idPerson
 * @param idCase
 * @param afterThisDate
 * @param idEvent
 * @return
 */
LegalStatus findNextLegalStatusByIdPersonIdCaseByDate(int idPerson, int idCase, Date afterThisDate, int idEvent);


List<Map> findLegalStatusByIdStageByIdPerson(int idStage, int idPerson);
}
