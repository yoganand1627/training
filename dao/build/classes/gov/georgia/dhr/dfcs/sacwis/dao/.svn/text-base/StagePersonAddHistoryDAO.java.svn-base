/**
 * Created on August 22, 2011 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.StagePersonAddHistory;

/**Change History:
 * Date        User              Description
 * --------    ----------------  --------------------------------------------------
 * 08/24/2011  schoi             STGAP00017013: MR-095 Initial Creation
 * 09/07/2011  schoi             STGAP00017013: MR-095 Added new method insertStagePersonAddHistoryAddedFromAddPersonToActiveStages
 * 10/10/2011  schoi             STGAP00017013: MR-095 Added new method deleteStagePersonAddHistoryByIdPerson for Person Merge Split logic change
 * 10/21/2011  schoi             STGAP00017013: MR-095 Added new method deleteStagePersonAddHistoryByIdPersonByIdFromStage 
 *                               to delete record from STAGE_PERSON_ADD_HISTORY table after the person delete is successfully executed
 */

public interface StagePersonAddHistoryDAO {
  
  /**
   * This selects a unique row from the StagePersonAddHistory table <p/>
   * 
   * @param idStage
   * @param idPerson
   * 
   */
  List<StagePersonAddHistory> findStagePersonAddHistorybyIdStageIdPerson(int idStage, int idPerson);

  /**
   * This inserts record to the StagePersonAddHistory table <p/>
   * 
   * @param idFromStage
   * @param idToStage
   * @param idCase
   * @param idPerson
   * @param cdStagePersType
   * @param cdStagePersRelInt
   * @param dtAdded
   * 
   */
  int insertStagePersonAddHistoryAddedFromAddPersonToActiveStages(int idFromStage, int idToStage, int idCase,
                                                                  int idPerson, String cdStagePersType,
                                                                  String cdStagePersRelInt, Date dtAdded);
  
  /**
   * Saves StagePersonAddHistory information to the DB
   * 
   * @param stagePersonAddHistory
   * 
   */
  void saveStagePersonAddHistory(StagePersonAddHistory stagePersonAddHistory);
  
  /**
   * Deletes StagePersonAddHistory by idPerson where stageByIdFromStage(s) is not closed
   * 
   * @param idPerson
   * 
   */
  int deleteStagePersonAddHistoryByIdPerson(int idPerson);
  
  /**
   * Deletes StagePersonAddHistory by idPerson and idFromStage
   * 
   * @param idPerson
   * @param idFromStage
   * 
   */
  int deleteStagePersonAddHistoryByIdPersonByIdFromStage(int idPerson, int idFromStage);
}
