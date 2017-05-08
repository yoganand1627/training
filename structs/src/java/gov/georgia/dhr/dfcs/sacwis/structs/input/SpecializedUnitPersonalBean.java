package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SpecializedUnitPersonalBean implements Serializable {
  
  private int idStage;

  private String securityAttribute;

  private String specialization;
 
  private String cdCounty;
  
  private boolean isRAC;
  
  public String getCdCounty() {
    return cdCounty;
  }

  public void setCdCounty(String cdCounty) {
    this.cdCounty = cdCounty;
  }

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  public boolean isRAC() {
    return isRAC;
  }

  public void setRAC(boolean isRAC) {
    this.isRAC = isRAC;
  }

  public String getSecurityAttribute() {
    return securityAttribute;
  }

  public void setSecurityAttribute(String securityAttribute) {
    this.securityAttribute = securityAttribute;
  }

  public String getSpecialization() {
    return specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }
}
