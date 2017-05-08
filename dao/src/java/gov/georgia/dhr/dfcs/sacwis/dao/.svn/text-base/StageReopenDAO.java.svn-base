/**
 * Created on July 21 2009 by Bhavna Gehlot
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.StageReopen;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopenCbx;

import java.util.List;

public interface StageReopenDAO {
  /**
   * This method returns the checkboxes saved in the table
   * @param idEvent
   * @return
   */
  List<String> findCheckboxbyIdEvent(int idEvent);
  
  /**
   * This method returns the StageReopen for an event
   * @param idEvent
   * @return
   */
  StageReopen findStageReopenByIdEvent(int idEvent);
  
  /**
   * This saves the info in Stage Reopen Table
   * @param stageReopen
   */
  void saveOrUpdateStageReopen(StageReopen stageReopen);
  
  /**
   * This saves the check boxes in  STAGE_REOPEN_CBX table
   * @param stageReopenCbx
   */
  void saveStageReopenCbx(StageReopenCbx stageReopenCbx);
  
  /**
   * This deletes from STAGE_REOPEN_CBX table
   * @param idEvent
   */
  void deleteStageReopenCbxByIdEvent(int idEvent);
}
