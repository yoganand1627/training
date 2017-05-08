package gov.georgia.dhr.dfcs.sacwis.web.core.user;

import java.io.Serializable;

public class UnitStaffIdentifier implements Serializable {
  public static final String UNIT_STAFF_IDENTIFIER_KEY = "UNIT_STAFF_IDENTIFIER_KEY";
  private int ulIdStaff = 0;
  private String szStaffFullName = "";

  public UnitStaffIdentifier() {
  }

  public UnitStaffIdentifier(int ulIdStaff,
                             String szStaffFullName) {
    setUlIdStaff(ulIdStaff);
    setSzStaffFullName(szStaffFullName);
  }

  public int getUlIdStaff() {
    return ulIdStaff;
  }

  protected void setUlIdStaff(int ulIdStaff) {
    this.ulIdStaff = ulIdStaff;
  }

  public String getSzStaffNameFull() {
    return szStaffFullName;
  }

  protected void setSzStaffFullName(String szStaffFullName) {
    this.szStaffFullName = szStaffFullName;
  }

  public String toString() {
    return szStaffFullName + "(" + ulIdStaff + ")";
  }
}
