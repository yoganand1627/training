package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexUnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;

public class ComplexUnitDAOImpl extends BaseDAOImpl implements ComplexUnitDAO {
  private CapsCaseDAO capsCaseDAO = null;
  private StageDAO stageDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public int updateCapsCaseAndStage(int idUnit) {
    int nbrRowsAffected = capsCaseDAO.updateCapsCaseByFindingIdCaseInStageByIdUnit(idUnit);
    nbrRowsAffected += stageDAO.updateStageIdUnitCdStageRegionByIdUnit(idUnit);
    return nbrRowsAffected;
  }
}
