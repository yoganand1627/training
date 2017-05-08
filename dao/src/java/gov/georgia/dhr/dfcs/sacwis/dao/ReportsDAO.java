/**
 * Created on Mar 25, 2006 at 3:24:07 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.Reports;

public interface ReportsDAO {
  /**
   * This selects a row from Reports given nmRptSqrName.
   *
   * @param nmRptSqrName
   * @param nmRptSqrVer
   * @return A populated {@link gov.georgia.dhr.dfcs.sacwis.db.Reports} object
   */
  Reports findReport(String nmRptSqrName, String nmRptSqrVer);

  /**
   * This selects a list of reports that are used on the Reports Launch Page
   *
   * @return List<Reports> 
   */
  List<Reports>  findReportsPageReports();
  
  int executeFinValidation();
}
