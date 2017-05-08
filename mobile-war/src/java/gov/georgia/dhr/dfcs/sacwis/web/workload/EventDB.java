package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.io.Serializable;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

/** Event Databean; used to encapsulate information for EventList display */
public class EventDB
        implements Serializable {
  //from EventSearchConversation.eventListSetWindowState
  protected boolean newUsingEnabled = false;
  protected boolean deleteEnabled = false;
  //from CCMN34SO.ROWCCMN57DO
  protected boolean submitted = false;
  //from ROWCCMN33SO
  protected boolean hasEventNavigation = false;
  protected boolean allowsMultipleInstances = false;
  protected boolean allowsNewUsing = false;
  protected boolean allowsDelete = false;
  protected Date dateEventOccurred = null;
  protected String eventStatusCode = null;
  protected String eventTypeCode = null;
  protected String stageCode = null;
  protected String taskCode = null;
  protected String taskStatusCode = null;
  protected String topWindow = null;
  protected String stageName = null;
  protected String caseWorkerName = null;
  protected String personName = null;
  protected String eventDescription = null;
  protected int caseId = 0;
  protected int eventId = 0;
  protected int stageId = 0;

  public String getDateEventOccurredString() {
    if (dateEventOccurred == null) {
      return "";
    }
    return DateHelper.SLASH_FORMAT.format(dateEventOccurred);
  }

  public String getEventTypeDecode() {
    return Lookup.simpleDecodeSafe("CEVNTTYP", eventTypeCode);
  }

  //generic get/sets
  public boolean getNewUsingEnabled() {
    return newUsingEnabled;
  }

  public void setNewUsingEnabled(boolean newUsingEnabled) {
    this.newUsingEnabled = newUsingEnabled;
  }
  
  public boolean getDeleteEnabled() {
    return deleteEnabled;
  }

  public void setDeleteEnabled(boolean deleteEnabled) {
    this.deleteEnabled = deleteEnabled;
  }

  public boolean getSubmitted() {
    return submitted;
  }

  public void setSubmitted(boolean submitted) {
    this.submitted = submitted;
  }

  public boolean getHasEventNavigation() {
    return hasEventNavigation;
  }

  public void setHasEventNavigation(boolean hasEventNavigation) {
    this.hasEventNavigation = hasEventNavigation;
  }

  public boolean getAllowsMultipleInstances() {
    return allowsMultipleInstances;
  }

  public void setAllowsMultipleInstances(boolean allowsMultipleInstances) {
    this.allowsMultipleInstances = allowsMultipleInstances;
  }

  public boolean getAllowsNewUsing() {
    return allowsNewUsing;
  }

  public void setAllowsNewUsing(boolean allowsNewUsing) {
    this.allowsNewUsing = allowsNewUsing;
  }
  
  public boolean getAllowsDelete() {
    return allowsDelete;
  }

  public void setAllowsDelete(boolean allowsDelete) {
    this.allowsDelete = allowsDelete;
  }

  public Date getDateEventOccurred() {
    return dateEventOccurred;
  }

  public void setDateEventOccurred(Date dateEventOccurred) {
    this.dateEventOccurred = dateEventOccurred;
  }

  public String getEventStatusCode() {
    return eventStatusCode;
  }

  public void setEventStatusCode(String eventStatusCode) {
    this.eventStatusCode = eventStatusCode;
  }

  public String getEventTypeCode() {
    return eventTypeCode;
  }

  public void setEventTypeCode(String eventTypeCode) {
    this.eventTypeCode = eventTypeCode;
  }

  public String getStageCode() {
    return stageCode;
  }

  public void setStageCode(String stageCode) {
    this.stageCode = stageCode;
  }

  public String getTaskCode() {
    return taskCode;
  }

  public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
  }

  public String getTaskStatusCode() {
    return taskStatusCode;
  }

  public void setTaskStatusCode(String taskStatusCode) {
    this.taskStatusCode = taskStatusCode;
  }

  public String getTopWindow() {
    return topWindow;
  }

  public void setTopWindow(String topWindow) {
    this.topWindow = topWindow;
  }

  public String getStageName() {
    return stageName;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  public String getCaseWorkerName() {
    return caseWorkerName;
  }

  public void setCaseWorkerName(String caseWorkerName) {
    this.caseWorkerName = caseWorkerName;
  }

  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }
}
