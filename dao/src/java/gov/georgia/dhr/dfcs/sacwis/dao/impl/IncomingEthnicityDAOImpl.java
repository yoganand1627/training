package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingEthnicityDAO;
import org.hibernate.SQLQuery;

public class IncomingEthnicityDAOImpl extends BaseDAOImpl implements IncomingEthnicityDAO {
  public int insertIncomingEthnicityByIdPerson(int idIncmgPerson, int idPerson) {

    SQLQuery query = getSession().createSQLQuery("INSERT INTO INCOMING_ETHNICITY " +
                                                 "                   (ID_INCOMING_ETHNICITY, " +
                                                 "                    ID_PERSON, " +
                                                 "                    CD_ETHNICITY) " +
                                                 "             SELECT 0, " +
                                                 "                    :idIncmgPerson, " +
                                                 "                    CD_ETHNICITY " +
                                                 "               FROM PERSON_ETHNICITY " +
                                                 "              WHERE ID_PERSON = :idPerson ");

    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }
}
