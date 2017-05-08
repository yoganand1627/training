package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   04/29/2009  bgehlot           STGAP00012833: Added the method findApprovedPrimaryPermanencyPlanGoal()
 *   07/30/2009  hjbaptiste        STGAP00014954: Added method CountApprvPrimPermPlanGoalByCaseAndCdPrimPermPlan()
 *   09/09/09    vdevarak          STGAP00015341: Added method findFCCPFamilyByIdPersonByEventStatusByIdStage to retrieve data for CPRS interface 
 *   06/20/2011  hnguyen           SMS#109631: CAPTA 4.3 Added findLatestApprovedFCCPFamilyByIdPersonForOpenFsuStage(idPerson).
 *   08/01/2011  cwells            STGAP00017068: ECEM 5.0 added method 
 *   11/14/2011  schoi             STGAP00017578: ECEM 5.0 Added method findLatestApprovedFCCPFamilyByIdPerson
 */

public class FCCPFamilyDAOImpl extends BaseDAOImpl implements FCCPFamilyDAO {

  public int saveFccpFamily(FccpFamily fccpFamily) {
    getSession().saveOrUpdate(fccpFamily);
    return fccpFamily.getIdEvent();
  }

  public FccpFamily findFCCPFamilyByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from FccpFamily f " +
                                           "where f.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (FccpFamily) query.uniqueResult();
  }
  
  public FccpFamily findAprvFCCPFamilyByIdCase(int idCase) {
	    Query query = getSession().createQuery(" select f from FccpFamily f, Event e" +
	                                           " where f.capsCase.idCase = :idCase " +
	                                           " and f.event.idEvent = e.idEvent " +
	                                           " and e.cdEventStatus = 'APRV' " +
	    									   " order by f.dtLastUpdate desc ");
	    query.setInteger("idCase", idCase);
	    return (FccpFamily) firstResult(query);
	  }

  public String findPrevPrimaryPermanencyPlanGoal(int idCase, Collection<Integer> principalsForEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT FF.CD_PRIM_PERM_PLAN " +
                                              "  FROM FCCP_FAMILY FF, " +
                                              "       (SELECT ID_EVENT IDEV " +
                                              "          FROM (  SELECT DISTINCT E1.ID_EVENT, E1.DT_LAST_UPDATE " +
                                              "                    FROM EVENT E1, " +
                                              "                         EVENT_PERSON_LINK EPL1 " +
                                              "                   WHERE E1.ID_CASE = :idCase " +
                                              "                     AND E1.ID_EVENT = EPL1.ID_EVENT " +
                                              "                     AND E1.CD_EVENT_TYPE = 'PLN' " +
                                              "                     AND E1.CD_EVENT_STATUS = 'APRV' " +
                                              "                     AND EPL1.ID_PERSON IN (:principalsForEvent) " +
                                              "                ORDER BY E1.DT_LAST_UPDATE DESC) " +
                                              "         WHERE ROWNUM <= 1) " +
                                              " WHERE FF.ID_EVENT = IDEV");
    query.setInteger("idCase", idCase);
    query.setParameterList("principalsForEvent", principalsForEvent);
    return (String) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public Integer CountApprvPrimPermPlanGoalByCaseAndCdPrimPermPlan(int idCase, String cdPrimPermPlan, Collection<Integer> principalsForEvent)  {
    SQLQuery query = getSession().createSQLQuery("SELECT COUNT(FF.ID_EVENT) as count" +
                                              "  FROM FCCP_FAMILY FF, " +
                                              "       (SELECT ID_EVENT IDEV " +
                                              "          FROM (  SELECT DISTINCT E1.ID_EVENT, E1.DT_LAST_UPDATE " +
                                              "                    FROM EVENT E1, " +
                                              "                         EVENT_PERSON_LINK EPL1 " +
                                              "                   WHERE E1.ID_CASE = :idCase " +
                                              "                     AND E1.ID_EVENT = EPL1.ID_EVENT " +
                                              "                     AND E1.CD_EVENT_TYPE = 'PLN' " +
                                              "                     AND E1.CD_EVENT_STATUS = 'APRV' " +
                                              "                     AND EPL1.ID_PERSON IN (:principalsForEvent) " +
                                              "                ORDER BY E1.DT_LAST_UPDATE DESC)) " +
                                              " WHERE FF.ID_EVENT = IDEV" +
                                              " AND FF.CD_PRIM_PERM_PLAN = :cdPrimPermPlan");
    query.setInteger("idCase", idCase);
    query.setString("cdPrimPermPlan", cdPrimPermPlan);
    query.setParameterList("principalsForEvent", principalsForEvent);
    query.addScalar ("count", Hibernate.INTEGER);
    return (Integer) query.uniqueResult();
  }
  
  public Date findDtLastUpdate(int idStage,int idEvent) {
	    SQLQuery query = getSession().createSQLQuery("SELECT DT_LAST_UPDATE " +
	                                                 "  FROM FCCP_DTL_FORM_NARR " +
	                                                 " WHERE ID_STAGE = :idStage" +
                                                         " AND ID_EVENT = :idEvent");
	    query.addScalar("DT_LAST_UPDATE", Hibernate.DATE);
	    query.setInteger("idStage", idStage);
            query.setInteger("idEvent", idEvent);
	    return (Date) firstResult(query);
  }
  
  public Integer findFCCPFormVersion(int idStage,int idEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_DOCUMENT_TEMPLATE " +
                                                 "  FROM FCCP_DTL_FORM_NARR " +
                                                 " WHERE ID_STAGE = :idStage" +
                                                 " AND ID_EVENT = :idEvent");
    query.addScalar("ID_DOCUMENT_TEMPLATE", Hibernate.INTEGER);
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);
    return (Integer) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public byte[] retrieveFCCPForm(int idStage,int idEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT NARRATIVE " +
                                                 " FROM FCCP_DTL_FORM_NARR " +
                                                 " WHERE ID_STAGE = :idStage" +
                                                 " AND ID_EVENT = :idEvent");
    query.addScalar("NARRATIVE", Hibernate.BINARY);
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);
    query.setMaxResults(1);
    List list = query.list();
    return list.size() > 0 ? (byte[]) list.get(0) : null;
  }
  
  //STGAP00012833: Gets the minimum dtCurrRev for a case
  public Date findEarliestDtCurrRevByIdCase(int idCase, Date dtRemoval ) {
    Query query = getSession().createQuery(" select distinct f.dtCurrRev " +
                                           " from FccpFamily f, EventPersonLink epl, Event e " +
                                          " where f.capsCase.idCase = :idCase " +
                                          " and f.idEvent = e.idEvent " +
                                          " and e.idEvent = epl.event.idEvent " +
                                          " and e.cdEventStatus = 'APRV' " +
                                          "   and f.dtCurrRev = " +
                                          "       ( select min(f2.dtCurrRev) " +
                                          "           from FccpFamily f2 " +
                                          "          where f2.capsCase.idCase = :idCase " +
                                          "   and f2.dtCurrRev >= :dtRemoval) ");
   query.setInteger("idCase", idCase);
   query.setDate("dtRemoval",dtRemoval);
   return (Date) firstResult(query);
 }
  
  @SuppressWarnings({"unchecked"})
  public List<FccpFamily> findFCCPFamilyByIdPersonByEventStatusByIdStage(int idPerson, int idStage, String cdEventType, Collection<String> cdEventStatuses) {
    Query query = getSession().createQuery("select f from FccpFamily f, Event e, EventPersonLink epl " +
                                           "where f.idEvent = e.idEvent  " +
                                           " and e.idEvent = epl.event.idEvent " +
                                           " and e.cdEventStatus in (:cdEventStatuses) " +
                                           " and e.cdEventType = :cdEventType " +
                                           " and e.stage.idStage = :idStage " +
                                           " and epl.person.idPerson = :idPerson " +
                                           " order by e.idEvent desc ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setParameterList("cdEventStatuses", cdEventStatuses);
    query.setString("cdEventType", cdEventType);
    return (List<FccpFamily>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public FccpFamily findLatestApprovedFCCPFamilyByIdPersonForOpenFsuStage(int idPerson) {
    Query query = getSession().createQuery(" from FccpFamily f " +
                                           " where f.event.cdEventStatus in ('APRV') " +
                                           " and f.event.cdEventType = 'PLN' " +
                                           " and f.event.stage.cdStage = 'FSU' " +
                                           " and f.event.stage.dtStageClose is null " +
                                           " and exists ( " +
                                           "    select 'x' " +
                                           "    from EventPersonLink epl " +
                                           "    where epl.event.idEvent = f.event.idEvent " +
                                           "    and epl.person.idPerson = :idPerson) " +
                                           " order by f.event.idEvent desc ");
    query.setInteger("idPerson", idPerson);
    return (FccpFamily) firstResult(query);
  }

  // STGAP00017578
  @SuppressWarnings({"unchecked"})
  public FccpFamily findLatestApprovedFCCPFamilyByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from FccpFamily f " +
                                           " where f.event.cdEventStatus in ('APRV') " +
                                           " and f.event.cdEventType = 'PLN' " +
                                           " and f.event.stage.cdStage = 'FSU' " +
                                           " and exists ( " +
                                           "    select 'x' " +
                                           "    from EventPersonLink epl " +
                                           "    where epl.event.idEvent = f.event.idEvent " +
                                           "    and epl.person.idPerson = :idPerson) " +
                                           " order by f.event.idEvent desc ");
    query.setInteger("idPerson", idPerson);
    return (FccpFamily) firstResult(query);
  }
}
