package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;

public interface RetrieveOnCallList {
  /**
   * Retrieves data for On Call List window's ListBox:(full row of the ON CALL table) The service calls a single DAO.
   *
   * @param ccmn06si The input object populated with the method parameters
   * @return The ouput object populated with retrieved row/column values
   */
  public CCMN06SO findOnCallList(CCMN06SI ccmn06si);
}
