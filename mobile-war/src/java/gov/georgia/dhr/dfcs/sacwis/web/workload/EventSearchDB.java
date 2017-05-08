package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Used by EventSearch to maintain state of checkboxes, dates, and person/staff ids/names */
public class EventSearchDB
        implements Serializable {
  protected boolean searchEntireCase = false;
  protected boolean isNew = true;
  protected String endDateString = null;
  protected String personName = null;
  protected String staffName = null;
  protected String startDateString = null;
  protected String[] eventTypeCodes = null;
  protected String[] stageCodes = null;
  protected int personId = 0;
  protected int staffId = 0;

  public String getEndDateString() {
    return endDateString;
  }

  public void setEndDateString(String endDateString) {
    this.isNew = false;
    this.endDateString = endDateString;
  }

  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.isNew = false;
    this.personName = personName;
  }

  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.isNew = false;
    this.staffName = staffName;
  }

  public String getStartDateString() {
    return startDateString;
  }

  public void setStartDateString(String startDateString) {
    this.isNew = false;
    this.startDateString = startDateString;
  }

  public List getEventTypeCodesList() {
    if (eventTypeCodes == null) {
      return new ArrayList();
    }
    return Arrays.asList(eventTypeCodes);
  }

  public String[] getEventTypeCodes() {
    return eventTypeCodes;
  }

  public void setEventTypeCodes(String[] eventTypeCodes) {
    this.isNew = false;
    this.eventTypeCodes = eventTypeCodes;
  }

  public List getStageCodesList() {
    if (stageCodes == null) {
      return new ArrayList();
    }
    return Arrays.asList(stageCodes);
  }

  public String[] getStageCodes() {
    return stageCodes;
  }

  public void setStageCodes(String[] stageCodes) {
    this.isNew = false;
    this.stageCodes = stageCodes;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.isNew = false;
    this.personId = personId;
  }

  public int getStaffId() {
    return staffId;
  }

  public void setStaffId(int staffId) {
    this.isNew = false;
    this.staffId = staffId;
  }

  public boolean getIsNew() {
    return isNew;
  }

  public boolean getSearchEntireCase() {
    return searchEntireCase;
  }

  public void setSearchEntireCase(boolean searchEntireCase) {
    this.searchEntireCase = searchEntireCase;
  }
}
