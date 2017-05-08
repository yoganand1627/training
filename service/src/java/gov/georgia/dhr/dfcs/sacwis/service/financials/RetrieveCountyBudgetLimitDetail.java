package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO;

public interface RetrieveCountyBudgetLimitDetail {
  
  
  /**
   * Called by financials ejb to  retrieve the results for CountyBudgetLimit Detail page. 
   * @param input
   * @return
   */
  public CountyBudgetLimitRetrieveSO retrieveCountyBudgetLimitDetail(CountyBudgetLimitRetrieveSI input);

}
