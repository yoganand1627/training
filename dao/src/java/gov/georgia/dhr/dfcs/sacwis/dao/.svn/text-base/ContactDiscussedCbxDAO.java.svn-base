/**
 * Created on August 16,2010 at by Bhavna Gehlot.
 */
package gov.georgia.dhr.dfcs.sacwis.dao;


import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.ContactDiscussedCbx;

import java.util.List;
import java.util.Map;

public interface ContactDiscussedCbxDAO {
  
  /**
   * Returns person id's of existing discussed persons for a passed event
   * 
   * @param idEvent
   * @return List <Integer>
   */
  public List<ContactDiscussedCbx> findDiscussedMembersByIdEvent(int idEvent);
  /**
   * Deletes all row from CONTACT_DISCUSSED_CBX for a given contact event
   * 
   * @param idEvent
   * @return int
   */ 
  public int deleteDiscussedMembersByEvent(int IdEvent);
  
  /**
   * Deletes a row from CONTACT_DISCUSSED_CBX for a passed person and event
   * 
   * @param idEvent
   * @param idPerson
   * @return int
   */ 
  public int deleteDiscussedMembersByPersonAndEvent(int idPerson, int IdEvent);
  
  /**
   * Inserts or updates a row in CONTACT_DISCUSSED_CBX 
   * 
   * @param idEvent
   * @return int
   */  
  public void saveOrUpdateDiscussedMembers(ContactDiscussedCbx contactDiscussedCbx);

  /**
   * MR-072 Get the name and person id of discussed persons by idEvent
   * @param idEvent
   * @return
   */
  List<Map> findDiscussedMembersIdAndNameByIdEvent(int idEvent);
  
  /**
   * get the discussed person by idEvent and IdPerson
   * @param idEvent
   * @param idPerson
   * @return
   */
  List<Integer> findDiscussedMembersByIdEventIdPerson(int idEvent, int idPerson);
  
  /**
   * This method returns contact discussed cbx for idPersMergeClosed
   * @param idPersMergeClosed
   * @return
   */
  List<ContactDiscussedCbx> findDiscussedPersonByIdPersonClosed(int idPersMergeClosed);
  
  /**
   * This method updates CONTACT_DISCUSSED_CBX with idPersMergeForward
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return
   */
  int updateDiscussedCbxByIdPersonClosed(int idPersMergeForward, int idPersMergeClosed);
  
}
