package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import org.hibernate.Query;
import org.hibernate.Session;

/*Change History:
     Date         User                  Description
     --------     -------------------   --------------------------------------
     03/04/2010   mxpatel               SMS #46736: Added new method findIPersonByIdEpl
     04/19/2010   arege                 SMS#46744 Added method updateEventPersonLinkWithIdCase
*/
public class EventPersonLinkDAOImpl extends BaseDAOImpl implements EventPersonLinkDAO {
  public long countByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from PersonMergeView v, "
                                                           + "       EventPersonLink a " + "  join a.event "
                                                           + " where v.id.idPersonInput = :idPerson "
                                                           + "   and a.person.idPerson = v.id.idPersonOutput");
    query.setInteger("idPerson", idPerson);
    return (Long) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<EventPersonLink> findEventPersonLinkAndPersonByIdEvent(int idEvent) {
    Query query = getSession().createQuery("  from EventPersonLink a " + " where a.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (List<EventPersonLink>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<String> findNmPersonFullByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           "select epl.person.nmPersonFull " + "  from EventPersonLink epl"
                                                           + " where epl.event = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (List<String>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonsByIdEvent(int idEvent) {
    Query query = getSession()
                              .createQuery(
                                           " select new map (d.nmNameFirst as NM_FIRST, "
                                                           + " d.nmNameLast as NM_LAST, "
                                                           + " d.nmNameMiddle as NM_MIDDLE, "
                                                           + " d.cdNameSuffix as CD_NAME_SUFFIX, "
                                                           + " a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " epl.indCaregiver as IND_CAREGIVER, "
                                                           + " epl.dtLastUpdate as DT_LAST_UPDATE) "
                                                           + " from EventPersonLink epl "
                                                           + "     join epl.person a "
                                                           + "left join a.names d "
                                                           + "            where epl.event.idEvent = :idEvent "
                                                           + "            and (d.dtNameEndDate = :maxDate " +
                                                           "                   or d.dtNameEndDate is null ) "
                                                           + "            and (d.indNamePrimary = 'Y' or d.indNamePrimary is null) "
                                                           + "            and (d.indNameInvalid = 'N' or d.indNameInvalid is null ) "
                                                           + "       order by d.nmNameLast, "
                                                           + "                d.nmNameFirst, "
                                                           + "                d.nmNameMiddle");
    query.setInteger("idEvent", idEvent);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  public long countEventPersonLinksNonZeroIdEventByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select count(idEventPersLink) " + "  from EventPersonLink "
                                                           + " where person.idPerson = :idPerson "
                                                           + "   and event.idEvent > 0");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public long countEventPersonLinksByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from EventPersonLink "
                                                           + " where person.idPerson = :idPerson");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public long countByIdPersonIdNewPerson(int idPerson, int idNewPerson) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from EventPersonLink ep1, "
                                                           + "       EventPersonLink ep2, " + "       Event e, "
                                                           + "       Stage s "
                                                           + " where ep1.person.idPerson = :idPerson "
                                                           + "   and ep2.person.idPerson = :idNewPerson "
                                                           + "   and ep1.event.idEvent = ep2.event.idEvent "
                                                           + "   and ep1.event.idEvent = e.idEvent "
                                                           + "   and e.stage.idStage = s.idStage "
                                                           + "   and ( s.dtStageClose is null "
                                                           + "          or s.dtStageClose = :maxDate ) ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idNewPerson", idNewPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findEventTypeEventStatusEventStageByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select new Map (b.cdEventType as cdEventType, "
                                                           + "                b.cdEventStatus as cdEventStatus, "
                                                           + "                b.stage.idStage as idEventStage) "
                                                           + "  from EventPersonLink a " + "  join a.event b, "
                                                           + "       PersonMergeView c "
                                                           + " where c.id.idPersonInput = :idPerson "
                                                           + "   and a.person.idPerson = c.id.idPersonOutput");
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }

  public EventPersonLink findEventPersonLinkByIdEventAndIdPerson(int idEvent, int idPerson) {
    Query query = getSession().createQuery(
                                           "  from EventPersonLink epl " + " where epl.event.idEvent = :idEvent "
                                                           + "   and epl.person.idPerson = :idPerson");
    query.setInteger("idEvent", idEvent);
    query.setInteger("idPerson", idPerson);
    return (EventPersonLink) query.uniqueResult();
  }

  public int insertEventPersonLink(int idEvent, int idPerson) {
    Session session = getSession();
    EventPersonLink eventPersonLink = new EventPersonLink((Event) session.load(Event.class, idEvent),
                                                          (Person) session.load(Person.class, idPerson));
    session.saveOrUpdate(eventPersonLink);
    return 1;
  }

  public int updateEventPersonLink(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    Query query = getSession().createQuery(
                                           "update EventPersonLink " + "   set person.idPerson = :idPersMergeForward "
                                                           + " where person.idPerson =  :idPersMergeClosed "
                                                           + "   and event.idEvent = :idEvent ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int updateCareGiverStatus(String indCareGiver, int idPerson, int idEvent) {
    Query query = getSession().createQuery(
                                           "update EventPersonLink epl " + "   set epl.indCaregiver = :indCareGiver "
                                                           + " where person.idPerson =  :idPerson "
                                                           + "   and event.idEvent = :idEvent ");
    query.setString("indCareGiver", indCareGiver);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int deleteEventPersonLink(int idEvent, int idPerson, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "delete from EventPersonLink " + "      where event.idEvent = :idEvent "
                                                           + "        and person.idPerson = :idPerson "
                                                           + "        and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idEvent", idEvent);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int deleteEventPersonLinkByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" delete from EventPersonLink " + "       where event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int deleteEventPersonLink(int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "delete from EventPersonLink epl "
                                                           + "      where epl.event.idEvent in (select idEvent "
                                                           + "                                    from Event e"
                                                           + "                                   where e.stage.idStage = :idStage "
                                                           + "                                     and e.cdEventType in ('ASG', 'CON')) ");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonsForClientOutboundByIdEvent(int idEvent) {
    Query query = getSession()
                              .createQuery(
                                           " select new map (d.nmNameFirst as NM_FIRST, "
                                                           + " d.nmNameLast as NM_LAST, "
                                                           + " d.nmNameMiddle as NM_MIDDLE, "
                                                           + " a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " a.cdPersonSex as CD_PERSON_SEX, "
                                                           + " a.dtPersonBirth as DT_PERSON_BIRTH, "
                                                           + " a.cdSmileClient as CD_SMILE_CLIENT, "
                                                           + " epl.dtLastUpdate as DT_LAST_UPDATE) "
                                                           + " from EventPersonLink epl "
                                                           + "     join epl.person a "
                                                           + "left join a.names d "
                                                           + "            where epl.event.idEvent = :idEvent "
                                                           + "            and (d.dtNameEndDate = :maxDate or d.dtNameEndDate is null) "
                                                           + "            and (d.indNamePrimary = 'Y' or d.indNamePrimary is null) "
                                                           + "            and (d.indNameInvalid = 'N' or d.indNameInvalid is null) "
                                                           + "       order by d.nmNameLast, "
                                                           + "                d.nmNameFirst, "
                                                           + "                d.nmNameMiddle");
    query.setInteger("idEvent", idEvent);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonsForClientOutboundByIdEventForAdoAgreement(int idEvent) {
    Query query = getSession()
                              .createQuery(
                                           " select new map (d.nmNameFirst as NM_FIRST, "
                                                           + " d.nmNameLast as NM_LAST, "
                                                           + " d.nmNameMiddle as NM_MIDDLE, "
                                                           + " a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " a.cdPersonSex as CD_PERSON_SEX, "
                                                           + " a.dtPersonBirth as DT_PERSON_BIRTH, "
                                                           + " a.cdSmileClient as CD_SMILE_CLIENT, "
                                                           + " ads.dtLastUpdate as DT_LAST_UPDATE) "
                                                           + " from AdoptionSubsidy ads, AdptSubEventLink adsl "
                                                           + "     join ads.person a "
                                                           + " left join a.names d "
                                                           + "            where adsl.event.idEvent = :idEvent "
                                                           + "            and adsl.adoptionSubsidy.idAdptSub = ads.idAdptSub "         
                                                           + "            and (d.dtNameEndDate = :maxDate or d.dtNameEndDate is null) "
                                                           + "            and (d.indNamePrimary = 'Y' or d.indNamePrimary is null) "
                                                           + "            and (d.indNameInvalid = 'N' or d.indNameInvalid is null) "
                                                           + "       order by d.nmNameLast, "
                                                           + "                d.nmNameFirst, "
                                                           + "                d.nmNameMiddle");
    query.setInteger("idEvent", idEvent);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }
  @SuppressWarnings( { "unchecked" })
  public List<Map> findEventPersonLinkByIdStageByIdPersonByCdEventType(int idStage, int idPerson,
                                                                             String cdEventType) {
    Query query = getSession().createQuery(" select new map (epl.event.idEvent as ID_EVENT) " +
                                           " from EventPersonLink epl, OutputLaunchEventLink oel" + 
                                           " where epl.event.idEvent = oel.idEvent " +
                                           " and epl.event.cdEventType = :cdEventType " + 
                                           " and epl.event.stage.idStage = :idStage " + 
                                           " and epl.person.idPerson = :idPerson " +
                                           " and oel.indCurrent = 'Y' " +
                                           " and epl.event.cdEventStatus in ('COMP', 'APRV') "+
                                           " order by epl.event.dtLastUpdate desc ");

    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    return (List<Map>) query.list();
  }
  
  public void saveEventPersonLink(EventPersonLink eventPersonLink) {
    getSession().saveOrUpdate(eventPersonLink);
  }
  
  //STGAP00010006: Gets the event Id of the most recent approved Case Plan for the given case Id
  public Integer findIdEventByIdCaseByEventTypeByEventStatus(int idCase, String cdTask, int idChild) {
    Query query = getSession()
                              .createQuery(
                                           " select epl.event.idEvent "
                                                           + " from EventPersonLink epl "
                                                           + "   where epl.capsCase.idCase = :idCase "
                                                           + "   and epl.person.idPerson = :idChild "
                                                           + "   and epl.event.cdEventType = :cdEventType "
                                                           + "   and epl.event.cdTask = :cdTask "
                                                           + "   and epl.event.cdEventStatus = :cdEventStatus "
                                                           + "   order by epl.event.idEvent desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idChild", idChild);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_PLN);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (Integer) firstResult(query);
  }
  
  public Integer findIPersonByIdEpl(int idEvent) {
    Query query = getSession().createQuery(
                                           " select epl.person.idPerson " + " from EventPersonLink epl "
                                                           + " where epl.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (Integer) firstResult(query);
  }
  
  //STGAP000
  @SuppressWarnings( { "unchecked" })
  public long countEventPersonLinkByIdPersonIdCaseForExchangeChild(int idPerson, int idCase){
    //cdEventType 'EXC' and cdTask 9530 belongs to Exchange Child
    Query query = getSession().createQuery(
                                            "select count(*) "
                                            + " from EventPersonLink epl, Event e "
                                            + " where epl.event.idEvent = e.idEvent "
                                            + " and e.cdEventType = 'EXC' "
                                            + " and e.cdTask = 9530 "
                                            + " and epl.person.idPerson = :idPerson "  
                                            + " and epl.capsCase.idCase = :idCase ");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings( { "unchecked" })
  public long countEventPersonLinkByIdPersonIdForCPSInvestChildReferral(int idPerson){
    //cdEventType 'CFR' and cdEventStatus as 'COMP'
    Query query = getSession().createQuery(" select count(*) "
                                            + " from EventPersonLink epl, Event e "
                                            + " where epl.event.idEvent = e.idEvent "
                                            + " and e.cdEventType = 'CFR' " 
                                            + " and e.cdEventStatus = 'COMP' "
                                            + " and epl.person.idPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings( { "unchecked" })
  public long countEventPersonLinkByIdPersonIdForAllegationOfCDNFSI(int idPerson){
    //cdEventType 'CNS'
    Query query = getSession().createQuery(" select count(*) "
                                            + " from EventPersonLink epl, Event e "
                                            + " where epl.event.idEvent = e.idEvent "
                                            + " and e.cdEventType = 'CNS' " 
                                            + " and epl.person.idPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  @SuppressWarnings( { "unchecked" })
  public long countEventPersonLinkByIdPersonIdForAllegationOfCDNFSIApproved(int idPerson){
    //cdEventType 'CNS' and cdEventStatus as 'APRV'
    Query query = getSession().createQuery(" select count(*) "
                                            + " from EventPersonLink epl, Event e "
                                            + " where epl.event.idEvent = e.idEvent "
                                            + " and e.cdEventType = 'CNS' " 
                                            + " and e.cdEventStatus = 'APRV' "
                                            + " and epl.person.idPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }  
  
  // SMS#46744
  @SuppressWarnings( { "unchecked" })
  public int updateEventPersonLinkWithIdCase(int idCase, int idEventStage, String cdEventType) {
    Query query = getSession()
                              .createQuery(
                                           "update  EventPersonLink epl "
                                                           + " set  epl.capsCase.idCase = :idCase "
                                                           + " where epl.event.idEvent in ( "
                                                           + "                     select e.idEvent from Event e "
                                                           + "                     where e.stage.idStage = :idEventStage "
                                                           + "                     and e.cdEventType = :cdEventType "
                                                           + "                     and e.capsCase.idCase is null  ) ");
    query.setInteger("idCase", idCase);
    query.setInteger("idEventStage", idEventStage);
    query.setString("cdEventType", cdEventType);
    return query.executeUpdate();
  }
}
