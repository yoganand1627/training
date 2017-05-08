package gov.georgia.dhr.dfcs.sacwis.launcher.dao;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface RptLauncherDAO {

  /**
   * The method is called by the jxls report job to retrieve the data for the job
   *
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   * @param sql - sql to be executed
   * @param params - the params for report the bind variables for the sql 
   * @return List of maps that is return by the query
   */
  public List<Map<String, Object>> performJXLSQuery(String sql, Map<String, Object> params);
 
}
