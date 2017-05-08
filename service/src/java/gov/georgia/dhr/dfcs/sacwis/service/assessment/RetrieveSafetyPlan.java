package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyPlanRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO;

public interface RetrieveSafetyPlan {

  /**
   * A retrieval service which obtains Safety Assessment
   *
   * @param safetyPlaneRetrieveSI
   * @return A populated {@link gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO} object.
   */
  public SafetyPlanRetrieveSO retrieveSafetyPlan(SafetyPlanRetrieveSI safetyPlaneRetrieveSI);
}
