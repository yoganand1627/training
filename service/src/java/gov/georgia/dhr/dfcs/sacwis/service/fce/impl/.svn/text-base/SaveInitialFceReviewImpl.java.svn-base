package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveInitialFceReview;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveInitialFceReviewImpl extends BaseServiceImpl implements SaveInitialFceReview {
  
  private FceReviewDAO fceReviewDAO = null;
  
  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }

  public int saveInitialFceReview(FceReviewDB fceReviewDB){
    FceReview fceReview = new FceReview();
    CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceReviewDB.getIdCase());
    fceReview.setCapsCase(capsCase);
    Event event1 = getPersistentObject(Event.class, (int) fceReviewDB.getIdCurrentPlacementEvent());
    fceReview.setEventByIdCurrentPlacementEvent(event1);
    Event event2 = getPersistentObject(Event.class, (int) fceReviewDB.getIdEvent());
    fceReview.setEventByIdEvent(event2);
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                          (int) fceReviewDB.getIdFceApplication());
    fceReview.setFceApplication(fceApplication);
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceReviewDB.getIdFceEligibility());
    fceReview.setFceEligibility(fceEligibility);
    Person person = getPersistentObject(Person.class, (int) fceReviewDB.getIdLastUpdatePerson());
    fceReview.setPerson(person);
    Event event3 = getPersistentObject(Event.class, (int) fceReviewDB.getIdPlacementRateEvent());
    fceReview.setEventByIdPlacementRateEvent(event3);
    Stage stage = getPersistentObject(Stage.class, (int) fceReviewDB.getIdStage());
    fceReview.setStage(stage);
    fceReviewDAO.saveFceReview(fceReview);
    return fceReview.getIdFceReview();
  }

}
