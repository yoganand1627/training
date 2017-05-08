package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveFceEligibilityImpl extends BaseServiceImpl implements SaveFceEligibility {

  private FceEligibilityDAO fceEligibilityDAO = null;
  private FceReviewDAO fceReviewDAO = null;
  private FceApplicationDAO fceApplicationDAO = null;
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }
  
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }
  
  public int saveFceEligibility(FceEligibilityDB fceEligibilityDB) {
    FceEligibility fceEligibility = new FceEligibility();
    if (fceEligibilityDB.hasIdFceEligibility()) {
      fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility((int) fceEligibilityDB.getIdFceEligibility());
    }
    if (fceEligibilityDB.hasIdFceReview()) {
      FceReview fceReview = fceReviewDAO.findFceReviewByIdFceReview((int) fceEligibilityDB.getIdFceReview());
      fceEligibility.setFceReview(fceReview);
    }
    if (fceEligibilityDB.hasIdFceApplication()) {
      FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdFceApplication((int) fceEligibilityDB.getIdFceApplication());
      fceEligibility.setFceApplication(fceApplication);
    }
    if (fceEligibilityDB.hasIdCase()) {
      CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, (int) fceEligibilityDB.getIdCase());
      fceEligibility.setCapsCase(capsCase);
    }
    if (fceEligibilityDB.hasIdStage()) {
      Stage stage = (Stage) getPersistentObject(Stage.class, (int) fceEligibilityDB.getIdStage());
      fceEligibility.setStage(stage);
    }
    if (fceEligibilityDB.hasIdLastUpdatePerson()) {
      Person lastUpdatePerson = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdLastUpdatePerson());
      fceEligibility.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    }
    if (fceEligibilityDB.hasIdFcePerson()) {
      FcePerson fcePerson = (FcePerson) getPersistentObject(FcePerson.class, (int) fceEligibilityDB.getIdFcePerson());
      fceEligibility.setFcePerson(fcePerson);
    }
    if (fceEligibilityDB.hasIdPerson()) {
      Person person = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPerson());
      fceEligibility.setPersonByIdPerson(person);
    }
    if (fceEligibilityDB.hasIdPersonAllocMutual1()) {
      Person personAllocMutual1 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocMutual1());
      fceEligibility.setPersonAllocMutual1(personAllocMutual1);
    }
    if (fceEligibilityDB.hasIdPersonAllocMutual2()) {
      Person personAllocMutual2 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocMutual2());
      fceEligibility.setPersonAllocMutual2(personAllocMutual2);
    }
    if (fceEligibilityDB.hasIdPersonAllocSngl1()) {
      Person personAllocSngl1 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocSngl1());
      fceEligibility.setPersonAllocSngl1(personAllocSngl1);
    }
    if (fceEligibilityDB.hasIdPersonAllocSngl2()) {
      Person personAllocSngl2 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocSngl2());
      fceEligibility.setPersonAllocSngl2(personAllocSngl2);
    }
    if (fceEligibilityDB.hasIdPersonDeemIndiv1()) {
      Person personDeemIndiv1 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonDeemIndiv1());
      fceEligibility.setPersonDeemIndiv1(personDeemIndiv1);
    }
    if (fceEligibilityDB.hasIdPersonDeemIndiv2()) {
      Person personDeemIndiv2 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonDeemIndiv2());
      fceEligibility.setPersonDeemIndiv2(personDeemIndiv2);
    }
    if (fceEligibilityDB.hasIdPrnEarner()) {
      Person prnEarner = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPrnEarner());
      fceEligibility.setPersonByIdPrnEarner(prnEarner);
    }
    if (fceEligibilityDB.hasIdEligibilityEvent()) {
      Event event = (Event) getPersistentObject(Event.class, (int) fceEligibilityDB.getIdEligibilityEvent());
      fceEligibility.setEvent(event);
    }
    fceEligibility = PopulateFceUtility.populateFceEligibility(fceEligibilityDB, fceEligibility);
    fceEligibilityDAO.saveFceEligibility(fceEligibility);
    return fceEligibility.getIdFceEligibility();
  }
}
