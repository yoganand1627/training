package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveStageVerifiedListSI;

/**
 * 
 * @author wjcochran
 * This is the Service that saves red flag information for a stage. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   08/30/10  wjcochran SMS #66752: Initial File Creation
 * </pre>
 */
public interface SaveSummaryRedFlagCaseStage {
  
  /**
   * Updates the Stage table to indicate that the Stage has been indicated as
   * part of a red flag case. Uses the SaveStageVerifiedListSI object for data.
   * 
   * @param saveStageVerifiedListSI
   */
  void updateSummaryRedFlagCaseStages(SaveStageVerifiedListSI saveStageVerifiedListSI);

}
