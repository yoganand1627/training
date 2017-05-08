package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV31SO;

public interface SaveProfessionalAssessment {
  /**
   * Inserts/updates EventPersonLink, Event, Todo and ProfessionalAssmt tables.
   *
   * @param cinv31si
   * @return
   */
  CINV31SO saveProfessionalAssessment(CINV31SI cinv31si);

}
