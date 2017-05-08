package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*

Change History:
Date      User      Description
--------  --------  --------------------------------------------------
03/02/09   mxpatel   STGAP00012533: added dtPermFile field and get and set methods for this.
*/

public class ExchangeHomeDetailSO implements Serializable {
  private ROWCCMN01UIG00 event = null;
  
  // Regisration Info
  private String homeName = null;
  private String caseWorkerName = null;
  private String caseWorkerPhoneNumber = null;
  private String agencyName = null;
  private String agencyCaseWorkerName = null;
  private String agencyContractNumber = null;
  private String phoneNumber = null;
  private String phoneNumberExt = null;
  private Date dtInquired = null;
  private Date dtApplied = null;
  private Date dtImpactBegin = null;
  private Date dtOrientation = null;
  private Date dtApproved = null;
  private Date dtReRegistered = null;
  private Date dtRegistered = null;
  private Date dtLastUpdate = null;
  private String cdCounty = null;
  private String cdRegion = null;
  private Integer idResource = null;
  private Date dtLastUpdateDisplay = null;
  
  //Family Demographic Info
  private Date  dtFatherDOB = null;
  private String fatherRace = null;
  private String fatherEthnicity = null;
  private String fatherOccupation = null;
  private String fatherReligion = null;
  
  private Date dtMotherDOB = null;
  private String motherRace = null;
  private String motherEthnicity = null;
  private String motherOccupation = null;
  private String motherReligion = null;
  
  //Home Preferences
  private String indMentalRetardation = null;
  private String cdLevelMentalRetardation = null;
  private String indVisualHearingImpairments = null;
  private String cdLevelVisualHearingImpairments  = null;
  private String indPhysicallyDisabled = null;
  private String cdLevelPhysicallyDisabled  = null;
  private String indEmotionallyDisturbed  = null;
  private String cdLevelEmotionallyDisturbed = null;
  private String indOtherMedicalDiagnoses = null;
  private String cdlevelOtherMedicalDiagnoses = null;
  private String indFamilyHxofDrugsAlcohol = null;  
  private String indFamilyHxofMentalIllness = null;
  private String indFamilyHxofMR = null;
  private String indChilsHxofSexualAbuse = null;
  private List<String> childRacePref = new ArrayList<String>();
  private List<String> childEthnicityPerf = new ArrayList<String>();
  private Integer numOfChildren = null;
  private String indCdGenderOfChildren = null;
  private Integer maleMinRangeInMonths = null;
  private Integer maleMaxRangeInMonths = null;
  private Integer femaleMinRangeInMonths = null;
  private Integer femaleMaxRangeInMonths = null;
  private String homePrefComments = null;
  
  //Home Availability
  private String cdNonAvReasonHA = null;
  private Date dateOutHA = null;
  private String numDaysOutHA = null;
  private String commentsHA = null;
  private String familyIsLinkedHA = null;
  
  private List<ExchangeHomeChildrenSO> childrenConsideringList = new ArrayList<ExchangeHomeChildrenSO>(); 
  private List<ExchangeHomeChildrenSO> childrenNonSelectedList = new ArrayList<ExchangeHomeChildrenSO>();
  
  //Close Record Info
  private Date dtClosedNP = null;
  private String cdReasonClosed = null;
  private String explanationNPComments = null;
  private String childrenPlacedCWP = null;
  private Date dtPlacedCWP = null;
  private String permissionToFileCWP = null;
  private Date dtDocSendDateCWP = null;
  private String cdCountyCWP = null;
  private String aFileNumCWP = null;
  private Date dtFinalCWP = null;
  private Date dtFinalEnteredCWP = null;
  private Date dtDisruptionCWP = null;
  private Date dtDissolutionCWP = null;
  private String childrenPlacedWithCommentCWP = null;
  private Date dtPermFile = null; //mxpatel 12533
  
  //mxpatel 12533
  public Date getDtPermFile(){
    return dtPermFile;
  }
  
  //mxpatel 12533
  public void setDtPermFile(Date dtPermFile){
    this.dtPermFile = dtPermFile;
  }
  
  public Integer getMaleMinRangeInMonths() {
    return maleMinRangeInMonths;
  }

  public void setMaleMinRangeInMonths(Integer maleMinRangeInMonths) {
    this.maleMinRangeInMonths = maleMinRangeInMonths;
  }

  public Integer getMaleMaxRangeInMonths() {
    return maleMaxRangeInMonths;
  }

  public void setMaleMaxRangeInMonths(Integer maleMaxRangeInMonths) {
    this.maleMaxRangeInMonths = maleMaxRangeInMonths;
  }

  public Integer getFemaleMinRangeInMonths() {
    return femaleMinRangeInMonths;
  }

  public void setFemaleMinRangeInMonths(Integer femaleMinRangeInMonths) {
    this.femaleMinRangeInMonths = femaleMinRangeInMonths;
  }

  public Integer getFemaleMaxRangeInMonths() {
    return femaleMaxRangeInMonths;
  }

  public void setFemaleMaxRangeInMonths(Integer femaleMaxRangeInMonths) {
    this.femaleMaxRangeInMonths = femaleMaxRangeInMonths;
  }

  public String getHomePrefComments() {
    return homePrefComments;
  }

  public void setHomePrefComments(String homePrefComments) {
    this.homePrefComments = homePrefComments;
  }

  public String getHomeName() {
    return homeName;
  }

  public void setHomeName(String name) {
    this.homeName = name;
  }

  public String getCaseWorkerName() {
    return caseWorkerName;
  }

  public void setCaseWorkerName(String caseWorkerName) {
    this.caseWorkerName = caseWorkerName;
  }

  public String getCaseWorkerPhoneNumber() {
    return caseWorkerPhoneNumber;
  }

  public void setCaseWorkerPhoneNumber(String caseWorkerPhoneNumber) {
    this.caseWorkerPhoneNumber = caseWorkerPhoneNumber;
  }

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  public String getAgencyCaseWorkerName() {
    return agencyCaseWorkerName;
  }

  public void setAgencyCaseWorkerName(String agencyCaseWorkerName) {
    this.agencyCaseWorkerName = agencyCaseWorkerName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumberExt() {
    return phoneNumberExt;
  }

  public void setPhoneNumberExt(String phoneNumberExt) {
    this.phoneNumberExt = phoneNumberExt;
  }

  public String getIndMentalRetardation() {
    return indMentalRetardation;
  }

  public void setIndMentalRetardation(String indMentalRetardation) {
    this.indMentalRetardation = indMentalRetardation;
  }

  public String getCdLevelMentalRetardation() {
    return cdLevelMentalRetardation;
  }

  public void setCdLevelMentalRetardation(String cdLevelMentalRetardation) {
    this.cdLevelMentalRetardation = cdLevelMentalRetardation;
  }

  public String getIndVisualHearingImpairments() {
    return indVisualHearingImpairments;
  }

  public void setIndVisualHearingImpairments(String indVisualHearingImpairments) {
    this.indVisualHearingImpairments = indVisualHearingImpairments;
  }

  public String getCdLevelVisualHearingImpairments() {
    return cdLevelVisualHearingImpairments;
  }

  public void setCdLevelVisualHearingImpairments(String cdLevelVisualHearingImpairments) {
    this.cdLevelVisualHearingImpairments = cdLevelVisualHearingImpairments;
  }

  public String getIndPhysicallyDisabled() {
    return indPhysicallyDisabled;
  }

  public void setIndPhysicallyDisabled(String indPhysicallyDisabled) {
    this.indPhysicallyDisabled = indPhysicallyDisabled;
  }

  public String getCdLevelPhysicallyDisabled() {
    return cdLevelPhysicallyDisabled;
  }

  public void setCdLevelPhysicallyDisabled(String cdLevelPhysicallyDisabled) {
    this.cdLevelPhysicallyDisabled = cdLevelPhysicallyDisabled;
  }

  public String getIndEmotionallyDisturbed() {
    return indEmotionallyDisturbed;
  }

  public void setIndEmotionallyDisturbed(String indEmotionallyDisturbed) {
    this.indEmotionallyDisturbed = indEmotionallyDisturbed;
  }

  public String getCdLevelEmotionallyDisturbed() {
    return cdLevelEmotionallyDisturbed;
  }

  public void setCdLevelEmotionallyDisturbed(String cdLevelEmotionallyDisturbed) {
    this.cdLevelEmotionallyDisturbed = cdLevelEmotionallyDisturbed;
  }

  public String getIndOtherMedicalDiagnoses() {
    return indOtherMedicalDiagnoses;
  }

  public void setIndOtherMedicalDiagnoses(String indOtherMedicalDiagnoses) {
    this.indOtherMedicalDiagnoses = indOtherMedicalDiagnoses;
  }

  public String getCdlevelOtherMedicalDiagnoses() {
    return cdlevelOtherMedicalDiagnoses;
  }

  public void setCdlevelOtherMedicalDiagnoses(String cdlevelOtherMedicalDiagnoses) {
    this.cdlevelOtherMedicalDiagnoses = cdlevelOtherMedicalDiagnoses;
  }

  public String getIndFamilyHxofDrugsAlcohol() {
    return indFamilyHxofDrugsAlcohol;
  }

  public void setIndFamilyHxofDrugsAlcohol(String indFamilyHxofDrugsAlcohol) {
    this.indFamilyHxofDrugsAlcohol = indFamilyHxofDrugsAlcohol;
  }

  public String getIndFamilyHxofMentalIllness() {
    return indFamilyHxofMentalIllness;
  }

  public void setIndFamilyHxofMentalIllness(String indFamilyHxofMentalIllness) {
    this.indFamilyHxofMentalIllness = indFamilyHxofMentalIllness;
  }

  public String getIndFamilyHxofMR() {
    return indFamilyHxofMR;
  }

  public void setIndFamilyHxofMR(String indFamilyHxofMR) {
    this.indFamilyHxofMR = indFamilyHxofMR;
  }

  public String getIndChilsHxofSexualAbuse() {
    return indChilsHxofSexualAbuse;
  }

  public void setIndChilsHxofSexualAbuse(String indChilsHxofSexualAbuse) {
    this.indChilsHxofSexualAbuse = indChilsHxofSexualAbuse;
  }

  public Date getDtInquired() {
    return dtInquired;
  }

  public void setDtInquired(Date dtInquired) {
    this.dtInquired = dtInquired;
  }

  public Date getDtApplied() {
    return dtApplied;
  }

  public void setDtApplied(Date dtApplied) {
    this.dtApplied = dtApplied;
  }

  public Date getDtImpactBegin() {
    return dtImpactBegin;
  }

  public void setDtImpactBegin(Date dtImpactBegin) {
    this.dtImpactBegin = dtImpactBegin;
  }

  public Date getDtOrientation() {
    return dtOrientation;
  }

  public void setDtOrientation(Date dtOrientation) {
    this.dtOrientation = dtOrientation;
  }

  public Date getDtApproved() {
    return dtApproved;
  }

  public void setDtApproved(Date dtApproved) {
    this.dtApproved = dtApproved;
  }

  public Date getDtReRegistered() {
    return dtReRegistered;
  }

  public void setDtReRegistered(Date dtReRegistered) {
    this.dtReRegistered = dtReRegistered;
  }

  public Date getDtRegistered() {
    return dtRegistered;
  }

  public void setDtRegistered(Date dtRegistered) {
    this.dtRegistered = dtRegistered;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public String getCdCounty() {
    return cdCounty;
  }

  public void setCdCounty(String cdCounty) {
    this.cdCounty = cdCounty;
  }

  public String getCdRegion() {
    return cdRegion;
  }

  public void setCdRegion(String cdRegion) {
    this.cdRegion = cdRegion;
  }

  public Integer getIdResource() {
    return idResource;
  }

  public void setIdResource(Integer idResource) {
    this.idResource = idResource;
  }

  public ROWCCMN01UIG00 getEvent() {
    return event;
  }

  public void setEvent(ROWCCMN01UIG00 event) {
    this.event = event;
  }

  public List<String> getChildRacePref() {
    return childRacePref;
  }

  public void setChildRacePref(List<String> childRacePref) {
    this.childRacePref = childRacePref;
  }

  public Date getDtFatherDOB() {
    return dtFatherDOB;
  }

  public void setDtFatherDOB(Date dtFatherDOB) {
    this.dtFatherDOB = dtFatherDOB;
  }

  public String getFatherRace() {
    return fatherRace;
  }

  public void setFatherRace(String fatherRace) {
    this.fatherRace = fatherRace;
  }

  public String getFatherEthnicity() {
    return fatherEthnicity;
  }

  public void setFatherEthnicity(String fatherEthnicity) {
    this.fatherEthnicity = fatherEthnicity;
  }

  public String getFatherOccupation() {
    return fatherOccupation;
  }

  public void setFatherOccupation(String fatherOccupation) {
    this.fatherOccupation = fatherOccupation;
  }

  public String getFatherReligion() {
    return fatherReligion;
  }

  public void setFatherReligion(String fatherReligion) {
    this.fatherReligion = fatherReligion;
  }

  public Date getDtMotherDOB() {
    return dtMotherDOB;
  }

  public void setDtMotherDOB(Date dtMotherDOB) {
    this.dtMotherDOB = dtMotherDOB;
  }

  public String getMotherRace() {
    return motherRace;
  }

  public void setMotherRace(String motherRace) {
    this.motherRace = motherRace;
  }

  public String getMotherEthnicity() {
    return motherEthnicity;
  }

  public void setMotherEthnicity(String motherEthnicity) {
    this.motherEthnicity = motherEthnicity;
  }

  public String getMotherOccupation() {
    return motherOccupation;
  }

  public void setMotherOccupation(String motherOccupation) {
    this.motherOccupation = motherOccupation;
  }

  public String getMotherReligion() {
    return motherReligion;
  }

  public void setMotherReligion(String motherReligion) {
    this.motherReligion = motherReligion;
  }

  public List<String> getChildEthnicityPerf() {
    return childEthnicityPerf;
  }

  public void setChildEthnicityPerf(List<String> childEthnicityPerf) {
    this.childEthnicityPerf = childEthnicityPerf;
  }

  public Integer getNumOfChildren() {
    return numOfChildren;
  }

  public void setNumOfChildren(Integer numOfChildren) {
    this.numOfChildren = numOfChildren;
  }

  public String getIndCdGenderOfChildren() {
    return indCdGenderOfChildren;
  }

  public void setIndCdGenderOfChildren(String indCdGenderOfChildren) {
    this.indCdGenderOfChildren = indCdGenderOfChildren;
  }

  public Date getDtClosedNP() {
    return dtClosedNP;
  }

  public void setDtClosedNP(Date dtClosedNP) {
    this.dtClosedNP = dtClosedNP;
  }

  public String getCdReasonClosed() {
    return cdReasonClosed;
  }

  public void setCdReasonClosed(String cdReasonClosed) {
    this.cdReasonClosed = cdReasonClosed;
  }

  public String getExplanationNPComments() {
    return explanationNPComments;
  }

  public void setExplanationNPComments(String explanationNPComments) {
    this.explanationNPComments = explanationNPComments;
  }

  public String getChildrenPlacedCWP() {
    return childrenPlacedCWP;
  }

  public void setChildrenPlacedCWP(String childrenPlacedCWP) {
    this.childrenPlacedCWP = childrenPlacedCWP;
  }

  public Date getDtPlacedCWP() {
    return dtPlacedCWP;
  }

  public void setDtPlacedCWP(Date dtPlacedCWP) {
    this.dtPlacedCWP = dtPlacedCWP;
  }

  public String getPermissionToFileCWP() {
    return permissionToFileCWP;
  }

  public void setPermissionToFileCWP(String permissionToFileCWP) {
    this.permissionToFileCWP = permissionToFileCWP;
  }

  public Date getDtDocSendDateCWP() {
    return dtDocSendDateCWP;
  }

  public void setDtDocSendDateCWP(Date dtDocSendDateCWP) {
    this.dtDocSendDateCWP = dtDocSendDateCWP;
  }

  public String getCdCountyCWP() {
    return cdCountyCWP;
  }

  public void setCdCountyCWP(String cdCountyCWP) {
    this.cdCountyCWP = cdCountyCWP;
  }

  public String getAFileNumCWP() {
    return aFileNumCWP;
  }

  public void setAFileNumCWP(String fileNumCWP) {
    aFileNumCWP = fileNumCWP;
  }

  public Date getDtFinalCWP() {
    return dtFinalCWP;
  }

  public void setDtFinalCWP(Date dtFinalCWP) {
    this.dtFinalCWP = dtFinalCWP;
  }

  public Date getDtFinalEnteredCWP() {
    return dtFinalEnteredCWP;
  }

  public void setDtFinalEnteredCWP(Date dtFinalEnteredCWP) {
    this.dtFinalEnteredCWP = dtFinalEnteredCWP;
  }


 
  public String getChildrenPlacedWithCommentCWP() {
    return childrenPlacedWithCommentCWP;
  }

  public void setChildrenPlacedWithCommentCWP(String childrenPlacedWithCommentCWP) {
    this.childrenPlacedWithCommentCWP = childrenPlacedWithCommentCWP;
  }

  public String getCdNonAvReasonHA() {
    return cdNonAvReasonHA;
  }

  public void setCdNonAvReasonHA(String cdNonAvReasonHA) {
    this.cdNonAvReasonHA = cdNonAvReasonHA;
  }

  public Date getDateOutHA() {
    return dateOutHA;
  }

  public void setDateOutHA(Date dateOutHA) {
    this.dateOutHA = dateOutHA;
  }

  public String getNumDaysOutHA() {
    return numDaysOutHA;
  }

  public void setNumDaysOutHA(String numDaysOutHA) {
    this.numDaysOutHA = numDaysOutHA;
  }

  public String getCommentsHA() {
    return commentsHA;
  }

  public void setCommentsHA(String commentsHA) {
    this.commentsHA = commentsHA;
  }

  public String getFamilyIsLinkedHA() {
    return familyIsLinkedHA;
  }

  public void setFamilyIsLinkedHA(String familyIsLinkedHA) {
    this.familyIsLinkedHA = familyIsLinkedHA;
  }

  public List<ExchangeHomeChildrenSO> getChildrenConsideringList() {
    return childrenConsideringList;
  }

  public void setChildrenConsideringList(List<ExchangeHomeChildrenSO> childrenList) {
    this.childrenConsideringList = childrenList;
  }

  public List<ExchangeHomeChildrenSO> getChildrenNonSelectedList() {
    return childrenNonSelectedList;
  }

  public void setChildrenNonSelectedList(List<ExchangeHomeChildrenSO> childrenNonSelectedList) {
    this.childrenNonSelectedList = childrenNonSelectedList;
  }

  public Date getDtLastUpdateDisplay() {
    return dtLastUpdateDisplay;
  }

  public void setDtLastUpdateDisplay(Date dtLastUpdateDisplay) {
    this.dtLastUpdateDisplay = dtLastUpdateDisplay;
  }

  public Date getDtDisruptionCWP() {
    return dtDisruptionCWP;
  }

  public void setDtDisruptionCWP(Date dtDisruptionCWP) {
    this.dtDisruptionCWP = dtDisruptionCWP;
  }

  public Date getDtDissolutionCWP() {
    return dtDissolutionCWP;
  }

  public void setDtDissolutionCWP(Date dtDissolutionCWP) {
    this.dtDissolutionCWP = dtDissolutionCWP;
  }

  public String getAgencyContractNumber() {
    return agencyContractNumber;
  }

  public void setAgencyContractNumber(String agencyContractNumber) {
    this.agencyContractNumber = agencyContractNumber;
  }
}
