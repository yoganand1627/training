package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveFCGS;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSSaveSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/** @author vishala devarakonda */
public class SaveFCGSImpl extends BaseServiceImpl implements SaveFCGS {

  private ComplexPlanGoalDAO complexPlanGoalDAO = null;

  public void setComplexPlanGoalDAO(ComplexPlanGoalDAO complexPlanGoalDAO) {
    this.complexPlanGoalDAO = complexPlanGoalDAO;
  }

  public FCGSSaveSO updateFCGSInformation(FCGSSaveSI fcgsSaveSI) throws ServiceException {
    FCGSSaveSO fcgsSaveSO = new FCGSSaveSO();
    saveFCGS(fcgsSaveSI);
    return fcgsSaveSO;
  }

  @SuppressWarnings("unchecked")
  private void saveFCGS(FCGSSaveSI fcgsSaveSI) throws ServiceException {

    GoalsBean row = (GoalsBean) fcgsSaveSI.getGlBean();
    List<StepBean> stepBeanList = new ArrayList<StepBean>();
    Collection planStepList = new ArrayList();
    List<String> dataActionList = new ArrayList<String>();
    PlanGoal goal = new PlanGoal();
    String dataAction = "";
    String cdGoalRsn = row.getCdGoalRsn();
    String ldTxtGoal = row.getLdTxtGoal();
    String ldTxtOth = row.getLdTxtOth();
    String ldTxtGoalTyp = row.getCdGoalTyp();
    stepBeanList = row.getStepBeanList();
    Date tsLastUpdate = row.getDtLastUpdate();
    String cdScrDataAction = row.getCdScrDataAction();
    int idEvent = fcgsSaveSI.getUlIdEvent();
    int idPlanGoal = row.getIdGoal();
    int nbrRowsUpdated;

    goal.setCdGoalRsn(cdGoalRsn);
    goal.setCdGoalTyp(ldTxtGoalTyp);
    goal.setTxtGoal(ldTxtGoal);
    goal.setTxtOth(ldTxtOth);
    goal.setDtLastUpdate(tsLastUpdate);

    int size = stepBeanList.size();

    if (size != 0) {
      for (Iterator it = stepBeanList.iterator(); it.hasNext();) {
        StepBean stepBean = (StepBean) it.next();
        PlanStep planStep = new PlanStep();
        int idStep = stepBean.getIdStep();
        dataAction = stepBean.getCdScrDataAction();
        dataActionList.add(dataAction);
        planStep.setIdPlanStep(idStep);
        planStep.setCdStatus(stepBean.getLdCdStatus());
        planStep.setCdStepCode(stepBean.getLdCdStepCode());
        planStep.setDtActComp(stepBean.getDtActComp());
        planStep.setDtAntComp(stepBean.getDtAntComp());
        planStep.setIndSelected(stepBean.getIndSelected());
        planStep.setTxtPriority(stepBean.getLdTxtPriority());
        planStep.setTxtRspns(stepBean.getLdTxtResponsibility());
        planStep.setTxtStep(stepBean.getLdTxtStep());
        planStep.setTxtStepComm(stepBean.getLdTxtStepCmnts());
        planStep.setDtLastUpdate(stepBean.getDtLastUpdate());
        planStepList.add(planStep);
      }
    }

    // For save, update or delete the complex dao is called
    nbrRowsUpdated = complexPlanGoalDAO.updateFCGS(idPlanGoal, idEvent, goal, planStepList, cdScrDataAction,
                                                   dataActionList);

    if (nbrRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }
}
