package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveSummaryRedFlagCaseStage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
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
public class SaveSummaryRedFlagCaseStageImpl extends BaseServiceImpl implements SaveSummaryRedFlagCaseStage {

  private StageDAO stageDAO;
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void updateSummaryRedFlagCaseStages(SaveStageVerifiedListSI saveStageVerifiedListSI) {
    List<Integer> idRedFlagStage = saveStageVerifiedListSI.getVerifiedStageIds();
    List<String> indRedFlagStage = saveStageVerifiedListSI.getVerifiedStageInds();
    for (int i = 0; i < idRedFlagStage.size(); i++){
      int idStage = idRedFlagStage.get(i);
      String indRedFlag = indRedFlagStage.get(i);
      stageDAO.updateStageIndRedFlag(idStage, indRedFlag);
    }
  }

}
