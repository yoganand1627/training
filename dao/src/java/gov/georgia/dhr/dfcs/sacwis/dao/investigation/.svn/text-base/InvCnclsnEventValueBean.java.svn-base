package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

/**
 * Holds all data pertaining to an Investigation Conclusion Event.
 *
 * @author Jason Rios, December 3, 2002
 */
public class InvCnclsnEventValueBean extends BaseValueBean {
  // Instance Variables
  private int caseId;
  private int stageId;
  private int eventId;
  private int personId;
  private Date dateLastUpdate;
  private Date dateEventOccurred;
  private String eventType;
  private String taskCode;
  private String eventDescription;
  private String eventStatus;

  // Constants
  public static final int RISK_ASSESSMENT_DATA = 1;
  public static final int PAGE_CREATION_DATA_ONLY = 2;

  // Tracing
  private static final String TRACE_TAG = "InvCnclsnEventValueBean";

  public InvCnclsnEventValueBean() {
    caseId = 0;
    stageId = 0;
    eventId = 0;
    personId = 0;
    dateLastUpdate = null;
    dateEventOccurred = null;
    eventType = null;
    taskCode = null;
    eventDescription = null;
    eventStatus = null;
  }

  /** Constructor that builds the bean from the ResultSet retrieved from the database */
  public InvCnclsnEventValueBean(ResultSet results) throws DaoException {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    try {
      this.setCaseId(results.getInt(InvCnclsnDAO.CASE_ID_COLUMN));
      this.setStageId(results.getInt(InvCnclsnDAO.STAGE_ID_COLUMN));
      this.setEventId(results.getInt(InvCnclsnDAO.EVENT_ID_COLUMN));
      this.setPersonId(results.getInt(InvCnclsnDAO.EVENT_PERSON_ID_COLUMN));
      this.setDateLastUpdate(results.getTimestamp(InvCnclsnDAO.EVENT_DATE_LAST_UPDATE_COLUMN));
      this.setEventStatus(results.getString(InvCnclsnDAO.EVENT_STATUS_COLUMN));
      this.setEventType(results.getString(InvCnclsnDAO.EVENT_TYPE_COLUMN));
      this.setTaskCode(results.getString(InvCnclsnDAO.EVENT_TASK_CODE_COLUMN));
      this.setEventDescription(results.getString(InvCnclsnDAO.EVENT_DESCRIPTION_COLUMN));
      this.setDateEventOccurred(results.getTimestamp(InvCnclsnDAO.DATE_EVENT_OCCURRED_COLUMN));
    }
    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to InvCnclsnEventValueBean.");
      throw new DaoException("Exception translating ResultSet to InvCnclsnEventValueBean", e, 7);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Retrieves the Case Id for this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Case Id
   */
  public int getCaseId() {
    return caseId;
  }

  /**
   * Retrieves the Date this Investigation Conclusion Event occurred
   *
   * @ return Investigation Conclusion Event Date Occurred
   */
  public Date getDateEventOccurred() {
    return dateEventOccurred;
  }

  /**
   * Retrieves the Date this Investigation Conclusion Event was last updated
   *
   * @ return Investigation Conclusion Event Date Last Update
   */
  public Date getDateLastUpdate() {
    return dateLastUpdate;
  }

  /**
   * Retrieves the Event Description for this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Description
   */
  public String getEventDescription() {
    return eventDescription;
  }

  /**
   * Retrieves the Event Id for this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Id
   */
  public int getEventId() {
    return eventId;
  }

  /**
   * Retrieves the Status of this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Status
   */
  public String getEventStatus() {
    return eventStatus;
  }

  /**
   * Retrieves the Event Type for this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Type
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * Retrieves the Person Id for this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Person Id
   */
  public int getPersonId() {
    return personId;
  }

  /**
   * Retrieves the Stage Id for this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Stage Id
   */
  public int getStageId() {
    return stageId;
  }

  /**
   * Retrieves the Task Code for this Investigation Conclusion Event
   *
   * @ return Investigation Conclusion Event Task Code
   */
  public String getTaskCode() {
    return taskCode;
  }

  /**
   * Sets the Case Id for this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Case Id
   */
  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  /**
   * Set the Date this Investigation Conclusion Event occurred
   *
   * @ param Investigation Conclusion Event Date Occurred
   */
  public void setDateEventOccurred(Date dateEventOccurred) {
    this.dateEventOccurred = dateEventOccurred;
  }

  /**
   * Sets the Date this Investigation Conclusion Event was last updated
   *
   * @ param Investigation Conclusion Event Date Last Update
   */
  public void setDateLastUpdate(Date dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  /**
   * Sets the Event Description for this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Description
   */
  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  /**
   * Sets the Event Id for this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Id
   */
  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  /**
   * Sets the Status of this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Status
   */
  public void setEventStatus(String eventStatus) {
    this.eventStatus = eventStatus;
  }

  /**
   * Sets the Event Type for this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Type
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  /**
   * Sets the Person Id for this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Person Id
   */
  public void setPersonId(int personId) {
    this.personId = personId;
  }

  /**
   * Sets the Stage Id for this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Stage Id
   */
  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  /**
   * Sets the Task Code for this Investigation Conclusion Event
   *
   * @ param Investigation Conclusion Event Task Code
   */
  public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
  }

  /**
   * Returns a string of variable names and values
   *
   * @ return String
   */
  public String toString() {
    return "\n" +
           "InvCnclsnEventValueBean \n" +
           "  caseId = " + caseId + "\n" +
           "  stageId = " + stageId + "\n" +
           "  eventId = " + eventId + "\n" +
           "  personId = " + personId + "\n" +
           "  dateLastUpdate = " + dateLastUpdate + "\n" +
           "  dateEventOccurred = " + dateEventOccurred + "\n" +
           "  eventType = " + eventType + "\n" +
           "  taskCode = " + taskCode + "\n" +
           "  eventDescription = " + eventDescription + "\n" +
           "  eventStatus = " + eventStatus + "\n" +
           "end InvCnclsnEventValueBean \n";
  }
}
