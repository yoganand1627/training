package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

import org.hibernate.Query;

public class NeedsOutcomesDAOImpl extends BaseDAOImpl implements NeedsOutcomesDAO {

  public NeedsOutcomes findNeedsAndOutcomes(int idEvent) {
    Query query = getSession().createQuery("from NeedsOutcomes a " +
                                           " where a.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (NeedsOutcomes) firstResult(query);
  }
  
  public NeedsOutcomes findNeedsAndOutcomesLatestApprovedByIdStage(int idStage) {
    String cdStatusApproved = CodesTables.CEVTSTAT_APRV;
    Query query = getSession().createQuery(" from NeedsOutcomes no " +
                                           " where no.event.cdEventStatus = :cdStatusApproved " +
                                           " and no.event.stage.idStage = :idStage " +
                                           " order by no.event.dtLastUpdate desc ");
    
    query.setInteger("idStage", idStage );
    query.setString("cdStatusApproved", cdStatusApproved );
    
    return (NeedsOutcomes) firstResult(query);
  }
  
  public NeedsOutcomes findNeedsAndOutcomesLatestByIdStage(int idStage) {
    String cdStatusApproved = CodesTables.CEVTSTAT_APRV;
    String cdStatusComplete = CodesTables.CEVTSTAT_COMP;
    Query query = getSession().createQuery(" from NeedsOutcomes no " +
                                           " where (no.event.cdEventStatus = :cdStatusApproved " +
                                           " or no.event.cdEventStatus = :cdStatusComplete) " +
                                           " and no.event.stage.idStage = :idStage " +
                                           " order by no.event.dtLastUpdate desc ");
    
    query.setInteger("idStage", idStage );
    query.setString("cdStatusApproved", cdStatusApproved );
    query.setString("cdStatusComplete", cdStatusComplete );
    
    return (NeedsOutcomes) firstResult(query);
  }

  public void saveNeedsOutcomes(NeedsOutcomes needsOutcomes) {
    getSession().saveOrUpdate(needsOutcomes);
  }
}
