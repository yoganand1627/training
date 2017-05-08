package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingPhone;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class IncomingPhoneDAOImpl extends BaseDAOImpl implements IncomingPhoneDAO {
  @SuppressWarnings({"unchecked"})
  public List<IncomingPhone> findIncomingPhoneByIdIncmgPersonAndOrderByDtIncmgPhoneEnd(int idIncmgPerson) {
    Query query = getSession().createQuery("     from IncomingPhone ip  " +
                                           "    where ip.incomingPerson.idIncmgPerson = :idIncmgPerson " +
                                           " order by ip.dtIncmgPhoneEnd desc , " +
                                           "          ip.indIncmgPhonePrimary desc ");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    return (List<IncomingPhone>) query.list();
  }

  public int insertIncomingPhone(int idIncmgPerson, int idPerson) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO INCOMING_PHONE (   ID_INCOMING_PHONE," +
                                                 "  ID_INCMG_PERSON," +
                                                 "  TXT_INCMG_PHONE_COMMENTS," +
                                                 "  NBR_INCMG_PHONE_EXTENSION," +
                                                 "  NBR_INCMG_PHONE," +
                                                 "  DT_INCMG_PHONE_START," +
                                                 "  DT_INCMG_PHONE_END," +
                                                 "  IND_INCMG_PHONE_INVALID," +
                                                 "  IND_INCMG_PHONE_PRIMARY," +
                                                 "  CD_INCMG_PHONE_TYPE )" +
                                                 " SELECT 0," +
                                                 "        :idIncmgPerson," +
                                                 "        TXT_PERSON_PHONE_COMMENTS," +
                                                 "        NBR_PERSON_PHONE_EXTENSION," +
                                                 "        NBR_PERSON_PHONE," +
                                                 "        DT_PERSON_PHONE_START," +
                                                 "        DT_PERSON_PHONE_END," +
                                                 "        IND_PERSON_PHONE_INVALID," +
                                                 "        IND_PERSON_PHONE_PRIMARY," +
                                                 "        CD_PERSON_PHONE_TYPE" +
                                                 "   FROM PERSON_PHONE" +
                                                 "  WHERE ID_PERSON = :idPerson");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

}
