package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ReportParameter;
import gov.georgia.dhr.dfcs.sacwis.db.Reports;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class ReportsDAOImpl extends BaseDAOImpl implements ReportsDAO {
  public Reports findReport(String nmRptSqrName, String nmRptSqrVer) {
    Query query = getSession().createQuery(" from Reports r " +
                                           "where r.id.nmRptSqrName = :nmRptSqrName " +
                                           "  and r.id.nmRptSqrVer  = :nmRptSqrVer ");
    query.setString("nmRptSqrName", nmRptSqrName);
    query.setString("nmRptSqrVer", nmRptSqrVer);
    return (Reports) firstResult(query);
  }
  @SuppressWarnings("unchecked")
  public List<Reports> findReportsPageReports() {
	    Query query = getSession().createQuery(" from Reports r " +
	                                           "where indRptPage = :indRptPage " + 
                                                   "order by r.txtRptAreaType, r.txtRptFullName");
	    query.setString("indRptPage", "Y");
	    return (List<Reports>) query.list();
  }
  
  public int executeFinValidation() {
	    SQLQuery query = getSession().createSQLQuery("CALL FIN_VALIDATION()");
	    int retVal = query.executeUpdate();
	    return retVal;
	  }
}