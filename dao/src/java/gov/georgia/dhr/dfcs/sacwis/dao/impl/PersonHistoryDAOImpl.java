package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonHistory;
import org.hibernate.Query;

public class PersonHistoryDAOImpl extends BaseDAOImpl implements PersonHistoryDAO {
  public String findPersonHistoryByIdPersonforPersonwithOldestHistEffect(int idPerson) {
    Query query = getSession().createQuery("select nmPersHistFull" +
                                           "   from PersonHistory" +
                                           "  where person.idPerson = :idPerson" +
                                           "    and dtPersHistEffect = (select min(dtPersHistEffect)" +
                                           "                              from PersonHistory" +
                                           "                             where person.idPerson = :idPerson)");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  public String findPersonHistoryByIdPerson(int idPerson, Date dtPlcmtStart) {
    Query query = getSession().createQuery("select nmPersHistFull" +
                                           "   from PersonHistory" +
                                           "  where person.idPerson = :idPerson" +
                                           "    and dtPersHistEffect <= :dtPlcmtStart" +
                                           "    and dtPersHistEnd > :dtPlcmtStart");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    return (String) firstResult(query);
  }

  public PersonHistory findPersonHistoryByIdPersonAndLastUpdate(int idPerson,
                                                                Date lastUpdate) {
    Query query = getSession().createQuery(" from   PersonHistory" +
                                           " where  person.idPerson = :idPerson" +
                                           " and dtPersHistEffect < :lastUpdate" +
                                           " and dtPersHistEnd >= :lastUpdate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("lastUpdate", lastUpdate);
    return (PersonHistory) firstResult(query);
  }
}
