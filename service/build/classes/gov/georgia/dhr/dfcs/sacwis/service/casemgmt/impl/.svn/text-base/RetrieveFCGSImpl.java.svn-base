package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.PlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFCGS;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** @author vishala devarakonda */

public class RetrieveFCGSImpl extends BaseServiceImpl implements RetrieveFCGS {

  private PlanGoalDAO planGoalDAO = null;

  public void setPlanGoalDAO(PlanGoalDAO planGoalDAO) {
    this.planGoalDAO = planGoalDAO;
  }

  @SuppressWarnings("unchecked")
  public FCGSRetrieveSO retrieveFCGS(FCGSRetrieveSI fcgsRetrieveSI) {
    FCGSRetrieveSO fcgsRetrieveSO = new FCGSRetrieveSO();
    if (fcgsRetrieveSI.getUlIdGoal() != 0) {

      // In case of deleting the step the control is supposed to come back to
      // the FCGS Detail page with the updated Goal data.So The goal is retrieved
      // by passing the idGoal.

      int idGoal = fcgsRetrieveSI.getUlIdGoal();
      PlanGoal planGoal = planGoalDAO.findFCGSByIdGoal(idGoal);
      GoalsBean goalBean = new GoalsBean();
      List<StepBean> stepBeanList = new ArrayList();
      goalBean.setCdGoalRsn(planGoal.getCdGoalRsn());
      goalBean.setCdGoalTyp(planGoal.getCdGoalTyp());
      goalBean.setIdGoal(planGoal.getIdPlanGoal());
      goalBean.setLdTxtGoal(planGoal.getTxtGoal());
      goalBean.setLdTxtOther(planGoal.getTxtOth());
      goalBean.setDtLastUpdate(planGoal.getDtLastUpdate());
      for (Iterator stepIt = planGoal.getPlanSteps().iterator(); stepIt.hasNext();) {
        PlanStep planStep = (PlanStep) stepIt.next();
        StepBean stepBean = new StepBean();
        stepBean.setDtActComp(planStep.getDtActComp());
        stepBean.setDtAntComp(planStep.getDtAntComp());
        stepBean.setIdStep(planStep.getIdPlanStep());
        stepBean.setIndSelected(planStep.getIndSelected());
        stepBean.setLdCdStatus(planStep.getCdStatus());
        stepBean.setLdTxtPriority(planStep.getTxtPriority());
        stepBean.setLdTxtResponsibility(planStep.getTxtRspns());
        stepBean.setDtLastUpdate(planStep.getDtLastUpdate());
        stepBean.setLdTxtStep(planStep.getTxtStep());
        stepBean.setLdTxtStepCmnts(planStep.getTxtStepComm());
        stepBean.setLdCdStepCode(planStep.getCdStepCode());
        stepBeanList.add(stepBean);
      }
      goalBean.setStepBeanList(stepBeanList);
      fcgsRetrieveSO.setGoalBean(goalBean);
    } else {
      int idEvent = fcgsRetrieveSI.getUlIdEvent();
      List<PlanGoal> goalsBeanList = planGoalDAO.findFCGSByIdEvent(idEvent);
      List goalRowList = new ArrayList();
      // It is possible for a plan to be entered into the system with no
      // rows in the Goal Step tables.
      // Therefore we will not handle SQL_NOT_FOUND.
      fcgsRetrieveSO.setUlIdEvent(idEvent);
      if (goalsBeanList != null && !goalsBeanList.isEmpty()) {
        for (Iterator it = goalsBeanList.iterator(); it.hasNext();) {
          PlanGoal fcgs = (PlanGoal) it.next();
          GoalsBean goalRow = new GoalsBean();
          List<StepBean> stepBeanList = new ArrayList();
          goalRow.setCdGoalRsn(fcgs.getCdGoalRsn());
          goalRow.setCdGoalTyp(fcgs.getCdGoalTyp());
          goalRow.setIdGoal(fcgs.getIdPlanGoal());
          goalRow.setLdTxtGoal(fcgs.getTxtGoal());
          goalRow.setLdTxtOther(fcgs.getTxtOth());
          goalRow.setDtLastUpdate(fcgs.getDtLastUpdate());
          for (Iterator stepIt = fcgs.getPlanSteps().iterator(); stepIt.hasNext();) {
            PlanStep planStep = (PlanStep) stepIt.next();
            StepBean stepBean = new StepBean();
            stepBean.setDtActComp(planStep.getDtActComp());
            stepBean.setDtAntComp(planStep.getDtAntComp());
            stepBean.setIdStep(planStep.getIdPlanStep());
            stepBean.setIndSelected(planStep.getIndSelected());
            stepBean.setLdCdStatus(planStep.getCdStatus());
            stepBean.setLdTxtPriority(planStep.getTxtPriority());
            stepBean.setLdTxtResponsibility(planStep.getTxtRspns());
            stepBean.setLdTxtStep(planStep.getTxtStep());
            stepBean.setLdTxtStepCmnts(planStep.getTxtStepComm());
            stepBean.setDtLastUpdate(planStep.getDtLastUpdate());
            stepBean.setLdCdStepCode(planStep.getCdStepCode());
            stepBeanList.add(stepBean);
          }
          goalRow.setStepBeanList(stepBeanList);
          goalRowList.add(goalRow);
        }
      }

      fcgsRetrieveSO.setGoalBeanList(goalRowList);
    }

    return fcgsRetrieveSO;
  }
}
