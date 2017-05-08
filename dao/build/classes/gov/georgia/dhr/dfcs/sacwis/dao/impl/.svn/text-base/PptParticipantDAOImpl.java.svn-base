package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PptParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PptParticipant;
import org.hibernate.Query;

public class PptParticipantDAOImpl extends BaseDAOImpl implements PptParticipantDAO {
  @SuppressWarnings({"unchecked"})
  public List<PptParticipant> findPptParticipantByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
            " from   PptParticipant p" +
            " where  p.event.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);

    return (List<PptParticipant>) query.list();
  }

  public long countPptParticipant(int idPersMergeForward, int idPersMergeClosed) {

    Query query = getSession().createQuery(" select count(*)" +
                                           "   from PptParticipant ppt1," +
                                           "        PptParticipant ppt2," +
                                           "        Event e," +
                                           "        Stage s" +
                                           "  where ppt1.person.idPerson = :idPersMergeForward" +
                                           "    and ppt2.person.idPerson = :idPersMergeClosed" +
                                           "    and ppt1.event.idEvent = ppt2.event.idEvent" +
                                           "    and ppt1.event.idEvent = e.idEvent" +
                                           "    and e.stage.idStage = s.idStage" +
                                           "    and s.dtStageClose is null ");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);

    return (Long) query.uniqueResult();
  }

  public void savePptParticipant(PptParticipant pptParticipant) {
    getSession().saveOrUpdate(pptParticipant);
  }

  public int updatePptParticipant(int idEvent, int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery("update PptParticipant" +
                                           "    set person.idPerson = :idPersMergeForward" +
                                           "  where person.idPerson = :idPersMergeClosed" +
                                           "    and event.idEvent = :idEvent");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();

  }

  public void deletePptParticipant(PptParticipant pptParticipant) {
    getSession().delete(pptParticipant);
  }
}