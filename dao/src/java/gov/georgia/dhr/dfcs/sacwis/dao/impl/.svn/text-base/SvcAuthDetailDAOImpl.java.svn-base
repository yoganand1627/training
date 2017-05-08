package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------

 09/29/2008   mxpatel          STGAP00009005: changed the method findSvcAuthDetailByIdPerson to 
                               return an object instead of an object array, which resolved the problem
                               with the ClassCastException.
 06/15/2009  arege             STGAP00012399: Added new method updateSvcAuthDetailWithIdForward to 
                               update svcAuthDetail table with idForward during person merge.
 01/07/2010  arege             STGAP00015696: Added findActiveServAuthByIdSpcNeedsDetAndCdSvcAuthDtlSvc()
 01/08/2010  mxpatel           STGAP00015702: Added methods for MR-52 - findServiceAuthsforSpcNeedsDeter, findAmountReqByIdSvcAuth, findIdSvcAuthDtlByIdSvcAuth, 
                               findIdSvcAuthDtlByIdEventSvcAuth, findIdSpcNeedsDetByIdSvcAuthDtl
 01/19/2010  mxpatel           SMS #43772: Added findSvcAuthDtlByIdPerson method to find service auths  with same type and same amount as the current Agreement
 01/27/2010  mxpatel           SMS #44087: Modified the findIdSvcAuthDtlByIdEventSvcAuth method to exclude the current svcAuthDtl and include svcAuthDtls types
 02/10/2010  mxpatel           SMS #44084: added method findSvcAuthDtlByIdPersonForSvcAuthDtl. Modified the existing methods to return only active ado_sub.
 02/11/2010  wjcochran         SMS #37406: Added new method findSvcAuthDtlByIdPersonIdSvcAuthDtl
 02/11/2010  mxpatel           SMS #45427: Removed the condition for begin date from getTotalSvcAuthDetailAmountReq
 02/25/2010  mxpatel           SMS #45293: added method findAllServAuthTermByIdSpcNeedsDet
 02/15/2010  mxpatel           SMS #44084: modified findSvcAuthDtlByIdPersonForSvcAuthDtl method to exclude end date and term date.      
 03/02/2010  mxpatel           SMS #45293: modified the code so that all service auths will copied from ADO to PAD (including end dated and terminated).  Also
                               added code to make sure approved amount for Non Recurring services on the Adoption Assistance 
                               Application is strictly adhered to by looking to previously approved and paid Assistance Agreements
 03/02/2010  mxpatel           SMS #44084: Modified the method to exclude end date and term date validations.                               
 02/02/2012  schoi             STGAP00017831: MR-102 Added new method findDistinctPersonByIdSvcAuth
 02/03/2012  schoi             STGAP00017831: MR-102 Added new method findEarliestBeiginDateOfSvcAuthDetailByPersonByIdSvcAuth 
                             
*/

public class SvcAuthDetailDAOImpl extends BaseDAOImpl implements SvcAuthDetailDAO {

  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> findServiceAuthDetailPersonByIdSvcAuth(int idSvcAuth) {
    Query query = getSession()
                              .createQuery(
                                           "      from SvcAuthDetail s " + "join fetch s.person "
                                                           + "     where s.serviceAuthorization.idSvcAuth = :idSvcAuth");

    query.setInteger("idSvcAuth", idSvcAuth);
    return (List<SvcAuthDetail>) query.list();
  }

  // STGAP00017831: MR-102
  // This selects distinct personID from SvcAuthDetail(s) under the idSvcAuth
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findDistinctPersonByIdSvcAuth(int idSvcAuth) {

    Query query = getSession().createQuery(" select distinct p.idPerson " + " from "
                                                           + " SvcAuthDetail s, Person p "
                                                           + " where s.serviceAuthorization.idSvcAuth = :idSvcAuth "
                                                           + " and p.idPerson = s.person.idPerson");
    query.setInteger("idSvcAuth", idSvcAuth);
    return (List<Integer>) query.list();
  }
  
  // STGAP00017831: MR-102
  // This selects the earliest Begin Date of Service Authorization Detail by personID and idSvcAuth
  @SuppressWarnings({ "unchecked" })
  public Date findEarliestBeiginDateOfSvcAuthDetailByPersonByIdSvcAuth(int idPerson, int idSvcAuth) {

    Query query = getSession().createQuery(" select s.dtSvcAuthDtlBegin " + " from "
                                                           + " SvcAuthDetail s "
                                                           + " where s.serviceAuthorization.idSvcAuth = :idSvcAuth "
                                                           + " and s.person.idPerson = :idPerson "
                                                           + " order by s.dtSvcAuthDtlBegin asc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idSvcAuth", idSvcAuth);
    return (Date) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<String> findDistinctSvcCodes(int idSvcAuth) {
    Query query = getSession().createQuery(
                                           " select distinct s.cdSvcAuthDtlSvc from SvcAuthDetail s"
                                                           + " where s.serviceAuthorization.idSvcAuth = :idSvcAuth");
    query.setInteger("idSvcAuth", idSvcAuth);
    return (List<String>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> findSvcAuthDetailByIdSvcAuthBySvcCode(int idSvcAuth, String cdSvcAuthDtlSvc) {
    Query query = getSession()
                              .createQuery(
                                           "      from SvcAuthDetail s "
                                                           + "join fetch s.serviceAuthorization "
                                                           + "     where s.serviceAuthorization.idSvcAuth = :idSvcAuth "
                                                           + "       and s.cdSvcAuthDtlSvc= :cdSvcAuthDtlSvc ");

    query.setInteger("idSvcAuth", idSvcAuth);
    query.setString("cdSvcAuthDtlSvc", cdSvcAuthDtlSvc);
    return (List<SvcAuthDetail>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> getLinkedOpenSvcAuthDetailByIdSvcAuth(int idSvcAuth, Date todayDate) {
    Query query = getSession().createQuery(
                                           " from SvcAuthDetail sad "
                                                           + " where sad.serviceAuthorization.idSvcAuth = :idSvcAuth "
                                                           + " and sad.specialNeedsDetermination is not null ");
    query.setInteger("idSvcAuth", idSvcAuth);
    return (List<SvcAuthDetail>) query.list();
  }

  public SvcAuthDetail findSvcAuthDetail(int idSvcAuthDtl) {
    Query query = getSession().createQuery(" from SvcAuthDetail s" + " where s.idSvcAuthDtl = :idSvcAuthDtl");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (SvcAuthDetail) firstResult(query);
  }
  //STGAP00006330: CR - 14
  public Integer findIdSvcAuth(int idSvcAuthDtl) {
    Query query = getSession().createQuery(" select sd.serviceAuthorization.idSvcAuth "
                                           + " from SvcAuthDetail sd " 
                                           + " where sd.idSvcAuthDtl = :idSvcAuthDtl");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (Integer)query.uniqueResult();
  }

  public SvcAuthDetail findSvcAuthDetailByIdPerson(int idSvcAuthDtl, int idResource, String cdSvcAuthDtlSvc,
                                                   int idPerson, Date dtDtSvcAuthDtlTerm, Date dtDtSvcAuthDtlBegin) {
    Query query = getSession()
                              .createQuery(
                                           "select sd " //mxpate added this out for defect #9005
                                         //  " select sd.serviceAuthorization.idSvcAuth, " //mxpate commented this out for defect #9005
                                         //                + "        sd.serviceAuthorization.indSvcAuthComplete " //mxpate commented this out for defect #9005
                                                           + "   from Stage st, Event ev, SvcAuthEventLink se, "
                                                           + "        SvcAuthDetail sd, "
                                                           + "        ServiceAuthorization sa "
                                                           + "  where sd.idSvcAuthDtl <> :idSvcAuthDtl "
                                                           + "    and sa.idSvcAuth = sd.serviceAuthorization.idSvcAuth "
                                                           + "    and se.serviceAuthorization.idSvcAuth = sd.serviceAuthorization.idSvcAuth "
                                                           + "    and ev.stage.idStage = se.idSvcAuthEvent "
                                                           + "    and st.idStage = ev.stage.idStage "
                                                           + "    and sa.capsResource.idResource = :idResource "
                                                           + "    and sd.cdSvcAuthDtlSvc = :cdSvcAuthDtlSvc "
                                                           + "    and sd.person.idPerson = :idPerson "
                                                           + "    and sd.dtSvcAuthDtlBegin <= :dtSvcAuthDtlTerm "
                                                           + "    and sd.dtSvcAuthDtlTerm >= :dtSvcAuthDtlBegin "
                                                           + "    and ((ev.cdEventStatus <> 'PROC' "
                                                          + "          and  st.dtStageClose is NOT NULL) "
                                                           + "         or  st.dtStageClose is NULL)  ");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setInteger("idResource", idResource);
    query.setString("cdSvcAuthDtlSvc", cdSvcAuthDtlSvc);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSvcAuthDtlTerm", dtDtSvcAuthDtlTerm);
    query.setTimestamp("dtSvcAuthDtlBegin", dtDtSvcAuthDtlBegin);
    return (SvcAuthDetail) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findSvcAuthDetailByIdPersonSQL(int idSvcAuthDtl, int idResource, String cdSvcAuthDtlSvc,
                                                       int idPerson, Date dtDtSvcAuthDtlTerm, Date dtDtSvcAuthDtlBegin) {
    Query query = getSession()
                              .createSQLQuery(
                                              " SELECT "
                                                              + " SD.ID_SVC_AUTH, "
                                                              + " SA.IND_SVC_AUTH_COMPLETE "
                                                              + " FROM "
                                                              + " STAGE ST, "
                                                              + " EVENT EV, "
                                                              + " SVC_AUTH_EVENT_LINK SE, "
                                                              + " SERVICE_AUTHORIZATION SA, "
                                                              + " SVC_AUTH_DETAIL SD "
                                                              + " WHERE "
                                                              + " ID_SVC_AUTH_DTL                 <> :idSvcAuthDtl "
                                                              + " AND SA.ID_SVC_AUTH                  = SD.ID_SVC_AUTH "
                                                              + " AND SE.ID_SVC_AUTH              = SA.ID_SVC_AUTH "
                                                              + " AND EV.ID_EVENT                 = SE.ID_SVC_AUTH_EVENT "
                                                              + " AND ST.ID_STAGE                 = EV.ID_EVENT_STAGE "
                                                              + " AND SA.ID_RESOURCE              = :idResource "
                                                              + " AND SD.CD_SVC_AUTH_DTL_SVC      = :cdSvcAuthDtlSvc "
                                                              + " AND SD.ID_PERSON                = :idPerson "
                                                              + " AND SD.DT_SVC_AUTH_DTL_BEGIN    <= :dtSvcAuthDtlTerm "
                                                              + " AND SD.DT_SVC_AUTH_DTL_TERM     >= :dtSvcAuthDtlBegin "
                                                              + " AND ((EV.CD_EVENT_STATUS        <> 'PROC' "
                                                              + "        AND ST.DT_STAGE_CLOSE   is not NULL) "
                                                              + "     OR  ST.DT_STAGE_CLOSE       is NULL) ");

    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setInteger("idResource", idResource);
    query.setString("cdSvcAuthDtlSvc", cdSvcAuthDtlSvc);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSvcAuthDtlTerm", dtDtSvcAuthDtlTerm);
    query.setTimestamp("dtSvcAuthDtlBegin", dtDtSvcAuthDtlBegin);
    return (List<Object[]>) query.list();
  }

  public SvcAuthDetail findSvcAuthDetailFromSvcAuthDtlSvcAuthPersonByIdPerson(int moSvcDtlSvcMonth, int yrSvcDtlServiceYear, int idContract,
                                                                              String cdSvcDtlCounty, String cdSvcDtlService, int idPerson,
                                                                              Collection<Integer> idSvcAuthDtlList) {
    Query query = getSession().createQuery("  from SvcAuthDetail b"
                                                           + "  join fetch b.serviceAuthorization a "
                                                           + "  where b.dtSvcAuthDtlBegin = (select max(b2.dtSvcAuthDtlBegin) "
                                                           + "                                from SvcAuthDetail b2, "
                                                           + "                                     ServiceAuthorization a2 "
                                                           + "                               where trunc(b2.dtSvcAuthDtlBegin) <= "
                                                           + "                                     trunc(last_day(to_date(:moSvcDtlSvcMonth||'/'||:yrSvcDtlServiceYear,'mm/yyyy'))) "
                                                           + "                                 and trunc(b2.dtSvcAuthDtlTerm) >=  trunc(to_date(:moSvcDtlSvcMonth||'/01/'||:yrSvcDtlServiceYear,'mm/dd/yyyy')) "
                                                           + "                                 and a2.contract.idContract = :idContract "
                                                           + "                                 and a2.cdSvcAuthCounty  = :cdSvcDtlCounty "
                                                           + "                                 and b2.serviceAuthorization.idSvcAuth = a2.idSvcAuth "
                                                           + "                                 and b2.cdSvcAuthDtlSvc = :cdSvcDtlService "
                                                           + "                                 and b2.person.idPerson = :idPerson "
                                                           + "                                 and b.person.idPerson = b2.person.idPerson "
                                                           + "                                 and b2.idSvcAuthDtl not in ( :idSvcAuthDtlList ) ) "
                                                           + "   and a.contract.idContract = :idContract "
                                                           + "   and a.cdSvcAuthCounty = :cdSvcDtlCounty "
                                                           + "   and b.serviceAuthorization.idSvcAuth = a.idSvcAuth "
                                                           + "   and b.person.idPerson = :idPerson "
                                                           + "   and b.cdSvcAuthDtlSvc = :cdSvcDtlService");
    query.setInteger("moSvcDtlSvcMonth", moSvcDtlSvcMonth);
    query.setInteger("yrSvcDtlServiceYear", yrSvcDtlServiceYear);
    query.setInteger("idContract", idContract);
    query.setString("cdSvcDtlCounty", cdSvcDtlCounty);
    query.setString("cdSvcDtlService", cdSvcDtlService);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("idSvcAuthDtlList", idSvcAuthDtlList, Hibernate.INTEGER);
    return (SvcAuthDetail) firstResult(query);
  }

  public Date findDtEaEligibilityInitiated(int idStage) {
    SQLQuery query = getSession().createSQLQuery(
                                                 " SELECT SAD.DT_SVC_AUTH_DTL_BEGIN " + "   FROM SVC_AUTH_DETAIL SAD, "
                                                                 + "        EVENT E, "
                                                                 + "        SVC_AUTH_EVENT_LINK SAE "
                                                                 + "  WHERE SAD.ID_SVC_AUTH = SAE.ID_SVC_AUTH "
                                                                 + "    AND SAE.ID_SVC_AUTH_EVENT = E.ID_EVENT "
                                                                 + "    AND E.ID_EVENT_STAGE = :idStage "
                                                                 + "    AND E.CD_EVENT_STATUS = 'APRV'" + "  UNION "
                                                                 + " SELECT S.DT_STAGE_CLOSE " + "   FROM STAGE S "
                                                                 + "  WHERE S.ID_STAGE = :idStage " + "  UNION "
                                                                 + " SELECT CR.DT_REMOVAL "
                                                                 + "   FROM CNSRVTRSHP_REMOVAL CR, "
                                                                 + "        EVENT E "
                                                                 + "  WHERE CR.ID_REMOVAL_EVENT = E.ID_EVENT "
                                                                 + "    AND E.ID_EVENT_STAGE = :idStage " + "  UNION "
                                                                 + " SELECT sysdate " + "   FROM DUAL "
                                                                 + " ORDER BY 1 ");

    query.setInteger("idStage", idStage);
    return (Date) firstResult(query);
  }

  public Date findDtSvcAuthTerm(int idCase) {
    Query query = getSession().createQuery(
                                           "select a.dtSvcAuthDtlTerm " + "   from Event c, " + "        Stage d, "
                                                           + "        SvcAuthEventLink b, "
                                                           + "        SvcAuthDetail a "
                                                           + "  where d.capsCase.idCase = :idCase "
                                                           + "    and d.idStage = c.stage "
                                                           + "    and c.idEvent = b.idSvcAuthEvent "
                                                           + "    and b.serviceAuthorization = a.serviceAuthorization "
                                                           + "    and trunc(a.dtSvcAuthDtlTerm) > trunc(sysdate)");

    query.setInteger("idCase", idCase);
    return (Date) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findSvcAuthDetailByIdPerson(int idPerson, int pageNbr, int pageSize) {
    Query query = getSession()
                              .createQuery(
                                           "select new map (a.idSvcAuthDtl as idSvcAuthDtl, "
                                                           + "                a.serviceAuthorization.idSvcAuth as idSvcAuth, "
                                                           + "                a.person.idPerson as idPerson, "
                                                           + "                a.cdSvcAuthDtlAuthType as cdSvcAuthDtlAuthType, "
                                                           + "                a.cdSvcAuthDtlPeriod as cdSvcAuthDtlPeriod, "
                                                           + "                a.cdSvcAuthDtlSvc as cdSvcAuthDtlSvc, "
                                                           + "                a.dtSvcAuthDtl as dtSvcAuthDtl, "
                                                           + "                a.dtSvcAuthDtlBegin as dtSvcAuthDtlBegin, "
                                                           + "                a.dtSvcAuthDtlEnd as dtSvcAuthDtlEnd, "
                                                           + "                a.dtSvcAuthDtlTerm as dtSvcAuthDtlTerm, "
                                                           + "                b.capsResource.idResource as idResource, "
                                                           + "                b.cdSvcAuthCounty as cdSvcAuthCounty) "
                                                           + "  from SvcAuthDetail a "
                                                           + "  join a.serviceAuthorization b "
                                                           + " where a.person.idPerson = :idPerson");

    query.setInteger("idPerson", idPerson);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
  public int updateSvcAuthDetailAddUsedValues(int idSvcAuthDtl, double addUnitUsed, double addAmtUsed) {
    Query query = getSession().createQuery("update SvcAuthDetail sad " +
                                           "set sad.nbrSvcAuthDtlUnitUsed = nvl(sad.nbrSvcAuthDtlUnitUsed, 0) + :addUnitUsed, " +
                                           "sad.amtSvcAuthDtlAmtUsed = nvl(sad.amtSvcAuthDtlAmtUsed, 0) + :addAmtUsed " +
                                           "where sad.idSvcAuthDtl = :idSvcAuthDtl");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setDouble("addUnitUsed", addUnitUsed);
    query.setDouble("addAmtUsed", addAmtUsed);
    return query.executeUpdate();
  }
  
  //Added for STGAP00012399
  public int updateSvcAuthDetailWithIdForward(int idPersonForward, int idPersonClosed){
    Query query = getSession().createQuery("update SvcAuthDetail sad " +
                                           "set sad.person.idPerson = :idPersonForward " +
                                           "where sad.person.idPerson = :idPersonClosed");
    query.setInteger("idPersonForward", idPersonForward);
    query.setDouble("idPersonClosed", idPersonClosed);
    return query.executeUpdate();
  }

  public int saveSvcAuthDetail(SvcAuthDetail svcAuthDetail) {
    getSession().saveOrUpdate(svcAuthDetail);
    return svcAuthDetail.getIdSvcAuthDtl();
  }

  public void deleteSvcAuthDetail(SvcAuthDetail svcAuthDetail) {
    getSession().delete(svcAuthDetail);
  }
  
  public Date findDtServiceAuthDetailTermByIdSvcAuthDtl(int idSvcAuthDtl) {
    Query query = getSession().createQuery(" select sad.dtSvcAuthDtlTerm from SvcAuthDetail sad " + "where sad.idSvcAuthDtl = :idSvcAuthDtl");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (Date) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> getOpenSvcAuthDetailByIdStageByIdPersonByCdSvcAuthDtlSvc( int idStage, int idPerson,
                                                                                       Date todayDate,
                                                                                       String cdSvcAuthDtlSvcFamily ){
    Query query = getSession().createQuery(" select sad " 
                                         + " from Event e, SvcAuthEventLink sael, SvcAuthDetail sad " 
                                         + " where e.stage.idStage = :idStage " 
                                         + " and e.idEvent = sael.idSvcAuthEvent " 
                                         + " and sael.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth " 
                                         + " and ( sad.dtSvcAuthDtlEnd > :todayDate " 
                                         + "       or sad.dtSvcAuthDtlEnd > :todayDate ) " 
                                         + " and sad.dtSvcAuthDtlTerm > :todayDate " 
                                         + " and sad.person.idPerson = :idPerson " 
                                         + " and sad.cdSvcAuthDtlSvc like :cdSvcAuthDtlSvcFamily");
    
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("todayDate", todayDate);
    query.setString("cdSvcAuthDtlSvcFamily", cdSvcAuthDtlSvcFamily);
    return (List<SvcAuthDetail>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> getOpenSvcAuthDetailByIdStageByCdSvcAuthDtlSvc( int idStage, Date todayDate,
                                                                                       String cdSvcAuthDtlSvcFamily ){
    Query query = getSession().createQuery(" select sad " 
                                         + " from Event e, SvcAuthEventLink sel, SvcAuthDetail sad " 
                                         + " where e.stage.idStage = :idStage " 
                                         + " and e.idEvent = sel.idSvcAuthEvent " 
                                         + " and sel.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth " 
                                         + " and ( sad.dtSvcAuthDtlEnd > :todayDate " 
                                         + "       or sad.dtSvcAuthDtlEnd > :todayDate) "
                                         + " and sad.dtSvcAuthDtlTerm > :todayDate  " 
                                         + " and sad.cdSvcAuthDtlSvc like :cdSvcAuthDtlSvcFamily");
    
    query.setInteger("idStage", idStage);
    query.setTimestamp("todayDate", todayDate);
    query.setString("cdSvcAuthDtlSvcFamily", cdSvcAuthDtlSvcFamily);
    return (List<SvcAuthDetail>) query.list();
  }
  
  //STGAP00015696: Find all Active ServiceAuthDetail associated with the given adoasstapplication and service code   
  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> findActiveServAuthByIdSpcNeedsDetAndCdSvcAuthDtlSvc(int idAdopAsstAppl, Collection<String> cdSvcDtlService ,
                                                                           Date dtToday) {
    Query query = getSession()
                              .createQuery(
                                           "   from SvcAuthDetail sad "
                                                           + "   where  sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + "   and sad.cdSvcAuthDtlSvc in ( :cdSvcDtlService ) "
                                                           + "   and sad.dtSvcAuthDtlTerm > :dtToday  "
                                                           + "   and sad.dtSvcAuthDtlEnd > :dtToday "
                                                           + "   and sad.dtSvcAuthDtlBegin <= :dtToday ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setParameterList("cdSvcDtlService", cdSvcDtlService);
    query.setTimestamp("dtToday", dtToday);
    return (List<SvcAuthDetail>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> findAllServAuthByIdSpcNeedsDet(int idAdopAsstAppl) {
    Query query = getSession()
                              .createQuery(
                                           "   from SvcAuthDetail sad "
                                                           + "   where  sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + " order by sad.cdSvcAuthDtlAuthType Desc, sad.dtSvcAuthDtlTerm desc ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    return (List<SvcAuthDetail>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> findAllServAuthTermByIdSpcNeedsDet(int idAdopAsstAppl) {
    String svcAuthDtlAuthType = CodesTables.CSVATYPE_TRM;
    Query query = getSession()
                              .createQuery(
                                           "   from SvcAuthDetail sad "
                                                           + "   where  sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + " and sad.cdSvcAuthDtlAuthType = :svcAuthDtlAuthType"
                                                           + " order by sad.cdSvcAuthDtlAuthType Desc, sad.dtSvcAuthDtlTerm desc ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setString("svcAuthDtlAuthType", svcAuthDtlAuthType);
    return (List<SvcAuthDetail>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public Double getTotalSvcAuthDetailAmountReq(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList,
                                               Date dtToday, int idSvcAuthDtl) {
    Query query = getSession()
                              .createQuery(
                                           "select sum(sad.amtSvcAuthDtlAmtReq) from SvcAuthDetail sad , SvcAuthEventLink sael, Event e"
                                                           + " where sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + "   and e.idEvent = sael.idSvcAuthEvent "
                                                           + "   and sael.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth"
                                                           + "   and sad.cdSvcAuthDtlSvc in ( :cdSvcDtlService ) "
                                                           + "   and sad.dtSvcAuthDtlTerm > :dtToday  "
                                                           + "   and sad.dtSvcAuthDtlEnd > :dtToday "
                                                           + "   and sad.idSvcAuthDtl <> :idSvcAuthDtl ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setParameterList("cdSvcDtlService", cdSvcDtlServiceList);
    query.setTimestamp("dtToday", dtToday);
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (Double) firstResult(query);

  }
  
  @SuppressWarnings( { "unchecked" })
  public Double getTotalSvcAuthDetailAmountUsed(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList,
                                                Date dtToday, int idSvcAuthDtl) {
    Query query = getSession()
                              .createQuery(
                                           "select sum(sad.amtSvcAuthDtlAmtUsed) from SvcAuthDetail sad , SvcAuthEventLink sael, Event e"
                                                           + " where sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + "   and e.idEvent = sael.idSvcAuthEvent "
                                                           + "   and sael.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth"
                                                           + "   and sad.cdSvcAuthDtlSvc in ( :cdSvcDtlService ) "
                                                           + "   and (sad.dtSvcAuthDtlTerm <= :dtToday  "
                                                           + "   or sad.dtSvcAuthDtlEnd <= :dtToday )"
                                                           + "   and sad.idSvcAuthDtl <> :idSvcAuthDtl ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setParameterList("cdSvcDtlService", cdSvcDtlServiceList);
    query.setTimestamp("dtToday", dtToday);
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (Double) firstResult(query);

  }
  
  @SuppressWarnings( { "unchecked" })
  public Double getTotalSvcAuthDetailAmountReqFor510(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList,
                                                     Date dtToday, int idSvcAuthDtl, String cdEventType) {
    Query query = getSession()
                              .createQuery(
                                           "select sum(sad.amtSvcAuthDtlAmtReq) from SvcAuthDetail sad , SvcAuthEventLink sael, Event e"
                                                           + " where sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + "   and e.idEvent = sael.idSvcAuthEvent "
                                                           + "   and sael.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth"
                                                           + "   and sad.cdSvcAuthDtlSvc in ( :cdSvcDtlService ) "
                                                           + "   and sad.dtSvcAuthDtlTerm > :dtToday  "
                                                           + "   and sad.dtSvcAuthDtlEnd > :dtToday "
                                                           + "   and e.cdEventType = :cdEventType "
                                                           + "   and sad.idSvcAuthDtl <> :idSvcAuthDtl ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setParameterList("cdSvcDtlService", cdSvcDtlServiceList);
    query.setTimestamp("dtToday", dtToday);
    query.setString("cdEventType", cdEventType);
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (Double) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public Double getTotalSvcAuthDetailAmountReqFor510ForAgreement(int idAdopAsstAppl,
                                                                 Collection<String> cdSvcDtlServiceList, Date dtToday,
                                                                 String cdEventType) {
    Query query = getSession()
                              .createQuery(
                                           "select sum(sad.amtSvcAuthDtlAmtReq) from SvcAuthDetail sad , SvcAuthEventLink sael, Event e"
                                                           + " where sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + "   and e.idEvent = sael.idSvcAuthEvent "
                                                           + "   and sael.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth"
                                                           + "   and sad.cdSvcAuthDtlSvc in ( :cdSvcDtlService ) "
                                                           + "   and sad.dtSvcAuthDtlTerm > :dtToday  "
                                                           + "   and sad.dtSvcAuthDtlEnd > :dtToday "
                                                           + "   and e.cdEventType = :cdEventType ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setParameterList("cdSvcDtlService", cdSvcDtlServiceList);
    query.setTimestamp("dtToday", dtToday);
    query.setString("cdEventType", cdEventType);
    return (Double) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public Double getTotalSvcAuthDetailAmountReqFor510Term(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList,
                                                         Date dtToday, int idSvcAuthDtl, String cdEventType) {
    Query query = getSession()
                              .createQuery(
                                           "select sum(sad.amtSvcAuthDtlAmtUsed) from SvcAuthDetail sad , SvcAuthEventLink sael, Event e"
                                                           + " where sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + "   and e.idEvent = sael.idSvcAuthEvent "
                                                           + "   and sael.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth"
                                                           + "   and sad.cdSvcAuthDtlSvc in ( :cdSvcDtlService ) "
                                                           + "   and (sad.dtSvcAuthDtlTerm <= :dtToday  "
                                                           + "   or sad.dtSvcAuthDtlEnd <= :dtToday) "
                                                           + "   and e.cdEventType = :cdEventType "
                                                           + "   and sad.idSvcAuthDtl <> :idSvcAuthDtl ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setParameterList("cdSvcDtlService", cdSvcDtlServiceList);
    query.setTimestamp("dtToday", dtToday);
    query.setString("cdEventType", cdEventType);
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (Double) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public Double getTotalSvcAuthDetailAmountReqFor510TermForAgreement(int idAdopAsstAppl,
                                                                     Collection<String> cdSvcDtlServiceList,
                                                                     Date dtToday, String cdEventType) {
    Query query = getSession()
                              .createQuery(
                                           "select sum(sad.amtSvcAuthDtlAmtUsed) from SvcAuthDetail sad , SvcAuthEventLink sael, Event e"
                                                           + " where sad.specialNeedsDetermination.idEvent = :idAdopAsstAppl "
                                                           + "   and e.idEvent = sael.idSvcAuthEvent "
                                                           + "   and sael.serviceAuthorization.idSvcAuth = sad.serviceAuthorization.idSvcAuth"
                                                           + "   and sad.cdSvcAuthDtlSvc in ( :cdSvcDtlService ) "
                                                           + "   and (sad.dtSvcAuthDtlTerm <= :dtToday  "
                                                           + "   or sad.dtSvcAuthDtlEnd <= :dtToday) "
                                                           + "   and e.cdEventType = :cdEventType ");
    query.setInteger("idAdopAsstAppl", idAdopAsstAppl);
    query.setParameterList("cdSvcDtlService", cdSvcDtlServiceList);
    query.setTimestamp("dtToday", dtToday);
    query.setString("cdEventType", cdEventType);
    return (Double) firstResult(query);
  }
  
  public Integer findIdSpcNeedsDetByIdSvcAuthDtl(int idSvcAuthDtl){
    Query query = getSession().createQuery(" select sad.specialNeedsDetermination.event.idEvent "
                                           + " from SvcAuthDetail sad "
                                           + " where sad.idSvcAuthDtl = :idSvcAuthDtl");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
   return (Integer) query.uniqueResult(); 
  }

  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> findSvcAuthDtlByIdPerson(int idPerson, String cdEventType, int idStage, Collection<String> cdSvcAuthDtlSvc, double amtSvcAuthDtlAmtReq){
    String cdSvcAuthDtlAuthType = CodesTables.CSVATYPE_TRM;
    Query query = getSession().createQuery(" select sad "
                                           + " from SvcAuthDetail sad, Event e, SvcAuthEventLink sel "
                                           + " where  sad.serviceAuthorization.idSvcAuth = sel.serviceAuthorization.idSvcAuth "
                                           + " and e.idEvent = sel.idSvcAuthEvent "
                                           + " and e.cdEventType = :cdEventType "
                                           + " and e.stage.idStage = :idStage  "
                                           + " and sad.cdSvcAuthDtlSvc in (:cdSvcAuthDtlSvc) "
                                           + " and sad.cdSvcAuthDtlAuthType <> :cdSvcAuthDtlAuthType "
                                           + " and sad.person.idPerson = :idPerson " 
                                           + " and sad.amtSvcAuthDtlAmtReq = :amtSvcAuthDtlAmtReq" );
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdSvcAuthDtlAuthType", cdSvcAuthDtlAuthType);
    query.setParameterList("cdSvcAuthDtlSvc", cdSvcAuthDtlSvc);
    query.setDouble("amtSvcAuthDtlAmtReq", amtSvcAuthDtlAmtReq);
    return (List<SvcAuthDetail>) query.list();
  }
  
  public SvcAuthDetail findSvcAuthDtlByIdPersonIdSvcAuthDtl(int idSvcAuthDtl, int idResource, String cdSvcAuthDtlSvc,
                                                   int idPerson, Date dtDtSvcAuthDtlTerm, Date dtDtSvcAuthDtlBegin) {
    Query query = getSession().createQuery("select sd " 
                                         + "   from Stage st, Event ev, SvcAuthEventLink se, "
                                         + "        SvcAuthDetail sd, "
                                         + "        ServiceAuthorization sa "
                                         + "  where sd.idSvcAuthDtl = :idSvcAuthDtl "
                                         + "    and sa.idSvcAuth    = sd.serviceAuthorization.idSvcAuth "
                                         + "    and se.serviceAuthorization.idSvcAuth = sd.serviceAuthorization.idSvcAuth "
                                         + "    and ev.stage.idStage = se.idSvcAuthEvent "
                                         + "    and st.idStage = ev.stage.idStage "
                                         + "    and sa.capsResource.idResource = :idResource "
                                         + "    and sd.cdSvcAuthDtlSvc = :cdSvcAuthDtlSvc "
                                         + "    and sd.person.idPerson = :idPerson "
                                         + "    and sd.dtSvcAuthDtlBegin <= :dtSvcAuthDtlTerm "
                                         + "    and sd.dtSvcAuthDtlTerm >= :dtSvcAuthDtlBegin "
                                         + "    and ((ev.cdEventStatus <> 'PROC' "
                                         + "          and  st.dtStageClose is NOT NULL) "
                                         + "         or  st.dtStageClose is NULL)  ");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setInteger("idResource", idResource);
    query.setString("cdSvcAuthDtlSvc", cdSvcAuthDtlSvc);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSvcAuthDtlTerm", dtDtSvcAuthDtlTerm);
    query.setTimestamp("dtSvcAuthDtlBegin", dtDtSvcAuthDtlBegin);
    return (SvcAuthDetail) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<SvcAuthDetail> findSvcAuthDtlByIdPersonForSvcAuthDtl(int idPerson, int idSvcAuthDtl, String cdEventType, int idStage, Collection<String> cdSvcAuthDtlSvc, double amtSvcAuthDtlAmtReq){
    String cdSvcAuthDtlAuthType = CodesTables.CSVATYPE_TRM;
    Query query = getSession().createQuery(" select sad "
                                           + " from SvcAuthDetail sad, Event e, SvcAuthEventLink sel "
                                           + " where  sad.serviceAuthorization.idSvcAuth = sel.serviceAuthorization.idSvcAuth "
                                           + " and e.idEvent = sel.idSvcAuthEvent "
                                           + " and e.cdEventType = :cdEventType "
                                           + " and e.stage.idStage = :idStage  "
                                           + " and sad.cdSvcAuthDtlSvc in (:cdSvcAuthDtlSvc) "
                                           + " and sad.cdSvcAuthDtlAuthType <> :cdSvcAuthDtlAuthType "
                                           + " and sad.person.idPerson = :idPerson " 
                                           + " and sad.idSvcAuthDtl <> :idSvcAuthDtl "
                                           + " and sad.amtSvcAuthDtlAmtReq = :amtSvcAuthDtlAmtReq" );
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setInteger("idStage", idStage);
    query.setString("cdSvcAuthDtlAuthType", cdSvcAuthDtlAuthType);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdSvcAuthDtlSvc", cdSvcAuthDtlSvc);
    query.setDouble("amtSvcAuthDtlAmtReq", amtSvcAuthDtlAmtReq);
    return (List<SvcAuthDetail>) query.list();
  }

}
