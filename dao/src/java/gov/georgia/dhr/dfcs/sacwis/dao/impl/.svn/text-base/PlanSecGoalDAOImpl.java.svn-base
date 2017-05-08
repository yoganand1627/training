package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PlanSecGoal;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanSecGoalDAO;

import org.hibernate.Query;

public class PlanSecGoalDAOImpl extends BaseDAOImpl implements PlanSecGoalDAO {

  public void saveFosterCareSecGoals(PlanSecGoal planSecGoal) {
    getSession().saveOrUpdate(planSecGoal);
  }

  @SuppressWarnings( { "unchecked" })
  public List<PlanSecGoal> findFosterCareSecGoalsList(int idEvent) {
    Query query = getSession().createQuery("   from PlanSecGoal a" + "  where a.event = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (List<PlanSecGoal>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public PlanSecGoal findFosterCareSecGoalsOnId(int idPlanSecGoal) {
    Query query = getSession().createQuery("   from PlanSecGoal a" + "    where a.idPlanSecGoal = :idPlanSecGoal");

    query.setInteger("idPlanSecGoal", idPlanSecGoal);
    return (PlanSecGoal) firstResult(query);
  }
  
  public int deleteFosterCareSecGoals(int idPlanSecGoal) {
    Query query = getSession().createQuery(
                                           "delete from PlanSecGoal a"
                                                           + "       where a.idPlanSecGoal = :idPlanSecGoal");
    query.setInteger("idPlanSecGoal", idPlanSecGoal);
    return query.executeUpdate();
  }

}
