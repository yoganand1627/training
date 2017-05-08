package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;

public interface FceRedeterminationCommonFunction {
  
  /**
   * This retrieves a record from FCE_ELIGIBILITY for idFceApplication.
   * 
   * @param long idFceApplication
   * @return FceEligibilityDB
   */  
  public FceEligibilityDB retrieveEligibilityByIdFceApplication(long idFceApplication);
  
  /**
   * This updates the FCE_ELIGIBILITY table with cdBlocChild.
   * 
   * @param String cdBlocChild
   */  
  public int updateFceEligibilityCdBlocChild(long idFceEligibility, String cdBlocChild);
  
  /**
   * This updates the FCE_ELIGIBILITY table with current judicial review.
   * 
   * @param FceReviewDB fceReviewDB
   */  
  public void updateReimbursabilityJudicialRequirements(FceReviewDB fceReviewDB);
}
