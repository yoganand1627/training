package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO;

public interface RetrieveSafetyAssessment {

  /**
   * A retrieval service which obtains Safety Assessment
   *
   * @param safetyAssessmentRetrieveSI
   * @return A populated {@link gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO} object.
   */
  public SafetyAssessmentRetrieveSO retrieveSafetyAssessment(SafetyAssessmentRetrieveSI safetyAssessmentRetrieveSI);
}