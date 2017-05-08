package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*Change History:
  *   Date         User                  Description
  *   --------     -------------------   --------------------------------------
  *   09/24/2009   mxpatel               STGAP00014707: modified findEligibilityLatestApprovedCountByIdStageByIdPerson method
  *                                      to make sure eligibility is not end dated.
  *   10/01/2009   mxpatel               STGAP00015486: modified findMostRecentApprovedEligibilityinFCC to only include open FCC stages and eligibility
  *                                      is not end dated.
  *   12/04/2011   hnguyen               SMS#89483: Update findEligibilityByIdPersonAndDtCurrent to order by end date
  *                                      
  *   
*/
public class EligibilityDAOImpl extends BaseDAOImpl implements EligibilityDAO {
  
  @SuppressWarnings({"unchecked"})
  public Eligibility findEligibilityCurrentApprovedByIdPerson(int idPerson){
    Query query = getSession().createQuery(" from Eligibility e "
                                           + "where e.personByIdPerson.idPerson = :idPerson and "
                                           + "e.dtEligStart <= sysdate and "
                                           + "e.dtEligEnd >= sysdate and "
                                           + "e.event.cdEventStatus = 'APRV'");
    query.setInteger("idPerson", idPerson);
    return (Eligibility) firstResult(query);
  }
  
  /*
   * This method is used for updating the CSUP_PARENT_OUTBOUND table
   */
  public String findDistinctChildCOAByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select e.cdEligMedEligGroup from Eligibility e " 
                                           + "where e.personByIdPerson.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);  
  }
  
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  @SuppressWarnings({"unchecked"})
  public Eligibility findDistinctEligibilityByIdPersonAndIndCsupSend(int idPerson) {
    Query query = getSession().createQuery(" from Eligibility e " 
                                           + "where e.personByIdPerson.idPerson = :idPerson " 
                                           + "and e.indEligCsupSend = 'Y'");
    query.setInteger("idPerson", idPerson);
    return (Eligibility) firstResult(query);  
  }
  
  public Eligibility findEligibilityByIdEligEvent(int idEligEvent) {
    Query query = getSession().createQuery(" from Eligibility e " +
                                           "where e.event.idEvent = :idEligEvent");
    query.setInteger("idEligEvent", idEligEvent);
    return (Eligibility) query.uniqueResult();
  }
  
  public Eligibility findEligibilityByIdPersonAndDtCurrent(int idPerson, Date dtCurrentDate) {
    Query query = getSession().createQuery(" from Eligibility e " +
                                           "where e.personByIdPerson.idPerson = :idPerson " +
                                           "  and e.dtEligEnd >= :dtCurrentDate " +
                                           "order by e.dtEligEnd desc ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtCurrentDate", dtCurrentDate);
    return (Eligibility) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdEligEventByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select e.idEligEvent " +
                                           "  from Eligibility e " +
                                           " where e.personByIdPerson.idPerson = :idPerson");

    query.setInteger("idPerson", idPerson);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public Long countEligEventByIdPersonIdCaseAndExcludedEvent(int idPerson, int idCase, int idExcludedEvent) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from Eligibility e " +
                                           "  where e.capsCase.idCase = :idCase" +
                                           "  and e.personByIdPerson.idPerson = :idPerson" +
                                           "  and e.event.cdEventStatus = 'APRV' " +
                                           "  and e.idEligEvent <> :idExcludedEvent ");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setInteger("idExcludedEvent", idExcludedEvent);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdEligEventOnLeft(int idPerson, Date dtEligEnd, Date dtEligStart) {
    Query query = getSession().createQuery("select e.idEligEvent " +
                                           "  from Eligibility e " +
                                           " where e.personByIdPerson.idPerson = :idPerson " +
                                           "   and trunc(e.dtEligEnd) > trunc(:dtEligStart) " +
                                           "   and trunc(e.dtEligEnd) < trunc(:dtEligEnd) " +
                                           "   and trunc(e.dtEligStart) <> trunc(e.dtEligEnd) ");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtEligEnd", dtEligEnd);
    query.setTimestamp("dtEligStart", dtEligStart);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdEligEventOnRight(int idPerson, Date dtEligEnd, Date dtEligStart) {
    Query query = getSession().createQuery("select e.idEligEvent " +
                                           "  from Eligibility e " +
                                           " where e.personByIdPerson.idPerson = :idPerson " +
                                           "   and trunc(e.dtEligStart) > trunc(:dtEligStart) " +
                                           "   and trunc(e.dtEligStart) < trunc(:dtEligEnd) " +
                                           "   and trunc(e.dtEligStart) <> trunc(e.dtEligEnd) ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtEligEnd", dtEligEnd);
    query.setTimestamp("dtEligStart", dtEligStart);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdEligEventCheckIdentical(int idPerson, Date dtEligEnd, Date dtEligStart) {
    Query query = getSession().createQuery(" select e.idEligEvent" +
                                           "   from Eligibility e" +
                                           "  where e.personByIdPerson.idPerson = :idPerson " +
                                           "    and trunc(e.dtEligStart) <= trunc(:dtEligStart) " +
                                           "    and trunc(e.dtEligEnd) >= trunc(:dtEligEnd) " +
                                           "    and trunc(e.dtEligStart) <> trunc(e.dtEligEnd) " +
                                           "    and  not (:dtEligStart = :dtEligEnd " +
                                           "              and (trunc(e.dtEligStart) = trunc(:dtEligStart) " +
                                           "                    or trunc(e.dtEligEnd) = trunc(:dtEligEnd))) ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtEligEnd", dtEligEnd);
    query.setTimestamp("dtEligStart", dtEligStart);

    return (List<Integer>) query.list();
  }

  public Object[] findIdEligEventDtEligEndOnLeft(Date dtEligStart, int idPerson) {
    SQLQuery query = getSession().createSQLQuery(" SELECT ID_ELIG_EVENT, " +
                                                 "       DT_ELIG_END " +
                                                 "  FROM Eligibility " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND (TRUNC(:dtEligStart) - TRUNC(DT_ELIG_END)) >= 1.0 " +
                                                 "   AND DT_ELIG_END  = " +
                                                 "       (SELECT MAX(DT_ELIG_END) " +
                                                 "          FROM Eligibility " +
                                                 "         WHERE ID_PERSON = :idPerson " +
                                                 "           AND TRUNC(DT_ELIG_END) <= TRUNC(:dtEligStart) " +
                                                 "           AND TRUNC(DT_ELIG_START) <> TRUNC(DT_ELIG_END))");
    query.setTimestamp("dtEligStart", dtEligStart);
    query.setInteger("idPerson", idPerson);
    query.addScalar("ID_ELIG_EVENT", Hibernate.INTEGER);
    query.addScalar("DT_ELIG_END", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Object[] findIdEligEventDtEligStartOnRight(Date dtEligEnd, int idPerson) {

    SQLQuery query = getSession().createSQLQuery(" SELECT ID_ELIG_EVENT, " +
                                                 "       DT_ELIG_START " +
                                                 "  FROM Eligibility " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND (TRUNC(DT_ELIG_START) - TRUNC(:dtEligEnd)) >= 1.0 " +
                                                 "   AND DT_ELIG_START  = " +
                                                 "       (SELECT MIN(DT_ELIG_START) " +
                                                 "          FROM Eligibility " +
                                                 "         WHERE ID_PERSON = :idPerson " +
                                                 "           AND TRUNC(DT_ELIG_START) >= TRUNC(:dtEligEnd) " +
                                                 "           AND TRUNC(DT_ELIG_START) <> TRUNC(DT_ELIG_END))");
    query.setTimestamp("dtEligEnd", dtEligEnd);
    query.setInteger("idPerson", idPerson);
    query.addScalar("ID_ELIG_EVENT", Hibernate.INTEGER);
    query.addScalar("DT_ELIG_END", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Map findPrevEligOrdered(int idEligEvent, int idPerson) {
    Query query = getSession().createQuery("  select new map(e.cdEligCsupQuest1 as cdEligCsupQuest1, " +
                                           "                 e.cdEligCsupQuest2 as cdEligCsupQuest2, " +
                                           "                 e.cdEligCsupQuest3 as cdEligCsupQuest3, " +
                                           "                 e.cdEligCsupQuest4 as cdEligCsupQuest4, " +
                                           "                 e.cdEligCsupQuest5 as cdEligCsupQuest5, " +
                                           "                 e.cdEligCsupQuest6 as cdEligCsupQuest6, " +
                                           "                 e.cdEligCsupQuest7 as cdEligCsupQuest7) " +
                                           "     from Eligibility e " +
                                           "    where e.personByIdPerson.idPerson = :idPerson " +
                                           "      and e.idEligEvent <> :idEligEvent " +
                                           "      and trunc(e.dtEligStart) <> trunc(e.dtEligEnd) " +
                                           " order by e.dtEligEnd desc ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEligEvent", idEligEvent);
    return (Map) firstResult(query);
  }

  public Object[] findIdEligEventExists(int idEligEvent, Date dtEligStart, Date dtEligEnd, int idPerson,
                                        Date dtLastUpdate) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_ELIG_EVENT, " +
                                                 "       trunc(DT_ELIG_START) AS ELIGIBILITY_DT_ELIG_START, " +
                                                 "       trunc(DT_ELIG_END) AS ELIGIBILITY_DT_ELIG_END, " +
                                                 "       trunc(:dtEligStart) AS PARAM_DT_ELIG_START, " +
                                                 "       trunc(:dtEligEnd) AS PARAM_DT_ELIG_END" +
                                                 "  FROM Eligibility " +
                                                 " WHERE ID_ELIG_EVENT  = :idEligEvent " +
                                                 "       AND DT_LAST_UPDATE = :dtLastUpdate " +
                                                 "       AND ID_PERSON = :idPerson");
    query.setTimestamp("dtEligStart", dtEligStart);
    query.setTimestamp("dtEligEnd", dtEligEnd);
    query.setInteger("idEligEvent", idEligEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idPerson", idPerson);
    query.addScalar("ID_ELIG_EVENT", Hibernate.INTEGER);
    query.addScalar("ELIGIBILITY_DT_ELIG_START", Hibernate.DATE);
    query.addScalar("ELIGIBILITY_DT_ELIG_END", Hibernate.DATE);
    query.addScalar("PARAM_DT_ELIG_START", Hibernate.DATE);
    query.addScalar("PARAM_DT_ELIG_END", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdEventOverlapLeft(int idPerson, int idEligEvent, Date dtCurrPloc, Date dtEligStart) {
    Query query = getSession().createQuery("select e.idEligEvent " +
                                           "   from Eligibility e " +
                                           "  where e.personByIdPerson.idPerson = :idPerson " +
                                           "    and trunc(e.dtEligEnd) <= :dtCurrPloc " +
                                           "    and trunc(e.dtEligEnd) > :dtEligStart " +
                                           "    and e.idEligEvent <> :idEligEvent ");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtCurrPloc", dtCurrPloc);
    query.setTimestamp("dtEligStart", dtEligStart);
    query.setInteger("idEligEvent", idEligEvent);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdEventOverlapRight(int idPerson, int idEligEvent, Date dtCurrPloc, Date dtEligStart) {
    Query query = getSession().createQuery("select e.idEligEvent " +
                                           "   from Eligibility e " +
                                           "  where e.personByIdPerson.idPerson = :idPerson " +
                                           "    and trunc(e.dtEligStart) >= :dtCurrPloc " +
                                           "    and trunc(e.dtEligStart) < :dtEligStart " +
                                           "    and e.idEligEvent <> :idEligEvent ");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtCurrPloc", dtCurrPloc);
    query.setTimestamp("dtEligStart", dtEligStart);
    query.setInteger("idEligEvent", idEligEvent);
    return (List<Integer>) query.list();
  }

  public Object[] findIdEligEventOnLeftOfDtEligStart(Date dtEligStart, int idPerson, Date dtCurrPlocStart) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_ELIG_EVENT, " +
                                                 "       DT_ELIG_END " +
                                                 "  FROM Eligibility " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND (TRUNC(:dtEligStart) - TRUNC(DT_ELIG_END)) >= 1.0 " +
                                                 "   AND DT_ELIG_END = (SELECT MAX(DT_ELIG_END) " +
                                                 "                        FROM Eligibility " +
                                                 "                       WHERE ID_PERSON = :idPerson " +
                                                 "                         AND TRUNC(DT_ELIG_END) <= :dtCurrPlocStart ) ");
    query.setTimestamp("dtEligStart", dtEligStart);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtCurrPlocStart", dtCurrPlocStart);
    query.addScalar("ID_ELIG_EVENT", Hibernate.INTEGER);
    query.addScalar("DT_ELIG_END", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Object[] findIdEligEventOnRightOfDtEligEnd(Date dtEligEnd, int idPerson, Date dtCurrPlocEnd) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_ELIG_EVENT, " +
                                                 "       DT_ELIG_START " +
                                                 "  FROM Eligibility " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND (trunc(DT_ELIG_START) - TRUNC(:dtEligEnd)) >= 1.0 " +
                                                 "   AND DT_ELIG_START = (SELECT min(DT_ELIG_START) " +
                                                 "                          FROM ELIGIBILITY " +
                                                 "                         WHERE ID_PERSON = :idPerson " +
                                                 "                           AND trunc(DT_ELIG_START) >= :dtCurrPlocEnd) ");
    query.setTimestamp("dtEligEnd", dtEligEnd);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtCurrPlocEnd", dtCurrPlocEnd);
    query.addScalar("ID_ELIG_EVENT", Hibernate.INTEGER);
    query.addScalar("DT_ELIG_START", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Eligibility findEligibilityLatestApprovedByIdStageByIdPerson(int idStage, int idPerson){
    Query query = getSession().createQuery(" from Eligibility e " +
                                           " where e.event.stage.idStage = :idStage " +
                                           " and e.personByIdPerson.idPerson = :idPerson " +
                                           " and e.event.cdEventStatus = 'APRV' " +
                                           "    and (e.dtEligStart <= trunc(sysdate) " +
                                           "         and e.dtEligEnd >= trunc(sysdate)) " +
                                           " order by e.dtLastUpdate desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (Eligibility) firstResult(query);
  }
  
  public Eligibility findEligibilityLatestApprovedByIdCaseByIdPerson(int idCase, int idPerson){
    Query query = getSession().createQuery(" from Eligibility e " +
                                           " where e.event.capsCase.idCase = :idCase " +
                                           " and e.personByIdPerson.idPerson = :idPerson " +
                                           " and e.event.cdEventStatus = 'APRV' " +
                                           " order by e.dtEligEnd desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (Eligibility) firstResult(query);
  }
  
  public Long findEligibilityLatestApprovedCountByIdStageByIdPerson(int idStage, int idPerson){
    Query query = getSession().createQuery(" select count(*) from Eligibility e " +
                                           " where e.event.stage.idStage = :idStage " +
                                           " and e.personByIdPerson.idPerson = :idPerson " +
                                           " and e.event.cdEventStatus = 'APRV' " +
                                           " and e.dtEligEnd >= sysdate  " +
                                           " order by e.dtLastUpdate desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  

  public Eligibility findMostRecentApprovedEligibilityinFCC(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           " from Eligibility e "
                                                           + " where e.personByIdPerson.idPerson = :idPerson "
                                                           + " and e.event.stage.cdStage = 'SUB' "
                                                           + " and e.event.cdEventStatus = 'APRV' "
                                                           + " and (e.event.stage.dtStageClose is null or e.event.stage.dtStageClose = ''  or e.event.stage.dtStageClose = :maxDate)"
                                                           + " and e.dtEligEnd >= sysdate "
                                                           + " order by e.dtEligEnd desc ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Eligibility) firstResult(query);
  } 
  
  
  public Eligibility findLatestApprovedEligibilityinFCC(int idPerson) {
    Query query = getSession()
    .createQuery(
                 " from Eligibility e "
                                 + " where e.personByIdPerson.idPerson = :idPerson "
                                 + " and e.event.stage.cdStage = 'SUB' "
                                 + " and e.event.cdEventStatus = 'APRV' "
                                 + " order by e.idEligEvent desc ");
query.setInteger("idPerson", idPerson);
return (Eligibility) firstResult(query);
} 
  
  
  
  public long countEligibility(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from Eligibility e1, " +
                                           "        Eligibility e2 " +
                                           "  where e1.personByIdPerson.idPerson = :idPersMergeForward " +
                                           "    and e2.personByIdPerson.idPerson = :idPersMergeClosed " +
                                           "    and (e1.dtEligEnd >= trunc(sysdate) " +
                                           "         and e2.dtEligEnd >= trunc(sysdate)) ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return (Long) query.uniqueResult();
  }

  public void saveEligibility(Eligibility eligibility) {
    getSession().saveOrUpdate(eligibility);
  }
}
