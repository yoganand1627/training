package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCountyBudgetLimitDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitSaveSI;

public class SaveCountyBudgetLimitDetailImpl extends BaseServiceImpl implements SaveCountyBudgetLimitDetail {

  private CountyBudgetLimitDAO countyBudgetLimitDAO = null;
  
  public void setCountyBudgetLimitDAO(CountyBudgetLimitDAO dao){
    countyBudgetLimitDAO = dao;
  }
  
  public int saveCountyBudgetLimitDetail(CountyBudgetLimitSaveSI input){
    int idCountyBudgetLimit = input.getIdCountyBudgetLimit();
    String county = input.getCounty();
    String program = input.getProgram();
    int fiscalYear = input.getFiscalYear();
    double budgetLimit = input.getBudgetedAmount();
    
    boolean update = idCountyBudgetLimit > 0;
    CountyBudgetLimit cbl = null;
    if(update) {
      cbl = countyBudgetLimitDAO.findCountyBudgetLimitById(idCountyBudgetLimit);
    }
    
    if(cbl == null) {
      cbl = countyBudgetLimitDAO.findCountyBudgetLimitByProgramAndFiscalYear(county, program, fiscalYear);
      if(cbl == null) {
        update = false;
      }
    }
    
    if(!update) {
      cbl = new CountyBudgetLimit();
      cbl.setIdCountyBudgetLimit(0); //-- not necessary, but for clarity
      cbl.setCdCounty(county);
      cbl.setCdProgram(program);
      cbl.setNbrFiscalYear(fiscalYear);
      cbl.setAmtSpent(0.0);
      cbl.setAmtObg(0.0);
      cbl.setAmtBalance(budgetLimit);
    } else {
      double updatedBalance = cbl.getAmtBalance() - (cbl.getAmtBudgetLimit() - budgetLimit);
      cbl.setAmtBalance(updatedBalance);
    }
    cbl.setAmtBudgetLimit(budgetLimit);
    
    return countyBudgetLimitDAO.saveOrUpdateCountyBudgetLimit(cbl);
  }
}
