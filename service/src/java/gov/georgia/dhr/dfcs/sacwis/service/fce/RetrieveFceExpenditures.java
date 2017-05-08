package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;

public interface RetrieveFceExpenditures {
  /**
   * This retrieves a record from the FCE_EXPENDITURES table.
   * 
   * @param long idFceExpenditures
   * @return FceExpendituresDB
   */  
  public FceExpendituresDB retrieveFceExpenditures(long idFceExpenditures) throws ServiceException;
}
