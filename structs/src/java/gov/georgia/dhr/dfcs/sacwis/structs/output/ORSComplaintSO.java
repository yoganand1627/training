package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

public class ORSComplaintSO implements Serializable {

  private String szResourceName = null;

  private String szORSFacilityID = null;
  
  private Date dtIntake = null;
  
  private String szNmItake = null;
  
  private String szStatus = null;
  
  private String szPriority = null;
  
  private String szNarrative = null;
  
  private String szInvestigatorName = null;
  
  private String szType = null;
  
  private Date dtLastUpdate = null;
  
  public String getSzResourceName() {
    return szResourceName;
  }

  public void setSzResourceName(String szResourceName) {
    this.szResourceName = szResourceName;
  }

  public String getSzORSFacilityID() {
    return szORSFacilityID;
  }

  public void setSzORSFacilityID(String szORSFacilityID) {
    this.szORSFacilityID = szORSFacilityID;
  }

  public Date getDtIntake() {
    return dtIntake;
  }

  public void setDtIntake(Date dtIntake) {
    this.dtIntake = dtIntake;
  }

  public String getSzNmItake() {
    return szNmItake;
  }

  public void setSzNmItake(String szNmItake) {
    this.szNmItake = szNmItake;
  }

  public String getSzStatus() {
    return szStatus;
  }

  public void setSzStatus(String szStatus) {
    this.szStatus = szStatus;
  }

  public String getSzPriority() {
    return szPriority;
  }

  public void setSzPriority(String szPriority) {
    this.szPriority = szPriority;
  }

  public String getSzNarrative() {
    return szNarrative;
  }

  public void setSzNarrative(String szNarrative) {
    this.szNarrative = szNarrative;
  }

  public String getSzInvestigatorName() {
    return szInvestigatorName;
  }

  public void setSzInvestigatorName(String szInvestigatorName) {
    this.szInvestigatorName = szInvestigatorName;
  }

  public String getSzType() {
    return szType;
  }

  public void setSzType(String szType) {
    this.szType = szType;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

}
