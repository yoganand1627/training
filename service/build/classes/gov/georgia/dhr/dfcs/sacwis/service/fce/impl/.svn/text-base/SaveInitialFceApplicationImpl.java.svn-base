package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveInitialFceApplication;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveInitialFceApplicationImpl extends BaseServiceImpl implements SaveInitialFceApplication {
  
  private FceApplicationDAO fceApplicationDAO = null;
  
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }
  
  public int saveInitialFceApplication(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = new FceApplication();
    CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceApplicationDB.getIdCase());
    fceApplication.setCapsCase(capsCase);
    Stage stage = getPersistentObject(Stage.class, (int) fceApplicationDB.getIdStage());
    fceApplication.setStage(stage);
    Person lastUpdatePerson = getPersistentObject(Person.class, (int) fceApplicationDB.getIdLastUpdatePerson());
    fceApplication.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    Event event = getPersistentObject(Event.class, (int) fceApplicationDB.getIdEvent());
    fceApplication.setEvent(event);
    fceApplication.setCdApplication(fceApplicationDB.getCdApplication());
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                        (int) fceApplicationDB.getIdFceEligibility());
    fceApplication.setFceEligibility(fceEligibility);
    Person person = getPersistentObject(Person.class, (int) fceApplicationDB.getIdPerson());
    fceApplication.setPersonByIdPerson(person);
    fceApplicationDAO.saveFceApplication(fceApplication);
    return fceApplication.getIdFceApplication();
  }
  
}
