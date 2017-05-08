package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

public class PortalContactBean implements Serializable {

  private int idContactEvent;
  private int idContactCase;
  private int idContactStage;
  private Date dtContactDate;
  private String cdCntctMethod;
  private String cdCntctPurpose;
  private String szContactedBy;
  private String szContactAgency;
  private String szIndAccess;
  private String cdStageType;
  
    

  public int getIdContactEvent() {
    return idContactEvent;
  }

  public void setIdContactEvent(int idContactEvent) {
    this.idContactEvent = idContactEvent;
  }
  
  public int getIdContactStage() {
    return idContactStage;
  }

  public void setIdContactStage(int idContactStage) {
    this.idContactStage = idContactStage;
  }

  public int getIdContactCase() {
    return idContactCase;
  }

  public void setIdContactCase(int idContactCase) {
    this.idContactCase = idContactCase;
  }
  
  public Date getDtContactDate() {
    return dtContactDate;
  }

  public void setDtContactDate(Date dtContactDate) {
    this.dtContactDate = dtContactDate;
  }
  
  public String getCdCntctMethod() {
    return cdCntctMethod;
  }

  public void setCdCntctMethod(String cdCntctMethod) {
    this.cdCntctMethod = cdCntctMethod;
  }
  
  public String getCdCntctPurpose() {
    return cdCntctPurpose;
  }

  public void setCdCntctPurpose(String cdCntctPurpose) {
    this.cdCntctPurpose = cdCntctPurpose;
  }
    
  public String getSzContactedBy() {
    return szContactedBy;
  }

  public void setSzContactedBy(String szContactedBy) {
    this.szContactedBy = szContactedBy;
  }
  
  public String getSzContactAgency() {
    return szContactAgency;
  }

  public void setSzContactAgency(String szContactAgency) {
    this.szContactAgency = szContactAgency;
  }
  
  public String getSzIndAccess() {
    return szIndAccess;
  }

  public void setSzIndAccess(String szIndAccess) {
    this.szIndAccess = szIndAccess;
  }
  
  public String getCdStageType() {
    return cdStageType;
  }

  public void setCdStageType(String cdStageType) {
    this.cdStageType = cdStageType;
  }
  
}