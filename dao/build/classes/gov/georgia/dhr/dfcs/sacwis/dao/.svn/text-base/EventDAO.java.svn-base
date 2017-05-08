/**
 * Created on Mar 25, 2006 at 2:28:19 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Event;


/**
 * This is the DAO class is used for the Event table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  08/04/2008  arege    STGAP00007353 Added findEventIdByIdCaseByCdEventStatus()
 *                       to get all the events related to a case that has pending Status.
 *  10/08/2008  arege    STGAP00010425 Modified the method findEventIdByIdCaseByCdEventStatus()
 *                       to find eventids for both the cases involved in  a merge. Changed its name to 
 *                       findEventIdByIdCaseToByIdCaseFromByCdEventStatus()
 *  04/01/2009  bgehlot  Added method findEventByIdCaseAndCdEventTypeDesc
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteEvent, deleteEventByStageDesc, updateEventByStageTaskType,
 *                       findEventByIdStageAndEventTypeAndTaskIdEventDesc
 *  12/02/2009  arege    SMS#37215 Added to find Earliest Event of given type and in given status for a given stage 
 *  02/23/2010  hnguyen  Added countEventRowsByIdStageAndCdEventTypeAndCdEventStatuses
 *                       to retrieve count of events for given stage by event type and status
 *  04/19/2010  arege    SMS#46744 Addded method updateEventByIdStageAndCdEventType 
 *  05/05/2010  arege    SMS#42496: findEventByIdStageCdEventStatusCdEventTypes
 *  05/24/2010  arege    SMS#42496: Added method findEventByIdCaseAndCdEventStatus
 *  06/02/2010  arege    SMS#54782: Added findAprvChildDeathReportByIdPersonIdStage 
 *
 * </pre>
 */

public interface EventDAO {
  /**
   * Find the first un approved WTLP for an event in a case - one is enough
   * @param idCase, idEvent
   * @return count
   */
  String findUnAprvLatestWTLP(int idCase, Collection<Integer> principalsForEvent);
  /**
   * Selects event information based on the stage id and event status, ignoring events with task ids that are passed in
   *
   * @param idStage
   * @param cdEventStatus
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Event} objects for the given criteria.
   */

  List<Event> findEventByIdStageAndCdEventStatus(int idStage, String cdEventStatus);

  /**
   * This selects a row from Event. <p/>
   *
   * @param idEventStage
   * @param cdEventType
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Event} objects for the given criteria.
   */
  Event findEventByStageAndType(int idEventStage, String cdEventType);
  /**
   * Find an event for given stage with specific type and status
   * @param idEventStage
   * @param cdEventType
   * @param cdEventStatus
   * @return
   */
  Event findEventByStageTypeAndStatus(int idEventStage, String cdEventType, String cdEventStatus);
  /**
   * This retrives all rows from the EVENT table using idStage, cdEventType and cdEventStatus
   * <p/>
   *
   * @param idStage
   * @param cdEventType1
   * @param cdEventType2
   * @param cdEventStatus
   * @return The list of @{link Event} object for the stage and type and status.
   */
  List<Event> findAllEventsByStageTypeAndStatus(int idEventStage, String cdEventType1, String cdEventType2, String cdEventStatus);
  
  /**
   * This function returns IdEvent based on idPerson
   */
  Integer findIdEventByIdEventPerson(int idPerson);
  
  
  
  List<Event> findEventWithIdStageAndCdTask(int idStage, String cdTask);

  /**
   * This will retrieve an entire row from Event given the primary key of idEvent
   *
   * @param idEvent
   * @return The first @{link Event} object for the given idEvent.
   */
  Event findEventByIdEvent(int idEvent);
  
  /**
   * Approval Status used to get Case/Stage info needed for accessed windows from Aprvl Sts.
   *
   * @param idApproval
   * @return The {@link gov.georgia.dhr.dfcs.sacwis.db.Event} object for the given idApproval.
   */
  Event findApprovalStatus(int idApproval);

  /**
   * Retrieve an Event for the specified event stage, event type and task
   *
   * @param idEventStage
   * @param cdEventType
   * @param cdTask
   * @return Event
   */
  Event findEventByIdStageAndEventTypeAndTask(int idEventStage, String cdEventType, String cdTask);
  

  /**
   * Retrieves the most recent approved Event for the specified stage, event type, and task
   * @param idEventStage
   * @param cdEventType
   * @param cdTask
   * @return Event
   */
  Event findApprovedEventByIdStageAndEventTypeAndTask(int idEventStage, String cdEventType, String cdTask);

  /**
   * This will return Event given idStage and cdTask.
   *
   * @param idStage
   * @param cdTask
   * @return keys idEvent, cdEventStatus
   */
  Map findEventByIdStageCdTask(int idStage, String cdTask);

  /**
   * This will return Event given idStage and cdTask.
   *
   * @param idStage
   * @param cdTask
   * @return keys idEvent, cdEventStatus
   */
  Map findEventByIdStageCdTaskOrderByIdEvent(int idStage, String cdTask);

  /**
   * This counts the rows in the Event Table.
   *
   * @param idCase
   * @param cdStageInvestigation
   * @return The cdEventStatus of the investigation conclusion event.
   */
  String findEventCdEventStatus(int idCase, String cdStageInvestigation);
  
  //STGAP00007353 Added method to get all the events related to a case that has pending Status.
  //STGAP00010425 Modified the method to find eventids for both the cases involved in  a merge
  //              Changed method name. 
  
  /**Find all the eventids within two Cases that have a specific event status.
   * @param idCaseTo
   * @param idCaseFrom
   * @param cdEventStatus
   * @return The List of EventIds as Integer objects. 
   */ 

   List<Integer> findEventIdByIdCaseToByIdCaseFromByCdEventStatus(int idCaseTo,int idCaseFrom, String cdEventStatus);

  /**
   * Find all the event within a case that have a specific status.
   * This will return Event and Stage given Case ID, Event Type CD and Event Status CD.
   *
   * @param idCase
   * @param cdEventStatus
   * @return keys cdEventStatus, cdEventType, idEvent, idEventPerson,idEventStage, txtEventDescr, cdStageReasonClosed,
   *         indStageClose
   */
  public Map findEventAndStageByIdCaseByCdEventStatus(int idCase, String cdEventStatus);
  
  /**
   * This will return Event and Stage given Case ID, Event Type CD and Event Status CD.
   *
   * @param idCase
   * @param cdEventType
   * @param cdEventStatus
   * @return keys cdEventStatus, cdEventType, idEvent, idEventPerson,idEventStage, txtEventDescr, cdStageReasonClosed,
   *         indStageClose
   */
  Map findEventAndStage(int idCase, String cdEventType, String cdEventStatus);

  /**
   * Gets a list of {@link gov.georgia.dhr.dfcs.sacwis.db.Event} objects for a given stage and type.
   *
   * @param idEventStage
   * @param cdEventType
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Event} objects for a given stage and type.
   */

  List<Event> findEventByIdStageAndCdEventType(int idEventStage, String cdEventType);
  
  /**
   * Gets a list of {@link gov.georgia.dhr.dfcs.sacwis.db.Event} objects for a given stage, type and statuses in the 
   * desc order by event id.
   *
   * @param idEventStage
   * @param cdEventType
   * @param 
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Event} objects for a given stage and type.
   */
  List<Event> findEventByIdStageAndCdEventTypeDesc(int idEventStage, String cdEventType, Collection<String> cdEventStatuses);

  /**
   * Retrieves an idEvent from Event table for the given cdEventType,cdEventStatus,and txtEventDescr. It is intended for
   * use by the Intake Priority/Closure retrieve service to determine whether or not a Notification to Reporter has
   * already been completed.
   *
   * @param idStage
   * @param cdEventType
   * @param cdEventStatus
   * @param txtEventDescr
   * @return The idEvent for the given criteria.
   */
  Integer findIdEventFromEvent(int idStage, String cdEventType, String cdEventStatus, String txtEventDescr);

  /**
   * This counts Event given idStage.
   *
   * @param idStage
   * @return The count of events for a given stage.
   */
  long countEventRowsByIdStage(int idStage);

  /**
   * This retrieves idPlcmtEvent from Event given idCase, idPlcmtChild, cdPlcmtActPlanned dtPlcmtStart and dtPlcmtEnd.
   *
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtPlcmtStart
   * @param dtPlcmtEnd
   * @return The given idPlcmtEvent
   */
  Map findEventIdPlcmtEventByDtPlcmtStart(int idCase, int idPlcmtChild, String cdPlcmtActPlanned, Date dtPlcmtStart,
                                              Date dtPlcmtEnd);

  /**
   * This retrieves idPlcmtEvent from Event given idCase, idPlcmtChild, cdPlcmtActPlanned, dtPlcmtStart and dtPlcmtEnd.
   *
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtPlcmtStart
   * @param dtPlcmtEnd
   * @return Finds idPlcmtEvent from Event given idCase, idPlcmtChild, cdPlcmtActPlanned, dtPlcmtStart and dtPlcmtEnd.
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findEventIdPlcmtEventByDtPlcmtStartAndEnd(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                          Date dtPlcmtStart, Date dtPlcmtEnd);

  /**
   * This retrieves idPlcmtEvent from Event given idCase, idPlcmtChild, cdPlcmtActPlanned, dtPlcmtStart
   * currDtPlcmtStart, idPlcmtEvent.
   *
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtPlcmtStart
   * @param currDtPlcmtStart
   * @param idPlcmtEvent
   * @return List of idPlacementEvents for the requested placement.
   */
  @SuppressWarnings(("unchecked"))
  List<Map> findEventIdPlcmtEventCurrDtPlcmtStartEqlGrtrDtEnd(int idCase, int idPlcmtChild,
                                                                  String cdPlcmtActPlanned, Date dtPlcmtStart,
                                                                  Date currDtPlcmtStart, int idPlcmtEvent);

  /**
   * Find a placement event ID
   *
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtCurrPlcmtEnd
   * @param dtPlcmtEnd
   * @param idPlcmtEvent
   * @return The idEvent for the placement.
   */
  @SuppressWarnings(("unchecked"))
  public List<Map> findIdPlcmtEventByCurrDtPlcmtEnd(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                        Date dtCurrPlcmtEnd, Date dtPlcmtEnd, int idPlcmtEvent);

  /**
   * Finds event status for COMP, PEND or APRV events based on idStage and cdContactType.
   *
   * @param idStage
   * @param cdContactType
   * @return The cdEventStatus for the event found.
   */
  String findEventStatus(int idStage, String cdContactType);

  /**
   * Finds event status for events based on idStage, cdContactType and the cdEventStatus passed in (which will be the
   * same as the value returned, if it is found.
   *
   * @param idStage
   * @param cdContactType
   * @param cdEventStatus
   * @return The event status.
   */
  String findEventStatus(int idStage, String cdContactType, String cdEventStatus);
  
  
  /**
   * Finds cd_event_type
   * @param idEvent
   * @return
   */
  String findCdEventTypeByIdEvent(int idEvent);

  /**
   * Finds event history for reports.
   *
   * @param idStage
   * @param cdEventType
   * @return An array of information about the event history.
   */
  List<Object[]> findEventHistory(int idStage, String cdEventType);

  /**
   * Finds event description information for reports.
   *
   * @param idStage
   * @return
   */
  List<Object[]> findEventDescriptionInformationByIdStage(int idStage);

  /**
   * Updates table Event field cdEventStatus given idStage and cdEventType.
   * <p/>
   *
   * @param cdEventStatus
   * @param idStage
   * @param cdEventType
   */
  int updateEventByIdStageCdEventType(String cdEventStatus, int idStage, String cdEventType);

  /**
   * Partial update of Event table using the supplied parameters(column values).
   *
   * @param cdEventStatus
   * @param cdEventType
   * @param idPerson
   * @param idStage
   * @param txtEventDescr
   * @param cdTask
   * @param idEvent
   * @param dtLastUpdate
   */
  int updateEvent(String cdEventStatus, String cdEventType, int idPerson, int idStage, String txtEventDescr,
                  String cdTask, int idEvent, Date dtLastUpdate);

  /**
   * Partial update of Event table using the supplied parameters(column values).
   *
   * @param cdEventStatus
   * @param cdEventType
   * @param idStage
   * @param txtEventDescr
   * @param cdTask
   * @param idEvent
   * @param dtLastUpdate
   */
  int updatePortalEvent(String cdEventStatus, String cdEventType, int idStage, String txtEventDescr,
                  String cdTask, int idEvent, Date dtLastUpdate);

  /**
   * Update Event
   *
   * @param idEvent
   * @return The number of rows updated.
   */
  int updateEvent(int idEvent);

  /**
   * Partial update of Event given idEvent and cdEventStatus.
   *
   * @param idEvent
   * @param cdEventStatus
   */
  int updateEventByIdEvent(int idEvent, String cdEventStatus);

  /**
   * Update Event
   *
   * @param idStage
   * @param cdTask
   * @param idEvent
   * @return The number of rows updated.
   */
  int updateEventByIdEventAndCdTask(int idStage, String cdTask, int idEvent);

  /**
   * Partial update of Event table using the supplied parameters(column values).
   *
   * @param cdEventStatus
   * @param idStage
   * @param cdEventType
   */
  int updateEvent(String cdEventStatus, int idStage, String cdEventType);

  /**
   * Partial update of Event given cdEventStatus, cdEventType, dtEventOccurred, idPerson, idStage, txtEventDescr,    *
   * idEvent, and dtLastUpdate.
   *
   * @param cdEventStatus
   * @param cdEventType
   * @param dtEventOccurred
   * @param idPerson
   * @param idStage
   * @param txtEventDescr
   * @param cdTask
   * @param idEvent
   * @param dtLastUpdate    return
   */
  int updateEventByIdEventAlsoDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred, int idPerson,
                                           int idStage, String txtEventDescr, String cdTask, int idEvent,
                                           Date dtLastUpdate);

  /**
   * Partial update of Event given cdEventStatus, cdEventType, dtEventOccurred, idPerson, idStage, txtEventDescr,    *
   * idEvent, and dtLastUpdate.
   *
   * @param cdEventStatus
   * @param cdEventType
   * @param dtEventOccurred
   * @param idStage
   * @param txtEventDescr
   * @param cdTask
   * @param idEvent
   * @param dtLastUpdate    return
   */
  int updatePortalEventByIdEventAlsoDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred,
                                           int idStage, String txtEventDescr, String cdTask, int idEvent,
                                           Date dtLastUpdate);
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Event} object.
   *
   * @param idEvent
   * @param dtLastUpdate
   */
  //void deleteEvent(Event event);
  int deleteEvent(int idEvent, Date dtLastUpdate);

  /**
   * Delete rows in Event based on idStage
   *
   * @param idStage
   * @return The number of rows deleted.
   */
  int deleteEvent(int idStage);
  
  int deleteAppEventByIdApproval(Collection<Integer> idApprovalList );

  /**
   * Deletes a row in the Event table by the primary key idEvent
   *
   * @param idEvent
   * @return The number of rows deleted.
   */
  int deleteEventByIdEvent(int idEvent);
  
  /**
   * Calls Hibernate method Session.delete() for given {@link gov.georgia.dhr.dfcs.sacwis.db.Event} object.
   * 
   * @param event
   */
  void deleteEvent(Event event);

  /** Save a row in the Event table */
  void saveEvent(Event event);
  
  /** Save a row in the Event table */
  int saveEventReturnsEventId(Event event);
  /**
   * This method checks to see if there are any RiskAssessments that are not in completed status for 
   * a given idStage
   * @param idStage
   * @return
   */
  
  long countCompletedRiskAssessments(int idStage);
  
  /**
   * This method returns the totalNumber of SafetyAssessments created and total number approved
   * for a given id_event_stage
   * @param idStage
   * @return
   */
  Object[] findSafetyAssessments(int idStage);
  
  /**
   * Finds event status for events based on idEvent
   * 
   * @param idEvent
   * @return The event status.
   */ 
  public String findEventCdEventStatusbyIdEvent(int idEvent);
  public Integer retrieveIdEventFromEvent(int idCase)  ;
  /**
   * find latest child detail's status for a child in a case
   * @param idPerson
   * @param idCase
   * @return
   */
  public long findCountEventByIdStageCdTask(int idStage, String cdTask);
  /**
   * This method checks count of event table where stage and cdTask equal stage and cdTask passed in 
   * @param idStage
   * @param cdTask
   * @return
   */
  public Map findLatestChildEventStatusByPersonByCase(String cdEventType, int idPerson, int idCase);
 
  /**
   * This method finds the most recent event for the give stage and event type
   * @param idEventStage
   * @param cdEventType
   * @return
   */
  public Event findLatestEventByStageAndType(int idEventStage, String cdEventType);
  
  //mxpatel added this for defect #12290
  public long countAprvEventsOfSndType( int idStage);
  
  /**
   * STGAP00012833: Retrieve the events for cdEventType and cdEventStatus by idCase
   * @param idEventCase
   * @param cdEventType
   * @param cdEventStatuses
   * @return List<Event>
   */
  public List<Event> findEventByIdCaseAndCdEventTypeDesc(int idEventCase, String cdEventType, Collection<String> cdEventStatuses);
  
  
  /** 
   * //STGAP00014341: Delete event for idStage and cdTask
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteEvent(int idStage, String cdTask);
  
  /** 
   * //STGAP00014341: Delete event for idStage and txtEventDescr
   * @param idStage
   * @param txtEventDescr
   * @param cdEventType
   * @return
   */
  int deleteEventByStageDesc(int idStage, String txtEventDescr, String cdEventType);
  
  /** 
   * //STGAP00014341: Delete event for idStage and cdTask and cdEventType
   * @param idStage
   * @param cdTask
   * @param cdEventType
   * @return
   */
  int updateEventByStageTaskType(int idStage, String cdTask, String cdEventType);
  
  /** 
   * //STGAP00014341: find the latest event for idStage and cdTask and cdEventType
   * @param idEventStage
   * @param cdEventType
   * @param cdTask
   * @return
   */
  Event findEventByIdStageAndEventTypeAndTaskIdEventDesc(int idEventStage, String cdEventType, String cdTask);
  
 // SMS#37215 Added to find Earliest Event of given type and in given status for a given stage
  /**
   * 
   * @param idEventStage
   * @param cdEventType
   * @param cdEventStatus
   * @return
   */
  Event findEarliestEventByStageTypeAndStatus(int idEventStage, String cdEventType, String cdEventStatus);
  
  /**
   * 
   * @param idEventStage
   * @param cdEventType
   * @param cdEventStatuses
   * @return long - count of events for given stage, event type, and event statuses
   */
  public long countEventRowsByIdStageAndCdEventTypeAndCdEventStatuses(int idEventCase, String cdEventType,
                                                                      Collection<String> cdEventStatuses);
  
  /**
   * Updates the event table with idCase for a given idStage and cdEventType
   * @param idCase
   * @param idStage
   * @param cdEventType
   * @return
   */
  public int updateEventByIdStageAndCdEventType( int idCase , int idStage, String cdEventType);
  
/**
 * Find list of Events in Pending status by given event types and event status
 * @param idStage
 * @param cdEventTypes
 * @param cdEventStatuses
 * @return
 */
  public List<Event> findEventByIdStageCdEventStatusCdEventTypes(int idStage, Collection<String> cdEventTypes, Collection<String> cdEventStatuses);

  
  /**
   * Selects event information based on the idCase and event status
   *
   * @param idCase
   * @param cdEventStatus
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Event} objects for the given criteria.
   */

  List<Event> findEventByIdCaseAndCdEventStatus(int idCase, Collection<String> cdEventStatus);
  
  /**
   * 
   * @param idPerson
   * @param idEventStage
   * @param cdEventStatus   
   * @return
   */
  public List<Event> findAprvChildDeathReportByIdPersonIdStage(int idPerson, int idEventStage, Collection<String> cdEventStatus); 

}
