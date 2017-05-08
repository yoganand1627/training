
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskFactorValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanTaskValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RiskAssmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

/**
 * Handles all Family Plan procedures and operations.
 * 
 * <pre>
 *               Change History:
 *               Date      User        Description
 *               --------  ----------  -----------------------------------------------------
 *               06/22/04  RIOSJA      SIR 22909 - For family plan evals, add the event id of the family plan being evaluated to the
 *                                     eval event description.
 *               06/23/04  RIOSJA      SIR 19002 -  Workers can now create an evaluation in one stage for a family plan that was
 *                                     created in another stage within the same progression of stages (stages that originate from
 *                                     the same INV stage). Since the plan type is determined based upon the stage of service in
 *                                     which the plan or eval is created, we need to determine the new plan type so that it can be
 *                                     saved to the database.
 *               07/01/04  RIOSJA      SIR 14974 - Check if any of the principals in the plan have person characteristics of
 *                                     'Limited English Proficiency' or 'Hearing Impaired', and set the
 *                                     isInterpreterTranslatorNeeded property of the family plan bean accordingly.
 *               05/16/08  SSUBRAM     STGAP00006386: ONG Family Plan: user should not be able to add a plan if there is an 
 *                                     unfinished existing plan 
 * </pre>
 */
@SuppressWarnings("serial")
public class FamilyPlanBean extends BaseServiceEjb {
  // static constants
  public static final String TRACE_TAG = "FamilyPlanBean";

  private CheckStageEventStatus checkStageEventStatus = null;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;

  public FamilyPlanBean() {
  }

  public void onEjbCreate() {
    // Other services.
    this.checkStageEventStatus = getService(CheckStageEventStatus.class);
    this.invalidateApproval = getService(InvalidateApproval.class);
    this.postEvent = getService(PostEvent.class);
  }

  /**
   * Deletes an entire Family Plan Item. Restores an item to its original state as if the item had never been addressed.
   * 
   * @param familyPlanBeanFromState
   *          FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param itemBeanFromRequest
   *          FamilyPlanItemValueBean containing the family plan item details to be saved to the database.
   * @throws TimestampMismatchException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  public void deleteFamilyPlanItem(FamilyPlanValueBean familyPlanBeanFromState,
                                   FamilyPlanItemValueBean itemBeanFromRequest) throws TimestampMismatchException,
                                                                               ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteFamilyPlanItem");

    Connection connection = null;

    try {
      connection = getConnection();

      // Get the most recent event for the family plan. It will either be the
      // family plan event (if it has not been approved), or it will be the
      // most recent family plan evaluation event.
      EventValueBean mostRecentEvent;
      if (!CodesTables.CEVTSTAT_APRV.equals(familyPlanBeanFromState.getFamilyPlanEvent().getEventStatusCode())) {
        mostRecentEvent = familyPlanBeanFromState.getFamilyPlanEvent();
      } else {
        List familyPlanEvalsList = (List) familyPlanBeanFromState.getFamilyPlanEvaluations();
        FamilyPlanEvalValueBean mostRecentFamilyPlanEval = (FamilyPlanEvalValueBean) familyPlanEvalsList.get(0);
        mostRecentEvent = mostRecentFamilyPlanEval.getEvalEvent();
      }

      // Determine whether or not the stage is open and modifiable.
      callCheckStageEventStatus(mostRecentEvent);

      // If the event is pending approval and the user did not access the
      // family plan via an approval todo, call InvalidateApproval common
      // function to invalidate the approval and demote all related events.
      // Then call post event to demote the event itself.
      if (mostRecentEvent.getEventStatusCode() != null
          && mostRecentEvent.getEventStatusCode().equals(CodesTables.CEVTSTAT_PEND)
          && !familyPlanBeanFromState.isApprovalMode()) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(mostRecentEvent);
        invalidateApproval.invalidateApproval(ccmn05ui);

        CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(mostRecentEvent, familyPlanBeanFromState,
                                                       familyPlanBeanFromState);
        postEvent.postEvent(ccmn01ui);
      }

      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      familyPlanDao.deleteFamilyPlanItem(itemBeanFromRequest);
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException deleting family plan item");
      getSessionContext().setRollbackOnly();
      throw tme;
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      getSessionContext().setRollbackOnly();
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }

  /**
   * Deletes the selected Family Plan Task.
   * 
   * @param familyPlanBeanFromState
   *          FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param itemBeanFromRequest
   *          FamilyPlanItemValueBean containing the family plan item details to be saved to the database.
   * @param indexOfTaskToDelete
   *          The index of the task to be deleted from the database.
   * @return FamilyPlanItemValueBean The object containing the family plan item details.
   * @throws TimestampMismatchException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  public FamilyPlanItemValueBean deleteFamilyPlanTask(FamilyPlanValueBean familyPlanBeanFromState,
                                                      FamilyPlanItemValueBean itemBeanFromRequest,
                                                      int indexOfTaskToDelete) throws TimestampMismatchException,
                                                                              ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteFamilyPlanTask");

    Connection connection = null;

    try {
      List<FamilyPlanTaskValueBean> tasksList = (List<FamilyPlanTaskValueBean>) itemBeanFromRequest.getTasks();
      FamilyPlanTaskValueBean taskToDelete = tasksList.get(indexOfTaskToDelete);

      // If the task exists in the database, delete it.
      if (taskToDelete.getFamilyPlanTaskId() > 0) {
        connection = getConnection();

        // Get the most recent event for the family plan. It will either be the
        // family plan event (if it has not been approved), or it will be the
        // most recent family plan evaluation event.
        EventValueBean mostRecentEvent;
        if (!CodesTables.CEVTSTAT_APRV.equals(familyPlanBeanFromState.getFamilyPlanEvent().getEventStatusCode())) {
          mostRecentEvent = familyPlanBeanFromState.getFamilyPlanEvent();
        } else {
          List familyPlanEvalsList = (List) familyPlanBeanFromState.getFamilyPlanEvaluations();
          FamilyPlanEvalValueBean mostRecentFamilyPlanEval = (FamilyPlanEvalValueBean) familyPlanEvalsList.get(0);
          mostRecentEvent = mostRecentFamilyPlanEval.getEvalEvent();
        }

        // Determine whether or not the stage is open and modifiable.
        callCheckStageEventStatus(mostRecentEvent);

        // If the event is pending approval and the user did not access the
        // family plan via an approval todo, call InvalidateApproval common
        // function to invalidate the approval and demote all related events.
        // Then call post event to demote the event itself.
        if (CodesTables.CEVTSTAT_PEND.equals(mostRecentEvent.getEventStatusCode())
            && !familyPlanBeanFromState.isApprovalMode()) {
          CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(mostRecentEvent);
          invalidateApproval.invalidateApproval(ccmn05ui);

          CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(mostRecentEvent, familyPlanBeanFromState,
                                                         familyPlanBeanFromState);
          postEvent.postEvent(ccmn01ui);
        }

        FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
        familyPlanDao.deleteFamilyPlanTask(taskToDelete);
      }

      // Remove the task from the list of tasks for the family plan item.
      tasksList.remove(indexOfTaskToDelete);
      if (tasksList.size() == 0) {
        tasksList = null;
      }
      itemBeanFromRequest.setTasks(tasksList);
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException deleting family plan task");
      getSessionContext().setRollbackOnly();
      throw tme;
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      getSessionContext().setRollbackOnly();
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return itemBeanFromRequest;
  }

  /**
   * Retrieves the event details from the database for the given event id.
   * 
   * @param eventId
   *          The id of the event to be queried from the database.
   * @return EventValueBean The object containing the event details.
   */
  public EventValueBean queryEvent(Integer eventId) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryEvent");

    Connection connection = null;
    EventValueBean eventBean = null;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      eventBean = familyPlanDao.queryEvent(eventId);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return eventBean;
  }

  /**
   * Retrieves all family plan, family plan evaluation and family assessment events given the event id of a legacy
   * family plan, family plan evalution or family assessment.
   * 
   * @param eventId
   *          The id of the family plan event whose related events will be queried from the database.
   * @return List The list of events related to the given family plan event.
   */
  public List queryLegacyEvents(Integer eventId) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryLegacyEvents");

    Connection connection = null;
    List legacyEventsList = null;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      legacyEventsList = familyPlanDao.queryLegacyEvents(eventId);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return legacyEventsList;
  }

  /**
   * Retrieves the Family Plan details from the database.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the family plan search parameters.
   * @return FamilyPlanValueBean The object containing the family plan details.
   */
  @SuppressWarnings("unchecked")
  public FamilyPlanValueBean queryFamilyPlan(FamilyPlanValueBean familyPlanBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryFamilyPlan");

    Connection connection = null;
    Collection principalsForStage;
    Collection principalsForEvent;
    Collection childrenInCaseInSubcare;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);

      principalsForStage = familyPlanDao.queryPrincipalsForStage(familyPlanBean);
      familyPlanBean.setPrincipalsForStage(principalsForStage);

      // Create a hashmap of the person id's of the children in the case that
      // are in subcare. The hashmap will be used to identify the principals
      // for the event that need a permanency goal.
      HashMap<Integer, Boolean> childrenInCaseInSubcareHashMap = new HashMap<Integer, Boolean>();
      childrenInCaseInSubcare = familyPlanDao.queryChildrenInCaseInSubcare(familyPlanBean.getCaseId());
      if (childrenInCaseInSubcare.size() > 0) {
        Iterator iter = childrenInCaseInSubcare.iterator();
        while (iter.hasNext()) {
          Integer personId = (Integer) iter.next();
          childrenInCaseInSubcareHashMap.put(personId, true);
        }
      }
      familyPlanBean.setChildrenInCaseInSubcareHashmap(childrenInCaseInSubcareHashMap);
      
      // Regarding data conversion issue: addition of case converted ONG
      CaseUtility.Stage priorStage =  CaseUtility.getPriorStage(familyPlanBean.getStageId());
      boolean isConvertedOng = isConvertedOng(familyPlanBean.getStageId());
      if (isConvertedOng || CodesTables.CSTAGES_FSU.equals(priorStage.getCdStage())) {
        familyPlanBean.setIdStageForInitRiskAssmt(familyPlanBean.getStageId()); // is the currrent ONG stage id
      } else {
        familyPlanBean.setIdStageForInitRiskAssmt(priorStage.getIdStage()); // should be the INV id stage
      }
      familyPlanBean.setCdStagePrior(priorStage.getCdStage());
      familyPlanBean.setConvertedOng(isConvertedOng);
      CaseUtility.Event initialRiskAssessment = queryInitialRiskAssessment(familyPlanBean); // van: use this one below too
      familyPlanBean.setIdEventForInitRiskAssmt(initialRiskAssessment.getIdEvent());
      // End Regarding data conversion issue: addition of case converted ONG
 
      // Query the family plan details to see if the row exists in the
      // FAMILY_PLAN table. 'Stage Progression' will create a row in the EVENT
      // table, but not in the FAMILY_PLAN table. If no row exists in the
      // FAMILY_PLAN table, we need to treat this as a new family plan.
      // SHINES: For COPY and EDIT/UPDATE, this is still event ID from the chosen plan so that
      // existing data can be brought over
      if (familyPlanBean.getFamilyPlanEvent().getEventId() > 0) {
        familyPlanBean = familyPlanDao.queryFamilyPlan(familyPlanBean);
      }
      // set current risk assessment id event to that of initial one so Initial values can be referenced from the intial
      // one properly when page has not been saved at least one time, since at this time family plan id and event id exist
      // even though it is new plan
      if (familyPlanBean.isNewUsing()) {
        familyPlanBean.setRiskAssessmentEventId(familyPlanBean.getIdEventForInitRiskAssmt());
      }

      // If the family plan exists, query the family plan details from the
      // database. Otherwise, prepare an empty family plan. An empty plan will
      // import all areas of concern from the risk assessment (in the
      // investigation stage) that have a level of concern of 'Somewhat' or
      // greater.
      if (familyPlanBean.getFamilyPlanId() > 0) {
        // Query the principals associated with the most recent event for this
        // family plan. (If the family plan has already been approved, the most
        // recent event is the first evaluation event in the list.)
        EventValueBean mostRecentEvent = familyPlanBean.getFamilyPlanEvent();
        principalsForEvent = familyPlanDao.queryPrincipalsForEvent(mostRecentEvent);
        familyPlanBean.setPrincipalsForEvent(principalsForEvent);

        // RIOSJA, SIR 14974 - Check if any of the principals in the plan have
        // person characteristics of 'Limited English Proficiency' or 'Hearing
        // Impaired'.
        boolean isInterpreterTranslatorNeeded = familyPlanDao.checkIfIntepreterTranslatorIsNeeded(principalsForEvent);
        familyPlanBean.setInterpreterTranslatorIsNeeded(isInterpreterTranslatorNeeded);
        
        // If a Risk ReAssessment has been processed (has status PROC, COMP), get value for Current scale of concern
        // from it
        if (familyPlanBean.getRiskAssessmentEventId() > 0) {
          //CaseUtility.Event riskAssmtEvent = CaseUtility.getEvent(familyPlanBean.getRiskAssessmentEventId());
          EventValueBean riskAssmtEvent = queryEvent(familyPlanBean.getRiskAssessmentEventId());
          if (riskAssmtEvent != null && !CodesTables.CEVTSTAT_NEW.equals(riskAssmtEvent.getEventStatusCode())) {
            List<FamilyPlanItemValueBean> familyPlanItems = new ArrayList<FamilyPlanItemValueBean>();
            RiskAssmtValueBean riskAssmtSearchBean = new RiskAssmtValueBean(familyPlanBean.getCaseId(),
                                                                            riskAssmtEvent.getStageId(),
                                                                            riskAssmtEvent.getEventId());

            riskAssmtSearchBean.setUlPersonId(familyPlanBean.getUserId());
            riskAssmtSearchBean.setSzUserLoginId(familyPlanBean.getUserLoginId());
            // Get the risk assessment details.
            /*EventValueBean initialRiskAssmnt = familyPlanDao
                                                            .queryFirstCompEventByStageAndTask(
                                                                                               familyPlanBean
                                                                                                             .getStageId(),
                                                                                               RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE);
            */
            
            //CaseUtility.Event initialRiskAssmnt = queryInitialRiskAssessment(familyPlanBean); // van: already queried up above
            int idInitialRiskAssmntEvent = initialRiskAssessment.getIdEvent();
            // populate Initital Scale of Concern and Initially Addressed since this is the first plan for ONG from FCF
            boolean isFirstFamilyPlan = (0 != idInitialRiskAssmntEvent && idInitialRiskAssmntEvent == familyPlanBean
                                                                                                                    .getRiskAssessmentEventId());
            
            RiskAssmtValueBean riskAssmtBean = lookupEjb(RiskAssmt.class).queryRiskAssmt(riskAssmtSearchBean);
            List factorsList = (List) riskAssmtBean.getFactors();
            Iterator itemListItr = familyPlanBean.getFamilyPlanItemList().iterator();
            while (itemListItr.hasNext()) {
              FamilyPlanItemValueBean item = (FamilyPlanItemValueBean) itemListItr.next();
              Iterator iter = factorsList.iterator();
              while (iter.hasNext()) {
                RiskFactorValueBean riskFactorBean = (RiskFactorValueBean) iter.next();
                if (item.getAreaOfConcernCode().equals(riskFactorBean.getAreaCode())) {

                  if (isFirstFamilyPlan) {
                    item.setDateInitiallyAddressed(riskFactorBean.getAreaDateLastUpdate());
                    item.setInitialLevelOfConcernScale(riskFactorBean.getAreaScaleOfConcern());
                  }

                  item.setCurrentLevelOfConcernScale(riskFactorBean.getAreaScaleOfConcern());
                  if (CodesTables.CRISKSOC_3.equals(riskFactorBean.getAreaScaleOfConcern())
                      || CodesTables.CRISKSOC_4.equals(riskFactorBean.getAreaScaleOfConcern())
                      || CodesTables.CRISKSOC_5.equals(riskFactorBean.getAreaScaleOfConcern())) {
                    item.setIdentifiedInRiskAssessment(true);
                  } else {
                    item.setIdentifiedInRiskAssessment(false);
                  }
                  familyPlanItems.add(item);
                  break;
                }
              }
            }
            familyPlanBean.setFamilyPlanItemList(familyPlanItems);

          } // end APRV || PEND || ....
        }
      } else {
        // Set the plan type of the new family plan.
        familyPlanBean.setPlanTypeCode(CodesTables.CPLNTYPE_FPP);

        // Import the risk assessment areas of concern using either INV or Initial R/A done in FCF,
        // but first create an empty family plan item list using data from the RISK_AREA_LOOKUP
        // table in case the risk assessment does not exist.
        familyPlanBean = familyPlanDao.queryItemsFromRiskAreaLookup(familyPlanBean);
        familyPlanBean = importItemsFromRiskAssmt(familyPlanBean);
      }

      // Query the stage closure event, if it exists.
      EventValueBean stageClosureEvent = familyPlanDao.queryStageClosureEvent(familyPlanBean.getStageId());
      if (stageClosureEvent != null) {
        familyPlanBean.setStageClosureEvent(stageClosureEvent);
      }
      // if prior stage is not FCF, it is INV, then Initial Due Date is 90 days from Intake call date
      // It is blank if it is progressed from a FCF stage (prior is FCF)
      if (familyPlanDao.queryFcfStageId(familyPlanBean.getStageId()) == 0) {
        if (DateHelper.isNull(familyPlanBean.getDateInitialDueDate())) {
          Date initialDateString = familyPlanDao.queryIntakeCallDate(familyPlanBean.getCaseId());
          if (!DateHelper.isNull(initialDateString)) {
            Date dateInitDue = DateHelper.addToDate(initialDateString, 0, 3, 0);
            familyPlanBean.setDateInitialDueDate(DateHelper.toCastorDate(dateInitDue));
          }
        }
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return familyPlanBean;
  }

  /**
   * Retrieves the event id of the family plan to which the given evaluation belongs.
   * 
   * @param evalEventId
   *          The event id of the evaluation whose corresponding family plan event id will be retrieved.
   * @return familyPlanEventId The event id of the family plan to which the given evaluation belongs.
   */
  public Integer queryFamilyPlanEventId(Integer evalEventId) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryFamilyPlanEventId");

    Connection connection = null;
    int familyPlanEventId = 0;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      familyPlanEventId = familyPlanDao.queryFamilyPlanEventId(evalEventId);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return familyPlanEventId;
  }

  /**
   * Retrieves all approved family plans for the given stage and any related stages that were created in IMPACT. Related
   * stages are ones from the same progression of stages originating from the same INV stage.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the family plan search parameters.
   * @return approvedFamilyPlans Collection containing all approved family plans for the given stage and any prior stage
   *         that were created in IMPACT.
   */
  public Collection<FamilyPlanValueBean> queryApprovedFamilyPlans(FamilyPlanValueBean familyPlanBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryApprovedFamilyPlans");

    Connection connection = null;
    Collection<FamilyPlanValueBean> approvedFamilyPlans = null;
    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      approvedFamilyPlans = familyPlanDao.queryApprovedFamilyPlans(familyPlanBean);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return approvedFamilyPlans;
  }

  /**
   * Retrieves the Family Plan Item details from the database.
   * 
   * @param familyPlanItemBean
   *          FamilyPlanItemValueBean containing the family plan item search parameters.
   * @return FamilyPlanItemValueBean The object containing the family plan item details.
   */
  public FamilyPlanItemValueBean queryFamilyPlanItem(FamilyPlanItemValueBean familyPlanItemBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryFamilyPlanItem");

    Connection connection = null;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      familyPlanItemBean = familyPlanDao.queryFamilyPlanItem(familyPlanItemBean);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return familyPlanItemBean;
  }

  /**
   * Calls CheckStageEventStatus (CCMN06U) common function to determine whether or not the case is still open and
   * modifiable.
   * 
   * @param event
   *          The EventValueBean containing the case specific information.
   */
  private void callCheckStageEventStatus(EventValueBean event) {
    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    if (event.getEventId() > 0) {
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    CCMN06UI ccmn06ui = populateCCMN06UI_CheckStageEventStatus(event, actionCode);
    checkStageEventStatus.status(ccmn06ui);
  }

  /**
   * Saves the family plan details to the database. Creates a new family plan event or a new family plan evaluation
   * event, if needed. Otherwise, updates the existing family plan event or family plan evaluation event. Returns the
   * event id of the event being added or updated.
   * 
   * @param familyPlanBeanFromState
   *          FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param familyPlanBeanFromRequest
   *          FamilyPlanValueBean containing the family plan data to be saved to the database.
   * @return Integer The event id of the family plan.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException
   * 
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  @SuppressWarnings( { "unchecked" })
  public Integer saveFamilyPlan(FamilyPlanValueBean familyPlanBeanFromState,
                                FamilyPlanValueBean familyPlanBeanFromRequest) throws TimestampMismatchException,
                                                                              ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".saveFamilyPlan");

    Connection connection = null;
    Integer eventId = 0;
    Integer eventRiskAssmtId = 0;

    try {
      connection = getConnection();

      EventValueBean eventToSave = familyPlanBeanFromRequest.getFamilyPlanEvent();

      // Determine whether or not the stage is open and modifiable.
      callCheckStageEventStatus(eventToSave);

      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      
      // ACTION TO TAKE:
      // 1) If we are saving family plan data, and the family plan does not
      // yet exist, create a new family plan event, if necessary, and insert
      // the new family plan details.
      // 2) If we are saving family plan data, and the family plan event does
      // exist, update the family plan event and the family plan details.

      if (familyPlanBeanFromState.getFamilyPlanId() == 0) {
        // If the family plan event has not been created (by stage progression),
        // call PostEvent
        if (eventToSave.getEventId() == 0) {
          //STGAP00006386: ONG Family Plan: user should not be able to add a plan if 
          //there is an unfinished existing plan. This validation should be done only during
          //the time of adding a new plan and not during the update or copying a plan
          if (!familyPlanBeanFromRequest.isCopiedPlan() && !familyPlanBeanFromRequest.isUpdatedPlan()){
            validateFamilyPlan(familyPlanBeanFromRequest);
          }
          eventId = postEvent(eventToSave, familyPlanBeanFromState, familyPlanBeanFromRequest);
          // Insert a row into the EVENT_PLAN_LINK table to indicate that the
          // family plan was created using IMPACT.
          familyPlanDao.addEventPlanLinkRow(eventId);
          // create Risk ReAssessment for new plan resulting from using ADD, COPY buttons only
          if (!familyPlanBeanFromRequest.isUpdatedPlan()) {
            // pass the newly created event id for to-be-saved Family Plan to postRiskAssmtEvent to construct Risk
            // ReAssessment event description
            eventRiskAssmtId = postRiskAssmtEvent(familyPlanBeanFromState, eventId);
          } else {
            eventRiskAssmtId = familyPlanBeanFromState.getRiskAssessmentEventId();
          }
        } else {
          eventId = eventToSave.getEventId();
          CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(eventToSave, familyPlanBeanFromState,
                                                         familyPlanBeanFromRequest);
          postEvent.postEvent(ccmn01ui);
          // the first plan in ONG progressed from INV would not have a Risk ReAssessment created for
          // so set it to INV R/A event id
          int investigationStageId = queryInvestigationStageId(familyPlanBeanFromState.getStageId());
          CaseUtility.Event invRiskAssmtEvent = CaseUtility.getEvent(investigationStageId,
                                                                     RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE);
          eventRiskAssmtId = invRiskAssmtEvent.getIdEvent();

        }
        familyPlanBeanFromState.getFamilyPlanEvent().setEventId(eventId);
        familyPlanBeanFromRequest.getFamilyPlanEvent().setEventId(eventId);
        familyPlanBeanFromState.setRiskAssessmentEventId(eventRiskAssmtId);
        familyPlanBeanFromRequest.setRiskAssessmentEventId(eventRiskAssmtId);
        familyPlanDao.addFamilyPlan(familyPlanBeanFromRequest);
        familyPlanDao.addFamilyPlanItems(familyPlanBeanFromState);
        // STGAP00006207 - populate task for each item if existed since copy a family plan will copy all item data
        List<FamilyPlanItemValueBean> familyPlanItems = (List)familyPlanBeanFromState.getFamilyPlanItemList();
        // insert task data if exists for copied plan
        if (familyPlanItems != null && !familyPlanItems.isEmpty()) {
          Iterator<FamilyPlanItemValueBean> itemItr = familyPlanItems.iterator();
          while (itemItr.hasNext() ) {
            FamilyPlanItemValueBean itemBean = itemItr.next();
            if (itemBean.getTasks() != null) {
              List<FamilyPlanTaskValueBean> taskList = (List)itemBean.getTasks();
              if (taskList != null && !taskList.isEmpty()) {
                Iterator<FamilyPlanTaskValueBean> taskItr = taskList.iterator();
                while (taskItr.hasNext()) {
                  FamilyPlanTaskValueBean taskBean = taskItr.next();
                  taskBean.setFamilyPlanEventId(eventId);
                  taskBean.setFamilyPlanItemId(itemBean.getFamilyPlanItemId());
                  familyPlanDao.addFamilyPlanTask(taskBean);
                }
              }
            }
          }
        }
        // end STGAP00006207
      } else if (familyPlanBeanFromState.getFamilyPlanId() > 0) {
        eventId = eventToSave.getEventId();

        // If the event is pending approval and the user did not access the
        // family plan via an approval todo, or if the user accessed the family
        // plan after navigating a stage closure approval todo, call
        // InvalidateApproval common function to invalidate the approval and
        // demote all related events. If the user accessed the family plan after
        // navigating a stage closure approval todo, we want to invalidate the
        // pending family plan so the user can close the stage without leaving
        // a pending family plan. This will no longer be an issue if SIR 19659
        // is accepted and implemented.
        if (CodesTables.CEVTSTAT_PEND.equals(eventToSave.getEventStatusCode())
            && (!familyPlanBeanFromState.isApprovalMode() || familyPlanBeanFromState.isApprovalModeForStageClosure())) {
          CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(eventToSave);
          invalidateApproval.invalidateApproval(ccmn05ui);
        }
        familyPlanDao.updateFamilyPlan(familyPlanBeanFromRequest);

        // Call PostEvent to update the family plan event and the principals for
        // the event.
        CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(eventToSave, familyPlanBeanFromState, familyPlanBeanFromRequest);
        postEvent.postEvent(ccmn01ui);
      }

      // If the stage closure event is pending approval, and the user did not
      // access the stage via an approval todo, invalidate it. Then set the
      // stage closure event status to COMP.
      if (familyPlanBeanFromState.getStageClosureEvent() != null
          && CodesTables.CEVTSTAT_PEND.equals(familyPlanBeanFromState.getStageClosureEvent().getEventStatusCode())
          && !familyPlanBeanFromState.isApprovalMode()) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(familyPlanBeanFromState.getStageClosureEvent());
        invalidateApproval.invalidateApproval(ccmn05ui);

        EventValueBean stageClosureEvent = new EventValueBean();
        stageClosureEvent.setEventId(familyPlanBeanFromState.getStageClosureEvent().getEventId());
        stageClosureEvent.setEventStatusCode(CodesTables.CEVTSTAT_COMP);
        familyPlanDao.updateEventStatusWithoutTimestamp(stageClosureEvent);
      }

      // If the worker clicked 'Save and Submit', or if the supervisor is
      // saving changes while in approval mode, create an Alert To-Do for the
      // Next Review.
      if (familyPlanBeanFromRequest.isSaveAndSubmit() || familyPlanBeanFromRequest.isApprovalMode()) {
        Date nextReviewDueDate = DateHelper.toJavaDate(familyPlanBeanFromRequest.getDateNextEvalDue());
        familyPlanDao.addTodoForNextReview(familyPlanBeanFromRequest, nextReviewDueDate);
      }
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException updating family plan");
      getSessionContext().setRollbackOnly();
      throw tme;
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      getSessionContext().setRollbackOnly();
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return eventId;
  }

  /**
   * Saves the family plan item details to the database.
   * 
   * @param familyPlanBeanFromState
   *          FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param itemBeanFromRequest
   *          FamilyPlanItemValueBean containing the family plan item details to be saved to the database.
   * @throws TimestampMismatchException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  public void saveFamilyPlanItem(FamilyPlanValueBean familyPlanBeanFromState,
                                 FamilyPlanItemValueBean itemBeanFromRequest) throws TimestampMismatchException,
                                                                             ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".saveFamilyPlanItem");

    Connection connection = null;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);

      // ------------------------------
      // Get the most recent approval date, if there is one. (It will either be
      // the approval date of the family plan or the approval date of the most
      // recently approved evaluation. Evaluations are stored in the family plan
      // bean from most recent to oldest; therefore, the first one that has an
      // approval date will be the most recently approved one. If no approved
      // evaluations exists, check if the family plan has been approved. If it
      // has, use that date.) Also, get a reference to the most recent event
      // (not necessarily an approved one).
      boolean bSavingEvaluationData = false;
      EventValueBean mostRecentEvent;
      if (familyPlanBeanFromState.getFamilyPlanEvaluations() != null) {
        bSavingEvaluationData = true;

        // The first eval event in the list is the most recent event.
        List familyPlanEvals = (List) familyPlanBeanFromState.getFamilyPlanEvaluations();
        FamilyPlanEvalValueBean mostRecentFamilyPlanEval = (FamilyPlanEvalValueBean) familyPlanEvals.get(0);
        mostRecentEvent = mostRecentFamilyPlanEval.getEvalEvent();
      } else {
        mostRecentEvent = familyPlanBeanFromState.getFamilyPlanEvent();
      }// end if ( familyPlanBean.getFamilyPlanEvaluations() != null )
      // ------------------------------

      // Determine whether or not the stage is open and modifiable.
      callCheckStageEventStatus(mostRecentEvent);

      // If the event is pending approval and the user did not access the
      // family plan via an approval todo, or if the user accessed the family
      // plan after navigating a stage closure approval todo, call
      // InvalidateApproval common function to invalidate the approval and
      // demote all related events. If the user accessed the family plan after
      // navigating a stage closure approval todo, we want to invalidate the
      // pending family plan so the user can close the stage without leaving
      // a pending family plan. This will no longer be an issue if SIR 19659
      // is accepted and implemented.
      if (CodesTables.CEVTSTAT_PEND.equals(mostRecentEvent.getEventStatusCode())
          && (!familyPlanBeanFromState.isApprovalMode() || familyPlanBeanFromState.isApprovalModeForStageClosure())) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(mostRecentEvent);
        invalidateApproval.invalidateApproval(ccmn05ui);

        CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(mostRecentEvent, familyPlanBeanFromState,
                                                       familyPlanBeanFromState);
        postEvent.postEvent(ccmn01ui);
      }

      familyPlanDao.updateFamilyPlanItem(itemBeanFromRequest);

      // Iterate through the tasks for the item and save them to the database
      // as needed.
      Iterator iter = itemBeanFromRequest.getTasks().iterator();
      while (iter.hasNext()) {
        // Save the task to the database only if the task field actually has
        // text in it.
        FamilyPlanTaskValueBean taskBean = (FamilyPlanTaskValueBean) iter.next();
        if (taskBean.getTask() != null) {
          if (taskBean.getFamilyPlanTaskId() > 0) {
            familyPlanDao.updateFamilyPlanTask(taskBean);
          } else {
            familyPlanDao.addFamilyPlanTask(taskBean);
          }
        } // end if ( taskBean.getTask() != null )
      } // end while ( iter.hasNext() )

      // Save the evaluation item if:
      // 1) the user is saving evaluation data, and
      // 2) the evaluation item has data, and
      // 3) if evaluation item's eval event has not yet been approved
      List evalItemsList = (List) itemBeanFromRequest.getEvalItems();
      if (bSavingEvaluationData && evalItemsList != null) {
        FamilyPlanEvalItemValueBean evalItem = (FamilyPlanEvalItemValueBean) evalItemsList.get(0);
        if (!CodesTables.CEVTSTAT_APRV.equals(mostRecentEvent.getEventStatusCode())
            && mostRecentEvent.getEventId() == evalItem.getFamilyPlanEvalEventId()) {
          if (evalItem.getFamilyPlanEvalItemId() > 0) {
            familyPlanDao.updateFamilyPlanEvalItem(evalItem);
          } else {
            familyPlanDao.addFamilyPlanEvalItem(evalItem);
          }
        } // end if( !CodesTables.CEVTSTAT_APRV.equals( mostRecentEvent.getEventStatusCode() ) && ...
      } // end if ( bSavingEvaluationData && evalItemsList != null )

      // If the stage closure event is pending approval, and the user did not
      // access the stage via an approval todo, invalidate it. Then set the
      // stage closure event status to COMP.
      if (familyPlanBeanFromState.getStageClosureEvent() != null
          && CodesTables.CEVTSTAT_PEND.equals(familyPlanBeanFromState.getStageClosureEvent().getEventStatusCode())
          && !familyPlanBeanFromState.isApprovalMode()) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(familyPlanBeanFromState.getStageClosureEvent());
        invalidateApproval.invalidateApproval(ccmn05ui);

        EventValueBean stageClosureEvent = new EventValueBean();
        stageClosureEvent.setEventId(familyPlanBeanFromState.getStageClosureEvent().getEventId());
        stageClosureEvent.setEventStatusCode(CodesTables.CEVTSTAT_COMP);
        familyPlanDao.updateEventStatusWithoutTimestamp(stageClosureEvent);
      }
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException updating family plan item");
      getSessionContext().setRollbackOnly();
      throw tme;
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      getSessionContext().setRollbackOnly();
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }

  /**
   * Saves the permanency goal for each child in the family plan or family plan evaluation.
   * 
   * @param familyPlanBeanFromState
   *          FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param goalsCommentFromRequest
   *          The new Goal Comment value.
   * @param childrenInPlanFromState
   *          The list of children with the original value of their permanency goal.
   * @param childrenInPlanFromRequest
   *          The list of children with the new value of their permanency goal.
   * @throws TimestampMismatchException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  @SuppressWarnings( { "unchecked" })
  public void savePermanencyGoals(FamilyPlanValueBean familyPlanBeanFromState, String goalsCommentFromRequest,
                                  List<PersonValueBean> childrenInPlanFromState,
                                  List<PersonValueBean> childrenInPlanFromRequest) throws TimestampMismatchException,
                                                                                  ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".savePermanencyGoals");

    Connection connection = null;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);

      // Get the most recent event.
      EventValueBean mostRecentEvent;
      if (familyPlanBeanFromState.getFamilyPlanEvaluations() != null) {
        // The first eval event in the list is the most recent event.
        List familyPlanEvals = (List) familyPlanBeanFromState.getFamilyPlanEvaluations();
        FamilyPlanEvalValueBean mostRecentFamilyPlanEval = (FamilyPlanEvalValueBean) familyPlanEvals.get(0);
        mostRecentEvent = mostRecentFamilyPlanEval.getEvalEvent();
      } else {
        mostRecentEvent = familyPlanBeanFromState.getFamilyPlanEvent();
      }

      // Determine whether or not the stage is open and modifiable.
      callCheckStageEventStatus(mostRecentEvent);

      // Save the permanency goals and target dates.
      HashMap originalPermanencyGoalHashmap = new HashMap();
      HashMap originalTargetDateHashmap = new HashMap();
      if (childrenInPlanFromState.size() > 0) {
        // Create a hashmap with the person id for each child in the plan and
        // the original value of the child's permanency goal. Create another
        // hashmap with the person id for each child in the plan and the
        // original value of the permanency goal target date. The maps will be
        // used to determine whether or not the data has changed.
        Iterator<PersonValueBean> iter = childrenInPlanFromState.iterator();
        while (iter.hasNext()) {
          PersonValueBean personBeanFromState = iter.next();
          originalPermanencyGoalHashmap.put(personBeanFromState.getPersonId(),
                                            personBeanFromState.getPermanencyGoalCode());
          originalTargetDateHashmap.put(personBeanFromState.getPersonId(),
                                        personBeanFromState.getPermanencyGoalTargetDate());
        }

        // Iterate through the children in the plan, and save their permanency
        // goal if it has changed.
        iter = childrenInPlanFromRequest.iterator();
        while (iter.hasNext()) {
          PersonValueBean personBeanFromRequest = iter.next();
          Integer personId = personBeanFromRequest.getPersonId();
          String originalPermanencyGoal = (String) originalPermanencyGoalHashmap.get(personId);
          org.exolab.castor.types.Date originalTargetDate = (org.exolab.castor.types.Date) originalTargetDateHashmap
                                                                                                                    .get(personId);

          boolean permGoalHasChanged = false;
          boolean targetDateHasChanged = false;

          // Check if the Permanency Goal has changed.
          if ((personBeanFromRequest.getPermanencyGoalCode() != null && originalPermanencyGoal == null)
              || (personBeanFromRequest.getPermanencyGoalCode() == null && originalPermanencyGoal != null)
              || (personBeanFromRequest.getPermanencyGoalCode() != null && originalPermanencyGoal != null && !originalPermanencyGoal
                                                                                                                                    .equals(personBeanFromRequest
                                                                                                                                                                 .getPermanencyGoalCode()))) {
            permGoalHasChanged = true;
          }

          // Check if the Permanency Goal Target Date has changed.
          if ((personBeanFromRequest.getPermanencyGoalTargetDate() != null && originalTargetDate == null)
              || (personBeanFromRequest.getPermanencyGoalTargetDate() == null && originalTargetDate != null)
              || (personBeanFromRequest.getPermanencyGoalTargetDate() != null && originalTargetDate != null && !originalTargetDate
                                                                                                                                  .equals(personBeanFromRequest
                                                                                                                                                               .getPermanencyGoalTargetDate()))) {
            targetDateHasChanged = true;
          }

          if (permGoalHasChanged || targetDateHasChanged) {
            familyPlanDao.updateChildPermanencyInfo(mostRecentEvent.getEventId(), personBeanFromRequest);
          }
        } // end while ( iter.hasNext() )
      } // end if ( childrenInPlanFromState.size() > 0 )

      // Save the Permanency Goals Comment.
      String originalGoalsComment = familyPlanBeanFromState.getPermanencyGoalsComment();
      if ((goalsCommentFromRequest != null && originalGoalsComment == null)
          || (goalsCommentFromRequest == null && originalGoalsComment != null)
          || (goalsCommentFromRequest != null && originalGoalsComment != null && !originalGoalsComment
                                                                                                      .equals(goalsCommentFromRequest))) {
        familyPlanDao.updatePermanencyGoalComment(familyPlanBeanFromState, goalsCommentFromRequest);
      }
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException updating permanency goals");
      getSessionContext().setRollbackOnly();
      throw tme;
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      getSessionContext().setRollbackOnly();
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }

  /**
   * Calls PostEvent common function in its own transaction to add or update the given family plan event or family plan
   * evaluation event.
   * 
   * @param eventBean
   *          EventValueBean containing the family plan event or the family plan evaluation event to be saved to the
   *          database.
   * @param familyPlanBeanFromState
   *          FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param familyPlanBeanFromRequest
   *          FamilyPlanValueBean containing the family plan details to be saved to the database.
   * @return Integer The event id of the family plan.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  public Integer postEvent(EventValueBean eventBean, FamilyPlanValueBean familyPlanBeanFromState,
                           FamilyPlanValueBean familyPlanBeanFromRequest) throws ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".postEvent");

    CCMN01UI ccmn01ui;
    CCMN01UO ccmn01uo = null;

    try {
      ccmn01ui = populateCCMN01UI_PostEvent(eventBean, familyPlanBeanFromState, familyPlanBeanFromRequest);
      ccmn01uo = postEvent.postEvent(ccmn01ui);
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling CCMN01US: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
    return ccmn01uo != null ? ccmn01uo.getUlIdEvent() : 0;
  }

  public int postRiskAssmtEvent(FamilyPlanValueBean familyPlanBeanFromState, int familyPlanEventId)
                                                                                                   throws ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "postRiskAssmtEvent");
    performanceTrace.enterScope();

    int newRiskAssmtEventId;
    try {
      CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent_RiskAssmtNew(familyPlanBeanFromState, familyPlanEventId);
      CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
      newRiskAssmtEventId = ccmn01uo.getUlIdEvent();
    } catch (ServiceException we) {
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    performanceTrace.exitScope();
    return newRiskAssmtEventId;
  }

  /**
   * Checks the given event id to determine whether or not the event was created before the initial launch of IMPACT.
   * 
   * @param eventId
   *          The id of the family plan to be checked for legacy status.
   * @return Boolean Indicator that indicates whether or not the given event was created in CAPS.
   */
  public Boolean checkIfEventIsLegacy(Integer eventId) {
    GrndsTrace.enterScope(TRACE_TAG + ".checkIfEventIsLegacy");

    boolean isLegacyEvent = false;
    Connection connection = null;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      isLegacyEvent = familyPlanDao.checkIfEventIsLegacy(eventId);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return isLegacyEvent;
  }

  /**
   * Helper method called to populate the input object for the PostEvent common function for updating a given event.
   * 
   * @param eventBean
   *          EventValueBean containing the family plan event or the family plan evaluation event to be saved to the
   *          database.
   * @param familyPlanBeanFromState
   *          FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param familyPlanBeanFromRequest
   *          FamilyPlanValueBean containing the family plan details to be saved to the database.
   * @return CCMN01UI The input object for the CCMN01UI service.
   */
  @SuppressWarnings( { "unchecked" })
  private CCMN01UI populateCCMN01UI_PostEvent(EventValueBean eventBean, FamilyPlanValueBean familyPlanBeanFromState,
                                              FamilyPlanValueBean familyPlanBeanFromRequest) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN01UI_PostEvent");

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();

    input.setSzUserId(String.valueOf(familyPlanBeanFromState.getUserId()));

    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_PLN);
    rowccmn01uig00.setSzCdTask(eventBean.getEventTaskCode());
    rowccmn01uig00.setUlIdPerson(familyPlanBeanFromState.getUserId());
    rowccmn01uig00.setUlIdStage(eventBean.getStageId());

    if (eventBean.getDateEventOccurred() != null || eventBean.getEventId() != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(eventBean.getDateEventOccurred()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }

    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    String eventDesc = null;

    // this check is not needed when code is complete for SHINES since it is always CD_TASK_FPR_FAM_PLAN
    if (FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN.equals(eventBean.getEventTaskCode())) {
      if (!familyPlanBeanFromRequest.isUpdatedPlan()) {
        eventDesc = "ONG Family Plan";
      } else { // updated plan
        eventDesc = "ONG Family Plan Event " + familyPlanBeanFromState.getFamilyPlanEvent().getEventId() + " updated ";

        if (familyPlanBeanFromRequest.getDateCurrentEvalCompleted() != null) {
          eventDesc += FormattingHelper.formatDate(familyPlanBeanFromRequest.getDateCurrentEvalCompleted());
        }
      }
      if (familyPlanBeanFromRequest.isSaveAndSubmit()) {
        rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
      }
      // If the 'Date Plan Completed' field is not empty, the status of the
      // family plan event should be COMP (or possibly PEND).
      if (familyPlanBeanFromRequest.getDatePlanCompleted() != null) {
        rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
      }
      // If the supervisor accessed the family plan via a family plan approval
      // todo, and the status of the family plan event was PEND, it should
      // remain PEND. The supervisor is allowed to make changes without
      // invalidating the pending approval. If the supervisor accessed the
      // family plan via a stage closure approval todo, however, the status of
      // the family plan event should be set to COMP because the family plan
      // approval will be invalidated. This will enable the supervisor to
      // close the stage without leaving a pending family plan behind.
      if (familyPlanBeanFromState.isApprovalMode() && !familyPlanBeanFromState.isApprovalModeForStageClosure()) {
        rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PEND);
      }
    }
    rowccmn01uig00.setSzTxtEventDescr(eventDesc);

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    if (eventBean.getEventId() > 0) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowccmn01uig00.setUlIdEvent(eventBean.getEventId());
      rowccmn01uig00.setTsLastUpdate(eventBean.getDateLastUpdate());
    }

    // Compare the list of 'Principals on the Plan' from the state bean to the
    // list of 'Principals on the Plan' from the request bean. Pass each principal
    // that was newly selected or that was deselected to PostEvent. Pass newly
    // selected principals with an 'szCdScrDataAction' of ADD, and pass each
    // principal that was deselected with an 'szCdScrDataAction' of DELETE. They
    // will be added/deleted from the EVENT_PERSON_LINK table.
    // -----------------
    // NOTE: IF WE ARE ABOUT TO CREATE A NEW EVALUATION EVENT, REMOVE THE
    // 'Principals on the Plan' FROM THE STATE BEAN SO THAT THE SELECTED
    // PRINCIPALS WILL BE ADDED TO EVENT_PERSON_LINK TABLE FOR THE NEW EVALUATION
    // EVENT.
    /*
     * if ((FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN_EVAL.equals(eventBean.getEventTaskCode()) ||
     * FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN_EVAL.equals(eventBean.getEventTaskCode()) ||
     * FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN_EVAL .equals(eventBean .getEventTaskCode())) && eventBean.getEventId() ==
     * 0) {
     */
    if (familyPlanBeanFromRequest.isUpdatedPlan() && eventBean.getEventId() == 0) {
      familyPlanBeanFromState.setPrincipalsForEvent(null);
    }
    Iterator iter;
    int numOfPrincipalsInList = 0;
    List principalsFromStateBean = null;
    List principalsFromRequestBean;
    Map principalsFromStateBeanHashmap = new HashMap();
    Map principalsFromRequestBeanHashmap = new HashMap();
    if (familyPlanBeanFromState.getPrincipalsForEvent() != null) {
      principalsFromStateBean = (List) familyPlanBeanFromState.getPrincipalsForEvent();
      iter = principalsFromStateBean.iterator();
      while (iter.hasNext()) {
        PersonValueBean personBean = (PersonValueBean) iter.next();
        Integer personId = personBean.getPersonId();
        principalsFromStateBeanHashmap.put(personId, personId);
      }
    }

    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY();

    if (familyPlanBeanFromRequest.getPrincipalsForEvent() != null) {
      principalsFromRequestBean = (List) familyPlanBeanFromRequest.getPrincipalsForEvent();
      iter = principalsFromRequestBean.iterator();
      while (iter.hasNext()) {
        PersonValueBean personBean = (PersonValueBean) iter.next();
        Integer personId = personBean.getPersonId();
        // Principals in the request bean, but not in the state bean were newly
        // selected, so ADD them.
        // Or in case of New Using principalsForState is populated with existing data
        // the page first loaded, so ADD them Post Event data
        if (!principalsFromStateBeanHashmap.containsKey(personId) || eventBean.getEventId() == 0) {
          rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
          rowccmn01uig01.setUlIdPerson(personId);
          rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
          rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          numOfPrincipalsInList++;
        }
        principalsFromRequestBeanHashmap.put(personId, personId);
      } // end while ( iter.hasNext() )
    } // end if ( familyPlanBeanFromRequest.getPrincipalsForEvent() != null )

    if (principalsFromStateBean != null) { // ADD skip this
      iter = principalsFromStateBean.iterator();
      while (iter.hasNext()) {
        PersonValueBean personBean = (PersonValueBean) iter.next();
        Integer personId = personBean.getPersonId();
        // Principals in the state bean, but not in the request bean were
        // deselected, so DELETE them.
        if (!principalsFromRequestBeanHashmap.containsKey(personId)) {
          rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
          rowccmn01uig01.setUlIdPerson(personId);
          rowccmn01uig01.setTsLastUpdate(personBean.getEventPersonLinkDateLastUpdate());
          rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
          rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          numOfPrincipalsInList++;
        }
      } // end while ( iter.hasNext() )
    } // end if ( principalsFromStateBean != null )

    rowccmn01uig01_array.setUlRowQty(numOfPrincipalsInList);
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    GrndsTrace.exitScope();

    return ccmn01ui;
  }

  /*
   * This function is called when a new Family Plan that is not the first Family Plan is added. It populates data for
   * Risk ReAssessment exclusively.
   */
  @SuppressWarnings( { "unchecked" })
  private CCMN01UI populateCCMN01UI_PostEvent_RiskAssmtNew(FamilyPlanValueBean familyPlanBeanFromState,
                                                           int familyPlanEventId) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN01UI_PostEvent_RiskAssmtNew");

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();

    input.setSzUserId(String.valueOf(familyPlanBeanFromState.getUserId()));

    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_ASM);
    // rowccmn01uig00.setSzCdTask(RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE);
    rowccmn01uig00.setSzCdTask(RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE);
    rowccmn01uig00.setUlIdPerson(familyPlanBeanFromState.getUserId());
    rowccmn01uig00.setUlIdStage(familyPlanBeanFromState.getStageId());
    rowccmn01uig00.setSzTxtEventDescr(RiskAssmtValueBean.RISK_REASSESSMENT_EVENT_DESC + " for Family Plan Event "
                                      + familyPlanEventId);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_NEW);

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    GrndsTrace.exitScope();

    return ccmn01ui;
  }

  /**
   * Helper method called to populate the input object for the InvalidateApproval common function.
   * 
   * @param eventBean
   *          EventValueBean containing the details of the event whose pending approval will be invalidated.
   * @return CCMN05UI The input object for the CCMN05UI service.
   */
  private CCMN05UI populateCCMN05UI_InvalidateApproval(EventValueBean eventBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN05UI_InvalidateApproval");

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO rowccmn45do = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO();

    input.setSzUserId(String.valueOf(eventBean.getPersonId()));
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(eventBean.getDateEventOccurred()));
    rowccmn45do.setSzCdEventStatus(eventBean.getEventStatusCode());
    rowccmn45do.setSzCdEventType(eventBean.getEventTypeCode());
    rowccmn45do.setSzCdTask(eventBean.getEventTaskCode());
    rowccmn45do.setSzTxtEventDescr(eventBean.getEventDescription());
    rowccmn45do.setTsLastUpdate(eventBean.getDateLastUpdate());
    rowccmn45do.setUlIdEvent(eventBean.getEventId());
    rowccmn45do.setUlIdPerson(eventBean.getPersonId());
    rowccmn45do.setUlIdStage(eventBean.getStageId());

    ccmn05ui.setUlIdEvent(eventBean.getEventId());
    ccmn05ui.setArchInputStruct(input);

    GrndsTrace.exitScope();

    return ccmn05ui;
  }

  /**
   * Helper method called to populate the input object for the CheckStageEventStatus common function.
   * 
   * @param eventBean
   *          EventValueBean containing the event details whose case will be checked for closed/open status.
   * @param actionCode
   *          Code indicating the action that will be taken on the case.
   * @return CCMN06UI The input object for the CCMN06UI service.
   */
  private CCMN06UI populateCCMN06UI_CheckStageEventStatus(EventValueBean eventBean, String actionCode) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN06UI_CheckStageEventStatus");

    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct input = new ArchInputStruct();

    ccmn06ui.setUlIdStage(eventBean.getStageId());
    ccmn06ui.setSzCdTask(eventBean.getEventTaskCode());

    input.setSzUserId(String.valueOf(eventBean.getPersonId()));
    input.setCReqFuncCd(actionCode);

    ccmn06ui.setArchInputStruct(input);

    GrndsTrace.exitScope();
    return ccmn06ui;
  }

  /**
   * Retrieves the stage id for the investigation stage that led to the creation of this stage.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the family plan details whose investigation stage id will be retrieved from
   *          the database.
   * @return int The stage id of the investigation stage that led to the creation of this family stage.
   */
  private int queryInvestigationStageId(FamilyPlanValueBean familyPlanBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryInvestigationStageId");

    Connection connection = null;
    int investigationStageId = 0;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      investigationStageId = familyPlanDao.queryInvestigationStageId(familyPlanBean.getStageId());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return investigationStageId;
  }

  private int queryInvestigationStageId(int currentOngStageId) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryInvestigationStageId");

    Connection connection = null;
    int investigationStageId = 0;

    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      investigationStageId = familyPlanDao.queryInvestigationStageId(currentOngStageId);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return investigationStageId;
  }

  /**
   * Retrieves the event info for initial risk assessment based on following rule If FCF->ONG: get the first RRA
   * completed for the stage If INV->ONG: get the RA created from INV Initial risk assessment is used to set the
   * Initially addressed date and Initial level of concern
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the family plan details whose risk assessment from the investigation stage
   *          will be retrieved from the database.
   * @return EventValueBean The object containing the details of the risk assessment event
   */
  public EventValueBean getRiskAssmtEvent(FamilyPlanValueBean familyPlanBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".getRiskAssmtEvent");

    EventValueBean riskAssmtEvent = new EventValueBean();
    CaseUtility.Event initialRiskAssmtEvent;
    int idStageOng = familyPlanBean.getStageId();
    // (a) If FCF->ONG: get the first RRA completed for the stage
    // (b) If INV->ONG: get the RA created from INV
    // STGAP00002835
    // If there is no prior stage, or it is converted investigation which has no Risk Assessment created for (a)
    try {
      /*CaseUtility.Stage priorStage = CaseUtility.getPriorStage(familyPlanBean.getStageId());
      String priorCdStage = priorStage.getCdStage();
      boolean priorStageIsInv = CodesTables.CSTAGES_INV.equals(priorCdStage);
      boolean convertedOng = isConvertedOng(idStageOng);

      // Investigation stage created in SHINES: has Risk Assessment completed for
      if (priorStageIsInv && !convertedOng) {
        int investigationStageId = queryInvestigationStageId(idStageOng);
        initialRiskAssmtEvent = CaseUtility
                                           .getEvent(investigationStageId, RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE);

      } else { // prior stage is FCF or converted INV
        int stageId = familyPlanBean.getStageId();
        initialRiskAssmtEvent = CaseUtility
                                           .getFirstCompEventByStageAndTask(
                                                                            stageId,
                                                                            RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE);
        // when this is the first plan in ONG (progressed from FCF) and RRA is not completed
        // set id event with the in-PROC RRA's id event to pass null check on jsp when click on Risk Assessment
        // hyperlink so that Risk ReAssessment will display
        // initialRiskAssmtEvent is always not null
        if (0 == initialRiskAssmtEvent.getIdEvent()) {
          initialRiskAssmtEvent.setIdEvent(familyPlanBean.getRiskAssessmentEventId());
        }
      }*/
      
      initialRiskAssmtEvent = queryInitialRiskAssessment(familyPlanBean);
      if (0 == initialRiskAssmtEvent.getIdEvent()) {
        initialRiskAssmtEvent.setIdEvent(familyPlanBean.getRiskAssessmentEventId());
      }
      // Query the complete event details because we also need stage id.
      if (initialRiskAssmtEvent.getIdEvent() > 0) {
        riskAssmtEvent = queryEvent(initialRiskAssmtEvent.getIdEvent());
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting using CaseUtility: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
    return riskAssmtEvent;
  }

  /**
   * Import all areas of concern from the risk assessment in the investigation stage if it is ONG progressed from INV;
   * first complete first risk assessment (also called risk reassessment) in ONG if it is ONG progressed from FCF
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the family plan details whose risk assessment from the investigation stage
   *          or initial risk assessment in ONG will be imported.
   * @return FamilyPlanValueBean The object containing the details of the family plan.
   */
  private FamilyPlanValueBean importItemsFromRiskAssmt(FamilyPlanValueBean familyPlanBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".importItemsFromRiskAssmt");

    List<FamilyPlanItemValueBean> familyPlanItems = new ArrayList<FamilyPlanItemValueBean>();

    try {
      // If (prior stage is INV) import INV R/A
      // else (it is FCF) import Initial R/A done in FCF
      // Prior Stage map has one single pair <id stage, cd stage>

      /*String taskCode = null;
      int stageId = 0;
      CaseUtility.Event riskAssmtEvent;
      int idStageOng = familyPlanBean.getStageId();
      CaseUtility.Stage priorStage = CaseUtility.getPriorStage(idStageOng);
      String priorCdStage = priorStage.getCdStage();
      boolean convertedOng = isConvertedOng(idStageOng);

      if (CodesTables.CSTAGES_INV.equals(priorCdStage) && !convertedOng) {
        stageId = queryInvestigationStageId(familyPlanBean);
        taskCode = RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE;
        riskAssmtEvent = CaseUtility.getEvent(stageId, taskCode);
      } else {
        stageId = familyPlanBean.getStageId();
        taskCode = RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE;
        riskAssmtEvent = CaseUtility.getFirstCompEventByStageAndTask(stageId, taskCode);
      }*/
      
      /*int idStageOng = familyPlanBean.getStageId();
      CaseUtility.Stage priorStage = CaseUtility.getPriorStage(idStageOng);
      String priorCdStage = priorStage.getCdStage();
      boolean convertedOng = isConvertedOng(idStageOng);
      CaseUtility.Event riskAssmtEvent = queryInitialRiskAssessment(idStageOng);*/
      
      String priorCdStage = familyPlanBean.getCdStagePrior();
      boolean convertedOng = familyPlanBean.isConvertedOng();
      CaseUtility.Event riskAssmtEvent = queryInitialRiskAssessment(familyPlanBean);

      // REQUIREMENT 1: Import the areas of concern only if the risk assessment
      // event status is COMP, PEND or APRV.
      if (riskAssmtEvent != null
          && (CodesTables.CEVTSTAT_APRV.equals(riskAssmtEvent.getCdEventStatus())
              || CodesTables.CEVTSTAT_PEND.equals(riskAssmtEvent.getCdEventStatus()) || CodesTables.CEVTSTAT_COMP
                                                                                                                 .equals(riskAssmtEvent
                                                                                                                                       .getCdEventStatus()))) {
        /*RiskAssmtValueBean riskAssmtSearchBean = new RiskAssmtValueBean(familyPlanBean.getCaseId(), stageId,
                                                                        riskAssmtEvent.getIdEvent());*/
        RiskAssmtValueBean riskAssmtSearchBean = new RiskAssmtValueBean(familyPlanBean.getCaseId(), familyPlanBean.getIdStageForInitRiskAssmt(),
                                                                        riskAssmtEvent.getIdEvent());

        riskAssmtSearchBean.setUlPersonId(familyPlanBean.getUserId());
        riskAssmtSearchBean.setSzUserLoginId(familyPlanBean.getUserLoginId());

        // Get the risk assessment details.
        RiskAssmtValueBean riskAssmtBean = lookupEjb(RiskAssmt.class).queryRiskAssmt(riskAssmtSearchBean);

        // REQUIREMENT 2: Import the areas of concern only if the Risk Finding
        // is not blank and is not 'Risk Assessment N/A' (04).
        // SHINES removed this requirement - import nevertheless
        List factorsList = (List) riskAssmtBean.getFactors();

        // The risk assessment value bean will have 54 factor beans. Each factor
        // bean contains the data for an individual factor, the category to
        // which the factor belongs, and the area to which the category belongs.
        // Check the level of concern for each area, and import it if the level
        // is 'Somewhat' or greater. (SHINES removed this requirement - import nevertheless)
        String previousAreaCode = null;
        Iterator iter = factorsList.iterator();
        while (iter.hasNext()) {
          RiskFactorValueBean riskFactorBean = (RiskFactorValueBean) iter.next();

          if (previousAreaCode == null || !riskFactorBean.getAreaCode().equals(previousAreaCode)) {
            FamilyPlanItemValueBean itemBean = new FamilyPlanItemValueBean();
            itemBean.setAreaOfConcernCode(riskFactorBean.getAreaCode());
            itemBean.setAreaOfConcernText(riskFactorBean.getAreaText());
            itemBean.setCaseId(familyPlanBean.getCaseId());
            itemBean.setStageId(familyPlanBean.getStageId());

            // REQUIREMENT 3: Import the areas of concern only if they are
            // 'Somewhat' or greater.
            // SHINES removed this requirement - import nevertheless

            // 1. if it is the first plan in ONG from INV, populate Initially valuess and current scale of concern (CSC)
            // with INV R/A values
            // 2. if subsequent new plan in ONG from INV, populate Initially values with INV R/A values, populate
            // CSC with current R/RA (done in queryFamilyPlan())
            // 3. if first plan in ONG from FCF or converted ONG, populate all three in queryFamilyPlan()
            // 4. if subsequent new plan in ONG from FCF or converted ONG, populate Initially values
            // with first RRA, populate CSC with current RRA

            itemBean.setDateInitiallyAddressed(riskFactorBean.getAreaDateLastUpdate());
            itemBean.setInitialLevelOfConcernScale(riskFactorBean.getAreaScaleOfConcern());
            // For scenario 1
            if ((CodesTables.CSTAGES_INV.equals(priorCdStage) && !convertedOng)
                && (familyPlanBean.getFamilyPlanEvent().getEventId() > 0)) {
              itemBean.setCurrentLevelOfConcernScale(riskFactorBean.getAreaScaleOfConcern());
            }
            if (CodesTables.CRISKSOC_3.equals(riskFactorBean.getAreaScaleOfConcern())
                || CodesTables.CRISKSOC_4.equals(riskFactorBean.getAreaScaleOfConcern())
                || CodesTables.CRISKSOC_5.equals(riskFactorBean.getAreaScaleOfConcern())) {
              itemBean.setIdentifiedInRiskAssessment(true);
            } // end REQUIREMENT 3:
            familyPlanItems.add(itemBean);
          }
          previousAreaCode = riskFactorBean.getAreaCode();
        } // end while( iter.hasNext() )
        familyPlanBean.setFamilyPlanItemList(familyPlanItems);
      } // end REQUIREMENT 1:
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
    return familyPlanBean;
  }

  private boolean isConvertedOng(int idStageOng) {
    GrndsTrace.enterScope(TRACE_TAG + ".isConvertedOng");
    boolean convertedOng;
    try {
      CaseUtility.Stage priorStage = CaseUtility.getPriorStage(idStageOng);
      String priorCdStage = priorStage.getCdStage();
      boolean priorStageIsInv = CodesTables.CSTAGES_INV.equals(priorCdStage);
      int investigationStageId = queryInvestigationStageId(idStageOng);
      CaseUtility.Event invRiskAssmtEvent = CaseUtility.getEvent(investigationStageId,
                                                                 RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE);
      convertedOng = (priorStage == null || !StringHelper.isValid(priorCdStage) || (priorStageIsInv && (0 == invRiskAssmtEvent
                                                                                                                              .getIdEvent())));
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting using CaseUtility: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
    return convertedOng;
  }
  
  private CaseUtility.Event queryInitialRiskAssessment(FamilyPlanValueBean familyPlanBean) {
    
    CaseUtility.Event initialRiskAssessment = new CaseUtility.Event();

    // should query prior stage and call isConvertedOng() again so that we do not depend on whether familyPlanBean is set
    // with CdStagePrior and ConvertedOng values
    if (CodesTables.CSTAGES_INV.equals(familyPlanBean.getCdStagePrior()) && !familyPlanBean.isConvertedOng()) {
      int stageId = queryInvestigationStageId(familyPlanBean.getStageId());
      String taskCode = RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE;
      initialRiskAssessment = CaseUtility.getEvent(stageId, taskCode);
    } else {
      String taskCode = RiskAssmtValueBean.RISK_REASSESSMENT_TASK_CODE;
      initialRiskAssessment = CaseUtility.getFirstCompEventByStageAndTask(familyPlanBean.getStageId(), taskCode);
    }

    return initialRiskAssessment;
  }
  /**
   * STGAP00006386: ONG Family Plan: user should not be able to add a plan if 
     there is an unfinished existing plan.
   * @param familyPlanBeanFromRequest
   * @return boolean
   */
  private boolean validateFamilyPlan(FamilyPlanValueBean familyPlanBeanFromRequest) 
          throws ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".validateFamilyPlan");
    boolean validateFailed = false;
    Connection connection = null;
    try {
      connection = getConnection();
      FamilyPlanDAO familyPlanDao = new FamilyPlanDAO(connection);
      Collection<PersonValueBean> principalForStage = familyPlanDao.queryPrincipalsForStage(familyPlanBeanFromRequest);
      Collection principalForEvent = familyPlanBeanFromRequest.getPrincipalsForEvent();
      //Iterate through the principals and form a comma separated id_person list for only the Primary Care
      //taker listed as per the enhancement (BF, LF, PF, BM, LM, MP, PK, PA, AB, AP)
      String principalPersonIdList = "0";
      Iterator<PersonValueBean> itPrForStg = principalForStage.iterator();
      while (itPrForStg.hasNext()){
        PersonValueBean pvbPrForStg = (PersonValueBean)itPrForStg.next();
        Iterator itPrForEvt = principalForEvent.iterator();
        while (itPrForEvt.hasNext()){
          PersonValueBean pvbPrForEvt = (PersonValueBean)itPrForEvt.next();
          if ((pvbPrForEvt.getPersonId() == pvbPrForStg.getPersonId())){
            String principalRelIntCd = pvbPrForStg.getRelationshipInterestCode();
            if (principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_BF) || principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_LF)
                            ||principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_PF) || principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_BM)
                            ||principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_LM) || principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_MP)
                            ||principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_PK) || principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_PA)
                            ||principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_AB) || principalRelIntCd.equalsIgnoreCase(CodesTables.CRPTRINT_AP)){
              principalPersonIdList+=", "+pvbPrForEvt.getPersonId();
            }
          }
        }
      }
      int curEventId = 0;
      //Calling the Query to get the Non Approved event list for the given case id and principal list 
      List<Integer> nonApprvEventList = 
        familyPlanDao.queryNotApprvEventsForPrincipalList(familyPlanBeanFromRequest.getCaseId(), 
                                                          principalPersonIdList, curEventId);
      Iterator<Integer> itNonApprvEventList = nonApprvEventList.iterator();
      while (itNonApprvEventList.hasNext()){
        int nonApprvEventId = itNonApprvEventList.next();
        int countDtGoalComp = familyPlanDao.countFamilyPlanItemWtDtGoalComp(nonApprvEventId);
        if (countDtGoalComp > 0){
          validateFailed = true;
          throw new ServiceException(Messages.MSG_SVC_FAMILY_PLAN_ADD_VALID);
        }
      }
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      getSessionContext().setRollbackOnly();
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }    
    return validateFailed;
  }
  /** Gets a JDBC Tx Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }
}
