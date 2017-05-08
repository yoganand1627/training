package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingPersonId;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class IncomingPersonIdDAOImpl extends BaseDAOImpl implements IncomingPersonIdDAO {
  @SuppressWarnings({"unchecked"})
  public List<IncomingPersonId> findIncomingPersonIdByIdIncmgPerson(int idIncmgPerson) {
    Query query = getSession().createQuery("  from IncomingPersonId i " +
                                           " where i.incomingPerson.idIncmgPerson = :idIncmgPerson ");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    return (List<IncomingPersonId>) query.list();
  }

  public int insertIncomingPersonID(int idIncmgPerson, int idPerson) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO INCOMING_PERSON_ID (   ID_INCOMING_PERSON_ID," +
                                                 "  ID_INCMG_PERSON," +
                                                 "  NBR_INCMG_PERS_ID_NUMBER," +
                                                 "  CD_INCMG_PERS_ID_TYPE," +
                                                 "  DT_INCMG_PERS_ID_START," +
                                                 "  DT_INCMG_PERSON_ID_END," +
                                                 "  IND_INCMG_PERSON_ID_INV," +
                                                 "  DESC_INCMG_PERSON_ID )" +
                                                 " SELECT 0," +
                                                 "        :idIncmgPerson," +
                                                 "        NBR_PERSON_ID_NUMBER," +
                                                 "        CD_PERSON_ID_TYPE," +
                                                 "        DT_PERSON_ID_START," +
                                                 "        DT_PERSON_ID_END," +
                                                 "        IND_PERSON_ID_INVALID," +
                                                 "        DESC_PERSON_ID" +
                                                 "   FROM PERSON_ID" +
                                                 "  WHERE ID_PERSON = :idPerson");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

}
