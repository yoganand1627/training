package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;

import java.io.Serializable;

public class ReviewHelper implements Serializable {
  protected static FceReviewDB createReview(long idCase, long idEvent, long idFceApplication, long idFceEligibility,
                                            long idStage) {
    FceReviewDB fceReviewDB = new FceReviewDB();
    fceReviewDB.setIdCase(idCase);
    fceReviewDB.setIdEvent(idEvent);
    fceReviewDB.setIdFceApplication(idFceApplication);
    fceReviewDB.setIdFceEligibility(idFceEligibility);
    fceReviewDB.setIdStage(idStage);
    return fceReviewDB;
  }
}
