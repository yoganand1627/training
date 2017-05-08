/**
 * Created on Mar 25, 2006 at 3:33:22 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This is the DAO class is used for the STAGE table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/04/08  SWR       STGAP00009080 - Added findOtherOpenStagesInCase() to support
 *                      edits required for MR-005 'Opened in Error' closure reason in 
 *                      Investigation
 *  07/10/08  arege     STGAP00008896       Added updateStageClearIdCaseByIdStage()     
 *  
 *  07/22/08  arege     STGAP00009014 Added method to update the Stage table, the Comments under Response Time 
 *                      Section on IntakeClosure page are saved to the column TXT_STAGE_RES_TIME_CMNTS
 *                      in Stage table.
 *  03/04/09  bgehlot   STGAP00012734: Gets the stage id of the active stage for a given case id and cd_stage.
 *  06/12/09  mxpatel   STGAP00013002: wrote the method findCdStageByIdStage.
 *  07/23/09  bgehlot  STGAP00014341: Added method updateStageAsgnmtHistory, deleteStageAsgnmtHistory
 *  02/23/10  wjcochran MR-62 Added method findStageByIdCaseAndCdStageSet That will look up a series of
 *                      stages for a particular case (i.e. - 'ONG', 'PAD' stages for a case idCase)
 *  08/30/10  wjcochran SMS #66752: Added new method, updateSummaryRedFlagCaseStages, to update the 
 *                      IND_RED_FLAG field in the STAGE table
 *  03/20/11  htvo      SMS#97845 MR-074-2 AFCARS: added findIdCaseByIdPersonCdRoleCdStageDtStageStart
 *  08/24/11  schoi     STGAP00017013: MR-095 Added findOpenStagesByIdCaseByIdPersonNotExistsInSPL
 *  10/06/11  schoi     STGAP00017013: MR-095 Added new method findMostRecentIdStageByIdCaseAndCdStage
 *  02/10/12  htvo      STGAP00017831: MR-102 - Added findIdCasesByIdCaseCdStageCdStageReasonClosed
 * </pre>
 */

public interface StageDAO {
  /**
   * Retrieves count cdStage from Stage
   *
   * @param idEvent
   * @return A count of cdStage's for an event.
   */
  long countCdStage(int idEvent);

  /**
   * @param idCase
   * @param idStage
   * @return A list of stage ids associated with the given case id.
   */  
  List<Integer> findSubStagesByCaseId(int idCase, String cdStage, String indStageClosure); 
  /**
   * Retrieves a stage object with the situation object pre-fetched.
   *
   * @param idStage
   * @return A {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} object with the {@link gov.georgia.dhr.dfcs.sacwis.db.Situation}
   *         object pre-fetched.
   */
  Stage findStageAndSituation(int idStage);

  /**
   * @param idCase
   * @param principalsForEvent
   * @return
   */
  List<Integer> findStagesNotHaveWTLP(int idCase, Collection<Integer> principalsForEvent);

  /** Find sub or ado stage that the primary child either never has Child Detail completed or has one Child Detail that 
   * is not completed (Child might have more than one Child Detail completed for)
   * @param idCase
   * @param principalsForEvent
   * @return
   */
  List<Integer> findStagesNotHaveChildDetailCompleted(int idCase, Collection<Integer> principalsForEvent);

  /**
   * This selects all the id_stages for all duplicate rows in the stage_person_link table due to problems with case
   * merges. <p/>
   *
   * @param idPersMergeClosed
   * @param idPersMergeForward
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} objects.
   */
  List<Integer> findStageIdSategeForAllDupliactes(int idPersMergeClosed, int idPersMergeForward);

  /**
   * This selects a row from Stage given the idCase. <p/>
   *
   * @param idCase
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} objects.
   */
  List<Stage> findStageByIdCase(int idCase);
  
  /**
   * This selects a row from Stage given the idCase and cdStage. <p/>
   *
   * @param idCase
   * @param cdStage
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} objects.
   */
  List<Stage> findStageByIdCaseAndCdStage(int idCase, String cdStage);
  
  /**
   * Finds a list a stages given a case id and stage type
   * @param idCase
   * @param cdStage
   * @return List <Stage>
   */
  ArrayList<Integer> findStageIdsByIdCaseAndCdStage(int idCase, String cdStage);
  
  /**
   * Finds all Closed Stages of a given type prior to a given date for a given person. 
   * @param idPerson
   * @param cdStage
   * @param dtStageStart
   * @return List<Stage>
   */
  public List<Stage> findClosedStageByIdPersonCdStageDtStart(int idPerson, String cdStage, Date dtStageStart);
  
  
  /**
   * Finds all Closed Stages of a given type prior to a given date for a list of persons. 
   * @param idPersons
   * @param cdStage
   * @param dtStageStart
   * @return
   */
  public List<Stage> findClosedStageByPersonListCdStageDtStart(List<Integer> idPersons, String cdStage, Date dtStageStart);
  
  /**
   * Finds all Stages of a given type prior to a given date for a list of persons
   * @param idPersons
   * @param dtStageStart
   * @return
   */
  public Long findClosedStageByPersonListDtStart(List<Integer> idPersons, Date dtStageStart);
  
  
  /**
   * This will look up a series of Stages given an idCase and a 
   * group of cdStage values.
   * @param idCase
   * @param cdStage
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} objects.
   */
  List<Stage> findStageByIdCaseAndCdStageSet(int idCase, Set<String> cdStage);

  /**
   * This select a row from Stage given the idCase and cdStage in a descending order
   * @param idCase
   * @param cdStage
   * @return List<Stage>
   */
  public List<Stage> findStageByIdCaseAndCdStageDesc(int idCase, String cdStage);

  /**
   * This selects a row from Stage given the idCase and cdStage. <p/>
   *
   * @param idCase
   * @param cdStage
   * @return stage id for FA Home.
   */
  Integer findIdStageByIdCaseAndCdStage(int idCase, String cdStage);
  
  /**
   * This selects a row from Stage given the idCase and cdStage. <p/>
   *
   * @param idCase
   * @param cdStage
   * @return the most recent idStage
   */
  Stage findMostRecentIdStageByIdCaseAndCdStage(int idCase, List<String> cdStage, int idStage);
  
  /**
   * This selects a full row from the STAGE and CAPS_CASE tables. <p/>
   *
   * @param idStage
   * @return A {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} object with the {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCase}
   *         object pre-fetched.
   */
  Stage findStageAndCapsCase(int idStage);

  /**
   * This selects a full row from the STAGE table by the Stage ID. <p/> From cses71.pc
   *
   * @param idStage
   * @return Stage by idStage
   */
  Stage findStageByIdStage(int idStage);

  /**
   * This selects a the Stage name from the STAGE table by the Stage ID. <p/>
   *
   * @param idStage
   * @return String representing the Stage name
   */
  String findNmStageByIdStage(int idStage);
  
  /**
   * Retrieve all stages for a case.
   *
   * @param idCase
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} objects.
   */
  List<Stage> findStagesByIdCase(int idCase);

  /**
   * This selects a row from Stage given the idStag and role 'pr'.
   *
   * @param idStage
   * @return A list of information about a stage.
   */
  Integer findStageByIdStageAndIdPersonAndRole(int idStage);

  /**
   * Retrieves ID_CASE from Stage table given idStage.
   *
   * @param idStage
   * @return The idCase for the specified stage.
   */
  Integer findStageIdCaseByIdStage(int idStage);

  /**
   * This retrieves all the ID STAGE's (and their corresponding CD STAGE) associated with an ID STAGE given as input.
   * These stages are all the open stages associated with ID CASE. <p/>
   *
   * @param idCase
   * @return keys idStage, cdStage
   */
  List<Map> findStageByIdCaseDtStageClose(int idCase);

  /**
   * This gets a count of open stages that an idPerson is involved, and where that person is not a STAFF member.
   *
   * @param idPerson
   * @return Integer
   */
  long countOpenStagesByIdPersonAndIdStages(int idPerson);

  /**
   * Retrieves list of rows from Stage table by querying Stage and StagePersonLinkTable for the given idPerson and
   * cdStagePersRole = 'PC'
   *
   * @param idPerson
   * @return List of Stage objects
   */
  PaginatedHibernateList<Stage> findStageByIdPerson(int idPerson, int pageNbr, int pageSize);

  /**
   * Retrieves dtLastUpdate from the Stage table given the idStage.
   *
   * @param idStage
   * @return Date representing dtLastUpdate Timestamp
   */
  Date findStageDtLastUpdate(int idStage);

  /**
   * Retrieves the count from Stage/StagePersonLink tables for the given idPerson and idCase. ie.Retrieves the count
   * from the Stage table where the idPerson entered along with the idCase match an idPerson, (primary worker) in one of
   * the stages in the case.
   *
   * @param idPerson
   * @param idCase
   * @return Integer
   */
  long countStageByIdPersonIdCase(int idPerson, int idCase);

  /**
   * Return the Stage CD for the specified idCase CD Stage
   *
   * @param idCase
   * @return String
   */
  String findCdStageByIdCase(int idCase);

  /**
   * Retrieves columns idStage, cdStage, cdStageProgram, cdStageType, cdStageCnty, nmStage and idCase from Stage table;
   * nmPersonFull from Person table;idPerson, cdStagePersRole, idStagePersonLink and dtLastUpdate from StagePersonLink
   * table;nmCase from CapsCase table for the given idStage and ORDER the results BY cdStagePersRole(from
   * StagePersonLink table)
   *
   * @param idStage
   * @return List of Map objects, each Map encapsulating a row of columns retrieved by the query.
   */
  List<Map> findStageByIdStageAndOrderByCdStagePersRole(int idStage);

  /**
   * This finds stage information for the case summary page. Since it is one of the most often used pages in the entire
   * system, it is implemented in straight SQL to maximize performance. <p/> This version is for the CPS program; there
   * is also a version for the Licensing program. <p/> The return array has the following information: <p/>
   * <p/>
   * <pre>
   *    String nmStage = szNmStage = S.NM_STAGE = row[0]
   *    String cdStage = szCdStage = S.CD_STAGE = row[1]
   *    String cdStageType = szCdStageType = S.CD_STAGE_TYPE = row[2]
   *    String dtStageStart = dtDtStageStart = S.DT_STAGE_START = row[3]
   *    String dtStageClose = dtDtStageClose = S.DT_STAGE_CLOSE = row[4]
   *    String cdStageRegion = szCdStageRegion= S.CD_STAGE_REGION = row[5]
   *    String idSituation = szCdStageProgram = S.CD_STAGE_PROGRAM = row[6]
   *    String idSituation = ulIdSituation = S.ID_SITUATION = row[7]
   *    String idStage = ulIdStage = S.ID_STAGE = row[8]
   *    String cdStageREasonClosed = szCdStageReasonClosed = S.CD_STAGE_REASON_CLOSED = row[9]
   *    String idPerson = ulIdPerson = L.ID_PERSON = row[10]
   *    String cdCpsInvstOverallDisp = CdCpsOverallDisptn = A.CD_CPS_INVST_OVRALL_DISP = row[11]
   * </pre>
   *
   * @param idCase
   * @param cdStagePersRole
   * @param scrCdStagePersRole
   * @return An {@link Object}[] of information about the stages for the case. See description for details.
   */
  PaginatedHibernateList<Object[]> findCPSCaseSummaryStages(int idCase, String cdStagePersRole,
                                                            String scrCdStagePersRole, int pageNbr, int pageSize);
  
  /**
   * This finds stage information for the case summary page excluding the sealed records by checking caps_case.Ind_Case_Sealed. 
   * If the Sealed Indicator is Y, then remove ADO and FCC stages from the result. Since it is one of the most often used pages 
   * in the entire system, it is implemented in straight SQL to maximize performance. 
   * <p/> This version is for the CPS program; there is also a version for the Licensing program. <p/> 
   * The return array has the following information: <p/>
   * <p/>
   * <pre>
   *    String nmStage = szNmStage = S.NM_STAGE = row[0]
   *    String cdStage = szCdStage = S.CD_STAGE = row[1]
   *    String cdStageType = szCdStageType = S.CD_STAGE_TYPE = row[2]
   *    String dtStageStart = dtDtStageStart = S.DT_STAGE_START = row[3]
   *    String dtStageClose = dtDtStageClose = S.DT_STAGE_CLOSE = row[4]
   *    String cdStageRegion = szCdStageRegion= S.CD_STAGE_REGION = row[5]
   *    String idSituation = szCdStageProgram = S.CD_STAGE_PROGRAM = row[6]
   *    String idSituation = ulIdSituation = S.ID_SITUATION = row[7]
   *    String idStage = ulIdStage = S.ID_STAGE = row[8]
   *    String cdStageREasonClosed = szCdStageReasonClosed = S.CD_STAGE_REASON_CLOSED = row[9]
   *    String idPerson = ulIdPerson = L.ID_PERSON = row[10]
   *    String cdCpsInvstOverallDisp = CdCpsOverallDisptn = A.CD_CPS_INVST_OVRALL_DISP = row[11]
   * </pre>
   *
   * @param idCase
   * @param cdStagePersRole
   * @param scrCdStagePersRole
   * @return An {@link Object}[] of information about the stages for the case. See description for details.
   */
  PaginatedHibernateList<Object[]> findCPSSealedCaseSummaryStages(int idCase, String cdStagePersRole,
                                                            String scrCdStagePersRole, int pageNbr, int pageSize);

  /**
   * This DAM will return a full row from STAGE and STAGE PERS Link given an ID STAGE. <p/>
   * <p/>
   * <pre>
   *    int idStage = S.ID_STAGE = row[0]
   *    Date dtLastUpdate = S.DT_LAST_UPDATE = row[1]
   *    String cdStageType = S.CD_STAGE_TYPE = row[2]
   *    int idUnit = S.ID_UNIT = row[3]
   *    int idCase = S.ID_CASE = row[4]
   *    int idSituation = S.ID_SITUATION = row[5]
   *    Date dtStageClose = S.DT_STAGE_CLOSE = row[6]
   *    String cdStageClassification = S.CD_STAGE_CLASSIFICATION = row[7]
   *    String cdStageCurrPriority = S.CD_STAGE_CURR_PRIORITY = row[8]
   *    String cdStageInitialPriority = S.CD_STAGE_INITIAL_PRIORITY = row[9]
   *    String cdStageReasonClosed = S.CD_STAGE_REASON_CLOSED = row[10]
   *    String cdStageRsnPriorityChgd = S.CD_STAGE_RSN_PRIORITY_CHGD = row[11]
   *    String indStageClosed = S.IND_STAGE_CLOSE = row[12]
   *    String cdStageCnty = S.CD_STAGE_CNTY = row[13]
   *    String nmStage = S.NM_STAGE = row[14]
   *    String cdStageRegion = S.CD_STAGE_REGION = row[15]
   *    Date dtStageStart = S.DT_STAGE_START = row[16]
   *    String cdStageProgram = S.CD_STAGE_PROGRAM = row[17]
   *    String cdStage = S.CD_STAGE = row[18]
   *    String txtStagePriorityCmnts = S.TXT_STAGE_PRIORITY_CMNTS = row[19]
   *    String txtStageClosureCmnts = S.TXT_STAGE_CLOSURE_CMNTS = row[20]
   *    int idStagePersonLink = SPL1.ID_STAGE_PERSON_LINK = row[21]
   *    Date dtLastUpdate = SPL1.DT_LAST_UPDATE = row[22]
   *    int idPerson = SPL1.ID_PERSON = row[23]
   *    String cdStagePersRole = SPL1.CD_STAGE_PERS_ROLE = row[24]
   *    String indStagePersInLaw = SPL1.IND_STAGE_PERS_IN_LAW = row[25]
   *    String cdStagePersType = SPL1.CD_STAGE_PERS_TYPE = row[26]
   *    String cdStagePersSearchInd = SPL1.CD_STAGE_PERS_SEARCH_IND = row[27]
   *    String txtStagePersNotes = SPL1.TXT_STAGE_PERS_NOTES = row[28]
   *    Date dtStagePersLink = SPL1.DT_STAGE_PERS_LINK = row[29]
   *    String cdStagePersRelInt = SPL1.CD_STAGE_PERS_REL_INT = row[30]
   *    String indStagePersReporter = SPL1.IND_STAGE_PERS_REPORTER = row[31]
   *    String indStagePersEmpNew = SPL1.IND_STAGE_PERS_EMP_NEW = row[32]
   * </pre>
   *
   * @param idStage
   * @param idStageRelated
   * @return An {@link Object}[] of information about the stages and stagePersonLink
   */
  List<Object[]> findStageStagePersonLinkByIdStageAndIdStageRelated(int idStage, int idStageRelated);

  /**
   * This is an update/insert for stage info.
   *
   * @param stage
   */
  void saveStage(Stage stage);

  /**
   * Partial update of Stage table using the supplied parameters(column values).
   *
   * @param dtStageClose
   * @param cdStageReasonClosed
   * @param txtStageClosureCmnts
   * @param lastUpdate
   * @param idStage
   */
  int updateStage(Date dtStageClose, String cdStageReasonClosed, String txtStageClosureCmnts, Date lastUpdate,
                  int idStage);

  /**
   * Updates table Stage, fields cdStageRegion and cdStageCnty given idStage <p/>
   *
   * @param idStage
   * @param cdStageRegion
   * @param cdStageCnty
   */
  int updateStageCdStageRegioncCStageCntyByIdStage(int idStage, String cdStageRegion, String cdStageCnty);

  /**
   * Updates table Stage, fields idUnit, cdStageRegion given idUnit <p/>
   *
   * @param idUnit
   */
  int updateStageIdUnitCdStageRegionByIdUnit(int idUnit);

  /**
   * Updates table Stage, field idUnit given idStage <p/>
   *
   * @param idStage
   * @param idPerson
   */
  int updateStageIdUnitByIdStageAndUnitEmpLinkIdUnit(int idStage, int idPerson);

  /** 
   * Updates table Stage, field idUnit given idStage <p/>
   *
   * @param idUnit
   * @param idStage
   */
  int updateStageIdUnitByIdStage(int idUnit, int idStage);

  /**
   * Partial update of Stage table using the supplied parameters(column values).
   *
   * @param dtStageClose
   * @param cdStageReasonClosed
   * @param idStage
   */
  int updateStageDtStageCloseCdStageReasonClosed(Date dtStageClose, String cdStageReasonClosed, int idStage);

  /**
   * Partial update of Stage table using the supplied parameters(column values).
   *
   * @param nmCase
   * @param idStage
   */
  int updateStageNmStage(String nmCase, int idStage);

  /**
   * Change the Stage Name for all open APS stages where the original Stage Name is equal to a given NM PERSON FULL and
   * the ID PERSON is linked to the stage as a victim or client
   *
   * @param nmStage
   * @param nmPersonFull
   * @param idPerson
   * @param maxDate
   * @return The number of rows affected.
   */
  int updateStage(String nmStage, String nmPersonFull, int idPerson, Date maxDate);

  /**
   * Inserts a new case with an idCase
   *
   * @param idStage
   * @param cdStageType
   * @param idCase
   * @param dtStageClose
   * @param cdStageClassification
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param indStageClose
   * @param cdTxtStagePriorityCmnts
   * @param cdStageCnty
   * @param cdNmStage
   * @param cdStageRegion
   * @param dtStageStart
   * @param idSituation
   * @param cdStageProgram
   * @param cdStage
   * @param cdTxtStageClosureCmnts
   * @param idUnit
   * @param cdStageScroutReason
   * @param cdTxtStageSplInstrtCmnt
   * @return The number of rows affected.
   */
  int insertStageWithIdCase(int idStage, String cdStageType, Integer idCase, Date dtStageClose,
                            String cdStageClassification, String cdStageCurrPriority, String cdStageInitialPriority,
                            String cdStageRsnPriorityChgd, String cdStageReasonClosed, String indStageClose,
                            String cdTxtStagePriorityCmnts, String cdStageCnty, String cdNmStage, String cdStageRegion,
                            Date dtStageStart, Integer idSituation, String cdStageProgram, String cdStage,
                            String cdTxtStageClosureCmnts, int idUnit, String cdStageScroutReason,
                            String cdTxtStageSplInstrtCmnt);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} object to the database.
   *
   * @param idUnit
   * @param cdStageClassification
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param nmStage
   * @param dtIncomingCall
   * @param cdStageProgram
   * @param cdStage
   * @param cdStageScroutReason
   * @param txtStageSplInstrtCmnt
   * @param idStage
   * @param tsLastUpdate
   * @param txtStagePriorityCmnts
   * @return Integer
   */
  int updateIntakeStageByIdStageAndDtLastUpdate(int idUnit, String cdStageClassification, String cdStageCurrPriority,
                                                String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                                String cdStageReasonClosed, String nmStage, Date dtIncomingCall,
                                                String cdStageProgram, String cdStage, String cdStageScroutReason,
                                                String txtStageSplInstrtCmnt, int idStage, Date tsLastUpdate,
                                                String txtStagePriorityCmnts);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} object to the database.
   *
   * STGAP00008086 added the cdStageScroutReason parameter to support Intake Closure.
   *
   * @param cdStageType
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param txtStagePriorityCmnts
   * @param txtStageClosureCmnts
   * @param tsLastUpdate
   * @param cdStageScroutReason
   * @param idStage
   * @return Integer
   */
  int updateStageByIdStageAndDtLastUpdate(String cdStageType, String cdStageCurrPriority,
                                          String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                          String cdStageReasonClosed, String txtStagePriorityCmnts,
                                          String txtStageClosureCmnts, Date tsLastUpdate, 
                                          String cdStageScroutReason, int idStage);
  
  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.Stage} object to the database.
   *
   * STGAP00009014 This method updates the Stage table, the Comments under Response Time Section 
   *               on Intake Closure page are saved to the column TXT_STAGE_RES_TIME_CMNTS
   *               in Stage table.
   *
   * @param cdStageType
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param txtStageResponseTimeCmnts
   * @param txtStageClosureCmnts
   * @param tsLastUpdate
   * @param cdStageScroutReason
   * @param idStage
   * @return Integer
   */
  int updateStageByIdStageAndDtLastUpdateAndResTimeCmnts(String cdStageType, String cdStageCurrPriority,
                                          String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                          String cdStageReasonClosed, String txtStageResponseTimeCmnts,
                                          String txtStageClosureCmnts, Date tsLastUpdate, 
                                          String cdStageScroutReason, int idStage);
  
  
  

  /**
   * Updates a Stage row
   *
   * @param cdStageType
   * @param idCase
   * @param dtStageClose
   * @param cdStageClassification
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param indStageClose
   * @param cdTxtStagePriorityCmnts
   * @param cdStageCnty
   * @param cdNmStage
   * @param cdStageRegion
   * @param dtStageStart
   * @param idSituation
   * @param cdStageProgram
   * @param cdStage
   * @param cdTxtStageClosureCmnts
   * @param idUnit
   * @param idStage
   * @return The number of rows affected.
   */
  int updateStageWithIdCase(String cdStageType, int idCase, Date dtStageClose, String cdStageClassification,
                            String cdStageCurrPriority, String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                            String cdStageReasonClosed, String indStageClose, String cdTxtStagePriorityCmnts,
                            String cdStageCnty, String cdNmStage, String cdStageRegion, Date dtStageStart,
                            int idSituation, String cdStageProgram, String cdStage, String cdTxtStageClosureCmnts,
                            int idUnit, int idStage);

  /**
   * Clear stage reason closed for the specified idStage
   *
   * @param idStage
   * @return The number of rows affected.
   */
  int updateStageSetCdStageReasonClosed(int idStage);
  
  /**
   * Updates Stage table to indicate if the Stage has been verified
   * @param idStage
   * @param indEcsVer
   * @return int representing the number of rows affected.
   */
  int updateStageIndEcsVerified(int idStage, String indEcsVer);

  /**
   * Updates the Stage table to indicate if the Stage is
   * part of a Red Flag case.
   * @param idStage
   * @param indRedFlag
   * @return
   */
  int updateStageIndRedFlag(int idStage, String indRedFlag);

  /**
   * Delete rows from Stage based on idStage.
   *
   * @param idStage
   */
  int deleteStage(int idStage);

  /**
   * Partial update of Stage table using the supplied parameters(column values).
   *
   * @param dtStageStart
   * @param idStage
   */
  int updateStage(Date dtStageStart, int idStage);

  /**
   * Partial update of Stage table using the supplied parameters(column values).
   *
   * @param szCdStageCnty
   * @param idStage
   */
  int updateStageCdStageCnty(int idStage, String szCdStageCnty);

  /**
   * Select rows from Stage,CapsCase and StagePersonLink tables by using idPerson
   *
   * @param idPerson
   * @return Information about stages by person.
   */
  List<Map> findStageByIdPersonInput(int idPerson);

  /**
   * Returns the stage id of the subcare stage for that person
   *
   * @param cdStage
   * @param idPriorStage
   * @param idPerson
   * @param cdStagePersRole
   * @return stage id.
   */
  Integer findStageByStageByIdPriorStage(String cdStage, int idPriorStage, int idPerson, String cdStagePersRole);
  
  /**
   * Used exclusively for stage that is multiple for a case (FCC, e.g.)
   * @param idCase
   * @param cdStage
   * @return
   */
  List<Map> findOpenStagesByIdCaseCdStage(int idCase, String cdStage);
  
  // STGAP00017013: MR-095
  /**
   * Finds Open Stages in the same Case where the Person is not included the SPL except the idStage
   * 
   * @param idCase
   * @param idStage
   * @param idPerson
   * @param cdStages
   * @return
   */
  List<Stage> findOpenStagesByIdCaseByIdPersonNotExistsInSPL(int idCase, int idStage, int idPerson, List<String> cdStages);
  
  /**
   * Finds Stages child is identified as the primary child for a case 
   * @param idCase
   * @param cdStages
   * @param idPerson
   * @return
   */
  public List<Map> findStagesByIdCaseCdStagesIdPrimary(int idCase, Collection<String> cdStages, int idPerson);
  
  
  /**
   * Find all open stages of a case
   * @param idCase
   * @return
   */
  List<Stage> findOpenStagesByIdCase(int idCase);

  /**
   * Find indStageClose value to determine if stage is closed.
   * @param idStage
   * @param idCase
   * @return
   */
  String indStageClose(int idStage, int idCase);
  
  /**
   * Find the county of the latest stage for a person
   * @param idPerson
   * @return cdStageCnty
   */
  String findStageCountyForPerson(int idPerson);
  
  /**
   * Finds open stages where the child is the primary and given the person id, case id, stage types, and 
   * date to compare.  
   * @param cdStages
   * @param idPerson
   * @param dtCaseSt
   * @return
   */
  public List<Map> findOpenStagesByIdCaseCdStagesIdPrimary(Collection<String> cdStages, int idPerson, Date dtCaseSt);
  
  
  
  /**
   * Finds open stages in case other than the stage provided.  Added
   * for STGAP00009080 (MR-005 - Opened in Error).
   * @param idCase - Case ID to use in query critiera
   * @param idStage - Stage ID to use in query criteria
   * @return List<Stage>
   */
  List<Stage> findOtherOpenStagesInCase (int idCase, int idStage);
  
  /** 
   * STGAP0000
   * @param idStage
   * 
   */
  int updateStageClearIdCaseAndIdSituationByIdStage(int idStage);
  /**
   * Count the total number of ADO stages for the given idPerson and idStage
   * @param idPerson
   * @param idCase
   * @return count
   */
  long countOpenAdoStageByIdPersonIdCase(int idPerson, int idCase);
  
  /**
   * Gets the FCC stage for the given person in the given case
   * @param idCase
   * @param idPerson
   * @parm cdStage
   * @return
   */
  Integer findStageByIdCaseIdPerson(int idCase, int idPerson, String cdStage);
  
  /**
   * Mark the stages in the list as SAU Sealed
   * @param idStageList
   * @return
   */
  @SuppressWarnings({"unchecked"})
  int updateStageMarkStageSealed(Collection idStageList);
  
  /**
   * Mark the stages in the list as Sensitive
   * @param idStageList
   * @return
   */
  @SuppressWarnings({"unchecked"})
  int updateStageMarkStageSensitive(Collection idStageList);
  
  /**
   * Get the list of open stages in the given case
   * @param idCase
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdStagesOfOpenStagesByIdCase(int idCase);
  
  /**
   * Insert or update a stage row
   * @param stage
   * @return
   */
  int saveOrUpdateStage(Stage stage);
  
  /**
   * Update the stage record with the idUnit and idSituation for the given idStage
   * @param idUnit
   * @param idStage
   * @param idSituation
   * @return
   */
  int updateStageIdUnitByIdStageIdSituation(int idUnit, int idStage, int idSituation);
  
  /**
   * This finds stage information for the case summary page. Since it is one of the most often used pages in the entire
   * system, it is implemented in straight SQL to maximize performance. <p/> This version is for the PAD Cases; If the 
   * user accessing the page has SAU Sealed attribute, than in addition to the stages in the current case, all the stages in the
   * old case where the ADO stage for this child exists, should be listed on the case summary page. So both the PAD case Id
   * and the ADO case ids are passed to get the stages: <p/>
   * <p/>
   * <pre>
   *    String nmStage = szNmStage = S.NM_STAGE = row[0]
   *    String cdStage = szCdStage = S.CD_STAGE = row[1]
   *    String cdStageType = szCdStageType = S.CD_STAGE_TYPE = row[2]
   *    String dtStageStart = dtDtStageStart = S.DT_STAGE_START = row[3]
   *    String dtStageClose = dtDtStageClose = S.DT_STAGE_CLOSE = row[4]
   *    String cdStageRegion = szCdStageRegion= S.CD_STAGE_REGION = row[5]
   *    String idSituation = szCdStageProgram = S.CD_STAGE_PROGRAM = row[6]
   *    String idSituation = ulIdSituation = S.ID_SITUATION = row[7]
   *    String idStage = ulIdStage = S.ID_STAGE = row[8]
   *    String cdStageREasonClosed = szCdStageReasonClosed = S.CD_STAGE_REASON_CLOSED = row[9]
   *    String idPerson = ulIdPerson = L.ID_PERSON = row[10]
   *    String cdCpsInvstOverallDisp = CdCpsOverallDisptn = A.CD_CPS_INVST_OVRALL_DISP = row[11]
   * </pre>
   *
   * @param idCase
   * @param cdStagePersRole
   * @param scrCdStagePersRole
   * @return An {@link Object}[] of information about the stages for the ADO and PAD cases. See description for details.
   */
  PaginatedHibernateList<Object[]> findCPSCaseSummaryStagesForPadCase(Collection lstCaseId, String cdStagePersRole,
                                                            String scrCdStagePersRole, int pageNbr, int pageSize);
  
  /**
   * Gets the open PAD stage in the given case
   * @param idCase
   * @param cdStage
   * @return
   */
  Integer findOpenPadStageByIdCaseCdStage(int idCase, String cdStage);
  
  /**
   * Gets the corresponding open FCC stage if there is one for the given ADO stage
   * @param idStage
   * @return
   */
  Integer findOpenFccStageByIdAdoStage(int idStage);
  
  /**
   * Gets list of Open stages for the given case other than the stage passed
   * @param idCase
   * @param idStage
   * @return
   */
  List<Stage> findOpenStagesByIdCaseByIdStage(int idCase, int idStage);
  
  /**
   * Gets the stage id in the case for the person id and stage type passed where the person is primary child
   * @param idCase
   * @param idPerson
   * @param cdStage
   * @return
   */
  Integer findStageFCCByIdCaseIdPerson(int idCase, int idPerson, String cdStage);
  
  /**
   * Gets the stage id of the active stage for a given case id and cd_stage
   * @param idCase
   * @param cdStage
   * @return
   */
  Integer findIdStageByIdCaseAndCdStageAndDtStageClose(int idCase, String cdStage);
  Integer findIdStageForOpenAdoStageByIdPersonIdCase(int idPerson, int idCase);//mxpatel wrote this for defect #13045
  String findCdStageByIdStage(int idStage);
  
  /** 
   * //STGAP00014341: Update Stage Assignment History for idPErson idStage and cdRole
   * @param idPerson
   * @param idStage
   * @param cdRole
   * @return
   */
  int updateStageAsgnmtHistory(int idPerson, int idStage);
  
  /** 
   * //STGAP00014341: delete Staff Assignment History for idPErson idStage and cdRole
   * @param idPerson
   * @param idStage
   * @param cdRole
   * @return
   */
  int deleteStageAsgnmtHistory(int idPerson, int idStage);

/**
 * Find id case of the most recently opened stage by id person, cd role, and cd stage, and before a date dt
 * @param idChild
 * @param cdRole
 * @param cdStage
 * @param dt
 * @return
 */
  public Integer findIdCaseByIdPersonCdRoleCdStageDtStageStart(int idChild, String cdRole, String cdStage, Date dt);
  
  /**
   * Find cases of certain stage and reason closed from a given set of case ids.
   * @param idCases
   * @param cdStages
   * @param cdStageReasonClosed
   * @return
   */
  List<Integer> findIdCasesByIdCaseCdStageCdStageReasonClosed(Collection<Integer> idCases,
                                                              Collection<String> cdStages,
                                                              Collection<String> cdStageReasonClosed);

}
