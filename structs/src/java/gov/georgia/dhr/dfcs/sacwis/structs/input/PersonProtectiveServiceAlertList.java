package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

/** @todo add javadocs for methods */

/**
 * PersonProtectiveServiceAlertList value bean that contains the list of persons to display on a Protective Service
 * Alert.
 *
 * @author Lokhande, Lata, Sept 13, 2006
 */
@SuppressWarnings("serial")
public class PersonProtectiveServiceAlertList implements Serializable {
  private int idPerson;
  private String name = null;
  private Date dob = null;
  private String ssn = null;
  private String race = null;
  private String ethnicity = null;
  private String gender = null;
  private String legalStatus = null;
  private boolean psaCurrentlyActive;
  private boolean psaNewlyActive;

  public PersonProtectiveServiceAlertList() {
    this.idPerson = 0;
    this.psaCurrentlyActive = false;
    this.psaNewlyActive = false;
  }

  public PersonProtectiveServiceAlertList(boolean currentlyActive, boolean newlyActive, int idPerson,
                                          String name, Date dob, String ssn, String race, String ethnicity,
                                          String gender, String legalStatus) {
    this.psaCurrentlyActive = currentlyActive;
    this.psaNewlyActive = newlyActive;
    this.idPerson = idPerson;
    this.name = name;
    this.dob = dob;
    this.ssn = ssn;
    this.race = race;
    this.ethnicity = ethnicity;
    this.gender = gender;
    this.legalStatus = legalStatus;
  }

  public PersonProtectiveServiceAlertList(boolean currentlyActive, boolean newlyActive, int idPerson) {
    this.psaCurrentlyActive = currentlyActive;
    this.psaNewlyActive = newlyActive;
    this.idPerson = idPerson;
  }

  public boolean isPsaCurrentlyActive() {
    return this.psaCurrentlyActive;
  }

  public void setPsaCurrentlyActive(boolean psaCurrentlyActive) {
    this.psaCurrentlyActive = psaCurrentlyActive;
  }

  public boolean isPsaNewlyActive() {
    return this.psaNewlyActive;
  }

  public void setPsaNewlyActive(boolean psaNewlyActive) {
    this.psaNewlyActive = psaNewlyActive;
  }

  //public boolean hasIdPerson() {
  //  return this.idPerson > 0;
  //}

  public int getIdPerson() {
    return this.idPerson;
  }

  //public Integer getIdPersonWrapped() {
  //  return this.idPerson;
  //}

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDOB() {
    return this.dob;
  }

  public void setDOB(Date dob) {
    this.dob = dob;
  }

  public String getSSN() {
    return this.ssn;
  }

  public void setSSN(String ssn) {
    this.ssn = ssn;
  }

  public String getRace() {
    return this.race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public String getEthnicity() {
    return this.ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getLegalStatus() {
    return this.legalStatus;
  }

  public void setLegalStatus(String legalStatus) {
    this.legalStatus = legalStatus;
  }
}