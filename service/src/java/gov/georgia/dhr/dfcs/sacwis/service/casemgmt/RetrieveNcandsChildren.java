package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenSO;

public interface RetrieveNcandsChildren {

  /**
   * This Service retrieves the list of children with NCANDS data 
   * for the Case Watch page
   * 
   * @param CaseWatchSI
   *          object
   * @return {@link NcandsChildrenSO} object
   */

  public NcandsChildrenSO retrieveNcandsChildren(CaseWatchSI caseWatchSI);

}
