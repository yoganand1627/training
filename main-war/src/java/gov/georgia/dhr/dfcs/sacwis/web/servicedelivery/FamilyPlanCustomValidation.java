package gov.georgia.dhr.dfcs.sacwis.web.servicedelivery;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanTaskValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Used to perform the custom validation when the user attempts to Save or Save and Submit the Family Plan Detail and/or
 * Family Plan Item Detail pages.
 * 
 * @author Jason Rios 03/05/2003 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup. <p/> 07/02/04
 *         thompswa SIR 22881 The user now is prevented from entering a future date in the 'Date Plan Completed' date
 *         field and in the 'DateCurrentEvalCompleted' date field.
 */
public class FamilyPlanCustomValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "FamilyPlanCustomValidation";

  /**
   * <p>
   * This method contains custom validation for Family Plan activities.
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean isValid = true;

    FamilyPlanValueBean familyPlanBeanFromState = (FamilyPlanValueBean) state.getAttribute("familyPlanBean", request);
    FamilyPlanValueBean familyPlanBeanFromRequest = FamilyPlanConversation.createFamilyPlanValueBean(request);

    // *******************************
    // *** SAVE OR SAVE AND SUBMIT ***
    // *******************************
    if (super.isButtonPressed(FamilyPlanConversation.SAVE_BUTTON_ON_DETAIL_PAGE)
        || super.isButtonPressed(FamilyPlanConversation.SAVE_SUBMIT_BUTTON)) {
      familyPlanBeanFromRequest.setFamilyPlanEvent(familyPlanBeanFromState.getFamilyPlanEvent());

      // At least one principal must be selected.
      String[] checkedPrincipals = CheckboxHelper.getCheckedValues(request, "cbxPrincipalsOnPlan");
      if (checkedPrincipals.length <= 0) {
        isValid = false;
        setErrorMessage(Messages.MSG_SVC_NEED_PRINCIPALS);
      }
      // Page can't be populated if there are more than 100 principals in the stage
      if (checkedPrincipals.length > 100) {
        isValid = false;
        setErrorMessage(Messages.MSG_SVC_LISTBOX_FULL);
      }

      // The 'Date Plan Prepared' date cannot be after today.
      if (familyPlanBeanFromRequest.getDatePlanPrepared() != null) {
        if (DateHelper.isAfterToday(familyPlanBeanFromRequest.getDatePlanPrepared())) {
          isValid = false;
          setErrorMessage("txtDatePlanPrepared", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
        }
      }
      // The 'Date Plan Completed' date cannot be after today.
      if (familyPlanBeanFromRequest.getDatePlanCompleted() != null) {
        if (DateHelper.isAfterToday(familyPlanBeanFromRequest.getDatePlanCompleted())) {
          isValid = false;
          setErrorMessage("txtDatePlanCompleted", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
        }
      }
      // The 'DateCurrentEvalCompleted' date cannot be after today.
      if (familyPlanBeanFromRequest.getDateCurrentEvalCompleted() != null) {
        if (DateHelper.isAfterToday(familyPlanBeanFromRequest.getDateCurrentEvalCompleted())) {
          isValid = false;
          setErrorMessage("txtDateReviewedWithFamily", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
        }
      }

      // 'Next Review Due' date cannot be before the 'Date Plan Completed'.
      if (familyPlanBeanFromRequest.getDatePlanPrepared() != null
          && familyPlanBeanFromRequest.getDateNextEvalDue() != null) {
        if (DateHelper.isBefore(familyPlanBeanFromRequest.getDateNextEvalDue(),
                                familyPlanBeanFromRequest.getDatePlanPrepared())) {
          isValid = false;
          setErrorMessage(Messages.MSG_SVC_REVIEW_BEF_COMP_WARN);
        }
      }

      // If the family plan has never been appproved, the 'Next Review Due' date
      // cannot be more than 3 months beyond the 'Date Plan Completed' for an
      // FPR or FRE stage, or more than 6 months for an FSU stage. If the family
      // plan has already been approved, the 'Next Review Due' date cannot be
      // more than 3 months beyond the 'Current Eval Completed' date for an FPR
      // or FRE stage, or more than 6 months for an FSU stage.
      if (!CodesTables.CEVTSTAT_APRV.equals(familyPlanBeanFromRequest.getFamilyPlanEvent().getEventStatusCode())) {
        if (familyPlanBeanFromRequest.getDatePlanPrepared() != null
            && familyPlanBeanFromRequest.getDateNextEvalDue() != null) {
          org.exolab.castor.types.Date datePlanComp = familyPlanBeanFromRequest.getDatePlanPrepared();
          org.exolab.castor.types.Date nextEvalDue = familyPlanBeanFromRequest.getDateNextEvalDue();

          // Get the number of days/months between the 'Date Plan Completed'
          // and 'Next Review Due' date. (The Vector returned by the
          // getDatesInRange() method includes the 'Date Plan Completed', so
          // subtract 1 from the total size.)
          gov.georgia.dhr.dfcs.sacwis.core.utility.Date datePlanCompAsImpactUtilDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                                                                                                                                         datePlanComp
                                                                                                                                                     .getDay(),
                                                                                                                                         datePlanComp
                                                                                                                                                     .getMonth(),
                                                                                                                                         datePlanComp
                                                                                                                                                     .getCentury()
                                                                                                                                                         * 100
                                                                                                                                                         + datePlanComp
                                                                                                                                                                       .getYear());
          gov.georgia.dhr.dfcs.sacwis.core.utility.Date nextReviewDueAsImpactUtilDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                                                                                                                                          nextEvalDue
                                                                                                                                                     .getDay(),
                                                                                                                                          nextEvalDue
                                                                                                                                                     .getMonth(),
                                                                                                                                          nextEvalDue
                                                                                                                                                     .getCentury()
                                                                                                                                                          * 100
                                                                                                                                                          + nextEvalDue
                                                                                                                                                                       .getYear());
          int numOfMonthsInRange = DateUtility.getDatesInRange(datePlanCompAsImpactUtilDate,
                                                               nextReviewDueAsImpactUtilDate, DateUtility.MONTH, 1)
                                              .size() - 1;

          if (numOfMonthsInRange > 3) {
            isValid = false;
            setErrorMessage(Messages.MSG_FP_REV_WITHIN_THREE_MONTHS);

          }
        } // end if ( familyPlanBean.getDatePlanPrepared() != null && familyPlanBean.getDateNextEvalDue() != null )
      } else {
        if (familyPlanBeanFromRequest.getDateCurrentEvalCompleted() != null
            && familyPlanBeanFromRequest.getDateNextEvalDue() != null) {
          org.exolab.castor.types.Date currEvalComp = familyPlanBeanFromRequest.getDateCurrentEvalCompleted();
          org.exolab.castor.types.Date nextEvalDue = familyPlanBeanFromRequest.getDateNextEvalDue();

          // Get the number of days/months between the 'Current Review
          // Completed' and 'Next Review Due' date. (The Vector returned by the
          // getDatesInRange() method includes the 'Current Review Completed'
          // date, so subtract 1 from the total size.)
          gov.georgia.dhr.dfcs.sacwis.core.utility.Date currEvalCompAsImpactUtilDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                                                                                                                                         currEvalComp
                                                                                                                                                     .getDay(),
                                                                                                                                         currEvalComp
                                                                                                                                                     .getMonth(),
                                                                                                                                         currEvalComp
                                                                                                                                                     .getCentury()
                                                                                                                                                         * 100
                                                                                                                                                         + currEvalComp
                                                                                                                                                                       .getYear());
          gov.georgia.dhr.dfcs.sacwis.core.utility.Date nextReviewDueAsImpactUtilDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                                                                                                                                          nextEvalDue
                                                                                                                                                     .getDay(),
                                                                                                                                          nextEvalDue
                                                                                                                                                     .getMonth(),
                                                                                                                                          nextEvalDue
                                                                                                                                                     .getCentury()
                                                                                                                                                          * 100
                                                                                                                                                          + nextEvalDue
                                                                                                                                                                       .getYear());
          int numOfMonthsInRange = DateUtility.getDatesInRange(currEvalCompAsImpactUtilDate,
                                                               nextReviewDueAsImpactUtilDate, DateUtility.MONTH, 1)
                                              .size() - 1;

          if (numOfMonthsInRange > 3) {
            isValid = false;
            setErrorMessage(Messages.MSG_FP_REV_WITHIN_THREE_MONTHS);
          }

        } // end if ( familyPlanBean.getDatePlanPrepared() != null && familyPlanBean.getDateNextEvalDue() != null )
      } // end if ( familyPlanBean.getFamilyPlanEvent().getApprovalDate() == null )
    }

    // ***********************
    // *** SAVE AND SUBMIT ***
    // ***********************
    if (super.isButtonPressed(FamilyPlanConversation.SAVE_SUBMIT_BUTTON)) {
      // 'Date Plan Prepared' is required to save and submit.
      if (familyPlanBeanFromRequest.getDatePlanPrepared() == null) {
        isValid = false;
        setErrorMessage(Messages.MSG_SVC_CMPLTD_NOT_FLLD);
      }

      // 'Next Review Due' is required to save and submit.
      if (familyPlanBeanFromRequest.getDateNextEvalDue() == null) {
        isValid = false;
        setErrorMessage(Messages.MSG_SVC_NXT_REV_NOT_FLLD);
      }

      // 'Date Reviewed with Familiy' is required to save and submit.
      if (familyPlanBeanFromRequest.getDateCurrentEvalCompleted() == null) {
        isValid = false;
        setErrorMessage(Messages.MSG_SVC_FAM_REV_NOT_FLLD);
      }

      // 'Reason for CPS Involvement' is required to save and submit.
      if (familyPlanBeanFromRequest.getReasonForCPSInvolvement() == null) {
        isValid = false;
        setErrorMessage("txtReasonForInvolvement", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
      }

      // 'Description of Family Strengths and Resources' is required to save
      // and submit.
      if (familyPlanBeanFromRequest.getStrengthsAndResources() == null) {
        isValid = false;
        setErrorMessage("txtStrengthsResources", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
      }
      if (familyPlanBeanFromState.getRiskAssessmentEventId() > 0) {
        CaseUtility.Event riskAssmtEvent = CaseUtility.getEvent(familyPlanBeanFromState.getRiskAssessmentEventId());
        if (riskAssmtEvent != null
                        && !(CodesTables.CEVTSTAT_APRV.equals(riskAssmtEvent.getCdEventStatus())
                            || CodesTables.CEVTSTAT_COMP.equals(riskAssmtEvent.getCdEventStatus()))) {
          isValid = false;
          setErrorMessage(Messages.MSG_RISK_AS_REQ);
        }

      }

      // Item must have Current Level of Concern if it was imported from the
      // Risk Assessment.
      // (The family plan bean from state must be used for this validation
      // because the family plan bean created from the request does not contain
      // items data.)
      List familyPlanItemsVector = (List) familyPlanBeanFromState.getFamilyPlanItemList();
      Iterator itemsIter = familyPlanItemsVector.iterator();
      while (itemsIter.hasNext()) {
        FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) itemsIter.next();

        if (itemBean.isIdentifiedInRiskAssessment() && itemBean.getCurrentLevelOfConcernScale() == null) {
          isValid = false;
          setErrorMessage(Messages.MSG_FP_AREA_NEEDS_CURRENT_LOC);
          break;
        }
      } // end while ( itemsIter.hasNext() )

      // Item must have at least one task/service that is not completed if:
      // 1. Current Level of Concern is 'Somewhat' or greater, or
      // 2. Current Level of Concern is blank, and Initial Level of Concern
      // is 'Somewhat' or greater.
      // (The family plan bean from state must be used for this validation
      // because the family plan bean created from the request does not contain
      // items data.)
      itemsIter = familyPlanItemsVector.iterator();
      while (itemsIter.hasNext()) {
        FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) itemsIter.next();

        if (CodesTables.CRISKSOC_3.equals(itemBean.getCurrentLevelOfConcernScale())
            || CodesTables.CRISKSOC_4.equals(itemBean.getCurrentLevelOfConcernScale())
            || CodesTables.CRISKSOC_5.equals(itemBean.getCurrentLevelOfConcernScale())
            || (itemBean.getCurrentLevelOfConcernScale() == null && (CodesTables.CRISKSOC_3
                                                                                           .equals(itemBean
                                                                                                           .getInitialLevelOfConcernScale())
                                                                     || CodesTables.CRISKSOC_4
                                                                                              .equals(itemBean
                                                                                                              .getInitialLevelOfConcernScale()) || CodesTables.CRISKSOC_5
                                                                                                                                                                         .equals(itemBean
                                                                                                                                                                                         .getInitialLevelOfConcernScale())))) {
          List tasksVector = (List) itemBean.getTasks();

          // If the tasksVector is empty, this item definitely has no
          // uncompleted tasks. Set the error message, and break out of the
          // while loop. Otherwise, loop through the tasks, and check for an
          // uncompleted one.
          if (tasksVector == null) {
            isValid = false;
            String errorMessage = "<a href='#" + itemBean.getAreaOfConcernCode() + "'>"
                                  + itemBean.getAreaOfConcernText() + "</a> - "
                                  + MessageLookup.getMessageByNumber(Messages.MSG_SVC_NEED_PGTS);
            setErrorMessage(errorMessage);
          } else {
            boolean hasUncompletedTask = false;
            Iterator tasksIter = tasksVector.iterator();
            while (tasksIter.hasNext()) {
              FamilyPlanTaskValueBean taskBean = (FamilyPlanTaskValueBean) tasksIter.next();
              if (taskBean.getDateTaskCompleted() == null) {
                hasUncompletedTask = true;
                break;
              }
            } // end while ( iter.hasNext() )

            // If this item has no uncompleted tasks, set the error message, and
            // break out of the while loop.
            if (!hasUncompletedTask) {
              isValid = false;
              String errorMessage = "<a href='#" + itemBean.getAreaOfConcernCode() + "'>"
                                    + itemBean.getAreaOfConcernText() + "</a> - "
                                    + MessageLookup.getMessageByNumber(Messages.MSG_SVC_NEED_PGTS);
              setErrorMessage(errorMessage);
            } // end if( !hasUncompletedTask )
          } // end if( tasksVector == null )
        } // end if( CodesTables.CRISKSOC_3.equals( itemBean.getCurrentLevelOfConcernScale() ) ||...
      } // end while ( itemsIter.hasNext() )

      // To save and submit an evaluation...
      String taskCode = GlobalData.getSzCdTask(request);
      if (taskCode.equals(FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN_EVAL)
          || taskCode.equals(FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN_EVAL)
          || taskCode.equals(FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN_EVAL)) {
        // 'Current Review Completed' is required.
        if (familyPlanBeanFromRequest.getDateCurrentEvalCompleted() == null) {
          isValid = false;
          setErrorMessage("txtDateReviewedWithFamily", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }

        // Each Area of Concern that was addressed prior to the most recent
        // approval date (meaning it has been reviewed and approved by a supervisor)
        // must have a Current Level of Concern. Also, if the Current Level of
        // Concern is 'Somewhat' or greater, it must have been evaluated during
        // this evaluation.
        Date mostRecentApprovalDate = FamilyPlanConversation.getMostRecentApprovalDate(familyPlanBeanFromState);
        itemsIter = familyPlanItemsVector.iterator();
        while (itemsIter.hasNext()) {
          FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) itemsIter.next();

          if (itemBean.getDateInitiallyAddressed() != null && mostRecentApprovalDate != null
              && itemBean.getDateInitiallyAddressed().before(mostRecentApprovalDate)) {
            if (itemBean.getCurrentLevelOfConcernScale() == null) {
              isValid = false;
              String errorMessage = "<a href='#" + itemBean.getAreaOfConcernCode() + "'>"
                                    + itemBean.getAreaOfConcernText()
                                    + "</a> - Please enter a 'Current Level of Concern' for this Area of Concern.";
              setErrorMessage(errorMessage);
            } else if (CodesTables.CRISKSOC_3.equals(itemBean.getCurrentLevelOfConcernScale())
                       || CodesTables.CRISKSOC_4.equals(itemBean.getCurrentLevelOfConcernScale())
                       || CodesTables.CRISKSOC_5.equals(itemBean.getCurrentLevelOfConcernScale())) {
              // If there are no eval items, obviously this Area of Concern has
              // not been evaluated for this evaluation. Set the error message for
              // this Area of Concern.
              if (itemBean.getEvalItems() == null) {
                isValid = false;
                String errorMessage = "<a href='#" + itemBean.getAreaOfConcernCode() + "'>"
                                      + itemBean.getAreaOfConcernText()
                                      + "</a> - Please enter an evaluation for this Area of Concern.";
                setErrorMessage(errorMessage);
              } else {
                // If the most recent eval item does not belong to the current
                // evaluation, then an eval item has not been entered for this
                // evaluation. Set the error message for this Area of Concern.
                FamilyPlanEvalItemValueBean mostRecentEvalItem = null;
                mostRecentEvalItem = (FamilyPlanEvalItemValueBean) itemBean.getEvalItems().iterator().next();
                if (mostRecentEvalItem.getFamilyPlanEvalEventId() != GlobalData.getUlIdEvent(request)) {
                  isValid = false;
                  String errorMessage = "<a href='#" + itemBean.getAreaOfConcernCode() + "'>"
                                        + itemBean.getAreaOfConcernText()
                                        + "</a> - Please enter an evaluation for this Area of Concern.";
                  setErrorMessage(errorMessage);
                }
              } // end if( itemBean.getEvalItems() == null )
            } // end else if( CodesTables.CRISKSOC_3.equals( itemBean.getCurrentLevelOfConcernScale() ) ||...
          } // end if( itemBean.getDateInitiallyAddressed() != null &&...
        } // end while( itemsIter.hasNext() )
      } // end if ( taskCode.equals( FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN_EVAL ) ||...
    } // end if ( super.isButtonPressed( FamilyPlanConversation.SAVE_SUBMIT_BUTTON ) )

    // **********************************
    // *** SAVE (ON ITEM DETAIL PAGE) ***
    // **********************************
    if (super.isButtonPressed(FamilyPlanConversation.SAVE_BUTTON_ON_ITEM_PAGE)) {
      FamilyPlanItemValueBean familyPlanItemBean = FamilyPlanConversation.createFamilyPlanItemValueBean(request);
      List tasksVector = (List) familyPlanItemBean.getTasks();

      // 'Task Created' is required for each Task/Service that has a value.
      int loopCounter = 0;
      Iterator iter = tasksVector.iterator();
      while (iter.hasNext()) {
        FamilyPlanTaskValueBean taskBean = (FamilyPlanTaskValueBean) iter.next();
        if (taskBean.getTask() != null && taskBean.getDateTaskCreated() == null) {
          isValid = false;
          String fieldName = "txtDateCreated" + loopCounter;
          setErrorMessage(fieldName, Messages.SSM_COMPLETE_REQUIRED);
        }
        if(taskBean.getTask() != null && taskBean.isCourtMandatedClosure() && taskBean.getDateCourtAction()== null){
          isValid = false;
          String fieldName = "cbxCourtOrdered" + loopCounter;
          setErrorMessage(fieldName, Messages.MSG_DT_CRT_ACTION_REQ); 
        }
        if(familyPlanItemBean.getDateGoalsCompleted()!=null && (taskBean.getDateTaskCompleted()==null && (taskBean.isCourtMandatedClosure() && taskBean.getDateCourtAction()!= null))){
          isValid = false;
          String fieldName = "txtDateCompleted" + loopCounter;
          setErrorMessage(
                          fieldName,
                          Messages.MSG_DT_TSK_COMP_REQ); 
        }
        loopCounter++;
      } // end while ( iter.hasNext() )
    } // end if ( super.isButtonPressed( FamilyPlanConversation.SAVE_BUTTON_ON_ITEM_PAGE ) )

    // ********************************************
    // *** USED FOR 'FAMILY PLAN SELECTOR' PAGE ***
    // ********************************************
    // If the user selected a family plan to be evaluated, check that the family
    // plan has no unapproved evaluations.
    int selectedFamilyPlanEventId = ContextHelper.getIntSafe(request, "selectedFamilyPlanEventId");
    if (selectedFamilyPlanEventId > 0) {
      // Find the family plan the user selected.
      ArrayList approvedFamilyPlans = (ArrayList) state.getAttribute("approvedFamilyPlans", request);
      Iterator iter = approvedFamilyPlans.iterator();
      while (iter.hasNext()) {
        FamilyPlanValueBean familyPlanBean = (FamilyPlanValueBean) iter.next();
        if (familyPlanBean.getFamilyPlanEvent().getEventId() == selectedFamilyPlanEventId) {
          // Now check the family plan for any unapproved evaluations.
          if (familyPlanBean.getFamilyPlanEvaluations() != null) {
            ArrayList familyPlanEvaluations = (ArrayList) familyPlanBean.getFamilyPlanEvaluations();
            Iterator iter2 = familyPlanEvaluations.iterator();
            while (iter2.hasNext()) {
              // If the evaluation is unapproved, notify the user that they cannot
              // create a new evaluation yet.
              FamilyPlanEvalValueBean familyPlanEval = (FamilyPlanEvalValueBean) iter2.next();
              if (!CodesTables.CEVTSTAT_APRV.equals(familyPlanEval.getEvalEvent().getEventStatusCode())) {
                isValid = false;
                setErrorMessage(Messages.MSG_FP_PLAN_HAS_PROC_EVAL);
                break;
              }
            } // end while( iter2.hasNext() )
          } // end if ( familyPlanBean.getFamilyPlanEvaluations() != null )
        } // end if( familyPlanBean.getFamilyPlanEvent().getEventId() == selectedFamilyPlanEventId )
      } // end while( iter.hasNext() )
    } // end if( selectedFamilyPlanEventId > 0 )

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return isValid;
  }
}
