package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class SvcAuthEventLinkDAOImpl extends BaseDAOImpl implements SvcAuthEventLinkDAO {

  @SuppressWarnings( { "unchecked" })
  public List<Map> findEventStageAndIdSvcAuthByIdSvcAuth(int idSvcAuth) {
    Query query = getSession().createQuery(
                                           "select new map(s.cdStage as cdStage," + "        s.idStage as idStage,"
                                                           + "        s.dtStageClose as dtStageClose,"
                                                           + "        e.idEvent as idEvent,"
                                                           + "        e.cdEventStatus as cdEventStatus,"
                                                           + "        e.cdEventType as cdEventType,"
                                                           + "        e.cdTask as cdTask,"
                                                           + "        sv.serviceAuthorization.idSvcAuth as idSvcAuth)"
                                                           + "   from SvcAuthEventLink sv" + "      join sv.event e"
                                                           + "      join e.stage s"
                                                           + "  where sv.serviceAuthorization.idSvcAuth = :idSvcAuth");
    query.setInteger("idSvcAuth", idSvcAuth);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  // Added for MR-52
  public List<Map> findLinkedServAuthByIdStagecdProgType(int idStage, String cdSvcAuthCategory, int idSpecNeedDet) {
    Query query = getSession().createQuery(
                                           "select distinct new map(sa.idSvcAuth as idSvcAuth, " + "        sa.cdSvcAuthCounty as cdSvcAuthCounty,"
                                                           + "        sa.capsResource.idResource as idResource,"
                                                           + "        sa.contract.idContract as idContract,"
                                                           + "        sa.personByIdPrimaryClient.idPerson as idPrimaryClient,"
                                                           + "        sa.personByIdPerson.idPerson as idPerson,"
                                                           + "        sa.cdSvcAuthAbilToRespond as cdSvcAuthAbilToRespond,"
                                                           + "        sa.cdSvcAuthRegion as cdSvcAuthRegion,"
                                                           + "        sa.cdSvcAuthCategory as cdSvcAuthCategory,"
                                                           + "        sa.cdSvcAuthService as cdSvcAuthService,"
                                                           + "        sa.dtSvcAuthVerbalReferl as dtSvcAuthVerbalReferl,"
                                                           + "        sa.dtSvcAuthEff as dtSvcAuthEff,"
                                                           + "        sa.indSvcAuthComplete as indSvcAuthComplete,"
                                                           + "        sa.txtSvcAuthComments as txtSvcAuthComments,"
                                                           + "        sa.txtSvcAuthDirToHome as txtSvcAuthDirToHome,"
                                                           + "        sa.txtSvcAuthHomeEnviron as txtSvcAuthHomeEnviron,"
                                                           + "        sa.txtSvcAuthMedCond as txtSvcAuthMedCond,"
                                                           + "        sa.txtSvcAuthSecProvdr as txtSvcAuthSecProvdr,"
                                                           + "        sa.indDontdComntySvc as indDontdComntySvc,"
                                                           + "        sa.amtEstValue as amtEstValue,"
                                                           + "        sa.cdPayCnty as cdPayCnty,"
                                                           + "        sa.indWaiverReqd as indWaiverReqd,"                                                                                                                                                                                                                                                                                                                                                                                                               
                                                           + "        sa.idWaiver as idWaiver,"
                                                           + "        sa.dtRefSent as dtRefSent,"
                                                           + "        sa.cdErlyCaseTyp as cdErlyCaseTyp,"
                                                           + "        sa.cdPupTyp as cdPupTyp,"
                                                           + "        sa.cdPupOtcme as cdPupOtcme,"
                                                           + "        sel.event.txtEventDescr as txtEventDescr)"
                                                           + "     from SvcAuthEventLink sel, " 
                                                           + "          ServiceAuthorization sa, " 
                                                           + "          SvcAuthDetail sad, " 
                                                           + "          Stage s " 
                                                           + " where s.capsCase.idCase = sel.capsCase.idCase "
                                                           + " and sa.idSvcAuth = sel.serviceAuthorization.idSvcAuth "
                                                           + " and sad.serviceAuthorization.idSvcAuth = sa.idSvcAuth "
                                                           + " and sad.specialNeedsDetermination.idEvent = :idSpecNeedDet "
                                                           + " and sel.event.cdEventStatus = 'APRV' "
                                                           + " and sa.cdSvcAuthCategory = :cdSvcAuthCategory "
                                                           + " and s.idStage = :idStage ");
    query.setInteger("idSpecNeedDet", idSpecNeedDet);
    query.setInteger("idStage", idStage);
    query.setString("cdSvcAuthCategory", cdSvcAuthCategory);
    return (List<Map>) query.list();

  }

  public SvcAuthEventLink findSvcAuthEventLinkByEventId(int idSvcAuthEvent) {
    Query query = getSession().createQuery("from SvcAuthEventLink s " + "where s.idSvcAuthEvent = :idSvcAuthEvent ");
    query.setInteger("idSvcAuthEvent", idSvcAuthEvent); 
    return (SvcAuthEventLink) firstResult(query);
  }

  public void saveSvcAuthEventLink(SvcAuthEventLink svcAuthEventLink) {
    getSession().saveOrUpdate(svcAuthEventLink);
  }

  public int insertSvcAuthEventLink(int idEvent, int idSvcAuth) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO SVC_AUTH_EVENT_LINK (ID_SVC_AUTH_EVENT, "
                                                                 + "                                 ID_SVC_AUTH ) "
                                                                 + "                         VALUES (:idEvent, "
                                                                 + "                                 :idSvcAuth) ");
    query.setInteger("idEvent", idEvent);
    query.setInteger("idSvcAuth", idSvcAuth);
    return query.executeUpdate();
  }
}
