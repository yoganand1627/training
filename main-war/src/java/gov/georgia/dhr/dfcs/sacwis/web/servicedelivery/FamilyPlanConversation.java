package gov.georgia.dhr.dfcs.sacwis.web.servicedelivery;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanTaskValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.FamilyPlan;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Used to handle Family Plan of Service functions and procedures.
 * 
 * @author Jason Rios, February 10, 2003 <p/> <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *    --------  -------- --------------------------------------------------
 *   06/06/03  GRIMSHAN  SIR 16979 - Retrieve page mode from event search conversation
 *                        not need to be changed, it will not be
 *   03/05/04  thompswa  SIR 22662 - The Family Plan Perm Goals page was revised with SIR 19979 to
 *                       include a required Target Date field and a message,
 *                       MSG_FP_PERM_GOAL_REQ,  before the plan could be approved. Plans
 *                       created prior to the Target Date field have no date.
 *                       Now, when you click on Approval Status on an APRV plan, the
 *                       message will not display.
 *   06/24/04  RIOSJA    SIR 19002 - We need to keep track of the stage Start Date so that we can display
 *                       an informational message if the worker attemps to evaluate a family
 *   07/01/04  RIOSJA    SIR 14974 - If a principal in the plan has person characteristics of
 *                       'Limited English Proficiency' or 'Hearing Impaired',
 *                       retrieve the Services and Referrals Checklist for the stage
 *                       so we can check whether or not Interpreter/Translator services
 *                       have been offered.
 *  08/13/04  thompswa   SIR 23052 - When a worker attempts to view a family plan, but a family
 *                       plan evaluation exists for that family plan, the user
 *                       is taken to the  Generic Error Page and a new message
 *                       refers them  to printed copies of the plan.
 *  07/24/05   werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *  4/10/08   cjgerry    STGAP00008115 - removed code for SIR 14974 - this is not a georgia requirement
 *  10/20/08  charden    STGAP00010574 - wrote code so that delete button will display only for new tasks
 *                       on the familyPlanItemDetail page that have been added to an updated FamilyPlan before
 *                       the FamilyPlan has been saved
 * </pre>
 */
public class FamilyPlanConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "FamilyPlanConversation";

  public static final String FAMILY_PLAN_BEAN_KEY = "familyPlanBean";

  public static final String FAMILY_PLAN_ITEM_BEAN_KEY = "familyPlanItemBean";

  public static final String EVENT_STATUS_FIELD_NAME = "hdnEventStatus";

  public static final String PERMANENCY_GOAL_FIELD_NAME = "selPermanencyGoal";

  public static final String FAMILY_PLAN_DETAIL_PAGE = "/serviceDelivery/FamilyPlan/displayFamilyPlan";

  public static final String FAMILY_PLAN_ITEM_DETAIL_PAGE = "/serviceDelivery/FamilyPlan/displayFamilyPlanItem";

  public static final String FAMILY_PLAN_SELECTOR_PAGE = "/serviceDelivery/FamilyPlan/listApprovedFamilyPlans";

  public static final String PERMANENCY_GOALS_BUTTON = "btnPermanencyGoals";

  public static final String SAVE_BUTTON_ON_DETAIL_PAGE = "btnSaveOnDetailPage";

  public static final String SAVE_BUTTON_ON_ITEM_PAGE = "btnSaveOnItemPage";

  public static final String SAVE_SUBMIT_BUTTON = "btnSaveSubmit";

  public static final String DELETE_THIS_SECTION_BUTTON = "btnDeleteThisSection";

  public static final String SAVE_FAMILY_PLAN = "1111";

  public static final String SAVE_AND_SUBMIT_FAMILY_PLAN = "2222";

  public static final String GO_TO_APPROVAL_STATUS = "3333";

  /* RIOSJA, SIR 14974 */
  public static final String FPR_CHECKLIST_TASK_CODE = "2306";

  public static final String FRE_CHECKLIST_TASK_CODE = "2307";

  public static final String FSU_CHECKLIST_TASK_CODE = "2308";

  public static final String INV_CHECKLIST_TASK_CODE = "2309";

 public static final String ADD_FAMILY_PLAN_TASK = "/serviceDelivery/FamilyPlan/addFamilyPlanTask";
  
  public static final String DISPLAY_FAMILY_PLAN_ITEM = "/serviceDelivery/FamilyPlan/displayFamilyPlanItem";
  
  public static final String DELETE_FAMILY_PLAN_TASK = "/serviceDelivery/FamilyPlan/deleteFamilyPlanTask";
  
  public static final String DISPLAY_FAMILY_PLAN = "/serviceDelivery/FamilyPlan/displayFamilyPlan";
  
  private FamilyPlan familyPlan;

  public void setFamilyPlan(FamilyPlan familyPlan) {
    this.familyPlan = familyPlan;
  }

  /**
   * Adds a new task group to this family plan item.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addFamilyPlanTask_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addFamilyPlanTask_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanItemValueBean itemBeanFromState = (FamilyPlanItemValueBean) state
                                                                                 .getAttribute(
                                                                                               FAMILY_PLAN_ITEM_BEAN_KEY,
                                                                                               request);
      FamilyPlanItemValueBean itemBeanFromRequest = createFamilyPlanItemValueBean(request);
      itemBeanFromRequest.setIdentifiedInRiskAssessment(itemBeanFromState.isIdentifiedInRiskAssessment());

      List<FamilyPlanTaskValueBean> tasksVector = (List<FamilyPlanTaskValueBean>) itemBeanFromRequest.getTasks();
      FamilyPlanTaskValueBean newTaskBean = new FamilyPlanTaskValueBean();
      tasksVector.add(0, newTaskBean);
      itemBeanFromRequest.setTasks(tasksVector);

      state.setAttribute(FAMILY_PLAN_ITEM_BEAN_KEY, itemBeanFromRequest, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /** Method that builds a FamilyPlanItemValueBean object from an HttpServletRequest object. */
  public static FamilyPlanItemValueBean createFamilyPlanItemValueBean(HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    // Create the field names to be retrieved from the request object based upon
    // the params sent to this method
    String caseIdField = "hdnCaseId";
    String eventIdField = "hdnFamilyPlanEventId";
    String familyPlanItemIdField = "hdnFamilyPlanItemId";
    String familyPlanItemDateLastUpdateField = "hdnFamilyPlanItemDateLastUpdate";
    String areaOfConcernTextField = "hdnAreaOfConcernText";
    String areaOfConcernCodeField = "hdnAreaOfConcernCode";
    String dateInitiallyAddressedField = "hdnDateInitiallyAddressed";
    String goalsField = "txtGoals";
    String dtGoalsCompleted = "txtDtGoalComp";
    String initialLevelOfConcernField = "selInitialLevelOfConcern";
    String currentLevelOfConcernField = "selCurrentLevelOfConcern";
    String numOfTasksField = "numOfTasks";

    FamilyPlanItemValueBean familyPlanItemBean = new FamilyPlanItemValueBean();
    // Get the following fields which should never be empty.
    familyPlanItemBean.setCaseId(ContextHelper.getIntSafe(request, caseIdField));
    familyPlanItemBean.setFamilyPlanEventId(ContextHelper.getIntSafe(request, eventIdField));
    familyPlanItemBean.setFamilyPlanItemId(ContextHelper.getIntSafe(request, familyPlanItemIdField));
    familyPlanItemBean
                      .setFamilyPlanItemDateLastUpdate(ContextHelper.getJavaDateSafe(request,
                                                                                     familyPlanItemDateLastUpdateField));
    familyPlanItemBean.setAreaOfConcernCode(ContextHelper.getStringSafe(request, areaOfConcernCodeField));
    familyPlanItemBean.setAreaOfConcernText(ContextHelper.getStringSafe(request, areaOfConcernTextField));
    familyPlanItemBean.setGoals(ContextHelper.getStringSafe(request, goalsField));
    familyPlanItemBean.setDateGoalsCompleted(ContextHelper.getJavaDateSafe(request, dtGoalsCompleted));

    // Get the following fields only if they are not empty.
    if (request.getParameter(dateInitiallyAddressedField) != null
        && !"".equals(request.getParameter(dateInitiallyAddressedField))) {
      familyPlanItemBean.setDateInitiallyAddressed(ContextHelper.getJavaDateSafe(request, dateInitiallyAddressedField));
    }
    if (request.getParameter(initialLevelOfConcernField) == null
        || "".equals(request.getParameter(initialLevelOfConcernField))) {
    } else {
      familyPlanItemBean
                        .setInitialLevelOfConcernScale(ContextHelper.getStringSafe(request, initialLevelOfConcernField));
    }
    if (request.getParameter(currentLevelOfConcernField) == null
        || "".equals(request.getParameter(currentLevelOfConcernField))) {
    } else {
      familyPlanItemBean
                        .setCurrentLevelOfConcernScale(ContextHelper.getStringSafe(request, currentLevelOfConcernField));
    }

    // Determine the number of tasks for this item. Get the values for each
    // task from the request, put them into a task value bean, and put the bean
    // into a Vector. Once all tasks have been retrieved from the request,
    // assign the Vector to the appropriate property in this item bean.
    List<FamilyPlanTaskValueBean> tasksVector = new ArrayList<FamilyPlanTaskValueBean>();

    int numOfTasks = ContextHelper.getIntSafe(request, numOfTasksField);
    for (int i = 0; i < numOfTasks; i++) {
      FamilyPlanTaskValueBean taskBean = new FamilyPlanTaskValueBean();

      // Get the following fields which should never be empty.
      taskBean.setCaseId(ContextHelper.getIntSafe(request, caseIdField));
      taskBean.setFamilyPlanEventId(ContextHelper.getIntSafe(request, eventIdField));
      taskBean.setFamilyPlanItemId(ContextHelper.getIntSafe(request, familyPlanItemIdField));

      // Get the following fields only if they are not empty.
      // Determine whether or not the "Court Ordered" checkbox is checked.
      String fieldName = "cbxCourtOrdered" + i;
      String checkboxValue = CheckboxHelper.getCheckboxValue(request, fieldName);
      if (ArchitectureConstants.Y.equals(checkboxValue)) {
        taskBean.setCourtOrderedTask(true);
      }

      fieldName = "hdnDateTaskApproved" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setDateTaskApproved(ContextHelper.getJavaDateSafe(request, fieldName));
      }
      fieldName = "txtDateCompleted" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setDateTaskCompleted(ContextHelper.getCastorDateSafe(request, fieldName));
      } else {
        taskBean.setDateTaskCompleted(null);
      }
      fieldName = "txtDateCreated" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setDateTaskCreated(ContextHelper.getCastorDateSafe(request, fieldName));
      }

      fieldName = "txtDateCourtAction" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setDateCourtAction(ContextHelper.getCastorDateSafe(request, fieldName));
      } else {
        taskBean.setDateCourtAction(null);
      }

      fieldName = "cbxCourtMandatedClosure" + i;
      String checkboxCourtValue = CheckboxHelper.getCheckboxValue(request, fieldName);
      if (ArchitectureConstants.Y.equals(checkboxCourtValue)) {
        taskBean.setCourtMandatedClosure(true);
      }

      fieldName = "hdnTaskDateLastUpdate" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setFamilyPlanTaskDateLastUpdate(ContextHelper.getJavaDateSafe(request, fieldName));
      }

      fieldName = "hdnTaskId" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setFamilyPlanTaskId(ContextHelper.getIntSafe(request, fieldName));
      }

      fieldName = "txtTask" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setTask(ContextHelper.getStringSafe(request, fieldName));
      }

      fieldName = "txtProgress" + i;
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        taskBean.setProgress(ContextHelper.getStringSafe(request, fieldName));
      }

      tasksVector.add(taskBean);
    } // end for ( int i=0; i < numOfTasks; i++ )
    familyPlanItemBean.setTasks(tasksVector);

    GrndsTrace.exitScope();
    return familyPlanItemBean;
  }

  /**
   * Deletes the selected Family Plan Task.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteFamilyPlanTask_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteFamilyPlanTask_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY,
                                                                                             request);

      FamilyPlanItemValueBean itemBeanFromState = (FamilyPlanItemValueBean) state
                                                                                 .getAttribute(
                                                                                               FAMILY_PLAN_ITEM_BEAN_KEY,
                                                                                               request);
      FamilyPlanItemValueBean itemBeanFromRequest = createFamilyPlanItemValueBean(request);
      itemBeanFromRequest.setIdentifiedInRiskAssessment(itemBeanFromState.isIdentifiedInRiskAssessment());

      int indexOfTaskToDelete = ContextHelper.getInt(request, "indexOfTaskToDelete");
      itemBeanFromRequest = familyPlan.deleteFamilyPlanTask(familyPlanBeanFromState, itemBeanFromRequest,
                                                            indexOfTaskToDelete);

      // Query the family plan details again in case a pending approval was
      // invalidated and the event details have changed. Put the updated object
      // back into state for later use.
      FamilyPlanValueBean newFamilyPlanBean = familyPlan.queryFamilyPlan(familyPlanBeanFromState);

      itemBeanFromRequest = addEmptyTaskIfNeeded(itemBeanFromRequest);

      state.setAttribute(FAMILY_PLAN_BEAN_KEY, newFamilyPlanBean, request);
      state.setAttribute(FAMILY_PLAN_ITEM_BEAN_KEY, itemBeanFromRequest, request);
    } catch (TimestampMismatchException tme) {
      setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Deletes an entire Family Plan Item. Restores an item to its original state as if the item had never been addressed.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteFamilyPlanItem_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteFamilyPlanItem_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY,
                                                                                             request);
      FamilyPlanItemValueBean itemBeanFromRequest = createFamilyPlanItemValueBean(request);
      familyPlan.deleteFamilyPlanItem(familyPlanBeanFromState, itemBeanFromRequest);
    } catch (TimestampMismatchException tme) {
      setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Queries the family plan details from the database, then displays the Family Plan Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayFamilyPlan_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFamilyPlan_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    boolean invalidateMessageIsAlreadyInRequest = false;
    boolean btnEdit = ContextHelper.getIntSafe(request, "Edit.x") != 0;
    boolean btnNewUsing = ContextHelper.getIntSafe(request, "NewUsing.x") != 0;
    boolean btnAdd = ContextHelper.getIntSafe(request, "Add.x") != 0;
    
    //STGAP00010574 - get the previous url from the request and look in request to see if save button has been pressed
    Integer  saveInt = (Integer) request.getAttribute("Save.x") != null ? (Integer) request.getAttribute("Save.x") : 0;
    boolean isSave = saveInt != 0 ? true : false;
    String prevUrl = request.getParameter("FormValidationPrevUrl");
    Boolean doDelete = state.getAttribute("doDelete", request) == null ? false : true;
    

    try {
      FamilyPlanValueBean familyPlanBean = new FamilyPlanValueBean();

      // Preserve PageMode, and clear state.
      // SIR 16979 get the page mode from event search conversation if the page
      // mode does not need to be changed, it will not be
      String pageMode;
      if (btnEdit) {
        pageMode = PageModeConstants.EDIT;
      } else if (btnNewUsing) {
        pageMode = PageModeConstants.NEW_USING;
      } else if (btnAdd) {
        pageMode = PageModeConstants.NEW;
      } else {
        //pageMode = PageModeConstants.MODIFY;
        pageMode = EventSearchConversation.getEventDetailPageMode(request);
      }
      
      //get maps from state before removing all attributes to be set in later upon satisfaction of conditions
      Map<String, String> areasOfConcernMap = (Map<String, String>) state.getAttribute("areasOfConcernMap", request); 
      Map<String, FamilyPlanItemValueBean> familyPlanItemBeanMap = (Map<String, FamilyPlanItemValueBean>) state.getAttribute("familyPlanItemBeanMap", request);

      state.removeAllAttributes(request);
      PageMode.setPageMode(pageMode, request);
      if (btnEdit) {
        Sets.setPageSet(Sets.E, request);
      } else if (PageModeConstants.NEW_USING.equals(pageMode)) {
        Sets.setPageSet(Sets.N, request);
      } else if (PageModeConstants.NEW.equals(pageMode)) {
        Sets.setPageSet(Sets.A, request);
      } else if (PageModeConstants.MODIFY.equals(pageMode)) {
        Sets.setPageSet(Sets.M, request);
      }
       
      //if we are entering this method from the list page the hyperlink has been pressed, set boolean to true and add it to state
      //to be used in jsp when determining if code should be executed that determines if delete button should display or not
      if(!ADD_FAMILY_PLAN_TASK.equals(prevUrl) && !DISPLAY_FAMILY_PLAN_ITEM.equals(prevUrl) 
          && !DELETE_FAMILY_PLAN_TASK.equals(prevUrl) && !DISPLAY_FAMILY_PLAN.equals(prevUrl) && btnEdit){
        doDelete = true;
        state.setAttribute("doDelete", doDelete, request);
      }
      if(doDelete == true){
        state.setAttribute("doDelete", doDelete, request);
      }
      
      //if we are not entering the display from a page not associated with the FamilyPlan and the save
      //button has not been pressed, resave maps into state
      if((ADD_FAMILY_PLAN_TASK.equals(prevUrl) || DISPLAY_FAMILY_PLAN_ITEM.equals(prevUrl) 
          || DELETE_FAMILY_PLAN_TASK.equals(prevUrl) || DISPLAY_FAMILY_PLAN.equals(prevUrl))
          && (!isSave)){
        state.setAttribute("areasOfConcernMap", areasOfConcernMap, request);
        state.setAttribute("familyPlanItemBeanMap", familyPlanItemBeanMap, request);
      }
      request.removeAttribute("Save.x");
      

      // Populate the new FamilyPlanValueBean with default values from GlobalData.
      familyPlanBean.setCaseId(GlobalData.getUlIdCase(request));
      familyPlanBean.setStageId(GlobalData.getUlIdStage(request));
      familyPlanBean.setStageCode(GlobalData.getSzCdStage(request));
      familyPlanBean.setStageTypeCode(GlobalData.getSzCdStageType(request));
      familyPlanBean.setStageName(GlobalData.getSzNmStage(request));
      familyPlanBean.setIsApprovalMode(GlobalData.isApprovalMode(request));
      familyPlanBean.setUserId(user.getUserID());
      familyPlanBean.setUserLoginId(user.getUserLogonID());

      EventValueBean riskAssmtEvent = new EventValueBean();
      String taskCode = GlobalData.getSzCdTask(request);
      if (taskCode.equals(FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN)) {
        // If there is an event id in GlobalData, then it's the event id of the
        // family plan.
        if (GlobalData.getUlIdEvent(request) > 0) {
          // Query the family plan and family plan event details.
          EventValueBean familyPlanEvent = familyPlan.queryEvent(GlobalData.getUlIdEvent(request));
          familyPlanBean.setFamilyPlanEvent(familyPlanEvent);

          // If the family plan event is pending approval and the user did
          // not access the page via a family plan approval todo, notify them
          // that the pending approval will be invalidated if they save any
          // changes. If the supervisor accessed the pending family plan via
          // a stage closure approval todo, the pending family plan will be
          // invalidated. This will enable the supervisor to close the stage
          // without leaving a pending family plan behind.
          if (CodesTables.CEVTSTAT_PEND.equals(familyPlanEvent.getEventStatusCode())
              && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
            setInformationalMessage(Messages.MSG_FP_INVLD_APRVL, request);
            setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
            invalidateMessageIsAlreadyInRequest = true;
          }
        } // end if (GlobalData.getUlIdEvent(request) > 0)
        else {
          // Since there is no event id in GlobalData, this is a new family
          // plan. Prepare the family plan event bean so that the new family
          // plan event can be created.
          familyPlanBean.getFamilyPlanEvent().setEventTaskCode(taskCode);
          familyPlanBean.getFamilyPlanEvent().setCaseId(GlobalData.getUlIdCase(request));
          familyPlanBean.getFamilyPlanEvent().setStageId(GlobalData.getUlIdStage(request));
        } // end else

        familyPlanBean.setNewUsing(PageModeConstants.NEW_USING.equals(pageMode));
        // A NEW family plan created through stage progression should return a null familyPlanBean
        familyPlanBean = familyPlan.queryFamilyPlan(familyPlanBean); 
        riskAssmtEvent = familyPlan.getRiskAssmtEvent(familyPlanBean); // initial
        // If a plan was copied, current scale if concern should not be populated until new RRA is populated
        if (PageModeConstants.NEW_USING.equals(pageMode)) {
          resetCurrentScaleOfconcern(familyPlanBean);
        }
      }

      // If the stage closure event is pending approval, and the user did not
      // access the page via an approval todo, notify them that the pending
      // approval will be invalidated if they save any changes.
      if (familyPlanBean.getStageClosureEvent() != null
          && CodesTables.CEVTSTAT_PEND.equals(familyPlanBean.getStageClosureEvent().getEventStatusCode())
          && !GlobalData.isApprovalMode(request)) {
        setInformationalMessage(Messages.MSG_FP_STAGE_CLOSURE_INVLD_APRVL, request);
        if (!invalidateMessageIsAlreadyInRequest) {
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }

      state.setAttribute("riskAssmtEvent", riskAssmtEvent, request);
      state.setAttribute(FAMILY_PLAN_BEAN_KEY, familyPlanBean, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Lists all approved family plans for the stage that were created in IMPACT so the user can select the plan to which
   * the new evaluation will apply.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void listApprovedFamilyPlans_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".listApprovedFamilyPlans_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanValueBean searchBean = new FamilyPlanValueBean();
      searchBean.setCaseId(GlobalData.getUlIdCase(request));
      searchBean.setStageId(GlobalData.getUlIdStage(request));

      // The user is creating a new family plan evaluation. Query all
      // approved family plans for the current stage and any prior stage that
      // were created in IMPACT.
      Collection<FamilyPlanValueBean> approvedFamilyPlans = familyPlan.queryApprovedFamilyPlans(searchBean);

      // If there are no approved family plans, notify the user. Otherwise,
      // put the List of approved family plans into state to be used by the
      // JSP and by the FamilyPlanCustomValidation class once the user selects
      // a plan to evaluate.
      if (approvedFamilyPlans == null || approvedFamilyPlans.size() == 0) {
        setInformationalMessage(Messages.MSG_FP_PLAN_NOT_APPRVD, request);
      } else {
        // RIOSJA, SIR 19002 - We need to keep track of the stage Start Date so
        // that we can display an informational message if the worker attemps to
        // evaluate a family plan that was created in a newer stage.
        CaseUtility.Stage currentStage = CaseUtility.getStage(GlobalData.getUlIdStage(request));

        state.setAttribute("currentStage", currentStage, request);
        state.setAttribute("approvedFamilyPlans", approvedFamilyPlans, request);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Displays the Family Plan Item Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayFamilyPlanItem_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFamilyPlanItem_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Determine which item (area of concern) the user selected.
      String selectedAreaOfConcernCode = ContextHelper.getStringSafe(request, "selectedAreaOfConcernCode");

      // Query the item details from the database.
      FamilyPlanItemValueBean selectedItemBean = null;
      FamilyPlanValueBean familyPlanBean = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY, request);
      Iterator iter = familyPlanBean.getFamilyPlanItemList().iterator();
      while (iter.hasNext()) {
        FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) iter.next();
        if (selectedAreaOfConcernCode.equals(itemBean.getAreaOfConcernCode())) {
          selectedItemBean = familyPlan.queryFamilyPlanItem(itemBean);
          break;
        }
      }

      selectedItemBean = addEmptyTaskIfNeeded(selectedItemBean);
      
      //STGAP00010574 - if maps do not exist already in state, create new maps and populate them with area of concern codes and FamilyPlanItemValueBeans
      //respectively then save them into state to be used in JSP to determine if delete button should be displayed.
      //This is code is taking the initial tasks and saving them into state to be compared against taskBeans that have new tasks saved in them
      String beanName = selectedAreaOfConcernCode + "Bean";
      Map<String, String> areasOfConcernMap = (Map<String, String>) state.getAttribute("areasOfConcernMap", request); 
      Map<String, FamilyPlanItemValueBean> familyPlanItemBeanMap = (Map<String, FamilyPlanItemValueBean>) state.getAttribute("familyPlanItemBeanMap", request);
      if(areasOfConcernMap == null){
        areasOfConcernMap = new HashMap<String, String>();
      }
      if(familyPlanItemBeanMap == null){
        familyPlanItemBeanMap = new HashMap<String, FamilyPlanItemValueBean>();
      }
      if(!familyPlanItemBeanMap.containsKey(beanName)){
        familyPlanItemBeanMap.put(beanName, selectedItemBean);
      }
      if (!areasOfConcernMap.containsKey(selectedAreaOfConcernCode)) {
        areasOfConcernMap.put(selectedAreaOfConcernCode, selectedAreaOfConcernCode);
      }
      state.setAttribute("selectedAreaOfConcernCode", selectedAreaOfConcernCode, request);
      state.setAttribute("areasOfConcernMap", areasOfConcernMap, request);
      state.setAttribute("familyPlanItemBeanMap", familyPlanItemBeanMap, request);
      state.setAttribute(FAMILY_PLAN_ITEM_BEAN_KEY, selectedItemBean, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Displays the Family Plan Item Detail page.
   * 
   * @param familyPlanItemBean
   */
  private FamilyPlanItemValueBean addEmptyTaskIfNeeded(FamilyPlanItemValueBean familyPlanItemBean) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addTaskIfNeeded()");
    performanceTrace.enterScope();

    // If the item has no tasks/services, add an empty one for display
    // purposes on the JSP.
    List<FamilyPlanTaskValueBean> tasksVector = (List<FamilyPlanTaskValueBean>) familyPlanItemBean.getTasks();
    if (tasksVector == null || tasksVector.size() == 0) {
      tasksVector = new ArrayList<FamilyPlanTaskValueBean>();
      FamilyPlanTaskValueBean newTaskBean = new FamilyPlanTaskValueBean();
      tasksVector.add(0, newTaskBean);
      familyPlanItemBean.setTasks(tasksVector);
    }

    performanceTrace.exitScope();
    return familyPlanItemBean;
  }

  /**
   * Displays the Family Plan Goals page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayFamilyPlanGoals_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFamilyPlanGoals_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanItemValueBean itemBeanFromState = (FamilyPlanItemValueBean) state
                                                                                 .getAttribute(
                                                                                               FAMILY_PLAN_ITEM_BEAN_KEY,
                                                                                               request);
      FamilyPlanItemValueBean itemBeanFromRequest = createFamilyPlanItemValueBean(request);
      itemBeanFromRequest.setIdentifiedInRiskAssessment(itemBeanFromState.isIdentifiedInRiskAssessment());
      state.setAttribute(FAMILY_PLAN_ITEM_BEAN_KEY, itemBeanFromRequest, request);

      // Build a goals to area of concern HashMap. The key of the HashMap will
      // be the area of concern code, and the value will be a Vector containing
      // the codes of the goals (from CSPGOLLD) that apply to that area of
      // concern.
      // --------------------
      // Use the family plan items in the family plan bean in state to obtain
      // the list of area of concern codes, and start building the HashMap. The
      // goals Vector will be empty at this point.
      Map<String, List<String>> goalsToAreaOfConcernHashMap = new HashMap<String, List<String>>();
      FamilyPlanValueBean familyPlanBean = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY, request);
      List familyPlanItems = (List) familyPlanBean.getFamilyPlanItemList();
      Iterator iter = familyPlanItems.iterator();
      while (iter.hasNext()) {
        FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) iter.next();
        goalsToAreaOfConcernHashMap.put(itemBean.getAreaOfConcernCode(), new ArrayList<String>());
      }

      // Populate the HashMap with the code of each goal.
      Collection goalsToAreaOfConcernCodesTable = Lookup.getCategoryCollection(CodesTables.CSPGOLAC);
      iter = goalsToAreaOfConcernCodesTable.iterator();
      while (iter.hasNext()) {
        CodeAttributes goalToAreaOfConcern = (CodeAttributes) iter.next();
        String areaOfConcernCode = goalToAreaOfConcern.getDecode();
        String goalCode = goalToAreaOfConcern.getCode();
        List<String> goalsVector = goalsToAreaOfConcernHashMap.get(areaOfConcernCode);
        goalsVector.add(goalCode);
      }
      state.setAttribute("goalsToAreaOfConcernLookup", goalsToAreaOfConcernHashMap, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Displays the Children's Permanency Goals page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayPermanencyGoals_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPermanencyGoals_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Get the status of the event being modified.
      String eventStatus = request.getParameter(EVENT_STATUS_FIELD_NAME);
      request.setAttribute(EVENT_STATUS_FIELD_NAME, eventStatus);

      FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY,
                                                                                             request);
      HashMap childrenInCaseInSubcareHashMap = familyPlanBeanFromState.getChildrenInCaseInSubcareHashmap();
      List<PersonValueBean> childrenInPlanInSubcare = new ArrayList<PersonValueBean>();
      // Create an ArrayList containing a copy of the PersonValueBean for all
      // children that are principals in the current plan and that are in
      // substitute care. The ArrayList will be used to populate the Family
      // Plan Permanency Goals JSP.
      if (familyPlanBeanFromState.getPrincipalsForEvent().size() > 0) {
        Iterator iter = familyPlanBeanFromState.getPrincipalsForEvent().iterator();
        while (iter.hasNext()) {
          PersonValueBean principalInEventBean = (PersonValueBean) iter.next();

          Boolean principalIsChildInSubcare = (Boolean) childrenInCaseInSubcareHashMap
                                                                                      .get(new Integer(
                                                                                                       principalInEventBean
                                                                                                                           .getPersonId()));

          if (principalIsChildInSubcare != null && Boolean.TRUE.equals(principalIsChildInSubcare)) {
            PersonValueBean copyOfPrincipalBean = new PersonValueBean();
            copyOfPrincipalBean.setPersonId(principalInEventBean.getPersonId());
            copyOfPrincipalBean
                               .setEventPersonLinkDateLastUpdate(principalInEventBean
                                                                                     .getEventPersonLinkDateLastUpdate());
            copyOfPrincipalBean.setFullName(principalInEventBean.getFullName());
            copyOfPrincipalBean.setPermanencyGoalCode(principalInEventBean.getPermanencyGoalCode());
            copyOfPrincipalBean.setPermanencyGoalTargetDate(principalInEventBean.getPermanencyGoalTargetDate());
            childrenInPlanInSubcare.add(copyOfPrincipalBean);
          }
        } // end while( iter.hasNext() )
      } // end if( familyPlanBean.getPrincipalsForEvent().size() > 0 )

      state.setAttribute("childrenInPlanInSubcare", childrenInPlanInSubcare, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Appends the selected family plan goals to the goals that were already entered by the worker, if there are any.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void appendFamilyPlanGoals_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".appendFamilyPlanGoals_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanItemValueBean familyPlanItemBean = (FamilyPlanItemValueBean) state
                                                                                  .getAttribute(
                                                                                                FAMILY_PLAN_ITEM_BEAN_KEY,
                                                                                                request);

      // Get any goals that were selected on the Family Plan Goals page, and
      // append them to the existing goals.
      String[] selectedGoals = CheckboxHelper.getCheckedValues(request, "cbxGoals_");
      for (int i = 0; i < selectedGoals.length; i++) {
        familyPlanItemBean.setGoals(familyPlanItemBean.getGoals() + "\n" + "- " + selectedGoals[i]);
      }

      familyPlanItemBean = addEmptyTaskIfNeeded(familyPlanItemBean);

      state.setAttribute(FAMILY_PLAN_ITEM_BEAN_KEY, familyPlanItemBean, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Takes the user to the Risk Assessment Detail page and loads the most recent risk assessment from the investigation
   * stage that led to the creation of this stage.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayRiskAssmt_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayRiskAssmt_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanValueBean familyPlanBean = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY, request);
      /*if (familyPlanBean.getRiskAssessmentEventId() > 0) {
        CaseUtility.Event riskAssmtEvent = CaseUtility.getEvent(familyPlanBean.getRiskAssessmentEventId());
        GlobalData.setUlIdEvent(riskAssmtEvent.getIdEvent(), request);
        GlobalData.setSzCdTask(RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE, request);
        // GlobalData.setSzCdStage(CodesTables.CSTAGES_FPR, request);

      } else { // willl display INV Risk Assessment or first Risk Assessment completed in ONG accordingly
        EventValueBean riskAssmtEvent = familyPlan.getRiskAssmtEvent(familyPlanBean);
        GlobalData.setUlIdStage(riskAssmtEvent.getStageId(), request);
        GlobalData.setUlIdEvent(riskAssmtEvent.getEventId(), request);
        GlobalData.setSzCdTask(RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE, request);
        CaseUtility.Stage stageRiskAssmt = CaseUtility.getStage(riskAssmtEvent.getStageId());
        GlobalData.setSzCdStage(stageRiskAssmt.getCdStage(), request);
      }*/
      EventValueBean riskAssmtEvent;
      int idEventCurrentRa = familyPlanBean.getRiskAssessmentEventId();
      if (idEventCurrentRa > 0) {
        riskAssmtEvent = familyPlan.queryEvent(idEventCurrentRa);
      } else { // page before save; willl display INV Risk Assessment or first Risk Assessment completed in ONG accordingly
        riskAssmtEvent = familyPlan.getRiskAssmtEvent(familyPlanBean); // query initial RA
      }
      GlobalData.setUlIdStage(riskAssmtEvent.getStageId(), request);
      GlobalData.setUlIdEvent(riskAssmtEvent.getEventId(), request);
      GlobalData.setSzCdTask(riskAssmtEvent.getEventTaskCode(), request);
      GlobalData.setSzCdStage(riskAssmtEvent.getStageCode(), request);
  
     
      /*EventValueBean riskAssmtEvent = familyPlan.getRiskAssmtEvent(familyPlanBean); 
      boolean displayInvRa = (riskAssmtEvent.getEventId() == familyPlanBean.getRiskAssessmentEventId()) || (0 == familyPlanBean.getRiskAssessmentEventId());
      GlobalData.setUlIdStage(riskAssmtEvent.getStageId(), request);
      GlobalData.setUlIdEvent(riskAssmtEvent.getEventId(), request);
      if (CodesTables.CSTAGES_INV.equals(familyPlanBean.getCdStagePrior()) && !familyPlanBean.isConvertedOng() && displayInvRa) {
        GlobalData.setSzCdStage(CodesTables.CSTAGES_INV, request);
        GlobalData.setSzCdTask(RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE, request);
      } else {
        GlobalData.setUlIdEvent(familyPlanBean.getRiskAssessmentEventId(), request);
        GlobalData.setUlIdStage(familyPlanBean.getStageId(), request);
        GlobalData.setSzCdStage(CodesTables.CSTAGES_FPR, request);
        GlobalData.setSzCdTask(RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE, request);
      }*/
      
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Saves the family plan. Then returns the user to the Family Plan Detail page where the newly saved family plan
   * details will be displayed.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveFamilyPlan_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFamilyPlan_xa()");
    performanceTrace.enterScope();
    saveFamilyPlan(context, SAVE_FAMILY_PLAN);
    performanceTrace.exitScope();
  }

  /**
   * Saves the family plan. Then takes the user to the To-Do Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveAndSubmitFamilyPlan_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitFamilyPlan_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    boolean isValid;
    try {
      saveFamilyPlan(context, SAVE_AND_SUBMIT_FAMILY_PLAN);
      isValid = validateFamilyPlan(context);

      // If the validation passed, send the user to the To-Do Detail page;
      // otherwise, send them back to the Family Plan Detail page.
      if (isValid) {
        String approvalTaskCode = null;
        if (GlobalData.getSzCdTask(request).equals(FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN)
            || GlobalData.getSzCdTask(request).equals(FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN_EVAL)) {
          approvalTaskCode = FamilyPlanValueBean.CD_TASK_FPR_APPRV_FAM_PLAN;
        } else if (GlobalData.getSzCdTask(request).equals(FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN)
                   || GlobalData.getSzCdTask(request).equals(FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN_EVAL)) {
          approvalTaskCode = FamilyPlanValueBean.CD_TASK_FRE_APPRV_FAM_PLAN;
        } else if (GlobalData.getSzCdTask(request).equals(FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN)
                   || GlobalData.getSzCdTask(request).equals(FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN_EVAL)) {
          approvalTaskCode = FamilyPlanValueBean.CD_TASK_FSU_APPRV_FAM_PLAN;
        }

        ToDoDetailDB toDoDetailDb = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                     GlobalData.getUlIdStage(request), approvalTaskCode);

        ToDoHelper.setToDoDetailDB(toDoDetailDb, request, state);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Saves the family plan item details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveFamilyPlanItem_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFamilyPlanItem_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY,
                                                                                             request);
      FamilyPlanItemValueBean itemBeanFromRequest = createFamilyPlanItemValueBean(request);
      familyPlan.saveFamilyPlanItem(familyPlanBeanFromState, itemBeanFromRequest);
      // Put an indicator into the request telling the Family Plan Detail page
      // to anchor to the Family Plan Item List section.
      request.setAttribute("goToFamilyPlanItemList", true);
    } catch (TimestampMismatchException tme) {
      setPresentationBranch("error", context);
      setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
    } catch (ServiceException we) {
      setPresentationBranch("error", context);
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Saves the family plan item details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  @SuppressWarnings( { "unchecked" })
  public void savePermanencyGoals_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePermanencyGoals_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY,
                                                                                             request);
      List<PersonValueBean> childrenInPlanFromState = (List<PersonValueBean>) state
                                                                                   .getAttribute(
                                                                                                 "childrenInPlanInSubcare",
                                                                                                 request);
      List<PersonValueBean> childrenInPlanFromRequest = new ArrayList<PersonValueBean>();

      // Get the new/updated permanency goal for each child in the current plan
      // that is in substitute care, create a PersonValueBean with the child's
      // data, and the bean to an ArrayList that will be sent to the EJB.
      if (childrenInPlanFromState.size() > 0) {
        Iterator iter = childrenInPlanFromState.iterator();
        while (iter.hasNext()) {
          PersonValueBean personBeanFromState = (PersonValueBean) iter.next();
          int personId = personBeanFromState.getPersonId();

          PersonValueBean personBeanFromRequest = new PersonValueBean();
          personBeanFromRequest.setPersonId(personId);
          personBeanFromRequest
                               .setEventPersonLinkDateLastUpdate(personBeanFromState.getEventPersonLinkDateLastUpdate());

          // Get the Permanency Goal. The child's person id was used in the
          // Permanency Goal field name so that the field names would be unique
          // and easily associated with the child.
          String fieldName = "selPermGoal" + String.valueOf(personId);
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            personBeanFromRequest.setPermanencyGoalCode(ContextHelper.getStringSafe(request, fieldName));
          }

          // Get the Target Date. The child's person id was used in the Target
          // Date field name so that the field names would be unique and easily
          // associated with the child.
          fieldName = "txtTargetDate" + String.valueOf(personId);
          if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
            personBeanFromRequest.setPermanencyGoalTargetDate(ContextHelper.getCastorDateSafe(request, fieldName));
          }
          childrenInPlanFromRequest.add(personBeanFromRequest);
        } // end while( iter.hasNext() )
      } // end if( childrenInPlanFromState.size() > 0 )

      // Get the Permanency Goals Comment field.
      String goalsCommentFromRequest = null;
      String fieldName = "txtPermanencyGoalsComment";
      if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
        goalsCommentFromRequest = ContextHelper.getStringSafe(request, fieldName);
      }

      // Save the info.
      familyPlan.savePermanencyGoals(familyPlanBeanFromState, goalsCommentFromRequest, childrenInPlanFromState,
                                     childrenInPlanFromRequest);
    } catch (TimestampMismatchException tme) {
      setPresentationBranch("error", context);
      setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
    } catch (ServiceException we) {
      setPresentationBranch("error", context);
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Validates the family plan. Then takes the user to the Approval Status page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void validateAndGoToApprovalStatus_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateAndGoToApprovalStatus_xa()");
    performanceTrace.enterScope();

    try {
      validateFamilyPlan(context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /* RIOSJA, SIR 14974 */

  /**
   * Validates the family plan to ensure that permanency goals were entered for all children in the plan for FSU stages.
   * Also ensures that "Interpreter/Translator" services are properly recorded on the Services and Referrals Checklist
   * if a principal in the plan is hearing impaired or has limited English proficiency.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private boolean validateFamilyPlan(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFamilyPlan()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    boolean isValid = true;

    try {
      FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY,
                                                                                             request);

      // Retrieve the newly saved data from the database to perform the
      // validation using the most recent data.
      FamilyPlanValueBean familyPlanBean = familyPlan.queryFamilyPlan(familyPlanBeanFromState);
      state.setAttribute(FAMILY_PLAN_BEAN_KEY, familyPlanBean, request);

      boolean isValidPermGoals = checkPermanencyGoals(familyPlanBean);
      if (!isValidPermGoals) {
        // SIR 22662 avoids the message for approved plans
        String eventStatus = request.getParameter(EVENT_STATUS_FIELD_NAME);
        if (!CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
          // Use addErrorMessage() instead of setErrorMessage() because
          // addErrorMessage() does not set the flag that reloads the JSP
          // with the old data. Since we have already performed the save, we
          // want the page to load with the newly saved data and timestamps.
          addErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_FP_PERM_GOAL_REQ), request);
          setPresentationBranch("error", context);
          isValid = false;
        }
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return isValid;
  }


  /**
   * Validates the family plan to ensure that permanency goals were entered for all children in the plan for FSU stages.
   * 
   * @param familyPlanBean
   */
  private boolean checkPermanencyGoals(FamilyPlanValueBean familyPlanBean) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".checkPermanencyGoals()");
    performanceTrace.enterScope();
    boolean isValid = true;

    // If the stage is FSU, all children in the plan that are in substitute
    // care must have a permanency goal. This validation is placed here and
    // not in the custom validation class because the validation needs to use
    // the most recent list of principals. If the user selected a new child
    // from the Principals on the Plan list and then clicked Save and Submit,
    // the newest list of principals is not available in the family plan bean
    // from state. This validation must query the most recent list of
    // principals from the database
    if (CodesTables.CSTAGES_FSU.equals(familyPlanBean.getStageCode())
        && familyPlanBean.getChildrenInCaseInSubcareHashmap().size() > 0) {
      HashMap childrenInCaseInSubcareHashmap = familyPlanBean.getChildrenInCaseInSubcareHashmap();
      Iterator iter = familyPlanBean.getPrincipalsForEvent().iterator();
      while (iter.hasNext()) {
        PersonValueBean principalInEventBean = (PersonValueBean) iter.next();

        Boolean principalIsChildInSubcare = (Boolean) childrenInCaseInSubcareHashmap
                                                                                    .get(new Integer(
                                                                                                     principalInEventBean
                                                                                                                         .getPersonId()));

        if (Boolean.TRUE.equals(principalIsChildInSubcare)
            && (principalInEventBean.getPermanencyGoalCode() == null
                || "".equals(principalInEventBean.getPermanencyGoalCode())
                || principalInEventBean.getPermanencyGoalTargetDate() == null || null == principalInEventBean
                                                                                                             .getPermanencyGoalTargetDate())) {
          isValid = false;
          break;
        }
      } // end while( iter.hasNext() )
    } // end if( CodesTables.CSTAGES_FSU.equals( familyPlanBeanFromState.getStageCode() ) &&...

    performanceTrace.exitScope();
    return isValid;
  }

  /** Constructor that builds the bean from an HttpServletRequest */
  public static FamilyPlanValueBean createFamilyPlanValueBean(HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    FamilyPlanValueBean familyPlanValueBean = new FamilyPlanValueBean();
    // Create the field names to be retrieved from the request.
    String caseIdField = "hdnCaseId";
    String stageIdField = "hdnStageId";
    String dateStageStartedField = "hdnDateStageStarted"; /* RIOSJA, SIR 19002 */
    String familyPlanIdField = "hdnFamilyPlanId";
    String familyPlanDateLastUpdateField = "hdnFamilyPlanDateLastUpdate";
    String stageCodeField = "hdnStageCode";
    String stageTypeCodeField = "hdnStageTypeCode";
    String stageNameField = "hdnStageName";
    String planTypeCodeField = "hdnPlanTypeCode";
    String principalsOnPlanField = "cbxPrincipalsOnPlan";
    String datePlanCompletedField = "txtDatePlanCompleted";
    String datePlanPreparedField = "txtDatePlanPrepared";
    String dateNextReviewDueField = "txtDateNextReviewDue";
    String dateCurrentReviewCompletedField = "txtDateReviewedWithFamily";
    String explanationOfClientNonParticipationField = "txtExplanationOfClientNonParticipation";
    String clientCommentsField = "cbxClientComments";
    String reasonForCPSInvolvementField = "txtReasonForInvolvement";
    String strengthsResourcesField = "txtStrengthsResources";
    String familyPlanEvalEventIdField = "hdnFamilyPlanEvalEventIdField";
    String familyPlanEvalEventDateLastUpdateField = "hdnFamilyPlanEvalEventDateLastUpdateField";
    String familyPlanEvalIdField = "hdnFamilyPlanEvalIdField";
    String familyPlanEvalDateLastUpdateField = "hdnFamilyPlanEvalDateLastUpdateField";
    String primaryWorkerIdField = "hdnPrimaryWorkerId";
    // GA Shines
    String cdOutcome = "selSzCdOutcome";
    String courtOrderCheckbox = "cbxCourtOrdered";
    String hdnIsUpdatedPlan = "hdnIsUpdatedPlan";

    // Get the following fields which should never be empty.
    familyPlanValueBean.setCaseId(ContextHelper.getIntSafe(request, caseIdField));
    familyPlanValueBean.setStageId(ContextHelper.getIntSafe(request, stageIdField));
    familyPlanValueBean.setFamilyPlanId(ContextHelper.getIntSafe(request, familyPlanIdField));
    familyPlanValueBean.setPlanTypeCode(ContextHelper.getString(request, planTypeCodeField));
    familyPlanValueBean.setStageCode(ContextHelper.getStringSafe(request, stageCodeField));
    familyPlanValueBean.setStageTypeCode(ContextHelper.getStringSafe(request, stageTypeCodeField));
    familyPlanValueBean.setStageName(ContextHelper.getStringSafe(request, stageNameField));
    familyPlanValueBean.setPrimaryWorkerId(ContextHelper.getIntSafe(request, primaryWorkerIdField));
    /* RIOSJA, SIR 19002 */
    familyPlanValueBean.setDateStageStarted(ContextHelper.getCastorDateSafe(request, dateStageStartedField));

    familyPlanValueBean.setCdOutcome(ContextHelper.getString(request, cdOutcome));
    // Get the following fields only if they are not empty.
    if (request.getParameter(familyPlanDateLastUpdateField) != null
        && !"".equals(request.getParameter(familyPlanDateLastUpdateField))) {
      familyPlanValueBean.setFamilyPlanDateLastUpdate(ContextHelper.getJavaDateSafe(request,
                                                                                    familyPlanDateLastUpdateField));
    }
    if (request.getParameter(datePlanCompletedField) != null
        && !"".equals(request.getParameter(datePlanCompletedField))) {
      familyPlanValueBean.setDatePlanCompleted(ContextHelper.getCastorDateSafe(request, datePlanCompletedField));
    }
    if (request.getParameter(datePlanPreparedField) != null && !"".equals(request.getParameter(datePlanPreparedField))) {
      familyPlanValueBean.setDatePlanPrepared(ContextHelper.getCastorDateSafe(request, datePlanPreparedField));
    }
    if (request.getParameter(dateNextReviewDueField) != null
        && !"".equals(request.getParameter(dateNextReviewDueField))) {
      familyPlanValueBean.setDateNextEvalDue(ContextHelper.getCastorDateSafe(request, dateNextReviewDueField));
    }
    if (request.getParameter(dateCurrentReviewCompletedField) != null
        && !"".equals(request.getParameter(dateCurrentReviewCompletedField))) {
      familyPlanValueBean.setDateCurrentEvalCompleted(ContextHelper.getCastorDateSafe(request,
                                                                                      dateCurrentReviewCompletedField));
    }
    if (request.getParameter(explanationOfClientNonParticipationField) != null
        && !"".equals(request.getParameter(explanationOfClientNonParticipationField))) {
      familyPlanValueBean
                         .setExplanationOfClientNonParticipation(ContextHelper
                                                                              .getStringSafe(request,
                                                                                             explanationOfClientNonParticipationField));
    }
    if (request.getParameter(reasonForCPSInvolvementField) != null
        && !"".equals(request.getParameter(reasonForCPSInvolvementField))) {
      familyPlanValueBean
                         .setReasonForCPSInvolvement(ContextHelper.getStringSafe(request, reasonForCPSInvolvementField));
    }
    if (request.getParameter(strengthsResourcesField) != null
        && !"".equals(request.getParameter(strengthsResourcesField))) {
      familyPlanValueBean.setStrengthsAndResources(ContextHelper.getStringSafe(request, strengthsResourcesField));
    }

    // Determine whether or not the "Client comments" checkbox is checked.
    String[] checkedClientComments = CheckboxHelper.getCheckedValues(request, clientCommentsField);
    if (checkedClientComments.length > 0) {
      familyPlanValueBean.setClientGaveComments(true);
    }
    // Get the following fields only if they are not empty.
    // Determine whether or not the "Court Ordered" checkbox is checked.
    String checkboxValue = CheckboxHelper.getCheckboxValue(request, courtOrderCheckbox);
    if (ArchitectureConstants.Y.equals(checkboxValue)) {
      familyPlanValueBean.setIndCourtOrdered(true);
    }
    boolean isUpdatedPlan = ContextHelper.getBooleanSafe(request, hdnIsUpdatedPlan);
    if (Sets.isInSet(Sets.E, request) || isUpdatedPlan) {
      familyPlanValueBean.setIsUpdatedPlan(true);
    }

    // Create a PersonValueBean for each principal that is selected in the
    // 'Principals on Plan' listbox, and add the bean to the 'principalsForEvent'
    // collection.
    List<PersonValueBean> principalsForEventVector = new ArrayList<PersonValueBean>();
    String[] checkedPrincipals = CheckboxHelper.getCheckedValues(request, principalsOnPlanField);
    for (int i = 0; i < checkedPrincipals.length; i++) {
      PersonValueBean personBean = new PersonValueBean();
      personBean.setPersonId(new Integer(checkedPrincipals[i]));
      principalsForEventVector.add(personBean);
    }
    familyPlanValueBean.setPrincipalsForEvent(principalsForEventVector);

    // Get the evaluation fields if they are not empty.
    if (request.getParameter(familyPlanEvalEventIdField) != null
        && !"".equals(request.getParameter(familyPlanEvalEventIdField))) {
      FamilyPlanEvalValueBean mostRecentEval = new FamilyPlanEvalValueBean();
      EventValueBean mostRecentEvalEvent = new EventValueBean();
      mostRecentEvalEvent.setCaseId(familyPlanValueBean.getCaseId());
      mostRecentEvalEvent.setStageId(familyPlanValueBean.getStageId());
      mostRecentEvalEvent.setEventId(ContextHelper.getIntSafe(request, familyPlanEvalEventIdField));
      mostRecentEvalEvent.setDateLastUpdate(ContextHelper.getJavaDateSafe(request,
                                                                          familyPlanEvalEventDateLastUpdateField));
      mostRecentEval.setCaseId(familyPlanValueBean.getCaseId());
      mostRecentEval.setFamilyPlanEventId(familyPlanValueBean.getFamilyPlanEvent().getEventId());
      mostRecentEval.setStageId(familyPlanValueBean.getStageId());
      mostRecentEval.setEvalId(ContextHelper.getIntSafe(request, familyPlanEvalIdField));
      mostRecentEval.setEvalDateLastUpdate(ContextHelper.getJavaDateSafe(request, familyPlanEvalDateLastUpdateField));
      mostRecentEval.setEvalEvent(mostRecentEvalEvent);
      List<FamilyPlanEvalValueBean> evalsVector = new ArrayList<FamilyPlanEvalValueBean>();
      evalsVector.add(mostRecentEval);
      familyPlanValueBean.setFamilyPlanEvaluations(evalsVector);
    }

    GrndsTrace.exitScope();
    return familyPlanValueBean;
  }

  /**
   * Saves the family plan.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void saveFamilyPlan(GrndsExchangeContext context, String action) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFamilyPlan");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String pageMode = PageMode.getPageMode(request);
    boolean isNewUsing = PageModeConstants.NEW_USING.equals(pageMode);
    boolean isUpdated = Sets.isInSet(Sets.E, request);

    try {
      FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute(FAMILY_PLAN_BEAN_KEY,
                                                                                             request);
      FamilyPlanValueBean familyPlanBeanFromRequest = createFamilyPlanValueBean(request);
      if (!(Sets.isInSet(Sets.E, request)) && !(Sets.isInSet(Sets.N, request))) { // either ADD or hyperlinked
        familyPlanBeanFromRequest.setFamilyPlanEvent(familyPlanBeanFromState.getFamilyPlanEvent());
      }
      familyPlanBeanFromRequest.setUserId(familyPlanBeanFromState.getUserId());
      familyPlanBeanFromRequest.setCaseId(familyPlanBeanFromState.getCaseId());
      familyPlanBeanFromRequest.setFamilyPlanItemList(familyPlanBeanFromState.getFamilyPlanItemList());
      // Set the "is approval mode" indicators. If the supervisor accesses a
      // pending family plan after navigating a stage closure approval todo
      // and they save changes, we want to invalidate the pending family plan.
      // This will enable the supervisor to close the stage without leaving a
      // pending family plan. This will no longer be an issue if SIR 19659 is
      // accepted and implemented.
      familyPlanBeanFromRequest.setIsApprovalMode(GlobalData.isApprovalMode(request));
      familyPlanBeanFromRequest.setIsApprovalModeForStageClosure(GlobalData.isStageClosureBeingApproved(request));
      familyPlanBeanFromState.setIsApprovalMode(GlobalData.isApprovalMode(request));
      familyPlanBeanFromState.setIsApprovalModeForStageClosure(GlobalData.isStageClosureBeingApproved(request));

      /*
       * if (familyPlanBeanFromState.getFamilyPlanEvaluations() != null) {
       * familyPlanBeanFromRequest.setFamilyPlanEvaluations(familyPlanBeanFromState.getFamilyPlanEvaluations()); }
       */
      
      //STGAP00010574 - if saveAndSubmit button has been pressed, remove maps and saveButton from state/request 
      //and if save button is pressed, add save attribute to request
      if (SAVE_AND_SUBMIT_FAMILY_PLAN.equals(action)) {
        familyPlanBeanFromRequest.setIsSaveAndSubmit(true);
        state.removeAttribute("areasOfConcernMap", request);
        state.removeAttribute("familyPlanItemBeanMap",request);
        request.removeAttribute("Save.x");
      }
      if(SAVE_FAMILY_PLAN.equals(action)){
        request.setAttribute("Save.x", 1);
      }

      // if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
      if ((Sets.isInSet(Sets.E, request)) || (Sets.isInSet(Sets.N, request))) {
        familyPlanBeanFromRequest.getFamilyPlanEvent().setEventId(0);
        familyPlanBeanFromRequest.getFamilyPlanEvent().setEventStatusCode("PROC");
        familyPlanBeanFromRequest.getFamilyPlanEvent().setCaseId(
                                                                 familyPlanBeanFromState.getFamilyPlanEvent()
                                                                                        .getCaseId());
        familyPlanBeanFromRequest.getFamilyPlanEvent()
                                 .setCreatorsFirstName(
                                                       familyPlanBeanFromState.getFamilyPlanEvent()
                                                                              .getCreatorsFirstName());
        familyPlanBeanFromRequest.getFamilyPlanEvent()
                                 .setCreatorsLastName(
                                                      familyPlanBeanFromState.getFamilyPlanEvent()
                                                                             .getCreatorsLastName());
        familyPlanBeanFromRequest.getFamilyPlanEvent().setEventTypeCode(
                                                                        familyPlanBeanFromState.getFamilyPlanEvent()
                                                                                               .getEventTypeCode());
        familyPlanBeanFromRequest.getFamilyPlanEvent().setPersonId(
                                                                   familyPlanBeanFromState.getFamilyPlanEvent()
                                                                                          .getPersonId());
        familyPlanBeanFromRequest.getFamilyPlanEvent().setStageId(
                                                                  familyPlanBeanFromState.getFamilyPlanEvent()
                                                                                         .getStageId());
        familyPlanBeanFromRequest.getFamilyPlanEvent()
                                 .setDateEventOccurred(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
        familyPlanBeanFromState.setFamilyPlanId(0);
        // A plan which is updated from a copied plan will have IND_UPDATE_PLAN = true and IND_COPIED_PLAN = true.
        // However, a plan which was copied from an approved updated plan will only have IND_COPIED_PLAN = true.
        if ((Sets.isInSet(Sets.E, request))) {
          familyPlanBeanFromRequest.setIsUpdatedPlan(true);
        } else if (Sets.isInSet(Sets.N, request)) {
          familyPlanBeanFromRequest.setIsUpdatedPlan(false);
          familyPlanBeanFromRequest.setCopiedPlan(true);

        }
        familyPlanBeanFromRequest.getFamilyPlanEvent().setEventTaskCode(FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN);

      }
      Integer eventId = familyPlan.saveFamilyPlan(familyPlanBeanFromState, familyPlanBeanFromRequest);
      // Set the PageMode to EDIT in case it was NEW before the save.
      PageMode.setPageMode(PageModeConstants.EDIT, request);

      // Put the family plan event id into GlobalData in case this was a new
      // family plan.
      GlobalData.setUlIdEvent(eventId, request);
    } catch (TimestampMismatchException tme) {
      setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Helper method that handles all the WTC Exceptions.
   * 
   * @param we
   *          WtcException
   * @param context
   *          The GrndsExchangeContext object.
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
    case Messages.MSG_SVC_FAMILY_PLAN_ADD_VALID:  
      setErrorMessage(errorCode, request);
      break;

    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
  }

  /**
   * Returns the most recent approval date for the family plan.
   * 
   * @param familyPlanBean
   *          The FamilyPlanValueBean containing the family plan details.
   * @return mostRecentApprovalDate The most recent approval date for the family plan.
   */
  protected static Date getMostRecentApprovalDate(FamilyPlanValueBean familyPlanBean) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getMostRecentApprovalDate()");
    performanceTrace.enterScope();

    // ---------------------
    // Get the most recent approval date, if there is one. It will either be
    // the approval date of the family plan or the approval date of the most
    // recently approved evaluation. Evaluations are stored in the family plan
    // bean from most recent to oldest; therefore, the first one that has an
    // approval date will be the most recently approved one. (We will actually
    // use the DT_LAST_UPDATE of the most recently approved event. Once an event
    // is approved, the row is never again updated, so DT_LAST_UPDATE can serve
    // as the approval date. Unfortunately, DT_APPROVAL_DATE on the APPROVAL
    // table is never populated with the date the event is approved, so it's not
    // availabe for us to use.)
    Date mostRecentApprovalDate = null;
    if (CodesTables.CEVTSTAT_APRV.equals(familyPlanBean.getFamilyPlanEvent().getEventStatusCode())) {
      mostRecentApprovalDate = familyPlanBean.getFamilyPlanEvent().getDateLastUpdate();
    }

    performanceTrace.exitScope();
    return mostRecentApprovalDate;
  }

  /**
   * Calls Output Launch Retrieve service to check for a visitation plan.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private boolean checkForVisitationPlan(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".checkForVisitationPlan");

    HttpServletRequest request = context.getRequest();
    boolean bVisitationPlanExists = false;

    try {
      String englishVisitationPlanTaskCode = null;
      String spanishVisitationPlanTaskCode = null;
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FPR)) {
        englishVisitationPlanTaskCode = FamilyPlanValueBean.CD_TASK_FPR_VISITATION_PLAN_ENGLISH;
        spanishVisitationPlanTaskCode = FamilyPlanValueBean.CD_TASK_FPR_VISITATION_PLAN_SPANISH;
      } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FRE)) {
        englishVisitationPlanTaskCode = FamilyPlanValueBean.CD_TASK_FRE_VISITATION_PLAN_ENGLISH;
        spanishVisitationPlanTaskCode = FamilyPlanValueBean.CD_TASK_FRE_VISITATION_PLAN_SPANISH;
      } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FSU)) {
        englishVisitationPlanTaskCode = FamilyPlanValueBean.CD_TASK_FSU_VISITATION_PLAN_ENGLISH;
        spanishVisitationPlanTaskCode = FamilyPlanValueBean.CD_TASK_FSU_VISITATION_PLAN_SPANISH;
      }

      // Use CaseUtility to get the most recent English visitation plan event
      // for the stage.
      CaseUtility.Event mostRecentEnglishVisitationPlanEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request),
                                                                                    englishVisitationPlanTaskCode);

      if (mostRecentEnglishVisitationPlanEvent.getIdEvent() > 0) {
        EventValueBean englishVisitationPlanEventInfo = new EventValueBean();
        englishVisitationPlanEventInfo.setStageId(GlobalData.getUlIdStage(request));
        englishVisitationPlanEventInfo.setEventId(mostRecentEnglishVisitationPlanEvent.getIdEvent());
        englishVisitationPlanEventInfo.setEventTaskCode(englishVisitationPlanTaskCode);
        // Query the database to see if the document exists.
        try {
          CSUB59SI csub59si = populateCSUB59SI_Retrieve(englishVisitationPlanEventInfo);
          CSUB59SO csub59so = CSUB59SO.unmarshal(new StringReader(WtcHelper.callService("CSUB59S", csub59si)));
          if (csub59so.getTsLastUpdate() != null) {
            bVisitationPlanExists = true;
          }
        } catch (ServiceException we) {
          // If a "No Rows Returned" WtcException is thrown by the service call,
          // then the English visitation plan document does not exist.
          if (we.getErrorCode() == Messages.MSG_NO_ROWS_RETURNED) {
            bVisitationPlanExists = false;
          } else {
            throw we;
          }
        }
      } // if (mostRecentEnglishVisitationPlanEvent.getIdEvent() > 0)

      // if the English visitation plan document does not exist, check for a
      // Spanish visitation plan.
      if (!bVisitationPlanExists) {
        // Use CaseUtility to get the most recent Spanish visitation plan event
        // for the stage.
        CaseUtility.Event mostRecentSpanishVisitationPlanEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request),
                                                                                      spanishVisitationPlanTaskCode);

        if (mostRecentSpanishVisitationPlanEvent.getIdEvent() > 0) {
          EventValueBean spanishVisitationPlanEventInfo = new EventValueBean();
          spanishVisitationPlanEventInfo.setStageId(GlobalData.getUlIdStage(request));
          spanishVisitationPlanEventInfo.setEventId(mostRecentSpanishVisitationPlanEvent.getIdEvent());
          spanishVisitationPlanEventInfo.setEventTaskCode(spanishVisitationPlanTaskCode);
          // Query the database to see if the document exists.
          try {
            CSUB59SI csub59si = populateCSUB59SI_Retrieve(spanishVisitationPlanEventInfo);
            CSUB59SO csub59so = CSUB59SO.unmarshal(new StringReader(WtcHelper.callService("CSUB59S", csub59si)));
            if (csub59so.getTsLastUpdate() != null) {
              bVisitationPlanExists = true;
            }
          } catch (ServiceException we) {
            // If a "No Rows Returned" WtcException is thrown by the service call,
            // then the English visitation plan document does not exist.
            if (we.getErrorCode() == Messages.MSG_NO_ROWS_RETURNED) {
              bVisitationPlanExists = false;
            } else {
              throw we;
            }
          }
        } // end if (mostRecentEnglishVisitationPlanEvent.getIdEvent() > 0)
      } // end if (!bVisitationPlanExists)
    } catch (Exception e) {
      processSevereException(context, e);
    }
    GrndsTrace.exitScope();
    return bVisitationPlanExists;
  }

  /* RIOSJA, SIR 14974 */

  /**
   * Helper method called to populate the input object for the Services and Referrals Checklist retrieve service.
   * 
   * @param context
   *          container for request, session and state
   * @return CINV54SI object
   */
  private CINV54SI populateCINV54SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV54SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CINV54SI cinv54si = new CINV54SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(25);

    String taskCode = INV_CHECKLIST_TASK_CODE;
    if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FPR_CHECKLIST_TASK_CODE;
    } else if (CodesTables.CSTAGES_FRE.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FRE_CHECKLIST_TASK_CODE;
    } else if (CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FSU_CHECKLIST_TASK_CODE;
    }

    int idEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request), taskCode).getIdEvent();
    cinv54si.setUlIdEvent(idEvent);
    cinv54si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv54si.setArchInputStruct(input);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv54si;
  }

  /**
   * Helper method called to populate the input object for the Output Launch Retrieval service (CSUB59S).
   * 
   * @param visitationEventInfo
   *          Object containing the visitation event details.
   */
  private CSUB59SI populateCSUB59SI_Retrieve(EventValueBean visitationEventInfo) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB59SI_Retrieve()");
    performanceTrace.enterScope();

    CSUB59SI csub59si = new CSUB59SI();
    ArchInputStruct input = new ArchInputStruct();

    csub59si.setUlIdStage(visitationEventInfo.getStageId());
    csub59si.setUlIdEvent(visitationEventInfo.getEventId());
    csub59si.setSzCdTask(visitationEventInfo.getEventTaskCode());

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);

    csub59si.setArchInputStruct(input);

    performanceTrace.exitScope();
    return csub59si;
  }

 
  private void resetCurrentScaleOfconcern(FamilyPlanValueBean familyPlanBean) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".resetCurrentScaleOfconcern()");
    performanceTrace.enterScope();
    
    for (Iterator itemListItr = familyPlanBean.getFamilyPlanItemList().iterator(); itemListItr.hasNext(); ) {
      ((FamilyPlanItemValueBean)itemListItr.next()).setCurrentLevelOfConcernScale("");
    }
    familyPlanBean.getFamilyPlanItemList();
    performanceTrace.exitScope();
  }
  
}
