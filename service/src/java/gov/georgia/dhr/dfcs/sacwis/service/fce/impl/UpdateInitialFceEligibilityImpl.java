package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.fce.UpdateInitialFceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class UpdateInitialFceEligibilityImpl extends BaseServiceImpl implements UpdateInitialFceEligibility {
  
  private FceEligibilityDAO fceEligibilityDAO = null;
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public void updateInitialFceEligibility(FceEligibilityDB fceEligibilityDB) {
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(
                                                        (int) fceEligibilityDB.getIdFceEligibility());
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                        (int) fceEligibilityDB.getIdFceApplication());
    fceEligibility.setFceApplication(fceApplication);
    Person person = getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPerson());
    fceEligibility.setPersonByIdPerson(person);
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceEligibilityDB.getIdFcePerson());
    fceEligibility.setFcePerson(fcePerson);

    if (fceEligibilityDB.hasIdPrnEarner()) {
      Person prnEarner = getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPrnEarner());
      fceEligibility.setPersonByIdPrnEarner(prnEarner);
    }

    String indEligible = toCharIndicator(fceEligibilityDB.getIndEligibleObject());
    fceEligibility.setIndEligible(indEligible);
    fceEligibilityDAO.saveFceEligibility(fceEligibility);
  }
  
  private static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }
}
