package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

public class PersonCharacteristicsBean implements Serializable {

  private String cdCharCategory;
  private String cdCharacteristic;

  public String getCdCharCategory() {
    return cdCharCategory;
  }

  public void setCdCharCategory(String cdCharCategory) {
    this.cdCharCategory = cdCharCategory;
  }
  
  public String getCdCharacteristic() {
    return cdCharacteristic;
  }

  public void setCdCharacteristic(String cdCharacteristic) {
    this.cdCharacteristic = cdCharacteristic;
  }
  
}
