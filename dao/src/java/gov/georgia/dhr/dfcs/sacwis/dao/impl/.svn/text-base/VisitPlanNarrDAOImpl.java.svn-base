package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.VisitPlanNarrDAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

public class VisitPlanNarrDAOImpl extends BaseDAOImpl implements VisitPlanNarrDAO {

  @SuppressWarnings({"unchecked"})
  public List<byte[]> findCurrentVisitationPlansForEvent(List<Integer> idEvents) {
    SQLQuery query = getSession().createSQLQuery(" SELECT NARRATIVE" +
                                                 " FROM VISIT_PLAN_NARR" +
                                                 " WHERE ID_EVENT in (" + 
                                                 " SELECT ID_EVENT " +
                                                 " FROM OUTPUT_LAUNCH_EVENT_LINK" +
                                                 " WHERE ID_EVENT in (:idEvent) AND" +
                                                 " IND_CURRENT = 'Y')"
                                                  );
    query.setParameterList("idEvent", idEvents, Hibernate.INTEGER);
    query.addScalar("NARRATIVE", Hibernate.BINARY);
    return (List<byte[]>) query.list();
  }
}
