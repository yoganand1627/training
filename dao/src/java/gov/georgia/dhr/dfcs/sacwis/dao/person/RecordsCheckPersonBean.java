package gov.georgia.dhr.dfcs.sacwis.dao.person;

import java.io.Serializable;
import java.util.Date;

public class RecordsCheckPersonBean implements Serializable {

  private static final long serialVersionUID = 1L;
  private int personId;
  private String firstName;
  private String middleName;
  private String lastName;
  private String displayNameFull;
  private Date dateOfBirth;
  private String cdStagePersonType;
  private String cdStagePersonRole;
  private String decodeStagePersonRole;
  private int age;
  private String cdStagePersRelInt;
  
  
  public int getPersonId() {
    return personId;
  }
  public void setPersonId(int personId) {
    this.personId = personId;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getMiddleName() {
    return middleName;
  }
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getDisplayNameFull() {
    return displayNameFull;
  }
  public void setDisplayNameFull(String displayNameFull) {
    this.displayNameFull = displayNameFull;
  }
  public Date getDateOfBirth() {
    return dateOfBirth;
  }
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  public String getCdStagePersonType() {
    return cdStagePersonType;
  }
  public void setCdStagePersonType(String cdStagePersonType) {
    this.cdStagePersonType = cdStagePersonType;
  }
  public String getCdStagePersonRole() {
    return cdStagePersonRole;
  }
  public void setCdStagePersonRole(String cdStagePersonRole) {
    this.cdStagePersonRole = cdStagePersonRole;
  }
  public String getDecodeStagePersonRole() {
    return decodeStagePersonRole;
  }
  public void setDecodeStagePersonRole(String decodeStagePersonRole) {
    this.decodeStagePersonRole = decodeStagePersonRole;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getCdStagePersRelInt() {
    return cdStagePersRelInt;
  }
  public void setCdStagePersRelInt(String cdStagePersRelInt) {
    this.cdStagePersRelInt = cdStagePersRelInt;
  }
}
