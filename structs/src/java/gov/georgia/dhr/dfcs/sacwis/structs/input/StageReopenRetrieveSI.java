package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
 
/** @author Bhavna Gehlot */

public class StageReopenRetrieveSI implements Serializable {

  private int ulIdEvent;
  private int ulIdStage;
  private int ulIdUser;
  
 
  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getUlIdStage() {
    return this.ulIdStage;
  }
  
  public int setUlIdStage(int ulIdStage) {
    return this.ulIdStage = ulIdStage;
  }
  
  public int getUlIdUser() {
    return this.ulIdUser;
  }
  
  public int setUlIdUser(int ulIdUser) {
    return this.ulIdUser = ulIdUser;
  }
    
}

