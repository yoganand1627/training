package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class NcEvent implements Serializable {
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

  /** Constructor */
  public NcEvent() {
  }

  /**
   * Constructor that builds the object with the given params.
   *
   * @param caseId  The id of the case in which this event was created.
   * @param stageId The id of the stage in which this event was created.
   * @param eventId The id of this event.
   */
  public NcEvent(int caseId, int stageId, int eventId) {
    this();
    this.caseId = caseId;
    this.stageId = stageId;
    this.eventId = eventId;
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
