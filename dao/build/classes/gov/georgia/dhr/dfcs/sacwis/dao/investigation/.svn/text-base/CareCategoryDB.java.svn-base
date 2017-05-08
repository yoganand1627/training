package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public class CareCategoryDB extends BaseValueBean {
  private int caseId;
  private int stageId;
  private int eventId;
  private String reasonCode;
  private int careCategoryId;
  private int careDomainId;
  private String categoryText;
  private int order;
  private String domainCode;
  private List<CareFactorDB> factors = new ArrayList<CareFactorDB>();
  private String categoryCode;
  private boolean isDirty;
  private java.sql.Timestamp dateLastUpdate;

  public CareCategoryDB(ResultSet results, boolean forExistingCare) {
    try {
      if (forExistingCare) {
        this.setCareCategoryId(results.getInt(CareDao.ID_CARE_CATEGORY_COLUMN));
        this.setCareDomainId(results.getInt(CareDao.ID_CARE_DOMAIN_COLUMN));
        this.setCaseId(results.getInt(CareDao.ID_CASE_COLUMN));
        this.setStageId(results.getInt(CareDao.ID_STAGE_COLUMN));
        this.setEventId(results.getInt(CareDao.ID_EVENT_COLUMN));
        this.setCategoryCode(results.getString(CareDao.CD_CATEGORY_COLUMN));
        this.setReasonCode(StringHelper.getNonNullString(results.getString(CareDao.CD_REASON_TO_BELIEVE_COLUMN)));
        this.setDateLastUpdate(results.getTimestamp(CareDao.DATE_LAST_UPDATE_COLUMN));
      } else {
        //Set these values to empty strings so that jsp doesn't have to worry about it
        this.setReasonCode(StringHelper.EMPTY_STRING);
      }
      this.setCategoryCode(results.getString(CareDao.CD_CATEGORY_COLUMN));
      this.setDomainCode(results.getString(CareDao.CD_DOMAIN_COLUMN));
      this.setCategoryText(results.getString(CareDao.TXT_CATEGORY_COLUMN));
      this.setOrder(results.getInt(CareDao.NBR_CATEGORY_ORDER_COLUMN));
      this.setIsDirty(false);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }

  }

  public void addFactor(CareFactorDB factor) {
    factors.add(factor);
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
    List factors = this.getFactors();
    Iterator factorsIt = factors.iterator();
    while (factorsIt.hasNext()) {
      CareFactorDB factorDB = (CareFactorDB) factorsIt.next();
      factorDB.setCaseId(caseId);
    }
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
    List factors = this.getFactors();
    Iterator factorsIt = factors.iterator();
    while (factorsIt.hasNext()) {
      CareFactorDB factorDB = (CareFactorDB) factorsIt.next();
      factorDB.setStageId(stageId);
    }
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
    List factors = this.getFactors();
    Iterator factorsIt = factors.iterator();
    while (factorsIt.hasNext()) {
      CareFactorDB factorDB = (CareFactorDB) factorsIt.next();
      factorDB.setEventId(eventId);
    }
  }

  public String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public int getCareCategoryId() {
    return careCategoryId;
  }

  public void setCareCategoryId(int careCategoryId) {
    this.careCategoryId = careCategoryId;
    List factors = this.getFactors();
    Iterator factorsIt = factors.iterator();
    while (factorsIt.hasNext()) {
      CareFactorDB factorDB = (CareFactorDB) factorsIt.next();
      factorDB.setCareCategoryId(careCategoryId);
    }
  }

  public int getCareDomainId() {
    return careDomainId;
  }

  public void setCareDomainId(int careDomainId) {
    this.careDomainId = careDomainId;
    List factors = this.getFactors();
    Iterator factorsIt = factors.iterator();
    while (factorsIt.hasNext()) {
      CareFactorDB factorDB = (CareFactorDB) factorsIt.next();
      factorDB.setCareDomainId(careDomainId);
    }
  }

  public String getCategoryText() {
    return categoryText;
  }

  public void setCategoryText(String categoryText) {
    this.categoryText = categoryText;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getDomainCode() {
    return domainCode;
  }

  public void setDomainCode(String domainCode) {
    this.domainCode = domainCode;
  }

  public java.util.List getFactors() {
    return factors;
  }

  public void setFactors(List<CareFactorDB> factors) {
    this.factors = factors;
  }

  public java.sql.Timestamp getDateLastUpdate() {
    return dateLastUpdate;
  }

  public void setDateLastUpdate(java.sql.Timestamp dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  public String getCategoryCode() {
    return categoryCode;
  }

  public void setCategoryCode(String categoryCode) {
    this.categoryCode = categoryCode;
  }

  public boolean isDirty() {
    return this.isDirty;
  }

  public void setIsDirty(boolean isDirty) {
    this.isDirty = isDirty;
  }

  public void setCareDirty(boolean isDirty) {
    this.isDirty = isDirty;

    List factors = this.getFactors();
    Iterator factorsIt = factors.iterator();
    while (factorsIt.hasNext()) {
      CareFactorDB factorDB = (CareFactorDB) factorsIt.next();
      factorDB.setIsDirty(isDirty);
    }
  }

  public String toString() {
    StringBuilder output = new StringBuilder();

    output.append("Case ID: ").append(this.getCaseId());
    output.append("\nStage ID: ").append(this.getStageId());
    output.append("\nEvent ID: ").append(this.getEventId());
    output.append("\nCare Domain ID: ").append(this.getCareDomainId());
    output.append("\nCase Catergory ID: ").append(this.getCareCategoryId());
    output.append("\nDomain Code: ").append(this.getDomainCode());
    output.append("\nCategory Code: ").append(this.getCategoryCode());
    output.append("\nCategory Text: ").append(this.getCategoryText());
    output.append("\nOrder: ").append(this.getOrder());
    output.append("\nReason Code: ").append(this.getReasonCode());
    output.append("\nDate Last Update: ").append(this.getDateLastUpdate());
    output.append("\nIs Dirty: ").append(this.isDirty());
    output.append("\nFactors: ").append(this.getFactors());

    return output.toString();
  }

  public boolean isComplete(boolean checkReason, boolean checkFactors) {
    boolean isComplete = true;

    if (checkReason && !StringHelper.isValid(this.getReasonCode())) {
      isComplete = false;
    }

    List factors = this.getFactors();
    Iterator factorsIt = factors.iterator();
    while (factorsIt.hasNext() && isComplete && checkFactors) {
      CareFactorDB factorDB = (CareFactorDB) factorsIt.next();
      isComplete = factorDB.isComplete();
    }

    return isComplete;
  }

}