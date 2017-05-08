package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingAddress;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class IncomingAddressDAOImpl extends BaseDAOImpl implements IncomingAddressDAO {
  @SuppressWarnings({"unchecked"})
  public List<IncomingAddress> findIncomingAddressByIdIncmgPerson(int idIncmgPerson) {
    Query query = getSession().createQuery(" from IncomingAddress ia " +
                                           "where ia.incomingPerson.idIncmgPerson = :idIncmgPerson ");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    return (List<IncomingAddress>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<IncomingAddress> findIncomingAddressByIdIncmgPersonAndOrderByDtIncmgAddrEnd(int idIncmgPerson) {
    Query query = getSession().createQuery("    from IncomingAddress i " +
                                           "   where i.incomingPerson.idIncmgPerson = :idIncmgPerson " +
                                           "order by i.dtIncmgAddrEnd desc , " +
                                           "         i.indIncmgAddrPrimary desc ");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    return (List<IncomingAddress>) query.list();
  }

  public int insertIncomingAddress(int idIncmgPerson, int idPerson) {
    SQLQuery query = getSession().createSQLQuery("  INSERT INTO INCOMING_ADDRESS (   ID_INCMG_PERSON," +
                                                 "  ID_INCOMING_ADDRESS," +
                                                 "  ADDR_INCMG_ADDR_ZIP," +
                                                 "  CD_INCMG_ADDR_STATE," +
                                                 "  ADDR_INCMG_ADDR_CITY," +
                                                 "  DT_INCMG_ADDR_START," +
                                                 "  DT_INCMG_ADDR_END," +
                                                 "  IND_INCMG_ADDR_INVALID," +
                                                 "  ADDR_INCMG_ADDR_ST_LN_1," +
                                                 "  ADDR_INCMG_ADDR_ST_LN_2," +
                                                 "  CD_INCMG_ADDR_COUNTY," +
                                                 "  TXT_INCMG_ADDR_COMMENTS," +
                                                 "  CD_INCMG_ADDR_TYPE," +
                                                 "  IND_INCMG_ADDR_PRIMARY," +
                                                 "  ADDR_INCMG_ADDR_ATTN )" +
                                                 " SELECT :idIncmgPerson," +
                                                 "        0," +
                                                 "        A.ADDR_PERSON_ADDR_ZIP," +
                                                 "        A.CD_PERSON_ADDR_STATE," +
                                                 "        A.ADDR_PERSON_ADDR_CITY," +
                                                 "        B.DT_PERS_ADDR_LINK_START," +
                                                 "        B.DT_PERS_ADDR_LINK_END," +
                                                 "        B.IND_PERS_ADDR_LINK_INVALID," +
                                                 "        A.ADDR_PERS_ADDR_ST_LN_1," +
                                                 "        A.ADDR_PERS_ADDR_ST_LN_2," +
                                                 "        A.CD_PERSON_ADDR_COUNTY," +
                                                 "        B.TXT_PERS_ADDR_CMNTS," +
                                                 "        B.CD_PERS_ADDR_LINK_TYPE," +
                                                 "        B.IND_PERS_ADDR_LINK_PRIMARY," +
                                                 "        A.ADDR_PERSON_ADDR_ATTN" +
                                                 "   FROM PERSON_ADDRESS A," +
                                                 "        ADDRESS_PERSON_LINK B" +
                                                 "  WHERE B.ID_PERSON = :idPerson" +
                                                 "    AND B.ID_PERSON_ADDR = A.ID_PERSON_ADDR");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

}
