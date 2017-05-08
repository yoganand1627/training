package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Event;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;

public class CareDB extends BaseValueBean {
  private String comment;
  private String action;
  private int caseId;
  private int stageId;
  private int eventId;
  private String caseName;
  private String eventStatus;
  private String lifeThreateningCode;
  private java.util.List domains;
  private String taskCode;
  private Event approvalEvent;
  private boolean isDirty;
  private Timestamp dateLastUpdate;
  private Date eventDateLastUpdate;
  private Timestamp dateEventOccurred;
  private Date dtCareComplete;
  private Timestamp dateLastUpdateInvDetail;
  private boolean investigationInd;

  /**
   * This gets a completely empty care, which should never be done. This constructor only exists to make CareDB Serializable.
   */
  public CareDB() {
  }

  public CareDB(ArrayList domains, ArrayList categories, ArrayList factors) {
    this.setAction(StringHelper.EMPTY_STRING);
    this.setComment(StringHelper.EMPTY_STRING);
    this.setLifeThreateningCode(StringHelper.EMPTY_STRING);
    initDomains(domains, categories, factors);
  }

  public CareDB(ResultSet results, List domains, List categories, List factors) {
    try {
      // Set the domains first because other fields depend on them.
      this.initDomains(domains, categories, factors);
      this.setComment(StringHelper.getNonNullString(results.getString(CareDao.DESC_LIFE_THREAT_COMMENT_COLUMN)));
      this.setAction(StringHelper.getNonNullString(results.getString(CareDao.DESC_LIFE_THREAT_ACTIONS_COLUMN)));
      this.setCaseId(results.getInt(CareDao.ID_CASE_COLUMN));
      this.setStageId(results.getInt(CareDao.ID_STAGE_COLUMN));
      this.setEventId(results.getInt(CareDao.ID_EVENT_COLUMN));
      this.setLifeThreateningCode(StringHelper.getNonNullString(
              results.getString(CareDao.CD_LIFE_THREAT_RESPONSE_COLUMN)));
      this.setDateLastUpdate(results.getTimestamp(CareDao.DATE_LAST_UPDATE_COLUMN));
      this.setEventDateLastUpdate(results.getTimestamp(CareDao.DATE_LAST_UPDATE_EVENT_COLUMN));
      this.setCaseName(results.getString(CareDao.NM_CASE_COLUMN));
      this.setEventStatus(results.getString(CareDao.CD_EVENT_STATUS_COLUMN));
      this.setDateEventOccurred(results.getTimestamp(CareDao.DATE_EVENT_OCCURRED_COLUMN));
      this.setDateLastUpdateInvDetail(results.getTimestamp(CareDao.DATE_LAST_UPDATE_INV_DETAIL));
      this.setDtCareComplete(results.getDate(CareDao.DATE_APS_INVST_CLT_ASSMT));
    }
    catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    }
  }

  private void initDomains(List domains, List categories, List factors) {
    // Add the factors to the category beans
    for (int x = 0; x < factors.size(); x++) {
      CareFactorDB factor = (CareFactorDB) factors.get(x);
      for (int j = 0; j < categories.size(); j++) {
        CareCategoryDB category = (CareCategoryDB) categories.get(j);
        if (factor.getCategoryCode().equals(category.getCategoryCode())) {
          category.addFactor(factor);
          break;
        }
      }
    }

    // Add categories to the domain beans
    for (int x = 0; x < categories.size(); x++) {
      CareCategoryDB category = (CareCategoryDB) categories.get(x);
      for (int j = 0; j < categories.size(); j++) {
        CareDomainDB domain = (CareDomainDB) domains.get(j);
        if (category.getDomainCode().equals(domain.getDomainCode())) {
          domain.addCategory(category);
          break;
        }
      }
    }
    this.setDomains(domains);
  }

  public Date getEventDateLastUpdate() {
    return eventDateLastUpdate;
  }

  public void setEventDateLastUpdate(Date eventDateLastUpdate) {
    this.eventDateLastUpdate = eventDateLastUpdate;
  }

  public Timestamp getDateLastUpdateInvDetail() {
    return dateLastUpdateInvDetail;
  }

  public void setDateLastUpdateInvDetail(Timestamp dateLastUpdateInvDetail) {
    this.dateLastUpdateInvDetail = dateLastUpdateInvDetail;
  }

  public Date getDtCareComplete() {
    return dtCareComplete;
  }

  public void setDtCareComplete(Date dtCareComplete) {
    this.dtCareComplete = dtCareComplete;
  }

  public Event getApprovalEvent() {
    return approvalEvent;
  }

  public void setApprovalEvent(Event approvalEvent) {
    this.approvalEvent = approvalEvent;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public java.sql.Timestamp getDateLastUpdate() {
    return dateLastUpdate;
  }

  public void setDateLastUpdate(java.sql.Timestamp dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  public Timestamp getDateEventOccurred() {
    return dateEventOccurred;
  }

  public void setDateEventOccurred(Timestamp dateEventOccurred) {
    this.dateEventOccurred = dateEventOccurred;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;

    List domains = this.getDomains();
    Iterator domainsIt = domains.iterator();
    while (domainsIt.hasNext()) {
      CareDomainDB domainDB = (CareDomainDB) domainsIt.next();
      domainDB.setCaseId(caseId);
    }
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
    List domains = this.getDomains();
    Iterator domainsIt = domains.iterator();
    while (domainsIt.hasNext()) {
      CareDomainDB domainDB = (CareDomainDB) domainsIt.next();
      domainDB.setStageId(stageId);
    }
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
    List domains = this.getDomains();
    Iterator domainsIt = domains.iterator();
    while (domainsIt.hasNext()) {
      CareDomainDB domainDB = (CareDomainDB) domainsIt.next();
      domainDB.setEventId(eventId);
    }
  }

  public String getLifeThreateningCode() {
    return lifeThreateningCode;
  }

  public void setLifeThreateningCode(String lifeThreateningCode) {
    this.lifeThreateningCode = lifeThreateningCode;
  }

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public String getEventStatus() {
    return eventStatus;
  }

  public void setEventStatus(String eventStatus) {
    this.eventStatus = eventStatus;
  }

  public java.util.List getDomains() {
    return domains;
  }

  public void setDomains(java.util.List domains) {
    this.domains = domains;
  }

  public boolean isDirty() {
    return this.isDirty;
  }

  public void setIsDirty(boolean isDirty) {
    this.isDirty = isDirty;
  }

  public void setCareDirty(boolean isDirty) {
    this.isDirty = isDirty;

    List domains = this.getDomains();
    Iterator domainsIt = domains.iterator();
    while (domainsIt.hasNext()) {
      CareDomainDB domainDB = (CareDomainDB) domainsIt.next();
      domainDB.setCareDirty(isDirty);
    }
  }

  public String getTaskCode() {
    return taskCode;
  }

  public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
  }

  public boolean isInvestigationInd() {
    return investigationInd;
  }

  public void setInvestigationInd(boolean investigationInd) {
    this.investigationInd = investigationInd;
  }

  public String toString() {
    StringBuffer output = new StringBuffer();

    output.append("Case ID: ").append(this.getCaseId());
    output.append("\nCase Name: ").append(this.getCaseName());
    output.append("\nStage ID: ").append(this.getStageId());
    output.append("\nEvent ID: ").append(this.getEventId());
    output.append("\nEvent Status: ").append(this.getEventStatus());
    output.append("\nDate Event Occurred: ").append(this.getDateEventOccurred());
    output.append("\nEvent ID: ").append(this.getEventId());
    output.append("\nLife Threatening Code: ").append(this.getLifeThreateningCode());
    output.append("\nComment: ").append(this.getComment());
    output.append("\nAction: ").append(this.getAction());
    output.append("\nDate Last Update: ").append(this.getDateLastUpdate());
    output.append("\nEvent Date Last Update: ").append(this.getEventDateLastUpdate());
    output.append("\nIs Dirty: ").append(this.isDirty());
    output.append("\nDomain: ").append(this.getDomains());
    output.append("\nDate Care Complete: ").append(this.getDtCareComplete());
    output.append("\nInv Conclusiont Date Last Update: ").append(this.getDateLastUpdateInvDetail());

    return output.toString();
  }

  /**
   * This code will blank out the Comments and Factors from the domains.  The blanking out of the Category Responses is
   * done within the domainDB set method.
   */
  public void blankOut() {
    List domains = this.getDomains();

    Iterator domainsIt = domains.iterator();
    while (domainsIt.hasNext()) {
      CareDomainDB domainDB = (CareDomainDB) domainsIt.next();

      // This value will only change if a category is answerd YES or is null.  Otherwise
      // all the questions are answered and comments should be enabled.
      // FIXME: The values assigned to this variable are never used
      boolean validComments = true;

      // If Allegation Focus is YES, factors are valid
      boolean validFactors = true;

      if (ArchitectureConstants.N.equals(domainDB.getAllegationFocusCode())) {
        // Allegation focus is NO, so set to false. The factors are valid only if a category reason is YES.
        validFactors = false;

        List categories = domainDB.getCategories();

        Iterator categoryIt = categories.iterator();
        while (categoryIt.hasNext()) {
          CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();

          // If the reason code is Yes, Comments are ok and break out of the loop
          if (ArchitectureConstants.Y.equals(categoryDB.getReasonCode())) {
            validComments = true;
            validFactors = true;
            break;
          }

          // If the reason code is null, invalidate Comments.  But we still need to
          // through to see if we find any YES's.
          if (!StringHelper.isValid(categoryDB.getReasonCode())) {
            validComments = false;
          }
        }
      }

//      // Blank out comments
//      if( !validComments )
//      {
//        domainDB.setComment( StringHelper.EMPTY_STRING );
//        domainDB.setIsDirty( true );
//      }
//
      // Blank of factors
      if (!validFactors) {
        List categories = domainDB.getCategories();

        Iterator categoryIt = categories.iterator();
        while (categoryIt.hasNext()) {
          CareCategoryDB categoryDB = (CareCategoryDB) categoryIt.next();

          List factors = categoryDB.getFactors();

          Iterator factorsIt = factors.iterator();
          while (factorsIt.hasNext()) {
            CareFactorDB factorDB = (CareFactorDB) factorsIt.next();

            if (!StringHelper.EMPTY_STRING.equals(factorDB.getFactorResponseCode())) {
              factorDB.setFactorResponseCode(StringHelper.EMPTY_STRING);
              factorDB.setIsDirty(true);
            }
          }
        }
      }
    }
  }

  public boolean isComplete() {
    boolean isComplete = true;

    if (StringHelper.isValid(this.getLifeThreateningCode())) {
      isComplete = false;
    }

    List domains = this.getDomains();

    Iterator domainsIt = domains.iterator();
    while (domainsIt.hasNext() && isComplete) {
      CareDomainDB domainDB = (CareDomainDB) domainsIt.next();
      isComplete = domainDB.isComplete();
    }
    return isComplete;
  }

  public List<String> isCompleteList() {
    List<String> incompleteList = new ArrayList<String>();

    if (!StringHelper.isValid(this.getLifeThreateningCode())) {
      incompleteList.add("Life or Health Threatening");
    }

    List domains = this.getDomains();

    Iterator domainsIt = domains.iterator();
    while (domainsIt.hasNext()) {
      CareDomainDB domainDB = (CareDomainDB) domainsIt.next();
      if (!domainDB.isComplete()) {
        incompleteList.add(domainDB.getDomainText());
      }
    }
    return incompleteList;
  }

  public CCMN01UI getEventStruct(String eventStatus, int userID, String userLogonID) {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();

    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 =
            new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();

    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_ASM);
    rowccmn01uig00.setSzCdTask(this.taskCode);
    rowccmn01uig00.setSzTxtEventDescr("CARE");
    rowccmn01uig00.setUlIdPerson(userID);
    rowccmn01uig00.setUlIdStage(this.getStageId());

    //rowccmn01uig00.setDtDtEventOccurred( DateHelper.getTodayCastorDate() );

    input.setSzUserId(userLogonID);

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    if (this.getEventId() > 0) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowccmn01uig00.setUlIdEvent(this.getEventId());
      rowccmn01uig00.setTsLastUpdate(this.getEventDateLastUpdate());
      if (this.getDateEventOccurred() != null) {
        Date javaDate = new Date(this.getDateEventOccurred().getTime());
        rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(javaDate));
      }
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    }

    rowccmn01uig00.setTsLastUpdate(this.eventDateLastUpdate);
    rowccmn01uig00.setSzCdEventStatus(eventStatus);

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    return ccmn01ui;
  }
}