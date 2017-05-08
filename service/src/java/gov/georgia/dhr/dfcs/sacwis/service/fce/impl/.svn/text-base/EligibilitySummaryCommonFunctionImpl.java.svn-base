package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EligibilitySummaryCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class EligibilitySummaryCommonFunctionImpl extends BaseServiceImpl implements EligibilitySummaryCommonFunction {
  
  private FceEligibilityDAO fceEligibilityDAO = null;
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public FceEligibilityDB retrieveEligibilityForEligibilityEvent(long idEligibilityEvent) {
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdEligibilityEvent(idEligibilityEvent);
    if (fceEligibility == null) {
      return null;
    }
    return PopulateFceUtility.populateFceEligibilityDB(fceEligibility);
  }
  
  public int updateFceEligibilityCdBlocAmtSsi(long idFceEligibility, String cdBlocChild, double amtSsi) {
    return fceEligibilityDAO.updateFceEligibilityByCdBlocChild(idFceEligibility, cdBlocChild, amtSsi);
  }
  
  public int updateFceEligibilityIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered) {
    return fceEligibilityDAO.updateFceEligibilityByIndChildSupportOrdered(idFceEligibility, indChildSupportOrdered);
  }

}
