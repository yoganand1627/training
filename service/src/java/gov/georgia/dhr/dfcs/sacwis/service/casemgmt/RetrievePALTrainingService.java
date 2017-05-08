package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC10SO;

public interface RetrievePALTrainingService {

  /**
   * This service will retrieve the Event Status from the EVENT table given the specified ID_EVENT.  If upon retreieving
   * the Event Status, The status is not "NEW", then a row must must be retrieved from the PAL table as well.  It will
   * retrieve al columns from the PAL SERVICES table given a specific ID STAGE. Additionally, it will get a smart date
   * for the PAL stage by retrieving the Stage record from the STAGE table.
   *
   * @param ccfc10si
   * @return A populated {@link CCFC10SO} object. if the retreive fails.
   */
  public CCFC10SO retrievePALTrainningService(CCFC10SI ccfc10si);
}
