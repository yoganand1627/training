package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrievePersistentFcePrinciples;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrievePersistentFcePrinciplesImpl extends BaseServiceImpl implements RetrievePersistentFcePrinciples {
  
  private FcePersonDAO fcePersonDAO = null;
  
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  
  public List<FcePersonDB> retrievePersistentFcePrinciples(long idFceEligibility) throws ServiceException {
    List<FcePersonDB> principles = new ArrayList<FcePersonDB>();
    List<FcePerson> fcePersonList = fcePersonDAO.findPrincipals(idFceEligibility);
    if (fcePersonList != null && !fcePersonList.isEmpty()) {
      Iterator<FcePerson> fcePersonList_it = fcePersonList.iterator();
      while (fcePersonList_it.hasNext()) {
        FcePerson fcePerson = fcePersonList_it.next();
        principles.add(PopulateFceUtility.populateFcePersonDB(fcePerson));
      }
    }
    return principles;
  }
}
