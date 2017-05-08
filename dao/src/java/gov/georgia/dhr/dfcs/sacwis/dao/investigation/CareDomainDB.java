package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public class CareDomainDB extends BaseValueBean {
  private int caseId;
  private int stageId;
  private int eventId;
  private int careDomainId;
  private String allegationFocusCode;
  private String domainCode;
  private String domainText;
  private int order;
  private List<CareCategoryDB> categories = new ArrayList<CareCategoryDB>();
  private boolean isDirty;
  private java.sql.Timestamp dateLastUpdate;

  public CareDomainDB(ResultSet results, boolean forExistingCare) {
    try {
      if (forExistingCare) {
        this.setCareDomainId(results.getInt(CareDao.ID_CARE_DOMAIN_COLUMN));
        this.setAllegationFocusCode(StringHelper.getNonNullString(
                results.getString(CareDao.CD_ALLEGATION_FOCUS_COLUMN)));
        this.setCaseId(results.getInt(CareDao.ID_CASE_COLUMN));
        this.setStageId(results.getInt(CareDao.ID_STAGE_COLUMN));
        this.setEventId(results.getInt(CareDao.ID_EVENT_COLUMN));
        this.setDateLastUpdate(results.getTimestamp(CareDao.DATE_LAST_UPDATE_COLUMN));
      } else {
        //Set these values to empty strings so that jsp doesn't have to worry about it
        this.setAllegationFocusCode(StringHelper.EMPTY_STRING);
      }
      this.setDomainCode(results.getString(CareDao.CD_DOMAIN_COLUMN));
      this.setDomainText(results.getString(CareDao.TXT_DOMAIN_COLUMN));
      this.setOrder(results.getInt(CareDao.NBR_DOMAIN_ORDER_COLUMN));
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }

  }

  public void addCategory(CareCategoryDB category) {
    categories.add(category);
  }

  public int getCareDomainId() {
    return careDomainId;
  }

  public void setCareDomainId(int careDomainId) {
    this.careDomainId = careDomainId;
    List categories = this.getCategories();
    Iterator categoryIt = categories.iterator();
    while (categoryIt.hasNext()) {
      CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();
      categoryDB.setCareDomainId(careDomainId);
    }
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
    List categories = this.getCategories();
    Iterator categoryIt = categories.iterator();
    while (categoryIt.hasNext()) {
      CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();
      categoryDB.setCaseId(caseId);
    }
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
    List categories = this.getCategories();
    Iterator categoryIt = categories.iterator();
    while (categoryIt.hasNext()) {
      CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();
      categoryDB.setStageId(stageId);
    }
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
    List categories = this.getCategories();
    Iterator categoryIt = categories.iterator();
    while (categoryIt.hasNext()) {
      CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();
      categoryDB.setEventId(eventId);
    }
  }

  public String getAllegationFocusCode() {
    return allegationFocusCode;
  }

  public void setAllegationFocusCode(String allegationFocusCode) {
    this.allegationFocusCode = allegationFocusCode;

    if (ArchitectureConstants.Y.equals(allegationFocusCode)) {
      List categories = this.getCategories();
      Iterator categoryIt = categories.iterator();

      while (categoryIt.hasNext()) {
        CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();
        categoryDB.setReasonCode(StringHelper.EMPTY_STRING);
        categoryDB.setIsDirty(true);
      }
    }

  }

  public java.sql.Timestamp getDateLastUpdate() {
    return dateLastUpdate;
  }

  public void setDateLastUpdate(java.sql.Timestamp dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  public String getDomainCode() {
    return domainCode;
  }

  public void setDomainCode(String domainCode) {
    this.domainCode = domainCode;
  }

  public String getDomainText() {
    return domainText;
  }

  public void setDomainText(String domainText) {
    this.domainText = domainText;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public java.util.List getCategories() {
    return categories;
  }

  public void setCategories(List<CareCategoryDB> categories) {
    this.categories = categories;
  }

  public boolean isDirty() {
    return this.isDirty;
  }

  public void setIsDirty(boolean isDirty) {
    this.isDirty = isDirty;
  }

  public void setCareDirty(boolean isDirty) {
    this.isDirty = isDirty;

    List categories = this.getCategories();
    Iterator categoriesIt = categories.iterator();
    while (categoriesIt.hasNext()) {
      CareCategoryDB categoryDB = (CareCategoryDB) categoriesIt.next();
      categoryDB.setCareDirty(isDirty);
    }
  }

  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("Case ID: ").append(this.getCaseId());
    output.append("\nStage ID: ").append(this.getStageId());
    output.append("\nEvent ID: ").append(this.getEventId());
    output.append("\nCare Domain ID: ").append(this.getCareDomainId());
    output.append("\nDomain Code: ").append(this.getDomainCode());
    output.append("\nDomain Text: ").append(this.getDomainText());
    output.append("\nOrder: ").append(this.getOrder());
    output.append("\nAllegation Focus Code: ").append(this.getAllegationFocusCode());
    output.append("\nDate Last Update: ").append(this.getDateLastUpdate());
    output.append("\nIs Dirty: ").append(this.isDirty());
    output.append("\nCategories: ").append(this.getCategories());
    return output.toString();
  }

  public boolean isComplete() {
    boolean isComplete = true;
    boolean checkReasons = false;
    boolean checkFactors = false;

    if (!StringHelper.isValid(this.getAllegationFocusCode())) {
      isComplete = false;
    } else if (ArchitectureConstants.N.equals(this.getAllegationFocusCode())) {
      checkReasons = true;
    } else if (ArchitectureConstants.Y.equals(this.getAllegationFocusCode())) {
      checkFactors = true;
    }

    List categories = this.getCategories();
    Iterator categoryIt = categories.iterator();
    while (categoryIt.hasNext() && checkReasons && !checkFactors && isComplete) {
      CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();
      if (ArchitectureConstants.Y.equals(categoryDB.getReasonCode())) {
        //All we need is one Yes.  Doesn't matter what the other categories are.
        //Check the factors from here.
        checkFactors = true;
        checkReasons = false;
        break;
      }
    }

    categoryIt = categories.iterator();
    while (categoryIt.hasNext() && isComplete) {
      CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();
      isComplete = categoryDB.isComplete(checkReasons, checkFactors);
    }

    return isComplete;
  }
}