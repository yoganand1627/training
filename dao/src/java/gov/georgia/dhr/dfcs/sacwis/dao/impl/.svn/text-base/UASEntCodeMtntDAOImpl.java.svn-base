/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASEntCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtnt;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * @author hong-van.t.vo
 * 
 */
public class UASEntCodeMtntDAOImpl extends BaseDAOImpl implements UASEntCodeMtntDAO {

  public UasEntCodeMtnt findEntCodeMtntsByIdEnt(int idUasEntCodeMtnt) {
    // TODO Auto-generated method stub
    return null;
  }

  @SuppressWarnings("unchecked")
  public List<String> findCdEntListByIdProgram(int idUasProgramCodeMtnt) {
    Query query = getSession().createQuery(" select e.cdEntCode from "
                                                           + " UasEntCodeMtnt e "
                                                           + " where e.uasProgramCodeMtnt.idUasProgramCodeMtnt = :idUasProgramCodeMtnt ");
    query.setInteger("idUasProgramCodeMtnt", idUasProgramCodeMtnt);
    return (List<String>) query.list();
  }

  public Map findEntDetailByIdEnt(int idUasEntCodeMtnt) {
    Query query = getSession().createQuery(" select new map (e.cdEntCode as cdEntCode, e.indEntHeader as indEntHeader) from "
                                                           + " UasEntCodeMtnt e "
                                                           + " where e.idUasEntCodeMtnt = :idUasEntCodeMtnt ");
    query.setInteger("idUasEntCodeMtnt", idUasEntCodeMtnt);
    return (Map) query.uniqueResult();
  }
  
  @SuppressWarnings("unchecked")
  public List<String> findCdUasByCdEntCodeHeader(String cdEntHeader) {
    Query query = getSession().createQuery(" select distinct e.uasProgramCodeMtnt.cdUas from UasEntCodeMtnt e "
                                                           + " where cdEntCode = :cdEntHeader "
                                                           + " and e.indEntHeader = 'Y'");
    query.setString("cdEntHeader", cdEntHeader);
    return (List<String>) query.list();
  }

  public void saveUasEntCodeMtnt(UasEntCodeMtnt uasEntCodeMtnt) {
    getSession().saveOrUpdate(uasEntCodeMtnt);
  }

  @SuppressWarnings("unchecked")
  public List<UasEntCodeMtnt> findEntCodeMtntsByIdProgram(int idUasProgramCodeMtnt) {
    Query query = getSession().createQuery(" from "
                                                           + " UasEntCodeMtnt e "
                                                           + " where e.uasProgramCodeMtnt.idUasProgramCodeMtnt = :idUasProgramCodeMtnt ");
    query.setInteger("idUasProgramCodeMtnt", idUasProgramCodeMtnt);
    return (List<UasEntCodeMtnt>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> findCdSvcCodeByIdProgram(int idUasProgramCodeMtnt) {
    Query query = getSession().createQuery(" select new map (upper(e.cdSvcCode) as svcCode, upper(e.idUasEntCodeMtnt) as idEnt)  "
                                                           + " from UasEntCodeMtnt e "
                                                           + " where e.uasProgramCodeMtnt.idUasProgramCodeMtnt = :idUasProgramCodeMtnt ");
    query.setInteger("idUasProgramCodeMtnt", idUasProgramCodeMtnt);
    return (List<Map<String, Object>>) query.list();
  }
  
  public Double findCaseBudgetLimitByHeader(String header) {
    Query query = getSession().createQuery(" select e.amtCaseBudgetLimit from UasEntCodeMtnt e "
                                           + " where e.cdSvcCode = :header " +
                                           		" and e.cdAlpha is null " +
                                           		" and e.indEntHeader = 'Y'");
    query.setString("header", header);
    return (Double) firstResult(query);
  }
  

}
