package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class AgeCitizenshipSaveSI implements Serializable {
  
  private long ulIdStage;
  private long ulIdEvent;
  private PersonCitizenshipIdentityList personCitizenshipIdentityBean;
  
  public long getUlIdStage() {
    return ulIdStage;
  }
  public void setUlIdStage(long ulIdStage) {
    this.ulIdStage = ulIdStage;
  }
  public PersonCitizenshipIdentityList getPersonCitizenshipIdentityBean() {
    return personCitizenshipIdentityBean;
  }
  public void setPersonCitizenshipIdentityBean(PersonCitizenshipIdentityList personCitizenshipIdentityBean) {
    this.personCitizenshipIdentityBean = personCitizenshipIdentityBean;
  }
  public long getUlIdEvent() {
    return ulIdEvent;
  }
  public void setUlIdEvent(long ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }
}
