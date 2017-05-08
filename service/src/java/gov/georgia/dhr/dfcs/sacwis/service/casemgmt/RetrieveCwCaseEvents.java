package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventsSO;

public interface RetrieveCwCaseEvents {

  /**
   * This Service retrieves case events for the Case Watch page
   * 
   * @param CaseWatchSI
   *          object
   * @return {@link CaseWarningsSO} object
   */

  public CwCaseEventsSO retrieveCwCaseEvents(CaseWatchSI caseWatchSI);

}
