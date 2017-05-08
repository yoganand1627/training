package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtPriorHistoryValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskFactorValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RiskAssmt;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

//import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtFmlyStrValueBean;

/**
 * Conversation class used to retrieve the details of a Risk Assessment from the database and prepare them for display
 * on the JSP. Also used to save and update the Risk Assessment details. <p/> <p/>
 * <p/>
 * <pre>
 * Change History:
 * Date        User      Description
 * ----------  --------  --------------------------------------------------
 * 06/06/2003  GRIMSHAN  SIR 16979 -Retrieve page mode from event search conversation
 *                       if the page mode does not need to be changed, it will not be
 * 06/06/2009  mchillman STGAP00014127: Added Current Level of Risk to the Risk Assessment 
                         page in the ONG stage
 * </pre>
 *
 * @author Jason Rios, October 10, 2002
 */
public class RiskAssmtConversation extends BaseHiddenFieldStateConversation {
  public static final String DISPLAY_PAGE = "/investigation/RiskAssmt/displayRiskAssmt";

  public static final String TRACE_TAG = "RiskAssmtConversation";

  public static final String RISK_ASSMT_BEAN_KEY = "riskAssmtValueBean";

  private RiskAssmt riskAssmt;

  public void setRiskAssmt(RiskAssmt riskAssmt) {
    this.riskAssmt = riskAssmt;
  }

  /**
   * Called by the GRNDS controller when the user requests to display selected resources.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayRiskAssmt_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayRiskAssmt_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    RiskAssmtValueBean returnBean = new RiskAssmtValueBean();
    boolean isOngStage = CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request));

    try {
      state.removeAllAttributes(request);
      RiskAssmtValueBean searchBean = new RiskAssmtValueBean();
      if (isOngStage) { // accessing from Case Summary | Event List: event ID is put into GlobalData
        searchBean.setEventId(GlobalData.getUlIdEvent(request));
      }
      // Clear the event id from GlobalData. The navigation cannot put the risk
      // assessment event id into GlobalData when the user clicks the Risk
      // Assessment second-level tab, so if an event id is there, it's left
      // over from a previous conversation.
      GlobalData.setUlIdEvent(0, request);

      //RiskAssmtValueBean searchBean = new RiskAssmtValueBean();
      searchBean.setCaseId(GlobalData.getUlIdCase(request));
      searchBean.setStageId(GlobalData.getUlIdStage(request));
      // searchBean.setEventId(GlobalData.getUlIdEvent(request));

      // The navigation cannot put the risk assessment event id into GlobalData
      // when the user clicks the Risk Assessment second-level tab, so query the
      // risk assessment event id (using case id and stage id), if it exists,
      // and determine whether or not the risk assessment was created using
      // IRA/IMPACT.

      //returnBean = riskAssmtEjb.checkIfRiskAssmtCreatedUsingIRA(searchBean);

      // start modification to include Risk ReAssessment from FPR stage
      // This is done while testing accessing Risk ReAssessment through third level tab
      // Event list under second level tab Case Summary
      // There is supposed to be a third level tab Risk Assessment under second level
      // tab Family Plans but it has yet been implemented
      // Code might need rewriting if clicking on this third level tab Risk Assessment 
      // stil cannot put Risk Assessment event ID into GlobalData
      if (isOngStage) { // 
        returnBean.setCaseId(GlobalData.getUlIdCase(request));
        returnBean.setStageId(GlobalData.getUlIdStage(request));
        returnBean.setSzCdTask(GlobalData.getSzCdTask(request));
        returnBean.setIsCreatedUsingIRAorIMPACT(true);
        returnBean.setEventId(searchBean.getEventId());
      } else {
        returnBean = riskAssmt.checkIfRiskAssmtCreatedUsingIRA(searchBean);
      }
      // end modification to include Risk ReAssessment from FPR stage

      // If a risk assessment was found and it was not created using IRA or
      // IMPACT, send the user to the Risk and Safety Assessment page. If a risk
      // assessment was found and it was created using IRA or IMPACT, query the
      // complete risk assessment details and send the user to the Risk
      // Assessment page. If a risk assessment was not found, query the data
      // needed to build the page.
      if (returnBean.getEventId() > 0) {
        GlobalData.setUlIdEvent(returnBean.getEventId(), request);

        // SIR 16979 - Since the risk assessment event already exists,
        // we must
        // determine PageMode using the EventSearchConversation because
        // the
        // PageMode might be different if the user is accessing the risk
        // assessment from the Event List.
        // SHINES - However, if this is a Risk ReAssessment created in ONG, needs to reflect Family Plan that 
        // created it page mode. It is simply VIEW if Family Plan is approved, EDIT otherwise.
        if (isOngStage) {
          PageMode.setPageMode(riskAssmt.queryFamilyPlanPageMode(returnBean.getEventId()), request);
        } else {
          PageMode.setPageMode(EventSearchConversation.getEventDetailPageMode(request), request);
        }
        // if (!returnBean.isCreatedUsingIRAorIMPACT()) {
        // SIR 18434 - Risk Assessments that were not created in IRA or IMPACT
        // should be displayed in the 'Risk and Safety Assessment' page. First
        // put the risk assessment event's task code into GlobalData, then
        // send the user to that page. There are approximately 239361 risk
        // assessments not created in IRA or IMPACT that have a null task code
        // and that do not have any principals associated with the event. If
        // the user attempts to access one of those risk assessments, send them
        // to the Generic Error Page and inform them that the data is not
        // available (because the 'Risk and Safety Assessment' page will blow
        // up for those events).
        // if (returnBean.getSzCdTask() != null) {
        // GlobalData.setSzCdTask(returnBean.getSzCdTask(),
        // request);
        // setPresentationBranch("RiskAndSafetyAssessment",
        // context);
        // } else {
        // displayMessagePage(
        // MessageLookup
        // .getMessageByNumber(Messages.MSG_RA_NO_DATA_AVAILABLE),
        // context);
        // } // end if( returnBean.getSzCdTask() != null )
        // } else {
        // Retrieve the risk assessment details and the related Investigation
        // Conclusion Event, if it exists. Also check the risk assessment for completion.
        searchBean.setEventId(returnBean.getEventId());
        UserProfile user = UserProfileHelper.getUserProfile(request);
        searchBean.setSzUserLoginId(user.getUserLogonID());
        searchBean.setUlPersonId(user.getUserID());
        returnBean = riskAssmt.queryRiskAssmt(searchBean);
        // If the Investigation Conclusion Event Status is 'PEND', then set a
        // message in the request that will notify the user that the pending
        // approval will be invalidated if they save any changes.
        if (returnBean != null) {
          if (returnBean.getInvestigationConclusionEvent() != null
              && CodesTables.CEVTSTAT_PEND.equals(returnBean.getInvestigationConclusionEvent().getEventStatus())
              && !GlobalData.isApprovalMode(request)) {
            setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);

            setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
          } // end if(
          // returnBean.getInvestigationConclusionEvent()
        } else { // != null &&...
          PageMode.setPageMode(GlobalData.getAppMode(request), request);
          returnBean = riskAssmt.queryPageData(searchBean);
        }
        // } // end if( isCreatedUsingIRA.booleanValue() == false )
      } else {
        // Since this is a new risk assessment, PageMode will be the same as AppMode.
        PageMode.setPageMode(GlobalData.getAppMode(request), request);
        returnBean = riskAssmt.queryPageData(searchBean);
      } // end if ( searchBean.getEventId() > 0 )

      // If the risk assessment was accessed in approval mode, set the indicator accordingly.
      if (GlobalData.isApprovalMode(request)) {
        returnBean.setIsApprovalMode(true);
      }
      if (isOngStage) {
        CaseUtility.Event mostRecentRiskAssmtEvent = CaseUtility.getEvent(searchBean.getEventId());
        //returnBean.setDateLastUpdate(mostRecentRiskAssmtEvent.getDtLastUpdate());
        returnBean.setEventDateLastUpdate(mostRecentRiskAssmtEvent.getDtLastUpdate());
        returnBean.setEventStatus(mostRecentRiskAssmtEvent.getCdEventStatus());
      }
      state.setAttribute("riskAssmtBean", returnBean, request);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /*
   * Constructor that builds the bean from an HttpServletRequest.
   * 
   * @param request The HttpServletRequest object.
   */
  public static RiskAssmtValueBean createRiskAssmtValueBean(HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    RiskAssmtValueBean riskAssmtValueBean = new RiskAssmtValueBean();
    // Create the field names to be retrieved from the request object based
    // upon
    // the params sent to this method
    String caseIdFieldName = "hdnCaseId";
    String stageIdFieldName = "hdnStageId";
    String eventIdFieldName = "hdnEventId";
    String purposeFieldName = "selPurpose";
    String findingFieldName = "selFinding";
    String dateLastUpdateFieldName = "hdnDateLastUpdate";
    String eventDateLastUpdateFieldName = "hdnEventDateLastUpdate";
    String eventStatusFieldName = "hdnEventStatus";
    String responseDateFieldName = "txtDtResponse";
    String responseTimeFieldName = "txtTmResponse";
    String responeTimeIndFieldName = "rbResponseTime";
    String priorHistoryDateOfReportFieldName = "txtDateOfReport";
    String priorHistoryDateOfClosureFieldName = "txtDtOfClosure";
    String priorHistoryChildDeathOrInjuryFieldName = "cbxChildDeathOrSeriousInjury";
    String priorHistorySummaryOfFindingsFieldName = "txtRiskAssmtPriorHistory";
    String parentsGuideIndFieldName = "rbParentsGuide";
    String dateCopyOfParentsGuideToParentsFieldName = "txtDtParentsGuide";
    String parentsNotifiedIndFieldName = "rbParentNotified";
    String dateParentNotifiedFieldName = "txtDtParentNotified";
    String HIPPAPolicyExplainedFieldName = "rbHIPPAPolicyExplained";
    String HIPPASignedFieldName = "rbHIPPASigned";
    String dateHIPPASignedAndAckFieldName = "txtDtHIPPASignedAndAck";
    String commentsONHIPPAFieldName = "txtCommentsOnHIPPA";
    String hdnLastUpdateInvActionsFieldName = "hdnDateLastUpdateInvActions";
    String childFragilityProtectionFieldName = "cbxChildFragilityProtect";
    String childBehaviourFieldName = "cbxChildBehaviour";
    String childVulnerabilityFieldName = "rbChildVulnerability";
    String KnowledgeSkillsFieldName = "cbxKnowledgeSkills";
    String ControlFieldName = "cbxControl";
    String FunctioningFieldName = "cbxFunctioning";
    String EmotionalCareFieldName = "cbxEmotionalCare";
    String PhysicalCareFieldName = "cbxPhysicalCare";
    String TrendFieldName = "cbxTrend";
    String CurrentSeverityFieldName = "cbxCurrentSeverity";
    String ChronicityFieldName = "cbxChronicity";
    String DangerousExposureFieldName = "cbxDangerousExposure";
    String StressorsFieldName = "cbxStressors";
    String SocialClimateFieldName = "cbxSocialClimate";
    String SocialViolenceFieldName = "cbxSocialViolence";
    String DeceptionFieldName = "cbxDeception";
    String AttitudeFieldName = "cbxAttitude";
    String CaregiverCapabilityFieldName = "rbCaregiverCapability";
    String QualityOfCareFieldName = "rbQualityOfCare";
    String MaltreatmentPatternFieldName = "rbMaltreatmentPattern";
    String HomeEnvFieldName = "rbHomeEnv";
    String SocialEnvFieldName = "rbSocialEnv";
    String ResponseToInterventionFieldName = "rbResponseToIntervention";
    String commentsAssessmentOfFmlyStrFieldName = "txtSummarizeJustificationOfFindings";
    String dateLastUpdateFmlyStrFieldName = "hdnDateLastUpdateFmlyStr";
    String numOfReportsField = "numOfReports";
    String currentLevelOfRisk = "selCurrLvlRisk";

    // Retrieve the field values from the request and set the properties of
    // this
    // bean to those values
    riskAssmtValueBean.setCaseId(ContextHelper.getIntSafe(request, caseIdFieldName));
    riskAssmtValueBean.setStageId(ContextHelper.getIntSafe(request, stageIdFieldName));
    riskAssmtValueBean.setEventId(ContextHelper.getIntSafe(request, eventIdFieldName));

    // Retrieve the following field values from the request and set the
    // properties
    // of this bean to those values ONLY IF the values are not null or
    // empty.
    if (request.getParameter(purposeFieldName) != null && !"".equals(request.getParameter(purposeFieldName))) {
      riskAssmtValueBean.setPurpose(ContextHelper.getStringSafe(request, purposeFieldName));
    }
    if (request.getParameter(findingFieldName) != null && !"".equals(request.getParameter(findingFieldName))) {
      riskAssmtValueBean.setFinding(ContextHelper.getStringSafe(request, findingFieldName));
    }
    if (request.getParameter(dateLastUpdateFieldName) != null
        && !"".equals(request.getParameter(dateLastUpdateFieldName))) {
      riskAssmtValueBean.setDateLastUpdate(ContextHelper.getJavaDateSafe(request, dateLastUpdateFieldName));
    }
    if (request.getParameter(eventDateLastUpdateFieldName) != null
        && !"".equals(request.getParameter(eventDateLastUpdateFieldName))) {
      riskAssmtValueBean.setEventDateLastUpdate(ContextHelper.getJavaDateSafe(request, eventDateLastUpdateFieldName));
    }
    if (request.getParameter(eventStatusFieldName) != null && !"".equals(request.getParameter(eventStatusFieldName))) {
      riskAssmtValueBean.setEventStatus(ContextHelper.getStringSafe(request, eventStatusFieldName));
    }
    if (request.getParameter(responseDateFieldName) != null && !"".equals(request.getParameter(
            responseDateFieldName))) {
      riskAssmtValueBean.setDateResponse(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                               responseDateFieldName)));
    }
    if (request.getParameter(responseTimeFieldName) != null && !"".equals(request.getParameter(
            responseTimeFieldName))) {
      riskAssmtValueBean.setTmResponse(ContextHelper.getTimeSafe(request, responseTimeFieldName));
    }
    if (request.getParameter(responeTimeIndFieldName) != null
        && !"".equals(request.getParameter(responeTimeIndFieldName))) {
      riskAssmtValueBean.setIndResponse(ContextHelper.getStringSafe(request, responeTimeIndFieldName));
    }
    if (request.getParameter(currentLevelOfRisk) != null && !"".equals(request.getParameter(currentLevelOfRisk))) {
      riskAssmtValueBean.setCdCurrLvlRisk(ContextHelper.getStringSafe(request, currentLevelOfRisk));
    }
    if (request.getParameter(priorHistoryDateOfReportFieldName) != null
        && !"".equals(request.getParameter(priorHistoryDateOfReportFieldName))) {
      riskAssmtValueBean.setDateOfReport(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                               priorHistoryDateOfReportFieldName)));
    }
    if (request.getParameter(priorHistoryDateOfClosureFieldName) != null
        && !"".equals(request.getParameter(priorHistoryDateOfClosureFieldName))) {
      riskAssmtValueBean.setDateOfClosure(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                                priorHistoryDateOfClosureFieldName)));
    }
    riskAssmtValueBean.setIndChildHistoryReport(CheckboxHelper.getCheckboxValue(request,
                                                                                priorHistoryChildDeathOrInjuryFieldName));
    if (request.getParameter(priorHistorySummaryOfFindingsFieldName) != null
        && !"".equals(request.getParameter(priorHistorySummaryOfFindingsFieldName))) {
      riskAssmtValueBean.setFindingHistoryReport(ContextHelper.getStringSafe(request,
                                                                             priorHistorySummaryOfFindingsFieldName));
    }
    if (request.getParameter(parentsGuideIndFieldName) != null
        && !"".equals(request.getParameter(parentsGuideIndFieldName))) {
      riskAssmtValueBean.setIndParentsGuide(ContextHelper.getStringSafe(request, parentsGuideIndFieldName));
    }
    if (request.getParameter(dateCopyOfParentsGuideToParentsFieldName) != null
        && !"".equals(request.getParameter(dateCopyOfParentsGuideToParentsFieldName))) {
      riskAssmtValueBean.setDateParentsGuide(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                                   dateCopyOfParentsGuideToParentsFieldName)));
    }
    if (request.getParameter(parentsNotifiedIndFieldName) != null
        && !"".equals(request.getParameter(parentsNotifiedIndFieldName))) {
      riskAssmtValueBean.setIndParentsNotified(ContextHelper.getStringSafe(request, parentsNotifiedIndFieldName));
    }
    if (request.getParameter(dateParentNotifiedFieldName) != null
        && !"".equals(request.getParameter(dateParentNotifiedFieldName))) {
      riskAssmtValueBean.setDateParentsNotified(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                                      dateParentNotifiedFieldName)));
    }
    if (request.getParameter(HIPPAPolicyExplainedFieldName) != null
        && !"".equals(request.getParameter(HIPPAPolicyExplainedFieldName))) {
      riskAssmtValueBean.setIndHIPPAPolicyExp(ContextHelper.getStringSafe(request, HIPPAPolicyExplainedFieldName));
    }
    if (request.getParameter(HIPPASignedFieldName) != null && !"".equals(request.getParameter(HIPPASignedFieldName))) {
      riskAssmtValueBean.setIndHIPPAPolicySigned(ContextHelper.getStringSafe(request, HIPPASignedFieldName));
    }

    if (request.getParameter(dateHIPPASignedAndAckFieldName) != null
        && !"".equals(request.getParameter(dateHIPPASignedAndAckFieldName))) {
      riskAssmtValueBean.setDateHIPPASignedAndAck(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                                        dateHIPPASignedAndAckFieldName)));
    }
    if (request.getParameter(commentsONHIPPAFieldName) != null
        && !"".equals(request.getParameter(commentsONHIPPAFieldName))) {
      riskAssmtValueBean.setCommentsHIPPA(ContextHelper.getStringSafe(request, commentsONHIPPAFieldName));
    }

    if (request.getParameter(hdnLastUpdateInvActionsFieldName) != null
        && !"".equals(request.getParameter(hdnLastUpdateInvActionsFieldName))) {
      riskAssmtValueBean.setDateLastUpdateInvActions(ContextHelper.getJavaDateSafe(request,
                                                                                   hdnLastUpdateInvActionsFieldName));
    }
    riskAssmtValueBean.setIndChildFragilityProtection(CheckboxHelper.getCheckboxValue(request,
                                                                                      childFragilityProtectionFieldName));

    riskAssmtValueBean.setIndChildBehaviour(CheckboxHelper.getCheckboxValue(request, childBehaviourFieldName));

    if (request.getParameter(childVulnerabilityFieldName) != null
        && !"".equals(request.getParameter(childVulnerabilityFieldName))) {
      riskAssmtValueBean.setIndChildVulnerability(ContextHelper.getStringSafe(request, childVulnerabilityFieldName));
    }
    riskAssmtValueBean.setIndKnowledgeSkills(CheckboxHelper.getCheckboxValue(request, KnowledgeSkillsFieldName));

    riskAssmtValueBean.setIndControl(CheckboxHelper.getCheckboxValue(request, ControlFieldName));

    riskAssmtValueBean.setIndFunctioning(CheckboxHelper.getCheckboxValue(request, FunctioningFieldName));

    riskAssmtValueBean.setIndEmotionalCare(CheckboxHelper.getCheckboxValue(request, EmotionalCareFieldName));

    riskAssmtValueBean.setIndPhysicalCare(CheckboxHelper.getCheckboxValue(request, PhysicalCareFieldName));

    riskAssmtValueBean.setIndTrend(CheckboxHelper.getCheckboxValue(request, TrendFieldName));

    riskAssmtValueBean.setIndCurrentSeverity(CheckboxHelper.getCheckboxValue(request, CurrentSeverityFieldName));

    riskAssmtValueBean.setIndChronicity(CheckboxHelper.getCheckboxValue(request, ChronicityFieldName));

    riskAssmtValueBean.setIndDangerousExposure(CheckboxHelper.getCheckboxValue(request, DangerousExposureFieldName));

    riskAssmtValueBean.setIndStressors(CheckboxHelper.getCheckboxValue(request, StressorsFieldName));

    riskAssmtValueBean.setIndSocialClimate(CheckboxHelper.getCheckboxValue(request, SocialClimateFieldName));

    riskAssmtValueBean.setIndSocialViolence(CheckboxHelper.getCheckboxValue(request, SocialViolenceFieldName));

    riskAssmtValueBean.setIndDeception(CheckboxHelper.getCheckboxValue(request, DeceptionFieldName));

    riskAssmtValueBean.setIndAttitude(CheckboxHelper.getCheckboxValue(request, AttitudeFieldName));

    if (request.getParameter(CaregiverCapabilityFieldName) != null
        && !"".equals(request.getParameter(CaregiverCapabilityFieldName))) {
      riskAssmtValueBean.setIndCaregiverCapability(ContextHelper.getStringSafe(request, CaregiverCapabilityFieldName));
    }
    if (request.getParameter(QualityOfCareFieldName) != null
        && !"".equals(request.getParameter(QualityOfCareFieldName))) {
      riskAssmtValueBean.setIndQualityOfCare(ContextHelper.getStringSafe(request, QualityOfCareFieldName));
    }
    if (request.getParameter(MaltreatmentPatternFieldName) != null
        && !"".equals(request.getParameter(MaltreatmentPatternFieldName))) {
      riskAssmtValueBean.setIndMaltreatmentPattern(ContextHelper.getStringSafe(request, MaltreatmentPatternFieldName));
    }
    if (request.getParameter(HomeEnvFieldName) != null && !"".equals(request.getParameter(HomeEnvFieldName))) {
      riskAssmtValueBean.setIndHomeEnv(ContextHelper.getStringSafe(request, HomeEnvFieldName));
    }
    if (request.getParameter(SocialEnvFieldName) != null && !"".equals(request.getParameter(SocialEnvFieldName))) {
      riskAssmtValueBean.setIndSocialEnv(ContextHelper.getStringSafe(request, SocialEnvFieldName));
    }
    if (request.getParameter(ResponseToInterventionFieldName) != null
        && !"".equals(request.getParameter(ResponseToInterventionFieldName))) {
      riskAssmtValueBean.setIndResponseToIntervention(ContextHelper.getStringSafe(request,
                                                                                  ResponseToInterventionFieldName));
    }
    if (request.getParameter(commentsAssessmentOfFmlyStrFieldName) != null
        && !"".equals(request.getParameter(commentsAssessmentOfFmlyStrFieldName))) {
      riskAssmtValueBean.setCommentsAssessmentOfFmlyStr(ContextHelper.getStringSafe(request,
                                                                                    commentsAssessmentOfFmlyStrFieldName));
    }

    if (request.getParameter(dateLastUpdateFmlyStrFieldName) != null
        && !"".equals(request.getParameter(dateLastUpdateFmlyStrFieldName))) {
      riskAssmtValueBean.setDateLastUpdateFmlyStr(ContextHelper.getJavaDateSafe(request,
                                                                                dateLastUpdateFmlyStrFieldName));
    }

    // Determine the number of reports for this item. Get the values for each
    // history report from the request, put them into a history value bean,
    // and put the bean
    // into a Vector. Once all reports have been retrieved from the request,
    // assign the Vector to the appropriate property in this item bean.

    List<RiskAssmtPriorHistoryValueBean> reportsVector = new ArrayList<RiskAssmtPriorHistoryValueBean>();
    String fieldName;
    int numOfReports = ContextHelper.getIntSafe(request, numOfReportsField);
    for (int i = 0; i < numOfReports; i++) {
      RiskAssmtPriorHistoryValueBean reportBean = new RiskAssmtPriorHistoryValueBean();

      // Get the following fields which should never be empty.
      reportBean.setEventId(ContextHelper.getIntSafe(request, eventIdFieldName));

      // Get the following fields only if they are not empty.

      fieldName = "cbxChildDeathOrSeriousInjury" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        reportBean.setIndChildHistoryReport(CheckboxHelper.getCheckboxValue(request, fieldName));
      }

      fieldName = "txtDateOfReport" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        reportBean.setDateOfReport(ContextHelper.getJavaDateSafe(request, fieldName));
      }

      fieldName = "txtDtOfClosure" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        reportBean.setDateOfClosure(ContextHelper.getJavaDateSafe(request, fieldName));
      }

      fieldName = "txtRiskAssmtPriorHistory" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        reportBean.setFindingHistoryReport(ContextHelper.getStringSafe(request, fieldName));
      }

      fieldName = "hdnHistoryReportID" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        reportBean.setRiskHistoryReportId(ContextHelper.getIntSafe(request, fieldName));
      }
      fieldName = "hdnDateLastUpdateHistoryReport" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        reportBean.setLastUpdateDate(ContextHelper.getJavaDateSafe(request, fieldName));
      }

      reportsVector.add(reportBean);
    } // end for ( int i=0; i < numOfTasks; i++ )

    riskAssmtValueBean.setReports(reportsVector);

    GrndsTrace.exitScope();
    return riskAssmtValueBean;
  }

  /**
   * Called by the GRNDS controller when the user saves the Risk Assessment.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveRiskAssmt_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveRiskAssmt_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      RiskAssmtValueBean riskAssmtBeanFromState = (RiskAssmtValueBean) state.getAttribute("riskAssmtBean", request);
      RiskAssmtValueBean riskAssmtBeanFromRequest = createRiskAssmtValueBean(request);

      // RiskAssmtFmlyStrValueBean riskAssmtFmlyStrBeanFromState =
      // (RiskAssmtFmlyStrValueBean)
      // state.getAttribute("riskAssmtFmlyStrBean",request);
      // RiskAssmtFmlyStrValueBean riskAssmtFmlyStrBeanFromRequest =
      // createRiskAssmtFmlyStrBean(request);

      UserProfile user = UserProfileHelper.getUserProfile(request);
      riskAssmtBeanFromRequest.setSzUserLoginId(user.getUserLogonID());
      riskAssmtBeanFromRequest.setUlPersonId(user.getUserID());

      // If the risk assessment was accessed in approval mode, set the
      // indicator
      // accordingly so that the Investigation Conclusion will not be
      // invalidated.
      if (GlobalData.isApprovalMode(request)) {
        riskAssmtBeanFromRequest.setIsApprovalMode(true);
      }

      // Create a Risk Factor bean for each factor using the values submitted
      // in the form, then put the Factor bean into a Vector, then assign the
      // Vector to the appropriate property in the Risk Assessment bean.
      List<RiskFactorValueBean> factors = new ArrayList<RiskFactorValueBean>();
      Iterator iter = riskAssmtBeanFromState.getFactors().iterator();
      while (iter.hasNext()) {
        RiskFactorValueBean riskFactorBeanFromState = (RiskFactorValueBean) iter.next();
        String areaCode = riskFactorBeanFromState.getAreaCode();
        String categoryCode = riskFactorBeanFromState.getCategoryCode();
        String factorCode = riskFactorBeanFromState.getFactorCode();
        String factorText = riskFactorBeanFromState.getFactorText();
        String areaConcernText = riskFactorBeanFromState.getAreaConcernText();
        RiskFactorValueBean riskFactorBeanFromRequest = createRiskFactorValueBean(request, areaCode, categoryCode,
                                                                                  factorCode, factorText,
                                                                                  areaConcernText);
        factors.add(riskFactorBeanFromRequest);
      }
      riskAssmtBeanFromRequest.setFactors(factors);

      Integer riskAssmtEventId = riskAssmt.saveRiskAssmt(riskAssmtBeanFromState, riskAssmtBeanFromRequest);
      // Put the Risk Assessment event id into GlobalData in case this is
      // a
      // new Risk Assessment.
      GlobalData.setUlIdEvent(riskAssmtEventId, request);
    } catch (TimestampMismatchException tme) {
      // Remove "completion check" indicator so the JSP does not fail.
      request.removeAttribute("performCompletionCheck");
      setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
    } catch (ServiceException we) {
      // Remove "completion check" indicator so the JSP does not fail.
      request.removeAttribute("performCompletionCheck");
      handleError(we, context);
    } catch (Exception e) {
      // Remove "completion check" indicator so the JSP does not fail.
      request.removeAttribute("performCompletionCheck");

      // RIOSJA, 09/24/03 - The risk assessment EJB is creating multiple risk
      // assessments for the same Investigation stage in Production. This is
      // bad. For the 09/28/03 release, Murthi is adding a database unique
      // contraint to prevent this from happening. The following if statement
      // will trap any occurances of that constraint violation. Mike Werle said
      // that his new logging architecture will capture lots of information
      // when the constraint is violated, so we probably don't need the if
      // statement below. But please leave it for now. I'll remove it in a
      // future release once we fix the problem with the EJB.

      //* if(e.getMessage().indexOf("CAPS.IND_RISK_ASSESSMENT_1") > -1) { e.printStackTrace(); }

      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Called by the GRNDS controller when the user requests that a completion check be performed on the Risk Assessment.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void checkRiskAssmt_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "checkRiskAssmt_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      // Set a "perform completion check" indicator to true and put it in
      // the
      // request so the JSP will know that a completion check is being
      // performed.
      Boolean performCompletionCheck = Boolean.TRUE;
      request.setAttribute("performCompletionCheck", performCompletionCheck);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Helper method that handles all WTC Exceptions thrown by the save service.
   *
   * @param we      The WtcException object.
   * @param context The GrndeExchangeContext object.
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_DATABASE_SAVE_FAIL:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_MULT_INST:
        setErrorMessage(errorCode, request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

  /**
   * Constructor that builds the bean from an HttpServletRequest.
   *
   * @param request           The HttpServletRequest object.
   * @param areaCodeToGet     The factor's area code.
   * @param categoryCodeToGet The factor's category code.
   * @param factorCodeToGet   The factor's factor code.
   */
  public static RiskFactorValueBean createRiskFactorValueBean(HttpServletRequest request, String areaCodeToGet,
                                                              String categoryCodeToGet, String factorCodeToGet,
                                                              String factorText,
                                                              String areaConcernText) {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    // Create the field names to be retrieved from the request object based upon
    // the params sent to this method
    String caseIdFieldName = "hdnCaseId";
    String stageIdFieldName = "hdnStageId";
    String eventIdFieldName = "hdnEventId";
    String areaIdFieldName = "hdn" + areaCodeToGet + "Id";
    String areaDateLastUpdateFieldName = "hdn" + areaCodeToGet + "DateLastUpdate";
    String areaScaleOfConcernFieldName = "sel" + areaCodeToGet + "ScaleOfConcern";
    String categoryIdFieldName = "hdn" + categoryCodeToGet + "Id";
    String categoryDateLastUpdateFieldName = "hdn" + categoryCodeToGet + "DateLastUpdate";
    String categoryScaleOfConcernFieldName = "sel" + categoryCodeToGet + "ScaleOfConcern";
    String factorIdFieldName = "hdn" + factorCodeToGet + "Id";
    String factorDateLastUpdateFieldName = "hdn" + factorCodeToGet + "DateLastUpdate";
    String factorResponseFieldName = "rb" + factorCodeToGet + "Response";
    String categoryJustificationOfFindingsFieldName = "txt" + areaCodeToGet + "justification";

    RiskFactorValueBean riskFactorBean = new RiskFactorValueBean();
    riskFactorBean.setAreaCode(areaCodeToGet);
    riskFactorBean.setCategoryCode(categoryCodeToGet);
    riskFactorBean.setFactorCode(factorCodeToGet);
    riskFactorBean.setFactorText(factorText);
    riskFactorBean.setAreaConcernText(areaConcernText);

    // Retrieve the field values from the request and set the properties of this bean to those values
    riskFactorBean.setCaseId(ContextHelper.getIntSafe(request, caseIdFieldName));
    riskFactorBean.setStageId(ContextHelper.getIntSafe(request, stageIdFieldName));
    riskFactorBean.setEventId(ContextHelper.getIntSafe(request, eventIdFieldName));

    if (request.getParameter(areaIdFieldName) != null && !"".equals(request.getParameter(areaIdFieldName))) {
      riskFactorBean.setAreaId(ContextHelper.getIntSafe(request, areaIdFieldName));
    }
    if (request.getParameter(areaDateLastUpdateFieldName) != null
        && !"".equals(request.getParameter(areaDateLastUpdateFieldName))) {
      riskFactorBean.setAreaDateLastUpdate(ContextHelper.getJavaDateSafe(request, areaDateLastUpdateFieldName));
    }
    if (request.getParameter(areaScaleOfConcernFieldName) != null
        && !"".equals(request.getParameter(areaScaleOfConcernFieldName))) {
      riskFactorBean.setAreaScaleOfConcern(ContextHelper.getStringSafe(request, areaScaleOfConcernFieldName));
    }
    if (request.getParameter(categoryIdFieldName) != null && !"".equals(request.getParameter(categoryIdFieldName))) {
      riskFactorBean.setCategoryId(ContextHelper.getIntSafe(request, categoryIdFieldName));
    }
    if (request.getParameter(categoryDateLastUpdateFieldName) != null
        && !"".equals(request.getParameter(categoryDateLastUpdateFieldName))) {
      riskFactorBean.setCategoryDateLastUpdate(ContextHelper.getJavaDateSafe(request, categoryDateLastUpdateFieldName));
    }
    if (request.getParameter(categoryScaleOfConcernFieldName) != null
        && !"".equals(request.getParameter(categoryScaleOfConcernFieldName))) {
      riskFactorBean.setCategoryScaleOfConcern(ContextHelper.getStringSafe(request, categoryScaleOfConcernFieldName));
    }
    if (request.getParameter(factorIdFieldName) != null && !"".equals(request.getParameter(factorIdFieldName))) {
      riskFactorBean.setFactorId(ContextHelper.getIntSafe(request, factorIdFieldName));
    }
    if (request.getParameter(factorDateLastUpdateFieldName) != null
        && !"".equals(request.getParameter(factorDateLastUpdateFieldName))) {
      riskFactorBean.setFactorDateLastUpdate(ContextHelper.getJavaDateSafe(request, factorDateLastUpdateFieldName));
    }
    if (request.getParameter(factorResponseFieldName) != null
        && !"".equals(request.getParameter(factorResponseFieldName))) {
      riskFactorBean.setFactorResponse(ContextHelper.getStringSafe(request, factorResponseFieldName));
    }
    if (request.getParameter(categoryJustificationOfFindingsFieldName) != null
        && !"".equals(request.getParameter(categoryJustificationOfFindingsFieldName))) {
      riskFactorBean.setCategoryJustificationOfFindings(ContextHelper.getStringSafe(request,
                                                                                    categoryJustificationOfFindingsFieldName));
    }
    GrndsTrace.exitScope();
    return riskFactorBean;
  }

  /**
   * Adds a new Prior History Report section to this Risk Assessment
   *
   * @param context The GrndsExchangeContext object.
   */
  public void addPriorHistoryReport_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addPriorHistory_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      RiskAssmtValueBean riskAssmtBeanFromRequest = createRiskAssmtValueBean(request);
      // itemBeanFromRequest.setIdentifiedInRiskAssessment(itemBeanFromState.isIdentifiedInRiskAssessment());
      RiskAssmtValueBean riskAssmtBeanFromState = (RiskAssmtValueBean) state.getAttribute("riskAssmtBean", request);
      List<RiskFactorValueBean> factors = new ArrayList<RiskFactorValueBean>();
      Iterator iter = riskAssmtBeanFromState.getFactors().iterator();
      while (iter.hasNext()) {
        RiskFactorValueBean riskFactorBeanFromState = (RiskFactorValueBean) iter.next();
        String areaCode = riskFactorBeanFromState.getAreaCode();
        String categoryCode = riskFactorBeanFromState.getCategoryCode();
        String factorCode = riskFactorBeanFromState.getFactorCode();
        String factorText = riskFactorBeanFromState.getFactorText();
        String areaConcernText = riskFactorBeanFromState.getAreaConcernText();
        RiskFactorValueBean riskFactorBeanFromRequest = createRiskFactorValueBean(request, areaCode, categoryCode,
                                                                                  factorCode, factorText,
                                                                                  areaConcernText);
        factors.add(riskFactorBeanFromRequest);
        riskAssmt.setRiskFactorValueBean(riskFactorBeanFromRequest, categoryCode, areaCode, factorCode);
      }
      riskAssmtBeanFromRequest.setFactors(factors);

      riskAssmtBeanFromRequest = riskAssmt.checkRiskAssmtForCompletion(riskAssmtBeanFromRequest);

      List<RiskAssmtPriorHistoryValueBean> reportsVector = riskAssmtBeanFromRequest.getReports();
      RiskAssmtPriorHistoryValueBean newReportsBean = new RiskAssmtPriorHistoryValueBean();
      reportsVector.add(0, newReportsBean);
      riskAssmtBeanFromRequest.setReports(reportsVector);
      state.setAttribute("riskAssmtBean", riskAssmtBeanFromRequest, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
}
