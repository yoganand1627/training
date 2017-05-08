package gov.georgia.dhr.dfcs.sacwis.structs.output;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationBean;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/** @author Vishala Devarakonda, May 7, 2007 */

/**
 * 
 * <pre>
 *          Change History:
 *           Date          User              Description
 *           ----------    ----------------  --------------------------------------------------
 *           03/01/2011    htvo              SMS#97845 MR-074-2 AFCARS: new field to indicate incident or non-incident child for PAD
 *           06/01/2011    htvo              SMS#109403: MR-082: changed bNonIncidentChild to bIncidentChild to better reflect the new 
 *                                           logic that only incident can be accurately determined by the system.
 *           06/07/2011    htvo              SMS#109403: correct SMS code from 10943 to 109403                                
 * </pre>
 */


@SuppressWarnings("serial")
public class SpecialNeedsDeterminationRetrieveSO implements Serializable {

  private int ulIdEvent;

  private String staffPersRole;

  private String attrSocialServicesStaff;

  private int userId;

  private String cdTask;

  private Date dtEventOccurred;

  private String txtEventDesc;

  private Date dtEventLastUpdate;

  private String cdEventStatus;

  private boolean hasStageClosureEvent;

  private SpecialNeedsDeterminationBean spNdsDetBean;

  private String personFirst;

  private String personLast;

  private String personMiddle;

  private Date personDOB;

  private int personAge;

  private String personGender;

  private String personRace;

  private String personEthnicity;

  private String personHomeCnty;

  private String personBoardCnty;

  private String personIVEEligibility;
  
  private boolean hasCurrentEligibility;

  private Date personLstEntryFCare;
  
  private int ulIdChild;
  
  private String nmStage;
  
  private double perDiemRate;
  
  private Date dtEventApproved;
  
  private Integer nbrSpNeedsChildrenRequest;
  
  private String indNonRecOnly;
  
  boolean bIncidentChild; //SMS#109403: this is calculated logical field used to control page behavior, used for all stages
  
  boolean bPriorAprvSpecialNeedsDeter;
  
  boolean bFirstApplication;
  
  boolean bPriorAprvNonRec;
  
  Map<String, Object> priorAprvSpecialNeedsDeterNA;
  
  private String indIncidentChild; // this field maps to the actual IND_INCIDENT_CHILD in SPECIAL_NEEDS_DETERMINATION
                                    // table, applicable PAD only.
  private boolean bDisableIncidentStatus; // set display mode for Incident/Non-Incident Status

  public String getNmStage() {
    return nmStage;
  }

  public void setNmStage(String nmStage) {
    this.nmStage = nmStage;
  }

  public int getUlIdChild() {
    return ulIdChild;
  }

  public void setUlIdChild(int ulIdChild) {
    this.ulIdChild = ulIdChild;
  }


  public String getPersonBoardCnty() {
    return personBoardCnty;
  }

  public void setPersonBoardCnty(String personBoardCnty) {
    this.personBoardCnty = personBoardCnty;
  }

  public String getPersonEthnicity() {
    return personEthnicity;
  }

  public void setPersonEthnicity(String personEthnicity) {
    this.personEthnicity = personEthnicity;
  }

  public String getPersonFirst() {
    return personFirst;
  }

  public void setPersonFirst(String personFirst) {
    this.personFirst = personFirst;
  }

  public String getPersonGender() {
    return personGender;
  }

  public void setPersonGender(String personGender) {
    this.personGender = personGender;
  }

  public String getPersonHomeCnty() {
    return personHomeCnty;
  }

  public void setPersonHomeCnty(String personHomeCnty) {
    this.personHomeCnty = personHomeCnty;
  }

  public String getPersonIVEEligibility() {
    return personIVEEligibility;
  }

  public void setPersonIVEEligibility(String personIVEEligibility) {
    this.personIVEEligibility = personIVEEligibility;
  }

  public String getPersonLast() {
    return personLast;
  }

  public void setPersonLast(String personLast) {
    this.personLast = personLast;
  }

  public Date getPersonLstEntryFCare() {
    return personLstEntryFCare;
  }

  public void setPersonLstEntryFCare(Date personLstEntryFCare) {
    this.personLstEntryFCare = personLstEntryFCare;
  }

  public String getPersonMiddle() {
    return personMiddle;
  }

  public void setPersonMiddle(String personMiddle) {
    this.personMiddle = personMiddle;
  }

  public String getPersonRace() {
    return personRace;
  }

  public void setPersonRace(String personRace) {
    this.personRace = personRace;
  }

  public SpecialNeedsDeterminationBean getSpNdsDetBean() {
    return spNdsDetBean;
  }

  public void setSpNdsDetBean(SpecialNeedsDeterminationBean spNdsDetBean) {
    this.spNdsDetBean = spNdsDetBean;
  }

  public boolean hasStageClosureEvent() {
    return hasStageClosureEvent;
  }

  public void setHasStageClosureEvent(boolean hasStageClosureEvent) {
    this.hasStageClosureEvent = hasStageClosureEvent;
  }

  public String getCdEventStatus() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.cdEventStatus = cdEventStatus;
  }

  public String getAttrSocialServicesStaff() {
    return attrSocialServicesStaff;
  }

  public void setAttrSocialServicesStaff(String attrSocialServicesStaff) {
    this.attrSocialServicesStaff = attrSocialServicesStaff;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public String getCdTask() {
    return cdTask;
  }

  public void setCdTask(String cdTask) {
    this.cdTask = cdTask;
  }

  public Date getDtEventLastUpdate() {
    return dtEventLastUpdate;
  }

  public void setDtEventLastUpdate(Date dtEventLastUpdate) {
    this.dtEventLastUpdate = dtEventLastUpdate;
  }

  public Date getDtEventOccurred() {
    return dtEventOccurred;
  }

  public void setDtEventOccurred(Date dtEventOccurred) {
    this.dtEventOccurred = dtEventOccurred;
  }

  public String getTxtEventDesc() {
    return txtEventDesc;
  }

  public void setTxtEventDesc(String txtEventDesc) {
    this.txtEventDesc = txtEventDesc;
  }

  public boolean isHasStageClosureEvent() {
    return hasStageClosureEvent;
  }

  public void setPersonDOB(Date personDOB) {
    this.personDOB = personDOB;
  }

  public Date getPersonDOB() {
    return personDOB;
  }

  public void setPersonAge(int personAge) {
    this.personAge = personAge;
  }

  public int getPersonAge() {
    return personAge;
  }

  public String getStaffPersRole() {
    return staffPersRole;
  }

  public void setStaffPersRole(String staffPersRole) {
    this.staffPersRole = staffPersRole;
  }

  public double getPerDiemRate() {
    return perDiemRate;
  }

  public void setPerDiemRate(double perDiemRate) {
    this.perDiemRate = perDiemRate;
  }

  public Date getDtEventApproved() {
    return dtEventApproved;
  }

  public void setDtEventApproved(Date dtEventApproved) {
    this.dtEventApproved = dtEventApproved;
  }

  public boolean hasCurrentEligibility() {
    return hasCurrentEligibility;
  }

  public void setHasCurrentEligibility(boolean hasCurrentEligibility) {
    this.hasCurrentEligibility = hasCurrentEligibility;
  }

  public Integer getNbrSpNeedsChildrenRequest() {
    return nbrSpNeedsChildrenRequest;
  }

  public void setNbrSpNeedsChildrenRequest(Integer nbrSpNeedsChildrenRequest) {
    this.nbrSpNeedsChildrenRequest = nbrSpNeedsChildrenRequest;
  }

  public String getIndNonRecOnly() {
    return indNonRecOnly;
  }

  public void setIndNonRecOnly(String indNonRecOnly) {
    this.indNonRecOnly = indNonRecOnly;
  }

  public boolean isBIncidentChild() {
    return bIncidentChild;
  }

  public void setBIncidentChild(boolean incidentChild) {
    bIncidentChild = incidentChild;
  }

  public boolean isBPriorAprvSpecialNeedsDeter() {
    return bPriorAprvSpecialNeedsDeter;
  }

  public void setBPriorAprvSpecialNeedsDeter(boolean priorAprvSpecialNeedsDeter) {
    bPriorAprvSpecialNeedsDeter = priorAprvSpecialNeedsDeter;
  }

  public boolean isBFirstApplication() {
    return bFirstApplication;
  }

  public void setBFirstApplication(boolean firstApplication) {
    bFirstApplication = firstApplication;
  }

  public boolean isBPriorAprvNonRec() {
    return bPriorAprvNonRec;
  }

  public void setBPriorAprvNonRec(boolean priorAprvNonRec) {
    bPriorAprvNonRec = priorAprvNonRec;
  }
  
  public Map<String, Object> getPriorAprvSpecialNeedsDeterNA() {
    return priorAprvSpecialNeedsDeterNA;
  }

  public void setPriorAprvSpecialNeedsDeterNA(Map<String, Object> priorAprvSpecialNeedsDeterNA) {
    this.priorAprvSpecialNeedsDeterNA = priorAprvSpecialNeedsDeterNA;
  }

  public String getIndIncidentChild() {
	return indIncidentChild;
  }

  public void setIndIncidentChild(String indIncidentChild) {
	this.indIncidentChild = indIncidentChild;
  }

  public boolean isBDisableIncidentStatus() {
    return bDisableIncidentStatus;
  }

  public void setBDisableIncidentStatus(boolean disableIncidentStatus) {
    bDisableIncidentStatus = disableIncidentStatus;
  }

}
