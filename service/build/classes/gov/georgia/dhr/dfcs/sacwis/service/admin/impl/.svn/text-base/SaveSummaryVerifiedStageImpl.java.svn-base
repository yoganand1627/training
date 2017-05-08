package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveSummaryVerifiedStage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveStageVerifiedListSI;

import java.util.List;

public class SaveSummaryVerifiedStageImpl extends BaseServiceImpl implements SaveSummaryVerifiedStage {

  private StageDAO stageDAO;
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  
  public void updateSummaryVerifiedStages(SaveStageVerifiedListSI saveStageVerifiedListSI) {
    List<Integer> verifiedStageIds = saveStageVerifiedListSI.getVerifiedStageIds();
    List<String> verifiedStageInds = saveStageVerifiedListSI.getVerifiedStageInds();
    for (int i = 0; i < verifiedStageIds.size(); i++){
      int idStage = verifiedStageIds.get(i);
      String indEcsVer = verifiedStageInds.get(i);
      stageDAO.updateStageIndEcsVerified(idStage, indEcsVer);
    }
  }

}
