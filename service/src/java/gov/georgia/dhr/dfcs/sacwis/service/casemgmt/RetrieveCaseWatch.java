package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSO;

public interface RetrieveCaseWatch {

  /**
   * This Service retrieves data for the Case Watch page
   * 
   * @param CaseWatchSI
   *          object
   * @return {@link CaseWatchSO} object
   */

  public CaseWatchSO retrieveCaseWatch(CaseWatchSI caseWatchSI);

}
