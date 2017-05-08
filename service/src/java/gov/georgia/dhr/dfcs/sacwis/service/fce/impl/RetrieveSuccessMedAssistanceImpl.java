package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.InitialMedicaidAppDAO;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveSuccessMedAssistance;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveSuccessMedAssistanceImpl extends BaseServiceImpl implements RetrieveSuccessMedAssistance {
  private InitialMedicaidAppDAO initialMedicaidAppDAO = null;
  
  public void setInitialMedicaidAppDAO(InitialMedicaidAppDAO initialMedicaidAppDAO) {
    this.initialMedicaidAppDAO = initialMedicaidAppDAO;
  }
  
  public Map retrieveSuccessMedAssistance (long idCase, long idStage){
    String eventType = CodesTables.CEVNTTYP_IMA;
    Map medAssistance = initialMedicaidAppDAO.findSuccessMedAssistanceByCaseAndStage(idCase, idStage, eventType);
    return medAssistance;
  }

}
