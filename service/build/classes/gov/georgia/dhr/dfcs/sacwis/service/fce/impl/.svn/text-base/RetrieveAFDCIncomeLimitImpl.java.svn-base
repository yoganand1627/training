package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceAfdcIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveAFDCIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveAFDCIncomeLimitImpl extends BaseServiceImpl implements RetrieveAFDCIncomeLimit {
  
  private FceIncomeDAO fceIncomeDAO = null;
  
  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }

  public Integer[] retrieveAFDCIncomeLimit(long nbrCertifiedGroup) {
    Integer amtAfdcImcomeLimit[] = new Integer[2];
    FceAfdcIncomeLimit fceAdfcIncomeLimit = fceIncomeDAO.findAFDCIncomeLimitByNbrCertifiedGroup(nbrCertifiedGroup);
    if (fceAdfcIncomeLimit != null) {
      amtAfdcImcomeLimit[0]= fceAdfcIncomeLimit.getAmtGrossIncomeCeiling();
      amtAfdcImcomeLimit[1]= fceAdfcIncomeLimit.getAmtStandardOfNeed();
    }
    return amtAfdcImcomeLimit;
  }

}
