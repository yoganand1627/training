package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ChildPlanParticipDAO;
import org.hibernate.Query;

public class ChildPlanParticipDAOImpl extends BaseDAOImpl implements ChildPlanParticipDAO {
  public long countChildPlanParticipEvents(int idPersMergeForward, int idPersMergeClosed) {

    Query query = getSession().createQuery(" select count(*)" +
                                           "   from ChildPlanParticip cp1," +
                                           "        ChildPlanParticip cp2," +
                                           "        Event e," +
                                           "        Stage s" +
                                           "  where cp1.person.idPerson = :idPersMergeForward" +
                                           "    and cp2.person.idPerson = :idPersMergeClosed" +
                                           "    and cp1.event.idEvent = cp2.event.idEvent" +
                                           "    and cp1.event.idEvent = e.idEvent" +
                                           "    and e.stage.idStage = s.idStage" +
                                           "    and s.dtStageClose is null ");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);

    return (Long) query.uniqueResult();
  }

  public int updateChildPlanParticipIdPerson(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    Query query = getSession().createQuery(" update ChildPlanParticip" +
                                           "    set person.idPerson = :idPersMergeForward" +
                                           "  where person.idPerson = :idPersMergeClosed" +
                                           "    and event.idEvent = :idEvent");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
}
