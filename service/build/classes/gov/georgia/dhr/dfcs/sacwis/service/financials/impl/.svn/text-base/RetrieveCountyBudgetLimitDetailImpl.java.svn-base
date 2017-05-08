package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveCountyBudgetLimitDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO;

public class RetrieveCountyBudgetLimitDetailImpl extends BaseServiceImpl implements RetrieveCountyBudgetLimitDetail{
  
  private CountyBudgetLimitDAO countyBudgetLimitDAO = null;
  
  public void setCountyBudgetLimitDAO(CountyBudgetLimitDAO dao){
    countyBudgetLimitDAO = dao;
  }
  
  public CountyBudgetLimitRetrieveSO retrieveCountyBudgetLimitDetail(CountyBudgetLimitRetrieveSI input){
    CountyBudgetLimitRetrieveSO result = new CountyBudgetLimitRetrieveSO();
    CountyBudgetLimit countyBudgetLimit  = countyBudgetLimitDAO.findCountyBudgetLimitById(input.getIdCountyBudgetLimit());
    if (countyBudgetLimit != null){
      result.setAmountObligated(getDoubleSafe(countyBudgetLimit.getAmtObg()));
      result.setAmountSpent(getDoubleSafe(countyBudgetLimit.getAmtSpent()));
      result.setBudgetedAmount(getDoubleSafe(countyBudgetLimit.getAmtBudgetLimit()));
      result.setCounty(countyBudgetLimit.getCdCounty());
      result.setIdCountyBudgetLimit(getIntegerSafe(countyBudgetLimit.getIdCountyBudgetLimit()));
      result.setProgram(countyBudgetLimit.getCdProgram());
      result.setRemainingBalance(getDoubleSafe(countyBudgetLimit.getAmtBalance()));
      result.setFiscalYear(getIntegerSafe(countyBudgetLimit.getNbrFiscalYear()));
      result.setDtLastUpdate(countyBudgetLimit.getDtLastUpdate());
    }
    return result;
  }
  
  private double getDoubleSafe(Double d) {
    if(d == null) {
      return 0.0;
    }
    return d;
  }
  
  private int getIntegerSafe(Integer i) {
    if(i == null) {
      return 0;
    }
    return i;
  }

}
