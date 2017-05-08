package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO;

public interface RetrieveCaseList {
  /**
   * Retrieves all the cases for window - Case List. This service calls a dynamic search dao that returns cases and a
   * dao that retrieves the county name of each case county code.
   *
   * @param ccmn20si The input object populated with method parameters.
   * @return CCMN20SO The ouput object populated with retrieved row/column values.
   */
  public CCMN20SO findCaseListInformation(CCMN20SI ccmn20si);

}
