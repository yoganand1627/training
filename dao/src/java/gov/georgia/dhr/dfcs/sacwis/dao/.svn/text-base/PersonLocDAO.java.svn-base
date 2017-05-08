/**
 * Created on Mar 25, 2006 at 3:12:04 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PersonLoc;

public interface PersonLocDAO {
  /**
   * Looks in the Person LOC table for Level Care Type(Authorized) that already exist for the same Person ID and date.
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocStart
   * @return
   */
  long countPersonLocByDtPlocStart(int idPerson, String cdPlocType, Date dtPlocStart);

  /**
   * Retrieves PersonLoc by idPerson and cdPlocType
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocEnd
   * @return The PersonLoc object.
   */
  PersonLoc findPersonLocByCdPlocTypeAndIdPerson(int idPerson, String cdPlocType, Date dtPlocEnd);

  /**
   * This selects a single row from the PersonLoc table given the primary key idEvent.  It returns an array with two
   * elements.  The first element (index 0) is the PersonLoc object; the second element is the full name found by left
   * joining the Person table.
   *
   * @param idPlocEvent
   * @return See description.
   */
  Object[] findPersonLoc(int idPlocEvent);

  /**
   * This selects a single row from the PersonLoc table given idPerson and cdPlocType
   *
   * @param idPerson, cdPlocType
   * @return PersonLoc
   */

  PersonLoc findPersonLocByIdPerson(int idPerson, String cdPlocType);

  /**
   * This will retrieve all idPlocEvent ids in the PersonLoc table.
   *
   * @param idPerson
   * @param cdPlocType
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdPlocEventByIdPersonCdPlocType(int idPerson, String cdPlocType);

  /**
   * This will retrieve all idPlocEvent ids in the PersonLoc table. Added conditional so that records that start and end
   * on the same day are not included in the overlap/gap validation on the left.
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtDtPlocStart
   * @param dtDtPlocEnd
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdPlocEventOverLapGapOnLeft(int idPerson, String cdPlocType, Date dtDtPlocStart,
                                                Date dtDtPlocEnd);

  /**
   * This will retrieve all idPlocEvent ids in the PersonLoc table. Added conditional so that records that start and end
   * on the same day are not included in the overlap/gap validation on the right.
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtDtPlocStart
   * @param dtDtPlocEnd
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdPlocEventOverLapGapOnRight(int idPerson, String cdPlocType, Date dtDtPlocStart,
                                                 Date dtDtPlocEnd);

  /**
   * This will retrieve all idPlocEvent ids in the PersonLoc table. Added conditional so that records that start and end
   * on the same day are not included in the overlap/gap validation.  Check to see if these will be identical or in the
   * same record.
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtDtPlocStart
   * @param dtDtPlocEnd
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdPlocEventIdenticalOrInRecord(int idPerson, String cdPlocType, Date dtDtPlocStart,
                                                   Date dtDtPlocEnd);

  /**
   * This will retrieve all idPlocEvent, dtPlocEnd, abs(dtPlocEnd-:dtDtPlocStart) in the PersonLoc table. Added
   * conditional so that records that start and end on the same day are not included in the overlap/gap validation.
   * Check if the gap on LEFT of dtDtPlocStart is bigger than 1 day.  SELECT statement will return record if it finds
   * one, which means gap is >= 1.0 day ==> ERROR!
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtDtPlocStart
   * @return keys idPlocEvent, dtPlocEnd, dtPlocDiffDate
   */
  Object[] findIdPlocEventDtPlocEndDtDiffDateOnLeft(int idPerson, String cdPlocType, Date dtDtPlocStart);

  /**
   * This will retrieve all idPlocEvent, dtPlocEnd, abs(dtPlocEnd-:dtDtPlocStart) in the PersonLoc table. Added
   * conditional so that records that start and end on the same day are not included in the overlap/gap validation.
   * Check if the gap on RIGHT of dtDtPlocStart is bigger than 1 day.  SELECT statement will return record if it finds
   * one, which means gap is >= 1.0 day ==> ERROR!
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtDtPlocEnd
   * @return keys idPlocEvent, dtPlocEnd, dtPlocDiffDate
   */
  Object[] findIdPlocEventDtPlocEndDtDiffDateOnRight(int idPerson, String cdPlocType, Date dtDtPlocEnd);

  /**
   * Check if there's any record at all.  It should already exist in order to do an update.
   * <p/>
   * If exists, gets START and END date for other processing (with timestamp removed.)
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocStart
   * @param dtPlocEnd
   * @param idPlocEvent
   * @param dtLastUpdate
   * @return keys idPlocEvent, dtPlocStart, dtPlocEnd, truncDtPlocStart, truncDtPlocEnd
   */
  @SuppressWarnings({"unchecked"})
  Object[] findDtPlocStartDtPlocEnd(int idPerson, String cdPlocType, Date dtPlocStart, Date dtPlocEnd, int idPlocEvent,
                                    Date dtLastUpdate);

  /**
   * If the 2 dates (i.e., dtDtPlocStart vs curr_ploc_start) are different then the user wants to change that end (left
   * or right) Use function sign(abs(...) to return either 0 or +1 (Start_Date = LEFT END) (End_Date   = RIGHT END) 0 =
   * No update that end (date are same) 1 = update that end    (date are different) (For some reason I cannot combine
   * these 2 SELECTs together. The compiler keeps giving errors) =================================================================
   * VALIDATE 4: Gap LEFT of dtPlocStart Check this gap ONLY IF dtPlocStart <> curr_ploc_star because: if the 2 are the
   * same, then the user does NOT want to update that end.  Only when the 2 are different does it mean that the user
   * wants to update that end ================================================================= Unlike checking for
   * GAP_EXIST_1 and GAP_EXIST_2 (where we check for these gaps only if the new date for that end is different from the
   * corresponding date in the existing record) we must always check for OVERLAP_1 and OVERLAP_2.
   * =================================================================
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocStart
   * @return keys idPlocEvent, dtPlocEnd, dtPlocDiff
   */
  @SuppressWarnings({"unchecked"})
  Object[] findIdPlocEventDtPlocEndDtPlocDiffOnLeft(int idPerson, String cdPlocType, Date dtPlocStart);

  /**
   * If the 2 dates (i.e., dtDtPlocStart vs curr_ploc_start) are different then the user wants to change that end (left
   * or right) Use function sign(abs(...) to return either 0 or +1 (Start_Date = LEFT END) (End_Date   = RIGHT END) 0 =
   * No update that end (date are same) 1 = update that end    (date are different) (For some reason I cannot combine
   * these 2 SELECTs together. The compiler keeps giving errors) =================================================================
   * Gap RIGHT of dtPlocEnd Check this gap ONLY IF dtPlocEnd <> curr_ploc_end =================================================================
   * Unlike checking for GAP_EXIST_1 and GAP_EXIST_2 (where we check for these gaps only if the new date for that end is
   * different from the corresponding date in the existing record) we must always check for OVERLAP_1 and OVERLAP_2.
   * =================================================================
   * <p/>
   * Note that, in order to preserve table names in existing code this is a SQL query, not a HQL query.
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocEnd
   * @param currPlocEnd
   * @return keys idPlocEvent, dtPlocEnd, dtPlocDiff
   */
  @SuppressWarnings({"unchecked"})
  Object[] findIdPlocEventDtPlocEndDtPlocDiffOnRight(int idPerson, String cdPlocType, Date dtPlocEnd, Date currPlocEnd);

  /**
   * If the 2 dates (i.e., dtDtPlocStart vs curr_ploc_start) are different then the user wants to change that end (left
   * or right) Use function sign(abs(...) to return either 0 or +1 (Start_Date = LEFT END) (End_Date   = RIGHT END) 0 =
   * No update that end (date are same) 1 = update that end    (date are different) (For some reason I cannot combine
   * these 2 SELECTs together. The compiler keeps giving errors) =================================================================
   * VALIDATE 1:  check for LEFT-SIDE  OVERLAP If new START_DATE overlaps any of its LEFT record(s) (If its overlaps
   * some, then it must at least overlaps its immediate previous record, and that's what we want to know)
   * ================================================================= Unlike checking for GAP_EXIST_1 and GAP_EXIST_2
   * (where we check for these gaps only if the new date for that end is different from the corresponding date in the
   * existing record) we must always check for OVERLAP_1 and OVERLAP_2. =================================================================
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocStart
   * @param idPlocEvent
   * @param dtCurrPlocStart
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdPlocEventCheckForLeftSideOverlap(int idPerson, String cdPlocType, Date dtPlocStart,
                                                       int idPlocEvent, Date dtCurrPlocStart);

  /**
   * If the 2 dates (i.e., dtDtPlocStart vs curr_ploc_start) are different then the user wants to change that end (left
   * or right) Use function sign(abs(...) to return either 0 or +1 (Start_Date = LEFT END) (End_Date   = RIGHT END) 0 =
   * No update that end (date are same) 1 = update that end    (date are different) (For some reason I cannot combine
   * these 2 SELECTs together. The compiler keeps giving errors) =================================================================
   * VALIDATE 2:  check for RIGHT-SIDE  OVERLAP If new START_DATE overlaps any of its RIGHT record(s) (If its overlaps
   * some, then it must at least overlaps its immediate next record, and that's what we want to know)
   * ================================================================= Unlike checking for GAP_EXIST_1 and GAP_EXIST_2
   * (where we check for these gaps only if the new date for that end is different from the corresponding date in the
   * existing record) we must always check for OVERLAP_1 and OVERLAP_2. =================================================================
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocEnd
   * @param idPlocEvent
   * @param dtCurrPlocEnd
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdPlocEventCheckForRightSideOverlap(int idPerson, String cdPlocType, Date dtPlocEnd,
                                                        int idPlocEvent, Date dtCurrPlocEnd);

  PersonLoc findPersonLocByIdPersonCurrentDate(int person, String cdPlocType, Date dtScrDtCurrentDate);

  /**
   * This will retrieve idPlocEvent from PersonLoc given idPerson, idStage.
   *
   * @param idPerson
   * @param idStage
   * @return
   */
  Integer findIdPlocEventByAnyAloc(int idPerson, int idStage);

  /**
   * This will retrieve idPlocEvent from PersonLoc given idPerson, cdPlocType, dtplocStart,dtDtPlocEnd and
   * idPlocEvent.</p> <p>It validates wether new START_DATE overlaps its immediate next record.</p>
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtCurrplocEnd
   * @param dtDtPlocEnd
   * @param idPlocEvent
   * @return Integer representing the idPlocEvent
   */
  Integer findIdPlocEventDtPlocStartGreaterOrEqualDtCurrplocEnd(int idPerson, String cdPlocType,
                                                                Date dtCurrplocEnd, Date dtDtPlocEnd,
                                                                int idPlocEvent);

  /**
   * This will retrieve idPlocEvent from PersonLoc given idPerson, idStage, dtDtPlocStart, dtDtPlocEnd
   *
   * @param idPerson
   * @param idStage
   * @param dtDtPlocStart
   * @param dtDtPlocEnd
   * @return
   */
  Integer findIdPlocEventByDtEndNotEqlDtStart(int idPerson, int idStage, Date dtDtPlocStart, Date dtDtPlocEnd);

  /**
   * This will retrieve idPlocEvent from PersonLoc given idPerson, idStage, dtDtPlocStart, dtDtPlocEnd
   *
   * @param idPerson
   * @param idStage
   * @param dtDtPlocStart
   * @param dtDtPlocEnd
   * @return
   */
  Integer findIdPlocEventByDtStartNotEqlDtEnd(int idPerson, int idStage, Date dtDtPlocStart, Date dtDtPlocEnd);

  /**
   * This will retrieve idPlocEvent dtPlocEnd dtPeriod from PersonLoc given idPerson, idStage, dtDtPlocStart
   *
   * @param idPerson
   * @param idStage
   * @param dtDtPlocStart
   * @return
   */
  Object[] findIdPlocEventDtPlocEndByMaxDtPlocEnd(int idPerson, int idStage, Date dtDtPlocStart);

  /**
   * This will retrieve idPlocEvent dtPlocEnd dtPeriod from PersonLoc given idPerson, idStage, dtDtPlocStart,
   * dtDtPlocEnd
   *
   * @param idPerson
   * @param idStage
   * @param dtDtPlocStart
   * @param dtDtPlocEnd
   * @return
   */
  Object[] findIdPlocEventDtPlocEndByMinDtPlocStart(int idPerson, int idStage,
                                                    Date dtDtPlocStart, Date dtDtPlocEnd);

  /**
   * This will retrieve idPlocEvent from PersonLoc given idPerson, cdPlocType, currDtPlocStart, dtDtPlocStart
   *
   * @param idPerson
   * @param cdPlocType
   * @param currDtPlocStart
   * @param dtDtPlocStart
   * @param idPlocEvent
   * @return
   */
  Integer findIdPlocEventByCurrDtPlocStart(int idPerson, String cdPlocType, Date currDtPlocStart, Date dtDtPlocStart,
                                           int idPlocEvent);

  /**
   * Finds information about an PersonLoc record based on dtPlocStart, idPerson, idStage, and currPlocStart.
   *
   * @param dtPlocStart
   * @param idPerson
   * @param idStage
   * @param currPlocStart
   * @return
   */
  Object[] findPlocByDtPlocStartIdPersonIdStageAndCurrPlocStart(Date dtPlocStart, int idPerson, int idStage,
                                                                Date currPlocStart);

  /**
   * Finds information about an PersonLoc record based on dtPlocEnd, idPerson, idStage, and currPlocStart.
   *
   * @param dtPlocEnd
   * @param idPerson
   * @param idStage
   * @param dtCurrPlocEnd
   * @return
   */
  public Object[] findPlocByDtPlocEndIdPersonIdStageDtCurrPlocEnd(Date dtPlocEnd, int idPerson, int idStage,
                                                                  Date dtCurrPlocEnd);

  /**
   * Finds information about a PersonLoc record based on idPerson, idStage, dtPlocStart and dtPlocEnd.
   *
   * @param idPerson
   * @param idStage
   * @param dtPlocStart
   * @param dtPlocEnd
   * @return
   */
  public Integer findPersonLocIdPlocEvent(int idPerson, int idStage, Date dtPlocStart, Date dtPlocEnd);

  /**
   * Finds information about a PersonLoc record based on dtPlocStart, dtPlocEnd, idPlocEvent, tsLastUpdate,  and
   * idPerson.
   *
   * @param dtPlocStart
   * @param dtPlocEnd
   * @param idPlocEvent
   * @param tsLastUpdate
   * @param idPerson
   * @return
   */
  public Object[] findPersonLocIdPlocEvent(Date dtPlocStart, Date dtPlocEnd, int idPlocEvent,
                                           Date tsLastUpdate, int idPerson);

  /**
   * Partial insert of PersonLoc table using the supplied parameters(column values). (Note that the insert is done using
   * straight SQL)
   *
   * @param idPerson
   * @param cdPlocChild
   * @param cdPlocType
   * @param dtPlocEnd
   * @param dtPlocStart
   * @param indPlocCsupSend
   * @param indPlocWriteHistory
   * @param idPersUpdt
   * @param cdRevType           return int The number of entities effected by the 'insert' operation.
   */
  int insertPersonLoc(int idPerson, String cdPlocChild, String cdPlocType, Date dtPlocEnd, Date dtPlocStart,
                      String indPlocCsupSend, String indPlocWriteHistory, int idPersUpdt, String cdRevType);

  /**
   * Partial insert of PersonLoc table using the supplied parameters(column values). (Note that the insert is done using
   * straight SQL)
   *
   * @param idPlocEvent
   * @param tsLastUpdate
   * @param idPerson
   * @param cdPlocChild
   * @param cdPlocType
   * @param dtPlocEnd
   * @param dtPlocStart
   * @param indPlocCsupSend
   * @param indPlocWriteHistory
   * @param idPersUpdt
   * @param cdRevType           return int The number of entities effected by the 'insert' operation.
   */
  int insertPersonLoc(int idPlocEvent, int idPerson, String cdPlocChild, String cdPlocType,
                      Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend, String indPlocWriteHistory,
                      int idPersUpdt, String cdRevType);

  /**
   * Partial update of PersonLoc table using the supplied parameters(column values).
   *
   * @param idPerson
   * @param cdPlocChild
   * @param dtPlocEnd
   * @param dtPlocStart
   * @param indPlocCsupSend
   * @param indPlocWriteHistory
   * @param idPersUpdt
   * @param cdRevType
   * @param idPlocEvent
   * @param lastUpdate          return int The number of entities effected by the 'update' operation.
   */
  int updatePersonLoc(int idPerson, String cdPlocChild, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                      String indPlocWriteHistory, int idPersUpdt, String cdRevType, int idPlocEvent,
                      Date lastUpdate);
}
