/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * @author ekemini.s.udofiah
 *
 */
public class PortalUserDAOImpl extends BaseDAOImpl implements PortalUserDAO {
  public PortalUser findPortalUserbyIdUser(int idUser) {
    Query query = getSession().createQuery(" from  PortalUser p " +
                                           " where p.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    return (PortalUser) firstResult(query);
  }
  public PortalUser findPortalUserbyLoginEmailId(String txtEmail) {
    Query query = getSession().createQuery(" from  PortalUser p " +
                                            " where upper(p.txtUserEmail) = upper(:txtEmail) ");
    query.setString("txtEmail", txtEmail);
    return (PortalUser) firstResult(query);
  }
  public Object[] findValidateLoginInfoByTxtEmail(String txtEmail) {
    //DO NOT change the order as it will affect the validateLoginImpl service
    SQLQuery query = getSession().createSQLQuery(" Select decrypt(TXT_PASSWORD) as txt_password,  " //element 0
                                                 + " DT_LAST_PASSWD_RESET, " //element 1
                                                 + " IND_PASSWD_TEMP, " //element 2
                                                 + " NBR_FAILED_LOGIN_ATTEMPTS, " //element 3
                                                 + " CD_QUESTION_1, " //element 4
                                                 + " CD_QUESTION_2, " //element 5
                                                 + " CD_QUESTION_3, " //element 6
                                                 + " decrypt(TXT_ANSWER_1) as txt_answer_1, " //element 7
                                                 + " decrypt(TXT_ANSWER_2) as txt_answer_2, " //element 8
                                                 + " decrypt(TXT_ANSWER_3) as txt_answer_3, " //element 9
                                                 + " CD_STATUS, " //element 10
                                                 + " ID_USER " //element 11
                                                 + " from PORTAL_USER "
                                                 + " where upper(TXT_USER_EMAIL) = upper(:txtEmail) ");

    query.setString("txtEmail", txtEmail);
       
    return (Object[]) firstResult(query);
  }
  
  public Object[] findValidateLoginInfoByIdUser(int idUser){
    //DO NOT change the order as it will affect the validateLoginImpl service
    SQLQuery query = getSession().createSQLQuery(" Select decrypt(txt_password) as txt_password,  " //element 0
                                                 + " Dt_Last_Passwd_Reset, " //element 1
                                                 + " Ind_Passwd_Temp, " //element 2
                                                 + " Nbr_Failed_Login_Attempts, " //element 3
                                                 + " Cd_Question_1, " //element 4
                                                 + " Cd_Question_2, " //element 5
                                                 + " Cd_Question_3, " //element 6
                                                 + " decrypt(Txt_Answer_1) as txt_answer_1, " //element 7
                                                 + " decrypt(Txt_Answer_2) as txt_answer_2, " //element 8
                                                 + " decrypt(Txt_Answer_3) as txt_answer_3, " //element 9
                                                 + " Cd_Status, " //element 10
                                                 + " id_user " //element 11
                                                 + " from portal_user "
                                                 + " where id_user = :idUser ");

    query.setInteger("idUser", idUser);
    return (Object[]) firstResult(query);
  }
  public void updatePortalUserForNumFailedAttempts(String txtEmail, int numFailedAttempt){
    SQLQuery query = getSession().createSQLQuery( " update portal_user " +
                                        " set NBR_FAILED_LOGIN_ATTEMPTS = :numFailedAttempt " +
                                        " where upper(txt_user_email) = upper(:txtEmail) ");
    query.setString("txtEmail", txtEmail);
    query.setInteger("numFailedAttempt", numFailedAttempt);
    query.executeUpdate();
  }
  public void updatePortalUserForChangePassword(String txtEmail, int numFailedAttempt, String newPassword){
    SQLQuery query = getSession().createSQLQuery( " update PORTAL_USER " +
                                        " SET NBR_FAILED_LOGIN_ATTEMPTS = :numFailedAttempt, " +
                                        " IND_PASSWD_TEMP = 'N', " +
                                        " TXT_PASSWORD = encrypt(:newPassword) " +
                                        " where upper(TXT_USER_EMAIL) = upper(:txtEmail) ");
    query.setString("txtEmail", txtEmail);
    query.setInteger("numFailedAttempt", numFailedAttempt);
    query.setString("newPassword", newPassword);
    query.executeUpdate();
  }
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findPreviousPasswordsByTxtEmail(String txtEmail, int numRowsReturned){
    //DO NOT change the order as it will affect the validateLoginImpl service
    SQLQuery query = getSession().createSQLQuery(" select max_dt_last_update, txt_password "
                                                +" from " 
                                                +" (Select max(dt_last_update) as max_dt_last_update, "
                                                +" decrypt(txt_password) as txt_password "
                                                +" from portal_user_audit "
                                                +" where upper(TXT_USER_EMAIL) = upper(:txtEmail) "
                                                +" group by  decrypt(txt_password) "
                                                +" order by max_dt_last_update desc "
                                                +" )where ROWNUM <= :numRowsReturned ");

    query.setString("txtEmail", txtEmail);
    query.setInteger("numRowsReturned", numRowsReturned);   
    return (List<Object[]>)query.list();
  }
  
  public void savePortalUser(PortalUser portalUser) {
    getSession().saveOrUpdate(portalUser);
  }
  
  public int saveNewPortalUser(Session session, PortalUser portalUser, String txtSecAns1, 
                               String txtSecAns2, String txtSecAns3,
                               String txtPassword) {
    session.saveOrUpdate(portalUser);
    int idUser = portalUser.getIdUser();
    Query query = session.createQuery(" update PortalUser pu " +
                                     " set pu.txtAnswer1  = encrypt(:txtSecAns1), " +
                                     " pu.txtAnswer2 = encrypt(:txtSecAns2), " +
                                     " pu.txtAnswer3 = encrypt(:txtSecAns3), " +
                                     " pu.txtPassword = encrypt(:txtPassword) " +
                                     " where pu.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    query.setString("txtSecAns1", txtSecAns1);
    query.setString("txtSecAns2", txtSecAns2);
    query.setString("txtSecAns3", txtSecAns3);
    query.setString("txtPassword", txtPassword);
    query.executeUpdate(); 
    return portalUser.getIdUser();
  }
  
  public long countPortalUserByTxtEmail(String txtEmail){
    Query query = getSession().createQuery(" select count(*) from PortalUser pu " +
                                                 " where upper(pu.txtUserEmail) = upper(:txtEmail) ");
    query.setString("txtEmail", txtEmail);
    return (Long) query.uniqueResult();
  }
  
  public long countPortalUserByTxtEmailAndNotIdUser(String txtEmail, int idUser){
    Query query = getSession().createQuery(" select count(*) from PortalUser pu " +
                                                 " where upper(pu.txtUserEmail) = upper(:txtEmail) " +
                                                 " and pu.idUser <> :idUser ");
    query.setInteger("idUser", idUser);
    query.setString("txtEmail", txtEmail);
    return (Long) query.uniqueResult();
  }  
  public PortalUser findPortalUserbyIdUserSession(Session session, int idUser) {
    Query query = session.createQuery(" from  PortalUser p " +
                                           " where p.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    return (PortalUser) firstResult(query);
  }
  
  public void resetPassword(String txtPassword, int idUser){
   Query query = getSession().createQuery(" update PortalUser pu " +
                                      " set pu.txtPassword = encrypt(:txtPassword), " +
                                      " pu.indPasswdTemp = 'Y', " +
                                      " pu.nbrFailedLoginAttempts = 0 " +
                                      " where pu.idUser = :idUser ");
   query.setInteger("idUser", idUser);
   query.setString("txtPassword", txtPassword);
   query.executeUpdate();
  }
  
  public void approvePortalUser(int idUser){
    Query query = getSession().createQuery(" update PortalUser pu " +
                                           " set pu.cdStatus = 'ACT' " +
                                           " where pu.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    query.executeUpdate();    
  }
  public void updatePortalUserForSecurityChangesByIdUser(int idUser, String txtAns1,
                                                         String txtAns2, String txtAns3){
    Query query = getSession().createQuery(" update PortalUser pu " +
                                      " set pu.txtAnswer1  = encrypt(:txtAns1), " +
                                      " pu.txtAnswer2 = encrypt(:txtAns2), " +
                                      " pu.txtAnswer3 = encrypt(:txtAns3) " +
                                      " where pu.idUser = :idUser ");
     query.setInteger("idUser", idUser);
     query.setString("txtAns1", txtAns1);
     query.setString("txtAns2", txtAns2);
     query.setString("txtAns3", txtAns3);
     query.executeUpdate(); 
  }
  public void updatePortalUserForChangePasswordByIdUser(int idUser, String newPassword, Date lastUpdateDt){
    Query query = getSession().createQuery(" update PortalUser pu " +
                                           " set pu.txtPassword = encrypt(:newPassword), " +
                                           " pu.dtLastPasswdReset = :lastUpdateDt " +
                                           " where pu.idUser = :idUser ");
          query.setInteger("idUser", idUser);
          query.setString("newPassword", newPassword);
          query.setDate("lastUpdateDt", lastUpdateDt);
          query.executeUpdate();     
  }
  public void deletePortalUserByIdUser(int idUser){
    Query query = getSession().createQuery(" delete PortalUser pu " +
                                           " where pu.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    query.executeUpdate();       
  }
  
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPendingPortalAdmins(int pageNbr, int pageSize) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(a.nmUserFull as nmUserFull,"
                                                           + "               a.idUser as idUser, "
                                                           + "               a.txtOther as nmResource1,  " 
                                                           + "		     b.nmResource as nmResource2, "
                                                           + "               b.idResource as idResource,"
                                                           + "               a.txtUserEmail as addrRsrcEmail,"
                                                           + "               a.nbrUserPhone as nbrRsrcContactPhn,"
                                                           + "               a.cdRequestType as cdAccessType,"
                                                           + "               a.cdStatus as cdStatus,"
                                                           + "               c.dtStart as dtStart,"
                                                           + "               c.dtEnd as dtEnd) "
                                                           + "               FROM PortalUserVendorLink c "
                                                           + "               right join c.portalUser a"
                                                           + "               left join c.capsResource b" 
                                                           + "               WHERE a.cdRequestType = :type"
                                                           + "               AND a.cdStatus = :status"
                                                           + "               ORDER BY a.nmUserFull asc");
    
    query.setString("type", CodesTables.CUSRTYP_PAD);
    query.setString("status", CodesTables.CUSRSTAT_PEN);
    
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
}
