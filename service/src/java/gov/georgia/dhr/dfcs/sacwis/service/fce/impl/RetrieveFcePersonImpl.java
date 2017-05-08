package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveFcePersonImpl extends BaseServiceImpl implements RetrieveFcePerson {
  
  private FcePersonDAO fcePersonDAO = null;
  
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }
  
  public FcePersonDB retrieveFcePerson(long idFcePerson) throws ServiceException {
    FcePerson fcePerson = fcePersonDAO.findFcePersonByIdFceEPerson(idFcePerson);
    if (fcePerson == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFcePersonDB(fcePerson);
  }
}
