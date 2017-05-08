package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.CprsOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CprsOutbound;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

public class CprsOutboundDAOImpl extends BaseDAOImpl implements CprsOutboundDAO {

  @SuppressWarnings({"unchecked"})
  public List<Integer> findCasesForCountyAndDate(String county, Date searchDate) {
    Query query = getSession().createQuery(" select idCase " +
                                           " from CprsOutbound" +
                                           " where dtCaseUpdated >= :searchDate" +
                                           " and cdCounty = :county"
                                           );
    query.setDate("searchDate", searchDate);
    query.setString("county", county);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<CprsOutbound> findCprsOutboundCasesForCountyAndDate(String county, Date searchDate) {
    Query query = getSession().createQuery(" from CprsOutbound" +
                                           " where dtCaseUpdated >= :searchDate" +
                                           " and cdCounty = :county"
                                           );
    query.setDate("searchDate", searchDate);
    query.setString("county", county);
    return (List<CprsOutbound>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public CprsOutbound findCprsOutboundByCaseId(int idCase) {
    Query query = getSession().createQuery(" from CprsOutbound " +
                                           " where idCase = :idCase ");
    query.setInteger("idCase", idCase);
    return (CprsOutbound) query.uniqueResult();
  }
  
  @SuppressWarnings({"unchecked"})
  public int updateProcessedCase(Integer idCase, String error) {
    Query query = getSession().createQuery(" update CprsOutbound" +
                                           " set cdError = :cdError," + 
                                           " dtProcess = :dtProcess" +
                                           " where idCase = :idCase");
    query.setInteger("idCase", idCase);
    query.setDate("dtProcess", new Date());
    query.setString("cdError", error);
    return query.executeUpdate();
  }
  
  public int updateProcessedCases(List<Integer> idCases, String error) {
    Query query = getSession().createQuery(" update CprsOutbound" +
                                           " set cdError = :cdError," + 
                                           " dtProcess = :dtProcess" +
                                           " where idCase in (:idCases)");
    
    query.setParameterList("idCases", idCases);
    query.setDate("dtProcess", new Date());
    query.setString("cdError", error);
    return query.executeUpdate();
  }
}
