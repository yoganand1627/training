package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO;

public interface RetrieveAssign {

  static final String FULL_UNITS_VIEW = "F";
  static final String ON_CALL_VIEW = "O";

  /**
   * Retrieves information needed in order to assign an employee to a stage
   *
   * @param ccmn80si The input object that contains the method parameters.
   * @return CCMN80SO The output object populated with the returned rows/column values.
   */
  public CCMN80SO retrieveEmployeeAssignInfo(CCMN80SI ccmn80si);
}
