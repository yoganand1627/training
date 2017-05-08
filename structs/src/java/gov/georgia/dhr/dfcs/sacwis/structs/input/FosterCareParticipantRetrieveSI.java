package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/** @author Steven Thrasher */
public class FosterCareParticipantRetrieveSI implements Serializable {

  //class member Variables
  protected int ulIdEvent;

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

}