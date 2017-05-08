package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngoingSO;

public interface RetrieveCwOngoing {

  /**
   * This Service retrieves ongoing stage info for the Case Watch page
   * 
   * @param CaseWatchSI
   *          object
   * @return {@link CwOngoingSO} object
   */

  public CwOngoingSO retrieveCwOngoing(CaseWatchSI caseWatchSI);

}
