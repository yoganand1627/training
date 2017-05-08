package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

/**
 * Holds all data for a single Risk Assessment factor.
 * 
 * @author Jason Rios, October 10, 2002
 */
public class RiskFactorValueBean extends BaseValueBean {
  private int caseId;

  private int stageId;

  private int eventId;

  private int areaId;

  private String areaCode;

  private String areaText;

  private String areaScaleOfConcern;

  private String areaSortOrderIndex;

  private Date areaDateLastUpdate;

  private int categoryId;

  private String categoryCode;

  private String categoryText;

  private String categoryScaleOfConcern;

  private String categorySortOrderIndex;

  private Date categoryDateLastUpdate;

  private int factorId;

  private String factorCode;

  private String factorText;
  
  private String areaConcernText;

  private String factorResponse;

  private String factorSortOrderIndex;

  private String factorComment;

  private String childFragilityProtect;

  private String childVulnerability;

  private Date factorDateLastUpdate;

  private String factorJustificationOfFindings;

  private String categoryJustificationOfFindings;

  public static final int RISK_ASSESSMENT_DATA = 1;

  public static final int PAGE_CREATION_DATA_ONLY = 2;

  private static final String TRACE_TAG = "RiskFactorBean";

  /** Null Constructor */
  public RiskFactorValueBean() {
    caseId = 0;
    stageId = 0;
    eventId = 0;
    areaId = 0;
    areaCode = null;
    areaText = null;
    areaScaleOfConcern = null;
    areaSortOrderIndex = null;
    areaDateLastUpdate = null;
    categoryId = 0;
    categoryCode = null;
    categoryText = null;
    categoryScaleOfConcern = null;
    categorySortOrderIndex = null;
    categoryDateLastUpdate = null;
    factorId = 0;
    factorCode = null;
    factorText = null;
    areaConcernText = null;
    factorResponse = null;
    factorSortOrderIndex = null;
    factorComment = null;
    factorDateLastUpdate = null;
    factorJustificationOfFindings = null;
    categoryJustificationOfFindings = null;
  }

  /**
   * Constructor that builds the bean from a ResultSet object.
   * 
   * @param usage
   *          Indicates whether the RiskFactorValueBean will contain risk assessment details or just the data to build
   *          the RiskAssmt.jsp.
   * @param results
   *          The ResultSet object.
   * @throws DaoException
   */
  public RiskFactorValueBean(int usage, ResultSet results) throws DaoException {
    try {
      GrndsTrace.enterScope(TRACE_TAG + " constructor");

      // Set the following bean properties to the corresponding values retrieved
      // from the database. (None of these values will be null.)
      this.setAreaCode(results.getString(RiskAssmtDAO.AREA_CODE_COLUMN));
      this.setAreaText(results.getString(RiskAssmtDAO.AREA_TEXT_COLUMN));
      this.setAreaSortOrderIndex(results.getString(RiskAssmtDAO.AREA_SORT_ORDER_INDEX_COLUMN));
      this.setCategoryCode(results.getString(RiskAssmtDAO.CATEGORY_CODE_COLUMN));
      this.setCategoryText(results.getString(RiskAssmtDAO.CATEGORY_TEXT_COLUMN));
      this.setCategorySortOrderIndex(results.getString(RiskAssmtDAO.CATEGORY_SORT_ORDER_INDEX_COLUMN));
      this.setFactorCode(results.getString(RiskAssmtDAO.FACTOR_CODE_COLUMN));
      this.setFactorText(results.getString(RiskAssmtDAO.FACTOR_TEXT_COLUMN));
      this.setAreaConcernText(results.getString(RiskAssmtDAO.AREA_CONCERN_TEXT_COLUMN));
      this.setFactorSortOrderIndex(results.getString(RiskAssmtDAO.FACTOR_SORT_ORDER_INDEX_COLUMN));

      // The following database columns will exist in the RecordSet only if this
      // bean is being used to hold the details for an existing Risk Assessment.
      // If this bean is being used only to hold the data needed to create the
      // Risk Assessment page, the columns will not exist in the RecordSet.
      if (usage == this.RISK_ASSESSMENT_DATA) {
        this.setCaseId(results.getInt(RiskAssmtDAO.CASE_ID_COLUMN));
        this.setStageId(results.getInt(RiskAssmtDAO.STAGE_ID_COLUMN));
        this.setEventId(results.getInt(RiskAssmtDAO.EVENT_ID_COLUMN));

        if (results.getInt(RiskAssmtDAO.AREA_ID_COLUMN) > 0) {
          this.setAreaId(results.getInt(RiskAssmtDAO.AREA_ID_COLUMN));
        }
        if (results.getString(RiskAssmtDAO.AREA_SCALE_OF_CONCERN_COLUMN) != null) {
          this.setAreaScaleOfConcern(results.getString(RiskAssmtDAO.AREA_SCALE_OF_CONCERN_COLUMN));
        }
        if (results.getTimestamp(RiskAssmtDAO.AREA_DATE_LAST_UPDATE_COLUMN) != null) {
          this.setAreaDateLastUpdate(results.getTimestamp(RiskAssmtDAO.AREA_DATE_LAST_UPDATE_COLUMN));
        }
        if (results.getInt(RiskAssmtDAO.CATEGORY_ID_COLUMN) > 0) {
          this.setCategoryId(results.getInt(RiskAssmtDAO.CATEGORY_ID_COLUMN));
        }
        if (results.getString(RiskAssmtDAO.CATEGORY_SCALE_OF_CONCERN_COLUMN) != null) {
          this.setCategoryScaleOfConcern(results.getString(RiskAssmtDAO.CATEGORY_SCALE_OF_CONCERN_COLUMN));
        }
        if (results.getTimestamp(RiskAssmtDAO.CATEGORY_DATE_LAST_UPDATE_COLUMN) != null) {
          this.setCategoryDateLastUpdate(results.getTimestamp(RiskAssmtDAO.CATEGORY_DATE_LAST_UPDATE_COLUMN));
        }
        if (results.getInt(RiskAssmtDAO.FACTOR_ID_COLUMN) > 0) {
          this.setFactorId(results.getInt(RiskAssmtDAO.FACTOR_ID_COLUMN));
        }
        if (results.getString(RiskAssmtDAO.FACTOR_RESPONSE_COLUMN) != null) {
          this.setFactorResponse(results.getString(RiskAssmtDAO.FACTOR_RESPONSE_COLUMN));
        }
        if (results.getString(RiskAssmtDAO.FACTOR_COMMENT_COLUMN) != null) {
          this.setFactorComment(results.getString(RiskAssmtDAO.FACTOR_COMMENT_COLUMN));
        }
        if (results.getTimestamp(RiskAssmtDAO.FACTOR_DATE_LAST_UPDATE_COLUMN) != null) {
          this.setFactorDateLastUpdate(results.getTimestamp(RiskAssmtDAO.FACTOR_DATE_LAST_UPDATE_COLUMN));
        }
        if (results.getString(RiskAssmtDAO.AREA_TXT_RISK_AREA_JUSTIFICATION_COLUMN) != null) {
          this
              .setCategoryJustificationOfFindings(results
                                                         .getString(RiskAssmtDAO.AREA_TXT_RISK_AREA_JUSTIFICATION_COLUMN));
        }

        if (results.getString(RiskAssmtDAO.CATEGORY_TXT_RISK_CATEG_JUSTIFICATION) != null) {
          this
              .setCategoryJustificationOfFindings(results.getString(RiskAssmtDAO.CATEGORY_TXT_RISK_CATEG_JUSTIFICATION));
        }

      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to RiskFactorBean.");
      throw new DaoException("Exception translating ResultSet to RiskFactorBean", e, 7);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Retrieves the Case Id
   * 
   * @return Case Id
   */
  public int getCaseId() {
    return caseId;
  }

  /**
   * Retrieves the Stage Id
   * 
   * @return Stage Id
   */
  public int getStageId() {
    return stageId;
  }

  /**
   * Retrieves the Event Id
   * 
   * @return Event Id
   */
  public int getEventId() {
    return eventId;
  }

  /**
   * Retrieves the Area Id
   * 
   * @return Area Id
   */
  public int getAreaId() {
    return areaId;
  }

  /**
   * Retrieves the Code for this Area of Concern
   * 
   * @return Area of Concern Code
   */
  public String getAreaCode() {
    return areaCode;
  }

  /**
   * Retrieves the Date that this Area of Concern was last updated
   * 
   * @return Area of Concern Date Last Update
   */
  public Date getAreaDateLastUpdate() {
    return areaDateLastUpdate;
  }

  /**
   * Retrieves the Scale of Concern for this Area of Concern
   * 
   * @return Area of Concern Scale of Concern
   */
  public String getAreaScaleOfConcern() {
    return areaScaleOfConcern;
  }

  /**
   * Retrieves the Sort Order Index for this Area of Concern
   * 
   * @return Area of Concern Sort Order Index
   */
  public String getAreaSortOrderIndex() {
    return areaSortOrderIndex;
  }

  /**
   * Retrieves the Text for this Area of Concern
   * 
   * @return Area of Concern Text
   */
  public String getAreaText() {
    return areaText;
  }

  /**
   * Retrieves the Category Id
   * 
   * @return Category Id
   */
  public int getCategoryId() {
    return categoryId;
  }

  /**
   * Retrieves the Code for this Area of Concern Category
   * 
   * @return Area of Concern Category Code
   */
  public String getCategoryCode() {
    return categoryCode;
  }

  /**
   * Retrieves the Date this Area of Concern Category was last updated
   * 
   * @return Area of Concern Category Date Last Update
   */
  public Date getCategoryDateLastUpdate() {
    return categoryDateLastUpdate;
  }

  /**
   * Retrieves the Scale of Concern this Area of Concern Category
   * 
   * @return Area of Concern Category Scale Of Concern
   */
  public String getCategoryScaleOfConcern() {
    return categoryScaleOfConcern;
  }

  /**
   * Retrieves the Sort Order Index for this Area of Concern Category
   * 
   * @return Area of Concern Category Sort Order Index
   */
  public String getCategorySortOrderIndex() {
    return categorySortOrderIndex;
  }

  /**
   * Retrieves the Text for this Area of Concern Category
   * 
   * @return Area of Concern Category Text
   */
  public String getCategoryText() {
    return categoryText;
  }

  /**
   * Retrieves the Factor Id
   * 
   * @return Factor Id
   */
  public int getFactorId() {
    return factorId;
  }

  /**
   * Retrieves the Code for this Area of Concern Factor
   * 
   * @return Area of Concern Factor Code
   */
  public String getFactorCode() {
    return factorCode;
  }

  /**
   * Retrieves the Date this Area of Concern Factor was last updated
   * 
   * @return Area of Concern Factor Date Last Update
   */
  public Date getFactorDateLastUpdate() {
    return factorDateLastUpdate;
  }

  /**
   * Retrieves the Comment for this Area of Concern Factor
   * 
   * @return Area of Concern Factor Comment
   */
  public String getFactorComment() {
    return factorComment;
  }

  /**
   * Retrieves the Response for this Area of Concern Factor
   * 
   * @return Area of Concern Factor Response
   */
  public String getFactorResponse() {
    return factorResponse;
  }

  /**
   * Retrieves the Sort Order Index for this Area of Concern Factor
   * 
   * @return Area of Concern Factor Sort Order Index
   */
  public String getFactorSortOrderIndex() {
    return factorSortOrderIndex;
  }

  /**
   * Retrieves the Text for this Area of Concern Factor
   * 
   * @return Area of Concern Factor Text
   */
  public String getFactorText() {
    return factorText;
  }

  /**
   * Retrieves the Text for this Area of Concern 
   * 
   * @return Area of Concern Text
   */
  public String getAreaConcernText() {
    return areaConcernText;
  } 
  /**
   * Retrieves the Text for justicifation of findings
   * 
   * @return Area of Concern Factor Text
   */
  public String getFactorJustificationOfFindings() {
    return factorJustificationOfFindings;
  }

  /**
   * Retrieves Category Justification of findings
   * 
   * @param Category
   *          Justification of findings
   */

  public String getCategoryJustificationOfFindings() {
    return categoryJustificationOfFindings;
  }

  /**
   * Retrieves child Vulnerability Protection in Assessment of Family Strengths
   * 
   * @param child
   *          Vulnerability Protection
   */
  // public String getChildVulnerability() {
  // return childVulnerability;
  // }
  /**
   * Sets the Case Id
   * 
   * @param Case
   *          Id
   */
  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  /**
   * Sets the Stage Id
   * 
   * @param Stage
   *          Id
   */
  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  /**
   * Sets the Event Id
   * 
   * @param Event
   *          Id
   */
  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  /**
   * Sets the Area Id
   * 
   * @param Area
   *          Id
   */
  public void setAreaId(int areaId) {
    this.areaId = areaId;
  }

  /**
   * Sets the Code for this Area of Concern
   * 
   * @param Area
   *          of Concern Code
   */
  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  /**
   * Sets the Date this Area of Concern was last updated
   * 
   * @param Area
   *          of Concern Date Last Update
   */
  public void setAreaDateLastUpdate(Date areaDateLastUpdate) {
    this.areaDateLastUpdate = areaDateLastUpdate;
  }

  /**
   * Sets the Scale of Concern for this Area of Concern
   * 
   * @param Area
   *          of Concern Scale of Concern
   */
  public void setAreaScaleOfConcern(String areaScaleOfConcern) {
    this.areaScaleOfConcern = areaScaleOfConcern;
  }

  /**
   * Sets the Sort Order Index for this Area of Concern
   * 
   * @param Area
   *          of Concern Sort Order Index
   */
  public void setAreaSortOrderIndex(String areaSortOrderIndex) {
    this.areaSortOrderIndex = areaSortOrderIndex;
  }

  /**
   * Sets the Text for this Area of Concern
   * 
   * @param Area
   *          of Concern Text
   */
  public void setAreaText(String areaText) {
    this.areaText = areaText;
  }

  /**
   * Sets the Category Id
   * 
   * @param Category
   *          Id
   */
  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  /**
   * Sets the Code for this Area of Concern Category
   * 
   * @param Area
   *          of Concern Category Code
   */
  public void setCategoryCode(String categoryCode) {
    this.categoryCode = categoryCode;
  }

  /**
   * Sets the Date this Area of Concern Category was last updated
   * 
   * @param Area
   *          of Concern Category Date Last Update
   */
  public void setCategoryDateLastUpdate(Date categoryDateLastUpdate) {
    this.categoryDateLastUpdate = categoryDateLastUpdate;
  }

  /**
   * Sets the Scale of Concern for this Area of Concern Category
   * 
   * @param Area
   *          of Concern Category Scale of Concern
   */
  public void setCategoryScaleOfConcern(String categoryScaleOfConcern) {
    this.categoryScaleOfConcern = categoryScaleOfConcern;
  }

  /**
   * Sets the Sort Order Index for this Area of Concern Category
   * 
   * @param Area
   *          of Concern Category Sort Order Index
   */
  public void setCategorySortOrderIndex(String categorySortOrderIndex) {
    this.categorySortOrderIndex = categorySortOrderIndex;
  }

  /**
   * Sets the Text for this Area of Concern Category
   * 
   * @param Area
   *          of Concern Category Text
   */
  public void setCategoryText(String categoryText) {
    this.categoryText = categoryText;
  }

  /**
   * Sets the Factor Id
   * 
   * @param Factor
   *          Id
   */
  public void setFactorId(int factorId) {
    this.factorId = factorId;
  }

  /**
   * Sets the Code for this Area of Concern Factor
   * 
   * @param Area
   *          of Concern Factor Code
   */
  public void setFactorCode(String factorCode) {
    this.factorCode = factorCode;
  }

  /**
   * Sets the Date this Area of Concern Factor was last updated
   * 
   * @param Area
   *          of Concern Factor Date Last Update
   */
  public void setFactorDateLastUpdate(Date factorDateLastUpdate) {
    this.factorDateLastUpdate = factorDateLastUpdate;
  }

  /**
   * Sets the Comment for this Area of Concern Factor
   * 
   * @param Area
   *          of Concern Factor Comment
   */
  public void setFactorComment(String factorComment) {
    this.factorComment = factorComment;
  }

  /**
   * Sets the Response for this Area of Concern Factor
   * 
   * @param Area
   *          of Concern Factor Response
   */
  public void setFactorResponse(String factorResponse) {
    this.factorResponse = factorResponse;
  }

  /**
   * Sets the Sort Order Index for this Area of Concern Factor
   * 
   * @param Area
   *          of Concern Factor Sort Order Index
   */
  public void setFactorSortOrderIndex(String factorSortOrderIndex) {
    this.factorSortOrderIndex = factorSortOrderIndex;
  }

  /**
   * Sets the Text for this Area of Concern Factor
   * 
   * @param Area
   *          of Concern Factor Text
   */
  public void setFactorText(String factorText) {
    this.factorText = factorText;
  }

  /**
   * Sets the Text for this Area of Concern 
   * 
   * @param Area
   *          of Concern  Text
   */
  public void setAreaConcernText(String areaConcernText) {
    this.areaConcernText = areaConcernText;
  }
  
  
  /**
   * Sets the Text for justification of findings
   * 
   * @param Area
   *          of Concern Factor Text
   */
  public void setFactorJustificationOfFindings(String factorJustificationOfFindings) {
    this.factorJustificationOfFindings = factorJustificationOfFindings;
  }

  /**
   * Sets the Category Justification of findings
   * 
   * @param Category
   *          Justification of findings
   */
  public void setCategoryJustificationOfFindings(String categoryJustificationOfFindings) {
    this.categoryJustificationOfFindings = categoryJustificationOfFindings;
  }

  /**
   * Sets the child Vulnerability Protection in Assessment of Family Strengths
   * 
   * @param child
   *          Vulnerability Protection
   */
  // public void setChildVulnerability(String childVulnerability) {
  // this.childVulnerability = childVulnerability;
  // }
  /**
   * Returns a string of variable names and values
   * 
   * @return String
   */
  public String toString() {
    return ("\n" + "RiskFactorValueBean \n" + "  caseId = " + caseId + "\n" + "  stageId = " + stageId + "\n"
            + "  eventId = " + eventId + "\n" + "  areaId = " + areaId + "\n" + "  areaCode = " + areaCode + "\n"
            + "  areaText = " + areaText + "\n" + "  areaScaleOfConcern = " + areaScaleOfConcern + "\n"
            + "  areaSortOrderIndex = " + areaSortOrderIndex + "\n" + "  areaDateLastUpdate = " + areaDateLastUpdate
            + "\n" + "  categoryId = " + categoryId + "\n" + "  categoryCode = " + categoryCode + "\n"
            + "  categoryText = " + categoryText + "\n" + "  categoryScaleOfConcern = " + categoryScaleOfConcern + "\n"
            + "  categorySortOrderIndex = " + categorySortOrderIndex + "\n" + "  categoryDateLastUpdate = "
            + categoryDateLastUpdate + "\n" + "  factorId = " + factorId + "\n" + "  factorCode = " + factorCode + "\n"
            + "  factorText = " + factorText + "\n" + "  factorResponse = " + factorResponse + "\n"
            + "  factorSortOrderIndex = " + factorSortOrderIndex + "\n" + "  factorComment = " + factorComment + "\n"
            + "  factorDateLastUpdate = " + factorDateLastUpdate + "\n" + "  childFragilityProtect = "
            + childFragilityProtect + "\n" + "  childVulnerability = " + childVulnerability + "\n" + "end RiskFactorValueBean \n");
  }
}
