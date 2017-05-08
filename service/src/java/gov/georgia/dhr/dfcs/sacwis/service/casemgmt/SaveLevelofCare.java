package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB17SO;

public interface SaveLevelofCare {

  /**
   * This service confirms that event processsing is OK using CheckStageEvent Status function and add/update an Event
   * row and a LevelofCare row. If primary child is unknown, it will be determined.  Oracle trigger will be set on the
   * PersonLOC table to write to its shadow table. The shadow table will trigger an update to the adjustment table.
   *
   * @param csub17si The input object populated with the method parameter (row/column) values.
   * @return The output object populated with the retrieved row/column values.
   */
  public CSUB17SO saveEventAndLevelofCare(CSUB17SI csub17si);
}
