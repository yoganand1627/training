package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;

import java.util.List;
import java.util.Map;

public interface DynamicPlanGoalDAO {
  /**
   * Fetches PlanGoal records from the database based on inputs
   * from FCCPFamilyDetailFormImpl page
   * @param eventGoal: Map contains event ID and Goal Cd
   * @return List of PlanGoal objects
   */
  List<PlanGoal> findFCGSByIdEventsByCdGoalTypes(Map<Integer, String> eventGoal);
}
