/**
 * Created on December 19, 2006 at by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;

import java.util.Collection;
import java.util.List;

/** @author vishala devarakonda */

public interface PlanGoalDAO {

  /**
   * Retrieves all Goals from the Plan_Goal table given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  // @SuppressWarnings({"unchecked"})
  List<PlanGoal> findFCGSByIdEvent(int idEvent);

  /**
   * Retrieves all Goals from the Plan_Goal table given idEvent. <p/>
   * 
   * @param idEvent
   * @param cdGoalType
   * @return List<PlanGoal>
   */
  List<PlanGoal> findFCGSByIdEventByCdGoalType(int idEvent, String cdGoalTyp);
  
  /**
   * Retrieves all Goals from the Plan_Goal table given idEvent and cdGoalTyp combination. <p/>
   * 
   * @param idEventsCol
   * @param cdGoalTypsCol
   * @return List<PlanGoal>
   */  
  // @SuppressWarnings({"unchecked"})
  PlanGoal findFCGSByIdGoal(int idGoal);
  
  /**
   * STGAP00012833: Find the Goal for the Goal type and reason
   * @param idEvent
   * @param cdGoalTyp
   * @param cdGoalRsn
   * @return PlanGoal
   */
  PlanGoal findFCGSByIdEventByCdGoalTypeCdGoalRsn(int idEvent, String cdGoalTyp, String cdGoalRsn);

  /**
   * Updates Plan_Goal and Plan_Step tables
   * 
   * @param planGoal
   * 
   * @return
   */
  int savePlanGoal(PlanGoal planGoal);

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

  void deletePlanGoal(PlanGoal planGoal);

}