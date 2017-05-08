package gov.georgia.dhr.dfcs.sacwis.service.reports;

import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportParametersSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC21SO;

public interface RetrieveReportParmlist {
  /**
   * This service will fetch a report's parameter list and re-launch
   *
   * @param carc21si {@link CARC21SI}
   * @return {@link CARC21SO}
   */
  public CARC21SO retrieveReportParamList(CARC21SI carc21si);

  /**
   * This service will fetch a report's parameter list for the Launch screen
   *
   * @param string nmRptSqrName
   * @param string nmRptSqrVer
   * @return List<ReportParameterSO> 
   */
  public List<RetrieveReportParametersSO> retrieveLaunchReportParameters(String nmRptSqrName, String nmRptSqrVer);
}
