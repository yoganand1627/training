package gov.georgia.dhr.dfcs.sacwis.dao.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

/**
 * Holds all data pertaining to an Event.
 *
 * @author Jason Rios, February 5, 2003
 */
public class EventValueBean extends BaseValueBean {
  private int caseId;
  private int stageId;
  private int eventId;
  private String stageCode;
  private Date dateLastUpdate;
  private String eventTypeCode;
  private String eventTaskCode;
  private String eventDescription;
  private Date dateEventOccurred;
  private String eventStatusCode;
  private int personId;
  private int approvalId;
  private Date approvalDateLastUpdate;
  private int approvalPersonId;
  private String approvalTopic;
  private Date approvalDate;
  private String creatorsFirstName;
  private String creatorsLastName;

  private static final String TRACE_TAG = "EventValueBean";

  /** Constructor */
  public EventValueBean() {
  }

  /**
   * Constructor that builds the object with the given params.
   *
   * @param caseId  The id of the case in which this event was created.
   * @param stageId The id of the stage in which this event was created.
   * @param eventId The id of this event.
   */
  public EventValueBean(int caseId, int stageId, int eventId) {
    this();
    this.caseId = caseId;
    this.stageId = stageId;
    this.eventId = eventId;
  }

  /**
   * Constructor that builds the bean from the ResultSet from a full-row retrieval from the EVENT table.
   *
   * @param results ResultSet from a full-row retrieval of the EVENT table.
   */
  public EventValueBean(ResultSet results)
          throws DaoException {
    this();

    try {
      this.setEventId(results.getInt("ID_EVENT"));
      this.setDateLastUpdate(results.getTimestamp("DT_LAST_UPDATE"));
      this.setStageId(results.getInt("ID_EVENT_STAGE"));
      this.setEventTypeCode(results.getString("CD_EVENT_TYPE"));
      this.setStageCode(results.getString("CD_STAGE"));

      // Set the following bean properties to the corresponding values retrieved
      // from the database only if the values from the database are not null.
      if (results.getInt("ID_CASE") > 0) {
        this.setCaseId(results.getInt("ID_CASE"));
      }
      if (results.getInt("ID_EVENT_PERSON") > 0) {
        this.setPersonId(results.getInt("ID_EVENT_PERSON"));
      }
      if (results.getString("CD_TASK") != null) {
        this.setEventTaskCode(results.getString("CD_TASK"));
      }
      if (results.getString("TXT_EVENT_DESCR") != null) {
        this.setEventDescription(results.getString("TXT_EVENT_DESCR"));
      }
      if (results.getTimestamp("DT_EVENT_OCCURRED") != null) {
        this.setDateEventOccurred(results.getTimestamp("DT_EVENT_OCCURRED"));
      }
      if (results.getString("CD_EVENT_STATUS") != null) {
        this.setEventStatusCode(results.getString("CD_EVENT_STATUS"));
      }
    }
    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to EventValueBean.");
      throw new DaoException("Exception translating ResultSet to EventValueBean", e, 7);
    }
    GrndsTrace.exitScope();
  }

  public int getCaseId() {
    return caseId;
  }

  public Date getDateEventOccurred() {
    return dateEventOccurred;
  }

  public Date getDateLastUpdate() {
    return dateLastUpdate;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public int getEventId() {
    return eventId;
  }

  public String getEventStatusCode() {
    return eventStatusCode;
  }

  public String getEventTaskCode() {
    return eventTaskCode;
  }

  public String getEventTypeCode() {
    return eventTypeCode;
  }

  public int getPersonId() {
    return personId;
  }

  public int getStageId() {
    return stageId;
  }

  public Date getApprovalDate() {
    return approvalDate;
  }

  public Date getApprovalDateLastUpdate() {
    return approvalDateLastUpdate;
  }

  public int getApprovalId() {
    return approvalId;
  }

  public int getApprovalPersonId() {
    return approvalPersonId;
  }

  public String getApprovalTopic() {
    return approvalTopic;
  }

  public String getCreatorsFirstName() {
    return creatorsFirstName;
  }

  public String getCreatorsLastName() {
    return creatorsLastName;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public void setDateEventOccurred(Date dateEventOccurred) {
    this.dateEventOccurred = dateEventOccurred;
  }

  public void setDateLastUpdate(Date dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public void setEventStatusCode(String eventStatusCode) {
    this.eventStatusCode = eventStatusCode;
  }

  public void setEventTaskCode(String eventTaskCode) {
    this.eventTaskCode = eventTaskCode;
  }

  public void setEventTypeCode(String eventTypeCode) {
    this.eventTypeCode = eventTypeCode;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public void setApprovalDate(Date approvalDate) {
    this.approvalDate = approvalDate;
  }

  public void setApprovalDateLastUpdate(Date approvalDateLastUpdate) {
    this.approvalDateLastUpdate = approvalDateLastUpdate;
  }

  public void setApprovalId(int approvalId) {
    this.approvalId = approvalId;
  }

  public void setApprovalPersonId(int approvalPersonId) {
    this.approvalPersonId = approvalPersonId;
  }

  public void setApprovalTopic(String approvalTopic) {
    this.approvalTopic = approvalTopic;
  }

  public void setCreatorsFirstName(String creatorsFirstName) {
    this.creatorsFirstName = creatorsFirstName;
  }

  public void setCreatorsLastName(String creatorsLastName) {
    this.creatorsLastName = creatorsLastName;
  }

  public String getStageCode() {
    return stageCode;
  }

  public void setStageCode(String stageCode) {
    this.stageCode = stageCode;
  }
}
