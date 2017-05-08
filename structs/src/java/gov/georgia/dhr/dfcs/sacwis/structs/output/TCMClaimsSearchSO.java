package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TCMClaimsSearchSO implements Serializable {

  private int ulIdTcmClaim;

  private Date tsDtLastUpdate = null;

  private int ulIdStage;

  private int ulIdStaff;

  private int ulIdPerson;

  private String szNmClient;

  private String szNbrMedicaid;

  private String szCdStatus;

  private String szCdDenialReason;

  private Date dtStatusDate;

  private Date dtServiceDate;

  private String ulTCNNumber;
  
  private int ulIdEvent;

  public void setUlIdTcmClaim(int ulIdTcmClaim) {
    this.ulIdTcmClaim = ulIdTcmClaim;
  }

  public int getUlIdTcmClaim() {
    return ulIdTcmClaim;
  }

  public void setTsDtLastUpdate(Date tsDtLastUpdate) {
    this.tsDtLastUpdate = tsDtLastUpdate;
  }

  public Date getTsDtLastUpdate() {
    return tsDtLastUpdate;
  }

  public void setUlIdStage(int ulIdStage) {
    this.ulIdStage = ulIdStage;
  }

  public int getUlIdStage() {
    return ulIdStage;
  }

  public void setUlIdStaff(int ulIdStaff) {
    this.ulIdStaff = ulIdStaff;
  }

  public int getUlIdStaff() {
    return ulIdStaff;
  }

  public void setUlIdPerson(int ulIdPerson) {
    this.ulIdPerson = ulIdPerson;
  }

  public int getUlIdPerson() {
    return ulIdPerson;
  }

  public void setSzNmClient(String szNmClient) {
    this.szNmClient = szNmClient;
  }

  public String getSzNmClient() {
    return szNmClient;
  }

  public void setSzNbrMedicaid(String szNbrMedicaid) {
    this.szNbrMedicaid = szNbrMedicaid;
  }

  public String getSzNbrMedicaid() {
    return szNbrMedicaid;
  }

  public void setSzCdStatus(String szCdStatus) {
    this.szCdStatus = szCdStatus;
  }

  public String getSzCdStatus() {
    return szCdStatus;
  }

  public void setSzCdDenialReason(String szCdDenialReason) {
    this.szCdDenialReason = szCdDenialReason;
  }

  public String getSzCdDenialReason() {
    return szCdDenialReason;
  }

  public void setDtStatusDate(Date dtStatusDate) {
    this.dtStatusDate = dtStatusDate;
  }

  public Date getDtStatusDate() {
    return dtStatusDate;
  }

  public void setDtServiceDate(Date dtServiceDate) {
    this.dtServiceDate = dtServiceDate;
  }

  public Date getDtServiceDate() {
    return dtServiceDate;
  }

  public void setUlTCNNumber(String ulTCNNumber) {
    this.ulTCNNumber = ulTCNNumber;
  }

  public String getUlTCNNumber() {
    return ulTCNNumber;
  }

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

}
