package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
/**
 * 
 * Change History
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 02/04/09    wjcochran                 STGAP00012148: Add Mother Married at Child Birth Indicator
 * 
 * </PRE>
 */
@SuppressWarnings({"serial"})
public class NonIncidentAFCARSInformationSO implements Serializable {
  private int idPerson;
  private Date dtApplicationSent;
  private String indMentRetard;
  private String indVisHearImp;
  private String indPhyDisabled;
  private String indEmtDisturbed;
  private String indOthMedDiag;  
  private String cdSevMentRetard;
  private String cdSevVisHearImp;
  private String cdSevPhyDisabled;
  private String cdSevEmtDisturbed;
  private String cdSevOthMedDiag;
  private String cdPrimSpecNeed;
  private String nmBirthNameFirst;
  private String nmBirthNameMiddle;
  private String nmBirthNameLast;
  private Date dtBirthMotherDOB;
  private String cdBirthMotherTermType;
  private Date dtBirthMotherRightsTerm;
  private String indBMMarriedAtChildBrth;
  private String indBMRaceAA;
  private String indBMRaceAN;
  private String indBMRaceBK;
  private String indBMRaceHP;
  private String indBMRaceUD;
  private String indBMRaceWT;
  private String cdBMEthnicity;
  private Date dtBirthFatherDOB;
  private String cdBirthFatherTermType;
  private Date dtBirthFatherRightsTerm;
  private String indBFRaceAA;
  private String indBFRaceAN;
  private String indBFRaceBK;
  private String indBFRaceHP;
  private String indBFRaceUD;
  private String indBFRaceWT;
  private String cdBFEthnicity;
  private ArrayList bmRaceList;
  private ArrayList bfRaceList;
  private String nmEmployee;
  private String employeePhone;
  private Date dtLastUpdate;
  private String cdPlacmentCounty;
  private String indAPNonRelative;
  private String indAPPriorFP;
  private String indAPOtherRelative;
  private String indAPStepParent;
  private String cdPlcmtBy;
  private String cdPlacementFrom;
  private String cdMaritalStatus;
  private ArrayList amRaceList;
  private ArrayList afRaceList;
  private String cdAFEthnicity;
  private String cdAMEthnicity;  
  private Date dtAdoptiveMotherDOB;
  private Date dtAdoptiveFatherDOB;
  
  
  //@TODO Add Primary Special Need indicator
    
  public int getIdPerson() {
    return idPerson;
  }
  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }
  public Date getDtApplicationSent() {
    return dtApplicationSent;
  }
  public void setDtApplicationSent(Date dtApplicationSent) {
    this.dtApplicationSent = dtApplicationSent;
  }
  public String getIndMentRetard() {
    return indMentRetard;
  }
  public void setIndMentRetard(String indMentRetard) {
    this.indMentRetard = indMentRetard;
  }
  public String getIndVisHearImp() {
    return indVisHearImp;
  }
  public void setIndVisHearImp(String indVisHearImp) {
    this.indVisHearImp = indVisHearImp;
  }
  public String getIndPhyDisabled() {
    return indPhyDisabled;
  }
  public void setIndPhyDisabled(String indPhyDisabled) {
    this.indPhyDisabled = indPhyDisabled;
  }
  public String getIndEmtDisturbed() {
    return indEmtDisturbed;
  }
  public void setIndEmtDisturbed(String indEmtDisturbed) {
    this.indEmtDisturbed = indEmtDisturbed;
  }
  public String getIndOthMedDiag() {
    return indOthMedDiag;
  }
  public void setIndOthMedDiag(String indOthMedDiag) {
    this.indOthMedDiag = indOthMedDiag;
  }
  public String getCdSevMentRetard() {
    return cdSevMentRetard;
  }
  public void setCdSevMentRetard(String cdSevMentRetard) {
    this.cdSevMentRetard = cdSevMentRetard;
  }
  public String getCdSevVisHearImp() {
    return cdSevVisHearImp;
  }
  public void setCdSevVisHearImp(String cdSevVisHearImp) {
    this.cdSevVisHearImp = cdSevVisHearImp;
  }
  public String getCdSevPhyDisabled() {
    return cdSevPhyDisabled;
  }
  public void setCdSevPhyDisabled(String cdSevPhyDisabled) {
    this.cdSevPhyDisabled = cdSevPhyDisabled;
  }
  public String getCdSevEmtDisturbed() {
    return cdSevEmtDisturbed;
  }
  public void setCdSevEmtDisturbed(String cdSevEmtDisturbed) {
    this.cdSevEmtDisturbed = cdSevEmtDisturbed;
  }
  public String getCdSevOthMedDiag() {
    return cdSevOthMedDiag;
  }
  public void setCdSevOthMedDiag(String cdSevOthMedDiag) {
    this.cdSevOthMedDiag = cdSevOthMedDiag;
  }
  public String getCdPrimSpecNeed() {
    return cdPrimSpecNeed;
  }
  public void setCdPrimSpecNeed(String cdPrimSpecNeed) {
    this.cdPrimSpecNeed = cdPrimSpecNeed;
  }
  public String getNmBirthNameFirst() {
    return nmBirthNameFirst;
  }
  public void setNmBirthNameFirst(String nmBirthNameFirst) {
    this.nmBirthNameFirst = nmBirthNameFirst;
  }
  public String getNmBirthNameMiddle() {
    return nmBirthNameMiddle;
  }
  public void setNmBirthNameMiddle(String nmBirthNameMiddle) {
    this.nmBirthNameMiddle = nmBirthNameMiddle;
  }
  public String getNmBirthNameLast() {
    return nmBirthNameLast;
  }
  public void setNmBirthNameLast(String nmBirthNameLast) {
    this.nmBirthNameLast = nmBirthNameLast;
  }
  public Date getDtBirthMotherDOB() {
    return dtBirthMotherDOB;
  }
  public void setDtBirthMotherDOB(Date dtBirthMotherDOB) {
    this.dtBirthMotherDOB = dtBirthMotherDOB;
  }
  public String getCdBirthMotherTermType() {
    return cdBirthMotherTermType;
  }
  public void setCdBirthMotherTermType(String cdBirthMotherTermType) {
    this.cdBirthMotherTermType = cdBirthMotherTermType;
  }
  public Date getDtBirthMotherRightsTerm() {
    return dtBirthMotherRightsTerm;
  }
  public void setDtBirthMotherRightsTerm(Date dtBirthMotherRightsTerm) {
    this.dtBirthMotherRightsTerm = dtBirthMotherRightsTerm;
  }
  public String getIndBMMarriedAtChildBrth() {
    return indBMMarriedAtChildBrth;
  }
  public void setIndBMMarriedAtChildBrth(String indBMMarriedAtChildBrth) {
    this.indBMMarriedAtChildBrth = indBMMarriedAtChildBrth;
  }
  public String getIndBMRaceAA() {
    return indBMRaceAA;
  }
  public void setIndBMRaceAA(String indBMRaceAA) {
    this.indBMRaceAA = indBMRaceAA;
  }
  public String getIndBMRaceAN() {
    return indBMRaceAN;
  }
  public void setIndBMRaceAN(String indBMRaceAN) {
    this.indBMRaceAN = indBMRaceAN;
  }
  public String getIndBMRaceBK() {
    return indBMRaceBK;
  }
  public void setIndBMRaceBK(String indBMRaceBK) {
    this.indBMRaceBK = indBMRaceBK;
  }
  public String getIndBMRaceHP() {
    return indBMRaceHP;
  }
  public void setIndBMRaceHP(String indBMRaceHP) {
    this.indBMRaceHP = indBMRaceHP;
  }
  public String getIndBMRaceUD() {
    return indBMRaceUD;
  }
  public void setIndBMRaceUD(String indBMRaceUD) {
    this.indBMRaceUD = indBMRaceUD;
  }
  public String getIndBMRaceWT() {
    return indBMRaceWT;
  }
  public void setIndBMRaceWT(String indBMRaceWT) {
    this.indBMRaceWT = indBMRaceWT;
  }
  public String getCdBMEthnicity() {
    return cdBMEthnicity;
  }
  public void setCdBMEthnicity(String cdBMEthnicity) {
    this.cdBMEthnicity = cdBMEthnicity;
  }
  public Date getDtBirthFatherDOB() {
    return dtBirthFatherDOB;
  }
  public void setDtBirthFatherDOB(Date dtBirthFatherDOB) {
    this.dtBirthFatherDOB = dtBirthFatherDOB;
  }
  public String getCdBirthFatherTermType() {
    return cdBirthFatherTermType;
  }
  public void setCdBirthFatherTermType(String cdBirthFatherTermType) {
    this.cdBirthFatherTermType = cdBirthFatherTermType;
  }
  public Date getDtBirthFatherRightsTerm() {
    return dtBirthFatherRightsTerm;
  }
  public void setDtBirthFatherRightsTerm(Date dtBirthFatherRightsTerm) {
    this.dtBirthFatherRightsTerm = dtBirthFatherRightsTerm;
  }
  public String getIndBFRaceAA() {
    return indBFRaceAA;
  }
  public void setIndBFRaceAA(String indBFRaceAA) {
    this.indBFRaceAA = indBFRaceAA;
  }
  public String getIndBFRaceAN() {
    return indBFRaceAN;
  }
  public void setIndBFRaceAN(String indBFRaceAN) {
    this.indBFRaceAN = indBFRaceAN;
  }
  public String getIndBFRaceBK() {
    return indBFRaceBK;
  }
  public void setIndBFRaceBK(String indBFRaceBK) {
    this.indBFRaceBK = indBFRaceBK;
  }
  public String getIndBFRaceHP() {
    return indBFRaceHP;
  }
  public void setIndBFRaceHP(String indBFRaceHP) {
    this.indBFRaceHP = indBFRaceHP;
  }
  public String getIndBFRaceUD() {
    return indBFRaceUD;
  }
  public void setIndBFRaceUD(String indBFRaceUD) {
    this.indBFRaceUD = indBFRaceUD;
  }
  public String getIndBFRaceWT() {
    return indBFRaceWT;
  }
  public void setIndBFRaceWT(String indBFRaceWT) {
    this.indBFRaceWT = indBFRaceWT;
  }
  public String getCdBFEthnicity() {
    return cdBFEthnicity;
  }
  public void setCdBFEthnicity(String cdBFEthnicity) {
    this.cdBFEthnicity = cdBFEthnicity;
  }
  public ArrayList getBMRaceList() {
    return bmRaceList;
  }
  public void setBMRaceList(ArrayList bmRaceList) {
    this.bmRaceList = bmRaceList;
  }
  public ArrayList getBFRaceList() {
    return bfRaceList;
  }
  public void setBFRaceList(ArrayList bfRaceList) {
    this.bfRaceList = bfRaceList;
  }
  public String getNmEmployee() {
    return nmEmployee;
  }
  public void setNmEmployee(String nmEmployee) {
    this.nmEmployee = nmEmployee;
  }
  public String getEmployeePhone() {
    return employeePhone;
  }
  public void setEmployeePhone(String employeePhone) {
    this.employeePhone = employeePhone;
  }
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }
  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }
  public String getIndAPNonRelative() {
    return indAPNonRelative;
  }
  public void setIndAPNonRelative(String indAPNonRelative) {
    this.indAPNonRelative = indAPNonRelative;
  }
  public String getIndAPPriorFP() {
    return indAPPriorFP;
  }
  public void setIndAPPriorFP(String indAPPriorFP) {
    this.indAPPriorFP = indAPPriorFP;
  }
  public String getIndAPOtherRelative() {
    return indAPOtherRelative;
  }
  public void setIndAPOtherRelative(String indAPOtherRelative) {
    this.indAPOtherRelative = indAPOtherRelative;
  }
  public String getIndAPStepParent() {
    return indAPStepParent;
  }
  public void setIndAPStepParent(String indAPStepParent) {
    this.indAPStepParent = indAPStepParent;
  }
  public String getCdPlcmtBy() {
    return cdPlcmtBy;
  }
  public void setCdPlcmtBy(String cdPlcmtBy) {
    this.cdPlcmtBy = cdPlcmtBy;
  }
  public String getCdPlacementFrom() {
    return cdPlacementFrom;
  }
  public void setCdPlacementFrom(String cdPlacementFrom) {
    this.cdPlacementFrom = cdPlacementFrom;
  }
  public String getCdPlacmentCounty() {
    return cdPlacmentCounty;
  }
  public void setCdPlacmentCounty(String cdPlacmentCounty) {
    this.cdPlacmentCounty = cdPlacmentCounty;
  }
  public String getCdMaritalStatus() {
    return cdMaritalStatus;
  }
  public void setCdMaritalStatus(String cdMaritalStatus) {
    this.cdMaritalStatus = cdMaritalStatus;
  }
  public ArrayList getAmRaceList() {
    return amRaceList;
  }
  public void setAmRaceList(ArrayList amRaceList) {
    this.amRaceList = amRaceList;
  }
  public ArrayList getAfRaceList() {
    return afRaceList;
  }
  public void setAfRaceList(ArrayList afRaceList) {
    this.afRaceList = afRaceList;
  }
  public String getCdAFEthnicity() {
    return cdAFEthnicity;
  }
  public void setCdAFEthnicity(String cdAFEthnicity) {
    this.cdAFEthnicity = cdAFEthnicity;
  }
  public String getCdAMEthnicity() {
    return cdAMEthnicity;
  }
  public void setCdAMEthnicity(String cdAMEthnicity) {
    this.cdAMEthnicity = cdAMEthnicity;
  }
  public Date getDtAdoptiveMotherDOB() {
    return dtAdoptiveMotherDOB;
  }
  public void setDtAdoptiveMotherDOB(Date dtAdoptiveMotherDOB) {
    this.dtAdoptiveMotherDOB = dtAdoptiveMotherDOB;
  }
  public Date getDtAdoptiveFatherDOB() {
    return dtAdoptiveFatherDOB;
  }
  public void setDtAdoptiveFatherDOB(Date dtAdoptiveFatherDOB) {
    this.dtAdoptiveFatherDOB = dtAdoptiveFatherDOB;
  }
  
}
