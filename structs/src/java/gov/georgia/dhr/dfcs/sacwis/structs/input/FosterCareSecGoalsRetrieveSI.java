package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * @author Nandita Hegde
 */

public class FosterCareSecGoalsRetrieveSI implements Serializable {

  private int caseId;

  private int eventId;

  private int secGoalsId;

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

  public int getSecGoalsId() {
    return secGoalsId;
  }

  public void setSecGoalsId(int secGoalsId) {
    this.secGoalsId = secGoalsId;
  }

}
