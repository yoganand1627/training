package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;

public interface RetrieveFceIncome {
  
  /**
   * This retrieves a record from the FCE_INCOME table.
   * 
   * @param long idFceIncome
   * @return FceIncomeDB
   */  
  public FceIncomeDB retrieveFceIncome(long idFceIncome) throws ServiceException ;
  
  
  /**
   * Retrieves a list of FCE_INCOME recordsbased on the idFceEligibility and idPerson
   * 
   * @param idFceEligibility
   * @param idPerson
   * @return
   * @throws ServiceException
   */
  public List<FceIncomeDB> retrieveFceIncomeForFcePerson(long idFceEligibility, long idPerson) throws ServiceException;

}
