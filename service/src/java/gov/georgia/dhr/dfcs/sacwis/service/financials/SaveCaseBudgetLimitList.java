package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitSaveSO;

public interface SaveCaseBudgetLimitList {

  /**
   * This Service calls a DAO to update Case Budget Limit information.
   * 
   * @param CaseBudgetLimitSaveSI
   *          {@link gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI} object
   * @return {@link CaseBudgetLimitSaveSO} object
   */
  public CaseBudgetLimitSaveSO saveCaseBudgetLimitList(CaseBudgetLimitSaveSI csBdgtLmtSaveSI);
}
