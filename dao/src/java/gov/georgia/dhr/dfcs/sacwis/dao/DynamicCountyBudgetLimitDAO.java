package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

public interface DynamicCountyBudgetLimitDAO {
  
  public static final int AMT_OBG = 1;
  public static final int AMT_BALANCE = 2;
  
  /**
   * Fetches CountyBudgetLimit records from the database based on inputs
   * from CountyBudgetLimitSearch page
   * @param county
   * @param program
   * @param fiscalYear
   * @return
   */
  List<Object[]> findCountyBudgetLimit(String county,String program,int fiscalYear);

  /**
   * Updates any CountyBudgetLimit records for the given county, program, and fiscalYear.  The update will
   * always increment the amtSpent value by the amount given.  Also, if a proper constant from this interface
   * is used for the decrementColumn argument, that column will be decremented by the amount given.
   * 
   * @param county
   * @param program
   * @param fiscalYear
   * @param amount
   * @param decrementColumn
   * @return
   */
  int updateCountyBudgetLimitAmounts(String county, String program, int fiscalYear, double amount, int decrementColumn);

}
