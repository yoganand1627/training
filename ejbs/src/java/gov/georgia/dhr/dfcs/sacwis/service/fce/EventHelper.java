package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   11/07/08  wjcochran STGAP00010990 - added a check for stage type, depending on the value
 *                              would change the Eligibility task code, a previously hard coded value
 *   12/01/10  hnguyen   SMS#81144: Added new method to update FCE event description based on type
 *   12/14/10  hnguyen   SMS#81144: Corrected logic with getting event description.
 *   12/14/10  hnguyen   SMS#86018: Corrected FCEA event description.
 *   12/28/10  hnguyen   SMS#86018: Increased event description length from 80 to 100.
 *   01/03/10  hnguyen   SMS#86018: Updated FCEA event description to fit event list display.
 * </pre>
 */
public class EventHelper implements Serializable {
  public static final String LEGACY_FCE_APPLICATION_TASK_CODE = "3100";
  public static final String LEGACY_FCE_REVIEW_TASK_CODE = "3110";

  public static final String FCE_APPLICATION_EVENT_TYPE = "FCA";
  public static final String FCE_APPLICATION_TASK_CODE = "3430";

  public static final String FCE_ELIGIBILITY_EVENT_TYPE = "FCD";
  public static final String FCE_ELIGIBILITY_TASK_CODE = "3120";

  public static final String FCE_REVIEW_EVENT_TYPE = "FCR";
  public static final String FCE_REVIEW_TASK_CODE = "3440";

  public static final String ELIG_DETERM_ADO = "8620";
  public static final String ELIG_DETERM_PAD = "9110";

  public static final String NEW_EVENT = CodesTables.CEVTSTAT_NEW;
  public static final String APPROVED_EVENT = CodesTables.CEVTSTAT_APRV;
  public static final String COMPLETE_EVENT = CodesTables.CEVTSTAT_COMP;
  public static final String PENDING_EVENT = CodesTables.CEVTSTAT_PEND;
  public static final String PROCESS_EVENT = CodesTables.CEVTSTAT_PROC;

  public static final String STAGE_ADO = "ADO";
  public static final String STAGE_PAD = "PAD";
  
  private static final String COMPLETE_TODO_SQL = "update todo \n" +
                                                  "set dt_todo_completed = sysdate \n" +
                                                  "where id_todo_event = ? \n";
  private static final String HAS_LEGACY_EVENTS_SQL = "select count(*) \n" +
                                                      "from event \n" +
                                                      "where cd_task in ('" + LEGACY_FCE_APPLICATION_TASK_CODE + "', " +
                                                      "                  '" + LEGACY_FCE_REVIEW_TASK_CODE + "') \n" +
                                                      "  and id_event_stage = ? \n";
  private static final String COUNT_COMPLETE_EVENTS_SQL = "select count(*) from event " +
                                                          "where id_event_stage = ? \n" +
                                                          "  and cd_task = ? \n" +
                                                          "  and cd_event_status != '" + APPROVED_EVENT + "' \n";
  private static final String SELECT_EVENT_BY_ID_SQL = "select * from event where id_event = ?";
  private static final String COUNT_UNAPPROVED_EVENTS_SQL =
          "select count(*) from event where id_event_stage = ? and cd_task = ? and cd_event_status != '" + APPROVED_EVENT + "' \n";
  private static final String COUNT_UNAPPROVED_OR_NONENDDATED_EVENTS_SQL = "select count(*) from event e, eligibility el " + 
                                                                           "  where e.id_event_stage = ? and e.cd_task = ? \n" +
                                                                           "  and e.id_event = el.id_elig_event \n" +
                                                                           "  and (e.cd_event_status != '" + APPROVED_EVENT + "' \n" +
                                                                           "       or (e.cd_event_status = '" + APPROVED_EVENT + "' \n" +
                                                                           "       and el.dt_elig_end = to_date('12/31/4712', 'mm/dd/yyyy'))) \n";
  private static final String UPDATE_TODO_SQL = "update todo \n" +
                                                "set id_todo_event = ? \n" +
                                                "where id_todo_stage = ? \n" +
                                                "and cd_todo_task = ?" +
                                                "and id_todo_event is null";
  private static final String UPDATE_FCE_ELIGIBILITY_ID_PERSON_SQL =
          "update fce_eligibility set id_fce_person = null, " +
          "id_fce_application = null where id_fce_eligibility = ? \n";
  private static final String DELETE_FCE_PERSON_SQL_BY_ID_FCE_ELIGIBILITY_SQL =
          "delete from fce_person where id_fce_eligibility = ? \n";
  private static final String DELETE_FCE_APPLICATION_BY_ID_EVENT_SQL =
          "delete from fce_application where id_event = ? " +
          "and cd_application in ('" + FceConstants.CAPS + "', '" + FceConstants.NEW_TO_SUBCARE + "') \n";
  private static final String DELETE_FCE_REASON_NOT_ELIGIBILIE_BY_ID_FCE_ELIGIBILITY_SQL =
          "delete from fce_reason_not_eligible where id_fce_eligibility = ? \n";
  private static final String DELETE_FCE_ELIGIBILITY_BY_ID_FCE_ELIGIBILITY_SQL =
          "delete from fce_eligibility where id_fce_eligibility = ? \n";
  private static final String DELETE_EVENT_BY_ID_EVENT_SQL = "delete from event where id_event = ? \n";
  private static final String COUNT_COMPLETE_FCR_EVENTS_SQL = "select count(*) from event " +
                                                              "where id_event_stage = ? \n" +
                                                              "  and cd_task = ? \n" +
                                                              "  and ( cd_event_status = '" + NEW_EVENT + "' \n" +
                                                              "  or cd_event_status = '" + PROCESS_EVENT + "' \n" +
                                                              "  or cd_event_status = '" + PENDING_EVENT + "' \n" +
                                                              "  or cd_event_status = '" + COMPLETE_EVENT + "' )\n" ;

  private static final String CHECK_STAGE_TYPE = "select cd_stage from stage " +
  		                                  "where id_stage = ? \n";
  
  private static final String COUNT_APPROVED_EVENTS_SQL = "select count(*) from event " + "where id_event_stage = ? \n"
                                                          + "  and cd_task = ? \n" + "  and cd_event_status = '"
                                                          + APPROVED_EVENT + "' \n";

  private static final String CHECK_FCEA_TYPE = "select cd_application, ind_amended_app from fce_application " + "where id_event = ? \n";

  protected static void completeTodosForEventId(Connection connection, long idEvent) throws SQLException {
    //copied from cinv43d.pc
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(COMPLETE_TODO_SQL);
      preparedStatement.setLong(1, idEvent);
      preparedStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static boolean hasLegacyEvents(Connection connection, long idStage) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(HAS_LEGACY_EVENTS_SQL);
      preparedStatement.setLong(1, idStage);
      long count = SqlHelper.selectLong(preparedStatement);
      return (count > 0);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static EventDB findOrCreateEvent(PostEvent postEvent, Connection connection, String eventType, long idEvent,
                                             long idPerson, long idStage)
          throws EjbValidationException, SQLException {
    if (idEvent != 0) {
      return findEvent(connection, idEvent);
    }
    idEvent = createEvent(postEvent, connection, eventType, idPerson, idStage);
    return findEvent(connection, idEvent);
  }

  protected static void changeEventStatus(PostEvent postEvent, Connection connection, long idEvent, String eventStatusWas,
                                       String eventStatusWillBe)
          throws SQLException {
    changeEventStatus(postEvent, connection, idEvent, eventStatusWas, eventStatusWillBe, null);
  }

  private static void changeEventStatus(PostEvent postEvent, Connection connection, long idEvent, String eventStatusWas,
                                       String eventStatusWillBe, String description)
          throws SQLException {
    Set<String> hashSet = new HashSet<String>();
    hashSet.add(eventStatusWas);
    changeEventStatus(postEvent, connection, idEvent, hashSet, eventStatusWillBe, description);
  }

  protected static void changeEventStatus(PostEvent postEvent, Connection connection, long idEvent,
                                       Set<String> eventStatusWas, String eventStatusWillBe, String description)
          throws SQLException {
    FceHelper.verifyNonZero("idEvent", idEvent);
    EventDB eventDB = findEvent(connection, idEvent);
    if (description == null) {
//      description = getDescription(eventDB.getCdTask(), eventStatusWillBe);
      description = getDescription(connection, eventDB, eventStatusWillBe);
    }
    eventDB.setTxtEventDescr(description);
    changeEventStatus(postEvent, eventDB, eventStatusWas, eventStatusWillBe);
  }

  private static String getDescription(String taskCode, String eventStatus) {
    Map<String, String> eventMap = new HashMap<String, String>();
    if (taskCode.equals(FCE_APPLICATION_TASK_CODE)) {
      eventMap.put(NEW_EVENT, "Initial Application has been opened, but has not been saved.");
      eventMap.put(PROCESS_EVENT, "Initial Application has been saved, but has not been submitted.");
      eventMap.put(PENDING_EVENT, "Initial Application has been submitted on " + DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT));
      eventMap.put(COMPLETE_EVENT, "Initial Application was completed, but system-derived eligibility determination is not confirmed.");
      eventMap.put(APPROVED_EVENT, "Initial Application was completed and system-derived eligibility determination is confirmed.");
    } else if (taskCode.equals(FCE_ELIGIBILITY_TASK_CODE) || taskCode.equals(ELIG_DETERM_ADO) || taskCode.equals(ELIG_DETERM_PAD)) {
      eventMap.put(NEW_EVENT, "Eligibility Determination");
    } else if (taskCode.equals(FCE_REVIEW_TASK_CODE)) {
      eventMap.put(NEW_EVENT, "Reimbursability Determination has been opened but has not been saved.");
      eventMap.put(PROCESS_EVENT, "Reimbursability Determination is in progress.");
      eventMap.put(PENDING_EVENT, "Reimbursability Determination has been assigned on " + DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT));
      eventMap.put(COMPLETE_EVENT, "Reimbursability Determination was completed.");
      eventMap.put(APPROVED_EVENT, "Reimbursability Determination was reviewed and system-derived determination is confirmed.");
    } else {
      throw new IllegalArgumentException("Invalid task code: " + taskCode);
    }
    String description = eventMap.get(eventStatus);
    if (description == null) {
      throw new IllegalStateException("Unexpected eventStatus '" + eventStatus + "' " +
                                      "for taskCode '" + taskCode + "'");
    }
    final int eventDescriptionColumnLimit = 100;
    if (description.length() > eventDescriptionColumnLimit) {
      description = description.substring(0, eventDescriptionColumnLimit);
    }
    return description;
  }

  private static void changeEventStatus(PostEvent postEvent, EventDB eventDB, Set<String> eventStatusWas,
                                       String eventStatusWillBe) {
    String currentEventStatus = eventDB.getCdEventStatus();
    if (eventStatusWas.contains(currentEventStatus) == false) {
      return;
    }
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn01ui.setArchInputStruct(archInputStruct);
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    rowccmn01uig00.setUlIdEvent((int) eventDB.getIdEvent());
    rowccmn01uig00.setTsLastUpdate(eventDB.getDtLastUpdate());
    rowccmn01uig00.setUlIdStage((int) eventDB.getIdEventStage());
    rowccmn01uig00.setSzCdEventType(eventDB.getCdEventType());
    rowccmn01uig00.setUlIdPerson((int) eventDB.getIdEventPerson());
    rowccmn01uig00.setSzCdTask(eventDB.getCdTask());
    rowccmn01uig00.setSzTxtEventDescr(eventDB.getTxtEventDescr());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new java.util.Date()));
    rowccmn01uig00.setSzCdEventStatus(eventStatusWillBe);
    audEvent(postEvent, ccmn01ui);
  }

  protected static int createEvent(PostEvent postEvent, Connection connection, String eventType, long idPerson,
                                long idStage)
          throws EjbValidationException, SQLException {
    if (eventType.equals(FCE_APPLICATION_EVENT_TYPE)) {
      return createApplicationEvent(postEvent, connection, idPerson, idStage);
    }
    if (eventType.equals(FCE_ELIGIBILITY_EVENT_TYPE)) {
      return createEligibilityEvent(postEvent, connection, idPerson, idStage);
    }
    if (eventType.equals(FCE_REVIEW_EVENT_TYPE)) {
      return createReviewEvent(postEvent, connection, idPerson, idStage);
    }
    throw new IllegalStateException("unexpected eventType: " + eventType);
  }

  private static int createApplicationEvent(PostEvent postEvent, Connection connection, long idPerson, long idStage)
          throws SQLException {
    String description = getDescription(FCE_APPLICATION_TASK_CODE, NEW_EVENT);
    CCMN01UI ccmn01ui = createCCMN01UI(idPerson, idStage, FCE_APPLICATION_EVENT_TYPE, FCE_APPLICATION_TASK_CODE,
                                       description);
    associatePrimaryChildToEvent(connection, ccmn01ui, idStage);
    return audEvent(postEvent, ccmn01ui);
  }

  private static int createEligibilityEvent(PostEvent postEvent, Connection connection, long idPerson, long idStage)
          throws EjbValidationException, SQLException {
    // STGAP00010990 - Added a check for the stage Type to determine the task code,
    // which was previously hard coded for the Foster Care stage
    String stageType = checkStageType(connection, idStage);
    String taskCode = FCE_ELIGIBILITY_TASK_CODE;
    if (STAGE_ADO.equals(stageType)) {
      taskCode = ELIG_DETERM_ADO;
    } else if (STAGE_PAD.equals(stageType)) {
      taskCode = ELIG_DETERM_PAD;
    }
    long incompleteEligibilityEvents = countIncompleteEvents(connection, taskCode, idStage);
    // There can be only 1 incomplete EligibilityEvent at a time;
    if (incompleteEligibilityEvents > 0) {
      throw new EjbValidationException(Messages.MSG_OPEN_SUMMARY_EVENT, BasePrsException.WARNING_PRIORITY);
    }
    String description = getDescription(taskCode, NEW_EVENT);
    CCMN01UI ccmn01ui = createCCMN01UI(idPerson, idStage, FCE_ELIGIBILITY_EVENT_TYPE, taskCode,
                                       description);
    // NOTE: 08/14/2003, Matthew McClain: I do not set the child's id on NEW eligibility event because
    //  it would break the update service.
    return audEvent(postEvent, ccmn01ui);
  }

  private static int createReviewEvent(PostEvent postEvent, Connection connection, long idPerson, long idStage)
          throws SQLException {
    String description = getDescription(FCE_REVIEW_TASK_CODE, NEW_EVENT);
    CCMN01UI ccmn01ui = createCCMN01UI(idPerson, idStage, FCE_REVIEW_EVENT_TYPE, FCE_REVIEW_TASK_CODE, description);
    associatePrimaryChildToEvent(connection, ccmn01ui, idStage);
    return audEvent(postEvent, ccmn01ui);
  }

  private static CCMN01UI createCCMN01UI(long idPerson, long idStage, String eventType, String taskCode,
                                           String eventDescription) {
    if (idStage > Integer.MAX_VALUE) {
      throw new IllegalStateException("idStage too big: " + idStage);
    }
    if (idPerson > Integer.MAX_VALUE) {
      throw new IllegalStateException("idPerson too big: " + idPerson);
    }
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn01ui.setArchInputStruct(archInputStruct);
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    rowccmn01uig00.setUlIdStage((int) idStage);
    rowccmn01uig00.setSzCdEventType(eventType);
    rowccmn01uig00.setUlIdPerson((int) idPerson);
    rowccmn01uig00.setSzCdTask(taskCode);
    rowccmn01uig00.setSzTxtEventDescr(eventDescription);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new java.util.Date()));
    rowccmn01uig00.setSzCdEventStatus(NEW_EVENT);
    return ccmn01ui;
  }

  private static void associatePrimaryChildToEvent(Connection connection, CCMN01UI ccmn01ui, long idStage)
          throws SQLException {
    ROWCCMN01UIG00 rowccmn01uig00 = ccmn01ui.getROWCCMN01UIG00();
    // Find PrimaryChild for stage and associate with the event so the child shows up on event list.
    long idChild = PersonHelper.findPrimaryChildForStage(connection, idStage);
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    rowccmn01uig01.setUlIdPerson((int) idChild);
    rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    rowccmn01uig01_array.setUlRowQty(rowccmn01uig01_array.getROWCCMN01UIG01Count());
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
  }

  private static int audEvent(PostEvent postEvent, CCMN01UI ccmn01ui) {
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    return ccmn01uo.getUlIdEvent();
  }

  //Note: wouldn't suggest using with anything other than
  //FCE_ELIGIBILITY_TASK_CODE or FCE_REVIEW_TASK_CODE
  protected static long countIncompleteEvents(Connection connection, String taskCode, long idStage)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(COUNT_COMPLETE_EVENTS_SQL);
      preparedStatement.setLong(1, idStage);
      preparedStatement.setString(2, taskCode);
      return SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  @SuppressWarnings({"deprecation"})
  protected static EventDB findEvent(Connection connection, long eventId) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(SELECT_EVENT_BY_ID_SQL);
      preparedStatement.setLong(1, eventId);
      List list = SqlHelper.createListFromQuery(preparedStatement);
      Map map = null;
      if (listIsValid(list)) {
        map = (Map) list.get(0);
      }
      return toEventDB(map);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  private static boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }

  private static EventDB toEventDB(Map map) {
    EventDB eventDB = new EventDB();
    EventDB.populateWithMap(eventDB, map);
    return eventDB;
  }

  protected static void deleteFceEligibility(Connection connection, long idFceEligibility, long idEligibilityEvent)
          throws SQLException {
    PreparedStatement updateFceEligibilityStatement = null;
    try {
      updateFceEligibilityStatement = connection.prepareStatement(UPDATE_FCE_ELIGIBILITY_ID_PERSON_SQL);
      updateFceEligibilityStatement.setLong(1, idFceEligibility);
      updateFceEligibilityStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(updateFceEligibilityStatement);
    }

    PreparedStatement deleteFcePersonStatement = null;
    try {
      deleteFcePersonStatement = connection.prepareStatement(DELETE_FCE_PERSON_SQL_BY_ID_FCE_ELIGIBILITY_SQL);
      deleteFcePersonStatement.setLong(1, idFceEligibility);
      deleteFcePersonStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(deleteFcePersonStatement);
    }

    //Delete the shell application that may have been created.
    PreparedStatement deleteFceApplicationStatement = null;
    try {
      deleteFceApplicationStatement = connection.prepareStatement(DELETE_FCE_APPLICATION_BY_ID_EVENT_SQL);
      deleteFceApplicationStatement.setLong(1, idEligibilityEvent);
      deleteFceApplicationStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(deleteFceApplicationStatement);
    }

    PreparedStatement deleteFceReasonNotEligibileStatement = null;
    try {
      deleteFceReasonNotEligibileStatement =
              connection.prepareStatement(DELETE_FCE_REASON_NOT_ELIGIBILIE_BY_ID_FCE_ELIGIBILITY_SQL);
      deleteFceReasonNotEligibileStatement.setLong(1, idFceEligibility);
      deleteFceReasonNotEligibileStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(deleteFceReasonNotEligibileStatement);
    }

    PreparedStatement deleteFceEligibilityStatement = null;
    try {
      deleteFceEligibilityStatement = connection.prepareStatement(DELETE_FCE_ELIGIBILITY_BY_ID_FCE_ELIGIBILITY_SQL);
      deleteFceEligibilityStatement.setLong(1, idFceEligibility);
      deleteFceEligibilityStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(deleteFceEligibilityStatement);
    }

    PreparedStatement deleteEventStatement = null;
    try {
      deleteEventStatement = connection.prepareStatement(DELETE_EVENT_BY_ID_EVENT_SQL);
      deleteEventStatement.setLong(1, idEligibilityEvent);
      deleteEventStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(deleteEventStatement);
    }
  }

  protected static void attachEventToTodo(Connection connection, long eventId, long stageId, String cdTask)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(UPDATE_TODO_SQL);
      preparedStatement.setLong(1, eventId);
      preparedStatement.setLong(2, stageId);
      preparedStatement.setString(3, cdTask);
      preparedStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  public static long countUnApprovedEvents(Connection connection, String taskCode, long idStage) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      // Eligibility Summaries can be 'Approved' and still be open as long as it's not end dated
      if (FCE_ELIGIBILITY_TASK_CODE != taskCode) {
        preparedStatement = connection.prepareStatement(COUNT_UNAPPROVED_EVENTS_SQL);
      } else {
        preparedStatement = connection.prepareStatement(COUNT_UNAPPROVED_OR_NONENDDATED_EVENTS_SQL);
      }
      preparedStatement.setLong(1, idStage);
      preparedStatement.setString(2, taskCode);
      return SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }
  
  protected static long countIncompleteFosterCareReviewEvents(Connection connection, String taskCode, long idStage)
  throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(COUNT_COMPLETE_FCR_EVENTS_SQL);
      preparedStatement.setLong(1, idStage);
      preparedStatement.setString(2, taskCode);
      return SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
}
  
  public static long countApprovedEvents(Connection connection, String taskCode, long idStage) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(COUNT_APPROVED_EVENTS_SQL);
      preparedStatement.setLong(1, idStage);
      preparedStatement.setString(2, taskCode);
      return SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }
  
  /**
   * This method will take in a stage ID and retrieve the stage type
   * for that stage
   * @param connection
   * @param idStage
   * @return
   */
  public static String checkStageType(Connection connection, long idStage) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(CHECK_STAGE_TYPE);
      preparedStatement.setLong(1, idStage);
      return SqlHelper.selectString(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  private static String getDescription(Connection connection, EventDB eventDB, String eventStatus) throws SQLException {
    Map<String, String> eventMap = new HashMap<String, String>();
    String taskCode = eventDB.getCdTask();
    String cdApplication = null;
    boolean indAmended = false;
    
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    try {
      preparedStatement = connection.prepareStatement(CHECK_FCEA_TYPE);
      preparedStatement.setLong(1, eventDB.getIdEvent());
      preparedStatement.execute();
      resultSet = preparedStatement.getResultSet();
      
      while( resultSet.next() ){
        cdApplication = resultSet.getString("CD_APPLICATION");
        indAmended = "Y".equals(resultSet.getString("IND_AMENDED_APP"));
      }
      
    } finally {
      if( resultSet != null){
        resultSet.close();
      }
      if(preparedStatement != null){
        preparedStatement.close();
      }
    }
    
    if (FCE_APPLICATION_TASK_CODE.equals(taskCode)) {
      if( CodesTables.CFCEAPRE_A.equals(cdApplication) && !indAmended){
        eventMap.put(NEW_EVENT, "Initial Application has been opened but has not been saved.");
        eventMap.put(PROCESS_EVENT, "Initial Application has been saved, but has not been submitted.");
        eventMap.put(PENDING_EVENT, "Initial Application has been submitted on " + DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT));
        eventMap.put(COMPLETE_EVENT, "Initial Application was completed, but system-derived eligibility determination is not confirmed.");
        eventMap.put(APPROVED_EVENT, "Initial Application was completed and system-derived eligibility determination is confirmed.");
      } else if ( CodesTables.CFCEAPRE_A.equals(cdApplication) && indAmended){
        eventMap.put(NEW_EVENT, "Amended Application has been opened but has not been saved.");
        eventMap.put(PROCESS_EVENT, "Amended Application has been saved, but has not been submitted.");
        eventMap.put(PENDING_EVENT, "Amended Application has been submitted on " + DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT));
        eventMap.put(COMPLETE_EVENT, "Amended Application was completed, but system-derived eligibility determination is not confirmed.");
        eventMap.put(APPROVED_EVENT, "Amended Application was completed and system-derived eligibility determination is confirmed.");
      } else  if ( CodesTables.CFCEAPRE_R.equals(cdApplication)){
        eventMap.put(NEW_EVENT, "Notification of Change has been opened but has not been saved.");
        eventMap.put(PROCESS_EVENT, "Notification of Change has been saved, but has not been submitted.");
        eventMap.put(PENDING_EVENT, "Notification of Change has been submitted on " + DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT));
        eventMap.put(COMPLETE_EVENT, "Notification of Change was completed, but system-derived eligibility determination is not confirmed.");
        eventMap.put(APPROVED_EVENT, "Notification of Change was completed and system-derived eligibility determination is confirmed.");
      }
    } else if (FCE_ELIGIBILITY_TASK_CODE.equals(taskCode) || ELIG_DETERM_ADO.equals(taskCode) || ELIG_DETERM_PAD.equals(taskCode)) {
      eventMap.put(NEW_EVENT, "Eligibility Determination");
    } else if (FCE_REVIEW_TASK_CODE.equals(taskCode)) {
      eventMap.put(NEW_EVENT, "Reimbursability Determination has been opened but has not been saved.");
      eventMap.put(PROCESS_EVENT, "Reimbursability Determination is in progress.");
      eventMap.put(PENDING_EVENT, "Reimbursability Determination has been assigned on " + DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT));
      eventMap.put(COMPLETE_EVENT, "Reimbursability Determination was completed.");
      eventMap.put(APPROVED_EVENT, "Reimbursability Determination was reviewed and system-derived determination is confirmed.");
    } else {
      throw new IllegalArgumentException("Invalid task code: " + taskCode);
    }
    String description = eventMap.get(eventStatus);
    if (description == null) {
      throw new IllegalStateException("Unexpected eventStatus '" + eventStatus + "' " +
                                      "for taskCode '" + taskCode + "'");
    }
    final int eventDescriptionColumnLimit = 100;
    if (description.length() > eventDescriptionColumnLimit) {
      description = description.substring(0, eventDescriptionColumnLimit);
    }
    
    return description;
  }

}

