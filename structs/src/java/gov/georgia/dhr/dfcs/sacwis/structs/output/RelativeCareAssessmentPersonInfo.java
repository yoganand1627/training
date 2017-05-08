package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class RelativeCareAssessmentPersonInfo implements Serializable {

  private int ulIdPerson;

  private String nmPersonName;

  private boolean[] isSelected = new boolean[3];

  private Date dtLastUpdate;

  private int ulIdRcaPerson;

  private int ulIdRcaEvent;

  public int getUlIdRcaEvent() {
    return ulIdRcaEvent;
  }

  public void setUlIdRcaEvent(int idEvent) {
    ulIdRcaEvent = idEvent;
  }

  public int getUlIdRcaPerson() {
    return ulIdRcaPerson;
  }

  public void setUlIdRcaPerson(int idRcaPerson) {
    this.ulIdRcaPerson = idRcaPerson;
  }

  public int getUlIdPerson() {
    return ulIdPerson;
  }

  public void setUlIdPerson(int idPerson) {
    ulIdPerson = idPerson;
  }

  /**
   * @return the isSelected
   */
  public boolean[] getIsSelected() {
    return isSelected;
  }

  /**
   * @param isSelected
   *          the isSelected to set
   */
  public void setIsSelected(boolean[] isSelected) {
    this.isSelected = isSelected;
  }

  /**
   * @return the nmPersonName
   */
  public String getNmPersonName() {
    return nmPersonName;
  }

  /**
   * @param nmPersonName
   *          the nmPersonName to set
   */
  public void setNmPersonName(String nmPersonName) {
    this.nmPersonName = nmPersonName;
  }

  public void setIsSelected(int index) {
    isSelected[index] = true;
    isSelected[(index + 1) % 3] = false;
    isSelected[(index + 2) % 3] = false;
  }

  public boolean getIsSelected(int index) {
    return isSelected[index];
  }

  /**
   * @return the dtLastUpdate
   */
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  /**
   * @param dtLastUpdate
   *          the dtLastUpdate to set
   */
  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public void setCdPersonType(String pType) {
    if ("PRC".equals(pType)) {
      setIsSelected(0);
    } else if ("CHP".equals(pType)) {
      setIsSelected(1);
    } else if ("HOM".equals(pType)) {
      setIsSelected(2);
    }
  }

  public String getCdPersonType(int index) {
    String result = null;
    switch (index) {
    case 0:
      result = "PRC";
      break;
    case 1:
      result = "CHP";
      break;
    case 2:
      result = "HOM";
      break;
    }
    return result;
  }

  public String getCdPersonType() {
    if (this.getIsSelected(0)) {
      return "PRC";
    } else if (this.getIsSelected(1)) {
      return "CHP";
    } else if (this.getIsSelected(2)) {
      return "HOM";
    } else
      return "";
  }

}
