package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO;

public interface RetrieveCwCaseWarnings {

  /**
   * This Service retrieves case warnings for the Case Watch page
   * 
   * @param CaseWatchSI
   *          object
   * @return {@link CaseWarningsSO} object
   */

  public CaseWarningsSO retrieveCwCaseWarnings(CaseWatchSI caseWatchSI);

}
