package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO;

public interface RetrieveCaseFileManagement {

  /**
   * This service will retrieve all columns for an Id Case from the CASE FILE MANAGEMENT table.  There will be one row
   * for for a specified Id Case. It will retrieve a full row from both the OFFICE and UNIT tables with the ID OFFICE
   * and ID UNIT respectively.  The service will also retrieve a full row from the CAPS CASE table to get the closure
   * date for the Case.  Finally, it will check to see if the person who entered the window is the primary worker.
   *
   * @param ccfc21si
   * @return A populated {@link CCFC21SO} object.
   */
  public CCFC21SO retrieveCaseFileManagement(CCFC21SI ccfc21si);
}
