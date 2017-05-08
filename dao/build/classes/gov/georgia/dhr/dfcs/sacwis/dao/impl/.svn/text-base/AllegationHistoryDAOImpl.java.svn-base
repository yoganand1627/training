package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.AllegationHistoryDAO;

import org.hibernate.Query;

public class AllegationHistoryDAOImpl extends BaseDAOImpl implements AllegationHistoryDAO {
  @SuppressWarnings({"unchecked"})
  public List<Integer> findAllegationHistoryIdAllegedPerpetrator(int idStage) {
    Query query = getSession().createQuery("select distinct ap.personByIdAllegedPerpetrator.idPerson " +
                                           "  from AllegationHistory ap " +
                                           " where ap.allegation.idAllegation in " +
                                           "       (select distinct a.idAllegation " +
                                           "          from Allegation a " +
                                           "         where a.stage.idStage = :idStage)");
    query.setInteger("idStage", idStage);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<String> findAllegationHistoryNmPersonFull(int idStage) {
    Query query = getSession().createQuery("select distinct b.nmPersonFull " +
                                           "  from AllegationHistory a, " +
                                           "       Person b " +
                                           " where a.stage.idStage = :idStage " +
                                           "   and b.idPerson = a.personByIdVictim.idPerson");
    query.setInteger("idStage", idStage);
    return (List<String>) query.list();
  }

}
