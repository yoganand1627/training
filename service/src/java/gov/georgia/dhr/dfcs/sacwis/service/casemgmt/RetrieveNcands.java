package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsSO;

public interface RetrieveNcands {

  /**
   * This Service retrieves NCANDS data for the Case Watch page
   * 
   * @param CaseWatchSI
   *          object
   * @return {@link NcandsSO} object
   */

  public NcandsSO retrieveNcands(CaseWatchSI caseWatchSI);

}
