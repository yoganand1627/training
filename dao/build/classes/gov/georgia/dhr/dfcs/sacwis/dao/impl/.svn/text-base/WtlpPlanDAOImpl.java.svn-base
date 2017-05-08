package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;

import org.hibernate.Query;

public class WtlpPlanDAOImpl extends BaseDAOImpl implements WtlpPlanDAO {
  public WtlpPlan findWtlp(int idWtlpEvent) {
    Query query = getSession().createQuery(" from WtlpPlan w " +
                                           "where w.idEvent = :idEvent ");

    query.setInteger("idEvent", idWtlpEvent);
    return (WtlpPlan) firstResult(query);
  }

  public WtlpPlan findWtlpPlanLatestApprovedByIdStageByIdPerson(int idStage, int idPerson) {
    Query query = getSession().createQuery("    from WtlpPlan wp " +
                                           "   where wp.event.stage.idStage = :idStage " +
                                           "     and wp.person.idPerson = :idPerson " +
                                           "     and wp.event.cdEventStatus = 'APRV' " +
                                           "order by wp.dtLastUpdate desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (WtlpPlan) firstResult(query);
  }
  
  public WtlpPlan findWtlpPlanLatestApprovedByIdCaseByIdPerson(int idCase, int idPerson) {
    Query query = getSession().createQuery("    from WtlpPlan wp " +
                                           "   where wp.event.capsCase.idCase = :idCase " +
                                           "     and wp.person.idPerson = :idPerson " +
                                           "     and wp.event.cdEventStatus = 'APRV' " +
                                           "order by wp.dtLastUpdate desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (WtlpPlan) firstResult(query);
  }
  
  //STGAP00004470: Added this method to populate the WTLP Form
  public WtlpPlan findWtlpPlanLatestByIdStageByIdPerson(int idEvent) {
    Query query = getSession().createQuery("    from WtlpPlan wp " +
                                           "   where wp.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (WtlpPlan) query.uniqueResult();
  }

  public void saveWtlp(WtlpPlan wtlp) {
    getSession().saveOrUpdate(wtlp);
  }
}
