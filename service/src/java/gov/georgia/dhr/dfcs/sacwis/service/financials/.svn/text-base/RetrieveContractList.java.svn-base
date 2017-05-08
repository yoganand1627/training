package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON01SO;

public interface RetrieveContractList {

  /**
   * This service will retrieve a list of contract records matching a set of dynamic search criteria. The columns it
   * retrieves are Contract ID, Region, Function Type, Program Type, Budget Limit Indicator, and Contract Manager Name
   * from the Contracts table and Resource ID, Resource Name  and Resource VID from the Resource Address table.
   *
   * @param ccon01si
   * @return CCON01SO
   */
  CCON01SO retrieveContractList(CCON01SI ccon01si);
}
