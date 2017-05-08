/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASProgramCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UasProgramCodeMtnt;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * @author hong-van.t.vo
 * 
 */
public class UASProgramCodeMtntDAOImpl extends BaseDAOImpl implements UASProgramCodeMtntDAO {

  @SuppressWarnings("unchecked")
  public List<UasProgramCodeMtnt> findUasProgramCodeMtnts() {
    Query query = getSession().createQuery(" from UasProgramCodeMtnt p ");
    return (List<UasProgramCodeMtnt>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<UasProgramCodeMtnt> findActiveUasProgramCodeMtnts() {
    Query query = getSession().createQuery(" from UasProgramCodeMtnt p, " + " CodesTable t"
                                                           + " where t.id.codeType = 'CPRGCODE' "
                                                           + " and t.dtEnd is null " + " and t.id.code = p.cdUas "
                                                           + " order by u.cdUas asc");
    return (List<UasProgramCodeMtnt>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<Map> findActiveUasProgramCodes() {
    Query query = getSession().createQuery("select distinct new map("
                                                           + " u.idUasProgramCodeMtnt as idUasProgramCodeMtnt, "
                                                           + " u.cdUas as cdUas, " + " u.dtEffective as dtEffective, "
                                                           + " u.dtLastUpdate as dtLastUpdate, "
                                                           + " p.idPerson as idPersonLastUpdate, "
                                                           + " p.nmPersonFull as nmPersonLastUpdate, "
                                                           + " u.txtProgramDesc as txtProgramDesc) "
                                                           + " from UasProgramCodeMtnt u "
                                                           + " left join u.personLastUpdate p, " + " CodesTables t "
                                                           + " where t.id.codeType = 'CPRGCODE' "
                                                           + " and t.dtEnd is null " + " and t.id.code = u.cdUas "
                                                           + " order by u.cdUas asc");
    return (List<Map>) query.list();
  }

  public UasProgramCodeMtnt findUasProgramCodeMtnt(int idUasProgramCodeMtnt) {
    Query query = getSession().createQuery(" from UasProgramCodeMtnt p "
                                                           + " where p.idUasProgramCodeMtnt = :idUasProgramCodeMtnt");
    query.setInteger("idUasProgramCodeMtnt", idUasProgramCodeMtnt);
    return (UasProgramCodeMtnt) query.uniqueResult();
  }

  public int updateUasProgramCodeMtnt(int idUasProgramCodeMtnt, String cdProgramType, String txtProgramDesc,
                                      Date dtEffective, String indCCI, String indCPA, String indSvcAuth,
                                      String indPSSF, String indInvAddOn, int idPersonLastUpdate) {
    Query query = getSession().createQuery(" update UasProgramCodeMtnt p " + " set p.cdProgramType = :cdProgramType, "
                                                           + " p.txtProgramDesc = :txtProgramDesc, "
                                                           + " p.dtEffective = :dtEffective, "
                                                           + " p.indCci = :indCCI, " + " p.indCpa = :indCPA, "
                                                           + " p.indPssf = :indPSSF, "
                                                           + " p.indServAuth = :indSvcAuth, "
                                                           + " p.indInvAddon = :indInvAddOn, "
                                                           + " p.personLastUpdate.idPerson = :idPersonLastUpdate "
                                                           + " where p.idUasProgramCodeMtnt = :idUasProgramCodeMtnt");
    query.setInteger("idUasProgramCodeMtnt", idUasProgramCodeMtnt);
    query.setString("cdProgramType", cdProgramType);
    query.setString("txtProgramDesc", txtProgramDesc);
    query.setDate("dtEffective", dtEffective);
    query.setString("indCCI", indCCI);
    query.setString("indCPA", indCPA);
    query.setString("indSvcAuth", indSvcAuth);
    query.setString("indPSSF", indPSSF);
    query.setString("indInvAddOn", indInvAddOn);
    query.setInteger("idPersonLastUpdate", idPersonLastUpdate);
    return query.executeUpdate();
  }

  public int saveUasProgramCodeMtnt(UasProgramCodeMtnt uasProgramCodeMtnt) {
    getSession().saveOrUpdate(uasProgramCodeMtnt);
    return uasProgramCodeMtnt.getIdUasProgramCodeMtnt();
  }

  public UasProgramCodeMtnt findUasProgramCodeMtntByCdUas(String cdUasProgramCode) {
    Query query = getSession().createQuery(" from UasProgramCodeMtnt p "
                                                           + " where p.cdUas = :cdUasProgramCode");
    query.setString("cdUasProgramCode", cdUasProgramCode);
    return (UasProgramCodeMtnt) query.uniqueResult();
  }
  
  public Integer findIdUasProgramCodeMtntByCdUas(String cdUasProgramCode) {
    Query query = getSession().createQuery(" select p.idUasProgramCodeMtnt from UasProgramCodeMtnt p "
                                                           + " where p.cdUas = :cdUasProgramCode");
    query.setString("cdUasProgramCode", cdUasProgramCode);
    return (Integer) query.uniqueResult();
  }

}
