package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.dao.StageRepLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.StageRepLink;

public class StageRepLinkDAOImpl  extends BaseDAOImpl  implements StageRepLinkDAO {

  
  public StageRepLink findStageRepLinkByIdPersonIdStage(int idPerson, int idStage) {
    Session session = getSession();
    Query query = session.createQuery("from StageRepLink srp " 
                                      + " where srp.person.idPerson = :idPerson"
                                      + " and srp.stage.idStage = :idStage");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (StageRepLink) firstResult(query);
  }
  
  public void saveStageRepLink(StageRepLink stageRepLink) {
    getSession().saveOrUpdate(stageRepLink);
  }
  
  public void deleteStageRepLink(StageRepLink stageRepLink){
    getSession().delete(stageRepLink);
  }
}
