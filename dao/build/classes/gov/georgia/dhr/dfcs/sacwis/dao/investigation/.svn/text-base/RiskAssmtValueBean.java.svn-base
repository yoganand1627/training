package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

/**
 * Holds all data pertaining to Risk Assessment.
 * 
 * @author Jason Rios, October 10, 2002
 */
@SuppressWarnings("serial")
public class RiskAssmtValueBean extends BaseValueBean {

  // instance variables
  private int caseId;

  private int stageId;

  private int eventId;

  private String purpose;

  private String finding;

  private Date dateLastUpdate;

  private Date dateLastUpdateInvActions;

  private Date dateLastUpdateFmlyStr;

  private Date dateResponse;

  private String indResponse;

  private String tmResponse;

  private Collection factors;

  private String eventStatus;

  private Date eventDateLastUpdate;

  private Map areaCompletionStatus;

  private boolean isComplete;

  private boolean isPriorHistoryComplete;

  private boolean isInvActionsComplete;

  private boolean isAssessmentOfFmlyStrComplete;

  private Date dateOfReport;

  private Date dateOfClosure;

  private String findingHistoryReport;

  private String indChildHistoryReport;

  private String indParentsGuide;

  private Date dateParentsGuide;

  private String indParentsNotified;

  private Date dateParentsNotified;

  private String indHIPPAPolicyExp;

  private String indHIPPAPolicySigned;

  private Date dateHIPPASignedAndAck;

  private String commentsHIPPA;

  private String indChildFragilityProtection;

  private String indChildBehaviour;

  private String indChildVulnerability;

  private InvCnclsnEventValueBean investigationConclusionEvent;

  private String indKnowledgeSkills;

  private String indControl;

  private String indFunctioning;

  private String indEmotionalCare;

  private String indPhysicalCare;

  private String indTrend;

  private String indCurrentSeverity;

  private String indChronicity;

  private String indDangerousExposure;

  private String indStressors;

  private String indSocialClimate;

  private String indSocialViolence;

  private String indDeception;

  private String indAttitude;

  private String indCaregiverCapability;

  private String indQualityOfCare;

  private String indMaltreatmentPattern;

  private String indHomeEnv;

  private String indSocialEnv;

  private String indResponseToIntervention;

  private String commentsAssessmentOfFmlyStr;

  private boolean hasStructuredNarr;

  private String szCdTask;

  private String szUserLoginId;

  private int ulPersonId;

  private boolean isCreatedUsingIRAorIMPACT;

  private boolean isApprovalMode;

  private static final String TRACE_TAG = "RiskAssmtBean";

  public static final String RISK_ASSESSMENT_EVENT_DESC = "Risk Assessment";

  public static final String RISK_REASSESSMENT_EVENT_DESC = "Risk ReAssessment";

  public static final String RISK_ASSESSMENT_TASK_CODE = "2295";

  public static final String RISK_REASSESSMENT_TASK_CODE = "7385";

  public static final String INVESTIGATION_CONCLUSION_TASK_CODE = "2330";

  private List<RiskAssmtPriorHistoryValueBean> reports;
  
  private String cdCurrLvlRisk;

  /** Constructor. */
  public RiskAssmtValueBean() {
    caseId = 0;
    stageId = 0;
    eventId = 0;
    purpose = null;
    finding = null;
    dateLastUpdate = null;
    dateLastUpdateInvActions = null;
    dateLastUpdateFmlyStr = null;
    dateResponse = null;
    indResponse = null;
    tmResponse = null;
    eventDateLastUpdate = null;
    eventStatus = null;
    factors = null;
    areaCompletionStatus = null;
    isComplete = false;
    isPriorHistoryComplete = false;
    isInvActionsComplete = false;
    isAssessmentOfFmlyStrComplete = false;
    investigationConclusionEvent = null;
    hasStructuredNarr = false;
    szCdTask = null;
    szUserLoginId = null;
    ulPersonId = 0;
    isCreatedUsingIRAorIMPACT = false;
    isApprovalMode = false;
    dateOfReport = null;
    dateOfClosure = null;
    findingHistoryReport = null;
    indChildHistoryReport = null;
    indParentsGuide = null;
    dateParentsGuide = null;
    indParentsNotified = null;
    dateParentsNotified = null;
    indHIPPAPolicyExp = null;
    indHIPPAPolicySigned = null;
    dateHIPPASignedAndAck = null;
    indChildFragilityProtection = null;
    indChildBehaviour = null;
    indChildVulnerability = null;
    indKnowledgeSkills = null;
    indControl = null;
    indFunctioning = null;
    indEmotionalCare = null;
    indPhysicalCare = null;
    indTrend = null;
    indCurrentSeverity = null;
    indChronicity = null;
    indDangerousExposure = null;
    indStressors = null;
    indSocialClimate = null;
    indSocialViolence = null;
    indDeception = null;
    indAttitude = null;
    indCaregiverCapability = null;
    indQualityOfCare = null;
    indMaltreatmentPattern = null;
    indHomeEnv = null;
    indSocialEnv = null;
    indResponseToIntervention = null;
    commentsHIPPA = null;
    commentsAssessmentOfFmlyStr = null;
    reports = null;
    cdCurrLvlRisk = null;
  }

  /**
   * Constructor that build the bean from the Case Id, Stage Id and Event Id.
   * 
   * @param caseId
   *          The id of the case to which the risk assessment belongs.
   * @param stageId
   *          The id of the stage to which the risk assessment belongs.
   * @param eventId
   *          The risk assessment event id.
   */
  public RiskAssmtValueBean(int caseId, int stageId, int eventId) {
    this();
    this.setCaseId(caseId);
    this.setStageId(stageId);
    this.setEventId(eventId);
  }

  /**
   * Constructor that builds the bean from the ResultSet retrieved from the database.
   * 
   * @param results
   *          The ResultSet object.
   * @throws DaoException
   */
  public RiskAssmtValueBean(ResultSet results) throws DaoException {
    this();
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    try {
      this.setCaseId(results.getInt(RiskAssmtDAO.CASE_ID_COLUMN));
      this.setStageId(results.getInt(RiskAssmtDAO.STAGE_ID_COLUMN));
      this.setEventId(results.getInt(RiskAssmtDAO.EVENT_ID_COLUMN));

      // Set the following bean properties to the corresponding values retrieved
      // from the database only if the values from the database are not null.
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_PURPOSE_COLUMN) != null) {
        this.setPurpose(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_PURPOSE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FINDING_COLUMN) != null) {
        this.setFinding(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FINDING_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_IND_RESPONSE_COLUMN) != null) {
        this.setIndResponse(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_IND_RESPONSE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_CD_CURRENT_LVL_RISK_COLUMN) != null) {
        this.setCdCurrLvlRisk(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_CD_CURRENT_LVL_RISK_COLUMN));
      }
      if (results.getTimestamp(RiskAssmtDAO.RISK_ASSESSMENT_DATE_RESPONSE_COLUMN) != null) {
        Timestamp ts = results.getTimestamp(RiskAssmtDAO.RISK_ASSESSMENT_DATE_RESPONSE_COLUMN);
        this.setDateResponse(ts);
        this.setTmResponse(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_TIME_RESPONSE));
      }
      if (results.getTimestamp(RiskAssmtDAO.RISK_ASSESSMENT_DATE_LAST_UPDATE_COLUMN) != null) {
        this.setDateLastUpdate(results.getTimestamp(RiskAssmtDAO.RISK_ASSESSMENT_DATE_LAST_UPDATE_COLUMN));
      }
      if (results.getTimestamp(RiskAssmtDAO.EVENT_DATE_LAST_UPDATE_COLUMN) != null) {
        this.setEventDateLastUpdate(results.getTimestamp(RiskAssmtDAO.EVENT_DATE_LAST_UPDATE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.EVENT_STATUS_COLUMN) != null) {
        this.setEventStatus(results.getString(RiskAssmtDAO.EVENT_STATUS_COLUMN));
      }
      // if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_CLOSURE_COLUMN) != null) {
      // this.setDateOfClosure(results.getTimestamp(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_CLOSURE_COLUMN));
      // }
      // if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_REPORT_COLUMN) != null) {
      // this.setDateOfReport(results.getTimestamp(RiskAssmtDAO.RISK_HISTORY_REPORT_DATE_OF_REPORT_COLUMN));
      // }
      // if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_CHLD_DEATH_INJ_COLUMN) != null) {
      // this.setIndChildHistoryReport(results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_CHLD_DEATH_INJ_COLUMN));
      // }
      // if (results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_SUMMARY_COLUMN) != null) {
      // this.setFindingHistoryReport(results.getString(RiskAssmtDAO.RISK_HISTORY_REPORT_SUMMARY_COLUMN));
      // }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_PARENTSGUIDE_COLUMN) != null) {
        this.setIndParentsGuide(results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_PARENTSGUIDE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_DT_PARENTSGUIDE_COLUMN) != null) {
        this.setDateParentsGuide(results.getTimestamp(RiskAssmtDAO.RISK_INV_ACTIONS_DT_PARENTSGUIDE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_PARENTSINTERV_COLUMN) != null) {
        this.setIndParentsNotified(results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_PARENTSINTERV_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_DT_PARENTSINTERV_COLUMN) != null) {
        this.setDateParentsNotified(results.getTimestamp(RiskAssmtDAO.RISK_INV_ACTIONS_DT_PARENTSINTERV_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_HIPPAINFO_COLUMN) != null) {
        this.setIndHIPPAPolicyExp(results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_HIPPAINFO_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_HIPPASIGN_COLUMN) != null) {
        this.setIndHIPPAPolicySigned(results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_IND_RISK_IA_HIPPASIGN_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_DT_HIPPASIGN_COLUMN) != null) {
        this.setDateHIPPASignedAndAck(results.getTimestamp(RiskAssmtDAO.RISK_INV_ACTIONS_DT_HIPPASIGN_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_COMMENTS_COLUMN) != null) {
        this.setCommentsHIPPA(results.getString(RiskAssmtDAO.RISK_INV_ACTIONS_COMMENTS_COLUMN));
      }
      if (results.getTimestamp(RiskAssmtDAO.RISK_INV_ACTIONS_DT_LAST_UPDATE_COLUMN) != null) {
        this.setDateLastUpdateInvActions(results.getTimestamp(RiskAssmtDAO.RISK_INV_ACTIONS_DT_LAST_UPDATE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHILDPROCTN_COLUMN) != null) {
        this
            .setIndChildFragilityProtection(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHILDPROCTN_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHILDBHVR_COLUMN) != null) {
        this.setIndChildBehaviour(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHILDBHVR_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHILDVUL_COLUMN) != null) {
        this.setIndChildVulnerability(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHILDVUL_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_KNOWLEDGE_COLUMN) != null) {
        this.setIndKnowledgeSkills(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_KNOWLEDGE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CONTROL_COLUMN) != null) {
        this.setIndControl(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CONTROL_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_FUNCTNG_COLUMN) != null) {
        this.setIndFunctioning(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_FUNCTNG_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_PHYCARE_COLUMN) != null) {
        this.setIndPhysicalCare(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_PHYCARE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_EMOCARE_COLUMN) != null) {
        this.setIndEmotionalCare(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_EMOCARE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_TREND_COLUMN) != null) {
        this.setIndTrend(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_TREND_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CURSEVRTY_COLUMN) != null) {
        this.setIndCurrentSeverity(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CURSEVRTY_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHRONCTY_COLUMN) != null) {
        this.setIndChronicity(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_CHRONCTY_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_DANEXP_COLUMN) != null) {
        this.setIndDangerousExposure(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_DANEXP_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_STRESS_COLUMN) != null) {
        this.setIndStressors(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_STRESS_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SOCCLI_COLUMN) != null) {
        this.setIndSocialClimate(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SOCCLI_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SOCVIOL_COLUMN) != null) {
        this.setIndSocialViolence(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SOCVIOL_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_ATTITUDE_COLUMN) != null) {
        this.setIndAttitude(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_ATTITUDE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_DECEPTION_COLUMN) != null) {
        this.setIndDeception(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_DECEPTION_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_IND_CAREGIVCAP_COLUMN) != null) {
        this.setIndCaregiverCapability(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_IND_CAREGIVCAP_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_QUALOFCARE_COLUMN) != null) {
        this.setIndQualityOfCare(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_QUALOFCARE_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_MALPATRN_COLUMN) != null) {
        this.setIndMaltreatmentPattern(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_MALPATRN_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_HOMENV_COLUMN) != null) {
        this.setIndHomeEnv(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_HOMENV_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SOCENV_COLUMN) != null) {
        this.setIndSocialEnv(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SOCENV_COLUMN));
      }

      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_RESPINT_COLUMN) != null) {
        this.setIndResponseToIntervention(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_RESPINT_COLUMN));
      }
      if (results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SUMMARY_COLUMN) != null) {
        this.setCommentsAssessmentOfFmlyStr(results.getString(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_SUMMARY_COLUMN));
      }
      if (results.getTimestamp(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_DT_LAST_UPDATE_COLUMN) != null) {
        this
            .setDateLastUpdateFmlyStr(results.getTimestamp(RiskAssmtDAO.RISK_ASSESSMENT_FMLY_STR_DT_LAST_UPDATE_COLUMN));
      }

    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to RiskAssmtBean.");
      throw new DaoException("Exception translating ResultSet to RiskAssmtBean", e, 7);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Retrieves the Area Completion Status array for this Risk Assessment @ return Risk Assessment Area Completion Status
   * Array
   */
  public Map getAreaCompletionStatus() {
    return areaCompletionStatus;
  }

  /** Retrieves the Case Id for this Risk Assessment @ return Risk Assessment Case Id */
  public int getCaseId() {
    return caseId;
  }

  /** Retrieves the Date this Risk Assessment was last updated @ return Risk Assessment Date Last Update */
  public Date getDateLastUpdate() {
    return dateLastUpdate;
  }

  /** Retrieves the Date the Risk Assessment Event was last updated @ return Risk Assessment Event Date Last Update */
  public Date getEventDateLastUpdate() {
    return eventDateLastUpdate;
  }

  /** Retrieves the Event Id for this Risk Assessment @ return Risk Assessment Event Id */
  public int getEventId() {
    return eventId;
  }

  /** Retrieves the Status of the Risk Assessment Event @ return Risk Assessment Event Status */
  public String getEventStatus() {
    return eventStatus;
  }

  /** Retrieves the Task Code of the Risk Assessment Event @ return Risk Assessment Task Code */
  public String getSzCdTask() {
    return szCdTask;
  }

  /** Retrieves the Login Id of the current user @ return Current User Login Id */
  public String getSzUserLoginId() {
    return szUserLoginId;
  }

  /** Retrieves the Person Id of the current user @ return Current User Person Id */
  public int getUlPersonId() {
    return ulPersonId;
  }

  /** Retrieves the Factors for this Risk Assessment @ return Risk Assessment Factors */
  public Collection getFactors() {
    return factors;
  }

  /** Retrieves the Finding for this Risk Assessment @ return Risk Assessment Finding */
  public String getFinding() {
    return finding;
  }

  /**
   * Retrieves the Investigation Conclusion Event bean associated with this Risk Assessment @ return Investigation
   * Conclusion Event bean
   */
  public InvCnclsnEventValueBean getInvestigationConclusionEvent() {
    return investigationConclusionEvent;
  }

  /** Retrieves the Purpose for this Risk Assessment @ return Risk Assessment Purpose */
  public String getPurpose() {
    return purpose;
  }

  /** Retrieves the response date for this Risk Assessment @ return Risk Assessment response date */
  public Date getDateResponse() {
    return dateResponse;
  }

  /** Retrieves the response Time for this Risk Assessment @ return Risk Assessment response date */
  public String getTmResponse() {
    return tmResponse;
  }

  /** Retrieves the response date ind for this Risk Assessment @ return Risk Assessment response date ind */
  public String getIndResponse() {
    return indResponse;
  }

  /** Retrieves the Stage Id for this Risk Assessment @ return Risk Assessment Date Last Update */
  public int getStageId() {
    return stageId;
  }

  /** Retrieves the date of report for this Prior History Report/Screening @ return Risk Assessment date of report */
  public Date getDateOfReport() {
    return dateOfReport;
  }

  /** Retrieves the date of closure for this Prior History Report/Screening @ return Risk Assessment date of closure */
  public Date getDateOfClosure() {
    return dateOfClosure;
  }

  /**
   * Retrieves the Summary of Findings for this Prior History Report/Screening @ return Risk Assessment date of closure
   */
  public String getFindingHistoryReport() {
    return findingHistoryReport;
  }

  /**
   * Retrieves the Child/Death or Injury for this Prior History Report/Screening @ return Risk Assessment date of
   * closure
   */
  public String getIndChildHistoryReport() {
    return indChildHistoryReport;
  }

  /** Retrieves the Parents Guide Ind for this Investigation/Actions @ return Risk Assessment Parents Guide */

  public String getIndParentsGuide() {
    return indParentsGuide;
  }

  /** Retrieves the Parents Guide Date for this Investigation/Actions @ return Risk Assessment Parents Guide */
  public Date getDateParentsGuide() {
    return dateParentsGuide;
  }

  /** Retrieves the Parents Notified Ind for this Investigation/Actions @ return Risk Assessment Parents notified */
  public String getIndParentsNotified() {
    return indParentsNotified;
  }

  /** Retrieves the Parents Notified Date for this Investigation/Actions @ return Risk Assessment Parents notified */
  public Date getDateParentsNotified() {
    return dateParentsNotified;
  }

  /** Retrieves the HIPPA Policy Exp Ind for this Investigation/Actions @ return Risk Assessment HIPPA policy exp */
  public String getIndHIPPAPolicyExp() {
    return indHIPPAPolicyExp;
  }

  /** Retrieves the HIPPA Policy signed Ind for this Investigation/Actions @ return Risk Assessment HIPPA policy signed */
  public String getIndHIPPAPolicySigned() {
    return indHIPPAPolicySigned;
  }

  /**
   * Retrieves the HIPPA Signed and Acknowledge Date for this Investigation/Actions @ return Risk Assessment date HIPPA
   * policy signed
   */
  public Date getDateHIPPASignedAndAck() {
    return dateHIPPASignedAndAck;
  }

  /** Retrieves the HIPPA comments for this Investigation/Actions @ return Risk Assessment HIPPA comments */

  public String getCommentsHIPPA() {
    return commentsHIPPA;
  }

  public Date getDateLastUpdateInvActions() {
    return dateLastUpdateInvActions;
  }

  /**
   * Retrieves the childFragilityProtection for Assessment of family Strengths @ return Risk Assessment
   * childFragilityProtection
   */
  public String getIndChildFragilityProtection() {
    return indChildFragilityProtection;
  }

  /** Retrieves the childBehaviour for Assessment of family Strengths @ return Risk Assessment childBehaviour */
  public String getIndChildBehaviour() {
    return indChildBehaviour;
  }

  /** Retrieves the childVulnerability for Assessment of family Strengths @ return Risk Assessment childVulnerability */
  public String getIndchildVulnerability() {
    return indChildVulnerability;
  }

  /** Retrieves the KnowledgeSkills for Assessment of family Strengths @ return Risk Assessment KnowledgeSkills */
  public String getIndKnowledgeSkills() {
    return indKnowledgeSkills;
  }

  /** Retrieves the Control for Assessment of family Strengths @ return Risk Assessment Control */
  public String getIndControl() {
    return indControl;
  }

  /** Retrieves the Functioning for Assessment of family Strengths @ return Risk Assessment Functioning */
  public String getIndFunctioning() {
    return indFunctioning;
  }

  /** Retrieves the Emotional Care for Assessment of family Strengths @ return Risk Assessment Emotional Care */
  public String getIndEmotionalCare() {
    return indEmotionalCare;
  }

  /** Retrieves the Physical Care for Assessment of family Strengths @ return Risk Assessment Physical Care */
  public String getIndPhysicalCare() {
    return indPhysicalCare;
  }

  /** Retrieves the Trend for Assessment of family Strengths @ return Risk Assessment Trend */
  public String getIndTrend() {
    return indTrend;
  }

  /** Retrieves the Current Severity for Assessment of family Strengths @ return Risk Assessment Current Severity */
  public String getIndCurrentSeverity() {
    return indCurrentSeverity;
  }

  /** Retrieves the Chronicity for Assessment of family Strengths @ return Risk Assessment Chronicity */
  public String getIndChronicity() {
    return indChronicity;
  }

  /** Retrieves the Dangerous Exposure for Assessment of family Strengths @ return Risk Assessment Dangerous Exposure */
  public String getIndDangerousExposure() {
    return indDangerousExposure;
  }

  /** Retrieves the Stressors for Assessment of family Strengths @ return Risk Assessment Stressors */
  public String getIndStressors() {
    return indStressors;
  }

  /** Retrieves the SocialClimate for Assessment of family Strengths @ return Risk Assessment SocialClimate */
  public String getIndSocialClimate() {
    return indSocialClimate;
  }

  /** Retrieves the SocialViolence for Assessment of family Strengths @ return Risk Assessment SocialViolence */
  public String getIndSocialViolence() {
    return indSocialViolence;
  }

  /** Retrieves the Deception for Assessment of family Strengths @ return Risk Assessment Deception */
  public String getIndDeception() {
    return indDeception;
  }

  /** Retrieves the Attitude for Assessment of family Strengths @ return Risk Assessment Attitude */
  public String getIndAttitude() {
    return indAttitude;
  }

  /**
   * Retrieves the Caregiver Capability for Assessment of family Strengths @ return Risk Assessment Caregiver Capability
   */
  public String getIndCaregiverCapability() {
    return indCaregiverCapability;
  }

  /** Retrieves the Quality of care for Assessment of family Strengths @ return Risk Assessment Quality of care */
  public String getIndQualityOfCare() {
    return indQualityOfCare;
  }

  /**
   * Retrieves the Maltreatment Pattern for Assessment of family Strengths @ return Risk Assessment Maltreatment Pattern
   */
  public String getIndMaltreatmentPattern() {
    return indMaltreatmentPattern;
  }

  /** Retrieves the Home Environment for Assessment of family Strengths @ return Risk Assessment Home Environment */
  public String getIndHomeEnv() {
    return indHomeEnv;
  }

  /** Retrieves the social Environment for Assessment of family Strengths @ return Risk Assessment social Environment */
  public String getIndSocialEnv() {
    return indSocialEnv;
  }

  /**
   * Retrieves the Response To Interventionfor Assessment of family Strengths @ return Risk Assessment Response To
   * Intervention
   */
  public String getIndResponseToIntervention() {
    return indResponseToIntervention;
  }

  /** Retrieves the justification for Assessment of family Strengths @ return Risk Assessment justification of findings */

  public String getCommentsAssessmentOfFmlyStr() {
    return commentsAssessmentOfFmlyStr;
  }

  public Date getDateLastUpdateFmlyStr() {
    return dateLastUpdateFmlyStr;
  }

  public List<RiskAssmtPriorHistoryValueBean> getReports() {
    return reports;
  }

  /** Retrieves the "is complete" indicator for this Risk Assessment @ return Risk Assessment "is complete" indicator */

  public boolean isComplete() {
    return isComplete;
  }

  public boolean isPriorHistoryComplete() {
    return isPriorHistoryComplete;
  }

  public boolean isInvActionsComplete() {
    return isInvActionsComplete;
  }

  public boolean isAssessmentOfFmlyStrComplete() {
    return isAssessmentOfFmlyStrComplete;
  }

  /**
   * Retrieves the "has structured narrative" indicator for this Risk Assessment @ return Risk Assessment "has
   * structured narrative" indicator
   */
  public boolean hasStructuredNarr() {
    return hasStructuredNarr;
  }

  /**
   * Retrieves the "created using IRA or IMPACT" indicator for this Risk Assessment @ return Risk Assessment "created
   * using IRA or IMPACT" indicator
   */
  public boolean isCreatedUsingIRAorIMPACT() {
    return isCreatedUsingIRAorIMPACT;
  }

  /**
   * Retrieves the indicator to that indicates whether or not the Risk Assessment was accessed in approval mode--via an
   * Approval To-Do. @ return Risk Assessment "is approval mode" indicator
   */
  public boolean isApprovalMode() {
    return isApprovalMode;
  }

  /**
   * Sets the Area Completion Status array for this Risk Assessment
   * 
   * @param Risk
   *          Assessment Area Completion Status Array
   */
  public void setAreaCompletionStatus(Map areaCompletionStatus) {
    this.areaCompletionStatus = areaCompletionStatus;
  }

  /**
   * Sets the Case Id for this Risk Assessment
   * 
   * @param Risk
   *          Assessment Case Id
   */
  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  /**
   * Sets the "is complete" indicator for this Risk Assessment
   * 
   * @param Risk
   *          Assessment "is complete" indicator
   */
  public void setComplete(boolean isComplete) {
    this.isComplete = isComplete;
  }

  /**
   * Sets the "is prior history complete" indicator for this Risk Assessment
   * 
   * @param Risk
   *          Assessment "is prior history complete" indicator
   */
  public void setPriorHistoryComplete(boolean isPriorHistoryComplete) {
    this.isPriorHistoryComplete = isPriorHistoryComplete;
  }

  public void setInvActionsComplete(boolean isInvActionsComplete) {
    this.isInvActionsComplete = isInvActionsComplete;

  }

  public void setAssessmentOfFmlyStrComplete(boolean isAssessmentOfFmlyStrComplete) {
    this.isAssessmentOfFmlyStrComplete = isAssessmentOfFmlyStrComplete;

  }

  /**
   * Sets the "has structured narrative" indicator for this Risk Assessment
   * 
   * @param Risk
   *          Assessment "has structured narrative" indicator
   */
  public void setHasStructuredNarr(boolean hasStructuredNarr) {
    this.hasStructuredNarr = hasStructuredNarr;
  }

  /**
   * Sets the Date this Risk Assessment was last updated
   * 
   * @param Risk
   *          Assessment Date Last Update
   */
  public void setDateLastUpdate(Date dateLastUpdate) {
    this.dateLastUpdate = dateLastUpdate;
  }

  /**
   * Sets the Date the Risk Assessment Event was last updated
   * 
   * @param Risk
   *          Assessment Date Last Update
   */
  public void setEventDateLastUpdate(Date eventDateLastUpdate) {
    this.eventDateLastUpdate = eventDateLastUpdate;
  }

  /**
   * Sets the Event Id for this Risk Assessment
   * 
   * @param Risk
   *          Assessment Event Id
   */
  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  /**
   * Sets the Status of the Risk Assessment Event
   * 
   * @param Risk
   *          Assessment Event Status
   */
  public void setEventStatus(String eventStatus) {
    this.eventStatus = eventStatus;
  }

  /**
   * Sets the Task Code of the Risk Assessment Event
   * 
   * @param Risk
   *          Assessment Task Code
   */
  public void setSzCdTask(String szCdTask) {
    this.szCdTask = szCdTask;
  }

  /**
   * Sets the Login Id of the current user
   * 
   * @param Current
   *          User Login Id
   */
  public void setSzUserLoginId(String szUserLoginId) {
    this.szUserLoginId = szUserLoginId;
  }

  /**
   * Sets the Person Id of the current user
   * 
   * @param Current
   *          User Person Id
   */
  public void setUlPersonId(int ulPersonId) {
    this.ulPersonId = ulPersonId;
  }

  /**
   * Sets the Factors array for this Risk Assessment
   * 
   * @param Risk
   *          Assessment Factors
   */
  public void setFactors(Collection factors) {
    this.factors = factors;
  }

  /**
   * Sets the Finding for this Risk Assessment
   * 
   * @param Risk
   *          Assessment Finding
   */
  public void setFinding(String finding) {
    this.finding = finding;
  }

  /**
   * Sets the Investigation Conclusion Event bean associated with this Risk Assessment
   * 
   * @param Investigation
   *          Conclusion Event bean
   */
  public void setInvestigationConclusionEvent(InvCnclsnEventValueBean investigationConclusionEvent) {
    this.investigationConclusionEvent = investigationConclusionEvent;
  }

  /**
   * Sets the Purpose for this Risk Assessment
   * 
   * @param Risk
   *          Assessment Purpose
   */
  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  /** Sets the Response date for this Risk Assessment @ return Risk Assessment response date */
  public void setDateResponse(Date dateResponse) {
    this.dateResponse = dateResponse;
  }

  /** Sets the Response time for this Risk Assessment @ return Risk Assessment response date */
  public void setTmResponse(String tmResponse) {
    this.tmResponse = tmResponse;
  }

  /** Retrieves the response time ind for this Risk Assessment @ return Risk Assessment response date ind */
  public void setIndResponse(String indResponse) {
    this.indResponse = indResponse;
  }

  /** Retrieves the Date Of Report for this Risk History Report @ return Risk History Report Date Of Report */
  public void setDateOfReport(Date dateOfReport) {
    this.dateOfReport = dateOfReport;
  }

  /** Retrieves the Date Of Closure for this Risk History Report @ return Risk History Report Date Of Closure */
  public void setDateOfClosure(Date dateOfClosure) {
    this.dateOfClosure = dateOfClosure;
  }

  /** Retrieves the Summary of findings for this Risk History Report @ return Risk History Report Date Of Closure */
  public void setFindingHistoryReport(String findingHistoryReport) {

    this.findingHistoryReport = findingHistoryReport;
  }

  /** Retrieves the Child Death Ind for this Risk History Report @ return Risk History Report Child Death Ind */

  public void setIndChildHistoryReport(String indChildHistoryReport) {
    this.indChildHistoryReport = indChildHistoryReport;
  }

  /** Retrieves the Parents Guide Ind for this Investigation Actions @ return Investigation Actions Parents Guide Ind */
  public void setIndParentsGuide(String indParentsGuide) {
    this.indParentsGuide = indParentsGuide;
  }

  /** Retrieves the Parents Guide Date for this Investigation Actions @ return Investigation Actions Parents Guide date */
  public void setDateParentsGuide(Date dateParentsGuide) {
    this.dateParentsGuide = dateParentsGuide;
  }

  /**
   * Retrieves the Parents Notified Ind for this Investigation Actions @ return Investigation Actions Parents Notified
   * Ind
   */
  public void setIndParentsNotified(String indParentsNotified) {
    this.indParentsNotified = indParentsNotified;
  }

  /**
   * Retrieves the Parents Notified Date for this Investigation Actions @ return Investigation Actions Parents Notified
   * Date
   */
  public void setDateParentsNotified(Date dateParentsNotified) {
    this.dateParentsNotified = dateParentsNotified;
  }

  /**
   * Retrieves the HIPPA Policy Exp Ind for this Investigation Actions @ return Investigation Actions HIPPA Policy Exp
   * Ind
   */
  public void setIndHIPPAPolicyExp(String indHIPPAPolicyExp) {
    this.indHIPPAPolicyExp = indHIPPAPolicyExp;
  }

  /**
   * Retrieves the HIPPA Policy signed Ind for this Investigation Actions @ return Investigation Actions HIPPA Policy
   * Exp Ind
   */
  public void setIndHIPPAPolicySigned(String indHIPPAPolicySigned) {
    this.indHIPPAPolicySigned = indHIPPAPolicySigned;
  }

  /**
   * Retrieves the HIPPA Policy signed date for this Investigation Actions @ return Investigation Actions HIPPA Policy
   * Exp Ind
   */
  public void setDateHIPPASignedAndAck(Date dateHIPPASignedAndAck) {
    this.dateHIPPASignedAndAck = dateHIPPASignedAndAck;
  }

  /**
   * Retrieves the HIPPA Policy comments for this Investigation Actions @ return Investigation Actions HIPPA Policy Exp
   * Ind
   */
  public void setCommentsHIPPA(String commentsHIPPA) {
    this.commentsHIPPA = commentsHIPPA;
  }

  public void setDateLastUpdateInvActions(Date dateLastUpdateInvActions) {
    this.dateLastUpdateInvActions = dateLastUpdateInvActions;
  }

  /**
   * Retrieves the childFragilityProtection for Assessment of family strength @ return Assessment of family strength
   * childFragilityProtection Ind
   */
  public void setIndChildFragilityProtection(String indChildFragilityProtection) {
    this.indChildFragilityProtection = indChildFragilityProtection;
  }

  /**
   * Retrieves the childBehaviour for Assessment of family strength @ return Assessment of family strength
   * childBehaviour Ind
   */
  public void setIndChildBehaviour(String indChildBehaviour) {
    this.indChildBehaviour = indChildBehaviour;
  }

  /**
   * Retrieves the ChildVulnerability for Assessment of family strength @ return Assessment of family strength
   * ChildVulnerability Ind
   */
  public void setIndChildVulnerability(String indChildVulnerability) {
    this.indChildVulnerability = indChildVulnerability;
  }

  /**
   * Retrieves the KnowledgeSkills for Assessment of family strength @ return Assessment of family strength
   * KnowledgeSkills Ind
   */
  public void setIndKnowledgeSkills(String indKnowledgeSkills) {
    this.indKnowledgeSkills = indKnowledgeSkills;
  }

  /** Retrieves the Control for Assessment of family strength @ return Assessment of family strength Control Ind */
  public void setIndControl(String indControl) {
    this.indControl = indControl;
  }

  /** Retrieves the Functioning for Assessment of family strength @ return Assessment of family strength Functioning Ind */
  public void setIndFunctioning(String indFunctioning) {
    this.indFunctioning = indFunctioning;
  }

  /**
   * Retrieves the Emotional Care for Assessment of family strength @ return Assessment of family strength Emotional
   * Care Ind
   */
  public void setIndEmotionalCare(String indEmotionalCare) {
    this.indEmotionalCare = indEmotionalCare;
  }

  /**
   * Retrieves the Physical Care for Assessment of family strength @ return Assessment of family strength Physical Care
   * Ind
   */
  public void setIndPhysicalCare(String indPhysicalCare) {
    this.indPhysicalCare = indPhysicalCare;
  }

  /** Retrieves the Trend for Assessment of family strength @ return Assessment of family strength Trend Ind */
  public void setIndTrend(String indTrend) {
    this.indTrend = indTrend;
  }

  /**
   * Retrieves the Current Severity for Assessment of family strength @ return Assessment of family strength Current
   * Severity Ind
   */
  public void setIndCurrentSeverity(String indCurrentSeverity) {
    this.indCurrentSeverity = indCurrentSeverity;
  }

  /** Retrieves the Chronicity for Assessment of family strength @ return Assessment of family strength Chronicity Ind */
  public void setIndChronicity(String indChronicity) {
    this.indChronicity = indChronicity;
  }

  /**
   * Retrieves the Dangerous Exposure for Assessment of family strength @ return Assessment of family strength Dangerous
   * Exposure Ind
   */
  public void setIndDangerousExposure(String indDangerousExposure) {
    this.indDangerousExposure = indDangerousExposure;
  }

  /** Retrieves the Stressors for Assessment of family strength @ return Assessment of family strength Stressors Ind */
  public void setIndStressors(String indStressors) {
    this.indStressors = indStressors;
  }

  /**
   * Retrieves the Social Climate for Assessment of family strength @ return Assessment of family strength Social
   * Climate Ind
   */
  public void setIndSocialClimate(String indSocialClimate) {
    this.indSocialClimate = indSocialClimate;
  }

  /**
   * Retrieves the Social Violence for Assessment of family strength @ return Assessment of family strength Social
   * Violence Ind
   */
  public void setIndSocialViolence(String indSocialViolence) {
    this.indSocialViolence = indSocialViolence;
  }

  /** Retrieves the Deception for Assessment of family strength @ return Assessment of family strength Deception Ind */
  public void setIndDeception(String indDeception) {
    this.indDeception = indDeception;
  }

  /** Retrieves the Attitude for Assessment of family strength @ return Assessment of family strength Attitude Ind */
  public void setIndAttitude(String indAttitude) {
    this.indAttitude = indAttitude;
  }

  /**
   * Retrieves the Caregiver Capability for Assessment of family strength @ return Assessment of family strength
   * Caregiver Capability Ind
   */
  public void setIndCaregiverCapability(String indCaregiverCapability) {
    this.indCaregiverCapability = indCaregiverCapability;
  }

  /**
   * Retrieves the Quality Of Care for Assessment of family strength @ return Assessment of family strength Quality Of
   * Care Ind
   */
  public void setIndQualityOfCare(String indQualityOfCare) {
    this.indQualityOfCare = indQualityOfCare;
  }

  /**
   * Retrieves the Maltreatment Pattern for Assessment of family strength @ return Assessment of family strength
   * Maltreatment Pattern Ind
   */
  public void setIndMaltreatmentPattern(String indMaltreatmentPattern) {
    this.indMaltreatmentPattern = indMaltreatmentPattern;
  }

  /** Retrieves the Home Env for Assessment of family strength @ return Assessment of family strength Home Env Ind */
  public void setIndHomeEnv(String indHomeEnv) {
    this.indHomeEnv = indHomeEnv;
  }

  /** Retrieves the Social Env for Assessment of family strength @ return Assessment of family strength Social Env Ind */
  public void setIndSocialEnv(String indSocialEnv) {
    this.indSocialEnv = indSocialEnv;
  }

  /**
   * Retrieves the Response To Intervention for Assessment of family strength @ return Assessment of family strength
   * Response To Intervention Ind
   */
  public void setIndResponseToIntervention(String indResponseToIntervention) {
    this.indResponseToIntervention = indResponseToIntervention;
  }

  /** Retrieves the justification for Assessment of family strength @ return Assessment of family strength justification */

  public void setCommentsAssessmentOfFmlyStr(String commentsAssessmentOfFmlyStr) {
    this.commentsAssessmentOfFmlyStr = commentsAssessmentOfFmlyStr;
  }

  public void setDateLastUpdateFmlyStr(Date dateLastUpdateFmlyStr) {
    this.dateLastUpdateFmlyStr = dateLastUpdateFmlyStr;
  }

  public void setReports(List<RiskAssmtPriorHistoryValueBean> reports) {
    this.reports = reports;
  }

  /**
   * Sets the Stage Id for this Risk Assessment
   * 
   * @param Risk
   *          Assessment Stage Id
   */
  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  /**
   * Sets the "is created using IRA or IMPACT" indicator for this Risk Assessment
   * 
   * @param Risk
   *          Assessment "is created using IRA or IMPACT" boolean value
   */
  public void setIsCreatedUsingIRAorIMPACT(boolean isCreatedUsingIRAorIMPACT) {
    this.isCreatedUsingIRAorIMPACT = isCreatedUsingIRAorIMPACT;
  }

  /**
   * Sets the indicator that indicates whether or not the Risk Assessment was accessed in approval mode--via an Approval
   * To-Do.
   * 
   * @param Risk
   *          Assessment "is approval mode" boolean value
   */
  public void setIsApprovalMode(boolean isApprovalMode) {
    this.isApprovalMode = isApprovalMode;
  }

  /** Get a string of variable names and values @ return String */

  public String toString() {
    return ("\n" + "RiskAssmtValueBean \n" + "  caseId = " + caseId + "\n" + "  stageId = " + stageId + "\n"
            + "  eventId = " + eventId + "\n" + "  purpose = " + purpose + "\n" + "  finding = " + finding + "\n"
            + " dateResponse = " + dateResponse + "\n" + " indResponse = " + indResponse + "\n" + " dateOfReport = "
            + dateOfReport + "\n" + " dateOfClosure = " + dateOfClosure + "\n" + " indChildHistoryReport = "
            + indChildHistoryReport + "\n" + "indParentsGuide = " + indParentsGuide + "\n" + "dateParentsGuide = "
            + dateParentsGuide + "\n" + "indParentsNotified =" + indParentsNotified + "\n" + "dateParentsNotified = "
            + dateParentsNotified + "\n" + "indHIPPAPolicyExp = " + indHIPPAPolicyExp + "\n" + "indHIPPAPolicySigned ="
            + indHIPPAPolicySigned + "\n" + "dateHIPPASignedAndAck = " + dateHIPPASignedAndAck + "\n"
            + " dateLastUpdate = " + dateLastUpdate + "\n" + "  factors = \n" + factors + " \n" + "  eventStatus = "
            + eventStatus + "\n" + "  eventDateLastUpdate = " + eventDateLastUpdate + "\n"
            + "  areaCompletionStatus = " + areaCompletionStatus + " \n" + "  isComplete = " + isComplete + "\n"
            + "  investigationConclusionEvent = " + investigationConclusionEvent + "\n" + "  hasStructuredNarr = "
            + hasStructuredNarr + "\n" + "  szCdTask = " + szCdTask + "\n" + "  szUserLoginId = " + szUserLoginId
            + "\n" + "  ulPersonId = " + ulPersonId + "\n" + "  isCreatedUsingIRAorIMPACT = "
            + isCreatedUsingIRAorIMPACT + "\n" + "  isApprovalMode = " + isApprovalMode + "\n" + "end RiskAssmtValueBean \n");
  }

  public String getCdCurrLvlRisk() {
    return cdCurrLvlRisk;
  }

  public void setCdCurrLvlRisk(String cdCurrLvlRisk) {
    this.cdCurrLvlRisk = cdCurrLvlRisk;
  }
}
