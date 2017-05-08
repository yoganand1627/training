package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class PaymentOfCareRetrieveSI implements Serializable {
  protected int ulIdEvent;
  protected int ulIdStage;

  public int getUlIdStage() {
    return ulIdStage;
  }

  public void setUlIdStage(int ulIdStage) {
    this.ulIdStage = ulIdStage;
  }

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }
}