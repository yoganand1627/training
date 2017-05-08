package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsAdoptionHistoryDAO;

import org.hibernate.Query;

public class AfcarsAdoptionHistoryDAOImpl extends BaseDAOImpl implements AfcarsAdoptionHistoryDAO {
  public Integer findAfcarsAdoptionHistoryIdPersonByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select personId from AfcarsAdoptionHistory " +
    		"where personId = :idPerson " +
    		"and dtAfcarsSubmitted is not null");
    query.setInteger("idPerson", idPerson);
    Object firstResult = firstResult(query);
    if (firstResult == null)
      return 0;
    return (Integer) firstResult;
  }
  
  public Integer findAfcarsAdoptionHistoryIdPersonByIdStage(int idStage) {
    Query query = getSession().createQuery("select a.personId from AfcarsAdoptionHistory a, StagePersonLink s " +
                "where a.personId = s.person.idPerson " +
                "and a.dtAfcarsSubmitted is not null " +
                "and s.cdStagePersRole = 'PC' " +
                "and s.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    Object firstResult = firstResult(query);
    if (firstResult == null)
      return 0;
    return (Integer) firstResult;
  }

}
