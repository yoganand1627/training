package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseReviewRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewRetrieveSO;

public interface RetrieveCaseReview {

  /**
   * @param caseReviewRetrieveSI
   * @return CaseReviewRetrieveSO.
   */
  public CaseReviewRetrieveSO retrieveCaseReview(CaseReviewRetrieveSI caseReviewRetrieveSI);
  public static final String NO_RECUR = "No";
  public static final String YES_RECUR = "Yes";

}
