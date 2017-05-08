package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.DiversionConclusionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DiversionConclusion;

public class DiversionConclusionDAOImpl extends BaseDAOImpl implements DiversionConclusionDAO {

  public DiversionConclusion findDiversionConclusionByIdStage(int idStage) {
    Query query = getSession().createQuery(" from DiversionConclusion" 
                                          +" where stageByIdStage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (DiversionConclusion) firstResult(query);
  }

  public DiversionConclusion findDiversionConclusionByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from DiversionConclusion" 
                                           +" where event.idEvent = :idEvent");
     query.setInteger("idEvent", idEvent);
     return (DiversionConclusion) firstResult(query);
  }

  public void saveDiversionConclusion(DiversionConclusion diversionConclusion) {
    getSession().saveOrUpdate(diversionConclusion);
  }
}
