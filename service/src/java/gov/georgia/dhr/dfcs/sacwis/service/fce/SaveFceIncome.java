package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;

public interface SaveFceIncome {

  /**  This service saves a record in FCE_INCOME table
   *   @param fceIncomeDB
   *   @return int
   */
  public int saveFceIncome(FceIncomeDB fceIncomeDB);
}
