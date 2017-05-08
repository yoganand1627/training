package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal;

public interface PlanSecGoalDAO {

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal} object to the database.
   * 
   * @param PlanSecGoal
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal} object.
   */
  void saveFosterCareSecGoals(PlanSecGoal planSecGoal);

  /**
   * Retrieves all secondary goals from the plan_sec_goal table given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  // @SuppressWarnings({"unchecked"})
  List<PlanSecGoal> findFosterCareSecGoalsList(int idEvent);

  /**
   * Retrieves all Secondary Goals Info from the plan_sec_goal table given secondary goal id. <p/>
   * 
   * @param idFosterCareSecGoals
   * @return
   */
  // @SuppressWarnings({"unchecked"})
  PlanSecGoal findFosterCareSecGoalsOnId(int idFosterCareSecGoals);

  /**
   * Deletes all secondary goals from the plan_sec_goal table given sec goal plan id. <p/>
   * 
   * @param idFosterCareSecGoals
   * @return
   */
  // @SuppressWarnings({"unchecked"})
  int deleteFosterCareSecGoals(int idFosterCareSecGoals);

}
