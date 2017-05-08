package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.structs.output.SaPerson;

/** @author modeste.g.ngom */
public class SafetyAssessmentSaveSI implements Serializable {

  /**
   *
   */

  // class member Variables
  private int ulIdEvent;
  private int idCase;
  private int idPerson;
  private int idStage;
  private String szTxtPageStatus;
  private String szTxtWhyResponses;
  private String szTxtAddtnlCommnts;
  private String szTxtOverallSafetyDecision;
  private String szTxtOtherSafetyFactor;
  private String cdReqFuncCd;
  protected ROWCCMN01UIG00 rowccmn01uig00 = null;
  protected ROWCCMN01UIG01_ARRAY rowccmn01uig00_array = null;

  private boolean drugExposedNewBornExist;

  private Map<String, Collection<SafetyFactorsSaveSI>> safetyFactors;

  private Map<String, Collection<ReasonableEffortsSaveSI>> reasonableEfforts;

  private Collection<DrugExposedNewBornSaveSI> drugExposedNewborn;

  private Collection<SaPerson> principalCaretakers;

  private Collection<SaPerson> principalChildren;

  private Date dtLastUpdate;

  public String getSzTxtOtherSafetyFactor() {
    return this.szTxtOtherSafetyFactor;
  }

  public void setSzTxtOtherSafetyFactor(String other) {
    this.szTxtOtherSafetyFactor = other;
  }

  public Date getDtLastUpdate() {
    return this.dtLastUpdate;
  }

  public void setDtLastUpdate(Date dt) {
    this.dtLastUpdate = dt;
  }

  public SafetyAssessmentSaveSI() {
    super();
    // TODO Auto-generated constructor stub
  }

  // Methods

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getIdCase() {
    return idCase;
  }

  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  public String getSzTxtAddtnlCommnts() {
    return szTxtAddtnlCommnts;
  }

  public void setSzTxtAddtnlCommnts(String szTxtAddtnlCommnts) {
    this.szTxtAddtnlCommnts = szTxtAddtnlCommnts;
  }

  public String getSzTxtWhyResponses() {
    return szTxtWhyResponses;
  }

  public void setSzTxtWhyResponses(String szTxtWhyResponses) {
    this.szTxtWhyResponses = szTxtWhyResponses;
  }

  public String getSzTxtPageStatus() {
    return szTxtPageStatus;
  }

  public void setSzTxtPageStatus(String szTxtPageStatus) {
    this.szTxtPageStatus = szTxtPageStatus;
  }

  public String getCdReqFuncCd() {
    return cdReqFuncCd;
  }

  public void setCdReqFuncCd(String cdReqFuncCd) {
    this.cdReqFuncCd = cdReqFuncCd;
  }

  public Map<String, Collection<SafetyFactorsSaveSI>> getSafetyFactors() {
    return safetyFactors;
  }

  public void setSafetyFactors(Map<String, Collection<SafetyFactorsSaveSI>> safetyFactors) {
    this.safetyFactors = safetyFactors;
  }

  public Collection<DrugExposedNewBornSaveSI> getDrugExposedNewborn() {
    return drugExposedNewborn;
  }

  public void setDrugExposedNewborn(Collection<DrugExposedNewBornSaveSI> drugExposedNewborn) {
    this.drugExposedNewborn = drugExposedNewborn;
  }

  public Map<String, Collection<ReasonableEffortsSaveSI>> getReasonableEfforts() {
    return reasonableEfforts;
  }

  public void setReasonableEfforts(Map<String, Collection<ReasonableEffortsSaveSI>> reasonableEfforts) {
    this.reasonableEfforts = reasonableEfforts;
  }

  public Collection<SaPerson> getPrincipalCaretakers() {
    return principalCaretakers;
  }

  public void setPrincipalCaretakers(Collection<SaPerson> principalCaretakers) {
    this.principalCaretakers = principalCaretakers;
  }

  public Collection<SaPerson> getPrincipalChildren() {
    return principalChildren;
  }

  public void setPrincipalChildren(Collection<SaPerson> principalChildren) {
    this.principalChildren = principalChildren;
  }

  public String getSzTxtOverallSafetyDecision() {
    return szTxtOverallSafetyDecision;
  }

  public void setSzTxtOverallSafetyDecision(String szTxtOverallSafetyDecision) {
    this.szTxtOverallSafetyDecision = szTxtOverallSafetyDecision;
  }

  public boolean getDrugExposedNewBornExist() {
    return drugExposedNewBornExist;
  }

  public void setDrugExposedNewBornExist(boolean drugExposedNewBornExist) {
    this.drugExposedNewBornExist = drugExposedNewBornExist;
  }

  public ROWCCMN01UIG00 getROWCCMN01UIG00() {
    return rowccmn01uig00;
  }

  public void setROWCCMN01UIG00(ROWCCMN01UIG00 rowccmn01uig00) {
    this.rowccmn01uig00 = rowccmn01uig00;
  }

  public ROWCCMN01UIG01_ARRAY getROWCCMN01UIG01_ARRAY() {
    return rowccmn01uig00_array;
  }

  public void setROWCCMN01UIG01_ARRAY(ROWCCMN01UIG01_ARRAY rowccmn01uig00_array) {
    this.rowccmn01uig00_array = rowccmn01uig00_array;
  }
}
