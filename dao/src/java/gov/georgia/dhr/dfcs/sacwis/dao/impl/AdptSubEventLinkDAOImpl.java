package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.AdptSubEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Event;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

public class AdptSubEventLinkDAOImpl extends BaseDAOImpl implements AdptSubEventLinkDAO {
  public Map findAdptSubEventLink(int idEvent) {

    Query query = getSession().createQuery("select new Map (a.idAdptSub as idAdptSub, " +
                                           "                a.dtLastUpdate as dtLastUpdate, " +
                                           "                a.dtAdptSubAgreeRetn as dtAdptSubAgreeRetn, " +
                                           "                a.dtAdptSubAgreeSent as dtAdptSubAgreeSent, " +
                                           "                a.dtAdptSubAppReturned as dtAdptSubAppReturned, " +
                                           "                a.dtAdptSubLastInvc as dtAdptSubLastInvc, " +
                                           "                a.dtAdptSubEnd as dtAdptSubEnd, " +
                                           "                a.dtAdptSubEffective as dtAdptSubEffective, " +
                                           "                a.dtAdptSubApprvd as dtAdptSubApprvd, " +
                                           "                a.dtAdptSubAppSent as dtAdptSubAppSent, " +
                                           "                a.capsResource.idResource as idResource, " +
                                           "                a.person.idPerson as idPerson, " +
                                           "                a.placement.idPlcmtEvent as idPlcmtEvent, " +
                                           "                a.amtAdptSub as amtAdptSub, " +
                                           "                a.cdAdptSubCloseRsn as cdAdptSubCloseRsn, " +
                                           "                a.cdAdptSubDeterm as cdAdptSubDeterm, " +
                                           "                a.indAdptSubThirdParty as indAdptSubThirdParty, " +
                                           "                a.indAdptSubProcess as indAdptSubProcess, " +
                                           "                a.txtAdptSubRsn as txtAdptSubRsn," +
                                           "                a.indSauConf as indSauConf," +
                                           "                a.indSpclAsstApprvl as indSpclAsstApprvl," +
                                           "                a.amtSpclAsstReq as amtSpclAsstReq," +
                                           "                a.cdSpclAsstType as cdSpclAsstType," +
                                           "                a.txtSpclAsstSpecify as txtSpclAsstSpecify," +
                                           "                a.txtSpclAsstCmnts as txtSpclAsstCmnts," +
                                           "                a.dtRenwlEffBegin as dtRenwlEffBegin," +
                                           "                a.dtRenwlEffEnd as dtRenwlEffEnd, " +
                                           "                a.dtAdptSubTerminated as dtAdptSubTerminated, " +
                                           "                a.indSchoolVer as indSchoolVer, " +
                                           "                a.cdPaymentMthd as cdPaymentMthd," +
                                           "                a.indNonIncSSA as indNonIncSSA," +
                                           "                c.cdEventStatus as cdEventStatus," +
                                           "                a.specialNeedsDetermination.idEvent as idSpecialNeedsDetermination) " +
                                           " from AdoptionSubsidy a, AdptSubEventLink b, Event c " +
                                           " where b.event.idEvent = :idEvent " +
                                           " and c.idEvent = :idEvent " +
                                           " and b.adoptionSubsidy.idAdptSub = a.idAdptSub");
    query.setInteger("idEvent", idEvent);
    return (Map) firstResult(query);
  }
  
  public Long findPriorEndedAAAgreementCount(int idStage, int idPerson) {
    Query query = getSession().createQuery("select count(*) from AdoptionSubsidy a, AdptSubEventLink b,Event c " +
                                           " where b.event.idEvent = c.idEvent " +
                                           " and b.adoptionSubsidy.idAdptSub = a.idAdptSub" +
                                           " and c.stage.idStage = :idStage " +
                                           " and a.person.idPerson= :idPerson " +
                                           " and ((a.cdAdptSubCloseRsn is not null) " +
                                           " or (a.dtAdptSubTerminated is not null and a.dtAdptSubTerminated < sysdate) " +
                                           " or (a.dtAdptSubEnd is not null and a.dtAdptSubEnd < sysdate)) ");
    
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (Long)firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findCompletedAdoptionSubsidiesByIdCaseIdStageIdPerson(int idCase, int idStage, int idPerson) {
    Query query = getSession().createQuery("select a.idAdptSub from AdoptionSubsidy a, AdptSubEventLink b, Event c " +
                                           " where b.event.idEvent = c.idEvent " +
                                           " and c.stage.idStage = :idStage " +
                                           " and b.adoptionSubsidy.idAdptSub = a.idAdptSub " +
                                           " and b.capsCase.idCase = :idCase " +
                                           " and a.person.idPerson = :idPerson " +
                                           " and c.cdEventStatus = '" + CodesTables.CEVTSTAT_COMP + "'" +
                                           " and (a.dtRenwlEffEnd is null or a.dtRenwlEffEnd > sysdate)" +
                                           " order by c.idEvent desc "
                                           );
    
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (List<Integer>)query.list();
  }

  public int insertAdptSubEventLink(int idEvent, int idAdptSub) {
    Session session = getSession();
    AdptSubEventLink adptSubEventLink = new AdptSubEventLink((Event) session.load(Event.class, idEvent),
                                                          (AdoptionSubsidy) session.load(AdoptionSubsidy.class, idAdptSub));
    session.saveOrUpdate(adptSubEventLink);
    return 1;
  }
  
  //STGAP00010749: Gets the event Id for the given AdoptionSubsidy record
  public Integer findIdEventByIdAdoSub(int idAdoSub){
    Query query = getSession().createQuery( " select a.event.idEvent " +
                                            " from AdptSubEventLink a " +
                                            " where a.adoptionSubsidy = :idAdoSub ");
    query.setInteger("idAdoSub", idAdoSub);
    return (Integer)firstResult(query);
  }
  
  //STGAP00010749: Inserts or updatse an AdptSubEventLink record 
  public void saveAdptSubEventLink(AdptSubEventLink adptSubEventLink) {
    getSession().saveOrUpdate(adptSubEventLink);
  }
}
