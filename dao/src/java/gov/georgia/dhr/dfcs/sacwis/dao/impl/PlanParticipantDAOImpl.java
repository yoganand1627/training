package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.PlanParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant;

import java.util.List;

import org.hibernate.Query;

public class PlanParticipantDAOImpl extends BaseDAOImpl implements PlanParticipantDAO {
  @SuppressWarnings({"unchecked"})
  public List<PlanParticipant> findPlanParticipantByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
            " from   PlanParticipant p" +
            " where  p.event.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);

    return (List<PlanParticipant>) query.list();
  }

  public void savePlanParticipant(PlanParticipant planParticipant) {
    getSession().saveOrUpdate(planParticipant);
  }

  public int updatePlanParticipant(int idEvent, int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery("update PlanParticipant" +
                                           "    set person.idPerson = :idPersMergeForward" +
                                           "  where person.idPerson = :idPersMergeClosed" +
                                           "    and event.idEvent = :idEvent");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();

  }

  public int deletePlanParticipant(int idPlanPart) {
    Query query = getSession().createQuery(
                                           "delete from PlanParticipant a"
                                                           + "       where a.idPlanParticipant = :idPlanPart");
    query.setInteger("idPlanPart", idPlanPart);
    return query.executeUpdate();
  }
 /* public void deletePlanParticipant(PlanParticipant planParticipant) {
    getSession().delete(planParticipant);
  }*/
}