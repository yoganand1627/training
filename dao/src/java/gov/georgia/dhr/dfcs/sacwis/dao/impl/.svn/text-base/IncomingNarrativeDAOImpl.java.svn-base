package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingNarrativeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingNarrative;
import org.hibernate.Query;

public class IncomingNarrativeDAOImpl extends BaseDAOImpl implements IncomingNarrativeDAO {
  public long countIncomingNarrativesByIdStage(int idStage) {
    Query query = getSession().createQuery("select count(i.idStage) " +
                                           "  from IncomingNarrative i " +
                                           " where i.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (Long) firstResult(query);
  }

  public IncomingNarrative findIncomingNarrativeByIdStage(int idStage) {
    Query query = getSession().createQuery(" from IncomingNarrative i " +
                                           "where i.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (IncomingNarrative) firstResult(query);
  }
}
