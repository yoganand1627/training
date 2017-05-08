/**
 * Created on April 6, 2007 at by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimit;

import java.util.List;

import org.hibernate.Query;

/** @author vishala devarakonda */

public class CaseBudgetLimitDAOImpl extends BaseDAOImpl implements CaseBudgetLimitDAO {

  public CaseBudgetLimit findByIdCaseBySvcCode(int idCase, String cdSvcAuthCode) {
    Query query = getSession().createQuery("    from CaseBudgetLimit a " +
                                           "   where a.capsCase.idCase = :idCase " +
                                           "     and a.id.cdSvcCode = :cdSvcAuthCode " +
                                           "order by a.dtLastUpdate desc");
    query.setInteger("idCase", idCase);
    query.setString("cdSvcAuthCode", cdSvcAuthCode);
    return (CaseBudgetLimit) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<CaseBudgetLimit> findCaseBudgetLimitListByIdCase(int idCase) {
    Query query = getSession().createQuery("    from CaseBudgetLimit a " +
                                           "   where a.capsCase.idCase = :idCase " +
                                           "order by a.dtLastUpdate desc");
    query.setInteger("idCase", idCase);
    return (List<CaseBudgetLimit>) query.list();
  }

 @SuppressWarnings("unchecked")
 public List<CaseBudgetLimit> findCaseBudgetLimitBySmileInvoiceParams(String cdSvcCode1, String cdSvcCode2,
                                                                       String cdSvcCode0, int idSvcAuthDtl) {
   
    Query query = getSession().createQuery(" select distinct cbl from CaseBudgetLimit cbl, " +
                                           " Event e, " + 
                                           " SvcAuthDetail sad, " +
                                           " SvcAuthEventLink svl, " +
                                           " DelvrdSvcDtl dsl " +
                                           " where cbl.id.idCase = e.capsCase.idCase " +
                                           " and sad.idSvcAuthDtl = :idSvcAuthDtl " +
                                           " and dsl.svcAuthDetail.idSvcAuthDtl = sad.idSvcAuthDtl " +
                                           " and sad.serviceAuthorization.idSvcAuth = svl.serviceAuthorization.idSvcAuth " +
                                           " and svl.idSvcAuthEvent = e.idEvent " +
                                           " and (cbl.id.cdSvcCode = :cdSvcCode1 " +
                                           " or cbl.id.cdSvcCode = :cdSvcCode2 " +
                                           " or cbl.id.cdSvcCode = :cdSvcCode0) "); 
    query.setString("cdSvcCode1", cdSvcCode1);
    query.setString("cdSvcCode2", cdSvcCode2);
    query.setString("cdSvcCode0", cdSvcCode0);
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (List<CaseBudgetLimit>) query.list();   
    
  }
  
  public int updateCaseBudgetLimitByIdSvcAuthDtl(int idSvcAuthDtl, String cdSvcCode, double addAmtSpent) {
    Query query = getSession().createQuery("update CaseBudgetLimit cbl " +
                                           "   set cbl.amtSpent = nvl(cbl.amtSpent, 0) + :addAmtSpent, " +
                                           "       cbl.amtRemain = nvl(cbl.amtRemain, 0) - :addAmtSpent " +
                                           " where cbl.id.cdSvcCode = :cdSvcCode " +
                                           "   and cbl.id.idCase in ( " +
                                           "       select sael.capsCase.idCase " +
                                           "         from SvcAuthEventLink sael " +
                                           "       where sael.serviceAuthorization.idSvcAuth = ( " +
                                           "             select sad.serviceAuthorization.idSvcAuth " +
                                           "               from SvcAuthDetail sad " +
                                           "              where sad.idSvcAuthDtl = :idSvcAuthDtl " +
                                           "             ) " +
                                           "       )");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setString("cdSvcCode", cdSvcCode);
    query.setDouble("addAmtSpent", addAmtSpent);
    return query.executeUpdate();
  }
  
  public int updateCaseBudgetLimitByIdSvcAuthDtlForTermDate(int idSvcAuthDtl, String cdSvcCode, double addAmtSpent) {
    Query query = getSession().createQuery("update CaseBudgetLimit cbl " +
                                           "   set cbl.amtSpent = nvl(cbl.amtSpent, 0) + :addAmtSpent, " +
                                           "       cbl.amtBalance = nvl(cbl.amtBalance, 0) - :addAmtSpent " +
                                           " where cbl.id.cdSvcCode = :cdSvcCode " +
                                           "   and cbl.id.idCase in ( " +
                                           "       select sael.capsCase.idCase " +
                                           "         from SvcAuthEventLink sael " +
                                           "       where sael.serviceAuthorization.idSvcAuth = ( " +
                                           "             select sad.serviceAuthorization.idSvcAuth " +
                                           "               from SvcAuthDetail sad " +
                                           "              where sad.idSvcAuthDtl = :idSvcAuthDtl " +
                                           "             ) " +
                                           "       )");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setString("cdSvcCode", cdSvcCode);
    query.setDouble("addAmtSpent", addAmtSpent);
    return query.executeUpdate();
  }


  public void saveCaseBudgetLimit(CaseBudgetLimit csBLmt) {
    getSession().saveOrUpdate(csBLmt);
  }
}