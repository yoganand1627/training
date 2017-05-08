package gov.georgia.dhr.dfcs.sacwis.dao.document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

public class DocumentEventValueBean extends BaseValueBean {

  private int eventId;
  private int caseId;
  private int stageId;
  private String eventTypeCode;
  private int personId;
  private String taskCode;
  private String eventDescription;
  private Date eventOccurred;
  private Date dateLastUpdate;
  private String eventStatusCode;

  public DocumentEventValueBean() {

  }

  public DocumentEventValueBean(ResultSet resultSet) throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".Constructor");
    this.setEventId(resultSet.getInt(DocumentSaveCheckEventStatusDao.EVENT_ID_COLUMN));
    this.setCaseId(resultSet.getInt(DocumentSaveCheckEventStatusDao.CASE_ID_COLUMN));
    this.setPersonId(resultSet.getInt(DocumentSaveCheckEventStatusDao.PERSON_ID_COLUMN));
    this.setStageId(resultSet.getInt(DocumentSaveCheckEventStatusDao.STAGE_ID_COLUMN));
    this.setEventTypeCode(resultSet.getString(DocumentSaveCheckEventStatusDao.EVENT_TYPE_COLUMN));
    this.setEventDescription(resultSet.getString(DocumentSaveCheckEventStatusDao.EVENT_DESCRIPTION_COLUMN));
    this.setEventStatusCode(resultSet.getString(DocumentSaveCheckEventStatusDao.EVENT_STATUS_COLUMN));
    this.setEventOccurred(resultSet.getDate(DocumentSaveCheckEventStatusDao.DATE_OCCURRED_COLUMN));
    this.setDateLastUpdate(resultSet.getTimestamp(DocumentSaveCheckEventStatusDao.DATE_LAST_UPDATE_COLUMN));
    this.setTaskCode(resultSet.getString(DocumentSaveCheckEventStatusDao.TASK_CODE_COLUMN));
    GrndsTrace.exitScope();
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public String getEventTypeCode() {
    return eventTypeCode;
  }

  public void setEventTypeCode(String eventTypeCode) {
    this.eventTypeCode = eventTypeCode;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getTaskCode() {
    return taskCode;
  }

  public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public Date getEventOccurred() {
    return eventOccurred;
  }

  public void setEventOccurred(Date eventOccurred) {
    this.eventOccurred = eventOccurred;
  }

  public String getEventStatusCode() {
    return eventStatusCode;
  }

  public void setEventStatusCode(String eventStatusCode) {
    this.eventStatusCode = eventStatusCode;
  }

  public Date getDateLastUpdate() {
    return dateLastUpdate;
  }

  public void setDateLastUpdate(Date dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  private static final String TRACE_TAG = "DocumentEventValueBean";
}