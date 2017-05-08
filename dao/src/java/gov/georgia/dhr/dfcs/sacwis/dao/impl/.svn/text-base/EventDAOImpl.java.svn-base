package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * This is the DAO class is used for the Event table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  08/04/2008  arege    STGAP00007353 Added findEventIdByIdCaseByCdEventStatus()
 *                       to get all the events related to a case that has pending Status.
 *  10/08/2008  arege    STGAP00010425 Modified the method findEventIdByIdCaseByCdEventStatus()
 *                       to find eventids for both the cases involved in  a merge. Changed its name to 
 *                       findEventIdByIdCaseToByIdCaseFromByCdEventStatus()
 *  02/04/2009  mxpatel  STGAP00012290: Added a new method to find any approved adoption application for a stage.      
 *  
 *  04/01/2009  bgehlot  Added method findEventByIdCaseAndCdEventTypeDesc
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteEvent, deleteEventByStageDesc, updateEventByStageTaskType,
 *                       findEventByIdStageAndEventTypeAndTaskIdEventDesc
 *  08/27/2009  cwells   STGAP00014529: added method findApprovedEventByIdStageAndEventTypeAndTask()        
 *  12/02/2009  arege    SMS#37215 Added to find Earliest Event of given type and in given status for a given stage           
 *  04/19/2010  arege    SMS#46744 Addded method updateEventByIdStageAndCdEventType 
 *  05/05/2010  arege    SMS#42496: Added findEventByIdStageCdEventStatusCdEventTypes
 *  05/24/2010  arege    SMS#42496: Added method findEventByIdCaseAndCdEventStatus
 *  06/02/2010  arege    SMS#54782: Added findAprvChildDeathReportByIdPersonIdStage
 *                       
 * </pre>
 */

public class EventDAOImpl extends BaseDAOImpl implements EventDAO {
  @SuppressWarnings( { "unchecked" })
  public List<Event> findEventByIdStageAndCdEventStatus(int idStage, String cdEventStatus) {
    Query query = getSession().createQuery(
                                           " from Event a " + "where a.stage.idStage = :idStage "
                                                           + "  and a.cdEventStatus = :cdEventStatus "
                                                           + "  and (a.cdTask <> '7085' "
                                                           + "       or a.cdTask <> '7090' "
                                                           + "       or a.cdTask <> '7095')");
    query.setInteger("idStage", idStage);
    query.setString("cdEventStatus", cdEventStatus);
    return (List<Event>) query.list();
  }

  public Event findEventByStageAndType(int idEventStage, String cdEventType) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idEventStage "
                                                           + "     and e.cdEventType = :cdEventType "
                                                           + "order by e.dtEventOccurred");

    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    return (Event) firstResult(query);

  }
  
 
  public Event findLatestEventByStageAndType(int idEventStage, String cdEventType) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idEventStage "
                                                           + "     and e.cdEventType = :cdEventType "
                                                           + "order by e.dtEventOccurred desc");

    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    return (Event) firstResult(query);

  }
  
  public Integer findIdEventByIdEventPerson(int idPerson){
    
    Query query = getSession().createQuery(" select ev.idEvent from Event ev,InitialMedicaidApp ima  " +
                                           " where ev.idEvent = ima.idEvent " +
                                           " and ev.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
    
    
    
  }
  
  public Event findEventByStageTypeAndStatus(int idEventStage, String cdEventType, String cdEventStatus) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idEventStage "
                                                           + "     and e.cdEventType = :cdEventType "
                                                           + "     and e.cdEventStatus = :cdEventStatus "
                                                           + "order by e.dtEventOccurred desc");

    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    return (Event) firstResult(query);

  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Event> findAllEventsByStageTypeAndStatus(int idEventStage, String cdEventType1, String cdEventType2, String cdEventStatus) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idEventStage "
                                                           + "     and (e.cdEventType = :cdEventType1 or e.cdEventType = :cdEventType2)"
                                                           + "     and e.cdEventStatus = :cdEventStatus "
                                                           + "order by e.dtEventOccurred desc, e.dtLastUpdate desc");

    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType1", cdEventType1);
    query.setString("cdEventType2", cdEventType2);
    query.setString("cdEventStatus", cdEventStatus);
    return (List<Event>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Event> findEventWithIdStageAndCdTask(int idStage, String cdTask) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idStage "
                                                           + "     and e.cdTask = :cdTask " + "order by idEvent");

    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    return (List<Event>) query.list();
  }

  public Event findEventByIdEvent(int idEvent) {
    Session session = getSession();
    Query query = session.createQuery(" from Event " + "where idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (Event) firstResult(query);
  }

  public Event findApprovalStatus(int idApproval) {
    Query query = getSession().createQuery(" from Event a " + "where a.idEvent = :idApproval ");
    query.setInteger("idApproval", idApproval);
    return (Event) firstResult(query);
  }

  public Event findEventByIdStageAndEventTypeAndTask(int idEventStage, String cdEventType, String cdTask) {
    Query query = getSession().createQuery(
                                           " from Event e " + "where e.stage.idStage = :idEventStage "
                                                           + "  and e.cdEventType = :cdEventType "
                                                           + "  and e.cdTask = :cdTask");
    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdTask", cdTask);
    return (Event) firstResult(query);
  }
  
  public Event findApprovedEventByIdStageAndEventTypeAndTask(int idEventStage, String cdEventType, String cdTask) {
	    Query query = getSession().createQuery(
	                                           " from Event e " + "where e.stage.idStage = :idEventStage "
	                                                           + "  and e.cdEventType = :cdEventType "
	                                                           + "  and e.cdEventStatus = 'APRV'"
	                                                           + "  and e.cdTask = :cdTask "
	                                                           + "order by dtLastUpdate desc");
	    query.setInteger("idEventStage", idEventStage);
	    query.setString("cdEventType", cdEventType);
	    query.setString("cdTask", cdTask);
	    return (Event) firstResult(query);
	  }
  
  @SuppressWarnings( { "unchecked" })
  public Map findEventByIdStageCdTask(int idStage, String cdTask) {
    Query query = getSession()
                              .createQuery(
                                           "  select new map(e.idEvent as idEvent, "
                                                           + "                e.cdEventStatus as cdEventStatus) "
                                                           + "    from Event e "
                                                           + "   where e.stage.idStage = :idStage "
                                                           + "     and e.cdTask = :cdTask "
                                                           + "order by decode(e.cdEventStatus, 'NEW' ,1, 'PROC', 2, 'COMP', 3, 'PEND', 4, 'APRV', 5, 'REJT', 6) ");

    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    return (Map) firstResult(query);
  }
  @SuppressWarnings( { "unchecked" })
  public Map findEventByIdStageCdTaskOrderByIdEvent(int idStage, String cdTask) {
    Query query = getSession()
                              .createQuery(
                                           " select new map(e.idEvent as idEvent, "
                                                           + "                e.cdEventStatus as cdEventStatus) "
                                                           + "    from Event e "
                                                           + "   where e.stage.idStage = :idStage "
                                                           + "     and e.cdTask = :cdTask " + "order by e.idEvent desc");
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    return (Map) firstResult(query);
  }
 
  public String findCdEventTypeByIdEvent(int idEvent){
    
    Query query = getSession().createQuery(" select e.cdEventType from Event e " + "where e.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (String) firstResult(query);
    
  }
 
  public String findEventCdEventStatus(int idCase, String cdStageInvestigation) {
    String cdInvConclusion = "CCL";
    Query query = getSession()
                              .createQuery(
                                           "select e.cdEventStatus "
                                                           + "  from Event e "
                                                           + " where e.cdEventType = :cdInvConclusion "
                                                           + "   and e.stage.idStage in (select s.idStage "
                                                           + "                          from Stage s"
                                                           + "                         where s.capsCase.idCase = :idCase "
                                                           + "                           and s.cdStage = :cdStageInvestigation "
                                                           + "                           and s.dtStageClose is null )");
    query.setInteger("idCase", idCase);
    query.setString("cdStageInvestigation", cdStageInvestigation);
    query.setString("cdInvConclusion", cdInvConclusion);
    return (String) firstResult(query);
  }
 
  public String findUnAprvLatestWTLP(int idCase, Collection<Integer> principalsForEvent) {
    Query query = getSession().createSQLQuery("SELECT E.CD_EVENT_STATUS " +
                                              "  FROM EVENT E " +
                                              " WHERE (E.CD_EVENT_TYPE,E.ID_EVENT_STAGE,E.DT_EVENT_OCCURRED) IN " +
                                              "       (  SELECT E.CD_EVENT_TYPE, " +
                                              "                 E.ID_EVENT_STAGE, " +
                                              "                 MAX(E.DT_EVENT_OCCURRED) " +
                                              "            FROM EVENT E, " +
                                              "                 STAGE S, " +
                                              "                 STAGE_PERSON_LINK SPL, " +
                                              "                 PERSON P " +
                                              "           WHERE (S.CD_STAGE = 'SUB' " +
                                              "               OR S.CD_STAGE = 'ADO') " +
                                              "             AND S.ID_CASE = :idCase " +
                                              "             AND E.ID_EVENT_STAGE = S.ID_STAGE " +
                                              "             AND S.ID_STAGE = SPL.ID_STAGE " +
                                              "             AND SPL.ID_PERSON = P.ID_PERSON " +
                                              "             AND SPL.ID_PERSON IN (:principalsForEvent) " +
                                              "             AND SPL.CD_STAGE_PERS_ROLE = 'PC' " +
                                              "             AND MONTHS_BETWEEN(SYSDATE,P.DT_PERSON_BIRTH) >= 168 " +
                                              "        GROUP BY E.ID_EVENT_STAGE,E.CD_EVENT_TYPE " +
                                              "          HAVING E.CD_EVENT_TYPE = 'WTL') " +
                                              "   AND E.CD_EVENT_STATUS <> 'APRV'");
    query.setInteger("idCase", idCase);
    query.setParameterList("principalsForEvent", principalsForEvent);
    return (String) firstResult(query);
  }
  
 //STGAP00007353 Added method to get all the events related to a case that has pending Status.
 //STGAP00010425 Modified the method to find eventids for both the cases involved in  a merge. 
  @SuppressWarnings( { "unchecked" })
  public List<Integer> findEventIdByIdCaseToByIdCaseFromByCdEventStatus(int idCaseTo,int idCaseFrom, String cdEventStatus) {
    Query query = getSession().createQuery(
                                           "select e.idEvent"
                                           + " from Event e ," + "Stage s "
                                           + " where e.stage.idStage = s.idStage "
                                           + "   and (e.capsCase.idCase = :idCaseTo or e.capsCase.idCase = :idCaseFrom) "
                                           + "   and e.cdEventStatus = :cdEventStatus "
                                           + "   and s.dtStageClose is null ");
    query.setInteger("idCaseTo", idCaseTo);
    query.setInteger("idCaseFrom", idCaseFrom);
    query.setString("cdEventStatus", cdEventStatus);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public Map findEventAndStageByIdCaseByCdEventStatus(int idCase, String cdEventStatus) {
    Query query = getSession()
                              .createQuery(
                                           " select new map(e.cdEventStatus as cdEventStatus, "
                                                           + "                e.cdEventType as cdEventType, "
                                                           + "                e.idEvent as idEvent, "
                                                           + "                e.person.idPerson as idEventPerson, "
                                                           + "                e.stage.idStage as idEventStage, "
                                                           + "                e.txtEventDescr as txtEventDescr, "
                                                           + "                s.cdStageReasonClosed as cdStageReasonClosed, "
                                                           + "                s.indStageClose as indStageClose) "
                                                           + "  from Event e, " + "       Stage s "
                                                           + " where e.stage.idStage = s.idStage "
                                                           + "   and e.capsCase.idCase = :idCase "
                                                           + "   and e.cdEventStatus = :cdEventStatus "
                                                           + "   and s.dtStageClose is null ");
    query.setInteger("idCase", idCase);
    query.setString("cdEventStatus", cdEventStatus);
    return (Map) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Map findEventAndStage(int idCase, String cdEventType, String cdEventStatus) {
    Query query = getSession()
                              .createQuery(
                                           " select new map(e.cdEventStatus as cdEventStatus, "
                                                           + "                e.cdEventType as cdEventType, "
                                                           + "                e.idEvent as idEvent, "
                                                           + "                e.person.idPerson as idEventPerson, "
                                                           + "                e.stage.idStage as idEventStage, "
                                                           + "                e.txtEventDescr as txtEventDescr, "
                                                           + "                s.cdStageReasonClosed as cdStageReasonClosed, "
                                                           + "                s.indStageClose as indStageClose) "
                                                           + "  from Event e, " + "       Stage s "
                                                           + " where e.stage.idStage = s.idStage "
                                                           + "   and e.capsCase.idCase = :idCase "
                                                           + "   and e.cdEventType = :cdEventType "
                                                           + "   and e.cdEventStatus = :cdEventStatus "
                                                           + "   and s.dtStageClose is null ");
    query.setInteger("idCase", idCase);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    return (Map) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Event> findEventByIdStageAndCdEventType(int idEventStage, String cdEventType) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idEventStage "
                                                           + "     and e.cdEventType = :cdEventType "
                                                           + "order by dtEventOccurred");
    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    // return (List<Event>) firstResult(query);
    return (List<Event>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Event> findEventByIdStageAndCdEventTypeDesc(int idEventStage, String cdEventType, Collection<String> cdEventStatuses) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idEventStage "
                                                           + " and e.cdEventType = :cdEventType  " 
                                                           + " and e.cdEventStatus in ( :cdEventStatuses ) "
                                                           + " order by idEvent desc");
    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdEventStatuses", cdEventStatuses);
    return (List<Event>) query.list();
  }

  public Integer findIdEventFromEvent(int idStage, String cdEventType, String cdEventStatus, String txtEventDescr) {
    Query query = getSession().createQuery(
                                           "select idEvent " + "  from Event e " + " where e.stage.idStage = :idStage "
                                                           + "   and e.cdEventType = :cdEventType "
                                                           + "   and e.cdEventStatus = :cdEventStatus "
                                                           + "   and trim(e.txtEventDescr) = :txtEventDescr ");
    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("txtEventDescr", txtEventDescr);
    return (Integer) firstResult(query);
  }

  public long countEventRowsByIdStage(int idStage) {
    Query query = getSession()
                              .createQuery("select count(*) " + "  from Event e " + " where e.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }
  //STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
  //The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary type. 
  @SuppressWarnings( { "unchecked" })
  public Map findEventIdPlcmtEventByDtPlcmtStart(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                     Date dtPlcmtStart, Date dtPlcmtEnd) {
    Query query = getSession().createQuery(
                                           "select new map(p.idPlcmtEvent as idPlcmtEvent, p.cdTempType as cdTempType) " 
                                                           + "  from Event e, Placement p "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and e.idEvent = p.idPlcmtEvent "
                                                           + "   and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and trunc(p.dtPlcmtStart) > trunc(:dtPlcmtStart) "
                                                           + "   and trunc(p.dtPlcmtStart) < trunc(:dtPlcmtEnd) "
                                                           + "   and trunc(p.dtPlcmtStart) <> trunc(p.dtPlcmtEnd)");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    return (Map) firstResult(query);
  }

  //STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
  //The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary type. 
  @SuppressWarnings( { "unchecked" })
  public List<Map> findEventIdPlcmtEventByDtPlcmtStartAndEnd(int idCase, int idPlcmtChild,
                                                                 String cdPlcmtActPlanned, Date dtPlcmtStart,
                                                                 Date dtPlcmtEnd) {
    Query query = getSession()
                              .createQuery(
                                           " select new map(p.idPlcmtEvent as idPlcmtEvent, p.cdTempType as cdTempType) "
                                                           + "   from Placement p "
                                                           + "   join p.event e "
                                                           + "  where p.capsCase.idCase = :idCase "
                                                           + "    and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "    and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "    and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "    and trunc(p.dtPlcmtStart) <= trunc(:dtPlcmtStart) "
                                                           + "    and trunc(p.dtPlcmtEnd) >= trunc(:dtPlcmtEnd) "
                                                           + "    and trunc(p.dtPlcmtStart) <> trunc(p.dtPlcmtEnd) "
                                                           + "    and not (:dtPlcmtStart = :dtPlcmtEnd "
                                                           + "             and (trunc(p.dtPlcmtStart) = trunc(:dtPlcmtStart) "
                                                           + "                  or trunc(p.dtPlcmtEnd) = trunc(:dtPlcmtEnd)))");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    return (List<Map>) query.list();
  }

  //STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
  //The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary type. 
  @SuppressWarnings( { "unchecked" })
  public List<Map> findEventIdPlcmtEventCurrDtPlcmtStartEqlGrtrDtEnd(int idCase, int idPlcmtChild,
                                                                         String cdPlcmtActPlanned, Date dtPlcmtStart,
                                                                         Date currDtPlcmtStart, int idPlcmtEvent) {
    Query query = getSession().createQuery(
                                           "select new map(p.idPlcmtEvent as idPlcmtEvent, p.cdTempType as cdTempType) " + "  from Event e, " + "       Placement p "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and e.idEvent = p.idPlcmtEvent "
                                                           + "   and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and trunc(p.dtPlcmtEnd) <= :currDtPlcmtStart "
                                                           + "   and trunc(p.dtPlcmtEnd) > :dtPlcmtStart "
                                                           + "   and p.idPlcmtEvent <> :idPlcmtEvent");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setTimestamp("currDtPlcmtStart", currDtPlcmtStart);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    return (List<Map>) query.list();
  }

  //STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
  //The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary type. 
  @SuppressWarnings( { "unchecked" })
  public List<Map> findIdPlcmtEventByCurrDtPlcmtEnd(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                        Date dtCurrPlcmtEnd, Date dtPlcmtEnd, int idPlcmtEvent) {
    Query query = getSession().createQuery(
                                           "select new map(p.idPlcmtEvent as idPlcmtEvent, p.cdTempType as cdTempType) " + "  from Event e, " + "       Placement p "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and e.idEvent = p.idPlcmtEvent "
                                                           + "   and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and trunc(p.dtPlcmtStart) >= :dtCurrPlcmtEnd "
                                                           + "   and trunc(p.dtPlcmtStart) < trunc(:dtPlcmtEnd) "
                                                           + "   and p.idPlcmtEvent <> :idPlcmtEvent");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setTimestamp("dtCurrPlcmtEnd", dtCurrPlcmtEnd);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    return (List<Map>) query.list();
  }

  public String findEventStatus(int idStage, String cdContactType) {
    Query query = getSession().createQuery(
                                           "select e.cdEventStatus " + "  from Contact c " + "  join c.event e "
                                                           + " where c.stage.idStage = :idStage "
                                                           + "   and c.cdContactType = :cdContactType "
                                                           + "   and e.cdEventStatus in (:cdEventStatuses)");
    query.setInteger("idStage", idStage);
    query.setString("cdContactType", cdContactType);
    query.setParameterList("cdEventStatuses", new String[] { CodesTables.CEVTSTAT_COMP, CodesTables.CEVTSTAT_PEND,
                                                            CodesTables.CEVTSTAT_APRV }, Hibernate.STRING);
    return (String) firstResult(query);
  }

  public String findEventStatus(int idStage, String cdContactType, String cdEventStatus) {
    Query query = getSession().createQuery(
                                           "select e.cdEventStatus " + "  from Contact c " + "  join c.event e "
                                                           + " where c.stage.idStage = :idStage "
                                                           + "   and c.cdContactType = :cdContactType "
                                                           + "   and e.cdEventStatus = :cdEventStatus");
    query.setInteger("idStage", idStage);
    query.setString("cdContactType", cdContactType);
    query.setString("cdEventStatus", cdEventStatus);
    return (String) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findEventHistory(int idStage, String cdEventType) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT N.NM_NAME_FIRST AS NM_NAME_FIRST, "
                                                                 + "       N.NM_NAME_MIDDLE AS NM_NAME_MIDDLE, "
                                                                 + "       N.NM_NAME_LAST AS NM_NAME_LAST, "
                                                                 + "       N.CD_NAME_SUFFIX AS CD_NAME_SUFFIX, "
                                                                 + "       EJH.CD_JOB_BJN AS CD_JOB_BJN, "
                                                                 + "       M.ADDR_MAIL_CODE_CITY AS ADDR_MAIL_CODE_CITY, "
                                                                 + "       PP.NBR_PERSON_PHONE AS NBR_PERSON_PHONE, "
                                                                 + "       PP.NBR_PERSON_PHONE_EXTENSION AS NBR_PERSON_PHONE_EXTENSION, "
                                                                 + "       EV.ID_EVENT_PERSON AS ID_EVENT_PERSON, "
                                                                 + "       EV.CD_EVENT_STATUS AS CD_EVENT_STATUS, "
                                                                 + "       EV.CD_EVENT_TYPE AS CD_EVENT_TYPE, "
                                                                 + "       EV.DT_EVENT_OCCURRED AS DT_EVENT_OCCURRED "
                                                                 + "  FROM PERSON_PHONE PP, "
                                                                 + "       MAIL_CODE M, "
                                                                 + "       OFFICE O, "
                                                                 + "       EMP_JOB_HISTORY EJH, "
                                                                 + "       EMPLOYEE EMP, "
                                                                 + "       NAME N, "
                                                                 + "       EVENT EV "
                                                                 + " WHERE EV.ID_EVENT_STAGE = :idStage "
                                                                 + "   AND EV.CD_EVENT_TYPE   = :cdEventType "
                                                                 + "   AND EV.CD_EVENT_STATUS <> :cdReject "
                                                                 + "   AND EV.DT_EVENT_OCCURRED = "
                                                                 + "       (SELECT (MAX(EV2.DT_EVENT_OCCURRED)) "
                                                                 + "          FROM EVENT EV2 "
                                                                 + "         WHERE EV2.ID_EVENT_STAGE = :idStage "
                                                                 + "           AND EV2.CD_EVENT_TYPE   = :cdEventType "
                                                                 + "           AND EV2.CD_EVENT_STATUS <> :cdReject) "
                                                                 + "   AND EV.ID_EVENT_PERSON = N.ID_PERSON(+) "
                                                                 + "   AND N.IND_NAME_PRIMARY(+) = :indYes "
                                                                 + "   AND NVL(N.DT_NAME_END_DATE, :dtMaxDate) = "
                                                                 + "       (SELECT NVL(MAX(N2.DT_NAME_END_DATE),:dtMaxDate) "
                                                                 + "          FROM NAME N2 "
                                                                 + "         WHERE N2.ID_PERSON(+) = EV.ID_EVENT_PERSON "
                                                                 + "           AND N2.IND_NAME_PRIMARY(+) = :indYes) "
                                                                 + "   AND EV.ID_EVENT_PERSON = EMP.ID_PERSON(+) "
                                                                 + "   AND EMP.ID_EMP_OFFICE = O.ID_OFFICE (+) "
                                                                 + "   AND O.CD_OFFICE_MAIL = M.CD_MAIL_CODE(+) "
                                                                 + "   AND EV.ID_EVENT_PERSON = EJH.ID_PERSON(+) "
                                                                 + "   AND NVL(EJH.DT_JOB_END,:dtMaxDate) = "
                                                                 + "       (SELECT NVL(MAX(EJH2.DT_JOB_END),:dtMaxDate) "
                                                                 + "          FROM EMP_JOB_HISTORY EJH2 "
                                                                 + "         WHERE EV.ID_EVENT_PERSON = EJH2.ID_PERSON(+) ) "
                                                                 + "   AND EV.ID_EVENT_PERSON = PP.ID_PERSON(+) "
                                                                 + "   AND PP.CD_PERSON_PHONE_TYPE(+) = :cdBSType "
                                                                 + "   AND PP.IND_PERSON_PHONE_PRIMARY(+) = :indYes "
                                                                 + "   AND NVL(PP.DT_PERSON_PHONE_END,:dtMaxDate) = "
                                                                 + "        (SELECT NVL(MAX(PP2.DT_PERSON_PHONE_END),:dtMaxDate) "
                                                                 + "           FROM PERSON_PHONE PP2 "
                                                                 + "         WHERE EV.ID_EVENT_PERSON = PP2.ID_PERSON(+) "
                                                                 + "           AND PP2.CD_PERSON_PHONE_TYPE(+) = :cdBSType "
                                                                 + "           AND PP2.IND_PERSON_PHONE_PRIMARY(+) = :indYes)");
    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdReject", CodesTables.CAPPDESG_REJT);
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
    query.addScalar("NBR_PERSON_PHONE_EXTENSION", Hibernate.STRING);
    query.addScalar("ID_EVENT_PERSON", Hibernate.INTEGER);
    query.addScalar("CD_EVENT_STATUS", Hibernate.STRING);
    query.addScalar("CD_EVENT_TYPE", Hibernate.STRING);
    query.addScalar("DT_EVENT_OCCURRED", Hibernate.DATE);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findEventDescriptionInformationByIdStage(int idStage) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "  SELECT SUBSTR(TXT_EVENT_DESCR,1,4) AS CD_EVENT_STATUS, "
                                                                 + "         SUBSTR(TXT_EVENT_DESCR,5,2) AS CD_STAGE_RSN_PRIORITY_CHG, "
                                                                 + "         SUBSTR(TXT_EVENT_DESCR,7) AS TXT_STAGE_PRIORITY_CMTS "
                                                                 + "    FROM EVENT "
                                                                 + "   WHERE ID_EVENT_STAGE = :idStage "
                                                                 + "     AND CD_EVENT_TYPE  = :cdPrtType "
                                                                 + "ORDER BY DT_EVENT_OCCURRED");
    query.setInteger("idStage", idStage);
    query.setString("cdPrtType", CodesTables.CEVNTTYP_PRT);
    query.addScalar("CD_EVENT_STATUS", Hibernate.STRING);
    query.addScalar("CD_STAGE_RSN_PRIORITY_CHG", Hibernate.STRING);
    query.addScalar("TXT_STAGE_PRIORITY_CMTS", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }

  public int updateEventByIdStageCdEventType(String cdEventStatus, int idStage, String cdEventType) {
    Query query = getSession().createQuery(
                                           "update Event e " + "    set e.cdEventStatus = :cdEventStatus "
                                                           + "  where e.stage.idStage = :idStage "
                                                           + "    and e.cdEventType = :cdEventType ");

    query.setString("cdEventStatus", cdEventStatus);
    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    return query.executeUpdate();
  }

  public int updateEvent(String cdEventStatus, String cdEventType, int idPerson, int idStage, String txtEventDescr,
                         String cdTask, int idEvent, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "update Event " + "   set cdEventStatus = :cdEventStatus, "
                                                           + "       cdEventType = :cdEventType, "
                                                           + "       person.idPerson = :idPerson, "
                                                           + "       stage.idStage = :idStage, "
                                                           + "       txtEventDescr = :txtEventDescr, "
                                                           + "       cdTask = :cdTask " + " where idEvent = :idEvent "
                                                           + "   and dtLastUpdate = :dtLastUpdate");
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setString("txtEventDescr", txtEventDescr);
    query.setString("cdTask", cdTask);
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
  
  public int updatePortalEvent(String cdEventStatus, String cdEventType,int idStage, String txtEventDescr,
                         String cdTask, int idEvent, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "update Event " + "   set cdEventStatus = :cdEventStatus, "
                                                           + "       cdEventType = :cdEventType, "
                                                           + "       stage.idStage = :idStage, "
                                                           + "       txtEventDescr = :txtEventDescr, "
                                                           + "       cdTask = :cdTask " + " where idEvent = :idEvent "
                                                           + "   and dtLastUpdate = :dtLastUpdate");
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setInteger("idStage", idStage);
    query.setString("txtEventDescr", txtEventDescr);
    query.setString("cdTask", cdTask);
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updateEvent(int idEvent) {
    Query query = getSession().createQuery("update Event " + "   set idEvent = idEvent " + " where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int updateEventByIdEvent(int idEvent, String cdEventStatus) {
    Query query = getSession().createQuery(
                                           "update Event " + "   set cdEventStatus = :cdEventStatus "
                                                           + " where idEvent = :idEvent");
    query.setString("cdEventStatus", cdEventStatus);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int updateEventByIdEventAndCdTask(int idStage, String cdTask, int idEvent) {
    Query query = getSession().createQuery(
                                           "update Event " + "   set stage.idStage = :idStage, "
                                                           + "       cdTask = :cdTask " + " where idEvent = :idEvent");
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int updateEvent(String cdEventStatus, int idStage, String cdEventType) {
    Query query = getSession().createQuery(
                                           "update Event " + "   set cdEventStatus = :cdEventStatus "
                                                           + " where stage.idStage = :idStage "
                                                           + "   and cdEventType = :cdEventType ");
    query.setString("cdEventStatus", cdEventStatus);
    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    return query.executeUpdate();
  }

  public int updateEventByIdEventAlsoDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred,
                                                  int idPerson, int idStage, String txtEventDescr, String cdTask,
                                                  int idEvent, Date dtLastUpdate) {

    Query query = getSession().createQuery(
                                           "update Event " + "   set cdEventStatus = :cdEventStatus, "
                                                           + "       cdEventType = :cdEventType, "
                                                           + "       dtEventOccurred = :dtEventOccurred, "
                                                           + "       person.idPerson = :idPerson, "
                                                           + "       stage.idStage = :idStage, "
                                                           + "       txtEventDescr = :txtEventDescr, "
                                                           + "       cdTask = :cdTask " + " where idEvent = :idEvent "
                                                           + "   and dtLastUpdate = :dtLastUpdate");

    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setTimestamp("dtEventOccurred", dtEventOccurred);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setString("txtEventDescr", txtEventDescr);
    query.setString("cdTask", cdTask);
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
  
  public int updatePortalEventByIdEventAlsoDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred,
                                                        int idStage, String txtEventDescr, String cdTask,
                                                  int idEvent, Date dtLastUpdate) {

    Query query = getSession().createQuery(
                                           "update Event " + "   set cdEventStatus = :cdEventStatus, "
                                                           + "       cdEventType = :cdEventType, "
                                                           + "       dtEventOccurred = :dtEventOccurred, "
                                                           + "       stage.idStage = :idStage, "
                                                           + "       txtEventDescr = :txtEventDescr, "
                                                           + "       cdTask = :cdTask " + " where idEvent = :idEvent "
                                                           + "   and dtLastUpdate = :dtLastUpdate");

    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setTimestamp("dtEventOccurred", dtEventOccurred);
    query.setInteger("idStage", idStage);
    query.setString("txtEventDescr", txtEventDescr);
    query.setString("cdTask", cdTask);
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }


  public int deleteEvent(int idEvent, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "delete Event " + " where idEvent = :idEvent "
                                                           + "   and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();

  }

  public int deleteEvent(int idStage) {
    Query query = getSession().createQuery("delete from Event e " + "      where e.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);

    return query.executeUpdate();
  }

  public int deleteEventByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from Event e " + " where e.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();
  }
  
  public int deleteAppEventByIdApproval(Collection<Integer> idApprovalList ) {  
    Query query = getSession().createQuery("delete from Event e " + " where e.idEvent in (:idApprovalList) ");
    query.setParameterList("idApprovalList", idApprovalList);
    return query.executeUpdate();
  }

  public void deleteEvent(Event event) {
    getSession().delete(event);
  }

  public void saveEvent(Event event) {
    getSession().saveOrUpdate(event);

  }
  public int saveEventReturnsEventId(Event event){
    getSession().saveOrUpdate(event);
    return event.getIdEvent();
  }
  public long countCompletedRiskAssessments(int idStage) {

    Query query = getSession().createQuery(
                                           "select count(*) from  Event e " + " where e.stage.idStage = :idStage "
                                                           + " and e.cdEventType='ASM' " + " and e.cdTask='2295' "
                                                           + " and e.cdEventStatus='COMP'");
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  public Object[] findSafetyAssessments(int idStage) {

    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 " SELECT a.a1 AS totalSafetyAssessments , b.b1 AS numApproved   "
                                                                 + " FROM ( SELECT COUNT(*) a1 FROM Event e WHERE e.id_event_stage=:idStage AND e.cd_Task='2285' ) a , ( SELECT COUNT(*) b1 FROM Event e WHERE e.id_Event_stage=:idStage AND e.cd_Task='2285' AND e.cd_Event_Status='APRV') b");
    query.setInteger("idStage", idStage);
    query.addScalar("totalSafetyAssessments", Hibernate.INTEGER);
    query.addScalar("numApproved", Hibernate.INTEGER);
    return (Object[]) query.uniqueResult();
  }
  public String findEventCdEventStatusbyIdEvent(int idEvent) {

    Query query = getSession().createQuery(
                                             "select e.cdEventStatus " + "  from Event e "
                                                     + " where e.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (String) firstResult(query);
    }
  
  public Integer retrieveIdEventFromEvent(int idStage) {

    Query query = getSession().createQuery(
                                             "select e.idEvent " + "  from Event e "
                                                    + " where e.stage.idStage = :idStage "
                                                    + " AND e.cdEventType = 'IMA'" );
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
    }
  
  public long findCountEventByIdStageCdTask(int idStage, String cdTask) {
    Query query = getSession().createQuery(
                                           "  select count(*) " + "    from Event e "
                                                           + "   where e.stage.idStage = :idStage "
                                                           + "     and e.cdTask = :cdTask ");

    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings( { "unchecked" })
  public Map findLatestChildEventStatusByPersonByCase(String cdEventType, int idPerson, int idCase) {
    Query query = getSession()
    .createQuery(" SELECT new map (e.cdEventStatus AS CD_EVENT_STATUS, " +
                " e.dtEventOccurred AS DT_EVENT_OCCURRED, " +
                " e.idEvent AS ID_EVENT) " +
                " FROM Event e, StagePersonLink spl " +
                " WHERE e.stage.idStage = spl.stage.idStage " +
                " AND e.capsCase.idCase = :idCase AND spl.person.idPerson = :idPerson " +
                " AND (spl.stage.cdStage = :cdStageSUB OR spl.stage.cdStage = :cdStageADO) " +
                " AND spl.cdStagePersRole = :cdStagePersRole " +
                " AND e.cdEventType = :cdEventType " +
                " ORDER BY e.dtEventOccurred DESC, e.idEvent DESC ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStageADO", CodesTables.CSTAGES_ADO);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    return (Map) firstResult(query);
  }
  
  //mxpatel added this method for defect #12290
  @SuppressWarnings( { "unchecked" })
  public long countAprvEventsOfSndType( int idStage) {
    Query query = getSession().createQuery(
                                           "  select count(*) " + "    from Event e "
                                                           + "   where e.cdEventType = 'SND' "
                                                           + "     and e.cdEventStatus = 'APRV' "
                                                           + "     and e.stage = :idStage ");

    query.setInteger("idStage", idStage);
    return  (Long) query.uniqueResult();
  }
  
  @SuppressWarnings( { "unchecked" })
  //STGAP00012833: Retrieve the events for cdEventType and cdEventStatus by idCase
  public List<Event> findEventByIdCaseAndCdEventTypeDesc(int idEventCase, String cdEventType, Collection<String> cdEventStatuses) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.capsCase.idCase = :idEventCase "
                                                           + " and e.cdEventType = :cdEventType  " 
                                                           + " and e.cdEventStatus in ( :cdEventStatuses ) "
                                                           + " order by idEvent desc");
    query.setInteger("idEventCase", idEventCase);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdEventStatuses", cdEventStatuses);
    return (List<Event>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  //SMS#42496: Retrieve the events for cdEventTypes and cdEventStatus by idStage
  public List<Event> findEventByIdStageCdEventStatusCdEventTypes(int idStage, Collection<String> cdEventTypes, Collection<String> cdEventStatuses) {
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.stage.idStage = :idStage "
                                                           + " and e.cdEventType in (:cdEventTypes ) " 
                                                           + " and e.cdEventStatus in ( :cdEventStatuses ) "
                                                           + " order by idEvent desc");
    query.setInteger("idStage", idStage);
    query.setParameterList("cdEventTypes", cdEventTypes);
    query.setParameterList("cdEventStatuses", cdEventStatuses);
    return (List<Event>) query.list();
  }
  
  //STGAP00014341: Delete event for idStage and cdTask
  public int deleteEvent(int idStage, String cdTask) {
    Query query = getSession().createQuery(
                                           " delete Event e " + 
                                           " where e.stage.idStage = :idStage " + 
                                           " and e.cdEventType = :cdEventType " +
                                           " and e.cdTask = :cdTask ");
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_APP);
    return query.executeUpdate();

  }
  
  //STGAP00014341: Delete event for idStage and txtEventDescr
  public int deleteEventByStageDesc(int idStage, String txtEventDescr, String cdEventType) {
    Query query = getSession().createQuery(
                                           " delete Event e " + 
                                           " where e.stage.idStage = :idStage " + 
                                           " and e.cdEventType = :cdEventType " +
                                           " and e.txtEventDescr = :txtEventDescr ");
    query.setInteger("idStage", idStage);
    query.setString("txtEventDescr", txtEventDescr);
    query.setString("cdEventType", cdEventType);
    return query.executeUpdate();

  }
  
  //STGAP00014341: Delete event for idStage and cdTask and cdEventType
  public int updateEventByStageTaskType(int idStage, String cdTask, String cdEventType) {
    Query query = getSession().createQuery(
                                           " update Event e " + 
                                           " set e.cdEventStatus = :cdEventStatus "+
                                           " where e.stage.idStage = :idStage " + 
                                           " and e.cdEventType = :cdEventType " +
                                           " and e.cdTask = :cdTask ");
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_COMP);
    return query.executeUpdate();

  }
  
  //STGAP00014341: find the latest event for idStage and cdTask and cdEventType
  public Event findEventByIdStageAndEventTypeAndTaskIdEventDesc(int idEventStage, String cdEventType, String cdTask) {
    Query query = getSession().createQuery(
                                           " from Event e " + "where e.stage.idStage = :idEventStage "
                                                           + "  and e.cdEventType = :cdEventType "
                                                           + "  and e.cdTask = :cdTask "
                                                           + " order by e.idEvent desc");
    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdTask", cdTask);
    return (Event) firstResult(query);
  }
  
  //SMS#37215 Added to find Earliest Event of given type and in given status for a given stage.
  public Event findEarliestEventByStageTypeAndStatus(int idEventStage, String cdEventType, String cdEventStatus) {
    Query query = getSession().createQuery(
                                          " from Event e " + "   where e.stage.idStage = :idEventStage "
                                                           + "   and e.cdEventType = :cdEventType "
                                                           + "   and e.cdEventStatus = :cdEventStatus "
                                                           + "   order by e.dtEventOccurred asc");

    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    return (Event) firstResult(query);

  }
  
  public long countEventRowsByIdStageAndCdEventTypeAndCdEventStatuses(int idEventStage, String cdEventType,
                                                                      Collection<String> cdEventStatuses) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "from Event e "
                                                           + " where e.stage.idStage = :idEventStage "
                                                           + " and e.cdEventType = :cdEventType "
                                                           + " and e.cdEventStatus in ( :cdEventStatuses )");

    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdEventStatuses", cdEventStatuses);
    return (Long) query.uniqueResult();
  }

  // SMS#46744 Added method updateEventByIdStageAndCdEventType
  @SuppressWarnings( { "unchecked" })
  public int updateEventByIdStageAndCdEventType(int idCase, int idStage, String cdEventType) {
    Query query = getSession().createQuery(
                                           "update Event e " + "   set e.capsCase.idCase = :idCase "
                                                           + "   where e.stage.idStage = :idStage "
                                                           + "   and e.cdEventType = :cdEventType "
                                                           + "   and e.capsCase.idCase is null ");
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    return query.executeUpdate();
  }
  
  @SuppressWarnings( { "unchecked" })    

  public List<Event> findEventByIdCaseAndCdEventStatus(int idCase, Collection<String> cdEventStatus) { 
    Query query = getSession().createQuery(
                                           "    from Event e " + "   where e.capsCase.idCase = :idCase "
                                                               + " and e.cdEventStatus in ( :cdEventStatus ) "                                                             
                                                               + " order by idEvent desc");
    query.setInteger("idCase", idCase);
    query.setParameterList("cdEventStatus", cdEventStatus);
    return (List<Event>) query.list();
  }
 
  //SMS#54782
  @SuppressWarnings( { "unchecked" })
  public List<Event> findAprvChildDeathReportByIdPersonIdStage(int idPerson, int idEventStage , Collection<String> cdEventStatus) { 
    Query query = getSession().createQuery(
                                           "    from Event e , ChldDthNrFltySeriInj cd " 
                                                               + " where e.idEvent = cd.event.idEvent " 
                                                               + " and cd.idChild = :idPerson"
                                                               + " and e.stage.idStage = :idEventStage "
                                                               + " and e.cdEventStatus in ( :cdEventStatus ) "  
                                                               + " and cd.reportType = :cdReportType " );
                                                               
    query.setInteger("idPerson", idPerson);           
    query.setInteger("idEventStage", idEventStage);
    query.setParameterList("cdEventStatus", cdEventStatus);
    query.setString("cdReportType", CodesTables.CDREPTYP_DTH);
    return (List<Event>) query.list();
  }
  
}
