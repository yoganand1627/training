package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFceApplication;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveFceApplicationImpl extends BaseServiceImpl implements RetrieveFceApplication {

  private FceApplicationDAO fceApplicationDAO = null;
  
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }
  
  public FceApplicationDB retrieveFceApplication(long idFceApplication) throws ServiceException {
    FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdFceApplication(idFceApplication);
    if (fceApplication == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceApplicationDB(fceApplication);
  }
}
