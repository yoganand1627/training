package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveFosterCareSecGoals;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsSaveSO;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanSecGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal;
import gov.georgia.dhr.dfcs.sacwis.db.Event;

public class SaveFosterCareSecGoalsImpl extends BaseServiceImpl implements SaveFosterCareSecGoals {

  private PlanSecGoalDAO planSecGoalDAO = null;

  public void setPlanSecGoalDAO(PlanSecGoalDAO planSecGoalDAO) {
    this.planSecGoalDAO = planSecGoalDAO;
  }

  public FosterCareSecGoalsSaveSO saveFosterCareSecGoals(FosterCareSecGoalsSaveSI fosterCareSecGoalsSaveSI)
                                                                                                           throws ServiceException {
    FosterCareSecGoalsSaveSO fosterCareSecGoalsSaveSO = new FosterCareSecGoalsSaveSO();
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(fosterCareSecGoalsSaveSI.getCdReqFuncCd())) {
      // delete foster care sec goals.
      planSecGoalDAO.deleteFosterCareSecGoals(fosterCareSecGoalsSaveSI.getIdPlanSecGoals());
    } else {
      // save foster care secondary goals details.
      saveFosterCareSecGoal(fosterCareSecGoalsSaveSI);
    }
    return fosterCareSecGoalsSaveSO;
  }

  // save foster care secondary goals to plan_sec_goal table.
  private void saveFosterCareSecGoal(FosterCareSecGoalsSaveSI fosterCareSecGoalsSaveSI) throws ServiceException {

    PlanSecGoal planSecGoal = new PlanSecGoal();

    int idEvent = fosterCareSecGoalsSaveSI.getEventId();
    int idPlanSecGoal = fosterCareSecGoalsSaveSI.getIdPlanSecGoals();
    if (idPlanSecGoal != 0) {
      planSecGoal.setIdPlanSecGoal(idPlanSecGoal);
    }
    planSecGoal.setDtLastUpdate(fosterCareSecGoalsSaveSI.getDtLastUpdateSecGoals());
    planSecGoal.setTxtDesc(fosterCareSecGoalsSaveSI.getTxtDesc());
    planSecGoal.setIndPrntAppv(fosterCareSecGoalsSaveSI.getIndParentApproval());
    planSecGoal.setCdStat(fosterCareSecGoalsSaveSI.getSelStatus());
    Event event = (Event) getPersistentObject(Event.class, idEvent);
    planSecGoal.setEvent(event);
    planSecGoalDAO.saveFosterCareSecGoals(planSecGoal);
  }

}
