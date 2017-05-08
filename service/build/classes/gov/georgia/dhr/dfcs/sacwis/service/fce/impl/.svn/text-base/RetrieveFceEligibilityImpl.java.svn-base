package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveFceEligibilityImpl extends BaseServiceImpl implements RetrieveFceEligibility {
  
  private FceEligibilityDAO fceEligibilityDAO = null;
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public FceEligibilityDB retrieveFceEligibility(long idFceEligibility) throws ServiceException {
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(idFceEligibility);
    if (fceEligibility == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceEligibilityDB(fceEligibility);
  }
}
