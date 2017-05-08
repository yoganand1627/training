/**
 *
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class ChildPlanDetailRetrieveSI implements Serializable {

  private int ulIdEvent;

  private String bSysIndIntake;

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public String getBSysIndIntake() {
    return bSysIndIntake;
  }

  public void setBSysIndIntake(String bSysIndIntake) {
    this.bSysIndIntake = bSysIndIntake;
  }
}
