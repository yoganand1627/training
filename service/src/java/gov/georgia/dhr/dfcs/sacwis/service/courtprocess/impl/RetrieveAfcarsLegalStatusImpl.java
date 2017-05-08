package gov.georgia.dhr.dfcs.sacwis.service.courtprocess.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsAdoptionHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.RetrieveAfcarsLegalStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AfcarsLegStatHistSO;

import java.util.List;
import java.util.Map;

public class RetrieveAfcarsLegalStatusImpl extends BaseServiceImpl implements RetrieveAfcarsLegalStatus {
  public AfcarsAdoptionHistoryDAO afcarsAdoptionHistoryDAO = null;

  public LegalStatusDAO legalStatusDAO = null;
  
  public void setAfcarsAdoptionHistoryDAO(AfcarsAdoptionHistoryDAO afcarsAdoptionHistoryDAO) {
    this.afcarsAdoptionHistoryDAO = afcarsAdoptionHistoryDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public AfcarsLegStatHistSO retrieveAfcarsLegalStatus(int idStage) {
    AfcarsLegStatHistSO afcarsLegStatHistSO = new AfcarsLegStatHistSO();
    int idChild = afcarsAdoptionHistoryDAO.findAfcarsAdoptionHistoryIdPersonByIdStage(idStage);
    
    if (idChild > 0) {
      List<Map> lsDataList = legalStatusDAO.findLegalStatusByIdStageByIdPerson(idStage, idChild);
      afcarsLegStatHistSO.setIdPerson(idChild);
      afcarsLegStatHistSO.setIdStage(idStage);
      afcarsLegStatHistSO.setLegalStatusMapList(lsDataList);
      afcarsLegStatHistSO.setPrevAfcarsReported(true);      
    } else {
      afcarsLegStatHistSO.setPrevAfcarsReported(false);
    }
    return afcarsLegStatHistSO;
  }

}
