/**
 * Created on June 16, 2008 at by Patrick Coogan
 */

package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SrHouseholdMembers;
import java.util.List;

import org.hibernate.Query;

public class SrHouseholdMembersDAOImpl extends BaseDAOImpl implements SrHouseholdMembersDAO {

  @SuppressWarnings( { "unchecked" })
  public  List<Integer> findSrHouseholdMembersByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select sha.idPerson  " +
    		                               " from SrHouseholdMembers sha" +
                                           " where sha.safetyResource.event.idEvent = :idEvent"); 
    query.setInteger("idEvent", idEvent);
    return  (List<Integer>) query.list();
  }

  public void saveOrUpdateSrHouseholdMembers(SrHouseholdMembers srHouseholdMembers){
    getSession().saveOrUpdate(srHouseholdMembers);
  }
  
  public int deleteSrHouseholdMembersByPersonAndEvent(int idPerson, int idEvent) {
    Query query = getSession().createQuery("delete from SrHouseholdMembers srh" +
                                           "       where srh.idPerson = :idPerson" +
                                           "       and srh.safetyResource.idEvent = :idEvent");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
  
  public int deleteSrHouseholdMembersByEvent(int idEvent) {
    Query query = getSession().createQuery("delete from SrHouseholdMembers srh" +
                                           "       where srh.safetyResource.idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
  
  public long countSafetyHouseholdForEvent(int idPerson, int idEvent) {

    Query query = getSession().createQuery(
                                           "select count(*) from  SrHouseholdMembers sh " 
                                           + " where sh.safetyResource.event.idEvent = :idEvent "
                                           + " and sh.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return (Long) query.uniqueResult();
  }
  
  public int deleteSrHouseholdMembersEvent(int idPerson, int idEvent) {
    Query query = getSession().createSQLQuery("delete from SR_HOUSEHOLD_MEMBERS" +
                                           "       where ID_PERSON = :idPerson and ID_SR_EVENT = :idEvent ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public int mergeSafetyResourceHshldMembers(int idPersMergeForward, int idPersMergeClosed, int idEvent){
   
    Query query = getSession().createSQLQuery(" update SR_HOUSEHOLD_MEMBERS set ID_PERSON =  :idPersMergeForward " +
                                                " where ID_PERSON =  :idPersMergeClosed " +
                                                " and ID_SR_EVENT = :idEvent ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public long countSafetyHouseholdForCase(int idPerson, int idCase) {
     
     Query query = getSession().createQuery(
                                            "select count(*) from  SrHouseholdMembers sh " 
                                             + " where sh.safetyResource.event.capsCase.idCase = :idCase "
                                             + " and sh.idPerson = :idPerson ");
         
     query.setInteger("idPerson", idPerson);
     query.setInteger("idCase", idCase);
     return (Long) query.uniqueResult();
   }


}
