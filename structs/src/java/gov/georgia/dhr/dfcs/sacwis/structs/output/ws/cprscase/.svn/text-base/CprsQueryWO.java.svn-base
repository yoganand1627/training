package gov.georgia.dhr.dfcs.sacwis.structs.output.ws.cprscase;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
                         
04/16/2009  bgehlot           STGAP00012856: Added new fields nbrPostReqCred, nbrPostReqEar, dtDecision , flgDate.
12/08/2009  hjbaptiste        SMS# 41275: Added new fields adultChildConnectedTo, childConnectedToAnAdult, dtLTFCAgreementSigned, 
                              isLTFCPlacement for APPLA. Additionally added new fields isTempPlacement, tempPlacementType, dtStatusEffective
06/20/2011  htvo              SMS#109405 MR-083: updated per peer review to indicate a new field cdStateActRecruiting was added per the MR
*/

public class CprsQueryWO implements Serializable {

  private String message = null;

  private List<Case> cases = null;

  public static class Case implements Serializable {
    private String caseId = null;

    private String caseName = null;
    
    private String county = null;

    private List<Stage> stages = null;
    
    private String message = null;
    
    private Date dateGenerated = null;

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public String getCaseId() {
      return caseId;
    }

    public void setCaseId(String caseId) {
      this.caseId = caseId;
    }

    public List<Stage> getStages() {
      return stages;
    }

    public void setStages(List<Stage> stages) {
      this.stages = stages;
    }

    public String getCaseName() {
      return caseName;
    }

    public void setCaseName(String caseName) {
      this.caseName = caseName;
    }

    public String getCounty() {
      return county;
    }

    public void setCounty(String county) {
      this.county = county;
    }

    public Date getDateGenerated() {
      return dateGenerated;
    }

    public void setDateGenerated(Date dateGenerated) {
      this.dateGenerated = dateGenerated;
    }
  }

  public static class Stage implements Serializable {
    private Child primaryChild = null;

    private String reviewMeth = null;

    private CaseTracking caseTracking = null;

    private Removal removal = null;

    private ASFA asfa = null;

    private List<PlanGoal> reunificationPlanGoals = null;

    private List<PlanGoal> nonReunificationPlanGoals = null;

    private List<PlanGoal> afterCarePlanGoalsPlanGoals = null;

    private List<PlanGoal> dcsPlanGoalsPlanGoals = null;

    private List<SecondaryGoal> secondaryGoals = null;

    private Nonreunification nonreunification = null;

    private Placement currentPlacement = null;

    private List<Placement> priorPlacements = null;

    private List<CaseManager> caseManagers = null;

    private List<CareTaker> careTakers = null;

    private List<Relative> relatives = null;

    private List<HealthCareProvider> healthCareProviders = null;

    private WTLP wtlp = null;

    private EducationHistory education = null;

    private HealthStatus healthStatus = null;

    private List<DiligentSearch> diligentSearches = null;

    private Aftercare aftercare = null;

    private Adoption adoption = null;

    private Participation participation = null;

    private CCFAMDT ccfAmdt = null;

    private List<String> visitationPlans = null;
    
    private Integer stageId = null;
    
    private Integer familyPlanId = null;
    
    private String familyPlanStatus= null;
    
    private Integer childPlanId = null;
    
    private String childPlanStatus = null;
    
    private String county = null;
    
    public HealthStatus getHealthStatus() {
      return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
      this.healthStatus = healthStatus;
    }

    public ASFA getAsfa() {
      return asfa;
    }

    public void setAsfa(ASFA asfa) {
      this.asfa = asfa;
    }

    public List<CareTaker> getCareTakers() {
      return careTakers;
    }

    public void setCareTakers(List<CareTaker> careTakers) {
      this.careTakers = careTakers;
    }

    public List<CaseManager> getCaseManagers() {
      return caseManagers;
    }

    public void setCaseManagers(List<CaseManager> caseManagers) {
      this.caseManagers = caseManagers;
    }

    public CaseTracking getCaseTracking() {
      return caseTracking;
    }

    public void setCaseTracking(CaseTracking caseTracking) {
      this.caseTracking = caseTracking;
    }

    public Placement getCurrentPlacement() {
      return currentPlacement;
    }

    public void setCurrentPlacement(Placement currentPlacement) {
      this.currentPlacement = currentPlacement;
    }

    public Nonreunification getNonreunification() {
      return nonreunification;
    }

    public void setNonreunification(Nonreunification nonreunification) {
      this.nonreunification = nonreunification;
    }

    public Child getPrimaryChild() {
      return primaryChild;
    }

    public void setPrimaryChild(Child primaryChild) {
      this.primaryChild = primaryChild;
    }

    public List<Placement> getPriorPlacements() {
      return priorPlacements;
    }

    public void setPriorPlacements(List<Placement> priorPlacements) {
      this.priorPlacements = priorPlacements;
    }

    public Removal getRemoval() {
      return removal;
    }

    public void setRemoval(Removal removal) {
      this.removal = removal;
    }

    public WTLP getWtlp() {
      return wtlp;
    }

    public void setWtlp(WTLP wtlp) {
      this.wtlp = wtlp;
    }

    public List<Relative> getRelatives() {
      return relatives;
    }

    public void setRelatives(List<Relative> relatives) {
      this.relatives = relatives;
    }

    public EducationHistory getEducation() {
      return education;
    }

    public void setEducation(EducationHistory education) {
      this.education = education;
    }

    public List<HealthCareProvider> getHealthCareProviders() {
      return healthCareProviders;
    }

    public void setHealthCareProviders(List<HealthCareProvider> healthCareProviders) {
      this.healthCareProviders = healthCareProviders;
    }

    public List<DiligentSearch> getDiligentSearches() {
      return diligentSearches;
    }

    public void setDiligentSearches(List<DiligentSearch> diligentSearches) {
      this.diligentSearches = diligentSearches;
    }

    public Adoption getAdoption() {
      return adoption;
    }

    public void setAdoption(Adoption adoption) {
      this.adoption = adoption;
    }

    public List<PlanGoal> getAfterCarePlanGoalsPlanGoals() {
      return afterCarePlanGoalsPlanGoals;
    }

    public void setAfterCarePlanGoalsPlanGoals(List<PlanGoal> afterCarePlanGoalsPlanGoals) {
      this.afterCarePlanGoalsPlanGoals = afterCarePlanGoalsPlanGoals;
    }

    public List<PlanGoal> getDcsPlanGoalsPlanGoals() {
      return dcsPlanGoalsPlanGoals;
    }

    public void setDcsPlanGoalsPlanGoals(List<PlanGoal> dcsPlanGoalsPlanGoals) {
      this.dcsPlanGoalsPlanGoals = dcsPlanGoalsPlanGoals;
    }

    public List<PlanGoal> getNonReunificationPlanGoals() {
      return nonReunificationPlanGoals;
    }

    public void setNonReunificationPlanGoals(List<PlanGoal> nonReunificationPlanGoals) {
      this.nonReunificationPlanGoals = nonReunificationPlanGoals;
    }

    public List<PlanGoal> getReunificationPlanGoals() {
      return reunificationPlanGoals;
    }

    public void setReunificationPlanGoals(List<PlanGoal> reunificationPlanGoals) {
      this.reunificationPlanGoals = reunificationPlanGoals;
    }

    public List<SecondaryGoal> getSecondaryGoals() {
      return secondaryGoals;
    }

    public void setSecondaryGoals(List<SecondaryGoal> secondaryGoals) {
      this.secondaryGoals = secondaryGoals;
    }

    public Participation getParticipation() {
      return participation;
    }

    public void setParticipation(Participation participation) {
      this.participation = participation;
    }

    public Aftercare getAftercare() {
      return aftercare;
    }

    public void setAftercare(Aftercare aftercare) {
      this.aftercare = aftercare;
    }

    public CCFAMDT getCcfAmdt() {
      return ccfAmdt;
    }

    public void setCcfAmdt(CCFAMDT ccfAmdt) {
      this.ccfAmdt = ccfAmdt;
    }

    public List<String> getVisitationPlans() {
      return visitationPlans;
    }

    public void setVisitationPlans(List<String> visitationPlans) {
      this.visitationPlans = visitationPlans;
    }

    public String getReviewMeth() {
      return reviewMeth;
    }

    public void setReviewMeth(String reviewMeth) {
      this.reviewMeth = reviewMeth;
    }

    public Integer getChildPlanId() {
      return childPlanId;
    }

    public void setChildPlanId(Integer childPlanId) {
      this.childPlanId = childPlanId;
    }

    public Integer getFamilyPlanId() {
      return familyPlanId;
    }

    public void setFamilyPlanId(Integer familyPlanId) {
      this.familyPlanId = familyPlanId;
    }

    public Integer getStageId() {
      return stageId;
    }

    public void setStageId(Integer stageId) {
      this.stageId = stageId;
    }

    public String getChildPlanStatus() {
      return childPlanStatus;
    }

    public void setChildPlanStatus(String childPlanStatus) {
      this.childPlanStatus = childPlanStatus;
    }

    public String getFamilyPlanStatus() {
      return familyPlanStatus;
    }

    public void setFamilyPlanStatus(String familyPlanStatus) {
      this.familyPlanStatus = familyPlanStatus;
    }

    public String getCounty() {
      return county;
    }

    public void setCounty(String county) {
      this.county = county;
    }
  }

  public static class GenPerson implements Serializable {
    
    private int idPerson;

    private String lastName = null;

    private String firstName = null;

    private String middlename = null;

    private String address1 = null;

    private String address2 = null;

    private String city = null;

    private String county = null;

    private String state = null;

    private String zip = null;

    private String phoneNumber = null;
    
    public String getAddress1() {
      return address1;
    }

    public void setAddress1(String address1) {
      this.address1 = address1;
    }

    public String getAddress2() {
      return address2;
    }

    public void setAddress2(String address2) {
      this.address2 = address2;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getCounty() {
      return county;
    }

    public void setCounty(String county) {
      this.county = county;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public int getIdPerson() {
      return idPerson;
    }

    public void setIdPerson(int idPerson) {
      this.idPerson = idPerson;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getMiddlename() {
      return middlename;
    }

    public void setMiddlename(String middlename) {
      this.middlename = middlename;
    }

    public String getPhoneNumber() {
      return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getZip() {
      return zip;
    }

    public void setZip(String zip) {
      this.zip = zip;
    }
  }

  public static class CareTaker extends GenPerson implements Serializable {
    private Date birthdate = null;

    private String ssn = null;
    
    private String relType = null;
    
    private String Comment = null;

    public String getRelType() {
      return relType;
    }

    public void setRelType(String relType) {
      this.relType = relType;
    }

    public String getComment() {
      return Comment;
    }

    public void setComment(String comment) {
      Comment = comment;
    }

    public Date getBirthdate() {
      return birthdate;
    }

    public void setBirthdate(Date birthdate) {
      this.birthdate = birthdate;
    }

    public String getSsn() {
      return ssn;
    }

    public void setSsn(String ssn) {
      this.ssn = ssn;
    }
  }

  public static class HealthCareProvider extends GenPerson implements Serializable {
    private String faxNumber = null;

    private String relType = null;

    public String getFaxNumber() {
      return faxNumber;
    }

    public String getRelType() {
      return relType;
    }

    public void setRelType(String relType) {
      this.relType = relType;
    }

    public void setFaxNumber(String faxNumber) {
      this.faxNumber = faxNumber;
    }
  }

  public static class Child implements Serializable {
    private int idPerson;

    private String lastName = null;

    private String firstName = null;

    private String middlename = null;
    
    private String legalStatus = null;
    
    private Date dtStatusEffective = null;
    
    private String race = null;

    private String hispanicOrign = null;

    private String permPlanType = null;

    private Date dischargeDt = null;

    private String dischargeReason;

    private String initOrReview = null;

    private Date birthdate = null;

    private String gender = null;

    private String assignedJudge = null;
    
    private String assignedJudgeDecode = null;
    
    private String assignedJudgeCode = null;

    private String ssn = null;

    public String getSsn() {
      return ssn;
    }

    public void setSsn(String ssn) {
      this.ssn = ssn;
    }

    public String getAssignedJudge() {
      return assignedJudge;
    }

    public void setAssignedJudge(String assignedJudge) {
      this.assignedJudge = assignedJudge;
    }
    
    public String getAssignedJudgeDecode() {
      return assignedJudgeDecode;
    }

    public void setAssignedJudgeDecode(String assignedJudgeDecode) {
      this.assignedJudgeDecode = assignedJudgeDecode;
    }
    
    public String getAssignedJudgeCode() {
      return assignedJudgeCode;
    }

    public void setAssignedJudgeCode(String assignedJudgeCode) {
      this.assignedJudgeCode = assignedJudgeCode;
    }

    public Date getBirthdate() {
      return birthdate;
    }

    public void setBirthdate(Date birthdate) {
      this.birthdate = birthdate;
    }

    public Date getDischargeDt() {
      return dischargeDt;
    }

    public void setDischargeDt(Date dischargeDt) {
      this.dischargeDt = dischargeDt;
    }

    public String getDischargeReason() {
      return dischargeReason;
    }

    public void setDischargeReason(String dischargeReason) {
      this.dischargeReason = dischargeReason;
    }

    public String getGender() {
      return gender;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

    public String getInitOrReview() {
      return initOrReview;
    }

    public void setInitOrReview(String initOrReview) {
      this.initOrReview = initOrReview;
    }

    public String getPermPlanType() {
      return permPlanType;
    }

    public void setPermPlanType(String permPlanType) {
      this.permPlanType = permPlanType;
    }

    public String getHispanicOrign() {
      return hispanicOrign;
    }

    public void setHispanicOrign(String hispanicOrign) {
      this.hispanicOrign = hispanicOrign;
    }

    public String getLegalStatus() {
      return legalStatus;
    }

    public Date getDtStatusEffective() {
      return dtStatusEffective;
    }

    public void setDtStatusEffective(Date dtStatusEffective) {
      this.dtStatusEffective = dtStatusEffective;
    }

    public void setLegalStatus(String legalStatus) {
      this.legalStatus = legalStatus;
    }

    public String getRace() {
      return race;
    }

    public void setRace(String race) {
      this.race = race;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public int getIdPerson() {
      return idPerson;
    }

    public void setIdPerson(int idPerson) {
      this.idPerson = idPerson;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getMiddlename() {
      return middlename;
    }

    public void setMiddlename(String middlename) {
      this.middlename = middlename;
    }
  }

  public static class Relative extends GenPerson implements Serializable {
    private String relType = null;
    
    private String Comment = null;

    private String tribalMember = null;
    
    private String sideOfFamily = null;
    
    public String getSideOfFamily() {
      return sideOfFamily;
    }

    public void setSideOfFamily(String sideOfFamily) {
      this.sideOfFamily = sideOfFamily;
    }

    public String getTribalMember() {
      return tribalMember;
    }

    public void setTribalMember(String tribalMember) {
      this.tribalMember = tribalMember;
    }

    public String getRelType() {
      return relType;
    }

    public void setRelType(String relType) {
      this.relType = relType;
    }

    public String getComment() {
      return Comment;
    }

    public void setComment(String comment) {
      Comment = comment;
    }
  }

  public static class CaseManager extends GenPerson implements Serializable {
    String emailAddress = null;

    String supervisorLastName = null;

    String supervisorFirstName = null;

    String supervisorPhoneNumber = null;
    
    Boolean primary = null;

    public String getEmailAddress() {
      return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
    }

    public String getSupervisorFirstName() {
      return supervisorFirstName;
    }

    public void setSupervisorFirstName(String supervisorFirstName) {
      this.supervisorFirstName = supervisorFirstName;
    }

    public String getSupervisorLastName() {
      return supervisorLastName;
    }

    public void setSupervisorLastName(String supervisorLastName) {
      this.supervisorLastName = supervisorLastName;
    }

    public String getSupervisorPhoneNumber() {
      return supervisorPhoneNumber;
    }

    public void setSupervisorPhoneNumber(String supervisorPhoneNumber) {
      this.supervisorPhoneNumber = supervisorPhoneNumber;
    }

    public Boolean getPrimary() {
      return primary;
    }

    public void setPrimary(Boolean primary) {
      this.primary = primary;
    }
  }

  public static class Placement implements Serializable {
    private Integer eventId = null;
    
    private String eventStatus = null;
    
    private String state = null;

    private String county = null;

    private String relationship = null;

    private Date enteredDt = null;

    private String type = null;
    
    private Date exitedDt = null;

    private String removalReason = null;

    private String cCCFAPlacementRec = null;

    private String cCCFAPlacementMatch = null;

    private String cCCFAPlacementComment = null;
    
    //
    
    private String address1 = null;

    private String address2 = null;

    private String city = null;

    private String zip = null;

    private String homePhone = null;

    private String officePhone = null;

    private String fax = null;

    private String mobliePhone = null;

    private String relativeName = null;

    private String exhaustiveSearchPerformed = null;

    private String safeSetting = null;

    private String leastRestrictive = null;

    private String mostFamilyLike = null;

    private String plcmtAppro = null;

    private String closeProxToParents = null;

    private String consistChildBestInter = null;

    private String notExp = null;

    private String is14Older = null;
    
    private String isLTFCPlacement = null;
    
    private String isTempPlacement = null; 
    
    private String tempPlacementType = null;

    private String adjustingToCare = null;

    private String notAdjustingToCareCmmt = null;

    private String stayWithSiblings = null;

    private String stayWithSiblingsCmmt = null;

    private Date refCCFADt = null;

    private String changeSchDist = null;

    private String changeSchDistCmmt = null;

    private Date parentNotifiedDate = null;

    private String childResponse = null;

    private Date discussedWithChildDate = null;

    private String emergencyPlacement = null;

    private Date prePlaceVisitDt = null;

    private String childexpTraumaDueToPlac = null;

    private String childexpTraumaDueToPlacCmmt = null;
    
    private String childConnectedToAnAdult = null;
    
    private String adultChildConnectedTo = null;

    private Date psychInfoDt = null;

    private Date medInfoDt = null;

    private Date educInfoDt = null;

    private String childEduNotProvidedCmmts = null;

    private String dfcsHomeAssmtResults = null;

    private Date dfcsHomeAssmtResultCompletedDt = null;

    private String dfcsHomeAssmtResultCmmts = null;

    private Date schlRecGivenToCGDt = null;

    private Date plcmtCPGivenToCGDt = null;

    private String recNotGivenToCGCmmts = null;
    
    private Date dtDecision = null;
    
    private Date dtLTFCAgreementSigned = null;
    
    

    public String getCounty() {
      return county;
    }

    public void setCounty(String county) {
      this.county = county;
    }

    public Date getEnteredDt() {
      return enteredDt;
    }

    public void setEnteredDt(Date enteredDt) {
      this.enteredDt = enteredDt;
    }

    public String getRelationship() {
      return relationship;
    }

    public void setRelationship(String relationship) {
      this.relationship = relationship;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getCCCFAPlacementComment() {
      return cCCFAPlacementComment;
    }

    public void setCCCFAPlacementComment(String placementComment) {
      cCCFAPlacementComment = placementComment;
    }

    public String getCCCFAPlacementMatch() {
      return cCCFAPlacementMatch;
    }

    public void setCCCFAPlacementMatch(String placementMatch) {
      cCCFAPlacementMatch = placementMatch;
    }

    public String getCCCFAPlacementRec() {
      return cCCFAPlacementRec;
    }

    public void setCCCFAPlacementRec(String placementRec) {
      cCCFAPlacementRec = placementRec;
    }

    public Date getExitedDt() {
      return exitedDt;
    }

    public void setExitedDt(Date exitedDt) {
      this.exitedDt = exitedDt;
    }

    public String getRemovalReason() {
      return removalReason;
    }

    public void setRemovalReason(String removalReason) {
      this.removalReason = removalReason;
    }

    public String getAddress1() {
      return address1;
    }

    public void setAddress1(String address1) {
      this.address1 = address1;
    }

    public String getAddress2() {
      return address2;
    }

    public void setAddress2(String address2) {
      this.address2 = address2;
    }

    public String getAdjustingToCare() {
      return adjustingToCare;
    }

    public void setAdjustingToCare(String adjustingToCare) {
      this.adjustingToCare = adjustingToCare;
    }

    public String getChangeSchDist() {
      return changeSchDist;
    }

    public void setChangeSchDist(String changeSchDist) {
      this.changeSchDist = changeSchDist;
    }

    public String getChangeSchDistCmmt() {
      return changeSchDistCmmt;
    }

    public void setChangeSchDistCmmt(String changeSchDistCmmt) {
      this.changeSchDistCmmt = changeSchDistCmmt;
    }

    public String getChildEduNotProvidedCmmts() {
      return childEduNotProvidedCmmts;
    }

    public void setChildEduNotProvidedCmmts(String childEduNotProvidedCmmts) {
      this.childEduNotProvidedCmmts = childEduNotProvidedCmmts;
    }

    public String getChildexpTraumaDueToPlac() {
      return childexpTraumaDueToPlac;
    }

    public void setChildexpTraumaDueToPlac(String childexpTraumaDueToPlac) {
      this.childexpTraumaDueToPlac = childexpTraumaDueToPlac;
    }

    public String getChildexpTraumaDueToPlacCmmt() {
      return childexpTraumaDueToPlacCmmt;
    }

    public void setChildexpTraumaDueToPlacCmmt(String childexpTraumaDueToPlacCmmt) {
      this.childexpTraumaDueToPlacCmmt = childexpTraumaDueToPlacCmmt;
    }
    
    public String getChildConnectedToAnAdult() {
      return childConnectedToAnAdult;
    }

    public void setChildConnectedToAnAdult(String childConnectedToAnAdult) {
      this.childConnectedToAnAdult = childConnectedToAnAdult;
    }
    
    public String getAdultChildConnectedTo() {
      return adultChildConnectedTo;
    }

    public void setAdultChildConnectedTo(String adultChildConnectedTo) {
      this.adultChildConnectedTo = adultChildConnectedTo;
    }

    public String getChildResponse() {
      return childResponse;
    }

    public void setChildResponse(String childResponse) {
      this.childResponse = childResponse;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getCloseProxToParents() {
      return closeProxToParents;
    }

    public void setCloseProxToParents(String closeProxToParents) {
      this.closeProxToParents = closeProxToParents;
    }

    public String getConsistChildBestInter() {
      return consistChildBestInter;
    }

    public void setConsistChildBestInter(String consistChildBestInter) {
      this.consistChildBestInter = consistChildBestInter;
    }

    public String getDfcsHomeAssmtResultCmmts() {
      return dfcsHomeAssmtResultCmmts;
    }

    public void setDfcsHomeAssmtResultCmmts(String dfcsHomeAssmtResultCmmts) {
      this.dfcsHomeAssmtResultCmmts = dfcsHomeAssmtResultCmmts;
    }

    public Date getDfcsHomeAssmtResultCompletedDt() {
      return dfcsHomeAssmtResultCompletedDt;
    }

    public void setDfcsHomeAssmtResultCompletedDt(Date dfcsHomeAssmtResultCompletedDt) {
      this.dfcsHomeAssmtResultCompletedDt = dfcsHomeAssmtResultCompletedDt;
    }

    public String getDfcsHomeAssmtResults() {
      return dfcsHomeAssmtResults;
    }

    public void setDfcsHomeAssmtResults(String dfcsHomeAssmtResults) {
      this.dfcsHomeAssmtResults = dfcsHomeAssmtResults;
    }

    public Date getDiscussedWithChildDate() {
      return discussedWithChildDate;
    }

    public void setDiscussedWithChildDate(Date discussedWithChildDate) {
      this.discussedWithChildDate = discussedWithChildDate;
    }

    public Date getEducInfoDt() {
      return educInfoDt;
    }

    public void setEducInfoDt(Date educInfoDt) {
      this.educInfoDt = educInfoDt;
    }

    public String getEmergencyPlacement() {
      return emergencyPlacement;
    }

    public void setEmergencyPlacement(String emergencyPlacement) {
      this.emergencyPlacement = emergencyPlacement;
    }

    public String getExhaustiveSearchPerformed() {
      return exhaustiveSearchPerformed;
    }

    public void setExhaustiveSearchPerformed(String exhaustiveSearchPerformed) {
      this.exhaustiveSearchPerformed = exhaustiveSearchPerformed;
    }

    public String getFax() {
      return fax;
    }

    public void setFax(String fax) {
      this.fax = fax;
    }

    public String getHomePhone() {
      return homePhone;
    }

    public void setHomePhone(String homePhone) {
      this.homePhone = homePhone;
    }

    public String getIs14Older() {
      return is14Older;
    }

    public void setIs14Older(String is14Older) {
      this.is14Older = is14Older;
    }
    
    public String getIsLTFCPlacement() {
      return isLTFCPlacement;
    }

    public void setIsLTFCPlacement(String isLTFCPlacement) {
      this.isLTFCPlacement = isLTFCPlacement;
    }
    
    public String getIsTempPlacement() {
      return isTempPlacement;
    }

    public void setIsTempPlacement(String isTempPlacement) {
      this.isTempPlacement = isTempPlacement;
    }

    public String getTempPlacementType() {
      return tempPlacementType;
    }

    public void setTempPlacementType(String tempPlacementType) {
      this.tempPlacementType = tempPlacementType;
    }
    
    public String getLeastRestrictive() {
      return leastRestrictive;
    }

    public void setLeastRestrictive(String leastRestrictive) {
      this.leastRestrictive = leastRestrictive;
    }

    public Date getMedInfoDt() {
      return medInfoDt;
    }

    public void setMedInfoDt(Date medInfoDt) {
      this.medInfoDt = medInfoDt;
    }

    public String getMobliePhone() {
      return mobliePhone;
    }

    public void setMobliePhone(String mobliePhone) {
      this.mobliePhone = mobliePhone;
    }

    public String getMostFamilyLike() {
      return mostFamilyLike;
    }

    public void setMostFamilyLike(String mostFamilyLike) {
      this.mostFamilyLike = mostFamilyLike;
    }

    public String getNotAdjustingToCareCmmt() {
      return notAdjustingToCareCmmt;
    }

    public void setNotAdjustingToCareCmmt(String notAdjustingToCareCmmt) {
      this.notAdjustingToCareCmmt = notAdjustingToCareCmmt;
    }

    public String getNotExp() {
      return notExp;
    }

    public void setNotExp(String notExp) {
      this.notExp = notExp;
    }

    public String getOfficePhone() {
      return officePhone;
    }

    public void setOfficePhone(String officePhone) {
      this.officePhone = officePhone;
    }

    public Date getParentNotifiedDate() {
      return parentNotifiedDate;
    }

    public void setParentNotifiedDate(Date parentNotifiedDate) {
      this.parentNotifiedDate = parentNotifiedDate;
    }

    public String getPlcmtAppro() {
      return plcmtAppro;
    }

    public void setPlcmtAppro(String plcmtAppro) {
      this.plcmtAppro = plcmtAppro;
    }

    public Date getPlcmtCPGivenToCGDt() {
      return plcmtCPGivenToCGDt;
    }

    public void setPlcmtCPGivenToCGDt(Date plcmtCPGivenToCGDt) {
      this.plcmtCPGivenToCGDt = plcmtCPGivenToCGDt;
    }

    public Date getPrePlaceVisitDt() {
      return prePlaceVisitDt;
    }

    public void setPrePlaceVisitDt(Date prePlaceVisitDt) {
      this.prePlaceVisitDt = prePlaceVisitDt;
    }

    public Date getPsychInfoDt() {
      return psychInfoDt;
    }

    public void setPsychInfoDt(Date psychInfoDt) {
      this.psychInfoDt = psychInfoDt;
    }

    public String getRecNotGivenToCGCmmts() {
      return recNotGivenToCGCmmts;
    }

    public void setRecNotGivenToCGCmmts(String recNotGivenToCGCmmts) {
      this.recNotGivenToCGCmmts = recNotGivenToCGCmmts;
    }

    public Date getRefCCFADt() {
      return refCCFADt;
    }

    public void setRefCCFADt(Date refCCFADt) {
      this.refCCFADt = refCCFADt;
    }

    public String getRelativeName() {
      return relativeName;
    }

    public void setRelativeName(String relativeName) {
      this.relativeName = relativeName;
    }

    public String getSafeSetting() {
      return safeSetting;
    }

    public void setSafeSetting(String safeSetting) {
      this.safeSetting = safeSetting;
    }

    public Date getSchlRecGivenToCGDt() {
      return schlRecGivenToCGDt;
    }

    public void setSchlRecGivenToCGDt(Date schlRecGivenToCGDt) {
      this.schlRecGivenToCGDt = schlRecGivenToCGDt;
    }

    public String getStayWithSiblings() {
      return stayWithSiblings;
    }

    public void setStayWithSiblings(String stayWithSiblings) {
      this.stayWithSiblings = stayWithSiblings;
    }

    public String getStayWithSiblingsCmmt() {
      return stayWithSiblingsCmmt;
    }

    public void setStayWithSiblingsCmmt(String stayWithSiblingsCmmt) {
      this.stayWithSiblingsCmmt = stayWithSiblingsCmmt;
    }

    public String getZip() {
      return zip;
    }

    public void setZip(String zip) {
      this.zip = zip;
    }

    public Integer getEventId() {
      return eventId;
    }

    public void setEventId(Integer eventId) {
      this.eventId = eventId;
    }

    public String getEventStatus() {
      return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
      this.eventStatus = eventStatus;
    }
    
    public Date getDtDecision() {
      return dtDecision;
    }

    public void setDtDecision(Date dtDecision) {
      this.dtDecision = dtDecision;
    }
    
    public Date getDtLTFCAgreementSigned() {
      return dtLTFCAgreementSigned;
    }

    public void setDtLTFCAgreementSigned(Date dtLTFCAgreementSigned) {
      this.dtLTFCAgreementSigned = dtLTFCAgreementSigned;
    }
  }

 
  public static class Item implements Serializable {
    private String name = null;

    private String value = null;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  public static class ASFA implements Serializable {
    private List<Item> items = null;

    private String details = null;

    public String getDetails() {
      return details;
    }

    public void setDetails(String details) {
      this.details = details;
    }

    public List<Item> getItems() {
      return items;
    }

    public void setItems(List<Item> items) {
      this.items = items;
    }
  }

  public static class Nonreunification implements Serializable {
    private List<Item> items = null;

    private String willDFCSFileTPR = null;

    private Date dCSFileTPRDt = null;

    private String tPRExp = null;

    private String steps = null;

    private String addtlInfo = null;

    public String getAddtlInfo() {
      return addtlInfo;
    }

    public void setAddtlInfo(String addtlInfo) {
      this.addtlInfo = addtlInfo;
    }

    public Date getDCSFileTPRDt() {
      return dCSFileTPRDt;
    }

    public void setDCSFileTPRDt(Date fileTPRDt) {
      dCSFileTPRDt = fileTPRDt;
    }

    public List<Item> getItems() {
      return items;
    }

    public void setItems(List<Item> items) {
      this.items = items;
    }

    public String getSteps() {
      return steps;
    }

    public void setSteps(String steps) {
      this.steps = steps;
    }

    public String getTPRExp() {
      return tPRExp;
    }

    public void setTPRExp(String exp) {
      tPRExp = exp;
    }

    public String getWillDFCSFileTPR() {
      return willDFCSFileTPR;
    }

    public void setWillDFCSFileTPR(String willDFCSFileTPR) {
      this.willDFCSFileTPR = willDFCSFileTPR;
    }
  }

  public static class CaseTracking implements Serializable {
    private Date initialCasePlanDt = null;

    private Date currentCasePlanReviewDt = null;

    private Date nextReviewDt = null;

    private Date previousReviewDt = null;

    private Date childRemovalDt = null;

    private Date custExpirationDt = null;
    
    private Date diligentSearchCompletedDt = null;

    private Date anticaptedDateOfAchievingPermDt = null;

    private String permPlan = null;

    private String permPlanCompReason = null;

    private String concurrentPermPlan = null;

    private String concurrentpermPlanCompReason = null;
    
    private Date finalDispositionDate = null;
    
    private Date tprFiledDate = null;
    
    private Date tprVsAchievedDate = null;
    
    private String tprAppealed = null;
    
    private Date tprAppealedDate = null;

    private List<LegalActionItem> legalActions = null;

    public Date getAnticaptedDateOfAchievingPermDt() {
      return anticaptedDateOfAchievingPermDt;
    }

    public void setAnticaptedDateOfAchievingPermDt(Date anticaptedDateOfAchievingPermDt) {
      this.anticaptedDateOfAchievingPermDt = anticaptedDateOfAchievingPermDt;
    }

    public Date getChildRemovalDt() {
      return childRemovalDt;
    }

    public void setChildRemovalDt(Date childRemovalDt) {
      this.childRemovalDt = childRemovalDt;
    }

    public String getConcurrentPermPlan() {
      return concurrentPermPlan;
    }

    public void setConcurrentPermPlan(String concurrentPermPlan) {
      this.concurrentPermPlan = concurrentPermPlan;
    }

    public String getConcurrentpermPlanCompReason() {
      return concurrentpermPlanCompReason;
    }

    public void setConcurrentpermPlanCompReason(String concurrentpermPlanCompReason) {
      this.concurrentpermPlanCompReason = concurrentpermPlanCompReason;
    }

    public Date getCurrentCasePlanReviewDt() {
      return currentCasePlanReviewDt;
    }

    public void setCurrentCasePlanReviewDt(Date currentCasePlanReviewDt) {
      this.currentCasePlanReviewDt = currentCasePlanReviewDt;
    }

    public Date getDiligentSearchCompletedDt() {
      return diligentSearchCompletedDt;
    }

    public void setDiligentSearchCompletedDt(Date diligentSearchCompletedDt) {
      this.diligentSearchCompletedDt = diligentSearchCompletedDt;
    }

    public Date getInitialCasePlanDt() {
      return initialCasePlanDt;
    }

    public void setInitialCasePlanDt(Date initialCasePlanDt) {
      this.initialCasePlanDt = initialCasePlanDt;
    }

    public List<LegalActionItem> getLegalActions() {
      return legalActions;
    }

    public void setLegalActions(List<LegalActionItem> legalActions) {
      this.legalActions = legalActions;
    }

    public Date getNextReviewDt() {
      return nextReviewDt;
    }

    public void setNextReviewDt(Date nextReviewDt) {
      this.nextReviewDt = nextReviewDt;
    }

    public String getPermPlan() {
      return permPlan;
    }

    public void setPermPlan(String permPlan) {
      this.permPlan = permPlan;
    }

    public String getPermPlanCompReason() {
      return permPlanCompReason;
    }

    public void setPermPlanCompReason(String permPlanCompReason) {
      this.permPlanCompReason = permPlanCompReason;
    }

    public Date getPreviousReviewDt() {
      return previousReviewDt;
    }

    public void setPreviousReviewDt(Date previousReviewDt) {
      this.previousReviewDt = previousReviewDt;
    }

    public Date getCustExpirationDt() {
      return custExpirationDt;
    }

    public void setCustExpirationDt(Date custExpirationDt) {
      this.custExpirationDt = custExpirationDt;
    }

    public Date getFinalDispositionDate() {
      return finalDispositionDate;
    }

    public void setFinalDispositionDate(Date finalDispositionDate) {
      this.finalDispositionDate = finalDispositionDate;
    }

    public String getTprAppealed() {
      return tprAppealed;
    }

    public void setTprAppealed(String tprAppealed) {
      this.tprAppealed = tprAppealed;
    }

    public Date getTprFiledDate() {
      return tprFiledDate;
    }

    public void setTprFiledDate(Date tprFiledDate) {
      this.tprFiledDate = tprFiledDate;
    }

    public Date getTprVsAchievedDate() {
      return tprVsAchievedDate;
    }

    public void setTprVsAchievedDate(Date tprVsAchievedDate) {
      this.tprVsAchievedDate = tprVsAchievedDate;
    }

    public Date getTprAppealedDate() {
      return tprAppealedDate;
    }

    public void setTprAppealedDate(Date tprAppealedDate) {
      this.tprAppealedDate = tprAppealedDate;
    }

  }

  public static class LegalActionItem implements Serializable {
    private String actionType = null;
    
    private String hrType = null;
    
    private String crtType = null;

    private Date outcomeDt = null;

    private Date crtDt = null;

    private Date filedDt = null;
    
    private Date continDt = null;
    
    private Date nxtHearDt = null;
    
    private Date pubDt = null;
    
    private Date shelterCareAuthDt = null;
    
    List<String> outcomes = null;

    public Date getCrtDt() {
      return crtDt;
    }

    public void setCrtDt(Date crtDt) {
      this.crtDt = crtDt;
    }

    public Date getFiledDt() {
      return filedDt;
    }

    public void setFiledDt(Date filedDt) {
      this.filedDt = filedDt;
    }

    public String getHrType() {
      return hrType;
    }

    public void setHrType(String hrType) {
      this.hrType = hrType;
    }

    public Date getOutcomeDt() {
      return outcomeDt;
    }

    public void setOutcomeDt(Date outcomeDt) {
      this.outcomeDt = outcomeDt;
    }

    public List<String> getOutcomes() {
      return outcomes;
    }

    public void setOutcomes(List<String> outcomes) {
      this.outcomes = outcomes;
    }

    public String getCrtType() {
      return crtType;
    }

    public void setCrtType(String crtType) {
      this.crtType = crtType;
    }

    public String getActionType() {
      return actionType;
    }

    public void setActionType(String actionType) {
      this.actionType = actionType;
    }

    public Date getContinDt() {
      return continDt;
    }

    public void setContinDt(Date continDt) {
      this.continDt = continDt;
    }

    public Date getNxtHearDt() {
      return nxtHearDt;
    }

    public void setNxtHearDt(Date nxtHearDt) {
      this.nxtHearDt = nxtHearDt;
    }

    public Date getPubDt() {
      return pubDt;
    }

    public void setPubDt(Date pubDt) {
      this.pubDt = pubDt;
    }

    public Date getShelterCareAuthDt() {
      return shelterCareAuthDt;
    }

    public void setShelterCareAuthDt(Date shelterCareAuthDt) {
      this.shelterCareAuthDt = shelterCareAuthDt;
    }
  }

  public static class Removal implements Serializable {
    private Date removalDt = null;

    private List<String> removalReasons = null;

    private String descriptionOfIncident = null;

    private String effrtsToPreventRemoval = null;

    private String rsnsNoHomeProtection = null;

    private String harmIfRemains = null;
    
    private String removalType = null;

    public String getRemovalType() {
		return removalType;
	}

	public void setRemovalType(String removalType) {
		this.removalType = removalType;
	}

	public String getDescriptionOfIncident() {
      return descriptionOfIncident;
    }

    public void setDescriptionOfIncident(String descriptionOfIncendent) {
      this.descriptionOfIncident = descriptionOfIncendent;
    }

    public String getEffrtsToPreventRemoval() {
      return effrtsToPreventRemoval;
    }

    public void setEffrtsToPreventRemoval(String effrtsToPreventRemoval) {
      this.effrtsToPreventRemoval = effrtsToPreventRemoval;
    }

    public String getHarmIfRemains() {
      return harmIfRemains;
    }

    public void setHarmIfRemains(String harmIfRemains) {
      this.harmIfRemains = harmIfRemains;
    }

    public Date getRemovalDt() {
      return removalDt;
    }

    public void setRemovalDt(Date removalDt) {
      this.removalDt = removalDt;
    }

    public List<String> getRemovalReasons() {
      return removalReasons;
    }

    public void setRemovalReasons(List<String> removalReasons) {
      this.removalReasons = removalReasons;
    }

    public String getRsnsNoHomeProtection() {
      return rsnsNoHomeProtection;
    }

    public void setRsnsNoHomeProtection(String rsnsNoHomeProtection) {
      this.rsnsNoHomeProtection = rsnsNoHomeProtection;
    }
  }

  public static class WTLP implements Serializable {
    private String eligibilty = null;

    private String livingArrg = null;

    private String maritalStatus = null;

    private String type = null;

    private String placementAuth = null;

    private String voluntaryCmmt = null;

    private String education = null;

    private String vocEduPrep = null;

    private String basicDailyLiving = null;

    private String personalDevCouns = null;

    private String healthEduMain = null;

    private Date wtlpDt = null;

    private Date durFromDt = null;

    private Date durToDt = null;

    private String strengths = null;

    private String needs = null;

    List<PlanGoal> goals = null;

    private String ydcLastName = null;

    private String ydcFirstName = null;

    private String ydcMiddleName = null;

    private String ydcSuffix = null;

    private String ydcPhone = null;

    private String parentalStatus = null;

    private Date emancipDiscDt = null;

    private String emancipDiscComments = null;

    private Date exceptedHSGradDt = null;

    private String acadTrack = null;

    private String creditsReq = null;

    private String creditsEarned = null;
    
    private String custodyStatus = null;
    
    private Integer nbrPostReqCred = null;
    
    private Integer nbrPostReqEar = null;

    public String getBasicDailyLiving() {
      return basicDailyLiving;
    }

    public void setBasicDailyLiving(String basicDailyLiving) {
      this.basicDailyLiving = basicDailyLiving;
    }

    public String getEducation() {
      return education;
    }

    public void setEducation(String education) {
      this.education = education;
    }

    public List<PlanGoal> getGoals() {
      return goals;
    }

    public void setGoals(List<PlanGoal> goals) {
      this.goals = goals;
    }

    public String getHealthEduMain() {
      return healthEduMain;
    }

    public void setHealthEduMain(String healthEduMain) {
      this.healthEduMain = healthEduMain;
    }

    public String getNeeds() {
      return needs;
    }

    public void setNeeds(String needs) {
      this.needs = needs;
    }

    public String getPersonalDevCouns() {
      return personalDevCouns;
    }

    public void setPersonalDevCouns(String personalDevCouns) {
      this.personalDevCouns = personalDevCouns;
    }

    public String getPlacementAuth() {
      return placementAuth;
    }

    public void setPlacementAuth(String placementAuth) {
      this.placementAuth = placementAuth;
    }

    public String getStrengths() {
      return strengths;
    }

    public void setStrengths(String strengths) {
      this.strengths = strengths;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getVocEduPrep() {
      return vocEduPrep;
    }

    public void setVocEduPrep(String vocEduPrep) {
      this.vocEduPrep = vocEduPrep;
    }

    public String getAcadTrack() {
      return acadTrack;
    }

    public void setAcadTrack(String acadTrack) {
      this.acadTrack = acadTrack;
    }

    public String getCreditsEarned() {
      return creditsEarned;
    }

    public void setCreditsEarned(String creditsEarned) {
      this.creditsEarned = creditsEarned;
    }

    public String getCreditsReq() {
      return creditsReq;
    }

    public void setCreditsReq(String creditsReq) {
      this.creditsReq = creditsReq;
    }
    
    
    public Integer getNbrPostReqCred() {
      return nbrPostReqCred;
    }

    public void setNbrPostReqCred(Integer nbrPostReqCred) {
      this.nbrPostReqCred = nbrPostReqCred;
    }
    
    public Integer getNbrPostReqEar() {
      return nbrPostReqEar;
    }

    public void setNbrPostReqEar(Integer nbrPostReqEar) {
      this.nbrPostReqEar = nbrPostReqEar;
    }

    public Date getDurFromDt() {
      return durFromDt;
    }

    public void setDurFromDt(Date durFromDt) {
      this.durFromDt = durFromDt;
    }

    public Date getDurToDt() {
      return durToDt;
    }

    public void setDurToDt(Date durToDt) {
      this.durToDt = durToDt;
    }

    public String getEmancipDiscComments() {
      return emancipDiscComments;
    }

    public void setEmancipDiscComments(String emancipDiscComments) {
      this.emancipDiscComments = emancipDiscComments;
    }

    public Date getEmancipDiscDt() {
      return emancipDiscDt;
    }

    public void setEmancipDiscDt(Date emancipDiscDt) {
      this.emancipDiscDt = emancipDiscDt;
    }

    public Date getExceptedHSGradDt() {
      return exceptedHSGradDt;
    }

    public void setExceptedHSGradDt(Date exceptedHSGradDt) {
      this.exceptedHSGradDt = exceptedHSGradDt;
    }

    public String getParentalStatus() {
      return parentalStatus;
    }

    public void setParentalStatus(String parentalStatus) {
      this.parentalStatus = parentalStatus;
    }

    public String getVoluntaryCmmt() {
      return voluntaryCmmt;
    }

    public void setVoluntaryCmmt(String voluntaryCmmt) {
      this.voluntaryCmmt = voluntaryCmmt;
    }

    public Date getWtlpDt() {
      return wtlpDt;
    }

    public void setWtlpDt(Date wtlpDt) {
      this.wtlpDt = wtlpDt;
    }

    public String getEligibilty() {
      return eligibilty;
    }

    public void setEligibilty(String eligibilty) {
      this.eligibilty = eligibilty;
    }

    public String getLivingArrg() {
      return livingArrg;
    }

    public void setLivingArrg(String livingArrg) {
      this.livingArrg = livingArrg;
    }

    public String getMaritalStatus() {
      return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
      this.maritalStatus = maritalStatus;
    }

    public String getYdcFirstName() {
      return ydcFirstName;
    }

    public void setYdcFirstName(String ydcFirstName) {
      this.ydcFirstName = ydcFirstName;
    }

    public String getYdcLastName() {
      return ydcLastName;
    }

    public void setYdcLastName(String ydcLastName) {
      this.ydcLastName = ydcLastName;
    }

    public String getYdcMiddleName() {
      return ydcMiddleName;
    }

    public void setYdcMiddleName(String ydcMiddleName) {
      this.ydcMiddleName = ydcMiddleName;
    }

    public String getYdcPhone() {
      return ydcPhone;
    }

    public void setYdcPhone(String ydcPhone) {
      this.ydcPhone = ydcPhone;
    }

    public String getYdcSuffix() {
      return ydcSuffix;
    }

    public void setYdcSuffix(String ydcSuffix) {
      this.ydcSuffix = ydcSuffix;
    }

    public String getCustodyStatus() {
      return custodyStatus;
    }

    public void setCustodyStatus(String custodyStatus) {
      this.custodyStatus = custodyStatus;
    }
  }

  public static class PlanGoal implements Serializable {
    private String goal = null;

    private String reason = null;

    private String type = null;

    List<PlanStep> steps = null;

    public String getGoal() {
      return goal;
    }

    public void setGoal(String goal) {
      this.goal = goal;
    }

    public String getReason() {
      return reason;
    }

    public void setReason(String reason) {
      this.reason = reason;
    }

    public List<PlanStep> getSteps() {
      return steps;
    }

    public void setSteps(List<PlanStep> steps) {
      this.steps = steps;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }
  }

  public static class PlanStep implements Serializable {
    private String priority = null;

    private String respParty = null;

    private Date toBeCompDt = null;

    private String comment = null;

    private String description = null;

    private String status = null;
    
    private String indSelected = null;

    public String getComment() {
      return comment;
    }

    public void setComment(String comment) {
      this.comment = comment;
    }

    public String getPriority() {
      return priority;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public void setPriority(String priority) {
      this.priority = priority;
    }

    public String getRespParty() {
      return respParty;
    }

    public void setRespParty(String respParty) {
      this.respParty = respParty;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public Date getToBeCompDt() {
      return toBeCompDt;
    }

    public void setToBeCompDt(Date toBeCompDt) {
      this.toBeCompDt = toBeCompDt;
    }

    public String getIndSelected() {
      return indSelected;
    }

    public void setIndSelected(String indSelected) {
      this.indSelected = indSelected;
    }
  }

  public static class SecondaryGoal implements Serializable {
    private String desc = null;

    private String status = null;

    private String prntAppv = null;

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }

    public String getPrntAppv() {
      return prntAppv;
    }

    public void setPrntAppv(String prntAppv) {
      this.prntAppv = prntAppv;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
  }

  public static class HealthStatus implements Serializable {
    private String immunUTD = null;

    private String reasonImmunNtUTD = null;

    private String immunOnFile = null;

    private String reasonImmunNtOnFile = null;

    private String ongoingMedPysch = null;

    private String medPsychProblem = null;

    private String medRecOnFile = null;

    private String reasonMedRecNtOnFile = null;

    private String psychRecOnFile = null;

    private String reasonPsychNtOnFile = null;

    private String ongoingMedPsychTreatment = null;

    private String medPsychTreatment = null;

    private String missingEvalDates = null;

    private String otherRelNedInfo = null;

    private List<Medication> medications = null;

    private Date lastMedExamDt = null;

    private Date lastDentalExamDt = null;

    private Date lastPyExamDt = null;

    private Date lastMedScreenDt = null;

    private Date lastDentalScreenDt = null;

    private Date lastHealthCheckScreenDt = null;

    private String earlyIntervention = null;

    private String earlyInterventionCmmts = null;

    private String prevEarlyIntervention = null;
    
    private Date immunDt = null;

    public String getEarlyIntervention() {
      return earlyIntervention;
    }

    public void setEarlyIntervention(String earlyIntervention) {
      this.earlyIntervention = earlyIntervention;
    }

    public String getEarlyInterventionCmmts() {
      return earlyInterventionCmmts;
    }

    public void setEarlyInterventionCmmts(String earlyInterventionCmmts) {
      this.earlyInterventionCmmts = earlyInterventionCmmts;
    }

    public String getImmunOnFile() {
      return immunOnFile;
    }

    public void setImmunOnFile(String immunOnFile) {
      this.immunOnFile = immunOnFile;
    }

    public String getImmunUTD() {
      return immunUTD;
    }

    public void setImmunUTD(String immunUTD) {
      this.immunUTD = immunUTD;
    }

    public Date getLastDentalExamDt() {
      return lastDentalExamDt;
    }

    public void setLastDentalExamDt(Date lastDentalExamDt) {
      this.lastDentalExamDt = lastDentalExamDt;
    }

    public Date getLastDentalScreenDt() {
      return lastDentalScreenDt;
    }

    public void setLastDentalScreenDt(Date lastDentalScreenDt) {
      this.lastDentalScreenDt = lastDentalScreenDt;
    }

    public Date getLastHealthCheckScreenDt() {
      return lastHealthCheckScreenDt;
    }

    public void setLastHealthCheckScreenDt(Date lastHealthCheckScreenDt) {
      this.lastHealthCheckScreenDt = lastHealthCheckScreenDt;
    }

    public Date getLastMedExamDt() {
      return lastMedExamDt;
    }

    public void setLastMedExamDt(Date lastMedExamDt) {
      this.lastMedExamDt = lastMedExamDt;
    }

    public Date getLastMedScreenDt() {
      return lastMedScreenDt;
    }

    public void setLastMedScreenDt(Date lastMedScreenDt) {
      this.lastMedScreenDt = lastMedScreenDt;
    }

    public Date getLastPyExamDt() {
      return lastPyExamDt;
    }

    public void setLastPyExamDt(Date lastPyExamDt) {
      this.lastPyExamDt = lastPyExamDt;
    }

    public List<Medication> getMedications() {
      return medications;
    }

    public void setMedications(List<Medication> medications) {
      this.medications = medications;
    }

    public String getMedPsychTreatment() {
      return medPsychTreatment;
    }

    public void setMedPsychTreatment(String medPsychTreatment) {
      this.medPsychTreatment = medPsychTreatment;
    }

    public String getMedPsychProblem() {
      return medPsychProblem;
    }

    public void setMedPsychProblem(String medPsychProblem) {
      this.medPsychProblem = medPsychProblem;
    }

    public String getMedRecOnFile() {
      return medRecOnFile;
    }

    public void setMedRecOnFile(String medRecOnFile) {
      this.medRecOnFile = medRecOnFile;
    }

    public String getMissingEvalDates() {
      return missingEvalDates;
    }

    public void setMissingEvalDates(String missingEvalDates) {
      this.missingEvalDates = missingEvalDates;
    }

    public String getOngoingMedPsychTreatment() {
      return ongoingMedPsychTreatment;
    }

    public void setOngoingMedPsychTreatment(String ongoingMedPsychTreatment) {
      this.ongoingMedPsychTreatment = ongoingMedPsychTreatment;
    }

    public String getOngoingMedPysch() {
      return ongoingMedPysch;
    }

    public void setOngoingMedPysch(String ongoingMedPysch) {
      this.ongoingMedPysch = ongoingMedPysch;
    }

    public String getPrevEarlyIntervention() {
      return prevEarlyIntervention;
    }

    public void setPrevEarlyIntervention(String prevEarlyIntervention) {
      this.prevEarlyIntervention = prevEarlyIntervention;
    }

    public String getPsychRecOnFile() {
      return psychRecOnFile;
    }

    public void setPsychRecOnFile(String psychRecOnFile) {
      this.psychRecOnFile = psychRecOnFile;
    }

    public String getReasonImmunNtOnFile() {
      return reasonImmunNtOnFile;
    }

    public void setReasonImmunNtOnFile(String reasonImmunNtOnFile) {
      this.reasonImmunNtOnFile = reasonImmunNtOnFile;
    }

    public String getReasonImmunNtUTD() {
      return reasonImmunNtUTD;
    }

    public void setReasonImmunNtUTD(String reasonImmunNtUTD) {
      this.reasonImmunNtUTD = reasonImmunNtUTD;
    }

    public String getReasonMedRecNtOnFile() {
      return reasonMedRecNtOnFile;
    }

    public void setReasonMedRecNtOnFile(String reasonMedRecNtOnFile) {
      this.reasonMedRecNtOnFile = reasonMedRecNtOnFile;
    }

    public String getReasonPsychNtOnFile() {
      return reasonPsychNtOnFile;
    }

    public void setReasonPsychNtOnFile(String reasonPsychNtOnFile) {
      this.reasonPsychNtOnFile = reasonPsychNtOnFile;
    }

    public String getOtherRelNedInfo() {
      return otherRelNedInfo;
    }

    public void setOtherRelNedInfo(String otherRelNedInfo) {
      this.otherRelNedInfo = otherRelNedInfo;
    }

    public Date getImmunDt() {
      return immunDt;
    }

    public void setImmunDt(Date immunDt) {
      this.immunDt = immunDt;
    }
  }

  public static class Medication implements Serializable {
    private String medication = null;

    private String adminPerson = null;

    public String getAdminPerson() {
      return adminPerson;
    }

    public void setAdminPerson(String adminPerson) {
      this.adminPerson = adminPerson;
    }

    public String getMedication() {
      return medication;
    }

    public void setMedication(String medication) {
      this.medication = medication;
    }
  }

  public static class EducationHistory implements Serializable {
    private String childInSchool = null;

    private String childNotInSchoolComment = null;

    private String gradeLevel = null;

    private String schoolSystem = null;

    private String schoolName = null;

    private String schoolAddress1 = null;

    private String schoolAddress2 = null;

    private String schoolCity = null;

    private String schoolState = null;

    private String schoolZip = null;

    private String schoolCounty = null;

    private String schoolPhoneNumber = null;

    private String schoolFaxNumber = null;

    private String attendance = null;

    private String perfAtGradeLevel = null;

    private String specialEdNeeds = null;

    private String specialEdNeedsComment = null;

    private String schoolChanged = null;

    private String schoolRecords = null;

    private String prevSpecialEdServices = null;

    private Date studentSuppTeamDt = null;

    private String individEdPlan = null;

    private Date individEdPlanDt = null;

    private String individEdPlanSurrPrnt = null;

    private String legalPrntInvolved = null;

    private String stuSuppPlan = null;

    private String surrFosterPrnt = null;

    private String surrLegalPrnt = null;

    private String narrBeDispRec = null;

    private String sstCmmts = null;

    private String behDispRec = null;

    private String guidConLastName = null;

    private String guidConFirstName = null;

    private String eduAssmnt = null;

    private Date eduAssmntDt = null;

    private String recBoardRec = null;

    private String suppSpvsn = null;

    private String suppSpvsnCmmt = null;

    private String develAssmtCmmt = null;

    private Date develAssmtCompDt = null;

    private String develScreenCmmt = null;

    private Date develScreenCmptDt = null;

    private String classPlac = null;
    
    private String recInFileCmmt = null;
    
    private String schChgDuePlcmtCmmt = null;
    
    private String devScrnAssmtCmmt = null;
    
    private String eductnDevScrnCmmt = null; 
    
    public String getDevScrnAssmtCmmt() {
      return devScrnAssmtCmmt;
    }

    public void setDevScrnAssmtCmmt(String devScrnAssmtCmmt) {
      this.devScrnAssmtCmmt = devScrnAssmtCmmt;
    }

    public String getEductnDevScrnCmmt() {
      return eductnDevScrnCmmt;
    }

    public void setEductnDevScrnCmmt(String eductnDevScrnCmmt) {
      this.eductnDevScrnCmmt = eductnDevScrnCmmt;
    }

    public String getRecInFileCmmt() {
      return recInFileCmmt;
    }

    public void setRecInFileCmmt(String recInFileCmmt) {
      this.recInFileCmmt = recInFileCmmt;
    }

    public String getSchChgDuePlcmtCmmt() {
      return schChgDuePlcmtCmmt;
    }

    public void setSchChgDuePlcmtCmmt(String schChgDuePlcmtCmmt) {
      this.schChgDuePlcmtCmmt = schChgDuePlcmtCmmt;
    }

    public String getAttendance() {
      return attendance;
    }

    public void setAttendance(String attendance) {
      this.attendance = attendance;
    }

    public String getBehDispRec() {
      return behDispRec;
    }

    public void setBehDispRec(String behDispRec) {
      this.behDispRec = behDispRec;
    }

    public String getChildInSchool() {
      return childInSchool;
    }

    public void setChildInSchool(String childInSchool) {
      this.childInSchool = childInSchool;
    }

    public String getChildNotInSchoolComment() {
      return childNotInSchoolComment;
    }

    public void setChildNotInSchoolComment(String childNotInSchoolComment) {
      this.childNotInSchoolComment = childNotInSchoolComment;
    }

    public String getDevelAssmtCmmt() {
      return develAssmtCmmt;
    }

    public void setDevelAssmtCmmt(String develAssmtCmmt) {
      this.develAssmtCmmt = develAssmtCmmt;
    }

    public Date getDevelAssmtCompDt() {
      return develAssmtCompDt;
    }

    public void setDevelAssmtCompDt(Date develAssmtCompDt) {
      this.develAssmtCompDt = develAssmtCompDt;
    }

    public String getDevelScreenCmmt() {
      return develScreenCmmt;
    }

    public void setDevelScreenCmmt(String develScreenCmmt) {
      this.develScreenCmmt = develScreenCmmt;
    }

    public Date getDevelScreenCmptDt() {
      return develScreenCmptDt;
    }

    public void setDevelScreenCmptDt(Date develScreenCmptDt) {
      this.develScreenCmptDt = develScreenCmptDt;
    }

    public String getEduAssmnt() {
      return eduAssmnt;
    }

    public void setEduAssmnt(String eduAssmnt) {
      this.eduAssmnt = eduAssmnt;
    }

    public Date getEduAssmntDt() {
      return eduAssmntDt;
    }

    public void setEduAssmntDt(Date eduAssmntDt) {
      this.eduAssmntDt = eduAssmntDt;
    }

    public String getGradeLevel() {
      return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
      this.gradeLevel = gradeLevel;
    }

    public String getGuidConFirstName() {
      return guidConFirstName;
    }

    public void setGuidConFirstName(String guidConFirstName) {
      this.guidConFirstName = guidConFirstName;
    }

    public String getGuidConLastName() {
      return guidConLastName;
    }

    public void setGuidConLastName(String guidConLastName) {
      this.guidConLastName = guidConLastName;
    }

    public String getIndividEdPlan() {
      return individEdPlan;
    }

    public void setIndividEdPlan(String individEdPlan) {
      this.individEdPlan = individEdPlan;
    }

    public Date getIndividEdPlanDt() {
      return individEdPlanDt;
    }

    public void setIndividEdPlanDt(Date individEdPlanDt) {
      this.individEdPlanDt = individEdPlanDt;
    }

    public String getIndividEdPlanSurrPrnt() {
      return individEdPlanSurrPrnt;
    }

    public void setIndividEdPlanSurrPrnt(String individEdPlanSurrPrnt) {
      this.individEdPlanSurrPrnt = individEdPlanSurrPrnt;
    }

    public String getLegalPrntInvolved() {
      return legalPrntInvolved;
    }

    public void setLegalPrntInvolved(String legalPrntInvolved) {
      this.legalPrntInvolved = legalPrntInvolved;
    }

    public String getPerfAtGradeLevel() {
      return perfAtGradeLevel;
    }

    public void setPerfAtGradeLevel(String perfAtGradeLevel) {
      this.perfAtGradeLevel = perfAtGradeLevel;
    }

    public String getPrevSpecialEdServices() {
      return prevSpecialEdServices;
    }

    public void setPrevSpecialEdServices(String prevSpecialEdServices) {
      this.prevSpecialEdServices = prevSpecialEdServices;
    }

    public String getRecBoardRec() {
      return recBoardRec;
    }

    public void setRecBoardRec(String recBoardRec) {
      this.recBoardRec = recBoardRec;
    }

    public String getSchoolAddress1() {
      return schoolAddress1;
    }

    public void setSchoolAddress1(String schoolAddress1) {
      this.schoolAddress1 = schoolAddress1;
    }

    public String getSchoolAddress2() {
      return schoolAddress2;
    }

    public void setSchoolAddress2(String schoolAddress2) {
      this.schoolAddress2 = schoolAddress2;
    }

    public String getSchoolChanged() {
      return schoolChanged;
    }

    public void setSchoolChanged(String schoolChanged) {
      this.schoolChanged = schoolChanged;
    }

    public String getSchoolCity() {
      return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
      this.schoolCity = schoolCity;
    }

    public String getSchoolCounty() {
      return schoolCounty;
    }

    public void setSchoolCounty(String schoolCounty) {
      this.schoolCounty = schoolCounty;
    }

    public String getSchoolName() {
      return schoolName;
    }

    public void setSchoolName(String schoolName) {
      this.schoolName = schoolName;
    }

    public String getSchoolPhoneNumber() {
      return schoolPhoneNumber;
    }

    public void setSchoolPhoneNumber(String schoolPhoneNumber) {
      this.schoolPhoneNumber = schoolPhoneNumber;
    }

    public String getSchoolRecords() {
      return schoolRecords;
    }

    public void setSchoolRecords(String schoolRecords) {
      this.schoolRecords = schoolRecords;
    }

    public String getSchoolState() {
      return schoolState;
    }

    public void setSchoolState(String schoolState) {
      this.schoolState = schoolState;
    }

    public String getSchoolSystem() {
      return schoolSystem;
    }

    public void setSchoolSystem(String schoolSystem) {
      this.schoolSystem = schoolSystem;
    }

    public String getSchoolZip() {
      return schoolZip;
    }

    public void setSchoolZip(String schoolZip) {
      this.schoolZip = schoolZip;
    }

    public String getSpecialEdNeeds() {
      return specialEdNeeds;
    }

    public void setSpecialEdNeeds(String specialEdNeeds) {
      this.specialEdNeeds = specialEdNeeds;
    }

    public String getSpecialEdNeedsComment() {
      return specialEdNeedsComment;
    }

    public void setSpecialEdNeedsComment(String specialEdNeedsComment) {
      this.specialEdNeedsComment = specialEdNeedsComment;
    }

    public String getSstCmmts() {
      return sstCmmts;
    }

    public void setSstCmmts(String sstCmmts) {
      this.sstCmmts = sstCmmts;
    }

    public Date getStudentSuppTeamDt() {
      return studentSuppTeamDt;
    }

    public void setStudentSuppTeamDt(Date studentSuppTeamDt) {
      this.studentSuppTeamDt = studentSuppTeamDt;
    }

    public String getStuSuppPlan() {
      return stuSuppPlan;
    }

    public void setStuSuppPlan(String stuSuppPlan) {
      this.stuSuppPlan = stuSuppPlan;
    }

    public String getSuppSpvsn() {
      return suppSpvsn;
    }

    public void setSuppSpvsn(String suppSpvsn) {
      this.suppSpvsn = suppSpvsn;
    }

    public String getSuppSpvsnCmmt() {
      return suppSpvsnCmmt;
    }

    public void setSuppSpvsnCmmt(String suppSpvsnCmmt) {
      this.suppSpvsnCmmt = suppSpvsnCmmt;
    }

    public String getNarrBeDispRec() {
      return narrBeDispRec;
    }

    public String getSurrFosterPrnt() {
      return surrFosterPrnt;
    }

    public void setSurrFosterPrnt(String surrFosterPrnt) {
      this.surrFosterPrnt = surrFosterPrnt;
    }

    public String getSurrLegalPrnt() {
      return surrLegalPrnt;
    }

    public void setSurrLegalPrnt(String surrLegalPrnt) {
      this.surrLegalPrnt = surrLegalPrnt;
    }

    public void setNarrBeDispRec(String narrBeDispRec) {
      this.narrBeDispRec = narrBeDispRec;
    }

    public String getClassPlac() {
      return classPlac;
    }

    public void setClassPlac(String classPlac) {
      this.classPlac = classPlac;
    }

    public String getSchoolFaxNumber() {
      return schoolFaxNumber;
    }

    public void setSchoolFaxNumber(String schoolFaxNumber) {
      this.schoolFaxNumber = schoolFaxNumber;
    }
}

  public static class DiligentSearch implements Serializable {
    private String refType = null;

    private String refCmmnts = null;

    private String refName = null;

    private String succCont = null;

    private String wnSuccCont = null;

    private String comment = null;

    private String plcmtRes = null;

    private String wnPlcmtRes = null;

    private String visitRes = null;

    private String outcomeCmmt = null;

    private Date relCareSubsidiesDt = null;

    private String anyCrtkPrior = null;

    private String noLongerWPCrtk = null;

    private String relationshipType = null;

    private String contMeth = null;

    private Date contDt = null;

    private String interviewerId = null;

    private String interviewer = null;

    private Relative personContacted = null;

    public String getComment() {
      return comment;
    }

    public void setComment(String comment) {
      this.comment = comment;
    }

    public Date getContDt() {
      return contDt;
    }

    public void setContDt(Date contDt) {
      this.contDt = contDt;
    }

    public String getContMeth() {
      return contMeth;
    }

    public void setContMeth(String contMeth) {
      this.contMeth = contMeth;
    }

    public String getInterviewerId() {
      return interviewerId;
    }

    public void setInterviewerId(String interviewerId) {
      this.interviewerId = interviewerId;
    }

    public String getOutcomeCmmt() {
      return outcomeCmmt;
    }

    public void setOutcomeCmmt(String outcomeCmmt) {
      this.outcomeCmmt = outcomeCmmt;
    }

    public Relative getPersonContacted() {
      return personContacted;
    }

    public void setPersonContacted(Relative personContacted) {
      this.personContacted = personContacted;
    }

    public String getPlcmtRes() {
      return plcmtRes;
    }

    public void setPlcmtRes(String plcmtRes) {
      this.plcmtRes = plcmtRes;
    }

    public String getRefCmmnts() {
      return refCmmnts;
    }

    public void setRefCmmnts(String refCmmnts) {
      this.refCmmnts = refCmmnts;
    }

    public String getRefName() {
      return refName;
    }

    public void setRefName(String refName) {
      this.refName = refName;
    }

    public String getRefType() {
      return refType;
    }

    public void setRefType(String refType) {
      this.refType = refType;
    }

    public String getRelationshipType() {
      return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
      this.relationshipType = relationshipType;
    }

    public Date getRelCareSubsidiesDt() {
      return relCareSubsidiesDt;
    }

    public void setRelCareSubsidiesDt(Date relCareSubsidiesDt) {
      this.relCareSubsidiesDt = relCareSubsidiesDt;
    }

    public String getSuccCont() {
      return succCont;
    }

    public void setSuccCont(String succCont) {
      this.succCont = succCont;
    }

    public String getVisitRes() {
      return visitRes;
    }

    public void setVisitRes(String visitRes) {
      this.visitRes = visitRes;
    }

    public String getWnPlcmtRes() {
      return wnPlcmtRes;
    }

    public void setWnPlcmtRes(String wnPlcmtRes) {
      this.wnPlcmtRes = wnPlcmtRes;
    }

    public String getWnSuccCont() {
      return wnSuccCont;
    }

    public void setWnSuccCont(String wnSuccCont) {
      this.wnSuccCont = wnSuccCont;
    }

    public String getAnyCrtkPrior() {
      return anyCrtkPrior;
    }

    public void setAnyCrtkPrior(String anyCrtkPrior) {
      this.anyCrtkPrior = anyCrtkPrior;
    }

    public String getNoLongerWPCrtk() {
      return noLongerWPCrtk;
    }

    public void setNoLongerWPCrtk(String noLongerWPCrtk) {
      this.noLongerWPCrtk = noLongerWPCrtk;
    }

    public String getInterviewer() {
      return interviewer;
    }

    public void setInterviewer(String interviewer) {
      this.interviewer = interviewer;
    }
  }

  public static class Adoption implements Serializable {
    private String cdStateActRecruiting = null; // SMS#109405: new field per MR-083
    
    private String indAdoptRes = null;

    private String stateAct = null;

    private String cntyAct = null;

    private Integer numOfFamCons = null;

    private String notSelCmmts = null;

    private String barrToRec = null;

    private String barrToPlcmt = null;

    private String curSpNeeds = null;

    private String reasChildAvail = null;

    private Date adotAgreeDt = null;

    private Date lifeHistPresDt = null;

    private Date adotStaffDt = null;

    private Date intTprDt = null;

    private Date decAdoptDt = null;

    private Date permStaffDt = null;

    private Date permFileDt = null;

    private Date docSentDt = null;

    private String inqryOTHS = null;

    private List<Item> items = null;
    
    private String prepCmnts = null;
    
    private String tprBarr = null;
    
    private String recruitComment = null;
    
    private Date letterSentDt = null;
    
    private String indFpAdo = null;
    
    private Date disruptionDt = null;
    
    private List<ExchangeChildRecruitmentActivities> exchangeChildRecruitmentActivities= null;
    
    private List<RecruitmentActivities> recruitmentActivities = null;

    public String getCdStateActRecruiting() {
      return cdStateActRecruiting;
    }

    public void setCdStateActRecruiting(String cdStateActRecruiting) {
      this.cdStateActRecruiting = cdStateActRecruiting;
    }

    public String getIndFpAdo() {
      return indFpAdo;
    }

    public void setIndFpAdo(String indFpAdo) {
      this.indFpAdo = indFpAdo;
    }

    public Date getAdotAgreeDt() {
      return adotAgreeDt;
    }

    public void setAdotAgreeDt(Date adotAgreeDt) {
      this.adotAgreeDt = adotAgreeDt;
    }

    public Date getAdotStaffDt() {
      return adotStaffDt;
    }

    public void setAdotStaffDt(Date adotStaffDt) {
      this.adotStaffDt = adotStaffDt;
    }

    public String getBarrToRec() {
      return barrToRec;
    }

    public void setBarrToRec(String barrToRec) {
      this.barrToRec = barrToRec;
    }

    public String getCurSpNeeds() {
      return curSpNeeds;
    }

    public void setCurSpNeeds(String curSpNeeds) {
      this.curSpNeeds = curSpNeeds;
    }

    public Date getDecAdoptDt() {
      return decAdoptDt;
    }

    public void setDecAdoptDt(Date decAdoptDt) {
      this.decAdoptDt = decAdoptDt;
    }

    public Date getDocSentDt() {
      return docSentDt;
    }

    public void setDocSentDt(Date docSentDt) {
      this.docSentDt = docSentDt;
    }

    public String getIndAdoptRes() {
      return indAdoptRes;
    }

    public void setIndAdoptRes(String indAdoptRes) {
      this.indAdoptRes = indAdoptRes;
    }

    public String getInqryOTHS() {
      return inqryOTHS;
    }

    public void setInqryOTHS(String inqryOTHS) {
      this.inqryOTHS = inqryOTHS;
    }

    public Date getIntTprDt() {
      return intTprDt;
    }

    public void setIntTprDt(Date intTprDt) {
      this.intTprDt = intTprDt;
    }

    public List<Item> getItems() {
      return items;
    }

    public void setItems(List<Item> items) {
      this.items = items;
    }

    public Date getLifeHistPresDt() {
      return lifeHistPresDt;
    }

    public void setLifeHistPresDt(Date lifeHistPresDt) {
      this.lifeHistPresDt = lifeHistPresDt;
    }

    public String getNotSelCmmts() {
      return notSelCmmts;
    }

    public void setNotSelCmmts(String notSelCmmts) {
      this.notSelCmmts = notSelCmmts;
    }

    public Integer getNumOfFamCons() {
      return numOfFamCons;
    }

    public void setNumOfFamCons(Integer numOfFamCons) {
      this.numOfFamCons = numOfFamCons;
    }

    public Date getPermFileDt() {
      return permFileDt;
    }

    public void setPermFileDt(Date permFileDt) {
      this.permFileDt = permFileDt;
    }

    public Date getPermStaffDt() {
      return permStaffDt;
    }

    public void setPermStaffDt(Date permStaffDt) {
      this.permStaffDt = permStaffDt;
    }

    public String getReasChildAvail() {
      return reasChildAvail;
    }

    public void setReasChildAvail(String reasChildAvail) {
      this.reasChildAvail = reasChildAvail;
    }

    public String getBarrToPlcmt() {
      return barrToPlcmt;
    }

    public void setBarrToPlcmt(String barrToPlcmt) {
      this.barrToPlcmt = barrToPlcmt;
    }

    public String getCntyAct() {
      return cntyAct;
    }

    public void setCntyAct(String cntyAct) {
      this.cntyAct = cntyAct;
    }

    public String getStateAct() {
      return stateAct;
    }

    public void setStateAct(String stateAct) {
      this.stateAct = stateAct;
    }

    public String getPrepCmnts() {
      return prepCmnts;
    }

    public void setPrepCmnts(String prepCmnts) {
      this.prepCmnts = prepCmnts;
    }

    public String getTprBarr() {
      return tprBarr;
    }

    public void setTprBarr(String tprBarr) {
      this.tprBarr = tprBarr;
    }

    public String getRecruitComment() {
      return recruitComment;
    }

    public void setRecruitComment(String recruitComment) {
      this.recruitComment = recruitComment;
    }

    public Date getLetterSentDt() {
      return letterSentDt;
    }

    public void setLetterSentDt(Date letterSentDt) {
      this.letterSentDt = letterSentDt;
    }

    public Date getDisruptionDt() {
      return disruptionDt;
    }

    public void setDisruptionDt(Date disruptionDt) {
      this.disruptionDt = disruptionDt;
    }

    public List<ExchangeChildRecruitmentActivities> getExchangeChildRecruitmentActivities() {
      return exchangeChildRecruitmentActivities;
    }

    public void setExchangeChildRecruitmentActivities(
                                                      List<ExchangeChildRecruitmentActivities> exchangeChildRecruitmentActivities) {
      this.exchangeChildRecruitmentActivities = exchangeChildRecruitmentActivities;
    }

    public List<RecruitmentActivities> getRecruitmentActivities() {
      return recruitmentActivities;
    }

    public void setRecruitmentActivities(List<RecruitmentActivities> recruitmentActivities) {
      this.recruitmentActivities = recruitmentActivities;
    }
  }
  
  public static class ExchangeChildRecruitmentActivities  implements Serializable {
    private String code = null;
    private String codeType = null;
    private Date dtPerformed = null;
    public String getCode() {
      return code;
    }
    public void setCode(String code) {
      this.code = code;
    }
    public String getCodeType() {
      return codeType;
    }
    public void setCodeType(String codeType) {
      this.codeType = codeType;
    }
    public Date getDtPerformed() {
      return dtPerformed;
    }
    public void setDtPerformed(Date dtPerformed) {
      this.dtPerformed = dtPerformed;
    }
  }
  
  public static class RecruitmentActivities  implements Serializable {
    private String code = null;
    private String codeType = null;
    private List<Date> performedDates = null;
    public String getCode() {
      return code;
    }
    public void setCode(String code) {
      this.code = code;
    }
    public String getCodeType() {
      return codeType;
    }
    public void setCodeType(String codeType) {
      this.codeType = codeType;
    }
    public List<Date> getPerformedDates() {
      return performedDates;
    }
    public void setPerformedDates(List<Date> performedDates) {
      this.performedDates = performedDates;
    }
  }
  

  public static class Participation implements Serializable {
    private String parentPart = null;

    private String parentPartCmmt = null;

    private String childPart = null;

    private String childPartCmmt = null;

    private String cseref = null;

    private String cserefCmmt = null;

    private String parentRefToSign = null;

    private Date hearReqDt = null;
    
    private String hearReqCmmt = null;

    private List<Participant> participants = null;

    public String getChildPart() {
      return childPart;
    }

    public void setChildPart(String childPart) {
      this.childPart = childPart;
    }

    public String getChildPartCmmt() {
      return childPartCmmt;
    }

    public void setChildPartCmmt(String childPartCmmt) {
      this.childPartCmmt = childPartCmmt;
    }

    public String getCseref() {
      return cseref;
    }

    public void setCseref(String cseref) {
      this.cseref = cseref;
    }

    public String getCserefCmmt() {
      return cserefCmmt;
    }

    public void setCserefCmmt(String cserefCmmt) {
      this.cserefCmmt = cserefCmmt;
    }

    public Date getHearReqDt() {
      return hearReqDt;
    }

    public void setHearReqDt(Date hearReqDt) {
      this.hearReqDt = hearReqDt;
    }

    public String getParentPart() {
      return parentPart;
    }

    public void setParentPart(String parentPart) {
      this.parentPart = parentPart;
    }

    public String getParentPartCmmt() {
      return parentPartCmmt;
    }

    public void setParentPartCmmt(String parentPartCmmt) {
      this.parentPartCmmt = parentPartCmmt;
    }

    public String getParentRefToSign() {
      return parentRefToSign;
    }

    public void setParentRefToSign(String parentRefToSign) {
      this.parentRefToSign = parentRefToSign;
    }

    public List<Participant> getParticipants() {
      return participants;
    }

    public void setParticipants(List<Participant> participants) {
      this.participants = participants;
    }

    public String getHearReqCmmt() {
      return hearReqCmmt;
    }

    public void setHearReqCmmt(String hearReqCmmt) {
      this.hearReqCmmt = hearReqCmmt;
    }
  }

  public static class Participant implements Serializable {
    private String nameFirst = null;

    private String nameMiddle = null;

    private String nameLast = null;

    private String relType = null;

    private Date signedDt = null;

    private String agreed = null;

    private String agreedCmmt = null;

    private Date agreedDt = null;

    public String getAgreed() {
      return agreed;
    }

    public void setAgreed(String agreed) {
      this.agreed = agreed;
    }

    public String getAgreedCmmt() {
      return agreedCmmt;
    }

    public void setAgreedCmmt(String agreedCmmt) {
      this.agreedCmmt = agreedCmmt;
    }

    public Date getAgreedDt() {
      return agreedDt;
    }

    public void setAgreedDt(Date agreedDt) {
      this.agreedDt = agreedDt;
    }

    public String getNameFirst() {
      return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
      this.nameFirst = nameFirst;
    }

    public String getNameLast() {
      return nameLast;
    }

    public void setNameLast(String nameLast) {
      this.nameLast = nameLast;
    }

    public String getNameMiddle() {
      return nameMiddle;
    }

    public void setNameMiddle(String nameMiddle) {
      this.nameMiddle = nameMiddle;
    }

    public String getRelType() {
      return relType;
    }

    public void setRelType(String relType) {
      this.relType = relType;
    }

    public Date getSignedDt() {
      return signedDt;
    }

    public void setSignedDt(Date signedDt) {
      this.signedDt = signedDt;
    }
  }

  public static class Aftercare implements Serializable {
    private String type = null;

    private String reasonDisFromFC = null;

    private Date disFromFCDt = null;

    private Date afterCareBeginDt = null;

    private Date afterCareEndDt = null;
    
    private List<CareTaker> careTakers = null;

    private List<Relative> relatives = null;

    public Date getAfterCareBeginDt() {
      return afterCareBeginDt;
    }

    public void setAfterCareBeginDt(Date afterCareBeginDt) {
      this.afterCareBeginDt = afterCareBeginDt;
    }

    public Date getAfterCareEndDt() {
      return afterCareEndDt;
    }

    public void setAfterCareEndDt(Date afterCareEndDt) {
      this.afterCareEndDt = afterCareEndDt;
    }

    public Date getDisFromFCDt() {
      return disFromFCDt;
    }

    public void setDisFromFCDt(Date disFromFCDt) {
      this.disFromFCDt = disFromFCDt;
    }

    public String getReasonDisFromFC() {
      return reasonDisFromFC;
    }

    public void setReasonDisFromFC(String reasonDisFromFC) {
      this.reasonDisFromFC = reasonDisFromFC;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public List<CareTaker> getCareTakers() {
      return careTakers;
    }

    public void setCareTakers(List<CareTaker> careTakers) {
      this.careTakers = careTakers;
    }

    public List<Relative> getRelatives() {
      return relatives;
    }

    public void setRelatives(List<Relative> relatives) {
      this.relatives = relatives;
    }
  }

  public static class CCFAMDTDetail implements Serializable {
    private String identNeed = null;

    private String serRec = null;

    private String comment = null;
    
    private String serPro = null;

    public String getSerPro() {
      return serPro;
    }

    public void setSerPro(String serPro) {
      this.serPro = serPro;
    }

    public String getComment() {
      return comment;
    }

    public void setComment(String comment) {
      this.comment = comment;
    }

    public String getIdentNeed() {
      return identNeed;
    }

    public void setIdentNeed(String identNeed) {
      this.identNeed = identNeed;
    }

    public String getSerRec() {
      return serRec;
    }

    public void setSerRec(String serRec) {
      this.serRec = serRec;
    }
  }

  public static class CCFAMDT implements Serializable {
    private Date refDt = null;

    private String agencyName = null;

    private String indName = null;

    private String indTitle = null;

    private Date assmtCmpltDt = null;

    private String plcmtRes = null;

    // TODO: PPT needs to be worked out as well as CCFA Recomendations
    private Date mdtDate = null;

    private String preName = null;

    private String preTitle = null;
    
    private Date preDt = null;
    
    List<CCFAMDTDetail> details = null;
    
    private Date flgDate = null;

    public String getAgencyName() {
      return agencyName;
    }

    public void setAgencyName(String agencyName) {
      this.agencyName = agencyName;
    }

    public Date getAssmtCmpltDt() {
      return assmtCmpltDt;
    }

    public void setAssmtCmpltDt(Date assmtCmpltDt) {
      this.assmtCmpltDt = assmtCmpltDt;
    }

    public String getIndName() {
      return indName;
    }

    public void setIndName(String indName) {
      this.indName = indName;
    }

    public String getIndTitle() {
      return indTitle;
    }

    public void setIndTitle(String indTitle) {
      this.indTitle = indTitle;
    }

    public Date getMdtDate() {
      return mdtDate;
    }

    public void setMdtDate(Date mdtDate) {
      this.mdtDate = mdtDate;
    }

    public String getPlcmtRes() {
      return plcmtRes;
    }

    public void setPlcmtRes(String plcmtRes) {
      this.plcmtRes = plcmtRes;
    }

    public Date getRefDt() {
      return refDt;
    }

    public void setRefDt(Date refDt) {
      this.refDt = refDt;
    }

    public List<CCFAMDTDetail> getDetails() {
      return details;
    }

    public void setDetails(List<CCFAMDTDetail> details) {
      this.details = details;
    }

    public String getPreName() {
      return preName;
    }

    public void setPreName(String preName) {
      this.preName = preName;
    }

    public String getPreTitle() {
      return preTitle;
    }

    public void setPreTitle(String preTitle) {
      this.preTitle = preTitle;
    }

    public Date getPreDt() {
      return preDt;
    }

    public void setPreDt(Date preDt) {
      this.preDt = preDt;
    }
    
    public Date getFlgDate() {
      return flgDate;
    }

    public void setFlgDate(Date flgDate) {
      this.flgDate = flgDate;
    }
  }

  public List<Case> getCases() {
    return cases;
  }

  public void setCases(List<Case> cases) {
    this.cases = cases;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
