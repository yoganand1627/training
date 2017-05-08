package gov.georgia.dhr.dfcs.sacwis.dao.person;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

/** @todo add javadoc comments */

/**
 * Holds all data pertaining to a Person.
 *
 * @author Jason Rios, February 5, 2003
 */
public class PersonValueBean extends BaseValueBean {
  // instance variables
  private int caseId;
  private int stageId;
  private int eventId;
  private int personId;
  private Date personTableDateLastUpdate;
  private String sex;
  private AddressValueBean currentAddress;
  private Date dateOfDeath;
  private Date dateOfBirth;
  private String religionCode;
  private String personCharacteristicsCode;
  private String livingArrangementCode;
  private String guardianshipConservatorshipCode;
  private String activeInactiveMergedStatusCode;
  private String reasonForDeathCode;
  private String maritalStatusCode;
  private String primaryLanguageCode;
  private String ethnicGroupCode;
  private Boolean isApproxDateOfBirth;
  private Boolean needsPersonHistoryRowAdded;
  private int age;
  private String phone;
  private String id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String fullName;
  private String occupation;
  private String nameSuffixCode;
  private Boolean isMerged;
  private String relationshipInterestCode;
  private String personCategoryCode;
  private Date personCategoryDateLastUpdate;
  private int annualIncome;
  private String birthCity;
  private String birthCountry;
  private String birthCountyCode;
  private String birthState;
  private String citizenshipCode;
  private String eyeColorCode;
  private String fosterAdoptiveHomeRoleCode;
  private String hairColorCode;
  private String highestEducationCode;
  private Boolean motherWasMarriedAtChildsBirth;
  private Date personDetailTableDateLastUpdate;
  private Boolean personWasBornInUnitedStates;
  private String lastEmployersName;
  private String maidenName;
  private int heightFootComponent;
  private int heightInchesComponent;
  private int weight;
  private String raceCode;
  private String raceDateLastUpdate;
  private List addresses;
  private String roleInStageCode;
  private String permanencyGoalCode;
  private org.exolab.castor.types.Date permanencyGoalTargetDate;
  private Date eventPersonLinkDateLastUpdate;

  /** Constructor */
  public PersonValueBean() {
    caseId = 0;
    stageId = 0;
    eventId = 0;
    personId = 0;
    personTableDateLastUpdate = null;
    sex = null;
    currentAddress = null;
    dateOfDeath = null;
    dateOfBirth = null;
    religionCode = null;
    personCharacteristicsCode = null;
    livingArrangementCode = null;
    guardianshipConservatorshipCode = null;
    activeInactiveMergedStatusCode = null;
    reasonForDeathCode = null;
    maritalStatusCode = null;
    primaryLanguageCode = null;
    ethnicGroupCode = null;
    isApproxDateOfBirth = null;
    needsPersonHistoryRowAdded = null;
    age = 0;
    phone = null;
    id = null;
    firstName = null;
    middleName = null;
    lastName = null;
    fullName = null;
    occupation = null;
    nameSuffixCode = null;
    isMerged = null;
    relationshipInterestCode = null;
    personCategoryCode = null;
    personCategoryDateLastUpdate = null;
    annualIncome = 0;
    birthCity = null;
    birthCountry = null;
    birthCountyCode = null;
    birthState = null;
    citizenshipCode = null;
    eyeColorCode = null;
    fosterAdoptiveHomeRoleCode = null;
    hairColorCode = null;
    highestEducationCode = null;
    motherWasMarriedAtChildsBirth = null;
    personDetailTableDateLastUpdate = null;
    personWasBornInUnitedStates = null;
    lastEmployersName = null;
    maidenName = null;
    heightFootComponent = 0;
    heightInchesComponent = 0;
    weight = 0;
    raceCode = null;
    raceDateLastUpdate = null;
    addresses = null;
    roleInStageCode = null;
    permanencyGoalCode = null;
    permanencyGoalTargetDate = null;
    eventPersonLinkDateLastUpdate = null;
  }

  public String getActiveInactiveMergedStatusCode() {
    return activeInactiveMergedStatusCode;
  }

  public List getAddresses() {
    return addresses;
  }

  public int getAge() {
    return age;
  }

  public int getAnnualIncome() {
    return annualIncome;
  }

  public String getBirthCity() {
    return birthCity;
  }

  public String getBirthCountry() {
    return birthCountry;
  }

  public String getBirthCountyCode() {
    return birthCountyCode;
  }

  public String getBirthState() {
    return birthState;
  }

  public String getCitizenshipCode() {
    return citizenshipCode;
  }

  public AddressValueBean getCurrentAddress() {
    return currentAddress;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public Date getDateOfDeath() {
    return dateOfDeath;
  }

  public String getEthnicGroupCode() {
    return ethnicGroupCode;
  }

  public String getEyeColorCode() {
    return eyeColorCode;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getFosterAdoptiveHomeRoleCode() {
    return fosterAdoptiveHomeRoleCode;
  }

  public String getFullName() {
    return fullName;
  }

  public String getGuardianshipConservatorshipCode() {
    return guardianshipConservatorshipCode;
  }

  public String getHairColorCode() {
    return hairColorCode;
  }

  public int getHeightFootComponent() {
    return heightFootComponent;
  }

  public int getHeightInchesComponent() {
    return heightInchesComponent;
  }

  public String getHighestEducationCode() {
    return highestEducationCode;
  }

  public String getId() {
    return id;
  }

  public Boolean getIsApproxDateOfBirth() {
    return isApproxDateOfBirth;
  }

  public Boolean getIsMerged() {
    return isMerged;
  }

  public String getLastEmployersName() {
    return lastEmployersName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getLivingArrangementCode() {
    return livingArrangementCode;
  }

  public String getRoleInStageCode() {
    return roleInStageCode;
  }

  public String getPermanencyGoalCode() {
    return permanencyGoalCode;
  }

  public org.exolab.castor.types.Date getPermanencyGoalTargetDate() {
    return permanencyGoalTargetDate;
  }

  public Date getEventPersonLinkDateLastUpdate() {
    return eventPersonLinkDateLastUpdate;
  }

  public void setActiveInactiveMergedStatusCode(String activeInactiveMergedStatusCode) {
    this.activeInactiveMergedStatusCode = activeInactiveMergedStatusCode;
  }

  public void setAddresses(List addresses) {
    this.addresses = addresses;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setAnnualIncome(int annualIncome) {
    this.annualIncome = annualIncome;
  }

  public void setBirthCity(String birthCity) {
    this.birthCity = birthCity;
  }

  public void setBirthCountry(String birthCountry) {
    this.birthCountry = birthCountry;
  }

  public void setBirthCountyCode(String birthCountyCode) {
    this.birthCountyCode = birthCountyCode;
  }

  public void setBirthState(String birthState) {
    this.birthState = birthState;
  }

  public void setCitizenshipCode(String citizenshipCode) {
    this.citizenshipCode = citizenshipCode;
  }

  public void setCurrentAddress(AddressValueBean currentAddress) {
    this.currentAddress = currentAddress;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setDateOfDeath(Date dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }

  public void setEthnicGroupCode(String ethnicGroupCode) {
    this.ethnicGroupCode = ethnicGroupCode;
  }

  public void setEyeColorCode(String eyeColorCode) {
    this.eyeColorCode = eyeColorCode;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setFosterAdoptiveHomeRoleCode(String fosterAdoptiveHomeRoleCode) {
    this.fosterAdoptiveHomeRoleCode = fosterAdoptiveHomeRoleCode;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setGuardianshipConservatorshipCode(String guardianshipConservatorshipCode) {
    this.guardianshipConservatorshipCode = guardianshipConservatorshipCode;
  }

  public void setHairColorCode(String hairColorCode) {
    this.hairColorCode = hairColorCode;
  }

  public void setHeightFootComponent(int heightFootComponent) {
    this.heightFootComponent = heightFootComponent;
  }

  public void setHeightInchesComponent(int heightInchesComponent) {
    this.heightInchesComponent = heightInchesComponent;
  }

  public void setHighestEducationCode(String highestEducationCode) {
    this.highestEducationCode = highestEducationCode;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setIsApproxDateOfBirth(Boolean isApproxDateOfBirth) {
    this.isApproxDateOfBirth = isApproxDateOfBirth;
  }

  public void setIsMerged(Boolean isMerged) {
    this.isMerged = isMerged;
  }

  public void setLastEmployersName(String lastEmployersName) {
    this.lastEmployersName = lastEmployersName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setLivingArrangementCode(String livingArrangementCode) {
    this.livingArrangementCode = livingArrangementCode;
  }

  public String getMaidenName() {
    return maidenName;
  }

  public String getMaritalStatusCode() {
    return maritalStatusCode;
  }

  public String getMiddleName() {
    return middleName;
  }

  public Boolean getMotherWasMarriedAtChildsBirth() {
    return motherWasMarriedAtChildsBirth;
  }

  public String getNameSuffixCode() {
    return nameSuffixCode;
  }

  public Boolean getNeedsPersonHistoryRowAdded() {
    return needsPersonHistoryRowAdded;
  }

  public String getOccupation() {
    return occupation;
  }

  public String getPersonCategoryCode() {
    return personCategoryCode;
  }

  public Date getPersonCategoryDateLastUpdate() {
    return personCategoryDateLastUpdate;
  }

  public String getPersonCharacteristicsCode() {
    return personCharacteristicsCode;
  }

  public Date getPersonDetailTableDateLastUpdate() {
    return personDetailTableDateLastUpdate;
  }

  public int getPersonId() {
    return personId;
  }

  public Date getPersonTableDateLastUpdate() {
    return personTableDateLastUpdate;
  }

  public Boolean getPersonWasBornInUnitedStates() {
    return personWasBornInUnitedStates;
  }

  public String getPhone() {
    return phone;
  }

  public String getPrimaryLanguageCode() {
    return primaryLanguageCode;
  }

  public String getRaceCode() {
    return raceCode;
  }

  public String getRaceDateLastUpdate() {
    return raceDateLastUpdate;
  }

  public String getReasonForDeathCode() {
    return reasonForDeathCode;
  }

  public String getRelationshipInterestCode() {
    return relationshipInterestCode;
  }

  public String getReligionCode() {
    return religionCode;
  }

  public String getSex() {
    return sex;
  }

  public int getWeight() {
    return weight;
  }

  public void setMaidenName(String maidenName) {
    this.maidenName = maidenName;
  }

  public void setMaritalStatusCode(String maritalStatusCode) {
    this.maritalStatusCode = maritalStatusCode;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public void setMotherWasMarriedAtChildsBirth(Boolean motherWasMarriedAtChildsBirth) {
    this.motherWasMarriedAtChildsBirth = motherWasMarriedAtChildsBirth;
  }

  public void setNameSuffixCode(String nameSuffixCode) {
    this.nameSuffixCode = nameSuffixCode;
  }

  public void setNeedsPersonHistoryRowAdded(Boolean needsPersonHistoryRowAdded) {
    this.needsPersonHistoryRowAdded = needsPersonHistoryRowAdded;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public void setPersonCategoryCode(String personCategoryCode) {
    this.personCategoryCode = personCategoryCode;
  }

  public void setPersonCategoryDateLastUpdate(Date personCategoryDateLastUpdate) {
    this.personCategoryDateLastUpdate = personCategoryDateLastUpdate;
  }

  public void setPersonCharacteristicsCode(String personCharacteristicsCode) {
    this.personCharacteristicsCode = personCharacteristicsCode;
  }

  public void setPersonDetailTableDateLastUpdate(Date personDetailTableDateLastUpdate) {
    this.personDetailTableDateLastUpdate = personDetailTableDateLastUpdate;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public void setPersonTableDateLastUpdate(Date personTableDateLastUpdate) {
    this.personTableDateLastUpdate = personTableDateLastUpdate;
  }

  public void setPersonWasBornInUnitedStates(Boolean personWasBornInUnitedStates) {
    this.personWasBornInUnitedStates = personWasBornInUnitedStates;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPrimaryLanguageCode(String primaryLanguageCode) {
    this.primaryLanguageCode = primaryLanguageCode;
  }

  public void setRaceCode(String raceCode) {
    this.raceCode = raceCode;
  }

  public void setRaceDateLastUpdate(String raceDateLastUpdate) {
    this.raceDateLastUpdate = raceDateLastUpdate;
  }

  public void setReasonForDeathCode(String reasonForDeathCode) {
    this.reasonForDeathCode = reasonForDeathCode;
  }

  public void setRelationshipInterestCode(String relationshipInterestCode) {
    this.relationshipInterestCode = relationshipInterestCode;
  }

  public void setReligionCode(String religionCode) {
    this.religionCode = religionCode;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public void setRoleInStageCode(String roleInStageCode) {
    this.roleInStageCode = roleInStageCode;
  }

  public void setPermanencyGoalCode(String permanencyGoalCode) {
    this.permanencyGoalCode = permanencyGoalCode;
  }

  public void setPermanencyGoalTargetDate(org.exolab.castor.types.Date permanencyGoalTargetDate) {
    this.permanencyGoalTargetDate = permanencyGoalTargetDate;
  }

  public void setEventPersonLinkDateLastUpdate(Date eventPersonLinkDateLastUpdate) {
    this.eventPersonLinkDateLastUpdate = eventPersonLinkDateLastUpdate;
  }

  /**
   * Get a string representation of the variable names and values.
   *
   * @ return String
   */
  public String toString() {
    return (
            "\n" +
            "PersonValueBean \n" +
            "  caseId = " + caseId + "\n" +
            "  stageId = " + stageId + "\n" +
            "  eventId = " + eventId + "\n" +
            "  personId = " + personId + "\n" +
            "  personTableDateLastUpdate = " + personTableDateLastUpdate + "\n" +
            "  sex = " + sex + "\n" +
            "  currentAddress = " + currentAddress + "\n" +
            "  dateOfDeath = " + dateOfDeath + "\n" +
            "  dateOfBirth = " + dateOfBirth + "\n" +
            "  religionCode = " + religionCode + "\n" +
            "  personCharacteristicsCode = " + personCharacteristicsCode + "\n" +
            "  livingArrangementCode = " + livingArrangementCode + "\n" +
            "  guardianshipConservatorshipCode = " + guardianshipConservatorshipCode + "\n" +
            "  activeInactiveMergedStatusCode = " + activeInactiveMergedStatusCode + "\n" +
            "  reasonForDeathCode = " + reasonForDeathCode + "\n" +
            "  maritalStatusCode = " + maritalStatusCode + "\n" +
            "  primaryLanguageCode = " + primaryLanguageCode + "\n" +
            "  ethnicGroupCode = " + ethnicGroupCode + "\n" +
            "  isApproxDateOfBirth = " + isApproxDateOfBirth + "\n" +
            "  needsPersonHistoryRowAdded = " + needsPersonHistoryRowAdded + "\n" +
            "  age = " + age + "\n" +
            "  phone = " + phone + "\n" +
            "  id = " + id + "\n" +
            "  firstName = " + firstName + "\n" +
            "  middleName = " + middleName + "\n" +
            "  lastName = " + lastName + "\n" +
            "  fullName = " + fullName + "\n" +
            "  occupation = " + occupation + "\n" +
            "  nameSuffixCode = " + nameSuffixCode + "\n" +
            "  isMerged = " + isMerged + "\n" +
            "  relationshipInterestCode = " + relationshipInterestCode + "\n" +
            "  personCategoryCode = " + personCategoryCode + "\n" +
            "  personCategoryDateLastUpdate = " + personCategoryDateLastUpdate + "\n" +
            "  annualIncome = " + annualIncome + "\n" +
            "  birthCity = " + birthCity + "\n" +
            "  birthCountry = " + birthCountry + "\n" +
            "  birthCountyCode = " + birthCountyCode + "\n" +
            "  birthState = " + birthState + "\n" +
            "  citizenshipCode = " + citizenshipCode + "\n" +
            "  eyeColorCode = " + eyeColorCode + "\n" +
            "  fosterAdoptiveHomeRoleCode = " + fosterAdoptiveHomeRoleCode + "\n" +
            "  hairColorCode = " + hairColorCode + "\n" +
            "  highestEducationCode = " + highestEducationCode + "\n" +
            "  motherWasMarriedAtChildsBirth = " + motherWasMarriedAtChildsBirth + "\n" +
            "  personDetailTableDateLastUpdate = " + personDetailTableDateLastUpdate + "\n" +
            "  personWasBornInUnitedStates = " + personWasBornInUnitedStates + "\n" +
            "  lastEmployersName = " + lastEmployersName + "\n" +
            "  maidenName = " + maidenName + "\n" +
            "  heightFootComponent = " + heightFootComponent + "\n" +
            "  heightInchesComponent = " + heightInchesComponent + "\n" +
            "  weight = " + weight + "\n" +
            "  raceCode = " + raceCode + "\n" +
            "  raceDateLastUpdate = " + raceDateLastUpdate + "\n" +
            "  addresses = " + addresses + "\n" +
            "  roleInStageCode = " + roleInStageCode + "\n" +
            "  permanencyGoalCode = " + permanencyGoalCode + "\n" +
            "  permanencyGoalTargetDate = " + permanencyGoalTargetDate + "\n" +
            "  eventPersonLinkDateLastUpdate = " + eventPersonLinkDateLastUpdate + "\n" +
            "end PersonValueBean \n");
  }

}

