package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO;

public interface RetrievePrincipalsForRiskAssessment {
  /**
   * This service fills the Principal list box on the Risk Assessment window.
   *
   * @param cinv36si
   * @return A populated {@link CINV36SO} object.
   */
  public CINV36SO retrievePrincipalsForRiskAssessment(CINV36SI cinv36si);
}
