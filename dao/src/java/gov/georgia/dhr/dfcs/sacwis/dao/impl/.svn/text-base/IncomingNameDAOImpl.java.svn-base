package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingNameDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingName;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class IncomingNameDAOImpl extends BaseDAOImpl implements IncomingNameDAO {
  @SuppressWarnings( { "unchecked" })
  public List<IncomingName> findIncomingNameByIdIncmgPerson(int idIncmgPerson) {
    Query query = getSession().createQuery(
                                           " from IncomingName i "
                                                           + "where i.incomingPerson.idIncmgPerson = :idIncmgPerson ");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    return (List<IncomingName>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<IncomingName> findIncomingNameByIdIncmgPersonAndOrderByDtIncmgNameEnd(int idIncmgPerson) {
    Query query = getSession()
                              .createQuery(
                                           "    from IncomingName i "
                                                           + "   where i.incomingPerson.idIncmgPerson = :idIncmgPerson "
                                                           + "order by i.dtIncmgNameEnd desc , "
                                                           + "         i.indIncmgNamePrimary desc ");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    return (List<IncomingName>) query.list();
  }

  public int insertIncomingName(int idIncmgPerson, int idPerson) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO INCOMING_NAME (ID_INCOMING_NAME,"
                                                                 + "                           ID_INCMG_PERSON,"
                                                                 + "                           NM_INCMG_NAME_FIRST,"
                                                                 + "                           NM_INCMG_NAME_MIDDLE,"
                                                                 + "                           NM_INCMG_NAME_LAST,"
                                                                 + "                           IND_INCMG_NAME_INVALID,"
                                                                 + "                           IND_INCMG_NAME_PRIMARY,"
                                                                 + "                           CD_INCMG_NAME_SUFFIX,"
                                                                 + "                           DT_INCMG_NAME_START,"
                                                                 + "                           DT_INCMG_NAME_END )"
                                                                 + " SELECT 0," + "        :idIncmgPerson,"
                                                                 + "        NM_NAME_FIRST," + "        NM_NAME_MIDDLE,"
                                                                 + "        NM_NAME_LAST,"
                                                                 + "        IND_NAME_INVALID,"
                                                                 + "        IND_NAME_PRIMARY,"
                                                                 + "        CD_NAME_SUFFIX,"
                                                                 + "        DT_NAME_START_DATE,"
                                                                 + "        DT_NAME_END_DATE" + "   FROM NAME"
                                                                 + "  WHERE ID_PERSON = :idPerson");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

}
