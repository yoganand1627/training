package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceReasonNotEligibleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceReasonNotEligible;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceReasonNotEligible;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveFceReasonNotEligibleImpl extends BaseServiceImpl implements SaveFceReasonNotEligible {
  
  private FceReasonNotEligibleDAO fceReasonNotEligibleDAO = null;
  
  public void setFceReasonNotEligibleDAO(FceReasonNotEligibleDAO fceReasonNotEligibleDAO) {
    this.fceReasonNotEligibleDAO = fceReasonNotEligibleDAO;
  }
  
  public int saveFceReasonNotEligible(FceReasonNotEligibleDB fceReasonNotEligibleDB) {
    FceReasonNotEligible fceReasonNotEligible = new FceReasonNotEligible();
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class, (int) fceReasonNotEligibleDB.getIdFceEligibility());
    fceReasonNotEligible.setFceEligibility(fceEligibility);
    if (fceReasonNotEligibleDB.hasCdReasonNotEligible()) {
      fceReasonNotEligible.setCdReasonNotEligible(fceReasonNotEligibleDB.getCdReasonNotEligible());
    }
    fceReasonNotEligibleDAO.saveFceReasonNotEligible(fceReasonNotEligible);
    return fceReasonNotEligible.getIdFceReasonNotEligible();
  }
}
