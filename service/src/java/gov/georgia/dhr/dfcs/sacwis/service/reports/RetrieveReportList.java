package gov.georgia.dhr.dfcs.sacwis.service.reports;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06SO;

/**
 * This interface provides the service method definitions for retrieving the Report List 
 * 
 * <pre>
 *    Change History:
 *    Date      User        Description
 *    --------  ----------  --------------------------------------------------
 *    12/01/08  alwilliams  STGAP00009474 - Added the interface prologue
 *                        
 * </pre>
 */
public interface RetrieveReportList {

  /**
   * This service will retrieve a list of all reports to be displayed on the Report List window.
   *
   * @param carc06si {@link CARC06SI}
   * @return {@link CARC06SO}
   */
  CARC06SO retrieveReportList(CARC06SI carc06si);
}
