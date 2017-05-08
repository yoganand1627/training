/**
 * Created on Mar 25, 2006 at 3:23:46 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ReportParameter;

public interface ReportParameterDAO {
  /**
   * Retrieves rows from the REPORT PARAMETER table given the nmRptSqrName and the nmRptSqrVer
   *
   * @param nmRptSqrName
   * @param nmRptSqrVer
   * @return List of ReportParameter by nmRptSqrName and nmRptSqrVer
   */
  @SuppressWarnings({"unchecked"})
  List<ReportParameter> findReportParameter(String nmRptSqrName, String nmRptSqrVer);
  /**
   * 
   * @param nmRptSqrName
   * @param nmRptParmName
   * @param nmRptSqrVer
   * @return Get the Report Parameter Object
   */
  @SuppressWarnings({"unchecked"})
  public ReportParameter findNbrRptParmSeq(String nmRptSqrName, String nmRptParmName, String nmRptSqrVer);
}
