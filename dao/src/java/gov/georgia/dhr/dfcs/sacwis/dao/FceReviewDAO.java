package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FceReview;

public interface FceReviewDAO {
  /**
   * This does a retrieve from the FCE_REVIEW Table by idReviewEvent
   * 
   * @param idReviewEvent
   * @return FceReview
   */
  public FceReview findFceReviewByIdReviewEvent(long idReviewEvent);
  
   
  /**
   * This does a retrieve from the FCE_REVIEW Table by the given ID_EVENT
   * 
   * @param idEvent
   * @return FceReviewDB
   */
  FceReview findFceReviewByIdEvent(int idEvent);

  public FceReview findFceReviewByIdFceReview(long idFceReview);
  
  /**
   * This saves data in the FCE_REVIEW Table 
   * 
   * @param fceReview
   */
  public void saveFceReview(FceReview fceReview);
  
  /**
   * This updates a row in the FCE_REVIEW table with CdLivingConditionCurrent
   * 
   * @param idFceReview
   * @param cdLivingConditionCurrent
   * @return Integer indication how many rows were updated
   */
  public int updateFceReviewByCdLivingConditionCurrent(long idFceReview, String cdLivingConditionCurrent);
  
  /**
  * This does a retrieve from the FCE_REVIEW table with idEvent
  * 
  * @param idEvent
  * @return FceReview
  */
  public FceReview findFceReviewByIdEventAndDtReviewComplete(int idEvent);

}
