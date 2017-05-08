/**
 * Created on July 4, 2009 at by Ashwini Rege.
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.ContactPrivConverCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactPrivConverCbx;

import org.hibernate.Query;

public class ContactPrivConverCbxDAOImpl extends BaseDAOImpl implements ContactPrivConverCbxDAO {

  @SuppressWarnings( { "unchecked" })
public  List<Integer> findPrivConversationMembersByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select cpc.idPrivConverPerson  " +
                                           " from ContactPrivConverCbx cpc " +
                                           " where cpc.contact.idEvent = :idEvent"); 
    query.setInteger("idEvent", idEvent);
    return  (List<Integer>) query.list();
  }

public int deletePrivConversationMembersByPersonAndEvent(int idPerson, int idEvent) {
    Query query = getSession().createQuery("delete from ContactPrivConverCbx cpc " +
                                           "       where cpc.idPrivConverPerson = :idPerson" +
                                           "       and cpc.contact.idEvent = :idEvent");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
  
  public int deletePrivConversationMembersByEvent(int idEvent) {
    Query query = getSession().createQuery("delete from ContactPrivConverCbx cpc" +
                                           "       where cpc.contact.idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
    
  }
  
  public void saveOrUpdatePrivConversationMembers(ContactPrivConverCbx contactPrivConverCbx){
      getSession().saveOrUpdate(contactPrivConverCbx);
    }
  }



