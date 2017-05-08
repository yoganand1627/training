package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceReview;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveFceReviewImpl extends BaseServiceImpl implements SaveFceReview {
  
  private FceReviewDAO fceReviewDAO = null;
  private FceEligibilityDAO fceEligibilityDAO = null;
  private FceApplicationDAO fceApplicationDAO = null;
  private EventDAO eventDAO = null;
  
  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public int saveFceReview(FceReviewDB fceReviewDB) {
    FceReview fceReview = new FceReview();
    
    if (fceReviewDB.hasIdFceReview()) {
      fceReview = fceReviewDAO.findFceReviewByIdFceReview((int) fceReviewDB.getIdFceReview());
    }
    if (fceReviewDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(
                                                          (int) fceReviewDB.getIdFceEligibility());
      fceReview.setFceEligibility(fceEligibility);
    }  
    if (fceReviewDB.hasIdFceApplication()) {
      FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdFceApplication((int) fceReviewDB.getIdFceApplication());
      fceReview.setFceApplication(fceApplication);
    }
    if (fceReviewDB.hasIdCase()) {
      CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceReviewDB.getIdCase());
      fceReview.setCapsCase(capsCase);
    }
    if (fceReviewDB.hasIdCurrentPlacementEvent()) {
      Event event = eventDAO.findEventByIdEvent((int) fceReviewDB.getIdCurrentPlacementEvent());
      fceReview.setEventByIdCurrentPlacementEvent(event);
    }
    if (fceReviewDB.hasIdEvent()) {
      Event event = eventDAO.findEventByIdEvent((int) fceReviewDB.getIdEvent());
      fceReview.setEventByIdEvent(event);
    }
    if (fceReviewDB.hasIdLastUpdatePerson()) {
      Person person = getPersistentObject(Person.class, (int) fceReviewDB.getIdLastUpdatePerson());
      fceReview.setPerson(person);
    }
    if (fceReviewDB.hasIdPlacementRateEvent()) {
      Event event = eventDAO.findEventByIdEvent((int) fceReviewDB.getIdPlacementRateEvent());
      fceReview.setEventByIdPlacementRateEvent(event);
    }
    if (fceReviewDB.hasIdStage()) {
      Stage stage = getPersistentObject(Stage.class, (int) fceReviewDB.getIdStage());
      fceReview.setStage(stage);
    }
    fceReview = PopulateFceUtility.populateFceReview(fceReviewDB, fceReview);
    fceReviewDAO.saveFceReview(fceReview);
    return fceReview.getIdFceReview();
  }
}
