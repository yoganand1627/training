/**
 * Created on December 19, 2006 at by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;

import java.util.List;

import org.hibernate.Query;

/** @author vishala devarakonda */
/**
 * This is the DAO class for PLAN_GOAL
 * 
 * 
 * <pre>
 *  Change History:
 *  Date          User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  04/01/2009    bgehlot      STGAP00012833 - Added findFCGSByIdEventByCdGoalTypeCdGoalRsn() method 
 */
public class PlanGoalDAOImpl extends BaseDAOImpl implements PlanGoalDAO {


  @SuppressWarnings( { "unchecked" })
  public List<PlanGoal> findFCGSByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           "     from PlanGoal a" + "    where a.event.idEvent = :idEvent"
                                                           + " order by a.dtLastUpdate desc");
    query.setInteger("idEvent", idEvent);
    return (List<PlanGoal>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<PlanGoal> findFCGSByIdEventByCdGoalType(int idEvent, String cdGoalTyp) {
    Query query = getSession().createQuery(
                                           " from PlanGoal a where a.event.idEvent = :idEvent" +
                                           " and a.cdGoalTyp = :cdGoalTyp order by a.dtLastUpdate desc");
    query.setInteger("idEvent", idEvent);
    query.setString("cdGoalTyp", cdGoalTyp);
    return (List<PlanGoal>) query.list();
  }

  public PlanGoal findFCGSByIdGoal(int idGoal) {
    Query query = getSession().createQuery(
                                           "     from PlanGoal a" + "    where a.idPlanGoal = :idGoal"
                                                           + " order by a.dtLastUpdate desc");
    query.setInteger("idGoal", idGoal);
    return (PlanGoal) firstResult(query);
  }
  
  //STGAP00012833: Find the Goal for the Goal type and reason
  public PlanGoal findFCGSByIdEventByCdGoalTypeCdGoalRsn(int idEvent, String cdGoalTyp, String cdGoalRsn) {
    Query query = getSession().createQuery(
                                           " from PlanGoal a where a.event.idEvent = :idEvent" +
                                           " and a.cdGoalTyp = :cdGoalTyp "
                                           + " and a.cdGoalRsn = :cdGoalRsn "
                                           + " order by a.dtLastUpdate desc");
    query.setInteger("idEvent", idEvent);
    query.setString("cdGoalTyp", cdGoalTyp);
    query.setString("cdGoalRsn", cdGoalRsn);
    return (PlanGoal) firstResult(query);
  }

 public int  savePlanGoal(PlanGoal planGoal){

    getSession().saveOrUpdate(planGoal);
      return planGoal.getIdPlanGoal();
 }


public void deletePlanGoal(PlanGoal planGoal){
       getSession().delete(planGoal);
}

}