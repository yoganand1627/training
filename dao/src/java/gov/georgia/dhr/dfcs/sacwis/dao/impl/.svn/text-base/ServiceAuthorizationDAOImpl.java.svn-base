package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *  02/18/2010    mxpatel               SMS #45630: Modified the code to consider amount as well when checking for svc_auth_dtl                                                                     
 * </pre>
 * 
 */

public class ServiceAuthorizationDAOImpl extends BaseDAOImpl implements ServiceAuthorizationDAO {
  public ServiceAuthorization findServiceAuth(int idSvcAuth) {
    Query query = getSession().createQuery(" from ServiceAuthorization sa " + "where sa.idSvcAuth = :idSvcAuth");
    query.setInteger("idSvcAuth", idSvcAuth);
    return (ServiceAuthorization) firstResult(query);
  }

  public ServiceAuthorization findServiceAuthEventLink(int idSvcAuthEvent) {
    Query query = getSession().createQuery(
                                           "select sae.serviceAuthorization from SvcAuthEventLink sae "
                                                           + "where sae.idSvcAuthEvent = :idSvcAuthEvent");
    query.setInteger("idSvcAuthEvent", idSvcAuthEvent);
    return (ServiceAuthorization) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  // Added for STGAP00012399 ,STGAP00012838
  public List<ServiceAuthorization> findServAuthByIdPrimaryClient(int idPersonClosed) {
    Query query = getSession().createQuery(
                                           " from ServiceAuthorization sa "
                                                           + " where sa.personByIdPrimaryClient.idPerson = :idPersonClosed ");
    query.setInteger("idPersonClosed", idPersonClosed);
    return (List<ServiceAuthorization>) query.list();

  }
  
  public SvcAuthDetail findServiceAuthDetail(int idSvcAuthDtl) {
    Query query = getSession().createQuery(" from SvcAuthDetail sad " + "where sad.idSvcAuthDtl = :idSvcAuthDtl");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (SvcAuthDetail) firstResult(query);
  }

  public int findIdServiceAuthByIdContractIdRsrcCdSvcDtl(int idContract, int idResource, String cdSvcDtl) {
    SQLQuery query = getSession().createSQLQuery("SELECT sa.ID_SVC_AUTH " 
                                           + "FROM SERVICE_AUTHORIZATION sa, SVC_AUTH_DETAIL sd "
                                           + "WHERE sa.ID_CONTRACT = :idContract "
                                           + "AND sa.ID_SVC_AUTH = sd.ID_SVC_AUTH "
                                           + "AND sd.CD_SVC_AUTH_DTL_SVC = :cdSvcDtl "
                                           + "AND sa.ID_RESOURCE = :idResource "
                                           + "AND sd.DT_SVC_AUTH_DTL_BEGIN <= SYSDATE "
                                           + "AND sd.DT_SVC_AUTH_DTL_END >= SYSDATE");

    query.setInteger("idContract", idContract);
    query.setInteger("idResource", idResource);
    query.setString("cdSvcDtl", cdSvcDtl);
    
    BigDecimal result = (BigDecimal) firstResult(query);
    if (result == null) {
      return 0;
    }
    return Integer.parseInt(String.valueOf(result));


  }
  
  @SuppressWarnings("unchecked")
  public int findServiceAuthByIdPrimaryClient(int idPrimaryClient, String cdSvcDtl, double amountAdoSub) {
    //STGAP00011586: send the SYSDATE to the trunc function so that the timestamp is not
    // used in the date comparison (dates are typically stored with 12:00 AM as the time
    // and this would invalidate the query if we left the timestamp in.
    SQLQuery query = getSession().createSQLQuery("SELECT sa.ID_SVC_AUTH " 
                                                 + "FROM SERVICE_AUTHORIZATION sa, SVC_AUTH_DETAIL sd "
                                                 + "WHERE sa.ID_PRIMARY_CLIENT = :idPrimaryClient "
                                                 + "AND sa.ID_SVC_AUTH = sd.ID_SVC_AUTH "
                                                 + "AND sd.CD_SVC_AUTH_DTL_SVC = :cdSvcDtl "
                                                 + "AND sd.DT_SVC_AUTH_DTL_BEGIN <= trunc(SYSDATE) "
                                                 + "AND sd.AMT_SVC_AUTH_DTL_AMT_REQ = :amountAdoSub "
                                                 + "AND sd.DT_SVC_AUTH_DTL_END >= trunc(SYSDATE)");

    query.setInteger("idPrimaryClient", idPrimaryClient);
    query.setString("cdSvcDtl", cdSvcDtl);
    query.setDouble("amountAdoSub", amountAdoSub);

    BigDecimal result = (BigDecimal) firstResult(query);
    if (result == null) {
      return 0;
    }
    return Integer.parseInt(String.valueOf(result));
    
  }
  
  public int insertServiceAuthorization(int idSvcAuth, int idPrimaryClient, Date dtLastUpdate, String cdSvcAuthCounty,
                                        int idResource, int idContract, String cdSvcAuthCategory,
                                        String cdSvcAuthService, String txtSvcAuthComments, String txtSvcAuthSecProvdr,
                                        Date dtSvcAuthEff, String indWaiverReqd, Date dtRefSent, String cdPayCnty,
                                        int idWaiver, String cdPupTyp, String cdErlyCaseTyp, String cdPupOtcme) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "INSERT INTO SERVICE_AUTHORIZATION (ID_SVC_AUTH, "
                                                                 + "                                   ID_PRIMARY_CLIENT, "
                                                                 + "                                   DT_LAST_UPDATE, "
                                                                 + "                                   CD_SVC_AUTH_COUNTY, "
                                                                 + "                                   ID_RESOURCE, "
                                                                 + "                                   ID_CONTRACT, "
                                                                 + "                                   CD_SVC_AUTH_CATEGORY, "
                                                                 + "                                   CD_SVC_AUTH_SERVICE, "
                                                                 + "                                   TXT_SVC_AUTH_COMMENTS, "
                                                                 + "                                   TXT_SVC_AUTH_SEC_PROVDR, "
                                                                 + "                                   DT_SVC_AUTH_EFF, "
                                                                 + "                                   IND_WAIVER_REQD, "
                                                                 + "                                   DT_REF_SENT, "
                                                                 + "                                   CD_PAY_CNTY, "
                                                                 + "                                   ID_WAIVER, "
                                                                 + "                                   CD_PUP_TYP, "
                                                                 + "                                   CD_ERLY_CASE_TYP, "
                                                                 + "                                   CD_PUP_OTCME) "
                                                                 + "     VALUES (:idSvcAuth, "
                                                                 + "             :idPrimaryClient, "
                                                                 + "             :dtLastUpdate, "
                                                                 + "             :cdSvcAuthCounty, "
                                                                 + "             :idResource, "
                                                                 + "             :idContract, "
                                                                 + "             :cdSvcAuthCategory, "
                                                                 + "             :cdSvcAuthService, "
                                                                 + "             :txtSvcAuthComments, "
                                                                 + "             :txtSvcAuthSecProvdr, "
                                                                 + "             :dtSvcAuthEff, "
                                                                 + "             :indWaiverReqd, "
                                                                 + "             :dtRefSent, "
                                                                 + "             :cdPayCnty, "
                                                                 + "             :idWaiver, "
                                                                 + "             :cdPupTyp, "
                                                                 + "             :cdErlyCaseTyp, "
                                                                 + "             :cdPupOtcme )");
    query.setInteger("idSvcAuth", idSvcAuth);
    query.setInteger("idPrimaryClient", idPrimaryClient);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setString("cdSvcAuthCounty", cdSvcAuthCounty);
    query.setInteger("idResource", idResource);
    query.setInteger("idContract", idContract);
    query.setString("cdSvcAuthCategory", cdSvcAuthCategory);
    query.setString("cdSvcAuthService", cdSvcAuthService);
    query.setString("txtSvcAuthComments", txtSvcAuthComments);
    query.setString("txtSvcAuthSecProvdr", txtSvcAuthSecProvdr);
    query.setTimestamp("dtSvcAuthEff", dtSvcAuthEff);
    query.setString("indWaiverReqd", indWaiverReqd);
    query.setTimestamp("dtRefSent", dtRefSent);
    query.setString("cdPayCnty", cdPayCnty);
    query.setInteger("idWaiver", idWaiver);
    query.setString("cdPupTyp", cdPupTyp);
    query.setString("cdErlyCaseTyp", cdErlyCaseTyp);
    query.setString("cdPupOtcme", cdPupOtcme);
    return query.executeUpdate();
  }

  public int updateServiceAuthorization(String cdSvcAuthCounty, int idResource, int idContract,
                                        String cdSvcAuthCategory, String cdSvcAuthService, String txtSvcAuthComments,
                                        String txtSvcAuthSecProvdr, int idSvcAuth, Date dtLastUpdate,
                                        String indWaiverReqd, Date dtRefSent, String cdPayCnty, int idWaiver,
                                        String cdPupTyp, String cdErlyCaseTyp, String cdPupOtcme) {
    Query query = getSession().createQuery(
                                           "update ServiceAuthorization"
                                                           + "    set cdSvcAuthCounty = :cdSvcAuthCounty, "
                                                           + "        capsResource.idResource = :idResource, "
                                                           + "        contract.idContract = :idContract, "
                                                           + "        cdSvcAuthCategory = :cdSvcAuthCategory, "
                                                           + "        cdSvcAuthService = :cdSvcAuthService, "
                                                           + "        txtSvcAuthComments = :txtSvcAuthComments, "
                                                           + "        txtSvcAuthSecProvdr = :txtSvcAuthSecProvdr, "
                                                           + "        indWaiverReqd = :indWaiverReqd, "
                                                           + "        dtRefSent = :dtRefSent, "
                                                           + "        cdPayCnty = :cdPayCnty, "
                                                           + "        idWaiver = :idWaiver, "
                                                           + "        cdPupTyp = :cdPupTyp, "
                                                           + "        cdErlyCaseTyp = :cdErlyCaseTyp, "
                                                           + "        cdPupOtcme = :cdPupOtcme "
                                                           + "  where idSvcAuth = :idSvcAuth "
                                                           + "    and dtLastUpdate = :dtLastUpdate ");
    query.setString("cdSvcAuthCounty", cdSvcAuthCounty);
    query.setInteger("idResource", idResource);
    query.setInteger("idContract", idContract);
    query.setString("cdSvcAuthCategory", cdSvcAuthCategory);
    query.setString("cdSvcAuthService", cdSvcAuthService);
    query.setString("txtSvcAuthComments", txtSvcAuthComments);
    query.setString("txtSvcAuthSecProvdr", txtSvcAuthSecProvdr);
    query.setString("indWaiverReqd", indWaiverReqd);
    query.setDate("dtRefSent", dtRefSent);
    query.setString("cdPayCnty", cdPayCnty);
    query.setInteger("idWaiver", idWaiver);
    query.setString("cdPupTyp", cdPupTyp);
    query.setString("cdErlyCaseTyp", cdErlyCaseTyp);
    query.setString("cdPupOtcme", cdPupOtcme);
    query.setInteger("idSvcAuth", idSvcAuth);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  // Added for STGAP00012399 ,STGAP00012838
  public int updateServiceAuthorizationWithForwardPerson(int idPersonForward, int idPersonClosed) {
    Query query = getSession().createQuery(
                                           "update ServiceAuthorization sa"
                                                           + "  set  sa.personByIdPrimaryClient  = :idPersonForward "
                                                           + "  where sa.personByIdPrimaryClient = :idPersonClosed ");

    query.setInteger("idPersonForward", idPersonForward);
    query.setInteger("idPersonClosed", idPersonClosed);
    return query.executeUpdate();
  }    
  
  public void saveServiceAuthorization(ServiceAuthorization serviceAuthorization) {
    getSession().saveOrUpdate(serviceAuthorization);
  }
 
  public int deleteServiceAuthorization(int idSvcAuth) {
    SQLQuery query = getSession().createSQLQuery("CALL COMPLEX_DELETE.DELETE_SERVICE_AUTH(:idSvcAuth)");
    query.setInteger("idSvcAuth", idSvcAuth);
    return query.executeUpdate();
  }
}
