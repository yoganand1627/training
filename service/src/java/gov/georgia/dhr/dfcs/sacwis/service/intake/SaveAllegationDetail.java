package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO;

public interface SaveAllegationDetail {

  /**
   * AUD for the Allegation Detail Window.
   *
   * @param {@link cinv47si}
   * @return {@link CINV47SO}
   */
  CINV47SO saveAllegDtl(CINV47SI cinv47si);
}
