package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFceIncome;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrieveFceIncomeImpl extends BaseServiceImpl implements RetrieveFceIncome {
  
  private FceIncomeDAO fceIncomeDAO = null;
  
  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }
  
  public FceIncomeDB retrieveFceIncome(long idFceIncome) throws ServiceException {
    FceIncome fceIncome = fceIncomeDAO.findFceIncomeByIdFceIncome(idFceIncome);
    if (fceIncome == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceIncomeDB(fceIncome);
  }
  
  public List<FceIncomeDB> retrieveFceIncomeForFcePerson(long idFceEligibility, long idPerson) throws ServiceException {
    List<FceIncomeDB> fceIncomeDBList = new ArrayList<FceIncomeDB>();
    List<FceIncome> fceIncomes = fceIncomeDAO.findFceIncomeByIdFceEligAndIdPerson(idFceEligibility, idPerson);
    if (fceIncomes != null && fceIncomes.size() > 0) {
      Iterator<FceIncome> fceIncomesIterator = fceIncomes.iterator();
      while(fceIncomesIterator.hasNext()) {
        FceIncome fceIncome = fceIncomesIterator.next();
        fceIncomeDBList.add(PopulateFceUtility.populateFceIncomeDB(fceIncome));
      }
    }
    return fceIncomeDBList;
  }
}
