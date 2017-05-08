package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TCMClaimsSearchSI implements Serializable {

  private int ulIdStaff;
  
  private int idClient;

  private int month;

  private int ulYear;

  private String szCdCounty;

  private String szUnit;

  private String szCdStatus;

  public void setUlIdStaff(int ulIdStaff) {
    this.ulIdStaff = ulIdStaff;
  }

  public int getUlIdStaff() {
    return ulIdStaff;
  }

  public int getIdClient() {
    return idClient;
  }

  public void setIdClient(int idClient) {
    this.idClient = idClient;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getMonth() {
    return month;
  }

  public void setUlYear(int ulYear) {
    this.ulYear = ulYear;
  }

  public int getUlYear() {
    return ulYear;
  }

  public void setSzCdCounty(String szCdCounty) {
    this.szCdCounty = szCdCounty;
  }

  public String getSzCdCounty() {
    return szCdCounty;
  }

  public void setSzUnit(String szUnit) {
    this.szUnit = szUnit;
  }

  public String getSzUnit() {
    return szUnit;
  }

  public void setSzCdStatus(String szCdStatus) {
    this.szCdStatus = szCdStatus;
  }

  public String getSzCdStatus() {
    return szCdStatus;
  }

}
