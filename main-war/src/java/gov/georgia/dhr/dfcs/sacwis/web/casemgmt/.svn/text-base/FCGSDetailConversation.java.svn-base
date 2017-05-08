package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.WTLPRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to display add or modify a foster care case plan's goal information
 * 
 * @author Vishala Devarakonda, December 18, 2006
 */
@SuppressWarnings("serial")
public class FCGSDetailConversation extends BaseHiddenFieldStateConversation {

  private CaseMgmt casemgmt;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;

  private static final String TRUE = "true";

  public static final String TRACE_TAG = "FCGSDetailConversation";

  public void setCasemgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }

  /**
   * This method is called by the GRNDS controller when a user clicks on the Add Button or the Goal hyperlink on the
   * FCGS sub section
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  @SuppressWarnings("unchecked")
  public void displayFCGSDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayFCGSDetail_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    GoalsBean selectedGoal = new GoalsBean();
    int arrayIndex = ContextHelper.getIntSafe(request, "fcgsIndex");
    String nreIndicator = ContextHelper.getStringSafe(request, "hdnNreIndicator");

    try {
      // In case of FCCPFamily both reunification and nonreunification setions are on the page.
      // when a request is made by this page to access the FCGSDetail page the indicator is checked
      // to determine if the request is made for Reunification or nonreunification.Depending on that
      // the appropriate goal list is retrieved from the state.
      String isAdd = "";
      if (request.getParameter("isAddFCGS") != null) {
        isAdd = request.getParameter("isAddFCGS");
      }
      List<GoalsBean> goalBeanList;
      String goalType;
      String goalRsnCode;
      if ("true".equals(nreIndicator)) {
        goalBeanList = (List) state.getAttribute("specficGoalListNre", request);
        goalType = "NRE";
        goalRsnCode = ContextHelper.getStringSafe(request, "hdnCDGoalRsnNre");
      } else {
        goalBeanList = (List) state.getAttribute("specficGoalList", request);
        goalRsnCode = ContextHelper.getStringSafe(request, "hdnCDGoalRsn");
        goalType = ContextHelper.getStringSafe(request, "hdnGoalType");
      }

      if (goalBeanList != null && !(TRUE.equals(isAdd))) {
        selectedGoal = goalBeanList.get(arrayIndex);
      } else {
        selectedGoal.setCdGoalTyp(goalType);
        selectedGoal.setCdGoalRsn(goalRsnCode);
      }
      // When the user tries to add a new goal and selects a reason which already exists an error message is displayed.
      if ("true".equals(isAdd) && (("NRE".equals(goalType) || "REU".equals(goalType) || "WTL".equals(goalType)))) {
        List<String> extRsnList = (List) state.getAttribute("existingReasonList", request);

        int size = 0;
        if (extRsnList != null && !extRsnList.isEmpty()) {
          size = extRsnList.size();
        }
        String branch;
        String codesTable;
        if ("NRE".equals(goalType)) {
          branch = "FCCP_FAMILY_PLAN_DETAIL";
          codesTable = "CNRRSN";
        } else if ("REU".equals(goalType)) {
          branch = "FCCP_FAMILY_PLAN_DETAIL";
          codesTable = "CRURSN";
        } else if ("WTL".equals(goalType)) {
          branch = "WTLP";
          codesTable = "CWTLPGLS";
        } else {
          // We did not get a goal type; we cannot continue.
          // noinspection ThrowCaughtLocally
          throw new IllegalStateException("Failed to determine goal type.");
        }
        String goalRsn = Lookup.simpleDecodeSafe(codesTable, goalRsnCode);
        if ("".equals(goalRsn)) {
          setErrorMessage(Messages.MSG_FCCP_GOAL_REQD, request);
          setPresentationBranch(branch, context);
        } else if (!"Other".equals(goalRsn)) {
          for (int i = 0; i < size; i++) {
            if (extRsnList.get(i).equals(goalRsn)) {
              setErrorMessage(Messages.MSG_GOAL_TYPE_EXISTS, request);
              setPresentationBranch(branch, context);
              // We are done looping; break out of the loop.
              break;
            }
          }
        }
      }
      state.setAttribute("GoalsBean", selectedGoal, request);
      state.setAttribute("isAddFCGS", isAdd, request);
    } catch (Exception e) {
      handleException(e, context, "displayFCGSDetail_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks on the Add Button on the FCGS Detail page which
   * adds a new step section to the FCGS Detail page
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addGoalStep_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addGoalStep_xa");
    performanceTrace.enterScope();
    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      GoalsBean goalBean = populateFCGSRetrieveSI_Add_Delete(context);
      List<StepBean> stepBeanList = goalBean.getStepBeanList();
      // Add blank object
      stepBeanList.add(new StepBean());
      goalBean.setStepBeanList(stepBeanList);
      state.setAttribute("GoalsBean", goalBean, request);
      String addStepIndicator = "Y";
      state.setAttribute("addStepIndicator", addStepIndicator, request);
      int numberOfSteps = ContextHelper.getIntSafe(request, "numOfSteps");
      numberOfSteps += 1;
      request.setAttribute("numberOfSteps", numberOfSteps);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();

  }

  // This method populates the widget values from the request. This is called when a new step
  // is added or deleted to retain the entered data that is not saved before clicking the button
  private static GoalsBean populateFCGSRetrieveSI_Add_Delete(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "populateFCGSRetrieveSI_Add");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    GoalsBean goalBean = (GoalsBean) state.getAttribute("GoalsBean", request);
    try {

      goalBean.setCdGoalRsn(ContextHelper.getStringSafe(request, "hdnCDGoalRsn"));
      goalBean.setCdGoalTyp(ContextHelper.getStringSafe(request, "hdnGoalType"));
      goalBean.setLdTxtGoal(ContextHelper.getStringSafe(request, "szTxtGoal"));
      goalBean.setLdTxtOther(ContextHelper.getStringSafe(request, "szTxtOther"));

      List<StepBean> stepBeanList = goalBean.getStepBeanList();
      int numOfSteps = ContextHelper.getIntSafe(request, "numOfSteps");
      for (int i = 0; i < numOfSteps; i++) {
        StepBean stepBean = new StepBean();
        String fieldName = "cbxSelected" + i;
        String checkboxValue = CheckboxHelper.getCheckboxValue(request, fieldName);
        if ("Y".equals(checkboxValue)) {
          stepBean.setIndSelected("Y");

          fieldName = "hdnStepId" + i;
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            stepBean.setIdStep(ContextHelper.getIntSafe(request, fieldName));
          }

          fieldName = "hdnStepCode" + i;
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            stepBean.setLdCdStepCode(ContextHelper.getStringSafe(request, fieldName));
          }

          fieldName = "txtDtAntComp" + i;
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            stepBean.setDtAntComp(ContextHelper.getJavaDateSafe(request, fieldName));
          }

          fieldName = "txtDtActComp" + i;
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            stepBean.setDtActComp(ContextHelper.getJavaDateSafe(request, fieldName));
          }

          if (stepBean.getIdStep() != 0) {

            fieldName = "szTxtPriority" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtPriority(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szTxtRspns" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtResponsibility(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStep" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStep(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStepComm" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStepCmnts(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szCdStatus" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdCdStatus(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "stepDtLastUpdate" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setDtLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, fieldName)));
            }

          } else {
            String index = "errorIndex" + i;
            request.setAttribute(index, "true");

            fieldName = "szTxtPriority" + i + "_Disabled";

            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtPriority(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szTxtRspns" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtResponsibility(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStep" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStep(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStepComm" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStepCmnts(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szCdStatus" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdCdStatus(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "stepDtLastUpdate" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setDtLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, fieldName)));
            }
          }

          stepBeanList.remove(i);
          stepBeanList.add(i, stepBean);

        }
      } // end for ( int i=0; i < numOfSteps; i++ )

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return goalBean;
  }

  /**
   * This method is called by the GRNDS controller when a user clicks on the Save Button on the FCGS Detail page
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveFCGSDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveFCGSDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String goalType = ContextHelper.getStringSafe(request, "hdnGoalType");

    try {
      FCGSSaveSI fcgsSaveSI = populateFCGSSaveSI_AU(context);

      casemgmt.updateFCGSInformation(fcgsSaveSI);
      request.setAttribute("FCGSSaveSI", fcgsSaveSI);

      GlobalData.setUlIdEvent(fcgsSaveSI.getUlIdEvent(), request);
      request.setAttribute("FCGS", "fcgs");
      if ("DFC".equals(goalType)) {
        setPresentationBranch("CHILD_PLAN_DETAIL", context);
      } else if ("WTL".equals(goalType)) {
        setPresentationBranch("WTLP", context);
        BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                         .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
        WTLPRetrieveSO wtlpRetrieveSO = (WTLPRetrieveSO) state.getAttribute("RETRIEVE_WTLP_INFORMATION", request);
        if (CodesTables.CEVTSTAT_PEND.equals(wtlpRetrieveSO.getCdEventStatus()) && (!wtlpRetrieveSO.isApprovalMode())) {
          CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(wtlpRetrieveSO, wtlpRetrieveSO.getIdStage(),
                                                                  wtlpRetrieveSO.getUserId());
          invalidateApproval.invalidateApproval(ccmn05ui);
          CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(wtlpRetrieveSO);
          postEvent.postEvent(ccmn01ui);
        }
      } else if ("REU".equals(goalType) || "NRE".equals(goalType) || "AFC".equals(goalType)) {
        setPresentationBranch("FCCP_FAMILY_DETAIL", context);
        // If Foster care case plan family in pending approval and user did not save this page through approval to do,
        // invalidate that pending approval
        BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                         .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
        FCCPFamilyDetailSO fccpFamilyDetailSO = (FCCPFamilyDetailSO) state.getAttribute("CASE_PLAN_FAMILY", request);
        if (CodesTables.CEVTSTAT_PEND.equals(fccpFamilyDetailSO.getCdEventStatus())
            && (!fccpFamilyDetailSO.isApprovalMode() || fccpFamilyDetailSO.isApprovalModeForStageClosure())) {
          CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(fccpFamilyDetailSO, fccpFamilyDetailSO.getStageId(),
                                                                  fccpFamilyDetailSO.getUserId());
          invalidateApproval.invalidateApproval(ccmn05ui);
          CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(fccpFamilyDetailSO);
          postEvent.postEvent(ccmn01ui);
        }
      }

    } catch (Exception e) {
      handleException(e, context, "saveFCGSDetail_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the saveFCGSDetail_xa to populate the input object for the FCGSSave service.
   * 
   * @param context
   *          GrndeExchangeContext
   * @return FCGSSaveSI
   * @throws ParseException
   * @throws ParseException
   */
  private FCGSSaveSI populateFCGSSaveSI_AU(GrndsExchangeContext context) throws ServiceException, ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFCGSSaveSI_AU");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    GoalsBean goalBean = (GoalsBean) state.getAttribute("GoalsBean", request);
    List<StepBean> spBeanList = new ArrayList<StepBean>();
    spBeanList = goalBean.getStepBeanList();
    GoalsBean glBean = new GoalsBean();
    glBean.setCdGoalRsn(ContextHelper.getStringSafe(request, "hdnCDGoalRsn"));
    glBean.setCdGoalTyp(ContextHelper.getStringSafe(request, "hdnGoalType"));
    glBean.setLdTxtGoal(ContextHelper.getStringSafe(request, "szTxtGoal"));
    glBean.setLdTxtOther(ContextHelper.getStringSafe(request, "szTxtOther"));
    glBean.setDtLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "fgcsTsLastUpdate")));

    List<StepBean> stepBeanList = new ArrayList<StepBean>();
    int numOfSteps = ContextHelper.getIntSafe(request, "numOfSteps");
    for (int i = 0; i < numOfSteps; i++) {
      StepBean stepBean = new StepBean();
      int stepId = 0;
      String fieldName = "hdnStepId" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        stepId = ContextHelper.getIntSafe(request, fieldName);
      }
      stepBean.setIdStep(stepId);
      fieldName = "cbxSelected" + i;
      String checkboxValue = CheckboxHelper.getCheckboxValue(request, fieldName);
      if (stepId != 0 && "N".equals(checkboxValue)) {
        Iterator stepListIt = spBeanList.iterator();
        while (stepListIt.hasNext()) {
          StepBean spBean = (StepBean) stepListIt.next();
          if (spBean.getIdStep() == stepId) {
            spBean.setIndSelected("N");
            stepBean = spBean;
            stepBeanList.add(stepBean);
            break;
          }
        }
      } else {
        if ("Y".equals(checkboxValue)) {
          stepBean.setIndSelected("Y");

          fieldName = "hdnStepCode" + i;
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            stepBean.setLdCdStepCode(ContextHelper.getStringSafe(request, fieldName));
          }

          fieldName = "txtDtAntComp" + i;
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            stepBean.setDtAntComp(ContextHelper.getJavaDateSafe(request, fieldName));
          }

          fieldName = "txtDtActComp" + i;
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            stepBean.setDtActComp(ContextHelper.getJavaDateSafe(request, fieldName));
          }

          if (stepBean.getIdStep() != 0) {

            fieldName = "szTxtPriority" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtPriority(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szTxtRspns" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtResponsibility(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStep" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStep(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStepComm" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStepCmnts(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szCdStatus" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdCdStatus(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "stepDtLastUpdate" + i;
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setDtLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, fieldName)));
            }

          } else {
            fieldName = "szTxtPriority" + i + "_Disabled";

            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtPriority(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szTxtRspns" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtResponsibility(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStep" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStep(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "txtStepComm" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdTxtStepCmnts(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "szCdStatus" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setLdCdStatus(ContextHelper.getStringSafe(request, fieldName));
            }

            fieldName = "stepDtLastUpdate" + i + "_Disabled";
            if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
              stepBean.setDtLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, fieldName)));
            }
          }
          stepBeanList.add(stepBean);
        }
      }
    } // end for ( int i=0; i < numOfSteps; i++ )
    glBean.setStepBeanList(stepBeanList);
    int idGoal = 0;

    if (!TRUE.equals(request.getParameter("isAddFCGS"))) {
      idGoal = (ContextHelper.getIntSafe(request, "hdnGoalId"));
    }

    FCGSSaveSI fcgsSaveSI = new FCGSSaveSI();
    String funcCode = ServiceConstants.REQ_FUNC_CD_ADD;

    if (!TRUE.equals(request.getParameter("isAddFCGS"))) {
      funcCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    fcgsSaveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    glBean.setIdGoal(idGoal);
    glBean.setCdScrDataAction(funcCode);
    fcgsSaveSI.setGlBean(glBean);
    performanceTrace.exitScope();
    return fcgsSaveSI;
  }

  /**
   * This method is called by the GRNDS controller when a user clicks on the Delete Section Button on the FCGS Detail
   * page
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteGoal_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteGoal_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);

    try {
      FCGSSaveSI fcgsSaveSI = new FCGSSaveSI();
      GoalsBean goalBean = (GoalsBean) state.getAttribute("GoalsBean", request);
      String goalType = goalBean.getCdGoalTyp();
      List<StepBean> stepBeanList = goalBean.getStepBeanList();
      List<StepBean> newBeanList = new ArrayList<StepBean>();
      int size = stepBeanList.size();
      for (int i = 0; i < size; i++) {
        if ("Y".equals(stepBeanList.get(i).getIndSelected()) || stepBeanList.get(i).getIdStep()!=0) {
          stepBeanList.get(i).setCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
        } else {

          newBeanList.add(stepBeanList.get(i));
        }

      }
      for (int j = 0; j < newBeanList.size(); j++) {
        StepBean delBean = newBeanList.get(j);
        stepBeanList.remove(delBean);
      }
      goalBean.setCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
      fcgsSaveSI.setGlBean(goalBean);
      casemgmt.updateFCGSInformation(fcgsSaveSI);
      request.setAttribute("FCGSDeleteSI", fcgsSaveSI);
      request.setAttribute("FCGS", "fcgs");
      if ("DFC".equals(goalType)) {
        setPresentationBranch("CHILD_PLAN_DETAIL", context);
      } else if ("WTL".equals(goalType)) {
        setPresentationBranch("WTLP", context);
      } else if ("REU".equals(goalType) || "NRE".equals(goalType)) {
        setPresentationBranch("FCCP_FAMILY_DETAIL", context);
      }

    } catch (Exception e) {
      handleException(e, context, "deleteGoal_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks on the delete Button on any one of the Step
   * sections on the FCGS Detail page
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteStep_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteStep_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);

    try {
      int idStep = ContextHelper.getIntSafe(request, "hdnDelStepId");
      int stepIndex = ContextHelper.getIntSafe(request, "hdnDelIndex");
      FCGSSaveSI fcgsSaveSI = new FCGSSaveSI();
      FCGSRetrieveSI fcgsretSI = new FCGSRetrieveSI();
      GoalsBean selectedGoal = (GoalsBean) state.getAttribute("GoalsBean", request);
      StepBean delStepBean = new StepBean();
      int idGoal = selectedGoal.getIdGoal();
      List<StepBean> stepBeanList = new ArrayList<StepBean>();
      stepBeanList = selectedGoal.getStepBeanList();
      if (stepBeanList != null) {
        int size = stepBeanList.size();
        for (int i = 0; i < size; i++) {
          if (stepBeanList.get(i).getIdStep() == idStep) {
            delStepBean = stepBeanList.get(i);
            stepBeanList.get(i).setCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
            break;
          }
        }
        selectedGoal.setStepBeanList(stepBeanList);
        fcgsSaveSI.setGlBean(selectedGoal);
        fcgsSaveSI.setUlIdGoal(idGoal);
        casemgmt.updateFCGSInformation(fcgsSaveSI);
      }
      fcgsretSI.setUlIdGoal(idGoal);
      GoalsBean goalBean = populateFCGSRetrieveSI_Add_Delete(context);
      List<StepBean> stepBeanList1 = new ArrayList<StepBean>();
      stepBeanList1 = goalBean.getStepBeanList();
      // Add blank object
      stepBeanList1.remove(stepIndex);
      goalBean.setStepBeanList(stepBeanList1);
      state.setAttribute("GoalsBean", goalBean, request);
      int numberOfSteps = ContextHelper.getIntSafe(request, "numOfSteps");
      numberOfSteps--;
      request.setAttribute("numberOfSteps", numberOfSteps);
      String deleteStepIndicator = "Y";
      state.setAttribute("deleteStepIndicator", deleteStepIndicator, request);
    } catch (Exception e) {
      handleException(e, context, "deleteStep_xa");
    }
  }

  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param e
   *          The Exception
   * @param methodName
   *          A String containing the method which threw the exception
   */
  protected void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
        this.setPresentationBranch("error", context);

        setErrorMessage(Messages.MSG_CMN_NO_PRIMARY_ROW, "/casemgmt/FCGSDetail/displayFCGSDetail", context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  // Invalidate the pending approval of FCCPFamily from which this page coming from
  private CCMN05UI populateCCMN05UI_InvalidateApproval(FCCPFamilyDetailSO fCCPFamilyDetailToSave, int idStage,
                                                       int idUser) {

    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN05UI_InvalidateApproval");
    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO rowccmn45do = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO();

    input.setSzUserId(String.valueOf(idUser));
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(fCCPFamilyDetailToSave.getDtEventOccurred()));
    rowccmn45do.setSzCdEventStatus(fCCPFamilyDetailToSave.getCdEventStatus());
    rowccmn45do.setSzCdEventType(CodesTables.CEVNTTYP_PLN);
    rowccmn45do.setSzCdTask(fCCPFamilyDetailToSave.getCdTask());
    rowccmn45do.setSzTxtEventDescr(fCCPFamilyDetailToSave.getTxtEventDesc());
    rowccmn45do.setTsLastUpdate(fCCPFamilyDetailToSave.getDtEventLastUpdate());
    rowccmn45do.setUlIdEvent(fCCPFamilyDetailToSave.getEventId());
    rowccmn45do.setUlIdPerson(idUser);
    rowccmn45do.setUlIdStage(idStage);

    ccmn05ui.setUlIdEvent(fCCPFamilyDetailToSave.getEventId());
    ccmn05ui.setArchInputStruct(input);

    GrndsTrace.exitScope();
    return ccmn05ui;
  }

  private CCMN05UI populateCCMN05UI_InvalidateApproval(WTLPRetrieveSO wtlpRetrieveSO, int idStage, int idUser) {

    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN05UI_InvalidateApproval");
    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO rowccmn45do = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO();

    input.setSzUserId(String.valueOf(idUser));
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    rowccmn45do.setSzCdEventStatus(wtlpRetrieveSO.getCdEventStatus());
    rowccmn45do.setSzCdEventType(CodesTables.CEVNTTYP_PLN);
    rowccmn45do.setSzCdTask(wtlpRetrieveSO.getSzCdTask());
    rowccmn45do.setSzTxtEventDescr("Written Transitional Living Plan");
    rowccmn45do.setTsLastUpdate(wtlpRetrieveSO.getDtLastUpdate());
    rowccmn45do.setUlIdEvent(wtlpRetrieveSO.getIdEvent());
    rowccmn45do.setUlIdPerson(idUser);
    rowccmn45do.setUlIdStage(idStage);

    ccmn05ui.setUlIdEvent(wtlpRetrieveSO.getIdEvent());
    ccmn05ui.setArchInputStruct(input);

    GrndsTrace.exitScope();
    return ccmn05ui;
  }

  // Reset the event that FCCPFamily whose pending approval is being invalidated from PEND to PROC
  @SuppressWarnings( { "unchecked" })
  private CCMN01UI populateCCMN01UI_PostEvent(FCCPFamilyDetailSO fCCPFamilyDetailToSave) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN01UI_PostEvent");

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();

    input.setSzUserId(String.valueOf(fCCPFamilyDetailToSave.getUserId()));

    rowccmn01uig00.setUlIdEvent(fCCPFamilyDetailToSave.getEventId());
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_PLN);
    rowccmn01uig00.setSzCdTask(fCCPFamilyDetailToSave.getCdTask());
    rowccmn01uig00.setUlIdPerson(fCCPFamilyDetailToSave.getUserId());
    rowccmn01uig00.setUlIdStage(fCCPFamilyDetailToSave.getStageId());
    rowccmn01uig00.setSzTxtEventDescr(fCCPFamilyDetailToSave.getTxtEventDesc());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(fCCPFamilyDetailToSave.getDtEventOccurred()));
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    rowccmn01uig00.setTsLastUpdate(fCCPFamilyDetailToSave.getDtEventLastUpdate());

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    GrndsTrace.exitScope();

    return ccmn01ui;
  }

  private CCMN01UI populateCCMN01UI_PostEvent(WTLPRetrieveSO wtlpRetrieveSO) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN01UI_PostEvent");

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();

    input.setSzUserId(String.valueOf(wtlpRetrieveSO.getUserId()));

    rowccmn01uig00.setUlIdEvent(wtlpRetrieveSO.getIdEvent());
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_WTL);
    rowccmn01uig00.setSzCdTask(wtlpRetrieveSO.getSzCdTask());
    rowccmn01uig00.setUlIdPerson(wtlpRetrieveSO.getUserId());
    rowccmn01uig00.setUlIdStage(wtlpRetrieveSO.getIdStage());
    rowccmn01uig00.setSzTxtEventDescr("Written Transitional Living Plan");
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(wtlpRetrieveSO.getDtEventCreated()));
    rowccmn01uig00.setTsLastUpdate(wtlpRetrieveSO.getDtLastUpdate());

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    GrndsTrace.exitScope();

    return ccmn01ui;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

}
