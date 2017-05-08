package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;

public interface AgeAndCitizenshipCommonFunction {

  /**
   * This saves the CdPersonCitizenship in the FCE_ELIGIBILITY table
   * @param long idFceEligibility, String cdPersonCitizenship
   */
  public void updateFceEligibilityCdPersonCitizenship(long idFceEligibility, String cdPersonCitizenship);
  
  /**
   * This saves the IndEvalConclusion in the FCE_ELIGIBILITY table
   * @param long idFceApplication, String indEvaluationConclusion
   */
  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion);
  
  /**
   * This retrieves data from FCE_PERSON table
   * @param long idFceEligibility, long idPerson
   * @return FcePersonDB
   */
  public FcePersonDB findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson);
  
  /**
   * This retrieves the idPerson of the child for the stage_person_link table
   * @param long idStage, String cdStagePersonRole
   * @return long
   */
  public long findPrimaryChildForStage (long idStage, String cdStagePersonRole);
  
  /**
   * This does a retrieve from the FCE_REVIEW Table by idReviewEvent
   * 
   * @param idReviewEvent
   * @return FceReview
   */
  public FceReviewDB findReviewByReviewEvent(long idReviewEvent); 

}
