package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;

public interface SaveInitialFceReview {
  
  /**  This service saves the initial record in FCE_REVIEW table with
   *   required data filled in.
   *   @param fceReviewDB
   *   @return int
   */
  
  public int saveInitialFceReview(FceReviewDB fceReviewDB);

}
