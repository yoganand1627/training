/**
 * Created on Mar 25, 2006 at 2:17:36 PM by Michael K. Werle
 *
 * <pre>
 *  Change History:
 *  Date               User      Description
 *  ----------        --------  --------------------------------------------------
 *  09/29/2009         arege    STGAP00015281: Added method findContactNarrativeByIdEvent() to find Narrative by idEvent.
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.ContactNarrative;

public interface ContactNarrativeDAO {
  /**
   * Delete from ContactNarative based on idStage
   *
   * @param idStage
   */
  int deleteContactNarative(int idStage);
  
  /**
   * Find ContactNarrative by given idEvent. 
   * @param idEvent
   * @return List of ContactNarratives for given idEvent.
   */
  ContactNarrative findContactNarrativeByIdEvent(int idEvent);
  
  /**
   * This method is to be used to retrieve data for the Google Appliance
   * 
   */
  List<Map> findAllContactNarratives();

  /**
   * This method is to be used to retrieve data for the Google Appliance
   * 
   */
  List<Integer> findAllIdEventsForContactNarratives();

}
