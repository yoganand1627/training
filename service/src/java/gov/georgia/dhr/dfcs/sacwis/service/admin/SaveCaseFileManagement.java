package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC22SO;

public interface SaveCaseFileManagement {

  /**
   * This service will save all columns for an IdCase to the CASE FILE MANAGEMENT table.  There will be one row for a
   * specified IdCase.  Furthermore, it will check to see if the MailCode/Region/Program specified exists as well as the
   * Unit/Region/Program exists.  Additionally, it will retrieve a full row from the CAPS CASE table to get the closure
   * date for the Case.
   *
   * @param ccfc22si
   * @return
   */
  public CCFC22SO saveCaseFileManagement(CCFC22SI ccfc22si);
}
