package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;

import java.util.List;
import java.util.Set;


/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/13/10  hjbaptiste               Initial creation
 * 02/18/10  bgehlot                  Adding business logic for pre-population of Parent Contact Rules from the Person Detail,
 *                                    and logic for all the other buttons on the Page.
 * 02/21/10  hjbaptiste               Added saveContactStandards(), deleteContactStandards() and deleteContactStandardsByIdEvent()
 * 02/23/10  wjcochran                MR-62 Added method findApprovedContactStandardsByCdStageByIdCase that
 *                                    returns a ContactStandard object for a particular case idCase
 *                                    in a list of stages (i.e. 'FSU', 'ONG').
 * 
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, Februrary 13, 2010
 */
public interface ContactStandardsDAO {

  /**
   * Retrieves the Contact Standards from the db for the given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  ContactStandards findContactStandardsByIdEvent(int idEvent);
  
  /**
   * Get all approved Contact Standards
   * @param idStage
   * @return
   */
  List<ContactStandards> findApprovedContactStandards(int idStage);
  
  
  /**
   * Updates Contact Standards table.
   * 
   * @param ContactStandards
   * 
   * @return
   */
  void saveContactStandards(ContactStandards contactStandards);
  
  /**
   * Simple deletes of a Contact Standards
   * 
   * @param contactStandards
   * @return Integer
   */
  void deleteContactStandards(ContactStandards contactStandards);
  
  /**
   * Deletes a contact Standards based on the given idEvent
   * 
   * @param idEvent
   * @return
   */
  int deleteContactStandardsByIdEvent(int idEvent);
  
  /**
   * Finds a ContactStandards object for a particular case in a series of stages.
   * @param cdStageSet
   * @param idCase
   * @return
   */
  ContactStandards findApprovedContactStandardsByCdStageByIdCase(Set<String> cdStageSet, int idCase);

}
