package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
 
/** @author joshua.d.dorsey */

public class SafetyResourceRetrieveSI implements Serializable {

  private int ulIdEvent;
  private int ulIdStage;
  
 
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
    
}

