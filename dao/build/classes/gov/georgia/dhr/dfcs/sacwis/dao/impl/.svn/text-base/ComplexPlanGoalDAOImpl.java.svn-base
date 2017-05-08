package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanStepDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/** @author vishala devarakonda */

public class ComplexPlanGoalDAOImpl extends BaseDAOImpl implements ComplexPlanGoalDAO {

  private PlanGoalDAO planGoalDAO = null;

  public void setPlanGoalDAO(PlanGoalDAO planGoalDAO) {
    this.planGoalDAO = planGoalDAO;
  }

  private PlanStepDAO planStepDAO = null;

  public void setPlanStepDAO(PlanStepDAO planStepDAO) {
    this.planStepDAO = planStepDAO;
  }

  @SuppressWarnings("unchecked")
  public int updateFCGS(int idPlanGoal, int idEvent, PlanGoal goal, Collection planStepList, String cdScrDataAction,
                        List<String> dataActionList) {

    String cdScrDataAction_step = "";
    int result = 0;
    int idGoal = 0;

    Event event = new Event();
    if (idEvent != 0) {
      event = (Event) getSession().load(Event.class, idEvent);
    }
    goal.setEvent(event);
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
      goal = (PlanGoal) getSession().load(PlanGoal.class, idPlanGoal);
    } else {
      goal.setIdPlanGoal(idPlanGoal);
    }
    int size = planStepList.size();
    int i = 0;
    if (size != 0) {
      for (Iterator it = planStepList.iterator(); it.hasNext();) {
        PlanStep planStep = new PlanStep();
        planStep = (PlanStep) it.next();
        int idStep = planStep.getIdPlanStep();
        cdScrDataAction_step = dataActionList.get(i);
        if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction_step)) {
          if (idStep != 0) {
            planStep = (PlanStep) getSession().load(PlanStep.class, idStep);
          }
          planStepDAO.deletePlanStep(planStep);
          result = 1;
        }
              i++;
      }
    }
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
      // As all the child steps are already deleted in the previous loop this
      // will delete the parent goal.
      planGoalDAO.deletePlanGoal(goal);
      result = 1;
    } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)
               || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
      // First the goal is saved with out any steps and the id Goal is returned.
      idGoal = planGoalDAO.savePlanGoal(goal);

      if (idGoal != 0) {
        // Once the Goal is saved successfully the corresponding steps are saved.
        PlanGoal planGoal = new PlanGoal();
        planGoal = (PlanGoal) getSession().load(PlanGoal.class, idGoal);

        for (Iterator it = planStepList.iterator(); it.hasNext();) {
          PlanStep planStep = (PlanStep) it.next();
          planStep.setPlanGoal(planGoal);
          int count = planStepDAO.savePlanStep(planStep);
          if (count == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        }
        result++;
      }

    }
    return result;
  }

}