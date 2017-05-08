package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceApplication;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveFceApplicationImpl extends BaseServiceImpl implements SaveFceApplication {

  private FceApplicationDAO fceApplicationDAO = null;
  
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }
  
  public int saveFceApplication(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = new FceApplication();
    if (fceApplicationDB.hasIdFceApplication()) {
      fceApplication = getPersistentObject(FceApplication.class, (int) fceApplicationDB.getIdFceApplication());
    }
    if (fceApplicationDB.hasIdCase()) {
      CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceApplicationDB.getIdCase());
      fceApplication.setCapsCase(capsCase);
    }
    if (fceApplicationDB.hasIdStage()) {
      Stage stage = getPersistentObject(Stage.class, (int) fceApplicationDB.getIdStage());
      fceApplication.setStage(stage);
    }
    if (fceApplicationDB.hasIdLastUpdatePerson()) {
      Person lastUpdatePerson = getPersistentObject(Person.class, (int) fceApplicationDB.getIdLastUpdatePerson());
      fceApplication.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    }
    if (fceApplicationDB.hasIdEvent()) {
      Event event = getPersistentObject(Event.class, (int) fceApplicationDB.getIdEvent());
      fceApplication.setEvent(event);
    }
    if (fceApplicationDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceApplicationDB.getIdFceEligibility());
      fceApplication.setFceEligibility(fceEligibility);
    }
    if (fceApplicationDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fceApplicationDB.getIdPerson());
      fceApplication.setPersonByIdPerson(person);
    }
    if (fceApplicationDB.hasIdMngngCvsPerson()) {
      Person personByIdMngngCvsPerson = getPersistentObject(Person.class, (int) fceApplicationDB.getIdMngngCvsPerson());
      fceApplication.setPersonByIdMngngCvsPerson(personByIdMngngCvsPerson);
    }
    if (fceApplicationDB.hasIdOtherRelativePerson()) {
      Person personByIdOtherRelativePerson = getPersistentObject(Person.class,
                                                                 (int) fceApplicationDB.getIdOtherRelativePerson());
      fceApplication.setPersonByIdOtherRelativePerson(personByIdOtherRelativePerson);
    }
    fceApplication = PopulateFceUtility.populateFceApplication(fceApplicationDB, fceApplication);
    fceApplicationDAO.saveFceApplication(fceApplication);
    return fceApplication.getIdFceApplication();
  }
}
