/**
 *@author vishala Devarakonda 
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/** @author vishala devarakonda */
@SuppressWarnings("serial")
public class SpecialNeedsDeterminationRetrieveSI implements Serializable {

  private int ulIdEvent;

  private int ulIdCase;

  private int ulIdStage;

  private int ulIdPerson;

  private int userId;
  
  private String cdStage;

  public String getCdStage() {
    return cdStage;
  }

  public void setCdStage(String cdStage) {
    this.cdStage = cdStage;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getUlIdPerson() {
    return ulIdPerson;
  }

  public void setUlIdPerson(int ulIdPerson) {
    this.ulIdPerson = ulIdPerson;
  }

  public int getUlIdCase() {
    return ulIdCase;
  }

  public void setUlIdCase(int ulIdCase) {
    this.ulIdCase = ulIdCase;
  }

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
