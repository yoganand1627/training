/**
 * Created on June 16, 2008 at by Patrick Coogan
 *  * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/21/2009  bgehlot         STGAP00014329: Added method findSafetyResourceByIdEvent  
 * </pre>
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;

import org.hibernate.Query;

public class SafetyResourceDAOImpl extends BaseDAOImpl implements SafetyResourceDAO {
   
  public int saveOrUpdateSafetyResource(SafetyResource safetyResource){
    getSession().saveOrUpdate(safetyResource);
    return safetyResource.getIdEvent();
  }
 
  public int deleteSafetyResource(int idEvent) {
    Query query = getSession().createQuery("delete from SafetyResource" +
                                           "       where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public long countSafetyResourceForCase(int idPerson, int idCase) {

    Query query = getSession().createQuery(
                                           "select count(*) from  SafetyResource sr " 
                                           + " where sr.event.capsCase.idCase = :idCase "
                                           + " and (sr.idPrimary = :idPerson " 
                                           + " or sr.idSecondary = :idPerson) ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    return (Long) query.uniqueResult();
  }
  
  public long countOpenSafetyResourcesForCase(int idCase) {

    Query query = getSession().createQuery(
                                           "select count(*) from  SafetyResource sr " 
                                           + " where sr.event.capsCase.idCase = :idCase "
                                           + " and sr.event.cdEventStatus != :cdEventStatus");
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setInteger("idCase", idCase);
    return (Long) query.uniqueResult();
  }
  
  
  //Merge Primary Safety Resource
  public int updateSafetyResourcePrimary(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    
    Query query = getSession().createQuery(" update SafetyResource sr " +
                                              "    set idPrimary =  :idPersMergeForward " +
                                              "  where idPrimary =  :idPersMergeClosed " +
                                              "    and sr.event.idEvent = :idEvent ");
     query.setInteger("idPersMergeForward", idPersMergeForward);
     query.setInteger("idPersMergeClosed", idPersMergeClosed);
     query.setInteger("idEvent", idEvent);
     return query.executeUpdate();
  }
  
//Merge Primary Safety Resource
  public int updateSafetyResourceSecondary(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    
    Query query = getSession().createQuery(" update SafetyResource sr " +
                                              "    set idSecondary =  :idPersMergeForward " +
                                              "  where idSecondary =  :idPersMergeClosed " +
                                              "    and sr.event.idEvent = :idEvent ");
     query.setInteger("idPersMergeForward", idPersMergeForward);
     query.setInteger("idPersMergeClosed", idPersMergeClosed);
     query.setInteger("idEvent", idEvent);
     return query.executeUpdate();
  }
  
  //STGAP00014329: Find the safety resource for idEvent
  public SafetyResource findSafetyResourceByIdEvent(int idEvent) {

    Query query = getSession().createQuery("   from SafetyResource sr " + 
                                           "  where sr.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (SafetyResource) firstResult(query);
  }
 
  @SuppressWarnings({"unchecked"})
  public List<Map> findAllSafetyResourcePlacementsForCase(int idCase){
    
    Query query = getSession().createQuery("select new map("
                                           + " p.nmPersonFull as childPlaced, "
                                           + " p2.nmPersonFull as safetyResource, "
                                           + " src.dtStart as startDate, "
                                           + " src.dtEnd as endDate, "
                                           + " round(months_between(nvl(src.dtEnd,sysdate),src.dtStart),0) as monthsInPlacement)"
                                           + " from SafetyResourceChild src, Person p, Person p2 " 
                                           + " inner join src.safetyResource sr "
                                           + " inner join sr.event e  "
                                           + " where e.capsCase.idCase = :idCase"
                                           + " and src.idChild = p.idPerson"
                                           + " and sr.idPrimary= p2.idPerson"
                                           + " order by p.nmPersonFull desc");

    query.setInteger("idCase", idCase);
    return (List<Map>) query.list();
    
    
  }
  
}
