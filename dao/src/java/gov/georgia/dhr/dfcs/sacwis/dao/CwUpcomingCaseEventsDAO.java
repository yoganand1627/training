/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CwUpcomingEvents;
import java.util.List;

/**
 * @author Patrick Coogan
 *
 */
public interface CwUpcomingCaseEventsDAO {
  /**
   * This selects a list of case warnings for a stage.
   *
   * @param idStage
   * @return List<CwUpcomingEvents>
   */
  List<CwUpcomingEvents> findUpcomingEventsByStageID(int idStage);
  
 /**
 *  Whether this event has an upcoming events
 * @param idEvent
 * @return
 */
  Integer findCwUpcomingEventsByIdEvent(int idEvent);
  
  /**
   * Delete an upcoming event by event id
   * @param idEvent
   * @return
   */
  int deleteCwUpcomingEventsByStageID(int idEvent);
}
