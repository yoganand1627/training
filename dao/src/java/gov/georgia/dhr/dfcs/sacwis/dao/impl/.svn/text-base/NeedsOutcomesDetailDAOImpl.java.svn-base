package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomesDetail;

import java.util.List;

import org.hibernate.Query;

public class NeedsOutcomesDetailDAOImpl extends BaseDAOImpl implements NeedsOutcomesDetailDAO {

  @SuppressWarnings({"unchecked"})
  public List<NeedsOutcomesDetail> findNeedsAndOutcomesDetailList(int idEvent) {
    Query query = getSession().createQuery("   from NeedsOutcomesDetail a" +
                                           "  where a.needsOutcomes = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (List<NeedsOutcomesDetail>) query.list();
  }

  public void saveNeedsOutcomesDetail(NeedsOutcomesDetail needsOutcomesDetail) {
    getSession().saveOrUpdate(needsOutcomesDetail);
  }

  public NeedsOutcomesDetail findNeedsAndOutcomesDetail(int idNeeds) {
    Query query = getSession().createQuery("from NeedsOutcomesDetail a " +
                                           " where a.idNeedsOutcomesDetail = :idNeeds");
    query.setInteger("idNeeds", idNeeds);
    return (NeedsOutcomesDetail) firstResult(query);
  }

  public int deleteNeedsAndOutcomesDetail(int idNeeds) {
    Query query = getSession().createQuery("delete from NeedsOutcomesDetail a " +
                                           "      where a.idNeedsOutcomesDetail = :idNeeds");
    query.setInteger("idNeeds", idNeeds);
    return query.executeUpdate();
  }
}