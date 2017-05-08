/**
 * Created on August 16,2010 at by Bhavna Gehlot.
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.ContactDiscussedCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.ContactDiscussedCbx;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public class ContactDiscussedCbxDAOImpl extends BaseDAOImpl implements ContactDiscussedCbxDAO {

@SuppressWarnings( { "unchecked" })
public  List<ContactDiscussedCbx> findDiscussedMembersByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select cpc  " +
                                           " from ContactDiscussedCbx cpc " +
                                           " where cpc.contact.idEvent = :idEvent"); 
    query.setInteger("idEvent", idEvent);
    return  (List<ContactDiscussedCbx>) query.list();
  }

public int deleteDiscussedMembersByPersonAndEvent(int idPerson, int idEvent) {
    Query query = getSession().createQuery("delete from ContactDiscussedCbx cpc " +
                                           "       where cpc.person.idPerson = :idPerson" +
                                           "       and cpc.contact.idEvent = :idEvent");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
  
  public int deleteDiscussedMembersByEvent(int idEvent) {
    Query query = getSession().createQuery("delete from ContactDiscussedCbx cpc" +
                                           "       where cpc.contact.idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
  
  public void saveOrUpdateDiscussedMembers(ContactDiscussedCbx contactDiscussedCbx){
      getSession().saveOrUpdate(contactDiscussedCbx);
    }
  
  /**
   * MR-072 Get the name and person id of discussed persons by idEvent
   * @param idEvent
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  public  List<Map> findDiscussedMembersIdAndNameByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select new map (cpc.person.idPerson as idDiscussedPerson, " +
                                           " p.nmPersonFull as nmPersonFull) " +
                                           " from ContactDiscussedCbx cpc, Person p " +
                                           " where cpc.person.idPerson = p.idPerson " +
                                           " and cpc.contact.idEvent = :idEvent"); 
    query.setInteger("idEvent", idEvent);
    return  (List<Map>) query.list();
  }
  
  /**
   * get the discussed person by idEvent and IdPerson
   * @param idEvent
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public  List<Integer> findDiscussedMembersByIdEventIdPerson(int idEvent, int idPerson) {
    Query query = getSession().createQuery(" select cpc.person.idPerson  " +
                                           " from ContactDiscussedCbx cpc " +
                                           " where cpc.contact.idEvent = :idEvent " +
                                           " and cpc.person.idPerson = :idPerson "
                                           ); 
    query.setInteger("idEvent", idEvent);
    query.setInteger("idPerson", idPerson);
    return  (List<Integer>) query.list();
  }
  

  /**
   * This method returns contact discussed cbx for idPersMergeClosed
   * @param idPersMergeClosed
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<ContactDiscussedCbx> findDiscussedPersonByIdPersonClosed(int idPersMergeClosed){
    
    Query query = getSession().createQuery(" select c " +
                                           " from ContactDiscussedCbx c " +
                                           " where c.person.idPerson = :idPersMergeClosed " );
                                           
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return (List<ContactDiscussedCbx>) query.list();
  }
  
  /**
   * This method updates CONTACT_DISCUSSED_CBX with idPersMergeForward
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return
   */
  public int updateDiscussedCbxByIdPersonClosed(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery("update ContactDiscussedCbx " +
                                           "   set person.idPerson = :idPersMergeForward " +
                                           " where person.idPerson = :idPersMergeClosed ");
                                           
    
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return query.executeUpdate();
  }
}



