package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Attendees;

import java.util.List;
import java.util.Map;

public interface AttendeesDAO {
  /**
   * This method updates or inserts the given Attendees entry into the ATTENDEES table.
   *
   * @param attendees
   */
  void saveAttendees(Attendees attendees);

  /**
   * Deletes the Attendees persistent object from the database.
   *
   * @param attendees
   */
  void deleteAttendees(Attendees attendees);

  /**
   * Retrieves all Attendees assigned to the Legal Action represented by <code>idLegalActEvent</code> which is the
   * ID_LEGAL_ACT_EVENT column of the ATTENDEES table.
   *
   * @param idLegalActEvent
   * @return
   */
  List<Map> findAttendeesByIdLegalActEvent(int idLegalActEvent);
  
  /**
   * Retrieves the first ATTENDEES record for the given idLegalActEvent and idPerson combination.
   * 
   * @param idLegalActEvent
   * @param idPerson
   * @return
   */
  Attendees findUniqueAttendees(int idLegalActEvent, int idPerson);
  
  /**
   * Retrieves all Attendees records associated to the Legal Action represented by the given idLegalActEvent.
   * 
   * @param idLegalActEvent
   * @return
   */
  List<Attendees> findAttendeesList(int idLegalActEvent);
}
