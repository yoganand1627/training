package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC08SO;

public interface SavePALFollowup {

  /**
   * Description: This service will update all columns for an Id Stage from the PAL FOLLOWUP table.  Additionally, it
   * will add/delete rows from the PAL PUBLIC ASSIST table given an Id Stage and a Cd PAL Public Assist code. It will
   * also update all the columns for an Id Event from the EVENT row. It can add or modify the EVENT row.  It will also
   * retrieve the primary child for the PAl stage in order to link the event with the primary child when adding/updating
   * the followup event. </p>
   *
   * @param ccfc08si
   */
  public CCFC08SO savePALFollowup(CCFC08SI ccfc08si);
}
