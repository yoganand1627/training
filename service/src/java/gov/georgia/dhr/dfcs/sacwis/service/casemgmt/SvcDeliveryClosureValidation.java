package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC16SO;

public interface SvcDeliveryClosureValidation {

  /**
   * Performs a series of edits to determine if Service Delivery is complete or not and will either close the Stage,
   * prepare it for submittal, or return warnings from the edits.
   *
   * @param csvc16si
   * @return
   */
  CSVC16SO svcDeliveryClosureValidation(CSVC16SI csvc16si);

}
