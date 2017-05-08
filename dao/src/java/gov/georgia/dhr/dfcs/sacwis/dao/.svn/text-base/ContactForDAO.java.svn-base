package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ContactFor;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/18/10  Bhavna Gehlot            Initial creation
 * 02/21/10  hjbaptiste               Added deleteContactFor()
 * 
 * </pre>
 *
 * @author Bhavna Gehlot, Februrary 18, 2010
 */
public interface ContactForDAO {
  
  /**
   * Retrieves the Contact For from the db for the given idContactRule. <p/>
   * 
   * @param idContactRule
   * @return
   */
  List<ContactFor> findContactForByIdContactRule(int idContactRule);

  /**
   * Retrieves the Contact For from the db for the given idContactRule. <p/>
   * 
   * @param idContactRule
   * @param idChild
   * @return
   */
  ContactFor findContactForByIdContactRuleIdChild(int idContactRule, int idChild);
  
  /**
   * Retrieves the id of all of the children of the ContactFor for the passed in id contact rule
   * where the indContactFor is set to 'Y'
   * 
   * @param idContactRule
   * @return List<Integer>
   */
  List<Integer> findCheckedContactForByIdContactRuleIdChild(int idContactRule);
  
  /**
   * Saves in CONTACT_FOR table
   */
  void saveContactFor(ContactFor contactFor);
  
  /**
   * Deletes all ContactFor records for the passed in idContactRule
   *  
   * @param idContactRules
   * @return Integer
   */
  int deleteAllContactForsByIdContactRule(int idContactRule);
  
  /**
   * Deletes all ContactFor records for the passed in list of idContactRule
   * 
   * @param idContactRules
   * @return Integer
   */
  public int deleteAllContactForsByListContactRules(List<Integer> idContactRules);
  
  /**
   * Deletes a ContactFor record from the db
   * 
   * @param contactFor
   */
  void deleteContactFor(ContactFor contactFor);

  /**
   * Identifies if the two person ids are linked to the same Contact Rule. 
   * 
   * @param idPerson
   * @param idNewPerson
   * @return long
   */ 
  long countByIdPersonIdNewPerson(int idPerson, int idNewPerson);
  

  /**
   * Updates the person ids for all the contact rules for a given event/contact standard.
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   * @return long
   */  
  int updateContactFor(int idPersMergeForward, int idPersMergeClosed, int idEvent);
  
  

}
