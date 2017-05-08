package gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;

/**
 * Holds all data pertaining to a Family Plan. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   06/23/04  RIOSJA    SIR 19002 - We need to keep track of the stage Start Date
 *                       so that we can display an informational message if the
 *                       worker attemps to evaluate a family plan that was created
 *                       in a newer stage.
 *   07/01/04  RIOSJA    SIR 14974 - Added interpreterTranslatorIsNeeded property
 *                       which will be set to true if any principal in the family
 *                       plan has person characteristics of 'Limited English
 *                       Proficiency' or 'Hearing Impaired'.
 * </pre>
 * 
 * @author Jason Rios, February 6th, 2003
 */
public class FamilyPlanValueBean extends BaseValueBean {
  /**
   * 
   */
  private static final long serialVersionUID = 8492438943008820642L;

  // *** FPR Task Codes ***
  public static final String CD_TASK_FPR_FAM_PLAN = "7080";

  public static final String CD_TASK_FPR_FAM_PLAN_EVAL = "7300";

  public static final String CD_TASK_FPR_APPRV_FAM_PLAN = "7180";

  public static final String CD_TASK_FPR_VISITATION_PLAN_ENGLISH = "7250";

  public static final String CD_TASK_FPR_VISITATION_PLAN_SPANISH = "7260";

  public static final String LEGACY_CD_TASK_FPR_3_MONTH_EVAL = "7085";

  public static final String LEGACY_CD_TASK_FPR_6_MONTH_EVAL = "7090";

  public static final String LEGACY_CD_TASK_FPR_SPEC_MONTH_EVAL = "7095";

  public static final String LEGACY_CD_TASK_FPR_FAMILY_ASSMT = "7060";

  // *** FRE Task Codes ***
  public static final String CD_TASK_FRE_FAM_PLAN = "5600";

  public static final String CD_TASK_FRE_FAM_PLAN_EVAL = "7310";

  public static final String CD_TASK_FRE_APPRV_FAM_PLAN = "5820";

  public static final String CD_TASK_FRE_VISITATION_PLAN_ENGLISH = "5890";

  public static final String CD_TASK_FRE_VISITATION_PLAN_SPANISH = "5900";

  public static final String LEGACY_CD_TASK_FRE_3_MONTH_EVAL = "5610";

  public static final String LEGACY_CD_TASK_FRE_6_MONTH_EVAL = "5620";

  public static final String LEGACY_CD_TASK_FRE_SPEC_MONTH_EVAL = "5630";

  public static final String LEGACY_CD_TASK_FRE_FAMILY_ASSMT = "5590";

  // *** FSU Task Codes ***
  public static final String CD_TASK_FSU_FAM_PLAN = "4150";

  public static final String CD_TASK_FSU_FAM_PLAN_EVAL = "7320";

  public static final String CD_TASK_FSU_APPRV_FAM_PLAN = "4320";

  public static final String CD_TASK_FSU_VISITATION_PLAN_ENGLISH = "4390";

  public static final String CD_TASK_FSU_VISITATION_PLAN_SPANISH = "4400";

  public static final String LEGACY_CD_TASK_FSU_6_MONTH_EVAL = "4170";

  public static final String LEGACY_CD_TASK_FSU_SPEC_MONTH_EVAL = "4180";

  public static final String LEGACY_CD_TASK_FSU_FAMILY_ASSMT = "4140";

  // instance variables
  private int caseId = 0;

  private int stageId = 0;

  private int familyPlanId = 0;

  private Date familyPlanDateLastUpdate = null;

  private EventValueBean familyPlanEvent = new EventValueBean();

  private Collection familyPlanEvaluations = null;

  private String stageCode = null;

  private String stageTypeCode = null;

  private String stageName = null;

  private org.exolab.castor.types.Date dateStageStarted = null; /* RIOSJA, SIR 19002 */

  private String planTypeCode = null;

  private org.exolab.castor.types.Date datePlanCompleted = null;

  private org.exolab.castor.types.Date dateNextEvalDue = null;

  private org.exolab.castor.types.Date dateCurrentEvalCompleted = null;

  /* Added for R2 GA Shines */
  private org.exolab.castor.types.Date datePlanPrepared = null;

  private org.exolab.castor.types.Date dateInitialDueDate = null;

  private boolean indCourtOrdered = false;

  private boolean isUpdatedPlan = false;

  private boolean isCopiedPlan = false;

  private int riskAssessmentEventId;

  /* end R2 Shines */

  /* R2 GA Shines enhancement */
  private String cdOutcome = null;

  /* end R2 GA Shines enhancement */

  /* R2 GA Shines regarding data conversion issue */
  private boolean convertedOng;

  private int idStageForInitRiskAssmt; // id stage of which the initial risk assessment for ONG is completed, either
                                        // INV one or the first complete one in ONG
  private int idEventForInitRiskAssmt;

  private String cdStagePrior;
  private boolean newUsing = false;

  /* end R2 GA Shines regarding data conversion issue */

  private int familyAssessmentEventId = 0;

  private String reasonForCPSInvolvement = null;

  private boolean clientGaveComments = false;

  private String strengthsAndResources = null;

  private String explanationOfClientNonParticipation = null;

  private Collection familyPlanItemList = null;

  private Collection principalsForStage = null;

  private Collection principalsForEvent = null;

  private boolean isReadyForNextEvaluation = false;

  private boolean isApprovalMode = false;

  private boolean isApprovalModeForStageClosure = false;

  private boolean isSaveAndSubmit = false;

  private int primaryWorkerId = 0;

  private int userId = 0;

  private String userLoginId = null;

  private EventValueBean stageClosureEvent = null;

  private HashMap childrenInCaseInSubcareHashmap = null;

  private String permanencyGoalsComment = null;

  private boolean interpreterTranslatorIsNeeded = false; /* RIOSJA, SIR 14974 */

  /** Constructor */
  public FamilyPlanValueBean() {
  }

  /* RIOSJA, SIR 14974 */
  public boolean getInterpreterTranslatorIsNeeded() {
    return interpreterTranslatorIsNeeded;
  }

  public int getCaseId() {
    return caseId;
  }

  public boolean clientGaveComments() {
    return clientGaveComments;
  }

  public boolean isReadyForNextEvaluation() {
    return isReadyForNextEvaluation;
  }

  public boolean isApprovalMode() {
    return isApprovalMode;
  }

  public boolean isApprovalModeForStageClosure() {
    return isApprovalModeForStageClosure;
  }

  public boolean isSaveAndSubmit() {
    return isSaveAndSubmit;
  }

  public Date getFamilyPlanDateLastUpdate() {
    return familyPlanDateLastUpdate;
  }

  public org.exolab.castor.types.Date getDateNextEvalDue() {
    return dateNextEvalDue;
  }

  public org.exolab.castor.types.Date getDatePlanCompleted() {
    return datePlanCompleted;
  }

  public org.exolab.castor.types.Date getDateCurrentEvalCompleted() {
    return dateCurrentEvalCompleted;
  }

  public org.exolab.castor.types.Date getDatePlanPrepared() {
    return datePlanPrepared;
  }

  public org.exolab.castor.types.Date getDateInitialDueDate() {
    return dateInitialDueDate;
  }

  public boolean getIndCourtOrdered() {
    return indCourtOrdered;
  }

  public boolean isUpdatedPlan() {
    return isUpdatedPlan;
  }

  public String getExplanationOfClientNonParticipation() {
    return explanationOfClientNonParticipation;
  }

  public int getRiskAssessmentEventId() {
    return riskAssessmentEventId;
  }

  public int getFamilyAssessmentEventId() {
    return familyAssessmentEventId;
  }

  public Collection getFamilyPlanItemList() {
    return familyPlanItemList;
  }

  public String getStageCode() {
    return stageCode;
  }

  public String getStageTypeCode() {
    return stageTypeCode;
  }

  public String getStageName() {
    return stageName;
  }

  /* RIOSJA, SIR 19002 */
  public org.exolab.castor.types.Date getDateStageStarted() {
    return dateStageStarted;
  }

  public String getPlanTypeCode() {
    return planTypeCode;
  }

  public Collection getPrincipalsForStage() {
    return principalsForStage;
  }

  public Collection getPrincipalsForEvent() {
    return principalsForEvent;
  }

  public String getReasonForCPSInvolvement() {
    return reasonForCPSInvolvement;
  }

  public EventValueBean getFamilyPlanEvent() {
    return familyPlanEvent;
  }

  public Collection getFamilyPlanEvaluations() {
    return familyPlanEvaluations;
  }

  public int getFamilyPlanId() {
    return familyPlanId;
  }

  public int getStageId() {
    return stageId;
  }

  public String getStrengthsAndResources() {
    return strengthsAndResources;
  }

  public int getPrimaryWorkerId() {
    return primaryWorkerId;
  }

  public int getUserId() {
    return userId;
  }

  public String getUserLoginId() {
    return userLoginId;
  }

  public EventValueBean getStageClosureEvent() {
    return stageClosureEvent;
  }

  public HashMap getChildrenInCaseInSubcareHashmap() {
    return childrenInCaseInSubcareHashmap;
  }

  public String getPermanencyGoalsComment() {
    return permanencyGoalsComment;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public void setClientGaveComments(boolean clientGaveComments) {
    this.clientGaveComments = clientGaveComments;
  }

  public void setIsReadyForNextEvaluation(boolean isReadyForNextEvaluation) {
    this.isReadyForNextEvaluation = isReadyForNextEvaluation;
  }

  public void setIsApprovalMode(boolean isApprovalMode) {
    this.isApprovalMode = isApprovalMode;
  }

  public void setIsApprovalModeForStageClosure(boolean isApprovalModeForStageClosure) {
    this.isApprovalModeForStageClosure = isApprovalModeForStageClosure;
  }

  public void setIsSaveAndSubmit(boolean isSaveAndSubmit) {
    this.isSaveAndSubmit = isSaveAndSubmit;
  }

  public void setFamilyPlanDateLastUpdate(Date familyPlanDateLastUpdate) {
    this.familyPlanDateLastUpdate = familyPlanDateLastUpdate;
  }

  public void setDateNextEvalDue(org.exolab.castor.types.Date dateNextEvalDue) {
    this.dateNextEvalDue = dateNextEvalDue;
  }

  public void setDatePlanCompleted(org.exolab.castor.types.Date datePlanCompleted) {
    this.datePlanCompleted = datePlanCompleted;
  }

  public void setDateCurrentEvalCompleted(org.exolab.castor.types.Date dateCurrentEvalCompleted) {
    this.dateCurrentEvalCompleted = dateCurrentEvalCompleted;
  }

  public void setDatePlanPrepared(org.exolab.castor.types.Date datePlanPrepared) {
    this.datePlanPrepared = datePlanPrepared;
  }

  public void setDateInitialDueDate(org.exolab.castor.types.Date dateInitialDueDate) {
    this.dateInitialDueDate = dateInitialDueDate;
  }

  public void setIndCourtOrdered(boolean indCourtOrdered) {
    this.indCourtOrdered = indCourtOrdered;
  }

  public void setIsUpdatedPlan(boolean isUpdatedPlan) {
    this.isUpdatedPlan = isUpdatedPlan;
  }

  public void setExplanationOfClientNonParticipation(String explanationOfClientNonParticipation) {
    this.explanationOfClientNonParticipation = explanationOfClientNonParticipation;
  }

  public void setRiskAssessmentEventId(int riskAssessmentEventId) {
    this.riskAssessmentEventId = riskAssessmentEventId;
  }

  public void setFamilyAssessmentEventId(int familyAssessmentEventId) {
    this.familyAssessmentEventId = familyAssessmentEventId;
  }

  public void setFamilyPlanId(int familyPlanId) {
    this.familyPlanId = familyPlanId;
  }

  public void setFamilyPlanItemList(Collection familyPlanItemList) {
    this.familyPlanItemList = familyPlanItemList;
  }

  public void setStageCode(String stageCode) {
    this.stageCode = stageCode;
  }

  public void setStageTypeCode(String stageTypeCode) {
    this.stageTypeCode = stageTypeCode;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  /* RIOSJA, SIR 19002 */
  public void setDateStageStarted(org.exolab.castor.types.Date dateStageStarted) {
    this.dateStageStarted = dateStageStarted;
  }

  public void setPlanTypeCode(String planTypeCode) {
    this.planTypeCode = planTypeCode;
  }

  public void setPrincipalsForStage(Collection principalsForStage) {
    this.principalsForStage = principalsForStage;
  }

  public void setPrincipalsForEvent(Collection principalsForEvent) {
    this.principalsForEvent = principalsForEvent;
  }

  public void setReasonForCPSInvolvement(String reasonForCPSInvolvement) {
    this.reasonForCPSInvolvement = reasonForCPSInvolvement;
  }

  public void setFamilyPlanEvent(EventValueBean familyPlanEvent) {
    this.familyPlanEvent = familyPlanEvent;
  }

  public void setFamilyPlanEvaluations(Collection familyPlanEvaluations) {
    this.familyPlanEvaluations = familyPlanEvaluations;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public void setStrengthsAndResources(String strengthsAndResources) {
    this.strengthsAndResources = strengthsAndResources;
  }

  public void setPrimaryWorkerId(int primaryWorkerId) {
    this.primaryWorkerId = primaryWorkerId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setUserLoginId(String userLoginId) {
    this.userLoginId = userLoginId;
  }

  public void setStageClosureEvent(EventValueBean stageClosureEvent) {
    this.stageClosureEvent = stageClosureEvent;
  }

  public void setChildrenInCaseInSubcareHashmap(HashMap childrenInCaseInSubcareHashmap) {
    this.childrenInCaseInSubcareHashmap = childrenInCaseInSubcareHashmap;
  }

  public void setPermanencyGoalsComment(String permanencyGoalsComment) {
    this.permanencyGoalsComment = permanencyGoalsComment;
  }

  /* RIOSJA, SIR 14974 */
  public void setInterpreterTranslatorIsNeeded(boolean interpreterTranslatorIsNeeded) {
    this.interpreterTranslatorIsNeeded = interpreterTranslatorIsNeeded;
  }

  /**
   * Get a string representation of the variable names and values. @ return String
   */
  public String toString() {
    return ("\n" + "FamilyPlanValueBean \n" + "  caseId = " + caseId + "\n" + "  stageId = " + stageId + "\n"
            + "  familyPlanEvent = " + familyPlanEvent + "\n" + "  familyPlanEvaluations = " + familyPlanEvaluations
            + "\n" + "  familyPlanId = " + familyPlanId + "\n" + "  familyPlanDateLastUpdate = "
            + familyPlanDateLastUpdate + "\n" + "  stageCode = " + stageCode + "\n" + "  stageTypeCode = "
            + stageTypeCode + "\n" + "  stageName = " + stageName + "\n" + "  dateStageStarted = " + dateStageStarted
            + "\n" + /* RIOSJA, SIR 19002 */
            "  planTypeCode = " + planTypeCode + "\n" + "  datePlanCompleted = " + datePlanCompleted + "\n"
            + "  dateNextEvalDue = " + dateNextEvalDue + "\n" + "  dateCurrentEvalCompleted = "
            + dateCurrentEvalCompleted + "\n" + "  familyAssessmentEventId = " + familyAssessmentEventId + "\n"
            + "  reasonForCPSInvolvement = " + reasonForCPSInvolvement + "\n" + "  clientGaveComments = "
            + clientGaveComments + "\n" + "  strengthsAndResources = " + strengthsAndResources + "\n"
            + "  explanationOfClientNonParticipation = " + explanationOfClientNonParticipation + "\n"
            + "  familyPlanItemList = " + familyPlanItemList + "\n" + "  isReadyForNextEvaluation = "
            + isReadyForNextEvaluation + "\n" + "  principalsForEvent = " + principalsForEvent + "\n"
            + "  principalsForStage = " + principalsForStage + "\n" + "  isApprovalMode = " + isApprovalMode + "\n"
            + "  isApprovalModeForStageClosure = " + isApprovalModeForStageClosure + "\n" + "  primaryWorkerId = "
            + primaryWorkerId + "\n" + "  isSaveAndSubmit = " + isSaveAndSubmit + "\n" + "  userId = " + userId + "\n"
            + "  userLoginId = " + userLoginId + "\n" + "  stageClosureEvent = " + stageClosureEvent + "\n"
            + "  childrenInCaseInSubcareHashmap = " + childrenInCaseInSubcareHashmap + "\n"
            + "  permanencyGoalsComment = " + permanencyGoalsComment + "\n" + "  interpreterTranslatorIsNeeded = "
            + interpreterTranslatorIsNeeded + "\n" + /* RIOSJA, SIR 14974 */
    "end FamilyPlanValueBean \n");
  }

  public String getCdOutcome() {
    return cdOutcome;
  }

  public void setCdOutcome(String cdOutcome) {
    this.cdOutcome = cdOutcome;
  }

  public boolean isCopiedPlan() {
    return isCopiedPlan;
  }

  public void setCopiedPlan(boolean isCopiedPlan) {
    this.isCopiedPlan = isCopiedPlan;
  }

  public String getCdStagePrior() {
    return cdStagePrior;
  }

  public void setCdStagePrior(String cdStagePrior) {
    this.cdStagePrior = cdStagePrior;
  }

  public boolean isConvertedOng() {
    return convertedOng;
  }

  public void setConvertedOng(boolean convertedOng) {
    this.convertedOng = convertedOng;
  }

  public int getIdStageForInitRiskAssmt() {
    return idStageForInitRiskAssmt;
  }

  public void setIdStageForInitRiskAssmt(int idStageForInitRiskAssmt) {
    this.idStageForInitRiskAssmt = idStageForInitRiskAssmt;
  }

  public int getIdEventForInitRiskAssmt() {
    return idEventForInitRiskAssmt;
  }

  public void setIdEventForInitRiskAssmt(int idEventForInitRiskAssmt) {
    this.idEventForInitRiskAssmt = idEventForInitRiskAssmt;
  }

  public boolean isNewUsing() {
    return newUsing;
  }

  public void setNewUsing(boolean newUsing) {
    this.newUsing = newUsing;
  }

}
