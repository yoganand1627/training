/**
 * Created on December 19, 2006 at by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;

/** @author vishala devarakonda */

public interface PlanStepDAO {

  /**
   * Updates Plan_Step table
   * 
   * @param planStep
   * 
   * @return
   */
  int savePlanStep(PlanStep planStep);

  /**
   * Updates Plan_Goal and Plan_Step tables
   * 
   * @param idPlanGoal
   * @param idEvent
   * @param cdGoalRsn
   * @param ldTxtGoal
   * @param ldCdTxtOth
   * @param ldTxtGoalTyp
   * @param stepBeanList
   * @param dtLastUpdate
   * @return
   */

  void deletePlanStep(PlanStep planStep);

}