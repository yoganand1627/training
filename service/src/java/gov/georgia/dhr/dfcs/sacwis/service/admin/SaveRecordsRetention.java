package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC20SO;

public interface SaveRecordsRetention {

  /**
   * This service will add/update all columns for an Id Case from the RECORDS RETENTION table.
   *
   * @param ccfc20si
   * @return
   */
  public CCFC20SO saveRecordsRetention(CCFC20SI ccfc20si);
}
