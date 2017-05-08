/**
 * Created on Mar 25, 2006 at 2:31:23 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.EmergencyAssist;

public interface EmergencyAssistDAO {
  /**
   * Retrieves rows from EmergenctAssist table for the given idEvent.
   *
   * @param idEvent
   * @return List of EmergencyAssist objects
   */
  @SuppressWarnings({"unchecked"})
  List<EmergencyAssist> findEmergencyAssistByIdEvent(int idEvent);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.EmergencyAssist} object to the database.
   *
   * @param emergencyAssist A populated {@link gov.georgia.dhr.dfcs.sacwis.db.EmergencyAssist} object.
   */
  void saveEmergencyAssist(EmergencyAssist emergencyAssist);
}
