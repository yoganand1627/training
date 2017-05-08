package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.CacheMode;
import org.hibernate.Session;

public class FceApplicationDAOImpl extends BaseDAOImpl implements FceApplicationDAO {
  public int updateFceApplicationIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage) {
    Query query = getSession().createQuery("update FceApplication " +
                                           "   set personByIdPerson.idPerson = :idPersMergeForward " +
                                           " where personByIdPerson.idPerson = :idPersMergeClosed " +
                                           "   and stage.idStage = :idStage");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public FceApplication findFceApplicationByIdApplicationEvent(long idApplicationEvent) {
    Query query = getSession().createQuery(" from FceApplication fca " +
                                           "where fca.event.idEvent = :idApplicationEvent");

    query.setLong("idApplicationEvent", idApplicationEvent);
    return (FceApplication) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findPlacementByIdStageAndIdEvent(int idStage, String cdTask) {
    Query query = getSession().createQuery("  select new map(e.cdTask as cdTask, " +
                                           "                 e.cdEventStatus as cdEventStatus, " +
                                           "                 e.dtEventOccurred as dtEventOccurred, " +
                                           "                 e.txtEventDescr as txtEventDescr, " +
                                           "                 p.nmPersonFull as nmPersonFull) " +
                                           "    from Event e, " +
                                           "         Person p " +
                                           "   where e.cdTask = :cdTask " +
                                           "     and e.stage.idStage = :idStage " +
                                           "     and e.person = p.idPerson " +
                                           "order by e.dtEventOccurred desc ");
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    return (List<Map>) query.list();
  }

  public FceApplication findFceApplicationByEventList(Collection<Integer> eventList) {
    Query query = getSession().createQuery(" from FceApplication fca " +
                                           " where fca.event.idEvent in (:eventList) " +
                                           "    and fca.cdApplication in ('A','R') " +
                                           "    and fca.dtApplicationComplete is not null " +
                                           "order by fca.dtApplicationComplete desc, fca.dtLastUpdate desc ");
    query.setParameterList("eventList", eventList);
    return (FceApplication) firstResult(query);
  }
  
  
  public FceApplication findLatestCompleteFceApplication(long idStage) {
    Query query = getSession().createQuery(" from FceApplication fca " +
                                           " where fca.stage.idStage = :idStage" +
                                           "    and fca.dtApplicationComplete is not null " +
                                           "order by fca.dtApplicationComplete desc ");
    query.setLong("idStage", idStage);
    return (FceApplication) firstResult(query);
  }

  public FceApplication findFceApplicationByIdFceApplication(long idFceApplication) {
    Query query = getSession().createQuery("      from FceApplication fca " +
                                           "join fetch fca.stage " +
                                           "join fetch fca.fceEligibility " +
                                           "join fetch fca.personByIdLastUpdatePerson " +
                                           "     where fca.idFceApplication = :idFceApplication");

    query.setLong("idFceApplication", idFceApplication);
    //query.setCacheMode(CacheMode.REFRESH);
    return (FceApplication) query.uniqueResult();
  }

  public void updateFceApplicationByIndEvalConclusion(long idFceApplication, String indEvaluationConclusion) {

    Query query = getSession().createQuery(" update FceApplication " +
                                           "    set indEvaluationConclusion = :indEvaluationConclusion" +
                                           "  where idFceApplication = :idFceApplication");

    query.setString("indEvaluationConclusion", indEvaluationConclusion);
    query.setLong("idFceApplication", idFceApplication);
    query.executeUpdate();

  }
  
  public int updateFceApplicationCdApplication(long idFceApplication,String cdApplication){
    Query query = getSession().createQuery(" update FceApplication " +
                                           "    set cdApplication = :cdApplication" +
                                           "  where idFceApplication = :idFceApplication");

    query.setString("cdApplication", cdApplication);
    query.setLong("idFceApplication", idFceApplication);
    return (Integer) query.executeUpdate();
  }
  
  public int updateFceAppliationByNbrLivingAtHome(long idFceApplication,long nbrLivingAtHome){
    Query query = getSession().createQuery(" update FceApplication " +
                                           "    set nbrLivingAtHome = :nbrLivingAtHome" +
                                           "  where idFceApplication = :idFceApplication");

    query.setLong("nbrLivingAtHome", nbrLivingAtHome);
    query.setLong("idFceApplication", idFceApplication);
    return (Integer) query.executeUpdate();
  }

  public void updateFceApplicationRemovalAddress(long idFceApplication, String addrRemovalStLn1, String addrRemovalStLn2,
                                          String addrRemovalCity, String cdRemovalAddrState, String addrRemovalAddrZip, String cdRemovalAddrCounty) {
    Query query = getSession().createQuery(" update FceApplication " +
                                           "    set addrRemovalStLn1 = :addrRemovalStLn1," +
                                           "    addrRemovalStLn2 = :addrRemovalStLn2," +
                                           "    addrRemovalCity = :addrRemovalCity," +
                                           "    cdRemovalAddrState = :cdRemovalAddrState," +
                                           "    addrRemovalAddrZip = :addrRemovalAddrZip," +
                                           "    cdRemovalAddrCounty = :cdRemovalAddrCounty" +
                                           "  where idFceApplication = :idFceApplication");

    query.setString("addrRemovalStLn1", addrRemovalStLn1);
    query.setString("addrRemovalStLn2", addrRemovalStLn2);
    query.setString("addrRemovalCity", addrRemovalCity);
    query.setString("cdRemovalAddrState", cdRemovalAddrState);
    query.setString("addrRemovalAddrZip", addrRemovalAddrZip);
    query.setString("cdRemovalAddrCounty", cdRemovalAddrCounty);
    query.setLong("idFceApplication", idFceApplication);
    query.executeUpdate();
    //getSession().flush();
  }
  
  
  public void saveFceApplication(FceApplication fceApplication) {
    getSession().saveOrUpdate(fceApplication);
  }

  public FceApplication findLatestFceApplicationInitialAmendedByEventList(Collection<Integer> eventList) {
    Query query = getSession().createQuery(" from FceApplication fca " +
                                           " where fca.event.idEvent in (:eventList) " +
                                           "    and fca.cdApplication = 'A' " +
                                           "    and fca.dtApplicationComplete is not null " +
                                           "order by fca.dtApplicationComplete desc, fca.dtLastUpdate desc ");
    query.setParameterList("eventList", eventList);
    return (FceApplication) firstResult(query);
  }
}
