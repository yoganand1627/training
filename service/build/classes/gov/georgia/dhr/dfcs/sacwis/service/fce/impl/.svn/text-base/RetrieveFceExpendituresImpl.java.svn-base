package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveFceExpendituresImpl extends BaseServiceImpl implements RetrieveFceExpenditures {
  
  private FceExpendituresDAO fceExpendituresDAO = null;
  
  public void setFceExpendituresDAO(FceExpendituresDAO fceExpendituresDAO) {
    this.fceExpendituresDAO = fceExpendituresDAO;
  }
  
  public FceExpendituresDB retrieveFceExpenditures(long idFceExpenditures) throws ServiceException {
    FceExpenditures fceExpenditures = fceExpendituresDAO.findFceExpendituresByIdFceExpenditures(idFceExpenditures);
    if (fceExpenditures == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceExpendituresDB(fceExpenditures);
  }
}
