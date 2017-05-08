package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceIveIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveIVEIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveIVEIncomeLimitImpl extends BaseServiceImpl implements RetrieveIVEIncomeLimit {

  public static final int NBR_AGE_CHILD = 13;
  
  private FceIncomeDAO fceIncomeDAO = null;
  
  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }
  
  public Double[] retrieveIVEIncomeLimit(long nbrAge){
    Double amtIVEImcomeLimit[] = new Double[2];
    FceIveIncomeLimit fceIVEIncomeLimit = null;
    if(nbrAge <=13){
      fceIVEIncomeLimit = fceIncomeDAO.findIVEIncomeLimitByNbrAge(nbrAge);
    }else{
      fceIVEIncomeLimit = fceIncomeDAO.findIVEIncomeLimitByNbrAge(NBR_AGE_CHILD);
    }
    amtIVEImcomeLimit[0]= fceIVEIncomeLimit.getAmtGrossIncomeCeiling();
    amtIVEImcomeLimit[1]= fceIVEIncomeLimit.getAmtStandardOfNeed();
    return amtIVEImcomeLimit;
   }
}
