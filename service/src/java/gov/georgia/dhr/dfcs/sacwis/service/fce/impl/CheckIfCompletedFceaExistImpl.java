package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.service.fce.CheckIfCompletedFceaExist;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class CheckIfCompletedFceaExistImpl extends BaseServiceImpl implements CheckIfCompletedFceaExist {
  private FceApplicationDAO fceApplicationDAO = null;
  
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }
  
  
  public boolean checkIfCompletedFceaExist(long idStage) {
    FceApplication fceApplication = fceApplicationDAO.findLatestCompleteFceApplication(idStage);
    if (fceApplication == null){
      return false;
    } else {
     return true;
    }
  }

}
