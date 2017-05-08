/**
 * Created on December 19, 2006 at by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanStepDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;

/** @author vishala devarakonda */


public class PlanStepDAOImpl extends BaseDAOImpl implements PlanStepDAO {



 public int  savePlanStep(PlanStep planStep){
   
   
     getSession().saveOrUpdate(planStep);
      return planStep.getIdPlanStep();
 }


public void deletePlanStep(PlanStep planStep){
       getSession().delete(planStep);
}

}