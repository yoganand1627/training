package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyPlan;

public interface SpSafetyPlanDAO {

  /**
   * Retrieves a complete single row from the SaSafetyPlane table. <p/>
   * 
   * @param idEvent
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  SpSafetyPlan findSpSafetyPlan(int idEvent);

  /**
   * Save a {@link gov.georgia.dhr.dfcs.sacwis.db.SpSafetyPlan} object into the database.
   * 
   * @param spSafetyPlan
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.SpSafetyPlan} object.
   */
  void saveSpSafetyPlan(SpSafetyPlan spSafetyPlan);
  
  void deleteSpSafetyPlan(SpSafetyPlan spSafetyPlan);
  
  int deleteSpSafetyPlan(int idEvent, Date dtLastUpdate);

}
