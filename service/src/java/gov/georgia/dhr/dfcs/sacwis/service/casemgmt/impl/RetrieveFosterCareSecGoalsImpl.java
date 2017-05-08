package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanSecGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFosterCareSecGoals;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO;

public class RetrieveFosterCareSecGoalsImpl extends BaseServiceImpl implements RetrieveFosterCareSecGoals {

  private PlanSecGoalDAO planSecGoalDAO = null;

  int idEvent = 0;

  public void setPlanSecGoalDAO(PlanSecGoalDAO planSecGoalDAO) {
    this.planSecGoalDAO = planSecGoalDAO;
  }

  @SuppressWarnings("unchecked")
  public FosterCareSecGoalsRetrieveSO retrieveFosterCareSecGoals(
                                                                 FosterCareSecGoalsRetrieveSI fosterCareSecGoalsRetrieveSi) {
    FosterCareSecGoalsRetrieveSO fosterCareSecGoalsRetrieveSO = new FosterCareSecGoalsRetrieveSO();
    int idEvent = fosterCareSecGoalsRetrieveSi.getEventId();
    int idSecPlansGoals = fosterCareSecGoalsRetrieveSi.getSecGoalsId();
    if (idEvent == 0) {
      return fosterCareSecGoalsRetrieveSO;
    } else {
      List<PlanSecGoal> fosterCareSecGoalsList = new ArrayList();
      // Retrieve sec plan goals based on event id.
      fosterCareSecGoalsList = planSecGoalDAO.findFosterCareSecGoalsList(idEvent);
      List secGoalList = new ArrayList();

      if (fosterCareSecGoalsList != null && !fosterCareSecGoalsList.isEmpty()) {
        for (Iterator it = fosterCareSecGoalsList.iterator(); it.hasNext();) {
          PlanSecGoal planSecGoal = (PlanSecGoal) it.next();
          FosterCareSecGoalsList fosterCareSecGoals = new FosterCareSecGoalsList();
          fosterCareSecGoals.setTxtDesc(planSecGoal.getTxtDesc());
          fosterCareSecGoals.setSelStatus(planSecGoal.getCdStat());
          fosterCareSecGoals.setIndParentApproval(planSecGoal.getIndPrntAppv());
          fosterCareSecGoals.setDtLastUpdateSecGoals(planSecGoal.getDtLastUpdate());
          fosterCareSecGoals.setIdPlanSecGoals(planSecGoal.getIdPlanSecGoal());
          secGoalList.add(fosterCareSecGoals);
        }
      }
      fosterCareSecGoalsRetrieveSO.setSecGoalsList(secGoalList);
    }

    // Retrieve sec plan goals .
    if (idSecPlansGoals != 0) {
      PlanSecGoal planSecGoal = planSecGoalDAO.findFosterCareSecGoalsOnId(idSecPlansGoals);
      if (planSecGoal != null) {
        fosterCareSecGoalsRetrieveSO.setTxtDesc(planSecGoal.getTxtDesc());
        fosterCareSecGoalsRetrieveSO.setSelStatus(planSecGoal.getCdStat());
        fosterCareSecGoalsRetrieveSO.setIndParentApproval(planSecGoal.getIndPrntAppv());
        fosterCareSecGoalsRetrieveSO.setIdPlanSecGoals(planSecGoal.getIdPlanSecGoal());
        fosterCareSecGoalsRetrieveSO.setDtLastUpdateSecGoals(planSecGoal.getDtLastUpdate());
      }
    }
    return fosterCareSecGoalsRetrieveSO;
  }

}
