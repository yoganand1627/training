/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.SvcAuthUasEntCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthUasEntCode;

import java.util.List;

import org.hibernate.Query;

public class SvcAuthUasEntCodeDAOImpl extends BaseDAOImpl implements SvcAuthUasEntCodeDAO {

  @SuppressWarnings("unchecked")
  public List<Integer> findIdSvcAuthUasEntCode() {
    Query query = getSession().createQuery("select s.idSvcAuthUasEntCode " +
    		"from SvcAuthUasEntCode s");
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<String> findSvcAuthHeaderCodes() {
    Query query = getSession().createQuery("select s.cdUas || s.cdEnt " +
                "from SvcAuthUasEntCode s");
    return (List<String>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<String> findCdUasByCdEnt(String cdEnt) {
    Query query = getSession().createQuery("select distinct s.cdUas " +
                "from SvcAuthUasEntCode s " +
                "where s.cdEnt = :cdEnt");
    query.setString("cdEnt", cdEnt);
    return (List<String>) query.list();
  }
  
  public int saveSvcAuthUasEntCode(SvcAuthUasEntCode saHeader) {
    getSession().saveOrUpdate(saHeader);
    return saHeader.getIdSvcAuthUasEntCode();
  }
  
  public int deleteSvcAuthUasEntCodeByCdUasCdEnt(String cdUas, String cdEnt) {
    Query query = getSession().createQuery("delete from SvcAuthUasEntCode s " +
    		"where s.cdUas = :cdUas " +
                "and s.cdEnt = :cdEnt");
    query.setString("cdUas", cdUas);
    query.setString("cdEnt", cdEnt);
    return query.executeUpdate();
  }
}
