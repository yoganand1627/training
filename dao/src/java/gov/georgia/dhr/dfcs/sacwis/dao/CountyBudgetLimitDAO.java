package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;

public interface CountyBudgetLimitDAO {
  
  /**
   * Retrieves a CountyBudgetLimit based on id. This is used in
   * CountyBudgetLimit Detail page.
   * @param idCountyBudgetLimit
   * @return
   */
  CountyBudgetLimit findCountyBudgetLimitById(int idCountyBudgetLimit);
  
  /**
   * Checks to see if a CountyBudgetLimit exists before saving.
   * @param program
   * @param year
   * @return
   */
  CountyBudgetLimit findCountyBudgetLimitByProgramAndFiscalYear(String county, String program, int year);
  
  /**
   * Saves or update CountyBudgetLimit . Called from CountyBudgetLimit Detail page in Add/Modfiy mode.
   * @param cntyBdgtLmt
   */
  int saveOrUpdateCountyBudgetLimit(CountyBudgetLimit cntyBdgtLmt);

}
