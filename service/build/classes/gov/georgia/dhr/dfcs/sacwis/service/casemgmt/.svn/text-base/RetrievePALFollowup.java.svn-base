package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO;

public interface RetrievePALFollowup {

  /**
   * This service will retrieve the Event Status from the EVENT table given the specified ID EVENT.  If upon retrieving
   * the Event Status, the Status is not "NEW" then a row must be retrieved from the PAL table as well. It will retrieve
   * all columns from the PAL FOLLOWUP table given the specified ID STAGE.  It will also retrieve all the rows from the
   * PAL PUBLIC ASSIST table given the specified ID STAGE.  There will only be one event retrieved from the CCMN45D DAM,
   * one record retrieved from the PAL FOLLOWUP table and zero to many records from the PAL PUBLIC ASSIST table.
   *
   * @param ccfc07si
   * @return
   */
  public CCFC07SO retrievePALFollowup(CCFC07SI ccfc07si);
}
