package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

/** @author vishala devarakonda */
public class FCGSSaveSO implements Serializable {

  private int ulIdGoal;

  public void setUlIdGoal(int ulIdGoal) {
    this.ulIdGoal = ulIdGoal;
  }

  public int getUlIdGoal() {
    return ulIdGoal;
  }
}