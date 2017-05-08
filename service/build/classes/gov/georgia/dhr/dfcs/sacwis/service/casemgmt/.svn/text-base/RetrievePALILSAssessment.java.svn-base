package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC01SO;

public interface RetrievePALILSAssessment {

  /**
   * Description: This service will retrieve the Event Status from the EVENT stable given the specified ID EVENT.  If
   * upon retrieving the Event Status, the Status is not "NEW" then a row must be retrieved from the PAL table as well.
   * It will retrieve all columns from the PAL table given the specified ID STAGE.  There will only be one event one
   * record retrieved from the PAL table.
   *
   * @param ccfc01si
   */
  public CCFC01SO retrieveEventStatus(CCFC01SI ccfc01si);

}
