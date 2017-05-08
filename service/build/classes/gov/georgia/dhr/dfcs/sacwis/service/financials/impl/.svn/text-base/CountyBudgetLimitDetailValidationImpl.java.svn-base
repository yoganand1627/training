package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.service.financials.CountyBudgetLimitDetailValidation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class CountyBudgetLimitDetailValidationImpl extends BaseServiceImpl implements CountyBudgetLimitDetailValidation {

  private CountyBudgetLimitDAO countyBudgetLimitDAO = null;
  
  public void setCountyBudgetLimitDAO(CountyBudgetLimitDAO dao){
    countyBudgetLimitDAO = dao;
  }
  
  public int isCountyBudgetLimitDetailValid(String county, String program, int fiscalYear) {
    CountyBudgetLimit cbl =  countyBudgetLimitDAO.findCountyBudgetLimitByProgramAndFiscalYear(county, program, fiscalYear);
    return cbl == null ? 0 : cbl.getIdCountyBudgetLimit();
  }

}
