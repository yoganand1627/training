package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/18/10  Bhavna Gehlot            Initial creation
 * 02/21/10  hjbaptiste               Added deleteContactRule()
 * 
 * </pre>
 *
 * @author Bhavna Gehlot, Februrary 18, 2010
 */
public interface ContactRuleDAO {
  
  /**
   * Retrieves the Contact Rules from the db for the given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  List<ContactRule> findContactRulesByIdEventCdPersonRole(int idEvent, List<String> roles);
  
  /**
   * Retrieves all Contact Rules from the db for the given idEvent and roles.
   * It will return a map with the following keys: 
   * <pre>
   * 1) idPerson
   * 2) nmPersonFull
   * </pre> 
   * @param idEvent
   * @param roles
   * @return List<Map>
   */
  List<Map> findContactRulesPersonByIdEventCdPersonRole(int idEvent, List<String> roles);
  
  /**
   * Retrieves the Contact Rules from the db for the given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  List<ContactRule> findContactRuleByIdEvent(int idEvent);

  /**
   * Retrieves all Contact Rules associated with a Contact Standards
   * 
   * @param idEvent
   * @return List<ContactRule>
   */
  List<ContactRule> findAllContactRulesByIdEvent(int idEvent);

  /**
   * Retrieves all Contact Rules from the db for the given idEvent with including newly
   * added ones. The newly created ones would not have a cd_person_role nor an id_person
   * 
   * @param idEvent
   * @param roles
   * @return
   */
  List<ContactRule> findAllParentContactRulesByIdEventIncludeNew(int idEvent, List<String> roles);
  
  /**
   * Based on the indPrepopulate variable that's passed in , the Prepopulated Contact Rules or
   * the Non-Prepopulated Contact Rules will be returned for the given idEvent and the given roles
   * 
   * @param idEvent
   * @param roles
   * @return List<ContactRule>
   */
  List<ContactRule> findContactRulesByIdEventRolesIndPrepopulate(int idEvent, List<String> roles, String indPrepopulated);
  
  /**
   * Finds the full names of people that have a Contact Rule that has the child selected in the 'Contact For' section. 
   * 
   * @param idEvent
   * @param idChild
   * @param cdPersonRole
   * @return List<String>
   */
  List<String> findContactRulesByIdEventIdChild(int idEvent, int idChild, String cdPersonRole);
  
  /**
   * Finds the Unknowm people that have a Contact Rule that has the child selected in the 'Contact For' section. 
   * 
   * @param idEvent
   * @param idChild
   * @param cdPersonrole
   * @return String
   */
  String findUnknownContactRulesByIdEventIdChild(int idEvent, int idChild, String cdPersonrole);
  
  /**
   * Identifies if the two person ids are linked to the same event/Contact Standard. 
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
  int updateContactRule(int idPersMergeForward, int idPersMergeClosed, int idEvent);
  
  
  /**
   * Saves in CONTACT_RULE table
   */
  int saveContactRule(ContactRule contactRule);

  /**
   * Deletes a Contact Rule
   * 
   * @param contactRule
   */
  void deleteContactRule(ContactRule contactRule);
  
  /**
   * Deletes all Contact Rules for a particular Contact Standards (Event)
   * 
   * @param idEvent
   */
  int deleteAllContactRules(int idEvent);
}
