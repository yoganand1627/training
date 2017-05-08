package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;

public interface EventPersonLinkDAO {
  /**
   * This joins the EVENT and EVENT PERSON LINK Table to return a count of events a given ID PERSON * is involved in
   * where the event status is not equal to approved.
   *
   * @param idPerson
   * @return The count of unapproved events for a particular person.
   */
  public long countByIdPerson(int idPerson);

  /**
   * Retrieves rows with fields from EventPersonLink and Person tables, for a given idEvent.
   *
   * @param idEvent
   * @return List of EventPersonLink objects
   */
  @SuppressWarnings({"unchecked"})
  public List<EventPersonLink> findEventPersonLinkAndPersonByIdEvent(int idEvent);

  /**
   * Retrieves names associated with a given event.
   *
   * @param idEvent
   * @return List<EventPersonLink>
   */
  @SuppressWarnings({"unchecked"})
  public List<String> findNmPersonFullByIdEvent(int idEvent);
  
  /**
   * Retrieves person's name, id, and indicator whether that person is a caregiver in a foster care family case plan
   * @param idEvent
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findPersonsByIdEvent(int idEvent);

  /**
   * Return a count of EvenPersonLinks for a specified idPerson where idEvent > 0
   *
   * @param idPerson
   * @return Integer
   */
  public long countEventPersonLinksNonZeroIdEventByIdPerson(int idPerson);

  /**
   * Returns the count of the number of EventsPersonLinks for the specified idPerson
   *
   * @param idPerson
   * @return The count of event links for a given person.
   */
  public long countEventPersonLinksByIdPerson(int idPerson);

  /**
   * This will select a count of the events in an open stage with which both Host variables are associated.
   *
   * @param idPerson
   * @param idNewPerson
   * @return The count of events in an open stage with which both Host variables are associated.
   */
  public long countByIdPersonIdNewPerson(int idPerson, int idNewPerson);

  /**
   * This joins Event and EventPersonLink to determine if for the given idPerson an EventType exists.
   *
   * @param idPerson
   * @return Information about events associated with a particular person.
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findEventTypeEventStatusEventStageByIdPerson(int idPerson);

  public EventPersonLink findEventPersonLinkByIdEventAndIdPerson(int idEvent, int idPerson);

  /**
   * This inserts into EventPersonLink.
   *
   * @param idEvent
   * @param idPerson
   */
  public int insertEventPersonLink(int idEvent, int idPerson);

  /**
   * Partial update of EventPersonLink table using the supplied parameters(column values).
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   */
  public int updateEventPersonLink(int idPersMergeForward, int idPersMergeClosed, int idEvent);
  
  /**
   * Update indCareGiver column
   * @param indCareGiver
   * @param idPerson
   * @param idEvent
   * @return
   */
  public int updateCareGiverStatus(String indCareGiver, int idPerson, int idEvent);

  /**
   * Delete rows from EVENT_PERSON_LINK based on ID_EVENT and ID_PERSON
   *
   * @param idEvent
   * @param idPerson
   * @return The number of rows deleted.
   */
  public int deleteEventPersonLink(int idEvent, int idPerson, Date dtLastUpdate);

  /**
   * Delete rows from EVENT_PERSON_LINK based on ID_EVENT
   *
   * @param idEvent
   * @return The number of rows deleted.
   */
  public int deleteEventPersonLinkByIdEvent(int idEvent);

  /**
   * Delete rows in EVENT_PERSON_LINK based on ID_EVENT
   *
   * @param idStage
   * @return The number of rows deleted.
   */
  public int deleteEventPersonLink(int idStage);

  /**
   * Retrieves person's name, id, dob, and indicator whether that person is a SMILE client
   * @param idEvent
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findPersonsForClientOutboundByIdEvent(int idEvent);
  
  /**
   * Retrieves person's name, id, dob, and indicator whether that person is a SMILE client for Adoption Agreement events
   * @param idEvent
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findPersonsForClientOutboundByIdEventForAdoAgreement(int idEvent);

  /**
   * find the eventPersonLink for a person in a specific cdEventType and idStage
   * @param idStage
   * @param idPerson
   * @param cdEventType
   * @return EventPersonLink
   */
  List<Map> findEventPersonLinkByIdStageByIdPersonByCdEventType(int idStage, int idPerson,
                                                                      String cdEventType);
  
  /**
   * Saves an Event Person Link record
   * @param eventPersonLink
   * @return
   */
  public void saveEventPersonLink(EventPersonLink eventPersonLink);

  
  /**
   * This method gets the idEvent of the most recent approved case plan for the given case
   * @param idCase
   * @parm cdTask
   * @return
   */
  public Integer findIdEventByIdCaseByEventTypeByEventStatus(int idCase, String cdTask, int idChild);
  
  /**
   * Counts the number of Event for the given idPerson and idCase for Exchange Child
   * @param idPerson
   * @param idCase
   * @return
   */
  public long countEventPersonLinkByIdPersonIdCaseForExchangeChild(int idPerson, int idCase);
  /**
   * Counts the number of Event for the given idPerson for CPS Investigation CAPTA Changes Requirement 1
   * @param idPerson
   * @param idCase
   * @return
   */
  public long countEventPersonLinkByIdPersonIdForCPSInvestChildReferral(int idPerson);
  /**
   * Counts the number of Event for the given idPerson for Allegation type of Child Death/Near Fatality/
   * Serious Injury
   * @param idPerson
   * @return
   */
  public long countEventPersonLinkByIdPersonIdForAllegationOfCDNFSI(int idPerson);
  /**
   * Counts the number of Approved Event for the given idPerson for Allegation type of Child Death/Near Fatality/
   * Serious Injury
   * @param idPerson
   * @return
   */
  public long countEventPersonLinkByIdPersonIdForAllegationOfCDNFSIApproved(int idPerson);
  Integer findIPersonByIdEpl(int idEvent);
  
  /**
   * Updates EventPersonLink records with idCase for given idEventStage and cdEventType
   * @param idCase
   * @param idEventStage
   * @param cdEventType
   * @return
   */
  public int updateEventPersonLinkWithIdCase(int idCase, int idEventStage, String cdEventType );

}
