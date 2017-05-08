package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO;

public interface RetrieveStaffSecurity {

  /**
   * Retrieves security information for a given employee from the Employee Table if it exists. It also retrieves any
   * temporary assignments of the employee, which can be up to five assignments.
   *
   * @param carc14si The input object that contains the method parameters.
   * @return CARC14SO The output object populated with the returned row/column values.
   */
  public CARC14SO findEmployeeSecurityInformation(CARC14SI carc14si);

}
