package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.ReportParameterDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ReportParameter;
import org.hibernate.Query;

public class ReportParameterDAOImpl extends BaseDAOImpl implements ReportParameterDAO {
  @SuppressWarnings({"unchecked"})
  public List<ReportParameter> findReportParameter(String nmRptSqrName, String nmRptSqrVer) {
    Query query = getSession().createQuery(" from ReportParameter r " +
                                           "where r.reports.id.nmRptSqrName = :nmRptSqrName " +
                                           "  and r.reports.id.nmRptSqrVer = :nmRptSqrVer" + 
                                           "  order by r.nbrRptParmSeq");
    query.setString("nmRptSqrName", nmRptSqrName);
    query.setString("nmRptSqrVer", nmRptSqrVer);
    return (List<ReportParameter>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public ReportParameter findNbrRptParmSeq(String nmRptSqrName, String nmRptParmName, String nmRptSqrVer){
    Query query = getSession().createQuery(" from ReportParameter r " +
                                           "where r.reports.id.nmRptSqrName = :nmRptSqrName " +
                                           "  and r.reports.id.nmRptSqrVer = :nmRptSqrVer" +                                           
                                           "  and r.nmRptParmName = :nmRptParmName" + 
                                           "  order by r.nbrRptParmSeq");
    query.setString("nmRptSqrName", nmRptSqrName);
    query.setString("nmRptParmName", nmRptParmName);
    query.setString("nmRptSqrVer", nmRptSqrVer);
    return (ReportParameter) firstResult(query);
  }
}
