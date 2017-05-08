package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.fce.UpdateFcePersonBirthday;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class UpdateFcePersonBirthdayImpl extends BaseServiceImpl implements UpdateFcePersonBirthday {
  
  private FcePersonDAO fcePersonDAO = null;
  
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }
  
  public void updateFcePersonBirthday(FcePersonDB fcePersonDB) {
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fcePersonDB.getIdFcePerson());
    fcePerson.setDtBirth(fcePersonDB.getDtBirth());
    fcePerson.setNbrAge((int) fcePersonDB.getNbrAge());
    String indDobApprox = null;
    if (fcePersonDB.getIndDobApprox() == true) {
      indDobApprox = ArchitectureConstants.Y;
    } else if (fcePersonDB.getIndDobApprox() == false) {
      indDobApprox = ArchitectureConstants.N;
    }
    fcePerson.setIndDobApprox(indDobApprox);
    fcePersonDAO.saveFcePerson(fcePerson);
  }
}
