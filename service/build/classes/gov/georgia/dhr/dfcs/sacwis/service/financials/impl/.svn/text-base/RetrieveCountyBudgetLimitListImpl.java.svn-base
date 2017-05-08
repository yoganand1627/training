package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveCountyBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO;

public class RetrieveCountyBudgetLimitListImpl extends BaseServiceImpl implements RetrieveCountyBudgetLimitList {

  private DynamicCountyBudgetLimitDAO dynamicCountyBudgetLimitDAO = null;

  public void setDynamicCountyBudgetLimitDAO(DynamicCountyBudgetLimitDAO dynamicCountyBudgetLimitDAO) {
    this.dynamicCountyBudgetLimitDAO = dynamicCountyBudgetLimitDAO;
  }

  public List<CountyBudgetLimitRetrieveSO> retrieveCountyBudgetLimitList(CountyBudgetLimitRetrieveSI input) {
    List<CountyBudgetLimitRetrieveSO> result = new ArrayList<CountyBudgetLimitRetrieveSO>();

    List<Object[]> objectArrayList = dynamicCountyBudgetLimitDAO.findCountyBudgetLimit(input.getCounty(),
                                                                                       input.getProgram(),
                                                                                       input.getFiscalYear());
    Iterator iterator = objectArrayList.iterator();

    while (iterator.hasNext()) {
      Object[] array = (Object[]) iterator.next();
      CountyBudgetLimitRetrieveSO retrieveSO = new CountyBudgetLimitRetrieveSO();
      if (array[0] != null) {
        retrieveSO.setIdCountyBudgetLimit((Integer) array[0]);
      }
      retrieveSO.setProgram((String) array[1]);
      retrieveSO.setCounty((String) array[2]);
      if (array[3] != null) {
        retrieveSO.setBudgetedAmount((Double) array[3]);
      }
      if (array[4] != null) {
        retrieveSO.setAmountSpent((Double) array[4]);
      }
      if (array[5] != null) {
        retrieveSO.setAmountObligated((Double) array[5]);
      }
      if (array[6] != null) {
        retrieveSO.setRemainingBalance((Double) array[6]);
      }
      result.add(retrieveSO);
    }
    return result;
  }
}
