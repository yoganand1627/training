package gov.georgia.dhr.dfcs.sacwis.dao.common;

import java.io.Serializable;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

/** @todo add javadocs for methods */

/**
 * PhoneDB value bean that contains the details of a single phone number entry.
 *
 * @author Matthew McClain, March 1, 2003
 */
public class PhoneDB implements Serializable {
  protected int phoneId = 0;
  protected Date lastUpdate = null;
  protected int personId = 0;
  protected String comments = null;
  protected String extension = null;
  protected String number = null;
  protected Date startDate = null;
  protected Date endDate = null;
  protected boolean invalid = false;
  protected boolean primary = false;
  protected String phoneType = null;
  protected String personFullName = null;

  public int getPhoneId() {
    return phoneId;
  }

  public void setPhoneId(int phoneId) {
    this.phoneId = phoneId;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public long getLastUpdateTime() {
    if (lastUpdate == null) {
      return 0L;
    }
    return lastUpdate.getTime();
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Date getStartDate() {
    return startDate;
  }

  public String getStartDateString() {
    return DateHelper.toString(startDate,
                               DateHelper.SLASH_FORMAT);
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public String getEndDateString() {
    return DateHelper.toString(endDate,
                               DateHelper.SLASH_FORMAT);
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public boolean getInvalid() {
    return invalid;
  }

  public void setInvalid(boolean invalid) {
    this.invalid = invalid;
  }

  public boolean getPrimary() {
    return primary;
  }

  public void setPrimary(boolean primary) {
    this.primary = primary;
  }

  public String getPhoneType() {
    return phoneType;
  }

  public void setPhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

  public String getPersonFullName() {
    return personFullName;
  }

  public void setPersonFullName(String personFullName) {
    this.personFullName = personFullName;
  }

  public String toString() {
    return
            "PhoneDB: \n" +
            " phoneId: " + phoneId + "\n" +
            " lastUpdate: " + lastUpdate + "\n" +
            " personId: " + personId + "\n" +
            " comments: " + comments + "\n" +
            " extension: " + extension + "\n" +
            " number: " + number + "\n" +
            " startDate: " + startDate + "\n" +
            " endDate: " + endDate + "\n" +
            " invalid: " + invalid + "\n" +
            " primary: " + primary + "\n" +
            " phoneType: " + phoneType + "\n" +
            " personFullName: " + personFullName + "\n" +
            "End PhoneDB \n";
  }
}
