package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV09SO;

public interface SaveMultipleAllegationDetail {
  /**
   * @param cinv09si
   * @return An empty {@link CINV09SO} object.
   */
  CINV09SO saveMultipleAllegationDetail(CINV09SI cinv09si);
}
