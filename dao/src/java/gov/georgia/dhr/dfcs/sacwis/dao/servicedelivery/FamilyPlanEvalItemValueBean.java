package gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

/** @todo add javadocs */

/**
 * Holds all data pertaining to a Family Plan Evaluation.
 *
 * @author Jason Rios, February 6th, 2003
 */
public class FamilyPlanEvalItemValueBean extends BaseValueBean {
  // instance variables
  private int caseId;
  private int stageId;
  private int familyPlanEventId;
  private int familyPlanItemId;
  private int familyPlanEvalEventId;
  private int familyPlanEvalItemId;
  private Date familyPlanEvalItemDateLastUpdate;
  private String evaluation;
  private Date dateApproved;

  /** Constructor */
  public FamilyPlanEvalItemValueBean() {
    caseId = 0;
    stageId = 0;
    familyPlanEventId = 0;
    familyPlanItemId = 0;
    familyPlanEvalEventId = 0;
    familyPlanEvalItemId = 0;
    familyPlanEvalItemDateLastUpdate = null;
    evaluation = null;
    dateApproved = null;
  }

  public int getCaseId() {
    return caseId;
  }

  public Date getDateApproved() {
    return dateApproved;
  }

  public String getEvaluation() {
    return evaluation;
  }

  public int getFamilyPlanEvalEventId() {
    return familyPlanEvalEventId;
  }

  public Date getFamilyPlanEvalItemDateLastUpdate() {
    return familyPlanEvalItemDateLastUpdate;
  }

  public int getFamilyPlanEvalItemId() {
    return familyPlanEvalItemId;
  }

  public int getFamilyPlanItemId() {
    return familyPlanItemId;
  }

  public int getFamilyPlanEventId() {
    return familyPlanEventId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public void setDateApproved(Date dateApproved) {
    this.dateApproved = dateApproved;
  }

  public void setEvaluation(String evaluation) {
    this.evaluation = evaluation;
  }

  public void setFamilyPlanEvalEventId(int familyPlanEvalEventId) {
    this.familyPlanEvalEventId = familyPlanEvalEventId;
  }

  public void setFamilyPlanEvalItemDateLastUpdate(Date familyPlanEvalItemDateLastUpdate) {
    this.familyPlanEvalItemDateLastUpdate = familyPlanEvalItemDateLastUpdate;
  }

  public void setFamilyPlanEvalItemId(int familyPlanEvalItemId) {
    this.familyPlanEvalItemId = familyPlanEvalItemId;
  }

  public void setFamilyPlanEventId(int familyPlanEventId) {
    this.familyPlanEventId = familyPlanEventId;
  }

  public void setFamilyPlanItemId(int familyPlanItemId) {
    this.familyPlanItemId = familyPlanItemId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }
}
