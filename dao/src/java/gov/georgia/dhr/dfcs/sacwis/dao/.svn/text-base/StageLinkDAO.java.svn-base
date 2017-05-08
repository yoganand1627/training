/**
 * Created on Mar 25, 2006 at 3:33:11 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageLink;
/**
 * This is the DAO class is used for the STAGE_LINK table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  11/25/09  arege     SMS#37361 Added findStageLinkByIdStageAndCdStage() to find if the previous stage is the given stage     
 *  02/07/12  htvo      STGAP00017831: MR-102 - Added method findPriorStageByIdCurrStage(int idStage)
 * </pre>
 */

public interface StageLinkDAO {
  /**
   * This select should pull Stage_Link row where ID_STAGE equals host idStage. It should then join the stage table to
   * retrieve all columns from the row where ID_STAGE equals the ID_PREVIOUS_STAGE
   * <p/>
   *
   * @param idStage
   * @return
   */
  Map findStageLinkPreviousStage(int idStage);
  
  /**
   * Finds a list of progressed to stages given a certain stage type and the progressed from stage id. 
   * @param idPrevStage
   * @param cdStageTypes
   * @return
   */
  public List<Map> findAllProgressedToStagesByIdStageIdStageType(int idPrevStage, String cdStageTypes) ;

  /**
   * This selects a row from StageLink given the idStage.
   * <p/>
   *
   * @param idStage
   * @return Integer
   */
  Integer findStageLinkByIdStage(int idStage);

  /**
   * Gets the most recently closed previous ID STAGE for a given ID STAGE.
   *
   * @param idStage
   * @return
   */
  Integer findPreviousIdStagebyIdStage(int idStage);

  /**
   * Gets the most recently closed previous ID STAGE for a given ID STAGE.
   * 
   * @param idStage
   * @return
   */
  Integer findStageLinkMostRecentlyClosedPreviousIdStage(int idStage);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.StageLink} object to the database.
   *
   * @param stageLink A populated {@link gov.georgia.dhr.dfcs.sacwis.db.StageLink} object.
   */
  void saveStageLink(StageLink stageLink);
  
  /**
   * Gets the previous stage id if the previous stage is ADO.
   * 
   * @param idStage
   * @return
   */
  public Integer findPreviousIdStageByIdStageByCdStage(int idStage);
  
  /**
   * Gets the new PAD stage id based on the prior stage id
   * 
   * @param idPriorStage
   * @return int 
   */
  public Integer findNewIdPADStageByIdPriorStage(int idPriorStage);
  
  /**
   * Gets the new PAD case id based on the prior stage id
   * 
   * @param idPriorStage
   * @return int 
   */
  public Integer findNewIdPADCaseByIdPriorStage(int idPriorStage);
  
  /** 
   * // STGAP00014341 : Gets the new idStage based on the prior stage id
   * @param idPriorStage
   * @return
   */
  Stage findNewIdStageByIdPriorStage(int idPriorStage);
  
  /**
   * 
   * @param idStage
   * @param cdStages
   * @return
   */
  public Integer findStageLinkByIdStageAndCdStage(int idStage,  Collection<String>  cdStages);
  
  /**
   * Find the previous stage (through stage progression) by id stage of the current stage of the same case.
   * @param idStage
   * @return
   */
  public Stage findPriorStageByIdCurrStage(int idStage);
}
