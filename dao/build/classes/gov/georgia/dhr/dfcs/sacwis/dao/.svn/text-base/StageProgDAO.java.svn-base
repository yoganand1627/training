/**
 * Created on Mar 25, 2006 at 3:32:41 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.StageProg;

public interface StageProgDAO {
  /**
   * This will receives CD STAGE, CD STAGE PROGRAM, and CD STAGE REASON CLOSED from the Service and retrieves entire
   * row(s) from the STAGE_PROG table.
   *
   * @param cdStageProgStage
   * @param cdStageProgProgram
   * @param cdStageProgRsnClose
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<StageProg> findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(String cdStageProgStage,
                                                                                       String cdStageProgProgram,
                                                                                       String cdStageProgRsnClose);
}
