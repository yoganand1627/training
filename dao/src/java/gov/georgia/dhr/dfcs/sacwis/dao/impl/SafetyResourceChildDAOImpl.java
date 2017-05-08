/**
 * Created on June 16, 2008 at by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.util.Map;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;


/**
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/25/2009 bgehlot          STGAP00014329: Added method deleteSafetyResourceChildTodo
 * 
 * 07/09/2009 cwells           STGAP00014333: Added methods retrieveSafetyRsrcForm and findSafetyRsrcFormVersion 
 * 02/06/2012 schoi            STGAP00017831: MR-102 Added new method findActiveApprovedSafetyResourceByIdPersonByDate
 * </pre>
 */

public class SafetyResourceChildDAOImpl extends BaseDAOImpl implements SafetyResourceChildDAO {

  public SafetyResourceChild findSafetyResourceByIdSrChild(int idSrChild) {

    Query query = getSession().createQuery("   from SafetyResourceChild ssc" + 
                                           "  where ssc.idSrChild = :idSrChild");
    query.setInteger("idSrChild", idSrChild);
    return (SafetyResourceChild) firstResult(query);
  }

  public int saveOrUpdateSafetyResourceChild(SafetyResourceChild safetyResourceChild) {
    getSession().saveOrUpdate(safetyResourceChild);
    return safetyResourceChild.getIdSrChild();
  }

  public int deleteSafetyResourceChild(int idSrChild) {
    
    Query query = getSession().createQuery(
                                           " delete from SafetyResourceChild src " 
                                           + " where src.idSrChild = :idSrChild");
    query.setInteger("idSrChild", idSrChild);                                                    
    return query.executeUpdate();
  }

  @SuppressWarnings("unchecked")
  public List<SafetyResourceChild> findOpenSafetyResourcesForStage(int idStage) {

    Query query = getSession().createQuery(
                                           " from SafetyResourceChild src " 
                                           + " inner join src.safetyResource sr "
                                           + " inner join sr.event e inner join e.stage s "
                                           + " where s.idStage = :idStage"
                                           + " and src.dtEnd is null");

    query.setInteger("idStage", idStage);
    return (List<SafetyResourceChild>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<SafetyResourceChild> findOpenSafetyResourcesForCase(int idCase) {

    Query query = getSession().createQuery(
                                           " from SafetyResourceChild src " 
                                           + " inner join src.safetyResource sr "
                                           + " inner join sr.event e inner join e.stage s "
                                           + " where s.capsCase.idCase = :idCase "
                                           + " and src.dtEnd is null");

    query.setInteger("idCase", idCase);
    return (List<SafetyResourceChild>) query.list();
  }  
  
  
  @SuppressWarnings("unchecked")
  public List<Map> findSafetyResourceChildrenForEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           " select new map " +
                                           "(src as safetyResourceChild, p.nmPersonFull as nmPersonFull)" +
                                           "from SafetyResourceChild src, Person p  " +
                                           "where src.idChild = p.idPerson and src.safetyResource.idEvent = :idSrEvent");
    query.setInteger("idSrEvent", idEvent);
    return (List<Map>) query.list();
                                          
  }
  
  @SuppressWarnings("unchecked")
  public SafetyResourceChild findOpenActiveSafetyResourcesForChild(int idSrChild, Date dtSysDtGenericSysdate) {

    Query query = getSession().createQuery(
                                           " from SafetyResourceChild src where src.idChild = :idSrChild"
                                                           + " and src.dtStart <= :dtSysDtGenericSysdate "
                                                           + " and src.dtEnd is null ");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("idSrChild", idSrChild);
    return (SafetyResourceChild) firstResult(query);
  }  
  
  @SuppressWarnings("unchecked")
  public List<SafetyResourceChild> findOpenSafetyResourcesForChild(int idSrChild) {

    Query query = getSession().createQuery(
                                           " from SafetyResourceChild src where src.idChild = :idSrChild"
                                                           + " and src.dtEnd is null");

    query.setInteger("idSrChild", idSrChild);
    return (List<SafetyResourceChild>) query.list();
  }  
  
  @SuppressWarnings("unchecked")
  public List<Integer> findOverlapLeftForChild(int idChild, Date dtStart, Date dtEnd, int idSrChild) {

    Query query = getSession().createQuery(
                                           " select src.idChild from SafetyResourceChild src"
                                           + " where src.idChild = :idChild"
                                           + " and (src.dtEnd > :dtStart"
                                           + " or src.dtEnd is NULL) "
                                           + " and src.dtStart < :dtEnd"
                                           + " and src.dtStart <> nvl(src.dtEnd,to_date('12/31/4712','MM/DD/YYYY'))"
                                           + " and src.idSrChild <> :idSrChild ");

    query.setInteger("idChild", idChild);
    query.setDate("dtEnd", dtEnd);
    query.setDate("dtStart",dtStart);
    query.setInteger("idSrChild", idSrChild);
    return query.list();
  }  

  @SuppressWarnings("unchecked")
  public List<Integer> findOverlapRightForChild(int idChild, Date dtEnd, int idSrChild) {

    Query query = getSession().createQuery(
                                           " select src.idChild from SafetyResourceChild src"
                                           + " where src.idChild = :idChild"
                                           + " and src.dtStart < :dtEnd"
                                           + " and (src.dtEnd > :dtEnd"
                                           + " or src.dtEnd is NULL)"
                                           + " and src.dtStart <> nvl(src.dtEnd,to_date('12/31/4712','MM/DD/YYYY'))"
                                           + " and src.idSrChild <> :idSrChild ");

    query.setInteger("idChild", idChild);
    query.setInteger("idSrChild",idSrChild);
    query.setDate("dtEnd",dtEnd);
    return query.list();
  }  
  
  @SuppressWarnings("unchecked")
  public List<Integer> findOpenSafetyResourcesForEvent(int idEvent) {
    
    Query query = getSession().createQuery(
                                           " select src.idChild from SafetyResourceChild src"
                                           + " where src.safetyResource.idEvent = :idEvent"
                                           + " and src.dtEnd is NULL");
        
    query.setInteger("idEvent", idEvent);
    return query.list();
  }
  
  public long countSafetyResourceChildForEvent(int idPerson, int idEvent) {

    Query query = getSession().createQuery(
                                           "select count(*) from  SafetyResourceChild sca " 
                                           + " where sca.safetyResource.event.idEvent = :idEvent "
                                           + " and sca.idChild = :idPerson ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return (Long) query.uniqueResult();
  }
  
  public int deleteSafetyResourceChildEvent(int idChild, int idEvent) {
    Query query = getSession().createSQLQuery("delete from SAFETY_RESOURCE_CHILD" +
                                           "       where ID_CHILD = :idChild" +
                                           "       and ID_SR_EVENT = :idEvent ");
    query.setInteger("idChild", idChild);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public int mergeSafetyResourceChildren(int idPersMergeForward, int idPersMergeClosed, int idEvent){

    Query query = getSession().createSQLQuery(" update SAFETY_RESOURCE_CHILD set ID_CHILD =  :idPersMergeForward " +
                                                 " where ID_CHILD =  :idPersMergeClosed " +
                                                 " and ID_SR_EVENT = :idEvent ");
       query.setInteger("idPersMergeForward", idPersMergeForward);
       query.setInteger("idPersMergeClosed", idPersMergeClosed);
       query.setInteger("idEvent", idEvent);
       return query.executeUpdate();  
  }
  
  public long countSafetyResourceChildForCase(int idPerson, int idCase) {
     
    Query query = getSession().createQuery(
                                            "select count(*) from  SafetyResourceChild sca " 
                                             + " where sca.safetyResource.event.capsCase.idCase = :idCase "
                                             + " and sca.idChild = :idPerson ");
   query.setInteger("idPerson", idPerson);
   query.setInteger("idCase", idCase);
   return (Long) query.uniqueResult();
  }
  
  public Integer findSafetyRsrcFormVersion(int idEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_DOCUMENT_TEMPLATE " +
                                                 "  FROM SAFETY_RSRC_ASMNT_NARR " +
                                                 " WHERE ID_EVENT = :idEvent");
    query.addScalar("ID_DOCUMENT_TEMPLATE", Hibernate.INTEGER);
    query.setInteger("idEvent", idEvent);
    return (Integer) firstResult(query);
  }
  
  // STGAP00017831: MR-102
  // Gets active Safety Resource Placement in which the Start Date of Safety Resource Placement 
  // is earlier or equal to the Begin Date of the earliest Service Authorization Detail 
  // for the person receiving services AND the End Date of Safety Resource Placement 
  // must be later than the Begin Date of the earliest Service Authorization Detail 
  // for the person receiving services. System will look for the Safety Resource Placement across stages.
  @SuppressWarnings({"unchecked"})
  public SafetyResourceChild findActiveApprovedSafetyResourceByIdPersonByDate(int idChild, Date dtSvcAuthDtlBegin) {
    Query query = getSession().createQuery(
                                           " from SafetyResourceChild src where src.idChild = :idChild "
                                           + " and src.safetyResource.event.cdEventStatus = 'APRV' "
                                           + " and src.dtStart <= :dtSvcAuthDtlBegin " 
                                           + " and nvl(src.dtEnd,to_date('12/31/4712','MM/DD/YYYY')) > :dtSvcAuthDtlBegin ");
    query.setInteger("idChild", idChild);
    query.setTimestamp("dtSvcAuthDtlBegin", dtSvcAuthDtlBegin);
    return (SafetyResourceChild) firstResult(query);     
  }
  
  @SuppressWarnings({"unchecked"})
  public byte[] retrieveSafetyRsrcForm(int idEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT NARRATIVE " +
                                                 " FROM SAFETY_RSRC_ASMNT_NARR " +
                                                 " WHERE ID_EVENT = :idEvent");
    query.addScalar("NARRATIVE", Hibernate.BINARY);
    query.setInteger("idEvent", idEvent);
    query.setMaxResults(1);
    List list = query.list();
    return list.size() > 0 ? (byte[]) list.get(0) : null;
  }
  
  /**
   * STGAP00014329: Delete todo for the evwnt
   */
  public int deleteSafetyResourceChildTodo(int idEvent) {
    Query query = getSession().createQuery(" delete from Todo t " +
                                           " where t.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
}