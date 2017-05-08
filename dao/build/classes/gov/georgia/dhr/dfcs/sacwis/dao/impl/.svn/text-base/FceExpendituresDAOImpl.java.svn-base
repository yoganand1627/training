package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;

public class FceExpendituresDAOImpl extends BaseDAOImpl implements FceExpendituresDAO {

  public int updateFceExpendituresIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage) {

    Query query = getSession().createQuery(" update FceExpenditures" +
                                           " set person.idPerson = :idPersMergeForward" +
                                           " where person.idPerson = :idPersMergeClosed" +
                                           " and fceEligibility.idFceEligibility in (select idFceEligibility" +
                                           "                                         from FceEligibility" +
                                           "                                         where stage.idStage = :idStage)");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public void saveFceExpenditures(FceExpenditures fceExpenditures) {
    getSession().saveOrUpdate(fceExpenditures);
  }

  public FceExpenditures findFceExpendituresByIdFceExpenditures(long idFceExpenditures) {
    Query query = getSession().createQuery(" from FceExpenditures fe " +
                                           "where fe.idFceExpenditures = :idFceExpenditures");

    query.setLong("idFceExpenditures", idFceExpenditures);
    return (FceExpenditures) query.uniqueResult();
  }

  public FceExpenditures findFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                      long idFcePerson,
                                                                                      long idPerson){
    Query query = getSession().createQuery("  from FceExpenditures fe" +
                                           "  where fe.idFceExpenditures = :idFceExpenditures" +
                                           "  and fe.fcePerson.idFcePerson = :idFcePerson" +
                                           "  and fe.person.idPerson = :idPerson");

    query.setLong("idFceExpenditures", idFceExpenditures);
    query.setLong("idFcePerson", idFcePerson);
    query.setLong("idPerson", idPerson);
    return (FceExpenditures) query.uniqueResult();
  }
  
  public void deleteFceExpenditures(long idFceEligibility){
    Query query = getSession().createQuery(" delete from FceExpenditures fe" +
                                           " where fe.fceEligibility.idFceEligibility = :idFceEligibility");
    query.setLong("idFceEligibility", idFceEligibility);
    query.executeUpdate();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<FceExpenditures>  findAllFceExpenditures(long idFceEligibility){
    Query query = getSession().createQuery("  from FceExpenditures fe" +
                                           "  where fe.fceEligibility.idFceEligibility = :idFceEligibility");
    query.setLong("idFceEligibility", idFceEligibility);
    return (List<FceExpenditures>) query.list();
  }
}
