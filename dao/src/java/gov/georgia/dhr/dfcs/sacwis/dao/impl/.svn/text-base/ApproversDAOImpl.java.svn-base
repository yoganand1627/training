package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ApprovalEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  Added method deleteApproversByIdStageCdTask, deleteApprovers, findApproverByIdEventForFSUSUBFPR
 * </pre>
 */

public class ApproversDAOImpl extends BaseDAOImpl implements ApproversDAO {
  @SuppressWarnings({"unchecked"})
  public List<Approvers> findApproversByIdEventReverseChronology(int idEvent){
    Query query = getSession().createQuery("from Approvers a "
                                           + "where a.approval.idApproval in (select ael.approval.idApproval "
                                           + "from ApprovalEventLink ael "
                                           + "where ael.event.idEvent=:idEvent) "
                                           + "order by a.idApprovers desc");
    query.setInteger("idEvent", idEvent);
    return (List<Approvers>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public Approvers findApproverByIdEventIfEventIsApproved(int idEvent, String cdEventStatus){
    Query query = getSession().createQuery("from Approvers a "
                                           + "where a.approval.idApproval in (select ael.approval.idApproval "
                                           + "from ApprovalEventLink ael "
                                           + "where ael.event.idEvent=:idEvent " 
                                           + "and ael.event.cdEventStatus = :cdEventStatus) "
                                           + "order by a.idApprovers desc");
    query.setInteger("idEvent", idEvent);
    query.setString("cdEventStatus", cdEventStatus);
    return (Approvers) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Approvers> findApproversByIdApprovalReverseChronology(int idApproval){
    Query query = getSession().createQuery("from Approvers a "
                                           + "where a.approval.idApproval = :idApproval "
                                           + "order by a.idApprovers desc");
    query.setInteger("idApproval", idApproval);
    return (List<Approvers>) query.list();
  }
  
  //-- this method will actually only ever return one record
  @SuppressWarnings({"unchecked"})
  public List<Approvers> findApproversByIdTodoReverseChronology(int idTodo){
    Query query = getSession().createQuery("from Approvers a "
                                           + "where a.todo.idTodo = :idTodo "
                                           + "order by a.idApprovers desc");
    query.setInteger("idTodo", idTodo);
    return (List<Approvers>) query.list();
  }

  public Approvers findApproversByIdTodo(int idTodo) {
    Query query = getSession().createQuery("   from Approvers a " +
                                           "  where a.todo.idTodo = :idTodo ");
    query.setInteger("idTodo", idTodo);
    return (Approvers) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Approvers> findApproversByIdApproval(int idApproval) {
    Query query = getSession().createQuery("  from Approvers a left join fetch a.person " +
                                           " where a.approval.idApproval = :idApproval ");

    query.setInteger("idApproval", idApproval);

    return (List<Approvers>) query.list();
  }

  // STGAP00005880 - this method is meant to look for approvers record for a given idApporval, based off it name
  // and how it is called from various services. However, here it takes idApprovers as parameter and its query logic 
  // confirms it. This is incorrect. Keep the old code commented out as a reference as to why it is being changed since
  // this method is being called by many services. The updated version is right below this old method with the same
  // name
  /*@SuppressWarnings({"unchecked"})
  public List<Map> findAllApproversForGivenApproval(int idApprovers) {

    Query query = getSession().createQuery("select  new map(a.dtApproversDetermination as dtApproversDetermination, " +
                                           "        a.person.nmPersonFull as nmPersonFul, " +
                                           "        a.cdApproversStatus as cdApproversStatus, " +
                                           "        a.txtApproversCmnts as txtApproversCmnts, " +
                                           "        a.todo.idTodo as idTodo, " +
                                           "        a.person.idPerson as idPerson, " +
                                           "        a.idApprovers as idApprovers, " +
                                           "        a.dtLastUpdate as dtLstUpdate) " +
                                           "   from Approvers a " +
                                           "  where a.idApprovers = :idApprovers ");

    query.setInteger("idApprovers", idApprovers);
    return (List<Map>) query.list();
  }*/
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findAllApproversForGivenApproval(int idApproval) {

    Query query = getSession().createQuery("select  new map(a.dtApproversDetermination as dtApproversDetermination, " +
                                           "        a.person.nmPersonFull as nmPersonFul, " +
                                           "        a.cdApproversStatus as cdApproversStatus, " +
                                           "        a.txtApproversCmnts as txtApproversCmnts, " +
                                           "        a.todo.idTodo as idTodo, " +
                                           "        a.person.idPerson as idPerson, " +
                                           "        a.idApprovers as idApprovers, " +
                                           "        a.dtLastUpdate as dtLstUpdate) " +
                                           "   from Approvers a " +
                                           "  where a.approval.idApproval = :idApproval ");

    query.setInteger("idApproval", idApproval);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Object[]> findAllApproversByIntakeIdEvent(int idEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT N.NM_NAME_FIRST AS NM_NAME_FIRST, " +
                                                 "       N.NM_NAME_MIDDLE AS NM_NAME_MIDDLE, " +
                                                 "       N.NM_NAME_LAST AS NM_NAME_LAST, " +
                                                 "       N.CD_NAME_SUFFIX AS CD_NAME_SUFFIX, " +
                                                 "       EJH.CD_JOB_BJN AS CD_JOB_BJN, " +
                                                 "       M.ADDR_MAIL_CODE_CITY AS ADDR_MAIL_CODE_CITY, " +
                                                 "       PP.NBR_PERSON_PHONE AS NBR_PERSON_PHONE, " +
                                                 "       PP.NBR_PERSON_PHONE_EXTENSION AS NBR_PERSON_PHONE_EXTENSION, " +
                                                 "       EV.ID_EVENT_PERSON AS ID_EVENT_PERSON, " +
                                                 "       EV.CD_EVENT_STATUS AS CD_EVENT_STATUS, " +
                                                 "       EV.CD_EVENT_TYPE AS CD_EVENT_TYPE, " +
                                                 "       AP.DT_APPROVERS_DETERMINATION AS DT_APPROVERS_DETERMINATION " +
                                                 "  FROM PERSON_PHONE PP, " +
                                                 "       APPROVAL_EVENT_LINK AEL, " +
                                                 "       APPROVERS AP, " +
                                                 "       MAIL_CODE M, " +
                                                 "       OFFICE O, " +
                                                 "       EMP_JOB_HISTORY EJH, " +
                                                 "       EMPLOYEE EMP, " +
                                                 "       NAME N, " +
                                                 "       EVENT EV " +
                                                 " WHERE EV.ID_EVENT = :idEvent " +
                                                 "   AND EV.ID_EVENT = AEL.ID_EVENT (+) " +
                                                 "   AND AEL.ID_APPROVAL = AP.ID_APPROVAL " +
                                                 "   AND AP.CD_APPROVERS_STATUS = :cdAprv " +
                                                 "   AND AP.DT_LAST_UPDATE = (SELECT MAX(AP1.DT_LAST_UPDATE) " +
                                                 "                              FROM APPROVERS AP1 " +
                                                 "                             WHERE AP1.ID_APPROVAL = AEL.ID_APPROVAL) " +
                                                 "   AND AP.ID_PERSON = N.ID_PERSON (+) " +
                                                 "   AND N.IND_NAME_PRIMARY (+) = :indYes " +
                                                 "   AND NVL(N.DT_NAME_END_DATE, :dtMaxDate) = " +
                                                 "       (SELECT NVL(MAX(N2.DT_NAME_END_DATE), :dtMaxDate) " +
                                                 "          FROM NAME N2 " +
                                                 "         WHERE N2.ID_PERSON (+) = AP.ID_PERSON " +
                                                 "           AND N2.IND_NAME_PRIMARY (+) = :indYes) " +
                                                 "   AND AP.ID_PERSON = EMP.ID_PERSON (+) " +
                                                 "   AND EMP.ID_EMP_OFFICE = O.ID_OFFICE (+) " +
                                                 "   AND O.CD_OFFICE_MAIL = M.CD_MAIL_CODE (+) " +
                                                 "   AND AP.ID_PERSON = EJH.ID_PERSON (+) " +
                                                 "   AND NVL(EJH.DT_JOB_END, :dtMaxDate) = " +
                                                 "       (SELECT NVL(MAX(EJH2.DT_JOB_END), :dtMaxDate) " +
                                                 "          FROM EMP_JOB_HISTORY EJH2 " +
                                                 "         WHERE AP.ID_PERSON = EJH2.ID_PERSON (+) ) " +
                                                 "   AND AP.ID_PERSON = PP.ID_PERSON (+) " +
                                                 "   AND PP.CD_PERSON_PHONE_TYPE (+) = :cdBSType " +
                                                 "   AND PP.IND_PERSON_PHONE_PRIMARY (+) = :indYes " +
                                                 "   AND NVL(PP.DT_PERSON_PHONE_END, :dtMaxDate) = " +
                                                 "       (SELECT NVL(MAX(PP2.DT_PERSON_PHONE_END), :dtMaxDate) " +
                                                 "          FROM PERSON_PHONE PP2 " +
                                                 "         WHERE AP.ID_PERSON = PP2.ID_PERSON (+) " +
                                                 "           AND PP2.CD_PERSON_PHONE_TYPE (+) = :cdBSType " +
                                                 "           AND PP2.IND_PERSON_PHONE_PRIMARY (+) = :indYes)");
    query.setInteger("idEvent", idEvent);
    query.setString("cdAprv", CodesTables.CAPPDESG_APRV);
    query.setString("indYes", ArchitectureConstants.Y);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    query.setString("cdBSType", CodesTables.CPHNTYP_BS);
    query.addScalar("NM_NAME_FIRST", Hibernate.STRING);
    query.addScalar("NM_NAME_MIDDLE", Hibernate.STRING);
    query.addScalar("NM_NAME_LAST", Hibernate.STRING);
    query.addScalar("CD_NAME_SUFFIX", Hibernate.STRING);
    query.addScalar("CD_JOB_BJN", Hibernate.STRING);
    query.addScalar("ADDR_MAIL_CODE_CITY", Hibernate.STRING);
    query.addScalar("NBR_PERSON_PHONE", Hibernate.STRING);
    query.addScalar("NBR_PERSON_PHONE_EXTENSION", Hibernate.INTEGER);
    query.addScalar("ID_EVENT_PERSON", Hibernate.INTEGER);
    query.addScalar("CD_EVENT_STATUS", Hibernate.STRING);
    query.addScalar("CD_EVENT_TYPE", Hibernate.STRING);
    query.addScalar("DT_APPROVERS_DETERMINATION", Hibernate.TIMESTAMP);
    return (List<Object[]>) query.list();
  }

  public int updateApproversByIdApproversAndDtLastUpdate(int idPerson, String cdApproversStatus,
                                                         String txtApproversComments, int idApprovers, 
                                                         Date dtApproversDetermination, Date dtLastUpdate) {
    Query query = getSession().createQuery(" update Approvers " +
                                           "    set dtApproversDetermination = :dtApproversDetermination, " +
                                           "        person.idPerson = :idPerson, " +
                                           "        cdApproversStatus = :cdApproversStatus, " +
                                           "        txtApproversCmnts = :txtApproversComments " +
                                           "  where idApprovers = :idApprovers " +
                                           "  and dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdApproversStatus", cdApproversStatus);
    query.setString("txtApproversComments", txtApproversComments);
    query.setInteger("idApprovers", idApprovers);
    query.setTimestamp("dtApproversDetermination", dtApproversDetermination);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updateCdApproversStatusByIdApproval(int idApproval) {
    Query query = getSession().createQuery("update Approvers " +
                                           "    set cdApproversStatus = 'INVD'" +
                                           "  where cdApproversStatus = 'PEND'" +
                                           "    and approval.idApproval = :idApproval");

    query.setInteger("idApproval", idApproval);
    return query.executeUpdate();
  }
  
  public int updateIdTodoByIdApprovers(int idApprovers, int idTodo) {
    Query query = getSession().createQuery("update Approvers a "
                                           + "set a.todo.idTodo = :idTodo "
                                           + "where a.idApprovers = :idApprovers");
    query.setInteger("idTodo", idTodo);
    query.setInteger("idApprovers", idApprovers);
    return query.executeUpdate();
  }
  
  public int updateIdTodoByIdTodo(int oldIdTodo, int newIdTodo) {
    Query query = getSession().createQuery("update Approvers a "
                                           + "set a.todo.idTodo = :newIdTodo "
                                           + "where a.todo.idTodo = :oldIdTodo");
    query.setInteger("newIdTodo", newIdTodo);
    query.setInteger("oldIdTodo", oldIdTodo);
    return query.executeUpdate();
  }

  public int insertApprovers(String cdApproversStatus, Date dtApproversDetermination, Date dtApproversRequested,
                             int idApproval, int idPerson, int idTodo, String indApproversHistorical,
                             String cdTxtApproversComments) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO APPROVERS " +
                                                 "  (CD_APPROVERS_STATUS, " +
                                                 "   DT_APPROVERS_DETERMINATION, " +
                                                 "   DT_APPROVERS_REQUESTED, " +
                                                 "   ID_APPROVAL, " +
                                                 "   ID_APPROVERS, " +
                                                 "   ID_PERSON, " +
                                                 "   ID_TODO, " +
                                                 "   IND_APPROVERS_HISTORICAL, " +
                                                 "   TXT_APPROVERS_CMNTS) " +
                                                 " VALUES ( " +
                                                 "  :cdApproversStatus, " +
                                                 "  :dtApproversDetermination, " +
                                                 "  :dtApproversRequested, " +
                                                 "  :idApproval, " +
                                                 "   SEQ_APPROVERS.NEXTVAL, " +
                                                 "  :idPerson, " +
                                                 "  :idTodo, " +
                                                 "  :indApproversHistorical, " +
                                                 "  :cdTxtApproversComments)");

    query.setString("cdApproversStatus", cdApproversStatus);
    query.setTimestamp("dtApproversDetermination", dtApproversDetermination);
    query.setTimestamp("dtApproversRequested", dtApproversRequested);
    query.setInteger("idApproval", idApproval);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idTodo", idTodo);
    query.setString("indApproversHistorical", indApproversHistorical);
    query.setString("cdTxtApproversComments", cdTxtApproversComments);
    return query.executeUpdate();
  }

  public Date findApproversDtApproversDetermination(int idApproval) {
    Query query = getSession().createQuery("select a.dtApproversDetermination " +
                                           " from   Approvers a " +
                                           " where  a.approval.idApproval = :idApproval " +
                                           "        and a.idApprovers = (select max(a1.idApprovers) as idApprovers " +
                                           "                             from   Approvers a1 " +
                                           "                             where  a1.approval.idApproval = a.approval.idApproval " +
                                           "                                    and a1.dtApproversDetermination = (select max(a3.dtApproversDetermination) as dtApproversDetermination " +
                                           "                                                                       from   Approvers a3 " +
                                           "                                                                       where  a3.approval.idApproval = a.approval.idApproval)) ");

    query.setInteger("idApproval", idApproval);
    return (Date) firstResult(query);
  }
  
  public int deleteApproversByIdApproval(Collection<Integer> idApprovalList) {
    Query query = getSession().createQuery("delete Approvers aps" +
                                           " where aps.approval.idApproval in (:idApprovalList) ");
    query.setParameterList("idApprovalList", idApprovalList);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public List<Approvers> findApproversByIdApproval(Collection<Integer> idApprovalList) {
    Query query = getSession().createQuery(" from Approvers " +
                                           " where approval.idApproval in (:idApprovalList) ");
    query.setParameterList("idApprovalList", idApprovalList);
    return (List<Approvers>)query.list();
  }
  
  public int deleteApproversByIdApproval(int idApproval) {
    Query query = getSession().createQuery("delete Approvers " +
                                           " where approval.idApproval = :idApproval");
    query.setInteger("idApproval", idApproval);
    return query.executeUpdate();
  }
  
  //STGAP00010749: Gets the Approver record for the given id event
  public Approvers findApproverByIdEvent(int idEvent){
    Query query = getSession().createQuery(" from Approvers a join fetch a.person " +
                                           " where a.approval.idApproval = (select max(ael.approval.idApproval) " +
                                           " from ApprovalEventLink ael " +
                                           " where ael.event.idEvent = :idEvent) " +
                                           " order by a.idApprovers desc");
    query.setInteger("idEvent", idEvent);
    return (Approvers)firstResult(query);
  }
  
  //STGAP00010749: Gets the list of Approver records for the given id Approval
  @SuppressWarnings({"unchecked"})
  public List<Approvers> findApproverByIdApprovalByCdStatus(int idApproval, int idApprovers){
    Query query = getSession().createQuery(" from Approvers a " +
                                           " where a.approval.idApproval = :idApproval " +
                                           " and a.idApprovers <> :idApprovers " +
                                           " and a.cdApproversStatus <> :cdApproversStatus ");
    query.setInteger("idApproval", idApproval);
    query.setInteger("idApprovers", idApprovers);
    query.setString("cdApproversStatus", CodesTables.CEVTSTAT_APRV);
    return (List<Approvers>)firstResult(query);
  }
  
  //STGAP00014341: Delete Approvers for the stage and task
  public int deleteApproversByIdStageCdTask(int idStage, String cdTask) {
    SQLQuery query = getSession().createSQLQuery("delete from Approvers where id_approval in " +
                                                 " (select id_approval from approval_event_link " +
                                                 "where id_event in (select id_event from event where " +
                                                 "cd_event_type = :cdEventType and cd_task = :cdTask and id_event_stage= :idStage))" );
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_APP);
    return query.executeUpdate();
  }
  
  //STGAP00014341: Delete Approvers for the stage and task
  public int deleteApprovers(int idStage, String cdTask) {
    SQLQuery query = getSession().createSQLQuery("delete from Approvers where id_approval in " +
                                                 " (select id_event from event where " +
                                                 "cd_event_type = :cdEventType and cd_task = :cdTask and id_event_stage= :idStage)" );
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_APP);
    return query.executeUpdate();
  }
  
  //STGAP00014341: find Approvers for SUB, FPR and FSU
  public Approvers findApproverByIdEventForFSUSUBFPR(int idEvent){
    Query query = getSession().createQuery(" from Approvers a join fetch a.person " +
                                           " where a.approval.idApproval = (select e.idEvent " +
                                           " from Event e " +
                                           " where e.idEvent = :idEvent) " +
                                           " order by a.idApprovers desc");
    query.setInteger("idEvent", idEvent);
    return (Approvers)firstResult(query);
  }
}
