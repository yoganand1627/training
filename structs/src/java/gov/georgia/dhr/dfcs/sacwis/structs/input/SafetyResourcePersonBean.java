package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/** @author Patrick Coogan */

public class SafetyResourcePersonBean implements Serializable {

  private int ulIdChild;
  private String nmChildFull;
 
  public int getUlIdChild() {
  return ulIdChild;
  }

  public void setUlIdChild(int ulIdChild) {
  this.ulIdChild = ulIdChild;
  }

  public String getNmChildFull() {
  return nmChildFull;
  }

  public void setNmChildFull(String nmChildFull) {
  this.nmChildFull = nmChildFull;
  }

}