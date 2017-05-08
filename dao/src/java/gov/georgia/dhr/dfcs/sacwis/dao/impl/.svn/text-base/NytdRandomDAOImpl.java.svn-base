package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.NytdRandomDAO;

public class NytdRandomDAOImpl extends BaseDAOImpl implements NytdRandomDAO {

  public Integer findIdNytdRandomByIdPersonIdYouthRptDtl(Integer idPerson, Integer idYouthReportDtl, Date dtRptPeriodEnd) {
    // TODO Auto-generated method stub
    String strQuery = "select n.idNytdRandom" +
    		      " from NytdRandom n" +
    		      " where n.person.idPerson = :idPerson" +
    		      " and n.youthReportDtl.idYouthReportDtl = :idYouthReportDtl" +
    		      " and n.dtRptPeriodEnd = :dtRptPeriodEnd";
    Query query = getSession().createQuery(strQuery);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idYouthReportDtl", idYouthReportDtl);
    query.setDate("dtRptPeriodEnd", dtRptPeriodEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdNytdRandomByIdPerson(Integer idPerson){
    String strQuery = "select n.idNytdRandom" + " from NytdRandom n" + " where n.person.idPerson = :idPerson";
    Query query = getSession().createQuery(strQuery);
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

}
