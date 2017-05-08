package gov.georgia.dhr.dfcs.sacwis.service.financials;

import java.util.Arrays;
import java.util.Collection;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BudgetUpdateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BudgetUpdateSO;

public interface UpdateBudgets {
  
  //-- constants
  public static final Collection<String> PAYABLE_CONTRACT_PERIOD_STATUS = Arrays.asList(CodesTables.CCONSTAT_ACT, CodesTables.CCONSTAT_SVH);
  
  //-- abstract method
  BudgetUpdateSO updateBudgets(BudgetUpdateSI budgetUpdateSI);
  
}
