package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.document.VisitPlan;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VISITPLANSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.VISITPLANSO;

public class VisitPlanImpl extends BaseDocumentServiceImpl implements VisitPlan {

  private StageDAO stageDAO;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public VISITPLANSO retrieveVisitPlan(VISITPLANSI visitPlansi) {
    VISITPLANSO visitPlanso = new VISITPLANSO();

    PreFillData preFillData = new PreFillData();
    int idStage = visitPlansi.getUlIdStage();
    Stage stage = stageDAO.findStageByIdStage(idStage);

    String stageName = stage.getNmStage();
    preFillData.addBookmark(createBookmark(CHILD_NAME, stageName));

    visitPlanso.setPreFillData(preFillData);
    return visitPlanso;
  }
}
        
