/**
 * Created on June 24, 2009 at  by Ashwini R. Rege
 */
package gov.georgia.dhr.dfcs.sacwis.dao;


import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ContactPrivConverCbx;

public interface ContactPrivConverCbxDAO {
  
  /**
   * Returns person id's of existing priv conversations for a passed event
   * 
   * @param idEvent
   * @return List <Integer>
   */
  public List<Integer> findPrivConversationMembersByIdEvent(int idEvent);
  /**
   * Deletes all row from CONTACT_PRIV_CONVER_CBX for a given contact event
   * 
   * @param idEvent
   * @return int
   */ 
  public int deletePrivConversationMembersByEvent(int IdEvent);
  
  /**
   * Deletes a row from CONTACT_PRIV_CONVER_CBX for a passed person and event
   * 
   * @param idEvent
   * @param idPerson
   * @return int
   */ 
  public int deletePrivConversationMembersByPersonAndEvent(int idPerson, int IdEvent);
  
  /**
   * Inserts or updates a row in CONTACT_PRIV_CONVER_CBX 
   * 
   * @param idEvent
   * @return int
   */  
  public void saveOrUpdatePrivConversationMembers(ContactPrivConverCbx contactPrivConverCbx);

  
}
