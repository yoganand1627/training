package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.TempStagePersLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.TempStagePersLink;
import org.hibernate.Query;

public class TempStagePersLinkDAOImpl extends BaseDAOImpl implements TempStagePersLinkDAO {
  public TempStagePersLink findTempStagePersLinkByIdStageAndCdTempStagePersRole(int idStage,
                                                                                String cdTempStagePersRole) {
    Query query = getSession().createQuery(" from TempStagePersLink " +
                                           "where idTempStage = :idStage " +
                                           "  and cdTempStagePersRole = :cdTempStagePersRole");
    query.setInteger("idStage", idStage);
    query.setString("cdTempStagePersRole", cdTempStagePersRole);
    return (TempStagePersLink) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<TempStagePersLink> findTempStagePersLinkByIdTempStagePerson(int idTempStagePerson,
                                                                                            int pageNbr,
                                                                                            int pageSize) {
    Query query = getSession().createQuery(" from TempStagePersLink t " +
                                           "where t.person.idPerson = :idTempStagePerson ");
    query.setInteger("idTempStagePerson", idTempStagePerson);
    return (PaginatedHibernateList<TempStagePersLink>) paginatedList(pageNbr, pageSize, query);
  }

  public void saveTempStagePersLink(TempStagePersLink tempStagePersLink) {
    getSession().saveOrUpdate(tempStagePersLink);
  }

  public void deleteTempStagePersLink(TempStagePersLink tempStagePersLink) {
    getSession().delete(tempStagePersLink);
  }
}