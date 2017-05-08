/**
 * Created on Jan 8, 2007 at 4:13:37 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.reports;

import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportPageSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveReportSI;

public interface RetrieveReport {
  RetrieveReportSO retrieveReport(RetrieveReportSI retrieveReportSI);
  /**
   * This service will retrieve a list of all reports to be displayed on the 
   * Report LaunchList window.
   *
   * @return List<RetrieveReportPageSO>
   */
  List<RetrieveReportPageSO> retrieveAllReportPageReports(int idUser);
}
