package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import gov.georgia.dhr.dfcs.sacwis.dao.DynamicPlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;

public class DynamicPlanGoalDAOImpl extends DynamicBaseDAOImpl implements DynamicPlanGoalDAO {
  @SuppressWarnings({"unchecked"})
  public List<PlanGoal> findFCGSByIdEventsByCdGoalTypes(Map<Integer, String> eventGoal) {
    //if(allNullArgs(eventGoal)) {
    //  throw new ServiceException(Messages.SQL_NOT_FOUND);
    //}
    Criteria criteria = getSession().createCriteria(PlanGoal.class, "pg");
    
    Disjunction whereClause = Restrictions.disjunction();
    Set<Integer> idEventSet = eventGoal.keySet();
    for(Integer idEvent : idEventSet) {
      whereClause.add(Restrictions.and(Restrictions.eq("pg.event.idEvent", idEvent), Restrictions.eq("pg.cdGoalTyp", eventGoal.get(idEvent))));
    }
    criteria.add(whereClause);
    criteria.addOrder(Order.desc("pg.cdGoalTyp"));
    criteria.addOrder(Order.desc("pg.dtLastUpdate"));
    return (List<PlanGoal>) criteria.list();
  }

}



