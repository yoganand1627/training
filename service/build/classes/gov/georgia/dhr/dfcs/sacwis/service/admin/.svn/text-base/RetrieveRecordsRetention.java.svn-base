package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO;

public interface RetrieveRecordsRetention {

  /**
   * This service will retrieve all columns for an ID Case from the Records Retention table.  There will be one row for
   * a specified ID Case.  Additionally, it will retrieve a full row from the CAPS CASE table to get the closure date
   * for case.
   *
   * @param ccfc19si
   * @return
   */
  public CCFC19SO findRecordsRetention(CCFC19SI ccfc19si);
}
