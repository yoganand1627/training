package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC29SO;

public interface RetrieveIncomeAndResources {

  /**
   * This service will retrieve all records from the INCOME AND RESOURCES table that have an ID PERSON equal to the one
   * passed into the service. Same DAM will retrieve the NM PERSON FULL from the PERSON table for each ID PERSON. The
   * service will also retrieve the system date and the sum of incomes and resources for the person passed in for the
   * current month.
   *
   * @param ccfc29si
   * @return {@link CCFC29SO}
   */
  public CCFC29SO retrieveIncomeAndResources(CCFC29SI ccfc29si);
}
