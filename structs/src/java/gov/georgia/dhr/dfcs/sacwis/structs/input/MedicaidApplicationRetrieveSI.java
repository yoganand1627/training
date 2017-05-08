package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class MedicaidApplicationRetrieveSI implements Serializable { 
  /** @author Gautami Rout */
   
  private int ulIdPerson;

  private int ulIdEvent;

  private int ulIdStage;
  
  private int ulIdCase;


  public int getUlIdPerson() {
    return ulIdPerson;
  }

  public void setUlIdPerson(int ulIdPerson) {
    this.ulIdPerson = ulIdPerson;
  }

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }
  public int getUlIdStage() {
    return this.ulIdStage;
  }

  public void setUlIdStage(int stage) {
    ulIdStage = stage;
  }
  public int getUlIdCase() {
    return ulIdCase;
  }

  public void setUlIdCase(int ulIdCase) {
    this.ulIdCase = ulIdCase;
  }
}
