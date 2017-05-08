package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

public class LegalActionOutcomeDAOImpl extends BaseDAOImpl implements LegalActionOutcomeDAO {

  public void saveOutcome(LegalActionOutcome lao) {
    getSession().saveOrUpdate(lao);
  }
  
  public void deleteOutcome(LegalActionOutcome lao) {
    getSession().delete(lao);
  }
  
  public int deleteOutcome(int idLegalActEvent, String cdOutcome) {
    Query query = getSession().createQuery("delete from LegalActionOutcome lao "
                                           + "where lao.legalAction.idLegalActEvent = :idLegalActEvent "
                                           + "and lao.cdOutcome = :cdOutcome");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    query.setString("cdOutcome", cdOutcome);
    return query.executeUpdate();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<LegalActionOutcome> findLegalActionOutcomeList(int idLegalActEvent) {
    Query query = getSession().createQuery("from LegalActionOutcome lao "
                                           + "where lao.legalAction.idLegalActEvent = :idLegalActEvent");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    return (List<LegalActionOutcome>) query.list();
  }
  
  public LegalActionOutcome findLegalActionOutcomeForYouthReport(int idPerson, String cdOutcome) {
    Query query = getSession().createQuery(" from LegalActionOutcome lao " +
                                           "where lao.legalAction.person.idPerson = :idPerson " +
                                           "  and lao.cdOutcome = :cdOutcome");
    query.setInteger("idPerson", idPerson);
    query.setString("cdOutcome", cdOutcome);
    return (LegalActionOutcome) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<String> findCdOutcomeListByIdEvent(int idLegalActEvent) {
    Query query = getSession().createQuery("select lao.cdOutcome from LegalActionOutcome lao "
                                           + "where lao.legalAction.idLegalActEvent = :idLegalActEvent");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    return (List<String>) query.list();
  }

}
