/**
 * Created on Mar 25, 2006 at 2:31:39 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;

public interface EligibilityDAO {
  
  /**
   * Gets the Class of Assistance Medicaid info for the child
   * <p/>
   * This method is used for updating the CSUP_PARENT_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  String findDistinctChildCOAByIdPerson(int idPerson);
  
  /**
   * Get the current approved eligibility for a child
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param idStage
   * @return Eligibility
   */
  Eligibility findEligibilityCurrentApprovedByIdPerson(int idPerson);
  

  /**
   * Get the most recent approved eligibility in the FCC stage.
   *
   * @param idPerson
   * @return Eligibility
   */  
  Eligibility findMostRecentApprovedEligibilityinFCC( int idPerson);
  
  /**
   * Checks to see if the Ind_Elig_Csup_Send flag is set to 'Y'
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Eligibility findDistinctEligibilityByIdPersonAndIndCsupSend(int idPerson);
  /**
   * Retrieves a row from Eligibility table against the given Event ID
   * <p/>
   *
   * @param idEligEvent the id of the Eligibility Event
   * @return @link {Eligibility}
   */
  Eligibility findEligibilityByIdEligEvent(int idEligEvent);
  
  /**
   * Retrieves a row from Eligibility table against the given Person ID and the current date
   * <p/>
   *
   * @param idPerson
   * @param dtCurrentDate
   * @return Eligibility
   */
  Eligibility findEligibilityByIdPersonAndDtCurrent(int idPerson, Date dtCurrentDate);

  /**
   * Check if there's any record of this idPerson. 
   *
   * @param idPerson
   * @return The idEligEvent associated with a particular person.
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdEligEventByIdPerson(int idPerson);
  
  /**
   * Finds the number of Approved Eligibility records for a primary child on a given case excluding the passed in event
   * 
   * @param idPerson
   * @param idCase
   * @param idExcludedEvent
   * @return
   */
  Long countEligEventByIdPersonIdCaseAndExcludedEvent(int idPerson, int idCase, int idExcludedEvent);

  /**
   * Added conditional so that records that start and end on the same day are not included in the overlap/gap
   * validation.
   * <p/>
   * Check if new records overlaps other records on LEFT (works whether new record overlaps 1 or more existing records
   *
   * @param idPerson
   * @param dtEligEnd
   * @param dtEligStart
   * @return The ididEligEvents associated with the given person between the given dates.
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdEligEventOnLeft(int idPerson, Date dtEligEnd, Date dtEligStart);

  /**
   * Added conditional so that records that start and end on the same day are not included in the overlap/gap
   * validation.
   * <p/>
   * Check if new records overlaps other records on Right (works whether new record overlaps 1 or more existing records
   *
   * @param idPerson
   * @param dtEligEnd
   * @param dtEligStart
   * @return A list of idEligEvents for a particular idPerson and date range.
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdEligEventOnRight(int idPerson, Date dtEligEnd, Date dtEligStart);

  /**
   * Added conditional so that records that start and end on the same day are not included in the overlap/gap
   * validation.
   * <p/>
   * Check if new record is either identical OR within a record
   *
   * @param idPerson
   * @param dtEligEnd
   * @param dtEligStart
   * @return A list of idEligEvents for a particular idPerson and date range.
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdEligEventCheckIdentical(int idPerson, Date dtEligEnd, Date dtEligStart);

  /**
   * Check if the gap on LEFT of dtEligStart is bigger than 1 day.  SELECT statement will return record if it finds one,
   * which means gap is >= 1.0 day ==> ERROR!
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param dtEligStart
   * @return keys idPlocEvent, dtEligEnd, dtPlocDiff
   */
  Object[] findIdEligEventDtEligEndOnLeft(Date dtEligStart, int idPerson);

  /**
   * Check if the gap on Right of dtEligStart is bigger than 1 day.  SELECT statement will return record if it finds
   * one, which means gap is >= 1.0 day ==> ERROR!
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param dtEligEnd
   * @return keys idPlocEvent, dtEligStart, dtPlocDiff
   */
  Object[] findIdEligEventDtEligStartOnRight(Date dtEligEnd, int idPerson);

  /**
   * Determines if previous eligibility was court ordered.
   *
   * @param idPerson
   * @param idEligEvent
   * @return keys cdEligCsupQuest1, cdEligCsupQuest2, cdEligCsupQuest3, cdEligCsupQuest4, cdEligCsupQuest5,
   *         cdEligCsupQuest6, cdEligCsupQuest7
   */
  Map findPrevEligOrdered(int idEligEvent, int idPerson);

  /**
   * Check if there's any record at all.  It should already exist in order to do an update.
   * <p/>
   * If exists, gets START and END date for other processing (with timestamp removed.)
   * <p/>
   * Also remove timestamp on both input dates: hI_xxx because they are being used a lot. So it's better to remove them
   * once and never have to apply trunc() on these input dates again.
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param dtEligStart
   * @param dtEligEnd
   * @param dtLastUpdate
   * @param idEligEvent
   * @return keys idEligEvent, dtEligStart, dtEligEnd, truncDtEligStart, truncDtEligEnd
   */
  Object[] findIdEligEventExists(int idEligEvent, Date dtEligStart, Date dtEligEnd, int idPerson,
                                 Date dtLastUpdate);

  /**
   * If the 2 dates (i.e., hI_dtDtEligStart vs curr_ploc_start) are different then the user wants to change that end
   * (left or right) Use function sign(abs(...) to return either 0 or +1 (Start_Date = LEFT END) (End_Date   = RIGHT
   * END) 0 = No update that end (date are same) 1 = update that end    (date are different) (For some reason I cannot
   * combine these 2 SELECTs together. The compiler keeps giving errors)
   * <p/>
   * ================================================================= VALIDATE 1:  check for LEFT-SIDE  OVERLAP If new
   * START_DATE overlaps any of its LEFT record(s) (If its overlaps some, then it must at least overlaps its immediate
   * previous record, and that's what we want to know)
   * <p/>
   * ================================================================= Unlike checking for GAP_EXIST_1 and GAP_EXIST_2
   * (where we check for these gaps only if the new date for that end is different from the corresponding date in the
   * existing record) we must always check for OVERLAP_1 and OVERLAP_2. =================================================================
   *
   * @param idPerson
   * @param idEligEvent
   * @param dtEligStart
   * @param dtCurrPloc
   * @return A list of idEligEvents for a particular idPerson, dtCurPloc, and date range.
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdEventOverlapLeft(int idPerson, int idEligEvent, Date dtCurrPloc, Date dtEligStart);

  /**
   * If the 2 dates (i.e., hI_dtDtEligStart vs curr_ploc_start) are different then the user wants to change that end
   * (left or right) Use function sign(abs(...) to return either 0 or +1 (Start_Date = LEFT END) (End_Date   = RIGHT
   * END) 0 = No update that end (date are same) 1 = update that end    (date are different) (For some reason I cannot
   * combine these 2 SELECTs together. The compiler keeps giving errors)
   * <p/>
   * ================================================================= VALIDATE 1:  check for RIGHT-SIDE  OVERLAP If new
   * START_DATE overlaps any of its LEFT record(s) (If its overlaps some, then it must at least overlaps its immediate
   * previous record, and that's what we want to know)
   * <p/>
   * ================================================================= Unlike checking for GAP_EXIST_1 and GAP_EXIST_2
   * (where we check for these gaps only if the new date for that end is different from the corresponding date in the
   * existing record) we must always check for OVERLAP_1 and OVERLAP_2. =================================================================
   *
   * @param idPerson
   * @param idEligEvent
   * @param dtEligStart
   * @param dtCurrPloc
   * @return A list of idEligEvents for a particular idPerson, dtCurrPloc and date range.
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdEventOverlapRight(int idPerson, int idEligEvent, Date dtCurrPloc, Date dtEligStart);

  /**
   * Gap LEFT of dtEligStart Check this gap ONLY IF dtEligStart <> dtCurrPlocStart because: if the 2 are the same, then
   * the user does NOT want to update that end.  Only when the 2 are different does it mean that the user wants to
   * update that end
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param dtEligStart
   * @param dtCurrPlocStart
   * @return keys idEligEvent, dtEligEnd, dtEligDiff
   */
  Object[] findIdEligEventOnLeftOfDtEligStart(Date dtEligStart, int idPerson, Date dtCurrPlocStart);

  /**
   * Gap RIGHT of dtEligEnd Check this gap ONLY IF dtEligEnd <> dtCurrPlocEnd
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param dtEligEnd
   * @param dtCurrPlocEnd
   * @return keys idEligEvent, dtEligStart, dtEligDiff
   */
  Object[] findIdEligEventOnRightOfDtEligEnd(Date dtEligEnd, int idPerson, Date dtCurrPlocEnd);

  /**
   * Get the latest approved eligibility for a person in a SUB stage
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param idStage
   * @return Eligibility
   */
  Eligibility findEligibilityLatestApprovedByIdStageByIdPerson(int idStage, int idPerson);
  
  /**
   * Get the latest approved eligibility for a person in a case, determined by
   * last eligibility end date.
   * <p/>
   * 
   * @param idPerson
   * @param idCase
   * @return Eligibility
   */
  Eligibility findEligibilityLatestApprovedByIdCaseByIdPerson(int idCase, int idPerson);
  
  /**
   * Get the the count of approved eligibility for a person in a stage
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param idStage
   * @return Long
   */
  Long findEligibilityLatestApprovedCountByIdStageByIdPerson(int idStage, int idPerson);
  
  
  /**
   * Getting the most recent approved FCC Eligibility in the FCC stage 
   * @param idPerson
   * @return
   */
  public Eligibility findLatestApprovedEligibilityinFCC(int idPerson);
  
  
  /**
   * Returns the count of duplicate eligibility records for two host ID PERSONS.
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return The count of duplicate eligibility records for two host ID PERSONS.
   */
  long countEligibility(int idPersMergeForward, int idPersMergeClosed);

  /**
   * Saves or updates an {@link gov.georgia.dhr.dfcs.sacwis.db.Eligibility} object.
   *
   * @param eligibility
   */
  void saveEligibility(Eligibility eligibility);
}
