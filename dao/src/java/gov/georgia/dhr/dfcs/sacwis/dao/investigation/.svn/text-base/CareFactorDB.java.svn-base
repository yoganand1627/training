package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.ResultSet;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public class CareFactorDB extends BaseValueBean {
  private int caseId;
  private int stageId;
  private int eventId;
  private int personId;
  private String factorCode;
  private String factorResponseCode;
  private int careDomainId;
  private int careCategoryId;
  private String factorText;
  private int order;
  private String categoryCode;
  private String indicatorLow;
  private String indicatorMedium;
  private String indicatorHigh;
  private String indicatorNA;
  private String indicatorUTD;
  private boolean outcomeExists;
  private int careFactorId;
  private boolean isDirty;
  private java.sql.Timestamp dateLastUpdate;
  private Date dtCareFactor;
  private static final String TRUE = "true";
  private static final String FALSE = "false";
  private static final String ENABLED = "Y";

  public CareFactorDB(ResultSet results, int outComeId, boolean forExistingCare) {
    try {
      if (forExistingCare) {
        this.setCareFactorId(results.getInt(CareDao.ID_CARE_FACTOR_COLUMN));
        this.setCareCategoryId(results.getInt(CareDao.ID_CARE_CATEGORY_COLUMN));
        this.setCareDomainId(results.getInt(CareDao.ID_CARE_DOMAIN_COLUMN));
        this.setCaseId(results.getInt(CareDao.ID_CASE_COLUMN));
        this.setStageId(results.getInt(CareDao.ID_STAGE_COLUMN));
        this.setEventId(results.getInt(CareDao.ID_EVENT_COLUMN));
        this.setCategoryCode(results.getString(CareDao.CD_CATEGORY_COLUMN));
        this.setFactorResponseCode(StringHelper.getNonNullString(
                results.getString(CareDao.CD_CARE_FACTOR_RESPONSE_COLUMN)));
        this.setDateLastUpdate(results.getTimestamp(CareDao.DATE_LAST_UPDATE_COLUMN));
        this.setDtCareFactor(results.getTimestamp(CareDao.DATE_CARE_FACTOR));
        //If an outcome was retrieved set the outComeExists indicator to TRUE
        //String outCome =results.getString(CareDao.CD_APS_OUTCOME_RESULT);
        if (outComeId == this.getCareFactorId()) {
          this.setOutcomeExists(true);
        } else {
          this.setOutcomeExists(false);
        }

      } else {
        //Set these values to empty strings so that jsp doesn't have to worry about it
        this.setFactorResponseCode(StringHelper.EMPTY_STRING);
      }

      this.setCategoryCode(results.getString(CareDao.CD_CATEGORY_COLUMN));
      this.setFactorCode(results.getString(CareDao.CD_FACTOR_COLUMN));
      this.setFactorText(results.getString(CareDao.TXT_FACTOR_COLUMN));
      this.setOrder(results.getInt(CareDao.NBR_FACTOR_ORDER_COLUMN));
      this.setIsDirty(false);

      //If an outcome exists for this factor, all the indicators should be
      //disabled.  Otherwise use the results retrieved from the database.
      if (this.outcomeExists) {
        this.setHasLowIndicatorDisabled(TRUE);
        this.setHasHighIndicatorDisabled(TRUE);
        this.setHasMediumIndicatorDisabled(TRUE);
        this.setHasNAIndicatorDisabled(TRUE);
        this.setHasUTDIndicatorDisabled(TRUE);
      } else {
        String tempIndicator = results.getString(CareDao.IND_FACTOR_LOW_COLUMN);
        if (ENABLED.equals(tempIndicator)) {
          this.setHasLowIndicatorDisabled(FALSE);
        } else {
          this.setHasLowIndicatorDisabled(TRUE);
        }

        tempIndicator = results.getString(CareDao.IND_FACTOR_MED_COLUMN);
        if (ENABLED.equals(tempIndicator)) {
          this.setHasMediumIndicatorDisabled(FALSE);
        } else {
          this.setHasMediumIndicatorDisabled(TRUE);
        }

        tempIndicator = results.getString(CareDao.IND_FACTOR_HIGH_COLUMN);
        if (ENABLED.equals(tempIndicator)) {
          this.setHasHighIndicatorDisabled(FALSE);
        } else {
          this.setHasHighIndicatorDisabled(TRUE);
        }

        tempIndicator = results.getString(CareDao.IND_FACTOR_NA_COLUMN);
        if (ENABLED.equals(tempIndicator)) {
          this.setHasNAIndicatorDisabled(FALSE);
        } else {
          this.setHasNAIndicatorDisabled(TRUE);
        }

        tempIndicator = results.getString(CareDao.IND_FACTOR_UTD_COLUMN);
        if (ENABLED.equals(tempIndicator)) {
          this.setHasUTDIndicatorDisabled(FALSE);
        } else {
          this.setHasUTDIndicatorDisabled(TRUE);
        }
      }
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }

  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
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

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getFactorCode() {
    return factorCode;
  }

  public void setFactorCode(String factorCode) {
    this.factorCode = factorCode;
  }

  public String getFactorResponseCode() {
    return factorResponseCode;
  }

  public void setFactorResponseCode(String factorResponseCode) {
    this.factorResponseCode = factorResponseCode;
  }

  public int getCareDomainId() {
    return careDomainId;
  }

  public void setCareDomainId(int careDomainId) {
    this.careDomainId = careDomainId;
  }

  public int getCareCategoryId() {
    return careCategoryId;
  }

  public void setCareCategoryId(int careCategoryId) {
    this.careCategoryId = careCategoryId;
  }

  public java.sql.Timestamp getDateLastUpdate() {
    return dateLastUpdate;
  }

  public void setDateLastUpdate(java.sql.Timestamp dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  public String getFactorText() {
    return factorText;
  }

  public void setFactorText(String factorText) {
    this.factorText = factorText;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getCategoryCode() {
    return categoryCode;
  }

  public void setCategoryCode(String categoryCode) {
    this.categoryCode = categoryCode;
  }

  public String hasLowIndicatorDisabled() {
    return indicatorLow;
  }

  public void setHasLowIndicatorDisabled(String indicatorLow) {
    this.indicatorLow = indicatorLow;
  }

  public String hasMediumIndicatorDisabled() {
    return indicatorMedium;
  }

  public void setHasMediumIndicatorDisabled(String indicatorMedium) {
    this.indicatorMedium = indicatorMedium;
  }

  public String hasHighIndicatorDisabled() {
    return indicatorHigh;
  }

  public void setHasHighIndicatorDisabled(String indicatorHigh) {
    this.indicatorHigh = indicatorHigh;
  }

  public String hasNAIndicatorDisabled() {
    return indicatorNA;
  }

  public void setHasNAIndicatorDisabled(String indicatorNA) {
    this.indicatorNA = indicatorNA;
  }

  public String hasUTDIndicatorDisabled() {
    return indicatorUTD;
  }

  public void setHasUTDIndicatorDisabled(String indicatorUTD) {
    this.indicatorUTD = indicatorUTD;
  }

  public int getCareFactorId() {
    return careFactorId;
  }

  public void setCareFactorId(int careFactorId) {
    this.careFactorId = careFactorId;
  }

  public boolean outcomeExists() {
    return this.outcomeExists;
  }

  public void setOutcomeExists(boolean s) {
    this.outcomeExists = s;
  }

  public Date getDtCareFactor() {
    return dtCareFactor;
  }

  public void setDtCareFactor(Date dtCareFactor) {
    this.dtCareFactor = dtCareFactor;
  }

  public boolean isDirty() {
    return this.isDirty;
  }

  public void setIsDirty(boolean isDirty) {
    this.isDirty = isDirty;
  }

  public String toString() {
    StringBuffer output = new StringBuffer();
    output.append("Case ID: " + this.getCaseId());
    output.append("\nStage ID: " + this.getStageId());
    output.append("\nEvent ID: " + this.getEventId());
    output.append("\nPerson ID: " + this.getPersonId());
    output.append("\nCare Domain ID: " + this.getCareDomainId());
    output.append("\nCare Category ID: " + this.getCareCategoryId());
    output.append("\nCare Factor ID: " + this.getCareFactorId());
    output.append("\nCategory Code: " + this.getCategoryCode());
    output.append("\nFactor Code: " + this.getFactorCode());
    output.append("\nFactor Text: " + this.getFactorText());
    output.append("\nOrder: " + this.getOrder());
    output.append("\nFactor Response Code: " + this.getFactorResponseCode());
    output.append("\nDate Last Update: " + this.getDateLastUpdate());
    output.append("\nIs Dirty: " + this.isDirty());
    return output.toString();
  }

  public boolean isComplete() {
    return StringHelper.isValid(this.getFactorResponseCode());
  }

}