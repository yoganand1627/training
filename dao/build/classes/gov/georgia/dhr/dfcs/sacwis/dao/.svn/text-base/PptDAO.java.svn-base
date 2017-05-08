/**
 * Created on Mar 25, 2006 at 3:19:34 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;

public interface PptDAO {
  /**
   * This selects a row from Reports given nmRptSqrName. <p/> From: Cses14d.pc
   *
   * @param idPptEvent
   * @return
   */
  Ppt findPpt(int idPptEvent);

  /**
   * Inserts/updates an entire row of Ppt table.
   *
   * @param ppt
   */
  void savePpt(Ppt ppt);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Ppt} object.
   *
   * @param ppt
   */
  void deletePpt(Ppt ppt);
  
  /**
   * select the latest team meeting for a stage, eventype and Ppt type
   *
   * @param idStage
   * @param cdEventType
   * @param cdPptType
   * @return Ppt
   */
  Ppt findLatestPptByIdStageByCdEventTypeByCdPptType(int idStage, String cdEventType,
                                                     String cdPptType);
  List<Ppt> findLatestPptByIdStageByCdEventTypeByCdPptTypes(int idStage, String cdEventType,
                                                                   Collection<String> cdPptTypes);
  /**
   * select the latest team meeting date for a stage and ftm types
   *
   * @param idStage
   * @param cdEventType
   * @param cdFtmTypes
   * @return Date
   */
  Date findLatestFtmDateByIdStageByCdFtmTypes(int idStage, Collection<String> cdFtmTypes);

  Ppt findMostRecentPptByIdStageByCdEventTypeByCdPptTypes(int idStage, String cdEventType,
                                                          Collection<String> cdPptTypes);
  
  /**
   * Retrieves the most recent PPT Type regardless of the status of the event
   * 
   * @param idStage
   * @param cdEventType
   * @param cdPptType
   * @return
   */
  Ppt findMostRecentPptByIdStageByCdEventTypeByCdPptType(int idStage, String cdEventType, String cdPptType);
  
  /**
   * MR-062 Get the PPT for idContactStdsEvent
   * @param idContactStdsEvent
   * @return
   */
  Ppt findPptByIdContactStdsEvent(int idContactStdsEvent);
  
  /**
   * MR-062 Update the PPT for idContactStdsEvent
   * @param idContactStdsEvent
   * @return
   */
  int updatePPTByIdContactStdEvent(int idContactStdsEvent);
}
