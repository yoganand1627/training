package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingRaceDAO;
import org.hibernate.SQLQuery;

public class IncomingRaceDAOImpl extends BaseDAOImpl implements IncomingRaceDAO {
  public int insertIncomingRaceByIdPerson(int idIncmgPerson, int idPerson) {

    SQLQuery query = getSession().createSQLQuery("INSERT INTO INCOMING_RACE " +
                                                 "                   (ID_INCOMING_RACE, " +
                                                 "                    ID_PERSON, " +
                                                 "                    CD_RACE) " +
                                                 "             SELECT 0, " +
                                                 "                    :idIncmgPerson, " +
                                                 "                    CD_RACE " +
                                                 "               FROM PERSON_RACE " +
                                                 "              WHERE ID_PERSON = :idPerson ");

    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }
}
