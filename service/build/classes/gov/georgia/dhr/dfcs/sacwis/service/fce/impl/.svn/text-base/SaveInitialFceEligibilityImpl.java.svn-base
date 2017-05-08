package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveInitialFceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveInitialFceEligibilityImpl extends BaseServiceImpl implements SaveInitialFceEligibility {
  
  private FceEligibilityDAO fceEligibilityDAO = null;
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public int saveInitialFceEligibility(FceEligibilityDB fceEligibilityDB) {
    FceEligibility fceEligibility = new FceEligibility();
    CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceEligibilityDB.getIdCase());
    fceEligibility.setCapsCase(capsCase);
    Stage stage = getPersistentObject(Stage.class, (int) fceEligibilityDB.getIdStage());
    fceEligibility.setStage(stage);
    Person lastUpdatePerson = getPersistentObject(Person.class, (int) fceEligibilityDB.getIdLastUpdatePerson());
    fceEligibility.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    
    if (fceEligibilityDB.hasIdPrnEarner()) {
      Person prnEarner = getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPrnEarner());
      fceEligibility.setPersonByIdPrnEarner(prnEarner);
    }

    fceEligibilityDAO.saveFceEligibility(fceEligibility);
    return fceEligibility.getIdFceEligibility();
  }  
}
